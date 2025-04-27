<!DOCTYPE html>
<% 
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
02/07/2017	  	IN061197	     	Mukesh M 		  									AAKH-CRF-0091 [IN061197] 
07/01/2019	  	IN068344	     	Manickavasagam 	 	  								GHL-CRF-0549 [IN068344] 
26/07/2019      IN070451		    B Haribabu   26/07/2019     Manickam                ML-MMOH-CRF-1408
27/08/2020		IN073716			Shazana												MOHE-SCF-0031
03/09/2020      IN073900            Haribabu                                MMS-DM-CRF-0174.2
--------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="eMM.*,eST.*, eST.Common.* , eCommon.Common.*,java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
<head>
	<meta name="Author" content="Rammohan">
<%
		    request.setCharacterEncoding("UTF-8");
			String locale			=		(String)session.getAttribute("LOCALE");

		    String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eST/js/ItemSearch.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<style type='text/css'>
			select{
			width:145px;}
	</style>
</head>
<%
	//java.util.HashMap defaultParameter			=			null;

	String bean_id									=			 "ItemSearchBean";
	String bean_name								=			"eST.ItemSearchBean";	

	ItemSearchBean bean								=			(ItemSearchBean) getBeanObject( bean_id,bean_name,request);  

	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setLanguageId(locale);
//	String facility_id								=			(String) session.getValue("facility_id");
	String search_string							=			CommonBean.checkForNull(request.getParameter("search_string"),"");
	String category									=			CommonBean.checkForNull(request.getParameter("category"),"%");
	String ps_item									=			CommonBean.checkForNull(request.getParameter("ps_item"),"%");
	String sole_source								=			CommonBean.checkForNull(request.getParameter("sole_source"),"%");
	String abc_analysis								=			CommonBean.checkForNull(request.getParameter("abc_analysis"),"%");
	String mfg_item									=			CommonBean.checkForNull(request.getParameter("mfg_item"),"%");
	String expiry									=			CommonBean.checkForNull(request.getParameter("expiry"),"%");
	String store_code								=			CommonBean.checkForNull(request.getParameter("store_code"),"%");
	String item_class								=			CommonBean.checkForNull((String)request.getParameter("item_class"),"");
	String consignment								=			CommonBean.checkForNull(request.getParameter("consignment"),"%");
	String chkitemstorecmb							=			CommonBean.checkForNull(request.getParameter("chkitemstorecmb"),"N");
	String to_store_code							=			CommonBean.checkForNull(request.getParameter("to_store_code"),"%");
	String store_disable							=			CommonBean.checkForNull(request.getParameter("store_disable"),"N");
	String itm_srch_param							=			CommonBean.checkForNull(request.getParameter("array_itemsearch"),"");
	String kit										=			CommonBean.checkForNull(request.getParameter("kit"),"N");
	String direct_sale								=			CommonBean.checkForNull(request.getParameter("direct_sale"),"N");
	String barcode_id								=			CommonBean.checkForNull(request.getParameter("barcode_id"),"");// Added for IN:073900

	String trn_type									=			CommonBean.checkForNull(request.getParameter("trn_type"),""); //Added by Sakti against AMS-CRF-0011 trn_type passing
	String search_no									=			CommonBean.checkForNull(request.getParameter("search_no"),""); //Added by suresh.r on 17-06-2014 against ML-BRU-SCF-1375
	//String item_class_code							=			CommonBean.checkForNull(request.getParameter("item_class_code"),"%");
	//String item_class_desc							=			CommonBean.checkForNull(request.getParameter("item_class_desc"),"%");
	if(trn_type.equals("undefined"))
			trn_type = "";
	if(item_class.equals("undefined"))
			item_class = "";
	if(direct_sale.equals("undefined"))
			direct_sale = "";
	ArrayList  array_itemsearch						=			 new ArrayList();
	if (itm_srch_param != null)
	{
		//int i=0;
		StringTokenizer st							=			 new StringTokenizer(itm_srch_param,",");
		 while (st.hasMoreTokens()) 
			{
				array_itemsearch.add(st.nextToken());
			}
			bean.setitemsearchparam(array_itemsearch);
			
	}
	

	boolean  Search									=			true;
	if(search_string!="")
		Search										=			true;
    else
		Search										=			false;

	String category_disable							=			category.equals("A")?"":"disabled";
	String ps_item_disable							=			ps_item.equals("A")?"":"disabled";
	String sole_source_disable						=			sole_source.equals("A")?"":"disabled";
	String abc_analysis_disable						=			abc_analysis.equals("%")?"":"disabled";
	String mfg_item_disable							=			mfg_item.equals("A")?"":"disabled";
	String expiry_disable							=			expiry.equals("A")?"":"disabled";
	String store_code_disable						=			store_code.equals("%")?"":"disabled";
	if (store_disable.equals("Y"))
	{
			store_code_disable ="disabled";
	}
	String item_class_disable						=			item_class.equals("")?"":"disabled";
	String consignment_disable						=			consignment.equals("A")?"":"disabled";
	String chkitemstorecmb_checked					=			chkitemstorecmb.equals("Y")?"checked":"";
	String visibility								=			chkitemstorecmb.equals("Y")?"visibility:visible":"visibility:hidden";
	String visibility1								=			kit.equals("Y")?"visibility:visible":"visibility:hidden";

	String item_class_display						=			bean.getItemClassDesc(item_class);
	String item_analysis							=			bean.getItemAnalysis();
	String val										=			"";
	String dflt="";// Modified for IN:073900
	bean.setSearch_string(search_string) ;
	bean.setCategory(category) ;
	bean.setSole_source_yn(sole_source) ;
	bean.setPs_item_yn(ps_item) ;
	bean.setAbc_analysis(abc_analysis) ;
	bean.setMfg_item(mfg_item) ;
	bean.setExpiry(expiry) ;
	bean.setStore_code(store_code) ;
	bean.setTo_Store_code(to_store_code) ;
	bean.setItem_class(item_class) ;
	bean.setConsignment(consignment) ;
	bean.setChkItemStoreCombination(chkitemstorecmb) ;
	bean.setSearch(Search) ;
	bean.setDirectSale(direct_sale) ;
	
	
	if(store_code.equals("%"))store_code			=			"";
