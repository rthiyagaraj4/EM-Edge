<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
		 request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 ends

		 String locale			= (String)session.getAttribute("LOCALE");
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
	String called_from    = "CA";
	String mode			  = (String)CommonRepository.getCommonKeyValue("MODE_INSERT") ;
	String params		  = request.getQueryString() ;
	String location_code  = request.getParameter("location_code")==null?"":request.getParameter("location_code");
	String patient_class  = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
	String patient_id     = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String encounter_id	  = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");	
	String bed_num        = request.getParameter("bed_num")==null?"":request.getParameter("bed_num");
	String facility_id	  = (String) session.getValue("facility_id");

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
	ft_bean.setLanguageId(locale);
	ft_bean.setCurrentTimeAndAdminWithinHRS();
	String mar_disp_held_disc_orders_yn=bean.getMarDispHeldDiscOrdersYN();
	String mar_disp_held_disc_check ="";
	boolean marPrintYn = ft_bean.isSiteSpecific("PH", "MAR_PRINT_YN"); // Added for GHL-CRF-0458
	if(mar_disp_held_disc_orders_yn.equals("Y"))
		mar_disp_held_disc_check= "checked";
	
	if(patient_class.equals("IP") || patient_class.equals("DC")){
		ft_bean.setPatientClass("I");
	}
	if(patient_class.equals("EM") || patient_class.equals("OP")){
		ft_bean.setPatientClass("O");
	}

	String userAuthPINYN		= ft_bean.getUserAuthPINYN(facility_id);
	bean.setSchMARParams();
	HashMap hmSchMARDtl = bean.getSchMARParams();
	String mar_default_order_by = "", mar_disc_dose_yn="N", from_date="", to_date="", mar_disc_dose_chk="", mar_iv_compl_dt_ind="";
	if(hmSchMARDtl!=null & hmSchMARDtl.size()>0){
		mar_default_order_by = (String)hmSchMARDtl.get("MAR_DEFAULT_ORDER_BY");
		mar_disc_dose_yn = (String)hmSchMARDtl.get("MAR_DISC_DOSE_YN");
		mar_iv_compl_dt_ind = (String)hmSchMARDtl.get("MAR_IV_COMPL_DT_IND");
		from_date = (String)hmSchMARDtl.get("FROM_DATE");
		to_date =(String) hmSchMARDtl.get("TO_DATE");
	}
	if(mar_disc_dose_yn.equals("Y"))
		mar_disc_dose_chk="checked";
	ArrayList adroute=ft_bean.getAdminRoute();
	ArrayList adroute_categ=ft_bean.getAdminRouteCategory();

	//frmMARSchLevelCriteria
%>
	<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
		<form name="MedicationAdministrationSearchForm" id="MedicationAdministrationSearchForm" >
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
				<tr>
	 				<td class="label" width='10%'><fmt:message key="Common.ViewBy.label" bundle="${common_labels}"/></td>
	 				<td class='field' width='10%'><select name='viewBy' id='viewBy' onChange='viewByChange(this)' >
	 	  					<option value='W' selected><fmt:message key="Common.weekly.label" bundle="${common_labels}"/></option>
	 	  					<option value='M' ><fmt:message key="Common.monthly.label" bundle="${common_labels}"/></option>
	 					</select>
						<input type='hidden' name='viewCount' id='viewCount' value='0'>
					</td>
	 				<td class="label" width='5%'><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
	 				<td class='field' width='10%'>
	 	  				<input type='text' name='fromDate' id='fromDate'  size="13" maxlength="16" value="<%=DateUtils.convertDate(from_date, "DMY","en",locale)%>" disabled>
	 	  				<IMG SRC="../../eCommon/images/CommonCalendar.gif" id='from_time_calendar'>
					</td>
	 				<td class="label" width='5%'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
	 				<td class='field' width='15%'>
	 	  				<input type='text'  name='toDate' id='toDate' size="13" maxlength="16" value="<%=DateUtils.convertDate(to_date, "DMY","en",locale)%>"  disabled>
	 	  				<IMG SRC="../../eCommon/images/CommonCalendar.gif" id='from_time_calendar'>
	 				</td>
	 				<td class="label" width='15%' id='Navigation'><b><a href="javascript:SubmitLink('P');">< <fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>&nbsp;&nbsp;&nbsp;<a href="javascript:SubmitLink('N');"> <fmt:message key="Common.next.label" bundle="${common_labels}"/> > </a></b>
	 				</td>
					
	 				<td class="button" width='10%'><input type='button' id='Show' name='btnShowCriteria' id='btnShowCriteria' value='<fmt:message key="Common.morecriteria.label" bundle="${common_labels}"/>' onclick='showHideCriteria();'></td>
	 				<td class="button" width='10%'><input type='button' name='btnSearch' id='btnSearch' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick='searchMednAdmin("MARSCH");'></td>
	 				<% if(marPrintYn){ //  Added for GHL-CRF-0458 - Start %>
				<td class="button" width='10%'><input type='button' name='btnPrint1' id='btnPrint1'  value='<fmt:message key="Common.print.label" bundle="${common_labels}"/>' onclick='printReports("MARSCH");'> </td>
					<%}  //  Added for GHL-CRF-0458 - End %>
					<td class="label">&nbsp;</td>
      			</tr>
			</table>
			<table id='trMoreCriteria'  style='display:inline;' cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
				<tr><td colspan='4'>&nbsp;</td></tr>
				<tr>
					<td class="label" width='20%'><fmt:message key="ePH.displayOrderby.label" bundle="${ph_labels}"/>
					</td>
					<td class='field' width='15%'>
						<select name='display_order_by' id='display_order_by' onChange='' >
							<OPTION value="D" <%=mar_default_order_by.equals("D")?"selected":""%>><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></OPTION>
							<OPTION value="F" <%=mar_default_order_by.equals("F")?"selected":""%>><fmt:message key="ePH.DosageForm.label" bundle="${ph_labels}"/></OPTION>
							<OPTION value="O" <%=mar_default_order_by.equals("O")?"selected":""%>><fmt:message key="ePH.OrderDate/Time.label" bundle="${ph_labels}"/></OPTION>
						</select>
					</td>
					<td class="label" colspan='2'>&nbsp;
					</td>  
				</tr>
				<tr >
					<td class="label" ><fmt:message key="ePH.AdminRouteCategory.label" bundle="${ph_labels}"/>
					</td>
					<td class='field'>
						<select name="admin_route_category" id="admin_route_category" onChange='reloadAdminRoutes(this);'>
	 	 				<option>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
