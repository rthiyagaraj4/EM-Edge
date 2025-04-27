<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title></title>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale = (String) session.getAttribute("LOCALE");
		
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js" ></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../ePH/js/Prescription_1.js"></script>
		<script language="Javascript" src="../../ePH/js/PrescriptionTest.js"></script>
		<!-- <script language="Javascript" src="../../eCommon/js/messages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->

	</head>
<%
try{
	String pat_class	=	request.getParameter("pat_class");
	String ord_status	=	request.getParameter("ord_status");
	String order_from	=	request.getParameter("order_from");
	String order_to		=	request.getParameter("order_to");
	String pract_id		=	request.getParameter("pract_id");
	String patient_id	=	request.getParameter("patient_id");
	String pat_id		=	request.getParameter("pat_id");
	String encounter_id	=	request.getParameter("encounter_id");
	String group_by		=	request.getParameter("group_by");
	String log_pract_id	=	request.getParameter("log_pract_id");
	//String module_id ="PH";
	int l=0;
	String sys_date=(String) com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
	String iv_prep_yn="";
	String rx_legend="";
	String rx_type		=	request.getParameter("rx_type");
	String from	= CommonBean.checkForNull(request.getParameter("from"));
	String to	= CommonBean.checkForNull(request.getParameter("to"));
	String drug_desc = CommonBean.checkForNull(request.getParameter("drug_desc"));
	String call_from = CommonBean.checkForNull(request.getParameter("call_from"));
	String checkcount = CommonBean.checkForNull(request.getParameter("checkcount"),"0");
	String pract_type = CommonBean.checkForNull(request.getParameter("pract_type"),""); //Added for ML-BRU-SCF-0958 [EMR IN:1835]
	l = Integer.parseInt(checkcount);
	String bean_id		= "@PrescriptionBean_1"+patient_id+encounter_id;
	String bean_name	= "ePH.PrescriptionBean_1";
	PrescriptionBean_1 bean		= (PrescriptionBean_1)getBeanObject( bean_id,bean_name,request );
	String presBean_id			= "PrescriptionBean"+patient_id+encounter_id;
	String presBean_name		= "ePH.PrescriptionBean";
	PrescriptionBean presBean		= (PrescriptionBean)getBeanObject(presBean_id, presBean_name, request );
	if(call_from.equals("SEARCH"))
		bean.copyPresClear();	//added by Manickavasagam J for SCF-7540
	bean.setLanguageId(locale);
	String facility_id					= (String) session.getValue("facility_id");
	String DMA_bean_id				=	"DispMedicationAllStages" ;     
	String DMA_bean_name		=	"ePH.DispMedicationAllStages";

	DispMedicationAllStages DMAbean = (DispMedicationAllStages)getBeanObject( DMA_bean_id, DMA_bean_name,request);
	DMAbean.setLanguageId(locale);

	String or_bean_name				= "eOR.OrderEntryBean";
	String or_bean_id				= "@orderentrybean"+patient_id+encounter_id;
	OrderEntryBean orbean			= (OrderEntryBean)getBeanObject( or_bean_id,or_bean_name,request ) ;
    String drugsearch_bean_Id   = "ePH.DrugSearchBean";  //  Added for ML-BRU-SCF-0958 [IN:042045] Start
	String drugsearch_bean_name = "ePH.DrugSearchBean";
    DrugSearchBean drugbean		=	(DrugSearchBean)getBeanObject( drugsearch_bean_Id, drugsearch_bean_name, request ) ; //  Added for ML-BRU-SCF-0958 [IN:042045] End
	orbean.setLanguageId(locale);
	String resp_id = orbean.getResponsibilityId();
	ArrayList result		=	new ArrayList();
	ArrayList alphabets		=	new ArrayList();
	ArrayList prescriptions	=  bean.getPrescriptions();
	String checked			=	"";
	boolean found			=  false; 
	if(!locale.equals("en")){
		order_from = DateUtils.convertDate(order_from, "DMY",locale,"en");
		order_to = DateUtils.convertDate(order_to, "DMY",locale,"en");
	}

	String drug_priv_appln_yn			= (String) session.getValue("PrivilegeApplicability");
	if ( drug_priv_appln_yn == null || drug_priv_appln_yn.equals("")) 
		drug_priv_appln_yn = "N";
	HashMap total_result	=	bean.getPreviousOrders(pat_class,pract_id,pat_id,ord_status,order_from,order_to,from,to,drug_desc,group_by,drug_priv_appln_yn,resp_id, log_pract_id);
	ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
	if(total_result.size()!=0 && group_by.equals("DR")) {
		result		=	(ArrayList)total_result.get("RESULT");
		//alphabets	=	(ArrayList)total_result.get("ALPHABETS");
	} 
	else{
		result		=	(ArrayList)total_result.get("RESULT");
	}
	int recCount		=	0;
	String classValue	=	"";
	String disabled		=	"";
	String pres_no		=	"";
	String order_id		=	"";
	String order_line_no		=	"";
	String drug_code	=	"";
	String ord_date="";
	String sliding_scale_yn = "";
	String priv_appl_yn = "";
	boolean taper_display = false;
    String verb_order_appr_drug_yn = ""; //Added for ML-BRU-SCF-0958 [IN:042045] 
    String Called_from_verbal_order = drugbean.getCalled_from_verbal_order(); //Added for ML-BRU-SCF-0958 [IN:042045]
	HashMap iv_legends = (HashMap) presBean.getIVLegends();
	String taper = "";
	String qty_uom, strength_value, taper_disabled=""; //taper_disabled added for [IN:048140]
	int dosageWidth=0;
	if(result.size()<2){
%>
		<script>
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA",'Common'));
		</script>
<%
		return;
	}
%>
	<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onLoad="checkHeaderonLoad();">
		<form name="frmPrescriptionPrevOrdersResult" id="frmPrescriptionPrevOrdersResult">
		<!-- Display the Previous Next link -->
<%
			String size="";
			// added for previous orders  performance tuning - start
			if( (result.size()>=2) && ( !( ((String) result.get(0)).equals("0")) ) && ( !( ((String) result.get(0)).equals("")) )){
%>
	             <table cellpadding=0 cellspacing=0 width="100%" align="center">
					<tr>
						<td width="78%" class="white">&nbsp;</td>
						<td width="20%" class="white">&nbsp;
<%
							out.println(result.get(0));// For display the previous/next link
%>
						</td>
						<td width="2%" class="white">&nbsp;
					</tr>
				</table>
<% 
			}
			else{
%>
	             <table cellpadding=0 cellspacing=0 width="100%" align="center">
					<tr>
						<td width="78%" class="white">&nbsp;</td>
					</tr>
				</table>
<%
			}
// added for previous orders  performance tuning - End
%>
			<div id="HTab" style="width:100%; overflow:hidden" align='left'>
				<table border="1" cellpadding="0" cellspacing="0" width="100%" align="left" name="resultTable" id="resultTable">
					<tr>  
						<th  nowrap width="1%" style="font-size:10">&nbsp;</th>
						<th  nowrap width="6%" style="font-size:10" colspan='2'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
<%
						if(!group_by.equals("PR")) { 
							dosageWidth = 25;
%>
							<th  width="24%"  style="font-size:10"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></th>
							<th  width="24%"  style="font-size:10"><fmt:message key="ePH.DosageDetail.label" bundle="${ph_labels}"/></th>
<%
						}
						else{
							dosageWidth = 37;
%>
							<th  width="36%"  style="font-size:10"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></th>
							<th  width="36%"  style="font-size:10"><fmt:message key="ePH.DosageDetail.label" bundle="${ph_labels}"/></th>
<%
						}
%>
						<th  width="10%"  style="font-size:10"><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></th>
						<th  width="10%"  style="font-size:10"><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></th>
<%
						if(!group_by.equals("PR")) { 
%>
							<th width="12%" style="font-size:10"><fmt:message key="Common.OrderedBy.label" bundle="${common_labels}"/></th>
							<th width="12%" style="font-size:10"><fmt:message key="ePH.OrderedLocation.label" bundle="${ph_labels}"/></th>	
<%
						}
%>
					</tr>
				</table>
			</div>
			<div id="DataTab" style="height:310px; width:100%; overflow:scroll" onScroll="scrollit()" align='left'>
				<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center" name="resultTable" id="resultTable" id="resultTable">
<% 
					String disContinue = "N";
					HashMap taperValues = null; //Added for RUT-CRF-0088 [IN036978]
					int count = 1;
					for(int i=0; i<result.size(); i+=22) { // i+=22 to 23 Added for ML-BRU-SCF-0958 [EMR IN:1835]

						disContinue = "N";
						if(recCount%2==0)
							classValue="QRYEVENSMALL";
						else
							classValue="QRYODDSMALL";

						found	=	false;
						if(i==0)
							++i;

						checked		=	"";
						disabled	=	"";
						order_id = (String)result.get(i+1);
						order_line_no = (String)result.get(i+2);
						drug_code = (String)result.get(i+3);
					    //verb_order_appr_drug_yn = (String)result.get(i+22); // Commented for ML-BRU-SCF-0958 [IN:042045  
						iv_prep_yn = (String)result.get(i+17);
						if(group_by.equals("PR")){
							disContinue = (String)result.get(i+19);
							sliding_scale_yn = (String)result.get(i+20);
							priv_appl_yn = (String)result.get(i+21);
							verb_order_appr_drug_yn = (String)result.get(i+22); //  Added for ML-BRU-SCF-0958 [IN:042045]
						}
						else{
							disContinue = (String)result.get(i+18);
							sliding_scale_yn = (String)result.get(i+19);
							priv_appl_yn = (String)result.get(i+20);
							verb_order_appr_drug_yn = (String)result.get(i+21); //  Added for ML-BRU-SCF-0958 [IN:042045]
						}
						if(iv_prep_yn==null) 
							iv_prep_yn="";

						if(iv_prep_yn.equals(""))
							rx_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.NormalRx.label", "ph_labels");
						else if(iv_prep_yn.equals("0"))
							rx_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.OncologyRegimen.label", "ph_labels")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Admixture.label", "ph_labels")+")";
						else if(iv_prep_yn.equals("1"))
							rx_legend=(String)iv_legends.get("IVA")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Direct.label", "common_labels")+")";//com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.IVwithAdditives.label","common_labels");
						else if(iv_prep_yn.equals("2"))
							rx_legend= (String)iv_legends.get("IVA")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Admixture.label", "ph_labels")+")";//com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.IVwithAdditives.label", "common_labels")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Admixture.label", "ph_labels")+")";
						else if(iv_prep_yn.equals("3"))
							rx_legend= (String)iv_legends.get("IVI")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Direct.label", "common_labels")+")";//"IV Piggyback (Direct)";
						else if(iv_prep_yn.equals("4"))
							rx_legend= (String)iv_legends.get("IVI")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Admixture.label", "ph_labels")+")";//"IV piggyback (Admixture)";
						else if(iv_prep_yn.equals("5"))
							rx_legend= (String)iv_legends.get("IVWA");//com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.IVwithAdditives.label", "common_labels");
						else if(iv_prep_yn.equals("6"))
							rx_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.CompoundingRx.label", "ph_labels");
						else if(iv_prep_yn.equals("7"))
							rx_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.TPNStandardRegimen.label", "ph_labels");//"TPN Standard Regimen";
						else if(iv_prep_yn.equals("8"))
							rx_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.TPNNONStandardRegimen.label", "ph_labels");//"TPN NON Standard Regimen";
						else if(iv_prep_yn.equals("9"))
							rx_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.OncologyRegimen.label", "ph_labels")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Direct.label", "common_labels")+")";//"Oncology Regimen (Direct)";

						if(prescriptions!= null && prescriptions.contains(result.get(i+3))){ 
							disabled	=	"disabled";
						}
						if(prescriptions!= null && prescriptions.contains(result.get(i+1)+","+result.get(i+2))){ 
							checked		=	"checked";
							disabled	=	"";
						}
						for(int j=0;j<prescriptionDetails.size();j++){
							if( ((String)((HashMap) prescriptionDetails.get(j)).get("DRUG_CODE")).equals((String)result.get(i+3)) ) {
								found	=	true;
								break;
							}
						}

						if(found){
							disabled	=	"disabled";
						}
						taper_display=false; //Added for SKR-SCF-0823 [IN:041165]
						//count = DMAbean.chkfortapering(order_id,drug_code, order_line_no);//commented for RUT-CRF-0088 [IN036978]
						taperValues=DMAbean.chkfortapering(order_id,drug_code, order_line_no, patient_id);	//Modified for RUT-CRF-0088 [IN036978]  
						//count =Integer.parseInt(taperValues.get("COUNT").toString());  // Modified for RUT-CRF-0088 [IN036978]  //Commented for ML-BRU-SCF-1458 [IN:052366]
						count = bean.chkfortaperingCount(order_id);//commented for RUT-CRF-0088 [IN036978]
						if(count==1 ){
							taper_display=false;
						}
						if(group_by.equals("PR") && !(pres_no.equals((String)result.get(i+1)))) { 
							pres_no	=	(String)result.get(i+1);
							taper_display=false;
%>
							<tr>
							<td  width="1%" class="CURRTEXT">&nbsp;</td>
<%
							if(iv_prep_yn.equals(rx_type)){
								if(disContinue.equals("Y") || (Called_from_verbal_order.equals("Y") && verb_order_appr_drug_yn.equals("N")) ||  (pract_type.equals("NS") && verb_order_appr_drug_yn.equals("N")) )  //verbal order condition added for ML-BRU-SCF-0958 [IN:042045]
									disabled="disabled";
								if(count>1 ) //Added for [IN:048140]- start
									taper_disabled="disabled";
								else
									taper_disabled="";//Added for [IN:048140]- end
%>	
								<td  width="4%" class="CURRTEXT" id="ord_<%=(String)result.get(i+1)%>"><input type="checkbox" name="<%=(String)result.get(i+1)%>" id="<%=(String)result.get(i+1)%>" onClick=" checkLines(this,i); checkonce(this,'<%=(String)result.get(i+1)%>'); " <%=checked%> <%=disabled%>  <%=taper_disabled%>></td>
								<input type='hidden' name='iv_prep_yn<%=(String)result.get(i+1)%>' id='iv_prep_yn<%=(String)result.get(i+1)%>' value='<%=iv_prep_yn%>' >
								<!--	<input type ="hidden" name ="priv_appl_yn<%=i%>" value="<%=priv_appl_yn%>"> -->
								<input type ="hidden" name ="<%=result.get(i+1)+",end_date_iv"%>" value="<%=result.get(i+13)%>"></td>
								<input type = "hidden" name ="<%=result.get(i+1)+",ord_status_iv"%>" value = '<%=(String)result.get(i)%>'>
								<input type = "hidden" name ="<%=result.get(i+1)+",answer_iv"%>" value = '<%=(String)result.get(i)%>'>
								<input type = "hidden" name ="TaperCount<%=result.get(i+1)%>" value = '<%=count%>'>
<%
							}
							else{
%>
								<td   width="4%" class="CURRTEXT">&nbsp</td>
<%
							}
							ord_date = (String)result.get(i+18);
						//	if(!locale.equals("en")){
						//		ord_date =  DateUtils.convertDate(ord_date, "DMYHM","en",locale);
						//	}
%>
							<td   colspan="3" style="font-size:10;font-weight:bold" class="CURRTEXT"><fmt:message key="Common.OrderDateTime.label" bundle="${common_labels}"/>:&nbsp;&nbsp;<%=ord_date%>
<%
							//if(!pract_id.equals("")) {  //commented for  MO-GN-5476 [IN:052574]
%>
								&nbsp;&nbsp;&nbsp;<fmt:message key="Common.OrderedBy.label" bundle="${common_labels}"/>:&nbsp;&nbsp;<%=result.get(i+15)%>
<%
							//}
%>
							&nbsp;&nbsp;&nbsp;<%=rx_legend%></td>
							<td  colspan="2"  class="CURRTEXT" nowrap style="font-size:10;font-weight:bold"> <fmt:message key="ePH.OrderedLocation.label" bundle="${ph_labels}"/>:&nbsp;&nbsp;<%=result.get(i+16)==null?"&nbsp;":result.get(i+16)%>&nbsp;&nbsp;&nbsp;</td>
						</tr>
<%
					}
					if((count==1)||(!taper_display)){
%>		
						<tr>
<% 
							if( ((String)result.get(i)).equals("CN")){
%>
								<td width="1%" class='CANCELLED'>&nbsp;</td>
<%
							} 
							else if( ((String)result.get(i)).equals("DC")) { 
%>
								<td width="1%" class='DISCONTINUED'>&nbsp;</td>
<%
							}
							else{
%>
								<td width="1%" class="<%=classValue%>">&nbsp;</td>
<%	
							}

							if(rx_type.equals("") && iv_prep_yn.equals("")){
								if(disContinue.equals("Y") || (Called_from_verbal_order.equals("Y") && verb_order_appr_drug_yn.equals("N")) ||  (pract_type.equals("NS") && verb_order_appr_drug_yn.equals("N")))  //verbal order condition added for ML-BRU-SCF-0958 [IN:042045](pract_type.equals("NS") && verb_order_appr_drug_yn.equals("N")) -- //  Added for ML-BRU-SCF-0958 [EMR IN:1835] 
									disabled="disabled";

								if(prescriptions!=null && prescriptions.contains(result.get(i+1)+","+result.get(i+2))){ 
									checked		=	"checked";
									//disabled	=	"disabled";
								} 
%>
								<input type ="hidden" name ="<%=result.get(i+1)+","+result.get(i+2)+",priv"%>" value="<%=priv_appl_yn%>"> 
								<td width="4%" class="<%=classValue%>"   id='drug_<%=(String)result.get(i+1)%>'>
								<input type="checkbox" name="<%=result.get(i+1)+","+result.get(i+2)%>" id="<%=result.get(i+1)+","+result.get(i+2)%>" onClick=" return checkDuplicate(this,'<%=priv_appl_yn%>'); "  value="<%=result.get(i+3)%>" <%=checked%> <%=disabled%>>
								<input type ="hidden" name ="<%=result.get(i+1)+","+result.get(i+2)+",drug_code"%>" id ="<%=result.get(i+1)+","+result.get(i+2)+",drug_code"%>" value="<%=result.get(i+3)%>"></td>
								<input type = "hidden" name ="<%=result.get(i+1)+","+result.get(i+2)+",ord_status"%>" id ="<%=result.get(i+1)+","+result.get(i+2)+",ord_status"%>" value = '<%=(String)result.get(i)%>'>
<%
							}
							else{
%>
								<td width="4%" class="<%=classValue%>"  >&nbsp</td>
<%
							}
%>
							<input type ="hidden" name ="<%=result.get(i+1)+","+result.get(i+2)+",end_date"%>" id ="<%=result.get(i+1)+","+result.get(i+2)+",end_date"%>" value="<%=result.get(i+13)%>"></td>
							<td width="2%" class="<%=classValue%>">
<%
							if((count>1)){
								taper = DMAbean.getTapervalue();
								taper_display = true;
								if(taper.equals("UP")){
%>
									<img src="../../ePH/images/uparrow.gif" onclick="showTaperDetails('<%=patient_id%>','<%=order_id%>','<%=drug_code%>');" valign="center" title='Taper Dose' style="cursor:pointer"height='20' width='20'></img>
<%
								}	
								else if(taper.equals("DOWN")){
%>
									<img src="../../ePH/images/downarrow.gif" onclick="showTaperDetails('<%=patient_id%>','<%=order_id%>','<%=drug_code%>');" valign="center" title='Taper Dose' style="cursor:pointer" height='20' width='20'></img>
<%
								}
								else{//Added for SKR-SCF-0823 [IN:041165]
%>
									<img src="../../ePH/images/MultiFrequency.gif" onclick="showTaperDetails('<%=patient_id%>','<%=order_id%>','<%=drug_code%>');" valign="center" title='<fmt:message key="ePH.TaperDose.label" bundle="${ph_labels}"/>' style="cursor:pointer" height='20' width='20' ></img>
<%
								}
							}
							else{
%>
								&nbsp;
<%
							}
%>
							</td>
							<td width="<%=dosageWidth%>%" style="font-size:10" class="<%=classValue%>"><%=result.get(i+4)%></td>
<%
							if(sliding_scale_yn.equals("N")){										
								strength_value = (String) result.get(i+5);
								if(strength_value!=null && !strength_value.equals("") && Float.parseFloat(strength_value) < 1)
									strength_value = Float.parseFloat(strength_value)+"";
								qty_uom = (String) result.get(i+6);
								if(qty_uom!=null && !qty_uom.equals(""))
									qty_uom = bean.getUomDisplay(facility_id,result.get(i+6).toString());
								if(((String)result.get(i+8)).equals("(Divided)")){
%>
									<td width="<%=dosageWidth%>%" style="font-size:10" class="<%=classValue%>"><%=strength_value+" "+qty_uom+"&nbsp;-&nbsp;<font  color=red>"+result.get(i+8)+"</font>&nbsp;for&nbsp;"+result.get(i+9)+" "+result.get(i+11)%></td>
<%
								}
								else{
%>
									<td width="<%=dosageWidth%>%" style="font-size:10" class="<%=classValue%>"><%=strength_value+" "+qty_uom+"&nbsp;-&nbsp;"+result.get(i+8)+"&nbsp;for&nbsp;"+result.get(i+9)+" "+result.get(i+11)%></td>
<%
								}
							}
							else{
%>
								<td width="<%=dosageWidth%>%" style="font-size:10" class="<%=classValue%>"><%=result.get(i+8)+"&nbsp;for&nbsp;"+result.get(i+9)+" "+result.get(i+11)%></td>
<%							
							}
%>							
							<td width="10%" nowrap style="font-size:10" class="<%=classValue%>"><%=result.get(i+12)%></td>
							<td width="10%" nowrap style="font-size:10" class="<%=classValue%>"><%=result.get(i+13)%></td>
<%
							if(!group_by.equals("PR")) { 
%>
								<td width="12%" style="font-size:10" class="<%=classValue%>"><%=result.get(i+15)%></td>
								<td width="12%" style="font-size:10" class="<%=classValue%>"><%=result.get(i+16)==null?"&nbsp;":result.get(i+16)%></td>
<%
							} 
%>
						</tr>
<%
					}
					recCount++;
					if(group_by.equals("PR")) {
						++i;
					}
				}	
