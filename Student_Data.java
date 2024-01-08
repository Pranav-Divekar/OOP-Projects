import java.util.*;
class Student
{
    String name;
    int[] marks=new int[5];
    int roll;

    public void set_data(int roll,String name,int[] marks)
    {
        this.name = name;
        this.roll = roll;
        for(int i=0;i<5;i++)
        {
            this.marks[i] = marks[i];
        }
    }
    public void get_data()
    {
        System.out.println("Name is : "+name);
        System.out.println("ID is : "+roll);
    }

    public void averageMarks()
    {   int sum=0;
        for(int i=0;i<5;i++)
        {
            sum += marks[i];
        }
        System.out.println("Average marks are : "+(sum/5));

    }

}
class Student_Data
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Student s1 = new Student();
        System.out.println("Enter name of Student : ");
        String name = sc.nextLine();
        System.out.println("Enter ID of Student : ");
        int id = sc.nextInt();
        System.out.println("Enter marks of 5 Subject ");
        int[] marks = new int[5];
        for(int j=0;j<5;j++)
        {
            marks[j]=sc.nextInt();
        }
        s1.set_data(id,name,marks);
        s1.get_data();
        s1.averageMarks();
        sc.close();

    }
}