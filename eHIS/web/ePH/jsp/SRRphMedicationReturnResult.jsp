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
	<script language="javascript" src="../../ePH/js/SRRMedicationReturn.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<script language="javascript" src="../js/PhCommon.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
<form name="SRRPhMedicationnReturnResult" id="SRRPhMedicationnReturnResult">

<%
	String bean_id				= "SRROnlineReportSet2Bean" ;
	String bean_name			= "ePH.SRROnlineReportSet2Bean";
	SRROnlineReportSet2Bean bean		= (SRROnlineReportSet2Bean)getBeanObject( bean_id,bean_name,request) ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	bean.setLanguageId(locale);
   try{
    


    String patient_id = CommonBean.checkForNull(request.getParameter("patient_id"));
    String p_encounter = CommonBean.checkForNull(request.getParameter("p_encounter"));
   
    String p_locn_type = CommonBean.checkForNull(request.getParameter("p_locn_type"));
    String fr_retndate = CommonBean.checkForNull(request.getParameter("fr_retndate"));
    String to_retndate = CommonBean.checkForNull(request.getParameter("to_retndate"));
    String p_pres_id = CommonBean.checkForNull(request.getParameter("p_pres_id"));
    String p_ret_to_disp_locn_code = CommonBean.checkForNull(request.getParameter("p_ret_to_disp_locn_code"));
    String p_locn_code = CommonBean.checkForNull(request.getParameter("p_locn_code"));
    String p_ret_doc_no = CommonBean.checkForNull(request.getParameter("p_ret_doc_no"));

	String from = CommonBean.checkForNull(request.getParameter("from"));
	String to = CommonBean.checkForNull(request.getParameter("to"));
	/*out.println("p_locn_type===>" +p_locn_type);
	out.println("patient_id===>" +patient_id);8
	out.println("fr_retndate===>" +fr_retndate);
	out.println("to_retndate===>" +to_retndate);
	out.println("p_pres_id===>" +p_pres_id);
	out.println("p_ret_to_disp_locn_code===>" +p_ret_to_disp_locn_code);
	out.println("p_locn_code===>" +p_locn_code);
	out.println("from===>" +from);
	out.println("to===>" +to);*/

	ArrayList result =new ArrayList();


	result=bean.getMedicationReturnVoucherListNursingunit(locale,p_pres_id,patient_id,fr_retndate,to_retndate,p_encounter,p_ret_to_disp_locn_code, p_locn_type,p_locn_code,from,to,p_ret_doc_no,p_facility_id);
		int count =0;
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
			<th  nowrap><fmt:message key="ePH.ReturnDate.label" bundle="${ph_labels}"/></th>
			<th  nowrap><fmt:message key="ePH.ReturnDispenselocation.label" bundle="${ph_labels}"/></th>
			<th  nowrap><fmt:message key="Common.documentno.label" bundle="${common_labels}"/></th>
			<th  nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
			<th  nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
			<th  nowrap><fmt:message key="ePH.PrescriptionID.label" bundle="${ph_labels}"/></th>
			<th  nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
			<th  nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
			</tr>

<%		
		for (int i=0;i<result.size()-9;i=i+9){					
			String classvalue="";
			if ( i % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
			
	%>
		<tr>
		<%	//out.println("Result(8)======>" +result.get(i+8));

			
			
			%>
			<!-- Date Conversion done for (String)result.get(i+8)==25238==By Sandhya -->
			<td class="<%=classvalue%>" style="font-size=9"><%=com.ehis.util.DateUtils.convertDate((String)result.get(i+8),"DMY","en",locale)%></td>
			
			<td class="<%=classvalue%>" style="font-size=9"><font class="hyperlink" style="cursor:pointer" onClick="showPrintReport('<%=result.get(i+1)%>','<%=result.get(i+8)%>','<%=result.get(i+9)%>')"><%=result.get(i+7)%></font></td>
			<td class="<%=classvalue%>" style="font-size=9"><font class="hyperlink" style="cursor:pointer" onClick="showPrintReport('<%=result.get(i+1)%>','<%=result.get(i+8)%>','<%=result.get(i+9)%>')"><%=result.get(i+1)%></font></td>
			<td class="<%=classvalue%>" style="font-size=9"><font class="hyperlink" style="cursor:pointer" onClick="showPrintReport('<%=result.get(i+1)%>','<%=result.get(i+8)%>','<%=result.get(i+9)%>')"><%=result.get(i+2)%></font></td>
			<td class="<%=classvalue%>" style="font-size=9"><%=result.get(i+3)%></td>
			<td class="<%=classvalue%>" style="font-size=9"><%=result.get(i+4)%></td>
			<td class="<%=classvalue%>" style="font-size=9"><%=result.get(i+5)%></td>
			<td class="<%=classvalue%>" style="font-size=9"><%=result.get(i+6)%></td>
		
		</tr>
		
	<%
			count =count+1;
		}
	}else{
	%>
		<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
			parent.frames[2].location.href = "../../eCommon/html/blank.html";
				</script>
	<%
	}%>
		</table>
	
	<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
	<input type="hidden" name="p_pres_id" id="p_pres_id" value="<%=p_pres_id%>">
	<input type="hidden" name="fr_retndate" id="fr_retndate" value="<%=fr_retndate%>">
	<input type="hidden" name="to_retndate" id="to_retndate" value="<%=to_retndate%>">
	<input type="hidden" name="p_encounter" id="p_encounter" value="<%=p_encounter%>">
	<input type="hidden" name="p_ret_to_disp_locn_code" id="p_ret_to_disp_locn_code" value="<%=p_ret_to_disp_locn_code%>">
	<input type="hidden" name="p_locn_type" id="p_locn_type" value="<%=p_locn_type%>">
	<input type="hidden" name="p_locn_code" id="p_locn_code" value="<%=p_locn_code%>">
	<input type="hidden" name="p_ret_doc_no" id="p_ret_doc_no" value="<%=p_ret_doc_no%>">
	<input type="hidden" name="from" id="from" value="<%=from%>">
	<input type="hidden" name="to" id="to" value="<%=to%>">
	<input type="hidden" name="p_report_id" id="p_report_id" value="">
	
	
<%
	
		
 }catch (Exception exception) {
		
		exception.printStackTrace();
	}
	finally{
	}
%>
</form>
<% putObjectInBean(bean_id,bean,request); %>


</body>
</html>




