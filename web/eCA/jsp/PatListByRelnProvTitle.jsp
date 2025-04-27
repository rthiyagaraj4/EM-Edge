<%
/*
-------------------------------------------------------------------------------------------------------------------------------
	Date		Edit History	Name				Rev.Date   		Rev.By 		Description
-------------------------------------------------------------------------------------------------------------------------------
?				100				?           									created
15/04/2023		37866			Ramesh G		 								MMS-DM-CRF-0226
22-06-2023        22856      Srinivasa N T                      22-06-2023            Ramesh G    ML-MMOH-CRF-1778
-------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locn_type = request.getParameter("locn_type");
String fromMain = request.getParameter("fromMain")==null?"":request.getParameter("fromMain");
if(locn_type == null || locn_type.equals(""))locn_type="";
Connection con = null;
boolean isVirtualConsSiteSpec = false;
	try{
		con=ConnectionManager.getConnection(request);
		isVirtualConsSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","VIRTUAL_CONSALTATION"); //37866
	}catch(Exception e){
		
	}finally{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>
<html>
	<head>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
 <%
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<!-- <modifeid by Arvind @02-12-2008> -->
	

	<script src='../../eCA/js/PatListByRelnProvResult.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<title><fmt:message key="eCA.ViewPatientListbyLocationResultMain.label" bundle="${ca_labels}"/></title>
	</head>
	<body  class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="formLocnResultLocation" id="formLocnResultLocation">
			<%if(locn_type.equals("IP") || locn_type.equals("DC")){%>
				<table  id='TitleTab' border='1' cellpadding='3' cellspacing='0' width='100%' align='center'>
					<tr >
						<td class='columnheader' width="" nowrap>&nbsp;</td>
						<td class='columnheader' width="" nowrap>&nbsp;</td>
						<!-- //22856-start-->
                                                <td class='columnheader' nowrap  ><fmt:message key="eCA.Sno.label" bundle="${common_labels}"/></td>
                                                <!-- //22856-End-->
						<td class='columnheader' width="" nowrap colspan=3 ><a name=1   href="javascript:callForOrderByRel('PN');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></a></td>						
						<td class='columnheader' width="" nowrap><a name=1   href="javascript:callForOrderByRel('AGE');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.age.label" bundle="${common_labels}"/></a></td>
						<td class='columnheader' width="" nowrap><a name=1   href="javascript:callForOrderByRel('SEX');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.Sex.label" bundle="${common_labels}"/></a></td>
						<td class='columnheader' width="" nowrap><a name=1   href="javascript:callForOrderByRel('PID');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></a></td>
						<td class='columnheader' width="" nowrap><a name=1   href="javascript:callForOrderByRel('AD');" 	onclick='changeColor(this);' style="color:pink"><fmt:message key="Common.VisitAdmDate.label" bundle="${common_labels}"/></a></td>
						<!--  -->
						<td class='columnheader' width="" nowrap><a name=1   href="javascript:callForOrderByRel('IQS');" 	onclick='changeColor(this);' style="color:white"><fmt:message key="Common.QueueStatus.label" bundle="${common_labels}"/></a></td>
						<!--  -->
						<td class='columnheader' width="" nowrap><a name=1   href="javascript:callForOrderByRel('DD');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.dischargedate.label" bundle="${common_labels}"/></a></td>
						<td class='columnheader' width="" nowrap><a name=1    href="javascript:callForOrderByRel('PR');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></a></td>
						<td class='columnheader' width="" nowrap><a name=1    href="javascript:callForOrderByRel('LOC');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></a></td>
						<td class='columnheader' width="" nowrap><a name=1     href="javascript:callForOrderByRel('SD');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></a></td>
						<td class='columnheader' width="" nowrap><a name=1     href="javascript:callForOrderByRel('ED');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></a></td>
						<td class='columnheader' width="" nowrap><a name=1     href="javascript:callForOrderByRel('DOB');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></a></td>
						<td class='columnheader' width="" nowrap><a name=1   href="javascript:callForOrderByRel('RID');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></a></td>
						<td class='columnheader' width="">&nbsp;&nbsp;&nbsp;</td> 
					</tr>
				</table>
				<%}
				else if(locn_type.equals("EM") || locn_type.equals("OP")||locn_type.equals("XT") ){%>
					<table id='TitleTab' border='1' cellpadding='3' cellspacing='0' width='100%' align='center'>
						<tr>
							<td class='columnheader' width="" nowrap>&nbsp;</td>
							<td class='columnheader' width="" nowrap>&nbsp;</td>
						        <!-- //22856-start-->
                                                        <td class='columnheader'  nowrap  ><fmt:message key="eCA.Sno.label" bundle="${common_labels}"/></td>
                                                        <!-- //22856-End-->
							<td class='columnheader' width="" nowrap colspan=3 ><a name=1     href="javascript:callForOrderByRel('PN');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></a></td>	
							<%
							//37866 Start.
							if(isVirtualConsSiteSpec && locn_type.equals("OP")){%>
								<td class='columnheader' width=""  nowrap ><a style='color:white'   ><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ConsultationType.label","ca_labels")%></a></td>
							<%}
							//37866 End.
							%>
							<td class='columnheader' width="" nowrap><a name=1     href="javascript:callForOrderByRel('AGE');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.age.label" bundle="${common_labels}"/></a></td>
							<td class='columnheader' width="" nowrap><a name=1     href="javascript:callForOrderByRel('SEX');" onclick='changeColor(this);' style="color:white">Sex</a></td>
							<td class='columnheader' width="" nowrap><a name=1     href="javascript:callForOrderByRel('PID');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></a></td>
							<td class='columnheader' width="" nowrap><a name=1     href="javascript:callForOrderByRel('AD');" onclick='changeColor(this);' style="color:pink"><fmt:message key="Common.VisitAdmDate.label" bundle="${common_labels}"/></a></td>
							<%if(locn_type.equals("OP")) {%>
							<td class='columnheader' width="" nowrap><a name=1     href="javascript:callForOrderByRel('VT');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></a></td>
							<%}%>
							<td class='columnheader' width="" nowrap><a name=1     href="javascript:callForOrderByRel('DD');" onclick='changeColor(this);' style="color:white"><fmt:message key="eCA.ConsEndDate.label" bundle="${ca_labels}"/></a></td>
							<td class='columnheader' width="" nowrap colspan=2><a name=1     href="javascript:callForOrderByRel('PR');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></a></td>
							<td class='columnheader' width="" nowrap><a name=1     href="javascript:callForOrderByRel('LOC');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></a></td>
							<td class='columnheader' width="" nowrap><a name=1     href="javascript:callForOrderByRel('SD');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></a></td><td class='columnheader' width="" nowrap><a name=1     href="javascript:callForOrderByRel('ED');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></a></td>
							<td class='columnheader' width="" nowrap><a name=1     href="javascript:callForOrderByRel('DOB');" onclick='changeColor(this);' style="color:white">DOB</a></td>
							<td class='columnheader' width="" nowrap><nobr><a name=1     href="javascript:callForOrderByRel('RID');" onclick='changeColor(this);' style="color:white"><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></a></nobr></td>
							<td class='columnheader' width="">&nbsp;&nbsp;&nbsp;</td> 
						</tr>
					</table>
				<%}%>

			</form>
		</body>
		<script>

<% 	if(!fromMain.equals("Y")){ 	%> 
		var url=top.content.workAreaFrame.PatResultFr.RelnResultPatClass.document.forms[0].url.value	; 
		top.content.workAreaFrame.PatResultFr.LocnResult.location.href='PatListByRelnProvResult.jsp?'+url;		
<%	} else	{ 	%>
	top.content.workAreaFrame.PatResultFr.LocnResult.location.href='PatListByRelnProvResult.jsp?<%=request.getQueryString()%>';
<%	}	%>

	</script>
</html>

