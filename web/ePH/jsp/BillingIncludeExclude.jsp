<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<title><fmt:message key="ePH.Include/ExcludeDetail.label" bundle="${ph_labels}"/> </title>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="JavaScript" src="../../ePH/js/DirectDispensing.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	</head>
	<body onMouseDown="" onKeyDown="lockKey()">
<%
        String	bean_id								= "RegPrescriptionsBean" ;
	    String	bean_name							= "ePH.RegPrescriptionsBean";	
	    RegPrescriptionsBean bean					= (RegPrescriptionsBean)getBeanObject( bean_id,bean_name,request) ;
        String order_id								= request.getParameter("order_id")==null?"":request.getParameter("order_id");
		String order_line_no						= request.getParameter("order_line_no")==null?"":request.getParameter("order_line_no");
		String bl_incl_excl_override_reason_code	= "";
		String bl_incl_excl_override_reason_desc    = "";
		String excl_incl_ind                        = "";
		String override_allowed_str					= "";
		String bl_override_excl_incl_ind_chk		= "";	
		String inc_exec_legend						= "";
		String def_inc_exec_gif						= "";
		//String sSource								= request.getParameter("fromDisp")==null?"":request.getParameter("fromDisp");
		String override_allowed_yn					= request.getParameter("override_allowed_yn") ;
		String approval_reqd_yn						= request.getParameter("approval_reqd_yn") ;
		String recnum								= request.getParameter("recnum");
		String excl_incl_ind_default				= request.getParameter("excl_incl_ind_default")==null?"E":request.getParameter("excl_incl_ind_default");
		//excl_incl_ind_default ="B";
	    if(!order_id.equals("")){
			HashMap Billing_det				=(HashMap)bean.getBillingDetails(locale,order_id.trim(),order_line_no.trim());
			if(Billing_det.size()>0){
				 bl_incl_excl_override_reason_code	=(String)Billing_det.get("PRES_BL_INCL_EXCL_OVERRIDE_REASON_CODE");
				 bl_incl_excl_override_reason_desc  =(String)Billing_det.get("PRES_BL_INCL_EXCL_OVERRIDE_REASON_DESC");
				 excl_incl_ind                      =(String)Billing_det.get("PRES_BL_INCL_EXCL_OVERRIDE_VALUE");
			}
			 override_allowed_str				="disabled"	;
		}
		else{
             excl_incl_ind						= request.getParameter("excl_incl_ind_default")==null?"":request.getParameter("excl_incl_ind_default") ;
			 bl_incl_excl_override_reason_desc	= request.getParameter("bl_incl_excl_override_reason_desc")==null?"":request.getParameter("bl_incl_excl_override_reason_desc") ;
			 bl_incl_excl_override_reason_code	= request.getParameter("bl_incl_excl_override_reason_code")==null?"":request.getParameter("bl_incl_excl_override_reason_code") ;
			 if(override_allowed_yn.equals("")){
				override_allowed_str			="disabled"	;
			}
		}
		String include_selected ="";
		String exclude_selected ="";
		boolean nothing_selected=false;
	    if(!bl_incl_excl_override_reason_desc.equals("")){
			if(excl_incl_ind.equals("I")){
				include_selected ="selected";
			}
			else if(excl_incl_ind.equals("E")){
				exclude_selected ="selected";
			}
			else{
				nothing_selected=true;
			}
		}
		else{
			nothing_selected=true;
		}
		
		String approval_reqd_yn_str					="<img src='../../eCommon/images/disabled.gif'></img>";		
		String excl_incl_ind_style					="visibility:hidden";	
		

		if(approval_reqd_yn.equals("Y")) {
			approval_reqd_yn_str = "<img src='../../eCommon/images/enabled.gif'></img>";
		}
        if(excl_incl_ind.equals("I")){
			bl_override_excl_incl_ind_chk ="checked";
		}		

		if(!excl_incl_ind.equals(excl_incl_ind_default)){
				excl_incl_ind_style="";
		}
		if(excl_incl_ind_default.equals("I")){
           inc_exec_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Exclude.label","common_labels");
		   def_inc_exec_gif="<img src='../../eCommon/images/enabled.gif'></img>";
		}else if(excl_incl_ind_default.equals("E")){
           inc_exec_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Include.label","common_labels");
		   def_inc_exec_gif= "<img src='../../eCommon/images/disabled.gif'></img>";
		}
