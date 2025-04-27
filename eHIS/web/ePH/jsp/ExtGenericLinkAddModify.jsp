<!DOCTYPE html>
 <!-- 
/*
 ------------------------------------------------------------------------------------------------------------------------------
Date		Edit History		Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------	
28/04/2020  IN:071537        B Haribabu                                         GHL-CRF-0614
-------------------------------------------------------------------------------------------------------------------------------
*/
 -->
 <%-- created on 23/12/2009  Shyampriya --%>

<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import="ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %><!--Modified for IN:071537-->

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
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<!-- <SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/MstCodeCommon.js"></SCRIPT> -->
	<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/PhCommon.js"></SCRIPT>
	<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/ExtGenericLink.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	<SCRIPT>
		function_id = "<%= request.getParameter( "function_id" ) %>"
	</SCRIPT>
</HEAD>

<body onMouseDown="CodeArrest()"  onKeyDown="lockKey()">

<%
	/* Mandatory checks start */
	String mode	= request.getParameter( "mode" ) ;
	String bean_id = "ExtGenericLinkBean" ;
	String bean_name = "ePH.ExtGenericLinkBean";


	
	 String pkey_value      ="";

	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) ) ) )
		return ;
		
	/* Mandatory checks end */

	/* Initialize Function specific start */
	ExtGenericLinkBean bean = (ExtGenericLinkBean)getBeanObject( bean_id, bean_name, request ) ;


	 bean.clear() ;
	 bean.setLanguageId(locale);
	bean.setMode( mode ) ;
	
	int	    totalRecords	=	0;	
	totalRecords	=	Integer.parseInt(CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE") );	
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	
	//Added for IN:071537 start
    Connection con				= null;
	 
    boolean type_appl=false;
			
	try 
	{
		con						= ConnectionManager.getConnection(request);
		type_appl = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","PH_THIRDPARTY_TYPE_APPL");
	} 
	catch (Exception e) 
	{
		e.printStackTrace(System.err);
		System.out.println(" Error in Criteria Page " + e.getMessage());
	} 
	finally 
	{
		if (con != null) ConnectionManager.returnConnection(con, request);
	}
	
	//Added for IN:071537 end
	String tableWidth="";
	String fieldCheck="";
	String sql_ph_generic_name_select="";
	

%>
<form name="frmExtGenericLink" id="frmExtGenericLink" id="External Generic Link" >
<%
		if( mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") ) ) {
			sql_ph_generic_name_select = PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT14");
%>
	
	<BR><BR><BR><BR>
	<table cellpadding="0" cellspacing="0" width="60%" align="center" border=1>
	<TR>
		<TH><fmt:message key="ePH.GenericID.label" bundle="${ph_labels}"/></TH>
		<TH><fmt:message key="ePH.ProductID.label" bundle="${ph_labels}"/></TH>
		<!--Added for IN:071537 start -->
		<%if(type_appl){ %>
		<TH><fmt:message key="ePH.Type.label" bundle="${ph_labels}"/></TH>
		<%} %>
		<!--Added for IN:071537 end -->
		<TH><fmt:message key="ePH.ExternalGenericID.label" bundle="${ph_labels}"/></TH>
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
				<INPUT TYPE="text" name="generic_name<%=cnt%>" id="generic_name<%=cnt%>"  SIZE="40" MAXLENGTH="40"  class="UPPER" VALUE="" readOnly><input type="button" name="generic_search<%=cnt%>" id="generic_search<%=cnt%>" value="?" class="button"   onClick="searchGenericName(generic_name<%=cnt%>,generic_id<%=cnt%>,ext_generic_id<%=cnt %>,product_id<%=cnt %>);">
				<INPUT TYPE="hidden" name="generic_id<%=cnt%>" id="generic_id<%=cnt%>" value="">
			</TD>
			<TD CLASS="<%=classValue %>" >&nbsp;
				<SELECT name="product_id<%=cnt %>" id="product_id<%=cnt %>" >
					<OPTION VALUE="CIMS">  CIMS  </option>
				</SELECT>&nbsp;&nbsp;
			</TD>
			<!--Added for IN:071537 starts -->
			<%if(type_appl){ %>
			<TD CLASS="<%=classValue %>" >
				<SELECT name="type<%=cnt %>" id="type<%=cnt %>"  >
<%-- 					<option value="">&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;</option> --%>
					<OPTION VALUE="Molecule">Molecule</option>
					<OPTION VALUE="SubstanceClass">Substance Class</option>
					<OPTION VALUE="Product">Product</option>
					<OPTION VALUE="GGPI">GGPI</option>
					<OPTION VALUE="GenericItem">Generic Item</option>
					<OPTION VALUE="ActiveCompositionGroup">Active Composition Group</option>
				</SELECT>
			</TD>
			<%} %>
			<!--Added for IN:071537 end -->
			<TD CLASS="<%=classValue %>" >		
				<INPUT TYPE="text" name="ext_generic_id<%=cnt %>" id="ext_generic_id<%=cnt %>"  SIZE="40" MAXLENGTH="40" onKeyPress="return CheckForAlphaNumeric(event)" onBlur="CodeCheck(this)" class="UPPER" disabled>
				<!-- Removed - CIMS LookUP,CIMS , onKeyPress="return CheckForAlphaNumeric(event)" onBlur="CodeCheck(this)"  --> 
				<!-- ADDED  - CIMS LookUP-->
				<%if(type_appl){ %>
				<input type="button" name="cims_search<%=cnt%>" id="cims_search<%=cnt%>" value="?" class="button"   onClick="queryCIMSCode(product_id<%=cnt%>,type<%=cnt%>,ext_generic_id<%=cnt%>,this);">&nbsp;<!--Modified for IN:071537-->
				<%} else{%>
				<input type="button" name="cims_search<%=cnt%>" id="cims_search<%=cnt%>" value="?" class="button"   onClick="queryCIMSCode(product_id<%=cnt%>,'',ext_generic_id<%=cnt%>,this);">&nbsp;<!--Modified for IN:071537-->
				<%} %>
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
			String generic_id=request.getParameter("generic_id");
			String generic_name=request.getParameter("generic_name");
			String product_id=request.getParameter("product_id");
			String type=request.getParameter("type");//Added for IN:071537
		//	if(product_id.trim().equals("First Data Bank"))
		//		product_id_code = "FDB";
		//	else if(product_id.trim().equals("CIMS"))
		//		product_id_code = "CIMS";
			String ext_generic_id=(request.getParameter("ext_prod_generic_id")).trim();//Modified for IN:071537

			String nature=bean.getEnabledStatus(generic_id, product_id, ext_generic_id);
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
					<td class="label" width="20%" ><fmt:message key="ePH.GenericID.label" bundle="${ph_labels}"/></td>
					<td><input type="text" name="generic_id" id="generic_id" value="<%=generic_id%>" size="20" maxlength="20" readonly></td>
				</tr>

				<tr >
					<td width="20%">&nbsp;</td>
					<td class="label" width="20%" ><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></td>
					<td><input type="text" name="generic_name" id="generic_name" value="<%=generic_name%>" size="60" maxlength="60" readonly></td>
				</tr>

				<tr >
					<td width="20%">&nbsp;</td>
					<td class="label" width="20%" ><fmt:message key="ePH.ProductID.label" bundle="${ph_labels}"/></td>
					<td><input type="text" name="product_id" id="product_id" value="<%=product_id%>" size="60" maxlength="60" readonly></td>
					
				</tr>
				<!--Added for IN:071537 starts -->
				<tr >
					<%if(type_appl){ %>
					<td width="20%">&nbsp;</td>
					<td class="label" width="20%" ><fmt:message key="ePH.Type.label" bundle="${ph_labels}"/></td>
					<td>
					<SELECT name="typeDesc" id="typeDesc" onchange="clearExtProductID();" ><!--Modified for IN:071537-->
<%-- 						<option value="">&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;</option> --%>
<%
					if((type.trim()).equals("Molecule")){
%>
						<OPTION VALUE="Molecule" selected>Molecule</option>
<%						
					}else{
%>
						<OPTION VALUE="Molecule" >Molecule</option>
<%
	            	}
						 
					if((type.trim()).equals("SubstanceClass")){
%>
						<OPTION VALUE="SubstanceClass" selected>Substance Class</option>
<%						
					}else{
%>
						<OPTION VALUE="SubstanceClass" >Substance Class</option>
<%
					}
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
						<OPTION VALUE="GenericItem" selected>Generic Item</option>
<%						
					}else{
%>
						<OPTION VALUE="GenericItem" >Generic Item</option>
<%
					}
					if((type.trim()).equals("ActiveCompositionGroup")){
%>
						<OPTION VALUE="ActiveCompositionGroup" selected>Active Composition Group</option>
<%						
					}else{
%>
	 				    <OPTION VALUE="ActiveCompositionGroup" >Active Composition Group</option>
<%
					}
%>
						</SELECT>
					
				<!--	<input type="text" name="typeDesc" id="typeDesc" value="<%=type%>" size="60" maxlength="60" readonly> -->
					
					</td>
					<%} %>
			
				</tr>
                                <!--Added for IN:071537 end -->
				<tr >
					<td width="20%">&nbsp;</td>
					<td class="label" width="20%" ><fmt:message key="ePH.ExternalGenericID.label" bundle="${ph_labels}"/></td>
					<td><input type="text" name="ext_generic_id" id="ext_generic_id" value="<%=ext_generic_id%>" size="60" maxlength="60" onKeyPress ="return CheckForAlphaNumeric(event)" onBlur="CodeCheck(this)" class="UPPER">
					<!-- Removed CIMS Lookup, onKeyPress ="return CheckForAlphaNumeric(event)" onBlur="CodeCheck(this)"  --> 
					<!-- ADDED CIMS Lookup -->
					<%if(type_appl){ %>
					<input type="button" name="cims_search" id="cims_search" value="?" class="button"   onClick="queryCIMSCode(product_id,typeDesc,ext_generic_id,this);">&nbsp;<!--Modified for IN:071537-->
					<%}else{ %>
					<input type="button" name="cims_search" id="cims_search" value="?" class="button"   onClick="queryCIMSCode(product_id,'',ext_generic_id,this);">&nbsp;<!--Modified for IN:071537-->
					<%} %>
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
	<input type="hidden" name="sql_ph_generic_name_select" id="sql_ph_generic_name_select" value="<%=sql_ph_generic_name_select%>">
	<input type="hidden" name="language_id" id="language_id" value="<%=locale%>">		
</FORM>

</BODY>
</HTML>

<%
putObjectInBean(bean_id,bean,request);
%>

