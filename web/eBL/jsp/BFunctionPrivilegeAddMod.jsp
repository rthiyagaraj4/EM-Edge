<!DOCTYPE html>
<%@page import="java.util.Date"%>
<%@page import="eBL.BLFunctionPrivilegeBean"%>
<%@ page import="webbeans.eCommon.*,eBL.Common.*,com.ehis.util.*,java.util.*,java.sql.*,java.text.*, eBL.BLUserRightsBean"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- JSP Page specific attributes end --%>


<%
	request.setCharacterEncoding("UTF-8");
%>
<%!
String nulltoStr(String inputString){
	if(inputString==null){
		return "";
	}
	else{
		return inputString;
	}
}

private String assignSysdate(String inputString,String systemDate){
	if(inputString == null || "null".equals(inputString)){
		inputString = systemDate;
	}
	
	return inputString;
}
%>
<HTML>
<HEAD>
</HEAD>
<style>

	div.tableContainer {
		width: 100%;		/* table width will be 99% of this*/
		height: 160px; 	/* must be greater than tbody*/
		overflow: auto;
		margin: 0 auto;
	}

table {
	width: 100%;		/*100% of container produces horiz. scroll in Mozilla*/
	border: none;
	background-color: #f7f7f7;
	}
	
table>tbody	{  /* child selector syntax which IE6 and older do not support*/
	overflow: auto; 
	height: 120x;
	overflow-x: hidden;
	}
	
thead tr	{
	position:relative; 
	top: expression(offsetParent.scrollTop); /*IE5+ only*/
	}
		
		div.tableContainer {
		width: 100%;		/* table width will be 99% of this*/
		height: 140px; 	/* must be greater than tbody*/
		overflow: scroll;
		margin: 0 auto;
	}		

		.LocalYellow
		{
			BACKGROUND-COLOR: yellow ;
			FONT-SIZE: 8pt ;
			border-style: dashed;
			border-left-color: #D5E2E5;
			border-right-color: #D5E2E5;
			border-top-color: #D5E2E5;
			border-bottom-color: #D5E2E5; 
		}
		</style>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "")
			? (String) session.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
	
			
	String beanId = "FunctionPrivilegeBean" ;
	String beanName = "eBL.BLFunctionPrivilegeBean";
	
	BLFunctionPrivilegeBean functionPrivilegeBean = (BLFunctionPrivilegeBean) getBeanObject(beanId, beanName, request);
	cleanBeanObject(beanId, beanName, request);
	functionPrivilegeBean.clearAll();
			
	String action_mode=nulltoStr(request.getParameter("action_mode"));
	String rights_type = nulltoStr(request.getParameter("rights_type"));
	String rights_code = nulltoStr(request.getParameter("rights_code"));
	String eff_from_date =nulltoStr(request.getParameter("eff_from_date"));
	String eff_to_date = nulltoStr(request.getParameter("eff_to_date"));
	String appl_to_all_yn =nulltoStr(request.getParameter("appl_to_all_yn"));
	String appl_to_ip_yn =nulltoStr(request.getParameter("appl_to_ip_yn"));
	String appl_to_op_yn =nulltoStr(request.getParameter("appl_to_op_yn"));
	String appl_to_dc_yn =nulltoStr(request.getParameter("appl_to_dc_yn"));
	String appl_to_em_yn =nulltoStr(request.getParameter("appl_to_em_yn"));
	String appl_to_ex_yn =nulltoStr(request.getParameter("appl_to_ex_yn"));
	String appl_to_em_ex =appl_to_em_yn+appl_to_ex_yn;
	String todaysDate=null;
	String disabled = "";
	String readonly = "";
	String effFromDis = "";
	String effFromRead = "";
	boolean updateMode = false;

	String systemDate = "";
	try{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dt = new Date();		
		systemDate = dateFormat.format(dt);
	}
	catch(Exception e){
		systemDate = "";
	}
	
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
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'
	type='text/css' />
