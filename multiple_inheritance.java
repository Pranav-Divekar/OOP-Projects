interface parent1 
{
   public void parent1method();
}
interface parent2
{
   public  void parent2method();
}
class multiple_inheritance implements parent1,parent2
{   public void parent1method()
    {
        System.out.println("parent 1 method");
    }

    public void parent2method()
    {
        System.out.println("parent 2 method");
    }
    public static void main(String args[])
    {   multiple_inheritance m1  = new multiple_inheritance();
        m1.parent1method();
        m1.parent2method();

    }

}