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
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
	<HEAD>
		<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String p_user_name= (String) session.getValue( "login_user" ) ;	
		String facility_id= (String) session.getValue( "facility_id" ) ;	
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<LINK REL="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></LINK>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../js/PhRepPatFill.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" src="../../eCommon/js/CommonCalendar.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../js/PhRepIPFillLabel.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>
	<body onMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<%
Connection con			= null;  // Added for MOHE-CRF-0074 - start
try{
	 con				= ConnectionManager.getConnection(request);
	boolean region_check = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","REGION_CHECK");
	// Added for MOHE-CRF-0074 - END
		String bean_id1				= "PHReportsBean" ;
		String bean_name1			= "ePH.PHReportsBean";
		ePH.PHReportsBean  phbean	= (ePH.PHReportsBean)getBeanObject( bean_id1,bean_name1,request) ;
		phbean.setLanguageId(locale);
		ArrayList OrderingFacility=phbean.getOrderingFacilityId(p_user_name);
		// String selected			="";
		String medicationlist_flag	="";
		String order_facility_id	="";
		String order_facility_name	="";
		//String p_nursing_unit		="";
		medicationlist_flag= request.getParameter("medicationlist_flag");
		/*if(medicationlist_flag.equals("Y")){
		   disabled="disabled";
		  selected="selected";
		}
		else if(medicationlist_flag.equals("N")){
		  disabled="";
		  selected="";
		}*/
		String region_code = phbean.getRegionCode(); //Added for MOHE-CRF-0074
		ArrayList region_code_check = phbean.getRegionCheck(p_user_name,region_code); //Added for MOHE-CRF-0074
%> 
		<FORM name="formPHRepIPFillLabel" id="formPHRepIPFillLabel" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame">
			<TABLE WIDTH="90%" ALIGN="center" CELLPADDING="0" CELLSPACING="0" BORDER="0">
				<TR>
					<td class="label" align="right"><fmt:message key="Common.OrderingFacility.label" bundle="${common_labels}"/>&nbsp;</td>
					<td colspan="7">&nbsp;&nbsp;<select name="p_ord_facility_id" id="p_ord_facility_id">
<%
				if(region_check){ // MOHE-CRF-0074-Start
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
<%
					}
					else{
%>
		   			<option value='<%=order_facility_id%>'><%=order_facility_name%></option>
<%
					}
				}
			} //Added for MOHE-CRF-0074
%>
				</SELECT>
				</td>
			</tr>
			<TR>
<%
			 if(medicationlist_flag.equals("Y")){
%>    
				<INPUT TYPE="hidden" name="report_by" id="report_by" VALUE="PHRPATMEDLIST">
<%
			}
			else if(medicationlist_flag.equals("N")){
%>
				<TD CLASS="label" ALIGN="right"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/> </TD>
				<TD >&nbsp;&nbsp;
				<INPUT TYPE="text" maxlength=20 name="p_nursing_unit" id="p_nursing_unit" >
				<INPUT TYPE="button" CLASS="button" VALUE="?" onClick="searchNursingUnit(p_nursing_unit)" >
				<img src="../../eCommon/images/mandatory.gif" align="center"></img></TD>
				<TD ALIGN="right" WIDTH="30%" CLASS="label"><fmt:message key="ePH.FillProcessID.label" bundle="${ph_labels}"/>&nbsp;</TD>
				<TD ALIGN="left" COLSPAN="4">&nbsp;&nbsp; 
				<SELECT name="p_fill_proc_id" id="p_fill_proc_id"  onChange="getDispNos(this)"><OPTION>
				&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;</OPTION>
				</SELECT>

				<img src="../../eCommon/images/mandatory.gif" align="center"></img>
				</TD>
			</TR>		
				<TR style="visibility:hidden">	
					<td align="right"  class="label" nowrap WIDTH="20%"><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
					<td align="left">&nbsp;&nbsp;
					<select name="p_order_type" id="p_order_type" onChange="populateDispNo();showLabelDetail(this);setStage(this);" disabled>
					<option value="NRx" selected ><fmt:message key="ePH.NormalRx.label" bundle="${ph_labels}"/></option>
					<option value="IVWA"  ><fmt:message key="Common.IVwithAdditives.label" bundle="${common_labels}"/></option>
					<option value="IVWTA" ><fmt:message key="ePH.IVwithoutAdditives.label" bundle="${ph_labels}"/></option>
					<option value="IVIM" ><fmt:message key="ePH.IVIntermittent.label" bundle="${ph_labels}"/></option>
					<option value="Onc" ><fmt:message key="ePH.Oncology.label" bundle="${ph_labels}"/></option>
					</select>
					</td>
					<td></td>
					<td></td>
			    </TR> 
<%
			}
%> 
			</TABLE>
			<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
			<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
			<INPUT TYPE="hidden" name="SQL_PH_DISP_MEDICATION_SELECT32" id="SQL_PH_DISP_MEDICATION_SELECT32" value="<%=PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT32")%>"> 
			<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
			<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHIPFILLPROCLBL">
			<INPUT TYPE="hidden" name="bean_id1" id="bean_id1" VALUE="<%=bean_id1%>">
			<INPUT TYPE="hidden" name="bean_name1" id="bean_name1" VALUE="<%=bean_name1%>">
			<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>">
			<INPUT TYPE="hidden" name="nunit" id="nunit" >
			<INPUT TYPE="hidden" name="p_fill_prc_id" id="p_fill_prc_id" value=""> 
			<INPUT TYPE="hidden" name="p_disp_fm_no" id="p_disp_fm_no" value=""> 
			<INPUT TYPE="hidden" name="p_disp_to_no" id="p_disp_to_no" value=""> 
			<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
			<% putObjectInBean(bean_id1,phbean,request); %>
		</FORM>
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

