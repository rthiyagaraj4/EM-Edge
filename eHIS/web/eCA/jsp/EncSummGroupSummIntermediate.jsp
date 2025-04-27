<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
13/09/2013     		1   		Sethuraman      Created for Searching encounter Summary
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

		<script language="JavaScript" src ="../../eCA/js/EncSummaryGroupSumm.js"></script>
		<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/ValidateControl.js'></Script>
		<SCRIPT LANGUAGE="JavaScript">
			var returnArray;
		</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%@page import="java.sql.*, java.io.*, webbeans.eCommon.ConnectionManager"%>
<body OnMouseDown='CodeArrest();' onKeyDown="lockKey()">
<%

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String summCode = "";	
	String sql = "";
	int count =0;
	try
	{
			con = ConnectionManager.getConnection(request);			
			summCode = request.getParameter("es_summ_code") == null ? "" : request.getParameter("es_summ_code");			
						
			sql = "SELECT es_summ_code, es_summ_desc, es_summ_title, es_sum_status from cr_es_summ_hdr where (upper(es_summ_code) like upper(?) or upper(es_summ_desc) like upper(?) ) ORDER BY  es_summ_desc";		
			
			//sql ="SELECT note_type code, note_type_desc description FROM ca_note_type where eff_status='E' and upper(note_type_desc) like upper(?) order by note_type_desc";
			
			ps = con.prepareStatement(sql);
			ps.setString(1,summCode);
			ps.setString(2,summCode);
			rs = ps.executeQuery();
			while(rs.next())
			{
				count++;
			}	
			if(count == 1)
			{
				rs = ps.executeQuery();
				out.println("<script>");
				while(rs.next())
				{	
					out.println("parent.f_query_add_mod.document.SummGroupSummForm.es_summ_code.value='"+rs.getString(1)+"' ");						
					out.println("parent.f_query_add_mod.document.SummGroupSummForm.es_summ_desc.value='"+rs.getString(2)+"' ");
					out.println("parent.f_query_add_mod.document.SummGroupSummForm.es_summ_title.value='"+rs.getString(3)+"' ");
					if (rs.getString(4).equalsIgnoreCase("e"))
						out.println("parent.f_query_add_mod.document.SummGroupSummForm.es_summ_status.value='1' ");
					else
						out.println("parent.f_query_add_mod.document.SummGroupSummForm.es_summ_status.value='0' ");
					
					out.println("parent.f_query_add_mod.document.SummGroupSummForm.flag.value='true' ");

				}
			}
			if(rs != null) rs.close();
			out.println("</script>");

			if(count == 0 || count > 1)
			{
				//sql = "SELECT note_type code,note_type_desc description FROM ca_note_type where eff_status='E' and upper(note_type) like upper(?) and  upper(note_type_desc) like upper(?) ORDER BY  note_type_desc";
				sql = "SELECT es_summ_code, es_summ_desc, es_summ_title, es_sum_status from cr_es_summ_hdr where (upper(es_summ_code) like upper(?) or upper(es_summ_desc) like upper(?) ) ORDER BY  es_summ_desc";			
%>
	<script>
		 retArray = callSummCodeType1("<%=sql%>","Summary",parent.f_query_add_mod.document.SummGroupSummForm.es_summ_code);
			if(retArray != null && retArray !="")	
			{
				parent.f_query_add_mod.document.SummGroupSummForm.es_summ_desc.value = retArray[1];
				parent.f_query_add_mod.document.SummGroupSummForm.es_summ_code.value = retArray[0];
				parent.f_query_add_mod.document.SummGroupSummForm.flag.value = 'true';
				parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';				
			}
			else
			{
				parent.f_query_add_mod.document.SummGroupSummForm.es_summ_desc.value = "";
				parent.f_query_add_mod.document.SummGroupSummForm.es_summ_code.value = "";
				parent.f_query_add_mod.document.SummGroupSummForm.flag.value = 'true';
				parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
			}			
	</script>
<%
		 }	
	if(rs != null) rs.close();
	if(ps != null) ps.close();
	}
	catch(Exception ee)
	{
		//out.println("Exception in Encounter Summary Intermediate Module "+ee.toString());//COMMON-ICN-0181
		ee.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		try{
				
				if(con != null) ConnectionManager.returnConnection(con);
		}
		catch(Exception e){}
	}
%>
 </body>
</html>

