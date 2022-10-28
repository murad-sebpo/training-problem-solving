
# Training Outline
### Training Outline Link - [Outline](https://github.com/sebpo1/scraping/discussions/26)


## Day 2 : Data Structures and Java Collections
### PART-1

1. Find all pairs of an integer array whose sum is equal to a given number.

[Solution](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/Data_Structures_and_Java_Collections/PART_1/ProblemOne.java)

2. Find the largest and smallest number in an unsorted integer array.

[Solution](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/Data_Structures_and_Java_Collections/PART_1/ProblemTwo.java)

3. How to find the length of a singly linked list?

[Solution](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/Data_Structures_and_Java_Collections/PART_1/ProblemThree.java)

4. How to count a number of vowels and consonants in a String?

[Solution](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/Data_Structures_and_Java_Collections/PART_1/ProblemFour.java)

5. Search for a (value) in a hash-map, and if presents return its key. Else return null.

[Solution](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/Data_Structures_and_Java_Collections/PART_1/ProblemFive.java)

6. How do you find the missing number in a given integer array of 1 to 100?

[Solution](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/Data_Structures_and_Java_Collections/PART_1/ProblemSix.java)

7. How do you find duplicate numbers in an array if it contains multiple duplicates?

[Solution](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/Data_Structures_and_Java_Collections/PART_1/ProblemSeven.java)

8. How do you reverse a linked list?

[Solution](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/Data_Structures_and_Java_Collections/PART_1/ProblemEight.java)

9. How do you count the occurrence of a given character in a string?

[Solution](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/Data_Structures_and_Java_Collections/PART_1/ProblemNine.java)


### PART-2
- Arrays (Linear/Circular and 2D-Arrays)

  [Implementation](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/Data_Structures_and_Java_Collections/PART_2/Arrays.java)

- List (ArrayList)

  [Implementation](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/Data_Structures_and_Java_Collections/PART_2/ArrayListImpl.java)

- Set (HashSet)

  [Implementation](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/Data_Structures_and_Java_Collections/PART_2/SetImpl.java)

- Map (HashMap)

  [Implementation](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/Data_Structures_and_Java_Collections/PART_2/MapIml.java)

- HashTable

  [Implementation](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/Data_Structures_and_Java_Collections/PART_2/HashTableImpl.java)

- Stacks

  [Implementation](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/Data_Structures_and_Java_Collections/PART_2/StackImpl.java)

- Queues

  [Implementation](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/Data_Structures_and_Java_Collections/PART_2/QueueImpl.java)

PART-3

Given an Integer Array, let's say int[ ] arr = {10, 32, 1, 8, 32, 92, 41,71,34,64,99}

i) Find the maximum and minimum value of the given array, making sure the line below is in the code System.out.println("The Max value is: " + findMaxValue(arr) + "and Min Value is: " + findMinValue(arr). Basically, you have to complete those 2 unimplemented methods. Cannot use built-in functions

[Solution](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/Data_Structures_and_Java_Collections/PART_3/ProblemOne.java)

ii) Convert the array to a List, and then print the List using enhanced for loop. Do it in a function called 'convertingToListAndPrint(int[] arr)

[Solution](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/Data_Structures_and_Java_Collections/PART_3/ProblemTwo.java)

Let's say this is an ArrayList:
groceryList = ["Eggs","Cheese","Chicken","Milk", "Beef", "Potato","Potato", "Carrot", "Eggs", "Eggs"]
Somehow, the user, noted down some elements twice

i) Implement the user groceryList in Java using ArrayList

ii) Remove the duplicate elements of the list, and print them using enhanced for loop.

iii) The user wants to make sure whether he wrote down Potato in his groceryList. Without using the brute force approach, create a method "isPotatoThere(...)" that returns true, if it exists, else false.

iv) The user realized he mistakenly wrote "Beef" instead of "Mutton". Update the shopping list. Make sure, you mention the line below in your code. System.out.println("The updated List are" + updatedArrayList(...))

[Solution](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/Data_Structures_and_Java_Collections/PART_3/ProblemThree.java)

Construct a dictionary (HashTable/HashMap any one of your wish), and print them. Each individual can have none, one or more than one address. Code for the given scenario, making the individual name as the unique key
-> Akib has 3 addresses = Mirpur, Dhanmondi, Shiddheshwari -> Sajeeb has 1 address = Lalmatia -> Niloy has 2 addresses = Puran Dhaka, Rajarbag -> Ratul lives abroad has no address

i) Construct the Dictionary, using the scenario above. ii) Print them such that the output is like this

Individual 1: Akib Address 1: Mirpur Address 2: Dhanmondi Address 3: Shiddheshwari

*The one with no address should show - "NO ADDRESS", but you cannot put 'NO ADDRESS' in the dictionary.

[Solution](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/Data_Structures_and_Java_Collections/PART_3/ProblemFour.java)



## String Manipulation and Date Problems

### PART-A

1. Given a String String cricketPlayers = "Shakib Al Hasan, Tamim Iqbal, Mashrafe Mortaza, Mushfiqur Rahim, Liton Das, Rubel Hossain"

