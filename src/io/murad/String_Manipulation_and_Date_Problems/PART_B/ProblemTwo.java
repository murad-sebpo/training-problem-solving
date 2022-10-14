package io.murad.String_Manipulation_and_Date_Problems.PART_B;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Formatter;

public class ProblemTwo {

    public static void main(String[] args) {
        BigInteger exNumber = new BigDecimal("1.2345986E9").toBigInteger();
        System.out.println(exNumber);

//        BigDecimal bd = new BigDecimal("1.2345986E9");
        double val = 1.2345986E9;




        BigDecimal bd =new BigDecimal(val).setScale(6, RoundingMode.UP);
        System.out.println(bd.floatValue());

        Formatter formatter = new Formatter();
        Formatter sfd = formatter.format("%.2f", val);
        System.out.println(sfd.toString());


    }
}
