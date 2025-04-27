<!DOCTYPE html>
<!-- by Meghanath -->

<%@ page import="java.sql.*,java.text.*,java.net.*,java.util.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
<HEAD>
<!-- <LINK rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></LINK> -->
<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<SCRIPT language='javascript' src='../../eCommon/js/ValidateControl.js'></SCRIPT>
<SCRIPT language='javascript' src='../../eCommon/js/common.js'></SCRIPT>

<SCRIPT language='javascript' src='../../eFM/js/FMDocumentFolder.js'></SCRIPT>
</HEAD>
<BODY onKeyDown = 'lockKey()'>
<%
	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'> ");

	String whereclause	= "";
	String from			= "";
	String to			= "";
	
	String doc_type_code	= request.getParameter("DOC_CODE");
	String doc_type_name	= request.getParameter("DOC_NAME");
	String doc_number		= request.getParameter("DOC_NUMBER");
	String eff_status		= request.getParameter("EFF_STATUS");
	
	StringBuffer sql	= null;
	StringBuffer mysql	= null;
	StringBuffer mysql1 = null;
	sql					= new StringBuffer();
	mysql				= new StringBuffer();
	mysql1				= new StringBuffer();

	whereclause = request.getParameter("whereclause");
	from		= request.getParameter("from");
	to		    = request.getParameter("to");

	int andCheck = 0;

	if(whereclause == null || whereclause.equals("null"))
	{
		if(!(doc_type_code == null || doc_type_code.equals("null")))
		{
			sql.append(" where upper(doc_type_code) like upper('"+doc_type_code+"%') ");
			andCheck = 1;
		}
		if(!(doc_type_name == null || doc_type_name.equals("null")))
		{
			if(andCheck == 1)
			{
				sql.append(" and upper(doc_type_name) like upper('"+doc_type_name+"%') ");
			}
			else
			{
				sql.append(" where upper(doc_type_name) like upper('"+doc_type_name+"%') ");
				andCheck = 1;
			}
		}
		if(!(doc_number == null || doc_number.equals("null")))
		{
			if(andCheck == 1)
			{
			  sql.append(" and upper(doc_no) like upper('"+doc_number+"%') ");
			}
			else
			{
				sql.append(" where upper(doc_no) like upper('"+doc_number+"%') ");
				andCheck = 1;
			}
		}
		if(!(eff_status == null || eff_status.equals("null")))		
		{
			if(eff_status.equals("E"))
			{
				if(andCheck == 1)
				{
					sql.append(" and eff_status = 'E' "); 
				}
				else
				{
					sql.append(" where eff_status = 'E' ");
					andCheck = 1;
				}
			}
			if(eff_status.equals("D"))
			{
				if(andCheck == 1)
				{
					sql.append(" and eff_status = 'D' ");
				}
				else
				{
					sql.append(" where eff_status = 'D' ");
					andCheck = 1;
				}
			}
		}

		String order[] = request.getParameterValues("orderbycolumns");
		if(!(order == null || order.equals("")))
		{
			sql.append(" order by ");
			for(int i=0;i<order.length;i++)
			{
				if(i == order.length - 1)
				{
					sql.append(order[i]);
				}
				else
				{
					sql.append(order[i]);
					sql.append(" , ");
				}
			}
		}
	}
	else
	{
		sql.append(whereclause);
	}

	int start	= 0;
	int end		= 0;
	int	i		= 1;

	if(from == null) start = 1;
	else start = Integer.parseInt(from);

	if(to == null) end = 14;
	else end = Integer.parseInt(to);

	Connection conn			= null;
	java.sql.Statement stmt	= null;
	ResultSet rst			= null;

