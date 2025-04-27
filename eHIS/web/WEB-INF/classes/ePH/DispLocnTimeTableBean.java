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
import ePH.Common.* ;
import eCommon.Common.* ;
import eCommon.SingleTableHandler.*;

public class DispLocnTimeTableBean extends PhAdapter implements Serializable 
{
	
	protected Hashtable hashMultiple;
	protected String mode		="";
	protected String locale		="";
	
	public DispLocnTimeTableBean() 
	{
		try 
		{
			doCommon();
		}
		
		catch(Exception e) { e.printStackTrace();}
	}

 public void setLanguageId(String locale)
	{
	  this.locale=locale;
	}

public String getLanguageId()
	{
	return this.locale;
	}


	/* Over-ridden Adapter methods start here */
	public void clear() 
	{
		super.clear() ;
	}

	private void doCommon() throws Exception 
	{
	}

	/* Over-ridden Adapter methods end here */


	
	public void setAll(Hashtable recordSetMultiple)
	{
		
			        
			
		
		this.mode =(String)recordSetMultiple.get("mode");		
		if (mode.equals(CommonRepository.getCommonKeyValue( "MODE_INSERT" ))){
			hashMultiple = recordSetMultiple ;
					//System.err.println("hashMultiple----->"+hashMultiple);
		}else if(mode.equals(CommonRepository.getCommonKeyValue( "MODE_MODIFY" ))){
		
		//System.err.println("modify block");

		}
		
	} 
		



	public HashMap validate() throws Exception 
	{
		HashMap map=new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map;
	}
	// setAll method to set all the values
	
