package io.murad.String_Manipulation_and_Date_Problems.PART_A;

public class ProblemThree {

    public static void main(String[] args) {
        String extractedText = " 123/I New Boston Rood, Boston - 12132 ";
        String correctSpelling = extractedText.replace("Rood", "Road");
        String cleanedData = correctSpelling.trim();
        System.out.println("Cleaned Data " + "\"" + cleanedData + "\"");

    }
}
