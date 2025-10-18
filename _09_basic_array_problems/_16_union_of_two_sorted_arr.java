package _09_basic_array_problems;

public class _16_union_of_two_sorted_arr {
    /**
     * Q. Find the union of two sorted arrays.
     * => arr1[] = [1, 1, 2, 3, 4, 5]
     * => arr2[] = [2, 3, 4, 4, 5, 6]
     * 
     * Union: Distinct elements of two sorted arrays
     * => union[] = [1, 2, 3, 4, 5, 6]
     *
     * 
     * Approach-1: Unique (map, set)
     * => HashSet<Integer> unionSet;
     * 
     * 1. Insert all elements of arr1[] into the set
     * => for(int i = 0; i < n; i++) {
     *       unionSet.add(arr1[i]);
     *    }
     * 
     * 2. Insert all elements of arr2[] into the set
     * => for(int i = 0; i < m; i++) {
     *       unionSet.add(arr2[i]);
     *    }
     * 
     * 3. Return the set as the union(or convert to list if needed)
     * => return new ArrayList<>(unionSet);
     * 
     * TC: O(M + N)
     * SC: O(M + N)
     *  
     * 
     * Approach-2: Unique (map, set)
     * => HashMap<Integer, Integer> freq;
     * => ArrayList<Integer> Union = new ArrayList<>();
     * 
     * 1. Insert all elements of arr1[] into the map
     * => for(int i = 0; i < n; i++) {
     *       freq.put(arr1[i], freq.getOrDefault(arr[i], 0)+1);
     *    }
     * 
     * 2. Insert all elements of arr2[] into the map
     * => for(int i = 0; i < m; i++) {
     *       freq.put(arr2[i], freq.getOrDefault(arr2[i], 0)+1);
     *    }
     * 
     * 3. Extract all unique keys(distinct elements) from the map
     * => for(int it : freq.keySet()) {
     *       Union.add(it);
     *    }
     *    return Union;
     * 
     * TC: O(M + N)
     * SC: O(M + N)
     * 
     * Note: Do sorting before these approach-1 & 2.
    */
}
