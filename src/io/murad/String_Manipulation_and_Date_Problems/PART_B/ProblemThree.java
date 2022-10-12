package io.murad.String_Manipulation_and_Date_Problems.PART_B;

public class ProblemThree {
    public static void main(String[] args) {
        String[] nameList = {"AFT Logistics, LLC n/k/a Equity One Contractors LLC",
                "BlueChip Financial d/ b/a Spotloan", "Huhn, Douglas Joseph, Jr."};

        for (int i = 0; i < nameList.length; i++) {
            String[] outputName = nameList[i].split("n/k/a|f/k/a|d/b/a");

//            String name = outputName[0];
//            String alias = outputName[1];
              int index = 0;
            for(String namee : outputName){

                if (namee.contains("Jr.") || namee.contains("Sr.")) {
                    System.out.printf("Index: %d, Element: %s\n", index++, namee);
                    System.out.println("Name = " + namee.replace("Jr.", " ") + " Alias = " );
                } else {
                    System.out.println("Name = " + namee.trim() + " Alias = " );
                }

            }



        }

    }

}
