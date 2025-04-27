<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
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

		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String homepage = request.getParameter("homepage")==null?"":request.getParameter("homepage") ; //Added for Bru-HIMS-CRF-073.1 [IN:047222]
		String scope = request.getParameter("scope")==null?"":request.getParameter("scope") ; //Added for Bru-HIMS-CRF-073.1 [IN:047222]
		String store_code = request.getParameter("store_code")==null?"":request.getParameter("store_code") ; //Added for Bru-HIMS-CRF-073.1 [IN:047222]
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>	
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>	
		<script language="JavaScript" src="../../ePH/js/RegPrescriptions.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
		<form name="RegPrescriptionsQueryCriteria" id="RegPrescriptionsQueryCriteria"  >
<%
		try{
			String bean_id    = "RegPrescriptionsBean" ;
			String bean_name  = "ePH.RegPrescriptionsBean";
			//String  date_name ="Order Date From"; 
			//String  date_name =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderDateFrom.label","common_labels"); //code commented for Bru-HIMS-CRF-418[IN045564] 
			String  date_name =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Period.label","common_labels")+" "+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.from.label","common_labels");	//code added for Bru-HIMS-CRF-418[IN045564] 							
			RegPrescriptionsBean bean = (RegPrescriptionsBean)getBeanObject(bean_id,bean_name,request) ;	
			//bean.setLanguageId(locale);
			// It will resturn all the dispense locations which statisfies all 5 conditions.
			String disp_details = bean.getDispLocations();
			bean.clearPrescriptionDetails();
			bean.clearPatientPayable(); //added for Bru-HIMS-CRF-094 [IN:029959]
			String facility_id			= (String) session.getValue( "facility_id" );
			// Add following two statements for SRR20056-SCF-7807[28329] 
			bean.getFromToDate(facility_id);
			String from_date=bean.getFromDate();
			String to_date=bean.getToDate();//Remove facility_id in parameter for SRR20056-SCF-7807[28329]		
			String dispExpOrders_yn = bean.getDispExpOrders();		//Added for ML-BRU-SCF-0987 [IN:042737]
			//String to_date=bean.getToDate(facility_id);
			//String date=bean.getToDate();
%>
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0" id="regprescriptionquerycriteriatable">
				<tr>
					<td  class="label"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
					<td  class="label"colspan="5">
						<select name="disp_locn_code" id="disp_locn_code" >
<%
						StringTokenizer st_disp_details = new StringTokenizer(disp_details,",");
						String code ="", desc="";
						while(st_disp_details.hasMoreTokens()){
							code=st_disp_details.nextToken();
							desc=st_disp_details.nextToken();
%>
							<option value="<%=code%>"><%=desc%></option>
<%
						}
