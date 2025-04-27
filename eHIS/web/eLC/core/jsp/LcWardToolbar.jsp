<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="com.iba.framework.core.util.Constants"%>
<%@ page  import="com.iba.framework.cache.pojo.business.CacheManager"%>
<%@ page  import="com.iba.ehis.lc.core.vo.SourceBean"%>
<%@ page language="java"%>
<%@ include file="/framework/html/Tag.text"%>

<html> 
	<head>
<%
		String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
		.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
		:"IeStyle.css" ;
		if(sStyle==null)sStyle="IeStyle.css";
		String loggedInUser = (String) session.getAttribute("login_user");
		String facilityId=(String)session.getAttribute("facility_id");
		Object obj=null;
	try
		{
			/* obj=CacheManager.getCache().getObject(Constants.USER_SESSION_CACHE,				
					"sessid", "objKey"); */ //AMRI-SCF-0679
								
		}catch(Exception e){} 

			
%>

<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>'></link>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/engine.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/util.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LodgeComplaint.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/RequestForCleaning.js'></script>
		<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


		<Script>
		var flag="";
	   function activate( newimg ) {
			return true;
		}
	
		function create1() 
		{
		var moduleId="LC";
		var functionId="LC_REQ_FOR_LINEN";
		parent.content.location.href = contextPath + "/eLC/RequestForLinen/jsp/RequestForLinenMainFrames.jsp?&functionId="+functionId+"&moduleId="+moduleId;
		}
var viewId;
 var dirtyFlag="";
 var userFlag="";
 var loggedInUser="";
 var facilityId="";
 var cutoffTime=new Date();


function cleaning() {
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
	 if(prop!=null){
	  dirtyFlag=prop;
	  dt=rec[prop]}
	}
	cutoffTime=dt;
	//alert(cutoffTime)
	//	alert("getDirty===" +facilityId)
		RequestForCleaning.getOverRideWardConf(facilityId,getconf); 
		
}

function checkUser()
{
	RequestForCleaning.getLcUser(facilityId,loggedInUser,getUser);
}

