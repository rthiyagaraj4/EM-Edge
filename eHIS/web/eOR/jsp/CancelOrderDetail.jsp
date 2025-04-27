<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------
Date		  Edit History	Name		Rev.Date		Rev.Name			Description
-------------------------------------------------------------------------------------------------------------------------------
01/08/2018		IN64543			Dinesh T		01/08/2018	Ramesh G		ML-MMOH-CRF-0776
14/10/2019      IN071315	    Nijitha S   14/10/2019   Ramesh G		    GHL-CRF-0607
25/03/2020	IN072752		Nijitha S	25/03/2020	Ramesh G	ML-MMOH-CRF-1229/12
-------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page contentType="text/html;charset=UTF-8"%> 

<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/CancelOrder.js"></script>
 	<!--<script language="JavaScript" src="../js/ViewOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
--><!--IN64543-->
	
	<script>
		function alignWidth() {

			var last=eval(document.getElementById("detailTab").rows.length)-1;
			if(document.getElementById("detailTab")!=null) {
					for(i=0;i <document.getElementById("detailTab").rows(last).cells.length;i++) {
						var wid=document.getElementById("detailTab").rows(last).cells(i).offsetWidth;
						var wid1= parent.CancelOrderHeader.document.getElementById("titleTab").rows(0).cells(i).offsetWidth;
						if(eval(wid1) <eval(wid)){
							parent.CancelOrderHeader.document.getElementById("titleTab").rows(0).cells(i).width=wid;
						} else {
							document.getElementById("detailTab").rows(last).cells(i).width = wid1;
						}
					}
				}
			}

	</script>
</head>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<form name=cancel_order_dtl id='cancel_order_dtl'>
<%
	/* Mandatory checks start */
	String mode	   = "1";//request.getParameter( "mode" ) ;
//	String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_ExistingOrder" ;
	String bean_name = "eOR.ExistingOrder";
	String bean_id1 = "Or_CancelOrder" ;
	String bean_name1 = "eOR.CancelOrder";
	String bean_id2 = "Or_ViewOrder" ;//IN64543
	String bean_name2 = "eOR.ViewOrder";//IN64543

	String orderId = request.getParameter("orderId");
	orderId = (orderId == null) ? "" : orderId;
	String ord_typ_code = request.getParameter("ord_typ_code");
	ord_typ_code = (ord_typ_code == null) ? "" : ord_typ_code;

	String patient_id = request.getParameter("patient_id");
	patient_id = (patient_id == null) ? "" : patient_id;
 	String cont_order_ind = request.getParameter("cont_order_ind");
	cont_order_ind = (cont_order_ind == null) ? "" : cont_order_ind;

	String sex = request.getParameter( "sex" ) ;
	sex = (sex == null) ? "" : sex;

 String p_called_from_ca = request.getParameter("p_called_from_ca")==null?"":request.getParameter("p_called_from_ca"); //IN071315

	String ord_facility_id = request.getParameter("ord_facility_id");
    ord_facility_id = (ord_facility_id == null) ? "":ord_facility_id;
    String iv_prep_yn = request.getParameter("iv_prep_yn")==null?"":request.getParameter("iv_prep_yn");
    //iv_prep_yn = (iv_prep_yn == null) ? "":iv_prep_yn;
    String ord_cat = request.getParameter("ord_cat");
    ord_cat = (ord_cat == null) ? "" : ord_cat;
	String facility_id = (String)session.getValue("facility_id");
	String practitioner_type  	= (String) session.getValue("practitioner_type");//Added by Uma on 5/12/2010 for IN021330
	String appl_sliding_scale_yn = "";
	ArrayList allValues = new ArrayList();
/* Mandatory checks end */

	/* Initialize Function specific start */
