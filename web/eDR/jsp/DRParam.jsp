<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<title><fmt:message key="eDR.DRParameter.label" bundle="${dr_labels}"/></title>
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<script language='javascript' src='../../eDR/js/DRParam.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<SCRIPT language='javascript' src='../../eCommon/js/DateUtils.js'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

<%
	Connection con			= null;
	PreparedStatement pstmt = null;	
	ResultSet rs  			= null;	

	try
	{
		con = ConnectionManager.getConnection(request);

		String url		= "../../eCommon/jsp/MstCodeToolbar.jsp?";
		String params	= request.getQueryString();
		String source	= url + params;	
	
		String str 		= "";		
		

		str   = " SELECT * FROM dr_param";		
		pstmt = con.prepareStatement(str);	
		rs    = pstmt.executeQuery();
		if(rs != null)
		{
			if(rs.next())
			{
				%>
				<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>'  scrolling=no noresize style='height:8vh;width:100vw'></iframe>
				<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eDR/jsp/DRParamAddModify.jsp' scrolling='no' style='height:80vh;width:100vw'></iframe>
				<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' scrolling='no'  noresize style='height:12vh;width:100vw'></iframe>
				
				<%	 
			}
			else
			{	
				%>
				<script>
					alert(getMessage('DR_PARAM_NOT_AVAILABLE','DR'));
					
				</script>
				<%
			}
		}

		if(rs != null)	rs.close();
		if(pstmt != null) pstmt.close();
		
	}
	catch(Exception e)
	{
		out.println("Exception e :"+e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
	%>
</html>

