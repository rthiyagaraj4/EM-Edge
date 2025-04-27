<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> <html>
<head>
    <%String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");
	 %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
  
	 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	 	<script language="javascript" src="../../eCommon/js/common.js"></script>

</head>

<body class='message' onKeyDown='lockKey()'>
<%
		Connection con = ConnectionManager.getConnection(request);
        PreparedStatement pstmt = null;
		ResultSet rset = null;
       try 
		{
		
		String scheme = request.getParameter("scheme")==null?"":request.getParameter("scheme");

        String code = request.getParameter("code")==null?"":request.getParameter("code");
        
		String objName = request.getParameter("objName")==null?"":request.getParameter("objName");
		
		String desc = "";
		String sql = "";
		// MR_ICD_CODE removed and MR_TERM_CODE replaced and scheme replaced from 1 as ICD10 and 2 as ICD9CM for IN032171 by Kamakshi N on 09.05.2012 
		if (scheme.equals("ICD10"))
		{
			//sql = "SELECT SHORT_DESC,LONG_DESC FROM MR_ICD_CODE WHERE DIAG_CODE=?";
			sql = "SELECT SHORT_DESC,LONG_DESC,term_set_id FROM MR_TERM_CODE where TERM_CODE =? ";
		}
			else if (scheme.equals("ICD9CM"))
		{
			//sql = "SELECT SHORT_DESC,LONG_DESC FROM MR_ICD_CODE WHERE DIAG_CODE=?  AND RECORD_TYPE='D'";
			sql = "SELECT SHORT_DESC,LONG_DESC,term_set_id FROM MR_TERM_CODE where TERM_CODE =? and DIAGNOSIS_YN = 'Y' ";
		}
		if(rset != null)rset.close();
		if(pstmt != null)pstmt.close();
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,code);
		rset = pstmt.executeQuery();
		if(rset!=null && rset.next())
		 {
				desc = rset.getString("SHORT_DESC");
				
		%>
		<script>
	    var temp ="<%=desc%>";
		
		eval("parent.frames[2].document.forms[0].<%=objName%>").value=temp;	
		</script>
		<%
		   }
		    else
		{%>
			   <script>
//		    var str = getMessage("NO_RECORD_FOUND_FOR_CRITERIA");
			var str = getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common");
		    alert(str);
	   		  </script>
					<%}


			//end of else part
		}
		catch(Exception e)
			{out.println(e.toString());}
  		finally {
					try
			{
					if(rset != null)rset.close();
					if(pstmt != null)pstmt.close();
			}
			catch(Exception e)
			{}
			  ConnectionManager.returnConnection(con,request);
				}
%>


