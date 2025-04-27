<!DOCTYPE html>
<%
/*
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
*/
/* 
-----------------------------------------------------------------------
Date       Edit History      Name        		Description
-----------------------------------------------------------------------
?             100            ?           		created
26/06/2012    IN033488      Chowminya G     Incident No: IN033488 -  Error Marking - Result completed indicator> 
23/07/2012    IN033472		Nijitha S		System does not display Appointment Reschedule Reason in Existing orders.
25/09/2012	  IN030279		Ramesh G		Bru-HIMS-CRF-160
19/10/2012    IN033061      Chowminya G     System doesnt display menu cancel/discontinue if the orders are IV Fluid ,IV Fluid+Drug, IV Fluid+Drug(Frequency). 
17/12/2012	  IN036674		Ramesh G		In Existing Orders there is no option to print the Order Sheet but there is option to select the order.
20/02/2012	  IN037398		Chowminya G		System displays as "Consent Required"
18/04/2013    IN038336      Chowminya G     In the Existing Order, there are yellow box that which not reflecting with any colour coding in the legend.
05/06/2013    IN029948		Nijitha  S      Bru-HIMS-CRF-082
06/06/2013    IN040198.1    Chowminya G     Reopen - Status of the Order Catalog is displayed wrongly
22/07/2013    IN041421      Chowminya G     special characters - record consent "Internal Server Error" is displayed
07/08/2013	  IN042100      Chowminya G		Ph Category  -  Hold Order Option line level with MAR status P
06/05/2014	  IN048935		Nijitha S		ML-BRU-SCF-1318	- In the existing order tab, once a drug has been discontinued, the order status changes to Discontinued However the MAR status in the existing order still remains as In Progress
20/05/2014	  IN049203		Chowminya		Existing order - Discontinue reason details not populated
13/08/2014	  IN049419		Ramesh G		An Audit Trail for Additional Information Amendment of Order	
03/06/2015	  IN054720		Vijayakumar K	ML-BRU-SCF-1580 [IN:054720]
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        		Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
09/10/2015	IN055910		Karthi L										From Clinician Access, modified result shall be identified by include ?!? in Blue color
21/10/2015	IN057196		Ramesh G		Recording Of Consent Form
21/10/2015	  IN058125		Karthi L												Modified icon is showing for Registration Status.	
08/03/2016	IN059490		Karthi L										After placing orders, in Existing order ? keeping the Status as active and click search takes more than 1 minute to display the ordered details.[AAKH-SCF-0252]							
10/05/2017	IN064215		Krishna Gowtham J	10/05/2017	Ramesh G		PMG2017-SH-CRF-0001							
12/05/2017	IN063781		Krishna Gowtham J	12/05/2017		Ramesh G		ML-MMOH-CRF-0804					
09/06/2017	IN063816		Krishna Gowtham J	09/06/2017		Ramesh G		GHL-CRF-0445.1
10/07/2017	IN061903		Krishna Gowtham J 	10/07/2017		Ramesh G		ML-MMOH-CRF-0555
28/08/2017	IN065091		Krishna Gowtham J 	29/08/2017		Ramesh G		GHL-CRF-0440.1					
15/12/2017	IN065942		Dinesh T		15/12/2017		Ramesh G		In Nuclear medicine  department we required the 																				barcode functionality at the time of 																						Registration of order,required patient 																						Id,patient name,age,sex,register date and name 																				of study.
20/03/2018      IN066414		Sharanraj		13/04/2018		Ramesh G		ML-MMOH-CRF-1071
06/06/2018  	IN08078			Sharanraj		12/06/2018		Ramesh G		ML-MMOH-SCF-1011
23/07/2018	IN64543			Dinesh T		23/07/2018		Ramesh G		ML-MMOH-CRF-0776
18/07/2018   	IN061961		sivabagyam M    	18/07/2018		Ramesh G		GHL-CRF-0433
16/10/2018	IN066709		Prakash C		16/10/2018		Ramesh G 		ML-MMOH-CRF-1101
17/10/2018	IN067817		sivabagyam	 17/10/2018	        Ramesh G       ML-MMOH-CRF-1198	
05/11/2018	IN068986		Ramya Maddena		05/11/2018		Ramesh G		MO-CRF-20137.1
9/11/2018	IN068994		sivabagyam	 09/11/2018	        Ramesh G       CA-Common-Existing order-Print
28/1/2019	IN069597 		sivabagyam	 28/1/2019	        Ramesh G       CA-Common-Multi Facility Orders
14/10/2019  IN071315	    Nijitha S   	14/10/2019  	Ramesh G		GHL-CRF-0607
06/07/2020	IN072654	Nijitha S	06/07/2020	Ramesh G	MMS-KH-CRF-0029.4
04/08/2020	IN073565	Nijitha S	04/08/2020	Remesh G	MMS-KH-CRF-0029.4/03
24/09/2020	IN074110	Nijitha S	24/09/2020	Remesh G	MMS-KH-CRF-0029.4/05
14/10/2020	IN072542		SIVABAGYAM M	14/10/2020	RAMESH G	CA-GHL-CRF-0558.1-US003/02- View Chart Summary
16/08/2021	19112			Ramesh												NMC-JD-CRF-0106
07/09/2023	  31792	   Ranjith P R		08/09/2023		RAMESH G		ML-MMOH-CRF-1913
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,java.sql.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
try
{
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
 	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script><!-- used for date validation-->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../../eOR/js/ExistingOrder.js"></script>
 	<script language="JavaScript" src="../../eOR/js/ViewOrder.js"></script> <!-- added to include the function for displaying the cancel reason -->
 	<script language="JavaScript" src="../../eOR/js/ResultOrder.js"></script> <!-- added to include the function for viewing the results onclicking the status hyperlink -->
 	<script language="JavaScript" src="../../eOR/js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 	
 	<Style>		
    </Style>
	<script>
	//IN029948 Starts
	async function showDetailsPH(patient_id,order_id,order_line_no,line_status_text)
	{
	var dialogHeight= "40vh" ;
	var dialogWidth	= "50vw" ;
	var dialogTop = "240" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var retVal = await window.showModalDialog("../../ePH/jsp/QueryPatientDrugProfileLocations.jsp?patient_id="+patient_id+"&order_id="+order_id+"&order_line_no="+order_line_no+"&line_status_text="+line_status_text,arguments,features);
	}
	//IN029948 Ends
	function dummy(){}
	function hideToolTip(obj,imgObj,row)	
	{
		dynamichide(obj, window.event,row);
	  /*document.getElementById('tooltiplayer').style.visibility = 'hidden'
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


	/*function resizeWindow(orderctlHDR)
	{
		
	    var orderctlHDR1 = orderctlHDR.id;
		var wdth = document.getElementById('orderctlHDR1').offsetWidth;
		var hght1 = document.getElementById('orderctlHDR1').offsetHeight;		
		
		var wdth1 = getPos(orderctlHDR).x +wdth;
		var hght = getPos(orderctlHDR).y ;	

		bodwidth  = document.body.offsetWidth
		bodheight = document.body.offsetHeight
		
		var z = bodwidth- (event.x + wdth);	
		
		var x 	  = event.x;
		var y 	  = event.y;	
		
		x 	  = x + (document.getElementById('tooltiplayer').offsetWidth);
		y 	  = hght + (document.getElementById('tooltiplayer').offsetHeight);	
		
		if(x<bodwidth){
			x= wdth1;
			
		}else{			
			x = getPos(orderctlHDR).x;
			
		}
		if(y<bodheight){			
			y = hght;
			
		}else
		{
			y = y - (document.getElementById('tooltiplayer').offsetHeight*2) + hght1 ;	
		}
	
		document.getElementById('tooltiplayer').style.posLeft= x;
		document.getElementById('tooltiplayer').style.posTop = y;
		document.getElementById('tooltiplayer').style.visibility='visible'
	}

	function displayToolTip(val,ord_cat,val1,orderId,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,sex,age,dob,visit_adm_date,cont_order_ind,order_status,iv_prep_yn,ord_typ_code,catalog_code,episode_id,episode_visit_num,orderctlHDR,imgObj,existing_order_called_from_new){//Added existing_order_called_from_new for IN074110
		

		callMouseOverOnTD(orderctlHDR,imgObj);

		buildTable (val,ord_cat,val1,orderId,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,sex,age,dob,visit_adm_date,cont_order_ind,order_status,iv_prep_yn,ord_typ_code,catalog_code,episode_id,episode_visit_num,existing_order_called_from_new)//Added existing_order_called_from_new for IN074110
			resizeWindow(orderctlHDR);

	}


	//function displayToolTip1(val,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,cont_order_ind,order_status,sex,age,dob,visit_adm_date,iv_prep_yn,ord_typ_code,episode_id,episode_visit_num,orderctlHDR,imgObj)//IN64543
	//function displayToolTip1(val,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,cont_order_ind,order_status,sex,age,dob,visit_adm_date,iv_prep_yn,ord_typ_code,episode_id,episode_visit_num,orderctlHDR,imgObj,instrn_type)//IN64543
	function displayToolTip1(val,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,cont_order_ind,order_status,sex,age,dob,visit_adm_date,iv_prep_yn,ord_typ_code,episode_id,episode_visit_num,orderctlHDR,imgObj,instrn_type,view_by,existing_order_called_from_new)//IN061961//Added existing_order_called_from_new for IN074110
	{
			//buildTable1 (val,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,cont_order_ind,order_status,sex,iv_prep_yn)
		  
			callMouseOverOnTD(orderctlHDR,imgObj);
			
			//buildTable1 (val,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,cont_order_ind,order_status,sex,age,dob,visit_adm_date,iv_prep_yn,ord_typ_code,episode_id,episode_visit_num);//IN64543
			//buildTable1 (val,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,cont_order_ind,order_status,sex,age,dob,visit_adm_date,iv_prep_yn,ord_typ_code,episode_id,episode_visit_num,instrn_type);//IN64543
			buildTable1 (val,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,cont_order_ind,order_status,sex,age,dob,visit_adm_date,iv_prep_yn,ord_typ_code,episode_id,episode_visit_num,instrn_type,view_by,existing_order_called_from_new);//IN061961//Added existing_order_called_from_new for IN074110
			resizeWindow(orderctlHDR);
	}


	function buildTable(val,ord_cat,val1,orderId,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,sex,age,dob,visit_adm_date,cont_order_ind,order_status,iv_prep_yn,ord_typ_code,catalog_code,episode_id,episode_visit_num,existing_order_called_from_new) {//Added existing_order_called_from_new for IN074110

		
		
        var rowval   = val.split (",");
		var row      = ("View,Cancels,Ammend,Discontinue,Hold,Resume,LinkToCurrentEncounter,ViewReplacedOrder,ViewOriginalOrder,Renew");
		rowval1      = row.split(",");
		//var tab_dat  = "<table id='tooltiptable1' class='contextMenu' width='80%' height='100%' align='center'>"
		var tab_dat = "<table id='tooltiptable1' class='contextMenu' width='100%' height='100%' align='center' style='background-color: lightgrey; border: 1px solid black; '>";
    
		for( var i=0; i<rowval.length; i++ ) {
			//alert(rowval.length);
			//alert(i);
			//alert(rowval[i]);
			var colval  = rowval[i];

			var colval1 = rowval1[i];

			if (colval != "" )
			{
				tab_dat     += "<tr>"
				if(colval1 == "Ammend" || colval1 == "Renew"){
					//alert(document.existing_order_dtl.queryString.value);
					
					queryString = document.existing_order_dtl.queryString.value;

					if (colval1 == "Renew" && (ord_cat != 'PH')) {
						
						tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class= 'contextMenuLink' href=javascript:callRenewFunctions('"+orderId+"','"+patient_id+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+escape(visit_adm_date)+"','"+iv_prep_yn+"','"+colval1+"','"+queryString+"')>"+colval+" </a></td>"
					} else {

						//IN049419 Start.
						//tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class= 'contextMenuLink' href=javascript:callAmmendFunctions('"+orderId+"','"+patient_id+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+escape(visit_adm_date)+"','"+iv_prep_yn+"','"+colval1+"')>"+colval+" </a></td>"
						tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class= 'contextMenuLink' href=javascript:callAmmendFunctions('"+orderId+"','"+patient_id+"','"+ord_cat+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+escape(visit_adm_date)+"','"+iv_prep_yn+"','"+colval1+"')>"+colval+" </a></td>"
						//IN049419 End.
					}
				}else{
					tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class= 'contextMenuLink' href=javascript:callMenuFunctions('"+colval1+"','"+patient_id+"','"+ord_cat+"','"+escape(val1)+"','"+orderId+"','"+cont_order_ind+"','"+order_status+"','"+sex+"','"+ord_typ_code+"','"+catalog_code+"','"+encntr_id+"','"+patient_class+"','"+location_code+"','"+location_type+"','"+episode_id+"','"+episode_visit_num+"','"+existing_order_called_from_new+"')>"+colval+" </a></td>"//Added existing_order_called_from_new for IN074110
				}
				tab_dat     += "</tr> "
			}
		}
			tab_dat     += "</table> "
		document.getElementById('t').innerHTML = tab_dat;
	}

	//function buildTable1(val,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,cont_order_ind,order_status,sex,iv_prep_yn) {
	//function buildTable1(val,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,cont_order_ind,order_status,sex,age,dob,visit_adm_date,iv_prep_yn,ord_typ_code,episode_id,episode_visit_num) {//IN64543
		//function buildTable1(val,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,cont_order_ind,order_status,sex,age,dob,visit_adm_date,iv_prep_yn,ord_typ_code,episode_id,episode_visit_num,instrn_type) {//IN64543
		function buildTable1(val,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,cont_order_ind,order_status,sex,age,dob,visit_adm_date,iv_prep_yn,ord_typ_code,episode_id,episode_visit_num,instrn_type,view_by,existing_order_called_from_new) {//IN061961//Added existing_order_called_from_new for IN074110
		
	    var rowval   = val.split (",");
		//IN061903 start
		//var row      = ("View,Cancel,Amend,Preps,Comments,Instructions,,Discontinue,Hold,Resume,LinkToCurrentEncounter,Replace,ViewReplacedOrder,ViewOriginalOrder,Renew");//IN072654
		var row      = ("View,Cancel,Amend,Preps,Comments,Instructions,,Discontinue,Hold,Resume,LinkToCurrentEncounter,Replace,ViewReplacedOrder,ViewOriginalOrder,Renew,InteractionDtls");//IN072654
		//var row      = ("View,Cancel,Amend,Preps,Comments,Instructions,,Discontinue,Hold,Resume,LinkToCurrentEncounter,Replace,ViewReplacedOrder,ViewOriginalOrder,Renew,NotDone");
		//IN061903 ends	
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
						var cnsnt_with_order_yn = document.existing_order_dtl.queryString.value;
						   tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class= 'contextMenuLink' href=\"javascript:callAmmendFunctions1('"+colval1+"','"+escape(val1)+"','"+ord_cat+"','"+orderId+"','"+cancel_type+"','"+order_line_num+"','"+catalog_code+"','"+item_narration+"','"+patient_id+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+order_status+"','"+sex+"','"+age+"','"+dob+"','"+escape(visit_adm_date)+"','"+iv_prep_yn+"','"+cnsnt_with_order_yn+"')\">"+colval+"</a></td>";
						
						//alert("tab_dat"+tab_dat);
						// tab_dat     += "<td class = 'ORMENULAYER' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=\"javascript:callAmmendFunctions1('"+colval1+"','"+escape(val1)+"','"+ord_cat+"','"+orderId+"','"+cancel_type+"','"+order_line_num+"','"+catalog_code+"','"+item_narration+"','"+patient_id+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+order_status+"','"+sex+"','"+age+"','"+dob+"','"+escape(visit_adm_date)+"','"+iv_prep_yn+"','"+order_Set_id+"')\"><B>"+colval+" </B></a></td>";
					}
				}
				else 
				{					
					//var order_status=""; //Commented IN042100
					//tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class= 'contextMenuLink' href=javascript:callMenuFunctions1('"+colval1+"','"+escape(val1)+"','"+ord_cat+"','"+orderId+"','"+cancel_type+"','"+order_line_num+"','"+catalog_code+"','"+item_narration+"','"+patient_id+"','"+cont_order_ind+"','"+order_status+"','"+sex+"','"+ord_typ_code+"','"+encntr_id+"','"+patient_class+"','"+location_code+"','"+location_type+"','"+episode_id+"','"+episode_visit_num+"','"+iv_prep_yn+"')>"+colval+" </a></td>"; //Included iv_prep_yn --[IN033061]//IN64543
					//tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class= 'contextMenuLink' href=javascript:callMenuFunctions1('"+colval1+"','"+escape(val1)+"','"+ord_cat+"','"+orderId+"','"+cancel_type+"','"+order_line_num+"','"+catalog_code+"','"+item_narration+"','"+patient_id+"','"+cont_order_ind+"','"+order_status+"','"+sex+"','"+ord_typ_code+"','"+encntr_id+"','"+patient_class+"','"+location_code+"','"+location_type+"','"+episode_id+"','"+episode_visit_num+"','"+iv_prep_yn+"','"+instrn_type+"')>"+colval+" </a></td>"; //Included iv_prep_yn --[IN033061]//IN64543
					//tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class= 'contextMenuLink' href=javascript:callMenuFunctions1('"+colval1+"','"+escape(val1)+"','"+ord_cat+"','"+orderId+"','"+cancel_type+"','"+order_line_num+"','"+catalog_code+"','"+item_narration+"','"+patient_id+"','"+cont_order_ind+"','"+order_status+"','"+sex+"','"+ord_typ_code+"','"+encntr_id+"','"+patient_class+"','"+location_code+"','"+location_type+"','"+episode_id+"','"+episode_visit_num+"','"+iv_prep_yn+"','"+instrn_type+"','"+view_by+"')>"+colval+" </a></td>"; //IN061961 Commented for IN071315
					//tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class= 'contextMenuLink' href=javascript:callMenuFunctions1('"+colval1+"','"+escape(val1)+"','"+ord_cat+"','"+orderId+"','"+cancel_type+"','"+order_line_num+"','"+catalog_code+"','"+item_narration+"','"+patient_id+"','"+cont_order_ind+"','"+order_status+"','"+sex+"','"+ord_typ_code+"','"+encntr_id+"','"+patient_class+"','"+location_code+"','"+location_type+"','"+episode_id+"','"+episode_visit_num+"','"+iv_prep_yn+"','"+instrn_type+"','"+view_by+"','"+p_called_from_ca+"')>"+colval+" </a></td>"; //Added for IN071315
					tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class= 'contextMenuLink' href=javascript:callMenuFunctions1('"+colval1+"','"+escape(val1)+"','"+ord_cat+"','"+orderId+"','"+cancel_type+"','"+order_line_num+"','"+catalog_code+"','"+item_narration+"','"+patient_id+"','"+cont_order_ind+"','"+order_status+"','"+sex+"','"+ord_typ_code+"','"+encntr_id+"','"+patient_class+"','"+location_code+"','"+location_type+"','"+episode_id+"','"+episode_visit_num+"','"+iv_prep_yn+"','"+instrn_type+"','"+view_by+"','"+p_called_from_ca+"','"+existing_order_called_from_new+"')>"+colval+" </a></td>"; //Added for IN071315//Added existing_order_called_from_new for IN074110
				}
				tab_dat     += "</tr> "
			}
		}
			tab_dat     += "</table> "
			//alert(tab_dat);
		document.getElementById('t').innerHTML = tab_dat;
	}
	function viewCanOrderFormatLineCmts1(line,order_line_num,orderId,view_by){
			var dialogHeight ='18' ;
			var dialogWidth = '29' ;
			var dialogTop	= '189';
			var dialogLeft = '167' ;
			var title = '';
			var cancel_date_time = "";
			var cancel_pract_id  = "";
			var order_status = eval("document.existing_order_dtl.order_status"+line+".value");
			/*if(can_reason=="Cancel Reason")
				can_reason=getLabel('eOR.CancelReason.label','OR');
			else if(can_reason=="Discontinue")
				can_reason=getLabel('eOR.Discontinue.label','OR');
			else if(can_reason=="Comments")
				can_reason=getLabel('Common.Comments.label','Common');*/
			var can_reason = eval("document.existing_order_dtl.Can_Reason"+line+".value");
		    var order_category = eval("document.existing_order_dtl.order_category"+line+".value");
			
			var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';
 			if(can_reason=="Comments")
				var narration = eval("document.existing_order_dtl.Cmts"+line+".value");
			else{
 				var narration = eval("document.existing_order_dtl.Cancel"+line+".value");
				cancel_date_time =  eval("document.existing_order_dtl.Cancel_date_time"+line+".value"); 
				cancel_pract_id =  eval("document.existing_order_dtl.Cancel_pract_id"+line+".value"); 
			}	
 			var arguments = "";
			
			//var finalString	= "can_reason="+encodeURIComponent(can_reason)+"&cancel_date_time="+cancel_date_time+"&cancel_pract_id="+cancel_pract_id+"&order_line_num="+order_line_num+"&orderId="+orderId+"&view_by="+view_by;IN033472
			var Appt_can_remarks		= eval("parent.ExistingOrderResult.document.existing_order_dtl.Appt_can_remarks"+line+".value");//IN033472
			var Appt_can_reason		= eval("parent.ExistingOrderResult.document.existing_order_dtl.Appt_can_reason"+line+".value");//ML-MMOH-CRF-1617.1
			if (Appt_can_remarks !== "" || Appt_can_reason !== "") {
			    can_reason = "Appointment cancel Reason";
			}
			
			var finalString	= "can_reason="+encodeURIComponent(can_reason)+"&cancel_date_time="+cancel_date_time+"&cancel_pract_id="+cancel_pract_id+"&order_line_num="+order_line_num+"&orderId="+orderId+"&view_by="+view_by+"&order_category="+order_category+"&order_status="+order_status;//IN033472//ML-MMOH-CRF-1617.1
			//var finalString	= "can_reason="+encodeURIComponent(can_reason)+"&cancel_date_time="+cancel_date_time+"&cancel_pract_id="+cancel_pract_id+"&order_line_num="+order_line_num+"&orderId="+orderId+"&view_by="+view_by+"&appt_resched_reason="+appt_resched_reason;//IN033472
			
			var retVals = window.showModalDialog("../../eOR/jsp/ViewLineComment.jsp?"+finalString,arguments,features);

}
	//ML-MMOH-CRF-1617.1 START
