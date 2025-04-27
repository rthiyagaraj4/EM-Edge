<!DOCTYPE html>
<%@  page contentType="text/html;charset=UTF-8"  import ="eCommon.Common.CommonBean"  %>
<% request.setCharacterEncoding("UTF-8"); %>


<%
//Checkstyle Violation commented by Munisekhar
//String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String params = request.getQueryString();
%>

			<FRAMESET ROWS='34%,*' border='0'>
				<FRAME name="MenuModify" id="MenuModify" frameborder="0" scrolling="no" noresize src="../../eDS/jsp/MenuModify.jsp?<%=params%>"></FRAME>
				<frameset cols="40%,*" >
					<frame name="MenuItemAdd" id="MenuItemAdd" frameborder="0" scrolling="no" noresize src="../../eDS/jsp/MenuItemAdd.jsp?<%=params%>"/>
					<frame name="MenuItemPopulate" id="MenuItemPopulate" frameborder="0" scrolling="no" noresize src="../../eDS/jsp/MenuItemPopulate.jsp?<%=params%>"/>
				</frameset>
 			</FRAMESET>