// Modified for IN:073900 start
	if(!(barcode_id.equals(""))){
		val="IC";
	}
	else{
	 dflt				=	(String)bean.getDflt_search_item()==null?"":(String)bean.getDflt_search_item();
	if(dflt.equals("")){
		 val = CommonBean.checkForNull(bean.getDflt_search_item1(),"IC");
	}else{
		 val = CommonBean.checkForNull(bean.getDflt_search_item(),"IC");
	}
	}
	// Modified for IN:073900 end
%>
<body onload='FocusFirstElement();<%=(bean.getSearch_string().equals(""))?"":"searchVals();"%>; 
<%=dflt.equals("")?"getDefaultItmSearch1();":"getDefaultItmSearch();" %>'>

	<form name="ItemSearchCriteria_Form" id="ItemSearchCriteria_Form" >
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align=center>
				<form name="searchform" id="searchform" onSubmit= 'return submitPage();' >
       				<table border="0" cellspacing=0 cellpadding=0 width='100%' align=center>
					<th   colspan=7>
					<fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></th>
				<tr>  
					<td class='fields'  width="43%" nowrap>	<!-- added for alignment issues in MOHE-SCF-0031 start-->
					
						<table  border="0" cellpadding="0" cellspacing="0" width='100%'>
						<tr>
						<td  class='label' width="18.5%" nowrap style="padding-left: 9px;">
						<input type='radio'  <%=(val.equals("IC"))?"checked":""%> name='searchby' id='searchby'  accesskey='N' value='IC'  onClick='storeVal(this.value);'>&nbsp;
					<fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
						<td  class='label'>
						<input type='radio'  <%=(val.equals("IN"))?"checked":""%> name='searchby' id='searchby' value='IN' accesskey='T' onClick='storeVal(this.value);'><!-- added td tag for MOHE-SCF-0031 -->
					<fmt:message key="Common.ItemName.label" bundle="${common_labels}"/>
						</td>
						</tr>
						</table>
		
					</td>	<!-- added for alignment issues in MOHE-SCF-0031 end-->
					
					<td class='label' >
					<fmt:message key="Common.category.label" bundle="${common_labels}"/>
