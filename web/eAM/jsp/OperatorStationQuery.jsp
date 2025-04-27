<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8");%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language='javascript' src='../../eAM/js/OperatorStation.js'></script>

<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'> </link>
</head><BODY OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'  class='CONTENT' >
<%
	String whereClause = request.getParameter("whereclause");
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	String sql = "";
	String cd = request.getParameter("oper_stn_id");
	String longdesc = request.getParameter("long_desc");
	String enabled = request.getParameter("eff_status");
	String oper_stn_type= request.getParameter("oper_stn_type");
	String facilityid=request.getParameter("facility_id");
	String facility_name = request.getParameter("facility_name");

	if ( (whereClause == null || whereClause.equals("")) )
	{
	cd=cd.toUpperCase();
	//int andCheck = 0;


	if ( !(facilityid == null || facilityid.equals("")) )
		{
			sql =sql+ " and  a.facility_id like  '"+facilityid.toUpperCase()+"%'";
		}

	if ( !(facility_name == null || facility_name.equals("")) )
		{
			sql =sql+ " and upper(b.facility_name) like upper('"+facility_name+"%')";
		}


	if ( !(cd == null || cd.equals("")) )
		{
			sql =sql+ " and upper(oper_stn_id) like upper('"+cd+"%')";
		}

	if ( !(longdesc == null || longdesc.equals("")) )
		{
				sql = sql + " and upper(long_desc)  like  upper('"+longdesc+"%') " ;
		}



	if ( !(oper_stn_type == null || oper_stn_type.equals("")) )
		{
				sql = sql + " and upper(oper_stn_type)  =upper('"+oper_stn_type+"')" ;
		}


	if ( !(enabled == null || enabled.equals("")) )
	{
	     if( enabled.equals("E") )
	     {

	   	   sql = sql + " and eff_status='E'";
	     }
	     if ( enabled.equals("D") )
	     {
 	           sql = sql + " and eff_status='D'";
	     }
	}

	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");

	if ( !(ord == null || ord .equals("")) )
	{
		sql=sql+" order by ";
		for ( int i=0;i < ord.length;i++ )
	 	{
	 	if ( i == ord.length - 1 )
			sql=sql+ord[i];
		else
			sql=sql+ord[i]+",";
		}
	}
	
	} //end of where clause IF
	else
			sql = whereClause;

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
//Statement stmt1=null;
ResultSet rs = null;
String eff_status="";

	try{	conn = ConnectionManager.getConnection(request);


		stmt = conn.createStatement();
		int maxRecord = 0;
	
		String sqlstr ="select a.FACILITY_ID,b.FACILITY_NAME,a.OPER_STN_TYPE,a.OPER_STN_ID,a.LONG_DESC,a.SHORT_DESC,a.eff_status from am_oper_stn a, sm_facility_param b  where a.facility_id =b.facility_id  "+sql;
		rs = stmt.executeQuery(sqlstr);
		
		if ( start != 1 )
		for( int j=1; j<start; i++,j++ )
		rs.next() ;

		while ( i<=end && rs.next() )
		{
			if(maxRecord==0)
			{
		


		%>


		<p>
			
<form name='opstn_form_result' id='opstn_form_result'>
		<table align='right'>
		<tr>
		
		<%
		if ( !(start <= 1) )
			out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/OperatorStationQuery.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

		//if ( !( (start+14) > maxRecord ) )
			out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eAM/jsp/OperatorStationQuery.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");

		%>
		
		</tr>
		</table>
		</p>
<br><br>

		<table border="1" width="100%" cellspacing="0" cellpadding="0">
		<th class='columnheader'><fmt:message key="Common.FacilityID.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="eAM.OperatorStationType.label" bundle="${am_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
		<% }
			String facilityid1="";
			
			  String classValue = "",fac_name="" ;


				eff_status = rs.getString("eff_status");

				facilityid1=rs.getString("FACILITY_ID");

				fac_name = rs.getString("FACILITY_NAME");

				String code = rs.getString("OPER_STN_ID");

				String type = rs.getString("OPER_STN_TYPE");

				if(eff_status == null) eff_status="";
				if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;





				out.println("<tr><td align=='left' class='" + classValue + "'>");
				%><a href="javascript:qryModify('<%=facilityid1%>','<%=code%>','<%=type%>','<%=eff_status%>','<%=fac_name%>')"><%=facilityid1%></a></td><td class='<%=classValue%>'><%
		


				out.println(fac_name+"</td><td class='" + classValue + "'>");
				
				out.println(code+"</a></td><td class='" + classValue + "'>");
				out.println( rs.getString("long_desc") );
				out.println("</td><td class='" + classValue + "'>");
				out.println(rs.getString("short_desc") );
				out.println("</td>");
				out.println("</td><td class='" + classValue + "'>");
				if(rs.getString("oper_stn_type").equals("I"))
					out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels"));
				else
				if(rs.getString("oper_stn_type").equals("O"))
					out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels"));
				else
				if(rs.getString("oper_stn_type").equals("B"))
					out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.IPOP.label","common_labels"));
				out.println("</td><td class='" + classValue + "' align='center'>");

				if ( rs.getString("eff_status").equals("E") )
					out.println("<img src='../../eCommon/images/enabled.gif'></img>");
				else
						out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
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

		  if(rs!=null) 	rs.close();
	      if(stmt!=null) 	stmt.close();
	}//end of try
	catch(Exception e) { out.println(e.toString());}

	finally {
	 	 if (stmt != null) stmt.close();
	 	// if (stmt1 != null) stmt1.close();
	 	 if (rs != null)   rs.close();
	 	 	ConnectionManager.returnConnection(conn,request);

	}


		%>
		</tr>
		</table>
</center>

<br>
</BODY>
</form>
</HTML>


