<!DOCTYPE html>
<%-- JSP Page specific attributes start  --%>
 <%@ page import ="eOT.OTWidgetSelectionBean,java.util.ArrayList,java.util.HashMap, java.util.LinkedHashMap" %>  
<%@ page import=  "java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.Common.CommonBean,eOT.*,eOT.Common.*" %>
<html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@include file="../../eOT/jsp/StringUtil.jsp" %>
<%	request.setCharacterEncoding("UTF-8");
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }	%>   

<head>
<meta charset="utf-8" />
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<link rel="stylesheet" href="../../eOT/html/style.css" type="text/css" media="screen, projection" /> </link>
	<script>
	$(document).ready(function(){
		$(window).load(function(){
			var detheight = parseInt($(window).height())- (parseInt($(".header").height())+ parseInt($(".footer").height())); 
			$(".detailslot").css("height", detheight);
		});
		$(window).resize(function(){
			var detheight = parseInt($(window).height())- (parseInt($(".header").height())+ parseInt($(".footer").height())); 
			$(".detailslot").css("height", detheight);
		});
	});
	</script>
<!-- Added against 44321 on 10/17/2013 -->
<script>
/* function check_value(){
		var roomTempvalue=0; 
		var staffTempval=0;
		var myTest=0;
		if(document.getElementById('staffAssignmentId').checked){	 
				   staffTempval++; 
				   document.getElementById('staffAssignmentId').checked =true;   
		}
		var len=document.widget_form.chkbox_value.value;  
		roomTempvalue=parseInt(roomTempvalue)+parseInt(staffTempval);
		for(var k=0; k<len;k++){
			 if(document.getElementById('roomListId'+k).checked){    
					   roomTempvalue++;   
				  if(roomTempvalue>3 && myTest==0){
					  myTest++; 
					  alert(getMessage("APP-OT0214",'OT'));
				  } 
				document.widget_form.check[k].checked =true;		
			}
		 }
			 document.widget_form.check_chk_value.value=roomTempvalue;
			 if(parseInt(document.getElementById("check_chk_value").value)==0) alert(getMessage("APP-OT0215",'OT'));
		} 
function check_value(obj){
var tempvalue=0; 
var roomcount=0;
if(document.getElementById('staffAssignmentId').checked){	
	if(tempvalue>3 ){  
		   //document.getElementById('staffAssignmentId').checked =false;
	       document.getElementById("check_chk_value").value=parseInt(document.getElementById("check_chk_value").value)-parseInt(1);
	}else{ 
	       tempvalue++; 
		   document.getElementById('staffAssignmentId').checked =true;
   }
}
var len=document.widget_form.chkbox_value.value; 
for(k=0; k<len;k++){ 
      if(document.getElementById('roomListId'+k).checked){
	     tempvalue++;
	    
if(tempvalue>3){ 
	alert(getMessage("APP-OT0214",'OT'));
	tempvalue--;	
	if(obj.name=="check")
	document.widget_form.check[k].checked =false;
	else if(obj.name=="staffass")
	document.widget_form.staffass.checked =false;
 }else{       
	    document.widget_form.check[k].checked =true;		
	  }		
	}	
  }
	  document.widget_form.check_chk_value.value=tempvalue; 
	 if(parseInt(document.getElementById("check_chk_value").value)==0) alert(getMessage("APP-OT0215",'OT'));
}*/
function check_value(i)
{
	var total = 0;
	if($('#staffAssignmentId').is(':checked') == true)
		total++;
	var max = document.forms[0].fetchCount.value;
	for (var idx = 0; idx < max; idx++)
	{
		if($('#roomListId'+idx).is(':checked') == true)
		{
			total++;
/*
			if(total > 3)
			{
				if(i != '' && i >= 0)
					$('#roomListId'+i).prop('checked', false);
				else
					$('#staffAssignmentId').prop('checked', false);
				alert(getMessage("APP-OT0214",'OT'));
				break;
			}
*/
		}
	}
	if(total == 0)	// Added by Chaitanya against IN:044804
		alert(getMessage("APP-OT0215",'OT'));
}
	</script>
</head> 
<link rel="StyleSheet" type="text/css" href="../../eOT/html/style.css"></link>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script language='javascript' src='../../eOT/js/OTExternalWidgetSelection.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	String staff="";
	String auto_refresh="";
	String refresh_interval="30";
	String refresh_interval_time="";
	StringBuffer room_code1Buffer = new StringBuffer();
	StringBuffer roomCodeDisplayBuffer = new StringBuffer ();
	String room_code1="";
	String roomCodeDisplay = "";
	String room_code2="";
	String room_code3="";
	String checkedYnSlots = "";
	String chkValueSlots = "N";
	String chk_checked1="";
	String chk_value1="N";
	String widget_selection_id="";
	String facilityid="";
	String locale = (String)session.getAttribute("LOCALE");
	String staff_assign_yn = "";
	String autoRefresh_yn = "";
	int autoRefreshTime = 0;
	String staff_name="";
