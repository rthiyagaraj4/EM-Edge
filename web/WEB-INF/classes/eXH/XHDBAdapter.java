/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;
import java.sql.Statement;
/**
 * Class is used to close the curson and  the common check null validation
 *
 */
public class  XHDBAdapter
{

/**
  * Method closes the cursor
  */
 public  static void closeCursor(Statement statement)
 {
		try
		{
			statement.close();
		}
		catch(Exception ee){}
 }
/**
  * Method checks the Null String
  */
 public static String checkNull(String s)
 {
        return (((s == null) || (s.equals("")) || (s.equals("null")) || (s.equals(" "))) ? "" : s);
 }

/**
  * Method checks the Null String and returns zero if it is null
  */
  
     public static String checkNullZero(String s)
    {
        return (((s == null)||(s.equals(""))||(s.equals("null"))) ? "0" : s);
    }

/**
  * Method checks the Null String and returns zero if it is null
  */
   public static String checkNullForCheckBox(String s)
   {
        return (((s == null)||(s.equals(""))||(s.equals("null"))) ? "N" : s);
    }

  /**
  * Replaces with replaceWith argument if s is null
  */
 public static String isNullReplace(String s,String replaceWith)
 {
        return (((s == null)||(s.equals(""))||(s.equals("null"))||(s.equals(" "))) ? replaceWith : s);
 }

 /**
 * Method replaces with empty string if the string is null, it will not check for spaces
 **/
 public static String checkNullNoTrim(String s)
 {
        return (((s == null)||(s.equals(""))||(s.equals("null"))) ? "" : s);
 }

}//end of class
