<!DOCTYPE html>
<%@page import="java.sql.*, java.io.*, webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
<%
  request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
  String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="JavaScript" src ="../../eCA/js/SpecialtyEvent.js"></script>
		<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/ValidateControl.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		</head>
	<body OnMouseDown="CodeArrest()"  onKeyDown="lockKey()">
	<form name="specialityeventaddmodifyForm" id="specialityeventaddmodifyForm"  method ='post' target='messageFrame' action='../../servlet/eCA.SpecialtyEventServlet'>
	<BR><BR>
<%
	  
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	ResultSet rsmodify = null;
	String mode = request.getParameter("mode") == null ? "insert" : request.getParameter("mode");
	String sql = "";
	String sqlmodify = "";
	try
	{   
			con = ConnectionManager.getConnection(request);
			String moduleId = "";
			String code_vlue = "";
			String description_val = "";
			String agegroupDes = "";
			String agegroupCode = "";
			String agegrpCode = "";
			String orderSequenceNo = "";
			String defType = "";
			String autoClsPeriod = "";
			String autoClsPeriodType = "";
			String autoClsType = "";
			String eff_status = "";
			String disabled="";
			String disabledOtherThree="";
			String check="";
			if(mode.equals("insert"))
		   {
			defType=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.UserDefined.label","common_labels");
			check="checked";
		   }

		if(mode.equals("modify"))
		{	
				disabled="disabled";
				try
				{
				code_vlue =  request.getParameter("code_vlue") == null ? "" : request.getParameter("code_vlue");
				code_vlue=code_vlue.trim();
				sqlmodify = "select MODULE_ID, SPLTY_EVENT_DESC, AGE_GROUP_CODE, ORDER_SEQ_NO, SYS_IND, AUTO_CLOSE_PERIOD, AUTO_CLOSE_PERIOD_TYPE, AUTO_CLOSE_TYPE, EFF_STATUS  from ca_splty_event where SPLTY_EVENT_CODE = ?";
				ps = con.prepareStatement(sqlmodify);
				 ps.setString(1,code_vlue);
				 rsmodify = ps.executeQuery();
				 while(rsmodify.next())
				 {
				    moduleId = rsmodify.getString("MODULE_ID")==null?"":rsmodify.getString("MODULE_ID");
					description_val = rsmodify.getString("SPLTY_EVENT_DESC")==null?"":rsmodify.getString("SPLTY_EVENT_DESC");
					agegrpCode = rsmodify.getString("AGE_GROUP_CODE")==null?"":rsmodify.getString("AGE_GROUP_CODE");
					orderSequenceNo = rsmodify.getString("ORDER_SEQ_NO")==null?"":rsmodify.getString("ORDER_SEQ_NO");
					defType = rsmodify.getString("SYS_IND")==null?"":rsmodify.getString("SYS_IND");
					if(defType.equals("U"))
					 defType=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.UserDefined.label","common_labels");
					else
					defType=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SystemDefined.label","common_labels");
					autoClsPeriod = rsmodify.getString("AUTO_CLOSE_PERIOD")==null?"":rsmodify.getString("AUTO_CLOSE_PERIOD");
				    autoClsPeriodType = rsmodify.getString("AUTO_CLOSE_PERIOD_TYPE")==null?"":rsmodify.getString("AUTO_CLOSE_PERIOD_TYPE");
					autoClsType = rsmodify.getString("AUTO_CLOSE_TYPE")==null?"":rsmodify.getString("AUTO_CLOSE_TYPE");
					eff_status=	  rsmodify.getString("EFF_STATUS")==null?"":rsmodify.getString("EFF_STATUS");

				}
				if(rsmodify != null) rsmodify.close();
		        if(ps != null) ps.close();

				if(eff_status.equals("D")) disabledOtherThree = "disabled";
				else disabledOtherThree = "";
			}
			catch(Exception e)
			{
				
				e.printStackTrace();
			}
			
			out.println("<input type ='hidden' name='agegroupCode' id='agegroupCode' value='"+agegrpCode+"' >");
			try{
			 
		     sql = "Select   SHORT_DESC  from  AM_AGE_GROUP where AGE_GROUP_CODE=?";
		     ps = con.prepareStatement(sql);
			 ps.setString(1,agegrpCode);
		     rs = ps.executeQuery();
			 if(rs.next())
			 agegroupDes=rs.getString("SHORT_DESC");
			 if(rs != null) rs.close();
		     if(ps != null) ps.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
			}
		}
		
		sql = "select MODULE_ID,MODULE_NAME   from SM_module where MODULE_GROUP_ID='SS' order by 2";
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
%>
<table border='0' cellspacing='0' cellpadding='3' width='100%' align='center'>
		
		<tr>
			<td class ='label' ><fmt:message key="Common.Module.label" bundle="${common_labels}"/></td>
			<td class ='fields' >
			<select name ="module"  maxlength='2' <%=disabled%>><option  value="">----------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
				
<%
		while(rs.next())
		{

			if (moduleId.trim().equals(rs.getString(1).trim()))
				{
					out.println("<option value='"+rs.getString(1)+"' selected>"+rs.getString(2)+"</option>");		
				}
				else
				{
					out.println("<option value='"+rs.getString(1)+"'>"+rs.getString(2)+"</option>");	
				}
		}
		if(rs != null) rs.close();
		if(ps != null) ps.close();
%>			</select><img src="../../eCommon/images/mandatory.gif" align="center" >
			</td>
		</tr>

	<tr><td class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		   <td class='fields'><input type="text" name="code" id="code" value="<%=code_vlue%>"  maxlength='6'  size='7' <%=disabled%>><img src="../../eCommon/images/mandatory.gif" align="center" ></td>
	 </tr>
	<tr><td class='label'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
		   <td class='fields'><input type="text" name="description" id="description" value="<%=description_val%>"  maxlength='60'  size="40" <%=disabledOtherThree%>><img src="../../eCommon/images/mandatory.gif" align="center" ></td>
	 </tr>
	<tr><td class='label' ><fmt:message key="Common.agegroup.label" bundle="${common_labels}"/></td>
			<td class='fields'>
				<input type ='text' name='agegroupDes' id='agegroupDes' size='20'   value="<%=agegroupDes%>" onBlur="getageGroup1(this,agegroupDes)" <%=disabledOtherThree%>><input type ='Button' class='button' name='buttonAgeGrp' id='buttonAgeGrp' value='?' Onclick='getageGroup()' <%=disabledOtherThree%>><img src="../../eCommon/images/mandatory.gif" align="center" ></td></tr>
	<tr><td class='label'><fmt:message key="eCA.OrderSequence.label" bundle="${ca_labels}"/></td>
		   <td class='fields'><input type="text" name="orderSequence" id="orderSequence" value="<%=orderSequenceNo%>"  maxlength='3'  size='5' onKeyPress='return numOnly(this)' onBlur="checkPositiveNumber(this);" <%=disabledOtherThree%>><img src="../../eCommon/images/mandatory.gif" align="center" ></td>
	 </tr>
	<tr><td class='label'><fmt:message key="Common.DefinitionType.label" bundle="${common_labels}"/></td>
		   <td class='fields'><input type="text" name="definitionType" id="definitionType" value="<%=defType%>" <%=disabled%> ><input type=hidden name='def_type_value' id='def_type_value' 		value='U' size='1' maxlength='2'></td>
	 </tr>
	<!--<tr>	<td class ='label' ><fmt:message key="eCA.AutoClosePeriod.label" bundle="${ca_labels}"/></td>
			<td class ='fields' ><input type="text" name="autoClosePeriod" id="autoClosePeriod" value="<%=autoClsPeriod%>"  maxlength='2'  size='4' onKeyPress='return numOnly(this)'>
			<select name ="autoClosePeriodType">
				<option  value=""> -----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
				   <%if(autoClsPeriodType.equals("D")) {%>
						<option  value="D"  selected> <fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
                <%}else{%>
			      <option  value="D"> <fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
		       <%} %> 
			
			 <%if(autoClsPeriodType.equals("W")) {%>
						<option  value="W"  selected> <fmt:message key="Common.weeks.label" bundle="${common_labels}"/></option>
                <%}else{%>
			      <option  value="W"><fmt:message key="Common.weeks.label" bundle="${common_labels}"/></option>
		       <%} %> 

				 <%if(autoClsPeriodType.equals("M")) {%>
						<option  value="M"  selected> <fmt:message key="Common.months.label" bundle="${common_labels}"/></option>
                <%}else{%>
			      <option  value="M"> <fmt:message key="Common.months.label" bundle="${common_labels}"/></option>
		       <%} %> 

				 <%if(autoClsPeriodType.equals("Y")) {%>
						<option  value="Y"  selected> <fmt:message key="Common.Years.label" bundle="${common_labels}"/></option>
                <%}else{%>
			      <option  value="Y"><fmt:message key="Common.Years.label" bundle="${common_labels}"/></option>
		       <%} %> 
			</select>
			</td>
		</tr>
<tr>
	<td class ='label' ><fmt:message key="eCA.AutoCloseType.label" bundle="${ca_labels}"/></td>
			<td class ='fields' >
			<select name ="autoCloseType"  <%=disabled%>>
			  <option  value="">----------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
			
		<%if(autoClsType.equals("A")) {%>
						<option  value="A"  selected> <fmt:message key="eCA.Alert.label" bundle="${ca_labels}"/></option>
         <%}else{%>
			<option  value="A"> <fmt:message key="eCA.Alert.label" bundle="${ca_labels}"/></option>
		 <%} %> 
			
		<%if(autoClsType.equals("F")) {%>
						<option  value="F"  selected><fmt:message key="eCA.ForceClose.label" bundle="${ca_labels}"/></option>

         <%}else{%>
			<option  value="F"> <fmt:message key="eCA.ForceClose.label" bundle="${ca_labels}"/></option>
		 <%} %> 

			  </select>
			</td>
</tr>-->
	<tr><td class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		   <td class='fields'><input type="checkbox" name="enabled" id="enabled" value=""  <%=check%> <%if(mode.equals("modify") && eff_status.trim().equals("E"))out.println("checked");%> ></td>
	 </tr>
</table>
				 <!-- <input type ='hidden' name='agegroupCode' id='agegroupCode' value='<%=agegroupCode%>'>-->
				  <input type ='hidden' name='mode' id='mode' value='<%=mode%>'>	
				  <input type ='hidden' name='moduleId' id='moduleId' value='<%=moduleId%>'>
				 <input type ='hidden' name='code_vlue' id='code_vlue' value='<%=code_vlue%>'>	
				 <input type ='hidden' name='description_val' id='description_val' value='<%=description_val%>'>
				 <input type ='hidden' name='agegrpCode' id='agegrpCode' value='<%=agegrpCode%>'>	
				 <input type ='hidden' name='defType' id='defType' value='<%=defType%>'>
				  <input type ='hidden' name='autoClsPeriod' id='autoClsPeriod' value='<%=autoClsPeriod%>'>	
				  <input type ='hidden' name='autoClsPeriodType' id='autoClsPeriodType' value='<%=autoClsPeriodType%>'>	
				 <input type ='hidden' name='autoClsType' id='autoClsType' value='<%=autoClsType%>'>
				

</form>
<%
	}
	catch(Exception ee)
	{
		//out.println("Exception in SpecialtyEventAddModifyIntermediate Module "+ee.toString());//COMMON-ICN-0181
		ee.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		try{
				if(con != null) 
			  {	
				ConnectionManager.returnConnection(con);
				con.close();
			  }
			}
		catch(Exception e){
			out.println(e);//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
	}

%>
	</body>
</html>

