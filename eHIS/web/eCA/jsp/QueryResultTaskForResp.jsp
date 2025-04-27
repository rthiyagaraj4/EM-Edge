<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<HTML>
<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />	
	
</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
	Connection conn =null;
	PreparedStatement stmt  = null;
	PreparedStatement stmt1 = null;
	ResultSet rset = null;
	ResultSet rs = null;

    String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    StringBuffer sql = new StringBuffer();
    String appl_task_id  = request.getParameter("appl_task_id");
	if(appl_task_id==null) appl_task_id="";
    String appl_task_name = request.getParameter("appl_task_desc");
	if(appl_task_name==null) appl_task_name="";
    String resp_id = request.getParameter("resp_id");
	if(resp_id==null) resp_id="";
	String resp_name=request.getParameter("resp_name");
	if(resp_name==null) resp_name="";
	String privilege_status =request.getParameter("privilege_status");
	if(privilege_status ==null) privilege_status ="";

	String srl_no="";
	String prvlg_status="";
    if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;
	if(sql.length() > 0) sql.delete(0,sql.length());
	if ( !(appl_task_id == null || appl_task_id.equals("")) )
        {
	        sql.append(" and upper(a.appl_task_id) like upper('"+appl_task_id +"%')");
			cnt++;
        }

	if ( !(appl_task_name == null || appl_task_name.equals("")) )
		{
			sql.append(" and upper(b.appl_task_desc) in (Select upper(appl_task_desc)  from ca_appl_task where upper(appl_task_desc)  like upper('"+appl_task_name +"%')) ");

		}

	if ( !(resp_id == null || resp_id.equals("")) )
        {
	        sql.append(" and upper(a.resp_id) like upper('"+resp_id+"%')");
			cnt++;
        }

        if ( !(resp_name == null || resp_name.equals("")) )
        {
			sql.append(" and upper(c.resp_name) in (Select upper(resp_name) from sm_resp where upper(resp_name) like upper('"+resp_name+"%')) ");
        }

    if ( !(privilege_status == null || privilege_status.equals("")) )
    {
         if( privilege_status.equals("A") )
         {

         sql.append(" and a.privilege_status='A'");

         }
         else if ( privilege_status.equals("X") )
         {
              sql.append(" and a.privilege_status='X'");
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
        end = 14 ;
    else
        end = Integer.parseInt( to ) ;
try
{

 conn  =  ConnectionManager.getConnection(request);

int maxRecord = 0;


StringBuffer strsql= new StringBuffer();
strsql.append("select count(*) as total from ca_appl_task_for_resp_reln a, ca_appl_task b, sm_resp c where a.appl_task_id=b.appl_task_id and a.resp_id=c.resp_id ");
strsql.append(sql);
//out.println(sql);
stmt = conn.prepareStatement(strsql.toString());

StringBuffer strsql1= new StringBuffer();
strsql1.append("select a.appl_task_id, b.appl_task_desc,a.resp_id,c.resp_name, a.privilege_status,a.srl_no  from  ca_appl_task_for_resp_reln a, ca_appl_task b, sm_resp c where a.appl_task_id=b.appl_task_id and a.resp_id=c.resp_id   ");
strsql1.append(sql);
//out.println(strsql1);
 rs = stmt.executeQuery();
 rs.next();
maxRecord = rs.getInt("total");

if(maxRecord == 0){
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
}

stmt1=conn.prepareStatement(strsql1.toString());
rset = stmt1.executeQuery();
%>
<P>
<table align='center'cellpadding='3'width='100%'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eCA/jsp/QueryResultTaskForResp.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eCA/jsp/QueryResultTaskForResp.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>

<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<td class='columnheadercenter' width='20%'><fmt:message key="eCA.TaskID.label" bundle="${ca_labels}"/></td>
<td class='columnheadercenter' width='25%'><fmt:message key="eCA.TaskDesc.label" bundle="${ca_labels}"/></td>
<td class='columnheadercenter' width='20%'><fmt:message key="Common.ResponsibilityID.label" bundle="${common_labels}"/></td>
<td class='columnheadercenter' width='25%'><fmt:message key="Common.ResponsibilityName.label" bundle="${common_labels}"/></td>
<td class='columnheadercenter' width='10%'><fmt:message key="eCA.Applicable.label" bundle="${ca_labels}"/></td>

<%
	String status_image="";
    if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rset.next() ;
String classValue= " ";
      while ( rset.next() && i<=end  )
{
    if ( i % 2 == 0 )
                    classValue = "QRYEVEN" ;
                else
            classValue = "QRYODD" ;

    appl_task_id = rset.getString(1);
    appl_task_name=rset.getString(2);
    resp_id= rset.getString(3);
    resp_name= rset.getString(4);
    prvlg_status= rset.getString(5);
    srl_no= rset.getString(6);

    out.println("<tr><td align=='left' class='" + classValue + "'>");
	out.println("<a href='../../eCA/jsp/AddModifyTaskForResp.jsp?appl_task_id="+ appl_task_id + "&srl_no="+srl_no+"' target='f_query_add_mod' >");
       out.println(appl_task_id+"</a></td><td class='" + classValue + "'>");
 //   out.println("<a href='../../eCA/jsp/AddModifyTaskForResp.jsp?appl_task_id="+ appl_task_id + "&srl_no="+srl_no+"' target='f_query_add_mod' >");
    out.println( appl_task_name );
    out.println("</td><td class='" + classValue + "'>");
	 out.println("<a href='../../eCA/jsp/AddModifyTaskForResp.jsp?appl_task_id="+ appl_task_id + "&srl_no="+srl_no+"' target='f_query_add_mod' >");
    out.println(resp_id );
    out.println("</a></td><td class='" + classValue + "'>");
   // out.println("<a href='../../eCA/jsp/AddModifyTaskForResp.jsp?appl_task_id="+ appl_task_id + "&srl_no="+srl_no+"' target='f_query_add_mod' >");
    out.println(resp_name );
	out.println("</td>");
    out.println("</td><td align=center class='" + classValue + "'>");
			if(prvlg_status.equals("A")){
				status_image = "<img src='../../eCommon/images/enabled.gif'></img>";
			}else{
				status_image = "<img src='../../eCommon/images/RRnwd.gif'></img>";
			}

	 out.println(status_image);
	out.println("</td>");
	i++;
} %>

</td></tr>
</table>
</center>

<br><center>
<%
	if(rs!=null) rs.close();
	if(rset!=null) rset.close();
    if(stmt!=null)	stmt.close();
	if(stmt1!=null)	stmt1.close();
}
catch(Exception e)
{
	//out.println(e);//common-icn-0181
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

