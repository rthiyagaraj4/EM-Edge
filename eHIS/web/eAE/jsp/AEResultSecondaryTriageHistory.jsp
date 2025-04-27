<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,webbeans.eCommon.*,com.ehis.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<HTML>
<head> 
 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eAE/js/AESecondaryTriageHistory.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY  class='CONTENT' onLoad='' onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name="secondary_resultform" id="secondary_resultform" method='post' action='../../eAE/jsp/AEResultSecondaryTriageHistory.jsp'>

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
	  	end = 10 ;
	else
		end = Integer.parseInt( to ) ;

		Connection con = null;
		PreparedStatement stmt	= null;
		ResultSet rs=null;

	try
	{
      con =  ConnectionManager.getConnection(request);
	  
	  
	  if(!( (sql_query == null) || (sql_query.equals(""))	))	{	

          if(stmt != null) stmt.close();
		  stmt = con.prepareStatement("select to_char(a.queue_date,'dd/mm/yyyy hh24:mi') visit_adm_date_time,OP_GET_DESC.OP_CLINIC(a.FACILITY_ID, a.LOCN_CODE,'"+locale+"','1') clinic_name,AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(a.FACILITY_ID, a.LOCN_CODE, a.TREATMENT_AREA_CODE,'"+locale+"','2') TREATMENT_AREA_DESC,a.AE_BED_NO,a.patient_id,decode('"+locale+"', 'en', b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name))patient_name,a.encounter_id from op_patient_queue a, mp_patient b where a.facility_id='"+facilityId+"' and a.patient_class = 'EM' and a.patient_id = b.patient_id"+sql_query+"  order by visit_adm_date_time desc");
		  
	  	} else {
		  if(stmt != null) stmt.close();	
		  stmt = con.prepareStatement("select to_char(a.queue_date,'dd/mm/yyyy hh24:mi') visit_adm_date_time,OP_GET_DESC.OP_CLINIC(a.FACILITY_ID, a.LOCN_CODE,'"+locale+"','1') clinic_name,AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(a.FACILITY_ID, a.LOCN_CODE, a.TREATMENT_AREA_CODE,'"+locale+"','2') TREATMENT_AREA_DESC,a.AE_BED_NO,a.patient_id,decode('"+locale+"', 'en', b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name))patient_name,a.encounter_id from op_patient_queue a, mp_patient b where a.facility_id='"+facilityId+"' and a.patient_class = 'EM' and a.patient_id = b.patient_id order by visit_adm_date_time desc");
		}
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
<div name='msg'  id='msg' style="position:absolute;width: 0; height: 0; left: 201; top: 62">
</div>

<div  id='divTitleTable' >
<table align='right'>
<tr>
<td>
<%  
if ( !(start <= 1) )
	out.println("<A HREF='../../eAE/jsp/AEResultSecondaryTriageHistory.jsp?from="+(start-10)+"&to="+(end-10)+"&sql_query="+URLEncoder.encode(sql_query)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if (endOfRes.equals("1"))
	out.println("<A id='nextvalue' HREF='../../eAE/jsp/AEResultSecondaryTriageHistory.jsp?from="+(start+10)+"&to="+(end+10)+"&sql_query="+URLEncoder.encode(sql_query)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>"); 
	
%>
</td>
</tr>
</table>

</p>

<table border="1"  cellspacing='0' cellpadding='0' width="100%">
<th>	<fmt:message key="Common.VisitDate.label" bundle="${common_labels}"/>		</th>
<th>	<fmt:message key="Common.Location.label" bundle="${common_labels}"/>		</th>
<th>	<fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/>	</th>
<th>	<fmt:message key="eAE.BedBayNo.label" bundle="${ae_labels}"/>	    </th>
<th>	<fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>	</th>
<th>	<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>		</th>
<th>	<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>	</th>
<% }

	 if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
	 else
		  	classValue = "QRYODD" ;

	String visit_adm_date_time = rs.getString("visit_adm_date_time");
	String clinic_name	= rs.getString("clinic_name");
	String patient_id = rs.getString("patient_id");
	String patient_name = rs.getString("patient_name");
	String encounter_id = rs.getString("encounter_id");
	String treatment_area_desc = rs.getString("TREATMENT_AREA_DESC");
	String assign_bed_num = rs.getString("AE_BED_NO");
	

	if(visit_adm_date_time == null)			visit_adm_date_time	=	"";
	if(clinic_name == null)					clinic_name		=	"";
	if(patient_id == null)					patient_id		=	"";
	if(patient_name == null)				patient_name	=	"";
	if(encounter_id == null)				encounter_id	=	"";
	if(treatment_area_desc == null)			treatment_area_desc	=	"&nbsp;";
	if(assign_bed_num == null)			    assign_bed_num	=	"&nbsp;";



	out.println("<tr><td class='" + classValue + "' width='10%'><font size=1>");
	out.println(DateUtils.convertDate(visit_adm_date_time,"DMYHM","en",locale)+"</td><td class='" + classValue + "'width='12%'><font size=1>");
	out.println(clinic_name+"</td><td class='" + classValue + "' width='8%'><font size=1>");
	out.println(treatment_area_desc+"</td><td class='" + classValue + "' width='8%'><font size=1>");
	out.println(assign_bed_num+"</td><td class='" + classValue + "' width='8%'><font size=1>");
    out.println("<a  href='javascript:CallViewPatSecondaryDetails(\""+patient_id+"\",\""+ encounter_id+"\",\""+visit_adm_date_time+"\");'>");
	out.println(encounter_id+"&nbsp;</td><td class='" + classValue + "' width='5%'><font size=1>");
	out.println(patient_id+"</td><td class='" + classValue + "' width='12%'><font size=1>");
	out.println(patient_name+"</td>");
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
	<%}%>
 </tr>
</table>
</div>
<br>
<%   
if(stmt!=null)	stmt.close();
if(rs!=null)	rs.close();
 }catch(Exception e)
     {
			e.printStackTrace();
     }
	finally   
	{
		out.println("<script>parent.frames[1].document.forms[0].search.disabled = false</script>");
	    ConnectionManager.returnConnection(con,request);
    } 
%>
</form>
</BODY>
</HTML>

