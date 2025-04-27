<!DOCTYPE html>
<%/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
06/01/2021	 TFS-25868		Prabha				GHL-CRF-0627
---------------------------------------------------------------------------------------------------------------
*/ %>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="JavaScript" src="../../ePH/js/PhRepRePrintDispLabelSheet.js"></script>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
		<form name="frmRePrintDispLabelSheetCriteria" id="frmRePrintDispLabelSheetCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame"> 
<%
//Added for GHL-CRF-0627 - Start
	Connection con			= null;
		try{
			con				= ConnectionManager.getConnection(request);
			boolean disp_sheet = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DISP_SHEET_CHECK");
//Added for GHL-CRF-0627 - End
			String patient_id	=	"";
			String bean_id		= "RePrintDispLabelSheetBean" ;
			String bean_name	= "ePH.RePrintDispLabelSheetBean";
			RePrintDispLabelSheetBean bean = (RePrintDispLabelSheetBean)getBeanObject( bean_id,bean_name, request) ;
			bean.setLanguageId(locale);
			SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date date_time	 	= new java.util.Date();
			//String Sysdate 				= dtSystemFormat.format(date_time); //commented for SKR-SCF-1005[IN048684]
			String Sysdate 				= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);	 //added for SKR-SCF-1005[IN048684]
			ArrayList localLang1 = new ArrayList();	//Added For ML-BRU-SCF-0538 [IN:036179] - Start
			String newLocalLanguage ="";
			String localLang ="";
			String sDefaultLocLang = "";
			if(!locale.equals("en")){
				localLang1 = bean.getLangNameAndId(locale);
				newLocalLanguage =(String)localLang1.get(0);
				sDefaultLocLang ="selected";
			}
			else{
				newLocalLanguage=bean.getSMLOcalLanguageID();
				localLang1 = bean.getLangNameAndId(newLocalLanguage);
			}
			if(localLang1 !=null && localLang1.size()>0)
				localLang =(String)localLang1.get(1);
			//Added For ML-BRU-SCF-0538 [IN:036179] - End
			
			//Added for GHL-CRF-0627 - Start
			String dispense_sheet="N";
			if(disp_sheet==true)
			{
				dispense_sheet="Y";
			}
			//Added for GHL-CRF-0627 - End
%>
			<table cellpadding="0" cellspacing="0" width="98%" align="center" border="0" id="tblRePrintDispLabelSheetCriteria">
	            <TH COLSPAN="4" ><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>

				<tr>
					<td align="left" width='25%'>
					<%if(disp_sheet){ //added for skr-scf-1696
          %>
						<input type="radio" name="report_type" id="report_type" value="L" checked onclick='clearResult();checkDispCriteria(this);'><fmt:message key="ePH.DispenseLabel.label" bundle="${ph_labels}"/>  <!-- Modified for GHL-CRF-0627 -->
						<input type="radio" name="report_type" id="report_type" value="S"  onclick='clearResult();checkDispCriteria(this);'><fmt:message key="ePH.DISPENSESHEET.label" bundle="${ph_labels}"/>&nbsp;&nbsp;  <!-- Modified for GHL-CRF-0627 -->
					<%} else{%>
						<input type="radio" name="report_type" id="report_type" value="L" checked onclick='clearResult();'><fmt:message key="ePH.DispenseLabel.label" bundle="${ph_labels}"/>  
						<input type="radio" name="report_type" id="report_type" value="S"  onclick='clearResult();'><fmt:message key="ePH.DISPENSESHEET.label" bundle="${ph_labels}"/>&nbsp;&nbsp;
				
					<%} %>
					</td>
				</tr>
				<tr>
				</tr>
				<tr>
					<td align="right" class="label" width='15%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td align="left" width='25%'>&nbsp;
						<input type="text" name="patient_id" id="patient_id" value="<%=patient_id%>" maxlength="<%=bean.getPatientIDLength()%>" size="20" onKeyPress="changeToUpper()" onchange="Duplicatecheck();" ><!-- code 'chkPatientID();'  is replaced by 'Duplicatecheck()'  for ML-BRU-SCF-0621[IN036565]-->
						<input type="button" value="?" class="button" name="btnPatientID" id="btnPatientID" onClick="callPatientSearch()">
						<label id='patDetails'></label>
					</td>
					<td align="right" class="label" width='15%'><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
					<td align="left" width='25%'>&nbsp;
						<select name="p_pat_class" id="p_pat_class" onChange="loadStages(p_pat_class);populateDispNo();">
							<option value="IP"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
							<option value="OP"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
							<option value="XT"><fmt:message key="Common.external.label" bundle="${common_labels}"/></option>
						</select>
					</td>
				 </tr>
				<tr>
					<td align="right" class="label" width='15%'><fmt:message key="ePH.DispensedDate.label" bundle="${ph_labels}"/></td>
					<td align="left" width='25%'>&nbsp;
						<input type="text" name="dispense_date" id="dispense_date"  size="10" Onblur="CheckDateT(this); if(DateCheck(sysdate,dispense_date)) { populateDispNo();}" value='<%=Sysdate%>'>
						<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dispense_date');"></td>
					</td>
					<td align="right" class="label" width='15%'><fmt:message key="ePH.DispenseNo.label" bundle="${ph_labels}"/></td>
					<td align="left" width='25%'>&nbsp;
					<select name="p_disp_no" id="p_disp_no"><!--code 'onChange="setDispNo(this)"' added for HSA-SCF-0038[IN050015] -->
					<option value="">&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;</option>
					<!-- value="All" removed for [IN:035576]-->
					</select>
					</td>
				</tr>
				<tr>
					<td align="right" class="label" width='15%'><fmt:message key="Common.Stage.label" bundle="${common_labels}"/></td>
					<td align="left" width='25%'>&nbsp;
					<select name="stage" id="stage" onChange="populateDispNo()">
						<option value="F" selected><fmt:message key="ePH.Filling.label" bundle="${ph_labels}"/></option>
						<option value="D"><fmt:message key="ePH.Delivery.label" bundle="${ph_labels}"/></option>
					</select>
					</td>
					<td align="right" class="label" width='15%'><fmt:message key="Common.Language.label" bundle="${common_labels}"/>
					</td>
					<td align="left" width='25%'>&nbsp;

					<select name="language" id="language"  onchange="changeLanguage(this)"/> <!-- onchange="changeLanguage(this)" Added for IN031262  -->
						<option value="en"><fmt:message key="Common.English.label" bundle="${common_labels}"/></option> 
