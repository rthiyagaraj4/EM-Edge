/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePO.Common;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Properties;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import eCommon.Common.CommonAdapter;
import eCommon.Common.CommonRepository;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;

public class PoUtils
{
 
	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;
	HashMap				map			=	null;
	Properties			jdbc_props	=	null;

	public PoUtils()
	{
	}

	public PoUtils( Properties jdbc_props )
	{
        this.jdbc_props	=	jdbc_props;
	}

	public java.util.HashMap checkDuplicateExists( String SQL_PO_CODE_EXISTS, ArrayList arrPKFields ) throws Exception
	{
		int	count		=	0,	totalPKFields	=	0;
		int	colIndex	=	0;
		
		try
		{
			map		=	new	HashMap();
			pstmt	=	intializeSQLPStatement ( SQL_PO_CODE_EXISTS );

			totalPKFields	=	arrPKFields.size();
			for( int i=0; i<totalPKFields; i++ )
			{
				if( arrPKFields.get(i) instanceof java.lang.String )
				{
					pstmt.setString( ++colIndex, (String) arrPKFields.get(i) );
				}
				if( arrPKFields.get(i) instanceof java.lang.Integer )
				{
					pstmt.setInt( ++colIndex, ((Integer) arrPKFields.get(i)).intValue() );
				}
				if( arrPKFields.get(i) instanceof java.lang.Long )
				{
					pstmt.setLong( ++colIndex, ((Long) arrPKFields.get(i)).longValue() );
				}
			}
			
			rs	=	pstmt.executeQuery();

			if ( rs.next() ) 
			{
				count	=	rs.getInt( "count" );

				if ( count > 0 ) 
				{
					map = logMessage(map, false, getMessage("RECORD_ALREADY_EXISTS") );
				}
			}
		}
		catch(Exception e)
		{
			String	error_msg	=	"Exception@checkDuplicateExists() method...SQL Is : " + SQL_PO_CODE_EXISTS + " Exception@1 : " + e.toString();
			logErrorMessage( map, e, error_msg );
		}
		finally {
				rs.close();
				returnJDBCResources();
				}

		return map;
	}

	public static java.util.HashMap logMessage(HashMap map, String message_text)
	{
		return logMessage( map, true, message_text );
	}

	public static java.util.HashMap logMessage(HashMap map, boolean operation_status, String message_text)
	{
		map.put( "result", new Boolean( operation_status ) );
		map.put( "message", message_text );
		return map;
	}

	public static java.util.HashMap logErrorMessage(HashMap map, Exception e)
	{
		e.printStackTrace();
		return logMessage( map, false, e.toString() );
	}

	public static java.util.HashMap logErrorMessage(HashMap map, Exception e, String error_msg)
	{
		e.printStackTrace();
	//	System.err.println( error_msg );
		return logMessage( map, false, (error_msg+e.toString()) );
	}

	public static java.util.HashMap parseRequest(javax.servlet.http.HttpServletRequest request)
	{
		String	element_name		=	"",		element_value		=	"";

		java.util.HashMap		hmElements		=	new java.util.HashMap();
		java.util.Enumeration	enumElements	=	request.getParameterNames();

		while(enumElements.hasMoreElements())
		{
			element_name	=	(String)	enumElements.nextElement();
			element_value	=	CommonAdapter.checkForNull( request.getParameter(element_name) );
			hmElements.put(	element_name, element_value );
		}
		return hmElements;
	}

	public String getListOptions( String SQL_STMT,String language_id ) throws java.sql.SQLException, Exception
	{
		return getListOptions( SQL_STMT, new ArrayList(), "",language_id);
	}

	public String getListOptions( String SQL_STMT, String defaultValue,String language_id ) throws java.sql.SQLException, Exception
	{
		return getListOptions( SQL_STMT, new ArrayList(), defaultValue,language_id);
	}

	public String getListOptions( String SQL_STMT, ArrayList arrValues,String language_id ) throws java.sql.SQLException, Exception
	{
		return getListOptions( SQL_STMT, arrValues, "",language_id);
	}

