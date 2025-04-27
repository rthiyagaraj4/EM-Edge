<!DOCTYPE html>
<%@ page language="java" import="java.util.*,com.iba.framework.core.vo.UserPreferences,com.iba.framework.cache.pojo.business.Cache,com.iba.framework.cache.pojo.business.CacheManager,com.iba.framework.core.util.Constants,com.iba.framework.core.util.IBADate,com.iba.framework.core.util.IBADateTime,com.iba.ehis.lc.core.util.LcDateFormat,com.iba.framework.core.util.IBADateValidation" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page  import="com.iba.framework.core.util.Constants" %>
<%@ include file="/framework/html/Tag.text"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<ibaHtmlEl:html locale="true">
<head>
	<%
	
			String loggedInUser = (String) session.getAttribute("login_user");
			String locale = (String) session.getAttribute("LOCALE");
			String facilityId=(String)session.getAttribute("facility_id");
			String functionId = (String) request.getParameter("functionId");
			String moduleId = (String) request.getParameter("moduleId");
			String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session
			.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
			if (sStyle == null)
				sStyle = "IeStyle.css";
			String qryEven = "QRYEVEN";
			String qryOdd = "QRYODD";

			UserPreferences userPrefs =new UserPreferences();
			/* Cache cache = CacheManager.getCache();
			userPrefs=(UserPreferences)cache.getObject(Constants.USER_SESSION_CACHE, request.getSession().getId(), Constants.USER_PREFS); */
			
			String timepattrn=userPrefs.getTimeFormat();
			String sb=userPrefs.getDateFormat();
			String pattern=sb+" "+timepattrn;

			IBADateTime todate=LcDateFormat.convertDateFormat(null,request);


			IBADateValidation ibaDateValidation = new IBADateValidation();
			String cdate = ibaDateValidation.convertDateJS(todate.toString(),"en",locale,pattern);

		
	%>
		<script type="text/javascript" src='<%=request.getContextPath()%>/eLC/RequestForCleaningLinen/js/RequestForCleaningLinen.js'></script>
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>' />
		<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/DynaLookup.js'></script>
	<Script language="JavaScript" src='<%=request.getContextPath()%>/core/lookup/js/Lookup.js'></Script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/hashtable.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LinenRequest.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<Script language="JavaScript" src='<%=request.getContextPath()%>/framework/js/PopupWindow.js'></Script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/eLC/RequestForCleaningLinen/js/tooltip.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/IBADateValidator.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/ReceiveLoanedLinenList.js'></script>
	

<Script>
var  testpopup5="";
var val="";
function test5popupactivate(anchor,id) {
if(testpopup5=="")
{
 testpopup5 = new PopupWindow();
}
val=document.getElementById("remarks"+id).value;
testpopup5.height=200;
testpopup5.width=300;
testpopup5.offsetX=-10;
testpopup5.offsetY=10;
testpopup5.windowProperties="toolbar=no,location=no,status=no,menubar=no,scrollbars=auto,resizable=no,alwaysRaised,dependent,titlebar=no";
testpopup5.autoHide();
testpopup5.noResize=true;
testpopup5.populate('<title><ibaBean:message key="com.iba.ehis.lc.remark" bundle="lcLabels" /></title><link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>"></link><FORM><CENTER><table border="0" celpadding="0" cellspacing="0" width="100%" height="100%"><tr><td class="label" align="center"> <ibaBean:message key="com.iba.ehis.lc.remark" bundle="lcLabels" />: </td></tr><tr><td  align="center"><textarea rows=5 cols=40 id="remark"  name="remark" readonly="true" >'+val+'</textarea></td></tr><tr><td  align="center"><input class="button" type="button" onclick="window.close();" value="OK"/></td></tr></table> </FORM></CENTER>');
testpopup5.showPopup(anchor);
}
</script>

