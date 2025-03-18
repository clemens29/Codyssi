package Day1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Template.Template;

public class Day1 {

    public static void main(String[] args) {
        try {
            String day = "day1";
            List<String> inputLines = Template.readInputFile(day, "input.txt");

            if (args.length > 0) {
                inputLines = Template.readInputFile(day, "test.txt");
                System.out.println(day + " of Codyssi 2025 - test input");
            } else {
                System.out.println(day + " of Cosyssi 2025");
            }

            // part1
            String symbols = inputLines.get(inputLines.size() - 1);
            int sum1 = Integer.parseInt(inputLines.get(0));
            for (int i = 1; i < inputLines.size() - 1; i++) {
                if (symbols.charAt(i-1) == '+') {
                    sum1 += Integer.parseInt(inputLines.get(i));
                } else {
                    sum1 -= Integer.parseInt(inputLines.get(i));
                }
            }
            System.out.println("Part 1: " + sum1);

            // part2
            int sum2 = Integer.parseInt(inputLines.get(0));
            for (int i = 1; i < inputLines.size() - 1; i++) {
                if (symbols.charAt(inputLines.size()-i-2) == '+') {
                    sum2 += Integer.parseInt(inputLines.get(i));
                } else {
                    sum2 -= Integer.parseInt(inputLines.get(i));
                }
            }
            System.out.println("Part 2: " + sum2);

            // part3
            int sum3 = Integer.parseInt(inputLines.get(0) + inputLines.get(1));
            int j = 1;
            for (int i = 2; i < inputLines.size() - 2; i+=2) {
                if (symbols.charAt(inputLines.size()-j-2) == '+') {
                    sum3 += Integer.parseInt(inputLines.get(i) + inputLines.get(i+1));
                } else {
                    sum3 -= Integer.parseInt(inputLines.get(i) + inputLines.get(i+1));
                }
                j++;
            }
            System.out.println("Part 3: " + sum3);

        } catch (IOException e) {
            System.out.println("Error reading input file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}