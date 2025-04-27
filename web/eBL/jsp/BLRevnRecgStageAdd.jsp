
<%
/*
Sr No        Version               Incident              SCF/CRF             	Developer Name
1			 V210518			   17598			  Common-ICN-0034			 Mohana Priya K
*/
%>
<html>
<head>
<%@page contentType="text/html;charset=UTF-8" import="java.sql.*,javax.naming.*,javax.rmi.*,java.io.*,java.util.*,java.util.ArrayList,java.util.HashMap,java.util.Enumeration,eBL.Common.*,eBL.*,eCommon.Common.*,webbeans.eCommon.*"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@page import="eBL.BLRevenueStageBean"%>
<%@ page import ="java.sql.Connection, java.util.ArrayList,webbeans.eCommon.ConnectionManager"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser" />
<%!
     private String checkForNull(String inputString) {
 		return (inputString == null) ? "" : inputString;
 	}
%>

<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	Connection connection	= null;
	PreparedStatement pstmt = null;
	//statement statement=null;
	ResultSet resultSet 	= null;
	String locale = (String)session.getAttribute("LOCALE");
	String facility_id = (String)session.getAttribute("facility_id");
	try{
		connection = ConnectionManager.getConnection(request);
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script src='../../eCommon/js/CommonCalendar.js' language='JavaScript'></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/ValidateControl.js' language='JavaScript'></script>
<Script src='../../eCommon/js/common.js' language='JavaScript'></Script>
<Script src='../../eBL/js/BLRevnRecgStage.js' language='JavaScript'></Script>
<Script src='../../eCommon/js/common.js' language='JavaScript'></Script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function descLoad(){
	var ordercat=document.getElementById('order_cat').value;
	var calld_frm = "getDesc";
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root></root>";
	var param="ordercat="+ordercat+"&calld_frm="+calld_frm; 
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eBL/jsp/BLRevnRecgStageValidation.jsp?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = (xmlHttp.responseText);
	var desc = retVal.split(":");
	document.getElementById('long_desc').value=desc[0];
	document.getElementById("short_desc").value=desc[1];
	if (document.getElementById('long_desc').value == "") 
	document.getElementById('long_desc').value="";
	if (document.getElementById("short_desc").value == 'null') 
	document.getElementById("short_desc").value="";
}

function orderType()
{
	var ordercat=document.getElementById('order_cat').value;
	var calld_frm = "getOrderType";
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root></root>";
	var param="ordercat="+ordercat+"&calld_frm="+calld_frm; 
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eBL/jsp/BLRevnRecgStageValidation.jsp?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = trim(xmlHttp.responseText);
	var orderTypeDesc = retVal.split("~~");
	var x=document.getElementById('order_type');
	$('#order_type').empty(); 
	var option1=document.createElement("option");
	option1.text="--Select--";
	x.add(option1);
	for(var r=0;r<orderTypeDesc.length-1;r++){
		var orderTypeCode = orderTypeDesc[r].split(":");
		var option=document.createElement("option");
		option.text=trim(orderTypeCode[0]);
		option.value=trim(orderTypeCode[1]);
		x.add(option);
	}
}

function trim(str) {
	if(str != ""){
		return str.replace(/^\s+|\s+$/g,'');
	}
    return "";
}
</script>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<form name='BLRevnRecgStageCreate' id='BLRevnRecgStageCreate' >
<table width='100%' align='center' cellspacing='0'>
	<tr>
		<td width='60%'>			
		<table width='100%'>
		<tr>
			<td width='20%' class="label" ><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
			<td width="25%" class="fields" >
			<Select name="order_cat" id="order_cat"  maxlength='30' onchange="descLoad();orderType();">
				<Option value="SLT" >--Select--</Option>
					<%					
						String sql=null;
						sql="select ORDER_CATEGORY from OR_ORDER_CATEGORY order by ORDER_CATEGORY";					
						pstmt = connection.prepareStatement(sql) ;					
						resultSet = pstmt.executeQuery();										
						while(resultSet.next()){%>
						<option value="<%=resultSet.getString(1)%>">
							<%=resultSet.getString(1)%></option>
						<%}%> 
			</select>
			<img src="../../eCommon/images/mandatory.gif">
		   </td>	
		  </tr>
		  <tr>
			<td width="20%" class="label" ><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
			<td width="25%" class="fields">
			<input type="text" name="long_desc" id="long_desc"  value="" maxlength=30 size=20 
			 onBlur="makeValidString(this);" readOnly='true'>
		</td>
		</tr>
		<tr>
			<td width='20%' class="label" ><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		<td class="fields">
			<input type="text" name="short_desc" id="short_desc" value="" maxlength=15 onBlur="makeValidString(this);" readOnly='true' >
		</td>
		</tr>
		<tr>
			<td width='20%' class="label" ><fmt:message key="eBL.ORDER_TYPE.label" bundle="${bl_labels}"/></td>
			<td width='25%' nowrap class='fields' >
			<Select name="order_type" id="order_type"   maxlength='30'  >
				<Option value='SLT'>--Select--</Option>
			</select>
			<img src="../../eCommon/images/mandatory.gif">
			</td>   
		</tr>		   
		<tr>
			<td width='20%' class="label" ><fmt:message key="eBL.Revenue_Stage.label" bundle="${bl_labels}"/></td>
			<td width='25%' nowrap class='fields' >
			<Select name="Revenue_Stage" id="Revenue_Stage">
			<Option value="SLT" >--Select--</Option>
			<Option id="opt" value="BLD" >Billed</Option>
			<Option value="REG" >Registered</Option>
			<Option value="CMP" >Completed</Option>
			</Select>
			<img src="../../eCommon/images/mandatory.gif">
			</td> 		
		</tr>
		<tr>
			<td width='20%' class="label" ><fmt:message key="eBL.VALID_FROM.label" bundle="${bl_labels}"/></td>
			<td class="fields">	
				<input type="text"  name="p_fm_date" id="p_fm_date" size="14" maxlength='10' value="" 
				onBlur="return checkDateBL(this)" >
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_fm_date');">
				<img src="../../eCommon/images/mandatory.gif">
			</td>
		</tr>
		</table>
	</td>		
</table>
<input type='hidden' name='locale' id='locale' value='<%=locale %>'>
<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id %>'>
</form>
<%
	}catch(Exception e)
	{
		e.printStackTrace();
		System.err.println("Exception in BlRevnRecgStageAdd.jsp::"+e);
	}
	finally{   //V210518 Starts
		try{
			if(pstmt!=null) pstmt.close();
			if(resultSet != null) resultSet.close();
			if(connection!=null){
				ConnectionManager.returnConnection(connection);
			}
		}catch(Exception ex) {
			ex.printStackTrace();	
		}
	}//V210518 Ends
%>
</body>
</html>

