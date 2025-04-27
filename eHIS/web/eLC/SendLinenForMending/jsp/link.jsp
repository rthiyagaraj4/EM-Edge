<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page  import="com.iba.framework.core.util.Constants" %>
<%@ page  import="com.iba.ehis.core.vo.AppVO" %>
<%@ include file="/framework/html/Tag.text" %>
<ibaHTML:html locale="true">

<head>
	<%
			String facilityId = (String) session.getAttribute("facility_id");
			String locale = (String) session.getAttribute("LOCALE");
			//String login_user = (String) session.getAttribute("login_user");
			session.setAttribute("requestStatus",request.getParameter("requestStatus"));
			String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session
			.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
			if (sStyle == null)
				sStyle = "IeStyle.css";
	%>
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>' />
<script language="javascript" src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/IBADateValidator.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LinenRequest.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/eLC/SendLinenForMending/js/SendLinenForMending.js'></script>

	<script type="text/javascript">


	var pArgumentArray = new Array();
	pArgumentArray[0]= <%=request.getParameter("requestNum")%>
	pArgumentArray[2]= <%=request.getParameter("sentBy")%>
	pArgumentArray[3]= <%=request.getParameter("requestStatus")%>
	pArgumentArray[4]=<%=request.getParameter("linenItem")%>
	pArgumentArray[5]=<%=request.getParameter("cancelledBy")%>
	pArgumentArray[6]=<%=request.getParameter("cancelledDate")%>"
	pArgumentArray[7]=<%=request.getParameter("reasonCode")%>
	pArgumentArray[8]=<%=request.getParameter("requestedQty")%>

	var reqDate = <%=request.getParameter("requestDate")%>
			
		IBADateValidator.convertDateJS(reqDate,"en","<%=locale%>","dd/MM/yyyy HH:mm",callBackReqDate);
		function callBackReqDate(conDate){
			pArgumentArray[1]=conDate;
		}
			
		function callModalWindow(title){
			var retVal = new String();
			var dialogHeight = "35";
			var dialogWidth = "50";   
			var status = "no";
		
			var dialogUrl = contextPath + "/eLC/SendLinenForMending/jsp/ModalMessageFrames.jsp?title="+ title +"&vo.checkView=veiw&method=4&requestNum="+pArgumentArray[0]+"&requestDate="+pArgumentArray[1]+"&sentBy="+pArgumentArray[3]+"&status="+pArgumentArray[3]+"&linenItem="+pArgumentArray[4]+"&cancelledBy="+pArgumentArray[5]+"&cancelledDate="+pArgumentArray[6]+"&reasonCode="+pArgumentArray[7]+"&requestStatus="+pArgumentArray[3]+"&addedFacilityId=<%=facilityId%>"
			var dialogArguments = pArgumentArray;
			var dialogFeatures = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + " ; scroll=no; status:" + status;
			var val=window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);
			if(val==true)
			parent.parent.window.frames[0].document.QueryCriteriaForm.submit();
		
		}
	</script>
</head>

<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<ibaBean:define id="status" scope="session" name="requestStatus" ></ibaBean:define>
	<table border='0' cellpadding='2' cellspacing='0' width='100%' align='center'>
		
		<%
			String stat = (String)session.getAttribute("requestStatus");
			String CN_Value[] = stat.split(" ");
			String statusSplit = CN_Value[1];
			if(statusSplit.equals("CN")){
		%>
		<tr>
			<td class="label">
				<a href="#"	onClick="return callModalWindow('<ibaBean:message	key="com.iba.ehis.lc.viewDetail" bundle="lcLabels" />');">
					<ibaBean:message key="com.iba.ehis.lc.view" bundle="lcLabels" />
				</a>
			</td>
		</tr>
		<tr>
				<td height="15">
					
				</td>
			</tr>
			<%
			} else if(statusSplit.equals("RE")){	
		%>
			<tr>
				<td class='label'>
					<a href="#"	onClick="return callModalWindow('<ibaBean:message	key="com.iba.ehis.lc.viewDetail" bundle="lcLabels" />');">
						<ibaBean:message key="com.iba.ehis.lc.view" bundle="lcLabels" />
					</a>
				</td>
			</tr>
			<tr>
				<td height="15">
					
				</td>
			</tr>
		<%
			} else {	
		%>
		<tr>
			<td class='label'>
				<a href="#" onClick="return callModalWindow('<ibaBean:message key="com.iba.ehis.lc.cancelDetail" bundle="lcLabels" />');">
				 <ibaBean:message	key="com.iba.ehis.lc.cancel" bundle="lcLabels" /> </a>
			</td>
		</tr>
		<tr>
			<td class="label">
				<a href="#"	onClick="return callModalWindow('<ibaBean:message	key="com.iba.ehis.lc.viewDetail" bundle="lcLabels" />');">
					<ibaBean:message key="com.iba.ehis.lc.view" bundle="lcLabels" />
				</a>
			</td>
		</tr>
		<%
			} 
		%>
	</table>
</body>
</ibaHTML:html>

