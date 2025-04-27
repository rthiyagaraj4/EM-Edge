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
<%@ page import ="eSS.RequestGroupBean,java.util.HashMap,java.util.ArrayList,,java.sql.*,webbeans.eCommon.*,java.lang.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<%-- Mandatory declarations end --%>
<html>
<head>
<%
	 request.setCharacterEncoding("UTF-8");
	String locale			=	(String)session.getAttribute("LOCALE");
	String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/RequestGroup.js"></script>
		<script language="JavaScript" SRC="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		 
</head> 
<%
	String bean_id = "RequestGroupBean";
	String bean_name = "eSS.RequestGroupBean";
	RequestGroupBean bean = (RequestGroupBean) getBeanObject( bean_id,bean_name,request );
	bean.setLanguageId(locale);
	
	String item_code				= 	request.getParameter( "item_code" )==null?"":request.getParameter( "item_code" ) ;
	String req_on_store_code		= 	request.getParameter( "req_on_store_code" )==null?"":request.getParameter( "req_on_store_code" ) ;
	String req_by_store_code		= 	request.getParameter( "req_by_store_code" )==null?"":request.getParameter( "req_by_store_code" ) ;
	String rcvng_store_code			= 	request.getParameter( "rcvng_store_code" )==null?"":request.getParameter( "rcvng_store_code" ) ;
	String click_type				= 	request.getParameter( "click_type" )==null?"":request.getParameter( "click_type" ) ;
	String total_rec				= 	request.getParameter( "total_rec" )==null?"":request.getParameter( "total_rec" ) ;
	String mode						= 	request.getParameter( "mode" )==null?"":request.getParameter( "mode" ) ;
	
	String surgery_type				=	request.getParameter( "surgery_type" )==null?"":request.getParameter( "surgery_type" ) ;
	
	String surg_nature_link_to_OT_yn = bean.checkForNull((String)((HashMap)bean.fetchRecord(bean.getSsRepositoryValue("SQL_SS_SURG_NATURE_LINK_OT_YN_SELECT"),bean.getLoginFacilityId())).get("SURG_NATURE_LINK_OT_YN"));
	String  display_flag					= "visibility:visible";
	if(surg_nature_link_to_OT_yn.equals("N")){
	display_flag					= "visibility:hidden";
	}	
	//MMOH-CRF-1661
	Connection con			= null;//MMOH-CRF-1661 START
	boolean linen_applicable_yn =false;
	try{
		con				= ConnectionManager.getConnection(request);
		linen_applicable_yn = eCommon.Common.CommonBean.isSiteSpecific(con,"SS", "SS_GROUP_TYPE_LINEN"); 
		if(linen_applicable_yn){
			bean.setLinen_applicable_yn("Y");
		}else{
			bean.setLinen_applicable_yn("N");   
		}
	}
	catch(Exception e){
		e.printStackTrace();
		System.out.println("Exception in RequestGroupSearchCriteria.jsp..");    
	} 
	finally{
		if(con != null)
    		ConnectionManager.returnConnection(con,request);
	}//end 
	
	putObjectInBean(bean_id,bean,request);

%>

