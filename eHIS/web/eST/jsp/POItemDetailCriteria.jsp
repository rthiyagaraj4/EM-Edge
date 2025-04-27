<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		       Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
27/11/2019      IN:071539               B Haribabu         28/11/2019         Manickam                NMC-JD-CRF-0029
--------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import=" eST.*,eST.Common.*,java.util.*,eCommon.Common.*, java.text.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%><!-- Modified for IN:071539 -->
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<%
		request.setCharacterEncoding("UTF-8");
		String locale		=	(String)session.getAttribute("LOCALE");

		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
		<script language="JavaScript" src="../../eST/js/StMessages.js"></script>
		<script language="JavaScript" src="../../eST/js/GoodsReceivedNote.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
</head>
<%
	String facility_id							=		(String) session.getValue( "facility_id" ) ;
	String user									=		(String) session.getValue( "login_user" );

	String bean_id								=		"goodsReceivedNoteBean";
	String bean_name							=		"eST.GoodsReceivedNoteBean";

	GoodsReceivedNoteBean bean = (GoodsReceivedNoteBean) getBeanObject( bean_id, bean_name,request );	

	String po_number								   =       bean.checkForNull(request.getParameter("po_number"));
	String store_code								   =	   bean.checkForNull(request.getParameter("store_code"));
	String mode										   =	   bean.checkForNull(request.getParameter("mode"));	
	String supp_code								   =	   bean.checkForNull(request.getParameter("supp_code"));
	String codeDisabled								   =		"";
	String codeDisabledforDO						   =		"";
	String do_no									   =	   bean.checkForNull(request.getParameter("do_no"));
	//Added for IN:071539 start
    Connection con				= null;
	 
	boolean item_sort_appl = false;
	
	try 
	{
		con						= ConnectionManager.getConnection(request);
		item_sort_appl = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_GRN_PO_SEARCH_SORT");
		
	} 
	catch (Exception e) 
	{
		e.printStackTrace(System.err);
		System.out.println(" Error in Criteria Page " + e.getMessage());
	} 
	finally 
	{
		if (con != null) ConnectionManager.returnConnection(con, request);
	}
	//Added for IN:071539 end

	if(mode.equals("2")){
	codeDisabled = "Readonly";
	//codeDisabledforDO = "disabled";
	}
//System.out.println("do_no======================43="+do_no);

	HashMap alstartdate      = bean.getDurationforStartDate();
    String currentdate	   =  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("SYSTEMDATE"),"DMY","en",locale);
	String currentdateminus	=  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("DURATIONFORSTARTDATE"),"DMY","en",locale);

%>
<body onload='FocusFirstElement();document.formPOItemDetailCriteria.submit();' >
	<form name="formPOItemDetailCriteria" id="formPOItemDetailCriteria" action="../../eST/jsp/POItemDetailResult.jsp" method="post" target="framePOItemDetailResult" onReset='FocusFirstElement();'>
	<table border="0" cellpadding="0" cellspacing="0" width='100%' align="center">	
		<th  colspan=5><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></th>
		<tr>
	    <td class="label"  ><fmt:message key="Common.item.label"	bundle="${common_labels}"/></td>
		<td>&nbsp;&nbsp;<input type=text name=item_desc id=item_desc  size=70 maxlength=60 value="" onblur='if(this.value!=""){searchItemCode(this)}' ><input type=hidden name="item_code" id="item_code" value=""  ><input type='button' class='button' value='?' onClick='searchItemCode(item_desc)' name="item_search" id="item_search"></td>
			
		<td class="label"><fmt:message key="eST.PORaisedBy.label" bundle="${st_labels}"/></td>
		<td class="fields">&nbsp;
			<select name="purchase_unit" id="purchase_unit">
			<%=bean.getPurchaseUnitList()%>
			</select>
		</td>	
		<td>&nbsp;</td>
		</tr>
		<tr>

		<td  class="label">
		<fmt:message key="Common.fromdate.label" bundle="${common_labels}"/></td>
		<td class="label">&nbsp;&nbsp;
		<input type="text" name="from_doc_date" id="from_doc_date" size="10" maxlength="10" value="<%=currentdateminus%>" onBlur="CheckDate(this);">
		<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('from_doc_date');"></img>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<fmt:message key="Common.todate.label" bundle="${common_labels}"/>
		<input type="text" name="to_doc_date" id="to_doc_date" size="10" maxlength="10"  value="<%=currentdate%>" onBlur="CheckDate(this);">
		<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('to_doc_date');"></img> 
		</td>

		<td class="label"><fmt:message key="eST.PONumber.label" bundle="${st_labels}"/></td>
		<td>&nbsp;&nbsp;<input type="text" size="15" maxlength="20"  name="doc_no" id="doc_no" onKeyPress="return CheckForSpecialChars(event);" value="<%=po_number%>" <%=codeDisabled%> ></td>
		</tr>

		<tr>
		<!-- Added for IN:071539 start -->
		<%if(item_sort_appl){ %>
		<td colspan=2 align="right" class="label"><fmt:message key="eST.SortByItemDesc.label" bundle="${st_labels}"/>&nbsp;
		<input type='radio' name="sort_by" id="sort_by" value="ITEMDESC" checked>
		&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eST.SortByItemCode.label" bundle="${st_labels}"/>&nbsp;
		<input type='radio' name="sort_by" id="sort_by" value="ITEMCODE" ></td>
		<%} %>
		<!-- Added for IN:071539 end -->
		<td class="label"><fmt:message key="eST.DoNo.label" bundle="${st_labels}"/></td>
		<td class="fields">&nbsp;
			<select name="do_no" id="do_no">
			<%=bean.getDoNoList(do_no,store_code,mode,supp_code)%>
			</select>
		</td>

		<td align="left">
		<input type=button name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick="document.formPOItemDetailCriteria.submit();" >&nbsp;
		<input type=button name="reset" id="reset" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' style="font-family:verdana;width:5em"  onclick="ReloadWindow();">
		</td>

        </tr>
	</table>

	 <input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
	 <input type="hidden" name="po_number" id="po_number"	value="<%=po_number%>">
	 <input type="hidden" name="store_code" id="store_code" value="<%=store_code%>">
	 <input type="hidden" name="mode" id="mode" value="<%=mode%>">
	 <input type="hidden" name="supp_code" id="supp_code" value="<%=supp_code%>">
	 <input type="hidden" name="loc_batch_string" id="loc_batch_string" value="">
	 <input type="hidden" name="l_from_doc_date" id="l_from_doc_date" value="<%=currentdateminus%>">
	 <input type="hidden" name="l_to_doc_date" id="l_to_doc_date" value="<%=currentdate%>">
</form>
<%
	putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