//	ExistingOrder bean = (ExistingOrder)mh.getBeanObject( bean_id, request,  bean_name ) ;
	ExistingOrder bean = (ExistingOrder)getBeanObject( bean_id, bean_name, request ) ;
	//CancelOrder bean1 = (CancelOrder)mh.getBeanObject( bean_id1, request,  bean_name1 ) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clear() ;
	bean.setMode( mode ) ;
	
	ViewOrder bean2 = (ViewOrder)getBeanObject( bean_id2, bean_name2, request );//IN64543
	bean2.setLanguageId(localeName);//IN64543
	
	allValues		= bean.viewOtherDetails(orderId,practitioner_type);

	String rd_install	=	bean.getRadiology(facility_id);
	String ot_install	=	bean.getOTModule(facility_id);
	
	String slClassValue = "";
	String prepsdata = "";
	String order_category = "";
	String dosage_unit			= "";
	String start_time_day_param = "";
	String pr_duration = "";
	String pr_duration_type = "";
	String quantity = "";


%>
<table cellpadding=3 cellspacing=0 border=1 width="100%" id='detailTab' align='center' class='gridData'>
		<%	if (ord_cat.equals("PH")) {	%>
			<th class='columnheader' width='7%' align="left"><fmt:message key="Common.Form.label" bundle="${common_labels}"/></th>
			<th class='columnheader' width='15%' align="left"><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></th>
			<th class='columnheader' width='15%' align="left"><fmt:message key="eOR.DosageUnit.label" bundle="${or_labels}"/></th>
		<%} else {%>
			<th class='columnheader' width='15%' align="left"><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></th>
			<th class='columnheader' width='7%' align="left"><fmt:message key="Common.priority.label" bundle="${common_labels}"/></th>
		<%}%>
		<th class='columnheader' width='' align="left"><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></th>
		<th class='columnheader' width='' align="left"><fmt:message key="Common.startdatetime.label" bundle="${common_labels}"/></th>
		<th class='columnheader' width='' align="left"><fmt:message key="Common.enddatetime.label" bundle="${common_labels}"/></th>
		<th class='columnheader' width='' align="left"><fmt:message key="Common.Qty.label" bundle="${common_labels}"/></th>
		<th class='columnheader' width='' align="left"><fmt:message key="Common.status.label" bundle="${common_labels}"/></th>
		<th class='columnheader' width='' align="left"><fmt:message key="eOR.Formats.label" bundle="${or_labels}"/></th>
		<th class='columnheader' width='' align="left"></th>
		<th class='columnheader' width='' align="left"><a  class='gridLink' id='hdr' ><font color='yellow'><fmt:message key="Common.reason.label" bundle="${common_labels}"/></a><div  id='display_hdr' style="display:none"><font color='yellow'><fmt:message key="Common.reason.label" bundle="${common_labels}"/></div><BR><input type=checkbox name='select_all' id='select_all' onClick='clickAll()'></th>
	</tr>

