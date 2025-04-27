<!DOCTYPE html>
<%@page import="java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.sql.CallableStatement,java.sql.Types,eCommon.XSSRequestWrapper,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>               
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<html>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eOT/js/AT_RecordAnesthesiaDetails.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
	<script>
		function reset(){
			var formObj=parent.parent.frames[2].document.forms[0];
			if(formObj.weight.disabled==false ||formObj.height.disabled==false||formObj.bsa.disabled==false||formObj.bmi.disabled==false){
			formObj.weight.value="";
			formObj.height.value="";
			formObj.bsa.value="";
			formObj.bmi.value="";
			formObj.status_desc.value="";
			// Added newly for crf-0021
			if(parent.parent.frames[8].document.forms[0].preop_asse_done.checked==false){
			formObj.stages1.value="";	
			formObj.document.getElementById('asa_score_code').innerHTML=""; 
			return;
			 }
			 else {
			  return;
			 }
			 // End crf - 0021
			if(parent.parent.frames[5].document.forms[0].remarks_tab.value=="Assessment"){
				parent.parent.frames[5].frames[1].frames[1].document.forms[0].pre_morbid_desc.value="";
				parent.parent.frames[5].frames[1].frames[1].document.forms[0].remarks.value="";
			}
	
			 if(parent.parent.frames[8].document.forms[0].preop_asse_done.checked==true){
				 parent.parent.frames[8].document.forms[0].preop_asse_done.checked=false;
			 }
		}
		}
	</script>
