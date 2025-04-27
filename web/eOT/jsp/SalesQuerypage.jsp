<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.*,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.util.*,webbeans.eCommon.ConnectionManager,webbeans.eCommon.ConnectionManager,eCommon.Common.*,eOT.*,eOR.OrderEntryBillingQueryBean,eST.OTTransactionBean,eST.*" contentType=" text/html;charset=UTF-8" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 String locale = (String)session.getAttribute("LOCALE"); 
 request.setCharacterEncoding("UTF-8");
 	String item_desc="";
	String expiry_date="";
	String batch_id="";
	String trade_name="";
	String bin_desc="";
	String qty="";
	String qty1="";
	String mm_item_code="";
	String remarks_dc="";
	String req_store_code="";
	String patient_id="";
	String encounter_id="";
	String patient_class="";
	String facility_id = (String)session.getValue("facility_id") ;
	String total_pay="";
	String patient_pay="";
	String patient_paid="";
	String include_exclude="";
	String preapp_yn="";
	String sale_document_type="";
	String sale_document_no="";
	String doc_srl_no="";
	String module_id = CommonBean.checkForNull(request.getParameter("module_id"));
	String oper_num = checkForNull(request.getParameter("oper_num"));
    String remarks_label =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels");
	String dup_item="";
	String dup_item1="";
	String dup_doc_no="";
	String batch_sale_price_yn="";
	boolean flag=true;
	boolean flag1=false;
	int count=0;
 //Modified by DhanasekarV on 25/11/2010 against  issue IN025244
	String dup_batch_id="";
	HashMap map=new HashMap();

	String tmp_batch_id ="";
	String tmp_trade_id = "";
	String tmp_bin_location ="";

	String facility_opernum    = (String)request.getParameter("ref_no")==null?"":(String)request.getParameter("ref_no");
	 Connection con=null;
	 CallableStatement statement =null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	ResultSet rs=null;
	ResultSet rs1=null;
 try {


	con = ConnectionManager.getConnection(request);

	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();

	if(rs1!=null) rs1.close();
	if(pstmt1!=null) pstmt1.close();
	 //	String SQL_DIRECT_CONS="SELECT batchview.trade_id, batchview.qty_on_hand,batchview.use_after_expiry_yn, batchview.expiry_yn expiry_yn, (batchview.avail_qty + stexp.sal_item_qty) avail_qty,batchview.trade_id_applicable_yn, batchview.manufacturer_id,stexp.sal_item_qty qty, batchview.store_desc, batchview.trade_name trade_name,batchview.nod nod, batchview.item_desc item_desc, batchview.manufacturer_name,batchview.store_code, batchview.suspended_yn, batchview.item_code,batchview.bin_location_code,TO_CHAR (batchview.expiry_date, 'dd/mm/yyyy') expiry_date,batchview.bin_desc bin_desc, batchview.batch_id,batchview.batch_status batch_status,hdr.remarks remarks FROM st_batch_search_lang_view batchview, st_sal_dtl_exp stexp,st_sal_hdr hdr WHERE batchview.store_code = stexp.store_code AND batchview.item_code = stexp.item_code AND batchview.batch_id = stexp.batch_id AND batchview.bin_location_code = stexp.bin_location_code AND batchview.expiry_date = stexp.expiry_date_or_receipt_date AND stexp.facility_id = '"+facility_id+"' AND batchview.language_id = '"+locale+"' AND batchview.lang1 = '"+locale+"' AND batchview.lang2 = '"+locale+"'AND stexp.doc_srl_no like '%' and hdr.module_id = '"+module_id+"' and stexp.doc_no = hdr.doc_no and stexp.doc_type_code = hdr.doc_type_code and hdr.REF_NO = '"+facility_opernum+"'";


//String SQL_DIRECT_CONS=" SELECT batchview.trade_id, batchview.qty_on_hand,batchview.use_after_expiry_yn, batchview.expiry_yn expiry_yn, (batchview.avail_qty + stexp.sal_item_qty) avail_qty,batchview.trade_id_applicable_yn, batchview.manufacturer_id,stexp.sal_item_qty qty, batchview.store_desc, batchview.trade_name trade_name,batchview.nod nod, batchview.item_desc item_desc, batchview.manufacturer_name,batchview.store_code, batchview.suspended_yn, batchview.item_code,batchview.bin_location_code,TO_CHAR (batchview.expiry_date, 'dd/mm/yyyy') expiry_date,batchview.bin_desc bin_desc, batchview.batch_id,batchview.batch_status batch_status,decode(dtl.remarks,'','',(select nvl(MM.REMARKS_DESC,'') from mm_trn_remarks_lang_vw mm where MM.TRN_REMARKS_CODE = dtl.remarks and mm.language_id ='"+locale+"')) remarks FROM st_batch_search_lang_view batchview, st_sal_dtl_exp stexp,st_sal_hdr hdr,st_sal_dtl dtl  WHERE batchview.store_code = stexp.store_code AND batchview.item_code = stexp.item_code AND batchview.batch_id = stexp.batch_id AND batchview.bin_location_code = stexp.bin_location_code AND batchview.expiry_date = stexp.expiry_date_or_receipt_date AND stexp.facility_id = '"+facility_id+"' AND batchview.language_id ='"+locale+"' AND batchview.lang1 ='"+locale+"' AND batchview.lang2 ='"+locale+"' AND stexp.doc_srl_no like '%' and hdr.module_id =  '"+module_id+"' and stexp.doc_no = hdr.doc_no and stexp.doc_type_code = hdr.doc_type_code and hdr.REF_NO = '"+facility_opernum+"'and dtl.facility_id = hdr.facility_id and dtl.doc_no = hdr.doc_no and dtl.doc_type_code = hdr.doc_type_code and dtl.doc_srl_no = stexp.doc_srl_no";


//String SQL_DIRECT_CONS="SELECT DTL.BL_INCL_EXCL_OVERRIDE_VALUE BL_INCL_EXCL_OVERRIDE_VALUE , DTL.BL_INCL_EXCL_OVERRIDE_REASON,EXP.Doc_no Doc_no,EXP.doc_srl_no doc_srl_no, EXP.doc_type_code doc_type_code,EXP.STORE_CODE store_code,dtl.item_code item_code,exp.batch_id batch_id, mm.short_desc item_desc,dtl.item_code,NVL ((SELECT short_name FROM am_trade_name_lang_vw WHERE language_id = '"+locale+"' AND trade_id = EXP.trade_id),      trade_id) trade_name,bin.short_desc bin_desc, TO_CHAR(EXP.expiry_date_or_receipt_date,'DD/MM/YYYY')   expiry_date,DECODE (dtl.remarks,'', '',(SELECT NVL (mm.remarks_desc, '')             FROM mm_trn_remarks_lang_vw mm WHERE mm.trn_remarks_code = dtl.remarks AND mm.language_id = '"+locale+"')) remarks,DECODE(BATCH_SALE_PRICE_YN,'Y',EXP.SAL_ITEM_QTY,DTL.ITEM_QTY) QTY,EXP.SAL_ITEM_QTY QTY1,nvl(BATCH_SALE_PRICE_YN,'N') BATCH_SALE_PRICE_YN FROM st_sal_hdr hdr, st_sal_dtl_exp EXP, st_sal_dtl dtl,mm_bin_location_lang_vw bin, mm_item_lang_vw mm,ST_ACC_ENTITY_PARAM WHERE hdr.module_id = '"+module_id+"' and HDR.REF_NO = '"+facility_opernum+"'  AND hdr.facility_id = dtl.facility_id  AND hdr.doc_no = dtl.doc_no AND hdr.doc_type_code = dtl.doc_type_code AND dtl.facility_id = EXP.facility_id AND dtl.doc_type_code = EXP.doc_type_code AND dtl.doc_no = EXP.doc_no AND dtl.doc_srl_no = EXP.doc_srl_no and BIN.STORE_CODE = EXP.STORE_CODE and BIN.BIN_LOCATION_CODE = EXP.BIN_LOCATION_CODE and BIN.LANGUAGE_ID = '"+locale+"'  and mm.item_code = dtl.item_code and mm.language_id = '"+locale+"' order by dtl.doc_no, dtl.doc_srl_no";

/* Old query commented by Sanjay against Incident No: OT-ICN31202
String SQL_DIRECT_CONS="SELECT DTL.BL_INCL_EXCL_OVERRIDE_VALUE BL_INCL_EXCL_OVERRIDE_VALUE , DTL.BL_INCL_EXCL_OVERRIDE_REASON,EXP.Doc_no Doc_no,EXP.doc_srl_no doc_srl_no, EXP.doc_type_code doc_type_code,EXP.STORE_CODE store_code,dtl.item_code item_code,exp.batch_id batch_id, mm.short_desc item_desc,dtl.item_code,NVL ((SELECT short_name FROM am_trade_name_lang_vw WHERE language_id = '"+locale+"' AND trade_id = EXP.trade_id),      trade_id) trade_name,bin.short_desc bin_desc, TO_CHAR(EXP.expiry_date_or_receipt_date,'DD/MM/YYYY')   expiry_date,DECODE (dtl.remarks,'', '',(SELECT NVL (mm.remarks_desc, '')             FROM mm_trn_remarks_lang_vw mm WHERE mm.trn_remarks_code = dtl.remarks AND mm.language_id = '"+locale+"')) remarks,DECODE(BATCH_SALE_PRICE_YN,'Y',EXP.SAL_ITEM_QTY,DTL.ITEM_QTY) QTY,EXP.SAL_ITEM_QTY QTY1,nvl(BATCH_SALE_PRICE_YN,'N') BATCH_SALE_PRICE_YN FROM st_sal_hdr hdr, st_sal_dtl_exp EXP, st_sal_dtl dtl,mm_bin_location_lang_vw bin, mm_item_lang_vw mm,ST_ACC_ENTITY_PARAM WHERE hdr.module_id = '"+module_id+"' and HDR.REF_NO = '"+facility_opernum+"'  AND hdr.facility_id = dtl.facility_id  AND hdr.doc_no = dtl.doc_no AND hdr.doc_type_code = dtl.doc_type_code AND dtl.facility_id = EXP.facility_id AND dtl.doc_type_code = EXP.doc_type_code AND dtl.doc_no = EXP.doc_no AND dtl.doc_srl_no = EXP.doc_srl_no and BIN.STORE_CODE = EXP.STORE_CODE and BIN.BIN_LOCATION_CODE = EXP.BIN_LOCATION_CODE and BIN.LANGUAGE_ID = '"+locale+"'  and mm.item_code = dtl.item_code and mm.language_id = '"+locale+"' and dtl.facility_id='"+facility_id+"' order by dtl.doc_no, dtl.doc_srl_no";
*/
// Fine tuned Query for Incident No: OT-ICN31202 Sanjay
String SQL_DIRECT_CONS = "SELECT   dtl.bl_incl_excl_override_value bl_incl_excl_override_value, dtl.bl_incl_excl_override_reason, EXP.doc_no doc_no, EXP.doc_srl_no doc_srl_no, EXP.doc_type_code doc_type_code, EXP.store_code store_code,dtl.item_code item_code, EXP.batch_id batch_id, mm.short_desc item_desc, dtl.item_code,NVL ((SELECT short_name FROM am_trade_name_lang_vw WHERE language_id = '"+locale+"'AND trade_id = EXP.trade_id), trade_id) trade_name, bin.short_desc bin_desc, TO_CHAR (EXP.expiry_date_or_receipt_date, 'DD/MM/YYYY') expiry_date,DECODE (dtl.remarks,'', '', (SELECT mm.remarks_desc FROM mm_trn_remarks_lang_vw mm WHERE mm.trn_remarks_code = dtl.remarks AND mm.language_id = '"+locale+"')) remarks,DECODE (st_acc.batch_sale_price_yn, 'Y', EXP.sal_item_qty, dtl.item_qty) qty, EXP.sal_item_qty qty1,NVL (st_acc.batch_sale_price_yn, 'N') batch_sale_price_yn,EXP.trade_id trade_id1,EXP.bin_location_code bin_location_code1 FROM st_sal_hdr hdr,st_sal_dtl_exp EXP,st_sal_dtl dtl, mm_bin_location_lang_vw bin, mm_item_lang_vw mm, st_acc_entity_param st_acc WHERE hdr.facility_id = dtl.facility_id AND hdr.doc_no = dtl.doc_no AND hdr.doc_type_code = dtl.doc_type_code AND dtl.facility_id = EXP.facility_id AND dtl.doc_type_code = EXP.doc_type_code AND dtl.doc_no = EXP.doc_no AND dtl.doc_srl_no = EXP.doc_srl_no AND bin.store_code = EXP.store_code AND bin.bin_location_code = EXP.bin_location_code AND bin.language_id = '"+locale+"' AND mm.item_code = dtl.item_code AND mm.language_id = '"+locale+"' AND HDR.facility_id = '"+facility_id+"' AND hdr.module_id = '"+module_id+"' AND hdr.ref_no = '"+facility_opernum+"' AND st_acc.acc_entity_id = 'ZZ' ORDER BY dtl.doc_no, dtl.doc_srl_no";

//System.out.println( "sales query page "+SQL_DIRECT_CONS);

		pstmt=con.prepareStatement(SQL_DIRECT_CONS,ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
			rs =pstmt.executeQuery();


String SQL_PAT_DTLS="Select patient_id, encounter_id,patient_class from ot_post_oper_hdr where operating_facility_id='"+facility_id+"' and oper_num='"+oper_num+"'";


		pstmt1=con.prepareStatement(SQL_PAT_DTLS);
			rs1 =pstmt1.executeQuery();
			



 %>

<html>
<title><%= request.getParameter( "tit" )==null?"":(String)request.getParameter("tit") %></title>

	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
			<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script> 
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




	  <script>
function openNewDialogWindow(strVal,index,remarks){
  var remarks=encodeURIComponent(remarks); 

  var remarks_size='500';
window.showModalDialog('../../eOT/jsp/TextArea.jsp?heading='+encodeURIComponent(strVal)+'&remarks='+remarks+'&size='+remarks_size,window,"dialogHeight: 145px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;");
}

function closewindow()
 {
parent.window.close();
}
		</script>
	<body>

 	<form name='salesquery' id='salesquery'>
 
 <table  cellpadding='3' cellspacing='0' width='100%' align='center'>
						 <tr>
						<td nowrap class='columnHeaderCenter'>
						<fmt:message key="Common.item.label" bundle="${common_labels}"/>
						</td>
						<td  nowrap class='columnHeaderCenter'>
						 <fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/>
						</td>
						<td  nowrap class='columnHeaderCenter'>
						<fmt:message key="Common.BatchID.label" bundle="${common_labels}"/>
						</td>
						<td  nowrap class='columnHeaderCenter'>
						<fmt:message key="Common.TradeName.label" bundle="${common_labels}"/>
						</td>
					
						<td  nowrap class='columnHeaderCenter'>
						<fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></td>
						
						<td  nowrap class='columnHeaderCenter'>
						<fmt:message key="Common.SaleQuantity.label" bundle="${common_labels}"/></td>
						
						<td  nowrap class='columnHeaderCenter'>
						<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
					

					<td  nowrap class='columnHeaderCenter'>
						<fmt:message key="Common.Charge.label" bundle="${common_labels}"/></td>

					   </tr>



					   	<%int q=0;
						

						if(rs1 !=null && rs1.next())
						{
						encounter_id=checkForNull(rs1.getString("encounter_id"));
						patient_id=checkForNull(rs1.getString("patient_id"));
						patient_class=checkForNull(rs1.getString("patient_class"));
						}

						while(rs !=null && rs.next()){

							mm_item_code=checkForNull(rs.getString("item_code"));
							
							
							

							req_store_code=checkForNull(rs.getString("store_code"));
							item_desc=checkForNull(rs.getString("item_desc"));
							expiry_date=checkForNull(rs.getString("expiry_date"));
							batch_id=checkForNull(rs.getString("batch_id"));
							trade_name=checkForNull(rs.getString("trade_name"));
							bin_desc=checkForNull(rs.getString("bin_desc"));
							
							qty=checkForNull(rs.getString("qty"));
							qty1=checkForNull(rs.getString("qty1"));
						//	System.err.println("qty :" +qty);
						//	System.err.println("qty1 :" +qty1);
							remarks_dc=checkForNull(rs.getString("remarks"));
							sale_document_type=checkForNull(rs.getString("doc_type_code"));
							sale_document_no=checkForNull(rs.getString("Doc_no"));
							doc_srl_no=checkForNull(rs.getString("doc_srl_no"));
							batch_sale_price_yn=checkForNull(rs.getString("BATCH_SALE_PRICE_YN"));
							
							include_exclude=checkForNull(rs.getString("BL_INCL_EXCL_OVERRIDE_VALUE"));

							tmp_trade_id = checkForNull(rs.getString("trade_id1"));

							tmp_bin_location =	checkForNull(rs.getString("bin_location_code1"));
				 //added by DhanasekarV on 25/11/2010 against  issue IN025244



						 //modified by DhanasekarV on 25/11/2010 against  issue IN025244
							if((mm_item_code).equals(dup_item) && (sale_document_no).equals(dup_doc_no))
							{
						
							flag = false;

							}
							else
							{							
							dup_item=mm_item_code;
							dup_doc_no=sale_document_no;
							dup_batch_id = batch_id;							
							flag=true;

							}

//							System.err.println("eOT flag1 --> "+flag);
							if(("Y").equals(batch_sale_price_yn))flag=true;
							statement=con.prepareCall("{call ST_BL_GET_ITEM_CHARGE_DTLS (?,?,?,?,?,to_date(?,'dd/MM/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
							String sal_trn_type=""; 
								if(patient_class.equals("IP"))
									{
										sal_trn_type="I";
									}else if(patient_class.equals("OP"))
									{
									sal_trn_type="O";
									}else if(patient_class.equals("EM"))
									{
									sal_trn_type="E";
									}else if(patient_class.equals("DC"))
									{
									sal_trn_type="D";
									}else if(patient_class.equals("XT"))
									{
									sal_trn_type="R";
									}		
			statement.setString(1, facility_id);
			statement.setString(2, patient_id);
			statement.setString(3, "ST");
			statement.setString(4, encounter_id);
			statement.setString(5, sal_trn_type);
			statement.setString(6, com.ehis.util.DateUtils.getCurrentDate("DMY","en"));
			statement.setString(7, mm_item_code);
			statement.setString(8, req_store_code);
			statement.setInt(9, Integer.parseInt(qty));

			tmp_batch_id = tmp_trade_id+";"+batch_id+";"+expiry_date+";"+tmp_bin_location+";"+qty1;

		//	System.out.println("Sales query page tmp_batch_id "+tmp_batch_id);
			
			if(("Y").equals(batch_sale_price_yn))
			//statement.setString(10, batch_id);
			statement.setString(10, tmp_batch_id);  // Modified on 13/06/2012 as per sunil kvsk instructions viewconsumables hang on that page
			else statement.setString(10, ";");
			statement.registerOutParameter(11, Types.VARCHAR);
			statement.registerOutParameter(12, Types.VARCHAR);
			statement.registerOutParameter(13, Types.VARCHAR);
			statement.registerOutParameter(14, Types.VARCHAR);
			statement.registerOutParameter(15, Types.FLOAT);
			statement.registerOutParameter(16, Types.FLOAT);
			statement.registerOutParameter(17, Types.FLOAT);
			statement.registerOutParameter(18, Types.FLOAT);
			statement.registerOutParameter(19, Types.FLOAT);
			statement.registerOutParameter(20, Types.FLOAT);
			statement.registerOutParameter(21, Types.FLOAT);
			statement.registerOutParameter(22, Types.FLOAT);
			statement.registerOutParameter(23, Types.FLOAT);
			statement.registerOutParameter(24, Types.FLOAT);
			statement.registerOutParameter(25, Types.FLOAT);
			statement.registerOutParameter(26, Types.FLOAT);
			statement.registerOutParameter(27, Types.FLOAT);
			statement.registerOutParameter(28, Types.FLOAT);
			statement.registerOutParameter(29, Types.VARCHAR);
			statement.registerOutParameter(30, Types.FLOAT);
			statement.registerOutParameter(31, Types.VARCHAR);
			statement.registerOutParameter(32, Types.VARCHAR);
			statement.registerOutParameter(33, Types.VARCHAR);
			statement.registerOutParameter(34, Types.VARCHAR);
			statement.registerOutParameter(35, Types.VARCHAR);
			statement.registerOutParameter(36, Types.VARCHAR);
			statement.registerOutParameter(37, Types.VARCHAR);
			statement.registerOutParameter(38, Types.VARCHAR);
			statement.setString(39, "");
			statement.setString(40, "");
			statement.setString(41, "N"); //Internal Adjestment
           statement.setString(42, sale_document_type);
		   statement.setString(43, sale_document_no);
		   statement.setString(44, doc_srl_no);
		   //statement.setString(44, "1");
		   	statement.setString(45, "N"); //p_discharge_ind
			statement.registerOutParameter(46, Types.VARCHAR); //p_drug_penalty_str Changes done for JD-CRF-0170

			statement.execute();
			



					 total_pay=checkForNull(statement.getString(21),"0.0");
					 patient_pay=checkForNull(statement.getString(25),"0.0");
					 patient_paid=checkForNull(statement.getString(38),"0.0");
					// include_exclude=checkForNull(statement.getString(35),"E");
					 preapp_yn=checkForNull(statement.getString(36),"E");				
	                   %>
					   <tr>
					   <td  align='left' class='gridData' nowrap><%=item_desc%></td>
					   <td  align='left' class='gridData' nowrap><%=expiry_date%></td>
					   <td  align='left' class='gridData' nowrap><%=batch_id%></td>
					   <td  align='left' class='gridData' nowrap><%=trade_name%></td>
					   <td  align='left' class='gridData' nowrap><%=bin_desc%></td>
					   <td  align='left' class='gridData' nowrap><%=qty1%></td>
					   <td  align='left' class='gridData' nowrap><a class='gridLink' style="cursor:pointer;color:blue;" onclick="openNewDialogWindow('<%=remarks_label%>','<%=q%>','<%=remarks_dc%>')"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></td>

						<%
							if(flag==true)
						{%>
						<td  class=gridData><B><font color='Indigo' ><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eOT.Payable.label" bundle="${or_labels}"/>:&nbsp;<%=total_pay%></font>&nbsp;&nbsp;<font color='crimson' ><fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/>:&nbsp;<%=patient_pay%></font>&nbsp;&nbsp;<font color='green' ><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/>:&nbsp;<%=patient_paid%></font><font color='Indigo'><fmt:message key="eOT.Included.Label" bundle="${ot_labels}"/>&nbsp;
						   
						<%    	
  if(include_exclude.equals("I")) {%>
					   <img width=15px src='../../eCommon/images/enabled.gif'></img>
					 <%  }else {%>
						    <img width=15px  src='../../eCommon/images/disabled.gif'></img>
					 <% }%>
				   
				   <fmt:message key="eOT.ApprovalRequired.Label" bundle="${ot_labels}"/>&nbsp

				<%    if(preapp_yn.equals("Y")) {%>
					   <img width=15px src='../../eCommon/images/enabled.gif'></img>
					   <%}else {%>
						  <img  width=15px src='../../eCommon/images/disabled.gif'></img>
				<%	}
						%>

						   </B></td>
						   <%}
					//Modified By DhanasekarV On 19/11/2010
						   else 
						{
					  %>
						<td  class=gridData><B><font color='Indigo' ><fmt:message key="eOT.SameBatchLegend.Label" bundle="${ot_labels}"/></B></td>

						<% } %>


					   </tr>
					   <% q++;
					   }
					   
						%>

					  <tr>
					  <td  align='right' width="25%" colspan='8' nowrap>
						<input type='button' name='close' id='close' class='button' value="<fmt:message key='Common.close.label' bundle='${common_labels}'/>" onClick='closewindow();' >
							</td>
							</tr>
					  </table>
	</form>
	</body>
</html>
<%
}catch ( Exception e ) {
	e.printStackTrace() ;
}finally {
	try{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null) 
			ConnectionManager.returnConnection(con,request);
	   }catch(Exception es){es.printStackTrace();}
}
%>

