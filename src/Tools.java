import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Tools {
    private static final Scanner scan = new Scanner(System.in);
    public static String[] ifStarOrSlash(String[] nums){
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
    public static double sumAll(String[] numsum){
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

    public static boolean validationSave(){
        System.out.println("Apakah anda ingin menyimpan data tersebut?\n1.Ya\n2.Tidak");
        System.out.print("Pilih:");
        int pilih = scan.nextInt();
        while (pilih!=1||pilih!=2){
            System.out.print("masukkan input yang valid: ");
            pilih= scan.nextInt();
        }
        return pilih==1;
    }

    public static boolean validationNumber(int num1,int num2,int num3,int num4){
        int[] num = {num1,num2,num3,num4};
        for(int i=0;i<4;i++){
            for (int j=0;j<4;j++){
                if(i!=j){
                    if(num[i]==num[j]){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void writeResults(String path,String[] result) throws IOException {
        FileWriter writeResult = new FileWriter(path);
        writeResult.write("result found: "+result.length);
        if(result.length!=0){
            for (int i=0;i<result.length;i++){
                writeResult.write(result[i]+"\n");
            }
        }
    }
    public static int cardToNum(String card){
        if(card=="A"){
            return 1;
        }
        if(card=="J"){
            return 11;
        }
        if(card=="Q"){
            return 12;
        }
        if(card=="K"){
            return 13;
        }
        return Integer.parseInt(card);
    }
    public static void ifInputKeyboardOrRandom(String result,boolean isKeyboard){
        if(isKeyboard){
            String[] card = new String[4];

            System.out.println("Masukkan kartu: ");
            for(int i=0;i<4;i++){
                card[i]=scan.next();
            }
            int[] num = new int[4];
            for(int i=0;i<4;i++){
                num[i] = cardToNum(card[i]);
            }
            for(int i=0;i<4;i++){
                for(int j=0;j<4;j++){
                    for(int k=0;k<4;k++){
                        for(int l=0;l<4;l++){
                            if(i!=j&&i!=k&&i!=l&&j!=k&&j!=l&&l!=k){
                                Results.results(result,num[i],num[j],num[k],num[l]);
                            }
                        }
                    }
                }
            }
        }
    }
}
