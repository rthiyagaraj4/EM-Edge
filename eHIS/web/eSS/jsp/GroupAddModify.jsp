<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
  
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
04/07/2021		TFS19249		 Shazana		ML-MMOH-CRF-1661-US001
---------------------------------------------------------------------------------------------------------------
*/ %>
<%-- Mandatory declarations start --%>
<%@ page  import=" eSS.GroupBean, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.sql.*,webbeans.eCommon.*,java.lang.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
 <%@include file="../../eCommon/jsp/CommonInclude.jsp"%>

<jsp:useBean id="alGroupList" scope="session" class="java.util.ArrayList" />

<%-- Mandatory declarations end --%>
<html>
	<head>
		<title> </title>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Manish Anand">
		<%
			String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			
			request.setCharacterEncoding("UTF-8");
            String locale			= (String)session.getAttribute("LOCALE");
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eSS/js/Group.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eST/js/StTransaction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<style type="text/css">
			SELECT{
				width:150px;
			}
		</style>

	</head>

	<body onload="FocusFirstElement();"  onSelect="codeArrestThruSelect()" onMouseDown="CodeArrest()">
<%
	String disabled			=	"";
	String disabled1			=	"";
	String SubClassdisabled	=	"disabled";
	String codeDisabled		=	"";
	String mode				=	"";
	String bean_id			=	"";
	String bean_name		=	"";
	String sterilizationDisabled=	"";
	String washingDisabled		=	"";
	String packingDisabled		=	"";
	String checked = "";

	/* Mandatory checks start */
	mode	= request.getParameter( "mode" ) ;
	bean_id = "groupBean" ;
	bean_name = "eSS.GroupBean";

	if ( mode == null || mode.equals("") ) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
	/* Mandatory checks end */
	
	/* Initialize Function specific start */
	GroupBean bean = (GroupBean) getBeanObject( bean_id,bean_name, request ) ;  
	bean.clear() ;
	bean.setMode( mode ) ;
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));	
	bean.setSession( session) ;
	Connection con			= null;//MMOH-CRF-1661 START
	boolean linen_applicable_yn =false;
	try{
		con				= ConnectionManager.getConnection(request);
		linen_applicable_yn = eCommon.Common.CommonBean.isSiteSpecific(con,"SS", "SS_GROUP_TYPE_LINEN"); 
		if(linen_applicable_yn){
			bean.setLinenApplicableYN("Y");  
		}else{
			bean.setLinenApplicableYN("N"); 
		}
	}
	catch(Exception e){
		e.printStackTrace();
		// System.out.println("Exception in GroupAddModify.jsp..");  
	}
	finally{ 
		if(con != null)
    		ConnectionManager.returnConnection(con,request);
	}//end 
	
	/* Initialize Function specific end */

	if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
		codeDisabled	= "disabled";
		disabled1	=	"disabled";
		if (null == request.getParameter( "group_code" ) )
			return;		
		bean.setGroup_code(request.getParameter( "group_code" )) ;
		bean.loadData() ;
		if(bean.getEff_status().equals("D")) 
			disabled	=	"disabled";
		if(bean.getSterilize_reqd_yn().equals("N")) 
			sterilizationDisabled	=	"disabled";
		if(bean.getWash_reqd_yn().equals("N")) 
			washingDisabled	=	"disabled";
		if(bean.getPack_reqd_yn().equals("N")) 
			packingDisabled	=	"disabled";
		if(!(bean.getChecklist_Code().equals("")))
			{
				checked = "checked";
			}
		if(bean.getGroup_type().equals("P")) 
		{
			SubClassdisabled	=	"";
		
		}
		else
			SubClassdisabled ="disabled";
		
	}
	//System.out.println("value=<%=bean.getChecklist_Code()"+bean.getChecklist_Code());
		putObjectInBean( bean_id,bean,request);
