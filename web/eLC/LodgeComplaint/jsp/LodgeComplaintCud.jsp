<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*,com.iba.framework.core.vo.UserPreferences,com.iba.framework.cache.pojo.business.Cache,com.iba.framework.cache.pojo.business.CacheManager,com.iba.framework.core.util.Constants,com.iba.framework.core.util.IBADate,com.iba.ehis.lc.core.util.LcDateFormat,com.iba.framework.core.util.IBADateTime,com.iba.framework.core.util.IBADateValidation"%>
<%@ page import="com.iba.ehis.core.vo.AppVO"%>
<%@ page import="java.util.Date"%>
<%@ page  import="com.iba.ehis.lc.core.vo.SourceBean"%>
<%@ include file="/framework/html/Tag.text"%>
<ibaHTML:html locale="true">
<head>
	<%
	String source=(String)request.getParameter("flag");
	String facilityId=(String)session.getAttribute("facility_id");
	String functionId = (String) session.getAttribute("functionId");
	String moduleId = (String) session.getAttribute("moduleId");
	String addedById = (String) session.getAttribute("login_user");
	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session
			.getAttribute("PREFERRED_STYLE"): "IeStyle.css";
		if (sStyle == null)
			sStyle = "IeStyle.css";
			String qryEven = "QRYEVEN";
			String qryOdd = "QRYODD";
			UserPreferences userPrefs =new UserPreferences();
			//AMRI-SCF-0679
			userPrefs.setDateFormat("dd/MM/yyyy") ;
			userPrefs.setTimeFormat("HH:mm");
			userPrefs.setLocale("en");
			//AMRI-SCF-0679
			/* Cache cache = CacheManager.getCache();
			userPrefs=(UserPreferences)cache.getObject(Constants.USER_SESSION_CACHE, request.getSession().getId(), Constants.USER_PREFS); */ //AMRI-SCF-0679
			String datepattrn=userPrefs.getDateFormat();
			String sb=userPrefs.getDateFormat();
			String tf=userPrefs.getTimeFormat();
			String pattern=sb+" "+tf;
			String locale=userPrefs.getLocale();
		
			IBADateTime todate=LcDateFormat.convertDateFormat(null,request);
			IBADateValidation ibadateVal = new IBADateValidation();
			String conDate = (String)ibadateVal.convertDateJS(todate.toString(),"en",locale,"dd/MM/yyyy HH:mm");
		//	out.println("conDate="+conDate);

		SourceBean obj=new SourceBean();
		try
		{
			/* obj=(SourceBean)CacheManager.getCache().getObject(Constants.USER_SESSION_CACHE,				
					"sessid", "objKey"); */
									
		}catch(Exception e){} 
	
	    //AMRI-SCF-0679
	String srcType = (String) session.getAttribute("sourceType");
	String srctype = (String) session.getAttribute("sourcetype");
	String src = (String) session.getAttribute("source");
	String srcCode = (String) session.getAttribute("sourceCode");
	//AMRI-SCF-0679
		/* String src=obj.getSource();
		String srcType=obj.getSourceType(); */
		request.setAttribute("srcType",srcType);
		request.setAttribute("src",src);
		//request.setAttribute("userFlag",userFlag);
		/* String srctype=obj.getSourcetype();
		String srcCode=obj.getSourceCode(); */


	%>

<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>' />
	<script type="text/javascript" src="<%=request.getContextPath()%>/core/lookup/js/Lookup.js"></script>	
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/hashtable.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/IBADateValidator.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/DynaLookup.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LodgeComplaint.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/validations.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/common.js"></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/eLC/LodgeComplaint/js/LodgeComplaint.js'></script>
		<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>

