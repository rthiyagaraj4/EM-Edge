<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page  import="com.iba.framework.core.util.Constants"%>
<%@ include file="/framework/html/Tag.text"%>

<ibaHTML:html locale="true">
<head>
	<% 	
		String facilityId=(String)session.getAttribute("facility_id");
		String functionId = (String) session.getAttribute("functionId");
		String moduleId = (String) session.getAttribute("moduleId");
		String addedById = (String) session.getAttribute("login_user");
		String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
				.getAttribute("PREFERRED_STYLE") != "")) ? (String) session
				.getAttribute("PREFERRED_STYLE")
				: "IeStyle.css";
				if (sStyle == null)
					sStyle = "IeStyle.css";
	%>
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>' />
<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>

	<script type="text/javascript" src="<%=request.getContextPath()%>/core/lookup/js/Lookup.js"></script>	
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/hashtable.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/IBADateValidator.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/DynaLookup.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/ReceiveLoanedLinenList.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/validations.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/common.js"></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/eLC/ReceiveLoanedLinen/js/ReceiveLoanedLinen.js'></script>
			
// *******************************************************************************************************	
	function assignVal(){
		
		document.ReceiveLoanedLinenForm["vo.loanLinenVO.loanRefNum"].value = dialogArguments[5];
		document.ReceiveLoanedLinenForm["vo.loanLinenVO.loanDate"].value = dialogArguments[6];
		document.ReceiveLoanedLinenForm["vo.loanLinenVO.sourceType"].value = dialogArguments[3];
		document.ReceiveLoanedLinenForm["vo.loanLinenVO.sourceCode"].value = dialogArguments[4];
		document.ReceiveLoanedLinenForm["vo.loanLinenVO.loanedToSourceType"].value = dialogArguments[1];
		document.ReceiveLoanedLinenForm["vo.loanLinenVO.loanedToSourceCode"].value = dialogArguments[2];
		document.ReceiveLoanedLinenForm["vo.loanLinenVO.givenBy"].value = dialogArguments[7];
		document.ReceiveLoanedLinenForm["vo.loanLinenVO.receivedBy"].value = dialogArguments[8];
		document.ReceiveLoanedLinenForm["vo.loanLinenVO.reasonforLoan"].value = dialogArguments[12];
		document.ReceiveLoanedLinenForm["vo.loanLinenVO.remarks"].value = dialogArguments[15];
	} 
	
	function checkQty(obj){
		var val=obj.value;
    if ( trimCheck(val) && isNaN(val) == false && val >=0)
        return true;
    else
        if ( val.length > 0 ) {
            	getServerMessage("message.Numbers.Allowed");
				parent.parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+dwrMessage;
				window.event.keyCode = 27;
				obj.value="";
			return false;
        }
	   }
	}
	
	function insert(){
		var loadMethod='2';
		loanRefNum=document.ReceiveLoanedLinenForm["vo.loanLinenVO.loanRefNum"].value;
		receivedBackBy=document.ReceiveLoanedLinenForm["vo.loanLinenVO.receivedBackBy"].value;
		location.href=contextPath+"/ReceiveLoanedLinenAction.do?method="+loadMethod+"&vo.loanLinenVO.loanRefNum"+loanRefNum
	}
	
	function receivedQtyStatus(){
		
		var Qty = document.ReceiveLoanedLinenForm["vo.loanLinenVO.receivedWriteOff"].value;
		document.getElementById("hide").value="test";
		if(Qty ==  'W'){
			document.ReceiveLoanedLinenForm["vo.loanLinenVO.receivedQty"].value="";
			document.ReceiveLoanedLinenForm["vo.loanLinenVO.receivedQty"].disabled=true;
		}else{ 
			document.ReceiveLoanedLinenForm["vo.loanLinenVO.receivedQty"].disabled=false;	
		}
	}
	
	function submitFormNullCheck(){
		var flag="";
		flag = checkNull();
		if(flag == true){
			document.ReceiveLoanedLinenForm.submit();
			}
		}

	function checkNull(){
		var flag;
	 	var error="";
	 	if(document.ReceiveLoanedLinenForm["vo.loanLinenVO.receivedWriteOff"].value == 'R'){
	 		var fieldName =new Array("com.iba.ehis.lc.receive/writeOff","com.iba.ehis.lc.receiveloanedlinen.receivedQty","com.iba.ehis.lc.receiveloanedlinen.receivedBackBy","com.iba.ehis.lc.receiveloanedlinen.givenBackBy");
			var fields =new Array(document.ReceiveLoanedLinenForm["vo.loanLinenVO.receivedWriteOff"],document.ReceiveLoanedLinenForm["vo.loanLinenVO.receivedQty"],document.ReceiveLoanedLinenForm["vo.loanLinenVO.receivedBackBy"],document.ReceiveLoanedLinenForm["vo.loanLinenVO.givenBackBy"]);
		}else if(document.ReceiveLoanedLinenForm["vo.loanLinenVO.receivedWriteOff"].value == 'W'){
			var fieldName =new Array("com.iba.ehis.lc.receive/writeOff","com.iba.ehis.lc.receiveloanedlinen.receivedBackBy","com.iba.ehis.lc.receiveloanedlinen.givenBackBy");
			var fields =new Array(document.ReceiveLoanedLinenForm["vo.loanLinenVO.receivedWriteOff"],document.ReceiveLoanedLinenForm["vo.loanLinenVO.receivedBackBy"],document.ReceiveLoanedLinenForm["vo.loanLinenVO.givenBackBy"]);
		}
		
		var key_value=new Array();
	 	for(j=0;j<fieldName.length;j++)
	 	{
	 		if(fields[j].value=="")
			{		 	
		 		getServerMessage(fieldName[j]);
		 		key_value[j]=dwrMessage;
				getServerMessage("message.cannot.blank");
				msg=dwrMessage;
		 		msgArray=msg.split('#');
		 		error=error +msgArray[0]+ key_value[j] + " " + msgArray[1] +"<br>";
		 		flag=false;
	 		}
		}
	 	
	//	messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
		if(flag==false) return false; else return true;
	
	}
	
