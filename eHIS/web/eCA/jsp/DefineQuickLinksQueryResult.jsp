<!DOCTYPE html>
<% 
/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------
07/02/2019		IN069654	sivabagyam M 	07/02/2019		Ramesh G			MO-CRF-20101.4
---------------------------------------------------------------------------------------------------------------
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
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 %>
 <!-- Added by Arvind @ 08-12-08 -->
		
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
</head>

<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
 <%
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    
	String from = request.getParameter("from") ;
    String to = request.getParameter("to") ;
    
	StringBuffer sql = new StringBuffer();
	
	String ql_type= (request.getParameter("ql_type")==null)?"":request.getParameter("ql_type");
	//String ql_type  = request.getParameter("ql_type");
	String function_name  = request.getParameter("function_name");
    String desc = request.getParameter("desc");
	String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
    int pageCnt = Integer.parseInt(MstQryPageCnt);

	if(desc == null)
		desc = "";
	else
		desc = desc.toUpperCase();
    String scope = request.getParameter("scope");
	String eff_status = request.getParameter("eff_status");

//	out.println("whereClause   :**"+whereClause+"**<br/>");

	if( (whereClause == null || whereClause.equals("")) )
    {
		sql = new StringBuffer();
		StringBuffer sqlTemp = new StringBuffer();



		if( !(ql_type == null || ql_type.equals("")) )
        {
			sqlTemp.append("and t.QUICK_LINK_TYPE like '"+ql_type +"%' ");
        }

        if( !(function_name == null || function_name.equals("")) )
        {
			sqlTemp.append("and upper(t.SYS_OPTION_DESC) like UPPER('"+function_name+"%') ");
        }
		if ( !(desc == null || desc.equals("")) )
        {
			sqlTemp.append("and UPPER(t.QUICK_LINK_DESCRIPTION) like UPPER('"+desc+"%') ");
        }
		if( !(scope == null || scope.equals("")) )
		{
			if(scope.equals("F") )
			{
				sqlTemp.append("and t.FUNCTION_SPEC_YN='Y' ");
			}
			else if(scope.equals("G") )
			{
				 sqlTemp.append("and t.GLOBAL_YN='Y' ");
			}
		}
		if( !(eff_status == null || eff_status.equals("")) )
		{
			if(eff_status.equals("E"))
			{
				sqlTemp.append("and t.EFF_STATUS='E' ");
			}
			else if( eff_status.equals("D"))
			{
				sqlTemp.append("and t.EFF_STATUS='D' ");
			}
		}
		// Modified by Sridhar Reddy on 06/04/2010 issue form site (If defined quicklink for only External application not fetching data in query mode )
		if(sqlTemp.length() > 0){
			sql.append(" WHERE ");
			//out.println(sqlTemp.indexOf("and"));
			if(sqlTemp.indexOf("and") == 0)
				sqlTemp.delete(0,3);

			sql.append(sqlTemp);
		}
		// End
		//appending order by clause
		String ord[] = request.getParameterValues("orderbycolumns");

		if ( !(ord == null || ord .equals("")) )
		{
			sql.append(" order by ");
			for ( int i=0;i < ord.length;i++ )
			{
				if ( i == ord.length - 1 )
				{
					if(ord[i].equals("t.SYS_OPTION_DESC"))
						sql.append(ord[i]);
					else
						sql.append("t."+ord[i]);
				}
				else
				{
					if(ord[i].equals("t.SYS_OPTION_DESC"))
						sql.append(ord[i]+",");
					else
						sql.append("t."+ord[i]+",");
				}
			}
		}
    } //end of where clause IF
    else
	{
		sql = new StringBuffer();
		// Modified by Sridhar Reddy on 06/04/2010 issue form site (If defined quicklink for only External application not fetching data in query mode )
		if (whereClause != null && !whereClause.equals("")) 
			sql.append(whereClause);

		//End
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

	PreparedStatement stmt;
	int maxRecord = 0;
	ResultSet rs = null;

	//String strsql1="select a.QUICK_LINK_TYPE, a.OPTION_ID, B.SYS_OPTION_DESC, a.QUICK_LINK_DESCRIPTION, a.FUNCTION_SPEC_YN, a.GLOBAL_YN, a.EFF_STATUS from SM_QUICK_LINK_LIST a, SM_QUICK_LINK_OPTION B WHERE B.OPTION_ID(+)=a.OPTION_ID  "+sql.toString();
	//String strsql1="select  distinct t.QUICK_LINK_REF, t.QUICK_LINK_TYPE,t.OPTION_ID,t.SYS_OPTION_DESC,t.QUICK_LINK_DESCRIPTION,t.FUNCTION_SPEC_YN,t.GLOBAL_YN, t.EFF_STATUS from SM_QUICK_LINK_LIST_VW t,SM_QUICK_LINK_LIST a, SM_QUICK_LINK_OPTION B WHERE B.OPTION_ID =a.OPTION_ID "+sql.toString();

	// Modified by Sridhar Reddy on 06/04/2010 issue form site (If defined quicklink for only External application not fetching data in query mode )
	String strsql1="select  distinct t.QUICK_LINK_REF, t.QUICK_LINK_TYPE,t.OPTION_ID,t.SYS_OPTION_DESC,t.QUICK_LINK_DESCRIPTION,t.FUNCTION_SPEC_YN,t.GLOBAL_YN, t.EFF_STATUS from SM_QUICK_LINK_LIST_VW t "+sql.toString();

	// End

	//out.println(strsql1);
	try
	{
		stmt = conn.prepareStatement(strsql1);
		rs = stmt.executeQuery();
		while(rs.next())
		{
			maxRecord++;
		}
		if(maxRecord == 0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
		}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();

		stmt=conn.prepareStatement(strsql1);
		rs = stmt.executeQuery();
%>

<table cellpadding='0' cellspacing='0' border='0' width='100%' align='center'>
	<tr>
		<td class='white' width='88%'></td> 
		<td nowrap  width='12%' align='right'>
<%
		if ( !(start <= 1) )
			out.println("<A class='gridLink' HREF='../../eCA/jsp/DefineQuickLinksQueryResult.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

		if ( !( (start+pageCnt) > maxRecord ) )
			out.println("&nbsp;<A class='gridLink' HREF='../../eCA/jsp/DefineQuickLinksQueryResult.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
		</td>
	</tr>
</table>
<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='3'>
	<tr>
	<td class='COLUMNHEADERCENTER' width='20%'><fmt:message key="eCA.QuickLinkType.label" bundle="${ca_labels}"/></td>
	<td class='COLUMNHEADERCENTER' width='30%'><fmt:message key="Common.Function.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADERCENTER' width='25%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADERCENTER' width='20%'><fmt:message key="Common.Scope.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADERCENTER' width='20%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td></tr>

<%
		if ( start != 1 )
			for( int j=1; j<start; i++,j++ )
		  rs.next() ;
		String classValue= " ";
		while ( rs.next() && i<=end  )
		{
			if ( i % 2 == 0 )
				classValue = "gridData" ;
			else
				classValue = "gridData" ;
			
			if(i==end)
				out.println("<tr style='border-bottom: 2px solid grey;'><td align=='left' class='" + classValue + "'>");
			else 
				out.println("<tr ><td align=='left' class='" + classValue + "'>");
			String ql_ref1			= rs.getString("QUICK_LINK_REF") == null ? "" : rs.getString("QUICK_LINK_REF");
			String ql_type1			= rs.getString("QUICK_LINK_TYPE") == null ? "" : rs.getString("QUICK_LINK_TYPE");
			//String function_id		= rs.getString("OPTION_ID") == null ? "" : rs.getString("OPTION_ID");
			String function_name1	= rs.getString("SYS_OPTION_DESC") == null ? "&nbsp;" : rs.getString("SYS_OPTION_DESC");
			String desc1			= rs.getString("QUICK_LINK_DESCRIPTION") == null ? "" : rs.getString("QUICK_LINK_DESCRIPTION");
			String function_spec_yn	= rs.getString("FUNCTION_SPEC_YN") == null ? "N" : rs.getString("FUNCTION_SPEC_YN");
			String global_yn		= rs.getString("GLOBAL_YN") == null ? "N" : rs.getString("GLOBAL_YN");
			String eff_status1		= rs.getString("EFF_STATUS") == null ? "" : rs.getString("EFF_STATUS");

			if(ql_type1.equals("QF")) ql_type1="Query Filter";
			else if(ql_type1.equals("AF")) ql_type1="Actual Function";
			else if(ql_type1.equals("EX")) ql_type1="External Application";
			else if(ql_type1.equals("AM")) ql_type1="Adaptive Menu";
			else  ql_type1 ="";
			
			String scope1 = "";
			if(function_spec_yn.equals("Y") && global_yn.equals("Y")){
				//scope1 = "Both";
				scope1 = "Global,Function Specific";
			}
			else if(function_spec_yn.equals("Y"))
				scope1 = "Function Specific";
			else if(global_yn.equals("Y"))
				scope1 = "Global";
			else
				scope1 = "&nbsp;";

			out.println(ql_type1);
			out.println("</td><td class='" + classValue + "'>");

			/*if(ql_type.equals("AM")){
			out.println("<a class='gridLink' href='../../eCA/jsp/DefineQuickLinksAddModify.jsp?mode=update&description="+ URLEncoder.encode(desc1)+"' target='f_query_add_mod' >");
			out.println(desc1);
			out.println("</td><td class='" + classValue + "'>");
			out.println("<a class='gridLink' href='../../eCA/jsp/DefineQuickLinksAddModify.jsp?mode=update&description="+ URLEncoder.encode(desc1)+"' target='f_query_add_mod' >");
			out.println("");

			}

			else{*/		
				
			if(ql_type1.equals("Adaptive Menu")){
				out.println("</td><td class='" + classValue + "'>");
				out.println(desc1);
				
			}
			else{
			out.println(function_name1);
			out.println("</td><td class='" + classValue + "'>");
			out.println("<a class='gridLink' href='../../eCA/jsp/DefineQuickLinksAddModify.jsp?ql_ref1="+ql_ref1+"&mode=update&description="+ URLEncoder.encode(desc1,"UTF-8")+"' target='f_query_add_mod' >");
			out.println(desc1);
			}
			out.println("</a></td><td class='" + classValue + "'>");
			out.println(scope1);
			out.println("</td><td class='" + classValue + "' >");
			if ( eff_status1.equalsIgnoreCase("E") )
				out.println("<img src='../../eCommon/images/enabled.gif'></img>");
			else
				out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
			out.println("</td>");
			out.println("</tr>");
			i++;
		} 
%>
</table>
</center>
<%
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
	}
	catch(Exception e)
	{
		//out.println("Exception @ 3333"+e.toString());//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		if (conn != null) 
			ConnectionManager.returnConnection(conn,request);
	}	

%>
</BODY>
</HTML> 

