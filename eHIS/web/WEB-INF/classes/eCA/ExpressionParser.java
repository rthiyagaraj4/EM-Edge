/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eCA;
import java.util.*;
public class ExpressionParser 
{
	/******************************************************/
	public boolean checkForValidity(String expn)
	{
		char lastChar=' ';

		int i=0;
		do
		{
			char charVal=expn.charAt(i);

			//checking for 8(   kind of expression --will not put into the stack
			if(charVal=='(' && lastChar!='V' )
			{
				bracketStack.push(new Character('('));

			}
			//checking for last character should be operand whin ) comes
			else if(charVal==')')
			{
				if(!bracketStack.empty() && lastChar=='V')
				{
					bracketStack.pop();

				}
				else
				{
					return false;
				}
			}
			//
			else if(isOperand(charVal) )
			{
				boolean checkIfLastChar=false;
				if(lastChar=='V')
				{
					return false;
				}
				char temp=expn.charAt(i);

				//checking for the variable or constant with more then one character
				//should not be an operator or bracket
				while((!isOperator(temp)) && temp!='(' && temp!=')' )
				{
					if(i==expn.length()-1)
					{
						checkIfLastChar=true;
						//i--;
						break;
					}
					i++;
					temp=expn.charAt(i);

				}
				if(!checkIfLastChar)
				i--;
				lastChar='V';

			}

			else if(isOperator(charVal))
			{
				//checking for the condition -- , ++
				if(lastChar=='O' && expn.charAt(i-1)!='(')
				{
					return false;
				}
				//checking for condition -(- or -(+
				if(lastChar=='O' && expn.charAt(i-1)=='(' && (charVal=='*' || charVal=='/'))
				{
					return false;
				}
				//checking for the initial character as / or *  --- will not allow
				if(lastChar==' ' && (charVal=='*' || charVal=='/'))
				{
					return false;
				}
				lastChar='O';

			}
			i++;

		}
		while(i<expn.length());
		//if bracket doesnot match or last character is not an operand
		if(!bracketStack.empty() || lastChar!='V')
		{
			return false;
		}

		return true;
	}
	/******************************************************/
	private boolean isOperator(char val)
	{
		if(val=='+' || val=='-' || val=='/' || val=='*')
			return true;
		else
			return false;
	}
	/******************************************************/
	private boolean isOperand(char val)
	{
		if(Character.isLetterOrDigit(val) || val=='$')
		{
			return true;
		}
		return false;
	}
	private Stack bracketStack = new Stack();
}
