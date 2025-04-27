<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8"
	import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper"%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
<title>Dispense Details</title>
<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
		request.setCharacterEncoding("UTF-8");
//added By Himanshu Start.
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//end.
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@include file="../../eCommon/jsp/CommonBean.jsp"%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'
	type='text/css'></link>
<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script language="Javascript" src="../../ePH/js/WardAcknowledge.js"></script>
<script language="Javascript" src="../../eCommon/js/CommonLookup.js"></SCRIPT>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/dchk.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body >
	<%
		 
			String bean_id		= "WardAcknowledgeBean";
			String bean_name	= "ePH.WardAcknowledgeBean";
			String facility_id					= (String) session.getValue("facility_id");

			WardAcknowledgeBean bean = (WardAcknowledgeBean)getBeanObject( bean_id,bean_name,request) ;
			bean.clear() ; 
			bean.setLanguageId(locale);
			String	patientId			=	CommonBean.checkForNull(request.getParameter("patientId"));
			String	dispNo 				= 	CommonBean.checkForNull(request.getParameter("dispNo"));
			String	srlNo			=	CommonBean.checkForNull(request.getParameter("srlNo"));
			//MMS-KH-CRF-0039 - start
			String	order_type			=	CommonBean.checkForNull(request.getParameter("order_type"));
			String  disp_locn_code		=   CommonBean.checkForNull(request.getParameter("disp_locn_code"));
			String	sql  ="";
		 	//String sql = "SELECT   ol.order_qty,d.drug_desc, a.disp_qty dispensedqty, b.disp_uom_code qtyuom,b.issue_qty, b.issue_uom_code, a.batch_id,(select short_desc from am_uom_lang_vw where uom_code=ol.order_uom and language_id = ? ) issue_uom_desc,(select short_desc from am_uom_lang_vw where uom_code =b.disp_uom_code and language_id = ? ) desped_uom_desc,TO_CHAR (a.expiry_date, 'DD/MM/YYYY') expiry_date,TO_CHAR (b.modified_date, 'dd/mm/yyyy hh24:mi') modified_date FROM ph_disp_drug_batch a, ph_disp_dtl b, ph_disp_hdr c, ph_drug d, st_item j, st_sal_hdr k, or_order l,or_order_line ol WHERE a.facility_id = b.facility_id AND k.doc_no = c.doc_no AND k.doc_type_code = c.doc_type AND k.facility_id = c.facility_id AND a.disp_no = b.disp_no AND a.srl_no = b.srl_no AND c.facility_id = b.facility_id AND c.disp_no = b.disp_no AND b.disp_drug_code = d.drug_code AND a.disp_qty <> NVL (a.returned_qty, 0) AND a.item_code = j.item_code AND c.order_id = l.order_id AND b.order_id = c.order_id AND NVL (l.iv_prep_yn, 'X') NOT IN ('2', '4', '6', '8', '0') AND ( (j.use_after_expiry_yn = 'N' AND SYSDATE < expiry_date) OR (j.use_after_expiry_yn = 'Y') ) AND l.patient_id = ? AND b.facility_id = ? AND b.disp_no = NVL (?, a.disp_no) AND l.patient_class = NVL (?, l.patient_class) AND a.srl_no = NVL (?, a.srl_no) ORDER BY b.added_date DESC";
		
			 //String sql="SELECT   ol.order_qty,d.drug_desc, a.disp_qty dispensedqty, b.disp_uom_code qtyuom,b.issue_qty, b.issue_uom_code, a.batch_id,(select short_desc from am_uom_lang_vw where uom_code = ol.order_uom and language_id = ? ) issue_uom_desc,(select short_desc from am_uom_lang_vw where uom_code =b.disp_uom_code and language_id = ? ) desped_uom_desc,TO_CHAR (a.expiry_date, 'DD/MM/YYYY') expiry_date,TO_CHAR (b.modified_date, 'dd/mm/yyyy hh24:mi') modified_date FROM ph_disp_drug_batch a, ph_disp_dtl b, ph_disp_hdr c, ph_drug d, st_item j, st_sal_hdr k, or_order l,or_order_line ol WHERE a.facility_id = b.facility_id AND k.doc_no = c.doc_no AND k.doc_type_code = c.doc_type AND k.facility_id = c.facility_id AND a.disp_no = b.disp_no AND a.srl_no = b.srl_no AND c.facility_id = b.facility_id AND c.disp_no = b.disp_no AND b.disp_drug_code = d.drug_code AND a.disp_qty <> NVL (a.returned_qty, 0) AND a.item_code = j.item_code AND c.order_id = l.order_id AND b.order_id = c.order_id AND NVL (l.iv_prep_yn, 'X') NOT IN ('2', '4', '6', '8', '0') AND ( (j.use_after_expiry_yn = 'N' AND SYSDATE < expiry_date) OR (j.use_after_expiry_yn = 'Y') ) AND l.patient_id = ? AND b.facility_id = ? AND a.disp_no = NVL (?, a.disp_no) AND l.patient_class = NVL (?, l.patient_class) AND ol.order_id=l.order_id AND ol.order_id=b.order_id AND a.srl_no = NVL (?, a.srl_no) ORDER BY b.added_date DESC";
			//MMS-KH-CRF-0039 - start
			  if(order_type.equals("A")){
				sql = "SELECT '' order_qty,MFG_UNIT drug_desc, order_id, QTY_VOLUME dispensedqty,QTY_UOM qtyuom, QTY_VOLUME issue_qty, QTY_UOM issue_uom_code, batch_id,QTY_UOM issue_uom_desc,QTY_UOM desped_uom_desc, TO_CHAR (expiry_date, 'DD/MM/YYYY') expiry_date,TO_CHAR (modified_date, 'dd/mm/yyyy hh24:mi') modified_date  FROM ph_worksheet_hdr where facility_id=? and DISP_LOCN=? and worksheet_id=? ";
			  }else{
				sql="SELECT   ol.order_qty,d.drug_desc,b.order_id, a.disp_qty dispensedqty, b.disp_uom_code qtyuom,b.issue_qty, b.issue_uom_code, a.batch_id,(select short_desc from am_uom_lang_vw where uom_code = ol.order_uom and language_id = ? ) issue_uom_desc,(select short_desc from am_uom_lang_vw where uom_code =b.disp_uom_code and language_id = ? ) desped_uom_desc,TO_CHAR (a.expiry_date, 'DD/MM/YYYY') expiry_date,TO_CHAR (b.modified_date, 'dd/mm/yyyy hh24:mi') modified_date FROM ph_disp_drug_batch a, ph_disp_dtl b, ph_disp_hdr c, ph_drug d, st_item j, st_sal_hdr k, or_order l,or_order_line ol WHERE a.facility_id = b.facility_id AND k.doc_no = c.doc_no AND k.doc_type_code = c.doc_type AND k.facility_id = c.facility_id AND a.disp_no = b.disp_no AND a.srl_no = b.srl_no AND c.facility_id = b.facility_id AND c.disp_no = b.disp_no AND b.disp_drug_code = d.drug_code AND a.disp_qty <> NVL (a.returned_qty, 0) AND a.item_code = j.item_code AND c.order_id = l.order_id AND b.order_id = c.order_id AND NVL (l.iv_prep_yn, 'X') NOT IN ('2', '4', '6', '8', '0') AND ( (j.use_after_expiry_yn = 'N' AND SYSDATE < expiry_date) OR (j.use_after_expiry_yn = 'Y') ) AND l.patient_id = ? AND b.facility_id = ? AND a.disp_no = NVL (?, a.disp_no) AND l.patient_class = NVL (?, l.patient_class) AND ol.order_id=l.order_id AND ol.order_id=b.order_id AND a.srl_no = NVL (?, a.srl_no) ORDER BY b.added_date DESC";//order_id added for GHL-CRF-0451
			  }
			  //MMS-KH-CRF-0039 - end

			ArrayList batchDetails=bean.getWardAcknowledgeDetails(sql,locale,patientId,dispNo,facility_id,srlNo,order_type,disp_locn_code);
			ArrayList patientDetails=new ArrayList();
			patientDetails=bean.getPatientDetails(patientId);
			String patient_name = (String)patientDetails.get(0);
			String sex	= (String)patientDetails.get(1);
			String age	= (String)patientDetails.get(2);
			
			if(sex.equalsIgnoreCase("female"))
				sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
			else if(sex.equalsIgnoreCase("male"))
				sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			else if(sex.equalsIgnoreCase("unknown"))
				sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