<%
	String rowColor = "";
	String appt_reqd_yn 		= "";
	String appt_date_time 		= "",	appt_ref_num 	=  "";
 	String cont_order_indicator = "",	parent_order_id 	=  "";
  	String parent_order_line_num=  "";

	for(int i=0; i<allValues.size(); i++){

		String[] record = (String [])allValues.get(i);
		/*if(i % 2 == 0){
			slClassValue = "QRYEVEN";
		}else{
			slClassValue = "QRYODD";
		}*/
		slClassValue="gridData";
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

		if(record[30] == null) record[30] = "";
		if(record[31] == null) record[31] = "";
		if(record[32] == null) record[32] = "";
		if(record[33] == null) record[33] = "";
		if(record[46] == null) record[46] = "";

		 appt_reqd_yn 			= record[20];
		 appt_date_time 			= record[21];
		 appt_ref_num 			= record[22];
		 cont_order_indicator		= record[23];
		 parent_order_id			= orderId;
		 parent_order_line_num	= record[9];
		dosage_unit						= record[28];

		// Added By Sridhar Reddy 060909 SRR20056-CRF-0274
			start_time_day_param = record[2] ;
			pr_duration = record[40] ;
			pr_duration_type = record[7] ;				
			quantity =  record[36] ;		
			// End SRR20056-CRF-0274
		appl_sliding_scale_yn =  record[46] ;	
		if (appt_reqd_yn == null) appt_reqd_yn = "";
		if (appt_date_time == null) appt_date_time = "";
		if (appt_ref_num == null) appt_ref_num = "";
		if (cont_order_ind == null) cont_order_ind = "";
		if (parent_order_id == null) parent_order_id = "";
		if (parent_order_line_num == null) parent_order_line_num = "";
		if (dosage_unit == null) dosage_unit = "";

		//prepsdata = bean.getPrepsdata(orderId,record[9]) ;//IN64543
		prepsdata =CommonBean.checkForNull(bean.getPrepsdata(orderId,record[9]),"");//IN64543
		bean2.setPrepsData(prepsdata,i);//IN64543
		order_category = record[14];
		if(order_category==null) order_category="";

		if(record[16].trim().equals("RED") || record[8].trim().equals("RD") || record[8].trim().equals("RJ")) rowColor = "orcancel"; else rowColor = slClassValue;

		String deptData  = "";
		//deptData = bean.getDeptdata(orderId,record[9]);//IN64543
		deptData = CommonBean.checkForNull(bean.getDeptdata(orderId,record[9]),"");//IN64543
		bean2.setDeptData(deptData,i);//IN64543

		String instruction = "";
		//String no_of_days = (String)bean.getPatientNoOfDays( patient_id, orderId) ;
		//if(no_of_days == null) no_of_days = ""; else	no_of_days = no_of_days.trim();


		//instruction = bean.getPatientInstruction(record[18],no_of_days,sex) ;
		//instruction = bean.getPatientInstruction(orderId,record[9]);//IN64543
		instruction = CommonBean.checkForNull(bean.getPatientInstruction(orderId,record[9]),"");//IN64543
		//if(instruction == null)	instruction = "";//IN64543

		String freq_code = record[6];
		if(freq_code == null)	freq_code = "";

		String schedule[]  =  (String[])bean.getScheduleYN(freq_code) ;
		String schd_yn = "";
		String interval_type = "";
		schd_yn = schedule[0];
		interval_type = schedule[1];
		//bean1.setIntervalType(interval_type);
		//schd_yn  = "Y";



		if(interval_type == null)	interval_type = "";
		if(schd_yn == null)			schd_yn = "";

// ==<%=record[16]
%><%--<Script>alert('appt_reqd_yn=<%=appt_reqd_yn%>,appt_ref_num=<%=appt_ref_num%>,appt_date_time=<%=appt_date_time%>')</Script>--%>
		<tr>
			<% if (ord_cat.equals("PH")) {%>
			<td width='7%' class="<%=rowColor%>"><font size=1><%=bean.getFormDesc(record[29])%></td>
			<td width='15%' class="<%=rowColor%>"><font size=1><%=record[0]%></td>
			<td width='15%' class="<%=rowColor%>"><font size=1><%=dosage_unit%></Font>
			<%if ((bean.getSplitDosageYN(parent_order_id,parent_order_line_num)).equalsIgnoreCase("Y")) {%>
			<BR><Font size='1' color='red'>(<fmt:message key="eOR.SplitDosage.label" bundle="${or_labels}"/>)</Font>
			<%}%>
			</td>
			<%} else {%>
			<td width='15%' class="<%=rowColor%>"><font size=1><%=record[0]%></td>
			<td width='7%' class="<%=rowColor%>"><font size=1><%=record[1]%></td>
			<%}%>
			<td width='15%' class="<%=rowColor%>"><font size=1><%=record[10]%></td>
			<td width='15%' class="<%=rowColor%>"><font size=1><%=com.ehis.util.DateUtils.convertDate(record[2],"DMYHM","en",localeName)%></td>
			<td width='15%' class="<%=rowColor%>"><font size=1><%=com.ehis.util.DateUtils.convertDate(record[3],"DMYHM","en",localeName)%></td>
			<td width='3%' class="<%=rowColor%>"><font size=1><%=record[4]%></td>
			<td width='10%' class="<%=rowColor%>"><font size=1>
			<%String can_reason = "";
				if(record[17]!=null && !record[17].equals("")) {%>
					<%can_reason = record[17].replace('\"','\n');
				}
			%>
			<input type="hidden" name="Cancel<%=i%>" id="Cancel<%=i%>" value="<%=can_reason%>">
				<%if(record[16].trim().equals("RED") || record[8].trim().equals("DC") || record[8].trim().equals("RD") || record[8].trim().equals("RJ") || (!can_reason.equals(""))){%><a class="gridLink"  href="javascript:viewCancelOrderFormatLineCmts('Cancel Reason','<%=i%>','<%=record[9]%>','<%=orderId%>')"><%}%>
				<%=record[5]%>
			</td>	<td width='8%' class="<%=rowColor%>"><font size=1><a class="gridLink" href="javascript:viewOrderFormatLineDtl('<%=orderId%>','<%=record[9]%>')"><%=record[11]%></a></td>
			<td width='5%' class="<%=rowColor%>"><font size=1>
				<%--<input type="hidden" name="Cmts<%=i%>" id="Cmts<%=i%>" value="<%=record[12]%>">
				<input type="hidden" name="Preps<%=i%>" id="Preps<%=i%>" value="<%=prepsdata%>">
				<input type="hidden" name="Depts<%=i%>" id="Depts<%=i%>" value="<%=deptData%>">
				<input type="hidden" name="Instruction<%=i%>" id="Instruction<%=i%>" value="<%=instruction%>">--%><%--IN64543--%>
				<input type="hidden" name="Appt<%=i%>" id="Appt<%=i%>" value="<%=appt_ref_num%>">
				<input type="hidden" name="Appt_date<%=i%>" id="Appt_date<%=i%>" value="<%=com.ehis.util.DateUtils.convertDate(appt_date_time,"DMYHM","en",localeName)%>">

				<input type="hidden" name="appt_locn<%=i%>" id="appt_locn<%=i%>" value="<%=record[30]%>">
				<input type="hidden" name="appt_resched_yn<%=i%>" id="appt_resched_yn<%=i%>" value="<%=record[31]%>">
				<input type="hidden" name="appt_resched_reason<%=i%>" id="appt_resched_reason<%=i%>" value="<%=record[32]%>">
				<input type="hidden" name="no_of_reschedules<%=i%>" id="no_of_reschedules<%=i%>" value="<%=record[33]%>">

				<input type="hidden" name="cont_order_indicator<%=i%>" id="cont_order_indicator<%=i%>" value="<%=cont_order_ind%>">
				<input type="hidden" name="parent_order_id<%=i%>" id="parent_order_id<%=i%>" value="<%=parent_order_id%>">
				<input type="hidden" name="parent_order_line_num<%=i%>" id="parent_order_line_num<%=i%>" value="<%=parent_order_line_num%>">

				<% if(record[12]!=null && !record[12].equals("")) {%><a class="gridLink"  href="javascript:viewCancelOrderFormatLineCmts('Comments','<%=i%>','<%=record[9]%>','<%=orderId%>')"><fmt:message key="Common.Comments.label" bundle="${common_labels}"/></a>   <%}else { %><fmt:message key="Common.Comments.label" bundle="${common_labels}"/> <% }%>
				<br><% if(prepsdata!=null && !(prepsdata.equals(""))){%> <a class="gridLink"  href="javascript:viewCancelPrepsData(escape('<%=i%>'))"><fmt:message key="eOR.Preps.label" bundle="${or_labels}"/></a> <%}else { %><fmt:message key="eOR.Preps.label" bundle="${or_labels}"/> <% }%>
				<br><% if(deptData!=null && !(deptData.equals(""))){%> <a class="gridLink"  href="javascript:viewCancelDeptData(escape('<%=i%>'))"><fmt:message key="eOR.DeptInstrn.label" bundle="${or_labels}"/></a> <%}else { %><fmt:message key="eOR.DeptInstrn.label" bundle="${or_labels}"/> <% }%>
				<br><% if(instruction!=null && !instruction.equals("")) {%> <a class="gridLink"  href="javascript:viewPatientData('<%=orderId%>','<%=record[9]%>','<%=i%>')"><fmt:message key="eOR.PatInstrn.label" bundle="${or_labels}"/></a> <%}else{%><fmt:message key="eOR.PatInstrn.label" bundle="${or_labels}"/> <% }%> 
					<!--<a href="javascript:viewPatientData('<%=record[18]%>','<%=orderId%>','<%=patient_id%>','<%=sex%>')">Pat.Instrn</a>  -->
				<% if((schd_yn.equals("Y"))){
					if(!order_category.equalsIgnoreCase("PH")) {
				%><br><a class="gridLink"  href="javascript:viewScheduleData('<%=orderId%>','<%=record[9]%>','<%=interval_type%>','<%=ord_facility_id%>','<%=freq_code%>','<%=order_category%>','cancel_order_dtl','<%=pr_duration%>','<%=pr_duration_type%>','<%=quantity%>','<%=appl_sliding_scale_yn%>','<%=start_time_day_param%>')"><fmt:message key="eOR.Schd.label" bundle="${or_labels}"/></a>
				<%} else if (order_category.equalsIgnoreCase("PH") && (!iv_prep_yn.equals("")) && parent_order_line_num.equalsIgnoreCase("1")) {%>
				<br><a class="gridLink"  href="javascript:viewScheduleData('<%=orderId%>','<%=record[9]%>','<%=interval_type%>','<%=ord_facility_id%>','<%=freq_code%>','<%=order_category%>','cancel_order_dtl','<%=pr_duration%>','<%=pr_duration_type%>','<%=quantity%>','<%=appl_sliding_scale_yn%>','<%=start_time_day_param%>')"><fmt:message key="eOR.Schd.label" bundle="${or_labels}"/></a>
				<%} else if (order_category.equalsIgnoreCase("PH") && (iv_prep_yn.equals(""))) {%>
				<br><a class="gridLink"  href="javascript:viewScheduleData('<%=orderId%>','<%=record[9]%>','<%=interval_type%>','<%=ord_facility_id%>','<%=freq_code%>','<%=order_category%>','cancel_order_dtl','<%=pr_duration%>','<%=pr_duration_type%>','<%=quantity%>','<%=appl_sliding_scale_yn%>','<%=start_time_day_param%>')"><fmt:message key="eOR.Schd.label" bundle="${or_labels}"/></a>
				<%}
				}%>
				<%--<%else {%>
				<br><fmt:message key="eOR.Schd.label" bundle="${or_labels}"/><% } %>--%>
				<% if((!appt_ref_num.equals("")) && (!appt_date_time.equals(""))){//(appt_reqd_yn.equals("Y")) && %><br>
					<% if(order_category.equals("RD") && rd_install.equals("Y") ||  order_category.equals("OT") && ot_install.equals("Y")) {%>	
						<a class="gridLink" href="javascript:viewCancelApptData(escape('<%=i%>'))"><fmt:message key="eOR.ApptDetails.label" bundle="${or_labels}"/></a>
					<% } else { %>
						<a class="gridLink" href="javascript:viewOACancelApptData(escape('<%=i%>'))"><fmt:message key="eOR.ApptDetails.label" bundle="${or_labels}"/></a>
					<% } %>
				<%} else if (!(cont_order_indicator.equalsIgnoreCase("DO") || cont_order_indicator.equalsIgnoreCase("CO"))){
					String apptYN = bean.getAppointmentYN(parent_order_id,parent_order_line_num);
					if (apptYN != null && apptYN.equalsIgnoreCase("Y")) {%>
					<br>
						<% if(order_category.equals("RD") && rd_install.equals("Y") ||  order_category.equals("OT") && ot_install.equals("Y")) {%>	
							<a class="gridLink" href="javascript:viewCancelApptData(escape('<%=i%>'))"><fmt:message key="eOR.ApptDetails.label" bundle="${or_labels}"/></a>
						<% } else { %>
							<a class="gridLink"  href="javascript:viewOACancelApptData(escape('<%=i%>'))"><fmt:message key="eOR.ApptDetails.label" bundle="${or_labels}"/></a>
					<% } %>
					<%}
				}%>
</td>
		<% if((record[15].trim()).equalsIgnoreCase("Y")){%>
			<td width='8%' align=center class="<%=rowColor%>">
				<font size=1><input type=checkbox name='chk<%=i%>' id='chk<%=i%>' onClick='clickLine(this,<%=i%>)'>
				<BR><a class='gridLink' id='lins<%=i%>'><fmt:message key="eOR.R.label" bundle="${or_labels}"/></a>
				<div id='display_lins<%=i%>' style="display:none"><fmt:message key="eOR.R.label" bundle="${or_labels}"/></div>
			</td>
		<%} else {%>
			<td width='8%' align=center class="<%=rowColor%>"></td>
		<%}%>
		</tr>
		<input type="hidden" name="cancel_desc<%=i%>" id="cancel_desc<%=i%>" value="">
		<input type="hidden" name="cancel_reason<%=i%>" id="cancel_reason<%=i%>" value="">
		<input type="hidden" name="line_status<%=i%>" id="line_status<%=i%>" value="<%=record[8]%>">
		<input type="hidden" name="line_num<%=i%>" id="line_num<%=i%>" value="<%=record[9]%>">
		<input type="hidden" name="catalog_code<%=i%>" id="catalog_code<%=i%>" value="<%=record[13]%>">
		<input type="hidden" name="order_category<%=i%>" id="order_category<%=i%>" value="<%=record[14]%>">
		<INPUT TYPE="hidden" name="instrn_type<%=i%>" id="instrn_type<%=i%>" value="<%=record[47]%>"><!--IN64543-->
		<INPUT TYPE="hidden" name="fpp_yn<%=i%>" id="fpp_yn<%=i%>" value="<%=record[48]%>"><!--IN072752-->
		<INPUT TYPE="hidden" name="fpp_category<%=i%>" id="fpp_category<%=i%>" value="<%=record[49]%>"><!--IN072752-->
		
		<%}%>

