<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        	Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
03/08/2017	IN062992		Dinesh T		7/8/2017		Ramesh G		ML-MMOH-CRF-0345.1
12/02/2018	IN065713		Dinesh T		12/02/2018		ML-MMOH-CRF-0987
10/10/2018	IN68241			Dinesh T		10/10/2018		Ramesh G		ML-MMOH-CRF-1227
28/02/2019  IN068370    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0014
28/02/2019  IN068373    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0015
18/03/2019	IN069959	Dinesh T 	  18/03/2019    Ramesh G    PMG2018-GHL-CRF-0015 - Issue 1
08/01/2020	IN068314	Nijitha S     08/01/2020	Ramesh G	ML-MMOH-CRF-1229
------------------------------------------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,webbeans.eCommon.ConnectionManager,java.sql.*"%><!-- Added for IN068314 -->
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>


<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language='javascript' src='../js/OrderSet.js'></script>
	<script language="javascript" src="../js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<!--IN068370,IN068373-->
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	</head>
 
<body onLoad="parent.parent.defaultLoadDetail()" onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name='header' id='header' target='messageFrame' >
<%

try{

	//String readOnly = "" ;
	//String checked = "checked" ;
	/* Mandatory checks start */
	String mode	   = request.getParameter( "mode" ) ;

	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_CareSet" ;
	String bean_name = "eOR.CareSetBean";
	//String disabled = "" ;

	CareSetBean bean = (CareSetBean)getBeanObject(bean_id, bean_name,request ) ;
	

	bean.clearALL();


	/*****CUSTUMAZIABLE PARAMETERS*****************/

	String order_careset_code				= "";
	String order_type_code					= "";
	String activity_type					= "";
	String indexed_yn						= "N";
//	String discharge_indicator				= "N";
	String long_desc						= "";
	String short_desc						= "";
	//String security_level					= "";
	String eff_status						= "E";
	String order_category					= "";
	String iv_prep_yn_val					= "";


	String	order_careset_code_update	="Y";
	String	order_category_update			="Y";
	String	category_update			            ="Y";
	//String	order_type_update				="Y";
	String	indexed_yn_update				="Y";
//	String	discharge_indicator_update		="Y";
	String	long_desc_update				="Y";
	String	short_desc_update				="Y";
	//String	security_level_yn_update		="Y";
	String	iv_prep_yn_update				= "Y";
	String	activity_update					= "Y";



	String  sql_order_category				="OrderCategory";
	String  sql_order_type					="OrderType";
	String  sql_iv_prep_yn					="iv_prep_yn";


	String	sql_order_category_params		="";
	//String	sql_order_type_default			="";
	//String  iv_prep_yn_display				= "style='display:none'";
	String  iv_prep_yn_display				= "display:none";
	String explanatory_text="";
	
	order_careset_code    				= bean.checkForNull(request.getParameter("order_set_code" ));
	long_desc						            = bean.checkForNull(request.getParameter("long_desc"));
	short_desc						            = bean.checkForNull(request.getParameter("short_desc"));
	order_category					        = bean.checkForNull(request.getParameter("order_category"));
	String module_id						= bean.checkForNull(request.getParameter("module_id"));


	//IN062992, starts
	bean.clearMappedFacilities();//IN068370,IN068373
	bean.setSiteSpecificYN("OR_ORDER_SET");//Hard coded since Function id is not coming
	boolean isSiteSpecificYN = bean.isSiteSpecificYN();
	//IN062992, ends
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ))
	return ;
	bean.setMode(mode ) ;
	//IN068314 Starts
	Boolean isfppapplicable = false;
	String fpp_yn="";
	Connection connection =  null;
	try{
	connection = ConnectionManager.getConnection(request); 
	
	isfppapplicable = eCommon.Common.CommonBean.isSiteSpecific(connection, "OR","FPP_APPLICABLE_YN");//IN068314
	bean.setIsFPPApplicable(isfppapplicable);//IN068314
	System.out.println("isfppapplicable==>"+isfppapplicable);
	}catch(Exception e1){
		e1.printStackTrace();
	}finally{
		if(connection!=null) connection.close();
	}
	 //IN068314 ENDS
	/********************MODIFY MODE ONLY FOR OR***************/
	if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )) {
	//order_type_update						="N";
	order_careset_code_update				="N";
	order_category_update					="N";

	order_careset_code						= request.getParameter("order_set_code");

	String code_p[]								={order_careset_code};

	bean.defaultLoadForUpdation(code_p);


	HashMap careSetHeaderStr = (HashMap)bean.getCareSetHeaderStr();
 	careSetHeaderStr.put("order_set_code",order_careset_code.trim());

	long_desc			=(String)careSetHeaderStr.get("long_desc");
	short_desc			=(String)careSetHeaderStr.get("short_desc");
	order_category		=(String)careSetHeaderStr.get("order_category");
	order_type_code		=(String)careSetHeaderStr.get("order_type_code");
	activity_type		=(String)careSetHeaderStr.get("activity_type");
	//security_level		=(String)careSetHeaderStr.get("security_level");
	explanatory_text			=careSetHeaderStr.get("explanatory_text")==null?"":(String)careSetHeaderStr.get("explanatory_text");
	eff_status			=(String)careSetHeaderStr.get("eff_status");
	indexed_yn			=(String)careSetHeaderStr.get("indexed_yn");
//	discharge_indicator	=(String)careSetHeaderStr.get("discharge_indicator");
	iv_prep_yn_val		=(String)careSetHeaderStr.get("iv_prep_yn")==null?"":(String)careSetHeaderStr.get("iv_prep_yn");
	bean.setApplicableTo(iv_prep_yn_val);//IN062992

	fpp_yn = (String)careSetHeaderStr.get("fpp_yn")==""?"N":(String)careSetHeaderStr.get("fpp_yn");//IN068314
	if(order_category!=null && order_category.equals("PH"))
		//iv_prep_yn_display = "style='display:inline'";
		iv_prep_yn_display = "display:visible";

	bean.loadRecordedData(); //Load the Data of the Ascc Mode -in case if user does not go  in the Ascc tab


	if(eff_status.trim().equalsIgnoreCase("D")){
		order_careset_code_update		="N";
		order_category_update			="N";
		//order_type_update				="N";
		indexed_yn_update				="N";
		//discharge_indicator_update		="N";
		long_desc_update				="N";
		short_desc_update				="N";
		//security_level_yn_update		="N";
		iv_prep_yn_update				= "N";
		activity_update					= "N";
	}
}//End of Modify Mode Code

