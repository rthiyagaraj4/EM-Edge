/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        	Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------
07/06/2020	IN072524	Nijitha S     		07/06/2020		Ramesh G		ML-MMOH-CRF-1229.2
-------------------------------------------------------------------------------------------------------------------------------
*/
package eOR;

import eOR.Common.* ;
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.rmi.* ;
import javax.naming.* ;
import javax.servlet.* ;
import eCommon.Common.*;
import javax.servlet.http.*;
import webbeans.eCommon.*;

import eOR.ORCatalogBySection.*;

public class  CatalogsBySection extends eOR.Common.OrAdapter  implements Serializable{
	protected String                      order_category;
	protected String                      tick_sheet_id;
	protected String                      section_code;
	protected int                         tick_sheet_seq_num;
	protected String                      order_catalog_code;
	protected String                      order_type_code;
	//protected String                      loadFlag;
	//protected ArrayList                   recordStore;
	protected String					  OrderCatalogIndex ;
	public    String					  detailPageMode;
	public	  eOR.Common.MultiRecordBean1            recStoreHandler ;
	protected String					  action ;
	eOR.Common.MultiRecordBean multiRecBean  = new eOR.Common.MultiRecordBean();

	//Connection connection =null ;
	//PreparedStatement pstmt = null ;
	//ResultSet rs = null;
	//PreparedStatement pstmt_order = null ;
	//ResultSet rs_order = null;

	public  String tempChk	="";
	//public  String tempChk1="";

/*********************Constructor *************************/
 public CatalogsBySection()
{
			 tick_sheet_id						= ""    ;
			 section_code						= ""    ;
			 tick_sheet_seq_num					= 0     ;
			 order_catalog_code					= ""    ;
			 order_type_code					= ""    ;
			// loadFlag							= "N"	;
			 action								= "";
			 recStoreHandler                     = new eOR.Common.MultiRecordBean1();
}

/**********************SET METHODS*************************/
  public void  setOrder_category(String  order_category) {this.order_category=  order_category; } ;
  public void  setTick_sheet_id(String  tick_sheet_id) {this.tick_sheet_id=  tick_sheet_id; } ;
  public void  setSection_code(String  section_code) {this.section_code=  section_code; } ;
  public void  setTick_sheet_seq_num(int  tick_sheet_seq_num) {this.tick_sheet_seq_num=  tick_sheet_seq_num; } ;
  public void  setOrder_catalog_code(String  order_catalog_code) {this.order_catalog_code=  order_catalog_code; } ;
  public void  setOrder_type_code(String  order_type_code) {this.order_type_code=  order_type_code; } ;

/**********************GET METHODS*************************/
  public String getOrder_category() { return this.order_category ; } ;
  public String getTick_sheet_id() { return this.tick_sheet_id ; } ;
  public String getSection_code() { return this.section_code ; } ;
  public int	getTick_sheet_seq_num() { return this.tick_sheet_seq_num ; } ;
  public String getOrder_catalog_code() { return this.order_catalog_code ; } ;
  public String getOrder_type_code() { return this.order_type_code ; } ;
  public String getDetailPageMode() { return this.detailPageMode ; } ;
  public String getAction() { return this.action ; } ;
	//IN068314 Starts
	public Boolean isFPPApplicable;
	public Boolean getIsFPPApplicable() {
		return isFPPApplicable;
	}
	public void setIsFPPApplicable(Boolean isFPPApplicable) {
		this.isFPPApplicable = isFPPApplicable;
	}
	//IN068314 Ends

/**************METHOD TO SET ALL THE FEILDS AT ONCE*************************/
 public void setAll( Hashtable recordSet ) {


	 this.mode = (String)recordSet.get("mode");


	 String detailPageMode_p = (String)recordSet.get("detailPageMode") ;

	 if(detailPageMode_p.equalsIgnoreCase("S")){
		 this.detailPageMode = "S" ;
		 updateCurrentPageForAsscStore(recordSet);
	 }


	 if(detailPageMode_p.equalsIgnoreCase("A")){
		this.detailPageMode = "A" ;
		synAsscStore(recordSet);
	 }

}
/*********************METHOD TO Reset the Class variable*****************/
	public void clear() {
			 tick_sheet_id						= "" ;
			 section_code						= "" ;
			 tick_sheet_seq_num					= 0  ;
			 order_catalog_code					= "" ;
			 order_type_code					= "" ;
			// loadFlag							= "N";
	}

/***************Validate ************************************/

public HashMap validate() throws Exception
{

        HashMap map = new HashMap() ;
        map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "" ) ;

	//	return map ;
		//int sizeRecordStore		 = recStoreHandler.getSize("DB");Commented by Uma on 9/9/2009 for IN013057
		int sizeRecordStore		 = multiRecBean.getSize("DB");

		//int counter = 0 ;
		boolean flag = false ;//Assume no duplicate at start
		boolean result = true ;
		StringBuffer msg = new StringBuffer();
	//	msg.append("Associated Order Catalogs ");
		TreeSet chker = new TreeSet();//Duplicate chker



		for(int i=0 ; i < sizeRecordStore ; i++){//Loop to Chk Duplicate
		//HashMap currData = (HashMap)recStoreHandler.getObject(i) ;Commented by Uma on 9/9/2009 for IN013057
		HashMap currData = (HashMap)multiRecBean.getObject(i) ;
		if(((String)currData.get("associate_yn")).trim().equalsIgnoreCase("Y")){
			String  seqNoStr = checkForNull(((String)currData.get("tick_sheet_seq_num")));

			if(seqNoStr.trim().equals("")){
				result = false;
				msg	   = new StringBuffer();
				msg.append("SeqNO for the OrderCatalog" + (String)currData.get("order_catalog_desc") + "is not entered" );
				break;
			}

			Integer seqNo = new Integer( Integer.parseInt(seqNoStr));
			flag = 	chker.add(seqNo);
			if(!flag){//Duplicate has been detected
				//msg.append((String)currData.get("order_catalog_desc") + " with seq No =" + seqNo.intValue() +" is duplicated");
				msg.append(seqNo + ",") ;
				result = false;
		//		flag = true ;
		//		break;
			}
		  }//Chk  for Ascc record only
		}//End of for Loop

		if(!result){
		   String msgStr  = msg.toString() ;
	
		   int t	      = msgStr.lastIndexOf(",");
		   if(t==-1)
		   	msgStr		  =  msgStr + " are duplicated...";
		   else
		   	msgStr 		  =  msgStr.substring(0,t) + " are duplicated...";

		   map.put( "result", new Boolean( false ) ) ;
		   map.put( "message",getMessage(language_id, "DUPLICATE_SEQ_NO","OR") ) ;
		   map.put( "invalidCode", msgStr ) ;
		}

        return map ;
 }

/*********************METHOD TO Insert*************************/
public HashMap insert()
{

	HashMap map = new HashMap() ;
	HashMap sqlMap = new HashMap() ;
	HashMap recordStoreParam = new HashMap() ;
	map.put( "result", new Boolean( true ) ) ;
	ArrayList allRecords = new ArrayList();
	

try	
{
	allRecords = multiRecBean.getAllDBRecords();


	if(allRecords.size()>0)
	{
		sqlMap.put("SQL_OR_CATALOGSBYSECTION_INSERT",OrRepository.getOrKeyValue("SQL_OR_CATALOGSBYSECTION_INSERT"));
		sqlMap.put("SQL_OR_CATALOGSBYSECTION_UPDATE",OrRepository.getOrKeyValue("SQL_OR_CATALOGSBYSECTION_UP"));
		sqlMap.put("SQL_OR_CATALOGSBYSECTION_DELETE",OrRepository.getOrKeyValue("SQL_OR_CATALOGSBYSECTION_DELETE"));
		recordStoreParam.put("records",multiRecBean.getAllDBRecords());
		//recordStoreParam.put("records",recStoreHandler.getAllDBRecords());Commented by Uma on 9/9/2009 for IN013057

		recordStoreParam.put("login_by_id" , login_by_id) ;
		recordStoreParam.put("login_at_ws_no" , login_at_ws_no ) ;
		recordStoreParam.put("login_facility_id" , login_facility_id ) ;
		return getResult(recordStoreParam,sqlMap );
	}
	else
	{
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message","CLICK_ONE_ORDERABLE");
		return map;	
	}
}catch(Exception e){
		tempChk += e.getMessage();
		logErrorMessage(e);
		return null;
	}
}
/*********************METHOD TO Update*************************/
public HashMap modify(){
	HashMap map = new HashMap();
	map.put( "result", new Boolean( false ) ) ;

	map.put( "message", "delete failure.." );
	return map;
}
/*********************METHOD TO Delete*************************/
public HashMap delete(){
	HashMap map = new HashMap();
	map.put( "result", new Boolean( false ) ) ;

	map.put( "message", "delete failure.." );
	return map;
}
/**************get Combo Options for Order Category(Header frame)********/
public String getComboOptions() {
	Connection connection =null ;
try
{
		connection = getConnection();
		String str = Populate.getComboOptions(OrRepository.getOrKeyValue("SQL_OR_TICK_SHEETS_ORD_CAT_SELECT_CODE"),connection,"ORDER_CATEGORY","SHORT_DESC");
		return str;
	}
	catch(Exception e){
		e.printStackTrace();
		return null;
	}
	finally
	{
		try
		 {
			closeConnection(connection);
		 }catch(Exception e){
			 e.printStackTrace();

		 }
	}
}


