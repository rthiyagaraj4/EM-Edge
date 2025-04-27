<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,com.ehis.util.*,webbeans.eCommon.*,java.util.StringTokenizer,java.util.TreeMap,eCommon.XSSRequestWrapper" %>
 
 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String locale = (String)session.getAttribute("LOCALE"); 

		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
	
	Connection con=null; 
	Statement stmt=null;
	ResultSet rset=null;  
	int maxRecord=0;
	int c=0;
	%>
	<html>
	<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eAE/js/AECancelledCheckout.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>


	</head>
	<%

	String facility_id=checkForNull(request.getParameter("facility_id"));
	String speciality_code=checkForNull(request.getParameter("speciality_code"));
	String location_id=checkForNull(request.getParameter("location_id"));
	String pract=checkForNull(request.getParameter("pract"));
	String patient_id=checkForNull(request.getParameter("patient_id"));
	String gender=checkForNull(request.getParameter("gender"));
	//String encounter_id=checkForNull(request.getParameter("encounter_id"));
	String patfrom=checkForNull(request.getParameter("patfrom"));
	String patto=checkForNull(request.getParameter("patto"));
	String cancelled_by=checkForNull(request.getParameter("cancelled_by"));
	String user=checkForNull(request.getParameter("user"));
	String disaster=checkForNull(request.getParameter("disaster"));
	String caseoftrauma=checkForNull(request.getParameter("caseoftrauma"));

	String from = request.getParameter( "from" );
	String to = request.getParameter( "to" );
	String queue_date="";
	String discharge_date_time="";
	String cancelled_date="";

	int start = 0 ;
	 int end = 0 ;
	 int i=1;

	 if ( from == null )
		start = 1 ;
	 else
		start = Integer.parseInt( from ) ;

	 if ( to == null )
	  	end = 12;
	 else
		end = Integer.parseInt( to ) ;
	
	try
	{
		con =  ConnectionManager.getConnection(request); 

%>


<BODY  onMouseDown="CodeArrest()" onKeyDown = 'lockKey()' >
<form name="AECancelChkout_result" id="AECancelChkout_result">
<%
	String class_val = "";
	StringBuffer sqlBuff=new StringBuffer();
	StringBuffer Where=new StringBuffer();
	String dis_yn="";
	String dis_status="";
	String trauma_yn="";
	String trauma_status="";
	String gender_tab="";
	String gender_st="";


	if(!speciality_code.equals(""))
		Where.append(" and a.SPECIALITY_CODE = '"+speciality_code+"' ");
	if(!location_id.equals(""))
		Where.append(" and a.LOCN_CODE = '"+location_id+"' ");
	if(!pract.equals(""))
		Where.append(" and a.PRACTITIONER_ID = '"+pract+"' ");
	if(!patient_id.equals(""))
		Where.append(" and a.PATIENT_ID = '"+patient_id+"' ");
	if(!gender.equals("A"))
	{
	if(!gender.equals(""))
		Where.append(" and b.Sex = '"+gender+"' ");
	}
	
	if(!cancelled_by.equals(""))
		Where.append(" and a.CANCELLED_BY_ID = '"+user+"' ");
	if(!disaster.equals(""))
		Where.append(" and a.DISASTER_YN = '"+disaster+"' ");
	if(!caseoftrauma.equals(""))
		Where.append(" and a.TRAUMA_YN = '"+caseoftrauma+"' ");
	
	if(!patfrom.equals(""))
		Where.append(" and trunc(a.CANCELLED_DATE) >= trunc(to_date('"+patfrom+"','dd/mm/yyyy')) ");

	if(!patto.equals(""))
		Where.append(" and trunc(a.CANCELLED_DATE) <= trunc(to_date('"+patto+"','dd/mm/yyyy')) ");

		
	Where.append(" order by a.QUEUE_DATE");
	
	sqlBuff.append("SELECT a.ENCOUNTER_ID, to_char(a.QUEUE_DATE,'dd/mm/yyyy hh24:mi') QUEUE_DATE, a.PATIENT_ID, decode('"+locale+"', 'en', b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name, b.Sex Gender, op_get_desc.OP_CLINIC(a.facility_id,a.LOCN_CODE, '"+locale+"',1) clinic_desc , a.SPECIALITY_CODE,am_get_desc.AM_SPECIALITY(a.SPECIALITY_CODE,'"+locale+"',2)  SPECIALITY_DESC, a.PRACTITIONER_ID, AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"' ,'1') practitioner_name, to_char(a.DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME, a.DISASTER_YN, a.TRAUMA_YN, am_get_desc.am_disposition_type(a.disposition_type,'"+locale+"',2) disposition_short_desc, a.CANCEL_REASON_CODE, am_get_desc.am_contact_reason(a.CANCEL_REASON_CODE,'"+locale+"',1) CANCEL_REASON_DESC, a.CANCELLED_BY_ID, sm_get_desc.SM_APPL_USER(a.CANCELLED_BY_ID,'en',1) user_name, to_char(a.CANCELLED_DATE,'dd/mm/yyyy hh24:mi') CANCELLED_DATE FROM op_cancelled_checkout a,mp_patient b WHERE a.facility_id = '"+facility_id+"'  and  a.patient_id = b.patient_id and a.patient_class='EM'");
	
	sqlBuff.append(Where.toString());

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
			out.println("<td align ='right' id='prev'><A HREF='../../eAE/jsp/AECancelledChecoutSearchResult.jsp?from="+(start-12)+"&to="+(end-12)+"&facility_id="+facility_id+"&speciality_code="+speciality_code+"&location_id="+location_id+"&pract="+pract+"&patient_id="+patient_id+"&gender="+gender+"&patfrom="+patfrom+"&patto="+patto+"&user="+user+"&cancelled_by="+cancelled_by+"&disaster="+disaster+"&caseoftrauma="+caseoftrauma+"'"+"text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
		%>
		<td align ='right' id='next' style='visibility:hidden'>
		<%
			out.println("<A HREF='../../eAE/jsp/AECancelledChecoutSearchResult.jsp?from="+(start+12)+"&to="+(end+12)+"&facility_id="+facility_id+"&speciality_code="+speciality_code+"&location_id="+location_id+"&pract="+pract+"&patient_id="+patient_id+"&gender="+gender+"&patfrom="+patfrom+"&patto="+patto+"&user="+user+"&cancelled_by="+cancelled_by+"&disaster="+disaster+"&caseoftrauma="+caseoftrauma+"'"+"text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		%>
		</td>
		</tr>
		</table>
		<br><br>
		</P>

	<table border="1"  cellspacing='0' cellpadding='0' width="100%">
	
		<th><fmt:message key="Common.DispType.label" bundle="${common_labels}"/></th>
		<th nowrap><fmt:message key="Common.VisitDate.label" bundle="${common_labels}"/></th>
		<th nowrap><fmt:message key="Common.CheckoutDate.label" bundle="${common_labels}"/></th>
		<th nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
		<th nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
		<th nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/></th>
		<th nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
		<th nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
		<th nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
		<th nowrap><fmt:message key="Common.cancelled.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.date.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.ReasonforCancellation.label" bundle="${common_labels}"/></th>
		<th nowrap><fmt:message key="Common.cancelledby.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.Disaster.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.CaseofTrauma.label" bundle="${common_labels}"/></th>

<%
			}
		dis_yn=rset.getString("DISASTER_YN");
		if(dis_yn.equals("Y"))
			dis_status="Yes";
		else
			dis_status="No";

		trauma_yn=rset.getString("TRAUMA_YN");
		if(trauma_yn.equals("Y"))
			trauma_status="Yes";
		else
			trauma_status="No";

		gender_tab=rset.getString("Gender");
		if(gender_tab.equals("M"))
			gender_st="Male";
		else if(gender_tab.equals("F"))
			gender_st="Female";
		else if(gender_tab.equals("U"))
			gender_st="Unknown";
		

		if (c % 2 == 0 )
			class_val = "QRYEVEN" ;
		else
			class_val = "QRYODD" ;
        queue_date=rset.getString("QUEUE_DATE");
        queue_date=DateUtils.convertDate(queue_date,"DMYHM","en",locale);

        discharge_date_time=rset.getString("DISCHARGE_DATE_TIME");
        discharge_date_time=DateUtils.convertDate(discharge_date_time,"DMYHM","en",locale);
        cancelled_date=rset.getString("CANCELLED_DATE");
		cancelled_date=DateUtils.convertDate(cancelled_date,"DMYHM","en",locale);

				
		out.println("<tr>");				
		out.println("<td class='"+class_val+"'><font size=1>" +rset.getString("disposition_short_desc")+"</td>");
		//out.println("<td nowrap class='"+class_val+"'><font size=1>" +rset.getString("QUEUE_DATE")+"</td>");

		out.println("<td nowrap class='"+class_val+"'><font size=1>" +queue_date+"</td>");

		//out.println("<td nowrap class='"+class_val+"'><font size=1>" +rset.getString("DISCHARGE_DATE_TIME")+"</td>");

		out.println("<td nowrap class='"+class_val+"'><font size=1>" +discharge_date_time+"</td>");

		out.println("<td nowrap class='"+class_val+"'><font size=1>" +rset.getString("PATIENT_ID")+"</td>");
		out.println("<td nowrap class='"+class_val+"'><font size=1>" +rset.getString("patient_name")+"</td>");
		out.println("<td nowrap class='"+class_val+"'><font size=1>" +gender_st+"</td>");
		out.println("<td nowrap class='"+class_val+"'><font size=1>" +rset.getString("ENCOUNTER_ID")+"</td>");
		out.println("<td nowrap class='"+class_val+"'><font size=1>" +rset.getString("clinic_desc")+"</td>");
		out.println("<td nowrap class='"+class_val+"'><font size=1>" +rset.getString("SPECIALITY_DESC")+"</td>");
		out.println("<td class='"+class_val+"'><font size=1>"+checkForNull(rset.getString("practitioner_name"))+"</td>");
		//out.println("<td nowrap class='"+class_val+"'><font size=1>" +rset.getString("CANCELLED_DATE")+"</td>");	

		out.println("<td nowrap class='"+class_val+"'><font size=1>" +cancelled_date+"</td>");	

		out.println("<td class='"+class_val+"'><font size=1>" +checkForNull(rset.getString("CANCEL_REASON_DESC"))+"</td>");
		out.println("<td class='"+class_val+"'><font size=1>" +rset.getString("user_name")+"</td>");
		out.println("<td class='"+class_val+"'><font size=1>" +dis_status+"</td>");
		out.println("<td class='"+class_val+"'><font size=1>" +trauma_status+"</td>");
		out.println("</tr>");
				
		c++;
		i++;
		maxRecord++;

	}
	if(maxRecord == 0)
		{
			 out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common')); </script>");
			 
		}

		if ( maxRecord < 12 || (!rset.next()) )
		{
		%>
			<script >
			if (document.getElementById("next"))
			document.getElementById("next").innerHTML="";

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

