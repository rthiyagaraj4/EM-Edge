<!DOCTYPE html>
<%--
	FileName	: queryEncounter.jsp
	Version	    : 3	
	Modified On	: 21-2-2005
--%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<script src='../../eCommon/js/common.js' language='javascript'></script>
<HTML>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head><BODY  class='CONTENT'  onKeyDown = 'lockKey()'  OnMouseDown='CodeArrest()'>
<%

request.setCharacterEncoding("UTF-8");	
    String whereClause = request.getParameter("whereclause");
 //   String sql="" ;
	 StringBuffer sbQuery = new StringBuffer();
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    //String facilityid=session.getValue("facilty_id");
    String facilityid=(String)session.getValue("facility_id");

    int start=0;
    int end=0;
    int i=1;
    if(whereClause!=null)
        {
		sbQuery.append(whereClause);
       // sql = whereClause;
        }

    if ( from == null )
        start = 1 ;
    else
        start = Integer.parseInt( from ) ;

    if ( to == null )
        end = 14 ;
    else
        end = Integer.parseInt( to ) ;


Statement stmt=null;
ResultSet rs=null;
int maxRecord = 0;
Connection conn=null;
conn  =  ConnectionManager.getConnection(request);
try
{
//conn = (Connection) session.getValue( "connection" ) ;


stmt = conn.createStatement();
rs = stmt.executeQuery("select count(*) as total from pr_enc_id_num_for_fcy where facility_id = '"+facilityid+"'");
rs.next();
maxRecord = rs.getInt("total");

if(rs!=null)rs.close();
		if(maxRecord == 0)
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
sbQuery.setLength(0);
sbQuery.append("select A.* from ");
//sql = "select A.* from ";
sbQuery.append("pr_enc_id_num_for_fcy A where a.facility_id= '" + facilityid +"' ");
//sql +=  "pr_enc_id_num_for_fcy A where a.facility_id= '" + facilityid +"' ";
rs = stmt.executeQuery(sbQuery.toString());

%>

<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eAM/jsp/queryEncounter.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eAM/jsp/queryEncounter.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
	<br><br>
</P>

<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th align='left'><fmt:message key="eAM.NextNumber.label" bundle="${am_labels}"/></th>
<%
    if(rs!=null)
    {

        if ( start != 1 )
        for( int j=1; j<start; i++,j++ )
            rs.next() ;
        String classValue=" ";
        while ( rs.next() && i<=end )
        {
            if ( i % 2 == 0 )
            classValue = "QRYEVEN" ;
            else
            classValue = "QRYODD" ;
            out.println("<tr><td class='" + classValue + "'>");
            String code = String.valueOf(rs.getInt("next_num"));
            //if(rs.getString("indicator").equals("Greater"))
                out.println("<a href='../../eAM/jsp/addModifyEncounter.jsp?year="+ code + "' target='f_query_add_mod' >");
            out.println(code+"</a></td>");

            //out.println( String.valueOf(rs.getInt("next_num") ) );
            //out.println("</td>");
            i++;
        }
    }
		
        if(rs!=null)    rs.close();
		 if(stmt!=null)  stmt.close();
    }
    catch(Exception e){out.print(e);}
    finally
    {
       
        if(conn!=null) ConnectionManager.returnConnection(conn,request); 
    }
    %>

</td></tr>
</table>
<br><center>
</center>
</BODY>
</HTML>

