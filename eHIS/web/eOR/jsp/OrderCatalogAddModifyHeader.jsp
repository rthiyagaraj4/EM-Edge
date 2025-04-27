<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
--------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        	Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------------------
03/08/2017	IN062992		Dinesh T		7/8/2017		Ramesh G		ML-MMOH-CRF-0345.1
28/02/2019  IN068370    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0014
28/02/2019  IN068373    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0015
18/03/2019	IN069959	Dinesh T 	  18/03/2019    Ramesh G    PMG2018-GHL-CRF-0015 - Issue 1
10/05/2019  IN068926       sivabagyam      10/05/2019      Ramesh G    	 ML-MMOH-CRF-1290
24/1/2020	IN072190		Shazana 									SKR-SCF-1312
--------------------------------------------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
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
	//System.out.println("OrderCatalogAddModifyHeader.jsp -------------> line 18 ::: "+request.getQueryString());
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eOR/js/OrCommonFunction.js"></script>
	<script language="javascript" src="../../eOR/js/OrderCatalog.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
    <Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script>





</head>
<!-- -->
<body onLoad="parent.parent.defaultLoadDetail()" onMouseDown="CodeArrest()"  onKeyDown="lockKey()"  >
<form name='header' id='header' target='messageFrame' >
<%

try{
	/* Added by Kishore Kumar N on Sept 07 for CRF 0691 */
	java.util.Properties props = (java.util.Properties) session.getValue( "jdbc" ) ;
	/* ends here.*/
	String locale = (String) props.getProperty("LOCALE");
	//String readOnly = "" ;
	//String checked = "checked" ;
	/* Mandatory checks start */
	
//out.println("<script>alert('"+request.getQueryString()+"');</script>");
	String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_OrderCatalog" ;
	String bean_name = "eOR.OrderCatalogBean";
	//String disabled = "" ;
	
	OrderCatalogBean bean = (OrderCatalogBean)getBeanObject(bean_id, bean_name ,request) ;	
	bean.setLanguageId(localeName);
	bean.clearALL();
	//IN062992, starts
	bean.clearMappedFacilities();//IN068370,IN068373
	bean.setSiteSpecificYN("OR_ORDER_MASTER");
	//IN062992, ends

	//out.println(request.getQueryString());

	/*****CUSTUMAZIABLE PARAMETERS*****************/
	String order_type_code					= "" ;
	String activity_type					= "" ;
	String image_link_id					= "" ;
	String indexed_yn					= "" ;
	//String security_level					= "" ;
	String eff_status						= "E";
	String eff_status_modify_Orginal		= "E" ;	//User only for Ph in modify mode
	String long_desc="";
	String short_desc="";

	String	update_code_yn					="Y";
	String	update_order_category_yn		="Y";
	String	update_order_type_yn			="Y";
	String	update_activity_type_yn			="";
	String	update_long_desc_yn				="Y";
	String	update_short_desc_yn			="Y";
	//String	update_security_level_yn		="Y";



	String  sql_order_category				="OrderCategory";
	String  sql_order_type					="OrderType";
	//String  sql_activity_type				="ActivityType";


	String	sql_order_category_params		="";
	String	sql_order_type_default			="";
	
	String ot_module = "";
	String oh_module = "";
	//String descriptions[] = new String[2];
	String descriptions="";
	String lnkVaccineId = "";
	String lnkVaccineName = "";
	//String l_global_facility_yn = "";//IN068370,IN068373
		String tpn_item_yn="";//added IN068926
	//String	sql_activity_type_default			="";

/********DEFAULT VALUES PASSED FROM OTHER MODULES********************/
	String order_catalog_code				= bean.checkForNull(request.getParameter("order_catalog_code" ));
	String module_id						= bean.checkForNull(request.getParameter("module_id"));
	HashMap descriptionMap			= new HashMap();//added for SKR-SCF-1312	
	//System.out.println("order_catalog_code========="+order_catalog_code);
	if(module_id.equals("PH"))
	{
		//commented for SKR-SCF-1312
		/*descriptions=(String)bean.getDescriptions(order_catalog_code);
		//long_desc= bean.checkForNull(descriptions);
		//short_desc= bean.checkForNull(descriptions); 
		short_desc=	(String)bean.getShortDescription(order_catalog_code, locale);*/
		//added for SKR-SCF-1312
		descriptionMap = bean.getMMDescriptions(order_catalog_code, locale); 
		if(descriptionMap!=null && descriptionMap.size()>0){
			long_desc = (String)descriptionMap.get("LONG_DESC");
			short_desc = (String)descriptionMap.get("SHORT_DESC"); 
		}
		if(long_desc.equals("")&&short_desc.equals(""))
		{
			long_desc	= bean.checkForNull(request.getParameter("long_desc"));
			short_desc	= bean.checkForNull(request.getParameter("short_desc"));
		}
	}
	else
	{
		long_desc	= bean.checkForNull(request.getParameter("long_desc"));
		short_desc	= bean.checkForNull(request.getParameter("short_desc"));
	}
	String order_category					= bean.checkForNull(request.getParameter("order_category"),"All");
	//System.out.println("order_category========="+order_category);
	if(short_desc.length()>0&&short_desc.length()>40)
	{
		short_desc=short_desc.substring(0,39);
	}

	if(module_id.equals("OT"))
	{
		module_id = "OR";
		ot_module = "OT";
	}
	if(module_id.equals("OH"))
	{
		module_id = "OR";
		oh_module = "OH";
	}

	//System.out.println("1111 sql_order_type="+sql_order_type);
	sql_order_type							= bean.checkForNull(request.getParameter("sql_order_type"));
	//System.out.println(" 2222 sql_order_type="+sql_order_type);
	String image_link_id_Updateble						 = "N";//for Body Organ
	String indexed_yn_updatable						     = "Y";//for Index by Service
	if(order_category.trim().equalsIgnoreCase("RX") || order_category.trim().equalsIgnoreCase("RD")|| order_category.trim().equalsIgnoreCase("TR") )
		image_link_id_Updateble = "Y" ;
	//sql_activity_type							= bean.checkForNull(request.getParameter("sql_activity_type"));
 	//System.out.println("nnnnnnnnnnnnnkkkkkkk :===="+request.getParameter("sql_order_type")+"=========");
   /**********************************************/
   	String l_mapping_facility_id = "";//IN068370,IN068373

	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ))
	return ;
	bean.setMode( mode ) ;

	/**********Parametize according to  the  Modules passed ***************/
	if(!module_id.equalsIgnoreCase("OR") && !mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ))){

		order_category = module_id ;

		if(module_id.equalsIgnoreCase("PH")){//For PHARMACY
			update_code_yn					="N";
			update_order_category_yn		="N";
			//update_order_type_yn			="N";
			//update_activity_type_yn			="N";
			update_long_desc_yn				="N";
			update_short_desc_yn			="Y";
			sql_order_category				="OrderCategoryOthers";
			sql_order_category_params		="PH";
		}

	}else{//for OR
		
			if(ot_module.equalsIgnoreCase("OT")){//For OT Surgery
			update_code_yn					="N";
			update_order_category_yn		="N";
			update_order_type_yn			="N";
			//update_activity_type_yn			="N";
			update_long_desc_yn				="Y";
			update_short_desc_yn			="Y";
			}
			if(oh_module.equalsIgnoreCase("OH")){//For Oral Health
			update_code_yn					="N";
			update_order_category_yn		="N";
			//update_order_type_yn			="N";
			update_activity_type_yn			="N";
			update_long_desc_yn				="Y";
			update_short_desc_yn			="Y";
			}
			sql_order_category				="OrderCategory";
			sql_order_type					="OrderType";
			
			//sql_activity_type				="ActivityType";
			sql_order_category_params		="";

	}

	/* Added by Kishore Kumar N on Sept 07 for CRF 0691 */
	String vaccineId = (String)bean.getLinkedVaccineId(order_catalog_code, locale)==null?"":(String)bean.getLinkedVaccineId(order_catalog_code, locale);
	String readOnlyVaccineId ="disabled";
	String btnDisabled = "disabled";
	if(!vaccineId.equals(""))
	{
		String str[] = vaccineId.split("`~");
		lnkVaccineId = str[0];
		lnkVaccineName = str[1];

	}
	else if(vaccineId.equals(""))
	{
		readOnlyVaccineId ="";
		btnDisabled = "";
	}
	/* ends here. */

	/********************MODIFY MODE ONLY FOR OR***************/
	if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )) {
		readOnlyVaccineId ="";
		btnDisabled = "";

	update_code_yn					="N";
	String code_p[]					={order_catalog_code};
//	out.println("code_p="+order_catalog_code);

	bean.defaultLoadForUpdation(code_p);
	//IN068370,IN068373, starts
	HashMap l_cata_hdr_dtls = bean.getOrderCatalogHeaderStr();
	
	String l_ind_fac_ids[] = null;
			
	if(l_cata_hdr_dtls.containsKey("appl_fac_id"))
	{
		l_ind_fac_ids = (String[])l_cata_hdr_dtls.get("appl_fac_id");
		
		for(int i=0;i<l_ind_fac_ids.length;i++)
			l_mapping_facility_id = l_mapping_facility_id+ "~" +l_ind_fac_ids[i];
	}
	//IN068370,IN068373, ends
//	out.println("tempChk="+bean.tempChk);
//	out.println("Arr="+bean.characteristicsRecStr.toString());
//	out.println("ArrInst="+bean.instructionsRecStr.toString());
//	orderCatalogHeaderStr =	getOrderCatalogHeaderStr();
 	if(module_id.equalsIgnoreCase("PH")) 
	{
		
		/*if(long_desc.equals("")) {
			long_desc			=(String)bean.orderCatalogHeaderStr.get("long_desc");
		}
		if(long_desc!=null && long_desc.length()> 40)
			short_desc = long_desc.substring(0,39);*/
		//if(short_desc.equals("")) {
		//	short_desc			=(String)bean.orderCatalogHeaderStr.get("short_desc");
		//}	
		
		/*descriptions=(String)bean.getDescriptions(order_catalog_code);
		long_desc=bean.checkForNull(descriptions);*/ //commented for SKR-SCF-1312
		
		//added for SKR-SCF-1312
		descriptionMap = bean.getMMDescriptions(order_catalog_code, locale); 
		if(descriptionMap!=null && descriptionMap.size()>0){
			long_desc = (String)descriptionMap.get("LONG_DESC");
			short_desc = (String)descriptionMap.get("SHORT_DESC"); 
		}
		//modified for skr-scf-1312
		if(short_desc!=null && short_desc.length()> 40)
		{	
			short_desc=bean.checkForNull(short_desc).substring(0,39);
		}
		else
		{	
			short_desc=bean.checkForNull(short_desc);
		}
		if(long_desc.equals("")&&short_desc.equals(""))
		{
			long_desc	= bean.checkForNull(request.getParameter("long_desc"));
			short_desc	= bean.checkForNull(request.getParameter("short_desc"));
		}


	} else {
		long_desc				=(String)bean.orderCatalogHeaderStr.get("long_desc");
		short_desc				=(String)bean.orderCatalogHeaderStr.get("short_desc");
	}	

	order_category			=(String)bean.orderCatalogHeaderStr.get("order_category");

	order_type_code			=(String)bean.orderCatalogHeaderStr.get("order_type_code");
	  tpn_item_yn=bean.orderCatalogHeaderStr.get("tpn_item_yn")==null?"":(String)bean.orderCatalogHeaderStr.get("tpn_item_yn");
	if(tpn_item_yn.equals(""))
		tpn_item_yn=bean.checkForNull(request.getParameter("tpn_item_yn"));

	activity_type		=(String)bean.orderCatalogHeaderStr.get("activity_type");
	image_link_id		=bean.orderCatalogHeaderStr.get("image_link_id")==null?"":(String)bean.orderCatalogHeaderStr.get("image_link_id");
	indexed_yn		=bean.orderCatalogHeaderStr.get("indexed_yn")==null?"N":(String)bean.orderCatalogHeaderStr.get("indexed_yn");
	//security_level			=(String)bean.orderCatalogHeaderStr.get("security_level");


	if(module_id.equalsIgnoreCase("OR") && order_category.trim().equalsIgnoreCase("PH")){	//Not updatable if called from OR module for PH
	eff_status			    =(String)bean.orderCatalogHeaderStr.get("eff_status");
	eff_status_modify_Orginal = eff_status ;
	bean.orderCatalogHeaderStr.put("eff_status","D");
	}


	eff_status			    =(String)bean.orderCatalogHeaderStr.get("eff_status");

//System.out.println("#### eff_status="+eff_status);

	update_order_category_yn		="N";
	update_order_type_yn			="N";
	//update_activity_type_yn			="N";



	if(module_id.equalsIgnoreCase("PH")){//FOR PHARMACY	IN MODIFY MODE
			update_code_yn					="N";
			update_order_category_yn		="N";
			update_order_type_yn			="N";
			//update_activity_type_yn			="N";
			update_long_desc_yn				="N";
			update_short_desc_yn			="N";
			sql_order_category				="OrderCategoryOthers";
			sql_order_category_params		="PH";
	}

	if(eff_status.trim().equalsIgnoreCase("D")){
			update_code_yn					="N";
			update_order_category_yn		="N";
			update_order_type_yn			="N";
			//update_activity_type_yn			="N";
			update_long_desc_yn				="N";
			update_short_desc_yn			="N";
			//update_security_level_yn 		="N";
			image_link_id_Updateble			= "N";
			indexed_yn_updatable			= "N";
	}

	 if(module_id.equalsIgnoreCase("OR") && order_category.trim().equalsIgnoreCase("PH")){
			eff_status = eff_status_modify_Orginal ;
	 }



} //End of modify if Loop
//System.out.println("#### eff_status_modify_Orginal="+eff_status_modify_Orginal);
//System.out.println("#### order_category="+order_category);
//System.out.println("#### eff_status="+eff_status);
	/******************************************************************/
