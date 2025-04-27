<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %> 
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	
	
</head>
<body onmousedown='CodeArrest()' onkeydown = 'lockKey()'  class='content'>
<%
	request.setCharacterEncoding("UTF-8");
	String whereClause = request.getParameter("whereclause");
	String sql="" ;
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	if((whereClause == null || whereClause.equals("")))
	{
		
		sql="";
		String Report_id	= request.getParameter("Report_id1");
			if(Report_id == null) Report_id = "";
		String type	= request.getParameter("type1");
			if(type == null) type = "";
		String description	= request.getParameter("description1");
			if(description == null) description = "";
		String group	= request.getParameter("group1");
			if(group == null) group = "";
			String code	= request.getParameter("code1");
			if(code == null) code = "";
       
		
		if ( !(Report_id == null || Report_id.equals("")) )
		{
			sql = " where upper(REPORT_ID) like upper('"+Report_id+"%')";
		}
		else
		{
			sql = " where upper(REPORT_ID) IN('MROPRFLS','MROPCSAT','MRIPCSBD','MRIPCSMH','MRIPCSEG','MROPANPO','MROPCSEG')";
		}

		if(!(type == null || type.equals("")))
		{
			if(sql.equals(""))
				sql = sql + " where ";
			else
				sql = sql + " and ";

			sql = sql + " upper(MAST_TABLE_NAME_REFERENCE) like upper('"+type+"%')";
		}
		if(!(description == null || description.equals("")))
		{
			if(sql.equals(""))
				sql = sql + " where ";
			else
				sql = sql + " and ";

			sql = sql + " upper(MAST_DESC) like upper('"+description+"%')";
		}
		if(!(code == null || code.equals("")))
		{
			if(sql.equals(""))
				sql = sql + " where ";
			else
				sql = sql + " and ";

			sql = sql + " upper(MAST_CODE) like upper('"+code+"%')";
		}

		if(!(group == null || group.equals("")))
		{
			if(sql.equals(""))
				sql = sql + " where ";
			else
				sql = sql + " and ";

			sql = sql + " upper(GROUP_DESC) like upper('"+group+"%')";
		}

				
		String ord[]=new String[3];
		String concatvalues= request.getParameter("concatvalues");
		 java.util.StringTokenizer st = new StringTokenizer(concatvalues,"|");
		 int i2=0;
        while (st.hasMoreTokens())
		{
               ord[i2]=st.nextToken();i2++;
         }

		//String ord[] = request.getParameterValues("orderbycolumns");
		if ( !(ord == null || ord .equals("")) )
		{
			sql=sql+" order by ";

			for ( int i=0;i < ord.length;i++ )
			{
			if ( i == ord.length - 1 )
				sql=sql+ord[i];
			else
				sql=sql+ord[i]+",";

			//out.println("sql--------"+sql);
			}
		}
	}
	else 
	{
		sql = whereClause;
	}
	int start = 0;
	int end = 0;
	int i=1;
	if (from == null)
		start = 1;
	else
		start = Integer.parseInt(from);
	if (to == null)
	  	end = 14;
	else
		end = Integer.parseInt(to);
		Connection conn =null;
		java.sql.Statement stmt=null;
		ResultSet rs=null;
		int maxRecord = 0;
	try
	{
		conn=ConnectionManager.getConnection(request);
		String CountSql=" SELECT COUNT(*) TOTAL FROM MR_REPORT_MAPPING_VW " + sql ;
		stmt = conn.createStatement();
		rs = stmt.executeQuery(CountSql);
		rs.next();
		maxRecord = rs.getInt("total");
		if(maxRecord == 0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
		}
		String FinalSql=" select MAST_CODE,REPORT_DESC, MAST_TABLE_NAME_REFERENCE,GROUP_DESC, MAST_DESC,ORDER_BY_SRL_NO from MR_REPORT_MAPPING_VW " + sql ;
		if(rs!=null)	rs.close();
		if(stmt!=null)	stmt.close();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(FinalSql);
		%>
		<P>
		<table align='right'>
		<tr>
			<td>
				<%
				if ( !(start <= 1) )
					out.println("<A HREF='../../eMR/jsp/ReportGroupQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
				if ( !( (start+14) > maxRecord ) )
					out.println("<A HREF='../../eMR/jsp/ReportGroupQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
				%>
			</td>
		</tr>
		</table>
		<br><br>
		</P>
		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		
		<th nowrap><fmt:message key="Common.report.label" bundle="${common_labels}"/></th>
		<th nowrap><fmt:message key="eMR.Master.label" bundle="${mr_labels}"/></th>
		<th nowrap><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th nowrap><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
		<th nowrap><fmt:message key="Common.Group.label" bundle="${common_labels}"/></th>
		<th nowrap><fmt:message key="Common.SerialNo.label" bundle="${common_labels}"/></th>
		<%
		if ( start != 1 )
		for( int j=1; j<start; i++,j++ )
		{
			rs.next() ;
		}
		String classValue="";
		while ( rs.next() && i<=end )
		{
			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;
			String REPORT_DESC =rs.getString("REPORT_DESC");
			String MAST_CODE =rs.getString("MAST_CODE");
			String mast_table_name_reference =rs.getString("MAST_TABLE_NAME_REFERENCE");
			String GROUP_DESC =rs.getString("GROUP_DESC");
			String MAST_DESC =rs.getString("MAST_DESC");
			int ORDER_BY_SRL_NO =rs.getInt("ORDER_BY_SRL_NO");
			
			
			if(mast_table_name_reference.equals("OC"))
			mast_table_name_reference="Order Catalog";
			if(mast_table_name_reference.equals("RC"))
			mast_table_name_reference="Race Group";
			if(mast_table_name_reference.equals("DT"))
			mast_table_name_reference="Delivery Type";
			if(mast_table_name_reference.equals("SP"))
			mast_table_name_reference="Specialty";

			out.println("<tr>");
			
			out.println("<td class='"+classValue+"'> "+REPORT_DESC+" </td>");
			out.println("<td class='"+classValue+"'> "+mast_table_name_reference+" </td>");
			out.println("<td class='"+classValue+"'> "+MAST_CODE+" </td>");
			out.println("<td class='"+classValue+"'> "+MAST_DESC+" </td>");
			out.println("<td class='"+classValue+"'> "+GROUP_DESC+"</td>");
			out.println("<td class='"+classValue+"'> "+ORDER_BY_SRL_NO+"</td>");
			out.println("</tr>");
			i++;
		}
	}
	catch(Exception e)
	{ 
		//out.println("Error in result page : "+e.toString());
		e.printStackTrace();
	}
	finally   
	{
		if(rs!=null)	rs.close();
		if(stmt!=null)	stmt.close();
		ConnectionManager.returnConnection(conn,request);
	}
%>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

