<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>	
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>	
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
		<script type="text/javascript" src="../../eCommon/js/dchk.js"></script>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../ePH/js/DispMedication.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="" onKeyDown="lockKey()">
		<form name="frmDispMedicationQueryCriteriaTokenInfo" id="frmDispMedicationQueryCriteriaTokenInfo" >
<%
			String bean_id				= "DispMedicationBean" ;
			String bean_name			= "ePH.DispMedicationBean";
			DispMedicationBean bean		= (DispMedicationBean)getBeanObject( bean_id, bean_name, request ) ;
			//String disp_stage			= bean.getDispStage();
			//Hashtable param_legends		= bean.getLegendsFromParam();

			String tok_series_status	= "";
			/*String disp_stage_name		= "";
			if(disp_stage.equals("V")){
				disp_stage_name = (String)param_legends.get("V");
			}else if(disp_stage.equals("A")){
				disp_stage_name = (String)param_legends.get("A");
			}else if(disp_stage.equals("F")){
				disp_stage_name = (String)param_legends.get("F");
			}else if(disp_stage.equals("B")){
				disp_stage_name = (String)param_legends.get("B");
			}else if(disp_stage.equals("D")){
				disp_stage_name = (String)param_legends.get("D");
			}else if(disp_stage.equals("AS")){
				disp_stage_name = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.AllStages.label","ph_labels");   
			}*/
			String disp_locn_code	=	bean.getDispLocnCode();
			ArrayList token_series	=	bean.loadTokenSeries(disp_locn_code);
			String queue_date       =   bean.getTodaysDate();
			String dflt_token_series_ind      =   bean.getDfltTokenSeriesInd();//Added for HSA-CRF-0136 [IN:048412]
			String def_sort_token_series_ind      =   bean.getDefSortTokenSeriesInd(); //Added for HSA-CRF-0136 [IN:048412]
			String generate_actual_token_yn      =   bean.getGenerateActualTokenYN();//Added for HSA-CRF-0136 [IN:048412]
			boolean defTokenSeriesFound= false; //added for [IN:037465]
			String defTokenSeries=""; //added for [IN:037465]

			if(token_series.size()==3) {
				tok_series_status	="disabled";
			}
			bean.setDispDfltDisplay_YN("N"); // Added For SRR20056-CRF-0663
%>
			<table cellpadding=0 cellspacing=0 width="100%" align="center">
				<tr>
					<td class="label" width='8%' nowrap id="dateLegend" ><fmt:message key="Common.QueueDate.label" bundle="${common_labels}"/></td>
					<td class="label" width='10%' ><input type="text" name="queue_date" id="queue_date"  size="8" maxlength="10" onBlur="CheckDateT(this);clearTokenValues(token_series,token_no,'<%=token_series.size()%>');" value="<%=com.ehis.util.DateUtils.convertDate(queue_date,"DMY","en",locale)%>" ><IMG SRC="../../eCommon/images/CommonCalendar.gif" id='Calendar' name='Calendar'  onclick="showCalendar('queue_date');document.frmDispMedicationQueryCriteriaTokenInfo.queue_date.focus();return false;" > <!--added ,'<%=token_series.size()%>' in clearTokenValues & removed setDefQueueDateToFrom(this)from onBlur for KAUH-SCF-0057 [IN:034750]-->
					<img src="../../eCommon/images/mandatory.gif"></td>
					<td class="label" width='8%' ><fmt:message key="ePH.TokenSeries.label" bundle="${ph_labels}"/></td>
					<td class="label" width='10%' ><select name="token_series" id="token_series" <%=tok_series_status%> onChange="populateToken(document.frmDispMedicationQueryCriteriaTokenInfo);tokenToGetFacility(document.frmDispMedicationQueryCriteriaTokenInfo)"><!--  tokenToGetFacility(document.frmDispMedicationQueryCriteriaTokenInfo)  added for ML-BRU-SCF-0340[IN:034556] -->
					<option value="">&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;</option>
