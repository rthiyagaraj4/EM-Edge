<!DOCTYPE html>
 
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	 <link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
 	<script LANGUAGE="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
	<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
 <script language="JavaScript" src="../../ePH/js/PhDrugInfo.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
</head>
<%
	String Sysdate	="";
	ArrayList Enq_Dtl = null;
	String verified_by="";
	String replied_by="";
	String dis1="disabled";
	String dis="";
	String dis2="";
	String check="";
	String Enq_num	= request.getParameter("Enq_num") ;
	if(Enq_num==null) Enq_num="";
	String RESPONSE_DTLS="", REMARKS="", RESPONSE_DATE_TIME="", REPLIED_BY="", VERIFIED_DATE_TIME="", RESPONDE_DAYS="", RESPONSE_HOURS="", RESPONSE_MINUTES="";

	String respond_time="";
	String login_by_name= (String)session.getValue( "login_user" );
	String bean_id			= "PhDrugInfoEnqBean" ;
	String bean_name		= "ePH.PhDrugInfoEnqBean";
	
	PhDrugInfoEnqBean bean = (PhDrugInfoEnqBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	Sysdate		=bean.getSysdate();

	if(!Enq_num.equals("")){
		
		Enq_Dtl =bean.getEnquirerDetails();
	
		verified_by=(String)Enq_Dtl.get(40);
		replied_by=(String)Enq_Dtl.get(39);
		if(verified_by==null) verified_by="";
		if(replied_by==null) replied_by="";
		if(!replied_by.equals("")) {
			dis="disabled";
		}
	
		if(!verified_by.equals("")) {
			check="checked";
			dis2="disabled";
		}else{
			dis2="";
		}
		dis1="";
		
		RESPONSE_DTLS=(String)Enq_Dtl.get(36);
		REMARKS=(String)Enq_Dtl.get(37);
		RESPONSE_DATE_TIME=(String)Enq_Dtl.get(38);
		REPLIED_BY=(String)Enq_Dtl.get(39);
		VERIFIED_DATE_TIME=(String)Enq_Dtl.get(41);
		RESPONDE_DAYS =(String)Enq_Dtl.get(42);
		RESPONSE_HOURS=(String)Enq_Dtl.get(43);
		RESPONSE_MINUTES =(String)Enq_Dtl.get(44);
		
		if(RESPONSE_DTLS==null) RESPONSE_DTLS="";
		if(REMARKS==null) REMARKS="";
		if(RESPONSE_DATE_TIME==null) RESPONSE_DATE_TIME="";
		if(REPLIED_BY==null) REPLIED_BY="";
		if(VERIFIED_DATE_TIME==null) VERIFIED_DATE_TIME="";
		if(RESPONSE_HOURS==null || RESPONSE_HOURS.equals("")) RESPONSE_HOURS="0";
		if(RESPONSE_MINUTES==null || RESPONSE_MINUTES.equals("")) RESPONSE_MINUTES="0";
		if(RESPONDE_DAYS==null || RESPONDE_DAYS.equals("")) RESPONDE_DAYS="0";
		if(!REPLIED_BY.equals(""))
		login_by_name=REPLIED_BY;
				
		bean.setResp_days((int)Integer.parseInt(RESPONDE_DAYS));
		bean.setResp_minutes((int)Integer.parseInt(RESPONSE_MINUTES));
		bean.setResp_hours((int)Integer.parseInt(RESPONSE_HOURS));
		if(!RESPONDE_DAYS.equals("0") && !RESPONDE_DAYS.equals(""))
		respond_time += RESPONDE_DAYS+" Days ";
		if(!RESPONSE_HOURS.equals("0") && !RESPONSE_HOURS.equals(""))
		respond_time += RESPONSE_HOURS+" Hrs ";
		if(!RESPONSE_MINUTES.equals("0") && !RESPONSE_MINUTES.equals("") )
		respond_time += RESPONSE_MINUTES+" Mins ";

	}
%>

<!-- <body> -->
<body onMouseDown="" onKeyDown="lockKey()">
<form name='PhDrugInfoResInfoDtls1Form' id='PhDrugInfoResInfoDtls1Form'>

<TABLE cellpadding=0 cellspacing=0 width="100%"  align="center" border="0" >
			
			<TR >
				<TH colspan='4' height='15'><b><fmt:message key="ePH.RespondRemarks.label" bundle="${ph_labels}"/></b></TH>
			</TR>
			<TR>
				<TD class="label" width="100%" colspan='4'>&nbsp;<textArea name="remark"  value="" rows='3' cols='111' onkeypress= "ChkMaxLen('Remark',this,1000,'mode');" <%=dis%>><%=REMARKS%></textarea></TD>
			</TR>
			<TR>
				<TD class='label' colspan='4'>&nbsp;&nbsp;&nbsp;</TD>
			</TR>
			<TR>
				<TD class='button' colspan='1' width='25%'><input type="button"  class="button" 
				value='<fmt:message key="ePH.Respond.label" bundle="${ph_labels}"/>' 
				name='respond' onclick="showResDtl(this);"></TD>

				<TD class='label' colspan='3' width='75%' nowrap><font id='respond_dt' style='display:none'><fmt:message key="ePH.ResponseDate/Time.label" bundle="${ph_labels}"/></font>&nbsp;&nbsp;<font id='respond_txt' style='display:none' >
				<input type="text" name="response_dt" id="response_dt"  size="18"  <%=dis%> value="<%=RESPONSE_DATE_TIME%>" maxlength="16" onBlur="callFirst();"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="if(document.getElementById('response_dt').disabled==false) { return showCalendar('response_dt',null,'hh:mm'); }"onblur="document.forms[0].response_dt.focus();" >
				<img src="../../eCommon/images/mandatory.gif" ></img></font><font id='res_tt' style='display:none'>&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.ResponseTime.label" bundle="${ph_labels}"/>&nbsp;&nbsp;<b><label id='resp_tt'></label>&nbsp;&nbsp;</b></font><input type='hidden' name='respond_time' id='respond_time' value='<%=respond_time%>'></TD>	
			</TR>
			<TR id='replied_by' style="display:none">
				<TD class="label" colspan='1' nowrap width='25%'>&nbsp;&nbsp;</TD>
				<TD class="label" colspan='3' nowrap width='25%'><fmt:message key="ePH.Replied/AnsweredBy.label" bundle="${ph_labels}"/>&nbsp;&nbsp;<b><%=login_by_name%>&nbsp;&nbsp;</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <fmt:message key="ePH.DoYouWanttoVerify.label" bundle="${ph_labels}"/>&nbsp;&nbsp;<input type='checkbox' name='verify' id='verify' onclick='callVerify(this);' value='N' <%=check%> <%=dis1%> <%=dis2%>></TD>
			</TR>
			<TR>
				<TD class='label' colspan='4'>&nbsp;&nbsp;&nbsp;</TD>
			</TR>
</TABLE>

<INPUT TYPE="hidden" name="sysdate1" id="sysdate1" VALUE="<%=Sysdate%>">

</form>
<script>

if(document.forms[0].response_dt !=null && document.forms[0].response_dt.value!="" ){
	document.getElementById("respond_dt").style.display='inline';
	document.getElementById("respond_txt").style.display='inline';
	document.getElementById("replied_by").style.display='inline';
	document.getElementById("res_tt").style.display='inline';
	document.forms[0].respond.style.display='none';
	document.getElementById("resp_tt").innerText=document.forms[0].respond_time.value;
}else{
document.forms[0].verify.disabled=true;
}
</script>
</body>
<% putObjectInBean(bean_id,bean,request); %>
</html>

