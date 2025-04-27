<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*,java.util.*,java.net.*,java.text.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<%
	request.setCharacterEncoding("UTF-8");
	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></head><BODY  class='CONTENT' onLoad='ClearMsg()' onMouseDown='CodeArrest()' onKeyDown='lockKey()' >");
	String facilityId		= (String) session.getValue( "facility_id" ) ;
	String whereClause		= request.getParameter("whereclause");

	StringBuffer sql	= new StringBuffer();				//Variable that holds where clause for that's dynamically constructed
	String from			= request.getParameter( "from" ) ;	//Variable that contains the number from which the display of the record starts
	String to			= request.getParameter( "to" ) ;	//Variable that contains the number from which the display of the record ends
	String nursing_unit_code	="";
	String nursing_unit_desc	="";
	String building_code		="";
	String building_desc	 	="";
	String floor_code			="";
	String floor_desc			="";

	if ( (whereClause == null || whereClause.equals("")) )
	{
		nursing_unit_code	= checkForNull(request.getParameter("nursing_unit_code"));
		nursing_unit_desc   = checkForNull(request.getParameter("nursing_unit_desc"));
		building_code		= checkForNull(request.getParameter("building_code"));
		building_desc		= checkForNull(request.getParameter("building_desc"));
		floor_code			= checkForNull(request.getParameter("floor_code"));
		floor_desc			= checkForNull(request.getParameter("floor_desc"));
		nursing_unit_code 	= nursing_unit_code.toUpperCase();
		building_code 		= building_code.toUpperCase();
		floor_code 			= floor_code.toUpperCase();
		
		/*Parameter variable definition ends here*/
		int andCheck		= 0;
		
		if(facilityId!=null && !facilityId.equals(""))
		{	
			if ( andCheck == 1 )
			{
				sql.append("and upper(facility_id) like upper('"+facilityId+"%')");
			}
			else
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("where upper(facility_id) like upper('"+facilityId+"%')");
				andCheck = 1;
			}				
		}

		if(nursing_unit_code!=null && !nursing_unit_code.equals(""))
		{				
			if ( andCheck == 1 )
			{
				sql.append("and upper(NURSING_UNIT_CODE) like upper('"+nursing_unit_code+"%')");
			}
			else
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("where upper(NURSING_UNIT_CODE) like upper('"+nursing_unit_code+"%')");
				andCheck = 1;
			}				
		}

		if(nursing_unit_desc!=null && !nursing_unit_desc.equals(""))
		{				
			if ( andCheck == 1 )
			{
				sql.append("and upper(nursing_unit_short_desc) like upper('"+nursing_unit_desc+"%')");
			}
			else
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("where upper(nursing_unit_short_desc) like upper('"+nursing_unit_desc+"%')");
				andCheck = 1;
			}				
		}

		if(building_code!=null && !building_code.equals(""))
		{				
			if ( andCheck == 1 )
			{
				sql.append("and upper(bldng_code) like upper('"+building_code+"%')");
			}
			else
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("where upper(bldng_code) like upper('"+building_code+"%')");
				andCheck = 1;
			}					
		}

		if(building_desc!=null && !building_desc.equals(""))
		{				
			if ( andCheck == 1 )
			{
				sql.append("and upper(bldng_short_desc) like upper('"+building_desc+"%')");
			}
			else
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("where upper(bldng_short_desc) like upper('"+building_desc+"%')");
				andCheck = 1;
			}				
		}

		if(floor_code!=null && !floor_code.equals(""))
		{				
			if ( andCheck == 1 )
			{
				sql.append("and upper(floor_code) like upper('"+floor_code+"%')");
			}
			else
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("where upper(floor_code) like upper('"+floor_code+"%')");
				andCheck = 1;
			}				
		}

		if(floor_desc!=null && !floor_desc.equals(""))
		{			
			if ( andCheck == 1 )
			{
				sql.append("and upper(floor_short_desc) like upper('"+floor_desc+"%')");
			}
			else
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("where upper(floor_short_desc) like upper('"+floor_desc+"%')");
				andCheck = 1;
			}				
		}

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
	}
	else
	{
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

	Connection con = null;
	Statement stmt=null;
	//ResultSet rset=null;
	ResultSet rs=null;
	int maxRecord = 0;

	try
	{
		con =ConnectionManager.getConnection(request);
		/*StringBuffer strsql1 = new StringBuffer();
		strsql1.append("select count(*) as total from ip_nursing_unit_location_vw "+sql.toString());
		stmt=con.createStatement();
		rs = stmt.executeQuery(strsql1.toString());
		rs.next();
		maxRecord = rs.getInt("total");
		stmt.close();
		rs.close();
if(maxRecord == 0)
	{
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
	}else{*/
		StringBuffer strsql2 = new StringBuffer();
		strsql2.append("select * from ip_nursing_unit_location_vw "+sql.toString());
		stmt=con.createStatement();
		rs = stmt.executeQuery(strsql2.toString());

		if ( start != 1 )
			for( int j=1; j<start; i++,j++ )
				rs.next() ;

		 while (  i<=end && rs.next())
		{
			 if (maxRecord==0)
			{
		
		%>

				<P>
				<table align='right'>
					<tr>
							<%
							if ( !(start <= 1) )
								out.println("<td align ='right' id='prev'><A HREF='../jsp/NursUnitLocnqueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

							//if ( !( (start+14) > maxRecord ) )
								out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../jsp/NursUnitLocnqueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
							%>
					</tr>
				</table>
				</P>
				<br>
				<br>
				<table border="1" width="100%" cellspacing='0' cellpadding='0'>
					<tr>
						<th><fmt:message key="Common.NursingUnitCode.label" bundle="${common_labels}"/></th>
						<th><fmt:message key="eIP.NursingUnitDescription.label" bundle="${ip_labels}"/></th>
						<th><fmt:message key="Common.building.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
						<th><fmt:message key="Common.building.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
						<th><fmt:message key="Common.FloorCode.label" bundle="${common_labels}"/></th>
						<th><fmt:message key="eAM.FloorDescription.label" bundle="${am_labels}"/></th>
					</tr>
						<%
						/*if ( start != 1 )
							 for( int j=1; j<start; i++,j++ )
								rs.next() ;*/
			}
					
					
						String classValue = "" ;

				//while ( rs.next() && i<=end )
				//{
						if ( i % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;

							nursing_unit_code			=rs.getString("nursing_unit_code");
							nursing_unit_desc			=rs.getString("nursing_unit_short_desc");
							building_code				=rs.getString("bldng_code");
							building_desc				=rs.getString("bldng_short_desc");
							floor_code					=rs.getString("floor_code");
							floor_desc					=rs.getString("floor_short_desc");
							building_code				=rs.getString("bldng_code");
						
						out.println("<tr>");
						out.println("<td class='" + classValue + "'><a  href=\"../jsp/AddModifyNursUnitPhysLocn.jsp?nursing_unit_code="+URLEncoder.encode(nursing_unit_code)+"&nursing_unit_desc="+URLEncoder.encode(nursing_unit_desc)+"&building_desc="+URLEncoder.encode(building_desc)+"&floor_desc="+URLEncoder.encode(floor_desc)+"&bldng_code="+URLEncoder.encode(building_code)+"&floor_code="+URLEncoder.encode(floor_code)+"\" target='f_query_add_mod' >");  
						out.println(nursing_unit_code+"</a></td>");

						out.print("<td class='" + classValue + "'>"+nursing_unit_desc+"</td>");

						out.print("<td class='" + classValue + "'>"+building_code+"</td>");

						out.print("<td class='" + classValue + "'>"+building_desc+"</td>");
						out.print("<td class='" + classValue + "'>"+floor_code+"</td>");
						out.print("<td class='" + classValue + "'>"+floor_desc+"</td>");
						
						out.print("</tr>");
						i++;
						maxRecord++;
		}//endwhile

		if(maxRecord == 0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}

				boolean flag = false;
				if ( maxRecord < 14 || (!rs.next()) )
					{
						%>
							<script >
							if (document.getElementById('next'))
								document.getElementById('next').style.visibility='hidden';
							</script>
						<% flag = true;
					}
					else
					{%>
							<script >
							if (document.getElementById('next'))
								document.getElementById('next').style.visibility='visible';
							</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



					<%
					}	
		//}
	}catch(Exception e)
	{
				out.print(e.toString());
	}
	finally   
	{
		try{

				if(stmt!=null) 	stmt.close();
				if(rs!=null) 		rs.close();
			}
			catch(Exception e)
				{out.println("Exception in tryCatch : "+ e.toString());}
		ConnectionManager.returnConnection(con,request); ;
	}
	%>

</td></tr>
</table>
</BODY>
</HTML>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

