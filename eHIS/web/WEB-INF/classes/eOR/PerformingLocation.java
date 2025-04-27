/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      		Name        	Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------------------------------
09/01/2019		IN066377			Kamalakannan G		09/01/2019		Ramesh G.		AMS-CRF-0139 
06/02/2019		IN069673			Kamalakannan G		06/02/2019		Ramesh G.		AMS-CRF-0139/02
------------------------------------------------------------------------------------------------------------------------------------------------------
*/
package eOR;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import eOR.Common.* ;
import eCommon.Common.*;

import javax.rmi.* ;
import javax.naming.* ;
import eOR.ORPerformLocation.*;

public class PerformingLocation extends OrAdapter implements java.io.Serializable{

	protected Hashtable all_values = new Hashtable();
	public String mode = "";
	protected String long_desc = "";
	protected String short_desc = "";
	protected String eff_status = "";
	protected String int_or_ext = "";


	public void  setLongDesc(String  long_desc) {this.long_desc=  long_desc; } ;
	public void  setShortDesc(String short_desc) {this.short_desc=  short_desc; } ;
	public void  setEffStatus(String eff_status) {this.eff_status=  eff_status;};
	public void  setIntOrExt(String int_or_ext) {this.int_or_ext = int_or_ext;};
	public String getLongDesc() {return long_desc; } ;
	public String getShortDesc() {return short_desc; } ;
	public String getEffStatus() {return eff_status; } ;
	public String getIntOrExt() {return this.int_or_ext; };

    public String getLbInstall(String module_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String lb_install_yn	= "N";
		try{
			connection	= getConnection();
			pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN"));
			pstmt.setString(1, checkForNull(module_id.trim(),""));
			pstmt.setString(2, login_facility_id);
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )
			{
				while(resultSet.next())
				{
					lb_install_yn = checkForNull(resultSet.getString( "operational_yn" ),"N")  ;
				}
			}
		}catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			} catch (Exception ee) {ee.printStackTrace() ;}
		}
		return lb_install_yn;
	}

	public ArrayList loadLocationType(String facility_id){
		Connection 	connection  = null;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;

		ArrayList all_location_type = new ArrayList();
		String[] location_type = new String[2];

		try	{
			connection  = getConnection();
			pstmt		= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_PERFORMING_FACILITY_OPERATIONAL_MODULE"));
			pstmt.setString(1,facility_id.trim());
			resultSet	= pstmt.executeQuery();

			while(resultSet.next())	{
				location_type[0] = resultSet.getString("module_id");
				location_type[1] = checkForNull(resultSet.getString("operational_yn"),"N");
				all_location_type.add(location_type);
			}
		}catch(Exception e){e.printStackTrace() ;

		}finally{
			try{
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			 }catch(Exception e){e.printStackTrace() ;
			 }
		}
		return all_location_type;
	}


	public void loadData(String locn_type, String code){
		Connection 	connection  = null;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		try	{
			connection  = getConnection();
			pstmt		= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_PERFORM_LOCN_LOAD_DATA"));
			pstmt.setString(1,locn_type.trim());
			pstmt.setString(2,code.trim());
			resultSet	= pstmt.executeQuery();

			while(resultSet.next())	{
				setShortDesc(ChkDef.defaultString(resultSet.getString("performing_deptloc_short_desc")));
				setLongDesc(ChkDef.defaultString(resultSet.getString("performing_deptloc_long_desc")));
				setEffStatus(ChkDef.defaultString(resultSet.getString("eff_status")));
				setIntOrExt(ChkDef.defaultString(resultSet.getString("int_or_ext")));
			}

		}catch(Exception e){e.printStackTrace() ;

		}finally{
			try{
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			 }catch(Exception e){e.printStackTrace() ;
			 }
		}
	}


	public HashMap insert(){
		HashMap recordStore = new HashMap() ;
		HashMap sqlMap = new HashMap();
		int counter = 0 ;

		int totalRecords = Integer.parseInt((String)all_values.get("totalRecords"));
		try{
			String ID="";
			HashMap tabData =null;
			for(int i=0 ; i < totalRecords ; i++)
			 {
				ID = "code"  + i ;
				tabData = new HashMap() ;
				tabData.put(("facility_id"),(String)all_values.get(("facility_id")));
				tabData.put(("locn_type"),(String)all_values.get(("locn_type")));
				if(!((String)all_values.get(ID)).trim().equals("")){
					tabData.put(("code"), (String)all_values.get(("code" + i))) ;
					tabData.put(("long_desc"),(String)all_values.get(("long_desc"+ i))) ;
					tabData.put(("short_desc"),(String)all_values.get(("short_desc"+ i))) ;
					tabData.put(("enabled"),(((String)all_values.get("enabled"+ i)).trim().equals(""))?"D":"E") ;
					tabData.put(("intext"),(((String)all_values.get("intext"+i)).trim().equals(""))?"I":"X");//Added by Subhash.Y
					tabData.put(("added_by_id"),login_by_id) ;
					tabData.put(("added_at_ws_no"),login_at_ws_no) ;
					tabData.put(("added_facility_id"),login_facility_id) ;
					tabData.put(("modified_by_id"),login_by_id) ;
					tabData.put(("modified_facility_id"),login_facility_id );
					tabData.put(("modified_at_ws_no"),login_at_ws_no) ;
					recordStore.put(String.valueOf(++counter),tabData);
					//counter++;
				 }
			 }

			sqlMap.put("SQL_OR_PERFORM_LOCN_INSERT", OrRepository.getOrKeyValue("SQL_OR_PERFORM_LOCN_INSERT") );
			sqlMap.put("SQL_OR_PERFORM_LOCN_DUPLICATE_CHK_MULIPLE",OrRepository.getOrKeyValue("SQL_OR_PERFORM_LOCN_DUPLICATE_CHK_MULIPLE"));
			return getResult(recordStore,sqlMap );
		}catch(Exception e){
			System.out.println("Exception here in Bean : "+ e) ;
			logErrorMessage(e);
			return null;
		}

	}

