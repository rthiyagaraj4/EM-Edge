<!DOCTYPE html>
<%@page  language="java" import="java.sql.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>
<script language=javascript src='../../eCA/js/AssignChartSumm.js'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src="../../eCommon/js/common.js"			language="javascript"></script>
</head>
<body  class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<% 	request.setCharacterEncoding("UTF-8");	%>
<%
		Connection con=null;
		
		String pract=request.getParameter("pract")==null?"":request.getParameter("pract");	
		//out.println("Pract="+pract);
		String practId="";
		String practDesc="";
		int count=0;
		try
		{
				PreparedStatement pstmt=null;
				ResultSet rset=null;
				con=ConnectionManager.getConnection(request);
					if (!pract.equals("")){
						pract=pract+"%";
						}
		StringBuffer sql= new StringBuffer();
		if(sql.length() > 0) sql.delete(0,sql.length());
		 sql.append("select  PRACTITIONER_ID,SHORT_NAME from ");
		 sql.append("AM_PRACTITIONER where EFF_STATUS ='E'  AND "); sql.append("upper(SHORT_NAME) like upper(?)");  
					pstmt=con.prepareStatement(sql.toString());
					pstmt.setString(1,pract);
					rset=pstmt.executeQuery();
					while(rset.next())
					{	
					   practId=rset.getString("PRACTITIONER_ID");
                       practDesc=rset.getString("SHORT_NAME");
					   count=count+1;
					}
		//out.println("Tab Count="+count);
    if (count==1)
	{ 
		out.println("<script>");
		out.println("parent.frames[1].document.forms[0].pctr.value='"+practDesc+"'");
		out.println("parent.frames[1].document.forms[0].practitioner.value='"+practId+"'");
		out.println("parent.frames[1].document.forms[0].flag.value='true' ");
		out.println("parent.frames[3].location.href='../../eCommon/jsp/error.jsp' ");

				out.println("</script>");
	}
   if(count>1 || count==0)
		{
			%>
		<script language=javascript>
		parent.frames[1].document.forms[0].searchsp2.disabled=true;
		parent.frames[1].document.forms[0].flag.value='true'
			callfunction();
		</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



        <% 
			
     	}//if
		if (rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();
		}
		catch(Exception ex)
		{
				//out.println("Exception in AssignChartSummSearch.jsp"+ex.toString());//COMMON-ICN-0181
				ex.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
					
			if (con!=null) ConnectionManager.returnConnection(con,request);
		 }
%>
</body>
</html>

