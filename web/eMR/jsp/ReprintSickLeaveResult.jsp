<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>

<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String FacilityId		= (String) session.getValue( "facility_id" ) ;
	String locale       =(String) session.getAttribute("LOCALE");
	String sql ;
	String PatientId	=	request.getParameter("PatientId") ;
	String PatientClass	=	request.getParameter("PatientClass") ;
	String EncounterId	=	request.getParameter("EncounterId") ;
	String LeaveFrom	=	request.getParameter("LeaveFrom") ;
	String LeaveTo	    =	request.getParameter("LeaveTo") ;
	
	String LeaveFrom_display ="";
	String LeaveTo_display   ="";

	if(PatientId	== null || PatientId.equals("null"))	PatientId = "";
	if(PatientClass == null || PatientClass.equals("null"))	PatientClass = "";
	if(EncounterId	== null || EncounterId.equals("null"))	EncounterId = "";	
	if(LeaveFrom	== null || LeaveFrom.equals("null"))	LeaveFrom = "";
	if(LeaveTo		== null || LeaveTo.equals("null"))		LeaveTo = "";
	


	String whereClause = request.getParameter("whereclause");
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	if(whereClause	== null || whereClause.equals("null"))	whereClause = "";
	int start = 0 ;
	int end = 0 ;
    int i=1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
		end = 14 ;
	else
		end = Integer.parseInt( to ) ;

	Statement stmt				= null;
	ResultSet rs				= null;
	Connection conn = null;
