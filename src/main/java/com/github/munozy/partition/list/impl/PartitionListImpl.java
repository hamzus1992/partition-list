package com.github.munozy.partition.list.impl;

import java.util.ArrayList;
import java.util.List;

import com.github.munozy.partition.list.PartitionList;

/**
 * This class implements {@link PartitionList}.
 *
 * @author Yupanqui MUNOZ
 *  
 * @param <T> <T> the type of elements in this list
 */
public class PartitionListImpl<T> implements PartitionList<T> {

	/**
	 * @see com.github.munozy.partition.list.PartitionList#partion(java.util.List, int)
	 *
	 * @param list
	 * @param partitionMaxSize
	 * @return
	 */
	@Override
	public List<List<T>> partition(List<T>  list, int partitionMaxSize) {
		if (list == null) {
			throw new IllegalArgumentException("List must not be NULL");
		}
		
		if (list.isEmpty()) {
			throw new IllegalArgumentException("List must not be empty");
		}
			
		if (partitionMaxSize <= 0){
			throw new IllegalArgumentException("PartitionMaxSize must be greater than Zero");
		}
		
		// avoid overflow
		if (partitionMaxSize + list.size() >= Integer.MAX_VALUE){
			throw new IllegalArgumentException("PartitionMaxSize plus list size must be less than " + Integer.MAX_VALUE);
		}
		
		List<List<T>> listOfPartion = new ArrayList<>();
		for (int i = 0; i < list.size(); i += partitionMaxSize) {
			// Math.min() is used for the case when the number of last elements of list was less then partitionMaxSize
			listOfPartion.add(list.subList(i, Math.min(i + partitionMaxSize, list.size())));
		}
		return listOfPartion;
	}

}
