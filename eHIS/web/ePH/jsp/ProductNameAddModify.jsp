<!DOCTYPE html>
<!-- Created on 04 August 2009 =====Shyampriya==== -->

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="ePH.*, ePH.Common.*,eCommon.Common.*,java.util.*,java.text.SimpleDateFormat,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
<% 
	request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
%>

 <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
 <script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 <script language="JavaScript" src="../../eCommon/js/common.js"></script>
 <script language="JavaScript" src="../js/PhCommon.js"></script>
 <script language="JavaScript" src="../js/ProductName.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>
<style>
textarea {
  resize: none;
}
</style>


<%
	
	String	 mode				=		(request.getParameter( "mode" ) !=null ? (request.getParameter("mode").trim()):"" );
	String bean_id				= "ProductNameBean" ;
	String bean_name			= "ePH.ProductNameBean";
	
	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;

	ProductNameBean bean			= (ProductNameBean)getBeanObject( bean_id,bean_name,request) ;

	bean.setLanguageId(locale);
	bean.setMode(mode) ;

	String product_code = "";
	String long_desc = "";
	String short_desc = "";
	String admixture_type = "";
	String remarks = "";
	String eff_status = "";
	String checked = "checked";
	String readonly = "";
	String selected = "";
	String disabled ="";

	if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) 
		{
			String	 product_name_code				=		(request.getParameter( "product_code" ) !=null ? (request.getParameter("product_code").trim()):"" );
			ArrayList productnameDetails = bean.getProductnameDetails(product_name_code);
			readonly = "readonly";

			if(productnameDetails.size()>1)
			{
				product_code = (String) productnameDetails.get(0);
				long_desc = (String) productnameDetails.get(1);
				short_desc = (String) productnameDetails.get(2);
				admixture_type = (String) productnameDetails.get(3);
				remarks = ((String) productnameDetails.get(4)).trim();
				eff_status = (String) productnameDetails.get(5);
			}

			if(eff_status.equals("D"))
			{
				checked = "";
				disabled="disabled";
			}
		}
	
%>

<body onload="FocusFirstElement();">
	<form name="ProductNameForm" id="ProductNameForm"  onreset="FocusFirstElement()">
		<br><br><br><br><br>
		<table border="0" cellpadding="3" cellspacing="0" width='75%'  height='75%' align=center>
		<tr height="6%">
			<td width="20%">&nbsp;</td>
			<td class="label" width="20%" ><fmt:message key="ePH.ProductNameCode.label" bundle="${ph_labels}"/></td>
			<td><input type="text" name="product_code" id="product_code" value="<%=product_code%>" size="6" maxlength="6" onKeyPress="return CheckForSpecChars(event);" onblur="this.value = this.value.toUpperCase();" oninput="this.value = this.value.toUpperCase();" <%=readonly%>>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></img>
			</td>
		</tr>
		<tr height="5%">
			<td width="20%">&nbsp;</td>
			<td class="label" width="20%" ><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
			<td><input type="text" name="long_desc" id="long_desc" value="<%=long_desc%>" size="60" maxlength="60" <%=disabled%> onKeyPress='return AllowFormat();'>&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></img>
			</td>
		</tr>
		<tr height="5%">
			<td width="20%">&nbsp;</td>
			<td class="label" width="20%" ><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
			<td><input type="text" name="short_desc" id="short_desc" value="<%=short_desc%>" size="30" maxlength="30" <%=disabled%> onKeyPress='return AllowFormat();'>&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></img>
			</td>
		</tr>
		<tr height="5%">
			<td width="20%">&nbsp;</td>
			<td class="label" width="20%" ><fmt:message key="ePH.AdmixtureType.label" bundle="${ph_labels}"/></td>
			<td >
					<select name="admixture_type" id="admixture_type" <%=disabled%>>
<%
						if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) && admixture_type.equals("A") )
							selected = "selected";
						else
							selected = "";
%>
						<option value="A" <%=selected%>><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
<%
						if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) && admixture_type.equals("CR") )
							selected = "selected";
						else
							selected = "";
%>
						<option value="CR" <%=selected%>><fmt:message key="ePH.CompoundRx.label" bundle="${ph_labels}"/></option>
<%
						if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) && admixture_type.equals("IV") )
							selected = "selected";
						else
							selected = "";
%>
						<option value="IV" <%=selected%>><fmt:message key="ePH.IVRx.label" bundle="${ph_labels}"/></option>
<%
						if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) && admixture_type.equals("OA") )
							selected = "selected";
						else
							selected = "";
%>
						<option value="OA" <%=selected%>><fmt:message key="ePH.OncologyAdmixture.label" bundle="${ph_labels}"/></option>
					</select>
			</td>
		</tr>
		<tr height="20%">
			<td width="20%">&nbsp;</td>
			<td class="label" width="20%" ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
			<td class="fields">	<textarea rows="7" cols="49" size="250" maxLength="250" name="remarks" onKeyPress="return AllowFormat(); return checkMaxLimit(this,250);"  onblur="checkMaxLength(this);" <%=disabled%>><%=remarks%></textarea>
			</td>
		</tr>
		<tr height="5%">
			<td width="20%">&nbsp;</td>
			<td  class="label" width="20%" ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td class="fields"><input type="checkbox"  value="E" name="eff_status" id="eff_status"  <%=checked%>>	</td> 
		</tr>
		<tr><td colspan="7">&nbsp;</td></tr>
		</table>

	<input type="hidden" name="mode" id="mode"		value="<%=mode%>">	
	<input type="hidden" name="bean_id" id="bean_id"		value="<%=bean_id%>">	
	<input type="hidden" name="bean_name" id="bean_name"	value="<%=bean_name%>">

	</form>
<%
	 putObjectInBean(bean_id,bean,request); 
%>
</body>

</HTML>

