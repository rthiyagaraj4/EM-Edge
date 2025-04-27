<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*,eCommon.XSSRequestWrapper" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<HTML>
	<HEAD>
<%
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<SCRIPT LANGUAGE="JavaScript" SRC="../js/PhCommon.js"></SCRIPT>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<SCRIPT LANGUAGE="JavaScript" SRC="../js/TrackingOutsourceMedication.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends

		String	bean_id			=	"TrackingOutsourceMedicationBean" ;
		String	bean_name		=	"ePH.TrackingOutsourceMedicationBean";
		String accessDisplay="display", defFacilicty="", defAction="", defSelect="";
		String homepage		= CommonBean.checkForNull(request.getParameter("homepage")); //Added for Bru-HIMS-CRF-073.1 [IN:047222] -start
		String dispSwitchLogin = "";
		if(homepage.equals("Y"))
			dispSwitchLogin ="display:none;"; //Added for Bru-HIMS-CRF-073.1 [IN:047222] -end
		TrackingOutsourceMedicationBean bean = (TrackingOutsourceMedicationBean)getBeanObject(bean_id,bean_name ,request);
		try{
			bean.setLanguageId(locale);
			bean.clearOutSourceDtls();
			String disp_locn_code = bean.getDispLocnCode();
			String disp_locn_name = bean.getDispLocnName();
			HashMap hmAccessDetails= bean.getAccessDetails();
			ArrayList referralfcy=bean.getReferralFacilities();	
			String drugLookupSql = "SELECT DISTINCT drug_code code, drug_desc description FROM (SELECT drug_desc drug_desc, drug_code drug_code, LANGUAGE_ID FROM ph_drug_lang_vw  WHERE DISCONTINUED_YN !='Y' UNION SELECT NVL (short_name, long_name) drug_desc, tpn_regimen_code drug_code, LANGUAGE_ID FROM ph_tpn_regimen_lang_vw  WHERE DISCONTINUED_YN !='Y')  where upper(drug_code) like upper(?) AND upper(drug_desc) like upper (?) and language_id= ";
			ArrayList IVlegends             =  (ArrayList)bean.getIVLegends();
			String ivlegend_option="", refFacDisplay="", refFacDisplaySend="";
			for(int i=0;i<=IVlegends.size()-2;i=i+2){
				ivlegend_option	=ivlegend_option +	"<option value='"+((String) IVlegends.get(i))+"'>"+((String) IVlegends.get(i+1))+"</option>"; 
			}
%>
			<form name="frmTrackingOutsourceMedicationCriteria" id="frmTrackingOutsourceMedicationCriteria" >
				<table cellpadding='2' cellspacing='0' width="99%" align="center" border='0'>
					<tr >
<%
						defAction = (String)hmAccessDetails.get("OUTSOURCING_DEF_ACTION");
						defFacilicty = (String)hmAccessDetails.get("OUTSOURCING_DEF_FACILITY");
						if(defAction==null || defAction.equals(""))
							defAction="S";
						if( ((String)hmAccessDetails.get("OUTSOURCING_SEND_YN")).equals("Y")){
							accessDisplay = "display";
							if(defAction.equals("S")){
								defSelect = "Checked";
								refFacDisplay = "display:none;";
								refFacDisplaySend = "display";
							}
						}
						else{
							accessDisplay = "none";
						}
%>
						<td width='15%' class="label" style="display:<%=accessDisplay%>;"> 
							<input type='radio' name='trackingOption' id='trackingOption' value='S' <%=defSelect%> onclick='changeAction("S");'/><B> <fmt:message key="ePH.Send.label" bundle="${common_labels}"/></B>
						</td>
<%
						defSelect="";
						if(((String)hmAccessDetails.get("OUTSOURCING_RECEIVE_YN")).equals("Y")){
							accessDisplay = "display";
							if(defAction.equals("R")){
								defSelect = "Checked";
								refFacDisplay = "display";
								refFacDisplaySend = "display:none;";
							}
						}
						else
							accessDisplay = "none";
%>
						<td width='15%' class="label" style="display:<%=accessDisplay%>;"> 
							<input type='radio' name='trackingOption' id='trackingOption' value='R' <%=defSelect%> onclick='changeAction("R");'/><B> <fmt:message key="ePH.Receive.label" bundle="${ph_labels}"/></B>
						</td>
<%
						defSelect="";
						if(((String)hmAccessDetails.get("OUTSOURCING_DELIVER_YN")).equals("Y")){
							accessDisplay = "display";
							if(defAction.equals("D")){
								defSelect = "Checked";
								refFacDisplay = "display";
								refFacDisplaySend = "display:none;";
							}
						}
						else
							accessDisplay = "none";
%>
						<td width='15%' colspan='2' class="label" style="display:<%=accessDisplay%>;"> 
						<input type='radio' name='trackingOption' id='trackingOption' value='D' <%=defSelect%>  onclick='changeAction("D");'/><B> <fmt:message key="ePH.Deliver.label" bundle="${ph_labels}"/></B>
						</td>
						<td colspan='5'>&nbsp;</td> 
					</tr>
					<tr><td colspan='8'>&nbsp;</td></tr>
					<tr >
						<td  class="label"><fmt:message key="Common.OrderDateFrom.label" bundle="${common_labels}"/></td>
						<td  class='label'>
							<input type="text" name="order_date_from" id="order_date_from"  size="8" maxlength="10" onBlur="CheckDateT(this,'<%=locale%>');" value="<%=com.ehis.util.DateUtils.convertDate(bean.getDate_minus_30(),"DMY","en",locale)%>"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id='CalendarFromDate' onclick="showCalendar('order_date_from');document.frmTrackingOutsourceMedicationCriteria.order_date_from.focus();return false; " >&nbsp;<img  src="../../eCommon/images/mandatory.gif"></img>
						</td>
						<td  class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
						<td  class='label'>
							<input type="text" name="order_date_to" id="order_date_to" size="8" maxlength="10" onBlur="CheckDateT(this,'<%=locale%>');" value="<%=com.ehis.util.DateUtils.convertDate(bean.getDate_plus_30(),"DMY","en",locale)%>"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id='CalendarToDate' onclick="showCalendar('order_date_to');document.frmTrackingOutsourceMedicationCriteria.order_date_to.focus();return false;">&nbsp;<img  src="../../eCommon/images/mandatory.gif"></img>
						</td>
						<td  class="label" nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
						<td  class='label'>
							<input type="text" name="patient_id" id="patient_id"  maxlength="<%=bean.getPatientIDLength()%>" size="18" value="" onKeyPress="uppercase()" onBlur="callPatientSearch()"><input type="button" value="?"  class="button" name="btnPatientID" id="btnPatientID" onClick="callPatientSearch()">
						</td>
						<td  class="label" ><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></td>
						<td  class="label" >
							<input type="text" name="drug_name" id="drug_name" size="45"  maxlength="60" value="" onblur='searchDrugName();'><input type="button" name="drug_search" id="drug_search" value="?" class="button"  onClick="searchDrugName();">
							<input type='hidden' name='drug_code' id='drug_code' value=''>
						</td>
					</tr>
					<tr>
						<td class="label"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
						<td class='label' ><b><%=disp_locn_name%><B></td>
						<td class="label" ><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
						<td class="label" COLSPAN='2'>
							<select name="order_type" id="order_type">
								<option value="ALL" selected><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
								<option value="NOR"><fmt:message key="ePH.RxOrder.label" bundle="${ph_labels}"/></option>
								<option value="CO"><fmt:message key="ePH.CompoundingOrder.label" bundle="${ph_labels}"/> </option>
								<%=ivlegend_option%>
								<option value="CD"><fmt:message key="ePH.OncologyOrder.label" bundle="${ph_labels}"/></option>
								<option value="CA"><fmt:message key="ePH.OncologyAdmixture.label" bundle="${ph_labels}"/></option>
								<option value="TD"><fmt:message key="ePH.TPNStandard.label" bundle="${ph_labels}"/></option>
								<option value="TA"><fmt:message key="ePH.TPNAdmixture.label" bundle="${ph_labels}"/></option>
							</select>
						</td>
						<td class="label">&nbsp;</td>
						<td class="label"  style='<%=refFacDisplay%>' id='refFacLblDisplay'><fmt:message key="Common.ReferralFacility.label" bundle="${common_labels}"/></td>
						<td class='label' style='<%=refFacDisplay%>' id='refFacDisplay'>
							<SELECT name="TRACKING_REF_FACILITY" id="TRACKING_REF_FACILITY" >
							<option value=''>&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;</option>
<%
							for(int i=0;i<referralfcy.size();i+=2){
								if(defFacilicty.equals((String)referralfcy.get(i)))
									defSelect = "selected";
								else
									defSelect = "";
%>
								<option  VALUE="<%=(String)referralfcy.get(i)%>" <%=defSelect%>><%= referralfcy.get(i+1) %></option>
<%
							}
%>
							</SELECT>&nbsp;<img  src="../../eCommon/images/mandatory.gif"></img>
						</td>
					</tr>
					<tr><td colspan='8'>&nbsp;</td></tr>
					<tr>
						<td class="label" colspan='6'>&nbsp;</td>
						<td class="label" colspan='2' style='text-align:right;'>
							<input type="button"   class="button" name="btnSwitch" id="btnSwitch" value='<fmt:message key="ePH.SwitchLogin.label" bundle="${ph_labels}"/>' onClick="switchToLogin()" style='<%=dispSwitchLogin%>'>&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="button" id="btnSearch" name="btnSearch" id="btnSearch" value='<fmt:message key="Common.Refresh.label" bundle="${common_labels}"/>' class="button" onClick="getResult();">&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
					</tr>
					<tr><td colspan='8'><HR class='HR' id='commonOutSourceDtlHR' style='display:none;'></td></tr>
					<tr id='commonOutSourceDtl' style='display:none;vertical-align:top;' >
						<td class="label" style='<%=refFacDisplaySend%>' id='refFacLblDisplaySend'><fmt:message key="Common.ReferralFacility.label" bundle="${common_labels}"/></td>
						<td class='label' colspan='2' style='<%=refFacDisplaySend%>' id='refFacDisplaySend'>
							<SELECT name="OUTSOURCING_REF_FACILITY" id="OUTSOURCING_REF_FACILITY" >
							<option value='' >&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;</option>
<%
							for(int i=0;i<referralfcy.size();i+=2){
								if(defFacilicty.equals((String)referralfcy.get(i)))
									defSelect = "selected";
								else
									defSelect = "";
%>
								<option  VALUE="<%=(String)referralfcy.get(i)%>" <%=defSelect%>><%= referralfcy.get(i+1) %></option>
<%
							}
%>
							</SELECT>&nbsp;<img  src="../../eCommon/images/mandatory.gif"></img>
						</td>
						<td class="label"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/>
						<td class="label" colspan="5">
							<textarea  rows='6' cols='60' name="remarks" onKeyPress="return checkMaxLimit(this,2000,'');" onBlur="callCheckMaxLen(this,2000,'blr');"></textarea>
						</td>
					</tr>
				</table>
				<input type='hidden' name='drugLookupSql' id='drugLookupSql' value="<%=drugLookupSql%>"/>
				<input type='hidden' name='sourceURL' id='sourceURL' value='<%=bean.getSource()%>'/>
				<input type='hidden' name='language_id' id='language_id' value='<%=locale%>'/>
				<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
				<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
				<input type="hidden" name="trackingAction" id="trackingAction" value="<%=defAction%>">
				<input type="hidden" name="defFacilicty" id="defFacilicty" value="<%=defFacilicty%>">
				<input type="hidden" name="mode" id="mode" value="">
				<input type='hidden' name='updateRecCount' id='updateRecCount' value="0"/>
				<input type="hidden" name="homepage" id="homepage" value="<%=homepage%>">
			<form>
<%
			putObjectInBean(bean_id,bean,request);
		}
		catch(Exception e){
			e.printStackTrace();
		}
%>
	</BODY>
</HTML>

