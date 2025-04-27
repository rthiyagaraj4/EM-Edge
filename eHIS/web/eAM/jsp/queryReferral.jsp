<!DOCTYPE html>
<%--
	FileName	: queryReferral.jsp
	Version	    : 3	
	Modified On	: 17-2-2005
--%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<script src='../../eCommon/js/common.js' language='javascript'></script>

<%
	Connection conn=null;
	try{
		request.setCharacterEncoding("UTF-8");	
			conn = ConnectionManager.getConnection(request);
			Statement stmt=null;
			ResultSet rs=null;
%>

<HTML>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
	</head>
	<BODY class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
	String whereClause = request.getParameter("whereclause");
	//String sql ="" ;
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	StringBuffer sbQuery = new StringBuffer();
	

	if ( (whereClause == null || whereClause.equals("")) )
	{
	String cd = request.getParameter("referral_code");
	cd = cd.toUpperCase();
	String longdesc=request.getParameter("long_desc");
	String enabled = request.getParameter("eff_status");

	int andCheck = 0;
	cd=cd.toUpperCase();

	if ( !(cd == null || cd.equals("")) )
		{
		sbQuery.append("where referral_code like '");
		sbQuery.append(cd);
		sbQuery.append("%'");
		andCheck = 1;
		}
	if ( !(longdesc == null || longdesc.equals("")) )
	{
		if ( andCheck == 1 )

		{	
			sbQuery.append(" and ");
			sbQuery.append(" upper(a.long_desc)  like  upper('"+longdesc+"%') ");
		}
		else
		{
			sbQuery.append("where upper(a.long_desc)  like upper('"+longdesc+"%') ");
			andCheck = 1;
		}
	}

	if ( !(enabled == null || enabled.equals("")) )
	{
	   if ( enabled.equals("E") )
	   {
		if ( andCheck == 1 )
		{
			sbQuery.append("and a.eff_status='E'");
		}
		else
		{
			sbQuery.append(" where a.eff_status='E'");
			andCheck = 1;
		}
	   }
	   if ( enabled.equals("D") )
	   {
		if ( andCheck == 1 )
		{

			sbQuery.append("and  a.eff_status='D'");
		}
		else
		{
			sbQuery.append(" where a.eff_status='D'");
			andCheck = 1;
		}
	   }
	}

	if(andCheck == 0)
	sbQuery.append(" where a.HEALTHCARE_SETTING_TYPE = b.hcare_setting_type_code(+) ");
	else
	sbQuery.append(" and a.HEALTHCARE_SETTING_TYPE = b.hcare_setting_type_code(+) ");
	String ord[] = request.getParameterValues("orderbycolumns");

	if ( !(ord == null || ord .equals("")) )
	{
		sbQuery.append("order by ");
		for ( int i=0;i < ord.length;i++ )
	 	{
	 	if ( i == ord.length - 1 )
			sbQuery.append(ord[i]);
		else
			sbQuery.append(ord[i]+",");
		}
	}
	} //end of where clause IF
	else{
		sbQuery.setLength(0);
		sbQuery.append(whereClause);
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

try{
	



stmt = conn.createStatement();
int maxRecord = 0;

	
String str="select a.*,b.short_desc hcare_desc from am_referral a, am_hcare_setting_type b "+sbQuery.toString();
if(rs!=null)rs.close();
rs = stmt.executeQuery(str);



	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  rs.next() ;

	while ( i<=end && rs.next() )
	{
		if(maxRecord==0)
		{

%>

<P>
<table align='right' >
<tr >

<%
if ( !(start <= 1) )
	out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/queryReferral.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

//if ( !( (start+14) > maxRecord ) )
	out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eAM/jsp/queryReferral.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
%>
</tr>
</table>
</P>
<br><br>

<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th class='columnheader'> <fmt:message key="Common.referral.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.HealthcareSettingType.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

<% }
 	

	  String classValue = "" ;

	if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
			classValue = "QRYODD" ;

	out.println("<tr><td class='" + classValue + "'>");
	String code = rs.getString("referral_code");

	out.println("<a href='../../eAM/jsp/ReferralModify_Form.jsp?referral_code="+ code +"' target='f_query_add_mod' >");
	out.println(code+"</a></td><td class='" + classValue + "'>");
	out.println( rs.getString("long_desc") );
	out.println("</td><td class='" + classValue + "'>");
	out.println( rs.getString("short_desc") );
	out.println("</td><td class='" + classValue + "'>");
	if(rs.getString("hcare_desc")==null)
		out.println("&nbsp;");
	else
		out.println(rs.getString("hcare_desc"));

	out.println("</td>");
    out.println("<td class='" + classValue + "' align='center'>");

	if ( rs.getString("eff_status").equals("E") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
		out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	i++;
	maxRecord++;
	} //end of while

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

%>

</td></tr>
</table>
<br>

<%
	if ( stmt != null ) stmt.close() ;
	if ( rs != null ) rs.close() ;
	

}//end of try
catch ( Exception e ){out.println(e);}


	}catch(Exception es) { out.println(es);}
	finally
	{
		if(conn!=null) ConnectionManager.returnConnection(conn,request);
	}
%>


</BODY>
</HTML>

