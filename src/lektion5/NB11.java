package lektion5;

public class NB11 {
    // linjer sökning
    static public int findBiggerTal(int[]list,int target,int postion){
        if(postion==list.length){
            return -1;
        } else if (target==list[postion]) {
            return postion;
        }
        return findBiggerTal(list,target,postion+1);
    }
    // binary sökning
    static public int findBiggerTal(int[]list,int target,int min,int high){
        if(min>high){
            return -1;
        }
        int mid = (min+high)/2;
        if(target==list[mid]){
            return mid;
        }
        if (target>list[mid]) {
            return findBiggerTal(list,target,mid+1,high);
        }
        return findBiggerTal(list,target,min,mid-1);

    }
}
