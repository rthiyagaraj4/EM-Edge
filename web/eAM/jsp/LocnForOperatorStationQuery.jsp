<!DOCTYPE html>
<%--
	FileName	: LocnForOperatorStationQuery.jsp
	Version	    : 3	
	Modified On	: 23-2-2005
--%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8");%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 <%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*, eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>

<HTML>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<BODY  OnMouseDown='CodeArrest()'  class='CONTENT' onKeyDown = 'lockKey()'>
<%
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

	String whereClause = request.getParameter("whereclause");
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	String facilityid="";
	StringBuffer sql=new StringBuffer(" ");
	String strSQL1="";
	//String strSQL="";
	String speciality_code ="";

	if ( (whereClause == null || whereClause.equals("")) )
	{
	String optstnid = request.getParameter("oper_stn_id");
	String optstndesc = request.getParameter("oshort_desc");
	String locid = request.getParameter("locn_code");
	String locdesc=request.getParameter("short_desc");

	//String speciality_desc = request.getParameter("speciality_desc");
	 speciality_code = request.getParameter("speciality_code");
	String locn_type =request.getParameter("locn_type"); 
	String facility_id = request.getParameter("facility_id");
	
	
	int andCheck = 0;
	facilityid = request.getParameter("facilityid");
		if(facilityid == null) facilityid="";
	String facility_name = request.getParameter("facility_name");
		if(facility_name == null) facility_name="";
		
	if ( !(optstnid == null || optstnid.equals("")) )
		{
		optstnid=optstnid.toUpperCase();
		sql.setLength(0);
		sql.append(" where  upper(oper_stn_id)  like upper('"+optstnid+"%') ");
		andCheck = 1;
		}

	if ( !(optstndesc == null || optstndesc.equals("")) )
		{
			if ( andCheck == 1 )
			{
			sql.append(" and ");
			sql.append(" upper(oper_stn_short_desc) like  upper('"+optstndesc+"%')  " );
			}
			else
			{
			sql.append(" where upper(oper_stn_short_desc) like  upper('"+optstndesc+"%')  ") ;
			andCheck = 1;
			}
		}

		if ( !(locdesc== null || locdesc.equals("")) )
		{
			if ( andCheck == 1 )
			{
			sql.append(" and ");
			sql.append("upper(locn_short_desc)  like  upper('"+locdesc+"%') " );
			}
			else
			{
			sql.append(" where upper(locn_short_desc)  like  upper('"+locdesc+"%') ") ;
			andCheck = 1;
			}
		}


		if ( !(locid== null || locid.equals("")) )
		{
			if ( andCheck == 1 )
			{
			sql.append(" and ");
			sql.append(" upper(locn_code) like  upper('"+locid+"%') " );
			}
			else
			{
			sql.append(" where  upper(locn_code) like  upper('"+locid+"%') " );
			andCheck = 1;
			}
		}

		
		if ( !(speciality_code== null || speciality_code.equals("")) )
		{
			if(andCheck ==1)
			{
			sql.append(" and ");
			sql.append(" upper(SPECIALITY_CODE) like  upper('"+speciality_code+"%') " );
			}
			else
			{
			sql.append(" where upper(SPECIALITY_CODE) like  upper('"+speciality_code+"%') ") ;
			andCheck = 1;			
			}
		}
		
		
		if ( !(locn_type== null || locn_type.equals("")) )
		{
			if(andCheck ==1)
			{
			sql.append( " and ");
			sql.append( " upper(CARE_LOCN_TYPE) like '"+locn_type+"%' " );
			}
			else
			{
			sql.append(" where upper(CARE_LOCN_TYPE) like '"+locn_type+"%' " );
			andCheck = 1;	
			}
		}
		
		
		if ( !(facility_name== null || facility_name.equals("")) )
		{
			if(andCheck ==1)
			{
			sql.append( " and ");
			sql.append( " upper(facility_name) like upper('"+facility_name+"%') " );
			}
			else
			{
			sql.append(" where upper(facility_name) like upper('"+facility_name+"%')  " );
			andCheck = 1;	
			}
		}
		
		if ( !(facility_id == null || facility_id.equals("")) )
		{
			if(andCheck ==1)
			{
			sql.append( " and ");
			sql.append( " upper(facility_id) like '"+facility_id.toUpperCase()+"%' " );
			}
			else
			{
			sql.append(" where upper(facility_id) like '"+facility_id.toUpperCase()+"%' ") ;
			andCheck = 1;	
			}
		}

	if(!speciality_code.equals(""))
		{
		//StringBuffer sql2=new StringBuffer();

		sql.append(" OR EXISTS (SELECT NURSING_UNIT_CODE FROM IP_NURS_UNIT_FOR_SPECIALTY	 WHERE FACILITY_ID = FACILITY_ID AND NURSING_UNIT_CODE = LOCN_CODE AND SPECIALTY_CODE = '"+speciality_code+"')");
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
	}
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

Connection conn = null;
//Statement stmt=null;
Statement stmt1=null;
ResultSet rs=null;
ResultSet rset=null;
int maxRecord = 0;
try{
	conn = ConnectionManager.getConnection(request);


stmt1 = conn.createStatement();
if(speciality_code.equals(""))
	{
strSQL1="SELECT * FROM AM_LOCN_FOR_OPER_STN_VW  "+sql.toString();
	}else
	{
		strSQL1="SELECT * FROM AM_LOCN_FOR_OPER_STN_VW   "+sql.toString();
		
		
	}
rset = stmt1.executeQuery(strSQL1);

if ( start != 1 )
	 for(int j=1; j<start; i++,j++ )
	 {
	  rset.next() ;
	}

while ( i<=end && rset.next() )
{
	if(maxRecord==0)
	{

%>

<p>
<table align='right'>
<tr>
<%
   if ( !(start <= 1) )
	out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/LocnForOperatorStationQuery.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

//  if ( !( (start+14) > maxRecord ) )
	out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eAM/jsp/LocnForOperatorStationQuery.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
%>

</tr>
</table>
</p>
<br><br>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th><fmt:message key="Common.FacilityID.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.Operator.label" bundle="${common_labels}"/><br><fmt:message key="eAM.StatID.label" bundle="${am_labels}"/></th>
<th><fmt:message key="eAM.OperatorStationDescription.label" bundle="${am_labels}"/></th>
<th><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></th>

<th><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.LocationDescription.label" bundle="${common_labels}"/></th>
<!-- <th>Enabled</th>-->

<% }
 	
String classValue = "" ;

        if ( i % 2 == 0 )
		classValue = "QRYEVEN" ;
	else
		classValue = "QRYODD" ;

	out.println("<tr><td class='" + classValue + "'>");
	String ostnid = rset.getString("oper_stn_id");
	String ostndesc = rset.getString("oper_stn_short_desc");
	String ccode = rset.getString("locn_code");
	String ccodedesc = rset.getString("locn_short_desc");
	
	out.println(rset.getString("facility_id")+"</td><td class='" + classValue + "'>");
	out.println(rset.getString("facility_name")+"</td><td class='" + classValue + "'>");
	out.println(ostnid+"</td><td class='" + classValue + "'>");
	out.println(ostndesc+"</td><td class='" + classValue + "'>");
	out.print(rset.getString("care_locn_type_short_desc")+"</td><td class='" + classValue + "'>");
	out.println(ccode+"</td><td class='" + classValue + "'>");
	
	out.println(ccodedesc+"</td>");
	
	i++;
	maxRecord++;
	}//end of while

if(maxRecord == 0)
{%>
	<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>
<%}

if ( maxRecord < 14 || (!rset.next()) ) {
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
	//out.print(e.toString());
	//out.println( strSQL1);
	e.printStackTrace();
}
finally
{
	try
	{
		//if(stmt!=null) stmt.close();
		if(stmt1!=null)
			stmt1.close();
		if(rset!=null)
			rset.close();
		if(rs!=null)
			rs.close();
	}
	catch(Exception e)
	{}
	ConnectionManager.returnConnection(conn,request);	
}%>

</td></tr>
</table>
</BODY>
</HTML>