<script>

		function doNext() {
		var pageNum=document.getElementById("vo.page.pageNo")
			pageNum.value=parseInt(pageNum.value)+1
			document.PageForm.submit()
		}
		function doPrev() {
			var pageNum=document.getElementById("vo.page.pageNo")
			pageNum.value=parseInt(pageNum.value)-1
			document.PageForm.submit()
		}			
		function checkNumber1(obj) {
	var val=obj.value;
    if ( trimCheck(val) && isNaN(val) == false && val >=0)
        return true;
    else
        if ( val.length > 0 ) {
            	getServerMessage("message.Numbers.Allowed");
				parent.parent.parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+dwrMessage;
				window.event.keyCode = 27;
				obj.value="";
			return false;
        }
}
function checkAlpha(obj1){
	  	 obj =  String.fromCharCode(window.event.keyCode);
	   	var alphaFilter =/^[a-z_A-Z]+$/;
	   	if (!(alphaFilter.test(obj))) { 
	   	//error = "Please enter a valid Alphabets.\n";
	   	getServerMessage("messages.Alphabet");
		parent.parent.parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+dwrMessage;
	   	window.event.keyCode = 27;
		obj1.value="";
   		}
   	}
	function ConfirmDate(){	
		var currDate = new Date();
		var date = currDate.getDate();
		var mon = currDate.getMonth();
		var hrNow = currDate.getHours();
		var mnNow = currDate.getMinutes();
		scNow = currDate.getSeconds();
		mon = mon+1;
		var year = currDate.getYear();
		if(date <10)
			date = "0"+date;
		if(mon <10)
			mon = "0"+mon;
		if(hrNow<10)
				hrNow="0"+hrNow;
		if(mnNow<10)
				mnNow="0"+mnNow;
		var convert1= date + "/" + mon + "/" + year;
			convert1=convert1+" "+hrNow+ ":" +mnNow;
	
		return convert1;
	}
</script>

</head>

<body onload="hideSubmit()" OnMouseDown="CodeArrest()"  onKeyDown="lockKey()">
	<ibaHTMLEl:form action="/PendingCountPageAction.do">
		<br>
		<div id="next" align="right">
				<table><tr><td>
						<ibaLogic:equal name="PageForm" property="vo.page.previousPage" value="true">		
						<a href="javascript:doPrev()">
						<ibaBean:message key="com.iba.ehis.lc.previous" bundle="lcLabels" />
						</a>
						</ibaLogic:equal>
						</td>
						<td>
						<ibaLogic:equal name="PageForm" property="vo.page.nextPage"	value="true">
						<a href="javascript:doNext()" >
						<ibaBean:message key="com.iba.ehis.lc.next" bundle="lcLabels" />
						</a></ibaLogic:equal>
						</td>

						</tr></table>
	</div>
	
			<ibaLogic:equal name="PageForm" value="0"
				property="vo.dataObjectsSize">
				<script> 
					alert("<ibaBean:message key='NO_RECORD_FOUND_FOR_CRITERIA' bundle='commonMesages' />");
				</script>
			</ibaLogic:equal>
			<ibaHTML:hidden property="vo.dataObjectsSize" />

			<table border="1" width="100%" cellspacing='0' cellpadding='0'
			align='center'>
			
					
	<ibaLogic:notEqual name="PageForm" value="0"
				property="vo.dataObjectsSize">
		<tr >
			<tr>
				<td  colspan=9 align="left">
					<b><ibaBean:message key="com.iba.ehis.lc.linenItemDetail"	bundle="lcLabels" /></b>
				</td>
		
			</tr>
			

				<tr>
					
					<th rowspan=2>
						<ibaBean:message key="com.iba.ehis.lc.linenItem"
							bundle="lcLabels" />
					</th>
					<th colspan=2>
						<ibaBean:message key="com.iba.ehis.lc.request"
							bundle="lcLabels" />
					</th>
					
					
					
					<th rowspan=2>
						<ibaBean:message key="com.iba.ehis.lc.requestForCleaningLinen.linenHandedOverBy"
							bundle="lcLabels" />
					</th>
					<th rowspan=2>
						<ibaBean:message key="com.iba.ehis.lc.requestForCleaningLinen.linenCollectedBy"
							bundle="lcLabels" />
					</th>
					<th rowspan=2>
						<ibaBean:message key="com.iba.ehis.lc.requestForCleaningLinen.confirmedYn"	
						bundle="lcLabels" />
					</th>
					<th rowspan=2>
						<ibaBean:message
							key="com.iba.ehis.lc.remark"
							bundle="lcLabels" />
					</th>
					<th rowspan=2>
							<ibaBean:message
							key="com.iba.ehis.lc.requestForCleaningLinen.confirmedDate"
							bundle="lcLabels" /> 
					</th>
					<th rowspan=2>
					<ibaBean:message key="com.iba.ehis.lc.requestForCleaningLinen.confirmedBy"
							bundle="lcLabels" />
					
					</th> 

				</tr>
				<tr>
				<th><ibaBean:message key="com.iba.ehis.lc.date"	bundle="lcLabels" /></th>
				<th><ibaBean:message key="com.iba.ehis.lc.requestForCleaningLinen.quantity"
							bundle="lcLabels" /></th>
				
				</tr>

			</ibaLogic:notEqual>

			<ibaLogic:iterate id="result" name="PageForm"
				property="vo.dataObjects" indexId="rowId">
				<%
				  String style =(rowId.intValue()%2==0)?"QRYEVEN":"QRYODD";
				  //out.println(style);
				%>

					<tr>
				<%--		<td class="<%=style%>">
					<ibaBean:write name='result' property='cancelledBy' /> 
					</td>--%>
					<td class="<%=style%>" align='left'>
					<input type="hidden" name='lCode_<%=rowId%>' id='lCode_<%=rowId%>' size=8 value='<ibaBean:write name="result" property="linenItem" bundle="lcLabels" />' />
					<input type="text" size=12 name='lDesc_<%=rowId%>' id='lDesc_<%=rowId%>' value=" " style="background:transparent;border=0;" readonly="true" /> 
					<script>
						var lcode=document.getElementById("lCode_<%=rowId%>").value;
						ReceiveLoanedLinenList.getLinenItem("<%=locale%>",lcode,callBackLinenDesc);
							function callBackLinenDesc(data){
								for(prop in data){
									document.getElementById("lDesc_<%=rowId%>").value=data[prop];
								}
							}
					</script>
