<!DOCTYPE html>
<%
//"java.util.*, eOT.*, eOT.Common.*, eCommon.Common.*"
%>


<html>
<head>
	<%@ page import="eOT.WardChkOutBean" contentType="text/html;charset=UTF-8" %> 
	<%@ include file="../../eCommon/jsp/Common.jsp" %> 
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
	<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	request.setCharacterEncoding("UTF-8");
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<body>
<%
	String params		= request.getQueryString() ;
	String surgery_date	= request.getParameter("surgery_date");
	String nursing_unit	= request.getParameter("nursing_unit");
	String patient_id	= request.getParameter("patient_id");
	String view_by		= request.getParameter("view_by");
	String bookings_type= request.getParameter("bookings_type");
	String current_ip_ward_yn= request.getParameter("current_ip_ward_yn");
	String bean_id		= "WardChkOutBean";
	String bean_name	= "eOT.WardChkOutBean";
	String appt_yn ="";
	if(view_by.equals("A"))
		appt_yn = "";
	else if(view_by.equals("S"))
		appt_yn = "Y";
	else if(view_by.equals("U"))
		appt_yn = "N";
//BLEnterServiceRequestBean ServPanlBean			= (BLEnterServiceRequestBean)getBeanObject( str_or_bean_id, "eBL.BLEnterServiceRequestBean", request ) ;
	WardChkOutBean bean	= (WardChkOutBean) mh.getBeanObject( bean_id, request, bean_name );
	bean.clear();
	boolean ward_dtls_flag = false;
	String header_flag = "";
	if(bookings_type.equals("S")){
		ward_dtls_flag = bean.loadSurgeryBkgWardChkOutDtls(surgery_date,nursing_unit,patient_id,appt_yn,current_ip_ward_yn);
		header_flag="SURGERY_WARD_CHECK_OUT";
	}else if(bookings_type.equals("R")){
		ward_dtls_flag = bean.loadRadiologyBkgWardChkOutDtls(surgery_date,nursing_unit,patient_id);
		header_flag = "RADIOLOGY_WARD_CHECK_OUT";
	}
%>
	<!-- <div id="WardChkOutResultsFrame" > -->
			<%
			if(ward_dtls_flag==true){
			//System.out.println("ward_dtls_flag1: " + ward_dtls_flag) ;
			%>
				<%-- <iframe name="f_header_frame" id="f_header_frame" scrolling="no" noresize src="../../eOT/jsp/CommonResultsHeader.jsp?<%=params+"&header_flag="+header_flag%>" ></iframe>  --%>
			<%
				if(bookings_type.equals("S")){ // OT checklist
			%>
					<iframe name="f_ward_chk_out_frame" id="f_ward_chk_out_frame" style="height:90vh; width: 100vw;" frameborder="0" scrolling="yes" noresize src="../../eOT/jsp/WardChkOutOTResults.jsp?<%=params%>"></iframe>
			<%
				}else{
			%>
					<iframe name="f_ward_chk_out_frame" id="f_ward_chk_out_frame" style="height:90vh; width: 100vw;" frameborder="0" scrolling="yes" noresize src="../../eOT/jsp/WardChkOutRDResults.jsp?<%=params%>"></iframe>		
			<%
				}
			}else{
			%>
				<iframe name="f_header_frame" id="f_header_frame" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" > </iframe>
				<iframe name="f_ward_chk_out_frame" id="f_ward_chk_out_frame" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" ></iframe> 
		<%}%>
	<!-- </div> -->
	<%
		if(ward_dtls_flag==false){
	%>
	<script language="javascript">
		alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
		//enableSearchCriteria();
	</script>
	<%
		}
	%>
</body>
</html>
	