function viewCanOrderFormatLineCmts(line,order_line_num,orderId,view_by){
		
	var can_reason = eval("document.existing_order_dtl.Can_Reason"+line+".value");	
	var order_status = eval("document.existing_order_dtl.order_status"+line+".value");
	if(order_status=="Appt Scheduled"){
		var dialogHeight ='18' ;
	}else{
		var dialogHeight ='14' ;
	}
	
		var dialogWidth = '29' ;
		var dialogTop	= '189';
		var dialogLeft = '167' ;
		var title = '';
		var cancel_date_time = "";
		var cancel_pract_id  = "";

			/*if(can_reason=="Cancel Reason")
				can_reason=getLabel('eOR.CancelReason.label','OR');
			else if(can_reason=="Discontinue")
				can_reason=getLabel('eOR.Discontinue.label','OR');
			else if(can_reason=="Comments")
				can_reason=getLabel('Common.Comments.label','Common');*/
			var can_reason = eval("document.existing_order_dtl.Can_Reason"+line+".value");
			
			var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';
 			if(can_reason=="Comments")
				var narration = eval("document.existing_order_dtl.Cmts"+line+".value");
			else{
 				var narration = document.getElementById('Cancel'+line).value;
				cancel_date_time =  document.getElementById('Cancel_date_time'+line).value; 
				cancel_pract_id =  document.getElementById('Cancel_pract_id'+line).value; 
			}	
 			var arguments = "";
			
			//var finalString	= "can_reason="+encodeURIComponent(can_reason)+"&cancel_date_time="+cancel_date_time+"&cancel_pract_id="+cancel_pract_id+"&order_line_num="+order_line_num+"&orderId="+orderId+"&view_by="+view_by;IN033472
			var appt_resched_reason		= parent.ExistingOrderResult.document.getElementById('appt_resched_reason'+line).value;//IN033472
			var finalString	= "can_reason="+encodeURIComponent(can_reason)+"&cancel_date_time="+cancel_date_time+"&cancel_pract_id="+cancel_pract_id+"&order_line_num="+order_line_num+"&orderId="+orderId+"&view_by="+view_by+"&appt_resched_reason="+appt_resched_reason;//IN033472
			var retVals =await  top.window.showModalDialog("../../eOR/jsp/ViewLineComment.jsp?"+finalString,arguments,features);

}
async function showSlidingDetails(order_id, order_line_num, sliding_scale_yn){
                var dialogHeight= "13vh" ;
                var dialogWidth = "35vh" ;
                var dialogTop = "400" ;
                var center = "1" ;
                var status="no";
                var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" +             dialogTop;
                var arguments = "" ;
                var retVal =       await window.showModalDialog("../../ePH/jsp/QueryPatientDrugProfileRemarks.jsp?order_id="+order_id+"&order_line_num="+order_line_num+"&sliding_scale_yn="+sliding_scale_yn+"&called_frm=SlidingScale",arguments,features);
}


	</script>

	<!-- <STYLE TYPE="text/css">
       	A:link
       	 {
       	     COLOR: blue;
       	 }
     	A:visited
     	 {
             COLOR: blue ;
         }
        A:active
         {
             COLOR: red;
         }
     </STYLE> -->
	<!--IN065091 start-->
	<style>
	TD.QRY11 
	{
		BACKGROUND-COLOR: #05bbea;
		FONT-SIZE: 9PT ;
		BORDER-COLOR:	BLACK;
		BORDER-LEFT-COLOR: #D5E2E5;
		BORDER-RIGHT-COLOR: #D5E2E5;
		BORDER-TOP-COLOR: #D5E2E5;
		BORDER-BOTTOM-COLOR: #D5E2E5;
	}
	</style>
	<!--IN065091 Ends-->
</head>
<body  onscroll='processScroll()' onload='FocusFirstElement()'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String mode	   = "1";

	String patient_id	= request.getParameter("patientId");
	String encounter_id	= request.getParameter("encntr_id");
	
	String bean_id 		= "@existingorderbean"+patient_id+encounter_id;
 
	//String bean_id = "Or_ExistingOrder" ;
	String bean_name = "eOR.ExistingOrder";

	
	String facility_id = (String)session.getValue("facility_id");
	String resp_id = (String)session.getValue("responsibility_id");

	String pract_reln_id = request.getParameter("pract_reln_id")==null?"":request.getParameter("pract_reln_id");
	
	String practitioner_type  	= (String) session.getValue("practitioner_type");

	if(practitioner_type== null)practitioner_type = "";
	if(resp_id== null)resp_id = "";
	String episode_id ="";
	String episode_visit_num ="";
	String rd_install	= "N";
	String ot_install	= "N";
 	String old_category	 = "";
	String order_set_expln_txt="View Order Set Detail";

	ArrayList PrEncounterDtls		= null;
 	ArrayList allValues = new ArrayList();
	ArrayList ErrStatusChk		= null;//--[IN033488]


	/* Initialize Function specific start */
	//ExistingOrder bean = (ExistingOrder)mh.getBeanObject( bean_id, request,  bean_name ) ;
	ExistingOrder bean = (ExistingOrder)getBeanObject( bean_id, bean_name, request ) ;

    bean.setLanguageId(localeName);

	if(!bean.checkForNull(encounter_id,"").equals(""))
	{
		PrEncounterDtls  = bean.getPREncounterDetails(facility_id,encounter_id); 		
		if(PrEncounterDtls!=null)
		{
			for(int j=0; j<PrEncounterDtls.size(); j++)
			{
				String[] record 						= (String[])PrEncounterDtls.get(j);
				episode_id					= bean.checkForNull(record[3],"");
				episode_visit_num		= bean.checkForNull(record[4],"");
			}
		}
 	}  // End of function_from != "CP" 
	String from	 = bean.checkForNull(request.getParameter( "from" ),"1") ;
	String to	 = bean.checkForNull(request.getParameter( "to" ),"7") ;

 	int start	 = Integer.parseInt(from);
	int end		= Integer.parseInt(to);

// THESE ARE THE PARAMS FOR AMMEND FUNCTION

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
	

// THESE ARE THE PARAMS FOR AMMEND FUNCTION - END
%>
<%  	
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
	String order_category	= request.getParameter( "order_category" ) ;
	String order_type		= request.getParameter( "order_type" ) ;
	String view_by			= request.getParameter( "view_by" ) ;
	String search_criteria	= request.getParameter( "search_criteria" ) ;
	String cosign			= request.getParameter("cosign") ;
	String activity_type			= request.getParameter("activity_type") ;
	String elapsed_orders			= request.getParameter("elapsed_orders") ;
	String sys_cancelled_orders			= request.getParameter("sys_cancelled_orders") ;
	String curr_sys_date    = "";
	String action_type    = "";//--[IN033488]
	String action_date_time    = "";
	String action_by_id    = "";
	String recordConsentWithOrder = bean.getRecordConsetFormWithOrderYN();  //IN057196
	String cnsnt_with_order_yn = bean.checkForNull(request.getParameter("cnsnt_with_order_yn"),"N");  //IN057196
	//IN030279 Start.
		String function_from = ((String)request.getParameter("function_from"))==null ? "" : (String)request.getParameter("function_from");
		String existing_order_called_from_new = ((String)request.getParameter("existing_order_called_from_new"))==null ? "" : (String)request.getParameter("existing_order_called_from_new");//IN074110
		String deceased_yn = ((String)request.getParameter("deceased_yn"))==null ? "" : (String)request.getParameter("deceased_yn");
		String medico_legal_yn = ((String)request.getParameter("medico_legal_yn"))==null ? "" : (String)request.getParameter("medico_legal_yn");
		String postmortem_status = ((String)request.getParameter("postmortem_status"))==null ? "" : (String)request.getParameter("postmortem_status");
		String body_part_yn = ((String)request.getParameter("body_part_yn"))==null ? "" : (String)request.getParameter("body_part_yn");
		String registration_no = ((String)request.getParameter("registration_no"))==null ? "" : (String)request.getParameter("registration_no");
		String callingFrom = ((String)request.getParameter("callingFrom"))==null ? "" : (String)request.getParameter("callingFrom");
	//IN030279 End.
	String queryString = ((String)request.getParameter("queryString"))==null ? (String)request.getQueryString() : (String)request.getParameter("queryString");   //[IN036674]
	String lv_neonate_spec_yn	= "";//31792
	String Appt_can_reason	= "";//ML-MMOH-CRF-1617.1
	String Appt_can_remarks	= "";//ML-MMOH-CRF-1617.1
	String Appt_resched_remarks	= "";//ML-MMOH-CRF-1617.1
	
	//68801 start
	String existexternalReqFormYN="";
	String locale = request.getParameter("locale")==null?"":request.getParameter("locale") ;
	String visit_Id = request.getParameter("visit_Id")==null?"":request.getParameter("visit_Id") ;
	String Patient_ID = request.getParameter("Patient_ID")==null?"":request.getParameter("Patient_ID") ;
	//68801 end 
	
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
	if(elapsed_orders != null )elapsed_orders = elapsed_orders.trim();				else elapsed_orders = "";
	if(sys_cancelled_orders != null )sys_cancelled_orders = sys_cancelled_orders.trim();				else sys_cancelled_orders = "";
	

	rd_install = bean.getRadiology(facility_id);
	if(rd_install==null) rd_install = "N";

	ot_install = bean.getOTModule(facility_id);
	if(ot_install==null) ot_install = "N";
	
	//IN063816 start
	String barcodeSiteSpecificYN = "";

	boolean isSiteSpecific = false;
	boolean isSiteSpecificBTColor = false;//IN065091
	Connection connection =  null;
	
	boolean isSiteSpecificBillStatus = false; //19112
	boolean isSiteSpecificNeonatalMotherSpecimen=false;//31792
