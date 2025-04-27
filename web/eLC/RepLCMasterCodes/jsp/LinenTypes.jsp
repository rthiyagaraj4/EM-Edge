<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.iba.framework.core.vo.UserPreferences"%>
<%@ page import="com.iba.framework.cache.pojo.business.Cache"%>
<%@ page import="com.iba.framework.cache.pojo.business.CacheManager"%>
<%@ page  import="com.iba.framework.core.util.Constants"%>
<%@ include file="/framework/html/Tag.text"%>
<html>
<head>
	<%
		
		String functionId=(String)session.getAttribute("functionId");
		String moduleId=(String)session.getAttribute("moduleId");
		String facilityId=(String)session.getAttribute("facility_id");
		String language_Id = (String)session.getAttribute("LOCALE");
		String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
		.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
		:"IeStyle.css" ;
		if(sStyle==null)sStyle="IeStyle.css";
		
	%>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/IBADateValidator.js'></script>
	<Script Language="JavaScript" src="<%=request.getContextPath()%>/framework/js/common.js"></Script>
	<Script Language="JavaScript" src="<%=request.getContextPath()%>/framework/js/validations.js"></Script>
    <script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
    <script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
    <script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/DynaLookup.js'></script>
     <Script language ="JavaScript" src ='<%=request.getContextPath()%>/core/lookup/js/Lookup.js'></Script>
    <script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
    <script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
	<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>
    <Script Language="JavaScript" src="<%=request.getContextPath()%>/eLC/RepLCMasterCodes/js/LinenMasterCodes.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

  	<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>' />
</head>
	<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<ibaHTML:form action="/RepLinenMasterCodesAction.do" target="messageFrame" method="GET">
			<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
			<tr>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td>
						</td>
							<td align="left" class="label">
								<ibaBean:message key="com.iba.ehis.lc.From" bundle="lcLabels" />
								</td>
									<td align="left" class="label">
								<ibaBean:message key="com.iba.ehis.lc.To" bundle="lcLabels" />
							</td>
						</tr>	
					<tr>
					<td align="right" class="label">
						<ibaBean:message key="com.iba.ehis.lc.linenTypeCode" bundle="lcLabels" />
							</td>
								<td>
									<ibaHTML:text property="vo.linenTypeFrom" size="30" maxlength="30" />
										<input type='hidden' name="linenTypeHiddenFrom" id="linenTypeHiddenFrom" value=''/>
										<input type='button' class='button' value='?' onClick="showLookup('linenType','LTLookupFrom');" />
									</td>
								<td>
							<ibaHTML:text property="vo.linenTypeTo" size="30" maxlength="30"/>
						<input type='hidden' name="linenTypeHiddenTo" id="linenTypeHiddenTo" value=''/>
					<input type='button' class='button' value='?' onClick="showLookup('linenType','LTLookupTo');" />
				</td>
			</tr>
			<tr>
				<td align="right" class="label">
					<ibaBean:message key="com.iba.ehis.lc.status" bundle="lcLabels" />
						</td>
							<td>
								<ibaHTML:select property="vo.effStatus">
									<ibaHTML:option value=""><ibaBean:message key="com.iba.ehis.lc.select" bundle="lcLabels" /></ibaHTML:option>
									<ibaHTML:option value="E"><ibaBean:message key="com.iba.ehis.lc.statusY" bundle="lcLabels" /></ibaHTML:option>
									<ibaHTML:option value="D"><ibaBean:message key="com.iba.ehis.lc.statusN" bundle="lcLabels" /></ibaHTML:option>
								</ibaHTML:select>
							</td>
						<td>
					</td>
				</tr>
				<tr>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>
			</table>
				<ibaHTML:hidden property="method"/>
				<ibaHTML:hidden property="vo.functionId" value="<%=functionId%>"/>
				<ibaHTML:hidden property="vo.moduleId" value="<%=moduleId%>"/>
				<ibaHTML:hidden property="vo.repId" value="LCRLNTYP"/>
	
				<INPUT TYPE="hidden" name="facility_id" id="facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
				<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%= session.getValue( "facility_id" ) %>"/>
	
				<INPUT TYPE="hidden" name="user_id" id="user_id" VALUE="<%= session.getValue( "login_user" ) %>">
				<input type="hidden" name="p_user_id" id="p_user_id" value="<%= session.getValue( "login_user" ) %>"/>
				
				<input type="hidden" name="p_module_id" id="p_module_id" value="LC">
				<input type="hidden" name="module_id" id="module_id" value="LC">
	
				<input type="hidden" name="p_report_id" id="p_report_id" value="LCRLNTYP" />
				<input type="hidden" name="report_id" id="report_id" value="LCRLNTYP"/>
		
				<input type='hidden' name='locale' id='locale' value='<%=language_Id%>'>
				<input type='hidden' name='p_language_id' id='p_language_id' value='<%=language_Id%>'>
				<input type='hidden' name='facilityId' id='facilityId' value='<%=facilityId%>'>
						
				<input type='hidden' name='P_Linen_Type_From' id='P_Linen_Type_From' value=''>
				<input type='hidden' name='P_Linen_Type_To' id='P_Linen_Type_To' value=''>
				<input type='hidden' name='P_Status' id='P_Status' value=''>
		</ibaHTML:form>
	</body>
</html>

