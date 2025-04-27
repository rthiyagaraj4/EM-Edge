<!DOCTYPE html>

 <%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			     Edit History		         Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
02/11/2017	  	GHL-CRF-0458(IN0063830)      prathyusha 									Changes in Medication Administration Module 

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.sql.*,webbeans.eCommon.*" %>
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*, java.text.*,webbeans.eCommon.*" %>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="javascript" src="../../ePH/js/PhMednAdminList.js"></script>
		<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script> 	
		<script language="javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<!-- adding for scf ML-BRU-SCF-0498 [IN:035593] -->
	</head>
<%
	String bean_id				= "PHRepMednAdmnListBean" ;
	String bean_name			= "ePH.PHRepMednAdmnListBean";
	PHRepMednAdmnListBean bean	= (PHRepMednAdmnListBean)getBeanObject( bean_id,bean_name,request ) ;
	bean.setLanguageId(locale);
	String  med_adm_yn			= bean.getMednAdmnList();
    ArrayList nursingList       = bean.getMednNursingList(locale);
	ArrayList dateList          = bean.getMednDateList();
	 Connection connection				= null;//added for GHL-CRF-0458
	    connection						= ConnectionManager.getConnection(request);//added for GHL-CRF-0458
		boolean site = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","MAR_PRINT_YN");//added for GHL-CRF-0458
	if(med_adm_yn.equals("N"))
		out.println("<script>GoBack()</script>");
