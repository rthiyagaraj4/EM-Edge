<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*,java.sql.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
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
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../js/PhCommon.js"></SCRIPT>
		<script language="JavaScript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../js/AltDispLocn.js"></SCRIPT>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		<script type="text/javascript">
			async function searchSourceLocationAndSetDispenseLocation (){
				await searchLocationName();
				getdisploc();
			}
		</script>
	</HEAD>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<%
		String mode	= request.getParameter( "mode" ) ;
				
		String bean_id			=	"AltDispLocnBean" ;
		String bean_name		=	"ePH.AltDispLocnBean";
		String ord_src_code1	=	"";
		String ORDER_SRC_CODE="";
		String alt_disp_locn_code="";   
		String  working_hours_from = "00:00";               
		String  working_hours_to = "00:00";
		//String sql2 = PhRepository.getPhKeyValue( "SQL_PH_ALT_DISP_LOCN_SELECT1D" );
		String sql2 = "SELECT NURSING_UNIT_CODE CODE, LONG_DESC DESCRIPTION  FROM IP_NURSING_UNIT_LANG_VW IP_NURSING_UNIT WHERE UPPER(FACILITY_ID) LIKE UPPER(?) AND UPPER(PATIENT_CLASS) LIKE UPPER(?) AND Upper(NURSING_UNIT_CODE) like Upper(?) AND Upper(LONG_DESC) LIKE Upper(?) AND EFF_STATUS='E' AND LANGUAGE_ID = ";
		//String sql3 = PhRepository.getPhKeyValue( "SQL_PH_ALT_DISP_LOCN_SELECT1E" );
		String sql3 = "SELECT CLINIC_CODE CODE, LONG_DESC DESCRIPTION  FROM OP_CLINIC_LANG_VW OP_CLINIC WHERE  UPPER(FACILITY_ID) LIKE UPPER(?) AND UPPER(CLINIC_TYPE) LIKE UPPER(?)  AND Upper(CLINIC_CODE) like Upper(?) AND Upper(LONG_DESC) LIKE Upper(?) AND EFF_STATUS='E'  AND  LANGUAGE_ID = ";
		String facility_id	= (String) session.getValue( "facility_id" ) ;
		String facility_name = "";
		ArrayList facilities = new ArrayList();
		if ( mode == null || mode.equals("") )
			return ;

		if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) ) ) )
			return ;

		AltDispLocnBean bean = (AltDispLocnBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.setLanguageId(locale);

		bean.clear() ;
		bean.setMode(mode) ;
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
		String logged_fcy = bean.getLoggedInFacility();

		facilities = bean.getFacilities();
		String SEL1 ="";
		for (int i=0; i<facilities.size(); i += 2) {
			if(facility_id.equals((String)facilities.get(i))) {
				facility_name = (String)facilities.get(i+1);
			}
		}
%>
		<Form name = "AltDispLocnHeaderForm" id = "AltDispLocnHeaderForm">
<%
			if ((mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) )||(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )  ) )) {
				ArrayList facilities1 = bean.getFacilities();
				if (facilities1.size() != 0) {
%>
					<TABLE CELLPADDING="2" CELLSPACING="2" WIDTH="95%" ALIGN="center" BORDER="0">
						<TR>
							<TH COLSPAN="3"><fmt:message key="ePH.OrderingLocationDetail.label" bundle="${ph_labels}"/></TH>
						</TR>
						 <TR>
							<TD WIDTH="10%" CLASS="label"><fmt:message key="Common.OrderingFacility.label" bundle="${common_labels}"/></TD>
							<TD colspan='2' class ="label" name="ORDER_FCY"  style="font-size:xxx-medium;font-weight:bold"onchange=""><%=facility_name%></TD>
						</tr>
						<tr>
							<TD WIDTH="10%" CLASS="label"><fmt:message key="ePH.OrderingSourceType.label" bundle="${ph_labels}"/></TD>
							<TD colspan='2' class ="label"><SELECT name="ORDER_SRC_TYPE" id="ORDER_SRC_TYPE"  onchange="sendbl();searchBasedOnCriteria(this)"  >
							<OPTION VALUE="">---- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----</OPTION>
							<OPTION  VALUE="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></OPTION>
							<OPTION  VALUE="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></OPTION>
							<OPTION  VALUE="E"><fmt:message key="Common.ProcedureUnit.label" bundle="${common_labels}"/></OPTION>
							<OPTION  VALUE="D"><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></OPTION>
							</SELECT>&nbsp;<IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"></IMG>  
							</TD>
						</TR>
						<TR>
							<TD WIDTH="30%" CLASS="label"><fmt:message key="ePH.OrderingSourceLocation.label" bundle="${ph_labels}"/> </TD>
							<TD COLSPAN="2" class ="label">			
							<INPUT TYPE="text" name="ORDER_SRC_LOCN1" id="ORDER_SRC_LOCN1"  STYLE='overflow:visible;'><!--SIZE="30" MAXLENGTH="30" removed and STYLE='overflow:visible;' added for ML-MMOH-CRF-0752-->
							<INPUT TYPE="button" name="LOCATION_SEARCH" id="LOCATION_SEARCH" CLASS="button" VALUE="?" onClick='searchSourceLocationAndSetDispenseLocation();'><IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0" STYLE="visibility:visible" ID="longdesc_mandate"></IMG><INPUT TYPE="hidden"	name="ord_src_code1" id="ord_src_code1" VALUE="<%=ord_src_code1%>"onChange="">
							</TD>
						</TR>
						<TR>
							<td class="label"> <fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
							<td colspan="2" class ="label"><SELECT name="LOCN_BS_ORDRS" id="LOCN_BS_ORDRS"  onchange="sendbl()"  >
								<OPTION  VALUE="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></OPTION>
								<OPTION  VALUE="R"><fmt:message key="Common.routine.label" bundle="${common_labels}"/></OPTION>
								<OPTION  VALUE="S"><fmt:message key="Common.Stat.label" bundle="${common_labels}"/></OPTION>
								<OPTION  VALUE="D"><fmt:message key="Common.Discharge.label" bundle="${common_labels}"/></OPTION>
							</td>
						</TR>	
						<TR>
							<td class="label"><fmt:message key="ePH.RoutingLevel.label" bundle="${ph_labels}"/></td>
							<td colspan="2" class="label">
								<select name="routing_level" id="routing_level" onChange="loadRoutingLevelRelatedElements(this);sendbl();"  id="Routing Level">
									<!--
									<option value="S"><fmt:message key="Common.source.label" bundle="${common_labels}"/></option> -->
									<OPTION  VALUE="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></OPTION>
									<option value="O"><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></option>
									<option value="D" selected><fmt:message key="ePH.DrugClass.label" bundle="${ph_labels}"/></option>
									<option value="G"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></option>
									<option value="L"><fmt:message key="ePH.SpecialOrders.label" bundle="${ph_labels}"/></option>
									<OPTION value="M" ><fmt:message key="Common.MedicalItem.label" bundle="${common_labels}"/></OPTION>
									<!-- <OPTION value="H" ><fmt:message key="ePH.HomeLeave.label" bundle="${ph_labels}"/></OPTION>added for Bru-HIMS-CRF-093[29960] -->
								</select>&nbsp;
								<select name="routing_code" id="routing_code" id="RoutingCode" style="display:inline" onchange="sendbl()"> 
									<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
									<option value="G"><fmt:message key="Common.general.label" bundle="${common_labels}"/></option>
									<option value="N"><fmt:message key="ePH.Narcotics.label" bundle="${ph_labels}"/></option>
									<option value="C"><fmt:message key="ePH.Controlled.label" bundle="${ph_labels}"/></option>
								</select>
								<input type="text" name="drug_desc" id="drug_desc" style="display:none;" size="45" maxlength="30" >
								<input type="button" value="?" name="btnDrug" id="btnDrug" style="display:none" class="button" onClick="searchForDrug(drug_desc)">
								<img src="../../eCommon/images/mandatory.gif" border="0" id="imgRoutingCode"></img>
								<input type="hidden" name="drug_code" id="drug_code">
							</td>
						</TR>
						<TR>
							<TD WIDTH="30%" CLASS="label"><fmt:message key="ePH.CurrentDispenseLocation.label" bundle="${ph_labels}"/></TD>
							<TD COLSPAN="2" class ="label">
								<SELECT name="CURR_DISP_LOC" id="CURR_DISP_LOC" value="" onchange="showtimings();sendbl()">
								<OPTION VALUE="" SELECTED>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</OPTION>
								</SELECT>&nbsp;<IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"></IMG>  
							</TD>
						</TR>	
						<tr>
							<TD WIDTH="30%" CLASS="label">&nbsp;<fmt:message key="ePH.WorkinghoursFrom.label" bundle="${ph_labels}"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </TD>
							<TD width="66%" COLSPAN="2" class ="label"><input type="text" name="Time_from" id="Time_from" size="3" maxlength="5" value= "<%=working_hours_from%>" onkeypress="return allowPositiveNumber();" onBlur="appedzero(this);" readOnly>&nbsp; &nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;&nbsp; <input type="text" name="Time_to" id="Time_to" size="3" maxlength="5" value="<%=working_hours_to%>"onkeypress="return allowPositiveNumber();"onChange="appedzero(this); comparetime1(frm_time,to_time)" readOnly>
						</tr>
						<TR>
							<TH COLSPAN="3"><fmt:message key="ePH.PerformingLocationDetail.label" bundle="${ph_labels}"/></TH>
						</TR>
						<TR>
							<TD WIDTH="30%" CLASS="label"><fmt:message key="Common.PerformingFacility.label" bundle="${common_labels}"/></TD>
							<TD colspan='2' class ="label">
								<SELECT name="PERFORM_FCY" id="PERFORM_FCY"  onChange="sendbl()">
								<OPTION VALUE="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</OPTION>
<%
								for (int i=0; i<facilities.size(); i += 2) {
									if(facility_id.equals(facilities.get(i))){
%>
										<OPTION VALUE="<%= facilities.get(i) %>" selected><%= facilities.get(i+1) %></OPTION>
<%
									}
									else{
%>
										<OPTION VALUE="<%= facilities.get(i) %>"><%= facilities.get(i+1) %></OPTION>
<%
									}
								}
%>		
								</SELECT>&nbsp;<IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"></IMG>  
							</TD>
						</TR>
						<TR>
							<TD WIDTH="20%" CLASS="label"><fmt:message key="ePH.DayType.label" bundle="${ph_labels}"/></TD>
							<TD class ="label"><SELECT name="day_type" id="day_type" onChange="sendbl()">
								<OPTION VALUE="">&nbsp;&nbsp;---- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----&nbsp;&nbsp;</OPTION>
								<OPTION VALUE="0"><fmt:message key="Common.Holidays.label" bundle="${common_labels}"/></OPTION>
								<OPTION VALUE="1"><fmt:message key="Common.sun.label" bundle="${common_labels}"/></OPTION>
								<OPTION VALUE="2"><fmt:message key="Common.mon.label" bundle="${common_labels}"/></OPTION>
								<OPTION VALUE="3"><fmt:message key="Common.tue.label" bundle="${common_labels}"/></OPTION>
								<OPTION VALUE="4"><fmt:message key="Common.wed.label" bundle="${common_labels}"/></OPTION>
								<OPTION VALUE="5"><fmt:message key="Common.thu.label" bundle="${common_labels}"/></OPTION>
								<OPTION VALUE="6"><fmt:message key="Common.fri.label" bundle="${common_labels}"/></OPTION>
								<OPTION VALUE="7"><fmt:message key="Common.sat.label" bundle="${common_labels}"/></OPTION>
								<OPTION VALUE="8" selected><fmt:message key="Common.AllDays.label" bundle="${common_labels}"/></OPTION>
								</SELECT>&nbsp;<IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"></IMG>
							</TD>
							<TD WIDTH="10%" align='right'>  <input type="button" class="BUTTON" name="btnSearch" id="btnSearch" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="CollectValues()">&nbsp;&nbsp;&nbsp;</td>
						</TR>
					</table>
					<INPUT TYPE="hidden"	name="mode" id="mode"					VALUE="<%= mode %>">
					<INPUT TYPE="hidden"	name="bean_id" id="bean_id"				VALUE="<%= bean_id %>">
					<INPUT TYPE="hidden"	name="bean_name" id="bean_name"			VALUE="<%= bean_name %>">
					<INPUT TYPE="hidden"	name="function_id" id="function_id"			VALUE="<%= bean.getFunctionId() %>">
					<INPUT TYPE="hidden"	name="facility_id" id="facility_id"			VALUE="<%=  logged_fcy %>">
					<INPUT TYPE="hidden"	name="disp_locn_code" id="disp_locn_code"		VALUE="<%=alt_disp_locn_code%>">
					<INPUT TYPE="hidden"	name="ORDER_SRC_LOCN" id="ORDER_SRC_LOCN"			VALUE="<%=ORDER_SRC_CODE%>"> 
					<INPUT TYPE="hidden"	name="order_src_code" id="order_src_code"			VALUE="<%=ORDER_SRC_CODE%>"> 
					<INPUT TYPE="hidden"	name="facility_name" id="facility_name"   VALUE="<%=facility_name%>">
					<INPUT TYPE="hidden"	name="sql1" id="sql1"   VALUE="<%=SEL1%>">
					<INPUT TYPE="hidden"	name="sql2" id="sql2"   VALUE="<%=sql2%>">
					<INPUT TYPE="hidden"	name="sql3" id="sql3"   VALUE="<%=sql3%>">
					<INPUT TYPE="hidden"	name="ORDER_FCY" id="ORDER_FCY"   VALUE="<%=logged_fcy%>">
					<INPUT TYPE="hidden"	name="language_id" id="language_id"   VALUE="<%=locale%>">
<%		
				}
				else{
%>
					<SCRIPT>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</SCRIPT>
<%
				}
			}
%>
		</FORM>
		<% putObjectInBean(bean_id,bean,request); %>
	</BODY>
</HTML>