if(module_id.equalsIgnoreCase("OH"))
{
	order_careset_code_update		="N";
	category_update				="N";
	activity_update							= "N";
}

if((!order_careset_code.equals(""))&&(order_category.equalsIgnoreCase("PH")))
{
	HashMap AdditionalCatalogs	= (HashMap)bean.getDBAdditionalCatalogs();

	
	if(AdditionalCatalogs.size()==0)
	{
		bean.additionalDBCatalogs(order_careset_code.trim());
	}
	else
	{
		
	}

	//IN062992, starts
	if(isSiteSpecificYN)
	{
		HashMap ageWiseDBCatalogs	= (HashMap)bean.getDBAgeWiseCatalogs();
		
		if(ageWiseDBCatalogs.size()==0)
		{
			bean.ageWiseDBCatalogs(order_careset_code.trim());
		}		
		
		//IN065713, starts
		HashMap ageWiseAdditionalDBCatalogs	= (HashMap)bean.getDBAgeWiseAdditionalCatalogs();
		
		if(ageWiseAdditionalDBCatalogs.size()==0)
		{
			bean.ageWiseDBAdditionalCatalogs(order_careset_code.trim());
		}
		//IN065713, ends
		
		//IN68241, starts
		HashMap dosageTypeCatalogs	= (HashMap)bean.getDosageTypeHashValues();
		
		if(dosageTypeCatalogs.size()==0)
		{
			bean.populateCatalogByDosageType(order_careset_code.trim());
		}
		
		HashMap dosageTypeCatalogsAdditionalsKg	= (HashMap)bean.getDosageTypeAdditionalKgHashValues();
		
		if(dosageTypeCatalogsAdditionalsKg.size()==0)
		{
			bean.populateCatalogByDosageTypeAdditionalsKg(order_careset_code.trim());
		}
		
		HashMap dosageTypeCatalogsAdditionalsM2	= (HashMap)bean.getDosageTypeAdditionalM2HashValues();
		
		if(dosageTypeCatalogsAdditionalsM2.size()==0)
		{
			bean.populateCatalogByDosageTypeAdditionalsM2(order_careset_code.trim());
		}
		//IN68241, ends
	}
	//IN062992, ends
}


/******************************************************************/

%>
<table cellpadding=3 cellspacing=0 border=0 width='100%' align=center height='100%'>

