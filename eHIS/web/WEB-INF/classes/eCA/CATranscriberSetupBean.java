/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA;

import java.io.*;
import java.util.*;
import javax.rmi.* ;
import java.sql.*;
import javax.naming.* ;
import webbeans.eCommon.*;
import eCommon.Common.*;

public class  CATranscriberSetupBean implements Serializable
{
	protected String group_by;
	protected String resource_code;
	protected String transcriber_id;
	protected String locale;
	
	String login_by_id = "";
	String login_at_ws_no= "";
	String login_facility_id= "";	
	
	protected Hashtable MultiHashData = new Hashtable();
	CAMultiRecordBean multiRecBean  = new CAMultiRecordBean();

/*********************Constructor *************************/

	public CATranscriberSetupBean()
	{
		group_by		= "";
		resource_code	= "";
		transcriber_id	= "";
		locale			= "";
		try
		{
			doCommon();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

/**********************SET METHODS*************************/

	public void setGroupBy(String  group_by) {this.group_by =  group_by; } ;
	public void setResourceCode(String  resource_code) {this.resource_code =  resource_code; } ;
	public void setTranscriber(String  transcriber_id) {this.transcriber_id =  transcriber_id; } ;
	public void setLocale(String  locale) {this.locale =  locale; } ;

/**********************GET METHODS*************************/

	public String getGroupBy() {return this.group_by; } ;
	public String getResourceCode() {return this.resource_code; } ;
	public String getTranscriber() {return this.transcriber_id; } ;  
	public String getLocale() { return this.locale ; } ;
	public Object getMultiRecBean() { return multiRecBean ; } ;


/*********************METHOD TO SET ALL THE FEILDS AT ONCE*************************/

	public void setAll( Hashtable recordSet )
	{
		try
		{
			setGroupBy((String)recordSet.get("group_by"));
			setResourceCode((String)recordSet.get("resource_code"));
			setTranscriber((String)recordSet.get("transcriber_id"));
		}
		catch(Exception e)
		{
			try
			{
				throw new Exception("Excweption@SetAll: "+e);
			}
			catch(Exception ee)
			{
				ee.printStackTrace() ;
			}
		}
	}

/********************Validate Method ****************************/
	
	public HashMap validate() throws Exception
	{
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map ;
	}

/*********************METHOD TO Reset the Class variable*************************/

	public void clear()
	{
		group_by		= "";
		resource_code	= "";
		transcriber_id	= "";	
	}


/*********************METHOD TO Update*************************/

	public HashMap modify()
	{
		HashMap map = new HashMap();
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message", "success.." ) ;
		return map;
	}

/*********************METHOD TO Delete*************************/

	public HashMap delete()
	{
		HashMap map = new HashMap();
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message", "delete failure.." );
		return map;
	}

/*********************doCommon METHOD *************************/

	private void doCommon() throws Exception {
	}

/*********************loadData METHOD *************************/
	
	public void loadData() throws Exception {
	}
 
/*********Method to fetch the Data Base Values*************/
	
	public int fetchDBRecords(String group_by,String param_value)throws Exception
	{
		Connection connection = null ;
		PreparedStatement pstmt=null;
		HashMap htMapRecord = null;
		ResultSet rs=null;
		int total_rec =0;
		String SQL_QUERY="", code="", desc="" ;
	
		try
		{
			int checkRec = multiRecBean.getSize("DB");
			if(checkRec == 0)
			{
				connection = ConnectionManager.getConnection();
			
				if (group_by.equals("SP"))
				{
					SQL_QUERY = "SELECT A.RESOURCE_CODE CODE, AM_GET_DESC.AM_SPECIALITY(A.RESOURCE_CODE,?,'2') description FROM CA_DFLT_TRANSCRIBER A WHERE A.RESOURCE_TYPE = ? and TRANSCRIBE_PRACT_ID = ? order by 2";
				}
				else if (group_by.equals("PR"))
				{
					SQL_QUERY = "SELECT A.RESOURCE_CODE CODE, AM_GET_DESC.AM_PRACTITIONER(A.RESOURCE_CODE,?,'1') description FROM CA_DFLT_TRANSCRIBER A WHERE A.RESOURCE_TYPE = ? and TRANSCRIBE_PRACT_ID = ? order by 2";
				}
				else if (group_by.equals("PC"))
				{
					SQL_QUERY = "SELECT A.RESOURCE_CODE CODE, A.RESOURCE_CODE description FROM CA_DFLT_TRANSCRIBER A WHERE A.RESOURCE_TYPE = ? and TRANSCRIBE_PRACT_ID = ? order by 2";
				}

						
				pstmt = connection.prepareStatement(SQL_QUERY);
							
				if(!group_by.equals("PC"))
				{
					pstmt.setString(1,locale);
					pstmt.setString(2,group_by);
					pstmt.setString(3,param_value);
				}
				else
				{
					pstmt.setString(1,group_by);
					pstmt.setString(2,param_value);
				}
			
				rs = pstmt.executeQuery();
				if(rs != null)
				{
					while(rs.next())
					{
						code = rs.getString("code");
						desc = rs.getString("description");

						if(desc == null || desc.equals("null")) 
							desc = "";

						htMapRecord		=	new HashMap();
						htMapRecord.put("code"			,	code);
						htMapRecord.put("description"	,	desc);
						htMapRecord.put("valid"			,	"Y");
						htMapRecord.put("associate_yn"	,   "N");
						htMapRecord.put("status"		,   "N");
					
						multiRecBean.putObject(htMapRecord);
					}
				}	

			}
			total_rec = multiRecBean.getSize("DB");
		}
		catch(Exception e)
		{
			throw e;
		}
		finally
		{
			try
			{
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (connection != null) ConnectionManager.returnConnection(connection);
			}
			catch(Exception e){throw e;}
		}
		return total_rec;
	}

/*********************Method to fetch Alphabetical Records ***********************/
	
	public Object getRecordSet(String index,String group_by)throws Exception
	{
		Connection connection = null ;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt1=null;
		ResultSet rs=null;
		ResultSet rs1=null;
		try
		{
			java.util.HashMap htRecord = null;
			String description = "";
			String SQL_QUERY = "";
			String code = "";
			String std_query = "";
			String status1 = "";

			connection = ConnectionManager.getConnection();
			multiRecBean.clearSelectRec();

			if (group_by.equals("SP"))
			{
				if(!(index.equals("OTH")))
				{
					SQL_QUERY = "SELECT SPECIALITY_CODE CODE, AM_GET_DESC.AM_SPECIALITY(SPECIALITY_CODE,?,2) description FROM AM_SPECIALITY  WHERE EFF_STATUS = 'E' AND UPPER(SHORT_DESC) LIKE UPPER (?) order by 2";				
				}
				else
				{
					SQL_QUERY = "SELECT SPECIALITY_CODE CODE, AM_GET_DESC.AM_SPECIALITY(SPECIALITY_CODE,?,2) description FROM AM_SPECIALITY WHERE EFF_STATUS = 'Y' AND UPPER(SHORT_DESC) NOT BETWEEN UPPER('A%') AND UPPER('_Z%') ORDER BY 2";
				}			
			}
			else if (group_by.equals("PR"))
			{
				if(!(index.equals("OTH")))
				{
					SQL_QUERY = "SELECT PRACTITIONER_ID CODE, AM_GET_DESC.AM_PRACTITIONER(practitioner_id,?,'1') description  FROM AM_PRACTITIONER  WHERE eff_status = 'E' AND UPPER(PRACTITIONER_NAME) LIKE UPPER (?) order by 2";				
				}
				else
				{
					SQL_QUERY = "SELECT PRACTITIONER_ID CODE, AM_GET_DESC.AM_PRACTITIONER(practitioner_id,?,'1') description FROM AM_PRACTITIONER WHERE eff_status = 'E' AND UPPER(PRACTITIONER_NAME) NOT BETWEEN UPPER('A%') AND UPPER('_Z%') ORDER BY 2";
				}
			}
			else if(group_by.equals("PC"))
			{
				SQL_QUERY = "SELECT PATIENT_CLASS CODE, LONG_DESC description FROM AM_PATIENT_CLASS order by 1";
			}
		
			pstmt = connection.prepareStatement(SQL_QUERY);
			
			if(!group_by.equals("PC"))
			{
				pstmt.setString(1,locale);
				if(!(index.equals("OTH")))
				{
					pstmt.setString(2,index+"%");
				}
			}
		
			rs = pstmt.executeQuery();
			if(rs != null)
			{
				std_query = "select 'Y' FROM CA_DFLT_TRANSCRIBER WHERE RESOURCE_TYPE = ? AND RESOURCE_CODE = ? and rownum = 1";
				pstmt1=connection.prepareStatement(std_query);
				while(rs.next())
				{
					code			=	rs.getString("CODE");
					description		=	rs.getString("description");
				
					if(description == null || description.equals("null"))description = "";
				
					pstmt1.setString(1,group_by);
					pstmt1.setString(2,code);
					
					rs1=pstmt1.executeQuery();
					if(rs1.next())
					{
						status1 = rs1.getString(1) == null ? "N" : rs1.getString(1);
					}
					else
					{
						status1 = "N";
					}
					if (rs1 != null) rs1.close();
			
					htRecord = new HashMap();

					htRecord.put("code"			, code);
					htRecord.put("description"	, description);
					htRecord.put("valid"		, "N");

					if(status1.equalsIgnoreCase("Y"))
					{
						htRecord.put("associate_yn" , "A");
					}
					else
					{
						htRecord.put("associate_yn" , "N");
					}

					htRecord.put("status" , "N");
					multiRecBean.putListObject(htRecord);
				}
				if (pstmt1 != null) pstmt1.close();
			}
		}
		catch(Exception e)
		{
			throw e;
		}
		finally
		{
			try
			{
				if (rs != null) rs.close();
				if (rs1 != null) rs1.close();
				if (pstmt != null) pstmt.close();
				if (pstmt1 != null) pstmt1.close();
				if (connection != null) ConnectionManager.returnConnection(connection);
			}
			catch(Exception e){throw e;}
		}
		return multiRecBean;
	}

/***************************To get the multiRecord bean ***********/
	
	public Object getBean()
	{
		return this.multiRecBean;
	}

/***************************To clear the multiRecord bean ***********/
	
	public boolean clearDBRec()throws Exception
	{
		boolean clearFlag = false;
		clearFlag = multiRecBean.clearDBRec();
		return clearFlag;
	}

/***************************To check for null ***********/
	
	public String checkForNull(String inputString)
	{
		return (inputString==null || inputString.equals(""))	?	""	:	inputString;
	}
	
}//end of class


