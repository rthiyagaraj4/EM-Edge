<%@ page contentType="text/html;charset=UTF-8" import ="com.ehis.util.*,java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  

<!-- This file created by Jeyachitra for ML-MMOH-CRF 1742 -->

<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	%> 
<%
	Connection con = null;
	PreparedStatement pstmt=null;															
	ResultSet rs=null;
	PreparedStatement pstmt2=null;															
	ResultSet rs2=null;
	PreparedStatement pstmt3=null;															
	ResultSet rs3=null;
	
	String locale = (String)session.getAttribute("LOCALE"); 
	String login_user = (String)session.getAttribute("login_user"); 
	String patient_id = checkForNull(request.getParameter("patient_id"));
	String term_set_id = checkForNull(request.getParameter("term_set_id"));
	String term_code = checkForNull(request.getParameter("term_code"));
	String facility_id = checkForNull(request.getParameter("facility_id"));
	String encounter_id = checkForNull(request.getParameter("encounter_id"));
	String occur_srl_no = checkForNull(request.getParameter("occur_srl_no"));
	String attr_updated = "";
	String attr_disp_name = "";
	String cur_attr_val = 	"";				
	String prev_attr_val = "";
	String modified_date = "";
	String modified_by_Id = "";


try{
%>
<html>
<%	
	String sStyle =  (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<head>

	<title> <fmt:message key="Common.AuditTrail.label" bundle="${common_labels}"/></title>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel="stylesheet" type="text/css             " href="../../eCommon/html/CommonCalendar.css">
	<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script src='../../eCommon/js/common.js' language='javascript'></SCRIPT>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
	<script src="../../eCommon/js/CommonCalendar.js" language='javascript'></script>
	<script src='../js/RecDiagnosis.js' language='javascript'></script>
	<script src='../js/RecDiagnosisMain.js' language='javascript'></script>
	<script src='../../eCommon/js/dchk.js'  language='javascript'></script>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>		
	
</head>

<body>
		<table align='center' cellpadding='3' cellspacing='0' border='1' width='100%' style="border-collapse: collapse;">
		  
		  <tr></tr>
		  
		  <tr><td colspan='5' class='COLUMNHEADER'><fmt:message key="eMR.AuditTrialTitle.label" bundle="${mr_labels}"/>:&nbsp;<%=term_code %></td></tr>

		  <tr></tr>
		  
		  <tr>
		  <th align='center' style='cursor:pointer' nowrap class='CAGROUPHEADING'><fmt:message key="eMR.AuditTrialAttrUpdated.label" bundle="${mr_labels}"/> </th>
		  <th align='center' style='cursor:pointer' nowrap class='CAGROUPHEADING'> <fmt:message key="eMR.AuditTrialCurrVal.label" bundle="${mr_labels}"/> </th>
		  <th align='center' style='cursor:pointer' nowrap class='CAGROUPHEADING'> <fmt:message key="eMR.AuditTrialPrevVal.label" bundle="${mr_labels}"/> </th>
		  <th align='center' style='cursor:pointer' nowrap class='CAGROUPHEADING'> <fmt:message key="eMR.AuditTrialModDate.label" bundle="${mr_labels}"/> </th>
		  <th align='center' style='cursor:pointer' nowrap class='CAGROUPHEADING'> <fmt:message key="eMR.AuditTriallModBy.label" bundle="${mr_labels}"/> </th>
		  </tr>
		  
			<%
			String getDesc_curr = "", getDesc_prev="";
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement("select attr_updated, cur_attr_value, prev_attr_value, to_char(added_date,'dd/mm/yyyy hh24:mi:ss') added_date_odr, to_char(added_date,'dd/mm/yyyy hh24:mi') added_date, added_by_id from mr_rec_diag_audit_trial where patient_id=? and term_Set_id=? and encounter_id=? and term_code=? and occur_srl_no=? and facility_id=? order by added_date_odr desc");
			pstmt.setString(1, patient_id);
			pstmt.setString(2, term_set_id);
			pstmt.setString(3, encounter_id);
			pstmt.setString(4, term_code);
			pstmt.setString(5, occur_srl_no);
			pstmt.setString(6, facility_id);
			rs= pstmt.executeQuery();
			if(rs!= null)
			{
				while(rs.next())
				{
					attr_updated = checkForNull(rs.getString("attr_updated"));
					cur_attr_val = checkForNull(rs.getString("cur_attr_value"));
					prev_attr_val = checkForNull(rs.getString("prev_attr_value"));
					modified_date = checkForNull(rs.getString("added_date"));
					modified_by_Id = checkForNull(rs.getString("added_by_id"));
					
					if ((attr_updated.equalsIgnoreCase("Diagnosis_Classification")) || (attr_updated.equalsIgnoreCase("Accuracy"))) 
					{
					    HashMap<String, String> prev_curr_value = new HashMap<String, String>();
					    prev_curr_value.put("cur_attr_val", cur_attr_val);
					    prev_curr_value.put("prev_attr_val", prev_attr_val);

					    for (Map.Entry<String, String> e : prev_curr_value.entrySet()) {
					        if (attr_updated.equalsIgnoreCase("Diagnosis_Classification")) {
					            pstmt2 = con.prepareStatement("SELECT mr_get_desc.mr_diag_class(diag_class_code, ?, '2') short_desc FROM mr_diag_class WHERE diag_class_code = ?");
					        } else if (attr_updated.equalsIgnoreCase("Accuracy")) {
					            pstmt2 = con.prepareStatement("SELECT short_desc FROM mr_accuracy_lang_vw WHERE language_id = ? AND accuracy_code = ?");
					        }

					        pstmt2.setString(1, locale);
					        pstmt2.setString(2, e.getValue());
					        rs2 = pstmt2.executeQuery();

					        if (rs2 != null && rs2.next()) {
					            if (e.getKey().equals("cur_attr_val")) {
					                cur_attr_val = rs2.getString("short_desc");
					            } else if (e.getKey().equals("prev_attr_val")) {
					                prev_attr_val = rs2.getString("short_desc");
					            }
					        }
					    }
					}

					attr_disp_name = attr_updated;
					
					if (attr_updated.equalsIgnoreCase("Encounter_Stage")) {
						attr_disp_name = "Encounter Stages";
					}else if (attr_updated.equalsIgnoreCase("Diagnosis_Classification")) {
						attr_disp_name = "Diagnosis Classification";
					}else if (attr_updated.equalsIgnoreCase("As_On_Date")) {
						attr_disp_name = "As on";
					}else if (attr_updated.equalsIgnoreCase("Onset_Date")) {
						attr_disp_name = "Onset Date";
					}else if (attr_updated.equalsIgnoreCase("Diagnosis_Remarks")) {
						attr_disp_name = "Diagnosis Remarks";
					}else if(attr_updated.equalsIgnoreCase("Chief_Complaint")) {
						attr_disp_name = "Chief Complaint";
					}
					
					out.println("<tr><td nowrap>"+attr_disp_name+"</td>");
	              	out.println("<td style='word-wrap: break-word;width:300px;' class='audit-row curr_attr' data-attr-updated='" + attr_updated + "' data-attr-val='" + cur_attr_val + "' data-attr-name='c'>&nbsp;</td>");
	                out.println("<td style='word-wrap: break-word;width:300px;' class='audit-row prev_attr' data-attr-updated='" + attr_updated + "' data-attr-val='" + prev_attr_val + "' data-attr-name='p'>&nbsp;</td>");
					out.println("<td nowrap>"+modified_date+"</td>");
					out.println("<td nowrap>"+modified_by_Id+"</td></tr>");					
				}
			}
			
			
			%>
		</table>
		
		<br>

		<center><input type=button name="Close" id="Close" class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onclick="window.close();"></center>

		<br>
</body>

</html>
<%
}catch ( Exception e ) 
{
	e.printStackTrace() ;
}
finally 
{
	try
	{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(rs2!=null) rs2.close();
		if(pstmt2!=null) pstmt2.close();
		if(con!=null) 
			ConnectionManager.returnConnection(con,request);
	   }
	catch(Exception es)
	{
		es.printStackTrace();
	}
}
%>

<%!
	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}	
	
