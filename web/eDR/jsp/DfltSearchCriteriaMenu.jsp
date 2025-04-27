<!DOCTYPE html>
<!--
	Developed By       :  P.Sudhakaran
	Developed on   	   :  10/12/2001
	Module Name 	   :  /eCIS
	Function Name	   :  Default Search Criteria
-->
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<!doctype html public "-W3CDTD HTML 4.0 TransitionalEN">

<html>
<head>
<title><fmt:message key="eDR.DefaultSearchCriteria.label" bundle="${dr_labels}"/></title>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<script language='javascript' src='../../eDR/js/DefaultSearchCriteria.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;

	String url		= "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params	= request.getQueryString() ;
	String source	= url + params ;
	
	String str = "";
	
	String kk			= request.getParameter("mode");
	String p_mode		= request.getParameter("p_mode");
	String patient_id	= request.getParameter("patient_id");
	String ch			= request.getParameter("ch");
	String record		= request.getParameter("record");

	if(kk == null) kk = "";
	if(p_mode == null) p_mode = "";
	if(patient_id == null) patient_id = "";
	if(ch == null) ch = "";
	if(record == null) record = "";
	
	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();

		if(!(kk.equals("first"))) 
		{
			
	
			int p_count = 0;

			str = "SELECT count(*) total FROM dr_param";
			rs  = stmt.executeQuery(str);
			while(rs.next())
			{
				p_count = rs.getInt("total");	
			}

			if(p_count == 0)
			{
				%>
 				<script>
					var errortext = getMessage('DR_PARAM_NOT_AVAILABLE','DR');
					alert(errortext);
					parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp';
				</script>
				<%
			}

			%>
			<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder='0' scrolling='no' noresize frameborder='0' style='height:46%;width:100vw'></iframe>
				<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eDR/jsp/DefaultSearchCriteria.jsp' frameborder='0' scrolling='no'>
				<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='no' frameborder='0' noresize frameborder='0' style='height:100vh;width:100vw'></iframe>
			
			<%
		}
		else if(kk.equals("first"))
		{
			%>
			<iframe name='modifyform1' id='modifyform1' src ='../../eDR/jsp/EnterDuplicateModify.jsp?p_mode=add+&function_name=modify&patient_id=<%=patient_id%>&ch=<%=ch%>' frameborder='0' scrolling='yes' noresize></iframe>
				<iframe name='mess1' id='mess1' src='../../eDR/jsp/EnterDuplicateAddModDel.jsp?p_mode=add' frameborder='0' scrolling='no' noresize></iframe>
				<iframe name='addmodify1' id='addmodify1' src='../../eDR/jsp/EnterDuplicatesAddModifyPatId.jsp?p_mode=add+&function_name=insert&ch=<%=record%>' frameborder='0' scrolling='yes' noresize></iframe>
			
			<% 
		} 
		else if(p_mode.equals("Delete"))
		{
			%>
			<iframe name='modifyform7' id='modifyform7' src='../../eDR/jsp/EnterDuplicateModify.jsp?p_mode=add+&function_name=delete' frameborder='0' scrolling='yes' noresize></iframe>
				<iframe name='mess' id='mess' src='../../eDR/jsp/EnterDuplicateAddModDel.jsp?p_mode=add' frameborder='0' scrolling='no' noresize></iframe>
				<iframe name='addmodify' id='addmodify' src='../../eDR/jsp/EnterDuplicatesAddModifyPatId.jsp?p_mode=add+&function_name=insert' frameborder='0' scrolling='yes' noresize></iframe>
			
			<%
		}

		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
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

