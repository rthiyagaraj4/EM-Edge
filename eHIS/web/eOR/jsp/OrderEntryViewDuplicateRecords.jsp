<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="beanQueryObj" scope="page" class="eOR.OrderEntryQueryBean"/>
<%-- Mandatory declarations end --%>
<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	</link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntry.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntrySearch.js"></script>
	<script language="Javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id 					= request.getParameter("bean_id");
	String bean_name 				= request.getParameter("bean_name");
	String called_from 				= request.getParameter("called_from")==null?"":request.getParameter("called_from");
	String cat_code 				= request.getParameter("cat_code")==null?"":request.getParameter("cat_code");
	/* Initialize Function specific start */
	//OrderEntryBean bean 			= (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) 
;
    beanQueryObj.setLanguageId(localeName);
	OrderEntryBean bean				= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	Properties properties			= (Properties) session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean 
        	
	/* Initialize Function specific end */
	String classValue				= "";
	StringBuffer sbDuplicate		= new StringBuffer();
	HashMap hashValues				= bean.getAllValues();
	ArrayList DuplicateCheckDetails	= null;
 	String appt_module_id			= "", old_appt_module_id = "";
	int i							= 0;
	int dupl_count_alert			= 0;
	int dupl_count_error			= 0;
	int total_dupl_count_records	= 0;
	int conflict_exam_count_records = 0;
	int appt_count_records			= 0;
	int count						= 0;
	int exists=0;
	if(hashValues!=null)
	{
		dupl_count_alert 			= Integer.parseInt(bean.checkForNull((String)hashValues.get("dupl_count_alert"),"0"));
		dupl_count_error 			= Integer.parseInt(bean.checkForNull((String)hashValues.get("dupl_count_error"),"0"));
		total_dupl_count_records 	= Integer.parseInt(bean.checkForNull((String)hashValues.get("total_dupl_count_records"),"0"));
		conflict_exam_count_records = Integer.parseInt(bean.checkForNull((String)hashValues.get("conflict_exam_count_records"),"0"));
		appt_count_records			= Integer.parseInt(bean.checkForNull((String)hashValues.get("appt_count_records"),"0"));
	}
	if(conflict_exam_count_records > 0) 
	{ 
	%>
		<title><fmt:message key="eOR.ExamConflicts.label" bundle="${or_labels}"/></title>
	<%
	} 
	else if(appt_count_records >0) 
	{ 
	%>
		<title><fmt:message key="Common.AppointmentDetails.label" bundle="${common_labels}"/></title>
	<%
	} 
	else
	{ 
	%>
		<title><fmt:message key="eOR.DuplicateCheck.label" bundle="${or_labels}"/></title>
	<%
	} 
	%>
</head>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<form name="placeOrderForm" id="placeOrderForm">	
<%
	if(total_dupl_count_records > 0)
		count = total_dupl_count_records;
	else if(appt_count_records >0)	
		count = appt_count_records;
	else
		count = conflict_exam_count_records;
%>
	<table width="100%" border="1" cellspacing="0" cellpadding="0" class="grid">
	<tr>
