<!DOCTYPE html>
<%--
	FileName	: ResultTemplateQueryCriteriaResult.jsp
	Version	    : 3	
	Modified On	: 22-2-2005
--%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>


<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<HTML>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	</head>
<BODY class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >
 <%
request.setCharacterEncoding("UTF-8");	
    String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";

	String from = request.getParameter("from") ;
    String to = request.getParameter("to") ;
	
	StringBuffer sql =new StringBuffer(" ");

	String result_template_id  = request.getParameter("RESULT_TEMPLATE_ID");
    String result_template_name = request.getParameter("RESULT_TEMPLATE_NAME");
    String eff_status = request.getParameter("eff_status");

	if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;

	if ( !(result_template_id == null || result_template_id.equals("")) )
        {
	        sql.append(" where upper(result_template_id ) like upper('"+result_template_id +"%')");
			cnt++;
        }

     
	if ( !(result_template_name == null || result_template_name.equals("")) )
        {
		if(cnt>0)
			{
	        sql.append(" and upper(RESULT_TEMPLATE_NAME ) like upper('"+result_template_name +"%')");
			}
			else
			{
				sql.append(" where upper(RESULT_TEMPLATE_NAME ) like upper('"+result_template_name +"%')");
				cnt++;
			}

        }

    if ( !(eff_status == null || eff_status.equals("")) )
    {
         if( eff_status.equals("E") )
         {
  			if(cnt>0)
			   sql.append(" and eff_status='E'");
			else
				sql.append(" where  eff_status='E'");
         }
         if ( eff_status.equals("D") )
	     {
			if(cnt>0)
			   sql.append(" and eff_status='D'");
			else
				sql.append(" where  eff_status='D'");
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
	{		sql.setLength(0);
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
Statement stmt = null,stmt1 = null;
ResultSet rset = null;
ResultSet rs = null;
int maxRecord = 0;

try
	{
	conn  =  ConnectionManager.getConnection(request);
	stmt = conn.createStatement();
	String strsql="select count(*) as total from am_result_template"+sql;
	String strsql1="select result_template_id,result_template_name, eff_status from  am_result_template "+sql;

	rs = stmt.executeQuery(strsql);
	rs.next();
	maxRecord = rs.getInt("total");
		if(stmt!=null) 	stmt.close();
	if(maxRecord == 0)
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
	stmt1=conn.createStatement();
	rset = stmt1.executeQuery(strsql1);
	%>
<P>
	<table align='right'>
		<tr>
			<td>
			<%
			if ( !(start <= 1) )
				out.println("<A HREF='../../eAM/jsp/ResultTemplateQueryCriteriaResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

			if ( !( (start+14) > maxRecord ) )
				out.println("<A HREF='../../eAM/jsp/ResultTemplateQueryCriteriaResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
			%>
			</td>
		</tr>
	</table>
	<br><br>
</p>

<table border="1" width="100%" cellspacing='0' cellpadding='0'>
	<th width='30%'><fmt:message key="Common.TemplateID.label" bundle="${common_labels}"/></th>
	<th width='50%'><fmt:message key="Common.TemplateName.label" bundle="${common_labels}"/></th>
	<th width='20%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

<%
   if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rset.next() ;
String classValue= " ";
      while ( rset.next() && i<=end  )
		{
		 if ( i % 2 == 0 )
                    classValue = "QRYEVEN" ;
                else
            classValue = "QRYODD" ;

	out.println("<tr><td align=='left' class='" + classValue + "'>");

    String result_template_id1		=(rset.getString(1)==null)?"":rset.getString(1);
    String result_template_name1	=(rset.getString(2)==null)?"":rset.getString(2);

	String eff_status1				=(rset.getString(3)==null)?"":rset.getString(3);

	out.println("<a href='../../eAM/jsp/ResultTemplateAddModify.jsp?mode=update&result_template_id="+ URLEncoder.encode(result_template_id1)+"' target='f_query_add_mod' >");
    out.println(result_template_id1 + "</a></td><td class='" + classValue + "'>");
    out.println(result_template_name1);
    out.println("</td><td align=center class='" + classValue + "'>");
    if ( eff_status1.equalsIgnoreCase("E") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");
	i++;
} %>

</td></tr>
</table>
</center>

<br><center>
<%if (rset != null) rset.close();
	if (stmt1 != null) stmt1.close();
}
catch(Exception e)
{}
finally
{
	try
	{
		if (rs != null)   rs.close();
		if (rset != null) rset.close();
		if (stmt != null) stmt.close();
		if (stmt1 != null) stmt1.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	ConnectionManager.returnConnection(conn,request);
}
%>
	</center>
  </BODY>
</HTML>

