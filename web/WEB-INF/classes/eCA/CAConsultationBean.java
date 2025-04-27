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

public class  CAConsultationBean implements Serializable
{
	protected String group_by;
	protected String resource_code;
	protected String resource_type;
	protected String splty_code;
	protected String order_catalog;
	protected String mode;
	protected String locale;
	protected String function_id;
	public String debug="";
	
	String login_by_id = "";
	String login_at_ws_no= "";
	String login_facility_id= "";	
	
	protected Hashtable MultiHashData = new Hashtable();
	CAMultiRecordBean multiRecBean  = new CAMultiRecordBean();

/*********************Constructor *************************/

 public CAConsultationBean(){
	group_by	= ""    ;
	resource_code	= ""    ;
	resource_type	= ""    ;
	splty_code	= ""    ;
	order_catalog	= ""    ;
	mode	= ""    ;
	locale = "";
	function_id = "";
	try{
		doCommon();
	}catch(Exception e) {e.printStackTrace() ;}
 }

/**********************SET METHODS*************************/

  public void  setGroupBy(String  group_by) {this.group_by=  group_by; } ;
  public void  setResourceCode(String  resource_code) {this.resource_code=  resource_code; } ;
  public void  setResourceType(String  resource_type) {this.resource_type=  resource_type; } ;  
  public void  setOrderCatalog(String  order_catalog) {this.order_catalog=  order_catalog; } ;
  public void  setDebug(String  debug) {this.debug=  debug; } ;
  public void  setMode(String  mode) {this.mode=  mode; } ;
  public void  setLocale(String  locale) {this.locale=  locale; } ;
  public void  setFunctionId(String  function_id) {this.function_id=  function_id; } ;
  
/**********************GET METHODS*************************/

  public String  getGroupBy() {return this.group_by; } ;
  public String  getResourceCode() {return this.resource_code; } ;
  public String  getResourceType() {return this.resource_type; } ; 
  public String  getOrderCatalog() {return this.order_catalog; } ;  
  public String getDebug() { return this.debug ; } ;
  public String getLocale() { return this.locale ; } ;
  public String getFunctionId() { return this.function_id ; } ;
  public Object getMultiRecBean() { return multiRecBean ; } ;


/*********************METHOD TO SET ALL THE FEILDS AT ONCE*************************/

 public void setAll( Hashtable recordSet ) {
	try{


		setGroupBy((String)recordSet.get("group_by"));
		setResourceCode((String)recordSet.get("resource_code"));
		setResourceType((String)recordSet.get("resource_type"));
		setOrderCatalog((String)recordSet.get("order_catalog"));
		setMode((String)recordSet.get("mode"));
	}
	catch(Exception e){
	try{
		throw new Exception("Excweption@SetAll: "+e);
		}catch(Exception ee){ee.printStackTrace() ;
		}
	 }
 }//end of setALL

/********************Validate Method ****************************/
 public HashMap validate() throws Exception {
	HashMap map = new HashMap() ;
	map.put( "result", new Boolean( true ) ) ;
	map.put( "message", "success.." ) ;
	return map ;
 }//end of validate

/*********************METHOD TO Reset the Class variable*************************/

 public void clear() {
	group_by	= ""    ;
	resource_code	= ""    ;
	resource_type	= ""    ;
	splty_code	= ""    ;
	order_catalog	= ""    ;	
	function_id = "";
 }//end of clear


/*********************METHOD TO Update*************************/

 public HashMap modify(){
	HashMap map = new HashMap();
	map.put( "result", new Boolean( false ) ) ;
	map.put( "message", "success.." ) ;
	return map;
 }//end of modify

 /*********************METHOD TO Delete*************************/

 public HashMap delete(){
	HashMap map = new HashMap();
	map.put( "result", new Boolean( false ) ) ;
	map.put( "message", "delete failure.." );
	return map;
 }//end of delete

 /*********************doCommon METHOD *************************/

 private void doCommon() throws Exception {
 }

 /*********************loadData METHOD *************************/
 public void loadData() throws Exception {
 }
 
