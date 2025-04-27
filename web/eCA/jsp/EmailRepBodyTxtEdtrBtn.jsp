<!DOCTYPE html>
<%
/*
------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
------------------------------------------------------------------------------------------------------------------------------
?             100            ?           	created	
17/04/2014    IN047784	     Nijitha S     	ML-BRU-SCF-1282

------------------------------------------------------------------------------------------------------------------------------
*/
%>
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
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
			<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
			<script language="Javascript" src="../../eCommon/js/common.js"></script>
			<script language="Javascript" src="../../eCA/js/EmailRepBodyTxt.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
			
 	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	 <form name ="editorButtonForm">
<%
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet	rs = null;
	String module_id ="",report_id="",body_text_ref="",mode;
	String editor_content="";
	Clob body_template_text=null;

	try{ 
		eCA.EmailRepBodyTxtBean CA_EmailRepBodyTxtBean = (eCA.EmailRepBodyTxtBean)getObjectFromBean("CA_EmailRepBodyTxtBean","eCA.EmailRepBodyTxtBean",session);
		CA_EmailRepBodyTxtBean.clearBean();
		module_id=request.getParameter("module_id")==null?"":request.getParameter("module_id");
		report_id=request.getParameter("report_id")==null?"":request.getParameter("report_id");
		body_text_ref=request.getParameter("body_text_ref")==null?"":request.getParameter("body_text_ref");
		mode=request.getParameter("mode")==null?"":request.getParameter("mode");
		
		if(mode.equals("modify")){
			con = ConnectionManager.getConnection(request);	
			pstmt	=	con.prepareStatement("select BODY_TEMPLATE_TEXT	from SM_REPORT_MAIL_BODY where module_id =? and report_id=? and body_text_ref=?");
			pstmt.setString(1,module_id);
			pstmt.setString(2,report_id);
			pstmt.setString(3,body_text_ref);
			rs = pstmt.executeQuery();
			while (rs !=null && rs.next()){
				
				body_template_text=(java.sql.Clob)rs.getClob("BODY_TEMPLATE_TEXT");
				if(body_template_text!=null && body_template_text.length() > 0){
					editor_content = body_template_text.getSubString(1,( (int)body_template_text.length() ));
				}
			}
		}
		CA_EmailRepBodyTxtBean.setEditorContent(editor_content);	
%>
		
			<table border="0" cellpadding="3" cellspacing="0" width="100%" id='test'>
			<tr>
				<td><jsp:include page="EditorButton.jsp" flush="true"/></td>
			</tr>
			<tr>
				<td colspan="3" class='fields'>
					<textarea rows="0" cols="25" name="RTEText" style="visibility:hidden"><%=editor_content%></textarea>
				</td>
			</tr>
			<!--  IN047784 Start -->
			<!--<Script>setEditorTemplate();</script> -->			
			<Script>setTimeout(function() { setEditorTemplate(); }, 500);</script>
			<!--  IN047784 End. -->
 		</table>
<%
	putObjectInBean("CA_EmailRepBodyTxtBean",CA_EmailRepBodyTxtBean,session);	
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