%>
						</select>
					</td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td class="label">
						<input type="text" name="patient_id" id="patient_id" maxlength="<%=bean.getPatientIDLength()%>" onKeyPress="changeToUpper()" value="" onblur="defaultorder_status(this);callPatientSearch()"><input type="button" value="?" class="button" name="btnPatientID" id="btnPatientID" onClick="callPatientSearch()">
						<label class="hyperlink1" style="font-size:13px;cursor:pointer;color:#ff0000;" onClick="showPendingOrders(RegPrescriptionsQueryCriteria.patient_id.value,RegPrescriptionsQueryCriteria.disp_locn_code.value)"  style="visibility:hidden" id="pending_orders"><fmt:message key="Common.PendingOrders.label" bundle="${common_labels}"/></label>  
					</td>
					<td  class="label" nowrap><%=bean.getNationID()%></td>
						<td class="label">
							<input type="text" name="national_id_no" id="national_id_no" maxlength="20" size="20" value="" >
						</td>
						<td  class="label" nowrap>&nbsp;<%=bean.getHealthCardNo()%></td>
						<td class="label">
							<input type="text" name="health_card_num" id="health_card_num" maxlength="20" size="20" value="">
					</td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="Common.OrderNo.label" bundle="${common_labels}"/></td>
					<td class="label">
						<input type="text" name="order_id" id="order_id" maxlength="20" size="20" onBlur="ChangeUpperCase(this)" onKeyPress="return CheckForSpecChars(event)">
					</td>
					<td  class="label"><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
					<td class="label">
						<select name="priority" id="priority">
							<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
							<option value="U"><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
							<option value="R"><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
						</select>
					</td>
					<td  class="label"><fmt:message key="Common.Scope.label" bundle="${common_labels}"/></td> 
					<td class="label">
						<select name="order_status" id="order_status" onchange="checkDispExpOrders(this,'<%=dispExpOrders_yn%>');changeLegend(this);">
							   <option value="A" >--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
								<option value="P" selected><fmt:message key="ePH.NewPrescriptions.label" bundle="${ph_labels}"/></option>
								<option value="B"><fmt:message key="ePH.BMSPrescriptions.label" bundle="${ph_labels}"/></option>
								<option value="R"><fmt:message key="ePH.RefillPrescriptions.label" bundle="${ph_labels}"/></option>
								<option value="D"><fmt:message key="Common.DischargeMedication.label" bundle="${common_labels}"/></option> 
								<option value="E"><fmt:message key="ePH.ExpiredPrescriptions.label" bundle="${ph_labels}"/></option>
								<option value="XT"><fmt:message key="Common.ExternalPrescriptions.label" bundle="${common_labels}"/></option>
						</select>
					</td>
				</tr>
				<tr>
					<td  class="label" id='frm_legend'><%=date_name%></td>
					<td class="label" >						
						<input type="text" maxlength=10 name="order_date_from" id="order_date_from"  size="10" onBlur="CheckDateT(this);validateDate()" value="<%=com.ehis.util.DateUtils.convertDate(from_date,"DMY","en",locale)%>"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar name='CalFromDate'  onclick="showCalendar('order_date_from');document.RegPrescriptionsQueryCriteria.order_date_from.focus();return false;" > 
					</td><!-- changed the variable 'bean.getTodaysDate' to 'from_date' for SRR20056-SCF-7807[28329] -->
					<td  class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<td class="label">
						<input type="text" name="order_date_to" id="order_date_to" size="10" onBlur="CheckDateT(this);validateDate()" value="<%=com.ehis.util.DateUtils.convertDate(to_date,"DMY","en",locale)%>"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar  name='CalToDate'  onclick="showCalendar('order_date_to');document.RegPrescriptionsQueryCriteria.order_date_to.focus();return false;" >
					</td>
					<td colspan='2'><label style='color:blue;font-size:10px;FONT-WEIGHT: BOLDER;cursor:pointer;' id='reRoutePrescription' onclick="reRoutePrescription()"><fmt:message key="ePH.ReroutePrescription.label" bundle="${ph_labels}"/>	</label></td> <!--added  for Bru-HIMS-CRF-090 [IN:029956] -->
					<input type="hidden" name="re_route" id="re_route" value="Y">
				</tr>
				<tr>
					<td  class="label" nowrap><fmt:message key="Common.OrderingLocation.label" bundle="${common_labels}"/></td>
					<td  class="label">
						<select name="ord_loc_type" id="ord_loc_type" onChange="clearvalues(ord_locn_desc,ord_locn_code)">
							<option value="" selected><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option> <!-- code added for ML-BRU-SCF-0356[IN034602] -->
							<option value="C" ><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option> <!-- 'selected' value removed for ML-BRU-SCF-0356[IN034602] -->
							<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/> </option>
						</select>&nbsp;
						<input type="text" name="ord_locn_desc" id="ord_locn_desc" ><input type="button" class="button" value="?" name="btnordLocn" id="btnordLocn" onClick="searchCode(ord_locn_desc)" value="" ><input type="hidden" name="ord_locn_code" id="ord_locn_code" value="">  <!--onBlur="searchCode(ord_locn_desc)" code removed for ML-BRU-SCF-0356[IN034602] -->      
					</td>
					<td colspan='3'></td>
					<td class="label"  colspan="2" align="right"><input type="button" name="btnRefresh" id="btnRefresh" value='<fmt:message key="Common.Refresh.label" bundle="${common_labels}"/>' class="button" onClick="searchTheDataForHeaderAndFooter();"><label  name="no_of_patients" value="" id="no_of_patients" class="label"  size="4">
					</td>		
				</tr> 
			</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="Language_id" id="Language_id" value="<%=locale%>">
			<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>"> 
			<input type="hidden" name="SQL_PH_ALT_DISP_LOCN_SELECT1E" id="SQL_PH_ALT_DISP_LOCN_SELECT1E" value="<%=PhRepository.getPhKeyValue("SQL_PH_ALT_DISP_LOCN_SELECT1E")%>">
			<input type="hidden" name="SQL_PH_ALT_DISP_LOCN_SELECT1D" id="SQL_PH_ALT_DISP_LOCN_SELECT1D" value="<%=PhRepository.getPhKeyValue("SQL_PH_ALT_DISP_LOCN_SELECT1D")%>">
			<input type="hidden" name="SQL_PH_REG_PRES_ALL_SOURCE_SELECT" id="SQL_PH_REG_PRES_ALL_SOURCE_SELECT" value="<%=PhRepository.getPhKeyValue("SQL_PH_REG_PRES_ALL_SOURCE_SELECT")%>"> <!-- added for ML-BRU-SCF-0356[IN034602] -->
			<input type="hidden" name="facility_id" id="facility_id" value="<%=(String) session.getValue( "facility_id" )%>">
			<input type="hidden" name="autoCallReRoute_yn" id="autoCallReRoute_yn" value="<%=bean.getAutoCallReRouteYN()%>"> <!-- added for [IN:045320] -->
			<input type="hidden" name="callFrom" id="callFrom" value=""> <!-- added for [IN:045320] -->
			<input type="hidden" name="homepage" id="homepage" value="<%=homepage%>"> <!-- added for Bru-HIMS-CRF-073.1 [IN:047222]-->
<%
			putObjectInBean(bean_id,bean,request); 
		}
		catch(Exception e){
			e.printStackTrace();
		}
%>
		</form>
	</body>
<%
	if(!store_code.equals("") && homepage.equals("Y")){ //Added for Bru-HIMS-CRF-073.1 [IN:047222]
%>
		<script>
			document.RegPrescriptionsQueryCriteria.disp_locn_code.value='<%=store_code%>';
<%
			if(!scope.equals("")){
%>
				document.RegPrescriptionsQueryCriteria.order_status.value='<%=scope%>';
				document.RegPrescriptionsQueryCriteria.btnRefresh.click();
<%
			}
%>
		</script>
<%
	}
%>
</html>

