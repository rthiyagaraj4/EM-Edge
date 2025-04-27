<!DOCTYPE html>
<!--

/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			     Description
--------------------------------------------------------------------------------------------------------------
?				100					?               	 created
02/04/2024		 			       Himanshu           GHL-CRF-0672.1
---------------------------------------------------------------------------------------------------------------
*/ --> 
 <%-- saved on 03/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.sql.*, webbeans.eCommon.*" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>


<HTML>
<HEAD>
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
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<!-- <SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/PhRepFillProcess.js"></SCRIPT>-->
		<SCRIPT LANGUAGE="javascript" SRC="../js/PHPickListReport.js"></SCRIPT>
		

</HEAD>
<%
Connection con			= null;  
try{
	 con				= ConnectionManager.getConnection(request);
	boolean region_check = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","REGION_CHECK");
	
	String sys_date		=	"";
	String ph_bean_id	=	"PhProcessFillBean";
	String ph_bean_name	=	"ePH.PhProcessFillBean";
	
	String bean_id = "PHPickListBean" ;
	String bean_name = "ePH.PHPickListBean";
	/* Initialize Function specific start */
	PHPickListBean bean = (PHPickListBean)getBeanObject(bean_id, bean_name, request ) ;
	
	String order_facility_id="";
	String order_facility_name="";
	String p_user_name= (String) session.getValue( "login_user" ) ;	
	String facility_id= (String) session.getValue( "facility_id" ) ;	

	PhProcessFillBean phbean = (PhProcessFillBean)getBeanObject( ph_bean_id,ph_bean_name,request) ;
	sys_date=(String) phbean.getSysdate();
	phbean.setLanguageId(locale);
  	ArrayList OrderingFacility=phbean.getOrderingFacilityId(p_user_name);
	ArrayList disp_locn		=	bean.getDispLocns(locale);

%>
<!-- <BODY> -->
<body onMouseDown="" onKeyDown="lockKey()">
<BR>
<FORM name="formPhReppicklistProcess" id="formPhReppicklistProcess" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame">
<TABLE WIDTH="70%" ALIGN="center" CELLPADDING="0" CELLSPACING="0" BORDER="0">
		<TH COLSPAN="5" ALIGN="left"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
		<TR ><TD COLSPAN=5>&nbsp;</TD></TR>
		<TR>
			<TD ALIGN="right" WIDTH="20%" CLASS="label"><fmt:message key="ePH.PickListProccessDate.label" bundle="${ph_labels}"/>&nbsp;</TD>
			<TD ALIGN="left" COLSPAN="4">
			<INPUT TYPE=text name="p_proc_date_view" id="p_proc_date_view" disabled SIZE="10" maxlength="10" VALUE="<%=com.ehis.util.DateUtils.convertDate(sys_date,"DMY","en",locale)%>" onBlur='if(CheckDateT(this)) fillComboOptions(this)'>&nbsp;
			<img src="../../eCommon/images/mandatory.gif" align="center"></img></TD>
			<INPUT TYPE="hidden" name="p_proc_date" id="p_proc_date" VALUE="<%=com.ehis.util.DateUtils.convertDate(sys_date,"DMY","en",locale)%>">
		 <INPUT TYPE="hidden" name="p_fill_proc_dt" id="p_fill_proc_dt" VALUE=""> 
		</TR>
		
		
		<TR ><TD COLSPAN=5>&nbsp;</TD></TR>
		<TR>
			<TD WIDTH="20%">&nbsp;</TD>
			<TD ALIGN="left" WIDTH="20%" CLASS="label"><fmt:message key="Common.from.label" bundle="${common_labels}"/></TD>
			
		</TR>
		<TR>
			<TD align="right" class="label" nowrap><fmt:message key="Common.OrderingFacility.label" bundle="${common_labels}"/></TD>
			<TD  align="left"><select name="p_ord_facility_id" id="p_ord_facility_id">
<% 			
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
					
							%>
					</select> 
					</TD>
					</TR>
					<TR ><TD COLSPAN=5>&nbsp;</TD></TR>
					<TR >	
					<td class="label"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
					<td  ><select name="p_locncode" id="p_locncode">
					<option value="">&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;</option>
<% 
					for(int i=0; i<disp_locn.size();  i+=2){	
%>
							<option value="<%=(String)disp_locn.get(i)%>"><%=(String)disp_locn.get(i+1)%></option>
<%					
					}
%>
					</select><img src="../../eCommon/images/mandatory.gif" align="center"></img> </td>
					 </TR>
					 <TR ><TD COLSPAN=5>&nbsp;</TD></TR>
					
		<TR>
			<td class="label"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>&nbsp;</TD>
			<TD >
			<INPUT TYPE=text  name="p_fr_nurs_unit" id="p_fr_nurs_unit"  ><INPUT TYPE="button" name="nursunitFrom" id="nursunitFrom" VALUE="?" CLASS="button" onfocus="searchCode(p_fr_nurs_unit)" onclick="searchCode(p_fr_nurs_unit)"><img src="../../eCommon/images/mandatory.gif" align="center"></img></TD>
			
		</TR>
		<TR ><TD COLSPAN=5>&nbsp;</TD></TR>
		<TR>
		<td class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>&nbsp;</td>
			<TD><input type=text  name="p_patient_id" id="p_patient_id" ><INPUT TYPE="button" name="patient_id_Button" id="patient_id_Button" VALUE="?" CLASS="button"   onClick="callPatientSearch_report(document.formPhReppicklistProcess.p_patient_id)"></TD>
	</TR>
		
		
		
		
		<TR ><TD COLSPAN=5>&nbsp;</TD></TR>

	</TABLE>

	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHPICKLIST">
	<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="sys_dt" id="sys_dt" VALUE="<%=sys_date%>">
	<input TYPE='hidden' name='ph_bean_id' id='ph_bean_id' value='<%=ph_bean_id%>'>
	<input TYPE='hidden' name='ph_bean_name' id='ph_bean_name' value='<%=ph_bean_name%>'>
	<input TYPE='hidden' name='locale' id='locale' value='<%=locale%>'>
	<input TYPE='hidden' name='p_nurs_unit_code' id='p_nurs_unit_code' >
	<input TYPE='hidden' name='p_pick_list_yn' id='p_pick_list_yn' value="Y" >
	
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

