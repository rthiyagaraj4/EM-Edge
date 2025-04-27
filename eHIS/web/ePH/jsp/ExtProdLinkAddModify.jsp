<!DOCTYPE html>
 <%-- created on 07/12/2009   Shyampriya --%>

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
//Added  for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<!--<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/MstCodeCommon.js"></SCRIPT> -->
	<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/PhCommon.js"></SCRIPT>
	<script language="JavaScript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
	<SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/ExtProdLink.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	<SCRIPT>
		function_id = "<%= request.getParameter( "function_id" ) %>"
	</SCRIPT>
</HEAD>

<body onMouseDown="CodeArrest()"  onKeyDown="lockKey()">

<%
	/* Mandatory checks start */
	String mode	= request.getParameter( "mode" ) ;
	String bean_id = "ExtProdLinkBean" ;
	String bean_name = "ePH.ExtProdLinkBean";


	
	 String pkey_value      ="";

	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) ) ) )
		return ;
		
	/* Mandatory checks end */

	/* Initialize Function specific start */
	ExtProdLinkBean bean = (ExtProdLinkBean)getBeanObject( bean_id, bean_name, request ) ;


	 bean.clear() ;
	 bean.setLanguageId(locale);
	bean.setMode( mode ) ;
	
	int	    totalRecords	=	0;	
	totalRecords	=	Integer.parseInt(CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE") );	
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	

	String tableWidth="";
	String fieldCheck="";
	String disabled="disabled";
	

%>
<form name="frmExtProductLink" id="frmExtProductLink">
<%
		if( mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") ) ) {
%>
	<BR><BR><BR><BR>
	<table cellpadding="0" cellspacing="0" width="89%" align="center" border=1>
	<TR>
		<TH><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></TH>
		<TH><fmt:message key="ePH.ProductID.label" bundle="${ph_labels}"/></TH>
		<TH><fmt:message key="ePH.Type.label" bundle="${ph_labels}"/></TH>
		<TH><fmt:message key="ePH.ExternalDrugCode.label" bundle="${ph_labels}"/></TH>
		<TH ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></TH>
	</TR>
<%
	String classValue="";
	for ( int cnt=1; cnt<=totalRecords; cnt++ ) {
		if(cnt%2 ==0)
			classValue="QRYEVEN";
		else
			classValue="QRYODD";
%>
		 <TR>
			<TD CLASS="<%=classValue %>" >
<!--onKeyPress="return CheckForSpecChars(event)" onBlur="queryDrugSearch(drug_desc<%=cnt%>,drug_code<%=cnt%>,ext_drug_code<%=cnt %>);" -->
				<INPUT TYPE="text" name="drug_desc<%=cnt%>" id="drug_desc<%=cnt%>"  SIZE="40" MAXLENGTH="40"  class="UPPER" readOnly><input type="button" name="drug_search<%=cnt%>" id="drug_search<%=cnt%>" value="?" class="button"   onClick="queryDrugSearch(drug_desc<%=cnt%>,drug_code<%=cnt%>,ext_drug_code<%=cnt %>,product_id<%=cnt %>);">
				<INPUT TYPE="hidden" name="drug_code<%=cnt%>" id="drug_code<%=cnt%>" value="">
			</TD>
			<TD CLASS="<%=classValue %>" >
				<SELECT name="product_id<%=cnt %>" id="product_id<%=cnt %>" onChange="AlertExtDrugCode(drug_code<%=cnt%>,ext_drug_code<%=cnt %>,this,type<%=cnt %>);">
					<OPTION VALUE="FDB"><fmt:message key="ePH.FirstDataBank.label" bundle="${ph_labels}"/></option>
					<OPTION VALUE="CIMS">CIMS</option>
				</SELECT>
			</TD>
			<TD CLASS="<%=classValue %>" >
				<SELECT name="type<%=cnt %>" id="type<%=cnt %>" disabled >
					<option value="">&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;</option>
					<OPTION VALUE="Product">Product</option>
					<OPTION VALUE="GGPI">GGPI</option>
					<OPTION VALUE="GenericItem ">GenericItem </option>
				</SELECT>
			</TD>
			<TD CLASS="<%=classValue %>" >
				<INPUT TYPE="text" name="ext_drug_code<%=cnt %>" id="ext_drug_code<%=cnt %>"  SIZE="40" MAXLENGTH="40" onKeyPress="return CheckForAlphaNumeric(event)" onBlur="CodeCheck(this)" class="UPPER" disabled>
				<!-- Removed - CIMS LookUP, onKeyPress="return CheckForAlphaNumeric(event)"  onBlur="CodeCheck(this)"  --> 
				<!-- ADDED - CIMS LookUP -->
				<input type="button" name="cims_search<%=cnt%>" id="cims_search<%=cnt%>" value="?" class="button"   onClick="queryCIMSCode(product_id<%=cnt%>,type<%=cnt%>,ext_drug_code<%=cnt%>,this);">&nbsp;
				<!-- ADDED IN JUNE 2012 - CIMS TILL HERE -->
			</TD>
		
			<TD  CLASS="<%=classValue %>" >&nbsp;&nbsp;
				<INPUT TYPE="checkbox" name="eff_status<%=cnt%>" id="eff_status<%=cnt%>" VALUE="E" checked>
			</TD>
		</TR>
<%
	}
%>
	</table>
<%
} // end if(mode = insert0

		if( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {	
			String drug_code=request.getParameter("drug_code");
			String drug_desc=request.getParameter("drug_desc");
			String product_id=request.getParameter("product_id");
			String type=request.getParameter("type");
			String product_id_code ="";


			
			if(product_id.trim().equals("First Data Bank")){
				product_id_code = "FDB";
				type = "";
			}
			else if(product_id.trim().equals("CIMS")){
				product_id_code = "CIMS";
			
			}
			String ext_prod_drug_code=request.getParameter("ext_prod_drug_code");

			String nature=bean.getEnabledStatus(drug_code, product_id_code, ext_prod_drug_code);
			String checked = "";
			
			if(nature.equals("E"))
			{
				checked="checked";
				
			}
			else 
			{
				checked ="";
				
			}

%>
	
			<table border="0" cellpadding="3" cellspacing="0" width='75%'  height='50%' align=center>

				<tr><td>&nbsp;</td></tr>
				<tr><td>&nbsp;</td></tr>

				<tr >
					<td width="20%">&nbsp;</td>
					<td class="label" width="20%" ><fmt:message key="Common.DrugCode.label" bundle="${common_labels}"/></td>
					<td><input type="text" name="drug_code" id="drug_code" value="<%=drug_code%>" size="20" maxlength="20" readonly></td>
				</tr>

				<tr >
					<td width="20%">&nbsp;</td>
					<td class="label" width="20%" ><fmt:message key="ePH.DrugDescription.label" bundle="${ph_labels}"/></td>
					<td><input type="text" name="drug_desc" id="drug_desc" value="<%=drug_desc%>" size="60" maxlength="60" readonly></td>
				</tr>

				<tr >
					<td width="20%">&nbsp;</td>
					<td class="label" width="20%" ><fmt:message key="ePH.ProductID.label" bundle="${ph_labels}"/></td>
					<td><input type="text" name="product_id_name" id="product_id_name" value="<%=product_id%>" size="60" maxlength="60" readonly></td>
					<input type="hidden" name="product_id" id="product_id" value="<%=product_id_code%>">
				</tr>
<%
					String disable_type = "";
					if((product_id.trim()).equals("First Data Bank"))
						disable_type = "disabled";
%>

				<tr >
					<td width="20%">&nbsp;</td>
					<td class="label" width="20%" ><fmt:message key="ePH.Type.label" bundle="${ph_labels}"/></td>
					<td>
					<SELECT name="typeDesc" id="typeDesc" <%=disable_type%> >
						<option value="">&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;</option>
<% 
					if((type.trim()).equals("Product")){
%>
						<OPTION VALUE="Product" selected>Product</option>
<%						
					}else{
%>
						<OPTION VALUE="Product" >Product</option>
<%
					}
 
					if((type.trim()).equals("GGPI")){
%>
						<OPTION VALUE="GGPI" selected>GGPI</option>
<%						
					}else{
%>
						<OPTION VALUE="GGPI" >GGPI</option>
<%
					}
					if((type.trim()).equals("GenericItem")){
%>
						<OPTION VALUE="GenericItem" selected>GenericItem </option>
<%						
					}else{
%>
						<OPTION VALUE="GenericItem" >GenericItem </option>
<%
					}
%>
						</SELECT>
					
				<!--	<input type="text" name="typeDesc" id="typeDesc" value="<%=type%>" size="60" maxlength="60" readonly> -->
					
					</td>
			
				</tr>

				<tr >
					<td width="20%">&nbsp;</td>
					<td class="label" width="20%" ><fmt:message key="ePH.ExternalDrugCode.label" bundle="${ph_labels}"/></td>
					<td><input type="text" name="ext_prod_drug_code" id="ext_prod_drug_code" value="<%=ext_prod_drug_code%>" size="60" maxlength="60" onKeyPress ="return CheckForAlphaNumeric(event)" onBlur="CodeCheck(this)" class="UPPER">
					<!-- REMOVED onKeyPress ="return CheckForAlphaNumeric(event)" and onBlur="CodeCheck(this)"  FOR june 2012 - CIMS -->
					<!-- ADDED IN JUNE 2012 - CIMS -->
					<input type="button" name="cims_search" id="cims_search" value="?" class="button"  onfocus="queryCIMSCode(product_id_name,typeDesc,ext_prod_drug_code,this);" onClick="queryCIMSCode(product_id_name,typeDesc,ext_prod_drug_code,this);">&nbsp;
					<!-- ADDED IN JUNE 2012 - CIMS TILL HERE -->
					</td>
				</tr>

				<tr >
					<td width="20%">&nbsp;</td>
					<td  class="label" width="20%" ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
					<td class="fields"><input type="checkbox"  value="E" name="eff_status" id="eff_status"  <%=checked%>>	</td> 
				</tr>
				
		</table>
<%
		} // end if mode = modify
%>
	<input type="hidden" name="mode" id="mode" value="<%= mode %>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="totalRecords" id="totalRecords" value="<%= totalRecords %>">
			
</FORM>

</BODY>
</HTML>

<%
putObjectInBean(bean_id,bean,request);
%>

