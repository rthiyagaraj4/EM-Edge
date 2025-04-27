<!DOCTYPE html>
<%@ page import= "java.util.*" %>
<%@ page import="java.sql.Connection,java.util.HashMap,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHQueryRender,eXH.XHDBAdapter" %>
<%@ page import="eXH.XHUtil"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	String isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM"));	

	if(isDebugYN.equals("Y"))
		System.out.println(" - - -  Inside EM_Card_Reader.jsp  - - - ");	
	
	String button_width = "100";
	String button_height = "100";
	String button_label = "Read";
	//session.getServletContext().getRealPath("/");
%>
<html>
<head>
<title>Card Reader </title>
</head>
<body onUnLoad='window.returnValue="close"'>
	<br>
		<table align="center" border="4" cellpadding="1" cellspacing="1" style="width: 700px;">
			<tr>
				<td>
					<applet code="PatientPhotoApplet.class"
						codebase="../CardReader/" archive="CardReaderApplet.jar" width="700"
						height="325">
						<PARAM name="button_width" value="<%=button_width%>" />
						<PARAM name="button_height" value="<%=button_height%>" />
						<PARAM name="button_label" value="<%=button_label%>" />						
						<param name="separate_jvm" value="true" />
						Sorry, Your browser does not support Java applet!
					</applet>
				</td>
			</tr>
		</table>		
</body>
</html>
