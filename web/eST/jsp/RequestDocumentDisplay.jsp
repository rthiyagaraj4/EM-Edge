<!DOCTYPE html>
<!--
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
21/03/2014				48000			        Abdul Rabbani         21/03/2014        Rabbani               HSA-SCF-0017
-------------------------------------------------------------------------------------------------------------------------------
-->
<!--
*	Copyright © IBA Health Group Ltd. ALL RIGHTS RESERVED
*	Application		:	eST
*	Purpose 		:   For Displaying The Item Details
*	Created By		:	SURI
*	Created On		:	09 june 2008

-->
<%@page  import=" eST.*,eST.Common.*,java.util.*,webbeans.eCommon.*, java.text.*" contentType="text/html;charset=UTF-8"%>  
<%@include file="../../eCommon/jsp/CommonBean.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
<%
   request.setCharacterEncoding("UTF-8");
   String locale			=	(String)session.getAttribute("LOCALE");
   String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
type='text/css' ></link> 
<title><fmt:message key="Common.RequestDetails.label" bundle="${common_labels}"/></title>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
   <!-- <script language="javascript" src="../../eCommon/js/messages.js"></script> -->	
        <script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../eST/js/StCommon.js'></script>
   <!-- <script language='javascript' src='../../eST/js/StMessages.js'></script> -->	
        <script language="javascript" src="../../eST/js/Request.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body>
	<%
     	String bean_id = "authorizeAtIssueStoreBean";
		String bean_name = "eST.AuthorizeAtIssueStoreBean";
        String doc_no = CommonBean.checkForNull(request.getParameter("doc_no"),"%");
        String doc_type_code = CommonBean.checkForNull(request.getParameter("doc_type_code"),"%");
	    String DOC_DATE =   "";
        String REQ_BY_STORE_DESC =   "";
        String REQ_ON_STORE_DESC =  "";
        String REQ_RAISED_BY_ID =   "";
	 
   ArrayList Duplicate ;	
	AuthorizeAtIssueStoreBean bean = (AuthorizeAtIssueStoreBean) getBeanObject(bean_id, bean_name, request  );
 	/**
	* @Name - Mahesh
	* @Date - 25/01/2010
	* @Inc# - IN015496
	* @Desc - No.of Decimals is storeed in a temp variable as this page displays more than one item at a time.
	*/
		int no_of_decimals_temp			=		bean.getNoOfDecimals();
		int no_of_decimals				=		0;

