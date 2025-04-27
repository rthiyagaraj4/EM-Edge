<!DOCTYPE html>
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
	<script language="javascript" src="../../ePH/js/SRRPhHomeMednSheet.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<script language="javascript" src="../js/PhCommon.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
<form name="SRRPhHomeMednSheetResult" id="SRRPhHomeMednSheetResult">

<%
   try{
    String bean_id				= "SRROnlineReportSet2Bean" ;
	String bean_name			= "ePH.SRROnlineReportSet2Bean";
	
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
  
    String patient_id = CommonBean.checkForNull(request.getParameter("patient_id"));
  
    String p_pres_id = CommonBean.checkForNull(request.getParameter("p_pres_id"));
    String fr_dispdate = CommonBean.checkForNull(request.getParameter("fr_dispdate"));
    String to_dispdate = CommonBean.checkForNull(request.getParameter("to_dispdate"));
    String p_encounter = CommonBean.checkForNull(request.getParameter("p_encounter"));
    String p_pract_id = CommonBean.checkForNull(request.getParameter("p_pract_id"));
    String p_disp_locn_code = CommonBean.checkForNull(request.getParameter("p_disp_locn_code"));
    String p_tokfr = CommonBean.checkForNull(request.getParameter("p_tokfr"));
    String p_tokto = CommonBean.checkForNull(request.getParameter("p_tokto"));
    String p_locn_type = CommonBean.checkForNull(request.getParameter("p_locn_type"));
    String p_locn_code = CommonBean.checkForNull(request.getParameter("p_locn_code"));
   // String locale = CommonBean.checkForNull(request.getParameter("locale"));

	SRROnlineReportSet2Bean bean		= (SRROnlineReportSet2Bean)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(locale);
 

	String from = CommonBean.checkForNull(request.getParameter("from"));
	String to = CommonBean.checkForNull(request.getParameter("to"));
	
	ArrayList result =new ArrayList();
	result=bean.getHomeMedicationList( locale,  p_pres_id, patient_id, fr_dispdate, to_dispdate, p_encounter,  p_disp_locn_code, p_locn_type, p_locn_code, from, to, p_tokto, p_tokfr, p_facility_id);
	
		

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
			<th  nowrap><fmt:message key="ePH.DispensedDate.label" bundle="${ph_labels}"/></th>
			<th  nowrap><fmt:message key="ePH.TokenNo.label" bundle="${ph_labels}"/></th>
			<th  nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
			<th  nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
			<th  nowrap><fmt:message key="ePH.PrescriptionID.label" bundle="${ph_labels}"/></th  >
			<th  nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
			<th  nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>

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
		
		//record[0]=com.ehis.util.DateUtils.convertDate(record[0],"DMY","en",locale); Commented By Sandhya for incident 25344
		//out.println("record[5]=====>" +record[5]);
//com.ehis.util.DateUtils.convertDate(record[5],"DMY","en",locale)
	%>
		<tr>


			<td class="<%=classvalue%>" style="font-size=9"><font class="hyperlink" style="cursor:pointer" onClick="showPrintReport('<%=record[5]%>','<%=record[6]%>','<%=record[1]%>')">&nbsp;<%=com.ehis.util.DateUtils.convertDate(record[5],"DMY","en",locale)%></font></td>
			<td class="<%=classvalue%>" style="font-size=9"><font class="hyperlink" style="cursor:pointer" onClick="showPrintReport('<%=record[5]%>','<%=record[6]%>','<%=record[1]%>')">&nbsp;<%=record[6]%></font></td>
			<td class="<%=classvalue%>" style="font-size=9">&nbsp;<%=record[1]%></td>
			<td class="<%=classvalue%>" style="font-size=9">&nbsp;<%=record[3]%></td>
			<td class="<%=classvalue%>" style="font-size=9">&nbsp;<%=record[0]%></td>
			<td class="<%=classvalue%>" style="font-size=9">&nbsp;<%=record[2]%></td>			
			<td class="<%=classvalue%>" style="font-size=9">&nbsp;<%=record[7]%></td>			
			
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
	<input type="hidden" name="p_pres_id" id="p_pres_id" value="">
	<input type="hidden" name="fr_dispdate" id="fr_dispdate" value="">
	<input type="hidden" name="to_dispdate" id="to_dispdate" value="">
	<input type="hidden" name="p_encounter" id="p_encounter" value="">
	<input type="hidden" name="p_pract_id" id="p_pract_id" value="">
	<input type="hidden" name="p_facility_id" id="p_facility_id" value="">
	<input type="hidden" name="p_disp_locn_code" id="p_disp_locn_code" value="">
	<input type="hidden" name="p_tokfr" id="p_tokfr" value="">
	<input type="hidden" name="p_tokto" id="p_tokto" value="">
	<input type="hidden" name="p_locn_type" id="p_locn_type" value="">
	<input type="hidden" name="p_locn_code" id="p_locn_code" value="">
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



