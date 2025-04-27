<!DOCTYPE html>
 <!--
Fine Tuning
-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body  onKeyDown="lockKey()" topmargin="0" onMouseDown = 'CodeArrest()' >

<%
	String bean_id				= "DrugMasterBean" ;
	String bean_name			= "ePH.DrugMasterBean";
	DrugMasterBean bean			= (DrugMasterBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	String generic				=	request.getParameter("external_generic");
	String from					=	request.getParameter("from");
	String to					=	request.getParameter("to");
	ArrayList drugs				= bean.getExternalDrugs(generic);
	String drug_code			=	"";
	String drug_desc			=	"";
	String classValue			=	"";
	int start					= 0 ;
	int end						= 0 ;
	int maxRecord				=	drugs.size() / 2;
	if ( from == null || from.equals(""))
		start = 1 ;
	else
		start = Integer.parseInt( from  ) ;

	if ( to == null || to.equals(""))
		end =14;
	else
		end = Integer.parseInt( to ) ;

%>

<form name="ExternalDrugSearchForm" id="ExternalDrugSearchForm" >
<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../ePH/jsp/DrugMasterExternalDrugSearchResult.jsp?from="+(start-14)+"&to="+(end-14)+"&external_generic="+generic+"' text-decoration='none'>Prev</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../ePH/jsp/DrugMasterExternalDrugSearchResult.jsp?from="+(start+14)+"&to="+(end+14)+"&external_generic="+generic+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>

<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
<tr><th align="left"><fmt:message key="ePH.DrugName/Route/Form/Strength.label" bundle="${ph_labels}"/></th></tr>
<%	int	j	=0;
	for(int i=0; i<drugs.size(); i+=2)	{	
		
		if(j%2==0)
			classValue	=	"QRYEVEN";
		else
			classValue	=	"QRYODD";

	drug_code		=	(String)drugs.get(i);
	drug_desc		=	(String)drugs.get(i+1);
	
	%>
<tr>
	<td align="left" class="<%=classValue%>"><label style="cursor:pointer;color:blue" onClick="window.returnValue='<%=drug_code%>'; window.close()"><%=drug_desc%></label></td>
</tr>
<%	j++;
		}	%>
</table>
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
</form>
</body>
</html>

<%
putObjectInBean(bean_id,bean,request);
%>

