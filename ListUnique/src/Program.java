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
                    System.out.println("\nВвод значений списка.");
                    while(!condition){
                        System.out.print("Введите число(q для окончания):");
                        if(in.hasNextInt()){
                            list.add(in.nextInt());
                        }
                        else{
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
            System.out.println("Список изначальный:");
            for(var i:list){
                System.out.print(i+" ");
            }
            List uniqueList=list.unique();
            System.out.println("\n\nСписок уникальных элементов:");
            for(var i:uniqueList){
                System.out.print(i+" ");
            }
        }
    }
    public static Integer[] readFromFile() throws IOException {
        Scanner in = new Scanner(new File("src/example.txt"));
        ArrayList<Integer> temp=new ArrayList<Integer>();
        while(in.hasNextInt()){
            temp.add(in.nextInt());
            continue;
        }
        Integer[] result =temp.toArray(new Integer[0]);
        return result;
    }
}
