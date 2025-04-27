<!DOCTYPE html>

<%@ page import ="eST.ProductTransferBean, eST.Common.* , eCommon.Common.*,java.util.HashMap,java.util.ArrayList,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title></title>
	<%
		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<!--<link rel="stylesheet" type ="text/css" href="../../eST/html/IeStyle.css"></link>-->
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/rowcolor.js"></script>
		<script language="Javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eST/js/BatchSearch.js"> </script>
		<script language="javaScript" src="../../eST/js/ProductTransfer.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%

	String mode;
	String bean_id;
	String bean_name;
//	String function_id;
	String r_store_code;
	String r_request_no;
//	int maxRec					=		0; 
//	int start					=		0;
	//int end					=		0;
//	int displaySize				=		0;
//	int count					=		0;	
	int i						=		0;


	bean_id						=		"ProductTransferBean" ;
	bean_name					=		"eST.ProductTransferBean";

	ProductTransferBean bean	=		(ProductTransferBean)getBeanObject( "ProductTransferBean", "eST.ProductTransferBean" , request );
	bean.setLanguageId(locale);
    String facility_id			=		(String) session.getValue( "facility_id" ) ;
	String user_name			=		(String) session.getValue( "login_user" ) ;
	String  classvalue			=		"";

	HashMap dataList			=		null;
	mode						=		request.getParameter( "mode" ) ;
	if(mode==null) mode			=		"1";
