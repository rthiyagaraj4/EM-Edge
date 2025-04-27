<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<HTML>
	<HEAD>
<%
	    request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
    	String locale			= (String)session.getAttribute("LOCALE");
        String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		 <script language="javascript" src="../../eCommon/js/common.js"></script>
		<script LANGUAGE="javascript" SRC="../../ePH/js/EditDispLabel.js"></SCRIPT>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title><fmt:message key="ePH.EditLabel.label" bundle="${ph_labels}"/></title>
	</HEAD>
<%
		//String facility_id		= (String) session.getValue( "facility_id" );
		String patient_id = (String) request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String patient_name = (String) request.getParameter("patient_name")==null?"":java.net.URLDecoder.decode(request.getParameter("patient_name"),"UTF-8");
		String ord_date_time = (String) request.getParameter("ord_date_time")==null?"":request.getParameter("ord_date_time");
		String pract_name = (String) request.getParameter("pract_name")==null?"":request.getParameter("pract_name");
		String dispense_date_time = (String) request.getParameter("dispense_date_time")==null?"":request.getParameter("dispense_date_time");
		String order_id = (String) request.getParameter("order_id")==null?"":request.getParameter("order_id");
		String iv_prep_yn = (String) request.getParameter("iv_prep_yn")==null?"":request.getParameter("iv_prep_yn");
		String bean_id = "EditDispLabelBean" ;
		String bean_name = "ePH.EditDispLabelBean";
		EditDispLabelBean bean = (EditDispLabelBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.setLanguageId(locale);
		String allow_edit_disp_label = bean.getAllowEditDispLabel();  //Added for Bru-HIMS-CRF-414 [IN045554] -start
		String params = request.getQueryString() ;
		String dispense_date = "";//Added for Bru-HIMS-CRF-414 [IN045554] -end
%>
		<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
		<form name="frmEditLabelHeader" id="frmEditLabelHeader">
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0" >
<%
				if(!allow_edit_disp_label.equals("Y")){//if condition & else part added for //Added for Bru-HIMS-CRF-414 [IN045554]
%>
					<tr>
						<td class= "COLUMNHEADER" colspan="4" align="left"><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></td>
					</tr>
					<tr>
						<td class="label" colspan="4">&nbsp;</td>
					</tr>
					<tr>
						<td class="label" width='15%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>   :</td>
						<td class="label" width='20%'><b><%=patient_id%></b></td>
						<td class="label" width='15%'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/> </td>
						<td class="label" width='50%'><b><%=patient_name%></b></td>
					</tr>
					<tr>
						<td class="label" width='15%'><fmt:message key="ePH.PrescDate.label" bundle="${ph_labels}"/> :</td>
						<td class="label" width='20%'><b><%=com.ehis.util.DateUtils.convertDate(ord_date_time,"DMYHM","en",locale)%></b></td>
						<td class="label" width='15%'><fmt:message key="ePH.PrescBy.label" bundle="${ph_labels}"/> </td>
						<td class="label" width='50%'><b><%=pract_name%></b></td>
					</tr>
					<tr>
						<td class="label" colspan="4">&nbsp;</td>
					 </tr>
<%
				}
				else{ //Added for Bru-HIMS-CRF-414 [IN045554]
					String	bean_id_1			=	"DispMedicationBean" ;
					String	bean_name_1		=	"ePH.DispMedicationBean";
					DispMedicationBean dispBean	= (DispMedicationBean)getBeanObject( bean_id_1, bean_name_1, request);
					String	bean_id_2		=	"DispMedicationAllStages" ;
					String	bean_name_2		=	"ePH.DispMedicationAllStages";
					DispMedicationAllStages dispASBean	= (DispMedicationAllStages)getBeanObject( bean_id_2, bean_name_2, request);
					String patient_class = (String) request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
					String sDfltLangForDispLabel	= dispBean.getDefaultLanguageForDispenseLabel(patient_id);
					String sDefaultEnglish			="selected",sDefaultLocLang="";
					String labelLangId = bean.getEditableLabelLangId();
					ArrayList langIdName = null;
					String localLang="";
					if(dispense_date_time.length()>10)
						dispense_date = dispense_date_time.substring(0,10);
					if(sDfltLangForDispLabel.equals("L")){
						labelLangId=dispASBean.getSMLOcalLanguageID();
						langIdName = dispASBean.getLangNameAndId(labelLangId);
					}
					langIdName = dispASBean.getDefLangForLabel(patient_class);
					if(langIdName==null || langIdName.size()==0 ){
						if(!locale.equals("en") ){
							langIdName = dispASBean.getLangNameAndId(locale);
						}
						else{
							langIdName = dispASBean.getLangNameAndId(dispASBean.getSMLOcalLanguageID());
						}
					}
					else {
						if(((String)langIdName.get(0)).equals("en")){
							langIdName = dispASBean.getLangNameAndId(dispASBean.getSMLOcalLanguageID());
						}
					}
					if(labelLangId==null || labelLangId.equals(""))
						labelLangId = locale;
					if(labelLangId.equals("en")){
						sDefaultEnglish		=	"selected";
						sDefaultLocLang		=	"";
					}
					else{
						sDefaultEnglish		=	"";
						sDefaultLocLang		=	"selected";
					}
%>
					<tr>
						<td class= "COLUMNHEADER" colspan='3' align="left"><font style='font-size:12;'><B><fmt:message key="ePH.EditLabel.label" bundle="${ph_labels}"/></B></font></td>
					</tr>
					<tr>
						<td width='20%' class='label'><b><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></b></td>
						<td width='60%' class='label'><%=patient_name%><br>
							<%=patient_id%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=com.ehis.util.DateUtils.convertDate(dispense_date,"DMY","en",labelLangId)%>
						</td>
						<td width='20%' class='label'><fmt:message key="Common.Language.label" bundle="${common_labels}"/>&nbsp;&nbsp;
							<select name="labelLangId" id="labelLangId" onchange='setlabelLangId();'>
								<option value="en" <%=sDefaultEnglish%>> <fmt:message key="Common.English.label" bundle="${common_labels}"/></option>
<%
								if(langIdName!=null && langIdName.size()>0 && !((String)langIdName.get(0)).equals("en")){
									localLang = langIdName.get(1)==null?"":(String)langIdName.get(1);
%>
									<option value="<%=langIdName.get(0)%>" <%=sDefaultLocLang%>> <%=localLang%></option>
<%
								}
%>
							</select>
						</td>
					</tr>
					<tr>
						<td class="label" colspan="3">&nbsp;</td>
					 </tr>
<%
				}
%>
			</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
			<input type="hidden" name="dispense_date_time" id="dispense_date_time" value="<%=dispense_date_time%>">
			<input type="hidden" name="order_id" id="order_id" value="<%=order_id%>">
			<input type="hidden" name="iv_prep_yn" id="iv_prep_yn" value="<%=iv_prep_yn%>">
			<input type="hidden" name="allow_edit_disp_label" id="allow_edit_disp_label" value="<%=allow_edit_disp_label%>"><!--Added for Bru-HIMS-CRF-414 [IN045554] -->
			<input type="hidden" name="params" id="params" value="<%=params%>"> <!--Added for Bru-HIMS-CRF-414 [IN045554] -->
		</form>
	</body>
	<script>
		setlabelLangId();
	</script>
</html>


