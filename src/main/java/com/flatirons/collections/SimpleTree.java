/**
 * 
 */
package com.flatirons.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple tree implementation.
 * 
 * @author Flatirons Solutions
 *
 */
public class SimpleTree<T> implements Tree<T> {

    private final Map<T,List<T>> tree;
    private final Map<T,T> childrenToParents;

    /**
     * Constructor
     */
    public SimpleTree() {
        this.tree = new HashMap<>();
        this.childrenToParents = new HashMap<>();
    }

    /**
     * 
     */
    public void insert(T parent, T node) throws TreeException {

        if (parent == null) {
            if (!tree.isEmpty()) {
                throw new TreeException("Root node already exists.");
            }
            tree.put(node, new ArrayList<>());
            childrenToParents.put(node, null);
        }
        else if (tree.containsKey(parent)) {
            List<T> children = tree.get(parent);
            children.add(node);
            tree.put(node, new ArrayList<>());
            childrenToParents.put(node, parent);
        }
        else {
            throw new TreeException(String.format("Parent %s does not exist", parent.toString()));
        }
    }

    /**
     * 
     */
    public List<T> getChildren(T parent) throws TreeException {
        List<T> children = null;
        if (tree.containsKey(parent)) {
            children = tree.get(parent);
        }
        else {
            throw new TreeException(String.format("Parent %s does not exist", parent.toString()));
        }
        return children;
    }

    /**
     * 
     */
    public T getParent(T child) throws TreeException {
        T parent = null;
        if (childrenToParents.containsKey(child)) {
            parent = childrenToParents.get(child);
        }
        else {
            throw new TreeException(String.format("Child %s does not exist", child.toString()));
        }
        return parent;
    }
}