/*********************METHOD TO Update*************************/

	public HashMap modify(){
	//IN066377 start
		String function_id=(String)all_values.get(("function_id"))==null?"":(String)all_values.get(("function_id"));
		Connection con 		= null;
		PreparedStatement pstmt 	= null;	
		HashMap map = new HashMap() ;
        map.put( "flag","") ;
		map.put( "traceVal","");
		boolean	flag		  = false;
		StringBuffer messages = new StringBuffer() ;
		StringBuffer traceVal = new StringBuffer() ;
		if(!function_id.equals("Perf_locn_mand")){
	//IN066377 end	
			try{
			HashMap record = new HashMap();
			HashMap sqlMap = new HashMap();
			String enabled = "";
			sqlMap.put("SQL_OR_PERFORM_LOCN_UPDATE",OrRepository.getOrKeyValue("SQL_OR_PERFORM_LOCN_UPDATE"));
			record.put(("facility_id"),(String)all_values.get(("facility_id")));
			record.put(("locn_type"),(String)all_values.get(("locn_type")));
			record.put(("code"), (String)all_values.get(("code"))) ;
			record.put(("long_desc"),(String)all_values.get(("long_desc"))) ;
			record.put(("short_desc"),(String)all_values.get(("short_desc"))) ;
			enabled = ((String)all_values.get(("enabled_status")) );
			if(enabled==null || enabled.equals("") || enabled=="")
				enabled = "";
			if(enabled.equals(""))
				record.put(("eff_status"),"D");
			else 
				record.put(("eff_status"),(String)all_values.get(("enabled_status")));
			record.put(("int_or_ext"),int_or_ext);
			record.put(("modified_by_id"),login_by_id) ;
			record.put(("modified_facility_id"),login_facility_id );
			record.put(("modified_at_ws_no"),login_at_ws_no) ;
			return getResult(record,sqlMap );
			}catch(Exception e){
				System.out.println("here in exception "+e);
				logErrorMessage(e);
				return null;
		//IN066377 start		
			}
		}else{
			try{
				con = getConnection(); 
				int totalNum = 0;
				if(all_values.containsKey("totalRecords"))
					totalNum = Integer.parseInt((String)all_values.get("totalRecords"));
				String sql = "UPDATE OR_ORDER_PERF_LOCN_MAND SET DC=?,EM=?,OP =?,IP=?,XT=? WHERE ORDER_CATEGORY=?";
				pstmt = con.prepareStatement(sql);
				
				String orCat = null;
				String chk1 = null;
				String chk2 = null;
				String chk3 = null;
				String chk4 = null;
				String chk5 = null;
				totalNum=totalNum-1;
				for (int i = 0; i <= totalNum; i++) {
					orCat = "";
					chk1 = "";
					chk2 = "";
					chk3 = "";
					chk4 = "";
					chk5 = "";

	 				if(all_values.containsKey("order_cat"+i))
						orCat  = (String) all_values.get("order_cat"+i); 
	 				
					if(all_values.containsKey("chk1_"+i))
						chk1   = (String) all_values.get("chk1_"+i);
					chk1 = chk1.equals("")?"N":chk1;

					if(all_values.containsKey("chk2_"+i))
						chk2   = (String) all_values.get("chk2_"+i);
					chk2 = chk2.equals("")?"N":chk2;

					if(all_values.containsKey("chk3_"+i))
						chk3   = (String) all_values.get("chk3_"+i);
					chk3 = chk3.equals("")?"N":chk3;

					if(all_values.containsKey("chk4_"+i))
						chk4   = (String) all_values.get("chk4_"+i);
					chk4 = chk4.equals("")?"N":chk4;
					
					if(all_values.containsKey("chk5_"+i))
						chk5   = (String) all_values.get("chk5_"+i);
					chk5 = chk5.equals("")?"N":chk5;

					pstmt.setString(1,chk1);
					pstmt.setString(2,chk2);
					pstmt.setString(3,chk3);
					pstmt.setString(4,chk4);
					pstmt.setString(5,chk5);
					pstmt.setString(6,orCat);
					pstmt.addBatch();
				}
				int [] updateCounts = pstmt.executeBatch();	
				flag = true;
				
				for (int k=0;k<updateCounts.length ;k++ )
				{
					if(updateCounts[k]<0  && updateCounts[k] != -2 )
					{
						flag=false;
						break;
					}
				}

				if(flag == true)
				{
					messages.append( getMessage(language_id, "RECORD_MODIFIED", "SM") ) ;				
	    			con.commit() ;
				}
				else
				{
					con.rollback();
				}
			}catch(Exception e){
				flag = false;
				traceVal.append(e.getMessage());
				e.printStackTrace();
				try
				{
					con.rollback();
				}
				catch(Exception e1)
				{
					traceVal.append(e1.getMessage());
					e1.printStackTrace();
				}
			}finally{
				map.clear();

				if(pstmt != null)	
				{
					try
					{
						pstmt.close();
					}
					catch(Exception e)
					{
						e.printStackTrace();
						traceVal.append(e.getMessage());
					}
				}

				if(con != null)
				{
					try
					{
						closeConnection(con);
					}
					catch(Exception e)
					{
						e.printStackTrace();
						traceVal.append(e.getMessage());
					}
				}
			}
			map.put( "result", new Boolean(flag));
			map.put( "message", messages.toString() ) ;
			map.put( "traceVal", traceVal.toString() ) ;
	   		return map ;
			//IN066377 end
		}
	}

