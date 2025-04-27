<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<HTML>
<head>	
	<%
		request.setCharacterEncoding("UTF-8");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />	
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />	
		
	
	
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%

	Connection conn=null;
	PreparedStatement stmt = null;
	PreparedStatement stmt1 = null;
	ResultSet rset = null;
	ResultSet rs = null;


    String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    StringBuffer sql = new StringBuffer();
    String resp_id  = request.getParameter("resp_id");
	if(resp_id==null) resp_id="";
    String resp_name = request.getParameter("resp_name");
	if(resp_name==null) resp_name="";
    String pract_reln_id = request.getParameter("pract_reln_id");
	if(pract_reln_id==null) pract_reln_id="";
	String pract_reln_name=request.getParameter("pract_reln_name");

	//Modified by Archana @10-12-2008
	String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
    int pageCnt = Integer.parseInt(MstQryPageCnt);

	if(pract_reln_name==null) pract_reln_name="";

    if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;
	if(sql.length() > 0) sql.delete(0,sql.length());
	if ( !(resp_id == null || resp_id.equals("")) )
        {
	        sql.append(" and upper(a.resp_id) like upper('"+resp_id +"%')");
			cnt++;
        }

        if ( !(resp_name == null || resp_name.equals("")) )
        {
			sql.append(" and upper(b.resp_name) in (Select upper(resp_name)  from sm_resp where upper(resp_name)  like upper('"+resp_name +"%')) ");
        }
	if ( !(pract_reln_id == null || pract_reln_id.equals("")) )
        {
	        sql.append(" and upper(a.pract_reln_id) like upper('"+pract_reln_id +"%')");
			cnt++;
        }

        if ( !(pract_reln_name == null || pract_reln_name.equals("")) )
        {
			sql.append(" and upper(c.pract_reln_name) in (Select upper(pract_reln_name) from  ca_pract_reln  where upper(pract_reln_name) like upper('"+pract_reln_name+"%')) ");
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
			{
            sql.append(ord[i]);
			sql.append(",");
			}
        }
    }

    } //end of where clause IF
    else
            sql.append(whereClause);




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
try{
	 conn  =  ConnectionManager.getConnection(request);

int maxRecord = 0;
StringBuffer strsql= new StringBuffer();
if(strsql.length() > 0) strsql.delete(0,strsql.length());
strsql.append("select count(*) as total from ca_pract_reln_for_resp a, sm_resp b, ca_pract_reln c where a.resp_id=b.resp_id and a.pract_reln_id=c.pract_reln_id ");
strsql.append(sql);
//out.println(sql);
StringBuffer strsql1= new StringBuffer();
if(strsql1.length() > 0) strsql1.delete(0,strsql1.length());
strsql1.append("select a.resp_id, b.resp_name, a.pract_reln_id, c.pract_reln_name from ca_pract_reln_for_resp a, sm_resp b, ca_pract_reln c where a.resp_id=b.resp_id and a.pract_reln_id=c.pract_reln_id ");
strsql1.append(sql);
//out.println(strsql1);
stmt = conn.prepareStatement(strsql.toString());
rs = stmt.executeQuery();
rs.next();
maxRecord = rs.getInt("total");

if(maxRecord == 0){
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
}

stmt1=conn.prepareStatement(strsql1.toString());
rset = stmt1.executeQuery();
%>
<P>
<table width='100%' cellpadding=3 align='center'>
<tr>
<td align='right'>
<%
if ( !(start <= 1) )
    out.println("<A  class='gridLink' HREF='../../eCA/jsp/QueryResultRelnForResp.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+" </A>");

if ( !( (start+pageCnt) > maxRecord ) )
    out.println("<A  class='gridLink' HREF='../../eCA/jsp/QueryResultRelnForResp.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+" </A>");
%>
</td>
</tr>
</table>
<table class='grid' width="100%" cellspacing='0' cellpadding='3'>
<td class='COLUMNHEADERCENTER' width='25%'><fmt:message key="Common.ResponsibilityID.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADERCENTER' width='25%'><fmt:message key="Common.ResponsibilityName.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADERCENTER' width='25%'><fmt:message key="eCA.RelationshipID.label" bundle="${ca_labels}"/></td>
<td class='COLUMNHEADERCENTER' width='25%'><fmt:message key="eCA.RelationshipName.label" bundle="${ca_labels}"/></td>

<%
    if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rset.next() ;
String classValue= "GRIDDATA";
      while ( rset.next() && i<=end  )
{
/*    if ( i % 2 == 0 )
                    classValue = "QRYEVEN" ;
                else
            classValue = "QRYODD" ;*/
    out.println("<tr><td align=='left' class='" + classValue + "'>");

    resp_id = rset.getString(1);
    resp_name=rset.getString(2);
    pract_reln_id= rset.getString(3);
    pract_reln_name= rset.getString(4);

	out.println("<a class='gridLink' href='../../eCA/jsp/AddModifyRelnForResp.jsp?resp_id="+ resp_id + "&pract_reln_id="+pract_reln_id+"' target='f_query_add_mod' >");
       out.println(resp_id+"</a></td><td class='" + classValue + "'>");
    out.println( resp_name );
    out.println("</td><td class='" + classValue + "'>");

    out.println(pract_reln_id );
    out.println("</td><td class='" + classValue + "'>");
  
    out.println(pract_reln_name );
	out.println("</td>");
	i++;
} %>

</td></tr>
</table>
</center>

<br><center>
<%
	if(rs!=null)	rs.close();
	if(rset!=null) rset.close();
	if(stmt!=null)	stmt.close();
	if(stmt1!=null)	stmt1.close();
}
catch(Exception e)
{
	//out.println("Exception in AddModifyRelnForResp.jsp"+e.toString());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}

finally
{
	if(conn!=null)ConnectionManager.returnConnection(conn,request);
}
%>

</center>
</BODY>
</HTML>

