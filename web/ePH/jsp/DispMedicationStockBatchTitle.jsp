<!DOCTYPE html>

 <!-- 
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
	
08/10/2020		IN073865           Shazana		MMS-DM-CRF-0174.4
--------------------------------------------------------------------------------------------------------------
-->


<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<HTML>
	<HEAD>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../ePH/js/DispMedicationAllStages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>
<%
	String dosage_dtls1		=	"";
	String start_date		=	"";
	String end_date			=	"";
	String facility_id		=   (String) session.getValue("facility_id");
	String drug_desc		=	request.getParameter("drug_desc");
	String alt_drug_code		=	request.getParameter("alt_drug_code")==null?"":request.getParameter("alt_drug_code");
	String alt_drug_desc	=	request.getParameter("alt_drug_desc");
	String strength			=	request.getParameter("drug_strength");
	String alt_strength_uom=	request.getParameter("alt_strength_uom");
	String patient_id		=	request.getParameter("patient_id");//Added for KDAH-CRF-0231 [IN-034551]
    String main_strength_per_value_pres_uom =CommonBean.checkForNull(request.getParameter("main_strength_per_value_pres_uom"));
    String alt_drg_no			=	request.getParameter("alt_drg_no")==null?"":request.getParameter("alt_drg_no");
    String no = request.getParameter("no")==null?"":request.getParameter("no"); // Added for MMS-DM-SCF-0083
    String source = request.getParameter("source")==null?"":request.getParameter("source"); // Added for MMS-DM-SCF-0083
    String prescribed_strength	=	request.getParameter("prescribed_strength")==null?"":request.getParameter("prescribed_strength");
	String bms_strength			=	CommonBean.checkForNull(request.getParameter("bms_strength"));
	String alt_drug_strength	=	CommonBean.checkForNull(request.getParameter("alt_drug_strength"));

	if(strength!=null && !strength.equals("") && Float.parseFloat(strength) <1)
		strength = Float.parseFloat(strength) +"" ;

	String strength_uom		=	request.getParameter("uom");
	String order_id			=   request.getParameter("order_id");
	String order_line_no	=   request.getParameter("order_line_no")==null?"":request.getParameter("order_line_no");
	String qty_value		=   "";
	String qty_unit			=   "";
	String sliding_scale_yn =   "";
	String barcode_flg		=	"";//added for KDAH-CRF-0231 [IN-034551]
	
	if(alt_drug_desc!=null && !alt_drug_desc.equals("")) {
		drug_desc			=	alt_drug_desc;
		strength			=	alt_drug_strength;
		strength_uom		=	alt_strength_uom;
	}
	if(strength.equals("0")||strength.equals("0.0")) {
		strength			=	"";
		strength_uom		=	"";
	}

	String	bean_id_1		=	"DispMedicationBean" ;
	String	bean_name_1		=	"ePH.DispMedicationBean";
	
	DispMedicationBean bean_1	= (DispMedicationBean)getBeanObject( bean_id_1, bean_name_1, request);

	ArrayList dosage_dtls	=	new ArrayList();
	    dosage_dtls		=	bean_1.getDosageDtls(order_id,order_line_no);	

	dosage_dtls1	=	(String)dosage_dtls.get(0);
	start_date		=	(String)dosage_dtls.get(1);
	end_date		=	(String)dosage_dtls.get(2);
	qty_value		=	(String)dosage_dtls.get(3);
	qty_unit		=	(String)dosage_dtls.get(4);
	sliding_scale_yn=	(String)dosage_dtls.get(5);
	if(sliding_scale_yn.equals("Y")){
		 qty_value ="Sliding Scale";
		 qty_unit="";
	}
	if(request.getParameter("barcode_flg")!=null){//if & else block added for KDAH-CRF-0231 [IN-034551] 
		barcode_flg	=	request.getParameter("barcode_flg"); 
	}
	else{
		barcode_flg = 	bean_1.getBarcode_Scan_YN();
	}
