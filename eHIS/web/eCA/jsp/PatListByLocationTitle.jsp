<!DOCTYPE html>
<%
/*
-----------------------------------------------------------------------------------------------
Date			Edit History   Name         Rev.Date  Rev.By    Description
-----------------------------------------------------------------------------------------------
?				100				?           					created
18/12/2012		IN030466		Karthi L					 New column "Research Study" introduced in search result screen. New Research icon Study 			  										    intorduced based on the research study details patient having (CRF-025)
22/01/2013		IN030532		Karthi L					 CA Patient List to have option to call a specific patient queue no
23/10/2013      				Nijitha S					 Changes Suggested By Sunil To rearrange bedNo and Room No Column
22/01/2014		IN044246		Chowminya 22/01/2014 Self	 Research Study rename to Patient Classification
-----------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------------------------------------------
	Date		Edit History	Name				Rev.Date   		Rev.By 		Description
-------------------------------------------------------------------------------------------------------------------------------
23/10/2017		IN064342		Krishna Gowtham		23/10/2017		Ramesh G	GHL-CRF-0468.1
15/04/2023		37866			Ramesh G		 								MMS-DM-CRF-0226
22-06-2023        22856      Srinivasa N T                      22-06-2023            Ramesh G    ML-MMOH-CRF-1778
-------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
        request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String locn_type = request.getParameter("locn_type");
		String Summary=request.getParameter("Summary")==null?"":request.getParameter("Summary");
		
		if(locn_type == null || locn_type.equals(""))
			locn_type="";
		
		String queueValue =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.QPr.label","ca_labels");

		if(locn_type.equals("EM"))
			queueValue = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.priority.label","common_labels");
		else if(locn_type.equals("OP"))
			queueValue = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.QNo.label","ca_labels");
		else
			queueValue = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.QPr.label","ca_labels");

		String fromMain = request.getParameter("fromMain")==null?"":request.getParameter("fromMain");
		Connection conn = null;
		boolean isQMSapplicable=false; // added for CRF - 192
		try 
		{
			conn=ConnectionManager.getConnection(request);
			Boolean pre_dis_advc_prep_site_YN = CommonBean.isSiteSpecific(conn, "CA", "PRE_DIS_ADVC_PRE");//IN064342	
			boolean isVirtualConsSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(conn, "CA","VIRTUAL_CONSALTATION"); //37866
%>
<html>
    <head>
<%
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
    <title>View Patient List by Location Result (by Locn)</title>
    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	 <script src='../../eCA/js/PatientListByLocationResult.js' language='javascript'></script> 
	 	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

   
    </head>
    <body class='CONTENT'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
        <form name="formLocnResultLocation" id="formLocnResultLocation">

	     <%
				isQMSapplicable=eOP.QMSInterface.isSiteSpecific(conn,"OP","EXT_QUEUE_NO");
		 		if(locn_type.equals("IP") || locn_type.equals("DC"))
			{
				%>
                <table id='TitleTab' border='1' cellpadding='0' cellspacing='0' width='auto' >
                    <tr>
                        <th class='columnheader' width="16px" nowrap  valign="top">&nbsp;</th>
                        <th class='columnheader' width="16px" nowrap  valign="top">&nbsp;</th>
                        <!-- //22856-start-->
                        <th class='columnheader' width="" nowrap rowspan=3 valign="top" ><fmt:message key="eCA.Sno.label" bundle="${common_labels}"/></th>
                        <!-- //22856-End-->
                        <th class='columnheader' width="" nowrap colspan=3  valign="top"><a name=1 href="javascript:callForOrderByLoc('PN');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></a></th><th class='columnheader' width="" nowrap  valign="top"><a name=1 href="javascript:callForOrderByLoc('PID');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></a></th><th class='columnheader' width="" nowrap  valign="top"><a name=1 href="javascript:callForOrderByLoc('AGE');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.age.label" bundle="${common_labels}"/></a></th><th class='columnheader' width="" nowrap  valign="top"><a name=1 href="javascript:callForOrderByLoc('SEX');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.Sex.label" bundle="${common_labels}"/></a></th>
						<!-- Changes Suggested By Sunil To rearrange bedNo and Room No Column-->
						<th class='columnheader' width="" nowrap valign="top"><a name=1 href="javascript:callForOrderByLoc('BN');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></a></th><th class='columnheader' width="" nowrap  valign="top"><a name=1 href="javascript:callForOrderByLoc('RN');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.roomno.label" bundle="${common_labels}"/></a></th>
						
						<th class='columnheader' width="" nowrap  valign="top"><a name=1 href="javascript:callForOrderByLoc('AP');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></a></th><th class='columnheader' width="" nowrap  valign="top"><a name=1 href="javascript:callForOrderByLoc('MS');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.MedicalService.label" bundle="${common_labels}"/></a></th><th class='columnheader' width="" nowrap  valign="top"><a name=1 href="javascript:callForOrderByLoc('AD');"  onclick='changeColor(this);' style="color:pink"><fmt:message key="Common.admissiondate.label" bundle="${common_labels}"/></a></th><th class='columnheader' width="" nowrap  valign="top"><a name=1 href="javascript:callForOrderByLoc('IQS');"  onclick='changeColor(this);' style="color:white" ><fmt:message key="Common.QueueStatus.label" bundle="${common_labels}"/></a></th>
						<!-- added new header for CRF-025 -->
						<!--<td class='columnheader' width="" nowrap><style="color:white"/><fmt:message key="eCA.researchStudy.label" bundle="${ca_labels}"/></td>-->
						<th class='columnheader' width="" nowrap  valign="top"><style="color:white"/><fmt:message key="eCA.PatientClassification.label" bundle="${ca_labels}"/></th> <!--IN044246-->
						<!-- Changes Suggested By Sunil To rearrange bedNo and Room No Column-->
						<!--<td class='columnheader' width="" nowrap><a name=1 href="javascript:callForOrderByLoc('BN');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></a></td><td class='columnheader' width="" nowrap><a name=1 href="javascript:callForOrderByLoc('RN');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.roomno.label" bundle="${common_labels}"/></a></td>--><th class='columnheader' width="" nowrap valign="top"><a name=1 href="javascript:callForOrderByLoc('DD');"  onclick='changeColor(this);' style="color:white"><fmt:message key="Common.dischargedate.label" bundle="${common_labels}"/></a></th><th class='columnheader' width="" nowrap  valign="top"><a name=1 href="javascript:callForOrderByLoc('DOB');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></a></th><th class='columnheader' width="" nowrap  valign="top"><a name=1 href="javascript:callForOrderByLoc('RID');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></a></th>
                        
					<%
						//IN064342 start
						if(pre_dis_advc_prep_site_YN)
						{
					%>
							<th class='columnheader' width=""  valign="top"><a name=1 href="javascript:callForOrderByLoc('PDA');" onclick='changeColor(this);' style="color:white"><fmt:message key="eCA.PreDischargeAdvice.label" bundle="${ca_labels}"/></a></th>
					<%
						}
						//IN064342 end
					%>
					<th class='columnheader' width=""  valign="top">&nbsp;&nbsp;&nbsp;</th>
					</tr>
                </table>
                <%}else if(locn_type.equals("OP") || locn_type.equals("EM")){%>
                 <table id='TitleTab' border='1' cellpadding='0' cellspacing='0' width='auto' >
                        <tr>
                            <th class='columnheader' width="16px" nowrap valign="top">&nbsp;</th>
                            <th class='columnheader' width="16px" nowrap valign="top">&nbsp;</th>
                           <!-- //22856-start-->
                            <th class='columnheader' width="" nowrap rowspan=2 valign="top" ><fmt:message key="eCA.Sno.label" bundle="${common_labels}"/></th>
                           <!-- //22856-End-->
                            <!-- <td class='columnheader' width="" nowrap><a name=1 href="javascript:callForOrderByLoc('AT');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.appttime.label" bundle="${common_labels}"/></a></td><td class='columnheader' width="" nowrap><a name=1 href="javascript:callForOrderByLoc('QN');" onclick='changeColor(this);' style="color:white"><%=queueValue%></a></td><td class='columnheader' width="" nowrap colspan=3><a name=1 href="javascript:callForOrderByLoc('PN');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></a></td><td class='columnheader' width="" nowrap><a name=1 href="javascript:callForOrderByLoc('PID');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></a></td><td class='columnheader' width="" nowrap><a name=1 href="javascript:callForOrderByLoc('AGE');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.age.label" bundle="${common_labels}"/></a></td><td class='columnheader' width="" nowrap><a name=1 href="javascript:callForOrderByLoc('SEX');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.Sex.label" bundle="${common_labels}"/></a></td><td class='columnheader' width="" nowrap><a name=1 href="javascript:callForOrderByLoc('AP');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></a></td><td class='columnheader' width="" nowrap><a name=1 href="javascript:callForOrderByLoc('MS');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.MedicalService.label" bundle="${common_labels}"/></a></td> [IN030291]-->
							<th class='columnheader' width="" nowrap  valign="top"><a name=1 href="javascript:callForOrderByLoc('AT');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.appttime.label" bundle="${common_labels}"/></a></th>
							<th class='columnheader' width="" nowrap  valign="top"><a name=1 href="javascript:callForOrderByLoc('QN');" onclick='changeColor(this);' style="color:white"><%=queueValue%></a></th>
							<% if((isQMSapplicable) && locn_type.equals("OP")) // added for [IN030532]
							{ 
							%>
								<th class='columnheader' width="" nowrap  valign="top"><fmt:message key="eOP.CallTicket.label" bundle="${op_labels}"/></th>
							<%
							}
							%>
							<th class='columnheader' width="" nowrap colspan=3  valign="top"><a name=1 href="#" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.isinpatient.label" bundle="${common_labels}"/></a></th>
							<th class='columnheader' width="" nowrap colspan=3  valign="top"><a name=1 href="javascript:callForOrderByLoc('PN');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></a></th>
							<%
							//37866 Start.
							if(isVirtualConsSiteSpec  && locn_type.equals("OP")){%>
								<th class='columnheader'   nowrap ><a style='color:white'   ><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ConsultationType.label","ca_labels")%></a></th>
							<%}
							//37866 End.
							%>
							<th class='columnheader' width="" nowrap  valign="top"><a name=1 href="javascript:callForOrderByLoc('PID');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></a></th>
							<th class='columnheader' width="" nowrap  valign="top"><a name=1 href="javascript:callForOrderByLoc('AGE');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.age.label" bundle="${common_labels}"/></a></th>
							<th class='columnheader' width="" nowrap  valign="top"><a name=1 href="javascript:callForOrderByLoc('SEX');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.Sex.label" bundle="${common_labels}"/></a></th>
							<th class='columnheader' width="" nowrap  valign="top"><a name=1 href="javascript:callForOrderByLoc('AP');" onclick='changeColor(this);' style="width=150px;color:white"><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></a></th>
							<th class='columnheader' width="" nowrap  valign="top"><a name=1 href="javascript:callForOrderByLoc('MS');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.MedicalService.label" bundle="${common_labels}"/></a></th>  <!--  [IN030291] -->
							
							
							
							<%if(locn_type.equals("OP")){%>
							<th class='columnheader' width="" nowrap  valign="top"><a name=1 href="javascript:callForOrderByLoc('VT');" onclick='changeColor(this);' style="color:white"><nobr><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></nobr></a></th>
							<%}%>
							<th class='columnheader' width="" nowrap  valign="top"><a name=1 href="javascript:callForOrderByLoc('VD');" onclick='changeColor(this);' style="color:pink"><fmt:message key="Common.VisitDate.label" bundle="${common_labels}"/></a></th>
							<th class='columnheader' width="" nowrap colspan=2 valign="top"><a name=1 href="javascript:callForOrderByLoc('QS');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.QueueStatus.label" bundle="${common_labels}"/></a></th>
								<!-- added new header for CRF-025 -->
							<!--<td class='columnheader' style="width=100px;color:white" nowrap>	<fmt:message key="eCA.researchStudy.label" bundle="${ca_labels}"/>		</td>	-->
							<th class='columnheader' width="" nowrap  valign="top"><style="color:white"/><fmt:message key="eCA.PatientClassification.label" bundle="${ca_labels}"/></th> <!--IN044246-->
							<th class='columnheader' width="" nowrap  valign="top"><nobr>												
							<a name=1 href="javascript:callForOrderByLoc('DD');" onclick='changeColor(this);' style="color:white"><fmt:message key="eCA.ConsEndDate.label" bundle="${ca_labels}"/></a></nobr></th>
							<th class='columnheader' width="" nowrap  valign="top"><a name=1 href="javascript:callForOrderByLoc('DOB');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></a></th><th class='columnheader' width="" nowrap  valign="top"><nobr><a name=1 href="javascript:callForOrderByLoc('RID');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></a></nobr></th>
                            <th class='columnheader' width=""  valign="top">&nbsp;&nbsp;&nbsp;</th>
                        </tr>
                    </table>
                <%} else if(locn_type.equals("RP")) { %>
				<table id='TitleTab' border='1' cellpadding='0' cellspacing='0' width='auto' >
                    <tr>
					<th>&nbsp;</th>
					<th>&nbsp;</th>
				<th nowrap  valign="top"><a id='a01'   href="javascript:callForOrderByLoc('PN');" onclick='changeColor(this);' style='color:white'>
							<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></a></th>
				<th nowrap  valign="top"><a id='a02'   href="javascript:callForOrderByLoc('RID');" onclick='changeColor(this);' style='color:white'>
							<fmt:message key="Common.referralid.label" bundle="${common_labels}"/></a></th>
				<th nowrap  valign="top"><a id='a03'   href="javascript:callForOrderByLoc('AGE');" onclick='changeColor(this);' style='color:white'>
							<fmt:message key="Common.age.label" bundle="${common_labels}"/></a></th>
				<th nowrap  valign="top"><a id='a04'   href="javascript:callForOrderByLoc('SEX');" onclick='changeColor(this);' style='color:white'>
							<fmt:message key="Common.Sex.label" bundle="${common_labels}"/></a></th>
				<th nowrap  valign="top"><a id='a05'   href="javascript:callForOrderByLoc('PID');" onclick='changeColor(this);' style='color:white'>
							<fmt:message key="Common.patientId.label" bundle="${common_labels}"/></a></th>
				<th nowrap  valign="top"><a id='a06'  href="javascript:callForOrderByLoc('SAP');" onclick='changeColor(this);' style='color:white'> 				<fmt:message key="eCA.ReferralStatus.label" bundle="${ca_labels}"/></a></th>
				<th nowrap  valign="top"><a id='a07'   href="javascript:callForOrderByLoc('AD');" onclick='changeColor(this);' style='color:pink'>
							<fmt:message key="Common.VisitAdmDate.label" bundle="${common_labels}"/></a></th>
				<th nowrap  valign="top"><a id='a08' href="javascript:callForOrderByLoc('DD');" onclick='changeColor(this);' style='color:white'> 				<fmt:message key="eCA.VisitAdmEndDate.label" bundle="${ca_labels}"/></a></th>
				<th nowrap  valign="top"><a id='a09'   href="javascript:callForOrderByLoc('RN');" onclick='changeColor(this);' style='color:white'> 				<fmt:message key="Common.roomno.label" bundle="${common_labels}"/></a></th>
				<th nowrap  valign="top"><a id='a10'   href="javascript:callForOrderByLoc('BN');" onclick='changeColor(this);' style='color:white'> 				<fmt:message key="Common.bedno.label" bundle="${common_labels}"/></a></th>
				<!-- added new header for CRF-025 -->
				<!--<th nowrap><fmt:message key="eCA.researchStudy.label" bundle="${ca_labels}"/></th>-->
				<th nowrap  valign="top"><fmt:message key="eCA.PatientClassification.label" bundle="${ca_labels}"/></th><!--IN044246-->
				<th nowrap  valign="top"><a id='a11'   href="javascript:callForOrderByLoc('AP');" onclick='changeColor(this);' style='color:white'> 				<fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></a></th>
				<th nowrap  valign="top"><fmt:message key="Common.action.label" bundle="${common_labels}"/></th>


					</tr>

				<%}%>
                <input type=hidden name=url id=url value="<%=request.getQueryString()%>">
            </form>
        </body>
        <!--to load the detail frame-->
    <script>
<%  if(!fromMain.equals("Y")){  %>
		if ("<%=Summary%>" == "Summary")
		{
			 var url=parent.parent.PatResultFr.LocnResultPatClass.document.forms[0].url.value;
        	parent.parent.PatResultFr.LocnResult.location.href='../../eCA/jsp/PatListByLocationResult.jsp?'+url+'&Summary=Summary';
		}else{
        var url=top.content.workAreaFrame.PatResultFr.LocnResultPatClass.document.forms[0].url.value;
        top.content.workAreaFrame.PatResultFr.LocnResult.location.href='../../eCA/jsp/PatListByLocationResult.jsp?'+url;
		}
		//alert(1);
<%  } else  {   %>
       if ("<%=Summary%>" == "Summary")	parent.parent.PatResultFr.LocnResult.location.href='../../eCA/jsp/PatListByLocationResult.jsp?<%=request.getQueryString()%>&Summary=Summary';
		else		 			top.content.workAreaFrame.PatResultFr.LocnResult.location.href='../../eCA/jsp/PatListByLocationResult.jsp?<%=request.getQueryString()%>';
		//alert(2);
<%  }   %>
	<% // added for CRF 192
	}
	catch(Exception e){}
	finally{
		if(conn!=null) ConnectionManager.returnConnection(conn,request);
	}%>
    </script>
    </html>

