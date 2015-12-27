package main.java;

import java.util.Arrays;
import java.util.Stack;

public class Operations {

    public double calculate(String cal) {
        Stack<String> characters = new Stack<String>();
        String charArr[] = cal.split(" ");
        
        double result = 0;
        if(charArr.length > 2){
            for(int i=0; i < charArr.length ; i++){
                String first = "";
                String sec = "";
                if(checkIfBinary(charArr[i])){
                    sec = characters.pop();
                    first = characters.pop();
                    switch (charArr[i]) {
                        case "+":
                            result = add(first, sec);
                            characters.push(String.valueOf(result));
                            break;
                        case "-":
                            result = subtract(first, sec);
                            characters.push(String.valueOf(result));
                            break;
                        case "*":
                            result = mul(first, sec);
                            characters.push(String.valueOf(result));
                            break;
                        case "/":
                            result = div(first, sec);
                            characters.push(String.valueOf(result));
                            break;
                        case "^":
                            result = expo(first, sec);
                            characters.push(String.valueOf(result));
                            break;
                        default:
                            break;
                    }
                }else if(checkIfUnary(charArr[i])){
                    first = characters.pop();
                    switch (charArr[i]) {
                        case "%":
                            result = perc(first);
                            characters.push(String.valueOf(result));
                            break;
                        case "!":
                            result = fact(first);
                            characters.push(String.valueOf(result));
                            break;
                        default:
                            break;
                    }
                }else{
                    characters.push(charArr[i]);
                }
            }
        }
        
        return result;
    }
    
    private double expo(String first, String sec) {
        return Integer.valueOf(first)^Integer.valueOf(sec);
    }

    private boolean checkIfBinary(String bop){
        String ops[] = {"+", "-", "*", "/", "^"};
        boolean contains = false;
        if(Arrays.asList(ops).contains(bop)){
            contains = true;
        }
        
        return contains;
    }
    
    private boolean checkIfUnary(String uop){
        String ops[] = {"%", "!"};
        boolean contains = false;
        if(Arrays.asList(ops).contains(uop)){
            contains = true;
        }
        
        return contains;
    }
    
    private Double add(String one, String two){
        return Double.valueOf(one) + Double.valueOf(two);
    }

    private double subtract(String one, String two){
        return Double.valueOf(one) - Double.valueOf(two);
    }
    
    private double mul(String one, String two){
        return Double.valueOf(one) * Double.valueOf(two);
    }
    
    private double div(String one, String two){
        return Double.valueOf(one) / Double.valueOf(two);
    }
    
    private double perc(String one){
        return (Double.valueOf(one) / 100.0);
    }
    
    private double fact(String one){
    	double fact = 1;
    	for(int i = Integer.valueOf(one); i >= 1 ; i --){
    		fact = fact * i;
    	}
        return fact;
    }
}
