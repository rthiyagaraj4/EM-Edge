<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------------
?             100            ?           	created
31/05/2013    IN040092		Karthi L      When we Place "Order Set" Billing details are displayed.
13/08/2014	  IN049419		Ramesh G		An Audit Trail for Additional Information Amendment of Order
07/06/2020	  IN072524	Nijitha S     		07/06/2020		Ramesh G		ML-MMOH-CRF-1229.2
--------------------------------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>

<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script><!-- used for date valifdation-->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/ExistingOrder.js"></script>
 	<script language="JavaScript" src="../js/ViewOrder.js"></script> <!-- added to include the function for displaying the cancel reason -->
 	<script language="JavaScript" src="../js/ResultOrder.js"></script> <!-- added to include the function for viewing the results onclicking the status hyperlink -->
 	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 	<Style> </Style>
	<script>
	function dummy(){
	}

	function hideToolTip(obj,imgObj,row)	
	{
		dynamichide(obj, window.event,row);
	  /*document.getElementById("tooltiplayer").style.visibility = 'hidden'
		 if (obj != null)
		  {
				obj.className = 'gridDataBlue';
				eval("document.all."+imgObj).src = "../../eCommon/images/inactiveArrow.gif";
		  }*/	 
	}


	function callMouseOver(obj)	{
		currClass = obj.className ;
		obj.className = 'selectedcontextMenuItem';

	}

	function callOnMouseOut(obj){
		obj.className = 'contextMenuItem';
	}


	function resizeWindow(orderctlHDR)
	{
	    var orderctlHDR1 = orderctlHDR.id;
		
		var element = document.getElementById(orderctlHDR1);
		var wdth = element.offsetWidth;
		var hght1 = element.offsetHeight;

		/*var wdth = eval("document.all."+orderctlHDR1).offsetWidth;
		var hght1 = eval("document.all."+orderctlHDR1).offsetHeight;	*/	
		
		var wdth1 = getPos(orderctlHDR).x +wdth;
		var hght = getPos(orderctlHDR).y ;	

		bodwidth  = document.body.offsetWidth
		bodheight = document.body.offsetHeight
	
		var z = bodwidth- (event.x + wdth);	
		
		var x 	  = event.x;
		var y 	  = event.y;	

		x 	  = x + (document.getElementById("tooltiplayer").offsetWidth);
		y 	  = hght + (document.getElementById("tooltiplayer").offsetHeight);	

		if(x<bodwidth){
			x= wdth1;			
		}else{			
			x = getPos(orderctlHDR).x;
		}
		if(y<bodheight){			
			y = hght;
			
		}else
		{
			y = y - (document.getElementById("tooltiplayer").offsetHeight*2) + hght1 ;	
		}
	
		document.getElementById("tooltiplayer").style.posLeft= x;
		document.getElementById("tooltiplayer").style.posTop = y;
		document.getElementById("tooltiplayer").style.visibility='visible'
	}

	function displayToolTip(val,ord_cat,val1,orderId,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,sex,age,dob,visit_adm_date,cont_order_ind,order_status,iv_prep_yn,orderctlHDR,imgObj) {
		  	
			callMouseOverOnTD(orderctlHDR,imgObj);

			buildTable (val,ord_cat,val1,orderId,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,sex,age,dob,visit_adm_date,cont_order_ind,order_status,iv_prep_yn)
			resizeWindow(orderctlHDR)

	}


	function displayToolTip1(val,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,cont_order_ind,order_status,sex,age,dob,visit_adm_date,iv_prep_yn,orderctlHDR,imgObj) {
			
			callMouseOverOnTD(orderctlHDR,imgObj);

			buildTable1 (val,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,cont_order_ind,order_status,sex,age,dob,visit_adm_date,iv_prep_yn);
			resizeWindow(orderctlHDR)
	}


	function buildTable(val,ord_cat,val1,orderId,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,sex,age,dob,visit_adm_date,cont_order_ind,order_status,iv_prep_yn) {

        var rowval   = val.split (",");
		var row      = ("View,Cancels,Ammend,Discontinue,Hold,Resume,Renew,");
		rowval1      = row.split(",");
		var tab_dat  = "<table id='tooltiptable1' class='contextMenu' width='100%' height='100%' align='center'>"
		for( var i=0; i<rowval.length; i++ ) {
			var colval  = rowval[i]

			var colval1 = rowval1[i];
			if (colval != "")
			{
			
				tab_dat     += "<tr>"
				if(colval1 == "Ammend" || colval1 == "Renew")
				{
					queryString = document.existing_order_dtl.queryString.value;

					if (colval1 == "Renew" && (ord_cat != 'PH')) 
					{
						tab_dat     += "<td class = 'contextMenuItem'  id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class= 'contextMenuLink' href=javascript:callRenewFunctions('"+orderId+"','"+patient_id+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+escape(visit_adm_date)+"','"+iv_prep_yn+"','"+colval1+"','"+queryString+"')>"+colval+" </a></td>"
					} else 
					{
						//IN049419 Start.
						//tab_dat     += "<td class = 'contextMenuItem'  id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class= 'contextMenuLink' href=javascript:callAmmendFunctions('"+orderId+"','"+patient_id+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+escape(visit_adm_date)+"','"+iv_prep_yn+"','"+colval1+"')>"+colval+" </a></td>"
						tab_dat     += "<td class = 'contextMenuItem'  id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class= 'contextMenuLink' href=javascript:callAmmendFunctions('"+orderId+"','"+patient_id+"','"+ord_cat+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+escape(visit_adm_date)+"','"+iv_prep_yn+"','"+colval1+"')>"+colval+" </a></td>"
						//IN049419 End.
					}
				}else
				{
					tab_dat     += "<td class = 'contextMenuItem'  id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a  class= 'contextMenuLink' href=javascript:callMenuFunctions('"+colval1+"','"+patient_id+"','"+ord_cat+"','"+escape(val1)+"','"+orderId+"','"+cont_order_ind+"','"+order_status+"','"+sex+"','','','"+encntr_id+"','"+patient_class+"')>"+colval+" </a></td>"

					//function callMenuFunctions(colval1,patient_id,ord_cat,colval,orderId,cont_order_ind,order_status,sex,ord_typ_code,catalog_code,encounter_id,pat_class){
				}
				tab_dat     += "</tr> "
			}
		}
			tab_dat     += "</table> "
		document.getElementById("t").innerHTML = tab_dat
	}

	function buildTable1(val,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,cont_order_ind,order_status,sex,age,dob,visit_adm_date,iv_prep_yn) {

	    var rowval   = val.split (",");
		var row      = ("View,Cancel,Amend,Preps,Comments,Instructions,,Discontinue,Hold,Resume,Renew");
		rowval1      = row.split(",");
		var tab_dat  = "<table id='tooltiptable1' class='contextMenu' width='100%' height='100%' align='center'>"
		for( var i=0; i<rowval.length; i++ ) {
			var colval  = rowval[i]

			var colval1 = rowval1[i];
			if (colval != "")
			{
			
				tab_dat     += "<tr>";
				if (colval1 == "Renew" || colval1 == "Amend") {

					queryString = document.existing_order_dtl.queryString.value;

					if (colval1 == "Renew" && (ord_cat != 'PH')) {
						tab_dat     += "<td class = 'contextMenuItem'  id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class= 'contextMenuLink'   href=javascript:callRenewFunctions1('"+colval1+"','"+escape(val1)+"','"+ord_cat+"','"+orderId+"','"+cancel_type+"','"+order_line_num+"','"+catalog_code+"','"+item_narration+"','"+patient_id+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+order_status+"','"+sex+"','"+age+"','"+dob+"','"+escape(visit_adm_date)+"','"+iv_prep_yn+"','"+escape(queryString)+"')>"+colval+" </a></td>";
					} else {
						tab_dat     += "<td class = 'contextMenuItem'  id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class= 'contextMenuLink' href=javascript:callAmmendFunctions1('"+colval1+"','"+escape(val1)+"','"+ord_cat+"','"+orderId+"','"+cancel_type+"','"+order_line_num+"','"+catalog_code+"','"+item_narration+"','"+patient_id+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+order_status+"','"+sex+"','"+age+"','"+dob+"','"+escape(visit_adm_date)+"','"+iv_prep_yn+"')>"+colval+" </a></td>";
					}
				} else {
					tab_dat     += "<td class = 'contextMenuItem'  id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class= 'contextMenuLink' href=javascript:callMenuFunctions1('"+colval1+"','"+escape(val1)+"','"+ord_cat+"','"+orderId+"','"+cancel_type+"','"+order_line_num+"','"+catalog_code+"','"+item_narration+"','"+patient_id+"','"+cont_order_ind+"','"+order_status+"','"+sex+"')>"+colval+" </a></td>";
				}
				tab_dat     += "</tr> "
			}
		}
			tab_dat     += "</table> "
		document.getElementById("t").innerHTML = tab_dat
	}
	async function viewCanOrderFormatLineCmts(can_reason, line,order_line_num,orderId,view_by){
			
			//alert("order_line_num===="+order_line_num);
			
			var dialogHeight ='14' ;
			var dialogWidth = '29' ;
			var dialogTop	= '189';
			var dialogLeft = '167' ;
			var title = ''
			var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';
              /*if(can_reason=="Cancel Reason")
				can_reason=getLabel('eOR.CancelReason.label','OR');
			  else if(can_reason=="Discontinue")
				can_reason=getLabel('eOR.Discontinue.label','OR');
			else if(can_reason=="Comments")
				can_reason=getLabel('Common.Comments.label','Common');*/


			if(can_reason=="Comments")
				var narration = eval("document.existing_order_dtl.Cmts"+line+".value");
			else
				var narration = eval("document.existing_order_dtl.Cancel"+line+".value");

			var arguments = "";
			var finalString	= "can_reason="+encodeURIComponent(can_reason)+"&order_line_num="+order_line_num+"&orderId="+orderId+"&view_by="+view_by;
			var retVals = await window.showModalDialog("../../eOR/jsp/ViewLineComment.jsp?"+finalString,arguments,features);

}
	</script>

	<STYLE TYPE="text/css">
       
        TD.ORTOOLTIPS
	 {
		BACKGROUND-COLOR: ACTIVEBORDER;
		COLOR :BLACK;
		FONT-SIZE: 9PT ;
	 }
	TABLE.ORPOPUPMENUS
	 {
	   BORDER:2PX SOLID WHITE;
	   WIDTH:100%;
	   FONT-SIZE: SMALLER;
	   PADDING: 0;
	 }
	TD.ORMENU
	  {
		BACKGROUND-COLOR: #C0C0C0 ;
		FONT-SIZE: 9PT ;
		BORDER-STYLE: DASHED;
		BORDER-LEFT-COLOR: #FFA500;
		BORDER-RIGHT-COLOR: #FFA500;
		BORDER-TOP-COLOR: #FFFACD;
		BORDER-BOTTOM-COLOR: #FFFACD;
	  }

	 TD.ORMENULAYER
	  {
	 	  FONT-FAMILY: VERDANA ;
	 	  FONT-SIZE: 10PT ;
	 	  BACKGROUND-COLOR: #D8BFD8;
	 	  COLOR: WHITE;
	   }

  	</STYLE>
