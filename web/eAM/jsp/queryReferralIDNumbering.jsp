<!DOCTYPE html>
<%--
	FileName	: queryReferralIDNumbering.jsp
	Version	    : 3	
	Modified On	: 17-2-2005
--%>

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<HTML>
<head>

		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
</head>
<BODY  class='CONTENT' onKeyDown = 'lockKey()'  OnMouseDown='CodeArrest()'>
<%
request.setCharacterEncoding("UTF-8");	
    String whereClause = request.getParameter("whereclause");
	StringBuffer sbQuery = new StringBuffer();
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    String facilityid=(String)session.getValue("facility_id");

    int start=0;
    int end=0;
    int i=1;
    if(whereClause!=null)
        {
		sbQuery.append(whereClause);
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
try
{

conn  =  ConnectionManager.getConnection(request);
stmt = conn.createStatement();

sbQuery.setLength(0);
sbQuery.append("select A.* ,decode(sign(A.year_num-to_number(to_char(sysdate,'RRRR'))),-1,'Lesser','Greater') indicator from ");
sbQuery.append("am_ref_id_num_for_fcy A where a.facility_id= '" + facilityid +"' order by year_num ");
rs = stmt.executeQuery(sbQuery.toString());
sbQuery.setLength(0);

if ( start != 1 )
        for( int j=1; j<start; i++,j++ )
            rs.next() ;
while ( i<=end  && rs.next() )
        {
	if(maxRecord==0)
	{

%>

<P>
<table align='right'>
<tr>

<%
if ( !(start <= 1) )
    out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/queryReferralIDNumbering.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

//if ( !( (start+14) > maxRecord ) )
    out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eAM/jsp/queryReferralIDNumbering.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
%>

</tr>
</table>
</P>
<br><br>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th class='columnheader'><fmt:message key="Common.year.label" bundle="${common_labels}"/> </th>
<th class='columnheader'><fmt:message key="eAM.NextReferralNumber.label" bundle="${am_labels}"/></th>
<% }
    if(rs!=null)
    {

     
        String classValue=" ";
            if ( i % 2 == 0 )
            classValue = "QRYEVEN" ;
            else
            classValue = "QRYODD" ;
            out.println("<tr><td class='" + classValue + "'>");
            String code = String.valueOf(rs.getInt("year_num"));
            if(rs.getString("indicator").equals("Greater"))
                out.println("<a href='../../eAM/jsp/addModifyReferralIDNumbering.jsp?year_num="+ code + "' target='f_query_add_mod' >");
            out.println(code+"</a></td><td class='" + classValue + "'>");

            out.println( String.valueOf(rs.getInt("next_referral_num") ) );
            out.println("</td>");
            i++;
			maxRecord++;
        }//end of while
    }

if ( maxRecord < 14 || (!rs.next()) ) {
%>
	<script >
	if (document.getElementById('next'))
		document.getElementById('next').style.visibility='hidden';
	</script>
<%
		} else {%>
	<script >
	if (document.getElementById('next'))
		document.getElementById('next').style.visibility='visible';
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%}
			 if(rs!=null)    rs.close();
			 if(stmt!=null)  stmt.close();
       
    }//end of try
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

