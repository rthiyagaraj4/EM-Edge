<!DOCTYPE html>
<%@ page import ="java.util.*,java.sql.*,java.net.*,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<!-- <script language='JavaScript' src='../../eCommon/js/messages.js'></script>
<script language='JavaScript' src='../../eOT/js/OTMessages.js'></script> -->

<HTML>
	<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

	<script language='javascript' src='../../eCommon/js/common.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
	String locale=(String)session.getAttribute("LOCALE");
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    String sql = " ";

    String package_code = request.getParameter("package_code")==null?"":request.getParameter( "package_code" );
	String long_description =request.getParameter("long_description")==null?"":request.getParameter( "long_description" );
	String short_description =request.getParameter("short_description")==null?"":request.getParameter( "short_description" );
	String enabled =request.getParameter("enabled")==null?"":request.getParameter( "enabled" );
		
    if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;

		if ( !(package_code == null || package_code.equals("")) ){
	        sql = sql + " and upper(package_code ) like upper('"+package_code +"%')";
			cnt++;
        }

        if ( !(long_description == null || long_description.equals("")) ){
			sql = sql + " and upper(long_desc) like upper('"+long_description+"%')";
			cnt=1;
        }
		if ( !(short_description == null || short_description.equals("")) ){
			sql = sql + " and upper(short_desc) like upper('"+short_description+"%')";
			cnt=1;
        }


		if ( !(enabled == null || enabled.equals("")) ){
         if( enabled.equals("E") ){
		   sql = sql+" and nvl(status,'E')='E' ";
			cnt=1;
         }

		 if ( enabled.equals("D") ){
		   sql = sql+" and status='D'";
		   cnt=1;
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

try { 

Connection conn  =  ConnectionManager.getConnection(request);
PreparedStatement stmt = null;
PreparedStatement stmt1 = null;
int maxRecord = 0;
ResultSet rset=null;
ResultSet rs = null;

	try{
		
		String strsql="select count(*) as total from OT_PACKAGE_HDR_LANG_VW  WHERE LANGUAGE_ID = ? "+sql;
			String strsql1="SELECT PACKAGE_CODE, LONG_DESC, SHORT_DESC, nvl(STATUS,'E') STATUS FROM OT_PACKAGE_HDR_LANG_VW WHERE LANGUAGE_ID =? "+sql;
		stmt = conn.prepareStatement(strsql);
		stmt.setString(1,locale);
        rs = stmt.executeQuery();
        rs.next();
		maxRecord = rs.getInt("total");
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
		}
		stmt1=conn.prepareStatement(strsql1);
		stmt1.setString(1,locale);
		rset = stmt1.executeQuery();
	}catch(Exception e){
		e.printStackTrace();
		//out.println("Err Msg From ConsumablePackQueryResult.jsp "+e);
	}
%>
<form name='QueryResult' id='QueryResult'>
<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eOT/jsp/ConsumablePackQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>Prev</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eOT/jsp/ConsumablePackQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>

<table  class='grid' border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>
<th class="columnheader" nowrap> <!-- changed by yadav -->
    <fmt:message key="Common.PackageCode.label" bundle="${common_labels}"/>
</th><!--20%-->
<th class="columnheader" nowrap> <!-- changed by yadav -->
     <fmt:message key="Common.longdescription.label" bundle="${common_labels}"/>
</th><!--30%-->
<th class="columnheader" nowrap> <!-- changed by yadav -->
       <fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/>
</th><!--30%-->
<th class="columnheader" nowrap> <!-- changed by yadav -->
<fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th><!--30%-->


<%
   if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rset.next() ;
String classValue= " ";
      while ( rset.next() && i<=end  )
{
    if ( i % 2 == 0 )
                    classValue = "gridData" ; // changed by yadav
                else
            classValue = "gridData" ; // changed by yadav
    out.println("<tr><td align=='left' class='" + classValue + "'>");

    package_code = rset.getString(1);
    long_description=rset.getString(2);
	short_description=rset.getString(3);
    
	String mode="modify";
	out.println("<a href='../../eOT/jsp/ConsumablePackFrameForCreate.jsp?update_mode_yn="+mode+"&package_code="+package_code+"' target='f_query_add_mod' >");
    out.println(package_code+"</a></td>");
  
   out.println("<td class='" + classValue+"'>"+long_description+"</td>");
   out.println("<td class='" + classValue+"'>"+short_description+"</td>");
   
   out.println("<td class='" + classValue + "' align='center'>");
    if ( rset.getString("STATUS").equals("E") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");

	//out.println("<td class='" + classValue + "' align='center'>");
	
  
  
    
	i++;
} %>

</tr>
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
	//out.println("here "+e);
}
%>

</center>
</form>
</BODY>
</HTML>

