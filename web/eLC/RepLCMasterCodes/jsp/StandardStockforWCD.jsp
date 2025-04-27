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
	<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/IBADateValidator.js'></script>
	<Script Language="JavaScript" src="<%=request.getContextPath()%>/framework/js/common.js"></Script>
	<Script Language="JavaScript" src="<%=request.getContextPath()%>/framework/js/validations.js"></Script>
    <script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
    <script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
    <script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/DynaLookup.js'></script>
     <Script language ="JavaScript" src ='<%=request.getContextPath()%>/core/lookup/js/Lookup.js'></Script>
    <script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
    <script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
    <Script Language="JavaScript" src="<%=request.getContextPath()%>/eLC/RepLCMasterCodes/js/LinenMasterCodes.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>' />
<IBATagLibs:initCalendar /> 			
</head>
	<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<ibaHTML:form action="/RepLinenMasterCodesAction.do" target="messageFrame" method="GET">
			<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
			<tr>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td align="right" class="label">
						<ibaBean:message key="com.iba.ehis.lc.sourceType" bundle="lcLabels" />
							</td>
								<td>
									<ibaHTML:select property="vo.sourceType">
										<ibaHTML:option value="W"><ibaBean:message key="com.iba.ehis.lc.select" bundle="lcLabels" /></ibaHTML:option>
										<ibaHTML:option value="W"><ibaBean:message key="com.iba.ehis.lc.ward" bundle="lcLabels" /></ibaHTML:option>
										<ibaHTML:option value="C"><ibaBean:message key="com.iba.ehis.lc.clinic" bundle="lcLabels" /></ibaHTML:option>
										<ibaHTML:option value="D"><ibaBean:message key="com.iba.ehis.lc.department" bundle="lcLabels" /></ibaHTML:option>
									</ibaHTML:select>
								</td>
							<td>
						</td>
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
				<td align="right" class="label">
					<ibaBean:message key="com.iba.ehis.lc.sourceCode" bundle="lcLabels" />
						</td>
							<td>
								<ibaHTML:text property="vo.sourceCodeFrom" size="30" maxlength="30"/>
									<input type='hidden' name="sourceCodeHiddenFrom" id="sourceCodeHiddenFrom" value=''/>
										<input type='button' class='button' value='?' onClick="showLookup('standardStock','SCLookupFrom');" />
									</td>
								<td>
							<ibaHTML:text property="vo.sourceCodeTo" size="30" maxlength="30"/>
						<input type='hidden' name="sourceCodeHiddenTo" id="sourceCodeHiddenTo" value=''/>
					<input type='button' class='button' value='?' onClick="showLookup('standardStock','SCLookupTo');" />
				</td>
			</tr>
			<tr>
				<td align="right" class="label">
					<ibaBean:message key="com.iba.ehis.lc.linenItem" bundle="lcLabels" />
						</td>
							<td>
								<ibaHTML:text property="vo.linenItemFrom" size="30" maxlength="30"/>
									<input type='hidden' name="linenItemHiddenFrom" id="linenItemHiddenFrom" value=''/>
										<input type='button' class='button' value='?' onClick="showLookup('standardStock','LILookupFrom');" />
									</td>
								<td>
							<ibaHTML:text property="vo.linenItemTo" size="30" maxlength="30"/>
						<input type='hidden' name="linenItemHiddenTo" id="linenItemHiddenTo" value=''/>
					<input type='button' class='button' value='?' onClick="showLookup('standardStock','LILookupTo');" />
				</td>
			</tr>
			<tr>
				<td align="right" class="label">
					<ibaBean:message key="com.iba.ehis.lc.groupby" bundle="lcLabels" />
						</td>
							<td>
								<ibaHTML:select property="vo.groupBy">
									<ibaHTML:option value="S"><ibaBean:message key="com.iba.ehis.lc.returnoflinentolaundry.source" bundle="lcLabels" /></ibaHTML:option>
									<ibaHTML:option value="I"><ibaBean:message key="com.iba.ehis.lc.Item" bundle="lcLabels" /></ibaHTML:option>
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
				<ibaHTML:hidden property="vo.repId" value="LCRSSSRC"/>
	
				<INPUT TYPE="hidden" name="facility_id" id="facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
				<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%= session.getValue( "facility_id" ) %>"/>
	
				<INPUT TYPE="hidden" name="user_id" id="user_id" VALUE="<%= session.getValue( "login_user" ) %>">
				<input type="hidden" name="p_user_id" id="p_user_id"	value="<%= session.getValue( "login_user" ) %>"/>
				
				<input type="hidden" name="p_module_id" id="p_module_id" value="LC">
				<input type="hidden" name="module_id" id="module_id" value="LC">
	
				<input type="hidden" name="p_report_id" id="p_report_id" value="LCRSSSRC">
				<input type="hidden" name="report_id" id="report_id" value="LCRSSSRC"/>
		
				<input type='hidden' name='locale' id='locale' value='<%=language_Id%>'>
				<input type='hidden' name='p_language_id' id='p_language_id' value='<%=language_Id%>'>
				<input type='hidden' name='facilityId' id='facilityId' value='<%=facilityId%>'>
						
				<input type='hidden' name='P_Linen_Item_From' id='P_Linen_Item_From' value=''>
				<input type='hidden' name='P_Linen_Item_To' id='P_Linen_Item_To' value=''>
				<input type='hidden' name='P_Source_Code_From' id='P_Source_Code_From' value=''>
				<input type='hidden' name='P_Source_Code_To' id='P_Source_Code_To' value=''>
				<input type='hidden' name='P_Source_Type' id='P_Source_Type' value=''>
				<input type='hidden' name='P_Facility_ID' id='P_Facility_ID' value='<%=facilityId%>'>
		</ibaHTML:form>
	</body>
</html>

