<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
	<head>
	<%
	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends

		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT> 
		<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
		<script language="JavaScript" src="../../ePH/js/PhMessages.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../ePH/js/RegPrescriptions.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0" >
<%
		String	bean_id			=	"RegPrescriptionsBean" ;
		String	bean_name		=	"ePH.RegPrescriptionsBean";
		
   		RegPrescriptionsBean bean = (RegPrescriptionsBean)getBeanObject(bean_id,bean_name ,request) ;
		String sysdate = bean.getSysdate();
		String buttontitle	=	"Patient Arrived";
		String disp_locn_code=request.getParameter("disp_locn_code");
%>
		<form name="MarkPatArrivalFooter" id="MarkPatArrivalFooter" >
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0" >
				<tr>
					<td align="right"><input type="button" name="btnPres" id="btnPres" value="<%=buttontitle%>" class="button"  onClick="MarkPatArrival(MarkPatArrivalFooter);" >
					</td>
				</tr>
				<input type="hidden" name="sysdate" id="sysdate" value="<%=sysdate%>">
				<input type="hidden" name="disp_locn_code" id="disp_locn_code" value="<%=disp_locn_code%>">

			</table>
		</form>
	</body>
<%	putObjectInBean(bean_id,bean,request);%>
</html>