/*************get Combo Options Dynamic Population(Headre Frame)***********/

public String getComboBoxHtml(Hashtable ht) throws Exception {
	String sql = "" ;
	String optionString = "";
	String comboBoxString = "";
	Connection connection = null;
try
	{
		if( ht == null )
			return "Hashtable Passed to  this method is null";

		connection = getConnection();
	 	String  type = (String)ht.get("type");
		if(type.trim().equalsIgnoreCase("OrderCategory"))
		{
			sql			  = replace(OrRepository.getOrKeyValue("SQL_OR_CATALOG_TICK_SHEET") , "?" ,(String)ht.get("order_category"));
			optionString  = Populate.getComboOptions(sql,connection,"TICK_SHEET_ID","TICK_SHEET_DESC");
			comboBoxString="&nbsp;<select name='tick_sheet' onChange='parent.parent.fillComboOptions(this);'><option>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--- Select ---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>" + optionString + "</select><img src='../../eCommon/images/mandatory.gif'></img>" ;
		//	tempChk = "";
		}else if(type.trim().equalsIgnoreCase("tickSheet")){
			sql =replace(OrRepository.getOrKeyValue("SQL_OR_CATALOG_SECTION"), "?" ,(String)ht.get("order_category"));
			sql =replace(sql, "?" ,(String)ht.get("tick_sheet"));
		//
			//tempChk = sql;
			optionString = Populate.getComboOptions(sql,connection,"SECTION_CODE","SECTION_DESC");
			comboBoxString="&nbsp;<select name='section' onChange='parent.parent.select(this)'><option>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--- Select ---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>" + optionString + "</select><img src='../../eCommon/images/mandatory.gif'></img>" ;
		}
		else
			throw new Exception("Exception :-in Bean getComboBoxHtml function Hashtable Passed should contain order_category or tick_sheet ID only");
		}
	catch(Exception e){
		throw e;
	}
	finally
	{
		try
		 {
			closeConnection(connection);
		 }catch(Exception e){e.printStackTrace();

		 }
	}

	return comboBoxString;
}
/*********************METHOD TO load OrderCategory code-desc for Query Page********/
public String getComboString() {
Connection 	connection  = null;
PreparedStatement pstmt		= null;
ResultSet rs	= null;
try
	{
		connection  = getConnection();

		pstmt						= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_TICK_SHEETS_ORD_CAT_SELECT_CODE"));
		rs							= pstmt.executeQuery();
	    StringBuffer sb			    = new StringBuffer();
		String  codeCol	="";
		String  codeDesc="";
		while (rs.next())
			{
				codeCol			    = ChkDef.defaultString(rs.getString(1));
				codeDesc			= ChkDef.defaultString(rs.getString(2));
			    sb.append(codeDesc + "," + codeCol + ",");
			}

		 String str =   sb.toString() ;
		 sb.setLength(0);
		 return str.substring(0, str.length()-1);
	}
	catch(Exception e){
		e.printStackTrace();
		return null;
	}
	finally
	{
		try
		 {
		 	closeResultSet(rs);
		 	closeStatement(pstmt);
			closeConnection(connection);
		 }catch(Exception e){e.printStackTrace();

		 }
	}
}

