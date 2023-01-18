public class Priority {
    private static final Tools tools = new Tools();

    public static double one(String num1,String sym,String num2){
        String[] merge = {num1,sym,num2};
        return tools.sumAll(tools.ifStarOrSlash(merge));
    }
    public static double two(String num1,String sym1,String num2,String sym2,String num3){
        String[] merge = {num1,sym1,num2,sym2,num3};
        return tools.sumAll(tools.ifStarOrSlash(merge));
    }
    public static double three(String num1,String sym1,String num2,String sym2,String num3,String sym3,String num4){
        String[] merge = {num1,sym1,num2,sym2,num3,sym3,num4};
        return tools.sumAll(tools.ifStarOrSlash(merge));
    }

}