<body onload='FocusFirstElement();' >
	<form name="GroupSearchCriteria_Form" id="GroupSearchCriteria_Form" >
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align=center>
			
			<th   colspan=6><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></th>
		<tr>
			<td>&nbsp;&nbsp;</td> 
			<td   class="label"><fmt:message key="Common.searchby.label" bundle="${common_labels}"/>
		</td>
		<td  class="fields"><input type="radio" name="search_by" id="search_by" class="label" value="C"    onclick="storeVal(this)"><fmt:message key="Common.code.label" bundle="${common_labels}"/>
		<input type="radio" name="search_by" id="search_by" class="label" value="D" onclick="storeVal(this)" checked><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
		<td class="label" ><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></td>
        <td class='fields'><select name="search_criteria" id="search_criteria">
        <option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
        <option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
        <option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
        </select>
        </td>
		</tr>
		
        <tr>
		<td class="label">&nbsp;</td>
		<td class="label"><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/></td>
        <td class="fields"><input type="text" onBlur="makeValidString(this);allow_nochars(this);"  name="search_text" id="search_text"  width="30%" align="left" size="40" maxlength="70" >
        </td>
        <td  class="label" ><fmt:message key="eSS.GroupType.label" bundle="${ss_labels}"/></td>
        <td class=fields><select name="group_type" id="group_type" >	<%=bean.getGroupType()%></select></td>		
		
    </tr>
     
    
    <tr>
   		 <td class="label">&nbsp;</td>
   		 <%if(surg_nature_link_to_OT_yn.equals("Y")){ %>
		<td class="label"><fmt:message key="eSS.SurgeryType/Name.label" bundle="${ss_labels}"/></td>
		<%}else{ %>
		<td class="label"><fmt:message key="eSS.SurgeryType.label" bundle="${ss_labels}"/></td>
		<%} %>
		<td class="fields"><input type='text' name="surg_description" id="surg_description"  value="" maxLength='15' size='15' onBlur="makeValidString(this);"  onkeydown="" onBlur=""><input type='button' class='BUTTON' value='?' onClick="callSurgeryTypeSearchWindow(surgery_type, surg_description,surg_code,ot_surg_description);"  name="surgery_type_search" id="surgery_type_search"   onkeydown="return isNumberKey(event);"><input type="hidden" name="surgery_type" id="surgery_type"  value="">&nbsp;<input type='text' name="ot_surg_description" id="ot_surg_description" style =  "<%=display_flag%>" value="" maxLength='15' size='15'  readonly onkeydown="return isNumberKey(event);"><input type="hidden" name="surg_code" id="surg_code" value=""><input type="hidden" name="temp_surgery_type" id="temp_surgery_type" value=""><input type="hidden" name="temp_surgery_name" id="temp_surgery_name" value="">
		</td>
		
        </td>
	</tr>
	<tr>
	<td class="label">&nbsp;</td>
     <td class="label"><fmt:message key="eSS.ConsiderGroupsInTargetStore.label" bundle="${ss_labels}"/></td>
     <td align="left" ><input type=checkbox class=button name="target_store" id="target_store" value=""  onclick=""></td>
     <td align="left" nowrap>&nbsp;<input type="button" align="left" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="searchValues(); " class="button" >
        <input type="button" align="left" name="Reset" id="Reset" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' onClick="reset();reset_criteria();" class="button" >
        <input type=button class=button name="Save" id="Save" value=' <fmt:message key="Common.ok.label" bundle="${common_labels}"/>'  onclick="closeActionPerformed(this); ">
        <input type=button class=button name="Close" id="Close" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>'  onclick="parent.parent.document.getElementById('dialog_tag').close();"></td>
     </tr>
						

		
</center>
</table>
<input type="hidden" name="facility_id" id="facility_id" value="<%=bean.getLoginFacilityId()%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="click_type" id="click_type" value="<%=click_type%>">
<input type="hidden" name="total_rec" id="total_rec" value="<%=total_rec%>">
<input type="hidden" name="mode" id="mode" value="<%=mode%>">

<input type="hidden" name="req_on_store_code" id="req_on_store_code" value="<%=req_on_store_code%>">
<input type="hidden" name="req_by_store_code" id="req_by_store_code" value="<%=req_by_store_code%>">
<input type="hidden" name="rcvng_store_code" id="rcvng_store_code" value="<%=rcvng_store_code%>">
<input type="hidden" name="surg_nature_link_to_OT_yn" id="surg_nature_link_to_OT_yn" value="<%=surg_nature_link_to_OT_yn%>">


<script>
<%
	out.println("searchValues();");
%>
</script>
</form>

</body>
</html>

