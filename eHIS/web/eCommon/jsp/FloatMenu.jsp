<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
&nbsp;
<html>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
	<script Language="JavaScript" src="../../eCommon/js/logout.js"></script>
<!-- /*For Slider*/ -->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HEAD>
<TITLE>Float Menu</TITLE>
<%
	request.setCharacterEncoding("UTF-8");
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String login_user				= (String) session.getValue("login_user")==null?"":(String) session.getValue("login_user");//Added By Dharma on 17th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613]
		
	%>
	<link rel='StyleSheet' href='../html/<%=sStyle%>' type='text/css' ></link>
	<script>
		window.onresize=resizing

		function resizing() {
			var frameBval = document.getElementById("frameB").offsetWidth -5;
			document.getElementById("menuFr").width = frameBval+"px";
			
			document.getElementById("freAccMenuFr").width=frameBval+"px";
		}

		function changeTree(toggleButton) {				

			if(toggleButton.id == 'toggleTreeExpand') {
				menuFr.d.openAll();
				document.getElementById("exp_collapse_img").innerHTML="<IMG style='cursor:pointer' id = 'toggleTreeCollapse' SRC='../images/close-all.gif'  BORDER=0 ALT=\"<fmt:message key='Common.closeAll.label' bundle='${common_labels}'/>\" onClick=javascript:changeTree(this)>";
			} else if(toggleButton.id == 'toggleTreeCollapse') {
				menuFr.d.closeAll();
				document.getElementById("exp_collapse_img").innerHTML="<IMG SRC='../images/expand-all.gif' id='toggleTreeExpand' style='cursor:pointer' BORDER='0' ALT=\"<fmt:message key='Common.openAll.label' bundle='${common_labels}'/>\" onClick=javascript:changeTree(this);>";
			}

		}

		function toolFunction(str) {
				if(str == 1) {
					fnLogout("<%=login_user%>");//Added By Dharma on 17th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613]
					parent.content.location.href="../jsp/logoff.jsp" ;
				}else if(str == 2){
					mainwin = top.opener;
					var myBars = 'directories=no,location=no,menubar=no,status=no' ;
					var myOptions = 'width=' + window.screen.availwidth + ', height=' + window.screen.availheight + ', resizable=no, fullscreen=yes' ;
					var myFeatures = myBars + ', ' + myOptions ;
					mainwin = window.open("../../eSM/jsp/change_responsibility.jsp","eHISMain2",myFeatures)
					top.close();
				} else if(str == 3 || str == 4){
					wid = 0;
					hei = 0;
					if(document.getElementById("freAccMenuFr").width == 0) {
						wid = document.getElementById("frameB").offsetWidth;
						hei = 130;
						document.getElementById("menuFr").height= 515;

					}
					else {
						document.getElementById("menuFr").height= 660;
					}

					fname="";
						if(str == 3)
					{
							fname="PersonalizeList.jsp";

					}else if(str == 4)
					{
							fname="freqaccessTree.jsp";
					}
						
						if(document.getElementById("freAccMenuFr").src == fname) {
							if(document.getElementById("freAccMenuFr").height !=0) 
								changeSize(0,0);
							else
							{
								document.getElementById("freAccMenuFr").src = fname;
								changeSize(wid, hei);
							}
						 }else{
							 document.getElementById("freAccMenuFr").src = fname;
							 wid = document.getElementById("frameB").offsetWidth;
								hei = 130;
								document.getElementById("menuFr").height= 515;
								changeSize(wid, hei);
						}
				} else if(str ==5){
				   /* var dialogHeight    = "15" ;
					var dialogWidth = "26" ;
					var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; status=no;" ;
					var arguments   = "" ;
					retVal = window.showModalDialog("aboutProduct.jsp",arguments,features);*/
				}
			}
			
			function changeSize(wid,hei) {
				document.getElementById("freAccMenuFr").width=wid;
				document.getElementById("freAccMenuFr").height=hei;
			}
		</script>
		<script language = "javascript">
		/*	<!-- cmt for ie to edge work
			var ie = document.all ? 1 : 0
			var ns = document.layers ? 1 : 0

			if(ie){
			document.write('<style type="text/css">')
			document.write("#screen	{filter:Alpha(Opacity=30);}")
			document.write("</style>")
			}

			if(ns){
			document.write('<style type="text/css">')
			document.write("#master	{clip:rect(0,150,250,0);}")
			document.write("</style>")
			}
			-->*/
			var ie = document.all ? 1 : 0
	var ns = document.layers ? 1 : 0

	if (ie) {
		document.write('_$tag__________________')
		document.write("#screen	{filter:Alpha(Opacity=30);}")
		document.write("_$tag___")
	}

	if (ns) {
		document.write('_$tag__________________')
		document.write("#master	{clip:rect(0,150,250,0);}")
		document.write("_$tag___")
		}

		</script>

		<script language = "javascript">
			var ie = document.all ? 1 : 0
			var ns = document.layers ? 1 : 0

	var master = new Object("element")
	master.curLeft = -280;
	master.curTop = 10;
	master.gapLeft = 0;
	master.gapTop = 0;
	master.timer = null;

	function moveAlong(layerName, paceLeft, paceTop, fromLeft, fromTop) {
		clearTimeout(eval(layerName).timer)

		if (eval(layerName).curLeft != fromLeft) {
			if ((Math.max(eval(layerName).curLeft, fromLeft) - Math.min(
					eval(layerName).curLeft, fromLeft)) < paceLeft) {
				eval(layerName).curLeft = fromLeft
			} else if (eval(layerName).curLeft < fromLeft) {
				eval(layerName).curLeft = eval(layerName).curLeft + paceLeft
			} else if (eval(layerName).curLeft > fromLeft) {
				eval(layerName).curLeft = eval(layerName).curLeft - paceLeft
			}
			if (ie) {
				document.all[layerName].style.left = eval(layerName).curLeft
			}
			if (ns) {
				document[layerName].left = eval(layerName).curLeft
			}
		}

		if (eval(layerName).curTop != fromTop) {
			if ((Math.max(eval(layerName).curTop, fromTop) - Math.min(
					eval(layerName).curTop, fromTop)) < paceTop) {
				eval(layerName).curTop = fromTop
			} else if (eval(layerName).curTop < fromTop) {
				eval(layerName).curTop = eval(layerName).curTop + paceTop
			} else if (eval(layerName).curTop > fromTop) {
				eval(layerName).curTop = eval(layerName).curTop - paceTop
			}
			if (ie) {
				document.all[layerName].style.top = eval(layerName).curTop
			}
			if (ns) {
				document[layerName].top = eval(layerName).curTop
			}
		}

		eval(layerName).timer = setTimeout('moveAlong("' + layerName + '",'
				+ paceLeft + ',' + paceTop + ',' + fromLeft + ',' + fromTop
				+ ')', 30)
	}

	function setPace(layerName, fromLeft, fromTop, motionSpeed) {
		eval(layerName).gapLeft = (Math.max(eval(layerName).curLeft, fromLeft) - Math
				.min(eval(layerName).curLeft, fromLeft))
				/ motionSpeed
		eval(layerName).gapTop = (Math.max(eval(layerName).curTop, fromTop) - Math
				.min(eval(layerName).curTop, fromTop))
				/ motionSpeed

		moveAlong(layerName, eval(layerName).gapLeft, eval(layerName).gapTop,
				fromLeft, fromTop)
	}

	var expandState = 0
	var expand_val = new Object();
	var type_val = new Object();
	function expand(buttObj, type, module_id) {

		tempCols = ""
		iframetempCols = "";

		if (module_id == "cm") {

			expandState = expand_val;
		}
		//alert(expand_val);
		if (expandState == 0) {
			setPace("master", 0, 10, 10);
			expandState = 1;
			expand_val.expandState = 1;
			tempCols = "25%,*";
			type_val = type;
			if (buttObj != null) {
				if (buttObj.type == "button") {
					buttObj.value = '<fmt:message key="Common.hideMenu.label" bundle="${common_labels}"/>';

				} else {
					buttObj.innerText = '<fmt:message key="Common.hideMenu.label" bundle="${common_labels}"/>'

				}

			}
		} else {
			setPace("master", -280, 10, 10);
			expandState = 0;
			expand_val.expandState = 0;
			tempCols = "0,*";
			if (buttObj != null) {
				if (buttObj.type == "button") {
					if (module_id == "ca")
						buttObj.value = '<fmt:message key="Common.showMenu.label" bundle="${common_labels}"/>'
					else
						buttObj.value = '<fmt:message key="Common.menu.label" bundle="${common_labels}"/>'

				} else
					buttObj.innerText = '<fmt:message key="Common.menu.label" bundle="${common_labels}"/>'

			}

		}
		parent.parent.contentFrameset.removeAttribute("cols");
		parent.parent.contentFrameset.setAttribute("cols",tempCols);
		parent.parent.contentFrameset.cols = tempCols;
	}
