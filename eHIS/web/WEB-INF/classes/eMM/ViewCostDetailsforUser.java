/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMM ;

import java.io.* ;
import java.sql.* ;
import java.util.* ;
import eCommon.SingleTableHandler.*;
import eMM.Common.*;
import eCommon.*;
import eCommon.Common.*;

public class ViewCostDetailsforUser extends MmAdapter implements Serializable
{	
	private int RECORD_SIZE = Integer.parseInt((String)CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE"));

	private String	[]user_id					=		new String[RECORD_SIZE];
	private String	[]user_name					=		new String[RECORD_SIZE];
	private String	[]view_cost_details_yn	    =		new String[RECORD_SIZE];
	protected int	 totalRecords				=		0;
	protected String	 userid					=		"";
	protected Hashtable hashMultiple  ;
	
	public ViewCostDetailsforUser()throws Exception
	{ 
		try
		{
			doCommon();
		}
		catch(Exception e){
			e.printStackTrace();
			}
	}
//********* * Set Methods Start **************************

	
	public void setUserID(int index, String user_id) {
			user_id=user_id.trim();
			this.user_id[index]		=	user_id; 
	}


	public void setUserName(int index, String user_name) {
			
			this.user_name[index]		=	user_name; 
	}
	public void setTotalRecords(int totalRecords)
	{	
		this.totalRecords=totalRecords;
	}
	public void setUser_Id(String userid)
	{	
		
		this.userid=userid;
	}
	public void setViewCostDetails(int index, String view_cost_details_yn) {

			if(view_cost_details_yn.equals("N") || view_cost_details_yn==null || view_cost_details_yn=="")
            this.view_cost_details_yn[index]		="N" ;
        else
           
			this.view_cost_details_yn[index]		=	view_cost_details_yn;
	}
//*********** Get Methods Start *****************************	
	
	public String getUserID(int index) {
		return this.user_id[index];
	}
	public String getUserName(int index) 
	{
		
		return this.user_name[index];
	}

	public String getViewCostDetails(int index) 
	{
		return this.view_cost_details_yn[index];
	}		
	
	public int getTotalRecords() 
	{
		return this.totalRecords;
	}	
	public String getUser_Id() 
	{
		return this.userid;
	}	
	public void clear()
	{
		super.clear();
		
	}
//********************* setAll  *******************************************************/
    public void setAll( Hashtable recordSetMultiple ) {
        hashMultiple = recordSetMultiple ;
        this.mode =(String)recordSetMultiple.get("mode");
		if(mode.equals("1"))
		{
			for (int index=0;index<RECORD_SIZE;index++) {
			   String user_id			=	(String)recordSetMultiple.get("user_id"+index);

			   if((user_id!= null) || (!(user_id.equals("")))) {

			   String user_name					=		(String)recordSetMultiple.get("user_name"+index);
			   String view_cost_details_yn		=		(String)recordSetMultiple.get("view_cost_details_yn"+index);
			
				setUserID(index, user_id);
				setUserName(index, user_name);
				if(view_cost_details_yn==null || view_cost_details_yn.trim().equals(""))
					setViewCostDetails	(index, "N");
				else
					setViewCostDetails	(index, view_cost_details_yn);
					 
				}
			}
		}
		else
		{
				  String user_id				=		(String)recordSetMultiple.get("user_id");
				  setUser_Id(user_id);
				 
		}
				  
			
	}

//*************************************************************************
	public HashMap validate() throws Exception {
	
				HashMap map						=		new HashMap() ;
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", "" ) ;
				return map ;
    }
	private void doCommon() throws Exception 
	{
	}
	public HashMap insert()
	{
		ArrayList insertData					=		new ArrayList() ;
		ArrayList whereData					    =		new ArrayList() ;
		ArrayList LanguageData					=		new ArrayList() ;

		for(int i=0; i<RECORD_SIZE;i++)
		{	
				String userid					=		"user_id"  + i ;
			//  String username					=		"user_name"  + i ;
			//	String viewcostdetails_yn		=		 "view_cost_details_yn"  + i ;
				
				ArrayList insertRow				=		new ArrayList() ;
				ArrayList whereRow				=		new ArrayList() ;
			if(!
				  (  (((String)hashMultiple.get(userid))).trim().equals("")
										
				  )
			  )
			{
				insertRow.add( (String)hashMultiple.get(("user_id" + i))) ;
				if( ((String)hashMultiple.get(("view_cost_details_yn" + i))).equals("") )
					insertRow.add(  "N"  ) ;
				else
					insertRow.add( (String)hashMultiple.get(("view_cost_details_yn" + i))) ;
				insertRow.add( login_by_id ) ;
				insertRow.add( login_at_ws_no ) ;
				insertRow.add( login_facility_id ) ;
				insertRow.add( login_by_id ) ;
				insertRow.add( login_at_ws_no ) ;
				insertRow.add( login_facility_id ) ;
				
				whereRow.add( (String)hashMultiple.get(("user_id" + i) )) ;

				insertData.add( insertRow) ;
				whereData.add( whereRow) ;
			}
		}
				LanguageData.add(getLanguageId());
				HashMap tabData = new HashMap() ;
				tabData.put( "properties", getProperties() );
				tabData.put( "InsertData",insertData);
				tabData.put( "WhereData",whereData);
				tabData.put( "LanguageData",LanguageData);

				HashMap sqlMap = new HashMap() ;
				try
				{
					sqlMap.put( "SelectSQL","SELECT count(*) count FROM MM_VIEW_COST_FOR_USER WHERE APPL_USER_ID LIKE ?"  );
					sqlMap.put( "InsertSQL","Insert into MM_VIEW_COST_FOR_USER (APPL_USER_ID, VIEW_COST_YN, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID ) values (?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE,?,?)");

					//sqlMap.put( "SelectSQL", MmRepository.getMmKeyValue( "SQL_MM_ITEM_ANAL_CODE_EXISTS") );
					//sqlMap.put( "InsertSQL", MmRepository.getMmKeyValue( "SQL_MM_ITEM_ANAL_INSERT") );

					map			=	callSingleTableHandler( tabData, sqlMap, MmRepository.MULTIPLE_INSERT );
					if( ((Boolean) map.get( "result" )).booleanValue() )	
					{
						map.put( "message",  getMMMessage(getLanguageId(),(String) map.get( "msgid" ),"ST") ) ;
					}
					else{
						if( ((String)map.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) )
						{
							String messageText = getMMMessage(getLanguageId(),(String) map.get( "msgid" ),"Common") ;
							messageText = messageText.substring(0,(messageText.indexOf("<br>")));
							map.put( "message", messageText ) ;
							map.put( "invalidCode", delimitedString( (ArrayList)map.get("invalidCode")) ) ;
						}
						else
						{
							map.put( "message", map.get("msgid") + "tabData Content: "+tabData );
						}
					 }
				} 
				catch(Exception e)
				{
					e.printStackTrace();
				}
			return map;
	}
		
	public HashMap modify()
	{	
			HashMap map					=			 new HashMap();
			HashMap tabData				=			 new HashMap() ;
			ArrayList ModifyData		=			 new ArrayList();
			ArrayList LanguageData		=			 new ArrayList() ;
			map.put( "result", new Boolean( false ) ) ;

	
			ModifyData.add(checkForNull((String)hashMultiple.get( "view_cost_details_yn"),"N"));
			ModifyData.add(login_by_id);
			ModifyData.add(login_at_ws_no);
			ModifyData.add(login_facility_id);
			ModifyData.add(getUser_Id());
			
		
			LanguageData.add(getLanguageId());
			tabData.put( "ModifyData",	ModifyData ) ;
			tabData.put( "properties",	getProperties() ) ;
			tabData.put( "LanguageData",LanguageData);
			
	

			//	SingleTableHandlerHome home = null ;
				SingleTableHandlerRemote remote = null ;

			try
			{
				HashMap sqlMap = new HashMap() ;
				//sqlMap.put( "ModifySQL", MmRepository.getMmKeyValue( "SQL_MM_ITEM_ANAL_UPDATE") );
				sqlMap.put( "ModifySQL", "Update MM_VIEW_COST_FOR_USER set view_cost_yn = ?,  MODIFIED_DATE =SYSDATE , MODIFIED_BY_ID =? , MODIFIED_AT_WS_NO = ?,MODIFIED_FACILITY_ID= ? where APPL_USER_ID like ?" );

				Object home1 = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
				Object busObj = (home1.getClass().getMethod("create",null)).invoke(home1,null);

				Object argArray[] = new Object[2];
				argArray[0] = tabData;
				argArray[1] = sqlMap;

				Class [] paramArray = new Class[2];
				paramArray[0] = tabData.getClass(); 
				paramArray[1] = sqlMap.getClass();

				 map = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
				
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				if( ((Boolean) map.get( "result" )).booleanValue() )		
					map.put("message", getMMMessage(getLanguageId(),(String) map.get( "msgid" ),"ST") ) ;
				else
					map.put("message",map.get("msgid"));

			}
			catch(Exception e)
			{
				System.err.println( "Error Calling EJB : "+e ) ;
				map.put( "message", e.getMessage() ) ;
				e.printStackTrace() ;
			}
			finally
			{
			try {
					if( remote != null )
						remote.remove() ;
				} 
				catch( Exception ee )
				{
					System.err.println( ee.getMessage() ) ;
					map.put( "message", ee.getMessage() ) ;
					ee.printStackTrace();
				}
			}
		return map ;
	}


	public void loadData() throws Exception {
			Connection connection = null;
			PreparedStatement pstmt = null;
			ResultSet resultSet = null;
		
			try {
				connection = getConnection();
				//pstmt = connection.prepareStatement(MmRepository.getMmKeyValue( "SQL_MM_ITEM_ANAL_MODIFY"));
				pstmt = connection.prepareStatement(" Select a.appl_user_id APPL_USER_ID, b.appl_user_name APPL_USER_NAME , a.view_cost_yn VIEW_COST_YN from MM_VIEW_COST_FOR_USER a, sm_appl_user b where  a.appl_user_id = b.appl_user_id  and a.appl_user_id like ?");
				pstmt.setString( 1, user_id[0]);
			
				resultSet = pstmt.executeQuery();
				if((resultSet.next())&&(resultSet!=null))
				{
					setUserID(0,resultSet.getString("APPL_USER_ID"));
					setUserName(0,resultSet.getString("APPL_USER_NAME"));		
					setViewCostDetails(0,resultSet.getString("VIEW_COST_YN"));		
					
				}
			} 
			catch (Exception e )	{
				System.err.println("Error loading values from database");
				e.printStackTrace();
				throw e;
			} 
			finally {
				try{
					closeResultSet(resultSet);
					closeStatement(pstmt);
					closeConnection(connection);
				}
				catch(Exception es) {
					es.printStackTrace();
				}

			}
				
	}	
	
}

