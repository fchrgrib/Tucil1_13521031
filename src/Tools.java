public class Tools {
    public String[] ifStarOrSlash(String[] nums){
        for(int i = 0;i<nums.length;i++){
            if(nums[i].equals("*")){
                nums[i+1]=String.valueOf(Double.parseDouble(nums[i-1])*Double.parseDouble(nums[i+1]));
                nums[i-1]="0";
                nums[i]="+";
            }else if(nums[i].equals("/")){
                nums[i+1]=String.valueOf(Double.parseDouble(nums[i-1])/Double.parseDouble(nums[i+1]));
                nums[i-1]="0";
                nums[i]="+";
            }
        }
        return nums;
    }
    public double sumAll(String[] numsum){
        double sum = Double.parseDouble(numsum[0]);
        for(int i=0;i<numsum.length;i++){
            if(numsum[i].equals("+")){
                sum+=Double.parseDouble(numsum[i+1]);
            }else if(numsum[i].equals("-")){
                sum-=Double.parseDouble(numsum[i+1]);
            }
        }
        return sum;
    }

}
