<!DOCTYPE html>
  <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %><%-- Mandatory declarations end --%>
<html>
	<head>
		<title><fmt:message key="ePH.PostAdministrationDetails.label" bundle="${ph_labels}"/></title>
<%
		request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//endss
		String locale			= (String)session.getAttribute("LOCALE");
	
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="JavaScript" src="../../ePH/js/MedicationAdministration.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script> 
		<script language="Javascript" src="../../ePH/js/MedicationAdministrationFixedTime.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="ADRRemarksForm" id="ADRRemarksForm" >
<%
			String drug				=  request.getParameter("drug");
			String recno			=  request.getParameter("recno");
			String encounter_id		=  request.getParameter("encounter_id");
			String order_id			=  request.getParameter("order_id");
			String callFrom			=  request.getParameter("callFrom")==null?"":request.getParameter("callFrom");
			String scheKey			=  request.getParameter("scheKey")==null?"":request.getParameter("scheKey");
			String colvalue			=  request.getParameter("colvalue")==null?"":request.getParameter("colvalue");
			String sch_date_time	=  request.getParameter("sch_date_time")==null?"":request.getParameter("sch_date_time");
			String bean_id_1		= "MedicationAdministrationFTBean";
			String bean_name_1		= "ePH.MedicationAdministrationFTBean";
			MedicationAdministrationFTBean bean_1	= (MedicationAdministrationFTBean)getBeanObject( bean_id_1, bean_name_1 , request);	
			bean_1.setLanguageId(locale);
			String stDisabled = "";
			String bean_id		= "MedicationAdministrationBean";
			String bean_name	= "ePH.MedicationAdministrationBean";
			MedicationAdministrationBean bean	= (MedicationAdministrationBean)getBeanObject( bean_id, bean_name, request );	
			bean.setLanguageId(locale);
			String schule_date	=  bean_1.checkForNull(request.getParameter("sch_date"));
			ArrayList sch_date			= bean_1.loadSchDate(encounter_id,drug);
			//HashMap hmadr_details = null;
			ArrayList adr_details	=bean_1.getADRDetails(drug+"-"+schule_date);
			if(colvalue.equals("VPAD")){
			//	hmadr_details= bean.getADRDetail(encounter_id, sch_date_time, drug,order_id);
				stDisabled = "disabled";
			}
			System.err.println("=getQueryString===>"+request.getQueryString());
			String schdate				= "";
			String reason				= "";
			String remarks				= "";
			String record_date			= "";
			String record_by			= "";
			String sch_code				= "";
			String sch_desc				= "";
			String reason_code			=	"";
			String reason_desc			=	"";
			String bean_remarks="";
			ArrayList reasoncodes		=	new ArrayList();
			reasoncodes					=   bean.loadCodes("M");

			if(reasoncodes.size()>=2) {
				remarks	=	bean_1.getAdrRemarks((String)reasoncodes.get(0),"M");
			}
			/*if(hmadr_details!=null && hmadr_details.size()>0){
				schdate					= (String)hmadr_details.get("AGNST_SCHD");
				reason					= (String)hmadr_details.get("ADR_REASON");
				record_date				= (String)hmadr_details.get("ADR_RECORDED");
				remarks	=(String)hmadr_details.get("ADR_REMARKS");	
				record_by	=(String)hmadr_details.get("ADR_RECORDED_BY");	
			}*/
			if(adr_details.size() > 0){
				schdate					= (String)adr_details.get(0);
				reason					= (String)adr_details.get(1);
				if((String)adr_details.get(2) ==""){
					record_date             = bean_1.getSysdate();
				}
				else{			
					record_date				= bean_1.checkForNull((String)adr_details.get(2));
				}
				bean_remarks		=	bean_1.checkForNull((String)adr_details.get(3));
				if(!bean_remarks.trim().equals("")) {
					remarks	=	bean_remarks;	
				}

				if((String)adr_details.get(4) ==""){
					record_by = (String)session.getAttribute("login_user"); 
				}
				else{
					record_by				= bean_1.checkForNull((String)adr_details.get(4));
				}
			}
			if(remarks==null)
				remarks="";
%>
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
				<tr>
					<td class="label" ><fmt:message key="ePH.AgainstScheduledDose.label" bundle="${ph_labels}"/></td>
					<td class="label"><select name="scheduled_date" id="scheduled_date" onChange="setDefaultValues(ADRRemarksForm)" <%=stDisabled%>>
