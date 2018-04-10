package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {

		/**
		 * 
		 * Quel est le plus grand nombre de 8 chiffres de ce type : abcdefgh =
		 * abcd2 + efgh2 ?
		 */

		for(int a=1;a<10;a++){
			for(int b=0;b<10;b++){
				for(int c=0;c<10;c++){
					for(int d=0;d<10;d++){
						for(int e=1;e<10;e++){
							for(int f=0;f<10;f++){
								for(int g=0;g<10;g++){
									for(int h=0;h<10;h++){
										
										
										long abcd = a*1000+b*100+c*10+d;
										long efgh = e*1000+f*100+g*10+h;
										long abcdefgh = h+g*10+f*100+e*1000+d*10000+c*100000+b*1000000+a*10000000;
										
										if(abcd*abcd + efgh*efgh == abcdefgh){
											System.out.println();
											System.out.println(abcd+"²+"+efgh+"²="+abcd+efgh);
										}
										
									}	
								}	
							}	
						}	
					}	
				}	
			}	
		}

	}

	public static int doMath(int a, int b, int oper) {

		int c;

		if (oper == 0) {
			c = a + b;
		} else {
			if (oper == 1) {
				c = a - b;
			} else {
				if (oper == 2) {

					c = a * b;

				} else {

					c = a / b;

				}
			}
		}

		return c;

	}

}
