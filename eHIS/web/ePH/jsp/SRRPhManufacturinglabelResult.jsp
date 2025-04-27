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
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
		String locale			= (String)session.getAttribute("LOCALE");


String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../ePH/js/SRRPhManufacturinglabel.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<script language="javascript" src="../js/PhCommon.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
<form name="SRRPhManufacturinglabelResult" id="SRRPhManufacturinglabelResult">

<%
   try{
    String bean_id				= "SRROnlineReportSet2Bean" ;
	String bean_name			= "ePH.SRROnlineReportSet2Bean";
	SRROnlineReportSet2Bean bean		= (SRROnlineReportSet2Bean)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(locale);
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
    //String locale = request.getParameter("locale");
    String patient_id = CommonBean.checkForNull(request.getParameter("patient_id"));
    String p_wrksheet_id = CommonBean.checkForNull(request.getParameter("p_wrksheet_id"));
    String p_pres_id = CommonBean.checkForNull(request.getParameter("p_pres_id"));
    String fr_dispdate = CommonBean.checkForNull(request.getParameter("fr_dispdate"));
    String to_dispdate = CommonBean.checkForNull(request.getParameter("to_dispdate"));
    String p_encounter = CommonBean.checkForNull(request.getParameter("p_encounter"));
    String p_pract_id = CommonBean.checkForNull(request.getParameter("p_pract_id"));
    String p_disp_locn = CommonBean.checkForNull(request.getParameter("p_disp_locn"));
    String p_tokfr = CommonBean.checkForNull(request.getParameter("p_tokfr"));
    String p_tokto = CommonBean.checkForNull(request.getParameter("p_tokto"));
    String p_locn_type = CommonBean.checkForNull(request.getParameter("p_locn_type"));
    String p_locn_code = CommonBean.checkForNull(request.getParameter("p_locn_code"));
    String p_type_ord = CommonBean.checkForNull(request.getParameter("p_type_ord"));

	String from = CommonBean.checkForNull(request.getParameter("from"));
	String to = CommonBean.checkForNull(request.getParameter("to"));
	
	ArrayList result =new ArrayList();
	result=bean.getWorksheetList( locale, p_wrksheet_id,  p_pres_id, patient_id, fr_dispdate, to_dispdate, p_encounter, p_pract_id, p_disp_locn, p_locn_type, p_locn_code, from, to, p_tokto, p_tokfr, p_facility_id, p_type_ord);
		

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
			<th  nowrap><fmt:message key="ePH.TokenNo./DailySeqNo.label" bundle="${ph_labels}"/></th>
			<th  nowrap><fmt:message key="ePH.WorksheetID.label" bundle="${ph_labels}"/></th>
			<th  nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
			<th  nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
			<th  nowrap><fmt:message key="ePH.PrescriptionID.label" bundle="${ph_labels}"/></th  >
			<th  nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
			<th  nowrap><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></th>

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
		
		//record[0]=com.ehis.util.DateUtils.convertDate(record[0],"DMY","en",locale);
	%>
		<tr>
<%
					String tokn ="";
			if(record[3]==null){
				tokn ="";

				}

				if(record[4]!= null && record[3]!= null  )
				{
					tokn = tokn+ "/"+ record[4];
				}

				if(record[4]!= null && record[3]== null  )
				{
					tokn =  record[4];
				}
	%>

			<td class="<%=classvalue%>" style="font-size=9"><font class="hyperlink" style="cursor:pointer" onClick="showPrintReport('<%=record[0]%>','<%=p_type_ord%>','<%=locale%>')"><%=record[1]%></font></td>
			<td class="<%=classvalue%>" style="font-size=9"><font class="hyperlink" style="cursor:pointer" onClick="showPrintReport('<%=record[0]%>','<%=p_type_ord%>','<%=locale%>')">&nbsp;<%=tokn%></font></td>
			<td class="<%=classvalue%>" style="font-size=9"><%=record[0]%></td>
			<td class="<%=classvalue%>" style="font-size=9"><%=record[5]%></td>
			<td class="<%=classvalue%>" style="font-size=9"><%=record[7]%></td>
			<td class="<%=classvalue%>" style="font-size=9"><%=record[9]%></td>			
			<td class="<%=classvalue%>" style="font-size=9"><%=record[6]%></td>			
			<td class="<%=classvalue%>" style="font-size=9"><%=record[8]%></td>			
			
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
	<input type="hidden" name="p_wrksheet_id" id="p_wrksheet_id" value="">
	<input type="hidden" name="p_pres_id" id="p_pres_id" value="">
	<input type="hidden" name="fr_dispdate" id="fr_dispdate" value="">
	<input type="hidden" name="to_dispdate" id="to_dispdate" value="">
	<input type="hidden" name="p_encounter" id="p_encounter" value="">
	<input type="hidden" name="p_pract_id" id="p_pract_id" value="">
	<input type="hidden" name="p_facility_id" id="p_facility_id" value="">
	<input type="hidden" name="p_disp_locn" id="p_disp_locn" value="">
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



