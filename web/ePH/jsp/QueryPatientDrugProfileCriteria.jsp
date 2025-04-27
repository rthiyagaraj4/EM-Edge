<!DOCTYPE html>
<% /* 
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			     Description
--------------------------------------------------------------------------------------------------------------
?				100					?                created
10/10/2019  IN070786                PRATHYUSHA                       MMS-KH-CRF-0016.1
30/05/2023							Sushant Tambe	 				 ML-BRU-SCF-2227

---------------------------------------------------------------------------------------------------------------
*/ %>
 <!--This file is saved on 28/10/2005-->
<%-- JSP Page specific attributes start --%>
<!-- modified for ML-BRU-CRF-0522 -->
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.text.DecimalFormat,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
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
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		String facility_id			= (String)session.getAttribute("facility_id");//added for IN070786
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<!-- import the calendar script -->
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script LANGUAGE="javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="javascript" src="../../ePH/js/QueryPatientDrugProfile.js"></script> 
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="JavaScript" src="../../ePH/js/DispMedication.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0" onunload="ExternalDrugInsert()"><!-- onunload added for IN070786-->
<%
		String patient_id		=   request.getParameter("patient_id");
		String pat_class		=	request.getParameter("pat_class");
		String disp_locn_code	=   request.getParameter("disp_locn_code");
		String mode         	=   request.getParameter("mode");
		String called_frm		=	request.getParameter("called_frm")==null?"":request.getParameter("called_frm");//Added for Bru-HIMS-CRF-081
		String disablePatient	= "";
        String encounter_id		 = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");	 // encounter_id added for AAKH-CRF-0088.2
		String ReqDb	    =	request.getParameter("ReqDb")==null?"":request.getParameter("ReqDb");//Added for MMS-DM-CRF-115.4
		String enc_id1	    =	request.getParameter("enc_id1")==null?"":request.getParameter("enc_id1");//Added for MMS-DM-CRF-115.4
		String called_from		=	request.getParameter("called_from")==null?"":request.getParameter("called_from");//Added for MMS-DM-CRF-115.4
		String rowDisplay="display", closeBtnDisplay="display:none;";
		int drugNameSize=30;
		if (!(patient_id.trim()).equals("null")){
			disablePatient = "disabled";
		}
		else{
			patient_id = "";
		}
		//SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy");
		//java.util.Date date_time	 	= new java.util.Date();
		String Sysdate 				= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);

		String	bean_id			=	"QueryPatientDrugProfileBean" ;
		String	bean_name		=	"ePH.QueryPatientDrugProfileBean";

		QueryPatientDrugProfileBean bean = (QueryPatientDrugProfileBean)getBeanObject( bean_id,bean_name, request) ;
		bean.setLanguageId(locale);
		bean.setFacilityParamValues();
		//added for IN070786 start
		String bean_id1		= "@PrescriptionBean_1"+patient_id+encounter_id;
		String bean_name1	= "ePH.PrescriptionBean_1";
		PrescriptionBean_1 bean1		= (PrescriptionBean_1)getBeanObject( bean_id1,bean_name1,request );
		String no_ext_drug=(String)bean1.extDrugApplicableYN(patient_id,encounter_id);//added for mms-kh-crf-0016.1
		//added for IN070786  end
		ArrayList patientClass = bean.getPatientClass(); 
		//Added for  ML-BRU-CRF-0522  start
		Connection con				= null;
		 con						= ConnectionManager.getConnection(request);
		// added for ML-BRU-CRF-0522  end
	try{
		
		
		boolean site_default_active = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DRUG_PROFILE_DEFAULT_SEARCH");//Added for  ML-BRU-CRF-0522  
		//added for NMC-JD-CRF-0119 - start
		boolean generic_name_max_len_app = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","GENERIC_NAME_MAX_LEN_APP"); 

		String max_length = "";	
		String max_size = "";

		if(generic_name_max_len_app){
			max_length = "100";
			max_size   = "102";
		}
		else{
			max_length = "40";
			max_size   = "42";	
		}
		//added for NMC-JD-CRF-0119 - end
		String sql_ph_drug_search_select1 =	PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT1");
		String sql_ph_drug_search_select2 =	PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT2");
		String  sql_ph_tpn_drug_search_select= 	PhRepository.getPhKeyValue("SQL_PH_TPN_DRUG_SEARCH_SELECT");
		String  sql_ph_medicalitem_search_select= 	PhRepository.getPhKeyValue("SQL_PH_MEDICALITEM_SEARCH_SELECT");
		if(called_frm.equals("Dispense") ){
			rowDisplay="display:none;";
			drugNameSize=30;
			closeBtnDisplay="display:inline;";
		}
%>
		<form name="queryPatientDrugProfileCriteria" id="queryPatientDrugProfileCriteria" >
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
				<tr >
					<td class="label" width='10%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td class="label" width='22%'><input type="text" name="patient_id" id="patient_id"   size="20" value="<%=patient_id.trim()%>"  <%=disablePatient%> onKeyPress="changeToUpper()" maxlength="<%=bean.getPatientIDLength()%>" onblur="Duplicatecheck();" > <!-- onblur="Duplicatecheck();" added for ML-BRU-SCF-0621[IN036565]-->
					<input type="button" class="button" value="?" name="patient_search" id="patient_search" onclick="callPatientSearchQ()" <%=disablePatient%>>
					<img src="../../eCommon/images/mandatory.gif" align="center"></img> 
					</td>
					<td class="label" width='10%'><fmt:message key="Common.fromdate.label" bundle="${common_labels}"/></td>
					<td class="label" width='20%'><input type="text" name="dt_from" id="dt_from" 
					Onblur="if(CheckDate(this))if(DateCheck(sysdate,dt_from))validate_date(this,'TO_DATE_LESS_FROM');"
					value="" maxlength="10" size="10" >
					<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_from');"  onblur='dt_from.focus()'>
					</td>
					<td class="label" width='7%'><fmt:message key="Common.todate.label" bundle="${common_labels}"/></td>
					<td class="label" width='28%'><input type="text" name="dt_to" id="dt_to" value="" maxlength="10" size="10" Onblur="if(CheckDate(this))if(DateCheck(sysdate,dt_to))validate_date(this,'TO_DATE_LESS_FROM');"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_to');" onblur='dt_to.focus()' >
					</td>
					<td class="label" width='3%'>
						<img src="../../ePH/images/max.gif" id ="expand" value="expand" style="cursor:pointer;<%=closeBtnDisplay%>" onClick="MaxDrugProfile('<%=patient_id.trim()%>', '<%=disp_locn_code%>', '<%=pat_class.trim()%>','C','<%=ReqDb%>','<%=enc_id1%>','<%=called_from%>')" height="17" width='17' title="Maximize Drug Profile" >&nbsp;
						<img src="../../eCommon/images/disabled.gif" id="Closebutton" height='20' width='20' onclick="MinimizeDrugProfile('C')" valign="right"  title='Close Drug Profile' style="cursor:pointer;<%=closeBtnDisplay%>"></img>
					</td>
				</tr>
				<tr style='<%=rowDisplay%>'>   
					<td class='label'><fmt:message key="ePH.TPN.label" bundle="${ph_labels}"/> </td> 
					<td class='label'>
					<input type='checkbox' name='tpnCkBox' id='tpnCkBox' onclick= "disableGeneric(this)" ></td>		
					<td  class="label"><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/> </td>
					<td colspan="4" class="label"><input type="text" name="generic_name" id="generic_name" maxlength="<%=max_length%>" size="15">
					<input type="button" class="button" value="?" name="generic_name_search" id="generic_name_search" onclick="searchGenericName()"> <!-- onfocus="searchGenericName()"  Commenting for ML-BRU-SCF-2227 -->
					<input type="hidden" name="generic_id" id="generic_id" value="">
					</td>
				</tr>
				<tr >
					<td class="label" id="itemname" style='display:none;'><fmt:message key="Common.ItemName.label" bundle="${common_labels}"/>
					<td class="label" id="drugname" ><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/>		
					</td>
					<td class="label" class="label"><input type="text" name="drug_name" id="drug_name" maxlength="60" size="15" ><input type="button" class="button" value="?" name="drug_name_search" id="drug_name_search" onclick="searchDrugName()"> <!--  onfocus="searchDrugName()"  Commenting for ML-BRU-SCF-2227 --> 
					<input type="hidden" name="drug_code" id="drug_code" value="">
					</td>		
					<td class="label"><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
					<td class="label"  >
						<select name="pat_class" id="pat_class">
						<option value="">&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;</option>
<%
						for (int i=0;i<patientClass.size();i=i+2){
							if(pat_class.trim().equals(patientClass.get(i))) {
%>
								<option value="<%=patientClass.get(i)%>" selected><%=patientClass.get(i+1)%></option>
<%	
						}
						else{  
%>
							<option value="<%=patientClass.get(i)%>"><%=patientClass.get(i+1)%></option>
<%
						}	
					}
%>
					</select>			
					</td>
					<td class="label"><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
					<td class="label" colspan="2"><select name="status" id="status">
						<!-- SELECTED ADDED FOR ML-BRU-CRF-0522  start-->
						<% if(site_default_active){ %>
						<option value="*A" selected ><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<%}else{ %>
						<option value="*A"  ><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<%} %>
						<!-- SELECTED ADDED FOR ML-BRU-CRF-0522 end -->
						<option value="C"><fmt:message key="Common.completed.label" bundle="${common_labels}"/></option>
						<option value="F"><fmt:message key="ePH.FutureRx.label" bundle="${ph_labels}"/></option>
						<!-- SELECTED REMOVED FOR ML-BRU-CRF-0522 start -->
						<% if(site_default_active){ %>
						<option value="A" ><fmt:message key="Common.active.label" bundle="${common_labels}"/></option>
						<%}else{ %>
						<option value="A" selected><fmt:message key="Common.active.label" bundle="${common_labels}"/></option>
						<%} %>
						<!-- SELECTED REMOVED FOR ML-BRU-CRF-0522 end -->
						<option value="DC"><fmt:message key="Common.Discontinued.label" bundle="${common_labels}"/></option>
						<option value="HD"><fmt:message key="ePH.OnHold.label" bundle="${ph_labels}"/></option>
						<option value="R"><fmt:message key="Common.returned.label" bundle="${common_labels}"/></option>
						<option value="CN"><fmt:message key="Common.cancelled.label" bundle="${common_labels}"/></option>
						<option value="PG" ><fmt:message key="Common.Pending.label" bundle="${common_labels}"/></option>
						<!-- <option value="PN"><fmt:message key="ePH.PendingCosign.label" bundle="${ph_labels}"/></option> -->
						<option value="PO"><fmt:message key="Common.PendingAuthorization.label" bundle="${common_labels}"/></option>
						<option value="PC"><fmt:message key="Common.PendingConsent.label" bundle="${common_labels}"/></option>
						<option value="PS"><fmt:message key="ePH.PendingSplAprvl.label" bundle="${ph_labels}"/></option>
						</select> &nbsp;&nbsp;&nbsp;<input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'  onClick="callResultPage('<%=called_frm%>','<%=mode%>','Y','<%=encounter_id %>','<%=ReqDb%>','<%=enc_id1%>','<%=called_from%>');">&nbsp;&nbsp;</td> <!-- encounter_id added for AAKH-CRF-0088.2 and Added called_from,enc_id1,ReqDb for MMS-DM-CRF-115.4-->	
					<td></td>
				</tr>
				<tr >   
					<td class='label'> 
						<input type='radio' name='ItemType' id='ItemType' value='D' checked onclick='changeName();'/><fmt:message key="Common.Drug.label" bundle="${common_labels}"/>
					</td>
					<td class='label' colspan='6'>
						<input type='radio' name='ItemType' id='ItemType' value='M' onclick='changeName();'/><fmt:message key="Common.MedicalItem.label" bundle="${common_labels}"/>
					</td>	
				</tr>
			</table>
			<input type="hidden" name="sql_ph_drug_search_select1" id="sql_ph_drug_search_select1" value="<%=sql_ph_drug_search_select1%>">
			<input type="hidden" name="sql_ph_drug_search_select2" id="sql_ph_drug_search_select2" value="<%=sql_ph_drug_search_select2%>">
			<input type="hidden" name="sql_ph_tpn_drug_search_select" id="sql_ph_tpn_drug_search_select" value="<%=sql_ph_tpn_drug_search_select%>" >
			<input type="hidden" name="sql_ph_medicalitem_search_select" id="sql_ph_medicalitem_search_select" value="<%=sql_ph_medicalitem_search_select%>" >
			<input type="hidden" name="disp_locn_code" id="disp_locn_code" value="<%=disp_locn_code%>">
			<input type="hidden" name="" id="" value="">
			<INPUT TYPE="hidden" name="sysdate" id="sysdate" VALUE="<%=Sysdate%>">
			<INPUT TYPE="hidden" name="locale" id="locale" VALUE="<%=locale%>">
			<INPUT TYPE="hidden" name="mode" id="mode" VALUE="<%=mode%>">
			
			<INPUT TYPE="hidden" name="no_ext_drug" id="no_ext_drug" VALUE="<%=no_ext_drug%>"><!-- added for IN070786 -->
			<INPUT TYPE="hidden" name="no_ext_drug1" id="no_ext_drug1" VALUE=""><!-- added for IN070786 -->
			
			<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>"><!-- added for IN070786 -->	
			
		</form>
	</body>
	<script>
<%
		if(called_frm.equals("Dispense") || called_frm.equals("Prescription")|| called_frm.equals("DispenseMax") || called_from.equals("CDR")) {	
%>
			//document.queryPatientDrugProfileCriteria.search.click(); //Commented for Bru-HIMS-CRF-081 [IN:029947]
			callResultPage('<%=called_frm%>','<%=mode%>','N','<%=encounter_id%>','<%=ReqDb%>','<%=enc_id1%>','<%=called_from%>'); //Added for Bru-HIMS-CRF-081 [IN:029947] // encounter_id added for AAKH-CRF-0088.2//Added called_from,enc_id1,ReqDb for MMS-DM-CRF-115.4
<%
		}	
%>
	</script>
	<%} //Added  for ML-BRU-CRF-0522 start
		catch(Exception e) {
			out.print("Exception @ Result JSP :"+e.toString());
			e.printStackTrace();
		}
		finally{
			

			if(con != null)
				ConnectionManager.returnConnection(con,request);
		
		}
		//Added  for ML-BRU-CRF-0522 end
		putObjectInBean(bean_id,bean,request); %>
</html>

