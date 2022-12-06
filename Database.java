import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Database implements Serializable{
    private static ArrayList<Student> db = new ArrayList<>();
    private static ObjectInputStream ois = null;
    private static ObjectOutputStream oos = null;


    File f = new File("output.txt");

    public void close(){
        try{
            oos = new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(db);
            oos.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void open(){
        try{
            ois = new ObjectInputStream(new FileInputStream(f));
            db = (ArrayList<Student>) ois.readObject();
            ois.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void edit(){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter roll number :");
        int r = sc.nextInt();
        int i , ch =1;
        for (i = 0; i < db.size(); i++) {
            if (db.get(i).getRoll() == r){
                break;
            }
        }
        while(ch!=0){
            System.out.println("1. roll no \n2. Name \n3. Marks \n4. Div \n0 for Back");
            System.out.println("Enter field you want to edit :");
            ch = sc.nextInt();
            switch (ch){
                case 1:{
                    db.get(i).setRoll();
                    break;
                }
                case 2:{
                    db.get(i).setname();
                    break;
                }
                case 3:{
                    db.get(i).setmarks();
                    break;
                }
                case 4:{
                    db.get(i).setdiv();
                    break;
                }
            }
        }


    }
    public void catalog(){
        open();
        Scanner sc = new Scanner(System.in);
        int ch = 1;
        while(ch != 0){
            System.out.println("1 . new student \n2. Display all students \n3. Search student \n4. Delete student data \n5.edit student data\n 0 for exit");
            System.out.print("Enter your choice : ");
            ch = sc.nextInt();
            switch (ch){
                case 1:{
                    Student s = new Student();
                    s.set();
                    db.add(s);
                    break;
                }
                case 2:{
                    System.out.println("Roll no    name     Div   Marks");
                    for (int i = 0; i < db.size(); i++) {
                        db.get(i).display();
                    }
                    break;
                }
                case 3:{
                    System.out.println("enter roll number to search : ");
                    int r = sc.nextInt();
                    for (int i = 0; i < db.size(); i++) {
                        if (db.get(i).getRoll() == r){
                            System.out.println("Roll no    name     Div   Marks");
                            db.get(i).display();
                            break;
                        }

                    }
//                        System.out.println("Student not found!!");
                    break;
                }
                case 4:{
                    System.out.println("enter roll number to delete : ");
                    int r = sc.nextInt();
                    for (int i = 0; i < db.size(); i++) {
                        if (db.get(i).getRoll() == r){
                            System.out.println("Roll no    name     Div   Marks");
                            db.get(i).display();
                            db.remove(i);
                            System.out.println("Student deleted ");
                        }
                        else {
                            System.out.println("Student not found!!");
                        }
                    }
                    break;
                }
                case 5:{
                    edit();
                    break;
                }
                case 0:{
                    close();
                }
            }
        }
    }


}
