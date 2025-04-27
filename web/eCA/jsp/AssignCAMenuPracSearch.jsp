<!DOCTYPE html>
<%@page  language="java" import="java.sql.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		
		<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>
		<script src="../../eCA/js/AssignCAMenu.js" language="javascript"></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
</head>
<body  class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
		request.setCharacterEncoding("UTF-8");
		Connection con=null;
		String pract=request.getParameter("pract")==null?"":request.getParameter("pract");	
		//out.println("<script>alert('Pract="+pract+"')</script>");
		String practId="";
		String practDesc="";
		int count=0;
		try
		{
			
			PreparedStatement pstmt=null;
			ResultSet rset=null;
			con=ConnectionManager.getConnection(request);
			if (!pract.equals(""))
			{
					pract=pract+"%";
			}
					StringBuffer sql= new StringBuffer();
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append("select  PRACTITIONER_ID,SHORT_NAME ");
					sql.append("from AM_PRACTITIONER where ");
					sql.append("EFF_STATUS ='E'  AND ");
					sql.append("upper(SHORT_NAME) like upper(?)");  
					pstmt=con.prepareStatement(sql.toString());
					pstmt.setString(1,pract);
					rset=pstmt.executeQuery();
					while(rset.next())
					{	
					   practId=rset.getString("PRACTITIONER_ID");
                       practDesc=rset.getString("SHORT_NAME");
					   count=count+1;
					}

		if (count==1)
		{ 
			out.println("<script>");
			out.println("parent.frames[1].document.forms[0].practitioner_id2.value='"+practDesc+"'");
			out.println("parent.frames[1].document.forms[0].practitioner_id1.value='"+practId+"'");
			out.println("parent.frames[2].location.href='../../eCommon/jsp/error.jsp' ");
			out.println("</script>");
		}

		if(count>1 || count==0){	%>
				<script language=javascript>
				parent.frames[1].document.forms[0].prac_desc_search.disabled=true;
				callfunction1();
				</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



  <% 
		}
	if (rset!=null) rset.close();
	if(pstmt!=null) pstmt.close();
}
catch(Exception ex)
{
		//out.println("Exception in try of AssignCAMenuPracSearch.jsp"+ex.toString());//COMMON-ICN-0181
           ex.printStackTrace();//COMMON-ICN-0181
}
finally
{
		
		if (con!=null) ConnectionManager.returnConnection(con,request);
}
%>
</body>
</html>

