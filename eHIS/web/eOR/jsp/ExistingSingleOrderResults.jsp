<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
20/07/2012    IN033471      NijithaS    System does not filter the Order Categories in One Day and Continue Order.      
17/10/2012	  IN035773      NijithaS	Search order that sort by order category, system display correctly in first page but when click â??nextâ?? to view next page system display all category - not correct. 
19/10/2012    IN033061      Chowminya G  System doesnt display menu cancel/discontinue if the orders are IV Fluid ,IV Fluid+Drug, IV Fluid+Drug(Frequency).
22/11/2012    IN033160      Chowminya G  Thai screen displayed English date  
01/08/2018		IN64543			Dinesh T		01/08/2018	Ramesh G		ML-MMOH-CRF-0776
19/03/2019	  IN069932		Raja S		19/03/2019	Ramesh G		SKR-SCF-1166	
14/10/2019    IN071315	    Nijitha S   14/10/2019  Ramesh G		GHL-CRF-0607	
28/02/2022    IN27707       Suji Keerthi.G   28/02/2022    Ramesh G    SKR-CRF-0052  
28/06/2022	  32825			Ramesh G 			SKR-SCF-1681 	 
-----------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
 	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/ExistingSingleOrder.js"></script>
 	<script language="JavaScript" src="../js/ViewSingleOrder.js"></script> 
 	<script language="JavaScript" src="../js/ResultOrder.js"></script> 
 	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<style>
		.gridData1
		{
			background-color:#FFFFCC;
			height:18px;
			font-family: Verdana, Arial, Helvetica, sans-serif;
			font-size: 8pt;
			color: #0000FF;
			font-weight:normal;
			text-align:left;
			padding-left:10px;
			padding-right:10px;
			vertical-align:middle;
			
			border-top:0px;
			border-left:0px;
			border-right:0px;
			
			border-color:#EEEEEE;
		}
		.gridData2
		{
			background-color:PINK;
			height:18px;
			font-family: Verdana, Arial, Helvetica, sans-serif;
			font-size: 8pt;
			color: #0000FF;
			font-weight:normal;
			text-align:left;
			padding-left:10px;
			padding-right:10px;
			vertical-align:middle;
			
			border-top:0px;
			border-left:0px;
			border-right:0px;
			
			border-color:#EEEEEE;
		}
		.gridData3
		{
			height:18px;
			font-family: Verdana, Arial, Helvetica, sans-serif;
			font-size: 8pt;
			color: #000000;
			font-weight:normal;
			
			border-top:0px;
			border-left:0px;
			border-right:0px;
			
			border-color:#EEEEEE;
			text-align:left;
			padding-left:10px;
			padding-right:10px;
			vertical-align:middle;
		}
		
	</style>
	<script>
	
	function hideToolTip(obj,imgObj,row,originaltdcolor)	
	{
		dynamicMenuHide(obj, window.event,row,originaltdcolor);
	}

	function callMouseOver(obj)	
	{
		currClass = obj.className ;
		obj.className = 'selectedcontextMenuItem';
	}

	function callOnMouseOut(obj)
	{
		obj.className = 'contextMenuItem';
	}

/*function resizeWindow(orderctlHDR, event) {
  var tooltip = document.getElementById("tooltiplayer");
  var orderctlRect = orderctlHDR.getBoundingClientRect(); // Get position of the clicked element
  var tooltipWidth = tooltip.offsetWidth;
  var tooltipHeight = tooltip.offsetHeight;

  var viewportWidth = document.documentElement.clientWidth; // Viewport width
  var viewportHeight = document.documentElement.clientHeight; // Viewport height

  // Calculate the default position (to the right of the clicked element)
  var x = orderctlRect.right + 10; // Add 10px padding between the tooltip and the element
  var y = orderctlRect.top + window.scrollY; // Align vertically with the clicked element

  // Adjust position if the tooltip exceeds the viewport boundaries
  if (x + tooltipWidth > viewportWidth) {
    // If tooltip exceeds the right boundary, place it on the left
    x = orderctlRect.left - tooltipWidth - 10; // Add 10px padding
  }

  if (y + tooltipHeight > viewportHeight) {
    // If tooltip exceeds the bottom boundary, adjust upward
    y = viewportHeight - tooltipHeight - 20; // Keep 20px margin from the bottom
  }

  // Apply the calculated position
  tooltip.style.left = x + "px";
  tooltip.style.top = y + "px";

  // Make the tooltip visible
  tooltip.style.visibility = "visible";
}
*/
function resizeWindow(orderctlHDR, event) {
  var tooltip = document.getElementById("tooltiplayer");
  var orderctlRect = orderctlHDR.getBoundingClientRect(); // Get position of the clicked element
  var tooltipWidth = tooltip.offsetWidth;
  var tooltipHeight = tooltip.offsetHeight;

  var viewportWidth = document.documentElement.clientWidth; // Viewport width
  var viewportHeight = document.documentElement.clientHeight; // Viewport height

  // Calculate the default position (to the right of the clicked element)
  var x = orderctlRect.right + 10 + window.scrollX; // Adjust for horizontal scroll
  var y = orderctlRect.top + window.scrollY; // Adjust for vertical scroll

  // Adjust position if the tooltip exceeds the viewport boundaries
  if (x + tooltipWidth > viewportWidth + window.scrollX) {
    // If tooltip exceeds the right boundary, place it on the left
    x = orderctlRect.left - tooltipWidth - 10 + window.scrollX; // Adjust for horizontal scroll
  }

  if (y + tooltipHeight > viewportHeight + window.scrollY) {
    // If tooltip exceeds the bottom boundary, adjust upward
    y = viewportHeight + window.scrollY - tooltipHeight - 20; // Keep 20px margin from the bottom
  }

  // Apply the calculated position
  tooltip.style.left = x + "px";
  tooltip.style.top = y + "px";

  // Make the tooltip visible
  tooltip.style.visibility = "visible";
}



	
	//function displayToolTip1(val,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,cont_order_ind,order_status,sex,age,dob,visit_adm_date,iv_prep_yn,ord_typ_code,episode_id,episode_visit_num,orderctlHDR,imgObj)//IN64543
	function displayToolTip1(val,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,cont_order_ind,order_status,sex,age,dob,visit_adm_date,iv_prep_yn,ord_typ_code,episode_id,episode_visit_num,orderctlHDR,imgObj,line)//IN64543
	{
				callOnClickMouseOverOnTD(orderctlHDR,imgObj);

		//buildTable1 (val,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,cont_order_ind,order_status,sex,age,dob,visit_adm_date,iv_prep_yn,ord_typ_code,episode_id,episode_visit_num);//IN64543
		buildTable1 (val,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,cont_order_ind,order_status,sex,age,dob,visit_adm_date,iv_prep_yn,ord_typ_code,episode_id,episode_visit_num,line);//IN64543
		resizeWindow(orderctlHDR);
	}
	

	//function buildTable1(val,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,cont_order_ind,order_status,sex,age,dob,visit_adm_date,iv_prep_yn,ord_typ_code,episode_id,episode_visit_num)//IN64543
	function buildTable1(val,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,cont_order_ind,order_status,sex,age,dob,visit_adm_date,iv_prep_yn,ord_typ_code,episode_id,episode_visit_num,line)//IN64543
	{		
		var rowval   = val.split (",");
		var row      = ("View,Cancel,Amend,Preps,Comments,Instructions,,Discontinue,Hold,Resume,LinkToCurrentEncounter,Replace,ViewReplacedOrder,ViewOriginalOrder,Renew");
			
		rowval1      = row.split(",");
		var tab_dat  = "<table id='tooltiptable1' class='contextMenu' width='100%' height='100%' align='center'>"
		
		for( var i=0; i<rowval.length; i++ ) 
		{
			var colval  = rowval[i];
			var colval1 = rowval1[i];
			if (colval != "" )
			{
				tab_dat     += "<tr>";
			
				if (colval1 == "Renew" || colval1 == "Amend") 
				{				
					queryString = document.existing_order_dtl.queryString.value;
					if (colval1 == "Renew" && (ord_cat != 'PH')) 
					{
						tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class= 'contextMenuLink' href=\"javascript:callRenewFunctions1('"+colval1+"','"+escape(val1)+"','"+ord_cat+"','"+orderId+"','"+cancel_type+"','"+order_line_num+"','"+catalog_code+"','"+item_narration+"','"+patient_id+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+order_status+"','"+sex+"','"+age+"','"+dob+"','"+escape(visit_adm_date)+"','"+iv_prep_yn+"','"+escape(queryString)+"')\">"+colval+" </a></td>";
					} 
					else 
					{
						   tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class= 'contextMenuLink' href=\"javascript:callAmmendFunctions1('"+colval1+"','"+escape(val1)+"','"+ord_cat+"','"+orderId+"','"+cancel_type+"','"+order_line_num+"','"+catalog_code+"','"+item_narration+"','"+patient_id+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+order_status+"','"+sex+"','"+age+"','"+dob+"','"+escape(visit_adm_date)+"','"+iv_prep_yn+"')\">"+colval+"</a></td>";
					}
				}
				else 
				{
					//var order_status="";//Commented for IN069932 
					//tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class= 'contextMenuLink' href=javascript:callMenuFunctions1('"+colval1+"','"+escape(val1)+"','"+ord_cat+"','"+orderId+"','"+cancel_type+"','"+order_line_num+"','"+catalog_code+"','"+item_narration+"','"+patient_id+"','"+cont_order_ind+"','"+order_status+"','"+sex+"','"+ord_typ_code+"','"+encntr_id+"','"+patient_class+"','"+location_code+"','"+location_type+"','"+episode_id+"','"+episode_visit_num+"','"+iv_prep_yn+"')>"+colval+" </a></td>";//Included iv_prep_yn --[IN033061]//IN64543
					//tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class= 'contextMenuLink' href=javascript:callMenuFunctions1('"+colval1+"','"+escape(val1)+"','"+ord_cat+"','"+orderId+"','"+cancel_type+"','"+order_line_num+"','"+catalog_code+"','"+item_narration+"','"+patient_id+"','"+cont_order_ind+"','"+order_status+"','"+sex+"','"+ord_typ_code+"','"+encntr_id+"','"+patient_class+"','"+location_code+"','"+location_type+"','"+episode_id+"','"+episode_visit_num+"','"+iv_prep_yn+"','"+line+"')>"+colval+" </a></td>";//Included iv_prep_yn --[IN033061]//IN64543
					tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class= 'contextMenuLink' href=javascript:callMenuFunctions1('"+colval1+"','"+escape(val1)+"','"+ord_cat+"','"+orderId+"','"+cancel_type+"','"+order_line_num+"','"+catalog_code+"','"+item_narration+"','"+patient_id+"','"+cont_order_ind+"','"+order_status+"','"+sex+"','"+ord_typ_code+"','"+encntr_id+"','"+patient_class+"','"+location_code+"','"+location_type+"','"+episode_id+"','"+episode_visit_num+"','"+iv_prep_yn+"','"+line+"','"+p_called_from_ca+"')>"+colval+" </a></td>";//Included iv_prep_yn --[IN033061]//IN64543//Added for IN071315
				}
				tab_dat     += "</tr> "
			}
		}
		tab_dat     += "</table> "
		
		document.getElementById('tooltd').innerHTML = tab_dat;
	}
	async function viewCanOrderFormatLineCmts(line,order_line_num,orderId,view_by)
	{
		var dialogHeight ='14' ;
		var dialogWidth = '29' ;
		var dialogTop	= '189';
		var dialogLeft = '167' ;
		var title = '';
		var cancel_date_time = "";
		var cancel_pract_id  = "";

		var can_reason = eval("document.existing_order_dtl.Can_Reason"+line+".value");
			
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';
 		if(can_reason=="Comments")
			var narration = eval("document.existing_order_dtl.Cmts"+line+".value");
		else
		{
 			var narration = eval("document.existing_order_dtl.Cancel"+line+".value");
			cancel_date_time =  eval("document.existing_order_dtl.Cancel_date_time"+line+".value"); 
			cancel_pract_id =  eval("document.existing_order_dtl.Cancel_pract_id"+line+".value"); 
		}	
 		var arguments = "";
			
		var finalString	= "can_reason="+encodeURIComponent(can_reason)+"&cancel_date_time="+cancel_date_time+"&cancel_pract_id="+cancel_pract_id+"&order_line_num="+order_line_num+"&orderId="+orderId+"&view_by="+view_by;
		var retVals = await window.showModalDialog("../../eOR/jsp/ViewLineComment.jsp?"+finalString,arguments,features);

	}
	function showSlidingDetails(order_id, order_line_num, sliding_scale_yn)
	{
        var dialogHeight= "13" ;
        var dialogWidth = "35" ;
        var dialogTop = "400" ;
        var center = "1" ;
        var status="no";
        var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" +    dialogTop;
        var arguments = "" ;
        var retVal =       window.showModalDialog("../../ePH/jsp/QueryPatientDrugProfileRemarks.jsp?order_id="+order_id+"&order_line_num="+order_line_num+"&sliding_scale_yn="+sliding_scale_yn+"&called_frm=SlidingScale",arguments,features);
	}
	
	function callMouseOut(obj,originaltdcolor)
	{
		obj.style.backgroundColor = originaltdcolor;
		obj.className = 'gridDataBlue';
	}
