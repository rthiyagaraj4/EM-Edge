<!DOCTYPE html>
<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,eCommon.XSSRequestWrapper,webbeans.eCommon.ConnectionManager,eOT.ChkInOutRecoveryBean" %>
<html>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@include file="../../eOT/jsp/StringUtil.jsp" %>
<%@page  contentType="text/html;charset=UTF-8" %>


<title>	<fmt:message key="eOT.RecordPostAnaesthesiaDetails.Label" bundle="${ot_labels}"/>
</title>
<form name="OTCheckinForm" >
<head>
<%  
    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eOT/js/AT_PostAnaesthesia.js"></script>
	<script language="javascript" src="../../eOT/js/OTCommon.js"></script>
	<script>


	function reset(){
		var formObj=parent.parent.frames[2].document.forms[0];
		var postop_done_yn=document.forms[0].postop_done_yn.value;
		if(formObj.weight.disabled==false ||formObj.height.disabled==false||formObj.bsa.disabled==false||formObj.bmi.disabled==false){
			if(postop_done_yn!="Y"){
				formObj.weight.value="";
				formObj.height.value="";
				formObj.bsa.value="";
				formObj.bmi.value="";
				parent.parent.frames[3].document.forms[0].finish_date.value="";
				parent.parent.frames[3].document.forms[0].finish_time.value="";
				parent.parent.frames[3].document.forms[0].rec_start_date.value="";
				parent.parent.frames[3].document.forms[0].rec_start_time.value="";
				parent.parent.frames[3].document.forms[0].rec_finish_date.value="";
				parent.parent.frames[3].document.forms[0].rec_finish_time.value="";
				if(parent.parent.frames[6].frames[1].name=="untowards_evt_record_frame"){
				parent.parent.frames[6].frames[1].document.forms[0].unusual_occur_desc.value="";
				}else if(parent.parent.frames[6].frames[1].name="personal_record_frame"){
					parent.parent.frames[6].frames[0].document.forms[0].pract_type.value="";
					parent.parent.frames[6].frames[0].document.forms[0].practitioner_name.value="";			
				}
				if(parent.parent.frames[7].document.forms[0].checkAnaes.checked==true){
					parent.parent.frames[7].document.forms[0].checkAnaes.checked=false;
				}
		      }
			}
		}
		
	</script>


</head>

<%
	String facility_id  = (String) session.getValue("facility_id");
	String login_user = (String) session.getValue("login_user");
	String params = request.getQueryString();
	String bean_id = "ChkInOutRecoveryBean";
	String bean_name = "eOT.ChkInOutRecoveryBean";
	ChkInOutRecoveryBean bean = (ChkInOutRecoveryBean) mh.getBeanObject(bean_id, request, bean_name );
	bean.clear();
	params = params+"&module_id=OT&function_id=11&function_name=Record Post Anaesthesia Details&function_type=F&menu_id=OT_JAVA_DFLT&access=NYNNY&home_required_yn=N&facility_id="+facility_id+"&anesthesia_flag=POST"+"&slate_user_id="+login_user;
	String anesthesia_srl_no		=request.getParameter("anesthesia_srl_no");
	String postop_done_yn="";
	String source_order_id = "";
	Connection connection   = null ;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try{
		  String sql_postop= "SELECT POSTOP_DONE_YN POSTOP_DONE_YN1,SOURCE_ORDER_ID FROM AT_ANAESTHESIA_RECORD_HDR where OPERATING_FACILITY_ID =?  AND ANAESTHESIA_SERIAL_NUM=?";
		  connection	= ConnectionManager.getConnection(request);
		  pstmt=connection.prepareStatement(sql_postop);
		  pstmt.setString(1,facility_id);
		  pstmt.setString(2,anesthesia_srl_no); 
		  rs=pstmt.executeQuery();
		  if(rs.next())
		  {
			postop_done_yn=checkForNull(rs.getString("POSTOP_DONE_YN1"));
			source_order_id=checkForNull(rs.getString("SOURCE_ORDER_ID"));
		  }
	%>
	<input type='hidden' name='postop_done_yn' value='<%=postop_done_yn%>' >
<%
	}catch(Exception ee){
		System.err.println("Exception=="+ee);
	}
	finally{
		try{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(connection!=null) ConnectionManager.returnConnection(connection,request);
             }catch(Exception es){es.printStackTrace();}
	}
	String source ="";
	if(postop_done_yn.equals("Y")){	source="../../eCommon/jsp/commonToolbar.jsp?module_id=AT&function_type=F&menu_id=AT_JAVA_DFLT&access=NNNNY&home_required_yn=N";
	}else if(postop_done_yn.equals("N") || postop_done_yn.equals("")) {
	source="../../eCommon/jsp/commonToolbar.jsp?module_id=AT&function_type=F&menu_id=AT_JAVA_DFLT&access=NYNNY&home_required_yn=N";
	}
	params = params+"&postop_done_yn="+postop_done_yn+"&source_order_id="+source_order_id;
%>

<!-- <FRAMESET rows="30,22%,19%,4%,*,38,0,0" border='0'> -->
	<FRAMESET rows="4%,10%,20%,23%,4%,*,8%,8%,0,0" border='0'>
    <frame name="commontoolbarFrame" frameborder="0" scrolling='no' noresize="no" src="<%=source%>" >
	<frame name='OtPatientLineFrame' SRC='../../eOT/jsp/OTPatLineFrame.jsp?<%=params%>' scrolling='no' noresize>
	<frame name='AnaesthesiaHdrFrame' SRC='../../eOT/jsp/AT_CommonAnaesthesiaHdr.jsp?<%=params%>' scrolling='no' noresize></frame>
	<FRAME NAME='AnaesthesiaDetailsFrame' SRC='../../eCommon/html/blank.html'  scrolling='no' noresize='no'>
<FRAMESET ROWS = "0%,*" >
	<FRAME NAME='ObjectCollect' SRC='../../eOT/jsp/AT_PostAnaesthesiaObjectCollect.jsp?<%=params%>'  scrolling='no' 	noresize='no'></FRAME>
	<FRAME NAME='tab_frame' SRC='../../eOT/jsp/AT_PostAnaesthesiaTab.jsp?<%=params%>'  scrolling='no' 
	noresize='no'></FRAME> 
</FRAMESET>
	<FRAME NAME='ResultFrame' SRC='../../eCommon/html/blank.html?<%=params%>'  scrolling='no' noresize='no'></FRAME> 
	<frame name='post_anaes_doc_status_frame' src="../../eOT/jsp/AT_PostAnaesDocStatus.jsp?<%=params%>" frameborder="0" noresize >
	<frame name="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto"></frame>
	<frame name="dummy_frames" src='../../eCommon/html/blank.html' frameborder="0" noresize scrolling="no">
	<frame name="dummy_frame" src='../../eCommon/html/blank.html' frameborder="0" noresize scrolling="no">

</FRAMESET>
<body  onKeyDown = 'lockKey();'>

	<input type='hidden' name='params' value='<%=params%>' >
</form>
</body>
</html>
