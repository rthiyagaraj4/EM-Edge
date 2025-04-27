<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<script src='../../eCommon/js/common.js' language='javascript'></script>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>

<% 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8");
	%>
<%
out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>");

	String whereClause = request.getParameter("whereclause");
	StringBuffer sql = new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	String pat_no_ctrl = "" ;
	/*Added by lakshmanan for security issue ID 174035708 on 08-08-2023 start */
	java.util.HashMap psthashmap		=	new java.util.HashMap() ;
	int psthmcount=0;
	/*Added by lakshmanan for security issue ID 174035708 on 08-08-2023 end */


	if ( (whereClause == null || whereClause.equals("")) )
	{

	String cd = request.getParameter("pat_ser_grp_code");
	cd = cd.toUpperCase();
	String longdesc = request.getParameter("long_desc");
	longdesc = longdesc.toUpperCase();
	String series_type = request.getParameter("id_type");

	int andCheck = 0;
	if ( !(cd == null || cd.equals("")) )
		{
		sql.append("where pat_ser_grp_code like ? ");
		psthashmap.put(++psthmcount,cd+"%");
		//sql.append(cd);
		//sql.append("%'");
		andCheck = 1;
		}


	if ( !(longdesc == null || longdesc.equals("")) )
		{
			if ( andCheck == 1 )
			{	sql.append(" and ");
				sql.append("upper(long_desc) like  ? ");
				psthashmap.put(++psthmcount,longdesc+"%");
				//sql.append(longdesc+"%'");
			}
			else
			{
				sql.append("where upper(long_desc) like ? ");
				psthashmap.put(++psthmcount,longdesc+"%");
				//sql.append(longdesc);
				//sql.append("%'");
				andCheck = 1;
			}
	}


	if ( !(series_type == null || series_type.equals("")) )
		{
			if ( andCheck == 1 )
			{	sql.append(" and ");
				sql.append("upper(id_type) like  ? ");
				psthashmap.put(++psthmcount,series_type+"%");
				//sql.append(series_type+"%'");
			}
			else
			{
				sql.append("where upper(id_type) like ? ");
				psthashmap.put(++psthmcount,series_type+"%");
				//sql.append(series_type);
				//sql.append("%'");
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
			{
			sql.append(ord[i]);
			sql.append(",");
			}
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

//Connection conn = (Connection) session.getValue( "connection" ) ;
Connection conn=null;
try
{
conn = ConnectionManager.getConnection(request);
PreparedStatement pstmt=null;
ResultSet rs=null;


	//int maxRecord = 0;
/*try{
		
	pstmt = conn.prepareStatement("select count(*) as total from mp_pat_ser_grp "+sql.toString());

	rs = pstmt.executeQuery();
	rs.next();
	maxRecord = rs.getInt("total");
}catch(Exception e) { out.println(e.toString());}
finally
{
	if (pstmt != null) pstmt.close();
	if (rs != null) rs.close();
}
if (maxRecord==0)
{
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
}
else
{*/
try{
	/*Added by lakshmanan for security issue ID 174035708 on 08-08-2023 start */
	int pstcount=1;
	pstmt = conn.prepareStatement("select a.pat_ser_grp_code, a.long_desc, a.short_desc,  a.gen_pat_id_yn, a.prefix_reqd_yn, a.id_type, (case when a.scheme_id is not null then (select scheme_name from mp_check_digit_scheme b where a.scheme_id = b.scheme_id ) end )scheme_name,pat_no_ctrl,default_yn from mp_pat_ser_grp a "+sql.toString());
	while ( pstcount<=psthashmap.size()) {
	pstmt.setString(pstcount,(String) psthashmap.get(pstcount));
	pstcount++;
	}
	rs = pstmt.executeQuery();
	psthashmap.clear();
	/*Added by lakshmanan for security issue ID 174035708 on 08-08-2023 end */
%>



<%
 	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  rs.next() ;
    String classValue = "" ;
	int cnt = 0;
	while ( i<=end && rs.next())
	{
	if (cnt==0)
	{%>
		<P>
	<table align='right'>
	<tr>

	<%
	if ( !(start <= 1) )
		out.println("<td align ='right' id='prev'><A HREF='../jsp/queryPatientNumber.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>"); %>
	<td align ='right' id='next' style='visibility:hidden'>
	<% //if ( !( (start+14) > maxRecord ) )
		out.println("<A HREF='../jsp/queryPatientNumber.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
	%>
	</td>
	</tr>
	</table>
		<BR><BR>
	</p>

	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
	<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="eMP.CheckDigitScheme.label" bundle="${mp_labels}"/> </th>
	<th><fmt:message key="eMP.GeneratePatientID.label" bundle="${mp_labels}"/> </th>
	<th><fmt:message key="eMP.PrefixRequired.label" bundle="${mp_labels}"/></th>
	<th><fmt:message key="eMP.NumberingControl.label" bundle="${mp_labels}"/></th>
	<th><fmt:message key="eMP.SeriesType.label" bundle="${mp_labels}"/></th>
	<th><fmt:message key="eMP.DefaultCardReader.label" bundle="${mp_labels}"/></th>
<%	}
	if ( i % 2 == 0 )
	classValue = "QRYEVEN" ;
	else
	classValue = "QRYODD" ;
	out.println("<tr><td class='" + classValue + "'>");
	String code = rs.getString("pat_ser_grp_code");
	out.println("<a href='../jsp/PatientNumberModify.jsp?pat_ser_grp_code="+ code + "' target='f_query_add_mod' >");
	out.println(code+"</a></td><td class='" + classValue + "'>");
	out.println( rs.getString("long_desc") );
	out.println("</td><td class='" + classValue + "'>");
	out.println(rs.getString("short_desc") );
	


	out.println("</td><td align='center' class='" + classValue + "'>");
	out.println(checkForNull(rs.getString("scheme_name"),"&nbsp") );
	out.println("</td><td align='center' class='" + classValue + "'>");

	if ( rs.getString("gen_pat_id_yn").equals("Y") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
		out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");


	out.println("</td><td align='center' class='" + classValue + "'>");

	if ( rs.getString("prefix_reqd_yn").equals("Y") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
		out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");

	out.println("</td><td class='" + classValue + "'>");

	pat_no_ctrl=rs.getString("pat_no_ctrl");
	if(pat_no_ctrl==null)
		pat_no_ctrl="&nbsp";
	if(pat_no_ctrl.equals("U"))
	{
	pat_no_ctrl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.facility.label","common_labels");
	}
	else if(pat_no_ctrl.equals("Z"))
	{
	pat_no_ctrl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Site.label","common_labels");
	}
	else if(pat_no_ctrl.equals("N"))
	{
		pat_no_ctrl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.none.label","common_labels");
	}
//out.println("</td><td align='center' class='" + classValue + "'>");
	out.println(pat_no_ctrl);
	out.println("</td><td class='" + classValue + "'>");


	if( rs.getString("id_type")==null ||rs.getString("id_type").equals("") || rs.getString("id_type").equals("null"))
		out.println("&nbsp; ");
	else if(rs.getString("id_type").equals("G"))
		out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.GeneralSeries.label","mp_labels"));
	else if(rs.getString("id_type").equals("N"))
		out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NationalIDSeries.label","mp_labels"));
	else  if(rs.getString("id_type").equals("A"))
		out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.AlternateIDSeries.label","mp_labels"));
	else  if(rs.getString("id_type").equals("E"))
		out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.EmergencySeries.label","mp_labels"));
	else  if(rs.getString("id_type").equals("B"))
		out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NewBornSeries.label","mp_labels"));
	else  if(rs.getString("id_type").equals("U"))
		out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.UnrestrictedSeries.label","mp_labels"));
	else  if(rs.getString("id_type").equals("X"))
		out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ExternalSourceSeries.label","mp_labels"));
	else  if(rs.getString("id_type").equals("R"))
		out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ExternalPatientDonorSeries.label","mp_labels"));
	out.println("</td><td align='center' class='" + classValue + "'>");
	if ( rs.getString("default_yn").equals("Y") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img></td>");
	else
		out.println("<img src='../../eCommon/images/RRnwd.gif'></img></td>");
	i++;
	cnt++;
}   

if (cnt==0)
{
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
}
boolean flag = false;
if ( cnt < 14 || (!rs.next()) ) {
%>
	<script >
	if (document.getElementById("next"))
		document.getElementById("next").style.visibility='hidden';
	</script>
<% flag = true;
		} else {%>
	<script >
	if (document.getElementById("next"))
		document.getElementById("next").style.visibility='visible';
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%}%>
</td></tr>
</table>
<br><center>
<%

}catch(Exception e) { 
	e.printStackTrace();
}
finally	
{
	if (rs != null) rs.close();
	if (pstmt != null) pstmt.close();
}

}catch(Exception e) { 
	e.printStackTrace();
}
finally { 
	if(conn!=null) ConnectionManager.returnConnection(conn,request);
}
%>
</center>
</BODY>
</HTML>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