<!--					<ibaBean:write name="result" property="linenItem" />-->
					</td>
					<td class="<%=style%>" align='left'>
						<input type="text" size=15 name="requestDate<%=rowId%>" id="requestDate<%=rowId%>" style="background:transparent;border=0;" readonly="true"/> 
						<script>
						IBADateValidator.convertDateJS('<ibaBean:write name="result" property="requestDate" bundle="lcLabels" />  ',"en","<%=locale%>","<%=pattern%>",RDFromcallbackMethod);
						function  RDFromcallbackMethod(fdate){
							document.getElementById("requestDate<%=rowId%>").value=fdate;
						}
					   </script>
					</td>
					<td class="<%=style%>" align='right'>
						<input type=text size=3 name='qty:<%=rowId%>' id='qty:<%=rowId%>' value='<ibaBean:write name="result" property="requestedQty" bundle="lcLabels"/>' onkeyup="checkNumber1(this)" onblur="setHiddenValue(this)" />
						
					
					</td>
					<td class="<%=style%>" align='left'>
						<ibaBean:write name="result" property="linenHandedOverBy" />
					
						
					</td>
					<td class="<%=style%>" align='left'>
						<ibaBean:write name="result" property="linenCollectedBy" />
						
					</td>
					
						<td class="<%=style%>" align='left'>
