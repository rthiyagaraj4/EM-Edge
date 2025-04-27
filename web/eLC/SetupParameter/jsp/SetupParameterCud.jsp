<!DOCTYPE html>
<%@ page language="java" import="java.util.*,com.iba.framework.core.vo.UserPreferences,com.iba.framework.cache.pojo.business.Cache,com.iba.framework.cache.pojo.business.CacheManager,com.iba.framework.core.util.Constants,com.iba.framework.core.util.IBADate" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page  import="com.iba.framework.core.util.Constants"%>
<%@ include file="/framework/html/Tag.text"%>
<html>
<head>
<%			
			String functionId=(String)request.getParameter("functionId");
			String moduleId=(String)request.getParameter("moduleId");
			
			String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
			:"IeStyle.css" ;
			if(sStyle==null)sStyle="IeStyle.css";
				
%>
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>'></link>
<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>
<Script Language="JavaScript" src="framework/js/common.js"></Script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/IBADateValidator.js'></script>
<Script Language="JavaScript" src="framework/js/validations.js"></Script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/framework/js/PopupWindow.js"></script>
<Script Language="JavaScript" src="<%=request.getContextPath()%>/framework/js/common.js"></Script>
<Script Language="JavaScript" src="<%=request.getContextPath()%>/framework/js/validations.js"></Script>
<Script Language="JavaScript" src="<%=request.getContextPath()%>/eLC/SetupParameter/js/SetupParameter.js"></Script>
 <IBATagLibs:initCalendar />
