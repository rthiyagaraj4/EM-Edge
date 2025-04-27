<!DOCTYPE html>
 
<%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
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
		<script language="javascript" src="../../eST/js/PhysicalInventoryEntry.js"></script>
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
	String p_list_all_trades="";
	if(p_list_all_trades_yn.equals("N")&&(!trade_id.equals("")))
	{
     p_list_all_trades="disabled";
	}

	String store_code= request.getParameter( "store_code" )==null?"":request.getParameter( "store_code" ) ;
	String batch_id= request.getParameter( "batch_id" )==null?"":request.getParameter( "batch_id" ) ; //Added By Sakti against CRF# - RUT-CRF-0081 icn#34757

	String TRADE_ID						="";
	String SHORT_NAME					="";
	String expired_include_disabled		="";
	String suspended_include_disabled	="";
	String searchFunction				= request.getParameter( "searchFunction" )==null?"N":request.getParameter( "searchFunction" ) ;

	String multipleSelect				= request.getParameter( "multipleSelect" )==null?"N":request.getParameter( "multipleSelect" ) ;
	String includeSuspendedBatches		= request.getParameter( "includeSuspendedBatches" )==null?"N":request.getParameter( "includeSuspendedBatches" ) ;
	String includeExpiredBatches		= request.getParameter( "includeExpiredBatches" )==null?"N":request.getParameter( "includeExpiredBatches" ) ;
	String includeExpiredBatchesasN		= request.getParameter( "includeExpiredBatches" )==null?"N":request.getParameter( "includeExpiredBatches" ) ;
