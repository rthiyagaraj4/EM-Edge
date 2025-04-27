<!DOCTYPE html>
<%-- Mandatory declarations start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*,java.sql.*,java.io.*,java.net.*, eCA.* ,eOR.Common.*,eCommon.Common.*,webbeans.eCommon.*,javax.servlet.*" %> 
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
 
<html>
	<head>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
		<title><fmt:message key="eCA.Editor.label" bundle="${ca_labels}"/></title>
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
			<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
			<script language="Javascript" src="../../eCommon/js/common.js"></script>
			<script language="Javascript" src="../../eCA/js/SecTempOutputForm.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
			
 	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	 <form name ="editorButtonForm">
<%
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet	rs = null;
	String section ="",mode="insert";
	String editor_content="";
	Clob output_format=null;

	try{ 
		eCA.SecTempOutputFormBean CA_SecTempOutputFormBean = (eCA.SecTempOutputFormBean)getObjectFromBean("CA_SecTempOutputFormBean","eCA.SecTempOutputFormBean",session);
		CA_SecTempOutputFormBean.clearBean();
		section=request.getParameter("section");
		con = ConnectionManager.getConnection(request);	
		pstmt	=	con.prepareStatement("select sec_hdg_code,output_format from ca_sec_output_form where sec_hdg_code =?");
		pstmt.setString(1,section);
		rs = pstmt.executeQuery();
		if(rs == null) mode="insert";
		while (rs !=null && rs.next()){
			mode="modify";
			output_format=(java.sql.Clob)rs.getClob("output_format");
			if(output_format!=null && output_format.length() > 0)
				editor_content = output_format.getSubString(1,( (int)output_format.length() ));

		}
		
		CA_SecTempOutputFormBean.setEditorContent(editor_content);	
%>
		
			<table border="0" cellpadding="3" cellspacing="0" width="100%" id='test'>
			<tr>
				<td><jsp:include page="EditorButton.jsp" flush="true"/></td>
			</tr>
			<tr>
				<td colspan="3" class='fields'>
					<textarea rows="0" cols="25" name="RTEText" id="RTEText" style="visibility:hidden"><%=editor_content%></textarea>
				</td>
			</tr>
 			<input type="hidden" name="mode" id="mode" value="<%=mode%>">
			
			<Script>setTimeout("setEditorTemplate()",200);</script>
 		</table>
<%
	putObjectInBean("CA_SecTempOutputFormBean",CA_SecTempOutputFormBean,session);	
	}catch(Exception e){
		
		e.printStackTrace();
	}finally{
		if(rs!=null)
			rs.close();
		if(pstmt!=null)
			pstmt.close();
		if(con!=null)
			con.close();

		
	}	
%>
		</form>
	</body>
</html>

