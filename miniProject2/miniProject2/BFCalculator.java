package miniProject2;

import java.util.*;
import java.math.*;
import java.io.*;

public class BFCalculator 
{
    BigFraction currentResult;
    BigFraction[] registerList = new BigFraction[26];

    public BigFraction evaluate (String exp)
    {
        PrintWriter pen = new PrintWriter(System.out, true);
        String input[] = exp.split(" ");

        String[] numbers = new String[input.length / 2];
        String[] operators = new String[input.length / 2 + 1];

        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = input[i*2];
            if (i < numbers.length-1)
            {
                operators[i] = input[i*2+1];
            }
        }



        if (numbers.length > 1)
        {
            for (int j = 0; j < numbers.length-1; j++)
            {
                char register = numbers[j+1].charAt(0);
                BigFraction nextFraction;

                if(not a letter) // Create a function to check if it's not a letter later
                {
                    nextFraction = new BigFraction (numbers[j+1]);
                }
                else
                {
                    if (stored) // Create a function to check if it has been stored later
                    {
                        nextFraction = registerList[(int) register-97];
                    }
                }
                currentResult = Operator(this.currentResult, nextFraction, operators[j]);
            }
        }
        return (simplify(currentResult));
    }


    public BigFraction Operator(BigFraction fraction1, BigFraction fraction2, String operators)
    {
        BigFraction result = null;
        switch(operators)
        {
            case "+":
                result = fraction1.add(fraction2);
                break;

            case "-":
                 result = fraction1.subtract(fraction2);
                break;

            case "*":
                result = fraction1.multiply(fraction2);
                break;

            case "/":
                 result = fraction1.divide(fraction2);
                 break;
        }

        return result;
    }

    public void store (char register)
    {
        registerList[(int) register - 97] = this.currentResult;
    }
}




