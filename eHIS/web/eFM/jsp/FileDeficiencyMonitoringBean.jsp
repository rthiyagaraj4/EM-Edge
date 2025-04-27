<!DOCTYPE html>
<%@ page import ="java.util.*,java.sql.*, java.text.*,java.net.*,webbeans.eCommon.*, webbeans.eFM.FileDeficiencyMonitoring" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="recordSetDeficiency" scope="session" class="webbeans.eFM.FileDeficiencyMonitoring"/>
<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eFM/js/FMFileDeficiencyMonitoring.js' language='javascript'></script>

</head>
<body class='message' onKeyDown = 'lockKey()'>
<form name="DeficiencyMonitoring_bean" id="DeficiencyMonitoring_bean">
<%
	String PatientId="";
	String	operation_mode		=	"";
	String  fac_id				=	"";
	String  encounter_id		=	"";
	String	file_no				=	"";
	String	defi_code			=	"";
	String	defi_desc			=	"";
	String	admission_date		=	"";
	String	discharge_date		=	"";
	String	care_locn_code		=	"";
	String	defi_completed_status=	"";
	String	practitioner		=	"";
	String	practitioner_name	=	"";
	String	defi_reported_date	=	"";
	String	defi_status			=	"";
	String	defi_resolved_date	=	"";
	String	defi_remarks		=	"";
	String  item_delete_yn		=	"N";
	String  header_exist		=	"";
	String  patient_class		=	"";
	String  file_type			=	"";
	String  volume_no			=	"";
	String  record_from			=	"",dflt_practitioner="",dflt_practitioner_name="";

	int		row_index			=	0;
	boolean	duplicateExists		=	false;	

	HashMap		htRecord	=	null; 	

	try
	{
		operation_mode	=	(request.getParameter("operation_mode")==null)?	""	: request.getParameter("operation_mode");
       if(operation_mode.equals("")) recordSetDeficiency.clearAll();
		if(operation_mode.equals("ScreenModify"))
		{	
			operation_mode = "Modify";
			record_from = "SCREEN";
		}
		else if(operation_mode.equals("DatabaseModify"))
		{
			operation_mode = "Modify";
			record_from = "DATABASE";
		}
		else if(operation_mode.equals("Add"))
		{
			record_from = "SCREEN";
		}

		if(operation_mode.equals("Add") || operation_mode.equals("Modify"))
		{

			dflt_practitioner =	(request.getParameter("dflt_practitioner")==null) ? "" :										request.getParameter("dflt_practitioner");
			
			dflt_practitioner_name = (request.getParameter("dflt_practitioner_name")==null) ? "" :									request.getParameter("dflt_practitioner_name");
			
			PatientId =	(request.getParameter("PatientId")==null) ?	"" :											request.getParameter("PatientId");
			fac_id = (request.getParameter("fac_id")==null) ? "" : request.getParameter("fac_id");
			
			encounter_id = (request.getParameter("encounter_id")==null) ? "" :											request.getParameter("encounter_id");
			
			file_no = (request.getParameter("file_no")==null) ? "" : request.getParameter("file_no");
			
			defi_code =	(request.getParameter("defi_code")==null) ? "" :											request.getParameter("defi_code");
			
			defi_desc =	(request.getParameter("defi_desc")==null) ? "" :											request.getParameter("defi_desc");
			
			admission_date = (request.getParameter("admission_date")==null) ? "" :											request.getParameter("admission_date");
			
			discharge_date = (request.getParameter("discharge_date")==null) ? "" :											request.getParameter("discharge_date");
			
			care_locn_code = (request.getParameter("care_locn_code")==null) ? "" :											request.getParameter("care_locn_code");
			
			defi_completed_status =	(request.getParameter("defi_completed_status")==null) ?	"" :								request.getParameter("defi_completed_status");
			
			practitioner = (request.getParameter("practitioner")==null) ? "" :											request.getParameter("practitioner");
			
			practitioner_name =	(request.getParameter("practitioner_name")==null) ? "" :									request.getParameter("practitioner_name");
			
			defi_reported_date = (request.getParameter("defi_reported_date")==null) ? "" :										request.getParameter("defi_reported_date");

			defi_status = (request.getParameter("defi_status")==null) ? "" :											request.getParameter("defi_status");
			
			defi_resolved_date = (request.getParameter("defi_resolved_date")==null) ? "" :										request.getParameter("defi_resolved_date");
			
			defi_remarks = (request.getParameter("defi_remarks")==null) ? "" :											request.getParameter("defi_remarks");
			header_exist = (request.getParameter("header_exist")==null) ? "" :											request.getParameter("header_exist");
			
			patient_class = (request.getParameter("patient_class")==null) ? "" :											request.getParameter("patient_class");
			
			file_type =	(request.getParameter("file_type")==null) ? "" :												request.getParameter("file_type");
			
			volume_no =	(request.getParameter("volume_no")==null) ? "" :											request.getParameter("volume_no");

			htRecord	= new HashMap();

			htRecord.put("PatientId",				PatientId);
			htRecord.put("facility_id",				fac_id);
			htRecord.put("encounter_id",			encounter_id);
			htRecord.put("file_no",					file_no);
			htRecord.put("defi_code",				defi_code);
			htRecord.put("defi_desc",				defi_desc);
			htRecord.put("admission_date",			admission_date);
			htRecord.put("discharge_date",			discharge_date);
			htRecord.put("care_locn_code",			care_locn_code);
			htRecord.put("defi_completed_status",	defi_completed_status);
			htRecord.put("practitioner",			practitioner);
			htRecord.put("practitioner_name",		practitioner_name);
			htRecord.put("defi_reported_date",		defi_reported_date);
			htRecord.put("defi_status",				defi_status);
			htRecord.put("defi_resolved_date",		defi_resolved_date);
			htRecord.put("defi_remarks",			defi_remarks);
			htRecord.put("item_delete_yn",			item_delete_yn);
			htRecord.put("header_exist",			header_exist);
			htRecord.put("patient_class",			patient_class);
			htRecord.put("file_type",				file_type);
			htRecord.put("volume_no",				volume_no);
         	if(record_from.equals("SCREEN"))
			{
				htRecord.put("operation_mode",	"Add");
			}
			else
			{
				htRecord.put("operation_mode",	"Modify");
			}

			htRecord.put("record_from",	record_from);
			
			if(operation_mode.equals("Add"))
			{
				duplicateExists	=	recordSetDeficiency.isDetailAddDuplicateExists(htRecord);
			}
			
			if(duplicateExists)
			{
				%>
				<script language='javascript'>
					var errors = getMessage('DEFICIENCY_EXIST','FM');	
					parent.frames[5].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors; 
					parent.frames[4].document.forms[0].deficiency.focus();
				</script>
				<%
			}
			else
			{
				if( operation_mode.equals("Add"))
				{
					recordSetDeficiency.putObject(htRecord);
				 }
				else if(operation_mode.equals("Modify"))
				{
				row_index = Integer.parseInt(request.getParameter("record_num"));
				 if(recordSetDeficiency.isDetailAddDuplicateExists(htRecord))
				{
				 recordSetDeficiency.setObject(row_index,htRecord);
				 }
				}
				%>
				<script language='javascript'>
				
					parent.frames[3].location.href = "../../eFM/jsp/FMFileDeficiencyMonitoringDetails.jsp?PatientId=<%=PatientId%>"; 
					parent.frames[4].document.forms[0].operation_mode.value="Add";
					parent.frames[4].document.forms[0].deficiency.disabled = false;
					parent.frames[4].document.forms[0].physician.disabled = false;
					parent.frames[4].document.forms[0].date_reported.disabled = false;
					parent.frames[4].document.forms[0].date_resolved.disabled = true;
					parent.frames[4].document.forms[0].remarks.disabled = false;
					parent.frames[4].document.forms[0].add.disabled = false;
					parent.frames[4].document.forms[0].deficiency.value = "";
					parent.frames[4].document.forms[0].physician.value = "<%=dflt_practitioner%>";
					parent.frames[4].document.forms[0].physician1.value = "<%=dflt_practitioner_name%>";
					parent.frames[4].document.forms[0].date_reported.value = "";
					parent.frames[4].document.forms[0].date_resolved.value = "";
					parent.frames[4].document.forms[0].remarks.value = "";
					parent.frames[4].document.forms[0].defy_status(0).checked = true;
					parent.frames[4].document.forms[0].defy_status(1).checked = false;
					parent.frames[4].document.forms[0].defy_status(2).checked = false;
					parent.frames[4].document.forms[0].defy_status(1).disabled = true;
					parent.frames[4].document.forms[0].defy_status(2).disabled = true;
					parent.frames[4].document.forms[0].operation_mode.value = "Add";
				    </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

				<%
			}
		}
	}
	catch(Exception e)
	{
		out.println("Exception@1: "+e);
	}
%>
</form>
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

