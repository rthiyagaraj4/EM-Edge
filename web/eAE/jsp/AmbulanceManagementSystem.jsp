<!DOCTYPE html>
<%try{%>
<%@include file="AmbulanceManagementSystemCode.jsp"%>
<%@page errorPage="AmbulanceManagementSystemError.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<link rel="stylesheet" type ="text/css" href="../../eAE/html/fonts-min.css"></link>
	<link rel="stylesheet" type ="text/css" href="../../eAE/html/button.css"></link>
	<link rel="stylesheet" type ="text/css" href="../../eAE/html/stdbutton.css"></link>
	<link rel="stylesheet" type ="text/css" href="../../eAE/html/menu.css"></link>
	<link rel="stylesheet" type ="text/css" href="../../eAE/html/datatable.css"></link>
	<link rel="stylesheet" type ="text/css" href="<%=request.getContextPath()%>/eAE/html/AmbulanceManagementSystem.css"></link>
	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<link rel="stylesheet" type ="text/css" href='../../eAE/html/autocomplete.css'></link>
 	<link rel="stylesheet" type ="text/css" href='../../eAE/html/container.css'></link>
	<link rel="stylesheet" type ="text/css" href='../../eAE/html/container-skin.css'></link> 
	<link rel="stylesheet" type ="text/css" href='../../eAE/html/skin.css'></link> 
	<link rel="stylesheet" type="text/css" href="../../eAE/html/keyboard.css"> </link> 
	<link rel="stylesheet" type="text/css" href="../../eAE/html/paginator.css"> </link> 

	<script type="text/javascript" src="../../eAE/js/keyboard.js" charset="UTF-8"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>	
	<Script language="JavaScript" src="../../eCommon/js/CommonLookup.js" ></Script>
	<Script language="JavaScript" src="../../eCommon/js/common.js" ></Script>
	<Script language="JavaScript" src="../../eCommon/js/dchk.js" ></Script>
	<Script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js" ></Script>
	
	<script src='../../eAE/js/yahoo-dom-event.js' language='javascript'></script>
	<script src='../../eAE/js/connection-min.js' language='javascript'></script>
	<script src='../../eAE/js/element-min.js' language='javascript'></script>	
	<script src='../../eAE/js/container-min.js' language='javascript'></script>
    <script src='../../eAE/js/menu-min.js' language='javascript'></script>
	<script src='../../eAE/js/dragdrop-min.js' language='javascript'></script>
	<script src='../../eAE/js/datasource-min.js' language='javascript'></script> 
	<script src='../../eAE/js/datatable-min.js' language='javascript'></script>  
  	<script src='../../eAE/js/animation-min.js' language='javascript'></script>	
	<script src='../../eAE/js/autocomplete-min.js' language='javascript'></script>
	<script src='../../eAE/js/button-min.js' language='javascript'></script>	
	<script src='../../eAE/js/paginator-min.js' language='javascript'></script>	
	<script src='../../eAE/js/json-min.js' language='javascript'></script>	
	<script src='../../eAE/js/event-min.js' language='javascript'></script>	
	<script src='../../eAE/js/yahoo-min.js' language='javascript'></script>	
	<script src='../../eAE/js/get-min.js' language='javascript'></script>	


	<script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></script>
	<script src='../../eAE/js/AmbulanceManagementSystem.js' language='javascript'></script>
	
	
	<style>
	.yui-simple-dialog .bd span.warnicon {
    background: url("../../eAE/images/warn16_1.gif") no-repeat;
	}	


	</style>

</head>
<script type="text/javascript">

YAHOO.namespace("yuiData.StaticList"); 
YAHOO.yuiData.StaticList.sex = ["Male", "Female","Unknown"];
YAHOO.yuiData.StaticList.priority= ["Low", "Medium", "High"];
YAHOO.yuiData.StaticList.period= ["Hours", "Days"];
YAHOO.yuiData.StaticList.tripStatus1= ["Cancelled", "Completed"];
YAHOO.yuiData.StaticList.tripStatus2= ["Cancelled"];


YAHOO.widget.DataTable.prototype.getTdEl = function(cell) {
	var Dom = YAHOO.util.Dom,lang = YAHOO.lang,elCell,el = Dom.get(cell);
	// Validate HTML element
	if(el && (el.ownerDocument == document)) {
		// Validate TD element
		if(el.nodeName.toLowerCase() != "td") {
			// Traverse up the DOM to find the corresponding TR element
			elCell = Dom.getAncestorByTagName(el, "td");
		}else {
			elCell = el;
		}
		
		// Make sure the TD is in this TBODY
		if(elCell && (elCell.parentNode.parentNode == this._elTbody)) {
			// Now we can return the TD element
			return elCell;
		}
	}else if(cell) {
		var oRecord, nColKeyIndex;
		
		if(lang.isString(cell.columnKey) && lang.isString(cell.recordId)) {
			oRecord = this.getRecord(cell.recordId);
			var oColumn = this.getColumn(cell.columnKey);
			if(oColumn) {
				nColKeyIndex = oColumn.getKeyIndex();
			}
		}
		if(cell.record && cell.column && cell.column.getKeyIndex) {
			oRecord = cell.record;
			nColKeyIndex = cell.column.getKeyIndex();
		}
		var elRow = this.getTrEl(oRecord);
		if((nColKeyIndex !== null) && elRow && elRow.cells && elRow.cells.length > 0) {
			return elRow.cells[nColKeyIndex] || null;
		}
	}
	return null;
};


</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	
	out.println("<script>");
	out.println("YAHOO.example.Data =  {ambReqstDataAll: {"+cellData+"}}");
	//out.println("YAHOO.example.Data1 = {ambReqstData:	{"+cellData+"}}");
	out.println("YAHOO.example.Data2 = {ambChartData:	{"+cellData2+"}}");
	out.println("var myColumnDefs = ["+clDef+"];");
	out.println("var myColumnDefs1 = ["+clDef1+"];");
	//if(!err_msg.equals("")) out.println("alert(unescape('"+err_msg.replace('+',' ')+"'));");
	out.println("</script>");

	
%>

<html>
<body class="yui-skin-sam" OnMouseDown='CodeArrest()' onload='getDfltValues()' onkeydown="tabOnEnterKey();lockKey()" > 

<div id="Layer1" class="main" > 
<form name="frmAmbMangmntSystem" id="frmAmbMangmntSystem"  action="..\..\servlet\eAE.AmbulanceManagementServlet" method='post'>
<input type='hidden' id='virtKeypadDisplayYn' name='virt_keypad_display_yn' id='virt_keypad_display_yn' value='N'>
<input type='hidden' id='virKeypadDispFldYn' name='virt_keypad_disp_fld_yn' id='virt_keypad_disp_fld_yn' value='N'>
<input type='hidden' id='mode' name='mode' id='mode' value='insert'>

<!----------------------------top-------------------------------------------------->
		<div id="Layer3" class="top">
			<table width="100%" height="100%"  border="0" cellpadding="0" cellspacing="0" valign="top">
				<tr class="SUB">
					<td >
						<table width="100%" height="100%"  border="0" cellpadding="0" cellspacing="0" valign="top">
							<tr height="4%"  valign="top" width="100%">
								<td align='left' id='keyPadId'>&nbsp;<input id='VkbImg' type='text' size=1  maxlength=1 class='img'></td>
								<td class="COLUMNHEADER" align="right" valign="center" width="97%"><b><fmt:message key="eAE.AmbulanceManagementDashboard.label" bundle="${ae_labels}"/></b>&nbsp;</td>
								<td class="COLUMNHEADER" align="right" valign="center" width="3%"><img onclick="reQueryPage('refresh')" alt='Refresh' src='../../eAE/images/Reset.gif'/><img onclick="goHomePage()" alt='Close' src='../../eAE/images/MI_Close.gif'></img></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div> <!------------------------End -top-------------------------------------------------->
		
			  <!----------------------------Left-------------------------------------------------->
		<div id="Layer5A" class="left-outer" align="left" valign="center">&nbsp;<b><fmt:message key="eAE.RequestedQueue.label" bundle="${ae_labels}"/></b> 
				<div id='fillerDiv'><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br></div>
			<div id="Layer5" class="left" style='display:inline'>

			<table border="0" width="100%" height="100%" cellpadding="0" cellspacing="0">
					<tr>
						<td colspan="2" valign="center" align="left" nowrap><input id="checkbutton1" type="checkbox" name="chkRqstd" id="chkRqstd" value="1" <%=manipulateCheckBox(reqFlag,"R")%>><label  class="label" style="background-color:#BBBBFF" ><fmt:message key="Common.Requested.label" bundle="${common_labels}"/></label></input>
						<input id="checkbutton2" type="checkbox" name="chkAssnd" id="chkAssnd" value="1" <%=manipulateCheckBox(asnFlag,"A")%>><label  class="label" style="background-color:#ECD9D9" ><fmt:message key="Common.Assigned.label" bundle="${common_labels}"/></label></input>
						<input id="checkbutton3" type="checkbox" name="chkCmpltd" id="chkCmpltd" value="1"  <%=manipulateCheckBox(comFlag,"C")%>><label  class="label" style="background-color:#DFFFDF" ><fmt:message key="Common.completed.label" bundle="${common_labels}"/></label></input>
						<input id="checkbutton4" type="checkbox" name="chkCancld" id="chkCancld" value="1" <%=manipulateCheckBox(canFlag,"X")%>><label style="background-color:#FAABC0" class="label" ><fmt:message key="Common.cancelled.label" bundle="${common_labels}"/></label></input>
						<label  class="label-blue" style="background-color:white;cursor:pointer" id="lblFromDate" onclick="showCalendar1('from_date',null,null,true,'lblFromDate','From','<%=from_date%>');return false;"><fmt:message key="Common.from.label" bundle="${common_labels}"/>:<%=from_date%></label>
                       <label class="label-blue" id="lblToDate" style="background-color:none;cursor:pointer" onclick="showCalendar1('to_date',null,null,true,'lblToDate','To','<%=to_date%>');return false;"><fmt:message key="Common.to.label" bundle="${common_labels}"/>:<%=to_date%></label>
						<input type='hidden' name='from_date' id='from_date' value='<%=from_date%>'/ >
						<input type='hidden' name='to_date' id='to_date' value='<%=to_date%>'/ >
						 
						 <td align='right' width='10%'><div id="menubuttonsfromjavascript" style="display:none">
						 </div>&nbsp;</td>
						 <td align='right' width='1%'>&nbsp;</td>
					</tr>
					<tr><td colspan="4">&nbsp;</td></tr>
					<tbody>
					<tr >	
						<td width="1%">&nbsp;</td>					
						<td  colspan="2" valign="top" align="left" ><div id="ambRequst" class="ambRequst" style="left:1%" style="display:inline"></div><div id="ambRequstAll" class="ambRequstAll" style="display:none" ></div>
						<table border = '0' width="95%" height="3%" cellpadding="0" cellspacing="0" >
						<tr id='search' style="background: #7D98B8 url('../../eAE/images/sprite.png') repeat-x 0 -1700px;" >
						<td   align="right"  class='label' valign='center' nowrap width="5%" style="background: #7D98B8 url('../../eAE/images/sprite.png') repeat-x 0 -1700px;"><fmt:message key="eAE.find.label" bundle="${ae_labels}"/>:</td><td  align="left"  valign='center' class='label' nowrap width="25%" style="background: #7D98B8 url('../../eAE/images/sprite.png') repeat-x 0 -1700px;"><input name="findText" id="findText" style="border : 1px normal #696969;font-size : 10px;font-family : Verdana;font-weight : normal;" type="text"   maxlength='30' size='35' value="<%=findText%>"></td><td   align="left"  valign='center' width="5%" nowrap class='label' style="background: #7D98B8 url('../../eAE/images/sprite.png') repeat-x 0 -1700px;"><div class=button onClick='find()' ><fmt:message key="Common.Go.label" bundle="${common_labels}"/></div></td>
						<td   valign='center' align="right" nowrap style="background: #7D98B8 url('../../eAE/images/sprite.png') repeat-x 0 -1700px;">&nbsp;<div id="dt-paginator" class="yui-skin-sam yui-pg-container" style="text-align:right"></div>
						<div id="dt-paginatorAll" class="yui-skin-sam yui-pg-container" style="display:none;text-align:right"></div></td></tr></table>
						</td>
						<td valign="center" align="left" width="1%" height="100%" nowrap><img id="imgleft" src="../../eAE/images/ADSRight.gif" onClick="expandHorizontaly('Layer5A','Layer6A','imgleft','right','1%','98%','1%','54%');"/></td>
					</tr>	
						</tbody>
				</table>
				<input type="hidden" name="pat_name" id="pat_name" value=""/>
				
			</div>
		</div>
	<!----------------------------End   Left----------------------------------------------->
	<!----------------------------Right-------------------------------------------------->
		<div id="Layer6A" class="right-outer" align="left" valign="center">&nbsp;<b><fmt:message key="eAE.AmbulanceChart.label" bundle="${ae_labels}"/></b>
		<div id='fillerDiv'><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br></div>
			<div id="Layer6" class="right" style='display:inline'>
			
			<table border="0" width="100%" height="100%" cellpadding="0" cellspacing="0">
<tr>
	<td width="3%">&nbsp;</td>
	<td  width="87%"><input id="checkbutton1" type="checkbox" name="ambAssnd" id="ambAssnd" value="1" <%=manipulateCheckBox(aFlag,"A")%>><label  class="label" style="background-color:#ECD9D9" ><fmt:message key="Common.Assigned.label" bundle="${common_labels}"/></label></input>
	<input id="checkbutton2" type="checkbox" name="ambMntnce" id="ambMntnce" value="1" <%=manipulateCheckBox(mFlag,"M")%> ><label style="background-color:#E1E1E1"  class="label" ><fmt:message key="eAE.maintenance.label" bundle="${ae_labels}"/></label></input>
	<input id="checkbutton3" type="checkbox" name="ambAvlble" id="ambAvlble" value="1" <%=manipulateCheckBox(bFlag,"B")%>><label style="background-color:#DFFFDF"  class="label"><fmt:message key="Common.available.label" bundle="${common_labels}"/></label></input>
	</td>
	<td align="right" width="10%"><span id='spnPrevNext'>
		<%if(AmbChartDetList.size()>84){%><img src="../../eAE/images/ADSprevious.gif" id='imgPrev' onClick="javascript:loadPage('chartPrev');" style="display:none" />
		<img src="../../eAE/images/ADSnext.gif" id='imgNext' onClick="javascript:loadPage('chartNext')" /><%}%>
	</span></td>
   <!-- <td align='right' class="button" onclick=";" onMouseOver='style.cursor="hand";title="Go"'>Go</td>-->
	
</tr>
<tr>
	<td width="3%">&nbsp;</td>
	<td colspan="2% width="97%" valign="top">
<!------------------------------------when div is in normal size----------------------------------->
	<div id="ambChartImage">

	<div id="ambChartImageAll"><!----------------showing all Ambulance----------------------->
	
	<%
	String imgSRC="",dragVal="",alignString="",disp="";
	char ambtype;
	int y=0,chPage=0;
	for(int i=0,j=1;i<AmbChartDetList.size();i+=14,j++){
		ambStatus=(String)AmbChartDetList.get(i+7);
		ambType=AmbChartDetList.get(i+10)==null?"@":(String)AmbChartDetList.get(i+10);
		ambtype=ambType.charAt(0);

		ambCaseNo=AmbChartDetList.get(i+11)==null?"":(String)AmbChartDetList.get(i+11);
		ambPatDet=AmbChartDetList.get(i+12)==null?"&nbsp;":(String)AmbChartDetList.get(i+12);

		dragVal=ambStatus+"~"+ambType+"~"+AmbChartDetList.get(i+2)+"~"+AmbChartDetList.get(i)+"~"+AmbChartDetList.get(i+1)+"~"+AmbChartDetList.get(i+8)+"~"+AmbChartDetList.get(i+9)+"~"+ambCaseNo+"~"+ambPatDet+"~"+AmbChartDetList.get(i+13);

		alignString=((j%2)==0)?"right":"left";

		 switch(ambtype){
			   case 'R':
				   imgSRC="style=\"background-image:url('../../eAE/images/Ambulance.gif');background-repeat: no-repeat\"";
					break;
				
				case 'M':
					imgSRC="style=\"background-image:url('../../eAE/images/boatambulance.gif');\"";
					 break;
				
				case 'A':
					imgSRC="style=\"background-image:url('../../eAE/images/airambulance.gif');\"";
					 break;
	
				default:
					 imgSRC="style=\"background-image:url('../../eAE/images/Ambulance.gif');\"";
					 break;
		}
		if(ambStatus.equals("B")){
			chartClass="ambchartB";
		}else if(ambStatus.equals("A")){
			chartClass="ambchartA";
		}else if(ambStatus.equals("M")){
			chartClass="ambchartM";
		}%>
	
	<%if(y%6==0){
		
	chPage++;
	if(y==0) disp="inline;";else disp="none;";
	%>
	<div id='divPage<%=chPage%>' style="display:<%=disp%>">
	<table border="0" width="100%" cellpadding="0" cellspacing="0">
	<tr>
	<%}%>

	<td valign="top" align="<%=alignString%>">
	<div id="ambChart<%=j%>" name="<%=dragVal%>"class="<%=chartClass%>" <%=imgSRC%> valign="top" ondblclick="loadAmbEntryDiv('<%=ambStatus%>','<%=ambType%>','<%=AmbChartDetList.get(i+2)%>','<%=AmbChartDetList.get(i)%>','<%=AmbChartDetList.get(i+8)%>','<%=AmbChartDetList.get(i+9)%>','<%=ambPatDet%>','<%=ambCaseNo%>','<%=AmbChartDetList.get(i+13)%>');" > 
	<div  class="chartText">
	<%if(!AmbChartDetList.get(i+9).equals(""))
			out.println(AmbChartDetList.get(i)+"<br>"+AmbChartDetList.get(i+2)+"<br>"+AmbChartDetList.get(i+13)+"<br>"+AmbChartDetList.get(i+8)+"("+AmbChartDetList.get(i+9)+")<br>"+ambPatDet);
	  else	
			out.println(AmbChartDetList.get(i)+"<br>"+AmbChartDetList.get(i+2)+"<br>"+AmbChartDetList.get(i+13)+"<br>"+AmbChartDetList.get(i+8)+"<br>"+ambPatDet);
	%></div>
	</div>
	<%
	if(!ambStatus.equals("M"))
			createDrggableObject("ambChart"+j,j,out);
	 %>
	</td>
	<%if((j%2)==0){%>
	</tr>
	<% if(j%6!=0){%><tr><%}%>
	
	<%}if(j%6==0 && y!=0  && AmbChartDetList.size()>84){%>
	</table>
	</div>
	<%
	}

	y++;}%>
	
	<%if(AmbChartDetList.size()%84!=0 || AmbChartDetList.size()<=84){%>
	</table>
	</div>
	<%}%>

	<input type="hidden" name="totPage" id="totPage" value="<%=chPage%>" />
	<input type="hidden" name="currPage" id="currPage" value="1" />

	</div><!-----------End of showing all Ambulance--------------------->

<div id="ambSatausB" style="display:none" style="background-color:ALICEBLUE;"> <!-----------Div for Status B--------------------->

<table border="0" width="100%" height="98%" cellpadding="0" cellspacing="0" >
<tr height="35%">
<td align="left" valign="top"><br>
<div id="ambSelAmbB" ></div>
</td>
</tr>
<tr height="55%">
<td valign="top">
<table border="0" width="100%" cellpadding="0" cellspacing="0" >
<th colspan="2" style="background-color:#CCCCCC"><fmt:message key="eAE.RecordUnderMaintenanceDetails.label" bundle="${ae_labels}"/></th>

<tr>
	<td width="25%" class="label"><fmt:message key="Common.currentlocation.label" bundle="${common_labels}"/></td>
	 <td width="75%">
	 
	 <!--<input type="text" class="text-box-nkb" size="40" id='txtCurrLocB' name="txtCurrLocB" id="txtCurrLocB" onfocus='assignCurEle(this)' /> -->
	 <div id="toLocnAutoComplete">
				<input id="txtCurrLocB" name='txtCurrLocB' id='txtCurrLocB' type="text" maxlength='60' value=''class=text-box onfocus='assignCurEle(this)'> 
				<input name="txtCurrLocB_code" id="txtCurrLocB_code" id="txtCurrLocB_code" type="hidden">
				<div id="currLocnBContainer"></div>
	</div>
	 
	 
	 </td>
 </tr>

 <tr>
	<td class="label"><fmt:message key="eAE.UnderRepair.label" bundle="${ae_labels}"/></td>
	 <td align="left"><input type="checkbox"  id='chkUnderRepairB' name="chkUnderRepairB" id="chkUnderRepairB"  onclick="toggleDiv(this,divRprDetB,underRepairB)"/>
	 <input type="hidden"  name="underRepairB" id="underRepairB" value="N"/>
	 </td>
 </tr>
</table>
<div id="divRprDetB" style="display:none">
<table border="0" width="100%" cellpadding="0" cellspacing="0" >
<tr>
	<td width="25%" class="label"><fmt:message key="Common.periodfrom.label" bundle="${common_labels}"/></td>
	 <td width="75%"><input type="text" class="text-box-mand-nkb" size='19'maxLength='19' onblur='if(!ChkDate(this) || this.value=="") Alert(getMessage("AE_AMB_DATE","AE"),"001");' id='txtprdFromB' name="txtprdFromB" id="txtprdFromB" > <img  class="img" align='ABSBOTTOM' src="../../eAE/images/Calendar.gif"  onClick="return showCalendar('txtprdFromB',null,'hh:mm',true);"></td>
 </tr>
 <tr>
	<td class="label"><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
	<td class="label">
   	<div id="periodAutoComplete">
	<input name="txtPeriodB" id="txtPeriodB" maxlength='3' type="text" class="text-box-mand-nkb" size="2" onfocus='assignCurEle(this)' id='txtPeriodB'>
				<input id="periodInput"  name="txtPeriodType" id="txtPeriodType" type="text" class=text-box-mand-nkb>
				<div id="periodContainer"></div>
	</div>
	</td>
</tr>
<!--<tr>
	<td class="label">Period To</td>
	 <td><input type="text" class="text-box-nkb" name="txtprdToA" id="txtprdToA" /> </td>
 </tr>-->
<tr>
	<td class="label"><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
	<td><textarea class='text-area' wrap=virtual id='txtRemarksB' name='txtRemarksB' maxlength='500'  onKeyPress='return CheckSpecChars(event);checkMaxLimit(this,500)' onBlur="makeValidString(this)" onkeyup='chopText(this,500)' onchange='chopText(this,500)' onfocus='assignCurEle(this)'></textarea></td>
</tr>

</table>
</div>
</td>
</tr>
<tr>
<td valign="bottom" align="right" colspan="2"><input type="button" id="btnRecB" name="btnRecord" id="btnRecord" value="Record" /><input type="button" name="btnClose" id="btnClose" value="Close" id="btnClB" onclick="closeEntryDiv('ambSatausB')"/></td>
</tr>
</table>
</div><!----------End of Div for Status B--------------------->

<div id="ambSatausM" style="display:none" style="background-color:ALICEBLUE;"><!----------Div for Status M--------------------->
<table border="0" width="100%" height="98%" cellpadding="0" cellspacing="0" >
<tr height="35%">
<td valign="top" align="left"><br>
<div id="ambSelAmbM" ></div>
</td>
</tr>
<tr height="55%">
<td valign="top">
<table border="0" width="100%" cellpadding="0" cellspacing="0" >
<th colspan="2" style="background-color:#CCCCCC"><fmt:message key="eAE.RevokeUnderMaintenanceDetails.label" bundle="${ae_labels}"/> </th>
<tr>
	<td width="25%" class="label"><fmt:message key="Common.currentlocation.label" bundle="${common_labels}"/></td>
	 <td width="75%">
	 
	

	  <div id="toLocnAutoComplete">
				<input id="txtCurrLocM" name='txtCurrLocM' id='txtCurrLocM' type="text" maxlength='60' value=''class=text-box onfocus='assignCurEle(this)'> 
				<input name="txtCurrLocM_code" id="txtCurrLocM_code" id="txtCurrLocM_code" type="hidden">
				<div id="currLocnMContainer"></div>
	</div>
	 	 
	 
	 </td>

	
 </tr>
<tr>
	<td class="label"><fmt:message key="Common.periodfrom.label" bundle="${common_labels}"/></td>
	 <td><input type="text" class="text-box-nkb" name="txtprdFromM" id="txtprdFromM" readonly/> </td>
</tr>
<tr>
	<td class="label"><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
	 <td><input name="txtPeriodM" id="txtPeriodM" type="text" class="text-box-mand-nkb" size="2" readonly>
		 <input name="txtPeriodTypeM" id="txtPeriodTypeM" type="text" size="5" class=text-box-nkb readonly> </td>
</tr>
<tr>
	<td class="label"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/> </td>
	<td><textarea class='text-area' wrap=virtual  readonly name='txtRemarksM' id="txtRemarksM" onfocus='assignCurEle(this)'></textarea> </td>
</tr>
<tr>
	<td class="label"><fmt:message key="eAE.RevokeMaintenance.label" bundle="${ae_labels}"/></td>
	 <td align="left"><input type="checkbox"  id="chkRevokeRepairM" onfocus='assignCurEle(this)' name="chkRevokeRepairM" id="chkRevokeRepairM" onclick="setValueForCheckbox(chkRevokeRepairM,RevokeRepairM)"/>
	 <input type="hidden"  name="RevokeRepairM" id="RevokeRepairM" value="N"/>
	 </td>
 </tr>
</table>
</td>
</tr>
<tr>
	<td align="right" valign="bottom"><input type="button" id="btnRecM" name="btnRecord" id="btnRecord" value="Record"/><input type="button" name="btnClose" id="btnClose" value="Close" id="btnClM" onclick="closeEntryDiv('ambSatausM')"/></td>
</tr>
</table>
</div><!----------End of Div for Status M--------------------->

<div id="ambSatausA" style="display:none" style="background-color:ALICEBLUE;"><!----------Div for Status A--------------------->
<table border="0" width="100%" height="98%" cellpadding="0" cellspacing="0" >
<tr height="30%">
<td align="left" valign="top">
<div id="ambSelAmbA" ></div>
</td>
</tr>
<tr height="60%">
<td valign="top">
<table border="0" width="100%" cellpadding="0" cellspacing="0" >
<th colspan="4" style="background-color:#CCCCCC"><fmt:message key="eAE.UpdateAmbulanceStatus.label" bundle="${ae_labels}"/> </th>
<tr>
	<td  class="label" width="25%"><fmt:message key="Common.currentlocation.label" bundle="${common_labels}"/></td>
	 <td colspan="3" width="75%">
	 
	<!-- <input type="text" class="text-box-nkb" size="40" name="txtCurrLocA" id="txtCurrLocA" id="txtCurrLocA" onfocus='assignCurEle(this)' />-->
	 <div id="toLocnAutoComplete">
				<input id="txtCurrLocA" name='txtCurrLocA' id='txtCurrLocA' type="text" maxlength='60' value=''class=text-box onfocus='assignCurEle(this)'> 
				<input name="txtCurrLocA_code" id="txtCurrLocA_code" id="txtCurrLocA_code" type="hidden">
				<div id="currLocnAContainer"></div>
	</div>
	 
	 
	 </td>
 </tr>
<tr>
	<td class="label" ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/> </td>
	<td colspan="3"><textarea class='text-area' wrap=virtual  name='txtRemarksA' id="txtRemarksA" onfocus='assignCurEle(this)'></textarea> </td>
</tr>
<!--<tr>
	<td class="label" colspan="2">Reached Droping Location </td>
	<td colspan="2"><input type="checkbox"  name="chkReachDropLocnA" id="chkReachDropLocnA" onclick="setValueForCheckbox(chkReachDropLocnA,ReachDropLocnA);loadDestn();"/>
	 <input type="hidden"  name="ReachDropLocnA" id="ReachDropLocnA" value="N"/> </td>
</tr>-->
<tr>
	<td class="label" ><fmt:message key="eAE.DistanceCovered.label" bundle="${ae_labels}"/></td>
	<td colspan="3"><input type="text" class="text-box-nkb" maxlength='12' size="19" name="txtDistCovrdA" id="txtDistCovrdA"  onblur="calcEndMeter(this,txtStartMeterA,txtEndMeterA,txtEndTimeA)" /> <label id="distncUOM" class="label"></label></td>
</tr>

<tr>
	<td class="label" ><fmt:message key="Common.StartTime.label" bundle="${common_labels}"/></td>
	<td ><input type="text" class="text-box-nkb" size="19" name="txtStartTimeA" id="txtStartTimeA" readonly /> </td>
	<td class="label"><fmt:message key="Common.EndTime.label" bundle="${common_labels}"/></td>
	<td><input type="text" class="text-box-nkb" size="19" name="txtEndTimeA" id="txtEndTimeA" onblur='if(!ChkDate(this) || this.value=="") Alert(getAEMessage("AE_AMB_DATE"),"001");' /> <img  class="img" align='ABSBOTTOM' src="../../eAE/images/Calendar.gif"  onClick="return showCalendar('txtEndTimeA',null,'hh:mm',true);"></td>
</tr>

<tr>
	<td class="label" ><fmt:message key="eAE.StartingMeter.label" bundle="${ae_labels}"/></td>
	<td ><input type="text" class="text-box-nkb" size="19" name="txtStartMeterA" id="txtStartMeterA" readonly/> </td>
	<td class="label"><fmt:message key="eAE.Endmeter.label" bundle="${ae_labels}"/></td>
	<td><input type="text" class="text-box-nkb" size="19" maxlength='12' name="txtEndMeterA" id="txtEndMeterA" onblur="calcDistCoverd(txtDistCovrdA,txtStartMeterA,this,txtEndTimeA)"/> </td>
</tr>

</table>
</td>
</tr>
<tr>
	<td align="right" valign="bottom"><input type="button" id="btnRecA" name="btnRecord" id="btnRecord" value="Record"/><input type="button" name="btnClose" id="btnClose" value="Close" id="btnClA" onclick="closeEntryDiv('ambSatausA')"/></td>
</tr>
</table>
</div><!----------End of Div for Status A--------------------->

</div>
<!-------------------------------End of Div in normal size----------------------------------------->

<!----------------when div is in expand mode----------------->
<div id="ambChartTable" style="display:none;font-size : 10px;font-family : Verdana;font-weight : normal;"></div><div id='chartPaginatorTbl'><table border = '0' width="98%" height="3%" cellpadding="0" cellspacing="0" ><tr id='search' style="background: #7D98B8 url('../../eAE/images/sprite.png') repeat-x 0 -1700px;" ><td   valign='center' align="right" nowrap style="background: #7D98B8 url('../../eAE/images/sprite.png') repeat-x 0 -1700px;">&nbsp;<div id="dt-chartPaginator" class="yui-skin-sam yui-pg-container" style="display:none;text-align:right"></div></td></tr></table></div>
<!----------------when div is in expand mode----------------->

</td>
<td colspan="4" valign="center" align="right" width="1%" height="100%"><img id="imgRight" src="../../eAE/images/ADSLeft.gif" onClick="expandHorizontaly('Layer6A','Layer5A','imgRight','left','1%','98%','55%','44%');"/></td>
</tr>

</table>
<input type="hidden" name="dragAmbId" id="dragAmbId" value=""/>
<input type="hidden" name="selAmbId" id="selAmbId" value=""/>
<input type="hidden" name="selCaseno" id="selCaseno" value=""/>

<script>
YAHOO.yuiData.ACJSArray = new function() {
    // Instantiate first JS Array DataSource
    this.oACDS = new YAHOO.widget.DS_JSArray(YAHOO.yuiData.StaticList.period);

    // Instantiate first AutoComplete
    this.oAutoComp = new YAHOO.widget.AutoComplete('periodInput','periodContainer', this.oACDS);
    this.oAutoComp.prehighlightClassName = "yui-ac-prehighlight";
    this.oAutoComp.typeAhead = true;
    this.oAutoComp.useShadow = true;
    this.oAutoComp.minQueryLength = 0;
	this.oAutoComp.forceSelection = true; 

    this.oAutoComp.textboxFocusEvent.subscribe(function(){
        var sInputValue = YAHOO.util.Dom.get('periodInput').value;
        if(sInputValue.length === 0) {
            var oSelf = this;
            setTimeout(function(){oSelf.sendQuery(sInputValue);},0);
        }
    });
}

YAHOO.namespace("yuiData.DynamicList.curLocnM"); 
YAHOO.yuiData.DynamicList.curLocnM.ACJson = new function(){
    this.oACDS = new YAHOO.widget.DS_XHR("AMBGetJSON.jsp", ["mp_res_town","short_desc","res_town_code"]);
	this.oACDS.responseType = YAHOO.widget.DS_XHR.TYPE_JSON; 
    this.oACDS.queryMatchContains = true;
	this.oACDS.scriptQueryParam = "short_desc";
    this.oACDS.scriptQueryAppend = "table=mp_res_town";
 
    // Instantiate AutoComplete
	var txtCurrLocM = document.getElementById('txtCurrLocM');
	var currLocnMContainer = document.getElementById('currLocnMContainer');
    this.oAutoComp = new YAHOO.widget.AutoComplete(txtCurrLocM,currLocnMContainer, this.oACDS);
    this.oAutoComp.useShadow = true;
	this.oAutoComp.minQueryLength = 1;
	this.oAutoComp.maxResultsDisplayed = 7;
	this.oAutoComp.connTimeout = 3000;
	this.oAutoComp.typeAhead = true;
	this.oAutoComp.maxCacheEntries = 0;
	//this.oAutoComp.forceSelection = true; 

    this.oAutoComp.formatResult = function(oResultItem, sQuery){
		 var sValue = oResultItem[0];  
		 var sKey = oResultItem[1];  // Has the Code 
		 var aMarkup = ["<div class='text-box'><span class='text-box'>",sValue,"</span></div>"];
		 return (aMarkup.join(""));
	};


	this.oAutoComp.doBeforeExpandContainer = function(oTextbox, oContainer, sQuery, aResults) {
        var pos = YAHOO.util.Dom.getXY(oTextbox);
        pos[1] += YAHOO.util.Dom.get(oTextbox).offsetHeight + 2;
        YAHOO.util.Dom.setXY(oContainer,pos);
        return true;
    };
 
	//Define the itemSelect handler function: To assign the NOC code to hidden variable
	var itemSelectHandler = function(sType, aArgs) {
	YAHOO.log(sType); // this is a string representing the event;
				      
	var oACInstance = aArgs[0]; // Current AutoComplete instance
	var elListItem = aArgs[1];  // the <li> element selected in the suggestion container
	var oData = aArgs[2];		// object literal of data for the result, Code and description
	var code = oData[1];
	document.getElementById('txtCurrLocM_code').value=trimString(code);// Assign Code to hidden variable
	};//subscribe the handler to the event
	this.oAutoComp.itemSelectEvent.subscribe(itemSelectHandler);};


	YAHOO.namespace("yuiData.DynamicList.curLocnA"); 
YAHOO.yuiData.DynamicList.curLocnA.ACJson = new function(){
    this.oACDS = new YAHOO.widget.DS_XHR("AMBGetJSON.jsp", ["mp_res_town","short_desc","res_town_code"]);
	this.oACDS.responseType = YAHOO.widget.DS_XHR.TYPE_JSON; 
    this.oACDS.queryMatchContains = true;
	this.oACDS.scriptQueryParam = "short_desc";
    this.oACDS.scriptQueryAppend = "table=mp_res_town";
 
    // Instantiate AutoComplete
	var txtCurrLocA = document.getElementById('txtCurrLocA');
	var currLocnAContainer = document.getElementById('currLocnAContainer');
    this.oAutoComp = new YAHOO.widget.AutoComplete(txtCurrLocA,currLocnAContainer, this.oACDS);
    this.oAutoComp.useShadow = true;
	this.oAutoComp.minQueryLength = 1;
	this.oAutoComp.maxResultsDisplayed = 7;
	this.oAutoComp.connTimeout = 3000;
	this.oAutoComp.typeAhead = true;
	this.oAutoComp.maxCacheEntries = 0;
	//this.oAutoComp.forceSelection = true; 

    this.oAutoComp.formatResult = function(oResultItem, sQuery){
		 var sValue = oResultItem[0];  
		 var sKey = oResultItem[1];  // Has the Code 
		 var aMarkup = ["<div class='text-box'><span class='text-box'>",sValue,"</span></div>"];
		 return (aMarkup.join(""));
	};


	this.oAutoComp.doBeforeExpandContainer = function(oTextbox, oContainer, sQuery, aResults) {
        var pos = YAHOO.util.Dom.getXY(oTextbox);
        pos[1] += YAHOO.util.Dom.get(oTextbox).offsetHeight + 2;
        YAHOO.util.Dom.setXY(oContainer,pos);
        return true;
    };
 
	//Define the itemSelect handler function: To assign the NOC code to hidden variable
	var itemSelectHandler = function(sType, aArgs) {
	YAHOO.log(sType); // this is a string representing the event;
				      
	var oACInstance = aArgs[0]; // Current AutoComplete instance
	var elListItem = aArgs[1];  // the <li> element selected in the suggestion container
	var oData = aArgs[2];		// object literal of data for the result, Code and description
	var code = oData[1];
	document.getElementById('txtCurrLocA_code').value=trimString(code);// Assign Code to hidden variable
	};//subscribe the handler to the event
	this.oAutoComp.itemSelectEvent.subscribe(itemSelectHandler);};


	YAHOO.namespace("yuiData.DynamicList.curLocnB"); 
YAHOO.yuiData.DynamicList.curLocnB.ACJson = new function(){
    this.oACDS = new YAHOO.widget.DS_XHR("AMBGetJSON.jsp", ["mp_res_town","short_desc","res_town_code"]);
	this.oACDS.responseType = YAHOO.widget.DS_XHR.TYPE_JSON; 
    this.oACDS.queryMatchContains = true;
	this.oACDS.scriptQueryParam = "short_desc";
    this.oACDS.scriptQueryAppend = "table=mp_res_town";
 
    // Instantiate AutoComplete
	var txtCurrLocB = document.getElementById('txtCurrLocB');
	var currLocnBContainer = document.getElementById('currLocnBContainer');
    this.oAutoComp = new YAHOO.widget.AutoComplete(txtCurrLocB,currLocnBContainer, this.oACDS);
    this.oAutoComp.useShadow = true;
	this.oAutoComp.minQueryLength = 1;
	this.oAutoComp.maxResultsDisplayed = 7;
	this.oAutoComp.connTimeout = 3000;
	this.oAutoComp.typeAhead = true;
	this.oAutoComp.maxCacheEntries = 0;
	//this.oAutoComp.forceSelection = true; 

    this.oAutoComp.formatResult = function(oResultItem, sQuery){
		 var sValue = oResultItem[0];  
		 var sKey = oResultItem[1];  // Has the Code 
		 var aMarkup = ["<div class='text-box'><span class='text-box'>",sValue,"</span></div>"];
		 return (aMarkup.join(""));
	};


	this.oAutoComp.doBeforeExpandContainer = function(oTextbox, oContainer, sQuery, aResults) {
        var pos = YAHOO.util.Dom.getXY(oTextbox);
        pos[1] += YAHOO.util.Dom.get(oTextbox).offsetHeight + 2;
        YAHOO.util.Dom.setXY(oContainer,pos);
        return true;
    };
 
	//Define the itemSelect handler function: To assign the NOC code to hidden variable
	var itemSelectHandler = function(sType, aArgs) {
	YAHOO.log(sType); // this is a string representing the event;
				      
	var oACInstance = aArgs[0]; // Current AutoComplete instance
	var elListItem = aArgs[1];  // the <li> element selected in the suggestion container
	var oData = aArgs[2];		// object literal of data for the result, Code and description
	var code = oData[1];
	document.getElementById('txtCurrLocB_code').value=trimString(code);// Assign Code to hidden variable
	};//subscribe the handler to the event
	this.oAutoComp.itemSelectEvent.subscribe(itemSelectHandler);};
</script>
				
			</div>
		</div><!------------------------End -Right-------------------------------------------------->
		<div  id="Layer4A" class="bottom-outer" align="LEFT" valign="Center" ondblclick="switchView();">
		<TABLE border=0 width='100%' cellspacing="0" cellpadding="0">
		<TR>
			<TD valign=top width='53%'>&nbsp;<b><fmt:message key="Common.RequestDetails.label" bundle="${common_labels}"/></b></TD>
			<TD valign =top align='left'><img id="imgTop" src="../../eAE/images/ADSUp.gif" onClick="expandVertically('Layer4A','Layer6A','Layer5A','imgTop','6%','92%','48%','49%');"/></TD>
			<td id='fillerCell'><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br></td>
		</TR>
		</TABLE>
			<div id="Layer4" class="bottom" style='display:inline'>
				<%@include file="AmbulanceManagementSystemRequestDetail.jsp"%>
			</div>
		
		</div>
		<div id="dt-dlg">   
			 <span class="corner_tr"></span>  
			 <span class="corner_tl"></span>  
			 <span class="corner_br"></span>  
			 <span class="corner_bl"></span>  
			 <div class="hd">   
				 <fmt:message key="eAE.Choosewhichcolumnsyouwouldliketosee.label" bundle="${ae_labels}"/>:   
			 </div>  
			 <div id="dt-dlg-picker" class="bd">   
			 </div>  
		 </div>  
		<!----------------------------Variable which stores the current table column order--------------------------------------->
			<input type="hidden" name="selOrder" id="selOrder" value="<%=selOrderId%>" />
		<!------------------------------------------------------------------------------------------------------------------------>
	
		<!----------------------------Variables for prev next function of left div ----------------------------------------------->
			<input type="hidden" name="queStart" id="queStart" value="" />
			<input type="hidden" name="queEnd" id="queEnd" value="" />
		<!------------------------------------------------------------------------------------------------------------------------>
		
		<!----------------------------Variables for prev next function of right div----------------------------------------------->
			<input type="hidden" name="chartStart" id="chartStart" value="" />
			<input type="hidden" name="chartEnd" id="chartEnd" value="" />
		<!------------------------------------------------------------------------------------------------------------------------>

		<!----------------------------Variable which decides which action to be done in servlet----------------------------------->
			<input type="hidden" name="doAction" id="doAction" value="" />
		<!------------------------------------------------------------------------------------------------------------------------>
		
		<!----------------------------Variable which stores the status of window-------------------------------------------------->
			<input type="hidden" name="wStatus" id="wStatus" value="<%=wStatus%>" />
		<!------------------------------------------------------------------------------------------------------------------------>
        <input type="hidden" name="pageString" id="pageString" value="" />
		
</form>
</div> 

<div id="AlertDiv"></div>
<div id="dialog1">
<div class="hd"><fmt:message key="eAE.CustomizedPositionforGridtable.label" bundle="${ae_labels}"/> </div>
<div class="bd">
<form name="frmSetting" id="frmSetting" method="POST" action="..\..\servlet\eAE.AmbulanceManagementServlet">
<table>
	<tr>
		<td>
		<label for="txtName"><fmt:message key="Common.identification.label" bundle="${common_labels}"/>:</label>
		</td>
		<td>
		<input type="textbox" id="txtId" name="txtId" id="txtId" maxlength="5" class="text-box" onblur="ChangeUpperCase(txtId)" onfocus='assignCurEle(this)'/><br>
		</td>
	</tr>
	<tr>
		<td>
		<label for="txtDesc"><fmt:message key="Common.description.label" bundle="${common_labels}"/>:</label>
		</td>
		<td>
		<input type="textbox" id="txtDesc" name="txtDesc" id="txtDesc" maxlength='30' class="text-box" onfocus='assignCurEle(this)'/>
		<input type="hidden" name="doAction" id="doAction" value="saveSetting" />
		<input type="hidden" name="tblStng" id="tblStng" value="" />
		</td>
	</tr>
	<tr>
		<td>
		<label for="check"><fmt:message key="Common.Default.label" bundle="${common_labels}"/>:</label>
		</td>
		<td>
		<input type="checkbox" name="chkDefault" id="chkDefault" value="1" onclick="setValueForCheckbox(chkDefault,hidDefault)"/>
		<input type="hidden" name="hidDefault" id="hidDefault" value="N" />
		</td>
	</tr>
</table>
</form>
</div>
</div>
</body>

<script>

YAHOO.namespace("example.container");

var oPushButton1 = new YAHOO.widget.Button("btnRecB");
oPushButton1.on("click", onButtonClick); 
var oPushButton2 = new YAHOO.widget.Button("btnRecM");
oPushButton2.on("click", onButtonClick); 
var oPushButton3 = new YAHOO.widget.Button("btnRecA");  
oPushButton3.on("click", onButtonClick); 
var oPushButton4 = new YAHOO.widget.Button("btnClB"); 
oPushButton4.on("click", onButtonClick); 
var oPushButton5 = new YAHOO.widget.Button("btnClM"); 
oPushButton5.on("click", onButtonClick); 
var oPushButton6 = new YAHOO.widget.Button("btnClA");  
oPushButton6.on("click", onButtonClick);

function onButtonClick(p_oEvent) {   
	var selID=this.get("id");
	if(selID=='btnClB'){
		closeEntryDiv('ambSatausB')
	}else if(selID=='btnClM'){
		closeEntryDiv('ambSatausM')
	}else if(selID=='btnClA'){
		closeEntryDiv('ambSatausA')
	}else if(selID=='btnRecB'){
		RecordChartInfo('B');
	}else if(selID=='btnRecM'){
		RecordChartInfo('M');
	}else if(selID=='btnRecA'){
		RecordChartInfo('A');
	}else if(selID=='btnChartGo'){
		alert("Go  "+selID)
	}
}

YAHOO.util.Event.addListener(window, "load", function() {  

	//-----------------------------------------Column orders list button-----------------------------------------------------------

	 function onMenuItemClick(p_sType, p_aArgs, p_oItem) {

            oMenuButton4.set("label", p_oItem.cfg.getProperty("text"));
			document.frmAmbMangmntSystem.selOrder.value=p_oItem.value;
			reQueryPage();
        }

		<%out.println("var aMenuButton4Menu = ["+clmnOrdrs+"];");%>
      if(aMenuButton4Menu!=""){
        var oMenuButton4 = new YAHOO.widget.Button({ type: "menu", label: <%="'"+selOrderDesc+"'"%>, name: "mymenubutton", menu: aMenuButton4Menu, container: "menubuttonsfromjavascript" });    
      }else{
    	  var oMenuButton4 =new YAHOO.widget.Button({ type: "button", label: <%="'"+selOrderDesc+"'"%>, name: "mymenubutton",  container: "menubuttonsfromjavascript" }); 
      }
//-----------------------------------------Save Seting-----------------------------------------------------------
	
	var handleSubmit = function() {
		this.submit();
	};
	var handleCancel = function() {
		this.cancel();
	};
	var handleSuccess = function(o) {
		YAHOO.yui.container.alert(o.responseText,'id','Result');
		goRefreshPage();
	
	};
	var handleFailure = function(o) {
		alert("Submission failed: ");
	};

	// Instantiate the Dialog
	YAHOO.example.container.dialog1 = new YAHOO.widget.Dialog("dialog1", 
							{ width : "25em",
							  fixedcenter : true,
							  visible : false, 
							  zIndex:500,
							  constraintoviewport : true,
							  buttons : [ { text:"Submit", handler:handleSubmit, isDefault:true },
								      { text:"Cancel", handler:handleCancel } ]
							});

	// Validate the entries in the form 
	YAHOO.example.container.dialog1.validate = function() {
		var data = this.getData();
		if(data.txtId.indexOf(" ")!=-1){
		     alert(getMessage("SPACE_NOT_ALLOWED","AE"));
			return false;
		}else if (data.txtId == "" || data.txtDesc == "") {
		    alert(getMessage("ETR_NAME_N_DES","AE"));
			return false;
		} else {
			return true;
		}
	};

	YAHOO.example.container.dialog1.render();

	// Wire up the success and failure handlers
	YAHOO.example.container.dialog1.callback = { success: handleSuccess,
						     failure: handleFailure };

//-------------------------------Requested Queue All---------------------------------------------------------------
//YAHOO.example.Basic = new function() {   
  
	 YAHOO.example.CustomFormatting1 = new function() {   
		
		 this.myCustomFormatter = function(elCell, oRecord, oColumn, oData) { 
		 if(oColumn.getKey()=="Status1" && oColumn.hidden==false ){
			elCell.parentNode.className="";
			if(oData== 'R' || oData== "Requested") {   
			 //YAHOO.util.Dom.replaceClass(elCell.parentNode, elCell.parentNode.className, "Requested");   
			 elCell.parentNode.className="Requested";
			 elCell.innerHTML = "Requested&nbsp;" ;
			                
           }else if(oData== 'A'  || oData== "Assigned") {   
				//YAHOO.util.Dom.replaceClass(elCell.parentNode,elCell.parentNode.className,"Assigned");  
				 elCell.parentNode.className="Assigned";
                 elCell.innerHTML = "&nbsp;&nbsp;Assigned&nbsp;" ;
			}else if(oData== 'X'  || oData== "Cancelled") {   
              	 elCell.parentNode.className="Cancelled";
                 elCell.innerHTML = "Cancelled" ;
            } else if(oData== 'C'  || oData== "Completed") {   
             	  elCell.parentNode.className="Completed";
                 elCell.innerHTML = "Completed" ;
            }   
			}
			elCell.innerHTML= elCell.innerHTML+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
		 };   

		YAHOO.widget.DataTable.Formatter.myCustom = this.myCustomFormatter;   
         this.myDataSource = new YAHOO.util.DataSource(YAHOO.example.Data.ambReqstDataAll);   
         this.myDataSource.responseType = YAHOO.util.DataSource.TYPE_JSON;   
		this.myDataSource.responseSchema = {resultsList : "Response.Results", fields: [{key:"Name",parser:"string"},{key:"RequestedDate",parser:"YAHOO.widget.DataTable.formatDate"},{key:"Status1",parser:"myCustom"},{key:"Pickup",parser:"string"},{key:"Drop",parser:"string"},{key:"PickupAddress",parser:"string"},{key:"DropAddress",parser:"string"},{key:"AmbNo",parser:"string"},{key:"ambCaseStartDate",parser:"YAHOO.widget.DataTable.formatDate"},{key:"ambCaseEndDate",parser:"YAHOO.widget.DataTable.formatDate"},{key:"ambCallerName",parser:"string"},{key:"ambCallerContNo",parser:"string"},{key:"ambCallerRmrks",parser:"string"},{key:"natureCallDesc",parser:"string"},{key:"ambPriorityInd",parser:"string"},{key:"ambStartMileage",parser:"number"},{key:"ambEndMileage",parser:"number"},{key:"ambDispRemarks",parser:"string"},{key:"currentLocation",parser:"string"},{key:"ambVehicleName",parser:"string"},{key:"ambRegnNo",parser:"string"},{key:"ambLastMileage",parser:"number"}]};        
    
	window.myDataTable = new YAHOO.widget.DataTable("ambRequstAll",   
        myColumnDefs, this.myDataSource, {scrollable:true, height:"16em",width:"93em",sortable:true,draggableColumns:true, paginator: new YAHOO.widget.Paginator({
				containers:'dt-paginatorAll',
                rowsPerPage: 6,				                
                pageLinks: 5,
				alwaysVisible :false,
				firstPageLinkLabel:'<img src=../../eAE/images/FirstPage.gif>',
				previousPageLinkLabel:'<img src=../../eAE/images/ADSprevious.gif>',
				nextPageLinkLabel:'<img src=../../eAE/images/ADSnext.gif>',
				lastPageLinkLabel:'<img src=../../eAE/images/LastPage.gif>'
            })});
    /**************** Show, Hide Columns**********start**********/	
	         // Shows dialog, creating one when necessary   
         var newCols = true; 		 
		 var customizeColumns=new YAHOO.util.CustomEvent("customizeColumns"); 
		 var showDlg = function(e) {   
		     YAHOO.util.Event.stopEvent(e);   
                if(newCols) {   
                 // Populate Dialog   
                 // Using a template to create elements for the SimpleDialog   
                 var allColumns = window.myDataTable.getColumnSet().keys;   
                 var elPicker = YAHOO.util.Dom.get("dt-dlg-picker");   
                 var elTemplateCol = document.createElement("div");   
                 YAHOO.util.Dom.addClass(elTemplateCol, "dt-dlg-pickercol");   
                 var elTemplateKey = elTemplateCol.appendChild(document.createElement("span"));   
                 YAHOO.util.Dom.addClass(elTemplateKey, "dt-dlg-pickerkey");   
                 var elTemplateBtns = elTemplateCol.appendChild(document.createElement("span"));   
                 YAHOO.util.Dom.addClass(elTemplateBtns, "dt-dlg-pickerbtns");   
                 var onclickObj = {fn:handleButtonClick, obj:this, scope:false };
                			 
                 // Create one section in the SimpleDialog for each Column   
                 var elColumn, elKey, elButton, oButtonGrp,oGrpByButton;  
					
					for(var i=0,l=allColumns.length;i<l;i++) {   
						 var oColumn = allColumns[i];   
						 // Use the template   
						 elColumn = elTemplateCol.cloneNode(true);   
							
						 // Write the Column key   
						 elKey = elColumn.firstElementChild;  
					 
						   //  elKey.innerHTML = oColumn.getKey();					 
						 elKey.innerHTML = oColumn.label;					 
							
						 // Create a ButtonGroup   
						 oButtonGrp = new YAHOO.widget.ButtonGroup({    
										 id: "buttongrp"+i,    
										 name: oColumn.getKey(), 																		 
										 container: elKey.nextSibling
						 });   
					
						 oButtonGrp.addButtons([    
							 { label: "Show", value: "Show", checked: ((!oColumn.hidden)), onclick: onclickObj},   
							 { label: "Hide", value: "Hide", checked: ((oColumn.hidden)), onclick: onclickObj}
						 ]);   
						
						 elPicker.appendChild(elColumn); 			
					 } 		 
                 newCols = false;   
             } 
		 
             myDlg.show();   
         };   
         var hideDlg = function(e) {   
		         this.hide();   
         };  
 
		 var PrevsKey="";	
	     var handleButtonClick = function(e, oSelf) {
		 	var sKey = this.get("name"); 				
			if(this.get("value") == "Hide") {
				window.myDataTable.hideColumn(sKey);				
			}   
			else if(this.get("value")=="Show"){ 			
				window.myDataTable.showColumn(sKey);  				
			} 	
		};  
	
	window.myDataTable.subscribe("columnShowEvent",function(oArgs){
			if(((oArgs.column).getKey()=="Status1") || (window.myDataTable.getColumn("Status1").hidden==false)){
				var allRows = window.myDataTable.getRecordSet(); 
				for(var j=0;j<allRows.getLength();j++){
					oData=window.myDataTable.getRecord(j).getData("Status1");
			
					eTR=window.myDataTable.getTrEl(window.myDataTable.getRecord(j));
				
					if(oData !=null  && oData !="" && oData !='undefined'){			
						if(oData== 'R' || oData=="Requested") {			
							eTR.cells[(window.myDataTable.getColumn("Status1")).getKeyIndex()].className="Requested";						
							window.myDataTable.updateCell (window.myDataTable.getRecord(j), "Status1","Requested");	
						
					   }else if(oData== 'A' || oData=="Assigned") {  				
							eTR.cells[(window.myDataTable.getColumn("Status1")).getKeyIndex()].className="Assigned";   				
							window.myDataTable.updateCell (window.myDataTable.getRecord(j),  "Status1","Assigned");					
						
						}else if(oData== 'X'  || oData=="Cancelled") {   
							 eTR.cells[(window.myDataTable.getColumn("Status1")).getKeyIndex()].className="Cancelled";          
							 window.myDataTable.updateCell (window.myDataTable.getRecord(j),  "Status1","Cancelled");
							
						}else if(oData== 'C'  || oData=="Completed") {   
							eTR.cells[(window.myDataTable.getColumn("Status1")).getKeyIndex()].className="Completed";        
							window.myDataTable.updateCell (window.myDataTable.getRecord(j), "Status1","Completed");
							
					}
				}
					
			}	
		}

	},this,true)   ;
	window.myDataTable.subscribe("columnHideEvent",function(oArgs){
		if((oArgs.column).getKey()=="Status1" ){
			(oArgs.column).formatter="";
		}else{
		if((window.myDataTable.getColumn("Status1")).hidden==false){
			var allRows = window.myDataTable.getRecordSet(); 
			for(var j=0;j<allRows.getLength();j++){
				oData=window.myDataTable.getRecord(j).getData("Status1");
				eTR=window.myDataTable.getTrEl(window.myDataTable.getRecord(j));
			
				if(oData !=null  && oData !="" && oData !='undefined'){			
				if(oData== 'R' || oData=="Requested") {			
					eTR.cells[(window.myDataTable.getColumn("Status1")).getKeyIndex()].className="Requested";	
				
					window.myDataTable.updateCell (window.myDataTable.getRecord(j), "Status1","Requested");	
				
			   }else if(oData== 'A' || oData=="Assigned") {  				
					eTR.cells[(window.myDataTable.getColumn("Status1")).getKeyIndex()].className="Assigned";   				
					window.myDataTable.updateCell (window.myDataTable.getRecord(j),  "Status1","Assigned");					
				
				}else if(oData== 'X'  || oData=="Cancelled") {   
					 eTR.cells[(window.myDataTable.getColumn("Status1")).getKeyIndex()].className="Cancelled";          
					 window.myDataTable.updateCell (window.myDataTable.getRecord(j),  "Status1","Cancelled");
					
				}else if(oData== 'C'  || oData=="Completed") {   
					eTR.cells[(window.myDataTable.getColumn("Status1")).getKeyIndex()].className="Completed";        
					window.myDataTable.updateCell (window.myDataTable.getRecord(j), "Status1","Completed");
					
				}
				}
				
			}	
			}
		} 
	},this,true)   ;
	window.myDataTable.subscribe("columnSortEvent",function(oArgs){
		if((window.myDataTable.getColumn("Status1")).hidden==false){
			var allRows = window.myDataTable.getRecordSet(); 
			for(var j=0;j<allRows.getLength();j++){
				oData=window.myDataTable.getRecord(j).getData("Status1");
				eTR=window.myDataTable.getTrEl(window.myDataTable.getRecord(j));
			
				if(oData !=null  && oData !="" && oData !='undefined'){			
				if(oData== 'R' || oData=="Requested") {			
					eTR.cells[(window.myDataTable.getColumn("Status1")).getKeyIndex()].className="Requested";					
					window.myDataTable.updateCell (window.myDataTable.getRecord(j), "Status1","Requested");	
				
			   }else if(oData== 'A' || oData=="Assigned") {  				
					eTR.cells[(window.myDataTable.getColumn("Status1")).getKeyIndex()].className="Assigned";   				
					window.myDataTable.updateCell (window.myDataTable.getRecord(j),  "Status1","Assigned");					
				
				}else if(oData== 'X'  || oData=="Cancelled") {   
					 eTR.cells[(window.myDataTable.getColumn("Status1")).getKeyIndex()].className="Cancelled";          
					 window.myDataTable.updateCell (window.myDataTable.getRecord(j),  "Status1","Cancelled");
					
				}else if(oData== 'C'  || oData=="Completed") {   
					eTR.cells[(window.myDataTable.getColumn("Status1")).getKeyIndex()].className="Completed";        
					window.myDataTable.updateCell (window.myDataTable.getRecord(j), "Status1","Completed");
					
				}
				}
				
			}	
			}	
	},this,true)   ;	
	
 /**************** Show, Hide GroupColumns*******end*****/	
         // Create the SimpleDialog   
         YAHOO.util.Dom.removeClass("dt-dlg", "inprogress");   
         var myDlg = new YAHOO.widget.SimpleDialog("dt-dlg", {   
                 width: "30em", 
				  height:"35em",				 
                 visible: false,   
                 modal: true,   
                 buttons: [                         
                     { text:"Close",  handler:hideDlg }   
                 ],   
                 fixedcenter: true,   
                 constrainToViewport: true  
         });   
        myDlg.render();   
   
         // Nulls out myDlg to force a new one to be created   
         window.myDataTable.subscribe("columnReorderEvent", function(){   
             newCols = true;   
            YAHOO.util.Event.purgeElement("dt-dlg-picker", true);   
             YAHOO.util.Dom.get("dt-dlg-picker").innerHTML = "";   
         }, this, true);   
            
         // Hook up the SimpleDialog to the link   
		customizeColumns.subscribe(showDlg);      
		 
		window.myDataTable.subscribe("rowMouseoverEvent", window.myDataTable.onEventHighlightRow);
        window.myDataTable.subscribe("rowMouseoutEvent", window.myDataTable.onEventUnhighlightRow);
        window.myDataTable.subscribe("rowClickEvent", window.myDataTable.onEventSelectRow);
		
		/*this.myDataTable.subscribe("rowClickEvent", function(oArgs){
        var oRecord = this.getRecord(oArgs.target);
        var pt_name =  YAHOO.lang.dump(oRecord.getData("Name"));
		document.getElementById("pat_name").value=pt_name;
		callOnClick();
		});*/

		window.myDataTable.subscribe("rowDblclickEvent", function(oArgs){
        var oRecord = this.getRecord(oArgs.target);
        var tripSheetNo =  YAHOO.lang.dump(oRecord.getData("AmbNo"));
		//document.getElementById("pat_name").value=pt_name;
		callOnClickRequested(tripSheetNo);		
		});


		this.onContextMenuClick = function(p_sType, p_aArgs, p_myDataTable) {
		
			switch(p_aArgs[1].index){

				case 0:
					var elRow = this.contextEventTarget;   
					elRow = p_myDataTable.getTrEl(elRow);   
                    var oRecord = p_myDataTable.getRecord(elRow);   
                    var trip_no=oRecord.getData("AmbNo");

					leftVal = (screen.width-900) / 2;
					topVal = (screen.height-630) / 2;
				
				    window.open("AmbPrintTripSheet.jsp?p_trip_no="+trip_no,"reportWindow","resizable=1,scrollbars=1,width=900,height=630,left="+leftVal+",top="+topVal);

					break;
				case 1:
					var list = new Array();
					var list1= new Array();
					list=p_myDataTable.getColumnSet().getDefinitions();
					var cs=p_myDataTable.getColumnSet();
					var allColumnkeys = window.myDataTable.getColumnSet().keys;   
					var chkHiddenCols;
					for(var i=0;i<list.length;i++){
						cl=cs.getColumn(i);
						chkHiddenCols=allColumnkeys[i]
						if(chkHiddenCols.hidden==false){
							list1[i]=cl.getKey();
						}
					}
					document.frmSetting.tblStng.value=list1;
					document.frmSetting.txtId.value="";
					document.frmSetting.txtDesc.value="";
					document.frmSetting.chkDefault.checked=false;
					document.frmSetting.hidDefault.value="N";
					YAHOO.example.container.dialog1.show();
					
					break;
				case 2:
					customizeColumns.fire();
					break;
			}
			
		 };

		

        this.myContextMenu = new YAHOO.widget.ContextMenu("mycontextmenu", {trigger:window.myDataTable.getTbodyEl()});
        this.myContextMenu.addItem("Print");
		this.myContextMenu.addItem("Save Settings");
		this.myContextMenu.addItem("Customize Column Display");
	    this.myContextMenu.render("ambRequstAll");
        this.myContextMenu.clickEvent.subscribe(this.onContextMenuClick, window.myDataTable);
		 
     };   

   //-------------------------------Requested Queue Small---------------------------------------------------
   /*YAHOO.example.CustomFormatting = new function() {   
    	 this.myCustomFormatter1 = function(elCell, oRecord, oColumn, oData) {  
			 
			// alert(oRecord.getData("Status2"));
            if(oRecord.getData("Status1")== 'R') {   
                // YAHOO.util.Dom.replaceClass(elCell.parentNode,"Assigned", "Requested");  
				elCell.parentNode.className="Requested";
				 elCell.innerHTML ="Requested" ;
                
            }else if(oRecord.getData("Status1")== 'A') {   
              //  YAHOO.util.Dom.replaceClass(elCell.parentNode, "Requested","Assigned");  
			  elCell.parentNode.className="Assigned";
                 elCell.innerHTML = "Assigned" ;
            }  
		 };   

		 YAHOO.widget.DataTable.Formatter.myCustom1 = this.myCustomFormatter1;   
       /*  var myColumnDefs1 = [   
             {key:"RequestedDate",label:"Requested Date", formatter:YAHOO.widget.DataTable.formatDate, sortable:true, 
			 sortOptions:{defaultDir:YAHOO.widget.DataTable.CLASS_DESC},resizeable:true,width:120},   
             {key:"Name", sortable:true, resizeable:true,width:130},       
			 {key:"Status2",label:"Status", formatter:"myCustom1",sortable:true, resizeable:true,width:70},  
			 {key:"Pickup", sortable:true, resizeable:true,width:95},   
             {key:"Drop", sortable:true, resizeable:true,width:95} 
		];   */

		YAHOO.example.CustomFormatting2 = new function() { 
			
			 this.myCustomFormatter = function(elCell, oRecord, oColumn, oData) {  

            if(oRecord.getData("Status1")== 'R') {   
                // YAHOO.util.Dom.replaceClass(elCell.parentNode,"Assigned", "Requested");  
				elCell.parentNode.className="Requested";
				 elCell.innerHTML ="Requested" ;
                
            }else if(oRecord.getData("Status1")== 'A') {   
              //  YAHOO.util.Dom.replaceClass(elCell.parentNode, "Requested","Assigned");  
				 elCell.parentNode.className="Assigned";
                 elCell.innerHTML = "Assigned" ;
            }  
		 };   
 
         this.myDataSource = new YAHOO.util.DataSource(YAHOO.example.Data.ambReqstDataAll);   
         this.myDataSource.responseType = YAHOO.util.DataSource.TYPE_JSON;   
		
      // this.myDataSource.responseSchema = {resultsList : "Response.Results",fields: [<%=fields1%>,"AmbNo"]   
      this.myDataSource.responseSchema = {resultsList : "Response.Results",fields: [<%=fields1%>,{key:"AmbNo",parser:"string"}]}; 
	//	 this.myDataSource.responseSchema = {resultsList : "Response.Results",fields: [{key:"Name",parser:"string"},{key:"RequestedDate",parser:"YAHOO.widget.DataTable.formatDate"},{key:"ambCallerRmrks",parser:"string"},{key:"Pickup",parser:"string"},{key:"PickupAddress",parser:"string"}]  } ;
       
	//myColumnDefs1 = [{key:"Name", label:"Name",sortable:true, resizeable:false,width:93,minWidth:93,maxAutoWidth:93},{key:"RequestedDate",label:"Requested Date", formatter:YAHOO.widget.DataTable.formatDate, sortable:true, sortOptions:{defaultDir:YAHOO.widget.DataTable.CLASS_DESC},resizeable:false, width:104,minWidth:104,maxAutoWidth:104},{key:"ambCallerRmrks", label:"Request Remarks",formatter:"string",sortable:true, resizeable:false, width:93,minWidth:93,maxAutoWidth:93},{key:"Pickup", sortable:true, resizeable:false,width:93,minWidth:93,maxAutoWidth:93},{key:"PickupAddress", label:"Pickup Address",sortable:true, resizeable:false,width:93,minWidth:93,maxAutoWidth:93}];
         this.myDataTable1 = new YAHOO.widget.DataTable("ambRequst",   
         myColumnDefs1, this.myDataSource, {scrollable:true, height:"18em", paginator: new YAHOO.widget.Paginator({
			   containers:'dt-paginator',     
			   rowsPerPage: 6,
                pageLinks: 5,
				alwaysVisible :false,
				firstPageLinkLabel:'<img  src=../../eAE/images/FirstPage.gif>',
				previousPageLinkLabel:'<img src=../../eAE/images/ADSprevious.gif>',
				nextPageLinkLabel:'<img src=../../eAE/images/ADSnext.gif>',
				lastPageLinkLabel:'<img src=../../eAE/images/LastPage.gif>'
            })}); 
		 
		this.myDataTable1.subscribe("rowMouseoverEvent", this.myDataTable1.onEventHighlightRow);
        this.myDataTable1.subscribe("rowMouseoutEvent", this.myDataTable1.onEventUnhighlightRow);
        this.myDataTable1.subscribe("rowClickEvent", this.myDataTable1.onEventSelectRow);
        
        this.myDataTable1.subscribe("columnSortEvent",function(oArgs){
    		if((this.myDataTable1.getColumn("Status1")).hidden==false){
    				var allRows = this.myDataTable1.getRecordSet(); 
    				for(var j=0;j<allRows.getLength();j++){
    					oData=this.myDataTable1.getRecord(j).getData("Status1");
    					eTR=this.myDataTable1.getTrEl(this.myDataTable1.getRecord(j));
    				
    					if(oData !=null  && oData !="" && oData !='undefined'){			
    					if(oData== 'R' || oData=="Requested") {			
    						eTR.cells[(this.myDataTable1.getColumn("Status1")).getKeyIndex()].className="Requested";					
    						this.myDataTable1.updateCell (this.myDataTable1.getRecord(j), "Status1","Requested");	
    					
    				   }else if(oData== 'A' || oData=="Assigned") {  				
    						eTR.cells[(this.myDataTable1.getColumn("Status1")).getKeyIndex()].className="Assigned";   				
    						this.myDataTable1.updateCell (this.myDataTable1.getRecord(j),  "Status1","Assigned");					
    					
    					}else if(oData== 'X'  || oData=="Cancelled") {   
    						 eTR.cells[(this.myDataTable1.getColumn("Status1")).getKeyIndex()].className="Cancelled";          
    						 this.myDataTable1.updateCell (this.myDataTable1.getRecord(j),  "Status1","Cancelled");
    						
    					}else if(oData== 'C'  || oData=="Completed") {   
    						eTR.cells[(this.myDataTable1.getColumn("Status1")).getKeyIndex()].className="Completed";        
    						this.myDataTable1.updateCell (this.myDataTable1.getRecord(j), "Status1","Completed");
    						
    					}
    					}
    					
    				}	
    				}	
    		},this,true)   ;
        
        
        
        
		
		this.myDataTable1.subscribe("rowDblclickEvent", function(oArgs){
        var oRecord = this.getRecord(oArgs.target);
        var tripSheetNo =  YAHOO.lang.dump(oRecord.getData("AmbNo"));
		//document.getElementById("pat_name").value=pt_name;
		callOnClickRequested(tripSheetNo);
		});
	//};   


	 this.onContextMenuClick = function(p_sType, p_aArgs, p_myDataTable) {

			
					var elRow = this.contextEventTarget;   
					elRow = p_myDataTable.getTrEl(elRow);   
                    var oRecord = p_myDataTable.getRecord(elRow);   
                    var trip_no=oRecord.getData("AmbNo");

					leftVal = (screen.width-900) / 2;
					topVal = (screen.height-630) / 2;
				
				    window.open("AmbPrintTripSheet.jsp?p_trip_no="+trip_no,"reportWindow","resizable=1,scrollbars=1,width=900,height=630,left="+leftVal+",top="+topVal);
			}

	
		this.myContextMenu1 = new YAHOO.widget.ContextMenu("mycontextmenu1",
                {trigger:this.myDataTable1.getTbodyEl()});
        this.myContextMenu1.addItem("Print");
		this.myContextMenu1.render("ambRequst");		
	    this.myContextMenu1.clickEvent.subscribe(this.onContextMenuClick, this.myDataTable1);
	
	};


 //-------------------------------Ambulance Chart---------------------------------------------------
	YAHOO.example.CustomFormatting3 = new function() {   
    	 this.myCustomFormatter2 = function(elCell, oRecord, oColumn, oData) {   
			
           var imgSRC;
           switch(oRecord.getData("ambtype")){
			   case 'R':
				   imgSRC="<img src='../../eAE/images/Ambulance.gif' height=25 width=35 />";
			    break;
				
				case 'M':
					imgSRC="<img src='../../eAE/images/boatambulance.gif' height=25 width=35 />";
			    break;
				
				case 'A':
					imgSRC="<img src='../../eAE/images/airambulance.gif' height=25 width=35 />";
			    break;
		   }
            
			if(oRecord.getData("Status3")== 'M') {   
               	 elCell.parentNode.className="Maintance";
				 elCell.innerHTML = imgSRC//oData ;
             }else if(oRecord.getData("Status3")== 'B') {   
                 elCell.parentNode.className="Available";
                 elCell.innerHTML = imgSRC //oData ;
            } else if(oRecord.getData("Status3")== 'A') {   
                 elCell.parentNode.className="AssignedChart";
                 elCell.innerHTML = imgSRC //oData ;
            }  
		 };   

		 YAHOO.widget.DataTable.Formatter.myCustom2 = this.myCustomFormatter2;   
         var myColumnDefs2 = [ 
			 {key:"Status3",label:"Status", sortable:true, formatter:"myCustom2",resizeable:true,width:55},
             {key:"vehicleid",label:"Ambulance ID", formatter:YAHOO.widget.DataTable.formatDate, sortable:true, 
			 sortOptions:{defaultDir:YAHOO.widget.DataTable.CLASS_DESC},resizeable:true,width:140},   
             {key:"vehiclename",label:"Description", formatter:"string",sortable:true, resizeable:true,width:230},       
			 {key:"regnno", label:"Registration No",formatter:"string",sortable:true, resizeable:true,width:160},  
			 {key:"modelno", label:"Make",formatter:"string",sortable:true, resizeable:true,width:150},   
             {key:"ambContname", label:"Contact", formatter:"string",sortable:true, resizeable:true,width:160} ,
			 {key:"lastmileage", label:"Last Mileage", formatter:"number",sortable:true, resizeable:true,width:130}
			 
		];   
   
         this.myDataSource = new YAHOO.util.DataSource(YAHOO.example.Data2.ambChartData);   
         this.myDataSource.responseType = YAHOO.util.DataSource.TYPE_JSON;   
     //    this.myDataSource.responseSchema = {fields: ["vehicleid","vehiclename","regnno","modelno","ambContname","lastmileage","Status3","ambtype","ambDiv"]   
         this.myDataSource.responseSchema = {resultsList : "Response.Results",fields: [{key:"vehicleid",parser:"YAHOO.widget.DataTable.formatDate"},{key:"vehiclename",parser:"string"},{key:"regnno",parser:"string"},{key:"modelno",parser:"string"},{key:"ambContname",parser:"string"},{key:"lastmileage",parser:"number"},{key:"Status3",parser:"myCustom2"},{key:"ambtype",parser:"string"},{key:"ambDiv",parser:"string"}]   };

  
   
         this.myDataTable2 = new YAHOO.widget.DataTable("ambChartTable",   
         myColumnDefs2, this.myDataSource, {scrollable:true, height:"18em",width:"93em",paginator: new YAHOO.widget.Paginator({
				containers:'dt-chartPaginator',
                rowsPerPage: 4,
                pageLinks: 5,
				alwaysVisible :false,
				firstPageLinkLabel:'<img  src=../../eAE/images/FirstPage.gif>',
				previousPageLinkLabel:'<img src=../../eAE/images/ADSprevious.gif>',
				nextPageLinkLabel:'<img src=../../eAE/images/ADSnext.gif>',
				lastPageLinkLabel:'<img src=../../eAE/images/LastPage.gif>'
            })}); 
         
         
         this.myDataTable2.subscribe("columnSortEvent",function(oArgs){
  			if((this.myDataTable2.getColumn("Status3")).hidden==false){
  				var allRows = this.myDataTable2.getRecordSet(); 
  				for(var j=0;j<allRows.getLength();j++){
  					oData=this.myDataTable2.getRecord(j).getData("Status3");
  					eTR=this.myDataTable2.getTrEl(this.myDataTable2.getRecord(j));
  					if(oData !=null  && oData !="" && oData !='undefined'){			
  					if(oData== 'M' || oData=="Maintance") {			
  						eTR.cells[(this.myDataTable2.getColumn("Status3")).getKeyIndex()].className="Maintance";					
  				   }else if(oData== 'B' || oData=="Available") {  				
  						eTR.cells[(this.myDataTable2.getColumn("Status3")).getKeyIndex()].className="Available";   				
  					}else if(oData== 'A'  || oData=="AssignedChart") {   
  						 eTR.cells[(this.myDataTable2.getColumn("Status3")).getKeyIndex()].className="AssignedChart";          
  					}
  					}
  				}	
  				}	
  		},this,true)   ;
 	
         
         
         
         
			
			
		 
		this.myDataTable2.subscribe("rowMouseoverEvent", this.myDataTable2.onEventHighlightRow);
        this.myDataTable2.subscribe("rowMouseoutEvent", this.myDataTable2.onEventUnhighlightRow);
        this.myDataTable2.subscribe("rowClickEvent", this.myDataTable2.onEventSelectRow);
		
		this.myDataTable2.subscribe("rowDblclickEvent", function(oArgs){
        var oRecord = this.getRecord(oArgs.target);
      	if(oRecord.getData('Status3')!='M' && document.getElementById('ambStartedYn').checked != true){
		populateReqstdAmb(oRecord.getData("ambDiv"));
		}
		//callOnClick();
		});

		//To Suppress right click in Ambulance Chart 5/25/2009
		/*this.myContextMenu2 = new YAHOO.widget.ContextMenu("mycontextmenu1",
                {trigger:this.myDataTable2.getTbodyEl()});
        this.myContextMenu1.clickEvent.subscribe(this.onContextMenuClick, this.myDataTable2);
		*/
	};
	

	/* // Using Simple Dialog
	var alertPanel = new YAHOO.widget.SimpleDialog('Alert', {
                fixedcenter: true,
                visible: false,
                modal: true,
                width: '300px',
                constraintoviewport: true, 
				close:true,  
                icon: YAHOO.widget.SimpleDialog.ICON_WARN,
				Body:"Test",
                buttons: [
                    { text: 'OK', handler: function() {
                        alertPanel.hide();
                    }, isDefault: true }
                ]
            });
			alertPanel.setHeader('Alert');
            alertPanel.render("AlertDiv");
	
	YAHOO.namespace("yuiData.app"); 
	YAHOO.yuiData.app.alert = function (msg){
		//Give the body something to render with
		alertPanel.setBody('<div class=alert>'+msg+'</div>');
		//Render the Dialog to the body
		alertPanel.cfg.setProperty('icon', YAHOO.widget.SimpleDialog.ICON_WARN); 
		//Bring the dialog to the top 
		alertPanel.bringToTop(); 
		//Show the panel 
		alertPanel.show();
	}
*/
	YAHOO.namespace("yui.container"); 
		YAHOO.yui.container.overlay = new YAHOO.widget.Panel("Alert", 
		{
			visible:false,iframe:true,modal:true,close:true,draggable:true,underlay:"shadow",zIndex:1000,fixedcenter:true,width:'350px',constraintoviewport:true				
		} );
/* To store the id to focus after callback */
		var focusEle="";	
		YAHOO.yui.container.alert = function (msg,id,info){ 
			//YAHOO.yui.container.overlay.setBody('<div class=alert><span><img src="../../eAE/images/process.gif"></span><span>'+msg+'</span></div>');
			var arr = info.split("~");
			if (arr[0]=='Error')
			{
				YAHOO.yui.container.overlay.setBody('<table><tr><td><img src="../../eAE/images/wdie_error.gif"></td><td><div class=alert>'+msg+'</td></tr></table>');
				YAHOO.yui.container.overlay.setHeader("Error");
			}
			else if (arr[0]=='Process')
			{
				YAHOO.yui.container.overlay.configWidth='50px';
				YAHOO.yui.container.overlay.close=false;
				YAHOO.yui.container.overlay.setBody('<img align src="../../eAE/images/process.gif">');
				YAHOO.yui.container.overlay.setBody('<table><tr><td><img src="../../eAE/images/process.gif"></td><td><div class="process" align="center"> Please Wait.... </td></tr></table>');
				YAHOO.yui.container.overlay.setHeader("Processing");
			}else if(arr[0]=='Result'){
				YAHOO.yui.container.overlay.configWidth='50px';
				YAHOO.yui.container.overlay.close=false;
				YAHOO.yui.container.overlay.setBody('<img align src="../../eAE/images/warn16_1.gif"">');
				YAHOO.yui.container.overlay.setBody('<table><tr><td><img src="../../eAE/images/warn16_1.gif"></td><td><div class="process"> '+msg+'</div></td></tr></table>');
				YAHOO.yui.container.overlay.setHeader("Result");
			}
			YAHOO.yui.container.overlay.render("AlertDiv");
			YAHOO.yui.container.overlay.show();
			focusEle=id;
			YAHOO.yui.container.overlay.hideEvent.subscribe(focusElement);
		}

		function focusElement()
		{
			document.getElementById(focusEle).focus();
		}

		
	/* var myNewPanel = new YAHOO.widget.Panel("myNewPanel", {
	 constraintoviewport:true, x:10, y:10, draggable:true, width:"400px",
	 modal:true, effect:
	 {effect:YAHOO.widget.ContainerEffect.FADE,duration:0.25} } );
	 myNewPanel.cfg.queueProperty("visible",false);
	 myNewPanel.setHeader("Overlay #3 from Script");
	 myNewPanel.setBody("<iframe style='width:100%;height:400px;'></iframe>");
	 myNewPanel.setFooter("© copyright yui");
	 myNewPanel.render("AlertDiv");
			 myNewPanel.show(); */


	Rounded("div#Layer5A","ALICEBLUE","#ADD8E6");
	Rounded("div#Layer6A","ALICEBLUE","#ADD8E6");
	Rounded("div#Layer4A","ALICEBLUE","#ADD8E6");


	
	<% if(wStatus.equals("leftExp")){%>
	setTimeout("expandHorizontaly('Layer5A','Layer6A','imgleft','right','1%','98%','1%','54%')",3500);
	<%}else if(wStatus.equals("rightExp")){%>
	setTimeout("expandHorizontaly('Layer6A','Layer5A','imgRight','left','1%','98%','55%','44%')",3500);
	<%}%>

	

 });   


/*****************************************/
YAHOO.example.container.submitForm = function() {
	//define success handler
	var successHandler = function(o) {
		YAHOO.yui.container.alert(o.responseText,'id','Result');
		goRefreshPage();
	}
	//define failure handler
	var failureHandler = function(o) {
		Alert("Error " + o.status + " : " + o.statusText);
	}
	//define callback object
var callback = {
	success:successHandler,
	failure:failureHandler
	}

	var form = document.getElementById("frmAmbMangmntSystem");
	YAHOO.util.Connect.setForm(form);
	var transaction = YAHOO.util.Connect.asyncRequest("POST","../../servlet/eAE.AmbulanceManagementServlet",callback );
}



   /*   (function() {   
   
         var dd, dd2, clickRadius = 46, startPos,   
             Event=YAHOO.util.Event, Dom=YAHOO.util.Dom;   
   
         YAHOO.util.Event.onDOMReady(function() {   
   
             var el = Dom.get("ambChart1");   
             startPos = Dom.getXY(el);   
             dd = new YAHOO.util.DDProxy(el); 
		

			 var el1 = Dom.get("ambChart2");   
             startPos1 = Dom.getXY(el1);   
             dd3 = new YAHOO.util.DDProxy(el1); 
            
			 dd.clickValidator = function(e) {   
               var el = this.getEl();   
               var region = Dom.getRegion(el);  
	           setSelctedAmbId(el.name);
               var r = clickRadius;   
               var x1 = Event.getPageX(e), y1 = Event.getPageY(e);   
               var x2 = Math.round((region.right+region.left)/2);   
               var y2 = Math.round((region.top+region.bottom)/2);   
               return ( ((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2)) <= r*r );   
             };   
   
             dd.onDragDrop = function(e, id) {   
                 Dom.setXY(this.getEl(), Dom.getXY(id));   
				 populateReqstdAmb(document.frmAmbMangmntSystem.selAmbId.value);
			}   
   
             dd.onInvalidDrop = function(e) {   
                 new YAHOO.util.Motion(    
                     this.id, {    
                         points: {    
                             to: startPos   
                         }   
                     },    
                     0.3,    
                     YAHOO.util.Easing.easeOut    
                 ).animate();   
   
             }   

            dd2 = new YAHOO.util.DDTarget("bottomRight");   
   
         });   
   
     })(); */	 

 </script>
<%//putObjectInBean(bean_id,bean,request);%>
</html>
<%}catch(Exception e){
System.out.println("@@@ Exception in AmbulanceManagementSystem.jsp="+e);
e.printStackTrace();
}%>

