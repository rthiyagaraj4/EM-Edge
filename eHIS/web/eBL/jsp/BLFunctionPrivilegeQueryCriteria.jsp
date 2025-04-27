<!DOCTYPE html>
<html>
<head>
<title>Policy Definition</title>


<%@ page import="webbeans.eCommon.*,eBL.Common.*,com.ehis.util.*,java.util.*,java.sql.*,java.text.*, eBL.BLUserRightsBean"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<% request.setCharacterEncoding("UTF-8");%>
<%!
String nulltoStr(String inputString){
	if(inputString==null){
		return "";
	}
	else{
		return inputString;
	}
}
%>

<%


String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String locale = (String)session.getAttribute("LOCALE");
String facility_id = (String)session.getAttribute("facility_id");

String action_mode=nulltoStr(request.getParameter("action_mode"));
String eff_from_date =nulltoStr(request.getParameter("eff_from_date"));
String eff_to_date = nulltoStr(request.getParameter("eff_to_date"));

String todaysDate=null;
if(action_mode.equals("modify")){
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Timestamp inputTimeStamp = null;
    long longTimeStamp = 0;
    inputTimeStamp = Timestamp.valueOf(eff_from_date);
    longTimeStamp = inputTimeStamp.getTime();
    eff_from_date=sdf.format(longTimeStamp);
    inputTimeStamp = Timestamp.valueOf(eff_to_date);
    longTimeStamp = inputTimeStamp.getTime();
    eff_to_date=sdf.format(longTimeStamp);
	}
	else{
DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
Calendar cal = Calendar.getInstance();
todaysDate=dateFormat.format(cal.getTime());
	}

String rightsType=request.getParameter("rightsType");
String functionType=request.getParameter("functionType");
System.out.println("functionType==="+functionType);
if(functionType==null || functionType.trim().length()==0)
	functionType="";
String rightsCode=request.getParameter("rightsCode");
if(rightsCode==null || rightsCode.trim().length()==0)
	rightsCode="";
System.out.println("rightsCode==="+rightsCode);
if(rightsType==null){
	rightsType="S";
}

HashMap values=new HashMap();
values.put("rights_type", rightsType);
String queryString=BlRepository.getBlKeyValue("SQL_BL_PATSEARCH_RIGHTS_CODE",values,"PATSEARCH");
String facilityId																			=	"";
String functionId																			=	"";
String mode																					=	"";
mode																						=	"";
String isUserCanAcess																		=	"";
String bean_id																				=	"";
String bean_name																			=	"";
String modifyStatus     																	=	"";
ArrayList functionTypeListDesc	 															=	null;
ArrayList functionTypeListId																=	null;
ArrayList privilegeListId	 	 															=	null;
HashMap	 functionTypeMap																	= 	null;
HashMap	 presTypeMap																		= 	null;
LinkedHashMap		recordPrivilegeDetailsDataMap											=	null;

try  
{
 
	sStyle 																					=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	locale 																					= 	(String)session.getAttribute("LOCALE");
	facilityId																				=   (String) session.getValue( "facility_id" ) ;
	bean_id																					= 	"BLUserRightsBean";
	bean_name																				= 	"eBL.BLUserRightsBean";
	BLUserRightsBean bLUserRightsBean														= 	(BLUserRightsBean)getBeanObject( bean_id, bean_name, request ) ;
	isUserCanAcess																				= 	(String) (session.getValue("isUserCanAcess")==null?"Y":(session.getValue("isUserCanAcess")));
	functionTypeMap																				=	bLUserRightsBean.populateFunctionTypeList(facilityId, locale);	
	functionTypeListDesc																			=	(ArrayList)functionTypeMap.get("Desc");
	functionTypeListId																			=	(ArrayList)functionTypeMap.get("Id");
	recordPrivilegeDetailsDataMap																=    bLUserRightsBean.populatePrevilegeTypeList(facilityId, rightsType, rightsCode, functionType, todaysDate);
	System.out.println("recordPrivilegeDetailsDataMap======"+recordPrivilegeDetailsDataMap);
}
catch(Exception e)
{
	System.out.println("Exception in BillingRecordApprovalSearch.jsp::"+e);
}
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

<%@ page import ="java.sql.Connection, java.util.ArrayList,webbeans.eCommon.ConnectionManager"  %>
<link rel='stylesheet' type='text/css'
	href='../../eCommon/html/CommonCalendar.css'></link>
