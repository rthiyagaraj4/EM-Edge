<!DOCTYPE html>
 <%
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name       	Rev.Date   		Rev.By    	Description
--------------------------------------------------------------------------------------------------------------
06/02/2017		IN0063027			Badmavathi B							GHL-CRF-0413.7 - US009 - Barcode search
24/07/2018		66199				Shazana Hasan							GHL-CRF- 0499 - Added Challan_No in Batch Search
16/11/2018		69074				Shazana Hasan							GHL-ICN-0032
---------------------------------------------------------------------------------------------------------------
*/
%>
 <%@page contentType="text/html;charset=UTF-8"  import=" eST.CondemnExpiredBatchesHeaderBean,java.util.ArrayList,java.util.HashMap,java.sql.*,webbeans.eCommon.*,eCommon.Common.*,java.lang.*,java.text.NumberFormat,java.text.DecimalFormat"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eST/js/CondemnExpiredBatches.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
		<%
			String bean_id = "condemnExpiredBatchesHeaderBean";
			String bean_name = "eST.CondemnExpiredBatchesHeaderBean";					
			//String mode = eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT");
             String mode  =  (String)request.getParameter("mode");
			if(mode==null) {
				mode = "1";
			}			
			String site    =  (String)request.getParameter("site");// Added for GHL-CRF-0413.7
			String function_id = request.getParameter("function_id");		
			String classvalue="";
			CondemnExpiredBatchesHeaderBean bean = (CondemnExpiredBatchesHeaderBean)getBeanObject( bean_id,bean_name,request);  			
			bean.setLanguageId(locale);
			HashMap  hmExpiry = new HashMap();
			//Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 04-MAR-2013			
			String disposable_yn = bean.checkForNull(request.getParameter("disposable_yn"),"N");
            if(disposable_yn.equals("Y")){			
			String from_date   =  (String)request.getParameter("default_Expdate_condmn");
			String to_date     =  (String)request.getParameter("default_Expdate_condmn");
			//from_date          =   com.ehis.util.DateUtils.convertDate(from_date,"DMY","en",locale);
			//to_date            =    com.ehis.util.DateUtils.convertDate(to_date,"DMY","en",locale);
			String from_store  =  (String)request.getParameter("store_code");
			String to_store    =  (String)request.getParameter("store_code");
		//	String batch_id    =  (String)request.getParameter("batch_id");
		    
		
			HashMap hmParam = new HashMap();
			hmParam.put("from_date",from_date);
			hmParam.put("to_date",to_date);
			hmParam.put("from_item","");
			hmParam.put("to_item","");
			hmParam.put("from_store",from_store);
			hmParam.put("to_store",to_store);
			hmParam.put("batch_id","");
			 
			bean.loadExpired_batches(hmParam);
			} 
			//ends
			ArrayList alExpiredBatches = bean.getExpired_batches();	
			int i = 0,recCount =2;
			int no_of_decimals =0;
			
			//Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013 Starts
			String date_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels");
			String expiry_yn  =  bean.checkForNull((String)request.getParameter("condemn_type"),"Y");
			//Added by Rabbani Inc no : 45612 on 13-12-2013
			    if(mode.equals("2")){  
			           hmExpiry   = (HashMap)alExpiredBatches.get(0);
			          expiry_yn = (String)hmExpiry.get("expiry_yn");
				}
			   if(expiry_yn.equals("N")) {
				date_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.receiptdate.label","common_labels");
			    }
			   //ADDED FOR GHL-CRF-0499 START
			   Connection con				= null;
				con						= ConnectionManager.getConnection(request);
				boolean site_main = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_DISPLAY_CHALLAN_NO");
				bean.setSite_spec_yn(site_main);
			//ends
			
		%>
	<body onScroll="processScroll()" onLoad="processCheckBox(formCondemnExpiredBatchesList);" >	<!-- Added for GHL-CRF-0413.7 -->
		<form name='formCondemnExpiredBatchesList' id='formCondemnExpiredBatchesList'>
		
		<div id="divHeadSep" style="position: relative;overflow:auto; width:99vw; height:230px;float:left;"> 
		<div name='msg' id='msg' style="position:absolute;height:136; width:100%;display:none;"></div> 
		<table  border='1' cellpadding='0' cellspacing='0' width='100%' >
	<!--	
	* @Name - Priya
	* @Date - 19/02/2010
	* @Inc# - IN019466
	* @Desc - To align the headers in center . 					
	-->
				<tr  id="heading">
					<th ><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;<input type="checkbox" value="Y" name="checkAll" id="checkAll" checked onClick="return toggleCheck(formCondemnExpiredBatchesList);"></th>
					<td class='COLUMNHEADER' width='20%' style="TEXT-ALIGN:center"><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
					<%if(mode.equals("1")){ %>
					<td class='COLUMNHEADER'  class='label' width='12%' style="TEXT-ALIGN:center"><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
					<!--<td class='COLUMNHEADER'  class='label' width='10%' style="TEXT-ALIGN:center"><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td> -->
					 <td class='COLUMNHEADER'  class='label' width='10%' style="TEXT-ALIGN:center"><%=date_legend%></td>  
					<td class='COLUMNHEADER'  class='label' width='12%' style="TEXT-ALIGN:center"><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></td>
					
					<!-- Added against GHL-CRF- 0499 START-->
					<% if(site_main){ %>
					<td class='COLUMNHEADER'  class='label' width='12%' style="TEXT-ALIGN:center"><fmt:message key="eST.ChallanNo.label" bundle="${common_labels}"/></td>
					<% } %>
				<!-- Added against GHL-CRF- 0499 END-->
					<td class='COLUMNHEADER'  class='label' width='13%' style="TEXT-ALIGN:center"><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADER'  class='label' width='13%' style="TEXT-ALIGN:center"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADER'  class='label' width='12%' style="TEXT-ALIGN:center"><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADER' class='label'  width='10%' style="TEXT-ALIGN:center"><fmt:message key="eST.QuantityOnHand.label" bundle="${st_labels}"/></td>
					<%}else{%>
					<td class='COLUMNHEADER'  class='label' width='12%' style="TEXT-ALIGN:center"><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
					 <td class='COLUMNHEADER'  class='label'   style="TEXT-ALIGN:center"><%=date_legend%></td>  
					<td class='COLUMNHEADER'  class='label'  style="TEXT-ALIGN:center"><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></td>
					
					<!-- Added against GHL-CRF- 0499 START-->
					<% if(site_main){ %>
					<td class='COLUMNHEADER'  class='label' width='12%' style="TEXT-ALIGN:center"><fmt:message key="eST.ChallanNo.label" bundle="${common_labels}"/></td>
					<% } %>
					<!-- Added against GHL-CRF- 0499 END-->
					<td class='COLUMNHEADER'  class='label'  style="TEXT-ALIGN:center"><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADER'  class='label' width='13%' style="TEXT-ALIGN:center"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADER'  class='label'   style="TEXT-ALIGN:center"><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADER' class='label'     style="TEXT-ALIGN:center">Proposed Condemn Qty</td>
					<td class='COLUMNHEADER' class='label'    style="TEXT-ALIGN:center">Avail. for Condemn</td>
					<%} %>
				</tr>	
				
				
		<%
		try{
			String strCd="";//added for GHL-ICN-0032
			int noOfExpiredBatches = alExpiredBatches.size();	
			if(noOfExpiredBatches > 0 )
			{
			HashMap hmExpiredBatch = new HashMap();	
			String challanNo = "";//Added for GHL-CRF-0499 
			for (i = 0;i< noOfExpiredBatches;i++,recCount++) {
				hmExpiredBatch = (HashMap)alExpiredBatches.get(i);							
				classvalue = (recCount % 2 == 0)?"QRYEVEN":"QRYODD";
				
				String key = (String)hmExpiredBatch.get("item_code")+"||"+
				(String)hmExpiredBatch.get("store_code")+"||"+
				(String)hmExpiredBatch.get("batch_id")+"||"+
				(String)hmExpiredBatch.get("bin_location_code")+"||"+
				(String)hmExpiredBatch.get("expiry_date")+"||"+				
				(String)hmExpiredBatch.get("trade_id")+"||"+	
				//(String)hmExpiredBatch.get("qty_on_hand")+"||"+
				(String)hmExpiredBatch.get("avail_qty")+"||"+
				(String)hmExpiredBatch.get("replace_on_expiry_yn");
				
			    String expiry_date=(String)(hmExpiredBatch.get("expiry_date"));
			    String item_code=(String)hmExpiredBatch.get("item_code");
			    //added for GHL-CRF-0499
			    String batch_id=(String)hmExpiredBatch.get("batch_id");
			    		//ADDED FOR ghl-icn-0032
			    strCd = (String)hmExpiredBatch.get("store_code");
			/**
			* @Name - Suri
			* @Date - 19/01/2010
			* @Inc# - IN015496
			* @Desc - Code added to accept decimal values dynamically.
			* @ getAllowDecimalsYN() return's 'Y' that accept decimal values dynamically.other wise it should not accept decimal values dynamically. 
			*/
			 
			 if((bean.getAllowDecimalsYN(item_code)).equals("Y"))
					no_of_decimals=bean.getNoOfDecimals();
				else
					no_of_decimals=0;
				if(!locale.equals("en"))
				{
                 expiry_date=com.ehis.util.DateUtils.convertDate(expiry_date, "DMY" , "en",locale);
				}
				else
				{
				expiry_date=expiry_date;
				}
				
				// Added 
				HashMap hmRecord	=	null;
				String spcfn_img_display;
				hmRecord = bean.getItemSpecfnRemarks(bean.checkForNull(item_code),bean.getLanguageId());
				String item_specfin_name = CommonBean.checkForNull((String)hmRecord.get("ITEM_SPECIFICATION"),"");
				String item_remarks = CommonBean.checkForNull((String)hmRecord.get("ITEM_REMARKS"),"");
				spcfn_img_display="display:inline";
				if(item_specfin_name.equals("") && item_remarks.equals("")) {
					spcfn_img_display="display:none";
				}

				if(!item_specfin_name.equals("")){
					item_specfin_name = item_specfin_name.replaceAll(" ","%20");
					item_specfin_name = java.net.URLEncoder.encode(item_specfin_name,"UTF-8");
					item_specfin_name = item_specfin_name.replaceAll("%2520","%20");
				}
				if(!item_remarks.equals("")){
					item_remarks = item_remarks.replaceAll(" ","%20");
					item_remarks = java.net.URLEncoder.encode(item_remarks,"UTF-8");
					item_remarks = item_remarks.replaceAll("%2520","%20");
				}			
				// End
				//Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013 Starts
				String item_desc	=	CommonBean.checkForNull((String)hmExpiredBatch.get("item_desc"));
				if(!item_desc.equals("")){
					item_desc = item_desc.replaceAll(" ","%20");
					item_desc = java.net.URLEncoder.encode(item_desc,"UTF-8");
					item_desc = item_desc.replaceAll("%2520","%20");
				}
				//ends
		%>
			<tr id="tr_<%=i%>"><!-- Added id for GHL-CRF-0413.7 -->
				<td   class="<%=classvalue%>" >&nbsp;&nbsp;&nbsp;&nbsp;
					<input type='checkbox' name="remove_<%=i%>" id="remove_<%=i%>" value="<%=key%>" checked  onClick="changestatus(<%=i%>,this)";>
				</td>
				
				<td   class="<%=classvalue%>" >
					<%=java.net.URLDecoder.decode(item_desc,"UTF-8")%> &nbsp;<a style='<%=spcfn_img_display%>;'href="javascript:callItemSpcfnWindow('<%=bean.checkForNull(item_code)%>','<%=(String)hmExpiredBatch.get("item_desc")%>');"><img onmouseover="onMOver(msg,event,'<%=item_specfin_name%>','<%=item_remarks%>','<%=item_desc%>');"   onMouseout="onMOut(msg);"  src='../../eST/images/info.gif' alt="Item Remarks/Specification"  ></img></a>
				</td>

				<td    class="<%=classvalue%>" >
					<%=(String)hmExpiredBatch.get("store_desc")%>
				</td>
				
				<td    class="<%=classvalue%>" >
				          <%=expiry_date%>
				</td>
				
				<td   class="<%=classvalue%>"  >
					<%=(String)hmExpiredBatch.get("batch_id")%>
				</td>
				<!-- Added against GHL-CRF- 0499 START-->
				<% if( site_main ){
					challanNo = bean.getChallanNo(item_code, batch_id, expiry_date,strCd);//modified for GHL-ICN-0032
					
				%>				
				<td   class="<%=classvalue%>"  >
					<%=CommonBean.checkForNull(challanNo,"&nbsp;")%>
				</td>
				
				<% } %>
				<!-- Added against GHL-CRF- 0499 END-->
				
				<td  class="<%=classvalue%>" > 
					<%=(String)hmExpiredBatch.get("trade_name")%>
				</td>
				<td  class="<%=classvalue%>">&nbsp;&nbsp;<textarea style="resize:none;" name="remarks_desc_<%=i%>" rows="2" cols="15"   onKeyPress="return false;""><%=bean.checkForNull((String)hmExpiredBatch.get("remarks_desc"))%></textarea><input class="button" onClick='return searchRemarksCode(trn_remarks_code_<%=i%>,remarks_desc_<%=i%>);'  type="button" value="?">
				<input type="hidden" name="trn_remarks_code_<%=i%>" id="trn_remarks_code_<%=i%>" value="<%=bean.checkForNull((String)hmExpiredBatch.get("remarks"))%>">
				</td>
				<td class="<%=classvalue%>" >
					<%=(String)hmExpiredBatch.get("bin_desc")%>
				</td>
				<!-- 					
						* @Name - Priya
						* @Date - 19/02/2010
						* @Inc# - IN019466
						* @Desc - To right align QuantityOnHand.				
					-->
				<td class="<%=classvalue%>"  style="TEXT-ALIGN:right">
				   <%=bean.setNumber((bean.checkForNull((String)hmExpiredBatch.get("qty_on_hand"),"0")),no_of_decimals)%> 
				   &nbsp;
				</td> 
				<input type="hidden" name="propsed_qty_<%=i%>" id="propsed_qty_<%=i%>" value="<%=(String)hmExpiredBatch.get("qty_on_hand")%>">
				<%if(mode.equals("2")){ %>
				<td class="<%=classvalue%>"  style="TEXT-ALIGN:right">
				<%=bean.setNumber((bean.checkForNull((String)hmExpiredBatch.get("avail_qty"),"0")),no_of_decimals)%>  &nbsp;
				</td>
				<%} %> 
			</tr>			
		<%		
			}  
			}
			else
			{
			%>
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				document.location.href="../../eCommon/html/blank.html";
			</script>
		<%
		}
		%>		
			</table>	
		</div>	
			<input type="hidden" name="total_checkboxes" id="total_checkboxes" value="<%=i%>">
			<input type="hidden" name="mode" id="mode" value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name %>">
			<input type="hidden" name="function_id" id="function_id" value="<%=function_id%>">
			<input type="hidden" name="totalRecords" id="totalRecords" value="<%=noOfExpiredBatches%>">
			<input type="hidden" name="language_id" id="language_id" value="<%=locale%>">
			<!--Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 01-MAR-2013	-->	
			<input type="hidden" name="disposable_yn" id="disposable_yn" value="<%=disposable_yn%>">
			<input type="hidden" name="finalized" id="finalized" value="Y">
			<input type="hidden" name="site" id="site" value="<%=site%>"><!-- Added for GHL-CRF-0413.7 -->
		</form>
		<%
		}//ADDED FOR GHL-CRF-0499 STARTS
		catch(Exception e) {
			out.print("Exception @ Result JSP :"+e.toString());
		}
	finally{
			if(con != null)
				ConnectionManager.returnConnection(con,request);
		}//ENDS
%>
<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

