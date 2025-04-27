/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
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

public class ChartVerticalBean extends eOR.Common.OrAdapter implements Serializable
{
	protected String chart_result_type = "";
	protected String chart_vertical_code = "";
	protected String discr_msr_id = "";
	protected String copy_prev = "";
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
	public void setCopyPrevious(String prev)
	{
		this.copy_prev = prev;
	}
	public String getCopyPrevious()
	{
		return this.copy_prev;
	}
	public void setDiscreteMeasureID(String id)
	{
		this.discr_msr_id = id;
	}
	public String getDiscreteMeasureID()
	{
		return this.discr_msr_id;
	}
	public void setChartResultType(String type)
	{
		this.chart_result_type = type;
	}
	public String getChartResultType()
	{
		return this.chart_result_type;
	}
	public void setFacilityID(String id)
	{
		this.facility_id = id;
	}
	public String getFacilityID()
	{
		return this.facility_id;
	}
	public void setChartVerticalCode(String code)
	{
		this.chart_vertical_code = code;
	}
	public String getChartVerticalCode()
	{
		return this.chart_vertical_code;
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
		if(mode.equals("1"))
		{
			if(recordSet.containsKey("result_type"))
				setChartResultType((String)recordSet.get("result_type"));
		}
		else
		{
			if(recordSet.containsKey("chart_result_type"))
				setChartResultType((String)recordSet.get("chart_result_type"));
		}
		if(recordSet.containsKey("facility_id"))
			setFacilityID((String)recordSet.get("facility_id"));

		String tempCode = "";
		//String discr_msr = "";
		String cpy_prev = "";
		if(mode.trim().equalsIgnoreCase("1"))
		{
			HashMap map=null;
		for(int i=0;i<count;i++)
		{
			map = new HashMap();
			tempCode = (String)recordSet.get("code"+i);
			if(tempCode != null && !tempCode.equals(""))
			{
				map.put("chart_vertical_code",(String)recordSet.get("code"+i));
				map.put("long_desc",(String)recordSet.get("long_desc"+i));
				map.put("short_desc",(String)recordSet.get("short_desc"+i));
				map.put("seq_no",(String)recordSet.get("seq_no"+i));
				map.put("discr_msr_id", (String)recordSet.get("discr_msr_id"+i));
				cpy_prev = (String)recordSet.get("copy_prev"+i);
				if(cpy_prev == null || cpy_prev.equals("") || cpy_prev.equals(" ") || cpy_prev.equals("N"))
					cpy_prev = "N";
				else
					cpy_prev = "Y";

				map.put("copy_prev",cpy_prev);
				map.put("eff_status",(((String)recordSet.get("eff_status"+i)).equals("")) ? "D":(String)recordSet.get("eff_status"+i));

				recstorehandler.put(String.valueOf(cnt),map);
				cnt++;
			}
		}
		}
		else
		{
			HashMap map = new HashMap();
			map.put("chart_vertical_code",(String)recordSet.get("code"));
			map.put("long_desc",(String)recordSet.get("long_desc"));
			map.put("short_desc",(String)recordSet.get("short_desc"));
			map.put("seq_no",(String)recordSet.get("seq_no"));
			map.put("discr_msr_id", (String)recordSet.get("discr_msr_id"));
			cpy_prev = ((((String)recordSet.get("copy_prev")) == null) ? "":(String)recordSet.get("copy_prev"));
			map.put("copy_prev",cpy_prev);
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
		StringBuffer tmpBuff	= new StringBuffer();
		try{
		HashMap sqlMap = new HashMap() ;
		HashMap tabData = new HashMap() ;

		tabData.put("chart_result_type",chart_result_type);
		tabData.put("recstorehandler",recstorehandler);
		tabData.put("properties", getProperties());
		tabData.put("added_by_id"		  ,login_by_id) ;
		tabData.put("added_at_ws_no"     ,login_at_ws_no ) ;
		tabData.put("added_facility_id"  ,login_facility_id ) ;
		tabData.put("modified_by_id"		  ,login_by_id) ;
		tabData.put("modified_at_ws_no"     ,login_at_ws_no ) ;
		tabData.put("modified_facility_id"  ,login_facility_id ) ;

		sqlMap.put("SQL_OR_CHART_VERTICAL_INSERT",OrRepositoryExt.getOrKeyValue("SQL_OR_CHART_VERTICAL_INSERT"));
		sqlMap.put("SQL_OR_CHART_VERTICAL_DUPLICATE_CHK",OrRepositoryExt.getOrKeyValue("SQL_OR_CHART_VERTICAL_DUPLICATE_CHK"));


		/*InitialContext context = new InitialContext();
		Object object = context.lookup(OrRepositoryExt.getOrKeyValue("OR_ANTIBIOTIC_JNDI"));
		ORAntibioticHome home  = (ORAntibioticHome)PortableRemoteObject.narrow( object, ORAntibioticHome.class );
		ORAntibioticRemote remote = home.create();
			map = remote.insert(tabData, sqlMap );*/
		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepositoryExt.getOrKeyValue("OR_ANTIBIOTIC_JNDI"), ORAntibioticHome.class, getLocalEJB());
    	Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[]	= new Object[2];
			argArray[0]		= tabData;
			argArray[1]		= sqlMap;
 		Class [] paramArray = new Class[2];
 		 	paramArray[0]	= tabData.getClass();
			paramArray[1]	= sqlMap.getClass();
 		map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
					
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
				
				argArray	= null;
				paramArray	= null;
		if( ((Boolean) map.get( "result" )).booleanValue() ){
					//map.put( "message", (String) map.get( "msgid" ));
			map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
		}else{
					//map.put( "message", ((String) map.get("msgid"))) ;
			map.put( "message", getMessage(language_id, (String) map.get( "message" ), "Common")) ;
		
		}
			map.put("traceVal", (String)tmpBuff.toString());
			tmpBuff.setLength(0);
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}

		map.put( "result", new Boolean( true ) ) ;
		map.put( "flag" , "true");
		map.put( "traceVal","");
		map.put( "message", map.get("message"));

		return map;
	}
	public HashMap modify()
	{

		HashMap map = new HashMap();
		StringBuffer tmpBuff	= new StringBuffer();
		try{

		HashMap sqlMap = new HashMap() ;
		HashMap tabData = new HashMap() ;

		tabData.put("chart_result_type",chart_result_type);
		tabData.put("recstorehandler",recstorehandler);
		tabData.put("properties", getProperties());
		tabData.put("added_by_id"		  ,login_by_id) ;
		tabData.put("added_at_ws_no"     ,login_at_ws_no ) ;
		tabData.put("added_facility_id"  ,login_facility_id ) ;
		tabData.put("modified_by_id"		  ,login_by_id) ;
		tabData.put("modified_at_ws_no"     ,login_at_ws_no ) ;
		tabData.put("modified_facility_id"  ,login_facility_id ) ;

		sqlMap.put("SQL_OR_CHART_VERTICAL_UPDATE",OrRepositoryExt.getOrKeyValue("SQL_OR_CHART_VERTICAL_UPDATE"));

		/*InitialContext context = new InitialContext();
		Object object = context.lookup(OrRepositoryExt.getOrKeyValue("OR_ANTIBIOTIC_JNDI"));
		ORAntibioticHome home  = (ORAntibioticHome)PortableRemoteObject.narrow( object, ORAntibioticHome.class );
		ORAntibioticRemote remote = home.create();

			map = remote.modify(tabData, sqlMap );*/
		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepositoryExt.getOrKeyValue("OR_ANTIBIOTIC_JNDI"), ORAntibioticHome.class, getLocalEJB());
    	Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[]	= new Object[2];
			argArray[0]		= tabData;
			argArray[1]		= sqlMap;
 		Class [] paramArray = new Class[2];
 		 	paramArray[0]	= tabData.getClass();
			paramArray[1]	= sqlMap.getClass();
 		map = (java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
					
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
				
				argArray	= null;
				paramArray	= null;

				map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
				map.put("traceVal", (String)tmpBuff.toString());
		}catch(Exception e)
		{
			e.printStackTrace();
		}

		map.put( "result", new Boolean( true ) ) ;
		map.put( "flag" , "true");
		map.put( "traceVal","");
		map.put( "message", map.get("message"));
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
		String temp="";
		for(int k=0;k<noOfRecords;k++)
		{
			count = 0;
			temp = (String )allValues.get("code"+k);
			for(int j=0;j<arrCodes.length;j++)
			{

				if(temp.trim().equalsIgnoreCase( arrCodes[j] ))
					count++;
			}

			if(count > 1)
			{
					map.put( "result", new Boolean( false ) ) ;
					map.put( "message", "DUPLICATE_CODE_EXISTS");
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

	public String[] getEffStatus(String result_type,String code)
	{
		Connection 	connection  = null;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String eff_status[] = new String[2];
		try
		{
			connection   =getConnection();
			pstmt		 =connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_CHART_VERTICAL_SELECT_UPDATE"));
			pstmt.setString(1,result_type.trim());
			pstmt.setString(2,code.trim());
			resultSet	 = pstmt.executeQuery();
			while(resultSet != null && resultSet.next())
			{
				eff_status[0] = resultSet.getString("eff_status");
				eff_status[1] = resultSet.getString("chart_result_type");
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally
		{
			try
			{
				closeStatement(pstmt) ;
				closeResultSet(resultSet) ;
				closeConnection(connection);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	return eff_status;
	}

	public Vector getResultType()
	{
		Connection 	connection  = null;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		Vector objResultType = new Vector();
		try
		{
			connection   =getConnection();
			pstmt		 =connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_CHART_RESULT_TYPE"));
			resultSet	 = pstmt.executeQuery();
			while(resultSet != null && resultSet.next())
			{
				objResultType.add(resultSet.getString("chart_result_type"));
				objResultType.add(resultSet.getString("chart_result_type_desc"));
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

	return objResultType;
	}

}