try{
	connection = ConnectionManager.getConnection(request); 
	isSiteSpecific = eCommon.Common.CommonBean.isSiteSpecific(connection, "OR","GHL_BARCODE_LABEL_REPORT");
	isSiteSpecificBillStatus = eCommon.Common.CommonBean.isSiteSpecific(connection, "OR","BILL_STATUS_DISPLAY");//19112
	isSiteSpecificNeonatalMotherSpecimen = eCommon.Common.CommonBean.isSiteSpecific(connection,"OR","NEONATAL_MOTHER_SPECIMEN");//31792
	if(isSiteSpecific)
	{
		barcodeSiteSpecificYN = "Y";
	}
	else
	{
		barcodeSiteSpecificYN = "N";
	}
	//IN063816 ends
	//IN065091 starts
	
	String BTColorYN = "";
	isSiteSpecificBTColor = eCommon.Common.CommonBean.isSiteSpecific(connection, "OR","BLOOD_ORDERS_ACK");
	if(isSiteSpecificBTColor){
		BTColorYN = "Y";
	}
	else{
		BTColorYN = "N";
	}
}
catch(Exception e){
	out.println("Exception@1: "+e);
}
finally
{
	if(connection!=null)	ConnectionManager.returnConnection(connection,request);
}
	//IN065091 ends
	// Get the date Sysdate  (IF Appointment is there, and start_date_time is less than sysdate, then have to pass the sysdate
	ArrayList sysdate = (ArrayList)bean.getSysDateTime(properties);
	for(int i=0;i<sysdate.size();i++){
		curr_sys_date	= (String)sysdate.get(0);
 	}
	//allValues		= bean.getSearchDetails(view,patientId,encntr_id,order_status,order_by,catalog,date_from,date_to,order_category,order_type,search_criteria,priority,view_by, activity_type, practitioner_type,elapsed_orders,sys_cancelled_orders,start,end,(String)session.getAttribute("responsibility_id"),(String)session.getAttribute("ca_practitioner_id"),pract_reln_id);
	allValues		= bean.getSearchDetails(view,patientId,encntr_id,order_status,order_by,catalog,date_from,date_to,order_category,order_type,search_criteria,priority,view_by, activity_type, practitioner_type,elapsed_orders,sys_cancelled_orders,start,end,(String)session.getAttribute("responsibility_id"),(String)session.getAttribute("ca_practitioner_id"),pract_reln_id,(String)session.getValue("login_user"));//IN072542
	if(allValues.size() == 0){
%>
		<script>
			alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));
			if(parent.parent.ExistingOrderSearch){
				parent.parent.ExistingOrderSearch.document.existing_order_search.search.disabled = false;
				//parent.parent.ExistingOrderHeader.location.href = "../../eCommon/html/blank.html"
				parent.parent.ExistingOrderResult.location.href = "../../eCommon/html/blank.html"
			}else if(parent.ExistingOrderSearch){
				parent.ExistingOrderSearch.document.existing_order_search.search.disabled = false;
				//parent.ExistingOrderHeader.location.href = "../../eCommon/html/blank.html"
				parent.ExistingOrderResult.location.href = "../../eCommon/html/blank.html"
			}

		</script>

<%	}
%>
<form name="existing_order_dtl" id="existing_order_dtl" action="../../eOR/jsp/ExistingOrderResults.jsp" method="post" >
<div id="divHeadSep" style="position: absolute;width:100%">
	<table cellpadding=3 cellspacing=0 border='0' width="100%" height='' id="tableresult" class="grid">
		<tr id="heading" style="text-align:left;">
		<%if (view_by.equals("L")) {%>
		<%if (called_from.equals(""))
		{%>
			<th  class='columnheader' width='' nowrap></th>
			<th  class='columnheader' width='' nowrap></th>
		<%
		//IN065091 Start
		if(isSiteSpecificBTColor)
		{
		%>
			<th  class='columnheader' width='' nowrap></th><!--IN065091-->
		<%
		}//IN065091 ends
		%>
	<%}%>
		<th class='columnheader' width='' nowrap><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></th>
		<th class='columnheader' width='' nowrap><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></th>
		<%} else {%>
		<%if (called_from.equals(""))
		{%>
			<th class='columnheader' width='' nowrap></th>
			<th  class='columnheader' width='' nowrap></th>
			
	<%}%>
        <th class='columnheader' width='' nowrap ><fmt:message key="eOR.OrderedAt.label" bundle="${or_labels}"/></th>
        <%}%>
		<th class='columnheader' width='' nowrap><fmt:message key="Common.priority.label" bundle="${common_labels}"/></th>
		<%if (view_by.equals("L")) {%>
		<th class='columnheader' width='' nowrap><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></th>
		<th class='columnheader' width='' nowrap><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></th>
		<%} else {%>
		<th class='columnheader' width='' nowrap><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></th>
		<th class='columnheader' width='' nowrap><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></th>
		<%}%>
		<th class='columnheader' width='' nowrap><fmt:message key="Common.OrderedBy.label" bundle="${common_labels}"/></th>
		<th class='columnheader' width='' nowrap><fmt:message key="Common.status.label" bundle="${common_labels}"/></th>
		
		<!-- Arvind -->

		<%if((order_category.equals("PH")|| order_category.equals(""))&&view_by.equals("L")){ %>
			<!--<td class='columnheader' width=''><fmt:message key="eCA.MedAdmindetails.label" bundle="${ca_labels}"/></td> --><!--IN038336-->
			<th class='columnheader' width=''><fmt:message key="eOR.MARStatus.label" bundle="${or_labels}"/></th><!--IN038336 -->
					
		<%}%>
		<!--IN063816 start-->
		<%
		if("L".equals(view_by) && "Y".equals(barcodeSiteSpecificYN))
		{
		%>
			<th class='columnheader' width=''><fmt:message key="eOR.BarcodePrint.label" bundle="${or_labels}"/></th>
		<%
		}
		%>
		<!--IN063816 ends-->
		<%
		//IN065942, starts
		if("L".equals(view_by))
		{
		%>
		
		<th class='columnheader' width='50'><fmt:message key="eOR.RegisterLabel.label" bundle="${or_labels}"/></th>
		<%
		}
		//IN065942, ends	
		//19112 Start.
		if(isSiteSpecificBillStatus && "L".equals(view_by)){
			%>		
			<th class='columnheader' width='' nowrap><fmt:message key="eOR.BillingStatus.label" bundle="${or_labels}"/></th>
			<%
		}
		//19112 End.
		%>

	<%if (called_from.equals("")){ if (!function_from.equals("MO")){ //[IN036674] %>
		<th class='columnheader' width='' nowrap><fmt:message key="Common.action.label" bundle="${common_labels}"/><BR><input type=checkbox name='select_all' id='select_all' onClick='clickAll()' disabled></th>
	<% }} %>
	</tr>