<!-- CODE -->
<tr>
	<td class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type=text name='order_set_code' id='order_set_code'  onkeypress="return parent.parent.CheckForSpecChars(event)"  onBlur="parent.parent.ChangeUpperCase(this);"  maxlength="10"
	<%=eHISFormatter.chkReturn("y",order_careset_code_update,"","disabled")%>
	value="<%=order_careset_code.trim()%>"
	><img src="../../eCommon/images/mandatory.gif" align='center'></img></td>
	<!--<td colspan="3"></td>--><!--IN068370,IN068373-->
	<%
	//IN068370,IN068373, starts
	if("Y".equals(bean.getGlobalFacilityYn()) && bean.isSiteSpecific("ORDER_CATALOG_FAC_WISE"))
	{
	%>	
	<td class="label">
	<a href='#' onclick='showAllFacilities()'><fmt:message key="eOR.ApplicableFacilities.label" bundle="${or_labels}"/></a>
	<img src="../../eCommon/images/mandatory.gif" align='center'></img><!--IN068370,IN068373-->
	</td>
	<td>
	&nbsp;	
	</td>
	<%
	}
	//IN068370,IN068373, ends
	%>
</tr>

<!-- Long Description -->
<tr>
	<td class='label'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type=text name='long_desc' id='long_desc' size='40' maxlength='60' onBlur="parent.parent.makeValidString(this);"
	<%=eHISFormatter.chkReturn("y",long_desc_update,"","disabled")%>
	value="<%=long_desc.trim()%>" ><img src="../../eCommon/images/mandatory.gif"  align='center'></img></td>

	<td class='label'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type=text name='short_desc' id='short_desc' size='30'
	 maxlength='30' onBlur="parent.parent.makeValidString(this);parent.parent.defaultIntLowerFrame();" <%=eHISFormatter.chkReturn("y",short_desc_update,"","disabled")%> value="<%=short_desc.trim()%>" ><img src="../../eCommon/images/mandatory.gif"  align='center'></img></td>
</tr>

<tr>
	<!--ORDER CATEGORY  -->
	<td class='label'><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>

	<td id='order_category' class=fields><select name="order_category" id="order_category" onChange="parent.parent.fillComboOptions(this)"	
	<%
		if(module_id.equalsIgnoreCase("OH"))
		{
			out.println(eHISFormatter.chkReturn("Y",category_update,"","disabled"));
		}
		else
		{
			out.println(eHISFormatter.chkReturn("Y",order_category_update,"","disabled"));
		}
	%>><option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
	<%=bean.getComboOptions(sql_order_category,order_category.trim(),sql_order_category_params.trim())%>
	</select><img src="../../eCommon/images/mandatory.gif" align='center'></img>
	</td>


	<!--ORDER TYPE  -->
	<td class='label' ><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
	<td id='order_type_td' class=fields><select name="order_type_code" id="order_type_code"
	<%=eHISFormatter.chkReturn("Y",order_category_update,"","disabled")%>
	<%if(module_id.equalsIgnoreCase("OH"))	{%>onchange="parent.parent.display('S')"<%}else{%>onchange="parent.parent.fillComboOptions(this);parent.parent.display('S')"<%}%>><option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --- </option><%=bean.getComboOptions(sql_order_type,order_type_code.trim(),order_category.trim())%> </select><img src="../../eCommon/images/mandatory.gif"  align='center'></img>
	</td>
 </tr>

<tr>
	<input type='hidden' name='security_level' id='security_level' size='1' value='' maxlength='1' >
	<td class='label'><fmt:message key="eOR.ActivityType.label" bundle="${or_labels}"/></td>		
	<td id='activity_type_td' class=fields><%if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )) {
	StringBuffer sqlparam= new StringBuffer();
	sqlparam.append(order_category.trim());
	sqlparam.append(","+order_type_code.trim());
	sqlparam.append(","+order_category.trim());
	%><select name="activity_type" id="activity_type" <%=eHISFormatter.chkReturn("Y",activity_update,"","disabled")%>><option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --- </option><%=bean.getComboOptions("ActivityType",activity_type,sqlparam.toString())%></select><%}else{
		%><select name="activity_type" id="activity_type" <%if(module_id.equalsIgnoreCase("OH"))
		{
			out.println(eHISFormatter.chkReturn("Y",activity_update,"","disabled"));
		}%>><option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --- </option></select><%}%>
	
	</td>

<td class='label' ><fmt:message key="eOR.Index.label" bundle="${or_labels}"/></td>
<td class='fields'>
<input type='checkbox' name='indexed_yn' id='indexed_yn'
<%=eHISFormatter.chkReturn("Y",indexed_yn_update,"","disabled")%>
<%=eHISFormatter.chkReturn(indexed_yn.trim(),"N","","checked") %>
 value=''>
