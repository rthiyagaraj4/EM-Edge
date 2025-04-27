<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*,java.util.*,java.net.*,java.text.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<%
out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/common.js' language='javascript'></script><script language='javascript' src='../../eCommon/js/DateUtils.js'></script></head><BODY  class='CONTENT' onLoad='ClearMsg()'  onKeyDown = 'lockKey()' OnMouseDown='CodeArrest()'>");

	request.setCharacterEncoding("UTF-8");
	String whereClause = request.getParameter("whereclause");
	String sql ="";
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	String locale = (String)session.getAttribute("LOCALE");
	
	if ( (whereClause == null || whereClause.equals("")) )
	{
	sql = " ";

	String pracid = request.getParameter("other_staff_id")==null ?"":request.getParameter("other_staff_id");
	String pracname=request.getParameter("other_staff_name")==null ?"":request.getParameter("other_staff_name");
	String enabled1 = request.getParameter("nature")==null ?"":request.getParameter("nature");
	String facilityid=request.getParameter("facility_id")==null ?"":request.getParameter("facility_id");
	String facilityname=request.getParameter("facility_name")==null ?"":request.getParameter("facility_name");



	if ( !(pracid == null || pracid.equals("")) )
	{
	sql = sql+" and upper(a.other_staff_id) like upper('"+pracid+"%') ";
	}

	if ( !(pracname == null || pracname.equals("")) )
	{
		sql = sql + " and upper(b.other_staff_name)  like upper('"+pracname+"%') " ;
	}

	if ( !(facilityid == null || facilityid.equals("")) )
	{
		sql = sql + " and upper(a.facility_id) like upper('"+facilityid+"%')" ;
	}

	if ( !(facilityname == null || facilityname.equals("")) )
	{
		sql = sql + " and upper(c.facility_name)  like  upper('"+facilityname+"%') " ;
	}

	if ( !(enabled1 == null || enabled1.equals("")) )
	{
	   if ( enabled1.equals("E") )
	        {
			sql = sql + " and a.eff_status='E' ";
		}
	   if ( enabled1.equals("D") )
		{
			sql = sql + " and a.eff_status='D' ";
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
	else{
		sql = whereClause;
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


Connection conn=null;
Statement stmt=null;
ResultSet rs=null;
int maxRecord = 0;
try{
conn = ConnectionManager.getConnection(request);
stmt = conn.createStatement();


String sql1 = "select a.other_staff_id other_staff_id, a.facility_id facility_id, b.other_staff_name other_staff_name, c.facility_name facility_name, a.eff_status eff_status, to_char(a.eff_date_from,'dd/mm/yyyy') eff_date_from, to_char(a.eff_date_to,'dd/mm/yyyy') eff_date_to from am_other_staff_for_facility a, am_other_staff b, sm_facility_param c where a.other_staff_id = b.other_staff_id and a.facility_id = c.facility_id";
sql1 +=sql;
rs = stmt.executeQuery(sql1);

	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
	  rs.next() ;
	}

	while ( rs.next() && i<=end )
  {
		if(maxRecord==0)
	  {

%>

<p>
<table align='right'>
<tr>
<%
if ( !(start <= 1) )
	out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/OtherStaffForFacilityQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

//if ( !( (start+14) > maxRecord ) )
	out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eAM/jsp/OtherStaffForFacilityQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");

%>
</tr>
</table>
</p>
<br><br>

<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th class='columnheader'><fmt:message key="Common.FacilityID.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="eAM.OtherStaffID.label" bundle="${am_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.OtherStaffName.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.EffectiveDate.label" bundle="${common_labels}"/><fmt:message key="Common.from.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.EffectiveDate.label" bundle="${common_labels}"/><fmt:message key="Common.to.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
<% }
 
	String classValue = "" ;
	String code="";
	String pid="";
	String fromdate="";
	String todate="";

        if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
			classValue = "QRYODD" ;


	code = rs.getString("facility_id");
	pid=rs.getString("other_staff_id");
	fromdate=rs.getString("eff_date_from");
	if(fromdate == null || fromdate.equals(""))
		fromdate = "";
	String fromdate_disply=DateUtils.convertDate(fromdate,"DMY","en",locale);
	if(fromdate_disply == null || fromdate_disply.equals(""))
		fromdate_disply="&nbsp;";

	todate=rs.getString("eff_date_to");
	if(todate == null || todate.equals(""))
		todate = "";
	String todate_disply=DateUtils.convertDate(todate,"DMY","en",locale);
	if(todate_disply == null || todate_disply.equals(""))
		todate_disply="&nbsp;";

	out.println("<tr><td class='" + classValue + "'>");
	out.println(code+"</td><td class='" + classValue + "'>");
	out.println(rs.getString("facility_name")+"</td><td class='" + classValue + "'>");
	out.println(pid+"</td><td class='" + classValue + "'>");
	out.println(rs.getString("other_staff_name")+"</td><td align='left' class='" + classValue + "'>");
	out.println(fromdate_disply+"</td><td align='left' class='" + classValue + "'>");
	out.println(todate_disply+"</td><td align='center' class='" + classValue + "'>");
	if ( rs.getString("eff_status").equals("E") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
		out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
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


  }
  catch(Exception e){out.print(e);}
  finally
  {
  	if(stmt!=null) 	stmt.close();
  	if(rs!=null)	rs.close();
  	ConnectionManager.returnConnection(conn,request);

  }

%>

</td></tr>
</table>

<br><center>

</center>
</BODY>
</HTML>

