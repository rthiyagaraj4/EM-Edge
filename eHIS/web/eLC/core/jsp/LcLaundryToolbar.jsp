<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="com.iba.framework.core.util.Constants"%>
<%@ page language="java"%>
<%@ include file="/framework/html/Tag.text"%>
<html> 
	<head>
<%
		String textLabel=(String)session.getAttribute("textLabel");
		String functionLabel=(String)session.getAttribute("functionLabel");
		if(textLabel==null)textLabel="";
		if(functionLabel==null)functionLabel="";
		String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
		.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
		:"IeStyle.css" ;
		if(sStyle==null)sStyle="IeStyle.css";

		String loggedInUser = (String) session.getAttribute("login_user"); 
		String facilityId=(String)session.getAttribute("facility_id");
%>
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>'></link>
<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/hashtable.js"></script>
		<script type="text/javascript"	src='<%=request.getContextPath()%>/eLC/IssueOfLinen/js/IssueOfLinen.js'/>
	<script type="text/javascript" src="<%=request.getContextPath()%>/eLC/DeliverCleanedLinen/js/DeliverCleanedLinen.js">
	</script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/eLC/EnterCleanedLinen/js/EnterCleanedLinen.js">
	</script>
	<Script type="text/javascript" src="<%=request.getContextPath()%>/eLC/WriteOffLinen/js/WriteOffLinen.js"></Script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/RequestForCleaning.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/extCleaning.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<Script>
var userFlag="";
var issueLabel="";
	   function activate( newimg ) {
			return true;
		}
		
		function onDelete(){
		  parent.deleterec();
		}

		function onApply() {
			parent.apply() ;
			}
		
		function writeOff()
		{
		var flag="Laundry";
		var functionId="LC_WRITEOFF_LNDRY";
		parent.content.location.href=contextPath+"/eLC/WriteOffLinen/jsp/WriteOffLinenFrames.jsp?functionId="+functionId+"&flag="+flag;
		}
		function delivery1()
		{
		var functionId="LC_DEL_CLEANED_LINEN";
		parent.content.location.href = contextPath + "/eLC/DeliverCleanedLinen/jsp/DeliverCleanedLinenFrames.jsp?method="+loadMethod+"&functionId="+functionId;
		}
		function closeWindow()
		{
		parent.parent.window.close();
		}
		function switchFunction()
		{
			 parent.parent.frames[1].expand(this);
			 parent.parent.frames[2].location.href = contextPath +"/eCommon/jsp/maindisplay.jsp";
		}
		function home()
		{
		parent.parent.frames[2].location.href = contextPath + "/eLC/IssueOfLinen/jsp/IssueOfLinenMain.jsp";
		}
		function EnterLinen()
		{
		var moduleId="LC";
		var functionId="LC_ENTER_CLEAN_LINEN";
			parent.content.location.href=contextPath+"/eLC/EnterCleanedLinen/jsp/EnterCleanedLinenFrames.jsp?&vo.functionId="+functionId+"&vo.moduleId="+moduleId;
		}
		function IssueLinen()
		{
		var moduleId="LC";
		var functionId="LC_ISSUE";
			parent.content.location.href = contextPath + "/eLC/IssueOfLinen/jsp/IssueOfLinenFrames.jsp?vo.viewCode=requestsListFrame&method="+loadMethod+"&vo.functionId="+functionId;
		}
		function xCleaning()
		{
		var moduleId="LC";
		var functionId="LC_EXTERN_CLEANING";
		parent.content.location.href = contextPath + "/eLC/ExternalCleaning/jsp/RequestForExternalCleaningMainFrames.jsp?&vo.functionId="+functionId+"&vo.moduleId="+moduleId;
		}
		function sendMending()
		{
		var moduleId="LC";
		var functionId="LC_SEND_FOR_MEND_LINEN";
		parent.content.location.href = contextPath + "/eLC/SendLinenForMending/jsp/RequestForMendingMainFrames.jsp?&vo.functionId="+functionId+"&vo.moduleId="+moduleId;
		}
		function receiveMending()
		{
		
			var moduleId="LC";
			var functionId="LC_RECEIVE_MEND_LINEN";
			parent.content.location.href = contextPath + "/eLC/IssueLinenAfterMending/jsp/IssueOfLinenAfterMendingFrames.jsp?vo.viewCode=requestsListFrame&method="+loadMethod+"&vo.functionId="+functionId+"&vo.moduleId="+moduleId;

		}
	function complaint()
	{
		//alert()
		var moduleId="LC";
		var functionId="LC_LODGE_COMPLAINT";
		var flag="Laundry";	parent.content.location.href=contextPath+"/LodgeComplaintAction.do?method="+loadMethod+"&vo.functionId="+functionId+"&flag="+flag;
	}
