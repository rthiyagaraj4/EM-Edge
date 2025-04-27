<!DOCTYPE html>
<%--
/**
  *	Purpose				:	Displays the Search Result for AE Unknown Patients.
  * Added by			:	Sen 
  * Date				:   30/04/2004
  */
--%>

<%@ page import ="java.sql.*,java.net.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<HTML>
<head>
<% String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eAE/js/queryUnknownPatients.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY  class='CONTENT' onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<% 
request.setCharacterEncoding("UTF-8");
String sql_query			= request.getParameter("sql_query");

String	facilityId 			= (String) session.getValue( "facility_id" ) ;
String from 				= request.getParameter("from") ;

String to 					= request.getParameter("to") ;
String locale						= (String)session.getAttribute("LOCALE");

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

		Connection con = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;

	try
	{
      con =  ConnectionManager.getConnection(request);
	  
	  StringBuffer strsql1=new StringBuffer();
	  StringBuffer strsql2=new StringBuffer();

	  //Query modified by Ashwini on 03-Aug-2017 for ML-MMOH-SCF-0713
	  if(!( (sql_query == null) || (sql_query.equals(""))	))	
		{	

		  strsql2.append("select to_char(a.queue_date,'dd/mm/yyyy hh24:mi') visit_adm_date_time,a.queue_date order_adm_date_time,OP_GET_DESC.OP_CLINIC(a.FACILITY_ID, a.LOCN_CODE,'"+locale+"','1') clinic_name,a.patient_id ,decode('"+locale+"', 'en', b.patient_name , nvl(b.patient_name_loc_lang, b.patient_name)) patient_name, MP_GET_AGE_YMDH(b.date_of_birth) age,b.sex,a.queue_status visit_status_desc,a.episode_id,a.op_episode_visit_num,a.encounter_id,AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(a.FACILITY_ID, a.LOCN_CODE, a.TREATMENT_AREA_CODE,'"+locale+"','2') treatment_area_desc,a.AE_BED_NO assign_bed_num, AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"','1') practitioner_name  from op_patient_queue a, mp_patient b where a.facility_id='"+facilityId+"' and a.patient_class = 'EM' and a.patient_id = b.patient_id ");
		  strsql2.append(sql_query);
		  strsql2.append("  and b.PAT_DTLS_UNKNOWN_YN = 'Y' order by order_adm_date_time desc"); 
		   
		}
	  else
		{	
		  strsql2.append("select to_char(a.queue_date,'dd/mm/yyyy hh24:mi') visit_adm_date_time,a.queue_date order_adm_date_time,OP_GET_DESC.OP_CLINIC(a.FACILITY_ID, a.LOCN_CODE,'"+locale+"','1') clinic_name,a.patient_id, decode('"+locale+"', 'en', b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name, MP_GET_AGE_YMDH(b.date_of_birth) age,b.sex,a.queue_status visit_status_desc,a.episode_id,a.op_episode_visit_num,a.encounter_id,AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(a.FACILITY_ID, a.LOCN_CODE, a.TREATMENT_AREA_CODE,'"+locale+"','2') treatment_area_desc,a.AE_BED_NO assign_bed_num,AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"','1') practitioner_name        from op_patient_queue a, mp_patient b where a.facility_id='"+facilityId+"' and a.patient_class = 'EM'and a.patient_id = b.patient_id and b.PAT_DTLS_UNKNOWN_YN = 'Y' order by patient_id,order_adm_date_time desc"); 
		  
		} 
	  stmt = con.prepareStatement(strsql2.toString());
     // stmt.setString(1,facilityId);
 	  rs = stmt.executeQuery();  
	  String classValue = "" ;
	  int cnt=0;
	  String endOfRes="1";
	  if ( start != 1 )
		 for( int j=1; j<start; i++,j++ )
		  {
			rs.next() ;
		  }
  
	 while (i<=end && rs.next()){
		if(cnt==0){
%>
<p>
<table align='right'>
<tr>
<td>
<%  
if ( !(start <= 1) )
	out.println("<A HREF='../../eAE/jsp/queryUnknownPatientsResult.jsp?from="+(start-14)+"&to="+(end-14)+"&sql_query="+URLEncoder.encode(sql_query)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if (endOfRes.equals("1"))
	out.println("<A id='nextvalue' HREF='../../eAE/jsp/queryUnknownPatientsResult.jsp?from="+(start+14)+"&to="+(end+14)+"&sql_query="+URLEncoder.encode(sql_query)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>"); 
	
%>
</td>
</tr>
</table>
<br>
</p>
<table border="1"  cellspacing='0' cellpadding='0' width="100%">
<th>	<fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>	</th>
<th>	<fmt:message key="Common.VisitDate.label" bundle="${common_labels}"/>		</th>
<th>	<fmt:message key="Common.Location.label" bundle="${common_labels}"/>		</th>
<th>	<fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/>	</th>
<th>	<fmt:message key="Common.bedno.label" bundle="${common_labels}"/>      	</th>
<th>	<fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>    </th>
<th>	<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>		</th>
<th>	<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>	</th>
<th>	<fmt:message key="Common.age.label" bundle="${common_labels}"/>				</th>
<th>	<fmt:message key="Common.gender.label" bundle="${common_labels}"/>				</th>
<th>	<fmt:message key="Common.VisitStatus.label" bundle="${common_labels}"/>	</th>

<%} 

	 if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
	 else
		  	classValue = "QRYODD" ;

	String visit_adm_date_time = rs.getString("visit_adm_date_time");
	String clinic_name	= rs.getString("clinic_name");
	String patient_id = rs.getString("patient_id");
	String patient_name = rs.getString("patient_name");
	String age = rs.getString("age");
	String sex = rs.getString("sex");	
	String visit_status = rs.getString("visit_status_desc");
	String treatment_area_desc = rs.getString("treatment_area_desc");
	String assign_bed_num      = rs.getString("assign_bed_num");
    String practitioner_name   = rs.getString("practitioner_name");
	String encounter_id = rs.getString("encounter_id");
	
	

	if(visit_adm_date_time == null)			visit_adm_date_time	=	"";
	if(clinic_name == null)					clinic_name		=	"";
	if(patient_id == null)					patient_id		=	"";
	if(patient_name == null)				patient_name	=	"";
	if(age == null)							age				=	"";
	if(sex == null)							sex				=	"";
	if(visit_status == null)				visit_status	=	"";
	if(encounter_id == null)				encounter_id	=	"";
	if(treatment_area_desc == null)			treatment_area_desc	=	"";
	if(assign_bed_num == null)			    assign_bed_num	  =	"";
	if(practitioner_name == null)			practitioner_name =	"";

    out.println("<tr><td class='" + classValue + "' nowrap><font size=1>");
    out.println(encounter_id+"</td>");
	out.println("<td class='" + classValue + "'  nowrap><font size=1>");
	out.println(DateUtils.convertDate(visit_adm_date_time,"DMYHM","en",locale)+"</td><td class='" + classValue + "'w nowrap><font size=1>");
	out.println(clinic_name+"</td><td class='" + classValue + "'  nowrap><font size=1>");
    if(treatment_area_desc.equals(""))
		 {
    	    out.println("&nbsp;</td><td class='" + classValue + "'  nowrap><font size=1>");
		 } else
		 {
		    out.println(treatment_area_desc+"</td><td class='" + classValue + "'  nowrap><font size=1>");
		 }
	if(assign_bed_num.equals(""))
		 {
		     out.println("&nbsp;</td><td class='" + classValue + "'  nowrap><font size=1>");
		 } else
		 {
			 out.println(assign_bed_num+"</td><td class='" + classValue + "'  nowrap><font size=1>");
		 }
	if(practitioner_name.equals(""))
		 {
		    out.println("&nbsp;</td><td class='" + classValue + "'  nowrap><font size=1>");
		 } else
		 {
			out.println(practitioner_name+"</td><td class='" + classValue + "'  nowrap><font size=1>");
		 }
    out.println(patient_id+"</td><td class='" + classValue + "'  nowrap><font size=1>");
	out.println(patient_name+"</td><td class='" + classValue + "'  nowrap><font size=1>");
	

	//Modified by Ashwini on 03-Aug-2017 for ML-MMOH-SCF-0713
	if(age.equals(""))
		 {
	        out.println("&nbsp;</td><td class='" + classValue + "' ><font size=1>");
		 } else
		 {
			out.println(age+"</td><td class='" + classValue + "' nowrap><font size=1>");
		 }

	if(sex.equals("F"))
	                    out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels") +"</td><td class='" + classValue + "' nowrap><font size=1>");
	                if(sex.equals("M"))
	                    out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")+"</td><td class='" + classValue + "' nowrap><font size=1>");
	                if(sex.equals("U"))
	                    out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels")+"</td><td class='" + classValue + "'  nowrap><font size=1>");

					if(visit_status.equals("00"))
					out.println("&nbsp;</td>");
					if(visit_status.equals("01"))			        out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckedIn.label","common_labels")+"</td><td class='" + classValue + "' nowrap><font size=1>");
					if(visit_status.equals("02"))                  out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.AssignedtoTreatmentArea.label","ae_labels")+"</td><td class='" + classValue + "' nowrap><font size=1>");		
					if(visit_status.equals("03"))						out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.UndergoingTreatment.label","ae_labels")+"</td><td class='" + classValue + "' nowrap><font size=1>");
					if(visit_status.equals("04"))
					out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ConsultationInProgress.label","op_labels")+"</td>");	
					if(visit_status.equals("07"))		out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckOut.label","common_labels")+"</td><td class='" + classValue + "' nowrap><font size=1>");
					if(visit_status.equals("09"))
					out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.Autoclosed.label","ae_labels")+"</td>");
					if(visit_status.equals("99"))    out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels")+"</td><td class='" + classValue + "' nowrap><font size=1>");
					
	i++;
 	cnt++;
 }//endwhile
 if(cnt==0)
	 out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");
 if(!rs.next()&&cnt!=0){
	endOfRes="0";%>
	<script>
		document.getElementById("nextvalue").innerHTML=" ";
	</script>
	<%}       

 %>
 </tr>
</table>
<br>
<%   
strsql1.setLength(0);
strsql2.setLength(0);

if(rs!=null)	rs.close();
if(stmt!=null)	stmt.close();
 }catch(Exception e)
     {
		e.printStackTrace();
     }
	finally   
	{
		out.println("<script>parent.frames[1].document.forms[0].search.disabled = false</script>");
		
		 if(con!=null)
		 ConnectionManager.returnConnection(con,request);
    } 
%>
</BODY>
</HTML>

