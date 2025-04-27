<!DOCTYPE html>
<%
/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
14/02/2017		IN060945			Badmavathi B						MMS-DM-CRF-0084 - FDA_CODE added
24/05/2017		IN063603			Badmavathi B						GHL-CRF-0456
04/07/2017		IN064396			Sharanraj Hebbal					AMS-CRF-0127  - HSN_NO added
05/07/2017		IN060124			SooryaPrakash M						GHL-CRF-0405
2/1/2019		IN069010			Sharanraj						GHL-CRF-0548.1
2/1/2019		IN068781			Shazana							GHL-CRF-0549.1
14/1/2019		IN069439			Shazana 						GHL-CRF-0549.1 - fixed for alignment issues 
20/5/2020		IN73000				Shazana							PH-MMS-Dispense Medication
09/08/2022		IN32744													TH-KW-CRF-0046
---------------------------------------------------------------------------------------------------------
*/ 
%> 
<%-- JSP Page specific attributes start --%> 
<%@page import="java.util.*, eMM.*, eMM.Common.*,eCommon.Common.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="obj"   scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<!-- <jsp:useBean id="obj6" scope="page" class="eMM.ItemMasterBean"/> -->
<head>
<% 
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086

		String locale			=		(String)session.getAttribute("LOCALE");
//		String primary_lang		=		(String)session.getAttribute("PRIMARY_LANG");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<!--<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<script language="JavaScript" src="../../eCommon/js/common.js"></script> <!--  Vaild String -->
<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script> <!-- Code arrest,Focus -->
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../eMM/js/MmCommon.js"></script> <!-- On key press,Uppercase -->
	<script language="JavaScript" src="../../eMM/js/Item.js"></script>
	<style>
textarea {
  resize: none;
}
</style>
<%
	/* Mandatory checks start */
	String mode						=		request.getParameter( "mode" ) ;
	String bean_id					=		"ItemMasterBean" ;
	String bean_name				=		"eMM.ItemMasterBean";
	String readOnly					=		"";
	String disabled					=		"";
	String item_remarks				=		"";
	String eff_status				=		"";
//@---
	//String direct_sale_allowed_yn	=		"";
	String direct_sale_allowed_chk	=		"checked";
	boolean direct_sale_allow_yn = false;//Added for GHL-CRF-0456
	boolean stock_is_available=false;// Added for GHL-CRF-0405  
	boolean site=false; // Added for AMS-CRF-0127
	boolean price_type_yn			= false; // Added for TH-KW-CRF-0046	
	//String material_group_code	=		"";
