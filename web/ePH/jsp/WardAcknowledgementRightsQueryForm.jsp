<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
11/10/2017	  	IN064272	        prathyusha 											GHL-CRF-0466 [IN064272] 
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"   
	import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>

<html>
<head>
<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
        request.setCharacterEncoding("UTF-8");
//Added  for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	    String locale			= (String)session.getAttribute("LOCALE");
	  	String login_user	=	(String)session.getValue("login_user");
		String facility_id   = (String)session.getValue( "facility_id" );

	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'
	type='text/css'></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<SCRIPT LANGUAGE="JavaScript" SRC="../js/WardAcknowledgeRights.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<SCRIPT>
			var function_id = "<%= request.getParameter( "function_id" ).trim() %>"   
		</SCRIPT>
</head>

<!-- <body> -->
<body onMouseDown="" onKeyDown="lockKey()">
	<%
		java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		String login_at_ws_no		        = prop.getProperty( "client_ip_address" );
		String bean_id						= "WardAcknowledgeRightsBean"+login_at_ws_no;
		String bean_name	= "ePH.WardAcknowledgeRightsBean";
		
		WardAcknowledgeRightsBean bean = (WardAcknowledgeRightsBean)getBeanObject( bean_id,bean_name,request) ;
		
		String patientClass=CommonBean.checkForNull(request.getParameter("patientcat"));
		String genral_drug="checked";
		String narcotic_drug="checked";
		String controlled_drug="checked";
		String genral_drug_yn="Y";
		String narcotic_drug_yn="Y";
		String controlled_drug_yn="Y";
		String mode			= request.getParameter( "mode" ).trim() ;
		System.out.println("mode"+mode);
		System.out.println("mode from common"+CommonRepository.getCommonKeyValue( "MODE_INSERT" ));
		if ( mode == null || mode.equals("") )
			return ;
		if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) ) ) )
			return ;
		 if ( (mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) ))){
			
			        genral_drug="checked";
				  narcotic_drug="checked";
				 controlled_drug="checked";
					genral_drug_yn="Y";
					 narcotic_drug_yn="Y";
					 controlled_drug_yn="Y";
		}
		
		 
		 
%>

	<form name="FormWardAcknowlegmentRightsQueryCriteria" id="FormWardAcknowlegmentRightsQueryCriteria">
		<table cellpadding='0' cellspacing='0' width="100%" align="center"
			border="0">
			<!--<tr><td>&nbsp;&nbsp;</td></tr> --><!-- removed for ghl-crf-0466 -->
			<!--<tr><td>&nbsp;&nbsp;</td></tr> --><!-- removed for ghl-crf-0466 -->
<%if( mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")) ) { %>
			<tr >
				<!-- added for ghl-crf-0466 -->	<td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td>
				<!-- added for ghl-crf-0466 -->	<td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td>
				<TD CLASS="label" ><fmt:message key="Common.user.label"
						bundle="${common_labels}" />&nbsp;</TD>
				<TD><INPUT TYPE="text" name="user_name" id="user_name" MAXLENGTH="30" SIZE="40" VALUE="" onBlur="checkUser(this.value)">
				    <INPUT TYPE="button" name="user_search" id="user_search" CLASS="button" VALUE="?" onClick="searchUserNames(user_name)"> 
					<IMG SRC="../../eCommon/images/mandatory.gif" ALIGN=center></IMG> 
					<INPUT TYPE="hidden" name="user_id" id="user_id" VALUE="">
					<INPUT TYPE="hidden" name="SQL_PH_DISP_RIGHTS_SELECT1" id="SQL_PH_DISP_RIGHTS_SELECT1" VALUE="<%= PhRepository.getPhKeyValue( "SQL_PH_DISP_RIGHTS_SELECT1") %>">
					</TD>

			</tr>
			<%-- <tr>
				<td WIDTH="10%"></td>
				<td class="label"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}" /></td>
				<td><INPUT type="text" name="nursing_unit" id="nursing_unit" SIZE="40" maxlength="30" onBlur="">
				<INPUT TYPE="button" name="nursunit_button" id="nursunit_button" VALUE="?" CLASS="button"onfocus="locationLookup(nursing_unit)" onclick="locationLookup(nursing_unit)"> 
				<INPUT TYPE="hidden" name="nursing_unit_code" id="nursing_unit_code" VALUE="">
					<IMG SRC="../../eCommon/images/mandatory.gif" ALIGN=center></IMG></td>
			</tr> --%>
<%} // else if( mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) ) {
	/* String userID	= request.getParameter("userid");
	String userName	= request.getParameter("username");
	String locnCode	= request.getParameter("locncode");
	String locnDesc	= request.getParameter("locndesc");
	System.out.println(userID);
	
	String loginUserId = bean.getLoginById();  
	
	ArrayList result=new ArrayList();
	result=bean.getAckrights(userID,locnCode);
	System.out.println(result);
	if(result.size() >0){
		System.out.println("in if");
		genral_drug_yn=CommonBean.checkForNull( (String)result.get(0));
		 narcotic_drug_yn=CommonBean.checkForNull((String)result.get(1));
		 controlled_drug_yn=CommonBean.checkForNull((String)result.get(2));
		if(genral_drug_yn.equals("Y")){
			genral_drug="checked";
		}
		else genral_drug="";
     if(narcotic_drug_yn.equals("Y")){
	 narcotic_drug="checked";
		}
     else narcotic_drug="";
    if(controlled_drug_yn.equals("Y")){
	 controlled_drug="checked";
        }
    else  controlled_drug="";
		
	 
	} */
	%>

