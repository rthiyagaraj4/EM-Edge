<!DOCTYPE html>
<%@page import="java.sql.*,java.util.*, eCA.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8"%>
 <%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
		
	request.setCharacterEncoding("UTF-8");
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get( "SEARCH" ) ;

	Connection con = null;
	Connection conn = null;
	PreparedStatement stmt=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	ResultSet rst=null;

	String login_user = (String) session.getValue("login_user");
	String digital_content="";
	String userName ="";
	String password ="";
	String url ="";

	try{
		
		conn =  ConnectionManager.getConnection(request);

		String log_creds =" select userName,password,url from demo_image_appl_dtl ";
		
		pstmt = conn.prepareStatement(log_creds);
		rst = pstmt.executeQuery();
		 
		 
		
		while(rst.next())
		{
			userName = rst.getString("userName");	
			password = rst.getString("password");	
			url = rst.getString("url");	
		}
		if(rst!=null) rst.close();
		if(pstmt!=null)pstmt.close();

		 
		// String userName = "ibaehis";
		// String password = "ibaehis";
		// String url = "jdbc:mysql://indbgl-w00345/ehis";
		 Class.forName ("com.mysql.jdbc.Driver").newInstance ();
		 con = DriverManager.getConnection (url, userName, password);
	
		
		 String digitalNote = "select Col2 digital_content from Digital_Note where Col1= ? " ;

		 stmt = con.prepareStatement(digitalNote);
		 stmt.setString(1,login_user);
		 rs = stmt.executeQuery();

		 while(rs.next())
		 {
			digital_content = rs.getString("digital_content");	
		 }

		 out.println("parent.RecClinicalNotesSecDetailsFrame.RTEditor0.focus();");
		 out.println("parent.RecClinicalNotesSecDetailsFrame.RTEditor0.document.execCommand('paste','','"+digital_content+"' );");
		 if(rs!=null) rs.close();
		 if(stmt!=null)stmt.close();
	
	}
	catch(Exception e)
	{
		 e.printStackTrace();
		// out.println("Exception caught in RecClinicalNotesDigitalNoteIntermediate.jsp " + e);//COMMON-ICN-0181

	}
	finally 
	{
			
		 ConnectionManager.returnConnection(conn,request);
		
		if(con!=null)
		{
			con.close();
		}
	}









%>
