import dataobjects.*;

import java.util.Scanner;

public class Main {
    /*public static void main(String[] args) {
        Teacher teacher1 = new Teacher("Tage", "Berntsson", 1234567890, "Apor är inte blåa", "godis är sött");
        Student student1 = new Student("Kalle", "Jansson", 135498763, "kakor är mums");

        teacher1.registerStudent(student1);
        System.out.println("Teach Apor är inte blåa: " + teacher1.teachFact("Apor är inte blåa"));
        System.out.println("Teach bilar är hårda: " + teacher1.teachFact("bilar är hårda"));
        System.out.println("Knows Apor är inte blåa: " + student1.knowsFact("Apor är inte blåa"));
        System.out.println("Knows Blommor är färgade: " + student1.knowsFact("Blommor är färgade"));
        System.out.println("Learn bilar är hårda: " + teacher1.learn("bilar är hårda"));
        System.out.println("Learn bilar är hårda: " + teacher1.learn("bilar är hårda"));
        System.out.println("Teach bilar är hårda: " + teacher1.teachFact("bilar är hårda"));
        System.out.println("Teach bilar är hårda: " + teacher1.teachFact("bilar är hårda"));
        System.out.println("Knows bilar är hårda: " + student1.knowsFact("bilar är hårda"));

        //student1.learn("as");

        //(new Person("a", "a", 1, "a")).learn("a");
    }*/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.print("Width:");
            int width = in.nextInt();
            System.out.print("Height:");
            int height = in.nextInt();
            System.out.print("hex:");
            int hex = in.nextInt();
            System.out.println();
            HexGrid.calcGridValues(width, height, hex);
            System.out.printf("");
        }
    }
}