%>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="">
		<form name="formPhMednAdminListCriteria" id="formPhMednAdminListCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
				<TH COLSPAN="6" ALIGN="left"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
				<tr>
					<!--<td align="right" class="label" width="18%"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
					<td align="left" >&nbsp;&nbsp;<SELECT name="p_nursing_unit" id="p_nursing_unit" >
		   			<OPTION VALUE=" "> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </OPTION>
					<%	for (int i=0; i<nursingList.size(); i+=2) { %>
					<OPTION VALUE="<%= nursingList.get(i) %>"><%= nursingList.get(i+1) %></OPTION>
					<% } %>
					</SELECT><img src="../../eCommon/images/mandatory.gif" align="center"></td>--> <!-- commented below code for scf ML-BRU-SCF-0498 [IN:035593]  -->
					<td class="label"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td><!-- adding start for scf ML-BRU-SCF-0498 [IN:035593] -->
					<td>&nbsp;
						<select name="locn_type" id="locn_type" onChange="resetLocation()">
							<option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
							<option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
							<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
						</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
					</td>
				
			
					<td class="label"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
					<td><input type="text" name="locn_name" id="locn_name" STYLE='overflow:visible;'  disabled><!--size="20" maxlength="20" removed and STYLE='overflow:visible;' added for ML-MMOH-CRF-0752-->
					<input type="button" name="btnLocation" id="btnLocation" class="button" value="?" onClick="locationLookup(locn_name)"><!-- onfocus="locationLookup(locn_name)"--><input type="hidden" name="locn_code" id="locn_code">&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td><!-- adding end for scf ML-BRU-SCF-0498 [IN:035593] --><!-- Commenting onfocus for ML-BRU-SCF-2218 -->		 
			<%	if(!site){ %>	<td colspan='4'>&nbsp;</td><%} %>
		<%//if condtion added for GHL-CRF-0458 start
		if(site){ %>
					<td class="label" ><fmt:message key="ePH.reporttype.label" bundle="${ph_labels}"/></TD> 	<td>
						<select name="p_report_type" id="p_report_type" >
							<option value="ALL"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
							<option value="DEV"><fmt:message key="ePH.deviations.label" bundle="${ph_labels}"/></option>
							<option value="CAS"><fmt:message key="ePH.CorrectAdministrations.label" bundle="${ph_labels}"/></option>
							
						</select>
					</td>
			<%		}	//if condtion added for GHL-CRF-0458 end 
			%>
				</tr>
				<tr>	
					<td  class="label" ><fmt:message key="Common.DateFrom.label" bundle="${common_labels}"/></td>  
					<td align="left" >&nbsp;&nbsp;<input type="text" size="13" name="dt_from1" id="dt_from1" value="<%=com.ehis.util.DateUtils.convertDate((String)dateList.get(0),"DMYHM","en",locale)%>" onBlur="CheckDateT(this); ValidDateTime(dt_from1,dt_to1);dateDifference(this)"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_from1',null,'hh:mm');" >&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center"></td><td  class="label" ><fmt:message key="Common.DateTo.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td><td><input type="text" size="13" name="dt_to1" id="dt_to1" value="<%=com.ehis.util.DateUtils.convertDate((String)dateList.get(0),"DMYHM","en",locale)%>"   onBlur="CheckDateT(this); ValidDateTime(dt_from1,dt_to1);dateDifference(this)"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_to1',null,'hh:mm');" >&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center">  </td> 
			<%	if(!site){ %> <td class="label" colspan=2></td>
				<%		} //if condtion added for GHL-CRF-0458 end	
					 %>
				<%	//if condtion added for GHL-CRF-0458 start
				if(site){ %>	<td class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td >
						<input type="text" name="p_patient_id" id="p_patient_id" value="" maxlength="<%=bean.getPatientIDLength()%>" size="20" onKeyPress="changeToUpper()" onchange="Duplicatecheck();" >
						<input type="button" value="?" class="button" name="btnPatientID" id="btnPatientID" onClick="callPatientSearch()">
						
					</td>
					<%		} //if condtion added for GHL-CRF-0458 end	
					 %>
				</tr>
				<tr>
						<%	//if condtion added for GHL-CRF-0458 
						if(!site){ %>
					 <td  class="label"><fmt:message key="Common.groupby.label" bundle="${common_labels}"/></td>
					<td align="left">&nbsp;&nbsp;<select name="group_by" id="group_by">
						<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
						<option value="B"><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></option>
						<option value="A"><fmt:message key="ePH.AdminTime.label" bundle="${ph_labels}"/></option>
						</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
					</td> 
							<%		}//if condtion added for GHL-CRF-0458	
							 %>
					<td  class="label"><label id='lbl_from_bed'><fmt:message key="ePH.FromBedNo.label" bundle="${ph_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;</label></td><td align ='left' >&nbsp;&nbsp;<input type="text" name="bed_from" id="bed_from" size="8">&nbsp;&nbsp;&nbsp; </td><td align="right" class="label" ><label id="lbl_to_bed"><fmt:message key="ePH.ToBedNo.label" bundle="${ph_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></td><td><input type="text" name="bed_to" id="bed_to" size="8"></td>
				<%	//if condtion added for GHL-CRF-0458
				if(!site){ %><TD></TD>
				<TD></TD>
				<TD></TD>
				<TD></TD>
				<%		}//if condtion added for GHL-CRF-0458	
				 %>
				</tr>
			</table>
			<INPUT TYPE="hidden" name="p_ad_date" id="p_ad_date" VALUE="<%=dateList.get(2) %>">
			<INPUT TYPE="hidden" name="p_in_date" id="p_in_date" VALUE="<%=dateList.get(0) %>">
			<INPUT TYPE="hidden" name="p_en_date" id="p_en_date" VALUE="<%=dateList.get(1) %>">
			<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
			<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
			<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
			<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHRDMEADL">
			<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHRDMEADL">
			<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
			<INPUT TYPE="hidden" name="dt_from" id="dt_from" VALUE=" ">
			<INPUT TYPE="hidden" name="dt_to" id="dt_to" VALUE=" ">
			<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>"><!-- adding for scf ML-BRU-SCF-0498 [IN:035593] -START -->
			<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1")%>">
			<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2")%>"><!-- adding for scf ML-BRU-SCF-0498 [IN:035593] -END -->
		   <INPUT type="hidden" name="site" id="site" VALUE="<%=site%>">
		</form>
		<% putObjectInBean(bean_id,bean,request); %>
	</body>
</html>

