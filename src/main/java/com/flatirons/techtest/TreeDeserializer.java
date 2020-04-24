/**
 * 
 */
package com.flatirons.techtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.flatirons.collections.SimpleTree;
import com.flatirons.collections.Tree;
import com.flatirons.collections.TreeException;

/**
 * @author Flatirons Solutions
 * @param <T>
 *
 */
public class TreeDeserializer<T> {
    
    private final String file;
    private final Tree<String> tree;
    
    // key = level, value = node ; use natural ordering to retrieve parent
    private final TreeMap<String,String> parents;
    
    final static String ROOTID = "1";

    public TreeDeserializer(String file) {
        this.file = file;
        this.tree = new SimpleTree<>();
        this.parents = new TreeMap<>();
    }

    /**
     * 
     * @return 
     * @throws TreeException
     * @throws IOException
     */
    public Tree<String> deserialize() throws TreeException, IOException {
        try (
                InputStream in = TreeDeserializer.class.getClassLoader().getResourceAsStream(this.file);
                BufferedReader r = new BufferedReader(new InputStreamReader(in));
                ) {
            String line;
            
            while ((line = r.readLine()) != null) {
            	
            	String[] nl = line.split(",");				// level indexed at 1, node indexed at 0
            	parents.put(nl[1], nl[0]);     				// map a node it's own level.
        		
        		try {
	            	if ( nl[1].equals(ROOTID) ) {
	            		
	            		tree.insert(null, nl[0]);			// root node uses null parent
	            	} else {
	            		
            			// retrieve the parent node to insert the current node
            			tree.insert(parents.lowerEntry(nl[1]).getValue(), nl[0]);            			
	            	}
        		} catch (TreeException ex) {
        			throw ex;
        		}
            }
        }
        return tree;
    }
    
}
