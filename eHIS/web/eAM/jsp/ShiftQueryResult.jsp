<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*" %>
<html>
<head>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="query_form_result" id="query_form_result">
<%
request.setCharacterEncoding("UTF-8");	
	String whereClause = request.getParameter("whereclause");
	String sql="";
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;

	String qryWhere = "";

	if ((whereClause == null || whereClause.equals("")))
	{
		String qry_shift_code = request.getParameter("shift_code").equals("") ? "":request.getParameter("shift_code");
		String qry_shift_desc = request.getParameter("shift_desc").equals("") ? "":request.getParameter("shift_desc");
		String qry_shift_indicator = request.getParameter("shift_indicator").equals("") ? "":request.getParameter("shift_indicator");
		String qry_productive_flag = request.getParameter("productive_flag").equals("") ? "":request.getParameter("productive_flag");
		String qry_mnemonic_key = request.getParameter("mnemonic_key").equals("") ? "":request.getParameter("mnemonic_key");
		String qry_applicable = request.getParameter("applicable").equals("") ? "":request.getParameter("applicable");
		String qry_eff_status = request.getParameter("eff_status").equals("") ? "":request.getParameter("eff_status");
		
		String chkapp="";
		if(qry_applicable.equals("W")) chkapp = " and APPL_FOR_WORKING_DAYS='Y'";
		else
		if(qry_applicable.equals("N")) chkapp = " and APPL_FOR_NONWORKING_DAYS='Y'";
		else if(qry_applicable.equals("H")) chkapp = " and APPL_FOR_HOLIDAYS='Y'";
		
		qry_shift_code = qry_shift_code +"%";
		qry_shift_desc  = qry_shift_desc+"%";
		qry_shift_indicator  =   qry_shift_indicator +"%";
		qry_productive_flag = qry_productive_flag + "%";
		qry_mnemonic_key   = qry_mnemonic_key +"%";
		qry_applicable   = qry_applicable + "%";
		qry_eff_status = qry_eff_status + "%";

		
		if(qry_applicable.equals(""))
		{
		qryWhere = "where upper(shift_code) like upper('"+qry_shift_code+"') and upper(short_desc) like upper('"+qry_shift_desc+"') and upper(shift_indicator) like upper('"+qry_shift_indicator+"') and upper(nvl(productive_flag,'*')) like upper('"+qry_productive_flag+"') and upper(mnemonic_key) like upper('"+qry_mnemonic_key+"') and upper(eff_status) like upper('"+qry_eff_status+"')";
		}
		else
		{
			qryWhere = "where upper(shift_code) like upper('"+qry_shift_code+"') and upper(short_desc) like upper('"+qry_shift_desc+"') and upper(shift_indicator) like upper('"+qry_shift_indicator+"') and upper(nvl(productive_flag,'*')) like upper('"+qry_productive_flag+"') and upper(mnemonic_key) like upper('"+qry_mnemonic_key+"') and upper(eff_status) like upper('"+qry_eff_status+"')"+chkapp;
		}
		
		sql = qryWhere;
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
	}
	else
		sql = whereClause;

		


		String shift_code = "";
		String short_desc = "";
		String long_desc = "";
		String shift_start_time = "";
		String shift_end_time = "";
		String shift_indicator = "";
		String productive_flag = "";
		String mnemonic_key = "";
		String appl_for_working_days = "";
		String appl_for_nonworking_days = "";
		String appl_for_holidays = "";
		String eff_status = "";

	

Connection conn = ConnectionManager.getConnection(request);
Statement stmt=null;
ResultSet rs=null;
int maxRecord = 0;