<% 	if(total_dupl_count_records > 0) { %>
		<td class="columnheader" width="30%"><fmt:message key="eOR.ConflictswithItem.label" bundle="${or_labels}"/></td>
		<td class="columnheader" width="15%"><fmt:message key="Common.startdatetime.label" bundle="${common_labels}"/></td>
		<td class="columnheader" width="20%"><fmt:message key="Common.OrderedBy.label" bundle="${common_labels}"/></td>
		<td class="columnheader" width="20%"><fmt:message key="Common.enddatetime.label" bundle="${common_labels}"/></td>
		<td class="columnheader" width="15%"><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>



		<!--<td class="columnheader" width="20%">Ahead/Behind Prd.</td>-->
<%  } else if(appt_count_records > 0) { %>
		<td class="columnheader" width="36%"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
		<td class="columnheader" width="12%"><fmt:message key="eOA.ApptRefNo.label" bundle="${oa_labels}"/></td>
		<td class="columnheader" width="10%"><fmt:message key="Common.apptdate.label" bundle="${common_labels}"/></td>
		<td class="columnheader" width="6%"><fmt:message key="Common.StartTime.label" bundle="${common_labels}"/></td>
		<td class="columnheader" width="6%"><fmt:message key="Common.EndTime.label" bundle="${common_labels}"/></td>
		<td class="columnheader" width="30%"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></td>
<%	} else { %>		
		<td class="columnheader" width="20%"><fmt:message key="eOR.ConflictExam.label" bundle="${or_labels}"/></td>
		<td class="columnheader" width="35%"><fmt:message key="eOR.ConflictExamDescription.label" bundle="${or_labels}"/></td>
		<td class="columnheader" width="20%"><fmt:message key="eOR.ConflictExamDateTime.label" bundle="${or_labels}"/></td>
		<td class="columnheader" width="25%"><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
<%	} 

	//HashMap hash = bean.getAllValues();
	//out.println("size"+hashValues.size());
	//out.println("hashValues"+hashValues);
	int start = 0;
	int end = count;
	if(total_dupl_count_records > 0)
	{
		start = start +1;
		end = end +1;
	}
	if(called_from.equalsIgnoreCase("DUPLICATE")&&(!(cat_code.equals(""))))
	{
		if(hashValues!=null && hashValues.size() > 0)
		{
			for(i=start; i<end; i++)
			{
				classValue="gridData";
				if(!(bean.checkForNull((String)hashValues.get("vb_status"+i),"N").equals("N")) || !(bean.checkForNull((String)hashValues.get("va_status"+i),"N").equals("N")) && total_dupl_count_records > 0)
				{
					if(bean.checkForNull((String)hashValues.get("dupl_catalog_code"+i),"").equalsIgnoreCase(cat_code))
					{
						exists++;
						DuplicateCheckDetails = beanQueryObj.getDuplicateBehindCheckDetails(properties, bean.checkForNull((String)hashValues.get("patient_id"+i),""), bean.checkForNull((String)hashValues.get("dupl_catalog_code"+i),""), bean.checkForNull((String)hashValues.get("test_date_time"+i),""), bean.checkForNull((String)hashValues.get("activity_type"+i),""), bean.checkForNull((String)hashValues.get("chk_for_dupl_behind_unit"+i),""), bean.checkForNull((String)hashValues.get("chk_for_dupl_behind_period"+i),""), bean.checkForNull((String)hashValues.get("vb_status"+i),"N"), bean.checkForNull((String)hashValues.get("chk_for_dupl_status"+i),"N"),bean.checkForNull((String)hashValues.get("check_for_dupl_level"+i),"O")); 
					// Till Here --> For Behind 
					// Duplicate check Records for Ahead
					sbDuplicate	= buildDuplicateCheck(beanQueryObj, DuplicateCheckDetails,"BEHIND",localeName);
					if(sbDuplicate!=null){
						out.println(sbDuplicate.toString());
					}
					DuplicateCheckDetails = beanQueryObj.getDuplicateAheadCheckDetails(properties, bean.checkForNull((String)hashValues.get("patient_id"+i),""), bean.checkForNull((String)hashValues.get("dupl_catalog_code"+i),""), bean.checkForNull((String)hashValues.get("test_date_time"+i),""), bean.checkForNull((String)hashValues.get("activity_type"+i),""), bean.checkForNull((String)hashValues.get("chk_for_dupl_ahead_unit"+i),""), bean.checkForNull((String)hashValues.get("chk_for_dupl_ahead_period"+i),""), bean.checkForNull((String)hashValues.get("va_status"+i),"N"), bean.checkForNull((String)hashValues.get("chk_for_dupl_status"+i),"N"),bean.checkForNull((String)hashValues.get("check_for_dupl_level"+i),"O")); 
					// Till Here -- For Ahead 
					sbDuplicate	= buildDuplicateCheck(beanQueryObj, DuplicateCheckDetails,"AHEAD",localeName);
					if(sbDuplicate!=null){
						out.println(sbDuplicate.toString());
					}
					}
				}
			}
		}
	}
	else if(exists==0)
	{
		if(hashValues!=null && hashValues.size() > 0)
		{
			for(i=start; i<end; i++)
			{
				classValue="gridData";
				if(!(bean.checkForNull((String)hashValues.get("vb_status"+i),"N").equals("N")) || !(bean.checkForNull((String)hashValues.get("va_status"+i),"N").equals("N")) && total_dupl_count_records > 0)
				{
					// Fire a query and get the Details to display the whole records, instead of one displayed now
					// Duplicate check Records for Behind
						DuplicateCheckDetails = beanQueryObj.getDuplicateBehindCheckDetails(properties, bean.checkForNull((String)hashValues.get("patient_id"+i),""), bean.checkForNull((String)hashValues.get("dupl_catalog_code"+i),""), bean.checkForNull((String)hashValues.get("test_date_time"+i),""), bean.checkForNull((String)hashValues.get("activity_type"+i),""), bean.checkForNull((String)hashValues.get("chk_for_dupl_behind_unit"+i),""), bean.checkForNull((String)hashValues.get("chk_for_dupl_behind_period"+i),""), bean.checkForNull((String)hashValues.get("vb_status"+i),"N"), bean.checkForNull((String)hashValues.get("chk_for_dupl_status"+i),"N"),bean.checkForNull((String)hashValues.get("check_for_dupl_level"+i),"O")); 
					// Till Here --> For Behind 
					// Duplicate check Records for Ahead
					sbDuplicate	= buildDuplicateCheck(beanQueryObj, DuplicateCheckDetails,"BEHIND",localeName);
					if(sbDuplicate!=null){
						out.println(sbDuplicate.toString());
					}
					DuplicateCheckDetails = beanQueryObj.getDuplicateAheadCheckDetails(properties, bean.checkForNull((String)hashValues.get("patient_id"+i),""), bean.checkForNull((String)hashValues.get("dupl_catalog_code"+i),""), bean.checkForNull((String)hashValues.get("test_date_time"+i),""), bean.checkForNull((String)hashValues.get("activity_type"+i),""), bean.checkForNull((String)hashValues.get("chk_for_dupl_ahead_unit"+i),""), bean.checkForNull((String)hashValues.get("chk_for_dupl_ahead_period"+i),""), bean.checkForNull((String)hashValues.get("va_status"+i),"N"), bean.checkForNull((String)hashValues.get("chk_for_dupl_status"+i),"N"),bean.checkForNull((String)hashValues.get("check_for_dupl_level"+i),"O")); 
					// Till Here -- For Ahead 
					sbDuplicate	= buildDuplicateCheck(beanQueryObj, DuplicateCheckDetails,"AHEAD",localeName);
					if(sbDuplicate!=null){
						out.println(sbDuplicate.toString());
					}
	%>

	<%			} else if(conflict_exam_count_records > 0)  // For Exam Conflicts 
				{
	%>
				<tr>
					<td class="<%=classValue%>" nowrap><%=bean.checkForNull((String)hashValues.get("conflict_exam"+i),"")%> </td>
					<td class="<%=classValue%>" nowrap><%=bean.checkForNull((String)hashValues.get("conflict_exam_desc"+i),"")%> </td>
					<td class="<%=classValue%>" nowrap><%=bean.checkForNull((String)hashValues.get("conflict_exam_date"+i),"")%> </td>
					<td class="<%=classValue%>" nowrap><%=bean.checkForNull((String)hashValues.get("conflict_reason"+i),"")%> </td>
				</tr>
	<%		
				}
				if(appt_count_records > 0)
				{	// For Appointments Radialogy
					appt_module_id = bean.checkForNull((String)hashValues.get("appt_module_id"+i),"");
					if(appt_module_id.equals("OA") && !appt_module_id.equals(old_appt_module_id) )
					{
	%>				   
						<tr><td class="PATQRED"  "center" colspan="6"><fmt:message key="Common.OutpatientAppointments.label" bundle="${common_labels}"/></td></tr>
	<%		  	    }if(appt_module_id.equals("RD") && !appt_module_id.equals(old_appt_module_id) )
					{
	%>				   
						<tr><td class="PATQRED"  "center" colspan="6"><fmt:message key="eOR.RadiologyAppointments.label" bundle="${or_labels}"/></td></tr>	   
	<%				}    %>
				 
					<tr>
						<td class="<%=classValue%>" nowrap><%=bean.checkForNull((String)hashValues.get("appt_facility_name"+i),"")%> </td>
						<td class="<%=classValue%>" align="right"><%=bean.checkForNull((String)hashValues.get("appt_ref_no"+i),"")%> </td>
						<td class="<%=classValue%>" ><%=bean.checkForNull((String)hashValues.get("appt_date"+i),"")%> </td>
						<td class="<%=classValue%>" ><%=bean.checkForNull((String)hashValues.get("appt_start_time"+i),"")%> </td>
						<td class="<%=classValue%>" ><%=bean.checkForNull((String)hashValues.get("appt_end_time"+i),"")%> </td>
						<td class="<%=classValue%>" nowrap><%=bean.checkForNull((String)hashValues.get("clinic_desc"+i),"")%> </td>
					</tr>
	<%			
					old_appt_module_id = appt_module_id;
				}
				
			} // End of For
		} // End of if
	}

