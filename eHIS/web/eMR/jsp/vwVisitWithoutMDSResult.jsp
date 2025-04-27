<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,com.ehis.util.*,webbeans.eCommon.*,java.util.StringTokenizer,java.util.TreeMap" %>
<%	String locale = (String)session.getAttribute("LOCALE"); 
    String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
    Connection con=null; 
	Statement stmt=null;
	ResultSet rset=null;  
	int maxRecord=0;
	int c=0;
%>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language='javascript' src="../js/VisitsWithoutMDS.js"></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
</head>
<%
	String p_facility_id=request.getParameter("p_facility_id")==null?"":request.getParameter("p_facility_id");
	String p_encounter_id=request.getParameter("p_encounter_id")==null?"":request.getParameter("p_encounter_id");
	String p_patient_id=request.getParameter("p_patient_id")==null?"":request.getParameter("p_patient_id");
	String p_patient_class=request.getParameter("p_patient_class")==null?"":request.getParameter("p_patient_class");
	String p_locn_type=request.getParameter("p_locn_type")==null?"":request.getParameter("p_locn_type");
	//String p_fr_locn_code="";
	String p_fr_vst_date=request.getParameter("p_fr_vst_date")==null?"":request.getParameter("p_fr_vst_date");
	String p_to_vst_date=request.getParameter("p_to_vst_date")==null?"":request.getParameter("p_to_vst_date");
	String p_mds_type=request.getParameter("min_dataset")==null?"":request.getParameter("min_dataset");
	
	String from = request.getParameter( "from" );
	String to = request.getParameter( "to" );
	
	
	int start = 0 ;
	 int end = 0 ;
	 int i=1;

	 if ( from == null )
		start = 1 ;
	 else
		start = Integer.parseInt( from ) ;

	 if ( to == null )
	  	end = 14;
	 else
		end = Integer.parseInt( to ) ;
	
	
	try
	{
	con =  ConnectionManager.getConnection(request); 
	

	
%>
	<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
	<form name='VisitMDSResult' id='VisitMDSResult'  >
<%
	String class_val = "";
	//String Where = "";

	
	StringBuffer sqlBuff=new StringBuffer();
	//Maheshwaran K modified MR_MDS_RECORDED_YN for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
	sqlBuff.append(" SELECT to_char(a.visit_adm_date_time,'dd/mm/yyyy hh24:mi')visit_adm_date_time, a.patient_id, a.encounter_id, (DECODE('"+locale+"' ,'en', d.patient_name))patient_name, DECODE(d.sex,'M','Male','F','Female', 'Unknown') sex, a.assign_care_locn_type, a.assign_care_locn_code,(CASE WHEN a.assign_care_locn_type = 'N' THEN IP_GET_DESC.IP_NURSING_UNIT(a.FACILITY_ID, a.assign_care_locn_code,'"+locale+"','2') ELSE OP_GET_DESC.OP_CLINIC(a.FACILITY_ID, a.assign_care_locn_code, '"+locale+"','1') END )location_desc, get_age(d.date_of_birth)age, a.EPISODE_ID, (CASE WHEN a.Attend_Practitioner_Id IS NOT NULL  THEN AM_GET_DESC.AM_PRACTITIONER(a.Attend_Practitioner_Id,'"+locale+"','1') END) Practitioner_Name, Decode(a.patient_class,'IP','Inpatient','OP','Outpatient','EM','Emergency','DC','DayCare') encounrt_type FROM pr_encounter a, mp_patient d  WHERE a.facility_id ='" +p_facility_id+"' AND a.encounter_id = NVL('"+p_encounter_id+"',a.encounter_id) AND a.patient_id = NVL('"+p_patient_id+"',a.patient_id) AND a.patient_id = d.patient_id AND (a.VISIT_STATUS !='99' OR a.ADT_STATUS !='09') AND a.patient_class = NVL('"+p_patient_class+"',a.patient_class) AND a.assign_care_locn_code = NVL('"+p_locn_type+"', a.assign_care_locn_code) AND a.visit_adm_date_time BETWEEN TO_DATE ('"+p_fr_vst_date+"', 'dd/mm/yyyy') AND TO_DATE ('"+p_to_vst_date+"', 'dd/mm/yyyy')  + 0.9999 AND MR_MDS_RECORDED_YN(a.FACILITY_ID, a.ENCOUNTER_ID,a.patient_class,'"+p_mds_type+"',decode(a.patient_class,'IP','ALL','DC','ALL','OP','OC','EM','EC'),null)!='Y' order by a.visit_adm_date_time");

	
	if (rset != null) rset.close();
	if (stmt != null) stmt.close();
	stmt=con.createStatement();
    rset=stmt.executeQuery(sqlBuff.toString());
	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  {
	    rset.next() ;
	  }
	while (rset!=null && i<=end && rset.next())
    {
			
			if(maxRecord == 0)
			{

		%>
		<P>
		<table align='right'>
		<tr>
		
		<%
		if ( !(start <= 1) )
			out.println("<td align ='right' id='prev'><A HREF='../../eMR/jsp/vwVisitWithoutMDSResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sqlBuff.toString())+"&p_facility_id="+p_facility_id+"&p_encounter_id="+p_encounter_id+"&p_patient_id="+p_patient_id+"&p_patient_class="+p_patient_class+"&p_locn_type="+p_locn_type+"&p_fr_vst_date="+p_fr_vst_date+"&p_to_vst_date="+p_to_vst_date+"&p_mds_type="+p_mds_type+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
		%>
		<td align ='right' id='next' style='visibility:hidden'>
		<%
			out.println("<A HREF='../../eMR/jsp/vwVisitWithoutMDSResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sqlBuff.toString())+"&p_facility_id="+p_facility_id+"&p_encounter_id="+p_encounter_id+"&p_patient_id="+p_patient_id+"&p_patient_class="+p_patient_class+"&p_locn_type="+p_locn_type+"&p_fr_vst_date="+p_fr_vst_date+"&p_to_vst_date="+p_to_vst_date+"&p_mds_type="+p_mds_type+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		%>
		</td>
		</tr>
		</table>
		<br><br>
		</P>
			
	

	<table border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>
		<tr>
			<th nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
			<th nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
			<th nowrap><fmt:message key="Common.age.label" bundle="${common_labels}"/></th>
			<th nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/></th>
			<th nowrap><fmt:message key="Common.encounterdatetime.label" bundle="${common_labels}"/></th>
			<th nowrap><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></th>
			<th nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
			<th nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
			<th nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>	
		</tr>


<%
	}
		
		if (c % 2 == 0 )
			class_val = "QRYEVEN" ;
		else
			class_val = "QRYODD" ;
				
		out.println("<tr>");				
		out.println("<td nowrap class='"+class_val+"'>" +rset.getString("patient_id")+"</td>");
		out.println("<td class='"+class_val+"'>" +checkForNull(rset.getString("patient_name"))+"</td>");
		out.println("<td nowrap class='"+class_val+"'>" +rset.getString("age")+"</td>");
		out.println("<td nowrap class='"+class_val+"'>" +rset.getString("sex")+"</td>");
		out.println("<td nowrap class='"+class_val+"'>" +rset.getString("visit_adm_date_time")+"</td>");
		out.println("<td nowrap class='"+class_val+"'>" +rset.getString("encounrt_type")+"</td>");
		out.println("<td nowrap class='"+class_val+"'>" +rset.getString("ENCOUNTER_ID")+"</td>");
		out.println("<td nowrap class='"+class_val+"'>" +rset.getString("location_desc")+"</td>");
		out.println("<td nowrap class='"+class_val+"'>" +checkForNull(rset.getString("Practitioner_Name"))+"</td>");
		out.println("</tr>");
		
		
		c++;
		i++;
		maxRecord++;
		
		}
		if(maxRecord == 0)
		{
			 out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common')); </script>");
			 
		}

		if ( maxRecord < 14 || (!rset.next()) )
		{
		%>
			<script >
			if (document.getElementById("next"))
				document.getElementById("next").style.visibility='hidden';
			</script>
		<% 
		}
		else
		{%>
			<script >
			if (document.getElementById("next"))
				document.getElementById("next").style.visibility='visible';
			</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



		<%
		}
	


if(rset!=null)
	rset.close();	
if(stmt!=null)
	stmt.close();


%>
	</table>
</form>
</body>

</html>
<%
}
catch(Exception e)
{	
	//out.println("Exception="+e.toString());
	e.printStackTrace();
	
}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>


<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "&nbsp;" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