try {
	conn = ConnectionManager.getConnection(request);	
	%>
<HTML>
<head>
	<script src="../../eOP/js/menu.js" language="JavaScript1.2"></script>
	<script src="../../eOA/js/QueryLocnForDay.js"></script>
	
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function reprint(sl_ref_no,PatientId)
	{
	  document.forms[0].sl_ref_no.value = sl_ref_no;
	  document.forms[0].PatientId.value = PatientId;
	  document.forms[0].submit(); 
	}
	async function showremarks(remarks_cnt)
	{
		var dialogHeight= "11vh" ;
		var dialogWidth = "47vw" ;                    
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no;scroll=no" ;
		var arguments   = "" ;
		var arr =new Array();
		var arguments	= eval("document.forms[0].remarks"+remarks_cnt).value ;
		if(arguments == null) arguments="";
		var retVal = await window.showModalDialog("../../eMR/jsp/SickLeaveRemarks.jsp",arguments,features);
	}
	</script>
	</head>
	<body OnMouseDown='CodeArrest();' onKeyDown = 'lockKey();'>
	<form name='reprintSickLeaveResult' id='reprintSickLeaveResult' action="../../servlet/eMR.SickLeaveServlet"  method="post"  target ="messageFrame">
	<%

	String Where = " where (a.facility_id is null or a.facility_id = '"+FacilityId+"')  and nvl(b.patient_class,'x') = nvl('"+PatientClass+"',nvl(b.patient_class,'x'))  and nvl(a.patient_id,'x') = nvl('"+PatientId+"',nvl(a.patient_id,'x')) and nvl(a.encounter_id,0) = nvl('"+EncounterId+"',nvl(a.encounter_id,0)) and  trunc(a.leave_from) = nvl(to_date('"+LeaveFrom+"','dd/mm/yyyy'), trunc(a.leave_from)) and trunc(a.leave_to) = nvl(to_date('"+LeaveTo+"','dd/mm/yyyy'),trunc(a.leave_to)) and a.facility_id = b.facility_id (+) and a.encounter_id = b.encounter_id (+) and a.patient_id = c.patient_id";

	int maxRecord = 0;


	//sql = "Select AM_GET_DESC.AM_PATIENT_CLASS(B.PATIENT_CLASS,'"+localeName+"','2') patient_class,a.sl_ref_no sl_ref_no, a.patient_id patient_id,decode('"+localeName+"', 'en', c.patient_name, nvl(c.patient_name_loc_lang,c.patient_name)) patient_name, a.encounter_id, to_char(b.visit_adm_date_time,'dd/mm/yyyy hh24:mi'),decode(b.assign_care_locn_type, 'N', IP_GET_DESC.IP_NURSING_UNIT(b.facility_id, b.assign_care_locn_code,'"+localeName+"','2'), OP_GET_DESC.op_clinic(b.facility_id,b.assign_care_locn_code,'"+localeName+"','1')) LOCATION, AM_GET_DESC.AM_PRACTITIONER(a.authorized_by_id,'"+localeName+"','1') practitioner_name, nvl2(a.encounter_id, to_char( a.leave_from,'dd/mm/yyyy hh24:mi'), to_char(a.leave_from,'dd/mm/yyyy')), nvl2(a.encounter_id, to_char(a.leave_to,'dd/mm/yyyy hh24:mi'), to_char(a.leave_to,'dd/mm/yyyy')), to_char(b.discharge_date_time,'dd/mm/yyyy hh24:mi'), a.cert_issued,a.remarks from pr_sick_leave_register a, pr_encounter b, mp_patient c " + Where ;
	//sql = sql +" order by b.patient_class desc, a.patient_id";

	sql = "Select AM_GET_DESC.AM_PATIENT_CLASS(B.PATIENT_CLASS,'"+localeName+"','2') patient_class,a.sl_ref_no sl_ref_no, a.patient_id patient_id,decode('"+localeName+"', 'en', c.patient_name, nvl(c.patient_name_loc_lang,c.patient_name)) patient_name, a.encounter_id, to_char(b.visit_adm_date_time,'dd/mm/yyyy hh24:mi'),decode(b.assign_care_locn_type, 'N', IP_GET_DESC.IP_NURSING_UNIT(b.facility_id, b.assign_care_locn_code,'"+localeName+"','2'), OP_GET_DESC.op_clinic(b.facility_id,b.assign_care_locn_code,'"+localeName+"','1')) LOCATION, AM_GET_DESC.AM_PRACTITIONER(a.authorized_by_id,'"+localeName+"','1') practitioner_name, nvl2(a.encounter_id, to_char( a.leave_from,'dd/mm/yyyy hh24:mi'), to_char(a.leave_from,'dd/mm/yyyy hh24:mi')), nvl2(a.encounter_id, to_char(a.leave_to,'dd/mm/yyyy hh24:mi'), to_char(a.leave_to,'dd/mm/yyyy hh24:mi')), to_char(b.discharge_date_time,'dd/mm/yyyy hh24:mi'), a.cert_issued,a.remarks from pr_sick_leave_register a, pr_encounter b, mp_patient c " + Where ;
	sql = sql +" order by b.patient_class desc, a.patient_id";
	
	

	//stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);	
	stmt = conn.createStatement();	
	rs = stmt.executeQuery(sql);

	if ( start != 1 )
		for( int j=1; j<start; i++,j++ )
			rs.next() ;

	while ( i<=end && rs.next())
	{
		if(maxRecord==0)
		{

	/*if ( (rs != null) )
	{
	   rs.last();
	   maxRecord = rs.getRow();
	   rs.beforeFirst();
	}
	if (maxRecord==0)		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));document.location.href='../../eCommon/html/blank.html'</script>");
	else{*/
	%>
	<P>
	<table align='right'>
	<tr>
	
	<%
	if ( !(start <= 1) )
		out.println("<td align='right' id='prev'><A HREF='../../eMR/jsp/ReprintSickLeaveResult.jsp?PatientId="+PatientId+"&PatientClass="+PatientClass+"&EncounterId="+EncounterId+"&LeaveFrom="+LeaveFrom+"&LeaveTo="+LeaveTo+"&from="+(start-14)+"&to="+(end-14)+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
	//if ( !( (start+14) > maxRecord ) )
		out.println("<td align='right' id='next' style='visibility:hidden'><A HREF='../../eMR/jsp/ReprintSickLeaveResult.jsp?PatientId="+PatientId+"&PatientClass="+PatientClass+"&EncounterId="+EncounterId+"&LeaveFrom="+LeaveFrom+"&LeaveTo="+LeaveTo+"&from="+(start+14)+"&to="+(end+14)+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
	%>
	
	</tr>
	</table><br>
	</P>
	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
	<tr>
	<td class="COLUMNHEADER" nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
	<td class="COLUMNHEADER" nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
	<td class="COLUMNHEADER" nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
	<td class="COLUMNHEADER" nowrap><fmt:message key="eMR.AdmVisitDate.label" bundle="${mr_labels}"/></td>
	<td class="COLUMNHEADER" nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
	<td class="COLUMNHEADER" nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
	<td class="COLUMNHEADER" nowrap><fmt:message key="Common.LeaveFrom.label" bundle="${common_labels}"/></td>
	<td class="COLUMNHEADER" nowrap><fmt:message key="Common.LeaveTo.label" bundle="${common_labels}"/></td>
	<td class="COLUMNHEADER" nowrap><fmt:message key="Common.dischargedate.label" bundle="${common_labels}"/></td>
	<td class="COLUMNHEADER" nowrap><fmt:message key="Common.certificateissued.label" bundle="${common_labels}"/></td>
	<td class="COLUMNHEADER" nowrap>&nbsp;</td>
	</tr>
	<%
		}
	String classValue	 = "";
	String Prev_patient_class = "";
	//if ( rs != null )
			//{
			/*if ( start != 1 )
			 for( int j=1; j<start; i++,j++ )
				  rs.next() ;*/

			//while ( rs.next() && i<=end )
			//{
				if ( i % 2 == 0 )
					classValue = "QRYEVEN" ;
				else
					classValue = "QRYODD" ;
				
				String Patient_Class	= rs.getString(1);
				String SlRefNo			= rs.getString(2);
				String PatientID		= rs.getString(3);
				String PatientName		= rs.getString(4);
				String EncounterID		= rs.getString(5);
				String VisitAdmDate		= rs.getString(6);
				String Location		    = rs.getString(7);
				String PractName		= rs.getString(8);
				String LeaveFRom		= rs.getString(9);
				String LeaveTO			= rs.getString(10);
				String DisChargeDate	= rs.getString(11);
				String cert_issued		= rs.getString(12);
				String remarks			= rs.getString(13);

				if(Patient_Class==null	|| Patient_Class.equals("null"))	Patient_Class = "";
				if(EncounterID==null	|| EncounterID.equals("null"))		EncounterID = "&nbsp;";
				if(VisitAdmDate==null	|| VisitAdmDate.equals("null"))		VisitAdmDate = "&nbsp;";
				if(Location==null		|| Location.equals("null"))			Location = "&nbsp;";
				if(PractName==null		|| PractName.equals("null"))		PractName = "&nbsp;";
				if(DisChargeDate==null	|| DisChargeDate.equals("null"))	DisChargeDate = "&nbsp;";
				if(cert_issued==null	|| cert_issued.equals("null"))		cert_issued = "&nbsp;";
				if(remarks==null		|| remarks.equals("null"))			remarks = "&nbsp;";

				if(!(LeaveFRom==null || LeaveFRom.equals("")))
					LeaveFrom_display  = DateUtils.convertDate(LeaveFRom,"DMYHM","en",locale);
				if(!(LeaveTO==null || LeaveTO.equals("")))
					LeaveTo_display   = DateUtils.convertDate(LeaveTO,"DMYHM","en",locale);

				//if(!(LeaveFRom==null || LeaveFRom.equals("")))
					//LeaveFrom_display  = DateUtils.convertDate(LeaveFRom,"DMY","en",locale);
				//if(!(LeaveTO==null || LeaveTO.equals("")))
					//LeaveTo_display   = DateUtils.convertDate(LeaveTO,"DMY","en",locale);

				if(!VisitAdmDate.equals("&nbsp;"))
					VisitAdmDate = DateUtils.convertDate(VisitAdmDate,"DMYHM","en",locale);

				if(!DisChargeDate.equals("&nbsp;"))
					DisChargeDate = DateUtils.convertDate(DisChargeDate,"DMYHM","en",locale);

				if (!Prev_patient_class.equals(Patient_Class))
				out.println("<tr><th colspan = 11 align='left' class=GROUPING>"+Patient_Class+"</th></tr>");
				Prev_patient_class = Patient_Class;

				out.println("<tr><td nowrap class='"+classValue+"'>");
				out.println("<a href=javascript:reprint('"+SlRefNo+"','"+PatientID+"')>"+PatientID+"</a>");
				out.println("</td>");
				out.println("<td nowrap class='"+classValue+"'>" +PatientName+"</td>");
				out.println("<td nowrap class='"+classValue+"'>"+EncounterID+"</td>");
				out.println("<td nowrap class='"+classValue+"'>"+VisitAdmDate+"</td>");
				out.println("<td nowrap class='"+classValue+"'>"+Location+"</td>");			
				out.println("<td nowrap class='"+classValue+"'>"+PractName+"</td>");			
				out.println("<td nowrap class='"+classValue+"'>"+LeaveFrom_display+"</td>");			
				out.println("<td nowrap class='"+classValue+"'>"+LeaveTo_display+"</td>");			
				out.println("<td nowrap class='"+classValue+"'>"+DisChargeDate+"</td>");			
			    if (cert_issued.equals("Y"))
				out.println("<td nowrap  class='"+classValue+"'><img src=../../eCommon/images/enabled.gif></td>");			
				else
				out.println("<td nowrap class='"+classValue+"'><img src=../../eCommon/images/disabled.gif></td>");	
				out.println("<td class='"+classValue+"'>");
				out.println("<a href=javascript:showremarks('"+i+"')>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels")+"</a>");
				out.println("<input type = hidden name = remarks"+i +" value = \""+remarks+"\">");
				out.println("</td>");out.println("</tr>");
				i++;
				maxRecord++;
			}
		//}
%>
<input type  = hidden name = PatientId value="">
<input type  = hidden name = sl_ref_no value="">
<input type  = hidden name = operation value="print">

</table>
<br><center>
<%
				if (maxRecord==0)		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));document.location.href='../../eCommon/html/blank.html'</script>");

				if(maxRecord<14 || (!rs.next()))
				{%>
					<script>
						if (document.getElementById("next"))
							document.getElementById("next").style.visibility='hidden';
					</script>
				<%}
				else
				{%>
					<script>
						if (document.getElementById("next"))
							document.getElementById("next").style.visibility='visible';
					</script>
				<%}
//}
}catch ( Exception e ){ /* out.println(e); */ e.printStackTrace();}

finally{
	if ( rs != null ) rs.close() ;
	if ( stmt != null ) stmt.close() ;
	
	ConnectionManager.returnConnection(conn,request);
	}
%>
</center>


</form>
</body>
</html>

