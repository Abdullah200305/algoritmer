package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BackTrack {
   static public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>list = new Stack<>();
        List<Integer> current = new ArrayList<>();
        int i =0;
        subsets(nums,i,list,current);

        return list;
    }
    static public void subsets(int[] nums,int index,List<List<Integer>> res,List<Integer> cur) {
        if(index==nums.length){
            res.add(new ArrayList<>(cur));

            return;
        }
        for (int i = index; i < nums.length; i++) {
            subsets(nums,index+1,res,cur);
            cur.add(nums[index]);

            subsets(nums,index+1,res,cur);
            cur.remove(cur.size()-1);
        }


        subsets(nums,index+1,res,cur);
        cur.remove(cur.size()-1);
        return;
    }
}
