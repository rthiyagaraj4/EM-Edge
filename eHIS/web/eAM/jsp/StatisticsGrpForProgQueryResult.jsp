<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<HTML>
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<BODY   OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' class='CONTENT' onLoad=''>
<%

request.setCharacterEncoding("UTF-8");	
	String strsql2="";
	String sql=" ";
	String strsql1=" ";

	String whereClause = request.getParameter("whereclause");
	String sql1 = request.getParameter("sql1");
	if(sql1 == null || sql1.equals("null")) sql1 = "";
	String sql2 = request.getParameter("sql2");
	if(sql2 == null || sql2.equals("null")) sql2 = "";
	String orderby = request.getParameter("orderby");
	if(orderby == null || orderby.equals("null")) orderby = "";

	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	//int andCheck = 0;
try {
	if ( (whereClause == null || whereClause.equals("")) )
	{

		sql=" ";
		String module_id    = request.getParameter("module_id");
		String module_name    = request.getParameter("module_name");
		String program_id= request.getParameter("program_id");
		String program_name= request.getParameter("program_name");
		String program_type  = request.getParameter("program_type") ;
		String stat_grp_id  = request.getParameter("stat_grp_id") ;				
		String stat_grp_desc  = request.getParameter("stat_grp_desc") ;				

		if (!(module_id == null || module_id.equals("")) )
		{
			module_id=module_id.toUpperCase();
			sql=sql+ " and upper(a.module_id) like upper('"+module_id+"%')  ";
		}

		if (!(module_name == null || module_name.equals("")) )
		{
				sql=sql+ " and upper(d.module_name)  like upper('"+module_name+"%') ";
		}

		if ( !(program_type == null || program_type.equals("")) && !program_type.equals("B"))
		{
			sql=sql+ " and upper(program_type)  like upper('"+program_type+"%') " ;
		}

		if ( !(program_id == null || program_id.equals("")))
		{
			sql=sql+ " and upper(program_id) like upper('"+program_id+"%')" ;
		}

		if ( !(program_name == null || program_name.equals("")) )
		{
			sql1 = " and upper(c.report_desc)  like upper('"+program_name+"%') " ;
			sql2 = " and upper(c.function_name)  like upper('"+program_name+"%') " ;
		}

		if ( !(stat_grp_id == null || stat_grp_id.equals("")))
		{
			sql=sql+ " and upper(a.stat_grp_id) like upper('"+stat_grp_id+"%')" ;
		}

		if ( !(stat_grp_desc == null || stat_grp_desc.equals("")) )
		{
			sql=sql+ " and upper(b.stat_grp_desc) like upper('"+stat_grp_desc+"%')" ;
		}

		//appending order by clause

		String ord[] = request.getParameterValues("orderbycolumns");

		if ( !(ord == null || ord .equals("")) )
		{
			orderby=orderby+" order by ";

			for ( int i=0;i < ord.length;i++ )
			{
			if ( i == ord.length - 1 )
				orderby=orderby+ord[i];
			else
				orderby=orderby+ord[i]+",";
			}

		}

	}// end if whereClause
	else {
		sql = whereClause;

	}
}
catch(Exception e) {out.println("here "+e); }	

