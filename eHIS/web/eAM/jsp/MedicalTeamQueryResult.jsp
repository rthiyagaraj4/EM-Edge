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
String sqlchk = "";
//String strsql1= "";
String strsql2= "";
String speciality_code="";
String speciality_desc ="";
Boolean isMedicalTeamApplicable = false; //Added by Shaik Mujafar for ML-MMOH-CRF-0716
try{
	request.setCharacterEncoding("UTF-8");
//MMS-ME-SCF-0096 vulnerability Issue 
	request= new XSSRequestWrapper(request); 
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
	conn = ConnectionManager.getConnection(request);
	isMedicalTeamApplicable =  eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","MEDICAL_TEAM_APPLICABLE"); //Added by Shaik Mujafar for ML-MMOH-CRF-0716
	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' class='CONTENT' >");
	
	String whereClause = request.getParameter("whereclause");
	StringBuffer sql=new StringBuffer("");
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	String facility_id = request.getParameter("facility_id");
	String facility_name = request.getParameter("facility_name");
	
	if ((whereClause == null || whereClause.equals("")))
	{
		sql.setLength(0);
		sql.append("");
			
		String applicable_for =request.getParameter("applicable_for");
		
		String teamid 		= request.getParameter("team_id");
		String longdesc 	= request.getParameter("long_desc");
		String effstatus 	= request.getParameter("eff_status");
		if(effstatus.equals(null)) effstatus = "D"; 
		
		 speciality_code = request.getParameter("speciality_code");
	 speciality_desc = request.getParameter("speciality_desc");
		
		int andCheck = 0;

		teamid=teamid.toUpperCase();
		
		if(teamid!=null && !teamid.equals(""))
		{
			if ( andCheck == 1 )
			{
				
				sql.append(" and ");
				sql.append(" team_id like  '"+teamid+"%'" );
			}
			else
			{
				sql.setLength(0);
				sql.append(" where team_id like '"+teamid+"%'" );
				andCheck = 1;
				sqlchk ="Y";
			}
		}		

		if(facility_id!=null && !facility_id.equals(""))
		{
			if ( andCheck == 1 )
			{
				sql.append(" and ");
				sql.append(" facility_id like  '"+facility_id.toUpperCase()+"%'" );
			}
			else
			{
				sql.setLength(0);
				sql.append(" where facility_id like '"+facility_id.toUpperCase()+"%'" );
				andCheck = 1;
				sqlchk ="Y";
			}
		}


		if(facility_id!=null && !facility_id.equals(""))
		{
			if ( andCheck == 1 )
			{
				sql.append(" and ");
				sql.append(" facility_id like  '"+facility_id.toUpperCase()+"%'" );
			}
			else
			{
				sql.setLength(0);
				sql.append(" where facility_id like '"+facility_id.toUpperCase()+"%'" );
				andCheck = 1;
				sqlchk ="Y";
			}
		}
		if(facility_name!=null && !facility_name.equals(""))
		{
			if ( andCheck == 1 )
			{
				sql.append(" and ");
				sql.append(" upper(facility_name) like  upper('"+facility_name+"%') " );
			}
			else
			{
				sql.setLength(0);
				sql.append(" where upper(facility_name) like upper('"+facility_name+"%') " );
				andCheck = 1;
				sqlchk ="Y";
			}
		}
		if(speciality_desc!=null && !speciality_desc.equals(""))
		{
			if ( andCheck == 1 )
			{
				sql.append(" and ");
				sql.append(" upper(speciality_desc)  like  upper('"+speciality_desc+"%') " );
			}
			else
			{
				sql.setLength(0);
				sql.append(" where upper(speciality_desc)  like upper('"+speciality_desc+"%') " );
				andCheck = 1;
				sqlchk ="Y";
			}
		}
		if(speciality_code!=null && !speciality_code.equals(""))
		{
			if ( andCheck == 1 )
			{
				sql.append( " and ");
				sql.append( " upper(speciality_code)  like  upper('"+speciality_code+"%') " );
			}
			else
			{
				sql.setLength(0);
				sql.append( " where upper(speciality_code)  like upper('"+speciality_code+"%') " );
				andCheck = 1;
				sqlchk ="Y";
			}
		}
		if(longdesc!=null && !longdesc.equals(""))
		{
			if ( andCheck == 1 )
			{
				sql.append( " and ");
				sql.append( " upper(long_desc)  like  upper('"+longdesc+"%') " );
			}
			else
			{
				sql.setLength(0);
				sql.append(" where upper(long_desc)  like upper('"+longdesc+"%') " );
				andCheck = 1;
				sqlchk ="Y";
			}
		}
		if ( effstatus.equals("E") )
		{
			if ( andCheck == 0 )
			{
				sql.setLength(0);
				sql.append(" where eff_status='E'");
				andCheck = 1;
				sqlchk ="Y";
			}
			else
			{
				
				sql.append(" and eff_status='E'");
			}	
		}
		if ( effstatus.equals("D") )
		{
			if ( andCheck == 0 )
			{
				sql.setLength(0);
				sql.append(" where  eff_status='D'");
				andCheck = 1;
				sqlchk ="Y";
			}
			else
			{
				
				sql.append( " and eff_status='D'");
			}	
		}
		

		if ( applicable_for.equals("I") )
		{
			if ( andCheck == 0 )
			{
				sql.setLength(0);
				sql.append( " where appl_for_ip_yn='Y'");
				andCheck = 1;
				sqlchk ="Y";
			}
			else
			{
				
				sql.append( " and appl_for_ip_yn='Y'");
			}	
		}
		if ( applicable_for.equals("O") )
		{
			if ( andCheck == 0 )
			{
				sql.setLength(0);
				sql.append( " where  appl_for_op_yn='Y'");
				andCheck = 1;
				sqlchk ="Y";
			}
			else
			{
				sql.append(" and appl_for_op_yn='Y'");
			}	
		}
		// added by mujafar for ML-MMOH-CRF-0716 start
		if ( applicable_for.equals("M") )
		{ 
			if ( andCheck == 0 )
			{
				sql.setLength(0);
				sql.append( " where  appl_for_mr_yn='Y'");
				andCheck = 1;
				sqlchk ="Y";
			}
			else
			{
				sql.append(" and appl_for_mr_yn='Y'");
			}	
		}
		// end

		
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
			 strsql2="select TEAM_ID,LONG_DESC,SHORT_DESC,EFF_STATUS,APPL_FOR_OP_YN,APPL_FOR_IP_YN,APPL_FOR_MR_YN,speciality_code,speciality_desc,facility_id,facility_name from am_medical_team_vw "+sql; // modified by mujafar for ML-MMOH-CRF-0716
		else	
			 strsql2="select TEAM_ID,LONG_DESC,SHORT_DESC,EFF_STATUS,APPL_FOR_OP_YN,APPL_FOR_IP_YN,APPL_FOR_MR_YN,speciality_code,speciality_desc,facility_id,facility_name from am_medical_team_vw "+sql; // modified by mujafar for ML-MMOH-CRF-0716

		rs = stmt.executeQuery(strsql2);

		if ( start != 1 )
		 for( int j=1; j<start; i++,j++ )
		 {
			rs.next() ;
		 }

		 while (i<=end && rs.next() )
	{
		 if(maxRecord==0)
		{
		
	%>

	<P>
	<table align='right'>
	<tr>
	
	<%
	if ( !(start <= 1) )
		out.println("<td align ='right' id='prev'><A HREF='MedicalTeamQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
	//if ( !( (start+14) > maxRecord ) )
		out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='MedicalTeamQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
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
		<th class='columnheader'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> <fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.Inpatients.label" bundle="${common_labels}"/></th>
		<%if(isMedicalTeamApplicable){%><th class='columnheader'><fmt:message key="eMR.MedicalReport.label" bundle="${mr_labels}"/></th><%}// modified by mujafar for ML-MMOH-CRF-0716 %>
		<th class='columnheader'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

	<% }
	

	String classValue = "" ;
			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;

			String facId=rs.getString("facility_id");
			String facName=rs.getString("facility_name");
			String	 teamid 	= rs.getString("TEAM_ID");
			String effstatus = rs.getString("EFF_STATUS");
			String appl_for_op_yn= rs.getString("appl_for_op_yn");
			String appl_for_ip_yn= rs.getString("appl_for_ip_yn");
			String appl_for_mr_yn =rs.getString("APPL_FOR_MR_YN"); // modified by mujafar for ML-MMOH-CRF-0716
			 speciality_code = rs.getString("speciality_code");
			 speciality_desc = rs.getString("speciality_desc");
			

			out.println("<tr><td class='" + classValue + "'>");						
			out.println("<a href='addModifyMedicalTeam.jsp?teamid="+teamid+"&facility_id="+facId+"&facility_desc="+java.net.URLEncoder.encode(facName)+"' target='f_query_add_mod' >");
			out.println(facId+"</a></td><td class='" + classValue + "'>");		
			out.println("<a href='addModifyMedicalTeam.jsp?teamid="+teamid+"&facility_id="+facId+"&facility_desc="+java.net.URLEncoder.encode(facName)+"' target='f_query_add_mod' >");
			out.println(facName+"</a></td><td class='" + classValue + "'>");	
			out.println("<a href='addModifyMedicalTeam.jsp?teamid="+teamid+"&facility_id="+facId+"&facility_desc="+java.net.URLEncoder.encode(facName)+"' target='f_query_add_mod' >");
			out.println(teamid+"</a></td><td class='" + classValue + "'>");			
			out.println(rs.getString("LONG_DESC")==null?"":rs.getString("LONG_DESC")+"</td><td align='left' class='" + classValue + "'>");			
			out.println(rs.getString("SHORT_DESC")==null?"":rs.getString("SHORT_DESC")+"</td><td align='left' class='" + classValue + "'>");			
			out.println(rs.getString("speciality_code")==null?"":rs.getString("speciality_code")+"</td><td align='left' class='" + classValue + "'>");			
			out.println(rs.getString("speciality_desc")==null?"":rs.getString("speciality_desc")+"</td><td align='center' class='" + classValue + "'>");			
			
			if(appl_for_op_yn.equals("Y"))
				out.println("<img src='../../eCommon/images/enabled.gif'></img>");
			else
				out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
			out.println("</td><td align='center' class='" + classValue + "'>");

			if(appl_for_ip_yn.equals("Y"))
				out.println("<img src='../../eCommon/images/enabled.gif'></img>");
			else
				out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
			out.println("</td><td align='center' class='" + classValue + "'>");  
			
			if(isMedicalTeamApplicable){ // ADDED by mujafar for ML-MMOH-CRF-0716
			if(appl_for_mr_yn.equals("Y"))
				out.println("<img src='../../eCommon/images/enabled.gif'></img>");
			else
				out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
			out.println("</td><td align='center' class='" + classValue + "'>");
			}
			

				if(effstatus.equals("E"))
				out.println("<img src='../../eCommon/images/enabled.gif'></img>");
			else
				out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
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

	if(stmt!=null) 	stmt.close();
	if(rs!=null) 	rs.close();
	
	}// end of try
	catch(Exception e)
		{
			//e.toString();
			//out.println(e);
			e.printStackTrace();
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
	</td>
  </tr>
</table>
</BODY>
</HTML>

