/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-------------------------------------------------------------------------------------------------------
Date       Edit History      Name        		Description
-------------------------------------------------------------------------------------------------------
?             100            ?           		created
08/08/2011    IN28060        Dinesh T           Next, previous causing Server down. Modified the														connection closing
-------------------------------------------------------------------------------------------------------
*/
package eOR;
import java.io.*;
import java.util.*;
import javax.rmi.* ;
import java.sql.*;
import javax.naming.* ;
import webbeans.eCommon.*;
import eOR.ORAssignPrivilegeGroup.* ;
import eOR.Common.*;
import eCommon.Common.*;

public class  AssignPrevilegeGroup extends eOR.Common.OrAdapter implements Serializable
{
	protected Hashtable MultiHashData = new Hashtable();
    protected Hashtable hashtable=null;
	protected HashMap insertRecs=null;
	protected String prev_grp_code;
	protected String dtl_grp_by_code;
	protected String prev_code_update;
	protected String resp_pract_code;
	protected String prev_code;
	protected String resp_pract;
	protected String code="";
	protected boolean delinkSetup = false;
	protected List<String> privilegeList;

	eOR.Common.MultiRecordBean multiRecBean  = new eOR.Common.MultiRecordBean();
	public void  setPrev_group_code(String  prev_grp_code)
	{
	   this.prev_grp_code=  prev_grp_code;
	 }
	 public String getPrev_group_code() { return this.prev_grp_code ; } ;
	 public void  setdtl_grp_by_code(String  dtl_grp_by_code)
	  {
	   this.dtl_grp_by_code=  dtl_grp_by_code;
	  }
   public String getDtl_grp_by_code() { return this.dtl_grp_by_code ; } ;

   public void  setPrev_code_update(String  prev_code_update)
	{
	   this.prev_code_update=  prev_code_update;
	 }
	 public String getPrev_code_update() { return this.prev_code_update ; } ;
	 public void  setResp_pract_code(String  resp_pract_code)
	  {
	   this.resp_pract_code=  resp_pract_code;
	  }
   public String getResp_pract_code() { return this.resp_pract_code ; } ;

 /*********************METHOD TO SET ALL THE FEILDS AT ONCE*************************/

 public void setAll( Hashtable recordSet ) {
	try{
		hashtable= recordSet;
	setMode((String)hashtable.get("mode"));
	if(getMode().equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){
    setPrev_group_code((String)hashtable.get("grp_by_code"));
    setdtl_grp_by_code((String)hashtable.get("dtl_grp_by_code"));
	}
	  else{

		   String group_by=(String)hashtable.get("group_by")  ;
		   if(group_by.equals("RS"))
		  {
				prev_code=(String)hashtable.get("grp_by_code1");
				resp_pract=(String)hashtable.get("grp_by_code");
		  }
		  else if (group_by.equals("PR"))
		  {
			  prev_code=(String)hashtable.get("grp_by_code2");
			  resp_pract=(String)hashtable.get("grp_by_code");
		  }
	setPrev_code_update(prev_code);
    setResp_pract_code(resp_pract);
	  }
	}
	catch(Exception e){
	try{
		throw new Exception("Excweption@SetAll: "+e);
		}catch(Exception ee){ee.printStackTrace() ;
		}
	 }
 }//end

