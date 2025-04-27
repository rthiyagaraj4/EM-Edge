<!DOCTYPE html>
<!-- CRF-004 Authorize Slots for Booking - Rajesh V New page added for including Authorized users-->
<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,eCommon.XSSRequestWrapper,webbeans.eCommon.ConnectionManager" %>
<%@page  contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% 
	request.setCharacterEncoding("UTF-8");	
	//Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends 

	String locale = (String)session.getAttribute("LOCALE");
	String facility_id = (String) session.getValue("facility_id");	
	String operRoom = request.getParameter("oper_room");
	String doctorCode = request.getParameter("doctor_code");
	Connection con = null;
	ResultSet rst = null;
	PreparedStatement pstmt = null;
	String sqlGetUsers =	"SELECT APPL_USER_NAME description, APPL_USER_ID code FROM OT_OPER_ROOM_USER "+
							" WHERE OPER_ROOM_CODE='"+operRoom+"' and APPL_USER_ID <> '"+doctorCode+"' ORDER BY 1";
	String sqlSelDoc =	"SELECT PRACTITIONER_NAME description, PRACTITIONER_ID code FROM AM_PRACTITIONER_LANG_VW WHERE "+
						" LANGUAGE_ID='"+locale+"'  AND NVL(EFF_STATUS,'E') = 'E' AND UPPER(PRACTITIONER_ID) LIKE UPPER('"+doctorCode+"')";
%>
<html>
<head>
	<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<title><fmt:message key="eOT.AuthorizeSlotBooking.Label" bundle="${ot_labels}"/></title>
	<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function localTrimString(sInString) {
		  return sInString.replace(/^\s+|\s+$/g,"");
		}
	
	function searchDoctor(obj,target){		
		var role=getLabel("Common.Role.label","common");
			var tcode = obj.value;
			var tdesc = target.value;
			var retVal =    new String();
			var argumentArray  = new Array() ;
			var dataNameArray  = new Array() ;
			var dataValueArray = new Array() ;
			var dataTypeArray  = new Array() ;
			var tit = role;
			var sql="";
			var operRoom = document.forms[0].operRoom.value;
			//sql="SELECT PRACTITIONER_NAME description, PRACTITIONER_ID code FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID='"+locale+"'  AND NVL(EFF_STATUS,'E') = 'E' AND PRACT_TYPE IN ( SELECT PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE WHERE ROLE_TYPE ='"+role_type+"') AND UPPER(PRACTITIONER_NAME) LIKE UPPER(?) AND UPPER(PRACTITIONER_ID) LIKE UPPER(?) ORDER BY 1";
			sql="SELECT APPL_USER_NAME description, APPL_USER_ID code FROM OT_OPER_ROOM_USER WHERE OPER_ROOM_CODE='"+operRoom+"'  AND UPPER(APPL_USER_NAME) LIKE UPPER(?) AND UPPER(APPL_USER_ID) LIKE UPPER(?) ORDER BY 1";
			argumentArray[0] =sql;
			argumentArray[1] = dataNameArray ;
			argumentArray[2] = dataValueArray ;
			argumentArray[3] = dataTypeArray ;
			argumentArray[4] = "2,1";
			argumentArray[5] = target.value;
			argumentArray[6] = DESC_LINK  ;
			argumentArray[7] = DESC_CODE ;
			
			retVal = await CommonLookup( tit, argumentArray );
			if(retVal != null && retVal != "" )
			{
				var ret1=unescape(retVal);
				arr=ret1.split(",");
				obj.value = arr[0];
				target.value=arr[1];
			}else{
		
				target.value="";
				obj.value="";
			}
	}
	function assign(obj){
		var formObj = document.forms[0];
		formObj.practitioner_id.value = obj.value;
		document.getElementById("practitioner_pwd").value = ''; // IN048096
	}
	function authenticate(name,pwd){
		var formObj = document.forms[0];
		formObj.practitioner_id.value = formObj.practitioner_name.value 
		if(name.value.length<1){
			alert(getMessage("USER_ID_NOT_BLANK","SM"));
			return false;
		}
		if(pwd.value.length<1){
			alert(getMessage("ENTER_PWD","SM"));
			return false;
		}
		if(validateCheckListPIN()){
			window.returnValue='YES';
			window.close();
		}
		else{
			alert(getMessage("APP-OT0202","OT"));
			document.getElementById("practitioner_pwd").value = ''; // IN048096
			return false;
		}
		
	}
	function validateCheckListPIN(){
		var formObj = document.forms[0];
		var userId = formObj.practitioner_id.value;
		var userPwd = formObj.practitioner_pwd.value;
		if(userId.length<1){
			userId = formObj.doctorCode.value;
		}
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var param="func_mode=validateUserPwd&user_id="+userId+"&user_pwd="+userPwd;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
		xmlHttp.send(xmlDoc);
		var pwd = localTrimString(xmlHttp.responseText);
		
		if(pwd=="Y"){
			return true;
		}else{
			//alert("Invalid PIN");
			//alert(getMessage("APP-OT0063","OT"));
			return false;
		}
	}
	function disableEnterKey(e){ 
		var key; 
		if(window.event){ 
			key = window.event.keyCode; 
		} else { 
			key = e.which;      
		} 
		if(key == 13){ 
			return false; 
		} else { 
			return true; 
		}    
	} 
	</script>
