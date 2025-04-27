<!DOCTYPE html>
<%@page  language="java" import="java.sql.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
			<script language='javascript' src='../../eCommon/js/common.js'></script>
			<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>
			<script src='../../eCA/js/FlowSheet.js' language='javascript'></script>
			<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
			</head>
			<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<%
			request.setCharacterEncoding("UTF-8");
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rset=null;
			java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
			String locale = (String) p.getProperty("LOCALE");
			String eventGroup=request.getParameter("eventGroup")==null?"":request.getParameter("eventGroup");
			String hist_type=request.getParameter("history_type");
			String resEventGroup	="";
			int count=0;
		
			try{
					con=ConnectionManager.getConnection(request);
					if (!eventGroup.equals("")){
						eventGroup=eventGroup+"%";
					}
						
					//String sql= "select EVENT_GROUP,long_desc SHORT_DESC from CR_CLIN_EVENT_GROUP where  hist_rec_type=?  and upper(SHORT_DESC) like upper(?)";

					String sql= "select EVENT_GROUP,long_desc SHORT_DESC from CR_CLN_EVT_GRP_LANG_VW where  hist_rec_type=?  and upper(SHORT_DESC) like upper(?) and language_id = ?";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1,hist_type);
					pstmt.setString(2,eventGroup);
					pstmt.setString(3,locale);

					rset=pstmt.executeQuery();

					while(rset.next()){
								resEventGroup=rset.getString("SHORT_DESC");
								count=count+1;
					}

					if (count==1){ 
								/*out.println("<script>");
								out.println("top.content.workAreaFrame.frames[0].document.forms[0].event_group1.value='"+resEventGroup+"'");
								out.println("top.content.messageFrame.location.href='../../eCommon/jsp/error.jsp' ");
								out.println("</script>");*/
		
								out.println("<script language='javascript'>");
								out.println("if(top.content!=null){");	 out.println("top.content.workAreaFrame.frames[0].document.forms[0].event_group1.value='"+resEventGroup+"'");
								out.println("top.content.messageFrame.location.href='../../eCommon/jsp/error.jsp' ");
								out.println("}else{");
								out.println("parent.criteria_f0.criteria_f1.document.forms[0].event_group1.value='"+resEventGroup+"'");
								out.println("parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp' ");
								out.println("}");
								out.println("</script>");
					 }
			
					if (count>1 || count==0){%>
 						<script language=javascript>
						//top.content.workAreaFrame.frames[0].document.forms[0].event_group_but.disabled=true;
						
					  if(top.content!=null)
	                  {
						top.content.workAreaFrame.frames[0].document.forms[0].event_group_but.disabled=true;
					 }
					else
				     {
						parent.criteria_f0.criteria_f1.document.forms[0].event_group_but.disabled=true;
				      }
					  callfunction();
						</script>
					<%}
				if (rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
			
			}catch(Exception e){
							//out.println("Error Raise"+e);//COMMON-ICN-0181
							e.printStackTrace();//COMMON-ICN-0181	
			}finally{
					
					if (con!=null) ConnectionManager.returnConnection(con,request);
			}
		%>
	</body>
	<input type='hidden' name='locale' id='locale' value='<%=locale%>' >

