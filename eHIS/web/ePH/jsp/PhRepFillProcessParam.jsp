<!DOCTYPE html>
<!--
/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			     Description
--------------------------------------------------------------------------------------------------------------
?				100					?                created
06/05/2021		TFS-15598       Prabha          MOHE-CRF-0074
---------------------------------------------------------------------------------------------------------------
*/ --> 
 <%-- saved on 03/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.sql.*, webbeans.eCommon.*" %> <!-- Modified for MOHE-CRF-0074 -->
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
	<%

    request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	//
    String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
   (String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<!-- import the calendar script -->
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<!-- <SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT> -->
	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/PhRepFillProcess.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>
<%
Connection con			= null;  // Added for MOHE-CRF-0074 - start
try{
	 con				= ConnectionManager.getConnection(request);
	boolean region_check = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","REGION_CHECK");
	// Added for MOHE-CRF-0074 - END
	String sys_date		=	"";
	String ph_bean_id	=	"PhProcessFillBean";
	String ph_bean_name	=	"ePH.PhProcessFillBean";
	String order_facility_id="";
	String order_facility_name="";
	String p_user_name= (String) session.getValue( "login_user" ) ;	
	String facility_id= (String) session.getValue( "facility_id" ) ;	

	PhProcessFillBean phbean = (PhProcessFillBean)getBeanObject( ph_bean_id,ph_bean_name,request) ;
	sys_date=(String) phbean.getSysdate();
	phbean.setLanguageId(locale);
  	ArrayList OrderingFacility=phbean.getOrderingFacilityId(p_user_name);
	
  	String region_code = phbean.getRegionCode(); //Added for MOHE-CRF-0074
	ArrayList region_code_check = phbean.getRegionCheck(p_user_name,region_code); //Added for MOHE-CRF-0074

%>
<!-- <BODY> -->
<body onMouseDown="" onKeyDown="lockKey()">
<BR>
<FORM name="formPhRepFillProcess" id="formPhRepFillProcess" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame">
<TABLE WIDTH="70%" ALIGN="center" CELLPADDING="0" CELLSPACING="0" BORDER="0">
		<TH COLSPAN="5" ALIGN="left"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
		<TR ><TD COLSPAN=5>&nbsp;</TD></TR>
		<TR>
			<TD ALIGN="right" WIDTH="20%" CLASS="label"><fmt:message key="ePH.FillProcessDate.label" bundle="${ph_labels}"/>&nbsp;</TD>
			<TD ALIGN="left" COLSPAN="4">
			<INPUT TYPE=text name="p_fill_proc_dt1" id="p_fill_proc_dt1" SIZE="6" maxlength="10" VALUE="<%=com.ehis.util.DateUtils.convertDate(sys_date,"DMY","en",locale)%>" onBlur='if(CheckDateT(this)) fillComboOptions(this)'><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="showCalendar('p_fill_proc_dt1');document.formPhRepFillProcess.p_fill_proc_dt1.focus();return false;" >&nbsp;
			<img src="../../eCommon/images/mandatory.gif" align="center"></img></TD>
		 <INPUT TYPE="hidden" name="p_fill_proc_dt" id="p_fill_proc_dt" VALUE=""> 
		</TR>
		<TR ><TD COLSPAN=5>&nbsp;</TD></TR>
		<TR>
			<TD ALIGN="right" WIDTH="20%" CLASS="label"><fmt:message key="ePH.FillProcessType.label" bundle="${ph_labels}"/>&nbsp;</TD>
			<TD ALIGN="left" COLSPAN="4">
			<SELECT name="p_fill_proc_ty" id="p_fill_proc_ty" onChange="fillComboOptions(this)">
				<option>&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;</option>
				<OPTION value="R"><fmt:message key="Common.routine.label" bundle="${common_labels}"/></OPTION>
				<OPTION value="I"><fmt:message key="ePH.Incremental.label" bundle="${ph_labels}"/></OPTION>
			</SELECT>&nbsp;
			<img src="../../eCommon/images/mandatory.gif" align="center"></img></TD>
		</TR>
		<TR ><TD COLSPAN=5>&nbsp;</TD></TR>
		<TR>
			<TD ALIGN="right" WIDTH="20%" CLASS="label"><fmt:message key="ePH.FillProcessID.label" bundle="${ph_labels}"/>&nbsp;</TD>
			<TD ALIGN="left" COLSPAN="4">
			<SELECT name="p_fill_proc_id" id="p_fill_proc_id" onchange="clearTextFlds()"><OPTION>&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;</OPTION>
			</SELECT>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></img></TD>
		</TR>
		<TR ><TD COLSPAN=5>&nbsp;</TD></TR>
		<TR>
			<TD WIDTH="20%">&nbsp;</TD>
			<TD ALIGN="left" WIDTH="20%" CLASS="label"><fmt:message key="Common.from.label" bundle="${common_labels}"/></TD>
			<TD ALIGN="left" WIDTH="20%" CLASS="label" COLSPAN="3"><fmt:message key="Common.to.label" bundle="${common_labels}"/></TD>
		</TR>
		<TR>
			<TD align="right" class="label" nowrap><fmt:message key="Common.OrderingFacility.label" bundle="${common_labels}"/></TD>
			<TD  align="left" colspan="2"><select name="p_ord_facility_id" id="p_ord_facility_id">
<% 				if(region_check){ // MOHE-CRF-0074-Start
				   for (int i=0;i<region_code_check.size();i+=2){
						order_facility_id=(String)region_code_check.get(i);
					order_facility_name=(String)region_code_check.get(i+1);
							if(facility_id.equals(order_facility_id))	{
%>
									<option value='<%=order_facility_id%>' selected><%=order_facility_name%></option>
							<%
							}
							else{
%>
									<option value='<%=order_facility_id%>'><%=order_facility_name%></option>
<%	
								}
							}
					 }else{ // MOHE-CRF-0074-End
								for (int i=0;i<OrderingFacility.size();i+=2){
									order_facility_id=(String)OrderingFacility.get(i);
									order_facility_name=(String)OrderingFacility.get(i+1);
									 if(facility_id.equals(order_facility_id))	{
							%>
								<option value='<%=order_facility_id%>'selected><%=order_facility_name%></option>
								
							<%}else{%>
								  <option value='<%=order_facility_id%>'><%=order_facility_name%></option>
							   <%}
							}
					} //Added for MOHE-CRF-0074
							%>
					</select> 
					</TD>
					</TR>

		<TR>
			<TD ALIGN="right" WIDTH="20%" CLASS="label"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>&nbsp;</TD>
			<TD ALIGN="left" WIDTH="20%" >
			<INPUT TYPE=text name="p_fr_nurs_unit" id="p_fr_nurs_unit" SIZE="10" maxlength="10" readonly ><INPUT TYPE="button" name="nursunitFrom" id="nursunitFrom" VALUE="?" CLASS="button"  onclick="searchCode(p_fr_nurs_unit)"></TD>
			<TD ALIGN="left" WIDTH="20%" CLASS="label" COLSPAN="3">
			<INPUT TYPE=text name="p_to_nurs_unit" id="p_to_nurs_unit" SIZE="10" maxlength="10" readonly ><INPUT TYPE="button" name="nursunitTo" id="nursunitTo" VALUE="?" CLASS="button" onclick="searchCode(p_to_nurs_unit)"></TD>
			
		</TR>
		<TR>
			<TD align="right" class="label" name="disp_dispensingFacility_col"  nowrap>
			 <fmt:message key="ePH.DispensingFacility.label" bundle="${ph_labels}"/></TD>
			<TD  align="left" colspan="2"><select name="p_disp_facility_id" id="p_disp_facility_id" >
<% 					if(region_check){ // Added for MOHE-CRF-0074-Start
						   for (int i=0;i<region_code_check.size();i+=2){
								order_facility_id=(String)region_code_check.get(i);
							order_facility_name=(String)region_code_check.get(i+1);
								if(facility_id.equals(order_facility_id))	{
%>
										<option value='<%=order_facility_id%>' selected><%=order_facility_name%></option>
								 <%
								}
								else{
%>
										<option value='<%=order_facility_id%>'><%=order_facility_name%></option>
<%	
									}
								}
						 }else{ //Added for MOHE-CRF-0074 - End
								for (int i=0;i<OrderingFacility.size();i+=2){
									order_facility_id=(String)OrderingFacility.get(i);
									order_facility_name=(String)OrderingFacility.get(i+1);
									 if(facility_id.equals(order_facility_id))	{
							%>
								<option value='<%=order_facility_id%>'selected><%=order_facility_name%></option>
								
							<%}else{%>
								  <option value='<%=order_facility_id%>'><%=order_facility_name%></option>
							   <%}
							}
						 } //Added for MOHE-CRF-0074
							%>
                           
					</select> 
					</TD>
					</TR>
		<TR ><TD COLSPAN=5>&nbsp;</TD></TR>

	</TABLE>

	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHRFILLPR">
	<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="sys_dt" id="sys_dt" VALUE="<%=sys_date%>">
	<input TYPE='hidden' name='ph_bean_id' id='ph_bean_id' value='<%=ph_bean_id%>'>
	<input TYPE='hidden' name='ph_bean_name' id='ph_bean_name' value='<%=ph_bean_name%>'>
	<input TYPE='hidden' name='locale' id='locale' value='<%=locale%>'>
	
<% putObjectInBean(ph_bean_id,phbean,request); %>
</FORM>
	<INPUT TYPE="hidden" name="SQL_PH_REPORTS_NURSUNIT_LOOKUP" id="SQL_PH_REPORTS_NURSUNIT_LOOKUP" VALUE="<%= PhRepository.getPhKeyValue( "SQL_PH_REPORTS_NURSUNIT_LOOKUP" ) %>">
</BODY>
<%} // Added for MOHE-CRF-0074 - start
catch(Exception e){
	e.printStackTrace();
}
finally{ 
	if(con != null)
		ConnectionManager.returnConnection(con,request);	
}
%> <!-- Added for MOHE-CRF-0074 - End -->
</HTML>

