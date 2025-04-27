<!DOCTYPE html>
<%@page import="eBL.toolbar.bc.ToolBarDisplayBC"%>
<%@page import="eBL.toolbar.response.ToolbarResponse"%>
<%@page import="eBL.toolbar.request.ToolbarRequest"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String styleMap = "";
	 if("IeStyleBlue.css".equals(sStyle))
	 {
		styleMap = "Blue";
	 }
	 else if("IeStyleLime.css".equals(sStyle))
	 {
		styleMap = "Lime";
	 }
	 else if("IeStyleOrange.css".equals(sStyle))
	 {
		styleMap = "Orange";
	 }
	 else if("IeStyleVoilet.css".equals(sStyle))
	 {
		styleMap = "Violet";
	 }
	 else
	 {
		styleMap = "";
	 }
	String width = "25px;";
	String height = "25px;";
%>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<style>
.myButton {
	
	background-color: #83AAB4;
	border-radius:8px;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:arial;
	font-size:10px;
	font-weight:bold;
	padding:5px 12px;
	text-decoration:none;
	text-shadow:0px 1px 0px #3d768a;
	BORDER-STYLE: outset;
	BORDER-LEFT-COLOR: #83AAB4;
	BORDER-RIGHT-COLOR: #83AAB4;
	BORDER-TOP-COLOR: #83AAB4;
	BORDER-BOTTOM-COLOR: #83AAB4 
}
.myButton:hover {
	background-color:#44919E;
	BORDER-STYLE: inset;
}
.myButton:active {
	position:relative;
	top:1px;
}
.iconBarRow
	{
		BACKGROUND-image: url('../../eCommon/images/toolBarBG.jpg');
		width:1024;
		height:28px;
		border-bottom:none;
	}
.iconBarRowBlue
	{
		BACKGROUND-image: url('../../eCommon/images/toolBarBGBlue.jpg');
		width:1024;
		height:28px;
		border-bottom:none;
	}
.iconBarRowLime
	{
		BACKGROUND-image: url('../../eCommon/images/toolBarBGLime.jpg');
		width:1024;
		height:28px;
		border-bottom:none;
	}
.iconBarRowOrange
	{
		BACKGROUND-image: url('../../eCommon/images/toolBarBGOrange.jpg');
		width:1024;
		height:28px;
		border-bottom:none;
	}
.iconBarRowViolet
	{
		BACKGROUND-image: url('../../eCommon/images/toolBarBGViolet.jpg');
		width:1024;
		height:28px;
		border-bottom:none;
	}
	IMG.imageClass
	{
		vertical-align: middle;
	}
</style>
<script>
$(document).ready(function(){
	$('span:last').css('padding-right','0px')
});
function loadFunction(url){
	alert('Url ->'+url);
}

function refresh(){
	parent.refresh();
}

function closeWindow(){
	parent.closeWindow();
}
</script>
</head>
<body>
	<form action="">
		<%
		String userId = checkForNull(request.getParameter("userid"));
		String responsibilityId = checkForNull(request.getParameter("userrespid"));
		String functionId = checkForNull(request.getParameter("functionid"));
		String facilityId = (String) session.getValue( "facility_id" ) ;
		ToolbarRequest toolbarRequest = new ToolbarRequest();
		toolbarRequest.setUserId(userId);
		toolbarRequest.setResponsibilityId(responsibilityId);
		toolbarRequest.setFacilityId(facilityId);
		toolbarRequest.setFunctionId(functionId);
		ToolBarDisplayBC toolBarBC = new ToolBarDisplayBC(); 
		ToolbarResponse toolbarResponse = toolBarBC.getToolBarForUser(toolbarRequest);
		HashMap toolBarMap = toolbarResponse.getToolBarMap();
		%>
		<div class='iconBarRow<%=styleMap%>'>
			<%
				if(toolBarMap!=null){
					ToolbarResponse bean = null;
					Iterator iterator= toolBarMap.keySet().iterator();
					int index = 0;
					int sNo = 0;
					while(iterator.hasNext())
					{
						index =    (Integer)iterator.next();
						sNo	  =		index+1;
						bean =  (ToolbarResponse) toolBarMap.get(index);
				%>
						<span style="padding-right: 30px;  ">
							<img src="../images/<%=bean.getToolbarIcon() %>" width="<%=width %>" height="<%=height %>" style="cursor: pointer;" title="<%=bean.getToolbarFunction()%>" onclick="loadFunction('<%=bean.getToolbarUrl()%>')">
						</span>
				<%		
					}
				}
				%>
				<span style="padding-right: 30px; ">
					<img src="../images/refresh.jpg" width="<%=width %>" height="<%=height %>" style="cursor: pointer;" title="Refresh Page" onclick='refresh();'>
				</span>
				<span style="padding-right: 30px; ">
					<img src="../images/MI_CloseT1.gif" width="<%=width %>" height="<%=height %>" style="cursor: pointer;" title="Close Window" onclick='closeWindow();'>
				</span>
			</div>
	</form>
</body>
</html>

