<!DOCTYPE html>

<%@ page import ="webbeans.eCommon.*,java.sql.*,java.util.*,java.net.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></head><BODY  class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey();'>");
	String facilityId = (String) session.getValue( "facility_id" ) ;
	String whereClause = request.getParameter("whereclause");

	StringBuffer sql=new StringBuffer(); 
	String from  = request.getParameter( "from" ) ;
	String to    = request.getParameter( "to" ) ;
	int andCheck = 0;
	
	if ( (whereClause == null || whereClause.equals("")) )
	{
		
		sql.setLength(0);
		String clinic_code = request.getParameter("clinic_code");
		String clinic_desc = request.getParameter("clinic_desc");
		String dept_code = request.getParameter("dept_code");
		String dept_short_desc = request.getParameter("dept_short_desc");
		String service_code   = request.getParameter("service_code");
		String service_short_desc = request.getParameter("service_short_desc");
		
		clinic_code = clinic_code.toUpperCase();
		dept_code = dept_code.toUpperCase();
		service_code = service_code.toUpperCase();
		
		sql.append(" where facility_id  = '"+facilityId+"' ");
		andCheck=1;				
		
		if ( !(clinic_code == null || clinic_code.equals("")) )
		{
			if ( andCheck == 1 )
			{	sql.append(" and ");
				sql.append( "upper(clinic_code) like  upper('"+clinic_code+"%')" );
			}
			else
			{
				sql.append( "where upper(clinic_code) like upper('"+clinic_code+"%')" );
				andCheck = 1;
			}
		}
		
		if ( !(clinic_desc == null || clinic_desc.equals("")) )
		{
			if ( andCheck == 1 )
			{	sql.append( " and " );
				sql.append("upper(clinic_short_desc) like  upper('"+clinic_desc+"%')" );
			}
			else
			{
				sql.append( "where upper(clinic_short_desc) like upper('"+clinic_desc+"%')" );
				andCheck = 1;
			}
		 }

		
		if ( !(dept_code == null || dept_code.equals("")) )
		{		  
			if ( andCheck == 1 )
			{	sql.append( " and " );
				sql.append("upper(dept_code) like  upper('"+dept_code+"%')" );
			}
			else
			{
				sql.append( "where upper(dept_code) like upper('"+dept_code+"%')" );
				andCheck = 1;
			}		  
		}
		
		if ( !(dept_short_desc == null || dept_short_desc.equals("")) )
		{
			if ( andCheck == 1 )
			{	sql.append( " and ");
				sql.append( "upper(dept_short_desc) like  upper('"+dept_short_desc+"%')" );
			}
			else
			{
				sql.append( "where upper(dept_short_desc) like upper('"+dept_short_desc+"%')" );
				andCheck = 1;
			}
		 }

		if ( !(service_code == null || service_code.equals("")) )
		{		  
			if ( andCheck == 1 )
			{	sql.append(" and " );
				sql.append( "upper(service_code) like  upper('"+service_code+"%')" );
			}
			else
			{
				sql.append( "where upper(service_code) like upper('"+service_code+"%')" );
				andCheck = 1;
			}		  
		}
		
		if ( !(service_short_desc == null || service_short_desc.equals("")) )
		{
			if ( andCheck == 1 )
			{	sql.append( " and " );
				sql.append("upper(service_short_desc) like  upper('"+service_short_desc+"%')" );
			}
			else
			{
				sql.append( "where upper(service_short_desc) like upper('"+service_short_desc+"%')") ;
				andCheck = 1;
			}
		 }
	 
	 	String ord[] = request.getParameterValues("orderbycolumns");
	 		if ( !(ord == null || ord .equals("")) )
	 		{
	 			sql.append(" order by " );
	 
	 			for ( int i=0;i < ord.length;i++ )
	 			{
	 			if ( i == ord.length - 1 )
	 				sql.append(ord[i]);
	 			else
	 				sql.append(ord[i]).append("," );
	 			}
	 		}
	 	}
	 	else
	 	{
	 		sql.append(whereClause);
		}
	

	String endOfRes = "1";

	int start = 0 ;
	int end = 0 ;
	int i=1;
	int cnt = 0;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;

	Connection conn = null;
	Statement stmt=null;
	//ResultSet rset=null;
	ResultSet rs=null;
	//int maxRecord = 0;
	//StringBuffer  strsql1 = new StringBuffer();
	StringBuffer strsql2 = new StringBuffer();
	try{
			conn =ConnectionManager.getConnection(request); 
			stmt = conn.createStatement();
			
			/*strsql1.append("select count(*) as total from op_clinic_for_service_vw  ").append(sql) ;
			rs = stmt.executeQuery(strsql1.toString());
			rs.next();
			maxRecord = rs.getInt("total");
			
			if(rs != null) rs.close();

			if(maxRecord == 0){
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
			}else{*/
			
			strsql2.append("select  * from op_clinic_for_service_vw  ").append(sql);
			
			rs = stmt.executeQuery(strsql2.toString());

			if ( start != 1 )
				for( int j=1; j<start; i++,j++ )
					rs.next() ;
			while( i<=end && rs.next() )
			{
				if ( cnt == 0 )
				{
	%>

	<P>
	<table align='right'>
	<tr>
	<td>
	<%
	if ( !(start <= 1) )
		out.println("<A HREF='../jsp/ClinicServiceQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

	if ( endOfRes.equals("1") )
		out.println("<A id='nextval' HREF='../jsp/ClinicServiceQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
	%>
	</td>
	</tr>
	</table>
	</P>
	<br>
	<br>
	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
	<th class='columnheader'><fmt:message key="Common.Location.label" bundle="${common_labels}"/> </th>
	<th class='columnheader'><fmt:message key="Common.LocationDescription.label" bundle="${common_labels}"/></th>
	<th class='columnheader'><fmt:message key="Common.DepartmentCode.label" bundle="${common_labels}"/></th>
	<th class='columnheader'><fmt:message key="eOP.DepartmentDescription.label" bundle="${op_labels}"/></th>	
	<th class='columnheader'><fmt:message key="Common.ServiceCode.label" bundle="${common_labels}"/></th>
	<th class='columnheader'><fmt:message key="Common.ServiceDescription.label" bundle="${common_labels}"/></th>

	<%	
		}
			String classValue = "" ;
	
			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;

			String cliniccode 	    = rs.getString("clinic_code");
			String clinicshortdesc = rs.getString("clinic_short_desc");
			String deptcode	    = rs.getString("dept_code");
			String deptshortdesc   = rs.getString("dept_short_desc");
			String servicecode	    = rs.getString("service_code");
			String serviceshortdesc   = rs.getString("service_short_desc");
			
			out.println("<tr><td class='" + classValue + "'>");
			
			out.println(cliniccode+"</a></td><td class='" + classValue + "'>");
			out.println(clinicshortdesc+"</a></td><td class='" + classValue + "'>");
			out.println(deptcode+"</a></td><td class='" + classValue + "'>");
			out.println(deptshortdesc+"</a></td><td class='" + classValue + "'>");			
			out.println(servicecode+"</a></td><td class='" + classValue + "'>");
			out.println(serviceshortdesc+"</a></td><td class='" + classValue + "'>");			
		i++;
		cnt++;

	} //endwhile

	if(cnt == 0)
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
	
	if( !rs.next() && cnt!=0 )
	{
	%>
	<script>
		document.getElementById("nextval").innerHTML = " ";
	</script>

	<%
	}
	
	//strsql1.setLength(0);
	strsql2.setLength(0);
	sql.setLength(0);
	
	}catch(Exception e){ out.println(e);
		
	}	finally   
	        {
				try{
		  if(stmt!=null) stmt.close();
	      if(rs!=null) 	 rs.close();
		  //if(rset!=null) rset.close();
				}catch(Exception e){}
		  if(conn != null) ConnectionManager.returnConnection(conn,request);
		}
%>

</td></tr>
</table>
</BODY>
</HTML>