</head>
<body onscroll='moveFrame()' onload='FocusFirstElement()'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	/* Mandatory checks start */
	String mode	   = "1";//request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;

	String patient_id	= request.getParameter("patientId");
	String encounter_id	= request.getParameter("encntr_id");
	String bean_id 		= "@existingorderbean"+patient_id+encounter_id;

	String bean_name = "eOR.ExistingOrder";
	String bill_bean_id			 = "Or_billingQueryBean" ;
	String bill_bean_name		 = "eOR.OrderEntryBillingQueryBean";

	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String practitioner_type = (String)session.getValue("practitioner_type");

	
	String facility_id = (String)session.getValue("facility_id");
	String resp_id = (String)session.getValue("responsibility_id");
	String pract_reln_id = (String)request.getParameter("relationship_id");
	HashMap setBills_dtls			= null;
	HashMap bill_dtls				= null;
	String[] billing_details 		= null;
	ArrayList BillChargeInfo		= null;

	if(resp_id== null)resp_id = "";
	if(pract_reln_id== null) pract_reln_id= "";
	if(practitioner_id == null)practitioner_id = "";
	ArrayList allValues = new ArrayList();
	String[] OrderSetValues = new String[9];//IN072524
/* Mandatory checks end */

	/* Initialize Function specific start */
	//ExistingOrder bean = (ExistingOrder)mh.getBeanObject( bean_id, request,  bean_name ) ;
	ExistingOrder bean = (ExistingOrder)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(localeName);
	OrderEntryBillingQueryBean bill_bean = (OrderEntryBillingQueryBean)getBeanObject(bill_bean_id,bill_bean_name, request ) ;
	bill_bean.setLanguageId(localeName);
	//bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	//bean.setMode( mode ) ;

// THESE ARE THE PARAMS FOR AMMEND FUNCTION

	String location_type			= bean.checkForNull(request.getParameter("location_type"),"");
	String location_code			= bean.checkForNull(request.getParameter("location_code"),"");
	String patient_class			= bean.checkForNull(request.getParameter("patient_class"),"");
	String p_called_from_ca			= bean.checkForNull(request.getParameter("p_called_from_ca"),"");
	String sex						= bean.checkForNull(request.getParameter("sex"),"");
	String age						= bean.checkForNull(request.getParameter("age"),"");
	String dob						= bean.checkForNull(request.getParameter("dob"),"");
	String visit_adm_date			= bean.checkForNull(request.getParameter("visit_adm_date"),"");

