<!DOCTYPE html>
<%@page  language="java" import="java.sql.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
			<script src="../../eCommon/js/common.js" language="javascript"></script>
			<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>
			<script language='javascript' src='../js/FlowSheetCompDetail.js'></script>
			<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	</head>
	<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<%
			Properties p = (Properties)session.getValue("jdbc");
			String locale	= (String) p.getProperty("LOCALE");
			request.setCharacterEncoding("UTF-8");
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rset=null;
			
			String eventGroup=request.getParameter("eventGroup")==null?"":request.getParameter("eventGroup");
			String hist_type=request.getParameter("history_type");
			String resEventGroup	="",resEventGroupCode	="";
			
			int count=0;

			try{
					con=ConnectionManager.getConnection(request);
					if (!eventGroup.equals("")){
						eventGroup=eventGroup+"%";
					}
						
					//String sql= "select EVENT_GROUP,short_desc SHORT_DESC from CR_CLIN_EVENT_GROUP where  hist_rec_type=?  and upper(SHORT_DESC) like upper(?)";
					String sql= "select EVENT_GROUP,short_desc SHORT_DESC from CR_CLN_EVT_GRP_LANG_VW where  hist_rec_type=?  and language_id = ? and upper(SHORT_DESC) like upper(?)";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1,hist_type);
					pstmt.setString(2,locale);
					pstmt.setString(3,eventGroup);
					rset=pstmt.executeQuery();

					while(rset.next()){
								resEventGroup=rset.getString("SHORT_DESC");
								resEventGroupCode=rset.getString("EVENT_GROUP");
								count=count+1;
					}
					if (count==1){ 
								out.println("<script>");								out.println("parent.frames[1].frames[2].document.forms[0].event_group1.value='"+resEventGroup+"'");
								out.println("parent.frames[1].frames[2].document.forms[0].event_group.value='"+resEventGroupCode+"'");
								out.println("parent.messageFrame.location.href='../../eCommon/jsp/error.jsp' ");
								out.println("</script>");
					 }
					 if (count>1 || count==0){%>
 						<script language=javascript>
							//alert('inside');
							parent.frames[1].frames[2].document.forms[0].event_group_but.disabled=true;
							callfunction();
						</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



					<%}
				if (rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
			}catch(Exception e){
							//out.println("Error Raise"+e);//common-icn-0181
							e.printStackTrace();//COMMON-ICN-0181
			}finally{
					
						if (con!=null) ConnectionManager.returnConnection(con,request);
					}
		%>
	</body>
	</html>

