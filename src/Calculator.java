import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Calculator {

    private static Map<Integer, String> romaAndArabic = new HashMap<>();

    public static void main(String[] args) throws TaskException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your operation:");
        String operation = scanner.nextLine();


        String[] operationArray = operation.split(" ");
        if (operationArray.length > 3)
            throw new TaskException();


        romaAndArabic.put(1, "I");
        romaAndArabic.put(2, "II");
        romaAndArabic.put(3, "III");
        romaAndArabic.put(4, "IV");
        romaAndArabic.put(5, "V");
        romaAndArabic.put(6, "VI");
        romaAndArabic.put(7, "VII");
        romaAndArabic.put(8, "VIII");
        romaAndArabic.put(9, "IX");
        romaAndArabic.put(10, "X");
        romaAndArabic.put(50, "L");
        romaAndArabic.put(20, "XX");
        romaAndArabic.put(30, "XXX");
        romaAndArabic.put(40, "XL");
        romaAndArabic.put(60, "LX");
        romaAndArabic.put(70, "LXX");
        romaAndArabic.put(80, "XXC");
        romaAndArabic.put(90, "XC");



        boolean checked = romeNumbersCheck(operationArray);
        if (checked) {
            calculateArabic(operationArray);
        } else {
            calculatingRoman(operationArray);
        }


    }

    public static boolean romeNumbersCheck(String[] numbers) {
        boolean flag = true;
        for (Map.Entry<Integer, String> entry : romaAndArabic.entrySet()) {
            for (String number : numbers) {
                if (number.equals(entry.getValue()))
                    flag = false;
            }
        }
        return flag;
    }

    public static void calculateArabic(String[] numbers) throws TaskException {
        int result;
        if (Integer.parseInt(numbers[0]) > 10 || Integer.parseInt(numbers[2]) > 10)
        throw new TaskException();
        if (numbers[1].equals("+")) {
            result = Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[2]);
            System.out.println("Result is: " + result);
        }
        else if (numbers[1].equals("*")){
            result = Integer.parseInt(numbers[0]) * Integer.parseInt(numbers[2]);
            System.out.println("Result is: " + result);
        }
        else if (numbers[1].equals("-")) {
            result = Integer.parseInt(numbers[0]) - Integer.parseInt(numbers[2]);
            System.out.println("Result is: " + result);
        }
        else if (numbers[1].equals("/") && Integer.parseInt(numbers[2]) != 0) {
            result = Integer.parseInt(numbers[0]) / Integer.parseInt(numbers[2]);
            System.out.println("Result is: " + result);
        }
        else  {throw new TaskException();}


    }

    public static String calculatingRoman(String[] numbers) throws TaskException {
        int result = 0;
        int firstNumber = 0;
        int secondNumber = 0;
        for (Map.Entry<Integer, String> entry : romaAndArabic.entrySet()) {


            if (numbers[0].equals(entry.getValue())) {
                firstNumber = entry.getKey();
            }
            if (numbers[2].equals(entry.getValue())) {
                secondNumber = entry.getKey();
            }

        }
        if (numbers[1].equals("+")) {
            result = firstNumber + secondNumber;
        } else if (numbers[1].equals("-")) {
            result = firstNumber - secondNumber;
        } else if (numbers[1].equals("/")) {
            result = firstNumber / secondNumber;
        } else if (numbers[1].equals("*")) {
            result = firstNumber * secondNumber;
        } else
            throw new TaskException();
        if (result < 1) {
            throw new TaskException();
        } else {
            if (result == 100) {
                System.out.println("Result is D");
            } else
            {
                int x = result % 10;
                int y = result - x;
                String finalResult = "";
                for (Map.Entry<Integer, String> entry : romaAndArabic.entrySet()) {
                    if (x == entry.getKey()) {
                        finalResult = finalResult + entry.getValue();
                    }
                    if (y == entry.getKey()) {
                        finalResult = entry.getValue() + finalResult;
                    }
                }

                    System.out.println("Result is: " + finalResult);
                }


                return Integer.toString(result);
            }
        }

    }


    class TaskException extends Exception {
        public TaskException() {
            System.out.println("Exception");
        }
    }





