import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

import Queue.*;

public class Program {
    public static void main(String[] args) throws IOException {
        IQueue<Integer> queue = null;
        boolean correct_1st_step = false;
        Scanner in = new Scanner(System.in);
        int choice = 0;
        while (!correct_1st_step) {
            System.out.print("""
                    Выберите реализацию стека:
                    1 - Стек системный
                    2 - Стек пользовательский
                    Ваш выбор:\s""");
            if (in.hasNextInt()) {
                choice = in.nextInt();
            }
            switch (choice) {
                case 1 -> {
                    queue = new Queue.Queue_v1.Queue<>();
                    correct_1st_step = true;
                }
                case 2 -> {
                    queue = new Queue.Queue_v2.Queue<>();
                    correct_1st_step = true;
                }
                default -> System.out.println("Некорректный ввод. Попробуйте снова.");
            }
        }
        boolean correct_2nd_step = false;
        choice = 0;
        while (!correct_2nd_step) {
            System.out.print("""
                    Выберите способ ввода исходных данных:
                    1 - Вручную
                    2 - Из файла
                    Ваш выбор:\s""");
            if (in.hasNextInt()) {
                choice = in.nextInt();
            }
            switch (choice) {
                case 2-> {
                    var temp = readFromFile();
                    for (var i : temp) {
                        queue.enqueue(i);
                    }
                    correct_2nd_step = true;
                }
                case 1 -> {
                    boolean condition = false;
                    System.out.println("\nВвод значений списка.");
                    while (!condition) {
                        System.out.print("Введите число(q для окончания):");
                        if (in.hasNextInt()) {
                            queue.enqueue(in.nextInt());
                        } else {
                            condition = true;
                        }
                    }
                    correct_2nd_step = true;
                }
                default -> System.out.println("Некорректный ввод. Попробуйте снова.");
            }
        }
        System.out.println("Исходная очередь:");
        if(queue.empty()){
            System.out.println("В очереди нет ни одного элемента!");
        }
        else{
            for(var i:queue){
                System.out.print(i+"  ");
            }
            System.out.println("\nУдаление элемента из очереди:");
            queue.dequeue();
            System.out.println("Очередь:");
            for(var i:queue){
                System.out.print(i+"  ");
            }
            System.out.println("\nДобавление элемента в очередь:");
            queue.enqueue(7);
            System.out.println("Очередь:");
            for(var i:queue){
                System.out.print(i+"  ");
            }
        }
        in.close();
    }
    public static ArrayList<Integer> readFromFile () throws IOException {
        Scanner fin = new Scanner(new File("src/example.txt"));
        ArrayList<Integer> temp = new ArrayList<>();
        while (fin.hasNextInt()) {
            temp.add(fin.nextInt());
        }
        fin.close();
        return temp;
    }
}