<script src='../../eCommon/js/CommonCalendar.js' language='JavaScript'></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/ValidateControl.js' language='JavaScript'></script>
<Script src='../../eCommon/js/common.js' language='JavaScript'></Script>
<script language='javascript' src='../../eBL/js/BLFunctionPrivilegePolicy.js'></script>
<script language='javascript'>
function focusObject() {
	document.forms[0].elements[0].focus();
}
function addOrderByCol() {
	var i = 0;
	var from = document.getElementById('orderbycols');
	if (from.options.length > 0) {
		var to = document.getElementById('orderbycolumns');
		var element = document.createElement('OPTION');
		element.text = from.options[from.selectedIndex].text;
		element.value = from.options[from.selectedIndex].value;
		to.add(element);
		from.remove(from.selectedIndex);
		if (from.options[i])
			from.options[i].selected = true;
		i++;
	}
}
function removeOrderByCol() {
	var j = 0;
	var from = document.getElementById('orderbycolumns');
	if (from.options.length > 0) {
		var to = document.getElementById('orderbycols');
		var element = document.createElement('OPTION');
		element.text = from.options[from.selectedIndex].text;
		element.value = from.options[from.selectedIndex].value;
		to.add(element);
		from.remove(from.selectedIndex);
		if (from.options[j])
			from.options[j].selected = true;
		j++;
	}
}
function SelectAll() {
	var i = 0;
	document.getElementById("orderbycolumns").selectedIndex = 0;
	while (i < document.getElementById("orderbycolumns").length) {
		document.getElementById("orderbycolumns").options[i].selected = true;
		i++;
	}
}
/*
function execQuery() {
	if (document.getElementById("orderbycolumns").options.length > 0) {
		SelectAll();
		document.query_form.submit();
	} else {
		alert(getMessage('ORDERBY_NOT_BLANK', 'Common'))
	}
}
*/ //V230420
function execQuery() {
	if (document.getElementById("orderbycolumns").options.length > 0) {
		var rightsType= document.getElementById('rightsType').value;
		var rightsCode= document.getElementById('rightsCode').value;
		var function_type= document.getElementById('function_type').value;
		parent.frames[1].location.href="../../eBL/jsp/BLFunctionPrivilegeQueryResult.jsp?rightsCode="+rightsCode+"&rightsType="+rightsType+"&function_type="+function_type;
	} else {
		alert(getMessage('ORDERBY_NOT_BLANK', 'Common'))
	}
}
//V230420-MOHE-SCF-0198-TP

function clearPolicyFields(obj){
	obj.value = '';
}





</script>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown='lockKey()'
	onLoad='focusObject()'>
