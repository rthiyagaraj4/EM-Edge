<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
06/09/2011    IN31901        NijithaS    Incident No: IN31901 - Bru-HIMS-CRF-263		 
-------------------------------------------------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<%  
   
	String facility_id = (String)session.getValue("facility_id");
	//	out.println(facility_id);
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String mode			= request.getParameter( "mode" ) ;
	String function_id  = request.getParameter("function_id") ;
	String bean_id		= "performing_location" ;
	String bean_name	= "eOR.PerformingLocation";
	//String disabled		= "" ;
	int		totalRecords	=	0;
	totalRecords	=	Integer.parseInt(CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE"));
	PerformingLocation bean = (PerformingLocation)getBeanObject( bean_id,  bean_name , request) ;

%>

<html>
<head>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
	-->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eOR/js/PerformingLocation.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>

<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()"> <%--  onload='FocusFirstElement()'--%>
<form name='perform_locn_bottom' id='perform_locn_bottom' target='messageFrame' >
<%
if((mode.trim().equals("1"))){
%>
	<table class='grid' width='100%'>
	<tr><td class='COLUMNHEADER'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
	    <td class='COLUMNHEADER'><fmt:message key="Common.external.label" bundle="${common_labels}"/></td>
	    <td class='COLUMNHEADER'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	</tr>
	<%
	for(int i=0; i<totalRecords; i++){
	String  classValue = "";

		if ( i % 2 == 0 )
		  	classValue = "gridData" ;
		else
		  	classValue = "gridData" ;
	%>
	<tr>
		<td   class='<%=classValue%>' nowrap ><input type="text" name="code<%=i%>" id="code<%=i%>" size="4" maxlength="4" onBlur='ChangeUpperCase(this);resetColorCode(this);' onkeypress="return CheckForSpecChars(event)" >
			<%/*--onkeypress="return CheckForSpecChars(event)"--*/%>
		<%if(i == 0){%><img src="../../eCommon/images/mandatory.gif"></img><%}%></td>
		<td  class='<%=classValue%>' nowrap ><input type="text" name="long_desc<%=i%>" id="long_desc<%=i%>" value="" size="30" maxlength="30" onBlur="makeValidString( this );resetColorCode(this);">
		<%if(i == 0){%><img src="../../eCommon/images/mandatory.gif"></img><%}%></td>
		<td  class='<%=classValue%>' nowrap ><input type="text" name="short_desc<%=i%>" id="short_desc<%=i%>" value="" size="15" maxlength="15" onBlur="makeValidString( this );resetColorCode(this);">
		<%if(i == 0){%><img src="../../eCommon/images/mandatory.gif"></img><%}%></td>
		<td  class='<%=classValue%>' nowrap ><input type="checkbox" name="intext<%=i%>" id="intext<%=i%>" value="I" onclick="checkIE(this)"></td>
		<td  class='<%=classValue%>' nowrap ><input type="checkbox" name="enabled<%=i%>" id="enabled<%=i%>" value="E" checked onclick="checkEnabled(this)"></td>
	</tr>
	<%
	}
	%>
	</table>
	<INPUT TYPE="hidden" name="locn_type" id="locn_type" value="">

<%
} else if((mode.trim().equals("2"))){
		String locn_type =  request.getParameter( "locn_type" ) ;
		String code =  request.getParameter( "code" ) ;

		String long_desc = "";
		String short_desc = "";
		String eff_status = "";
		String int_or_ext = "";
		String checkedIE = "";
		//String readonlyIE = "";
		String checked= "";
		String readonly= "",disable="";

		bean.setFunctionId(bean.checkForNull(function_id));
		bean.clear() ;
		bean.setMode(mode) ;

		bean.loadData(locn_type, code);

		long_desc = bean.getLongDesc() ;
		short_desc =bean.getShortDesc() ;
		eff_status =bean.getEffStatus() ;
		int_or_ext = bean.getIntOrExt();
		//out.println(int_or_ext);
		if(locn_type == null)		 locn_type = "";	else locn_type	= locn_type.trim();
		if(short_desc == null)		 short_desc = "";	else short_desc = short_desc.trim();
		if((eff_status.trim()).equals("E")){
			checked = " checked ";
		}else{
			readonly = "  readonly ";
			disable	 = "disabled";
			checked	 = "";
		}
		//Added by Subhash.Y 
		//Start
		if((int_or_ext.trim()).equals("X"))
		{
			checkedIE = "checked";
		}
		else{
			//readonlyIE = "readonly";
			checkedIE = "";
		}
		//End	
		String locationType = "";
		if (locn_type.equalsIgnoreCase("I"))
			locationType = "Departmental Diagnostics";
		else if (locn_type.equalsIgnoreCase("P"))
			locationType = "Patient Care";
		else if (locn_type.equalsIgnoreCase("T"))
			locationType = "Treatment Location";
		else if (locn_type.equalsIgnoreCase("M"))
			locationType = "Miscellaneous Service Location";
		else if (locn_type.equalsIgnoreCase("L"))
			locationType = "Laboratory Site";
		else if (locn_type.equalsIgnoreCase("R"))
			locationType = "Radiology Wing";
		else if (locn_type.equalsIgnoreCase("O"))//IN31901
			locationType = "Non OT Rooms";//IN31901

%>
<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
	
	<tr>
		<td width="25%"   class="label"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
		<td class="fields"><input type=text name="locn_type_disp" id="locn_type_disp" value="<%=locationType%>" size="30" readonly ><input type=hidden name="locn_type" id="locn_type" value="<%=locn_type%>">
		<img src="../../eCommon/images/mandatory.gif"></td>
	</tr>
	
	<tr>
		<td width="25%"   class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		<td class="fields"><input type=text name="code_disp" id="code_disp" value="<%=code%>" readonly  size='4' maxlength='4'><input type=hidden name="code" id="code" value="<%=code%>">
		<img src="../../eCommon/images/mandatory.gif"></td>
	</tr>
	
	<tr>
		<td width="25%"   class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
		<td class="fields"><input type=text name="long_desc" id="long_desc" value="<%=long_desc%>"  <%=readonly%> size='30' maxlength='30' onBlur="makeValidString( this );">
		<img src="../../eCommon/images/mandatory.gif"></td>
	</tr>
	
	<tr>
		<td width="25%"   class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		<td class="fields"><input type=text name="short_desc" id="short_desc" value="<%=short_desc%>" <%=readonly%> size='15' maxlength='15' onBlur="makeValidString( this );">
		<img src="../../eCommon/images/mandatory.gif"></td>
	</tr>
	
	<tr>
		<td width="25%"   class="label"><fmt:message key="Common.external.label" bundle="${common_labels}"/></td>
		<td class="fields"><input type=checkbox name="intext" id="intext" value="<%=int_or_ext%>" <%=checkedIE%> <%=disable%>		 ></td>
	</tr>
	
	<tr>
		<td width="25%"   class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<td class="fields"><input type=checkbox name="enabled_status" id="enabled_status" value="<%=eff_status%>" <%=checked%> ></td>
	</tr>
	
</table>

<%
}
%>
	<INPUT TYPE="hidden" name="mode" id="mode" value="<%=mode%>">
	<INPUT TYPE="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<INPUT TYPE="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input TYPE="hidden" name="totalRecords" id="totalRecords" value="<%=totalRecords%>">
	<INPUT TYPE="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
 <!--	<input type="hidden" name="function_id" id="function_id" value="<%//=bean.getFunctionId()%>">-->
 
</form>
</body>
</html>
<%
		putObjectInBean(bean_id,bean,request);
 
%>

