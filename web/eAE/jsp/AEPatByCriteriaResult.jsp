<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,webbeans.eCommon.*,com.ehis.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script> 
<script language='javascript' src='../../eAE/js/AEPatientByCriteria.js'></script> 
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
try{
String sql_query			= request.getParameter("sql_query");
String contact_no			= request.getParameter("contact_no");
String facilityId 			= (String) session.getValue( "facility_id" ) ;
String from 				= request.getParameter("from") ;
String to 					= request.getParameter("to") ;
String patient_id			= "";
int p_rec_cnt				= 0;
String locale				= (String)session.getAttribute("LOCALE");
%>

<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>

<%  
	int start = 0 ;
	int end = 0 ;
	int i=1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 12 ;
	else
		end = Integer.parseInt( to ) ;   

		Connection con = null;		
		Statement stmt=null;
		ResultSet rs=null;

	try
	{
      con =  ConnectionManager.getConnection(request);
	  String strsql2="";

		if(contact_no != null && !contact_no.equals("")){

			strsql2="select a.encounter_id,a.patient_id, decode('"+locale+"', 'en', b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name, to_char(b.date_of_birth,'dd/mm/yyyy') date_of_birth, b.sex,to_char(a.queue_date,'dd/mm/yyyy hh24:mi') visit_adm_date_time, a.queue_date order_adm_date_time,OP_GET_DESC.OP_CLINIC(a.FACILITY_ID, a.LOCN_CODE,'"+locale+"','1') clinic_name,nvl((AM_GET_DESC.AM_DISPOSITION_TYPE(DISPOSITION_TYPE,'"+locale+"','1')),'&nbsp;')disp_desc,AM_GET_DESC.AM_SERVICE(service_code,'"+locale+"','2') service_desc,a.queue_status visit_status_desc,a.episode_id,a.op_episode_visit_num from op_patient_queue a, mp_patient b,ae_pat_related_contacts c where a.facility_id='"+facilityId+"' and a.patient_class = 'EM' and a.patient_id = b.patient_id "+sql_query+" and a.facility_id= c.facility_id(+) and a.encounter_id=c.encounter_id(+) and c.res1_tel_no='"+contact_no+"'  order by patient_id,order_adm_date_time desc"; 
		   
		}
		else
			strsql2="select a.encounter_id,a.patient_id,decode('"+locale+"', 'en', b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name, to_char(b.date_of_birth,'dd/mm/yyyy') date_of_birth, b.sex, to_char(a.queue_date,'dd/mm/yyyy hh24:mi') visit_adm_date_time, a.queue_date order_adm_date_time, OP_GET_DESC.OP_CLINIC(a.FACILITY_ID, a.LOCN_CODE,'"+locale+"','1') clinic_name, AM_GET_DESC.AM_SERVICE(service_code,'"+locale+"','2') service_desc,a.queue_status visit_status_desc, a.episode_id, a.op_episode_visit_num, nvl((AM_GET_DESC.AM_DISPOSITION_TYPE(DISPOSITION_TYPE,'"+locale+"','1')),'&nbsp;')disp_desc from op_patient_queue a, mp_patient b where a.facility_id='"+facilityId+"' and a.patient_class = 'EM' and a.patient_id = b.patient_id "+sql_query+" order by patient_id,order_adm_date_time desc"; 

		stmt = con.createStatement();
		//if(contact_no != null && !contact_no.equals(""))
			//pstmt.setString(1,contact_no);	
		rs = stmt.executeQuery(strsql2.toString()); 
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
	out.println("<A HREF='../../eAE/jsp/AEPatByCriteriaResult.jsp?from="+(start-12)+"&to="+(end-12)+"&sql_query="+URLEncoder.encode(sql_query)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

	if (endOfRes.equals("1"))
	out.println("<A id='nextvalue' HREF='../../eAE/jsp/AEPatByCriteriaResult.jsp?from="+(start+12)+"&to="+(end+12)+"&sql_query="+URLEncoder.encode(sql_query)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>"); 
	
	%>
</td>
</tr>
</table>
</p>
<br><br>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th> &nbsp;  </th>
<th><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>		</th>
<th><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>	</th>
<th><fmt:message key="Common.Location.label" bundle="${common_labels}"/>		</th>
<th><fmt:message key="Common.service.label" bundle="${common_labels}"/>			</th>
<th><fmt:message key="Common.VisitStatus.label" bundle="${common_labels}"/>	</th>
<th><fmt:message key="Common.Disposition.label" bundle="${common_labels}"/>		</th>
<% }

	 if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
	 else
		  	classValue = "QRYODD" ;
	
	String encounter_id = rs.getString("encounter_id");
	patient_id	= rs.getString("patient_id");
	String patient_name = rs.getString("patient_name");
	String age	=	rs.getString("date_of_birth");
	String clinic_name	= rs.getString("clinic_name");
	String service_desc = rs.getString("service_desc");
	String visit_status = rs.getString("visit_status_desc");
	String disposition	= rs.getString("disp_desc");
	String sex	=	rs.getString("sex");
	if(sex.equals("M"))
	 sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
	else if(sex.equals("F"))
	 sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
	else if(sex.equals("U"))
	 sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
		if(visit_status.equals("00"))
		visit_status="&nbsp;";
		if(visit_status.equals("01"))			        visit_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckedIn.label","common_labels");
		if(visit_status.equals("02"))                  visit_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.AssignedtoTreatmentArea.label","ae_labels");		
		if(visit_status.equals("03"))						visit_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.UndergoingTreatment.label","ae_labels");
		if(visit_status.equals("04"))
		visit_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ConsultationInProgress.label","op_labels");	
		if(visit_status.equals("07"))		visit_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckOut.label","common_labels");
		if(visit_status.equals("09"))
		visit_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.Autoclosed.label","ae_labels");
	if(visit_status.equals("99"))    visit_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");
	
	String viewstring=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels");
    viewstring=viewstring+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientDetails.label","common_labels");
	String param ="javascript:viewpatdet('"+patient_id+"','"+encounter_id+"')";
	out.println("<tr><td class='" + classValue + "'><font size=1>");
	out.println("<a title='"+viewstring+"' href="+param+">+</a></td><td class='"+classValue+"' nowrap><font size=1>");
	String visit_adm_date_time = rs.getString("visit_adm_date_time");
	visit_adm_date_time=DateUtils.convertDate(visit_adm_date_time,"DMYHM","en",locale);
	out.println(visit_adm_date_time+"</td><td class='" + classValue + "' nowrap><font size=1>");

	out.println(patient_name+","+DateUtils.convertDate(age,"DMY","en",locale)+","+sex+"</td><td class='" + classValue + "' nowrap><font size=1>");
	out.println(patient_id+"</td><td class='" + classValue + "' nowrap><font size=1>");
	out.println(encounter_id+"</td><td class='" + classValue + "' nowrap><font size=1>");
	
	out.println(clinic_name+"</td><td class='" + classValue + "' nowrap><font size=1>");
	
	service_desc	= (service_desc== null) ? "" :service_desc;
	out.println(service_desc+"</td><td class='" + classValue + "' nowrap><font size=1>");
	
	if( ! (visit_status ==null || visit_status.equals("") ) )
	out.println(visit_status+"</td><td class='" + classValue + "' nowrap><font size=1>");
	else
	out.println("&nbsp;</td><td class='" + classValue + "' nowrap><font size=1>");
	
	disposition	=  ( disposition == null  ) ? "":disposition;
	out.println(disposition+"</td>");
	i++;
	p_rec_cnt++;
	cnt++;
 }//endwhile        
 if(cnt==0)
	 out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));parent.frames[1].document.forms[0].search.disabled = false;;</script>");
 if(!rs.next()&&cnt!=0){
	endOfRes="0";%>
	<script>
		document.getElementById('nextvalue').innerHTML=" ";
	</script>
	<%}
 %>
</tr>
</table>
<%    
if(rs!=null)		rs.close();
if(stmt!=null)	stmt.close();
 }catch(Exception e)
     {
		//e.toString();
		//out.println(e.toString());
		e.printStackTrace();
     }
	finally   
	{
		out.println("<script>parent.frames[1].document.forms[0].search.disabled = false</script>");
		 
		 if(con!=null)
		 ConnectionManager.returnConnection(con,request);
    }  

	
%>

</body>
</html>
<%
}
catch(Exception e) {/* out.println("main"+e); */ e.printStackTrace(); }
finally
{
	out.println("<script>parent.frames[1].document.forms[0].search.disabled = false</script>");
}
%>

