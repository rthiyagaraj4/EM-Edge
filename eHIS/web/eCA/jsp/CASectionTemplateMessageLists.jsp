<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	<title></title>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<!-- <modifeid by Arvind @10-12-2008> -->

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCA/js/CASectionTemplateMessage.js"></script>
		<script language="javascript" src="../../eCA/js/SectionTemplate.js"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




	</head>
	<body onKeyDown="lockKey()">
	<form name="CASectionTemplateMessageListsForm" id="CASectionTemplateMessageListsForm">
	<!-- <table align='center' border='1' width='100%' cellpadding='3' cellspacing='0'>
			<tr>
				<td class='columnHeadercenter' width='77%'><fmt:message key="Common.Message.label" bundle="${common_labels}"/></td>
				<td class='columnHeadercenter' width='23%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
			</tr>
		</table> -->
	<table class='grid'  width='100%' align='center'>
		<tr>
			<td class='COLUMNHEADER'  width='77%'><fmt:message key="Common.Message.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER'  width='23%' ><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
		</tr>
	<%
//	java.util.Properties p =(java.util.Properties) session.getValue( "jdbc" );

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	StringBuffer sqlqry = new StringBuffer("");
	String comp_id = request.getParameter("comp_id") == null?"":request.getParameter("comp_id");
	String section_code = request.getParameter("section_code") == null?"":request.getParameter("section_code");
	String label_type = request.getParameter("label_type") == null?"":request.getParameter("label_type");
	String comp_desc = request.getParameter("comp_desc") == null?"":request.getParameter("comp_desc");

		
	String Label_id   = "";
	String Label_desc = "";
	String Label_desc1 = "";
	String Label_detail = "";
	String ClassValue = "";
	String rowValue = "";
//	String selectYN = "";
	int count = 0;
	int i=0;
	int rowCount = 0;
	//int rowCount = 0;
	//out.println("section_code>>>>>>>"+section_code);	

	//out.println("label_type>>>>>>>"+label_type);	
	 String sql ="";
	 PreparedStatement psmt = null;
	 ResultSet rsmt = null;
	
	try
	{
		if(! label_type.equals("T"))
		{
			sqlqry.append("Select LABEL_ID,LABEL_DESC FROM CA_TEMPLATE_LABEL where DISCR_MSR_ID = ?"); if(label_type.equals("P"))
				sqlqry.append("and LABEL_TYPE = 'P'");
			else if(label_type.equals("H"))
				sqlqry.append("and LABEL_TYPE = 'H'");
			
			con = ConnectionManager.getConnection(request);
			ps  = con.prepareStatement(sqlqry.toString());
			ps.setString(1,comp_id);

			rs  = ps.executeQuery();

			sql = "SELECT COUNT(*) total FROM CA_TEMPLATE_LABEL WHERE DISCR_MSR_ID= ? AND LABEL_TYPE = 'P'";
			psmt  = con.prepareStatement(sql);
			psmt.setString(1,comp_id);
			rsmt = psmt.executeQuery();

			if(rsmt.next())
			{
				rowCount = rsmt.getInt("total");
				rowValue = String.valueOf(rowCount+1);
			}

			if(rsmt != null) rsmt.close();
			if(psmt != null) psmt.close();
			
			if(rowCount != 0)
			{
				while(rs.next())
				{
					Label_id = rs.getString("LABEL_ID");
					Label_desc = rs.getString("LABEL_DESC");
					if(Label_id == null || Label_id.equals("null"))Label_id ="";
					if(Label_desc == null || Label_desc.equals("null"))Label_desc ="";
					Label_detail =Label_id+","+Label_desc;

					if(count % 2 == 0)
						ClassValue = "gridData";
					else
						ClassValue = "gridData";
					
						out.println("<tr><td wrap width='77%'  name='label_id"+i+"' class='" + ClassValue + "' width='77%'>"+Label_desc+"</td>");
						out.println("<td wrap width='23%'   class='" + ClassValue + "'>");
						out.println("<input type='checkbox' name='chk_"+i+"' id='chk_"+i+"' value='"+Label_detail+"'  onClick =\"OnSelection(),closewPromthnt('"+Label_id+"','"+Label_desc+"')\"></td></tr>");
						count++;
						i++;
					Label_detail = "";
				}

			}
			else
			{
				if(label_type.equals("P"))
				{
					Label_id = comp_id + "_P"+rowValue;
					Label_id = Label_id.trim();
					Label_detail =Label_id +","+ comp_desc;

					out.println("<tr><td width='77%' wrap  name='label_id"+1+"' class='gridData'  width='77%'>"+comp_desc+"</td>");
					 if(!(comp_desc.equals("null")|| comp_desc == null ||comp_desc == ""))
				  {
					out.println("<td  wrap width='23%'  class='gridData'>");
					out.println("<input type='checkbox' name='chk_"+1+"' id='chk_"+1+"' value=\""+Label_detail+"\"  onClick =\"OnSelection(),closewPromthnt('"+comp_id+"','"+comp_desc+"')\"></td></tr>");
				  }
				}
			}

		if(rs!=null)rs.close();
		if(ps!=null)ps.close();
		}
		else if(label_type.equals("T"))
		{
			sqlqry.append("Select LABEL_ID,LABEL_DESC FROM CA_TEMPLATE_LABEL where DISCR_MSR_ID = ? and LABEL_TYPE = 'T' ");
			con = ConnectionManager.getConnection(request);
			ps  = con.prepareStatement(sqlqry.toString());
			ps.setString(1,section_code);
			rs  = ps.executeQuery();

			while(rs.next())
			{
				Label_id = rs.getString("LABEL_ID");
				Label_desc = rs.getString("LABEL_DESC");
				if(Label_id == null || Label_id.equals("null"))Label_id ="";
				if(Label_desc == null || Label_desc.equals("null"))Label_desc ="";
				Label_desc1 = Label_desc.replace("'","~");
				Label_detail =Label_id+","+Label_desc;

				if(count % 2 == 0)
					ClassValue = "gridData";
				else
					ClassValue = "gridData";
				
					out.println("<tr><td wrap width='77%' name='label_id"+i+"' class='" + ClassValue + "' width='77%'>"+Label_desc+"</td>");
					out.println("<td  wrap width='23%' class='" + ClassValue + "'>");
					out.println("<input type='checkbox' name='chk_"+i+"' id='chk_"+i+"' value=\""+Label_detail+"\"  onClick =\"OnSelection(),closewPromthnt('"+Label_id+"','"+Label_desc1+"')\"></td></tr>");
					count++;
					i++;
				Label_detail = "";
			}
		}
		if(rs!=null)rs.close();
		if(ps!=null)ps.close();
	  }
	  catch(Exception e)
	  {
			//out.println("Exception  in CASectionTemplateMessageLists.jsp" +e);//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
	  }
	  finally
	  {
		if(con!=null)ConnectionManager.returnConnection(con,request);
      }
	
	%>
	
</table>
<input type='hidden' name='rowCount' id='rowCount' value="<%=count%>">
<input type='hidden' name='comp_id' id='comp_id' value="<%=comp_id%>">
<input type='hidden' name='section_code' id='section_code' value="<%=section_code%>">
<input type='hidden' name='label_type' id='label_type' value="<%=label_type%>">


</form>
</body>
</html>

