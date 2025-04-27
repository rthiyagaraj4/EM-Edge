<!DOCTYPE html>

<%--
	FileName	: SubserviceinfacilityQueryResult.jsp
	Version	    : 3	
	Modified On	: 21-2-2005
--%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>


<%
out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'   class='CONTENT' >");
request.setCharacterEncoding("UTF-8");	
String whereClause = request.getParameter("whereclause");

StringBuffer sql=new StringBuffer("");
String from = request.getParameter( "from" ) ;
String to = request.getParameter( "to" ) ;



   if ( (whereClause == null || whereClause.equals("")) )
     {
	sql.setLength(0);
	sql.append("");
		 	
	String operating_facility_id = request.getParameter("operating_facility_id");
	if(operating_facility_id==null) operating_facility_id="";
	
	String facility_name 	     = request.getParameter("facility_name");
	if(facility_name==null) facility_name="";
	
	String service_code	     =request.getParameter("service_code");
	if(service_code==null) service_code="";
	
	String service_long_desc     =request.getParameter("service_long_desc");
	if(service_long_desc==null) service_long_desc="";
	
	String service_short_desc    =request.getParameter("service_short_desc");
	if(service_short_desc==null) service_short_desc="";
	
	String subservice_code	     =request.getParameter("subservice_code");
	if(subservice_code==null) subservice_code="";
	
	String subservice_short_desc =request.getParameter("subservice_short_desc");	
	if(subservice_short_desc==null) subservice_short_desc="";
	
	String dept_code	     =request.getParameter("dept_code");
	if(dept_code==null) dept_code="";
	
	String dept_short_desc	     =request.getParameter("dept_short_desc");
	if(dept_short_desc==null) dept_short_desc="";
	
	String section_code	     =request.getParameter("section_code");
	if(section_code==null) section_code="";
	
	String section_short_desc     =request.getParameter("section_short_desc");
	if(section_short_desc==null) section_short_desc="";
	
	String enabled 		     = request.getParameter("eff_status");
	if(enabled==null) enabled="";
	
	int andCheck = 0;
	
	
	//out.println(operating_facility_id +"  "+ service_code +"  "+  subservice_code+"  "+ section_code+"  "+  facility_name+"  "+ service_short_desc+"  "+  subservice_short_desc+"  "+  section_short_desc+"  "+  dept_code+"  "+  dept_short_desc);

	if ( !(operating_facility_id == null || operating_facility_id.equals("")) )
		{
		sql.setLength(0);
		sql.append("where upper(operating_facility_id) like upper('"+operating_facility_id+"%')");
		andCheck = 1;
		}
	
	
	if ( !(facility_name == null || facility_name.equals("")) )
		   {
			if ( andCheck == 1 )
			{	
				sql.append(" and ");
				sql.append("upper(facility_name)  like  upper('"+facility_name+"%') " );
			}
			else
			{
				sql.append("where upper(facility_name)  like upper('"+facility_name+"%') " );
				andCheck = 1;
			}
	 }
	 	
	
	if ( !(service_code == null || service_code.equals("")) )
		   {
			if ( andCheck == 1 )
			{	sql.append(" and ");
				sql.append("upper(service_code) like  upper('"+service_code+"%')" );
			}
			else
			{
				sql.setLength(0);
				sql.append("where upper(service_code) like upper('"+service_code+"%')" );
				andCheck = 1;
			}
		 }


	if ( !(service_short_desc == null || service_short_desc.equals("")) )
		   {
			if ( andCheck == 1 )
			{	sql.append(" and ");
				sql.append("upper(service_short_desc)  like  upper('"+service_short_desc+"%') " );
			}
			else
			{
				sql.setLength(0);
				sql.append("where upper(service_short_desc)  like upper('"+service_short_desc+"%') " );
				andCheck = 1;
			}
		 }
	
		
	if ( !(subservice_code == null || subservice_code.equals("")) )
	   {
		if ( andCheck == 1 )
		{	sql.append(" and ");
			sql.append("upper(subservice_code) like  upper('"+subservice_code+"%')" );
		}
		else
		{
			sql.setLength(0);
			sql.append("where upper(subservice_code) like upper('"+subservice_code+"%')" );
			andCheck = 1;
		}
	 }
	 
		
	if ( !(subservice_short_desc == null || subservice_short_desc.equals("")) )
	   {
		if ( andCheck == 1 )
		{	sql.append(" and ");
			sql.append("upper(subservice_short_desc)  like  upper('"+subservice_short_desc+"%') " );
		}
		else
		{
			sql.setLength(0);
			sql.append("where upper(subservice_short_desc)  like upper('"+subservice_short_desc+"%') " );
			andCheck = 1;
		}
	 }
			
	

       	if ( !(dept_code == null || dept_code.equals("")) )
	   {
		if ( andCheck == 1 )
		{	sql.append(" and ");
			sql.append("upper(dept_code) like  upper('"+dept_code+"%')" );
		}
		else
		{
			sql.setLength(0);
			sql.append("where upper(dept_code) like upper('"+dept_code+"%')" );
			andCheck = 1;
		}
	 }
	 
	 if ( !(dept_short_desc == null || dept_short_desc.equals("")) )
	    {
	 	if ( andCheck == 1 )
	 	{	sql.append(" and ");
	 		sql.append(" upper(dept_short_desc) like  upper('"+dept_short_desc+"%') " );
	 	}
	 	else
	 	{
			sql.setLength(0);
	 		sql.append("where upper(dept_short_desc)  like upper('"+dept_short_desc+"%') " );
	 		andCheck = 1;
	 	}
	    }
	 

	if ( !(section_code == null || section_code.equals("")) )
	    {
		 if ( andCheck == 1 )
			 {
			 sql.append(" and ");
				sql.append("upper(section_code) like  upper('"+section_code+"%')" );
			}
		else
			{
			sql.setLength(0);
				sql.append("where upper(section_code) like upper('"+section_code+"%')" );
				andCheck = 1;
			}
	}
	
	
	if ( !(section_short_desc == null || section_short_desc.equals("")) )
	    {
		 if ( andCheck == 1 )
			{	sql.append( " and ");
				sql.append("upper(section_short_desc)  like  upper('"+section_short_desc+"%') " );
			}
		else
			{
			sql.setLength(0);
				sql.append("where upper(section_short_desc)  like upper('"+section_short_desc+"%') " );
				andCheck = 1;
			}
	}



	if ( !(enabled == null || enabled.equals("")) )
	{
	   if ( enabled.equals("E") )
	        {
		if ( andCheck == 0 )
				{
			sql.setLength(0);
			sql.append("where eff_status='E'");
				}
		else
			sql.append(" and eff_status='E'");
		}
	   if ( enabled.equals("D") )
		{
		if ( andCheck == 0 )
			{
			sql.setLength(0);
			sql.append(" where  eff_status='D'");
			}
		else
			sql.append( " and eff_status='D'");
		}
	   if ( enabled.equals("B") )
	   	{
	   	//out.println(sql );

	   	// sql = sql; nothing is added to get both E and D
		}
	}
	
		
	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");

	if ( !(ord == null || ord .equals("")) )
	{
		sql.append(" order by ");

		for ( int i=0;i < ord.length;i++ )
	 	{
	 	if ( i == ord.length - 1 )
			sql.append(ord[i]);
		else
			sql.append(ord[i]+",");
		}
	}
	} //end of where clause IF
	else{
		sql.setLength(0);
		sql.append(whereClause);

	}
        
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
		
