import java.util.*;
class Car_Details
{
    String number;
    String brand;
    String model_name;
    String type;
    //sux,hatchback,sedan,off-road,premium,sports
    int no_of_seats;
// Normal Function
    public Car_Details()
    {   System.out.println("This is default constructor object");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Registration number of car : ( no spaces :) )");
        this.number = sc.next();
         System.out.println("Enter brand name of the car : ");
        this.brand = sc.next();
        System.out.println("Enter model name of the car : ");
        this.model_name = sc.next();
        System.out.println("Enter type of car : Suv,Hatchback,Sedan,Off-road,Premium,Sports etc..");
        this.type = sc.next();
        System.out.println("Enter number of seats car has : ");
        this.no_of_seats = sc.nextInt();

    }
//Parameterized Function
    public Car_Details(String number1,String brand1,String model_name1,String type1,int no_of_seats1)
    {
        System.out.println("This is parameterized constructor object");
        this.number = number1;
        this.brand = brand1;
        this.model_name = model_name1;
        this.type = type1;
        this.no_of_seats =no_of_seats1;

    }

     public Car_Details(Car_Details c1)
    {
        System.out.println("This is copy constructor object");
         this.number = c1.number;
         this.brand = c1.brand;
         this.model_name = c1.model_name;
         this.type = c1.type;
         this.no_of_seats =c1.no_of_seats;

         System.out.println("number of car using copy constructor : "+this.number);
    }
    public void display()
    {
        System.out.println("------------------------------------------------------------");
        System.out.println("Number : "+this.number);
        System.out.println("Brand : "+this.brand);
        System.out.println("model : "+this.model_name);
        System.out.println("type : "+this.type);
        System.out.println("Number of seats : "+this.no_of_seats);
        System.out.println("------------------------------------------------------------");
    }


}
class car_rental_system
{
    public static void main(String args[])
    {
        int n;
         Scanner sc=new Scanner(System.in);
        do
        {
            System.out.println("------------------------------------------------------------");
            System.out.println("Enter the choice");
            System.out.println("1.Add a new car to database.");
            System.out.println("2.Search for a car in database.");
            System.out.println("3.Rent a car from database.");
            System.out.println("4.Exit");
            System.out.println("------------------------------------------------------------");
            System.out.print("Your choice : ");
            n=sc.nextInt();
            switch(n)
            {
                case 1:
                Car_Details c1 = new Car_Details();
                Car_Details c2 = new Car_Details("MH14GD6556","TATA","HARRIER","SUV",6);
              //  c1.display();
                c2.display();
                Car_Details c3 = new Car_Details(c2);
                c3.display();
                 Car_Details c4 = new Car_Details();
                 c4 = c2;
                 c4.display();

       // Car_Details cd = new Car_Details();
       // cd.add_car();
        break;
            }
        }
        while(n!=4);

        sc.close();

    }
}