<!-- 					("A,All;Y,Medical;N,Non Medical;",getCategory()); -->
					<td  class='fields' width="15%">&nbsp;
					<select name='category' id='category' accesskey='Y'  <%=category_disable%> >
					<option value="A"  <%=bean.getCategory().equals("A")?"Selected":""%>>
					<fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
					<option value="Y"<%=bean.getCategory().equals("Y")?"Selected":""%>>
					<fmt:message key="Common.medical.label" bundle="${common_labels}"/></option>
					<option value="N"<%=bean.getCategory().equals("N")?"Selected":""%>>
					<fmt:message key="eST.NonMedical.label" bundle="${st_labels}"/></option>
					</select></td>
					<td class='label'   width="10%" nowrap >
					<fmt:message key="eST.Manufacturing.label" bundle="${st_labels}"/> &nbsp;</td>
<!-- 					("A,All;Y,Manufacturing ;N,Non Manufacturing;",getMfg_item()); -->
					<td class='fields'  width="15%">
					<select name='mfg_item' id='mfg_item'   accesskey='f'  <%=mfg_item_disable%> >
					<option value="A"  <%=bean.getMfg_item().equals("A")?"Selected":""%>>
					<fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
					<option value="Y"<%=bean.getMfg_item().equals("Y")?"Selected":""%>>
					<fmt:message key="eST.Manufacturing.label" bundle="${st_labels}"/></option>
					<option value="N"<%=bean.getMfg_item().equals("N")?"Selected":""%>>
					<fmt:message key="eST.NonManufacturing.label" bundle="${st_labels}"/></option>
					</select>
					</td>
				</tr>
				<tr>
					<td class='label' width="44%">&nbsp;	<!-- added for alignment issues in MOHE-SCF-0031 -->
					<input type='radio' <%=(val.equals("MC"))?"checked":""%> accesskey='M'  name='searchby' id='searchby' value='MC'  onClick='storeVal(this.value);'>&nbsp;
					<fmt:message key="eST.MachineCode.label" bundle="${st_labels}"/>
					&nbsp;&nbsp;&nbsp;<input type='radio' <%=(val.equals("PN"))?"checked":""%> accesskey='P' name='searchby' id='searchby' value='PN' onClick='storeVal(this.value);'>&nbsp;
					<fmt:message key="eST.PartNumber.label" bundle="${st_labels}"/></td>
					<td class='label' >
					<fmt:message key="Common.SoleSource.label" bundle="${common_labels}"/></td>
<!-- 					("A,All;Y,Sole Source ;N,Non Sole Source ;",getSole_source_yn()); -->
					<td class='fields'>&nbsp;
					<select name='sole_source' id='sole_source' accesskey='S'  <%=sole_source_disable%> >
					<option value="A"  <%=bean.getSole_source_yn().equals("A")?"Selected":""%>>
					<fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
					<option value="Y"<%=bean.getSole_source_yn().equals("Y")?"Selected":""%>>
					<fmt:message key="Common.SoleSource.label" bundle="${common_labels}"/></option>
					<option value="N"<%=bean.getSole_source_yn().equals("N")?"Selected":""%>>
					<fmt:message key="eST.NonSoleSource.label" bundle="${st_labels}"/></option>
					</select>
					</td>
<!-- 					("A,All;Y,Expiry Items;N,Non-Expiry Items;",getExpiry()); -->
					<td class='label' >
					<fmt:message key="Common.Expiry.label" bundle="${common_labels}"/>&nbsp;</td>
					<td class='fields'>
					<select name='expiry' id='expiry' <%=expiry_disable%> accesskey='E'   >
					<option value="A"  <%=bean.getExpiry().equals("A")?"Selected":""%>>
					<fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
					<option value="Y"<%=bean.getExpiry().equals("Y")?"Selected":""%>>
					<fmt:message key="eST.ExpiryItems.label" bundle="${st_labels}"/></option>
					<option value="N"<%=bean.getExpiry().equals("N")?"Selected":""%>>
					<fmt:message key="eST.NonExpiryItems.label" bundle="${st_labels}"/></option>
					</select>
					</td>
				</tr>
				<tr>
					<td class='label'   width="44%">&nbsp;	<!-- added for alignment issues in MOHE-SCF-0031 -->
					<input type='radio' <%=(val.equals("TI"))?"checked":""%> name='searchby' id='searchby' value='TI'  accesskey='T' onClick='storeVal(this.value);' >&nbsp;
					<fmt:message key="Common.TradeID.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type='radio' <%=(val.equals("TN"))?"checked":""%> name='searchby' id='searchby' value='TN'  onClick='storeVal(this.value);'>&nbsp;
					<fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></td>
