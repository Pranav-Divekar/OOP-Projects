import java.util.*;
import java.lang.*;
class conversion
{
    public static void convertstr(int num)
        {   int[] binary1 = new int[4];
            StringBuilder bin = new StringBuilder();
            int n= num ;
            int i=0;
            while(n>0)
            {

            if(n%2==0)
            {
                 binary1[i++] = 0;
                    bin.append("0");
                 n=n/2;

            }
            else
            {
                 binary1[i++] = 1;
                bin.append("1");
                  n=n/2;
            }

        }
        //StringBuilder reverseStr = bin.reverse();
        System.out.println("The decimal number "+num+" is in Binary :"+bin.reverse().toString());
    }
    public static void main(String args[])
    {
        Scanner sc  = new Scanner(System.in);
        System.out.println("Enter the decimal number : ");
        int no = sc.nextInt();

     convertstr(no);
    sc.close();
    }
}