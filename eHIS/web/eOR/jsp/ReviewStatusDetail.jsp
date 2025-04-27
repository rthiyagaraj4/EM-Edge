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
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date	Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------
?             100            ?           								created
03/04/2014	IN048368		Vijayakumar K								While Result reporting an order->Task list->Result reporting->
01/08/2018		IN64543			Dinesh T		01/08/2018	Ramesh G		ML-MMOH-CRF-0776																		Review line status->Click on ?Preps? and ?Dept.Intrn? hyper link getting 500 internal server error.
--------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.*,eCommon.XSSRequestWrapper " %>
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
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
 	<script language="JavaScript" src="../js/ReviewStatus.js"></script>
 	<!--<script language="JavaScript" src="../js/ViewOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
-->

	<script>
		function alignWidth() 
	    {

/*			var last=eval(document.getElementById("detailTab").rows.length)-1;
			if(document.getElementById("detailTab")!=null) {
					for(i=0;i <document.getElementById("detailTab").rows(last).cells.length;i++) {
						var wid=document.getElementById("detailTab").rows(last).cells(i).offsetWidth;
						var wid1= parent.ReviewStatusHeader.document.getElementById("titleTab").rows(0).cells(i).offsetWidth;
						//alert(wid);
						//if(eval(wid1) <eval(wid)){
							parent.ReviewStatusHeader.document.getElementById("titleTab").rows(0).cells(i).width=wid;
							//alert(parent.ReviewStatusHeader.document.getElementById("titleTab").rows(0).cells(i).offsetWidth);
						//} else {
						//	alert();
						//	document.getElementById("detailTab").rows(last).cells(i).width = wid1;
						//}
					}alert(parent.ReviewStatusHeader.document.getElementById("titleTab").rows(0).cells(0).offsetWidth);
					alert(document.getElementById("detailTab").rows(0).cells(0).offsetWidth);
				}*/

			var totalRows =  document.getElementById("detailTab").rows.length;
			if(totalRows>0)
			{
				var counter = totalRows-1;

				//		alert(' parent.ReviewStatusHeader.document.getElementById("titleTab").rows(1).cells.length;   ' + 					parent.ReviewStatusHeader.document.getElementById("titleTab").rows(0).cells.length);

				var temp = parent.ReviewStatusHeader.document.getElementById("titleTab").rows[0].cells.length;

				for(var i=0;i<temp;i++) 
				{
					parent.ReviewStatusHeader.document.getElementById("titleTab").rows[0].cells[i].width=document.getElementById("detailTab").rows[counter].cells[i].offsetWidth;
				}

			}
		}

	</script>

</head>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="alignHeading()">
<form name=review_status_dtl>
<%
	
	/* Mandatory checks start */
	String mode	   = "2";//request.getParameter( "mode" ) ;
	String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_ReviewStatus" ;
	String bean_name = "eOR.ReviewStatusBean";
	String task_type = request.getParameter("task_type");
	String orderId = request.getParameter("orderId");
	String patient_id = request.getParameter("patient_id");
 	String facility_id = (String)session.getValue("facility_id");
	String practitioner_type  	= (String) session.getValue("practitioner_type");//Added by Uma on 5/12/2010 for IN021330
	//	String sex = request.getParameter( "sex" ) ;
	ArrayList allValues = new ArrayList();
/* Mandatory checks end */

	/* Initialize Function specific start */
	//ReviewStatusBean bean = (ReviewStatusBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	ReviewStatusBean bean = (ReviewStatusBean)getBeanObject(  bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clear() ;
	bean.setMode( mode ) ;

	//ExistingOrder bean1 = (ExistingOrder)mh.getBeanObject( "Or_ExistingOrder", request,  "eOR.ExistingOrder" ) ;
	ExistingOrder bean1 = (ExistingOrder)getBeanObject(  "Or_ExistingOrder", "eOR.ExistingOrder", request ) ;
	bean1.setLanguageId(localeName);
	allValues = bean.viewOtherDetails(orderId,practitioner_type);
	ViewOrder beanViewOrder = (ViewOrder)getBeanObject(  "Or_ViewOrder", "eOR.ViewOrder", request ) ;//IN048368

	String rd_install	= "N";
	String ot_install	= "N";
	String slClassValue = "";
	String prepsdata = "";
	String order_category = "";

	String appt_locn  ="";
	String appt_resched_yn  ="N";
	String appt_resched_reason  ="";
	String no_of_reschedules  ="";
