package io.murad.Data_Structures_and_Java_Collections.PART_2;

public class PLanguage {
    private String langName;
    private int releaseYear;
    public PLanguage(String name,int relYear){
        this.langName = name;
        this.releaseYear = relYear;
    }

    public String getLangName() {
        return langName;
    }

    public int getReleaseYear() {
        return releaseYear;
    }
}
