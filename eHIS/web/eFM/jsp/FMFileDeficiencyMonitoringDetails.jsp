<!DOCTYPE html>
<%@ page import ="java.util.*,java.sql.*, java.text.*,webbeans.eCommon.*, webbeans.eFM.FileDeficiencyMonitoring" contentType="text/html; charset=UTF-8" %>
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
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eFM/js/FMFileDeficiencyMonitoring.js' ></script>
	<script language="javascript" src="../../eCommon/js/rowcolor.js" ></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%	
	//String EncounterId	= request.getParameter("EncounterId");	
	//String Admndate		= request.getParameter("Admndate");	
	//String Discdate		= request.getParameter("Discdate");	
	//String Carelocn		= request.getParameter("Carelocn");
	
	String PatientId	= request.getParameter("PatientId");
	String Found		= request.getParameter("Found");
  
   
   Object row_count1 = session.getAttribute("row_count");
	if(row_count1==null)  row_count1="";
	String  fac_id					=	"";
	String  encounter_id			=	"";
	String	file_no					=	"";
	String	file_type				=	"";
	String	volume_no				=	"";
	String	patient_class			=	"";
	String	defi_code				=	"";
	String	defi_desc				=	"";
	String	admission_date			=	"";
	String	discharge_date			=	"";
	String	care_locn_code			=	"";
	String	defi_completed_status	=	"";
	String	practitioner			=	"";
	String	practitioner_name		=	"";
	String	defi_reported_date		=	"";
	String	defi_status				=	"";
	String	defi_resolved_date		=	"";
	String	defi_remarks			=	"";
	//String  item_delete_yn			=	"";
	String  defi_status_desc		=	"";  
	String	operation_mode			=	"";
	String	record_from				=	"";
	 int cnt=0;
	boolean Status_flag	= false;
%>
<body OnMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
<form name='FileDeficiencyMonitoring_detail' id='FileDeficiencyMonitoring_detail'>
	<table id='tb1' border="1" cellpadding="0" cellspacing="0" width='100%' align="CENTER">

