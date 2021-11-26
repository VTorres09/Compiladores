/* *******************************************************************
 * Copyright (c) 2021 Universidade Federal de Pernambuco (UFPE).
 * 
 * This file is part of the Compilers course at UFPE.
 * 
 * During the 1970s and 1980s, Hewlett-Packard used RPN in all 
 * of their desktop and hand-held calculators, and continued to 
 * use it in some models into the 2020s. In computer science, 
 * reverse Polish notation is used in stack-oriented programming languages 
 * such as Forth, STOIC, PostScript, RPL and Joy.
 *  
 * Contributors: 
 *     Henrique Rebelo      initial design and implementation 
 *     http://www.cin.ufpe.br/~hemr/
 * ******************************************************************/
/**
 * @author Henrique Rebelo
 */

public class Token {

	public final TokenType type; // token type
	public final String lexeme; // token value

	// Constructor
	public Token (String value) throws Exception {
		this.type = typeOf(value);      
		this.lexeme = value;
	}

	// Type detector
	private TokenType typeOf(String symbol) throws Exception {

		if(symbol.chars().allMatch( Character::isDigit )){
			return TokenType.NUM;
		}else{
			switch (symbol) {
				case "+":
					return TokenType.PLUS;
				case "-":
					return TokenType.MINUS;
				case "*":
					return TokenType.STAR;
				case "/":
					return TokenType.SLASH;
				default:
					throw new Exception("Unexpected character: " + symbol);
			}
		}
		
	}	


	@Override
	public String toString() {
		return "Token [type=" + this.type + ", lexeme=" + this.lexeme + "]";
	}
}