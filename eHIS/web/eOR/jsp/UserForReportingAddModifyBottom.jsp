<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="java.util.*,eOR.* ,eOR.Common.*,eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOR/js/UserForReporting.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




</head><!--   -->
<body onload='FocusFirstElement()'  OnMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<%
	//String readOnly = "" ;
	//String checked = "checked" ;
	/* Mandatory checks start */
	
	String mode	   = request.getParameter( "mode" ) ;
	String type	   = request.getParameter( "type" ) ;
	if(type != null)type = type.trim();

	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_UserForReporting" ;
	String bean_name = "eOR.UserForReporting";
	//String disabled = "" ;
	ArrayList Category_Data = new ArrayList();
	ArrayList responsibility_Data = new ArrayList();
	//ArrayList OrderType_Data = new ArrayList();

	String responsibility_id = (String)session.getValue("responsibility_id") ;

//	if ( !(mode.equals( CommonInterface.MODE_MODIFY ) || mode.equals( CommonInterface.MODE_INSERT )) )
//		return ;

/* Mandatory checks end */

	/* Initialize Function specific start */
	UserForReporting bean = (UserForReporting)getBeanObject( bean_id, bean_name , request ) ;
	bean.setLanguageId(localeName);
	bean.clear() ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setMode( mode ) ;


String resp_name		=  "";
String resp_id			=   "";
String pract_name		=   "";
String pract_id			=   "";

String ord_cat			=  "";
String ord_cat_desc		=  "";
String order_type		=  "";
String ord_typ_code		= "";
String user_category	=  "";
String security_level	= "";
String restrict_by_deptloc_yn = "";
String[] allValues = new String[11];
String detailData = "";
String order_category	= "";
String[] record=null;



/* Initialize Function specific end */
	if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") )  || mode.equals( CommonRepository.getCommonKeyValue("MODE_DELETE") ) ) {

		resp_id			= request.getParameter("resp_id");
		pract_id		= request.getParameter("pract_id");
		order_category	= request.getParameter("order_category");


		resp_id = resp_id.trim();
		pract_id = pract_id.trim();
		order_category = order_category.trim();


		if(resp_id == null ) resp_id = "";
		if(pract_id == null ) pract_id = "";
		if(order_category == null) order_category = "";

		try{
			allValues = bean.getMainData(resp_id, pract_id, order_category);

			resp_name		= allValues[0];
			pract_name		= allValues[2];
			ord_cat			= allValues[4];
			ord_cat_desc	= allValues[5];
			ord_typ_code	= allValues[6];
			order_type		= allValues[7];
			user_category	= allValues[8];
			security_level	= allValues[9];
			restrict_by_deptloc_yn = allValues[10];
			allValues=null;

			if(resp_name == null ) resp_name = "";
			if(pract_name == null ) pract_name = "";
			if(security_level == null ) security_level = "";
			restrict_by_deptloc_yn = (restrict_by_deptloc_yn == null) ? "N" : restrict_by_deptloc_yn;

			bean.setResponsibility(resp_id);
			bean.setResponsibilityDesc(resp_name);
			bean.setPractitioner(pract_id);
			bean.setPractitionerDesc(pract_name);

			bean.setOrderCategory(ord_cat);
			bean.setOrderCategoryDesc(ord_cat_desc);

			bean.setOrderType(ord_typ_code);
			bean.setOrderTypeDesc(order_type);
			bean.setPrivilege(user_category);
			bean.setSecurityLevel(security_level);
			bean.setRist_perform_loc_chk_val(restrict_by_deptloc_yn);
			//out.println("<script>alert('restrict_by_deptloc_yn="+bean.getRist_perform_loc_chk_val()+"')</script>");
			detailData = bean.getDetailData(resp_id, pract_id, order_category);
		//	out.println("<script>alert('detailData="+detailData+"')</script>");
			bean.fetchDBRecords(resp_id, pract_id,ord_cat, ord_typ_code);
			//int dbRecordCount		=  bean.fetchDBRecords(resp_id, pract_id,ord_cat, ord_typ_code);
						
		}catch(Exception e) {
			System.out.println(" Exception : "+e );
		}
	}
