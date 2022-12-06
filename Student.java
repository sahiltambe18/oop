import java.io.Serializable;
import java.util.Scanner;

public class Student implements Serializable {
    private String name , div ;
    private int marks , roll;



    public void set(){
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        System.out.print("enter roll number : ");
        this.roll = sc.nextInt();
        System.out.print("\nenter name : ");
        this.name = sc1.nextLine();
        System.out.print("\nenter Division : ");
        this.div = sc.next();
        System.out.print("\nenter marks : ");
        this.marks = sc.nextInt();
    }
    public void display(){
        System.out.println(roll+"     "+name+"      "+div+"     "+marks);
    }

    public void setRoll() {

        Scanner sc1 = new Scanner(System.in);
        System.out.print("enter roll number : ");
        this.roll = sc1.nextInt();
    }
    public void setdiv() {
        Scanner sc1 = new Scanner(System.in);
        System.out.print("enter division : ");
        this.div = sc1.next();
    }
    public void setname() {
        Scanner sc1 = new Scanner(System.in);
        System.out.print("enter name : ");
        this.name = sc1.next();
    }
    public void setmarks() {
        Scanner sc1 = new Scanner(System.in);
        System.out.print("enter marks : ");
        this.marks = sc1.nextInt();
    }

    public String getName() {
        return name;
    }

    public String getDiv() {
        return div;
    }

    public int getMarks() {
        return marks;
    }

    public int getRoll() {
        return roll;
    }
}
