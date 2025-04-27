<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8" import=" eST.*,eST.Common.*,java.util.*,java.lang.*"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=		(String)session.getAttribute("LOCALE");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<script language="JavaScript" src="../../eST/js/ChangeBinLocation.js"></script>
<%
	int i						=		0;
	String mode;
	String bean_id;
	String bean_name;
	String function_id;

	mode						=		request.getParameter( "mode" ) ;
	if(mode==null)	mode		=		"1";
	function_id					=		request.getParameter( "function_id" ) ;
	
	bean_id						=		"ChangeBinLocationBean" ;
	bean_name					=		"eST.ChangeBinLocationBean";

	ChangeBinLocationBean bean	=		(ChangeBinLocationBean) getBeanObject( "ChangeBinLocationBean","eST.ChangeBinLocationBean" ,request);
	bean.setLanguageId(locale);

	StHeaderBean beanHdr		=	(StHeaderBean) getBeanObject( "stHeaderBean", "eST.Common.StHeaderBean",request);
    bean.setChangeBinLocationHeaderBean(beanHdr);

	ArrayList ALDetailData		=	bean.getDetailValues();


%>

<BODY>
<form name=formChangeBinLocationDetail>
<table border=1  cellpadding="0" cellspacing="0" width='100%' align=center>
<TR>
    <TH class="QRYODD"><fmt:message key="Common.delete.label" bundle="${common_labels}"/></th>
	<TH class="QRYODD"><fmt:message key="Common.item.label" bundle="${common_labels}"/></TH>
	<TH class="QRYODD"><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></TH>
	<TH class="QRYODD"><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></TH>
    <TH class="QRYODD"><fmt:message key="Common.uom.label" bundle="${common_labels}"/></TH>
    <TH class="QRYODD"><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></TH>
	<TH class="QRYODD"><fmt:message key="eST.FromBinLocation.label" bundle="${st_labels}"/></TH>
    <TH class="QRYODD"><fmt:message key="eST.AvailableQty.label" bundle="${st_labels}"/>.</TH>
	<TH class="QRYODD"><fmt:message key="eST.ToBinLocation.label" bundle="${st_labels}"/></TH>
    <TH class="QRYODD"><fmt:message key="eST.QuantityToTransfer.label" bundle="${st_labels}"/></TH>
 