<link rel="stylesheet" type="text/css"
	href="../../eCommon/html/CommonCalendar.css"></link>
<style>
.YELLOW 
		{
			BACKGROUND-COLOR: yellow ;
			FONT-SIZE: 8pt ;
			border-style: dashed;
			border-left-color: #D5E2E5;
			border-right-color: #D5E2E5;
			border-top-color: #D5E2E5;
			border-bottom-color: #D5E2E5; 
		}
</style>
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language='javascript' src='../../eCommon/js/dchk.js'		   ></script>
<script language='javascript' src='../../eCommon/js/common.js'		   ></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js'	   ></script>
<script language="javascript" src="../../eBL/js/BLFunctionPrivilegePolicy.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
$(document).ready(function(){
	var firstRow = $('#privTableRow1').attr('rowValue');
	if(firstRow == 1){
		loadPrivilegePolicies(firstRow);
	}
	var rowCount = $('privilegeListSize').val();
	for(var i=0;i<rowCount;i++){
		
	}
});
</script>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
			String rightsType=request.getParameter("rightsType");
			String rightsCode=request.getParameter("rightsCode");
			String functionType=request.getParameter("functionType");
			if(functionType==null || functionType.trim().length()==0)
				functionType="";			
			if(rightsCode==null || rightsCode.trim().length()==0)
				rightsCode="";
			if(rightsType==null){
				rightsType="S";
			}
			
			

			
			System.out.println("rightsType/rightsCode/functionType==="+rightsType+"/"+rightsCode+"/"+functionType);
			
			 %>
<form id="BLUserRightsAddModForm" name="BLUserRightsAddModForm" id="BLUserRightsAddModForm" action="../../servlet/eBL.BLFunctionPrivilegeServlet" method="post" target="messageFrame">
<TABLE border='0' cellpadding='3' cellspacing='0' width='98%' align="center">
<% 


HashMap values=new HashMap();
values.put("rights_type", rightsType);
String queryString=BlRepository.getBlKeyValue("SQL_BL_PATSEARCH_RIGHTS_CODE",values,"PATSEARCH");

//String	facilityId		= (String) session.getValue( "facility_id");
String	loggedInUser	=  (String) session.getValue("login_user");	

response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
response.setHeader("Pragma","no-cache"); //HTTP 1.0   
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 
String applyMode																			=	new String();
String locale																				=	"";
String facilityId																			=	"";
String functionId																			=	"";
String mode																					=	"";
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
mode=request.getParameter("mode");
String functionTypeid=  "";
String functionTypedesc=  "";
String eff_fromDate=  "";
String eff_toDate=  "";
String priv_YN=  "";
if(("modify").equals(mode))
{
	disabled = "disabled";
	readonly = "readonly";
	System.out.println("Inside modify"+rightsType);
	functionTypeid=request.getParameter("functionId");
	functionTypedesc=request.getParameter("functionDesc");
	eff_fromDate=request.getParameter("effFrmDate");
	eff_toDate=request.getParameter("effToDate");
	priv_YN=request.getParameter("privYN");
	
	if(functionTypedesc == null || "null".equals(functionTypedesc))			functionTypedesc="All Functions";
	
	updateMode=true;	
	functionType=functionTypeid;
	
	System.out.println("Inside modify/rightsType/rightsCode/functionId/functionTypedesc/eff_fromDate/eff_toDate/priv_YN/updateMode"+rightsType+"/"+rightsCode+"/"+functionTypeid+"/"+functionTypedesc+"/"+eff_fromDate+"/"+eff_toDate+"/"+priv_YN+"/"+updateMode);
}
else{
	
	System.out.println("failure>>>>mode"+mode);
}

