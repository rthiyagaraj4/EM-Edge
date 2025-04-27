/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR;

import java.io.*;
import java.util.*;
import javax.rmi.* ;
import java.sql.*;
import javax.naming.* ;
import webbeans.eCommon.*;


import eOR.ORPractForConsent.* ;
import eOR.Common.*;
import eCommon.Common.*;

public class PractForConsentBean extends eOR.Common.OrAdapter implements Serializable
{
	protected String group_by;
	protected String pract_consent_code;
	public	  String debug="";
	protected Hashtable MultiHashData = new Hashtable();
	eOR.Common.MultiRecordBean multiRecBean  = new eOR.Common.MultiRecordBean();

	public PractForConsentBean()
	{
		group_by		= ""	;
		pract_consent_code	= ""    ;
		try{
			doCommon();
		   }catch(Exception e) {e.printStackTrace() ;}
	}

  public void  setGroup_by(String group_by) {this.group_by = group_by; };
  public void  setPract_consent_code(String  pract_consent_code) {this.pract_consent_code=  pract_consent_code; } ;
  public void  setDebug(String  debug) {this.debug=  debug; } ;

  public String getGroup_by() { return this.group_by ; };
  public String getPract_consent_code() { return this.pract_consent_code ; } ;
  public String getDebug() { return this.debug ; } ;

	public void setAll( Hashtable recordSet ) 
	{
		try
		{
			setPract_consent_code((String)recordSet.get("pract_consent_code"));
			setMode((String)recordSet.get("mode"));
		}
		catch(Exception e)
		{
			try
			{
				throw new Exception("Exception@SetAll: "+e);
			}
			catch(Exception ee)
			{
				ee.printStackTrace() ;
			}
		}
	}

