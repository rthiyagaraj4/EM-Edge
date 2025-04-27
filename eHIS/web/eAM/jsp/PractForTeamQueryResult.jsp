<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>

<%
Connection conn = null;
Statement stmt=null;
ResultSet rset=null;
ResultSet rs=null;
int maxRecord = 0;
String sqlchk ="";
//String strsql1="";
String strsql2="";
	

try{
request.setCharacterEncoding("UTF-8");	
//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
	conn = ConnectionManager.getConnection(request);
	
	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY OnMouseDown='CodeArrest()' class='CONTENT' onKeyDown = 'lockKey()' >");
	//String facilityId = (String) session.getValue( "facility_id" ) ;
	String whereClause = request.getParameter("whereclause");
	StringBuffer sql=new StringBuffer("");
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;

	
	
	if ((whereClause == null || whereClause.equals("")))
	{
				
		sql.setLength(0);
		sql.append("");
		String practitionerid 		= request.getParameter("practitioner_id");
		String teamshortdesc 		= request.getParameter("team_short_desc");
		String practitionershortname 	= request.getParameter("practitioner_short_name");
		String practitionerrole 	= request.getParameter("practitioner_role");
		String team_id			= request.getParameter("team_id");
		String splty_code = request.getParameter("speciality_code");
	
		String splty_desc = request.getParameter("speciality_desc");

		

		String facility_id = request.getParameter("facility_id");
		String facility_name = request.getParameter("facility_name");
		
		team_id=team_id.toUpperCase();		
		practitionerid=practitionerid.toUpperCase();
		
		int andCheck = 0;

		if(practitionerid!=null && !practitionerid.equals(""))
		{
				sql.append(" where ");
				sql.append(" practitioner_id like  '"+practitionerid+"%'" );
				andCheck = 1;
		}		
		
		if(facility_id!=null && !facility_id.equals(""))
		{
				if ( andCheck == 1 )
				{
				sql.append(" and ");
				sql.append(" facility_id like  '"+facility_id.toUpperCase()+"%'");
				}
				else
				{
				sql.setLength(0);
				sql.append(" where facility_id like  '"+facility_id.toUpperCase()+"%'");
				andCheck = 1;
				}
		}		

		if(facility_name!=null && !facility_name.equals(""))
		{
				if ( andCheck == 1 )
				{
				sql.append(" and ");
				sql.append(" upper(facility_name) like  upper('"+facility_name+"%')");
				}
				else
				{
					sql.setLength(0);
				sql.append(" where upper(facility_name) like  upper('"+facility_name+"%')");
				andCheck = 1;
				}
		}		


		if(team_id!=null && !team_id.equals(""))
		{
				if ( andCheck == 1 )
				{
				sql.append(" and ");
				sql.append(" team_id like  '"+team_id+"%'");
				}
				else
				{
					sql.setLength(0);
				sql.append(" where team_id like  '"+team_id+"%'");
				andCheck = 1;
				}
		}	
		
		if(teamshortdesc!=null && !teamshortdesc.equals(""))
		{
				if ( andCheck == 1 )
				{
				sql.append(" and ");
				sql.append(" upper(team_short_desc)  like  upper('"+teamshortdesc+"%')");
				}
				else
				{
					sql.setLength(0);
				sql.append(" where upper(team_short_desc)  like  upper('"+teamshortdesc+"%')") ;
				andCheck = 1;
				}
		}
		
		if(practitionershortname!=null && !practitionershortname.equals(""))
		{
				if ( andCheck == 1 )
				{
				sql.append(" and ");
				sql.append(" upper(practitioner_name)  like  upper('"+practitionershortname+"%')");
				}
				else
				{
					sql.setLength(0);
				sql.append(" where  upper(practitioner_name)  like  upper('"+practitionershortname+"%')");
				andCheck = 1;
				}
		}		
		
		if(practitionerrole!=null && !practitionerrole.equals(""))
		{
				if ( andCheck == 1 )
				{
				sql.append(" and ");
				sql.append(" practitioner_role like  '"+practitionerrole+"%'");
				}
				else
				{
					sql.setLength(0);
				sql.append(" where    practitioner_role like  '"+practitionerrole+"%'");
				andCheck = 1;
				}
		}		
		
			if(splty_code!=null && !splty_code.equals(""))
			{
					if ( andCheck == 1 )
					{
						
					sql.append(" and ");
					sql.append(" SPECIALITY_CODE like  '"+splty_code.toUpperCase()+"%'");
					}
					else
					{
											
						sql.setLength(0);
					sql.append(" where    SPECIALITY_CODE like  '"+splty_code.toUpperCase()+"%'");
					andCheck = 1;
					}
			}		

			
			if(splty_desc!=null && !splty_desc.equals(""))
			{
			
				
					if ( andCheck == 1 )
					{
					
					sql.append(" and ");
					sql.append(" upper(short_desc) like  upper('"+splty_desc+"%')");
		

					}
					else
					{
					sql.setLength(0);
					sql.append(" where   upper(short_desc) like  upper('"+splty_desc+"%') " );
					andCheck = 1;
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
	else
	{
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

		stmt = conn.createStatement();
		
	

		if(sqlchk.equals("Y"))
			 strsql2="select FACILITY_ID,FACILITY_NAME,TEAM_ID,TEAM_LONG_DESC,TEAM_SHORT_DESC,PRACTITIONER_ID,PRACTITIONER_NAME PRACTITIONER_SHORT_NAME,PRACTITIONER_ROLE,SPECIALITY_CODE,SHORT_DESC SPECIALITY_DESC from AM_PRACT_FOR_TEAM_VW "+sql.toString();		
		else	
			 strsql2="select FACILITY_ID,FACILITY_NAME,TEAM_ID,TEAM_LONG_DESC,TEAM_SHORT_DESC,PRACTITIONER_ID,PRACTITIONER_NAME PRACTITIONER_SHORT_NAME,PRACTITIONER_ROLE,SPECIALITY_CODE,SHORT_DESC SPECIALITY_DESC from AM_PRACT_FOR_TEAM_VW "+sql.toString();		
	
		rs = stmt.executeQuery(strsql2);

		if ( start != 1 )
		 for( int j=1; j<start; i++,j++ )
		 {
			rs.next() ;
		 }
	
	while ( i<=end && rs.next())
	{
		if(maxRecord==0)
		{
	
	%>

	<P>
	<table align='right'>
	<tr>
	
	<%
	if ( !(start <= 1) )
		out.println("<td align ='right' id='prev'><A HREF='PractForTeamQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

	//if ( !( (start+14) > maxRecord ) )
		out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='PractForTeamQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
	%>
	
	</tr>
	</table>
	</P>
	<br>
	<br>

	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
	<th class='columnheader'><fmt:message key="Common.FacilityID.label" bundle="${common_labels}"/></th>	
	<th class='columnheader'><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></th>	
	<th class='columnheader'><fmt:message key="Common.TeamID.label" bundle="${common_labels}"/></th>	
	<th class='columnheader'><fmt:message key="eAM.Team.label" bundle="${am_labels}"/> <fmt:message key="Common.description.label" bundle="${common_labels}"/></th>	
	<th class='columnheader'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
	<th class='columnheader'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> <fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
	<th class='columnheader'><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></th>
	<th class='columnheader'><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/></th>
	<th class='columnheader'><fmt:message key="Common.Role.label" bundle="${common_labels}"/></th>

	<% }
	

	String classValue = "" ;

			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;

			String	 teamid = rs.getString("TEAM_ID");
			String   facility_ID = rs.getString("FACILITY_ID");
			String   facility_name = rs.getString("FACILITY_NAME");
			String   practitioner_id = rs.getString("PRACTITIONER_ID");
			String speciality_code = rs.getString("speciality_code");
			String speciality_desc = rs.getString("speciality_desc");

		

			out.println("<tr><td  class='" + classValue + "' align='left'>");			
			out.println(facility_ID+"</td><td  class='" + classValue + "'>");	
			out.println(facility_name+"</td><td  class='" + classValue + "'>");	
			
			out.println(teamid+"</td><td  class='" + classValue + "'>");			
			out.println(rs.getString("TEAM_SHORT_DESC")==null?"":rs.getString("TEAM_SHORT_DESC")+"</td><td align='left' class='" + classValue + "'>");
			out.println(speciality_code+"</td><td  align='left' class='" + classValue + "'>");
			out.println(speciality_desc+"</td><td  align='left' class='" + classValue + "'>");
			
			out.println(practitioner_id+"</td><td  align='left' class='" + classValue + "'>");
			out.println(rs.getString("PRACTITIONER_SHORT_NAME")==null?"":rs.getString("PRACTITIONER_SHORT_NAME")+"</td><td  align='left' class='" + classValue + "'>");
			out.println(rs.getString("PRACTITIONER_ROLE")==null?"":rs.getString("PRACTITIONER_ROLE"));
		i++;
		maxRecord++;
	}//endwhile
	
	if(maxRecord == 0)
{%>
	<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>
<%}

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
	
	}//end of try
	catch(Exception e)
		{
			e.toString();
			out.println(e);
		}
		
		finally
		{
			try
			{
				if(stmt!=null) 	stmt.close();
				if(rs!=null) 		rs.close();
				if(rset!=null)		rset.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			ConnectionManager.returnConnection(conn,request);
		}
		
%>

</td></tr>
</table>
</BODY>
</HTML>

