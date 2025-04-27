<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*, webbeans.eCommon.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

 <head>	

<STYLE TYPE="text/CSS">

/* This style is used for locking the table's heading  */

div#summary_tbl {
height: 80%;
width: 100%;
overflow: auto;
position: absolute;
}

</STYLE>
 
<%
			String sStyle =
			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script>
var flagPerson = true;
var flagPerson1 = true;
 function toolFunction(str) {
	if(str == 1) {
		parent.parent.content.location.href="../jsp/logoff.jsp";
	} else if(str == 2){
		mainwin = top.opener
		var myBars = 'directories=no,location=no,menubar=no,status=no' ;
		var myOptions = 'width=' + window.screen.availwidth + ', height=' + window.screen.availheight + ', resizable=no, fullscreen=yes' ;
		var myFeatures = myBars + ', ' + myOptions ;
		mainwin = window.open("../../eSM/jsp/change_responsibility.jsp","eHISMain2",myFeatures)
		top.close();
	} else if (str == 3){
        if (flagPerson== true)
        {
			parent.navigation.rows="3%,*,18%";
			parent.personalize.location.href="../jsp/PersonalizeList.jsp";
        }else {
			parent.navigation.rows="3%,*,0%";
			parent.personalize.location.href='../../eCommon/html/blank.html';
		}	
		flagPerson = !flagPerson;

	} else if (str == 4){
        if (flagPerson1== true)
        {
			parent.navigation.rows="3%,*,20%";
			parent.personalize.location.href="../jsp/freqaccessTree.jsp";
        }else {
			parent.navigation.rows="3%,*,0%";
			parent.personalize.location.href='../../eCommon/html/blank.html';
		}	
		flagPerson1 = !flagPerson1;
	}
	
} 

</script>
</head>
<%
     String desktop_code="" ;		
	 String responsibility_id=(String) session.getValue( "responsibility_id" ) ;
	 desktop_code=(String) session.getValue( responsibility_id ) ;
	 request.setCharacterEncoding("UTF-8");	
%>
 <body class='NavigIconsBorder' onKeyDown = 'lockKey()'>
	<form name='summaryForm' id='summaryForm'>
	<table width="100%" cellspacing='0' cellpadding='0' border='0'>
	    <tr>
	       <td width='5%' align='left'>
		    <IMG style="cursor:pointer" SRC="../images/Logout.gif" BORDER=0 ALT="" align="absmiddle"   TITLE='<fmt:message key="Common.logout.label" bundle="${common_labels}"/>' onclick="javascript:toolFunction(1)">
			<IMG style="cursor:pointer" SRC="../images/switch_resp.gif" BORDER=0 ALT="" align="absmiddle" onclick="toolFunction(2)" TITLE='Switch Responsibility'>
			<IMG style="cursor:pointer" SRC="../images/personalize02.gif" BORDER=0 ALT="" align="absmiddle"  onclick="toolFunction(3)" TITLE='<fmt:message key="Common.personalize.label" bundle="${common_labels}"/>'>
			<IMG style="cursor:pointer" SRC="../images/Freq Accessed.gif" BORDER=0 ALT="" align="absmiddle"  onclick="toolFunction(4)" TITLE='<fmt:message key="Common.frequentlyAccessedFunctions.label" bundle="${common_labels}"/>'>
			</td>
	    </tr>
	</table>	

 </form>
 </body>
</html>