Connection conn = null;
Statement stmt =null;
// ResultSet rset =null;
ResultSet rs = null;

int maxRecord = 0;

try{
conn = ConnectionManager.getConnection(request);
stmt = conn.createStatement();


String strsql2="select * from am_facility_subsrvc_vw "+sql;
if(rs!=null)rs.close();
rs = stmt.executeQuery(strsql2);

if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
		rs.next() ;
	  }

while ( i<=end && rs.next())
	   {
	if(maxRecord==0)
	{

%>

<p>
<table align='right'>
<tr>
<%
if ( !(start <= 1) )
	out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/SubserviceinfacilityQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

//if ( !( (start+14) > maxRecord ) )
	out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eAM/jsp/SubserviceinfacilityQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");

%>
</tr>
</table>
</p><br><br>
<table border="1" width="200%" cellspacing='0' cellpadding='0'>

<th class='columnheader'><fmt:message key="Common.facility.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.identification.label" bundle="${common_labels}"/></th>

<th class='columnheader'><fmt:message key="Common.facility.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.name.label" bundle="${common_labels}"/></th>

<th class='columnheader'><fmt:message key="Common.service.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></th>

<th class='columnheader'><fmt:message key="Common.service.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></th>

<th class='columnheader'><fmt:message key="eAM.SubServiceCode.label" bundle="${am_labels}"/></th>

<th class='columnheader'><fmt:message key="Common.subservice.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></th>

<th class='columnheader'><fmt:message key="Common.acctdept.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></th>

<th class='columnheader'><fmt:message key="Common.acctdept.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></th>

<th class='columnheader'><fmt:message key="Common.Section.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></th>

<th class='columnheader'><fmt:message key="Common.SectionDescription.label" bundle="${common_labels}"/></th>

<th class='columnheader'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>


<% }
	
	  String classValue = "" ;
	  
	        if ( i % 2 == 0 )
			  	classValue = "QRYEVEN" ;
			  else
			  	classValue = "QRYODD" ;
			  

		out.println("<tr><td class='" + classValue + "'>");
		String code = rs.getString("operating_facility_id");	
		String servicecode1=rs.getString("service_code");
		//String servicedesc=rs.getString("service_short_desc");
		String deptcode1=rs.getString("dept_code");
		String subservice=rs.getString("subservice_code");
		//String facilityname=rs.getString("facility_name");
		
		out.println("<a href='../../eAM/jsp/addModifySubserviceinFacility.jsp?facility_id="+ code +"&service_code="+servicecode1+"&dept_code="+deptcode1+"&subservice_code="+subservice+"&source=modify "+"'target='f_query_add_mod' >");
			
		out.println(code+"</a></td><td class='" + classValue + "'>");
		
		
		//out.println("<a href='../../eAM/jsp/addModifySubserviceinFacility.jsp?facility_id="+ code +"&service_code="+servicecode1+"&dept_code="+deptcode1+"&subservice_code="+subservice+"&source=modify "+"'target='f_query_add_mod' >");
		out.println( rs.getString("facility_name") );
		out.println("</td><td class='" + classValue + "'>");
		
		
		
		//out.println("<a href='../../eAM/jsp/addModifySubserviceinFacility.jsp?facility_id="+ code +"&service_code="+servicecode1+"&dept_code="+deptcode1+"&subservice_code="+subservice+"&source=modify "+"'target='f_query_add_mod' >");
		out.println( rs.getString("service_code") );
		out.println("</td><td class='" + classValue + "'>");
		
		
		//out.println("<a href='../../eAM/jsp/addModifySubserviceinFacility.jsp?facility_id="+ code +"&service_code="+servicecode1+"&dept_code="+deptcode1+"&subservice_code="+subservice+"&source=modify "+"' target='f_query_add_mod' >");
		out.println( rs.getString("service_short_desc") );
		out.println("</td><td class='" + classValue + "'>");
		
		
		//out.println("<a href='../../eAM/jsp/addModifySubserviceinFacility.jsp?facility_id="+ code +"&service_code="+servicecode1+"&dept_code="+deptcode1+"&subservice_code="+subservice+"&source=modify "+"'target='f_query_add_mod' >");
		out.println( rs.getString("subservice_code") );
		out.println("</td><td class='" + classValue + "'>");
		
		
		//out.println("<a href='../../eAM/jsp/addModifySubserviceinFacility.jsp?facility_id="+ code +"&service_code="+servicecode1+"&dept_code="+deptcode1+"&subservice_code="+subservice+"&source=modify "+"'target='f_query_add_mod' >");
		//out.println( rs.getString("facility_name") );
		//out.println("</a></td><td class='" + classValue + "'>");
		
		
		//out.println("<a href='../../eAM/jsp/addModifySubserviceinFacility.jsp?operating_facility_id="+ code + "' target='f_query_add_mod' >");
		out.println( rs.getString("subservice_short_desc") );
		out.println("</td><td class='" + classValue + "'>");
		
		out.println( rs.getString("dept_code") );
		out.println("</td><td class='" + classValue + "'>");
		
		out.println( rs.getString("dept_short_desc") );
		out.println("</td><td class='" + classValue + "'>");
		
		String sec_code = rs.getString("section_code");
		String sec_desc = rs.getString("section_short_desc");
		if(sec_code == null || sec_code.equals("null"))  sec_code = "&nbsp;";
		if(sec_desc == null || sec_desc.equals("null"))  sec_desc = "&nbsp;";
		//out.println("<a href='../../eAM/jsp/addModifySubserviceinFacility.jsp?operating_facility_id="+ code + "' target='f_query_add_mod' >");
		out.println( sec_code );
		out.println("</td><td class='" + classValue + "'>");
		out.println( sec_desc );
		//out.println("<a href='../../eAM/jsp/addModifySubserviceinFacility.jsp?operating_facility_id="+ code + "' target='f_query_add_mod' >");
		//out.println("</td><td class='" + classValue + "'>");		
			
		out.println("</td><td align='center' class='" + classValue + "'>");
		
		if ( rs.getString("eff_status").equals("E") )
			out.println("<img src='../../eCommon/images/enabled.gif'></img>");
		else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
		i++;
		maxRecord++;
	   }  // end of while

if(maxRecord == 0)
{ %>
			 <script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>
<% }

if ( maxRecord < 14 || (!rs.next()) ) {
%>
	<script >
	if (document.getElementById('next'))
		document.getElementById('next').style.visibility='hidden';
	</script>
<% 
		} else {%>
	<script >
	if (document.getElementById('next'))
		document.getElementById('next').style.visibility='visible';
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%}

}// end of try
catch(Exception e) { out.println(e.toString());}

finally {
  if (rs != null)   rs.close();
  if (stmt != null) stmt.close();
  
  
   	ConnectionManager.returnConnection(conn,request);
}


	  
%>

</td></tr>
</table>
<br><center>
<!--%
if ( !(start <= 1) )
	out.println("<A HREF='../../eAM/jsp/SubserviceinfacilityQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'><img src='../../eCommon/images/previous.gif' alt='Previous' border='0'></A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='../../eAM/jsp/SubserviceinfacilityQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'><img src='../../eCommon/images/next.gif' alt='Next' border='0'></A>");

rs.close();

%-->

</center>
</BODY>
</HTML>

