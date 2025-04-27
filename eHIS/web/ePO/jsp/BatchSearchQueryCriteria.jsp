<!DOCTYPE html>
 
<%@ page import ="eST.BatchSearchBean,java.util.HashMap,java.util.ArrayList" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<%-- Mandatory declarations end --%>
<html>
<head>
<!-- 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
 --><%
	 request.setCharacterEncoding("UTF-8");
	String locale			=	(String)session.getAttribute("LOCALE");
	String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 	<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<!-- 	<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eST/js/StTransaction.js"></script>
		<script language="javascript" src="../../eST/js/BatchSearch.js"></script>
		<script language="JavaScript" SRC="../../eCommon/js/common.js"></script>
		 <script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>

</head>
<%
	BatchSearchBean bean = (BatchSearchBean) getBeanObject( "batchSearchBean","eST.BatchSearchBean",request );
	bean.setLanguageId(locale);
	String user_name  =  (String) session.getValue( "login_user" ) ;

	String p_multi_trade_select_yn = request.getParameter("p_multi_trade_select_yn")==null?"":request.getParameter("p_multi_trade_select_yn") ;
	String p_list_all_trades_yn= request.getParameter( "p_list_all_trades_yn" )==null?"":request.getParameter( "p_list_all_trades_yn" ) ;


   if(p_multi_trade_select_yn.equals(""))
   {
      p_multi_trade_select_yn="Y";

   }

	String item_code= request.getParameter( "item_code" )==null?"":request.getParameter( "item_code" ) ;

	String trade_id	= request.getParameter( "trade_code" )==null?"":request.getParameter( "trade_code" ) ;
	String doc_type_code	= request.getParameter( "doc_type_code" )==null?"":request.getParameter( "doc_type_code" ) ;
	String doc_no	= request.getParameter( "doc_no" )==null?"":request.getParameter( "doc_no" ) ;
	String trn_type	= request.getParameter( "trn_type" )==null?"":request.getParameter( "trn_type" ) ;
    String p_list_all_trades="";
	

	if(p_list_all_trades_yn.equals("N")&&(!trade_id.equals("")))
	{
     p_list_all_trades="disabled";
	}

	String store_code= request.getParameter( "store_code" )==null?"":request.getParameter( "store_code" ) ;
	String rdonly="";
	String TRADE_ID						="";
	String SHORT_NAME					="";
	String expired_include_disabled		="";
	String suspended_include_disabled	="";
	String searchFunction				= request.getParameter( "searchFunction" )==null?"N":request.getParameter( "searchFunction" ) ;
	String batch_status_yn				= request.getParameter( "batch_status_yn" )==null?"N":request.getParameter( "batch_status_yn" ) ;
	String multipleSelect				= request.getParameter( "multipleSelect" )==null?"N":request.getParameter( "multipleSelect" ) ;
	String includeSuspendedBatches		= request.getParameter( "includeSuspendedBatches" )==null?"N":request.getParameter( "includeSuspendedBatches" ) ;
	String includeExpiredBatches		= request.getParameter( "includeExpiredBatches" )==null?"N":request.getParameter( "includeExpiredBatches" ) ;
	String itemStoreDisable		= request.getParameter( "itemStoreDisable" )==null?"N":request.getParameter( "itemStoreDisable" ) ;
	

	String includeZeroStockBatches	= request.getParameter( "includeZeroStockBatches" )==null?"N":request.getParameter( "includeZeroStockBatches" ) ;
	String cuttOffDate	= request.getParameter( "cuttOffDate" )==null?"":request.getParameter( "cuttOffDate" ) ;
	String maxAllowed="1";
	if(multipleSelect.equals("N"))maxAllowed="1";
	else if(multipleSelect.equals("Y"))maxAllowed="10";

	String use_after_expiry =(String)bean.getUseAfterExpiry(item_code);
	String includeExpiredBatchesChecked="";
	if(includeExpiredBatches.equals("Y") && use_after_expiry.equals("Y")) includeExpiredBatchesChecked="checked";

	String includeZeroStockBatchesChecked="";
	if(includeZeroStockBatches.equals("Y"))includeZeroStockBatchesChecked="checked";
	String includeSuspendedBatchesChecked="";	if(includeSuspendedBatches.equals("Y"))includeSuspendedBatchesChecked="checked";
	if(searchFunction.equals("Y") || itemStoreDisable.equals("Y"))
	{
		if(item_code.equals(""))
		{%>
			<script language="JavaScript">
				alert(getMessage("ST_ITEM_CODE_BLANK","ST"));
				//parent.window.close();
				parent.parent.document.getElementById('dialog_tag').close();
			</script>
		<%}else if (store_code.equals(""))
		{%>
				<script language="JavaScript">
				alert(getMessage("ST_STORE_CODE_BLANK","ST"));
				//parent.window.close();
				parent.parent.document.getElementById('dialog_tag').close();
				</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<%
		}
		else
			rdonly="disabled";
	}
	
	if(searchFunction.equals("Y"))
	{

	ArrayList alexp=new ArrayList();

    alexp=(ArrayList)bean.checkCountRecord(store_code,user_name);
	int size=alexp.size();
	if(size>0)
	{
		String expired_include=(String)alexp.get(0);
		String suspended_include=(String)alexp.get(1);
		if(expired_include.equals("N") || use_after_expiry.equals("N"))
		expired_include_disabled="disabled";
		else
	    expired_include_disabled="enabled"; 
	
		if(suspended_include.equals("N"))
			suspended_include_disabled="disabled";
		else
			suspended_include_disabled="enabled";
	}
		else{
		
			}

		}else{


	}

	bean.setMaxAllowed(maxAllowed) ;
	bean.setMultipleSelect(multipleSelect) ;
	bean.setSearchFunction(searchFunction) ;
	bean.setIncludeExpiredBatches(includeExpiredBatches) ;
	bean.setIncludeZeroStockBatches(includeZeroStockBatches) ;
	bean.setIncludeSuspendedBatches(includeSuspendedBatches) ;
	bean.setCuttOffDate(cuttOffDate) ;
   
	ArrayList TradeIdArraylist=new ArrayList();
	HashMap TradeIdMap = new HashMap();

	TradeIdArraylist=bean.getTradeId(item_code);
	if(item_code.equals(""))
	{
	TradeIdArraylist = bean.getTradeList("","");
   	}

	putObjectInBean("batchSearchBean",bean,request);

