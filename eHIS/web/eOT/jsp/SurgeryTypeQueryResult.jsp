<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = (String)session.getAttribute("LOCALE"); 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
%>


<HTML>
	<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

	<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script Language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
	try
	{
   
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    String sql = " ";

    String nature_code = request.getParameter("nature_code")==null?"":request.getParameter( "nature_code" ).toUpperCase();
	String long_desc =request.getParameter("long_desc")==null?"":request.getParameter( "long_desc" ).toUpperCase();
	String short_desc =request.getParameter("short_desc")==null?"":request.getParameter( "short_desc" ).toUpperCase();
	String nature_type =request.getParameter("nature_type")==null?"":request.getParameter( "nature_type" );
    String enabled = request.getParameter("status")==null?"":request.getParameter( "status");

    if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;

		if ( !(nature_code == null || nature_code.equals("")) ){
	        sql = sql + " where UPPER(nature_code ) like upper('"+nature_code +"%')";
			cnt++;
        }

        if ( !(long_desc == null || long_desc.equals("")) ){
			if(cnt>0)
				sql = sql + " and UPPER(long_desc) like '"+long_desc+"%'";
			else{
				sql=sql+" where UPPER(long_desc) like '"+long_desc+"%'";
				cnt=1;
			}

        }
	   if ( !(short_desc == null || short_desc.equals("")) ){
			if(cnt>0)
				sql = sql + " and UPPER(short_desc) like '"+short_desc+"%'";
			else{
				sql=sql+" where UPPER(short_desc) like '"+short_desc+"%'";
				cnt=1;
			}

        }
	
	if ( !(nature_type == null || nature_type.equals("all")) ){
			if(cnt>0)
				sql = sql + " and nature_type like '"+nature_type+"%'";
			else{
				sql=sql+" where nature_type like '"+nature_type +"%'";
				cnt =1;
			}
        }

	
	if ( !(enabled == null || enabled.equals("")) ){
         if( enabled.equals("E") ){

			if(cnt>0)
			   sql = sql+" and nvl(status,'E')='E' ";
			else{
				sql=sql+ " where  nvl(status,'E')='E' ";
				cnt=1;
			}
         }

		 if ( enabled.equals("D") ){

            if(cnt>0)
			   sql = sql+" and status='D'";
			else
				sql=sql+ "where  status='D'";
         }

         if ( enabled.equals("B") ){
//               sql = sql; //nothing is added to get both E and D
         }
    }

    //appending order by clause
    String ord[] = request.getParameterValues("orderbycolumns");

    if ( !(ord == null || ord .equals("")) )
    {
        sql=sql+" order by ";
        for ( int i=0;i < ord.length;i++ )
        {
        if ( i == ord.length - 1 )
            sql=sql+ord[i];
        else
            sql=sql+ord[i]+",";
        }
    }

    } //end of where clause IF
    else
            sql = whereClause;



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

Connection conn  =  ConnectionManager.getConnection(request);

PreparedStatement stmt = null;
PreparedStatement stmt1 = null;
int maxRecord = 0;
ResultSet rset=null;
ResultSet rs = null;

	try{
		
		String strsql="select count(*) as total from OT_NATURE_OF_SURGERY "+sql;
		String strsql1="select nature_code,long_desc, short_desc, nature_type, nvl(status,'E') status from  OT_NATURE_OF_SURGERY "+sql;

		
		stmt = conn.prepareStatement(strsql);
		rs = stmt.executeQuery();

		rs.next();
		maxRecord = rs.getInt("total");
		
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
		}
		
		stmt1=conn.prepareStatement(strsql1);
		rset = stmt1.executeQuery();
		
	}catch(Exception e){
		e.printStackTrace();
	}
%>
<form name='QueryResult' id='QueryResult'>
<P>

<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eOT/jsp/SurgeryTypeQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eOT/jsp/SurgeryTypeQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>

<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>
	<th class="ColumnHeader" >
		<fmt:message key="Common.SurgeryType.label" bundle="${common_labels}"/>
	</th>
		
	<th class="ColumnHeader">
		<fmt:message key="Common.longdescription.label" bundle="${common_labels}"/>
	</th>
	<th class="ColumnHeader" >
			<fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/>	
	</th>
	<th class="ColumnHeader" >
			<fmt:message key="Common.type.label" bundle="${common_labels}"/>	
	</th> 
	<th class="ColumnHeader" >
			<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>	
	</th> 
<%
   if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rset.next() ;
String classValue= " ";
      while ( rset.next() && i<=end  )
{
    if ( i % 2 == 0 )
                    classValue = "gridData" ;
                else
            classValue = "gridData" ;
    out.println("<tr><td align=='left' class='" + classValue + "' nowrap>");

    nature_code = rset.getString(1);
    long_desc=rset.getString(2);
    short_desc= rset.getString(3);
	nature_type = rset.getString(4);
	
	if(nature_type.equals("EL")) nature_type="Elective";
	else if(nature_type.equals("EM")) nature_type="Emergency";
	String mode="modify";
	out.println("<a href='../../eOT/jsp/SurgeryTypeAddModify.jsp?mode="+mode+"&nature_code="+ nature_code+"' target='f_query_add_mod' >");
    out.println(nature_code+"</a></td>");
  
   out.println("<td class='" + classValue+"' nowrap>"+long_desc+"</td>");
   out.println("<td class='" + classValue+"' nowrap>"+short_desc+"</td>");
   out.println("<td class='" + classValue+"' nowrap>"+nature_type+"</td>");
  
   out.println("<td class='" + classValue + "' align='center' nowrap>");
    if ( rset.getString("status").equals("E") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");

	//out.println("<td class='" + classValue + "' align='center'>");
	

	i++;
} %>

</td></tr>
</table>
</center>

<br><center>
<%
if(stmt!=null)	stmt.close();
		if(stmt1!=null)	stmt1.close();
		if(rs!=null)	rs.close();
		if(rset!=null) rset.close();
ConnectionManager.returnConnection(conn,request);
}
catch(Exception e)
{
	e.printStackTrace();
}
%>

</center>
</form>
</BODY>
</HTML>