<%
	String slClassValue = "";
	String src_type = request.getParameter("source_type");
	if(src_type==null) src_type= "";

	String fontValue = "";

	String cont_order_ind = "";


	String[] existing_details = null;
	String can_reason = null;
	String consent_req_Yn = null;
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
	String bt_ack_YN = ""; //IN065091

	/*String line_menu_security1	= (String)bean.getMenu("CANCEL_ORDER",resp_id,pract_reln_id);
	String line_menu_security2	= (String)bean.getMenu("DISCONTINUE",resp_id,pract_reln_id);
	String menu_security1		= (String)bean.getMenu("AMEND_ORDER",resp_id,pract_reln_id);
	String menu_security_hold	= (String)bean.getMenu("HOLD",resp_id,pract_reln_id);
	String menu_security_resume = (String)bean.getMenu("RESUME",resp_id,pract_reln_id);*/
	String order_catalog_nature	= null;
	String display_appt_yn		= "N";
	String notify_yn			= "N";
	String [] colorString = {"X","X","X","X"};
	String color_string = "X,X,X,X";
	String appt_disabled = "";
	String allow_cancel_yn = "";

	StringTokenizer menu_options = null;
	int i = 0;
	//Added by Uma on 2/11/2010 for package billing
    String billing_package_ref = "";
	//	Added by Sridhar Reddy on 11/11/2008 for Displaytooltip
		StringBuffer strOrderCtl = new StringBuffer();		
	// end
	String lb_rslt_mod_status = ""; //HSA-CRF-0257.1 - IN055910 - Start
	String isResultModified = ""; //HSA-CRF-0257.1-02 IN058125	
	ArrayList specList = null; //HSA-CRF-0257.1-02 IN058125	
	for(int k=0; k<allValues.size(); k++){
		String billingStatus = ""; //19112
		if(strOrderCtl.length() > 0)
			strOrderCtl = strOrderCtl.delete(0,strOrderCtl.length());

		existing_details = (String[])allValues.get(k);
        if(existing_details[0] == null) existing_details[0] = "";
        if(existing_details[1] == null) existing_details[1] = "";
        if(existing_details[2] == null) existing_details[2] = "";
        if(existing_details[3] == null) existing_details[3] = "";
		//added by jayashree
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
		/*Added by Uma on 4/15/2010 for package billing*/
		
		if(view_by.trim().equals("H"))
		{
			if(existing_details[55] == null) existing_details[55] = "";
			if(existing_details[56] == null) existing_details[56] = "";
			if(existing_details[64] == null) existing_details[64] = "";//31792
			
		}
		/*Ends Here*/
		slClassValue="gridData";
		if(view_by.trim().equals("L"))
		{
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
			/*Added by Uma on 4/15/2010 for package billing*/
			if(existing_details[67] == null) existing_details[67] = "";
			if(existing_details[68] == null) existing_details[68] = "";
			if(existing_details[69] == null) existing_details[69] = "";
			/*Ends Here*/
			if(existing_details[71] == null) existing_details[71] = "";
			if(existing_details[72] == null) existing_details[72] = ""; //IN063816
			if(existing_details[73] == null) existing_details[73] = ""; //IN065091
			if(existing_details[74] == null) existing_details[74] = ""; //IN065942
			if(existing_details[75] == null) existing_details[75] = "";//IN64543
			if(existing_details[76] == null) existing_details[76] = ""; //IN061961
			
			if(existing_details[79] == null) existing_details[79] = ""; //19112
			if(existing_details[81] == null) existing_details[81] = ""; //31792
			if(existing_details[82] == null) existing_details[82] = ""; //ML-MMOH-CRF-1617.1
			if(existing_details[83] == null) existing_details[83] = ""; //ML-MMOH-CRF-1617.1
			if(existing_details[84] == null) existing_details[84] = ""; //ML-MMOH-CRF-1617.1
			
			//IN066709 Starts	
			if(resp_id.equals("MO") && ("Y".equals(existing_details[60]))){
				cnsnt_with_order_yn="Y";
			}
			//IN066709 Ends	
			
			menu_options			= new StringTokenizer(existing_details[15],"|");
			
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
				/*Added by Uma on 2/11/2010 for CRF 712 package billing*/
				existing_details[68] = menu_options.nextToken();  //REPLACE FOR PACKAGE BILLING
				/*Ends Here*/
				existing_details[65] = menu_options.nextToken();  //VIEW_REPLACED_ORDER
				existing_details[66] = menu_options.nextToken();  //VIEW_ORIGINAL_ORDER				
				
			}
			
			//IN063781 starts
			if("PF".equals(existing_details[14]) && !("RD".equals(existing_details[0]) && "Y".equals(existing_details[17])))
			{
				existing_details[17] = "N";
			}
			//IN063781 ends
			cont_order_ind			= existing_details[21];
			color_string			= existing_details[36];
			can_reason				= existing_details[37];
			can_pract_id			= existing_details[38];
			can_date_time			= existing_details[39];
			disc_pract_id			= existing_details[40];
			disc_date_time			= existing_details[41];
			//hold_pract_id			= existing_details[42];
			//hold_date_time			= existing_details[43];
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
			//Added by Uma on 2/11/2010 for package billing CRF 712*/
			billing_package_ref		= existing_details[67];
			bt_ack_YN				= existing_details[73];//IN065091
			if(existing_details[64] == null || existing_details.equals("")) existing_details[64] = "";					 
			//IN068986 Start.
			/*if(existing_details[77] != null)//IN061961
				total_query_records		= existing_details[77];//IN061961 */
			/* if(existing_details[78] != null)//IN061961
				total_query_records		= existing_details[78];//IN061961 IN073562*/
			//IN068986 Ends.
			//19112 Start.
			//if(existing_details[79] != null)//IN073562
			//total_query_records		= existing_details[79];//IN073562
			if("B".equals(existing_details[79]))
				billingStatus	= "Billed&nbsp;<img src='../../eOR/images/Billed.png' border='0'  title='Billed'/>";
			else if("U".equals(existing_details[79]))
				billingStatus	= "Unbilled&nbsp;<img src='../../eOR/images/Unbilled.png' border='0'  title='Unbilled'/>";
			else
				billingStatus	=existing_details[79];
			
			if("DC".equals(existing_details[14]) || "CN".equals(existing_details[14]) )
				billingStatus="";
			if(existing_details[80] != null)//IN073562
			total_query_records		= existing_details[80];//IN073562
			
			lv_neonate_spec_yn =existing_details[81];//31792
			Appt_can_reason=existing_details[82];//ML-MMOH-CRF-1617.1
			Appt_can_remarks=existing_details[83];//ML-MMOH-CRF-1617.1
			Appt_resched_remarks=existing_details[84];//ML-MMOH-CRF-1617.1
			
			//19112 End.
		} 
		else 
		{
			if(existing_details[25] == null || existing_details.equals("")) existing_details[25] = "X,X,X,X";
			if(existing_details[46] == null || existing_details.equals("")) existing_details[46] = "N";
			if(existing_details[49] == null || existing_details.equals("")) existing_details[49] = "0";
			if(existing_details[50] == null || existing_details.equals("")) existing_details[50] = "";
			if(existing_details[51] == null || existing_details.equals("")) existing_details[51] = "";			
			if(existing_details[52] == null || existing_details.equals("")) existing_details[52] = "";			
			if(existing_details[53] == null || existing_details.equals("")) existing_details[53] = "";			
			if(existing_details[54] == null || existing_details.equals("")) existing_details[54] = "";	
			if(existing_details[62] == null || existing_details.equals("")) existing_details[62] = "";//IN066414
			if(existing_details[63] == null || existing_details.equals("")) existing_details[63] = "";//IN067817
			color_string			= existing_details[25];

			menu_options			= new StringTokenizer(existing_details[12],"|");
							
			if(menu_options.hasMoreTokens())
			{
				existing_details[12] =	menu_options.nextToken();  //AMEND_CANCEL
				allow_cancel_yn= menu_options.nextToken();    // CANCEL_ORDER Added by Sridhar for MO-CRF-0033
				existing_details[15] =	menu_options.nextToken();  //DISCONTINUE 
				existing_details[20] =	menu_options.nextToken();  //HOLD 
				existing_details[21] =	menu_options.nextToken();  //RESUME 
				existing_details[23] =	menu_options.nextToken();  //RENEW 
				existing_details[14] =	menu_options.nextToken();  //RESULT_HYPER_LINK 
				existing_details[52] =  menu_options.nextToken();  //LINK_TO_CURRENT_ENCOUNTER  
				/*Added by Uma on 2/11/2010 for CRF 712 package billing*/
				existing_details[56] =  menu_options.nextToken();  //REPLACE FOR PACKAGE BILLING
				/*Ends Here*/
				existing_details[53] =  menu_options.nextToken();  //VIEW_REPLACED_ORDER  
				existing_details[54] =  menu_options.nextToken();  //VIEW_ORIGINAL_ORDER  
				
			}
			// Start of lines to be commented
			can_reason				= existing_details[26];
			can_pract_id			= existing_details[27];
			can_date_time			= existing_details[28];
			disc_pract_id			= existing_details[29];
			disc_date_time			= existing_details[30];
			//hold_pract_id			= existing_details[31];
			//hold_date_time			= existing_details[32];
			last_action_reason_desc	= existing_details[33];	
			appt_date				= existing_details[34];
			appt_ref_num			= existing_details[35];
			order_catalog_nature	= existing_details[36];
			sec_order_yn			= existing_details[37];
			pri_order_id			= existing_details[38];

			appt_locn				= existing_details[39];
			appt_resched_yn			= existing_details[40];
			appt_resched_reason		= existing_details[41];
			no_of_reschedules		= existing_details[42];
			appt_reqd_yn			= existing_details[43];
			notify_yn				= existing_details[46];
			display_appt_yn			= existing_details[12];  //display_popupmen

			last_action_type		= existing_details[47];
			accession_num			= existing_details[48];
			consent_req_Yn			= existing_details[50];
			/*Added by Uma on 2/11/2010 for package billing CRF 712*/
			billing_package_ref			= existing_details[55];
			
			// end of lines to be commented
			if(existing_details[58] != null)//Menaka
				total_query_records		= bean.checkForNull(existing_details[58],"0");//Menaka
				
			//IN063781 starts
			if("PF".equals(existing_details[13]) && !("RD".equals(existing_details[0]) && "Y".equals(existing_details[14])))
			{
				existing_details[14] = "N";
			}
			//IN063781 ends
			lv_neonate_spec_yn=existing_details[64];//31792
	}

		//HSA-CRF-0257.1 - IN055910 - Start 
		if(existing_details[0].equals("LB")) {
			//isResultModified = bean.getResultStatFromStatusAppl(view_by, existing_details[9], existing_details[11]); //HSA-CRF-0257.1-02 [IN058125]  // commented for PERF ISSUE - Karthi
			isResultModified = bean.getResultStatFromStatusAppl(view_by, existing_details[9], existing_details[11], patientId); // modified for PERF ISSUE - Karthi
			if(isResultModified == null) isResultModified = ""; //HSA-CRF-0257.1-02 [IN058125]
			if("Y".equals(isResultModified)) { //AAKH-SCF-0252
				//specList = bean.getIntervalTestSpecNos(existing_details[9]); // commented for PERF ISSUE - Karthi
				specList = bean.getIntervalTestSpecNos(existing_details[9], patientId); // modified for PERF ISSUE - Karthi
				if(specList != null && specList.size()>1){
					//lb_rslt_mod_status = bean.getLBModStatForIntTest(specList);	// commented for PERF ISSUE - Karthi
					lb_rslt_mod_status = bean.getLBModStatForIntTest(specList, patientId);	// modified for PERF ISSUE - Karthi
				}
				else {
					//lb_rslt_mod_status =  bean.getLabOrderStatusBySpecNo(accession_num, view_by, existing_details[12]);	// commented for PERF ISSUE - Karthi
					lb_rslt_mod_status =  bean.getLabOrderStatusBySpecNo(accession_num, view_by, existing_details[12], patientId);	// modified for PERF ISSUE - Karthi
				}
				if(lb_rslt_mod_status == null) lb_rslt_mod_status ="";
			}	//AAKH-SCF-0252
			//isResultModified = bean.getResultStatFromStatusAppl(view_by, existing_details[9], existing_details[11]); //HSA-CRF-0257.1-02 [IN058125] - AAKH-SCF-0252
			//if(isResultModified == null) isResultModified = ""; //HSA-CRF-0257.1-02 [IN058125] - AAKH-SCF-0252
		}
		//HSA-CRF-0257.1 - IN055910 - End
	if(k==0) { 
%>		
	<%if((Integer.parseInt(total_query_records)>0) || (start>1)){%>
	<tr align="right">
	<!--IN063816 start-->
	<%
	if("L".equals(view_by) && "Y".equals(barcodeSiteSpecificYN))
	{
		//IN065091 start
		if("L".equals(view_by) && isSiteSpecificBTColor){
		%>
			<!--<td colspan="13">--><!--IN065942-->
			<td colspan="14"><!--IN065942-->
		<%
		}else{
	%>
		<!--<td colspan="12">--><!--IN065942-->
		<td colspan="13"><!--IN065942-->
	<%
		}
	}else if("L".equals(view_by) && isSiteSpecificBTColor){	
	%>
		<!--<td colspan="12">--><!--IN065942-->
		<td colspan="13"><!--IN065942-->
	<%}
	else{
	%>
	<!--IN063816 ends-->
		<!--<td colspan="11">--><!--IN065942-->
		<td colspan="12"><!--IN065942-->
	<%}%>
			<jsp:include page="ResultScrolling.jsp" ><jsp:param name="flush" value="true" />
			<jsp:param name ="from" value= "<%=start%>" /> 
			<jsp:param name ="to" value= "<%=end%>" />	
			<jsp:param name ="total_size" value= "<%=total_query_records%>" />   
			<jsp:param name ="check_box_name" value= "chk" />					 
			<jsp:param name ="form_name" value= "existing_order_dtl" />  
			</jsp:include>
		</td>
	</tr>
	<%}%>
<%		}  

	if(!existing_details[0].equals(old_category) && order_by.equals("O")) 
	{ 
	%>
		<tr>

			<td <%if(view_by.trim().equals("L")){ out.println("colspan='12'"); } else{ out.println("colspan='11'"); } %> class="CAHIGHERLEVELCOLOR"> <%=existing_details[1]%>
		
			</td>
		</tr>
<% } 
%>
	<tr>
	<%//if(view_by.trim().equals("L")){

			