%>
			
<form name="formDrugDetailsAcknowledge" id="formDrugDetailsAcknowledge">
	<TABLE width="100%" cellspacing="0" cellpadding="0"
		border="1"><tr>
		<th class="commontoolbarfunction" align="left" >&nbsp;<%=patient_name%>&nbsp;,&nbsp;<%=sex%>&nbsp;,&nbsp;<%=age%>,&nbsp;<%=patientId%></th>	
	</tr>
	<tr></tr>
	<tr></tr></table>
		
	<TABLE width="100%" align="left" cellspacing="0" cellpadding="0"
		border="1">
		
		<tr>
		<%			//MMS-KH-CRF-0039 - start
					if(order_type.equals("A")){%>
					<td class='COLUMNHEADER' width=40%><fmt:message
					key="Common.ProductName.label" bundle="${common_labels}" /></td>

					<td class='COLUMNHEADER' width=10%><fmt:message key="ePH.PreparedQuantity.label" bundle="${ph_labels}"/></td>
					<%}else{
					//MMS-KH-CRF-0039 - end
					%>
			<td class='COLUMNHEADER' width=40%><fmt:message key="ePH.DrugDescription.label" bundle="${ph_labels}"/></td> <!-- Modified for TFS-13907 -->
					<td class='COLUMNHEADER' width=10%><fmt:message key="ePH.OrderQuantity.label" bundle="${ph_labels}"/></td>
					<td class='COLUMNHEADER' width=10%><fmt:message key="ePH.DispenseQuantity.label" bundle="${ph_labels}"/></td>
					<%}%>

			<td class='COLUMNHEADER' width=10%><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width=10%><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width=10%><fmt:message key="Common.Dispensed.label" bundle="${common_labels}"/><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></td>
			<!-- Added for ghl-CRF-0451 start -->
			<td class='COLUMNHEADER' width=40%><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></td>
			<!-- Added for ghl-CRF-0451 end -->
		</tr>
		<%
					
					
		int rowCount=0;
		String classvalue="";
		String temp="";
		int rowspan=1;
		int rowspanCount=1;
		for (int i=0;i<batchDetails.size();i+=9){// 8 IS changed to 9 added for GHL-CRF-0451
			if(((String)batchDetails.get(i)).equals(temp)){
				rowspan++;
		}
					temp=(String)batchDetails.get(i);

					}
		
		
		for (int i=0;i<batchDetails.size();i+=9){ // 8 IS changed to 9 added for GHL-CRF-0451
			
			if ( rowCount++ % 2 == 0 ){
				classvalue = "QRYEVEN" ;
			}
			else{
				classvalue = "QRYODD" ;
			}%>
				<TR>
								<%if(i == 0){ %><TD class="<%=classvalue%>"
									style="font-family: verdana; font-size: 8pt;" align="left" rowspan="<%=rowspan%>"><%=batchDetails.get(i)%>
								</TD>
								<%if(!order_type.equals("A")){	//MMS-KH-CRF-0039 
									%>								
								<TD class="<%=classvalue%>"
									style="font-family: verdana; font-size: 8pt;" align="left" rowspan="<%=rowspan%>"><%=batchDetails.get(i+1)%>&nbsp;<%=batchDetails.get(i+2)%>
								</TD>
								<%}
								}else{%> <% } 
									
								
								%>

								<TD class="<%=classvalue%>"
									style="font-family: verdana; font-size: 8pt;" align="left"><%=batchDetails.get(i+3)%>&nbsp;<%=batchDetails.get(i+4)%>
								</TD>
								<TD class="<%=classvalue%>"
									style="font-family: verdana; font-size: 8pt;" align="left"><%=batchDetails.get(i+5)%>
								</TD>
								<TD class="<%=classvalue%>"
									style="font-family: verdana; font-size: 8pt;" align="left"><%=batchDetails.get(i+6)%>
								</TD>
								<TD class="<%=classvalue%>"
									style="font-family: verdana; font-size: 8pt;" align="left">
									<%=com.ehis.util.DateUtils.convertDate((((String)(batchDetails.get(i+7))).trim()),"DMYHM","en",locale)%>
									
								</TD>
								<!-- Added for ghl-CRF-0451 start -->
								<TD class="<%=classvalue%>"
									style="font-family: verdana; font-size: 8pt;" align="left"><%=batchDetails.get(i+8)%>
								</TD>
								<!-- Added for ghl-CRF-0451 end -->
								

		</TR>
<%	temp=(String)batchDetails.get(i);

rowCount++;
}
%>
</TABLE>

</form>
		
</body>
</html>

