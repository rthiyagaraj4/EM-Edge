<!DOCTYPE html>
<%
/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
19/01/2021      TFS id:6938        B Haribabu          19/01/2021                    MMS-DM-CRF-0174.3
---------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.*,java.sql.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			=		(String)session.getAttribute("LOCALE");
	String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eST/js/StTransaction.js"></script>
	<script language="javascript" src="../../eST/js/StockStatusByItem.js"></script>
</head>
<%
Connection con				= null;//Added for TFS id:6938
try{//Added for TFS id:6938
	String facility_id							=		(String) session.getValue( "facility_id" ) ;
	String bean_id								=		"StockStatusByItemBean";
	String bean_name							=		"eST.StockStatusByItemBean";
	String user									=		(String) session.getValue( "login_user" );

	StockStatusByItemBean bean					=		(StockStatusByItemBean) getBeanObject( bean_id, bean_name,request );
	bean.setLanguageId(locale);
	con						= ConnectionManager.getConnection(request);//Added for TFS id:6938
	boolean barcode_appl =CommonBean.isSiteSpecific(con, "ST", "BARCODE_APPL_FOR_QUERY_FUNC");//Added for TFS id:6938
	String item_code							=		request.getParameter( "item_code" )==null?"":request.getParameter( "item_code" ) ;
	String store_code							=		request.getParameter( "store_code" )==null?"":request.getParameter( "store_code" ) ;
	String rdonly								=		"";
	String display_flag							=		"visibility:hidden";

	if(((String)bean.getAccessCostDetails()).equals("Y"))
		display_flag							=		"visibility:visible";

	String searchFunction						=		request.getParameter( "searchFunction" )==null?"N":request.getParameter( "searchFunction" ) ;
	/**
		 * @Name - Priya
		 * @Date - 07/06/2010
		 * @Inc# - 
		 * @Desc -  To get no of decimals for cost 
		 */
	String noOfDecimalsForCost=bean.getNoOfDecimalsCost();
	
	// Added by Rabbani #Inc no :39203 on  18-APR-2013
	 String trn_across_facility_yn  = bean.checkForNull((String)bean.fetchRecord("select  trn_across_facility_yn  from  ST_ACC_ENTITY_PARAM where ACC_ENTITY_ID= 'ZZ'").get("TRN_ACROSS_FACILITY_YN"),"N");
	 
	if(searchFunction.equals("Y"))	{
		if(item_code.equals("")) {
	%>
	<script language="JavaScript">
		alert(getMessage("ST_ITEM_CODE_BLANK","ST"));
		parent.window.close();
	</script>
	<%
	}else if (store_code.equals("")) {
	%>
	<script language="JavaScript">
		alert(getMessage("ST_STORE_CODE_BLANK","ST"));
		parent.window.close();
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<%
	} else
		rdonly="disabled";
	}
%>
<body onload='FocusFirstElement();' >
	<form name="formStockStatusQueryCriteria" id="formStockStatusQueryCriteria" >
	<table border="0" cellpadding="0" cellspacing="0" width='100%' align="center">	
	
	   <!-- Added by Rabbani #Inc no :39203 on  09/04/2013 -->
	<%if(trn_across_facility_yn.equals("Y")){%>
	    <tr>
	    <td class=label colspan="5">&nbsp;&nbsp;<fmt:message key="eST.StockStatusforFacility.label" bundle="${st_labels}"/>&nbsp;&nbsp;&nbsp;<select name='dflt_facility_id' id='dflt_facility_id' onChange="facility_select(this)">
		 <option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/> </option>
		      <%
 			   ArrayList	arrTrnfacility				=	null;
			   HashMap		hmTrnFacility				=	null;
			   String Select_facility_id = "",	Select_facility_name =	"";
			   String dflt_facility_select	 =	"";
			   
			    arrTrnfacility   =	 bean.getFacility_names();
			    //int arrLength  =	 arrTrnfacility.size();
			 
			for(int i=0;i<arrTrnfacility.size(); i++)
			{
				hmTrnFacility			=	(HashMap) arrTrnfacility.get(i);
				Select_facility_id		=	(String)hmTrnFacility.get("FACILITY_ID");
				Select_facility_name	=	(String)hmTrnFacility.get("FACILITY_NAME");
				
				if(Select_facility_id.trim().equals(bean.getLoginFacilityId()))
				  dflt_facility_select				=	"Selected";
				else
				  dflt_facility_select				=	"";
				%>
					  <option value="<%=Select_facility_id%>" <%=dflt_facility_select%> ><%=Select_facility_name%></option>  
				<%
		     }
			%></select></td></tr>
			
		 <%}else{%>
		 <input type=hidden name="dflt_facility_id" id="dflt_facility_id" value = "<%=bean.getLoginFacilityId()%>">
		 <%}%>
		<tr>
		<td colspan="5">&nbsp;</td>
		</tr>
		<!-- ends -->
		<!-- Added for TFS id:6938 start-->
		<%if(barcode_appl){ %>
		<tr>
	<td class=label colspan="5">&nbsp;&nbsp;<fmt:message key="eST.BarcodeId.label" bundle="${st_labels}"/>&nbsp;&nbsp;<input type=text name=barcode id=barcode size=80  maxlength=100 value="" onkeypress="callItemSearchScreenForQueryFunction(event, barcode,'SSBI','<%=bean_id%>','<%=bean_name%>',document.formStockStatusQueryCriteria);" ></td>
<%-- 		<td  class='label'><input type=text name=barcode size=80  maxlength=100 value="" onkeypress="callItemSearchScreenForQueryFunction(event, barcode,'SSBI','<%=bean_id%>','<%=bean_name%>');" ></td> --%>
	</tr>
		<%} %>
		<!-- Added for TFS id:6938 end-->
		<tr>
		<td class=label>&nbsp;
			<fmt:message key="Common.item.label"	bundle="${common_labels}"/>&nbsp;
			<input type="text" name='item_desc' id='item_desc' size="50" maxlength="60" value="" <%=rdonly%> >
			<input type="hidden" name='item_code' id='item_code' value="">
			<input type='button' class='BUTTON' value='?' onClick='callItemSearchScreen(item_code,item_desc);' name="item_search" id="item_search">&nbsp;<%=bean.getImage("M")%>
			 <label  id= 'id_Highlight' ></label>
		 </td>
		
		<td class= label>
		&nbsp;<fmt:message key="Common.uom.label" bundle="${common_labels}"/>&nbsp;</td>
		<td class=label><b id="id_uom"></b></td>
		<td  class=label ><fmt:message key="eST.ExpiryYN.label" bundle="${st_labels}"/>
		<label id="id_exp"  align='center' ></label>
		</td>
		<td class=label width="11%">&nbsp;</td>
	</tr>
	</table>
	<table border="0" cellpadding="0" cellspacing="0" width='100%' align=center>
		<tr>
			<td  class="label" colspan='2' nowrap>
			     &nbsp;&nbsp;<fmt:message key="Common.StoreCodeFrom.label" bundle="${common_labels}"/>&nbsp;&nbsp;<input maxLength=20 size=20 name="store_code_from" id="store_code_from" value="" ><input class="button" name="from_store_desc" id="from_store_desc" onClick="return searchStoreCode(store_code_from,'<%=user%>');" type="button" value="?">
			</td>
			<td  class="label" colspan='2' nowrap>
			     <fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;&nbsp;<input maxLength=20 size=20 name="store_code_to" id="store_code_to" value="" ><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchStoreCode(store_code_to,'<%=user%>');" type="button" value="?">
			</td>
			<td class="label" colspan='4' nowrap>
				<fmt:message key="eST.StockLevel.label" bundle="${st_labels}"/>&nbsp;&nbsp;<select name="stock_level" id="stock_level" >
				<option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
				<option  value='Z'><fmt:message key="eST.ZeroStock.label" bundle="${st_labels}"/></option>
				<option  value='S'><fmt:message key="eST.StockOnHand.label" bundle="${st_labels}"/></option>
				<option  value='B'><fmt:message key="eST.BelowRe-OrderLevel.label" bundle="${st_labels}"/></option></select>
			</td>
		</tr>

		<tr height=17>
			<td  class=label align=left width=350>&nbsp;&nbsp;<fmt:message key="eST.TotalStock.label" bundle="${st_labels}"/></td>
			<td class='LABEL' align="left" width=300>&nbsp;<b id="id_stock"></b></td>
			<!-- <td  class='label' align=left width=80></td> -->
			<td  class=label align='left' width=275>
			     <label style="<%=display_flag%>"><fmt:message  key="Common.UnitCost.label" bundle="${common_labels}"/></label>
			</td>
			<td class='LABEL'  align='left' width=200>&nbsp;<b id="id_cost" style="<%=display_flag%>"></b></td>
			<!-- <td  class=label align=left width=80></td> -->
			<td  class=label align=left width=250>
			     <label style="<%=display_flag%>"><fmt:message key="eST.CostValue.label" bundle="${st_labels}"/></label>
			</td>
			<td class='LABEL'  align='left' width=100>&nbsp<b id="id_value" style="<%=display_flag%>"></b></td>
			<!-- <td  class=label align=left width=50></td> -->
		</tr>
		<tr height=17>
			<td  class=label align=left>&nbsp;
			  <fmt:message key="eST.StockReorderStore.label" bundle="${st_labels}"/>
			</td>
			<td class='LABEL'  align='left'>&nbsp;<b id="id_store"></b></td>
			<!-- <td  class=label align='right'></td>  -->
			<td  class=label align=left>
			   <fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/>
			</td>
			<td class='LABEL' align="left">&nbsp;<b id="id_class"></b></td>
			<!--<td  class=label align=left></td>
			<td  class=label align=left>&nbsp</td> -->
			<td class='LABEL'>&nbsp;<b id="id_minfo"></b></td>
			<td  class=label align=left></td>
		</tr>
		<tr height=17>
			<td  class=label align=left>&nbsp;&nbsp;<fmt:message key="Common.PackSize.label" bundle="${common_labels}"/></td>
			<td class='LABEL'  align=left>&nbsp;<b id="id_size"></b></td>
			<td  class=label align=left></td>
			<td  class=label align=left>&nbsp</td>
			<td  class=label align=left>&nbsp&nbsp</td>
			<td  class=label align=left></td>
			<td  class=label align=left>&nbsp&nbsp</td>
			<td class='LABEL'>&nbsp</td>
			<td  class=label align=left></td>
		</tr>
		<tr height=17>
			<td  class=label align=left>&nbsp;&nbsp;<fmt:message key="eST.YTDConsQty.label" bundle="${st_labels}"/></td>
			<td class='LABEL' align=left>&nbsp;<b id="id_conQty"></b></td>
			<!-- <td  class=label align=left></td> -->
			<td  class=label align=left><fmt:message key="eST.YTDIssueQty.label" bundle="${st_labels}"/></td>
			<td class='LABEL' align=left>&nbsp;<b id="id_ytdIQty"></b></td>
			<!-- <td  class=label align=left></td> -->
			<td  class=label align=left><fmt:message key="eST.MTDReceiptsQty.label" bundle="${st_labels}"/></td>
			<td class='LABEL' align=left>&nbsp;<b id="id_mtdRQty"></b></td>
			<td  class=label align=left></td>
		</tr>
		<tr height=17>
			<td  class=label align=left>&nbsp;&nbsp;<fmt:message key="eST.MTDConsQty.label" bundle="${st_labels}"/></td>
			<td class='LABEL' align=left>&nbsp;<b id="id_MTDconQty"></b></td>
			<!-- <td  class=label align=left></td> -->
			<td  class=label align=left><fmt:message key="eST.MTDIssueQty.label" bundle="${st_labels}"/></td>
			<td class='LABEL' align=left>&nbsp;<b id="id_mtdIQty"></b></td>
			</tr>
		<tr height=17>
			<td  class=label align='left'>&nbsp;&nbsp;<fmt:message key="Common.LastIssueDate.label" bundle="${common_labels}"/></td>
			<td class='LABEL' align="left">&nbsp;<b id="id_lestdate"></b></td>
			<td  class=label align=left></td>
			<td  class=label align="center">&nbsp;<b id="id_leststore"></b></td>
			<td class='LABEL'>&nbsp;<b id=""></b></td>
			<td  class=label align=left></td>
			<td  class=label align='left'>&nbsp&nbsp</td>
			<td class='LABEL'>&nbsp;<b id=""></b></td>
			<td  class=label align=left></td>
		</tr>
		<tr height=17>
			<td  class=label align='left'>&nbsp;&nbsp;<fmt:message key="eST.MinimumLevel.label" bundle="${st_labels}"/></td>
			<td class='LABEL' align='left'>&nbsp;<b id="id_minl"></b></td>
			<!-- <td  class=label align=left></td> -->
			<td  class=label align='left'><fmt:message key="eST.ROLevel.label" bundle="${st_labels}"/></td>
			<td class='LABEL' align='left'>&nbsp;<b id="id_recl"></b></td>
			<!-- <td  class=label align=left></td> -->
			<td  class=label align='left'><fmt:message key="eST.MaximumLevel.label" bundle="${st_labels}"/></td>
			<td class='LABEL' align='left'>&nbsp;<b id="id_maxl"></b></td>
			<td  class=label align=left></td>
		</tr>
		<tr height=17>
			<td  class=label align='left'>&nbsp;&nbsp;<fmt:message key="eST.PrimaryStore.label" bundle="${st_labels}"/></td>
			<td class='LABEL'>&nbsp;<b id="id_pstore"></b></td>
			<!-- <td  class=label align=left></td> -->
			<td  class=label align='left'><fmt:message key="eST.StoreLevelStatus.label" bundle="${st_labels}"/></td>
			<td class='LABEL' align='left'>&nbsp;<b id="id_pstock"></b></td>
			<!-- <td  class=label align=left></td> -->
			<td  class=label align='left'><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/>(<fmt:message key="Common.first.label" bundle="${common_labels}"/>)</td>
			<td class='LABEL'>&nbsp;<b id="id_locfirst"></b></td>
			<td  class=label align=left></td>
	  </tr>
	  <!--Added by Rabbani #30069(BRU-HIMS-CRF-110) on 23-APR-2013-->
	   <tr>
	   <tr>
	   <td  class=label align='left' nowrap colspan="9">&nbsp;&nbsp;<fmt:message key="eST.IncludeSuspendedBatchesinAvailableQuantity.label" bundle="${st_labels}"/>&nbsp;&nbsp; <input type= "checkbox"  name= "includeSuspendedBatches"   value = "N"  onclick = "SetSuspendedBatches(this);" ></td>
	  </tr>
	  <!-- ends -->
	  <tr>
		<td colspan='7'></td>
		<td align = "left" ><input type="button" name="Search" id="Search" class= 'button' value= '<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick="searchDetails()" ></input>
	 <tr>
 </table>
	<table>
	<tr id="trhidden" name="trhidden" style="display:none">
		<td class='normal' height=15 width=130 align='center' id='id_storestatus'>
			<a class="TABLINK" id="link1" href="javascript:Display('1')" ><b><fmt:message key="eST.StoreLevelStatus.label" bundle="${st_labels}"/></b></a>
		</td>			
		<td class='normal' height=15 width=130 align='center' id='id_moredetail'>
			<a class="TABLINK" id="link2" href="javascript:Display('2')" ><b><fmt:message key="eST.MoreDetails.label" bundle="${st_labels}"/></b></a>
		</td>
		<td class='normal' height=15 width=130 align='center' id='id_consumption'>
			<a class="TABLINK" id="link2" href="javascript:Display('3')" ><b><fmt:message key="eST.Consumption.label" bundle="${st_labels}"/></b></a>
		</td>
	</tr>
	</table>
	<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP"				value="<%=bean.getStRepositoryValue("SQL_ST_STOCK_STATUS_BY_STORE_ITEM_STORE")%>">
	<input type="hidden" name="facility_id" id="facility_id"					value="<%=facility_id%>">
	<input type="hidden" name="language_id" id="language_id"						value="<%=locale%>">
	<input type="hidden" name="no_of_decimals_for_cost" id="no_of_decimals_for_cost" value='<%=noOfDecimalsForCost%>'>
	<!--Added by Rabbani #INC no : 39203  on 09/04/2013 -->
	<input type="hidden" name="unit_cost_facility" id="unit_cost_facility" >
	<input type="hidden" name="id_min_lev" id="id_min_lev" >
	 
</form>
<%
	putObjectInBean(bean_id,bean,request);
//Added for TFS id:6938 start	
}
catch(Exception e){
	e.printStackTrace();
}
finally{
	
	if(con != null)
		ConnectionManager.returnConnection(con,request);

}
//Added for TFS id:6938 end
%>

</body>
</html>

