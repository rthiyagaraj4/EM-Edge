/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
// include packages statement
package eOR;

//import necessary packages
import java.io.* ;
import java.util.* ;
import java.sql.*;
import javax.rmi.* ;
import javax.naming.* ;
import eCommon.SingleTableHandler.* ;
import eOR.Common.* ;
import eCommon.Common.*;
import webbeans.eCommon.*;
import javax.servlet.http.*;


import eOR.ORAntibiotic.*;

public class AntibioticBean extends OrAdapter implements Serializable
{
	protected String antibiotic_code = "";
	protected String long_desc = "";
	protected String short_desc = "";
	protected String seq_no = "";
	protected String eff_status = "";
	protected String facility_id = "";
	//protected String mode = "";

	protected HashMap recstorehandler = new HashMap();
	protected Hashtable allValues = new Hashtable();

	/*public void setMode(String mode)
	{
		this.mode = mode;
	}
	public String getMode()
	{
		return this.mode;
	}*/
	public void setFacilityID(String id)
	{
		this.facility_id = id;
	}
	public String getFacilityID()
	{
		return this.facility_id;
	}
	public void setAntibioticCode(String code)
	{
		this.antibiotic_code = code;
	}
	public String getAntibioticCode()
	{
		return this.antibiotic_code;
	}
	public void setLongDesc(String desc)
	{
		this.long_desc = desc;
	}
	public String getLongDesc()
	{
		return this.long_desc;
	}
	public void setShortDesc(String desc)
	{
		this.short_desc = desc;
	}
	public String getShortDesc()
	{
		return this.short_desc;
	}
	public void setSeqNo(String no)
	{
		this.seq_no = no;
	}
	public String getSeqNo()
	{
		return this.seq_no;
	}
	public void setEffStatus(String status)
	{
		this.eff_status = status;
	}
	public String getEffStatus()
	{
		return this.eff_status;
	}