/**************************************************************************/
public HashMap getOrderTypes(){
Connection connection =null ;
try
{
		connection = getConnection();
		HashMap hm = Populate.getAsHashArray(OrRepository.getOrKeyValue("SQL_OR_CATALOG_ORDER_TYPE"),connection,"ORDER_TYPE_CODE","ORDER_TYPE_CODE");
		return hm;
	}
	catch(Exception e){
		e.printStackTrace();
		return null;
	}
	finally
	{
		try
		 {
			closeConnection(connection);
		 }catch(Exception e){e.printStackTrace();

		 }
	}
}
/******************************************************************************/
public synchronized int  loadRecordedData(HttpServletRequest request){

Connection connection =null ;
PreparedStatement pstmt = null ;
ResultSet rs = null;
PreparedStatement pstmt_order = null ;
ResultSet rs_order = null;


if(recStoreHandler.getSize("DB")>0)
return recStoreHandler.getSize("DB");

order_category		  = request.getParameter("order_category");
tick_sheet_id		  = request.getParameter("tick_sheet_id");
section_code		  = request.getParameter("section_code");
String sql		 ="";

try
{
	connection	 = getConnection();
	sql = OrRepository.getOrKeyValue("SQL_OR_CATALOGSBYSECTION_UPDATE");

	pstmt = connection.prepareStatement(sql);
	pstmt.setString(1,ChkDef.defaultString(order_category));
	pstmt.setString(2,ChkDef.defaultString(tick_sheet_id));
	pstmt.setString(3,ChkDef.defaultString(section_code));

	rs = pstmt.executeQuery();

	String order_catalog_code = "";
	String order_catalog_desc = "";
 	String tick_sheet_seq_num = "";
	String order_type_code    = "";
	String order_type_desc    = "";
	HashMap	tempHash=null;
	HashMap	tempHashO=null;
	ArrayList orderTypeListVal =null;
	ArrayList orderTypeListDesc=null;
	//Added By Sridhar Reddy On 22/03/2010 For "Maximum open cursors issue"
	pstmt_order = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_CATALOG_ORDER_TYPE")) ;
	//End
	while(rs.next()){

		tempHash = new HashMap();
		tempHashO = new HashMap();


	order_catalog_code = rs.getString("order_catalog_code");
	order_catalog_desc = rs.getString("order_catalog_short_desc");
 	tick_sheet_seq_num = rs.getString("tick_sheet_seq_num");
	order_type_code    = rs.getString("order_type_code");
	order_type_desc    = rs.getString("order_type_desc");
//Commented By Sridhar Reddy On 22/03/2010 For "Maximum open cursors issue"
//	pstmt_order = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_CATALOG_ORDER_TYPE")) ;
// End
	pstmt_order.setString(1,order_catalog_code.trim());
	pstmt_order.setString(2,order_type_code.trim());

	rs_order = pstmt_order.executeQuery();

	orderTypeListVal = new ArrayList();
	orderTypeListDesc = new ArrayList();

	int k =0 ,l=0;
	orderTypeListVal.add(l++ , order_type_code) ;
	orderTypeListDesc.add(k++, order_type_desc) ;

	while(rs_order.next()){
	orderTypeListVal.add(l++,rs_order.getString("order_type_code")) ;
	orderTypeListDesc.add(k++,rs_order.getString("order_type_desc")) ;
	}
	closeResultSet(rs_order);
	tempHash.put("order_category",order_category);
	tempHash.put("tick_sheet_id",tick_sheet_id);
	tempHash.put("section_code", section_code);
	tempHash.put("order_type_list_code",orderTypeListVal);
	tempHash.put("order_type_list_desc",orderTypeListDesc);
	tempHash.put("order_type_sel", order_type_code);
	tempHash.put("order_catalog_code", order_catalog_code);
	tempHash.put("order_catalog_desc", order_catalog_desc);
	tempHash.put("tick_sheet_seq_num", tick_sheet_seq_num);
    tempHash.put("valid"			,	"Y");
	tempHash.put("associate_yn"		,   "y");
	tempHash.put("status"			,   "N");

	//Holding Original value

	tempHashO.put("order_category"		, order_category);
	tempHashO.put("tick_sheet_id"		, tick_sheet_id);
	tempHashO.put("section_code"		, section_code);
	tempHashO.put("order_type_list_code", orderTypeListVal);
	tempHashO.put("order_type_list_desc", orderTypeListDesc);
	tempHashO.put("order_type_sel"		, order_type_code);
	tempHashO.put("order_catalog_code"	, order_catalog_code);
	tempHashO.put("order_catalog_desc"	, order_catalog_desc);
	tempHashO.put("tick_sheet_seq_num"	, tick_sheet_seq_num);
    tempHashO.put("valid"				, "Y");
	tempHashO.put("associate_yn"		, "y");
	tempHashO.put("status"				, "N");



	recStoreHandler.putObject(tempHash);
	recStoreHandler.putObjectOriginal(tempHashO);
	} //End of while loop

  }catch(Exception e){
			e.printStackTrace();
  }finally{
		try
		 {
		 	closeResultSet(rs_order);
		 	closeStatement(pstmt_order);
		 	closeResultSet(rs);
		 	closeStatement(pstmt);
			closeConnection(connection);
		 }catch(Exception e){e.printStackTrace();

		 }
  }

   return recStoreHandler.getSize("DB");

}
/***********************************************************************/
public int  loadIndexData(HttpServletRequest request){
	Connection connection =null ;
	PreparedStatement pstmt = null ;
	ResultSet rs = null;
	PreparedStatement pstmt_order = null ;
	ResultSet rs_order = null;

	order_category		  = request.getParameter("order_category");
	tick_sheet_id		  = request.getParameter("tick_sheet_id");
	section_code		  = request.getParameter("section_code");
	OrderCatalogIndex	  = request.getParameter("OrderCatalogIndex");

    String fpp_yn = request.getParameter("fpp_yn");//IN072524
	
	Boolean isfppapplicable = getIsFPPApplicable();//IN072524
    String sql = "";


	//String sql		 ="";
	//tempChk = "o=" + OrderCatalogIndex  ;
try
{
	connection	 = getConnection();

	if(OrderCatalogIndex.trim().equalsIgnoreCase("others")){
	//pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_CATALOG_OTHERS")) ;//IN072524
	sql = "SELECT A.ORDER_CATALOG_CODE ORDER_CATALOG_CODE, A.SHORT_DESC SHORT_DESC,A.ORDER_TYPE_CODE ORDER_TYPE_CODE,B.SHORT_DESC ORDER_TYPE_DESC FROM  OR_ORDER_CATALOG A, OR_ORDER_TYPE B WHERE A.ORDER_TYPE_CODE = B.ORDER_TYPE_CODE AND A.ORDER_CATEGORY=decode(?,'*A',a.Order_Category,?) AND UPPER(A.SHORT_DESC) NOT BETWEEN UPPER(?) AND UPPER('_Z%') AND a.eff_status = 'E' ##FPP_APPLICABLEYN## ORDER BY A.SHORT_DESC";//IN072524
	pstmt = connection.prepareStatement(sql) ;//IN072524
	
	//IN072524 Starts
	  if(isfppapplicable){
	  if("Y".equals(fpp_yn)){
		  sql=sql.replace("##FPP_APPLICABLEYN##"," AND a.FPP_YN='Y' ");
	  }else{
		  sql=sql.replace("##FPP_APPLICABLEYN##"," AND (a.FPP_YN IS NULL OR a.FPP_YN='N') ");
	  }
	  }
	  else
		  sql=sql.replace("##FPP_APPLICABLEYN##","");
	  //IN072524 Ends
	OrderCatalogIndex = "A";
	}else{
	OrderCatalogIndex = OrderCatalogIndex.trim() + "%";
	//pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_CATALOG")) ;//IN072524
	//tempChk +="  orderIndex="+ OrderCatalogIndex + " SQlaa="+OrInterface.SQL_OR_CATALOG;//IN072524
	sql = "SELECT A.ORDER_CATALOG_CODE ORDER_CATALOG_CODE, A.SHORT_DESC SHORT_DESC,A.ORDER_TYPE_CODE ORDER_TYPE_CODE,B.SHORT_DESC ORDER_TYPE_DESC FROM  OR_ORDER_CATALOG A, OR_ORDER_TYPE B WHERE B.ORDER_TYPE_CODE = A.ORDER_TYPE_CODE AND A.ORDER_CATEGORY=decode(?,'*A',a.Order_Category,?) AND upper(A.SHORT_DESC) LIKE upper(?) AND a.eff_status = 'E' ##FPP_APPLICABLEYN## ORDER BY A.SHORT_DESC";//IN072524
	//IN072524 Starts
	  if(isfppapplicable){
	  if("Y".equals(fpp_yn)){
		  sql=sql.replace("##FPP_APPLICABLEYN##"," AND a.FPP_YN='Y' ");
	  }else{
		  sql=sql.replace("##FPP_APPLICABLEYN##"," AND (a.FPP_YN IS NULL OR a.FPP_YN='N') ");
	  }
	  }
	  else
		  sql=sql.replace("##FPP_APPLICABLEYN##","");
	  //IN072524 Ends
	}

//	tempChk +="Before Querty Exe";
	pstmt.setString(1,order_category.trim());
	pstmt.setString(2,order_category.trim());
	pstmt.setString(3,OrderCatalogIndex);

	rs = pstmt.executeQuery();

	recStoreHandler.clearSelectRec();//first clear  the  prevoius record.
//	tempChk +="Cleared";
		String tempCatalog= "" ;
		String defaultOrderTypeCode = "";
		String defaultOrderTypeDesc = "";
		HashMap tempHash=null;
		ArrayList orderTypeListVal = null;
		ArrayList orderTypeListDesc = null;
		/*Added by Jyothi to fix the open cursor exception*/
		pstmt_order = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_CATALOG_ORDER_TYPE")) ;
		/*END*/
		while(rs.next())
		{
		tempHash = new HashMap();//Represents each record
		tempCatalog= rs.getString("order_catalog_code") ;

		tempHash.put("order_catalog_code",tempCatalog);
		tempHash.put("order_catalog_desc",rs.getString("short_desc"));

		defaultOrderTypeCode = rs.getString("order_type_code");
		defaultOrderTypeDesc = rs.getString("order_type_desc");

		/***Query Order type Depending upon Order Catalog Selected******/
		/*Commented by Jyothi to fix the open cursor exception*/
		//pstmt_order = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_CATALOG_ORDER_TYPE")) ;
		/*END*/
		pstmt_order.setString(1,tempCatalog);
		pstmt_order.setString(2,defaultOrderTypeCode);

		tempChk = "Exception in sQL" ;

		rs_order = pstmt_order.executeQuery();

		orderTypeListVal = new ArrayList();
		orderTypeListDesc = new ArrayList();

		int k =0 ,l=0;
		orderTypeListVal.add(l++,defaultOrderTypeCode) ;
		orderTypeListDesc.add(k++,defaultOrderTypeDesc) ;
		while(rs_order.next())
		{
			orderTypeListVal.add(l++,rs_order.getString("order_type_code")) ;
			orderTypeListDesc.add(k++,rs_order.getString("order_type_desc")) ;
		}
		closeResultSet(rs_order);

		tempHash.put("order_category",order_category);
		tempHash.put("tick_sheet_id",tick_sheet_id);
		tempHash.put("section_code", section_code);
		tempHash.put("order_catalog_code",tempCatalog);
		tempHash.put("order_catalog_desc",rs.getString("short_desc"));
		tempHash.put("order_type_list_code" ,orderTypeListVal);
		tempHash.put("order_type_list_desc" ,orderTypeListDesc);
		tempHash.put("order_type_sel" , "");
		tempHash.put("tick_sheet_seq_num" , "");
		tempHash.put("valid"			,	"N");
		tempHash.put("associate_yn"		,   "N");
		tempHash.put("status"			,   "N");

		recStoreHandler.putListObject(tempHash);
		}



	}catch(Exception e){
			e.printStackTrace();
			tempChk = "Exception in sQL" + e ;
	}finally{
		try
		 {
		 	closeResultSet(rs_order);
		 	closeStatement(pstmt_order);
		 	closeResultSet(rs);
		 	closeStatement(pstmt);
			closeConnection(connection);
		 }catch(Exception e){e.printStackTrace();

		 }
	}
	return recStoreHandler.getSize("SELECT");
}
/**************************Synchronize in Associated Mode****************/
private void  synAsscStore(HttpServletRequest request){

int fm_disp  =ChkDef.defaultInt(request.getParameter("previousRecord"));
int to_disp	 =ChkDef.defaultInt(request.getParameter("nextRecord"));

try{
	Hashtable ht =null;
	for (int i = fm_disp-1; i <to_disp ; i++){

		 ht  = new Hashtable();
		ht.put("order_type_sel",ChkDef.defaultString((String)request.getParameter("order_type_code" + i)));
		ht.put("tick_sheet_seq_num",ChkDef.defaultString((String)request.getParameter("tick_sheet_seq_num" + i)));

		ht.put("include",checkForNull((String)request.getParameter("include" + i),"N"));

	//	tempChk += "" + i ;
		recStoreHandler.setDBBeanValue(i,ht);

	}
}catch(Exception e){
	logErrorMessage(e);
}

}
/**************************Synchronize in Associated Mode****************/
private void  synAsscStore(Hashtable request){

int fm_disp  =ChkDef.defaultInt(((String)request.get("previousRecord")));
int to_disp	 =ChkDef.defaultInt(((String)request.get("nextRecord")));

  try{
	  Hashtable ht=null;
	for (int i = fm_disp-1; i <to_disp ; i++){
		ht  = new Hashtable();
		ht.put("order_type_sel",ChkDef.defaultString((String)request.get("order_type_code" + i)));
		ht.put("tick_sheet_seq_num",ChkDef.defaultString((String)request.get("tick_sheet_seq_num" + i)));
		ht.put("include",checkForNull((String)request.get("include" + i),"N"));
//		tempChk += "" + i ;
		recStoreHandler.setDBBeanValue(i,ht);
		}
   }catch(Exception e){
	logErrorMessage(e);
	}

}
/******************Update   Records  *********************/
private void updateCurrentPageForAsscStore(HttpServletRequest request){

	int fm_disp  =ChkDef.defaultInt(request.getParameter("previousRecord"));
	int to_disp	 =ChkDef.defaultInt(request.getParameter("nextRecord"));
try{
		String ascc="";

	for (int i = fm_disp-1; i <to_disp ; i++){

		ascc = checkForNull((String)request.getParameter("include" + i),"N");
		HashMap ht  =(HashMap)recStoreHandler.getListObject(i);
		String pk[] ={(String)ht.get("order_catalog_code")};//Primary Key

		ht = Validaty(ht); //this will give the inserted record if already present in the database

		if(((String)ht.get("valid")).trim().equalsIgnoreCase("Y"))
		continue ;

//		tempChk +="there" ;

		if(ascc.trim().equalsIgnoreCase("Y")){
			ht.put("order_type_sel",ChkDef.defaultString((String)request.getParameter("order_type_code" + i)));
			ht.put("tick_sheet_seq_num",ChkDef.defaultString((String)request.getParameter("tick_sheet_seq_num" + i)));
			ht.put("valid"			,	"N");
			ht.put("associate_yn"	,	"y");
			ht.put("status"			,   "y");
			recStoreHandler.setObject(pk,ht);//Will add or set depending upon the primary key match
		}else{//remove form assoc list if alreay asccociated
			int indx = recStoreHandler.containsElement(pk);
			if(indx != -1 )
			recStoreHandler.removeObject(indx);
		}
	  }
	}catch(Exception e){
	logErrorMessage(e);
	}
}
/******************Update   Records  *********************/
private void updateCurrentPageForAsscStore(Hashtable request){
//	tempChk="here";
	int fm_disp  =ChkDef.defaultInt(((String)request.get("previousRecord")));
	int to_disp	 =ChkDef.defaultInt(((String)request.get("nextRecord")));
try{
//	tempChk +="Before for loop";
String ascc="";
	for (int i = fm_disp-1; i <to_disp ; i++){

		ascc = checkForNull(((String)request.get("include" + i)),"N");
		HashMap ht  =(HashMap)recStoreHandler.getListObject(i);
		String pk[] ={(String)ht.get("order_catalog_code")};//Primary Key

		ht = Validaty(ht); //this will give the inserted record if already present in the database

		if(((String)ht.get("valid")).trim().equalsIgnoreCase("Y"))
		continue ;

//		tempChk +="there" ;

		if(ascc.trim().equalsIgnoreCase("Y")){
			ht.put("order_type_sel",ChkDef.defaultString(((String)request.get("order_type_code" + i))));
			ht.put("tick_sheet_seq_num",ChkDef.defaultString(((String)request.get("tick_sheet_seq_num" + i))));
			ht.put("valid"			,	"N");
			ht.put("associate_yn"	,	"y");
			ht.put("status"			,   "y");
			recStoreHandler.setObject(pk,ht);//Will add or set depending upon the primary key match
		}else{//remove form assoc list if alreay asccociated
			int indx = recStoreHandler.containsElement(pk);
			if(indx != -1 )
			recStoreHandler.removeObject(indx);
		}

	}
}catch(Exception e){
	logErrorMessage(e);
}
}
/******************************************************************************/
private String replace(String str ,String change ,String replace){
int t = str.indexOf(change);
if( t == -1)
	return str;

str   = str.substring(0,t) + " '" + replace.trim()+ "' " + str.substring(t+1)  ;
return str ;
}
/**********This Method  Actually Calls the EJB's Method ********************/
 private  HashMap getResult(HashMap record , HashMap sqlMap ) {
	HashMap map  = new HashMap() ;
	try
		{


			/*InitialContext context = new InitialContext();
			Object object		   = context.lookup(OrRepository.getOrKeyValue("CATALOGBYSECTION_JNDI"));
			ORCatalogBySectionHome home  = (ORCatalogBySectionHome) PortableRemoteObject.narrow( object,ORCatalogBySectionHome.class );
			ORCatalogBySectionRemote remote = home.create() ;*/
			HashMap tabDataParam =  new HashMap() ;
			StringBuffer tmpBuff	= new StringBuffer();
			tabDataParam.put( "properties", getProperties() );
			tabDataParam.put( "tabData",     record );

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("CATALOGBYSECTION_JNDI"), ORCatalogBySectionHome.class, getLocalEJB());
    		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[]	= new Object[2];
				argArray[0]		= tabDataParam;
				argArray[1]		= sqlMap;
 			Class [] paramArray = new Class[2];
 		 		paramArray[0]	= tabDataParam.getClass();
				paramArray[1]	= sqlMap.getClass();

			if(mode.equals(CommonRepository.getCommonKeyValue("MODE_DELETE"))){
				return null ;
			}else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {

				//map = remote.insert(tabDataParam, sqlMap ) ;

				map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			//	map = insert(tabDataParam, sqlMap ) ;
			}else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))){
				return null ;
			}

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

		  return map;

	 }catch(Exception e){
		map.put( "message", e.getMessage() );
		e.printStackTrace() ;
		return map ;
	}

 }//End of Method

