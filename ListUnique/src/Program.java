package List_Unique;

import java.io.*;
import java.util.*;

public class Program {
    public static void main(String[] args) throws IOException{
        boolean correct_1st_step = false;
        List list=new List();
        while (!correct_1st_step) {
            System.out.print("Выберите способ инициализации списка:\n" +
                    "1 - Из файла\n2 - Ввод вручную\nВаш выбор: ");
            Scanner in = new Scanner(System.in);
            int choice = in.nextInt();
            switch (choice) {
                case 1: {
                    Integer[] temp= readFromFile();
                    for(int i:temp){
                        list.add(i);
                    }
                    correct_1st_step=true;
                    break;
                }
                case 2: {
                    boolean condition=false;
                    System.out.println("\n\nВвод значений списка.");
                    while(!condition){
                        System.out.print("Введите число:");
                        list.add(in.nextInt());
                        System.out.print("Продолжить(да/нет):");
                        if(in.next().compareTo("нет")==0){
                            condition=true;
                        }
                    }
                    correct_1st_step=true;
                    break;
                }
                default: {
                    System.out.println("Некорректный ввод. Попробуйте снова.");
                    break;
                }
            }
            System.out.println("Список изначальный:\n"+list.show());
            List uniqueList=list.unique();
            System.out.println("Список уникальных элементов:\n"+uniqueList.show());
        }
    }
    public static Integer[] readFromFile() throws IOException {
        Scanner in = new Scanner(new File("List_Unique/example.txt"));
        ArrayList<Integer> temp=new ArrayList<Integer>();
        while(in.hasNextInt()){
            temp.add(in.nextInt());
            continue;
        }
        Integer[] result =temp.toArray(new Integer[0]);
        return result;
    }
}