%>
	<body onMouseDown="" onKeyDown="lockKey()" onload="setfldFocus('<%=barcode_flg%>')"> <!-- onload="setfldFocus('<%=barcode_flg%>')" added for KDAH-CRF-0231 [IN-034551] -->
		<form name="DispMedicationAllocationBatchTitle" id="DispMedicationAllocationBatchTitle">
			<table cellpadding="0" cellspacing="0" width="98%" align="center" border="1">
				<tr >
					<td colspan="7"  width="50%" class="OUTOFSTOCK" nowrap> 
					<b>&nbsp;<%=qty_value%>&nbsp;&nbsp;<%=bean_1.getUomDisplay(facility_id,qty_unit)%>&nbsp;<%=dosage_dtls1%></b>&nbsp;&nbsp;<fmt:message key="Common.startdatetime.label" bundle="${common_labels}"/> :<b><%=com.ehis.util.DateUtils.convertDate(start_date,"DMYHM","en",locale)%></b>&nbsp;&nbsp;&nbsp;<fmt:message key="Common.enddatetime.label" bundle="${common_labels}"/>:<b><%=com.ehis.util.DateUtils.convertDate(end_date,"DMYHM","en",locale)%> </b></td>
					<td width="30%"  class="OUTOFSTOCK">&nbsp;&nbsp;</td> 
				</tr>
				<tr ><td style="border: none;border: 3px solid white;" colspan="7" width="100%"></td></tr>
				<tr  >
					<td colspan="7"  width="50%" class="BATCHTITLE"><fmt:message key="ePH.BatchDetailsfor.label" bundle="${ph_labels}"/> <b><%=java.net.URLDecoder.decode(drug_desc,"UTF-8")%>&nbsp;<%=strength%>&nbsp;<%=bean_1.getUomDisplay(facility_id,strength_uom)%></b></td>
					<td width="50%"  class="BATCHTITLE"><img src="../../ePH/images/InsufficientStock.gif" id="stock_image" style="visibility:hidden;" height="12"></td> 
				</tr>

				<tr><td colspan="7" width="100%"></td></tr>
				 <tr>
					<td  class="COLUMNHEADER" width="10%" style="font-size:9px"><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
					<td  class="COLUMNHEADER"  width="10%" style="font-size:9px"><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></td>
					<td  class="COLUMNHEADER"  width="21%" style="font-size:9px"><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></td>
					<td  class="COLUMNHEADER" width="20%" style="font-size:9px"><fmt:message key="Common.Manufacturer.label" bundle="${common_labels}"/></td>
					<td  class="COLUMNHEADER" width="16%" style="font-size:9px"><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></td>
					<td  class="COLUMNHEADER" width="10%" style="font-size:9px"><fmt:message key="eST.AvailableQty.label" bundle="${st_labels}"/></td>
					<td  class="COLUMNHEADER" width="15%" style="font-size:9px"><fmt:message key="ePH.AllocatedQuantity.label" bundle="${ph_labels}"/></td>
					<td  class="COLUMNHEADER" width="5%" style="font-size:9px"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
				</tr>
			</table>
<%
			//Added for Bru-HIMS-CRF-076 [IN:034551]
			if(bean_1.getBarcode_Scan_YN()!=null && bean_1.getBarcode_Scan_YN().equals("Y") || !bean_1.getBarcode_id().equals("") || bean_1.getStockDtl().containsKey("barcode_applicable") && bean_1.getStockDtl().get("barcode_applicable").equals("Y") ){ // if barcodeflg value 'Y' then display text field on the grid which helps point cursor to the scanner added for KDAH-CRF-0231 [IN-034551]
%>
				<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
					<td  width="5%" colspan='5' style='text-align:right;'><input type="text" class='fields' name="barcode_id" id="barcode_id" style="text-align:right" onkeydown="if (event.keyCode==13 || event.keyCode==17) {callBarcodesearch('<%=patient_id%>','<%=order_id%>','<%=order_line_no%>','<%=alt_drug_code%>','<%=prescribed_strength%>','<%=bms_strength%>', '<%=alt_drug_strength%>','<%=drug_desc%>','<%=alt_drug_desc%>','<%=no%>','<%=source%>',event)}" maxlength="100"  size=80  ></td><!-- no and source Added for MMS-DM-SCF-0083,increased maxlength size for IN073865 -->
					<td  width="3%" ></td>
				</table>
<%
			}
%>
       <input type='hidden' name='bar_code_scan_site_YN' id='bar_code_scan_site_YN' value='<%=bean_1.getBarcodeSiteYN()%>'><!--Added for MMS-DM-CRF-157.2-->
		</form>
	</body>
</html>

