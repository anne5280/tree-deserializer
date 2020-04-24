/**
 * 
 */
package com.flatirons.techtest;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.flatirons.collections.Tree;
import com.flatirons.collections.TreeException;

/**
 * @author developer
 *
 */
public class TestTreeDeserializer {

    private static final String TEST_FILE = "serialized-tree.csv";

    @Test
    public void testTreeDeserializer() throws TreeException, IOException {
        
        TreeDeserializer td = new TreeDeserializer(TEST_FILE);
        Tree<String> tree = td.deserialize();
        
        Assert.assertEquals(null, tree.getParent("A"));
        Assert.assertEquals("A", tree.getParent("B"));
        Assert.assertEquals("B", tree.getParent("C"));
        Assert.assertEquals("C", tree.getParent("D"));
        Assert.assertEquals("C", tree.getParent("E"));
        Assert.assertEquals("B", tree.getParent("F"));
        Assert.assertEquals("F", tree.getParent("G"));
        Assert.assertEquals("G", tree.getParent("H"));
        Assert.assertEquals("G", tree.getParent("I"));
        Assert.assertEquals("F", tree.getParent("J"));
        Assert.assertEquals("F", tree.getParent("K"));
        Assert.assertEquals("K", tree.getParent("L"));
        Assert.assertEquals("K", tree.getParent("M"));
        Assert.assertEquals("K", tree.getParent("N"));
        Assert.assertEquals("A", tree.getParent("O"));
        Assert.assertEquals("A", tree.getParent("P"));
        Assert.assertEquals("P", tree.getParent("Q"));
        Assert.assertEquals("Q", tree.getParent("R"));
        Assert.assertEquals("R", tree.getParent("S"));
        Assert.assertEquals("P", tree.getParent("T"));
        Assert.assertEquals("P", tree.getParent("U"));
        Assert.assertEquals("U", tree.getParent("V"));
        Assert.assertEquals("U", tree.getParent("W"));
        Assert.assertEquals("W", tree.getParent("X"));
        Assert.assertEquals("W", tree.getParent("Y"));
        Assert.assertEquals("P", tree.getParent("Z"));
    }
}
