
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page	import="java.util.*, eOR.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

	<%-- jsp:useBean id="mh" scope="session" class="CommonMultipleHandler" --%>
<%-- To call the Common MultipleHandler where the id will be as mh--%>
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
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>

	<script language="JavaScript" src="../js/OrderType.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



	<script>
	 function lockKey()
	  {
		 	 
		if(event.keyCode == 93)
			alert("Welcome to eHIS");
	  }

	  function lockBackSpace()
	  {
		// alert(document.order_type_form.mode.value);
		   var mode = document.order_type_form.mode.value;
        // alert(window.event.keyCode);
		 if(mode==2 && window.event.keyCode==8)
		  {
             //return false;
		  }
	  }
	  
	</script>
  </head>

  <body onload="FocusFirstElement()" onMouseDown="CodeArrest()"  
  onKeyDown="lockKey();return lockBackSpace();" >
  <%
	/* Mandatory checks start */
	
	String mode         = request.getParameter( "mode" ) ;
	String facility_id = (String)session.getValue("facility_id");

//	String function_id  = request.getParameter( "function_id" ) ;

	String bean_id      = "Or_order_type" ;
	String bean_name    = "eOR.OrderType";
	String readOnly     = "" ;
	//String disabled     = "" ;
	String checked		= "";
	String checked_reqd	= "";
	String checked_freq	= "";
	String checked_soft = "";
	String checked_cont = "";
	String codeReadOnly = "";
	String reg_reqd_disabled			= "";
	String order_category_disabled		= "";
	String freq_update_disabled			= "";
	String soft_stop_update_disabled	= "";
	String cont_update_disabled			= "";

	String soft_stop_update_allow_yn	= "";
	String cont_order_update_allow_yn	= "";
	String soft_stop_applicable_yn		= "";
	String cont_order_applicable_yn		= "";
	String style_auto					= "display:none";
	//String auto_report					= "";
	if ( mode == null || mode.equals("") )
		return ;
	
	/* Mandatory checks end */
	/* Initialize Function specific start */
	OrderType bean = (OrderType)getBeanObject( bean_id,  bean_name, request ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clear() ;
	bean.setLanguageId(localeName);
	bean.setMode( mode ) ;
	/* Initialize Function specific end */
	if ( mode.equals(  CommonRepository.getCommonKeyValue("MODE_MODIFY") ) )
		{
		   String order_type_code			=   request.getParameter( "order_type_code" ) ;
		   bean.setOrderTypeCode(order_type_code.trim()) ;
		   bean.loadData() ;

//		   out.println("NNNNNNNNNNNNN");

	/*	   if(bean.getApptReqValue().trim().equals("Y"))
			{
   		       reg_reqd_disabled            = "disabled";
			}                                                */
		
     	   if(bean.getRegnReqdYn().trim().equals("Y"))
			   checked_reqd					= "checked";    

		   if(bean.getFreqApplicableYn().trim().equals("Y"))
			   checked_freq					= "checked";
		   if(bean.getSoftStopYnYn().trim().equals("Y"))
			   checked_soft					= "checked";
		   if(bean.getContOrderYn().trim().equals("Y"))
			   checked_cont					= "checked";
		   if(!bean.getEffStatus().trim().equals("E"))
			{
			   readOnly						= "readOnly" ;
			   //disabled						= "disabled" ;
			}
           else
			{
			   checked						= "checked";
        	   if(bean.getOrderCategoryCode().equals("PH") || bean.getOrderCategoryCode().equals("MR") || bean.getOrderCategoryCode().equals("CS"))
			 {
					reg_reqd_disabled		= "disabled";
			 }
			  else if(bean.getOrderCategoryCode().equals("OT")||bean.getOrderCategoryCode().equals("RD"))
			  {
				   String ins_yn = bean.getInstallYN(bean.getOrderCategoryCode());
    			   if(ins_yn.equals("Y"))
					{
						reg_reqd_disabled		= "disabled";
					}
			  }
			  else if(bean.getOrderCategoryCode().equals("LB"))
			  {
				   String moduleRL =bean.checkForNull(bean.getmoduleRL("",bean.getOrderCategoryCode(),bean.getOrderTypeCode(),facility_id),"");
    			   if(moduleRL.equalsIgnoreCase("IBARL"))
					{
						reg_reqd_disabled		= "disabled";
					}
			  }

	   		   if(!bean.getFreqUpdateAllowYn().trim().equals("Y"))
			    freq_update_disabled		= "disabled";
   	   		   if(!bean.getSoftStopUpdateAllowYn().trim().equals("Y"))
			    soft_stop_update_disabled	= "disabled";
	   		   if(!bean.getContOrderUpdateAllowYn().trim().equals("Y"))
			    cont_update_disabled		= "disabled";
				
			   soft_stop_update_allow_yn	= bean.getSoftStopUpdateAllowYn();
			   cont_order_update_allow_yn	= bean.getContOrderUpdateAllowYn();

			   soft_stop_applicable_yn		= bean.getSoftStopInsertApplicableYn();
			   cont_order_applicable_yn		= bean.getContOrderInsertApplicableYn();
            }
			   order_category_disabled  = "disabled";
			   codeReadOnly				= "readOnly";
			   //auto_report				= bean.getAutoReport() == null?"":bean.getAutoReport();
			   if(bean.getOrderCategoryCode().equals("RD") || bean.getOrderCategoryCode().equals("PC") || bean.getOrderCategoryCode().equals("RX") || bean.getOrderCategoryCode().equals("DS")){
					style_auto				= "display:inline";
			   }
		
		}
		else
		{			
		  checked						= "checked";
		}
	
 %>
   <form name="order_type_form" id="order_type_form" method="post" action="../../servlet/eOR.OrControllerServlet?set_common=Y"	target="messageFrame">
	   <table cellpadding=3 cellspacing=0 width="100%" align="center" border=0>
		<tr>
			<td class="label" width='33%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td class='fields'>
				<input type="text" name="order_type_code" id="order_type_code" value="<%=bean.getOrderTypeCode()%>" size="4" maxlength="4" onBlur="ChangeUpperCase( this );"  <%=codeReadOnly%>  onKeyPress="return CheckForSpecChars(event);" ><img src="../../eCommon/images/mandatory.gif" align=center></img>
			</td>
		<td class="label" colspan='3'></td>
		</tr>
		<tr>
			<td class="label" width='33%'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
			<td class='fields'>
			   <input type="text" name="long_desc" id="long_desc" value="<%=bean.getLongDesc()%>"  size="30" maxLength="30" onBlur="makeValidString(this);" <%=readOnly%>><img src="../../eCommon/images/mandatory.gif" align=center></img>
			</td>
			<td class="label" colspan='3'></td>
		</tr>
		<tr>
			<td class="label" width='33%'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
			<td class='fields'>
			   <input type="text" name="short_desc" id="short_desc" value="<%=bean.getShortDesc()%>"  size="15" maxLength="15" onBlur="makeValidString(this);" <%=readOnly%>><img src="../../eCommon/images/mandatory.gif" align=center></img>
			</td>
			<td class="label" colspan='3'></td>
		</tr>
		<tr>
			<td class="label" width='33%'><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
			<td class='fields' ><select name="order_category_code" id="order_category_code" onChange="getOrderCategory(this);getInstallValue(this)" <%=order_category_disabled%> >
			<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
			<%
			
			  ArrayList Order_Category = bean.getOrderCategory();
			  String[] record=null;
			  for(int i=0; i<Order_Category.size(); i++)
			  {
			    record = (String[])Order_Category.get(i);
				if(record[0].equalsIgnoreCase(bean.getOrderCategoryCode()))
					out.println("<option value = '"+record[0]+"::"+record[4]+"::"+record[5]+"::"+record[6]+"::"+record[7]+"::"+record[8]+"::"+record[9]+"' selected> "+record[1]+" ");	 
				else
					out.println("<option value = '"+record[0]+"::"+record[4]+"::"+record[5]+"::"+record[6]+"::"+record[7]+"::"+record[8]+"::"+record[9]+"'> "+record[1]+" ");	 
			  }
			  Order_Category= null;
			%>
			</select>
			<input type='hidden' name='order_category' id='order_category' value='<%=bean.getOrderCategoryCode()%>'>
	 		<img src="../../eCommon/images/mandatory.gif"></img></td>
			<td class="label" colspan='3'></td>
		 </tr>
		  <tr>
			<td class="label" width='33%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			
			<td class='fields'><input type='checkbox' name='eff_status_yn' id='eff_status_yn' value='<%=bean.getEffStatus()%>' <%=checked%> onClick='change(this);'>
			</td>
			
			<td class="label" colspan='3'></td>
		 </tr>
		 <tr>
			<td class='columnheader' colspan='5'> <fmt:message key="eOR.AutoRegistration.label" bundle="${or_labels}"/></td>
		 </tr>
		 <tr>
			<td  class="label"><fmt:message key="Common.required.label" bundle="${common_labels}"/></td>
			<% if (( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) && (bean.getEffStatus().equalsIgnoreCase("D"))) {	

				%>
			<td class='fields'><input type='checkbox' name='regn_reqd' id='regn_reqd' value='N' <%=checked_reqd%> disabled>
			<input type='hidden' name = 'regn_reqd_yn' value='<%=bean.getRegnReqdYn()%>'></td>
            <% } else {	
    			
				%>
			<td class='fields'><input type='checkbox' name='regn_reqd_yn' id='regn_reqd_yn' value='<%=bean.getRegnReqdYn()%>' onClick='change(this);' <%=checked_reqd%>  <%=reg_reqd_disabled%>></td>
			<% } %>
			
			<td class="label" colspan='2'></td>
		 </tr>
		 <tr>
		  <td colspan='5' >
		    <table cellpadding=3 cellspacing=0 width="100%" align="center" id='timing_order' border=0 >
			<tr>
				<td class='columnheader'  colspan='5' ><fmt:message key="eOR.DefaultTiming.label" bundle="${or_labels}"/></td>
			</tr>
			<tr>
				<td class="label" width='33%'><fmt:message key="eOR.FrequencyApplicable.label" bundle="${or_labels}"/></td>
			<% if (( mode.equals(  CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) && (bean.getEffStatus().equalsIgnoreCase("D"))) { %>
				<td class='fields'><input type='checkbox' name='freq_applicable' id='freq_applicable' value='N'  <%=checked_freq%> disabled><input type='hidden' name = 'freq_applicable_yn' value='<%=bean.getFreqApplicableYn()%>'>
            <% } else { %>
				<td class="fields"><input type='checkbox' name='freq_applicable_yn' id='freq_applicable_yn' value='<%=bean.getFreqApplicableYn()%>' onClick='change(this);hideSoftStop(this);' <%=checked_freq%> <%=freq_update_disabled%>><% } %></td>
			
			<% if (( mode.equals(  CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) && (bean.getEffStatus().equalsIgnoreCase("D"))) { %>
				<td class="label" id='soft_stop' >
				<fmt:message key="eOR.SoftStopforInpatients.label" bundle="${or_labels}"/><input type='checkbox' name='soft_stop_val' id='soft_stop_val' value='N' <%=checked_soft%> disabled>  
				<input type='hidden' name = 'soft_stop_yn' value='<%=bean.getSoftStopYnYn()%>'></td>
            <% } else { %>
				<td  class="label" id='soft_stop' >
				<fmt:message key="eOR.SoftStopforInpatients.label" bundle="${or_labels}"/><input type='checkbox' name='soft_stop_yn' id='soft_stop_yn' value='<%=bean.getSoftStopYnYn()%>' onClick='change(this);' <%=checked_soft%> <%=soft_stop_update_disabled%>></td>  
            <% } %>
				<td class="label" ></td>	
				<td class="label" width='32%'></td>
			</tr>
			
			
			<tr id='default_order'>
				<td class='columnheader'  colspan='5' ><fmt:message key="eOR.DefaultOrderRepeats.label" bundle="${or_labels}"/></td>
			</tr>
			<tr id='continous_order'>
				<td class="label" width='33%'><fmt:message key="eOR.CreateasContinuingOrder.label" bundle="${or_labels}"/></td>
			<% if (( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) && (bean.getEffStatus().equalsIgnoreCase("D"))) { %>
				<td class="fields" ><input type='checkbox' name='cont_order' id='cont_order' value='N' <%=checked_cont%> disabled>
				 <input type='hidden' name = 'cont_order_yn' value='<%=bean.getContOrderYn()%>'></td>
			<% } else { %>
				<td class="fields" ><input type='checkbox' name='cont_order_yn' id='cont_order_yn' value='<%=bean.getContOrderYn()%>'	 onClick='change(this);' <%=checked_cont%> <%=cont_update_disabled%>></td>
			<% } %>
				<td class="label"></td>	
				<td class="label" colspan='2' ></td>
			</tr>	
			<!-- <tr>
				<td class="label" colspan='4'></td>
			</tr> -->
			
			
		    </table>
		  </td>	
		</tr>
		<tr id='default_auto' style="<%=style_auto%>">
				<td class='columnheader' colspan='5' ><fmt:message key="eOR.DefaultAutoReport.label" bundle="${or_labels}"/></td>
		</tr>
		<tr id='auto_report' style="<%=style_auto%>">
				<td  class="label" width='33%'><fmt:message key="Common.Text.label" bundle="${common_labels}"/></td>
				<% if (( mode.equals(  CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) && (bean.getEffStatus().equalsIgnoreCase("D"))) { %>
				<td class="fields">
				<textarea name="auto_report_text" rows="2" cols="25" maxlength="500" value="" disabled onBlur="SPCheckMaxLen('Default Auto Report',this,500);"><%=bean.getAutoReport()==null?"":bean.getAutoReport()%></textarea>
				
				 <% } else { %>	
				<td class="fields">
				<!-- <input type="text" name="auto_report_text" id="auto_report_text" size="" maxlength="500" value="<%=bean.getAutoReport()==null?"":bean.getAutoReport()%>" <%--=freq_update_disabled--%>> -->
				<textarea name="auto_report_text" rows="2" cols="25" maxlength="500" value="" onBlur="SPCheckMaxLen('Default Auto Report',this,500);" <%--=freq_update_disabled--%>><%=bean.getAutoReport()==null?"":bean.getAutoReport()%></textarea>
				 <% }  %>	
				</td>
				<td class="label" colspan='3'>
			</tr>
		</table>


	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
	<input type="hidden" name="soft_stop_applicable_yn" id="soft_stop_applicable_yn" value="<%=soft_stop_applicable_yn%>">
	<input type="hidden" name="soft_stop_update_yn" id="soft_stop_update_yn" value="<%=soft_stop_update_allow_yn%>">
	<input type="hidden" name="cont_order_applicable_yn" id="cont_order_applicable_yn" value="<%=cont_order_applicable_yn%>">
	<input type="hidden" name="cont_order_update_yn" id="cont_order_update_yn" value="<%=cont_order_update_allow_yn%>">
    <input type="hidden" name="frequency" id="frequency" value="">
	<input type="hidden" name="softStop" id="softStop"  value="">
	<input type="hidden" name="contOrder" id="contOrder" value="">
	</form>
  
 </body>
</html>	


<%
		putObjectInBean(bean_id,bean,request);
 
%>

