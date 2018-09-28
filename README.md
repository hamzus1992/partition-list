# partition-list
A java library for partitioning a list into a list of sublists.

## Status

[![License](http://img.shields.io/badge/license-APACHE2-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.munozy/partition-list/badge.svg?style=plastic)](https://maven-badges.herokuapp.com/maven-central/com.github.munozy/partition-list)

## How to install

By setting a build-automation tool [see](https://search.maven.org/artifact/com.github.munozy/partition-list/).

Or by building locally the project
```
mvn package
```
And the take generated jar file
```
target/partition-list-X.X.X-SNAPSHOT.jar
```
### Functionalities

```java
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
```
## How to use

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.github.munozy.partition.list.PartitionList;
import com.github.munozy.partition.list.factory.PartitionListFactory;

/**
 * Example of PartitionList library usage.
 * 
 * @author Yupanqui Munoz
 *
 */
public class PartitionApp {
  public static void main(String[] args) {
    
    // Other way is: PartitionListFactory.getInstance().createPartitionList("default")
    PartitionList<Integer> partitionList = PartitionListFactory.getInstance().createPartitionList();	
    
    /*
     * Inputs
     */
    // List of elements
    List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));   
    // Maximum size of sublist partition
    int partitionMaxSize = 2;
    
    //Output
    for (List<Integer> partion : partitionList.partition(list, partitionMaxSize)) {
       System.out.print(partion);
    }
  }
}
```
#### Inputs
 
```
([1,2,3,4,5], 2)
 ```
#### Output
 
```
[1,2][3,4][5]
 ```