<%  
    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends

	request.setCharacterEncoding("UTF-8");
	String source="";
	
	String title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,
	"eOT.PreAnaesthesiaForm.Label","ot_labels");
	String param=request.getQueryString();
	java.util.Properties prop = null;
	prop	= (java.util.Properties) session.getValue( "jdbc" ) ;
	String tab_name				=request.getParameter("tab_name");
	String login_user				= prop.getProperty( "login_user" );
	String client_ip_address		= prop.getProperty( "client_ip_address" );
	String facility_id				=request.getParameter("facility_id");
	String patient_id				=request.getParameter("patient_id");
	String request_source_type		=request.getParameter("request_source_type");
	String source_id				=request.getParameter("source_id");
	String parent_source_id			=request.getParameter("parent_source_id");
	System.err.println("55,source_id======="+source_id);
	System.err.println("56,parent_source_id======="+parent_source_id);
	String anathestist_code			=request.getParameter("anathestist_code");
	String anaesthesia_srl_no1		=request.getParameter("anesthesia_srl_no");
	String source_order_id = "";
	String getOrderId="";//AAKH-SCF-0345
	String patient_class = "",encounter_id  = "",anaesthesia_srl_no="",status="",error_text="",lang_error_text="",preop_asse_done_yn="";
	if(anathestist_code==null || anathestist_code.equals("null")) anathestist_code="";
	Connection connection   = null ;
	CallableStatement cstmt= null ;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql_anaesthetist="SELECT ANAESTHETIST_CODE FROM  OT_PENDING_ORDER WHERE ORDER_ID=?";
	try{
		connection	= ConnectionManager.getConnection(request);		
		if(tab_name.equalsIgnoreCase("PendingOrders")) {	
				pstmt=connection.prepareStatement(sql_anaesthetist);
				System.err.println("70,sql_anaesthetist==="+sql_anaesthetist);
				pstmt.setString(1,parent_source_id);
				System.err.println("72,parent_source_id==="+parent_source_id);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					anathestist_code = rs.getString(1);
					System.err.println("76,anathestist_code==="+anathestist_code);
					if(anathestist_code ==null) anathestist_code="";
				}
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				cstmt=connection.prepareCall("{call At_Ins_Anaesthesia_Record(?,?,?,?,?,?,'OT','OT','P',?,?,?,?,?,?)}");
				cstmt.setString(1, facility_id);		 
				cstmt.setString(2, patient_id);
				cstmt.setString(3, request_source_type);
				cstmt.setString(4, parent_source_id);		
				cstmt.setString(5, source_id);
				cstmt.setString(6, anathestist_code);
				cstmt.setString(7, login_user);
				cstmt.setString(8, client_ip_address);
				cstmt.registerOutParameter( 9, Types.VARCHAR );
				cstmt.registerOutParameter( 10, Types.VARCHAR );
				cstmt.registerOutParameter( 11, Types.VARCHAR );
				cstmt.registerOutParameter( 12, Types.VARCHAR ); // for V_LANG_ERR_MSG_ID
				cstmt.execute() ;
				anaesthesia_srl_no = cstmt.getString(9);
				status = checkForNull(cstmt.getString(10));
				error_text = cstmt.getString(11);
				lang_error_text = cstmt.getString(12);		
				System.err.println("99,anaesthesia_srl_no==="+anaesthesia_srl_no+"==status=="+status+"==error_text=="+error_text+"==lang_error_text=="+lang_error_text);
				if(status.equalsIgnoreCase("E")){
					error_text = lang_error_text;
					out.println("<script>alert('"+error_text+"');</script>");
					out.println("<script>window.close();</script>");
					connection.rollback();
					return;
				}else	
				{
					connection.commit();
				}
					param=param+"&generated_anesthesia_srl_no="+anaesthesia_srl_no;
  }	

	  String sql_preop= "SELECT PREOP_ASSE_DONE_YN PREOP_ASSE_DONE_YN1,SOURCE_ORDER_ID FROM  AT_ANAESTHESIA_RECORD_HDR where OPERATING_FACILITY_ID =?  AND ANAESTHESIA_SERIAL_NUM=?";
	  pstmt=connection.prepareStatement(sql_preop);
	  System.err.println("116,sql_preop==="+sql_preop);
	  pstmt.setString(1,facility_id);
	  if(anaesthesia_srl_no.equals("")){
  		pstmt.setString(2,anaesthesia_srl_no1);
		System.err.println("120,anaesthesia_srl_no1==="+anaesthesia_srl_no1);
		}
	  else{
  		pstmt.setString(2,anaesthesia_srl_no);
		System.err.println("124,anaesthesia_srl_no==="+anaesthesia_srl_no);
		}
	    rs=pstmt.executeQuery();
	    while(rs.next())
	   {
		 preop_asse_done_yn=checkForNull(rs.getString("PREOP_ASSE_DONE_YN1"));
		 source_order_id = checkForNull(rs.getString("SOURCE_ORDER_ID"));
		 System.err.println("131,preop_asse_done_yn==="+preop_asse_done_yn+"==source_order_id=="+source_order_id);
	   }

	   
  	//Get the Encounter ID and Patient Class
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();

	//AAKH-SCF-0345 starts	
	//String str_query1 = "select ORDER_ID from ot_queue where PATIENT_ID = '"+patient_id+"' and rownum=1 order by added_date desc";
	
	String str_query1 = "select SOURCE_ORDER_ID from AT_ANAESTHESIA_RECORD_HDR where OPERATING_FACILITY_ID = '"+facility_id+"' and SOURCE_ORDER_ID = '"+parent_source_id+"'";

	pstmt=connection.prepareStatement(str_query1);
	System.err.println("146,str_query1======="+str_query1);
	rs = pstmt.executeQuery();

	if(rs !=null && rs.next())
	{
		getOrderId= rs.getString(1);
		System.err.println("getOrderId======="+getOrderId);
	}
	if(pstmt!=null) pstmt.close();
	if(rs!=null) rs.close(); 
			
	if(getOrderId==null || getOrderId.equals("")){//Added Newly
		String str_update="UPDATE AT_ANAESTHESIA_RECORD_HDR SET SOURCE_ORDER_ID = '"+parent_source_id+"' WHERE OPERATING_FACILITY_ID = '"+facility_id+"' and ORDER_ID = '"+source_id+"'";
		pstmt=connection.prepareStatement(str_update);
		int result=	pstmt.executeUpdate();
		
		if(result>0)
		{
			connection.commit();
		}else{
			connection.rollback();
		}
	}//Added Newly
	//AAKH-SCF-0345 End

	String sql="SELECT PATIENT_ID, PATIENT_CLASS, ENCOUNTER_ID, EPISODE_ID, SOURCE_TYPE, SOURCE_CODE, ORD_PRACT_ID ORD_PRACT_ID1,to_char(ORD_DATE_TIME,'dd/mm/yyyy') ORD_DATE_TIME1 FROM  OR_ORDER WHERE ORDER_ID=?";

	pstmt=connection.prepareStatement(sql);
	pstmt.setString(1,source_order_id);
	rs=pstmt.executeQuery();
	while(rs.next())
	{
		patient_id=checkForNull(rs.getString("PATIENT_ID"));
		patient_class=checkForNull(rs.getString("PATIENT_CLASS"));
		encounter_id=checkForNull(rs.getString("ENCOUNTER_ID"));
	}
	  // end of retreiving encounter_ID and Patient Class
    }catch(Exception ee){
	System.err.println("Exception=="+ee);
	connection.rollback();
  }