</head>
	<body onload="showCutOffRows()" OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
	
		<br>
		<ibaHTML:form action="/SetupParameterAction.do" target="messageFrame" >
		<table border='1' cellpadding='2' cellspacing='0' width='75%' bordercolor="#9999FF" align='center' >
		<tr>
		<th align="left" colspan='2' >
		<ibaBean:message key="com.iba.ehis.lc.setUpParameter.linenDeliveryTimes" bundle="lcLabels" />
		</th>
		</tr>
		<tr>
		<td class='label' nowrap width='50%'>
		<ibaBean:message key="com.iba.ehis.lc.setUpParameter.noOfCut-OffTiming" bundle="lcLabels" />
		<ibaHTML:select property="vo.noOfcutOfTimings" onchange="showCutOffRows()" >
							<ibaHTML:option value=""><ibaBean:message key="com.iba.ehis.lc.select" bundle="lcLabels" />
							</ibaHTML:option>
							<ibaHTML:option value="0"><ibaBean:message key="com.iba.ehis.lc.setUpParameter.notApplicable" bundle="lcLabels" />
							</ibaHTML:option>
							<ibaHTML:option value="2">2
							</ibaHTML:option>
							<ibaHTML:option value="3">3
							</ibaHTML:option>
						</ibaHTML:select>

		</td>
		<td>
		<div id="headerLabel" class='label' >
		<ibaBean:message key="com.iba.ehis.lc.setUpParameter.deliveryDateForCleaning" bundle="lcLabels" />
		</div>
		</td>
		</tr>
		<tr>
		<td colspan='2'>
		<table cellpadding='2'width='100%' cellspacing='0' align='center' bordercolor="#9999FF"   >

				<tr>
					<td class='label' colspan='2' align="left">
						<ibaBean:message key="com.iba.ehis.lc.setUpParameter.cut-OffTimeForAcceptance"
							bundle="lcLabels" />
					</td>
					<td rowspan="4" background="#9999FF">
					
					</td>
					<td class='label' colspan='2' align="center">
						<ibaBean:message key="com.iba.ehis.lc.setUpParameter.cut-OffTimeForDelivery"
							bundle="lcLabels" />
					</td>
					
				</tr>
				<tr id="row1">
					<td class='label' width="5%">1.</td>
					<td width="45%">
						<input type="text" name="cutOffTimeForLinRecptFr" id="cutOffTimeForLinRecptFr"  value="00:00" onblur="verify(this);" size="6" readonly/>
						<input type="text" name="cutOffTimeForLinenRecpt" id="cutOffTimeForLinenRecpt" size="6" onblur="verify(this);getTime1();"/>
						<ibaHTML:hidden property="vo.cutOffTimeForLinRecptFr" />
						<ibaHTML:hidden property="vo.cutOffTimeForLinRecptFr.pattern" value="dd/MM/yyyy HH:mm" />
						<ibaHTML:hidden property="vo.cutOffTimeForLinRecptTo" />
						<ibaHTML:hidden property="vo.cutOffTimeForLinRecptTo.pattern" value="dd/MM/yyyy HH:mm" />
						
					</td>
					
					<td  nowrap align="right">
						<select name="cutOfDaysForLinenDelv" id="cutOfDaysForLinenDelv"  onchange="showDayNo();getTime1()">
							<option value=""><ibaBean:message key="com.iba.ehis.lc.select" bundle="lcLabels" />
							</option>
							<option value="0"><ibaBean:message key="com.iba.ehis.lc.setUpParameter.sameDay" bundle="lcLabels" />
							</option>
							<option value="1"><ibaBean:message key="com.iba.ehis.lc.setUpParameter.nextDay" bundle="lcLabels" />
							</option>
							<option value="2"><ibaBean:message key="com.iba.ehis.lc.setUpParameter.after" bundle="lcLabels" /> 
							</option>
						</select>
						<input type="text" name="dayNo" id="dayNo" maxlength='2' size='2' onblur="setDayNo(this)" onkeyup="checkNumber(this);"/> 
						<ibaHTML:hidden property="vo.cutOfDaysForLinenDelv"/>
					</td>
					<td >
						
						<input type="text" name="cutOffTimeForLinenDelv" id="cutOffTimeForLinenDelv" size="6" onblur="if(verify(this)){getTime1();validateDate(0)}" />
						<ibaHTML:hidden property="vo.cutOffTimeForLinenDelv" />
						<ibaHTML:hidden property="vo.cutOffTimeForLinenDelv.pattern" value="dd/MM/yyyy HH:mm" />
					</td>
				</tr>
				<tr id="row2">
					<td class='label' width="5%">2.</td>
					<td width="45%">
						<input type="text" name="cutOffTimeForLinRecpt2Fr" id="cutOffTimeForLinRecpt2Fr" onblur="verify(this);" size="6" readonly/>
						
						<input type="text" name="cutOffTimeForLinenRecpt2" id="cutOffTimeForLinenRecpt2" size="6" onblur="if(verify(this)){getTime2();checkReceipt(this)}" />
						<ibaHTML:hidden property="vo.cutOffTimeForLinRecpt2Fr" />
						<ibaHTML:hidden property="vo.cutOffTimeForLinRecpt2Fr.pattern" value="dd/MM/yyyy HH:mm" />
						<ibaHTML:hidden property="vo.cutOffTimeForLinRecpt2To" />
						<ibaHTML:hidden property="vo.cutOffTimeForLinRecpt2To.pattern" value="dd/MM/yyyy HH:mm" />
						
					</td>
					
					<td  nowrap align="right">
						<select name="cutOfDaysForLinenDelv2" id="cutOfDaysForLinenDelv2"  onchange="showDayNo2();getTime2()">
							<option value=""><ibaBean:message key="com.iba.ehis.lc.select" bundle="lcLabels" />
							</option>
							<option value="0"><ibaBean:message key="com.iba.ehis.lc.setUpParameter.sameDay" bundle="lcLabels" />
							</option>
							<option value="1"><ibaBean:message key="com.iba.ehis.lc.setUpParameter.nextDay" bundle="lcLabels" />
							</option>
							<option value="2"><ibaBean:message key="com.iba.ehis.lc.setUpParameter.after" bundle="lcLabels" /> 
							</option>
						</select>
						<input type="text" name="dayNo2" id="dayNo2" size='2' maxlength='2' onblur="setDayNo(this)" onkeyup="checkNumber(this);"/> 
						<ibaHTML:hidden property="vo.cutOfDaysForLinenDelv2"/>
					</td>
					<td >
						
						<input type="text" name="cutOffTimeForLinenDelv2" id="cutOffTimeForLinenDelv2" size="6" onblur="if(verify(this)){getTime2(); validateDate(1);checkDelivery(this)}"/>
						<ibaHTML:hidden property="vo.cutOffTimeForLinenDelv2" />				
						<ibaHTML:hidden property="vo.cutOffTimeForLinenDelv2.pattern" value="dd/MM/yyyy HH:mm" />	
					</td>
				</tr>
				<tr id="row3">
					<td class='label' width="5%">3.</td>
					<td width="45%">
						<input type="text" name="cutOffTimeForLinRecpt3Fr" id="cutOffTimeForLinRecpt3Fr" onblur="verify(this);" size="6" readonly/>

						<input type="text" name="cutOffTimeForLinenRecpt3" id="cutOffTimeForLinenRecpt3" size="6" readonly onblur="if(verify(this)){getTime3();checkReceipt(this)}" />
						<ibaHTML:hidden property="vo.cutOffTimeForLinRecpt3To" />
						<ibaHTML:hidden property="vo.cutOffTimeForLinRecpt3To.pattern" value="dd/MM/yyyy HH:mm" />
						<ibaHTML:hidden property="vo.cutOffTimeForLinRecpt3Fr" />
						<ibaHTML:hidden property="vo.cutOffTimeForLinRecpt3Fr.pattern" value="dd/MM/yyyy HH:mm" />
						
					</td>
					
					<td  nowrap align="right">
						<select name="cutOfDaysForLinenDelv3" id="cutOfDaysForLinenDelv3"  onchange="showDayNo3();getTime3()">
							<option value=""><ibaBean:message key="com.iba.ehis.lc.select" bundle="lcLabels" />
							</option>
							<option value="0"><ibaBean:message key="com.iba.ehis.lc.setUpParameter.sameDay" bundle="lcLabels" />
							</option>
							<option value="1"><ibaBean:message key="com.iba.ehis.lc.setUpParameter.nextDay" bundle="lcLabels" />
							</option>
							<option value="2"><ibaBean:message key="com.iba.ehis.lc.setUpParameter.after" bundle="lcLabels" /> 
							</option>
						</select>
						<input type="text" name="dayNo3" id="dayNo3" size='2' maxlength='2' onblur="setDayNo(this)" onkeyup="checkNumber(this);"/>
						<ibaHTML:hidden property="vo.cutOfDaysForLinenDelv3"/>
					</td>
					<td >
						
						<!-- <ibaHTML:IBACalendarInput property="vo.cutOffTimeForLinenDelv"  format=" %H:%M"  /> -->
						<input type="text" name="cutOffTimeForLinenDelv3" id="cutOffTimeForLinenDelv3" size="6" onblur="if(verify(this)){getTime3();validateDate(2);checkDelivery(this)}" />
						<ibaHTML:hidden property="vo.cutOffTimeForLinenDelv3" />				
						<ibaHTML:hidden property="vo.cutOffTimeForLinenDelv3.pattern" value="dd/MM/yyyy HH:mm" />
					</td>
				</tr>
			
				</table>
				</td>
				
				</tr>
				</table>
				<br>
				<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center' >
				<tr>
					<td  class='label'>
						<ibaBean:message key="com.iba.ehis.lc.setUpParameter.dirtyLinen"
							bundle="lcLabels" />
					</td>
					<td width="50%">
						
						<ibaHTML:checkbox property="vo.dirtyLinenEntryByLaundry" value="Y" />
						
						<ibaLogic:equal value="Y" property="vo.dirtyLinenEntryByLaundry" name="SetupParameterForm">
							<script type="text/javascript">
							document.getElementById("vo.dirtyLinenEntryByLaundry").checked=true
							</script>
						</ibaLogic:equal>
						
					</td>
				</tr>
				<tr>
					<td  class='label'>
						<ibaBean:message key="com.iba.ehis.lc.setUpParameter.confirmDirtyLinen"
							bundle="lcLabels" />
					</td>
					<td width="50%">
						
						<ibaHTML:checkbox property="vo.confReqdForDirtyLinen" value="Y" />
						
						<ibaLogic:equal value="Y" property="vo.confReqdForDirtyLinen" name="SetupParameterForm">
							<script type="text/javascript">
							document.getElementById("vo.confReqdForDirtyLinen").checked=true
							</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

						</ibaLogic:equal>
						
					</td>
				</tr>
				<tr>
					<td class='label'>
						<ibaBean:message key="com.iba.ehis.lc.setUpParameter.allowLinenThanStock"
							bundle="lcLabels" />
					</td>
					<td width="50%">
						<ibaHTML:select property="vo.stdStockChk" >
							<ibaHTML:option value=""><ibaBean:message key="com.iba.ehis.lc.select" bundle="lcLabels" />
							</ibaHTML:option>
							<ibaHTML:option value="A"><ibaBean:message key="com.iba.ehis.lc.setUpParameter.allow" bundle="lcLabels" />
							</ibaHTML:option>
							<ibaHTML:option value="S"><ibaBean:message key="com.iba.ehis.lc.setUpParameter.stop" bundle="lcLabels" />
							</ibaHTML:option>
							<ibaHTML:option value="T"><ibaBean:message key="com.iba.ehis.lc.setUpParameter.alert" bundle="lcLabels" />
							</ibaHTML:option>
						</ibaHTML:select>
						<img src='framework/images/mandatory.gif'></img>
					</td>
				</tr>
			</table>
			<ibaHTML:hidden property="method"/>
			<ibaHTML:hidden property="vo.functionId" value="<%=functionId%>"/>
			<ibaHTML:hidden property="vo.moduleId" value="<%=moduleId%>"/>
			</ibaHTML:form>
	</body>
	<script>
	getTime();
	hidedayNo();
	defaultDayStatus();
	</script>
</html>