<!-- 					("A,All;Y,PS Items;N,Non PS Items;",getPs_item_yn()); -->
					<td class='label' >
					<fmt:message key="eMM.PharmacyStockItem.label" bundle="${mm_labels}"/></td>
					<td class='fields'>&nbsp;
					<select name='ps_item' id='ps_item' accesskey='I' <%=ps_item_disable%> >
					<option value="A"  <%=bean.getPs_item_yn().equals("A")?"Selected":""%>>
					<fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
					<option value="Y"<%=bean.getPs_item_yn().equals("Y")?"Selected":""%>>
					<fmt:message key="eST.PharmacyStockItems.label" bundle="${st_labels}"/></option>
					<option value="N"<%=bean.getPs_item_yn().equals("N")?"Selected":""%>>
					<fmt:message key="eST.NonPSItems.label" bundle="${st_labels}"/></option>			
				    </select>
					</td>
					<td class='label' >
					<fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/>&nbsp;</td>
					<td class='fields'>
					<% if((item_class=="")||(item_class_display=="")){ %>
					<select name='item_class' id='item_class' accesskey='C' <%=item_class_disable%> onChange="setItemClassDesc(this);" ><%=bean.getItemClass()%></select>
					<%}else if(item_class_display!="")  {%>
					<select name='item_class' id='item_class' accesskey='C' <%=item_class_disable%> onBlur="setItemClassDesc(this);" >
					<option ><%=item_class_display%></option></select>
					<%}%> 

					</td>
				</tr>
				<!-- ("A,A;B,B;C,C;",getAbc_analysis(),true); -->
				 <tr>
					<td class='label' >&nbsp;
					<input type='radio' <%=(val.equals("AC"))?"checked":""%> name='searchby' id='searchby' value='AC'  accesskey='A' onClick='storeVal(this.value);'>&nbsp;
					<fmt:message key="Common.AlphaCode.label" bundle="${common_labels}"/></td>
					<td class='label'   >
					<fmt:message key="eST.ABCAnalysis.label" bundle="${st_labels}"/></td>
					<td class='fields'>&nbsp;
					<select name='abc_analysis' id='abc_analysis' accesskey='B'  <%=abc_analysis_disable%> >
					<option value="" ><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
					<option value="A"  <%=bean.getABCAnalysis().equals("A")?"Selected":""%>>
					<fmt:message key="eST.A.label" bundle="${st_labels}"/></option>
					<option value="B"<%=bean.getABCAnalysis().equals("B")?"Selected":""%>>
					<fmt:message key="eST.B.label" bundle="${st_labels}"/></option>
					<option value="C"<%=bean.getABCAnalysis().equals("C")?"Selected":""%>>
					<fmt:message key="eST.C.label" bundle="${st_labels}"/></option>
					</select>
					</td>
					<td class='label' >
					<fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/>&nbsp;1&nbsp;</td>
					<td class='fields'>
					<select name='item_analysis_1' id='item_analysis_1'  accesskey='1' ><%=item_analysis%>
				  </select>
					</td>
				</tr>
				<tr>
					<td class='label'  >
						<table cellpadding=0 cellspacing=0 border=0 width='100%' align=center>
							<td  style=<%=visibility%> class='label'>
							<fmt:message key="eST.ConsiderIteminTargetStore.label" bundle="${st_labels}"/> 
							<input type='checkbox'  name='chkitemstorecmb' id='chkitemstorecmb' <%=chkitemstorecmb_checked%> ></td>
							<td class = 'label'style=<%=visibility1%>><fmt:message key="eMM.KitTemplate.label" bundle="${mm_labels}"/>
							&nbsp;<input type='checkbox'  name='kit_template_yn' id='kit_template_yn' onclick="formdisable(this);"></td>
						</table>
					</td>
					<td class='label'  >
					<fmt:message key="Common.Manufacturer.label" bundle="${common_labels}"/></td>
					<td class='fields'>&nbsp;
					<select name='manufacturer' id='manufacturer' accesskey ='u' ><%=bean.getManufacturerList()%>				
				    </select>
					</td>
					<td class='label' >
					<fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/>&nbsp;2&nbsp;</td>
					<td class='fields'><select name='item_analysis_2' id='item_analysis_2' accesskey='2'><%=item_analysis%>
				    </select>
					</td>
				</tr>
				<tr> 
					 <!-- <td colspan=1>&nbsp;</td>  -->
				<td class='label'   rowspan='2'>
				<table cellpadding=0 cellspacing=0 border=0 width='100%' align=center>
					<tr>
						<td class='label' >
						<fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
						<td class='fields'>&nbsp;<input type='text' name='store' id='store'  size=8  maxlength=6 value="<%=store_code.equals("null")?"":store_code%>"  <%=store_code_disable%>  >
						<input type='button' class=button name='search_store' id='search_store'   value="?"  <%=store_code_disable%>   onclick="searchCode(store_code,store)"></td>
											
					</tr>
					<tr>
						<td class='label'  nowrap>
						<fmt:message key="eMM.SearchString.label" bundle="${mm_labels}"/></td>
						<td class='fields'>&nbsp;<input type='text' name='search_string' id='search_string'  size=35  maxlength=60   value="<%=bean.getSearch_string()%>"><%=bean.getImage("M")%>
						</td>  
					</tr>
				</table>
				</td> 
				<!-- 	("A,All;Y,Consignment ;N,Non Consignment"); -->
					<!-- <td   > -->
					<td class='label'  ><fmt:message key="eST.Consignment.label" bundle="${st_labels}"/></td>
					<td class='fields'>&nbsp;&nbsp;<select name='consignment' id='consignment' accesskey ='u'  <%=consignment_disable%> > 
					<option value="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
				<option value="Y"><fmt:message key="eST.Consignment.label" bundle="${st_labels}"/></option>
				<option value="N"><fmt:message key="eST.NonConsignment.label" bundle="${st_labels}"/></option>
				    </select>
					</td> 
					<td class='label'  nowrap><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/>&nbsp;3&nbsp;</td>
					<td class='fields'><select name='item_analysis_3' id='item_analysis_3' accesskey='3'><%=item_analysis%></select>
					</td>
				</tr> 
				<tr>
				<td class='label' ><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></td>
				<td class='fields'>&nbsp;&nbsp;<select name='search_criteria' id='search_criteria'>
				<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
				<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
				<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
				</select> </td>
				<td   colspan='2'>
					<input type='button'  class='BUTTON' name='previous' id='previous' value='<fmt:message key="Common.previous.label" bundle="${common_labels}"/>' disabled onClick='goPrev();'><input type='button' class='BUTTON' name='next' id='next' value='<fmt:message key="Common.next.label" bundle="${common_labels}"/>' onClick='goNext();' disabled><input type='button' class='BUTTON' name='search' id='search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='searchVals();'>
				    </td>
			</tr>
	</table>