%>
<form name='user_for_reporting' id='user_for_reporting' target='messageFrame' >
<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
	


	<%if( mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT") )&& type.equals("responsibility")){%>
			<tr><td width="35%"   class="label"><fmt:message key="Common.responsibility.label" bundle="${common_labels}"/></td><td><SELECT name="responsibility" id="responsibility" ><option value=''> --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --- </option>
		<%
				responsibility_Data = bean.getAllResponsibility();


				for(int i=0; i<responsibility_Data.size(); i++){
					record = (String [])responsibility_Data.get(i);
		%>
				<option value=<%=record[0]%>><%=record[1]%></option>
		<%
				}responsibility_Data=null;
		%></SELECT><img src="../../eCommon/images/mandatory.gif"></td>
			</tr>

		<%} else if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) && (!(resp_name.equals("")))){%><tr><td width="35%"   class="label"><fmt:message key="Common.responsibility.label" bundle="${common_labels}"/></td><td ><input type=hidden name="responsibility" id="responsibility" value="<%=bean.getResponsibility()%>" ><input type=text name="resp_display" id="resp_display" value="<%=bean.getResponsibilityDesc()%>" readonly><img src="../../eCommon/images/mandatory.gif"></td></tr>
		<%} %>

	<%if( mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT") )&& type.equals("practioner")){%>

			<tr>
			<td width="35%"   class="label"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td><td ><input type='text' name='practitioner_desc' id='practitioner_desc' value='' size=30 maxlength=40 onFocus='javascript:blur()'><input type='button' name='practitioner_button' id='practitioner_button' class='button'   value='?' onClick='show_practtioner_window(document.getElementById("practitioner_desc"))'><img src="../../eCommon/images/mandatory.gif"></td></tr>
			<input type='hidden' name='practitioner' id='practitioner' value='' size=30 maxlength=40 >

		<%} else if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") )  && (!(pract_name.equals("")))) {%> <tr><td width="35%"  align=right class="label"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td><td><input type='text' name="pract_display" id="pract_display" value="<%=bean.getPractitionerDesc()%>"  size=30 maxlength=40 readonly>
			<input type='hidden' name='practitioner' id='practitioner' value="<%=bean.getPractitioner()%>" ><img src="../../eCommon/images/mandatory.gif"></td></tr>
		<%}%>

	
	<tr>
		<td width="35%"    class="label"><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
		<%if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {%>
			<td><input type=text name="ord_cat_display" id="ord_cat_display" value="<%=bean.getOrderCategoryDesc()%>" onKeyPress="return CheckForSpecChars(event)" readonly>
			<input type=hidden name="order_category" id="order_category" value="<%=bean.getOrderCategory()%>" ></td><%}else{%><td ><SELECT name="order_category" id="order_category"  onChange='populateOrderTyoes(this)'>
			<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
		<%
			try{
				Category_Data = bean.getAllOrderCategory();

				for(int i=0; i<Category_Data.size(); i++){
					record = (String [])Category_Data.get(i);

		%>
				<option value=<%=record[0]%>><%=record[1]%>
			
		<%
				}Category_Data=null;
			}catch(Exception e){
				System.out.println(e);
			}
		%>
			</SELECT><img src="../../eCommon/images/mandatory.gif"></td>

		<%}%>

	</tr>
	
	<TR><TD   class="label"><fmt:message key="eOR.RestrictPerformingLocation.label" bundle="${or_labels}"/></td>
	<%if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {%>
	<%--<Script>alert('here=<%=bean.getRist_perform_loc_chk_val()%>')</Script>--%>
		<TD id='rist_perform_loc_td'><Input type='checkbox' name='rist_perform_loc_chk' id='rist_perform_loc_chk' value='<%=bean.getRist_perform_loc_chk_val()%>' onClick='clickCheck(this)' <%=((bean.getRist_perform_loc_chk_val()).equalsIgnoreCase("Y"))?"checked":""%>>
		<%if ((bean.getRist_perform_loc_chk_val()).equalsIgnoreCase("Y")) {%>
			<input type='button' name='Performing_Locations' id='Performing_Locations'  value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PerformingLocation.label","common_labels")%>' class='BUTTON' onClick='clickButton()'> 
		<%}%>
	<%} else {%>
	<TD id='rist_perform_loc_td'><Input type='checkbox' name='rist_perform_loc_chk' id='rist_perform_loc_chk' value='N' onClick='clickCheck(this)'>
	<%}%>
	</TD></TR>
	
	<tr>
		<td width="35%"   class="label"><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
		<%if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {%>
			<td ><input type=text name="order_type_display" id="order_type_display" value="<%=bean.getOrderTypeDesc()%>" onKeyPress="return CheckForSpecChars(event)" readonly>
			<input type='button' name="orderable" id="orderable" class='button'   value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Orderable.label","common_labels")%>' onClick='orderableModify()' > 
			<input type=hidden name="order_type" id="order_type" value="<%=bean.getOrderType()%>" ><img src="../../eCommon/images/mandatory.gif">
			</td><%}else{%><td><SELECT name="order_type" id="order_type" OnChange='ClearBean()'>
				<option value=''> --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---

			</SELECT><img src="../../eCommon/images/mandatory.gif">
			<input type='button' name="orderable" id="orderable" class='button'   value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Orderable.label","common_labels")%>' onClick='Orderable()' >
			</td>
		<%}%>
	</tr>
	
	<tr>
		<td width="35%"   class="label"><fmt:message key="eOR.Privilege.label" bundle="${or_labels}"/></td>
		<td ><SELECT name="privilege" id="privilege">
			<option value=''> --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
			<%String strPrivilage=(bean.getPrivilege()==null)?"":bean.getPrivilege();%>
			<option value='R'<% if((strPrivilage).equals("R")){ out.print(" selected ");}%>><fmt:message key="eOR.Reporting.label" bundle="${or_labels}"/>
			<option value='A' <% if((strPrivilage).equals("A")){ out.print(" selected ");}%>><fmt:message key="eOR.ReportingandAuthorizing.label" bundle="${or_labels}"/>
		  </SELECT><img src="../../eCommon/images/mandatory.gif">
		</td>
	</tr>
	