try{
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

Connection conn =ConnectionManager.getConnection(request);//(Connection)session.getValue("connection") ;
Statement stmt=null;
//ResultSet rset=null;
ResultSet rs=null;
int maxRecord = 0;

try
{
	//String facilityId = (String) session.getValue( "facility_id" ) ;
	stmt = conn.createStatement();
	strsql1="select count(program_id) total from am_stat_grp_for_program where "+
		" program_id in ( select a.program_id from am_stat_grp_for_program a,am_stat_group b, "+
		" sm_report c,sm_module d where a.stat_grp_id = b.stat_grp_id and a.program_id = c.report_id "+
		" and a.module_id = d.module_id and a.program_type = 'R' "+sql+sql1+
		" UNION ALL select a.program_id "+
		" from am_stat_grp_for_program a, am_stat_group b, sm_function c, sm_module d "+
		" where a.stat_grp_id = b.stat_grp_id and "+
		" a.program_id = c.function_id and a.module_id = d.module_id and "+
		" a.program_type = 'F' "+sql+sql2+") ";
	//out.println(strsql1);
	rs = stmt.executeQuery(strsql1);
	rs.next();
	maxRecord = rs.getInt("total");
		if(maxRecord == 0)
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");

	
	strsql2="select a.module_id, a.program_id, c.report_desc program_name, a.program_type, a.sequence_no, "+
		" a.stat_grp_id, b.stat_grp_desc,d.module_name "+
		" from am_stat_grp_for_program a, am_stat_group b, sm_report c, sm_module d "+
		" where a.stat_grp_id = b.stat_grp_id and a.program_id = c.report_id "+
		" and a.module_id = d.module_id and a.program_type = 'R' "+sql+sql1+
		" UNION ALL select a.module_id, a.program_id, "+
		" c.function_name program_name, a.program_type, a.sequence_no,	a.stat_grp_id,b.stat_grp_desc,d.module_name "+
		" from am_stat_grp_for_program a, am_stat_group b, sm_function c, sm_module d "+
		" where a.stat_grp_id = b.stat_grp_id and a.program_id = c.function_id "+
		" and a.module_id = d.module_id and a.program_type = 'F' "+sql+sql2+orderby;
	//out.println(strsql2);
	if(rs!=null)rs.close();
	rs = stmt.executeQuery(strsql2);
	
	%>

<P>
<table align='right'>
<tr >
<td>
<%
if ( !(start <= 1) )
	out.println("<A HREF=\"../../eAM/jsp/StatisticsGrpForProgQueryResult.jsp?from="+(start-13)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"&sql1="+URLEncoder.encode(sql1)+"&sql2="+URLEncoder.encode(sql2)+"&orderby="+URLEncoder.encode(orderby)+"\""+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF=\"../../eAM/jsp/StatisticsGrpForProgQueryResult.jsp?from="+(start+13)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"&sql1="+URLEncoder.encode(sql1)+"&sql2="+URLEncoder.encode(sql2)+"&orderby="+URLEncoder.encode(orderby)+"\""+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
</P>
<br><br>
	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
	<th><fmt:message key="Common.ModuleName.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="eAM.ProgramType.label" bundle="${am_labels}"/></th>
	<th><fmt:message key="eAM.ProgramName.label" bundle="${am_labels}"/></th>
	<th><fmt:message key="Common.StatisticsGroup.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="eAM.SequenceNumber.label" bundle="${am_labels}"/></th>

	<%
		if ( start != 1 )
		 for( int j=1; j<start; i++,j++ ){
		  rs.next() ;

		  }

		String classValue = "" ;

		while ( rs.next() && i<=end )
		{
			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;

			String module_id = rs.getString("module_id");
			String module_name = rs.getString("module_name");
			String program_id = rs.getString("program_id");
			String program_name = rs.getString("program_name");
			String program_type = rs.getString("program_type");
			String stat_grp_id = rs.getString("stat_grp_id");
			String stat_grp_desc = rs.getString("stat_grp_desc");
			String seq_no = rs.getString("sequence_no");
			
			out.println("<tr><td class='" + classValue + "'>");
			out.println("<a href=\"../../eAM/jsp/AddModifyStatisticsGrpForProg.jsp?operation=modify&module_id="+module_id+"&module_name="+java.net.URLEncoder.encode(module_name)+"&program_id="+program_id+"&program_type="+program_type+"&program_name="+java.net.URLEncoder.encode(program_name)+"&stat_grp_id="+stat_grp_id+"&stat_grp_desc="+java.net.URLEncoder.encode(stat_grp_desc)+"&sequence_number="+seq_no+"\" >");
			out.println(module_name+"</a></td>");
			out.println("<td class='" + classValue + "' >");
			if ( program_type.equals("R") )
				out.println("Report");
			else
				out.println("Function");
			out.println("</td><td class='" + classValue + "' >");
			out.println(program_name);
			out.println("</td><td class='" + classValue + "' >");
			out.println(stat_grp_desc);
			out.println("</td><td class='" + classValue + "' align='right'>");
			out.println(seq_no);
			out.println("</td></tr>");	
			i++;

		}//endwhile

}
catch(Exception e){
		out.println(e.toString());
}

finally {
	if(rs!=null)	 	rs.close();
	if(stmt!=null)	stmt.close();
	
//	if(rset!=null) 	rset.close();
ConnectionManager.returnConnection(conn,request);
}
%>

</table>
<br><center>

<%
}
catch(Exception e2) {out.println("here too"+e2);}
%>

</center>
</BODY>
</HTML>

