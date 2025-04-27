<!DOCTYPE html>
 <%@ page import ="java.util.*,java.sql.*,webbeans.eCommon.*" %>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<HTML>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String sql_ph_generic_name_lookup=PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_SELECT_LOOKUP");
		String sql_ph_drug_lookup=PhRepository.getPhKeyValue("SQL_PH_DRUG_ORDER_CAT_NOT_LINK_SELECT1");
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script language="Javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
		<Script language='JavaScript' src='../../eCommon/js/CommonResult.js'></Script>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/TrackingOutsourceMedication.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<%
		java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		String login_at_ws_no		        = prop.getProperty( "client_ip_address" );
		String	bean_id			=	"TrackingOutsourceMedicationBean" ;
		String	bean_name		=	"ePH.TrackingOutsourceMedicationBean";
		TrackingOutsourceMedicationBean bean = (TrackingOutsourceMedicationBean)getBeanObject(bean_id,bean_name ,request);
		String mode			= request.getParameter("mode");
		bean.setLanguageId(locale);
		bean.setMode( mode ) ;
		String facility_id					= (String) session.getValue("facility_id");
		String drugLookupSql = "SELECT DISTINCT drug_code code, drug_desc description FROM (SELECT drug_desc drug_desc, drug_code drug_code, LANGUAGE_ID FROM ph_drug_lang_vw  WHERE DISCONTINUED_YN !='Y' UNION SELECT NVL (short_name, long_name) drug_desc, tpn_regimen_code drug_code, LANGUAGE_ID FROM ph_tpn_regimen_lang_vw  WHERE DISCONTINUED_YN !='Y')  where upper(drug_code) like upper(?) AND upper(drug_desc) like upper (?) and language_id= ";
		ArrayList IVlegends             =  (ArrayList)bean.getIVLegends();
		String ivlegend_option="", refFacDisplay="", refFacDisplaySend="";
		for(int i=0;i<=IVlegends.size()-2;i=i+2){
			ivlegend_option	=ivlegend_option +	"<option value='"+((String) IVlegends.get(i))+"'>"+((String) IVlegends.get(i+1))+"</option>"; 
		}
		ArrayList referralfcy=bean.getReferralFacilities();	
%>
		<form name='query_form' id='query_form' method='post' action='TrackingOutsourceMedicationQueryResult.jsp' onsubmit='SelectAll()'>
			<table cellpadding=0 cellspacing=0 width="98%" align="center" border="0">
				<TR>
					<td  ALIGN="Center" COLSPAN="4"> &nbsp;    </td>
				</TR>
				<TR>
					  <TH  ALIGN="Left" COLSPAN="10" width='20%'> <fmt:message key="Common.QueryCriteria.label" bundle="${common_labels}"/>    </TH>
				</TR>
				<TR><td  ALIGN="Center" COLSPAN="4"> &nbsp;</td></TR>
				<tr>
					<td align="right" class="label" width='10%'>
						<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
					</td>
					<td align="left" class="label"  colspan='3'>
						<input type="text" name="patient_id" id="patient_id"  maxlength="<%=bean.getPatientIDLength()%>" size="18" value="" onKeyPress="uppercase()" onBlur="callPatientSearch('QUERY')"><input type="button" value="?"  class="button" name="btnPatientID" id="btnPatientID" onClick="callPatientSearch('QUERY')">
					</select>
					</td>
				</tr>
				<tr>	
					<td class="label" WIDTH="10%" >
						<fmt:message key="Common.Drug.label" bundle="${common_labels}"/>
					</td>
					<td class="label"   WIDTH="30%">
						<input type="text" name="drug_name" id="drug_name" size="45"  maxlength="60" value=""><input type="button" name="drug_search" id="drug_search" value="?" class="button"  onClick="searchDrugName('QUERY');">
						<input type='hidden' name='drug_code' id='drug_code' value=''>
					</td>
				</tr>
				<tr >
					<td class="label"><fmt:message key="Common.OrderDateFrom.label" bundle="${common_labels}"/></td>
					<td class='label'>
						<input type="text" name="order_date_from" id="order_date_from"  size="8" maxlength="10" onBlur="CheckDateT(this,'<%=locale%>');" value="<%=com.ehis.util.DateUtils.convertDate(bean.getDate_minus_30(),"DMY","en",locale)%>"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id='CalendarFromDate' onclick="showCalendar('order_date_from');document.query_form.order_date_from.focus();return false; " >
						&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/>
						<input type="text" name="order_date_to" id="order_date_to" size="8" maxlength="10" onBlur="CheckDateT(this,'<%=locale%>');" value="<%=com.ehis.util.DateUtils.convertDate(bean.getDate_plus_30(),"DMY","en",locale)%>"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id='CalendarToDate' onclick="showCalendar('order_date_to');document.query_form.order_date_to.focus();return false;">
					</td>
				</tr>
				<tr>
					<td class="label" ><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
					<td class="label">
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
				<tr>	
				</tr>
				<tr>
					<td class="label" ><fmt:message key="Common.ReferralFacility.label" bundle="${common_labels}"/></td>
					<td class='label' >
						<SELECT name="ref_facility" id="ref_facility" >
						<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
						for(int i=0;i<referralfcy.size();i+=2){
%>
							<option  VALUE="<%=(String)referralfcy.get(i)%>" ><%= referralfcy.get(i+1)%>
							</option>
<%
						}
