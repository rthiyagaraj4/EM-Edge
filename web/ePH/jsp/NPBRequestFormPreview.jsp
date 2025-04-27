<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, ePH.* ,ePH.Common.*,eCommon.Common.*"%>
<%-- JSP Page specific attributes end --%>   
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
 
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link> <!-- To display the calendar --> 
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script Language="vbscript">
			Dim WSHShell
			Dim myHeader
			Dim myFooter
			Set WSHShell = CreateObject("WScript.Shell")
			'myHeader = WSHShell.RegRead("HKCU\Software\Microsoft\Internet Explorer\PageSetup\header")
			'myFooter = WSHShell.RegRead("HKCU\Software\Microsoft\Internet Explorer\PageSetup\footer")

			WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\header", "&b&d"
			WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\footer", "&bPage &p of &P"

			Sub ResetHeader()
				Dim WSHShell
				Set WSHShell = CreateObject("WScript.Shell")
				WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\header", myHeader
				WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\footer", myFooter
				WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\margin_left", "19.05"
				WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\margin_right", "19.05"
			End Sub

		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<style type='text/css'>
			ADDRESS{font-style: NORMAL;} 
			INPUT.TEXT_DISPLAY
			{
				background:white;  
				color: RED ;
				border-style: none;
			}
		</style>
		<title><fmt:message key="eOR.EditorPreview.label" bundle="${or_labels}"/></title>
    </head>
	<body onMouseDown="CodeArrest()" onblur="" onKeyDown="lockKey()" >
<%
		request.setCharacterEncoding("UTF-8");
		//String NPBReqFormText		= request.getParameter("NPBReqFormText");
		String NPBReqFormText="";
		String bean_id		= request.getParameter("bean_id");
		String bean_name		= request.getParameter("bean_name");
		String mode		= request.getParameter("mode")==null?"1":request.getParameter("mode");
		String calledFrom		= request.getParameter("calledFrom")==null?"":request.getParameter("calledFrom");
		String NPBReqNo		= request.getParameter("request_no")==null?"":request.getParameter("request_no");
		String NPBReqFormId		= request.getParameter("NPBReqFormId")==null?"":request.getParameter("NPBReqFormId");
		try{
			if ( bean_id == null || bean_id.equals( "" ) )
				return ;
			if(mode.equals("1") || calledFrom.equals("REQUEST")){
				NPBRequestBean bean = (NPBRequestBean)getBeanObject(bean_id,bean_name ,request) ;
				if(mode.equals("1"))
					NPBReqFormText = bean.getNPBReqFormText();
				else{
					NPBReqFormText = bean.getNPBRequestFormText(NPBReqNo);
				}
			}
			else if (mode.equals("2")){
				NPBRequestApproveRejectBean bean = (NPBRequestApproveRejectBean)getBeanObject(bean_id,bean_name ,request) ;
				HashMap NPBRequestDtlList=bean.getNPBRequestDtlList();
				HashMap NPBRequestDtl = (HashMap)NPBRequestDtlList.get(NPBReqNo);
				NPBReqFormText =(String) NPBRequestDtl.get("REQUEST_FORM_CONTENT");
			}
			if(NPBReqFormText==null || NPBReqFormText.equals("<ADDRESS>&nbsp;</ADDRESS>"))	
				NPBReqFormText ="";
			NPBReqFormText	= "<img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' width='40' height='40' align='center'></img>" +NPBReqFormText ;
		}
		catch(Exception e){
			e.printStackTrace();
		}
%>
		<form name="editor_preview" id="editor_preview" method="post" target="messageFrame">
			<table cellpadding=3 cellspacing=0 border=0  style='table-layout: fixed;' >	
				<tr>		
					<td style='text-align:left;' id="NPBReqDetail"><font size='2'><%=NPBReqFormText%></font></td> 		
				</tr>
			</table>
		</form>
	</body>
</html>

