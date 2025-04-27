/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
  * @author				ArulKumarRaja.N
  * @since				Version 1.0
  * @created-on			13th June 2002
  * @last-modified-on	20th June 2002
  * @purpose			Contains general purpose HTML Utility functions
  * @package			ecis.utils
  */

package ecis.utils;

public class HTMLUtilities
{
	/**
	  *	public constructor
	  */
	public HTMLUtilities(){}

	/**
	  *	The method replace(inputString, searchString, replaceString) used to 
	  * get the replace String
	  *
	  * @param		inputString   - the String which is to be encoded accordingly to HTML Standards
	  * @param		searchString  - the String which is to be searched in the inputString
	  * @param		replaceString - the String which is to be replaced in case of the searchString found
	  * @returns	outputString  - the replaced String.	
	  *
	  */
	private static String replace(String inputString, String searchString, String replaceString) 
	{
		String	outputString	=	"";
		int		currentIndex	=	-1;

		/**
		  *	Find for the Occurance of searchString (ie., \" ) 
		  * If found replace it with replaceString which represents a HTML entity.
		  */
		currentIndex	=	inputString.indexOf(searchString);
		while(currentIndex!=-1)
		{
			outputString	+=	inputString.substring(0,currentIndex)+replaceString;
			inputString		=	inputString.substring( currentIndex+1);
			currentIndex	=	inputString.indexOf(searchString);
		}

		/**
		  *	If still the input string remains and doesnot have any more searchString,
		  * add it to the outputString.
		  */
		if(currentIndex<inputString.length())
		{
			outputString	+=	inputString;
		}
		
		/**
		  * Return the HTML Encoded outputString;
		  */
		return outputString;
	}

	/**
	  *	The method getInputString(inputString) used to get the HTML Encoded Display String
	  * which can be displayed as a value for a HTML input type.
	  *
	  * @param		inputString  - the String which is to be encoded accordingly to HTML Standards
	  * @returns	outputString - the HTML Encoded String used for Display Purpose.	
	  *
	  */
	public static String getInputString(String inputString) 
	{
		/**
		  *	Find for the Occurance of double quote (ie., \" ) 
		  * If found replace it with &quote; HTML entity.
		  */
		return replace(inputString, "\"", "&quot;"); 
	}

	/**
	  *	The method getDisplayString(inputString) used to get the HTML Encoded Display String
	  * which can be displayed as a HTML text in the canvas area of a browser.
	  *
	  * @param		inputString  - the String which is to be encoded accordingly to HTML Standards
	  * @returns	outputString - the HTML Encoded String used for Display Purpose.	
	  *
	  */
	public static String getDisplayString(String inputString) 
	{
		/**
		  *	Find for the Occurance of double quote (ie., \" ) 
		  * If found replace it with &quote; HTML entity.
		  */
		return replace(inputString, "&", "&amp;"); 
	}
}
