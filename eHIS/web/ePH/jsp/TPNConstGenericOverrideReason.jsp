<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
  request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
  response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
  response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
  //ends
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
     <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	 <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	 <script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	 <script language="JavaScript" src="../../ePH/js/TPNNonStdRegimen.js"></script>
	 <script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!-- 	 <script language="JavaScript" src="../../ePH/js/PhMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	 -->
<%
    String	bean_id				= "TPNNonStandardRegimenBean" ;
	String	bean_name			= "ePH.TPNNonStandardRegimenBean";
	TPNNonStandardRegimenBean bean		= (TPNNonStandardRegimenBean)getBeanObject( bean_id, bean_name, request);
	
	//String override=request.getParameter("override");
	String row_no		= request.getParameter("rowno");
	String name         =request.getParameter("name");
	String group        =request.getParameter("group");
	String res          =request.getParameter("alert");
	String remarks		="";
	String remarks1		="";
	String readOnly		="";
	   
	String mode					= request.getParameter("mode");
	if(mode ==  null) {mode = "";}
	String tpn_override_reason  = request.getParameter("tpn_override_reason");
	if(mode.equals("dispensing")){
		remarks1	=	tpn_override_reason; 
		readOnly	=	"readonly";
	}else{
		//remarks1=(String)bean.getOverriddenReason(group,row_no); 
		remarks1=request.getParameter("reason");
	}
 if(remarks1==null)
	remarks1="";
	
		
	%>
<title><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.OverrideReason.label","ph_labels")%></title>
     
</head>


<body style="background-color:#E2E3F0;" OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">

<form name="TpnConsGenericOvrrideReason" id="TpnConsGenericOvrrideReason" >
<table width='100%' border='0' cellspacing='0' cellpadding='0' align='center'>
	<tr>
		<td align='left' class='label' width='10%'></td>
	</tr>
	<tr>
		<td align='left' width='90%' class='label'>&nbsp;&nbsp;<textarea name="tpncons_remarks" rows="5" cols="60" onBlur="makeValidString(this)" <%=readOnly%> ><%=remarks1%></textarea>&nbsp;<IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"  ID=""></td>
		
	</tr>
	<% if(res!=null){%>
	<tr>
	<td class='label'>
			<center><%=res%></center>
		</TD>
		<tr>&nbsp;</tr>
		<% }%>
		<TR>
	    
		<td class='label'>
			<center><input type='Button' width='10%' align='right' class='Button' name='Ok' id='Ok' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onclick="saveRemarksForDrug('<%=group%>','<%=row_no%>');doAmendClose(this);">
			<input type='Button' width='10%' align='left' class='Button' name='Cancel' id='Cancel' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onclick="window.close();"></center>
		</TD>
		
			
		</TR>
</table>
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="row_no" id="row_no" value="<%=row_no%>">

</body>

</html>
	
<% 
 //remarks.setLength(0);
//putObjectInBean(bean_id,bean,request);
%>

