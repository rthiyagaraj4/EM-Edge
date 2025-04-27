<!DOCTYPE html>
 
 <%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			     Edit History		         Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
02/11/2017	  	ML-MMOH-CRF-0973(IN0065451)  prathyusha 									Request to have re-print option for : 1. TPN Cover Bag label 2. TPN Lipid label
02/11/2017	  	ML-MMOH-CRF-0973(IN0065451)  Narasimhulu 									Request to have re-print option for : 1. TPN Cover Bag label 2. TPN Lipid label
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
 <%-- saved on 03/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.sql.*,webbeans.eCommon.*" %>
<!-- java.sql.*,webbeans.eCommon.* added for ml-mmoh-crf-0977 -->
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
	//

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

 	<script LANGUAGE="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script LANGUAGE="javascript" src="../../ePH/js/PhManufacturingLabel.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
	<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
	<!--<script LANGUAGE="javascript" src="../js/PhMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
-->
</head>

<%
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String bean_id				= "PhIssueTokenBean" ;
	String bean_name			= "ePH.PhIssueTokenBean";
	PhIssueTokenBean bean		= (PhIssueTokenBean)getBeanObject( bean_id,bean_name,request ) ;
	bean.setLanguageId(locale);
    ArrayList displocation  = bean.getDispLocation();
    Connection connection				= null;//added for ML-MMOH-CRF-0973
    connection						= ConnectionManager.getConnection(request);//added for ML-MMOH-CRF-0973
	boolean siteTpn = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","TPN_MF_LABEL");//added for ML-MMOH-CRF-0973
	boolean siteTpnStd = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","TPN_STD_REGIMEN_LABEL");// added for ML-MMOH-CRF-1089
try{//added for ML-MMOH-CRF-0973

%>

<BODY onload="document.formPhManufacturingLabelCriteria.p_disp_locn_code.focus();" onMouseDown="" onKeyDown="lockKey()">
<!-- <BODY onload="document.formPhManufacturingLabelCriteria.p_disp_locn_code.focus();"> -->
<!--<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="document.formPhIssueTokenCriteria.p_disp_locn_code.focus();"> -->

<form name="formPhManufacturingLabelCriteria" id="formPhManufacturingLabelCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
	
	<table cellpadding="0" cellspacing="3" width="100%" align="center" border="0">
	<TH COLSPAN="4"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
	<tr>
		<td class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
		<td >&nbsp;<select name="p_report_id_1" id="p_report_id_1" onChange="changeLegend(this)" ><!--modified for ML-MMOH-CRF-1089-->
					<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					<option value="PHBRMFGLB"><fmt:message key="ePH.IV.label" bundle="${ph_labels}"/>  </option>
					<option value="PHCYTOMFGLB"> <fmt:message key="ePH.Oncology.label" bundle="${ph_labels}"/> </option>
					<option value="PHCPMFGLB"><fmt:message key="ePH.Compound.label" bundle="${ph_labels}"/> </option>
				   
					
					<!--  Added for ML-MMOH-CRF-0973 start -->
				<%	if(siteTpn){ %>
				
					<option value="PHTPNDISPLBF"><fmt:message key="ePH.TPNStandard.label" bundle="${ph_labels}"/></option>
					<%-- <option value="PHBRMFGTP"><fmt:message key="ePH.TPNNonStandard.label" bundle="${ph_labels}"/></option> --%>
					<option value="PHBRMFGTP"><fmt:message key="ePH.TPNCustomize.label" bundle="${ph_labels}"/></option>
					<%if(siteTpnStd){//ADDED FOR   ML-MMOH-CRF-1089 %>
					<option value="COB"><fmt:message key="ePH.TPNCOVERBAG.label" bundle="${ph_labels}"/></option>
					<%}else{%>
						<option value="PHTPNCOB"><fmt:message key="ePH.TPNCOVERBAG.label" bundle="${ph_labels}"/></option>
					<%} %>
					<option value="PHTPNLIP"><fmt:message key="ePH.TPN.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="ePH.LIPIDLABEL.label" bundle="${ph_labels}"/></option>
					
				<%	}else{%>
					
					 <option value="PHBRMFGTP"><fmt:message key="ePH.TPN.label" bundle="${ph_labels}"/></option> <!-- if else added for ML-MMOH-CRF-0973 -->
				<%} %>
					<!--  Added for ML-MMOH-CRF-0973 end -->
					</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" >

	   	<td class="label" ><label id="label_drug">&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.WorksheetID.label" bundle="${ph_labels}"/></td>
		<td >&nbsp;&nbsp;<input type="text" maxlength="15" size="15" name="p_worksheet_id" id="p_worksheet_id" onKeyPress='return CheckForSpecChars(event)' onblur="getDuration(document.formPhManufacturingLabelCriteria.p_report_id_1.value)" >&nbsp;</SELECT><img src="../../eCommon/images/mandatory.gif" align="center">
     </tr>
	 <tr>
        <td class="label"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
		<td >&nbsp;<SELECT name="p_disp_locn_code" id="p_disp_locn_code" onchange="getDuration(document.formPhManufacturingLabelCriteria.p_report_id_1.value)">
		   	<OPTION VALUE=" ">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</OPTION>
	 <%	 if (displocation.size() > 0 )
				for (int i=0; i<displocation.size(); i+=2) {
	%>
			 <OPTION VALUE="<%= displocation.get(i) %>"><%= displocation.get(i+1) %></OPTION>

	<% 	} %> 
	  </SELECT><img src="../../eCommon/images/mandatory.gif" align="center"></td> 
	
	
		<td class="label" >&nbsp;&nbsp;&nbsp;<fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></td>
		<td >&nbsp;&nbsp;<input type="text" maxlength="15" size="15" name="p_order_id" id="p_order_id" onKeyPress='return CheckForSpecChars(event)'>&nbsp;</SELECT>   	
</tr>		
	
	</table>
	
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= p_facility_id %>">
	<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%=bean_id%>">
	<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%=bean_name%>">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<INPUT TYPE="hidden" name="p_duration_value" id="p_duration_value" VALUE="">
	<INPUT TYPE="hidden" name="p_ord_type" id="p_ord_type" VALUE="">
	<INPUT TYPE="hidden" name="p_freq" id="p_freq" VALUE="">
	<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE=""><!-- ADDED for ML-MMOH-CRF-1089 -->
	
</form>

<%//Added  for ML-MMOH-CRF-0973 start
}

		catch(Exception e) {
			out.print("Exception @ Result JSP :"+e.toString());
			e.printStackTrace();
		}
		finally{
			

			if(connection != null)
				ConnectionManager.returnConnection(connection,request);
		
		}
		//Added  for ML-MMOH-CRF-0973 END
		 %>
		 </body>
<% putObjectInBean(bean_id,bean,request); %>

</html>