// *******************************************************************************************************
</script>
<body onload="assignVal();">
	<ibaHTML:form action="/LoanLinenAction.do" target="messageFrame">
		<table border='0 ' cellpadding='2' cellspacing='0' width='100%' align='center'>
		<tr>
				<td>
					&nbsp;
				</td><td>
					&nbsp;
				</td><td>
					&nbsp;
				</td><td>
					&nbsp;
				</td>
			</tr>
			<tr>
				<td align="right" class='label'>
					<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.ref.Num" bundle="lcLabels" />
				</td>
				<td>
					<ibaHTML:text property="vo.loanLinenVO.loanRefNum"
						maxlength="10" size="10" readonly="true" />
					<ibaHTML:link linkName="a" />
				</td>
				<td align="left" class='label'>
					<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.loanDate"
						bundle="lcLabels" />
					<ibaHTML:IBACalendarInput
						property="vo.loanLinenVO.loanDate" maxlength="16"
						size="16" readonly="true"></ibaHTML:IBACalendarInput>
					<ibaHTML:hidden property="vo.loanLinenVO.loanDate" />
				</td>
				<td></td>
			</tr>
		<tr>
			<td align="right" class='label'>
				<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.source" bundle="lcLabels" />
					</td>
					<td>
						<ibaHTML:text property="vo.loanLinenVO.sourceType" maxlength="10" size="10" readonly="true"/>
							<ibaHTML:hidden property="vo.loanLinenVO.sourceType" />
							<ibaHTML:text property="vo.loanLinenVO.sourceCode" maxlength="30" size="30" readonly="true"/>
							<ibaHTML:hidden property="vo.loanLinenVO.sourceCode" />
						</td>
						<td>
					</td>
				<td></td>
				</tr>
			<tr>
				<td align="right" class='label'>
					<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.loanedTo" bundle="lcLabels" />
				</td>
				<td>
					<ibaHTML:hidden property="vo.loanLinenVO.loanedToSourceType" />
					<ibaHTML:text property="vo.loanLinenVO.loanedToSourceType" maxlength="10" size="10" readonly="true"/>
					<ibaHTML:text property="vo.loanLinenVO.loanedToSourceCode" maxlength="30" size="30" readonly="true"/>
					<ibaHTML:hidden property="vo.loanLinenVO.loanedToSourceCode" />
				</td>
				<td></td>
				<td></td>
				</tr>
				<tr >
					<td  align="right" class='label'>
						<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.givenBy" bundle="lcLabels" />
					</td>
					<td>
					 <ibaHTML:text property="vo.loanLinenVO.givenBy"  maxlength="30" size="30" readonly="true"/>
					  <ibaHTML:hidden property="vo.loanLinenVO.givenBy"/>
						
				</td><td>
				</td><td>
				</td>
			</tr>	
			<tr>
				<td align="right" class='label'>
					<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.receivedBy" bundle="lcLabels" />
				</td>
				<td >
					<ibaHTML:text property="vo.loanLinenVO.receivedBy" maxlength="30" size="30" readonly="true"/>
					<ibaHTML:hidden property="vo.loanLinenVO.receivedBy"/>
				</td>
					<td>
					</td><td>
				</tr>
				<tr>
				<td align="right" class='label'>
					<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.reasonForLoan" bundle="lcLabels" />
				</td>
				<td >
					<ibaHTML:text property="vo.loanLinenVO.reasonforLoan" maxlength="100" size="30" readonly="true"/>
					<ibaHTML:hidden property="vo.loanLinenVO.reasonforLoan"/>
				</td>					
				<td>
				</td>
				<td></td>
				</tr>
				
				<tr>
				<td align="right" class='label'>
					<ibaBean:message key="com.iba.ehis.lc.remark" bundle="lcLabels" />
				</td>
					<td >
						<ibaHTML:text property="vo.loanLinenVO.remarks" maxlength="100" size="30" readonly="true"/>
						<ibaHTML:hidden property="vo.loanLinenVO.remarks"/>
					</td>
			<td></td>
			<td></td>
			</tr>
			</table>
			<table border='0 ' cellpadding='2' cellspacing='0' width='100%' align='center'>
			<tr>
				<td>
					&nbsp;
				</td><td>
					&nbsp;
				</td><td>
					&nbsp;
				</td><td>
					&nbsp;
				</td>
		</tr>
			<tr>
				<th align="left" colspan='4' >
					<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.loanReceiptDetails" bundle="lcLabels" />
				</th>
				<tr>
				<td>
					&nbsp;
				</td><td>
					&nbsp;
				</td><td>
					&nbsp;
				</td><td>
					&nbsp;
				</td>
		</tr>
			<tr>
				<td align="right" class='label'>
					<ibaBean:message key="com.iba.ehis.lc.receive/writeOff" bundle="lcLabels" />
					</td>
						<td>
							<ibaHTML:select property="vo.loanLinenVO.receivedWriteOff" onchange="receivedQtyStatus();">
								<ibaHTML:option value="R"><ibaBean:message key="com.iba.ehis.lc.receive" bundle="lcLabels" />
								</ibaHTML:option>
								<ibaHTML:option value="W"><ibaBean:message key="com.iba.ehis.lc.writeOff" bundle="lcLabels" />
								</ibaHTML:option>
							</ibaHTML:select>
							<img src="framework/images/mandatory.gif"></img>
						<td>
					</td>
				<td></td>
			</tr>	
			
			<tr>
				<td align="right" class='label'>
					<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.receivedQty" bundle="lcLabels" />
				</td>
				<td>
					<ibaHTML:text property="vo.loanLinenVO.receivedQty" maxlength="5" size="5" onkeypress="checkQty(this);"/>
					<img src="framework/images/mandatory.gif"  name="hide" style = "visibility:visible"></img>
				</td>
					<td>
					</td><td>
				</tr>
				<tr>
				<td align="right" class='label'>
					<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.receivedBackBy" bundle="lcLabels" />
					</td><td>
					<ibaHTML:text property="vo.loanLinenVO.receivedBackBy" maxlength="30" size="30" />
					<img src="framework/images/mandatory.gif"></img>
				</td>
					<td>
					</td><td>
				</tr>
				<tr>
				<td align="right" class='label'>
					<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.givenBackBy" bundle="lcLabels" />
					</td><td>
					<ibaHTML:text property="vo.loanLinenVO.givenBackBy" maxlength="30" size="30" />
					<img src="framework/images/mandatory.gif"></img>
				</td>
					<td>
					</td><td>
				</tr>
				<tr>
				<td>
					&nbsp;
				</td><td>
					&nbsp;
				</td><td>
					&nbsp;
				</td><td>
					&nbsp;
				</td>
			</tr>
				<tr>
					<td colspan="4" align='center'>

						<input class="BUTTON" type="button" name="Submit1" id="Submit1" value="<ibaBean:message key="com.iba.ehis.lc.cancel" bundle="lcLabels" />" onclick="submitFormNullCheck();"/>
					</td>
				</tr>
				<tr>
				<td>
					&nbsp;
				</td><td>
					&nbsp;
				</td><td>
					&nbsp;
				</td><td>
					&nbsp;
				</td>
		</tr>	
		</table>

		<ibaHTML:hidden property="vo.operatingFacilityId" value="<%=facilityId%>" />
						
		<ibaHTML:hidden property="vo.functionId" value="<%=functionId%>" />
	
		<ibaHTML:hidden property="vo.moduleId" value="<%=moduleId%>" />
		<ibaHTML:hidden property="vo.moduleId" value="LC" />
		<ibaHTML:hidden property="vo.mode"/>
			<ibaHTML:hidden property="method" value='2'/>
								
	</ibaHTML:form>
</body>
</ibaHTML:html>