var exFlag="";
function checkExternalParam()
{
	facilityId="<%=facilityId%>";
	extCleaning.getPararmForFacility(facilityId,getExternalParam)
	function getExternalParam(dat)
	{
		for(prop in dat)
		{if(dat[prop]!=""||dat[prop]!=null)
			{
			exFlag=prop;
			if(prop=='N'){
				document.getElementById("externalCleaning").style.visibility='hidden';
				document.getElementById("exLabel").style.visibility='hidden';
			}else
				{
				document.getElementById("externalCleaning").style.visibility='visible';
				document.getElementById("exLabel").style.visibility='visible';
				}

			}
		}
	}
}

	function cleaning() 
	{
		loggedInUser="<%=loggedInUser%>";
		facilityId="<%=facilityId%>";
		//alert(loggedInUser+"=="+facilityId)
		RequestForCleaning.getDirtyLinenParam(facilityId,getDirty);
		checkUser();
	}
	function getDirty(rec)
	{
		facilityId="<%=facilityId%>";
		//alert("getDirty===" +facilityId)
		var dt=new Date();

		for(prop in rec)
		{
			if(prop!=null)
				{	
				  dirtyFlag=prop;
				  dt=rec[prop]
				}
		}
		cutoffTime=dt;
		//alert(cutoffTime)
			//	alert("getDirty===" +facilityId)
			RequestForCleaning.getOverRideWardConf(facilityId,getconf); 
			
}

function checkUser()
{
	loggedInUser="<%=loggedInUser%>";
	facilityId="<%=facilityId%>";
	RequestForCleaning.getLcUser(facilityId,loggedInUser,getUser);
}

function getUser(data)
{
   for(prop in data)
	   {
		if(prop!=null)
			{
			    document.getElementById("LaundryConf").value=data[prop];
				if(prop==loggedInUser.toUpperCase()){
				userFlag="Y";
				document.getElementById("cleaningLabel").style.visibility="visible";
				}
				else
				{	
			    userFlag="N";
				document.getElementById("Cleaning").style.visibility="hidden";
				document.getElementById("cleaningLabel").style.visibility="hidden";
			   }
			}

		}
		if(userFlag==null||userFlag=="")
		{	 
			userFlag="N"; 
			document.getElementById("Cleaning").style.visibility="hidden";
			document.getElementById("cleaningLabel").style.visibility="hidden";
		
		}
		//checkExternalParam();
 }



   function getconf(data1)
   {
	   var conf="";
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
	   for(prop1 in data1)
	   {
		  if(prop1!=null)
			  {
				delDate=data1[prop1];
			  }
	   }
	 
	   conf=document.getElementById("LaundryConf").value;
		if(conf!="")
			{	
			if(conf=='Y') 
				parent.content.location.href = contextPath + "/eLC/RequestForCleaningLinen/jsp/RequestForCleaningLinenMainFrames.jsp?flag=Y&dirtyFlag="+dirtyFlag+"&cutoffTime="+cutoffTime+"&delParamDate="+delDate+"&userFlag="+userFlag;	
				else
				parent.content.location.href = contextPath + "/eLC/RequestForCleaningLinen/jsp/RequestForCleaningLinenMainFrames.jsp?flag=N&dirtyFlag="+dirtyFlag+"&cutoffTime="+cutoffTime+"&delParamDate="+delDate+"&userFlag="+userFlag;
			} 
		else
			{
				getServerMessage("APP-LC00022");
				var msg=dwrMessage;
				alert(msg);
			}

  }