if(ot_module.equalsIgnoreCase("OT")){//For OT Surgery
	
		order_type_code = bean.checkForNull(request.getParameter("order_type"));
	}
	//System.out.println("order_type_code========15"+order_type_code);
	//added for skr-scf-1312
	System.out.println("short_desc-- "+short_desc);
	System.out.println("long_desc-- "+long_desc);

%>
<table align='center' cellpadding=2 cellspacing=0 border='0' width='100%'>


<tr>
	<td  class="label"   width="25%"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
	<!--<td colspan='3' class="fields"  width="25%"><input type=text name='order_catalog_code' id='order_catalog_code' size='20' onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this);"  maxlength="10"--><!--IN068370,IN068373-->
	<td class="fields"  width="25%" colspan="3"><input type=text name='order_catalog_code' id='order_catalog_code' size='20' onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this);"  maxlength="10"
	<%=eHISFormatter.chkReturn("y",update_code_yn,"","disabled")%>
	value="<%=order_catalog_code.trim()%>"
	><img src="../../eCommon/images/mandatory.gif" align='center'></img></td><!--IN06837,IN068373-->
	
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

<tr>
	<td  class="label" width="25%"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
	<td width="30%" class="fields"><input type=text name='long_desc' id='long_desc' size='30' maxlength='60' onBlur="makeValidString(this);"
	<%=eHISFormatter.chkReturn("y",update_long_desc_yn,"","disabled")%>
	value="<%=long_desc.trim()%>" ><img src="../../eCommon/images/mandatory.gif"  align='center'></img></td>

	<td  class="label" ><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
	<td class="fields" ><input type=text name='short_desc' id='short_desc' size='30'
	 maxlength='40' onBlur="makeValidString(this);parent.parent.defaultIntLowerFrame();" <%=eHISFormatter.chkReturn("y",update_short_desc_yn,"","disabled")%> value="<%=short_desc.trim()%>" ><img src="../../eCommon/images/mandatory.gif"  align='center'></img></td>
