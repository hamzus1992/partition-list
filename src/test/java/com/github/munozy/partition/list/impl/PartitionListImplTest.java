package com.github.munozy.partition.list.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.munozy.partition.list.PartitionList;
import com.github.munozy.partition.list.impl.PartitionListImpl;

/**
 * Test of  {@link PartitionListImpl} class.
 *
 * @author Yupanqui MUNOZ
 *
 */
public class PartitionListImplTest {
	
	private PartitionList<Integer> partionIntergerList;
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Before
	public void setup() {
		partionIntergerList = new PartitionListImpl<>();
	}
	
	/**
	 * If list is empty than IllegalArgumentException should be thrown.
	 */
	@Test
	public void shouldThrowIllegalArgumentExceptionWheListIsEmpty() {
		List<Integer> list = new ArrayList<>();
		
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("List must not be empty");
		
		partionIntergerList.partition(list, 1);
	}

	/**
	 * If list is null than IllegalArgumentException should be thrown.
	 */
	@Test
	public void shouldThrowIllegalArgumentExceptionWheListIsNull() {
		List<Integer> list = null;
		
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("List must not be NULL");
		
		partionIntergerList.partition(list, 1);
	}
	
	/**
	 * If <code>partitionMaxSize = 0</code> than IllegalArgumentException should be thrown.
	 */
	@Test
	public void shouldThrowIllegalArgumentExceptionWhenPartitionMaxSizeIsEqualToZero() {
		List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4));
		
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("PartitionMaxSize must be greater than Zero");
		
		partionIntergerList.partition(list, 0);
	}
	
	/**
	 * If <code>partitionMaxSize < 0</code> than IllegalArgumentException should be thrown.
	 */
	@Test
	public void shouldThrowIllegalArgumentExceptionWhenPartitionMaxSizeIsLessThanZero() {
		List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4));
		
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("PartitionMaxSize must be greater than Zero");
		
		partionIntergerList.partition(list, -2);
	}
	
	/**
	 * If <code>partitionMaxSize + lis.size >= Integer.MAX_VALUE</code> than IllegalArgumentException should be thrown.
	 */
	@Test
	public void shouldThrowIllegalArgumentExceptionWhenPartitionMaxSizePlusListSizeIsGreaterThanOrEqualToIntegerMAX_VALUE() {
		List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4));
		
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("PartitionMaxSize plus list size must be less than " + Integer.MAX_VALUE);
		
		partionIntergerList.partition(list, Integer.MAX_VALUE - list.size());
	}
	
	/**
	 * Partition should be successful when list size is divisible by partitionMaxSize.
	 */
	@Test
	public void partitionShouldBeSuccessfulWhenListSIzeIsDivisibleByPartitionMaxSize() {
		List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4));
		int partitionMaxSize = 2;
		List<List<Integer>> partitions = partionIntergerList.partition(list, partitionMaxSize);
		
		Iterator<List<Integer>> partitionsIterator = partitions.iterator();
		
		Assert.assertEquals(2, partitions.size());
		
		Assert.assertTrue(partitionsIterator.hasNext());
		List<Integer> partion = partitionsIterator.next();
		Assert.assertEquals(new ArrayList<>(Arrays.asList(1,2)), partion);
		
		Assert.assertTrue(partitionsIterator.hasNext());
		partion = partitionsIterator.next();
		Assert.assertEquals(new ArrayList<>(Arrays.asList(3,4)), partion);	
	}
 
	/**
	 * Partition should be successful when list size is not divisible by partitionMaxSize.
	 */
	@Test
	public void partitionShouldBeSuccessfulWhenListSIzeIsNotDivisibleByPartitionMaxSize() {
		List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
		int partitionMaxSize = 2;
		List<List<Integer>> partitions = partionIntergerList.partition(list, partitionMaxSize);
		
		Iterator<List<Integer>> partitionsIterator = partitions.iterator();
		
		Assert.assertEquals(3, partitions.size());
		
		Assert.assertTrue(partitionsIterator.hasNext());
		List<Integer> partion = partitionsIterator.next();
		Assert.assertEquals(new ArrayList<>(Arrays.asList(1,2)), partion);
		
		Assert.assertTrue(partitionsIterator.hasNext());
		partion = partitionsIterator.next();
		Assert.assertEquals(new ArrayList<>(Arrays.asList(3,4)), partion);	
		
		Assert.assertTrue(partitionsIterator.hasNext());
		partion = partitionsIterator.next();
		Assert.assertEquals(new ArrayList<>(Arrays.asList(5)), partion);	
	}
	
	/**
	 * Partition should be successful when partitionMaxSize is greater list size.
	 */
	@Test
	public void partitionShouldBeSuccessfulWhenPartitionMaxSizeIsGreaterThanListSize() {
		List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
		int partitionMaxSize = list.size() + 1;
		List<List<Integer>> partitions = partionIntergerList.partition(list, partitionMaxSize);
		
		Iterator<List<Integer>> partitionsIterator = partitions.iterator();
		
		Assert.assertEquals(1, partitions.size());
		
		Assert.assertTrue(partitionsIterator.hasNext());
		List<Integer> partion = partitionsIterator.next();
		Assert.assertEquals(new ArrayList<>(Arrays.asList(1,2,3,4,5)), partion);
	}
}
