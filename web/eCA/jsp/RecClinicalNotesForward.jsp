<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------
Date		Edit History  Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
05/06/2018  IN67872	  Dinesh T	05/06/2018	Ramesh G	CRF-0497.1
07/08/2018  IN063818	 Raja S		07/08/2018	Ramesh G	MMS-DM-CRF-0102
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		String	operation_mode		=	"",		window_title				=	"";
		String  isModifyDescYN      =   "";//IN063818
		operation_mode	=	request.getParameter("operation_mode") == null ? "" : request.getParameter("operation_mode");
		isModifyDescYN = request.getParameter("isModifyDescYN") == null ? "N" : request.getParameter("isModifyDescYN");//IN063818

		//if(!(operation_mode.equals("MarkAsError") || operation_mode.equals("ModifySection") || operation_mode.equals("ModifyAddendum")))//IN67872	
		/*if(!(operation_mode.equals("MarkAsError") || operation_mode.equals("ModifySection") || operation_mode.equals("ModifyAddendum") || operation_mode.equals("REJECT")))//IN67872		
			window_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ForwardNotesTo.label","ca_labels");
		else if(operation_mode.equals("ModifySection") || operation_mode.equals("ModifyAddendum")){
			//IN063818 starts
			if(isModifyDescYN.equals("Y"))
				window_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.RemarksforUpdate.label","ca_labels");
			else{
			//IN063818 ends
				window_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.RemarksforModify.label","ca_labels");
			}
		//else////IN67872
		}else if(operation_mode.equals("MarkAsError"))//IN67872
			window_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.MarkasError.label","ca_labels");
		else if(operation_mode.equals("REJECT"))//IN67872
			window_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.MarkasReject.label","ca_labels");//IN67872
			*/
	%>
		<title><%=window_title%></title>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
		<iframe src='../../eCA/jsp/RecClinicalNotesForwardMain.jsp?<%=request.getQueryString()%>' frameborder='0' framespacing='0' scrolling='no'  name="criteria" id="criteria" MARGINWIDTH='0px' MARGINHEIGHT='0px' style='height:100vh;width:100vw'></iframe>
</html>