/**********This Method  Actually Calls the EJB's Method ********************/
 private  HashMap getResult(HashMap record , HashMap sqlMap )
 {
		HashMap map  = new HashMap() ;
		try
		{
			/*System.err.println("Inside getResult @@@@@ of Perfm Locn");
			InitialContext context = new InitialContext();
			System.err.println("Before Lookup");
			Object object		   = context.lookup(OrRepository.getOrKeyValue("OR_PERFORMING_LOCATION_JNDI"));
			System.err.println("After Lookup");
			ORPerformLocationHome home  = (ORPerformLocationHome) PortableRemoteObject.narrow( object,ORPerformLocationHome.class );
			System.err.println("After Home");
			ORPerformLocationRemote remote = home.create() ;
			System.err.println("After Remote and Home Create");*/
			/*eOR.ORPerformLocation.ORPerformLocationManager remote = new eOR.ORPerformLocation.ORPerformLocationManager();*/

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("OR_PERFORMING_LOCATION_JNDI"), ORPerformLocationHome.class, getLocalEJB());
    		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			HashMap tabDataParam =  new HashMap() ;
			tabDataParam.put( "properties", getProperties() );
			tabDataParam.put( "records",     record );

		  Object argArray[]	= new Object[2];
			argArray[0]		= tabDataParam;
			argArray[1]		= sqlMap;
 		  Class [] paramArray = new Class[2];
 		 	paramArray[0]	= tabDataParam.getClass();
			paramArray[1]	= sqlMap.getClass();
 				

			if(mode.equals( CommonRepository.getCommonKeyValue("MODE_DELETE"))){
				return null ;
			}else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
				//map = remote.insert(tabDataParam, sqlMap ) ;
				map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

			}else  if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))){
			   // map = remote.modify(tabDataParam, sqlMap ) ;
			   map = (java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			}
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
		 
		    argArray	= null;
		    paramArray	= null;


         map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;

		 // return map;

	  }catch(Exception e){
		System.out.println( "Error Calling EJB :" + e ) ;
		map.put( "message", e.getMessage() );
		e.printStackTrace() ;
		//return map ;
	  }
