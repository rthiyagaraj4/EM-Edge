<!DOCTYPE html>
<%@ page
	import="java.sql.*,java.util.*,java.text.*,webbeans.eCommon.*"
	contentType="text/html;charset=UTF-8"%>
<%
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	request.setCharacterEncoding("UTF-8");
	String locale = (String) session.getAttribute("LOCALE");
%>
<html>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<BODY class='Message' onKeyDown='lockKey()'>
	<%
		try {
			con = ConnectionManager.getConnection(request);
			String event_type = "";
			String applicationID = request.getParameter("applicationID");
			System.out.println("applicationID..."+applicationID);
			String query = "select event_type from xh_application_event_type where application_id = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, applicationID);
			rs = pstmt.executeQuery();
			while (rs != null && rs.next()) {
				event_type = rs.getString("event_type");
				System.out.println("event_type..."+event_type);
			%>
				<script>
					var opt		=   parent.frames[1].document.forms[0].document.createElement("OPTION");
					opt.text	= "<%=event_type%>";
					opt.value	= "<%=event_type%>";
					//alert(":parent.frames[1].document.forms[0]= "+parent.frames[1].document.forms[0].name)
					parent.frames[1].document.forms[0].notifyEvent.add(opt); 
				</script>	
			<%	
					} //End of while		 
					//System.err.println("While end================ ");
					if(rs!=null) { rs.close(); rs = null; }   
					if(pstmt!=null) { pstmt.close(); pstmt = null; }  
				 
			   }catch(Exception e) { 
				   e.toString();
			   }
			   finally {
					ConnectionManager.returnConnection(con,request);  
			   }
			%>
</body>
</html>

