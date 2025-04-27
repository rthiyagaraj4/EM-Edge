<!DOCTYPE html>

  
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eST.Common.*,eCommon.XSSRequestWrapper"" %>
<%-- JSP Page specific attributes end 
/*
--------------------------------------------------------------------------------------------------------------------------------
Date		  Edit History	   Name		   Rev.Date   	 Rev.By 	   Description
17/02/2021		TFS:14131	        Manickavasagam J			     MMS-KH-CRF-0038
-----------------------------------------------------------------------------------------------------------------------------
*/
--%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<!-- This will be used on click of allocate batches link   -->
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
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
    <script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../ePH/js/DispMedication.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	try{
	String order_line_no=request.getParameter("order_line_no");
	
	//String bean_id		= "DispMedicationAllStages" ;
	//String bean_name	= "ePH.DispMedicationAllStages";
	
	String bean_id_1	= "DispMedicationBean" ;
	String bean_name_1	= "ePH.DispMedicationBean";
	DispMedicationBean bean_1 = (DispMedicationBean)getBeanObject( bean_id_1, bean_name_1, request ) ;
	//bean_1.setLanguageId(locale);

	String bean_id_3				= "DispMedicationAllStages" ;
	String bean_name_3				= "ePH.DispMedicationAllStages";
	DispMedicationAllStages bean_3  = (DispMedicationAllStages)getBeanObject( bean_id_3, bean_name_3, request ) ;

	String	bean_id_2		=	"StUtilities" ;
	String	bean_name_2		=	"eST.Common.StUtilities";
	StUtilities bean_2		=	null;

	/** Stock Bean Integration -Start ***/
	try { 
		bean_2 = (StUtilities) getBeanObject( bean_id_2,  bean_name_2, request );
		bean_2.setLanguageId(locale);

	}
//	catch (eST.Common.InsufficientBatchException exception) {
//		out.println(exception.getAvailableQuantity());
//		exception.printStackTrace();
//	}
	catch (Exception exception) {
		out.println(exception);
		exception.printStackTrace();
	}
	
	String qty		  =	request.getParameter("order_qty");
	String drug_code  = request.getParameter("drug_code");
	String drug_name  = request.getParameter("drug_name");
	String store_code = request.getParameter("store_code");
	String flag		  = request.getParameter("flag");
	String uom		  = request.getParameter("uom");
	String trade_code = request.getParameter("trade_code");
	String disp_locn_code= bean_1.getDispLocnCode();
	String item_code1 ="";

	ArrayList items = null;
    

	int iNoOfDecimals				= 0;
	boolean bDecimalAllowed			= bean_3.getDecimalAllowedYN(drug_code);
	if(bDecimalAllowed)
		iNoOfDecimals = bean_3.getINoOfDecimals();

	int iMaxLength					= 5+iNoOfDecimals;

	if(flag.equals("D")){

		items = bean_1.getItemDetails();
		if(items != null && items.size()>0)
		{
			if(!items.get(0).toString().equals(drug_code))
			{
				bean_1.setItemDetails(drug_code);
				items = bean_1.getItemDetails();
			}
		}
		else
		{
			bean_1.setItemDetails(drug_code);
			items = bean_1.getItemDetails();
		}
	}
	else if(flag.equals("F")){
		bean_1.setRFItemDetails(drug_code);
		items = bean_1.getRFItemDetails();

	}
	HashMap hmParameters	=	new HashMap();
	hmParameters.put("STORE_CODE",store_code);
	hmParameters.put("TRN_QTY",qty);
	hmParameters.put("INCLUDE_SUSPENDED","FALSE");//optional, by default FALSE
	hmParameters.put("INCLUDE_EXPIRED","FALSE");//optional, by default FALSE
	hmParameters.put("CUT_OFF_DATE","");//optional, by default SYSDATE
	hmParameters.put("VERIFY_INSUFFICIENT_QTY","FALSE");//optional, by default TRUE
	ArrayList alBatchList = new ArrayList();
	if(items.size()==2){
		if(trade_code!=null && !trade_code.equals("")){ // added  for IN073000
		     hmParameters.put("ITEM_CODE",items.get(0)+"="+trade_code);
		}else{
			 hmParameters.put("ITEM_CODE",items.get(0));
		}
		HashMap stock_detail	=	bean_2.getBatches(hmParameters);
		if(stock_detail.size()>0 && !stock_detail.containsKey("EXCEPTION")){
				alBatchList.add(stock_detail.get("BATCH_DATA"));	
		}
		item_code1 =(String)items.get(0);
	}
	else if(items.size()>2){		
		for (int i=0;i<items.size();i=i+2){
			hmParameters.put("ITEM_CODE",items.get(i));
			item_code1 =(String)items.get(i);
			HashMap stock_detail	=	bean_2.getBatches(hmParameters);
			if(stock_detail.size()>0 && !stock_detail.containsKey("EXCEPTION")){
				alBatchList.add(stock_detail.get("BATCH_DATA"));
			}
		}
		
	}

    HashMap IssueUOMAndBaseUOM		=	(HashMap)bean_3.getStoreDfltIssueUOMAndBaseUOM(store_code,item_code1);
    Double base_to_disp_uom_equl    =	bean_3.getEqulValue ( item_code1, (String)IssueUOMAndBaseUOM.get("BASE_UOM"), uom);
	Double base_to_def_uom_equl	    =   bean_3.getEqulValue ( item_code1, (String)IssueUOMAndBaseUOM.get("BASE_UOM"), (String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM"));
	if(flag.equals("F"))
	   base_to_disp_uom_equl		=	1.0;
	if(base_to_def_uom_equl == 0)
		base_to_def_uom_equl = 1.0;
	if(base_to_disp_uom_equl == 0)
		base_to_disp_uom_equl = 1.0;
    Double conv_factor              =  ( bean_3.lcm( base_to_disp_uom_equl,base_to_def_uom_equl))/base_to_disp_uom_equl; 
%>
<form name="frmDispMedicationWSShowBatches" id="frmDispMedicationWSShowBatches">
	<tr><!-- added for MMS-KH-CRF-0038 - start -->
		<%
		if(bean_1.getBarcode_Scan_YN().equals("Y")){ %>
		<td  width="20%"  style='text-align:right;'><font style='font-size:10;vertical-align: text-top;'>Barcode</font> <input type="text" class='fields' name="barcode_id" id="barcode_id" style="text-align:right"  onkeydown="if (event.keyCode==13) {validateBarcode(this)}" maxlength="100" size="80">
		</td>
		<%}
		%>
		</tr><!-- added for MMS-KH-CRF-0038 - end -->
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1" id="wsshowbatchestable">
		<tr>
			<td  colspan="8" style="background:#FDE6D0;font-size:10"><fmt:message key="ePH.BatchDetailsfor.label" bundle="${ph_labels}"/> <b><%=drug_name%></b></td>
		</tr>
		<tr>
			<td class="TDSTYLE1">
				<B><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></B>
			</td>
			<td class="TDSTYLE1">
				<B><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></B>
			</td>
			<td class="TDSTYLE1">
				<B><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></B>
			</td>
			<td class="TDSTYLE1">
				<B><fmt:message key="Common.Manufacturer.label" bundle="${common_labels}"/></B>
			</td>
			<td class="TDSTYLE1">
				<B><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></B>
			</td>
			<td class="TDSTYLE1">
				<B><fmt:message key="eST.AvailableQty.label" bundle="${st_labels}"/></B>
			</td>
			<td class="TDSTYLE1">
				<B><fmt:message key="ePH.AllocatedQuantity.label" bundle="${ph_labels}"/></B>
			</td>
			<td class="TDSTYLE1">
				<B><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></B>
			</td>
		</tr>
		<%
			String class_name="";
			int outerCount = alBatchList.size();
			int innerCount = 0;
			String barcode_id = "";


			for (int i=0;i<alBatchList.size();i++){
				ArrayList batch_details = (ArrayList)alBatchList.get(i);	

				innerCount = batch_details.size();
				if(flag != null && flag.equals("F"))
					innerCount = 1;
				   
					String tmp_qty		 =  qty;	

				for(int j=0; j<innerCount; j++ ) {

					if(j%2==0)
						class_name	=	"QRYEVENSMALL"; 
					else
						class_name	=	"QRYODDSMALL";

					HashMap drug_detail	=	(HashMap)batch_details.get(j);					
					String expiry_date	 = (String)drug_detail.get("EXPIRY_DATE");
					String batch_id		 = (String)drug_detail.get("BATCH_ID");
					String trade_id		 = (String)drug_detail.get("TRADE_ID");
					String trade_name	 = (String)drug_detail.get("TRADE_NAME");
					String manufacturer_id=(String)drug_detail.get("MANUFACTURER_ID");
					String manufacturer	 = (String)drug_detail.get("MANUFACTURER_NAME");
					String bin_locn_code = (String)drug_detail.get("BIN_LOCATION_CODE");
					String bin_locn		 = (String)drug_detail.get("BIN_DESC");
					String available_qty = (String)drug_detail.get("AVAIL_QTY");
					String item_code	 = (String)drug_detail.get("ITEM_CODE");
					String item_desc	 = (String)drug_detail.get("ITEM_DESC");
					barcode_id			 = (String)drug_detail.get("BARCODE_ID");  //added for MMS-KH-CRF-0038 
					if(barcode_id==null) 
						barcode_id = "";



		%>
		<tr>
			<td class="<%=class_name%>">
				<%=com.ehis.util.DateUtils.convertDate(expiry_date,"DMY","en",locale)%>
			</td>
			<td class="<%=class_name%>">
				<%=batch_id%>
				<input type="hidden" name="batch_id<%=i%><%=j%>" id="batch_id<%=i%><%=j%>" value="<%=batch_id%>">
				<input type="hidden" name="item_code<%=i%><%=j%>" id="item_code<%=i%><%=j%>" value="<%=item_code%>">
				<input type="hidden" name="item_desc<%=i%><%=j%>" id="item_desc<%=i%><%=j%>" value="<%=item_desc%>">
				<input type="hidden" name="expiry_date<%=i%><%=j%>" id="expiry_date<%=i%><%=j%>" value="<%=expiry_date%>">
				<input type="hidden" name="barcode_id<%=i%><%=j%>" id="barcode_id<%=i%><%=j%>" value="<%=barcode_id%>"> <!-- added for MMS-KH-CRF-0038 - start -->
				
			</td>
			<td class="<%=class_name%>">
				<input type="hidden" name="trade_id<%=i%><%=j%>" id="trade_id<%=i%><%=j%>" value="<%=trade_id%>">
				<input type="hidden" name="trade_name<%=i%><%=j%>" id="trade_name<%=i%><%=j%>" value="<%=trade_name%>">
				<%=trade_name%>
			</td>
			<td class="<%=class_name%>">
				<input type="hidden" name="manufacturer_id<%=i%><%=j%>" id="manufacturer_id<%=i%><%=j%>" value="<%=manufacturer_id%>">
				<input type="hidden" name="manufacturer_name<%=i%><%=j%>" id="manufacturer_name<%=i%><%=j%>" value="<%=java.net.URLEncoder.encode(manufacturer)%>">
				<%=manufacturer%>
			</td>
			<td class="<%=class_name%>">
				<input type="hidden" name="bin_locn_code<%=i%><%=j%>" id="bin_locn_code<%=i%><%=j%>" value="<%=bin_locn_code%>">
				<input type="hidden" name="bin_locn_desc<%=i%><%=j%>" id="bin_locn_desc<%=i%><%=j%>" value="<%=bin_locn%>">
				<%=bin_locn%>
			</td>
			<td class="<%=class_name%>">
				<input type="hidden" name="available_qty<%=i%><%=j%>" id="available_qty<%=i%><%=j%>" value="<%=available_qty%>">
				<%=available_qty%>
			</td>

		<%	if(Float.parseFloat(qty)> Float.parseFloat(available_qty)){
			      tmp_qty	=  Float.parseFloat(available_qty)+"";   
				  qty		=	Float.parseFloat(qty)-Float.parseFloat(tmp_qty)+"";
        
			}else{
                 tmp_qty  = qty;
			}

			if(bean_1.getBarcode_Scan_YN().equals("Y")) //MMS-KH-CRF-0038
				tmp_qty = "";


		%>
			<td class="<%=class_name%>" >
				<input type="textbox" onKeyPress="if(event.keyCode!=13) {return allowValidNumber(this,event,4,<%=iNoOfDecimals%>);}else{return false;}"  name="alloc_qty<%=i%><%=j%>" class="number" value="<%=tmp_qty%>" size="6" maxlength="<%=iMaxLength%>"  onBlur="if(validateNumbers(this,4,'<%=iNoOfDecimals%>')){CheckNum(this);validateShowBatchesAllocQty('<%=available_qty%>',this,'<%=conv_factor%>','<%=iNoOfDecimals%>');}">
			</td>
			<td class="<%=class_name%>" >
				<input type="checkbox" name="chkSelect<%=i%><%=j%>" id="chkSelect<%=i%><%=j%>" value="E" checked>
			</td>
		</tr>
		<%				
				}
			}
		%>
	</table>
	<input type="hidden" name="inner_count" id="inner_count" value="<%=innerCount%>">
	<input type="hidden" name="outer_count" id="outer_count" value="<%=outerCount%>">
	<input type="hidden" name="order_line_no" id="order_line_no" value="<%=order_line_no%>">
	<input type="hidden" name="drug_code" id="drug_code" value="<%=drug_code%>">
	<input type="hidden" name="drug_name" id="drug_name" value="<%=drug_name%>">
	<input type="hidden" name="disp_locn_code" id="disp_locn_code" value="<%=disp_locn_code%>">
	<input type="hidden" name="store_code" id="store_code" value="<%=store_code%>">
	<input type="hidden" name="uom" id="uom" value="<%=uom%>">
	<input type="hidden" name="conv_factor" id="conv_factor" value="<%=conv_factor%>">
	<input type="hidden" name="no_decimals_allowed" id="no_decimals_allowed" value="<%=iNoOfDecimals%>">
</form>
</body>
</html>

<%
putObjectInBean(bean_id_2,bean_2,request);
putObjectInBean(bean_id_1,bean_1,request);

}catch(Exception e){
e.printStackTrace();
}
%>

