package com.github.munozy.partition.list.factory;

import com.github.munozy.partition.list.PartitionList;
import com.github.munozy.partition.list.impl.PartitionListImpl;

/**
 * This singleton factory is dedicated to creation of {@link PartitionList} objects.
 * 
 * @author Yupanqui MUNOZ
 *
 */
public class PartitionListFactory {

	private static PartitionListFactory instance;
	
	private PartitionListFactory() {
		// avoid instantiation
	}
	
	/**
	 * Return the <b>PartitionListFactory</b>.
	 * 
	 * @return the <b>PartitionListFactory</b> instance
	 */
	public static PartitionListFactory getInstance() {
		if (instance == null) {
			instance = new PartitionListFactory();
		}
		
		return instance;
	}
	
	/**
	 * Create default PartitionList object.
	 *  
	 * @return the <b>PartitionList</b>
	 */
	public <T> PartitionList<T> createPartitionList() {
		return createPartitionList("default");
	}
	
	/**
	 * Create PartitionList object. 
	 * 
	 * @param <T> the element type of the list
	 * @param partitionListType the PartitionList type. Use <code>default</code> value for using default implementation
	 * @return the <b>PartitionList</b>
	 */
	public <T> PartitionList<T> createPartitionList(String partitionListType) {
		if (partitionListType == null) {
			throw new IllegalArgumentException("The value of partitionListType is not exist. Use \"default\" value for using the default implementation");
		}
		
		if (partitionListType.matches("default")) {
			return new PartitionListImpl<T>();
		} else {
			throw new IllegalArgumentException("The value of partitionListType is not exist. Use \"default\" value for using the default implementation");
		}
	}
}