</tr>

<tr>
	<td  class="label"><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
	<td  id='order_category' class="fields" ><% if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ))){%><select  <%=eHISFormatter.chkReturn("Y",update_order_category_yn,"","disabled")%> name="order_category" onChange="parent.parent.fillComboOptions(this)">
	<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option><%=bean.getComboOptions("OrderCategory",order_category.trim(),"")%></select><img src="../../eCommon/images/mandatory.gif"></img>
	<%}else{%><select name="order_category" id="order_category" onChange="parent.parent.fillComboOptions(this)"	<%=eHISFormatter.chkReturn("Y",update_order_category_yn,"","disabled")%>
	><option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
<%=bean.getComboOptions(sql_order_category,order_category.trim(),sql_order_category_params.trim())%></select><img src="../../eCommon/images/mandatory.gif"  	align='center'></img>
	<%}

%>
</td>
<td  class="label" ><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
	<td  id='order_type_td' class="fields" ><% //System.out.println("#### mode ="+mode);
	if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )) {%><select name="order_type_code" id="order_type_code"	<%=eHISFormatter.chkReturn("Y",update_order_type_yn,"","disabled")%> onchange="parent.parent.fillComboOptions(this);parent.parent.defaultTabChar();parent.parent.display('C');" ><option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>	<%=bean.getComboOptions("OrderType",order_type_code.trim(),order_category.trim())%></select><img src="../../eCommon/images/mandatory.gif"  align='center'></img>
	<%}
	else if (ot_module.equals("OT"))
	{

	%><select name="order_type_code" id="order_type_code"	<%=eHISFormatter.chkReturn("Y",update_order_type_yn,"","disabled")%> onchange="parent.parent.fillComboOptions(this);parent.parent.defaultTabChar();parent.parent.display('C')" ><option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--- </option>	<%=bean.getComboOptions("OrderType",order_type_code.trim(),order_category.trim())%></select><img src="../../eCommon/images/mandatory.gif"  align='center'></img>
	

	<%
	}
	else if (oh_module.equals("OH"))
	{

	%><select name="order_type_code" id="order_type_code"	 onchange="parent.parent.defaultTabChar();parent.parent.display('C')" ><option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--- </option>	
	<%
			 out.println(bean.getComboOptions("OrderType","",order_category));
	%>
	</select><img src="../../eCommon/images/mandatory.gif"  align='center'></img>
	<%
	}
	else{
		%><select name="order_type_code"  id="order_type_code" onchange="parent.parent.fillComboOptions(this);parent.parent.defaultTabChar();parent.parent.display('C');displayLnkVaccine(this)" ><option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--- </option>
	<% 
		
		if(order_category.equals("PH"))
			
		sql_order_type = "SELECT A.ORDER_TYPE_CODE code,B.SHORT_DESC short_desc FROM PH_ORDER_TYPE_FOR_DRUG_CLASS A,OR_ORDER_TYPE_LANG_VW B WHERE A.ORDER_TYPE_CODE=B.ORDER_TYPE_CODE AND B.EFF_STATUS='E' AND A.DRUG_CLASS= '"+sql_order_type+"' AND B.LANGUAGE_ID ='"+localeName+"' ORDER BY 2 ";
		//if(bean.getComboOptions(sql_order_type,sql_order_type_default,"") != null && !bean.getComboOptions(sql_order_type,sql_order_type_default,"").equals(""))
		
		
		out.println(bean.getComboOptions(sql_order_type,sql_order_type_default,""))	;
	
	%></select><img src="../../eCommon/images/mandatory.gif"  align='center'></img>
	<%}%>
	</td>
