<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");

	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<%
    String url1 = "../../eOP/jsp/QPVpline.jsp?" ;
    String url2 = "../../eCommon/html/blank.html" ;
    String blnk = request.getParameter("blnk") ;
    
    if(blnk.equals("N")) {

    String openEpisode = request.getParameter("openEpisode");
    if(openEpisode == null) openEpisode="";
  
    String patid=request.getParameter("patid");
    String mrnno=request.getParameter("mrnno");
    String dtfrm=request.getParameter("dtfrm");
    String dtto=request.getParameter("dtto");
    String serv=request.getParameter("serv");
    String loc=request.getParameter("loc");
    String pract=request.getParameter("pract");
    String srch=request.getParameter("srch");
	//String Facility_Id = (String) session.getValue("facility_id");
	
	String episode_id=request.getParameter("episode_id");
	
	String service_code = request.getParameter("service_code");
	//String episode_no = request.getParameter("episode_no");
	String user_id = request.getParameter("user_id");
	String speciality_id = request.getParameter("speciality_id");
	
	//if(episode_no==null) episode_no="";
	if(user_id==null) user_id="";
	if(speciality_id==null) speciality_id="";
	if(mrnno==null) mrnno="";
	if(dtfrm==null) dtfrm="";
	if(dtto==null) dtto="";
	if(serv==null) serv="";
	if(loc==null) loc="";
	if(pract==null) pract="";
	if(episode_id==null) episode_id="";
	if(service_code==null)	service_code = "";
	
	/*StringBuffer where_criteria = new StringBuffer();
	String and_yn = "";
	Connection conn = null ;
	Statement stmt=null;
	ResultSet rset=null;*/

try
{
	//conn  =  ConnectionManager.getConnection(request);
	//stmt = conn.createStatement();

	//StringBuffer sql =new StringBuffer();
	//String FromDateTime = "";
	//String ToDateTime = "";
	//String extra_criteria = "";
	String source1 ="";
	String source2 ="";

	/*	if (!patid.equals(""))
		{
			where_criteria.append("patient_id = '"+patid+"'" );
			and_yn = " and ";
		}
		// MRN
		if (!mrnno.equals(""))
		{
			where_criteria.append(and_yn).append( " patient_id in(select patient_id from mr_pat_file_index  where facility_id='"+Facility_Id+"' and file_no ='"+mrnno+"')" );
			and_yn = " and ";
		}
		// Date From
		if (!dtfrm.equals(""))
		{
			where_criteria.append(and_yn).append("trunc(visit_adm_date_time) >= to_date('"+dtfrm+"','dd/mm/yyyy')" );
			and_yn = " and ";
		}
		// To
		if (!dtto.equals(""))
		{
			where_criteria.append(and_yn) .append("trunc(visit_adm_date_time) <= to_date('"+dtto+"','dd/mm/yyyy')" );
			and_yn = " and ";
		}
		// Service
		if (!serv.equals(""))
		{
			where_criteria.append(and_yn ).append( "service_code ='"+ serv +"'" );
			and_yn      = " and ";
		}
		// Clinic
		if (!loc.equals(""))
		{
			where_criteria.append(and_yn ).append("assign_care_locn_code ='"+loc+"'");
			and_yn      = " and ";
		}
		// Practitioner
		if (!pract.equals(""))
		{
			where_criteria.append(and_yn).append( "attend_practitioner_id='"+pract+"'" );
			and_yn      = " and ";
		}
		if (episode_id != null && !episode_id.equals(""))
		{
			where_criteria.append( and_yn).append( "episode_id >= "+episode_id+" " );
			and_yn      = " and ";
		}
	//out.println("service_code"+service_code);
	if(!service_code.equals(""))
	{
		
	   sql.append("Select to_char(queue_date,'dd/mm/yyyy hh24:mi') from_date,to_char(queue_date,'dd/mm/yyyy hh24:mi') to_date, queue_date visit_adm_date_time ");
		sql.append(" from OP_PATIENT_QUEUE  ");
		sql.append(" where facility_id = '"+Facility_Id+"' and patient_class = 'OP' ");
		sql.append( " and service_code = '"+service_code+"' and patient_id = '"+patid+"' ");
		sql.append(" and episode_id = "+episode_id+" ");
		sql.append(" order by queue_date ");
		rset = stmt.executeQuery(sql.toString());

		if(rset != null)
		{
			if(rset.next())
			{
				FromDateTime = rset.getString(1);
			}
		}
		
		if(FromDateTime == null)	FromDateTime = "";

		if(rset != null) rset.close();

		sql.setLength(0);
		
		sql.append("Select to_char(queue_date,'dd/mm/yyyy hh24:mi') to_date,queue_date  visit_adm_date_time ");
		sql.append(" from OP_PATIENT_QUEUE  ");
		sql.append(" where facility_id = '"+Facility_Id+"'  and patient_class = 'OP' ");
		sql.append(" and service_code = '"+service_code+"' and patient_id = '"+patid+"' ");
		sql.append( " and episode_id > "+episode_id+" and visit_type_ind = 'F' ");
		sql.append( " order by queue_date ");
		rset = stmt.executeQuery(sql.toString());
		if(rset != null)
		{
			if(rset.next())
			{
				ToDateTime = rset.getString(1);
			}
		}
		if(ToDateTime == null)	ToDateTime = "";

		if(rset != null) rset.close();

		sql.setLength(0);
		
		if(!FromDateTime.equals(""))
			extra_criteria = " and visit_adm_date_time between to_date('"+FromDateTime+"','dd/mm/yyyy hh24:mi') and nvl(to_date('"+ToDateTime+"','dd/mm/yyyy hh24:mi'),sysdate) and service_code = '"+service_code+"' ";
	}

	sql.setLength(0); */

	//int maxRecord = 0;
	
    /*sql.append("select count(*) as total from Pr_Search_visit_vw ");
    sql.append("where facility_id = '"+Facility_Id+"' and nvl(level_of_care_ind,'XX') ='A' and ").append(where_criteria).append(extra_criteria);
   // out.println(sql.toString());
	rset = stmt.executeQuery(sql.toString());
	rset.next();
	maxRecord = rset.getInt("total");

	if(rset != null) rset.close();

	sql.setLength(0);
		
	if(maxRecord == 0)
	{				
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>"); */
	%>
<!--		<script>parent.frames[0].document.forms[0].search_button.disabled=false;</script>
		<!--//;-->
		<%
 //	 }
//	else
//	 {  

	    String params1="blnk="+blnk+"&patid="+patid+"&mrnno="+mrnno+"&dtfrm="+dtfrm+"&dtto="+dtto+"&serv="+serv+"&loc="+loc+"&pract="+pract+"&openEpisode="+openEpisode+"&speciality_id="+speciality_id+"&user_id="+user_id+"&episode_id="+episode_id;
		String params2 = "";
		source1 = url1 + params1;
    
		if((srch != null) && (!srch.equals(""))) {
        url2 = "../../eOP/jsp/QPVvisits.jsp?";
        params2 = params1; 
		}
		source2 = url2 + params2;
	
 
%>

<iframe name='pline_frame' id='pline_frame' src="../../eCommon/html/blank.html" frameborder=0 scrolling='no' noresize style='height:25vh;width:100vw'></iframe>
    <iframe name='result_frame' id='result_frame' src=<%=source2%> frameborder=0 noresize style='height:65vh;width:100vw'></iframe>

<form>
<input type='hidden' name='params1' id='params1' value='<%=params1%>'>
</form>
<%
//	}
  
  //if(rset != null) rset.close();
  //if(stmt != null) stmt.close();

}catch(Exception e){out.println("Excep Result:"+e);}

	finally{
		try
		{
			//if(rset!=null) rset.close();
			//if(stmt != null) stmt.close();
		}catch(Exception e){}
	
	//if(conn!=null) ConnectionManager.returnConnection(conn,request);
	
	 }
%>
</html>

<% } %>

