<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
08/04/2013    IN30708        Karthi      To incorporate the "Symbol" function  from Microsoft words to the Microsoft Editor in the clinical notes.
---------------------------------------------------------------------------------------------------------------
--> 
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src="../../eCommon/js/common.js" language="javascript"></script>

<HTML>
<head>
	<script language='javascript' src='../../eCA/js/CASymbolGroup.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
<%
    request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<style>
	td,th,tr
	{border-bottom: 1px solid #d5e2e5;
	}
</style>
</head>

<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
	String from = request.getParameter("from") ;
    String to = request.getParameter("to") ;
	StringBuffer sql = new StringBuffer();
	String group_id  = request.getParameter("groupid");
    String group_desc = request.getParameter("groupdesc");
	if(!(group_id == null || group_id.equals(""))){
		group_id = group_id.trim();
	}
	if(group_desc == null)
	{
		group_desc = "";
	}
	else
	{
		group_desc = group_desc.toUpperCase();
	}
   
    String eff_status= request.getParameter("eff_status");
	if ( (whereClause == null || whereClause.equals("")) )
    {	
		if ( !(group_id == null || group_id.equals("")) )
        {
			sql.append(" where upper(SG.SYMBOL_GROUP ) like upper('"+group_id +"%')");
        }

        if ( !(group_desc == null || group_desc.equals("")) )
        {		if(group_id == null || group_id.equals("")){
					sql.append(" where upper(SG.SYMBOL_GROUP_DESC) like '"+group_desc+"%'");
				}
				else
				{
					sql.append(" and upper(SG.SYMBOL_GROUP_DESC) like '"+group_desc+"%'");
				}	
        }  
		if ( !(eff_status == null || eff_status.equals("")) )
		{	if((group_id == null || group_id.equals("")) && (group_desc == null || group_desc.equals("")))
			{
				 if( eff_status.equals("E") )
					   sql.append(" where eff_status='E'");
				 
				 if ( eff_status.equals("D") )
					   sql.append(" where eff_status='D'");
			}
			else {
				 if( eff_status.equals("E") )
					   sql.append(" and eff_status='E'");
				 
				 if ( eff_status.equals("D") )
					   sql.append(" and eff_status='D'");
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
		 sql.append(whereClause);

    int start = 0 ;
    int end = 0 ;
    int i=1;

    if ( from == null )
        start = 1 ;
    else
        start = Integer.parseInt( from ) ;

    if ( to == null ){
		String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
		end =  Integer.parseInt(MstQryPageCnt);
	}
    else
        end = Integer.parseInt( to ) ;

Connection conn  = null;
PreparedStatement pstmt;
ResultSet rs = null;

int maxRecord = 0;

String strsql1="Select distinct(SG.SYMBOL_GROUP), SG.SYMBOL_GROUP_DESC, SG.EFF_STATUS from CA_SYMBOL_GROUP SG " +sql.toString();
try
{
	conn 	= ConnectionManager.getConnection(request);
	pstmt	= conn.prepareStatement(strsql1,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	rs		= pstmt.executeQuery();
	
	while(rs.next())
	{
		maxRecord++;
	}
	if(maxRecord == 0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
	}
	%>
	<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
		<tr>
			<td class='white' width='100%'></td> 
			<td  width='25%' nowrap>
			<%
				String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
				int pageCnt = Integer.parseInt(MstQryPageCnt);
			if ( !(start <= 1) )
				out.println("<A class='gridLink' HREF='../../eCA/jsp/CASymbolGroupQueryResult.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

			if ( !( (start+pageCnt) > maxRecord ) )
				out.println("&nbsp;<A class='gridLink' HREF='../../eCA/jsp/CASymbolGroupQueryResult.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
			%>
			</td>
		</tr>
	</table>

	<table class='grid' border="0" width="100%" cellspacing='0' cellpadding='3' style='border: 1px solid black;'>
	<tr align="left">
		<th class='columnheadercenter' width='15%'><fmt:message key="eCA.symbolgrpid.label" bundle="${ca_labels}"/></th>
		<th class='columnheadercenter' width='30%'><fmt:message key="eCA.symbolgrpdesc.label" bundle="${ca_labels}"/></th>
		<th class='columnheadercenter' width='10%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
	</tr>
	<%
	rs.beforeFirst();

	if ( start != 1 )
		for( int j=1; j<start; i++,j++ )
			rs.next() ;
	String classValue= " ";
	while ( rs.next() && i<=end  ){
		if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
			classValue = "QRYODD" ;

		out.println("<tr>");
		out.println("<td class='gridData'>");
			String group_id_	=(rs.getString("SYMBOL_GROUP")==null)?"":rs.getString("SYMBOL_GROUP");
			String group_desc_	 =(rs.getString("SYMBOL_GROUP_DESC")==null)?"":rs.getString("SYMBOL_GROUP_DESC");		
			String eff_status_	=	(rs.getString("EFF_STATUS")==null)?"":rs.getString("EFF_STATUS");
			
		out.println("<a class='gridLink' href='../../eCA/jsp/AddModifySymbolGroup.jsp?mode=2&group_id="+ URLEncoder.encode(group_id_)+"&group_desc="+ URLEncoder.encode(group_desc_)+"&eff_status="+ URLEncoder.encode(eff_status_)+"'target='f_query_add_mod' >");
		out.println(group_id_ + "</a></td>");
		out.println("<td class='gridData'>");
		out.println(group_desc_);
		out.println("</td>");
		out.println("<td class='gridData'>");	
		if ( eff_status_.equalsIgnoreCase("E") )    
			out.println("<img src='../../eCommon/images/enabled.gif'></img>");
		else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
		out.println("</td>");
		out.println("</tr>");
		i++;
	} 
	%>
	</table>
	<br>
	<center>
	<%
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();

}catch(Exception e){
	//out.println("Exception from CASymbolGroupQueryResult.jsp : "+e.getMessage());//common-icn-0181
	e.printStackTrace();	
}finally{
	if (conn != null) 
		ConnectionManager.returnConnection(conn,request);
}

%>
	</center>
</BODY>
</HTML>

