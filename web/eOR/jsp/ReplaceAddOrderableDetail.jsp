<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* " %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
 <%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/CompleteOrder.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
 	<script language="JavaScript" src="../js/ViewOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
			function alignWidth() {

			var last=eval(document.getElementById("detailTab").rows.length)-1;
			if(document.getElementById("detailTab")!=null) {
					for(i=0;i <document.getElementById("detailTab").rows(last).cells.length;i++) {
						var wid=document.getElementById("detailTab").rows(last).cells(i).offsetWidth;
						var wid1= parent.CompleteOrderHeader.document.getElementById("titleTab").rows(0).cells(i).offsetWidth;
						if(eval(wid1) <eval(wid)){
							parent.CompleteOrderHeader.document.getElementById("titleTab").rows(0).cells(i).width=wid;
						} else {
							document.getElementById("detailTab").rows(last).cells(i).width = wid1;
						}
					}
				}
			}

	</script>

</head>
<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<form name=complete_order_dtl>
<%


	/* Mandatory checks start */
	String mode	   = "1";//request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_CompleteOrder" ;
	String bean_name = "eOR.CompleteOrderBean";
	String bean_id1 = "Or_ExistingOrder" ;
	String bean_name1 = "eOR.ExistingOrder";
	String view_bean_id = "Or_ViewOrder" ;
	String view_bean_name = "eOR.ViewOrder";

	String orderId = request.getParameter("orderId");
	orderId = (orderId == null) ? "" : orderId;
	String patient_id = request.getParameter("patient_id");
	patient_id = (patient_id == null) ? "" : patient_id;
 	String sex = request.getParameter( "sex" ) ;
	sex = (sex == null) ? "" : sex;
	String ord_facility_id = request.getParameter("ord_facility_id");
    ord_facility_id = (ord_facility_id == null) ? "":ord_facility_id;
    String iv_prep_yn = request.getParameter("iv_prep_yn");
    iv_prep_yn = (iv_prep_yn == null) ? "":iv_prep_yn;
    String ord_cat = request.getParameter("ord_cat");
    ord_cat = (ord_cat == null) ? "" : ord_cat;

    String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String facility_id = (String)session.getValue("facility_id");
	String practitioner_type  	= (String) session.getValue("practitioner_type");//Added by Uma on 5/12/2010 for IN021330

	ArrayList allValues = new ArrayList();
