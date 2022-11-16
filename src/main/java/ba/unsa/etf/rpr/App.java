package ba.unsa.etf.rpr;

import static ba.unsa.etf.rpr.ExpressionEvaluator.*;

/**
 * Entry point to our Dijkstra Algorithm program
 * @author Lejla Heleg
 */
public class App 
{
    /**
     * Main method of our App
     * @param args array of Strings
     */
    public static void main( String[] args ) {
        StringBuilder input = new StringBuilder();
        for(String s : args){
            input.append(s).append(" ");
        }
        System.out.println("The result is: " + Evaluate(String.valueOf(input)));
    }
}
