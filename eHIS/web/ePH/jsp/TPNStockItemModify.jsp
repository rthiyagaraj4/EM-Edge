 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
    <!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
	<%
	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
	String locale			= (String)session.getAttribute("LOCALE");
	
	String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
    <SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
    <!-- <SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/MstCodeCommon.js"></SCRIPT> -->
    <SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
    <SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/PhCommon.js"></SCRIPT>
    <!--<SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/PhMessages.js"></SCRIPT>-->
    <SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/TPNStockItem.js"></SCRIPT>
    <!--<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/messages.js"></SCRIPT>-->
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



   
</HEAD>

<!-- <body onMouseDown="CodeArrest()" onKeyDown="lockKey()"> -->
<body onMouseDown="" onKeyDown="lockKey()">
<form name="TPNStockItemModifyQueryForm" id="TPNStockItemModifyQueryForm">
<%
    /* Mandatory checks start */
    String mode = request.getParameter( "mode" ) ;
	String bean_id = "TPNStockItemBean" ;
    String bean_name = "ePH.TPNStockItemBean";
	String codeDisabled= " ";
	String tpn_item= "";
	String tpn_item_yn= "";
	String item_code="";
	String item_desc="";
	String uom_code="";
    TPNStockItemBean bean = (TPNStockItemBean)getBeanObject( bean_id,bean_name,request) ;
    bean.setLanguageId(locale);
if ( mode == null || mode.equals("") )
     return ;
	 
    if (( !mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") ) )&&!(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY")))){

	   return ;
	}
	if (mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY")))
	{
	
	codeDisabled = "disabled";
	item_code=request.getParameter("item_code")==null?"":request.getParameter("item_code") ;
	ArrayList ItemDet=new ArrayList();
	ItemDet=(ArrayList)bean.getItemDetails(item_code);

	if(ItemDet.size()>0){
		item_code=(String)ItemDet.get(0);
		item_desc=(String)ItemDet.get(1);
		uom_code=(String)ItemDet.get(2);
		tpn_item_yn=(String)ItemDet.get(3);
	}
		if (tpn_item_yn.equals("Y"))
		{
		 tpn_item= "Checked";
		}
		else
		{		

          tpn_item=""; 
	    }
	}else
	bean.clear();
  // if (mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") ) )
   //{


	//bean.clear();
%>

<span style="position:absolute;top:130px;left:120px">
<TABLE align="center" cellspacing="0" cellpadding="0" border="0">
<tr>
<td class="label" colspan=2>&nbsp;</td>
</tr>
<tr>
<td class="label" colspan=2>&nbsp;</td>
</tr>
<tr>
<td class="label" width="40%"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
<td ><input type="text" name="item_code" id="item_code" maxLength=20 size=20 value="<%=item_code%>"  class="UPPER" <%=codeDisabled%>>
<input type='button' class='BUTTON' value='?'  onClick="searchItem(this)"  name="item_search" id="item_search" <%=codeDisabled%>><img align='center' src='../../eCommon/images/mandatory.gif'>&nbsp;
</img>&nbsp;&nbsp;</td>
</tr>
<tr>
<td class="label" colspan=2>&nbsp;</td>
</tr>
<tr>
<td class="label" colspan=2>&nbsp;</td>
</tr>
<tr>
<td class="label"><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
<td class="label"  id ="td_short_name"><%=item_desc%>
</td>
</tr>
<tr>
<td class="label" colspan=2>&nbsp;</td>
</tr>
<tr>
<td class="label" colspan=2>&nbsp;</td>
</tr>
<tr>
<td class="label"><fmt:message key="Common.uom.label" bundle="${common_labels}"/>&nbsp;&nbsp; </td>
<td class="label" id="td_gen_uom_code"><%=uom_code%>&nbsp;&nbsp;</td>
</tr>
<tr>
<td class="label" colspan=2>&nbsp;</td>
	</tr>
<tr>
<td class="label" colspan=2>&nbsp;</td>
</tr>
<tr>
<td class="label">	<fmt:message key="ePH.TPNItem.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>
<td><input type="checkbox" value="<%=tpn_item_yn%>" name="tpn_item_yn"  onclick='checkunchecktpn()' <%=tpn_item%> ></td>
</tr>
<tr>
<td class="label" colspan=2>&nbsp;</td>
</tr>
<tr>
<td class="label" colspan=2>&nbsp;</td>
</tr>
</TABLE>
</span>


<INPUT TYPE="hidden" name="mode" id="mode" value="<%=mode%>">
<INPUT TYPE="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<INPUT TYPE="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<INPUT TYPE="hidden" name="language_id" id="language_id" value="<%=locale%>">
<INPUT TYPE="hidden" name="sql_ph_drug_select99" id="sql_ph_drug_select99" value="<%=PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT99")%>">
	</form>
<% putObjectInBean(bean_id,bean,request);
  // }
 %>
</body>
</html>

