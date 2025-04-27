<!DOCTYPE html>
<!-- This jsp Created against ML-MMOH-CRF-0684-->
<%@page import="eDS.Common.DlQuery"%>
<%@  page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" %>
<%@  page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String language_Id  = (String)session.getAttribute("LOCALE");
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eDS/js/MenuType.js'></script>
<script language='javascript' src='../../eDS/js/DSCommon.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<fmt:setBundle basename="eDS.resources.Labels" var="ds_labels"/>
</head>
<body onload="parent.commontoolbarFrame.document.forms[0].apply.disabled=false;" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<% 
	String menuType = "";
	String shortDesc = "";
	String longDesc = "";
	String enabledYn = "";
	String menuTypeCode = request.getParameter("menuType");
	String disabled_flag = "";
	String readOnlyFlag = "";
	String ipmenutype_yn = "";
	String opmenutype_yn = "";
	String emmenutype_yn = "";
	String applstafforder_yn = "";
	String default_menu = "";
	String check_exist="";
	String disabled="";

	Connection con = null;
	ResultSet rst = null;
	PreparedStatement pstmt = null;

	String mode = request.getParameter("mode");
	
	try{
   
			con = ConnectionManager.getConnection(request);
			String str_query = "select DEFAULT_YN from DS_MENU_TYPE where eff_status = 'E' and  DEFAULT_YN = 'Y' and ROWNUM = 1";
			pstmt = con.prepareStatement(str_query);
	   		rst = pstmt.executeQuery();
	   		while(rst.next()){
			check_exist = rst.getString("DEFAULT_YN");
			}
			if(check_exist.equals("") || check_exist==null)
			check_exist="N";
			}
		catch(Exception e){
	   		System.err.println("Error in Meal Class insert mode------>"+e);
			e.printStackTrace();
   		}finally{
   			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(con);
			}
			catch(Exception e){
				System.err.println("Exception in Meal Class insert mode:========="+e);
				e.printStackTrace();
			}
   		}	
	
   if("modify".equals(mode)){
   		try{
		
			con = ConnectionManager.getConnection(request);
	
   			disabled_flag = "disabled";
   			readOnlyFlag = "readonly";
	   		
	   		pstmt = con.prepareStatement(DlQuery.DL_GET_MENU_TYPE);
	   		pstmt.setString(1,menuTypeCode);
	   		rst = pstmt.executeQuery();
	   		while(rst.next()){
	   			menuType = rst.getString("menu_type");
	   			longDesc = rst.getString("long_desc");
	   			shortDesc = rst.getString("short_desc");
	   			enabledYn = rst.getString("eff_status");				
				default_menu = rst.getString("DEFAULT_YN"); 				
				ipmenutype_yn = rst.getString("APPL_FOR_IP_YN"); 			
				opmenutype_yn = rst.getString("APPL_FOR_OP_YN"); 			
				emmenutype_yn = rst.getString("APPL_FOR_EM_YN"); 			
				applstafforder_yn = rst.getString("APPL_FOR_STAFF_YN"); 		
				
	   		}
   		}
   		catch(Exception e){
	   		System.err.println("Error in Meal Class->"+e);
			e.printStackTrace();
   		}
   		finally{
   			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(con);
			}
			catch(Exception e){
				System.err.println("Exception in Meal Class:"+e);
				e.printStackTrace();
			}
   		}
   }

