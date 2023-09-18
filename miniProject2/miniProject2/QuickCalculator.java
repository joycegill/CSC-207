package miniProject2;

import java.io.PrintWriter;

public class QuickCalculator 
{
    public static void main (String [] args) throws Exception
    {
        BFCalculator calc = new BFCalculator();
        PrintWriter pen = new PrintWriter(System.out, true);

        // Traverse through command line argument
        for(int i = 0; i < args.length; i++)
        {
            String current = args[i];

            // Store
            if(current.contains("STORE"))
            {
                String arr[] = current.split(" ");
                if(arr.length == 2)
                {
                    char register[] = arr[1].toCharArray();

                    // Correct variable name and type
                    if(register.length == 1)
                    {
                        calc.store(register[0]);
                    }

                    // Incorrect variable type
                    else
                    {
                        throw new Exception("Error: incorrect variable type");
                    }
                }

                // Incorrect number of inputs
                else
                {
                    throw new Exception("Error: incorrect number of inputs");
                }
            }

            // Evaluate
            else
            {
                BigFraction result = calc.evaluate(current);
                pen.println(result);
            }
        }
    }
}