</head>
<body>
<form name="authenticateForm" id="authenticateForm" autocomplete='off'>
<br/>
<br/>
	<table  border='0' cellpadding=3 cellspacing='0' width='70%' align="center">
	<% try{
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(sqlSelDoc);
			rst = pstmt.executeQuery();
	%>
	<tr> 
			<td class="label" width='30%'>
					<fmt:message key="Common.username.label" bundle="${common_labels}"/>
			</td>
			<td class="fields" width='70%'>
				<input type='hidden' name='practitioner_id' id='practitioner_id' >
				<!-- <input type='text' name='practitioner_name' id='practitioner_name' size='20' onblur="if(this.value!='')searchDoctor(practitioner_id,practitioner_name); else practitioner_id.value='';"  >			
				<input type='button' class='button' value='?' name='DoctorLookUp' id='DoctorLookUp' 	onClick='searchDoctor(practitioner_id,practitioner_name);'  > -->
				<select name="practitioner_name" id="practitioner_name" onchange="assign(this)">
					<%while(rst.next()) {%>
						<option value="<%=rst.getString("code")%>" selected>
						<%=rst.getString("description") %>
						</option>
					<%}
					pstmt = null;
					rst = null;

					pstmt = con.prepareStatement(sqlGetUsers);
					rst = pstmt.executeQuery();
					%>
					<%while(rst.next()) {%>
							<option value="<%=rst.getString("code")%>">
						<%=rst.getString("description") %>
						</option>
					<%}
					pstmt = null;
					rst = null;%>
				</select>
				<img src='../../eCommon/images/mandatory.gif'></img>
			</td>
	</tr>
	<%}
				
		catch(Exception e){
			System.err.println("Exception in User Authentication:"+e);
		}
				
		finally{
			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(con);
			}
			catch(Exception e){
				System.err.println("Exception in User Authentication:"+e);
			}
		}
	%>
	<tr>
			<td class="label" width='30%'>
				<fmt:message key="Common.password.label" bundle="${common_labels}"/>
			</td>
			<td class="fields" width='70%'>
				<input type="password" size='20' name="practitioner_pwd" id="practitioner_pwd" onKeyPress="return disableEnterKey(event)" autocomplete='off'>
				<img src='../../eCommon/images/mandatory.gif'></img>
			</td>
	</tr>
	<tr>
	</tr>
	<tr>
	</tr>
	 <tr>
			<td width='25%'class="button" colspan="2">
					<input type='button' name='record' id='record' class='button' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick='authenticate(practitioner_name,practitioner_pwd);'  >
					<input type='button' name='cancel' id='cancel' class='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='window.close();' >
			</td>
	
	</tr>
</table>
<input type='hidden' name='operRoom' id='operRoom' value='<%=operRoom%>'>
<input type='hidden' name='doctorCode' id='doctorCode' value='<%=doctorCode%>'>
</form>
</body>
</html>