</tr>

<tr><input type='hidden' name='security_level' id='security_level'  value=''>
<td  class="label" ><fmt:message key="eOR.ActivityType.label" bundle="${or_labels}"/></td>
	<td class="fields" id='activity_type_td' ><% if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )) {
	//String[] sqlparam=new String[];
	//String sqlparam=order_category.trim();
	String sqlparam1=order_category.trim();
	StringBuffer sqlparam= new StringBuffer();
	sqlparam.append(sqlparam1);
	//sqlparam+=","+order_type_code.trim();
	sqlparam.append(","+order_type_code.trim());
	//sqlparam+=","+order_category.trim();
	sqlparam.append(","+order_category.trim());
	
	//System.out.println("sql ActivityType======================="+sqlparam.toString());
	%><select name="activity_type" id="activity_type" <%=eHISFormatter.chkReturn("y",update_long_desc_yn,"","disabled")%>><option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>	<%=bean.getComboOptions("ActivityType",activity_type,sqlparam.toString())%></select>
	<%}else if(oh_module.equalsIgnoreCase("OH"))
	{
	%><select name="activity_type" id="activity_type" <%=eHISFormatter.chkReturn("y",update_activity_type_yn,"","disabled")%>><option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --- </option>
	</select>
	<%
	}
	else{%><select name="activity_type" id="activity_type" <%=eHISFormatter.chkReturn("y",update_long_desc_yn,"","disabled")%>><option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --- </option>
	</select>
	<%}%>
	</td>
	<%
		String image_link_style="visibility:visible";
	if(order_category.trim().equals("PH"))
		image_link_style="visibility:hidden";
	if(!order_category.trim().equals("PH")){	
		%>
		
	<td  class="label" name="image_link_lbl"  id="image_link_lbl" Style="<%=image_link_style%>" nowrap ><fmt:message key="eOR.BodyOrgan.label" bundle="${or_labels}"/></td>
	<td class="fields" name="image_link_td" id="image_link_td" Style="<%=image_link_style%>"><% if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )) {%><SELECT <%=eHISFormatter.chkReturn("y",image_link_id_Updateble,"","disabled")%> name="image_link_id" id="image_link_id"><option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>	<%=bean.getComboOptions("HotSpot",image_link_id,order_category.trim())%>
	</SELECT><%}else{%><SELECT <%=eHISFormatter.chkReturn("y",image_link_id_Updateble,"","disabled")%> NAME="image_link_id" id="image_link_id"><option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
	</SELECT><%}%>
	</td>
		<%}else if(order_category.trim().equals("PH") ){
		%>
			<td colspan="2">
			<!-- Added by Kishore Kumar N on Sept 07 for CRF 0691 -->
				<div name='divLinkedVanccineId' style='display:inline'>
					<table id='tblLinkedVanccineId' name='tblLinkedVanccineId' id='tblLinkedVanccineId' align='center' cellpadding=3 cellspacing=0 border='0' width='100%' <%if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) && !(order_type_code.equals("MS"))) {%> style='display:inline' <%}else{%>style='display:none' <%}%>>
						<td class="label" width='36%'><fmt:message key="eOR.LinkedVaccineName.label" bundle="${or_labels}"/></td>
						<td>
							<input type='text' value='<%=lnkVaccineName%>' name='txtLinkedVaccineId' id='txtLinkedVaccineId' Onblur ='showVaccineSearchBYText(this)' <%=readOnlyVaccineId%>><input type='button' value='?' name='btnLinkedVaccineId' id='btnLinkedVaccineId' onclick='showVaccineSearch()' <%=btnDisabled%> >
							<input type='hidden' name='hidLinkedVaccineId' id='hidLinkedVaccineId' value='<%=lnkVaccineId%>'>
						</td>
					</table>
				</div>
				
				<!-- ends here. -->

			</td>
		<%}%>

