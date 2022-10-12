package io.murad.String_Manipulation_and_Date_Problems.PART_A;

/**
 * Given a String (str1), check whether the all the items contains in str1.
 * String str1 = "Honda Porsche Mercedes Ford BMW Bentley Bugatti Toyota Audi Mazda Volswagen Lamborgini Renault Volvo"
 * int[] items = ["honda","lexus","mazda","bentley","hyundai","jeep","chevrolet"]
 * *Make sure it is CASE-INSENSITIVE
 * Output : Item 1: honda Inside str1 : true Item 2: lexus Inside str1 : false
 */
public class ProblemTwo {

//    public static String ignoreCase(String str,String str2) {
//        str.toUpperCase().equals(str2.toUpperCase());
//        return str;
//    }

    public static void main(String[] args) {
        String str1 = "Honda Porsche Mercedes Ford BMW Bentley Bugatti Toyota Audi Mazda Volswagen Lamborgini Renault Volvo".toLowerCase();
        String[] items = {"honda", "lexus", "mazda", "bentley", "hyundai", "jeep", "chevrolet"};

//        String[] newString = str1.split(" ");

        for (int i = 0; i < items.length; i++) {
            if (str1.contains(items[i])) {
                System.out.print("Item " + i + ":" + items[i] + " Inside str1: " + true);
                System.out.println(" ");
            } else {
                System.out.print("Item " + i + ":" + items[i] + false);
                System.out.println(" ");
            }
        }

    }
}