%>
	<br>
		<form name="menuType_form" id="menuType_form"  onload='FocusFirstElement()'  action="../../servlet/eDS.MenuTypeServlet" method="post" target="messageFrame">
			<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
				<!-- MenuType -->
				<tr>
					<td class='label'>
						<fmt:message key="eDS.MenuType.Label" bundle="${ds_labels}"/>
					</td>
					<td>
						<input type="text" name="menuType" id="menuType" value="<%=menuType%>" onkeypress="restrictSpecialChars(event)" size="10" maxlength="10" onkeyup="setFieldToUpperCase(this)"  onkeypress="return checkAlpha(event)" <%=disabled_flag %>/>
						<%
						    						
						%>
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>

				<!-- LongDescription -->
				<tr>
					<td class='label'>
						<fmt:message key="eOT.LongDescription.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<input type="text" name="longDesc" id="longDesc" value="<%=longDesc %>"  onkeypress="restrictSpecialChars(event)" size="30" maxlength="30" />
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>

				<!-- ShortDescription -->
				<tr>
					<td  class='label'>
						<fmt:message key="eOT.ShortDescription.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<input type="text" name="shortDesc" id="shortDesc" value="<%=shortDesc %>" onkeypress="restrictSpecialChars(event)" size="15" maxlength="15" />
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>

				<!-- DefaultMenuType -->
				<tr>
					<td  class='label'>
						<fmt:message key="eDS.DefaultMenuType.Label" bundle="${ds_labels}"/>
					</td>
					<td>
					<%if("modify".equals(mode)){
						if("Y".equals(default_menu)){
							disabled="disabled";
						%>
						<input type="checkbox" name="default_menu" id="default_menu" checked="checked" />
						<%}
					else{ 
						 if(check_exist.equals("Y"))
						{
						 disabled="disabled";
						%>
						 <input type="checkbox" name="default_menu" id="default_menu" disabled=<%=disabled%>/>
						<%}
						else{
							disabled="";

					  %>
					  <input type="checkbox" name="default_menu" id="default_menu" />
						<%}
					  %>

					 <% } }
					  else{
						if(check_exist.equals("Y"))
						{
						 disabled="disabled";
						%>
						 <input type="checkbox" name="default_menu" id="default_menu" disabled=<%=disabled%>/>
						<%}
						else{
							disabled="";
					  %>
					  <input type="checkbox" name="default_menu" id="default_menu" />
						<%}
					  %>				
					  <%}%>
					  
					</td>
				</tr>

				<!-- ApplForInpatient -->
				<tr>
					<td  class='label'>
						<fmt:message key="eDS.ApplForInpatient.Label" bundle="${ds_labels}"/>
					</td>
					<td>
						<%if("modify".equals(mode)){
							if("Y".equals(ipmenutype_yn)){ %>
								<input type="checkbox" name="ipmenutype_yn" id="ipmenutype_yn"  checked="checked"/>
							<%}
							else{%>
								<input type="checkbox" name="ipmenutype_yn" id="ipmenutype_yn"/>
							<%}
						}
						else{ %>
							<input type="checkbox" name="ipmenutype_yn" id="ipmenutype_yn" checked="checked" />
						<%} %>
					</td>
				</tr>				
								
				<!-- ApplForOutpatient -->
				<tr>
					<td  class='label'>
						<fmt:message key="eDS.ApplForOutpatient.Label" bundle="${ds_labels}"/>
					</td>
					<td>
						<%if("modify".equals(mode)){
							if("Y".equals(opmenutype_yn)){ %>
								<input type="checkbox" name="opmenutype_yn" id="opmenutype_yn"  checked="checked"/>
							<%}
							else{%>
								<input type="checkbox" name="opmenutype_yn" id="opmenutype_yn"/>
							<%}
						}
						else{ %>
							<input type="checkbox" name="opmenutype_yn" id="opmenutype_yn" checked="checked" />
						<%} %>
					</td>
				</tr>

				<!-- ApplForEmergencyPatient -->
				<tr>
					<td  class='label'>
						<fmt:message key="eDS.ApplForEmergencyPatient.Label" bundle="${ds_labels}"/>
					</td>
					<td>
						<%if("modify".equals(mode)){
							if("Y".equals(emmenutype_yn)){ %>
								<input type="checkbox" name="emmenutype_yn" id="emmenutype_yn"  checked="checked"/>
							<%}
							else{%>
								<input type="checkbox" name="emmenutype_yn" id="emmenutype_yn"/>
							<%}
						}
						else{ %>
							<input type="checkbox" name="emmenutype_yn" id="emmenutype_yn" checked="checked" />
						<%} %>
					</td>
				</tr>

				<!-- ApplForStaffOrder -->
				<tr>
					<td  class='label'>
						<fmt:message key="eDS.ApplForStaffOrder.Label" bundle="${ds_labels}"/>
					</td>
					<td>
						<%if("modify".equals(mode)){
							if("Y".equals(applstafforder_yn)){ %>
								<input type="checkbox" name="applstafforder_yn" id="applstafforder_yn"  checked="checked"/>
							<%}
							else{%>
								<input type="checkbox" name="applstafforder_yn" id="applstafforder_yn"/>
							<%}
						}
						else{ %>
							<input type="checkbox" name="applstafforder_yn" id="applstafforder_yn" checked="checked" />
						<%} %>
					</td>
				</tr>

				<!-- Enabled Yes or No -->
				<tr>
					<td class='label'>
						<fmt:message key="eOT.Enabled.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<%if("modify".equals(mode)){
							if("E".equals(enabledYn)){
							%>
								<input type="checkbox" name="enabledYn" id="enabledYn"  checked="checked"/>
							<%}
							else{
							%>
								<input type="checkbox" name="enabledYn" id="enabledYn"/>
							<%}
						}
						else{ %>
							<input type="checkbox" name="enabledYn" id="enabledYn"  checked="checked"/>
						<%} %>
					</td>
				</tr>
				<tr>
			</tr>
			</table>
			<input type='hidden' name='locale' id='locale' value="<%=locale%>">
			<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
			<input type='hidden' name='updMenuType' id='updMenuType' value='<%=menuType%>'>
		</form>
	</body>
</html>