<% 
					if(token_series.size()==3) {
						tok_series_status	="selected";
					}
					if(dflt_token_series_ind.equals("A") && token_series.size()>3){
						defTokenSeries = "*A";
						defTokenSeriesFound = true; 
%>
						<option value="*A" selected><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
<%
					}
					for (int i=0; i<token_series.size(); i+=3) { 
						if( ((String)token_series.get(i+1)).equals("Y") && dflt_token_series_ind.equals("W")){ //if block and else condition added for [IN:037465]
							defTokenSeriesFound = true; 
							defTokenSeries = (String)token_series.get(i); 
%>
							<option value="<%=token_series.get(i)%>"  selected><%=token_series.get(i+2)%></option>
<%	
						}
						else{
%>
							<option value="<%=token_series.get(i)%>" <%=tok_series_status%>><%=token_series.get(i+2)%></option>
<%
						}
					}
%>
					</select><img src="../../eCommon/images/mandatory.gif">
					</td>
					<td  class="label" width='7%' ><fmt:message key="ePH.TokenNo.label" bundle="${ph_labels}"/></td>
					<td class="label" width='18%' ><input type="text" name="token_no" id="token_no" size="6" maxlength="6" onBlur="CheckNum(this);validateToken(document.frmDispMedicationQueryCriteriaTokenInfo);tokenToGetFacility(document.frmDispMedicationQueryCriteriaTokenInfo)" onkeyPress='return allowValidNumber(this,event,6,0)' class="NUMBER" value="">
					<!--  tokenToGetFacility(document.frmDispMedicationQueryCriteriaTokenInfo)  added for ML-BRU-SCF-0340[IN:034556] -->
					<input type="button" name="btn_next_token" id="btn_next_token" id="btn_next_token" value='<fmt:message key="ePH.NextToken.label" bundle="${ph_labels}"/>' class="button" onClick="validateTokenNo(token_no,'btnNextToken');tokenToGetFacility(document.frmDispMedicationQueryCriteriaTokenInfo)">
					<!--  tokenToGetFacility(document.frmDispMedicationQueryCriteriaTokenInfo)  added for ML-BRU-SCF-0340[IN:034556] -->
					</td>
					<td  class="label" nowrap width='8%' ><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
					<td class="label" width='8%' ><SELECT name="sort_token_series_ind" id="sort_token_series_ind"  >
						<option VALUE='O' selected><fmt:message key="Common.OrderDateTime.label" bundle="${common_labels}"/></option>
						<option VALUE='R' ><fmt:message key="ePH.RegisterDateTime.label" bundle="${ph_labels}"/></option>
<%
						if(generate_actual_token_yn.equals("Y")){
%>
						<option VALUE='P' ><fmt:message key="ePH.PatientArrived.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="Common.time.label" bundle="${common_labels}"/></option>
<%
					}
%>
					</td>
					<td  class="label" nowrap width='8%' ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td class="label"  >
						<input type="text" name="patient_id" id="patient_id" maxlength="<%=bean.getPatientIDLength()%>" size="18" value="" onKeyPress="uppercase()" onblur="getResultForPatient('<%=bean.getPatientIDLength()%>')"><input type="button" value="?" class="button" name="btnPatientID" id="btnPatientID" onClick="callPatientSearch()" ></label>
					</td>
					<!--<td class="label" ><fmt:message key="ePH.DispenseStage.label" bundle="${ph_labels}"/></td>
					<td class="label" >&nbsp;<b><%/*=disp_stage_name*/%></b></td>-->
				</tr>		
			</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="language_id" id="language_id" value="<%=locale%>">
			<input type="hidden" name="sys_date" id="sys_date" value="<%=queue_date%>">
			<input type="hidden" name="function_id" id="function_id" value="<%=bean.getSFunctionId()%>">
			<input type="hidden" name="defTokenSeries" id="defTokenSeries" value="<%=defTokenSeries%>"> <!-- added for [IN:037465] -->
		</form>
		<script>
<%
			if((token_series.size()==3  || defTokenSeriesFound) && bean.getIssueTokenOnRegnYN().equals("Y") && bean.getDispRegnReqdYN().equals("Y")) { // added || defTokenSeriesFound for [IN:037465]
%>
				populateToken(document.frmDispMedicationQueryCriteriaTokenInfo);
<%
			}
			if(dflt_token_series_ind.equals("A") && !defTokenSeriesFound && token_series.size()>3){
%>
				document.frmDispMedicationQueryCriteriaTokenInfo.token_series.value='*A';
<%
			}
%>
			document.frmDispMedicationQueryCriteriaTokenInfo.sort_token_series_ind.value='<%=def_sort_token_series_ind%>'; //Added for HSA-CRF-0136 [IN:048412]
		</script>
	</body>
</html>

