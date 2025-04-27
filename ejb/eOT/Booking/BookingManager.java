/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT.Booking;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Properties;
import java.util.StringTokenizer;
import java.sql.Types;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
//import eOT.Common.ConnectionDispenser; //Commented on 02/07/13
import webbeans.eCommon.*;//Changed on 03/07/13 against UAT5 - Connection Issue
import eOT.Common.BillingUtil;
import eOT.Common.ErrorUtil;
import eOT.Common.BookingBillingManager;
import eOT.Common.ErrorQueue;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.CreateException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import eCommon.Common.CommonBean;//Added

/**
*
* @ejb.bean
*	name="Booking"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="Booking"
*	local-jndi-name="Booking"
*	impl-class-name="eOT.Booking.BookingManager"
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOT.Booking.BookingLocal"
*	remote-class="eOT.Booking.BookingRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOT.Booking.BookingLocalHome"
*	remote-class="eOT.Booking.BookingHome"
*	generate= "local,remote"
*
*
*/
public class BookingManager implements SessionBean
{
	String strBookingNum="";
	String strOrderId="";
	String strOrderLineNum="";
	String strOrderTypeCode="";
	String strErrMsg="";
	String ammendBooking = "";
	String selOrderIds = "";
	String ammendFlag = "";
	String selBookingNumber = "";
	 
	Map <String,String> orderlinemap=new HashMap<String,String>();   
	HashMap <String,String> booking_hdr   = new HashMap<String,String>(); 
	HashMap <String,HashMap> post_oper_dtls  = new HashMap<String,HashMap>(); 
	Properties  prop		= null;
	//public void ejbCreate() throws RemoteException, CreateException {}
	public void ejbCreate() {}
    public void ejbRemove() {}
    public void ejbActivate() {}
    public void ejbPassivate() {}
    public void setSessionContext( SessionContext context ) {}