finally{
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	if(cstmt!=null) cstmt.close();
	if(connection!=null) ConnectionManager.returnConnection(connection,request);
}

	param=param+"&preop_asse_done_yn="+preop_asse_done_yn;
	if(preop_asse_done_yn.equals("Y")){	source="../../eCommon/jsp/commonToolbar.jsp?module_id=AT&function_type=F&menu_id=AT_JAVA_DFLT&access=NNNNY&home_required_yn=N";
	}else if(preop_asse_done_yn.equals("N") || preop_asse_done_yn.equals("")) {
	source="../../eCommon/jsp/commonToolbar.jsp?module_id=AT&function_type=F&menu_id=AT_JAVA_DFLT&access=NYNNY&home_required_yn=N";
	}
	param=param+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&source_order_id="+source_order_id;
%>

<TITLE><%=title%></TITLE>
 <!-- 	<frameset rows='5%,22%,5%,12,0%,0%,12%'>  -->
		<frameset rows='3%,15%,18%,6%,38%,0%,0%,10%,10%'>

	<frame name="commontoolbarFrame" frameborder="0" src="<%= source %>" nowrap noresize scrolling='no'>
	<frame name='OtPatientLineFrame' src="../../eOT/jsp/OTPatLineFrame.jsp?<%=param%>" frameborder="0" nowrap noresize scrolling='no'>
	<frame name='pre_anesth_header_frame' src="../../eOT/jsp/AT_PreAnaesHeader.jsp?<%=param%>" frameborder="0" nowrap noresize scrolling='no'>
 <frameset rows='0, *'>  
		<frame name='pre_anesthesia_objectcollect_frame' src='../../eOT/jsp/AT_PreAnaesObjectCollect.jsp?<%=param%>' frameborder="0"  nowrap noresize scrolling='no'>
		<frame name='pre_anesth_header_tabs_frame' 	src="../../eOT/jsp/AT_PreAnaesthesiaTabs.jsp?<%=param%>" frameborder="0" nowrap noresize scrolling='no' >
	</frameset>
	<frame name='pre_anesth_tab_details_frame'	 src='../../eOT/jsp/AT_PreAnaesTabFrames.jsp?<%=param%>' frameborder="0" nowrap noresize scrolling='yes' > 
	<frame name='dummy_frame' src='../../eCommon/html/blank.html' frameborder="0" nowrap noresize scrolling='no' >
	<frame name='dummy_frames' src='../../eCommon/html/blank.html' frameborder="0" nowrap noresize scrolling='no' >
	<frame name='doc_status_frame' src="../../eOT/jsp/AT_PreAnaesDocStatus.jsp?<%=param%>" frameborder="0" nowrap noresize scrolling='auto' >
	<frame name='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder="0" nowrap noresize scrolling='no' >
</frameset>
</html>
