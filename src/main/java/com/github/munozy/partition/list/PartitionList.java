package com.github.munozy.partition.list;

import java.util.List;

/**
 * This interface offers to user the function for partitioning a list into a list of sublists. 
 * 
 * @author Yupanqui MUNOZ 
 *
 * @param <T> the type of elements in this list
 */
public interface PartitionList<T> {
	
	/**
	 * Return a list of sublists.
	 * 
	 * @param list the list of elements
	 * @param partitionMaxSize the maximum size of partition of a sublist
	 *   
	 * @return the list of sublists
	 */
	List<List<T>> partition(List<T> list, int partitionMaxSize);

}