System.out.println("includeExpiredBatches in jsp"+includeExpiredBatches);
	

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
	if(searchFunction.equals("Y"))
	{
		if(item_code.equals(""))
		{%>
			<script language="JavaScript">
				alert(getMessage("ST_ITEM_CODE_BLANK","ST"));
				parent.window.close();
			</script>
		<%}else if (store_code.equals(""))
		{%>
				<script language="JavaScript">
				alert(getMessage("ST_STORE_CODE_BLANK","ST"));
				parent.window.close();
				</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



		<%
		}
		
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
	
	putObjectInBean("batchSearchBean",bean,request);

//Added By Sakti against CRF# - RUT-CRF-0081 icn#34757
	String dflt_cutoff_days = (String)(bean.fetchRecord("SELECT DFLT_CUTOFF_DAYS FROM ST_FACILITY_PARAM WHERE FACILITY_ID = ?", new String[] {bean.getLoginFacilityId()})).get("DFLT_CUTOFF_DAYS");

	String process_suspended_items_yn = (String)(bean.fetchRecord("SELECT PROCESS_SUSPENDED_ITEMS_YN FROM st_user_access_for_store WHERE USER_ID = ? AND STORE_CODE = ?", new String[] {bean.getLoginById(),store_code})).get("PROCESS_SUSPENDED_ITEMS_YN");
	if(process_suspended_items_yn.equals("N")) {
		suspended_include_disabled="disabled";
		includeSuspendedBatchesChecked = "";
	}
	
//Added ends

%>

<body onload='FocusFirstElement();' >
	<form name="BatchSearchCriteria_Form" id="BatchSearchCriteria_Form" onSubmit= 'return submitPage();' >
		<table border="0" cellpadding="0" cellspacing="1" width='100%' align=center>
				<form name="formBatchSearch" id="formBatchSearch" onSubmit= 'return submitPage();' >
       				<table border=0 cellspacing=1 cellpadding=0 width='100%'>
					<th   colspan=6><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></th>
				<tr>
					<td  class=label><fmt:message key="eST.ItemFrom.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td>
					<td class='FIELDS'><input type=text name=item_code_from size=20 maxlength=20 value="<%=item_code%>" readonly ><input type=button name="item_search_from" id="item_search_from" class="button"   onClick="searchCodeItem(item_code_from)"  value='?' disabled></td>
					<td  class=label><fmt:message key="eST.ItemTo.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td>
					<td class='FIELDS'><input type=text name=item_code_to size=20 maxlength=20 value="<%=item_code%>" readonly><input type=button name="item_search_to" id="item_search_to" class="button"   onClick="searchCodeItem(item_code_to)"  value='?' disabled></td>
					<td  class=label></td>
					<td  class=label></td>
				</tr>
				<tr>
					<td  class=label><fmt:message key="eST.StoreFrom.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td>
					<td class='FIELDS'><input type=text name=store_code_from size=15 maxlength=15 value="<%=store_code%>" ><input type=button name="store_search_from" id="store_search_from" class="button"   onClick="return searchCodeStore(store_code_from);"  value='?' ></td>
					<td  class=label><fmt:message key="eST.StoreTo.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td>
					<td class='FIELDS'><input type=text name=store_code_to size=15 maxlength=15 value="<%=store_code%>"><input type=button name="store_search_to" id="store_search_to" class="button"   onClick="return searchCodeStore(store_code_to);"  value='?' ></td>
					<td  class=label></td>
					<td  class=label></td>
				</tr>
				<tr>
					<td  class=label><fmt:message key="Common.Manufacturer.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td><!-- Modified for IN:074037  -->
					<td class='FIELDS'>
					<select name=manufacturer_code><%=bean.getManufacturerList()%></select></td>
					<td  class=label><fmt:message key="eST.BatchExpiresNext.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td>
					<td  class=FIELDS><input type=text class= "NUMBER" name=period_of_expiry size=3 maxlength=3 onKeyPress="return isValidInteger();" onblur="checkDoubleFormat(this);">&nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
					<td  class=label></td>
					<td  class=label></td>
				</tr>
				
				<tr>

				<td  class=label><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td class='FIELDS'>
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
				<td class='FIELDS'><input type='text' value="<%=batch_id%>" name="batch_id" maxlength=10 size=10>
      		     <fmt:message key="eST.IncludeExpiredBatches.label" bundle="${st_labels}"/>
				<input type=checkbox name=includeExpiredBatches value='Y' <%=includeExpiredBatchesChecked%> <%=expired_include_disabled%>></td>
				<td class='label'></td><td class='label'></td>

			</tr>
			<tr>
				<td  class=label><fmt:message key="eST.IncludeZeroStockBatches.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td>
				<td class='FIELDS'><input type=checkbox name=includeZeroStockBatches value='Y' <%=includeZeroStockBatchesChecked%>></td>
				<td class=label><fmt:message key="eST.IncludeSuspendedBatches.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td>
				
				<%if(searchFunction.equals("Y")){%>
				<td class='FIELDS'><input type=checkbox name=includeSuspendedBatches value='Y' <%=includeSuspendedBatchesChecked%> <%=suspended_include_disabled%>>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='button'  class='BUTTON' name='previous' id='previous' value='<fmt:message key="Common.previous.label" bundle="${common_labels}"/>' disabled onClick='goPrev();'><input type='button' class='BUTTON' name='next' id='next' value='<fmt:message key="Common.next.label" bundle="${common_labels}"/>' onClick='goNext();' disabled><input type='button' class='BUTTON' name='search' id='search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='searchVals();'><input type=button class=button name="Close" id="Close" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>'  onclick="getVals();"></td>
				<%}else if(searchFunction.equals("N")){ %>
				<td class='FIELDS'><input type=checkbox name=includeSuspendedBatches value='Y' <%=includeSuspendedBatchesChecked%>>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='button'  class='BUTTON' name='previous' id='previous' value='<fmt:message key="Common.previous.label" bundle="${common_labels}"/>' disabled onClick='goPrev();'><input type='button' class='BUTTON' name='next' id='next' value='<fmt:message key="Common.next.label" bundle="${common_labels}"/>' onClick='goNext();' disabled><input type='button' class='BUTTON' name='search' id='search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='searchVals();'></td>
				<%}%>
                  <td  class=label></td>
					<td  class=label></td>
			</tr>
			<!--Added By Sakti against CRF# - RUT-CRF-0081 icn#34757-->
			<tr>
			<td  class=label><fmt:message key="eST.CutoffDays.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td>
			<td  class=FIELDS><input type=text class= "NUMBER" name='cut_off_date_for_grn' id='cut_off_date_for_grn' size=5 maxlength=5 value="<%=bean.checkForNull(dflt_cutoff_days)%>" onKeyPress="return isValidInteger();" onblur="return isValidIntegerZero(this);">&nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/></td>

			<td  class=label><fmt:message key="Common.Detail.label" bundle="${common_labels}"/>&nbsp;</td>
			<td class='FIELDS'><input type='radio' name="searchby" id="searchby" value="D" onclick = "" >
      		&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Summary.label" bundle="${common_labels}"/>&nbsp;
			<input type='radio' name="searchby" id="searchby" value="S" onclick= "" checked></td>
			<td class='label'></td>&nbsp;<td class='label'>&nbsp;</td>
			
			</tr>
	
	</table>
</center>
</table>
<input type=hidden name=facility_id value="<%=bean.getLoginFacilityId()%>">
<input type=hidden name=searchFunction value="<%=searchFunction%>">
<input type=hidden name=multipleSelect value="<%=multipleSelect%>">
<input type=hidden name=selectedBatch value="">
<input type=hidden name=p_language_id value="<%=locale%>">
<input type=hidden name=p_list_all_trades_yn value="<%=p_list_all_trades_yn%>">
<input type=hidden name=includeExpiredBatchesasN value="<%=includeExpiredBatchesasN%>">

<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
<script>
<%if (!(store_code.equals("")&&item_code.equals(""))) {
	out.println("searchVals();");
}%>
</script>
</form>

</body>
</html>
 