  public HashMap insert(){
	StringBuffer tmpBuff	= new StringBuffer();
	HashMap map = new HashMap() ;
	HashMap tabData = new HashMap() ;
	HashMap split = new HashMap();
	ArrayList deleteArrList = new ArrayList();
	ArrayList insertArrList = new ArrayList();
	ArrayList allRecords = new ArrayList();
	String valid= "", associate_yn="";
    map.put( "result", new Boolean( false ) ) ;
	map.put( "flag","") ;
	   try
	  {
		   allRecords = multiRecBean.getAllDBRecords();


		if(allRecords.size()>0){
		for(int j=0;j<allRecords.size();j++){
			split			= (HashMap)allRecords.get(j);
			valid			= (String) split.get("valid");
			associate_yn	= (String) split.get("associate_yn");
			if(valid.equals("Y")){
				if(associate_yn.equals("D")){
					deleteArrList.add(split);
				  }
				 }
			   else if(valid.equals("N")){
				if(associate_yn.equals("Y")){
					insertArrList.add(split);
				}
			      }
			}
	}else{
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message","CLICK_ONE_ORDERABLE");
		return map;
		}

		//if(delinkSetup)
		//{
			//if(!removePrivilegeForAllusers(getPrev_group_code(), getDtl_grp_by_code()).equals("SUCCESS"))
			//{
				//throw new Exception("Error in removing privilege for all users.");
			//}
		//}

		MultiHashData.put("dtl_grp_by_code", getDtl_grp_by_code());
		MultiHashData.put("prev_grp_code", getPrev_group_code());
		MultiHashData.put("login_by_id", login_by_id);
		MultiHashData.put("login_at_ws_no",login_at_ws_no);
		MultiHashData.put("login_facility_id",login_facility_id);



		tabData.put("MultiHashData",MultiHashData);
		tabData.put("insertArrList",insertArrList);
		tabData.put("deleteArrList",deleteArrList);
		tabData.put("properties", (Properties)getProperties());
		HashMap sqlMap = new HashMap();
		sqlMap.put("SQL_OR_ASSIGN_PRIVILEGE_GROUP_INSERT", OrRepositoryExt.getOrKeyValue("SQL_OR_ASSIGN_PRIVILEGE_GROUP_INSERT") );
		sqlMap.put("SQL_OR_ASSIGN_PRIVILEGE_GROUP_DELETE", OrRepositoryExt.getOrKeyValue("SQL_OR_ASSIGN_PRIVILEGE_GROUP_DELETE") );
		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepositoryExt.getOrKeyValue("OR_ASSIGN_PRIVILEGE_GROUP_JNDI"), ORAssignPrivilegeGroupHome.class, getLocalEJB());
    	Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		Object argArray[]	= new Object[2];
		argArray[0]		= tabData;
		argArray[1]		= sqlMap;



 		Class [] paramArray = new Class[2];
 		paramArray[0]	= tabData.getClass();
		paramArray[1]	= sqlMap.getClass();
 		map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		argArray=null;
	     paramArray=null;

				if( ((Boolean) map.get( "result" )).booleanValue() ){
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
				}else{

					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "Common")) ;
					}
				map.put("traceVal", (String)tmpBuff.toString());
				tmpBuff.setLength(0);
			}
		catch(Exception e) {
		map.put( "message", e.getMessage()) ;
		e.printStackTrace() ;
		}finally{
			clear();
	}
return map;
}//end of insert

 public HashMap modify(){
         HashMap map = new HashMap();
		 HashMap tabData = new HashMap() ;
		StringBuffer tmpBuff	= new StringBuffer();
    try{
		MultiHashData.put("applevel", (String)hashtable.get("applevel") );
		MultiHashData.put("insertrec", (String)hashtable.get("insertrec"));
	    MultiHashData.put("prev_group_code", getPrev_code_update());
		MultiHashData.put("resp_pract_code", getResp_pract_code());
		MultiHashData.put("login_by_id", login_by_id);
		MultiHashData.put("login_at_ws_no",login_at_ws_no);
		MultiHashData.put("login_facility_id",login_facility_id);

		tabData.put("MultiHashData",MultiHashData);
		tabData.put("properties", (Properties)getProperties());
        HashMap sqlMap = new HashMap();
		sqlMap.put("SQL_OR_PRIVILEGE_GROUP_CODE_UPDATE", OrRepositoryExt.getOrKeyValue("SQL_OR_PRIVILEGE_GROUP_CODE_UPDATE") );
		sqlMap.put("SQL_OR_ASSIGN_PRIVILEGE_GROUP_INSERT", OrRepositoryExt.getOrKeyValue("SQL_OR_ASSIGN_PRIVILEGE_GROUP_INSERT") );
		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepositoryExt.getOrKeyValue("OR_ASSIGN_PRIVILEGE_GROUP_JNDI"), ORAssignPrivilegeGroupHome.class, getLocalEJB());
    	Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		Object argArray[]	= new Object[2];
		argArray[0]		= tabData;
		argArray[1]		= sqlMap;
 		Class [] paramArray = new Class[2];
 		paramArray[0]	= tabData.getClass();
		paramArray[1]	= sqlMap.getClass();
 		map = (java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		 argArray=null;
	     paramArray=null;
				if( ((Boolean) map.get( "result" )).booleanValue() ){
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
				}else{
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "Common")) ;

				}
				map.put("traceVal", (String)tmpBuff.toString());
				tmpBuff.setLength(0);

		}
		catch(Exception e) {
		map.put( "message", e.getMessage()) ;
		e.printStackTrace() ;
		}finally{
			clear();
			}
		 return map;
}

		public ArrayList getPrevcode(String respid) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;

		ArrayList practValues = new ArrayList() ;
		try{
				connection	= getConnection();
				pstmt		= connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_PRIVILEGE_GROUP_CODE_SELECT") ) ;
				pstmt.setString(1, respid);
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
				   while (  resultSet!=null && resultSet.next()) {
					String[] record = null;
						record = new String[2];
						record[0] = checkForNull(resultSet.getString( "PRIV_GRP_ID" ),"")  ;
						record[1] = checkForNull(resultSet.getString( "PRIV_GRP_DESC" ),"")  ;
						practValues.add(record) ;

					}
				}
			}catch ( Exception e )	{
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}
			return practValues;
	}	 // End of the

