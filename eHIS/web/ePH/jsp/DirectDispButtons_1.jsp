<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8" import=" ePH.*, eOR.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
    <!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
		request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../ePH/js/DirectDispensing.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eOR/js/OrderEntrySearch.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
		String source			= request.getParameter("mode");
		String display1_yn		= request.getParameter("display1_yn");
		String display2_yn		= request.getParameter("display2_yn");
		String display1			="display:none";
		String display2			="display:none";
		if(display1_yn.equals("Y")){
		   display1			="display:inline";
		}
		if(display2_yn.equals("Y")){
		   display2			="display:inline";
		}
%>
		<form name="prescription_button" id="prescription_button" >
			<table cellpadding=0 cellspacing=0 width="100%" height="100%" align="center" border="0">
				<tr>
					<td  width="10%">
						<input type="button" class="button" value= '<fmt:message key="Common.confirm.label" bundle="${common_labels}"/>' name="confirm"  id="confirm"onclick="addDrug('<%=source%>')"  style="<%=display2%>"></input>
					</td>
					<td width="40%">
						<input type="button" class="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' name="Cancel"id="Cancel"onclick="addDrug('delete')" name="cancel"style="<%=display2%>" ></input>
					</td>				
					<td  width="50%" align='right'>
						<input type="button" class="button" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' onclick="resetDrugdetails('insert')"   name="btnReset" style="<%=display1%>">
						<input type="button" class="button" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/> ' onclick="clearDrugdetails()"   name="btnClear" style="display:none"> 
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>

