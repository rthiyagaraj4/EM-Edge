<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
12/04/2013    IN30708        Karthi      To incorporate the "Symbol" function  from Microsoft words to the Microsoft Editor in the clinical notes.
04/06/2013	  IN040481	  Nijitha S			CRF-CA-Bru-HIMS-CRF-221/08-Record Clinical Notes->Symbols is not displayed completely
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
18/02/2014	IN043895		Ramesh G		20/2/2014	    Chowminya		Clinical Notes is not correct for some of the Symbols which are loaded. 
04/06/2014	IN049424		Ramesh G 		04/06/2014		Akbar S			IN043895 Changes Reverted.
-----------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src="../../eCommon/js/common.js" language="javascript"></script>

<HTML>
<head>
	<script language='javascript' src='../../eCA/js/CASymbol.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<%
    request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
</head>

<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
	String from = request.getParameter("from") ;
    String to = request.getParameter("to") ;
	StringBuffer sql = new StringBuffer();
	String symbol_id  = request.getParameter("symbolid") == null? "": request.getParameter("symbolid").trim();
    String groupcode = request.getParameter("groupcode") == null? "": request.getParameter("groupcode").trim();
	String groupdesc = request.getParameter("groupdesc") == null? "": request.getParameter("groupdesc").trim();
	
	String eff_status= request.getParameter("eff_status");
	if ( (whereClause == null || whereClause.equals("")) )
    {	
		if ( !(symbol_id == null || symbol_id.equals("")) )
        {
			sql.append(" where upper(SYMBOL_ID ) like upper('"+symbol_id +"%')");
        }

        if ( !(groupcode == null || groupcode.equals("")) )
        {		if(symbol_id == null || symbol_id.equals("")){
					//sql.append(" where upper(SYMBOL_GROUP) like '"+groupcode+"%'");//IN040481
					sql.append(" where upper(SYMBOL_GROUP) like upper('"+groupcode+"%')");//IN040481
				}
				else
				{
					//sql.append(" and upper(SYMBOL_GROUP) like '"+groupcode+"%'");//IN040481
					sql.append(" and upper(SYMBOL_GROUP) like upper('"+groupcode+"%')");//IN040481
				}	
        }		
		
		if ( !(eff_status == null || eff_status.equals("")) )
		{	if((symbol_id == null || symbol_id.equals("")) && (groupcode == null || groupcode.equals("")) && (groupdesc == null || groupdesc.equals("")))
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

String strsql1="Select SYMBOL_ID, SYMBOL, SYMBOL_GROUP, SYMBOL_REMARKS, (Select distinct SYMBOL_GROUP_DESC from ca_symbol_group SG where SG.SYMBOL_GROUP = CS.SYMBOL_GROUP ) symbol_group_desc,EFF_STATUS  from CA_SYMBOL CS  " +sql.toString();

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
				out.println("<A class='gridLink' HREF='../../eCA/jsp/CASymbolQueryResult.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

			if ( !( (start+pageCnt) > maxRecord ) )
				out.println("&nbsp;<A class='gridLink' HREF='../../eCA/jsp/CASymbolQueryResult.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
			%>
			</td>
		</tr>
	</table>
	
	<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='3' > 
	<tr align="left">
		<th class='columnheadercenter'  width='15%'><fmt:message key="eCA.symbolid.label" bundle="${ca_labels}"/></th>
		<th class='columnheadercenter' width='15%'><fmt:message key="eCA.symbol.label" bundle="${ca_labels}"/></th>
		<th class='columnheadercenter' width='20%'><fmt:message key="eCA.symbolgroups.label" bundle="${ca_labels}"/></th>
		<th class='columnheadercenter' width='40%'><fmt:message key="eCA.symbolgroups.label" bundle="${ca_labels}"/> Desc</th>
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
			String symbol_id_			=	(rs.getString("SYMBOL_ID")==null)?"":rs.getString("SYMBOL_ID");
			String symbol_		 		=	(rs.getString("SYMBOL")==null)?"":rs.getString("SYMBOL");		
			String symbol_group_		=	(rs.getString("SYMBOL_GROUP")==null)?"":rs.getString("SYMBOL_GROUP");
			String symbol_group_desc_	=	(rs.getString("symbol_group_desc")==null)?"":rs.getString("symbol_group_desc");
			String remarks_	 			=	(rs.getString("SYMBOL_REMARKS")==null)?"":rs.getString("SYMBOL_REMARKS");
			String eff_status_			=	(rs.getString("EFF_STATUS")==null)?"":rs.getString("EFF_STATUS");
			
		out.println("<a class='gridLink' href='../../eCA/jsp/AddModifySymbol.jsp?mode=2&symbol_id="+ URLEncoder.encode(symbol_id_)+"&symbol="+ URLEncoder.encode(symbol_)+"&symbol_group="+ URLEncoder.encode(symbol_group_)+"&symbol_group_desc="+ URLEncoder.encode(symbol_group_desc_)+"&remarks="+ URLEncoder.encode(remarks_)+"&eff_status="+ URLEncoder.encode(eff_status_)+"'target='f_query_add_mod' >");
		out.println(symbol_id_ + "</a></td>");
		//IN043895 Start.
		//out.println("<td class='gridData'>");
			//IN049424 Start.
			//out.println("<td class='gridData'><font face='\"Charis SIL\", \"Doulos SIL\", Gentium,\"Arial Unicode MS\"'>");
			out.println("<td class='gridData'>");
			//IN049424 End.
		//IN043895 End.
		out.println(symbol_);
		//IN043895 Start.
		//out.println("</td>");
			//IN049424 Start.
			//out.println("</Font></td>");
			out.println("</td>");
			//IN049424 End.
		//IN043895 End.
		out.println("<td class='gridData'>");
		out.println(symbol_group_);
		out.println("</td>");
		out.println("<td class='gridData'>");
		out.println(symbol_group_desc_);
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
	//out.println("Exception from CASymbolQueryResult.jsp : "+e.getMessage());//COMMON-ICN-0181
	e.printStackTrace();	
}finally{
	if (conn != null) 
		ConnectionManager.returnConnection(conn,request);
}

%>
	</center>
</BODY>
</HTML>

