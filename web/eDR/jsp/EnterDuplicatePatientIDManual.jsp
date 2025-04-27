<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eDR.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
	request.setCharacterEncoding("UTF-8");
	String p_mode = request.getParameter("p_mode");
	
	String p_function_name = request.getParameter("function_name");
	if(p_function_name==null) p_function_name="";
   String flag=request.getParameter("flag");
if(flag==null) flag="";
%>
<html>
<script language='javascript' src='../../eCommon/js/common.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<%
	if (p_mode.equals("addition"))
	{
%>
	<iframe name='add' id='add' src='../../eDR/jsp/EnterDuplicatesAddPatId.jsp?function_name=insert &flag=create'  scrolling=no noresize style='height:100vh;width:40vw' frameborder='0'></iframe>
	<iframe name='mess' id='mess' src='../../eDR/jsp/EnterDuplicateAddModDel.jsp?p_mode=add'  scrolling=no noresize style='height:100vh;width:0vw' frameborder='0'></iframe>
	<iframe name='addmodify' id='addmodify' src='../../eDR/jsp/EnterDuplicatesAddModifyPatId.jsp?check=Show&p_mode=add+&function_name=insert'  scrolling=yes noresize style='height:100vh;width:55vw' frameborder='0'></iframe>
	
<%
	}
	else if (p_mode.equals("modify"))
	{
%>		<iframe name='criteria' id='criteria' src='../../eDR/jsp/EnterDuplicateQueryCriteria.jsp?function_name=modify' scrolling=no noresize style='height:15vh;width:100vw' frameborder='0'></iframe>
		<iframe name='blanks' id='blanks' src='../../eCommon/html/blank.html'  scrolling=no noresize style='height:85vh;width:100vw' frameborder='0'></iframe>
	   <iframe name='mess' id='mess' src='../../eDR/jsp/EnterDuplicateAddModDel.jsp?p_mode=add'  scrolling=no noresize style='height:0vh;width:100vw' frameborder='0'></iframe>
		
<%
	}
	else if (p_mode.equals("delete"))
	{
%>
	<iframe name='modifyform' id='modifyform' src='../../eDR/jsp/EnterDuplicateModify.jsp?p_mode=add+&function_name=delete' scrolling=yes noresize style='height:100vh;width:35vw' frameborder='0'></iframe>
	<iframe name='mess' id='mess' src='../../eDR/jsp/EnterDuplicateAddModDel.jsp?p_mode=add' scrolling=no noresize style='height:100vh; width:0vw;' frameborder='0'></iframe>
	<iframe name='addmodify' id='addmodify' src='../../eDR/jsp/EnterDuplicatesAddModifyPatId.jsp?p_mode=add+&function_name=insert' scrolling=yes noresize style='height:100vh;width:55vw' frameborder='0'></iframe>
	
 	<%
	}
	%>
</html>

