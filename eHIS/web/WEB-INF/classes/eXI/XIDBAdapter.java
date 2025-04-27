/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXI;
import java.sql.Statement;
/**
 * Class is used to close the curson and  the common check null validation
 *
 */
public class  XIDBAdapter
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
        return (((s == null)||(s.equals(""))||(s.equals("null"))||(s.equals(" "))) ? "" : s);
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

}//end of class
