import java.util.ArrayList;

public class ArabicNumberCalc{
    public static String op;
    public static int result;
    public static ArrayList<Integer> list1 = new ArrayList<>();
    public static ArrayList<Character> list2 = new ArrayList<>();
    public static boolean isDigit(char check) {
        return Character.isDigit(check);
    }

    public ArabicNumberCalc(String op){
        ArabicNumberCalc.op = op;
    }

    public static void getNumbers(){
        int len = op.length();
        for (int i = 0; i < len; i++) {
            if (!isDigit(op.charAt(i))){
                list2.add(op.charAt(i));
            }
        }
        char ch = list2.get(0);
        String str1 = op.replace(ch, '-');
        String [] strings = str1.split("-");
        for (int i =0; i< strings.length; i++){
            list1.add(Integer.parseInt(strings[i]));
        }
        if(list1.size()>2) throw new Error();
        int n1 = list1.get(0);
        int n2=list1.get(1);

        if (n1>10||n2>10){
            throw new Error("Error");
        }
        char oper = list2.get(0);
        switch (oper) {
            case '+' -> result = list1.get(0) + list1.get(1);
            case '-' -> result = list1.get(0) - list1.get(1);
            case '/' -> result = list1.get(0) / list1.get(1);
            case '*' -> result = list1.get(0) * list1.get(1);
        }
    }

    public static void showResult(){
        System.out.println(result);
    }
    public ArabicNumberCalc(){
    }
}