//        if (existing_details[9].equals("PH"))
{
           //  color_string = bean.getColorCodings(facility_id,existing_details[9],existing_details[12],existing_details[11]);
            StringTokenizer colorTokenizer = new StringTokenizer(color_string,",");
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
 					/*{if(order_status.equals("A"))
						colorString[index] = "QRY1";
					if(order_status.equals("F"))
						colorString[index] = "QRY7"; 
					if(order_status.equals("P"))
						colorString[index] = "QRY5"; 
					if(order_status.equals("D"))
						colorString[index] = "QRY2"; }*/
				index++;
            }  
        }
	  %>
	   <!-- For Header and Line Level --> <!-- For Color -->
	   <td width='' nowrap class='<%=((colorString[0].equals("X"))?slClassValue:colorString[0])%>'></td>
	  <% if(view_by.trim().equals("L")){
		   %>
	   <td width='' nowrap  class='<%=((colorString[2].equals("X"))?slClassValue:colorString[2])%>'>
	   <%
		if(sec_order_yn.equals("Y"))// && pri_order_id.equals(""))
		 {
		%>
			<a class='gridLink' href='javascript: dummy()' onClick="showSecondayOrders('<%=i%>','<%=existing_details[9]%>')"><img src='../../eOR/images/SecondaryOrder.gif' border='0'  title='Secondary Orders Exists'></img></a>
		<%
		 }
		if(!(existing_details[61].equals("")))
		{
			order_set_expln_txt=bean.getMessage(localeName,"ORDER_SET_EXPLN_TEXT","OR");
			if(!(view_by.trim().equals("L")))
			{
		%>
				<a class='gridLink' href='javascript: dummy()' onClick="showCareSetResults('<%=existing_details[61]%>')"  onMouseOver='showToolTip("<%=existing_details[9]%>","existing_order_dtl")' onMouseOut="hideToolTip()">S</a>
		<%}else
			{%>
				<a class='gridLink' href='javascript: dummy()' onClick="showCareSetResults('<%=existing_details[61]%>')"  onMouseOver='showToolTip("<%=existing_details[9]%><%=existing_details[11]%>","existing_order_dtl")' onMouseOut="hideToolTip()">S</a>
		<%}
		}
		%></td>
		<%
		//IN065091 start
		if(isSiteSpecificBTColor){
			if("Y".equals(bt_ack_YN)){
			%>
				<td width='' nowrap  class='QRY11'></td><!--IN065091-->
			<%
			}
			else
			{
			%>
				<td width='' nowrap  class = '<%=slClassValue%>'></td><!--IN065091-->
			<%	
			}
		}
		//IN065091 ends
	}
	else
	{
		%>
		<td width='' nowrap class='<%=((colorString[2].equals("X"))?slClassValue:colorString[2])%>'>
		<%
		
		if(sec_order_yn.equals("Y")) //&& pri_order_id.equals(""))
		{ %><a class='gridLink' href='javascript: dummy()' onClick="showSecondayOrders('<%=i%>','<%=existing_details[9]%>')"><img src='../../eOR/images/SecondaryOrder.gif' border='0'  title='Secondary Orders Exists'></img></a>
<%}
	if(!(existing_details[51].equals("")))
	{
		order_set_expln_txt=bean.getMessage(localeName,"ORDER_SET_EXPLN_TEXT","OR");
%>
		<a class='gridLink' href='javascript: dummy()' onClick="showCareSetResults('<%=existing_details[51]%>')"  onMouseOver='showToolTip("<%=existing_details[9]%>","existing_order_dtl")' onMouseOut="hideToolTip()">S</a>
<%
	}%></td>
	
<%}
		if(view_by.trim().equals("L")){

			//out.println("<script>alert('"+existing_details[7]+"')</script>");
		  // System.err.println("INTEH L"+view_by.trim());
%>

	
	<td width='' nowrap class='<%=slClassValue%>'> <%=com.ehis.util.DateUtils.convertDate(existing_details[27],"DMYHM","en",localeName)%></td>
	<td width='' nowrap class='<%=slClassValue%>'> <%if(!(existing_details[4].equalsIgnoreCase("MS")&&existing_details[0].equalsIgnoreCase("PH"))){out.println(com.ehis.util.DateUtils.convertDate(existing_details[28],"DMYHM","en",localeName));}%></td>
	<%} else {%>
		<td width='' nowrap class='<%=slClassValue%>'> <%=com.ehis.util.DateUtils.convertDate(existing_details[7],"DMYHM","en",localeName)%></td>
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
			//if(existing_details[11] == null) existing_details[11] = "";
			//if(existing_details[12] == null) existing_details[12] = "";
			//if(existing_details[13] == null) existing_details[13] = "";
			//if(existing_details[24] == null) existing_details[24] = "";
        	//if(existing_details[25] == null) existing_details[25] = "";
        	//if(existing_details[26] == null) existing_details[26] = "N";
        	//if(existing_details[27] == null) existing_details[27] = "";
        	//if(existing_details[28] == null) existing_details[28] = "";
			//cont_order_ind = existing_details[21];
		
 		%>
			<input type='hidden' name='line_num<%=i%>' id='line_num<%=i%>' value="<%=existing_details[11]%>">
			<input type='hidden' name='start_date_time<%=i%>' id='start_date_time<%=i%>' value="<%=existing_details[27]%>">
			<input type='hidden' name='catalog_code<%=i%>' id='catalog_code<%=i%>' value="<%=existing_details[12]%>">
			<input type='hidden' name='item_narration<%=i%>' id='item_narration<%=i%>' value="<%=existing_details[13]%>">
			<input type='hidden' name='location_code<%=i%>' id='location_code<%=i%>' value="<%=existing_details[19]%>">
			<input type='hidden' name='patient_class<%=i%>' id='patient_class<%=i%>' value="<%=existing_details[20]%>">
			<input type='hidden' name='cont_order_ind<%=i%>' id='cont_order_ind<%=i%>' value="<%=cont_order_ind%>">
			<input type='hidden' name='copy_yn<%=i%>' id='copy_yn<%=i%>' value="<%=existing_details[30]%>">
			<input type='hidden' name='source_type<%=i%>' id='source_type<%=i%>' value="<%=existing_details[18]%>">
			<input type='hidden' name='lv_neonate_spec_yn<%=i%>' id='lv_neonate_spec_yn<%=i%>' value="<%=existing_details[81]%>"><!-- 31792 -->
			
		<%}else{
			cont_order_ind = existing_details[19];
		%>
			<input type='hidden' name='catalog_code<%=i%>' id='catalog_code<%=i%>' value="<%=existing_details[45]%>">
			<input type='hidden' name='start_date_time<%=i%>' id='start_date_time<%=i%>' value="<%=existing_details[44]%>">
			<input type='hidden' name='location_code<%=i%>' id='location_code<%=i%>' value="<%=existing_details[17]%>">
			<input type='hidden' name='patient_class<%=i%>' id='patient_class<%=i%>' value="<%=existing_details[18]%>">
			<input type='hidden' name='cont_order_ind<%=i%>' id='cont_order_ind<%=i%>' value="<%=cont_order_ind%>">
            <input type='hidden' name='copy_yn<%=i%>' id='copy_yn<%=i%>' value="<%=existing_details[24]%>">
            <input type='hidden' name='source_type<%=i%>' id='source_type<%=i%>' value="<%=existing_details[16]%>">
            <%--IN066414 starts--%>
<%-- 			<input type='hidden' name='item_narration<%=i%>' id='item_narration<%=i%>' value="<%=existing_details[13]%>"> --%>
			<input type='hidden' name='item_narration<%=i%>' id='item_narration<%=i%>' value="<%=existing_details[62]%>">
			<%--IN066414 ends--%>
			<input type='hidden' name='line_num<%=i%>' id='line_num<%=i%>' value="<%=existing_details[11]%>"><!-- IN068659 -->
		<%


		  }%>
		    <input type='hidden' name='order_category<%=i%>' id='order_category<%=i%>' value="<%=existing_details[0]%>">
			<input type='hidden' name='ord_typ_code<%=i%>' id='ord_typ_code<%=i%>' value="<%=existing_details[4]%>">
			<input type='hidden' name='ord_typ_desc<%=i%>' id='ord_typ_desc<%=i%>' value="<%=existing_details[8]%>">
			<input type='hidden' name='ord_id<%=i%>' id='ord_id<%=i%>' value="<%=existing_details[9]%>">
			
	
	<%	
			
		
		if((view_by.trim()).equals("H")) 
		{					
			%>
			 <input type='hidden' name='lv_neonate_spec_yn<%=i%>' id='lv_neonate_spec_yn<%=i%>' value="<%=existing_details[64]%>"><!-- 31792 -->
			<td width='' nowrap class='<%=slClassValue%>'> <%=existing_details[8]%></td>
			<!-- <td width='' class='gridDataBlue'>  -->
			<%
					strOrderCtl.append("<td width='' nowrap id='orderctl"+i+"' style='cursor:pointer' class='gridDataBlue' ");
					//existing_details[23] = "Y";
					

					if (existing_details[22]==null)existing_details[22] = "";
					if (existing_details[23].equals("")) existing_details[23] = "N";
					/*if(existing_details[9]!=null){
					order_catalog_nature=bean.checkForNull(bean.getCatalogNature(existing_details[9].trim()));	
					}*/
			
					if((existing_details[9]!=null && (existing_details[9].trim().substring(0,2)).equals("CS")) || (order_catalog_nature!=null && order_catalog_nature.equals("S")) ) 
					{ // only care set (order set) orders
				
						strOrderCtl.append(" onClick=\"showCareSetResults('"+existing_details[9]+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
						
					}
					else  // For other categories Normal 
					{
						if((existing_details[12].trim().equals("Y") && allow_cancel_yn.trim().equals("Y"))&&((existing_details[0].equalsIgnoreCase("PH"))&&(existing_details[4].equalsIgnoreCase("MS")||existing_details[22].equalsIgnoreCase("6"))||(!(existing_details[55].equalsIgnoreCase("")))))
						{

							strOrderCtl.append("  onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',"+((allow_cancel_yn.trim().equals("Y"))?"'+getLabel('Common.cancel.label','Common')+'":"")+",,,,,"+((existing_details[52].trim().equals("Y"))?"'+getLabel('eOR.Linktocurrentencounter.label','OR')+'":"")+","+((existing_details[53].trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((existing_details[54].trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+","+((existing_details[23].trim().equals("Y"))? "'+getLabel('eOR.Renew.label','OR')+'" : "")+",','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','"+patientId+"','"+encounter_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+cont_order_ind+"','"+existing_details[13]+"','"+existing_details[22]+"','"+existing_details[4]+"','"+existing_details[45]+"','"+episode_id+"','"+episode_visit_num+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
						
						}else if((existing_details[12].trim().equals("Y") && allow_cancel_yn.trim().equals("N"))&&((existing_details[0].equalsIgnoreCase("PH"))&&(existing_details[4].equalsIgnoreCase("MS")||(existing_details[22].equalsIgnoreCase("6")))||(!(existing_details[55].equalsIgnoreCase("")))))
						{
							strOrderCtl.append("  onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',,,"+((existing_details[15].trim().equals("Y"))?"'+getLabel('Common.Discontinue.label','Common')+'":"")+",,,"+((existing_details[52].trim().equals("Y"))?"'+getLabel('eOR.Linktocurrentencounter.label','OR')+'":"")+","+((existing_details[53].trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((existing_details[54].trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+","+((existing_details[23].trim().equals("Y"))? "'+getLabel('eOR.Renew.label','OR')+'" : "")+",','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','"+patientId+"','"+encounter_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+cont_order_ind+"','"+existing_details[13]+"','"+existing_details[22]+"','"+existing_details[4]+"','"+existing_details[45]+"','"+episode_id+"','"+episode_visit_num+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
							
						}
						else
						{
							strOrderCtl.append("  onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',"+((allow_cancel_yn.trim().equals("Y"))?"'+getLabel('Common.cancel.label','Common')+'":"")+","+((existing_details[12].trim().equals("Y"))?"'+getLabel('Common.Amend.label','Common')+'":"")+","+((existing_details[15].trim().equals("Y"))?"'+getLabel('Common.Discontinue.label','Common')+'":"")+","+((existing_details[20].trim().equals("Y"))?"'+getLabel('Common.Hold.label','Common')+'":"")+","+((existing_details[21].trim().equals("Y"))?"'+getLabel('eOR.Resume.label','OR')+'":"")+","+((existing_details[52].trim().equals("Y"))?"'+getLabel('eOR.Linktocurrentencounter.label','OR')+'":"")+","+((existing_details[53].trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((existing_details[54].trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+","+((existing_details[23].trim().equals("Y"))? "'+getLabel('eOR.Renew.label','OR')+'" : "")+",','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','"+patientId+"','"+encounter_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+cont_order_ind+"','"+existing_details[13]+"','"+existing_details[22]+"','"+existing_details[4]+"','"+existing_details[45]+"','"+episode_id+"','"+episode_visit_num+"',this,'imgArrow"+i+"','"+existing_order_called_from_new+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");//IN072654//Added existing_order_called_from_new for IN074110
							//strOrderCtl.append("  onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',"+((allow_cancel_yn.trim().equals("Y"))?"'+getLabel('Common.cancel.label','Common')+'":"")+","+((existing_details[12].trim().equals("Y"))?"'+getLabel('Common.Amend.label','Common')+'":"")+","+((existing_details[15].trim().equals("Y"))?"'+getLabel('Common.Discontinue.label','Common')+'":"")+","+((existing_details[20].trim().equals("Y"))?"'+getLabel('Common.Hold.label','Common')+'":"")+","+((existing_details[21].trim().equals("Y"))?"'+getLabel('eOR.Resume.label','OR')+'":"")+","+((existing_details[52].trim().equals("Y"))?"'+getLabel('eOR.Linktocurrentencounter.label','OR')+'":"")+","+((existing_details[53].trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((existing_details[54].trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+","+((existing_details[23].trim().equals("Y"))? "'+getLabel('eOR.Renew.label','OR')+'" : "")+","+((null!=existing_details[64] && Integer.valueOf(existing_details[64]) > 0)? "'+getLabel('eOR.InteractionDtls.label','OR')+'" : "")+",','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','"+patientId+"','"+encounter_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+cont_order_ind+"','"+existing_details[13]+"','"+existing_details[22]+"','"+existing_details[4]+"','"+existing_details[45]+"','"+episode_id+"','"+episode_visit_num+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");//IN072654
							
						}			
		} // else of the order_category 'CS'
			//	out.println("<a href='javascript: dummy()' onClick=\"displayToolTip('View,,,Discontinue,,,','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"')\"  onMouseOver='hideToolTip()'>");

	%>
	
	<%	}	
	else if((view_by.trim()).equals("L")) {
		if(ext_appl_accession_num != null && !ext_appl_accession_num.equals(""))
			accession_num_tooltip = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ExternalApplicationAccessionNo.label","or_labels")+" "+ext_appl_accession_num;
		else
			accession_num_tooltip = "";
		
		%>

	<td width='' nowrap class='<%=slClassValue%>'> <%=existing_details[8]%></td>
	<!-- <td width='' class='<%=slClassValue%>'>  --> 

<%		
		strOrderCtl.append("<td width='' nowrap id='orderctl"+i+"' style='cursor:pointer' title='"+accession_num_tooltip+"' class='gridDataBlue'");
		if(existing_details[9]!=null && (existing_details[9].trim().substring(0,2)).equals("CS")) 
		{ // only care set (order set) orders
			
 				strOrderCtl.append("onClick=\"showCareSetResults('"+existing_details[9]+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
				
		}
		else 
		{ // For other categories normal one

					if(((existing_details[0].equalsIgnoreCase("PH"))&&((existing_details[4].equalsIgnoreCase("MS"))||(existing_details[25].equalsIgnoreCase("6"))))||(!(existing_details[67].equalsIgnoreCase(""))))
					{
							//strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',"+((allow_cancel_yn.trim().equals("Y"))?"'+getLabel('Common.cancel.label','Common')+'":"")+",,'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,,,,"+((existing_details[63].trim().equals("Y"))?"'+getLabel('eOR.Linktocurrentencounter.label','OR')+'":"")+","+((existing_details[68].trim().equals("Y"))?"'+getLabel('eOR.Replace.label','OR')+'":"")+","+((existing_details[65].trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((existing_details[66].trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+","+((existing_details[23].trim().equals("Y"))? "'+getLabel('eOR.Renew.label','OR')+'" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"','"+existing_details[4]+"','"+episode_id+"','"+episode_visit_num+"',this,'imgArrow"+i+"')\" onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
							//strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',"+((allow_cancel_yn.trim().equals("Y"))?"'+getLabel('Common.cancel.label','Common')+'":"")+",,'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,,,,"+((existing_details[63].trim().equals("Y"))?"'+getLabel('eOR.Linktocurrentencounter.label','OR')+'":"")+","+((existing_details[68].trim().equals("Y"))?"'+getLabel('eOR.Replace.label','OR')+'":"")+","+((existing_details[65].trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((existing_details[66].trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+","+((existing_details[26].trim().equals("Y"))? "'+getLabel('eOR.Renew.label','OR')+'" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"','"+existing_details[4]+"','"+episode_id+"','"+episode_visit_num+"',this,'imgArrow"+i+"')\" onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">"); //IN042100//IN64543
							strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',"+((allow_cancel_yn.trim().equals("Y"))?"'+getLabel('Common.cancel.label','Common')+'":"")+",,'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,,,,"+((existing_details[63].trim().equals("Y"))?"'+getLabel('eOR.Linktocurrentencounter.label','OR')+'":"")+","+((existing_details[68].trim().equals("Y"))?"'+getLabel('eOR.Replace.label','OR')+'":"")+","+((existing_details[65].trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((existing_details[66].trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+","+((existing_details[26].trim().equals("Y"))? "'+getLabel('eOR.Renew.label','OR')+'" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"','"+existing_details[4]+"','"+episode_id+"','"+episode_visit_num+"',this,'imgArrow"+i+"')\" onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"','"+existing_details[75]+"')\">"); //IN042100//IN64543
							
					}else
					{	
							//strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',"+((allow_cancel_yn.trim().equals("Y"))?"'+getLabel('Common.cancel.label','Common')+'":"")+","+((existing_details[15].trim().equals("Y"))?"'+getLabel('Common.Amend.label','Common')+'":"")+",'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,"+((existing_details[16].trim().equals("Y"))?"'+getLabel('Common.Discontinue.label','Common')+'":"")+","+((existing_details[22].trim().equals("Y"))?"'+getLabel('Common.Hold.label','Common')+'":"")+","+((existing_details[23].trim().equals("Y"))?"'+getLabel('eOR.Resume.label','OR')+'":"")+","+((existing_details[63].trim().equals("Y"))?"'+getLabel('eOR.Linktocurrentencounter.label','OR')+'":"")+","+((existing_details[68].trim().equals("Y"))?"'+getLabel('eOR.Replace.label','OR')+'":"")+","+((existing_details[65].trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((existing_details[66].trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+","+((existing_details[23].trim().equals("Y"))? "'+getLabel('eOR.Renew.label','OR')+'" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"','"+existing_details[4]+"','"+episode_id+"','"+episode_visit_num+"',this,'imgArrow"+i+"')\" onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
							//strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',"+((allow_cancel_yn.trim().equals("Y"))?"'+getLabel('Common.cancel.label','Common')+'":"")+","+((existing_details[15].trim().equals("Y"))?"'+getLabel('Common.Amend.label','Common')+'":"")+",'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,"+((existing_details[16].trim().equals("Y"))?"'+getLabel('Common.Discontinue.label','Common')+'":"")+","+((existing_details[22].trim().equals("Y"))?"'+getLabel('Common.Hold.label','Common')+'":"")+","+((existing_details[23].trim().equals("Y"))?"'+getLabel('eOR.Resume.label','OR')+'":"")+","+((existing_details[63].trim().equals("Y"))?"'+getLabel('eOR.Linktocurrentencounter.label','OR')+'":"")+","+((existing_details[68].trim().equals("Y"))?"'+getLabel('eOR.Replace.label','OR')+'":"")+","+((existing_details[65].trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((existing_details[66].trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+","+((existing_details[26].trim().equals("Y"))? "'+getLabel('eOR.Renew.label','OR')+'" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"','"+existing_details[4]+"','"+episode_id+"','"+episode_visit_num+"',this,'imgArrow"+i+"')\" onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");//IN042100
							//strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',"+((allow_cancel_yn.trim().equals("Y"))?"'+getLabel('Common.cancel.label','Common')+'":"")+","+((existing_details[15].trim().equals("Y"))?"'+getLabel('Common.Amend.label','Common')+'":"")+",'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,"+((existing_details[16].trim().equals("Y"))?"'+getLabel('Common.Discontinue.label','Common')+'":"")+","+((existing_details[22].trim().equals("Y"))?"'+getLabel('Common.Hold.label','Common')+'":"")+","+((existing_details[23].trim().equals("Y"))?"'+getLabel('eOR.Resume.label','OR')+'":"")+","+((existing_details[63].trim().equals("Y"))?"'+getLabel('eOR.Linktocurrentencounter.label','OR')+'":"")+","+((existing_details[68].trim().equals("Y"))?"'+getLabel('eOR.Replace.label','OR')+'":"")+","+((existing_details[65].trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((existing_details[66].trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+","+((existing_details[26].trim().equals("Y"))? "'+getLabel('eOR.Renew.label','OR')+'" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"','"+existing_details[4]+"','"+episode_id+"','"+episode_visit_num+"',this,'imgArrow"+i+"','"+existing_details[75]+"')\" onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");//IN64543
						//strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',"+((allow_cancel_yn.trim().equals("Y"))?"'+getLabel('Common.cancel.label','Common')+'":"")+","+((existing_details[15].trim().equals("Y"))?"'+getLabel('Common.Amend.label','Common')+'":"")+",'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,"+((existing_details[16].trim().equals("Y"))?"'+getLabel('Common.Discontinue.label','Common')+'":"")+","+((existing_details[22].trim().equals("Y"))?"'+getLabel('Common.Hold.label','Common')+'":"")+","+((existing_details[23].trim().equals("Y"))?"'+getLabel('eOR.Resume.label','OR')+'":"")+","+((existing_details[63].trim().equals("Y"))?"'+getLabel('eOR.Linktocurrentencounter.label','OR')+'":"")+","+((existing_details[68].trim().equals("Y"))?"'+getLabel('eOR.Replace.label','OR')+'":"")+","+((existing_details[65].trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((existing_details[66].trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+","+((existing_details[26].trim().equals("Y"))? "'+getLabel('eOR.Renew.label','OR')+'" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"','"+existing_details[4]+"','"+episode_id+"','"+episode_visit_num+"',this,'imgArrow"+i+"','"+existing_details[75]+"','"+view_by+"')\" onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");//IN061961//IN072654
					
						strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',"+((allow_cancel_yn.trim().equals("Y"))?"'+getLabel('Common.cancel.label','Common')+'":"")+","+((existing_details[15].trim().equals("Y"))?"'+getLabel('Common.Amend.label','Common')+'":"")+",'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,"+((existing_details[16].trim().equals("Y"))?"'+getLabel('Common.Discontinue.label','Common')+'":"")+","+((existing_details[22].trim().equals("Y"))?"'+getLabel('Common.Hold.label','Common')+'":"")+","+((existing_details[23].trim().equals("Y"))?"'+getLabel('eOR.Resume.label','OR')+'":"")+","+((existing_details[63].trim().equals("Y"))?"'+getLabel('eOR.Linktocurrentencounter.label','OR')+'":"")+","+((existing_details[68].trim().equals("Y"))?"'+getLabel('eOR.Replace.label','OR')+'":"")+","+((existing_details[65].trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((existing_details[66].trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+","+((existing_details[26].trim().equals("Y"))? "'+getLabel('eOR.Renew.label','OR')+'" : "")+","+((!"EXTERNAL_ORDER".equals(existing_order_called_from_new) && null!=existing_details[78] && Integer.valueOf(existing_details[78]) > 0)? "'+getLabel('eOR.InteractionDtls.label','OR')+'" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"','"+existing_details[4]+"','"+episode_id+"','"+episode_visit_num+"',this,'imgArrow"+i+"','"+existing_details[75]+"','"+view_by+"','"+existing_order_called_from_new+"')\" onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");//IN061961//IN072654//IN073565//Added existing_order_called_from_new for IN074110
						
						}
		}
		/*if(existing_details[0].equals("PH"))
		{
		String tradename=bean.checkForNull(bean.getTradeName(existing_details[9],existing_details[11]),"");
		if(!tradename.equals("**"))
		existing_details[3]=existing_details[3]+"["+tradename+"]";
		}*/
	} // End of else category 'CS'
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
		//if(existing_details[0].equalsIgnoreCase("PH"))
		//strOrderCtl.append("<input type='button' value='SS' onclick=showSlidingDetails('PHOP00000068461')>");  //used for the sliding scale function(new CRF)
		
		strOrderCtl.append(existing_details[3]);
		if(notify_yn!=null && notify_yn.equals("Y")) {
			strOrderCtl.append("<img height='15' width='15' src=\"../images/Alert.gif\">");
		} 
		//IN029948 Starts
		
		if( (view_by.trim()).equals("L") && existing_details[0].equalsIgnoreCase("PH") && "Y".equals(existing_details[70]))
		{
			strOrderCtl.append("<a href='javascript: dummy()' onClick=\"showDetailsPH('"+patient_id+"','"+existing_details[9]+"','"+existing_details[11]+"','"+existing_details[14]+"')\">");
			strOrderCtl.append("<img width='20' height='20' src='../../ePH/images/altenate.jpg'/>");
			strOrderCtl.append("</a>");				
		} 
			//IN029948 Ends
		//31792 starts
		if((view_by.trim()).equals("L") && isSiteSpecificNeonatalMotherSpecimen && lv_neonate_spec_yn.equals("Y")){					
			strOrderCtl.append("&nbsp;&nbsp;<img style='cursor:pointer;' src='../../eCA/images/MotherBlood.png' onClick=\"NeonatalMotherSpecimenDetails1('"+existing_details[9]+"','"+existing_details[11]+"','"+existing_details[0]+"','"+existing_details[62]+"','"+existing_details[57]+"',null,null)\">");
		}else if ((view_by.trim()).equals("H") && isSiteSpecificNeonatalMotherSpecimen && lv_neonate_spec_yn.equals("Y")){					
			strOrderCtl.append("&nbsp;&nbsp;<img style='cursor:pointer;' src='../../eCA/images/MotherBlood.png' onClick=\"NeonatalMotherSpecimenDetails1('"+existing_details[9]+"','"+existing_details[11]+"','"+existing_details[0]+"','"+existing_details[60]+"','"+existing_details[48]+"',null,null)\">");
		}
		//31792 End.
		if(!(existing_details[9]!=null && (existing_details[9].trim().substring(0,2)).equals("CS")))
		{
			strOrderCtl.append("<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+i+"' id='imgArrow"+i+"'></td>");
		}

		out.println(strOrderCtl.toString());
	
	
%>	 
		
<!-- 		sample for line level		<a href='javascript: dummy()' onClick="displayToolTip1(''+getLabel('Common.view.label','Common')+',Cancel,Preps,Comments,Instructions,,Discontinue','<%=existing_details[0]%>','<%=existing_details[1]%>','<%=existing_details[9]%>','CN','<%=existing_details[11]%>','<%=existing_details[12]%>','<%=i%>','<%=patientId%>')"  onMouseOver='hideToolTip()'> -->

		</td>
		<td width='' nowrap class='<%=slClassValue%>'> <%=existing_details[5]%> </a> </td>
		<td width='' nowrap  style='height:18px;	font-family: Verdana, Arial, Helvetica, sans-serif;	font-size: 8pt;	font-weight:normal;text-align:left;padding-left:10px;padding-right:10px;vertical-align:middle;border-top:0px;border-left:0px;border-right:0px;border-style:solid;' class='<%=((colorString[3].equals("X"))?slClassValue:colorString[3])%>'> 
		
<%	
	//  This added For MultipleConsent
				
	

 			/*AppointmentDetails = bean.getOrderApptDetails(existing_details[9]);
 			for(int k=0;k<AppointmentDetails.size();k++) {
				String[] record = (String [])AppointmentDetails.get(k);
				appt_ref_num 	= record[0];
				appt_date		= record[1];
				if(appt_ref_num==null) appt_ref_num= "";
				if(appt_date==null) appt_date= "";
			}*/

%>
		<input type="hidden" name="Appt<%=i%>" id="Appt<%=i%>" value="<%=appt_ref_num%>">
		<input type="hidden" name="Appt_date<%=i%>" id="Appt_date<%=i%>" value="<%=appt_date%>">
		<%
		if((view_by.trim().equals("L")))
		{%>
			<input type="hidden" name="performing_facility_id<%=i%>" id="performing_facility_id<%=i%>" value="<%=existing_details[62]%>">
		<%
		}
		else
		{
		%>
			<input type="hidden" name="performing_facility_id<%=i%>" id="performing_facility_id<%=i%>" value="<%=facility_id%>">
			<input type="hidden" name="performing_facility_id_hdr<%=i%>" id="performing_facility_id_hdr<%=i%>" value="<%=existing_details[60]%>"><!-- IN054720 -->
		<%
		}
		%>
		<input type="hidden" name="appt_locn<%=i%>" id="appt_locn<%=i%>" value="<%=appt_locn%>">
		<input type="hidden" name="appt_resched_yn<%=i%>" id="appt_resched_yn<%=i%>" value="<%=appt_resched_yn%>">
		<input type="hidden" name="appt_resched_reason<%=i%>" id="appt_resched_reason<%=i%>" value="<%=appt_resched_reason%>">
		<input type="hidden" name="no_of_reschedules<%=i%>" id="no_of_reschedules<%=i%>" value="<%=no_of_reschedules%>">

        <input type="hidden" name="parent_order_id<%=i%>" id="parent_order_id<%=i%>" value="">
		<input type="hidden" name="parent_order_line_num<%=i%>" id="parent_order_line_num<%=i%>" value="">
		<%if(!(view_by.trim().equals("L")))
		{%>
			<input type="hidden" name="explanatory_text<%=existing_details[9]%>" id="explanatory_text<%=existing_details[9]%>" value="<%=order_set_expln_txt%>">
		<%
		}else
		{%>
			<input type="hidden" name="explanatory_text<%=existing_details[9]%><%=existing_details[11]%>" id="explanatory_text<%=existing_details[9]%><%=existing_details[11]%>" value="<%=order_set_expln_txt%>">
		<%}%>
		<!--<input type ="hidden" name="localeName" id="localeName" value="<%=localeName%>">-->
 
		<%	if(!(view_by.trim().equals("L"))){
			//printEnable = "N";
			//HSA-CRF-0257.1 - IN055910 - Start
				if(existing_details[0].equals("LB") &&  lb_rslt_mod_status.equals("C") && isResultModified.equals("Y"))
		%>
				<img width='20' height='20' src='../../eCA/images/modifiedresult.png' alt='Result Modified'/>
		<%					
				//HSA-CRF-0257.1 - IN055910 - End
				if(existing_details[14].trim().equals("Y")){
					
					if(existing_details[9]!=null && (existing_details[9].trim().substring(0,2)).equals("CS")) { // only care set (order set) orders 
%>
						<a class='gridLink' href='javascript:showCareSetViewResults("<%=existing_details[9]%>","","<%=cont_order_ind%>","<%=patientId%>","<%=existing_details[3]%>")'>
 <%					}  else {  %>

						<% if(last_action_type!=null && last_action_type.equals("NT")) { %> <!--call Notes view  -->
							<!-- <a href="javascript:showNotes('<%=accession_num%>')"> -->
							<!--IN064215 start-->
							<!--<a class="gridLink" href="javascript:resultViewOrder('Result','<%=existing_details[1]%>','<%=existing_details[9]%>','','<%=cont_order_ind%>','<%=patientId%>','<%=existing_details[0]%>','<%=pract_reln_id%>')">-->
							
							<a class="gridLink" href="javascript:resultViewOrder('Result','<%=existing_details[1]%>','<%=existing_details[9]%>','','<%=cont_order_ind%>','<%=patientId%>','<%=existing_details[0]%>','<%=pract_reln_id%>','<%=view_by%>')">
							<!--IN064215 ends-->
						<% } else { %> <!-- Result View --> 
							<!--IN064215 start-->
							<!--<a class="gridLink" href="javascript:resultViewOrder('Result','<%=existing_details[1]%>','<%=existing_details[9]%>','','<%=cont_order_ind%>','<%=patientId%>','<%=existing_details[0]%>','<%=pract_reln_id%>')">-->
							
							<a class="gridLink" href="javascript:resultViewOrder('Result','<%=existing_details[1]%>','<%=existing_details[9]%>','','<%=cont_order_ind%>','<%=patientId%>','<%=existing_details[0]%>','<%=pract_reln_id%>','<%=view_by%>')">
							<!--IN064215 ends-->
						<% } %>
<%					} %>
							
					<%=existing_details[6]%></a>
				<%
				}
				else{ 					
					//if((!appt_ref_num.equals("")) && (!appt_date.equals("")) && (existing_details[14].equals("AB"))) //IN066414
					if((!appt_ref_num.equals("")) && (!appt_date.equals("")) && (existing_details[13].equals("AB"))) //IN066414
					{
 						/*commented and added for IN08078 starts*/
						//if( (existing_details[0].equals("RD") && rd_install.equals("Y")) || (existing_details[0].equals("OT") && ot_install.equals("Y")) )
						if( (existing_details[0].equals("RD") ) || (existing_details[0].equals("OT") && ot_install.equals("Y")) )
						/*commented and added for IN08078 Ends*/
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
							if(appt_reqd_yn!=null && appt_reqd_yn.equals("Y") && !appt_ref_num.equals("") && !existing_details[0].equals("OT")  && display_appt_yn.equals("Y") ) 
							{ 
						%>
								<input class="BUTTON" type="button" name="ReSchedule<%=i%>" id="ReSchedule<%=i%>" value="R" onClick="viewReSchedule(escape('<%=i%>'))">
							<% 
							} 
							%>												
	<%					} 
					}
					if(appt_reqd_yn!=null && appt_reqd_yn.equals("Y") && appt_ref_num.equals("") && display_appt_yn.equals("Y")) //&& existing_details[10].equals("R")) Modified by Uma on 8/26/2009 for IN013477
					{ 
						if(!(existing_details[0].equals("RD") && rd_install.equals("Y")) && !(existing_details[0].equals("OT") && ot_install.equals("Y") && existing_details[13].equals("OS") ))
						{
							%>
						<input class="BUTTON" type="button" name="Schedule<%=i%>" id="Schedule<%=i%>" value="S" onClick="BookAppointment(escape('<%=i%>'))">
				<%		} 
					}	
				out.println(existing_details[6]);
				out.println("</a>");
				 if(existing_details[50].equalsIgnoreCase("Y")){%>
					<input class="button" type="button" name="existing_consent_id_lookup<%=k%>" id="existing_consent_id_lookup<%=k%>"  title='Consent Details' value="C" onClick="callMultipleConsentHdr('<%=existing_details[4]%>','<%=existing_details[9]%>','<%=existing_details[0]%>','<%=k%>')"><!-- title changed from consent required to Consent IN037398-->
<% 					}
				}
				//IN057196 Start.
			//IN066709 Starts	
				if(existing_details[61].equalsIgnoreCase("N") && recordConsentWithOrder.equalsIgnoreCase("Y") && cnsnt_with_order_yn.equalsIgnoreCase("Y"))
				 {%>	
						<!--<input class="button" type="button" name="rec_consent_with_order<%=k%>" id="rec_consent_with_order<%=k%>"  title='Consent Details' value="RC" onClick="callConsentRec('<%=patientId%>','<%=existing_details[9]%>')">-->
						<input class="button" type="button" name="rec_consent_with_order<%=k%>" id="rec_consent_with_order<%=k%>"  title='Consent Details' value="RC" onClick="callConsentRec('<%=patientId%>','<%=existing_details[9]%>','<%=existing_details[27]%>')">		
<% 				
			//IN066709 ends		
				}
				//IN057196 End.
				//IN067817 STARTS
				 if((existing_details[6].equals("Resulted - Complete") ||existing_details[6].equals("Rejected")) && existing_details[63].equalsIgnoreCase("Y")){%>
					<a class='gridLink' href='javascript: dummy()' onClick="callNotifyDetailsHdr('<%=existing_details[9]%>','<%=existing_details[60]%>')"><img src='../../eOR/images/Notification_Completed.png' border='0'  title='Notification Details'></img></a> <!--IN069597 -->
					 	<%}		
				//IN067817 ENDS
			
			}else if((view_by.trim().equals("L"))){
				//boolean isviewLineDtls = bean.isSiteSpecific("DISP_LB_ORDER_DTLS_INDIV_LVL");//IN061961
				//HSA-CRF-0257.1 - IN055910 - Start
				if(existing_details[0].equals("LB") && lb_rslt_mod_status.equals("C")  && isResultModified.equals("Y"))
				%>
					<img width='20' height='20' src='../../eCA/images/modifiedresult.png' alt='Result Modified'/>
				<%					
				//HSA-CRF-0257.1 - IN055910 - End
				//IN061961 starts


				//IN061961 ends
				if(existing_details[17].trim().equals("Y")){
						//printEnable = "N";
						if(existing_details[9]!=null && (existing_details[9].trim().substring(0,2)).equals("CS")) { // only care set (order set) orders 
	%>
							<a class='gridLink' href='javascript:showCareSetViewResults("<%=existing_details[9]%>","","<%=cont_order_ind%>","<%=patientId%>","<%=existing_details[3]%>")'>
	<%					}  else {  %>

							<% if(last_action_type!=null && last_action_type.equals("NT")) { %> <!--call Notes view  -->
								<!-- <a href="javascript:showNotes('<%=accession_num%>')"> -->
								<!--IN064215 start-->
								<!--<a class="gridLink" href="javascript:resultViewOrder('Result','<%=existing_details[1]%>','<%=existing_details[9]%>','<%=existing_details[11]%>','<%=cont_order_ind%>','<%=patientId%>','<%=existing_details[0]%>','<%=pract_reln_id%>')">-->
								
								<!-- <a class="gridLink" href="javascript:resultViewOrder('Result','<%=existing_details[1]%>','<%=existing_details[9]%>','<%=existing_details[11]%>','<%=cont_order_ind%>','<%=patientId%>','<%=existing_details[0]%>','<%=pract_reln_id%>','<%=view_by%>')">-->
								<!--IN064215 ends-->
								<a class="gridLink" href="javascript:resultViewOrder('Result','<%=existing_details[1]%>','<%=existing_details[9]%>','<%=existing_details[11]%>','<%=cont_order_ind%>','<%=patientId%>','<%=existing_details[0]%>','<%=pract_reln_id%>','<%=view_by%>','<%=existing_details[76]%>','<%=existing_details[12]%>')"><!--	IN061961-->
							<% } else { %> <!-- Result View --> 
								<!--IN064215 start-->
								<!--<a class="gridLink" href="javascript:resultViewOrder('Result','<%=existing_details[1]%>','<%=existing_details[9]%>','<%=existing_details[11]%>','<%=cont_order_ind%>','<%=patientId%>','<%=existing_details[0]%>','<%=pract_reln_id%>')">-->
								
								<!-- <a class="gridLink" href="javascript:resultViewOrder('Result','<%=existing_details[1]%>','<%=existing_details[9]%>','<%=existing_details[11]%>','<%=cont_order_ind%>','<%=patientId%>','<%=existing_details[0]%>','<%=pract_reln_id%>','<%=view_by%>')"> -->
								<!--IN064215 ends-->
								<a class="gridLink" href="javascript:resultViewOrder('Result','<%=existing_details[1]%>','<%=existing_details[9]%>','<%=existing_details[11]%>','<%=cont_order_ind%>','<%=patientId%>','<%=existing_details[0]%>','<%=pract_reln_id%>','<%=view_by%>','<%=existing_details[76]%>','<%=existing_details[12]%>')"><!--	IN061961-->
							<% }%>
	<%					} %>
						<%=existing_details[6]%> </a>
						<% if(existing_details[60].equalsIgnoreCase("Y")){%>
						<input class="button" type="button" name="existing_consent_id_lookup<%=k%>" id="existing_consent_id_lookup<%=k%>"  title='Consent Details' value="C" onClick="callMultipleConsent('<%=existing_details[4]%>','<%=existing_details[12]%>','<%=URLEncoder.encode(existing_details[59],"UTF-8")%>','<%=existing_details[9]%>','<%=existing_details[11]%>','<%=existing_details[0]%>','<%=k%>')">   <!-- title changed from consent required to Consent IN037398--> <!-- IN041421 -->
	 <%				}
				}
				else
				{  
					if((!appt_ref_num.equals("")) && (!appt_date.equals("")) && (existing_details[14].equals("AB")) ) 
					{
						/*commented and added for IN08078 starts*/
						//if( (existing_details[0].equals("RD") && rd_install.equals("Y")) || (existing_details[0].equals("OT") && ot_install.equals("Y")) )
						if( (existing_details[0].equals("RD")) || (existing_details[0].equals("OT") && ot_install.equals("Y")) )//Sharanraj
						/*commented and added for IN08078 ends*/
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
					//IN068986 Start.
					if( (existing_details[0].equals("LB")) && "RG".equals(existing_details[14]) && "Y".equals(existing_details[77])){
					%>
					<a class="gridLink" href="javascript:resultViewForRegisteredOrder('Result','<%=existing_details[1]%>','<%=existing_details[9]%>','<%=existing_details[11]%>','<%=cont_order_ind%>','<%=patientId%>','<%=existing_details[0]%>','<%=pract_reln_id%>','<%=view_by%>','<%=existing_details[76]%>','<%=existing_details[12]%>','<%=existing_details[14]%>')">
					<%
					}
					//IN068986 End.
					out.println(existing_details[6]);		
					out.println("</a>"); 
					//ML-MMOH-CRF-1617.1 START 
					if(existing_details[0].equalsIgnoreCase("RD")&&existing_details[6].equalsIgnoreCase("Ordered")&&(!Appt_can_remarks.equals("")||!Appt_can_reason.equals(""))){
				 %>
										       
			        <Input type="button" name="cancel_comment<%=i%>" value="?" class="button" onClick="viewCanOrderFormatLineCmts1('<%=i%>','<%=existing_details[11]%>','<%=existing_details[9]%>')">
			          <Input type='hidden' name="Cancel<%=i%>" value="<%=can_reason%>">
					  <input type="hidden" name="Cancel_date_time<%=i%>" value="<%=can_date_time%>">
					  <input type="hidden" name="Cancel_pract_id<%=i%>" value="<%=can_pract_id%>">
					  <input type="hidden" name="Can_Reason<%=i%>" value="<%=str_value%>">
					  <input type="hidden" name="Appt_can_remarks<%=i%>" value="<%=Appt_can_remarks%>">
					  <input type="hidden" name="Appt_can_reason<%=i%>" value="<%=Appt_can_reason%>">
					  <input type="hidden" name="order_category<%=i%>" value="<%=existing_details[0]%>">
					   <input type="hidden" name="order_status<%=i%>" value="<%=existing_details[6]%>">
					    
					<% }
					if(existing_details[60].equalsIgnoreCase("Y")){%>
						<input class="button" type="button" name="existing_consent_id_lookup<%=k%>" id="existing_consent_id_lookup<%=k%>"  title='Consent Details' value="C" onClick="callMultipleConsent('<%=existing_details[4]%>','<%=existing_details[12]%>','<%=URLEncoder.encode(existing_details[59],"UTF-8")%>','<%=existing_details[9]%>','<%=existing_details[11]%>','<%=existing_details[0]%>','<%=k%>')"> <!-- title changed from consent required to Consent IN037398--><!-- IN041421 -->
	 <%				}
				}
				//IN057196 Start.
			//IN066709 Starts
				if(existing_details[71].equalsIgnoreCase("N") && recordConsentWithOrder.equalsIgnoreCase("Y") && cnsnt_with_order_yn.equalsIgnoreCase("Y")){%>		
					<!--<input class="button" type="button" name="rec_consent_with_order<%=k%>" id="rec_consent_with_order<%=k%>"  title='Consent Details' value="RC" onClick="callConsentRec('<%=patientId%>','<%=existing_details[9]%>')">-->
					<input class="button" type="button" name="rec_consent_with_order<%=k%>" id="rec_consent_with_order<%=k%>"  title='Consent Details' value="RC" onClick="callConsentRec('<%=patientId%>','<%=existing_details[9]%>','<%=existing_details[27]%>')">
			
			<%//IN066709 Ends
			}
				//IN057196 End.
			}
   			if(  !(view_by.trim().equals("L"))){
 				 /*canReason = (String[]) bean.getHeaderLineCancelReason(existing_details[9]);Ordered 
                 can_pract_id 		= 	canReason[1];     can_date_time 		= 	canReason[2];  */
				if(existing_details[11].equals("")) {
                 	can_reason		= can_reason;
				}
				else can_reason = existing_details[11]; 
 				if((can_reason==null || can_reason.equals("")) && existing_details[13].equals("HD"))
					can_reason		= last_action_reason_desc;
				if(can_reason==null) can_reason ="";
				// If appointment reason (transfer) is there, put the reason 
				if(appt_resched_reason!=null && !appt_resched_reason.equals("")&&existing_details[6].equalsIgnoreCase("Appt Scheduled"))
					can_reason		= appt_resched_reason;
				if(can_reason!=null && !can_reason.equals(""))
					can_reason		= can_reason.replace('\"','\n');
 				if((existing_details[13].trim()).equals("DC")) { // For Discontinue
 					if(disc_pract_id !=null && !disc_pract_id.equals(""))//IN049203
 						can_pract_id 		= 	disc_pract_id; 
 					if(disc_date_time !=null && !disc_date_time.equals(""))//IN049203
                				can_date_time 		= 	disc_date_time; 
				}
				//IN061903 starts
				if((existing_details[13].trim()).equals("ND")) { // For Not Done
 					if(disc_pract_id !=null && !disc_pract_id.equals(""))
 						can_pract_id 		= 	disc_pract_id; 
 					if(disc_date_time !=null && !disc_date_time.equals(""))
                				can_date_time 		= 	disc_date_time; 
				}
				//IN061903 ends
				
				if(existing_details[13].equals("HC") || existing_details[13].equals("HD"))
					str_value = "Hold";
				else if(appt_resched_reason!=null && !appt_resched_reason.equals("")&& existing_details[6].equalsIgnoreCase("Appt Scheduled"))
					str_value = "Appointment Re-Schedule Reason";
				else if(existing_details[13].trim().equals("DC"))
					str_value = "Discontinue";
				//IN061903 starts
				else if(existing_details[13].trim().equals("ND"))
					str_value = "Not Done";
				//IN061903 ends
				else 
					str_value = "Cancel Reason";
			
				//IN061903 starts
   				//if(( ((existing_details[13].trim()).equals("CN") || (existing_details[13].trim()).equals("DC") || (existing_details[13].trim()).equals("RD") || (existing_details[13].trim()).equals("RJ") || (existing_details[13].trim()).equals("HD") ) || (!appt_resched_reason.equals("")) ) && (  (existing_details[11] != null && !existing_details[11].equals("")) || !can_reason.equals("") )){
				if(( ((existing_details[13].trim()).equals("CN") || (existing_details[13].trim()).equals("DC") || (existing_details[13].trim()).equals("RD") || (existing_details[13].trim()).equals("RJ") || (existing_details[13].trim()).equals("HD") || (existing_details[13].trim()).equals("ND") ) || (!appt_resched_reason.equals("")) ) && (  (existing_details[11] != null && !existing_details[11].equals("")) || !can_reason.equals("") )){
				//IN061903 ends
  				
		%>
				<input type="hidden" name="Cancel<%=i%>" id="Cancel<%=i%>" value="<%=can_reason%>">
				<input type="hidden" name="Cancel_date_time<%=i%>" id="Cancel_date_time<%=i%>" value="<%=can_date_time%>">
				<input type="hidden" name="Cancel_pract_id<%=i%>" id="Cancel_pract_id<%=i%>" value="<%=can_pract_id%>">
				
				<%--<input type=button name="cancel_comment<%=i%>" id="cancel_comment<%=i%>" value="?" class="button" onClick="viewCanOrderFormatLineCmts('<%=str_value%>','<%=i%>','<%=existing_details[13]%>','<%=existing_details[9]%>','<%=view_by%>')">--%>

		<%		//IN061903 starts
				//} else if( ((existing_details[13].trim()).equals("CN") || (existing_details[13].trim()).equals("DC") || (existing_details[13].trim()).equals("RD") || (existing_details[13].trim()).equals("RJ") || (existing_details[13].trim()).equals("HD") || (!appt_resched_reason.equals(""))) && !can_reason.equals("")) {
				} else if( ((existing_details[13].trim()).equals("CN") || (existing_details[13].trim()).equals("DC") || (existing_details[13].trim()).equals("RD") || (existing_details[13].trim()).equals("RJ") || (existing_details[13].trim()).equals("HD") || (existing_details[13].trim()).equals("ND") || (!appt_resched_reason.equals(""))) && !can_reason.equals("")) {
				//IN061903 ends
				%>
				<input type="hidden" name="Cancel<%=i%>" id="Cancel<%=i%>" value="<%=can_reason%>">
				<input type="hidden" name="Cancel_date_time<%=i%>" id="Cancel_date_time<%=i%>" value="<%=can_date_time%>">
				<input type="hidden" name="Cancel_pract_id<%=i%>" id="Cancel_pract_id<%=i%>" value="<%=can_pract_id%>">
			<!--	<input type=button name="cancel_comment<%=i%>" id="cancel_comment<%=i%>" value="?" class="button" onClick="viewCanOrderFormatLineCmts('Cancel Reason','<%=i%>','<%=existing_details[13]%>','<%=existing_details[9]%>','<%=view_by%>')">-->
				<%} 
			} else {
                //IN061903 starts
				//if (((existing_details[14].trim()).equals("CN") || (existing_details[14].trim().equals("DC")) || (existing_details[14].trim().equals("RD")) || (existing_details[14].trim().equals("RJ")) || (existing_details[14].trim().equals("HD")) ) || (appt_resched_reason!=null && !appt_resched_reason.equals("")) || ((existing_details[24] != null) && (!(existing_details[24]).equals("")))) {
				if (((existing_details[14].trim()).equals("CN") || (existing_details[14].trim().equals("DC")) || (existing_details[14].trim().equals("RD")) || (existing_details[14].trim().equals("RJ")) || (existing_details[14].trim().equals("HD")) || (existing_details[14].trim().equals("ND")) ) || (appt_resched_reason!=null && !appt_resched_reason.equals("")) || ((existing_details[24] != null) && (!(existing_details[24]).equals("")))) {
				//IN061903 ends
                   	can_reason = (existing_details[24]).replace('\"','\n');
					if((can_reason==null || can_reason.equals("")) && (existing_details[14].trim()).equals("HD"))
						can_reason = existing_details[35]; // LAST_ACTION_REASON_DESC
					// If appointment reason (transfer) is there, put the reason
					if(appt_resched_reason!=null && !appt_resched_reason.equals("")&&existing_details[6].equalsIgnoreCase("Appt Scheduled"))
						can_reason		= appt_resched_reason;
					if(can_reason!=null || !can_reason.equals("")) 
						can_reason = can_reason.replace('\"','\n');
  					//IN061903 start
					//if((existing_details[14].trim()).equals("DC")) {
					if((existing_details[14].trim()).equals("DC") || (existing_details[14].trim()).equals("ND")) {
					//IN061903 ends
  						if(existing_details[34] !=null && !existing_details[34].equals(""))//IN049203
							can_pract_id 		= 	existing_details[34]; //disc_pract_id
						if(existing_details[33] !=null && !existing_details[33].equals(""))//IN049203	
							can_date_time 		= 	existing_details[33]; //disc_date_time
					} else if (!appt_resched_reason.equals("")&& existing_details[6].equalsIgnoreCase("Appt Scheduled")) {
						can_date_time 		= 	"";
						can_pract_id 		= 	"";
					}else if(existing_details[14].equals("HC") || existing_details[14].equals("HD")){ //IN042100 new condition for hold
						can_date_time 		= 	existing_details[43];
						can_pract_id 		= 	existing_details[42];
					}else { // For cancel
						can_date_time 		= 	existing_details[31];
						can_pract_id 		= 	existing_details[32];
					}
					
					if(existing_details[14].equals("HC") || existing_details[14].equals("HD"))
						str_value = "Hold";
					else if(appt_resched_reason!=null && !appt_resched_reason.equals("")&& existing_details[6].equalsIgnoreCase("Appt Scheduled"))
						str_value = "Appointment Re-Schedule Reason";
					else if(existing_details[14].trim().equals("DC"))
						str_value = "Discontinue";
					else if(existing_details[14].trim().equals("RD"))
						str_value = "Replaced";
					else if(existing_details[14].trim().equals("RG"))
						str_value = "Registered";
	 				else if(existing_details[14].trim().equals("CN"))
						str_value = "Cancel Reason";
					//IN061903 starts
					else if(existing_details[14].trim().equals("ND"))
						str_value = "Not Done";
					//IN061903 ends
					else
						str_value = existing_details[6];		
							
						%>
			<% //ML-MMOH-CRF-1617.1 START  %>
               <% if(!existing_details[6].equalsIgnoreCase("Appt Scheduled")&&!existing_details[6].equalsIgnoreCase("Ordered")){
                 %>  
					 <Input type="button" name="cancel_comment<%=i%>" value="?" class="button" onClick="viewCanOrderFormatLineCmts('<%=i%>','<%=existing_details[11]%>','<%=existing_details[9]%>')">
			          <Input type='hidden' name="Cancel<%=i%>" value="<%=can_reason%>">
			          <input type="hidden" name="Cancel_date_time<%=i%>" value="<%=can_date_time%>">
					  <input type="hidden" name="Cancel_pract_id<%=i%>" value="<%=can_pract_id%>">
					  <input type="hidden" name="Can_Reason<%=i%>" value="<%=str_value%>"> 
					  <input type="hidden" name="order_status<%=i%>" value="<%=existing_details[6]%>">
				 <% }	else if(existing_details[0].equalsIgnoreCase("RD")&&existing_details[6].equalsIgnoreCase("Appt Scheduled")&&(!Appt_resched_remarks.equals("")||!appt_resched_reason.equals(""))){
		          	 %>
		               
				         <Input type="button" name="cancel_comment<%=i%>" value="?" class="button" onClick="viewCanOrderFormatLineCmts('<%=i%>','<%=existing_details[11]%>','<%=existing_details[9]%>')">
				          <Input type='hidden' name="Cancel<%=i%>" value="<%=can_reason%>">
				          <input type="hidden" name="Cancel_date_time<%=i%>" value="<%=can_date_time%>">
						  <input type="hidden" name="Cancel_pract_id<%=i%>" value="<%=can_pract_id%>">
						  <input type="hidden" name="Can_Reason<%=i%>" value="<%=str_value%>">
						  <input type="hidden" name="Appt_resched_remarks<%=i%>" value="<%=Appt_resched_remarks%>">
						  <input type="hidden" name="order_category<%=i%>" value="<%=existing_details[0]%>">
						  <input type="hidden" name="order_status<%=i%>" value="<%=existing_details[6]%>">
						  <% }//ML-MMOH-CRF-1617.1 END%>
               
		<%		}
			}
		//--[IN033488]
		StringBuffer error_desc=new StringBuffer();	
		error_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.MarkedasError.label","ca_labels"));
		error_desc.append(" ");
		error_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels"));
		error_desc.append(" ");
		
		if(existing_details[13].trim().equals("RM") ||existing_details[13].trim().equals("RS")||existing_details[14].trim().equals("RM") ||existing_details[14].trim().equals("RS")) 
		{
			ErrStatusChk  = bean.getRltNoteSts(existing_details[9],localeName); 		
			
			if(ErrStatusChk!=null)
			{
				for(int j=0; j<ErrStatusChk.size(); j++)
				{
					String[] record 						= (String[])ErrStatusChk.get(j);
					action_type				= bean.checkForNull(record[2],"");
					action_date_time		= bean.checkForNull(record[1],"");
					action_by_id			= bean.checkForNull(record[0],"");
				}
			}
			
			if(action_type.equals("ER"))
			{
			%>
				<img title='<%=error_desc%><%=action_by_id%>' src="../../eCA/images/MarkError.gif"/>
			<%
			action_type = "";//IN040198.1
			}
		}
		
		//--[IN033488]
		%>
		</td>
		<!-- Arvind -->
		<%
		if((order_category.equals("PH")|| order_category.equals(""))&&view_by.equals("L"))
		{
			String med_admin_status_imd="";
			String med_admin_status_title="";
			String med_admin_status_text="";
			String med_admin_status = bean.getMedAdminStatus(patientId,encntr_id,facility_id,existing_details[9],existing_details[11]);
			//if(med_admin_status.equals("P"))//IN048935
			//IN061903 starts
			//if(med_admin_status.equals("P") && !"DC".equals(existing_details[14]) && !"CN".equals(existing_details[14]) && !"FC".equals(existing_details[14]))//IN048935
			if(med_admin_status.equals("P") && !"DC".equals(existing_details[14]) && !"CN".equals(existing_details[14]) && !"FC".equals(existing_details[14]) && !"ND".equals(existing_details[14]))
			//IN061903 ends
			{
				//med_admin_status_imd="green";//Commentted IN038336
				med_admin_status_imd="yellow";//Changed colour to yellow - IN038336
				med_admin_status_title="In Progress";//Changed from progess to In Progress -IN038336
				med_admin_status_text="In Progress"; //IN038336 - to correct tooltip issue
			}
			//IN061903 starts
			//else if(med_admin_status.equals("C") && !"DC".equals(existing_details[14]) && !"CN".equals(existing_details[14]) && !"FC".equals(existing_details[14]))//IN048935
			else if(med_admin_status.equals("C") && !"DC".equals(existing_details[14]) && !"CN".equals(existing_details[14]) && !"FC".equals(existing_details[14]) && !"ND".equals(existing_details[14]))
			//IN061903 ends
			{
				//med_admin_status_imd="yellow"; //Commetted IN038336
				med_admin_status_imd="DarkGreen";//Changed colour to green -IN038336
				med_admin_status_title="Completed";
				med_admin_status_text="Completed";//IN038336
			}
			else
			{
				med_admin_status_imd="";
				med_admin_status_title="";
				med_admin_status_text="";//IN038336
			}
			%>
			 <!-- Commented as part of IN033172 fix <td class='<%=slClassValue%>'>-->
			 <%
			 //IN061903 starts
			 //if(!med_admin_status.equals("N")&&(!med_admin_status.equals("")) && !"DC".equals(existing_details[14]) && !"CN".equals(existing_details[14]) && !"FC".equals(existing_details[14]))//IN048935 
			 if(!med_admin_status.equals("N")&&(!med_admin_status.equals("")) && !"DC".equals(existing_details[14]) && !"CN".equals(existing_details[14]) && !"FC".equals(existing_details[14]) && !"ND".equals(existing_details[14]))
			//IN061903 ends
			{%>
			 <a class="gridLink" href="javascript:viewMedication('<%=patientId%>','<%=location_code%>','<%=existing_details[7]%>','<%=patient_class%>')"><td class='<%=slClassValue%>' style='BACKGROUND-COLOR:<%=med_admin_status_imd%>;width:20px;height:20px;' onclick ="viewMedication('<%=patientId%>','<%=location_code%>','<%=existing_details[7]%>','<%=patient_class%>')" title='<%=med_admin_status_title%>'><%=med_admin_status_text%></td></a><!--IN038336 -->
						<% 
			} else {%>
			<!--Added as part of IN033172-->
			<td class='<%=slClassValue%>'></td>
			<!-- Commented as part of IN033172 fix</td> -->
			<%      }
		}%>
		<!--end here-->
		<!--IN063816 start-->
		<%		
		if (("L".equals(view_by)) && "Y".equals(barcodeSiteSpecificYN))
		{
			if(("Y".equals(existing_details[72])))
			{
		%>
				<td width='' nowrap class='<%=slClassValue%>'><input type=checkbox name='chk_barcode<%=i%>' id='chk_barcode<%=i%>'  value="N" onClick="clickLine_barcode(this,<%=i%>)"></td>
		<%
			}
			else
			{
			%>
				<td width='' nowrap class='<%=slClassValue%>'>&nbsp;<input type=checkbox name='chk_barcode<%=i%>' id='chk_barcode<%=i%>'  value="N" onClick="clickLine_barcode(this,<%=i%>)" style='display:none'></td>
			<%
			}
		}
		//IN065942, starts
		if("L".equals(view_by) && "Y".equals(existing_details[74]) && "RG".equals(existing_details[14]))
		{
		%>		
		<td width='' nowrap class='<%=slClassValue%>'><input type='checkbox' name='chk_prn_reg_label<%=i%>' id='chk_prn_reg_label<%=i%>' value="N" onClick="chkPrnRegLabel(this,<%=i%>)"></td>
		<%
		}
		//else if("L".equals(view_by) && "Y".equals(existing_details[74]) && !"RG".equals(existing_details[14]))
		else if("L".equals(view_by))
		{
		%>
		<td width='' nowrap class='<%=slClassValue%>'>&nbsp;</td>	
		<%
		}
		//IN065942, ends
		%>
		<input type=hidden name='order_line_num<%=i%>' id='order_line_num<%=i%>' value='<%=existing_details[11]%>'><!--IN063816-->
		<input type=hidden name='order_catalog_code<%=i%>' id='order_catalog_code<%=i%>' value='<%=existing_details[12]%>'><!--IN063816-->
		<!--IN063816 end-->
		<!-- 19112 Start.-->
		<%
		if("L".equals(view_by) && isSiteSpecificBillStatus && !"".equals(billingStatus))
		{
		%>		
		<td width='' nowrap class='<%=slClassValue%>'>&nbsp;&nbsp;&nbsp;&nbsp;<%=billingStatus%></td>
		<%
		}else if("L".equals(view_by)&& isSiteSpecificBillStatus)
		{
		%>
		<td width='' nowrap class='<%=slClassValue%>'>&nbsp;</td>	
		<%
		}
//start 68801
existexternalReqFormYN =bean.getExternalRequsitionFormYN(existing_details[9]);
if("H".equals(view_by) ){
if(existexternalReqFormYN.equals("Y")){  
if("H".equals(view_by) && !"RJ".equals(existing_details[13]) && !"PS".equals(existing_details[13]) && !"PO".equals(existing_details[13]) && !"PC".equals(existing_details[13]) && !"CN".equals(existing_details[13]))
{
%>		
<td class='<%=slClassValue%>'> 
<img onclick="callCApage('../../eCA/jsp/RecClinicalNotesModal.jsp?appl_task_id=EXTERNAL_REQ_FORM&locale=<%=locale%>&patient_id=<%=patient_id%>&encounter_id=<%=encounter_id%>&patient_class=<%=patient_class%>&order_id=<%=existing_details[9]%>&ord_typ_code=<%=existing_details[4]%>&facility_id=<%=facility_id%>&orderStatusCodeHdr=<%=existing_details[13]%>&title=Record External Requisition Form')" id="CLINICAL_NOTES1" alt="Record External Requisition Form"  style='cursor:pointer' src="../../eCA/images/external_requisition_form.png">
</td>
<%
}
else{
%>	
<td class='<%=slClassValue%>'>&nbsp;</td>
<% }
}else{
%>
<td class='<%=slClassValue%>'>&nbsp;</td>

<% }
}

%> <!-- // end 68801 -->
<%
		if (!function_from.equals("MO")){ //[IN036674]
		%>
		<td width='' nowrap class='<%=slClassValue%>'> <input type=checkbox name='chk<%=i%>' id='chk<%=i%>'  value="N" onClick='clickLine(this)' <%//=(printEnable.equals("N"))?"disabled":""%>></td>
		<%}%>
	</tr>
	<input type=hidden name='priority<%=i%>' id='priority<%=i%>' value='<%=existing_details[10]%>'>
    <%--<script>alert('<%=existing_details[14]%>')</script>--%>
	<input type=hidden name='ord_status<%=i%>' id='ord_status<%=i%>' value='<%=(!(view_by.trim().equals("L")))?existing_details[13]:existing_details[14]%>'>


<%	
	src_type = existing_details[16];
	old_category = existing_details[0];
	
	i++;
	}
%>
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
<input type=hidden name='function_from' id='function_from' value='<%=function_from %>'>

<input type=hidden name='p_called_from_ca' id='p_called_from_ca' value='<%=p_called_from_ca%>'>
<input type=hidden name='sex' id='sex' value='<%=sex%>'>
<input type=hidden name='age' id='age' value='<%=age%>'>
<input type=hidden name='dob' id='dob' value='<%=dob%>'>
<input type=hidden name='visit_adm_date' id='visit_adm_date' value='<%=visit_adm_date%>'>
<!-- <input type='hidden' name='queryString' id='queryString' value='<%=request.getQueryString()%>'> [IN036674] -->
<input type='hidden' name='queryString' id='queryString' value='<%=queryString%>'>
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

	
<!-- For Next & previous -->
<input type='hidden' name='from' id='from' value='<%=from%>'>
<input type='hidden' name='to' id='to' value='<%=to%>'>
<!-- IN030279 Start -->
<input type="hidden" name="deceased_yn" id="deceased_yn" value="<%=deceased_yn%>">
<input type="hidden" name="medico_legal_yn" id="medico_legal_yn" value="<%=medico_legal_yn%>">
<input type="hidden" name="postmortem_status" id="postmortem_status" value="<%=postmortem_status%>">
<input type="hidden" name="body_part_yn" id="body_part_yn" value="<%=body_part_yn%>">
<input type="hidden" name="registration_no" id="registration_no" value="<%=registration_no%>"> 
<input type="hidden" name="callingFrom" id="callingFrom" value="<%=callingFrom%>">
<input type="hidden" name="recordConsentWithOrder" id="recordConsentWithOrder" value="<%=recordConsentWithOrder%>">  <!-- IN057196 -->
<input type="hidden" name="cnsnt_with_order_yn" id="cnsnt_with_order_yn" value="<%=cnsnt_with_order_yn%>">  <!-- IN057196 -->
<!-- IN030279 End. -->
<input type=hidden name='total_recs_barcode' id='total_recs_barcode' value='<%=i%>'><!--IN063816-->
<input type=hidden name='call_from_barcode_btn' id='call_from_barcode_btn' value='N'><!--IN063816-->
<input type=hidden name='pract_type' id='pract_type' value='<%=practitioner_type%>'><!--IN065942-->

 <!-- For Next & previous -->

	<script>
			//if(parent.parent.ExistingOrderHeader.document.getElementById("tableheader")==null)
			//{
				//setTimeout("alignHeading('');",300);
			//}
			//else 
				//alignHeading('');
	</script>

</form>

		<div name='tooltiplayer' id='tooltiplayer' style="position: absolute; width: 12%; visibility: visible; left: 451px; top: 40px; background-color: #808080; z-index: 1000;"">
			<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%' align='center'>
				<tr>
					<td width='100%' id='t'></td>
					<!-- </td> -->
				</tr>
			</table>
		</div>
</body>
<script>
var function_from_ =document.forms[0].function_from.value;
if(function_from_ != "MO"){  //IN030279
if(parent.parent.ExistingOrderSearch)
{
	parent.parent.ExistingOrderSearch.document.existing_order_search.search.disabled = false;
   // parent.parent.ExistingOrderHeader.document.existing_order_hdg.select_all.disabled = false;
   if(document.getElementById("select_all"))
	{
	   document.getElementById("select_all").disabled = false;
	}
}
else if(parent.ExistingOrderSearch.document.existing_order_search)
{
	parent.ExistingOrderSearch.document.existing_order_search.search.disabled = false;
	//parent.ExistingOrderHeader.document.existing_order_hdg.select_all.disabled = false;
	if(document.getElementById("select_all"))
	{
	   document.getElementById("select_all").disabled = false;
	}
}
} //IN030279
</script>
</html>

<%
	//	putObjectInBean(bean_id,bean,request);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
%>