 public ArrayList getDispList(String facility_id,String locale)
	 {

	    Connection connection	 =		null ;
		PreparedStatement pstmt	 =		null ;
		ResultSet resultSet		 =		null ;
		ArrayList DispArraylist  =		new ArrayList();
	try{
		connection	 = getConnection() ;
		pstmt			 = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DISP_LOCN_TIME_SELECT1" )) ;
		//pstmt			 = connection.prepareStatement("select DISP_LOCN_CODE, LONG_DESC from ph_disp_locn_lang_vw where facility_id = ? and eff_status = 'E' and language_id = ? order by long_desc");
        pstmt.setString(1,facility_id);
        pstmt.setString(2,locale);
		resultSet      = pstmt.executeQuery() ;
		while (resultSet.next()) {
				HashMap rec		=	new HashMap();
				String code,desc;
				code					=	resultSet.getString("DISP_LOCN_CODE");
				desc					=	resultSet.getString("LONG_DESC");
				rec.put("code",code);
				rec.put("desc",desc);
				DispArraylist.add(rec);
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { 
				es.printStackTrace() ;
			}
		}
		return DispArraylist;
	  }





public ArrayList getQueryResult(String facility_id,String disp_code)
	 {
	    Connection connection	 =		null ;
		PreparedStatement pstmt	 =		null ;
		ResultSet resultSet		 =		null ;
		ArrayList ResultArraylist  =		new ArrayList();
	try{
		connection	 = getConnection() ;
		pstmt			 = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DISP_LOCN_TIME_SELECT2" )) ;
		//pstmt			 = connection.prepareStatement("Select -3 DISP_SEQ, '0' DAY_TYPE_CODE,'ALLDAYS' DAY_TYPE_LEGEND,null FROM_TIME_HH, null FROM_TIME_MM, null TO_TIME_HH,null TO_TIME_MM,'I' DB_ACTION FROM DUAL WHERE 0 NOT IN (SELECT DAY_TYPE FROM PH_DISP_LOCN_TIME_TABLE WHERE FACILITY_ID=? AND DISP_LOCN_CODE = ? AND DAY_TYPE = 0) UNION ALL Select -2 DISP_SEQ, '9' DAY_TYPE_CODE,'HOLIDAYS' DAY_TYPE_LEGEND,null FROM_TIME_HH, null FROM_TIME_MM, null TO_TIME_HH,null TO_TIME_MM,'I' DB_ACTION  FROM DUAL WHERE 9 NOT IN (SELECT DAY_TYPE FROM PH_DISP_LOCN_TIME_TABLE WHERE FACILITY_ID=? AND DISP_LOCN_CODE = ? AND DAY_TYPE = 9) UNION ALL Select -1 DISP_SEQ, '8' DAY_TYPE_CODE,'WORKINGDAYS' DAY_TYPE_LEGEND,null FROM_TIME_HH, null FROM_TIME_MM, null TO_TIME_HH,null TO_TIME_MM,'I' DB_ACTION FROM DUAL WHERE 8 NOT IN (SELECT DAY_TYPE FROM PH_DISP_LOCN_TIME_TABLE WHERE FACILITY_ID=? AND DISP_LOCN_CODE = ? AND DAY_TYPE = 8) UNION ALL SELECT TO_NUMBER(DAY_NO) DISP_SEQ, DAY_NO DAY_TYPE_CODE,DAY_OF_WEEK DAY_TYPE_LEGEND,null FROM_TIME_HH, null FROM_TIME_MM, null TO_TIME_HH,null TO_TIME_MM,'I' DB_ACTION FROM SM_DAY_OF_WEEK WHERE DAY_NO NOT IN (SELECT DAY_TYPE FROM PH_DISP_LOCN_TIME_TABLE WHERE FACILITY_ID=? AND DISP_LOCN_CODE = ?) UNION ALL SELECT A.DAY_TYPE DISP_SEQ, TO_CHAR(A.DAY_TYPE) DAY_TYPE_CODE, B.DAY_OF_WEEK,    TO_CHAR(A.FROM_TIME,'HH24') FROM_TIME_HH, TO_CHAR(A.FROM_TIME,'MI') FROM_TIME_MM, TO_CHAR(A.TO_TIME,'HH24') TO_TIME_HH, TO_CHAR(A.TO_TIME,'MI') TO_TIME_MM,'U' DB_ACTION FROM PH_DISP_LOCN_TIME_TABLE A, SM_DAY_OF_WEEK B WHERE a.FACILITY_ID=? AND a.DISP_LOCN_CODE = ? AND A.DAY_TYPE = B.DAY_NO UNION ALL SELECT A.DAY_TYPE DISP_SEQ, TO_CHAR(A.DAY_TYPE) DAY_TYPE_CODE, DECODE(A.DAY_TYPE,'0','ALLDAYS','9','HOLIDAYS','8','WORKINGDAYS') DAY_OF_WEEK, TO_CHAR(A.FROM_TIME,'HH24') FROM_TIME_HH, TO_CHAR(A.FROM_TIME,'MI') FROM_TIME_MM, TO_CHAR(A.TO_TIME,'HH24') TO_TIME_HH, TO_CHAR(A.TO_TIME,'MI') TO_TIME_MM, 'U' DB_ACTION FROM PH_DISP_LOCN_TIME_TABLE A WHERE a.FACILITY_ID=? AND a.DISP_LOCN_CODE = ? and  A.DAY_TYPE in (0,8,9) ORDER BY DAY_TYPE_CODE");
       	pstmt.setString(1,facility_id);
        pstmt.setString(2,disp_code);
		pstmt.setString(3,facility_id);
		pstmt.setString(4,disp_code);
        pstmt.setString(5,facility_id);
		pstmt.setString(6,disp_code);
		pstmt.setString(7,facility_id);
		pstmt.setString(8,disp_code);
		pstmt.setString(9,facility_id);
		pstmt.setString(10,disp_code);
		pstmt.setString(11,facility_id);
		pstmt.setString(12,disp_code);

		resultSet      = pstmt.executeQuery() ;
		while (resultSet.next()) {
				HashMap rec		=	new HashMap();
				String day_type_code,day_type_legend,from_time_hh,from_time_mm,to_time_hh,to_time_mm,db_action="";

				day_type_code			  =	resultSet.getString("DAY_TYPE_CODE");
				day_type_legend			  =	resultSet.getString("DAY_TYPE_LEGEND");
				from_time_hh			  =	resultSet.getString("FROM_TIME_HH");
				from_time_mm			  =	resultSet.getString("FROM_TIME_MM");
				to_time_hh				  =	resultSet.getString("TO_TIME_HH");
				to_time_mm				  =	resultSet.getString("TO_TIME_MM");
				db_action				  =	resultSet.getString("DB_ACTION");
				
				rec.put("day_type_code",day_type_code);
				rec.put("day_type_legend",day_type_legend);
				rec.put("from_time_hh",from_time_hh);
				rec.put("from_time_mm",from_time_mm);
				rec.put("to_time_hh",to_time_hh);
				rec.put("to_time_mm",to_time_mm);
				rec.put("db_action",db_action);
				ResultArraylist.add(rec);
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { 
				es.printStackTrace() ;
			}
		}
		return ResultArraylist;
	  }

// insert Method  starts here...
	public HashMap insert() {

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		ArrayList insertData = new ArrayList() ;
		ArrayList modifyRow = new ArrayList() ;
		ArrayList modifyData = new ArrayList() ;
		HashMap sqlMap = new HashMap() ; 
		HashMap tabData = new HashMap() ;
	 	String db_action="";
		String msgId="";
		
	//String sql_insert ="Insert into PH_DISP_LOCN_TIME_TABLE(FACILITY_ID, DISP_LOCN_CODE, DAY_TYPE, SRL_NO, FROM_TIME, TO_TIME,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID,MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID)values(?,?,?,1,to_date(to_char(sysdate,'ddmmyyyy')||?||?,'ddmmyyyyhh24mi'), to_date(to_char(sysdate,'ddmmyyyy')||?||?,'ddmmyyyyhh24mi'),?,SYSDATE,?,?,?,SYSDATE,?,?)";
   // String sql_update =" update ph_DISP_LOCN_TIME_TABLE set from_time = to_date(to_char(sysdate,'ddmmyyyy')||?||?,'ddmmyyyyhh24mi'),to_time   =to_date(to_char(sysdate,'ddmmyyyy')||?||?,'ddmmyyyyhh24mi'),MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? where facility_id = ? and disp_locn_code = ?and day_type = ?" ;
		

		try{

			for(int i=0; i<10;i++)
			{
			
				ArrayList insertRow = new ArrayList() ;
				
				db_action=(String)hashMultiple.get(("db_action" + i)) ;		
				
					if(db_action.equals("I")){
                        insertRow = new ArrayList();
						insertRow.add( (String)hashMultiple.get("facility_id" )) ;
						insertRow.add( (String)hashMultiple.get("disp_code"   )) ;
						insertRow.add( (String)hashMultiple.get(("day_type_code" + i)) ) ;
											
						String from_time_hh=(String)hashMultiple.get(("from_time_hh" + i));
						if(!from_time_hh.equals(""))
						{
						
						String aa[]=from_time_hh.split(":");
                       
						insertRow.add(aa[0]) ;
						insertRow.add(aa[1]) ;
						}else if(from_time_hh.equals(""))
						{
                         insertRow.add("") ;
						  insertRow.add("") ;
						}
						
						String to_time_hh=(String)hashMultiple.get(("to_time_hh" + i));
						if(!to_time_hh.equals(""))
						{
						String bb[]=to_time_hh.split(":");
						insertRow.add(bb[0]) ;
						insertRow.add(bb[1]) ;
				        }else if(to_time_hh.equals(""))
						{
							insertRow.add("") ;
						    insertRow.add("") ;
						}
						insertRow.add( login_by_id ) ;
						insertRow.add( login_at_ws_no ) ;
						insertRow.add( login_facility_id ) ;
						insertRow.add( login_by_id ) ;
						insertRow.add( login_at_ws_no ) ;
						insertRow.add( login_facility_id ) ;
						if(!from_time_hh.equals(""))
						{
							if(!to_time_hh.equals(""))
						  {
						    insertData.add( insertRow ) ;
						  }
						}
					}else if(db_action.equals("U"))
						{
						modifyRow = new ArrayList();
						String from_time_hh=(String)hashMultiple.get(("from_time_hh" + i));
						if(!from_time_hh.equals(""))
							{
						 String aa[]=from_time_hh.split(":");
						modifyRow.add(aa[0]) ;
						modifyRow.add(aa[1]) ;
							}else if(from_time_hh.equals(""))
							{
                             modifyRow.add("") ;
						     modifyRow.add("") ;
							}
						String to_time_hh=(String)hashMultiple.get(("to_time_hh" + i));
						if(!to_time_hh.equals(""))
							{
						 String bb[]=to_time_hh.split(":");
						modifyRow.add(bb[0]) ;
						modifyRow.add(bb[1]) ;
							}else if(to_time_hh.equals(""))
							{
								modifyRow.add("") ;
						        modifyRow.add("") ;
							}
						modifyRow.add(login_by_id);     
						modifyRow.add(login_at_ws_no);
						modifyRow.add(login_facility_id);
						modifyRow.add( (String)hashMultiple.get("facility_id")) ;
						modifyRow.add( (String)hashMultiple.get("disp_code"));
						modifyRow.add( (String)hashMultiple.get(("day_type_code" + i)) ) ;
						modifyData.add(modifyRow);
						
					   }

				}
			
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER" ),SingleTableHandlerHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

           	Object argArray[] = new Object[2];
			argArray[0] = tabData;
			argArray[1] = sqlMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = tabData.getClass(); ;
			paramArray[1] = sqlMap.getClass();
           if(insertData.size() > 0){
			   //System.err.println("insert block");
				tabData.put("properties", getProperties());
				tabData.put("InsertData", insertData);
				//sqlMap.put("InsertSQL", sql_insert);
			    sqlMap.put("InsertSQL",PhRepository.getPhKeyValue("SQL_PH_DISP_LOCN_TIME_INSERT"));

				map = (HashMap)(busObj.getClass().getMethod("singleBatchHandler",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			}
			if(modifyData.size() > 0){
			  // System.err.println("update block");
					tabData.clear();
					sqlMap.clear();
					tabData.put( "properties", getProperties() );
					tabData.put( "InsertData", modifyData);
				    //sqlMap.put( "InsertSQL", sql_update);
					sqlMap.put("InsertSQL",PhRepository.getPhKeyValue("SQL_PH_DISP_LOCN_TIME_UPDATE"));
					map = (HashMap)(busObj.getClass().getMethod("singleBatchHandler",paramArray)).invoke(busObj,argArray);
					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				}
			

             if( ((Boolean) map.get( "result" )).booleanValue() )
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
			else {
				msgId = (String)map.get( "msgid" )==null?"":(String)map.get( "msgid" );
				if( (msgId).equals( "CODE_ALREADY_EXISTS" ) ) {
					map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"Common") ) ;
					String msgID = getMessage((String) map.get( "msgid" ),false) ;
					//msgID = msgID.substring(0,(msgID.indexOf("<br>"))) ;
					map.put( "message", msgID  ) ;
					map.put( "invalidCode", delimitedString( (ArrayList)map.get("invalidCode")) ) ;
				}
				else if (msgId.equals("")){
					map.put( "message",getMessage(getLanguageId(),"PH_NO_CHANGE","PH") ) ;
				}
				else
					map.put( "message", (map.get("msgid"))) ;
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return map ;
	}//insert ends








	
} 