try{
		String[] strParameters = new String[7];
			
			strParameters[0] = doc_no;
            strParameters[1] = CommonBean.getLoginFacilityId();
            strParameters[2] = locale;
            strParameters[3] = locale;
            strParameters[4] = locale;
            strParameters[5] = (String)session.getAttribute("ACC_ENTITY_ID");
            strParameters[6] = doc_type_code;
			

 //Duplicate	= bean.fetchRecords(bean.getStRepositoryValue("SQL_ST_REQUEST_DTL_SELECT1"),strParameters);
 //commented by Rabbani  # Bru-HIMS-CRF-118[INC NO:30077] on 22-JULY-2013
 //Duplicate	= bean.fetchRecords("SELECT st.item_code,hdr.req_on_store_code,hdr.req_by_store_code,st.short_desc, TO_CHAR (hdr.doc_date, 'dd/mm/yyyy') doc_date, rbys.short_desc req_by_store_desc, rons.short_desc req_on_store_desc, dtl.pending_item_qty, dtl.req_item_qty, dtl.committed_item_qty,       hdr.req_raised_by_id, DECODE (hdr.request_status,'E', 'Request Entered', 'W', 'Authorized at Reqest by Store','A', 'Authorized at Issue Store','P', 'Partially Issued' ) request_status, itm.short_desc item_class_desc, am.SHORT_DESC req_uom_desc FROM st_request_hdr hdr,  st_request_dtl dtl,mm_store_lang_vw rbys,mm_store_lang_vw rons,mm_item_class_lang_vw itm, mm_item_lang_vw st, am_uom_lang_vw am,st_acc_entity_param  WHERE hdr.doc_no = dtl.doc_no AND dtl.doc_no = ?  AND st.item_code = dtl.item_code AND hdr.facility_id = dtl.facility_id  AND hdr.doc_type_code = dtl.doc_type_code  AND hdr.req_by_store_code = rbys.store_code AND hdr.req_on_store_code = rons.store_code  AND hdr.item_class_code = itm.item_class_code(+)   AND hdr.request_status IN ('E', 'W', 'A', 'P') AND dtl.facility_id like decode(TRN_ACROSS_FACILITY_YN,'Y','%', ?) AND st.language_id = rbys.language_id AND st.language_id = rons.language_id AND  st.language_id = ? AND itm.language_id(+) = ? AND am.uom_code = request_uom AND am.language_id =? and ACC_ENTITY_ID = ? and hdr.doc_type_code = ?",strParameters);
 //Added by Rabbani  # Bru-HIMS-CRF-118[INC NO:30077] on 22-JULY-2013
  Duplicate	= bean.fetchRecords("SELECT st.item_code,hdr.req_on_store_code,hdr.req_by_store_code,st.short_desc, TO_CHAR (hdr.doc_date, 'dd/mm/yyyy') doc_date, rbys.short_desc req_by_store_desc, rons.short_desc req_on_store_desc, dtl.pending_item_qty, dtl.req_item_qty, dtl.committed_item_qty,       hdr.req_raised_by_id, DECODE (hdr.request_status,'E', 'Request Entered', 'W', 'Authorized at Reqest by Store','A', 'Authorized at Issue Store','P', 'Partially Issued' ) request_status, itm.short_desc item_class_desc, am.SHORT_DESC req_uom_desc FROM st_request_hdr hdr,  st_request_dtl dtl,mm_store_lang_vw rbys,mm_store_lang_vw rons,mm_item_class_lang_vw itm, mm_item_lang_vw st, am_uom_lang_vw am,st_acc_entity_param  WHERE hdr.doc_no = dtl.doc_no AND dtl.doc_no = ?  AND st.item_code = dtl.item_code AND hdr.facility_id = dtl.facility_id  AND hdr.doc_type_code = dtl.doc_type_code  AND hdr.req_by_store_code = rbys.store_code AND hdr.req_on_store_code = rons.store_code  AND hdr.item_class_code = itm.item_class_code(+)   AND hdr.request_status IN ('E', 'W', 'A', 'P') AND dtl.facility_id like decode(TRN_ACROSS_FACILITY_YN,'Y','%', ?) AND st.language_id = rbys.language_id AND st.language_id = rons.language_id AND  st.language_id = ? AND itm.language_id(+) = ? AND am.uom_code = request_uom AND am.language_id =? and ACC_ENTITY_ID = ? and hdr.doc_type_code = ? and dtl.pending_item_qty > 0",strParameters);
	   
	 }catch(Exception exception){
				exception.printStackTrace();
				throw exception;
			}

	  
    
		int i;
		String classvalue = "";
				
			%>			
						
				<table cellpadding=0 cellspacing=0 width="100%" align="center">
			<tr>
				<td width="80%" class="white">&nbsp;</td>
				<td width="20%" class="white">&nbsp;
				<%
					
				   for( i=0; i< Duplicate.size(); i++) {
				    HashMap hmRecords	=	(HashMap)Duplicate.get(i);
                    DOC_DATE =   bean.checkForNull((String)hmRecords.get("DOC_DATE"),"");
                    REQ_BY_STORE_DESC =   bean.checkForNull((String)hmRecords.get("REQ_BY_STORE_DESC"),"");
                    REQ_ON_STORE_DESC =   bean.checkForNull((String)hmRecords.get("REQ_ON_STORE_DESC"),"");
                    REQ_RAISED_BY_ID =   bean.checkForNull((String)hmRecords.get("REQ_RAISED_BY_ID"),"");
				   }
				%>
				</td>
			</tr>	 
			</table>
			
	<table border=0 cellpadding=0 cellspacing=0 align="center" width='100%' height=20>
	<td class=ITEMSELECT  align="left">
			 
	&nbsp;&nbsp;&nbsp;&nbsp;<b><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/>:</b><%=doc_no%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>
	<fmt:message key="Common.DocDate.label" bundle="${common_labels}"/>:</b><%=DOC_DATE%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>	
	<fmt:message key="eST.ReqBy.label" bundle="${st_labels}"/>:</b><%=REQ_RAISED_BY_ID%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>
	<fmt:message key="Common.FromStore.label" bundle="${st_labels}"/>:</b><%=REQ_BY_STORE_DESC%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>
	<fmt:message key="Common.ToStore.label" bundle="${st_labels}"/>:</b><%=REQ_ON_STORE_DESC%>&nbsp;
	
	<!--
	<fmt:message key="eST.ByStore.label" bundle="${st_labels}"/>:</b> 
	<fmt:message key="eST.RaisedBy.label" bundle="${st_labels}"/>:</b>   -->
	
	</table>
			
	<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
		<tr>
		 <th width='40%'><fmt:message key="Common.item.label" bundle="${common_labels}"/></th>
		 <th width='10%'><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></th>
		 <th width='10%'><fmt:message key="eST.ReqUOM.label" bundle="${st_labels}"/></th>
		 <th width='10%'><fmt:message key="eST.RequestedQty.label" bundle="${st_labels}"/></th> 
		 <th width='10%'><fmt:message key="Common.PendingQty.label" bundle="${common_labels}"/></th>
		 <th width='10%'><fmt:message key="eST.CommitedQty.label" bundle="${st_labels}"/></th>
		 <!-- Commented by Rabbani #Inc no:27060 (MO-CRF-20048) on 17-Feb-2014 -->
        <!-- <th width='20%'><fmt:message key="Common.RequestStatus.label" bundle="${common_labels}"/></th>	 -->
		</tr>		
		<%
			for( i=0; i< Duplicate.size(); i++) {
				HashMap hmRecords	=	(HashMap)Duplicate.get(i);
				String SHORT_DESC	=	(String)hmRecords.get("SHORT_DESC");
				String REQUEST_STATUS	=	(String)hmRecords.get("REQUEST_STATUS");
				String ITEM_CLASS_DESC	=	bean.checkForNull((String)hmRecords.get("ITEM_CLASS_DESC"),"&nbsp;");
				String REQ_UOM_DESC	=	bean.checkForNull((String)hmRecords.get("REQ_UOM_DESC"),"&nbsp;");
				double PENDING_ITEM_QTY	=	Double.parseDouble((String)hmRecords.get("PENDING_ITEM_QTY"))* (bean.getConvFactTemp((String)hmRecords.get("ITEM_CODE"),(String)hmRecords.get("REQ_BY_STORE_CODE")));
				String REQ_ITEM_QTY	=	(String)hmRecords.get("REQ_ITEM_QTY");
				double COMMITTED_ITEM_QTY	=	Double.parseDouble((String)hmRecords.get("COMMITTED_ITEM_QTY"))* (bean.getConvFactTemp((String)hmRecords.get("ITEM_CODE"),(String)hmRecords.get("REQ_BY_STORE_CODE")));
				//String COMMITTED_ITEM_QTY	=	(String)hmRecords.get("COMMITTED_ITEM_QTY");
				classvalue =	((i%2)==0)?"OAQRYODD":"OAQRYEVEN";
/**
* @Name - Mahesh
* @Date - 25/01/2010
* @Inc# - IN015496
* @Desc - If Decimals is allowed for that item, then No.of decimals is assigned to the variable else 0.
*/
					if((bean.getAllowDecimalsYN((String)hmRecords.get("ITEM_CODE"))).equals("Y")){
						no_of_decimals = no_of_decimals_temp;
					}else{
						no_of_decimals = 0;
					}
	 
				
		%>
			<tr>	
				<td class="<%=classvalue%>" onclick="disableClick(event);" ><%=SHORT_DESC%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=ITEM_CLASS_DESC%></td>
				<td class="<%=classvalue%>"><%=REQ_UOM_DESC%></td>
				<td class="<%=classvalue%>" align="right" onclick="disableClick(event);"><%=bean.setNumber(""+REQ_ITEM_QTY,no_of_decimals)%></td>
				<td class="<%=classvalue%>" align="right" onclick="disableClick(event);"><%=bean.setNumber(""+PENDING_ITEM_QTY,no_of_decimals)%></td>
				<td class="<%=classvalue%>" align="right" onclick="disableClick(event);"><%=bean.setNumber(""+COMMITTED_ITEM_QTY,no_of_decimals)%></td>
				<!-- Commented by Rabbani #Inc no:27060 (MO-CRF-20048) on 17-Feb-2014 
				<td class="<%=classvalue%>" nowrap onclick="disableClick(event);"><%=REQUEST_STATUS%></td>	
                -->				
			</tr>
		<%
			}
			
		%>
		
		</table>
		<table cellpadding=0 cellspacing=0 border=0 align=right>
		<tr>
			<td align=right><INPUT TYPE="button"  class="button" value="Close" onClick='window.close()'></td>
		</tr>
		</table>
</body>
</html>

