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

    public static void main(String[] args) {
      int[]list = new int[10];
        for (int i = 0; i < list.length; i++) {
            list[i]=i;
        }
        System.out.println(NB11.findBiggerTal(list,35,0));
        System.out.println(NB11.findBiggerTal(list,36,0,list.length-1));
        }
}