 /*********Method to fetch the Data Base Values*************/
 public int fetchDBRecords(String group_by,String param_value)throws Exception {
	Connection connection = null ;
	PreparedStatement pstmt=null;
	HashMap htMapRecord = null;
	ResultSet rs=null;
	int total_rec =0;
	String SQL_QUERY="", code="", desc="",ext_status="" ;
	
	try{
		int checkRec = multiRecBean.getSize("DB");
		if(checkRec==0){
			connection = ConnectionManager.getConnection();
			
			if (group_by.equals("P") || group_by.equals("S"))
			{

				//SQL_QUERY = "SELECT B.ORDER_CATALOG_CODE CODE, B.SHORT_DESC description,'Y' ext_status FROM CA_CONS_CATALOG_FOR_RESOURCE A, OR_ORDER_CATALOG B WHERE B.ORDER_CATALOG_CODE = A.ORDER_CATALOG_CODE AND A.RESOURCE_CODE = ? and A.RESOURCE_TYPE = ?";
				SQL_QUERY = "SELECT B.ORDER_CATALOG_CODE CODE, B.SHORT_DESC description  FROM CA_CONS_CATALOG_FOR_RESOURCE A, OR_ORDER_CATALOG B WHERE B.ORDER_CATALOG_CODE = A.ORDER_CATALOG_CODE AND A.RESOURCE_CODE = ? and A.RESOURCE_TYPE = ?";
				
			}else if (group_by.equals("O"))
			{
				if (getResourceType().equals("S"))
				{
					//SQL_QUERY = "SELECT A.RESOURCE_CODE CODE, AM_GET_DESC.AM_SPECIALITY(A.RESOURCE_CODE,?,'2') description,CA_GET_CATALOG_FOR_RESOURCE(?,?,A.RESOURCE_CODE) ext_status FROM CA_CONS_CATALOG_FOR_RESOURCE A WHERE A.RESOURCE_TYPE = ?";
					SQL_QUERY = "SELECT A.RESOURCE_CODE CODE, AM_GET_DESC.AM_SPECIALITY(A.RESOURCE_CODE,?,'2') description FROM CA_CONS_CATALOG_FOR_RESOURCE A WHERE A.RESOURCE_TYPE = ? and order_catalog_code=?";
				}else if (getResourceType().equals("P"))
				{
					//SQL_QUERY = "SELECT A.RESOURCE_CODE CODE, AM_GET_DESC.AM_PRACTITIONER(A.RESOURCE_CODE,?,'1') description,CA_GET_CATALOG_FOR_RESOURCE(?,?,A.RESOURCE_CODE) ext_status FROM CA_CONS_CATALOG_FOR_RESOURCE A WHERE A.RESOURCE_TYPE = ?";
					SQL_QUERY = "SELECT A.RESOURCE_CODE CODE, AM_GET_DESC.AM_PRACTITIONER(A.RESOURCE_CODE,?,'1') description FROM CA_CONS_CATALOG_FOR_RESOURCE A WHERE A.RESOURCE_TYPE = ? and order_catalog_code=?";
				}									
			}					
						
			pstmt = connection.prepareStatement(SQL_QUERY);
			if (group_by.equals("P") || group_by.equals("S"))
			{
				pstmt.setString(1,param_value);
				pstmt.setString(2,getResourceType());				
			}else if (group_by.equals("O"))
			{				
				pstmt.setString(1,locale);
				pstmt.setString(2,getResourceType());
				pstmt.setString(3,param_value);
				//pstmt.setString(4,getResourceType());							
			}
			
			rs = pstmt.executeQuery();
			if(rs != null){
				while(rs.next()){
				code					=	rs.getString("code");
				desc					=	rs.getString("description");
				//ext_status					=	rs.getString("ext_status");

			

				if(desc == null || desc.equals("null"))desc="";
				if(ext_status == null || ext_status.equals("null"))ext_status="N";
				htMapRecord		=	new HashMap();
				htMapRecord.put("code"			,	code);
				htMapRecord.put("description"	,	desc);
				htMapRecord.put("valid"			,	"Y");
			/*	if (ext_status.equals("Y"))				
					htMapRecord.put("valid"			,	"Y");
				else
					htMapRecord.put("valid"			,	"N");  */
				
				htMapRecord.put("associate_yn"	,   "N");
				htMapRecord.put("status"		,   "N");
				//htMapRecord.put("extStatus"		,   ext_status);

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
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (connection != null) ConnectionManager.returnConnection(connection);
			}
		catch(Exception e){throw e;}
	}
	return total_rec;
 }//end of fetchRecords

 /*********************Method to fetch Alphabetical Records ***********************/
// public Object getRecordSet(String index, String service_code)throws Exception{
 public Object getRecordSet(String index,String group_by,String order_catalog)throws Exception{
	Connection connection = null ;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	ResultSet rs=null;
	ResultSet rs1=null;
	try{
		java.util.HashMap htRecord = null;
		String  description="", SQL_QUERY="", code="";//,status="E";
		String std_query="";
		String status1="";
		//valid="N",
		connection = ConnectionManager.getConnection();
		multiRecBean.clearSelectRec();

	

		if (group_by.equals("P") || group_by.equals("S"))
		{

			if(!(index.equals("OTH"))){
				SQL_QUERY = "SELECT ORDER_CATALOG_CODE CODE, SHORT_DESC description FROM OR_ORDER_CATALOG  WHERE UPPER(SHORT_DESC) LIKE UPPER (?) AND ORDER_CATEGORY = 'CN' and EFF_STATUS = 'E'";
			}else{
				SQL_QUERY = "SELECT ORDER_CATALOG_CODE CODE, SHORT_DESC description FROM OR_ORDER_CATALOG  WHERE UPPER(SHORT_DESC) NOT BETWEEN UPPER('A%') AND UPPER('_Z%') and EFF_STATUS = 'E' AND ORDER_CATEGORY = 'CN' ORDER BY 2";
			}				
		}else if (group_by.equals("O"))
		{
			if (getResourceType().equals("S"))
			{
				if(!(index.equals("OTH"))){
					SQL_QUERY = "SELECT SPECIALITY_CODE CODE, AM_GET_DESC.AM_SPECIALITY(SPECIALITY_CODE,?,2) description FROM AM_SPECIALITY  WHERE EFF_STATUS = 'E' AND UPPER(SHORT_DESC) LIKE UPPER (?) order by 2";				
				}else{
					SQL_QUERY = "SELECT SPECIALITY_CODE CODE, AM_GET_DESC.AM_SPECIALITY(SPECIALITY_CODE,?,2) description FROM AM_SPECIALITY WHERE EFF_STATUS = 'Y' AND UPPER(SHORT_DESC) NOT BETWEEN UPPER('A%') AND UPPER('_Z%') ORDER BY 2";
				}			
			}else if (getResourceType().equals("P"))
			{
				if(!(index.equals("OTH"))){
					SQL_QUERY = "SELECT PRACTITIONER_ID CODE, AM_GET_DESC.AM_PRACTITIONER(practitioner_id,?,'1') description  FROM AM_PRACTITIONER  WHERE eff_status = 'E' AND UPPER(PRACTITIONER_NAME) LIKE UPPER (?) order by 2";				
				}else{
					SQL_QUERY = "SELECT PRACTITIONER_ID CODE, AM_GET_DESC.AM_PRACTITIONER(practitioner_id,?,'1') description FROM AM_PRACTITIONER WHERE eff_status = 'E' AND UPPER(PRACTITIONER_NAME) NOT BETWEEN UPPER('A%') AND UPPER('_Z%') ORDER BY 2";
				}
			}									
		}					
		
		pstmt = connection.prepareStatement(SQL_QUERY);
		if (group_by.equals("P") || group_by.equals("S"))
		{ 
			if(!(index.equals("OTH"))){
				pstmt.setString(1,index+"%");
			}			
		}else if (group_by.equals("O"))
		{
			pstmt.setString(1,locale);
			if(!(index.equals("OTH"))){
				pstmt.setString(2,index+"%");
			}
		}
		
		rs = pstmt.executeQuery();
		if(rs != null){

			std_query="select CA_GET_CATALOG_FOR_RESOURCE(?,?,?) status from dual";
			pstmt1=connection.prepareStatement(std_query);
			while(rs.next()){
				code				=	rs.getString("CODE");
				description		=	rs.getString("description");
				
				if(description == null || description.equals("null"))description="";
				
				pstmt1.setString(1,getResourceType());
				pstmt1.setString(2,order_catalog);
				pstmt1.setString(3,code);
				rs1=pstmt1.executeQuery();
				while(rs1.next())
				{
					status1=rs1.getString("status")==null?"N":rs1.getString("status");
				}
				if (rs1 != null) rs1.close();
				

				htRecord					=	new HashMap();

				htRecord.put("code"			,	code);
				htRecord.put("description"	,	description);

				htRecord.put("valid"		,	"N");
				if(status1.equalsIgnoreCase("Y"))
				{
					htRecord.put("associate_yn" ,   "A");
				}
				else
				{
					htRecord.put("associate_yn" ,   "N");
				}
				//htRecord.put("associate_yn" ,   "N");
				htRecord.put("status"		,	"N");
				//htRecord.put("extStatus"		,	"C");
				multiRecBean.putListObject(htRecord);
			}

			if (pstmt1 != null) pstmt1.close();
		}
	}
	catch(Exception e){
		throw e;
	}
	finally{
		try{
				if (rs != null) rs.close();
				if (rs1 != null) rs1.close();
				if (pstmt != null) pstmt.close();
				if (pstmt1 != null) pstmt1.close();
				if (connection != null) ConnectionManager.returnConnection(connection);
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

 public String checkForNull(String inputString)
	{
		return (inputString==null || inputString.equals(""))	?	""	:	inputString;
	}
	
}//end of class


