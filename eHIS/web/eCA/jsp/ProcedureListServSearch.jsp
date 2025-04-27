<!DOCTYPE html>
<%@page  language="java" import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
			<script language='javascript' src='../../eCommon/js/common.js'></script>
			<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>
			<script Language="JavaScript" src='../js/ProcedureList.js'></script>
			<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
			
	</head>

	<body class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
		<%
			request.setCharacterEncoding("UTF-8");
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rset=null;
			java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
			String locale = (String) p.getProperty("LOCALE");
			
			String serviceid=request.getParameter("serviceid")==null?"":request.getParameter("serviceid");
			String resServiceItem	="";
			String resServiceCode="";
			int count=0;
			try
			{
					con=ConnectionManager.getConnection(request);

					if (!serviceid.equals(""))
					{
						serviceid=serviceid+"%";
					}
						
					//String sql= "Select service_code, short_desc from am_service where upper(SHORT_DESC) like upper(?)";

					String sql = "Select service_code, short_desc from am_service_lang_vw where upper(SHORT_DESC) like upper(?) and language_id = ?";

					pstmt=con.prepareStatement(sql);
					pstmt.setString(1,serviceid);
					pstmt.setString(2,locale);
					rset=pstmt.executeQuery();

					while(rset.next())
					{
								resServiceCode=rset.getString("service_code");
								resServiceItem=rset.getString("SHORT_DESC");
								count=count+1;
					}
	
					if (count==1)
					{ 
								out.println("<script>");
								out.println("top.content.workAreaFrame.frames[0].document.forms[0].serv_code.value='"+resServiceCode+"'");
								out.println("top.content.workAreaFrame.frames[0].document.forms[0].serv_code1.value='"+resServiceItem+"'");
								out.println("top.content.messageFrame.location.href='../../eCommon/jsp/error.jsp' ");
								out.println("</script>");
					 }
			
					if (count>1 || count==0)
					{%>
 						<script language=javascript>
								top.content.workAreaFrame.frames[0].document.forms[0].searchcode_button.disabled=true;
								callfunction();
						</script>
					<%}
					if (rset!=null) rset.close();
					if(pstmt!=null) pstmt.close();
			}
			catch(Exception e)
			{
							//out.println("Error Raise"+e);//common-icn-0181
		                                   e.printStackTrace();//COMMON-ICN-0181
			}
			finally
			{
					if (con!=null) ConnectionManager.returnConnection(con,request);
			}
		%>
	<form name="Procedure_List_Search" id="Procedure_List_Search">
		<input type="hidden" name="locale" id="locale" value="<%=locale%>">
	</form>
	</body>