%>
<script>

function getDescriptionForAttrUpdated(attr_name, value)
{	
	var returnValue ="";
	if(attr_name!=null)
	{
		if(attr_name==("Nature"))
		{
			if(value==("A"))
				returnValue = getLabel('Common.Actual.label','Common');
			else if(value==("P"))
				returnValue = getLabel("Common.Potential.label","Common");
			else if(value==("W"))
				returnValue = getLabel("Common.Wellness.label","Common");
		}
		else if(attr_name==("Severity"))
		{
			if(value==("D"))
				returnValue = getLabel("Common.Moderate.label","Common");
			else if(value==("L"))
				returnValue = getLabel("Common.Mild.label","Common");
			else if(value==("S"))
				returnValue = getLabel("Common.Severe.label","Common");
			else if(value==("E"))
				returnValue = getLabel("Common.Extreme.label","Common");
		}
		else if(attr_name==("Priority"))
		{
			if(value==("C")) value = getLabel("Common.Critical.label","Common");
			else if(value==("H")) value = getLabel("Common.High.label","Common");
			else if(value==("N")) value = getLabel('Common.Normal.label','Common');

		}
		else if(attr_name==("Encounter_Stage"))
		{
			if(value==("A"))
				returnValue = getLabel("Common.admission.label","Common");
			else if(value==("I"))
				returnValue = getLabel("Common.Intermediate.label","Common");
			else if(value==("D"))
				returnValue = getLabel("Common.Discharge.label","Common");	
		}
		else if(attr_name==("Status"))
		{
			if(value==("A"))
				returnValue = getLabel("Common.active.label","Common");
			else if(value==("R"))
				returnValue = getLabel("Common.Resolved.label","Common");
			else if(value==("X"))
				returnValue = getLabel("Common.Revoked.label","Common");
			else if(value==("E"))
				returnValue = getLabel("Common.InError.label","Common");
		}		
	}	
	
	return returnValue != "" ? returnValue : value;
	
}	

$(document).ready(function() {
	 
	$('td.audit-row').each(function() {	
		var attrUpdated = $(this).data('attr-updated');
		var attrVal = $(this).data('attr-val');
		var attrName = $(this).data('attr-name');
		
		var updatedValue = getDescriptionForAttrUpdated(attrUpdated, attrVal);

		if(attrName == 'c')
			$(this).html(updatedValue);
			
		else if (attrName == 'p')
			$(this).html(updatedValue);
			
	});
});

</script>