//	String p_unit_cost				=		"";
//	int	   unit_cost				=		0;

	String pr_based_checked			=		"";
	String ps_item_checked			=		"";
	String cssd_component_checked	=		"";
	String cssd_enable_disable		=		"";
	String ps_enable_disable		=		"";
	String cannot_modify			=		"";
	String cannot_modify_uom		=		"";
	String day_selected				=  "";
	String month_selected			=  "";
	String year_selected			=  "";
	ArrayList arr_lang				=		new ArrayList();
	//added for GHL-CRF-0549.1 STARTS
	String lowCost_item_checked			=		"";
	String highCost_item_checked			=		"";
	String innovator_item_checked			=	"";
	//added for GHL-CRF-0549 end
	arr_lang.add(locale);

	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
	/* Mandatory checks end */

	/* Initialize Function specific start */
	ItemMasterBean bean				=		(ItemMasterBean)getBeanObject( bean_id,bean_name,request ) ;
	bean.setLanguageId(locale);
	bean.clear() ;

	ServletContext context			=		getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	/* Initialize Function specific end */

	MmUtils objMmUtils				=			new MmUtils( bean.getProperties() );

	//Added for FD-AMS-CRF-0127 starts
	String HSNCodeVisibility ="visibility:hidden";
	Connection con				= null;

	//Added for GHL-CRF-0549.1 starts
	String item_type_visibility ="visibility:hidden";
	boolean site_specific = false;

	
	try
	{	
		con						= ConnectionManager.getConnection(request);
		site					= eCommon.Common.CommonBean.isSiteSpecific(con, "MM","MM_HSN_NO");
		System.out.println("Site==>"+site);
		bean.setIssite(site); // Added for AMS-CRF-0127
		if(site){
			HSNCodeVisibility = "visibility:visible";
        }

		site_specific = eCommon.Common.CommonBean.isSiteSpecific(con, "MM","MM_ITEM_TYPE");
		System.out.println("site_specific==>"+site_specific);
		bean.setIssiteSpecific(site_specific);  
		if(site_specific){
			item_type_visibility = "visibility:visible";
	    }

		price_type_yn			= eCommon.Common.CommonBean.isSiteSpecific(con, "MM","MM_ITEM_PRICE_TYPE"); // Added for TH-KW-CRF-0046	
		System.out.println("price_type_yn==>"+price_type_yn);
	}
	finally
	{
		if(con != null)
      		ConnectionManager.returnConnection(con,request);	
	}
	
	//Added for FD-AMS-CRF-0127 ends	
	ArrayList	arrSSIV				=			null;
	HashMap		hmSSIV				=			null;
	String	IV						=			"";
	String  SS						=			"";
	String  PO						=			"";
	String  mandatory_check			=			"";
	String in_po_disabled			=			"";
	String cat_disabled				=			"";
	String material_group_mandatory =			"Y";
	String billing_installed		=			"N";
	String billing_check_yn			=			"";
	String strPackItemYNCheck="checked";
	if(bean.getBLModuleInstalled().equals("Y")){
			billing_installed		=			"";
		}else
		{
			billing_installed		=			"disabled";
		}
	arrSSIV							=			bean.isSSIVModuleInstalled();
	int arrLen						=			arrSSIV.size();
	for(int i=0;i<arrLen; i++)
	{
		hmSSIV						=			(HashMap) arrSSIV.get(i);

		IV							=			(String)hmSSIV.get("IV");//"I" ; 
		SS							=			(String)hmSSIV.get("SS");  
		PO							=			(String)hmSSIV.get("PO");//"N";

		if( (!IV.trim().equals("I")) && (PO.trim().equals("N"))){
			in_po_disabled			 =			"disabled";
			material_group_mandatory =			"N";
		    bean.setCategoryCode("ST");
		}

		if((!IV.trim().equals("N"))&&SS.trim().equals("N")&& PO.trim().equals("N")){
			cat_disabled			 =			"disabled";
			bean.setCategoryCode("ST");
		}
		else if(IV.trim().equals("N")){
			cat_disabled			=			"disabled";
			bean.setCategoryCode("NS");
		}		
		
		if(SS.trim().equals("N"))
		{
			cssd_enable_disable		=			"disabled";
		}
		else if(SS.trim().equals("S") && IV.trim().equals("N"))
		{
			cssd_enable_disable		=			"disabled";
			cssd_component_checked	=			"checked";

		}

		if(IV.trim().equals("N"))
		{
			ps_enable_disable		=			"disabled";
		}
		else if(IV.trim().equals("P") && SS.trim().equals("N"))
		{	
			ps_enable_disable		=			"disabled";
			ps_item_checked			=			"checked";
		}
		else if(IV.trim().equals("P") && SS.trim().equals("S"))
		{
			mandatory_check			=			"mandatory";

		}

	}

	if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) )
	{


		bean.setItemCode(request.getParameter("item_code").trim());

		bean.loadData();

		if(bean.getBillableItemYN().equals("Y")){
			billing_check_yn		=			"checked";	
		}else{
			billing_check_yn		=			"";
		}

		bean.setSQLOperation(CommonRepository.getCommonKeyValue("MODE_MODIFY"),  MmRepository.getMmKeyValue("SQL_MM_ITEM_MASTER_UPDATE"));
		// pr_based_budget_yn		=			bean.getPrBudget();
		// if(pr_based_budget_yn.equals("Y"))
		// pr_based_checked			=			"checked";
			cannot_modify			=			"disabled";

		if(bean.getEffStatus().equals("E"))
		{
			readOnly				=			"";
			disabled				=			"";

		}
		else
		{
			readOnly				=			"readonly" ;
			disabled				=			"disabled" ;

		}
		if(bean.getPsItem().equals("Y"))
		{
			ps_item_checked			=			"checked";
		}
		else
		{
			ps_item_checked			=			"";
		}
		if(bean.getCSSDComponent().equals("Y"))
		{
			cssd_component_checked	=			"checked";
		}
		else
		{
			cssd_component_checked	=			"";
		}

//@ ---
		if(bean.getDirectSaleAllowedYN().equals("Y"))
		{
			direct_sale_allowed_chk	=			"checked";
		}
		else
		{
			direct_sale_allowed_chk	=			"";
		}
		//Added against GHL-CRF-0456 starts
		int count=Integer.parseInt((String)bean.fetchRecord("select count(*) count from st_item_store where item_code = ? and (sales_allowed_yn  is null or sales_allowed_yn ='Y')",bean.getItemCode()).get("COUNT"));//recheck it
		if(count>0)
			direct_sale_allow_yn = true;
		//Added against GHL-CRF-0456 ends

		//Added against GHL-CRF-0405 starts
		double cnt=Double.parseDouble(bean.checkForNull((String)bean.fetchRecord(bean.getMmRepositoryValue("SQL_MM_ITEM_TOT_QTY_ON_HAND"),bean.getItemCode()).get("SUM"),"0"));
		System.out.println("count value" + cnt);
		if(cnt>0)
			stock_is_available = true;
		//Added against GHL-CRF-0405 ends
		if(bean.getUOM()==null)
		{
			cannot_modify_uom		=			"enabled";
		}
		else
		{
			cannot_modify_uom		=			"disabled";
		}

		
	   if(bean.getPackageItemYN().equals("Y")){
			strPackItemYNCheck		=			"checked";	
		}else{
			strPackItemYNCheck		=			"";
		}
	   	   
	   //added for GHL-CRF-0549.1 starts
	   
	   if(site_specific){
		   if (bean.getLowCostItem()==null){
			   bean.setLowCostItem("N");
		   }
		   if (bean.getHighCostItem()==null){
			   bean.setHighCostItem("N");
		   }
		   if (bean.getInnovatorItem()==null){
			   bean.setInnovatorItem("N");
		   }
		   if(bean.getLowCostItem().equalsIgnoreCase("Y")){
	   			lowCost_item_checked = "checked";
		   }
		   else{
			   lowCost_item_checked = "";
		   }
		   
		   if(bean.getHighCostItem().equalsIgnoreCase("Y")){
	   			highCost_item_checked = "checked";
		   }
		   else{
			   highCost_item_checked = "";
		   }
		   
		   if(bean.getInnovatorItem().equalsIgnoreCase("Y")){
	   			innovator_item_checked = "checked";
		   }
		   else{
			   innovator_item_checked = "";
		   }
		   
	   }//added for GHL-CRF-0549.1 ends
	}
			
       String item_desc =HTMLencode(bean.getLongDesc());
	   String short_desc =HTMLencode(bean.getShortDesc());

			/* @Name - Priya
			* @Date - 11/05/2010
			* @Inc# - 
			* @Desc - To check whether to display the 'Pakage Item' or not by calling the FUNCTION bl_package_enabled_yn
			*/
	   String packageItemVisibility ="visibility:hidden";
	   if((bean.getBLPackageEnabledYN()).equals("Y")){
			 packageItemVisibility = "visibility:visible";
	   }
	if(bean.getShelf_life_time().equals("D"))
		day_selected = "selected";
	else if(bean.getShelf_life_time().equals("M"))	
		month_selected = "selected";
	else if(bean.getShelf_life_time().equals("Y"))		
		year_selected = "selected";
