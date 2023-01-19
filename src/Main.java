import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        System.out.println("===========================SELAMAT DATANG DI PERMAINAN 24 SOLVE===========================");
        boolean isEnd = false;
        while (!isEnd){
            String res = "";
            boolean isBoard = Tools.isKeyboard();
            String[] result = Tools.ifInputKeyboardOrRandom(res,isBoard);
            if(result[1]==""){
                System.out.println("Tidak ada solusi\n\n");
            }else {
                String [] cobs = result[1].split("\n");
                System.out.println(cobs.length+" Solutions found\n\n");
            }
            System.out.println(result[1]);
            boolean save= Tools.validationSave();
            if(save) Tools.writeResults(result[1],result[0]);
            isEnd = Tools.validationExit();
        }
    }
}