<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale	= (String)session.getAttribute("LOCALE");
		String facility_id	= (String)session.getAttribute("facility_id"); // Added for RUT-CRF-0035 [IN029926] 
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String homepage = request.getParameter("homepage")==null?"":request.getParameter("homepage"); //Added for Bru-HIMS-CRF-073 [IN:029939]
		String disableDispLon = "";
		if(homepage.equals("Y"))
			disableDispLon = "disabled";//Added for Bru-HIMS-CRF-073.1 [IN:047222] -end
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<!-- import the calendar script -->
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../ePH/js/DirectDispensing.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
		<form name="DirectDispensingQueryCriteria" id="DirectDispensingQueryCriteria"  >
<%
			String bean_id			= "DirectDispensingBean" ;
			String bean_name		= "ePH.DirectDispensingBean";
			String str_disabled		= "";
			String patient_id       = "";
			String pract_name       = "";
			//String ord_locn_name    = "";
			String encounter_id     = "";	
			String patient_class    = "";
			String ord_locn         = "";
			String practioner_id    = "";
			String enctr_dtls_reqd	= "";
			String disp_locn_code	= "";	
			String mand_dis			= "visibility:hidden";
			DirectDispensingBean bean = (DirectDispensingBean)getBeanObject(bean_id,bean_name,request) ;
			// It will resturn all the dispense locations which statisfies all 5 conditions.pls don't delete this part of code 
			String store_code = request.getParameter("store_code")==null?"":request.getParameter("store_code"); //Added for Bru-HIMS-CRF-073 [IN:029939]
			String DirDispStatus=(String)bean.getDirDispencingStatus();
			ArrayList record		=  bean.checkForTheDisplay();
			if(record!=null && record.size()>0) {
				if(((String)record.get(0)).equals("NO DISPLAY-1")) {
%>
					<SCRIPT>alert(getMessage("PH_USER_NOT_A_PHARMACIST","PH"));</SCRIPT>
<%
				}
				else if(((String)record.get(0)).equals("NO DISPLAY-2")) {
%>
					<SCRIPT>alert(getMessage("PH_OR_NOT_INSTALLED","PH"));</SCRIPT>
<%
				}
				else if(((String)record.get(0)).equals("NO DISPLAY-3")) {
%>
					<SCRIPT>alert(getMessage("PH_WS_NO_NOT_MAPPED","PH"));</SCRIPT>
<%
				}
				else if(((String)record.get(0)).equals("NO DISPLAY-4")) {
%>
					<SCRIPT>alert(getMessage("PH_REG_REQ_ACK_REQ_NO","PH"));</SCRIPT>
<%
				}
				if(((String)record.get(0)).indexOf("NO DISPLAY")> -1){
					if(homepage.equals("Y")){ 
%>
						<SCRIPT>//window.close();</SCRIPT>
<%
					}
					else{
%>
						<SCRIPT>window.location.href ='../../eCommon/jsp/dmenu.jsp'</SCRIPT>
<%
					}
				}
			}
			enctr_dtls_reqd			= (String)bean.getEnctrDtlsReqd();
			if(enctr_dtls_reqd==null) 
				enctr_dtls_reqd="N";
			String disp_details		= bean.getDispLocations();
			String SQL_PH_DISP_LOCN_SELECT10=PhRepository.getPhKeyValue("SQL_PH_DISP_LOCN_SELECT10");
			patient_id				= bean.getPatientID();

			if(patient_id!=null && !patient_id.equals("")){
				pract_name		= bean.getPractionerName();
				//ord_locn_name    = bean.getOrdLocnName();
				encounter_id     = bean.getEncounterID();
				if(encounter_id.equals("")||encounter_id==null){
					patient_class ="XT";
					bean.setPatientClass(patient_class); 
				}
				patient_class    = bean.getPatientClass();
				ord_locn         = bean.getOrdLocn();
				practioner_id    = bean.getPractionerID();
				disp_locn_code	= bean.getDispLocnCode();
			}
			else{
				disp_locn_code	= bean.getdflt_dir_disp_locn();
			}
			if(enctr_dtls_reqd.equals("Y")){
				mand_dis="visibility:visible";
			}
			String userAuthPINYN=bean.getUserAuthPINYN(facility_id,disp_locn_code); // Added for RUT-CRF-0035 [IN029926] 
			userAuthPINYN=userAuthPINYN==null?"":userAuthPINYN;// Added for RUT-CRF-0035 [IN029926] 
