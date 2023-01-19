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
        while (pilih<1&&pilih>2){
            System.out.print("masukkan input yang valid: ");
            pilih= scan.nextInt();
        }
        return pilih==1;
    }

    public static boolean validationNumber(int num1,int num2,int num3,int num4){

        int[] num = {num1,num2,num3,num4};
        for (int i=0;i<4;i++){
            if(num[i]>13||num[i]<1){
                return false;
            }
        }
        for(int i=0;i<4;i++){
            for (int j=0;j<4;j++){
                if(i!=j){
                    if((num[i]==num[j])){
                        return false;
                    }
                }
            }
        }

        return true;
    }
    public static boolean isKeyboard(){
        System.out.println("Pilih Cara Bermain:\n1. Input dengan keyboard\n2. Dipilih angka random");
        System.out.print("Pilih: ");
        int pilih = scan.nextInt();
        while (pilih<1&&pilih>2){
            System.out.println("masukkan input key yang valid:");
            pilih = scan.nextInt();
        }
        return pilih==1;
    }
    public static boolean validationExit(){
        System.out.println("Apakah anda ingin melanjutkan permainan?\n1.Ya\n2.Tidak");
        System.out.print("Pilih: ");
        int pilih = scan.nextInt();
        while (pilih<1&&pilih>2){
            System.out.println("masukkan input yang valid:");
            pilih = scan.nextInt();
        }
        return pilih==2;
    }

    public static void writeResults(String res, String card) throws IOException {
        System.out.println("masukkan lokasi penyimpanan dan format nama file:\ncontoh jika menggunakan Intellij : ./test/test.txt\ncontoh jika menggunakan Vscode : ../test/test.txt");
        String path = scan.next();
        FileWriter writeResult = new FileWriter(path);
        writeResult.write("Kartu yang dipilih:\n"+card+"\n\n");
        if(res!="") {
            String[] result = res.split("\n");
            writeResult.write(result.length+" Solutions found\n\n");
            if (result.length != 0) {
                for (int i = 0; i < result.length; i++) {
                    writeResult.write(result[i] + "\n");
                }
            }
            System.out.println("Data Berhasail Disimpan\n\n");
        }else {
            writeResult.write("Tidak ada solusi\n\n");
            System.out.println("Data Berhasail Disimpan\n\n");
        }
        writeResult.close();
    }
    public static int cardToNum(String card){
        if(card.equals("A")){
            return 1;
        }
        if(card.equals("J")){
            return 11;
        }
        if(card.equals("Q")){
            return 12;
        }
        if(card.equals("K")){
            return 13;
        }
        return Integer.valueOf(card);
    }
    private static String calculateResult(String result, int[] num) {

        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                for(int k=0;k<4;k++){
                    for(int l=0;l<4;l++){

                        if(i!=j&&i!=k&&i!=l&&j!=k&&j!=l&&l!=k){
                            if(Results.results(num[i],num[j],num[k],num[l])!=""){
                                result+=Results.results(num[i],num[j],num[k],num[l]);
                            }

                        }
                    }
                }
            }
        }
        return result;
    }
    public static String getRandom(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
    public static String[] ifInputKeyboardOrRandom(String result,boolean isKeyboard){
        String[] resultss;
        if(isKeyboard){

            String[] card = new String[4];
            int[] num = new int[4];


            System.out.println("Masukkan kartu: ");
            for(int i=0;i<4;i++){
                card[i]=scan.next();
            }


            for(int i=0;i<4;i++){
                num[i] = cardToNum(card[i]);
            }

            boolean isNumValid = validationNumber(num[0],num[1],num[2],num[3]);

            while (isNumValid==false){
                System.out.println("kartu sama atau melebihi batas masukkan kartu yang sesuai format: ");
                for(int i=0;i<4;i++){
                    card[i]=scan.next();
                }
                for(int i=0;i<4;i++){
                    num[i] = cardToNum(card[i]);
                }
                isNumValid = validationNumber(num[0],num[1],num[2],num[3]);
            }
            System.out.println("\n\nKartu yang dipilih:");
            for(int i=0;i<4;i++){
                System.out.print(card[i]+" ");
            }
            System.out.println("\n");
            resultss = new String[]{(card[0]+" "+card[1]+" "+card[2]+" "+card[3]+" "), calculateResult(result, num)};
            return resultss;
        }else {

            String[] cards = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
            int[] num = new int[4];


            String[] card = {getRandom(cards),getRandom(cards),getRandom(cards),getRandom(cards)};

            for(int i=0;i<4;i++){
                num[i] = cardToNum(card[i]);
            }
            boolean isNumValid = validationNumber(num[0],num[1],num[2],num[3]);
            while (!isNumValid){
                for(int i=0;i<4;i++){
                    card[i]=getRandom(cards);
                }
                for(int i=0;i<4;i++){
                    num[i] = cardToNum(card[i]);
                }
                isNumValid = validationNumber(num[0],num[1],num[2],num[3]);
            }

            System.out.println("\n\nKartu yang dipilih:");
            for(int i=0;i<4;i++){
                System.out.print(card[i]+" ");
            }
            System.out.println("\n");
            resultss = new String[]{(card[0]+" "+card[1]+" "+card[2]+" "+card[3]+" "), calculateResult(result, num)};
            return resultss;
        }
    }


}