%>

</head>
<body onLoad="FocusFirstElement()">
<form name="item_master_form1" id="item_master_form1" method="post">
<table  border="0" cellpadding="0" cellspacing="0" width='100%' align=center>
<tr><td>
<table  border="0" cellpadding="0" cellspacing="0" width='100%' align=center>
	<tr >
		<td colspan='7'>&nbsp;</td>
		<tr height='25'>
		<td  class="label" ><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
      	<td class="fields"   ><input type="text" name="item_code" id="item_code" size="20" maxlength="20" value="<%=bean.getItemCode()%>"   <%=(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") )?"disabled":"")%>
		onKeyPress="return KeyPressSpecCharsItemCode(event)" onBlur="CheckForSpecCharAlphaCode(this);convertToUpperCase(this);">&nbsp;
		<img src="../../eCommon/images/mandatory.gif"></img>
		
		</td>
		<td  class="label"  nowrap><fmt:message key="eMM.ItemAlphaCode.label" bundle="${mm_labels}"/>&nbsp;&nbsp;</td>
		<td class="fields"    ><input type="text" name="alpha_code" id="alpha_code" class="UPPER" value="<%=bean.getAlphaCode()%>" size="10" maxlength="10"  <%=readOnly%> onKeyPress="return KeyPressSpecCharsAlphaCode(event)" onBlur="CheckForSpecCharAlphaCode(this)"<%=(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") )?"disabled":"")%> >
		<!---->
		<img src="../../eCommon/images/mandatory.gif" ></img>
		</td>
		
		<td class="label"><span style="<%=HSNCodeVisibility%>"><fmt:message key="eMM.HSNCode.label" bundle="${mm_labels}"/>&nbsp;&nbsp;</td> <!-- Added for AMS-CRF-0127 -->
		<td class="fields"><span style="<%=HSNCodeVisibility%>"><input type="text" name="hsn_no" id="hsn_no"  value="<%=bean.getHsnNo()%>"   maxlength="20" onKeyPress="return KeyPressSpecCharsHSNCode(event)"     <%=(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") )?"disabled":"")%> > <img src="../../eCommon/images/mandatory.gif" ></img>
		</td> <!-- Added for AMS-CRF-0127 -->
	 </tr>
	 <tr height='30'>
		  <td  class="label" ><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		  <td class="fields"    colspan='6'><input type="text" name="short_desc" id="short_desc" value='<%=short_desc%>' size="70" maxlength="60" <%=disabled%> onKeyPress="return KeyPressSpecCharsItemDescCode(event);" onBlur="CheckForSpecCharAlphaCodeForDesc(this);" ><!-- added for 73000  -->
		  <img src="../../eCommon/images/mandatory.gif" ></img>
		  <input type=button name="similar_item" id="similar_item" value='<fmt:message key="eMM.ShowSimilarItems.label" bundle="${mm_labels}"/>'  onclick="view_similar_items(short_desc)" class="BUTTON">
		 
 	 </tr>
	 <tr height='30'>
		 <td  class="label"  ><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
      	 <td class="fields"    colspan='3'><input type="text" name="long_desc" id="long_desc" value='<%=item_desc%>' size="70" maxlength="60" <%=disabled%> onKeyPress="return  KeyPressSpecCharsItemDescCode(event);" onBlur="CheckForSpecCharAlphaCodeForDesc(this);">&nbsp;<img src="../../eCommon/images/mandatory.gif" ></img> <!-- added for 73000 -->
		 </td><td class="label"></td><td class="label"></td><td class="label"></td>
	  </tr>


     <tr height='30'>
		 <!-- <%
		  if(item_remarks==null) item_remarks="";
		  if(item_remarks.equals("")) item_remarks="";
		  item_remarks.trim();
		 %> -->
		   <td  class="label"  valign='top'><fmt:message key="eMM.ItemRemarks.label" bundle="${mm_labels}"/>&nbsp;&nbsp;</td>
		   <td class="fields"   colspan='3' ><textarea   name="item_remarks" rows='2' cols='61' <%=disabled%>
		  onKeyPress="checkMaxLimit(this,120);" onBlur="SPCheckMaxLen('Item Remarks',this,120);" onpaste="checkMaxLengthPaste(this,120)"><%=bean.checkForNull(bean.getRemarks())%></textarea>&nbsp;
		  </td><td class="label"></td><td class="label"></td><td class="label"></td>
	 </tr>
	 <!-- <tr height='30'>
	       <td  class="label"  valign='top'>Item Specification&nbsp;&nbsp;</td>
		   <td class="label"   colspan='3'   ><textarea   name="item_specification" rows='2' cols='61' <%=disabled%>><%=bean.getSpecification()%></textarea>
		  </td>
	 </tr> -->
	 <tr height='25'>
	      <td  class="label" ><fmt:message key="eMM.CategoryType.label" bundle="${mm_labels}"/>&nbsp;&nbsp;</td>
		  <td class="fields" >
		  <%if(eff_status.equals("D"))
			{
			%>
				<input type='hidden' name='category_type_code' id='category_type_code' value="<%=bean.getCategoryCode()%>">
				<select name="category_type_code1" id="category_type_code1"  disabled <%=cannot_modify%> >
				<option value='' >&nbsp;&nbsp;&nbsp----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----&nbsp;&nbsp;&nbsp</option>
				<option value='ST' <%if(bean.getCategoryCode().trim().equals("ST")) out.print("selected");%>><fmt:message key="Common.Inventory.label" bundle="${common_labels}"/></option>
				<option value='NS' <%if(bean.getCategoryCode().trim().equals("NS")) out.print("selected");%>><fmt:message key="eMM.Non-Inventory.label" bundle="${mm_labels}"/></option>
				</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
		<%	}
			else
			{%>
				<select name="category_type_code" id="category_type_code"  <%=disabled%>  <%=cannot_modify%> <%=cat_disabled%>>
				<option value='' <%if(bean.getCategoryCode().trim().equals("")) out.print("selected");%>>&nbsp;&nbsp;&nbsp----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----&nbsp;&nbsp;&nbsp</option>
				<option value='ST' <%if(bean.getCategoryCode().trim().equals("ST")) out.print("selected");%>><fmt:message key="Common.Inventory.label" bundle="${common_labels}"/></option>
				<option value='NS' <%if(bean.getCategoryCode().trim().equals("NS")) out.print("selected");%>><fmt:message key="eMM.Non-Inventory.label" bundle="${mm_labels}"/></option>
				</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
			<%
			}%>
				</td>
				<td  class="label"  valign='top' >
				<a href='javascript:callTextBox();'  <%=disabled%>><fmt:message key="eMM.ItemSpecification.label" bundle="${mm_labels}"/>&nbsp&nbsp</a></td>
				<td class=fields >&nbsp;<input type="hidden" name='item_specification' id='item_specification' value="<%=bean.getSpecification()%>">
				
				</td> 
				<td class="label"></td><td class="label"></td><td class="label"></td>
				<!-- <td  class="label"  >PR Based Budget&nbsp;&nbsp;</td>
				<td  align="left"  class="label" colspan='2' ><input type="checkbox" id='pr_based_budget_yn' value="Y" <%=pr_based_checked%> ></td>  -->
	</tr>
	<!-- </table>CSSD Component
	<table  border="0" cellpadding="0" cellspacing="0" width='96%'> -->
	<tr height='25'>
			<td   class='label' colspan=6>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eMM.PharmacyStockItem.label" bundle="${mm_labels}"/>&nbsp;&nbsp; &nbsp;&nbsp;
			<input type='checkbox' name='ps_item_yn' id='ps_item_yn' value="Y" <%=ps_item_checked%> <%=ps_enable_disable%>  <%=disabled%> <%=cannot_modify%>>
			&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eMM.CSSDComponent.label" bundle="${mm_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='checkbox' name='cssd_component_yn' id='cssd_component_yn' value="Y" <%=cssd_component_checked%> <%=cssd_enable_disable%>  <%=disabled%> <%=cannot_modify%> >
			<% if (!in_po_disabled.equals("disabled"))
			{
			%>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<fmt:message key="eMM.MaterialGroup.label" bundle="${mm_labels}"/>	&nbsp;&nbsp;<select name="material_group_code" id="material_group_code" <%=in_po_disabled%>>
		<%=objMmUtils.getListOptions(MmRepository.getMmKeyValue("SQL_MM_MATRIALS_GROUP_CODE_DESC"),arr_lang,bean.getMaterialCode(),locale)%> 
		</select>
			<%if(material_group_mandatory.equals("Y")){%>
				<img src="../../eCommon/images/mandatory.gif"></img>
			<%
				}
			}
			%>
			<!-- GHL-CRF-0548.1 , modified for 69437 -->
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<fmt:message key="eMM.ItemTechName.label" bundle="${mm_labels}"/>&nbsp;&nbsp;
			<input type='text' id="Item_Tech_Desc" name="Item_Tech_Desc" id="Item_Tech_Desc" value="<%=bean.checkForNull((String)bean.getItemTechDesc())%>" maxLength='15' size='26' <%=disabled%> ><!-- added 'id' for 69437-->
			<input type='button' class='BUTTON' value='?'
			onClick="searchItemTech(Item_Tech_Code,Item_Tech_Desc);" <%=disabled%>><!-- modified for 69437-->
			<input type="hidden" name="Item_Tech_Code" id="Item_Tech_Code" value="<%=bean.getItemTechCode()%>"> <!-- modified for 69437 -->
			
			</td>
			
			<!-- GHL-CRF-0548.1 -->
			
	</tr>
	<tr height='25'> <!-- modified for 69439 -->
		<TD class="label"   width='19%' nowrap><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/>&nbsp;&nbsp;</TD>
		<td class="fields" ><SELECT name='item_class_code' id='item_class_code' onChange="" <%=disabled%> >
		<%=	objMmUtils.getListOptions( MmRepository.getMmKeyValue("SQL_MM_ITEM_MASTER_CLASS"),arr_lang,bean.getItemClass(),locale)%>
		</SELECT>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
		</TD>
		<td   class="label" ><fmt:message key="Common.UnitCost.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td class="fields"  >
		<input type='text' id='unit_cost' class='number' size='19' maxlength='19' name='unit_cost' id='unit_cost' value="<%=bean.setNumber(bean.getUnitCost(),3)%>" <%=disabled%> readonly ></td><td class="label"></td><td class="label"></td><td class="label"></td>
	</tr>
	
	<%
	if(site_specific){
	%>
	<!-- added for GHL-CRF-0549.1 START -->
	<tr height='25' > <!-- modified for 69439 -->
			<td  class="label" ><span style="<%=item_type_visibility%>"><fmt:message key="eMM.ItemType.label" bundle="${mm_labels}"/> </td> 
			<td  class="label" ><span style="<%=item_type_visibility%>"><fmt:message key="eMM.LowCostItem.label" bundle="${mm_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;
			<span style="<%=item_type_visibility%>"><input type="checkbox" name="lowcost_item" id="lowcost_item"  onclick="checkItemTypeLowCost(this);" value="Y" <%=lowCost_item_checked%>  <%=disabled%>></td> <!-- modified for 69437-->

			<td  class="label"  ><span style="<%=item_type_visibility%>"><fmt:message key="eMM.HighMarginItem.label" bundle="${mm_labels}"/> &nbsp;&nbsp;&nbsp;&nbsp;
			<span style="<%=item_type_visibility%>"><input type="checkbox" name="highcost_item" id="highcost_item" onclick="checkItemTypeHighCost(this);" value ="Y" <%=highCost_item_checked%>  <%=disabled%>></td> <!-- modified for 69437-->
	
			<td  class="label"  ><span style="<%=item_type_visibility%>"><fmt:message key="eMM.InnovatorItem.label" bundle="${mm_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;
			<span style="<%=item_type_visibility%>"><input type="checkbox" name="innovator_item" id="innovator_item" onclick="checkItemTypeInnovator(this);" value="Y" <%=innovator_item_checked%>  <%=disabled%>></td> <!-- modified for 69437-->
	</tr> 
	<% } %>
	<!-- added for GHL-CRF-0549.1 END -->
	
	
	<tr height='25'> <!-- modified for 69439 -->
		<td  class="label"><fmt:message key="Common.uom.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td class=fields><select name="gen_uom_code" id="gen_uom_code" <%=disabled%> <%=cannot_modify_uom%>><option value="">&nbsp;&nbsp;&nbsp;-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;&nbsp;</option>
		<%
			ArrayList	arrUOM				=	null;
			HashMap		hmUOM				=	null;
			String code = "",	desc		=	"";
			String uom_select				=	"";

			arrUOM =	bean.getUomList();
			int arrLength					=	arrUOM.size();
			for(int i=0;i<arrLength; i++)
			{

				hmUOM						=	(HashMap) arrUOM.get(i);
				code						=	(String)hmUOM.get("code");
				desc						=	(String)hmUOM.get("desc");
				if(code.trim().equals(bean.getUOM()))
				{
					uom_select				=	"Selected";
				}
				else
					uom_select				=	"";

				%>
					<option value="<%=code%>" <%=uom_select%> ><%=desc%></option>
				<%
			}
			%>
			</select>&nbsp;<img  src='../../eCommon/images/mandatory.gif'></img></td>
			<td   class='label'><fmt:message key="eMM.BillableItem.label" bundle="${mm_labels}"/>&nbsp;&nbsp;</td>
			<td   class='fields'>
			<input type='checkbox' name='billable_yn' id='billable_yn' value="Y" <%=billing_installed%> <%=billing_check_yn%> onClick="setBill_yn(billable_yn)">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<span style="<%=packageItemVisibility%>"><fmt:message key="eST.PackageItem.label" bundle="${st_labels}"/>&nbsp;&nbsp;
			
			<input type='checkbox' name='package_item_yn' id='package_item_yn' value="Y"  <%=strPackItemYNCheck%>   <%=disabled%> ></span></td><td class="label"></td><td class="label"></td>
			
		</tr>
<tr height='25'> <!-- modified for 69439 -->
	<td class="label"><fmt:message key="eMM.ShelfLife.label" bundle="${mm_labels}"/></td>
		<td class="fields"><input type='text' class=NUMBER size='5' onKeyPress="return isValidInteger();" onBlur="checkIntegerFormat(this);" maxlength='3' name="shelf_life_no" id="shelf_life_no" value="<%=bean.getShelf_life_no()%>" >
			<select name="shelf_life_time" id="shelf_life_time">
				<option value="M" selected <%=month_selected%>>Months</option>
				<option value="D" <%=day_selected%>>Days</option>
				<option value="Y" <%=year_selected%>>Years</option>
			</select>
		</td>
<td class='label'><fmt:message key="eMM.DirectSalesAllowed.label" bundle="${mm_labels}"/></td>
 <td class='fields'>
<input type='checkbox' name='direct_sale_allowed_yn' id='direct_sale_allowed_yn' value="Y" <%=direct_sale_allowed_chk%> onclick="checkDirectSalesAllowed(this)" > <!-- Added for GHL-CRF-0456  -->
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>&nbsp;&nbsp;
			
<input type='checkbox' name='eff_status' id='eff_status' value="E" <%=(readOnly.equals("")?"checked":"")%> onclick="checkItemIsEmpty(this)"><!-- Added for GHL-CRF-0405  -->
</td>

<td colspan='2'>&nbsp;</td>
</tr>
<%
System.err.println("bean.getPriceType()"+bean.getPriceType()+"bean.getBillableItemYN()"+bean.getBillableItemYN());
%>
<% if(price_type_yn) { %>
<tr><td colspan='2'>&nbsp;</td>
	<td class="label"><fmt:message key="eMM.PriceType.label" bundle="${mm_labels}"/></td>
	<td class="fields">
		<% if(bean.getBillableItemYN().equals("") || bean.getBillableItemYN().equalsIgnoreCase("N")) { %>
				<select name="price_type" id="price_type" disabled>
				<option value=''>&nbsp;&nbsp;&nbsp-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;&nbsp</option>
		<% } else { %>
			<select name="price_type" id="price_type" >
			<option value='B' <%if(bean.getPriceType().trim().equals("B") || bean.getPriceType().trim().equals("")) out.print("selected");%>><fmt:message key="eMM.BatchPrice.label" bundle="${mm_labels}"/></option>
			<option value='G' <%if(bean.getPriceType().trim().equals("G")) out.print("selected");%>><fmt:message key="eMM.GlobalPrice.label" bundle="${mm_labels}"/></option>
		<% } %>
		</select>
	</td>
	<td colspan='2'>&nbsp;</td>
</tr>
<% } else { %> 
	<tr><td colspan='7'>&nbsp;</td></tr>
<% } %>
<tr><td colspan='7'>&nbsp;</td>
		<!-- <tr height='20'>
			<td   class='label'>Enabled&nbsp;&nbsp;</td>
			<td   class='label'>
			<input type='checkbox' name='eff_status' id='eff_status' value="E" <%=(readOnly.equals("")?"checked":"")%> ></td>
			<td colspan='2'></td>
		</tr>   -->
		<TR height='20'>
			<TD COLSPAN=7>&nbsp;</TD>
		</TR>
	</table>
	</td></tr>
	</table>
	<input type="hidden" name="mode" id="mode"						value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id"						value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name"					value="<%= bean_name %>">
	<input type="hidden" name="sole_source_yn" id="sole_source_yn"				value="">
	<input type="hidden" name="curr_supp_code" id="curr_supp_code"				value="">
	<input type="hidden" name="special_item_yn" id="special_item_yn"				value="">
	<input type="hidden" name="imported_item" id="imported_item"				value="">
	<input type="hidden" name="reimbursable_item_yn" id="reimbursable_item_yn"		value="">
	<input type="hidden" name="essential_item" id="essential_item"				value="">
	<input type="hidden" name="reimburse_type" id="reimburse_type"				value="">
	<input type="hidden" name="material_group_mandatory" id="material_group_mandatory"	value="<%=material_group_mandatory %>">
	<input type="hidden" name="current_cost_date" id="current_cost_date"			value="">
	<input type="hidden" name="last_cost_date" id="last_cost_date"				value="">
	<input type="hidden" name="next_last_cost_date" id="next_last_cost_date"			value="">
	<input type="hidden" name="last_receipt_date" id="last_receipt_date"			value="">
	<input type="hidden" name="item_anal1_code" id="item_anal1_code"				value="">
	<input type="hidden" name="item_anal2_code" id="item_anal2_code"				value="">
	<input type="hidden" name="item_anal3_code" id="item_anal3_code"				value="">
	<input type="hidden" name="manufacturer_id" id="manufacturer_id"				value="">
	<input type="hidden" name="mandatory_check" id="mandatory_check"				value="<%=mandatory_check%>">
	<input type="hidden" name="function_id" id="function_id"					value="<%=bean.getFunctionId()%>">
	<input type="hidden" name="SQL_MM_ITEM_LOOKUP" id="SQL_MM_ITEM_LOOKUP"			value="<%= bean.getMmRepositoryValue("SQL_MM_ITEM_LOOKUP")%>">
	<input type="Hidden" name="from_query_or_create" id="from_query_or_create"		value="create">
<!--<input type="hidden" name="last_pur_advice_date" id="last_pur_advice_date"		value=""> -->
<!--<input type="hidden" name="pur_gen_uom_conv" id="pur_gen_uom_conv"			value="">
	<input type="hidden" name="qty_on_order" id="qty_on_order"				value=""> -->
	<input type="Hidden" name="place_of_origin" id="place_of_origin"		value="">
	<input type="hidden" name="fda_code" id="fda_code"		value=""><!-- Added for MMS-DM-CRF-0084 -->
<input type="hidden" name="direct_sale_allow_yn" id="direct_sale_allow_yn"		value="<%=direct_sale_allow_yn%>"><!-- Added for GHL-CRF-0456 -->
<input type="hidden" name="stock_is_available" id="stock_is_available"		value="<%=stock_is_available%>"><!-- Added for GHL-CRF-0405  -->
<input type="hidden" name="site" id="site"						value="<%=site%>"><!-- Added for AMS-CRF-0127 -->
<input type="hidden" name="SQL_MM_ITEM_TECH_NAME" id="SQL_MM_ITEM_TECH_NAME" value="<%= bean.getMmRepositoryValue("SQL_MM_ITEM_TECH_NAME")%>"> <!-- Sharanraj GHL-CRF-0548.1-->
<input type="hidden" name="language_id" id="language_id" value="<%=locale%>"> <!-- sharanraj  GHL-CRF-0548.1-->
<input type="hidden" name="site_specific" id="site_specific" value="<%=site_specific%>"><!-- Added for GHL-CRF-0549.1 -->
<input type="hidden" name="price_type_yn" id="price_type_yn" value="<%=price_type_yn%>"><!-- Added for TH-KW-CRF-0046-->
<input type="hidden" name="category_code1" id="category_code1"		value="">			 <!-- Added for MMS-DM-CRF-0209.2 -->
<input type="hidden" name="alternate" id="alternate"		value="">                <!-- Added for MMS-DM-CRF-0209.2 -->
<input type="hidden" name="site_cat_alt" id="site_cat_alt"	value="">                <!-- Added for MMS-DM-CRF-0209.2 -->
</form>
<%
	putObjectInBean(bean_id,bean,request);
%>
<%!
	//Added By Ramana CV For Handling the SPL CHARS
	public static String HTMLencode(String desc){
		StringBuffer item_desc = new StringBuffer(desc.trim()); 
		for (int i=0; i<item_desc.length(); ++i) {
            char c = item_desc.charAt(i);
            if (c == '<') {
                item_desc.replace(i,i+1,"&lt;");
                i += 3;
            } else if (c == '>') {
                item_desc.replace(i,i+1,"&gt;");
                i += 3;
            } else if (c == '\"') {
                item_desc.replace(i,i+1,"&quot;");
                i += 5;
            }else if(c=='\''){
		               item_desc.replace(i,i+1,"&#039");
                i += 6;
						  
		    }
        }
		return item_desc.toString();
		}
%>
</body>
<script>
parent.item_class_detail.location.href="../jsp/AddModifyItem2.jsp?<%=request.getQueryString()%>"

</script>

</html>

