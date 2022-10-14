package io.murad.String_Manipulation_and_Date_Problems.PART_B;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ProblemTwo {

    public static void main(String[] args) {
        BigInteger exNumber = new BigDecimal("1.2345986E9").toBigInteger();
        System.out.println(exNumber);

        BigDecimal bd = new BigDecimal("1.2345986E9");
        double val = 1.2345986E9;
        System.out.println(BigDecimal.valueOf(val));
        BigDecimal intv = BigDecimal.valueOf(val);
        float exNumber2 = new BigDecimal(String.valueOf(intv)).floatValue();
        System.out.println(exNumber2);
        System.out.println(Math.abs(val));
         double val2 = bd.doubleValue();
        System.out.println();

        BigDecimal bigDecimal = BigDecimal.valueOf(val);
        float valt = bigDecimal.floatValue();
        System.out.println(valt);

        System.out.printf("%.8f",val);

        BigDecimal value = new BigDecimal(val);
        System.out.println(value.setScale(6));
    }
}
