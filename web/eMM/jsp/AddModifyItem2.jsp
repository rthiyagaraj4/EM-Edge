<%
/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
14/02/2017		IN060945			Badmavathi B						MMS-DM-CRF-0084 - FDA_CODE added
10/08/2018      IN068462            Haribabu B                          MMS-DM-CRF-0144.1 - FDA_CODE Length modified
---------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.util.*,eMM.*,eMM.Common.*,eCommon.Common.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="obj"   scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%@include file ="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

 
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options","nosniff"); //MMS-ME-SCF-0086

		String locale			= (String)session.getAttribute("LOCALE");

//		String primary_lang		= (String)session.getAttribute("PRIMARY_LANG");
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<script language="JavaScript" src ="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"> </script>
	<script language="JavaScript" src="../../eMM/js/Item.js"></script>
	<script language="JavaScript" src="../../eMM/js/MmCommon.js"></script>
	<script language="JavaScript" src="../../eMM/js/MasterCodeList.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<!-- <script language="JavaScript" src="../js/MmMessages.js"></script> -->
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	</script>
</head>
<body onload="changeManu()">
<%
String mode						=	"";
String bean_id					=	"";
String bean_name				=	"";
String disabled					=	"";
String supplier_disabled="";
//String checked					=	"";
String readOnly					=	"";
//String facility_id				=	"";
//String codeReadOnly				=	"";
String checked_sole_source_yn	=	"";
String checked_special_item_yn	=	"";
String checked_imported_item	=	"";
String checked_essential_item	=	"";
String checked_reimbursable_item_yn	=	"";
//String supp_status				=	"";
String soleSource_disabled		=	"";
String manufacturer_disabled	=	"";
String disable					=	"disabled";
String ReimburseType ="";
String category                 =	""; //Added for MMS-DM-CRF-0209.2
String alternate                =	""; //Added for MMS-DM-CRF-0209.2
String alternate_disabled      =   "disabled";		 //Added for MMS-DM-CRF-0209.2
		
		
ArrayList arr_lang=new ArrayList();
arr_lang.add(locale);
//facility_id  =  (String) session.getValue( "facility_id" ) ;
  
String code=request.getParameter("item_code");

mode				=	request.getParameter("mode");
bean_id				=	"itemMasterBean" ;
bean_name			=	"eMM.ItemMasterBean";

if ( mode == null || mode.equals("") ) 
		return ;
//if ( !(mode.equals( CommonInterface.MODE_MODIFY ) || mode.equals( CommonInterface.MODE_INSERT )) )
//		return ;

ItemMasterBean bean = (ItemMasterBean)getBeanObject(bean_id,bean_name,request);
bean.setLanguageId(locale);
bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));	
if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")))
bean.clear();
//out.println("mode"+mode);
bean.setMode(mode);
MmUtils objMmUtils	=	new MmUtils( bean.getProperties() );

//Added for MMS-DM-CRF-0084 starts
	String fdaCodeVisibility ="visibility:hidden";
	Connection con				= null;
	con						= ConnectionManager.getConnection(request);
	boolean site = eCommon.Common.CommonBean.isSiteSpecific(con, "MM","MM_SFDA_CODE");
	boolean site_cat_alt =eCommon.Common.CommonBean.isSiteSpecific(con, "MM","MM_ITEM_CATE_ALTERNATE");//Added for MMS-DM-CRF-0209.2  
	//site_cat_alt =true;	
	if(site){
	fdaCodeVisibility = "visibility:visible";
}
//Added for MMS-DM-CRF-0084 ends
//out.println("bean.isAPModuleInstalled()"+bean.isAPModuleInstalled());
if (bean.isAPModuleInstalled())
	{
		
//		supp_status = "enabled";
	
	}
	else
	{
//		supp_status= "disabled";
		
		
	
		
	}
//out.println("supp_status"+supp_status);

