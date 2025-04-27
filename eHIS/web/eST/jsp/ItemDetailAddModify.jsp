<!DOCTYPE html>
<%--This JSP is call when a user clicks on Create Button -->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html" import=" eST.*, eST.Common.* , eCommon.Common.*, java.text.*, java.util.*" %>
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
		
		
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eST/js/StMessages.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="JavaScript" src="../../eST/js/Item.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body > 
<%
	String mode;
	String bean_id;
	String bean_name;
	//String codeDisabled =	"";
	String disabled		=	"";

	/* Mandatory checks start */
	mode	= request.getParameter( "mode" ) ;
	bean_id = "itemBean" ;
	bean_name = "eST.ItemBean";
	if ( mode == null || mode.equals("") ) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))) )
		return ;
	/* Mandatory checks end */

	/* Initialize Function specific start */
	ItemBean bean = (ItemBean)getBeanObject( bean_id,bean_name,request ) ;  
		bean.setLanguageId(locale);
		/* Initialize Function specific end */

	if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
			}
%>
<form name="formItemDetail" id="formItemDetail" >
		<table border="0" cellpadding="1" cellspacing="0" width='100%' align='center' >
			<a  name="tab1"></a>
			<img  src="../images/General.gif" border=0><a align='left' href="javascript:tab7.scrollIntoView();" onFocus="javascript:tab1.scrollIntoView();"><img  src="../images/Additional_click.gif" border=0></a>
			<tr>
				<td  class="label" ><fmt:message key="eST.MinSalesQuantity.label" bundle="${st_labels}"/></td>
				<td  class="fields">&nbsp;&nbsp;<input type='text' name="group_code" id="group_code" value="" maxLength=10 size=10 class="UPPER"   onBlur="checkSpecialChars(this);"></td>

				<td  class="label" ><fmt:message key="eST.MinimumStock.label" bundle="${st_labels}"/></td>
				<td  class="fields">&nbsp;&nbsp;<input type='text' name="alpha_code" id="alpha_code" value="" maxLength=10 size=10 <%=disabled%> ></td>
			</tr>	
			
			<tr>
				<td  class="label" ><fmt:message key="eST.MinStock.label" bundle="${st_labels}"/></td>
				<td   class="fields">&nbsp;&nbsp;<input type='text' name="long_desc" id="long_desc" value=""  size='40' maxLength='40' onBlur="makeValidString(this);"></td>
				<td  class="label" ><fmt:message key="eST.ROLevel.label" bundle="${st_labels}"/></td>
				<td >&nbsp;&nbsp;<input type='text' name="alpha_code" id="alpha_code" value="" maxLength=10 size=10 <%=disabled%> ></td>
				
			</tr>	
			<tr>
				<td  class="label" ><fmt:message key="eST.MaxStock.label" bundle="${st_labels}"/></td>
				<td  class="fields">&nbsp;&nbsp;<input type='text' name="short_desc" id="short_desc" value=""  size='15' maxLength='15' onBlur="makeValidString(this);"></td>
				<td  class="label" ><fmt:message key="eST.Reordarable.label" bundle="${st_labels}"/></td>
				<td   class="fields">&nbsp;&nbsp;<input type='checkbox' name="short_desc" id="short_desc" value=""  size='15' maxLength='15' onBlur="makeValidString(this);"></td>
				
				</select></td>
			</tr>
			<tr>
       			<td  class="label" ><fmt:message key="eST.LastDays.label" bundle="${st_labels}"/></td>
				<td  class="fields">&nbsp;&nbsp;<input type='text' name="short_desc" id="short_desc" value=""  size='15' maxLength='15' onBlur="makeValidString(this);"></td>
				<td  class='label'><fmt:message key="eST.MinStockDays.label" bundle="${st_labels}"/></td>
				<td  class="fields">&nbsp;<input type='text' name="short_desc" id="short_desc" value=""  size='15' maxLength='15' onBlur="makeValidString(this);"></td>
			</tr>
			<tr>
				<td  class="label" ><fmt:message key="eST.BufferPercentage.label" bundle="${st_labels}"/></td>
				<td   class="fields" colspan='3'>&nbsp;&nbsp;<input type='text' name="short_desc" id="short_desc" value=""  size='15' maxLength='15' onBlur="makeValidString(this);"></td>
				
				</tr>
			</table>
			<br><br><br><br><br><br><br><br><br><br><br><br>
			<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			<tr><td   class='white'>
			<a name="tab7"></a>
			<a  href="javascript:tab1.scrollIntoView();" onFocus="javascript:tab7.scrollIntoView();"><img  src="../images/General_click.gif" border=0></a><img  src="../images/Additional.gif" border=0>
			</td>
			</tr>
			</table>
			<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			<tr>
				<td  class="label" ><fmt:message key="eST.ManufacturerItem.label" bundle="${st_labels}"/></td>
				<td  class="fields">&nbsp;&nbsp;<input type='checkbox' name="short_desc" id="short_desc" value=""  size='15' maxLength='15' onBlur="makeValidString(this);"></td>
			
				</select></td>
				<td  class="label" ><fmt:message key="eST.BaseQuantity.label" bundle="${st_labels}"/></td>
				<td  class="fields">&nbsp;&nbsp;<input type='text' name="short_desc" id="short_desc" value=""  size='15' maxLength='15' onBlur="makeValidString(this);"></td>
				
			</tr>	
						
			<tr>
				<td  class="label" ><fmt:message key="eST.PartNumber.label" bundle="${st_labels}"/></td>
				<td  class="fields">&nbsp;<input type='text' name="wash_reqd_yn" id="wash_reqd_yn"  value="Y" <%=disabled%>  onClick="enableWashingDetails(this.checked);"></td>
				<td  class="label"><fmt:message key="eST.MachineCode.label" bundle="${st_labels}"/></td>
				<td>&nbsp;&nbsp;<select name="def_washing_type" id="def_washing_type" >
			
						</select></td>
			</tr>	

			<tr>
				<td  class="label" ><fmt:message key="Common.Insurance.label" bundle="${common_labels}"/></td>
				<td  class="fields">&nbsp;<input type='checkbox' name="pack_reqd_yn" id="pack_reqd_yn"  value="Y" <%=disabled%>  onClick="enablePackingDetails(this.checked)"></td>

				<td  class="label"><fmt:message key="Common.Autoclave.label" bundle="${common_labels}"/></td>
				<td  class="fields">&nbsp;&nbsp;<input type='checkbox' name="pack_item_desc" id="pack_item_desc" value="" maxLength='40' size='20' ></td>
			</tr>	
			<tr>
				<td  class="label" ><fmt:message key="Common.SterileType.label" bundle="${common_labels}"/></td>
				<td  class="fields">&nbsp;<input type='text' name="pack_reqd_yn" id="pack_reqd_yn"  value="Y" <%=disabled%>  onClick="enablePackingDetails(this.checked)"></td>

				<td  class="label"><fmt:message key="eST.PhyInventory.label" bundle="${st_labels}"/></td>
				<td  class="fields">&nbsp;&nbsp;<input type='checkbox' name="pack_item_desc" id="pack_item_desc" value="" maxLength='40' size='20' ></td>
			</tr>
			<tr>
				<td  class="label" ><fmt:message key="Common.CurrentYear.label" bundle="${common_labels}"/></td>
				<td  class="fields">&nbsp;<input type='checkbox' name="pack_reqd_yn" id="pack_reqd_yn"  value="Y" <%=disabled%>  onClick="enablePackingDetails(this.checked)"></td>

				<td  class="label"><fmt:message key="eST.PresentCount.label" bundle="${st_labels}"/></td>
				<td  class="fields">&nbsp;&nbsp;<input type='checkbox' name="pack_item_desc" id="pack_item_desc" value="" maxLength='40' size='20' ></td>
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

