<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,webbeans.eCommon.*,com.ehis.util.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eAE/js/AEPatientHistory.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

String sql_query			= request.getParameter("sql_query");
String	facilityId 			= (String) session.getValue( "facility_id" ) ;
String patient_id			= request.getParameter("patient_id");
String from 				= request.getParameter("from") ;
String to 					= request.getParameter("to") ;
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
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;   

		Connection con = null;
		java.sql.Statement stmt=null;
		ResultSet rs=null;

	try
	{
      con =  ConnectionManager.getConnection(request);
	  stmt = con.createStatement();
	  String strsql2="";

      strsql2="select encounter_id, patient_id, to_char(queue_date,'dd/mm/yyyy hh24:mi') visit_adm_date_time, queue_date order_adm_date_time, OP_GET_DESC.OP_CLINIC(FACILITY_ID, LOCN_CODE,'"+locale+"','1') clinic_name, AM_GET_DESC.AM_SERVICE(service_code,'"+locale+"','2') service_desc, queue_status visit_status_desc, nvl((AM_GET_DESC.AM_DISPOSITION_TYPE(DISPOSITION_TYPE,'"+locale+"','1')),'&nbsp;')disp_desc, AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(FACILITY_ID, LOCN_CODE,TREATMENT_AREA_CODE,'"+locale+"','2')		TREATMENT_AREA_DESC, AE_BED_NO, AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1') practitioner_name from op_patient_queue where facility_id='"+facilityId+"' and patient_class = 'EM' "+sql_query+" order by order_adm_date_time desc"; 

		rs = stmt.executeQuery(strsql2);  

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
	out.println("<A HREF='../../eAE/jsp/AEResultPatientHistory.jsp?from="+(start-14)+"&to="+(end-14)+"&sql_query="+URLEncoder.encode(sql_query)+"&patient_id="+patient_id+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

	if (endOfRes.equals("1"))
	out.println("<A id='nextvalue' HREF='../../eAE/jsp/AEResultPatientHistory.jsp?from="+(start+14)+"&to="+(end+14)+"&sql_query="+URLEncoder.encode(sql_query)+"&patient_id="+patient_id+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>"); 
	
	%>
</td>
</tr>
</table>
</p>

<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th> &nbsp;  </th>
<th>	<fmt:message key="Common.datetime.label" bundle="${common_labels}"/>	</th>
<th>	<fmt:message key="Common.Location.label" bundle="${common_labels}"/>		</th>
<th>	<fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/>	</th>
<th>	<fmt:message key="eAE.BedBayNo.label" bundle="${ae_labels}"/>	    </th>
<th>	<fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>	</th> 
<th>	<fmt:message key="Common.service.label" bundle="${common_labels}"/>			</th>
<th>	<fmt:message key="Common.VisitStatus.label" bundle="${common_labels}"/>	</th>
<th>	<fmt:message key="Common.Disposition.label" bundle="${common_labels}"/>		</th>
<th>    <fmt:message key="eAE.SecondaryTriage.label" bundle="${ae_labels}"/></th>
<% }

	 if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
	 else
		  	classValue = "QRYODD" ;
	String encounter_id= rs.getString("encounter_id");
	String param ="javascript:viewpatdet('"+patient_id+"','"+encounter_id+"')";
	out.println("<tr><td class='" + classValue + "'>");
	out.println("<a title='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ViewPatientDetails.label","mp_labels")+"' href="+param+">+</a></td><td class='"+classValue+"'>");
	String visit_adm_date_time = rs.getString("visit_adm_date_time");
visit_adm_date_time=DateUtils.convertDate(visit_adm_date_time,"DMYHM","en",locale);	out.println(visit_adm_date_time+"</td><td class='" + classValue + "'>");
	String clinic_name	= rs.getString("clinic_name");
	out.println(clinic_name+"</td><td nowrap class='" + classValue + "'>");


	String treatment_area_desc=rs.getString("TREATMENT_AREA_DESC");
	if(treatment_area_desc == null)			treatment_area_desc	=	"&nbsp;";
    out.println(treatment_area_desc+"</td><td  class='" + classValue + "'>");
	String assign_bed_num=rs.getString("AE_BED_NO");
	if(assign_bed_num == null)			    assign_bed_num	=	"&nbsp;";
    out.println(assign_bed_num+"</td><td class='" + classValue + "'>");
	String practitioner_name=rs.getString("PRACTITIONER_NAME");
	if(practitioner_name == null)			practitioner_name	=	"&nbsp;";
	out.println(practitioner_name+"</td><td class='" + classValue + "'>");


	String service_desc = rs.getString("service_desc");
	service_desc	= (service_desc== null) ? "" :service_desc;
	out.println(service_desc+"</td><td class='" + classValue + "'>");
	String visit_status = rs.getString("visit_status_desc");
	if( ! (visit_status ==null || visit_status.equals("") ) ){
	if(visit_status.equals("00"))
	visit_status="&nbsp;";
	if(visit_status.equals("01"))			        visit_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckedIn.label","common_labels");
	if(visit_status.equals("02"))                  visit_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.AssignedtoTreatmentArea.label","ae_labels");		
	if(visit_status.equals("03"))						visit_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.UndergoingTreatment.label","ae_labels");
	if(visit_status.equals("04"))	visit_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ConsultationInProgress.label","op_labels");	
	if(visit_status.equals("07"))		visit_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckOut.label","common_labels");
	if(visit_status.equals("09"))
	visit_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.Autoclosed.label","ae_labels");
	if(visit_status.equals("99"))	visit_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");
	out.println(visit_status+"</td><td class='" + classValue + "'>");
	}
	else
	out.println("&nbsp;</td><td class='" + classValue + "'>");
	String disposition	= rs.getString("disp_desc");
	disposition	=  ( disposition == null  ) ? "":disposition;
	out.println(disposition+"</td>");
	out.println("<td nowrap><a  href='javascript:CallViewPatSecondaryDetails(\""+patient_id+"\",\""+ encounter_id+"\",\""+visit_adm_date_time+"\");'>");
	out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.SecondaryTriage.label","ae_labels")+" &nbsp;</a></td>");
	i++;
   	cnt++;
 }//endwhile
  if(!rs.next()&&cnt!=0){
	endOfRes="0";%>
	<script>
		document.getElementById("nextvalue").innerHTML=" ";
	</script>
	<%}        
 %>

</td></tr>
<script>
	//parent.parent.frames[0].document.forms[0].reset.disabled=true;
</script>
</table>
<br>
<%    
if(rs!=null)	rs.close();
if(stmt!=null)	stmt.close();

 }catch(Exception e)
     {
			e.printStackTrace();
     }
	finally   
	{
		 out.println("<script>parent.parent.frames[1].document.forms[0].search.disabled = false;</script>"); 
		 
		 if(con!=null)
		 ConnectionManager.returnConnection(con,request);
    }  

	
%>

</body>
</html>