%>
				</table>
				<input type="hidden" name="from" id="from" value="">
				<input type="hidden" name="to" id="to" value="">
				<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
				<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
				<input type="hidden" name="pat_class" id="pat_class" value="<%=pat_class%>">
				<input type="hidden" name="ord_status" id="ord_status" value="<%=ord_status%>">
				<input type="hidden" value="<%=presBean_id%>" name="presBean_id">
				<input type="hidden" value="<%=presBean_name %>" name="presBean_name">
<%
				if(!locale.equals("en")){ // added if condition for the incident : SKR-SCF-0748 [IN036983]
%>
					<input type="hidden" name="order_from" id="order_from" value="<%=DateUtils.convertDate(order_from, "DMY","en",locale)%>">
					<input type="hidden" name="order_to" id="order_to" value="<%=DateUtils.convertDate(order_to, "DMY","en",locale)%>">
<%				}
				else{
%>
					<input type="hidden" name="order_from" id="order_from" value="<%=order_from%>">
					<input type="hidden" name="order_to" id="order_to" value="<%=order_to%>">
<%              
				}
%>
				<input type="hidden" name="pract_id" id="pract_id" value="<%=pract_id%>">
				<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
				<input type="hidden" name="pat_id" id="pat_id" value="<%=pat_id%>">
				<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">	
				<input type="hidden" name="drug_desc" id="drug_desc" value="">
				<input type="hidden" name="tot_rec" id="tot_rec" value="<%=recCount%>">
				<input type="hidden" name="group_by" id="group_by" value="<%=group_by%>">
				<input type="hidden" name="rx_type" id="rx_type" value="<%=rx_type%>">
				<input type="hidden" name="checkcount" id="checkcount" value=<%=l%>>
				<input type="hidden" name="system_date" id="system_date" value="<%=sys_date%>">
				<input type="hidden" name="log_pract_id" id="log_pract_id" value="<%=log_pract_id%>">
				<input type="hidden" name="pract_type" id="pract_type" value="<%=pract_type%>"> <!-- Added for ML-BRU-SCF-0958 [EMR IN:1835]-->
				
		</form>
<% 
		putObjectInBean(bean_id,bean,request); 
		putObjectInBean(presBean_id,presBean,request);
	}
	catch(Exception e){
		e.printStackTrace();
	}
%>
	</body>
	<script>
		disableHeader(document.forms[0].elements);
		callButtonFrames();
		//checkDuplicateAfterLoad();
		controlLines();
		function scrollit() {
		  eldata=document.getElementById("DataTab");
		  elheader=document.getElementById("HTab");
		  //x=eldata.scrollLeft;
		  elheader.scrollLeft=eldata.scrollLeft;
		} 
	</script>
</html>

