package com.zipcodewilmington.assessment1.part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by leon on 2/16/18.
 */
public class ArrayUtils {
    /**
     * @param objectArray   an array of any type of Object
     * @param objectToCount any non-primitive value
     * @return the number of times the specified `value` occurs in the specified `objectArray`
     * Given an array of objects, named `objectArray`, and an object `objectToCount`, return the number of times the `objectToCount` appears in the `objectArray`
     */
    public static Integer getNumberOfOccurrences(Object[] objectArray, Object objectToCount) {
        int count = 0;
        for (int i = 0; i < objectArray.length; i++) {
            if (objectArray[i] == objectToCount) {
                count++;
            }
        }
        return count;
    }
    //int n = 0;
    // for (Object to : objectArray) {
    //if(to.equals(objectToCount)) n +=1;
//}
//return n;

    /**
     * @param objectArray    an array of any type of Object
     * @param objectToRemove a value to be removed from the `objectArray`
     * @return an array with identical content excluding the specified `objectToRemove`
     * Given an array of objects, name `objectArray`, and an object `objectToRemove`, return an array of objects with identical contents excluding `objectToRemove`
     */
    public static Object[] removeValue(Object[] objectArray, Object objectToRemove) {
      /*  if (objectArray == null) {
            return null;
        } else if (objectArray.length <= 0) {
            return objectArray;
        } else {
            Object[] output = new String[objectArray.length - 1];
            int count = 0;
            for (Object i : objectArray) {
                if (!i.equals(objectToRemove)) {
                    output[count++] = i;
                }
            }
            return output;
        }
    }
*/
      /* ArrayList<Object> tmp = new ArrayList<>();
      for (Object to : objectArray) {
          if (!to.equals(objectToRemove)) tmp.add(to);
      }
      Integer [] foo = new Integer[tmp.size()];
      return tmp.toArray(foo);

      */

        int rm = 0;
        for (Object to : objectArray) {
            if (to.equals(objectToRemove)) rm++;
        }
        Integer[] result = new Integer[objectArray.length - rm];
        int j = 0;
        for (Integer i = 0; i < objectArray.length; i++) {
            if (!objectArray[i].equals(objectToRemove)) {
                result[j] = (Integer) ( objectArray[i] );
                j++;
            }

        }
        return result;
    }

    /**
     * @param objectArray an array of any type of Object
     * @return the most frequently occurring object in the array
     * given an array of objects, named `objectArray` return the most frequently occuring object in the array
     */
    public static Object getMostCommon(Object[] objectArray) {
        HashMap<Object, Integer> hm = new HashMap<>();
        int maximum = 1;
        int temp = 0;
        for (int i = 0; i < objectArray.length; i++) {
            if (hm.get(objectArray[i]) != null) {
                int count = hm.get(objectArray[i]);
                count++;
                hm.put(objectArray[i], count);
                if (count > maximum) {
                    maximum = count;
                    temp = (int) objectArray[i];
                }
            } else
                hm.put(objectArray[i], 1);
        }
        return temp;
    }


    /**
     * @param objectArray an array of any type of Object
     * @return the least frequently occurring object in the array
     * given an array of objects, named `objectArray` return the least frequently occuring object in the array
     */
    public static Object getLeastCommon(Object[] objectArray) {
        HashMap<Object, Integer> hm = new HashMap<>();
        int min = objectArray.length;
        int occ = 0;
        Object result = null;
        for (Object x : objectArray) {
            occ = getNumberOfOccurrences(objectArray, x);
            if (occ < min) {
                min = occ;
                result = x;
            }
        }
        return result;
    }

    /**
     * @param objectArray  an array of any type of Object
     * @param objectArrayToAdd an array of Objects to add to the first argument
     * @return an array containing all elements in `objectArray` and `objectArrayToAdd`
     * given two arrays `objectArray` and `objectArrayToAdd`, return an array containing all elements in `objectArray` and `objectArrayToAdd`
     */
    public static Object[] mergeArrays(Object[] objectArray, Object[] objectArrayToAdd) {

        Object[] ob = Arrays.copyOf(objectArray, objectArray.length + objectArrayToAdd.length);
        System.arraycopy(objectArrayToAdd, 0, ob, objectArray.length, objectArrayToAdd.length);
        return ob;
    }
}

