import java.util.ArrayList;
import java.util.Locale;

public class RomanNumbers extends ArabicNumberCalc{
    boolean isAlphabetic(char check){return Character.isAlphabetic(check);}
    boolean isEmpty(char check){return Character.isDefined(check);}
    int num1, num2, result;
    String op;
    ArrayList<String> list1 = new ArrayList();
    ArrayList<Character> list2 = new ArrayList();
    public int getArabic(String str){
        final int MAX = 3999;
        str = str.toUpperCase(Locale.ROOT);
        int i = 0;
        int current = 0;
        int previous = 0;
        int arabic = 0;

        while (i<str.length()){
            char letter = str.charAt(i);

            switch (letter){
                case 'I': current=1; break;
                case 'V': current=5; break;
                case 'X': current=10; break;
                case 'L': current=50; break;
                case 'C': current=100; break;
                case 'D': current=500; break;
                case 'M': current=1000; break;
            }
            if (current>previous){
                arabic += current-(previous*2);
            }else {
                arabic += current;
            }
            previous=current;
            i++;
        }
        if (arabic>MAX){
            throw new Error();
        } int x = arabic;
        return x;
    }

    public RomanNumbers(String op
    ){
        this.op=op;
    }

    public void getRomanResult(){
        for (int i=0; i<op.length(); i++){
            if (!isAlphabetic(op.charAt(i))&&isEmpty(op.charAt(i))){
                list2.add(op.charAt(i));

            }
            if (isDigit(op.charAt(i))) throw new Error();
        }
        char ch = list2.get(0);
        String str = op.replace(ch, ' ');
        String[] strings = str.split(" ");
        if (strings.length>2){ throw new Error();}
        for (int i=0; i < strings.length; i++){
            list1.add(strings[i]);
        }
        num1 = getArabic(list1.get(0));
        num2 = getArabic(list1.get(1));
        if (num1>10||num2>10){
            throw new Error();
        }
        switch (list2.get(0)) {
            case '+' -> result = num1+num2;
            case '-' -> result = num1-num2;
            case '/' -> result = num1/num2;
            case '*' -> result = num1*num2;
        }

        if (result<0){
            throw new Error();
        }

        String ans = getRoman(result);
        System.out.println(ans);
    }

    public static String getRoman(int input){
        if (input < 1 || input > 3999)
            throw new Error("Error");
        StringBuilder s = new StringBuilder();
        while (input >= 1000) {
            s.append("M");
            input -= 1000;        }
        while (input >= 900) {
            s.append("CM");
            input -= 900;
        }
        while (input >= 500) {
            s.append("D");
            input -= 500;
        }
        while (input >= 400) {
            s.append("CD");
            input -= 400;
        }
        while (input >= 100) {
            s.append("C");
            input -= 100;
        }
        while (input >= 90) {
            s.append("XC");
            input -= 90;
        }
        while (input >= 50) {
            s.append("L");
            input -= 50;
        }
        while (input >= 40) {
            s.append("XL");
            input -= 40;
        }
        while (input >= 10) {
            s.append("X");
            input -= 10;
        }
        while (input >= 9) {
            s.append("IX");
            input -= 9;
        }
        while (input >= 5) {
            s.append("V");
            input -= 5;
        }
        while (input >= 4) {
            s.append("IV");
            input -= 4;
        }
        while (input >= 1) {
            s.append("I");
            input -= 1;
        }
        return s.toString();
    }
}