<script type="text/javascript">
var contentList =new Hashtable();
var  testpopup5="";
var val="";
var selectFlag=false;;
function apply() {
			
				document.LodgeComplaintForm.submit();
}
function settime()
{
 window.setTimeout(AlertMsg,1000);	
}
function AlertMsg()
{
	var obj=document.getElementById("vo.complaintNum");
	var tableObj = document.getElementById("contentTable");
	var len = tableObj.rows.length;
	var flag=checkNull();
	if(flag==true)
		{
				if(parseInt(len)>0)
				{getServerMessage("com.iba.ehis.lc.pnyrequestNum");
				 alert(dwrMessage+" "+":"+obj.value);	
				 apply();
				}
				else{
					getServerMessage("com.iba.ehis.lc.atleastselectthelinenitem");
					alert(dwrMessage);}
				
		}
}
function setval()
{
val=document.getElementById("remarkArea").value;
document.getElementById("remark").value=val;
}
function test5popupactivate(anchor) {
if(testpopup5=="")
{
 testpopup5 = new PopupWindow();
}
val=document.getElementById("remark").value;
document.getElementById("remarkArea").value=val;
testpopup5.height=200;
testpopup5.width=300;
testpopup5.offsetX=-10;
testpopup5.offsetY=10;
testpopup5.autoHide();
getServerMessage("com.iba.ehis.lc.ok");
var buttonLable = dwrMessage;
testpopup5.populate('<title>Remark..</title><link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>"></link><FORM><CENTER><table border="0" celpadding="0" cellspacing="0" width="100%" height="100%"><tr><td class="label" align="center"> Remark: </td></tr><tr><td  align="centet"><textarea rows=5 cols=40 maxlength=2000 name="remarkArea" onkeyup="window.opener.document.getElementById("remarkArea").value=this.value;window.opener.setval()">'+val+'</textarea></td></tr><tr><td  align="center"><input class="button" type="button" onclick="window.close();window.opener.setval()" value="'+buttonLable+'"/></td></tr></table> </FORM></CENTER>');
testpopup5.showPopup(anchor);
setval();
}
function setReasonDesc()
{
	var obj=LodgeComplaintForm["vo.complaint"];
	
	if (obj != null) {
	for (i=0; i<obj.options.length; i++) {
			
           	if(obj.options(i).value==obj.value)
       		{
			  LodgeComplaintForm["vo.complaintDesc"].value=obj.options(i).text;
			  //alert(LodgeComplaintForm["vo.complaintDesc"].value);
   			}
    }
}
}
 function checkAlphaNum(){
	  	 obj =  String.fromCharCode(window.event.keyCode);
	   	var alphaFilter =/^[a-z_A-Z_0-9]+$/;
	   	if (!(alphaFilter.test(obj))) { 
	   		getServerMessage("APP-LC0008");
		parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+dwrMessage;
	   	window.event.keyCode = 27;
   		}
   	}  	
  
//================================================
function LinenViewVo(linenItem,refNo,dateTime,tDate,qty,linenItemDesc,flag) {
	this.refNo = refNo;
	this.dateTime = dateTime;
	this.tDate=tDate;
	this.linenItem = linenItem;
	this.qty = qty;
	this.linenItemDesc=linenItemDesc;
	if (flag == null) {
		flag = "createMethod";
	}
	this.flag = flag;
}
function populateList() {
	selectFlag=checkNull1();
			if(selectFlag==true)
			{ 
		var linenItem=document.LodgeComplaintForm["linenItem"].value;
		if(contentList.get(linenItem) ==null){
			viewObj = new LinenViewVo(linenItem,document.LodgeComplaintForm["refNo"].value,document.LodgeComplaintForm["dateTime"].value,document.LodgeComplaintForm["dateTime1"].value,document.LodgeComplaintForm["qty"].value,document.LodgeComplaintForm["linenDesc"].value)
			contentList.put(linenItem,viewObj)
		
			}else{
					var obj = contentList.get(linenItem)
					if(obj.flag != "createMethod"){
					obj.refNo = document.LodgeComplaintForm["refNo"].value
					obj.dateTime = document.LodgeComplaintForm["dateTime"].value
					obj.tDate = document.LodgeComplaintForm["dateTime1"].value
					obj.qty = document.LodgeComplaintForm["qty"].value
					obj.linenItemDesc = document.LodgeComplaintForm["linenDesc"].value
					obj.flag= updateMethod;
					contentList.put(linenItem,obj);
				}
			}
			showRecords();
			document.LodgeComplaintForm["linenItem"].value="";
			document.LodgeComplaintForm["linenDesc"].value="";
			document.LodgeComplaintForm["qty"].value="";
			document.LodgeComplaintForm["dateTime"].value="";
			document.LodgeComplaintForm["dateTime1"].value="";
			document.LodgeComplaintForm["refNo"].value="";
		}}