<%
		//String facility_id	= (String) session.getValue("facility_id");

		String classValue		= "";
		String checkboxval		= "";
		String checkboxstate	= "";
		String compStat			= "&nbsp;Closed";
		//String compStatId		= "C";

		int rowid		= 1;
		int row_count	= 0;

		HashMap	htRecord	= null; 

		try
		{
			out.println("<tr><td width='14%' class='columnheader'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.type.label","common_labels")+"</td>");
			out.println("<td width='15%' class='columnheader'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.DateReported.label","fm_labels")+"</td>");
			out.println("<td width='19%' class='columnheader'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.PractitionerResponsible.label","fm_labels")+"</td>");
			out.println("<td width='8%' class='columnheader'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels")+"</td>");
			out.println("<td width='15%' class='columnheader'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.DateResolvedCancelled.label","fm_labels")+"</td>");
			out.println("<td width='25%' class='columnheader'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels")+"</td>");
			out.println("<td width='4%' class='columnheader'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"?</td></tr>");

			row_count	=recordSetDeficiency.getSize();
			
			for(int i=0; i<row_count; i++)
			{
				classValue	=	((i%2)==0 ) ? "QRYEVEN" : "QRYODD";

				htRecord	=	(HashMap) recordSetDeficiency.getObject(i);

				fac_id					=	(String)	htRecord.get("facility_id");
				encounter_id			=	(String)	htRecord.get("encounter_id");
				file_no					=	(String)	htRecord.get("file_no");
				file_type				=	(String)	htRecord.get("file_type");
				volume_no				=	(String)	htRecord.get("volume_no");
				patient_class			=	(String)	htRecord.get("patient_class");
				defi_code				=	(String)	htRecord.get("defi_code");
				defi_desc				=	(String)	htRecord.get("defi_desc");
				admission_date			=	(String)	htRecord.get("admission_date");
				discharge_date			=	(String)	htRecord.get("discharge_date");
				care_locn_code			=	(String)	htRecord.get("care_locn_code");
				defi_completed_status	=	(String)	htRecord.get("defi_completed_status");
				practitioner			=	(String)	htRecord.get("practitioner");
				practitioner_name		=	(String)	htRecord.get("practitioner_name");
				defi_reported_date		=	(String)	htRecord.get("defi_reported_date");
				defi_status				=	(String)	htRecord.get("defi_status");
				defi_resolved_date		=	(String)	htRecord.get("defi_resolved_date");
				defi_remarks			=	(String)	htRecord.get("defi_remarks");
				//item_delete_yn			=	(String)	htRecord.get("item_delete_yn");
				operation_mode			=	(String)	htRecord.get("operation_mode");
				record_from				=	(String)	htRecord.get("record_from");
				//String header_exist		=	(String)	htRecord.get("header_exist");
				/*if(defi_reported_date != null)
				{
					defi_reported_date=DateUtils.convertDate(defi_reported_date,"DMYHM","en",localeName);
				}
				else
					defi_reported_date="";

				if(defi_resolved_date != null)
				{
					defi_resolved_date=DateUtils.convertDate(defi_resolved_date,"DMYHM","en",localeName);
				}
				else
					defi_reported_date="";*/
				
				if(defi_resolved_date == null || defi_resolved_date.equals("null"))
				{
					defi_resolved_date = "";
				}
				if(defi_status.equals("O"))
				{
					defi_status_desc	= "Open";
					compStat			= "&nbsp;Open";
					//compStatId			= "O";
					checkboxval			= "Checked";
					checkboxstate		= "";
					Status_flag	= true;
				}
				else if(defi_status.equals("C"))
				{
					defi_status_desc	= "Closed";
					checkboxval			= "Checked";
					if(record_from.equals("DATABASE"))
					{
						checkboxstate = "Disabled";
					}
				}
				else if(defi_status.equals("X"))
				{
					defi_status_desc	= "Cancelled";
					compStat			= "&nbsp;Closed";
					checkboxval			= "Checked";
					if(record_from.equals("DATABASE"))
					{
						checkboxstate = "Disabled";
					}
				}
				if(operation_mode.equals("Modify") && record_from.equals("DATABASE"))
				{
					checkboxval		= "Checked";
					checkboxstate	= "Disabled";
				}

				out.println("<tr><td class='"+classValue+"'><font size='1'>");

				if(record_from.equals("DATABASE") && (defi_status.equals("C")||defi_status.equals("X")))
				{	
					out.println(defi_desc);		
				}
				else
				{
					%>
					<a name="<%=rowid%>" id="<%=rowid%>" onClick='changeRowColor(this,7)'	href='javascript:OnDefMonitorDtlsSelection("<%=i%>","<%=record_from%>","<%=compStat%>","<%=fac_id%>","<%=encounter_id%>","<%=file_no%>","<%=file_type%>","<%=volume_no%>","<%=patient_class%>","<%=defi_code%>","<%=java.net.URLEncoder.encode(defi_desc)%>","<%=admission_date%>","<%=discharge_date%>","<%=care_locn_code%>","<%=defi_completed_status%>","<%=practitioner%>","<%=practitioner_name%>","<%=defi_reported_date%>","<%=defi_status%>","<%=defi_resolved_date%>","<%=defi_remarks%>","<%=Found%>","<%=PatientId%>")'>
					<%
					out.println(defi_desc);
				}

				out.println("</a></font></td><td class='"+classValue+"'><font size='1'>");
				out.println(defi_reported_date);
				out.println("</font></td><td class='"+classValue+"'><font size='1'>");
				out.println(practitioner_name);
				out.println("</font></td><td class='"+classValue+"'><font size='1'>");
				out.println(defi_status_desc);
				out.println("</font></td><td class='"+classValue+"'><font size='1'>");

				if(!defi_resolved_date.equals(""))
					out.println(defi_resolved_date);
				else
					out.println("&nbsp;");

				out.println("</font></td><td class='"+classValue+"'><font size='1'>");

				if(defi_remarks.equals(""))
				{
					out.println("&nbsp;");
				}
				else
				{
					out.println(defi_remarks);
				}
				out.println("</font></td><td align='center' class='"+classValue+"'><font size='1'>");
           				
				if(record_from.equals("SCREEN"))
				{
					cnt++;
					out.println("<input type='checkbox' name='select"+i+"' id='select"+i+"' "+checkboxval+" "+checkboxstate+" onClick='Remove("+i+");'>");
				}
				else
				{
					
					out.println("&nbsp;");
				}
				
				out.println("</font></td></tr>");
				out.println("<script>");
				out.println("parent.frames[2].document.getElementById('completed_status').innerHTML=\"<b>"+compStat+"\"");
	
				out.println("</script>");

				rowid++;
			} // end of for

			if(row_count!=0)
			{
			htRecord.put ("Status_flag",	Status_flag);
			}
			

			%>
			<input type='hidden' name='defi_code' id='defi_code' value='<%=defi_code%>'>
			<input type='hidden' name='row_count_up' id='row_count_up' value='<%=row_count%>'>
			<input type='hidden' name='Status_flag' id='Status_flag' value='<%=Status_flag%>'>
			<input type='hidden' name='row_count1' id='row_count1' value='<%=row_count1%>'>
			<input type='hidden' name='cnt' id='cnt' value='<%=cnt%>'>
			<input type='hidden' name='flagclick' id='flagclick' value=''>
				<%
		}
		catch(Exception e)
		{
			out.println("Exception e :"+e);
		}
	%>
	</table>
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

