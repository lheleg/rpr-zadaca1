package ba.unsa.etf.rpr;

import java.util.Stack;

/**
 * ExpressionEvaluator class calculates expression in format like
 * ( a + ( ( b + c ) * ( d * e ) ) ) where a, b, c, d, e are real numbers
 * using two Stacks to implement Dijkstra algorithm
 * @author Lejla Heleg
 * @version 1.0
 */

public class ExpressionEvaluator{
    private static final Stack<String> operators = new Stack<>();
    private static final Stack<Double> values = new Stack<>();

    /**
     * Evaluate method calculates value of expression using Dijkstra algorithm
     * @param str String
     * @return calculated value of expression
     */
    public static Double Evaluate(String str){
        String[] arrOfStr = str.split(" ");
        for(String s : arrOfStr){
            if(s.equals("(")) break;
            else if(s.equals("+")) operators.push(s);
            else if(s.equals("-")) operators.push(s);
            else if(s.equals("*")) operators.push(s);
            else if(s.equals("/")) operators.push(s);
            else if(s.equals("sqrt")) operators.push(s);
            else if(s.equals(")")){
                String opr = operators.pop();
                Double val = values.pop();
                if(s.equals("+")) val = values.pop() + val;
                else if(s.equals("-")) val = values.pop() - val;
                else if(s.equals("*")) val = values.pop() * val;
                else if(s.equals("/")) val = values.pop() / val;
                else if(s.equals("sqrt")) val = Math.sqrt(val);
                values.push(val);
            }
            else values.push(Double.parseDouble(s));
        }
        return values.pop();
    }
}
