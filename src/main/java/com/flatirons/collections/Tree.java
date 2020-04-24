/**
 * 
 */
package com.flatirons.collections;

import java.util.List;

/**
 * @author developer
 *
 */
public interface Tree<T> {

    /**
     * Insert node as a child of parent. If parent is null, the child becomes the root node of the tree.
     * 
     * @param parent The parent node
     * @param child The child node
     * @throws TreeException if parent does not exist in the tree, or if two root nodes are inserted.
     */
    void insert(T parent, T node) throws TreeException;

    /**
     * 
     * @param parent The parent node
     * @return The list of children for the parent.
     * @throws TreeException if parent does not exist in the tree
     */
    List<T> getChildren(T parent) throws TreeException;

    /**
     * 
     * @param child The child node
     * @return The parent node or null if child is the root node.
     * @throws TreeException if child does not exist in the tree
     */
    T getParent(T child) throws TreeException;

}
