<!DOCTYPE html>
<%@page import="ePH.PrescriptionBean"%>
<%@page import="ePH.IVPrescriptionBean"%>
<%@page import="eIPAD.chartsummary.clinicalnotes.healthobject.NotesData"%>
<%@page import="eIPAD.HealthObjects.Notes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.ehis.persist.PersistenceHelper"%>
<%@include file="../../../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@page import="eIPAD.chartsummary.common.healthobject.PatContext"%> 
<%@page import="eOR.ExistingOrder"%>
<%@page import="ePH.DrugSearchBean"%>
<%@page import="java.util.Date"%> 
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="ePH.PrescriptionBean_1"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="java.util.Locale" %>
<c:set var="path" value = "${pageContext.request.contextPath}"/>
<link rel="stylesheet" href="${path}/eIPAD/css/iPadPharmaColumLayout.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<input type = "hidden" name = "hdnPath" id = "hdnPath" value ="${path}" /> 	
<%
String orderNature="A";
%>
<div id="OrdListHWrapper_<%=orderNature%>" style="position: relative; height:100%; width: 100%; overflow: hidden;" class="ordListHWrapper table">		 	
<%
PatContext patientContextInsit = (PatContext)session.getAttribute("PatientContext"); 
		request.setCharacterEncoding("UTF-8");
		String locale		=	(String)session.getAttribute("LOCALE");		
		String patient_id	=	patientContextInsit.getPatientId();
		String encounter_id	=	patientContextInsit.getEncounterId();	
		String facility_id = patientContextInsit.getFacilityId();
		String EO_beanid		=	"@existingorderbean"+patient_id+encounter_id;
		String EO_beanname		=	"eOR.ExistingOrder";
		String previousOrderStr="";
		int orSize=0;
		ExistingOrder EO_bean	= (ExistingOrder)PersistenceHelper.getBeanObject( EO_beanid,EO_beanname,request );				
		String bean_id				= "@PrescriptionBean_1"+patient_id+encounter_id;
		String bean_name			= "ePH.PrescriptionBean_1";
		PrescriptionBean_1 Pres_bean= (PrescriptionBean_1)PersistenceHelper.getBeanObject( bean_id,bean_name,request);			
		
		String presBean_id			= "@PrescriptionBean"+patient_id+encounter_id;
		String presBean_name		= "ePH.PrescriptionBean";	
		PrescriptionBean presBean = (PrescriptionBean)PersistenceHelper.getBeanObject( presBean_id,presBean_name,request);   
		
		
		ArrayList allValues	=	new ArrayList();				
		Pres_bean.setLanguageId(locale);
		Properties properties	= (Properties) session.getValue("jdbc");					
		String curr_sys_date	= "";		
		ArrayList sysdate = (ArrayList)EO_bean.getSysDateTime(properties);
		for(int i=0;i<sysdate.size();i++){
			curr_sys_date	= (String)sysdate.get(0);
		}	
		
		String bean_id_IVPB			= "@IVPrescriptionBean_IVPB"+patient_id+encounter_id;
		String bean_name_IVPB	= "ePH.IVPrescriptionBean";
		IVPrescriptionBean iv_bean	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_IVPB, bean_name_IVPB, request);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");	
	Calendar calendar = Calendar.getInstance();		
	String order_to=sdf.format(sdf.parse(curr_sys_date));	
	calendar.setTime(sdf.parse(curr_sys_date));	
	calendar.add(Calendar.MONTH, -2);	
	String order_from=sdf.format(calendar.getTime());
	String pat_class="B";
	String ord_status		= "A";
	String pract_id="";	
	String from="";
	String to="1000";
	String drug_desc="";
	String group_by="PR";
	String drug_priv_appln_yn="Y";
	String resp_id=patientContextInsit.getResponsibilityID();
	String 	log_pract_id=patientContextInsit.getClinicianId();
	String avl_qty="";
	HashMap total_result	= Pres_bean.getPreviousOrders(pat_class,pract_id,patient_id,ord_status,order_from,order_to,from,to,drug_desc,group_by,drug_priv_appln_yn,resp_id, log_pract_id);	
	allValues		=	(ArrayList)total_result.get("RESULT");	
    String DrugSearchbean_id 			= "@DrugSearchBean"+patient_id+encounter_id;
	String	DrugSearchbean_name			=	"ePH.DrugSearchBean";	
	DrugSearchBean DrugSearchbean = (DrugSearchBean)PersistenceHelper.getBeanObject(DrugSearchbean_id, DrugSearchbean_name, request ) ;
	ArrayList drug_dtls =	null;
	ArrayList stock_dtls	=	null;
	String strFluidName="";
	String strdrug_CompleteDetails="";	
	if (allValues.size()>=2) 
	{
	%>
	<div style="position:absolute; width: auto; height: 100%;" id="OrdItemscroller_<%=orderNature %>">
	<ul id="OrdListColWrap_<%=orderNature %>" class="ordListColWrap row" style="height: 100%; margin-top: 0px; padding-left: 0px;">
	<%	
		String previousorder_id="";	    
		int count=0;
		String nextOrder="";
		int nextOrderidPosition=0;
		String orders_id_rx="";
		int orders_id_rx_pos=0;
		String checkForStock="";
		for(int i=0; i<allValues.size(); i+=22) 
			{				
				String trade_code="";
				count=count+1;
				nextOrderidPosition=count*23+2;
				if((nextOrderidPosition)>allValues.size()){//2 is order ID position
					nextOrder="";
				}
				else
				{
					nextOrder=(String)allValues.get(nextOrderidPosition);			
				}
				if(i==0)
					++i;								
				String orderStatus=(String)allValues.get(i);
				String cClassName="";
				if(orderStatus.equals("CN"))
					cClassName="rxBubleCellStatusCheckCancel";
				else if(orderStatus.equals("DC"))
					cClassName="rxBubleCellStatusCheckDiscontinued";
				else 
					cClassName="";
				String order_id = (String)allValues.get(i+1);
				Integer  order_line_no = Integer.parseInt((String)allValues.get(i+2));
				String drug_code = (String)allValues.get(i+3);
				//System.out.println("drug_code--------------------->"+drug_code);
				ArrayList trades = new ArrayList();
				trades = presBean.getTrades(drug_code); 
				String default_tradeName = "";
				if(trades.size() > 0){
					default_tradeName = (String)trades.get(0);
					trade_code=(String)trades.get(0);
					//System.out.println("default_tradeName==>>"+default_tradeName);
				}
				
				String drug_name =(String)allValues.get(i+4);	
				String qty_uom, strength_value;
				strength_value = (String) allValues.get(i+5);
				
				if(strength_value!=null && !strength_value.equals("") && Float.parseFloat(strength_value) < 1)
					strength_value = Float.parseFloat(strength_value)+"";
				qty_uom = (String) allValues.get(i+6);
				if(qty_uom!=null && !qty_uom.equals(""))
					qty_uom = Pres_bean.getUomDisplay(facility_id,allValues.get(i+6).toString());
				String startDate =(String)allValues.get(i+12);
				String endDate =(String)allValues.get(i+13);
				DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm");	//TODO	
				DateFormat fMonth = new SimpleDateFormat("MMM");
				DateFormat fDate = new SimpleDateFormat("dd");
				DateFormat fYear = new SimpleDateFormat("yyyy");
				Date startDate_dt = df.parse(startDate);
				Date endDate_dt = df.parse(endDate);	
				String formattedStartDate = fDate.format(startDate_dt);		
				String formattedStartMonthSmallCase = fMonth.format(startDate_dt);
				String formattedStartMonth = formattedStartMonthSmallCase.toUpperCase();		
				String formattedStartYear = fYear.format(startDate_dt);
				String formattedEndDate = fDate.format(endDate_dt);		
				String formattedEndMonthSmallCase = fMonth.format(endDate_dt);
				String formattedEndMonth = formattedEndMonthSmallCase.toUpperCase();				
				String formattedEndYear = fYear.format(endDate_dt);							
				String drugType ="";
				String drugTypeDesc ="";
				String drugTypeCode ="";
				String drugGenCat="";
				
				
				  
				   
				   
				drugType = (String)allValues.get(i+17);				
					if(drugType == null ||drugType.equals("")){
						drugTypeCode = "Rx";
						drugTypeDesc = "";
						drugGenCat="RX";
					}
                   else	if(drugType.equals("5")){
					   drugTypeCode = "IVWA";
					   drugTypeDesc ="WITHOUT ADDITIVES";	
					   drugGenCat="IV";
				   }
                   else	if(drugType.equals("6")){
					   drugTypeCode = "CRx";
					   drugTypeDesc ="COMPOUND RX";
					   drugGenCat="Crx";
				   }				   
                   else	if(drugType.equals("1") ||drugType.equals("2") ){
					   drugTypeCode = "IVD";
					   drugTypeDesc ="WITH ADDITIVES";	
					   drugGenCat="IV";
				   }
				   else	if(drugType.equals("3") ||drugType.equals("4") ){
					   drugTypeCode = "IVPB";
					   drugTypeDesc ="INTERMITTENT";
					   drugGenCat="IV";
				   }
					
					//strength_value = (String) allValues.get(i+5);
					
					
				String drug_CompleteDetails = strength_value+" "+qty_uom+" - "+allValues.get(i+8)+" For "+allValues.get(i+9)+" "+allValues.get(i+11);				
			    String id_drug= drug_code.replaceAll("[-+.^:,]","");						
                String trad="T";				
				String id_drugName_tradeName=id_drug+"_"+trad+i;
				String priv_appl_yn = (String)allValues.get(i+21);
				String order_ids= order_id.replaceAll("[-+.^:,]","");						
                String lineNum=(String)allValues.get(i+2);				
				String id_order_ids_lineNum=order_ids;	
				//String id_drug="T";				
				String ivrxIsPresent = request.getParameter("ivrxChk");
				
				drug_dtls	=	DrugSearchbean.getPreferredDrugDetails(drug_code);
				if(drug_dtls!=null && drug_dtls.size() > 0){
					trade_code=	(String)drug_dtls.get(3);
				}
				String drug_class="";
				avl_qty="";
				stock_dtls	= DrugSearchbean.checkStock(drug_code, trade_code, drug_class, "","","",patient_id,encounter_id);
				if(stock_dtls!=null && stock_dtls.size() > 0){
					avl_qty	=	(String)stock_dtls.get(1);
				}	
				
				 if(Float.parseFloat(avl_qty)>0){
					 if(!checkForStock.equals("out-stock"))
					 	checkForStock="in-stock";
				 }else{				 
					 checkForStock="out-stock";
				 }
				 System.out.println(drug_name + " Stock :  "+avl_qty + " checkForStock " + checkForStock);
	 if((drugTypeCode.equals("Rx")&& drugTypeDesc.equals(""))|| ivrxIsPresent.equals("Y") && drugTypeDesc.equals("WITHOUT ADDITIVES")){
		 
		 ArrayList exstngIVorder = 	iv_bean.getExistingIVRecords(order_id, "Y", "IP");//TODO -- change patient_class hardcoded
		
	  String	 drug_codesEX ="";
	  String drugCodeUniq="";
	  
	
		 for(int e=0;e<exstngIVorder.size();e++){
			 
			 HashMap extDrugList		=	(HashMap)exstngIVorder.get(e); 
			 String drug_codeex=	(String)extDrugList.get("ORDER_CATALOG_CODE")==null?"":(String)extDrugList.get("ORDER_CATALOG_CODE"); 
			 
			 
			 drug_codesEX +=drug_codeex+",";
			 drugCodeUniq+=drug_codeex.replaceAll("[-+.^:,]","")+",";
	
			 
		 }
	
		 if(exstngIVorder.size()>0){
			 drug_codesEX = drug_codesEX.substring(0, drug_codesEX.length()-1);
			 drugCodeUniq = drugCodeUniq.substring(0, drugCodeUniq.length()-1)+"";
		 }
		 
		 //orders_id_rx_pos
		 
		 if(!orders_id_rx.equals(order_ids)){
			 
			 orders_id_rx_pos=0;
			 
		 }
		 
		 orders_id_rx_pos= orders_id_rx_pos+1;
		 
		 id_order_ids_lineNum=order_ids+"_"+orders_id_rx_pos;
		 orders_id_rx=order_ids;
		 
		 drug_codesEX=drug_code;
		 drugCodeUniq=drug_code.replaceAll("[-+.^:,]","");
	 %>
	<li>
		<div  id="<%=id_order_ids_lineNum%>" 
		data-currentid="<%=id_order_ids_lineNum%>"  
		data-drugCodeUnique="<%=id_order_ids_lineNum%>" 
		data-drugname="<%=drug_name%>" 
		data-drugtypecode="<%=drugTypeCode%>" 
		data-drugcodesall="<%=drug_codesEX%>" 
		data-drugUniqueall="<%=drugCodeUniq%>"
		data-previous="po"
		data-drugCode="<%=drug_code%>" 
		data-orderId="<%=order_id%>" 
		data-drugtypedesc="<%=drugTypeDesc%>" 
		data-tradeCodes="<%=trade_code%>" 
		data-tradeName="<%=default_tradeName%>"
		data-ivrxispresent="<%=ivrxIsPresent%>" 
		data-priority="R"
		data-rxpos="<%=orders_id_rx_pos%>" 
		data-ordercatcode="" 
		data-previligegroupdrugordering_yn="<%=priv_appl_yn%>"
		data-diagnosis_found_yn="" 
		data-appl_for_age_grp_yn="" 
		data-in_formulary="" 
		data-drug_class="" 
		data-stock_yn="" 
		data-allow_yn="" 
		data-avl_qty="<%=checkForStock%>"
		<%
		System.out.println("checkForStock KNs : " + checkForStock);
		%>
		
		class="rxBuble rxBubleSlotOne rxBubleTable ordDraggable_<%=orderNature %>">
			<div class="rxBubleRow">
			    <div class="rxBubleCellContentDesc">
				   <div class="rxBubleCellContent">
						<div class="rxBubleLable"><%=drug_name%></div>
						<div class="rxBubleLableDrugFreq"><%=drug_CompleteDetails%></div>
					</div>
				</div>
				<div class="rxBubleCellContentTime">
				 <div id="div2" class="drugDateDataWrapper">
			    <div id="footerWrapper" style="width:100%;padding-left: 3px;">
				<div class="rxBubleCellContentBubble">				
				<%if(cClassName.length()>0){%>
				<div class="rxBubleCellStatusCheck <%=cClassName%>" ></div>
				<%}%>
				<div class="rxBubleCellBubbleContent"><%=drugGenCat%>							
				</div>
				</div>
				<div class="rxBubleCellContentType">
				<span class="rxBubleDrugType"><%=drugTypeDesc%></span>
				</div>				
				  <div class="table" style="width:52px;float:right;"> 
                     <div class="row">
					    <div class="cell drugStartDateStyle">
						   <span><%=formattedEndDate%></span>
						</div>
					    <div class="cell startMonthStyleWrapper">
						  <div class="table startMonthStyle">
                             <div class="row"> 						  
					            <div class="cell startMonthCellCss">
								   <%=formattedEndMonth%>
								</div>
					         </div>
							 <div class="row">
 							    <div class="cell startYearCellCss">
								   <%=formattedEndYear%>
								</div>
					        </div>
						  </div>
						</div>
					 </div>
                 </div>					 
				 <div  style="float:right;width:17px;" class="table">
                    <div class="row">
					  <div class="cell toStyleCssPrevOrders">to</div>
					</div>
                 </div>				 
				 <div class="table" style="width:52px;float:right;"> 
                     <div class="row">
					    <div class="cell drugStartDateStyle">
						  <span><%=formattedStartDate%></span>
						</div>
					    <div class="cell startMonthStyleWrapper">
						  <div class="table startMonthStyle">
                             <div class="row"> 						  
					            <div class="cell startMonthCellCss">
								   <%=formattedStartMonth%>
								</div>
					         </div>
							 <div class="row">
 							    <div class="cell startYearCellCss">
								   <%=formattedStartYear%>
								</div>
					         </div>
						  </div>
						</div>
					 </div>
                 </div>					 
				 <div style="clear: both;"></div>
				</div>
			  </div>
			</div>
				   <%
				     if(Float.parseFloat(avl_qty)>0){%>
						<div class="rxBubleCellIconInStock"><img src="${path}/eIPAD/images/Drag25x25.png"></div>
					<%}else{%>
						<div class="rxBubleCellIconOutStock"><img src="${path}/eIPAD/images/Drag25x25.png"></div>
					<%}%>
			</div>
		</div>
    </li>
     <%}
	else if(ivrxIsPresent.equals("Y") && drugTypeDesc.equals("INTERMITTENT")){		
		if(!previousorder_id.equals(order_id)) {
			strFluidName=drug_name;
			strdrug_CompleteDetails=drug_CompleteDetails;
			
		//	strength_value = (String) allValues.get(i+5);
		
		//System.out.println("(String) allValues.get(i+5)"+(String) allValues.get(i+5)+"(String) allValues.get(i+8)"+(String) allValues.get(i+8));
		
	//	System.out.println("drug_CompleteDetailsdrug_CompleteDetailsdrug_CompleteDetails::"+drug_CompleteDetails);
			
			ArrayList exstngIVorder = 	iv_bean.getExistingIVRecords(order_id, "Y", "IP");//TODO -- change patient_class hardcoded
			
			  String	 drug_codesEX ="";
			  String drugCodeUniq="";
				 for(int e=0;e<exstngIVorder.size();e++){
					 
					 HashMap extDrugList		=	(HashMap)exstngIVorder.get(e); 
					 String drug_codeex=	(String)extDrugList.get("ORDER_CATALOG_CODE")==null?"":(String)extDrugList.get("ORDER_CATALOG_CODE"); 
					
					 drug_codesEX+=drug_codeex+",";
					 drugCodeUniq+=drug_codeex.replaceAll("[-+.^:,]","")+",";	
					
					 
				 }
		
				 if(exstngIVorder.size()>0){
					 drug_codesEX = drug_codesEX.substring(0, drug_codesEX.length()-1); 
					 drugCodeUniq = drugCodeUniq.substring(0, drugCodeUniq.length()-1)+"";
				 }
				
			%>	
		<li>
		<div  id="<%=id_order_ids_lineNum%>" 
		data-currentid="<%=id_order_ids_lineNum%>"  
		data-drugCodeUnique="<%=id_order_ids_lineNum%>" 
		data-drugname="<%=drug_name%>" 
		data-drugtypecode="<%=drugTypeCode%>" 
		data-drugcodesall="<%=drug_codesEX%>"
		data-drugUniqueall="<%=drugCodeUniq%>"
		data-previous="po"
		data-drugCode="<%=drug_code%>" 
		data-orderId="<%=order_id%>" 
		data-durgDesp="<%=drugTypeDesc%>" 
		
		data-tradeCodes="<%=trade_code%>" 
		data-tradeName="<%=default_tradeName%>"
		data-avl_qty="<%=checkForStock%>"
		
		class="rxBuble rxBubleSlotTwo rxBubleTable ordDraggable_<%=orderNature %>">
			<div class="rxBubleRow">			
		<% } else if(previousorder_id.equals(order_id)) {%>		
				<div class="rxBubleCellContentDesc">
				   <div class="rxBubleCellContent">
					<div class="rxBubleLable"><%=drug_name%></div>
					<div class="rxBubleLableDrugFreq"> 
					 <%=drug_CompleteDetails%>
					</div>
                </div>					
				</div>				
				<div class="drugItemSeperator">
				  <img src="${path}/eIPAD/images/FluidAdditiveDiff.PNG">
				</div>
				 <div class="rxBubleCellContentDesc">
				   <div class="rxBubleCellContent">
					<div class="rxBubleLable"><%=strFluidName%></div>
					<div class="rxBubleLableDrugFreq"> 
					  <%=strdrug_CompleteDetails%>
					  <%strFluidName="";
					  strdrug_CompleteDetails="";
					  //WithCount=0;
					  %>
					</div>
                </div>					
				</div>				
				<div class="rxBubleCellContentTime">
				 <div id="div2" class="drugDateDataWrapper">
			    <div id="footerWrapper" style="width:100%;padding-left: 3px;">
				<div class="rxBubleCellContentBubble">
				<%if(cClassName.length()>0){%>				
					<div class="rxBubleCellStatusCheck <%=cClassName%>" ></div>			
				<%}%>
				<div class="rxBubleCellBubbleContent"><%=drugGenCat%>
				</div>
				</div>
				<div class="rxBubleCellContentType" style="width:59px;">
				<span  style="width:59px;" class="rxBubleDrugType"><%=drugTypeDesc%></span>
				</div>	 
                 <div class="table drugDateContainer" style="width:54px;float:right;"> 
                     <div class="row">
					    <div class="cell drugStartDateStyle">
						   <span><%=formattedEndDate%></span>
						</div>
					    <div class="cell startMonthStyleWrapper">
						  <div class="table startMonthStyle">
                             <div class="row"> 						  
					            <div class="cell startMonthCellCss">
								   <%=formattedEndMonth%>
								</div>
					         </div>
							 <div class="row">
 							    <div class="cell startYearCellCss">
								   <%=formattedEndYear%>
								</div>
					        </div>
						  </div>
						</div>
					 </div>
                 </div>					 
				 <div  style="float:right;" class="table toStylingWrapper">
                    <div class="row">
					  <div class="cell toStyleCssPrevOrders">to</div>
					</div>
                 </div>				 
				 <div class="table drugDateContainer" style="width:52px;float:right;"> 
                     <div class="row">
					    <div class="cell drugStartDateStyle">
						  <span><%=formattedStartDate%></span>
						</div>
					    <div class="cell startMonthStyleWrapper">
						  <div class="table startMonthStyle">
                             <div class="row"> 						  
					            <div class="cell startMonthCellCss">
								   <%=formattedStartMonth%>
								</div>
					         </div>
							 <div class="row">
 							    <div class="cell startYearCellCss">
								   <%=formattedStartYear%>
								</div>
					         </div>
						  </div>
						</div>
					 </div>
                 </div>	
				 
				 <div style="clear: both;"></div>
				</div>
			  </div>
			</div>
				   <%
				     if(Float.parseFloat(avl_qty)>0){%>
						<div class="rxBubleCellIconInStock"><img src="${path}/eIPAD/images/Drag25x25.png"></div>
					<%}else{%>
						<div class="rxBubleCellIconOutStock"><img src="${path}/eIPAD/images/Drag25x25.png"></div>
					<%}%>
			</div>
		</div>
    </li>	
    <%}} else if(ivrxIsPresent.equals("Y") && drugTypeDesc.equals("WITH ADDITIVES")){		
		if(!previousorder_id.equals(order_id)) {
			strFluidName=drug_name;
			strdrug_CompleteDetails=drug_CompleteDetails;
			
			ArrayList exstngIVorder = 	iv_bean.getExistingIVRecords(order_id, "Y", "IP");//TODO -- change patient_class hardcoded
			
			  String drug_codesEX ="";
			  String drugCodeUniq="";
				 for(int e=0;e<exstngIVorder.size();e++){
					 
					 HashMap extDrugList		=	(HashMap)exstngIVorder.get(e); 
					 String drug_codeex=	(String)extDrugList.get("ORDER_CATALOG_CODE")==null?"":(String)extDrugList.get("ORDER_CATALOG_CODE"); 
					
					 drug_codesEX+=drug_codeex+",";
					 drugCodeUniq+=drug_codeex.replaceAll("[-+.^:,]","")+",";	
							
				 }
		
				 if(exstngIVorder.size()>0){
					 drug_codesEX = drug_codesEX.substring(0, drug_codesEX.length()-1); 
					 drugCodeUniq = drugCodeUniq.substring(0, drugCodeUniq.length()-1)+""; 
					 
				 }
				
				

			%>
		<li>
			<div  id="<%=id_order_ids_lineNum%>" 
		data-currentid="<%=id_order_ids_lineNum%>"  
		data-drugCodeUnique="<%=id_order_ids_lineNum%>" 
		data-drugname="<%=drug_name%>" 
		data-drugtypecode="<%=drugTypeCode%>" 
		
		data-drugCode="<%=drug_code%>" 
		data-orderId="<%=order_id%>" 
		data-durgDesp="<%=drugTypeDesc%>" 
		data-drugcodesall="<%=drug_codesEX%>"
		data-drugUniqueall="<%=drugCodeUniq%>"
		data-previous="po"
		data-tradeCodes="<%=trade_code%>" 
		data-tradeName="<%=default_tradeName%>"
		data-avl_qty="<%=checkForStock%>"
			class="rxBuble  rxBubleTable ordDraggable_<%=orderNature %>">
				<div class="rxBubleRow"> <% 
		} else if(previousorder_id.equals(order_id) && order_line_no==2) {%>		
			<div class="rxBubleCellContentDesc">
				<div class="rxBubleCellContent">
					<div class="rxBubleLable"><%=drug_name%></div>
					<div class="rxBubleLableDrugFreq"><%=drug_CompleteDetails%></div>
				</div>
			</div>			
			<% if(!previousorder_id.equals(nextOrder)) {%>
				<div class="drugItemSeperator">	<img src="${path}/eIPAD/images/FluidAdditiveDiff.PNG"></div>
				<div class="rxBubleCellContentDesc">
					<div class="rxBubleCellContent">
						<div class="rxBubleLable"><%=strFluidName%></div>
						<div class="rxBubleLableDrugFreq"><%=strdrug_CompleteDetails%>
							<%strFluidName="";
							strdrug_CompleteDetails="";%> 
						</div>
					</div>
				</div>
			<%}%>
		<%} else if(previousorder_id.equals(order_id) && order_line_no==3) {%>
			<div class="rxBubleCellContentDesc">
				<div class="rxBubleCellContent">
					<div class="rxBubleLable"><%=drug_name%></div>
					<div class="rxBubleLableDrugFreq"><%=drug_CompleteDetails%></div>
				</div>
			</div>
			<% if(order_id.equals(nextOrder)){%>
			<div class="drugItemSeperator">
				  <img src="${path}/eIPAD/images/MoreIVWA.PNG">
			</div>
			<%}%>
			<div class="drugItemSeperator">	<img src="${path}/eIPAD/images/FluidAdditiveDiff.PNG"></div>
			<div class="rxBubleCellContentDesc">
				<div class="rxBubleCellContent">
					<div class="rxBubleLable"><%=strFluidName%></div>
					<div class="rxBubleLableDrugFreq"><%=strdrug_CompleteDetails%>
						<%strFluidName="";
						strdrug_CompleteDetails="";%>
					</div>
					</div>
			</div>			
		<%}%>			
		<% if(order_line_no>1 && !previousorder_id.equals(nextOrder)){%>
		<div class="rxBubleCellContentTime">
			<div id="div2" class="drugDateDataWrapper">
			    <div id="footerWrapper" style="width:100%;padding-left: 3px;">
				<div class="rxBubleCellContentBubble">
				<%if(cClassName.length()>0){%>
				<div class="rxBubleCellStatusCheck <%=cClassName%>" ></div>				
				<%}%>
				<div class="rxBubleCellBubbleContent"><%=drugGenCat%>
				</div>
				</div>
				<div class="rxBubleCellContentType">
				<span style="" class="rxBubleDrugType"><%=drugTypeDesc%></span>
				</div>				
				 <div class="table drugDateContainer" style="width:54px;float:right;"> 
                     <div class="row">
					    <div class="cell drugStartDateStyle">
						   <span><%=formattedEndDate%></span>
						</div>
					    <div class="cell startMonthStyleWrapper">
						  <div class="table startMonthStyle">
                             <div class="row"> 						  
					            <div class="cell startMonthCellCss">
								   <%=formattedEndMonth%>
								</div>
					         </div>
							 <div class="row">
 							    <div class="cell startYearCellCss">
								   <%=formattedEndYear%>
								</div>
					        </div>
						  </div>
						</div>
					 </div>
                 </div>					 
				 <div  style="float:right;" class="table toStylingWrapper">
                    <div class="row">
					  <div class="cell toStyleCssPrevOrders">to</div>
					</div>
                 </div>				 
				 <div class="table drugDateContainer" style="width:52px;float:right;"> 
                     <div class="row">
					    <div class="cell drugStartDateStyle">
						  <span><%=formattedStartDate%></span>
						</div>
					    <div class="cell startMonthStyleWrapper">
						  <div class="table startMonthStyle">
                             <div class="row"> 						  
					            <div class="cell startMonthCellCss">
								   <%=formattedStartMonth%>
								</div>
					         </div>
							 <div class="row">
 							    <div class="cell startYearCellCss">
								   <%=formattedStartYear%>
								</div>
					         </div>
						  </div>
						</div>
					 </div>
                 </div>					 
				 <div style="clear: both;"></div>
				</div>
			  </div>
			</div>
				   <%
				     if(Float.parseFloat(avl_qty)>0){%>
						<div class="rxBubleCellIconInStock"><img src="${path}/eIPAD/images/Drag25x25.png"></div>
					<%}else{%>
						<div class="rxBubleCellIconOutStock"><img src="${path}/eIPAD/images/Drag25x25.png"></div>
					<%}%>
			</div>
		</div>
    </li>	
		<%}}else if(drugTypeCode.equalsIgnoreCase("CRx") &&  drugTypeDesc.equalsIgnoreCase("COMPOUND RX")){
			 String	 drug_codesEX ="";
			  String drugCodeUniq="";
			  ArrayList exstngIVorder = 	iv_bean.getExistingIVRecords(order_id, "Y", "IP");//TODO -- change patient_class hardcoded
			 int orderSize=exstngIVorder.size();
			
			if(orderSize>=7){
				
				orderSize=7;
			}
			%>
			
			<%  if(!previousOrderStr.equalsIgnoreCase(order_id)){
				previousOrderStr=order_id;
				orSize=0;
				
			%>
			
			
			<li>
			<div  id="<%=id_order_ids_lineNum%>_<%=i%>" 
		data-currentid="<%=id_order_ids_lineNum%>_<%=i%>"  
		data-drugCodeUnique="<%=id_order_ids_lineNum%>" 
		data-drugname="<%=drug_name%>" 
		data-drugtypecode="<%=drugTypeCode%>" 
		data-drugcodesall="<%=drug_codesEX%>" 
		data-drugUniqueall="<%=drugCodeUniq%>"
		data-previous="po"
		data-drugCode="<%=drug_code%>" 
		data-orderId="<%=order_id%>" 
		data-drugtypedesc="<%=drugTypeDesc%>" 
		data-tradeCodes="<%=trade_code%>" 
		data-tradeName="<%=default_tradeName%>"
		data-ivrxispresent="<%=ivrxIsPresent%>" 
		data-priority="R"
		data-ordercatcode="" 
		data-previligegroupdrugordering_yn=""
		data-diagnosis_found_yn="" 
		data-appl_for_age_grp_yn="" 
		data-in_formulary="" 
		data-drug_class="" 
		data-stock_yn="" 
		data-allow_yn="" 
		data-avl_qty="<%=checkForStock%>"
		
		
		class="rxBuble rxBubleSlotOne rxBubleTable ordDraggable_<%=orderNature %>">
		<div class="rxBubleRow">
		<% }%>
		   
		
		
		<% orSize=orSize+1;
		

		%>
			
				<% 	if(orSize <= 7){ 	%>
		    <div class="rxBubleCellContentCrx">
			   <div class="rxBubleCellContentDtl">
					<div class="rxBubleLable"><%=drug_name%></div>
					
				</div>
			</div>
			
			<% 
				}
		
			
			if(orSize==orderSize){
			%>
			<% 	if(orderSize>=7){ 	%>
			<div class="drugItemSeperator">
				 <img src="${path}/eIPAD/images/MoreIVWA.PNG">
				</div>
					<% 	} 	%>
				
			<div class="rxBubleLableDrugFreqCrx"><%=drug_CompleteDetails%></div>
			
			
			<div class="rxBubleCellContentTime">
				 <div id="div2" class="drugDateDataWrapper">
			    <div id="footerWrapper" style="width:100%;padding-left: 3px;">
				<div class="rxBubleCellContentBubble">				
				<%if(cClassName.length()>0){%>
				<div class="rxBubleCellStatusCheck <%=cClassName%>" ></div>
				<%}%>
				<div class="rxBubleCellBubbleContent"><%=drugGenCat%>							
				</div>
				</div>
				<div class="rxBubleCellContentType">
				<span class="rxBubleDrugType"><%=drugTypeDesc%></span>
				</div>				
				  <div class="table" style="width:52px;float:right;"> 
                     <div class="row">
					    <div class="cell drugStartDateStyle">
						   <span><%=formattedEndDate%></span>
						</div>
					    <div class="cell startMonthStyleWrapper">
						  <div class="table startMonthStyle">
                             <div class="row"> 						  
					            <div class="cell startMonthCellCss">
								   <%=formattedEndMonth%>
								</div>
					         </div>
							 <div class="row">
 							    <div class="cell startYearCellCss">
								   <%=formattedEndYear%>
								</div>
					        </div>
						  </div>
						</div>
					 </div>
                 </div>					 
				 <div  style="float:right;width:17px;" class="table">
                    <div class="row">
					  <div class="cell toStyleCssPrevOrders">to</div>
					</div>
                 </div>				 
				 <div class="table" style="width:52px;float:right;"> 
                     <div class="row">
					    <div class="cell drugStartDateStyle">
						  <span><%=formattedStartDate%></span>
						</div>
					    <div class="cell startMonthStyleWrapper">
						  <div class="table startMonthStyle">
                             <div class="row"> 						  
					            <div class="cell startMonthCellCss">
								   <%=formattedStartMonth%>
								</div>
					         </div>
							 <div class="row">
 							    <div class="cell startYearCellCss">
								   <%=formattedStartYear%>
								</div>
					         </div>
						  </div>
						</div>
					 </div>
                 </div>					 
				 <div style="clear: both;"></div>
				</div>
			  </div>
			</div>
			
			
		
			<div class="rxBubleCellIconOutStock"><img src="${path}/eIPAD/images/Drag25x25.png"></div>
			
			</div>
			
			
			
			
			 </div>
		    </li>
			
			<%
			
			}
			if(orSize==exstngIVorder.size()){
			orSize=0;
			previousOrderStr="";
			}
			%>
	<%	}	
		if(group_by.equals("PR")){			
			previousorder_id	=	order_id;			
			++i;
		}}%>
	</ul>
	</div>
	<%
	}else{      
	%>
    <div id="noPrevOreders" class="table" style="width:100%;height:99%;background:#edf1f3;" data-role = "none">
		<div class="pharmEmptyData">
		  No previous orders available
		</div>
	</div>
	<input type="hidden" name="hdnPrevOrderSize" id="hdnPrevOrderSize" id="hdnPrevOrderSize" value="0" />
	<%		
	}	
	%>	
	</div>	
<script src="${path}/eIPAD/js/PharamaColumnLayout.js"></script>
<script src="${path}/eIPAD/js/lib/kendo/kendo.all.min.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>

<link rel="stylesheet" href="${path}/eIPAD/css/kendo/kendo.common.min.css" />
<script>
    $(document).ready(function() {
        var checkForRec = $('#no_record').val();
        if (checkForRec != 'no') 
		{		
            var ordListColWrap = $('#' + "OrdListColWrap_A");
            var ordListColParent = ordListColWrap.parent();
           var ordListColItems1 = ordListColWrap.children();         
           onOriChange();	
		   setTimeout(function() {
          // assignOrdItemsHScroll_S();
           //dragAndDrop();
            }, 500);         		   
            $('#no_record').val("");
        }    }); 
</script>
</html>