%>
	</table>
	<table width="100%" border="0" cellspacing="0" cellpadding="3">
		<tr>
			<td class="white" align="center" width="100%">
<% 				if((dupl_count_error > 0)||(dupl_count_alert>0)) { // display the View, cancel buttons
%>					<input type="button" name="ok" id="ok" class="BUTTON" value ="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>" onClick="closeViewRecords()">
<%				}else{  %>
					<input type="button" name="proceed" id="proceed" class="BUTTON" value ="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Proceed.label","common_labels")%>" onClick="proceedInsertion()">
					<input type="button" name="cancel" id="cancel" class="BUTTON" value ="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>"   onClick="cancelDuplicateRecords()">
<%				}  %>
			</td>
		</tr>
</table>
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
</form>
</body>
</html>
<%!
	private java.lang.StringBuffer buildDuplicateCheck(eOR.OrderEntryQueryBean beanQueryObj, ArrayList DuplicateCheckDetails,String behind_ahead,String localeName ) throws Exception
	{
	 	String[] record					= null;	
		String classValue				= "";
		StringBuffer sbDuplicate		= new StringBuffer();

		for(int k=0; k<DuplicateCheckDetails.size(); k++)
		{
			classValue="gridData";
 			record = (String[])DuplicateCheckDetails.get(k);
			if(k==0) {
				if(beanQueryObj.checkForNull(behind_ahead,"").equals("") || beanQueryObj.checkForNull(behind_ahead,"").equals("BEHIND"))
				{
 			//if(!beanQueryObj.checkForNull((String)hashValues.get("vb_status"+i),"N").equals("N") )  
					sbDuplicate.append("<tr>");	
					sbDuplicate.append("	<td class='columnheader' colspan='5'>Behind Period</td>");
					sbDuplicate.append("</tr>");
 				} else {  
					sbDuplicate.append("<tr>");	
					sbDuplicate.append("	<td class='columnheader' colspan='5'>Ahead Period</td>");
					sbDuplicate.append("</tr>");
				} 
			} // End of K
 
					sbDuplicate.append("<tr>");	
					sbDuplicate.append("	<td class='"+classValue+"' nowrap><a class='gridLink' href='#' onClick=\"viewDuplicate('"+((String)record[1])+"')\">"+beanQueryObj.checkForNull((String)record[2],"&nbsp;")+"</a></td>");

					String startdate=beanQueryObj.checkForNull((String)record[0],"");
					startdate=com.ehis.util.DateUtils.convertDate(startdate,"DMYHM","en",localeName);
						
 					sbDuplicate.append("	<td class='"+classValue+"' nowrap>"+startdate+"</td>");
					sbDuplicate.append("	<td class='"+classValue+"' nowrap>"+beanQueryObj.checkForNull((String)record[3],"&nbsp;")+"</td>");

					String enddate=beanQueryObj.checkForNull((String)record[5],"");
					enddate=com.ehis.util.DateUtils.convertDate(enddate,"DMYHM","en",localeName);

					sbDuplicate.append("	<td class='"+classValue+"' nowrap>"+enddate+"</td>");
					sbDuplicate.append("	<td class='"+classValue+"' nowrap>"+beanQueryObj.checkForNull((String)record[4],"&nbsp;")+"</td>");
   					sbDuplicate.append(" </tr>");	
					record = null;
				}
		return sbDuplicate;
	} // End of Method
%>


<%
	// no need to set it back persistence
	//putObjectInBean(bean_id,bean,request);
	//if(hashValues!=null) {
		//hashValues.clear();			 hashValues		= null;			
	//}
 	if(DuplicateCheckDetails!=null) {
		DuplicateCheckDetails.clear(); DuplicateCheckDetails= null;
	}
	if(sbDuplicate!=null) {
		sbDuplicate.setLength(0);
 	}
%>