function getUser(data)
{
   for(prop in data)
	   {
	    if(prop!=null){
		if(prop==loggedInUser)
		   userFlag="Y";
			else
		    userFlag="N";
		}
		}
		if(userFlag==null||userFlag=="")
			userFlag="N";
	
 }


   function getconf(data1)
   {
	   var moduleId="LC";
		var functionId="LC_REQ_FOR_CLEANING_LINEN";
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
		    if(prop1!=null){
		  conf=prop1;
		  delDate=data1[prop1];	
			}
	if(conf!=""){		 
		if(conf=='Y')
			parent.content.location.href = contextPath + "/eLC/RequestForCleaningLinen/jsp/RequestForCleaningLinenMainFrames.jsp?flag=Y&dirtyFlag="+dirtyFlag+"&cutoffTime="+cutoffTime+"&delParamDate="+delDate+"&userFlag="+userFlag+"&requestDate="+convert1+"&functionId="+functionId+"&moduleId="+moduleId;			
		else
			parent.content.location.href = contextPath + "/eLC/RequestForCleaningLinen/jsp/RequestForCleaningLinenMainFrames.jsp?flag=N&dirtyFlag="+dirtyFlag+"&cutoffTime="+cutoffTime+"&delParamDate="+delDate+"&userFlag="+userFlag+"&requestDate="+convert1+"&functionId="+functionId+"&moduleId="+moduleId;			
	}
	else
	   {
		getServerMessage("APP-LC00022");
		var msg=dwrMessage;
		alert(msg);
		}

   }
   function writeOff()
		{
		var flag="";
		var functionId="LC_WRITEOFF_LINEN";
		parent.content.location.href=contextPath+"/eLC/WriteOffLinen/jsp/WriteOffLinenFrames.jsp?functionId="+functionId+"&flag="+flag;
		}
	function complaint()
	{
		//alert()
		var moduleId="LC";
		var functionId="LC_LODGE_COMPLAINT";
	    parent.content.location.href=contextPath+"/LodgeComplaintAction.do?method="+loadMethod+"&vo.functionId="+functionId
	}
	 function Loan()
   {
	   var functionId="LC_LOAN_LINEN"
		var moduleId="LC"
	   parent.content.location.href=contextPath+"/eLC/LoanLinen/jsp/LoanLinenMainFrames.jsp?vo.functionId="+functionId+"&vo.moduleId="+moduleId
   }
	function borrow() {
		var moduleId="LC";
		var functionId="LC_RECEIVE_LOAN_LINEN";
		parent.content.location.href = contextPath + "/eLC/ReceiveLoanedLinen/jsp/ReceiveLoanedLinenMainFrames.jsp?vo.functionId="+functionId+"&vo.moduleId="+moduleId
	}
	function returnOfLinen()
	{
		var moduleId="LC";
		var functionId="LC_RETURN_LINEN_TO_LAND";
		parent.content.location.href=contextPath+"/eLC/ReturnofLinentoLaundry/jsp/ReturnofLinentoLaundryFrames.jsp?vo.functionId="+functionId+"&vo.moduleId="+moduleId
	}
	function onApply() {
		parent.apply() ;
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
		
	function changeImg(obj)
{
	if(obj.id=="create")
	{
		obj.src="../../../eLC/core/images/W-New2.gif";
		document.getElementById("Cleaning").src="../../../eLC/core/images/W-Cleaning1.gif";
		document.getElementById("writeoff").src="../../../eLC/core/images/W-Writeoff1.gif";
		document.getElementById("Lend").src="../../../eLC/core/images/W-Lend1.gif";
		document.getElementById("Return").src="../../../eLC/core/images/W-Return1.gif"; 
		document.getElementById("Borrow").src="../../../eLC/core/images/W-Borrow1.gif";
		document.getElementById("Complaint").src="../../../eLC/core/images/W-Complaint1.gif";
		
	}
	
	else if(obj.id=="Cleaning")
	{
		obj.src="../../../eLC/core/images/W-Cleaning2.gif";
		document.getElementById("create").src="../../../eLC/core/images/W-New1.gif";
		document.getElementById("writeoff").src="../../../eLC/core/images/W-Writeoff1.gif";
		document.getElementById("Lend").src="../../../eLC/core/images/W-Lend1.gif";
		document.getElementById("Borrow").src="../../../eLC/core/images/W-Borrow1.gif";
		document.getElementById("Complaint").src="../../../eLC/core/images/W-Complaint1.gif";
		document.getElementById("Return").src="../../../eLC/core/images/W-Return1.gif";
			}
	else if(obj.id=="writeoff")
	{
		obj.src="../../../eLC/core/images/L-Writeoff2.gif";
		document.getElementById("create").src="../../../eLC/core/images/W-New1.gif";
		document.getElementById("Cleaning").src="../../../eLC/core/images/W-Cleaning1.gif";
		document.getElementById("Lend").src="../../../eLC/core/images/W-Lend1.gif";
		document.getElementById("Borrow").src="../../../eLC/core/images/W-Borrow1.gif";
		document.getElementById("Complaint").src="../../../eLC/core/images/W-Complaint1.gif";
		document.getElementById("Return").src="../../../eLC/core/images/W-Return1.gif";
		
	}
	else if(obj.id=="Lend")
	{
		obj.src="../../../eLC/core/images/W-Lend2.gif";
		document.getElementById("create").src="../../../eLC/core/images/W-New1.gif";
		document.getElementById("Cleaning").src="../../../eLC/core/images/W-Cleaning1.gif";
		document.getElementById("writeoff").src="../../../eLC/core/images/W-Writeoff1.gif";
		document.getElementById("Borrow").src="../../../eLC/core/images/W-Borrow1.gif";
		document.getElementById("Complaint").src="../../../eLC/core/images/W-Complaint1.gif";
		document.getElementById("Return").src="../../../eLC/core/images/W-Return1.gif";
		
	}
	else if(obj.id=="Borrow")
	{
		obj.src="../../../eLC/core/images/W-Borrow2.gif";
		document.getElementById("create").src="../../../eLC/core/images/W-New1.gif";
		document.getElementById("Cleaning").src="../../../eLC/core/images/W-Cleaning1.gif";
		document.getElementById("writeoff").src="../../../eLC/core/images/W-Writeoff1.gif";
		document.getElementById("Lend").src="../../../eLC/core/images/W-Lend1.gif";
		document.getElementById("Complaint").src="../../../eLC/core/images/W-Complaint1.gif";
		document.getElementById("Return").src="../../../eLC/core/images/W-Return1.gif";
		
	}
	else if(obj.id=="Complaint")
	{
		obj.src="../../../eLC/core/images/W-Complaint2.gif";
		document.getElementById("create").src="../../../eLC/core/images/W-New1.gif";
		document.getElementById("Cleaning").src="../../../eLC/core/images/W-Cleaning1.gif";
		document.getElementById("writeoff").src="../../../eLC/core/images/W-Writeoff1.gif";
		document.getElementById("Lend").src="../../../eLC/core/images/W-Lend1.gif";
		document.getElementById("Borrow").src="../../../eLC/core/images/W-Borrow1.gif";
		document.getElementById("Return").src="../../../eLC/core/images/W-Return1.gif";
		
	}
	else if(obj.id=="Return")
	{
		obj.src="../../../eLC/core/images/W-Return2.gif";
		document.getElementById("create").src="../../../eLC/core/images/W-New1.gif";
		document.getElementById("Cleaning").src="../../../eLC/core/images/W-Cleaning1.gif";
		document.getElementById("writeoff").src="../../../eLC/core/images/W-Writeoff1.gif";
		document.getElementById("Lend").src="../../../eLC/core/images/W-Lend1.gif";
		document.getElementById("Borrow").src="../../../eLC/core/images/W-Borrow1.gif";
		document.getElementById("Complaint").src="../../../eLC/core/images/W-Complaint1.gif";
		
		
	}
	
	
	
	
}

function displayLabel(arg)
{
flag=arg;
var issueLabel="";

if(flag=='R')
issueLabel="<ibaBean:message key="com.iba.ehis.lc.requestForLinen"	bundle="lcLabels" />";
if(flag=='C')
issueLabel="<ibaBean:message key="com.iba.ehis.lc.requestForCleaningLinen"	bundle="lcLabels" />";
if(flag=='W')
issueLabel="<ibaBean:message key="com.iba.ehis.lc.write-off"	bundle="lcLabels" />";
if(flag=='M')
issueLabel="<ibaBean:message key="com.iba.ehis.lc.lodgeComplaint"	bundle="lcLabels" />";
if(flag=='N')
issueLabel="<ibaBean:message key="com.iba.ehis.lc.returnoflinentolaundry"	bundle="lcLabels" />";
if(flag=='L')
issueLabel="<ibaBean:message key="com.iba.ehis.lc.loanLinen"	bundle="lcLabels" />";
if(flag=='B')
issueLabel="<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen"	bundle="lcLabels" />";

document.getElementById("desc").innerText=issueLabel;
}

	</Script>

	</head>
	<body  leftmargin=0 rightmargin=0 topmargin=0 >


<form name="LcToolbar_form" id="LcToolbar_form" >
	
<table  width="100%" cellspacing='0' cellpading='0'  align='center' class="CONTENT">
	<tr>
	<td class='PATIENTLINECOLOR' align="top" height="30" colspan='7' >

	</td>
	<td class='PATIENTLINECOLOR' align='right'>
	<img src="../../../eLC/core/images/mc_switch.gif" height=18
								onclick="this.src='../../../eLC/core/images/mc_homepage.gif' ;switchFunction();" />
	<img src="../../../eLC/core/images/mc_close.gif" height=18
								onclick="this.src='../../../eLC/core/images/mc_close.gif' ;closeWindow();" />
	</td >
	</tr>
	</table>
	<table  width="100%" cellspacing='0' cellpading='0'  align='center' class="CONTENT">
	<tr>
		<td  align="left" >
			<table  cellspacing='0' cellpading='0'>
			<tr>
				<td class='label' colspan='9'>&nbsp&nbsp&nbsp<b><ibaBean:message key="com.iba.ehis.lc.request" bundle="lcLabels" /></b></td>
			</tr>
				<tr >
					<td nowrap="false">
						<img id="create" src="../../../eLC/core/images/W-New1.gif"
							onclick="create1();displayLabel('R');changeImg(this);parent.messageFrame.location.href='MessageFrame.jsp'"
							 name='create' ></img>
					</td>



					<td nowrap="false">
						<img id="Cleaning" src="../../../eLC/core/images/W-Cleaning1.gif"
							onclick="cleaning();displayLabel('C');changeImg(this);parent.messageFrame.location.href='MessageFrame.jsp'"
							name='load' ></img>
					</td>

					<td width=10%>
					</td>

					<td nowrap="false">
						<img id="Lend" src="../../../eLC/core/images/W-Lend1.gif" onclick="Loan();displayLabel('L');changeImg(this);parent.messageFrame.location.href='MessageFrame.jsp'"
							name='Lend'></img>
					</td>



					<td nowrap="false">
						<img id="Borrow" src="../../../eLC/core/images/W-Borrow1.gif"   onclick="changeImg(this);borrow();displayLabel('B');parent.messageFrame.location.href='MessageFrame.jsp'" name='Borrow'></input>
					
					</td>

					<td width=10%>
					</td>
					
					<td nowrap="false">
						<img id="Complaint" src="../../../eLC/core/images/W-Complaint1.gif"  
							onclick="complaint();displayLabel('M');changeImg(this)
							;parent.messageFrame.location.href='MessageFrame.jsp'"
							name='Complaint' ></img>
							
					</td>


					<td  nowrap="false">
						<img id="Return" src="../../../eLC/core/images/W-Return1.gif"  
							onclick="returnOfLinen();displayLabel('N');changeImg(this);parent.messageFrame.location.href='MessageFrame.jsp'"
							 name='Return'></img>
					</td>
					<td >
						<img id="writeoff" src="../../../eLC/core/images/W-Writeoff1.gif"  
							onclick="writeOff(); ;displayLabel('W');changeImg(this);parent.messageFrame.location.href='MessageFrame.jsp'"
							 name='writeoff' ></img>
					</td>
					
					<td width="*">
					&nbsp&nbsp&nbsp
															
					</td>
				

					</tr>
			
					<tr>
					<td  class='label'>
						<ibaBean:message key="com.iba.ehis.lc.new" bundle="lcLabels" />
					</td>
					<td class='label'>
						<ibaBean:message key="com.iba.ehis.lc.cleaning" bundle="lcLabels" />
					</td>

					<td width=10%>
					</td>

					<td class='label'>
					<ibaBean:message key="com.iba.ehis.lc.lend" bundle="lcLabels" />
					</td>

					<td class='label'>
						<ibaBean:message key="com.iba.ehis.lc.borrow" bundle="lcLabels" />
					</td>

					<td width=10%>
					</td>

					<td class='label'>
						<ibaBean:message key="com.iba.ehis.lc.complaint" bundle="lcLabels" />
						&nbsp
					</td>
					<td  class='label'>
					<ibaBean:message key="com.iba.ehis.lc.return" bundle="lcLabels" />
					&nbsp
					</td>
					<td class='label'>
					<ibaBean:message key="com.iba.ehis.lc.write-off" bundle="lcLabels" />
					</td>
					<td width="*">
					&nbsp&nbsp&nbsp
					</td>
				</tr>
				
			</table>
		</td>
	</tr>
	<tr>
	<td id="desc" align="left" class="PATIENTLINECOLOR"  colspan='9'>
	</td></tr>
	</table>

						
</form>
</body>
</html>