%>
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0" >
				<tr>
					<td  class="label" width='10%' nowrap>&nbsp;&nbsp;&nbsp; <fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/>  &nbsp;</td>
					<td  SIZE='15'>
						<select name="disp_locn_code" id="disp_locn_code" <%=str_disabled%> <%=disableDispLon%>>				
<%
						StringTokenizer st_disp_details = new StringTokenizer(disp_details,",");
						String code, desc ;
						while(st_disp_details.hasMoreTokens()){
							code=st_disp_details.nextToken();
							desc=st_disp_details.nextToken();
							if(!disp_locn_code.equals(code)){
%>
								<option value="<%=code%>"><%=desc%></option>
<%
							}
							else{
%>	
								<option value="<%=code%>"selected><%=desc%></option>
<%
							}
						}
%>
						</select>
						<img src="../../eCommon/images/mandatory.gif"  >
					</td>
					<td  class="label" width='10%'nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/> &nbsp;</td>
					<td  nowrap>
						<input type="text" name="patient_id" id="patient_id" maxlength="<%=bean.getPatientIDLength()%>" <%=str_disabled%> onKeyPress="changeToUpper()" value="<%=patient_id%>" ><input type="button" value="?" class="button" name="btnPatientID" id="btnPatientID"  <%=str_disabled%> onClick="callPatientSearch()" onfocus="chkPatientID();">&nbsp;<img src="../../eCommon/images/mandatory.gif"  >
					</td>
					<td colspan="2"nowrap></td>
				</tr> 
				<tr>
					<td  class="label" width='12%' nowrap>&nbsp;&nbsp;&nbsp;<fmt:message key="Common.encounterid.label" bundle="${common_labels}"/> &nbsp;</td>
					<td nowrap>
						<input type="text" name="encounter_id" id="encounter_id"  <%=str_disabled%>   maxlength='12' onKeyPress="changeToUpper()" value="<%=encounter_id%>" readonly><input type="button" value="?" class="button" name="btnencounter" id="btnencounter" <%=str_disabled%> onClick=" searchEncounterId(document.DirectDispensingQueryCriteria.patient_id)" >&nbsp;<img style="<%=mand_dis%>" src="../../eCommon/images/mandatory.gif">
					</td>
					<td  class="label" width='12%' nowrap><fmt:message key="Common.OrderingPractitioner.label" bundle="${common_labels}"/> &nbsp;</td>
					<td  nowrap>
						<input type="text" name="practioner_name" id="practioner_name" value="<%=pract_name%>" ><input type="button" value="?" class="button" name="btnpractsearch" id="btnpractsearch"  <%=str_disabled%> onClick="searchPractioner1()" >&nbsp;<img src="../../eCommon/images/mandatory.gif"  >
					</td>
					<td class="label"  colspan="2"nowrap><input type="button" name="btnProceed" id="btnProceed"id="btnProceed" value='<fmt:message key="Common.Proceed.label" bundle="${common_labels}"/> ' class="button" onClick="chkPatientID1()"></td>		
					<td></td>
				</tr>
			 </table>
			<input type="hidden" name="bean_id" id="bean_id"						value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"					value="<%=bean_name%>">
			<input type="hidden" name="patient_class" id="patient_class"				value="<%=patient_class%>">
			<input type="hidden" name="practioner_id" id="practioner_id"				value="<%=practioner_id%>">
			<input type="hidden" name="ord_locn" id="ord_locn"					value="<%=ord_locn%>">	
			<input type="hidden" name="enctr_dtls" id="enctr_dtls"				    value="<%=enctr_dtls_reqd%>">	
			<input type="hidden" name="SQL_PH_DISP_LOCN_SELECT10" id="SQL_PH_DISP_LOCN_SELECT10"	value="<%=SQL_PH_DISP_LOCN_SELECT10%>">
			<input type="hidden" name="userAuthPINYN" id="userAuthPINYN"				value="<%=userAuthPINYN%>">  <!-- Added for RUT-CRF-0035 [IN029926] -->
			<input type="hidden" name="homepage" id="homepage"				value="<%=homepage%>">  <!-- Added for Bru-HIMS-CRF-073.1 [IN:047222] -->
		</form>
	</body>
<% putObjectInBean(bean_id,bean,request); %>
</html>

