/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package webbeans.op;

public class  CurrencyFormat
{
	public static String formatCurrency(String amount,int scale)
	{
		String returnAmount="";	
		double roundAmount = 0.0d;
		if(amount==null) amount = "0";
		amount.trim();
		if(amount.equals("")) amount = "0";
		int amountLength=amount.length();

		returnAmount = ""+amount;

		double original_value	= Double.parseDouble(returnAmount);

		java.text.DecimalFormat nf = new java.text.DecimalFormat();
		nf.setMaximumFractionDigits(3);
		nf.setMaximumFractionDigits(15);
		String formatString = "##############0.";
		for (int i=0; i<scale; i++ )
		{
			formatString+="0";
		}
		nf.applyPattern(formatString);
		nf.setDecimalSeparatorAlwaysShown(false);
		nf.toLocalizedPattern();

		returnAmount = ""+nf.format(original_value); //result3;

		return returnAmount;
	}
}
