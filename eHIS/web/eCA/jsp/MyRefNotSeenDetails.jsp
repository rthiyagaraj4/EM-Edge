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
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name        		Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
22/01/2018  	IN062606            Sharanraj         01/02/2018              Ramesh G        ML-MMOH-CRF-0726
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,eCA.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<head>
	<title><fmt:message key="eCA.ReviewNotes.label" bundle="${ca_labels}"/></title>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
				|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
				.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language='javascript' src='../../eCA/js/PendDiscSummNotes.js'></script>
	<script src='../js/ReferralPatListResult.js' language='javascript'></script>
	<script src='../js/MyRefToPerform.js' language='javascript'></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt1 = null;
	ResultSet rs1 = null;
	String orderBy="";
	String reOrder="";
	String anchorID="";
	try {
		con = ConnectionManager.getConnection(request);
		java.util.Properties p = (java.util.Properties) session
				.getValue("jdbc");
		String locale = (String) p.getProperty("LOCALE");
		String clinicianId = (String) session
				.getValue("ca_practitioner_id");
		String facilityId = (String) session.getValue("facility_id");
		String from_date=request.getParameter("from_date") == null ? ""
				: request.getParameter("from_date");
		String to_date=request.getParameter("to_date") == null ? ""
				: request.getParameter("to_date");
		String patientid = request.getParameter("patientid") == null ? ""
 				: request.getParameter("patientid");

		boolean flag=false;
		String search =request.getParameter("search")==null?"":request.getParameter("search");
		
		 orderBy			=	request.getParameter("orderBy") == null ? "" : request.getParameter("orderBy");
		 reOrder			=	request.getParameter("reOrder") == null ? "" : request.getParameter("reOrder");
		 anchorID			=	request.getParameter("anchorID") == null ? "" : request.getParameter("anchorID");

		
		String visitStyle = "";
		if(reOrder.equals("1"))
		{
			visitStyle = "color:pink" ;
		}
		else
		{
			visitStyle = "color:yellow" ;
		}
		
		
		String bean_id1 = "Ca_MyRefToPerformBean" ;
		String bean_name1 = "eCA.MyRefToPerformBean";
		MyRefToPerformBean bean1=(MyRefToPerformBean)getBeanObject( bean_id1, bean_name1, request ) ;
		
		ArrayList details=bean1.getMyrefDetails(clinicianId,locale,facilityId,search,from_date,to_date,patientid,orderBy,reOrder,anchorID);
		String classValue = "";
%>
<form name="MyRefNotSeenDtl_form" id="MyRefNotSeenDtl_form" method="post" target=messageFrame>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='content'>
<table  id='PatResultTbl' border="1" width="100%" cellspacing='0' cellpadding='3' align='center'>
				<tr>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
				<th nowrap><a id='a01'   href="javascript:callForOrderByLoc1('PC');" onclick='changeColor1(this);' style='color:white'>
							<fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></a></th>
				<th nowrap><a id='a02'   href="javascript:callForOrderByLoc1('LOC');" onclick='changeColor1(this);' style='color:white'>
							<fmt:message key="Common.Location.label" bundle="${common_labels}"/></a></th>
				<th nowrap><a id='a03'   href="javascript:callForOrderByLoc1('PN');" onclick='changeColor1(this);' style='color:white'>
							<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></a></th>
				<th nowrap><a id='a04'   href="javascript:callForOrderByLoc1('RID');" onclick='changeColor1(this);' style='color:white'>
							<fmt:message key="Common.referralid.label" bundle="${common_labels}"/></a></th>
				<th nowrap><a id='a05'   href="javascript:callForOrderByLoc1('AGE');" onclick='changeColor1(this);' style='color:white'>
							<fmt:message key="Common.age.label" bundle="${common_labels}"/></a></th>
				<th nowrap><a id='a06'   href="javascript:callForOrderByLoc1('SEX');" onclick='changeColor1(this);' style='color:white'>
							<fmt:message key="Common.Sex.label" bundle="${common_labels}"/></a></th>
				<th nowrap><a id='a07'   href="javascript:callForOrderByLoc1('PID');" onclick='changeColor1(this);' style='color:white'>
							<fmt:message key="Common.patientId.label" bundle="${common_labels}"/></a></th>
				<th nowrap><a id='a08'  href="javascript:callForOrderByLoc1('RS');" onclick='changeColor1(this);' style='color:white'> 				<fmt:message key="eCA.ReferralStatus.label" bundle="${ca_labels}"/></a></th>
				<th nowrap><a id='a09'   href="javascript:callForOrderByLoc1('AD');" onclick='changeColor1(this);' style='color:pink'>
							<fmt:message key="Common.VisitAdmDate.label" bundle="${common_labels}"/></a></th>
				<th nowrap><a id='a10' href="javascript:callForOrderByLoc1('DD');" onclick='changeColor1(this);' style='color:white'> 				<fmt:message key="eCA.VisitAdmEndDate.label" bundle="${ca_labels}"/></a></th>
				<th nowrap><a id='a11'   href="javascript:callForOrderByLoc1('RN');" onclick='changeColor1(this);' style='color:white'> 				<fmt:message key="Common.roomno.label" bundle="${common_labels}"/></a></th>
				<th nowrap><a id='a12'   href="javascript:callForOrderByLoc1('BN');" onclick='changeColor1(this);' style='color:white'> 				<fmt:message key="Common.bedno.label" bundle="${common_labels}"/></a></th>
				<th nowrap><a id='a13'   href="javascript:callForOrderByLoc1('AP');" onclick='changeColor1(this);' style='color:white'> 				<fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></a></th>
				</tr>
			<%
				String episode_type_desc = "";
				String status = "";
				String enctr_id="";
				int j = 0;
				int k = 0;
	for(int i=0;i<details.size();i=i+15)
				{
					flag=true;
					//episode_type_desc = rs1.getString("PATIENT_CLASS") == null ? "&nbsp": rs1.getString("PATIENT_CLASS");
					episode_type_desc=details.get(i).toString();
					//status = rs1.getString("STATUS") == null ? "" : rs1.getString("STATUS");
					status=details.get(i+1).toString();
					//enctr_id = rs1.getString("EPISODE_ID")== null ? "" : rs1.getString("EPISODE_ID");
					enctr_id=details.get(i+2).toString();
					if (episode_type_desc.equals("OP"))
						episode_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
					else if (episode_type_desc.equals("IP"))
						episode_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
					else if (episode_type_desc.equals("EM"))
						episode_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
					else if (episode_type_desc.equals("DC"))
						episode_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label", "common_labels");
					if (status.equals("P"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "eCA.PendingReferrals.label","ca_labels");
					else if (status.equals("U"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Unassigned.label","common_labels");
					else if (status.equals("O"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.open.label","common_labels");
			%>
			<tr>
				<%
					if (!enctr_id.equals("")) {
				%>
				<td class='gridData'><a href=javascript:showEncounterDeatils1('<%=j%>','<%=enctr_id%>','<%=details.get(i+3)%>') class='gridLink'>&nbsp;+&nbsp;</a></td>
				<%
					} else {
				%>
				<td class='gridData' nowrap><font size=1>&nbsp</font></td>
				<%
					}
				%>
				<td class='gridData' nowrap><font size=1>&nbsp</font></td>
				<td class='gridData' nowrap><font size=1>&nbsp</font></td>
				<td class='gridData' nowrap><font size=1><%=episode_type_desc%></font></td>
				<td class='gridData' nowrap><font size=1><%=details.get(i+4)%></font></td>
				<td class='gridData' nowrap><font size=1><%=details.get(i+5)%></font></td>
				<td class='gridData' nowrap><font size=1><%=details.get(i+6)%></font></td>
				<td class='gridData' nowrap><font size=1><%=details.get(i+7)%></font></td>
				<td class='gridData' nowrap><font size=1><%=details.get(i+8)%></font></td>
				<td class='gridData' nowrap><font size=1><%=details.get(i+9)%></font></td>
				<td class='gridData' nowrap><font size=1><%=status%></td>
				<td class='gridData' nowrap><font size=1><%=details.get(i+10)%></font></td>
				<td class='gridData' nowrap><font size=1>&nbsp</td>
				<td class='gridData' nowrap><font size=1><%=details.get(i+11)%></font></td>
				<td class='gridData' nowrap><font size=1><%=details.get(i+12)%></font></td>
				<td class='gridData' nowrap><font size=1><%=details.get(i+13)%></font></td>
			</tr>
			<input type="hidden" name="patient_id<%=k%>" id="patient_id<%=k%>" value='<%=details.get(i+14)%>'>
			<%
			j++;
			k++;
				}
 				if(!flag)
 				{
 					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
 					out.println("<script>top.content.workAreaFrame.MyRefNotSeenDetailsFrame.location.href = '../../eCommon/html/blank.html';</script>");
 				}
			%>
		</table>
</body>
<%-- <input type="hidden" name="noofrec" id="noofrec" value="<%=i%>"> --%>

<input type="hidden" name="facility_id" id="facility_id" value="<%=facilityId%>">
<input type="hidden" name="tempAccession_Num" id="tempAccession_Num" value="">
</form>
<%
	if (rs != null)
		rs.close();
	if (pstmt != null)
		pstmt.close();
	if (rs1 != null)
			rs1.close();
		if (pstmt1 != null)
			pstmt1.close();

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if (con != null)
			ConnectionManager.returnConnection(con, request);
	}
if(!anchorID.equals(""))
{
%>
<script>
if('<%=anchorID%>'!='')
{
	if('<%=reOrder%>'=='1')
		document.getElementById("PatResultTbl").all.<%=anchorID%>.style.color='pink';
	else if('<%=reOrder%>'=='2')
		document.getElementById("PatResultTbl").all.<%=anchorID%>.style.color='yellow';
}	
</script>
<%
}
%></html>