/**********************Handle Action in all scenario's***********************/
public synchronized  void handleAction(HttpServletRequest request){


  String detailPageMode_p	=request.getParameter("detailPageMode") ;
  this.action				=request.getParameter("action") ;


//Scenario 9,10,11 will be called in apply Method

//No mode
  if(detailPageMode_p.equalsIgnoreCase("N")){
	if(action.equalsIgnoreCase("IndexSelect")) {//scenario 13
	loadIndexData(request);
	this.detailPageMode = "S" ;
	}
	if(action.equalsIgnoreCase("select")) //scenario 3
	this.detailPageMode = "S" ;
	if(action.equalsIgnoreCase("associated"))//scenario 6
	this.detailPageMode = "A" ;

	loadRecordedData(request);//scenario 3,6
 }

 //Select mode
 if(detailPageMode_p.equalsIgnoreCase("S")){
	updateCurrentPageForAsscStore(request);//scenario 2,5,8,12 --even in case of next prev

	if(action.equalsIgnoreCase("indexSelect")){//scenario 12
	loadIndexData(request);
	this.detailPageMode = "S" ;
	}

	if(action.equalsIgnoreCase("associated")){//Scenario 2
		this.detailPageMode = "A" ;
	}
}
 //Ass mode
 if(detailPageMode_p.equalsIgnoreCase("A")){
//	 tempChk += "here in Ascc";
	synAsscStore(request);//scenario 1,4,7--even in case of next prev
  	this.detailPageMode = "A" ;
}

}//End of Handle Method
/********************************************************************/
public synchronized int getRecordsNo(){
//String action	= request.getParameter("action") ;
if(detailPageMode.equalsIgnoreCase("A"))
	return recStoreHandler.getSize("DB") ;
else
	return recStoreHandler.getSize("SELECT") ;
}
/*******************************************************************/
public synchronized Object getRecord( int i){
//String action	= request.getParameter("action") ;
try{
	if(detailPageMode.equalsIgnoreCase("A")){
	return recStoreHandler.getObject(i) ;
	}else{
	return recStoreHandler.getListObject(i) ;}
}catch(Exception e){
	return null ;
}
}
/********Gives the DataBase Record if already  present or for Ascc /else Original DataBase record***********/
public synchronized HashMap Validaty(HashMap record ){
try{


 


	if(detailPageMode.equalsIgnoreCase("A"))
	return record ; //return Original

	String pk[] ={(String)record.get("order_catalog_code")};//Primary Key
	
	int index =	recStoreHandler.containsElement(pk) ;


	
	this.tempChk =this.tempChk+ "  " + index ;

	 if(index != -1){//Rec is there in Ascc store


		HashMap tempChk	 =(HashMap)recStoreHandler.getObject(index);

		String valid = (String)tempChk.get("valid");


		if(valid.trim().equalsIgnoreCase("Y")){//if it was form DataBase
			int indexOriginal = recStoreHandler.containsElementInOriginalDB(pk);
			if(indexOriginal != -1)
			{

				return (HashMap)recStoreHandler.getObjectOriginal(indexOriginal) ;//DataBase record
			}
			else
				return null ;//Some Error Condition Chk it
		}else
			return (HashMap)recStoreHandler.getObject(index) ;//Ascc record

	}else{ //not in ascc store

		return record;
	  }	 //return Original
	}catch(Exception e){
		e.printStackTrace();
	 return null ;
	}
}
/***************************************************************************/
public void clearAll() throws Exception
{
	//recStoreHandler.clearDBRec();
	//recStoreHandler.clearSelectRec();
	//recStoreHandler.clearDBRecOriginal();
	multiRecBean.clearDBRec();
	multiRecBean.clearSelectRec();
	multiRecBean.clearDBRecOriginal();
}
/********************************************************************/
 public  synchronized void SortedArrayListAscc(){

  java.util.ArrayList tempRef		= recStoreHandler.getAllDBRecords();
  java.util.TreeMap sorter			= new java.util.TreeMap();
  java.util.ArrayList holdDuplicate = new java.util.ArrayList();

  int sizeAscc = tempRef.size(); //ref of the Object DB Array List
	HashMap tempHash=null;
	
	
  for(int i=0 ; i < sizeAscc ; i++){
	  tempHash = (java.util.HashMap)tempRef.get(i);
	  String seqNoStr = checkForNull(((String)tempHash.get("tick_sheet_seq_num")),"0");
      Integer  seqNo   = new Integer( Integer.parseInt(seqNoStr));
	  if(!sorter.containsKey(seqNo)){
		  sorter.put(seqNo,tempHash);
	  }else{
		  holdDuplicate.add(tempHash);//array List of Dup records
	  }
 }
	tempRef.clear();//Clear  the  DB  records

	Collection  coll = sorter.values();
	Iterator iter    = coll.iterator();

	int dupSize = holdDuplicate.size();
	HashMap tempSrt	 =null;
	String  seqNoStr1  ="";
	HashMap tempDup	=null;
	String seqNoStr2="";

	while(iter.hasNext()){
	  tempSrt	 =(java.util.HashMap)iter.next();
	  seqNoStr1  =checkForNull(((String)tempSrt.get("tick_sheet_seq_num")),"0");
	  int seqNoSrt   =Integer.parseInt(seqNoStr1);

	  for(int j=0;j<dupSize;j++){
	  tempDup	= (java.util.HashMap)holdDuplicate.get(j);
	  seqNoStr2	= checkForNull(((String)tempDup.get("tick_sheet_seq_num")),"0");
      int  seqNoDup		=Integer.parseInt(seqNoStr2);
	  if(seqNoSrt == seqNoDup)
	  tempRef.add(tempDup);	//inserting Dup Values
	  }

	  tempRef.add(tempSrt);
	}
}
/**************Over riding get Message**************************************/
public String getMessage( String msgId ){
	String msg ="";

	if(msgId.equals("DUPLICATE_SEQ_NO")){
		msg = super.getMessage("DUPLICATE_SEQ_NO");
		int r= msg.indexOf("<br>");
		if(r==-1)
		  msg = msg.substring(0,msg.length()) ;
		else
		  msg = msg.substring(0,r) ;
	return msg;
	}else{
	return super.getMessage(msgId) ;
	}
}
/***************************************************************************/