%>
		<form name="BlincludeexcludeForm" id="BlincludeexcludeForm" >
			<table cellpadding="0" cellspacing="0" width="100%"  border='1'>	
				<tr id='BL_HEADER' >
				    <td class='COLUMNHEADER' width='9%'><fmt:message key="Common.Included.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADER' width='10%'><fmt:message key="ePH.OverrideIncl/Excl.label" bundle="${ph_labels}"/></td>
					<td class='COLUMNHEADER' width='45%'><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADER' width='15%'><fmt:message key="ePH.ApprovalReqd.label" bundle="${ph_labels}"/></td>
				</tr>
				<tr id='BL_VALUES' >
					 <td align='center'id='bl_def_inv_exec_val'><%=def_inc_exec_gif%></td> 
					<td class="label">
					<%if(!excl_incl_ind_default.equals("")){%>
					   <!-- <input type='checkbox' name='bl_override_excl_incl_ind' id='bl_override_excl_incl_ind' value='<%=excl_incl_ind%>' onclick='assignOverrideExclInclInd(this)'<%=bl_override_excl_incl_ind_chk%> <%=override_allowed_str%> > -->
					    <select name="bl_override_excl_incl_ind" id="bl_override_excl_incl_ind" onchange="assignOverrideExclInclInd(this)"  <%=override_allowed_str%>>
						   <option value="SEL">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
							<%if(override_allowed_yn.equals("I"))%>
								<option value="I" <%=include_selected%>><fmt:message key="Common.Include.label" bundle="${common_labels}"/></option>
							<%if(override_allowed_yn.equals("E"))%>
								<option value="E" <%=exclude_selected%> ><fmt:message key="Common.Exclude.label" bundle="${common_labels}"/></option>
							<%if(override_allowed_yn.equals("B")){%>
							    <option value="I" <%=include_selected%> ><fmt:message key="Common.Include.label" bundle="${common_labels}"/></option>
							    <option value="E" <%=exclude_selected%> ><fmt:message key="Common.Exclude.label" bundle="${common_labels}"/></option>
							 <%}%>
								
						</select>
					
					<%}else{%>
                        <!--   <%=def_inc_exec_gif%> -->
                          <input type='hidden' name='bl_override_excl_incl_ind' id='bl_override_excl_incl_ind' value='<%=excl_incl_ind%>'>
                    <%}
						  if(nothing_selected)
								override_allowed_str="disabled";
						  %>
					<input type='hidden' name='bl_def_override_excl_incl_ind' id='bl_def_override_excl_incl_ind' value='<%=excl_incl_ind_default%>'>
					</td>
					<td class="label" nowrap>
						<input type='text' name='bl_incl_excl_override_reason_desc' id='bl_incl_excl_override_reason_desc' size='45'  value='<%=bl_incl_excl_override_reason_desc%>'  readonly><input type="button" name="bl_overriden_action_reason_lkp" id="bl_overriden_action_reason_lkp" value="?" class="button" onClick="searchBLOverrideReason('<%=locale%>');"  <%=override_allowed_str%>><img  src="../../eCommon/images/mandatory.gif" id='bl_overriden_action_reason_img' name='bl_overriden_action_reason_img' style='<%=excl_incl_ind_style%>'></img>
						<input type='hidden' name='bl_incl_excl_override_reason_code' id='bl_incl_excl_override_reason_code' value='<%=bl_incl_excl_override_reason_code%>'>
					</td>		
					<td align='center'id='bl_approval_reqd_yn'><%=approval_reqd_yn_str%></td>
				</tr>
				<tr>
					<td colspan='4' align='right'><input type="button" class="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onclick='savedetails()'></td>
				</tr>
				<INPUT TYPE="hidden" name="sql_ph_prescription_bl_action_select_lookup" id="sql_ph_prescription_bl_action_select_lookup" VALUE="<%= PhRepository.getPhKeyValue( "SQL_PH_PRESCRIPTION_BL_ACTION_SELECT_LOOKUP") %>">
				<input type='hidden' name='recnum' id='recnum' value='<%=recnum%>'>
				<input type='hidden' name='override_allowed_yn' id='override_allowed_yn' value='<%=override_allowed_yn%>'>
			</table>
		</form>
	</body>
</html>

