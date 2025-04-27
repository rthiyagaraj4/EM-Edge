<!DOCTYPE html>
<%@page  language="java" import="java.sql.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
			<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>
			<script src='../../eCA/js/FlowSheet.js' language='javascript'></script>
			<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
			<script language='javascript' src='../../eCommon/js/common.js'></script>
			</head>

	<body   class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	request.setCharacterEncoding("UTF-8");
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	
	java.util.Properties p = (java.util.Properties) session.getValue("jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String eventItem=request.getParameter("eventItem")==null?"":request.getParameter("eventItem");
	String hist_type=request.getParameter("history_type");
	String resEventItem	="";
	int count=0;
	try{
			con=ConnectionManager.getConnection(request);
			if (!eventItem.equals("")){
				eventItem = eventItem+"%";
			}
				
			//String sql= " select EVENT_CODE ,long_desc SHORT_DESC from CR_CLIN_EVENT_MAST where hist_rec_type= ? and upper(SHORT_DESC) like upper(?) ";

			String sql= " select EVENT_CODE ,long_desc SHORT_DESC from CR_CLN_EVT_MST_LANG_VW where hist_rec_type= ? and upper(SHORT_DESC) like upper(?) and language_id = ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,hist_type);
			pstmt.setString(2,eventItem);
			pstmt.setString(3,locale);
			rset=pstmt.executeQuery();

			while(rset.next())
			{
				resEventItem = rset.getString("SHORT_DESC");
				count++;
			}

			if (count == 1)
			{%>
				<script language='javascript'>
					if(top.content!= null)
					{	
						top.content.workAreaFrame.frames[0].document.forms[0].event_item.value='<%=resEventItem%>';
						top.content.messageFrame.location.href='../../eCommon/jsp/error.jsp' ;
					}
					else
					{	
						parent.criteria_f0.criteria_f1.document.forms[0].event_item.value='<%=resEventItem%>'	;					
						parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp' ;
					}
				</script>
					
			<% }
	
			if (count>1 || count==0)
			{%>
			<script language=javascript>
					if(top.content!=null)
	                {
						top.content.workAreaFrame.frames[0].document.forms[0].event_item_but.disabled=true;
					}
					else
					{								
						parent.criteria_f0.criteria_f1.document.forms[0].event_item_but.disabled=true;
					}
						callfunctionitemsearch();
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

