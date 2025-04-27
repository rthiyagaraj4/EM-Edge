<!DOCTYPE html>
 <%-- saved on 27/10/2005 --%>
<%-- JSP Page specific attributes start --%>

<%@ page contentType="text/html;charset=UTF-8"  import="ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,eCommon.XSSRequestWrapper" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
	
<% 
    request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
	<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<script language="JavaScript" src="../js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
	<SCRIPT>
		function_id = "<%= request.getParameter( "function_id" ) %>"
	</SCRIPT>
</HEAD>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">

<%
	/* Mandatory checks start */
	String mode	= request.getParameter( "mode" ) ;
	String bean_id = "UomForFormBean" ;
	String bean_name = "ePH.UomForFormBean";
	
	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
	/* Mandatory checks end */

	/* Initialize Function specific start */
	UomForFormBean bean = (UomForFormBean)getBeanObject(bean_id,bean_name ,request) ;
	bean.clear() ;
	bean.setMode( mode ) ;
	 bean.setLanguageId(locale);
	/* Initialize Function specific end */


	/* Variable Declarations start */
	ArrayList	formOfDrug	=	null;
	String code			=	"";
	String value		=	"";
	/* Variable Declartions end*/
	
	/* Load values for Form of Drug start*/
	formOfDrug	=	bean.loadFormofDrug(locale);
	/* Load values for Form of Drug end*/


%>

<form name="formUomForForm" id="formUomForForm" >
<table cellpadding="0" cellspacing="0" width="90%" align="center" border="0">
	<tr>	
		<td class="label"><fmt:message key="ePH.FormofDrug.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>
		<td >
			<select name="formOfDrug" id="formOfDrug"  onChange="parent.callApplicableUom()">
			<option>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
			<% for(int i=0; i<formOfDrug.size(); i+=2)
				{ 
					int j= i;
					code	=	(String)formOfDrug.get(i);
					value	=	(String)formOfDrug.get(++j);
			%>
			<option value="<%=code%>"><%=value%></option>
			<%

				}
				
            putObjectInBean(bean_id,bean,request);

			%>
			</select>
		</td>
	</tr>
	
</table>
</body>
</HTML>

