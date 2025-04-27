<!DOCTYPE html>
<%--
	FileName	: queryHlthCareSetgTypRestns.jsp
	Version	    : 3	
	Modified On	: 17-2-2005
--%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<HTML>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<BODY OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' class='CONTENT' onKeyDown = 'lockKey()' >
<%
request.setCharacterEncoding("UTF-8");	
	String whereClause = request.getParameter("whereclause");
	//String sql ;
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	StringBuffer sbQuery = new StringBuffer();

	if ( (whereClause == null || whereClause.equals("")) )
	{
	//sql = "";
	String from_code = request.getParameter("from_hcare_setting_type_code");
	String to_code = request.getParameter("to_hcare_setting_type_code");
	String from_desc = request.getParameter("from_hcare_setting_type_desc");
	String to_desc = request.getParameter("to_hcare_setting_type_desc");
	
	
	int andCheck = 1;


	if ( !(from_code == null || from_code.equals("")) )
		{
		sbQuery.append(" and upper(from_hcare_setting_type_code) like upper('"+from_code+"%')");
		//sql = " and upper(from_hcare_setting_type_code) like upper('"+from_code+"%')";
		andCheck = 1;
		}


	if ( !(to_code == null || to_code.equals("")) )
	{
		if ( andCheck == 1 )
		{	
			sbQuery.append(" and ");
			//sql = sql + " and ";
			sbQuery.append("upper(to_hcare_setting_type_code) like  upper('"+to_code+"%')");
			//sql = sql + "upper(to_hcare_setting_type_code) like  upper('"+to_code+"%')" ;
		}
	}

	if ( !(from_desc == null || from_desc.equals("")) )
	{
		if ( andCheck == 1 )
		{	
			sbQuery.append(" and ");
			//sql = sql + " and ";
			sbQuery.append("upper(f.short_desc)  like  upper('"+from_desc+"%') ");
			//sql = sql + "upper(f.long_desc)  like  upper('"+from_desc+"%') " ;
		}
	}

	if ( !(to_desc == null || to_desc.equals("")) )
	{
		if ( andCheck == 1 )
		{	
			sbQuery.append(" and ");
			//sql = sql + ;
			sbQuery.append(" upper(t.short_desc)  like  upper('"+to_desc+"%') ");
			//sql = sql + " upper(t.long_desc)  like  upper('"+to_desc+"%') " ;
		}
	}


	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");
	//out.println("order by values are "+ord.toString());
	if ( !(ord == null || ord .equals("")) )
	{
		sbQuery.append(" order by ");
		//sql=sql+" order by ";
		for ( int i=0;i < ord.length;i++ )
	 	{
	 	if ( i == ord.length - 1 )
			sbQuery.append(ord[i]);
			//sql=sql+ord[i];
		else
			sbQuery.append(ord[i]+",");
			//sql=sql+ord[i]+",";
		}
	}
	} //end of where clause IF
	else
	{sbQuery.setLength(0);
		sbQuery.append( whereClause);}
		//sql = whereClause;

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

		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int maxRecord = 0;



try{
	pstmt = conn.prepareStatement("select from_hcare_setting_type_code,f.short_desc from_desc,to_hcare_setting_type_code,t.short_desc to_desc,ip_referral_yn,op_referral_yn from am_hcare_setting_type_rstrn r,am_hcare_setting_type f,am_hcare_setting_type t where r.from_hcare_setting_type_code = f.hcare_setting_type_code and r.to_hcare_setting_type_code = t.hcare_setting_type_code "+sbQuery.toString());

	rs = pstmt.executeQuery();

	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  rs.next() ;

	while ( i<=end  && rs.next())
	{
		if(maxRecord==0)
		{
%>
<P>
<table align='right'>
<tr>
<%
if ( !(start <= 1) )
	out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/queryHlthCareSetgTypRestns.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

//if ( !( (start+14) > maxRecord ) )
	out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eAM/jsp/queryHlthCareSetgTypRestns.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
%>

</tr>
</table>
</P>
<br><br>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th class='columnheader'><fmt:message key="eAM.FromHealthCareSettingType.label" bundle="${am_labels}"/><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="eAM.ToHealthCareSettingType.label" bundle="${am_labels}"/><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="eAM.IPReferral.label" bundle="${am_labels}"/></th>
<th class='columnheader'><fmt:message key="eAM.OPReferral.label" bundle="${am_labels}"/></th>

<%}
 	
	  String classValue = "" ;

	if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
		classValue = "QRYODD" ;

	String f_code = rs.getString("from_hcare_setting_type_code");
	String t_code = rs.getString("to_hcare_setting_type_code");

	out.println("<tr><td class='" + classValue + "'>");
	out.println("<a href='../../eAM/jsp/HlthCareSetgTypRestnsModify.jsp?from_hcare_setting_type_code="+ f_code + "&to_hcare_setting_type_code="+t_code+" ' target='f_query_add_mod' >");
	out.println(f_code+"</a></td>");

	out.println("</td><td class='" + classValue + "'>");
	out.println( rs.getString("from_desc") );
	out.println("</td>");

	out.println("<td class='" + classValue + "'>");
	out.println(t_code+"</td>");

	out.println("<td class='" + classValue + "'>");
	out.println( rs.getString("to_desc") );
	out.println("</td>");

	out.println("<td align='center' class='" + classValue + "'>");
		if ( rs.getString("ip_referral_yn").equals("Y") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");
	
	out.println("<td align='center' class='" + classValue + "'>");
		if ( rs.getString("op_referral_yn").equals("Y") )
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
%>

</td></tr>
</table>
<br><center>
<%

	if (rs != null) rs.close();
	if (pstmt != null) pstmt.close();
}//end of try
catch(Exception e) { out.println(e.toString());}
finally
{
	
	ConnectionManager.returnConnection(conn,request);
}

%>
</center>
</BODY>
</HTML>



