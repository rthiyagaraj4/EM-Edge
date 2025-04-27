<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../js/RegEmailRecipient.js'></script>
<!-- ****  Modified by Ambiga--CSS @02-02-09 **** -->

<HTML>
<head>
 <% 
    request.setCharacterEncoding("UTF-8");
	String sStyle =  (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
    int pageCnt = Integer.parseInt(MstQryPageCnt);
 %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	
</head>

<BODY class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
 <%

	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
	StringBuffer sql = new StringBuffer();
	String from = request.getParameter("from") ;
    String to = request.getParameter("to") ;
	String module_id  = request.getParameter("module_id")==null?"":request.getParameter("module_id");
    String report_id = request.getParameter("report_id")==null?"":request.getParameter("report_id");
    String report_desc = request.getParameter("report_desc")==null?"":request.getParameter("report_desc");
    String body_text_ref = request.getParameter("body_text_ref")==null?"":request.getParameter("body_text_ref");
    String body_text_desc = request.getParameter("body_text_desc")==null?"":request.getParameter("body_text_desc");
	if ( (whereClause == null || whereClause.equals("")) )
    {
		if ( !(module_id == null || module_id.equals("")) )
        {
			sql.append(" and a.module_id like upper('"+module_id +"%')");
        }
		if ( !(report_id == null || report_id.equals("")) )
        {
			sql.append(" and  a.report_id  like upper('"+report_id+"%')");
        }
		if ( !(body_text_ref == null || body_text_ref.equals("")) )
        {
			sql.append(" and upper(A.body_text_ref ) like upper('"+body_text_ref+"%')");
	    }

		if ( !(report_desc == null || report_desc.equals("")) )
        {			
			sql.append(" and upper(c.report_desc) like upper('"+report_desc+"%')");
		        }
		if ( !(body_text_desc == null || body_text_desc.equals("")) )
        {
			sql.append(" and upper(a.body_text_desc) like UPPER('"+body_text_desc+"%')");

        }
	  
    String ord[] = request.getParameterValues("orderbycolumns");

    if ( !(ord == null || ord .equals("")) )
    {
        sql.append(" order by ");
        for ( int i=0;i < ord.length;i++ )
        {		
			if(ord[i].equals("body_text_ref") || ord[i].equals("body_text_desc") )
			{
				ord[i]="a."+ord[i];
			}
			else
			{
				ord[i]="c."+ord[i];
			}
			
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

Connection conn  =  ConnectionManager.getConnection(request);

PreparedStatement stmt1=null;
PreparedStatement stmt=null;
int maxRecord = 0;
ResultSet rset = null;
ResultSet rs = null;

String strsql="select count(*) as total from SM_REPORT_MAIL_BODY a,sm_module b,sm_report c where a.module_id=b.module_id and a.module_id=c.module_id and a.report_id=c.report_id "+sql.toString();


String strsql1="select a.module_id module_id,b.module_name module_name,a.report_id report_id,c.report_desc report_desc,A.body_text_ref,A.body_text_desc body_text_dec from SM_REPORT_MAIL_BODY a,sm_module b,sm_report c where a.module_id=b.module_id and a.module_id=c.module_id and a.report_id=c.report_id "+sql.toString();

try
{
stmt = conn.prepareStatement(strsql);
rs = stmt.executeQuery();
rs.next();
maxRecord = rs.getInt("total");
if(maxRecord == 0)
{
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
}
%>
<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
<tr>
<td class='white' width='88%'></td> 
<td  align='right' width='12%'>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eCA/jsp/EmailRepBodyTxtQueryResult.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none' class='gridLink'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+pageCnt) > maxRecord ) )
    out.println("&nbsp;<A HREF='../../eCA/jsp/EmailRepBodyTxtQueryResult.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none' class='gridLink'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<table  width="100%" class="grid">
<td class='columnheadercenter' width='25%' nowrap><fmt:message key="Common.Module.label" bundle="${common_labels}"/></td>
<td class='columnheadercenter' width='10%' nowrap><fmt:message key="Common.ReportID.label" bundle="${common_labels}"/></td>
<td class='columnheadercenter' width='25%' nowrap><fmt:message key="Common.ReportDesc.label" bundle="${common_labels}"/></td>
<td class='columnheadercenter' width='15%' nowrap><fmt:message key="eCA.ReportBodyTextID.label" bundle="${ca_labels}"/></td>
<td class='columnheadercenter' width='25%' nowrap><fmt:message key="eCA.ReportBodyTextDesc.label" bundle="${ca_labels}"/></td>
<%
stmt1=conn.prepareStatement(strsql1);
rset = stmt1.executeQuery();

if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rset.next() ;
String classValue= " ";
 while ( rset.next() && i<=end  )
{
   /* if ( i % 2 == 0 )
         classValue = "QRYEVEN" ;
     else
         classValue = "QRYODD" ;*/
		 classValue = "gridData";

	out.println("<tr><td class='" + classValue + "' >");

		String module_id1	=(rset.getString("module_id")==null)?"":rset.getString("module_id");
		String module_name1	=(rset.getString("module_name")==null)?"":rset.getString("module_name");
		String report_id1	 =(rset.getString("report_id")==null)?"":rset.getString("report_id");
		String report_desc1	 =(rset.getString("report_desc")==null)?"":rset.getString("report_desc");
		String body_text_ref1	 =(rset.getString("body_text_ref")==null)?"":rset.getString("body_text_ref");
		String body_text_dec1		=(rset.getString("body_text_dec")==null)?"":rset.getString("body_text_dec");
	out.println(module_name1);
    out.println("</td><td class='" + classValue + "' nowrap>");
	out.println(report_id1);
	out.println("</td><td class='" + classValue + "' >");
	out.println(report_desc1);
    out.println("</td><td class='" + classValue + "' nowrap>");
	out.println(body_text_ref1);
    out.println("</td><td class='" + classValue + "' >");
	out.println("<a href='../../eCA/jsp/EmailRepBodyTxt.jsp?mode=modify&module_id="+ URLEncoder.encode(module_id1)+"&report_id="+ URLEncoder.encode(report_id1)+"&report_desc="+ URLEncoder.encode(report_desc1)+"&body_text_ref="+ URLEncoder.encode(body_text_ref1)+"&body_text_dec="+ URLEncoder.encode(body_text_dec1)+"' target='f_query_add_mod' class='gridLink' >");
    out.println(body_text_dec1 + "</a></td>");
	i++;
} %>

</td></tr>
</table>
</center>

<br><center>
<%

if(rs!=null) rs.close();
if(stmt!=null) stmt.close();

if(rset!=null) rset.close();
if(stmt1!=null) stmt1.close();
}
catch(Exception e)
{
	//out.println("Exception from EmailRepBodyTxtQueryResult.jsp : "+e.getMessage());//common-icn-0181
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

