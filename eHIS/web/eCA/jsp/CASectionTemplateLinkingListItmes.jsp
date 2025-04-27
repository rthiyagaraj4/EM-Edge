<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	String compId=request.getParameter("comp_id")==null?"":request.getParameter("comp_id");
	//String srlNo=request.getParameter("srl_no")==null?"":request.getParameter("srl_no");
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	int i=0;
	String classValue = "";
%>
<html>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
	<%
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<body onKeyDown="lockKey()">
<form name=compLinkingListItemsForm >
	<table width='100%' border='1' cellspacing='0' cellpadding='0' align='center' >
		<tr>
			<td class='columnheader'><fmt:message key="Common.Items.label" bundle="${common_labels}"/></td>
			<td class='columnheader'><fmt:message key="Common.Applicable.label" bundle="${common_labels}"/> </td>
			<td class='columnheader'><fmt:message key="Common.Default.label" bundle="${common_labels}"/> </td>
		</tr>
		<%
		try
		{
			con= ConnectionManager.getConnection(request);
			//String listItemId = "";
			String listItemText = "";
			String sql = "Select list_item_id, list_item_text from CA_TEMPLATE_COMP_LIST where comp_id = ?  order by order_seq_no ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,compId);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				i++;
				if(i%2!=0)
					classValue = "QRYODD";
				else
					classValue = "QRYEVEN";

				//listItemId = rs.getString(1);	
				listItemText = rs.getString(2);							
				%>
				<tr>
					<td class="<%=classValue%>"><%=listItemText%></td>
					<td class="<%=classValue%>"><input type=checkbox ></td>
					<td class="<%=classValue%>"><input type=radio name=default>
				</tr>
				<%
			}

		}
		catch(Exception e)
		{
			//out.println(e);//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			if (rs!=null) rs.close();
			if (pstmt!=null) pstmt.close();
			if(con!=null) ConnectionManager.returnConnection(con,request);

		}
		%>
		</table>
	</form>
</body>
</html>

