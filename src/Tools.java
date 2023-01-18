import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
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
                    if((num[i]==num[j])&&num[i]<0&&num[i]>13){
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
    private static void calculateResult(String result, int[] num) {
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
    public static String getRandom(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
    public static void ifInputKeyboardOrRandom(String result,boolean isKeyboard){
        if(isKeyboard){

            String[] card = new String[4];
            int[] num = new int[4];
            boolean isNumValid = validationNumber(num[0],num[1],num[2],num[3]);

            System.out.println("Masukkan kartu: ");
            for(int i=0;i<4;i++){
                card[i]=scan.next();
            }

            for(int i=0;i<4;i++){
                num[i] = cardToNum(card[i]);
            }


            while (!isNumValid){
                System.out.println("kartu sama atau melebihi batas masukkan kartu yang sesuai format: ");
                for(int i=0;i<4;i++){
                    card[i]=scan.next();
                }
                for(int i=0;i<4;i++){
                    num[i] = cardToNum(card[i]);
                }
                isNumValid = validationNumber(num[0],num[1],num[2],num[3]);
            }
            calculateResult(result,num);
        }else {

            String[] cards = {"A","1","2","3","4","5","6","7","8","9","10","J","Q","K"};
            int[] num = new int[4];
            boolean isNumValid = validationNumber(num[0],num[1],num[2],num[3]);

            String[] card = {getRandom(cards),getRandom(cards),getRandom(cards),getRandom(cards)};

            for(int i=0;i<4;i++){
                num[i] = cardToNum(card[i]);
            }

            while (!isNumValid){
                for(int i=0;i<4;i++){
                    card[i]=getRandom(cards);
                }
                for(int i=0;i<4;i++){
                    num[i] = cardToNum(card[i]);
                }
                isNumValid = validationNumber(num[0],num[1],num[2],num[3]);
            }
            calculateResult(result,num);
        }
    }


}