<%
						if(! (schule_date.length() > 0)){
							for(int i=0; i<sch_date.size(); i+=2) {
								sch_code	=	(String)sch_date.get(i);
								sch_desc	=	(String)sch_date.get(i+1); 

								if( (sch_code).equals(schdate) ){
%>
									<option value="<%=sch_code%>" selected><%=sch_desc%></option>
<%
								}
								else{
%>
									<option value="<%=sch_code%>" ><%=sch_desc%></option> 
<%
								}
							}
						}
						else{
%>
							<option value="<%=schule_date%>"><%=schule_date%></option>
<%
						}
%>
						</select>
					</td>
				</tr>
				<tr>

					<td class="label"  ><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
					<td class="label"><select name="reason_code" id="reason_code"  onchange="getAdrRemarks(ADRRemarksForm)" <%=stDisabled%>>
<% 
						for(int i=0; i<reasoncodes.size(); i+=2) {
							reason_code	=	(String)reasoncodes.get(i);
							reason_desc	=	(String)reasoncodes.get(i+1); 
							if( (reason_code).equals(reason) ) {
%>
								<option value="<%=reason_code%>" selected><%=reason_desc%></option>
<% 
								}
								else {	
%>
									<option value="<%=reason_code%>" ><%=reason_desc%></option> 
<%	
								}		
							}	
%>
						</select>&nbsp; <img src="../../eCommon/images/mandatory.gif" ></img>
					</td>
				</tr>
				<tr>
					<td class="label"  ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
					<td class="label">
						<textarea rows="4" cols="41" name="remarks" onKeyPress="return(checkMaxLimit(this,255));" <%=stDisabled%>><%=remarks%></textarea>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center" ></img>
					</td>
				</tr>
				<tr>
				<td  class="label"><fmt:message key="ePH.RecordedTime.label" bundle="${ph_labels}"/></td>
					<td class="label">
						<input type="text" name="record_date" id="record_date" onBlur="validateDateTime(ADRRemarksForm,this,'<%=locale%>')" value="<%=record_date%>" size="12" maxlength="16" tabindex='4' <%=stDisabled%>>
						<img src="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="showCalendar('record_date',null,'hh:mm');return false;" <%=stDisabled%>>&nbsp; <img src="../../eCommon/images/mandatory.gif" ></img>
					</td>
				</tr>
				<tr>
					<td class="label"  ><fmt:message key="Common.RecordedBy.label" bundle="${common_labels}"/>
					</td>
					<td class="label"><input type="text" name="administered_by" id="administered_by" maxlength="30" size="30" value="<%=record_by%>" onblur="searchCode(this);" <%=stDisabled%>><input type="button" class="button" name="btnAdminBy" id="btnAdminBy" value="?" onClick="searchCode(administered_by)" <%=stDisabled%>>
						<img src="../../eCommon/images/mandatory.gif" align="center" ></img>			
					</td>
				</tr>
				<tr>
					<td  colspan='2' align='center'>
<%
					if(colvalue.equals("VPAD")){
%>
						<input  type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' class="button"  onClick="parent.window.close();">
<%
					}
					else{
%>
						<input  type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' class="button"  onClick="setADRDetails(ADRRemarksForm,'<%=callFrom%>');parent.window.returnVal='OK'">
						<input  type="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' class="button"  onClick="removeADRDetails(ADRRemarksForm);parent.window.close();">
<%
					}
%>
				</td>
				</tr>
			</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id_1%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name_1%>">
			<input type="hidden" name="SQL_PH_MED_ADMIN_APPL_USERS" id="SQL_PH_MED_ADMIN_APPL_USERS" value="<%=PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_APPL_USERS")%>">
			<input type="hidden" name="drug" id="drug" value="<%=drug%>">
			<input type="hidden" name="recno" id="recno" value="<%=recno%>">
			<input type="hidden" name="appl_trn_type" id="appl_trn_type" value="M">
			<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
			<input type="hidden" name="order_id" id="order_id" value="<%=order_id%>" >
			<input type="hidden" name="sch_date_time" id="sch_date_time" value="<%=sch_date%>" >
			<input type="hidden" name="locale" id="locale" value="<%=locale%>">
			<input type="hidden" name="scheKey" id="scheKey" value="<%=scheKey%>">

		</form>
	</body>
</html>
<%
putObjectInBean(bean_id,bean,request);
putObjectInBean(bean_id_1,bean_1,request);
%>

