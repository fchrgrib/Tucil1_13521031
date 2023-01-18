public class Results {
    private static final Priority priority = new Priority();
    private static final String[] sym = {"+","-","/","*"};
    public static String results(String result,int num1,int num2,int num3,int num4){
        for(int i=0;i<sym.length;i++){
            for(int j=0;j<sym.length;j++){
                for(int k=0;k< sym.length;k++){
                    if(priority.three(Integer.toString(num1),sym[i],Integer.toString(num2),sym[j],Integer.toString(num3),sym[k],Integer.toString(num4))==24){
                        result+= (num1 +sym[i]+ num2 +sym[j]+ num3+sym[k]+ num4+"\n");
                    }
                    if((priority.two(Double.toString(priority.one(Integer.toString(num1),sym[i],Integer.toString(num2))),sym[j],Integer.toString(num3),sym[k],Integer.toString(num4)))==24){
                        result+= ("("+num1 +sym[i]+ num2+")"+ sym[j]+ num3+sym[k]+ num4+"\n");
                    }
                    if((priority.two(Integer.toString(num1),sym[i],Double.toString(priority.one(Integer.toString(num2),sym[j],Integer.toString(num3))),sym[k],Integer.toString(num4)))==24){
                        result+= (num1 +sym[i]+"("+ num2 +sym[j]+ num3+")"+sym[k]+ num4+"\n");
                    }
                    if((priority.two(Integer.toString(num1),sym[i],Integer.toString(num2),sym[j],Double.toString(priority.one(Integer.toString(num3),sym[k],Integer.toString(num4)))))==24){
                        result+= (num1 +sym[i]+ num2 +sym[j]+"("+ num3+sym[k]+ num4+")"+"\n");
                    }
                    if((priority.one(Double.toString(priority.two(Integer.toString(num1),sym[i],Integer.toString(num2),sym[j],Integer.toString(num3))),sym[k],Integer.toString(num4)))==24){
                        result+= ("("+num1 +sym[i]+ num2 +sym[j]+ num3+")"+sym[k]+ num4+"\n");
                    }
                    if((priority.one(Integer.toString(num1),sym[i],Double.toString(priority.two(Integer.toString(num2),sym[j],Integer.toString(num3),sym[k],Integer.toString(num4)))))==24){
                        result+= (num1 +sym[i]+"("+ num2 +sym[j]+ num3+sym[k]+ num4+")"+"\n");
                    }
                }
            }
        }
        return result;
    }
}
