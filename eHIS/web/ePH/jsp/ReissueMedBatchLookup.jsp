<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*,eST.*,eST.Common.*, eCommon.Common.*, java.text.DecimalFormat,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
	<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
<%
		request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for MMS-ME-SCF-0097 Starts 
	request= new XSSRequestWrapper(request); 
	response.addHeader("X-XSS-Protection", "1; mode=block"); 
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//Added by Himanshu for MMS-ME-SCF-0097 ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/ReissueMed.js"></script>
		<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/PhCommon.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>
	<!-- <body onload="shiftFocus()">  -->
	<body onload="shiftFocus()" onMouseDown="" onKeyDown="lockKey()">
<%
		String drug_code			=	"";
		String item_code			=	request.getParameter("item_code");
		String store_code			=	request.getParameter("store_code");
		String item_name 			=   request.getParameter("reissue_drug_name"); // added for ML-BRU-SCF-1073 by Ganga 		
%>
		<form name="ReissueMedBatchLookup" id="ReissueMedBatchLookup">
<%
			try{
				String recno				=	request.getParameter("no");
				String qty					=	request.getParameter("qty");
				String uom					=	request.getParameter("qty_uom");
				String disp_uom				=	request.getParameter("disp_uom");
				String Disp_facility_id			=   request.getParameter("Disp_facility_id");

				String decimalStringFormat = "#.####";
				DecimalFormat dfToInteger = new DecimalFormat(decimalStringFormat);

				String bean_id		= "ReissueMedBean" ;
				String bean_name	    = "ePH.ReissueMedBean";
				ReissueMedBean beanObj	= (ReissueMedBean)getBeanObject(bean_id,bean_name,request);
				String uom_code				= ""; //Added for HSA-SCF-0221

				if(!(request.getParameter("calledfrom").equals("modelwin"))){
					drug_code					=	request.getParameter("drug_code");
					String patient_id			=	request.getParameter("patient_id");
					String order_id				=	request.getParameter("order_id");
					String order_line_no		=	request.getParameter("order_line_no");
					String end_date				=	request.getParameter("end_date");
					String patient_class		=   request.getParameter("patient_class");
					String fill_period			=   request.getParameter("fill_period");
					String fill_unit			=   request.getParameter("fill_unit");
					String source				= "";
					String drug_strength		= "";
					String bms_strength			= "";
					String bms_qty				= "";
					String alt_drug_strength	= "";
					String called_from			= "";
					String drug_color			= "";
					String alt_drug_code		= "";
					String class_name			= "";
					String batch_id				= "";
					String expiry_date			= "";
					String issue_qty			= "";
					String item_drug_code		= "";
					String trade_name			= "";
					String manufacturer_name	= "";
					String bin_location			= "";
					String trade_id				= "";
					String bin_locn_code		= "";
					String batch_ids			= request.getParameter("batchId");
					String binLocCode			= request.getParameter("binLocCode");
					String expiryDate			= request.getParameter("expiryDate");
					String issued_qtys			= request.getParameter("issued_qty");
					String disp_locn  = beanObj.getDispLocnCode(); //added for FD-BRU-CRF-092
					HashMap		stock				=	new HashMap();
					ArrayList   for_stock_1			=	new ArrayList();
					ArrayList   for_stock_2			=	new ArrayList();
					ArrayList	stock_detail		=	new ArrayList();
					HashMap		drug_detail			=	new HashMap();

					String	bean_id_2		=	"StUtilities" ;
					String	bean_name_2		=	"eST.Common.StUtilities";
					StUtilities bean_2		=	null;
				//hard coded this function should be checked..
					//String		sys_date			=	"02/02/2004";

					/** Stock Bean Integration -Start ***/
					try { 
						bean_2 = (StUtilities)getBeanObject( bean_id_2,bean_name_2,request );
						bean_2.setLanguageId(locale);
					}
					catch (Exception exception) {
						exception.printStackTrace();
					}

					String	bean_id_3		=	"BatchSearchBean" ;
					String	bean_name_3		=	"eST.BatchSearchBean";

					BatchSearchBean bean_3	= (BatchSearchBean)getBeanObject( bean_id_3,bean_name_3,request);
					bean_3.setLanguageId(locale);
					/** Stock Bean Integration -End ***/ 

					StringTokenizer STbatchids = new StringTokenizer(batch_ids,"~");
					StringTokenizer STexpdate = new StringTokenizer(expiryDate,"~");
					StringTokenizer STlocncode = new StringTokenizer(binLocCode,"~");
					StringTokenizer STissued_qtys = new StringTokenizer(issued_qtys,"~");
					while(STbatchids.hasMoreElements()){
						for_stock_1		=	new ArrayList();
						batch_id		=	STbatchids.nextToken();
						expiry_date		=	STexpdate.nextToken();
						bin_locn_code	=	STlocncode.nextToken();
						for_stock_1.add(batch_id);
						for_stock_1.add(expiry_date);
						for_stock_1.add(bin_locn_code);
						for_stock_2.add(for_stock_1);
					}	

					if(alt_drug_code.equals(""))	{
						item_drug_code	=	drug_code;
					}
					else {
						item_drug_code	=	alt_drug_code;
					}

					String tmp_drug_code		=	item_drug_code;
					String tmp_drug_color		=	drug_color;
					String item_drug_color		=	drug_color;
					String tmp_item_code		=	"";
					String quantity				=	"";
					String select_status		=	"";

					ArrayList stock_items		=	new ArrayList();

					if(alt_drug_code.equals("")) {
						qty		=	new Float(qty).intValue()+"";
					}
					else {
						if(!drug_strength.equals("") && !alt_drug_strength.equals("")) { 
							bms_qty	=	new Float(Float.parseFloat(bms_strength)/	Float.parseFloat(alt_drug_strength)).intValue()+"";
							qty		=	bms_qty;
						} 
					}

					HashMap params			=	new HashMap();
					params.put("ITEM_CODE",item_code);
			//		params.put("STORE_CODE",store_code); commented for FD-BRU-CRF-092
					params.put("STORE_CODE",disp_locn); // added for FD-BRU-CRF-092
					params.put("TRN_QTY",qty);
					params.put("INCLUDE_SUSPENDED","FALSE");
					params.put("INCLUDE_EXPIRED","FALSE");
					params.put("CUT_OFF_DATE",end_date);
					params.put("VERIFY_INSUFFICIENT_QTY","FALSE");

					stock					=	bean_2.getBatches(params);
					stock_detail			=	(ArrayList)stock.get("BATCH_DATA");
					if(stock_detail.size() == 0) // Added for FD-BRU-CRF-092
						{ 
						 %> <script>alert(getMessage("ITEM_NOT_AVAILABLE","PH"));</script><%
						}

					ArrayList st_detail		=	new ArrayList();

					if(called_from.equals("stock") && bean_3.getSelectedList()!=null) {
						st_detail.add(bean_3.getSelectedList());	   
					} 
					else if(for_stock_2.size()!=0) {
						stock				=	bean_2.getBatches(params,for_stock_2);
						st_detail.add((ArrayList)stock.get("BATCH_DATA"));
					} 
					else {
						st_detail.add((ArrayList)stock.get("BATCH_DATA"));
					} 
					HashMap IssueUOMAndBaseUOM		=	(HashMap)beanObj.getStoreDfltIssueUOMAndBaseUOM(store_code,item_code);
					Double base_to_disp_uom_equl    =1.0;
					Double base_to_def_uom_equl	    =1.0;
					if(! IssueUOMAndBaseUOM.get("BASE_UOM").equals(disp_uom)){
						  base_to_disp_uom_equl    =	beanObj.getEqulValue ( item_code, (String)IssueUOMAndBaseUOM.get("BASE_UOM"), disp_uom);
					}
					if(!IssueUOMAndBaseUOM.get("BASE_UOM").equals((String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM"))){
						base_to_def_uom_equl	    =   beanObj.getEqulValue ( item_code, (String)IssueUOMAndBaseUOM.get("BASE_UOM"), (String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM"));
					}
					Double conv_factor              =  ( beanObj.lcm( base_to_disp_uom_equl,base_to_def_uom_equl))/base_to_disp_uom_equl; 
					uom_code = (String)IssueUOMAndBaseUOM.get("BASE_UOM"); //Added for HSA-SCF-0221
%>
				<table width="100%" >
					<tr><td class="white" align=right><input type="button" value="Stock Availability" class="button"  name="stkAvailability" id="stkAvailability" onclick="stockdialog('<%=item_code%>','<%=disp_locn%>','<%=recno%>','<%=qty%>','<%=uom%>','<%=Disp_facility_id%>')"> </td></tr>
				</table> <!-- store code removed and disp_locn added for showing current dispensing location batches --> 
				<table cellpadding="1" cellspacing="1" width="100%" align="center" border="1" id="batchtable" name="batchtable" id="batchtable">
					
					 <!-- added for ML-BRU-SCF-1073 by Ganga -->
					<tr><th colspan="8" align="left"><%=java.net.URLDecoder.decode(item_name,"UTF-8")%></th>	</tr>
					
					<tr>
						<th><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></th>
						<th><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></th>
						<th><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></th>
						<th><fmt:message key="Common.Manufacturer.label" bundle="${common_labels}"/></th>
						<th><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></th>
						<th><fmt:message key="eST.AvailableQty.label" bundle="${st_labels}"/></th>
						<th><fmt:message key="ePH.AllocatedQuantity.label" bundle="${ph_labels}"/></th>
						<th><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
					</tr>
<%	
					double tot_qty	=	0;
					tmp_item_code		=	"";
					double tmp_qty			=	0;
					int rec_no			=	0;

					for(int i=0; i<st_detail.size(); i++)	{
							
						batch_id			=	"";
						expiry_date			=	"";
						issue_qty			=	"";
						trade_id			=	"";
						bin_locn_code		=	"";
						item_drug_code		=	tmp_drug_code;
						item_drug_color		=	tmp_drug_color;
						drug_color			=	item_drug_color;
						if(st_detail.get(i) != null)
							stock_detail		=	(ArrayList) st_detail.get(i);

						for(int j=0; j<stock_detail.size(); j++ ) {
							drug_detail			=	(HashMap)stock_detail.get(j);
							item_drug_code		=	(String)drug_detail.get("ITEM_CODE");	
							expiry_date			=	(String)drug_detail.get("EXPIRY_DATE");	
							batch_id			=	(String)drug_detail.get("BATCH_ID");	
							trade_id			=	(String)drug_detail.get("TRADE_ID");	
							trade_name			=	(String)drug_detail.get("TRADE_NAME");	
							manufacturer_name	=	(String)drug_detail.get("MANUFACTURER_NAME");	
							bin_locn_code		=	(String)drug_detail.get("BIN_LOCATION_CODE");
							bin_location		=	(String)drug_detail.get("BIN_DESC");	
							issue_qty			=	(String)drug_detail.get("AVAIL_QTY");		
							quantity			=	"";
							select_status		=	"";
							tot_qty				+=	Double.parseDouble(issue_qty);

							if(for_stock_2.size()!=0){
								 quantity =STissued_qtys.nextToken();
							}

							if(j%2==0)
								class_name	=	"QRYEVENSMALL"; 
							else
								class_name	=	"QRYODDSMALL";

						// For getting the allocated quantity

							if(quantity.equals("") && !called_from.equals("stock")) {
								if( (Double.parseDouble(qty) < Double.parseDouble(issue_qty))) {
									quantity	=	qty;
								} 
								else  {
									quantity	=	issue_qty;
									tmp_qty		=	Double.parseDouble(qty) - Double.parseDouble(issue_qty);
									qty			=	tmp_qty+"";
								}
							}

							// Check/Uncheck Select checkbox based on quantity value
							if(!quantity.equals(""))
								select_status	=	"checked";
							
							if(stock_items.size() > 1) {
								if(!item_drug_code.equals(tmp_item_code)) {
									tmp_item_code		=	item_drug_code;
%>
									<tr><td colspan="8" align="left" class="CURRTEXT"><font size="1" style="font-weight:bold"><fmt:message key="Common.item.label" bundle="${common_labels}"/> : <%=tmp_item_code%></font></td></tr>
<%	
								}	
							}
%>
							<tr>
								<td align="left" width="10%" class="<%=class_name%>">
									<input type="hidden" name="item_drug_code<%=rec_no%>" id="item_drug_code<%=rec_no%>" value="<%=item_drug_code%>"><input type="hidden" name="item_drug_color<%=rec_no%>" id="item_drug_color<%=rec_no%>" value="<%=item_drug_color%>">&nbsp;<%=com.ehis.util.DateUtils.convertDate(expiry_date,"DMY","en",locale)%><input type="hidden" name="expiry_date<%=rec_no%>" id="expiry_date<%=rec_no%>" value="<%=expiry_date%>">
								</td>
								<td align="left" width="10%" class="<%=class_name%>">&nbsp;<%=batch_id%><input type="hidden" name="batch_id<%=rec_no%>" id="batch_id<%=rec_no%>" value="<%=batch_id%>"></td>
								<td align="left" width="20%" class="<%=class_name%>">&nbsp;<%=trade_name%><input type="hidden" name="trade_id<%=rec_no%>" id="trade_id<%=rec_no%>" value="<%=trade_id%>"></td>
								<td align="left" width="20%" class="<%=class_name%>">&nbsp;<%=manufacturer_name%></td>
								<td align="left" width="15%" class="<%=class_name%>">&nbsp;<%=bin_location%><input type="hidden" name="bin_locn_code<%=rec_no%>" id="bin_locn_code<%=rec_no%>" value="<%=bin_locn_code%>"></td>
							  
								<td align="left" width="12%" class="<%=class_name%>">&nbsp;<%=dfToInteger.format(Double.parseDouble(issue_qty))%><input type="hidden" name="alloc_qty<%=rec_no%>" id="alloc_qty<%=rec_no%>" value="<%=issue_qty%>"></td>
<%	
								if(patient_class == "IP") {
									int per_day			=0;
									if(per_day < 1)  
										per_day	=	1;
									if(fill_unit.equals("H") && !fill_period.equals("")) {
										quantity	=	new Float((Math.floor(Integer.parseInt(fill_period) / 24 )* per_day)).intValue()+"";
									} 
									else if(fill_unit.equals("D")) {
										quantity	=	(Integer.parseInt(fill_period) * per_day)+"";
									}
								} 
								quantity =(new Double(Double.parseDouble(quantity)).intValue())+"";
%>
								<td align="left" width="8%" class="<%=class_name%>">
								<input type="text" class="flat" size="8" value="<%=quantity%>" id="issue_qty<%=rec_no%>" name="issue_qty<%=rec_no%>" style="text-align:right" onKeyPress="return allowValidNumber(this,event,6,0);" onBlur="checkstock(this,'<%=issue_qty%>','<%=conv_factor%>');" maxlength="5">
								<input type="hidden" value="<%=quantity%>" name="Hissue_qty<%=rec_no%>">
								<input type="hidden" name="issue_uom<%=rec_no%>" id="issue_uom<%=rec_no%>" value="<%=uom_code%>">
								</td>
								<td align="center" width="5%" class="<%=class_name%>"><input type="checkbox"  name="select<%=rec_no%>" id="select<%=rec_no%>" <%=select_status%> onClick="validateCheck(this,'<%=rec_no%>')"></td>
							</tr>
<%	
							rec_no++;
						}	
					}	
%>
				</table>
				<input type="hidden" name="bean_id" id="bean_id" value="<%=""%>">
				<input type="hidden" name="bean_name" id="bean_name" value="<%=""%>">
				<input type="hidden" name="drug_code" id="drug_code" value="<%=drug_code%>"> 
				<input type="hidden" name="totalRecords" id="totalRecords" value="<%=rec_no%>"> 
				<input type="hidden" name="alt_drug_code" id="alt_drug_code" value="<%=alt_drug_code%>"> 
				<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>"> 
				<input type="hidden" name="order_id" id="order_id" value="<%=order_id%>"> 
				<input type="hidden" name="uom" id="uom" value="<%=uom%>">
				<input type="hidden" name="bms_qty" id="bms_qty" value="<%=bms_qty%>">
				<input type="hidden" name="order_line_no" id="order_line_no" value="<%=order_line_no%>">
				<input type="hidden" name="source" id="source" value="<%=source%>">
				<input type="hidden" name="recno" id="recno" value="<%=recno%>">
				<input type="hidden" name="tot_qty" id="tot_qty" value="<%=tot_qty%>">
				<input type="hidden" name="item_cost" id="item_cost" value="<%=0%>">
				<input type="hidden" name="conv_factor" id="conv_factor" value="<%=conv_factor%>">
				<input type="hidden" name="baseUOM" id="baseUOM" value="<%=uom_code%>"> <!-- //Added for HSA-SCF-0221-->
<%
				// objects nullified after usage
				stock				=	null;
				for_stock_1			=	null;
				for_stock_2			=	null;
				stock_detail		=	null;
				drug_detail			=	null;
				stock_items			=	null;
				params				=	null;
				st_detail			=	null;

				putObjectInBean(bean_id_2,bean_2,request);
				putObjectInBean(bean_id_3,bean_3,request);
			}
			else{
%>
				<table width="100%">
					<tr><td class="white" align=right><input type="button" value="Stock Availability" class="button"  name="stkAvailability" id="stkAvailability" onclick="stockdialog('<%=item_code%>','<%=store_code%>','<%=recno%>','<%=qty%>','<%=uom%>','<%=Disp_facility_id%>')"> </td></tr>
				</table>
				<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1" id="batchtable" name="batchtable" id="batchtable">
					<tr>
						<th><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></th>
						<th><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></th>
						<th><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></th>
						<th><fmt:message key="Common.Manufacturer.label" bundle="${common_labels}"/></th>
						<th><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></th>
						<th><fmt:message key="eST.AvailableQty.label" bundle="${st_labels}"/></th>
						<th><fmt:message key="ePH.AllocatedQuantity.label" bundle="${ph_labels}"/></th>
						<th><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
					</tr>
<%
					HashMap IssueUOMAndBaseUOM		=	(HashMap)beanObj.getStoreDfltIssueUOMAndBaseUOM(store_code,item_code);
					Double base_to_disp_uom_equl    =	beanObj.getEqulValue ( item_code, (String)IssueUOMAndBaseUOM.get("BASE_UOM"), disp_uom);

					Double base_to_def_uom_equl	    =   beanObj.getEqulValue ( item_code, (String)IssueUOMAndBaseUOM.get("BASE_UOM"), (String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM"));
					Double conv_factor              =  ( beanObj.lcm( base_to_disp_uom_equl,base_to_def_uom_equl))/base_to_disp_uom_equl; 
					uom_code = (String)IssueUOMAndBaseUOM.get("BASE_UOM"); //Added for HSA-SCF-0221
					int rec_no =  0;
					String 	batch_id				= "";
					item_code						= "";
					store_code						= "";
					String expiry_date			    = "";
					String bin_locn_code			= "";
					String bin_locn_desc			= "";
					String trade_id					= "";
					String trade_desc				= "";
					String manufacturer_desc	= "";
					String avail_qty		="";
					String class_name = "";
					String retval = request.getParameter("retval");
					StringTokenizer record		= new StringTokenizer (retval,"~");
					while(record.hasMoreElements()){
						ArrayList items = new ArrayList();
						StringTokenizer item = new StringTokenizer(record.nextToken() ,"`" );
						while(item.hasMoreElements()) {
							items.add(item.nextToken());
						}
								
						for (int j=0; j<items.size()-1;j+=16){
							batch_id				= (String) items.get(j);
							item_code				= (String) items.get(j+1);
							store_code				= (String) items.get(j+3);
							expiry_date				= (String) items.get(j+6);
							bin_locn_code			= (String) items.get(j+7);
							bin_locn_desc			= (String) items.get(j+8);
							trade_id				= (String) items.get(j+9);
							trade_desc				= (String) items.get(j+10);
							manufacturer_desc		= (String) items.get(j+14);
							avail_qty				= (String) items.get(j+15);
							if(j%2==0)
								class_name	=	"QRYEVENSMALL"; 
							else
								class_name	=	"QRYODDSMALL";
%>
							<tr>
								<td width="10%" class="<%=class_name%>"><%=com.ehis.util.DateUtils.convertDate(expiry_date,"DMY","en",locale)%></td>
								<input type="hidden" name="expiry_date<%=rec_no%>" id="expiry_date<%=rec_no%>" value="<%=expiry_date%>">
								<td width="10%" class="<%=class_name%>"><%=batch_id%></td>
								<input type="hidden" name="batch_id<%=rec_no%>" id="batch_id<%=rec_no%>" value="<%=batch_id%>">
								<td width="20%" class="<%=class_name%>"><%=trade_desc%></td>
								<input type="hidden" name="trade_id<%=rec_no%>" id="trade_id<%=rec_no%>" value="<%=trade_id%>">
								<td width="20%" class="<%=class_name%>"><%=manufacturer_desc%></td>
								<td width="15%" class="<%=class_name%>"><%=bin_locn_desc%></td>
								<input type="hidden" name="bin_locn_code<%=rec_no%>" id="bin_locn_code<%=rec_no%>" value="<%=bin_locn_code%>">
								<td width="12%" class="<%=class_name%>"><%=dfToInteger.format(Double.parseDouble(avail_qty))%></td>						
								<td width="8%" class="<%=class_name%>"><input type="text" class="flat" size="8" value="<%=qty%>" name="issue_qty<%=rec_no%>" id="issue_qty<%=rec_no%>" style="text-align:right" align="center" onKeyPress="return allowValidNumber(this,event,6,0);" onBlur="checkstock(this,'<%=avail_qty%>','<%=conv_factor%>');" >
								</td>
								<td width="5%"><input type="checkbox"  name="select<%=rec_no%>" id="select<%=rec_no%>" checked></td>
							</tr>
<%	
							rec_no++;	
						}	
					}
%>
					<input type="hidden" name="conv_factor" id="conv_factor" value="<%=conv_factor%>">
					<input type="hidden" name="baseUOM" id="baseUOM" value="<%=uom_code%>"> <!--//Added for HSA-SCF-0221-->
<%
				}
%>
				<input type="hidden" name="item_code" id="item_code" value="<%=item_code%>">
				<input type="hidden" name="store_code" id="store_code" value="<%=store_code%>">
<%
			}
			catch(Exception e){
				e.printStackTrace();
			}
%>
		</form>
	</body>
</html>

