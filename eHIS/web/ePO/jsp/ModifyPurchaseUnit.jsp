<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, ePO.*, ePO.Common.* , eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
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
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/PoCommon.js"></script>
	<script language="JavaScript" src="../js/PurchaseUnit.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onLoad="FocusFirstElement()" >

<%
	/* Mandatory checks start */
	String disabled				=	"" ;
	String mode					=	request.getParameter( "mode" );
	String bean_id				=	"purchaseUnitBean";
	String bean_name			=	"ePO.PurchaseUnitBean";
	String store_code			=	"";	

	if ( mode == null || mode.equals("") ) 
		return;
	if ( !(mode.equals((String) CommonRepository.getCommonKeyValue( "MODE_MODIFY") ) || mode.equals( (String)CommonRepository.getCommonKeyValue( "MODE_INSERT") )) )
			return;
	/* Mandatory checks end */

	
	/* Initialize Function specific start */
	PurchaseUnitBean bean = (PurchaseUnitBean)getBeanObject( bean_id,bean_name,request ) ;  
		bean.setLanguageId(locale);

	bean.clear() ;
	ServletContext context = getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
	bean.setMode( mode ) ;
	
	/* Initialize Function specific end */
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));	

if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) )
	{
		
		String unit_code		=	request.getParameter( "unit_code" ) ;
		
		bean.setUnit_code(0,unit_code.trim());
		bean.loadData() ;
		if(bean.getEff_status(0).equals("D"))
				disabled = "disabled" ;
		
//		bean.getMasterTypeList() ;
	}
%>
<form name="formPurchaseUnit" id="formPurchaseUnit" >		
<br><br><br><br><br>

<table cellpadding=0 cellspacing=0 width="90%" align=center >
<tr>
	<td colspan="3">&nbsp;</td>
</tr>

<tr>
	<td  class="label"><fmt:message key="ePO.PurchaseUnitCode.label" bundle="${po_labels}"/></td>
	<td  class=fields colspan="2">&nbsp;&nbsp;<input type="text" name="unit_code_0" id="unit_code_0" value="<%= bean.getUnit_code(0) %>" size="10" maxlength="4" disabled>
	<img src="../../eCommon/images/mandatory.gif"></img></td>
</tr>
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
<tr>
	<td  class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
	<td class=fields   colspan="2">&nbsp;&nbsp;<input type="text" name="long_desc_0" id="long_desc_0" value="<%=bean.getLong_desc(0)%>" size="30" maxlength="40" <%=disabled%> >
	<img src="../../eCommon/images/mandatory.gif"></img></td>
</tr>
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
<tr>
	<td  class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
	<td  class=fields colspan="2">&nbsp;&nbsp;<input type="text" name="short_desc_0" id="short_desc_0" value="<%= bean.getShort_desc(0) %>" size="15" maxlength="15" onBlur="makeValidString( this ) ;"  <%=disabled%> >
	<img src="../../eCommon/images/mandatory.gif"></img></td>
</tr>
<tr>
	<td colspan="3">&nbsp;</td>
</tr>

<tr>
	<td  class="label"><fmt:message key="ePO.AddressLine1.label" bundle="${po_labels}"/></td>
	<td  class=fields colspan="2">&nbsp;&nbsp;<input type="text" name="supp_address1_0" id="supp_address1_0" value="<%= bean.getSupp_Address_1(0) %>" size="60" maxlength="60"   <%=disabled%> >
	</td>
</tr>
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
<tr>
	<td  class="label"><fmt:message key="ePO.AddressLine2.label" bundle="${po_labels}"/></td>
	<td  class=fields colspan="2">&nbsp;&nbsp;<input type="text" name="supp_address2_0" id="supp_address2_0" value="<%= bean.getSupp_Address_2(0) %>" size="60" maxlength="60"   <%=disabled%> >
	</td>
</tr>
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
<tr>
	<td  class="label"><fmt:message key="ePO.AddressLine3.label" bundle="${po_labels}"/></td>
	<td  class=fields colspan="2">&nbsp;&nbsp;<input type="text" name="supp_address3_0" id="supp_address3_0" value="<%= bean.getSupp_Address_3(0) %>" size="60" maxlength="60"   <%=disabled%> >
	</td>
</tr>

<tr>
	<td colspan="3">&nbsp;</td>
</tr>
<tr>
	<td  class="label"><fmt:message key="ePO.GlobalUnit.label" bundle="${po_labels}"/></td>
	<td class=fields  colspan="2">&nbsp;<input type="checkbox" name="global_unit_0" id="global_unit_0" <%=(bean.getGlobal_unit(0)).equals("Y")?"checked":"" %> value="Y" ></td>
</tr>
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
<tr>
	<td  class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td class=fields  colspan="2">&nbsp;<input type="checkbox" name="eff_status_0" id="eff_status_0" <%=(bean.getEff_status(0)).equals("E")?"checked":"" %> value="E" ></td>
</tr>


<tr>
	<td colspan="3">&nbsp;</td>
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

