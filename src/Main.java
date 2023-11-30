package src;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.lang.*;
public class Main {
    public static void main(String[] args) throws Exception {
        File file;
        file = new File("E:/Files/GYM.java");
        GYM gym=(GYM) (FileReading.read(file));
        file = new File("E:/Files/Customer.java");
        ArrayList<Customer> customers =(ArrayList<Customer>) FileReading.read(file);
        }
    }