%>
		<form name="formGroup" id="formGroup" onReset="FocusFirstElement();" >
			<table border="0" cellpadding="1" cellspacing="2" width='100%' align='center' >
			<a  name="tab1" id="tab1"></a>
			<img  src="../images/General.gif" border=0><a align='left' href="javascript:tab7.scrollIntoView(); window.scrollBy(0, -5);" onFocus="javascript:tab1.scrollIntoView(); window.scrollBy(0, -10);"><img  src="../images/Additional_click.gif" border=0></a>
			<tr>
				<td align="right" class="label" ><fmt:message key="Common.Group.label" bundle="${common_labels}"/></td>
				<td align="left">&nbsp;&nbsp;<input type='text' name="group_code" id="group_code" value="<%=bean.getGroup_code()%>" maxLength=10 size=10 class="UPPER"  onKeyPress="return CheckForSpecChars(event);" <%=codeDisabled%> onBlur="checkSpecialChars(this);"><%=bean.getMandatoryImageTag()%></td>

				<td align="right" class="label" ><fmt:message key="Common.AlphaCode.label" bundle="${common_labels}"/></td>
				<td align="left">&nbsp;&nbsp;<input type='text' name="alpha_code" id="alpha_code" value="<%=bean.getAlpha_code()%>" maxLength=10 size=10 <%=disabled%> ><%=bean.getMandatoryImageTag()%></td><!-- onKeyPress="return CheckForSpecChars(event);" onBlur="checkSpecialChars(this);" -->
			</tr>	
			
			<tr>
				<td align="right" class="label" ><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
				<td align="left" >&nbsp;&nbsp;<input type='text' name="long_desc" id="long_desc" value="<%=bean.getLong_desc()%>"  size='40' maxLength='40' onBlur="makeValidString(this);" <%=disabled%>><%=bean.getMandatoryImageTag()%></td>
                 <td align="right" class="label" ><fmt:message key="eSS.GroupType.label" bundle="${ss_labels}"/></td>
                 
				<td  align="left">&nbsp;&nbsp;<select name="group_type" id="group_type" <%=disabled%> onChange="ChangeSubClass(this);">
				<%=bean.getGroup_type_List()%>
				</select></td>
				
			</tr>	
			<tr>
				<td align="right" class="label" ><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
				<td align="left">&nbsp;&nbsp;<input type='text' name="short_desc" id="short_desc" value="<%=bean.getShort_desc()%>"  size='15' maxLength='15' onBlur="makeValidString(this);" <%=disabled%>><%=bean.getMandatoryImageTag()%></td>
				<td align="right" class='label'><fmt:message key="eSS.Non-returnable.label" bundle="${ss_labels}"/></td>
				<td align="left">&nbsp;<input type='checkbox' name="non_returnable_yn" id="non_returnable_yn"  value="Y" <%=disabled%> <%=bean.getChecked(bean.getNon_returnable_yn())%>></td>
				
			</tr>
			<tr>
       			<td align="right" class="label" ><fmt:message key="eSS.SubClassification.label" bundle="${ss_labels}"/></td>
				<td align='left'>&nbsp;&nbsp;<select name="sub_classification_code" id="sub_classification_code" <%=SubClassdisabled%> <%=disabled%>>
				<%=bean.getSub_classification_code_List()%>
				</select></td>
				<td align="right" class="label" ><fmt:message key="eSS.UsageType.label" bundle="${ss_labels}"/></td>
				<td align='left'>&nbsp;&nbsp;<select name="usage_type" id="usage_type" <%=disabled%>>
				<%=bean.getUsage_type_List()%>
				</select></td>

				
			</tr>
			<tr>
				<td align="right" class="label" ><fmt:message key="eSS.SurgeryType.label" bundle="${ss_labels}"/></td>
				<td align='left'>&nbsp;&nbsp;<select name="surgery_type" id="surgery_type" <%=disabled%>>
				<%=bean.getSurgery_type_List()%>
				</select></td>
				<td align="right" class='label'>Based On CheckList</td>
				<td align='left'>&nbsp;<input type='checkbox' name="checklist_check" id="checklist_check" value="E" <%=disabled1%> <%=checked%> onclick="return enableCheckList(this);"></td>
				<td colspan='2' >&nbsp;</td>
				
			</tr>

			<tr>
				<td align="right" class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
				<td align='left'>&nbsp;<input type='checkbox' name="eff_status" id="eff_status" value="E" <%=bean.getChecked(bean.getEff_status())%>></td>
				
				<td align="left" class="label">CheckList</td><td>&nbsp;<input type='text' name="checklist_desc" id="checklist_desc" value="<%=bean.getChecklist_Code()%>" maxLength='40' size='20'  readonly><input type='button' class='BUTTON' value='?' onClick="searchCheckList(checklist_code,checklist_desc);" name='checklist_search_button' id='checklist_search_button' disabled >&nbsp;	<img src="../../eCommon/images/mandatory.gif" align="center" name ="mandtory_gif" style="visibility:hidden"><input type="hidden" name="checklist_code" id="checklist_code" value=""></td>
				<td colspan='2' >&nbsp;</td>
			
			</tr>
			<tr><td colspan='4'>&nbsp;</td></tr>
						
			</table>
			<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

			<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			<tr><td align='left'  class='white'>
			<a name="tab7" id="tab7"></a>
			<a align='left' href="javascript:tab1.scrollIntoView(); window.scrollBy(0, -5);" onFocus="javascript:tab7.scrollIntoView(); window.scrollBy(0, -10);"><img  src="../images/General_click.gif" border=0></a><img  src="../images/Additional.gif" border=0>
			</td>
			</tr>
			</table>
			<table border="0" cellpadding="0" cellspacing="2" width='100%' align='center' >
			<tr>
				<td align="right" class="label" ><fmt:message key="eSS.ItemClass.label" bundle="${ss_labels}"/></td>
				<td>&nbsp;&nbsp;<select name="item_class_code" id="item_class_code" <%=disabled%>>
				<%=bean.getItem_class_code_List()%>
				</select></td>
				<td align="right" class="label" ><fmt:message key="eSS.ItemAnalysis.label" bundle="${ss_labels}"/></td>
				<td>&nbsp;&nbsp;<select name="item_anal_code" id="item_anal_code" <%=disabled%>>
				<%=bean.getItem_anal_code_List()%>
				</select></td>
			</tr>	
			<tr>
				<td align="right" class="label"><fmt:message key="eSS.StatisticalGroup.label" bundle="${ss_labels}"/></td>
				<td>&nbsp;&nbsp;<select name="stat_group_code" id="stat_group_code" <%=disabled%>>
				<%=bean.getStat_group_code_List()%>
				</select></td>
				<td colspan='2'>&nbsp;</td>
			</tr>
			
			<tr>
				<td align="right" class="label" ><fmt:message key="eSS.Washing.label" bundle="${ss_labels}"/></td>
				<td>&nbsp;<input type='checkbox' name="wash_reqd_yn" id="wash_reqd_yn"  value="Y" <%=disabled%> <%=bean.getChecked(bean.getWash_reqd_yn())%> onClick="enableWashingDetails(this.checked);makeVisibleWash();"></td>
				<td align="right" class="label"><fmt:message key="eSS.WashingType.label" bundle="${ss_labels}"/></td>
				<td>&nbsp;&nbsp;<select name="def_washing_type" id="def_washing_type" <%=disabled%> <%=washingDisabled%>>
				<%=bean.getDef_washing_type_List()%>
						</select><span id='span1'><%=bean.getMandatoryImageTag()%></td>
			</tr>	

			<tr>
				<td align="right" class="label" ><fmt:message key="eSS.Packing.label" bundle="${ss_labels}"/></td>
				<td>&nbsp;<input type='checkbox' name="pack_reqd_yn" id="pack_reqd_yn"  value="Y" <%=disabled%> <%=bean.getChecked(bean.getPack_reqd_yn())%> onClick="enablePackingDetails(this.checked)"></td>

				<td align="right" class="label"><fmt:message key="eSS.PackItem.label" bundle="${ss_labels}"/></td>
				<td>&nbsp;&nbsp;<input type='text' name="pack_item_desc" id="pack_item_desc" value="<%=bean.getPack_item_desc()%>" maxLength='40' size='20' <%=disabled%> <%=packingDisabled%> <%=bean.getPack_item_desc().equals("")?"":"readOnly"%>><input type='button' class='BUTTON' value='?' onClick="searchPackItem(pack_item_code,pack_item_desc);" <%=disabled%> name="pack_item_search" <%=packingDisabled%>><input type="hidden" name="pack_item_code" id="pack_item_code" value="<%=bean.getPack_item_code()%>"></td>
			</tr>	

			<tr>
				<td align="right" class="label"><fmt:message key="eSS.PackItemQty.label" bundle="${ss_labels}"/></td>
				<td>&nbsp;&nbsp;<input type='text' name="pack_item_qty" id="pack_item_qty" value="<%=bean.getPack_item_qty()%>" maxLength="<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>" size="<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>" onKeyPress="return isValidInteger(this);" onBlur="checkIntegerFormat(this);" class="NUMBER" <%=disabled%> <%=packingDisabled%>></td>

				<td align="right" class="label"><fmt:message key="eSS.PackAddlCost.label" bundle="${ss_labels}"/></td>
				<td>&nbsp;&nbsp;<input type='text' name="pack_addl_cost" id="pack_addl_cost" value="<%=bean.getPack_addl_cost()%>" maxLength="<%=bean.getCurrencySize()%>" size="<%=bean.getCurrencySize()%>" onKeyPress="return isValidNumber(this,event,<%=bean.getCurrencyFormat()%>);"  onBlur="checkDoubleFormat(this);" class="NUMBER"  <%=disabled%> <%=packingDisabled%>></td>
			</tr>	
			<tr>
				<td align="right" class="label" ><fmt:message key="eSS.Sterilization.label" bundle="${ss_labels}"/></td>
				<td>&nbsp;<input type='checkbox' name="sterilize_reqd_yn" id="sterilize_reqd_yn"  value="Y" <%=disabled%> <%=bean.getChecked(bean.getSterilize_reqd_yn())%> onClick="enableSterilizationDetails(this.checked);makeVisibleSter();"></td>
				<td align="right" class="label"><fmt:message key="eSS.SterilizationType.label" bundle="${ss_labels}"/></td>
				<td>&nbsp;&nbsp;<select name="def_sterile_type" id="def_sterile_type" <%=disabled%> <%=sterilizationDisabled%>>
				<%=bean.getDef_sterile_type_List()%>
				</select><span id='span2'><%=bean.getMandatoryImageTag()%></span></td>
			</tr>	
			<tr>
				<td align="right" class="label"><a href='javascript:callTextBox();'  <%=disabled%>><fmt:message key="Common.remarks.label" bundle="${common_labels}"/>&nbsp&nbsp</a></td>
				<td align="left" colspan='3'>&nbsp;<input type="text" name='remarks' id='remarks' value="<%=bean.getRemarks()%>" maxLength="200" size="73"></td>
			</tr>
			<tr><td colspan='4'>&nbsp;</td></tr>
			</table>

			<br><br><br><br><br><br><br><br><br><br><br><br><br> <br><br><br><br><br><br><br><br>

			<input type="hidden" name="mode" id="mode" value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
			<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
			<input type="hidden" name="locale" id="locale" value="<%=locale%>">

			<input type="hidden" name="records_to_delete" id="records_to_delete" value="">
			<input type="hidden" name="SQL_SS_ITEM_LOOKUP" id="SQL_SS_ITEM_LOOKUP" value="<%= bean.getSsRepositoryValue("SQL_SS_ITEM_LOOKUP")%>">
		</form>
	</body>
</html>