i) Split 'cricketPlayers' and store in array called 'cricketPlayersArr'

ii) Some names in cricketPlayers, have more than one space in between their first and last name. Code such that, the names are separated by ONE SPACE only and print them
Output - Cricketer 1 - Shakib Al Hasan Cricketer 2 - Tamim Iqbal ...

[Solution](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/String_Manipulation_and_Date_Problems/PART_A/ProblemOne.java)


2. Given a String (str1), check whether the all the items contains in str1. String str1 = "Honda Porsche Mercedes Ford BMW Bentley Bugatti Toyota Audi Mazda Volswagen Lamborgini Renault Volvo"
   int[] items = ["honda","lexus","mazda","bentley","hyundai","jeep","chevrolet"]
   *Make sure it is CASE-INSENSITIVE

Output : Item 1: honda Inside str1 : true Item 2: lexus Inside str1 : false

[Solution](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/String_Manipulation_and_Date_Problems/PART_A/ProblemTwo.java)

3. While converting a PDF to TEXT using Optical Character Recognition, it mistook some characters for others. Furthermore, it added additional space at the start/end of the string. originalText = "123/I New Boston Road, Boston - 12132" extractedText = " 123/I New Boston Rood, Boston - 12132 "

Your job as a Web Scraper is to clean the data. But you have to use only 1 line of code to fix this. You CANNOT use the brute force approach (for/while loops) You CAN NOT write the entire String as that would be static. YOU ONLY have to FIX the spelling mistake, which is 'Rood' to 'Road', and delete the spaces in the first and last of the String.
Output: Cleaned Data "123/I New Boston Road, Boston - 12132"

[Solution](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/String_Manipulation_and_Date_Problems/PART_A/ProblemThree.java)

4. For a given String, print the frequency of each individual character. If such characters do not exist, for example - 'z', it won't print.

Output (Suppose) A: 19 times B : 3 times C: 2 times etc.
CASE-INSENSITIVE, so both lower and upper case will be regarded as one character. Modify the String as your wish.

[Solution](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/String_Manipulation_and_Date_Problems/PART_A/ProblemFour.java)

5. String dummyText = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."

i) How do you know if two Strings are equal? Use your own dummy-data/example.

[Solution](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/String_Manipulation_and_Date_Problems/PART_A/ProblemFive.java)

6. i) Capture the local machine date (Month-Day-Year (with leading zeros) format i.e 07/27/2020) using the Java Date API -You can refer to the documentation - https://docs.oracle.com/javase/8/docs/api/java/util/Date.html

ii) Compare the date you captured above, with 3 other dates below. Print their status, whether the given dates are in the PAST or FUTURE.

Convert String -> Date, if necessary.
String date1 = "03/22/1993" String date2 = "07/19/2022" String date3 = "01/01/2010"

[Solution](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/String_Manipulation_and_Date_Problems/PART_A/ProblemSix.java)


### PART-B

1. Take four strings : String name1 = “Taufiq” String name2 = “Tawheed” String name3 = “Tanveer” String name4 = “Taufiq” If two Strings are equal, then print them. Output: Name1 and Name4 matches. And the name is = Taufiq (You can Use your own dummy-data/example.)

[Solution](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/String_Manipulation_and_Date_Problems/PART_B/ProblemOne.java)

2. Convert Exponential number to integer/ floating-point number
   Given, 1.2345986E9 (exponential number), Convert it to 1.2345986

[Solution](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/String_Manipulation_and_Date_Problems/PART_B/ProblemTwo.java)

