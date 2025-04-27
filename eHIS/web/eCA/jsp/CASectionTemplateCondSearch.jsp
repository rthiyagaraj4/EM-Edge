<!DOCTYPE html>
<%@page  language="java" import="java.sql.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>
<script language="javascript" src="../js/SectionTemplate.js"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
</head>
<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	request.setCharacterEncoding("UTF-8");
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	
	String conditionid=request.getParameter("conditionid")==null?"":request.getParameter("conditionid");
		
	String resConditionId="";
	String resConditionDesc="";
	int count=0;
	try{
			con=ConnectionManager.getConnection(request);

				if (!conditionid.equals("")){
					conditionid=conditionid+"%";
				}


			String sql="SELECT AGE_GROUP_CODE,SHORT_DESC FROM AM_AGE_GROUP where EFF_STATUS='E' and  upper(SHORT_DESC) like upper(?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,conditionid);
			rset=pstmt.executeQuery();

			while(rset.next()){
						resConditionId=rset.getString("AGE_GROUP_CODE");
						resConditionDesc=rset.getString("SHORT_DESC");
						count=count+1;
			}

			if (count==1){ 
						out.println("<script>");
						out.println("parent.f_query_add_mod.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.age_group_code_desc.value='"+resConditionDesc+"'");
						out.println("parent.f_query_add_mod.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.age_group_code.value='"+resConditionId+"'");
						out.println("parent.messageFrame.location.href='../../eCommon/jsp/error.jsp' ");
						out.println("</script>");
			 }
	
			if (count>1 || count==0){ 	%>
				<script language=javascript>
						parent.f_query_add_mod.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.searchCondition.disabled=true;
						callfunction();
				</script>
			<% }
		if (rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();
	}
	catch(Exception e)
	{
		//out.println("Exception caught in CASectionTemplateCondSearch-->"+e);
		e.printStackTrace();
	}
	finally
	{
		if (con!=null) 
			ConnectionManager.returnConnection(con,request);
	}
%>
</body>

