package com.project.auth.util;

import java.util.Random;

public class Utils {
	
	public static String generateCardNumber(){
	    Random rnd = new Random();
	    int counter=0;
	    StringBuffer stringBuffer = new StringBuffer();
	    while(counter<=16){
	        int generate = rnd.nextInt(9); 
	        stringBuffer.append(generate);
	        counter++;
	    }
	    return stringBuffer.toString();
	}

}