</TR>
<%
	HashMap ht						=		new HashMap();
   for(i=0;i<ALDetailData.size();i++)
	   {
		String classValue				=		"";
		ht								=		(HashMap)ALDetailData.get(i);
		String item_code				=		(String)ht.get("item_code");
		String allow_deci_yn = "";
        String no_deci    = "";
        allow_deci_yn        =       bean.checkForNull(bean.getAllowDecimalsYN(item_code),"N");
        if(allow_deci_yn.equals("Y"))
		no_deci              =       ""+bean.checkForNull(""+bean.getNoOfDecimals(),"0");
		else
         no_deci   = "0";
		String item_desc				=		(String)ht.get("item_desc");
		String doc_srl_no				=		(String)ht.get("doc_srl_no");
		String batch_id					=		(String)ht.get("batch_id");
		String trade_name				=		(String)ht.get("trade_name");
	//	String avail_qty				=		(String)ht.get("avail_qty");
        String uom						=		(String)ht.get("uom");
		String exp_date					=		(String)ht.get("exp_date");
		String bin_desc					=		(String)ht.get("old_bin_loc_desc");
		String new_bin_loc_code			=		(String)ht.get("new_bin_loc_code");
		String new_bin_loc_desc			=		(String)ht.get("new_bin_loc_desc");
		String adj_item_qty				=	    bean.setNumber((String)ht.get("adj_item_qty"),Integer.parseInt(no_deci)).replace(".", "");
		String old_bin_loc_desc			=		(String)ht.get("old_bin_loc_desc");
        String avl_item_qty				=	bean.setNumber((String)ht.get("avl_item_qty"),Integer.parseInt(no_deci)).replace(".", "");
		
		if(i%2==0)	classValue			=		"QRYEVEN";
		else		classValue			=		"QRYODD";
%>
	<tr id="tr_<%=i%>">
		    <td  class="<%=classValue%>" ><input type='checkbox' name="checkbox<%=i%>" id="checkbox<%=i%>" ></td>
		    <td  class="<%=classValue%>" style="WORD-BREAK:BREAK-ALL;">
			<a  name="a_<%=i%>" href="javascript:populateData('<%=i%>','<%=item_code%>','<%=item_desc%>','<%=doc_srl_no%>','<%=batch_id%>','<%=trade_name%>','<%=avl_item_qty%>','<%=uom%>','<%=exp_date%>','<%=bin_desc%>','<%=new_bin_loc_desc%>','<%=adj_item_qty%>','<%=new_bin_loc_code%>')"><font size=1><%=ht.get("item_desc")%></font></a></td>
            <td  class="<%=classValue%>"><font size=1><%=batch_id%></font></td>
			<td  class="<%=classValue%>"><font size=1><%=com.ehis.util.DateUtils.convertDate(exp_date,"DMY","en",locale)%></font></td>
			<td  class="<%=classValue%>"><font size=1><%=uom%></font></td>
            <td  class="<%=classValue%>"><font size=1><%=trade_name%></font></td>
			<td  class="<%=classValue%>"><font size=1><%=old_bin_loc_desc%></font></td>
			<!-- 					
						* @Name - Priya
						* @Date - 19/02/2010
						* @Inc# - IN019466
						* @Desc - To right align Available Quantity, Qty to Transfer.				
					-->
			<td  class="<%=classValue%>" style="TEXT-ALIGN:right"><font size=1><%=avl_item_qty%></font>&nbsp;</td>
			<td  class="<%=classValue%>"><font size=1><%=new_bin_loc_desc%></font></td>
			<td  class="<%=classValue%>" style="TEXT-ALIGN:right"><font size=1><%=adj_item_qty%></font>&nbsp;</td>
			<input type="hidden" name="hOld_bin<%=i%>" id="hOld_bin<%=i%>" value="<%=old_bin_loc_desc%>">
			<input type="hidden" name="hNew_bin<%=i%>" id="hNew_bin<%=i%>" value="<%=new_bin_loc_desc%>"> 
			<input type="hidden" name="hbatch_id<%=i%>" id="hbatch_id<%=i%>" value="<%=batch_id%>"> 
			<input type="hidden" name="hItem<%=i%>" id="hItem<%=i%>" value="<%=item_desc%>"> 
			<input type="hidden" name="hExpiry<%=i%>" id="hExpiry<%=i%>" value="<%=com.ehis.util.DateUtils.convertDate(exp_date,"DMY","en",locale)%>"> 
			<input type="hidden" name="hTrade_name<%=i%>" id="hTrade_name<%=i%>" value="<%=trade_name%>">  
			<input type="hidden" name="hitem_code<%=i%>" id="hitem_code<%=i%>" value="<%=item_code%>">  
			<input type="hidden" name="adj_item_qty<%=i%>" id="adj_item_qty<%=i%>" value="<%=adj_item_qty%>">   
			

	</tr>
	<%}%>
</TABLE>   
            <input type="hidden" name="locale" id="locale"				value="<%=locale%>"> 
			<input type="hidden" name="total_checkboxes" id="total_checkboxes"	value="<%=i%>"> 
            <input type="hidden" name="records_to_delete" id="records_to_delete"	value="">
            <input type="hidden" name="mode" id="mode"				value="<%=mode%>">
            <input type="hidden" name="bean_id" id="bean_id"				value="<%=bean_id%>">
            <input type="hidden" name="bean_name" id="bean_name"			value="<%= bean_name %>">
            <input type="hidden" name="function_id" id="function_id"			value="<%= function_id %>">
</form>
<%
	putObjectInBean("ChangeBinLocationBean",bean,request);
	putObjectInBean("stHeaderBean",beanHdr,request);
%>
</BODY>

<%if (request.getParameter("index")!=null && !request.getParameter("index").equals("undefined")) {%>
<script language="JavaScript">
	<%-- document.getElementById("a_")<%=(request.getParameter("index")).equals("-1")?""+(i-1):request.getParameter("index")%>.scrollIntoView(); --%>
    var index = '<%= request.getParameter("index") %>';
    var elementId = "a_" + (index === "-1" ? (i - 1) : index);
    var element = document.getElementById(elementId);
    if (element) {
        element.scrollIntoView();
    }
	<%-- changeRowColor(document.getElementById("tr_")<%=(request.getParameter("index")).equals("-1")?""+(i-1):request.getParameter("index")%>);	 --%>
    var index = '<%= request.getParameter("index") %>';
    var elementId = "tr_" + (index === "-1" ? (i - 1) : index);
    var element = document.getElementById(elementId);
    if (element) {
        changeRowColor(element);
    }
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%}%>
</HTML>

