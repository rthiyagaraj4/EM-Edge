<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
13/09/2013     		1   		Sethuraman      Created for Displaying encounter Summary search results 
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src="../../eCommon/js/common.js" language="javascript"></script>

<HTML>
<head>
 <%
    request.setCharacterEncoding("UTF-8");
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


%>
<!-- <modifeid by Arvind @06-12-2008> -->

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	</head>

<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
 <%
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
	String from = request.getParameter("from") ;
    String to = request.getParameter("to") ;
	StringBuffer sql = new StringBuffer();
	String es_summ_code = request.getParameter("es_summ_code");   
	String es_summ_desc = request.getParameter("es_summ_desc");   
    
    if(es_summ_code == null)
    	es_summ_code = "";
	else
		es_summ_code = es_summ_code.toUpperCase();	
    
    if(es_summ_desc == null)
    	es_summ_desc = "";
	else
		es_summ_desc = es_summ_desc.toUpperCase();   	
	
    String es_summ_status= request.getParameter("es_summ_status");
	 
	if ( (whereClause == null || whereClause.equals("")) )
    {	
		if ( !(es_summ_code == null || es_summ_code.equals("")) )
        {
			sql.append(" upper(a.es_summ_code ) like upper('"+es_summ_code +"%') and ");
        }

        if ( !(es_summ_desc == null || es_summ_desc.equals("")) )
        {
			sql.append(" upper(a.es_summ_desc) like upper('"+es_summ_desc +"%') and ");
        }		
		

		if ( !(es_summ_status == null || es_summ_status.equals("")) )
	    {
	         if( es_summ_status.equals("E") )
	         {
				   sql.append(" a.es_summ_status ='E'");
	         }
	         if ( es_summ_status.equals("D") )
		     {
	
				   sql.append(" a.es_summ_status ='D'");
	         }	        
	    }		
		
		if (sql.indexOf("and", sql.length()-4) > 0)
		{			
			sql.delete(sql.length()-4, sql.length());			
		}
		
		if (sql.length() > 0)
			sql.insert(1, " where ");			
		
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

    if ( to == null ){
		String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
		end =  Integer.parseInt(MstQryPageCnt);
	}
    else
        end = Integer.parseInt( to ) ;

	Connection conn  = null;
	
	PreparedStatement stmt1;
	int maxRecord = 0;
	ResultSet rset = null;
	
	String strsql1="select a.es_summ_code, a.es_summ_desc, a.es_summ_title, a.es_summ_status, a.es_summ_type from cr_es_summ_hdr a "+sql.toString();
	try
	{
		conn  =  ConnectionManager.getConnection(request);
	
		stmt1=conn.prepareStatement(strsql1,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

		rset = stmt1.executeQuery();		
		while(rset.next())
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
 <td class='white' width='100%'></td> <!-- <88 to 100Updated by Arvind @19-12-08> -->
<td  width='25%' nowrap>
<%
		String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
	    int pageCnt = Integer.parseInt(MstQryPageCnt);
		if ( !(start <= 1) )
		    out.println("<A class='gridLink' HREF='../../eCA/jsp/EncSummGroupSummQueryResult.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
		
		if ( !( (start+pageCnt) > maxRecord ) )
		    out.println("&nbsp;<A class='gridLink' HREF='../../eCA/jsp/EncSummGroupSummQueryResult.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>

<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='3'>
<tr>
<td class='columnheadercenter' width='15%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
<td class='columnheadercenter' width='20%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
<td class='columnheadercenter' width='25%'><fmt:message key="eCA.Title.label" bundle="${ca_labels}"/></td>
<td class='columnheadercenter' width='10%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
</tr>

<%
		rset.beforeFirst();
	
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
	
		    String summ_code1 = (rset.getString("ES_SUMM_CODE")==null)?"":rset.getString("ES_SUMM_CODE");
		    String summ_desc1 = (rset.getString("ES_SUMM_DESC")==null)?"":rset.getString("ES_SUMM_DESC");
			String summ_title1 = (rset.getString("ES_SUMM_TITLE")==null)?"":rset.getString("ES_SUMM_TITLE");
			String summ_status1 = (rset.getString("ES_SUMM_STATUS")==null)?"":rset.getString("ES_SUMM_STATUS");		
			String summ_type1 = (rset.getString("ES_SUMM_TYPE")==null)?"":rset.getString("ES_SUMM_TYPE");		
			 
			out.println("<tr><td class='gridData'>");
			out.println("<a class='gridLink' href='../../eCA/jsp/EncSummGroupSummAddModify.jsp?mode=update&es_summ_code="+ URLEncoder.encode(summ_code1)+"' target='f_query_add_mod' >");
		    out.println(summ_code1+"</a></td>");
		    out.println("<td class='gridData'>"+summ_desc1+" </td>");
		    out.println("<td class='gridData'>"+summ_title1+" </td>");	    	
			
			if ( summ_status1.equalsIgnoreCase("E") )
		 		out.println("<td class='gridData'><img src='../../eCommon/images/enabled.gif'></img></td>");
		 	else
		 		out.println("<td class='gridData'><img src='../../eCommon/images/enabled.gif'></img></td>");
			
			out.println("</tr>");
		  
			i++;
		} 
%>


</table>
</center>

<br><center>
<%

		if(rset!=null) rset.close();
		if(stmt1!=null) stmt1.close();
	}
	catch(Exception e)
	{
		//out.println("Exception from EncGroupSummQueryResult JSP : "+e.getMessage());//common-icn-0181
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

