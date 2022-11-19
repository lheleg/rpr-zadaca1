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

    /**
     * Evaluate method calculates value of expression using Dijkstra algorithm
     * @param str String
     * @return calculated value of the expression
     * @throws RuntimeException if the String isn't correct
     */
    public Double evaluate(String str){
        Stack<String> operators = new Stack<>();
        Stack<Double> values = new Stack<>();
        String[] arrOfStr = str.split(" ");
        int parentheses = 0;
        for(String s : arrOfStr){
            if(s.equals("(")){ parentheses = parentheses - 1;}
            else if(s.equals("+")) operators.push(s);
            else if(s.equals("-")) operators.push(s);
            else if(s.equals("*")) operators.push(s);
            else if(s.equals("/")) operators.push(s);
            else if(s.equals("sqrt")) operators.push(s);
            else if(s.equals(")")){
                parentheses = parentheses + 1;
                String opr = operators.pop();
                Double val = values.pop();
                if(opr.equals("+")) val = values.pop() + val;
                else if(opr.equals("-")) val = values.pop() - val;
                else if(opr.equals("*")) val = values.pop() * val;
                else if(opr.equals("/")) val = values.pop() / val;
                else if(opr.equals("sqrt")) val = Math.sqrt(val);
                values.push(val);
            }
            else{
               try {
                    values.push(Double.parseDouble(s));
               }catch (RuntimeException e){
                   throw new RuntimeException();
                }
            }
        }
        try {
            if (parentheses != 0) throw new RuntimeException();
        }catch(RuntimeException e){
            throw new RuntimeException();
        }
        return values.pop();
    }
}
