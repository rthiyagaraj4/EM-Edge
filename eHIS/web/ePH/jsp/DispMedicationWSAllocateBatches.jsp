<!DOCTYPE html>

  <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eST.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<!-- This will be used on click of show batches button -->

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

   <script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../ePH/js/DispMedication.js"></script>
	<script language="JavaScript" src="../../ePH/js/DispMedicationAllStages.js"></script>
	

</head>
<body onMouseDown="" onKeyDown="lockKey()">
<%
	String retval = request.getParameter("retval");

	String identity				= request.getParameter("identity")==null?"":request.getParameter("identity") ;
	String drug_code_main		= request.getParameter("drug_code");
	String drug_desc_main		= request.getParameter("drug_name");
	String rf_name				= request.getParameter("fluid_name");
	String rf_id				= request.getParameter("rf_id");	
	String rf_drug_flag			= request.getParameter("rf_drug_flag")==null?"":request.getParameter("rf_drug_flag");
	String uom			        = request.getParameter("uom");
	String passed_item_code		= request.getParameter("passed_item_code");
	String order_id			    = request.getParameter("order_id")==null?"":request.getParameter("order_id");//added for MMS-KH-CRF-0038
	String patient_id			    = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");//added for MMS-KH-CRF-0038
	//if(identity==null)identity="";	
	//if(rf_drug_flag==null)rf_drug_flag="";
	String order_line_no		= request.getParameter("order_line_no");	
	String tot_num_of_drugs		= request.getParameter("tot_num_of_drugs");
	String	bean_id				=	"DispMedicationBean" ;
	String	bean_name			=	"ePH.DispMedicationBean";
	DispMedicationBean bean		= (DispMedicationBean)getBeanObject( bean_id, bean_name, request);	
	bean.setLanguageId(locale);

	String bean_id_3				= "DispMedicationAllStages" ;
	String bean_name_3				= "ePH.DispMedicationAllStages";
	DispMedicationAllStages bean_3  = (DispMedicationAllStages)getBeanObject( bean_id_3, bean_name_3, request ) ;

	if(rf_drug_flag.equals("RF")){	// Reconst Fluid
		drug_code_main = rf_id;
		drug_desc_main = rf_name;
	}
	Hashtable ws_allocated_qty = new Hashtable();
	String act_patient_episode_type = "";
	String act_patient_class = ""; //added for MMS-KH-CRF-0038 - start
	String scan_count_required_yn = "";
	String alert_required_yn = "";
	String remarks_required_yn = "";
	act_patient_episode_type     =  bean_3.getEncounterPatientClass(bean.getEncounterID(), patient_id);//Added for MMS-DM-CRF-0170
			//System.err.println("act_patient_episode_type@@@==="+act_patient_episode_type);
			if(act_patient_episode_type.equals("I"))
                act_patient_class  ="IP";
			else if(act_patient_episode_type.equals("O"))
                act_patient_class  ="OP";
			else if(act_patient_episode_type.equals("E"))
                act_patient_class  ="EM";
			else if(act_patient_episode_type.equals("D"))
                act_patient_class  ="DC";
			else if(act_patient_episode_type.equals("R"))
                act_patient_class  ="XT";
				  ArrayList scanCountSetup    = bean.getScanCountReqForPatientClass(act_patient_class,"DISPENSE_MEDICATION");
				  if(scanCountSetup.size()>0){
					  scan_count_required_yn = (String)scanCountSetup.get(0);
					  alert_required_yn      = (String)scanCountSetup.get(1);
					  remarks_required_yn    = (String)scanCountSetup.get(2);
				}
//added for MMS-KH-CRF-0038 end

	//if((bean.getHTWSAllocateBatches()).size()==0){
		bean.setWSAllocateBatches(retval,drug_code_main,drug_desc_main,order_line_no,rf_drug_flag);		
		bean.setDrugDetails(drug_code_main,drug_desc_main);
	//}
	ws_allocated_qty = bean.getWSAllocatedQty();	
	Hashtable ht_ws_fluid_allocate_batches = bean.getHTWSFluidAllocateBatches();

	if(ht_ws_fluid_allocate_batches==null){
		ht_ws_fluid_allocate_batches = new Hashtable();
	}

	int iNoOfDecimals				= 0;

	boolean bDecimalAllowed			= bean_3.getDecimalAllowedYN(drug_code_main);

	if(bDecimalAllowed)
		iNoOfDecimals = bean_3.getINoOfDecimals();
	int iMaxLength					= 5+iNoOfDecimals;
	int recCount=1;