return map ;
 }//End of Method



/**
	This will set all the values to set methods - persistant methods
	@param		:   recordSet-Hashtable
	@return		:	void
*/

	public void setAll( Hashtable recordSet ) {
		all_values = recordSet;
		this.mode = (String)recordSet.get( "mode" );
		/*if(recordSet.containsKey("enabled")){
			System.err.println("record set contains enabled @@@@@@@@@");
            String s = (String)recordSet.get("enabled");
            //if(!s.equals(""))
            //    setEffStatus("E");
            //else
            //    setEffStatus("D");
			setEffStatus(s);

        }*/
		//Modified by Subhash.Y on 11th May 2004 to a column to the database with the name
		//Inter / External -
		if(recordSet.containsKey("intext"))
		{
			String str = (String) recordSet.get("intext");
			if(str.equals("") || str.equals(" "))
				str = "I";
			setIntOrExt(str);
		}
	}

/**
	This will clear all the values of all bean variables
	@return		:	void
*/
public HashMap validate() throws Exception
{
	HashMap map = new HashMap();

	map.put( "result", new Boolean( true ) ) ;
	map.put( "message", "success.." );

	return map;
}
	public void clear() {

		long_desc	= ""    ;
		short_desc	= ""    ;
		eff_status = ""	;
		int_or_ext = "";
		super.clear() ;
	}
	//IN066377 start
	public ArrayList generateMandatoryRows(){
		ArrayList<String[]> perfLocManRowValues = new ArrayList<String[]>();
		Connection 	connection  = null;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		try	{
			connection  = getConnection();
			String rd_install_yn =  rdInstallYN(connection);
			pstmt		= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_PERFORM_LOCN_MAND"));
			resultSet	= pstmt.executeQuery();
			while(resultSet.next())	{
				String row_val[]=new String[8];//IN069673
				row_val[0] = checkForNull(resultSet.getString( "ORDER_CATEGORY" ),""); 
				if("N".equals(rd_install_yn) && "RD".equals(row_val[0])){
					row_val[1] = checkForNull(resultSet.getString( "SHORT_DESC" ),"");//IN069673
					row_val[2] = "N";//IN069673
					row_val[3] = "N";//IN069673
					row_val[4] = "N";//IN069673
					row_val[5] = "N";//IN069673
					row_val[6] = "N";//IN069673
					row_val[7] = checkForNull(resultSet.getString( "EFF_STATUS" ),"E");//IN069673
				}else{
					row_val[1] = checkForNull(resultSet.getString( "SHORT_DESC" ),"");//IN069673
					row_val[2] = checkForNull(resultSet.getString( "DC" ),"N");//IN069673
					row_val[3] = checkForNull(resultSet.getString( "EM" ),"N");//IN069673
					row_val[4] = checkForNull(resultSet.getString( "OP" ),"N");//IN069673
					row_val[5] = checkForNull(resultSet.getString( "IP" ),"N");//IN069673
					row_val[6] = checkForNull(resultSet.getString( "XT" ),"N");//IN069673
					row_val[7] = checkForNull(resultSet.getString( "EFF_STATUS" ),"E");//IN069673
				}
				perfLocManRowValues.add(row_val);
			}
		}catch(Exception e){e.printStackTrace() ;
		}finally{
			try{
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			 }catch(Exception e){e.printStackTrace() ;
			 }
		}
		return perfLocManRowValues;
	}
	//IN066377 end
	public String rdInstallYN(Connection connection){
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String rd_install_yn = "N";
		try{
			pstmt		= connection.prepareStatement("select INSTALL_YN from sm_module where MODULE_ID='RD'");
			resultSet	= pstmt.executeQuery();
			if(resultSet.next()){
				rd_install_yn = checkForNull(resultSet.getString( "INSTALL_YN" ),"N");
			}
		}catch(Exception e){e.printStackTrace() ;
		}finally{
			try{
				closeResultSet(resultSet);
				closeStatement(pstmt);
			 }catch(Exception e){e.printStackTrace() ;
			 }
		}
		return rd_install_yn;
	}
}
