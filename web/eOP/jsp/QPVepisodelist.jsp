<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper"  contentType="text/html; charset=UTF-8"%>
<%	request.setCharacterEncoding("UTF-8");	

request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
   <!--  <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
   <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
    <script language='javascript' src='../../eOP/js/QueryPatientVisits.js'></script>
    <Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%

	String openEpisode =request.getParameter("openEpisode");
	if(openEpisode == null) openEpisode="";
	String Facility_Id = (String) session.getValue("facility_id");
	String patid=request.getParameter("patid");
	String mrnno=request.getParameter("mrnno");
    String locale = (String) session.getValue("LOCALE");
	String dtfrm=request.getParameter("dtfrm");
	String dtto=request.getParameter("dtto");
	String serv=request.getParameter("serv");
	String loc=request.getParameter("loc");
	String pract=request.getParameter("pract");
	String mode=request.getParameter("mode");
	String episode_id=request.getParameter("episode_id");
	if(mrnno==null) mrnno="";

	if(dtfrm==null) dtfrm="";
	if(dtto==null) dtto="";
	if(serv==null) serv="";
	if(loc==null) loc="";
	if(pract==null) pract="";
	if(mode==null) mode="";
	if(episode_id==null) episode_id="";

	Connection conn = null;
	Statement stmt=null;
	ResultSet rset=null;
	StringBuffer sql=new StringBuffer();
	StringBuffer row=new StringBuffer();

	String params="patid="+patid+"&mrnno="+mrnno+"&mode="+mode+"&dtfrm="+dtfrm+"&dtto="+dtto+"&serv="+serv+"&loc="+loc+"&pract="+pract;
	StringBuffer where_criteria =new StringBuffer();
	String fld1_display = "";
	String and_yn = "";

	// patient_id 
	if (!patid.equals(""))
	{
		where_criteria.append( "patient_id = '"+patid+"'");
		and_yn = " and ";
	}
	//MRN
	if (!mrnno.equals(""))
	{
		where_criteria.append(and_yn).append( " patient_id in(select patient_id from mr_pat_file_index  where facility_id='"+Facility_Id+"' and file_no ='"+mrnno+"')");
		and_yn = " and ";
	}

	// Date From
	if (!dtfrm.equals(""))
	{
		where_criteria.append(and_yn).append("trunc(visit_adm_date_time) >= to_date('"+dtfrm+"','dd/mm/yyyy')");
		and_yn = " and ";
	}
	// To
	if (!dtto.equals(""))
	{
		where_criteria.append(and_yn).append("trunc(visit_adm_date_time) <= to_date('"+dtto+"','dd/mm/yyyy')");
		and_yn = " and ";
	}
	//Service
	if (!serv.equals(""))
	{
		where_criteria.append( and_yn).append( "service_code ='"+ serv +"'");
		and_yn      = " and ";
	}
	//Clinic
	if (!loc.equals(""))
	{
		where_criteria .append(and_yn).append( "assign_care_locn_code ='"+loc+"'");
		and_yn      = " and ";
	}
	//Practitioner
	if (!pract.equals(""))
	{
		where_criteria.append( and_yn).append("attend_practitioner_id='"+pract+"'");
		and_yn      = " and ";
	}

	if (!episode_id.equals(""))
	{
		where_criteria.append( and_yn).append("EPISODE_ID='"+episode_id+"'");
		and_yn      = " and ";
	}