try  
{
	 
	sStyle 																					=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	locale 																					= 	(String)session.getAttribute("LOCALE");
	facilityId																				=   (String) session.getValue( "facility_id" ) ;
	//functionId																			=	checkForNull(request.getParameter("function_id"));
	bean_id																					= 	"BLUserRightsBean";
	bean_name																				= 	"eBL.BLUserRightsBean";
	BLUserRightsBean bLUserRightsBean														= 	(BLUserRightsBean)getBeanObject( bean_id, bean_name, request ) ;
	isUserCanAcess																			= 	(String) (session.getValue("isUserCanAcess")==null?"Y":(session.getValue("isUserCanAcess")));
	functionTypeMap																			=	bLUserRightsBean.populateFunctionTypeList(facilityId, locale);	
	functionTypeListDesc																			=	(ArrayList)functionTypeMap.get("Desc");
	functionTypeListId																		=	(ArrayList)functionTypeMap.get("Id");
	if(!("S".equals(rightsType) || "".equals(rightsType)) && !"".equals(rightsCode) && !"".equals(functionType)){
		recordPrivilegeDetailsDataMap															=    bLUserRightsBean.populatePrevilegeTypeList(facilityId, rightsType, rightsCode, functionType, todaysDate);
	}
	else{
		recordPrivilegeDetailsDataMap															=    new LinkedHashMap();
	}
	
	System.out.println("recordPrivilegeDetailsDataMap======"+recordPrivilegeDetailsDataMap);
/* 	privilegeListDesc																			=	(ArrayList)presTypeMap.get("Desc");
	privilegeListId																				=	(ArrayList)presTypeMap.get("Id"); 
	System.out.println("privilegeListDesc======"+privilegeListDesc);
	System.out.println("privilegeListId======"+privilegeListId); */
		
%>
	<tr>
		<td width="5%"></td> 
		<td class='label' width="20%"><fmt:message key="eBL.USER_TYPE.label" bundle="${bl_labels}"/></td>
		<td class='fields' width="75%">
		<select id="rightsType" name="rightsType" id="rightsType" onchange='rightsTypeOnChange()' <%=disabled %>>
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
				<img src='../../eCommon/images/mandatory.gif'>
		</td>
	
	</tr>
	<tr>
	<td width="5%"></td> 
		<td class='label' width="20%"><fmt:message key="eBL.USER_CODE.label" bundle="${bl_labels}"/></td>
		<td class='fields' width="75%">
		<%System.out.println("rightsCode/queryString"+rightsCode+"/"+queryString); %>
			<input type='text' name='rightsCode' id='rightsCode' size=22 id = "rightsCode" value="<%= rightsCode %>" onblur='GetLookupBlur(rightsCode)' <%=disabled %>> 
			<input type='button' class='button' name='user_lookup' id='user_lookup' value='?' onClick='GetLookup(rightsCode)' <%=disabled %>>
			<img src='../../eCommon/images/mandatory.gif'>
		</td>
	</tr>
	<tr>
	<td width="5%"></td>
	<td class='label' width="20%"><fmt:message key="eBL.FunctionId.label" bundle="${bl_labels}"/></td>
					<td class='fields'>
					<select id="function_type" name="function_type" id="function_type"  style="width: 250px;" onchange='functionIdOnChange()' <%=disabled %> >
					<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
					<%


					System.out.println("functionTypeListId.size()========"+functionTypeListId);
					System.out.println("functionTypeListId.size()========"+functionTypeListId.size());
					
					if(("modify").equals(mode)){
						%>
						<option value="<%=functionTypeid%>" selected><%=functionTypedesc%></option>
						<%
					}
					else{
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
					}
					%>	
					</select>
					<input type="hidden"  name="functionTypeid" id="functionTypeid"  id="functionTypeid"  value="<%=functionTypeid%>"/>
					<input type="hidden"  name="functionTypedesc" id="functionTypedesc"  id="functionTypedesc"  value="<%=functionTypedesc%>"/>
					<img src='../../eCommon/images/mandatory.gif'>		
				</td>
	</tr>
	<!--<tr>
	<td width="5%"></td> 
		<td class='label' width="20%"><fmt:message key="eBL.DEFLT_PRIVILEGE.label" bundle="${bl_labels}"/></td>
		<td class='fields' width="75%">
			<input type="checkbox" name="defaultchk" id="defaultchk" id = "defaultchk" value="all" >
		</td>
	</tr> -->
	<td width="5%"></td> 
	<table cellpadding=3 cellspacing=0  align="center" width="98%" id="panel_categories_header_table" name="panel_categories_header_table" id="panel_categories_header_table" border="1"  >
		<div id="tableContainer">
		<thead>
		<TR>
		<th  class='columnheader' width="40%" align="left"><fmt:message key="eBL.PRIVILEGE.label" bundle="${bl_labels}"/></th>
		<th  class='columnheader' width="24%" align="left"><fmt:message key="Common.EffectiveDate.label" bundle="${common_labels}"/></th>
		<th  class='columnheader' width="24%" align="left"><fmt:message key="Common.EffectiveTo.label" bundle="${common_labels}"/></th>
		<th  class='columnheader' width="12%" align="left"><fmt:message key="eBL.ALLOWED_YN.label" bundle="${bl_labels}"/></th>
		</TR>
		</thead>
			<TBODY>
			<%
			System.out.println("<<<<<<<<<IN BLUserRightsMainAddMod.jsp recordPrivilegeDetailsDataMap:size:::::::>>>>>>"+recordPrivilegeDetailsDataMap.size()); 

			Iterator iterator= recordPrivilegeDetailsDataMap.keySet().iterator();

			String serviceIndKey = "";
			String serviceIndValue = "";
			String priceIndKey = "";
			String priceIndValue = "";
			String checked = "";
			String privilegeListDesc=null;
			int count=0;
			while(iterator.hasNext())
			{
				
				System.out.println("iterator..............");
				
				int index =    (Integer)iterator.next();
				int sNo	  =		index+1;

				System.out.println("<<<<<<<<<<<<IN  index>>>>>>>"+index);
				bLUserRightsBean = (BLUserRightsBean) recordPrivilegeDetailsDataMap.get(index);  
				privilegeListDesc=bLUserRightsBean.populatePrevilegeList(bLUserRightsBean.getPrevilegeID());
				if(privilegeListDesc == null || "null".equals(privilegeListDesc))	privilegeListDesc = "All Privilege";
				
		%>
		
		<tr id='privTableRow<%=sNo%>' rowValue='<%=sNo%>' >

			<%
					if(bLUserRightsBean.getPrevilegeDesc()!=null && bLUserRightsBean.getPrevilegeDesc().trim().length()>0 && "Y".equalsIgnoreCase(bLUserRightsBean.getPrevilegeDesc()))
					{
					%>
					<td class='fields'>
				<input type="checkbox"  name="privilege<%=index%>" id="privilege<%=index%>" id="privilege<%=index%>"  checked > <%=privilegeListDesc%> &nbsp;&nbsp;&nbsp;<a href='javascript:loadPrivilegePolicies(<%=sNo%>)'><i>(Dtls)</i></a>
					</td>
					<%
					}
					else
					{
					%>
					<td class='fields'>
					<input type="checkbox"  name="privilege<%=index%>" id="privilege<%=index%>" id="privilege<%=index%>"  ><%=privilegeListDesc%> &nbsp;&nbsp;&nbsp;<a href='javascript:loadPrivilegePolicies(<%=sNo%>)'><i>(Dtls)</i></a>
					</td>
					<%}%>
				<input type="hidden" name="privilegeId<%=index%>" id="privilegeId<%=index%>" id="privilegeId<%=index%>" value ="<%=bLUserRightsBean.getPrevilegeID()%>">
				<input type="hidden" name="privilegeName<%=index%>" id="privilegeName<%=index%>" id="privilegeName<%=index%>" value = "<%=bLUserRightsBean.getPrevilegeDesc()%>">	
					
				
					
					<%-- <input type='text' name='dateFrom' id='dateFrom' id='dateFrom' onblur='dateOnBlur("dateFrom");' value=<%=todaysDate%>> --%>					
					<%
					if(checkForNull(bLUserRightsBean.getPolicyEffectiveFrom()).length()>0){ 
						effFromDis = "disabled";
						effFromRead = "readonly";
					}
					else{
						effFromDis = "";
						effFromRead = "";
					}
					%>
					<td class='fields'>
						<input type='text' <%=effFromRead %> name='dateFrom<%=index%>' id='dateFrom<%=index%>' onblur='isValidDate(this);checkDates(this,dateTo<%=index%>);' value='<%=assignSysdate(bLUserRightsBean.getPolicyEffectiveFrom(),systemDate)%>'>
						<img src="../../eCommon/images/CommonCalendar.gif" id='fromCalendar<%=index %>' <%=effFromDis %> onclick="return showCalendar('dateFrom<%=index%>');" style='cursor: hand' >
						<img src='../../eCommon/images/mandatory.gif'>
					</td>
					<td class='fields'><input type='text'  name='dateTo<%=index%>' id='dateTo<%=index%>' id='dateTo<%=index%>' onblur='isValidDate(this);checkDates(dateFrom<%=index%>,this);' value='<%=checkForNull(bLUserRightsBean.getEffectiveTo())%>'>
						<img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('dateTo<%=index%>');" style='cursor: hand'"></td>
					<td class='fields'>
						<input type='checkbox' name='allowedYn<%=index %>' id='allowedYn<%=index %>' id='allowedYn<%=index %>'  <%="Y".equals(bLUserRightsBean.getAllowedYn())?"checked":"" %>
					</td>				
				<tr>
					<%
					count++;
		}
					%>	
				<input type="hidden" name="privilegeListSize" id="privilegeListSize" id="privilegeListSize" value = "<%=recordPrivilegeDetailsDataMap.size()%>" >
		</td>
<!-- 		<input type="button" class='button' name="add_mod" id="add_mod"	id="add_mod"   value="Modify" onclick="authUser();"  /> -->
	</tr>
<%-- 	<tr>
		<td width="5%"></td> 
		<td width="20%" class='label'><fmt:message key="eBL.EFFECTIVE_FROM_TO.label" bundle="${common_labels}"/></td>
		<td width="75%" class="fields">
			<TABLE border='0' cellpadding='3' cellspacing='0' width='100%'>
				<tr>
					<td>
					<input type='text' name='dateFrom' id='dateFrom' id='dateFrom' onblur='dateOnBlur("dateFrom");' value=<%=todaysDate%>>
					<input type='text' name='dateFrom' id='dateFrom' id='dateFrom' onblur='dateOnBlur("dateFrom");'>
					<img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('dateFrom');" style='cursor: hand'>
						&nbsp;-&nbsp;
					<input type='text'
						name='dateTo' id='dateTo' id='dateTo' onblur='dateOnBlur("dateTo");'><img
						src="../../eCommon/images/CommonCalendar.gif"
						onclick="return showCalendar('dateTo');" style='cursor: hand'">				
					</td>
				<tr>
				</tr>
			</TABLE>
				</table>
	</tr> --%>
	<tr>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
	</table>
<input type='hidden' name='actionMode' id='actionMode' value="<%=action_mode%>">
<input type='hidden' name='locale' id='locale' id='locale' value="<%=locale%>" >
<input type='hidden' name='facilityId' id='facilityId' value="<%=facilityId%>" >
<input type='hidden' name='queryString' id='queryString' value="<%=queryString %>">
<input type='hidden' name='prevClicked' id='prevClicked' id='prevClicked' vlaue=''>
<input type='hidden' name='prevRights' id='prevRights' id='prevRights' value='<%=rightsCode %>'>
</form>
	<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:30%; visibility:hidden;' bgcolor='blue'></div>
</body>
</TBODY>	
	
	</div>
<%
}
catch(Exception e)
{
	System.out.println("Exception in BillingRecordApprovalSearch.jsp::"+e);
}
%>
<%!	
private String checkForNull(String inputString)
{
	if(inputString == null || "null".equals(inputString)){
		inputString = "";
	}
	return inputString;
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
%>
</HTML>