</script>
 	
</head>
<body  onscroll='continuousprocessScroll()' onload='FocusFirstElement()'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String login_user	= (String)session.getValue("login_user");
	String mode	   = "1";
	String patient_id	= request.getParameter("patientId");
	String encounter_id	= request.getParameter("encntr_id");
	String bean_id 		= "@existingorderbean"+patient_id+encounter_id;
 	String bean_name = "eOR.ExistingOrder";
	ExistingOrder bean = (ExistingOrder)getBeanObject( bean_id, bean_name, request ) ;
    bean.setLanguageId(localeName);
	bean.setSiteSpecific("DEFAULT_ORDER_STATUS"); //IN27707
	String facility_id = (String)session.getValue("facility_id");
	String resp_id = (String)session.getValue("responsibility_id");
	String pract_reln_id = request.getParameter("pract_reln_id")==null?"":request.getParameter("pract_reln_id");
	String practitioner_type  	= (String) session.getValue("practitioner_type");
	if(practitioner_type== null)practitioner_type = "";
	if(resp_id== null)resp_id = "";
	String order_set_expln_txt="View Order Set Detail";
	String rd_install	= "N";
	String ot_install	= "N";
 	String old_order_date = "";
	
	String episode_id ="";
	String episode_visit_num ="";
	ArrayList allValues = new ArrayList();
	
	
	Properties properties	= (Properties) session.getValue( "jdbc" );
	String patientId		= request.getParameter( "patientId" ) ;
	String encntr_id		= request.getParameter( "encntr_id" ) ;
	String order_status		= request.getParameter( "ord_status" ) ;
	String order_by			= request.getParameter( "order_by" ) ;
	String catalog			= request.getParameter( "catalog" ) ;
	String view				= request.getParameter( "view" ) ;
	String priority			=  request.getParameter( "priority" );
	String date_from		= request.getParameter( "date_from" ) ;
	String date_to			= request.getParameter( "date_to" ) ;
	String order_category	= request.getParameter( "order_categ" ) ;
	
	String order_type		= request.getParameter( "order_type" ) ;
	String view_by			= request.getParameter( "view_by" ) ;
	String search_criteria	= request.getParameter( "search_criteria" ) ;
	String cosign			= request.getParameter("cosign") ;
	String activity_type			= request.getParameter("activity_type") ;
	String elapsed_orders			= request.getParameter("elapsed_orders") ;
	String sys_cancelled_orders			= request.getParameter("sys_cancelled_orders") ;
	String group_by			= request.getParameter( "group_by" ) ;//Menaka
	String order_frequency			= request.getParameter( "order_frequency" ) ;//Menaka
	//IN27707 Starts
	String called_frm1			= request.getParameter( "called_from" ) ;
	if(called_frm1== null)called_frm1 = "";
	String call_from			= request.getParameter( "call_from" )==null?"":request.getParameter( "call_from" );
	if(call_from.equals("undefined")) call_from = "";
	//IN27707 Ends
	String category_type	= "";
	category_type 	= request.getParameter( "category_type" ) ;
	if(category_type != null )category_type = category_type.trim();	else category_type = "I";
	
	String from	 = bean.checkForNull(request.getParameter( "from" ),"1") ;
	String to	 = bean.checkForNull(request.getParameter( "to" ),"30") ;
		
	
 	int start	 = Integer.parseInt(from);
	int end		= Integer.parseInt(to);
		
	String curr_sys_date    = "";
	String location_type			= bean.checkForNull(request.getParameter("location_type"),"");
	String location_code			= bean.checkForNull(request.getParameter("location_code"),"");
	String patient_class			= bean.checkForNull(request.getParameter("patient_class"),"");
	String p_called_from_ca			= bean.checkForNull(request.getParameter("p_called_from_ca"),"");
	String sex						= bean.checkForNull(request.getParameter("sex"),"");
	String age						= bean.checkForNull(request.getParameter("age"),"");
	String dob						= bean.checkForNull(request.getParameter("dob"),"");
 	String visit_adm_date			= bean.checkForNull(request.getParameter("visit_adm_date"),"");
 	String called_from			= bean.checkForNull(request.getParameter("called_from"),"");
	String str_value				= "";
	String total_query_records		= "0";
	
	if(called_from.equalsIgnoreCase("CategoryList")){
		//order_category	= request.getParameter( "order_category" ) ; 
		order_category	= request.getParameter( "ordercate_for_filter" ) ; //IN033471
	}
	else 
		order_category = "";
		
			
	if(patientId != null )patientId = patientId.trim();			else patientId = "";
	if(encntr_id != null )encntr_id = encntr_id.trim();			else encntr_id = "";

	if(view != null )view = view.trim();						else view = "";
	if(order_status != null )order_status = order_status.trim();else order_status = "";
	if(priority != null )priority = priority.trim();			else priority = "";
	if(date_from != null )date_from = date_from.trim();			else date_from = "";
	if(date_to != null )date_to = date_to.trim();				else date_to = "";
	if(order_category != null )order_category = order_category.trim();	else order_category = "";
	
	if(order_type != null )order_type = order_type.trim();		else order_type = "";
	if(activity_type != null )activity_type = activity_type.trim();		else activity_type = "";
	
	if(cosign != null )cosign = cosign.trim();					else cosign = "";
	if(catalog != null )catalog = catalog.trim();				else catalog = "";
	if(search_criteria != null )search_criteria = search_criteria.trim();	else search_criteria = "";
	if(order_by != null )order_by = order_by.trim();			else order_by = "";
	if(view_by != null )view_by = view_by.trim();				else view_by = "";
	if(group_by != null )group_by = group_by.trim();			else group_by = "";//Menaka
	if(order_frequency != null )order_frequency = order_frequency.trim();				else order_frequency = "";//Menaka
	if(elapsed_orders != null )elapsed_orders = elapsed_orders.trim();				else elapsed_orders = "";
	if(sys_cancelled_orders != null )sys_cancelled_orders = sys_cancelled_orders.trim();				else sys_cancelled_orders = "";
	
	// Get the date Sysdate  (IF Appointment is there, and start_date_time is less than sysdate, then have to pass the sysdate
	ArrayList sysdate = (ArrayList)bean.getSysDateTime(properties);
	for(int i=0;i<sysdate.size();i++)
	{
		curr_sys_date	= (String)sysdate.get(0);
 	}
	allValues		= bean.getSingleContinuousOrderDetails(view,patientId,encntr_id,order_status,order_by,catalog,date_from,date_to,order_category,order_type,search_criteria,priority,view_by, activity_type, practitioner_type,elapsed_orders,sys_cancelled_orders,start,end,(String)session.getAttribute("responsibility_id"),(String)session.getAttribute("ca_practitioner_id"),pract_reln_id,category_type,login_user,facility_id,call_from,called_frm1); //IN27707
		
	%>
