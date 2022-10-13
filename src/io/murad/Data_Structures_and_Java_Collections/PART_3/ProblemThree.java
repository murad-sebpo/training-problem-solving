package io.murad.Data_Structures_and_Java_Collections.PART_3;


import java.util.*;

/**
 * ii) Convert the array to a List, and then print the List using enhanced for loop.
 * Do it in a function called convertingToListAndPrint(int[] arr)
 * <p>
 * Let's say this is an ArrayList:
 * groceryList = ["Eggs","Cheese","Chicken","Milk", "Beef", "Potato","Potato", "Carrot", "Eggs", "Eggs"]
 * Somehow, the user, noted down some elements twice
 * i) Implement the user groceryList in Java using ArrayList
 * ii) Remove the duplicate elements of the list, and print them using enhanced for loop.
 * iii) The user wants to make sure whether he wrote down Potato in his groceryList.
 * Without using the brute force approach, create a method "isPotatoThere(...)" that returns true, if it exists, else false.
 * iv) The user realized he mistakenly wrote "Beef" instead of "Mutton". Update the shopping list.
 * Make sure, you mention the line below in your code. System.out.println("The updated List are" + updatedArrayList(...))
 */
public class ProblemThree {
    public static <T> List<T> removeDuplicates(List<T> groceryList) {
        List<T> newGroceryList = new ArrayList<T>();

        for (T grocery : groceryList) {
            if (!newGroceryList.contains(grocery)) {
                newGroceryList.add(grocery);
            }
        }
        return newGroceryList;
    }

    static void isPotatoThere(List<String> groceryList, String groceryName) {
        if (groceryList.contains(groceryName)) {
            System.out.println("Is " + groceryName + " available on the list: " + true);
        } else {
            System.out.println("Is " + groceryName + " Grocery available on the list: " + false);
        }
    }

    static List<String> updatedArrayList(List<String> gList, String currentGroceryName, String updateGroceryName) {
        if (gList.contains(currentGroceryName)) {
            int indexCurrentGroceryName = gList.indexOf(currentGroceryName);
            gList.set(indexCurrentGroceryName, updateGroceryName);
        } else {
            System.out.println("Grocery doesn't available");
        }

        return gList;

    }

    public static void main(String[] args) {

        List<String> groceryList = List.of("Eggs", "Cheese", "Chicken", "Milk", "Beef", "Potato", "Potato", "Carrot", "Eggs", "Eggs");

        List<String> groceryListWithoutDuplicate = removeDuplicates(groceryList);

        //Grocery List without duplicates
        groceryListWithoutDuplicate.forEach((groceryListWD -> {
            System.out.println(groceryListWD);
        }));

        isPotatoThere(groceryList, "Potato");

        List<String> listOfGrocery = new ArrayList<>(groceryList);
        // Updated Grocery List
        System.out.println("The updated List are " + updatedArrayList(listOfGrocery, "Beef", "Mutton"));

    }
}
