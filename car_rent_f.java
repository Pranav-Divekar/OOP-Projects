import java.util.*;
import java.io.*;

class Car_Details
{
    String number;
    String brand;
    String model_name;
    String type;
    //sux,hatchback,sedan,off-road,premium,sports
    int no_of_seats;

     public Car_Details(String s)
    {  
    }

    public Car_Details() {
        this.number = "";
        this.brand = "";
        this.model_name = "";
        this.type = "";
        this.no_of_seats = 0;
    }

    public Car_Details(String number1, String brand1, String model_name1, String type1, int no_of_seats1) {
        this.number = number1;
        this.brand = brand1;
        this.model_name = model_name1;
        this.type = type1;
        this.no_of_seats = no_of_seats1;
    }

    public Car_Details(Car_Details c1) {
        this.number = c1.number;
        this.brand = c1.brand;
        this.model_name = c1.model_name;
        this.type = c1.type;
        this.no_of_seats = c1.no_of_seats;
    }

    public void display() {
        System.out.println("------------------------------------------------------------");
        System.out.println("Number : " + this.number);
        System.out.println("Brand : " + this.brand);
        System.out.println("model : " + this.model_name);
        System.out.println("type : " + this.type);
        System.out.println("Number of seats : " + this.no_of_seats);
        System.out.println("------------------------------------------------------------");
    }
}

class search_car extends Car_Details {
    public void search() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the car number to search:");
        String searchNumber = sc.next();

        if (searchNumber.equals(this.number)) {
            this.display();
        } else {
            System.out.println("Car not found.");
        }
    }
}

class Rent_Car extends Car_Details {
    int rentalPrice;
    boolean isRented;

    public Rent_Car(Car_Details c1, int rentalPrice) {
        super(c1);
        this.rentalPrice = rentalPrice;
        this.isRented = false;
    }

    public void rent() {
        if (!isRented) {
            isRented = true;
            System.out.println("You have rented car: " + this.brand + " " + this.model_name);
        } else {
            System.out.println("This car is already rented.");
        }
    }
}

class car_rent_f {
    public static void main(String args[]) {
        int n;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("------------------------------------------------------------");
            System.out.println("Enter the choice");
            System.out.println("1. Add a new car to database.");
            System.out.println("2. Search for a car in database.");
            System.out.println("3. Rent a car from database.");
            System.out.println("4. Upload data from details.txt file");
            System.out.println("5. Display all available cars");
            System.out.println("0. Exit");
            System.out.println("------------------------------------------------------------");
            System.out.print("Your choice : ");
            n = sc.nextInt();

            switch (n) {
                case 1:
                    Car_Details c1 = new Car_Details();
                    System.out.println("Enter rental price for this car:");
                    int rentalPrice = sc.nextInt();
                    Rent_Car c2 = new Rent_Car(c1, rentalPrice);
                    break;

                case 2:
                    search_car s1 = new search_car();
                    s1.search();
                    break;

                case 3:
                    Rent_Car r1 = new Rent_Car(new Car_Details(), 0);
                    r1.rent();
                    break;

                
                    case 4:
                    try {
                        File f = new File("details.txt");
                        Scanner Reader = new Scanner(f);
                        List<Rent_Car> rentCars = new ArrayList<>();
                        while (Reader.hasNextLine()) {
                            String line = Reader.nextLine();
                            String[] values = line.split("\\s+");
                
                            Car_Details c4 = new Car_Details(values[0], values[1], values[2], values[3], Integer.parseInt(values[4]));
                            System.out.println("Enter rental price for this car:");
                            int rentalPrice2 = sc.nextInt();
                            Rent_Car c3 = new Rent_Car(c4, rentalPrice2);
                            rentCars.add(c3);
                        }
                        for (Rent_Car rc : rentCars) {
                            rc.display();
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    // Display all available cars
                    break;
            }
        } while (n != 0);

        sc.close();
    }
}