</script>
</head>
<body id="frameB" OnMouseDown='CodeArrest()' onKeyDown='lockKey()'
	class="COMMON_TOOLBAR">
	<div id="master" STYLE="position: absolute; left: 0; top: 0">
		<TABLE width="100%" CELLSPACING=0 class="COMMON_TOOLBAR"
			cellpadding="0">
			<tr class="COMMONTOOLBARFUNCTION">
				<td class="COMMONTOOLBARFUNCTION" colspan=2><fmt:message
						key="Common.menu.label" bundle="${common_labels}" /></td>
			</tr>

			<TR>
				<TD><IMG style="cursor: pointer" SRC="../../eCommon/images/Logout.gif"
					BORDER=0 ALT="" align="absmiddle"
					TITLE='<fmt:message key="Common.logout.label" bundle="${common_labels}"/>'
					onclick="javascript:toolFunction(1)"> <IMG
					style="cursor: pointer" SRC="../../eCommon/images/switch_resp.gif" BORDER=0
					ALT="" align="absmiddle" onclick="toolFunction(2)"
					TITLE='<fmt:message key="Common.switchResponsibility.label" bundle="${common_labels}"/>'>
					<IMG style="cursor: pointer" SRC="../../eCommon/images/personalize02.gif"
					BORDER=0 ALT="" align="absmiddle" onclick="toolFunction(3)"
					TITLE='<fmt:message key="Common.personalize.label" bundle="${common_labels}"/>'>
					<IMG style="cursor: pointer" SRC="../../eCommon/images/Freq Accessed.gif"
					BORDER=0 ALT="" align="absmiddle" onclick="toolFunction(4)"
					TITLE='<fmt:message key="Common.frequentlyAccessedFunctions.label" bundle="${common_labels}"/>'>
				</TD>
				<td align='right' id='exp_collapse_img'><IMG
					SRC="../../eCommon/images/expand-all.gif" style="cursor: pointer" BORDER='0'
					ALT='<fmt:message key="Common.openAll.label" bundle="${common_labels}"/>'
					id='toggleTreeExpand' onClick="javascript:changeTree(this);">
				</td>
			</tr>
			</table>

		<div id="menu">
			<table border="0" width="100%" cellspacing="0" cellpadding="0">
				<tr>
					<td width="100%"><a href="javascript:expand()" onfocus="this.blur()"><img name="menutop" border="0" src='../../eCommon/images/Menu.gif' width='0px' height='0px'></a></td>
							<!--src="menu.gif" width="0" height="0"></a></td>!-->
				</tr>
			</table>
		</div>

		<div id="#screenlinks" width='100%' height="100%">
			<iframe id="menuFr" name="menuFr" src="../../eCommon/jsp/Tree.jsp"  height='660px' width="100%" scrolling="auto" frameborder="1" ></iframe>
			<iframe id="freAccMenuFr" name="freAccMenuFr" src="../../eCommon/html/blank.html"  height='0px' width="0px" scrolling="auto" frameborder="1"  ></iframe>
		</div>
	</div>
</body>
</html>

