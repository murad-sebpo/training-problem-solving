package io.murad.Data_Structures_and_Java_Collections.PART_2;


import javax.xml.parsers.SAXParser;

/**
 *
 * Arrays (Linear/Circular and 2D-Arrays)
 *
 */
public class Arrays {

    public static  void main(String[] args){
        //Linear Array
        int[] ages = {32,34,56,76,78,58,39};
        for(int age : ages){
            System.out.println("Age List: " + age);
        }

        // Print the index 4
        System.out.println(ages[4]);

        // Print in reverse order
        for(int i = ages.length-1; i >= 0; i--){
            System.out.println("Age List in Reverse Order: " + ages[i]);
        }

        double[] salaries = new double[10];
        salaries[0] =  55000.46;
        salaries[1] =  15000.73;
        salaries[2] =  25000.59;
        salaries[3] =  35000.16;
        salaries[4] =  45000.96;

        for(double salary : salaries){
            System.out.println("Salary: "  + salary);
        }

        // 2D Array
        int[][] twoDArray = {
                {34,65,67,21,23},
                {78,12,90,45,76}
        };

        for(int[] array : twoDArray){
            for(int arr : array){
                System.out.print(arr + "\t");
            }
            System.out.println();
        }

        String str = "BanglaDesh";
        String reverse = String.valueOf(new StringBuffer(str).reverse());
        System.out.println(reverse);
    }
}
