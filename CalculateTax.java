// TC: O(n)
// SC: O(1)

import java.util.*;

public class CalculateTax {

    public static double calculateTax(List<List<Double>> levels, double salary) {
        int n = levels.size();
        double tax = 0;
        double prev = 0;
        for (int i = 0; i < n && salary > 0; i++) {
            if (levels.get(i).get(0) == null) {
                tax += salary * levels.get(i).get(1);
                return tax;
            }
            double taxableIncome = Math.min(salary, levels.get(i).get(0) - prev);
            tax += taxableIncome * levels.get(i).get(1);
            salary -= taxableIncome;
            prev = levels.get(i).get(0);
        }
        return tax;
    }

    public static void main(String[] args) {
        List<List<Double>> levels = new ArrayList<>();
        levels.add(Arrays.asList(10000.0, 0.3));
        levels.add(Arrays.asList(20000.0, 0.2));
        levels.add(Arrays.asList(30000.0, 0.1));
        levels.add(Arrays.asList(null, 0.1));
        double tax = calculateTax(levels, 45000);
        System.out.println(tax);
    }

}