<form name='query_form' id='query_form'><Script src='../../eCommon/js/common.js' language='JavaScript'></Script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<table width='100%' align='center' cellspacing='0' cellpadding='0'>
	<tr>
		<th align='left' width='20%'><fmt:message key="Common.QueryCriteria.label" bundle="${common_labels}"/></th>
		<tr>
			<td width='60%'>
			<p title='Query Criteria'>
			<table width='100%'>
				<tr>
		<td width="5%"></td> 
		<td class='label' width="20%"><fmt:message key="eBL.USER_TYPE.label" bundle="${bl_labels}"/></td>
		<td class='fields' width="75%">
		<select id="rightsType" name="rightsType"  onchange='rightsTypeOnChangeQuery()'>
		<%System.out.println("rightsType======"+rightsType); %>
				<option value='S' <%=rightsType.equals("S")?"selected":""%>>
					----
					<fmt:message key="Common.defaultSelect.label"
						bundle="${common_labels}" />
					----
				</option>
				<option value='U' <%=rightsType.equals("U")?"selected":""%>><fmt:message key="Common.user.label" bundle="${common_labels}"/></option>
				<option value='G' <%=rightsType.equals("G")?"selected":""%>><fmt:message key="Common.Group.label" bundle="${common_labels}"/></option>
				<option value='R' <%=rightsType.equals("R")?"selected":""%>><fmt:message key="Common.responsibility.label" bundle="${common_labels}"/></option>
		</select>			
				
		</td>
			   </tr>
				<tr>
	<td width="5%"></td> 
		<td class='label' width="20%"><fmt:message key="eBL.USER_CODE.label" bundle="${bl_labels}"/></td>
		<td class='fields' width="75%">
			<input type='text' name='rightsCode' id='rightsCode' size=22 id = "rightsCode" value="<%= rightsCode %>" onblur='GetLookupBlurQuery(rightsCode)'> 
			<input type=button class=button name='user_lookup' id='user_lookup' value='?' onClick='GetLookupQuery(rightsCode)'>
			
		</td>			
				</tr>
				<tr>
	<td width="5%"></td>
	<td class='label' width="20%"><fmt:message key="eBL.FunctionId.label" bundle="${bl_labels}"/></td>
					<td class='fields'>
					<select id="function_type" name="function_type"   style="width: 250px;" onchange='functionIdOnChange_query()'>
					<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
					<%
					String functionTypeid=  "";
					String functionTypedesc=  "";
					System.out.println("functionTypeListId========"+functionTypeListId);
					System.out.println("functionTypeListId.size()========"+functionTypeListId.size());
					for(int index=0;index<functionTypeListId.size();index++)
					{
					System.out.println("functionType=-========"+functionType);
					System.out.println("(String)functionTypeListId.get(index))=-========"+(String)functionTypeListId.get(index));
						if(functionType!=null && functionType.trim().length()>0 && functionType.equalsIgnoreCase((String)functionTypeListId.get(index)))
						{%>
						<option value="<%=functionTypeListId.get(index)%>" selected><%=functionTypeListDesc.get(index)%> 
						</option>
						<%functionTypeid = 	(String)functionTypeListId.get(index);	
						functionTypedesc = 	(String)functionTypeListDesc.get(index);				
					 }else
					    {%>
						<option value="<%=functionTypeListId.get(index)%>"><%=functionTypeListDesc.get(index)%>  
						</option>
					    <%}
					}
					%>	
					</select>
					<input type="hidden"  name="functionTypeid" id="functionTypeid"  id="functionTypeid"  value="<%=functionTypeid%>"/>
					<input type="hidden"  name="functionTypedesc" id="functionTypedesc"  id="functionTypedesc"  value="<%=functionTypedesc%>"/>
						
				</td>
				</tr>
			</table>
			</td>
		</tr>
</table>
</p>
<table width='100%' align='center'>
	<th width='20%' align='left'><fmt:message key="Common.SortOrder.label" bundle="${common_labels}"/>
	</td>
	<tr>
		<td width='60%'>
		<p title='Sort Order'>
		<table width='100%'>
			<td align='center'><b><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
			<td>&nbsp;</td>
			<td align='center'><b><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
			<tr>
				<td width='45%' align='center'><select name='orderbycols' id='orderbycols' 	size='5'>					
					<option value='hdr.USER_TYPE'><fmt:message key="eBL.USER_TYPE.label" bundle="${bl_labels}"/></option>
					<option value='hdr.USER_CODE'><fmt:message key="eBL.USER_CODE.label" bundle="${bl_labels}"/></option>				
				</select></td>
				<td align='center' width='3%'><input type='button' name='add' id='add'
					class='button' onclick='addOrderByCol()' value='---->'> <input type='button' name='add' id='add' class='button' value='<----'
					onclick='removeOrderByCol()'></img></td>
				<td width='45%' align='center'><select name='orderbycolumns' id='orderbycolumns' 
					size='5' multiple='true'>
					<option value='hdr.FUNCTION_ID'><fmt:message key="eBL.FunctionId.label" bundle="${bl_labels}"/></option>
				</select></td>
			</tr>
		</table>
		</p>
		</td>
	</tr>
</table>
<br>
<table border='0' width='100%' align='center'>
	<tr>
		<td width='100%' align='center' class='white'><input type='button' name='ExecuteQuery' id='ExecuteQuery' class='Button'
			onclick='execQuery()'></td>
	</tr>
</table>
<script>var exe=getLabel('Common.Execute.label','common'); document.forms[0].ExecuteQuery.value=exe;</script>
<input type='hidden' name='locale' id='locale' value='<%=locale %>'>
<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id %>'>
<!-- Added by Rajesh V -->
<input type='hidden' name='queryString' id='queryString' value="<%=queryString %>">
<!-- Added by Rajesh V -->
</form>
</body>
</html>