// THESE ARE THE PARAMS FOR AMMEND FUNCTION - END

	String patientId		= request.getParameter( "patientId" ) ;
	String encntr_id		= request.getParameter( "encntr_id" ) ;
	String order_status		= request.getParameter( "ord_status" ) ;
		order_status		= "Z"; // By default make the order_status as "Z", should bring the record for all status
	String order_by			= request.getParameter( "order_by" ) ;
	String catalog			= request.getParameter( "catalog" ) ;
	String view				= request.getParameter( "view" ) ;
	String priority			= request.getParameter( "priority" ) ;
	String date_from		= request.getParameter( "date_from" ) ;
	String date_to			= request.getParameter( "date_to" ) ;
	String order_category	= request.getParameter( "order_category" ) ;
	String order_type		= request.getParameter( "order_type" ) ;
	String view_by			= request.getParameter( "view_by" ) ;
 	String search_criteria	= request.getParameter( "search_criteria" ) ;
	String cosign			= request.getParameter( "cosign" ) ;
	String orderId			= request.getParameter( "orderId" ) ; // Will get orderId only if it is for OrderSet results
	String allow_cancel_yn	= "" ; // Will get orderId only if it is for OrderSet results

	String show_bill_info_yn = bean.getBillingInterfaceShowYn(facility_id); //added for IN035929[IN040092]	
	
	if(patientId != null )patientId = patientId.trim();			else patientId = "";
	if(encntr_id != null )encntr_id = encntr_id.trim();			else encntr_id = "";
	if(orderId != null )orderId = orderId.trim();			else orderId = "";
	

	if(view != null )view = view.trim();						else view = "";
	if(order_status != null )order_status = order_status.trim();else order_status = "";
	if(priority != null )priority = priority.trim();			else priority = "";
	if(date_from != null )date_from = date_from.trim();			else date_from = "";
	if(date_to != null )date_to = date_to.trim();				else date_to = "";
	if(order_category != null )order_category = order_category.trim();	else order_category = "";
	if(order_type != null )order_type = order_type.trim();		else order_type = "";
	if(cosign != null )cosign = cosign.trim();					else cosign = "";
	if(catalog != null )catalog = catalog.trim();				else catalog = "";
	if(search_criteria != null )search_criteria = search_criteria.trim();	else search_criteria = "";
	if(order_by != null )order_by = order_by.trim();			else order_by = "";
	if(view_by != null )view_by = view_by.trim();				else view_by = "";

	//allValues		= bean.getOrderSetSearchDetails(view,patientId,encntr_id,order_status,catalog,date_from,date_to,order_category,order_type,search_criteria,priority,view_by, orderId,practitioner_type);
	allValues		= bean.getOrderSetSearchDetails(view,patientId,encntr_id,order_status,catalog,date_from,date_to,order_category,order_type,search_criteria,priority,view_by, orderId,practitioner_type);
 
	if(allValues.size() == 0){
%>
		<script>
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","COMMON"));
			if(parent.parent.ExistingOrderSearch){
				parent.parent.ExistingOrderHeader.location.href = "../../eCommon/html/blank.html"
				parent.parent.ExistingOrderResult.location.href = "../../eCommon/html/blank.html"
			}else if(parent.ExistingOrderSearch){
				parent.ExistingOrderHeader.location.href = "../../eCommon/html/blank.html"
				parent.ExistingOrderResult.location.href = "../../eCommon/html/blank.html"
			}
			parent.window.close();
		</script>

<%	}
%>
<form name='existing_order_dtl' id='existing_order_dtl' target='messageFrame' >
<table cellpadding=3 cellspacing=0 border=0 width="100%" align='center' id="tableresult" class="grid">
<%
	String slClassValue = "";
	String src_type = "";
	//String tmp_ord_cat = "";
	String fontValue = "";

	String cont_order_ind = "";
	//String printEnable   = null;

	String[] existing_details = null;
	String can_reason = null;
 	//String menu_security1 = (String)bean.getMenu("AMEND_ORDER",resp_id,pract_reln_id);
	//String menu_security2 = null;
	//String menu_security_hold = (String)bean.getMenu("HOLD",resp_id,pract_reln_id);
	//String menu_security_resume = (String)bean.getMenu("RESUME",resp_id,pract_reln_id);
	//String line_menu_security1 = (String)bean.getMenu("CANCEL_ORDER",resp_id,pract_reln_id);
	//String line_menu_security2 = (String)bean.getMenu("DISCONTINUE",resp_id,pract_reln_id);
	String order_grouping_category = null;
	String color_string="";
	StringTokenizer colorTokenizer=null;
	StringTokenizer menu_options=null;
