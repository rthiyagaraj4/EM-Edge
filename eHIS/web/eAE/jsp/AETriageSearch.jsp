<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
  <script language='javascript' src='../../eAE/js/AETriageDetails.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
        request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		
		String patient_id			 = request.getParameter("patient_id");

			   patient_id			 = (patient_id == null)?"":patient_id;
		String clinic_code			 = request.getParameter("clinic_code");
			   clinic_code			 = (clinic_code == null)?"":clinic_code;
		String clinic_type			 = request.getParameter("clinic_type");
			   clinic_type			 = (clinic_type == null)?"":clinic_type;
		String clinic_desc			 = request.getParameter("clinic_desc");
		if(clinic_desc==null || clinic_desc.equals("") || clinic_desc=="")
				clinic_desc			 = "";
	    String treatment_area_code	 = request.getParameter("treatment_area_code");
			   treatment_area_code	 = (treatment_area_code == null)?"":treatment_area_code;
	    String treatment_area_desc	 = request.getParameter("treatment_area_desc");
			   treatment_area_desc	 = (treatment_area_desc == null)?"":treatment_area_desc;

		String encounter_id			 = request.getParameter("encounter_id");
			   encounter_id			 = (encounter_id == null)?"":encounter_id;
		String queue_status			 = request.getParameter("queue_status");
			   queue_status			 = (queue_status == null)?"":queue_status;
		String orig_tmt_area_code			= request.getParameter("orig_tmt_area_code");
		if(orig_tmt_area_code==null || orig_tmt_area_code.equals("") || orig_tmt_area_code=="")
				orig_tmt_area_code			= "";
%>
	 <body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	 <form name="ae_triage_search_form" id="ae_triage_search_form" >
	   <table border="0" cellpadding="1" cellspacing="0" align='center' width='100%'>
  		  <tr>
		      <td class='BODYCOLORFILLED' width='19%'>&nbsp;</td>
		      <td class='BODYCOLORFILLED' align='left' width='81%'>&nbsp;
			    <input type="button" class=button name='triage' id='triage' value='Triage Details' title='Triage Details' onClick='callFunction(this);'>
			    <input type="button" class=button name='ae_details' id='ae_details' value='A&E Details' title='A&E Details' onClick='callFunction(this);'>
			  </td>
			</tr>
	 </table>
          <input type='hidden' name='clinic_code' id='clinic_code' value='<%=clinic_code%>'>
   		  <input type='hidden' name='clinic_type' id='clinic_type' value='<%=clinic_type%>'>
   		  <input type='hidden' name='clinic_desc' id='clinic_desc' value='<%=clinic_desc%>'>
		  
   		  <input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>
   		  <input type='hidden' name='encounter_id' id='encounter_id' value='<%=encounter_id%>'>
		  <input type='hidden' name='treatment_area_code' id='treatment_area_code' value='<%=treatment_area_code%>'>
		  <input type='hidden' name='queue_status' id='queue_status' value='<%=queue_status%>'>
		  <input type='hidden' name='treatment_area_desc' id='treatment_area_desc' value='<%=treatment_area_desc%>'>
		   <input type='hidden' name='orig_tmt_area_code' id='orig_tmt_area_code' value='<%=orig_tmt_area_code%>'>
		  <input type='hidden' name='queryString' id='queryString' value='<%=request.getQueryString()%>'>
	 </form>
	 </body>
</html>

