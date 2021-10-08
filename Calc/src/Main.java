import java.util.Scanner;

public class Main {    public static String replaceSpace(String string){
    return string = string.replaceAll(" ", "");
}
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String op = in.nextLine();
        op = replaceSpace(op);
        ArabicNumberCalc calc = new ArabicNumberCalc(op);
        try {
            ArabicNumberCalc.getNumbers();
            ArabicNumberCalc.showResult();
        }catch (NumberFormatException numberFormatException){
            RomanNumbers romanNumbers = new RomanNumbers(op);
            romanNumbers.getRomanResult();
        }
    }
}






