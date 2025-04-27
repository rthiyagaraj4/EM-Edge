<!DOCTYPE html>
<%/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History      Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
15/04/2023		37866			Ramesh G		 MMS-DM-CRF-0226	
22-06-2023        22856      Srinivasa N T                      22-06-2023            Ramesh G    ML-MMOH-CRF-1778
---------------------------------------------------------------------------------------------------------------

*/ %>
<%@ page import ="java.sql.*,webbeans.eCommon.*, java.text.*, eCA.* , java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@page contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locn_type = request.getParameter("locn_type");
if(locn_type == null || locn_type.equals(""))locn_type="";
		String fromMain = request.getParameter("fromMain")==null?"":request.getParameter("fromMain");
		
%>
<html>
	<head>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script src='../../eCA/js/PatListByMedServiceResult.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 <%
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<!-- <title>View Patient List by Location Result (by Locn)</title>
	<script>
		var reOrder='';
		var scrollLeft='';
		function callForOrderBy(obj){
			var qryStr = parent.MedServResultLocation.document.forms[0].url.value;
			var url=qryStr+'&orderBy='+obj+'&reOrder='+reOrder+'&leftScrolling='+scrollLeft;
			parent.LocnResult.location.href='PatListByMedServiceResult.jsp?'+url;
		}

		function changeColor(object){
			scrollLeft=document.body.scrollLeft;
			if(object.style.color=='yellow'){
				reOrder='1';
				object.style.color='pink';
				return;
			}
			if(object.style.color=='pink'){
				reOrder='2';
				object.style.color='yellow';
				return;
			}
			reOrder='1';
			for(i=0;i<document.anchors.length;i++){
				document.anchors(i).style.color='white';
			}
			object.style.color='pink';
		}
	</script> -->
	</head>
	<%
	Connection con =null;
	boolean isVirtualConsSiteSpec =false;
	try{
		con = ConnectionManager.getConnection(request);
		isVirtualConsSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","VIRTUAL_CONSALTATION"); //37866
	}
	catch ( Exception e) 
	{
		out.println("In PatListByMedServicePatTitle : "+e);
	}
	finally 
	{		
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}
	%>
	<body  class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="formLocnResultLocation" id="formLocnResultLocation">
				<%if(locn_type.equals("IP") || locn_type.equals("DC")){%> 
					<table id='TitleTab' border='1' cellpadding='3' cellspacing='0'  width='auto'>
					<tr>
						<td class='columnHeadercenter' width="16px" nowrap>&nbsp;</td>
						<td class='columnHeadercenter' width="16px" nowrap>&nbsp;</td>
					        <!-- //22856-start-->
                                                <td class='columnheadercenter'  rowspan=1 width='' nowrap  ><fmt:message key="eCA.Sno.label" bundle="${common_labels}"/></td>
                                                <!-- //22856-End-->
						<td class='columnHeadercenter' width="" nowrap colspan='3'><a name=1   href="javascript:callForOrderBy('PN');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></a></td>						
						<td class='columnHeadercenter' width="" nowrap><a name=1   href="javascript:callForOrderBy('AGE');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.age.label" bundle="${common_labels}"/></a></td>
						<td class='columnHeadercenter' width="" nowrap><a name=1   href="javascript:callForOrderBy('SEX');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.gender.label" bundle="${common_labels}"/></a></td>
						<td class='columnHeadercenter' width="" nowrap><a name=1   href="javascript:callForOrderBy('PID');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></a></td>
						<td class='columnHeadercenter' width="" nowrap><a name=1   href="javascript:callForOrderBy('AD');" onclick='changeColor(this);' style="color:pink"><fmt:message key="Common.admissiondate.label" bundle="${common_labels}"/></a></td>
						<td class='columnHeadercenter' width="" nowrap><a name=1 href="javascript:callForOrderBy('IQS');"  onclick='changeColor(this);' style="color:white" ><fmt:message key="Common.QueueStatus.label" bundle="${common_labels}"/></a></td>
						<td class='columnHeadercenter' width="" nowrap><a name=1   href="javascript:callForOrderBy('DD');" onclick='changeColor(this);' title='discharge date' style="color:white"><fmt:message key="Common.dischargedate.label" bundle="${common_labels}"/></a></td>
						<td class='columnHeadercenter' width="" nowrap><a name=1   href="javascript:callForOrderBy('RN');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.roomno.label" bundle="${common_labels}"/></a></td>
						<td class='columnHeadercenter' width="" nowrap><a name=1   href="javascript:callForOrderBy('BN');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></a></td>
						<td class='columnHeadercenter' width="" nowrap><a name=1   href="javascript:callForOrderBy('AP');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></a></td>
						<td class='columnHeadercenter' width="" nowrap><a name=1   href="javascript:callForOrderBy('LOC');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></a></td>
						<td class='columnHeadercenter' width="" nowrap><a name=1   href="javascript:callForOrderBy('DOB');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></a></td>
						<td class='columnHeadercenter' width="" nowrap><a name=1   href="javascript:callForOrderBy('RID');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></a></td>
						<!--<td class='columnHeadercenter' width="">&nbsp;&nbsp;&nbsp;</td> -->
					</tr>
					</table>
				<%}else if(locn_type.equals("OP") || locn_type.equals("EM")){%>
						<table id='TitleTab' border='1' cellpadding='0' cellspacing='0'  width='auto'>
						<tr>
							<td class='columnHeadercenter' width="16px" nowrap>&nbsp;</td>
							<td class='columnHeadercenter' width="16px" nowrap>&nbsp;</td>
		                                        <!-- //22856-start-->
                                                        <td class='columnheadercenter'  rowspan=1 width='' nowrap  ><fmt:message key="eCA.Sno.label" bundle="${common_labels}"/></td>
                                                        <!-- //22856-End-->
							<td class='columnHeadercenter' width="" nowrap><a name=1   href="javascript:callForOrderBy('AT');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.appttime.label" bundle="${common_labels}"/></a></td>
							<td class='columnHeadercenter' width="" nowrap><a name=1   href="javascript:callForOrderBy('QN');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.QueueNo.label" bundle="${common_labels}"/></a></td>
							<td class='columnHeadercenter' width="" nowrap><a name=1   href="javascript:callForOrderBy('PN');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></a></td>
							<%
							//37866 Start.
							if(isVirtualConsSiteSpec && locn_type.equals("OP")){%>
							<td class='columnHeadercenter' width="" nowrap><a  style="color:white"><fmt:message key="eCA.ConsultationType.label" bundle="${ca_labels}"/></a></td>
							<%}
							//37866 End.
							%>
							<td class='columnHeadercenter' width="" nowrap><a name=1   href="javascript:callForOrderBy('AGE');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.age.label" bundle="${common_labels}"/></a></td>
							<td class='columnHeadercenter' width="" nowrap><a name=1   href="javascript:callForOrderBy('SEX');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.gender.label" bundle="${common_labels}"/></a></td>
							<td class='columnHeadercenter' width="" nowrap><a name=1   href="javascript:callForOrderBy('PID');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></a></td>
							<td class='columnHeadercenter' width="" nowrap><a name=1   href="javascript:callForOrderBy('VD');" onclick='changeColor(this);' style="color:pink"><fmt:message key="Common.VisitDate.label" bundle="${common_labels}"/></a></td>
							<%if(locn_type.equals("OP")){%>
							<td class='columnHeadercenter' width="" nowrap><a name=1   href="javascript:callForOrderBy('VT');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></a></td>
							<%}%>
							<td class='columnHeadercenter' width="" nowrap><a name=1   href="javascript:callForOrderBy('DD');" onclick='changeColor(this);' style="color:white"><fmt:message key="eCA.ConsEndDate.label" bundle="${ca_labels}"/></a></td>
							<td class='columnHeadercenter' width="" nowrap colspan='2'><a name=1   href="javascript:callForOrderBy('QS');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.QueueStatus.label" bundle="${common_labels}"/></a></td>
							<td class='columnHeadercenter' width="" nowrap><a name=1   href="javascript:callForOrderBy('AP');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></a></td>
							<td class='columnHeadercenter' width="" nowrap><a name=1   href="javascript:callForOrderBy('LOC');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></a></td>
							<td class='columnHeadercenter' width="" nowrap><a name=1   href="javascript:callForOrderBy('DOB');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></a></td>
							<td class='columnHeadercenter' width="" nowrap><nobr><a name=1   href="javascript:callForOrderBy('RID');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></a></nobr></td>
						<!--	<td class='columnHeadercenter' width="">&nbsp;&nbsp;&nbsp;</td> -->
						</tr>
						</table>
				<%}%>
				<input type=hidden name=url id=url value="<%=request.getQueryString()%>">
			</form>
		</body>

<script>
<% 	if(!fromMain.equals("Y")){ 	%> 
		var url=top.content.workAreaFrame.PatResultFr.MedServResultPatClass.document.forms[0].url.value	; 
		top.content.workAreaFrame.PatResultFr.LocnResult.location.href='PatListByMedServiceResult.jsp?'+url;		
<%	} else	{ 	%>
	top.content.workAreaFrame.PatResultFr.LocnResult.location.href='PatListByMedServiceResult.jsp?<%=request.getQueryString()%>';
<%	}	%>
</script>
</html>

