<!DOCTYPE html>
<%@page  import ="java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,eCommon.XSSRequestWrapper,webbeans.eCommon.ConnectionManager" %>
<%@page  contentType="text/html; charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head><title></title>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

String facility_id =(String)session.getAttribute("facility_id");

Connection con   = null ;
PreparedStatement pstmt = null ;
ResultSet resultSet     = null ;
String login_reqd_yn	= "N";
String  SQL = "SELECT NVL(SLATE_LOGIN_REQD_YN,'N') LOGIN_REQD FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID = ?";
try{
	con			= ConnectionManager.getConnection(request) ;
	pstmt				= con.prepareStatement(SQL) ;
	pstmt.setString(1,facility_id);
	resultSet	= pstmt.executeQuery();
	while(resultSet!=null && resultSet.next()){
			login_reqd_yn = resultSet.getString("LOGIN_REQD");
	}
}catch ( Exception e ) {
	System.err.println( "Error SlateTab.jsp  :"+e ) ;
    e.printStackTrace() ;
}finally {
      try{
          if (resultSet!=null) resultSet.close() ;
          if(pstmt!=null) pstmt.close();
          if(con!=null)ConnectionManager.returnConnection(con,request);
	   }catch(Exception es){}
}

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="StyleSheet" type="text/css" href="../../eCommon/html/Tabs.css"></link>
	<script type='text/javascript' src='../../eOT/js/Booking.js'></script>
	<script language="Javascript" src="../../eOT/js/WaitList.js"></script>
	<script type="text/javascript" src="../../eOT/js/OTCommon.js"></script>
	<script language="Javascript" src="../../eCommon/js/common.js"></script>
</head>
<script language="javascript">
var frame_count = 0;
function changeTab(objStr)
{
	selectTab(objStr);
	var frmObj=document.SlateTabForm;
	/*var obj=document.getElementById("Slate");
	obj.className="CAFIRSTSELECTHORZ";
	//obj=document.getElementById("WaitList");
	//obj.className="CAFIRSTSELECTHORZ";
	//obj=document.getElementById("ReSchedule");
//	obj.className="CAFIRSTSELECTHORZ";
	obj=document.getElementById("ToBeReSchedule");
	obj.className="CAFIRSTSELECTHORZ";
	obj=document.getElementById("BookVerification");
	obj.className="CAFIRSTSELECTHORZ";
	obj=document.getElementById(objStr);
	obj.className="CASECONDSELECTHORZ";*/

	//if(objStr=="Slate") frame_count=0;
	//alert(frame_count);
		
//alert(parent.frames[0].frames[0].name);
//alert(parent.frames[1].frames[0].name);
//alert(parent.frames[0].name);
//alert(parent.frames[1].name);
	var cmf=parent.parent.commontoolbarFrame.document.forms[0];

if(objStr=="BOOKVERIFICATION")
	{
	if(cmf.apply.disabled==true)
	{
      cmf.apply.disabled=false;
   }
}
else
{
	if(cmf.apply.disabled==false)
	{
	 cmf.apply.disabled=true;
	}
}

	var params=frmObj.params.value;
	params=params+"&tab_name="+objStr;
	//alert(params);
	parent.clearBean();
	parent.f_tab_frames.location.href="../../eOT/jsp/SlateTabFrames.jsp?"+params;
	//	parent.f_tab_frames.f_query_add_mod.location.href="../../eCommon/html/blank.html";
}

function disableapply()
{
	//alert(parent.name);
	//alert(parent.parent.name);
	//alert(frames[0].document.forms[0].name);
	//alert(frames[1].document.forms[0].name);
	//alert(frames[2].document.forms[0].name);
	//alert(frames[2].name);
//var cmf=commontoolbarFrame.document.forms[0];

if(cmf.apply.disabled==false)
	{
cmf.apply.disabled=true;
	}
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>

<form name="SlateTabForm" id="SlateTabForm">
	<table id="tab" cellspacing=0 cellpadding=3  border="0" width="100%" align='center'>
<tr>
	<td width= "100%" class="white">
		<ul id="tablist" class="tablist">
			<li class="tablistitem" title="<fmt:message key='eOT.Slate.Label' bundle='${ot_labels}'/>">
				<a onclick="changeTab('SLATE')" class="tabclicked" id="SLATE">
				<span class="tabSpanclicked" id="SLATEspan">
				<fmt:message key="eOT.Slate.Label" bundle="${ot_labels}"/></span>
				</a>
			</li>
			
			<li class="tablistitem" title="<fmt:message key='eOT.BookingVerification.Label' bundle='${ot_labels}'/>">
			<a onclick="changeTab('BOOKVERIFICATION')" class="tabA" id="BOOKVERIFICATION">
			<span class="tabAspan" id="BOOKVERIFICATIONspan">
			<fmt:message key="eOT.BookingVerification.Label" bundle="${ot_labels}"/></span>
			</a>
			</li>
			<li class="tablistitem" title="<fmt:message key='eOT.ToBeRescheduleCases.Label' bundle='${ot_labels}'/>">
			<a onclick="changeTab('TOBERESCHEDULE')" class="tabA" id="TOBERESCHEDULE">
			<span class="tabAspan" id="TOBERESCHEDULEspan">
			<fmt:message key="eOT.ToBeRescheduleCases.Label" bundle="${ot_labels}"/></span>
			</a>
			</li>
	</ul>
	</td>
			
<td colspan="5" width="75%"></td>
</tr>

</table>
<input type="hidden" name="params" id="params" value="<%=request.getQueryString()%>">
<input type="hidden" name="function_id" id="function_id" value="<%=request.getParameter("function_id")%>">
<input type="hidden" name="login_reqd_yn" id="login_reqd_yn" value="<%=login_reqd_yn%>"      >
<!-- The below line is required to change the select state of Initial tab selected -->
	<script>prevTabObj='SLATE'</script>
</form>
</body>
</html>

