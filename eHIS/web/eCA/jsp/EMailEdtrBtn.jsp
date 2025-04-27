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
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
			<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
			<script language="Javascript" src="../../eCommon/js/common.js"></script>
			<script language="Javascript" src="../../eCA/js/EMail.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
			
 	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	 <form name ="editorButtonForm">
<%
	Connection con = null;
	PreparedStatement pstmt = null;	
	ResultSet	rs = null;
	String module_id ="",report_id="",patient_id="",encounter_id="";
	String beanKey = "";
	String editor_content="";
	String mailToType = "";
	String regdMailerID = "";
	Clob body_template_text=null;
	eCA.EmailRepBodyTxtBean CA_EmailRepBodyTxtBean=null;

	java.util.Properties p = (java.util.Properties) session.getValue("jdbc");
	String locale = (String) p.getProperty("LOCALE") == null ? "" : (String) p.getProperty("LOCALE");
	String facility_id = (String) session.getValue("facility_id") == null ? "" : (String) session.getValue("facility_id");

	try{ 
		patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		encounter_id=request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		mailToType=request.getParameter("mailToType")==null?"":request.getParameter("mailToType");
		regdMailerID=request.getParameter("to_id")==null?"":request.getParameter("to_id");
		beanKey=request.getParameter("beanKey")==null?"":request.getParameter("beanKey");
		CA_EmailRepBodyTxtBean = (eCA.EmailRepBodyTxtBean)getObjectFromBean(beanKey,"eCA.EmailRepBodyTxtBean",session);
//		CA_EmailRepBodyTxtBean.clearBean();
		module_id=request.getParameter("module_id")==null?"":request.getParameter("module_id");
		report_id=request.getParameter("report_id")==null?"":request.getParameter("report_id");

/*		out.println("<script>");
		out.println("alert('module_id -"+module_id+"-');");
		out.println("alert('report_id -"+report_id+"-');");
		out.println("alert('mailToType -"+mailToType+"-');");
		out.println("alert('patient_id -"+patient_id+"-');");
		out.println("alert('encounter_id -"+encounter_id+"-');");
		out.println("alert('facility_id -"+facility_id+"-');");
		out.println("alert('locale -"+locale+"-');");
		out.println("</script>");*/

//		out.println("<script>alert('--"+regdMailerID+"--');");
	//	out.println("</script>");

		if(!module_id.equals("") && !report_id.equals(""))
		{
			con = ConnectionManager.getConnection(request);	

			pstmt = con.prepareStatement("select SM_GET_MAIL_BODY(?,?,?,?,?,?,?,'','',?) email_text FROM DUAL");
			pstmt.setString(1,module_id);
			pstmt.setString(2,report_id);
			pstmt.setString(3,mailToType);
			pstmt.setString(4,patient_id);
			pstmt.setString(5,encounter_id);
			pstmt.setString(6,facility_id);
			pstmt.setString(7,locale);
			pstmt.setString(8,regdMailerID);

			rs = pstmt.executeQuery();
			while (rs !=null && rs.next())
			{				
				body_template_text = (java.sql.Clob)rs.getClob("email_text");
				if(body_template_text != null && body_template_text.length() > 0)
					editor_content = body_template_text.getSubString(1,( (int)body_template_text.length() ));
			}
		}
		CA_EmailRepBodyTxtBean.setEditorContent(editor_content);	
		%>
		<table border="0" cellpadding="3" cellspacing="0" width="100%" id='test'>
			<!-- <tr>
				<td><jsp:include page="EditorButton.jsp" flush="true"/></td>
			</tr> -->
			<tr>
		
				<td colspan="3" class='fields'>
					<textarea rows="0" cols="25" name="RTEText" style="visibility:hidden"><%=editor_content%></textarea>
				</td>
			</tr>
			
			<Script>setEditorTemplate();</script>
 		</table>
<%
	putObjectInBean(beanKey,CA_EmailRepBodyTxtBean,session);	
	}catch(Exception e){
		
		e.printStackTrace();
	}finally{
		if(rs!=null)
			rs.close();
		if(pstmt!=null)
			pstmt.close();		
		if(con!=null) ConnectionManager.returnConnection(con,request);		
	}	
%>
		</form>
	</body>
</html>