	/**
	 *Method to insert the data
	 *@param tabData 
	 *@param sqlMap  
	 *@return HashMap holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	//INTERFACE METHOD
public HashMap insert( HashMap tabData, HashMap sqlMap )
{
	HashMap <String,String> map=new HashMap <String,String>();//for returning messages
	List<String> list = (ArrayList) tabData.get("mandatory_flds");
	Connection conn = null;//Changed on 03/07/13 against UAT5 - Connection Issue
	System.err.println("...Booking Manager...");
	System.err.println("=====tabData=====insertBookingHdr====BookingManager========"+tabData);
	System.err.println("=====sqlMap=====insertBookingHdr====BookingManager========"+sqlMap);
	try
	{
		boolean transaction_flag = true;
		prop		 = (Properties)tabData.get( "properties" );
		conn=ConnectionManager.getConnection(prop);//Changed on 03/07/13 against UAT5 - Connection Issue
		conn.setAutoCommit(false);
		booking_hdr = (HashMap)tabData.get("booking_hdr");
		ammendBooking = checkForNull(booking_hdr.get("ammendBooking"));
		selOrderIds = checkForNull(booking_hdr.get("selOrderIds"));
		ammendFlag = checkForNull(booking_hdr.get("ammendFlag"));
		selBookingNumber = checkForNull(booking_hdr.get("selBookingNumber"));

		String order_id=checkForNull(booking_hdr.get("orderid"));
		String old_order_id=checkForNull(booking_hdr.get("orderid"));
		post_oper_dtls = (HashMap)tabData.get("post_oper_dtls");
		String  strMultipleOperYN = (post_oper_dtls.size()>1)?"Y":"N";
		String strOperationCode =(String) post_oper_dtls.get("1").get("oper_code");
		String order_type_code=BillingUtil.getOrderTypeCode(""+booking_hdr.get("speciality_code"));		
		String login_facility_id = list.get(2);
		prop.put("strMultipleOperYN",strMultipleOperYN);
		prop.put("strOperationCode",strOperationCode);
		prop.put("login_facility_id",login_facility_id);

		transaction_flag = deleteExistingOrders(conn);
		
		if(!transaction_flag)
		{
			conn.rollback();
			map.put("flag", "0");
			map.put("result", "false");
			map.put("msgid", strErrMsg);
			return map;
		}
		transaction_flag = insertBookingHdr(conn);
		
		if(!transaction_flag)
		{
			conn.rollback();
			map.put("flag","0");
			map.put("result", "false" ) ;
			map.put("msgid", strErrMsg) ;
			return map;
		}
		//DETAIL INSERTION
	if(transaction_flag)
	{
			transaction_flag = insertBookingOperationDtls(conn);			
			if(!transaction_flag)
			{
				conn.rollback();
				map.put("flag","0");
				map.put("result", "false" ) ;
				map.put("msgid", "APP-OT0082") ;
				return map;
			}
	}

	//IF BOTH HEADER AND DETAIL INSERTION IS SUCCESS THEN COMMITS THE TRANSACTION OTHER WISE ROLLBACK
	//START BILLING PART RAJESH
	//ORDER-ID CREATION IF ORDER-IS NULL AND PASS THIS ORDER ID FOR ORDER LINE CREATION.

		if((ammendBooking != null && selOrderIds != null && ammendBooking.equals("Y") && selOrderIds.trim().length() > 0) || order_id.equals(""))
		{
			((HashMap)tabData.get("booking_hdr")).put("order_type_code",order_type_code);
			String retVal=createBackOrder(tabData,conn);
			order_id=(retVal.split("#")[0].equals("S"))?retVal.split("#")[1]:retVal.split("#")[0];
			
			((HashMap)tabData.get("booking_hdr")).put("orderid",order_id);
		}
		
		if("E".equals(order_id))
		{
				map.put("flag","0");
				map.put("result", "false") ;
				map.put("msgid", "APP-OT0128" ) ;
				return map;
		}


	//PUSHING ORDER_ID, ORDER_TYPE_CODE AND ORDER_LINE NUM INTO OPERATION MAP  IF CALLED FROM OT_MENU
	if(old_order_id.equals(""))
		pushOrderDtls(post_oper_dtls,conn);

	//OPERATION BILLING LOGIC STARTS
	//OPERATIONBILLINGMANAGER BILL_MNGR = NEW OPERATIONBILLINGMANAGER();
		if( transaction_flag)
		{
			transaction_flag = BookingBillingManager.intializeBookingBillingManager(tabData).processBilling(conn);
			
			if (!transaction_flag)
			{
			  conn.rollback();
			  String err_msg = ErrorQueue.getErrorMsg();
			  map.put("flag","0");
			 map.put("result", "false" ) ;
			 map.put("msgid", err_msg) ;
			 return map;
		  }
	  }

//OVER ALL COMMITING INCLUDING BILLING.. IF ANY 1 PROCEDURE FAILS IT HS TO ROLLBACK ALL PROCEDURES
	if(transaction_flag) 
	{
		transaction_flag = deletePendingRecs(conn);
	}		
	if(transaction_flag) 
	{
		conn.commit();
		map.put("flag","1$$"+strBookingNum);
		map.put("result", "true" ) ;
		map.put("msgid", "RECORD_INSERTED" ) ;
	}
	else
	{
		conn.rollback();
		map.put("flag","0");
		map.put("result", "false" ) ;
		map.put("msgid", "TRANSACTION FAILED") ;
	}
	}
	catch(Exception e)
	{
		System.err.println("BookingManagerEJB(OT) Exception Message From Line 151-->"+e.getMessage());
		e.printStackTrace();
		map.put("flag","0");
		map.put("result", "false" ) ;
		map.put("msgid", e.toString() ) ;
	}finally{
		try{
			booking_hdr = null;
			post_oper_dtls = null;
			prop = null;
		if(conn != null)
		ConnectionManager.returnConnection(conn,prop);//Changed on 02/07/13 against UAT5 - Connection Issue
			ErrorQueue.remove();
		}catch(Exception es){es.printStackTrace();}
	}
	return map;
}

//HEADER INSERTION METHOD
private boolean insertBookingHdr(Connection conn)
{
	CallableStatement cstmt = null;
	String strStatus="";
	String strErrorMsg="";
	String strLangErrorMsg = "";
	String strCollectSplty=booking_hdr.get("specilaity_collect").replaceAll(",","#");
	String strDuration=getDuration(booking_hdr.get("duration"),conn);
	String strPatientClass=checkForNull(booking_hdr.get("patient_class"));
	String over_booking_case_yn=(String) checkForNull(booking_hdr.get("over_booking_case_yn"),"N");
	String strEpisodeType=(!"".equals(strPatientClass))?booking_hdr.get("episode_type"):"";;
	String strVisitId=booking_hdr.get("visitid");
	//MMS-QH-CRF-186
	if(selOrderIds.equals("") || selOrderIds==null){
		strOrderId = booking_hdr.get("orderid");
	}else{
		strOrderId = "";
	}
	//MMS-QH-CRF-186
	if("".equals(strPatientClass))
	{
		strPatientClass=booking_hdr.get("episode_type");
		String episode_type_sql  = "SELECT EPISODE_TYPE FROM MP_EPISODE_TYPE_VW WHERE PATIENT_CLASS ?";
		strEpisodeType=getEpisodeType(strPatientClass,episode_type_sql,conn);
	}
	else
	{
		strEpisodeType=booking_hdr.get("episode_type");
	}

	try
	{
		cstmt=conn.prepareCall("{ call OT_UPDATE_BOOKING_DTLS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		cstmt.setString(1,prop.getProperty("login_facility_id"));
		cstmt.setString(2,booking_hdr.get("patient_id"));
		cstmt.setString(3,booking_hdr.get("episode_id"));
		cstmt.setString(4,booking_hdr.get("encounter_id"));
		cstmt.setString(5,strPatientClass);
		cstmt.setString(6,strEpisodeType);
		cstmt.setString(7,strVisitId);
		cstmt.setString(8,booking_hdr.get("SPECIALITY_CODE"));
		cstmt.setString(9,strOrderId);
		cstmt.setString(10,booking_hdr.get("pref_date"));
		cstmt.setString(11,booking_hdr.get("booking_date"));
		cstmt.setString(12,booking_hdr.get("start_time"));
		cstmt.registerOutParameter(13,Types.VARCHAR);
		cstmt.setString(14,("Y".equals(over_booking_case_yn))?"OVERBOOK":strDuration);// The Param UNIT_OF_TIME is considered for Over Booked Cases. Changed against CRF-21
		cstmt.setString(15,booking_hdr.get("roomCode"));
		cstmt.setString(16,booking_hdr.get("selSurgeonCode")); // 051911
		cstmt.setString(17,booking_hdr.get("natureType"));
		cstmt.setString(18,booking_hdr.get("natureCode"));
		cstmt.setString(19,booking_hdr.get("sourceType"));
		cstmt.setString(20,booking_hdr.get("sourceDesc"));
		cstmt.setString(21,booking_hdr.get("Anaesthetia_code"));
		cstmt.setString(22,booking_hdr.get("Anaesthetiest_code"));
		cstmt.setString(23,booking_hdr.get("Patient_position"));
		cstmt.setString(24,booking_hdr.get("REMARKS"));
		cstmt.registerOutParameter(25,Types.VARCHAR);
		cstmt.setString(26,"B");
		cstmt.setString(27,"");
		cstmt.registerOutParameter(28,Types.VARCHAR);
		cstmt.registerOutParameter(29,Types.VARCHAR);
		cstmt.setString(30,prop.getProperty("login_user"));
		cstmt.setString(31,prop.getProperty("client_ip_address"));
		cstmt.setString(32,(strOrderId.length()>0)?booking_hdr.get("waitlistyn"):"");
		cstmt.setString(33,"");
		cstmt.setString(34,booking_hdr.get("waitlistno"));
		cstmt.setString(35,"");
		cstmt.setString(36,"");
		cstmt.setString(37,booking_hdr.get("pre_oper_diag"));
		cstmt.setString(38,"");
		cstmt.setString(39,prop.getProperty("strOperationCode"));
		cstmt.setString(40, prop.getProperty("strMultipleOperYN"));
		cstmt.setString(41,strCollectSplty);
		cstmt.setString(42,"");
		cstmt.setString(43,"");
		cstmt.setString(44,"");
		cstmt.setString(45,booking_hdr.get("asst_surgeon_code"));
		cstmt.registerOutParameter(46,Types.VARCHAR);
		cstmt.executeQuery();
		strBookingNum	=	cstmt.getString(25);
		strStatus=checkForNull(cstmt.getString(28));
		strErrorMsg=checkForNull(cstmt.getString(29));
		strLangErrorMsg=checkForNull(cstmt.getString(46));
		
		if("E".equals(strStatus))
		{
			strErrMsg=(!"".equals(strLangErrorMsg))?strLangErrorMsg:strErrorMsg;
			return false;
		}
	}
	catch(Exception e)
	{
			 System.err.println("BookingManagerEJB(OT) Exception From EJB: Method: insertBookingHdr  "+e);
			 e.printStackTrace(System.err);
			//try{	conn.rollback();}catch(Exception ee1){}
			return false;
	}
	finally
	{
		  try
		  {
				if(cstmt!=null) cstmt.close();
		  }
		  catch(Exception ee)
		  {
			  ee.printStackTrace();
		  }
	}
	return true;
}

//DETAIL INSERTION METHOD
private boolean insertBookingOperationDtls(Connection conn)
{
	String fpp_category;//Added Against ML-MMOH-CRF-1939-US3
	String remarks="";
	String oper_code="";
	String side_applicable="";
	String strDuration="";
	String order_line_num="";
	String login_user =  prop.getProperty("login_user");
	String client_ip_address =  prop.getProperty("client_ip_address");
	String login_facility_id =  prop.getProperty("login_facility_id");
	PreparedStatement pstmt=null;
	int i=0;
	String sql="INSERT INTO OT_BOOKING_DTLS(OPERATING_FACILITY_ID,LINE_NUM,OPER_CODE,APPL_RIGHT_LEFT_FLAG,OPER_DURN,OPER_REMARKS,ORDER_ID,ORDER_TYPE_CODE,ORDER_LINE_NUM,ADDED_BY_ID,MODIFIED_BY_ID,ADDED_DATE,MODIFIED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,BOOKING_NUM,FPP_CATEGORY)VALUES(?,?,?,?,TO_DATE(?,'hh24:mi'),?,?,?,?,?,?,SYSDATE,SYSDATE,?,?,?,?,?,?)";
	HashMap <String,String> temp_map = new HashMap <String,String>();
	try{
		//Connection conn = ConnectionDispenser.getConnection();
		pstmt=conn.prepareCall(sql);
		for(i=1;i<=post_oper_dtls.size();i++)
		{
			temp_map=(HashMap)post_oper_dtls.get(""+i);
			order_line_num=checkForNull(temp_map.get("order_line_num"));
			//System.err.println("398, ==insertBooking==>"+order_line_num);
			oper_code=temp_map.get("oper_code");
			//System.err.println("400, ==insertBooking==>"+oper_code);
			side_applicable=temp_map.get("appl_right_left_flag");
			strDuration=temp_map.get("duration");
			remarks=temp_map.get("remarks");
			fpp_category = checkForNull(temp_map.get("fpp_category"));//Added Against ML-MMOH-CRF-1939-US3
			System.err.println("inside manager fpp=======>>>>"+fpp_category);
			remarks=java.net.URLDecoder.decode(remarks,"UTF-8");
			order_line_num=("".equals(order_line_num))?""+i:order_line_num;
			//System.err.println("405, ==insertBooking==>"+order_line_num);
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,order_line_num);
			pstmt.setString(3,oper_code);
			pstmt.setString(4,side_applicable);
			pstmt.setString(5,strDuration);
			pstmt.setString(6,remarks);
			pstmt.setString(7,strOrderId);
			pstmt.setString(8,getOrderType(oper_code,conn));
			pstmt.setString(9,order_line_num);
			pstmt.setString(10, login_user);
			pstmt.setString(11, login_user);
			pstmt.setString(12, client_ip_address);
			pstmt.setString(13,login_facility_id);
			pstmt.setString(14, client_ip_address);
			pstmt.setString(15,login_facility_id);
			pstmt.setString(16,strBookingNum);
			pstmt.setString(17,fpp_category);//Added Against ML-MMOH-CRF-1939-US3
			pstmt.execute();
			pstmt.clearParameters();
		}
	}
	catch(Exception ee)
	{
		 System.err.println("429, BookingManagerEJB(OT) Exception From EJB: Method: insertBookingOperationDtls  "+ee);
		 ee.printStackTrace(System.err);
		strErrMsg=""+ee;
		return false;
	}
	finally
	{
		try
		{
			if(pstmt !=null) 	pstmt.close();
			if(temp_map!=null) temp_map=null;
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}
	return true;
}


//HELPER METHODS
private void getOrderDetails(HashMap tabData)
{
	Connection conn = null;
	ResultSet rs=null;
	PreparedStatement pstmt=null;
	String SQL="SELECT b.oper_code oper_code1,a.order_type_code order_type_code1,a.order_line_num order_line_num1 FROM OR_ORDER_LINE a, ot_oper_mast b  WHERE order_id=? and  a.order_catalog_code=b.order_catalog_code order by order_line_num";
	try	{
			prop		 = (Properties)tabData.get( "properties" );
			conn=ConnectionManager.getConnection(prop);
			pstmt=conn.prepareCall(SQL);
			pstmt.setString(1,strOrderId);
			rs=pstmt.executeQuery();
			while(rs.next())	{
				orderlinemap.put(rs.getString("oper_code1"),rs.getString("order_type_code1")+"#"+rs.getString("order_line_num1"));
			}
			if(rs!=null) rs.close();
			if(pstmt!=null)pstmt.close();
	}catch(Exception ee){
		ee.printStackTrace(System.err);
		System.err.println("469, BookingManagerEJB(OT) Exception From EJB: Method: getOrderDetails  "+ee);
	}finally{
		try{
			if(rs !=null)	rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn != null)
			ConnectionManager.returnConnection(conn,prop);//Changed on 02/07/13 against UAT5 - Connection Issue
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

private String getDuration(String strDuration,Connection conn)  {
	//Connection conn = null;
	PreparedStatement pstmt=null;
	ResultSet rs1=null;
	try	{
		String sql="select to_char(to_Date('"+strDuration+"','HH24:MI'),'dd/mm/yyyy HH24:MI') from dual";
		//conn = ConnectionDispenser.getConnection();
		pstmt=conn.prepareCall(sql);
		rs1= pstmt.executeQuery();
		if(rs1.next()){
			strDuration=rs1.getString(1);
		}
	}catch(Exception e1){
		e1.printStackTrace(System.err);
		 System.err.println("BookingManagerEJB(OT) Exception From EJB: Method:getDuration  "+e1);
	}finally{
		try{
			if(rs1 !=null)	rs1.close();
			if(pstmt!=null) pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	return strDuration;
}

private String getOrderType(String oper_code,Connection conn){
	//Connection conn = null;
	PreparedStatement pstmt=null;
	ResultSet rs1=null;
	String order_type_code="";
	try	{
		String sql="SELECT ORDER_TYPE_CODE FROM OR_ORDER_CATALOG WHERE ORDER_CATALOG_CODE = (SELECT ORDER_CATALOG_CODE FROM OT_OPER_MAST WHERE OPER_CODE=?)";
		//conn = ConnectionDispenser.getConnection();
		pstmt=conn.prepareCall(sql);
		pstmt.setString(1,oper_code);
		rs1= pstmt.executeQuery();
		if(rs1.next()){
			order_type_code=rs1.getString(1);
		}
	}catch(Exception e1){
		e1.printStackTrace(System.err);
		 System.err.println("BookingManagerEJB(OT) Exception From EJB: Method: getOrderType  "+e1);
	}finally{
		try{
			if(rs1 !=null)	rs1.close();
			if(pstmt!=null) pstmt.close();
		}catch(Exception e){e.printStackTrace();}
	}
	return order_type_code;
}

private void pushOrderDtls(HashMap oper_map, Connection conn)
{
	PreparedStatement pstmt = null;
	ResultSet resultSet     = null;
	String order_line_num	= "";
	//HashMap map = new HashMap(); //Commented Against AAKH-ICN-0008
	try
	{
		pstmt			= conn.prepareStatement("SELECT ORDER_ID,ORDER_LINE_NUM,ORDER_TYPE_CODE FROM OT_BOOKING_DTLS WHERE BOOKING_NUM = ? AND OPERATING_FACILITY_ID = ? ORDER BY ORDER_ID, ORDER_LINE_NUM");//KDAH-SCF-0520
		int index=1;
		pstmt.setString(1,strBookingNum);
		pstmt.setString(2, prop.getProperty("login_facility_id"));//KDAH-SCF-0520
		resultSet		= pstmt.executeQuery();
		while(resultSet.next())
		{
			HashMap Tmap = new HashMap();
			Tmap=(HashMap)oper_map.get(""+index);
			order_line_num  = resultSet.getString("ORDER_LINE_NUM");
			Tmap.put("order_id",resultSet.getString("ORDER_ID"));
			Tmap.put("order_type_code",resultSet.getString("ORDER_TYPE_CODE"));
			Tmap.put("order_line_num",resultSet.getString("ORDER_LINE_NUM"));
			oper_map.put(""+index,Tmap);
			index++;
		}
	}
	catch ( Exception e ) 
	{
		e.printStackTrace();
	}
	finally 
	{
		try
		{
			if(pstmt!=null)     pstmt.close();
			if(resultSet!=null) resultSet.close();
		}
		catch(Exception es)
		{
			es.printStackTrace();
		}
	}
}

	private String getEpisodeType(String patient_class,String sql_ot_common_qry_select1,Connection conn) 
	{
		//Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet     = null;
		String result			= "";
		try{
			// conn = ConnectionDispenser.getConnection();
			 pstmt			= conn.prepareStatement("SELECT EPISODE_TYPE EPISODE_TYPE1 FROM MP_EPISODE_TYPE_VW WHERE PATIENT_CLASS = ?");
			pstmt.setString(1,patient_class);
			resultSet		= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				result  = resultSet.getString("EPISODE_TYPE1");
			}
		}catch ( Exception e ) {
			e.printStackTrace(System.err);
          System.err.println("BookingManagerEJB(OT) Exception From EJB: Method: getEpisodeType  "+e);
		}finally {
            try{
				  resultSet.close();
				  pstmt.close();
             }catch(Exception es){es.printStackTrace();}
        }
		return result;
	}

private String checkForNull(String str,String repl){
	repl=(repl!=null)?repl:"";
	return (  str!=null && str.intern()!="null" )?str.trim():repl;
}

private String checkForNull(String str){
	return (  str!=null && str.intern()!="null" )?str.trim():"";
}

private String createBackOrder(HashMap tabData,Connection conn)
{
	prop		 = (Properties)tabData.get( "properties" );	
	HashMap<String,String> booking_hdr = (HashMap)tabData.get("booking_hdr");
	ArrayList<String> audit_flds = (ArrayList)tabData.get("mandatory_flds");	
	String login_at_ws_no	 = (String)audit_flds.get(1);	//login_at_ws_no
	String login_facility_id = (String)audit_flds.get(2);	//login_facility_id
	String order_id="";
	String status="";
	String result="";
	String err_txt="";
	String login_user_id  = audit_flds.get(0);

	CallableStatement cstmt= null;
	try
	{
		cstmt=conn.prepareCall("{call OT_BACK_ORDER_CREATION(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		cstmt.setString(1,login_facility_id);//Ordering Facility
		cstmt.setString(2,strBookingNum);//Booking Num Globally Declared variable
		cstmt.setString(3,null);//Oper_Num passing directly
		//cstmt.setString(4,booking_hdr.get("surgeonCode"));//Operating Practitioner
		cstmt.setString(4,booking_hdr.get("selSurgeonCode"));//Operating Practitioner
		cstmt.setString(5,"B");//Booking CheckIn Flag
		cstmt.setString(6,booking_hdr.get("sourceType"));//Source Type
		cstmt.setString(7,booking_hdr.get("sourceDesc"));//Source Code
		cstmt.setString(8,login_user_id); //Login User Id
		cstmt.setString(9,login_at_ws_no); // WorkStation Id  /* newly added below three parameters on 17-04-2009 by sathish instructed by Dilip Kumar*/
		cstmt.setString(10,booking_hdr.get("surgeonCode"));
		//cstmt.setString(10,booking_hdr.get("selSurgeonCode")); // for testing 
		cstmt.setString(11,booking_hdr.get("booking_date"));
		cstmt.setString(12,booking_hdr.get("natureCode"));
		cstmt.setString(13,booking_hdr.get("anaes_review1"));
		cstmt.setString(14,booking_hdr.get("Anaesthetia_code"));
		cstmt.registerOutParameter(15,Types.VARCHAR);
		cstmt.registerOutParameter(16,Types.VARCHAR);
		cstmt.registerOutParameter(17,Types.VARCHAR);
		//System.err.println("650,surgeonCode===OT_BACK_ORDER_CREATION===="+booking_hdr.get("surgeonCode"));
		//System.err.println("651,selSurgeonCode===OT_BACK_ORDER_CREATION===="+booking_hdr.get("selSurgeonCode"));
		//System.err.println("652,login_user_id===OT_BACK_ORDER_CREATION===="+login_user_id);
		cstmt.execute();
		order_id = 	checkForNull(cstmt.getString(15));
		status = 	checkForNull(cstmt.getString(16));
		err_txt = 	checkForNull(cstmt.getString(17));
		if(status.equals("S"))
		{
			result="S#"+order_id;
		}
		else
		{
			result="E#"+err_txt;
		}
		cstmt.close();
	}
	catch (Exception e) 
	{
		e.printStackTrace();
	}
	finally 
	{
		try
		{
			if(cstmt!=null) 
				cstmt.close();
		}
		catch(Exception es)
		{
			es.printStackTrace();
		}
	}
	System.err.println("=====result===in createBackOrder======BookingManager========"+result);
	return result;
}

	private boolean deletePendingRecs(Connection conn)
	{
		PreparedStatement pstmt = null;
		//int i = 0;//Commented Against AAKH-ICN-0008
		//186
		selOrderIds=selOrderIds.replaceAll(",","','");
		System.err.println("ejb file  :"+selOrderIds);
		//186
		String sql = "DELETE FROM ot_pending_order where order_id IN ('" + selOrderIds + "') ";
		//HashMap <String,String> temp_map = new HashMap <String,String>(); //Commented Against AAKH-ICN-0008
		try
		{
			pstmt = conn.prepareCall(sql);//MMS-QH-CRF-186
			//pstmt = new JDBCStatementLogger(conn, sql);//MMS-QH-CRF-186
			//JDBCStatementLogger.logQueryStringDetails("deletePendingRecs","BookingManager", pstmt);
			pstmt.execute();//MMS-QH-CRF-186
		}
		catch(Exception ee)
		{
			System.err.println(" BookingManagerEJB(OT) Exception From EJB: Method: deletePendingRecs" + ee);
			ee.printStackTrace();
			return false;	
		}
		finally
		{
			try
			{
				if(pstmt !=null) 	pstmt.close();
			}
			catch(Exception ee)
			{
				ee.printStackTrace();
			}
		}
		return true;
	}

	private boolean deleteExistingOrders(Connection conn)
	{
		StringBuffer pendingOrderDetailsBuffer = new StringBuffer();
		String sql1 = "";
		String strHour, strMin;
		String strDuration = "";
		int hour = 0, min = 0;
		String strStatus = "";
		String strErrorMsg = "";
		String strErrMsg = "";
		String langstrMessage = "";
		String[] selOrderIdsArray = null;
		//String strCancel = "";	//Commented Against AAKH-ICN-0008
		String strCancelOrder = "true";
		String err_code = "";
		String err_text = "";
		String lang_err_msg_id = "";
		String sys_message_id = "";
		String err_desc = "";
		String selOrderId = "";
		String login_user =  prop.getProperty("login_user");
		String client_ip_address =  prop.getProperty("client_ip_address");
		String login_facility_id =  prop.getProperty("login_facility_id");

	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	CallableStatement cstmt = null;
	CallableStatement cstmt1 = null;
	ResultSet rs = null;
	ResultSet rs1 = null;
	try
	{
		cstmt = conn.prepareCall("{ call OT_UPDATE_BOOKING_DTLS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		cstmt1 = conn.prepareCall("{ call OT_CAN_OPER_CHARGES (?,?,?,?,?,?,?,?)}");
		/*System.err.println("deleteExistingOrders==OT_UPDATE_BOOKING_DTLS===================");
		System.err.println("=ammendFlag=====deleteExistingOrders====="+ammendFlag);
		System.err.println("=strBookingNum==deleteExistingOrders====="+strBookingNum);
		System.err.println("=strCancel======deleteExistingOrders====="+strCancel);
		System.err.println("=strOrderId=====deleteExistingOrders====="+strOrderId);*/
		if(ammendFlag != null && ammendFlag.equals("Y") && selBookingNumber.length() > 0)// && strCancel.equals("true"))
		{
	try{				
		//System.err.println("766, Booked Order id :"+booking_hdr.get("orderid")+"\n Selected Order Id :"+selOrderIds);
		updateCAStatus(conn,selOrderIds,login_facility_id,login_user,client_ip_address);
		}catch(Exception ee){
			
			ee.printStackTrace();
		}
		
		selOrderId = booking_hdr.get("orderid");
		cstmt.setString(1, prop.getProperty("login_facility_id"));
		cstmt.setString(2, "");
		cstmt.setString(3, "");
		cstmt.setString(4, "");
		cstmt.setString(5, "");
		cstmt.setString(6, "");
		cstmt.setString(7, "");
		cstmt.setString(8, "");
		if(strCancelOrder.equals("true") && selOrderId.length() > 0)
		{
			cstmt.setString(9, selOrderId);
			cstmt.setString(27, "CO");
		}
		else
		{
			cstmt.setString(9, "");
			cstmt.setString(27, "");
		}
		cstmt.setString(10, "");
		cstmt.setString(11, "");
		cstmt.setString(12, "");
		cstmt.registerOutParameter(13, Types.VARCHAR);
		cstmt.setString(14, "");
		cstmt.setString(15, "");
		cstmt.setString(16, "");
		cstmt.setString(17, "");
		cstmt.setString(18, "");
		cstmt.setString(19, "");
		cstmt.setString(20, "");
		cstmt.setString(21, "");
		cstmt.setString(22, "");
		cstmt.setString(23, "");
		cstmt.setString(24, "");
		cstmt.setString(25, selBookingNumber);
		cstmt.setString(26, "C");
		cstmt.registerOutParameter(28, Types.VARCHAR);
		cstmt.registerOutParameter(29, Types.VARCHAR);
		cstmt.setString(30, prop.getProperty("login_user"));
		cstmt.setString(31, prop.getProperty("client_ip_address"));
		cstmt.setString(32, "");
		cstmt.setString(33, "");
		cstmt.setString(34, "");
		cstmt.setString(35, "ABCR"); // Code used for internal reference AMCR --> Amend Booking Cancel Reason
		cstmt.setString(36, "Orders Amended"); 
		cstmt.setString(37, "");
		cstmt.setString(38, prop.getProperty("login_user"));
		cstmt.setString(39, "");
		cstmt.setString(40, "");
		cstmt.setString(41, "");
		cstmt.setString(42, "N");// Informed Ward YN
		cstmt.setString(43, "");// Ward Informed Date and Time
		cstmt.setString(44, "");// Cancelled Remarks
		cstmt.setString(45, "");// Cancelled Remarks
		cstmt.setString(47, "N");
		cstmt.registerOutParameter(46, Types.VARCHAR);
		cstmt.executeQuery();
		strStatus = cstmt.getString(28);
		strErrorMsg = cstmt.getString(29);
		if(strStatus.equalsIgnoreCase("E") == true) 
		{
			strErrMsg = strErrorMsg;
			return false;
		}

	if(strStatus.equalsIgnoreCase("S") == true) 
	{
		if (strCancelOrder.equals("true")) 
		{
			// Below Code For Cancel Billing record when cancelling the order(cancel check box in cancel appointment screen is checked only).
			cstmt1.setString(1, prop.getProperty("login_facility_id"));
			cstmt1.setString(2, selBookingNumber);
			cstmt1.setString(3, prop.getProperty("login_user"));
			cstmt1.setString(4, prop.getProperty("client_ip_address"));
			cstmt1.registerOutParameter(5, Types.VARCHAR);
			cstmt1.registerOutParameter(6, Types.VARCHAR);
			cstmt1.registerOutParameter(7, Types.VARCHAR);
			cstmt1.registerOutParameter(8, Types.VARCHAR);
			cstmt1.executeQuery();
			err_code = CommonBean.checkForNull(cstmt1.getString(5));
			err_text = CommonBean.checkForNull(cstmt1.getString(6));
			lang_err_msg_id = CommonBean.checkForNull(cstmt1.getString(7));
			sys_message_id = CommonBean.checkForNull(cstmt1.getString(8));
			String SQL2 = "SELECT NVL(MESSAGE_TEXT,MESSAGE_TEXT_SYSDEF) FROM SM_MESSAGE WHERE MESSAGE_ID = ?";
			try 
			{
				pstmt1 = conn.prepareStatement(SQL2);
				pstmt1.setString(1, sys_message_id);
				rs1 = pstmt1.executeQuery();
				while (rs1.next())
				{
					err_desc = CommonBean.checkForNull(rs1.getString(1));
				}
			}
			catch (Exception e)
			{
				System.err.println("Err Mesg in getMessage Function"+ e);
				e.printStackTrace();
			}
			finally
			{
				try
				{
					if (rs1 != null) rs1.close();
					if (pstmt1 != null) pstmt1.close();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			if(("").equals(err_desc))
			{
				err_desc += err_text;
			}
			if(err_desc.equals(""))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return true;
		}
	}
	}
	if(selOrderIds.length() > 0)// && selBookingNumber.length() == 0) 
	{
		selOrderId = "";
	if(selOrderIds != null && selOrderIds.trim().length() > 0)
	{			
		selOrderIdsArray = selOrderIds.split(",");				
		//MMS-QH-CRF-186			
		try{
			System.err.println("913 :"+login_user+"client_ip_address :"+client_ip_address+"login_facility_id:"+login_facility_id+"selOrderIds :"+selOrderIds);
			updateCAStatus(conn,selOrderIds,login_facility_id,login_user,client_ip_address);
			
		}catch(Exception einternal){				
			einternal.printStackTrace();
		}					
		
		pendingOrderDetailsBuffer.append("	SELECT performing_facility_id performing_facility_id1,	");
		pendingOrderDetailsBuffer.append("	nature_type nature_type1, order_id order_id1, order_type_code order_type_code1,	");
		pendingOrderDetailsBuffer.append("	TO_CHAR (pref_surg_date, 'dd/mm/yyyy') pref_surg_date1,	");
		pendingOrderDetailsBuffer.append("	team_doctor_ind team_doctor_ind1, performing_team_surgeon performing_team_surgeon1,	");
		pendingOrderDetailsBuffer.append("	patient_id patient_id1, admission_date admission_date1,	");
		pendingOrderDetailsBuffer.append("	discharge_date discharge_date1, episode_id episode_id1,	");
		pendingOrderDetailsBuffer.append("	patient_class patient_class1, encounter_id encounter_id1,	");
		pendingOrderDetailsBuffer.append("	episode_type episode_type1, visit_id visit_id1,	");
		pendingOrderDetailsBuffer.append("	surgery_nature surgery_nature1, speciality_code speciality_code1,	");
		pendingOrderDetailsBuffer.append("	ref_source_type ref_source_type1, ref_source_code ref_source_code1,	");
		pendingOrderDetailsBuffer.append("	anaesthesia_code anaesthesia_code1, anaesthetist_code anaesthetist_code1,	");
		pendingOrderDetailsBuffer.append("	patient_position patient_position1 FROM ot_pending_orders_vw	");
		pendingOrderDetailsBuffer.append("	WHERE order_id = ?	");
		System.err.println("pendingorderdetailsbuffer: "+pendingOrderDetailsBuffer);					
		
		//MMS-QH-CRF-186 end
	for(int i=0; i<selOrderIdsArray.length; i++)
	{
		selOrderId = selOrderIdsArray[i];
		sql1 = "SELECT SUM(TO_NUMBER(TO_CHAR(OPER_DURN,'hh24'))) HOUR1,SUM(TO_NUMBER(TO_CHAR(OPER_DURN,'mi'))) MIN1 FROM OT_PENDING_ORDERS_DTL_VW  where order_id=?";
		System.err.println("940,sql1==>"+sql1);
		try
		{
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, selOrderId);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				hour = Integer.parseInt(rs.getString("HOUR1"));
				min = Integer.parseInt(rs.getString("MIN1"));
			}
			rs.close();
			pstmt.close();
		}
		catch (Exception ee)
		{
			ee.printStackTrace();
		}
		finally
		{
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
		}

		hour += min / 60;
		min %= 60;
		strHour = "";
		strMin = "";

		if (hour < 10)
			strHour = "0" + hour;
		else
			strHour += hour;
		if (min < 10)
			strMin = "0" + min;
		else
			strMin = "" + min;

		strDuration = "01/03/05 " + strHour + ":" + strMin;
		
		//MMS-QH-CRF-186
		pstmt = conn.prepareStatement(pendingOrderDetailsBuffer.toString());
		System.err.println("selOrderId : "+selOrderId);
		pstmt.setString(1, selOrderId);
		rs = pstmt.executeQuery();
						//HashMap headerDtl = new HashMap(); //Commented Against AAKH-ICN-0008
		if(rs.next() == true)
		{
			cstmt.setString(1, prop.getProperty("login_facility_id"));
			cstmt.setString(2, CommonBean.checkForNull(rs.getString("PATIENT_ID1")));
			cstmt.setString(3, CommonBean.checkForNull(rs.getString("EPISODE_ID1")));
			cstmt.setString(4, CommonBean.checkForNull(rs.getString("ENCOUNTER_ID1")));
			cstmt.setString(5, CommonBean.checkForNull(rs.getString("PATIENT_CLASS1")));
			cstmt.setString(6, CommonBean.checkForNull(rs.getString("EPISODE_TYPE1")));
			cstmt.setString(7, CommonBean.checkForNull(rs.getString("VISIT_ID1")));
			cstmt.setString(8, CommonBean.checkForNull(rs.getString("SPECIALITY_CODE1")));
			cstmt.setString(9, CommonBean.checkForNull(rs.getString("ORDER_ID1")));
			cstmt.setString(10, CommonBean.checkForNull(rs.getString("PREF_SURG_DATE1")));
			cstmt.setString(11, "");
			cstmt.setString(12, "");
			cstmt.registerOutParameter(13, Types.VARCHAR);
			cstmt.setString(14, strDuration);
			cstmt.setString(15, "");
			cstmt.setString(16, CommonBean.checkForNull(rs.getString("PERFORMING_TEAM_SURGEON1")));
			cstmt.setString(17, CommonBean.checkForNull(rs.getString("NATURE_TYPE1")));
			cstmt.setString(18, CommonBean.checkForNull(rs.getString("SURGERY_NATURE1")));
			cstmt.setString(19, CommonBean.checkForNull(rs.getString("REF_SOURCE_CODE1")));
			cstmt.setString(20, CommonBean.checkForNull(rs.getString("REF_SOURCE_TYPE1")));
			cstmt.setString(21, CommonBean.checkForNull(rs.getString("ANAESTHESIA_CODE1")));
			cstmt.setString(22, CommonBean.checkForNull(rs.getString("ANAESTHETIST_CODE1")));
			cstmt.setString(23, CommonBean.checkForNull(rs.getString("PATIENT_POSITION1")));
			cstmt.setString(24, "");
			cstmt.registerOutParameter(25, Types.VARCHAR);
			cstmt.setString(26, "W");
			cstmt.setString(27, "");
			cstmt.registerOutParameter(28, Types.VARCHAR);
			cstmt.registerOutParameter(29, Types.VARCHAR);
			cstmt.setString(30, prop.getProperty("login_user"));
			cstmt.setString(31, prop.getProperty("client_ip_address"));
			if (selOrderId.length() > 0)
				cstmt.setString(32, "Y");
			else
				cstmt.setString(32, "");
			cstmt.setString(33, "");
			cstmt.setString(34, "");
			cstmt.setString(35, "");
			cstmt.setString(36, "");
			cstmt.setString(37, "");
			cstmt.setString(38, "");
			cstmt.setString(39, "");
			cstmt.setString(40, "");
			cstmt.setString(41, "");
			cstmt.setString(42, "");
			cstmt.setString(43, "");
			cstmt.setString(44, "");
			cstmt.setString(45, "");
			cstmt.setString(47, "N");
			cstmt.registerOutParameter(46, Types.VARCHAR);
			cstmt.executeQuery();
			strStatus = cstmt.getString(28);
			strErrorMsg = cstmt.getString(29);
			langstrMessage = cstmt.getString(46);
			if (strStatus.equalsIgnoreCase("E") == true) 
			{
				strErrMsg = strErrorMsg;
				return false;
			}
		}
		if(pstmt !=null) pstmt.close(); //Common-ICN-0053
		if(rs !=null) rs.close(); //Common-ICN-0054
		}
		if(strErrMsg!= null && strErrMsg.trim().length() > 0)
			return false;
		else
			return true;
		}
	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		try
		{
			if(pstmt !=null) pstmt.close();
			if(pstmt1 !=null) pstmt1.close();
			if(cstmt !=null) cstmt.close();
			if(cstmt1 !=null) cstmt1.close();
			if(rs !=null) rs.close();
			if(rs1 !=null) rs1.close();
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}
	return true;
}

private boolean updateCAStatus(Connection conn,String Order_Id,String Facility_Id,String P_UserName,String P_WS_No){
	boolean flag=false;
		CallableStatement cstmt = null;
	try{
			String[] selOrderIdsArrays = Order_Id.split(",");
			System.out.println("came in UpdateCAStatus");
			System.out.println("came in UpdateCAStatus Order_Id :"+Order_Id);
			System.out.println("came in UpdateCAStatus Facility_Id"+Facility_Id);
			System.out.println("came in UpdateCAStatus P_UserName : "+P_UserName);
			System.out.println("came in UpdateCAStatus P_WS_No "+P_WS_No);
			

			cstmt = conn.prepareCall("{  call or_ot_cancel_pending_order (?,?,?,?,?,?,?)}");
			for(int i=0;i<selOrderIdsArrays.length;i++){
				cstmt.setString(1, selOrderIdsArrays[i]);System.out.println(i+"="+selOrderIdsArrays[i]);
				cstmt.setString(2, Facility_Id);
				cstmt.setString(3, P_UserName);
				cstmt.setString(4, P_WS_No);
				cstmt.registerOutParameter(5, Types.VARCHAR);
				cstmt.registerOutParameter(6, Types.VARCHAR);
				cstmt.registerOutParameter(7, Types.VARCHAR);
				cstmt.executeQuery();
				
			}
			/*cstmt.setString(1, Order_Id);
			cstmt.setString(2, Facility_Id);
			cstmt.setString(3, P_UserName);
			cstmt.setString(4, P_WS_No);
			cstmt.registerOutParameter(5, Types.VARCHAR);
			cstmt.registerOutParameter(6, Types.VARCHAR);
			cstmt.registerOutParameter(7, Types.VARCHAR);
			cstmt.executeQuery();*/


			/*String p_err_code 	= cstmt.getString(5);
			String p_sys_message_id   = cstmt.getString(6);
			String p_error_text   = cstmt.getString(7);
			*/
			String p_err_code 	= cstmt.getString(5);
			String p_sys_message_id   = cstmt.getString(6);
			String p_error_text   = cstmt.getString(7);
			
			System.out.println("p_err_code UpdateCAStatus :"+p_err_code);
			System.out.println("p_sys_message_id UpdateCAStatus : "+p_sys_message_id);
			System.out.println("p_error_text UpdateCAStatus : "+p_error_text);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally //Added Against AAKH-ICN-0008
		{
			  try
			  {
					if(cstmt!=null) cstmt.close();
			  }
			  catch(Exception e)
			  {
				  e.printStackTrace();
			  }
		}
		return flag;	
		
	}
}//end of EJB