3. Given, a name list: nameList = [“AFT Logistics, LLC n/k/a Equity One Contractors LLC", “BlueChip Financial d/ b/a Spotloan”, “Huhn, Douglas Joseph, Jr.”] i) You have to split the alias from the name and print the name and alias. Split alias when “n/k/a” or “f/k/a” or “d/b/a” follows the name. ii) You have to remove (Jr./Sr.) from the name. Output: Name = AFT Logistics, LLC Alias = Equity One Contractors LLC Name = BlueChip Financial Alias = Spotloan Name = Huhn, Douglas Joseph

[Solution](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/String_Manipulation_and_Date_Problems/PART_B/ProblemThree.java)


4. Java Date API Get local machine Date How to compare between dates (past/future dates using built-in methods) Date formats mm/dd/yyyy dd/MM/YYYY Month/Day/Year with leading zero’s - 16/07/2020 Day/Month/Year with leading zero's - 07/16/2020
   Print date if it is not before 1900, 15/04/1754 20-04-2009 16-dec-1971 18/09/1856

[Solution](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/String_Manipulation_and_Date_Problems/PART_A/ProblemSix.java)

## 14 Regex problems

1. Count duplicate words in a sentence|file|string block input.

in : "he he goes to school"\
out: he: 2, goes: 1, school: 1

[Solution](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/Regex_problems/ProblemOne.java)

2. Check whether an email address is valid or not.

in : x@x.com out: valid\
in : x@x out: invalid\
in : x@x.com.bd.gov out: valid\
in : x.x@x.com out: valid\
in : ~x@x.com out: invalid\
in : "x@"x.com out: invalid

[Solution](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/Regex_problems/ProblemTwo.java)

3. Make a Ip(v4) address validator method.

in : 10.10.10.10 out: valid\
in : 310.10.10.10 out: invalid\
in : 255.10.10.10 out: valid\
in : 2555.10.10.10 out: invalid

[Solution](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/Regex_problems/ProblemThree.java)

4. Check if given time format is valid or not. Format: hh:mm:ss [12 hrs]

in : 12.59.59 out: valid\
in : 12.60.59 out: invalid

[Solution](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/Regex_problems/ProblemFour.java)

5. Check if given date format is valid or not. Format: dd/mm/yyyy [yyyy is valid upto 2014]

in : 12/12/1212 : valid\
in : 12/13/1212 : invalid\
in : 12/12/12122 : invalid\
in : 32/12/1212 : invalid

[Solution](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/Regex_problems/ProblemFive.java)

6. Check whether a HTML block is unique in a HTML file|string block input.

str: "<<div>>..<//div><<div>>..<//div><<p>>..<//p>"\
in : div out: duplicate\
in : p out: unique\
do this with java regex besides ur regex learning

[Solution](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/Regex_problems/ProblemSix.java)

7. Validate "Day and month" format
in : 2/29 out: invalid
in : 1/30 out: invalid

[Solution](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/Regex_problems/ProblemSeven.java)

8. Only match constant in a set using "char set intersection"

[Solution](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/Regex_problems/ProblemEight.java)

9. Match all odd numbers in a string containing both numbers and non numbers
in: abcd12XY15c1552d13 out:15,13

[Solution](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/Regex_problems/ProblemNine.java)

10. Match all words where 1st and last char is same\
in: all ala imi out: ala imi

[Solution](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/Regex_problems/ProblemTen.java)

11. Match all words that contain at least one same uppercase and a lowercase letter\
in: "Mam Did You tesT alL Students"\
out: "Mam Did tesT alL Students"

[Solution](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/Regex_problems/ProblemEleven.java)

12. Match all string(words)where theres no sub-string "ab"
in abad acdd adabdd\
out acdd

[Solution](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/Regex_problems/ProblemTwelve.java)

13. Match all strings/words that have exactly 3 'b' in total

in: "abba abbab baba"\
out: "abbab"

[Solution](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/Regex_problems/ProblemThirteen.java)

14. how to compare two date, which one is greater
01.11.2014 31.10.2019

[Solution](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/Regex_problems/ProblemFourteen.java)

## Java IO File Problems

### One
Create a text file ‘SEBPO.txt’. Write something in the text file. And read the content of the file.
Read a CSV file from the desktop. Print the content of the CSV files.
Suppose you have 10 text files on your computer. Read the content of the 10 text files and print it.
Create a text file (.txt) using any of your preferred Java File IO methods on your desktop under the folder named ‘Java File I/O Problems’. Make sure you name the file – “ListOfCountries.txt” Tasks – • Copy the dummy text below, paste it as a String in your IDE. String dummyText = “Bangladesh India Bhutan Russia China Mongolia France Italy Germany hungary Turkey Egypt Mexico Romania ethiopia “; • Under a method called, “storeDataToFile(…)”. Store the dummy data in a text file (.txt) which you will create – “ListOfCountries.txt”, such that each country occupies each separate line. [Pre-process the data, using your knowledge of String Manipulation where necessary. Furthermore, there are some countries, whose first letter does not start with an Upper-case, fix this issue.]
After viewing from the notepad app on the desktop, it will show something like this. View from Notepad app Bangladesh India Bhutan Etc.

• Create a method called, ‘printDataFromFile()’ which prints the data from the file you created in step II, in a sequential manner in the console.
Console Output :

Bangladesh\
India\
Bhutan etc. 

[Solution](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/Java_IO_File_Problems/AdvancedJavaIOFileProblems.java)

### Two
Retrieve the data in such a way, from the following 3 files (Data1.xls, Data2.xlsx, Data3.csv). All of them contains the same data, but in different formats. The name of your java class will be = XLSHandler.java, XLSXHandler.java, CSVHandler.java respectively. YOU ARE NOT ALLOWED TO CHANGE THE FORMAT OF THE FILES Tasks – You will be creating 2 methods (printRowWise(), printColumnWise()) to print in a specific manner, for the 3 classes mentioned above. • printRowWise() – This will print the file in a row-wise manner e.g : 1st entry: Name : John Country : USA .. etc.

2nd entry: Name : Michael Country: Italy ...etc.

[Solution](https://github.com/murad-sebpo/training-problem-solving/tree/master/Reading_XLS_CSV_using_Maven)

## GET - POST method creation with Java

### Extract Data from URL using GET method
[Implementation](https://github.com/murad-sebpo/training-problem-solving/blob/master/src/io/murad/GET_POST_method_creation_with_Java/GETMethodPractice.java)
