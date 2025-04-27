<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		           Name		          Rev.Date		        Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
02/11/2017	  	ML-MMOH-CRF-0977(IN065505)    prathyusha 											   TPN Standard â?? Request for Offline label should follow TPN Online Label format. 
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/  
%>
 <%-- saved on 03/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.sql.*,webbeans.eCommon.*" %>
<!-- java.sql.*,webbeans.eCommon.* added for ML-MMOH-CRF-0977 -->
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>

<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>

	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script LANGUAGE="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script LANGUAGE="javascript" src="../../ePH/js/PhWorksheetChart.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
	<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>

<%
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String bean_id				= "PhIssueTokenBean" ;
	String bean_name			= "ePH.PhIssueTokenBean";
	PhIssueTokenBean bean		= (PhIssueTokenBean)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(locale);
    ArrayList displocation  = bean.getDispLocation();

	String bean_id1				= "PHRepDispStatisByDispBean" ;
	String bean_name1			= "ePH.PHRepDispStatisByDispBean";
	PHRepDispStatisByDispBean bean1	= (PHRepDispStatisByDispBean)getBeanObject( bean_id1,bean_name1, request) ;
	bean1.setLanguageId(locale);
	String sys_date=bean1.getSysdate();
	 Connection connection				= null;//added for ML-MMOH-CRF-0977
	    connection						= ConnectionManager.getConnection(request);//added for ML-MMOH-CRF-0977
	boolean siteTpn = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","TPN_MF_LABEL");//added for ML-MMOH-CRF-0977
try{//try block is added for ML-MMOH-CRF-0977
%>


<!-- <BODY onload="document.formPhWorksheetChartCriteria.p_disp_locn_code.focus();"> -->
<BODY onload="document.formPhWorksheetChartCriteria.p_disp_locn_code.focus();" onMouseDown="" onKeyDown="lockKey()">
<!--<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="document.formPhIssueTokenCriteria.p_disp_locn_code.focus();"> -->

<form name="formPhWorksheetChartCriteria" id="formPhWorksheetChartCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
	
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
	<TH COLSPAN="6"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
	<tr>
		<td class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<select name="report_by" id="report_by" >
<!-- onChange="changeLegend(this)" -->
					<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
	
				 	<option value="IV"><fmt:message key="Common.Intravenous.label" bundle="${common_labels}"/> </option>
				 	<option value="CYTO"><fmt:message key="ePH.Oncology.label" bundle="${ph_labels}"/> </option>
					<option value="CMP"><fmt:message key="ePH.Compound.label" bundle="${ph_labels}"/> </option>
				<!-- added for ML-MMOH-CRF-0977 start -->
				<% 	if(siteTpn){	%>
						<option value="TPNS"><fmt:message key="ePH.TPNStandard.label" bundle="${ph_labels}"/></option> 
					<%--<option value="TPNN"><fmt:message key="ePH.TPNNonStandard.label" bundle="${ph_labels}"/> </option> --%>
					 <option value="TPNN"><fmt:message key="ePH.TPNCustomize.label" bundle="${ph_labels}"/> </option> 
					
			<%	}
				else{%>
				<option value="TPN"><fmt:message key="ePH.TPN.label" bundle="${ph_labels}"/></option> 
			<%	}%>
			<!-- added for ML-MMOH-CRF-0977 end -->

					</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
				</td>
<!-- 	   	<td align="right" class="label" ><label id="label_drug">&nbsp;&nbsp;&nbsp;Work Sheet Id</td>
		<td align="left" >&nbsp;&nbsp;<input type="text" maxlength="15" size="15" name="p_worksheet_id" id="p_worksheet_id" onKeyPress='return CheckForSpecChars(event)'>&nbsp;</SELECT><img src="../../eCommon/images/mandatory.gif" align="center"> -->

		<td class="label" width="10%" ><label id="label_drug">&nbsp;&nbsp;&nbsp;<fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
		<td>&nbsp;&nbsp;<select name="patient_class" id="patient_class"  >


				 	<option value="IP"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/> </option>
					<option value="OP"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/> </option>
					</select>&nbsp;
		</td>
		<td class="label" ><label id="label_drug">&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Stage.label" bundle="${common_labels}"/></td>
		<td >&nbsp;&nbsp;<select name="stage" id="stage"  >

				 	<option value="FA"><fmt:message key="ePH.Filling/Allocation.label" bundle="${ph_labels}"/></option>
					<option value="DL"><fmt:message key="ePH.Delivery.label" bundle="${ph_labels}"/> </option>
					</select>&nbsp;
		</td>

     </tr>
	 <tr COLSPAN="6" height="4">
	 <td COLSPAN="6"></td>
	 </tr>
	 <tr>
        <td class="label"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
		<td>&nbsp;<SELECT name="p_disp_locn_code" id="p_disp_locn_code">
		   	<OPTION VALUE=" ">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</OPTION>
	 <%	 if (displocation.size() > 0 )
				for (int i=0; i<displocation.size(); i+=2) {
	%>
			 <OPTION VALUE="<%= displocation.get(i) %>"><%= displocation.get(i+1) %></OPTION>

	<% 	} %> 
	  </SELECT><img src="../../eCommon/images/mandatory.gif"></td> 
	
	<!-- 
		<td align="right" class="label" >Order Id</td>
		<td align="left"  >&nbsp;&nbsp;<input type="text" maxlength="15" size="15" name="p_order_id" id="p_order_id" onKeyPress='return CheckForSpecChars(event)'>&nbsp;</SELECT> -->   	
		
		<td class="label" width="10%" nowrap><fmt:message key="Common.DateFrom.label" bundle="${common_labels}"/> <input type='text'  name='from_date' id='from_date' size='8' maxlength="10" value="<%=com.ehis.util.DateUtils.convertDate(sys_date,"DMY","en",locale)%>" readonly>&nbsp;<IMG  SRC="../../eCommon/images/CommonCalendar.gif"  id="from_date1" onclick="return showCalendar('from_date');">&nbsp;<img src ='../../eCommon/images/mandatory.gif'></img>&nbsp;&nbsp;&nbsp;&nbsp;<label class='label'></td>
		<td class="label" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></label>&nbsp;<input type='text'  name='to_date' id='to_date' size='8'  maxlength="10" value="<%=com.ehis.util.DateUtils.convertDate(sys_date,"DMY","en",locale)%>" readonly>&nbsp;<IMG SRC="../../eCommon/images/CommonCalendar.gif"  id="to_date1" onclick="return showCalendar('to_date');">&nbsp;<img src ='../../eCommon/images/mandatory.gif'></img>
		</td>
		<td class="label" ></td>
		<td class="button" >&nbsp;&nbsp;&nbsp;<input class="button" type="button" name="searchResults" id="searchResults"  value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick="showResults()"></td>

</tr>		
	 <tr COLSPAN="6" height="4"></tr>
	
	</table>
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="">
	<INPUT TYPE="hidden" name="p_worksheet_id" id="p_worksheet_id" VALUE="">
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= p_facility_id %>">
	<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%=bean_id%>">
	<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%=bean_name%>">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<INPUT TYPE="hidden" name="locale" id="locale" VALUE="<%=locale%>"> 
	<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">

</form>

<%//Added  for ML-MMOH-CRF-0977 start
}

		catch(Exception e) {
			out.print("Exception @ Result JSP :"+e.toString());
			e.printStackTrace();
		}
		finally{
			

			if(connection != null)
				ConnectionManager.returnConnection(connection,request);
		
		}
		//Added  for ML-MMOH-CRF-0977
		 %>
</body>
<% putObjectInBean(bean_id,bean,request); %>
</html>