String dbValues = "";
String chkCode = "";
	int chkvalue=0;
	String bean_id	 = "OTWidgetSelectionBean";
	String bean_name = "eOT.OTWidgetSelectionBean";
	OTWidgetSelectionBean bean	 = (OTWidgetSelectionBean)mh.getBeanObject( bean_id, request, bean_name );
	Map map =null;
	LinkedHashMap<String,String> facilityMap=null;
	ArrayList chkCodesList = new ArrayList();
	Connection connection=null;
try {
	connection=ConnectionManager.getConnection(request);

	facilityMap =  bean.getSurgeryTypeDtls();
	map =  bean.getWidgetDtls();
	if(map!=null && map.size()>0){
		widget_selection_id=checkForNull((String) map.get("widget_selection_id")); 
		facilityid=checkForNull((String) map.get("facility_id")); 
		staff_assign_yn=(String) map.get("staff_assign_yn")==null?"N":(String) map.get("staff_assign_yn"); 
		auto_refresh=(String) map.get("auto_refresh_yn")==null?"N":(String) map.get("auto_refresh_yn");
		refresh_interval=(String) map.get("refresh_interval")==null?"30":(String) map.get("refresh_interval");
		refresh_interval_time=(String) map.get("refresh_interval_time")==null?"SS":(String) map.get("refresh_interval_time");
		room_code2=checkForNull((String) map.get("ot_room_code2"));
		room_code3=checkForNull((String) map.get("ot_room_code3"));	
		chkCodesList = (ArrayList)map.get("CODESLIST");
}

	if(staff_assign_yn.equals("Y"))
	{
	    chkvalue++;
		checkedYnSlots="checked";
		chkValueSlots = "Y";
		staff_name="Staff Assignment";
		
	}
	else
	{
		checkedYnSlots="";
		chkValueSlots = "N";	
		
	}
	
	if(auto_refresh.equals("Y"))
	{
		chk_checked1="checked";
		chk_value1 = "Y";
	}
	else
	{
		chk_checked1="";
		chk_value1 = "N";
	}
	
%>
<body style="position:relative;" class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >
<form name="widget_form" id="widget_form" action="../../servlet/eOT.WidgetSelectionServlet" method="post" target="messageFrame" > 
<div class="main">
<div class="actiontitle">
<!--<fmt:message key="eOT.ExtendDispConfig.Label" bundle="${ot_labels}"/> -->
</div>
<div class="tcontent" >

<div class="stfdet">
	<span class="estftitlebold"><fmt:message key="eOT.WidgetSelection.Label" bundle="${ot_labels}"/></span>
</div>
<div class="stfdet" style="padding:2px;"> 
	<input class="floatleft check"  name ="staffass" id="staffAssignmentId" type="checkbox" onclick="check_eff2(this);createOrder(this);check_value('');"  value="<%=chkValueSlots%>" <%=checkedYnSlots%>/><span class="esstftitle"><fmt:message key="eOT.StaffAssignment.Label" bundle="${ot_labels}"/> </span>
	<br>
	<div class="textroom" ><fmt:message key="Common.room.label" bundle="${common_labels}"/>  <fmt:message key="Common.List.label" bundle="${common_labels}"/> </div>
</div>

<div class="tablediv" > 
<div class="tablediv" style="height:300px; overflow-y:scroll;">
<input type="hidden" name="fetchCount" id="fetchCount" id="fetchCount" value="<%=facilityMap.size()%>">
<table  class="exstaffgrid" cellspacing="0" >
	
	<%
		int i = 0;
		for(String code : facilityMap.keySet())
		{
			if(i%2 == 0)
			{
	%>
	<tr>
		<%
			}
			String chk1="";
/*
			if(code.equals(room_code1))
			{
			    chkvalue++;
				chk1="checked";
			}
			if(code.equals(room_code2))
			{
			    chkvalue++;
				chk1="checked";
			
			}
			if(code.equals(room_code3))
			{
			    chkvalue++;
				chk1="checked";
			}
*/			
			if(chkCodesList.contains(code))
				chk1="checked";
	%>	
			<td><input class="brdclr" id="roomListId<%=i%>" name="check" type="checkbox" value= "<%=code%>" <%=chk1%> onclick="createOrder(this);check_value('<%=i%>');"  /> <%= facilityMap.get(code) %> </td>
			<input type="hidden" id="roomListValue<%=i%>" id="roomListValue<%=i%>" value="<%=facilityMap.get(code)%>">
	<%
			if(i%2 == 1)
			{
	%>
		</tr>
	<%
			}	
			i++;
		}
		String sel2="",sel1="";
	%>	
</table>
</div>
</div>
</div>
	<div class="refresh" >
		<div class="">
			<div class="floatlefttitle">
				<fmt:message key="eOT.AutoRefreshTime.Label" bundle="${ot_labels}"/>
				<input type='text' id ="RefreshInterval"  name='RefreshInterval' id='RefreshInterval' maxlength=2 size=2  value="<%=refresh_interval%>"  onkeypress="return isNumberKey(event);"   >
				<select class=" " id="Interval" name= "Interval"    value = "<%=refresh_interval_time%>" >
				<option value='SS' <%="SS".equals(refresh_interval_time)?sel1="selected":sel1%>>
					<fmt:message key="eOT.seconds.Label" bundle="${ot_labels}"/>
				</option>
				<option value='MM' <%="MM".equals(refresh_interval_time)?sel2="selected":sel2%>>
					<fmt:message key="eOT.minutes.Label" bundle="${ot_labels}"/>
				</option>
				</select>
				</div>
		</div>
	</div>
	
	<div class="selectedbox">
		<div class="valign" >
<%
	for(int d=0; d<chkCodesList.size(); d++)
	{
		chkCode = (String)chkCodesList.get(d);
		if(!chkCode.equals("0"))
		{
			room_code1Buffer.append((String)chkCodesList.get(d) + ",");
			roomCodeDisplayBuffer.append(facilityMap.get((String)chkCodesList.get(d)) + ", ");
		}
	}
	room_code1 = room_code1Buffer.toString();
	roomCodeDisplay = roomCodeDisplayBuffer.toString();
	if(room_code1 != null && room_code1.length() > 0)
		room_code1 = room_code1.substring(0, room_code1.length() - 1);//Added against 45877
	if(roomCodeDisplay != null && roomCodeDisplay.length() > 0)
		roomCodeDisplay = roomCodeDisplay.substring(0, roomCodeDisplay.length() - 2);
	dbValues =  room_code1 + "~" + staff_name;
%>
	<input type="hidden" name="dbValues" id="dbValues" id="dbValues" value="<%=dbValues%>">
	<input type="hidden" name="roomCodeDisplay" id="roomCodeDisplay" id="roomCodeDisplay" value="<%=roomCodeDisplay%>">
			<span class="widgettext"><fmt:message key="eOT.Widgetselectfordispare.Label" bundle="${ot_labels}"/>  : <%=staff_name%> &nbsp;<%=roomCodeDisplay%></span> 
		    <span id="order"  ></span> 
			<span class="widgettext"> </span><span class="widgettext"> </span><span class="widgettext"></span>
		</div>
	</div>
	
</div>
<table width="99%">
<tr>
<td><input class="oldbtn1 floatleft" type="button" id="displayBtn" onclick='displayDashboard()' value="Display Dashboard" />
<input class="oldbtn1 floaleft" type="button" id="displayCloseBtn" onclick='closeDashboard()' value="Close Dashboard " disabled />	
</td>
<td><input class="oldbtn floatright" type="button" onclick='apply()' value="<fmt:message key="Common.apply.label" bundle="${common_labels}"/>"/>
<input class="oldbtn floatright" type="button" onclick='preview()' value="<fmt:message key="Common.Preview.label" bundle="${common_labels}"/>"/>
</td>
</tr> 
</table>
<input type="hidden" name="room1" id="room1" value="">
<input type="hidden" name="room2" id="room2" value="">
<input type="hidden" name="room3" id="room3" value="">
<!--<input type="text" name ="staffass" value="<%=staff_assign_yn%>"> -->
<input type="hidden" name ="widget_selection_id" value="<%=widget_selection_id%>">
<input type="hidden" name ="facilityid" value="<%=facilityid%>">
<input type="hidden" name ="refresh_interval" id ="refresh_interval" value="<%=refresh_interval%>">
<input type="hidden" name ="refresh_interval_time" id ="refresh_interval_time" value="<%=refresh_interval_time%>">
<input type="hidden" name ="auto_refresh" value="<%=auto_refresh%>">
<input type="hidden" name ="check_chk_value" id="check_chk_value" value="<%=chkvalue%>">
<input type="hidden" name ="chkbox_value" id="chkbox_value" value="<%=i%>">
<%if(!imgUrl.equals("")){ %>
 <img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>
<%}catch(Exception e){	
				System.err.println("Err From OTExternalWidgetFrame.jsp "+e.getMessage());
				e.printStackTrace();
			}
finally
{
	//if(connection!=null) connection.close();
	if(connection != null) ConnectionManager.returnConnection(connection);
}	%>
</form>
</body>
</html>

