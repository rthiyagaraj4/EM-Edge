<!DOCTYPE html>
<%@page  language="java" import="java.sql.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
			<script src="../../eCommon/js/common.js" language="javascript"></script>
			<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>
			<script language='javascript' src='../js/FlowSheetCompDetail.js'></script>
			<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
			
				
	</head>

	<body  class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<%
			Properties p	= (Properties)session.getValue("jdbc");
			String locale	= (String) p.getProperty("LOCALE");
			request.setCharacterEncoding("UTF-8");
			Connection con	=	null;
			PreparedStatement pstmt=null;
			ResultSet rset=null;
			
			String eventItem=request.getParameter("eventItem")==null?"":request.getParameter("eventItem");
			String hist_type=request.getParameter("history_type");
			String resEventItem	="",resEventItemCode	="";
			int count=0;
			try{
					con=ConnectionManager.getConnection(request);
					if (!eventItem.equals("")){
						eventItem=eventItem+"%";
					}
						
					//String sql= " select EVENT_CODE ,short_desc SHORT_DESC from CR_CLIN_EVENT_MAST where hist_rec_type= ? and upper(SHORT_DESC) like upper(?) ";
					String sql= "select EVENT_CODE ,short_desc SHORT_DESC from CR_CLN_EVT_MST_LANG_VW where hist_rec_type= ? and language_id = ? and upper(SHORT_DESC) like upper(?)  ";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1,hist_type);
					pstmt.setString(2,locale);
					pstmt.setString(3,eventItem);
					rset=pstmt.executeQuery();

					while(rset.next()){
								resEventItem=rset.getString("SHORT_DESC");
								resEventItemCode=rset.getString("EVENT_CODE");
								count=count+1;
					}

					if (count==1){ 
								out.println("<script>");
								out.println("parent.frames[1].frames[2].document.forms[0].event_item1.value='"+resEventItem+"'");
								out.println("parent.frames[1].frames[2].document.forms[0].event_item.value='"+resEventItemCode+"'");
								out.println("parent.messageFrame.location.href='../../eCommon/jsp/error.jsp' ");
								out.println("</script>");
					 }
			
					if (count>1 || count==0){%>
 						<script language=javascript>
								parent.frames[1].frames[2].document.forms[0].event_item_but.disabled=true;
								callfunctionitemsearch();
						</script>
					<%}
			}catch(Exception e){
							//out.println("Error Raise"+e);//COMMON-ICN-0181
							e.printStackTrace();//COMMON-ICN-0181
			}finally{
					if (rset!=null) rset.close();
					if(pstmt!=null) pstmt.close();
					if (con!=null) ConnectionManager.returnConnection(con,request);
			}
		%>
	</body>

