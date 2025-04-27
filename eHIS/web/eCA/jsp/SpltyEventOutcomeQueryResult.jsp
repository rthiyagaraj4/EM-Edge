<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src="../../eCommon/js/common.js" language="javascript"></script>

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

	 String whereClause		=		request.getParameter("whereclause");
	if(whereClause==null) 
		whereClause="";

    StringBuffer sql=new StringBuffer();
	String from		=		request.getParameter( "from" ) ;
    String to				=		request.getParameter( "to" ) ;
	String event_desc_display = "";
	String outcome_desc_display = "";
	String close_episode_display = "";
	String module_id		=		request.getParameter("module_id");
	String event_id		=		request.getParameter("event_id");
    String event_desc	=		request.getParameter("event_desc");
    String outcome_code		=		request.getParameter("outcome_code");
    String outcome_desc		=		request.getParameter("outcome_desc");

	
	 if ( (whereClause == null || whereClause.equals("")) )
    {
			sql.append(" WHERE  A.MODULE_ID =B.MODULE_ID AND A.MODULE_ID =C.MODULE_ID AND A. OUTCOME_CODE = B.OUTCOME_CODE AND A.SPLTY_EVENT_CODE = C.SPLTY_EVENT_CODE ");

			if ( !(module_id == null || module_id.equals("")) )
				{
					if(module_id.equals("A")){ }
					else {
							sql.append(" and upper(A.MODULE_ID) like upper('"+module_id +"%')");
						 }
				}
			
			if ( !(event_id == null || event_id.equals("")) )
				{
					sql.append(" and upper(A.SPLTY_EVENT_CODE) like upper('"+event_id +"%')");
				}
			if ( !(event_desc == null || event_desc.equals("")) ){
					sql.append(" and upper(SPLTY_EVENT_DESC) like upper('"+event_desc+"%')");
				}

			if ( !(outcome_code == null || outcome_code.equals("")) ){
					sql.append(" and  upper(A.OUTCOME_CODE) like upper('"+outcome_code+"%')");
				}

			if ( !(outcome_desc == null || outcome_desc.equals("")) ){
					sql.append(" and upper(OUTCOME_DESC) like upper('"+outcome_desc+"%')");
				}
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

	Connection conn = null;

	PreparedStatement stmt1= null;
	int maxRecord = 0;
	ResultSet rset = null;
try
{
	conn  =  ConnectionManager.getConnection(request);	

	StringBuffer strsql=new StringBuffer();
	
	 strsql.append("select count(*) as total from CA_SPLTY_EVENT_OUTCOME A,CA_SPLTY_OUTCOME B ,CA_SPLTY_EVENT C");
	 strsql.append(sql);

	 stmt1=conn.prepareStatement(strsql.toString());
	 rset = stmt1.executeQuery();
	 rset.next();
	 maxRecord = rset.getInt(1);
	 if(rset !=null) rset.close();
	 if(stmt1 != null)stmt1.close();

	 if(maxRecord == 0){
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
	}

	String close_episode_yn ="";
	StringBuffer strsql1=new StringBuffer();

	strsql1.append("SELECT SPLTY_EVENT_DESC ,OUTCOME_DESC ,CLOSE_EPISODE_YN FROM CA_SPLTY_EVENT_OUTCOME A,CA_SPLTY_OUTCOME B ,CA_SPLTY_EVENT C ");
	strsql1.append(sql);

	stmt1=conn.prepareStatement(strsql1.toString());
	rset = stmt1.executeQuery();
	%>

	<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
	<tr>
	<td class='white' width='88%'></td> 
	<td  align='right' width='12%' nowrap>
	<%
	if ( !(start <= 1) )
		out.println("<A HREF='../../eCA/jsp/SpltyEventOutcomeQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

	if ( !( (start+14) > maxRecord ) )
		out.println("&nbsp;<A HREF='../../eCA/jsp/SpltyEventOutcomeQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		
	%>
	</td>
	</tr>
	</table>

	<table border="1" width="100%" cellspacing='0' cellpadding='3'>
	<td class='columnHeadercenter'><fmt:message key="Common.outcome.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td class='columnHeadercenter'><fmt:message key="Common.EventDescription.label" bundle="${common_labels}"/></td>
	<td class='columnHeadercenter'>Close Episode</td>

	<%
	   if ( start != 1 )
		 for( int j=1; j<start; i++,j++ )
		  rset.next() ;
	String classValue= " ";
		  while ( rset.next() && i<=end  ) {
			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;

			event_desc = rset.getString("SPLTY_EVENT_DESC");
			outcome_desc = rset.getString("OUTCOME_DESC");
			close_episode_yn = rset.getString("CLOSE_EPISODE_YN");

			event_desc_display = event_desc;
			outcome_desc_display = outcome_desc;
			close_episode_display =close_episode_yn;
			event_desc = java.net.URLEncoder.encode(event_desc);
			outcome_desc = java.net.URLEncoder.encode(outcome_desc);
			//outcome_desc = java.net.URLEncoder.encode(outcome_desc);
%>
			<tr>
			<td  class=' <%= classValue %>'><%=outcome_desc_display %></td>
			<td class='<%= classValue %>'><%=event_desc_display %></td>
			<%
			out.println("<td class='" + classValue + "' align='center'>");
			if ( close_episode_display.equalsIgnoreCase("Y") )
				out.println("<img src='../../eCommon/images/enabled.gif'></img>");
			else
				out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
			out.println("</td>");
%>
		</tr>

		<%
		i++;
		} 
	%>

	</table>
	</center>

	<br><center>
<%


	if(rset != null)rset.close();
	if(stmt1 != null)stmt1.close();

}
catch(Exception e)
{
	//out.println("Exception in main try"+e);//COMMON-ICN-0181
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