<%-- <tr>
				<td WIDTH="10%"></td>
				<TD CLASS="label"><fmt:message key="Common.user.label"
						bundle="${common_labels}" />&nbsp;</TD>
				<TD><INPUT TYPE="text" name="user_name" id="user_name" MAXLENGTH="30" SIZE="40" VALUE="<%=userName %>" onBlur="checkUser(this.value)" disabled>
				    <INPUT TYPE="button" name="user_search" id="user_search" CLASS="button" VALUE="?" onClick="searchUserNames(user_name)" disabled> 
					<IMG SRC="../../eCommon/images/mandatory.gif" ALIGN=center></IMG> 
					<INPUT TYPE="hidden" name="user_id" id="user_id" VALUE="<%=userID %>">
					<INPUT TYPE="hidden" name="SQL_PH_DISP_RIGHTS_SELECT1" id="SQL_PH_DISP_RIGHTS_SELECT1" VALUE="<%= PhRepository.getPhKeyValue( "SQL_PH_DISP_RIGHTS_SELECT1") %>">
					</TD>

			</tr>
	 	<tr>
				<td WIDTH="10%"></td>
				<td class="label"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}" /></td>
				<td><INPUT type="text" name="nursing_unit" id="nursing_unit" SIZE="40" maxlength="30" onBlur="" value="<%=locnDesc%>" disabled>
				<INPUT TYPE="button" name="nursunit_button" id="nursunit_button" VALUE="?" CLASS="button"onfocus="locationLookup(nursing_unit)" disabled onclick="locationLookup(nursing_unit)"> 
					<INPUT TYPE="hidden" name="nursing_unit_code" id="nursing_unit_code" VALUE="<%=locnCode%>">
					<IMG SRC="../../eCommon/images/mandatory.gif" ALIGN=center></IMG></td>
			</tr> --%>
 


<%//} %>
			<tr>
			</tr>
			<tr>
			</tr>
			<tr>
			</tr>

		</table> 
		<%-- <TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="98%" ALIGN="center"
			BORDER="0">
			<TR>
				<TH COLSPAN="4"><fmt:message key="ePH.AuthorizedDrugs.label"
						bundle="${ph_labels}" /></TH>
			</TR>
			<TR>
				<TD CLASS="label" WIDTH="10%">&nbsp;</TD>
				<TD CLASS="label" WIDTH="20%"><fmt:message
						key="Common.general.label" bundle="${common_labels}" /></TD>
				<TD CLASS="label" WIDTH="25%"><fmt:message
						key="ePH.Narcotics.label" bundle="${ph_labels}" /></TD>
				<TD CLASS="label" WIDTH="25%"><fmt:message
						key="ePH.Controlled.label" bundle="${ph_labels}" /></TD>
			</TR>
			<TR>
				<TD CLASS="label" WIDTH="30%">&nbsp;</TD>
				<%
			if(genral_drug_yn.equals("Y")){
			%>
				<TD CLASS="label" WIDTH="20%">&nbsp; <IMG
					SRC="../../eCommon/images/enabled.gif"></IMG>

				</TD>
				<%}
			else{
			%>
				<TD CLASS="label" WIDTH="20%">&nbsp; <IMG
					SRC="../../eCommon/images/disabled.gif"></IMG>

				</TD>
				<%}
			 %>
				<%
			if(narcotic_drug_yn.equals("Y")){
			%>
				<TD CLASS="label" WIDTH="20%">&nbsp; <IMG
					SRC="../../eCommon/images/enabled.gif"></IMG>

				</TD>
				<%}
			else{
			%>
				<TD CLASS="label" WIDTH="20%">&nbsp; <IMG
					SRC="../../eCommon/images/disabled.gif"></IMG>

				</TD>
				<%}
			 %>
				<%
			if(controlled_drug_yn.equals("Y")){
			%>
				<TD CLASS="label" WIDTH="20%">&nbsp; <IMG
					SRC="../../eCommon/images/enabled.gif"></IMG>

				</TD>
				<%}
			else{
			%>
				<TD CLASS="label" WIDTH="20%">&nbsp; <IMG
					SRC="../../eCommon/images/disabled.gif"></IMG>

				</TD>
				<%}
			 %>



			</TR>
			<TR>


				<TD CLASS="label" WIDTH="30%">&nbsp;</TD>
				<TD CLASS="label" WIDTH="25%">&nbsp;&nbsp;<INPUT TYPE="checkbox" name="general_yn" id="general_yn" value="Y" <%=genral_drug %> onclick="AssignValue(this)"></TD>

				<TD CLASS="label" WIDTH="25%">&nbsp;&nbsp;<INPUT TYPE="checkbox" name="narcotic_yn" id="narcotic_yn" value="Y" <%=narcotic_drug %> onclick="AssignValue(this)"></TD>

				<TD CLASS="label" WIDTH="25%">&nbsp;&nbsp;<INPUT TYPE="checkbox" name="controlled_yn" id="controlled_yn" value="Y"
					<%=controlled_drug %> onclick="AssignValue(this)"></TD>
			</TR>
		</TABLE> --%>
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>"> 
		<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
			 
			 <input type="hidden" name="facility_id" id="facility_id" value=<%=facility_id%>> 
			<input type="hidden" name="p_language_id" id="p_language_id" value=<%=locale%>> 
			<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2")%>">
			<INPUT type="hidden" name="mode" id="mode" value="<%= mode %>">
		<% 
		putObjectInBean(bean_id,bean,request); 
%>
	</form>

</body>
</html>

