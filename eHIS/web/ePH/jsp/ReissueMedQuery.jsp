<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.net.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="cBean"  scope="session" class="ePH.ReissueMedBean" />
<%-- Mandatory declarations end --%>
<%
 
	String bean_id		= "ReissueMedBean" ;
    String bean_name	= "ePH.ReissueMedBean";

	ReissueMedBean beanObj	= (ReissueMedBean)getBeanObject(bean_id,bean_name,request);

	String disp_locn_desc	= beanObj.getDispLocnDesc();
	String disp_locn		= beanObj.getDispLocnCode();
	String disp_date		= beanObj.getTodaysDate();
	String from_date		= beanObj.getFromDate();
	String bl_interface_yn  = beanObj.checkforbillinginterface();

	String sql_ph_reissue_medication_select12		=	PhRepository.getPhKeyValue("SQL_PH_REISSUE_MEDICATION_SELECT12");
%>
<html>
<head>
  <%

	   request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String p_user_name= (String) session.getValue( "login_user" ) ;
		String facility_id   = (String)session.getValue( "facility_id" );

		String order_facility_id="";
		String order_facility_name="";
		ArrayList OrderingFacility=beanObj.getOrderingFacilityId(p_user_name);
		String today_date 	= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);//code added for ICN_ADHOC_030

String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link> 
	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<!-- import the calendar script -->
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<!-- <SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/MstCodeCommon.js"></SCRIPT> -->
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
    <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
    <script language="JavaScript" src="../js/PhCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
  <!--  <script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
    <!--<script language="JavaScript" src="../js/PhMessages.js"></script> -->
    <script language="JavaScript" src="../js/ReissueMed.js"></script>
	<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onMouseDown="" onKeyDown="lockKey()"  onLoad="document.FormReissueMedicationQueryCriteria.Patient_Id.focus()" topmargin="0">

<form name="FormReissueMedicationQueryCriteria" id="FormReissueMedicationQueryCriteria" >
 <table cellpadding=0 cellspacing=0 width="100%"  align="center" border="0" >
 <tr>
<!-- <td align="right" class="label"><fmt:message key="Common.OrderingFacility.label" bundle="${common_labels}"/></td> commented for FD-BRU-CRF-092 ***start****
  <td align="left" class="fields">&nbsp;&nbsp;&nbsp;<select name="OrderingFacility" id="OrderingFacility" onChange="">
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
		%></SELECT></td> *** end *** -->

 </tr>
<tr>	
			<td align="left" class="label" ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td align="left" >&nbsp;&nbsp;<input type="text" name="Patient_Id" id="Patient_Id" size="20" 
				maxlength="<%=beanObj.getPatientIDLength()%>" onKeyPress="uppercase()"><INPUT TYPE="button" name="Patient_Button" id="Patient_Button" VALUE="?" CLASS="button"  onClick="callPatientSearch(document.FormReissueMedicationQueryCriteria.Patient_Id)" >&nbsp;<img name="PhysicalLocMandatory" src="../../eCommon/images/mandatory.gif">
			</td>
			<td align="left" class="label" ><fmt:message key="ePH.ReissueDrug.label" bundle="${ph_labels}"/></td>
			<td align="left" colspan="2">&nbsp;&nbsp;<input type="text" name="drug_desc" id="drug_desc" size="20" 
				onKeyPress="uppercase()"><INPUT TYPE="button" name="drug_lookup" id="drug_lookup" VALUE="?" CLASS="button"  onClick="searchDrugName(drug_desc)" ><input type="hidden" name="drug_code" id="drug_code">
			</td>
		</tr>
		<tr>
			<td align="left" class="label" ><fmt:message key="ePH.DispensedDateFrom.label" bundle="${ph_labels}"/></td>
			<td align="left" >&nbsp;&nbsp;<input type="text" name="Disp_date_from" id="Disp_date_from"  size="8" maxlength="10"  value="<%=com.ehis.util.DateUtils.convertDate(from_date,"DMY","en",locale)%>" Onblur="if(CheckDateT(this))if(DateCheck(today_date,Disp_date_from))validate_date(this,'TO_DATE_LESS_FROM');"><INPUT TYPE="image" SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="showCalendar('Disp_date_from');document.FormReissueMedicationQueryCriteria.Disp_date_from.focus();return false;" >&nbsp;<img name="PhysicalLocMandatory" src="../../eCommon/images/mandatory.gif"> <!-- code 'Onblur="if(CheckDateT(this))if(DateCheck(today_date,Disp_date_from))validate_date(this,'TO_DATE_LESS_FROM');"' added for ICN_ADHOC_030  -->
			</td>
			<td align="left" class="label" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
			<td align="left" >&nbsp;&nbsp;<input type="text" name="Disp_date_to" id="Disp_date_to"  size="8" maxlength="10"  value="<%=com.ehis.util.DateUtils.convertDate(disp_date,"DMY","en",locale)%>" Onblur="if(CheckDateT(this))if(DateCheck(today_date,Disp_date_to))validate_date(this,'TO_DATE_LESS_FROM');"><INPUT TYPE="image" SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="showCalendar('Disp_date_to');document.FormReissueMedicationQueryCriteria.Disp_date_to.focus();return false;" >&nbsp;<img name="PhysicalLocMandatory" src="../../eCommon/images/mandatory.gif"><!-- code 'Onblur="if(CheckDateT(this))if(DateCheck(today_date,Disp_date_to))validate_date(this,'TO_DATE_LESS_FROM');"' added for ICN_ADHOC_030  -->
			</td>
			<td align="right" class="label">
				<input type="button" class="button" name="Search" id="Search" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>" onclick="callReissueResultPage(document.FormReissueMedicationQueryCriteria)">
				<input type="button" class="button" name="Cancel" id="Cancel" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" onclick="cancel(document.FormReissueMedicationQueryCriteria)">
			</td>
	</tr>
</table>

<input type="hidden" name="Bean_Id" id="Bean_Id" value="<%=bean_id%>">
<input type="hidden" name="Bean_Name" id="Bean_Name" value="<%=bean_name%>">
<input type="hidden" name="Locn_Code" id="Locn_Code" value="">
<input type="hidden" name="Patient_Class" id="Patient_Class" value="">
<input type="hidden" name="Drug_Code" id="Drug_Code" value="">
<input type="hidden" name="disp_locn" id="disp_locn" value="<%=disp_locn%>">
<input type="hidden" name="disp_locn_desc" id="disp_locn_desc" value="<%=disp_locn_desc%>">
<input type="hidden" name="sysdate" id="sysdate" value="<%=disp_date%>">
<input type="hidden" name="sql_ph_reissue_medication_select12" id="sql_ph_reissue_medication_select12" value="<%=sql_ph_reissue_medication_select12%>">
<input type="hidden" name="language_id" id="language_id" value="<%=locale%>">
<input type="hidden" name="bl_interface_yn" id="bl_interface_yn" value="<%=bl_interface_yn%>">
<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>"> <!-- FD-BRU-CRF-092 -->
<input type="hidden" name="today_date" id="today_date" value="<%=today_date%>"> <!-- code added for ICN_ADHOC_030  -->
</form>
<% putObjectInBean(bean_id,beanObj,request); %>
</body>
</html>

