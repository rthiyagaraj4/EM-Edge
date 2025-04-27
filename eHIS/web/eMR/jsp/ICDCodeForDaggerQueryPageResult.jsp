<!DOCTYPE html>
<%
/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/// MODULE			:	Medical Records..(MR)
/// Function Name	:	Asterisk Codes for Dagger Codes 
/// Developer		:	SRIDHAR R
/// Created On		:	2 DEC 2004
/// Function 		:   Used to Display the records based on criteria... 
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>


	<script src='../../eMR/js/ICDCodeForDagger.js' language='javascript'></script>

</head>
<body onmousedown='CodeArrest()' onkeydown = 'lockKey()'  class='content'>
<%
	request.setCharacterEncoding("UTF-8"); 
	String whereClause = request.getParameter("whereclause");
	StringBuffer sql=new StringBuffer() ;
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;

	if((whereClause == null || whereClause.equals("")))
	{
		//sql.append("");
		String dag_diag_code	= request.getParameter("dagger_code");
			if(dag_diag_code == null) dag_diag_code = "";
		String dag_short_desc	= request.getParameter("dagger_desc");
			if(dag_short_desc == null) dag_short_desc = "";
		String astk_diag_code	= request.getParameter("astk_code");
			if(astk_diag_code == null) astk_diag_code = "";
		String astk_short_desc	= request.getParameter("astk_desc");
			if(astk_short_desc == null) astk_short_desc = "";

		dag_diag_code	=	dag_diag_code.toUpperCase();
		dag_short_desc	=	dag_short_desc.toUpperCase();
		astk_diag_code	=	astk_diag_code.toUpperCase();
		astk_short_desc	=	astk_short_desc.toUpperCase();

		if ( !(dag_diag_code == null || dag_diag_code.equals("")) )
		{
			if(sql.length() <= 0)
				sql.append( " where ");
			else
				sql.append( " and ");

			sql.append(" upper(DAG_DIAG_CODE) like upper('"+dag_diag_code+"%')");
		}

		if(!(dag_short_desc == null || dag_short_desc.equals("")))
		{
			if(sql.length() <= 0)
				sql.append( " where ");
			else
				sql.append( " and ");

			sql.append(" upper(DAG_SHORT_DESC) like upper('"+dag_short_desc+"%')");
		}
		if(!(astk_diag_code == null || astk_diag_code.equals("")))
		{
			if(sql.length() <= 0)
				sql.append( " where ");
			else
				sql.append(" and ");

			sql.append( " upper(ASTK_DIAG_CODE) like upper('"+astk_diag_code+"%')");
		}
		if(!(astk_short_desc == null || astk_short_desc.equals("")))
		{
			if(sql.length() <= 0)
				sql.append(" where ");
			else
				sql.append( " and ");

			sql.append( " upper(ASTK_SHORT_DESC) like upper('"+astk_short_desc+"%')");
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
	}
	else 
	{
		sql.append(whereClause);
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
		Statement stmt=null;
		ResultSet rs=null;
		int maxRecord = 0;
	try
	{
		conn=ConnectionManager.getConnection(request);
		/*String CountSql=" SELECT COUNT(*)TOTAL FROM MR_ICD_CODE_DTL_VW " + sql.toString();
		stmt = conn.createStatement();

		//out.println("CountSql---"+CountSql);

		rs = stmt.executeQuery(CountSql);
		rs.next();
		maxRecord = rs.getInt("total");
		if(maxRecord == 0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
		}*/
		String FinalSql=" select DAG_DIAG_CODE, DAG_SHORT_DESC, ASTK_DIAG_CODE, ASTK_SHORT_DESC from MR_ICD_CODE_DTL_VW " + sql.toString();
		//if(rs!=null)	rs.close();
		//if(stmt!=null)	stmt.close();
		stmt = conn.createStatement();

		//out.println("FinalSql---"+FinalSql);

		rs = stmt.executeQuery(FinalSql);

		if ( start != 1 )
		for( int j=1; j<start; i++,j++ )
		{
			rs.next() ;
		}

		while (i<=end && rs.next())
		{
			if (maxRecord==0)
			{
		%>
				<P>
				<table align='right'>
				<tr>
					
						<%
						if ( !(start <= 1) )
							out.println("<td align ='right' id='prev'><A HREF='../../eMR/jsp/ICDCodeForDaggerQueryPageResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
						//if ( !( (start+14) > maxRecord ) )
							out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eMR/jsp/ICDCodeForDaggerQueryPageResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
						%>
					
				</tr>
				</table>
				<br><br>
				</P>
				<table border="1" width="100%" cellspacing='0' cellpadding='0'>
				<th nowrap><fmt:message key="eMR.DaggerCode.label" bundle="${mr_labels}"/></th>
				<th nowrap><fmt:message key="eMR.DaggerDescription.label" bundle="${mr_labels}"/></th>
				<th nowrap><fmt:message key="eMR.AsteriskCode.label" bundle="${mr_labels}"/></th>
				<th nowrap><fmt:message key="eMR.AsteriskDescription.label" bundle="${mr_labels}"/></th>
				<%
					
			}
				/*if ( start != 1 )
		for( int j=1; j<start; i++,j++ )
		{
			rs.next() ;
		}*/
				String classValue="";
		//while ( rs.next() && i<=end )
		//{
				if ( i % 2 == 0 )
					classValue = "QRYEVEN" ;
				else
					classValue = "QRYODD" ;
				String dag_diag_code =rs.getString("DAG_DIAG_CODE");
				if((dag_diag_code == null)||(dag_diag_code.equals("null"))) dag_diag_code = "&nbsp;";
				String dag_short_desc =rs.getString("DAG_SHORT_DESC");
				if((dag_short_desc == null)||(dag_short_desc.equals("null"))) dag_short_desc = "&nbsp;";
				String astk_diag_code =rs.getString("ASTK_DIAG_CODE");
				if((astk_diag_code == null)||(astk_diag_code.equals("null"))) astk_diag_code = "&nbsp;";
				String astk_short_desc =rs.getString("ASTK_SHORT_DESC");
				if((astk_short_desc == null)||(astk_short_desc.equals("null"))) astk_short_desc = "&nbsp;";
				out.println("<tr>");
				out.println("<td class='"+classValue+"'> "+dag_diag_code+"  </td>");
				out.println("<td class='"+classValue+"'> "+dag_short_desc+" </td>");
				out.println("<td class='"+classValue+"'> "+astk_diag_code+" </td>");
				out.println("<td class='"+classValue+"'> "+astk_short_desc+"</td>");
				out.println("</tr>");
				i++;
				maxRecord++;
		}
		

				if(maxRecord == 0)
				{
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
				}
				if ( maxRecord < 14 || (!rs.next()) )
				{
					%>
					<script >
						if (document.getElementById("next"))
							document.getElementById("next").style.visibility='hidden';
					</script>
					<% 
				}
				else
				{%>
					<script >
						if (document.getElementById("next"))
							document.getElementById("next").style.visibility='visible';
					</script>
				<%
				}
				sql.setLength(0);
	}
	catch(Exception e)
	{ 
		//out.println("Error in result page : "+e.toString());
		e.printStackTrace();
	}
	finally   
	{
		try
		{
			if(rs!=null)	rs.close();
			if(stmt!=null)	stmt.close();
		}
		catch(Exception e)
		{
			//out.println("Exception @ try "+e.toString());
			e.printStackTrace();
		}

		ConnectionManager.returnConnection(conn,request);
	}
%>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