%>
<form name="frmDispMedicationWSAllocateBatches" id="frmDispMedicationWSAllocateBatches">

	<tr><!-- added for MMS-KH-CRF-0038 - start -->
		<%

		if(bean.getBarcode_Scan_YN().equals("Y")){ %>
		<td  width="20%"  style='text-align:right;'><font style='font-size:10;vertical-align: text-top;'>Barcode</font> <input type="text" class='fields' name="barcode_id" id="barcode_id" style="text-align:right"  onkeydown="if (event.keyCode==13) {validateBarcodeAllocateBatch(event,this,'<%=alert_required_yn%>','<%=bean.getDispStage()%>','<%=order_id%>','<%=order_line_no%>','<%=drug_code_main%>','<%=act_patient_class%>','<%=remarks_required_yn%>','<%=bean.getEncounterID()%>','<%=patient_id%>')}" maxlength="100" size="80">

		</td>
		<%}
		%>
		</tr><!-- added for MMS-KH-CRF-0038 - end -->

	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1" id="wsallocatebatchestable">		
	<%
		Hashtable ht_ws_allocate_batches = bean.getHTWSAllocateBatches();
		Hashtable ht_ordered_qty		 = bean.getOrderedQty();	
		int drugItemCount = 0;
		int batch_count = 0;
		int alloc_qty_count = 1;

       HashMap IssueUOMAndBaseUOM		=	new HashMap();
	   Double base_to_disp_uom_equl    =	0.0;
	   Double base_to_def_uom_equl	   =    0.0;
	   Double conv_factor              =    0.0;

       if(!identity.equals("preview")){
         IssueUOMAndBaseUOM		=	(HashMap)bean_3.getStoreDfltIssueUOMAndBaseUOM(bean.getDispLocnCode(),passed_item_code);
		 base_to_disp_uom_equl  =	bean_3.getEqulValue ( passed_item_code, (String)IssueUOMAndBaseUOM.get("BASE_UOM"), uom);
		 base_to_def_uom_equl   =   bean_3.getEqulValue ( passed_item_code, (String)IssueUOMAndBaseUOM.get("BASE_UOM"),(String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM"));
		 conv_factor            =   (bean_3.lcm( base_to_disp_uom_equl,base_to_def_uom_equl))/base_to_disp_uom_equl;

	   }


		for(int ii=1;ii<=Integer.parseInt(tot_num_of_drugs);ii++){

			ArrayList arrList = new ArrayList();
			String item_code = "";
			String drug_code = "";
			String drug_name = "";
			String ordered_qty ="";
			String fluidoringredient = "Ingredient";
			if(ht_ws_allocate_batches.get(ii+"")!=null){		
			
				 arrList   = (ArrayList)ht_ws_allocate_batches.get(ii+"");
				 if(arrList.size()>0){

					 item_code = (String)arrList.get(0);
					 drug_code = (String)arrList.get(2);
					 drug_name = (String)arrList.get(3);
					 if(drug_code_main !=null && !drug_code_main.equals(drug_code))
						continue;
					 ++drugItemCount;

					 if((ii+"").equals("1")){
					   fluidoringredient = "Fluid";

					}
				 }
			}
    
    		ordered_qty = (String)ht_ordered_qty.get(ii+"");
			ArrayList alloc_qty =	(ArrayList)ws_allocated_qty.get(item_code+drug_code);

%>
			<input type="hidden" name="ordered_qty<%=drugItemCount%>" id="ordered_qty<%=drugItemCount%>" value="<%=ordered_qty%>">
<%
			if(arrList.size()>0){
				if(identity.equals("preview")&& alloc_qty == null  ){
					continue;
				}
		%>
			<tr>

				<td  colspan="8" style="background:#FDE6D0;font-size:10"><fmt:message key="ePH.BatchDetailsfor.label" bundle="${ph_labels}"/> 	<B><%=drug_name%></B></td>
				</tr>
				<tr>
				<input type="hidden" name="drug_code<%=drugItemCount%>" id="drug_code<%=drugItemCount%>" value="<%=drug_code%>">
				<input type="hidden" name="item_code<%=drugItemCount%>" id="item_code<%=drugItemCount%>" value="<%=item_code%>">
				<td  colspan="8" style="background:#FDE6D0;font-size:10"><B><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/> : <%=item_code%></B></td>
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
			<%
				if(!identity.equals("preview")){
			%>
				<td class="TDSTYLE1">
					<B><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></B>
				</td>
			<%
				}
			%>
			</tr>
			<%
				int rowCount = 1;
				String classvalue="";

				if((arrList.size() /15) >3)
				{
			%>
			<script language="javascript">
					alert(getMessage("PH_NOT_MORE_THAN_THREE_BATCHES","PH"));
			</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

			<%
					return;
				}

				for (int i=0;i<arrList.size();i=i+15){


					if ( rowCount % 2 == 0 )
						classvalue = "QRYODD" ;
					else
						classvalue = "QRYEVEN" ;
							   
					String batch_id	        = (String)arrList.get(i+1);						
					//String drug_desc      = (String)arrList.get(i+3);
//					String item_desc        = (String)arrList.get(i+4);
//					String disp_locn        = (String)arrList.get(i+5);
//					String disp_store       = (String)arrList.get(i+6);
					String expiry_date      = (String)arrList.get(i+7);
					//String bin_locn_code  = (String)arrList.get(i+8);
					String bin_locn_desc    = (String)arrList.get(i+9);						
					String trade_id			= (String)arrList.get(i+10);
					String trade_name		= (String)arrList.get(i+11);
					String manufacturer_id  = arrList.get(i+12) == null?"":(String)arrList.get(i+12);
					String manufacturer_name= arrList.get(i+13) == null?"":(String)arrList.get(i+13);
					       manufacturer_name=  java.net.URLDecoder.decode(manufacturer_name,"UTF-8");
					String avail_qty        = (String)arrList.get(i+14);

					String barcode_id =bean.getBarcodeID((String)arrList.get(i+0),(String)arrList.get(i+5),batch_id,com.ehis.util.DateUtils.convertDate(expiry_date,"DMY","en",locale));

			

					String sOnBlurValidateion = ""; 
//					if(tot_num_of_drugs.equals("1"))
//					{
						sOnBlurValidateion="onBlur=\"if(validateNumbers(this,4,'"+iNoOfDecimals+"')){validateWSAllocatedQty('"+avail_qty+"',this,'"+ordered_qty+"','"+conv_factor+"','"+iNoOfDecimals+"');}\"";
//					}


					if(alloc_qty !=null && identity.equals("preview") && (alloc_qty.size()<=(rowCount-1))){				
						continue;
					}
			%>
			<tr>
				<td class="<%=classvalue%>" style="font-size:10">
					<%=com.ehis.util.DateUtils.convertDate(expiry_date,"DMY","en",locale)%>
					<input type="hidden" name="expiry_date<%=drugItemCount%><%=rowCount%>" id="expiry_date<%=drugItemCount%><%=rowCount%>" value="<%=expiry_date%>">
				</td>
				<td class="<%=classvalue%>" style="font-size:10">
					<%=batch_id%>
					<input type="hidden" name="batch_id<%=drugItemCount%><%=rowCount%>" id="batch_id<%=drugItemCount%><%=rowCount%>" value="<%=batch_id%>">
				</td>
				<td class="<%=classvalue%>" style="font-size:10">&nbsp;<%=trade_name%>
					<input type="hidden" name="trade_id<%=drugItemCount%><%=rowCount%>" id="trade_id<%=drugItemCount%><%=rowCount%>" value="<%=trade_id%>">
				</td>
				<td class="<%=classvalue%>" style="font-size:10">&nbsp;<%=manufacturer_name%>
					<input type="hidden" name="manufacturer_id<%=drugItemCount%><%=rowCount%>" id="manufacturer_id<%=drugItemCount%><%=rowCount%>" value="<%=manufacturer_id%>">
				</td>
				<td class="<%=classvalue%>" style="font-size:10">
					<%=bin_locn_desc%>
					<input type="hidden" name="bin_locn_code<%=drugItemCount%><%=rowCount%>" id="bin_locn_code<%=drugItemCount%><%=rowCount%>" value="">
				</td>
				<td class="<%=classvalue%>" style="font-size:10">
					<%=avail_qty%>
					<input type="hidden" name="avail_qty<%=drugItemCount%><%=rowCount%>" id="avail_qty<%=drugItemCount%><%=rowCount%>" value="<%=avail_qty%>">
					
					<input type="hidden" name="barcode_id<%=drugItemCount%><%=rowCount%>" id="barcode_id<%=drugItemCount%><%=rowCount%>" value="<%=barcode_id%>"><!-- added for MMS-KH-CRF-0038 -->
					
					<input type="hidden" name="batch_id_manual_<%=drugItemCount%><%=rowCount%>" id="batch_id_manual_<%=drugItemCount%><%=rowCount%>" value=""><!-- added for MMS-KH-CRF-0038 -->

				</td>
				<%
					if(ws_allocated_qty.isEmpty()){
				%>
					<td class="<%=classvalue%>" style="font-size:10">
						<input type="text" name="alloc_qty<%=drugItemCount%><%=rowCount%>" id="alloc_qty<%=drugItemCount%><%=rowCount%>" onKeyPress="if(event.keyCode!=13) {return allowValidNumber(this,event,4,<%=iNoOfDecimals%>);}else{return false;}"  value="" size="6" maxlength="<%=iMaxLength%>" class="number" <%=sOnBlurValidateion%>>
					</td>
					<td class="<%=classvalue%>">
						<input type="checkbox" name="chkSelect<%=drugItemCount%><%=rowCount%>" id="chkSelect<%=drugItemCount%><%=rowCount%>" value="E" checked>
					</td>
				<%
					}else{
						if(alloc_qty !=null && identity.equals("preview") && alloc_qty.size()>(rowCount-1)){					
				%>				
					<td class="<%=classvalue%>" style="font-size:10" >
						<%=alloc_qty.get(rowCount-1)%>
					</td>
				<%
						}else if(alloc_qty!=null && !identity.equals("preview")){
							String str_alloc_qty="";
							if(alloc_qty.size()>(rowCount-1)){
								str_alloc_qty=(String)alloc_qty.get(rowCount-1);
								try{ Double.parseDouble(str_alloc_qty);}
								catch(Exception e){str_alloc_qty = "";}

							}
				%>
					<td class="<%=classvalue%>" style="font-size:10">
						<input type="text" name="alloc_qty<%=drugItemCount%><%=rowCount%>" id="alloc_qty<%=drugItemCount%><%=rowCount%>" value="<%=str_alloc_qty%>" onKeyPress="if(event.keyCode!=13) {return allowValidNumber(this,event,4,<%=iNoOfDecimals%>);}else{return false;}"  size="6" maxlength="<%=iMaxLength%>" class="number" <%=sOnBlurValidateion%>>
					</td>
					<td class="<%=classvalue%>">
						<input type="checkbox" name="chkSelect<%=drugItemCount%><%=rowCount%>" id="chkSelect<%=drugItemCount%><%=rowCount%>" value="E" checked>
					</td>		
				<%
						}else{
				%>
					<td class="<%=classvalue%>" style="font-size:10">
						<input type="text" name="alloc_qty<%=drugItemCount%><%=rowCount%>" id="alloc_qty<%=drugItemCount%><%=rowCount%>" value="" onKeyPress="if(event.keyCode!=13) {return allowValidNumber(this,event,4,<%=iNoOfDecimals%>);}else{return false;}"  size="6" maxlength="<%=iMaxLength%>" class="number" <%=sOnBlurValidateion%>>
					</td>
					<td class="<%=classvalue%>">
						<input type="checkbox" name="chkSelect<%=drugItemCount%><%=rowCount%>" id="chkSelect<%=drugItemCount%><%=rowCount%>" value="E" checked>
					</td>				
				<%
						}
					}
				%>
				</tr>
			<%
					rowCount++;
					batch_count++;
				}					
			%>
				<input type="hidden" name="row_count<%=alloc_qty_count%>" id="row_count<%=alloc_qty_count%>" value="<%=rowCount%>">
		<%
				alloc_qty_count++;
			}
		%>

		<%
		}
		%>
	<input type="hidden" name="inner_count" id="inner_count" value="<%=batch_count%>">
	<input type="hidden" name="outer_count" id="outer_count" value="<%=drugItemCount%>">

	</table>

	
	<%

		if(ht_ws_fluid_allocate_batches.size()>0){
			for(int i=1;i<=Integer.parseInt(tot_num_of_drugs);i++){
				if(ht_ws_fluid_allocate_batches.containsKey(i+"")){
					ArrayList arr_list = (ArrayList)ht_ws_fluid_allocate_batches.get(i+"");
					String item_code = (String)arr_list.get(0);
					String drug_desc = (String)arr_list.get(3);		
	%>
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1" id="wsfluidallocatebatchestable">		
		<tr>
			<td  colspan="8" style="background:#FDE6D0;font-size:10"><fmt:message key="ePH.BatchDetailsfor.label" bundle="${ph_labels}"/> 	<B><%=drug_desc%></B>(<b><fmt:message key="ePH.Ingredient.label" bundle="${ph_labels}"/>)</b></td>
		</tr>
		<tr>
			<td  colspan="8" style="background:#FDE6D0;font-size:10"><B><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/> : <%=item_code%></B></td>
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
			<%
				if(!identity.equals("preview")){
			%>
				<td class="TDSTYLE1">
					<B><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></B>
				</td>
			<%
				}
			%>
			</tr>
			<%		
				String classvalue="";
				recCount = 1;				
				for (int j=0;j<arr_list.size();j=j+16){

					if ( recCount % 2 == 0 )
						classvalue = "QRYODD" ;
					else
						classvalue = "QRYEVEN" ;

		   				   item_code		= (String)arr_list.get(j);
					String batch_id			= (String)arr_list.get(j+1);						
						   drug_desc		= (String)arr_list.get(j+3);
//					String item_desc		= (String)arr_list.get(j+4);
//					String disp_locn		= (String)arr_list.get(j+5);
//					String disp_store		= (String)arr_list.get(j+6);
					String expiry_date      = (String)arr_list.get(j+7);
//					String bin_locn_code    = (String)arr_list.get(j+8);					
					String bin_locn_desc    = (String)arr_list.get(j+9);						
//					String trade_id			= (String)arr_list.get(j+10);					
					String trade_name		= (String)arr_list.get(j+11);
//					String manufacturer_id  = (String)arr_list.get(j+12);					
					//String manufacturer_name= (String)arr_list.get(j+13);
					String manufacturer_name=  java.net.URLDecoder.decode(((String)arr_list.get(j+13)),"UTF-8");
					String avail_qty		= (String)arr_list.get(j+14);
					String alloc_qty		= (String)arr_list.get(j+15);
					if(rf_drug_flag.equals("RF")&&alloc_qty.equals(""))
						alloc_qty =request.getParameter("order_qty");
			%>
				<tr>
				<td class="<%=classvalue%>" style="font-size:10">
					<%=com.ehis.util.DateUtils.convertDate(expiry_date,"DMY","en",locale)%>					
				</td>
				<td class="<%=classvalue%>" style="font-size:10">
					<%=batch_id%>
				</td>
				<td class="<%=classvalue%>" style="font-size:10">&nbsp;<%=trade_name%>
				</td>
				<td class="<%=classvalue%>" style="font-size:10">&nbsp;<%=manufacturer_name%>
				</td>
				<td class="<%=classvalue%>" style="font-size:10">
					<%=bin_locn_desc%>
				</td>
				<td class="<%=classvalue%>" style="font-size:10">
					<%=avail_qty%>
					<input type="hidden" name="available_qty" id="available_qty" value ="<%=avail_qty%>">
				</td>
				<%
					if(!identity.equals("preview")){
				%>
				<td class="<%=classvalue%>" style="font-size:10">					
					<input type="text" name="alloc_qty<%=recCount%>" id="alloc_qty<%=recCount%>" value="<%=alloc_qty%>" onKeyPress="if(event.keyCode!=13) {return allowValidNumber(this,event,4,<%=iNoOfDecimals%>);}else{return false;}"  size="6" maxlength="<%=iMaxLength%>" class="number" >
				</td>
				<td class="<%=classvalue%>">
					<input type="checkbox" name="chkSelect<%=recCount%>" id="chkSelect<%=recCount%>" value="E" checked>
				</td>	
			<%
					}else{
			%>
				<td class="<%=classvalue%>" style="font-size:10">					
					<%=alloc_qty%>
				</td>
			<%
					}
				recCount++;
				}
			%>
	</table>
	<%			}
			}
		}
	%>	
	<input type="hidden" name="alloc_qty_count" id="alloc_qty_count" value="<%=alloc_qty_count%>">
	<input type="hidden" name="drug_item_count" id="drug_item_count" value="<%=drugItemCount%>">
	<input type="hidden" name="rf_drug_flag" id="rf_drug_flag" value="<%=rf_drug_flag%>">
	<input type="hidden" name="rec_count" id="rec_count" value="<%=recCount%>">
	<input type="hidden" name="conv_factor" id="conv_factor" value="<%=conv_factor%>">
	<input type="hidden" name="no_decimals_allowed" id="no_decimals_allowed" value="<%=iNoOfDecimals%>">
</form>
</body>
</html>

<%
putObjectInBean(bean_id,bean,request);
%>