%>

<body onload='FocusFirstElement();' >
	<form name="BatchSearchCriteria_Form" id="BatchSearchCriteria_Form" >
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align=center>
			<form name="formBatchSearch" id="formBatchSearch" onSubmit= 'return submitPage();' >
       			<table border=0 cellspacing=0 cellpadding=0 width='100%'>
					<th   colspan=6><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></th>
					<tr>
						<td  class=label>
						<fmt:message key="eST.ItemFrom.label" bundle="${st_labels}"/>&nbsp;&nbsp;
						</td>
						<td class='fields' nowrap>
						<input type=text name=item_code_from size=20 maxlength=20 value="<%=item_code%>" <%=rdonly%> onBlur="">
						<input type=button name="item_search_from" id="item_search_from" class="button"   onClick="searchCodeItem(item_code_from);getTradeList();"  value='?' <%=rdonly%>>
						</td>
						<td  class=label>
						<fmt:message key="eST.ItemTo.label" bundle="${st_labels}"/>&nbsp;&nbsp;
						</td>
						<td class='fields' nowrap>
						<input type=text name=item_code_to size=20 maxlength=20 value="<%=item_code%>" <%=rdonly%> onBlur="" >
						<input type=button name="item_search_to" id="item_search_to" class="button"   onClick="searchCodeItem(item_code_to);getTradeList();"  value='?' <%=rdonly%>>
						</td>
						<td  class=label></td>
						<td  class=label></td>
					</tr>
					 <%if((searchFunction.equals("N"))&& (batch_status_yn.equals("Y"))){%>
					<tr>
						<td  class=label>
						<fmt:message key="eST.ItemClassFrom.label" bundle="${st_labels}"/>&nbsp;&nbsp;
						</td>
						<td class='fields'>
						<input type=text name=item_class_from size=20 maxlength=20 value="" >
						<input type=button name="item_class_search_from" id="item_class_search_from" class="button"   onClick="searchItemClass(item_class_from)"  value='?'>
						</td>
						<td  class=label>
						<fmt:message key="eST.ItemClassTo.label" bundle="${st_labels}"/>&nbsp;&nbsp;
						</td>
						<td class='fields'>
						<input type=text name=item_class_to size=20 maxlength=20 value="<%=item_code%>" >
						<input type=button name="item_class_search_to" id="item_class_search_to" class="button"   onClick="searchItemClass(item_class_to)"  value='?' >
						</td>
						<td  class=label></td>
						<td  class=label></td>
					</tr>
					 <%}%>
					<tr>
						<td  class=label>
						<fmt:message key="eST.StoreFrom.label" bundle="${st_labels}"/>&nbsp;&nbsp;
						</td>
						<td class='fields'>
						<input type=text name=store_code_from size=15 maxlength=15 value="<%=store_code%>" <%=rdonly%>>
						<input type=button name="store_search_from" id="store_search_from" class="button"   onClick="return searchCodeStore(store_code_from);"  value='?' <%=rdonly%>>
						</td>
						<td  class=label>
						<fmt:message key="eST.StoreTo.label" bundle="${st_labels}"/>&nbsp;&nbsp;
						</td>
						<td class='fields'>
						<input type=text name=store_code_to size=15 maxlength=15 value="<%=store_code%>" <%=rdonly%>>
						<input type=button name="store_search_to" id="store_search_to" class="button"   onClick="return searchCodeStore(store_code_to);"  value='?' <%=rdonly%>>
						</td>
						<td  class=label></td>
						<td  class=label></td>
					</tr>
					<%if(!(batch_status_yn.equals("Y"))){%>
					 <tr>
					<td  class=label><fmt:message key="Common.Manufacturer.label" bundle="${mm_labels}"/>&nbsp;&nbsp;</td>
					<td class='fields'>
					<select name=manufacturer_code><%=bean.getManufacturerList()%></select></td>
					<td  class=label><fmt:message key="eST.BatchExpiresNext.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td>
					<td  class=fields><input type=text class= "NUMBER" name=period_of_expiry size=3 maxlength=3 onKeyPress="return isValidInteger();" onblur="checkDoubleFormat(this);">&nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
					<td  class=label>
						 <input type=hidden name=item_class_from value="" size="1">
						 <input type=hidden name=item_class_to value="" size="1">
					</td>
					<td  class=label></td>
				</tr>
				
				<tr>

				<td  class=label><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td class='fields'>
					<select name="Trade_code" id="Trade_code"<%=p_list_all_trades%>>
					<%if(p_multi_trade_select_yn.equals("Y")){%>
					<OPTION value=""selected>&nbsp;---Select--- &nbsp;</OPTION>
                    <%}
                  for(int i=0; i<TradeIdArraylist.size(); i++)
				{
					TradeIdMap = (HashMap)TradeIdArraylist.get(i);
					TRADE_ID = (String)TradeIdMap.get("TRADE_ID");
                    SHORT_NAME = (String)TradeIdMap.get("SHORT_NAME");
			     if(trade_id.equals(TRADE_ID)){%>
				 <OPTION value="<%=trade_id%>"selected><%=SHORT_NAME%></OPTION>
               <%}else{%>

            <OPTION value="<%=TRADE_ID%>"><%=SHORT_NAME%></OPTION>
			<%
			}
				}
			%>

  </SELECT>	  
				<td  class=label><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<!--
				* @Name - Priya
				* @Date - 04/02/2010
				* @Inc# - 15496 (SRR20056-CRF-0537.2)
				* @Desc - maxlength & size of the text field 'batch_id' is increased to 20
				-->
				<td class='fields'><input type='text' value="" name="batch_id" id="batch_id" maxlength=20 size=20>
      		     <fmt:message key="eST.IncludeExpiredBatches.label" bundle="${st_labels}"/>
				<input type=checkbox name=includeExpiredBatches value='Y' <%=includeExpiredBatchesChecked%> <%=expired_include_disabled%>></td>
				<td class='label'></td><td class='label'></td>

			</tr>
			<tr>
				<td  class=label><fmt:message key="eST.IncludeZeroStockBatches.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td>
				<td class='fields'><input type=checkbox name=includeZeroStockBatches value='Y' <%=includeZeroStockBatchesChecked%>></td>
				<td class=label><fmt:message key="eST.IncludeSuspendedBatches.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td>

					<%}else if((batch_status_yn.equals("Y"))){ %>
					<tr>
						<td  class=label>
						<fmt:message key="eST.DrugNonDrug.label" bundle="${st_labels}"/>&nbsp;&nbsp;
						</td>
						<td  class=fields>
						 <select name="drug_type" id="drug_type">
						 <option value="%" selected>
						  <fmt:message key="Common.Both.label" bundle="${common_labels}"/>
						 </option>								 
						 <option value="Y">
						 <fmt:message key="Common.Drug.label" bundle="${common_labels}"/>
						 </option>
						 <option value="N">
						 <fmt:message key="eST.NonDrug.label" bundle="${st_labels}"/>
						 </option>
						 </select>
						</td>
						<td  class=label>
						<fmt:message key="Common.Manufacturer.label" bundle="${mm_labels}"/>&nbsp;&nbsp;
						</td>
						<td class='fields'>
						<select name=manufacturer_code><%=bean.getManufacturerList()%></select>
						</td>						
						<td  class=label></td>
						<td  class=label></td>
					</tr>
				
					<tr>

					<td  class=label>
					<fmt:message key="eST.BatchExpiresNext.label" bundle="${st_labels}"/>&nbsp;&nbsp;
					</td>
					<td class='fields'>
					<input type=text class= "NUMBER" name=period_of_expiry size=3 maxlength=3 onKeyPress="return isValidInteger();" onblur="checkDoubleFormat(this);">&nbsp;
					<fmt:message key="Common.days.label" bundle="${common_labels}"/>
					</td>
					<td  class=label>
					<fmt:message key="Common.BatchID.label" bundle="${common_labels}"/>&nbsp;&nbsp;
					</td>
					<!--
				* @Name - Priya
				* @Date - 04/02/2010
				* @Inc# - 15496 (SRR20056-CRF-0537.2)
				* @Desc - maxlength & size of the text field 'batch_id' is increased to 20
				-->
					<td class='fields'>
					<input type='text' value="" name="batch_id" id="batch_id" maxlength=20 size=20>
					 <fmt:message key="eST.IncludeExpiredBatches.label" bundle="${st_labels}"/>
					<input type=checkbox name=includeExpiredBatches value='Y' <%=includeExpiredBatchesChecked%> <%=expired_include_disabled%>>
					</td>
					<td class='label'></td>
					<td class='label'></td>

				</tr>
				<tr>
					<td  class=label>  					
					<fmt:message key="Common.TradeName.label" bundle="${common_labels}"/>&nbsp;&nbsp;						
					</td>
					<td class='fields'>
					<select name="Trade_code" id="Trade_code"<%=p_list_all_trades%>>
						<%if(p_multi_trade_select_yn.equals("Y")){%>
						<OPTION value=""selected>&nbsp;---Select--- &nbsp;</OPTION>
						<%}
					  for(int i=0; i<TradeIdArraylist.size(); i++)
						{
						TradeIdMap = (HashMap)TradeIdArraylist.get(i);
						TRADE_ID = (String)TradeIdMap.get("TRADE_ID");
						SHORT_NAME = (String)TradeIdMap.get("SHORT_NAME");
					 if(trade_id.equals(TRADE_ID)){%>
					 <OPTION value="<%=trade_id%>"selected><%=SHORT_NAME%></OPTION>
						<%}else{%>

						<OPTION value="<%=TRADE_ID%>"><%=SHORT_NAME%></OPTION>
					<%
					}
						}
					%>	 
					</SELECT>	
					</td>
					<td class=label>
					<fmt:message key="eST.IncludeSuspendedBatches.label" bundle="${st_labels}"/>&nbsp;&nbsp;
					</td>
					 <%}%>
					<%if(searchFunction.equals("Y")){%>
					<td class='fields'>
					<input type=checkbox name=includeSuspendedBatches value='Y' <%=includeSuspendedBatchesChecked%> <%=suspended_include_disabled%>>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type='button'  class='BUTTON' name='previous' id='previous' value='<fmt:message key="Common.previous.label" bundle="${common_labels}"/>' disabled onClick='goPrev();'>
					<input type='button' class='BUTTON' name='next' id='next' value='<fmt:message key="Common.next.label" bundle="${common_labels}"/>' onClick='goNext();' disabled>
					<input type='button' class='BUTTON' name='search' id='search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='searchVals();'>
					<input type=button class=button name="Close" id="Close" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>'  onclick="returnVals();"></td>
					<%}else if(searchFunction.equals("N")){ %>
					<td class='fields'>
					<input type=checkbox name=includeSuspendedBatches value='Y' <%=includeSuspendedBatchesChecked%>>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type='button'  class='BUTTON' name='previous' id='previous' value='<fmt:message key="Common.previous.label" bundle="${common_labels}"/>' disabled onClick='goPrev();'>
					<input type='button' class='BUTTON' name='next' id='next' value='<fmt:message key="Common.next.label" bundle="${common_labels}"/>' onClick='goNext();' disabled>
					<input type='button' class='BUTTON' name='search' id='search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='searchVals();'></td>
					<%}%>
					 <td  class=label></td>
					<td  class=label></td>
				</tr>
				 <%if((batch_status_yn.equals("Y"))){%>
				<tr>
					<td  class=label>
					<fmt:message key="eST.IncludeZeroStockBatches.label" bundle="${st_labels}"/>&nbsp;&nbsp;
					</td>
					<td class='fields'>
					<input type=checkbox name=includeZeroStockBatches value='Y' <%=includeZeroStockBatchesChecked%>>
					</td>
					<td  class=label></td>
					<td  class=fields></td>
					<td  class=label></td>
					<td  class=label></td>
				</tr>
				<%}%>
		</table>
</center>
</table>
<input type=hidden name=facility_id value="<%=bean.getLoginFacilityId()%>">
<input type=hidden name=searchFunction value="<%=searchFunction%>">
<input type=hidden name=multipleSelect value="<%=multipleSelect%>">
<input type=hidden name=p_language_id value="<%=locale%>">
<input type=hidden name=p_list_all_trades_yn value="<%=p_list_all_trades_yn%>">
<input type=hidden name=doc_type_code value="<%=doc_type_code%>">
<input type=hidden name=doc_no value="<%=doc_no%>">
<input type=hidden name=trn_type value="<%=trn_type%>">

<input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
<input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_LANG" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG"	value="<%=eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT")+"'"+locale+"' and APPL_ST_YN='Y'"%>">
<script>
<%if (!(store_code.equals("")&&item_code.equals(""))) {
	out.println("searchVals();");
}%>
</script>
</form>

</body>
</html>

