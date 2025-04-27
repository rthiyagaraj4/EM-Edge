<!DOCTYPE html>
 
<!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="ePH.*, ePH.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
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


String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../ePH/js/SRRPhIssueToken.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<script language="javascript" src="../js/PhCommon.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
<form name="SRRPhIssueTokenQueryResult" id="SRRPhIssueTokenQueryResult">

<%
try{
	String bean_id				= "SRROnlineReportSet1Bean" ;
	String bean_name			= "ePH.SRROnlineReportSet1Bean";
	SRROnlineReportSet1Bean bean		= (SRROnlineReportSet1Bean)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(locale);

	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
    String p_token_series_code = CommonBean.checkForNull(request.getParameter("p_token_series_code"));
	String p_token_no = CommonBean.checkForNull(request.getParameter("p_token_no"));
	String p_disp_locn_code = CommonBean.checkForNull(request.getParameter("p_disp_locn_code"));
	String prescription_id = CommonBean.checkForNull(request.getParameter("prescription_id"));
    String p_disp_date_from = CommonBean.checkForNull(request.getParameter("p_disp_date_from"));
    String p_disp_date_to = CommonBean.checkForNull(request.getParameter("p_disp_date_to")); 
    String p_patient_id = CommonBean.checkForNull(request.getParameter("patient_id")); 
    String encounter_id = CommonBean.checkForNull(request.getParameter("encounter_id"));
    String pract_code = CommonBean.checkForNull(request.getParameter("pract_code"));
	String locn_type = CommonBean.checkForNull(request.getParameter("locn_type"));
    String locn_code = CommonBean.checkForNull(request.getParameter("locn_code")); 
    String p_langue = CommonBean.checkForNull(request.getParameter("p_langue"));    
	String from = CommonBean.checkForNull(request.getParameter("from"));
	String to = CommonBean.checkForNull(request.getParameter("to"));   

	ArrayList result =new ArrayList(); 
	//result=bean.getTokenList(p_token_no,p_token_series_code,p_patient_id,prescription_id,p_disp_locn_code,p_disp_date_from,p_disp_date_to,encounter_id,pract_code,locn_type,locn_code,p_facility_id,locale,p_langue,from,to);
	result=bean.getTokenList(p_token_no,p_token_series_code,p_patient_id,prescription_id,p_disp_locn_code,p_disp_date_from,p_disp_date_to,encounter_id,pract_code,locn_type,locn_code,p_facility_id,locale,locale,from,to); // The second locale is replacement of p_langue  for  SRR20056-SCF-7497[27545]
	
		if( (result.size()>=2) && ( !( ((String) result.get(0)).equals("0")) )){ %>
		<table cellpadding=0 cellspacing=0 align="center">
		<tr>
		<td width="80%" class="white">&nbsp;</td>
		<td width="20%" class="white">&nbsp;

		<%
		// For display the previous/next link
		out.println(result.get(0));
    	%>
		</td></tr>
		</table>
		<table cellpadding="0" cellspacing="0" width="98%" align="center" border="1" id="reprint_rep">
				<tr>
					<th  ><fmt:message key="ePH.TokenNo.label" bundle="${ph_labels}"/></th>
					<th  ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
					<th  ><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
					<th  ><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></th>
					<th  ><fmt:message key="Common.OrderDate.label" bundle="${common_labels}"/></th>
					<th  ><fmt:message key="ePH.PrescriptionID.label" bundle="${ph_labels}"/></th>
					<th  ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>

				</tr>
		<%
		String []record=new String[11];
		for (int i=1;i<result.size();i++){
			record= (String[])result.get(i);
		
			String classvalue="";
			if ( i % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
		
		record[5]=com.ehis.util.DateUtils.convertDate(record[5],"DMY","en",locale);
	%>
		<tr>
			<td class="<%=classvalue%>" style="font-size=9"><font class="hyperlink" style="cursor:pointer" onClick="showPrintReport('<%=p_facility_id%>','<%=p_langue%>','<%=record[1]%>','<%=record[8]%>','<%=record[9]%>','<%=record[6]%>','<%=record[7]%>','<%=record[10]%>')"><%=record[6]%></font></td>
				<td class="<%=classvalue%>" style="font-size=9"><font class="hyperlink" style="cursor:pointer" onClick="showPrintReport('<%=p_facility_id%>','<%=p_langue%>','<%=record[1]%>','<%=record[8]%>','<%=record[9]%>','<%=record[6]%>','<%=record[7]%>','<%=record[10]%>')"><%=record[1]%></font></td>
			<td class="<%=classvalue%>" style="font-size=9"><%=record[3]%></td>
			<td class="<%=classvalue%>" style="font-size=9"><%=record[4]%></td>
			<td class="<%=classvalue%>" style="font-size=9"><%=record[5]%></td>
			<td class="<%=classvalue%>" style="font-size=9"><%=record[0]%></td>			
			<td class="<%=classvalue%>" style="font-size=9"><%=record[2]%></td>			
		</tr>
	<%
		}
	}else{
	%>
		<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
			parent.frames[2].location.href = "../../eCommon/html/blank.html";
				</script>
	<%
	}%>

		</table>
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="from" id="from" value="">
	<input type="hidden" name="to" id="to" value="">
	<input type="hidden" name="p_patient_id" id="p_patient_id" value="">
	<input type="hidden" name="p_token_series_code" id="p_token_series_code" value="">
	<input type="hidden" name="p_token_no" id="p_token_no" value="">
	<input type="hidden" name="p_disp_locn_code" id="p_disp_locn_code" value="">
	<input type="hidden" name="prescription_id" id="prescription_id" value="">
	<input type="hidden" name="p_disp_date_from" id="p_disp_date_from" value="">
	<input type="hidden" name="p_disp_date_to" id="p_disp_date_to" value="">
	<input type="hidden" name="encounter_id" id="encounter_id" value="">
	<input type="hidden" name="locn_type" id="locn_type" value="">
	<input type="hidden" name="locn_code" id="locn_code" value="">
	<input type="hidden" name="pract_code" id="pract_code" value="">
	<input type="hidden" name="p_langue" id="p_langue" value="">
	<input type="hidden" name="p_QUEUE_DATE" id="p_QUEUE_DATE" value="">

	<% putObjectInBean(bean_id,bean,request); %>
		
	<%
	}catch (Exception exception) {
		
		exception.printStackTrace();
	}
	finally{
	}
%>
</form>
</body>
</html>