	public String getListOptions( String SQL_STMT, ArrayList arrValues, String defaultValue,String language_id ) throws java.sql.SQLException, Exception
	{
		StringBuffer	sbListOptions	=	new StringBuffer();
		String			option_value	=	"",		option_text		=	"";
		String			option_selected	=	"";
		String select_option_legend="";

		int				colIndex		=	0,		arrLength		=	0;
		if(!language_id.equals(""))
		{
			String select_option=getPOMessage(language_id,"SELECT_OPTION","PO") ;
			select_option_legend="<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;---"+select_option+ "---&nbsp;&nbsp;&nbsp;&nbsp;</option>";
			sbListOptions.append(select_option_legend);
			}
		
		else
		{
				sbListOptions.append("<option value=\"\">&nbsp;&nbsp;&nbsp;----- Select -----&nbsp;&nbsp;&nbsp;</option>");
		}

		try
		{
			pstmt		=	intializeSQLPStatement(SQL_STMT);

			arrLength	=	arrValues.size();
			for( colIndex=0; colIndex<arrLength; colIndex++ )
			{
				pstmt.setString( (colIndex+1), (String) arrValues.get(colIndex) );
			}

			rs	=	pstmt.executeQuery();
			
			while(rs.next())
			{
				option_value	=	rs.getString(1);
				option_text		=	rs.getString(2);

				option_selected	=	option_value.equals(defaultValue)	?	" SELECTED "	:	"";
	
				sbListOptions.append("\n\t\t<option value=\"");
				sbListOptions.append(option_value);
				sbListOptions.append("\"");
				sbListOptions.append(option_selected);
				sbListOptions.append(">");
				sbListOptions.append(option_text);
				sbListOptions.append("</option>");
			}
		}
		catch(java.sql.SQLException e)
		{
			sbListOptions.append("Exception@getListOptions: "+e+"<br>While Executing SQL :"+SQL_STMT);
		}
		finally
		{
			returnJDBCResources();
		}
		
		return sbListOptions.toString();
	}

	public PreparedStatement intializeSQLPStatement ( String SQL_QUERY ) throws java.sql.SQLException, Exception
	{
		return intializeSQLPStatement( SQL_QUERY, -1 );
	}

	public PreparedStatement intializeSQLPStatement ( String SQL_QUERY, int SCROLL_SENSITIVITY ) throws java.sql.SQLException, Exception
	{
		if( con==null || con.isClosed() )	
			con		=	ConnectionManager.getConnection(jdbc_props);

		if( SCROLL_SENSITIVITY != -1 )
		{
			pstmt	=	con.prepareStatement( SQL_QUERY, SCROLL_SENSITIVITY, ResultSet.CONCUR_READ_ONLY  );
		}
		else
		{
			pstmt	=	con.prepareStatement( SQL_QUERY );
		}
			return pstmt;
	}

	public void returnJDBCResources() 
	{
		try
		{
			if( rs != null )		rs.close();
			if( pstmt != null )		pstmt.close();
	        if( con != null )		ConnectionManager.returnConnection( con, jdbc_props ) ;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

    public String getMessage( String message_id ) throws Exception
	{
        String message_text	=	"";

        try 
		{
            pstmt		=	intializeSQLPStatement( (String) CommonRepository.getCommonKeyValue("SQL_GET_MESSAGE") ) ;

			pstmt.setString (	1,	message_id	) ;

			rs	=	pstmt.executeQuery() ;

			if( rs.next() ) 
			{
               message_text	=	"APP-" + rs.getString( "MESSAGE_ID" ) + " " + rs.getString("MESSAGE_TEXT_SYSDEF") + "<br>" ;
            } 
			else
               message_text	=	"Message Not Avaliable in SM_MESSAGE <br>" ;
        } 
		catch( Exception e) 
		{
			logErrorMessage( map, e, "Error@getMessage: "+e.toString() ) ;
        } 
		finally 
		{
			rs.close();
			returnJDBCResources();
        }
        return message_text;
    }
	
	public  String getPOMessage(String locale, String messageId, String moduleId)
	{
	
        java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
        return(mesg) ;
    }
	public Map getSubFunctionProperties(String menu_id, String function_id, Properties jdbc_props) throws Exception 
	{
		Map	mpSubFunctions		=	new HashMap();
		Map	mpSubFunctionAttr	=	null;
	
		try
		{
			this.jdbc_props	=	jdbc_props;
			intializeSQLPStatement(PoRepository.getPoKeyValue("SQL_PO_SUBFUNCTION_SELECT"));		

			pstmt.setString(1, menu_id);
			pstmt.setString(2, function_id);

			rs		=	pstmt.executeQuery();

			while(rs.next())
			{
				mpSubFunctionAttr	=	new HashMap();
				
				mpSubFunctionAttr.put( "INCL_YN", rs.getString("incl_yn") );
				mpSubFunctionAttr.put( "INSERT_ACCESS_YN", rs.getString("insert_access_yn") );
				mpSubFunctionAttr.put( "UPDATE_ACCESS_YN", rs.getString("update_access_yn") );
				mpSubFunctionAttr.put( "DELETE_ACCESS_YN", rs.getString("delete_access_yn") );
				mpSubFunctionAttr.put( "PRINT_ACCESS_YN", rs.getString("print_access_yn") );
				mpSubFunctionAttr.put( "QUERY_ONLY_ACCESS_YN", rs.getString("query_only_access_yn") );

				mpSubFunctions.put( rs.getString("subfunction_id"), mpSubFunctionAttr );
			}
		}
		catch(Exception e)
		{
			mpSubFunctions.put("ERROR_MESSAGE", ("Exception@1: "+e.toString()) );
		}
		finally
		{
				rs.close();
				returnJDBCResources();

		} 
		return mpSubFunctions;
	}
}
