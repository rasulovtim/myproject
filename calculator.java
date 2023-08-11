import java.util.*;

public class calculator {
    static int digit1, digit2;

    public static void main(String[] args) throws Exception {
        System.out.println("Введите выражение(от 1 до 10). Например: 2 + 2 или IV / II");
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        System.out.println(calculate(in));}
    public static String calculate(String inp)throws Exception{
        String result;
        String[] input = (inp.split(" "));
        if (input.length != 3) {
            throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        String operand1 = input[0];
        String operand2 = input[2];
        String operator = input[1];
        if (romanToArab(operand1) != 0 && romanToArab(operand2) != 0) {
            int firstOperand = romanToArab(operand1);
            int secondOperand = romanToArab(operand2);
            int resultForRomanInArab = (calc(firstOperand, secondOperand, operator) - 1);
            if (resultForRomanInArab < 0) {
                throw new Exception("в римской системе нет 0 или отрицательных чисел");
            } else {
                result = String.valueOf(convertArabToRoman(resultForRomanInArab));
            }
        } else {
            try {
                digit1 = Integer.parseInt(operand1);
                digit2 = Integer.parseInt(operand2);
            } catch (NumberFormatException e) {
                throw new NumberFormatException("т.к. используются одновременно разные системы счисления" + "\n" + e.getMessage());
            }
            if ((digit1 > 10 || digit1 < 1) || (digit2 > 10 || digit2 < 1)) {
                throw new Exception("Введите число от 1 до 10");
            }
            result = String.valueOf((calc(digit1, digit2, operator)));
        }
        return result;
    }

    public static int calc(int num1, int num2, String operation){
        int res = 0;
        switch (operation){
            case "+" -> {
                res = num1 + num2;}
            case "-" -> {
                res = num1 - num2;}
            case "*" -> {
                res = num1 *  num2;}
            case "/" -> {
                res = num1 / num2;}
            default -> System.out.println("Вы ввели не математическу операцию");

        }
        return res;
    }
    public static int romanToArab(String rom){
        return switch (rom){
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> 0;
        };
    }
    public static String convertArabToRoman(int arabNum){
        String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV",
                "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX",
                "*****", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII",
                "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII",
                "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI",
                "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII",
                "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV",
                "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        final String s = roman[arabNum];
        return s;
    }

}