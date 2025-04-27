<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page  import="com.iba.framework.core.util.Constants"%>
<%@ include file="/framework/html/Tag.text"%>
<html>
<head>
<%			
			String functionId=(String)request.getParameter("functionId");
			String moduleId=(String)request.getParameter("moduleId");
			String locale=(String)session.getAttribute("LOCALE");
			String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
			:"IeStyle.css" ;
			if(sStyle==null)sStyle="IeStyle.css";  
%>
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>' />
<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>

<Script Language="JavaScript" src="<%=request.getContextPath()%>/framework/js/common.js"></Script>
<Script Language="JavaScript" src="<%=request.getContextPath()%>/framework/js/validations.js"></Script>
<script type='text/javascript'	src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
<script type='text/javascript'	src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
<script type='text/javascript'	src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
<script type='text/javascript'	src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
<script Language="JavaScript" src="<%=request.getContextPath()%>/eLC/LinenItem/js/LinenItem.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/framework/js/PopupWindow.js"></script>

<Script>
var  testpopup5="";
var val="";

function setval()
{
val=document.getElementById("washingInstr").value;
document.getElementById("vo.washingInstructions").value=val;
}
function checkLength()
{
var Tvalue=0;
obj=document.getElementById("washingInstr");
Tvalue=textAreaLimit(obj,2000);
document.getElementById("vo.washingInstructions").value=Tvalue;
}
function test5popupactivate(anchor) {
if(testpopup5=="")
{
 testpopup5 = new PopupWindow();
}
val=document.getElementById("vo.washingInstructions").value;
document.getElementById("washingInstr").value=val;
testpopup5.height=200;
testpopup5.width=300;
testpopup5.offsetX=-10;
testpopup5.offsetY=10;
testpopup5.windowProperties="toolbar=no,location=no,status=no,menubar=no,scrollbars=auto,resizable=no,alwaysRaised,dependent,titlebar=no";
testpopup5.autoHide();
testpopup5.noResize=true;
testpopup5.populate('<title><ibaBean:message key="com.iba.ehis.lc.washingInstr" bundle="lcLabels" /></title><link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>"></link><FORM><CENTER><table border="0" celpadding="0" cellspacing="0" width="100%" height="100%"><tr><td class="label" align="center"> <ibaBean:message key="com.iba.ehis.lc.washingInstr" bundle="lcLabels" />: </td></tr><tr><td  align="center"><textarea rows=5 cols=40 id="Instr"  name="washingInstr" onkeyup="window.opener.document.getElementById("washingInstr").value=this.value;window.opener.setval();window.opener.checkLength();">'+val+'</textarea></td></tr><tr><td  align="center"><input class="button" type="button" onclick="window.close();window.opener.setval()" value="OK"/></td></tr></table> </FORM></CENTER>');
testpopup5.showPopup(anchor);
setval();
}

 
</Script>
</head>
	<body onload="disable();" OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
	
		<br>
		<ibaHTML:form action="/LinenItemAction.do" target="messageFrame" >
			<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
				<tr>
					<td align="right" class='label'>
						<ibaBean:message key="com.iba.ehis.lc.linenItem"
							bundle="lcLabels" />
					</td>
					<td>
						<ibaHTML:text property="vo.linenItem" size="6" maxlength="4" onkeyup="setFieldsToUpperCase(this)" onkeypress="return checkAlphaNum()"/>
						<img src='framework/images/mandatory.gif'></img>
					</td>
				</tr>
				<tr>
					<td align="right" class='label'>
						<ibaBean:message key="com.iba.ehis.lc.longDesc"
							bundle="lcLabels" />
					</td>
					<td>
						<ibaHTML:text property="vo.longDesc" size="35" maxlength="30" />
						<img src='framework/images/mandatory.gif'></img>
					</td>
				</tr>
				<tr>
					<td align="right" class='label'>
						<ibaBean:message key="com.iba.ehis.lc.shortDesc"
							bundle="lcLabels" />
					</td>
					<td>
						<ibaHTML:text property="vo.shortDesc" size="15" maxlength="15" />
						<img src='framework/images/mandatory.gif'></img>
					</td>
				</tr>
								<tr>
					<td align="right" class='label'>
						<ibaBean:message key="com.iba.ehis.lc.linenType"
							bundle="lcLabels" />
					</td>
				
					<td>
						<ibaHTML:select property="vo.linenType.linenTypeCode" >
							<ibaHTML:option value="">
						<ibaBean:message key="com.iba.ehis.lc.select"
							bundle="lcLabels" />
							</ibaHTML:option>
						<ibaHTML:optionsCollection property="vo.linenMap" label="value" value="key" />
						</ibaHTML:select>
						<img src='framework/images/mandatory.gif'></img>
					</td>
				</tr>
				<tr>
					<td align="right" class='label'>
						<ibaBean:message key="com.iba.ehis.lc.disposableItem"
							bundle="lcLabels" />
					</td>
					<td>
						
						<ibaHTML:checkbox property="vo.disposable" value="Y" />
						
						<ibaLogic:equal value="Y" property="vo.disposable" name="LinenItemForm">
							<script type="text/javascript">
							<!--
									document.getElementById("vo.disposable").checked=true
							//-->
							</script>
						</ibaLogic:equal>
						
					</td>
				</tr>
				<tr>
					<td align="right" class='label'>
						<ibaBean:message key="com.iba.ehis.lc.status"
							bundle="lcLabels" />
					</td>
					<td>
						
						<ibaHTML:checkbox property="vo.effStatus" value="E" />
						
						<ibaLogic:equal value="E" property="vo.effStatus" name="LinenItemForm">
							<script type="text/javascript">
							<!--
									document.getElementById("vo.effStatus").checked=true
							//-->
							</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

						</ibaLogic:equal>
						
					</td>
				</tr>
				<tr>
				<td colspan=4 align="right" class="label">

				<ibaLogic:equal value="2" property="method" name="LinenItemForm">
				<ibaLogic:equal value="E" property="vo.effStatus" name="LinenItemForm">
				<a href="javascript:popUpInstructions()" onclick="test5popupactivate(this.id);return false;" name="prepAnchor" id="prepAnchor">
						<ibaBean:message key="com.iba.ehis.lc.washingInstr" bundle="lcLabels" /></a>
						<input type="hidden" name="washingInstr" id="washingInstr" value="" maxlength="2000"/>
						<ibaHTML:hidden property="vo.washingInstructions"/>
				</ibaLogic:equal>
				<ibaLogic:equal value="D" property="vo.effStatus" name="LinenItemForm">
				<ibaBean:message key="com.iba.ehis.lc.washingInstr" bundle="lcLabels"/>
				</ibaLogic:equal>
				</ibaLogic:equal>

				<ibaLogic:equal value="0" property="method" name="LinenItemForm">
				<a href="javascript:popUpInstructions()" onclick="test5popupactivate(this.id);return false;" name="prepAnchor" id="prepAnchor">
				<ibaBean:message key="com.iba.ehis.lc.washingInstr" bundle="lcLabels" /></a>
				<input type="hidden" name="washingInstr" id="washingInstr" value="" maxlength="2000"/>
				<ibaHTML:hidden property="vo.washingInstructions"/>
				</ibaLogic:equal>
				</td>
			</tr>
				
			</table>
			<ibaHTML:hidden property="method"/>
			<ibaHTML:hidden property="style" value="<%=sStyle %>"/>

			<ibaHTML:hidden property="vo.functionId" value="<%=functionId%>"/>
			<ibaHTML:hidden property="vo.moduleId" value="<%=moduleId%>"/>
			<ibaHTML:hidden property="vo.locale" value="<%=locale%>"/>
		</ibaHTML:form>
	</body>
</html>


