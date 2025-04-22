import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        float[] profit = new float[20];
        float[] weight = new float[20];
        float[] ratio = new float[20];
        int capacity, num, i, j;
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter the number of items: ");
        num = sc.nextInt();
        System.out.println("Enter the capacity of the knapsack: ");
        capacity = sc.nextInt();
        System.out.println("Enter the profit and weight of each item: ");
        for (int k = 0; k < num; k++) {
            profit[k] = sc.nextFloat();
            weight[k] = sc.nextFloat();
            ratio[k] = profit[k] / weight[k];
        }
        // Sort items based on profit-to-weight ratio in descending order
        for( i=0;  i<num; i++){
            for( j=i+1; j<num; j++){
                if(ratio[i]<ratio[j]){
                    float temp = ratio[i];
                    ratio[i] = ratio[j];
                    ratio[j] = temp;

                    temp = profit[i];
                    profit[i] = profit[j];
                    profit[j] = temp;

                    temp = weight[i];
                    weight[i] = weight[j];
                    weight[j] = temp;
                }
            }  
        }
        FracKnapsack.knapsack(profit, weight, capacity, num);
    }
}
