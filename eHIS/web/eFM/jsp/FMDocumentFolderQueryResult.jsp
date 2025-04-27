<!DOCTYPE html>
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
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>
	<BODY onMouseDown='CodeArrest()' onKeyDown = 'lockKey();'>
<%
	String whereclause	= "";
	String from			= "";
	String to			= "";	
	String mysql		= "";
	String mysql1		= "";
	StringBuffer SelectSqlBuffer	= null;
	SelectSqlBuffer					= new StringBuffer();
	
	String facility_id = (String) session.getValue("facility_id");

	int andCheck = 0;

	whereclause = request.getParameter("whereclause");
	from		= request.getParameter("from");
	to		    = request.getParameter("to");

	if(whereclause == null || whereclause.equals("null"))
	{		
		String doc_folder_id			= request.getParameter("DOC_FOLDER_ID");
		String doc_folder_name			= request.getParameter("DOC_FOLDER_NAME");
		String patient_period_specific	= request.getParameter("PATIENT_PERIOD_SPECIFIC");
		String eff_status				= request.getParameter("EFF_STATUS");

		if(!(doc_folder_id == null || doc_folder_id.equals("null")))
		{
			SelectSqlBuffer.append(" where upper(doc_folder_id) like upper('"+doc_folder_id+"%') ");
			andCheck = 1;
		}
		if(!(doc_folder_name == null || doc_folder_name.equals("null")))
		{
			if(andCheck == 1)
			{
				SelectSqlBuffer.append( " and upper(doc_folder_name) like upper('"+doc_folder_name+"%') ");
			}
			else
			{
				SelectSqlBuffer.append( " where upper(doc_folder_id) like upper('"+doc_folder_name+"%') ");
				andCheck = 1;
			}
		}
		if(!(patient_period_specific == null || patient_period_specific.equals("null")))
		{
			if(patient_period_specific.equals("P"))
			{
				if(andCheck == 1)
				{
					SelectSqlBuffer.append(" and patient_period_specific ='P' ");
				}
				else
				{
					SelectSqlBuffer.append(" where patient_period_specific = 'P' ");
					andCheck = 1;
				}
			}
			if(patient_period_specific.equals("D"))
			{
				if(andCheck == 1)
				{
					SelectSqlBuffer.append(" and patient_period_specific ='D' ");
				}
				else
				{
					SelectSqlBuffer.append(" where patient_period_specific = 'D' ");
					andCheck = 1;
				}
			}
		}
		if(!(eff_status == null || eff_status.equals("null")))		
		{
			if(eff_status.equals("E"))
			{
				if(andCheck == 1)
				{
					SelectSqlBuffer.append(" and eff_status = 'E' "); 
				}
				else
				{
					SelectSqlBuffer.append(" where eff_status = 'E' ");
					andCheck = 1;
				}
			}
			if(eff_status.equals("D"))
			{
				if(andCheck == 1)
				{
					SelectSqlBuffer.append(" and eff_status = 'D' ");
				}
				else
				{
					SelectSqlBuffer.append(" where eff_status = 'D' ");
					andCheck = 1;
				}
			}
		}
		if(!(facility_id == null || facility_id.equals("null")))
		{
			if(andCheck ==1)
			{
				SelectSqlBuffer.append(" and facility_id = '"+facility_id+"' ");
			}
			else
			{
				SelectSqlBuffer.append(" where facility_id = '"+facility_id+"' ");
				andCheck = 1;
			}
		}
		String order[] = request.getParameterValues("orderbycolumns");
		if(!(order == null || order.equals("")))
		{
			SelectSqlBuffer.append(" order by ");
			for(int i=0;i<order.length;i++)
			{
				if(i == order.length - 1)
					SelectSqlBuffer.append(order[i]);
				else
					SelectSqlBuffer.append( order[i]+",");
			}
		}
	}
	else
	{
		 SelectSqlBuffer.append(whereclause);
	}
	int start	= 0;
	int end		= 0;
	int	i		= 1;

	if(from == null)
		start = 1;
	else
		start = Integer.parseInt(from);
	if(to == null)
		end = 14;
	else
		end = Integer.parseInt(to);

	Connection conn = null;
	Statement stmt	= null;
	ResultSet rst	= null;

	int maxRecords = 0;

	try
	{
		mysql ="SELECT count(*) total FROM fm_doc_folder" + SelectSqlBuffer; 
		conn = webbeans.eCommon.ConnectionManager.getConnection(request);
		stmt = conn.createStatement();
		rst  = stmt.executeQuery(mysql);

		if(rst != null && rst.next())
		{
			maxRecords = rst.getInt("total");
		}
		if(rst  != null) rst.close();
		if(maxRecords == 0)
		{
%>
			<SCRIPT>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
				parent.f_query_add_mod.location.href="../../eFM/jsp/FMDocumentFolderQueryCriteria.jsp";
			</SCRIPT>
<%
		}
		mysql1="SELECT doc_folder_id,doc_folder_name,patient_period_specific,eff_status FROM fm_doc_folder"+SelectSqlBuffer;
		rst = stmt.executeQuery(mysql1);
%>
		<P>
		<TABLE align='right'>
			<TR>
				<TD>
<%
					if(!(start <= 1))
					{
						out.println("<A href='../jsp/FMDocumentFolderQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(SelectSqlBuffer.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
					}
					if(!((start+14) > maxRecords))
					{
						out.println("<A href='../jsp/FMDocumentFolderQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(SelectSqlBuffer.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
					}
%>
				</TD>
			</TR>
		</TABLE>
		</P><BR><BR>
		<TABLE border='1' cellpadding='0' cellspacing='0' width='100%' align='center'>
			<TH><fmt:message key="eFM.DocumentFolderID.label" bundle="${fm_labels}"/></TH>
			<TH><fmt:message key="eFM.DocumentFolderName.label" bundle="${fm_labels}"/></TH>
			<TH><fmt:message key="eFM.DocumentFolderType.label" bundle="${fm_labels}"/></TH>
			<TH><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></TH>
<%
			if(start !=1)
			{
				for(int j=1;j<start;i++,j++)
				{
					rst.next();
				}
			}
			String calssValue = "";
			while(rst.next() && i<=end)
			{
				if(i%2 == 0)
					calssValue = "QRYEVEN";
				else
					calssValue = "QRYODD";

				String doc_fld_id			= rst.getString("doc_folder_id"); 
				String doc_fld_name			= rst.getString("doc_folder_name"); 
				String pat_period_specific	= rst.getString("patient_period_specific"); 
				String effstatus			= rst.getString("eff_status"); 

				if(doc_fld_id == null || doc_fld_id.equals("null"))
					doc_fld_id = "";
				if(doc_fld_name == null || doc_fld_name.equals("null"))
					doc_fld_name = "";
				if(pat_period_specific == null || pat_period_specific.equals("null"))
					pat_period_specific = "";
				if(effstatus == null || effstatus.equals("null"))
					effstatus = "";
				
				out.println("<TR><TD  class='"+calssValue+"'>");
				out.println("<A href='../jsp/FMDocumentFolderAddMod.jsp?operation=modify&doc_fld_id="+doc_fld_id+"&target=f_query_add_mod'>");
				out.println(doc_fld_id+"</A></TD>");
				out.println("<TD  class='"+calssValue+"'>"+doc_fld_name+"</TD>");
				
				out.println("<TD align='center' class='"+calssValue+"'>");
				if(pat_period_specific.equals("P"))
					out.println("Patient");
				else if(pat_period_specific.equals("D"))
					out.println("Period");

				out.println("<TD align='center' class='"+calssValue+"'>");
				if(effstatus.equals("E"))
					out.println("<IMG src='../../eCommon/images/enabled.gif'></IMG>");
				else if(effstatus.equals("D"))
					out.println("<IMG src='../../eCommon/images/RRnwd.gif'></IMG>");
					
				out.println("</TD></TR>");
					
				i++;
			}
%>
		</TABLE>
<%
	}
	catch(Exception e)
	{
		out.println("Exception :"+e.toString());
	}
	finally
	{
		if(rst  != null) rst.close();
		if(stmt != null) stmt.close();

		ConnectionManager.returnConnection(conn,request);
	}
%>
	</BODY>
</HTML>