</td>
</tr>
<!--IN068314 Starts-->
<%if(isfppapplicable)
{%>
<tr>
	  <td  class="label"  ><fmt:message key="eOR.FPPPATIENT.label" bundle="${or_labels}"/> </td>
	  <td  class="label"  ><input type="checkbox" name="fpp_yn" id="fpp_yn" value='<%=fpp_yn%>' onclick="validatefppcatalog(this)" <%=eHISFormatter.disabled("2",mode)%> <%=eHISFormatter.chkReturn(fpp_yn.trim(),"Y","checked","") %>/> 
	  <label name="fpplable">&nbsp;</label>
	  </td>
</tr>
<%}
else { %>
  <input type="hidden" name="fpp_yn" id="fpp_yn" value="">
<% } %>
<!--IN068314 Ends-->
<tr>
<td class='label' ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
<td  colspan='3' >
<input type='checkbox' name='eff_status' id='eff_status'  <%=eHISFormatter.chkReturn(eff_status.trim(),"D","","checked") %>
 value='E'>
</td>	
</tr>	
<tr id="iv_prep_yn_display" style="<%=iv_prep_yn_display%>">
 <td class='label' ><fmt:message key="Common.ApplicableTo.label" bundle="${common_labels}"/></td>
 <!--IN062992, starts-->
 <%
if(isSiteSpecificYN)
{
 %>
<td class='fields' id="iv_prep_yn_td"><select name="iv_prep_yn" id="iv_prep_yn" <%=eHISFormatter.chkReturn("Y",iv_prep_yn_update,"","disabled")%> onchange="parent.parent.display('S');parent.parent.clearAll();"><option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option><%=bean.getComboOptions(sql_iv_prep_yn,iv_prep_yn_val.trim(),order_category.trim())%>
<!--IN062992, ends-->
</select></td>
<%
}
else
{
%>
 <td class='fields' id="iv_prep_yn_td"><select name="iv_prep_yn" id="iv_prep_yn" <%=eHISFormatter.chkReturn("Y",iv_prep_yn_update,"","disabled")%>
 ><option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option><%=bean.getComboOptions(sql_iv_prep_yn,iv_prep_yn_val.trim(),order_category.trim())%>
<%
}	
%> 

<!-- 	 /**************************/
<select name="order_type_code" id="order_type_code"
	<%=eHISFormatter.chkReturn("Y",order_category_update,"","disabled")%>
	 onchange="parent.parent.fillComboOptions(this);parent.parent.display('S')" ><option value=''>--- Select --- </option><%=bean.getComboOptions(sql_order_type,order_type_code.trim(),order_category.trim())%></select
	 /**************************/ -->
 <td colspan='2'></td>
</tr>

<tr>

<!-- >discharge_indicator-->
<%/**<td class='label' >Discharge Indicator</td>
<td >
<input type='checkbox' name='discharge_indicator' id='discharge_indicator'
<%=//eHISFormatter.chkReturn("Y","","","disabled")  <!--//discharge_indicator_update-->
<%=///eHISFormatter.chkReturn("","N","","checked")   <!--//discharge_indicator.trim()-->
 value=''>
</td>--*/%>
<TD colspan='2'><input type='hidden' name='discharge_indicator' id='discharge_indicator' value=''></TD>
</tr>

</table>

	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="qry_str" id="qry_str" value="<%=request.getQueryString()%>">
 	<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
 	<input type="hidden" name="eff_status_mod" id="eff_status_mod" value="<%=eff_status.trim()%>">
 	<input type="hidden" name="explanatory_text" id="explanatory_text" value="<%=explanatory_text%>">
	<input type="hidden" name="iv_prep_ynVal" id="iv_prep_ynVal" value="<%=iv_prep_yn_val%>">
	<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
	<input type="hidden" name="module_id" id="module_id" value="<%=module_id%>">
	<!--IN068370,IN068373, starts-->
	<!--IN069959, starts-->
	<!--<input type='hidden' name='applFacsMappedYn' id='applFacsMappedYn' value =''/>-->
	<input type='hidden' name='applFacsMappedYn' id='applFacsMappedYn' value ='<%=bean.getMappedFacilities().size()>0?"Y":""%>'/>
	<!--IN069959, ends-->
	<input type='hidden' name='globalFacilityYn' id='globalFacilityYn' value ='<%=bean.getGlobalFacilityYn()%>'/>
	<input type='hidden' name='siteSpecGlobalFac' id='siteSpecGlobalFac' value ='<%=bean.isSiteSpecific("ORDER_CATALOG_FAC_WISE")%>'/>
	<!--IN068370,IN068373, ends-->
 </form>

<%
putObjectInBean(bean_id,bean,request);	
}
catch(Exception e)
{
	e.printStackTrace();
}
%>
</body>
</html>