function changeImg(obj)
{
	if(obj.id=="create")
	{
		obj.src="../../../eLC/core/images/L-Issue2.gif";
		document.getElementById("Delivery").src="../../../eLC/core/images/L-Delivery1.gif";
		document.getElementById("writeoff").src="../../../eLC/core/images/L-Writeoff1.gif";
		document.getElementById("Entry").src="../../../eLC/core/images/L-Entry1.gif";
		document.getElementById("mendingS").src="../../../eLC/core/images/L-MendingSend1.gif";
		document.getElementById("mendingR").src="../../../eLC/core/images/L-MendingRecive1.gif";
		document.getElementById("Lcomplaint").src="../../../eLC/core/images/L-Complaint1.gif";
		document.getElementById("Cleaning").src="../../../eLC/core/images/W-Cleaning1.gif";
		//document.getElementById("externalCleaning").src="../../../eLC/core/images/L-externalCleaning1.gif";
	}
	
	else if(obj.id=="Delivery")
	{
		obj.src="../../../eLC/core/images/L-Delivery2.gif";
		document.getElementById("create").src="../../../eLC/core/images/L-Issue1.gif";
		document.getElementById("writeoff").src="../../../eLC/core/images/L-Writeoff1.gif";
		document.getElementById("Entry").src="../../../eLC/core/images/L-Entry1.gif";
		document.getElementById("mendingS").src="../../../eLC/core/images/L-MendingSend1.gif";
		document.getElementById("mendingR").src="../../../eLC/core/images/L-MendingRecive1.gif";
		document.getElementById("Lcomplaint").src="../../../eLC/core/images/L-Complaint1.gif";
		document.getElementById("Cleaning").src="../../../eLC/core/images/W-Cleaning1.gif";
		//document.getElementById("externalCleaning").src="../../../eLC/core/images/L-externalCleaning1.gif";
	}
	else if(obj.id=="writeoff")
	{
		obj.src="../../../eLC/core/images/L-Writeoff2.gif";
		document.getElementById("create").src="../../../eLC/core/images/L-Issue1.gif";
		document.getElementById("Delivery").src="../../../eLC/core/images/L-Delivery1.gif";
		document.getElementById("Entry").src="../../../eLC/core/images/L-Entry1.gif";
		document.getElementById("mendingR").src="../../../eLC/core/images/L-MendingRecive1.gif";
		document.getElementById("mendingS").src="../../../eLC/core/images/L-MendingSend1.gif";
		document.getElementById("Lcomplaint").src="../../../eLC/core/images/L-Complaint1.gif";
		document.getElementById("Cleaning").src="../../../eLC/core/images/W-Cleaning1.gif";
		//document.getElementById("externalCleaning").src="../../../eLC/core/images/L-externalCleaning1.gif";
	}
	else if(obj.id=="Entry")
	{
		obj.src="../../../eLC/core/images/L-Entry2.gif";
		document.getElementById("create").src="../../../eLC/core/images/L-Issue1.gif";
		document.getElementById("Delivery").src="../../../eLC/core/images/L-Delivery1.gif";
		document.getElementById("writeoff").src="../../../eLC/core/images/L-Writeoff1.gif";
		document.getElementById("mendingS").src="../../../eLC/core/images/L-MendingSend1.gif";
		document.getElementById("mendingR").src="../../../eLC/core/images/L-MendingRecive1.gif";
		document.getElementById("Lcomplaint").src="../../../eLC/core/images/L-Complaint1.gif";
		document.getElementById("Cleaning").src="../../../eLC/core/images/W-Cleaning1.gif";
		///document.getElementById("externalCleaning").src="../../../eLC/core/images/L-externalCleaning1.gif";
	}
	else if(obj.id=="mendingS")
	{
		obj.src="../../../eLC/core/images/L-MendingSend2.gif";
		document.getElementById("create").src="../../../eLC/core/images/L-Issue1.gif";
		document.getElementById("Delivery").src="../../../eLC/core/images/L-Delivery1.gif";
		document.getElementById("writeoff").src="../../../eLC/core/images/L-Writeoff1.gif";
		document.getElementById("Entry").src="../../../eLC/core/images/L-Entry1.gif";
		document.getElementById("mendingR").src="../../../eLC/core/images/L-MendingRecive1.gif";
		document.getElementById("Lcomplaint").src="../../../eLC/core/images/L-Complaint1.gif";
		document.getElementById("Cleaning").src="../../../eLC/core/images/W-Cleaning1.gif";
		//document.getElementById("externalCleaning").src="../../../eLC/core/images/L-externalCleaning1.gif";
	}
	else if(obj.id=="mendingR")
	{
		obj.src="../../../eLC/core/images/L-MendingRecive2.gif";
		document.getElementById("create").src="../../../eLC/core/images/L-Issue1.gif";
		document.getElementById("Delivery").src="../../../eLC/core/images/L-Delivery1.gif";
		document.getElementById("writeoff").src="../../../eLC/core/images/L-Writeoff1.gif";
		document.getElementById("Entry").src="../../../eLC/core/images/L-Entry1.gif";
		document.getElementById("mendingS").src="../../../eLC/core/images/L-MendingSend1.gif";
		document.getElementById("Lcomplaint").src="../../../eLC/core/images/L-Complaint1.gif";
		document.getElementById("Cleaning").src="../../../eLC/core/images/W-Cleaning1.gif";
		//document.getElementById("externalCleaning").src="../../../eLC/core/images/L-externalCleaning1.gif";
	}
	else if(obj.id=="Lcomplaint")
	{
		obj.src="../../../eLC/core/images/L-Complaint2.gif";
		document.getElementById("create").src="../../../eLC/core/images/L-Issue1.gif";
		document.getElementById("Delivery").src="../../../eLC/core/images/L-Delivery1.gif";
		document.getElementById("writeoff").src="../../../eLC/core/images/L-Writeoff1.gif";
		document.getElementById("Entry").src="../../../eLC/core/images/L-Entry1.gif";
		document.getElementById("mendingS").src="../../../eLC/core/images/L-MendingSend1.gif";
		document.getElementById("mendingR").src="../../../eLC/core/images/L-MendingRecive1.gif";
		document.getElementById("Cleaning").src="../../../eLC/core/images/W-Cleaning1.gif";
		//document.getElementById("externalCleaning").src="../../../eLC/core/images/L-externalCleaning1.gif";
		
	}
	else if(obj.id=="Cleaning")
	{
		obj.src="../../../eLC/core/images/W-Cleaning2.gif";
		//document.getElementById("externalCleaning").src="../../../eLC/core/images/L-externalCleaning1.gif";
		document.getElementById("create").src="../../../eLC/core/images/L-Issue1.gif";
		document.getElementById("Delivery").src="../../../eLC/core/images/L-Delivery1.gif";
		document.getElementById("writeoff").src="../../../eLC/core/images/L-Writeoff1.gif";
		document.getElementById("Entry").src="../../../eLC/core/images/L-Entry1.gif";
		document.getElementById("mendingS").src="../../../eLC/core/images/L-MendingSend1.gif";
		document.getElementById("mendingR").src="../../../eLC/core/images/L-MendingRecive1.gif";
		document.getElementById("Lcomplaint").src="../../../eLC/core/images/L-Complaint1.gif";

	}
/*	else if(obj.id=="externalCleaning")
	{
		obj.src="../../../eLC/core/images/L-externalCleaning2.gif";
		document.getElementById("Cleaning").src="../../../eLC/core/images/W-Cleaning1.gif";
		document.getElementById("create").src="../../../eLC/core/images/L-Issue1.gif";
		document.getElementById("Delivery").src="../../../eLC/core/images/L-Delivery1.gif";
		document.getElementById("writeoff").src="../../../eLC/core/images/L-Writeoff1.gif";
		document.getElementById("Entry").src="../../../eLC/core/images/L-Entry1.gif";
		document.getElementById("mendingS").src="../../../eLC/core/images/L-MendingSend1.gif";
		document.getElementById("mendingR").src="../../../eLC/core/images/L-MendingRecive1.gif";
		document.getElementById("Lcomplaint").src="../../../eLC/core/images/L-Complaint1.gif";

	}*/
}
function displayLabel(arg)
{
flag=arg;

if(flag=='I')
issueLabel="<ibaBean:message key="com.iba.ehis.lc.issueOfLinen"	bundle="lcLabels" />";
if(flag=='D')
issueLabel="<ibaBean:message key="com.iba.ehis.lc.deliverCleanedLinen"	bundle="lcLabels" />";
if(flag=='E')
issueLabel="<ibaBean:message key="com.iba.ehis.lc.enterCleanedLinen"	bundle="lcLabels" />";
if(flag=='W')
issueLabel="<ibaBean:message key="com.iba.ehis.lc.writeofflinen"	bundle="lcLabels" />";
if(flag=='M')
issueLabel="<ibaBean:message key="com.iba.ehis.lc.sendLinenForMending"	bundle="lcLabels" />";
if(flag=='R')
issueLabel="<ibaBean:message key="com.iba.ehis.lc.receivelinenaftermending"	bundle="lcLabels" />";
if(flag=='Cl')
issueLabel="<ibaBean:message key="com.iba.ehis.lc.requestForCleaningLinen"	bundle="lcLabels" />";	
if(flag=='C')
issueLabel="<ibaBean:message key="com.iba.ehis.lc.lodgeComplaint" bundle="lcLabels" />";
if(flag=='x')
issueLabel="<ibaBean:message key="com.iba.ehis.lc.externalCleaning.externalCleaningReq" bundle="lcLabels" />";
document.getElementById("desc").innerText=issueLabel;
}
	</Script>
		
	</head>
	<body class="body" LEFTMARGIN='0' RIGHTMARGIN='0' topmargin='0' width='100%' bgcolor='#ffffff' onLoad="checkUser();" >