//	Added by Sridhar Reddy on 11/11/2008 for Displaytooltip
	StringBuffer strOrderCtl = new StringBuffer();	
	String billing_interface_yn = "N";
	billing_interface_yn = bill_bean.getBillingInterfaceYn();
	//String bl_info_display = "";
	//String careset_cat_desc = "";
	String order_set_bill_yn = "N";
	OrderSetValues=bill_bean.getOrderSetDetails(bean.checkForNull(orderId,""));
	String order_line_num=bean.checkForNull(OrderSetValues[1],"");
	String dateString=bean.checkForNull(OrderSetValues[2],"");
	String bill_order_catalog_code=bean.checkForNull(OrderSetValues[3],"");
	String order_qty=bean.checkForNull(OrderSetValues[4],"");
	order_set_bill_yn=bean.checkForNull(OrderSetValues[5],"");
	String bill_order_category=bean.checkForNull(OrderSetValues[6],"");
	String fpp_yn=bean.checkForNull(OrderSetValues[9],"");//IN072524
	String fpp_category=bean.checkForNull(OrderSetValues[10],"");//IN072524
	//String bill_order_set_desc=bean.checkForNull(OrderSetValues[7],"");
	if(billing_interface_yn.equals("Y") && order_set_bill_yn.equalsIgnoreCase("Y") && !bill_order_category.equals("BT"))
	{
		int numbering=0;
		//String displaytooltip="";
		//qty_value1 records[0]DP011G3 dateString28/02/2009 11:33 localeNameen bean.getPatientId()0000000310 bean.getEncounterId()10011862 bean.getPatientClass()IP bean.getPractitionerId()NAREN 
		//IN072524 Starts
		if("Y".equals(fpp_yn)){
			BillChargeInfo		= bill_bean.getBillChargeDetailsfpp(order_qty,bill_order_catalog_code,dateString,localeName, orderId,order_line_num,patient_id,encntr_id,patient_class,practitioner_id,fpp_yn,fpp_category) ;
		}
		else{
			BillChargeInfo		= bill_bean.getBillChargeDetails(order_qty,bill_order_catalog_code,dateString,localeName, orderId,order_line_num,patient_id,encntr_id,patient_class,practitioner_id) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
		}
		//IN072524 Ends
		if(BillChargeInfo==null) 
			BillChargeInfo= new ArrayList();
		billing_details = null;
		for( int m=0 ; m< BillChargeInfo.size() ; m++ ) 
		{
			billing_details 	= (String[])BillChargeInfo.get(m);
			setBills_dtls		= new HashMap();
			setBills_dtls.put("charged_yn"       , billing_details[1]);
			setBills_dtls.put("total_payable"    , billing_details[2]);
			setBills_dtls.put("patient_payable"  , billing_details[3]);
			setBills_dtls.put("quantity"         ,order_qty);
			setBills_dtls.put("incl_excl_action" , billing_details[4]);
			setBills_dtls.put("preapp_yn"        , billing_details[5]);
			setBills_dtls.put("patient_paid_amt" , billing_details[6]);
			setBills_dtls.put("bl_panel_str"     , billing_details[0]);
			setBills_dtls.put("serv_panel_ind"   , billing_details[10]);
			setBills_dtls.put("serv_panel_code"  , billing_details[11]);
			setBills_dtls.put("p_episode_type"	 , billing_details[13]);
			setBills_dtls.put("p_episode_id"	 , billing_details[14]);
			setBills_dtls.put("p_visit_id"		 , billing_details[15]);
			setBills_dtls.put("Future_order_yn"		 , billing_details[17]);
			setBills_dtls.put("rate"		 , "");
			setBills_dtls.put("excl_incl_ind_for_screen"		 , billing_details[4]);
			setBills_dtls.put("mod_physician_id"		 , billing_details[20]);
				
			setBills_dtls.put("fpp_yn"		 , fpp_yn);//IN072524
			setBills_dtls.put("fpp_category"		 , fpp_category);//IN072524
			//servicepanel=bean.checkForNull(billing_details[10],"");
			//servicepanelcode=bean.checkForNull(billing_details[11],"");
			bill_bean.setOrderBillDtls(patientId+encntr_id+bill_order_catalog_code, setBills_dtls); 
			 if(!billing_details[9].equals(""))
			{
				numbering=1;
			%> 
			<script>alert("<%=billing_details[9]%>");</script>
			<% 
			}
			if(billing_details[10].equals("")||billing_details[11].equals(""))
			{
						numbering=1;
			%>
			<script>
					var msg=getMessage("BILLING_SERVICE_NOT_DEFINED","OR");
					msg=msg.replace('{1}',"<%=bill_order_catalog_code%>");
					alert(msg);
			</script>
			<% 
				}
			}
			if(numbering==1&& order_set_bill_yn.equalsIgnoreCase("Y"))
			{	
			%>
			<script>
					//parent.criteriaDetailFrame.document.getElementById("recordApply").disabled=true;
			</script>
			<%
			}
			bill_dtls = (HashMap)bill_bean.getOrderBillDtls(patient_id+encntr_id+bill_order_catalog_code);
	%>
					<tr><td class="<%=slClassValue%>"></td><td class="<%=slClassValue%>"></td><td class="<%=slClassValue%>"></td><td colspan="6" class="<%=slClassValue%>"><table cellpadding=0 cellspacing=0 border=0 width='100%' align='right' <%if(show_bill_info_yn.equals("Y")) {%>style='border-width:0;display:inline'<%}else{%>style='border-width:0;display:none' <%}%> class="grid"> <!--  condition added for IN035929[IN040092] -->
				
					<tr ><td colspan="" width='20%' class="<%=slClassValue%>" style='border-width: 0;text-align: right;'><font class='label' size="1"><B><fmt:message key="Common.total.label" bundle="${common_labels}"/></B></font></td>
						<td colspan="" width='20%' class="<%=slClassValue%>" style='border-width: 0;text-align: right;'><font class='label' size="1"><B><fmt:message key="Common.patient.label" bundle="${common_labels}"/></B></font></td>
						<%
						if(bean.checkForNull((String)bill_dtls.get("serv_panel_ind"),"").equalsIgnoreCase("S"))
						{
						%>
							<td colspan="" width='25%' class="<%=slClassValue%>" style='border-width: 0;text-align: center;'><font class='label' size="1"><B><fmt:message key="Common.Included.label" bundle="${common_labels}"/></B></font></td>
							<td colspan="" width='25%' class="<%=slClassValue%>" style='border-width: 0;text-align: center;'><font class='label' size="1"><B><fmt:message key="eOR.ApprovalReqd.label" bundle="${or_labels}"/></B></font></td>
						<%
						}
						%>
					</tr>
					<tr>
						<td colspan="" class="<%=slClassValue%>" style='border-width: 0;text-align: right;'><font class='label' size="1"><span id='actual_<%=bill_order_catalog_code%>'><%=bean.checkForNull((String)bill_dtls.get("total_payable"),"0.0")%></span></font></td>
						<td colspan="" class="<%=slClassValue%>" style='border-width: 0;text-align: right;'><font class='label' size="1"><span id='payable_<%=bill_order_catalog_code%>'><%=bean.checkForNull((String)bill_dtls.get("patient_payable"),"0.0")%></span></font></td>
						<%
						if(bean.checkForNull((String)bill_dtls.get("serv_panel_ind"),"").equalsIgnoreCase("S"))
						{
						%>
							<td colspan="" class="<%=slClassValue%>" style='border-width: 0;text-align: center;'><font class='label' size="1"><span id='included_<%=bill_order_catalog_code%>'><%=bean.checkForNull((String)bill_dtls.get("incl_excl_action"),"").equals("E")?"No":(bean.checkForNull((String)bill_dtls.get("incl_excl_action"),"").equals("I")?"Yes":"")%></span></font></td>
							<td colspan="" class="<%=slClassValue%>" style='border-width: 0;text-align: center;'><font class='label' size="1"><span id='approved_<%=bill_order_catalog_code%>'><%=bean.checkForNull((String)bill_dtls.get("preapp_yn"),"").equals("Y")?"Yes":(bean.checkForNull((String)bill_dtls.get("preapp_yn"),"").equals("N")?"No":"")%></span></font>
							</td>
						<%
						}
						%>
					</tr>
				</table></td></tr>
	<%
	}
	// end
	for(int i=0; i<allValues.size(); i++){
		//printEnable = "Y";
		if(strOrderCtl.length() > 0)
			strOrderCtl = strOrderCtl.delete(0,strOrderCtl.length());
		
		existing_details = (String[])allValues.get(i);

        if(existing_details[0] == null) existing_details[0] = "";
        if(existing_details[1] == null) existing_details[1] = "";
        if(existing_details[2] == null) existing_details[2] = "";
        if(existing_details[3] == null) existing_details[3] = "";
        if(existing_details[4] == null) existing_details[4] = "";
        if(existing_details[5] == null) existing_details[5] = "";
        if(existing_details[6] == null) existing_details[6] = "";
        if(existing_details[7] == null) existing_details[7] = "";
		if(existing_details[8] == null) existing_details[8] = "";
		if(existing_details[9] == null) existing_details[9] = "";
		if(existing_details[10] == null) existing_details[10] = "";
		if(existing_details[11] == null) existing_details[11] = "";
        if(existing_details[12] == null) existing_details[12] = "";
        if(existing_details[13] == null) existing_details[13] = "";
        if(existing_details[14] == null) existing_details[14] = "";
        if(existing_details[15] == null) existing_details[15] = "";
        if(existing_details[16] == null) existing_details[16] = "";
        if(existing_details[17] == null) existing_details[17] = "";
		if(existing_details[18] == null) existing_details[18] = "";
		if(existing_details[19] == null) existing_details[19] = "";
		if(existing_details[20] == null) existing_details[20] = "";
		if(existing_details[21] == null) existing_details[21] = "";
        if(existing_details[22] == null) existing_details[22] = "";
        if(existing_details[23] == null) existing_details[23] = "";
        if(existing_details[24] == null) existing_details[24] = "";
       /* if(i % 2 == 0){
			slClassValue = "QRYEVEN";
		}else{
			slClassValue = "QRYODD";
		}*/
		slClassValue="gridData";

		if(view_by.trim().equals("L")){

			menu_options			= new StringTokenizer(existing_details[15],"|");
							
			if(menu_options.hasMoreTokens()){
				existing_details[15] = menu_options.nextToken();  //AMEND        
				allow_cancel_yn = menu_options.nextToken();  //Cancel        
				existing_details[16] = menu_options.nextToken();  //DISCONTINUE         
				existing_details[22] = menu_options.nextToken();  //HOLD                
				existing_details[23] = menu_options.nextToken();  //RESUME              
				existing_details[26] = menu_options.nextToken();  //RENEW               
				existing_details[17] = menu_options.nextToken();  //RESULT_HYPER_LINK   
				//existing_details[29] = "Y";
			}

			if(existing_details[25] == null) existing_details[25] = "";
        	if(existing_details[26] == null) existing_details[26] = "N";
        	if(existing_details[27] == null) existing_details[27] = "";
        	if(existing_details[28] == null) existing_details[28] = "";
        	if(existing_details[29] == null) existing_details[29] = "";
        	if(existing_details[30] == null) existing_details[30] = "";
			cont_order_ind = existing_details[21];
		}else{
			menu_options			= new StringTokenizer(existing_details[12],"|");
							
			if(menu_options.hasMoreTokens()){
				existing_details[12] =	menu_options.nextToken();  //AMEND
				allow_cancel_yn =	menu_options.nextToken();  //AMEND
				existing_details[15] =	menu_options.nextToken();  //DISCONTINUE 
				existing_details[20] =	menu_options.nextToken();  //HOLD 
				existing_details[21] =	menu_options.nextToken();  //RESUME 
				existing_details[23] =	menu_options.nextToken();  //RENEW 
				existing_details[14] =	menu_options.nextToken();  //RESULT_HYPER_LINK 
			}

		}
%>
	<% 
	if(!existing_details[0].equals(order_grouping_category)) { %>
 	<tr>

	   <td <%if(view_by.trim().equals("L")){ out.println("colspan='9'"); } else{ out.println("colspan='6'"); } %> class="CAHIGHERLEVELCOLOR"> <%=existing_details[1]%>
		
		   </td>
	</tr>
	<% } %>

  		
	</tr>
	<tr>
	
	<tr>
	<%if(view_by.trim().equals("L")){

        String [] colorString = {"X","X","X","X"};
{
            color_string = bean.getColorCodings(facility_id,existing_details[9],existing_details[12],existing_details[11]);
            colorTokenizer = new StringTokenizer(color_string,",");
            int index = 0;
            while(colorTokenizer.hasMoreTokens()) {
                String tempToken = colorTokenizer.nextToken();
                 if (tempToken.equals("#7FFF00"))
                    colorString[index] = "QRY1";
                else if (tempToken.equals("#008000"))
                    colorString[index] = "QRY2";
                else if (tempToken.equals("#A52A2A"))
                    colorString[index] = "QRY3";
                else if (tempToken.equals("#FF0000"))
                    colorString[index] = "QRY4";
                else if (tempToken.equals("#0000CD"))
                    colorString[index] = "QRY5";
                else if (tempToken.equals("#808000"))
                    colorString[index] = "QRY6";
                else if (tempToken.equals("#CD5C5C"))
                    colorString[index] = "QRY7";
				else if (tempToken.equals("#D8BFD8"))
                    colorString[index] = "QRY8";
				else if (tempToken.equals("#DDA0DD"))  //OLD #F5DEB3  
                    colorString[index] = "QRY9";
				else if (tempToken.equals("#F4A460"))
                    colorString[index] = "QRY10";
				else if (tempToken.equals("LIGHTYELLOW"))
                    colorString[index] = "LIGHTYELLOW";
				else if (tempToken.equals("BROWN"))
                    colorString[index] = "BROWN";
			    else if (tempToken.equals("X"))
					colorString[index] = slClassValue; 

                index++;
            }
        }

    %>
	<td width='' nowrap class='<%=((colorString[0].equals("X"))?slClassValue:colorString[0])%>'></td>
	<td width='' nowrap class='<%=((colorString[2].equals("X"))?slClassValue:colorString[2])%>'></td>
	<td width='' nowrap class='<%=slClassValue%>'> <%=existing_details[27]%></td>
	<td width='' nowrap class='<%=slClassValue%>'> <%=existing_details[28]%></td>
	<%} else {%>
		<td width='' nowrap class='<%=slClassValue%>'> <%=existing_details[7]%></td>
	<%}%>
		<td width='' nowrap class='<%=slClassValue%>'>
		<%
			if(existing_details[10].trim().equalsIgnoreCase("U")){
				fontValue = "<font size=1 color=red><b>";  // this is to indicate the different color for urgency
				existing_details[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");

			}else if(existing_details[10].trim().equalsIgnoreCase("S")){
				fontValue = "<font size=1 color=brown><b>";  // this is to indicate the different color for Stat
               existing_details[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");

			}else{
				fontValue = "<font size=1 color=black><b>";
				existing_details[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
			}

		%>
		<%=fontValue%><%=existing_details[2]%></td>
 <%if(view_by.trim().equals("L")){
			
			
			
			
			%>
			<input type='hidden' name='line_num<%=i%>' id='line_num<%=i%>' value="<%=existing_details[11]%>">
			<input type='hidden' name='catalog_code<%=i%>' id='catalog_code<%=i%>' value="<%=existing_details[12]%>">
			<input type='hidden' name='item_narration<%=i%>' id='item_narration<%=i%>' value="<%=existing_details[13]%>">
			<input type='hidden' name='location_code<%=i%>' id='location_code<%=i%>' value="<%=existing_details[19]%>">
			<input type='hidden' name='patient_class<%=i%>' id='patient_class<%=i%>' value="<%=existing_details[20]%>">
			<input type='hidden' name='cont_order_ind<%=i%>' id='cont_order_ind<%=i%>' value="<%=cont_order_ind%>">
			<input type='hidden' name='copy_yn<%=i%>' id='copy_yn<%=i%>' value="<%=existing_details[30]%>">
			<input type='hidden' name='source_type<%=i%>' id='source_type<%=i%>' value="<%=existing_details[18]%>">

		<%}else{
			cont_order_ind = existing_details[19];
		%>
			<input type='hidden' name='location_code<%=i%>' id='location_code<%=i%>' value="<%=existing_details[17]%>">
			<input type='hidden' name='patient_class<%=i%>' id='patient_class<%=i%>' value="<%=existing_details[18]%>">
			<input type='hidden' name='cont_order_ind<%=i%>' id='cont_order_ind<%=i%>' value="<%=cont_order_ind%>">
            <input type='hidden' name='copy_yn<%=i%>' id='copy_yn<%=i%>' value="<%=existing_details[24]%>">
            <input type='hidden' name='source_type<%=i%>' id='source_type<%=i%>' value="<%=existing_details[16]%>">
		<%


		  }%>
		    <input type='hidden' name='order_category<%=i%>' id='order_category<%=i%>' value="<%=existing_details[0]%>">
			<input type='hidden' name='ord_typ_code<%=i%>' id='ord_typ_code<%=i%>' value="<%=existing_details[4]%>">
			<input type='hidden' name='ord_typ_desc<%=i%>' id='ord_typ_desc<%=i%>' value="<%=existing_details[8]%>">
			<input type='hidden' name='ord_id<%=i%>' id='ord_id<%=i%>' value="<%=existing_details[9]%>">
	
	<%				  
		  if((view_by.trim()).equals("H")) {%>
			<td width='' nowrap class='<%=slClassValue%>'> <%=existing_details[8]%></td>
	
	<%	
			strOrderCtl.append("<td width='' nowrap id='orderctl"+i+"' style='cursor:pointer' class='gridDataBlue' ");
			
			//menu_security = "";
			//menu_security1 = "";
			if (existing_details[22]==null)existing_details[22] = "";
			if (existing_details[23].equals("")) existing_details[23] = "N";
			
			//if(existing_details[12].trim().equals("Y"))
			//{
				//menu_security = (String)bean.getMenu("CANCEL_ORDER",resp_id,pract_reln_id);
				//menu_security1 = (String)bean.getMenu("AMEND_ORDER",resp_id,pract_reln_id);

					//if(line_menu_security1.trim().equals("A") && menu_security1.trim().equals("A") )
					//{				
						//strOrderCtl.append(" onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+','+getLabel('Common.cancel.label','Common')+','+getLabel('Common.Amend.label','COMMON')+',,,,"+((existing_details[23].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','"+patientId+"','"+encounter_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+cont_order_ind+"','"+existing_details[13]+"','"+existing_details[22]+"',this,'imgArrow"+i+"')\"   onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
					//} else if(line_menu_security1.trim().equals("A") && menu_security1.trim().equals("") )
					//{
						//strOrderCtl.append("  onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+','+getLabel('Common.cancel.label','Common')+',,'+getLabel('Common.Discontinue.label','COMMON')+',,,"+((existing_details[23].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','"+patientId+"','"+encounter_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+cont_order_ind+"','"+existing_details[13]+"','"+existing_details[22]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
					//} else if(line_menu_security1.trim().equals("") && menu_security1.trim().equals("A") )
					//{
						//strOrderCtl.append("  onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',,'+getLabel('Common.Amend.label','COMMON')+','+getLabel('Common.Discontinue.label','COMMON')+',,,"+((existing_details[23].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','"+patientId+"','"+encounter_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+cont_order_ind+"','"+existing_details[13]+"','"+existing_details[22]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
					//}else 
					//{
						//strOrderCtl.append("  onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',,,,,,"+((existing_details[23].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','"+patientId+"','"+encounter_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+cont_order_ind+"','"+existing_details[13]+"','"+existing_details[22]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
					//}
			//}else if(existing_details[15].trim().equals("Y") && existing_details[20].trim().equals("Y"))
			//{				
				 //menu_security2 = (String)bean.getMenu("DISCONTINUE",resp_id,pract_reln_id);
				 //menu_security_hold = (String)bean.getMenu("HOLD",resp_id,pract_reln_id);
					//if(line_menu_security2.trim().equals("A") &&menu_security_hold.trim().equals("A"))
					//{
						//strOrderCtl.append("  onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',,,'+getLabel('Common.Discontinue.label','COMMON')+','+getLabel('Common.Hold.label','COMMON')+',,"+((existing_details[23].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','"+patientId+"','"+encounter_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+cont_order_ind+"','"+existing_details[13]+"','"+existing_details[22]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
					//}else if((line_menu_security2.trim().equals("X") || line_menu_security2.trim().equals("")) &&menu_security_hold.trim().equals("A"))
					//{
						//strOrderCtl.append("  onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',,,,'+getLabel('Common.Hold.label','COMMON')+',,"+((existing_details[23].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','"+patientId+"','"+encounter_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+cont_order_ind+"','"+existing_details[13]+"','"+existing_details[22]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
					//}else if(line_menu_security2.trim().equals("A") &&(menu_security_hold.trim().equals("X") || menu_security_hold.trim().equals("")))
					//{
						//strOrderCtl.append("  onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',,,'+getLabel('Common.Discontinue.label','COMMON')+',,,"+((existing_details[23].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','"+patientId+"','"+encounter_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+cont_order_ind+"','"+existing_details[13]+"','"+existing_details[22]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
					//}else{
						//strOrderCtl.append(" onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',,,,,,"+((existing_details[23].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','"+patientId+"','"+encounter_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+cont_order_ind+"','"+existing_details[13]+"','"+existing_details[22]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
					//}
			//}else if(existing_details[15].trim().equals("Y")) {
 					//menu_security2 = (String)bean.getMenu("DISCONTINUE",resp_id,pract_reln_id);
					//if(line_menu_security2.trim().equals("A"))
					//{
						//strOrderCtl.append(" onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',,,'+getLabel('Common.Discontinue.label','COMMON')+',,,"+((existing_details[23].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','"+patientId+"','"+encounter_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+cont_order_ind+"','"+existing_details[13]+"','"+existing_details[22]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
					//}else{
						//strOrderCtl.append(" onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',,,,,,"+((existing_details[23].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','"+patientId+"','"+encounter_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+cont_order_ind+"','"+existing_details[13]+"','"+existing_details[22]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
					//}
			//}else if (existing_details[20].trim().equals("Y")) 
			//{
				 //menu_security_hold = (String)bean.getMenu("HOLD",resp_id,pract_reln_id);
					//if(menu_security_hold.trim().equals("A"))
					//{
						//strOrderCtl.append(" onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',,,,'+getLabel('Common.Hold.label','COMMON')+',,"+((existing_details[23].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','"+patientId+"','"+encounter_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+cont_order_ind+"','"+existing_details[13]+"','"+existing_details[22]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
					//}else{
						//strOrderCtl.append(" onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',,,,,,"+((existing_details[23].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','"+patientId+"','"+encounter_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+cont_order_ind+"','"+existing_details[13]+"','"+existing_details[22]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
					//}
			//}else if(existing_details[21].trim().equals("Y") )
			//{ // Resume Check
				 //menu_security_resume = (String)bean.getMenu("RESUME",resp_id,pract_reln_id);
					//if(menu_security_resume.trim().equals("A") )
					//{
						//strOrderCtl.append(" onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',,,,,'+getLabel('eOR.Resume.label','OR')+',"+((existing_details[23].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','"+patientId+"','"+encounter_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+cont_order_ind+"','"+existing_details[13]+"','"+existing_details[22]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
					//}else
					//{
					//	strOrderCtl.append(" onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',,,,,,"+((existing_details[23].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','"+patientId+"','"+encounter_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+cont_order_ind+"','"+existing_details[13]+"','"+existing_details[22]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
					//}
			//}else
			//{
					//strOrderCtl.append(" onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',,,,,,"+((existing_details[23].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','"+patientId+"','"+encounter_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+cont_order_ind+"','"+existing_details[13]+"','"+existing_details[22]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
			//}
			strOrderCtl.append("  onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',"+((allow_cancel_yn.trim().equals("Y"))?"'+getLabel('Common.cancel.label','Common')+'":"")+","+((existing_details[12].trim().equals("Y"))?"'+getLabel('Common.Amend.label','Common')+'":"")+","+((existing_details[15].trim().equals("Y"))?"'+getLabel('Common.Discontinue.label','Common')+'":"")+","+((existing_details[20].trim().equals("Y"))?"'+getLabel('Common.Hold.label','Common')+'":"")+","+((existing_details[21].trim().equals("Y"))?"'+getLabel('eOR.Resume.label','OR')+'":"")+","+((existing_details[23].trim().equals("Y"))? "'+getLabel('eOR.Renew.label','OR')+'" : "")+",','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','"+patientId+"','"+encounter_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+cont_order_ind+"','"+existing_details[13]+"','"+existing_details[22]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");

 
 	}else if((view_by.trim()).equals("L")) {%>

	<td width='' nowrap class='<%=slClassValue%>'> <%=existing_details[8]%></td>
	<%	
			strOrderCtl.append("<td width='' nowrap id='orderctl"+i+"' style='cursor:pointer' class='gridDataBlue' ");	
			

			//line_menu_security1 = "";
			//line_menu_security2 = "";
			//menu_security_hold  = "";

			//if(existing_details[15].trim().equals("Y") )
			//{ //cancel check
				
				//line_menu_security1 = (String)bean.getMenu("CANCEL_ORDER",resp_id,pract_reln_id);
				
				//if(line_menu_security1.trim().equals("A"))
				//{					
					//strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+','+getLabel('Common.cancel.label','Common')+','+getLabel('Common.Amend.label','COMMON')+','+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,,,,"+((existing_details[26].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");  					

				//}else
				//{						   
					//strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',,,'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,,,,"+((existing_details[26].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
	
				//}
			//}else if( existing_details[16].trim().equals("Y") && existing_details[22].trim().equals("Y"))
			//{//discontinue check & hold
				
				//- Temporrily Hold in the line level is commented and will be incorporated by uncommenting the required lines when it requires
				//line_menu_security2 = (String)bean.getMenu("DISCONTINUE",resp_id,pract_reln_id);
				//menu_security_hold = (String)bean.getMenu("HOLD",resp_id,pract_reln_id);

					//if(line_menu_security2.trim().equals("A") && menu_security_hold.trim().equals("A"))
					//{	
						//strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',,,'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,'+getLabel('Common.Discontinue.label','COMMON')+',,,"+((existing_details[26].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");		
		
					//}else if((line_menu_security2.trim().equals("X")|| line_menu_security2.trim().equals("")) && menu_security_hold.trim().equals("A"))
					//{
	
				 		//strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',,,'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,,,,"+((existing_details[26].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");

					//}else if(line_menu_security2.trim().equals("A") && (menu_security_hold.trim().equals("X") || menu_security_hold.trim().equals("")))
					//{	
				 		//strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',,,'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,'+getLabel('Common.Discontinue.label','COMMON')+',,,"+((existing_details[26].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
					//}else
					//{	
						//strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',,,'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,,,,"+((existing_details[26].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
					//}
			//}
			//else if( existing_details[16].trim().equals("Y"))
			//{//discontinue check
				
				//- Temporrily Hold in the line level is commented and will be incorporated by uncommenting the required lines when it requires
				//line_menu_security2 = (String)bean.getMenu("DISCONTINUE",resp_id,pract_reln_id);

					//if(line_menu_security2.trim().equals("A"))
					//{	
						 //strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',,,'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,'+getLabel('Common.Discontinue.label','COMMON')+',,,"+((existing_details[26].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
					//}else
					//{
						//strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',,,'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,,,,"+((existing_details[26].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
					//}
			//}else if( existing_details[22].trim().equals("Y"))
			//{//hold check
				
				//- Temporrily Hold in the line level is commented and will be incorporated by uncommenting the required lines when it requires
				//menu_security_hold = (String)bean.getMenu("HOLD",resp_id,pract_reln_id);

					//if(menu_security_hold.trim().equals("A"))
					//{
						// strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',,,'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,,'+getLabel('Common.Hold.label','COMMON')+',,"+((existing_details[26].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
					//}else
					//{
						//strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',,,'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,,,,"+((existing_details[26].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");	
					//}
			//}else if( existing_details[23].trim().equals("Y"))
			//{//Resume check
				 //menu_security_resume = (String)bean.getMenu("RESUME",resp_id,pract_reln_id);
					//if(menu_security_resume.trim().equals("A") )
					//{
		
						//strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',,,'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,,,'+getLabel('eOR.Resume.label','OR')+',"+((existing_details[26].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
				//}
			//}else 
			//{	
					//strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',,,'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,,,,"+((existing_details[26].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
	
			//}
			strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',"+((allow_cancel_yn.trim().equals("Y"))?"'+getLabel('Common.cancel.label','Common')+'":"")+","+((existing_details[15].trim().equals("Y"))?"'+getLabel('Common.Amend.label','Common')+'":"")+",'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,"+((existing_details[16].trim().equals("Y"))?"'+getLabel('Common.Discontinue.label','Common')+'":"")+","+((existing_details[22].trim().equals("Y"))?"'+getLabel('Common.Hold.label','Common')+'":"")+","+((existing_details[23].trim().equals("Y"))?"'+getLabel('eOR.Resume.label','OR')+'":"")+","+((existing_details[23].trim().equals("Y"))? "'+getLabel('eOR.Renew.label','OR')+'" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"',this,'imgArrow"+i+"')\" onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
		}

		if(existing_details[3].indexOf("$$RD##")!=-1)
		{
			String[] str = (String[])existing_details[3].split("!~!");
			String order_detail ="";
			String[] strtitle = null;
			for(int s=0;s<str.length;s++)
			{
				if(str[s].indexOf("$$RD##")!=-1)
				{
					String line_order = (String)str[s];
					strtitle  =line_order.split("::");
					String titleText = "";
					if(strtitle[1].length()>0)
					{
						titleText = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderedFromRadiology.label","or_labels")+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Reason.label","or_labels")+":"+ strtitle[1];
					}
					else
					{
						titleText = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderedFromRadiology.label","or_labels");
					}
					strtitle[0] = "<img src='../../eOR/images/IN_RD_ADD_TEST.gif' title='"+titleText+"'>";
					order_detail = order_detail+strtitle[0]+strtitle[2]+", ";
				}
				else
				{
					order_detail = order_detail+str[s]+", ";
				}
			}
			existing_details[3] = order_detail;
			if(existing_details[3].lastIndexOf(",") ==((existing_details[3].length())-2))
			{
				existing_details[3] = existing_details[3] .substring(0,((existing_details[3].length())-2));
			}
		}
		if(existing_details[3].indexOf("!~!")!=-1)
		{
			existing_details[3] = existing_details[3].replace("!~!",",");
		}
		strOrderCtl.append(existing_details[3]);
		strOrderCtl.append("<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+i+"'></td>");

		out.println(strOrderCtl.toString());
	%>
		
<!-- 		sample for line level		<a href='javascript: dummy()' onClick="displayToolTip1('View,Cancel,Preps,Comments,Instructions,,Discontinue','<%=existing_details[0]%>','<%=existing_details[1]%>','<%=existing_details[9]%>','CN','<%=existing_details[11]%>','<%=existing_details[12]%>','<%=i%>','<%=patientId%>')"  onMouseOver='hideToolTip()'> -->
		
		<!-- </td> -->
		<td width='' nowrap class='<%=slClassValue%>'> <%=existing_details[5]%>  </td>
		<td width='' nowrap class='<%=slClassValue%>'> 
		<%	if(!(view_by.trim().equals("L"))){
				if(existing_details[14].trim().equals("Y")){
					//printEnable = "N";
		%>
					<a class="gridLink"  href="javascript:resultViewOrder('Result','<%=existing_details[1]%>','<%=existing_details[9]%>','','<%=cont_order_ind%>','<%=patientId%>','<%=existing_details[0]%>')">
					<%=existing_details[6]%> </a>
		<%		}else{
					out.println(existing_details[6]);
				}
			}else if((view_by.trim().equals("L"))){
				if(existing_details[17].trim().equals("Y")){
					//printEnable = "N";
		%>
					<a class="gridLink"  href="javascript:resultViewOrder('Result','<%=existing_details[1]%>','<%=existing_details[9]%>','<%=existing_details[11]%>','<%=cont_order_ind%>','<%=patientId%>','<%=existing_details[0]%>')">
					<%=existing_details[6]%> </a>
		<%		}else{
					out.println(existing_details[6]);
				}
			}
			can_reason = "";
			if(!(view_by.trim().equals("L"))){
				if(((existing_details[13].trim()).equals("CN") || (existing_details[13].trim()).equals("DC") || (existing_details[13].trim()).equals("RD") || (existing_details[13].trim()).equals("RJ")) || ((existing_details[11] != null) && (!(existing_details[11]).equals("")))){
				can_reason = (existing_details[11]).replace('\"','\n');
		%>
				<input type="hidden" name="Cancel<%=i%>" id="Cancel<%=i%>" value="<%=can_reason%>">
				<input type=button name="cancel_comment<%=i%>" id="cancel_comment<%=i%>" value="?" class="button" onClick="viewCanOrderFormatLineCmts('Cancel Reason','<%=i%>','<%=existing_details[13]%>','<%=existing_details[9]%>','<%=view_by%>')">

		<%		} else if ((existing_details[13].trim()).equals("CN") || (existing_details[13].trim()).equals("DC") || (existing_details[13].trim()).equals("RD") || (existing_details[13].trim()).equals("RJ")) {
					//can_reason = (existing_details[9]).replace('\"','\n');
		%>
					<input type="hidden" name="Cancel<%=i%>" id="Cancel<%=i%>" value="<%=bean.getHeaderLineCancelReason(existing_details[9])%>">
				<input type=button name="cancel_comment<%=i%>" id="cancel_comment<%=i%>" value="?" class="button" onClick="viewCanOrderFormatLineCmts('Cancel Reason','<%=i%>','<%=existing_details[13]%>','<%=existing_details[9]%>','<%=view_by%>')">
				<%}
			} else {
			                          if (((existing_details[14].trim()).equals("CN") || (existing_details[14].trim().equals("DC")) || (existing_details[14].trim().equals("RD")) || (existing_details[14].trim().equals("RJ"))) || ((existing_details[24] != null) && (!(existing_details[24]).equals("")))) {
                   	can_reason = (existing_details[24]).replace('\"','\n');
		%>
		          <Input type='hidden' name='Cancel<%=i%>' id='Cancel<%=i%>' value="<%=can_reason%>">

		          <Input type="button" name="cancel_comment<%=i%>" id="cancel_comment<%=i%>" value="?" class="button" onClick="viewCanOrderFormatLineCmts('Cancel Reason','<%=i%>','<%=existing_details[11]%>','<%=existing_details[9]%>')">
		<%}
        }%>
		</td>
	</tr>
	<input type=hidden name='priority<%=i%>' id='priority<%=i%>' value='<%=existing_details[10]%>'>
    <%--<script>alert('<%=existing_details[14]%>')</script>--%>
	<input type=hidden name='ord_status<%=i%>' id='ord_status<%=i%>' value='<%=(!(view_by.trim().equals("L")))?existing_details[13]:existing_details[14]%>'>


<%	src_type = existing_details[16];
	order_grouping_category = existing_details[0];
	}
%>
<tr style='visibility:hidden'>
<%if (view_by.equals("L"))
{%>
		
		<td class='columnheader' width='' nowrap><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width='' nowrap><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></td>
<%} else {%>
		
        <td class='columnheader' width='' nowrap><fmt:message key="eOR.OrderedAt.label" bundle="${or_labels}"/></td>
 <%}%>
		<td class='columnheader' width='' nowrap><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
<%if (view_by.equals("L")) 
{%>
		<td class='columnheader' width='' nowrap><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width='' nowrap><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
<%} else {%>
		<td class='columnheader' width='' nowrap><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width='' nowrap><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
<%}%>
  <td class='columnheader' width='' nowrap><fmt:message key="Common.OrderedBy.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width='' nowrap><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>

</tr>
</table>
<input type='hidden' name='source_type' id='source_type' value="<%=src_type%>">
<input type=hidden name='total_recs' id='total_recs' value='<%=allValues.size()%>'>
<input type=hidden name='patient_id' id='patient_id' value='<%=patientId%>'>
<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="function_id" id="function_id" value="<%//=bean.getFunctionId()%>">


<input type=hidden name='encounter_id' id='encounter_id' value='<%=encounter_id%>'>
<input type=hidden name='pract_reln_id' id='pract_reln_id' value='<%=pract_reln_id%>'>
<input type=hidden name='location_type' id='location_type' value='<%=location_type%>'>
<input type=hidden name='location_code' id='location_code' value='<%=location_code%>'>
<input type=hidden name='patient_class' id='patient_class' value='<%=patient_class%>'>
<input type=hidden name='p_called_from_ca' id='p_called_from_ca' value='<%=p_called_from_ca%>'>
<input type=hidden name='sex' id='sex' value='<%=sex%>'>
<input type=hidden name='age' id='age' value='<%=age%>'>
<input type=hidden name='dob' id='dob' value='<%=dob%>'>
<input type=hidden name='visit_adm_date' id='visit_adm_date' value='<%=visit_adm_date%>'>
<input type='hidden' name='queryString' id='queryString' value='<%=request.getQueryString()%>'>
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">

<script>
			if(parent.parent.ExistingOrderHeader.document.getElementById("tableheader")==null)
			{
				setTimeout("alignHeading('<%=order_set_bill_yn%>');",300);
			}
			else 
				alignHeading('<%=order_set_bill_yn%>');
	</script>
</form>

		<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:12%; visibility:hidden;' bgcolor='blue'>
			<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%' align='center'>
				<tr>
					<td width='100%' id='t'></td>
					</td>
				</tr>
			</table>
		</div>
<%
	//putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

