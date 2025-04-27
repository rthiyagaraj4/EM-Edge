<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<%@ page contentType="text/html;charset=UTF-8" %>
<HTML>
<HEAD>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<TITLE> New Document </TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
<%@ page import ="java.sql.*,webbeans.eCommon.*" %>
</HEAD>


		<%
			Connection con = ConnectionManager.getConnection();
			PreparedStatement pstmt = null ;
			ResultSet rset =null;
		try{
			String sql = "select nvl(FACILITY_LOGO,'') from sm_facility_param where facility_id = ?";
			pstmt = con.prepareStatement(sql); 
			pstmt.setString(1,(String) session.getAttribute( "facility_id" ));
			rset = pstmt.executeQuery() ;

			if(rset != null) {
				if(rset.next()){
					%>
						<BODY  onKeyDown = 'lockKey()' background = "../../eCommon/jsp/DisplayImages.jsp?param=facilityimage" style="margin:0px;background-repeat:no-repeat;background-position:center">
					<%
				}
					rset.close() ;
			}
			} catch(Exception e){
				e.printStackTrace();
			}
			finally{
				ConnectionManager.returnConnection(con);
				if(rset!=null)rset.close();
				if(pstmt!=null)pstmt.close();
			}

		%>
</BODY>
</HTML>

