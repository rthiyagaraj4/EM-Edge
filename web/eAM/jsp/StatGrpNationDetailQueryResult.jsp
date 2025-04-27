<!DOCTYPE html>
<%--
	FileName	: StatGrpNationDetailQueryResult.jsp
	Version	    : 3	
	Modified On	: 23-2-2005
--%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>




<%
	Connection conn = ConnectionManager.getConnection(request);///(Connection) session.getValue( "connection" ) ;
	Statement stmt = null;
	ResultSet rs = null;
	ResultSet rset =null;
	stmt = conn.createStatement();


	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY   OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' class='CONTENT' >");
request.setCharacterEncoding("UTF-8");	
	String whereClause = request.getParameter("whereclause");

	StringBuffer sql=new StringBuffer("") ;
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;


	if ( (whereClause == null || whereClause.equals("")) )
	{
		sql.setLength(0);
		sql.append("");
		String stat_grp_id = request.getParameter("stat_grp_id");
		String STAT_GRP_CAT = request.getParameter("STAT_GRP_CAT");
		String stat_grp_desc = request.getParameter("stat_grp_desc");
		//int andCheck = 1;

		if ( !((STAT_GRP_CAT == null || STAT_GRP_CAT.equals("")))&&!(STAT_GRP_CAT.equals("A")) )
		{
			sql.append(" and upper(b.STAT_GRP_CAT) like upper('"+STAT_GRP_CAT+"%')");
		}
		
		
		if ( !(stat_grp_id == null || stat_grp_id.equals("")) )
		{
			sql.append(" and upper(a.stat_grp_id) like upper('"+stat_grp_id+"%')");
		}

		if ( !(stat_grp_desc == null || stat_grp_desc.equals("")) )
		{
			sql.append("and upper(stat_grp_desc)  like  upper('"+stat_grp_desc+"%') " );
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
	else{
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

int maxRecord = 0;

	try{
String strsql1=" select count(distinct a.stat_grp_id) total from am_stat_grp_detail a, am_stat_group b "+
		"where a.stat_grp_id = b.stat_grp_id "+sql;
//out.println(strsql1);


rset = stmt.executeQuery(strsql1);
rset.next();
maxRecord = rset.getInt("total");
	if(maxRecord == 0)
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");

/*String strsql2=" select distinct a.stat_grp_id,b.stat_grp_desc stat_grp_desc,b.STAT_GRP_CAT STAT_GRP_CAT "+
		"from am_stat_grp_detail a, am_stat_group b "+sql;*/
String strsql2=" select distinct a.stat_grp_id,b.stat_grp_desc stat_grp_desc,b.STAT_GRP_CAT STAT_GRP_CAT "+
		"from am_stat_grp_detail a, am_stat_group b "+
		"where a.stat_grp_id = b.stat_grp_id "+sql;
//out.println(strsql2);
rs = stmt.executeQuery(strsql2);
%>

<p>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
	out.println("<A HREF='../../eAM/jsp/StatGrpNationDetailQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='../../eAM/jsp/StatGrpNationDetailQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

%>
</td>
</tr>
</table>
</p>
<br><br>

<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th><fmt:message key="eAM.StatisticsGroupID.label" bundle="${am_labels}"/></th>
<th><fmt:message key="Common.StatisticsGroup.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.category1.label" bundle="${common_labels}"/></th>
<%
 	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
	  rs.next() ;

	  }
	  String classValue = "" ;
	  String STAT_GRP_CAT="";
	  String STAT_GRP_CAT_DESC="";
	  
while ( rs.next() && i<=end )
{
        if ( i % 2 == 0 )
		  classValue = "QRYEVEN" ;
	else
		  classValue = "QRYODD" ;
		  
	STAT_GRP_CAT=rs.getString("STAT_GRP_CAT");
	if(STAT_GRP_CAT.equals("N"))
		STAT_GRP_CAT_DESC=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nationality.label","common_labels");
	else if(STAT_GRP_CAT.equals("S"))
		STAT_GRP_CAT_DESC=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.service.label","common_labels");
	
	else if (STAT_GRP_CAT.equals("P"))
	STAT_GRP_CAT_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
	
	

		
	out.println("<tr><td class='" + classValue + "'>");
	String stat_grp_id = rs.getString("stat_grp_id");
	//out.println("<a href='../../eAM/jsp/AddModifyStatGrpNationDetail.jsp?stat_grp_id="+ stat_grp_id + "&stat_grp_id="+ stat_grp_id + "&category="+STAT_GRP_CAT+"' target='f_query_add_mod' >");
	out.println(stat_grp_id+"</td><td class='" + classValue + "'>");
	out.println(rs.getString("stat_grp_desc"));
	out.println("</td><td class='" + classValue + "'>");
	out.println(STAT_GRP_CAT_DESC);
	out.println("</td>");
	i++;
	}
	 if (rs != null)   rs.close();
	  if (rset != null)   rset.close();
	 if (stmt != null) stmt.close();
	 
}
	catch(Exception e) {out.println(e);}
	finally {
		ConnectionManager.returnConnection(conn,request);
	}
%>

</td></tr>
</table>
<br><center>


</center>
</BODY>
</HTML>

