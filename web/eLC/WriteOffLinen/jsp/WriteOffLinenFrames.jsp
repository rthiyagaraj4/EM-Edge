<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<script type="text/javascript">
<!--
	top.title='<%=request.getParameter("title")%>'
//-->
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<%
		String function_id = (String)request.getParameter("functionId");
		String flag = (String)request.getParameter("flag");
		//out.println("flag="+flag);
	%>
	<frameset cols="70%,*" border="4" border="2">
	<frame name="WriteOffLinen" id="WriteOffLinen" noresize="noresize" src=" <%=request.getContextPath()%>/WriteOffLinenAction.do?method=1&flag=<%=flag%>&vo.functionId=<%=function_id%>" /> 
	<% if(flag.equals("Laundry")){ %>
	<frame name="RHSFrame" id="RHSFrame" noresize="noresize" src=" <%=request.getContextPath()%>/eLC/core/jsp/RHSTabsMain.jsp" />
	<% }else{ %>
	<frame name="RHSFrame" id="RHSFrame" noresize="noresize" src=" <%=request.getContextPath()%>/eLC/core/jsp/RHSTabsMainWards.jsp" />
	<% }; %>
	</frameset>
	
</html>

