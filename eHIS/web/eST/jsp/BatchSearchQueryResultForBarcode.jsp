<!DOCTYPE html>
<%@page import="eST.Common.StHeaderBean"%><!--added for GH-CRF-0531-->
<%@page import="eST.SplitBatchBean"%> <!--added for GH-CRF-0531-->
<%@ page import ="eST.BatchSearchBeanForBarcode,eCommon.Common.*,java.util.HashMap,java.util.ArrayList,java.lang.*,webbeans.eCommon.*,java.text.NumberFormat,java.text.DecimalFormat" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>

<html>
	<head> 
		<title></title>
 <%
			request.setCharacterEncoding("UTF-8");
 			String locale			= (String)session.getAttribute("LOCALE");
			String sStyle			= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<link rel="stylesheet" type ="text/css" href="../../eST/html/IeStyle.css"></link>
		<script language="JavaScript" SRC="../../eCommon/js/common.js"></script>
		<script language="JavaScript" SRC="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/rowcolor.js"></script>
		<script language="Javascript" src="../../eST/js/StCommon.js"></script>
		<script language="Javascript" src="../../eST/js/BatchSearchForBarcode.js"> </script>
 	    <script language="javascript" src="../../eST/js/StTransaction.js"></script>
        <script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body>
<%
	String from							=		request.getParameter( "from" )==null?"":request.getParameter( "from" ) ;
	String to							=		request.getParameter( "to" )==null?"":request.getParameter( "to" ) ;
	String stlightgreen					=		"";
	BatchSearchBeanForBarcode bean				=		(BatchSearchBeanForBarcode) getBeanObject( "batchSearchBeanForBarcode","eST.BatchSearchBeanForBarcode",request );
	/*Added for GHL-CRF-0531 START*/
	StHeaderBean bean1				=		(StHeaderBean) getBeanObject( "stHeaderBean","eST.Common.StHeaderBean",request );
	SplitBatchBean bean2			=  		(SplitBatchBean) getBeanObject( "splitBatchBean","eST.SplitBatchBean",request );
	/*Added for GHL-CRF-0531 END*/
	
	 
	bean.setLanguageId(locale);

	String searchFunction				= 		bean.getSearchFunction() ;
	String multipleSelect				=		bean.getMultipleSelect() ;
	String includeSuspendedBatches		=		bean.getIncludeSuspendedBatches() ;
	String includeExpiredBatches		= 		bean.getIncludeExpiredBatches() ;
	String includeZeroStockBatches		=		bean.getIncludeZeroStockBatches() ;
	String maxAllowed					=		bean.getMaxAllowed() ;
	String p_list_all_trades_yn			=		request.getParameter( "p_list_all_trades_yn" )==null?"":request.getParameter( "p_list_all_trades_yn" ) ;
	String barcode						=		request.getParameter( "barcode" )==null?"":request.getParameter( "barcode" ) ;
	  

	int maxRec							=		0; 
	int start							=		0;
	int end								=		0;
	int displaySize						=		0;
	int count							=		0;	
	String expiry_yn					=		"";
	int EWDays							=		0;

	String ACC_ENTITY_ID				=		(String)session.getAttribute("ACC_ENTITY_ID");
	String  classvalue					=		"";
	ArrayList result					=		new ArrayList();	
	HashMap dataList					=		null;

	String curr_item_store				=		"";
	String prev_item_store				=		"";
	String suspended					=		"";
	String stSQL						=		"";
	String item_code_from				=		"";
	String item_code_to					=		"";
	ArrayList alParameters	=	new ArrayList();
	ArrayList listRecord	=	new ArrayList();
	int no_of_decimals=bean.getNoOfDecimals(); 
	System.out.println("bean.getIncludeZeroStockBatches(): "+bean.getIncludeZeroStockBatches());
	
	 /*added for GHL-CRF-0531 start*/
	HashMap recordMap	=	null;
	HashMap recordMap1	=	null;//ADDED FOR GHL-CRF-0531
	HashMap recordMap2	=	null;//IN068961
	String item_code="";
	String storeCode="";
	String batchid="";
	String exp_date="";
	String bin_loc_code="";
	String storeBatchExp="";
	String headerBatchExp = "";
	String storeBatchExpBin ="";
	String itemCode="";
	String headerStore ="";//ADDED FOR GHL-CRF-0531
	String defBinLoc ="";
	String binLocationDesc ="";
	String recExpiry_yn="";	
	ArrayList strBatchExpList	=	new ArrayList();
	ArrayList strBatchExpBinList	=	new ArrayList();
	ArrayList strBatchExpQOH	=	new ArrayList();
	ArrayList strBatchExpAvlQty	=	new ArrayList();
	ArrayList strBatchExpQOH2	=	new ArrayList();//IN068961
	ArrayList strBatchExpAvlQty2	=	new ArrayList();//IN068961
	ArrayList headerlist					=		new ArrayList();
	ArrayList strBatchExpList2	=	new ArrayList();
	//ArrayList list1					=		new ArrayList();//GHL-CRF-0531
	//ArrayList list2					=		new ArrayList();//GHL-CRF-0531
	ArrayList list3					=		new ArrayList();//GHL-CRF-0531
	
	
	/*added for GHL-CRF-0531 end*/
	
	try{
			
				EWDays					=		bean.getEntityparam_EWDays(ACC_ENTITY_ID);
				result					=		bean.getDataList();			 
				maxRec					=		result.size();
				
				
				/*added for GHL-CRF-0531 start*/
				bean.setSrcStoreCode(bean1.getStore_code());
				headerBatchExp = bean.getSrcBatchid()+bean.getSrcExpDate();
				int k =0;
				int totalQOh = 0;
				int totalAvlQty = 0; 
				int finalQOH = 0; //IN068961
				int finalAvlQty = 0; //IN068961
			
				//added for fix - storing the batch exp of header store in a list start
				for (int h=0 ; h < result.size() ; h++){
					recordMap1	 = (HashMap)result.get(h);	
					
					String store1=(String)recordMap1.get("STORE_CODE");
					batchid= (String)recordMap1.get("BATCH_ID");
					exp_date = (String)recordMap1.get("EXPIRY_DATE");
					headerStore=bean1.getStore_code();
										
					if(headerStore.equalsIgnoreCase(store1)){
					storeBatchExp = batchid+exp_date;
					list3.add(storeBatchExp);
					}
				}
				//added for fix- to sort the result according to header store code end
				// added for IN068961 START
				int t=0;
				String prevQOH = ""; 
				String prevAvlQty = "";
				// added for IN068961 END
						
				while ( k < result.size() ){
					recordMap	 = (HashMap)result.get(k);	
					System.out.println("recordMap: "+recordMap);	
					batchid= (String)recordMap.get("BATCH_ID");
					exp_date = (String)recordMap.get("EXPIRY_DATE");
					itemCode = (String)recordMap.get("ITEM_CODE");
					String store1=(String)recordMap.get("STORE_CODE");
					String binLocCode = (String)recordMap.get("BIN_LOCATION_CODE");
					String QOH = (String)recordMap.get("QTY_ON_HAND");
					String avlQty = (String)recordMap.get("AVAIL_QTY");			
					storeBatchExp = batchid+exp_date;	
					storeBatchExpBin = batchid+exp_date+binLocCode;
					headerStore=bean1.getStore_code();
					
					if ( store1.equalsIgnoreCase(headerStore) ){						
						if ( (!strBatchExpList.contains(storeBatchExp)) && (!(headerBatchExp.contains(storeBatchExp))) ){							
							strBatchExpList.add(storeBatchExp); 
							strBatchExpBinList.add(storeBatchExpBin);
							strBatchExpQOH2.clear();//IN068961
							strBatchExpAvlQty2.clear();//IN068961
							strBatchExpQOH.add(QOH);
							strBatchExpAvlQty.add(avlQty);
							prevQOH=(String)recordMap.get("QTY_ON_HAND"); 
							prevAvlQty=(String)recordMap.get("AVAIL_QTY"); 
							finalQOH=0;
							finalAvlQty =0;
							t=0;
							k++;
						}
						else if(strBatchExpList.contains(storeBatchExp)) {							
							System.out.println("same item different bin");
							// added for IN068961 START	
							strBatchExpQOH2.add(QOH);
							strBatchExpAvlQty2.add(avlQty);
							
							int p = k-1;	
			
							if(t==0){
								totalQOh = Integer.parseInt(prevQOH) + Integer.parseInt(QOH); 
								totalAvlQty = Integer.parseInt(prevAvlQty) + Integer.parseInt(avlQty);
								prevQOH = "";
								prevAvlQty = "";
								t=t+1;
								recordMap.put("QTY_ON_HAND", String.valueOf(totalQOh)); 
								recordMap.put("AVAIL_QTY", String.valueOf(totalAvlQty)); 
								
							}else{
								finalQOH = finalQOH + totalQOh + Integer.parseInt(QOH) ;
								finalAvlQty = finalAvlQty + totalQOh + Integer.parseInt(avlQty);							
								totalQOh = 0; 
								totalAvlQty = 0;
								recordMap.put("QTY_ON_HAND", String.valueOf(finalQOH)); 
								recordMap.put("AVAIL_QTY", String.valueOf(finalAvlQty)); 
							}
							// added for IN068961 END						
							result.remove(p);
						}					
						else{
							result.remove(k);
						}
							
					}
					else{
						try{
							if( !list3.contains(storeBatchExp) && (!(headerBatchExp.contains(storeBatchExp))) && !strBatchExpList2.contains(storeBatchExp)){
								strBatchExpList2.add(storeBatchExp);
								k++; 
							}
							else{
								result.remove(k); 
							}						
						}
						catch(Exception e){
							e.printStackTrace();
						}						
					}												
				} 
						maxRec=result.size();
				 /*added for GHL-CRF-0531 end*/
		
		if(!searchFunction.equals("Y")){

				displaySize				=		Integer.parseInt( (String) CommonRepository.getCommonKeyValue("QUERY_RESULT_SIZE"));
				displaySize				=		Integer.parseInt("12");
				if ( from == null || from =="" )
					start				=		0;
				else
					start = Integer.parseInt( from ) ;

				if ( to == null || to ==""){
					end					=		displaySize ;
				}
				else{
					end					=		Integer.parseInt( to ) ;	
				}
		}
		if(result.size() > 0 ){
		%>
			<form name="BatchsearchForm" id="BatchsearchForm">
			<div name='msg' id='msg' style="position:absolute;width: 0; height: 0; left: 201; top: 62">
			</div>
			<table cellpadding=0 cellspacing=0 width="100%" align=center>
			<tr>
			<table border="1" cellpadding="0" cellspacing="0" width="100%"  id='tb1' align=center>
			<tr>
	
				<th  class='CAGROUP_HEADING' ></font></th> 
				<th  class='CAGROUP_HEADING' ><font size=1><b><fmt:message key="eST.Expiry/ReceiptDate.label" bundle="${st_labels}"/></b></font></th>
				<th  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></b></font></th>
				<th  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></b></font></th>
				<th  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="Common.Manufacturer.label" bundle="${common_labels}"/></b></font></th>
				<!-- <th  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="Common.BinLocation.label" bundle="${mm_labels}"/></b></font></th> --> 
				<th  class='CAGROUP_HEADING'><font size=1><b> <fmt:message key="Common.uom.label" bundle="${common_labels}"/></b></font></th>
				<th  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eST.QuantityOnHand.label" bundle="${st_labels}"/></b></font></th>
				<th  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eST.AvailableQty.label" bundle="${st_labels}"/></b></font></th>
			<%if(searchFunction.equals("Y")){%>
				<th  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></b></font></th>
			<%}%>
			</tr>
		<%
			count				=		start;
			int chkCount		=		0;

            if(!searchFunction.equals("Y")) {
//added for GHL-CRF-0531 START
            	 expiry_yn	=		recExpiry_yn;
					if(expiry_yn.equals("N")) 
							expiry_yn	=		"No";
					else if(expiry_yn.equals("Y")) 
							expiry_yn	=		"Yes";
			%>
			<%if(searchFunction.equals("Y")){%>
			<tr>
				<td colspan=10  
						class='ITEMSELECT'><font size=1><b><fmt:message key="Common.item.label" bundle="${common_labels}"/> :</b> 
								<%=itemCode%>&nbsp;&nbsp;
								 <b><fmt:message key="eST.ExpiryItems.label" bundle="${st_labels}"/> : </b><%=expiry_yn%>&nbsp;&nbsp;
<%-- 								 <b><fmt:message key="Common.Store.label" bundle="${mm_labels}"/> :  --%>
<%-- 								</b><%=store2%> --%>
				</font></td>
			</tr>
			<%}else{%>
			 <tr>
				<td colspan=9  class='ITEMSELECT'><font size=1><b>
				<fmt:message key="Common.item.label" bundle="${common_labels}"/> :</b> <%=itemCode%>&nbsp;&nbsp;
				<b><fmt:message key="eST.ExpiryItems.label" bundle="${st_labels}"/> : </b><%=expiry_yn%>&nbsp;&nbsp; 
<%-- 				<b><fmt:message key="Common.Store.label" bundle="${mm_labels}"/> : --%>
<%-- 				</b> <%=store2%></b></font></td> --%>
			</tr> 
			<% }%>
            	
            <% 	
			while ( count < maxRec && count < end)
			{
				dataList		=		(HashMap)result.get(count);
				if ( count % 2 == 0 )
					classvalue  =		"QRYEVEN" ;
				else
					classvalue  =		"QRYODD" ;
					
				curr_item_store =		(String)dataList.get("ITEM_CODE")+(String)dataList.get("STORE_CODE");				       
				//ADDED FOR GHL-CRF-0531 END
%>
			
		 <tr id="tr_<%=chkCount%>">
			<%
				
				stlightgreen		=		classvalue;
				String tool			=		"";
				String description	=		"";
				String expiry_date  =		(String)dataList.get("EXPIRY_DATE");
		
			suspended = CommonBean.checkForNull((String)dataList.get("SUSPENDED_YN"),"");
	
			if((!bean.isGreaterThanSysdate(expiry_date))&& expiry_yn.equals("Yes")){
					stlightgreen	=		"STLIGHTCREAM";
					tool			=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.ExpiredBatch.label","st_labels");
					//tool			=		"Expired Batch";
					description		=		"E";
				}
				else if (suspended.equals("Y")) 
					{
							
							stlightgreen	=	"STLIGHTCREAM";
							 tool			=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.SuspendedBatch.label","st_labels");
							//tool			=	"Suspended Batch";
							description		=	"S";
							
				}
				else if (((String)dataList.get("EXPIRY_YN")).equals("Y") &&   Integer.parseInt((String)dataList.get("NOD")) <= EWDays){
						
						stlightgreen		=	"STLIGHTCREAM";
						String  tool_expd	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Expiringin.label","st_labels");
						String tool_days	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels");
						tool				=	tool_expd +(String)dataList.get("NOD")+tool_days;
						description			=	"E"+(String)dataList.get("NOD");												
					}

			 	 if (((!bean.isGreaterThanSysdate(expiry_date))&& expiry_yn.equals("Yes"))&& (suspended.equals("Y")))
					 {
					stlightgreen			=	"STLIGHTCREAM";
					 tool					=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Suspended&ExpiredBatch.label","st_labels");
					//tool					=	"Suspended & Expired Batch";
					description				=	 "S/E";
					}
                 String stBatchStatus		=	(String)dataList.get("BATCH_STATUS") ;
				
				 //if( stBatchStatus .equals("C") ){
				 //Added by Rabbani for Bru-HIMS_CRF-111[inc no:30070]
				 if(suspended.equals("C") ){
					
					stlightgreen			=	"STLIGHTCREAM";
					tool					=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.NotifiedBatch.label","st_labels");
					//tool					=	"Notified Batch";
					description				=	"C";
				 }

				 
				 //if(((!bean.isGreaterThanSysdate(expiry_date))&& expiry_yn.equals("Yes"))&&stBatchStatus.equals("C"){
                if(((!bean.isGreaterThanSysdate(expiry_date))&& expiry_yn.equals("Yes"))&&suspended.equals("C")){
					
					stlightgreen			=	"STLIGHTCREAM";
					 tool					=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Expired&NotifiedBatch.label","st_labels");
					//tool					=	"Expired & Notified Batch";
					description				=	"E/C";

				 }
				  //if((((!bean.isGreaterThanSysdate(expiry_date))&& expiry_yn.equals("Yes"))&&stBatchStatus .equals("C") )&& (suspended.equals("Y")))
			 if((((!bean.isGreaterThanSysdate(expiry_date))&& expiry_yn.equals("Yes"))&& suspended.equals("C"))&& (suspended.equals("Y")))
					 {
					 stlightgreen			=	"STLIGHTCREAM";
					 tool					=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.SuspendedExpiredNotifiedBatch.label","st_labels");
					//tool					=	"Suspended,Expired & Notified Batch";
					description				=	"S/E/C";
					}
			%>
				<%if(description.equals("")){%>
				 <td class="<%=classvalue%>" >&nbsp;</td>
				<%}else{%>
				<td class="<%=stlightgreen%>"  title= "<%=tool%> " 
				<%if(!description.equals("E")){%>
				style = "cursor:pointer" onClick="showHistory1(tr_<%=chkCount%>,<%=chkCount%>,<%=count%>);" 
				<%}%>
				><font  size = 1 ><B><%=description%></B></font>
				</td>
				<%}%>
				<td class="<%=classvalue%>" >
				
				<font size=1><%=CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate((String)dataList.get("EXPIRY_DATE"),"DMY","en",locale),"&nbsp;")%></font></td>
				<td class="<%=classvalue%>" >
				<%
				String batch_id=(String)dataList.get("BATCH_ID");
				boolean value=com.ehis.util.DateUtils.validDate(batch_id,"DMY",locale);
				if(value)
				{					
				%>
	             <font size=1><%=CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate((String)dataList.get("BATCH_ID"),"DMY","en",locale),"&nbsp;")%></font></td>
				<%
				}
				else
				{
				%>
			   <font size=1><%=CommonBean.checkForNull((String)dataList.get("BATCH_ID"),"&nbsp;")%></font></td>
			  <%
				}
				%>
						
				<td class="<%=classvalue%>" >
				<font size=1><%=CommonBean.checkForNull((String)dataList.get("TRADE_NAME"),"&nbsp;")%></font>
				</td>
				<td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull((String)dataList.get("MANUFACTURER_NAME"),"&nbsp;")%></font></td>
				
				<!-- added for GHL-CRF-0531 start -->
<%-- 				 <%  --%>
  					
<%--  					%>	  --%>
<%--  				<td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull((String)dataList.get("BIN_DESC"),"&nbsp;")%></font></td>  --%>
<%--  				<% } else { %>  --%>
<%--  				  <td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull((String)dataList.get("BIN_DESC"),"&nbsp;")%></font></td> 				  --%>
<%--  				  <%} %>  --%>
				<!-- added for GHL-CRF-0531 end -->
				
<%--  				<td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull((String)dataList.get("BIN_DESC"),"&nbsp;")%></font></td>  <!-- commented for GHL-CRF-0531 --> --%>
				<td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull((String)dataList.get("UOM_DESC"),"&nbsp;")%></font></td>
				<!--
				* @Name - Priya
				* @Date - 01/02/2010
				* @Inc# - 15496 (SRR20056-CRF-0537.2)
				* @Desc - Modified by priya as if the value of 'QTY_ON_HAND' & 'AVAIL_QTY' is equal to zero and no_of_decimals is 4 then it should be displayed as 0 only & not as '0.000' & so used the common method
				-->
				<!-- 					
						* @Name - Priya
						* @Date - 19/02/2010
						* @Inc# - IN019466
						* @Desc - To right align Quantity on hand,AVAIL_QTY .				
					-->
					<!-- added for GHL-CRF-0531 start - -->
					<%
					if( bean1.getStore_code().equalsIgnoreCase((String)dataList.get("STORE_CODE")) ){
					%>
				<td class="<%=classvalue%>" style="TEXT-ALIGN:right"><font size=1><%=bean.setNumber(bean.checkForNull((String)dataList.get("QTY_ON_HAND"),"0"),no_of_decimals)%></font>&nbsp;</td>
				<td class="<%=classvalue%>" style="TEXT-ALIGN:right"><font size=1><%=bean.setNumber(bean.checkForNull((String)dataList.get("AVAIL_QTY"),"0"),no_of_decimals)%></font>&nbsp;</td>
				<%} else{ %>
				<td class="<%=classvalue%>" style="TEXT-ALIGN:right"><font size=1   value="0"><%=0%></font>&nbsp;</td>
				<td class="<%=classvalue%>" style="TEXT-ALIGN:right"><font size=1  value="0"><%=0%></font>&nbsp;</td>
				
				<%} %>
				<!-- added for GHL-CRF-0531 end -->
				
				
				<%
					if(  ! searchFunction.equals("Y"))	
					{%>
						<td  class="NODISPLAY"><input type=checkbox onClick="return checkAllowed(this);" name="check<%=count%>" id="check<%=count%>"></font></td><input type=hidden name="batch_id<%=count%>" id="batch_id<%=count%>" value="<%=(String)dataList.get("BATCH_ID")%>">
						<input type=hidden name="item_code<%=count%>" id="item_code<%=count%>" value="<%=(String)dataList.get("ITEM_CODE")%>">
						<input type=hidden name="item_desc<%=count%>" id="item_desc<%=count%>" value="<%=(String)dataList.get("ITEM_DESC")%>">
						<input type=hidden name="store_code<%=count%>" id="store_code<%=count%>" value="<%=(String)dataList.get("STORE_CODE")%>">
						<input type=hidden name="store_desc<%=count%>" id="store_desc<%=count%>" value="<%=(String)dataList.get("STORE_DESC")%>">
						<input type=hidden name="trade_id_applicable_yn<%=count%>" id="trade_id_applicable_yn<%=count%>" value="<%=(String)dataList.get("TRADE_ID_APPLICABLE_YN")%>">
						<input type=hidden name="expiry_date<%=count%>" id="expiry_date<%=count%>" value="<%=com.ehis.util.DateUtils.convertDate((String)dataList.get("EXPIRY_DATE"),"DMY","en",locale)%>">
						<input type=hidden name="bin_location_code<%=count%>" id="bin_location_code<%=count%>" value="<%=(String)dataList.get("BIN_LOCATION_CODE")%>">
						<input type=hidden name="bin_desc<%=count%>" id="bin_desc<%=count%>" value="<%=(String)dataList.get("BIN_DESC")%>">
						<input type=hidden name="trade_id<%=count%>" id="trade_id<%=count%>" value="<%=(String)dataList.get("TRADE_ID")%>">
						<input type=hidden name="trade_name<%=count%>" id="trade_name<%=count%>" value="<%=(String)dataList.get("TRADE_NAME")%>">
						<input type=hidden name="uom_code<%=count%>" id="uom_code<%=count%>" value="<%=(String)dataList.get("UOM_CODE")%>">
						<input type=hidden name="qty_on_hand<%=count%>" id="qty_on_hand<%=count%>" value="<%=(String)dataList.get("QTY_ON_HAND")%>">
						<input type=hidden name="nod<%=count%>" id="nod<%=count%>" value="<%=(String)dataList.get("NOD")%>">
						<input type=hidden name="manufacturer_id<%=count%>" id="manufacturer_id<%=count%>" value="<%=(String)dataList.get("MANUFACTURER_ID")%>">
						<input type=hidden name="manufacturer_name<%=count%>" id="manufacturer_name<%=count%>" value="<%=(String)dataList.get("MANUFACTURER_NAME")%>">
						<input type=hidden name="avail_qty<%=count%>" id="avail_qty<%=count%>" value="<%=(String)dataList.get("AVAIL_QTY")%>">
						<input type=hidden name="expiry_yn<%=count%>" id="expiry_yn<%=count%>" value="<%=bean.checkForNull((String)dataList.get("EXPIRY_YN"),"N")%>">
						<input type=hidden name="barcode_id<%=count%>" id="barcode_id<%=count%>"				value="<%=(String)dataList.get("BARCODE_ID")%>"><!-- Added against GHL-CRF-0446 -->
					<%}
				%>
			</tr>
		<%
				count++;
			chkCount++;
			//prev_item_store		=		curr_item_store; // commented for GHL-CRF-0531
			
			}
			}
			else
            {
	    //ADDED FOR GHL-CRF-0531 START
				expiry_yn		=		recExpiry_yn;
				 
				if(expiry_yn.equals("N")) 
					expiry_yn		=		"No";
				else if(expiry_yn.equals("Y")) 
					expiry_yn		=		"Yes";
		%>
		<%if(searchFunction.equals("Y")){ %>
		<tr>
			<td colspan=10  
				class='ITEMSELECT'><font size=1><b><fmt:message key="Common.item.label" bundle="${common_labels}"/> :</b> 
			<%=itemCode%>&nbsp;&nbsp; <b>
			<fmt:message key="eST.ExpiryItems.label" bundle="${st_labels}"/>  : </b><%=expiry_yn%>&nbsp;&nbsp;
<%-- 			<b><fmt:message key="Common.Store.label" bundle="${mm_labels}"/> :  --%>
<%-- 			</b><%=store2%> --%>
		</font></td>
		</tr>
		<%}else{ %>

		 <tr>
			<td colspan=9  class='ITEMSELECT'><font size=1><b><fmt:message key="Common.item.label" bundle="${common_labels}"/> :
			</b> <%=itemCode%>&nbsp;&nbsp;<b><fmt:message key="eST.ExpiryItems.label" bundle="${st_labels}"/>  : 
<%-- 			</b><%=expiry_yn%>&nbsp;&nbsp; <b><fmt:message key="Common.Store.label" bundle="${mm_labels}"/> : --%>
<%-- 			</b> <%=store2%></b></font></td> --%>
		</tr> 
		<%}%>
		
		<%	
				while ( count < maxRec) {

				dataList		=		(HashMap)result.get(count);
				//System.out.println("dataList: "+dataList);
				

				if ( count % 2 == 0 )
					classvalue	=		"QRYEVEN" ;
				else
					classvalue	=		"QRYODD" ;
				
				

				//ADDED FOR GHL-CRF-0531 END		

			
				stlightgreen			=		classvalue;
				String tool				=		"";
				String description		=		"";
				String expiry_date		=		(String)dataList.get("EXPIRY_DATE");
				suspended               =         CommonBean.checkForNull((String)dataList.get("SUSPENDED_YN"),"");

				if((!bean.isGreaterThanSysdate(expiry_date))&& expiry_yn.equals("Yes")){

					stlightgreen		=		"STLIGHTCREAM";
					tool				=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.ExpiredBatch.label","st_labels");
				//	tool				=		"Expired Batch";
					description			=		"E";
				}
				else if (suspended.equals("Y")) 
					{
					stlightgreen		=		"STLIGHTCREAM";
					tool				=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.SuspendedBatch.label","st_labels");
				//	tool				=		"Suspended Batch";
					description			=		"S";
				}
				else if (((String)dataList.get("EXPIRY_YN")).equals("Y") &&   Integer.parseInt((String)dataList.get("NOD")) <= EWDays){
					stlightgreen		=		"STLIGHTCREAM";
					String	 tool_exp	=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Expiringin.label","st_labels");
					String  tool_ds		=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels");
					tool				=		tool_exp+(String)dataList.get("NOD")+tool_ds;
					description			=		"E"+(String)dataList.get("NOD");												
					}


			 	 if (((!bean.isGreaterThanSysdate(expiry_date))&& expiry_yn.equals("Yes"))&& (suspended.equals("Y")))
					 {
					stlightgreen		=		"STLIGHTCREAM";
					tool				=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Suspended&ExpiredBatch.label","st_labels");
				//	tool				=		"Expired & Suspended Batch";
					description			=		"S/E";
					}

				String stBatchStatus	=		(String)dataList.get("BATCH_STATUS") ;

				 //if( stBatchStatus .equals("C") ){
				 if( suspended.equals("C")){
					
					stlightgreen		=		"STLIGHTCREAM";
					 tool				=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.NotifiedBatch.label","st_labels");
					//tool				=		"Notified Batch";
					description			=		"C";

				 }

		   // if(((!bean.isGreaterThanSysdate(expiry_date))&& expiry_yn.equals("Yes"))&&stBatchStatus.equals("C"){
			 if(((!bean.isGreaterThanSysdate(expiry_date))&& expiry_yn.equals("Yes"))&&suspended.equals("C")){
					stlightgreen		=		"STLIGHTCREAM";
					 tool				=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Expired&NotifiedBatch.label","st_labels");
					//tool				=		"Expired & Notified Batch";
					description			=		"E/C";
		 }
		 
	// if((((!bean.isGreaterThanSysdate(expiry_date))&& expiry_yn.equals("Yes"))&&stBatchStatus.equals("C"))&& (suspended.equals("Y")))
		 
	 if((((!bean.isGreaterThanSysdate(expiry_date))&& expiry_yn.equals("Yes"))&& suspended.equals("C"))&& (suspended.equals("Y")))
					 {
					stlightgreen		=		"STLIGHTCREAM";
					tool				=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.SuspendedExpiredNotifiedBatch.label","st_labels");
				//	tool				=		"Suspended,Expired & Notified Batch";
					description			=		"S/E/C";
					}
			%>
		
			
		 <tr id="tr_<%=chkCount%>">
				<%if(description.equals("")){%>
				 <td class="<%=classvalue%>" >&nbsp;</td>
				<%}else{%>
				<td class="<%=stlightgreen%>" title= "<%=tool%>" 
				<%if(!description.equals("E")){%>
				style = "cursor:pointer"   onClick="showHistory(tr_<%=chkCount%>,<%=chkCount%>);" 
				 <%}%>
				><font   size=1><B><%=description%></B></font></td>
				<%}%>
				<td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate((String)dataList.get("EXPIRY_DATE"),"DMY","en",locale),"&nbsp;")%></font></td>
				<td class="<%=classvalue%>" >
				
				<font size=1><%=CommonBean.checkForNull((String)dataList.get("BATCH_ID"),"&nbsp;")%></font></td>
				<td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull((String)dataList.get("TRADE_NAME"),"&nbsp;")%></font></td>
				<td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull((String)dataList.get("MANUFACTURER_NAME"),"&nbsp;")%></font></td>
				
				<!-- added for GHL-CRF-0531 start -->
<%--  				<%  --%>
 				
<%--  					%>	  --%>
<%-- 			<td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull((String)dataList.get("BIN_DESC"),"&nbsp;")%></font></td>  --%>
<%--  				<% } else { %>  --%>
<%--  				<td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull((String)dataList.get("BIN_DESC"),"&nbsp;")%></font></td>				  --%>
<%--  				<%} %>  --%>
				<!-- added for GHL-CRF-0531 end -->
				