public HashMap insert(HashMap tabDataParam , HashMap sqlMap )  {
		StringBuffer messages = new StringBuffer() ;
		StringBuffer traceVal = new StringBuffer() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "flag" ) ;


		HashMap tabData_p		 =(HashMap)tabDataParam.get("tabData");
		//Properties  pt      	 =(Properties)tabDataParam.get("properties");

		ArrayList tabDataMultiple=(ArrayList)tabData_p.get("records");
		String login_by_id		 =(String)tabData_p.get("login_by_id" ) ;
		String login_at_ws_no	 =(String)tabData_p.get("login_at_ws_no" ) ;
		String login_facility_id =(String)tabData_p.get("login_facility_id" ) ;

        Connection connection = null ;
		PreparedStatement pstmt_I = null ;
 		PreparedStatement pstmt_U = null ;
 		PreparedStatement pstmt_D = null ;

	try {
		 connection	= getConnection();
		 //connection = getConnection(pt) ;
	 	 int noOfRecords = tabDataMultiple.size() ;

		String SQL_OR_CATALOGSBYSECTION_INSERT	= (String)sqlMap.get("SQL_OR_CATALOGSBYSECTION_INSERT");
		String SQL_OR_CATALOGSBYSECTION_UPDATE	= (String)sqlMap.get("SQL_OR_CATALOGSBYSECTION_UPDATE");
		String SQL_OR_CATALOGSBYSECTION_DELETE	= (String)sqlMap.get("SQL_OR_CATALOGSBYSECTION_DELETE");

		pstmt_D = connection.prepareStatement(SQL_OR_CATALOGSBYSECTION_DELETE);
		pstmt_U = connection.prepareStatement(SQL_OR_CATALOGSBYSECTION_UPDATE);
		pstmt_I = connection.prepareStatement(SQL_OR_CATALOGSBYSECTION_INSERT);



		int counter_I=0,counter_U=0,counter_D=0;
		traceVal.append("***no of recs ="+noOfRecords);
		HashMap tabData     =null;
		String  valid	    ="";
		String  associate_yn="";
		for(int k=0 ; k< noOfRecords ; k++){

		tabData     =(HashMap)tabDataMultiple.get(k);
		valid	    =(String)tabData.get("valid");
		associate_yn=(String)tabData.get("associate_yn");
			traceVal.append("***b4 update=");
		if(valid.trim().equalsIgnoreCase("Y")){
			if(associate_yn.trim().equalsIgnoreCase("Y")){//update
			counter_U++ ;
			pstmt_U.setString(1 ,(String)tabData.get("order_type_sel"));
			pstmt_U.setString(2 ,(String)tabData.get("tick_sheet_seq_num"));
			pstmt_U.setString(3 ,login_by_id);
			pstmt_U.setString(4 ,login_at_ws_no);
			pstmt_U.setString(5 ,login_facility_id);
			pstmt_U.setString(6 ,(String)tabData.get("order_category"));
			pstmt_U.setString(7 ,(String)tabData.get("tick_sheet_id"));
			pstmt_U.setString(8 ,(String)tabData.get("section_code"));
			pstmt_U.setString(9 ,(String)tabData.get("order_catalog_code"));
			pstmt_U.addBatch();
			}else{//delete
			traceVal.append("***begin delete=");
			counter_D++ ;
			pstmt_D.setString(1 ,(String)tabData.get("order_category"));
			pstmt_D.setString(2 ,(String)tabData.get("tick_sheet_id"));
			pstmt_D.setString(3 ,(String)tabData.get("section_code"));
			pstmt_D.setString(4 ,(String)tabData.get("order_catalog_code"));
			pstmt_D.addBatch();
			}
		}
		if(valid.equalsIgnoreCase("N")){
			traceVal.append("***begin insertion=");
			traceVal.append("associate_yn="+(String)tabData.get("associate_yn")) ;
			if(associate_yn.equalsIgnoreCase("Y")){//Insert
			counter_I++;
			traceVal.append("tick_sheet_id="+(String)tabData.get("tick_sheet_id")) ;
			traceVal.append("order_category="+(String)tabData.get("order_category")) ;

			pstmt_I.setString(1 ,(String)tabData.get("order_category"));
			pstmt_I.setString(2 ,(String)tabData.get("tick_sheet_id"));
			pstmt_I.setString(3 ,(String)tabData.get("section_code"));
			pstmt_I.setString(4 ,(String)tabData.get("tick_sheet_seq_num"));
			pstmt_I.setString(5 ,(String)tabData.get("order_catalog_code"));
			pstmt_I.setString(6 ,(String)tabData.get("order_type_sel"));
			pstmt_I.setString(7 ,login_by_id);
			pstmt_I.setString(8 ,login_at_ws_no);
			pstmt_I.setString(9 ,login_facility_id);
			pstmt_I.setString(10,login_by_id);
			pstmt_I.setString(11,login_at_ws_no);
			pstmt_I.setString(12,login_facility_id);
			pstmt_I.addBatch();
		   }
		 }
		traceVal.append("***no of recs ="+k);

	  }//End of For Looping for all records



	  traceVal.append("counter_I="+counter_I) ;

			int [] updatedCounts_I ={};
			int [] updatedCounts_U ={};
			int [] updatedCounts_D ={};

			 if(counter_I > 0)
				 updatedCounts_I = pstmt_I.executeBatch();

	         if(counter_U > 0)
			 		 updatedCounts_U = pstmt_U.executeBatch();

					 if(counter_D > 0)
			 		 updatedCounts_D = pstmt_D.executeBatch();




			boolean updated_I = true ;
			boolean updated_U = true ;
			boolean updated_D = true ;

			if(counter_I > 0){
			 if((updatedCounts_I.length > 0)){
					updated_I= true ;
			 }else if((updatedCounts_I.length == (-3))){
					updated_I= false ;
			 }
			}

			if(counter_U > 0){
			 if((updatedCounts_U.length > 0)){
					updated_U= true ;
		     }else if((updatedCounts_U.length == (-3))){
					updated_U= false ;
			 }
			}

			if(counter_D > 0){
			 if((updatedCounts_D.length > 0)){
					updated_D= true ;
			 }else if((updatedCounts_D.length == (-3))){
					updated_D= false ;
			 }
			}


			if (updated_I && updated_U && updated_D ){
				connection.commit();
				map.put( "result", new Boolean( true ) ) ;
				messages.append("RECORD_INSERTED") ;
			}else{
				connection.rollback();
				messages.append( "Insert Failed" ) ;
			}

		}catch( Exception e ){
					traceVal.append(e.getMessage());
					map.put( "traceVal", traceVal.toString() ) ;

					try {
						connection.rollback();
//						closeConnection( connection,pt );
						//closeConnection(connection);
						} catch ( Exception ee ) {
						messages.append(ee.getMessage() ) ;
						}
				messages.append( e.getMessage() ) ;
				e.printStackTrace() ;
    		  } finally{
	            	try {
				//		closeConnection( connection,pt);
						closeStatement(pstmt_I);
						closeStatement(pstmt_U);
						closeStatement(pstmt_D);
						closeConnection(connection);
					} catch ( Exception fe ) {
					   	fe.printStackTrace() ;
			        }
	    	    }

			map.put( "message", messages.toString() ) ;
			map.put( "traceVal", traceVal.toString() ) ;
			return map ;

 }//End of Insert Method

