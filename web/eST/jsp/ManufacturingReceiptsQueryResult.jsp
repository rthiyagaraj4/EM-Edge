<!DOCTYPE html>
<%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			=	(String)session.getAttribute("LOCALE");
	String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<!--<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eST/js/ManufacturingReceipts.js'></script>
	<script language='javascript' src='../../eST/js/StCommon.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%try{
	//java.util.HashMap defaultParameter		=		null;
	String bean_id								=		"ManufacturingReceiptsBean";
	String bean_name							=		"eST.ManufacturingReceiptsBean";
	String classvalue							=		"";

	ManufacturingReceiptsBean bean				=		(ManufacturingReceiptsBean) getBeanObject(bean_id, bean_name, request);
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	//String index								=		bean.checkForNull(request.getParameter("index"),"-1");
	String mode									=		request.getParameter( "mode" )==null?"":  request.getParameter( "mode" );
	String store_code							=		request.getParameter( "store_code" )==null?"%":  request.getParameter( "store_code" );
	String doc_type								=		request.getParameter( "doc_type" )==null?"%":  request.getParameter( "doc_type" );
	String doc_no								=		request.getParameter( "doc_no" )==null?"%":  request.getParameter( "doc_no" );

	if(doc_no.equals(""))
		doc_no									=		"%";
	if(store_code.equals(""))
		store_code								=		"%";
	if(doc_type.equals(""))
		doc_type								=		"%";
	
	ArrayList recordSet							=		new ArrayList();
	//bean.getHdrData(store_code,doc_type,doc_no);

	//recordSet									=		bean.getHdrData(store_code,doc_type,doc_no);
	
	 //Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts 
	String dflt_mfg_mode =request.getParameter("dflt_mfg_mode")==null?"R":request.getParameter("dflt_mfg_mode");
	if(dflt_mfg_mode.equals("D")){
	recordSet									=		bean.getHdrQueryData(store_code,doc_type,doc_no);
	}else{
	  recordSet									=		bean.getHdrData(store_code,doc_type,doc_no);
	 }
	
	//System.out.println("recordSet:" +recordSet);
	//System.out.println("recordSet:" +(bean.checkForNull(bean.getBarcode_id())));
    
	if ( mode == null || mode.equals("") ) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
	HashMap hmRecord							=		new HashMap();
	%>
	<body>
	<form name='ManufacturingResultForm' id='ManufacturingResultForm' method='post' >
		<table border='1' cellpadding=0 cellspacing=0 width='100%' id='tb1'>
			<th><fmt:message key="Common.DocTypeCode.label" bundle="${common_labels}"/></th>
		    <th><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></th>
		    <th><fmt:message key="eST.MFGItem.label" bundle="${st_labels}"/></th>
		    <th><fmt:message key="eST.ReqNo.label" bundle="${st_labels}"/></th>
		    <th><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></th>
		    <th><fmt:message key="Common.PrepareLocation.label" bundle="${common_labels}"/></th>


	<%
	
	
		if(recordSet.size()>0){
		int i=0;
		for	(i	=0;	i<recordSet.size();i++){
			hmRecord					=		(HashMap)	recordSet.get(i);
			classvalue					=		((i%2)==0)?"QRYODD":"QRYEVEN";
			String preparation_type		=		bean.checkForNull((String)hmRecord.get("PREPARATION_TYPE"),"&nbsp;");
			String preparation_desc		=		"";
		
		if (preparation_type.equals("P"))
			preparation_desc			=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.PrePacking.label","st_labels");
		else if (preparation_type.equals("S"))
			preparation_desc			=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.StandardFormulary.label","st_labels");
		else if(preparation_type.equals("E"))
			preparation_desc			=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Extemporaneous.label","st_labels");
		else
			preparation_desc			=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");

			String preparation_mode		=		bean.checkForNull((String)hmRecord.get("PREPARATION_MODE"),"&nbsp;");
			String preparationmode_desc =		"";

		if (preparation_mode.equals("S"))
			preparationmode_desc		=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Sterile.label","st_labels");
		else if (preparation_mode.equals("N"))
			preparationmode_desc		=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.NonSterile.label","st_labels");
		else
			preparationmode_desc		=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");
			
		//	String patinetName			=		bean.checkForNull((String)hmRecord.get("PATIENT_NAME"));
			String loc_desc				=		bean.checkForNull((String)hmRecord.get("LOC_DESC"));
			String store_desc			=		bean.checkForNull((String)hmRecord.get("STORE_DESC"));
			String request_qty			=		bean.checkForNull((String)hmRecord.get("REQUEST_QTY"));
			String barcode_id			=		bean.checkForNull((String)hmRecord.get("BARCODE_ID"));
			String no_of_lables			=		bean.checkForNull((String)hmRecord.get("NO_OF_LABELS"));
			
			//System.out.println("barcode_id rel==>"+barcode_id);
//			System.err.println("in the query result"+recordSet);
String allow_deci_yn            =   bean.checkForNull(bean.getAllowDecimalsYN((String)hmRecord.get("ITEM_CODE")),"N");
	    String no_deci =   bean.checkForNull(""+bean.getNoOfDecimals(),"0");
		if(allow_deci_yn.equals("N"))
                            no_deci ="0";
	%>
		<tr>
			<td class="<%=classvalue%>"  align='left'  nowrap><a href="javascript:modifyData('<%=hmRecord.get("BATCH_ID")%>','<%=i%>','<%=preparationmode_desc%>','','<%=loc_desc%>','<%=store_desc%>','<%=request_qty%>','<%=mode%>','<%=(String)hmRecord.get("DOC_NO")%>','<%=hmRecord.get("DOC_TYPE_CODE")%>','<%=hmRecord.get("STORE_CODE")%>','<%=barcode_id%>','<%=no_of_lables%>','<%=dflt_mfg_mode%>');"><font size=1><%=(String)hmRecord.get("DOC_TYPE_CODE")%></a></font></td>
			<td class="<%=classvalue%>"  align='left'  nowrap><font size=1><%=bean.checkForNull((String)hmRecord.get("DOC_NO"),"&nbsp;")%></font></td>
			<%	if(preparation_type.equals("E")){%>
				<td class="<%=classvalue%>"  align='left'  nowrap><font size=1><%=bean.checkForNull((String)hmRecord.get("ITEM_CODE"),"&nbsp;")%></font></td>
				<%}else{%>
			<td class="<%=classvalue%>"  align='left'  nowrap><font size=1><%=bean.checkForNull((String)hmRecord.get("ITEMDESC"),"&nbsp;")%></font></td><%}%>
			<td class="<%=classvalue%>"  align='left'  nowrap><font size=1><%=bean.checkForNull((String)hmRecord.get("MFG_REQUEST_NO"),"&nbsp;")%></font></td>
			<!-- 					
						* @Name - Priya
						* @Date - 19/02/2010
						* @Inc# - IN019466
						* @Desc - To right align Quantity.				
					-->
			<td class="<%=classvalue%>"  style="TEXT-ALIGN:right"  nowrap><font size=1><%=bean.checkForNull(bean.setNumber((String)hmRecord.get("ITEM_QTY"),Integer.parseInt(no_deci)),"&nbsp;")%></font>&nbsp;</td>
			<td class="<%=classvalue%>"  align='left'  nowrap><font size=1><%=bean.checkForNull(loc_desc,"&nbsp;")%></font></td>
		</tr>
	<%
	}
	%>
<%
	putObjectInBean(bean_id,bean,request);
%>
	</table>
	<!--
	* @Name - Priya
	* @Date - 21/12/2009
	* @Inc# - IN017084
	* @Desc - To avoid the duplication records display in Modify mode
	 -->
	<div  id='readOnlyDiv'  style="visibility:hidden;z-index:3;position:absolute;top:0px;width:1007px;height:500px;background-color:#CCCFFF;filter:alpha(opacity=80);" >
		<table border="0" align="center" width="100%" height="100%">
		<tr><td align="center">
			
			</td></tr>
		</table>
		</div>
	<input type=hidden name="totalRecords" id="totalRecords"  value="<%=recordSet.size()%>">
	<input type=hidden name="mode" id="mode"  value="<%=mode%>">
	</form>
	</center>
<%			
		out.flush();
		} else{
		%>
			 <script>
					alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
					document.location.href="../../eCommon/html/blank.html";
			</script>
		<%
		}		
	}
	catch (Exception exception) {
		exception.printStackTrace();
	}
	%>
	</body>
	</html>

