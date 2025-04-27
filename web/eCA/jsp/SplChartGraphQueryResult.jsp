<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script language='javascript' src='../../eCommon/js/common.js'></script>

<HTML>
<head>
<%
 request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
int pageCnt = Integer.parseInt(MstQryPageCnt);
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

</head>

<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">

 <%
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
	String from = request.getParameter("from") ;
    String to = request.getParameter("to") ;
	StringBuffer sql = new StringBuffer();
	
	String spl_chart_type  = request.getParameter("SPL_CHART_TYPE");
    String graph_code = request.getParameter("GRAPH_CODE");
    String graph_desc = request.getParameter("GRAPH_DESC");
    String eff_status= request.getParameter("EFF_STATUS");
		
	if(spl_chart_type == null)
	{
		spl_chart_type = "";
	}
	else
	{
		spl_chart_type = spl_chart_type.toUpperCase();
	}
	 
	if ((whereClause == null || whereClause.equals("")) )
    {
		if ( !(spl_chart_type == null || spl_chart_type.equals("")) )
        {		
				if(spl_chart_type.equals(" "))
					spl_chart_type = "";
				sql.append(" upper(a.spl_chart_type ) like upper('"+spl_chart_type +"%')");
        }

        if ( !(graph_code == null || graph_code.equals("")) )
        {
				sql.append(" and upper(a.graph_code) like upper('"+graph_code+"%')");
        }
		
		if (!(graph_desc == null || graph_desc.equals("")))
        {
				sql.append(" and a.graph_desc like upper('"+graph_desc+"%')");
        }

 		if ( !(eff_status == null || eff_status.equals("")) )
		{
			 if( eff_status.equals("E") )
			 {
			   sql.append(" and a.eff_status='E'");
			 }
			 if( eff_status.equals("D") )
			 {
			   sql.append(" and a.eff_status='D'");
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
	{
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
        end = pageCnt ;
    else
        end = Integer.parseInt( to ) ;

	Connection conn  = null;

	PreparedStatement stmt1 = null;
	int maxRecord = 0;
	ResultSet rset = null;


	String strsql1="select a.SPL_CHART_TYPE,b.SPL_CHART_TYPE_DESC,a.SPL_CHART_TYPE_GRP_ID,NVL((SELECT SPL_CHART_TYPE_GRP_DESC FROM CA_SPL_CHART_TYPE_GRP WHERE SPL_CHART_TYPE_GRP_ID=a.SPL_CHART_TYPE_GRP_ID),'*A') CH_GRP_DESC,a.GRAPH_CODE,a.GRAPH_DESC,NVL((SELECT ELEMENT_TYPE_DESC FROM CA_SPL_CHART_ELEMENT_TYPE WHERE ELEMENT_TYPE=a.X_AXIS_ELEMENT_TYPE),'Key Value') X_ELE,NVL((SELECT ELEMENT_TYPE_DESC FROM CA_SPL_CHART_ELEMENT_TYPE WHERE ELEMENT_TYPE=a.Y_AXIS_ELEMENT_TYPE),'****') Y_ELE,a.EFF_STATUS from CA_SPL_CHART_GRAPH a,CA_SPL_CHART_TYPE b where a.SPL_CHART_TYPE=b.SPL_CHART_TYPE and "+sql.toString();

	try
	{
	conn  =  ConnectionManager.getConnection(request);

	stmt1=conn.prepareStatement(strsql1,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	rset = stmt1.executeQuery();
	while(rset.next())
	{
		maxRecord++;
	}
	if(maxRecord == 0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
	}
%>

<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eCA/jsp/SplChartGraphQueryResult.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none' class='gridLink'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+pageCnt) > maxRecord ) )
    out.println("<A HREF='../../eCA/jsp/SplChartGraphQueryResult.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none' class='gridLink'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>

<table width="100%" class='grid'>
<tr>
	<td class='COLUMNHEADERCENTER' width='20%'><fmt:message key="eCA.Graph.label" bundle="${ca_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADERCENTER' width='20%'><fmt:message key="eCA.Graph.label" bundle="${ca_labels}"/> <fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADERCENTER' width='15%'><fmt:message key="Common.Chart.label" bundle="${common_labels}"/> <fmt:message key="Common.Group.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADERCENTER' width='15%'>X - <fmt:message key="eCA.Axis.label" bundle="${ca_labels}"/></td>
	<td class='COLUMNHEADERCENTER' width='15%'>Y- <fmt:message key="eCA.Axis.label" bundle="${ca_labels}"/></td>
	<td class='COLUMNHEADERCENTER' width='15%'><fmt:message key="Common.Chart.label" bundle="${common_labels}"/> <fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADERCENTER' width='10%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
</tr>
<%
rset.beforeFirst();
if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rset.next() ;
String classValue= " ";
  while ( rset.next() && i<=end  )
  {
	classValue = "gridData" ;

	String spl_chart_type1	=(rset.getString("SPL_CHART_TYPE")==null)?"":rset.getString("SPL_CHART_TYPE");
	String spl_chart_type_desc	=(rset.getString("SPL_CHART_TYPE_DESC")==null)?"":rset.getString("SPL_CHART_TYPE_DESC");
	String spl_chart_groupid = (rset.getString("SPL_CHART_TYPE_GRP_ID")==null)?"":rset.getString("SPL_CHART_TYPE_GRP_ID");
	String spl_chart_group1	=(rset.getString("CH_GRP_DESC")==null)?"":rset.getString("CH_GRP_DESC");
	String graph_code1		=(rset.getString("GRAPH_CODE")==null)?"":rset.getString("GRAPH_CODE");
	String graph_desc1	    =(rset.getString("GRAPH_DESC")==null)?"":rset.getString("GRAPH_DESC");
	String x_axis1			=(rset.getString("X_ELE")==null)?"":rset.getString("X_ELE");
	String y_axis1			=(rset.getString("Y_ELE")==null)?"":rset.getString("Y_ELE");
	String eff_status1		=(rset.getString("EFF_STATUS")==null)?"":rset.getString("EFF_STATUS");
  
	out.println("<tr>");
	out.println("<td class='" + classValue + "' >");
	out.println(graph_code1);
	out.println("</td>");
	out.println("<td class='" + classValue + "' >");
	out.println("<a href='../../eCA/jsp/SplChartGraphAddModify.jsp?mode=update&spl_chart_type="+ URLEncoder.encode(spl_chart_type1)+"&graph_code="+URLEncoder.encode(graph_code1)+"&spl_chart_group="+ URLEncoder.encode(spl_chart_groupid)+"' target='f_query_add_mod' class='gridLink'>");
    out.println(graph_desc1);
	out.println("</a></td>");
	out.println("<td class='" + classValue + "' >");
	out.println(spl_chart_group1);
	out.println("</td>");
	out.println("<td class='" + classValue + "' >");
	out.println(x_axis1);
	out.println("</td>");
	out.println("<td class='" + classValue + "' >");
	out.println(y_axis1);
	out.println("</td>");
	out.println("<td class='" + classValue + "' >");
	out.println(spl_chart_type_desc);
	out.println("</td>");
	out.println("<td class='" + classValue + "' >");
	
	if ( eff_status1.equalsIgnoreCase("E") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");
	out.println("</tr>");
	i++;
} %>

</td></tr>
</table>
</center>

<br><center>
<%
if(rset!=null) rset.close();
if(stmt1!=null) stmt1.close();
}
catch(Exception e)
{
	out.println("Exception from SplChartGraphQueryResult JSP : "+e.getMessage());
	e.printStackTrace();	
}
finally
{
	if (conn != null) 
	ConnectionManager.returnConnection(conn,request);
}	

%>

</center>
</BODY>
</HTML>

