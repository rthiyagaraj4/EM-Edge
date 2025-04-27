
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name       	Rev.Date   		Rev.By    	Description
--------------------------------------------------------------------------------------------------------------
21/02/2016		IN0057461			B.Badmavathi					ML-MMOH-CRF-0448
---------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page  contentType="text/html;charset=UTF-8" import=" eST.*, eST.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.sql.*,webbeans.eCommon.*,java.lang.*"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=	 (String)session.getAttribute("LOCALE");
		String sStyle			=	 (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language='javascript' src='../../eST/js/StCommon.js'></script>
		<script language="javascript" src="../../eST/js/StHeader.js"></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script language="javaScript" src="../../eST/js/ProductTransfer.js"></script>
	</head>
<body>
<% 
//	String mode						=		eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT");
	String trn_type					=		"PRT"; 
	String sql_id					=		"SQL_ST_PRODUCT_TRANSFER_STORE_SELECT" ; 

 // int i							=		0;
	String mode;
	//String bean_id					=		"ProductTransferBean" ;
	//String bean_name				=		"eST.ProductTransferBean";

	ProductTransferBean bean		=		(ProductTransferBean)getBeanObject( "ProductTransferBean", "eST.ProductTransferBean" , request);
	bean.setLanguageId(locale);

	StHeaderBean beanHdr		=			(StHeaderBean) getBeanObject( "stHeaderBean", "eST.Common.StHeaderBean" ,request);
	 String store_code=bean.getStore_code();
	//String function_id				=		request.getParameter( "function_id" ) ;
	//mode							=		request.getParameter( "mode" ) ;
	
	String item_class_based			=		bean.getPRTItemClassBased(trn_type);
 	String param = request.getQueryString();    
	//Added for ML-MMOH-CRF-0448 B.Badmavathi starts
	String doc_type_code			=		bean.checkForNull(request.getParameter( "doc_type_code" ));
	String doc_no 					= 		bean.checkForNull(request.getParameter( "doc_no" ));
	String doc_ref 					= 		bean.checkForNull(request.getParameter( "doc_ref" ));
	String facility_id	        =	bean.getLoginFacilityId();  
	//bean.getSiteSpec();
	//boolean site = bean.isSite_spec_yn();
	/*boolean site = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_PRODUCT_TRANSFER");*/
	boolean site=bean.isSite_spec_yn();
	System.out.println("site======product transfer start jsp= in header====");
	System.out.println(site);
	 if(site){
		  mode						=		eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT");
		 if(request.getParameter( "doc_type_code" ) != null) {
		 mode						=		eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY");	
		 }
	 }
	 else{
	 mode							=		request.getParameter( "mode" ) ;
	//Added for ML-MMOH-CRF-0448 B.Badmavathi ends
	if(mode==null)
				mode				=		"1";
	//Added for ML-MMOH-CRF-0448 B.Badmavathi starts
	}
	 String	 request_vis			=		"disabled";
	 String req_no = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_STORE_DESC_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("PROD_TFR_REQUEST_NO"),"");
	 String prep_loc = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_STORE_DESC_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("PREPARE_LOCATION_CODE"),"");
	 //Added for ML-MMOH-CRF-0448 B.Badmavathi ends	
%>
<form name="formProductTransferHeader" id="formProductTransferHeader">

<jsp:include page="../../eST/jsp/StHeader.jsp" > 
	<jsp:param name="mode"			value="<%=mode%>" />
	<jsp:param name="trn_type"		value="<%=trn_type%>" />
    <jsp:param name="default_doc"	value="PRT" />
	<jsp:param name="storeSQLID"	value="<%=sql_id%>" />
</jsp:include>

<!-- <script language="JavaScript">
  parent.frameProductTransferAddModify.location.href="../../eST/jsp/ProductTransferAddModify.jsp?function_id=ST_PRODUCT_TRANSFER";
</script>   -->