//	int maxRecords = 0;

	try
	{
		
		
		conn = webbeans.eCommon.ConnectionManager.getConnection(request);
		stmt = conn.createStatement();

	/*	mysql.append(" SELECT count(*) total FROM fm_doc_type ");
		mysql.append(sql);
		rst  = stmt.executeQuery(mysql.toString());

		if(rst != null && rst.next())
		{
			maxRecords = rst.getInt("total");
		} if(rst  != null) rst.close();

		if(maxRecords == 0)
		{*/
			%>
			<SCRIPT>
				//alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
				//parent.f_query_add_mod.location.href="../../eFM/jsp/FMDocumentTypeQueryCriteria.jsp";
			</SCRIPT>
			<%
		//}
		mysql1.append(" SELECT doc_type_code,doc_type_name,doc_no,eff_status FROM fm_doc_type ");
		mysql1.append(sql);
		rst = stmt.executeQuery(mysql1.toString());
		%>
		
		<%
			if(start !=1)
				for(int j=1;j<start;i++,j++)
				{
					rst.next();
				}
			String calssValue = "";
			int cnt=0;
			while( i<=end && rst.next())
			{
				if(cnt==0)
				{%>
					<TABLE align='RIGHT'>
					<TR>
						
							<%
							if(!(start <= 1))
								out.println("<td align ='right' id='prev'><A href='../jsp/FMDocumentTypeQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></TD>");
								%>
									<td align ='right' id='next' style='visibility:hidden'>
								<%
						//	if(!((start+14) > maxRecords))
								out.println("<A href='../jsp/FMDocumentTypeQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
							%>
						</TD>
					</TR>
				</TABLE>
				<BR><BR>
				<TABLE border='1' cellpadding='0' cellspacing='0' width='100%'>
				<tr>
					<TH><fmt:message key="eFM.DocumentCode.label" bundle="${fm_labels}"/></TH>
					<TH><fmt:message key="eFM.DocumentName.label" bundle="${fm_labels}"/></TH>
					<TH><fmt:message key="Common.documentno.label" bundle="${common_labels}"/></TH>
					<TH><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></TH>
				</tr>
<%				}
				if(i%2 == 0)
					calssValue = "QRYEVEN";
				else
					calssValue = "QRYODD";

				String doc_fld_id = rst.getString("doc_type_code"); 
				String doc_fld_name = rst.getString("doc_type_name"); 
				String doc_fld_no = rst.getString("doc_no"); 
				String effstatus = rst.getString("eff_status"); 

				if(doc_fld_id == null || doc_fld_id.equals("null"))
					doc_fld_id = "";
				if(doc_fld_name == null || doc_fld_name.equals("null"))
					doc_fld_name = "";
				if(doc_fld_no == null || doc_fld_no.equals("null"))
					doc_fld_no = "";
				if(effstatus == null || effstatus.equals("null"))
					effstatus = "";
				
				out.println("<TR><TD  class='"+calssValue+"'>");
				out.println("<A href='../jsp/FMDocumentTypeAddMod.jsp?doc_fld_id="+doc_fld_id+"&target=f_query_add_mod&operation=modify'>");
				out.println(doc_fld_id+"</A></TD>");
				out.println("<TD  class='"+calssValue+"'>"+doc_fld_name+"</TD>");
				out.println("<TD  class='"+calssValue+"'>"+doc_fld_no+"</TD>");
				out.println("<TD align='center' class='"+calssValue+"'>");
					
				if(effstatus.equals("E"))
					out.println("<IMG src='../../eCommon/images/enabled.gif'></IMG>");
				else if(effstatus.equals("D"))
					out.println("<IMG src='../../eCommon/images/RRnwd.gif'></IMG>");
					
				out.println("</TD></TR>");
					
				i++;
				cnt++;
			}
			if (cnt==0)
			{
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
			}
			boolean flag = false;
			if ( cnt < 14 || (!rst.next()) ) {
			%>
				<script >
				if (document.getElementById("next"))
					document.getElementById("next").style.visibility='hidden';
				</script>
			<% flag = true;
					} else {%>
				<script >
				if (document.getElementById("next"))
					document.getElementById("next").style.visibility='visible';
				</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



			<%}
		%>
		</TABLE>
	<%
	
	if((sql != null) && (sql.length() >0))
	{
		sql.delete(0,sql.length());
	}
	if((mysql != null) && (mysql.length() >0))
	{
		mysql.delete(0,mysql.length());
	}
	if((mysql1 != null) && (mysql1.length() >0))
	{
		mysql1.delete(0,mysql1.length());
	}

	if(rst  != null) rst.close();
	if(stmt != null) stmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception :"+e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(conn,request);
	}
	%>
	</BODY>
</HTML>


