<!DOCTYPE html>


<%-- JSP Page specific attributes start --%>   
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*, java.text.*,ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>    
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<%  
	try{
%>
<html> 
<head>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="Javascript" src="../../ePH/js/OncologyRegimen.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String mfr_remarks		=	request.getParameter("mfr_remarks")==null?"":request.getParameter("mfr_remarks");

String bean_id = request.getParameter("bean_id")==null?"":request.getParameter("bean_id"); 
String bean_name = request.getParameter("bean_name")==null?"":request.getParameter("bean_id"); 
String drug_code = request.getParameter("drug_code")==null?"":request.getParameter("drug_code");
String ocurrance_num = request.getParameter("ocurrance_num")==null?"":request.getParameter("ocurrance_num"); 

OncologyRegimenBean bean	= (OncologyRegimenBean)getBeanObject(bean_id, bean_name,request) ;

if(mfr_remarks.equals("null"))mfr_remarks="";

System.err.println("mfr_remarks==34=>"+mfr_remarks);
            mfr_remarks = bean.getMFRRemarkForDrug()==null?"":bean.getMFRRemarkForDrug();
System.err.println("mfr_remarks==36=>"+mfr_remarks);
   if(!mfr_remarks.equals(""))
	{
			mfr_remarks=mfr_remarks.replaceAll(" ","%20"); 
			mfr_remarks = java.net.URLEncoder.encode(mfr_remarks,"UTF-8"); 
			mfr_remarks=mfr_remarks.replaceAll("%2520","%20");
	} 

   
String mfr_yn			=	request.getParameter("mfr_yn")==null?"Y":request.getParameter("mfr_yn");
String read_property	=	request.getParameter("read_property")==null?"":request.getParameter("read_property");
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<%if(mfr_yn.equals("Y")){%>
<title><fmt:message key="ePH.MFRRemarks.label" bundle="${ph_labels}"/></title>
<%}else{%>
<title><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></title>
<%}%>
</head>
<body>
<form name="ongoIVPrescriptionMFRRemarks" id="ongoIVPrescriptionMFRRemarks">
<table cellpadding="0" cellspacing="0" width="97%" align="center" border="0">
<tr><td><textarea rows="8" cols="47" name="mfr_remarks" onKeyPress="return(checkMaxLimit(this,255));" onBlur="callCheckMaxLen(this,255,' Remarks ')" <%=read_property%>></textarea></td>
</tr>
<tr><td align="center">
<input type="button" class="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>'
onclick="savedetails('<%=bean_id%>','<%=bean_name%>','<%=drug_code%>','<%=ocurrance_num%>');">&nbsp;&nbsp;</td></tr>
</table>
<script>
	var mfr_rem = decodeURIComponent('<%=mfr_remarks%>'); //CRF-673.2-inc#51648 on 10/10/2014
	document.ongoIVPrescriptionMFRRemarks.mfr_remarks.value=mfr_rem; //CRF-673.2-inc#51648 on 10/10/2014
</script>

</form>
</body>
</html>
<%}
catch(Exception e)
{
	System.err.println("Exception thrown in OncologyRegimenMFRRemarks.jsp Page..") ;
	e.printStackTrace();
}%>

