<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>

<HTML>
	<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
   	String locale = (String)session.getAttribute("LOCALE");
	String ph_module_yn = request.getParameter("ph_module_yn");
try{
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    String sql = " ";
    String instr_code = request.getParameter("instr_code")==null?"":request.getParameter( "instr_code" ).trim().toUpperCase();
	String long_desc =request.getParameter("long_desc")==null?"":request.getParameter( "long_desc" ).trim().toUpperCase();
	String short_desc =request.getParameter("short_desc")==null?"":request.getParameter( "short_desc" ).trim().toUpperCase();
	String ss_group_code =request.getParameter("ss_group_code")==null?"":request.getParameter( "ss_group_code" ).trim().toUpperCase();
    String enabled = request.getParameter("status")==null?"":request.getParameter( "status");
	
    if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;

		if ( !(instr_code == null || instr_code.equals("")) ){
	        sql = sql + " where upper(instr_code ) like upper('"+instr_code +"%')";
			cnt++;
        }

        if ( !(long_desc == null || long_desc.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(long_desc) like '"+long_desc+"%'";
			else{
				sql=sql+" where upper(long_desc) like '"+long_desc+"%'";
				cnt=1;
			}

        }
	   if ( !(short_desc == null || short_desc.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(short_desc) like '"+short_desc+"%'";
			else{
				sql=sql+" where upper(short_desc) like '"+short_desc+"%'";
				cnt=1;
			}

        }
	
	if ( !(ss_group_code == null || ss_group_code.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(ss_group_code) like '"+ss_group_code+"%'";
			else{
				sql=sql+" where uppper(ss_group_code) like '"+ss_group_code +"%'";
				cnt =1;
			}
        }

	
	if ( !(enabled == null || enabled.equals("")) ){
         if( enabled.equals("E") ){

			if(cnt>0)
			   sql = sql+" and nvl(status,'E')='E' ";
			else{
				sql=sql+ " where nvl(status,'E')='E' ";
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
		
		String strsql="select count(*) as total from OT_INSTRUMENT "+sql;
		String strsql1="select instr_code,long_desc, short_desc,ss_group_code, nvl(status,'E') status from OT_INSTRUMENT "+sql;
		stmt = conn.prepareStatement(strsql);
		rs = stmt.executeQuery();

		rs.next();
		maxRecord = rs.getInt("total");
		
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
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
    out.println("<A HREF='../../eOT/jsp/InstrumentQueryResult.jsp?from="+(start-14)+"&ph_module_yn="+ph_module_yn+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>Prev</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eOT/jsp/InstrumentQueryResult.jsp?from="+(start+14)+"&ph_module_yn="+ph_module_yn+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>

<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>
<th class="columnheadercenter" nowrap> <!-- changed by yadav -->
	<fmt:message key="eOT.InstrumentCode.Label" bundle="${ot_labels}"/>
</th>
<th class="columnheadercenter" nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.longdescription.label" bundle="${common_labels}"/>
</th>
<th class="columnheadercenter" nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/>
</th>
<th class="columnheadercenter" nowrap> <!-- changed by yadav -->
	<fmt:message key="eOT.CrossRefSSGroup.Label" bundle="${ot_labels}"/>
</th>
<th class="columnheadercenter" nowrap> <!-- changed by yadav -->
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
                    classValue = "gridData" ;  // changed by yadav
                else
            classValue = "gridData" ;  // changed by yadav
    out.println("<tr><td align=='left' class='" + classValue + "' nowrap>");

    instr_code = rset.getString(1);
    long_desc=rset.getString(2);
    short_desc= rset.getString(3);
	ss_group_code = rset.getString(4);
	if(ss_group_code==null || ss_group_code.equals("null"))
	ss_group_code="&nbsp;";
	
	String mode="modify";
	out.println("<a href='../../eOT/jsp/InstrumentAddModify.jsp?mode="+mode+"&instr_code="+ instr_code+"' target='f_query_add_mod' >");
    out.println(instr_code+"</a></td>");
    out.println("<td class='" + classValue+"' nowrap>"+long_desc+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+short_desc+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+ss_group_code+"</td>");
    out.println("<td class='" + classValue + "' align='center'>");
    if ( rset.getString("status").equals("E") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");

//	out.println("<td class='" + classValue + "' align='center'>");
	/*if ( image_linked_yn.equals("Y") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");*/

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