/* Mandatory checks end */

	/* Initialize Function specific start */
	CompleteOrderBean bean = (CompleteOrderBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(localeName);
	ExistingOrder bean1 = (ExistingOrder)getBeanObject( bean_id1, bean_name1 , request ) ;
	bean1.setLanguageId(localeName);
	ViewOrder view_bean = (ViewOrder)getBeanObject( view_bean_id, view_bean_name , request ) ;
	view_bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clear() ;
	bean.setMode( mode ) ;
	
    allValues = bean.viewOtherDetails(orderId,practitioner_type);
	


	String rd_install = bean1.getRadiology(facility_id); 
	String ot_install = bean1.getOTModule(facility_id);  
 	String slClassValue = "";
	String prepsdata = "";
	String order_category = "";
	String cont_order_ind = "";
	String dosage_unit			= "";
	String start_time_day_param = "";
	String pr_duration = "";
	String pr_duration_type = "";
	String quantity = "";
	String appl_sliding_scale_yn  = "";

	
%>
<table cellpadding=3 cellspacing=0 border=1 width="100%" id='headerTab' align='center'>
	<tr>
		<%	if (ord_cat.equals("PH")) {	%>
			<td class='columnheader' width='7%'><fmt:message key="Common.Form.label" bundle="${common_labels}"/></td>
			<td class='columnheader' width='15%'><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
			<td class='columnheader' width='15%'><fmt:message key="eOR.DosageUnit.label" bundle="${or_labels}"/></td>
		<%} else {%>
			<td class='columnheader' width='15%'><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
			<td class='columnheader' width='7%'><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
		<%}%>
		<td class='columnheader' width=''><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width=''><fmt:message key="Common.startdatetime.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width=''><fmt:message key="Common.enddatetime.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width=''><fmt:message key="Common.Qty.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width=''><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width=''><fmt:message key="eOR.Formats.label" bundle="${or_labels}"/></td>
		<td class='columnheader' width=''></td>
		<td class='columnheader' width=''><fmt:message key="Common.action.label" bundle="${common_labels}"/><!--Complete<BR><input type=checkbox name='select_all' id='select_all' onClick='clickAll()'>--></td>
	</tr>
</table>
<table cellpadding=3 cellspacing=0 border=1 width="100%"  id='detailTab' align='center' class="grid">
<%
	String curr_sys_date = "";
	//String curr_week_date  = "";
	//String last_week_date  = "";
	/*ArrayList sysdate = (ArrayList)bean.getSysDateTime(); //Commented beacuse of Thai Date validations on 17/02/2007
	for(int i=0;i<sysdate.size();i++){

		//last_week_date =  (String)sysdate.get(0);
		//curr_week_date =  (String)sysdate.get(1);
		curr_sys_date =  (String)sysdate.get(2);//bean.getSysDate();
	}*/
	curr_sys_date=com.ehis.util.DateUtils.getCurrentDate("DMYHM",localeName);

    for(int i=0; i<allValues.size(); i++){

		String[] record = (String [])allValues.get(i);

		if(record[1].compareTo("R")==0){
					record[1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
										
				}
					else if(record[1].compareTo("U")==0)
				{
					
					record[1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
									

				}
					else if(record[1].compareTo("S")==0)
				{
				
				record[1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
					

				}	

		
		slClassValue="gridData";
		if(!record[16].equalsIgnoreCase("N"))
		{
			// This is to present the row in the color got from database.
			if(record[16].equalsIgnoreCase("RED"))
				slClassValue = "ORCANCEL";
		}
		if(record[0] == null) record[0] = "";
		if(record[1] == null) record[1] = "";
		if(record[2] == null) record[2] = "";
		if(record[3] == null) record[3] = "";
		if(record[4] == null) record[4] = "";
		if(record[5] == null) record[5] = "";
		if(record[7] == null) record[7] = "";
		if(record[8] == null) record[8] = "";
		if(record[10] == null) record[10] = "";
		if(record[11] == null) record[11] = "";
		if(record[25] == null) record[25] = "";
		if(record[26] == null) record[26] = "";
		if(record[27] == null) record[27] = "";
		if(record[28] == null) record[28] = "";



		String appt_reqd_yn 			= record[18];
		String appt_date_time 			= record[19];
		String appt_ref_num 			= record[20];
		String cont_order_indicator		= record[17];
		String parent_order_id			= orderId;
		String parent_order_line_num	= record[9];
		dosage_unit						= record[23];

		// Added By Sridhar Reddy 060909 SRR20056-CRF-0274
		start_time_day_param = record[2] ;
		pr_duration = record[30] ;
		pr_duration_type = record[7] ;				
		quantity =  record[4] ;		
		// End SRR20056-CRF-0274
		appl_sliding_scale_yn =  record[31] ;
		if (appt_reqd_yn == null) appt_reqd_yn = "";
		if (appt_date_time == null) appt_date_time = "";
		if (appt_ref_num == null) appt_ref_num = "";
		if (cont_order_indicator == null) cont_order_indicator = "";
		if (parent_order_id == null) parent_order_id = "";
		if (parent_order_line_num == null) parent_order_line_num = "";
		if (dosage_unit == null) dosage_unit = "";
		if (appl_sliding_scale_yn == null) appl_sliding_scale_yn = "";

		//prepsdata = bean.getPrepsdata(record[13],record[9]) ;
		prepsdata = bean.getPrepsdata(orderId,record[9]) ;
		view_bean.setPrepsData(prepsdata,i);
//		prepsdata = "Test data";
		order_category = record[14];
		if(order_category==null) order_category= "";
		cont_order_ind =  record[17];

		String deptData  = "";
		deptData = bean1.getDeptdata(orderId,record[9]) ;
		view_bean.setDeptData(deptData,i);

		String instruction = "";
		 
		instruction = bean1.getPatientInstruction(orderId,record[9]) ;

		if(instruction == null)	instruction = "";

		String freq_code = record[6];
		if(freq_code == null)	freq_code = "";
		String schd_yn = "";
		String interval_type = "";
		if(!freq_code.equals(""))
		{
		String schedule[]  =  (String[])bean1.getScheduleYN(freq_code) ;
		schd_yn = schedule[0];
		interval_type = schedule[1];
		}
		
	 
		if(interval_type == null)	interval_type = "";
		if(schd_yn == null)			schd_yn = "";


%><%--<Script>alert('appt_reqd_yn=<%=appt_reqd_yn%>,appt_ref_num=<%=appt_ref_num%>,appt_date_time=<%=appt_date_time%>')</Script>--%>
		<tr>
			<% if (ord_cat.equals("PH")) {%>
			<td width='7%' class="<%=slClassValue%>"><font size=1><%=bean1.getFormDesc(record[24])%></td>
			<td width='15%' class="<%=slClassValue%>"><font size=1><%=record[0]%></td>
			<td width='15%' class="<%=slClassValue%>"><font size=1><%=dosage_unit%></Font>
			<%if ((bean1.getSplitDosageYN(parent_order_id,parent_order_line_num)).equalsIgnoreCase("Y")) {%>
			<BR><Font size='1' color='red'>(<fmt:message key="eOR.SplitDosage.label" bundle="${or_labels}"/>)</Font>
			<%}%>
			</td>
			<%} else {%>
			<td width='15%' class="<%=slClassValue%>"><font size=1><%=record[0]%></td>
			<td width='7%' class="<%=slClassValue%>"><font size=1><%=record[1]%></td>
			<%}%>
			<td width='13%' class="<%=slClassValue%>"><font size=1><%=record[10]%></td>
			<%
				if(record[2]!="")
				record[2]=com.ehis.util.DateUtils.convertDate(record[2],"DMYHM","en",localeName);
								
			%>
			<td width='15%' class="<%=slClassValue%>"><font size=1><%=record[2]%></td>
				<%
				if(record[3]!="")
				record[3]=com.ehis.util.DateUtils.convertDate(record[3],"DMYHM","en",localeName);
			%>
			<td width='15%' class="<%=slClassValue%>"><font size=1><%=record[3]%></td>
			<td width='3%' class="<%=slClassValue%>"><font size=1><%=record[4]%></td>
			<td width='9%' class="<%=slClassValue%>"><font size=1><%=record[5]%></td>
			<td width='9%' class="<%=slClassValue%>"><font size=1><a class="gridLink"  href="javascript:viewOrderFormatLineDtl('<%=orderId%>','<%=record[9]%>')"><%=record[11]%></a></td>
			<td width='7%' class="<%=slClassValue%>"><font size=1>
			<%--<input type="hidden" name="Cmts<%=i%>" id="Cmts<%=i%>" value="<%=record[12]%>">
			<input type="hidden" name="Preps<%=i%>" id="Preps<%=i%>" value="<%=prepsdata%>">
			<input type="hidden" name="Depts<%=i%>" id="Depts<%=i%>" value="<%=deptData%>">
			<input type="hidden" name="Instruction<%=i%>" id="Instruction<%=i%>" value="<%=instruction%>">--%>
			<input type="hidden" name="Appt<%=i%>" id="Appt<%=i%>" value="<%=appt_ref_num%>">
			<input type="hidden" name="Appt_date<%=i%>" id="Appt_date<%=i%>" value="<%=com.ehis.util.DateUtils.convertDate(appt_date_time,"DMYHM","en",localeName)%>">
			<input type="hidden" name="appt_locn<%=i%>" id="appt_locn<%=i%>" value="<%=record[25]%>">
			<input type="hidden" name="appt_resched_yn<%=i%>" id="appt_resched_yn<%=i%>" value="<%=record[26]%>">
			<input type="hidden" name="appt_resched_reason<%=i%>" id="appt_resched_reason<%=i%>" value="<%=record[27]%>">
			<input type="hidden" name="no_of_reschedules<%=i%>" id="no_of_reschedules<%=i%>" value="<%=record[28]%>">

			<input type="hidden" name="cont_order_indicator<%=i%>" id="cont_order_indicator<%=i%>" value="<%=cont_order_indicator%>">
			<input type="hidden" name="parent_order_id<%=i%>" id="parent_order_id<%=i%>" value="<%=parent_order_id%>">
			<input type="hidden" name="parent_order_line_num<%=i%>" id="parent_order_line_num<%=i%>" value="<%=parent_order_line_num%>">
	


			<%--<% if(record[12]!=null && !record[12].equals("")) { %> <a class="gridLink"  href="javascript:viewOrderFormatLineCmts1('Comments','<%=i%>','<%=record[9]%>','<%=orderId%>')"><fmt:message key="eOR.Cmts.label" bundle="${or_labels}"/></a> <% } else { %> <fmt:message key="eOR.Cmts.label" bundle="${or_labels}"/> <% } %>--%>
			<% if(record[12]!=null && !record[12].equals("")) { %> <a class="gridLink"  href="javascript:viewOrderFormatLineCmts('Comments','<%=i%>','<%=record[9]%>','<%=orderId%>')"><fmt:message key="eOR.Cmts.label" bundle="${or_labels}"/></a> <% } else { %> <fmt:message key="eOR.Cmts.label" bundle="${or_labels}"/> <% } %>
			<%--<br>	<% if(!(prepsdata.equals(""))){%> <a class="gridLink" href="javascript:viewCompletePrepsData(escape('<%=i%>'))"><fmt:message key="eOR.Preps.label" bundle="${or_labels}"/></a> <%} else { %> <fmt:message key="eOR.Preps.label" bundle="${or_labels}"/> <% } %>--%>
			<br>	<% if(!(prepsdata.equals(""))){%> <a class="gridLink" href="javascript:viewPrepsData(escape('<%=i%>'),'<%=parent_order_line_num%>')"><fmt:message key="eOR.Preps.label" bundle="${or_labels}"/></a> <%} else { %> <fmt:message key="eOR.Preps.label" bundle="${or_labels}"/> <% } %>
			<%--<br>	<% if(!(deptData.equals(""))){%> <a class="gridLink" href="javascript:viewCompleteDeptData(escape('<%=i%>'))"><fmt:message key="eOR.DeptInstrn.label" bundle="${or_labels}"/></a> <%} else { %> <fmt:message key="eOR.DeptInstrn.label" bundle="${or_labels}"/> <% } %>--%>
			<br>	<% if(!(deptData.equals(""))){%> <a class="gridLink" href="javascript:viewDeptData(escape('<%=i%>'),'<%=parent_order_line_num%>')"><fmt:message key="eOR.DeptInstrn.label" bundle="${or_labels}"/></a> <%} else { %> <fmt:message key="eOR.DeptInstrn.label" bundle="${or_labels}"/> <% } %>
			<br>	<% if(!instruction.equals("")) { %>
			<a class="gridLink" href="javascript:viewPatientData('<%=orderId%>','<%=record[9]%>','<%=i%>')"><fmt:message key="eOR.PatInstrn.label" bundle="${or_labels}"/></a> <%}else{%><fmt:message key="eOR.PatInstrn.label" bundle="${or_labels}"/> <% }%> 
				<!--<a href="javascript:viewPatientData('<%=record[13]%>','<%=orderId%>','<%=patient_id%>','<%=sex%>')">Pat.Instrn</a>  -->
			<% if((schd_yn.equals("Y"))){
				if(!order_category.equalsIgnoreCase("PH")) {
			%><br><a class="gridLink"  href="javascript:viewScheduleData('<%=orderId%>','<%=record[9]%>','<%=interval_type%>','<%=ord_facility_id%>','<%=freq_code%>','<%=order_category%>','complete_order_dtl','<%=pr_duration%>','<%=pr_duration_type%>','<%=quantity%>','<%=appl_sliding_scale_yn%>','<%=start_time_day_param%>')"><fmt:message key="eOR.Schd.label" bundle="${or_labels}"/></a>
			<%} else if (order_category.equalsIgnoreCase("PH") && (!iv_prep_yn.equals("")) && parent_order_line_num.equalsIgnoreCase("1")) {%>
			<br><a class="gridLink"  href="javascript:viewScheduleData('<%=orderId%>','<%=record[9]%>','<%=interval_type%>','<%=ord_facility_id%>','<%=freq_code%>','<%=order_category%>','complete_order_dtl','<%=pr_duration%>','<%=pr_duration_type%>','<%=quantity%>','<%=appl_sliding_scale_yn%>','<%=start_time_day_param%>')"><fmt:message key="eOR.Schd.label" bundle="${or_labels}"/></a>
			<%} else if (order_category.equalsIgnoreCase("PH") && (iv_prep_yn.equals(""))) {%>
			<br><a class="gridLink"  href="javascript:viewScheduleData('<%=orderId%>','<%=record[9]%>','<%=interval_type%>','<%=ord_facility_id%>','<%=freq_code%>','<%=order_category%>','complete_order_dtl'),'<%=pr_duration%>','<%=pr_duration_type%>','<%=quantity%>','<%=appl_sliding_scale_yn%>','<%=start_time_day_param%>')"><fmt:message key="eOR.Schd.label" bundle="${or_labels}"/></a>
			<%}
			}%>
			<%--<%else {%>
			<br><fmt:message key="eOR.Schd.label" bundle="${or_labels}"/><% } %>--%>
			<% if((appt_reqd_yn.equals("Y")) && (!appt_ref_num.equals("")) && (!appt_date_time.equals(""))){%><br>
			   <% if( (order_category.equals("RD") && rd_install.equals("Y")) || 	(order_category.equals("OT") && ot_install.equals("Y"))	 ) { %>
				<a class="gridLink" href="javascript:viewCompleteApptData(escape('<%=i%>'))"><fmt:message key="eOR.ApptDetails.label" bundle="${or_labels}"/></a>
				<%  } else { %>
					<a class="gridLink" href="javascript:viewOACompleteApptData(escape('<%=i%>'))"><fmt:message key="eOR.ApptDetails.label" bundle="${or_labels}"/></a>
				<%  } %>
			<%} else if (!(cont_order_indicator.equalsIgnoreCase("DO") || cont_order_indicator.equalsIgnoreCase("CO"))){
				String apptYN = bean.getAppointmentYN(parent_order_id,parent_order_line_num);
				if (apptYN != null && apptYN.equalsIgnoreCase("Y")) {%><br>
				<% if( (order_category.equals("RD") && rd_install.equals("Y")) || 	(order_category.equals("OT") && ot_install.equals("Y"))	 ) { %>
					<a class="gridLink" href="javascript:viewCompleteApptData(escape('<%=i%>'))"><fmt:message key="eOR.ApptDetails.label" bundle="${or_labels}"/></a>
				<%  } else { %>
				<a class="gridLink" href="javascript:viewOACompleteApptData(escape('<%=i%>'))"><fmt:message key="eOR.ApptDetails.label" bundle="${or_labels}"/></a>
				<%  } %>
				<%}
			}%>
				</td>
			<td width='10%' align=center class="<%=slClassValue%>"><font size=1>
			<%
				if(record[15].equalsIgnoreCase("Y")){%>
			<input type=checkbox name='chk<%=i%>' id='chk<%=i%>' onClick="checkOrderable('<%=i%>')">
			<%}else{%>
			
			<%}%>
			</td>
		</tr>
		<input type="hidden" name="catalog_desc<%=i%>" id="catalog_desc<%=i%>" value="<%=record[0]%>">
		<input type="hidden" name="line_status<%=i%>" id="line_status<%=i%>" value="<%=record[8]%>">
		<input type="hidden" name="line_num<%=i%>" id="line_num<%=i%>" value="<%=record[9]%>">
		<input type="hidden" name="catalog_code<%=i%>" id="catalog_code<%=i%>" value="<%=record[13]%>">
		<input type="hidden" name="complete_remarks<%=i%>" id="complete_remarks<%=i%>" value="">
		<input type="hidden" name="complete_date<%=i%>" id="complete_date<%=i%>" value="">
		<input type="hidden" name="order_category<%=i%>" id="order_category<%=i%>" value="<%=order_category%>">
		<input type="hidden" name="instrn_type<%=i%>" id="instrn_type<%=i%>" value="<%=record[32]%>">				
					
<%	}%>
<input type="hidden" name="qrystr" id="qrystr" value="<%=request.getQueryString()%>">
<input type="hidden" name="cont_order_ind" id="cont_order_ind" value="<%=cont_order_ind%>">
<input type="hidden" name="line_stat_to_updt" id="line_stat_to_updt" value="">
<input type="hidden" name="ord_category" id="ord_category" value="<%=order_category%>">
<input type="hidden" name="order_category" id="order_category" value="<%=order_category%>">
<input type=hidden name='total_recs' id='total_recs' value='<%=allValues.size()%>'>
<input type="hidden" name="complete_type" id="complete_type" value="">
<input type="hidden" name="ord_id" id="ord_id" value="<%=orderId%>">
<input type="hidden" name='mode' id='mode' value="1">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
				
<input type=hidden name='function_from' id='function_from' value='Complete'>
<input type="hidden" name="complete_all_desc" id="complete_all_desc" value="">
<input type="hidden" name="curr_sys_date" id="curr_sys_date" value="<%=curr_sys_date%>">
<input type="hidden" name="complete_all_remarks" id="complete_all_remarks" value="">
<input type="hidden" name="complete_all_date" id="complete_all_date" value="">
<input type="hidden" name="practitioner_id" id="practitioner_id" value="<%=practitioner_id%>">

<!--  Added By Sridhar Reddy 060909 SRR20056-CRF-0274 -->
<input type="hidden" name="pr_duration" id="pr_duration" value="<%=pr_duration%>">
<input type="hidden" name="pr_duration_type" id="pr_duration_type" value="<%=pr_duration_type%>">
<INPUT TYPE="hidden" name="start_time_day_param" id="start_time_day_param" value="<%=start_time_day_param%>">
<INPUT TYPE="hidden" name="quantity" id="quantity" value="<%=quantity%>">
<!-- END 274-->

<tr style='visibility:hidden'>
		<td class='columnheader' width=''><fmt:message key="eOR.CatalogName.label" bundle="${or_labels}"/></td>
		<td class='columnheader' width=''><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width=''><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width=''><fmt:message key="Common.startdatetime.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width=''><fmt:message key="Common.enddatetime.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width=''><fmt:message key="Common.Qty.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width=''><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width=''><fmt:message key="eOR.Formats.label" bundle="${or_labels}"/></td>
		<td class='columnheader' width=''></td>
		<td class='columnheader' width=''></td>
</tr>
</table>
<script>
			if(document.getElementById("headerTab")==null)
			{
				setTimeout("alignHeading();",300);
			}
			else 
				alignHeading();
			</script>

</form>

<%--<script>
			if(parent.CompleteOrderHeader.document.getElementById("titleTab")!=null) {
				alignWidth();
			}
</script>--%>
</body>
</html>
<%
putObjectInBean(bean_id,bean,request);
putObjectInBean(bean_id1,bean1,request);
putObjectInBean(view_bean_id,view_bean,request);
%>