<!-- 	<tr>
		<td width="35%"  align=right class="label">Security Level &nbsp;</td>
		<td >&nbsp;<input type=text name="security_level" id="security_level" size=1 maxlength=1 value='<%=bean.getSecurityLevel()%>' onKeyPress='return allowPositiveNumber()' onBlur="return checkPositiveNumber(this)">
		</td>

	</tr>
	<tr><td colspan="2">&nbsp;</td></tr>
 -->
 <input type=hidden name="security_level" id="security_level" size=1 maxlength=1 value=''>
</table>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<%if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {%>
<input type = 'hidden' name='rist_perform_loc_chk_val' id='rist_perform_loc_chk_val' value='<%=(bean.getRist_perform_loc_chk_val())%>'>
<%} else {%>
<input type = 'hidden' name='rist_perform_loc_chk_val' id='rist_perform_loc_chk_val' value='N'>
<%}%>
<%if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {%>
<input type=hidden name='finalString' id='finalString' value='<%=detailData%>'>
<input type='hidden' name='listValues' id='listValues' value='<%=detailData%>'>
<% } else {%>
<input type=hidden name='finalString' id='finalString' value=''>
<input type='hidden' name='listValues' id='listValues' value=''>
<%}%>
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
<input type="hidden" name="responsibility_id" id="responsibility_id" value="<%=responsibility_id%>">
<Input type="hidden" name='order_cat' id='order_cat' value="<%=order_category%>">
	<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
 <input type="hidden" name="prac_sql" id="prac_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_PRACTITIONER_LOOKUP_ADMIN")%>">
 <input type="hidden" name="prac_sql1" id="prac_sql1" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_PRACTITIONER_LOOKUP_SQL2_ADMIN")%>">
<!--   <input type="hidden" name="prac_sql" id="prac_sql" value="<%//=OrRepository.getOrKeyValue("SQL_OR_USER_FOR_REVIEW_PRAC_LOOKUP")%>"> -->
<!-- -------------------returned from Orderable modal window------------------>
<!-- <input type="hidden" name="ord_type_value" id="ord_type_value" value="">
<input type="hidden" name="ord_type_text" id="ord_type_text" value="">
<input type="hidden" name="ord_cat_value" id="ord_cat_value" value="">
<input type="hidden" name="ord_cat_text" id="ord_cat_text" value="">
<input type="hidden" name="catalog_desc" id="catalog_desc" value=""> -->
<!-- ------------------------------------------------------------------- -->
</form>

</body>
</html>
<%
	putObjectInBean(bean_id,bean,request);
%>

