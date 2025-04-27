/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR.Common ;
import java.util.*;
import java.sql.*;

import webbeans.eCommon.*;

public class eHISFormatter implements java.io.Serializable
{
	private eHISFormatter(){}
	/*
		This Function will return an array after StringTokenizer the elements
		Input will be taken as String.
	*/
	  public static Object[] splitArray(String split_code, String split_token) {
      	int  val 					= 0;
      	String code 				= "";
      	StringTokenizer stToken 	= new StringTokenizer(split_code,split_token);
      	String[] storeVal 		= new String[ stToken.countTokens()];
      	while(stToken.hasMoreTokens())
      	{
           code            		= stToken.nextToken();
           storeVal[val] = code;
           val++;
      	}
      	return storeVal;
    }

	/**
	 * This is meant to be used in the Update mode for the when
	 * selecting a default value ,for a select box.
	 */

	public static String select(String str1, String str2)
	{
		if(str1.trim().equalsIgnoreCase(str2.trim()))
		return "selected";
		else
		return "";
	}

	/**
	 * This is meant to be used in the "Update" mode  when
	 * a particular input type needed to be disabled
	 */

	public	static String disabled(String str1, String str2)
	{
		if(str1.trim().equalsIgnoreCase(str2.trim()))
		return "disabled";
		else
		return "";
	}

	/**
	 * This is meant to be used in the convenient method
	 */

	public	static String chkReturn(String str1, String str2 ,String str3 ,String str4)
	{
		//if(str1 == null) str1="";
		//if(str2 == null) str2="";
		if (str1 !=null && str2 != null)
		{
		
		if(str1.trim().equalsIgnoreCase(str2.trim()))
		return str3;
		}
	
		return str4;
	}


	/**
	 * This is meant to be used in the convenient method
	 */
 	public	static String chkReturn(String str1[], String str2 ,String str3[],String str4){
		int i = str1.length-1 ;
		while(i >= 0){
		if(str1[i].equalsIgnoreCase(str2.trim()))
		return str3[i];
		--i;
		}
		return str4;
	}




	/**
     * This method is used to build select box depending upon the values
	 *supplied
    */

	public static String populateList(String val , String desc , String selected) //OverLoad the above method to take input iv various form
	{
		selected = ChkDef.defaultString(selected)  ;
		return " <option value="+ val + "   " + select(val,selected) +  " >" + desc + "</option>" ;
	}


//Iterate the array and return all the options populated with  the appropriate values

public static String populateList(ArrayList val , ArrayList desc , String selectedValue) throws Exception//convinence method
	{
	   if( val == null || desc == null)
		   throw new Exception("The array List Paramtere Passed is null..." + "Val =" + val + " Desc = " + desc) ;

	   StringBuffer sb   =  new StringBuffer();

	   int sizeVal	= val.size();
	   int sizeDesc = val.size();

	   if(sizeVal != sizeDesc )
		   throw new Exception("The size of val and desc array List Passes are not same is null..." + "ValSize =" + sizeVal + " descSize = " + sizeDesc) ;

		for(int i=0 ; i < sizeVal ; i++)
		{
			sb.append(populateList((String)val.get(i) ,(String)desc.get(i) , selectedValue)) ;
		}

	   return sb.toString();
}


	public	static String ChkBoxChecked(String str1 , String str2) //convinence method
	{
		if(str1 == null || str2 == null)
		return "";

		if(str1.trim().equalsIgnoreCase(str2.trim()))
		return "checked";
		else
		return "";
	}


 public static String replaceForSQL(String str ,String change ,String replace)
	{
		int t = str.indexOf(change);

		if( t == -1)
		return str;

		str   = str.substring(0,t) + " '" + replace.trim()+ "' " + str.substring(t+1)  ;

		return str ;
	}

	// more Helper method can be added

}



  /*
	<select name='event_class' onchange='' >
			<option value="">------Select------</option>
			<%if (event_class.equals("PHY$")) {sel="selected";} else {sel="";}%>
			<option value="PHY$"  <%=sel%>>Physician</option>
			<%if (event_class.equals("NUR$")) sel="selected"; else sel="";%>
			<option value="NUR$"  <%=sel%>>Nursing</option>
			<%if (event_class.equals("CLI$")) sel="selected"; else sel="";%>
			<option value="CLI$"  <%=sel%>>Clinician</option>
			<%if (event_class.equals("REF$")) sel="selected"; else sel="";%>
			<option value="REF$"  <%=sel%>>Referral Letter</option>
			</select>

			<%if(mode.trim().equalsIgnoreCase("update")) {status="disabled" ;}else{status="";}%>
			<input type="text" name="note_type" value="<%=note_type%>" <%=status%> >




	USING THIS CLASS
	===============

	<select name='event_class' onchange='' >
	<option value="">------Select------</option>
	<option value="PHY$"  Formatter.select(event_class,"PHY$")>Physician</option>
	<option value="NUR$"  Formatter.select(event_class,"NUR$")>Nursing</option>
	<option value="CLI$"  Formatter.select(event_class,"CLI$")>Clinician</option>
	<option value="REF$"  Formatter.select(event_class,"REF$")>Referral Letter</option>
	</select>

	<input type="text" name="note_type" value="<%=note_type%>"  Formatter.disabled(mode,"update")>
*/
