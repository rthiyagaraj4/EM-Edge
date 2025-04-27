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
		String Report	= request.getParameter("Report");
			if(Report == null) Report = "";
		String Master	= request.getParameter("Master");
			if(Master == null) Master = "";
		String main_group	= request.getParameter("main_group");
			if(main_group == null) main_group = "";
		String sub_group	= request.getParameter("sub_group");
			if(sub_group == null) sub_group = "";
		String catalog_desc	= request.getParameter("catalog_desc");
			if(catalog_desc == null) catalog_desc = "";
		
		//group_code	=	group_code.toUpperCase();
		//group_name	=	group_name.toUpperCase();
		//report_id	=	report_id.toUpperCase();
		//mast_table_name_reference	=	mast_table_name_reference.toUpperCase();
		if ( !(Report == null || Report.equals("")) )
		{
			sql = " where upper(REPORT_ID) like upper('"+Report+"%')";
		}
		if(!(Master == null || Master.equals("")))
		{
			if(sql.equals(""))
				sql = sql + " where ";
			else
				sql = sql + " and ";

			sql = sql + " upper(MAST_TABLE_NAME_REFERENCE) like upper('"+Master+"%')";
		}
		if(!(main_group == null || main_group.equals("")))
		{
			if(sql.equals(""))
				sql = sql + " where ";
			else
				sql = sql + " and ";

			sql = sql + " upper(GROUP_DESC) like upper('"+main_group+"%')";
		}

		if(!(sub_group == null || sub_group.equals("")))
		{
			if(sql.equals(""))
				sql = sql + " where ";
			else
				sql = sql + " and ";

			sql = sql + " upper(SUB_GROUP_DESC) like upper('"+sub_group+"%')";
		}

		if(!(catalog_desc == null || catalog_desc.equals("")))
		{
			if(sql.equals(""))
				sql = sql + " where ";
			else
				sql = sql + " and ";

			sql = sql + " upper(MAST_DESC) like upper('"+catalog_desc+"%')";
		}

		
		String ord[] = request.getParameterValues("orderbycolumns");
		
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
		String FinalSql=" select REPORT_DESC, MAST_TABLE_NAME_REFERENCE,GROUP_DESC,SUB_GROUP_DESC, MAST_DESC,ORDER_BY_SRL_NO from MR_REPORT_MAPPING_VW " + sql ;
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
					out.println("<A HREF='../../eMR/jsp/SSOrderCatalogLinkQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
				if ( !( (start+14) > maxRecord ) )
					out.println("<A HREF='../../eMR/jsp/SSOrderCatalogLinkQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
				%>
			</td>
		</tr>
		</table>
		<br><br>
		</P>
		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<th nowrap><fmt:message key="Common.report.label" bundle="${common_labels}"/></th>
		<th nowrap><fmt:message key="eMR.Master.label" bundle="${mr_labels}"/></th>
		<th nowrap><fmt:message key="eMR.MainGroup.label" bundle="${mr_labels}"/></th>
		<th nowrap><fmt:message key="eMR.SubGroup.label" bundle="${mr_labels}"/></th>
		<th nowrap><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
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
			String REPORT_DESC =checkForNull(rs.getString("REPORT_DESC"));
			String MAST_TABLE_NAME_REFERENCE =checkForNull(rs.getString("MAST_TABLE_NAME_REFERENCE"));
			String GROUP_DESC =checkForNull(rs.getString("GROUP_DESC"));
			String SUB_GROUP_DESC =checkForNull(rs.getString("SUB_GROUP_DESC"));
			//if(SUB_GROUP_DESC.equals("null") || SUB_GROUP_DESC==null)
             //SUB_GROUP_DESC="";
			String MAST_DESC =checkForNull(rs.getString("MAST_DESC"));
			int ORDER_BY_SRL_NO =rs.getInt("ORDER_BY_SRL_NO");
			
			
			if(MAST_TABLE_NAME_REFERENCE.equals("OC"))
			MAST_TABLE_NAME_REFERENCE="Order Catalog";

			out.println("<tr>");
			
			out.println("<td class='"+classValue+"'> "+REPORT_DESC+" </td>");
			out.println("<td class='"+classValue+"'> "+MAST_TABLE_NAME_REFERENCE+" </td>");
			out.println("<td class='"+classValue+"'> "+GROUP_DESC+" </td>");
			out.println("<td class='"+classValue+"'> "+SUB_GROUP_DESC+" </td>");
			out.println("<td class='"+classValue+"'> "+MAST_DESC+"</td>");
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
public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
}
%>