</tr><tr>
<%if(!order_category.equals("PH")){%><!-- THIS LINE ADDED BY CHANNAVEER B on 14/05/2010-->
<td  width='12%' class="label"><fmt:message key="eOR.Index.label" bundle="${or_labels}"/></td>

<td class="fields"  width=''><input type='checkbox' <%=eHISFormatter.chkReturn("y",indexed_yn_updatable,"","disabled")%> name='indexed_yn' value="<%=indexed_yn%>"  onClick="parent.parent.checkValue(this);" <%=eHISFormatter.ChkBoxChecked("y", indexed_yn)%> ></td>
<%}%> <!-- THIS LINE ADDED BY CHANNAVEER B -->

<td  class="label" ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
<td  colspan='3' class="fields">
<input type='checkbox' name='eff_status' id='eff_status'  <%=eHISFormatter.chkReturn(eff_status.trim(),"D","","checked") %>
 value='E'>
</td>
</tr>

</table>
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="qry_str" id="qry_str" value="<%=request.getQueryString()%>">
 	<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
 	<input type="hidden" name="module_id" id="module_id" value="<%=module_id.trim()%>">
 	<input type="hidden" name="eff_status_mod" id="eff_status_mod" value="<%=eff_status.trim()%>">
	<input type="hidden" name="ot_module" id="ot_module" value="<%=ot_module%>">
	<input type="hidden" name="oh_module" id="oh_module" value="<%=oh_module%>">
	<!-- Added by Kishore Kumar N on Sept 07 for CRF 0691 -->
	<input type="hidden" name="locale" id="locale" value="<%=locale%>">
	<input type="hidden" name="tpn_item_yn" id="tpn_item_yn" value="<%=tpn_item_yn%>"><!-- IN068926 -->

	<!--IN068370,IN068373, starts-->
	<!--IN069959, starts-->
	<!--<input type='hidden' name='applFacsMappedYn' id='applFacsMappedYn' value =''/>-->
	<input type='hidden' name='applFacsMappedYn' id='applFacsMappedYn' value ='<%=bean.getMappedFacilities().size()>0?"Y":""%>'/>
	<!--IN069959, ends-->
	<input type='hidden' name='globalFacilityYn' id='globalFacilityYn' value ='<%=bean.getGlobalFacilityYn()%>'/>
	<input type='hidden' name='siteSpecGlobalFac' id='siteSpecGlobalFac' value ='<%=bean.isSiteSpecific("ORDER_CATALOG_FAC_WISE")%>'/>
	<!--IN068370,IN068373, ends-->
	<!-- ends here. -->
	<%
	if(ot_module.equals("OT"))
	{
	%>
	<script>
			parent.parent.defaultTabChar();
			parent.parent.display('C');
	</script>
	<%
	}
	%>
 </form>

<%putObjectInBean(bean_id,bean,request); }catch(Exception e){
System.out.println("@@in orderCatalogAddModifyHeader.jsp ="+e);
e.printStackTrace();
}%>
</body>
</html>


