import java.util.Scanner;

public class WaterBottles{

    public static int numWaterBottles(int numBottles, int numExchange) {
      int total = numBottles;
      int empties = numBottles;

      while(empties >= numExchange){
        int newFull = empties / numExchange;
        total += newFull;
        empties = newFull + (empties % numExchange); 
      }
      return total;
    }

    public static void main(String[] args) {
        int numBottles;
        int numExchange;

        Scanner sc = new Scanner(System.in);

        System.out.println("enter number of bottles");
        numBottles = sc.nextInt();
        System.out.println("enter exchange rate");
        numExchange = sc.nextInt();

        int res = numWaterBottles(numBottles, numExchange); 

        System.out.println("Total Bottles are:" + res);
        
        sc.close();
    }
}