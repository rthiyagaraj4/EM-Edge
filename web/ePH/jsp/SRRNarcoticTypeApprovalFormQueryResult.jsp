<!DOCTYPE html>
 
<!--This file is saved on 15/12/2009-->
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
//Added by Himanshu for MMS-ME-SCF-0097 Starts 
	request= new XSSRequestWrapper(request); 
	response.addHeader("X-XSS-Protection", "1; mode=block"); 
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//Added by Himanshu for MMS-ME-SCF-0097 ends
		String locale			= (String)session.getAttribute("LOCALE");


String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../ePH/js/SRRNarcoticTypeApprovalForm.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<script language="javascript" src="../js/PhCommon.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
<form name="SRRNarcoticTypeApprovalFormResult" id="SRRNarcoticTypeApprovalFormResult">

<%
   try{
    String bean_id				= "SRROnlineReportSet1Bean" ;
	String bean_name			= "ePH.SRROnlineReportSet1Bean";
	SRROnlineReportSet1Bean bean		= (SRROnlineReportSet1Bean)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(locale);

	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
   // String locale = request.getParameter("locale");
    String patient_id = CommonBean.checkForNull(request.getParameter("patient_id"));
    String p_fr_pre = CommonBean.checkForNull(request.getParameter("p_fr_pre"));
    String p_to_pre = CommonBean.checkForNull(request.getParameter("p_to_pre"));
    String p_encounter = CommonBean.checkForNull(request.getParameter("p_encounter"));
    String pract_code = CommonBean.checkForNull(request.getParameter("pract_code"));
    String drug_code = CommonBean.checkForNull(request.getParameter("drug_code"));
    String locn_type = CommonBean.checkForNull(request.getParameter("locn_type"));
    String locn_code = CommonBean.checkForNull(request.getParameter("locn_code"));
    String adr_reported_date_from = CommonBean.checkForNull(request.getParameter("adr_reported_date_from"));
    String adr_reported_date_to = CommonBean.checkForNull(request.getParameter("adr_reported_date_to"));
    String p_narcotics = CommonBean.checkForNull(request.getParameter("p_narcotics"));
	String from = CommonBean.checkForNull(request.getParameter("from"));
	String to = CommonBean.checkForNull(request.getParameter("to"));


	ArrayList result =new ArrayList();
	result=bean.getNarcoTypeApprovalList(patient_id,adr_reported_date_from,adr_reported_date_to,p_encounter,pract_code,p_fr_pre,p_to_pre,locn_type,locn_code,p_facility_id,locale,drug_code,p_narcotics,from,to);
	

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
			<th  nowrap><fmt:message key="Common.OrderDate.label" bundle="${common_labels}"/></th>
			<th  nowrap><fmt:message key="ePH.NarcoticNo.label" bundle="${st_labels}"/></th>
			<th  nowrap><fmt:message key="Common.DrugName.label" bundle="${mm_labels}"/></th>
			<th  nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
			<th  nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
			<th  nowrap><fmt:message key="ePH.PrescriptionID.label" bundle="${ph_labels}"/></th  >
			<th  nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>

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
		
		record[0]=com.ehis.util.DateUtils.convertDate(record[0],"DMYHM","en",locale);
	%>
		<tr>
			<td class="<%=classvalue%>" style="font-size=9" nowrap><font class="hyperlink" style="cursor:pointer" onClick="showPrintReport('<%=record[1]%>','<%=p_facility_id%>','<%=locale%>')"><%=record[0]%></font></td>
				<td class="<%=classvalue%>" style="font-size=9"><font class="hyperlink" style="cursor:pointer" onClick="showPrintReport('<%=record[1]%>','<%=p_facility_id%>','<%=locale%>')"><%=record[1]%></font></td>
			<td class="<%=classvalue%>" style="font-size=9" nowrap ><%=record[2]%></td>
			<td class="<%=classvalue%>" style="font-size=9" nowrap ><%=record[3]%></td>
			<td class="<%=classvalue%>" style="font-size=9" nowrap ><%=record[4]%></td>
			<td class="<%=classvalue%>" style="font-size=9" nowrap ><%=record[5]%></td>			
			<td class="<%=classvalue%>" style="font-size=9" nowrap ><%=record[6]%></td>			
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
	<input type="hidden" name="patient_id" id="patient_id" value="">
	<input type="hidden" name="p_fr_pre" id="p_fr_pre" value="">
	<input type="hidden" name="p_to_pre" id="p_to_pre" value="">
	<input type="hidden" name="adr_reported_date_from" id="adr_reported_date_from" value="">
	<input type="hidden" name="adr_reported_date_to" id="adr_reported_date_to" value="">
	<input type="hidden" name="p_encounter" id="p_encounter" value="">
	<input type="hidden" name="pract_code" id="pract_code" value="">
	<input type="hidden" name="p_narcotics" id="p_narcotics" value="">
	<input type="hidden" name="locn_type" id="locn_type" value="">
	<input type="hidden" name="locn_code" id="locn_code" value="">
	<input type="hidden" name="drug_code" id="drug_code" value="">
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



