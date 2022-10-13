package io.murad.Data_Structures_and_Java_Collections.PART_2;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * Set (HashSet)
 *
 */
public class SetImpl {

    public static void main(String[] args) {
        Set<PLanguage> programmingLanguages = new HashSet<>();
        programmingLanguages.add(new PLanguage("Java", 1995));
        programmingLanguages.add(new PLanguage("Groovy", 2003));
        programmingLanguages.add(new PLanguage("Kotlin",2011));
        programmingLanguages.add(new PLanguage("Javascript",1995));
        programmingLanguages.add(new PLanguage("Python",1991));

        programmingLanguages.forEach(pLanguage -> {
            System.out.println(pLanguage.getLangName() + " first appeared in " + pLanguage.getReleaseYear());
        });
    }
}
