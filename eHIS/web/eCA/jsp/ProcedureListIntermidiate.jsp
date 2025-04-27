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
			String procedurecode=request.getParameter("procedurecode")==null?"":request.getParameter("procedurecode");
			String resprocedurecode	="";
			//String resproceduredesc="";
			int count=0;
			try
			{
					con=ConnectionManager.getConnection(request);

					if (!procedurecode.equals(""))
					{
						procedurecode=procedurecode+"%";
					}
						
					//String sql= "Select service_code, short_desc from am_service where upper(SHORT_DESC) like upper(?)";
					//String sql= "Select diag_code,short_desc from mr_icd_code where  record_type='O'  and upper(SHORT_DESC) like upper('"+procedurecode+"')";//common-icn-0180
					String sql= "Select diag_code,short_desc from mr_icd_code where  record_type='O'  and upper(SHORT_DESC) like upper(?)";//common-icn-0180
					
					pstmt=con.prepareStatement(sql);
					//pstmt.setString(1,procedurecode);
					pstmt.setString(1,procedurecode);//common-icn-0180
					rset=pstmt.executeQuery();

					while(rset.next())
					{
								resprocedurecode=rset.getString("diag_code");
								//resproceduredesc=rset.getString("SHORT_DESC");
								count=count+1;
					}
	
					if (count==1)
					{ 
								out.println("<script>");
								out.println("top.content.workAreaFrame.frames[0].document.forms[0].proc_code.value='"+resprocedurecode+"'");
								out.println("top.content.messageFrame.location.href='../../eCommon/jsp/error.jsp' ");
								out.println("</script>");
					 }
			
					if (count>1 || count==0)
					{%>
 						<script language=javascript>
								top.content.workAreaFrame.frames[0].document.forms[0].searchcode_button.disabled=true;
								callfunction_procedure();
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
	</body>

