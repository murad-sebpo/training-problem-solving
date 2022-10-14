package io.murad.String_Manipulation_and_Date_Problems.PART_B;

public class ProblemThree {
    public static void main(String[] args) {
        String[] nameList = {"AFT Logistics, LLC n/k/a Equity One Contractors LLC",
                "BlueChip Financial d/b/a Spotloan", "Huhn, Douglas Joseph, Jr."};

        for (String name : nameList) {
            String[] nameSplitArray = name.split("n/k/a|f/k/a|d/b/a");

            if (nameSplitArray.length == 2) {
                System.out.println("Name = " + nameSplitArray[0] + " Alias = " + nameSplitArray[1]);
            } else if (nameSplitArray.length == 1) {
                if (nameSplitArray[0].contains("Jr.")) {
                    System.out.println("Name = " + nameSplitArray[0].replace("Jr.", ""));
                } else if (nameSplitArray[0].contains("Sr.")) {
                    System.out.println("Name = " + nameSplitArray[0].replace("Sr.", ""));
                }
            }

        }

    }

}