<form name="existing_order_dtl" id="existing_order_dtl" action="../../eOR/jsp/ExistingSingleOrderResults.jsp" method="post" >
<div id="divHeadSep" >
<table cellpadding='3' cellspacing='0'  cellpadding="3"  style="width: 100%; table-layout: fixed;">
	<tr id='heading2'>
		<TD width='50%' colspan='5' align='center' class='CASECONDSELECTHORZ' style='font-size:13pt'><b><fmt:message key="eOR.SingleOrder.label" bundle="${or_labels}"/></b></td>
		<td width='1%' bgcolor='#000000'>&nbsp;</td>
		<TD width='50%' colspan='5' align='center' class='CASECONDSELECTHORZ' style='font-size:13pt'><b><fmt:message key="eOR.ContinuousOrder.label" bundle="${or_labels}"/></b></td>
	</tr>
	<tr id='heading1'>
		<td class='columnheader' width='' nowrap></td>
		<td class='columnheader' width='' nowrap><fmt:message key="Common.time.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width='' nowrap><fmt:message key="eOR.OrderName.label" bundle="${or_labels}"/></td>
		<td class='columnheader' width='' nowrap><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width='' nowrap></td>
		<td bgcolor='#000000'>&nbsp;</td>
		<td class='columnheader' width='' nowrap></td>
		<td class='columnheader' width='' nowrap><fmt:message key="Common.time.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width='' nowrap><fmt:message key="eOR.OrderName.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width='' nowrap><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width='' nowrap></td>
	</tr>
	<%
	if((allValues.size() == 0))
	{
		%>
		<tr align='left'>
			<td class = 'gridData' colspan="11">
				<%
				try
				{ 							
					String returnText = SpringCacheBean.getMessage(pageContext,"NO_RECORD_FOUND_FOR_CRITERIA","common");
					out.println(returnText);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				%>
			</td>
		</tr>
		<%
	}
	String slClassValue = "";
	slClassValue="gridData3";
	String src_type = request.getParameter("source_type");
	if(src_type==null) src_type= "";
	String cont_order_ind = "";
	String[] existing_details = null;
	String can_reason = null;
	String can_date_time = null,can_pract_id = null;
	String disc_pract_id = null, disc_date_time = null;

	String appt_ref_num  = null, appt_date		= null;
	String appt_locn	  = null, appt_resched_yn		= "N";
	String appt_reqd_yn	  = "N";
	String appt_resched_reason  = null, no_of_reschedules = null;
	String last_action_reason_desc  = null;
	String sec_order_yn	= null,	pri_order_id = null;
	String last_action_type = null;
	String accession_num = null;
	String ext_appl_accession_num = null;
	String accession_num_tooltip = null;

	String order_catalog_nature	= null;
	String display_appt_yn		= "N";
	String notify_yn			= "N";
	String [] colorString = {"X","X","X","X"};
	String color_string = "X,X,X,X";
	String appt_disabled = "";
	String allow_cancel_yn = "";

	StringTokenizer menu_options = null;
	int i = 0;
    String billing_package_ref = "";

	StringBuffer strOrderCtl = new StringBuffer();
	String originaltdcolor = "";
	
	for(int k=0; k<allValues.size(); k++)
	{
		if(strOrderCtl.length() > 0)
			strOrderCtl = strOrderCtl.delete(0,strOrderCtl.length());
		existing_details = (String[])allValues.get(k);
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
		if(existing_details[25] == null) existing_details[25] = "";
       	if(existing_details[26] == null) existing_details[26] = "N";
       	if(existing_details[27] == null) existing_details[27] = "";
       	if(existing_details[28] == null) existing_details[28] = "";
       	if(existing_details[29] == null) existing_details[29] = "";
       	if(existing_details[30] == null) existing_details[30] = "";
       	if(existing_details[31] == null) existing_details[31] = "";
		if(existing_details[32] == null) existing_details[32] = "";
		if(existing_details[33] == null) existing_details[33] = "";
		if(existing_details[34] == null) existing_details[34] = "";
		if(existing_details[35] == null) existing_details[35] = "";
		if(existing_details[36] == null) existing_details[36] = "";
		if(existing_details[37] == null) existing_details[37] = "";
		if(existing_details[38] == null) existing_details[38] = "";
		if(existing_details[39] == null) existing_details[39] = "";
		if(existing_details[40] == null) existing_details[40] = "";
		if(existing_details[41] == null) existing_details[41] = "";
		if(existing_details[42] == null) existing_details[42] = "";
		if(existing_details[43] == null) existing_details[43] = "";
		if(existing_details[47] == null) existing_details[47] = "";
		if(existing_details[48] == null) existing_details[48] = "";
		if(existing_details[50] == null) existing_details[50] = "";
		if(existing_details[51] == null) existing_details[51] = "";
		if(existing_details[52] == null) existing_details[52] = "";
		if(existing_details[53] == null) existing_details[53] = "";
		if(existing_details[54] == null) existing_details[54] = "";		

		if(existing_details[26] == null) existing_details[26] = "N";
		if(existing_details[36] == null) existing_details[36] = "X,X,X,X"; // color
		if(existing_details[43] == null) existing_details[43] = "";
		if(existing_details[44] == null) existing_details[44] = "";
		if(existing_details[45] == null) existing_details[45] = "";
		if(existing_details[46] == null) existing_details[46] = "";			
		if(existing_details[49] == null) existing_details[49] = "";
		if(existing_details[50] == null) existing_details[50] = "";
		if(existing_details[51] == null) existing_details[51] = "N";
		if(existing_details[52] == null) existing_details[52] = "";
		if(existing_details[53] == null) existing_details[53] = "";
		if(existing_details[54] == null) existing_details[54] = "";
		if(existing_details[55] == null) existing_details[55] = "N";
		if(existing_details[56] == null) existing_details[56] = "";
		if(existing_details[57] == null) existing_details[57] = "";
		if(existing_details[58] == null) existing_details[58] = "0";
		if(existing_details[59] == null) existing_details[59] = "";
		if(existing_details[60] == null) existing_details[60] = "";
		if(existing_details[61] == null) existing_details[61] = "";
		if(existing_details[62] == null) existing_details[62] = "";
		if(existing_details[63] == null) existing_details[63] = "";
		if(existing_details[64] == null) existing_details[64] = "";
		if(existing_details[65] == null) existing_details[65] = "";
		if(existing_details[66] == null) existing_details[66] = "";
		if(existing_details[67] == null) existing_details[67] = "";
		if(existing_details[68] == null) existing_details[68] = "";
		if(existing_details[69] == null) existing_details[69] = "";
		if(existing_details[70] == null) existing_details[70] = "";
		if(existing_details[71] == null) existing_details[71] = "";
		if(existing_details[72] == null) existing_details[72] = "";
		if(existing_details[73] == null) existing_details[73] = "";	
		if(existing_details[74] == null) existing_details[74] = "";
		if(existing_details[75] == null) existing_details[75] = "";
		if(existing_details[76] == null) existing_details[76] = "";	
		if(existing_details[77] == null) existing_details[77] = "";	
				
		menu_options = new StringTokenizer(existing_details[15],"|");
		if(menu_options.hasMoreTokens())
		{
			existing_details[15] = menu_options.nextToken();  //AMEND_ORDER  
			allow_cancel_yn= menu_options.nextToken();    // CANCEL_ORDER Added by Sridhar for MO-CRF-0033
			existing_details[16] = menu_options.nextToken();  //DISCONTINUE 
			existing_details[22] = menu_options.nextToken();  //HOLD       
			existing_details[23] = menu_options.nextToken();  //RESUME    
			existing_details[26] = menu_options.nextToken();  //RENEW        
			existing_details[17] = menu_options.nextToken();  //RESULT_HYPER_LINK   	
			existing_details[63] = menu_options.nextToken();  //LINK_TO_CURRENT_ENCOUNTER
			existing_details[68] = menu_options.nextToken();  //REPLACE FOR PACKAGE BILLING
			existing_details[65] = menu_options.nextToken();  //VIEW_REPLACED_ORDER
			existing_details[66] = menu_options.nextToken();  //VIEW_ORIGINAL_ORDER				
		}
		cont_order_ind			= existing_details[21];
		color_string			= existing_details[36];
		can_reason				= existing_details[37];
		can_pract_id			= existing_details[38];
		can_date_time			= existing_details[39];
		disc_pract_id			= existing_details[40];
		disc_date_time			= existing_details[41];
		last_action_reason_desc	= existing_details[44];	
		appt_date				= existing_details[45];
		appt_ref_num			= existing_details[46];
		order_catalog_nature	= existing_details[47];
		sec_order_yn			= existing_details[48];
		pri_order_id			= existing_details[49];
		appt_locn				= existing_details[50];
		appt_resched_yn			= existing_details[51];
		appt_resched_reason		= existing_details[52];
 		no_of_reschedules		= existing_details[53];
		appt_reqd_yn			= existing_details[54];
		notify_yn				= existing_details[55];
		display_appt_yn			= existing_details[15];  //cancel_yn
		last_action_type		= existing_details[56];
		accession_num			= existing_details[57];
		ext_appl_accession_num	= existing_details[64];
		billing_package_ref			= existing_details[67];
		
		if(existing_details[64] == null || existing_details.equals("")) existing_details[64] = "";
		if(existing_details[78] != null)
			total_query_records		= existing_details[78];
		
		if(k==0) 
		{ 
			if((Integer.parseInt(total_query_records)>0) || (start>1))
			{
				%>
				<tr align="right" id='heading' bgcolor='WHITE'>
					<td colspan="11" >
						<jsp:include page="ResultScrollingSingleContinuous.jsp" ><jsp:param name="flush" value="true" />
						<jsp:param name ="from" value= "<%=start%>" /> 
						<jsp:param name ="to" value= "<%=end%>" />	
						<jsp:param name ="total_size" value= "<%=total_query_records%>" />   
						<jsp:param name ="check_box_name" value= "chk" />					 
						<jsp:param name ="form_name" value= "existing_order_dtl" /> 								 
						<jsp:param name ="order_category" value= "<%=order_category%>" /> 
						<jsp:param name ="called_from" value= "<%=called_from%>" />	 
						</jsp:include>
					</td>
				</tr>
				<%
			}
			else
			{
				%>
				<tr align="right" id="heading" bgcolor='white'>
					<td colspan="11">
						&nbsp;
					</td>
				</tr>
				<%			
			}
		}  
		existing_details[69] = com.ehis.util.DateUtils.convertDate(existing_details[69],"DMY","en",localeName); //--[IN033160]
		if(!existing_details[69].equals(old_order_date)) 
		{
			%>
			<TR height="25px;">
				<TD colspan='5' class='columnheader'><%=existing_details[69]%></TD>
				<TD bgcolor='#000000'>&nbsp;</TD>
				<TD colspan='5' class='columnheader'><%=existing_details[69]%></TD>
			</TR>
			<%
		}
		%>
		<tr>
			<%
			if(existing_details[76].equals("S"))
			{
				%>
			
				<td class='gridData3' <%if(existing_details[72].equals("CURR_MED_YELLOW")){ out.println("bgcolor='#FFFFCC'");}else if(existing_details[72].equals("CURR_MED_PINK")){ out.println("bgcolor='PINK'");} %>>&nbsp;</td>
				<td class='gridData3' <%if(existing_details[72].equals("CURR_MED_YELLOW")){ out.println("bgcolor='#FFFFCC'");}else if(existing_details[72].equals("CURR_MED_PINK")){ out.println("bgcolor='PINK'");} %>><%=existing_details[70]%></td>
				<input type='hidden' name='line_num<%=i%>' id='line_num<%=i%>' value="<%=existing_details[11]%>">
				<input type='hidden' name='start_date_time<%=i%>' id='start_date_time<%=i%>' value="<%=existing_details[27]%>">
				<input type='hidden' name='catalog_code<%=i%>' id='catalog_code<%=i%>' value="<%=existing_details[12]%>">
				<input type='hidden' name='item_narration<%=i%>' id='item_narration<%=i%>' value="<%=existing_details[13]%>">
				<input type='hidden' name='location_code<%=i%>' id='location_code<%=i%>' value="<%=existing_details[19]%>">
				<input type='hidden' name='patient_class<%=i%>' id='patient_class<%=i%>' value="<%=existing_details[20]%>">
				<input type='hidden' name='cont_order_ind<%=i%>' id='cont_order_ind<%=i%>' value="<%=cont_order_ind%>">
				<input type='hidden' name='copy_yn<%=i%>' id='copy_yn<%=i%>' value="<%=existing_details[30]%>">
				<input type='hidden' name='source_type<%=i%>' id='source_type<%=i%>' value="<%=existing_details[18]%>">
				<input type='hidden' name='order_category<%=i%>' id='order_category<%=i%>' value="<%=existing_details[0]%>">
				<input type='hidden' name='ord_typ_code<%=i%>' id='ord_typ_code<%=i%>' value="<%=existing_details[4]%>">
				<input type='hidden' name='ord_typ_desc<%=i%>' id='ord_typ_desc<%=i%>' value="<%=existing_details[8]%>">
				<input type='hidden' name='ord_id<%=i%>' id='ord_id<%=i%>' value="<%=existing_details[9]%>">
				<%
				if(ext_appl_accession_num != null && !ext_appl_accession_num.equals(""))
					accession_num_tooltip = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ExternalApplicationAccessionNo.label","or_labels")+" "+ext_appl_accession_num;
				else
					accession_num_tooltip = "";	
			
				if(existing_details[72].equals("CURR_MED_YELLOW"))
				{
					strOrderCtl.append("<td width='' id='orderctl"+i+"' bgcolor='#FFFFCC' style='cursor:pointer' title='"+accession_num_tooltip+"' class='gridData1' ");
				}
				else if(existing_details[72].equals("CURR_MED_PINK"))
				{
					strOrderCtl.append("<td width=''  id='orderctl"+i+"' bgcolor='PINK' style='cursor:pointer' title='"+accession_num_tooltip+"' class='gridData2' ");
				}
				else
				{
					strOrderCtl.append("<td width='' id='orderctl"+i+"' style='cursor:pointer' title='"+accession_num_tooltip+"' class='gridDataBlue'");
				}
				if(existing_details[9]!=null && (existing_details[9].trim().substring(0,2)).equals("CS")) 
				{ // only care set (order set) orders
				
					if(existing_details[72].equals("CURR_MED_PINK"))
					{
						originaltdcolor = "PINK";
					}
					else if(existing_details[72].equals("CURR_MED_YELLOW"))
					{
						originaltdcolor = "#FFFFCC";
					}
					else
					{
						originaltdcolor = "#FFFFFF";
					}
					strOrderCtl.append("onClick=\"showCareSetResults('"+existing_details[9]+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"','"+originaltdcolor+"')\" onMouseOut=\"callMouseOut(this,,'"+originaltdcolor+"')\">");
				}
				else 
				{ // For other categories normal one
					if(((existing_details[0].equalsIgnoreCase("PH"))&&((existing_details[4].equalsIgnoreCase("MS"))||(existing_details[25].equalsIgnoreCase("6"))))||(!(existing_details[67].equalsIgnoreCase(""))))
					{
					
						if(existing_details[72].equals("CURR_MED_PINK"))
						{
							originaltdcolor = "PINK";
						}
						else if(existing_details[72].equals("CURR_MED_YELLOW"))
						{
							originaltdcolor = "#FFFFCC";
						}
						else
						{
							originaltdcolor = "#FFFFFF";
						}
						//strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',"+((allow_cancel_yn.trim().equals("Y"))?"'+getLabel('Common.cancel.label','Common')+'":"")+",,'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,,,,"+((existing_details[63].trim().equals("Y"))?"'+getLabel('eOR.Linktocurrentencounter.label','OR')+'":"")+","+((existing_details[68].trim().equals("Y"))?"'+getLabel('eOR.Replace.label','OR')+'":"")+","+((existing_details[65].trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((existing_details[66].trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+","+((existing_details[23].trim().equals("Y"))? "'+getLabel('eOR.Renew.label','OR')+'" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"','"+existing_details[4]+"','"+episode_id+"','"+episode_visit_num+"',this,'imgArrow"+i+"')\" onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"','"+originaltdcolor+"')\" onMouseOut=\"callMouseOut(this,'"+originaltdcolor+"')\">");//IN64543
						strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',"+((allow_cancel_yn.trim().equals("Y"))?"'+getLabel('Common.cancel.label','Common')+'":"")+",,'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,,,,"+((existing_details[63].trim().equals("Y"))?"'+getLabel('eOR.Linktocurrentencounter.label','OR')+'":"")+","+((existing_details[68].trim().equals("Y"))?"'+getLabel('eOR.Replace.label','OR')+'":"")+","+((existing_details[65].trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((existing_details[66].trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+","+((existing_details[23].trim().equals("Y"))? "'+getLabel('eOR.Renew.label','OR')+'" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"','"+existing_details[4]+"','"+episode_id+"','"+episode_visit_num+"',this,'imgArrow"+i+"','"+i+"')\" onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"','"+originaltdcolor+"')\" onMouseOut=\"callMouseOut(this,'"+originaltdcolor+"')\">");//IN64543
					}
					else
					{

						if(existing_details[72].equals("CURR_MED_PINK"))
						{
							originaltdcolor = "PINK";
						}
						else if(existing_details[72].equals("CURR_MED_YELLOW"))
						{
							originaltdcolor = "#FFFFCC";
						}
						else
						{
							originaltdcolor = "#FFFFFF";
						}
						//strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',"+((allow_cancel_yn.trim().equals("Y"))?"'+getLabel('Common.cancel.label','Common')+'":"")+","+((existing_details[15].trim().equals("Y"))?"'+getLabel('Common.Amend.label','Common')+'":"")+",'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,"+((existing_details[16].trim().equals("Y"))?"'+getLabel('Common.Discontinue.label','Common')+'":"")+","+((existing_details[22].trim().equals("Y"))?"'+getLabel('Common.Hold.label','Common')+'":"")+","+((existing_details[23].trim().equals("Y"))?"'+getLabel('eOR.Resume.label','OR')+'":"")+","+((existing_details[63].trim().equals("Y"))?"'+getLabel('eOR.Linktocurrentencounter.label','OR')+'":"")+","+((existing_details[68].trim().equals("Y"))?"'+getLabel('eOR.Replace.label','OR')+'":"")+","+((existing_details[65].trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((existing_details[66].trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+","+((existing_details[23].trim().equals("Y"))? "'+getLabel('eOR.Renew.label','OR')+'" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"','"+existing_details[4]+"','"+episode_id+"','"+episode_visit_num+"',this,'imgArrow"+i+"')\" onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"','"+originaltdcolor+"')\"  onMouseOut=\"callMouseOut(this,'"+originaltdcolor+"')\">");//IN64543
						strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',"+((allow_cancel_yn.trim().equals("Y"))?"'+getLabel('Common.cancel.label','Common')+'":"")+","+((existing_details[15].trim().equals("Y"))?"'+getLabel('Common.Amend.label','Common')+'":"")+",'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,"+((existing_details[16].trim().equals("Y"))?"'+getLabel('Common.Discontinue.label','Common')+'":"")+","+((existing_details[22].trim().equals("Y"))?"'+getLabel('Common.Hold.label','Common')+'":"")+","+((existing_details[23].trim().equals("Y"))?"'+getLabel('eOR.Resume.label','OR')+'":"")+","+((existing_details[63].trim().equals("Y"))?"'+getLabel('eOR.Linktocurrentencounter.label','OR')+'":"")+","+((existing_details[68].trim().equals("Y"))?"'+getLabel('eOR.Replace.label','OR')+'":"")+","+((existing_details[65].trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((existing_details[66].trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+","+((existing_details[23].trim().equals("Y"))? "'+getLabel('eOR.Renew.label','OR')+'" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"','"+existing_details[4]+"','"+episode_id+"','"+episode_visit_num+"',this,'imgArrow"+i+"','"+i+"')\" onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"','"+originaltdcolor+"')\"  onMouseOut=\"callMouseOut(this,'"+originaltdcolor+"')\">");//IN64543
					}
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
				if(notify_yn!=null && notify_yn.equals("Y")) 
				{
					strOrderCtl.append("<img height='15' width='15' src=\"../images/Alert.gif\">");
				} 

				if(!(existing_details[9]!=null && (existing_details[9].trim().substring(0,2)).equals("CS")))
				{
					strOrderCtl.append("<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+i+"' id='imgArrow"+i+"'></td>");
				}

				out.println(strOrderCtl.toString());
				%>
	
				<td <%if(existing_details[72].equals("CURR_MED_YELLOW")){ out.println("bgcolor='#FFFFCC'");}else if(existing_details[72].equals("CURR_MED_PINK")){ out.println("bgcolor='PINK'");} %> width='' nowrap  style='height:18px;	font-family: Verdana, Arial, Helvetica, sans-serif;	font-size: 8pt;	font-weight:normal;text-align:left;padding-left:10px;padding-right:10px;vertical-align:middle;border-top:0px;border-left:0px;border-right:0px;border-style:solid;' class='<%=((colorString[3].equals("X"))?slClassValue:colorString[3])%>'> 
				<input type="hidden" name="Appt<%=i%>" id="Appt<%=i%>" value="<%=appt_ref_num%>">
				<input type="hidden" name="Appt_date<%=i%>" id="Appt_date<%=i%>" value="<%=appt_date%>">
				<input type="hidden" name="performing_facility_id<%=i%>" id="performing_facility_id<%=i%>" value="<%=existing_details[62]%>">
				<input type="hidden" name="appt_locn<%=i%>" id="appt_locn<%=i%>" value="<%=appt_locn%>">
				<input type="hidden" name="appt_resched_yn<%=i%>" id="appt_resched_yn<%=i%>" value="<%=appt_resched_yn%>">
				<input type="hidden" name="appt_resched_reason<%=i%>" id="appt_resched_reason<%=i%>" value="<%=appt_resched_reason%>">
				<input type="hidden" name="no_of_reschedules<%=i%>" id="no_of_reschedules<%=i%>" value="<%=no_of_reschedules%>">
				<input type="hidden" name="parent_order_id<%=i%>" id="parent_order_id<%=i%>" value="">
				<input type="hidden" name="parent_order_line_num<%=i%>" id="parent_order_line_num<%=i%>" value="">
				<input type="hidden" name="explanatory_text<%=existing_details[9]%><%=existing_details[11]%>" id="explanatory_text<%=existing_details[9]%><%=existing_details[11]%>" value="<%=order_set_expln_txt%>">
				<input type="hidden" name="instrn_type<%=i%>" id="instrn_type<%=i%>" value="<%=existing_details[79]%>"><!--IN64543-->
				<%			
				if(existing_details[17].trim().equals("Y"))
				{
					if(existing_details[9]!=null && (existing_details[9].trim().substring(0,2)).equals("CS")) 
					{ // only care set (order set) orders 
						%>
						<a class='gridLink' href='javascript:showCareSetViewResults("<%=existing_details[9]%>","","<%=cont_order_ind%>","<%=patientId%>","<%=existing_details[3]%>")'>
						<%
					}  
					else 
					{  
						if(last_action_type!=null && last_action_type.equals("NT")) 
						{
							%> <!--call Notes view  -->
							<a class="gridLink" href="javascript:resultViewOrder('Result','<%=existing_details[1]%>','<%=existing_details[9]%>','<%=existing_details[11]%>','<%=cont_order_ind%>','<%=patientId%>','<%=existing_details[0]%>','<%=pract_reln_id%>')">
							<%
						} 
						else 
						{ 
							%> <!-- Result View --> 
							<a class="gridLink" href="javascript:resultViewOrder('Result','<%=existing_details[1]%>','<%=existing_details[9]%>','<%=existing_details[11]%>','<%=cont_order_ind%>','<%=patientId%>','<%=existing_details[0]%>','<%=pract_reln_id%>')">
							<%
						}
					} 
					%>
					<%=existing_details[6]%>
					</a>
					<%
					if(existing_details[60].equalsIgnoreCase("Y"))
					{
						%>
						<input class="button" type="button" name="existing_consent_id_lookup<%=k%>" id="existing_consent_id_lookup<%=k%>"  title='Consent Required' value="C" onClick="callMultipleConsent('<%=existing_details[4]%>','<%=existing_details[12]%>','<%=existing_details[59]%>','<%=existing_details[9]%>','<%=existing_details[11]%>','<%=existing_details[0]%>','<%=k%>')">   
						<%
					}
				}
				else
				{  
					if((!appt_ref_num.equals("")) && (!appt_date.equals("")) && (existing_details[14].equals("AB")) ) 
					{
						if( (existing_details[0].equals("RD") && rd_install.equals("Y")) || (existing_details[0].equals("OT") && ot_install.equals("Y")) ) 
						{ 
							%>
							<a class="gridLink" href="javascript:viewApptData(escape('<%=i%>'))"> 
							<%		
						}
						else 
						{
							%>
							<a class="gridLink" href="javascript:viewOAApptData(escape('<%=i%>'))"> 
							<%
							if(appt_reqd_yn!=null && appt_reqd_yn.equals("Y") && !appt_ref_num.equals("") && !existing_details[0].equals("OT")  && display_appt_yn.equals("Y")) 
							{ 
								if(!existing_details[62].equals(facility_id))
								{
									String bookappt = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.RescheduleFromPerformingFacility.label","or_labels");
									appt_disabled = "disabled title='"+bookappt+"'";
								}
								else
								{
									appt_disabled = "";
								}
								%>
								<input class="BUTTON" <%=appt_disabled%> type="button" name="ReSchedule<%=i%>" value="R" onClick="viewReSchedule(escape('<%=i%>'))"> 
								<%
							} 
						} 
					} 
					if(appt_reqd_yn!=null && appt_reqd_yn.equals("Y") && appt_ref_num.equals("")  && display_appt_yn.equals("Y")) //&& existing_details[10].equals("R")) Modified by Uma on 8/26/2009 for IN013477
					{ 
						if(!(existing_details[0].equals("RD") && rd_install.equals("Y")) && !(existing_details[0].equals("OT") && ot_install.equals("Y") )&& existing_details[14].equals("OS"))
						{
							if(!existing_details[62].equals(facility_id))
							{
								String bookappt = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.AppointmentFromPerformingFacility.label","or_labels");
								appt_disabled = "disabled title='"+bookappt+"'";
							}
							else
							{
								appt_disabled = "";
							}
							%>
							<input class="BUTTON" <%=appt_disabled%> type="button" name="Schedule<%=i%>" value="S" onClick="BookAppointment(escape('<%=i%>'))">
							<%		
						}
					}	
					out.println(existing_details[6]);
					out.println("</a>");
					if(existing_details[60].equalsIgnoreCase("Y"))
					{
						%>
						<input class="button" type="button" name="existing_consent_id_lookup<%=k%>" id="existing_consent_id_lookup<%=k%>"  title='Consent Required' value="C" onClick="callMultipleConsent('<%=existing_details[4]%>','<%=existing_details[12]%>','<%=existing_details[59]%>','<%=existing_details[9]%>','<%=existing_details[11]%>','<%=existing_details[0]%>','<%=k%>')">
						<%
					}
				}
	 
				if (((existing_details[14].trim()).equals("CN") || (existing_details[14].trim().equals("DC")) || (existing_details[14].trim().equals("RD")) || (existing_details[14].trim().equals("RJ")) || (existing_details[14].trim().equals("HD")) ) || (appt_resched_reason!=null && !appt_resched_reason.equals("")) || ((existing_details[24] != null) && (!(existing_details[24]).equals("")))) 
				{
					can_reason = (existing_details[24]).replace('\"','\n');
					if((can_reason==null || can_reason.equals("")) && (existing_details[14].trim()).equals("HD"))
						can_reason = existing_details[35]; // LAST_ACTION_REASON_DESC
					// If appointment reason (transfer) is there, put the reason
					if(appt_resched_reason!=null && !appt_resched_reason.equals(""))
						can_reason		= appt_resched_reason;
					if(can_reason!=null || !can_reason.equals("")) 
						can_reason = can_reason.replace('\"','\n');
					if((existing_details[14].trim()).equals("DC")) 
					{
						can_date_time 		= 	existing_details[33]; //disc_date_time
						can_pract_id 		= 	existing_details[34]; //disc_pract_id
					} 
					else if (!appt_resched_reason.equals("")) 
					{
						can_date_time 		= 	"";
						can_pract_id 		= 	"";
					}
					else 
					{ // For cancel
						can_date_time 		= 	existing_details[31];
						can_pract_id 		= 	existing_details[32];
					}
					if(existing_details[14].equals("HC") || existing_details[14].equals("HD"))
						str_value = "Hold";
					else if(appt_resched_reason!=null && !appt_resched_reason.equals(""))
						str_value = "Appointment Re-schedule Reason";
					else if(existing_details[14].trim().equals("DC"))
						str_value = "Discontinue";
					else if(existing_details[14].trim().equals("RD"))
						str_value = "Replaced";
					else if(existing_details[14].trim().equals("RG"))
						str_value = "Registered";
					else if(existing_details[14].trim().equals("CN"))
						str_value = "Cancel Reason";
					else
						str_value = existing_details[6];		
					%>
					<Input type='hidden' name="Cancel<%=i%>" id="Cancel<%=i%>" value="<%=can_reason%>">
					<input type="hidden" name="Cancel_date_time<%=i%>" id="Cancel_date_time<%=i%>" value="<%=can_date_time%>">
					<input type="hidden" name="Cancel_pract_id<%=i%>" id="Cancel_pract_id<%=i%>" value="<%=can_pract_id%>">
					<input type="hidden" name="Can_Reason<%=i%>" id="Can_Reason<%=i%>" value="<%=str_value%>">
					<Input type="button" name="cancel_comment<%=i%>" id="cancel_comment<%=i%>" value="?" class="button" onClick="viewCanOrderFormatLineCmts('<%=i%>','<%=existing_details[11]%>','<%=existing_details[9]%>')">
					<%	
				}
				%>
	
				</td>
				<TD class='gridData3' <%if(existing_details[72].equals("CURR_MED_YELLOW")){ out.println("bgcolor='#FFFFCC'");}else if(existing_details[72].equals("CURR_MED_PINK")){ out.println("bgcolor='PINK'");} %>> <%if((existing_details[71].equalsIgnoreCase("ACTIVE")) && (existing_details[0].equalsIgnoreCase("PH"))){out.println("<img src='../../eOR/images/pharmacy_active.png'>");}else if((existing_details[71].equalsIgnoreCase("NON_ACTIVE")) && (existing_details[0].equalsIgnoreCase("PH"))){out.println("<img src='../../eOR/images/pharmacy_inactive.png'>");}else{out.println("&nbsp");}%></TD>
				<td border='1' bgcolor='#000000'>&nbsp;</td>
				<td class='gridData3'>&nbsp;</td>
				<td class='gridData3'>&nbsp;</td>
				<td class='gridData3'>&nbsp;</td>
				<td class='gridData3'>&nbsp;</td>
				<td class='gridData3'>&nbsp;</td>
	
				<%
			}
			else
			{
				%>
	
				<td class='gridData3' >&nbsp;</td>
				<td class='gridData3'>&nbsp;</td>
				<td class='gridData3'>&nbsp;</td>
				<td class='gridData3'>&nbsp;</td>
				<td class='gridData3'>&nbsp;</td>
				<td border='1' bgcolor='#000000'>&nbsp;</td>
				<td class='gridData3' <%if(existing_details[72].equals("CURR_MED_YELLOW")){ out.println("bgcolor='#FFFFCC'");}else if(existing_details[72].equals("CURR_MED_PINK")){ out.println("bgcolor='PINK'");} %>>&nbsp;</td>
				<td class='gridData3' <%if(existing_details[72].equals("CURR_MED_YELLOW")){ out.println("bgcolor='#FFFFCC'");}else if(existing_details[72].equals("CURR_MED_PINK")){ out.println("bgcolor='PINK'");} %>><%=existing_details[70]%></td>
				<input type='hidden' name='line_num<%=i%>' id='line_num<%=i%>' value="<%=existing_details[11]%>">
				<input type='hidden' name='start_date_time<%=i%>' id='start_date_time<%=i%>' value="<%=existing_details[27]%>">
				<input type='hidden' name='catalog_code<%=i%>' id='catalog_code<%=i%>' value="<%=existing_details[12]%>">
				<input type='hidden' name='item_narration<%=i%>' id='item_narration<%=i%>' value="<%=existing_details[13]%>">
				<input type='hidden' name='location_code<%=i%>' id='location_code<%=i%>' value="<%=existing_details[19]%>">
				<input type='hidden' name='patient_class<%=i%>' id='patient_class<%=i%>' value="<%=existing_details[20]%>">
				<input type='hidden' name='cont_order_ind<%=i%>' id='cont_order_ind<%=i%>' value="<%=cont_order_ind%>">
				<input type='hidden' name='copy_yn<%=i%>' id='copy_yn<%=i%>' value="<%=existing_details[30]%>">
				<input type='hidden' name='source_type<%=i%>' id='source_type<%=i%>' value="<%=existing_details[18]%>">
				<input type='hidden' name='order_category<%=i%>' id='order_category<%=i%>' value="<%=existing_details[0]%>">
				<input type='hidden' name='ord_typ_code<%=i%>' id='ord_typ_code<%=i%>' value="<%=existing_details[4]%>">
				<input type='hidden' name='ord_typ_desc<%=i%>' id='ord_typ_desc<%=i%>' value="<%=existing_details[8]%>">
				<input type='hidden' name='ord_id<%=i%>' id='ord_id<%=i%>' value="<%=existing_details[9]%>">
				<%
				if(ext_appl_accession_num != null && !ext_appl_accession_num.equals(""))
					accession_num_tooltip = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ExternalApplicationAccessionNo.label","or_labels")+" "+ext_appl_accession_num;
				else
					accession_num_tooltip = "";					
				if(existing_details[72].equals("CURR_MED_YELLOW"))
				{
					strOrderCtl.append("<td width='' bgcolor='#FFFFCC' id='orderctl"+i+"' style='cursor:pointer' title='"+accession_num_tooltip+"' class='gridData1'");
				}
				else if(existing_details[72].equals("CURR_MED_PINK"))
				{
					strOrderCtl.append("<td  width='' bgcolor='PINK' id='orderctl"+i+"' style='cursor:pointer' title='"+accession_num_tooltip+"' class='gridData2'");
				}
				else
				{
					strOrderCtl.append("<td width='' id='orderctl"+i+"' style='cursor:pointer' title='"+accession_num_tooltip+"' class='gridDataBlue'");
				}	
				if(existing_details[9]!=null && (existing_details[9].trim().substring(0,2)).equals("CS")) 
				{ // only care set (order set) orders
					if(existing_details[72].equals("CURR_MED_PINK"))
					{
						originaltdcolor = "PINK";
					}
					else if(existing_details[72].equals("CURR_MED_YELLOW"))
					{
						originaltdcolor = "#FFFFCC";
					}
					else
					{
						originaltdcolor = "#FFFFFF";
					}
					strOrderCtl.append("onClick=\"showCareSetResults('"+existing_details[9]+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"','"+originaltdcolor+"')\" onMouseOut=\"callMouseOut(this,'"+originaltdcolor+"')\">");
				}
				else 
				{ // For other categories normal one
					if(((existing_details[0].equalsIgnoreCase("PH"))&&((existing_details[4].equalsIgnoreCase("MS"))||(existing_details[25].equalsIgnoreCase("6"))))||(!(existing_details[67].equalsIgnoreCase(""))))
					{
						if(existing_details[72].equals("CURR_MED_PINK"))
						{
							originaltdcolor = "PINK";
						}
						else if(existing_details[72].equals("CURR_MED_YELLOW"))
						{
							originaltdcolor = "#FFFFCC";
						}
						else
						{
							originaltdcolor = "#FFFFFF";
						}
						//strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',"+((allow_cancel_yn.trim().equals("Y"))?"'+getLabel('Common.cancel.label','Common')+'":"")+",,'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,,,,"+((existing_details[63].trim().equals("Y"))?"'+getLabel('eOR.Linktocurrentencounter.label','OR')+'":"")+","+((existing_details[68].trim().equals("Y"))?"'+getLabel('eOR.Replace.label','OR')+'":"")+","+((existing_details[65].trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((existing_details[66].trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+","+((existing_details[23].trim().equals("Y"))? "'+getLabel('eOR.Renew.label','OR')+'" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"','"+existing_details[4]+"','"+episode_id+"','"+episode_visit_num+"',this,'imgArrow"+i+"')\" onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"','"+originaltdcolor+"')\" onMouseOut=\"callMouseOut(this,'"+originaltdcolor+"')\">");//IN64543
						strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',"+((allow_cancel_yn.trim().equals("Y"))?"'+getLabel('Common.cancel.label','Common')+'":"")+",,'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,,,,"+((existing_details[63].trim().equals("Y"))?"'+getLabel('eOR.Linktocurrentencounter.label','OR')+'":"")+","+((existing_details[68].trim().equals("Y"))?"'+getLabel('eOR.Replace.label','OR')+'":"")+","+((existing_details[65].trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((existing_details[66].trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+","+((existing_details[23].trim().equals("Y"))? "'+getLabel('eOR.Renew.label','OR')+'" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"','"+existing_details[4]+"','"+episode_id+"','"+episode_visit_num+"',this,'imgArrow"+i+"','"+i+"')\" onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"','"+originaltdcolor+"')\" onMouseOut=\"callMouseOut(this,'"+originaltdcolor+"')\">");//IN64543
					}
					else
					{
						if(existing_details[72].equals("CURR_MED_PINK"))
						{
							originaltdcolor = "PINK";
						}
						else if(existing_details[72].equals("CURR_MED_YELLOW"))
						{
							originaltdcolor = "#FFFFCC";
						}
						else
						{
							originaltdcolor = "#FFFFFF";
						}
						//strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',"+((allow_cancel_yn.trim().equals("Y"))?"'+getLabel('Common.cancel.label','Common')+'":"")+","+((existing_details[15].trim().equals("Y"))?"'+getLabel('Common.Amend.label','Common')+'":"")+",'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,"+((existing_details[16].trim().equals("Y"))?"'+getLabel('Common.Discontinue.label','Common')+'":"")+","+((existing_details[22].trim().equals("Y"))?"'+getLabel('Common.Hold.label','Common')+'":"")+","+((existing_details[23].trim().equals("Y"))?"'+getLabel('eOR.Resume.label','OR')+'":"")+","+((existing_details[63].trim().equals("Y"))?"'+getLabel('eOR.Linktocurrentencounter.label','OR')+'":"")+","+((existing_details[68].trim().equals("Y"))?"'+getLabel('eOR.Replace.label','OR')+'":"")+","+((existing_details[65].trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((existing_details[66].trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+","+((existing_details[23].trim().equals("Y"))? "'+getLabel('eOR.Renew.label','OR')+'" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"','"+existing_details[4]+"','"+episode_id+"','"+episode_visit_num+"',this,'imgArrow"+i+"')\" onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"','"+originaltdcolor+"')\" onMouseOut=\"callMouseOut(this,'"+originaltdcolor+"')\">");//IN64543
						strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',"+((allow_cancel_yn.trim().equals("Y"))?"'+getLabel('Common.cancel.label','Common')+'":"")+","+((existing_details[15].trim().equals("Y"))?"'+getLabel('Common.Amend.label','Common')+'":"")+",'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,"+((existing_details[16].trim().equals("Y"))?"'+getLabel('Common.Discontinue.label','Common')+'":"")+","+((existing_details[22].trim().equals("Y"))?"'+getLabel('Common.Hold.label','Common')+'":"")+","+((existing_details[23].trim().equals("Y"))?"'+getLabel('eOR.Resume.label','OR')+'":"")+","+((existing_details[63].trim().equals("Y"))?"'+getLabel('eOR.Linktocurrentencounter.label','OR')+'":"")+","+((existing_details[68].trim().equals("Y"))?"'+getLabel('eOR.Replace.label','OR')+'":"")+","+((existing_details[65].trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((existing_details[66].trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+","+((existing_details[23].trim().equals("Y"))? "'+getLabel('eOR.Renew.label','OR')+'" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"','"+existing_details[4]+"','"+episode_id+"','"+episode_visit_num+"',this,'imgArrow"+i+"','"+i+"')\" onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"','"+originaltdcolor+"')\" onMouseOut=\"callMouseOut(this,'"+originaltdcolor+"')\">");//IN64543
					}
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
				if(notify_yn!=null && notify_yn.equals("Y")) 
				{
					strOrderCtl.append("<img height='15' width='15' src=\"../images/Alert.gif\">");
				} 

				if(!(existing_details[9]!=null && (existing_details[9].trim().substring(0,2)).equals("CS")))
				{
					strOrderCtl.append("<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+i+"' id='imgArrow"+i+"'></td>");
				}

				out.println(strOrderCtl.toString());
				%>
	
				<td <%if(existing_details[72].equals("CURR_MED_YELLOW")){ out.println("bgcolor='#FFFFCC'");}else if(existing_details[72].equals("CURR_MED_PINK")){ out.println("bgcolor='PINK'");} %> width='' nowrap  style='height:18px;	font-family: Verdana, Arial, Helvetica, sans-serif;	font-size: 8pt;	font-weight:normal;text-align:left;padding-left:10px;padding-right:10px;vertical-align:middle;border-top:0px;border-left:0px;border-right:0px;border-style:solid;' class='<%=((colorString[3].equals("X"))?slClassValue:colorString[3])%>'> 
				<input type="hidden" name="Appt<%=i%>" id="Appt<%=i%>" value="<%=appt_ref_num%>">
				<input type="hidden" name="Appt_date<%=i%>" id="Appt_date<%=i%>" value="<%=appt_date%>">
				<input type="hidden" name="performing_facility_id<%=i%>" id="performing_facility_id<%=i%>" value="<%=existing_details[62]%>">
				<input type="hidden" name="appt_locn<%=i%>" id="appt_locn<%=i%>" value="<%=appt_locn%>">
				<input type="hidden" name="appt_resched_yn<%=i%>" id="appt_resched_yn<%=i%>" value="<%=appt_resched_yn%>">
				<input type="hidden" name="appt_resched_reason<%=i%>" id="appt_resched_reason<%=i%>" value="<%=appt_resched_reason%>">
				<input type="hidden" name="no_of_reschedules<%=i%>" id="no_of_reschedules<%=i%>" value="<%=no_of_reschedules%>">
				<input type="hidden" name="parent_order_id<%=i%>" id="parent_order_id<%=i%>" value="">
				<input type="hidden" name="parent_order_line_num<%=i%>" id="parent_order_line_num<%=i%>" value="">
				<input type="hidden" name="explanatory_text<%=existing_details[9]%><%=existing_details[11]%>" id="explanatory_text<%=existing_details[9]%><%=existing_details[11]%>" value="<%=order_set_expln_txt%>">
				<input type="hidden" name="instrn_type<%=i%>" id="instrn_type<%=i%>" value="<%=existing_details[79]%>"><!--IN64543-->
				<%			
				if(existing_details[17].trim().equals("Y"))
				{
					if(existing_details[9]!=null && (existing_details[9].trim().substring(0,2)).equals("CS")) 
					{ // only care set (order set) orders 
						%>
						<a class='gridLink' href='javascript:showCareSetViewResults("<%=existing_details[9]%>","","<%=cont_order_ind%>","<%=patientId%>","<%=existing_details[3]%>")'>
						<%
					}  
					else 
					{ 
						if(last_action_type!=null && last_action_type.equals("NT")) 
						{ 
						%> <!--call Notes view  -->
							<a class="gridLink" href="javascript:resultViewOrder('Result','<%=existing_details[1]%>','<%=existing_details[9]%>','<%=existing_details[11]%>','<%=cont_order_ind%>','<%=patientId%>','<%=existing_details[0]%>','<%=pract_reln_id%>')">
							<%
						} 
						else 
						{
							%> <!-- Result View --> 
							<a class="gridLink" href="javascript:resultViewOrder('Result','<%=existing_details[1]%>','<%=existing_details[9]%>','<%=existing_details[11]%>','<%=cont_order_ind%>','<%=patientId%>','<%=existing_details[0]%>','<%=pract_reln_id%>')">
							<%
						}
						
					} 
					%>
					<%=existing_details[6]%> 
					</a>
					<% 
					if(existing_details[60].equalsIgnoreCase("Y"))
					{
						%>
						<input class="button" type="button" name="existing_consent_id_lookup<%=k%>" id="existing_consent_id_lookup<%=k%>"  title='Consent Required' value="C" onClick="callMultipleConsent('<%=existing_details[4]%>','<%=existing_details[12]%>','<%=existing_details[59]%>','<%=existing_details[9]%>','<%=existing_details[11]%>','<%=existing_details[0]%>','<%=k%>')">   
						<%
					}
				}
				else
				{  
					if((!appt_ref_num.equals("")) && (!appt_date.equals("")) && (existing_details[14].equals("AB")) ) 
					{
						if( (existing_details[0].equals("RD") && rd_install.equals("Y")) || (existing_details[0].equals("OT") && ot_install.equals("Y")) ) 
						{ 
						%>
							<a class="gridLink" href="javascript:viewApptData(escape('<%=i%>'))"> 
						<%		
						}
						else 
						{
							%>
							<a class="gridLink" href="javascript:viewOAApptData(escape('<%=i%>'))"> 
							<%
							if(appt_reqd_yn!=null && appt_reqd_yn.equals("Y") && !appt_ref_num.equals("") && !existing_details[0].equals("OT")  && display_appt_yn.equals("Y")) 
							{ 
								if(!existing_details[62].equals(facility_id))
								{
									String bookappt = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.RescheduleFromPerformingFacility.label","or_labels");
									appt_disabled = "disabled title='"+bookappt+"'";
								}
								else
								{
									appt_disabled = "";
								}
								%>
								<input class="BUTTON" <%=appt_disabled%> type="button" name="ReSchedule<%=i%>" value="R" onClick="viewReSchedule(escape('<%=i%>'))"> 
								<%
							} 
						} 
					} 
					if(appt_reqd_yn!=null && appt_reqd_yn.equals("Y") && appt_ref_num.equals("")  && display_appt_yn.equals("Y")) //&& existing_details[10].equals("R")) Modified by Uma on 8/26/2009 for IN013477
					{ 
						if(!(existing_details[0].equals("RD") && rd_install.equals("Y")) && !(existing_details[0].equals("OT") && ot_install.equals("Y") )&& existing_details[14].equals("OS"))
						{
							if(!existing_details[62].equals(facility_id))
							{
								String bookappt = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.AppointmentFromPerformingFacility.label","or_labels");
								appt_disabled = "disabled title='"+bookappt+"'";
							}
							else
							{
								appt_disabled = "";
							}
							%>
							<input class="BUTTON" <%=appt_disabled%> type="button" name="Schedule<%=i%>" value="S" onClick="BookAppointment(escape('<%=i%>'))">
							<%		
						}
					}	
					out.println(existing_details[6]);
					out.println("</a>");
					if(existing_details[60].equalsIgnoreCase("Y"))
					{
						%>
						<input class="button" type="button" name="existing_consent_id_lookup<%=k%>" id="existing_consent_id_lookup<%=k%>"  title='Consent Required' value="C" onClick="callMultipleConsent('<%=existing_details[4]%>','<%=existing_details[12]%>','<%=existing_details[59]%>','<%=existing_details[9]%>','<%=existing_details[11]%>','<%=existing_details[0]%>','<%=k%>')">
						<%
					}
				}
	 
				if (((existing_details[14].trim()).equals("CN") || (existing_details[14].trim().equals("DC")) || (existing_details[14].trim().equals("RD")) || (existing_details[14].trim().equals("RJ")) || (existing_details[14].trim().equals("HD")) ) || (appt_resched_reason!=null && !appt_resched_reason.equals("")) || ((existing_details[24] != null) && (!(existing_details[24]).equals("")))) 
				{
					can_reason = (existing_details[24]).replace('\"','\n');
					if((can_reason==null || can_reason.equals("")) && (existing_details[14].trim()).equals("HD"))
						can_reason = existing_details[35]; // LAST_ACTION_REASON_DESC
					// If appointment reason (transfer) is there, put the reason
					if(appt_resched_reason!=null && !appt_resched_reason.equals(""))
						can_reason		= appt_resched_reason;
					if(can_reason!=null || !can_reason.equals("")) 
						can_reason = can_reason.replace('\"','\n');
					if((existing_details[14].trim()).equals("DC")) 
					{
						can_date_time 		= 	existing_details[33]; //disc_date_time
						can_pract_id 		= 	existing_details[34]; //disc_pract_id
					} 
					else if (!appt_resched_reason.equals("")) 
					{
						can_date_time 		= 	"";
						can_pract_id 		= 	"";
					}
					else 
					{ // For cancel
						can_date_time 		= 	existing_details[31];
						can_pract_id 		= 	existing_details[32];
					}
					if(existing_details[14].equals("HC") || existing_details[14].equals("HD"))
						str_value = "Hold";
					else if(appt_resched_reason!=null && !appt_resched_reason.equals(""))
						str_value = "Appointment Re-schedule Reason";
					else if(existing_details[14].trim().equals("DC"))
						str_value = "Discontinue";
					else if(existing_details[14].trim().equals("RD"))
						str_value = "Replaced";
					else if(existing_details[14].trim().equals("RG"))
						str_value = "Registered";
					else if(existing_details[14].trim().equals("CN"))
						str_value = "Cancel Reason";
					else
						str_value = existing_details[6];		
				
					%>
					<Input type='hidden' name="Cancel<%=i%>" id="Cancel<%=i%>" value="<%=can_reason%>">
					<input type="hidden" name="Cancel_date_time<%=i%>" id="Cancel_date_time<%=i%>" value="<%=can_date_time%>">
					<input type="hidden" name="Cancel_pract_id<%=i%>" id="Cancel_pract_id<%=i%>" value="<%=can_pract_id%>">
					<input type="hidden" name="Can_Reason<%=i%>" id="Can_Reason<%=i%>" value="<%=str_value%>">
					<Input type="button" name="cancel_comment<%=i%>" id="cancel_comment<%=i%>" value="?" class="button" onClick="viewCanOrderFormatLineCmts('<%=i%>','<%=existing_details[11]%>','<%=existing_details[9]%>')">
					<%	
				}
				%>
	
				</td>
			
				<TD class='gridData3' <%if(existing_details[72].equals("CURR_MED_YELLOW")){ %>bgcolor='#FFFFCC'<%}else if(existing_details[72].equals("CURR_MED_PINK")){ %>bgcolor='PINK'<%} %> ><%if((existing_details[71].equalsIgnoreCase("ACTIVE")) && (existing_details[0].equalsIgnoreCase("PH"))){out.println("<img src='../../eOR/images/pharmacy_active.png'>");}else if((existing_details[71].equalsIgnoreCase("NON_ACTIVE")) && (existing_details[0].equalsIgnoreCase("PH"))){out.println("<img src='../../eOR/images/pharmacy_inactive.png'>");}else{out.println("&nbsp;");}%></TD>
	
				<%
			}
			i++;
			old_order_date = existing_details[69];
		}
		%>
	</tr>
