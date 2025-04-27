<!DOCTYPE html>
<%@page  language="java" import="java.sql.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>essage
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
			<script language=javascript src='../js/TextBlock.js'></script>
			<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>
			<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
			</head>

	<BODY  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rset=null;
			
			String serviceid=request.getParameter("serviceid")==null?"":request.getParameter("serviceid");
				
			String resServiceId="";
			String resServiceDesc="";
			int count=0;
			try{
					con=ConnectionManager.getConnection(request);

						if (!serviceid.equals("")){
							serviceid=serviceid+"%";
						}
						
					String sql="select SERVICE_CODE, SHORT_DESC from am_service  where eff_status='E'  and  upper(SHORT_DESC) like upper(?)";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1,serviceid);
					rset=pstmt.executeQuery();

					while(rset.next()){
								resServiceId=rset.getString("SERVICE_CODE");
								resServiceDesc=rset.getString("SHORT_DESC");
								count=count+1;
					}

					if (count==1){ 
								out.println("<script>");
								out.println("parent.frames[1].document.forms[0].service_desc.value='"+resServiceDesc+"'");
								out.println("parent.frames[1].document.forms[0].service.value='"+resServiceId+"'");
								out.println("parent.frames[1].document.forms[0].flagService.value='true'");
								out.println("parent.frames[2].location.href='../../eCommon/jsp/error.jsp' ");
								out.println("</script>");
					 }
			
					if (count>1 || count==0){ 	%>
						<script language=javascript>
								parent.frames[1].document.forms[0].service_desc_search.disabled=true;
								parent.frames[1].document.forms[0].flagService.value='true'
								callfunction();
						</script>
					<% }

				if (rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
			}
			catch(Exception e)
			{
				//out.println("Error Raise"+e);//COMMON-ICN-0181
				e.printStackTrace();//COMMON-ICN-0181
			}
			finally
			{
				if (con!=null) ConnectionManager.returnConnection(con,request);
			}
		%>
	</body>