<input type="hidden" name="cont_order_ind" id="cont_order_ind" value="<%=cont_order_ind%>">
<input type="hidden" name="line_stat_to_updt" id="line_stat_to_updt" value="">
<input type="hidden" name="which_place" id="which_place" value="">
<input type="hidden" name="cancel_type" id="cancel_type" value="">
<input type="hidden" name="cancel_desc" id="cancel_desc" value="">
<input type="hidden" name="ord_id" id="ord_id" value="<%=orderId%>">
<input type="hidden" name="ord_category" id="ord_category" value="<%=order_category%>">
<input type="hidden" name="ot_install" id="ot_install" value="<%=ot_install%>">
<input type="hidden" name="rd_install" id="rd_install" value="<%=rd_install%>">
<input type="hidden" name="ord_typ_code" id="ord_typ_code" value="<%=ord_typ_code%>">
<input type="hidden" name="pract_id" id="pract_id" value="<%=(String)session.getValue("ca_practitioner_id")%>">
<input type="hidden" name='total_recs' id='total_recs' value='<%=allValues.size()%>'>
<input type="hidden" name='mode' id='mode' value='1'>
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id1%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name1%>">
<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">

<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
<input type="hidden" name="cancel_all_desc" id="cancel_all_desc" value="">
<input type="hidden" name="cancel_all_description" id="cancel_all_description" value="">
<!--  Added By Sridhar Reddy 160410 IN019204 -->
<input type="hidden" name="iv_prep_yn" id="iv_prep_yn" value="<%=iv_prep_yn%>">
<!-- END -->

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
<input type=hidden name='bean_id1' id='bean_id1' value='<%=bean_id%>'>
<input type=hidden name='bean_name1' id='bean_name1' value='<%=bean_name%>'>
<input type=hidden name='function_from' id='function_from' value='Cancel'>
<input type=hidden name='resp_id' id='resp_id' value='<%= (String)session.getValue("responsibility_id")%>'>
<input type="hidden" name="p_called_from_ca" id="p_called_from_ca" value='<%=p_called_from_ca%>'><!--IN071315->

</form>
<%--<script>
	if(parent.CancelOrderHeader.document.getElementById("titleTab")!=null) {
		alignWidth();
	}
</script>--%>
</body>
</html>

<%
		putObjectInBean(bean_id,bean,request);
		putObjectInBean(bean_id2,bean2,request);//IN64543
%>

