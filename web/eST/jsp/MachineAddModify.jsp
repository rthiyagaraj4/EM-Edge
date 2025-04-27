<%--This JSP is called when a user clicks on Create Button -->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import=" eST.*, eST.Common.* , eCommon.Common.*, java.text.*, java.util.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
<!-- 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
 --><%
 		 request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!-- 	<script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<!-- 	<script language="javascript" src="../../eST/js/StMessages.js"></script>
 -->	<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eST/js/Machine.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
textarea {
  resize: none;
}
</style>
</head>
<body onLoad="FocusFirstElement()">
<%
	String mode;
	String bean_id;
	String bean_name;
	String codeDisabled =	"";
	String disabled		=	"";
	String rdonly		=	"";
	String eff_chked_during_insert=	"checked";

	/* Mandatory checks start */
	mode	= request.getParameter( "mode" ) ;
	bean_id = "machineBean" ;
	bean_name = "eST.MachineBean";
	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))) )
		return ;
	/* Mandatory checks end */

	/* Initialize Function specific start */
	MachineBean bean = (MachineBean)getBeanObject( bean_id,bean_name,request ) ;
	bean.setLanguageId(locale);
	bean.clear() ;
	ServletContext context = getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);

	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	/* Initialize Function specific end */

	if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
		eff_chked_during_insert="";
		codeDisabled = "disabled";

		bean.setMachine_code(request.getParameter("machine_code")) ;
		bean.loadData() ;

		if(bean.getEff_status().equals("D"))
		{
			disabled = "disabled" ;
			rdonly="readonly";
		}
	}
%>
<form name="formMachine" id="formMachine" onreset="FocusFirstElement()">
	<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' height='100%'>
	<tr>
	<td width='100%' align='center' class="WHITE">
	<table border="0" cellpadding="1" cellspacing="0" width='75%' align='center'>

	<tr>
		<td>&nbsp;</td><td>&nbsp;</td>
	</tr>
	<tr>
		<td class="label"><fmt:message key="eST.MachineCode.label" bundle="${st_labels}"/></td>
		<td class="label">&nbsp;&nbsp;<input type="text" value="<%=bean.getMachine_code()%>" name="machine_code" size='10' maxLength='10' class='UPPER' onKeyPress="return CheckForSpecChars(event);" onBlur="checkSpecialChars(this);"  <%=codeDisabled%>><%=bean.getImage("M")%>
			</td>
	</tr>

	<tr>
		<td>&nbsp;</td><td>&nbsp;</td>
	</tr>
	<tr>
		<td class="label"><fmt:message key="Common.MachineName.label" bundle="${common_labels}"/></td>
		<td class="label">&nbsp;&nbsp;<input type="text" value="<%=bean.getMachine_name()%>" name="machine_name" size='60' maxLength='60' onBlur="makeValidString(this);" <%=disabled%>><%=bean.getImage("M")%>
			</td>
	</tr>

	<tr>
		<td>&nbsp;</td><td>&nbsp;</td>
	</tr>
	<tr>
		<td class="label"><fmt:message key="eST.ModelNo.label" bundle="${st_labels}"/></td>
		<td class="label">&nbsp;&nbsp;<input type="text" value="<%=bean.getModel_no()%>" name="model_no" size='20' maxLength='20' onBlur="makeValidString(this);" <%=disabled%>><%=bean.getImage("M")%>
			</td>
	</tr>

	<tr>
		<td>&nbsp;</td><td>&nbsp;</td>
	</tr>
	<tr>
		<td class="label"><fmt:message key="Common.Manufacturer.label" bundle="${common_labels}"/></td>
		<td class="label">&nbsp;&nbsp;<select name="manufacturer_id" id="manufacturer_id" <%=disabled%>>
							<%=bean.getManufacturer_List()%>
							</select>
			</td>
	</tr>

	<tr>
		<td>&nbsp;</td><td>&nbsp;</td>
	</tr>
	<tr>
		<td class="label" nowrap><a href='javascript:callTextBox();'><fmt:message key="eST.TechnicalSpecification.label" bundle="${st_labels}"/></a><input type="hidden" name='technical_specification' id='technical_specification' value="<%=bean.checkForNull(bean.getTechnical_specification())%>"  ></td>
		<td>&nbsp;&nbsp;<textarea rows=4 cols=50 name='technical_specification_textarea' id='technical_specification_textarea' <%=rdonly%>><%=bean.checkForNull(bean.getTechnical_specification())%></textarea></td>
	</tr>
	<tr>
		<td>&nbsp;</td><td>&nbsp;</td>
	</tr>
	<tr>
		<td class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<td class="label">&nbsp;<input type="checkbox" value="E" name="eff_status" id="eff_status"  <%=eff_chked_during_insert%><%=bean.getChecked(bean.getEff_status())%>>
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
	<input type="hidden" name="disabled123" id="disabled123" value="<%=disabled%>">

</form>
<%
putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

