<!DOCTYPE html>
<%--
	FileName	: OperatorStationRstrnQuery.jsp
	Version	    : 3	
	Modified On	: 23-2-2005
--%>
<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8");%>

<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<HTML>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<BODY OnMouseDown='CodeArrest()' class='CONTENT' onKeyDown = 'lockKey()' >
<%
	String whereClause = request.getParameter("whereclause");
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;

	String operstndesc = request.getParameter("short_desc");
	String appluserid 	   = request.getParameter("appl_user_id");
	String applusername 	   = request.getParameter("appl_user_name");
	String locncode 	   = request.getParameter("locn_code");
	String locnshortdesc 	   = request.getParameter("locn_short_desc");
	String locn_type = request.getParameter("locn_type");


	StringBuffer sql =new StringBuffer("");
	String facilityid=request.getParameter("facility_id");
	String facility_name=request.getParameter("facility_name");

	if ( (whereClause == null || whereClause.equals("")) )
	{
	int andCheck = 0;

	String cd = request.getParameter("oper_stn_id");

	if ( !(facilityid == null || facilityid.equals("")) )
		{
			sql.append(" where upper(facility_id)  like upper('"+facilityid.toUpperCase()+"%') ");
			andCheck = 1;
		}

	if ( !(facility_name == null || facility_name.equals("")) )
		{
			if ( andCheck == 1 )
			{
			sql.append(" and ");
			sql.append("  upper(facility_name)  like upper('"+facility_name+"%') ");

			}
			else
			{
			sql.setLength(0);
			sql.append("where upper(facility_name)  like upper('"+facility_name+"%') ");
			andCheck = 1;
			}

		}


	if ( !(locn_type == null || locn_type.equals("")) )
		{
			if ( andCheck == 1 )
			{
			sql.append(" and  upper(CARE_LOCN_TYPE)  like upper('"+locn_type+"%') ");
			}
			else
			{
			sql.setLength(0);
			sql.append( " where upper(CARE_LOCN_TYPE)  like upper('"+locn_type+"%') ");
			andCheck = 1;
			}

		}


	if ( !(cd == null || cd.equals("")) )
		{
		cd=cd.toUpperCase();
		if ( andCheck == 1 )
		{
		sql.append(" and upper(oper_stn_id) like upper('"+cd+"%')");
		}
		else
		{
		sql.setLength(0);
		sql.append(" where  upper(oper_stn_id) like upper('"+cd+"%')");
		andCheck = 1;
		}
		}



	if ( !(operstndesc == null || operstndesc.equals("")) )
		{
			if ( andCheck == 1 )
			{
				
				sql.append(" and upper(oper_stn_short_desc)  like  upper('"+operstndesc+"%') " );
			}
			else
			{
			sql.setLength(0);
			sql.append(" where upper(oper_stn_short_desc)  like  upper('"+operstndesc+"%') " );
			andCheck = 1;
			}
		}


	if ( !(appluserid == null || appluserid.equals("")) )
		{
			if ( andCheck == 1 )
			{
				sql.append(" and appl_user_id like  upper('"+appluserid+"%')" );
			}
			else
			{
			sql.setLength(0);
			sql.append(" where  appl_user_id like  upper('"+appluserid+"%')" );
			andCheck = 1;
			}
		}

	if ( !(applusername == null || applusername.equals("")) )
		{
				if ( andCheck == 1 )
				{
				sql.append(" and upper(appl_user_name) like  upper('"+applusername+"%') " );
				}
				else
				{
				sql.setLength(0);
				sql.append( " where upper(appl_user_name) like  upper('"+applusername+"%') " );
				andCheck = 1;
				}
		}

	if ( !(locncode == null || locncode.equals("")) )
		{
				if ( andCheck == 1 )
				{
				sql.append(" and upper(locn_code)  like  upper('"+locncode+"%') " );
				}
				else
				{
				sql.setLength(0);
				sql.append(" where  upper(locn_code)  like  upper('"+locncode+"%') " );
				andCheck = 1;
				}
		}

	if ( !(locnshortdesc == null || locnshortdesc.equals("")) )
		{

				if ( andCheck == 1 )
				{
				sql.append(" and upper(locn_short_desc)  like  upper('"+locnshortdesc+"%') " );
				}
				else
				{
				sql.setLength(0);
				sql.append(" where   upper(locn_short_desc)  like  upper('"+locnshortdesc+"%') " );
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

Connection conn = null ;

Statement stmt=null;
Statement stmt1=null;
ResultSet rs = null;

	try{
		conn = ConnectionManager.getConnection(request);

		int maxRecord = 0;
	

		stmt1 = conn.createStatement();
		String sqlstr ="select * from am_restrn_for_oper_stn_vw "+sql;
        rs = stmt1.executeQuery(sqlstr); 
		
		if ( start != 1 )
			 for( int j=1; j<start; i++,j++ )
			  rs.next() ;

		while ( i<=end  && rs.next() )
		{
			if(maxRecord==0)
			{

		%>

		<p>
		<table align='right'>
		<tr>
		
		<%
		if ( !(start <= 1) )
			out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/OperatorStationRstrnQuery.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

		//if ( !( (start+14) > maxRecord ) )
			out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eAM/jsp/OperatorStationRstrnQuery.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");

		%>
		</tr>
		</table>
		</p>
<br><br>

		<table border="1" width="100%" cellspacing="0" cellpadding="0">
		<th class='columnheader'><fmt:message key="Common.FacilityID.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.identification.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.userid.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.username.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.LocationDescription.label" bundle="${common_labels}"/></th>
		<% }
		
			  String classValue = "" ;

				if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;

			String facId=rs.getString("facility_id");
			String facName=rs.getString("facility_name");
			String code = rs.getString("oper_stn_id");
			String operstnshortdesc = rs.getString("oper_stn_short_desc");
			String appluserid1     = rs.getString("appl_user_id");
			String applusername1    = rs.getString("appl_user_name");
			String locncode1        = rs.getString("locn_code");
			String locnshortdesc1   = rs.getString("locn_short_desc");
			String locationtype1 = rs.getString("care_locn_type");
			String locationtypedesc1 = rs.getString("care_locn_type_short_desc");
			String operstntype = rs.getString("oper_stn_type");
			String care_locn_type_short_desc= rs.getString("care_locn_type_short_desc");

			out.println("<tr><td align=='left' class='" + classValue + "'>");
			
			out.println("<a href=\"../../eAM/jsp/addOperatorStationRstrnFrames.jsp?mode=update&facility_id="+facId+"&oper_stn_id="+ code +"&oper_stn_desc="+operstnshortdesc+"&user="+appluserid1 +"&applusername1="+applusername1+"&location_type="+locationtype1+"&location_type_desc="+locationtypedesc1+"&locnshortdesc1="+locnshortdesc1+"&facName="+java.net.URLEncoder.encode(facName)+"&locncode1="+ locncode1+"&oper_stn_type="+operstntype+"\" target='f_query_add_mod' >");
			
			out.println(facId+"</a></td><td class='" + classValue + "'>");
			
			out.println(facName+"</td><td class='" + classValue + "'>");
			
			out.println("<a href=\"../../eAM/jsp/addOperatorStationRstrnFrames.jsp?mode=update&facility_id="+facId+"&oper_stn_id="+ code +"&oper_stn_desc="+operstnshortdesc+"&user="+ appluserid1 +"&applusername1="+applusername1+"&location_type="+locationtype1+"&location_type_desc="+locationtypedesc1+"&locnshortdesc1="+locnshortdesc1+"&facName="+java.net.URLEncoder.encode(facName)+"&locncode1="+ locncode1+"&oper_stn_type="+operstntype+"\" target='f_query_add_mod' >");

						
			out.println(code+"</a></td><td class='" + classValue + "'>");
			
			out.println(operstnshortdesc+"</td>");
			
			out.println("</td><td class='" + classValue + "'>"+appluserid1);
			out.println("</td><td class='" + classValue + "'>"+applusername1);
			out.println("</td><td class='" + classValue + "'>"+care_locn_type_short_desc);
			out.println("</td><td class='" + classValue + "'>"+locncode1);

			out.println("</td><td class='" + classValue + "'>"+locnshortdesc1);

			out.println("</td>");
			i++;
			maxRecord++;
			}//end of while

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

	 	 if (rs != null)   rs.close();
       	 if (stmt1 != null) stmt1.close();
	}//end of try
	catch(Exception e) { out.println(e.toString());}

	finally {
		try{
	 	 if (stmt != null) stmt.close();
	 	 if (stmt1 != null) stmt1.close();
	 	 if (rs != null)   rs.close();
		}
		catch(Exception e)
		{}
	 	 ConnectionManager.returnConnection(conn,request);

	}


		%>
		</tr>
		</table>
</center>


</BODY>
</HTML>


