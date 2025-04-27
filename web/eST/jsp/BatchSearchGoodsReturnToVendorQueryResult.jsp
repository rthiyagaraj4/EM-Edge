<!DOCTYPE html>
<%
/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
12/01/2018		66199				Shazana Hasan							GHL-CRF- 0499 - Added Challan_No in Batch Search
22/01/2018							Chithra										 GHL-CRF-496 
24/07/2018		66199				Shazana Hasan							GHL-CRF- 0499 - Added Challan_No in Batch Search
16/11/2018		69074				Shazana Hasan							GHL-ICN-0032
---------------------------------------------------------------------------------------------------------
*/
%>
 <%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.*,java.lang.*,java.sql.*,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>

	<head>
		<title></title>
<!-- 		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link>
 --><%
 request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/rowcolor.js"></script>
		<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="Javascript" src="../../eST/js/StCommon.js"></script>
		<!-- <script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="Javascript" src="../../eST/js/BatchSearchGoodsReturnToVendor.js"> </script>
   <script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

   </head>

<body>
<%
	String from	= request.getParameter( "from" )==null?"":request.getParameter( "from" ) ;
	String to	= request.getParameter( "to" )==null?"":request.getParameter( "to" ) ;
	BatchSearchGoodsReturnToVendorBean bean = (BatchSearchGoodsReturnToVendorBean) getBeanObject( "BatchSearchGoodsReturnToVendorBean","eST.BatchSearchGoodsReturnToVendorBean",request );
	bean.setLanguageId(locale);
	String searchFunction	= 	bean.getSearchFunction() ;
	String multipleSelect	=	bean.getMultipleSelect() ;
	String maxAllowed	    =	bean.getMaxAllowed() ;
    String expiry_yn		=   bean.getExpYN();
    String EXPIRY_DATE_OR_RECEIPT_DATE = "";

    	//ADDED FOR GHL-CRF-0499 START
    	String challanNo="";
	   Connection con				= null;
		con						= ConnectionManager.getConnection(request);
		boolean site_main = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_DISPLAY_CHALLAN_NO");
		bean.setSite_spec_yn(site_main);


	int maxRec=0; 
	int start = 0;
	int end  = 0;
	int displaySize = 0;
	int count = 0;	
		
	String  classvalue="";
	ArrayList result=new ArrayList();	
	HashMap dataList	= null;
	try{
	
		result=bean.getDataList();
		maxRec=  result.size();

		displaySize = Integer.parseInt( (String) CommonRepository.getCommonKeyValue("QUERY_RESULT_SIZE"));
		displaySize = maxRec;

        if ( from == null || from =="" )
			start = 0;
		else
			start = Integer.parseInt( from ) ;

		if ( to == null || to ==""){
			end = displaySize ;
		}
		else{
			end = Integer.parseInt( to ) ;	
		}
		String site_id=bean.getCustomerID();
	String sap_legend="";
	if(site_id.equals("MC")){
		sap_legend="SAP " ;
	
	}
        
        if(result.size() > 0 ){

		%>
			<form name='BatchsearchForm' id='BatchsearchForm' >
			<div  style="position:relative;height:286px;overflow:auto">			
			<table border="1" cellpadding="0" cellspacing="0" width="100%"  id='tb1'  align='center'>
			  <tr style='position:relative'style='top:expression(this.offsetParent.scrollTop-2)'>
				<th  class='CAGROUP_HEADING'><font size=1><b><%=sap_legend%><fmt:message key="eST.GRNDocNo.label" bundle="${st_labels}"/></b></font></th>
				<th  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="Common.item.label" bundle="${common_labels}"/></b></font></th>
				<% if (expiry_yn.equals("Y")){ %>
				<th  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></b></font></th>
				<%} else { %>
                <th  class='CAGROUP_HEADING'><font size=1><b>  <fmt:message key="Common.receiptdate.label" bundle="${common_labels}"/></b></font></th>
                <%} %>

				<th  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></b></font></th>
				
				<!-- Added against ghl-crf-0499 START-->
				<%if( site_main ){ %>				
				<th  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eST.ChallanNo.label" bundle="${st_labels}"/></b></font></th><!-- Added against GHL-CRF- 0499 -->
				<% } %>
				<!-- Added against ghl-crf-0499 END-->
				
				<th  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></b></font></th><!-- Modified for IN:074037  -->
				<th  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></b></font></th><!-- Modified for IN:074037  -->
				<th  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="Common.PurchaseUOM.label" bundle="${common_labels}"/></b></font></th>
				<th  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eST.GRNQuantity.label" bundle="${st_labels}"/></b></font></th>
				<!-- <th  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eST.AvailableQty.label" bundle="${st_labels}"/></b></font></th> commanded for GHL-CRF-496-->
				
				<!-- added start  GHL-CRF-496  -->
				<th class='CAGROUP_HEADING' ><font size=1><b><fmt:message key="eST.MaxReturnQty.label" bundle="${st_labels}"/></b></font></th>
				
				 <!-- end  GHL-CRF-496  -->
				
				
				<%if(searchFunction.equals("Y")){%>
				   <th  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></b></font></th>
			    <%}%>
			  </tr>
		<%
			count	= start;
			int chkCount = 0;
			while ( count < maxRec && count < end)
			{
				//out.println(count );
				dataList = (HashMap)result.get(count);
				if ( count % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;

               EXPIRY_DATE_OR_RECEIPT_DATE = CommonBean.checkForNull((String)dataList.get("EXPIRY_DATE_OR_RECEIPT_DATE"));
				if(!locale.equals("en"))
		{
					 EXPIRY_DATE_OR_RECEIPT_DATE  = com.ehis.util.DateUtils.convertDate(EXPIRY_DATE_OR_RECEIPT_DATE,"DMY","en",locale);
		}
		else
		{
		EXPIRY_DATE_OR_RECEIPT_DATE=EXPIRY_DATE_OR_RECEIPT_DATE;
		}
		String allow_deci_yn            =   bean.checkForNull(bean.getAllowDecimalsYN((String)dataList.get("ITEM_CODE")),"N");
	    String no_deci            =   bean.checkForNull(""+bean.getNoOfDecimals(),"0");
		if(allow_deci_yn.equals("N"))
           no_deci ="0";
		//added for GHL-CRF-0499 START
		String batchid=(String)dataList.get("BATCH_ID");
		String expDate =(String)dataList.get("EXPIRY_DATE_OR_RECEIPT_DATE");
		String itemCode = (String)dataList.get("ITEM_CODE");
		//added for GHL-CRF-0499 END
			   
			   %>
							
			<tr>
			<%	
				if(site_id.equals("MC")){%>
				<td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull((String)dataList.get("EXT_DOC_NO"),"&nbsp;")%></font></td>
				<td class="<%=classvalue%>"  
				<%}else{%>
				
				<td class="<%=classvalue%>" ><font size=1><%=(String)dataList.get("GRN_DOC_NO")%></font></td>
				<%}%>
				<td class="<%=classvalue%>"  title="GRN:<%=(String)dataList.get("GRN_DOC_TYPE_CODE")%>/<%=(String)dataList.get("GRN_DOC_NO")%> PO#<%=CommonBean.checkForNull((String)dataList.get("PO_NO"))%>"><font size=1><%=CommonBean.checkForNull((String)dataList.get("ITEM_DESC"),"&nbsp;")%></font></td>
				<td class="<%=classvalue%>" ><font size=1><%=EXPIRY_DATE_OR_RECEIPT_DATE%></font></td>
				<td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull((String)dataList.get("BATCH_ID"),"&nbsp;")%></font></td>
				
				<!-- added for GHL-CRF-0499 START, MODIFIED FOR GHL-ICN-0032 -->
				<%
				if(site_main){
						challanNo = bean.getChallanNo(itemCode, batchid, expDate, bean.getStore_code()); 
				%>
				<td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull(challanNo,"&nbsp;")%></font></td>  <!-- Added against GHL-CRF- 0499 -->
				<% } %>
				<!-- Added against GHL-CRF-0499 END-->
				
				<td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull((String)dataList.get("TRADE_NAME"),"&nbsp;")%></font></td>
				<td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull((String)dataList.get("BIN_LOCATION_DESC"),"&nbsp;")%></font></td>
				<td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull((String)dataList.get("SHORT_DESC"),"&nbsp;")%></font></td>
				<td class="<%=classvalue%>" ><font size=1><%=bean.setNumber(CommonBean.checkForNull((String)dataList.get("GRN_ITEM_QTY"),"0"),Integer.parseInt(no_deci))%></font></td>
				<td class="<%=classvalue%>" ><font size=1><%=bean.setNumber(CommonBean.checkForNull((String)dataList.get("AVAIL_QTY"),"0"),Integer.parseInt(no_deci))%></font></td>
				<% if(searchFunction.equals("Y")) {%>
				<td  class="<%=classvalue%>"><input type='checkbox' onClick="return checkAllowed(this,'<%=(String)dataList.get("GRN_DOC_TYPE_CODE")%>/<%=(String)dataList.get("GRN_DOC_NO")%>');" name="check<%=count%>" title="GRN:<%=(String)dataList.get("GRN_DOC_TYPE_CODE")%>/<%=(String)dataList.get("GRN_DOC_NO")%> PO#<%=CommonBean.checkForNull((String)dataList.get("PO_NO"))%>"></font></td>
				<input type='hidden' name="batch_id<%=count%>" id="batch_id<%=count%>" value="<%=(String)dataList.get("BATCH_ID")%>"><input type='hidden' name="item_code<%=count%>" id="item_code<%=count%>" value="<%=(String)dataList.get("ITEM_CODE")%>"><input type='hidden' name="item_desc<%=count%>" id="item_desc<%=count%>" value="<%=(String)dataList.get("ITEM_DESC")%>"><input type='hidden' name="store_code<%=count%>" id="store_code<%=count%>" value="<%=(String)dataList.get("STORE_CODE")%>"><input type='hidden' name="store_desc<%=count%>" id="store_desc<%=count%>" value="<%=(String)dataList.get("STORE_DESC")%>"><input type='hidden' name="expiry_date<%=count%>" id="expiry_date<%=count%>" value="<%=(String)dataList.get("EXPIRY_DATE")%>"><input type='hidden' name="bin_location_code<%=count%>" id="bin_location_code<%=count%>" value="<%=(String)dataList.get("BIN_LOCATION_CODE")%>"><input type='hidden' name="bin_desc<%=count%>" id="bin_desc<%=count%>" value="<%=(String)dataList.get("BIN_DESC")%>"><input type='hidden' name="trade_id<%=count%>" id="trade_id<%=count%>" value="<%=(String)dataList.get("TRADE_ID")%>"><input type='hidden' name="trade_name<%=count%>" id="trade_name<%=count%>" value="<%=(String)dataList.get("TRADE_NAME")%>"><input type='hidden' name="qty_on_hand<%=count%>" id="qty_on_hand<%=count%>" value="<%=(String)dataList.get("QTY_ON_HAND")%>"><input type='hidden' name="nod<%=count%>" id="nod<%=count%>" value="<%=(String)dataList.get("NOD")%>"><input type='hidden' name="avail_qty<%=count%>" id="avail_qty<%=count%>" value="<%=(String)dataList.get("AVAIL_QTY")%>"><input type='hidden' name="grn_unit_cost_in_pur_uom<%=count%>" id="grn_unit_cost_in_pur_uom<%=count%>" value="<%=(String)dataList.get("GRN_UNIT_COST_IN_PUR_UOM")%>"><input type='hidden' name="grn_doc_srl_no<%=count%>" id="grn_doc_srl_no<%=count%>"  value="<%=(String)dataList.get("GRN_DOC_SRL_NO")%>"><input type='hidden' name="grn_doc_date<%=count%>" id="grn_doc_date<%=count%>" value="<%=(String)dataList.get("GRN_DOC_DATE")%>"><input type='hidden' name="grn_doc_no<%=count%>" id="grn_doc_no<%=count%>" value="<%=(String)dataList.get("GRN_DOC_NO")%>"><input type='hidden' name="grn_doc_type_code<%=count%>" id="grn_doc_type_code<%=count%>" value="<%=(String)dataList.get("GRN_DOC_TYPE_CODE")%>">


				</td>
				<%}%>
           	</tr>
								
		<%
			count++;
			chkCount++;
			//prev_item_store=curr_item_store;
	      }  //End of while loop
       %> </table>
		    <input type="hidden" name="start" id="start" value="<%=start%>">
			<input type="hidden" name="end" id="end" value="<%=end%>">
			<input type="hidden" name="totalRecords" id="totalRecords" value="<%=result.size()%>">
			<input type="hidden" name="displaySize" id="displaySize" value="<%=displaySize%>">
			<input type="hidden" name="multipleSelect" id="multipleSelect" value="<%=multipleSelect%>">
			<input type="hidden" name="maxAllowed" id="maxAllowed" value="<%=maxAllowed%>">
			<input type="hidden" name="count" id="count" value="1">
			<input type="hidden" name="pur_uom_conv" id="pur_uom_conv" value="<%=(String)dataList.get("PUR_UOM_CONV")%>">
			<input type="hidden" name="site_id" id="site_id" value="<%=site_id%>">
            
	  <%  out.flush();
		  }else{ %>

			 <script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				parent.window.close();
			 </script>
		<% 	} 

  	  }catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
	//added for GHL-CRF-0499
	finally{
		if(con != null)
			ConnectionManager.returnConnection(con,request);
	}
%>
<%
putObjectInBean("BatchSearchGoodsReturnToVendorBean",bean,request);
%>
</body>
</form>
               <!-- <script>activeLink();</script> -->
</html>