try{
	conn =  ConnectionManager.getConnection(request);
	stmt=conn.createStatement();
	/*int maxRecord = 0;
	
    sql.append("select count(*) as total ");
    sql.append("from op_episode_for_service episode,am_service service,");
    sql.append( "am_subservice subservice,op_clinic clinic ");
    sql.append( "where episode.operating_facility_id='"+Facility_Id+"' ");
    sql.append( "and service.service_code(+) = episode.service_code ");
    sql.append( "and subservice.service_code(+) = episode.service_code ");
    sql.append( "and subservice.subservice_code(+) = episode.subservice_code ");
    sql.append( "and clinic.facility_id = episode.operating_facility_id "); 
    sql.append( "and clinic.clinic_code = episode.clinic_code ");
    sql.append( "and episode.patient_id = '"+patid+"' ");
   
	if(openEpisode.equals("Y"))
    sql.append( "and episode.episode_status = '01' ");
    sql.append( "and episode.episode_id in (select episode_id from pr_encounter ");
    sql.append( "where facility_id = '"+Facility_Id+"' and patient_class not in ('EM', 'IP') and ").append(where_criteria).append(")");
	
    rset = stmt.executeQuery(sql.toString());
	rset.next();
	maxRecord = rset.getInt("total");

	if(rset != null) rset.close();

	sql.setLength(0);

	if(maxRecord == 0)					
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");
	else
	{*/
	
   sql.append( "SELECT   episode.EPISODE_ID episode_id,TO_CHAR(episode.start_date_time, 'dd/mm/yyyy') st_date_time,  TO_CHAR(episode.end_date_time,'dd/mm/yyyy') end_date_time,  am_get_desc.AM_SERVICE(episode.service_code,'"+locale+"',2) ,am_get_desc.AM_SUBSERVICE(episode.service_code,episode.subservice_code,'"+locale+"',2),  op_get_desc.OP_CLINIC(OPERATING_FACILITY_ID,clinic_code,'"+locale+"',1) clinic_desc,  episode.episode_id,  episode.service_code, episode.start_date_time FROM   op_episode_for_service episode  WHERE    episode.operating_facility_id='"+Facility_Id+"' AND  episode.patient_id = '"+patid+"'" );
	
	
	/*sql.append( "select to_char(episode.start_date_time,'dd/mm/yyyy') st_date_time,");
    sql.append( "to_char(episode.end_date_time,'dd/mm/yyyy') end_date_time,");
    sql.append( "service.short_desc,subservice.short_desc, clinic.short_desc clinic_desc,");
    sql.append( "episode.episode_id, episode.service_code,  episode.start_date_time ");
    sql.append( "from op_episode_for_service episode,am_service service,");
    sql.append( "am_subservice subservice,op_clinic clinic ");
    sql.append("where episode.operating_facility_id='"+Facility_Id+"' ");
    sql.append( "and service.service_code(+) = episode.service_code ");
    sql.append( "and subservice.service_code(+) = episode.service_code ");
    sql.append("and subservice.subservice_code(+) = episode.subservice_code ");
    sql.append("and clinic.facility_id = episode.operating_facility_id "); 
    sql.append( "and clinic.clinic_code = episode.clinic_code ");
    sql.append( "and episode.patient_id = '"+patid+"' ");*/
    
    if(openEpisode.equals("Y"))
		sql.append(" and episode.episode_status = '01' ");
    
    sql.append(" and episode.episode_id in (select episode_id from pr_encounter ");
    sql.append( "where facility_id = '"+Facility_Id+"' and patient_class not in ('EM', 'IP') and ").append(where_criteria).append(" ) order by episode.start_date_time desc");
//out.println(sql.toString());
    rset = stmt.executeQuery(sql.toString());
	/*if(rset.next())
	{*///	 rset.previous();	

%>
    <%

    String classValue = "";
    String fld1="";
    String fld2="";
    String fld3="";
    String fld4="";
    String fld5="";
    String fld6="";
    String fld7="";
	String epi_id = "";
	String episode_no = "";
	
    int i = 0;

	/*if(rset != null) {*/
	int count=0;
        while(rset.next())
        {
			if(count==0)
			{%>
	<body onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
    <form name="episodetab_form" id="episodetab_form">
    <table border='0' cellpadding='0' cellspacing='0' width='95%' align='center'>
    <tr><td align='center'>
    <table border="1" width="100%" cellspacing='0' cellpadding='0' id='tb1'>
     <th class='columnheader' ><fmt:message key="eMR.EpisodeNo.label" bundle="${mr_labels}"/></th>
	<th class='columnheader' ><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></th>
    <th class='columnheader' ><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></th>
    <th class='columnheader' ><fmt:message key="Common.service.label" bundle="${common_labels}"/></th>
    <th class='columnheader'><fmt:message key="Common.subservice.label" bundle="${common_labels}"/></th>
    <th class='columnheader' ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>


			
			<%}
			count++;
            if ( i%2 == 0 )
                classValue="QRYEVEN";
            else
                classValue="QRYODD";
			episode_no=rset.getString(1);
			if(episode_no == null) episode_no=""; 

            fld1=rset.getString(2); if(fld1 == null || fld1.equals("")) fld1="";

			fld1_display=DateUtils.convertDate(fld1,"DMY","en",locale);

            fld2=rset.getString(3); if(fld2 == null || fld2.equals("")) fld2="&nbsp;";
            fld3=rset.getString(4); if(fld3 == null || fld3.equals("")) fld3="&nbsp;";
            fld4=rset.getString(5); if(fld4 == null || fld4.equals("")) fld4="&nbsp;";
            fld5=rset.getString(6); if(fld5 == null || fld5.equals("")) fld5="&nbsp;";
            fld6=rset.getString(7); if(fld6 == null || fld6.equals("")) fld6="&nbsp;";
            fld7=rset.getString(8); if(fld7 == null || fld7.equals("")) fld7="&nbsp;";
			if (epi_id.equals(""))
	            epi_id = fld6;
			else
				epi_id = fld6 + "$" +epi_id;
            row.append("<tr>");
			row.append("<td  width='10%'   class='" + classValue + "'>" + episode_no + "</td>");
            row.append("<td   width='10%'  class='" + classValue + "'>");
            row.append("<a href = javascript:dispvisit('"+params+"','"+epi_id+"','"+fld7+"')>" + fld1_display + "</td>");
            row.append("<td  width='10%'   class='" + classValue + "'>" + fld2 + "</td>");
            row.append("<td   width='20%'  class='" + classValue + "'>" + fld3 + "</td>");
            row.append("<td   width='20%'  class='" + classValue + "'>" + fld4 + "</td>");
            row.append("<td   width='20%'  class='" + classValue + "'>" + fld5 + "</td></tr>");

            out.print(row.toString());
			row.setLength(0);
    		epi_id = fld6;
            i++;
        }
      /*}
	/*}
	else*/
	if(count==0)
	{	
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");
	}

	if(rset != null) rset.close();
	if(stmt != null) stmt.close();
	sql.setLength(0);
	row.setLength(0);

}
catch(Exception e){out.println("Excep EPISODE:"+e);
}
finally
{
	try{
		if(stmt!=null) stmt.close();
		if(rset!=null)rset.close();
	}catch(Exception e) {}
	if(conn!=null) ConnectionManager.returnConnection(conn,request);
}
    %>

   </table>
   </td></tr>
   </table>
<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
</form>
</body>
</html>


