<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import="java.sql.*,webbeans.eCommon.*,eBL.Common.*,eBL.*,eCommon.Common.*,java.net.*,webbeans.op.CurrencyFormat,java.io.*,com.ehis.util.*,java.util.*" contentType="text/html;charset=UTF-8"%>

<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
/*
NMC-JD-CRF-0102.2*/
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "")
					? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
					
	String validInsUser = request.getParameter("validInsUser");
	String params = request.getQueryString();
	String apprvSts_AAKHYN = request.getParameter("apprvSts_AAKHYN");//V230425
	String PreAuthEclaimYN = request.getParameter("PreAuthEclaimYN");//V230814
	System.err.println("params1 tab "+params);
	//params="PreAuthEclaimYN="+PreAuthEclaimYN;
	System.err.println("params "+params);
					
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<link rel='stylesheet' type='text/css' href='../../eCommon/html/Tabs.css'></link>
<script type="text/javascript" src="../../eBL/js/BLApprStatusTrackSearch.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<head>
<script>
	 var headTop = -1;
	 var FloatHead1;
	 function processScroll()
	 	{
	 		if (headTop < 0)
	 		{
	 			saveHeadPos();
	 			
	 		}
	 		if (headTop>0)
	 		{
	 			if (document.documentElement && document.documentElement.scrollTop)
	 				theTop = document.documentElement.scrollTop;
	 			else if (document.body)
	 				theTop = document.body.scrollTop;

	 			if (theTop>headTop)
	 				FloatHead1.style.top = (theTop-headTop) + 'px';
	 			else
	 				FloatHead1.style.top = '0px';
	 		}
	 	}

	 	function saveHeadPos()
	 	{
	 		parTable = document.getElementById("divHeadSep");
	 		if (parTable != null)
	 		{
	 			headTop = parTable.offsetTop + 3;
	 			FloatHead1 = document.getElementById("heading");
	 			FloatHead1.style.position = "relative";
	 		}
	 	}
	 	
	 	function lockKey()
	 	  {
	 		 	 
	 		if(event.keyCode == 93)
	 			alert("Welcome to eHIS");
	 	  }

	 	  function lockbackSpace()
	 	  {
	 		   var mode = document.mode.value;
	        if(mode=='modify' && window.event.keyCode==8)
	 		  {
	            //return false;
	 		  }
	 	  }
	 	 
	 	
	 	
	 </script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad="showMainTabDetails('PreAuthorization','<%=params%>')"> 
	<table width='100%'>
		<tr>
			<td width="100%" class="white">
				<ul id='tablist' class='tablist'>
					<li class="tablistitem"
						title='<fmt:message key="eBL.PreAuth.label" bundle="${bl_labels}"/>'>
						<a onclick="showMainTabDetails('PreAuthorization','<%=params %>')"
						class="tabClicked" id="PreAuthorization"> 
						<span class="tabSpanclicked" id="PreAuthorizationspan"> <fmt:message
									key="eBL.PreAuth.label" bundle="${bl_labels}" />
						</span>
					</a>
					</li>
					<li class="tablistitem"
						title='<fmt:message key="eBL.EClaim.label" bundle="${bl_labels}"/>'>
						<a onclick="showMainTabDetails('EClaim','<%=params %>')" class="tabA" id="EClaim">
						<span class="tabAspan" id="EClaimspan"> <fmt:message
									key="eBL.EClaim.label" bundle="${bl_labels}" />
						</span>
					</a>
					</li>
				</ul>
			</td>
		</tr>
	</table>
</body>
</html>

