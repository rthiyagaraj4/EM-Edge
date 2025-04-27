<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<%


String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");

out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >");
	Connection conn = null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	String whereClause = request.getParameter("whereclause");
	StringBuffer sql = new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;

	if ( (whereClause == null || whereClause.equals("")) )
	{
	String cd    = request.getParameter("Bay_Type_Code")==null ?"":request.getParameter("Bay_Type_Code");

	String desc    = request.getParameter("long_desc")==null ?"":request.getParameter("long_desc");
	String enabled    = request.getParameter("EFF_STATUS")==null ?"":request.getParameter("EFF_STATUS");
	int andCheck = 0;

	if ( !(cd == null || cd.equals("")) )
			{
			cd=cd.toUpperCase();
			sql.append("where upper(BAY_TYPE_CODE) like upper('"+cd+"%')");
			andCheck = 1;
			}

		if ( !(desc == null || desc.equals("")) )
			{
				if ( andCheck == 1 )
				{	sql.append(" and ");
					sql.append(" upper(LONG_DESC)  like  upper('"+desc+"%') ");
				}
				else
				{
					sql.append("where upper(LONG_DESC)  like upper('"+desc+"%') " );
					andCheck = 1;
				}
			}


		if ( !(enabled == null || enabled.equals("")) )
		{
		   if ( enabled.equals("E") )
		        {
			if ( andCheck == 0 )
				sql.append("where EFF_STATUS='E'");
			else
				sql.append(" and EFF_STATUS='E'");
			}
		   if ( enabled.equals("D") )
			{
			if ( andCheck == 0 )
				sql.append(" where  EFF_STATUS='D'");
			else
				sql.append(" and EFF_STATUS='D'");
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
	else {
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


try{
	conn = ConnectionManager.getConnection(request);
StringBuffer strsql2=new StringBuffer();
strsql2.append("select * from AE_BAY_TYPE ");
strsql2.append(sql.toString());

stmt= conn.prepareStatement(strsql2.toString());
rs = stmt.executeQuery();
	  String classValue = "" ;
	  int cnt=0;
	  String endOfRes="1";
	  	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  {
	    rs.next() ;
	  }
  
 while ( rs!=null && rs.next() && i<=end ){
	if(cnt==0){

%>

<P>
<table align='right'>
<tr >
<td>
<%
if ( !(start <= 1) )
	out.println("<A HREF='../../eAE/jsp/BayTypeQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if (endOfRes.equals("1"))
	out.println("<A id='nextvalue' HREF='../../eAE/jsp/BayTypeQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
	<br><br>
</P>

<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

<%}
if ( i % 2 == 0 )
		classValue = "QRYEVEN" ;
	else
		classValue = "QRYODD" ;

	out.println("<tr><td class='" + classValue + "'>");
	String code = rs.getString("BAY_TYPE_CODE");


	out.println("<a href='../../eAE/jsp/AddModifyBayType.jsp?bay_type_code="+ code + "' target='f_query_add_mod' >");
	out.println(code+"</a></td><td class='" + classValue + "' wrap >");
	out.println( rs.getString("long_desc") );


	out.println("</td><td class='" + classValue + "' wrap >");
	out.println(rs.getString("short_desc"));
	out.println("</td>");

	out.println("<td class='" + classValue + "' align='center' >");
	if ( rs.getString("EFF_STATUS").equals("E") )
		out.print("<img src='../../eCommon/images/enabled.gif'></img>");
	else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	i++;

	cnt++;
 }//endwhile
 if(cnt==0)
	 out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
 if(!rs.next()&&cnt!=0){
	endOfRes="0";%>
	<script>
		document.getElementById("nextvalue").innerHTML=" ";
	</script>
	<%}
if(rs!=null)	rs.close();
if(stmt!=null)	stmt.close();

}catch(Exception e){
		e.printStackTrace();
}
	finally   {
	if(conn != null)
	ConnectionManager.returnConnection(conn,request);
	

	}
%>

</td></tr>
</table>
<br><center>
</center>
</BODY>
</HTML>

