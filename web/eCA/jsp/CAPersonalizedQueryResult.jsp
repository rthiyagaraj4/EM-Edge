<!DOCTYPE html>
<%@page import="java.sql.*,java.io.*,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
	
	<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCA/js/CAPersonalizedHomePage.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
</HEAD>
<BODY OnMouseDown="CodeArrest()"  onKeyDown="lockKey()">
	<form name="form1" id="form1"> 
<%

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	Connection con = null;	
	PreparedStatement ps = null;
	ResultSet rs = null;
try
{
	ConnectionManager connection = new ConnectionManager();
	con = connection.getConnection(request);
	String string = request.getParameter("pract_id") ;
	String name = request.getParameter("pract_name");
	String selFunVal = "";
	StringBuffer sql = new StringBuffer();
	selFunVal = request.getParameter("selFunVal")==null ? "" : request.getParameter("selFunVal");
		if(string != "*ALL" && name !="ALL")
		 {
			name = name + "%";
		 }

		if (selFunVal.equals("Pract")){
	
		if(sql.length() > 0) sql.delete(0,sql.length());
	    sql.append("SELECT PRACTITIONER_ID, PRACTITIONER_NAME  FROM ");
	    sql.append("AM_PRACTITIONER WHERE upper(PRACT_TYPE)=upper(?) AND "); sql.append("EFF_STATUS=? and upper(PRACTITIONER_NAME) like upper(?)");
			
		}
	  else if (selFunVal.equals("Desk")){

	    if(sql.length() > 0) sql.delete(0,sql.length());
	    sql.append("SELECT DESKTOP_SUMMARY_ID, DESKTOP_SUMMARY_NAME  FROM ");
	    sql.append("SM_DESKTOP_SUM_HDR WHERE DESKTOP_SUMMARY_TYPE = 'C' AND EFF_STATUS='E' and upper(DESKTOP_SUMMARY_NAME) LIKE upper(?)"); 
	  }
	  ps=con.prepareStatement(sql.toString());

	  if (selFunVal.equals("Pract")){
				
					ps.setString(1,string);
	                ps.setString(2,"E");
	                ps.setString(3,name);		
			}
	else  if (selFunVal.equals("Desk")){
	                ps.setString(1,name);		
			}

	rs = ps.executeQuery();
	int count = 0;			
	while(rs.next())	
		{
			count++;
		}
	if(rs != null)	 rs.close();
	
	//	if(count==0)
//		{
//		out.println("<script>parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp' </script>");
//		}
		if(count == 1)
		{
			rs = ps.executeQuery();
		  if (selFunVal.equals("Pract"))
		{
			while(rs.next())
		 {
			out.println("<script language = \"JavaScript\">");
			out.println("parent.frame3.document.personalizedPractLookUpForm.qry_sub.value='"+							rs.getString("PRACTITIONER_NAME")+"'" );
			out.println("parent.frame3.document.personalizedPractLookUpForm.hid_sub.value='"+							rs.getString("PRACTITIONER_ID")+"'" );
			out.println("parent.frame3.document.personalizedPractLookUpForm.flag.value='true' ");
			out.println("parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp' ");
			out.println("</script>");
		 }
		}
		 else if (selFunVal.equals("Desk"))
		{
			while(rs.next())
			{
				out.println("<script language = \"JavaScript\">");
			out.println("parent.frame3.document.personalizedPractLookUpForm.desk_sub.value='"+							rs.getString("DESKTOP_SUMMARY_NAME")+"'" );
			out.println("parent.frame3.document.personalizedPractLookUpForm.hid_sub1.value='"+							rs.getString("DESKTOP_SUMMARY_ID")+"'" );
			out.println("parent.frame3.document.personalizedPractLookUpForm.flag.value='true' ");
			out.println("parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp' ");
			out.println("</script>");
			}
		}

	  }
	
		if(count > 1 || count==0)
		{
%>
<script language ="JavaScript">
	var chkVal = "<%=selFunVal%>";
     if (chkVal == "Pract")
   {
	parent.frame3.document.personalizedPractLookUpForm.look_up.disabled=false;
	callfunction();
   }else if (chkVal == "Desk")
 {
	parent.frame3.document.personalizedPractLookUpForm.look_up1.disabled=false;
	callfunction1();
 }
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%
	}
}
catch(Exception e)
{
	//out.println(e);//COMMON-ICN-0181
        e.printStackTrace();//COMMON-ICN-0181
	try
	{
			con.rollback();
	}
	catch(Exception ee)
	{
	}
}
finally
{
	try
	{	
		if(rs != null)	 rs.close();
		if(ps != null)	 ps.close();
		if(con != null)ConnectionManager.returnConnection(con);	
			
	}
	catch(Exception ee)
	{
	}
	
}
%>
</form>
</BODY>
</HTML>

