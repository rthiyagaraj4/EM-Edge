<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,eCommon.Common.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>

<HTML><head>
<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");

%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY  class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >

<%
	Boolean isDeathCasesAppl;
	String whereClause = request.getParameter("whereclause");
	StringBuffer  sql=new StringBuffer() ;
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	if ( (whereClause == null || whereClause.equals("")) )
	{
	String cd    = request.getParameter("DEATH_MANNER_CODE")==null ?"":request.getParameter("DEATH_MANNER_CODE");
	String desc    = request.getParameter("long_desc")==null ?"":request.getParameter("long_desc");
	String enabled    = request.getParameter("EFF_STATUS")==null ?"":request.getParameter("EFF_STATUS");
    String query_death_case=request.getParameter("QUERY_DEATH_CASE")==null ?"":request.getParameter("QUERY_DEATH_CASE");
	int andCheck = 0;
	if ( !(cd == null || cd.equals("")) )
			{
			sql.setLength(0);
			sql.append(" where upper(DEATH_MANNER_CODE) like upper('"+cd+"%')");
			andCheck = 1;
			}

		if ( !(desc == null || desc.equals("")) )
			{
				if ( andCheck == 1 )
				{	sql.append("  and upper(LONG_DESC)  like  upper('"+desc+"%') ");
						
				}
				else
				{  sql.setLength(0);
					sql.append(" where upper(LONG_DESC)  like upper('"+desc+"%') ") ;
					andCheck = 1;
				}
		}
		if ( !(enabled == null || enabled.equals("")) )
		{
		   if ( enabled.equals("E") )
		   {
			 if ( andCheck == 0 )
			{
				sql.setLength(0);
				sql.append(" where EFF_STATUS='E'");
			 }
			 else
			   sql.append(" and EFF_STATUS='E'");
		  }
		   if ( enabled.equals("D") )
			{
		     if ( andCheck == 0 )
				{
				sql.setLength(0);
				sql.append(" where  EFF_STATUS='D'");
				}
			 else
				sql.append(" and EFF_STATUS='D'");
				andCheck = 1;
		  }
	}
	//Added By shanmukh on 7th-AUG-2018 for ML-MMOH-CRF-1096
    if ( !(query_death_case == null || query_death_case.equals("") || query_death_case.equals(" ")) )
			{
				if ( andCheck == 1 )
				{	sql.append("  and upper(DEATH_CASE)  like  upper('"+query_death_case+"%') ");
				}
				else
				{  sql.setLength(0);
					sql.append(" where upper(DEATH_CASE)  like upper('"+query_death_case+"%') ") ;
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
			sql.append(ord[i]+",");
		}
	}
	}else
	{
	sql.append(whereClause);
	} //end of where clause IF
	
	int start = 0 ;
	int end = 0 ;
	int i=1;
	int cnt = 0;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;
Connection conn =null; 
Statement stmt=null;
//ResultSet rset=null;
ResultSet rs=null;
//int maxRecord = 0;

try{

conn=ConnectionManager.getConnection(request);
isDeathCasesAppl = eCommon.Common.CommonBean.isSiteSpecific(conn,"MO","DEATH_CASES_APPL");//Added by Shanmukh on 20th-JULY-2018 for ML-MMOH-CRF-1096
stmt = conn.createStatement();
/*
StringBuffer strsql1=new StringBuffer();
strsql1.append("select count(*) as total from mo_manner_of_death "+sql.toString());
rs = stmt.executeQuery(strsql1.toString());
if (rs.next())
{	
	maxRecord = rs.getInt("total");
}
if(rs!=null) rs.close();
if(maxRecord == 0)
out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
*/
StringBuffer strsql2=new StringBuffer();
strsql2.append("select * from mo_manner_of_death "+sql.toString());
rs = stmt.executeQuery(strsql2.toString());

		if ( start != 1 )
			for( int j=1; j<start; i++,j++ )
				rs.next() ;
	
		while(i<=end && rs.next()) 
		{		 
			if(cnt==0)
			{
%>

<P>
<table align='right'>
<tr >
<td>
<%
if ( !(start <= 1) )
	out.println("<A HREF='../../eMO/jsp/MannerOfDeathQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

	out.println("<A id='nextval' HREF='../../eMO/jsp/MannerOfDeathQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
	<br><br>
</P>

<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<td class='columnheader'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
<td class='columnheader'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
<td class='columnheader'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
<%if(isDeathCasesAppl){%>
<td class='columnheader'><fmt:message key="eMR.Death.label" bundle="${mr_labels}"/>&nbsp;<fmt:message key="eAE.Cases.label" bundle="${ae_labels}"/></td><%}%>
<td class='columnheader'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>

<%
	}
/*
if ( start != 1 )
for( int j=1; j<start; i++,j++ ){
rs.next() ;
}
*/
 String classValue = "" ;

//while ( rs.next() && i<=end )
//{
		if ( i % 2 == 0 )
		classValue = "QRYEVEN" ;
		else
		classValue = "QRYODD" ;
		out.println("<tr><td class='" + classValue + "'>");
		String code = rs.getString("DEATH_MANNER_CODE");
		out.println("<a href='../../eMO/jsp/addModifyMannerOfDeath.jsp?body_cond_code="+ code + "' target='f_query_add_mod' >");
		out.println(code+"</a></td><td class='" + classValue + "' wrap >");
		out.println( rs.getString("long_desc") );
		out.println("</td>");
		out.println("<td class='" + classValue + "' wrap >");
	    out.println( rs.getString("short_desc") );
	    out.println("</td>");
		if(isDeathCasesAppl){
//Added by Shanmukh on 20th-JULY-2018 for ML-MMOH-CRF-1096
		String death_case= rs.getString("death_case");
		death_case = (death_case == null)?"":death_case;
		if(death_case.equals("A")){
	   death_case="Accident";
   }else if(death_case.equals("M")){
	    death_case="Murder";
   }else if(death_case.equals("S")){
	    death_case="Suicide";
   }else if(death_case.equals("N")){
	    death_case="Natural";
   }else if(death_case.equals("UD")){
	    death_case="Undetermined";
   }else if(death_case.equals("UC")){
	    death_case="Unclassified";
   }else if(death_case.equals("P")){
	    death_case="Pending lx";
   }else if(death_case.equals("O")){
	    death_case="Others";
   }
        out.println("<td class='"+classValue+"' wrap>"+death_case+"&nbsp;</td>");
  //END	
		}  
		out.println("<td class='" + classValue + "' align='center' >");
		if ( rs.getString("EFF_STATUS").equals("E") )
		out.print("<img src='../../eCommon/images/enabled.gif'></img>");
		else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
		i++;
		cnt++;
       //strsql1.setLength(0);
	   strsql2.setLength(0);
	   sql.setLength(0);
  }//endwhile

  if(cnt==0)
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");

   if( !rs.next() && cnt!=0 )
   {
	%>
	<script>
		document.getElementById('nextval').innerHTML = " ";
	</script>
	<%
   }		

    if(rs!=null)	rs.close();
	if(stmt!=null)	stmt.close();
	}
	catch(Exception e){
		out.println("Exception in File MannerOfDeathQueryResult"+e.toString());
}
	finally   {
	
	ConnectionManager.returnConnection(conn,request);
	

	}
%>

</td></tr>
</table>
<br><center>
</center>
</BODY>
</HTML>