</table>
</div>
<input type='hidden' name='source_type' id='source_type' value="<%=src_type%>">

<input type=hidden name='total_recs' id='total_recs' value='<%=i%>'>

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
<input type=hidden name='function_from' id='function_from' value=''>

<input type=hidden name='p_called_from_ca' id='p_called_from_ca' value='<%=p_called_from_ca%>'>
<input type=hidden name='sex' id='sex' value='<%=sex%>'>
<input type=hidden name='age' id='age' value='<%=age%>'>
<input type=hidden name='dob' id='dob' value='<%=dob%>'>
<input type=hidden name='visit_adm_date' id='visit_adm_date' value='<%=visit_adm_date%>'>
<input type='hidden' name='queryString' id='queryString' value='<%=request.getQueryString()%>'>
<input type='hidden' name='patientId' id='patientId' value='<%=patient_id%>'>
<input type='hidden' name='encntr_id' id='encntr_id' value='<%=encntr_id%>'>
<input type='hidden' name='relationship_id' id='relationship_id' value='<%=pract_reln_id%>'>
<input type='hidden' name='ord_status' id='ord_status' value='<%=order_status%>'>
<input type='hidden' name='order_by' id='order_by' value='<%=order_by%>'>
<input type='hidden' name='catalog' id='catalog' value='<%=catalog%>'>
<input type='hidden' name='order_type' id='order_type' value='<%=order_type%>'>
<input type='hidden' name='view' id='view' value='<%=view%>'>
<input type='hidden' name='priority' id='priority' value='<%=priority%>'>
<input type='hidden' name='date_from' id='date_from' value='<%=date_from%>'>
<input type='hidden' name='date_to' id='date_to' value='<%=date_to%>'>
<input type='hidden' name='order_category' id='order_category' value='<%=order_category%>'>
<input type='hidden' name='view_by' id='view_by' value='<%=view_by%>'>
<input type='hidden' name='search_criteria' id='search_criteria' value='<%=search_criteria%>'>
<input type='hidden' name='cosign' id='cosign' value='<%=cosign%>'>
<input type='hidden' name='activity_type' id='activity_type' value='<%=activity_type%>'>
<input type='hidden' name='curr_sys_date' id='curr_sys_date' value='<%=curr_sys_date%>'>
<input type='hidden' name='start_date_obj' id='start_date_obj' value=''>
<input type='hidden' name='locale' id='locale' value='<%=localeName%>'>
<input type='hidden' name='elapsed_orders' id='elapsed_orders' value='<%=elapsed_orders%>'>
<input type='hidden' name='sys_cancelled_orders' id='sys_cancelled_orders' value='<%=sys_cancelled_orders%>'>
<input type='hidden' name='group_by' id='group_by' value='<%=group_by%>'><!-- Menaka -->
<input type='hidden' name='order_frequency' id='order_frequency' value='<%=order_frequency%>'><!-- Menaka -->
<input type=hidden name='called_from' id='called_from' value='<%=called_from%>'>
<input type='hidden' name='from' id='from' value='<%=from%>'>
<input type='hidden' name='to' id='to' value='<%=to%>'>
<input type='hidden' name='category_type' id='category_type' value='<%=category_type%>'>
<input type='hidden' name='ordercate_for_filter' id='ordercate_for_filter' value='<%=order_category%>'> <!-- IN035773Â  -->
<input type='hidden' name='call_from' id='call_from' value='<%=call_from%>'> <!-- 32825 -->

</form>
<div name='tooltiplayer' id='tooltiplayer' style="position: absolute; visibility: hidden; width: 150px; height: 100px;" bgcolor='blue' >
	<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%' align='center'>
		<tr>
			<td width='100%' id='tooltd'>&nbsp;</td>
		
		</tr>
	</table>
</div>
</body>
<script>
if(parent.parent.ExistingOrderSearch)
{
	parent.parent.ExistingOrderSearch.document.existing_order_search.search.disabled = false;
    if(document.getElementById("select_all"))
	{
	   document.getElementById("select_all").disabled = false;
	}
}
else if(parent.ExistingOrderSearch.document.existing_order_search)
{
	parent.ExistingOrderSearch.document.existing_order_search.search.disabled = false;
	if(document.getElementById("select_all"))
	{
	   document.getElementById("select_all").disabled = false;
	}
}
</script>
</html>

