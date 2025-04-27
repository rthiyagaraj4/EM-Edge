<!DOCTYPE html>
<%@ page import=" ePO.*, ePO.Common.* , eCommon.Common.*,  java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head> 
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
		
		//java.util.Locale loc = new java.util.Locale(locale);
		//java.util.ResourceBundle PO_labels = java.util.ResourceBundle.getBundle( "ePO.resources.Labels",loc);
	
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../ePO/js/PoCommon.js"></script>
	<script language="JavaScript" src="../../ePO/js/TermsAndConditions.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	    <script>
        function_id = "<%= request.getParameter("function_id") %>"
		menu_id		= "<%= request.getParameter("menu_id") %>"
		module_id	= "<%= request.getParameter("module_id") %>"
    </script>
</head>
<%
	String mode	= request.getParameter( "mode" ) ;
	String bean_id = "TermsAndConditionsBean" ;
	String bean_name = "ePO.TermsAndConditionsBean";
	String codeDisabled =	"";
	String checked	= "";
	String disable = "";
	TermsAndConditionsBean bean = (TermsAndConditionsBean)getBeanObject( bean_id, bean_name, request );
	bean.setLanguageId(locale);
		bean.clear() ;
	
	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))) )
		return ;
		ServletContext context = getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
	bean.setMode( mode ) ;

	if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
		codeDisabled = "disabled";
		bean.setTermsAndCond_Code(request.getParameter("termsAndCond_code")) ;

		bean.loadData() ;
		if(bean.getStatus().equals("E"))
		{
			checked		= "CHECKED";
		}
		else
		{
			checked		=	"";
			disable		=	"disabled";
		}

	
	}

%>
<body onload='FocusFirstElement();'>

	<form name="TermsAndConditionsAddModifyform" id="TermsAndConditionsAddModifyform" onreset="FocusFirstElement()">
	<table border="0" cellpadding="0" cellspacing="0" width='100%'  height='100%' align=center>
	<tr>
	<td width='100%'  class="WHITE">
	<table border="0" cellpadding="1" cellspacing="0" width='75%' align=center>

	<tr>
		<td>&nbsp;</td><td>&nbsp;</td>
	</tr>
	
	<tr>
		<td  class="label"> <fmt:message key="ePO.TermsAndCondCode.label" bundle="${po_labels}"/></td> 
		<td class="fields">&nbsp;&nbsp;<input type="text"  value="<%=bean.getTermsAndCond_Code()%>" name="termsAndCond_code" size='10' maxLength='6' class='UPPER' onKeyPress="return CheckForSpecChars(event);" onBlur="checkSpecialChars(this);"  <%=codeDisabled%>> <%=bean.getImage("M")%>
			</td> 
	</tr>

	<tr>
		<td>&nbsp;</td><td>&nbsp;</td>
	</tr>
<tr>
		<td  class="label"> <fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/>	</td>
		<td class="fields">&nbsp;&nbsp;<input type="text" value="<%=bean.getShortDesc()%>" name="short_desc" size='30' maxLength='20' <%=disable%> >
		 <%=bean.getImage("M")%> 
			</td>
			
	</tr>

	<tr>
		<td>&nbsp;</td><td>&nbsp;</td>
	</tr>
	
	<tr>
		<td  class="label"> <fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
		<td class=fields>&nbsp;&nbsp;<textarea name="long_desc" rows='7' cols='70'  onKeyPress="checkMaxLimit(this,4000);" <%=disable%> ><%=bean.getLongDesc()%></textarea> <%=bean.getImage("M")%> 	</td>
			
	</tr>

	<tr>
		<td>&nbsp;</td><td>&nbsp;</td>
	</tr>

	<tr>
		<td  class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<%if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") ) ) {
%>
		<td class="fields">&nbsp;<input type="checkbox" name="status" id="status" value="E" checked>
	<%}else{
	%>
		<td class="fields">&nbsp;<input type="checkbox" name="status" id="status" <%=checked%> value="E" >
<%}%>
		</td> 
	</tr>

	<tr>
		<td>&nbsp;</td><td>&nbsp;</td>
	</tr>
	</table>
	</td>
	</tr>
	</table>
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">


	</form>
	<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