public int fetchDBRecords(String previlegeid, String applicablelevel)throws Exception {
	Connection connection = null ;
	PreparedStatement pstmt=null;
	HashMap htMapRecord = null;
	ResultSet rs=null;
	int total_rec =0;
	String SQL_QUERY="", code="",desc="" ;

	try{
		int checkRec = multiRecBean.getSize("DB");
		if(checkRec==0){
			connection = getConnection();
			/*
			 Modified by kishore kumar N on 18-Aug-09 for CRF 641

			if(applicablelevel.equals("R"))
			SQL_QUERY = OrRepositoryExt.getOrKeyValue("SQL_ASSIGN_PRIVILEGE_GROUP_DB_REC1");
			else


			*/
			SQL_QUERY = OrRepositoryExt.getOrKeyValue("SQL_ASSIGN_PRIVILEGE_GROUP_DB_REC2");
			pstmt = connection.prepareStatement(SQL_QUERY);
			pstmt.setString(1,previlegeid);
			rs = pstmt.executeQuery();
			if(rs != null){
				while(rs.next()){
				code				=	rs.getString("APPL_MEMB_REF");
				/*if(applicablelevel.equals("R"))
				desc				=	rs.getString("description");
				else*/
				desc				=	rs.getString("description");
				htMapRecord		=	new HashMap();
				htMapRecord.put("code"			,	code);
				htMapRecord.put("desc"			,	desc);
				htMapRecord.put("valid"			,	"Y");
				htMapRecord.put("associate_yn"	,   "N");
				htMapRecord.put("status"		,   "N");

				/*
					htMapRecord.put("associate_yn"	,   "N");
					htMapRecord.put("status"		,   "N");
					ends here.
				*/

				multiRecBean.putObject(htMapRecord);
			}
		}
	}
	total_rec = multiRecBean.getSize("DB");
	//return total_rec;
	}
	catch(Exception e){
		throw e;
	}
	finally{
		try{
			closeResultSet( rs ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		catch(Exception e){throw e;}
	}
	return total_rec;
 }//end of fetchRecords  */

 /*********************Method to fetch Alphabetical Records ***********************/
// public Object getRecordSet(String index, String service_code)throws Exception{
 public Object getRecordSet(String privilegeid,String dtl_grp_by_code,String searchtext,String search_criteria,String speciality)throws Exception
{

	Connection connection = null ;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	int reccount = 0;
	 try{
		java.util.HashMap htRecord = null;
		String  desc="", SQL_QUERY="", code="";//,status="E";
		//valid="N",
		//String default_yn="";
		connection = getConnection();
		multiRecBean.clearSelectRec();

		/*
			 Modified by kishore kumar N on 18-Aug-09 for CRF 641
		*/
		/*if(!(dtl_grp_by_code.equals("R"))){*/
			if(!(searchtext.equals("OTH")))
				SQL_QUERY = OrRepositoryExt.getOrKeyValue("SQL_OR_ASSIGN_PRIV_GROUP_PRACT_SELECT");
			else
				SQL_QUERY = OrRepositoryExt.getOrKeyValue("SQL_OR_ASSIGN_PRIV_GROUP_PRACT_SELECT_OTH");
		/*}else{
			if(!(searchtext.equals("OTH")))
			SQL_QUERY = OrRepositoryExt.getOrKeyValue("SQL_OR_ASSIGN_PRIV_GROUP_RESP_SELECT");
			else
			 SQL_QUERY = OrRepositoryExt.getOrKeyValue("SQL_OR_ASSIGN_PRIV_GROUP_RESP_SELECT_OTH");
		}*/
		if(!speciality.equals(""))
		{
			SQL_QUERY = SQL_QUERY.replace("##FILTER$$", " and primary_speciality_code = ?");
		}
		else
		{
			 SQL_QUERY = SQL_QUERY.replace("##FILTER$$", " ");
		}
		if(!search_criteria.equals(""))
		{
			SQL_QUERY = SQL_QUERY.replace("##FILTER2$$", " and  upper(short_name)  like DECODE ((?),'S',upper(?)||'%','C','%' ||upper(?)||'%','E','%'||upper(?))");
		}
		else
		{
			if(!(searchtext.equals("OTH")))
			{
				SQL_QUERY = SQL_QUERY.replace("##FILTER2$$", " and upper(SHORT_NAME) like upper(?) ");
			}
			else
			{
				SQL_QUERY = SQL_QUERY.replace("##FILTER2$$", " ");
			}
		}
		if(!speciality.equals(""))
		{
			SQL_QUERY = SQL_QUERY.replace("##FILTER$$", " and primary_speciality_code = ?");
		}
		else
		{
			 SQL_QUERY = SQL_QUERY.replace("##FILTER$$", " ");
		}
		if(!search_criteria.equals(""))
		{
			SQL_QUERY = SQL_QUERY.replace("##FILTER2$$", " and  upper(short_name)  like DECODE ((?),'S',upper(?)||'%','C','%' ||upper(?)||'%','E','%'||upper(?))");
		}
		else
		{
			if(!(searchtext.equals("OTH")))
			{
				SQL_QUERY = SQL_QUERY.replace("##FILTER2$$", " and upper(SHORT_NAME) like upper(?) ");
			}
			else
			{
				SQL_QUERY = SQL_QUERY.replace("##FILTER2$$", " ");
			}
		}
		pstmt = connection.prepareStatement(SQL_QUERY);
		//pstmt.setString(++reccount, privilegeid);
		if(!speciality.equals(""))
		{
			pstmt.setString(++reccount, speciality);
		}
		if(!search_criteria.equals(""))
		{
			pstmt.setString(++reccount, search_criteria);

			pstmt.setString(++reccount, searchtext);

			pstmt.setString(++reccount, searchtext);

			pstmt.setString(++reccount, searchtext);

		}
		else
		 {
			if(!(searchtext.equals("OTH")))
			{
				pstmt.setString(++reccount, searchtext+"%");
			}
		}
		if(!speciality.equals(""))
		{
			pstmt.setString(++reccount, speciality);
		}
		if(!search_criteria.equals(""))
		{
			pstmt.setString(++reccount, search_criteria);

			pstmt.setString(++reccount, searchtext);

			pstmt.setString(++reccount, searchtext);

			pstmt.setString(++reccount, searchtext);

		}
		else
		 {
			if(!(searchtext.equals("OTH")))
			{
				pstmt.setString(++reccount, searchtext+"%");
			}
		}
		
		rs = pstmt.executeQuery();
		if(rs != null){
			while(rs.next()){
			/*	if(dtl_grp_by_code.equals("R"))
				{
				   code				=	rs.getString("RESP_ID");
				  desc				=	rs.getString("RESP_NAME");
				}
				else
				{*/
					code				=	rs.getString("PRACTITIONER_ID")==null?"":rs.getString("PRACTITIONER_ID");
					desc				=	rs.getString("SHORT_NAME")==null?"":rs.getString("SHORT_NAME");
				//}
               // if(desc == null || desc.equals("null"))desc="";
                htRecord					=	new HashMap();
				htRecord.put("code"			,	code);
				htRecord.put("desc"	,	desc);
                htRecord.put("valid"		,	"N");
				htRecord.put("associate_yn" ,   "N");
				htRecord.put("status"		,	"N");
				/*
					ends here.
					htRecord.put("associate_yn" ,   "N");
					htRecord.put("status"		,	"N");
				*/
				multiRecBean.putListObject(htRecord);
			}
		}
	}
	catch(Exception e){
		throw e;
	}
	finally{
		try{
			closeResultSet( rs ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		catch(Exception e){throw e;}
	}
	return multiRecBean;
 }//end of getRecordSet

    /***************************To get the multiRecord bean ***********/
 public Object getBean(){
	return this.multiRecBean;
 }//end of getBean

 /***************************To clear the multiRecord bean ***********/
  public boolean clearDBRec()throws Exception{
	boolean clearFlag = false;
	clearFlag = multiRecBean.clearDBRec();
	return clearFlag;
 }//end of clearDBRec

	/**
	 * @return the privilegeList
	 */
	public List<String> getPrivilegeList()
	{
		return privilegeList;
	}

	/**
	 * @param privilegeList the privilegeList to set
	 */
	public void setPrivilegeList(String code)
	{
		if(privilegeList == null)
		{
			privilegeList = new ArrayList<String>();
		}

		if (!privilegeList.contains(code))
		{
			privilegeList.add(code);
		}
	}

	public List<String> getPrevilegeGroups() throws Exception//<IN28060>
	{
		Connection con = null ;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try
		{

			//String prevGrpQry = OrRepositoryExt.getOrKeyValue("SQL_OR_ASSIGN_PRIVILIEGE_GROUP_BY_PRIVILEGE");
			String prevGrpQry = "Select PRIV_GRP_ID code, PRIV_GRP_DESC description from or_priv_group where EFF_STATUS = 'E' order by PRIV_GRP_DESC";
			con = getConnection();
			pst = con.prepareStatement(prevGrpQry);
			rs = pst.executeQuery();
			List<String> prevGrpList = new ArrayList<String>();
			while(rs.next())
			{
				prevGrpList.add(rs.getString(1)+"`~"+rs.getString(2));
			}
			return prevGrpList.size()>0?prevGrpList:null;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			//<IN28060>,Starts
			try{
				closeResultSet( rs ) ;
				closeStatement( pst ) ;
				closeConnection(con);
			}
			catch(Exception e){throw e;}
			//<IN28060>,ends
		}
		return null;
	}
	public String savePrevilegeGrpsForUser(String appLevel, String user, String groupBy)
	{
		String msg = "Fail";
		try
		{
			Map<String, String> map = new HashMap<String, String>();
			map.put("SQL_OR_ASSIGN_PRIVILEGE_TO_PRACTITIONER_DELETE", OrRepositoryExt.getOrKeyValue("SQL_OR_ASSIGN_PRIVILEGE_TO_PRACTITIONER_DELETE"));
			map.put("SQL_OR_PRIVILEGE_GROUP_ALL_DELETE", OrRepositoryExt.getOrKeyValue("SQL_OR_PRIVILEGE_GROUP_ALL_DELETE"));
			map.put("SQL_OR_ASSIGN_PRIVILEGE_GROUP_INSERT", OrRepositoryExt.getOrKeyValue("SQL_OR_ASSIGN_PRIVILEGE_GROUP_INSERT"));
			map.put("appLevel", appLevel);
			map.put("user", user);
			map.put("addedId", login_by_id);
			map.put("addedAtWsNo", login_at_ws_no);
			map.put("addedFac", login_facility_id);
			map.put("modifiedId", login_by_id);
			map.put("modifiedAtWsNo", login_at_ws_no);
			map.put("modifiedFac", login_facility_id);




		/*	Context context = new InitialContext();
			ORAssignPrivilegeGroupLocalHome home =  (ORAssignPrivilegeGroupLocalHome) context.lookup(OrRepositoryExt.getOrKeyValue("OR_ASSIGN_PRIVILEGE_GROUP_JNDI"));
			ORAssignPrivilegeGroupLocal busObj =  (ORAssignPrivilegeGroupLocal) home.create();
			msg = busObj.savePrevilegeGrpsForUser(getPrivilegeList(), map, getProperties(), groupBy);
			privilegeList.clear();
		*/

			if (getPrivilegeList() != null)
			{
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepositoryExt.getOrKeyValue("OR_ASSIGN_PRIVILEGE_GROUP_JNDI"), ORAssignPrivilegeGroupLocalHome.class, getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				Object [] argArray = new Object[4];
				argArray[0]		= getPrivilegeList();
				argArray[1]		= map;
				argArray[2]		= getProperties();
				argArray[3]		= groupBy;

				Class [] paramArray = new Class[4];
				paramArray[0]	= getPrivilegeList().getClass();
				paramArray[1]	= map.getClass();
				paramArray[2]	= getProperties().getClass();
				paramArray[3]	= groupBy.getClass();
				msg = (String)(busObj.getClass().getMethod("savePrevilegeGrpsForUser",paramArray)).invoke(busObj,argArray);
			}
			else
			{
				throw new Exception("");
			}


		}
		catch (Exception e)
		{
			e.printStackTrace();
			return e.getMessage();
		}
		return msg;
	}

	public boolean isPrevilegeGRPExists(String previlegeCode, String user, String appLevel)	 throws Exception //<IN28060>
	{
		ResultSet rs = null;
		Connection con = null ;
		PreparedStatement cntPst = null;
		if(previlegeCode != null && user != null && appLevel != null)
		{
			try
			{
				con = getConnection();
				cntPst = con.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ASSIGN_PRIVILEGE_COUNT"));
				cntPst.setString(1, previlegeCode);
				cntPst.setString(2, user);
				cntPst.setString(3, appLevel);
				rs = cntPst.executeQuery();
				if(rs.next())
				{
					if (rs.getInt(1)>0)
					{
						setPrivilegeList(previlegeCode);
						return true;
					}
				}
			}
			//<IN28060>,starts
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				try{
					closeResultSet( rs ) ;
					closeStatement( cntPst ) ;
					closeConnection(con);
				}
				catch(Exception e){throw e;}
			}
			//<IN28060>,ends
		}
		return false;
	}

	public boolean isPrevilegeGRPExists(String previlegeCode, String appLevel)	 throws Exception//<IN28060>
	{
		ResultSet rs = null;
		Connection con = null ;
		PreparedStatement cntPst = null;
		if(previlegeCode != null)
		{
			try
			{
				con = getConnection();
				cntPst = con.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_PRIVILEGE_GROUP_ALL_COUNT"));
				cntPst.setString(1, previlegeCode);
				cntPst.setString(2, appLevel);
				rs = cntPst.executeQuery();
				if(rs.next())
				{
					if (rs.getInt(1)>0)
					{
						setPrivilegeList(previlegeCode);
						return true;
					}
				}
			}
			//<IN28060>,starts
			catch(Exception e)
			{
				e.printStackTrace();
				return false;
			}
			finally
			{
				try{
					closeResultSet( rs ) ;
					closeStatement( cntPst ) ;
					closeConnection(con);
				}
				catch(Exception e){throw e;}
			}
		//<IN28060>,ends
		}
		return false;
	}

	public boolean isSpecificUserPExists(String previlegeCode, String appLevel)	   throws Exception
	{
		ResultSet rs = null;
		Connection con = null ;
		PreparedStatement cntPst = null;
		if(previlegeCode != null)
		{
			try
			{
				con = getConnection();
				cntPst = con.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_ASSIGN_PRIVILIEGE_PRIV_COUNT"));
				cntPst.setString(1, previlegeCode);
				cntPst.setString(2, appLevel);
				rs = cntPst.executeQuery();
				if(rs.next())
				{
					if (rs.getInt(1)>0)
					{
						setPrivilegeList(previlegeCode);
						return true;
					}
				}
			}
			//<IN28060>,starts
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				try{
					closeResultSet( rs ) ;
					closeStatement( cntPst ) ;
					closeConnection(con);
				}
				catch(Exception e){throw e;}
			}
			//<IN28060>,ends
		}
		return false;
	}

	public String removePrivilegeForAllusers(String prgId, String appLevel)
	{
		try
		{
			String deleteQry = OrRepositoryExt.getOrKeyValue("SQL_OR_PRIVILEGE_GROUP_ALL_DELETE");
			/*Context context = new InitialContext();
			ORAssignPrivilegeGroupLocalHome home =  (ORAssignPrivilegeGroupLocalHome) context.lookup(OrRepositoryExt.getOrKeyValue("OR_ASSIGN_PRIVILEGE_GROUP_JNDI"));
			ORAssignPrivilegeGroupLocal busObj =  (ORAssignPrivilegeGroupLocal) home.create();
			return busObj.removePrivilegeForAllusers(prgId, appLevel, deleteQry, getProperties());*/
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepositoryExt.getOrKeyValue("OR_ASSIGN_PRIVILEGE_GROUP_JNDI"), ORAssignPrivilegeGroupLocalHome.class, getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object [] argArray = new Object[4];
			argArray[0]		= prgId;
			argArray[1]		= appLevel;
			argArray[2]		= deleteQry;
			argArray[3]		= getProperties();

			Class [] paramArray = new Class[4];
			paramArray[0]	= prgId.getClass();
			paramArray[1]	= appLevel.getClass();
			paramArray[2]	= deleteQry.getClass();
			paramArray[3]	= getProperties().getClass();
			return (String) (busObj.getClass().getMethod("removePrivilegeForAllusers",paramArray)).invoke(busObj,argArray);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return "FAIL";
	}


	public void removePrivilege(String privilegeCode)
	{
		if(privilegeList != null && privilegeList.contains(privilegeCode) )
		{
			privilegeList.remove(privilegeCode);
		}
	}

	public void setDelinkSetup(boolean delinkSetup)
	{
		this.delinkSetup = delinkSetup;
	}

	private boolean getDelinkSetup()
	{
		return this.delinkSetup;
	}

}