<%
						if(adroute_categ!=null)	{
							for(int rouc=0;rouc<adroute_categ.size();rouc+=2){
%>
								<option value=<%=adroute_categ.get(rouc)%>><%=adroute_categ.get(rouc+1)%></option>
<%
							}
						}
%>
						</select>
					</td>
					<td   class="label" width='20%'><fmt:message key="ePH.RouteOfAdministration.label" bundle="${ph_labels}"/></td>
					<td class='field' width='*'>
						<select name="route_of_admin" id="route_of_admin">
	 					<option>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
<%
						if(adroute!=null){
							for(int rou=0;rou<adroute.size();rou+=2){
%>
								<option value=<%=adroute.get(rou)%>><%=adroute.get(rou+1)%></option>
<%
							}
						}
%>
						</select>
					</td>  
				</tr>
				<tr>
					<td class="label" ><fmt:message key="Common.Include.label" bundle="${common_labels}"/>
					</td>
					<td class='field'>
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
					<td   class="label"><fmt:message key="ePH.DisplayHeld/DiscontinuedOrders.label" bundle="${ph_labels}"/></td>
					<td class='field'><input type='checkbox' name='hold_discontinue_yn' id='hold_discontinue_yn' value='<%=mar_disp_held_disc_orders_yn%>' <%=mar_disp_held_disc_check%> onclick='assignValue(this)' >
					</td>  
				</tr>
				
			</table>
			<input type='hidden' value='<%=params%>' name='params' id='params'>
			<input type='hidden' value='<%=bean_id%>' name='bean_id' id='bean_id'>
			<input type='hidden' value='<%=bean_name%>' name='bean_name'  id='bean_name'>
			<input type='hidden' value='<%=ft_bean_id%>' name='ft_bean_id' id='ft_bean_id'>
			<input type='hidden' value='<%=ft_bean_name%>' name='ft_bean_name' id='ft_bean_name'>			
			<input type='hidden' value='<%=facility_id%>' name='facility_id' id='facility_id'>
			<input type='hidden' value='<%=patient_id%>' name='patient_id' id='patient_id'>
			<input type='hidden' value='<%=encounter_id%>' name='encounter_id' id='encounter_id'>
			<input type='hidden' value='<%=patient_class%>' name='patient_class' id='patient_class'>
			<input type='hidden' value='<%=patient_class%>' name='patient_class1' id='patient_class1'>
			<input type='hidden' value='<%=locale%>' name='locale' id='locale'>
			<input type='hidden' value='<%=location_code%>' name='nursing_unit' id='nursing_unit'>
			<input type='hidden' value='PH' name='called_from' id='called_from'>
			<input type='hidden' value='<%=bed_num%>' name='from_bed_no' id='from_bed_no'>
			<input type='hidden' value='<%=bed_num%>' name='to_bed_no' id='to_bed_no'>
			<input type='hidden' value='<%=bed_num%>' name='bed_num' id='bed_num'>
			<input type='hidden' value='<%=mar_disc_dose_yn%>' name='mar_disc_dose_yn' id='mar_disc_dose_yn'>
			<input type='hidden' value='<%=mar_iv_compl_dt_ind%>' name='mar_iv_compl_dt_ind' id='mar_iv_compl_dt_ind'>
			<input type="hidden" name="userAuthPINYN" id="userAuthPINYN"	value="<%=userAuthPINYN%>">  <!-- Added for RUT-CRF-0035 [IN029926] -->
			<input type='hidden' name="from_date" id="from_date" value='<%=from_date%>'> <!--  Added for GHL-CRF-0458  - Start -->
			<input type='hidden' name="to_date" id="to_date" value='<%=to_date%>'>
			<input type='hidden' name="user_name" id="user_name" value='<%=login_user%>'> <!--  Added for GHL-CRF-0458  - End -->
			<input type='hidden' value='N' name='disa' id='disa'>
			<script>
				searchMednAdmin("MARSCH");
			</script>
		</form>
	</body>
</html>
<%
	putObjectInBean(bean_id,bean,request);
	putObjectInBean(ft_bean_id,ft_bean,request);
%>