%>
<table cellpadding=3 cellspacing=0 border=1 width="100%" id='detailTab' align=center class="grid">
<%
	for(int i=0; i<allValues.size(); i++){

		String[] record = (String [])allValues.get(i);
		//record[11]=java.net.URLEncoder.encode(record[11],"UTF-8");
		if(record[14].equals("RD") || record[14].equals("OT"))
		{
		rd_install	= bean1.getRadiology(facility_id);
		ot_install	= bean1.getOTModule(facility_id);
		}

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

		/*if(i % 2 == 0){
			slClassValue = "QRYEVEN";
		}else{
			slClassValue = "QRYODD";
		}*/
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
		if(record[10] == null || record[10].equals("null")) record[10] = "";
		if(record[11] == null) record[11] = "";
		if(record[12] == null) record[12] = "";
		if(record[14] == null) record[14] = "";

		String appt_reqd_yn 			= record[18];
		String appt_date_time 			= record[19];
		String appt_ref_num 			= record[20];
		String cont_order_ind			= record[21];
		String parent_order_id			= orderId;
		String parent_order_line_num	= record[9];

		appt_locn						= record[24];
		appt_resched_yn					= record[24];
		appt_resched_reason				= record[24];
		no_of_reschedules				= record[24];

		if (appt_reqd_yn == null) appt_reqd_yn = "";
		if (appt_date_time == null) appt_date_time = "";
		if (appt_locn == null) appt_locn = "";
		if (appt_resched_yn == null) appt_resched_yn = "";
		if (appt_resched_reason == null) appt_resched_reason = "";
		if (no_of_reschedules == null) no_of_reschedules = "";
		if (appt_ref_num == null) appt_ref_num = "";
		if (cont_order_ind == null) cont_order_ind = "";
		if (parent_order_id == null) parent_order_id = "";
		if (parent_order_line_num == null) parent_order_line_num = "";

		//prepsdata = bean.getdata(orderId, record[9],"PAT_PREPS_TEXT");//IN64543
		prepsdata = CommonBean.checkForNull(bean.getdata(orderId, record[9],"PAT_PREPS_TEXT"),"");//IN64543
		beanViewOrder.setPrepsData(prepsdata,i);//IN048368
		//prepsdata = "Test data";
		order_category = record[17];
		String deptData  = "";
		//deptData = bean.getdata(orderId,record[9],"DEPT_INSTRNS");//IN64543
		deptData = CommonBean.checkForNull(bean.getdata(orderId,record[9],"DEPT_INSTRNS"),"");//IN64543
		beanViewOrder.setDeptData(deptData,i);//IN048368

		String instruction = "";
		//String no_of_days = (String)bean1.getPatientNoOfDays( patient_id, orderId) ;
		//if(no_of_days == null) no_of_days = ""; else	no_of_days = no_of_days.trim();

		//instruction = bean1.getPatientInstruction(record[13],no_of_days,sex) ;
		//instruction = bean.getdata(orderId,record[9],"PATIENT_INSTRNS");//IN64543
		instruction = CommonBean.checkForNull(bean.getdata(orderId,record[9],"PATIENT_INSTRNS"),"");//IN64543
		//if(instruction == null)	instruction = "";//IN64543

%><%--<Script>alert('appt_reqd_yn=<%=appt_reqd_yn%>,appt_ref_num=<%=appt_ref_num%>,appt_date_time=<%=appt_date_time%>')</Script>--%>
		<tr>
			<td width='15%' class="<%=slClassValue%>"><font size=1><%=record[0]%></font></td>
			<td width='11%' class="<%=slClassValue%>"><font size=1><%=record[1]%></font></td>
			<td width='10%' class="<%=slClassValue%>"><font size=1><%=record[10]%></font></td>
			<td width='10%'  class="<%=slClassValue%>"><font size=1><%=com.ehis.util.DateUtils.convertDate(record[2],"DMYHM","en",localeName)%></font></td>
			<td width='10%' class="<%=slClassValue%>"><font size=1><%=com.ehis.util.DateUtils.convertDate(record[3],"DMYHM","en",localeName)%></font></td>
			<td width='9%'  class="<%=slClassValue%>"><font size=1><%=(String)record[4]%></font></td>
			<td width='11%' class="<%=slClassValue%>"><font size=1><%=record[5]%></font></td>
			<td width='8%' class="<%=slClassValue%>"><font size=1><a class="gridLink" href="javascript:viewOrderFormatLineDtl('<%=orderId%>','<%=record[9]%>')"><%=record[11]%></a></td>
			<td width='8%' class="<%=slClassValue%>"><font size=1>
			<%--<input type="hidden" name="Cmts<%=i%>" id="Cmts<%=i%>" value="<%=record[12]%>">
			<input type="hidden" name="Preps<%=i%>" id="Preps<%=i%>" value="<%=prepsdata%>">
			<input type="hidden" name="Depts<%=i%>" id="Depts<%=i%>" value="<%=deptData%>">
			<input type="hidden" name="Instruction<%=i%>" id="Instruction<%=i%>" value="<%=instruction%>">--%>
			<input type="hidden" name="Appt<%=i%>" id="Appt<%=i%>" value="<%=appt_ref_num%>">
			<input type="hidden" name="Appt_date<%=i%>" id="Appt_date<%=i%>" value="<%=com.ehis.util.DateUtils.convertDate(appt_date_time,"DMYHM","en",localeName)%>">
			<input type="hidden" name="appt_locn<%=i%>" id="appt_locn<%=i%>" value="<%=appt_locn%>">
			<input type="hidden" name="appt_resched_yn<%=i%>" id="appt_resched_yn<%=i%>" value="<%=appt_resched_yn%>">
			<input type="hidden" name="appt_resched_reason<%=i%>" id="appt_resched_reason<%=i%>" value="<%=appt_resched_reason%>">
			<input type="hidden" name="no_of_reschedules<%=i%>" id="no_of_reschedules<%=i%>" value="<%=no_of_reschedules%>">
			<input type="hidden" name="cont_order_ind<%=i%>" id="cont_order_ind<%=i%>" value="<%=cont_order_ind%>">
			<input type="hidden" name="parent_order_id<%=i%>" id="parent_order_id<%=i%>" value="<%=parent_order_id%>">
			<input type="hidden" name="parent_order_line_num<%=i%>" id="parent_order_line_num<%=i%>" value="<%=parent_order_line_num%>">

			<% if(record[12]!=null && !record[12].equals("")) { %><a class="gridLink" href="javascript:viewOrderFormatLineCmts1('Comments','<%=i%>','<%=record[9]%>','<%=orderId%>')"><fmt:message key="Common.Comments.label" bundle="${common_labels}"/></a> <% } else { %><fmt:message key="Common.Comments.label" bundle="${common_labels}"/><%} %>
			<br><% if(!(prepsdata.equals(""))){%> <a class="gridLink" href="javascript:viewReviewPrepsData(escape('<%=i%>'))"><fmt:message key="eOR.Preps.label" bundle="${or_labels}"/></a> <%} else { %><fmt:message key="eOR.Preps.label" bundle="${or_labels}"/> <%}%>
			<br><% if(!(deptData.equals(""))){%> <a class="gridLink" href="javascript:viewReviewDeptData(escape('<%=i%>'))"><fmt:message key="eOR.DeptInstrn.label" bundle="${or_labels}"/></a> <%} else { %> <fmt:message key="eOR.DeptInstrn.label" bundle="${or_labels}"/> <% } %>
			<br><% if(!instruction.equals("")) { %><a class="gridLink" href="javascript:viewPatientData('<%=orderId%>','<%=record[9]%>','<%=i%>')"><fmt:message key="eOR.PatInstrn.label" bundle="${or_labels}"/></a> <%}else{%><fmt:message key="eOR.PatInstrn.label" bundle="${or_labels}"/> <% }%> 
				<!--<a href="javascript:viewPatientData('<%=record[17]%>','<%=orderId%>','<%=patient_id%>')">Pat.Instrn</a>-->	 
			<% if((appt_reqd_yn.equals("Y")) && (!appt_ref_num.equals("")) && (!appt_date_time.equals(""))){ %><br>
				<% if( (record[14].equals("RD") && rd_install.equals("Y") ) || (record[14].equals("OT") && ot_install.equals("Y") ))	{ %>
					<a class="gridLink" href="javascript:viewReviewApptData(escape('<%=i%>'))"><fmt:message key="eOR.ApptDetails.label" bundle="${or_labels}"/></a>
			<%	} else { %>
					<a class="gridLink" href="javascript:viewOAApptData(escape('<%=i%>'))"><fmt:message key="eOR.ApptDetails.label" bundle="${or_labels}"/></a>
			<%	}
				} else if (!(cont_order_ind.equalsIgnoreCase("DO") || cont_order_ind.equalsIgnoreCase("CO"))){
				String apptYN = bean.getAppointmentYN(parent_order_id,parent_order_line_num);
				if (apptYN != null && apptYN.equalsIgnoreCase("Y")) {%>
				<br>
				<% if( (record[14].equals("RD") && rd_install.equals("Y") ) || (record[14].equals("OT") && ot_install.equals("Y") ))	{ %>
					<a class="gridLink" href="javascript:viewReviewApptData(escape('<%=i%>'))"><fmt:message key="eOR.ApptDetails.label" bundle="${or_labels}"/></a>
				<%	} else { %>
					<a class="gridLink" href="javascript:viewOAApptData(escape('<%=i%>'))"><fmt:message key="eOR.ApptDetails.label" bundle="${or_labels}"/></a>
				<%	}
				 } 
				}%>
			</font></td>
			<%if(task_type.trim().equalsIgnoreCase("UpdateLine")){%>
			<td width='8%' class="<%=slClassValue%>"><font size=1>
				<a class="gridLink" href="#" onclick='javascript:viewLineStatusRemark(document.review_status_dtl.lineStatus<%=i%>,document.review_status_dtl.lineStatusRemark<%=i%>, <%=function_id%>)'><fmt:message key="Common.status.label" bundle="${common_labels}"/></a></font>
				<input type=hidden name='orderLineNum<%=i%>' id='orderLineNum<%=i%>' value='<%=record[9]%>'>
				<input type=hidden name='lineStatus<%=i%>' id='lineStatus<%=i%>' value='<%=record[8]%>'>
				<input type=hidden name='lineStatusRemark<%=i%>' id='lineStatusRemark<%=i%>' value=''>
			</font></td>
			<%}%>
		</tr>
		<input type="hidden" name="catalog_code<%=i%>" id="catalog_code<%=i%>" value="<%=record[13]%>">
		<input type="hidden" name="order_category<%=i%>" id="order_category<%=i%>" value="<%=order_category%>">
		<input type="hidden" name="instrn_type<%=i%>" id="instrn_type<%=i%>" value="<%=record[29]%>">				
<%	}%>
</table>
<input type="hidden" name="ord_category" id="ord_category" value="<%=order_category%>">
<input type=hidden name='task_type' id='task_type' value='<%=task_type%>'>
<input type=hidden name='order_id' id='order_id' value='<%=orderId%>'>
<input type=hidden name='total_recs' id='total_recs' value='<%=allValues.size()%>'>
<input type=hidden name='mode' id='mode' value='<%=mode%>'>	<!-- data required for bean -->
<input type=hidden name='function_id' id='function_id' value='<%=function_id%>'>	<!-- data required for bean -->
<input type=hidden name='bean_id' id='bean_id' value='<%=bean_id%>'>		<!-- data required for bean -->
<input type=hidden name='bean_name' id='bean_name' value='<%=bean_name%>'>		<!-- data required for bean -->
<input type=hidden name='patient_id' id='patient_id' value='<%=patient_id%>'>		<!-- data required for bean -->

<input type=hidden name='function_from' id='function_from' value='ReviewStatus'>
</form>
<script>
	if(parent.ReviewStatusHeader.document.getElementById("titleTab")!=null) {
		alignWidth();
	}
</script>
<%
 		putObjectInBean(bean_id,bean,request);
		putObjectInBean("Or_ExistingOrder",bean1,request);
%>
</body>
</html>

