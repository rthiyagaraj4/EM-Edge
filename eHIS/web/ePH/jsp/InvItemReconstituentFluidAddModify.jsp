<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.* , eCommon.Common.*" %>
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

    <script language="JavaScript" src="../../eCommon/js/common.js"></script>
    <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
    <script language="JavaScript" src="../js/PhCommon.js"></script>
  <!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->
  <!--<script language="JavaScript" src="../js/PhMessages.js"></script>-->
    <script language="JavaScript" src="../js/ReconstituentFluid.js"></script>
	<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="Javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 </head>
<!-- <body> -->
<body onMouseDown="" onKeyDown="lockKey()">
<%
	/* Mandatory checks start */
	String mode	= request.getParameter( "mode" ) ;
	String bean_id	=	"ReconstituentFluidBean";
	String bean_name	=	"ePH.ReconstituentFluidBean";
	String rf_id	= request.getParameter( "rf_id" ) ;
//out.println("rf_id....."+rf_id);
	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) ) ) )
		return ;
	/* Mandatory checks end */

	//String facility_id=(String) session.getValue( "facility_id" );

	/* Initialize Function specific start */
	ReconstituentFluidBean bean = (ReconstituentFluidBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);

	String Immodule_Yn=(String) bean.getImModule();

	bean.clear() ;
	bean.setMode( mode ) ;
	/* Initialize Function specific end */

	
%>

<form name="frmInvItemReconstituentFluidAddModify" id="frmInvItemReconstituentFluidAddModify" id="InvItem ReconstituentFluid AddModify">
<table width="90%" CELLPADDING="0" CELLSPACING="0" BORDER="0" align='center'>
	<th colspan="4"><fmt:message key="ePH.Add/ModifyInventoryItems.label" bundle="${ph_labels}"/></th>

	<tr>
		<td class="label"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
		<td colspan=""><INPUT TYPE="text" maxlength=20 name="ITEM_DESC" id="ITEM_DESC"><INPUT TYPE="button" CLASS="button" name="ITEM_SEARCH" id="ITEM_SEARCH" VALUE="?" onClick="searchCode(ITEM_DESC)"><img src="../../eCommon/images/mandatory.gif" ></img><input type="hidden" name="ITEM_CODE" id="ITEM_CODE" value=""> </td>
		<td class="label"><fmt:message key="ePH.ContentinBaseUnit.label" bundle="${ph_labels}"/></td>
		<td><INPUT TYPE="text" name="CONTENT_IN_BASE_UOM" id="CONTENT_IN_BASE_UOM" maxlength=8 style="text-align:right" onBlur="CheckPositiveNumber(this)"><img src="../../eCommon/images/mandatory.gif" align="center"></img></td>
	</tr>
	<tr>
			<td colspan="4" align='right'> 
				<input type="button" name="butt1" id="butt1" value='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>' class="button" onClick="editRow(this)">

				<input type="button" name="butt2" id="butt2" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' class="button" onClick="ResetToDefaultValues()">
			</td>
	</tr>
	<input type="hidden" name="rowNum" id="rowNum" value="">
	<%
	   String sqlQuery = "SELECT A.ITEM_CODE code,  B.LONG_DESC description FROM   ST_ITEM A,  MM_ITEM B WHERE B.ITEM_CODE=A.ITEM_CODE AND  upper(A.ITEM_CODE) LIKE UPPER(?) AND   upper(B.LONG_DESC) LIKE UPPER(?) AND A.ITEM_CODE IN (SELECT ITEM_CODE FROM PH_DRUG WHERE PHYSICAL_FORM='L' AND APPL_TO_RECONST_FLUID_YN='Y')  ORDER BY 2";
	%>
	<!-- <INPUT TYPE="hidden" name="SQL_PH_RECONSTITUENT_FLUID_SELECT4" id="SQL_PH_RECONSTITUENT_FLUID_SELECT4" VALUE="<%= PhRepository.getPhKeyValue( "SQL_PH_RECONSTITUENT_FLUID_SELECT4" ) %>"> -->
	<INPUT TYPE="hidden" name="SQL_PH_RECONSTITUENT_FLUID_SELECT4" id="SQL_PH_RECONSTITUENT_FLUID_SELECT4" VALUE="<%= sqlQuery %>">

	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input TYPE="hidden" name="Immodule_Yn" id="Immodule_Yn" value="<%=Immodule_Yn%>">
	<input TYPE="hidden" name="rf_id" id="rf_id" value="<%=rf_id%>">


</table>
</form>
</body>
</html>
<%
putObjectInBean(bean_id,bean,request);
%>