function deleteRows() {
	var tableObj = document.getElementById("contentTable");
	var len = tableObj.rows.length;
	for (i = len - 1; i != -1; i--) {
		tableObj.deleteRow(i);
	}
}
function showRecords() {
	var htmlContent = "";
	var tableObj = document.getElementById("contentTable");
	deleteRows();
	index = 0;
	var i=0;
	index = parseInt(index);
	for (  i in contentList.values()) {
		dataObj = contentList.values()[i];
		if (dataObj != null) {
			tableObj = document.getElementById("contentTable");
			if (dataObj.flag != "deleteMethod") {
				var row = tableObj.insertRow(tableObj.rows.length);
				
				var refnoCol = row.insertCell();
				refnoCol.className = "QRYEVEN";
				refnoCol.width="30%";
				refnoCol.innerHTML = dataObj.refNo + "<input type='hidden' name='vo.complaintList[" + (index) + "].referenceRequestNum' id='vo.complaintList[" + (index) + "].referenceRequestNum' value='" + dataObj.refNo + "'>";

				var dateTimeCol = row.insertCell();
				dateTimeCol.className = "QRYEVEN";
				dateTimeCol.width="30%";
				dateTimeCol.innerHTML = dataObj.tDate + "<input type='hidden' name='vo.complaintList[" + (index) + "].referenceRequestDate' id='vo.complaintList[" + (index) + "].referenceRequestDate' value='" + dataObj.dateTime + "'><input type='hidden' name='vo.complaintList[" + (index) + "].referenceRequestDate.pattern' id='vo.complaintList[" + (index) + "].referenceRequestDate.pattern' value='dd/MM/yyyy HH:mm'>" ;

				var linencol = row.insertCell();
				linencol.className = "QRYEVEN";
				linencol.width="30%";
				var str = "";
				str = "<a href=\"javascript:pickupContent('" + dataObj.linenItem + "')\">";
				str += dataObj.linenItemDesc + "</a><input type='hidden' name='vo.complaintList[" + (index) + "].linenItem' id='vo.complaintList[" + (index) + "].linenItem' value='" + dataObj.linenItem + "'>";
				linencol.innerHTML = str;

				var qtyCol = row.insertCell();
				qtyCol.className = "QRYEVEN";
				qtyCol.width="30%";
				qtyCol.innerHTML = dataObj.qty + "<input type='hidden' name='vo.complaintList[" + (index) + "].quantity' id='vo.complaintList[" + (index) + "].quantity' value='" + dataObj.qty + "'>";

				
			} else {
				var str = "<input type='hidden' name='vo.complaintList[" + (index) + "].referenceRequestNum' id='vo.complaintList[" + (index) + "].referenceRequestNum' value='" + dataObj.refNo + "'>"+"<input type='hidden' name='vo.complaintList[" + (index) + "].referenceRequestDate' id='vo.complaintList[" + (index) + "].referenceRequestDate' value='" + dataObj.dateTime + "'>"+"<input type='hidden' name='vo.complaintList[" + index + "].linenItem' id='vo.complaintList[" + index + "].linenItem' value='" + dataObj.linenItemDesc + "'>" + "<input type='hidden' name='vo.complaintList[" + (index) + "].quantity' id='vo.complaintList[" + (index) + "].quantity' value='" + dataObj.qty + "'>";
				document.getElementById("listContentLayer").innerHTML += str;
			}
			index++;
		}
	}
}
function pickupContent(linenItem) {
	var dataObj = contentList.get(linenItem);
	document.LodgeComplaintForm["dateTime"].value = dataObj.dateTime;
	document.LodgeComplaintForm["dateTime1"].value = dataObj.tDate;
	document.LodgeComplaintForm["linenItem"].value = linenItem;
	document.LodgeComplaintForm["linenDesc"].value = dataObj.linenItemDesc;
	document.LodgeComplaintForm["qty"].value = dataObj.qty;
	document.LodgeComplaintForm["refNo"].value = dataObj.refNo;
	// if(obj.flag!=loadMethod)
 			//	contentList.remove(linenItem)
 			showRecords()
}
function cancelRecord(){
			var linenItem=document.LodgeComplaintForm["linenItem"].value
		
			var obj = contentList.get(linenItem)
			if(obj !=null){
				if(obj.flag != "createMethod"){
					obj.flag=deleteMethod
					 contentList.put(linenItem,obj)
				}else{
					contentList.remove(linenItem)
				}
			}
				showRecords();
		}	
//=============================================

function setReqRefNo(dat){
 var max=0;
 for(prop in dat) {
	if(prop!=null){
	if(parseInt(prop)>parseInt(max))
			max=parseInt(prop);
	}
 }
 max=parseInt(max)+1;
document.LodgeComplaintForm["refNo"].value=max;
}

</script>
 <IBATagLibs:initCalendar />
