<!DOCTYPE html>
<!--Maheshwaran K created for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013-->
<%@ page import="java.sql.*, java.util.*, java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>

<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
<%
String title = request.getParameter("title");
title = (title == null)?"":title;
%>
<title><%=title%></title> 
<head>
<body>
<%
Connection con = null;
	Statement stmt = null;
	ResultSet rset = null;
	Statement tk_stmt = null;
	ResultSet tk_rset = null;	
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String facilityId	= (String)session.getAttribute("facility_id");
	String locale = (String) p.getProperty("LOCALE");
	String chart_id_str="";
	String note_type_str="";
	String diag_set_str="";
	String order_cat_str="";
	String order_cat_str_chk="";
	String mr_mds_recorded=request.getParameter("mr_mds_recorded");
	StringBuffer chart_desc= new StringBuffer("");
	StringBuffer note_type_desc= new StringBuffer("");
	StringBuffer diag_term_desc= new StringBuffer("");
	StringBuffer order_cat_desc= new StringBuffer("");
	try
		{
		con = ConnectionManager.getConnection(request);
		if(mr_mds_recorded.startsWith("#"))
		mr_mds_recorded=mr_mds_recorded.replace("#"," #");
		if(mr_mds_recorded.contains("###"))
		mr_mds_recorded=mr_mds_recorded.replace("###","# # #");
		if(mr_mds_recorded.contains("##"))
		mr_mds_recorded=mr_mds_recorded.replace("##","# #");
		if(mr_mds_recorded.endsWith("#"))
		order_cat_str_chk="empty";
		try
			{
		StringTokenizer tk=new StringTokenizer(mr_mds_recorded,"#");
		//if (tk.hasMoreTokens()){
			chart_id_str=tk.nextToken().trim();
			note_type_str=tk.nextToken().trim();
			diag_set_str=tk.nextToken().trim();
			if(!order_cat_str_chk.equals("empty")){
			order_cat_str=tk.nextToken().trim();
			}
	//	}	
	}
	catch(Exception e)
		{
		System.out.println("===="+e);
		}
			//Chart Token starts 
			if(!chart_id_str.equals("")){
			StringTokenizer chart_tk = new StringTokenizer(chart_id_str,"$");
			while(chart_tk.hasMoreTokens())
				{
				String chart_id=chart_tk.nextToken();
				try	
				{
				tk_stmt	= con.createStatement();
				tk_rset=tk_stmt.executeQuery("select CA_GET_DESC.CA_CHART('"+chart_id+"','"+locale+"',2)  SHORT_DESC from ca_chart where CHART_ID='"+chart_id+"'");
				if(tk_rset.next())
					{
					if(chart_desc.length()==0)
						{
						chart_desc.append(tk_rset.getString("SHORT_DESC"));
						}
					else{	
						chart_desc.append(",");
						chart_desc.append(tk_rset.getString("SHORT_DESC"));
						}
					}
				}
				catch(Exception e)
					{
					e.printStackTrace();
					}
				if(tk_stmt!=null) tk_stmt.close();
				if(tk_rset!=null) tk_rset.close();
				}
			}
			//Chart Token Ends 
			//Notes Token starts 
			if(!note_type_str.equals("")){
			StringTokenizer note_tk = new StringTokenizer(note_type_str,"$");
			while(note_tk.hasMoreTokens())
				{
				String note_type_id=note_tk.nextToken();
				try	
				{
				tk_stmt	= con.createStatement();
				tk_rset=tk_stmt.executeQuery("SELECT CA_GET_DESC.CA_NOTE_TYPE('"+note_type_id+"','"+locale+"',1)  NOTE_TYPE_DESC FROM CA_NOTE_TYPE WHERE NOTE_TYPE='"+note_type_id+"'");
				if(tk_rset.next())
					{
					if(note_type_desc.length()==0)
						{
						note_type_desc.append(tk_rset.getString("NOTE_TYPE_DESC"));
						}
					else{	
						note_type_desc.append(",");
						note_type_desc.append(tk_rset.getString("NOTE_TYPE_DESC"));
						}
					}
				}
				catch(Exception e)
					{
					e.printStackTrace();
					}
				if(tk_stmt!=null) tk_stmt.close();
				if(tk_rset!=null) tk_rset.close();
				}
			}
			//Note Token Ends 
			//Order Token starts 
			if(!order_cat_str_chk.equals("empty")){
			StringTokenizer order_tk = new StringTokenizer(order_cat_str,"$");
			while(order_tk.hasMoreTokens())
				{
				String order_cat_id=order_tk.nextToken();
				try	
				{
				tk_stmt	= con.createStatement();
				tk_rset=tk_stmt.executeQuery("SELECT OR_GET_DESC.OR_ORDER_CATEGORY('"+order_cat_id+"','"+locale+"',2)  SHORT_DESC FROM OR_ORDER_CATEGORY WHERE ORDER_CATEGORY='"+order_cat_id+"'");
				if(tk_rset.next())
					{
					if(order_cat_desc.length()==0)
						{
						order_cat_desc.append(tk_rset.getString("SHORT_DESC"));
						}
					else{	
						order_cat_desc.append(",");
						order_cat_desc.append(tk_rset.getString("SHORT_DESC"));
						}
					}
				}
				catch(Exception e)
					{
					e.printStackTrace();
					}
				if(tk_stmt!=null) tk_stmt.close();
				if(tk_rset!=null) tk_rset.close();
				}
			}
			//Order Token Ends 
			//Diagnosis Token starts 
			if(!diag_set_str.equals("")){
				StringTokenizer diag_tk = new StringTokenizer(diag_set_str,"$");
				while(diag_tk.hasMoreTokens())
					{
					String diag_termset_id=diag_tk.nextToken();
				try	
				{
				tk_stmt	= con.createStatement();
				tk_rset=tk_stmt.executeQuery("SELECT MR_GET_DESC.MR_TERM_SET('"+diag_termset_id+"','"+locale+"',1)  TERM_SET_DESC FROM MR_TERM_SET WHERE TERM_SET_ID='"+diag_termset_id+"'");
				if(tk_rset.next())
					{
					if(diag_term_desc.length()==0)
						{
						diag_term_desc.append(tk_rset.getString("TERM_SET_DESC"));
						}
					else{	
						diag_term_desc.append(",");
						diag_term_desc.append(tk_rset.getString("TERM_SET_DESC"));
						}
					}
				}
				catch(Exception e)
					{
					e.printStackTrace();
					}
				if(tk_stmt!=null) tk_stmt.close();
				if(tk_rset!=null) tk_rset.close();
				}
			}
			//Diagnosis Token Ends
			
		}
	catch(Exception e)	
		{
		//out.println("Exception occurred while getting the MDS Pending Completion detaials  : "+e);
		e.printStackTrace();
		}
	%>
	<table>	 
 	<tr><td clospan='2'><div style="position:relative;height:300px;width:500px;vertical-align:top;overflow:auto"> 
	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
	<th  align='left'><fmt:message key="eMR.MDS.label" bundle="${mr_labels}"/>&nbsp;<fmt:message key="Common.Compliance.label" bundle="${common_labels}"/></th>
	</table>
	<table cellspacing=0 cellpadding=0  border='1' cellpadding=0 cellspacing=0>
	<tr><td height='10px'>&nbsp;</td></tr>
	<tr>
	<th  align='left' width='150px'><fmt:message key="eMR.MDS.label" bundle="${mr_labels}"/></th>
	<th align='left' width="70%" nowrap ><fmt:message key="Common.Pending.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Completion.label" bundle="${common_labels}"/></th>
	</tr>
	<%if(!diag_set_str.equals("")){%>
	<tr><td class='QRYEVEN'><font color='blue'><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></font></td>
	<td class='QRYEVEN'><%=diag_term_desc.toString()%></td></tr>
	<%}
	if(!chart_id_str.equals("")){%>
	<tr><td class='QRYEVEN'><font color='blue'><fmt:message key="Common.Charts.label" bundle="${common_labels}"/></font></td>
	<td class='QRYEVEN'><%=chart_desc.toString()%></td></tr>
	<%
	}
	if(!note_type_str.equals("")){%>
	<tr><td class='QRYEVEN'><font color='blue'><fmt:message key="Common.ClinicalNotes.label" bundle="${common_labels}"/></font></td>
	<td class='QRYEVEN'><%=note_type_desc.toString()%></td></tr>
	<%}
	if(!order_cat_str_chk.equals("empty")){
	%>
	<tr><td class='QRYEVEN'><font color='blue'><fmt:message key="Common.Orders.label" bundle="${common_labels}"/></font></td>
	<td class='QRYEVEN'><%=order_cat_desc.toString()%></td></tr>
	<%}%>
	</table></div></td>
	</tr>		
	<tr height='10'><td colspan='2'>&nbsp;</td></tr>
	<tr>
		<td align='right' colspan="2"  width="460px">
		<input type=button class='button' name = 'close' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>'   onClick='parent.document.getElementById("dialog_tag").close()'">&nbsp;</td>
	</tr>
	
</table>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	? "" : inputString;
	}

	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	? defaultValue : inputString;
	}
%>
	</body>
</head>
</html>