</center>
</table>
		<input type="hidden" name="item_code" id="item_code" >
		<input type="hidden" name="short_desc" id="short_desc" >
		<input type="hidden" name="alpha_code" id="alpha_code" >
		<input type="hidden" name="machine_code" id="machine_code" >
		<input type="hidden" name="spare_part_id" id="spare_part_id" >
		<input type="hidden" name="store_code" id="store_code"			value="<%=store_code%>">
		<input type="hidden" name="item_class_code" id="item_class_code"		value="<%=item_class%>">
		<input type="hidden" name="language_id" id="language_id"			value="<%=locale%>">
		<input type="hidden" name="store_desc" id="store_desc">
		<input type="hidden" name="SQL_ST_ITEM_STORE" id="SQL_ST_ITEM_STORE"	value="<%=bean.getStRepositoryValue("SQL_ST_ITEM_STORE")%>">
		<input type='hidden'	name="dflt_search_item" id="dflt_search_item"		value="<%=(String)bean.getDflt_search_item()%>">
		<input type='hidden'	name="dflt_search_item1" id="dflt_search_item1"		value="<%=(String)bean.getDflt_search_item1()%>">
		<input type="hidden" name="trn_type" id="trn_type"			value="<%=trn_type%>">
		<input type="hidden" name="search_no" id="search_no"			value="<%=search_no%>"><!--Added by suresh.r on 17-06-2014 against ML-BRU-SCF-1375 -->		
</form>
<%
		putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

