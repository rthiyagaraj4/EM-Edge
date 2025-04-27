<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*,com.iba.framework.core.vo.UserPreferences,com.iba.framework.cache.pojo.business.Cache,com.iba.framework.cache.pojo.business.CacheManager,com.iba.framework.core.util.Constants,com.iba.framework.core.util.IBADate,com.iba.framework.core.util.IBADateTime,com.iba.ehis.lc.core.util.LcDateFormat,com.iba.framework.core.util.IBADateValidation" pageEncoding="UTF-8"%>
<%@ page  import="com.iba.framework.core.util.Constants" %>
<%@ page  import="com.iba.ehis.core.vo.AppVO" %>
<%@ include file="/framework/html/Tag.text"%>
<ibaHTML:html locale="true">
<title><ibaBean:message
		key="com.iba.ehis.lc.requestForLinen.cancelDetail" bundle="lcLabels" />
</title>
<head>
	<%
			String facilityId=(String)session.getAttribute("facility_id");
			String functionId = (String) session.getAttribute("functionId");
			String moduleId = (String) session.getAttribute("moduleId");
			String locale = (String) session.getAttribute("LOCALE");
			String addedById = (String) session.getAttribute("login_user");
			String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session
			.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
			if (sStyle == null)
				sStyle = "IeStyle.css";
				IBADateTime date = new IBADateTime(request.getSession().getId());
	%>
		<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>'></link>
	
	<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/IBADateValidator.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LinenRequest.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type="text/javascript"
		src='<%=request.getContextPath()%>/eLC/DeliverCleanedLinen/js/DeliverCleanedLinen.js'>
</script>

	<script type="text/javascript">
	var pArgumentArray = new Array();
	pArgumentArray[0]=<%=request.getParameter("sourceCode")%>
	pArgumentArray[1]=<%=request.getParameter("requestNum")%>
	pArgumentArray[1]=trimString(pArgumentArray[1]);
	var reqDate = <%=request.getParameter("requestDate")%>
		
	IBADateValidator.convertDateJS(reqDate,"en","<%=locale%>","dd/MM/yyyy HH:mm",callBackReqDate);
	function callBackReqDate(conDate){
		pArgumentArray[2]=conDate;
	}

	pArgumentArray[3]=<%=request.getParameter("linenHandedOverBy")%>
	pArgumentArray[4]=<%=request.getParameter("linenCollectedBy")%>
	var status=<%=request.getParameter("requestStatus")%>
	pArgumentArray[5]=trimString(status);
	pArgumentArray[6]=<%=request.getParameter("sourceType")%>     
	pArgumentArray[7]=<%=request.getParameter("linenItem")%>
	pArgumentArray[7]=trimString(pArgumentArray[7]);
	pArgumentArray[8]=<%=request.getParameter("cancelledBy")%>
	
	var delivDate = <%=request.getParameter("deliveryDate")%>
	
	IBADateValidator.convertDateJS("<%=date%>","en","<%=locale%>","dd/MM/yyyy HH:mm",callBackDelivDate);
	function callBackDelivDate(conDelivDate){
		pArgumentArray[9]=conDelivDate;

	}
	pArgumentArray[10]=<%=request.getParameter("reasonCode")%>
	
	var cancelDate = <%=request.getParameter("cancelledDate")%>
		
	IBADateValidator.convertDateJS(reqDate,"en","<%=locale%>","dd/MM/yyyy HH:mm",callBackCancelDate);
	function callBackCancelDate(conCnacelDate){
		pArgumentArray[11]=conCnacelDate;
	}

	pArgumentArray[12]=<%=request.getParameter("requestedQty")%>
	pArgumentArray[13]=<%=request.getParameter("category")%>
	var ldesc=<%=request.getParameter("linenDesc")%>"
	//alert(ldesc)
	//ldesc=ldesc.substring(1,ldesc.length)
	pArgumentArray[14]=trimString(ldesc);

	function callModalWindow(title)
	{
		var retVal = new String();
		var dialogHeight = "30";
		var dialogWidth = "55";
		var status = "no";
	
		var dialogUrl = contextPath + '/DeliverCleanedLinenViewAction.do?title='+ title +'&vo.checkView=deliver&method=4&vo.deliverCleanedLinenVO.requestNum='+pArgumentArray[1]+'&vo.deliverCleanedLinenVO.linenItem='+pArgumentArray[7]+'&vo.deliverCleanedLinenVO.requestStatus='+pArgumentArray[5]

		var dialogArguments = pArgumentArray;
		var dialogFeatures = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + " ; scroll:1; status:" + status;
		window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);
		
	}
	function callModalWindow1(title)
	{
		var retVal = new String();
		var dialogHeight = "35";
		var dialogWidth = "55";
		var status = "no";
		

		var reqStatus=pArgumentArray[5]
			pArgumentArray[5]=trimString(reqStatus);

		var dialogUrl = contextPath + "/eLC/DeliverCleanedLinen/jsp/ModalMessageFrames.jsp?title="+ title +"&requestNum="+pArgumentArray[1]+"&requestDate="+pArgumentArray[2]+"&sourceType="+pArgumentArray[6]+"&sourceCode="+pArgumentArray[0]+"&linenHandedOverBy="+pArgumentArray[3]+"&linenCollectedBy="+pArgumentArray[4]+"&requestStatus="+pArgumentArray[5]+"&linenItem="+pArgumentArray[7]+"&cancelledBy="+pArgumentArray[8]+"&deliveryDate="+pArgumentArray[9]+"&vo.deliverCleanedLinenVO.requestNum="+pArgumentArray[1]+"&vo.deliverCleanedLinenVO.linenItem="+pArgumentArray[7]+"&vo.deliverCleanedLinenVO.requestStatus="+pArgumentArray[5]

		var dialogArguments = pArgumentArray;
		var dialogFeatures = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + " ; scroll:yes; status:" + status;
		var val=window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);
		if(val==true)
			parent.parent.window.frames[0].document.QueryCriteriaForm.submit();
	
	}
	
	
	</script>
</head>

<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<table border='0' cellpadding='2' cellspacing='0' width='100%'
			align='center'>
			<%
			String stat = (String)request.getParameter("requestStatus");
			String DL_Value[] = stat.split(" ");
			String statusSplit = DL_Value[1];
			if(statusSplit.equals("DL")||statusSplit.equals("CN")){
		%>
			<tr>
				<td class="label">
					<a href="#"	onClick="return callModalWindow('<ibaBean:message	key='com.iba.ehis.lc.viewDetail' bundle='lcLabels' />');">
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
					<a href="#" onClick="return callModalWindow1('<ibaBean:message	key='com.iba.ehis.lc.delivery' bundle='lcLabels' />');">
					 <ibaBean:message	key="com.iba.ehis.lc.delivery" bundle="lcLabels" /> </a>
				</td>
			</tr>
			<tr>
				<td class="label">
					<a href="#"	onClick="return callModalWindow('<ibaBean:message	key='com.iba.ehis.lc.viewDetail' bundle='lcLabels' />');">
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

