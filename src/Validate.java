package src;

import java.util.Scanner;

public class Validate {

    static boolean check = false;
    //Confirms that input integer is between interval [start,end]
    public static int getInt(int start, int end) {
        Scanner in = new Scanner(System.in);
        int x = start; // not initializing causes error
        try {
            x = in.nextInt();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            while (x < start || x > end) {
                System.out.print("Invalid input. Please retry: ");
                x = in.nextInt();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return x;
    }

    public static char getGender() {
        Scanner in = new Scanner(System.in);
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
}