%>
						</SELECT>
					</td>
				</tr>
				<tr>	
					<td class="label" WIDTH="10%"  > 
						<fmt:message key="Common.status.label" bundle="${common_labels}"/></label>
					</td>
					<td class="label"  WIDTH="30%" > 
						<select name="tracingStatus" id="tracingStatus" onChange="">
						<option value="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<option value='P'><fmt:message key="Common.Pending.label" bundle="${common_labels}"/></option>
						<option value='S'><fmt:message key="ePH.Sent.label" bundle="${ph_labels}"/></option>
						<option value='R'><fmt:message key="Common.received.label" bundle="${common_labels}"/></option>
						<option value='D'><fmt:message key="ePH.Delivered.label" bundle="${ph_labels}"/></option>
						</select>
					</td>
				</tr>
				<TR><td  ALIGN="Center" COLSPAN="4"> &nbsp;</td></TR>
				<TR><td  ALIGN="Center" COLSPAN="4"> 
					<table width='100%' align='center' >
						<tr>
							<th align='left' >
							<fmt:message key="Common.SortOrder.label" bundle="${common_labels}"/> </th>
						</tr>
						<tr>
							<td width='60%' > 
							<table width='100%'align='center' >
								<tr>
									<td align='center'><b><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
									<td>&nbsp;</td>
									<td align='center'><b><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
								</tr>
								<tr>
									<td width='45%' align='center'>
									<select name='orderbycols' id='orderbycols' size='8' style='width:120px;'>
										<option value='drug_desc'><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></option>
										<option value='order_date'><fmt:message key="Common.OrderDate.label" bundle="${common_labels}"/></option>
										<!--<option value='order_type'><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></option>
										<option value='referral_facility'><fmt:message key="Common.ReferralFacility.label" bundle="${common_labels}"/></option>
										<option value='status'><fmt:message key="Common.status.label" bundle="${common_labels}"/></option> -->
									 </select>
									</td>
									<td align='center' width='3%' >
										<input type='button' name='add' id='add' class='button' onclick='addOrderByCol()' value='---->'> 
										<input type='button' name='add' id='add' class='button'  value='<----' onclick='removeOrderByCol()'></img>
									</td>
									<td width='45%' align='center'>
										<select name='orderbycolumns' id='orderbycolumns' size='8' multiple='true'  style='width:120px;'>
											<option value='patient_id'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></option>
										</select>
									</td>
								</tr>
							</table>
							</td>
						</tr>
					</table>
					</td>
				</tr>
			</table>
			
			<br>
			<table border='0' width='100%' align='center'><tr><td width='100%' align='center' class='white'><input type='button' name='ExecuteQuery' id='ExecuteQuery' class='Button' onclick="execQuery()" value="Execute" ></td></tr>
			</table>

			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="mode" id="mode" value="<%=mode%>">	
			<input type='hidden' name='language_id' id='language_id' value='<%=locale%>'/>
			<input type='hidden' name='drugLookupSql' id='drugLookupSql' value="<%=drugLookupSql%>"/>
		</form>
	</body>
<%
	putObjectInBean(bean_id,bean,request);
%>
</HTML>