//	function_id					=		request.getParameter( "function_id" ) ;
	r_store_code				=		request.getParameter("r_store_code")==null?"":request.getParameter("r_store_code");
	r_request_no				=		request.getParameter("r_request_no")==null?"":request.getParameter("r_request_no");

	ArrayList alrequestbatches	=		new ArrayList();
	
	alrequestbatches			=		bean.getRequestedBatches(r_store_code,r_request_no);
	
	String maxAllowed			=		bean.getMaxAllowed() ;
	%><body><%
	try{
		if(alrequestbatches.size() > 0 ){
		
%>


<form name='ProductTransferRequestSearchCriteria' id='ProductTransferRequestSearchCriteria'>

	<table border="1" cellpadding="0" cellspacing="0" width="100%"  id='tb1' align=center>
			<tr>
				<th  class='CAGROUP_HEADING' nowrap><font size=1><b><fmt:message key="Common.WorkStation.label" bundle="${common_labels}"/></b></font></th>
				<th  class='CAGROUP_HEADING' nowrap><font size=1><b><fmt:message key="eST.ReqNo.label" bundle="${st_labels}"/></b></font></th>
				<!-- <th  class='CAGROUP_HEADING'><font size=1><b>Conv Factor</b></font></th> -->
				<th  class='CAGROUP_HEADING'  style="font-size:7pt;WORD-BREAK:BREAK-ALL;"><b><fmt:message key="eST.Itemtobeused.label" bundle="${st_labels}"/></b></th>
				<th  class='CAGROUP_HEADING' nowrap><font size=1><b><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></b></font></th>
				<th  class='CAGROUP_HEADING' nowrap><font size=1><b><fmt:message key="eST.RepackFactor.label" bundle="${st_labels}"/> </b></font></th>
				<th  class='CAGROUP_HEADING'  style="font-size:7pt;WORD-BREAK:BREAK-ALL;"><b><fmt:message key="eST.RepackItem.label" bundle="${st_labels}"/> </b></th>
				<th  class='CAGROUP_HEADING'nowrap><font size=1><b><fmt:message key="eST.ExpectedQuantity.label" bundle="${st_labels}"/></b></font></th>
				 <!-- <th  class='CAGROUP_HEADING'><font size=1><b>Requested By</b></font></th>  -->
<!-- 				<th  class='CAGROUP_HEADING'><font size=1><b>Remarks</b></font></th> -->
				<th  class='CAGROUP_HEADING' nowrap><font size=1><b><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></b></font></th>
		   </tr>

	<%

		
				for(i=0;i<alrequestbatches.size();i++)
				{
					dataList = (HashMap)alrequestbatches.get(i);
					String allow_deci_yn_from            =   bean.checkForNull(((String)dataList.get("FROM_ALLOW_DECIMALS_YN")),"N");
	                 String no_deci_from            =   bean.checkForNull(""+bean.getNoOfDecimals(),"0");
					if(allow_deci_yn_from.equals("N"))
					   no_deci_from ="0";
					String allow_deci_yn_to            =   bean.checkForNull(((String)dataList.get("TO_ALLOW_DECIMALS_YN")),"N");
	                 String no_deci_to            =   bean.checkForNull(""+bean.getNoOfDecimals(),"0");
					if(allow_deci_yn_to.equals("N"))
					   no_deci_to ="0";
				if ( i % 2 == 0 )
						classvalue = "QRYEVEN" ;
					else
						classvalue = "QRYODD" ;
			   %>

			<tr id="tr_<%=i%>">
					
			<%
				//String 
			String title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PrintWorksheet.label","common_labels");
				%>
			<td class="<%=classvalue%>"   title= "<%=title%>" onclick = "PrintWorkSheet('<%=bean.checkForNull((String)dataList.get("PROD_TFR_REQUEST_NO"),"&nbsp;")%>')"><img  src='../../eCommon/images/beprint.gif'></img></td>
			<td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull((String)dataList.get("PROD_TFR_REQUEST_NO"),"&nbsp;")%></font></td>
			<!-- <td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull((String)dataList.get("TO_STK_UOM_CONV_FACTOR"),"&nbsp;")%></font></td> -->
			<td class="<%=classvalue%>"  style="font-size:7pt;WORD-BREAK:BREAK-ALL;"><%=CommonBean.checkForNull((String)dataList.get("FM_ITEM_DESC"),"&nbsp;")%></td>
			 <!-- 					
						* @Name - Priya
						* @Date - 19/02/2010
						* @Inc# - IN019466
						* @Desc - To right align Quantity, Expected Qty.				
					-->
			<td class="<%=classvalue%>" style="TEXT-ALIGN:right"><font size=1><%=bean.setNumber(CommonBean.checkForNull((String)dataList.get("FM_ITEM_QTY"),"&nbsp;"),Integer.parseInt(no_deci_from))%></font>&nbsp;</td>
			<td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull((String)dataList.get("FM_STK_UOM_CONV_FACTOR"),"&nbsp;")%>&nbsp;</font></td>
			<td class="<%=classvalue%>" style="font-size:7pt;WORD-BREAK:BREAK-ALL;"><%=CommonBean.checkForNull((String)dataList.get("TO_ITEM_DESC"),"&nbsp;")%></td>
			<td class="<%=classvalue%>" style="TEXT-ALIGN:right"><font size=1><%=bean.setNumber(CommonBean.checkForNull((String)dataList.get("TO_ITEM_QTY"),"&nbsp;"),Integer.parseInt(no_deci_to))%>&nbsp;</font></td>
			
			<!-- <td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull((String)dataList.get("REQUESTED_BY"),"&nbsp;")%></font></td>  -->
			<!-- <td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull((String)dataList.get("REMARKS"),"&nbsp;")%></font></td> -->
			 <td  class="<%=classvalue%>"><input type=checkbox onClick="return checkAllowed(this);" name="check<%=i%>" id="check<%=i%>"></font></td>
			   <input type=hidden name="prod_tfr_req_no<%=i%>" id="prod_tfr_req_no<%=i%>" value="<%=(String)dataList.get("PROD_TFR_REQUEST_NO")%>">
			   <input type=hidden name="fm_item_code<%=i%>" id="fm_item_code<%=i%>" value="<%=(String)dataList.get("FM_ITEM_CODE")%>">
			   <input type=hidden name="fm_item_desc<%=i%>" id="fm_item_desc<%=i%>" value="<%=(String)dataList.get("FM_ITEM_DESC")%>">
			   <input type=hidden name="fm_item_qty<%=i%>" id="fm_item_qty<%=i%>" value="<%=(String)dataList.get("FM_ITEM_QTY")%>">
			   <input type=hidden name="fm_stk_uom_conv_factor<%=i%>" id="fm_stk_uom_conv_factor<%=i%>" value="<%=(String)dataList.get("FM_STK_UOM_CONV_FACTOR")%>">
			   <input type=hidden name="to_item_code<%=i%>" id="to_item_code<%=i%>" value="<%=(String)dataList.get("TO_ITEM_CODE")%>">
			   <input type=hidden name="to_item_qty<%=i%>" id="to_item_qty<%=i%>" value="<%=(String)dataList.get("TO_ITEM_QTY")%>">
			   <input type=hidden name="to_stk_uom_conv_factor<%=i%>" id="to_stk_uom_conv_factor<%=i%>" value="<%=(String)dataList.get("TO_STK_UOM_CONV_FACTOR")%>">
			   <input type=hidden name="remarks<%=i%>" id="remarks<%=i%>" value="<%=(String)dataList.get("REMARKS")%>">
			   <input type="hidden" name="allow_deci_yn_from<%=i%>" id="allow_deci_yn_from<%=i%>"				value="<%=allow_deci_yn_from%>">
		       <input type="hidden" name="no_deci_from<%=i%>" id="no_deci_from<%=i%>"				value="<%=no_deci_from%>">
		       <input type="hidden" name="allow_deci_yn_to<%=i%>" id="allow_deci_yn_to<%=i%>"				value="<%=allow_deci_yn_to%>">
		       <input type="hidden" name="no_deci_to<%=i%>" id="no_deci_to<%=i%>"				value="<%=no_deci_to%>">

		<% }%>
    </table>
		<input type="hidden" name="maxAllowed" id="maxAllowed" value="<%=maxAllowed%>">
		<input type="hidden" name="mode" id="mode"		 value="<%=mode%>">
		<input type="hidden" name="totalRecords" id="totalRecords" value='<%=alrequestbatches.size()%>'>
		<input type="hidden" name="prt_delete_yn" id="prt_delete_yn"		value="<%=bean.getMfg_delete_yn()%>">
		<%}
		else
		{%>  
			<form name='ProductTransferRequestSearchCriteria' id='ProductTransferRequestSearchCriteria'>
			<input type="hidden" name="totalRecords" id="totalRecords" value='0'> 
				
			 <script>
			//	 alert("after="+ProductTransferRequestSearchCriteria.totalRecords.value);
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));

				//parent.window.close();
			</script>
		<%}%>			
    </form>
	<form name=ProductTransferRequestSearchCriteria_Form id=ProductTransferRequestSearchCriteria_Form action="../../eCommon/jsp/report_options.jsp" target="messageFrame"> 
			<input type="hidden" name="bean_id" id="bean_id"		 value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"	 value="<%=bean_name%>">
			<input type="hidden" name="p_module_id" id="p_module_id"  value="ST">
			<input type="hidden" name="p_report_id" id="p_report_id"  value="STBWRREP">
			<input type="hidden" name="p_user_name" id="p_user_name"	 value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%=facility_id%>">
			<input type="hidden" name="p_request_no" id="p_request_no" value=""> 
		</form>
	</center>
		<%
	} catch(Exception e) {
		out.print("Exception @ Result JSP :"+e);
	}
%>
 <%
putObjectInBean("ProductTransferBean",bean,request);
%>
  </body>
</html>

