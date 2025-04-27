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
		
		
		String specId=request.getParameter("specId")==null?"":request.getParameter("specId");	
		
		String splId="";
		String splDesc="";
		int count=0;
		
		try
		{
			
			PreparedStatement pstmt=null;
			ResultSet rset=null;
			con=ConnectionManager.getConnection(request);
		    if (!specId.equals(""))
			{
				specId=specId+"%";
			}
		
			StringBuffer sql= new StringBuffer();
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append("select SPECIALITY_CODE,SHORT_DESC from ");
			sql.append("AM_SPECIALITY where EFF_STATUS ='E' AND ");
			sql.append("upper(SHORT_DESC) like upper(?)");  
		    pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1,specId);
  			rset=pstmt.executeQuery();
			
			while(rset.next())
			{	
					splId=rset.getString("SPECIALITY_CODE");
					splDesc=rset.getString("SHORT_DESC");
					count=count+1;
			}   
      
		  if (count==1){
		      out.println("<script>");
 			  out.println("parent.frames[1].document.forms[0].speciality_code1.value='"+splDesc+"'");
			  out.println("parent.frames[1].document.forms[0].speciality_code2.value='"+splId+"'");
  			  out.println("parent.frames[2].location.href='../../eCommon/jsp/error.jsp' ");
			  out.println("</script>");
		 } 

		if(count>1 || count==0){	%>
		<script language=javascript>
			parent.frames[1].document.forms[0].service_desc_search.disabled=true;
			callfunction();
		</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



        <% 	}
	if (rset!=null) rset.close();
	if(pstmt!=null) pstmt.close();
}
catch(Exception ex)
{
	//out.println("Exception in AssignCAMenuSpecSearch.jsp"+ex.toString());//COMMON-ICN-0181
	ex.printStackTrace();//COMMON-ICN-0181
}
finally
{
		
		if (con!=null) ConnectionManager.returnConnection(con,request);
}

%>
</body>
</html>

