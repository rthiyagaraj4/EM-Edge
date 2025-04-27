/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package ePH ;

import java.io.* ;
import java.util.* ;
import java.sql.* ;
import javax.servlet.* ;
import javax.servlet.http.*;
/*import javax.rmi.* ;
import javax.naming.* ;*/
import ePH.Common.* ;
import eCommon.Common.* ;
import eCommon.SingleTableHandler.*;

//saved on 25/10/2005
public class DrugTypeBean extends PhAdapter implements Serializable {

	protected String m_strDrug_Code = "";
	protected String m_strDrug_Desc = "";
	protected String m_eff_status  = "";

	public DrugTypeBean() 
	{
		
		try 
		{
			doCommon() ;
		}
		catch(Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}

	/* Over-ridden Adapter methods start here */
private void doCommon() throws Exception 
	{
	}

public void clear() 
	{
		super.clear() ;
		
	}

	public void setDrugTypeCode(String strDrugCodeIn)
	{
		this.m_strDrug_Code = strDrugCodeIn;
	}
	public void setDrugTypeDesc(String strDrugDescIn)
	{
		this.m_strDrug_Desc = strDrugDescIn;
	}
	
	public void setEffStatus(String eff_status)
	{
		if (eff_status.equals("") || eff_status==null )
			eff_status="D";
		
		this.m_eff_status = eff_status;
	}
	
	public String getDrugTypeCode()
	{
		return m_strDrug_Code;
	}
	public String getDrugTypeDesc()
	{
		return m_strDrug_Desc;
	}

	public String getEffStatus()
	{
		return m_eff_status;
	}


public HashMap validate() throws Exception {
		HashMap map=new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map;
	}

public void setAll(Hashtable recordSet)
	{
		if(recordSet.containsKey("mode"))
			setMode((String)recordSet.get("mode")) ;
		if(recordSet.containsKey("drug_type"))
			setDrugTypeCode((String)recordSet.get("drug_type")) ;
		if(recordSet.containsKey("drug_desc"))
			setDrugTypeDesc((String)recordSet.get("drug_desc")) ;
		if(recordSet.containsKey("eff_status"))
			setEffStatus((String)recordSet.get("eff_status")) ;
	}

public HashMap getTypeDetails(String gCode,String locale)
{
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		HashMap result=new HashMap();
		
		try {
	connection = getConnection() ;
			//this query retrieveds cons group info
pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DRUGTYPE_SELECT2" )) ;
pstmt.setString(1,gCode);
pstmt.setString(2,locale);
resultSet = pstmt.executeQuery() ;
		if (resultSet.next()) {
				result.put("GNAME",resultSet.getString("DRUG_TYPE_DESC"));
				result.put("EFF_STATUS",resultSet.getString("EFF_STATUS"));
			}
		}
		catch ( Exception e ) {
			
			e.printStackTrace() ;
			result.put("GNAME",e.toString());
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {System.err.println(es);
			}
		
		}
		return result;

}

public HashMap modify() 
	{
	
		StringBuffer debug =new StringBuffer();
	
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;

		ArrayList modifyData = new ArrayList() ;

		modifyData.add( m_strDrug_Desc) ;
		modifyData.add( m_eff_status ) ;
		modifyData.add( login_by_id.trim() ) ;
		modifyData.add( login_at_ws_no.trim() ) ;
		modifyData.add( login_facility_id.trim() ) ;
		modifyData.add( m_strDrug_Code) ;
		
		HashMap tabData = new HashMap() ;
		tabData.put( "properties", getProperties() );
		tabData.put( "ModifyData",modifyData);

		HashMap sqlMap = new HashMap() ;
		try
		{
			sqlMap.put( "ModifySQL", PhRepository.getPhKeyValue("SQL_PH_DRUGTYPE_UPDATE") );
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}


		try 
		{

			Object home=com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());

Object busObj=(home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[]=new Object[2];
			argArray[0]=tabData;
			argArray[1]=sqlMap;

			Class[] paramArray=new Class[2];
			paramArray[0]=tabData.getClass();
			paramArray[1]=sqlMap.getClass();

			map=(HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);


			debug.append("After MODIFY:::"+(Boolean) map.get( "result" ));
			if( ((Boolean) map.get( "result" )).booleanValue() )
			{
				map.put( "result", new Boolean( true ) ) ;
				//map.put( "message", getMessage((String) map.get( "msgid" )) ) ;
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
				map.put( "flag",debug.toString());
			}
			else{
				map.put( "result", new Boolean( false ) ) ;
				map.put( "message", (map.get("msgid"))) ;
				map.put( "flag",debug.toString());
			}
		}
		catch(Exception e) 
		{
			System.err.println( "Error Calling EJB : "+e ) ;
			map.put( "message", e.getMessage()) ;
			map.put( "flag",debug.toString());
			e.printStackTrace() ;
		}

		return map ;	
	}







}
