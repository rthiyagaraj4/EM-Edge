<!DOCTYPE html>
<%--
	FileName	: ReactionQueryCriteria.jsp
	Version	    : 3	
	Modified On	: 21-2-2005
--%>


<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*, java.lang.*,webbeans.eCommon.*" 
contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<HTML>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<BODY  OnMouseDown='CodeArrest()' class='CONTENT' onKeyDown = 'lockKey()' >

<%
	request.setCharacterEncoding("UTF-8");	
	String whereClause = request.getParameter("whereclause");

//	String sql ;
	StringBuffer sbQuery = new StringBuffer();
	String from = request.getParameter( "from" ) ;

	String to = request.getParameter( "to" ) ;
	//sql="";

	if ( (whereClause == null || whereClause.equals("")) )
	{
		//sql="";
sbQuery.setLength(0);
		String reaction_code    = request.getParameter("reaction_code")==null ?"":request.getParameter("reaction_code");
		String long_desc    = request.getParameter("long_desc")==null ?"":request.getParameter("long_desc");
		String adverse_reaction_yn    = request.getParameter("adverse_reaction_yn")==null ?"":request.getParameter("adverse_reaction_yn");		
		String enabled    = request.getParameter("eff_status")==null ?"":request.getParameter("eff_status");
		//String facilityid=(String)session.getValue("facility_id");


	int andCheck 		= 0;
	if(reaction_code!= null)
		reaction_code		=reaction_code.toUpperCase();


	if ( !(reaction_code == null || reaction_code.equals("")) )
	{
		sbQuery.setLength(0);
		sbQuery.append("where upper(reaction_code) like upper('"+reaction_code+"%')");
		//sql = "where upper(reaction_code) like upper('"+reaction_code+"%')";
		andCheck = 1;
	}

	if ( !(long_desc == null || long_desc.equals("")) )
		{
			if ( andCheck == 1 )

			{	
				sbQuery.append(" and ");
				//sql = sql + " and ";
				sbQuery.append(" upper(long_desc)  like  upper('"+long_desc+"%') ");
				//sql = sql + " upper(long_desc)  like  upper('"+long_desc+"%') " ;
			}
			else
			{
				sbQuery.setLength(0);
//				sql = "where upper(long_desc)  like upper('"+long_desc+"%') " ;
                 sbQuery.append("where upper(long_desc)  like upper('"+long_desc+"%') ");
				andCheck = 1;
			}
	}

	if ( !(adverse_reaction_yn == null || adverse_reaction_yn.equals("")) )
	{
	   if ( adverse_reaction_yn.equals("Y") )
	   {
		if ( andCheck == 0 )
		{
			sbQuery.setLength(0);
			sbQuery.append("where adverse_reaction_yn='Y'");
		//	sql = "where adverse_reaction_yn='Y'";
			andCheck = 1;
		}
		else
			sbQuery.append("and adverse_reaction_yn='Y'");
			//sql = sql + " and adverse_reaction_yn='Y'";
	   }
	   if ( adverse_reaction_yn.equals("N") )
	   {
		if ( andCheck == 0 )
		{
			sbQuery.setLength(0);
			sbQuery.append("where  adverse_reaction_yn='N'");
			//sql = " where  adverse_reaction_yn='N'";
			andCheck = 1;
		}
		else
			sbQuery.append("and adverse_reaction_yn='N'");
			//sql = sql + " and adverse_reaction_yn='N'";
	   }
	}
	
	if ( !(enabled == null || enabled.equals("")) )
	{
	   if ( enabled.equals("E") )
	   {
		if ( andCheck == 0 )
		   {
			sbQuery.setLength(0);
			sbQuery.append(	"where eff_status='E'");
			//sql = "where eff_status='E'";
			}
		else
		   {
			sbQuery.append(	" and eff_status='E'");
			//sql = sql + " and eff_status='E'";
		   }
	   }
	   if ( enabled.equals("D") )
	   {
		if ( andCheck == 0 )
		   {
			sbQuery.setLength(0);
			sbQuery.append(	" where  eff_status='D'");
			//sql = " where  eff_status='D'";
		   }
		else
		   {
			sbQuery.append(	" and eff_status='D'");
			//sql = sql + " and eff_status='D'";
		   }
	   }
	}

	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");

	if ( !(ord == null || ord.equals("")) )
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

	else{
		sbQuery.setLength(0);
		sbQuery.append(whereClause);

		//sql = whereClause;

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
conn = ConnectionManager.getConnection(request);
Statement stmt=null;
ResultSet rs=null;
int maxRecord = 0;

try{
	

String strsql2="select * from am_reaction "+sbQuery.toString();

stmt = conn.createStatement();
if(rs!=null) rs.close();
rs = stmt.executeQuery(strsql2);

	 if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
	  rs.next() ;
	  }

	  while ( i<=end && rs.next() )
	{
		  if(maxRecord==0)
		{

%>

<P>
<table align='right'>
<tr>
<%
if ( !(start <= 1) )
	out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/ReactionTypeQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

//if ( !( (start+14) > maxRecord ) )
	out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eAM/jsp/ReactionTypeQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
%>
</tr>
</table>
</P>
<br><br>

<table border="1" width="100%" cellspacing='0' cellpadding='0'>

<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.AdverseReaction.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

<% }
 	
	  String classValue = "" ;
	if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
		  else
		  	classValue = "QRYODD" ;
		  


	out.println("<tr><td  class='" + classValue + "'>");
	String reaction_code = rs.getString("reaction_code");
	String long_desc = rs.getString("long_desc");
	String short_desc = rs.getString("short_desc");

	out.println("<a href='../../eAM/jsp/AddModifyReaction.jsp?reaction_code="+reaction_code+"' target='f_query_add_mod' >");
	out.println(reaction_code+"</a></td><td  class='" + classValue + "'>");
	//out.println("<a href='../../eAM/jsp/AddModifyReaction.jsp?disp_type="+disp_type+"' target='f_query_add_mod' >");
	out.println(long_desc+"</td><td  class='" + classValue + "'>");
	//out.println("<a href='../../eAM/jsp/AddModifyReaction.jsp?disp_type="+disp_type+"' target='f_query_add_mod' >");
	out.println(short_desc+"</td  class='" + classValue + "'>");

	out.println("<td align='center' class='" + classValue + "'>");

	if ( rs.getString("adverse_reaction_yn").equals("Y") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");

	out.println("<td align='center' class='" + classValue + "'>");	

	if ( rs.getString("eff_status").equals("E") )
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

  if(rs!=null) rs.close();
  if(stmt!=null) stmt.close();
}catch(Exception e){
	//	e.toString();
	//out.println(e);
	e.printStackTrace();
}
	finally   {
		
		ConnectionManager.returnConnection(conn,request);
	}
%>

</td></tr>
</table>
</BODY>
</HTML>

