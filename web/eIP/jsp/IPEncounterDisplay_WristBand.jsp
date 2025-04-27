<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import="java.sql.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>  
<script language='javascript' src='../../eCommon/js/common.js'></script>
 
<%
	Connection con = null;
	Statement stmt=null;
	ResultSet rs =null;

	try
	{
	con  =  ConnectionManager.getConnection(request);
	stmt=con.createStatement();
	String patient_id = checkForNull(request.getParameter("patient_id"));
	String encounter_id =checkForNull(request.getParameter("enc_id"));
	String flag =checkForNull(request.getParameter("flag"));
	String facilityId 	= (String) session.getValue( "facility_id" ) ;
	String locale=(String)session.getAttribute("LOCALE");
	String sql1="";
	Boolean proceed=true;
	String care_locn_type="";
	String care_locn_code="";
	int count=0;	
		if(flag.equals("encounter_details"))
		{
			if(patient_id.equals(""))
			{
				sql1="select patient_id,assign_care_locn_type,assign_care_locn_code from pr_encounter where facility_id='"+facilityId+"'and encounter_id='"+encounter_id+"'";
			}
			else if(!patient_id.equals(""))
			{
				sql1="select patient_id,assign_care_locn_type,assign_care_locn_code,encounter_id from pr_encounter where facility_id='"+facilityId+"' and patient_id ='"+patient_id+"' and encounter_id='"+encounter_id+"'";
			}
			rs=stmt.executeQuery(sql1);
			if (rs!=null){
				while(rs.next())
				{
					count=count+1;
					care_locn_type=rs.getString("assign_care_locn_type");
					care_locn_code=rs.getString("assign_care_locn_code");
					patient_id=rs.getString("patient_id");
				}
			}
			if(count==0)
			{
				proceed=false;
				%>
			<script>
				var errors = getMessage('INVALID_ENCOUNTER_ID','IP');
				alert(errors);				
				parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
				parent.frames[1].document.forms[0].encounter_id.value="";
				parent.frames[1].document.forms[0].encounter_id.focus();
				parent.frames[2].location.href='../../eCommon/html/blank.html';
			</script>
         <% }
			else
			{%>
				<script>
					parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
					//parent.frames[2].location.href='../../eIP/jsp/IPPrintPatientWristbandResult.jsp?patient_id=<%=patient_id%>&encounter_id=<%=encounter_id%>';
					var sql="select report_id, report_desc, 1 no_of_copies, module_id from sm_report_lang_vw where module_id = 'IP' AND REPORT_ID in('IPBWBLBW','IPBWBLBB','IPBWBLBR') and language_id = '<%=locale%>'";
					var reportParamNames="p_facility_id,p_module_id,p_encounter_id,p_patient_id";
					var reportParamValues="<%=facilityId%>,IP,<%=encounter_id%>,<%=patient_id%>";
					var getUrl			= "../../eCommon/jsp/InternalReportsPrint.jsp?rep_id=IPBWBLBW&step=1&sqlString="+sql+ "&reportParamNames="+reportParamNames+"&reportParamValues=" + reportParamValues + "&Patient_ID=<%=patient_id%>&encounter_id=<%=encounter_id%>&dest_locn_type=<%=care_locn_type%>&dest_locn_code=<%=care_locn_code%>";
					parent.frames[2].location.href=getUrl;
				</script>
			<%}

		if(rs!=null) rs.close();
		}

		if(proceed && !flag.equals("encounter_details"))
		{

	String sql = "SELECT AM_GET_DESC.AM_PATIENT_CLASS(patient_class,'"+locale+"','2') PATIENT_CLASS_DESC, encounter_id,  TO_CHAR(visit_adm_date_time, 'dd/mm/yyyy hh24:mi') visit_adm_date_time,  TO_CHAR(discharge_date_time, 'dd/mm/yyyy hh24:mi') discharge_date_time, am_get_desc.am_practitioner(attend_practitioner_id,'"+locale+"','1') practitioner_name, assign_care_locn_type,DECODE (assign_care_locn_type,'N', ip_get_desc.IP_NURSING_UNIT(facility_id,assign_care_locn_code,'"+locale+"','2'),op_get_desc.OP_CLINIC(facility_id,assign_care_locn_code,'"+locale+"','2')) locn_desc,assign_care_locn_code,AM_GET_DESC.AM_CARE_LOCN_TYPE(assign_care_locn_type,'"+locale+"','2') ASSIGN_CARE_LOCN_TYPE_DESC FROM pr_encounter  WHERE facility_id ='"+facilityId+"' AND patient_id ='"+patient_id+"'  ORDER BY visit_adm_date_time DESC";	
    rs=stmt.executeQuery(sql);
%>

<html>	
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
request.setCharacterEncoding("UTF-8"); %>
<HEAD>
<TITLE></TITLE>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	function sendtomain(encid){
			parent.window.returnValue=encid;
			parent.window.close();       
			}
</script>
</HEAD>

<BODY onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<br>
<br>
<form name="RepMovementHistForm" id="RepMovementHistForm" >
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<tr>
<th><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.AdmissionDateTime.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.dischargedatetime.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
</tr>
<%	int i = 0;
    String classValue="";
	String locn_type="";
	String locn_type_desc="";
	String locn_code="";
	if (rs!=null){
		while(rs.next())
		{
		 i = i +1;
			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;	
			locn_type=rs.getString(6)==null?"":rs.getString(6);
			locn_code=rs.getString("assign_care_locn_code")==null?"":rs.getString("assign_care_locn_code");
			locn_type_desc=rs.getString("ASSIGN_CARE_LOCN_TYPE_DESC")==null?"":rs.getString("ASSIGN_CARE_LOCN_TYPE_DESC");
		out.println("<tr><td class='" + classValue + "'>&nbsp;"+(rs.getString(1)==null?"":rs.getString(1))+"</td>");	
	    out.println("<td class='"+classValue+"'><a href=\"javascript:sendtomain('"+rs.getString(2)+"~"+locn_type+"~"+locn_code+"')\">&nbsp;"+(rs.getString(2)==null?"":rs.getString(2))+"</a></td>");
		out.println("<td class='" + classValue + "'>&nbsp;"+(rs.getString(3)==null?"":rs.getString(3))+"</td>");
		out.println("<td class='" + classValue + "'>&nbsp;"+(rs.getString(4)==null?"":rs.getString(4))+"</td>");
		out.println("<td class='" + classValue + "'>&nbsp;"+(rs.getString(5)==null?"":rs.getString(5))+"</td>");
		out.println("<td class='" + classValue + "'>&nbsp;"+locn_type_desc+"</td>");
		out.println("<td class='" + classValue + "'>&nbsp;"+(rs.getString(7)==null?"":rs.getString(7))+"</td></tr>");
		}		
}%>
</table>
<br>
<table border="0" width="100%" cellspacing='0' cellpadding='0'>
<tr>
	<td class='button'  colspan='5'>
		<input type='button' class='BUTTON' name='close' id='close' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onClick='window.close();'>
	 </td>
	</tr>
</table>
<%
	if(i==0)
			{%>
		<script>
			var msg =getMessage('NO_DISCHARGED_ENCOUTER','FM');
			alert(msg);
			window.close();
		</script>	
		
<%}
if(stmt!=null) stmt.close();
	if(rs!=null) rs.close();
		}
}catch (Exception e){ 
	e.printStackTrace(); 
	}
finally 
{
	ConnectionManager.returnConnection(con,request);
}	
%>

</form>
</BODY>
</HTML>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