	public void setAll(Hashtable recordSet)
	{
		allValues = recordSet;
		int count = Integer.parseInt((String)recordSet.get("noOfRecords"));
		this.mode = (String )recordSet.get("mode");
		
		
		int cnt = 0;

		if(recordSet.containsKey("facility_id"))
			setFacilityID((String)recordSet.get("facility_id"));
		if(mode.trim().equalsIgnoreCase("1"))
		{
		for(int i=0;i<count;i++)
		{
			HashMap map = new HashMap();
			String tempCode = (String)recordSet.get("code"+i);
			if(tempCode != null && !tempCode.equals(""))
			{
				map.put("antibiotic_code",(String)recordSet.get("code"+i));
				map.put("long_desc",(String)recordSet.get("long_desc"+i));
				map.put("short_desc",(String)recordSet.get("short_desc"+i));
				map.put("seq_no",(String)recordSet.get("seq_no"+i));
				map.put("eff_status",(((String)recordSet.get("eff_status"+i)).equals("")) ? "D":(String)recordSet.get("eff_status"+i));
				//map.put("facility_id",facility_id);
				recstorehandler.put(String.valueOf(cnt),map);
				cnt++;
			}
		}
		}
		else
		{
			HashMap map = new HashMap();
			map.put("antibiotic_code",(String)recordSet.get("code"));
			map.put("long_desc",(String)recordSet.get("long_desc"));
			map.put("short_desc",(String)recordSet.get("short_desc"));
			map.put("seq_no",(String)recordSet.get("seq_no"));
			map.put("eff_status",(((String)recordSet.get("eff_status")).equals("")) ? "D":(String)recordSet.get("eff_status"));
			recstorehandler.put(String.valueOf(cnt),map);
		}

		
	}
	public HashMap insert()
	{
		//Connection 	connection  = null;
		//PreparedStatement pstmt_update = null ;
		//ResultSet resultSet = null ;

		
		HashMap map = new HashMap();
		try{
		//connection   =getConnection();
		HashMap sqlMap = new HashMap() ;
		HashMap tabData = new HashMap() ;

		//tabData.put("facility_id",(String)all_values.get("facility_id"+i));
		tabData.put("recstorehandler",recstorehandler);
		tabData.put("properties", getProperties());
		tabData.put("added_by_id"		  ,login_by_id) ;
		tabData.put("added_at_ws_no"     ,login_at_ws_no ) ;
		tabData.put("added_facility_id"  ,login_facility_id ) ;
		tabData.put("modified_by_id"		  ,login_by_id) ;
		tabData.put("modified_at_ws_no"     ,login_at_ws_no ) ;
		tabData.put("modified_facility_id"  ,login_facility_id ) ;

		sqlMap.put("SQL_OR_ANTIBIOTIC_INSERT",OrRepositoryExt.getOrKeyValue("SQL_OR_ANTIBIOTIC_INSERT"));
		sqlMap.put("SQL_OR_ANTIBIOTIC_DUPLICATE_CHK",OrRepositoryExt.getOrKeyValue("SQL_OR_ANTIBIOTIC_DUPLICATE_CHK"));

		
		InitialContext context = new InitialContext();
		Object object = context.lookup(OrRepositoryExt.getOrKeyValue("OR_ANTIBIOTIC_JNDI"));
		ORAntibioticHome home  = (ORAntibioticHome)PortableRemoteObject.narrow( object, ORAntibioticHome.class );
		ORAntibioticRemote remote = home.create();

			map = remote.insert(tabData, sqlMap );
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		//clear();
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag" , "false");
		map.put( "traceVal","");
		map.put( "message", map.get("message"));
		return map;
	}
	public HashMap modify()
	{
		
		HashMap map = new HashMap();
		try{

		HashMap sqlMap = new HashMap() ;
		HashMap tabData = new HashMap() ;

		//tabData.put("facility_id",(String)all_values.get("facility_id"+i));
		tabData.put("recstorehandler",recstorehandler);
		tabData.put("properties", getProperties());
		tabData.put("added_by_id"		  ,login_by_id) ;
		tabData.put("added_at_ws_no"     ,login_at_ws_no ) ;
		tabData.put("added_facility_id"  ,login_facility_id ) ;
		tabData.put("modified_by_id"		  ,login_by_id) ;
		tabData.put("modified_at_ws_no"     ,login_at_ws_no ) ;
		tabData.put("modified_facility_id"  ,login_facility_id ) ;

		sqlMap.put("SQL_OR_ANTIBIOTIC_UPDATE",OrRepositoryExt.getOrKeyValue("SQL_OR_ANTIBIOTIC_UPDATE"));
		//sqlMap.put("SQL_OR_ANTIBIOTIC_DUPLICATE_CHK",OrRepositoryExt.getOrKeyValue("SQL_OR_ANTIBIOTIC_DUPLICATE_CHK"));

		InitialContext context = new InitialContext();
		Object object = context.lookup(OrRepositoryExt.getOrKeyValue("OR_ANTIBIOTIC_JNDI"));
		ORAntibioticHome home  = (ORAntibioticHome)PortableRemoteObject.narrow( object, ORAntibioticHome.class );
		ORAntibioticRemote remote = home.create();

			map = remote.modify(tabData, sqlMap );

		}catch(Exception e)
		{
			e.printStackTrace();
		}
		//clear();
		return map;
	}
	public HashMap delete()
	{
		return null;
	}
	public HashMap validate()
	{
		int count= 0;
		HashMap map = new HashMap();
		if(mode.equalsIgnoreCase("1"))
		{
		
		int noOfRecords = Integer.parseInt((String )allValues.get("noOfRecords"));
		String arrCodes[]  = new String[noOfRecords];
		for(int k=0;k<noOfRecords;k++)
		{
			if( (String )allValues.get("code"+k) != null && !((String )allValues.get("code"+k)).equals(""))
				arrCodes[k] = (String )allValues.get("code"+k);
		}
		for(int k=0;k<noOfRecords;k++)
		{
			
			count = 0;
			String temp = (String )allValues.get("code"+k);
			for(int j=0;j<arrCodes.length;j++)
			{
				
				if(temp.trim().equalsIgnoreCase( arrCodes[j] ))
					count++;
			}
				if(count > 1)
				{
					
					map.put( "result", new Boolean( false ) ) ;
					map.put( "flag" , "false");
					map.put( "traceVal","");
					//map.put( "invalidCode" , "Duplicate Codes Values Found"); 
					map.put( "message", getMessage(language_id,"DUPLICATE_CODE_EXISTS","Common"));
					return map;
				}
		}
		}

		
		map.put( "result", new Boolean( true ) ) ;
		map.put( "traceVal","");
		map.put( "flag" , "true");
		map.put( "message", "");
		
		return map ;
	}

	public String getEffStatus(String code)
	{
		Connection 	connection  = null;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String eff_status = "";
		try
		{
			connection   =getConnection();
			pstmt		 =connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ANTIBIOTIC_EFF_STATUS"));
			pstmt.setString(1,code.trim());
			resultSet	 = pstmt.executeQuery();
			while(resultSet != null && resultSet.next())
			{
				eff_status = resultSet.getString("eff_status");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally
		{
			try
			{
				closeResultSet(resultSet) ;
				closeStatement(pstmt) ;
				closeConnection(connection);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	return eff_status.trim();
	}
	/*
	public void clear()
	{
		recstorehandler = null;
		allValues = null;
	}
	*/
}
