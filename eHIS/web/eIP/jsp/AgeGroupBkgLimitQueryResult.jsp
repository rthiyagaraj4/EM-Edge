<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import ="webbeans.eCommon.*,java.sql.*,java.util.*,java.net.*,java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></head><BODY  class='CONTENT' onLoad='ClearMsg()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%	
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	String facilityId					= (String) session.getValue( "facility_id" ) ;
	String whereClause				= request.getParameter("whereclause");

	StringBuffer sql= new StringBuffer();
	//Variable that holds where clause for that's dynamically constructed
	String from						= request.getParameter( "from" ) ;		
	//Variable that contains the number from which the display of the record starts
	String to						= request.getParameter( "to" ) ;			
	//Variable that contains the number from which the display of the record ends
	String  age_group_code		="";
	String  age_group_desc		="";
	String bed_class_code			="";
	String bed_class_long_desc	 ="";
	String max_male_dly_booking="";
	String max_female_dly_booking="";
	String max_total_dly_booking="";
	String max_unknown_dly_booking="";

	if ( (whereClause == null || whereClause.equals("")) )
	{
		/*	Parameter variable definition starts here
			variables that holds the data/values coming from the criteria screen
		*/
		age_group_code		= request.getParameter("age_group_code");
		age_group_desc  	= request.getParameter("age_group_desc");
		bed_class_code		= request.getParameter("bed_class_code");
		bed_class_long_desc	= request.getParameter("bed_class_long_desc");
		age_group_code		= age_group_code.toUpperCase();
		bed_class_code		= bed_class_code.toUpperCase();
		
		if(age_group_code!=null && !age_group_code.equals(""))
		{
			sql.append("and upper(age_group_code) like upper('"+age_group_code+"%') ");
		}

		if(age_group_desc!=null && !age_group_desc.equals(""))
		{
			sql.append(" and ");
			sql.append("upper(age_group_short_desc) like  upper('"+age_group_desc+"%')");
		}

		if(bed_class_code!=null && !bed_class_code.equals(""))
		{
			sql.append( " and ");
			sql.append( "upper(bed_class_code) like upper('"+bed_class_code+"%') ");
		}

		if(bed_class_long_desc!=null && !bed_class_long_desc.equals(""))
		{
			sql.append(" and ");
			sql.append("upper(bed_class_short_desc) like  upper('"+bed_class_long_desc+"%') ");
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
		strsql1.append("select count(*) as total from ip_book_limit_by_age_grp_vw where facility_id = '"+facilityId+"' "+sql.toString());
		stmt=con.createStatement();
		rs = stmt.executeQuery(strsql1.toString());
		rs.next();
		maxRecord = rs.getInt("total");
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
		}
		stmt.close();
		rs.close();*/
		StringBuffer strsql2 = new StringBuffer();
		strsql2.append("select * from ip_book_limit_by_age_grp_vw where facility_id = '"+facilityId+"'  "+sql.toString());
		stmt=con.createStatement();
		rs = stmt.executeQuery(strsql2.toString());

		if ( start != 1 )
			for( int j=1; j<start; i++,j++ )
				rs.next() ;
		while ( i<=end && rs.next())
			{
			 if (maxRecord==0)
				{
	%>
		<P>
		<table align='right'>
			<tr>
				
					<%
					if ( !(start <= 1) )
						out.println("<td align ='right' id='prev'><A HREF='../jsp/AgeGroupBkgLimitQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

					//if ( !( (start+14) > maxRecord ) )
					out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../jsp/AgeGroupBkgLimitQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
					%>
				
			</tr>
		</table>
		</P>
		<br>
		<br>
		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
			<tr>
				<th><fmt:message key="Common.agegroupcode.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.agegroupdesc.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eIP.BedClassCode.label" bundle="${ip_labels}"/></th>
				<th><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/> <fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.maximum.label" bundle="${common_labels}"/> <fmt:message key="Common.male.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.maximum.label" bundle="${common_labels}"/> <fmt:message key="Common.female.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.maximum.label" bundle="${common_labels}"/> <fmt:message key="Common.unknown.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.maximum.label" bundle="${common_labels}"/> <fmt:message key="Common.total.label" bundle="${common_labels}"/></th>
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


					age_group_code			= rs.getString("age_group_code");
					age_group_desc			= rs.getString("age_group_short_desc");
					bed_class_code			= rs.getString("bed_class_code");
					bed_class_long_desc		= rs.getString("bed_class_short_desc");

					max_male_dly_booking	= String.valueOf(rs.getInt("max_male_dly_booking"));
					if(max_male_dly_booking.equals("0"))max_male_dly_booking="&nbsp;";
					max_female_dly_booking	= String.valueOf(rs.getInt("max_female_dly_booking"));
					if(max_female_dly_booking.equals("0"))max_female_dly_booking="&nbsp;";
					max_total_dly_booking	= String.valueOf(rs.getInt("max_total_dly_booking"));
					if(max_total_dly_booking.equals("0"))max_total_dly_booking="&nbsp;";
					max_unknown_dly_booking	= String.valueOf(rs.getInt("max_unknown_dly_booking"));
					if(max_unknown_dly_booking.equals("0"))max_unknown_dly_booking="&nbsp;";

					out.println("<tr>");
					out.print("<td class='" + classValue + "'>"+age_group_code+"</td>");
					out.print("<td class='" + classValue + "'>"+age_group_desc+"</td>");
					out.print("<td class='" + classValue + "'>"+bed_class_code+"</td>");
					out.print("<td class='" + classValue + "'>"+bed_class_long_desc+"</td>");
					out.print("<td class='" + classValue + "'>"+max_male_dly_booking+"</td>");
					out.print("<td class='" + classValue + "'>"+max_female_dly_booking+"</td>");
					out.print("<td class='" + classValue + "'>"+max_unknown_dly_booking+"</td>");
					out.print("<td class='" + classValue + "'>"+max_total_dly_booking+"</td>");
					out.print("</tr>");
					i++;
					maxRecord++;
				}//endwhile
			
					if(maxRecord == 0)
					{
						out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
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
				if(rs!=null) 		rs.close();
				//if(rset!=null)		rset.close();
				if(stmt!=null) 	stmt.close();
			
			}catch(Exception e)
			{
				//out.print(e.toString());
				e.printStackTrace();
			}
			finally   
			{
				ConnectionManager.returnConnection(con,request); 
			}	%>
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