<%
						if(localLang != null && !localLang.equals("")){
%>
							<option value="<%=newLocalLanguage%>" <%=sDefaultLocLang%>><%= localLang%></option>  
<%
						}
%>
					</select>
					</td> 
				</tr>
				<tr>
					<td colspan="3" align="right"> &nbsp;</td>
					<td style='text-align:right;'> 
						<input type="button" name="btnSearch" id="btnSearch" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class="button" onClick="showResults('<%=patient_id%>')">
						<input type="button" disabled class="button" name="viewReport" id="viewReport" value='<fmt:message key="Common.view.label" bundle="${common_labels}"/>' onClick="showReport('<%=patient_id%>','V')">
						<input type="button" disabled class="button" name="btnPrint" id="btnPrint" value='<fmt:message key="Common.print.label" bundle="${common_labels}"/>' class="button" onClick="showReport('<%=patient_id%>','P')">&nbsp;&nbsp;&nbsp;
					</td>
				</tr>
			</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
			<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="">
			<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
			<INPUT TYPE="hidden" name="locale" id="locale" VALUE="<%=locale%>">
			<input type="hidden" name="p_offline_print_seq_no" id="p_offline_print_seq_no" value="">
			<input type="hidden" name="p_language_id" id="p_language_id" value="<%=locale%>">
			<INPUT TYPE="hidden" name="sysdate" id="sysdate" VALUE="<%=Sysdate%>">
			<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
			<input type="hidden" name="p_patient_id" id="p_patient_id" value=""><!--code added for HSA-SCF-0038[IN050015]-->
			<input type="hidden" name="p_reprint_yn" id="p_reprint_yn" value="Y">
			<INPUT TYPE="hidden" name="P2MULDISP" id="P2MULDISP" VALUE=""><!-- added for SKR-SCF-1278-->
			<INPUT TYPE="hidden" name="disp_nos" id="disp_nos" VALUE=""><!-- added for SKR-SCF-1278-->
			<INPUT TYPE="hidden" name="p_disp_date" id="p_disp_date" VALUE=""><!-- added for SKR-SCF-1483-->
			<INPUT TYPE="hidden" name="p_disp_sheet" id="p_disp_sheet" VALUE="<%=dispense_sheet%>"> <!-- Added for GHL-CRF-0627 -->

<%
			putObjectInBean(bean_id,bean,request); 
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{ 	 //Added for GHL-CRF-0627 - Start
			if(con != null)
				ConnectionManager.returnConnection(con,request);	
		}     //Added for GHL-CRF-0627 - End
%>
		<script>
			populateDispNo();
		</script>
		</form>
	</body>
</html>

