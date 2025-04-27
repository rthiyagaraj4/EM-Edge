<!DOCTYPE html>
<!--
CRF Reference No     :  ML-MMOH-CRF-1959
Detected Release  No      :  SEPTEMBER 2023 Release 
File prepared by          :  SANTHOSH KUMAR N
File prepared date        :  20-07-2023
Purpose of the Change   :  As a MR user, In MR Module, I should be able to have a new function Receive BHT where the discharged records of all patient types can be changed to overdue, Delivered, returned or received.
Script Applicable for   :  Beta/Production/Both(Beta and Production)  - Applicable to All ML Sites    
-->
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
	<%
		Connection con		=  null;
		ResultSet rs 		= null;
		PreparedStatement pstmt = null;
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String frame_name="";
	

	%>
	<html> 
<%
String sStyle	= 
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
    <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	<BODY class='Message' onKeyDown = 'lockKey()'>
	<%
	try{
			con					= ConnectionManager.getConnection(request); 
			String shortDesc		    = "";
			String locn_type 				= "";
			String encounterType = request.getParameter("encounterType");
			String locTypeCode = encounterType.equals("EM")?"'C'":encounterType.equals("DC")?"'N'":encounterType.equals("OP")?"'C','E'":encounterType.equals("IP")?"'N'":"";
			
			StringBuffer sqlBuf  = new StringBuffer();

			sqlBuf.append("select locn_type, am_get_desc.am_care_locn_type(locn_type,'" + locale
				+ "',2) short_desc, CARE_LOCN_TYPE_IND, to_char(sysdate,'dd/mm/yyyy') sys_date from am_care_locn_type where SYS_USER_DEF_IND='S' and locn_type in ("+locTypeCode+") order by short_desc");
			pstmt   = con.prepareStatement(sqlBuf.toString());
			rs		 = pstmt.executeQuery();
			while(rs!=null && rs.next())
			{	
			locn_type = rs.getString("CARE_LOCN_TYPE_IND");
			shortDesc = rs.getString("short_desc");
	%>
		<script>
			//var opt		=   parent.frames[1].document.forms[0].document.createElement("OPTION");
			var opt = parent.frames[1].document.createElement("OPTION");
			opt.text	= "<%=shortDesc%>";
			opt.value	= "<%=locn_type%>";
			parent.frames[1].document.forms[0].locationType.add(opt); 
		</script>	
	<%	
			} //End of while		 
			if(rs!=null) { rs.close(); rs = null; }   
			if(pstmt!=null) { pstmt.close(); pstmt = null; }  
		 
	   }catch(Exception e)
       { e.toString();   }
	   finally {
				   ConnectionManager.returnConnection(con,request);  
			    }
	%>
	</body>    
	</html>	 

