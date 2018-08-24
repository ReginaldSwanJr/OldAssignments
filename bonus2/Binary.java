
/**
 * Write a description of class Binary here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Binary
{
   public static void main(String[] args){
       binary(156);
   }
   
   public static void binary(int num){
       if(num > 0){
           binary(num/2);
           System.out.print(num % 2 + "");
       }
   }
   
}
