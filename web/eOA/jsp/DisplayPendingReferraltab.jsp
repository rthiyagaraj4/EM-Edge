<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<Script src="../../eOA/js/Validate.js" language="JavaScript"></Script>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.net.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
  <link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<%
//Connection con = ConnectionManager.getConnection(request);
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
String callingMode=request.getParameter("callingMode");
if (callingMode==null) callingMode = "";
String frmCa=(String) session.getValue("ca_mode");
if (frmCa==null) frmCa = "";
String from_OR=request.getParameter("from_OR");
if(from_OR ==null) from_OR="N";
String install_yn_val=request.getParameter("install_yn_val")==null?"":request.getParameter("install_yn_val");
String oper_stn_id=request.getParameter("oper_stn_id")==null?"":request.getParameter("oper_stn_id");
String book_appt_yn=request.getParameter("book_appt_yn")==null?"":request.getParameter("book_appt_yn");
String create_wait_list_yn=request.getParameter("create_wait_list_yn")==null?"":request.getParameter("create_wait_list_yn");

%>
<script>	
	
	function tab_click2(id){
		if(prevTabObj!=null){
			document.getElementById(prevTabObj).className = "tabA";
document.getElementById(prevTabObj + "span").className = "tabAspan";
		}
		if(id == 'day_tab'){
			document.getElementById(id).className = "tabA";
document.getElementById(id + "span").className = "tabAspan";
		}else{
			document.getElementById(id).className = "tabClicked";
document.getElementById(id + "span").className = "tabSpanclicked";
		}
		prevTabObj=id
		tab_click(id);
	}

	function tab_click(objName){
		var install_yn_val=document.forms[0].install_yn_val.value;
		var oper_stn_id=document.forms[0].oper_stn_id.value;
		var book_appt_yn=document.forms[0].book_appt_yn.value;
		var create_wait_list_yn=document.forms[0].create_wait_list_yn.value;
		if (objName == 'order_tab' ){
			var url="../../eOA/jsp/DisplayPendingSchedule.jsp?install_yn_val="+install_yn_val+"&oper_stn_id="+oper_stn_id+"&book_appt_yn="+book_appt_yn+"&create_wait_list_yn="+create_wait_list_yn;
			parent.parent.frames[1].location.href=url;
		}else if(objName =='pending_tab'){
		}else if (objName == 'schedule_tab'){
			back('checkin_tab');
		}
	}
</script>
<html>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<Script src="../../eOA/js/ChangeDate.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
	<form name=image>
			
					
			<a name='demo'></a>
		<ul id="tablist" class="tablist" style="padding-left: 0px">
			<li class="tablistitem" title="schedules">
				<a onclick="tab_click2('schedule_tab')" class="tabA" id='schedule_tab' >
					<span class="tabAspan" id="schedule_tabspan" ><fmt:message key="Common.Schedule.label" bundle="${common_labels}"/><fmt:message key="Common.status.label" bundle="${common_labels}"/></span>
				</a>
			</li>
		<li class="tablistitem" title="Day Schedule">
				<a onclick="tab_click2('day_tab')" class="tabA" id='day_tab' >
					<span class="tabAspan" id="day_tabspan" ><fmt:message key="Common.day.label" bundle="${common_labels}"/><fmt:message key="Common.Schedule.label" bundle="${common_labels}"/></span>
				</a>
			</li>
		<li class="tablistitem" title="Pending Referral">
				<a onclick="tab_click2('pending_tab')" class="tabClicked" id='pending_tab' >
					<span class="tabSpanclicked" id="pending_tabspan" ><fmt:message key="eOA.Pendingreferral.label" bundle="${oa_labels}"/></span>
				</a>
			</li>
<%if ((from_OR.equals("Y") ) || (callingMode.equals("") && install_yn_val.equals("Y"))) {%>

		<li class="tablistitem" title="Pending Order">
				<a onclick="tab_click2('order_tab')" class="tabA" id='order_tab' >
					<span class="tabAspan" id="order_tabspan" ><fmt:message key="eOA.PendingOrderSchedule.label" bundle="${oa_labels}"/></span>
				</a>
			</li>
			<%}else {%>
			
			<%}%>
			
		</ul>
        <br>
			
		
			<input type="hidden" name="caMod" id="caMod" value ="<%=frmCa%>">
			<%String qStr=(String) session.getValue("qStr");
			String from_wait_list=(String) session.getValue("from_wait_list");%>
			<input type="hidden" name="qStr" id="qStr" value ="<%=qStr%>">
			<input type="hidden" name="from_wait_list" id="from_wait_list" value ="<%=from_wait_list%>">
			<input type="hidden" name="callingMode" id="callingMode" value='<%=callingMode%>'>
			<input type='hidden' name='ct_tab_name' id='ct_tab_name'>
			<input type='hidden' name='install_yn_val' id='install_yn_val' value='<%=install_yn_val%>'>
			<input type='hidden' name='oper_stn_id' id='oper_stn_id' value='<%=oper_stn_id%>'>
			<input type='hidden' name='book_appt_yn' id='book_appt_yn' value='<%=book_appt_yn%>'>
			<input type='hidden' name='create_wait_list_yn' id='create_wait_list_yn' value='<%=create_wait_list_yn%>'>	</body>
	</form>
</html>