try{
stmt = conn.createStatement();

String strsql = "select shift_code, long_desc, short_desc,TO_CHAR(shift_start_time,'hh24:mi') shift_start_time,TO_CHAR(shift_end_time,'hh24:mi') shift_end_time,DECODE(shift_indicator,'P','Productive','U','Unproductive','A','Absence','L','Leave') shift_indicator,DECODE(productive_flag,'W','Working','O','On Call','T','Training') productive_flag,appl_for_working_days, appl_for_nonworking_days, appl_for_holidays,mnemonic_key,eff_status FROM am_shift "+ sql;
	


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

		
	rs = stmt.executeQuery(strsql);

	if ( start != 1 )
		 for( int j=1; j<start; i++,j++ )
		 {
			rs.next() ;
		 }

	while ( rs.next() && i<end)
	{
		if(maxRecord==0)
		{
%>

<P>
<table align='right'>
<tr>
<%
if ( !(start <= 1) )
	out.println("<td align ='right' id='prev'><A HREF='ShiftQueryResult.jsp?from="+(start-13)+"&to="+(end-13)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

//if ( !( (start+14) > maxRecord ) )
	out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='ShiftQueryResult.jsp?from="+(start+13)+"&to="+(end+13)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
%>
</tr>
</table>
</P>
<br><br>
	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<tr>
<td class='COLUMNHEADER' rowspan="2"><fmt:message key="eAM.ShiftID.label" bundle="${am_labels}"/></td>
<td class='COLUMNHEADER' rowspan="2"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
<td class='COLUMNHEADER' rowspan="2"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
<td class='COLUMNHEADER' colspan="2"><fmt:message key="eAM.ShiftTimings.label" bundle="${am_labels}"/></td>
<td class='COLUMNHEADER' rowspan="2"><fmt:message key="Common.ShiftIndicator.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADER' rowspan="2"><fmt:message key="Common.ProductiveFlag.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADER' rowspan="2"><fmt:message key="eAM.ShiftMnemonic.label" bundle="${am_labels}"/></td>
<td class='COLUMNHEADER' colspan="3"><fmt:message key="Common.Applicability.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADER' rowspan="2"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
</tr>
<tr>
	<td class='COLUMNHEADER'><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="eAM.WD.label" bundle="${am_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="eAM.NWD.label" bundle="${am_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="eAM.HD.label" bundle="${am_labels}"/></td>
</tr>
<% }
	String classValue = "" ;
	

	if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
		  else
		  	classValue = "QRYODD" ;
		  
	shift_code = rs.getString("shift_code")==null ? "":rs.getString("shift_code");
	short_desc = rs.getString("short_desc")==null ? "":rs.getString("short_desc");
	long_desc = rs.getString("long_desc")==null ? "":rs.getString("long_desc");
	shift_start_time = rs.getString("shift_start_time")==null ? "":rs.getString("shift_start_time");
	shift_end_time = rs.getString("shift_end_time")==null ? "":rs.getString("shift_end_time");
	shift_indicator =rs.getString("shift_indicator")==null ? "":rs.getString("shift_indicator");
	productive_flag = rs.getString("productive_flag")==null ? "":rs.getString("productive_flag");
	mnemonic_key = rs.getString("mnemonic_key")==null ? "":rs.getString("mnemonic_key");
	appl_for_working_days = rs.getString("appl_for_working_days")==null ? "":rs.getString("appl_for_working_days");
	appl_for_nonworking_days =rs.getString("appl_for_nonworking_days")==null ? "":rs.getString("appl_for_nonworking_days");
	appl_for_holidays = rs.getString("appl_for_holidays")==null ? "":rs.getString("appl_for_holidays");
	eff_status = rs.getString("eff_status")==null ? "":rs.getString("eff_status");

	out.println("<tr><td class='" + classValue + "'><a href='../../eAM/jsp/ShiftAddModify.jsp?mode=2&shift_code="+shift_code+"&short_desc="+short_desc+"&long_desc="+long_desc+"&shift_start_time="+shift_start_time+"&shift_end_time="+shift_end_time+"&shift_indicator="+shift_indicator+"&productive_flag="+productive_flag+"&mnemonic_key="+mnemonic_key+"&appl_for_working_days="+appl_for_working_days+"&appl_for_nonworking_days="+appl_for_nonworking_days+"&appl_for_holidays="+appl_for_holidays+"&eff_status="+eff_status+"'>");
	out.println(shift_code +"</a></td><td class='" + classValue + "'>");
	out.println(short_desc +"</td><td class='" + classValue + "'>");
	out.println(long_desc +"</td><td class='" + classValue + "'>");
	out.println(shift_start_time +"</td><td class='" + classValue + "'>");
	out.println(shift_end_time +"</td><td class='" + classValue + "'>");

	if(shift_indicator.equalsIgnoreCase("Productive"))
		shift_indicator = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Productive.label","am_labels");
	else
	{
		if(shift_indicator.equalsIgnoreCase("Unproductive"))
			shift_indicator = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Unproductive.label","common_labels");
		else
		{
			if(shift_indicator.equalsIgnoreCase("Absence"))
				shift_indicator = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Absence.label","common_labels");
			else
				shift_indicator = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Leave.label","common_labels");
		}
	}

	out.println(shift_indicator +"</td><td class='" + classValue + "'>");
	if(shift_indicator.equalsIgnoreCase("Productive"))
	{
		if(productive_flag.equalsIgnoreCase("Working"))
			productive_flag = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Working.label","common_labels");
		else
		{
			if(productive_flag.equalsIgnoreCase("On Call"))
				productive_flag = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.OnCall.label","am_labels");
			else
			{
				if(productive_flag.equalsIgnoreCase("Training"))
					productive_flag = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Training.label","common_labels");
				else
					productive_flag = "&nbsp;";
			}
		}
	}
	else
		productive_flag = "&nbsp";

	out.println(productive_flag +"</td><td class='" + classValue + "'>");

	out.println(mnemonic_key +"</td><td class='" + classValue + "'>");

	if ( appl_for_working_days.equals("Y") )
		out.println("<div align='center'><img src='../../eCommon/images/enabled.gif'></img></div>");
	else
			out.println("<div  align='center'><img src='../../eCommon/images/RRnwd.gif'></img></div>");
	out.println("</td><td class='" + classValue + "'>");
	if ( appl_for_nonworking_days.equals("Y") )
		out.println("<div align='center'><img src='../../eCommon/images/enabled.gif'></img></div>");
	else
			out.println("<div  align='center'><img src='../../eCommon/images/RRnwd.gif'></img></div>");
	out.println("</td><td class='" + classValue + "'>");
	if ( appl_for_holidays.equals("Y") )
		out.println("<div align='center'><img src='../../eCommon/images/enabled.gif'></img></div>");
	else
			out.println("<div  align='center'><img src='../../eCommon/images/RRnwd.gif'></img></div>");
	out.println("</td><td class='" + classValue + "'>");
	if ( rs.getString("eff_status").equals("E") )
		out.println("<div align='center'><img src='../../eCommon/images/enabled.gif'></img></div>");
	else
			out.println("<div  align='center'><img src='../../eCommon/images/RRnwd.gif'></img></div>");

	out.println("</td></tr>");

	i++;
	maxRecord++;

  }//end of while

  if(maxRecord == 0)
{%>
	<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>
<%}

if ( maxRecord < 13 || (!rs.next()) ) {
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
	%>
	  </table>
<%
}catch(Exception e)
{
	out.println(e.getMessage());
	e.printStackTrace();
}
finally {
	  if (rs != null)   rs.close();
	  if (stmt != null) stmt.close();
	  
	  ConnectionManager.returnConnection(conn,request);
	}
%>

</body>
</html>