<form name="LcToolbar_form" id="LcToolbar_form" >

	<table  width="100%" cellspacing='0' cellpading='0' >
		<tr>
		<td class='PATIENTLINECOLOR'  align="top" colspan='12'>
			<ibaBean:message key="com.iba.ehis.lc.laundry" bundle="lcLabels" />
		</td>
		<td class='PATIENTLINECOLOR' align='right'>
		<img src="../../../eLC/core/images/mc_homepage.gif" height=18
								onclick="this.src='../../../eLC/core/images/mc_homepage.gif' ;home();" />
		<img src="../../../eLC/core/images/mc_switch.gif" height=18
								onclick="this.src='../../../eLC/core/images/mc_homepage.gif' ;switchFunction();" />
		<img src="../../../eLC/core/images/mc_close.gif" height=18
								onclick="this.src='../../../eLC/core/images/mc_close.gif' ;closeWindow();" />
		</td >
		</tr>
		</table>
		<table  width="100%" cellspacing='0' cellpading='0'>
		<tr>
			<td  align="left" width="100%" >
				<table cellspacing='0' cellpading='0'  >
				<tr>
					<td colspan='3'></td>
					<td class='label'><b><ibaBean:message key="com.iba.ehis.lc.cleaning" bundle="lcLabels" /></b></td>
					<td colspan=''></td>
					<td class='label' colspan='5' ><b><center><ibaBean:message key="com.iba.ehis.lc.mending" bundle="lcLabels" /></b></center></td>
					<td colspan='2'></td>
				</tr>
					<tr >
						<td nowrap="false">
							<img id="create"  src="../../../eLC/core/images/L-Issue1.gif"
								onclick="displayLabel('I');IssueLinen();changeImg(this);parent.messageFrame.location.href='MessageFrame.jsp'"
								value='Create' name='create' ></img>
						</td>

						<td width=10%>
						</td>
											
						<td nowrap="false" align="right">
							<img id="Cleaning" src="../../../eLC/core/images/W-Cleaning1.gif" onclick="cleaning();displayLabel('Cl');changeImg(this);parent.messageFrame.location.href='MessageFrame.jsp'"
							name='load' />
						</td>
						<td nowrap="false" align="center">
							<img id="Entry" src="../../../eLC/core/images/L-Entry1.gif" onclick="this.src='../../../eLC/core/images/L-Entry2.gif' ;displayLabel('E');EnterLinen();changeImg(this);parent.messageFrame.location.href='MessageFrame.jsp'"
								value='Entry'/>
						</td>
						<td nowrap="false" align="left">
							<img id="Delivery" src="../../../eLC/core/images/L-Delivery1.gif"  onclick="displayLabel('D');delivery1();changeImg(this);parent.messageFrame.location.href='MessageFrame.jsp'" name='Delivery'/>
						
						</td>

						<td width=10%>
						</td>
						
						<td nowrap="false" align="right">
							<img id="mendingS" src="../../../eLC/core/images/L-MendingSend1.gif"  
								onclick="displayLabel('M');changeImg(this);sendMending();parent.messageFrame.location.href='MessageFrame.jsp'"
								name='mendingS' ></img>
								
						</td>
						<td  nowrap="false">
							<img id="mendingR" src="../../../eLC/core/images/L-MendingRecive1.gif"  
								onclick="displayLabel('R');changeImg(this);receiveMending();parent.messageFrame.location.href='MessageFrame.jsp'"
								 name='mendingR'></img>
						</td>
						<td width=10%>
						</td>
						<td nowrap="false" align="right">
							<img id='Lcomplaint'  src="../../../eLC/core/images/L-Complaint1.gif"  
								onclick="complaint();displayLabel('C');changeImg(this)
							;parent.messageFrame.location.href='MessageFrame.jsp'"
							name='Lcomplaint' ></img>
						</td>
						<td nowrap="false">
							<img id="writeoff" src="../../../eLC/core/images/L-Writeoff1.gif"  onclick="writeOff(); ;displayLabel('W');changeImg(this);parent.messageFrame.location.href='MessageFrame.jsp'"
								 name='writeoff' ></img>
						</td>
						
					</tr>
					<tr >
						<td  class='label' nowrap="false">
							<ibaBean:message key="com.iba.ehis.lc.issue" bundle="lcLabels" />
						</td>
						<td width=10% nowrap="false">
						</td>
						
						<td id="cleaningLabel" class='label' nowrap="false">
						<ibaBean:message key="com.iba.ehis.lc.request" bundle="lcLabels" />
						</td>
						<td class='label' nowrap="false">
						<ibaBean:message key="com.iba.ehis.lc.entry" bundle="lcLabels" />
						</td>
						<td class='label' nowrap="false">
							<ibaBean:message key="com.iba.ehis.lc.delivery" bundle="lcLabels" />
						</td>
						<td width=10%>
						</td>
						<td class='label' nowrap="false">
							<ibaBean:message key="com.iba.ehis.lc.send" bundle="lcLabels" />
						</td>
						<td class='label' nowrap="false">
							<ibaBean:message key="com.iba.ehis.lc.receive" bundle="lcLabels" />
						</td>
						<td width=10%>
						</td>
						<td  class='label' nowrap="false">
						<ibaBean:message key="com.iba.ehis.lc.complaint" bundle="lcLabels" />
						</td>
						<td class='label' nowrap="false">
						<ibaBean:message key="com.iba.ehis.lc.write-off" bundle="lcLabels" />
						</td>
						
						
					</tr>
				</table>
			</td>
		</tr>
		<tr class="PATIENTLINECOLOR">
		<td id="desc" align="left" class="PATIENTLINECOLOR" colspan='9'>
		</td>
		</tr></table>
		<input type="hidden" name="LaundryConf" id="LaundryConf" />
</form>
</body>
</html> 