/*Added by Uma on 9/9/2009 for IN013057
***************************To get the multiRecord bean ***********/
 public Object getRecordSet(HttpServletRequest request)throws Exception
{
	//IN068370,IN068373	Start.
	HttpSession	session		=	null;
			session		=	request.getSession(false);
	String login_facility_id		=	(String)session.getValue("facility_id");
	//IN068370,IN068373 End.
	Connection connection = null ;
	PreparedStatement pstmt=null;
	//PreparedStatement pstmt_detail=null;
	PreparedStatement pstmt_order=null;
	ResultSet rs=null;
	//ResultSet rs_detail = null;
	ResultSet rs_order = null;
	//String sql_detail_query="";
	String associate_detail_yn="";
	String defaultOrderTypeCode = "";
	String defaultOrderTypeDesc = "";

	String order_category		  = request.getParameter("order_category");
	String tick_sheet_id		  = request.getParameter("tick_sheet_id");
	String section_code		  = request.getParameter("section_code");
	String OrderCatalogIndex	  = request.getParameter("OrderCatalogIndex");
	String searchingValue	  = request.getParameter("searchingValue");



	ArrayList orderTypeListVal =null;
	ArrayList orderTypeListDesc=null;
	//IN068370,IN068373 Start.
	setSiteSpecific("ORDER_CATALOG_FAC_WISE");
	Boolean is_ss_order_catlg_fac_wise = isSiteSpecific("ORDER_CATALOG_FAC_WISE");
	//IN068370,IN068373 End.
	String sql = "";//IN072524
	String fpp_yn = request.getParameter("fpp_yn");//IN072524
	Boolean isfppapplicable = getIsFPPApplicable();//IN072524
	try
	{
		java.util.HashMap htRecord = null;
		String catalog_desc="",  code="";
		connection = getConnection();
		multiRecBean.clearSelectRec();
		if(searchingValue.equals(""))
		{
			OrderCatalogIndex=OrderCatalogIndex;
		}
		else
		{
			OrderCatalogIndex=searchingValue;
		}

		if(OrderCatalogIndex.trim().equalsIgnoreCase("others"))
		{
	//IN068370,IN068373 Start.
			if(is_ss_order_catlg_fac_wise){
				pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDERSET_CATALOG_CODE_OTHRS_GLB_FAC_WISE")) ;
				pstmt.setString(1,order_category.trim());
				pstmt.setString(2,order_category.trim());
				pstmt.setString(3,login_facility_id);
			}else{
		//IN068370,IN068373 end.
			//IN072524 Starts
				//pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDERSET_CATALOG_CODE_OTHRS")) ;
				sql ="SELECT A.ORDER_CATALOG_CODE, A.SHORT_DESC,A.ORDER_TYPE_CODE,B.SHORT_DESC ORDER_TYPE_DESC,a.ordeR_category order_category ,a.QTY_REQD_YN ,a.freq_applicable_yn FROM  OR_ORDER_CATALOG A, OR_ORDER_TYPE B WHERE A.ORDER_TYPE_CODE = B.ORDER_TYPE_CODE AND A.ORDER_CATEGORY=DECODE(?,'*A',a.Order_Category,?) AND UPPER(A.SHORT_DESC) NOT BETWEEN UPPER('A%') AND UPPER('_Z%') AND order_catalog_nature !='S'  and  a.EFF_STATUS='E' ##FPP_APPLICABLEYN## order by  A.SHORT_DESC";
				 if(isfppapplicable){
					  if("Y".equals(fpp_yn)){
						  sql=sql.replace("##FPP_APPLICABLEYN##"," AND a.FPP_YN='Y' ");
					  }else{
						  sql=sql.replace("##FPP_APPLICABLEYN##"," AND (a.FPP_YN IS NULL OR a.FPP_YN='N') ");
					  }
					  }
			     else
				  sql=sql.replace("##FPP_APPLICABLEYN##","");
				 pstmt = connection.prepareStatement(sql) ; 
				 //IN072524 End
				pstmt.setString(1,order_category.trim());
				pstmt.setString(2,order_category.trim());
			}
		}
		else
		{
			OrderCatalogIndex = OrderCatalogIndex + "%";
		//IN068370,IN068373 Start.
			if(is_ss_order_catlg_fac_wise){
				pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_CATALOG_GLB_FAC_WISE")) ;
				pstmt.setString(1,order_category.trim());
				pstmt.setString(2,order_category.trim());
				pstmt.setString(3,OrderCatalogIndex);
				pstmt.setString(4,login_facility_id);
				
			}else{
		//IN068370,IN068373 End.
				//IN072524 Starts 
				//pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_CATALOG")) ;
				 sql = "SELECT A.ORDER_CATALOG_CODE ORDER_CATALOG_CODE, A.SHORT_DESC SHORT_DESC,A.ORDER_TYPE_CODE ORDER_TYPE_CODE,B.SHORT_DESC ORDER_TYPE_DESC FROM  OR_ORDER_CATALOG A, OR_ORDER_TYPE B WHERE B.ORDER_TYPE_CODE = A.ORDER_TYPE_CODE AND A.ORDER_CATEGORY=decode(?,'*A',a.Order_Category,?) AND upper(A.SHORT_DESC) LIKE upper(?) AND a.eff_status = 'E' ##FPP_APPLICABLEYN## ORDER BY A.SHORT_DESC";
				
				  if(isfppapplicable){
				  if("Y".equals(fpp_yn)){
					  sql=sql.replace("##FPP_APPLICABLEYN##"," AND a.FPP_YN='Y' ");
				  }else{
					  sql=sql.replace("##FPP_APPLICABLEYN##"," AND (a.FPP_YN IS NULL OR a.FPP_YN='N') ");
				  }
				  }
				  else
					  sql=sql.replace("##FPP_APPLICABLEYN##","");
				  pstmt = connection.prepareStatement(sql) ;
				  //IN072524 Ends
				pstmt.setString(1,order_category.trim());
				pstmt.setString(2,order_category.trim());
				pstmt.setString(3,OrderCatalogIndex);
			}

		}

		
		rs = pstmt.executeQuery();
// Added by Sridhar Reddy on 22/03/2010 for "Maximum open cursors issue"
		//IN068370,IN068373 Start.
		if(is_ss_order_catlg_fac_wise){
			pstmt_order = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_CATALOG_ORDER_TYPE_GLB_FAC_WISE")) ;
		}else{
		//IN068370,IN068373 end.
			pstmt_order = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_CATALOG_ORDER_TYPE")) ;
		}
		//End
		if(rs != null)
		{
			while(rs.next())
			{
				associate_detail_yn="";
				code				=	rs.getString("order_catalog_code");
				catalog_desc		=	rs.getString("short_desc");
					
				if(catalog_desc == null || catalog_desc.equals("null"))catalog_desc="";
				defaultOrderTypeCode = rs.getString("order_type_code");
				defaultOrderTypeDesc = rs.getString("order_type_desc");

				/***Query Order type Depending upon Order Catalog Selected******/
				// Comment by Sridhar Reddy on 22/03/2010 for "Maximum open cursors issue"
		//		pstmt_order = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_CATALOG_ORDER_TYPE")) ;
		//IN068370,IN068373 Start.
				if(is_ss_order_catlg_fac_wise){
					pstmt_order.setString(1,login_facility_id);
					pstmt_order.setString(2,code);
					pstmt_order.setString(3,defaultOrderTypeCode);					
				}else{
		//IN068370,IN068373 end.
					pstmt_order.setString(1,code);
					pstmt_order.setString(2,defaultOrderTypeCode);
				}
				rs_order = pstmt_order.executeQuery();

				orderTypeListVal = new ArrayList();
				orderTypeListDesc = new ArrayList();

				int k =0 ,l=0;
				orderTypeListVal.add(l++,defaultOrderTypeCode) ;
				orderTypeListDesc.add(k++,defaultOrderTypeDesc) ;
				while(rs_order.next())
				{
					orderTypeListVal.add(l++,rs_order.getString("order_type_code")) ;
					orderTypeListDesc.add(k++,rs_order.getString("order_type_desc")) ;
				}
				// Added by Sridhar Reddy on 22/03/2010 for "Maximum open cursors issue"
				closeResultSet(rs_order);
				//end
				htRecord					=	new HashMap();

				htRecord.put("order_category",order_category);
				htRecord.put("tick_sheet_id",tick_sheet_id);
				htRecord.put("section_code", section_code);
				htRecord.put("order_catalog_code",code);
				htRecord.put("order_catalog_desc",rs.getString("short_desc"));
				htRecord.put("order_type_list_code" ,orderTypeListVal);
				htRecord.put("order_type_list_desc" ,orderTypeListDesc);
				htRecord.put("order_type_sel" , "");
				htRecord.put("tick_sheet_seq_num" , "");
				htRecord.put("valid"			,	"N");
				htRecord.put("associate_yn"		,   "N");
				htRecord.put("status"			,   "N");
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
			closeResultSet(rs);
			closeStatement(pstmt_order);
			closeStatement(pstmt);
			closeConnection(connection);
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	return multiRecBean;
 }//end of getRecordSet

 /***************************To get the multiRecord bean ***********/
 public Object getBean()
{
	return this.multiRecBean;
 }//end of getBean

 /***************************To clear the multiRecord bean ***********/
  public boolean clearDBRec() throws Exception
{
	boolean clearFlag = false;
	clearFlag = multiRecBean.clearDBRec();
	return clearFlag;
 }//end of clearDBRec

/*********/
public int fetchDBRecords(HttpServletRequest request)throws Exception 
{

	int total_rec =0;
	Connection connection = null ;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt_order = null;
	//HashMap htMapRecord = null;
	ResultSet rs=null;
	ResultSet rs_order = null;


	String sql = "" ;
	String order_category		  = request.getParameter("order_category");
	String tick_sheet_id		  = request.getParameter("tick_sheet_id");
	String section_code		  = request.getParameter("section_code");
	

	try
	{
		int checkRec = multiRecBean.getSize("DB");
		if(checkRec==0)
		{
			connection	 = getConnection();
			sql = OrRepository.getOrKeyValue("SQL_OR_CATALOGSBYSECTION_UPDATE");

			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1,ChkDef.defaultString(order_category));
			pstmt.setString(2,ChkDef.defaultString(tick_sheet_id));
			pstmt.setString(3,ChkDef.defaultString(section_code));

			rs = pstmt.executeQuery();

			String order_catalog_code = "";
			String order_catalog_desc = "";
			String tick_sheet_seq_num = "";
			String order_type_code    = "";
			String order_type_desc    = "";
			HashMap	tempHash=null;
			HashMap	tempHashO=null;
			ArrayList orderTypeListVal =null;
			ArrayList orderTypeListDesc=null;
	// Added by Sridhar Reddy on 22/03/2010 for "Maximum open cursors issue"
		pstmt_order = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_CATALOG_ORDER_TYPE")) ;
	//End

			if(rs != null)
			{
				while(rs.next())
				{

					tempHash = new HashMap();
					tempHashO = new HashMap();


					order_catalog_code = rs.getString("order_catalog_code");
					order_catalog_desc = rs.getString("order_catalog_short_desc");
					tick_sheet_seq_num = rs.getString("tick_sheet_seq_num");
					order_type_code    = rs.getString("order_type_code");
					order_type_desc    = rs.getString("order_type_desc");

					// Commented by Sridhar Reddy on 22/03/2010 for "Maximum open cursors issue"
					//pstmt_order = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_CATALOG_ORDER_TYPE")) ;
					pstmt_order.setString(1,order_catalog_code.trim());
					pstmt_order.setString(2,order_type_code.trim());

					rs_order = pstmt_order.executeQuery();

					orderTypeListVal = new ArrayList();
					orderTypeListDesc = new ArrayList();

					int k =0 ,l=0;
					orderTypeListVal.add(l++ , order_type_code) ;
					orderTypeListDesc.add(k++, order_type_desc) ;

					while(rs_order.next())
					{
						orderTypeListVal.add(l++,rs_order.getString("order_type_code")) ;
						orderTypeListDesc.add(k++,rs_order.getString("order_type_desc")) ;
					}
					// Added by Sridhar Reddy on 22/03/2010 for "Maximum open cursors issue"
					if (rs_order != null )rs_order.close();
					//End
					
					tempHash.put("order_category",order_category);
					tempHash.put("tick_sheet_id",tick_sheet_id);
					tempHash.put("section_code", section_code);
					tempHash.put("order_type_list_code",orderTypeListVal);
					tempHash.put("order_type_list_desc",orderTypeListDesc);
					tempHash.put("order_type_sel", order_type_code);
					tempHash.put("order_catalog_code", order_catalog_code);
					tempHash.put("order_catalog_desc", order_catalog_desc);
					tempHash.put("tick_sheet_seq_num", tick_sheet_seq_num);
					tempHash.put("valid"			,	"Y");
					tempHash.put("associate_yn"		,   "y");
					tempHash.put("status"			,   "N");

					//Holding Original value

					tempHashO.put("order_category"		, order_category);
					tempHashO.put("tick_sheet_id"		, tick_sheet_id);
					tempHashO.put("section_code"		, section_code);
					tempHashO.put("order_type_list_code", orderTypeListVal);
					tempHashO.put("order_type_list_desc", orderTypeListDesc);
					tempHashO.put("order_type_sel"		, order_type_code);
					tempHashO.put("order_catalog_code"	, order_catalog_code);
					tempHashO.put("order_catalog_desc"	, order_catalog_desc);
					tempHashO.put("tick_sheet_seq_num"	, tick_sheet_seq_num);
					tempHashO.put("valid"				, "Y");
					tempHashO.put("associate_yn"		, "y");
					tempHashO.put("status"				, "N");

				multiRecBean.putObject(tempHash);
				multiRecBean.putObjectOriginal(tempHashO);
				}
			}
				closeResultSet(rs);
				closeStatement(pstmt_order);
				closeStatement(pstmt);
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
			closeResultSet(rs);
			closeStatement(pstmt_order);
			closeStatement(pstmt);
			closeConnection(connection);
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	return total_rec;
 }//end of fetchRecords

 /********Gives the DataBase Record if already  present or for Ascc /else Original DataBase record***********Added by Uma on 9/7/2009*/
	public boolean setBeanItemValue(int rowIndex, String value,String include,String catalogCode,String order_type_code)throws Exception
	{

		boolean altSelRecord  =	false;
		boolean altDBRecord =	false;
		int foundIndex = -1;
		java.util.HashMap hash = new java.util.HashMap();
		hash = (java.util.HashMap)multiRecBean.getListObject(rowIndex);
		String temp_order_catalog_code = "";

		if(include.equals("Y"))
		{
			hash.put("associate_yn", "Y");
			hash.put("tick_sheet_seq_num", value);
			hash.put("order_type_sel", order_type_code);
			altSelRecord = multiRecBean.setListObject(rowIndex, hash);

			if(altSelRecord)
			{

               	ArrayList allRecords = new ArrayList();
				allRecords = multiRecBean.getAllDBRecords();						
				java.util.HashMap hashValue = new java.util.HashMap();						
				if(allRecords!=null)
				{
					for(int z=0; z<allRecords.size();z++)
					{
							hashValue =(java.util.HashMap)multiRecBean.getObject(z);
							temp_order_catalog_code = (String)hashValue.get("order_catalog_code");
							if(catalogCode.equals(temp_order_catalog_code))
							{
								foundIndex = z;
								break;
							}
						}
				}					
				if(foundIndex != -1)
				{
					altDBRecord = multiRecBean.setObject(foundIndex,hash);
				}
				else
				{
					altDBRecord = multiRecBean.putObject(hash);
				}
			}
		}
		else if(include.equals("N"))
		{
			hash.put("associate_yn", "D");
			hash.put("tick_sheet_seq_num", "");
			hash.put("order_type_sel","");
			altSelRecord = multiRecBean.setListObject(rowIndex, hash);   
			if(altSelRecord)
			{
				altDBRecord = multiRecBean.removeRecord(hash);
			}
		}
		return altDBRecord;
	}


	/**
	  * Used to set the latest status of the bean value in the Associted records and inturn
	  * keep both to ArrayList in Synchronize, based on the operations
	  * performed on them.
	  * @param rowIndex refers the row Position.
	  *	@param value refers to the latest value.
	  */
	public boolean setDBBeanItemValue(int rowIndex, String value,String include,String catalogCode,String order_type_code)throws Exception
	{
		boolean altDBRecord =	false;
		String valid = "";
		java.util.HashMap hash = new java.util.HashMap();
		hash = (java.util.HashMap)multiRecBean.getObject(rowIndex);
		valid = (String)hash.get("valid");
		if(valid.equals("Y"))
		{
			if(include.equals("N"))
			{
				hash.put("associate_yn", "D");
				hash.put("tick_sheet_seq_num", value);
				altDBRecord = multiRecBean.setObject(rowIndex,hash);
			}
			else if(include.equals("Y"))
			{
				hash.put("associate_yn", "Y");
				hash.put("tick_sheet_seq_num", value);
				altDBRecord = multiRecBean.setObject(rowIndex,hash);
			}
		}
		else if(valid.equals("N"))
		{
			if(include.equals("N"))
			{
				hash.put("associate_yn", "D");
				hash.put("tick_sheet_seq_num", value);
				//hash.put("status"	   , "Y");
				altDBRecord = multiRecBean.setObject(rowIndex,hash);
			}
			else if(include.equals("Y"))
			{
				hash.put("associate_yn", "Y");
				hash.put("tick_sheet_seq_num", value);
				altDBRecord = multiRecBean.setObject(rowIndex,hash);
			}
		}
		return altDBRecord;
	}

	public ArrayList getSectionDetails(Hashtable ht) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String order_category = "";
		String tick_sheet = "";

		ArrayList sectionValues = new ArrayList() ;
		try{
				connection	= getConnection();
				pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CATALOG_SECTION") ) ;
				order_category		  = (String)ht.get("order_category")==null?"":(String)ht.get("order_category");
				tick_sheet				  = (String)ht.get("tick_sheet")==null?"":(String)ht.get("tick_sheet");
				pstmt.setString(1, order_category);
				pstmt.setString(2, tick_sheet);
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
				   while (  resultSet!=null && resultSet.next()) 
					{
						String[] record = null;
						record = new String[2];
						record[0] = checkForNull(resultSet.getString( "SECTION_CODE" ),"")  ;
						record[1] = checkForNull(resultSet.getString( "SECTION_DESC" ),"")  ;
						sectionValues.add(record) ;

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
			return sectionValues;
	}	 // End of the
	
	//IN072524 Starts
	public String getFPPYNTickSheet(Hashtable ht) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String order_category = "";
		String tick_sheet = "";
		String fpp_yn ="N";
		
		try{
				connection	= getConnection();
				pstmt		= connection.prepareStatement( "SELECT FPP_YN FROM OR_TICK_SHEET WHERE ORDER_CATEGORY=? AND TICK_SHEET_ID=? " ) ;
				order_category		  = (String)ht.get("order_category")==null?"":(String)ht.get("order_category");
				tick_sheet				  = (String)ht.get("tick_sheet")==null?"":(String)ht.get("tick_sheet");
				pstmt.setString(1, order_category);
				pstmt.setString(2, tick_sheet);
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
				   while (  resultSet!=null && resultSet.next()) 
					{
					   fpp_yn = checkForNull(resultSet.getString( "FPP_YN" ),"N")  ;
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
			return fpp_yn;
	}	
	//IN072524 Ends

 /*********************Method to fetch Alphabetical Records ***********************
 Ends here by Uma on 9/9/2009 for IN013057*/




}//ENd of the class