</head>
<body onload="getComplaintNo();reasonlist();CurrDate();" OnMouseDown="CodeArrest()" onKeyDown="lockKey()">

	<ibaHTML:form action="/LodgeComplaintAction.do"	target="messageFrame" > 
		<table border='0 ' cellpadding='2' cellspacing='0' width='80%' align='center'>
		
				<tr>
						<td class='label'  nowrap="nowrap" align="right">
								<ibaBean:message key="com.iba.ehis.lc.lodgeComplaint.complaintNo"	bundle="lcLabels" />
						</td>
						<td>
							 <ibaHTML:text property="vo.complaintNum" maxlength="10" size='8' readonly="true"/>
							 <img src="framework/images/mandatory.gif"></img>
						</td>
						<td class='label'  nowrap="nowrap" align="right">
								<ibaBean:message key="com.iba.ehis.lc.lodgeComplaint.complaintDate"	bundle="lcLabels" />
						</td>
						<td>
							<input type=text property="complaintDate" readonly="true" value="<%=conDate%>"/>
							 <img src="framework/images/mandatory.gif"></img>
							 <ibaHTML:hidden property="vo.complaintDate" value="<%=todate.toString()%>" />
							 
							 <ibaHTML:hidden property="vo.complaintDate.pattern" value="<%=pattern%>" />

						</td>
							
				</tr>
				<tr>
							<td align="right" width="30%" CLASS='label' nowrap="nowrap">
								<ibaBean:message
									key="com.iba.ehis.lc.lodgeComplaint.complaintSourceType"
									bundle="lcLabels" />
							</td>
							<td width="30%">
							<ibaLogic:equal value="Laundry" scope="request" parameter="flag"> 
							<ibaHTML:select property="vo.complaintSourceType" >
							<ibaHTML:option value=""><ibaBean:message key="com.iba.ehis.lc.select" bundle="lcLabels" />
							</ibaHTML:option>
							<ibaHTML:option value="L"><ibaBean:message key="com.iba.ehis.lc.laundry" bundle="lcLabels" />
							</ibaHTML:option>
							</ibaHTML:select>
							</ibaLogic:equal>  

							<ibaLogic:equal value="" scope="request" parameter="flag"> 
							<input type=text name="sourceType" id="sourceType" maxlength="10" readonly="true" value="<%=srcType%>"/>
							 <ibaHTML:hidden property="vo.complaintSourceType" value="<%=srctype%>"/>
							 </ibaLogic:equal>  
						
							<img src="framework/images/mandatory.gif"></img>
							</td>
						
							<td align="right" width="20%" CLASS='label' nowrap="nowrap">
							<ibaLogic:equal value="" scope="request" parameter="flag">  
								<ibaBean:message
									key="com.iba.ehis.lc.lodgeComplaint.complaintSource"
									bundle="lcLabels" />
							 </ibaLogic:equal>
							</td>
							<td width="40%" nowrap="nowrap" >
							<ibaLogic:equal value="Laundry" scope="request" parameter="flag">  
							<input type='hidden' maxlength=40 name="complaintSourceDesc" id="complaintSourceDesc" onblur="complaintCommonLookup('complaintSource')"/>
							<ibaHTML:hidden property="vo.complaintSource"  />
							<!-- <input id="bt2" type='button' class="BUTTON"  value='?' onclick='showLookup()' /> -->
							 </ibaLogic:equal>
							 <ibaLogic:equal value="" scope="request" parameter="flag"> 
							<input type='text' name="complaintSourceDesc" id="complaintSourceDesc" value="<%=src%>" />
							<ibaHTML:hidden property="vo.complaintSource" value="<%=srcCode%>" />
							<img src="framework/images/mandatory.gif"></img>
							  </ibaLogic:equal>
							
							</td>
						</tr>
						<tr>
							<td align="right" width="30%" CLASS='label' nowrap="nowrap">
								<ibaBean:message
									key="com.iba.ehis.lc.lodgeComplaint.complaintAgnSourceType"
									bundle="lcLabels" />
							</td>
							<td width="30%">
							<ibaHTML:select property="vo.complaintAgainstSourceType" >
							<ibaHTML:option value="W"><ibaBean:message key="com.iba.ehis.lc.ward" bundle="lcLabels" />
							</ibaHTML:option>
							<ibaHTML:option value="C"><ibaBean:message key="com.iba.ehis.lc.clinic" bundle="lcLabels" />
							</ibaHTML:option>
							<ibaHTML:option value="D"><ibaBean:message key="com.iba.ehis.lc.department" bundle="lcLabels" />
							</ibaHTML:option>
							<ibaHTML:option value="L"><ibaBean:message key="com.iba.ehis.lc.laundry" bundle="lcLabels" />
							</ibaHTML:option>
							</ibaHTML:select>
												
							<img src="framework/images/mandatory.gif"></img>
							</td>
						
							<td align="right" width="20%" CLASS='label' nowrap="nowrap">
								<ibaBean:message
									key="com.iba.ehis.lc.lodgeComplaint.complaintAgnSource"
									bundle="lcLabels" />
							</td>
							<td width="40%" nowrap="nowrap" >
							<input type='text' name="complaintAgainstSourceDesc" id="complaintAgainstSourceDesc" maxlength=40 onblur="complaintCommonLookup('complaintAgainstSourceDesc')"/>
							<ibaHTML:hidden property="vo.complaintAgainstSource"  />
							<input id="btg" type='button' class="BUTTON"  value='?' onclick='showLookupAgn()' />
							</td>
						</tr>
						<tr >
						<td class='label'  nowrap="nowrap" align="right">
								<ibaBean:message key="com.iba.ehis.lc.lodgeComplaint.complaintActivity"	bundle="lcLabels" />
						</td>
						<td class='label' colspan='3'>
						<ibaHTML:select property="vo.complaintActivity" onchange="hideListBlock(this)">
							<ibaHTML:option value=""><ibaBean:message key="com.iba.ehis.lc.select" bundle="lcLabels" /></ibaHTML:option>
								<ibaLogic:equal value="Laundry" scope="request" parameter="flag">
									<ibaHTML:option value="2" ><ibaBean:message key="com.iba.ehis.lc.lodgeComplaint.issueWithCleaning"	bundle="lcLabels" /></ibaHTML:option>
									<ibaHTML:option value="5"><ibaBean:message key="com.iba.ehis.lc.lodgeComplaint.requestForMending"	bundle="lcLabels" /></ibaHTML:option>
									<ibaHTML:option value="6"><ibaBean:message key="com.iba.ehis.lc.lodgeComplaint.receiveLinenAfterMending"	bundle="lcLabels" /></ibaHTML:option>
									<ibaHTML:option value="7"><ibaBean:message key="com.iba.ehis.lc.lodgeComplaint.others"	bundle="lcLabels" /></ibaHTML:option>
							</ibaLogic:equal>
							<ibaLogic:equal value="" scope="request" parameter="flag"> 
								<ibaHTML:option value="1"><ibaBean:message key="com.iba.ehis.lc.lodgeComplaint.newLinenIssue"	bundle="lcLabels" /></ibaHTML:option>
								<ibaHTML:option value="3" ><ibaBean:message key="com.iba.ehis.lc.lodgeComplaint.lateDelivery"	bundle="lcLabels" /></ibaHTML:option>
								<ibaHTML:option value="4"><ibaBean:message key="com.iba.ehis.lc.lodgeComplaint.issueWithLinenDelivery"	bundle="lcLabels" /></ibaHTML:option>
								<ibaHTML:option value="7"><ibaBean:message key="com.iba.ehis.lc.lodgeComplaint.others"	bundle="lcLabels" /></ibaHTML:option>
							</ibaLogic:equal>
						</ibaHTML:select>
						<img src="framework/images/mandatory.gif"></img>
					</td>
				</tr>
				<tr >
					<td class='label'  nowrap="nowrap" align="right">
						<ibaBean:message key="com.iba.ehis.lc.complaint"	bundle="lcLabels" />
					</td>
						<td class='label' colspan='3'>
							<ibaHTML:select property="vo.complaint"  onclick="setReasonDesc()">
							<ibaHTML:option value=""><ibaBean:message key="com.iba.ehis.lc.select" bundle="lcLabels" />
							</ibaHTML:option>
							</ibaHTML:select>
							<ibaHTML:hidden property="vo.complaintDesc"/>
							
							<img src="framework/images/mandatory.gif"></img>
						</td>
						</tr>
						
						<tr >
						<td class='label'  nowrap="nowrap" align="right">
								<ibaBean:message key="com.iba.ehis.lc.lodgeComplaint.complaintBy"	bundle="lcLabels" />
						</td>
						<td class='label' colspan='3' >
							 <ibaHTML:text property="vo.complaintBy" value="<%=addedById%>" />
							 <img src="framework/images/mandatory.gif"></img>
						</td>
						</tr>
		</table>
