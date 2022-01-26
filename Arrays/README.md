# Arrays
Arrays are linear data structures which allows to store data of similar data types in a sequential order and are placed in contigous memory locations. The data stored in the array can be accessed via the index.

# Advantages
## Similar data grouping
One can store data of similar data types
## Fast data retrieval using index
Data can be retrieved via index and can be in sequential or random order. Algorithm complexity of data retrieval is O(1) for the known index. For example, in the sorted array the minimum element can be obtained at first index i.e. 0th index 
## Supports other data structures
Other data structure implementationa are realized using Arrays. For Ex: Stack, Queue

# Disadvantages
## It is static
Number of data elements and type of data that will be stored in the Array must be known at the time of Array creation. Data can be added later. Because of this static nature, there are possibilities of under utilization of memory allocated. This happens if we allocate more size and store less data
## The size of the structure is fixed once created
At the runtime, if there are more data coming in, the size cannot be altered after Array is been created. In order to occupy more elements, a new Array needs to be created, populate the data from old Array to new Array, delete old Array and add new elements
## Searching an element is costlier
In an unsorted Array, If we want to search an element, it is required to visit all the elements. This will leads to a complexity of O(n)
In an sorted Array, by choosing an efficient algorithm, the element can be found using O(log(n)) complexity
## Insertion and Deletion
If you are maintaining an sorted array and in-case if you need to insert or delete an element, the complexity can go upto O(n)
