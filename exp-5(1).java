import java.util.*;

public class Main {

    
    public static int calculateSum(List<Integer> numbers) {
        int sum = 0;
        for (Integer num : numbers) {
            sum += num; // Unboxing happens here (Integer to int)
        }
        return sum;
    }

   
    public static Integer parseInteger(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) {
        
        List<String> stringNumbers = Arrays.asList("10", "20", "30", "40", "50");

        
        List<Integer> integers = new ArrayList<>();

       
        for (String str : stringNumbers) {
            integers.add(parseInteger(str)); 
        }

        
        int sum = calculateSum(integers);
        
        
        System.out.println("Sum of the integers: " + sum);
    }
}
// OUTPUT:
//Sum of the integers: 150
