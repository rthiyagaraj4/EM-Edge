<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*,java.util.*,java.net.*,java.text.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>


<%
	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT' onLoad='ClearMsg()' onMouseDown='CodeArrest()' onKeyDown='lockKey()' >");


	request.setCharacterEncoding("UTF-8");

	String facilityId	= (String) session.getValue( "facility_id" ) ;
	String whereClause	= request.getParameter("whereclause");

	StringBuffer sql = new StringBuffer();
	//Variable that holds where clause for that's dynamically constructed
	String from	= request.getParameter( "from" ) ;		
	//Variable that contains the number from which the display of the record starts
	String to = request.getParameter( "to" ) ;		
	//Variable that contains the number from which the display of the record ends
	String  nursing_unit_code		="";
	String  nursing_short_desc		="";
	String bed_class_code			="";
	String bed_class_short_desc		="";
	String bed_type_code			="";
	String bed_type_short_desc		="";
	String room						="";
	String bed_no					="";
	String eff_status				="";

	if ( (whereClause == null || whereClause.equals("")) )
	{
		/*	Parameter variable definition starts here
			variables that holds the data/values coming from the criteria screen
		*/
		nursing_unit_code	= request.getParameter("nursing_unit_code");
		if(nursing_unit_code==null) nursing_unit_code="";

		nursing_short_desc  	= request.getParameter("nursing_short_desc");
		if(nursing_short_desc==null) nursing_short_desc="";

		bed_class_code		= request.getParameter("bed_class_code");
		if(bed_class_code==null) bed_class_code="";

		bed_class_short_desc	= request.getParameter("bed_class_short_desc");
		if(bed_class_short_desc==null) bed_class_short_desc="";

		bed_type_code		= request.getParameter("bed_type_code");
		if(bed_type_code==null) bed_type_code="";

		bed_type_short_desc	= request.getParameter("bed_type_short_desc");
		if(bed_type_short_desc==null) bed_type_short_desc="";

		room			= request.getParameter("room");
		if(room==null) room="";

		bed_no			= request.getParameter("bed_no");
		if(bed_no==null) bed_no="";

		eff_status		= request.getParameter("eff_status");
		if(eff_status==null) eff_status="";
		
		nursing_unit_code	= nursing_unit_code.toUpperCase();
		bed_class_code		= bed_class_code.toUpperCase();
		bed_type_code		= bed_type_code.toUpperCase();
		room				= room.toUpperCase();
		bed_no				= bed_no.toUpperCase();		

		/*Parameter variable definition ends here*/

		if(nursing_unit_code!=null && !nursing_unit_code.equals(""))
		{
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append("and upper(nursing_unit_code) like upper('"+nursing_unit_code+"%')");
		}

		if(nursing_short_desc!=null && !nursing_short_desc.equals(""))
		{
				sql.append(" and ");
				sql.append("upper(nursing_unit_short_desc) like  upper('"+nursing_short_desc+"%') " );
		}

		if(bed_class_code!=null && !bed_class_code.equals(""))
		{
				sql.append(" and ");
				sql.append("upper(bed_class_code) like  upper('"+bed_class_code+"%') " );
		}

		if(bed_class_short_desc!=null && !bed_class_short_desc.equals(""))
		{
				sql.append(" and ");
				sql.append("upper(bed_class_short_desc) like  upper('"+bed_class_short_desc+"%') " );
		}

		if(bed_type_code!=null && !bed_type_code.equals(""))
		{
				sql.append(" and ");
				sql.append("upper(bed_type_code) like  upper('"+bed_type_code+"%')");
		}

		if(bed_type_short_desc!=null && !bed_type_short_desc.equals(""))
		{
				sql.append(" and ");
				sql.append("upper(bed_type_short_desc) like  upper('"+bed_type_short_desc+"%')");
		}

		if(room!=null && !room.equals(""))
		{
				sql.append(" and ");
				sql.append("upper(room_no) like  upper('"+room+"%')");
		}

		if(bed_no!=null && !bed_no.equals(""))
		{
				sql.append(" and ");
				sql.append("upper(bed_no) like  upper('"+bed_no+"%')");
		}

	   if ( eff_status.equals("E") )
		{
			sql.append(" and eff_status='E'");
		}
	   if ( eff_status.equals("D") )
		{
			sql.append(" and eff_status='D' ");
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
	{	con =ConnectionManager.getConnection(request); 
		/*StringBuffer strsql1 = new StringBuffer();
		strsql1.append("select count(*) as total from ip_nursing_unit_bed_vw where PSEUDO_BED_YN='Y' and main_bed_no is null and facility_id = '"+facilityId+"' "+sql.toString());

		stmt=con.createStatement();
		rs = stmt.executeQuery(strsql1.toString());
		rs.next();
		maxRecord = rs.getInt("total");
		stmt.close();
		rs.close();
		if(maxRecord == 0)
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		*/	
		StringBuffer strsql2 = new StringBuffer();
		strsql2.append("select * from ip_nursing_unit_bed_vw where PSEUDO_BED_YN='Y' and main_bed_no is null and facility_id = '"+facilityId+"'  "+sql.toString());
		stmt=con.createStatement();
		rs = stmt.executeQuery(strsql2.toString());

		if ( start != 1 )
			for( int j=1; j<start; i++,j++ )
				rs.next() ;

		while ( i<=end && rs.next() )
			{
				if (maxRecord==0)
					{
		%>

		<P>
		<table align='right'>
			<tr>
				
					<%
					if ( !(start <= 1) )
						out.println("<td align ='right' id='prev'><A HREF='../jsp/PseudoBedCreationQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

					//if ( !( (start+14) > maxRecord ) )
						out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../jsp/PseudoBedCreationQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
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
				<th><fmt:message key="eIP.BedClassCode.label" bundle="${ip_labels}"/></th>
				<th><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/> <fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.bedtype.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.bedtype.label" bundle="${common_labels}"/> <fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.RoomCubicle.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
			</tr>
				<%
					}
				/*if ( start != 1 )
					 for( int j=1; j<start; i++,j++ )
						rs.next() ;
				*/
						String classValue = "" ;

				//while ( rs.next() && i<=end )
				//{
						if ( i % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;


							nursing_unit_code			=rs.getString("nursing_unit_code");
							nursing_short_desc			=rs.getString("nursing_unit_short_desc");
							bed_class_code				=rs.getString("bed_class_code");
							bed_class_short_desc		=rs.getString("bed_class_short_desc");
							bed_type_code				=rs.getString("bed_type_code");
							bed_type_short_desc		=rs.getString("bed_type_short_desc");
							room								=rs.getString("room_no");
							bed_no								=rs.getString("bed_no");
							eff_status						=rs.getString("eff_status");
						
						out.println("<tr>");
						out.println("<td class='" + classValue + "'><a  href='../jsp/addModifyPseudoBedCreation.jsp?nursing_unit_code="+nursing_unit_code+"&bed_no="+bed_no+"' target='f_query_add_mod' >");
						out.println(nursing_unit_code+"</a></td>");
						out.print("<td class='" + classValue + "'>"+nursing_short_desc+"</td>");
						out.print("<td class='" + classValue + "'>"+bed_class_code+"</td>");
						out.print("<td class='" + classValue + "'>"+bed_class_short_desc+"</td>");
						out.print("<td class='" + classValue + "'>"+bed_type_code+"</td>");
						out.print("<td class='" + classValue + "'>"+bed_type_short_desc+"</td>");
						out.print("<td class='" + classValue + "'>"+room+"</td>");
						out.print("<td class='" + classValue + "'>"+bed_no+"</td>");
						
						out.print("<td class='" + classValue + "' align='center'>");
						if(eff_status.equals("E"))
							out.println("<img src='../../eCommon/images/enabled.gif'></img>");
						else
							out.println("<img src='../../eCommon/images/disabled.gif'></img>");
						out.print("</td>");
						out.print("</tr>");
						i++;
						maxRecord++;

				}//endwhile

						if(maxRecord == 0)
						{
							out.println("<script src='../../eCommon/js/common.js' language='javascript'></script>");					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
						}

						if ( maxRecord < 14 || (!rs.next()) )
						{
							%>
							<script >
								if (document.getElementById("next"))
									document.getElementById("next").style.visibility='hidden';
							</script>
							<% 
						}
						else
							{%>
							<script >
								if (document.getElementById("next"))
									document.getElementById("next").style.visibility='visible';
							</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



							<%
							}
			}
			catch(Exception e)
			{
				//out.print(e.toString());
				e.printStackTrace();
			}
			finally   
			{
				try
				{
					if(stmt!=null) 	stmt.close();
					if(rs!=null) 		rs.close();
					//if(rset!=null)		rset.close();
				}
				catch(Exception e)
				{/* out.println("Exception in tryCatch : "+ e.toString()); */ e.printStackTrace(); }
					ConnectionManager.returnConnection(con,request); 
			}
			%>

</td></tr>
</table>
</BODY>
</HTML>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