if(mode.equals(CommonRepository.getCommonKeyValue( "MODE_MODIFY")) )
{
	
	bean.setItemCode(request.getParameter("item_code").trim());
	bean.loadData();	
	if(bean.checkForNull((String)bean.getSupplierCode()).equals(""))
	{
		supplier_disabled="";
	}
	else
	{
supplier_disabled="disabled";
	}
	if (bean.getEffStatus().equals("E"))
	{
	//	checked = "CHECKED";
	}
	else
	{
//		checked			=	"";
		readOnly		=	" readOnly ";
		disabled		=	" disabled ";
	
	}
//	codeReadOnly =" readOnly ";
	
	if(bean.getSoleSource().equals("Y")) 
	{
		checked_sole_source_yn	=	"CHECKED";
	}
	if(bean.getSpecialItem().equals("Y")) 
	{
		checked_special_item_yn	=	"CHECKED";
	}
	if(bean.getImportedItem().equals("Y")) 
	{
		checked_imported_item	=	"CHECKED";
	}
	if(bean.getEssentialItem().equals("Y")) 
	{
		checked_essential_item	=	"CHECKED";
	}
	if(bean.getReimbursableItemYN().equals("Y")) 
	{
		checked_reimbursable_item_yn	=	"CHECKED";
		disable	= "";
	}
	ReimburseType = bean.getReimburseType();

	if (bean.isModuleInstalled("ST") && bean.isSTItem()) {
		soleSource_disabled="disabled" ;
	}
	manufacturer_disabled="disabled" ;
}
else
{
//	checked = "CHECKED";
}
%>
<form name="item_master_form2" id="item_master_form2">     
<!-- <table border='0' cellpadding='0' cellspacing='0' width='96%'  align='center'>
	<tr><td align='left' class='label'>
		<a  name="tab1" id="tab1"></a><img  src="../images/Transaction_Characteristic.gif" border=0><a align='left' href="javascript:tab8.scrollIntoView();"><img  src="../images/Item Characteristics_click.gif" border=0></a>
		</td>
	</tr>
</table> -->
	
