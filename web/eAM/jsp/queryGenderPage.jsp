<!DOCTYPE html>
<%--
	FileName	: queryGenderPage.jsp
	Version	    : 3	
	Modified On	: 19-2-2005
--%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<%
out.println("<HTML><head>		<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/common.js' language='javascript'></script></head><BODY  OnMouseDown='CodeArrest()' onLoad='ClearMsg()' onKeyDown = 'lockKey()'  class='CONTENT'>");
 request.setCharacterEncoding("UTF-8");	
       // String facilityid=(String) session.getValue( "facility_id" ) ;
       	String whereClause = request.getParameter("whereclause");
	if(whereClause==null)
		whereClause="";
//	String sql=" " ;
	StringBuffer sbQuery = new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	int andCheck = 0;

	if ( (whereClause == null || whereClause.equals("")) )
	{
	//sql = "";
	String cd    = request.getParameter("Age_grp_code")==null ?"":request.getParameter("Age_grp_code");
	String longdesc  = request.getParameter("long_desc")==null ?"":request.getParameter("long_desc");
	String enabled    = request.getParameter("gender")==null ?"":request.getParameter("gender");
	String enabled1   = request.getParameter("nature")==null ?"":request.getParameter("nature");

	if ( !(cd == null || cd.equals("")) )
		{
		sbQuery.append("where upper(age_group_code) like upper('"+cd+"%')");
		//sql = "where upper(age_group_code) like upper('"+cd+"%')";
		andCheck = 1;
		}

	if ( !(longdesc == null || longdesc.equals("")) )
		{
			if ( andCheck == 1 )
			{	
				sbQuery.append("and ");
			//	sql = sql + " and ";
				sbQuery.append("upper(long_desc)  like  upper('"+longdesc+"%') ");
				//sql = sql + " upper(long_desc)  like  upper('"+longdesc+"%') " ;
			}
			else
			{
				sbQuery.setLength(0);
				sbQuery.append(	"where upper(long_desc) like upper('"+longdesc+"%') ");
			//	sql = "where upper(long_desc) like upper('"+longdesc+"%') " ;
				andCheck = 1;
			}
		}


	if ( !(enabled1 == null || enabled1.equals("")) )
	{
	   if ( enabled1.equals("E") )
	        {
		if ( andCheck == 0 )
			{
			sbQuery.setLength(0);
			sbQuery.append( "where eff_status='E'");
			andCheck = 1;
			//sql = "where eff_status='E'";andCheck = 1;
			}

		else
			sbQuery.append( "and eff_status='E'");
		//	sql = sql + " and eff_status='E'";
		}
	   if ( enabled1.equals("D") )
		{
		if ( andCheck == 0 )
			{
			sbQuery.setLength(0);
			sbQuery.append(" where  eff_status='D'");
			andCheck = 1;
			//sql = " where  eff_status='D'";andCheck = 1;
			}
		else
			sbQuery.append("and eff_status='D'");
			//sql = sql + " and eff_status='D'";
		}
	  }

	if ( !(enabled == null || enabled.equals("")) )
	{

	   if ( enabled.equals("U") )
	        {
		if ( andCheck == 0 )
			{
				sbQuery.setLength(0);
				sbQuery.append("where gender='U'");
				andCheck = 1;

		//	sql = "where gender='U'";andCheck = 1;
			}
		else
			sbQuery.append(" and gender='U'");
			//sql = sql + " and gender='U'";
		}
	   if ( enabled.equals("M") )
		{
		if ( andCheck == 0 )
			{
			sbQuery.setLength(0);
			sbQuery.append(" where  gender='M'");
			andCheck = 1;
			//sql = " where  gender='M'";andCheck = 1;
			}
		else
			sbQuery.append(" and gender='M'");
		//	sql = sql + " and gender='M'";
		}
	   if ( enabled.equals("F") )
	   	{
	   	// sql = sql; nothing is added to get both E and D
	   	if ( andCheck == 0 )
			{
			sbQuery.setLength(0);
			sbQuery.append(" where  gender='F'");
			andCheck = 1;
			//sql = " where  gender='F'";andCheck = 1;
			}
			else
			sbQuery.append(" and gender='F'");
			//sql = sql + " and gender='F'";
		}
	}

/*	if(andCheck==0)
	        {
			  	sql = "where facility_id = '"+facilityid+"'" ;
			  	andCheck = 1;
	        }
	else
		{
				sql = sql+" and";
				sql = sql+" facility_id = '"+facilityid+"'" ;
	}

*/
	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");

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
	{
		sbQuery.setLength(0);
		sbQuery.append(whereClause);
	 // sql=whereClause;
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

Connection conn = ConnectionManager.getConnection(request);
Statement stmt=null;
ResultSet rs=null;
int maxRecord = 0;

try
{

stmt = conn.createStatement();


rs = stmt.executeQuery("select * from am_age_group "+sbQuery.toString());

	 if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  rs.next() ;

	while ( i<=end && rs.next() )
	{
		if(maxRecord==0)
		{
%>

<p>
<table align='right'>
<tr>
<%
if ( !(start <= 1) )
	out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/queryGenderPage.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

//if ( !( (start+14) > maxRecord ) )
	out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eAM/jsp/queryGenderPage.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");

%>
</tr>
</table>
	<br><br>
</p>


<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.gender.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

<% }
 	
	  String classValue = "" ;

        if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
		  else
		  	classValue = "QRYODD" ;


	out.println("<tr><td class='" + classValue + "'>");
	String code = rs.getString("AGE_GROUP_CODE");
	out.println("<a href='../../eAM/jsp/addModifyGenderGroup.jsp?age_grp_code="+ code + "' target='f_query_add_mod' >");
	out.println(code+"</a></td><td class='" + classValue + "'>");
	out.println( rs.getString("long_desc") );
	out.println("</td><td class='" + classValue + "'>");
	out.println(rs.getString("short_desc") );
	out.println("</td> <td class='" + classValue + "'>");
	String gend=rs.getString("gender") ;
	if(gend!=null)
		gend=gend.trim();
	if(gend==null|| gend.equals(""))
		out.println(" &nbsp ");

	else
	{
		if(gend.equals("U"))
			out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels"));
		if(gend.equals("M"))
			out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels"));
		if(gend.equals("F"))
			out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels"));
	}

	out.println("</td><td align='center' class='" + classValue + "'>");

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

	if(rs!=null) 	rs.close();
	if(stmt!=null)	stmt.close();
}
catch(Exception e){out.print(e);}
finally
{

ConnectionManager.returnConnection(conn,request);
}%>

</td></tr>
</table>
<br><center>
<!--%
if ( !(start <= 1) )
	out.println("<A HREF='../../eAM/jsp/queryGenderPage.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'><img src='../../eCommon/images/previous.gif' alt='Previous' border='0'></A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='../../eAM/jsp/queryGenderPage.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'><img src='../../eCommon/images/next.gif' alt='Next' border='0'></A>");
%-->
<%
rs.close();
%>

</center>
</BODY>
</HTML>