<br><br>
<div id="lowerBlock">
<table  align="center" border='0' cellpadding='0' cellspacing='0'
			width='80%' align='center'>
					<tr>
							<td class='label' align="right">
								<ibaBean:message key="com.iba.ehis.lc.lodgeComplaint.refNo" bundle="lcLabels" />
							</td>
							<td nowrap class='button' >
								<input type="text" name="refNo" id="refNo" onblur="complaintCommonLookup('refNo')" />
								<input type='button' class="BUTTON"  value='?' onclick='showLookupRefNo()' />
								<img src="framework/images/mandatory.gif"></img>
							</td>
							<td class='label' align="right">
								<ibaBean:message key="com.iba.ehis.lc.lodgeComplaint.dateTime"  bundle="lcLabels" />
							</td>
							<td nowrap class='button' >
								<input type="text" name="dateTime1" id="dateTime1" readonly="readonly" />
								<input type="hidden" name="dateTime" id="dateTime"  />
								<img src="framework/images/mandatory.gif"></img>
							</td>
						</tr>
							<tr>
								<td class='label' align='right' >
									<ibaBean:message key="com.iba.ehis.lc.linenItem"  bundle="lcLabels" />
								</td>
							<td nowrap class='button'>
							<input type="hidden" name="linenItem" id="linenItem"  />
							<input type="text" name="linenDesc" id="linenDesc" onblur="complaintCommonLookup('linenDesc')"  />
							<input type='button' class="BUTTON"  value='?' onclick='showRefNoDetail()' />
							<img src="framework/images/mandatory.gif"></img>
							</td>					
							<td class='label' align="right">
								<ibaBean:message key="com.iba.ehis.lc.requestForCleaningLinen.quantity"  bundle="lcLabels" />
							</td>
							<td>
								<input type="text" name="qty" id="qty" onkeyup="checkNumber1(this)" />
								<img src="framework/images/mandatory.gif"></img>

							</td>
						</tr>
						<tr>
							<td colspan="4" align='right'>
							<input class="BUTTON" type="button" name="select" id="select" value="<ibaBean:message key='com.iba.ehis.lc.selectforbutton'  bundle='lcLabels' />" onClick="populateList()" />
							<input class="BUTTON" type="button" name="cancel" id="cancel" value="<ibaBean:message key='com.iba.ehis.lc.cancel'  bundle='lcLabels' />" onClick="cancelRecord()" />
							</td>
						</tr>

		</table></div>

