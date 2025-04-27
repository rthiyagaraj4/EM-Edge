<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8"%>
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
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>' />
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/MessageReader.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/IBADateValidator.js'></script>
	<Script Language="JavaScript" src="<%=request.getContextPath()%>/framework/js/common.js"></Script>
	<Script Language="JavaScript" src="<%=request.getContextPath()%>/framework/js/validations.js"></Script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<Script language ="JavaScript" src ='<%=request.getContextPath()%>/core/lookup/js/Lookup.js'></Script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/DynaLookup.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
	<Script Language="JavaScript" src="<%=request.getContextPath()%>/eLC/RepShortageofLinenSupply/js/ShortageofLinenSupply.js"></Script> 
		<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<IBATagLibs:initCalendar /> 			
</head>
	<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<br>
		<ibaHTML:form action="/RepShortageofLinenSupplyAction.do" target="messageFrame" method="GET">
			<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
			<tr>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td align="right" class="label">
						<ibaBean:message key="com.iba.ehis.lc.source" bundle="lcLabels" />
							</td>
								<td>			
									<ibaHTML:select property="vo.sourceType" onchange="clearSourceType();">
										<ibaHTML:option value="W"><ibaBean:message key="com.iba.ehis.lc.select" bundle="lcLabels" /></ibaHTML:option>
										<ibaHTML:option value="W"><ibaBean:message key="com.iba.ehis.lc.ward" bundle="lcLabels" /></ibaHTML:option>
										<ibaHTML:option value="C"><ibaBean:message key="com.iba.ehis.lc.clinic" bundle="lcLabels" /></ibaHTML:option>			
										<ibaHTML:option value="D"><ibaBean:message key="com.iba.ehis.lc.department" bundle="lcLabels" /></ibaHTML:option>				
									</ibaHTML:select>
								</td>
							<td>
								<ibaHTML:text property="vo.sourceCode" size="30" maxlength="30" onblur="showLookup('sourceCode');"/>
							<input type='hidden' name="sourceCodeHidden" id="sourceCodeHidden" value=''/>
						<input type='button' class='button' value='?' onClick="showLookup('sourceCode');" />
					</td>
				</tr>
				<tr>
					<td align="right" class="label">
						<ibaBean:message key="com.iba.ehis.lc.linenItem" bundle="lcLabels" />
							</td>
								<td>
									<ibaHTML:text property="vo.linenItem" size="30" maxlength="30" onblur="showLookup('linenItem');"/>
									<input type='hidden' name="linenItemHidden" id="linenItemHidden" value=''/>
								<input type='button' class='button' value='?' onClick="showLookup('linenItem');" />
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
									
						<INPUT TYPE="hidden" name="facility_id" id="facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
						<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%= session.getValue( "facility_id" ) %>"/>
			
						<INPUT TYPE="hidden" name="user_name" id="user_name" VALUE="<%= session.getValue( "login_user" ) %>">
						<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= session.getValue( "login_user" ) %>"/>
						
						<input type="hidden" name="p_module_id" id="p_module_id" value="LC">
						<input type="hidden" name="module_id" id="module_id" value="LC">
			
						<input type="hidden" name="p_report_id" id="p_report_id" value="LCRSGLNS">
						<input type="hidden" name="report_id" id="report_id" value="LCRSGLNS"/>
				
						<input type='hidden' name='locale' id='locale' value='<%=language_Id%>'>
						<input type='hidden' name='p_language_id' id='p_language_id' value='<%=language_Id%>'>
						<input type='hidden' name='dateFormate' id='dateFormate' value='dd/MM/yyyy HH:mm'>
						<input type='hidden' name='facility_Id' id='facility_Id' value='<%=facilityId%>'>
												
						<input type='hidden' name='P_Linen_Item' id='P_Linen_Item' value=''>
						<input type='hidden' name='P_Source' id='P_Source' value=''>
						<input type='hidden' name='P_Source_Type' id='P_Source_Type' value=''>
		</ibaHTML:form>
	</body>
</html>

