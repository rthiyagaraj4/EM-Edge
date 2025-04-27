/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
	Note :- While Using this class checkDuplicate function using following Patttern
			of  sql=select Count(*) from emp where empno="0" and ename="desti"
			if the method return true means value is already  there.
*/
package eOR.Common ;
import java.sql.*;
import java.util.*;

public class  Validate implements java.io.Serializable
{
	public static boolean checkDuplicate(String sql,Connection con ) throws Exception
	{
		PreparedStatement stmt = null;
		ResultSet 	rs		   = null;
		try
		{
			int  count 	 = -1;

			if(sql== null || sql.trim().equals("") || con == null )
				 throw new Exception("Exception in Validate Bean--Illegal Parameter Passed Check \nsql=:>" + sql  + "\nConnection=>" + con ) ;

					stmt	 	= con.prepareStatement(sql);
					rs 			= stmt.executeQuery();

			while (rs.next())
			count = rs.getInt(1);

			if(count > 0 )
				return  true;
			else
				return  false;

	   }catch(Exception e){
			throw e;
	   }
		finally
		{
			closeResultSet(rs);
			closeStatement(stmt);
		}
	}

 	public static boolean checkDuplicate(String sql,Connection con , String arr[]) throws Exception
	{
		PreparedStatement pstmt = null;
		ResultSet 	rs		   = null;
		try
		{
			int  count 	 = -1;

			if(sql== null || sql.trim().equals("") || con == null || arr == null )
				 throw new Exception("Exception in Validate Bean-- Illegal Parameter Passed Check sql=:>" + sql  + "\nConnection=>" + con + "\narray=null" ) ;

			 pstmt	 = con.prepareStatement(sql);
				 rs	 = null ;
			int size = arr.length ;

			for(int i=0 ; i < size ; i++)
			{
				String val = arr[i];
				pstmt.setString(i+1,val);
			}

			rs = pstmt.executeQuery();

			while (rs.next())
			count = rs.getInt(1);

			if(count > 0 )
				return  true;
			else
				return  false;

	   }catch(Exception e){
			throw e;
	   }finally
		{
			closeResultSet(rs);
			closeStatement(pstmt);
		}

	}

/*if null return no values duplicated or esle it will give the list of duplicate values Again  Sql  should be accordingly*/

/*public static String[] giveDuplicateValues(String sql,Connection con , String arr[]) throws Exception{
	  try
	  {


	  }catch(Exception e){
				throw e;
	   }

	return null ;
}
*/

public static boolean checkPresentInSql(String sql,String value , Connection con ) throws Exception
	{
		PreparedStatement stmt = null;
		ResultSet 	rs		   = null;
		try
		{

			if(sql== null || sql.trim().equals("") || value== null || value.trim().equals("") || con == null  )
				 throw new Exception("Exception in Validate Bean--Illegal Parameter Passed Check \nsql=:>" + sql  + "\nConnection=>" + con ) ;

			//Statement stmt				= con.createStatement();
			stmt						= con.prepareStatement(sql);
			rs 							= stmt.executeQuery();
			//ResultSet rs				= stmt.executeQuery(sql);

			while (rs.next())
			{
				String val = ChkDef.defaultString(rs.getString(1));

				if(value.equalsIgnoreCase(val))
				return true ;
			}

				return  false;

	   }catch(Exception e){
			throw e;
 		}
 		finally
				{
					closeResultSet(rs);
					closeStatement(stmt);
		}
	}



   public static boolean checkPresentInStringArray(String arr[],String value) throws Exception
	{

		try
		{

			if(arr== null || value== null || value.trim().equals("") )
				 throw new Exception("Exception in Validate Bean-- Illegal Parameter Passed Check arr=:null" + "value="  + value) ;

			int size					= arr.length -1;
			while(size >= 0)
			{
				if(arr[size].trim().equalsIgnoreCase(value.trim()))
				return true ;
				--size;

			}
				return  false;

	   }catch(Exception e){
			throw e;
	}
  }


 public static boolean checkPresentInIntArray(int arr[],int value) throws Exception
	{

		try
		{

			if(arr== null || value== 0 )
				 throw new Exception("Exception in Validate Bean--Illegal Parameter Passed Check \narr=null" + "value=" + value ) ;

			int size					= arr.length -1;
			while(size >= 0)
			{
				if(arr[size]== value)
				return true ;
				--size;

			}
				return  false;

	   }catch(Exception e){
			throw e;
	}
}

	// Since these r all static methods, and for PMD it will give not close if we using
// rs.close() or stmt.close()
// for that to avoid have written these methods where it will close the statment/resultsets
// which will be called in this class

	  public static void closeStatement( PreparedStatement pstmt ) throws Exception {
        if( pstmt != null)   pstmt.close() ;
    }

	public static void closeResultSet( ResultSet rs ) throws Exception {
        if( rs != null )  rs.close() ;
    }
 




/*
	 public static void main(String[] args)
	 {
	  try
	  {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@dsg10:1521:hsdv","medicom","medehis01");
		//String sql     ="select Count(*) from or_order_Category where  ORDER_CATEGORY='LB' and SHORT_DESC='Laboratory'";
		String sql1     ="select ORDER_CATEGORY from or_order_Category ";

		Validate pt = new Validate();
	//	System.out.println(pt.checkDuplicate(sql,null));
		System.out.println(pt.checkPresentInSql(sql1,"LB",con));
		String myarr[] = {"a","c","v","d"};
		System.out.println(pt.checkPresentInStringArray(myarr,"d"));
		int myarr1[] = {0,1,3,5};
		System.out.println(pt.checkPresentInIntArray(myarr1,15));
	   }catch (Exception e){
		System.out.println(e);
	  }
 }
*/
}//End of Class
