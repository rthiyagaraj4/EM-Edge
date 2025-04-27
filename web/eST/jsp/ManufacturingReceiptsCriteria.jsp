
 <%@ page  import=" eST.*, eST.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.sql.*,webbeans.eCommon.*"
contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title> </title>
<!-- 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
	request.setCharacterEncoding("UTF-8");
	String locale			=	(String)session.getAttribute("LOCALE");
	String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 	
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eST/js/StTransaction.js"></script>
	<script language="JavaScript" src="../../eST/js/ManufacturingReceipts.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	
	ManufacturingReceiptsBean bean		=	(ManufacturingReceiptsBean) getBeanObject( "ManufacturingReceiptsBean","eST.ManufacturingReceiptsBean",request );
	bean.setLanguageId(locale);
	StHeaderBean beanHdr				=	(StHeaderBean) getBeanObject( "stHeaderBean","eST.Common.StHeaderBean",request );
	beanHdr.setLanguageId(locale);
	

	//String store_code					=		beanHdr.getStore_code();
	ArrayList ALDetailData				=		bean.getDataDtlList();
	String disable						=		"";
	float unit_cost						=		0.0f;
	String index						=		request.getParameter("index")==null?"-1":request.getParameter("index");
	String mode							=		request.getParameter("mode");

	String item_code					=		request.getParameter("item_code");
	String qty							=		request.getParameter("qty")==null?"":request.getParameter("qty");
	String display_flag					=		"visibility:hidden";
	String stButtonLegend				=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels");
	HashMap DtlArray					=		new HashMap();
	String allow_deci_yn        =       "";
	int 	no_deci              =     bean.getNoOfDecimals();
	allow_deci_yn        =       bean.checkForNull(bean.getAllowDecimalsYN(item_code),"N");
          if(allow_deci_yn.equals("Y"))
			no_deci              =     bean.getNoOfDecimals();
			else
           no_deci   = 0;
	/**
		 * @Name - Priya
		 * @Date - 03/06/2010
		 * @Inc# - 
		 * @Desc -  To get no of decimals for cost and round up cost with noOfDecimalsForCost
		 */
	int noOfDecimalsForCost=Integer.parseInt(bean.getNoOfDecimalsCost());
	if(!index.equals("-1"))
	{
		disable							=		"disabled";
		ALDetailData					=		bean.getDataDtlList();
		stButtonLegend					=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels");
		DtlArray						=		(HashMap)ALDetailData.get(Integer.parseInt(index));
		unit_cost						=		Float.parseFloat(qty)*Float.parseFloat(bean.setNumber(((String)DtlArray.get("UNIT_COST")),noOfDecimalsForCost));
		unit_cost						=		Float.parseFloat(bean.setNumber(""+unit_cost,noOfDecimalsForCost));
	}
		if(((String)bean.getAccessCostDetails()).equals("Y"))
			display_flag				=		"visibility:visible";
%>

	</head>
<body onLoad="FocusFirstElement();">
<form name=formHeaderCriteria>
	<table border='0' cellpadding='2' cellspacing='0' width='100%' align=center>
	<tr>
		<td class=label ><fmt:message key="Common.item.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td colspan=5  class=fields><input type=text name=item_desc size=70 maxlength=60 <%=disable%> value="<%=bean.checkForNull(((String)DtlArray.get("SHORT_DESC")))%>"  ><input type=button name="item_search" id="item_search" class="button" onClick="callItemSearchScreen(item_code)"  value='?' <%=disable%>  ><%=bean.getImage("M")%><b  id=td_uom  ><%=bean.checkForNull(((String)DtlArray.get("STOCK_UOM")))%>&nbsp;</b></td>
	</tr>
	<tr>
		<td class=label ><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td   colspan=5 class=fields ><input type=text name=adj_item_qty size=12    value="<%=bean.setNumber(qty,no_deci)%>" maxlength=12 class="NUMBER" onkeypress="return isValidNumber(this,event,7,<%=bean.getNoOfDecimals()%>);" onblur= "calculatecost();"><%=bean.getImage("M")%>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label style=<%=display_flag%>><fmt:message key="Common.Cost.label" bundle="${common_labels}"/>&nbsp;&nbsp;
		<b id=td_cost><%=bean.checkForNull(bean.setNumber(((String)DtlArray.get("UNIT_COST")),noOfDecimalsForCost),"")%></b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  &nbsp;<fmt:message key="Common.Value.label" bundle="${common_labels}"/>
		<b  id="val_id" > <%=unit_cost%>&nbsp;</b></label></td>
		</tr>
	<tr>
		<td class=fields  colspan='6'><input type=button name="edit" id="edit"value='<fmt:message key="eST.Edit/View.label" bundle="${st_labels}"/>'   class=button onclick="editViewBatch('<%=mode%>');" ><input type=button name=batchsearch value='<fmt:message key="eST.BatchSearch.label" bundle="${st_labels}"/>'   class=button onclick="callBatchSearch('<%=mode%>');" ><input type=button name="apply" id="apply" value="<%=stButtonLegend%>" class=button onclick="addToList ('<%=mode%>');"><input type=button name=Cancel value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'  class=button onclick="cancelForm();">
		</td> 
	</tr>
	</table>
	<BR>
	<input type="hidden" name="item_code" id="item_code"		value="<%=bean.checkForNull(((String)DtlArray.get("CHILD_ITEM_CODE")))%>">
	<input type="hidden" name="store_code" id="store_code"		value="<%=bean.getStore_code()%>">
	<input type="hidden" name="short_desc" id="short_desc"		value="<%=bean.checkForNull(((String)DtlArray.get("SHORT_DESC")))%>">
	<input type="hidden" name="doc_no" id="doc_no"			value="<%=bean.getDoc_no()%>">
	<input type="hidden" name="index" id="index"			value="<%=index%>">
	<input type="hidden" name="prep_qty" id="prep_qty"		value="<%=qty%>">
	<input type="hidden" name="item_unit_cost" id="item_unit_cost" >
	<input type="hidden" name="uom" id="uom" >
	<input type="hidden" name="stock_item_yn" id="stock_item_yn">
	<input type="hidden" name="stock_available_yn" id="stock_available_yn">
	<input type="hidden" name="allow_deci_yn" id="allow_deci_yn" 	value="Y">
	<input type="hidden" name="no_deci" id="no_deci" value="<%=no_deci%>">
	<input type="hidden" name="dec_allowed_yn" id="dec_allowed_yn" value="Y">
	<input type="hidden" name="no_of_decimals" id="no_of_decimals" value="<%=no_deci%>">
	<input type="hidden" name="no_of_decimals_for_cost" id="no_of_decimals_for_cost" value='<%=noOfDecimalsForCost%>'>

<%
	putObjectInBean("ManufacturingReceiptsBean",bean,request);
	putObjectInBean("stHeaderBean",beanHdr,request);
%>
</form>
</body>
</html>

