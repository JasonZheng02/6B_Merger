/**
  Represent a merge operation for sorted lists,
  as described in README.md
 */
import java.util.ArrayList;

public class Merger {

    ArrayList<String> usersData;

    /**
      Construct an instance from a list of data
      part of which is to be merged. See README
     */
    public Merger( ArrayList<String> list) {
        usersData = list;
    }


    /**
      Merge the sorted sub-lists.
     */
    public void merge(
      // indexes of sub-list boundaries; see README
        int start0  // index of first item in list0
      , int start1  // index of first item in list1
                    // = just past end of list0
      , int nItems  // number of items in the merged list
                    // = just past end of list1
      ) {
        ArrayList<String> resultingArray = new ArrayList<String>();  
        
        ArrayList<String> list0 = new ArrayList<String>();
        for (int index = start0; index < start1; index++){
            list0.add(usersData.get(index));
        }
        
        ArrayList<String> list1 = new ArrayList<String>();
        for (int index = start1; index < nItems; index++){
            list1.add(usersData.get(index));
        }
        
        while (list0.isEmpty() == false && list1.isEmpty() == false){
            if (list0.get(0).compareTo(list1.get(0)) < 0) {
                resultingArray.add(list0.remove(0));
            }             
            else if (list0.get(0).compareTo(list1.get(0)) > 0) {
                resultingArray.add(list1.remove(0));
            }
            else {
                resultingArray.add(list0.remove(0));
                resultingArray.add(list1.remove(0));
            }
            
            if (list0.isEmpty() == false && list1.isEmpty() == true){
                while (list0.isEmpty() == false) {
                    resultingArray.add(list0.get(0));
                    list0.remove(0);
                }
            }
        
            if (list0.isEmpty() == true && list1.isEmpty() == false){
                while (list1.isEmpty() == false) {
                    resultingArray.add(list1.get(0));
                    list1.remove(0);
                }
            }
        }
        for (int index = start0; index < nItems; index++) {
            usersData.set(index, resultingArray.get(index - start0));
        }
      }

    /**
      @return a string representation of the user's data
     */
    public String toString() {
        return "" + usersData; 
    }

    
    /** 
      @return the boolean value of the statement
         "the data in the range are in ascending order"
     */
    public boolean isSorted( int startAt, int endBefore) {
        for( int i = startAt
           ; i < endBefore -1 // stop early, because comparing to next
           ; i++
           )
            if( usersData.get(i).compareTo( usersData.get(i+1)) > 0) return false;
        return true;
    }
}