<table border='0' cellpadding='0' cellspacing='0' width='96%' align=center>
	<TR><TD COLSPAN=4>&nbsp;</TD></TR>
	
	<tr height='30'>
		<td  class="label" ><fmt:message key="Common.SoleSource.label" bundle="${common_labels}"/></td>    
		<td   class='fields'>&nbsp;&nbsp;<input type='checkbox' name='sole_source_yn' id='sole_source_yn' <%=checked_sole_source_yn%> value='Y'  onclick="changeManu()" <%=soleSource_disabled%> >	
		</td>
		<td  class="label"  ><fmt:message key="Common.Manufacturer.label" bundle="${common_labels}"/></td>
		<td class=fields>&nbsp;&nbsp;<select name="manufacturer_id" id="manufacturer_id"  <%=manufacturer_disabled%> ><option value="">&nbsp;&nbsp;&nbsp;-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;&nbsp;</option>
		<%
			ArrayList	arrManu				=	null;
			HashMap		hmManu				=	null;	
			//String code = "",	
			String	desc  = "";
			String Manu_select				=	"";

			arrManu =	bean.getManufacturerList();
			int arrLength	=	arrManu.size();
			for(int i=0;i<arrLength; i++)
			{
				hmManu		=	(HashMap) arrManu.get(i);

				code				=	(String)hmManu.get("code");
				desc				=	(String)hmManu.get("desc");
				if(code.trim().equals(bean.getManufacturer()))
				{
					Manu_select		=	"Selected";
				}
				else
					Manu_select		=	"";

				%>
					<option value="<%=code%>" <%=Manu_select%> ><%=desc%></option>
				<%
			}
			%>
			</select>&nbsp;<img align='center' id='span2' style="visibility:hidden" src='../../eCommon/images/mandatory.gif'></img></td>

		
		

		</td>
	</tr>
	<tr height='30'>
			<td  class="label" ><fmt:message key="Common.SpecialItem.label" bundle="${common_labels}"/></td>
			<td    class="fields">&nbsp; <input type="checkbox" name="special_item_yn" id="special_item_yn" value="Y"  <%=checked_special_item_yn%> <%=disabled%> >  &nbsp;</td> 
			</td>
			<td  class="label"  ><fmt:message key="Common.Supplier.label" bundle="${common_labels}"/></td>
	<!-- 	<td class="label" align='left'   >&nbsp;
			<select name='curr_supp_code' id='curr_supp_code' <%=disabled%> >
			</select>&nbsp<img src='../../eCommon/images/mandatory.gif' align='center'></img> -->
			<td class=fields>&nbsp;&nbsp;<input type='text' name="curr_supp_desc" id="curr_supp_desc" value="<%=bean.checkForNull((String)bean.getSupplierDesc())%>" maxLength='15' size='15' <%=disabled%> readonly><input type='button' class='BUTTON' value='?' 
			onClick="searchSupplier(curr_supp_code,curr_supp_desc);" <%=supplier_disabled%><%=disabled%>><input type="hidden" name="curr_supp_code" id="curr_supp_code" value="<%=bean.getSupplierCode()%>"></td>
			
	</tr>
	<tr height='30'>	
			<td  class="label"  nowrap><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/>  1</td>
			<td class="fields"    >&nbsp;
			<SELECT name='item_anal1_code' id='item_anal1_code' onChange="" <%=disabled%> > 
			<%=	objMmUtils.getListOptions( MmRepository.getMmKeyValue("SQL_MM_ITEM_MASTER_ANALYSIS"),arr_lang,bean.getItemAnal1Code(),locale)%>
			</SELECT>
			</td>
		  
			<td  class="label"  nowrap><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/>  2</td>
			<td class="fields"    >&nbsp;		
			<SELECT name='item_anal2_code' id='item_anal2_code' onChange="" <%=disabled%> >
			<%=	objMmUtils.getListOptions( MmRepository.getMmKeyValue("SQL_MM_ITEM_MASTER_ANALYSIS"),arr_lang,bean.getItemAnal2Code(),locale)%>
			</SELECT>	
			</TD>
		
			
	</tr>
	<tr height='30'>
			<td  class="label"  ><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/>  3</td>
			<td class="fields"   >&nbsp;
			<SELECT name='item_anal3_code' id='item_anal3_code' onChange="" <%=disabled%> >
			<%=	objMmUtils.getListOptions( MmRepository.getMmKeyValue("SQL_MM_ITEM_MASTER_ANALYSIS"),arr_lang,bean.getItemAnal3Code(),locale)%>
			</SELECT>
			</td>
			<td COLSPAN="2">&nbsp;</TD>
	</tr>
	<tr>
		<td  class="label"><fmt:message key="eMM.ImportedItem.label" bundle="${mm_labels}"/></td>
		<td>&nbsp;<input type="checkbox" name="imported_item" id="imported_item" value='Y' <%=checked_imported_item%>></td>
		<td  class="label"><fmt:message key="Common.Reimburse.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<input type="checkbox" name="reimbursable_item_yn" id="reimbursable_item_yn" value='Y' <%=checked_reimbursable_item_yn%> onclick="enableReimburse(this);"></td>
	</tr>
	<tr>
		<td  class="label"><fmt:message key="eMM.EssentialItem.label" bundle="${mm_labels}"/></td>
		<td class="fields">&nbsp;<input type="checkbox" name="essential_item" id="essential_item" value='Y' <%=checked_essential_item%>></td>
		<td  class="label"  ><fmt:message key="eMM.ReimburseType.label" bundle="${mm_labels}"/></td>
		<td class="fields"   >&nbsp;
		<%if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){%>
			<SELECT name='reimburse_type' id='reimburse_type' disabled>
				<option value='N'><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
			</SELECT>
		<%}else{%>
			<SELECT name='reimburse_type' id='reimburse_type' <%=disable%>>
				<%=bean.getReimburseList()%></option>
			</SELECT>
		<%}%>
		</td>
	</tr>
	<!-- Added for MMS-DM-CRF-0209.2 starts -->
	<%
	if(site_cat_alt)
	{
	%>
	 <tr >
          <td  class="label"><fmt:message key="eMM.Category.label" bundle="${mm_labels}"/></td>
          <td>
          <input type='hidden' name='category_code' id='category_code' value="<%=bean.getCategory()%>" >
          <select onchange="enableAlternate(this)" id="category_code_id" name="category_code1" id="category_code1" >
            <option value='' <%if(bean.getCategory().trim().equals("")) out.print("selected");%> >&nbsp;&nbsp;&nbsp----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----&nbsp;&nbsp;&nbsp</option>
  			<option value="G" <%if(bean.getCategory().trim().equals("G")) out.print("selected");%>><fmt:message key="Common.generic.label" bundle="${mm_labels}"/></option>
 			<option value="B" <%if(bean.getCategory().trim().equals("B")) out.print("selected");%> ><fmt:message key="eMM.Brand.label" bundle="${mm_labels}"/></option>
		 </select>	 
		 </td>
		 <% if(bean.getCategory().equals("B"))
			 {
			   alternate_disabled="";
			 }
		    else
		    {
		    	alternate_disabled="disabled"; 
		    }
			 %>
		 <td  class="label"><fmt:message key="eMM.Alternate.label" bundle="${mm_labels}"/></td>
          <td>
          <input type='hidden' name='alternate_yn' id='alternate_yn' value="<%=bean.getAlternate()%>">
          <select <%=alternate_disabled %> id="alternate_id" name="alternate" >
            <option value='' <%if(bean.getAlternate().trim().equals("")) out.print("selected");%>>&nbsp;&nbsp;&nbsp----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----&nbsp;&nbsp;&nbsp</option>
  			<option value="Y" <%if(bean.getAlternate().trim().equals("Y")) out.print("selected");%>><fmt:message key="Common.yes.label" bundle="${mm_labels}"/></option>
 			<option value="N" <%if(bean.getAlternate().trim().equals("N")) out.print("selected");%>><fmt:message key="Common.no.label" bundle="${mm_labels}"/></option>
		 </select>	 
		 <img align='center' id='span3' style="visibility:hidden" src='../../eCommon/images/mandatory.gif'></img>
		 <input type='hidden' name='site_cat_alt' id='site_cat_alt' value="<%=site_cat_alt%>">
		 </td>   		
	</tr>
	<%} %>
	<!-- Added for MMS-DM-CRF-0209.2 ends -->
	<!-- Added by sakti against CRF-12 inc#29966-->
	<tr><td class='label'><fmt:message key="eMM.PlaceOfOrigin.label" bundle="${mm_labels}"/>&nbsp;&nbsp;</td>
	<td class='fields'>	<select name="place_of_origin" id="place_of_origin" value="" ><%=bean.getPlaceOfOriginList()%></select></td></tr>
	<tr>
	<!-- Added ends-->

	<tr>
			<td COLSPAN=4>&nbsp;</TD>
	</tr>
	<!-- Added for MMS-DM-CRF-0084 starts-->
	<tr height='30'>
		<td  class="label" ><span style="<%=fdaCodeVisibility%>"><fmt:message key="eMM.FDACode.label" bundle="${mm_labels}"/>&nbsp;&nbsp;</td>
      	<td class="fields"   ><span style="<%=fdaCodeVisibility%>"><input type="text" name="fda_code" id="fda_code" size="50" maxlength="50" value="<%=bean.getFda_code()%>" >&nbsp;<!-- Modified for  MMS-DM-CRF-0144.1--><!-- Modified for  IN071635-->
	</td>
	</tr>
	<!-- Added for MMS-DM-CRF-0084 ends -->
	<!-- <tr>
			<td  class="label" >&nbsp;&nbsp;Purchase UOM</TD>
			<td class="label" align='left'  >&nbsp;			
			<SELECT name='pur_uom_code' id='pur_uom_code' onChange="" <%=disabled%> >
			
			</SELECT>&nbsp;<img src="../../eCommon/images/mandatory.gif" align='center'></img>
				
		</td>
				
			<td  class="label" >Conversion Factor</td>
			<td class="label" align='left'   >&nbsp;
			<input type=text size=10 maxlength=10  style="text-align:right" name='pur_gen_uom_conv' id='pur_gen_uom_conv' value=""  onkeypress='return allowValidNumber(this,event,5,2);'  <%=readOnly%> >
		</td>
			
		</tr>
		<tr>
			<td  class="label" >Qty On Order</td>
			<td class="label" align='left'   >&nbsp;
			<input type="text" name="qty_on_order" id="qty_on_order" style="text-align:right" value="" size="10" maxlength="10" <%=readOnly%> onKeyPress='return allowValidNumber(this,event,10,1);' >
		</td>
				
			<td  class="label"  nowrap>Last Pur Advice Dt</td> 
			<td class="label" align='left'  >&nbsp;
			<input type="text" name="last_pur_advice_date" id="last_pur_advice_date" value="" size="10" maxlength="10" onBlur="return CheckDate(this)">
		</td>
		</tr>
		<TR><TD COLSPAN=5>&nbsp;</TD></TR>
		</table>

		<br> <br><br><br><br> <br><br><br><br><br><br><br>   

	
		<table border='0' cellpadding='0' cellspacing='0' width='96%' align='center'>
		<tr><td align='left'  class='label'>
			<a name="tab8" id="tab8"></a>
			<a align='left' href="javascript:tab1.scrollIntoView();" onFocus="javascript:tab1.scrollIntoView();sole_source_yn.focus();"><img  src="../images/Transaction_Characteristic_click.gif" border=0></a><img  src="../images/Item Characteristics.gif" border=0>

			</td>
		</tr>
		</table>
  

		<TD class="label" align='right'  nowrap>Item Class</TD>
			<td class="label" align='left'   >&nbsp;			
			<SELECT name='item_class_code' id='item_class_code' onChange="" <%=disabled%> >
			</SELECT>

		</TD> 

		<!-- <td  class="label" >Conversion Factor</td>
		<td class="label" align='left'   >&nbsp;
		<input type=text size=10 maxlength=10  style="text-align:right" name='pur_gen_uom_conv' id='pur_gen_uom_conv' value=""  onkeypress='return allowValidNumber(this,event,5,2);'  <%=readOnly%> >
		</td> -->
 </table>
	 <br> <br><br><br><br><br><br><BR><BR><BR><BR><BR>	
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="SQL_MM_ITEM_MASTER_SUPPLIER" id="SQL_MM_ITEM_MASTER_SUPPLIER" value="<%= bean.getMmRepositoryValue("SQL_MM_ITEM_MASTER_SUPPLIER")%>">
<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
<input type="hidden" name="language_id" id="language_id" value="<%=locale%>">
</form>
<script>
//	document.item_master_form.sole_source_yn.focus() ;
</script>
<%
putObjectInBean(bean_id,bean,request);
%>
<%
//Added for MMS-DM-CRF-0084 starts
	if(con != null)
		ConnectionManager.returnConnection(con,request);
//Added for MMS-DM-CRF-0084 ends
%>
</body>

</html>

