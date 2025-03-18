package Day2;
import Template.Template;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day2 {

    public static void main(String[] args) {
        try {
            String day = "day2";
            List<String> inputLines = Template.readInputFile(day, "input.txt");

            if (args.length > 0) {
                inputLines = Template.readInputFile(day, "test.txt");
                System.out.println(day + " of Advent of Code 2024 - test input");
            } else {
                System.out.println(day + " of Advent of Code 2024");
            }

            //part1
            int funcA = Integer.parseInt(inputLines.get(0).split("ADD ")[1]);
            int funcB = Integer.parseInt(inputLines.get(1).split("MULTIPLY ")[1]);
            int funcC = Integer.parseInt(inputLines.get(2).split("OF ")[1]);

            ArrayList<Integer> qualitites = new ArrayList<>();
            for (int i = 4; i < inputLines.size(); i++) {
                int quality = Integer.parseInt(inputLines.get(i));
                qualitites.add(quality);
            }

            qualitites.sort(null);

            int median = qualitites.get(qualitites.size() / 2);

            long sum1 = calcPrice(median, funcA, funcB, funcC);
            System.out.println("Part 1: " + sum1);

            //part2
            int evenNumberedSum = 0;
            for (int i = 4; i < inputLines.size(); i++) {
                if (Integer.parseInt(inputLines.get(i)) % 2 == 0) {
                    evenNumberedSum += Integer.parseInt(inputLines.get(i));
                }
            }

            long sum2 = calcPrice(evenNumberedSum, funcA, funcB, funcC);
            System.out.println("Part 2: " + sum2);

            //part3
            long highestToAfford = 0;
            long maxPrice = 15000000000000L;
            
            for (int i = 4; i < inputLines.size(); i++) {
                long price = calcPrice(Integer.parseInt(inputLines.get(i)), funcA, funcB, funcC);
                if (price <= maxPrice && Integer.parseInt(inputLines.get(i)) > highestToAfford) {
                    highestToAfford = Integer.parseInt(inputLines.get(i));
                }
            }

            System.out.println("Part 3: " + highestToAfford);

        } catch (IOException e) {
            System.out.println("Error reading input file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static long calcPrice(int quality, int funcA, int funcB, int funcC) {
        // raise to the power of C
        long sum = (long) Math.pow(quality, funcC);
        // multiply by B
        sum *= funcB;
        // add A
        sum += funcA;
        return sum;
    }
}