	public HashMap insert()
	{
		HashMap map		 = new HashMap() ;
		HashMap tabData	 = new HashMap() ;
		HashMap split	 = new HashMap();
	
		ArrayList deleteArrList = new ArrayList();
		ArrayList insertArrList = new ArrayList();
		ArrayList allRecords	= new ArrayList();
		
		String valid= "", associate_yn="";
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag","") ;

		try 
		{
			allRecords = multiRecBean.getAllDBRecords();
			if(allRecords.size()>0)
			{
				for(int j=0;j<allRecords.size();j++)
				{
					split			= (HashMap)allRecords.get(j);
					valid			= (String) split.get("valid");
					associate_yn	= (String) split.get("associate_yn");
		
					if(valid.equals("Y"))
					{
						if(associate_yn.equals("D"))
						{
							deleteArrList.add(split);
						}
					}
					else if(valid.equals("N"))
					{
						if(associate_yn.equals("Y"))
						{
							insertArrList.add(split);
						}
					}
				}
			}
			else
			{
				map.put( "result", new Boolean( false ) ) ;
				if(group_by.equals("P"))
				{
					map.put( "message","ATLEAST_ONE_CONSENT");
				}
				else
				{
					map.put( "message","ATLEAST_ONE_PRACTITIONER");
				}
				return map;	
			}
			MultiHashData.put("group_by",group_by);
			MultiHashData.put("pract_consent_code", getPract_consent_code());
			MultiHashData.put("login_by_id", login_by_id);
			MultiHashData.put("login_at_ws_no",login_at_ws_no);
			MultiHashData.put("login_facility_id",login_facility_id);

			tabData.put("MultiHashData",MultiHashData);
			tabData.put("deleteArrList",deleteArrList);
			tabData.put("insertArrList",insertArrList);
			tabData.put("properties", (Properties)getProperties());
			HashMap sqlMap = new HashMap();
			sqlMap.put("SQL_OR_PRACT_FOR_CONSENT_DELETE", OrRepositoryExt.getOrKeyValue("SQL_OR_PRACT_FOR_CONSENT_DELETE") );
			sqlMap.put("SQL_OR_PRACT_FOR_CONSENT_INSERT", OrRepositoryExt.getOrKeyValue("SQL_OR_PRACT_FOR_CONSENT_INSERT") );
		
	
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepositoryExt.getOrKeyValue("OR_PRACT_FOR_CONSENT_JNDI"), ORPractForConsentHome.class, getLocalEJB());
   			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[]	= new Object[2];
			argArray[0]		= tabData;
			argArray[1]		= sqlMap;
			Class [] paramArray = new Class[2];
			paramArray[0]	= tabData.getClass();
			paramArray[1]	= sqlMap.getClass();
			map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			argArray=null;
			paramArray=null;

			if( ((Boolean) map.get( "result" )).booleanValue())
			{
				//map.put( "message", (String) map.get( "msgid" ));
				map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
				clear();
			}
			else
			{
				//map.put( "message", ((String) map.get("msgid"))) ;
				map.put( "message", getMessage(language_id, (String) map.get( "message" ), "Common")) ;
			}
		}
		catch(Exception e) 
		{
			System.err.println( "Error Calling EJB : "+e ) ;
			map.put( "message", e.getMessage()+debug) ;
			e.printStackTrace() ;
		}
		//finally
	//	{
	//		clear();
	//	}
		return map ;
	}

	public HashMap validate() throws Exception 
	{
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map ;
	}
 
	public void clear() 
	{
		group_by = "";
		pract_consent_code = "";
		debug = "";
		super.clear() ;
	}

	public HashMap modify()
	{
		HashMap map = new HashMap();
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message", "success.." ) ;
		return map;
	}
 
	public HashMap delete()
	{
		HashMap map = new HashMap();
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message", "delete failure.." );
		return map;
	}
 
  private void doCommon() throws Exception {
 }

 public void loadData() throws Exception {
 }

	public int fetchDBRecords()throws Exception 
	{
		Connection connection = null ;
		PreparedStatement pstmt=null;
		HashMap htMapRecord = null;
		ResultSet rs=null;
		int total_rec =0;
		String SQL_QUERY="", code="", long_desc="" ;
		try
		{
			int checkRec = multiRecBean.getSize("DB");
			if(checkRec==0){
				connection = getConnection();
			if(group_by.equals("P"))
			{
				SQL_QUERY = OrRepositoryExt.getOrKeyValue("SQL_PRACT_FOR_CONSENT_DB_REC");
			}
			else if(group_by.equals("C"))
			{
				SQL_QUERY = OrRepositoryExt.getOrKeyValue("SQL_CONSENT_FOR_PRACT_DB_REC");
			}
			pstmt = connection.prepareStatement(SQL_QUERY);
			pstmt.setString(1,language_id);
			pstmt.setString(2,pract_consent_code);
			rs = pstmt.executeQuery();
			if(rs != null)
			{
				while(rs.next())
				{
					code					=	rs.getString("code");
					long_desc				=	rs.getString("long_desc");
					if(long_desc == null || long_desc.equals("null"))long_desc="";
					htMapRecord				=	new HashMap();
					htMapRecord.put("code"			,	code);
					htMapRecord.put("long_desc"		,	long_desc);
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
				closeResultSet( rs ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}
			catch(Exception e)
			{
				throw e;
			}
		}
		return total_rec;
	}
  
	public Object getRecordSet(String index)throws Exception
	{
		Connection connection = null ;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try
		{
			java.util.HashMap htRecord = null;
			String  long_desc="", SQL_QUERY="", code="";
			connection = getConnection();

			multiRecBean.clearSelectRec();
	
			if(group_by.equals("P"))
			{
				if(!(index.equals("OTH")))
				{
					SQL_QUERY = OrRepositoryExt.getOrKeyValue("SQL_OR_PRACT_DESC");
				}
				else
				{
					SQL_QUERY = OrRepositoryExt.getOrKeyValue("SQL_OR_PRACT_DESC_OTH");
				}
			}
			else if(group_by.equals("C"))
			{
				if(!(index.equals("OTH")))
				{
				SQL_QUERY = OrRepositoryExt.getOrKeyValue("SQL_OR_CONSENT_DESC");
				}
				else
				{
					SQL_QUERY = OrRepositoryExt.getOrKeyValue("SQL_OR_CONSENT_DESC_OTH");
				}
			}
			pstmt = connection.prepareStatement(SQL_QUERY);
			if(!(index.equals("OTH")))
			{
				pstmt.setString(3,index+"%");
			}
			pstmt.setString(1,pract_consent_code);
			pstmt.setString(2,language_id);
			rs = pstmt.executeQuery();
			if(rs != null)
			{
				while(rs.next())
				{
					code				=	rs.getString("code");
					long_desc			=	rs.getString("long_desc");
					if(long_desc == null || long_desc.equals("null"))long_desc="";
					htRecord			=	new HashMap();
					htRecord.put("code"			,	code);
					htRecord.put("long_desc"	,	long_desc);
					htRecord.put("valid"		,	"N");
					htRecord.put("associate_yn" ,   "N");
					htRecord.put("status"		,	"N");
					multiRecBean.putListObject(htRecord);
				}
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
				closeResultSet( rs ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}
			catch(Exception e){throw e;}
		}
		return multiRecBean;
	}
 
	public Object getBean()
	{
		return this.multiRecBean;
	}

	public boolean clearDBRec()throws Exception
	{
		boolean clearFlag = false;
		clearFlag = multiRecBean.clearDBRec();
		return clearFlag;
	}
}
