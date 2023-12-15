package src;

import java.util.Scanner;

public class Validate {
    static Scanner in = new Scanner(System.in);
    static boolean checkValue;
    //Confirms that input integer is between interval [start,end]
    public static int getInt(int start, int end) {
        int x = start; // not initializing causes error
        try {
            x = in.nextInt();
        } catch (Exception e) {
            getInt(start,end);
        }
        try {
            while (x < start || x > end) {
                System.out.print("Invalid input. Please retry: ");
                x = in.nextInt();
            }
        } catch (Exception e) {
            getInt(start,end);
        }
        return x;
    }

    public static char getGender() {
        char x = '0';
        try {
            x = in.next().charAt(0);
            while (x != 'm' && x != 'M' && x != 'f' && x != 'F') {
                System.out.print("Invalid input. Please retry: ");
                x = in.next().charAt(0);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (x == 'm') {
            return 'M';
        } else if (x == 'f') {
            return 'F';
        } else {
            return x;
        }
    }
    public static int checkInt() {
        String x = "0";
        do {
            System.out.print("Enter Value: ");
            x = in.next();
            if (x.equals("1") || x.equals("2") || x.equals("3") || x.equals("4") || x.equals("5") || x.equals("6") || x.equals("7") || x.equals("8") || x.equals("9")) {
                checkValue = false;
            } else {
                System.out.println("Invalid Value");
                checkValue = true;
            }
        } while (checkValue);
        return Integer.parseInt(x);
    }
    public static int checkInt(int start, int end) {
        String x = "0";
        int finalAnswer = 0;
        do {
            if (finalAnswer !=0 )
                System.out.println("Invalid Value");
            do {
                System.out.print("Enter Value: ");
                x = in.next();
                if (x.equals("1") || x.equals("2") || x.equals("3") || x.equals("4") || x.equals("5") || x.equals("6") || x.equals("7") || x.equals("8") || x.equals("9")) {
                    checkValue = false;
                } else {
                    System.out.println("Invalid Value");
                    checkValue = true;
                }
            } while (checkValue);
            finalAnswer = Integer.parseInt(x);
        } while (finalAnswer < start || finalAnswer > end);
        return finalAnswer;
    }
}
