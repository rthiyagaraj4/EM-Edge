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
 <%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,java.lang.*,java.sql.*,webbeans.eCommon.*"
contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
<!-- 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
 --><%
 request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");

		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 	<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
	<!-- <script language="javascript" src="../../eST/js/StMessages.js"></script> -->
	<script language="javascript" src="../../eST/js/StTransaction.js"></script>
	<script language="javascript" src="../../eST/js/GRNHistoy.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
Connection con				= null;//Added for TFS id:6938
try{//Added for TFS id:6938
	String bean_id = "GRNHistoryBean";
	String bean_name = "eST.GRNHistoryBean";
	GRNHistoryBean bean = (GRNHistoryBean) getBeanObject( bean_id,bean_name,request );
	String rdonly="";
	bean.setLanguageId(locale);

	String currentdate		=  com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
	String currentdateminus =  com.ehis.util.DateUtils.minusDate(currentdate,"DMY",locale,7,"d").toString();
	con						= ConnectionManager.getConnection(request);//Added for TFS id:6938
	boolean barcode_appl =CommonBean.isSiteSpecific(con, "ST", "BARCODE_APPL_FOR_QUERY_FUNC");//Added for TFS id:6938
	
%>
<body onload='FocusFirstElement();' topmargin = 0 >
	<form name="formGRNHistoryQueryCriteria" id="formGRNHistoryQueryCriteria" >
<!-- Modified for TFS id:6938 start-->	
<!-- 		<table border="1" cellpadding="0" cellspacing="0" width='100%'   > -->
<%if(barcode_appl){ %>
		<tr>
	<td class=label >&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eST.BarcodeId.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td>
		<td  class='fields' nowrap>&nbsp;<input type=text name=barcode id=barcode size=80  maxlength=100 value="" onkeypress="callItemSearchScreenForQueryFunction(event, barcode,'GRNH','batchSearchBean','eST.BatchSearchBean',document.formGRNHistoryQueryCriteria);" ></td>
	</tr>
	<%} %>
		<tr>
		<!-- Modified for TFS id:6938 end-->
			<table border="0" cellpadding="0" cellspacing="0" width='100%'>	
			<td class=label align=rigth colspan = 0>&nbsp;&nbsp;Item&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<!-- Modified for TFS id:6938 -->
				<input type=text name='item_desc' id='item_desc' size=40 maxlength=40 value="" <%=rdonly%> >
				<input type=hidden name="item_code" id="item_code" value="">
				<input type='button' class='BUTTON' value='?' onClick='callItemSearchScreen(item_code,item_desc);' name="item_search" id="item_search">
				<label  id= 'id_Highlight' ></label></td>
				</td>
				<td  class="label"><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></td>
				<td  class='fields'>&nbsp;&nbsp;<input type="text" size="10" maxlength="10" class='NUMBER' name="doc_no" id="doc_no" value="" onKeyPress="return isValidNumber(this, event, 10);" onblur="checkDoubleFormat(this, false);" >
			</td>
			
			<td  class="label"><fmt:message key="eST.ExtRefNo.label" bundle="${st_labels}"/>
			&nbsp;&nbsp;&nbsp;&nbsp;<input maxLength=20 size=20  name="ref_no" id="ref_no" class="NUMBER" value="">
			</td>
			<td class=label></td>
			 
		</tr>
		<tr>
			<td class="label">&nbsp;&nbsp;<fmt:message key="Common.Supplier.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <!-- Modified for TFS id:6938 -->
			<select name="supplier" id="supplier"><%=bean.getSupplierList()%>
			</select>
			</td>
			<td class="label" align = right><fmt:message key="Common.Finalized.label" bundle="${common_labels}"/> &nbsp;&nbsp;</td>
			<td class="label" ><select name="finalized_yn" id="finalized_yn">
					<option value="A" ><fmt:message key="Common.all.label" bundle="${common_labels}"/> </option>
					<option value="Y" ><fmt:message key="Common.Finalized.label" bundle="${common_labels}"/></option>
					<option value="N" ><fmt:message key="Common.UnFinalized.label" bundle="${common_labels}"/></option>
			</select>
			</td>
			
			<td class=label align=left>
<fmt:message key="Common.fromdate.label" bundle="${common_labels}"/> &nbsp;&nbsp;&nbsp;
<input type='text' name='FM_DATE' id='FM_DATE' size=10 maxlength=10 class="DATE" value="<%=currentdateminus%>" onBlur="CheckDate(this);" ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('FM_DATE');" ></img><%=bean.getImage("M")%>&nbsp;&nbsp;
<fmt:message key="Common.todate.label" bundle="${common_labels}"/>&nbsp;<input type='text' name='TO_DATE' id='TO_DATE' size=10 maxlength=10 class="DATE" value="<%=currentdate%>" onBlur="CheckDate(this);" >
<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('TO_DATE');" ></img>&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td class="label"></td>
		</tr>			
		<tr>
			<td class="label">&nbsp;&nbsp;<fmt:message key="Common.Store.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<!-- Modified for TFS id:6938 -->
			<select name="store" id="store"><%=bean.getStore_code_List()%>
					</select>
			</td>
			<td class="label" align = right>
			<fmt:message key="eST.ReplacementGRN.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td>
			<td class="label" ><select name="repl_grn" id="repl_grn">
					<option value="A" ><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
					<option value="Y" ><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
					<option value="N" ><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
			</select>
			</td>
			<td  class="label"><fmt:message key="eST.PONo.label" bundle="${st_labels}"/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input maxLength=10 size=10  name="po_no" id="po_no" class="NUMBER" value="" onKeyPress="return isValidNumber(this, event, 10);" onblur="checkDoubleFormat(this, false);" >
			</td><td class=label></td>
			<table border="0" cellpadding="0" cellspacing="0" width='100%'>
				<tr>
					<td  align='right' colspan='4'>
						<input type='button'  class='BUTTON' name='previous' id='previous' 
						value='<fmt:message key="Common.previous.label" bundle="${common_labels}"/>' disabled onClick='goPrev();'>
						<input type='button' class='BUTTON' name='next' id='next' value='<fmt:message key="Common.next.label" bundle="${common_labels}"/>' onClick='goNext();' disabled><input type='button' class='BUTTON' name='search' id='search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="searchVals();">
					</td>
				</tr>
			</table>
		</tr>
		</table>	
</form>
<%
putObjectInBean(bean_id,bean,request);
//Added for TFS id:6938
}
catch(Exception e){
	e.printStackTrace();
}
finally{
	
	if(con != null)
		ConnectionManager.returnConnection(con,request);

}
//Added for TFS id:6938
%>
</body>
</html>


