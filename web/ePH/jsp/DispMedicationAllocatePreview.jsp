<!DOCTYPE html>

  <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//endss
		String locale			= (String)session.getAttribute("LOCALE");

		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../ePH/js/DispMedicationAllStages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title><fmt:message key="ePH.PreviewAllocation.label" bundle="${ph_labels}"/></title>
	</head>
	<!-- <body topmargin="0"> -->
	<body onMouseDown="" onKeyDown="lockKey()" topmargin="0">
		<form name="DispMedicationAllocatePreview" id="DispMedicationAllocatePreview" >
<%
			try{
			String	bean_id			=	"DispMedicationAllStages" ;
			String	bean_name		=	"ePH.DispMedicationAllStages";
			
			DispMedicationAllStages bean = (DispMedicationAllStages)getBeanObject( bean_id, bean_name,request ) ;
			bean.setLanguageId(locale);

			String	bean_id_1		=	"DispMedicationBean" ;
			String	bean_name_1		=	"ePH.DispMedicationBean";
			
			DispMedicationBean bean_1	= (DispMedicationBean)getBeanObject( bean_id_1, bean_name_1,request);
			bean_1.setLanguageId(locale);

			String facility_id	= (String) session.getValue("facility_id");
			String patient_id	= request.getParameter("patient_id");
			String order_id		= request.getParameter("order_id");
			String chosen_drug	= request.getParameter("chosen_drug");
			String source		= request.getParameter("source");
			String taper, show_remarks, taper_disable;

			if (order_id==null)		order_id	="";
			if (chosen_drug==null)	chosen_drug	="";
			if (source==null)		source	="";

			String order_line_no	=	"";
			String drug_code		=	"";
			String drug_name		=	"";
			
			String end_date			=	"";
			String pres_qty			=	"";
			String qty_uom			=	"";
			String qty_uom_disp		=	"";
			String alt_drug_code	=	"";
			String alt_drug_desc	=	"";
			String drug_color		=	"";
			String style			=	"";
			String strength_value	=	"";
			String strength_uom		=	"";
			String strength_uom_disp=	"";
			HashMap pack_dtls		=	null;	
			String uom				=	""; 
			
			boolean qty_found		=	false;
			double	tot_qty			=	0;
			ArrayList	colors		=	new ArrayList();
			colors.add("#FF0000");
			colors.add("#669900");
			colors.add("#FF9966");
			colors.add("#6699CC");
			colors.add("#FF0000");
			colors.add("#669900");
			colors.add("#FF9966");
			colors.add("#6699CC");
			colors.add("#FF0000");
			colors.add("#669900");
			colors.add("#FF9966");
			colors.add("#6699CC");

			ArrayList result		=	null;
			ArrayList orderLineDtls	=	new ArrayList();
			String disp_level	    = bean_1.getDispLevelValue();

			ArrayList alOrderIds = new ArrayList();
			ArrayList tmpResult  = new ArrayList();

			if(bean_1.getAlTrxOrderIds()!=null)
			{
				alOrderIds = bean_1.getAlTrxOrderIds();
			}


			if(disp_level.equals("P")) {
				//order lines of all orders
				result			= bean_1.getOrders(patient_id.trim());

				if(bean_1.getCriteriaOrderType()!=null && (bean_1.getCriteriaOrderType().equals("ALL") || bean_1.getCriteriaOrderType().equals("CDR"))) // CDR Condition Added for ML-MMOH-CRF-0435 [IN:057357]
				{
					if(alOrderIds.size()>0)
					{
						for(int i=0;i<result.size();i=i+11) {		//10 ->11 for SKR-SCF-0330 ICN 29789 //11->13 RUT-CRF-0069 ICN29607 //Modified for RUT-CRF-0088 [IN036978]  13 ->11 //IN 44141
							if(alOrderIds.contains(result.get(i+1)))
							{
								for(int j=i;j< i+11;j++)	//10 ->11 for SKR-SCF-0330 ICN 29789 //11->13 RUT-CRF-0069 ICN29607	//Modified for RUT-CRF-0088 [IN036978]  13 ->11 //IN 44141
									tmpResult.add(result.get(j));
							}
						}
					}
					result = tmpResult;
				}
				ArrayList tmp	=	new ArrayList();
			
				for(int i=0;i<result.size();i=i+11) {		 //10 ->11 for SKR-SCF-0330 ICN 29789 //11->13 RUT-CRF-0069 ICN29607	//Modified for RUT-CRF-0088 [IN036978]  13 ->11 //IN 44141
					tmp = (ArrayList)bean_1.getOrderLineDetails(patient_id,(String)result.get(i+1));
					if(tmp.size()!=0) {
						orderLineDtls.add((String)result.get(i+1));
						orderLineDtls.add((String)result.get(i+3));
						orderLineDtls.add((String)result.get(i+4));
					
					for(int j=0; j<tmp.size(); j++)
						orderLineDtls.add(tmp.get(j));
					}
				}
			}
			else {
				orderLineDtls = (ArrayList)bean_1.getOrderLineDetails(patient_id,order_id);
			}

			String disp_stage		=	bean_1.getDispStage();
			String module_id	    =	bean.getModuleId();
/*
			if(module_id.equals("1")) {
				//width_1	=	"50%";
				//width_2	=	"25%";
				//width_3	=	"25%";
			}
			else {
				//width_1	=	"61%";
				//width_2	=	"15%";
				//width_3	=	"19%";
			}*/

%>
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
				<tr>
					<td class= "COLUMNHEADERCENTER" ><fmt:message key="ePH.Drug/ItemDesc.label" bundle="${ph_labels}"/></td>
					<td class= "COLUMNHEADERCENTER" ><fmt:message key="ePH.AllocatedQuantity.label" bundle="${ph_labels}"/></td>
					<td class= "COLUMNHEADERCENTER" ><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
					<td class= "COLUMNHEADERCENTER" ><fmt:message key="ePH.TradeName/ManufacturerName.label" bundle="${ph_labels}"/></td>
					<td class= "COLUMNHEADERCENTER" ><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></td>
				</tr>
<%
				String classvalue			=	"";
				int recCount				=	1;
				//String strMulti				=	"";
				ArrayList stock_opt			=	new ArrayList();
				//String image				=	"";
				//String alt_strength_value	=	"";
				//String alt_strength_uom		=	"";
				//float  prod_qty				=  0.0f;
				for(int i=0;i<orderLineDtls.size(); i++){

					if ( recCount % 2 == 0 )
						classvalue = "QRYODD" ;
					else
						classvalue = "QRYEVEN" ;

					if(disp_level.equals("P") && ((String)orderLineDtls.get(i)).startsWith("PH")) {
						order_id		=	(String)orderLineDtls.get(i);
						//ordered_by	=	(String)orderLineDtls.get(++i);
									  i = i+2;
					//	location		=	(String)orderLineDtls.get(++i);
						++i;
					}

					
					stock_opt		=	new ArrayList();
					//image			=	"";
					tot_qty			=	0;
					//onClick			=	"";
					
					//allergy		=	(String)orderLineDtls.get(i);
								 i	=	i+2;
					//exceed_dose	=	(String)orderLineDtls.get(++i);
					//duplicate		=	(String)orderLineDtls.get(++i);
					drug_code		=	(String)orderLineDtls.get(++i);
					drug_name		=	(String)orderLineDtls.get(++i);
								i	=	i+2;
					//dosage_dtls	=	(String)orderLineDtls.get(++i);              
					//start_date	=	(String)orderLineDtls.get(++i);
					end_date		=	(String)orderLineDtls.get(++i);
					pres_qty		=	(String)orderLineDtls.get(++i);
					qty_uom			=	(String)orderLineDtls.get(++i);
					qty_uom_disp	=	(String)orderLineDtls.get(++i);
					order_line_no	=	(String)orderLineDtls.get(++i);
					i	=	i+4;
					//generic_id	=	(String)orderLineDtls.get(++i);
					//generic_name	=	(String)orderLineDtls.get(++i);
					//dosage_details=	(String)orderLineDtls.get(++i);
					//bms_qty		=	(String)orderLineDtls.get(++i);
					i	=	i+6;
					//duplicate_yn	=	(String)orderLineDtls.get(++i);
					//min_dose_dtls	=	(String)orderLineDtls.get(++i);
					i	=	i+2;
					strength_value	=	(String)orderLineDtls.get(++i);
					strength_uom	=	(String)orderLineDtls.get(++i);
					strength_uom_disp	=	(String)orderLineDtls.get(++i);
					if(module_id.equals("2")) {
						StringTokenizer st	=	new StringTokenizer((String)orderLineDtls.get(++i),"|");
						while(st.hasMoreTokens()){
							stock_opt.add((String)st.nextToken());
						} 
					}
					i=i+30;//changed 26 to 27 for Bru-HIMS-CRF-093-DD1[IN047223] //changed from i+24 to i+26 for dischargeIND, encounter_id 25-->26 for JD-CRF-0179 [IN:041211] // 27 --> 28 for Bru-HIMS-CRF-414- ML-BRU-SCF-1454 [IN:052271] --> 30 for  HSA-CRF-0138 [IN:048414] & Bru-HIMS-CRF-080

					/* Commented for RUT-CRF-0088 [IN036978] //IN 44141
					taper_order_yn 					=	(String)orderLineDtls.get(++i);// RUT-CRF-0069 ICN29607		
					taper_order_id					=	(String)orderLineDtls.get(++i);//RUT-CRF-0069 ICN29607
					taper_order_line_num					=	(String)orderLineDtls.get(++i);//RUT-CRF-0069 ICN29607*/

					if(end_date.length() >=10)
					end_date		=	end_date.substring(0,10);

					if(strength_value!=null && !strength_value.equals("") && Float.parseFloat(strength_value) <1)
						strength_value = Float.parseFloat(strength_value) +"" ;

					if(strength_value.equals("0")) {
						strength_value	=	"";
						strength_uom	=	"";
					}

					if(!chosen_drug.equals("") && !chosen_drug.equals(drug_code))
						continue;

					if(bean.checkHold(order_id,order_line_no)) 
						continue;

					ArrayList multi_drugs	=	bean.getMultiDrugs(patient_id,order_id,order_line_no);
					String qty				=	bean.getDrugQuantity(patient_id,order_id,order_line_no);
					if(!qty.equals(""))
						tot_qty				+=	Double.parseDouble(qty);

					//String alt_drug				=	bean.checkMultiStrength(drug_code);
					//	alt_drug_qty			=	"";
					ArrayList drug_detail		=	new ArrayList();
					ArrayList alt_drug_detail	=	new ArrayList();

					if(multi_drugs.size()	<	1	) {
						drug_detail					=	bean.getDrugDetail(patient_id,order_id,order_line_no);
					} 
				//if(!(taper_order_yn.equals("Y") && !taper_order_id.equals("") && !taper_order_line_num.equals(""))){ //Commented for RUT-CRF-0088 [IN036978] //IN 44141
					if(multi_drugs.size() < 1 && drug_detail.size()!=0) {
						String item_code	=	"";
						//String item_desc	=	"";
						String batch_id		=	"";
						String expiry_date	=	"";
						String alloc_qty	=	"";
						ArrayList	item_det	=	new ArrayList();
%>
						<tr id="tr_<%=recCount%>" >
							<td class="<%=classvalue%>" style="font-size:9;">
							<label style="<%=style%>" id="drug_desc<%=recCount%>">
							&nbsp;<%=drug_name%>&nbsp;<%=strength_value%>&nbsp;<%=strength_uom_disp%>
							</label>&nbsp;&nbsp; <!---/*bean.getUomDisplay(facility_id,strength_uom)*/-->
<%
							int	incr_1					=	0;	
							String prev_item_code		=	"";
							
							while(drug_detail.size() > incr_1 ) {
								item_code	=		(String)drug_detail.get(incr_1);
								incr_1		+=	10; //9->10 for MMS-SCF-0040 [IN:041888]
%>
								<br>
<%	
									if(!prev_item_code.equals(item_code)) {	
										prev_item_code	=	item_code;
%>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<label><%=item_code%></label>
<%	
									}
									else{	
%>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<label>&nbsp;</label>
			
<%	
									}
								}
%>	
								</td>
								<td class="<%=classvalue%>" style="font-size:9" ><%=pres_qty%>&nbsp;(<%=qty_uom_disp%>)
								<!--/*bean.getUomDisplay(facility_id,qty_uom)*/-->
<%
								int	qty_incr					=	0;	
								while(drug_detail.size() > qty_incr ) {	
									alloc_qty		=		(String)drug_detail.get(qty_incr+3);
									qty_incr		+=	10; //9->10 for MMS-SCF-0040 [IN:041888]
%>
									<br>
									<label style="font-size:9">&nbsp;&nbsp;<b><%=alloc_qty%></b>&nbsp;</label>
<%	
								}
%>
								</td>
								<td class="<%=classvalue%>" style="font-size:9">
<%	
								int	incr_3					=	0;		
								while(drug_detail.size() > incr_3 ) {	
									expiry_date	=		(String)drug_detail.get(incr_3+2);
									incr_3		+=	10;  //9->10 for MMS-SCF-0040 [IN:041888]
%>
									<br>	
									&nbsp;<%=com.ehis.util.DateUtils.convertDate(expiry_date,"DMY","en",locale)%>
<%	
								}
%>
								</td>
								<td class="<%=classvalue%>" style="font-size:9">
<%	
								int	incr_4					=	0;		
								while(drug_detail.size() > incr_4 ) {	
									item_code	=		(String)drug_detail.get(incr_4);
									batch_id	=		(String)drug_detail.get(incr_4+1);
									item_det	=	bean.getItemAndTradeName(item_code,batch_id);
									incr_4		+=	10; //9->10 for MMS-SCF-0040 [IN:041888]
									if(item_det.size()==2) {					
%>
										<br>
										&nbsp;&nbsp;<%=(String)item_det.get(0)%>&nbsp;/&nbsp;<%=(String)item_det.get(1)%>
<%		
									}
									else{	
%>	
										<br>&nbsp;			
<%
									}
								}	
%>
								</td>
								<td class="<%=classvalue%>" style="font-size:9">
<%	
								int	incr_5					=	0;		
								while(drug_detail.size() > incr_5 ) {	
									batch_id	=		(String)drug_detail.get(incr_5+1);	
									incr_5		+=	10;   //9->10 for MMS-SCF-0040 [IN:041888]
%>
									<br>
									&nbsp;<%=batch_id%>
<%	
								}
%>	
								</td>
							</tr>
<%	
						}	
						else if(multi_drugs.size() != 0) 	{
							String item_code	=	"";
							//String item_desc	=	"";
							String batch_id		=	"";
							String expiry_date	=	"";
							String alloc_qty	=	"";
							int			x		=	0;
							ArrayList	item_det	=	new ArrayList();
%>
							<tr id="tr_<%=recCount%>" >
							<td class="<%=classvalue%>" style="font-size:9;">
							<label style="<%=style%>" id="drug_desc<%=recCount%>">
								&nbsp;<%=drug_name%>&nbsp;<%=strength_value%>&nbsp;<%=strength_uom_disp%>
							</label><!--/*bean.getUomDisplay(facility_id,strength_uom)*/-->
<%
							for(int n=0; n<multi_drugs.size(); n+=5)	{ 
								alt_drug_code			=	(String)multi_drugs.get(n);
								alt_drug_desc			=	(String)multi_drugs.get(n+1);
								alt_drug_detail			=	bean.getAlternateDrugDetail(patient_id,order_id,order_line_no,alt_drug_code);
								drug_color				=	(String)colors.get(x++);
							
								int	incr_1					=	0;	
								String prev_item_code		=	"";
								while(alt_drug_detail.size() > incr_1 ) {
									item_code	=		(String)alt_drug_detail.get(incr_1);
									incr_1		+=	10; //9->10 for MMS-SCF-0040 [IN:041888]
%>
								<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<%
								if(!prev_item_code.equals(item_code)) {	
									prev_item_code	=	item_code;
%>
									<label style="color:<%=drug_color%>"><%=alt_drug_desc%></label>
									<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label style="color:<%=drug_color%>"><%=item_code%></label>
<%
								}
								else	{	
%>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<%
								}
							}	
						}
%>
						</td>
						<td class="<%=classvalue%>" style="font-size:9" >&nbsp;<%=pres_qty%>&nbsp;(<%=qty_uom_disp%>)
		<!--/*bean.getUomDisplay(facility_id,qty_uom)*/-->
<%	
						x		=	0;
						for(int n=0; n<multi_drugs.size(); n+=5)	{ 
							alt_drug_code			=	(String)multi_drugs.get(n);
							alt_drug_desc			=	(String)multi_drugs.get(n+1);
							alt_drug_detail			=	bean.getAlternateDrugDetail(patient_id,order_id,order_line_no,alt_drug_code);
							drug_color				=	(String)colors.get(x++);
							pack_dtls				=	bean.getPackSize(alt_drug_code);
							uom						=	(String)pack_dtls.get("STOCK_UOM");
							int	incr_2					=	0;
							while(alt_drug_detail.size() > incr_2 ) {
								alloc_qty	=		(String)alt_drug_detail.get(incr_2+3);
								incr_2		+=	10;//9->10 for MMS-SCF-0040 [IN:041888]
%>
								<br>
								<label style="font-size:9;color:<%=drug_color%>">&nbsp;<b><%=alloc_qty%>&nbsp;<%=bean.getUomDisplay(facility_id,uom)%> </b>&nbsp;</label>
<%	
							}
						}
%>
						</td>
						<td class="<%=classvalue%>" style="font-size:9">&nbsp;
<%	
						for(int n=0; n<multi_drugs.size(); n+=5)	{ 
							alt_drug_code			=	(String)multi_drugs.get(n);
							alt_drug_desc			=	(String)multi_drugs.get(n+1);
							alt_drug_detail			=	bean.getAlternateDrugDetail(patient_id,order_id,order_line_no,alt_drug_code);
							
							int	incr_3					=	0;	
							while(alt_drug_detail.size() > incr_3 ) {
								expiry_date	=		(String)alt_drug_detail.get(incr_3+2);
								incr_3		+=	10;//9->10 for MMS-SCF-0040 [IN:041888]
%>
								<br><%=expiry_date%>
<%	
							}	
						}
%>	
						</td>
						<td class="<%=classvalue%>" style="font-size:9">
<%	
						for(int n=0; n<multi_drugs.size(); n+=5)	{ 
							alt_drug_code			=	(String)multi_drugs.get(n);
							alt_drug_desc			=	(String)multi_drugs.get(n+1);
							alt_drug_detail			=	bean.getAlternateDrugDetail(patient_id,order_id,order_line_no,alt_drug_code);

							int	incr_4					=	0;
							while(alt_drug_detail.size() > incr_4 ) {	
								item_code	=		(String)alt_drug_detail.get(incr_4);
								batch_id	=		(String)alt_drug_detail.get(incr_4+1);
								item_det	=	bean.getItemAndTradeName(item_code,batch_id);	
								incr_4		+=	10; //9->10 for MMS-SCF-0040 [IN:041888]
								if(item_det.size()==2) {	
%>
									&nbsp;<br><%=(String)item_det.get(0)%>&nbsp;<%=(String)item_det.get(1)%>
<%	
								}
								else	{	
%>
									&nbsp;<br>
<%	
								}
							}
						}
%>
						&nbsp;</td>
						<td class="<%=classvalue%>" style="font-size:9">
<%		
						for(int n=0; n<multi_drugs.size(); n+=5)	{ 
							alt_drug_code			=	(String)multi_drugs.get(n);
							alt_drug_desc			=	(String)multi_drugs.get(n+1);
							alt_drug_detail			=	bean.getAlternateDrugDetail(patient_id,order_id,order_line_no,alt_drug_code);

							int	incr_5					=	0;	
							while(alt_drug_detail.size() > incr_5 ) {	
								batch_id	=		(String)alt_drug_detail.get(incr_5+1);	
								incr_5		+=	10;   //9->10 for MMS-SCF-0040 [IN:041888]
%>
								&nbsp;<br><%=batch_id%>
<%	
							}
						}
%>	
						&nbsp;</td>
					</tr>
<%	
				}
				//}		//Commented for RUT-CRF-0088 [IN036978] //IN 44141
				recCount++;
			}
%>
			</table>
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
				<tr>
					<td  class="white" align='right'>
						<input type="button" name="btnPreviewClose" id="btnPreviewClose" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick="window.close()" class="button">
					</td>
				</tr>
			</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="order_id" id="order_id" value="<%=order_id%>">
			<input type="hidden" name="qty_found" id="qty_found" value="<%=qty_found%>">
			<input type="hidden" name="tot_rec" id="tot_rec" value="<%=recCount%>">
		</form>
	</body>
</html>
<%
putObjectInBean(bean_id,bean,request);
putObjectInBean(bean_id_1,bean_1,request);
%>
<%
	}catch(Exception e){

      e.printStackTrace();
}

%>

