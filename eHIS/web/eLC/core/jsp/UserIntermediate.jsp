<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="com.iba.framework.core.util.Constants"%>
<%@ include file="/framework/html/Tag.text"%>
<ibaHTML:html>

<head>
<%
			String facilityId=(String)session.getAttribute("facility_id");
			String functionId = (String) session.getAttribute("functionId");
			String moduleId = (String) session.getAttribute("moduleId");
			String user = (String) session.getAttribute("login_user");
		
			//if(user==null)
			//user="AN";
			String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session
			.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
			if (sStyle == null)
				sStyle = "IeStyle.css";
				
	%>

<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>'></link>
<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/engine.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/util.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/RequestForCleaning.js'></script>
<script>
var user="";
var pArgumentArray=new Array();
pArgumentArray[0]="";
function callModalWindow()
	{
		var retVal = new Array();
		var dialogHeight = "8";
		var dialogWidth = "20";
		var status = "no";
		var dialogUrl = contextPath + "/eLC/core/jsp/UserView.jsp"
		var dialogArguments = pArgumentArray;
		var dialogFeatures = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + " ; scroll=no; status:" + status;
		var flag = window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);
		if(flag=="undefined" || flag==undefined){
				parent.parent.frames[1].expand(this);
				parent.parent.frames[2].location.href = contextPath +"/eCommon/jsp/maindisplay.jsp";
		}else{
			parent.content.location.href=flag;
		}

	}
function getLaundryUser(data)
{
var dirtyFlag="";	
var u1="";
 for(prop in data)
 {
  u1=prop;
 }
 RequestForCleaning.getDirtyLinenParam('<%=facilityId%>',getDirty);
 function getDirty(rec)
	{
	  for(prop in rec)
		{
		  if(prop!=null)
			  {
				dirtyFlag=prop;
			  }
		}

//alert(dirtyFlag)
 if(u1!="")
 	{
	 var msg="<ibaBean:message key='com.iba.ehis.lc.userMesg' bundle='lcLabels' />";
	 alert(msg)
	 /*var functionName="LC_ISSUE";
	 var moduleId="LC";
	 var textLabel="<ibaBean:message key='com.iba.ehis.lc.laundry' bundle='lcLabels' />";
	 var functionLabel="<ibaBean:message key='com.iba.ehis.lc.issueOfLinen' bundle='lcLabels'/>";
 	 location.href=contextPath + "/eLC/IssueOfLinen/jsp/IssueOfLinenMain.jsp?functionName="+functionName+"&moduleId="+moduleId+"&functionLabel="+functionLabel+"&textLabel="+textLabel;
	 */
	 goMain()
 	}
 	else if(u1=="")
 	{
	callModalWindow();
	}
 }
}
function goMain()
{
	parent.parent.parent.frames[1].expand(this);
			   parent.parent.parent.frames[2].location.href = contextPath +"/eCommon/jsp/maindisplay.jsp";
}

</script>
</head>  
<body  class="CONTENT" bgcolor="#ccccff" onload="RequestForCleaning.getLcUser('<%=facilityId%>','<%=user%>',getLaundryUser)" >
</body>
</ibaHTML:html>

