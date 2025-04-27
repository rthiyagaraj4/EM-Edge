<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
18/07/2013     		1   		Sethuraman      Created for Displaying encounter Summary Groups/Sub-Groups serach results 
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
	
	String sGroupSubGrp = "";
	int iGroupFlag = 0;

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
	String es_group_type = request.getParameter("es_group_type");
	String es_group_code = request.getParameter("es_group_code");
    String es_group_desc = request.getParameter("es_group_desc");
    
    if(es_group_type == null)
    	es_group_type = "";
	else
		es_group_type = es_group_type.toUpperCase();
    
    if(es_group_code == null)
	   	es_group_code = "";
	else
		es_group_code = es_group_code.toUpperCase();
	
    
    if(es_group_desc == null)
		es_group_desc = "";
	else
		es_group_desc = es_group_desc.toUpperCase();   	
	
    String es_group_status= request.getParameter("es_group_status");
	 
	if ( (whereClause == null || whereClause.equals("")) )
    {		
		if ( !(es_group_type == null || es_group_type.equals("")) )
        {
			sql.append(" upper(a.es_group_type ) like upper('"+es_group_type +"%') and ");
        }
		
		if ( !(es_group_code == null || es_group_code.equals("")) )
        {
			sql.append(" upper(a.es_group_code ) like upper('"+es_group_code +"%') and ");
        }

        if ( !(es_group_desc == null || es_group_desc.equals("")) )
        {
			sql.append(" upper(a.es_group_desc) like upper('"+es_group_desc +"%') and ");
        }		
		

		if ( !(es_group_status == null || es_group_status.equals("")) )
	    {
	         if( es_group_status.equals("E") )
	         {
				   sql.append(" es_group_status='E'");
	         }
	         if ( es_group_status.equals("D") )
		     {
	
				   sql.append(" es_group_status='D'");
	         }	        
	    }		
		
		if (sql.indexOf("and", sql.length()-4) > 0)
		{			
			sql.delete(sql.length()-4, sql.length());			
		}
		
		System.out.println(" - - - sql - - - "+sql.toString());
		
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
	
	//String strsql1="select a.note_group,a.note_GROUP_desc, b.APPL_TASK_desc APPL_TASK_ID, a.NO_OF_REC_PER_ENC,a.ROLE_BASED_ACCESS_YN,a.PRE_COND_FOR_REC,a.EFF_STATUS from  ca_note_group a,ca_appl_task b where a.APPL_TASK_ID = b.APPL_TASK_ID "+sql.toString();
	String strsql1="select a.es_group_flag, a.es_group_type, a.es_group_code, a.es_group_desc, a.es_group_remarks, a.es_group_image_url, a.es_group_status from  cr_es_group_header a "+sql.toString();
	try
	{
		conn  =  ConnectionManager.getConnection(request);
	
		stmt1=conn.prepareStatement(strsql1,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		System.out.println(" - - - ENcSummGroupQueryResult - - - "+strsql1);
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
		    out.println("<A class='gridLink' HREF='../../eCA/jsp/EncSummGroupQueryResult.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
		
		if ( !( (start+pageCnt) > maxRecord ) )
		    out.println("&nbsp;<A class='gridLink' HREF='../../eCA/jsp/EncSummGroupQueryResult.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>

<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='3'>
<td class='columnheadercenter' width='10%'><fmt:message key="Common.GroupType.label" bundle="${common_labels}"/></td>
<td class='columnheadercenter' width='10%'><fmt:message key="Common.GroupSubFlag.label" bundle="${common_labels}"/></td>
<td class='columnheadercenter' width='15%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
<td class='columnheadercenter' width='20%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
<td class='columnheadercenter' width='20%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
<td class='columnheadercenter' width='15%'><fmt:message key="Common.ImageURL.label" bundle="${common_labels}"/></td>
<td class='columnheadercenter' width='10%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>



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
	
		    String group_flag1 = (rset.getString("ES_GROUP_FLAG")==null)?"":rset.getString("ES_GROUP_FLAG");
		    String group_type1 = (rset.getString("ES_GROUP_TYPE")==null)?"":rset.getString("ES_GROUP_TYPE");
			String group_code1 = (rset.getString("ES_GROUP_CODE")==null)?"":rset.getString("ES_GROUP_CODE");
			String group_desc1 = (rset.getString("ES_GROUP_DESC")==null)?"":rset.getString("ES_GROUP_DESC");
			String group_remarks1 = (rset.getString("ES_GROUP_REMARKS")==null)?"&nbsp;":rset.getString("ES_GROUP_REMARKS");
			String group_image_url1 = (rset.getString("ES_GROUP_IMAGE_URL")==null)?"":rset.getString("ES_GROUP_IMAGE_URL");
			String group_status1 = (rset.getString("ES_GROUP_STATUS")==null)?"":rset.getString("ES_GROUP_STATUS");
			
			out.println("<tr><td class='gridData'>"+group_type1 + "</td>"); 
			
			iGroupFlag = 0;
			
			iGroupFlag = Integer.parseInt(group_flag1);
			
			if (iGroupFlag == 0)
				sGroupSubGrp = "Group";
			else
				sGroupSubGrp = "Sub-Group";
			
			out.println("<td class='gridData'>"+sGroupSubGrp+" </td>");
			out.println("<td class='gridData'>");
			out.println("<a class='gridLink' href='../../eCA/jsp/EncSummGroupAddModify.jsp?mode=update&es_group_flag="+ URLEncoder.encode(group_flag1)+"&es_group_type="+ URLEncoder.encode(group_type1)+"&es_group_code="+ URLEncoder.encode(group_code1)+"' target='f_query_add_mod' >");
		    out.println(group_code1+"</a></td>");
		    out.println("<td class='gridData'>"+group_desc1+" </td>");
		    out.println("<td class='gridData'>"+group_remarks1+" </td>");
		    out.println("<td class='gridData'>"+group_image_url1+" </td>");	
			
			if ( group_status1.equalsIgnoreCase("E") )
		 		out.println("<td class='gridData'><img src='../../eCommon/images/enabled.gif'></img></td>");
		 	else
		 		out.println("<td class='gridData'><img src='../../eCommon/images/disabled.gif'></img></td>");
		  
			i++;
		} 
%>

</td></tr>
</table>
</center>

<br><center>
<%

		if(rset!=null) rset.close();
		if(stmt1!=null) stmt1.close();
	}
	catch(Exception e)
	{
		//out.println("Exception from EncGroupQueryResult JSP : "+e.getMessage());//COMMON-ICN-0181
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

