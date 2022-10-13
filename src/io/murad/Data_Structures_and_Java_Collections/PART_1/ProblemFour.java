package io.murad.Data_Structures_and_Java_Collections.PART_1;

public class ProblemFour {

    public static void main(String[] args) {
        String text = "INDUSTRY LEADING PROFESSIONAL SERVICES FOR ADVERTISING, MEDIA & TECH".toLowerCase();

        char[] convertedStringToCharArray = text.toCharArray();
        int vowelCount = 0;
        int consonantCount = 0;
        for(int i = 0; i < convertedStringToCharArray.length; i++){
            if(convertedStringToCharArray[i] == 'a' || convertedStringToCharArray[i] == 'e' || convertedStringToCharArray[i] == 'i' || convertedStringToCharArray[i] == 'o' || convertedStringToCharArray[i] == 'u'){
                vowelCount++;
            }else if(convertedStringToCharArray[i] >= 'a' && convertedStringToCharArray[i] <= 'z'){
                consonantCount++;
            }
        }

        System.out.println("Vowels quantity in this String: " + vowelCount);
        System.out.println("Consonants quantity in this String: " + consonantCount);
    }
}
