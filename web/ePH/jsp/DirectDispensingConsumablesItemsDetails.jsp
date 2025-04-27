<!DOCTYPE html>

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.text.DecimalFormat,eST.*,eST.Common.*, eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<html>
	<head>
<% 
		request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 ends
			
			String locale			= (String)session.getAttribute("LOCALE");
			String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
			String params			= request.getQueryString() ;
			String patient_id       = request.getParameter("patient_id");
			String encounter_id     = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
			String bl_patient_class = request.getParameter("bl_patient_class");		
			String disp_locn_code   = request.getParameter("disp_locn_code");
			String bl_install_yn    = request.getParameter("billing_interface_yn")==null?"N":request.getParameter("billing_interface_yn");
			String sysdate           = request.getParameter("sysdate");
			 String classValue            = "SELECTEDRUGS";
		   String	disp_bean_id			   =	"DirectDispensingBean" ;
	       String	disp_bean_name			   =	"ePH.DirectDispensingBean";
	       DirectDispensingBean disp_bean  = (DirectDispensingBean)getBeanObject( disp_bean_id, disp_bean_name, request);

           int count   =0;
           HashMap cons_item_dtl        =  new HashMap();
		   ArrayList tot_cons_item_dtl  = (ArrayList)disp_bean.getConsumableDetails();

		   String ord_qty               =  "";
		   String batch_id              =  "";
		   String exp_date              =  "";
		   String trade_name            =  "";
		   String avail_qty             =  "";
		   String trade_code            =  "";
		   String bin_loc_code          =  "";
		   String gross_charge_amount   =  "";
		   String gross_amount   =  "";  // Added for ML-BRU-CRF-0469 [IN:065426]
		   String groos_pat_payable     =  "";
		   String error_msg             =  "";
		   String alloc_qty             =  "";
		   String selected_yn			=  "";
		   String chkbox_checked        =  "";
		   String chkbox_disabled       =  "";
		   String from_order_yn         =  "Y";
		   String all_disable           ="";
           HashMap batch_det            =  new HashMap();
           HashMap billing_det          =  new HashMap();
	       boolean grossAmountDispYN    =  disp_bean.isSiteSpecific("PH", "GROSS_AMT_DISPLY_YN"); // Added for ML-BRU-CRF-0469 [IN:065426]
	
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
		<script language="JavaScript" SRC="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../ePH/js/DirectDispensingConsumables.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="frm_consumableItemDatail" id="frm_consumableItemDatail">
			<table border="1" width="100%" cellspacing="0" cellpadding="0">	

                <input type="hidden" name="bean_id" id="bean_id"          value="<%=disp_bean_id%>">
				<input type="hidden" name="bean_name" id="bean_name"        value="<%=disp_bean_name%>">
                <input type="hidden" name="bl_install_yn" id="bl_install_yn"    value="<%=bl_install_yn%>">
				<input type="hidden" name="patient_id" id="patient_id"       value="<%=patient_id%>">
				<input type="hidden" name="encounter_id" id="encounter_id"     value="<%=encounter_id%>">
				<input type="hidden" name="sal_trn_type" id="sal_trn_type"     value="<%=bl_patient_class%>">
				<input type="hidden" name="sysdate" id="sysdate"          value="<%=sysdate%>">
				<input type="hidden" name="disp_locn_code" id="disp_locn_code"   value="<%=disp_locn_code%>">
				<input type="hidden" name="tot_cons_gross_charge_amount" id="tot_cons_gross_charge_amount"   value="">
				<input type="hidden" name="tot_cons_groos_pat_payable" id="tot_cons_groos_pat_payable"     value="">
				<input type="hidden" name="tot_cons_groos_pat_payable" id="tot_cons_groos_pat_payable"     value="">
				<input type="hidden" name="tot_groos_amt" id="tot_groos_amt"     value=""> <!-- Added for ML-BRU-CRF-0469 [IN:065426]  -->
				<input type="hidden" name="grossAmountDispYN" id="grossAmountDispYN"     value="<%=grossAmountDispYN%>"> <!-- Added for ML-BRU-CRF-0469 [IN:065426]  -->
			
				

			    <tr nowrap>
                <td class="COLUMNHEADER" style="font-size:9" width="4%"></td>
				<td class="COLUMNHEADER" style="font-size:9" width="30%"><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
				<td class="COLUMNHEADER" style="font-size:9" width="6%"><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
				<td class="COLUMNHEADER" style="font-size:9" width="6%"><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></td>				
				<td class="COLUMNHEADER" style="font-size:9" width="10%"><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
				<td class="COLUMNHEADER" style="font-size:9" width="16%"><fmt:message key="Common.Trade.label" bundle="${common_labels}"/></td>
				<td class="COLUMNHEADER" style="font-size:9" width="6%"><fmt:message key="eST.AvailableQty.label" bundle="${st_labels}"/></td>
				<td class="COLUMNHEADER" style="font-size:9" width="6%"><fmt:message key="ePH.AllocatedQuantity.label" bundle="${ph_labels}"/></td>
  <% if(bl_install_yn.equals("Y") ){
         if(grossAmountDispYN){ // Added for ML-BRU-CRF-0469 [IN:065426] - Start
  %>	
                    <td class= "COLUMNHEADER" width="7%" style="font-size:9"><fmt:message key="ePH.GrossAmount.label" bundle="${ph_labels}"/></td>
 <%      } %>
					<td class= "COLUMNHEADER" width="11%" style="font-size:9"><fmt:message key="Common.ChargeAmount.label" bundle="${common_labels}"/></td>
					<td class= "COLUMNHEADER" width="11%" style="font-size:9"><fmt:message key="ePH.PayableAmount.label" bundle="${ph_labels}"/></td>
  <%}  // Added for ML-BRU-CRF-0469 [IN:065426] -End %>
               </tr>
   <%         
               for(int i=0;i<tot_cons_item_dtl.size();i++){
                  cons_item_dtl  = (HashMap)tot_cons_item_dtl.get(i);

                  from_order_yn = (String)( cons_item_dtl.get("FROM_ORDER_YN")==null?"Y":cons_item_dtl.get("FROM_ORDER_YN"));
				  if(cons_item_dtl.containsKey("ALLOC_QTY")){
                      alloc_qty = (String) cons_item_dtl.get("ALLOC_QTY"); 

				  }	
				  if(cons_item_dtl.containsKey("SELECTED_YN")){
                      selected_yn = (String) cons_item_dtl.get("SELECTED_YN");
					  if(selected_yn.equals("Y")){
                          chkbox_checked  ="checked";
					  }else{
                          chkbox_checked  ="";
					  }

				  }	
				  
				  if(cons_item_dtl.containsKey("BATCH_DET")){                       
					    batch_det             =  (HashMap)cons_item_dtl.get("BATCH_DET");
					    batch_id              =  (String) batch_det.get("BATCH_ID");  
						exp_date              =  (String) batch_det.get("EXPIRY_DATE"); 
						trade_name            =  (String)batch_det.get("TRADE_DESC");
						avail_qty             =  (String)batch_det.get("AVAIL_QTY");  
						trade_code            =  (String)batch_det.get("TRADE_ID");  
						bin_loc_code          =  (String)batch_det.get("BIN_LOCN_CODE");  
				  }

//
               if(cons_item_dtl.containsKey("BILLING_DET")){   
				   

					    billing_det           =  (HashMap)cons_item_dtl.get("BILLING_DET");

					    gross_charge_amount   =  (String) billing_det.get("GROSS_CHARGE_AMOUNT");  
						groos_pat_payable     =  (String) billing_det.get("GROOS_PAT_PAYABLE"); 
						gross_amount          =  (String) billing_det.get("GROSS_CHARGE_AMOUNT_PAYABLE");  // Added for ML-BRU-CRF-0469 [IN:065426]
						error_msg             =  (String) billing_det.get("ERROR_MSG");
						if(!error_msg.equals("")){
							chkbox_disabled ="disabled";
						}

				  }
              


  %>
               <tr >

                 <td class='<%=classValue%>'  width="4%" >&nbsp;<input type="checkbox" name="select_<%=count%>" id="select_<%=count%>"  value="<%=selected_yn%>"  onclick="setvalue('<%=count%>')" <%=chkbox_checked%>  <%=chkbox_disabled%>>&nbsp;</td>

                 <td class='<%=classValue%>' style="font-size:9" width="30%" id='td_item_desc_<%=count%>'>&nbsp;&nbsp;<%=(String)cons_item_dtl.get("LONG_DESC")%></td>
	<% //ord_qty = (String)cons_item_dtl.get("ORDER_QTY");


	  if(!alloc_qty.equals("")){%>
				 <td class='<%=classValue%>' style="font-size:9" width="6%" id='td_ord_qty_<%=count%>'>&nbsp;&nbsp;<%=alloc_qty%>&nbsp;<b><%=(String)cons_item_dtl.get("ORDER_UOM")%></b></td>
	<%}else{%>	
	            <td class='<%=classValue%>' style="font-size:9" width="6%" id='td_ord_qty_<%=count%>'>&nbsp;&nbsp;</b></td>
	
	<%}%>
				 <td class='<%=classValue%>' style="font-size:9" width="6%" id='td_batch_id<%=count%>'>				 
				 <INPUT TYPE="text"  name="batch_id_<%=count%>" id="batch_id_<%=count%>"   size="10"  value='<%=batch_id%>' <%=all_disable%> onblur="clearvalues('<%=count%>');">&nbsp;<input type="button" class="button" name="dflt_item_search_<%= count %>" id="dflt_item_search_<%= count %>" value="?" <%=all_disable%> onclick="assignval('<%=(String)cons_item_dtl.get("ORDER_CATALOG_CODE")%>','<%= disp_locn_code %>','<%= count %>');"></td>				 
				 <td class='<%=classValue%>' style="font-size:9" width="10%" id='td_exp_date_<%=count%>'>&nbsp;<%=com.ehis.util.DateUtils.convertDate(exp_date,"DMY","en",locale)%></td>
				 <td class='<%=classValue%>' style="font-size:9" width="20%" id='td_trade_name_<%=count%>'>&nbsp;<%=trade_name%></td>
				 <td class='<%=classValue%>' style="font-size:9" width="6%" id='td_avail_qty_<%=count%>'>&nbsp;<%=avail_qty%></td>
				<% if(!batch_id.equals("")){%>
				 <td class='<%=classValue%>' style="font-size:9" width="6%" id='td_alloc_qty_<%=count%>'><INPUT TYPE="text"  class="flat" name="alloc_qty_<%=count%>" id="alloc_qty_<%=count%>"  <%=all_disable%> style="text-align:right"size="8" maxlength="5" value='<%=alloc_qty%>' onKeyPress="return allowValidNumber(this,event,6,0);" onblur="getConsumableBillingDetails('<%=count%>');" ></td>
			<%	 }else{%>
 <td class='<%=classValue%>' style="font-size:9" width="6%" id='td_alloc_qty_<%=count%>'><INPUT TYPE="text"  class="flat" name="alloc_qty_<%=count%>" id="alloc_qty_<%=count%>"  <%=all_disable%> style="text-align:right"size="8" maxlength="5" value='<%=alloc_qty%>' onKeyPress="return allowValidNumber(this,event,6,0);" onblur="getConsumableBillingDetails('<%=count%>');" disabled></td>


				<% }%>
     <% if(bl_install_yn.equals("Y") ){
		     if(error_msg.equals("")){
		    	 if(grossAmountDispYN){ // Added for ML-BRU-CRF-0469 [IN:065426] - Start
	%>	
	                  <td class='<%=classValue%>' style="font-size:9" width="7%" id='td_gross_amt_<%=count%>'><label style='font-size:9;color:black'>&nbsp;&nbsp;<%=gross_amount%></label></td>
	            <%} // Added for ML-BRU-CRF-0469 [IN:065426] - End %>
				      <td class='<%=classValue%>' style="font-size:9" width="11%" id='td_gross_charge_amt_<%=count%>'><label style='font-size:9;color:black'>&nbsp;&nbsp;<%=gross_charge_amount%></label></td>
					  <td class='<%=classValue%>' style="font-size:9" width="11%" id='td_pat_payable_amt_<%=count%>'><label style='font-size:9;color:black'>&nbsp;&nbsp;<%=groos_pat_payable%></label></td>
				  
     <%       }else{
    	        if(grossAmountDispYN){ // Added for ML-BRU-CRF-0469 [IN:065426] - Start
     %>
                       <td class='<%=classValue%>' style="font-size:9" width="7%" id='td_gross_amt_<%=count%>'><label style='font-size:11;color:red'  title='<%=error_msg%>'>&nbsp;&nbsp;<fmt:message key="Common.Error.label" bundle="${common_labels}"/></label></td>
     <%} // Added for ML-BRU-CRF-0469 [IN:065426] - End %>
                      <td class='<%=classValue%>' style="font-size:9" width="11%" id='td_gross_charge_amt_<%=count%>'><label style='font-size:11;color:red'  title='<%=error_msg%>'>&nbsp;&nbsp;<fmt:message key="Common.Error.label" bundle="${common_labels}"/></label></td>
					  <td class='<%=classValue%>' style="font-size:9" width="11%" id='td_pat_payable_amt_<%=count%>'><label style='font-size:11;color:red'  title='<%=error_msg%>'>&nbsp;&nbsp;<fmt:message key="Common.Error.label" bundle="${common_labels}"/></label></label></td>

	 <%       }
	     }
	 %>
			   </tr>  
                <input type="hidden" name="item_code_<%=count%>" id="item_code_<%=count%>"     value="<%=(String)cons_item_dtl.get("ORDER_CATALOG_CODE")%>">
			    <input type="hidden" name="trade_id_<%=count%>" id="trade_id_<%=count%>"     value="<%=trade_code%>">
				<input type="hidden" name="exp_date_<%=count%>" id="exp_date_<%=count%>"     value="<%=exp_date%>">
				<input type="hidden" name="bin_loc_code_<%=count%>" id="bin_loc_code_<%=count%>" value="<%=bin_loc_code%>">
				<input type="hidden" name="gross_charge_amount_<%=count%>" id="gross_charge_amount_<%=count%>" value="<%=gross_charge_amount%>">
				<input type="hidden" name="groos_pat_payable_<%=count%>" id="groos_pat_payable_<%=count%>"   value="<%=groos_pat_payable%>">
				<input type="hidden" name="gross_amt_<%=count%>" id="gross_amt_<%=count%>"   value="<%=gross_amount%>"> <!-- Added for ML-BRU-CRF-0469 [IN:065426] -->
				<input type="hidden" name="hdn_ord_qty_<%=count%>" id="hdn_ord_qty_<%=count%>"   value="<%=ord_qty%>">
				<input type="hidden" name="hdn_ord_uom_<%=count%>" id="hdn_ord_uom_<%=count%>"   value="<%=(String)cons_item_dtl.get("ORDER_UOM")%>">
			    
				
             
						
  <%		
	         if(from_order_yn.equals("N")&& bl_install_yn.equals("Y")){
   %>  
              <script>
                 getConsumableBillingDetails('<%=count%>');
              </script> 
   <%          }
  
  
            count++; 
            batch_det             =  new HashMap();
			billing_det           =  new HashMap();
			batch_id              =  ""; 
			exp_date              =  ""; 
			trade_name            =  ""; 
			avail_qty             =  ""; 
			trade_code            =  ""; 
			bin_loc_code          =  ""; 
            gross_charge_amount   =  "";   
			groos_pat_payable     =  "";   
			gross_amount          =  "";  // Added for ML-BRU-CRF-0469 [IN:065426]
			error_msg             =  "";
			alloc_qty             =  "";
			selected_yn			  =  "";
			chkbox_disabled       =  "";
			chkbox_checked        =  "";




          }

 %> 
               
				<input type="hidden" name="count" id="count"            value="<%=count%>">

			</table>
		</form>
	</body>
</html> 
<%
 		

	
%>

