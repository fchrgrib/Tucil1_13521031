import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class Main {
    private static final Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws IOException {


        Splashscreen.splashscreen();
        boolean isEnd = false;
        while (!isEnd){
            String res = "";
            boolean isBoard = Tools.isKeyboard();
            Instant stopwatch = Instant.now();
            String[] result = Tools.ifInputKeyboardOrRandom(res,isBoard);
            if(result[1]==""){
                System.out.println("Tidak ada solusi\n\n");
            }else {
                String [] cobs = result[1].split("\n");
                System.out.println(cobs.length+" Solutions found\n\n");
            }
            Instant end = Instant.now();

            System.out.println(result[1]);
            System.out.println("\nTime execuiton: "+Duration.between(stopwatch,end)+"\n");
            boolean save= Tools.validationSave();
            if(save) Tools.writeResults(result[1],result[0]);
            isEnd = Tools.validationExit();
        }
    }
}