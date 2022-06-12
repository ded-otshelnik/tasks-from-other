package List_Unique;

import java.io.*;
import java.util.*;

public class Program {
    public static void main(String[] args) throws IOException{
        boolean correct_1st_step = false;
        List list=new List();
        while (!correct_1st_step) {
            System.out.println("Выберите способ инициализации списка:\n" +
                    "1 - Из файла\n2 - Ввод вручную\nВаш выбор: ");
            Scanner in = new Scanner(System.in);
            int choice;
            choice = in.nextInt();
            switch (choice) {
                case 1: {
                    Integer[] temp= readFromFile();
                    for(int i:temp){
                        list.add(i);
                    }
                    break;
                }
                case 2: {
                    System.out.println("\n\nВвод значений списка:");
                    System.out.print("Введите число:");
                    list.add(in.nextInt());
                    System.out.print("Продолжить(да/нет):");
                    if(in.next().compareTo("Нет")==0){
                        break;
                    }
                }
                default: {
                    System.out.println("Некорректный ввод. Попробуйте снова.");
                    break;
                }
            }
            System.out.println("Список изначальный:\n"+list.show());
            List uniqueList=list.unique();
            System.out.println("Список изначальный:\n"+uniqueList.show());
        }
    }
    public static Integer[] readFromFile() throws IOException {
        FileReader in =new FileReader("List_Unique/example.txt");
        ArrayList<Integer> temp=new ArrayList<Integer>();
        while(temp.add(in.read())){
            continue;
        }
        Integer[] result =temp.toArray(new Integer[0]);
        return result;
    }
}
