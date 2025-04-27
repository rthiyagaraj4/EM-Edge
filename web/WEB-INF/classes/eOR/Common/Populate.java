/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR.Common ;
import java.sql.*;
import java.util.*;

public class Populate implements java.io.Serializable
{

	private Populate(){}
	/*Gives Combo Options with out any Defaultation & accepts no sql Param*/
	public static String getComboOptions(String sql ,  Connection con  , String codeColumn ,String codeDescriptionColumn ) throws Exception	{
	PreparedStatement stmt = null;
	ResultSet			rs = null;
	try
		{

			 if(sql== null || sql.trim().equals("") || con == null || codeColumn.trim().equals("") ||  codeColumn==null || codeDescriptionColumn.trim().equals("") ||  codeDescriptionColumn==null )
                 throw new Exception("Illegal Parameter Passed Check \nsql=:>" + sql  + "\nConnection=>" + con + "\n codeColumn=>" + codeColumn + "\ncodeDescriptionColumn=>"  + codeDescriptionColumn ) ;

			/*Statement stmt			= con.createStatement();
			ResultSet rs				= stmt.executeQuery(sql);*/

			stmt	= con.prepareStatement(sql);
			rs	    = stmt.executeQuery()  ;

			StringBuffer sb			    = new StringBuffer();

			if(rs !=null )
				{
					while (rs.next())
					{
						String  codeCol			    = ChkDef.defaultString(rs.getString(codeColumn.trim()));
						String  codeDesc			= ChkDef.defaultString(rs.getString(codeDescriptionColumn.trim()));
						 sb.append("<option value='"+ codeCol + "' >" + codeDesc + "</option>");
					}

				}

			 return  sb.toString();

		}
		catch(Exception e)
		{
			throw e;
		}
		finally
		{
			closeResultSet(rs);
			closeStatement(stmt);
		}

   }


/*Gives Combo Options with out any Defaultation & accepts  sql Param*/
public static String getComboOptions(String sql ,  Connection con  , String codeColumn ,String codeDescriptionColumn ,String params[]) throws Exception {
	//System.out.println("###inside populate##");
	//System.out.println("###params in populate="+params+"##");
	
	PreparedStatement stmt	= null;
	ResultSet			rs	= null;
		try
		{
			int paramslen  = params.length ;

			 if(sql== null || sql.trim().equals("") || con == null || codeColumn.trim().equals("") ||  codeColumn==null || codeDescriptionColumn.trim().equals("") ||  codeDescriptionColumn==null )
                 throw new Exception("Illegal Parameter Passed Check \nsql=:>" + sql  + "\nConnection=>" + con + "\n codeColumn=>" + codeColumn + "\ncodeDescriptionColumn=>"  + codeDescriptionColumn ) ;

			/*Statement stmt			= con.createStatement();
			ResultSet rs				= stmt.executeQuery(sql);*/

						 stmt		= con.prepareStatement(sql);

			for (int i = 0; i < paramslen ; i++ ){
			stmt.setString(i+1, (params[i]).trim());
			}


							rs	    = stmt.executeQuery()  ;

			StringBuffer sb			    = new StringBuffer();

			if(rs !=null )
				{
					while (rs.next())
					{
						String  codeCol			    = ChkDef.defaultString(rs.getString(codeColumn.trim()));
						String  codeDesc			= ChkDef.defaultString(rs.getString(codeDescriptionColumn.trim()));
						 sb.append("<option value='"+ codeCol + "' >" + codeDesc + "</option>");
					}

				}
			//System.out.println("####sb="+sb.toString());
			 return  sb.toString();

		}
		catch(Exception e)
		{
			throw e;
		}
		finally{
			closeResultSet(rs);
			closeStatement(stmt);
		}
   }


/*Gives Combo Options with Defaultation & accepts no sql Param*/
public static String getComboOptions(String sql ,  Connection con  , String codeColumn ,String codeDescriptionColumn , String selectedValue) throws Exception
{
		PreparedStatement stmt = null;
		ResultSet			rs = null;
		try
		{

			 if(sql== null || sql.trim().equals("") || con == null || codeColumn.trim().equals("") ||  codeColumn==null || codeDescriptionColumn.trim().equals("") ||  codeDescriptionColumn==null )
                 throw new Exception("Illegal Parameter Passed Check \nsql=:>" + sql  + "\nConnection=>" + con + "\n codeColumn=>" + codeColumn + "\ncodeDescriptionColumn=>"  + codeDescriptionColumn ) ;

/*			Statement stmt				= con.createStatement(); //
			ResultSet rs				= stmt.executeQuery(sql);*/
							 stmt		= con.prepareStatement(sql);
								rs	    = stmt.executeQuery()  ;
	        StringBuffer sb			    = new StringBuffer();
			String selected				= "";

			if(rs !=null )
				{
					while (rs.next())
					{
						selected                    = "";
						String  codeCol			    = ChkDef.defaultString(rs.getString(codeColumn.trim()));
						String  codeDesc			= ChkDef.defaultString(rs.getString(codeDescriptionColumn.trim()));

						if(codeCol.trim().equalsIgnoreCase(selectedValue.trim())){
						codeCol = codeCol   ;
						selected = 	" selected"	;
						}

						 sb.append("<option value='"+ codeCol + "'" + selected + " >" + codeDesc + "</option>");
					}

				}

			 return  sb.toString();

		}
		catch(Exception e)
		{
			throw e;
		}
		finally{
			closeResultSet(rs);
			closeStatement(stmt);
		}
   }




/*Gives Combo Options with Defaultation & accepts  sql Param*/
public static String getComboOptions(String sql ,  Connection con  , String codeColumn ,String codeDescriptionColumn , String selectedValue ,String params[]) throws Exception {
	PreparedStatement stmt		= null;
	ResultSet			rs	    = null;
		try
		{

			int paramslen  = params.length ;


			if(sql== null || sql.trim().equals("") || con == null || codeColumn.trim().equals("") ||  codeColumn==null || codeDescriptionColumn.trim().equals("") ||  codeDescriptionColumn==null )
                 throw new Exception("Illegal Parameter Passed Check \nsql=:>" + sql  + "\nConnection=>" + con + "\n codeColumn=>" + codeColumn + "\ncodeDescriptionColumn=>"  + codeDescriptionColumn ) ;

/*			Statement stmt				= con.createStatement(); //
			ResultSet rs				= stmt.executeQuery(sql);*/
			 stmt						= con.prepareStatement(sql);
			for (int i = 0; i < paramslen ; i++ ){
			stmt.setString(i+1, (params[i]).trim());
			}

								rs	    = stmt.executeQuery()  ;
	        StringBuffer sb			    = new StringBuffer();
			String selected				= "";

			if(rs !=null )
				{
					while (rs.next())
					{

						selected                    = "";
						String  codeCol			    = ChkDef.defaultString(rs.getString(codeColumn.trim()));
						String  codeDesc			= ChkDef.defaultString(rs.getString(codeDescriptionColumn.trim()));

						if(codeCol.trim().equalsIgnoreCase(selectedValue.trim())){
						codeCol = codeCol  ;
						selected = 	" selected"	;
						}

						 sb.append("<option value='"+ codeCol + "'"+ selected + " >" + codeDesc + "</option>");
					}

				}

			 return  sb.toString();

		}
		catch(Exception e)
		{
			throw e;
		}
		finally{
					closeResultSet(rs);
					closeStatement(stmt);
		}

   }


/*Gives Combo Options with Defaultation & accepts  sql Param for special char*/
public static String getComboOptions_sp(String sql ,  Connection con  , String codeColumn ,String codeDescriptionColumn , String selectedValue ,String params[]) throws Exception {
		PreparedStatement stmt		= null;
		ResultSet			rs	    = null;
		try
		{

			int paramslen  = params.length ;


			if(sql== null || sql.trim().equals("") || con == null || codeColumn.trim().equals("") ||  codeColumn==null || codeDescriptionColumn.trim().equals("") ||  codeDescriptionColumn==null )
                 throw new Exception("Illegal Parameter Passed Check \nsql=:>" + sql  + "\nConnection=>" + con + "\n codeColumn=>" + codeColumn + "\ncodeDescriptionColumn=>"  + codeDescriptionColumn ) ;

/*			Statement stmt				= con.createStatement(); //
			ResultSet rs				= stmt.executeQuery(sql);*/
							 stmt		= con.prepareStatement(sql);
			for (int i = 0; i < paramslen ; i++ ){
			stmt.setString(i+1, (params[i]).trim());
			}

								rs	    = stmt.executeQuery()  ;
	        StringBuffer sb			    = new StringBuffer();
			String selected				= "";

			if(rs !=null )
				{
					while (rs.next())
					{

						selected                    = "";
						String  codeCol			    = ChkDef.defaultString(rs.getString(codeColumn.trim()));
						String  codeDesc			= ChkDef.defaultString(rs.getString(codeDescriptionColumn.trim()));

						if(codeCol.trim().equalsIgnoreCase(selectedValue.trim())){
						codeCol = codeCol  ;
						selected = 	" selected"	;
						}

						 sb.append("<option value=\""+ codeCol +"\" "+ selected + " >" + codeDesc + "</option>");
					}

				}

			 return  sb.toString();

		}
		catch(Exception e)
		{
			throw e;
		}
		finally{
					closeResultSet(rs);
					closeStatement(stmt);
		}
   }




/*Gives arrayList's of value and desc & accepts no sql Param*/
public static HashMap getAsHashArray(String sql ,  Connection con  , String codeColumn ,String codeDescriptionColumn) throws Exception{
		PreparedStatement stmt		= null;
		ResultSet			rs	    = null;
try
	{

				if(sql== null || sql.trim().equals("") || con == null || codeColumn.trim().equals("") ||  codeColumn==null || codeDescriptionColumn.trim().equals("") ||  codeDescriptionColumn==null )
                 throw new Exception("Illegal Parameter Passed Check \nsql=:>" + sql  + "\nConnection=>" + con + "\n codeColumn=>" + codeColumn + "\ncodeDescriptionColumn=>"  + codeDescriptionColumn ) ;

				HashMap holder				= new HashMap();
/*				Statement stmt				= con.createStatement();
				ResultSet rs				= stmt.executeQuery(sql);*/
								 stmt		= con.prepareStatement(sql);
									rs	    = stmt.executeQuery()  ;
				ArrayList  arrValue			= new ArrayList();
				ArrayList  arrDesc			= new ArrayList();


				int i = 0;

				//System.out.println("Inside populateList..."+sql);

				while (rs.next())
					{
						String  codeCol			    = ChkDef.defaultString(rs.getString(codeColumn.trim()));
						String  codeDesc			= ChkDef.defaultString(rs.getString(codeDescriptionColumn.trim()));
						arrValue.add(i,codeCol);
						arrDesc.add(i,codeDesc);
						++i;
						//System.out.println("Code: "+codeCol+ " Code Desc: "+codeDesc);
					}

						holder.put("value" , arrValue);
						holder.put("Description" , arrDesc);

						return  holder;
		  }
		  catch(Exception e)
		  {
				throw e;
		  }
		  finally{
					closeResultSet(rs);
					closeStatement(stmt);
		 }

  }



/*Gives arrayList's of value and desc & accepts sql Param*/
public static HashMap getAsHashArray(String sql ,  Connection con  , String codeColumn ,String codeDescriptionColumn ,String params[]) throws Exception{
		PreparedStatement stmt		= null;
		ResultSet			rs	    = null;
try{

				int paramslen  = params.length ;

				if(sql== null || sql.trim().equals("") || con == null || codeColumn.trim().equals("") ||  codeColumn==null || codeDescriptionColumn.trim().equals("") ||  codeDescriptionColumn==null )
                 throw new Exception("Illegal Parameter Passed Check \nsql=:>" + sql  + "\nConnection=>" + con + "\n codeColumn=>" + codeColumn + "\ncodeDescriptionColumn=>"  + codeDescriptionColumn ) ;

				HashMap holder				= new HashMap();
/*				Statement stmt				= con.createStatement();
				ResultSet rs				= stmt.executeQuery(sql);*/
								 stmt		= con.prepareStatement(sql);

				for (int i = 0; i < paramslen ; i++ ){
					stmt.setString(i+1, (params[i]).trim());
				}

								  rs	    = stmt.executeQuery()  ;
				ArrayList  arrValue			= new ArrayList();
				ArrayList  arrDesc			= new ArrayList();


				int i = 0;

				//System.out.println("Inside populateList..."+sql);

				while (rs.next())
					{
						String  codeCol			    = ChkDef.defaultString(rs.getString(codeColumn.trim()));
						String  codeDesc			= ChkDef.defaultString(rs.getString(codeDescriptionColumn.trim()));
						arrValue.add(i,codeCol);
						arrDesc.add(i,codeDesc);
						++i;
						//System.out.println("Code: "+codeCol+ " Code Desc: "+codeDesc);
					}

						holder.put("value" , arrValue);
						holder.put("Description" , arrDesc);

						return  holder;
		  }
		  catch(Exception e)
		  {
				throw e;
		  }
		 finally{
					closeResultSet(rs);
					closeStatement(stmt);
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

public static void main(String[] args)
{
//  try
 // {
	/*	Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@dsg10:1521:hsdv","medicom","medehis01");
		String sql ="SELECT  ORDER_CATEGORY,SHORT_DESC FROM OR_ORDER_CATEGORY";
		System.out.println((HashMap)Populate.getAsHashArray(sql,con,"order_category","SHORT_DESC")); */
//   }catch (Exception e){
//		System.out.println(e);
  // }

 }


}