<%--  				<td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull((String)dataList.get("BIN_DESC"),"&nbsp;")%></font></td> <!-- COMMENTED FOR GHL-CRF-0531 --> --%>
				 <td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull((String)dataList.get("UOM_DESC"),"&nbsp;")%></font></td>
				 
				 <!-- added for GHL-CRF-0531 start -->
					<%
					if( bean1.getStore_code().equalsIgnoreCase((String)dataList.get("STORE_CODE")) ){
					%>				 
				<td class="<%=classvalue%>" style="TEXT-ALIGN:right"><font size=1><%=CommonBean.checkForNull((String)dataList.get("QTY_ON_HAND"),"0")%></font>&nbsp;</td>
				<td class="<%=classvalue%>" style="TEXT-ALIGN:right"><font size=1><%=CommonBean.checkForNull((String)dataList.get("AVAIL_QTY"),"0")%></font>&nbsp;</td>
				<%}else{ %>
				<td class="<%=classvalue%>" style="TEXT-ALIGN:right"><font size=1><%=0%></font>&nbsp;</td>
				<td class="<%=classvalue%>" style="TEXT-ALIGN:right"><font size=1><%=0%></font>&nbsp;</td>
				<%} %>
				
				<!-- added for GHL-CRF-0531 end - -->
				
				
				
				<%
					if(searchFunction.equals("Y"))	
					{
					%>
						<td  class="<%=classvalue%>"><input type=checkbox onClick="return checkAllowed(this);" name="check<%=count%>" id="check<%=count%>"></font></td>

						<input type=hidden name="batch_id<%=count%>" id="batch_id<%=count%>"				value="<%=(String)dataList.get("BATCH_ID")%>">
						<input type=hidden name="item_code<%=count%>" id="item_code<%=count%>"				value="<%=(String)dataList.get("ITEM_CODE")%>">
						<input type=hidden name="item_desc<%=count%>" id="item_desc<%=count%>"				value="<%=(String)dataList.get("ITEM_DESC")%>">
						<input type=hidden name="store_code<%=count%>" id="store_code<%=count%>"				value="<%=(String)dataList.get("STORE_CODE")%>">
						<input type=hidden name="store_desc<%=count%>" id="store_desc<%=count%>"				value="<%=(String)dataList.get("STORE_DESC")%>">
						<input type=hidden name="trade_id_applicable_yn<%=count%>" id="trade_id_applicable_yn<%=count%>"	value="<%=(String)dataList.get("TRADE_ID_APPLICABLE_YN")%>">
						<input type=hidden name="expiry_date<%=count%>" id="expiry_date<%=count%>"				value="<%=com.ehis.util.DateUtils.convertDate((String)dataList.get("EXPIRY_DATE"),"DMY","en",locale)%>">
						<input type=hidden name="bin_location_code<%=count%>" id="bin_location_code<%=count%>"		value="<%=(String)dataList.get("BIN_LOCATION_CODE")%>">
						<input type=hidden name="bin_desc<%=count%>" id="bin_desc<%=count%>"				value="<%=(String)dataList.get("BIN_DESC")%>">
						<input type=hidden name="trade_id<%=count%>" id="trade_id<%=count%>"				value="<%=(String)dataList.get("TRADE_ID")%>">
						<input type=hidden name="trade_name<%=count%>" id="trade_name<%=count%>"				value="<%=(String)dataList.get("TRADE_NAME")%>">
						<input type=hidden name="uom_code<%=count%>" id="uom_code<%=count%>"				value="<%=(String)dataList.get("UOM_CODE")%>">
						<input type=hidden name="qty_on_hand<%=count%>" id="qty_on_hand<%=count%>"				value="<%=(String)dataList.get("QTY_ON_HAND")%>">
						<input type=hidden name="nod<%=count%>" id="nod<%=count%>"						value="<%=(String)dataList.get("NOD")%>">
						<input type=hidden name="manufacturer_id<%=count%>" id="manufacturer_id<%=count%>"			value="<%=(String)dataList.get("MANUFACTURER_ID")%>">
						<input type=hidden name="manufacturer_name<%=count%>" id="manufacturer_name<%=count%>"		value="<%=(String)dataList.get("MANUFACTURER_NAME")%>">
						<input type=hidden name="avail_qty<%=count%>" id="avail_qty<%=count%>"				value="<%=(String)dataList.get("AVAIL_QTY")%>">
						<input type=hidden name="expiry_yn<%=count%>" id="expiry_yn<%=count%>"				value="<%=(String)dataList.get("EXPIRY_YN")%>">
						<input type=hidden name="barcode_id<%=count%>" id="barcode_id<%=count%>"				value="<%=bean2.checkForNull((String)dataList.get("BARCODE_ID"), "")%>"><!-- Added against GHL-CRF-0446,modified for ghl-crf-0531 -->
					<%}
				%>
			</tr>
		<%
				count++;
			chkCount++;
			//prev_item_store=curr_item_store; //commented for GHL-CRF-0531
			
			
			}
			}
		%>
			</table>
			<input type="hidden" name="locale" id="locale"					value="<%=locale%>">
			<input type="hidden" name="start" id="start"					value="<%=start%>">
			<input type="hidden" name="end" id="end"						value="<%=end%>">
			<input type="hidden" name="totalRecords" id="totalRecords"			value='<%=result.size()%>'>
			<input type="hidden" name="displaySize" id="displaySize"				value="<%=displaySize%>">
			<input type="hidden" name="multipleSelect" id="multipleSelect"			value="<%=multipleSelect%>">
			<input type="hidden" name="includeSuspendedBatches" id="includeSuspendedBatches" value="<%=includeSuspendedBatches%>">
			<input type="hidden" name="includeZeroStockBatches" id="includeZeroStockBatches" value="<%=includeZeroStockBatches%>">
			<input type="hidden" name="includeExpiredBatches" id="includeExpiredBatches"	value="<%=includeExpiredBatches%>">
            <input type="hidden" name="includeExpiredBatches" id="includeExpiredBatches"	value="Y">
			<input type="hidden" name="maxAllowed" id="maxAllowed"				value="<%=maxAllowed%>">
			<input type="hidden" name="count" id="count"					value="1">
			
		<%
			out.flush();
		} 
		else
		{
			%>
			<script>
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
           </script>
  
		<%
			 if(p_list_all_trades_yn.equals("N"))
		{%>
			 <script>
				parent.window.close();
			</script>
		<%
		}
		}
			


	} catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
%>

</body>
</form>
<% if(!searchFunction.equals("Y")) { %>
         <script>activeLink();</script>
 <% } %>

</html>