<br><br><div id="tableid">
<table border='1' cellpadding='2' cellspacing='0' width='80%'  align='center' >
						 <tr>
						 	<td  colspan=4>
								<b><ibaBean:message key="com.iba.ehis.lc.lodgeComplaint.referenceDetail"  bundle="lcLabels" /></b>
							</td>
						 </tr>
						<tr>
							<th align="center" width="30%">
								<ibaBean:message key="com.iba.ehis.lc.lodgeComplaint.refNo"  bundle="lcLabels" />
							</th>
							<th align="center" width="30%">
								<ibaBean:message key="com.iba.ehis.lc.lodgeComplaint.dateTime"  bundle="lcLabels" />
							</th>
							<th align="center" width="30%">
								<ibaBean:message key="com.iba.ehis.lc.linenItem"  bundle="lcLabels" />
							</th>
							<th align="center" width="30%">
								<ibaBean:message key="com.iba.ehis.lc.requestForCleaningLinen.quantity"  bundle="lcLabels" />
							</th>
							

						</tr>
						
		</table></div>
		<div id="listContentLayer" align="center">
		
					<table border='1' cellpadding='2' cellspacing='0' width='80%'
						 id="contentTable" >
						 
					</table>
				</div>


		<ibaHTML:hidden property="vo.addedFacilityId" value="<%=facilityId%>" />			
		<ibaHTML:hidden property="vo.functionId" value="<%=functionId%>" />
		<ibaHTML:hidden property="vo.moduleId" value="<%=moduleId%>" />
		<input type=hidden name="laundry" id="laundry" value="<%=source%>" />
		<input type=hidden name="languageId" id="languageId" value="<%=locale%>" />
		<input type=hidden name="vo.locale" id="vo.locale" value="<%=locale%>" />
		<ibaHTML:hidden property="vo.mode" />
		<table align="center"><tr><td><input type="button" value="<ibaBean:message key='com.iba.ehis.lc.submit'  bundle='lcLabels' />" name="Submit" class="BUTTON" onclick="getComplaintNo();settime()" /></td></tr></table>
	</ibaHTML:form>
</body>

</script>
</ibaHTML:html>

