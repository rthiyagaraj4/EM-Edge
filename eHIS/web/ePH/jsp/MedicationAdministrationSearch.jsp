 <!DOCTYPE html>
 <!-- 
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
10/08/2020	    IN73611             Shazana		MMS-DM-CRF-0174.4
--------------------------------------------------------------------------------------------------------------
-->

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*,java.sql.*,webbeans.eCommon.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
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
		// 
		 String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<!-- import the calendar script -->
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="Javascript" src="../../ePH/js/MedicationAdministration.js"></script>
		<script language="Javascript" src="../../ePH/js/MedicationAdministrationFixedTime.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<script language="JavaScript" src="../js/PhCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="JavaScript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
	Connection con			= null;
	try
	{
	
	String called_from    = "PH";
	ArrayList adroute     = null;
	ArrayList adroute_categ= null;
	String mode			  = (String)CommonRepository.getCommonKeyValue("MODE_INSERT") ;
	String params		  = request.getQueryString() ;
	String facility_id	  = (String) session.getValue("facility_id");
	String user_id		  = (String) session.getValue("login_user");
	String location_code  = request.getParameter("location_code")==null?"":request.getParameter("location_code");
	String patient_class  = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
	String patient_id     = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String bed_num        = request.getParameter("bed_num")==null?"":request.getParameter("bed_num");
	String encounter_id	  = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");

   	String call_from_ca        = request.getParameter("call_from_ca")==null?"":request.getParameter("call_from_ca");
	if(call_from_ca.equals("undefined"))
		call_from_ca="";
	String option_id        = request.getParameter("option_id")==null?"":request.getParameter("option_id");
	if(option_id.equals("undefined"))
		option_id="";

	//getting the reqd values from MedicationAdministrationBean 

	 String login_user	=	(String)session.getValue("login_user");

	String bean_id		= "MedicationAdministrationBean";
	String bean_name	= "ePH.MedicationAdministrationBean";
	MedicationAdministrationBean bean	= (MedicationAdministrationBean)getBeanObject( bean_id, bean_name , request);
	bean.setLanguageId(locale);
	HashMap dateValues  =  bean.getdateValues();
	String sys_date     = (String)dateValues.get("sys_date");
	String back_date    = (String)dateValues.get("back_date");
	
	bean.clear();
	String ft_bean_id				= "MedicationAdministrationFTBean";
	String ft_bean_name				= "ePH.MedicationAdministrationFTBean";
	MedicationAdministrationFTBean ft_bean	= (MedicationAdministrationFTBean)getBeanObject( ft_bean_id, ft_bean_name, request );
	ft_bean.clear();
	ft_bean.setLanguageId(locale);
	ft_bean.setCurrentTimeAndAdminWithinHRS();
	String mar_disp_held_disc_orders_yn=bean.getMarDispHeldDiscOrdersYN();//added for [IN:043283] -Start
	String mar_disp_held_disc_check ="";
	String printDisblYN   = ""; // Added for GHL-CRF-0458 - Start
   	boolean marPrintYn = ft_bean.isSiteSpecific("PH", "MAR_PRINT_YN");
   	printDisblYN   = "style=visibility:hidden";
    if(marPrintYn){
   	    if(!patient_id.equals("")){
   		   printDisblYN   = "style=visibility:visible"; 
   	    }
    }
    else{
    	 printDisblYN   = "style=visibility:hidden";
    }  // Added for GHL-CRF-0458 - End
	if(mar_disp_held_disc_orders_yn.equals("Y"))
		mar_disp_held_disc_check= "checked"; //added for [IN:043283] - End
	
	if(patient_class.equals("IP") || patient_class.equals("DC")){
		ft_bean.setPatientClass("I");
	}
	if(patient_class.equals("EM") || patient_class.equals("OP")){
		ft_bean.setPatientClass("O");
	}

	ArrayList result = ft_bean.getCurrentTimeAndAdminWithinHRS();
	String current_date_time	= (String)result.get(0);
	String disa                 ="N";
	if(!locale.equals("en"))
		current_date_time = DateUtils.convertDate(current_date_time, "DMYHM",locale,"en");

	String from_date_time		= ft_bean.getFromDateTime(current_date_time);

//	String to_date_time			= current_date_time;//removed for IN062053	
	String to_date_time			= ft_bean.getAdiminWindowToDateTime(current_date_time);	
	String userAuthPINYN		= ft_bean.getUserAuthPINYN(facility_id); //RUT-CRF-0035 [IN029926] Added for User Auth PIN Validation
	//if(!locale.equals("en")) current_date_time = DateUtils.convertDate(current_date_time, "DMYHM","en",locale);
	String SQL_PH_MED_ADMIN_SELECT17=PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_SELECT17");
	String SQL_PH_MED_ADMIN_SELECT18=PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_SELECT18");

     	con				= ConnectionManager.getConnection(request);
     	boolean mc_site = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_BARCODE_INT_EXT");
	 System.err.println("mc_site=========99===>"+mc_site);
%>
	<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
		<form name="MedicationAdministrationSearchForm" id="MedicationAdministrationSearchForm" >
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
     <tr>
	 	  <td   class="label" style="font-weight:bold"><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>

<%	
			if(patient_class.equals("")){		
 %> 
	
				<td  class="label"><input type="radio" name="patient_class" id="patient_class" value="IP" checked onclick="setValue(this);"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></td>
				<td  class="label"><input type="radio" name="patient_class" id="patient_class" value="DC" onclick="setValue(this);"><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></td>
				<td  class="label"><input type="radio" name="patient_class" id="patient_class" value="E" onclick="setValue(this);"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></td>
				<td  class="label"><input type="radio" name="patient_class" id="patient_class" value="A" onclick="setValue(this);"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></td>
			   <td></td>
 <%
		}
		else{
			if(patient_class.equals("IP")){
%>
				<td   class="label" style="font-weight:bold" colspan=5><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></td>
<%			  }else if(patient_class.equals("OP")){%>
				<td   class="label" style="font-weight:bold" colspan=5><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></td>
<%			  }else if(patient_class.equals("EM")){%>
				<td   class="label" style="font-weight:bold" colspan=5><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></td>
<%			  }else if (patient_class.equals("DC")){%>
				<td   class="label" style="font-weight:bold" colspan=5><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></td>
<%			  }

       }
 %>
     </tr>
				<tr>
						<td  class="label"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
                        <td  class='field' nowrap><input type='text' name='nursing_unit_desc' id='nursing_unit_desc' value='<%=location_code%>' onChange="locationSearch(nursing_unit,'<%=login_user%>');">
					    <input type="button" name="location_search" id="location_search" id ='location_search' value="?" class="button"  onClick="locationSearch(nursing_unit,'<%=login_user%>');">&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></img>
						<input type='hidden' name='nursing_unit' id='nursing_unit' value='<%=location_code%>'>
						<input type="hidden" name="back_date" id="back_date" value="<%=back_date%>">
						<input type="hidden" name="sys_date" id="sys_date" value="<%=sys_date%>">
					</td>
					<td  class="label"><fmt:message key="ePH.AdministrationWindow.label" bundle="${ph_labels}"/></td>
					<td  > <input type="text" name="admin_from_date" id="admin_from_date" size="13" maxlength="16" value="<%=from_date_time%>" onblur="showAdminToDate(this)" disabled>
					</td>
					<td  class='label'><fmt:message key="Common.to.label" bundle="${common_labels}"/>
					<input type="text" name="admin_to_date" id="admin_to_date" size="13" maxlength="16" value="<%=to_date_time%>" onblur="showAdminFromDate(this)" disabled></td>
					
				</tr>
				<tr>	
					<td  class="label" ><fmt:message key="ePH.AdministrationStatus.label" bundle="${ph_labels}"/></td>
					<td class='field'>
						<select name="administration_status" id="administration_status" onChange='changeFromTime();'>
							<option value="DUE"><fmt:message key="ePH.DueforAdministration.label" bundle="${ph_labels}"/></option>
	<!-- 					<option value="OVERDUE">Overdue for Administration</option> -->
							<option value="ALL"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
							<%if(marPrintYn){ // Added for GHL-CRF-0458 - Start %>
							<option value="DOA"><fmt:message key="ePH.Administered.label" bundle="${ph_labels}"/></option>
							<% } // Added for GHL-CRF-0458 - End %>
						</select>
					</td>	
					<td  class="label"><label id="from_label" ><fmt:message key="Common.from.label" bundle="${common_labels}"/>&nbsp;</label>
					</td>
					<td  ><input type='text' name='from_time' id='from_time' size='13' maxlength='16'  onBlur="validateDateTime(MedicationAdministrationSearchForm,this,'<%=locale%>')" value="<%=from_date_time%>"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id='from_time_calendar' onClick="var onBlurfn = document.getElementById('from_time').onblur; document.getElementById('from_time').onblur=null;  showCalendar('from_time',null,'hh:mm'); setTimeout(function() {	document.getElementById('from_time').onblur= onBlurfn;}, 500);return false;" >&nbsp;<img align="center" name='from_time_man' src="../../eCommon/images/mandatory.gif" >
					</td>
					<td   class="label" nowrap>
						<label id="to_label" > <fmt:message key="Common.to.label" bundle="${common_labels}"/></label>
						<input type='text' name='to_time' id='to_time' size='13' maxlength='16'  onBlur="validateDateTime(MedicationAdministrationSearchForm,this,'<%=locale%>')" value="<%=to_date_time%>"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id='to_time_calendar' onclick="var toonBlurfn = document.getElementById('to_time').onblur; document.getElementById('to_time').onblur=null; showCalendar('to_time',null,'hh:mm');setTimeout(function() {	document.getElementById('to_time').onblur= toonBlurfn;}, 500);return false;">
						<img align="center" name='to_time_man' id='to_time_man' src="../../eCommon/images/mandatory.gif" >
					</td>
					
				</tr>
				<tr>
					<td class="label"><fmt:message key="ePH.displayOrderby.label" bundle="${ph_labels}"/></td>
					<td class = 'field'>
						<select name="display_order_by" id="display_order_by">
							<option value="D"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></option>
							<option value="F"><fmt:message key="ePH.DosageForm.label" bundle="${ph_labels}"/></option>
							<!-- <option value="R"><fmt:message key="ePH.AdminRoute.label" bundle="${ph_labels}"/></option> --> 
							<option value="S" selected><fmt:message key="ePH.ScheduledDateTime.label" bundle="${ph_labels}"/></option>
						</select>
					</td>
				<%	if(patient_id.equals("")){
                %>
					<TD CLASS="label"><fmt:message key="ePH.FromBedNo.label" bundle="${ph_labels}"/></td>
					<td>
						<input type="text" value="" name="from_bed_no" id="from_bed_no" size=6 onBlur="compareBeds()"> <input type="button" name="bed_search" id="bed_search"  value="?" class="button"  onClick="bedSearch(from_bed_no);">
					</TD>
					<TD CLASS="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/>					
						<input type="text" value="" name="to_bed_no" id="to_bed_no" size=6  onBlur="compareBeds()"> <input type="button" name="bed_search" id="bed_search" value="?" class="button"  onClick="bedSearch(to_bed_no);">
					</td>
					
                <%}else{%>
                     <TD CLASS="label" ><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></td>
					 <TD CLASS="label" colspan=2><b><%=bed_num%></b></td>
					 <input type='hidden' value='<%=bed_num%>' name='from_bed_no' id='from_bed_no'>
					 <input type='hidden' value='<%=bed_num%>' name='to_bed_no' id='to_bed_no'>
				<%}%>
				</tr>
				<tr>
				<%
				adroute=ft_bean.getAdminRoute();
				adroute_categ=ft_bean.getAdminRouteCategory();
				%>
				<td class="label" nowrap><fmt:message key="ePH.AdminRouteCategory.label" bundle="${ph_labels}"/></td>
				<td class='field'><select name="admin_route_category" id="admin_route_category" onChange='reloadAdminRoutes(this);'><option>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
				<%
				if(adroute_categ!=null)
				{
					for(int rouc=0;rouc<adroute_categ.size();rouc+=2)
					{
						%>
						<option value=<%=adroute_categ.get(rouc)%>><%=adroute_categ.get(rouc+1)%></option>
						<%
					}

				}
				%>
				</select></td>
				<td class="label" nowrap><fmt:message key="ePH.RouteOfAdministration.label" bundle="${ph_labels}"/></td>
				<td class='field'><select name="route_of_admin" id="route_of_admin"><option>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
				<%
				if(adroute!=null)
				{
					for(int rou=0;rou<adroute.size();rou+=2)
					{
						%>
						<option value=<%=adroute.get(rou)%>><%=adroute.get(rou+1)%></option>
						<%
					}

				}
				%>
				</select>
				</td>
				<td  class="label">&nbsp;<label style="display:none"><fmt:message key="Common.view.label" bundle="${common_labels}"/> <label>&nbsp;<input type='radio' name='time_type' id='time_type' value="M"  onclick='textDisable();'  style="display:none">&nbsp;<label style="display:none"><fmt:message key="Common.multiple.label" bundle="${common_labels}"/> </label>&nbsp;&nbsp;<input type='radio' name='time_type' id='time_type' value="F" style="display:none" onclick='textEnable();' checked>&nbsp;<label style="display:none"><fmt:message key="Common.single.label" bundle="${common_labels}"/></label>
				</td>
				</tr>
				<tr>					
					<td   class="label"><fmt:message key="Common.Include.label" bundle="${common_labels}"/>&nbsp;&nbsp;
					</td>
					<td>
						<select name="order_type" id="order_type">
							<option value="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
							<option value="Rx"><fmt:message key="ePH.Rx.label" bundle="${ph_labels}"/></option>
							<option value="COMP"><fmt:message key="ePH.CompoundingRx.label" bundle="${ph_labels}"/></option>
							<option value="IVRx"><fmt:message key="ePH.IVRx.label" bundle="${ph_labels}"/></option>
							<option value="PRN"><fmt:message key="Common.PRN.label" bundle="${common_labels}"/></option>
							<option value="STAT"><fmt:message key="Common.Stat.label" bundle="${common_labels}"/></option>
							<option value="TPN"><fmt:message key="ePH.TPN.label" bundle="${ph_labels}"/></option>
							<option value="CYTO"><fmt:message key="ePH.Oncology.label" bundle="${ph_labels}"/></option>
						</select>
					</td>							
					<td class="label" nowrap ><fmt:message key="ePH.DisplayHeld/DiscontinuedOrders.label" bundle="${ph_labels}"/>
					<td><input type="checkbox" name="hold_discontinue_yn" id="hold_discontinue_yn" size="13" value='<%=mar_disp_held_disc_orders_yn%>' onclick='assignValue(this)' <%=mar_disp_held_disc_check%>><!--value =mar_disp_held_disc_orders_yn &&  mar_disp_held_disc_check //added for [IN:043283]-->
<%					if(mc_site==true){ %>
						<font style='font-size:10;vertical-align: text-top;'><fmt:message key="ePH.BarCode.label" bundle="${ph_labels}"/></font>
						<input type="text" class='fields' name="barcode_id" id="barcode_id" style="text-align:right;background-color:#fde6d0" onkeydown="if (event.keyCode==13) {barcodeScan(this);}"  maxlength="100"  size=60  ><!--onblur="barcodeScan(this);" CRF-413.8, IN73611-->
<%					}
%>					
					</td>
					
					<td class='label'><input type="button" class="button" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick="searchMednAdmin()"></td>				
					<% if(marPrintYn){ %>
					<td class='label'><input type="button" class="button" name="btnPrint" id="btnPrint" value='<fmt:message key="Common.print.label" bundle="${common_labels}"/>' onclick="printReports();" <%=printDisblYN%>></td> <!--  Added for GHL-CRF-0458 -->
					<%} %>
				</tr>
			</table>
			<input type='hidden' value='<%=params%>' name='params' id='params'>
			<input type='hidden' value='<%=mode%>' name='mode' id='mode'>
			<input type='hidden' value='<%=bean_id%>' name='bean_id' id='bean_id'>
			<input type='hidden' value='<%=ft_bean_id%>' name='ft_bean_id'  id='ft_bean_id'>
			<input type='hidden' value='<%=ft_bean_name%>' name='ft_bean_name'  id='ft_bean_name'>
			<input type='hidden' value='<%=bean_name%>' name='bean_name' id='bean_name'>
			<input type='hidden' value='<%=called_from%>' name='called_from' id='called_from'>
			<input type='hidden' value='<%=facility_id%>' name='facility_id' id='facility_id'>
			<input type='hidden' value='<%=patient_id%>' name='patient_id' id='patient_id'>
			<input type='hidden' value='<%=bed_num%>' name='bed_num' id='bed_num'>
			<input type='hidden' value='<%=encounter_id%>' name='encounter_id' id='encounter_id'>
			<input type='hidden' value='<%=disa%>' name='disa' id='disa'>
			<input type='hidden' value='' name='patient_class1' id='patient_class1'>
			<input type='hidden' value='<%=patient_class%>' name='patient_class' id='patient_class'>
			<input type="hidden" name="call_from_ca" id="call_from_ca" value="<%=call_from_ca%>">
			<input type="hidden" name="option_id" id="option_id" value="<%=option_id%>">			
			<input type='hidden' value='<%=locale%>' name='locale' id='locale'>
			<input type="hidden" name="SQL_PH_MED_ADMIN_SELECT17" id="SQL_PH_MED_ADMIN_SELECT17"	value="<%=SQL_PH_MED_ADMIN_SELECT17%>">
			<input type="hidden" name="SQL_PH_MED_ADMIN_SELECT18" id="SQL_PH_MED_ADMIN_SELECT18"	value="<%=SQL_PH_MED_ADMIN_SELECT18%>">
			<input type="hidden" name="userAuthPINYN" id="userAuthPINYN"	value="<%=userAuthPINYN%>">  <!-- Added for RUT-CRF-0035 [IN029926] -->
			<input type='hidden' name="from_date_time" id="from_date_time" value='<%=from_date_time%>'> <!--  Added for GHL-CRF-0458  - Start -->
			<input type='hidden' name="to_date_time" id="to_date_time" value='<%=to_date_time%>'>
			<input type='hidden' name="user_name" id="user_name" value='<%=user_id%>'>
			<input type='hidden' value='<%=encounter_id%>' name='encounter_id1' id='encounter_id1'>
			<input type='hidden' value='<%=patient_id%>' name='patient_id1' id='patient_id1'> <!--  Added for GHL-CRF-0458 End -->
			<script>
				document.MedicationAdministrationSearchForm.time_type.value="F";
				//if(document.MedicationAdministrationSearchForm.barcode_id!=undefined){
				//document.MedicationAdministrationSearchForm.barcode_id.disabled=true;
				//}
			</script>
		</form>
	</body>
<% 
	if(disa.equals("Y")){ 
%>
		<script>
			searchMednAdmin();
		</script> 
<%
	}
%>
<%
    if(!patient_id.equals("")){
%>
    <script>
	    document.MedicationAdministrationSearchForm.location_search.click();
        document.MedicationAdministrationSearchForm.Search.click();
	</script>

<%}%>

</html>
<%
	putObjectInBean(bean_id,bean,request);
	putObjectInBean(ft_bean_id,ft_bean,request);

}catch(Exception e){
	e.printStackTrace();
}finally{ //CRF-413.8
	if(con != null)
		ConnectionManager.returnConnection(con,request);	
	}
%>

