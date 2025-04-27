<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.CommonBean"%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");	
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends 
%>

<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eOT/js/AT_RecordAnesthesiaDetails.js"></script>
	<script language="JavaScript" src="../../eOT/js/AT_RecordIntraAnesthesia.js"></script>
	<script>
		function reset(){
		var formObj=parent.parent.frames[2].document.forms[0];
		if(formObj.weight.disabled==false ||formObj.height.disabled==false||formObj.bsa.disabled==false||formObj.bmi.disabled==false){
			formObj.weight.value="";
			formObj.height.value="";
			formObj.bsa.value="";
			formObj.bmi.value="";
			formObj.anaesthesia_desc.value="";
			formObj.start_date.value="";
			formObj.start_time.value="";
			formObj.finish_date.value="";
			formObj.finish_time.value="";
			if(parent.parent.frames[5].document.forms[0].remarks_tab.value=="personal_details"){
				parent.parent.frames[5].frames[0].document.forms[0].pract_type.value="";
				parent.parent.frames[5].frames[0].document.forms[0].practitioner_name.value="";
			}
			 if (parent.parent.frames[8].document.forms[0].intraop_done.checked==true){
				 parent.parent.frames[8].document.forms[0].intraop_done.checked=false;
				}
			}
		}
	</script>
<%
	String source="";
	String title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,
	"eOT.IntraAnaesthesia.Label","ot_labels")+",";
	String param=request.getQueryString();
	String facility_id				=request.getParameter("facility_id");
	String anesthesia_srl_no		=request.getParameter("anesthesia_srl_no");
	String intraop_done_yn="",source_order_id = "";
	Connection connection   = null ;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try{
		  String sql_preop= "SELECT INTRAOP_DONE_YN INTRAOP_DONE_YN1, SOURCE_ORDER_ID FROM AT_ANAESTHESIA_RECORD_HDR where OPERATING_FACILITY_ID =?  AND ANAESTHESIA_SERIAL_NUM=?";
		  connection	= ConnectionManager.getConnection(request);
		  pstmt=connection.prepareStatement(sql_preop);
		  pstmt.setString(1,facility_id);
		  pstmt.setString(2,anesthesia_srl_no); 
		  rs=pstmt.executeQuery();
		  if(rs.next())
		  {
			intraop_done_yn=CommonBean.checkForNull(rs.getString("INTRAOP_DONE_YN1"));
			source_order_id=CommonBean.checkForNull(rs.getString("SOURCE_ORDER_ID"));
		  }
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

	param=param+"&intraop_done_yn="+intraop_done_yn;

	if(intraop_done_yn.equals("Y")){	source="../../eCommon/jsp/commonToolbar.jsp?module_id=AT&function_type=F&menu_id=AT_JAVA_DFLT&access=NNNNY&home_required_yn=N";
	}else if(intraop_done_yn.equals("N") || intraop_done_yn.equals("")) {
	source="../../eCommon/jsp/commonToolbar.jsp?module_id=AT&function_type=F&menu_id=AT_JAVA_DFLT&access=NYNNY&home_required_yn=N";
	}
	param=param+"&source_order_id="+source_order_id;

%>

<TITLE><%=title%></TITLE>
 <frameset rows='3%,10%,35%,4%,*,0%,0%,10%,10%'> 

	<frame name="commontoolbarFrame" frameborder="0" src="<%= source %>" noresize scrolling='no'>
	<frame name="OtPatientLineFrame" frameborder="0" src="../../eOT/jsp/OTPatLineFrame.jsp?<%=param%>" noresize scrolling='auto'>
	<frame name='intra_anesth_header_frame' src="../../eOT/jsp/AT_IntraAnaesHeader.jsp?<%=param%>" frameborder="0" nowrap noresize scrolling='no' >
	<frameset rows='0,*'>
		<frame name='Intra_anesthesia_objectcollect_frame' src='../../eOT/jsp/AT_IntraAnaesObjectCollect.jsp?<%=param%>' frameborder="0" nowrap noresize scrolling='no' >
		<frame name='Intra_anesth_header_tabs_frame' 	src="../../eOT/jsp/AT_IntraAnaesTabs.jsp?<%=param%>" frameborder="0" nowrap noresize scrolling='no' >
	</frameset>
	<frame name='intra_anesth_tab_details_frame'	 src='../../eOT/jsp/AT_IntraAnaesTabFrames.jsp?<%=param%>' frameborder="0" nowrap noresize scrolling='auto' > 
	<frame name='dummy_frame' src='../../eCommon/html/blank.html' frameborder="0" nowrap noresize >
	<frame name='dummy_frames' src='../../eCommon/html/blank.html' frameborder="0" nowrap noresize > 
	<frame name='intra_doc_status_frame' src='../../eOT/jsp/AT_IntraAnaesDocStatus.jsp?<%=param%>' nowrap noresize  > 
	<frame name='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder="0" nowrap noresize scrolling='no'>
</frameset>
</html>




