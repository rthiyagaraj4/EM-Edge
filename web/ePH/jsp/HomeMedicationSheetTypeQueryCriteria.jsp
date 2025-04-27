<!DOCTYPE html>
 <%@ page import ="java.util.*,java.sql.*,webbeans.eCommon.*" %>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<HTML>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String sql_ph_home_med_type_lookup=PhRepository.getPhKeyValue("SQL_PH_HOME_MEDN_SHEET_TYPE_QUERY");
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script language="Javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
		<Script language='JavaScript' src='../../eCommon/js/CommonResult.js'></Script>
		<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/HomeMedicationSheetType.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	</head>
	<body onMouseDown="CodeArrest();" onKeyDown="lockKey()" topmargin="0">
<%
		java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		String login_at_ws_no		        = prop.getProperty( "client_ip_address" );
		String bean_id		= "@HomeMednSheetBean" ;
		String bean_name	= "ePH.HomeMednSheetBean";
		String mode			= request.getParameter("mode");

		HomeMednSheetBean bean = (HomeMednSheetBean)getBeanObject( bean_id,bean_name,request) ;
		bean.clear();
		bean.setLanguageId(locale);
		bean.setMode( mode ) ;
%>
		<form name='med_query_form' id='med_query_form' method='post' action='HomeMedicationSheetTypeQueryResult.jsp' onsubmit='SelectAll()'>
			<table cellpadding=0 cellspacing=0 width="98%" align="center" border="0">
				<TR>
					<td  ALIGN="Center" COLSPAN="4"> &nbsp;    </td>
				</TR>
				<TR>
					  <TH  ALIGN="Left" COLSPAN="10" width='20%'> <fmt:message key="Common.QueryCriteria.label" bundle="${common_labels}"/>    </TH>
				</TR>
				<TR><td  ALIGN="Center" COLSPAN="4"> &nbsp;</td></TR>
				<tr> 
					<td  class="label" >
						<fmt:message key="ePH.HOME_MEDICATION_SHEET.label" bundle="${ph_labels}"/>
					</td>
					<td class="label" >
						<select name="home_medn_sheet_type" id="home_medn_sheet_type" onChange="">
								<option value="I"><fmt:message key="ePH.Include.label" bundle="${ph_labels}"/></option>
								<option value="S"><fmt:message key="ePH.Separate.label" bundle="${ph_labels}"/></option>
								<option value="O"><fmt:message key="ePH.Only.label" bundle="${ph_labels}"/></option>
							</select>
					</td>
				</tr>
				<TR><td  ALIGN="Center" COLSPAN="4"> &nbsp;</td></TR>
				<TR><td  ALIGN="Center" COLSPAN="4"> 
					<table width='100%' align='center' >
						<tr>
							<th align='left' >
							<fmt:message key="Common.SortOrder.label" bundle="${common_labels}"/> </th>
						</tr>
						<tr>
							<td width='60%' > 
							<table width='100%'align='center' >
								<tr>
									<td align='center'><b><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
									<td>&nbsp;</td>
									<td align='center'><b><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
								</tr>
								<tr>
									<td width='45%' align='center'>
									<select name='orderbycols' id='orderbycols' size='6' >
										<option value='form_desc'><fmt:message key="ePH.FormDescription.label" bundle="${ph_labels}"/></option>
									 </select>
									</td>
									<td align='center' width='3%' >
										<input type='button' name='add' id='add' class='button' onclick='addOrderByCol()' value='---->'> 
										<input type='button' name='add' id='add' class='button'  value='<----' onclick='removeOrderByCol()'></img>
									</td>
									<td width='45%' align='center'>
										<select name='orderbycolumns' id='orderbycolumns' size='6' multiple='true'>
											<option value='form_code'><fmt:message key="ePH.FormCode.label" bundle="${ph_labels}"/></option>
										</select>
									</td>
								</tr>
							</table>
							</td>
						</tr>
					</table>
					</td>
				</tr>
			</table>
			
			<br>
			<table border='0' width='100%' align='center'><tr><td width='100%' align='center' class='white'><input type='button' name='ExecuteQuery' id='ExecuteQuery' class='Button' onclick="execQuery()" value="Execute" ></td></tr>
			</table>

			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="mode" id="mode" value="<%=mode%>">	
			<input type="hidden" name="locale" id="locale" value="<%=locale%>">
			<input type="hidden" name="sql_ph_home_med_type_lookup" id="sql_ph_home_med_type_lookup" value="<%=sql_ph_home_med_type_lookup%>">
			
		</form>
	</body>
</HTML>

