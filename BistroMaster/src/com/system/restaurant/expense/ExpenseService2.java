package com.system.restaurant.expense;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.system.restaurant.income.IncomeService;
import com.system.restaurant.income.TotalSales;
import com.system.restaurant.view.ExpenseView;

public class ExpenseService2 {
    public static final String PATH1 = ".\\data\\월지출\\월 고정지출 더미 데이터.txt";
    public static final String PATH2 = ".\\data\\월지출\\월 변동지출 더미 데이터.txt";
    public static final String PATH3 = ".\\data\\월지출\\월 별 총 지출 더미 데이터.txt";
    public static ArrayList<NonVariableExpense> nvlist = new ArrayList<>();
    public static ArrayList<VariableExpense> vlist = new ArrayList<>();

    public static void main(String[] args) {

        loadV();
        loadN();

        vlist.sort((v1,v2) -> v1.getDate().compareTo(v2.getDate()));
        nvlist.sort((v1,v2) -> v1.getDate().compareTo(v2.getDate()));

        System.out.println(vlist);
        System.out.println(nvlist);

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(PATH3));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int total = 0;
        for (int i = 0; i < vlist.size(); i++) {
            total = vlist.get(i).getTotalPrice() + nvlist.get(i).getTotalPrice();
            System.out.println(vlist.get(i).getTotalPrice());
            System.out.println(nvlist.get(i).getTotalPrice());
            System.out.println("==============================");
            System.out.println(total);
            String txt = String.format("%d,%d,%s\n", i, total, vlist.get(i).getDate());
            try {
                writer.write(txt);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        

    }

    public static void loadV(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(PATH2));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        String line = null;

        while (true) {
            try {
                if (!((line = reader.readLine()) != null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            String[] temp = line.split(",");

            VariableExpense vExpense = new VariableExpense(Integer.parseInt(temp[0])
                    , Integer.parseInt(temp[1])
                    , Integer.parseInt(temp[2])
                    , Integer.parseInt(temp[3])
                    , Integer.parseInt(temp[4])
                    , Integer.parseInt(temp[5])
                    , temp[6]
            );
            vlist.sort((n1, n2) -> n2.getDate().compareTo(n1.getDate()));
            vlist.add(vExpense);
        }

        try {
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void loadN(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(PATH1));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        String line = null;

        while (true) {
            try {
                if (!((line = reader.readLine()) != null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            String[] temp = line.split(",");

            NonVariableExpense nvExpense = new NonVariableExpense(Integer.parseInt(temp[0])
                    , Integer.parseInt(temp[1])
                    , Integer.parseInt(temp[2])
                    , Integer.parseInt(temp[3])
                    , temp[4]
            );
            nvlist.sort((n1, n2) -> n2.getDate().compareTo(n1.getDate()));
            nvlist.add(nvExpense);
        }


        try {
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}