<table  border=0 cellspacing="0" cellpadding="0" width="100%" border ="0" align=center>
	<tr>
			<td class="label" >&nbsp;</td>

			<td class='fields'><input type=button name="request" id="request" value='<fmt:message key="Common.Request.label" bundle="${common_labels}"/>' class=button style='width:70' style='height:16pt'    onclick="callRequestSearch()" <%= mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))?request_vis:""%> >&nbsp;&nbsp;&nbsp;</td><!--Modified for ML-MMOH-CRF-0448 B.Badmavathi -->

			<td  class=label >&nbsp;</td>
			<td  class=label >&nbsp;</td>
		<!--Added for ML-MMOH-CRF-0448 B.Badmavathi starts -->	
			<%if(site ){
				if(mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"))&& (req_no !="") ){ %>
					<td class="label" ><fmt:message key="eST.ReqNo.label" bundle="${st_labels}"/>&nbsp;:&nbsp;<%=req_no %>
				<%}else{%>
					<td id=request_no_hdr  class='label'  width='15%' >&nbsp;</td> 
				<%}
			}else{ %>
		<!--Added for ML-MMOH-CRF-0448 B.Badmavathi ends -->	
			<td id=request_no_hdr  class='label'  width='15%' >&nbsp;</td> 
		<!--Added for ML-MMOH-CRF-0448 B.Badmavathi starts -->	
			<%} %>
			<%if(site && prep_loc!="") {%>
			<td class="label" ><fmt:message key="Common.PrepareLocation.label" bundle="${common_labels}"/>&nbsp;<select name='prep_loc' id='prep_loc' ><%=bean.getPrepLoc1(prep_loc)%></select></td>
			<%}else{ %>
		<!--Added for ML-MMOH-CRF-0448 B.Badmavathi ends -->
			<td class="label" ><fmt:message key="Common.PrepareLocation.label" bundle="${common_labels}"/>&nbsp;<select name='prep_loc' id='prep_loc' ><%=bean.getPrepLoc()%></select></td>
			<%} %>	<!--Added for ML-MMOH-CRF-0448 B.Badmavathi  -->
			<td>&nbsp;</td>
	 </tr>
</table>
</tr>


<script language="JavaScript">
  parent.frameProductTransferAddModify.location.href="../../eST/jsp/ProductTransferAddModify.jsp?function_id=ST_PRODUCT_TRANSFER";
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>


  
	<input type="hidden" name="request_yn" id="request_yn"				value="N">
	<input type="hidden" name="request_flag" id="request_flag"			value="N">
	<input type="hidden" name="item_class_check" id="item_class_check"		value="<%=item_class_based%>">
	<input type="hidden" name="prt_delete_yn" id="prt_delete_yn"		value="">
	
        <input type="hidden"    name="barcode_applicable1" id="barcode_applicable1"			value="" >
    	<input type="hidden"    name="defaultqty_appl1" id="defaultqty_appl1"				value="" >
    	<input type="hidden"	name="defaultqty_value1" id="defaultqty_value1"			value="">
    	<input type="hidden"    name="editqty_appl1" id="editqty_appl1"				value="" >
    	<input type="hidden"    name="chargeable_yn" id="chargeable_yn"				value="" ><!--dummy-->
		<input type="hidden"    name="trn_type" id="trn_type"				      value="<%=trn_type%>">
		<input type="hidden"	name="finalize_allowed_yn" id="finalize_allowed_yn"	value="N">
	
</form>
<script>
 if(document.formProductTransferHeader.trn_type.value == "PRT" )  
callBarCodeApplicable('PRT','formProductTransferHeader','ProductTransferBean','eST.ProductTransferBean');
parent.frameProductTransferAddModify.document.location.href="../../eST/jsp/ProductTransferAddModify.jsp?<%=param%>";	  
</script>
<%

putObjectInBean("ProductTransferBean",bean,request);
%>
</body>
</html>