<%--					<ibaBean:write name="result" property="countConfirmedYn" />--%>
					
						<ibaLogic:equal value="N" property="countConfirmedYn" name="result">
						<input type="checkbox" value="N" onclick="setConfirm(this,'<%=rowId%>')" />
						</ibaLogic:equal>
						<ibaLogic:equal value="Y" property="countConfirmedYn" name="result">
						<input type="checkbox" value="Y" checked="checked"  />
						</ibaLogic:equal>
										
					</td>
					<td class="<%=style%>" align='left'>
						<a href="javascript:popUpInstructions()" onclick="test5popupactivate(this.id,<%=rowId%>);return false;" name="prepAnchor" id="prepAnchor">
						<ibaBean:message key="com.iba.ehis.lc.remark" bundle="lcLabels" />
						</a>
						<input type="hidden" value="<ibaBean:write name='result' id='result' property='remarks' />" name="remarks<%=rowId%>" />
					</td>
					<td class="<%=style%>" >
					<input type=text size=15 name='countConfirmedDate:<%=rowId%>' id='countConfirmedDate:<%=rowId%>' onblur="setHiddenValue(this)" readonly/>
					<script>
					if("<ibaBean:write name='result' property='countConfirmedDate' bundle='lcLabels'/>"!="") {
						IBADateValidator.convertDateJS('<ibaBean:write name="result" property="countConfirmedDate" bundle="lcLabels" />',"en","<%=locale%>","<%=pattern%>",RDFromcallbackMethod);
						
						function  RDFromcallbackMethod(fdate){
							//alert("fdate is :" +fdate);
								document.getElementById("countConfirmedDate:<%=rowId%>").value=fdate;
							}
						}
						else
						{
							var confirmDate =  ConfirmDate();
							IBADateValidator.convertDateJS(confirmDate,"en","<%=locale%>","<%=pattern%>",RDFromcallbackMethod);
							function  RDFromcallbackMethod(fdate){
								document.getElementById("countConfirmedDate:<%=rowId%>").value=fdate;
								 //alert("false is : " +document.getElementById("countConfirmedDate:<%=rowId%>").value)	;
								 document.getElementById("vo.placeCleaningLinenRequestVO.cleanLinenRequest["+<%=rowId%>+"].countConfirmedDate").value=fdate;
							}
							
						}
					</script>
					</td>

					<td class="<%=style%>" width="10%">
					<input type=text size=10 name='countConfirmedBy:<%=rowId%>' id='countConfirmedBy:<%=rowId%>' onblur="setHiddenValue(this)" onkeyup="checkAlpha(this)" readonly value="<%=loggedInUser%>"/>
					<script>
					if("<ibaBean:write name='result' property='countConfirmedBy' bundle="lcLabels"/>"!="") {
						document.getElementById("countConfirmedBy:<%=rowId%>").value="<ibaBean:write name='result' property='countConfirmedBy' bundle="lcLabels"/>"}
					</script>
					</td>
					
				</tr>
					<input type=hidden name="reqNo:<%=rowId%>" id="reqNo:<%=rowId%>" value='<ibaBean:write name="result" property="requestNo" />'/> 
					<input type=hidden name="category:<%=rowId%>" id="category:<%=rowId%>" value='<ibaBean:write name="result" property="category" />'/> 
					<input type=hidden name="linenItem<%=rowId%>" id="linenItem<%=rowId%>" value='<ibaBean:write name="result" property="linenItem" />'/> 
					<input type=hidden name="requestDate:<%=rowId%>" id="requestDate:<%=rowId%>" value='<ibaBean:write name="result" property="requestDate" bundle="lcLabels"/>'/> 
					<input type=hidden name="linenCollectedBy<%=rowId%>" id="linenCollectedBy<%=rowId%>" value='<ibaBean:write name="result" property="linenCollectedBy"  />'/> 
					<input type=hidden name="countConfirmedYn:<%=rowId%>" id="countConfirmedYn:<%=rowId%>" value='<ibaBean:write name="result" property="countConfirmedYn"  />'/>
					<input type=hidden name="remarks<%=rowId%>" id="remarks<%=rowId%>" value='<ibaBean:write name="result" property="remarks"  />'/>
					<input type=hidden name="requestStatus<%=rowId%>" id="requestStatus<%=rowId%>" value='<ibaBean:write name="result" property="requestStatus"  />'/>
					<input type=hidden name="scheduleDeliveryDate<%=rowId%>" id="scheduleDeliveryDate<%=rowId%>" value='<ibaBean:write name="result" property="scheduleDeliveryDate" bundle="lcLabels" />'/>

			</ibaLogic:iterate>

		</table>
		<ibaHTML:hidden property="vo.page.pageNo" />
		<ibaHTML:hidden property="method" value="4" />

		<ibaLogicEl:iterate id="result" name="PageForm"
			property="vo.criteriaVo.criteriaItems" indexId="ind">
			<%
							String itemValProp = "vo.criteriaVo.criteriaItems["
							+ ind + "].itemValue";
					String prop = "vo.criteriaVo.criteriaItems[" + ind
							+ "].property";
			%>
			<ibaHTMLEl:hidden property="<%=itemValProp%>" />
			<ibaHTMLEl:hidden property="<%=prop%>" />

		</ibaLogicEl:iterate>
		<ibaHTML:hidden property="vo.criteriaVo.orderBySelected.itemValue" />
		<ibaHTML:hidden property="vo.criteriaVo.queryResultPage" />
		<ibaHTML:hidden property="vo.moduleId" />
		<ibaHTML:hidden property="vo.functionId" />
		<input type="hidden" name="languageId" id="languageId" value="<%=locale%>" />
		<input type="hidden" name="pattern" id="pattern" value="<%=pattern%>" />
	</ibaHTMLEl:form>
		
	<ibaHTMLEl:form action="/RequestForCleaningLinenAction.do" target="messageFrame">
	<center><input type="button" value="Submit" name="Submit" id="Submit"  id="btn1" class="BUTTON" onclick="submit()" /></center>
		<div id="listContentLayer" align="center" >
		<table width='90%' id="contentTable1" >
		</table>
		</div>
		<ibaHTML:hidden property="vo.operatingFacilityId" value="<%=facilityId%>" />		
		<ibaHTML:hidden property="vo.functionId" value="<%=functionId%>" />
		<ibaHTML:hidden property="vo.moduleId" value="<%=moduleId%>" />
		<ibaHTML:hidden property="method" value="2" />	
		<ibaHTML:hidden property="vo.viewCode" value="pending" />	
		
	</ibaHTMLEl:form>
</body>
<script>
function submit()
{ document.RequestForCleaningLinenform.submit();
}
setObjValue();
</script>
</ibaHtmlEl:html>

