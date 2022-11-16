package ba.unsa.etf.rpr;

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
        String s = args[0];
        s.trim();
        try {
            ExpressionEvaluator e = new ExpressionEvaluator();
            System.out.println("The result is: " + e.evaluate(s));
        }catch(RuntimeException e){
            System.out.println("Your arithmetic expression is not valid!");
        }
    }
}
