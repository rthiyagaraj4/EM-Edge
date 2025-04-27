/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/*
---------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------	
10/05/2017	IN064215		Krishna Gowtham J	10/05/2017		Ramesh G		PMG2017-SH-CRF-0001		
07/11/2017	IN063813		Raja S				07/11/2017		Ramesh G		AAKH-CRF-0095
18/07/2018	IN061961		Sivabagyam M    	18/07/2018		Ramesh G		GHL-CRF-0433
05/11/2018	IN068986		Ramya Maddena		05/11/2018		Ramesh G		MO-CRF-20137.1
30/07/2019	IN070610		Dinesh T		30/07/2019		Ramesh G		TBMC-CRF-0011.1
15/01/2021	7632		Sivabagyam M		15/01/2021		Ramesh G	ML-MMOH-CRF-1261.1
07/09/2023	  31792	   Ranjith P R		08/09/2023		RAMESH G		ML-MMOH-CRF-1913
---------------------------------------------------------------------------------------------------------
*/
//IN064215 start
//function resultViewOrder(colval1,colval,orderId,order_line_num,cont_order_ind,patient_id, ord_cat, pract_reln_id){
//function resultViewOrder(colval1,colval,orderId,order_line_num,cont_order_ind,patient_id, ord_cat, pract_reln_id, view_by,event_code){
//IN064215 ends
async function resultViewOrder(colval1,colval,orderId,order_line_num,cont_order_ind,patient_id, ord_cat, pract_reln_id, view_by,event_code,order_catalog_code){	//IN061961
		var dialogHeight ='70vh' ;
		var dialogWidth = '100vw' ;
		var dialogTop	= '129';
		var dialogLeft = '11' ;

		if((screen.width==800) && (screen.height==600))
		{
			dialogHeight   ='95vh' ;
			dialogTop	= '129';
			dialogLeft = '30' ;
			dialogWidth = '80vw' ;
		}
		else
		{	
			dialogHeight   = "95vh" ;
			dialogTop	= '145';
			dialogLeft = '30' ;
			//dialogWidth = '60' ;//Commented for IN063813
			dialogWidth = '80vw' ;//Modified for IN063813
			
		}

		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';

		var arguments = "";
		//IN064215 start
		//var finalString	= "colval1="+colval1+ "&colval=" +encodeURIComponent(colval)+"&orderId="+ orderId+"&order_line_num="+ order_line_num+"&cont_order_ind="+cont_order_ind+"&patient_id="+patient_id+"&ord_cat="+ord_cat+"&pract_reln_id="+pract_reln_id;
		
		//var finalString	= "colval1="+colval1+ "&colval=" +encodeURIComponent(colval)+"&orderId="+ orderId+"&order_line_num="+ order_line_num+"&cont_order_ind="+cont_order_ind+"&patient_id="+patient_id+"&ord_cat="+ord_cat+"&pract_reln_id="+pract_reln_id+"&view_by="+view_by;
		//IN064215 ends
		var finalString	= "colval1="+colval1+ "&colval=" +encodeURIComponent(colval)+"&orderId="+ orderId+"&order_line_num="+ order_line_num+"&cont_order_ind="+cont_order_ind+"&patient_id="+patient_id+"&ord_cat="+ord_cat+"&pract_reln_id="+pract_reln_id+"&view_by="+view_by+"&event_code="+event_code+"&order_catalog_code="+order_catalog_code;//IN061961
		//alert(finalString)              
		var retVals = await top.window.showModalDialog("../../eOR/jsp/ExistingOrderTasks.jsp?"+finalString,arguments,features);
}
//IN068986 Start.
async function resultViewForRegisteredOrder(colval1,colval,orderId,order_line_num,cont_order_ind,patient_id, ord_cat, pract_reln_id, view_by,event_code,order_catalog_code,order_status){	//IN061961
		
		var dialogHeight ='27vh' ;
		var dialogWidth = '66vw' ;
		var dialogTop	= '129';
		var dialogLeft = '11' ;

		if((screen.width==800) && (screen.height==600))
		{
			dialogHeight   ='40vh' ;
			dialogTop	= '129';
			dialogLeft = '30' ;
			dialogWidth = '50vw' ;
		}
		else
		{			
			dialogHeight   = "40vh" ;
			dialogTop	= '145';
			dialogLeft = '30' ;
			dialogWidth = '70vw' ;			
		}

		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';

		var arguments = "";		
		var finalString	= "colval1="+colval1+ "&colval=" +encodeURIComponent(colval)+"&orderId="+ orderId+"&order_line_num="+ order_line_num+"&cont_order_ind="+cont_order_ind+"&patient_id="+patient_id+"&ord_cat="+ord_cat+"&pract_reln_id="+pract_reln_id+"&view_by="+view_by+"&event_code="+event_code+"&order_catalog_code="+order_catalog_code+"&order_status="+order_status;//IN061961
		             
		var retVals = await top.window.showModalDialog("../../eOR/jsp/ExistingOrderTasks.jsp?"+finalString,arguments,features);
		
}
//IN068986 End.
async function viewComments(comments){

		var dialogHeight ='12' ;
		var dialogWidth = '30' ;
		var dialogTop	= '189';
		var dialogLeft = '167' ;

		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';

		var arguments = "";
		var finalString	= "comments="+comments;
		var retVals = await window.showModalDialog("../../eOR/jsp/ViewComment.jsp?"+finalString,arguments,features);
}

async function viewClobData(row_index){
		//row_index = unescape(row_index)
		//alert(row_index)
		var dialogHeight ='37.5' ;
		var dialogWidth = '50' ;
		var dialogTop	= '150';
		var dialogLeft = '107' ;
		var title = ''
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';

		var arguments = "";
		var finalString	= "row_index="+ row_index;
		//alert(finalString)
		var retVals = await window.showModalDialog("../../eOR/jsp/ResultViewClobData.jsp?"+finalString,arguments,features);

}
async function viewResultComment(result_comment){
		//row_index = unescape(row_index)
		//alert(row_index)
		var dialogHeight ='12' ;
		var dialogWidth = '30' ;
		var dialogTop	= '189';
		var dialogLeft = '167' ;
		var title = ''
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';

		var arguments = "";
		var finalString	= "result_comment="+ result_comment;
		//alert(finalString)
		var retVals = await window.showModalDialog("../../eOR/jsp/ViewResultComment.jsp?"+finalString,arguments,features);

}
function printValues() {
	//alert('ord_typ_code='+parent.ViewOrderDtl.document.getElementById("ord_typ_code").value);
	//alert('patient_class='+parent.ViewOrderDtl.document.getElementById("patient_class").value);
	//alert('priority='+parent.ViewOrderDtl.document.getElementById("priority").value);
	//alert('ord_id='+parent.ViewOrderDtl.document.getElementById("ord_id").value);
	//alert('source_type='+parent.ViewOrderDtl.document.getElementById("source_type").value);
	//alert('location_code='+parent.ViewOrderDtl.document.getElementById("location_code").value);
	//alert('report_srl_no='+parent.ViewOrderDtl.document.getElementById("report_srl_no").value);

	var bean_id = parent.ViewOrderDtl.document.getElementById("bean_id").value ;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr ="<root><SEARCH " ;
	xmlStr += "ord_typ_code=\""+ parent.ViewOrderDtl.document.getElementById("ord_typ_code").value +"\" " ;
	xmlStr += "patient_class=\""+ parent.ViewOrderDtl.document.getElementById("patient_class").value +"\" " ;
	xmlStr += "priority=\""+ parent.ViewOrderDtl.document.getElementById("priority").value +"\" " ;
	xmlStr += "ord_id=\""+ parent.ViewOrderDtl.document.getElementById("ord_id").value +"\" " ;
	xmlStr += "source_type=\""+ parent.ViewOrderDtl.document.getElementById("source_type").value +"\" " ;
	xmlStr += "location_code=\""+ parent.ViewOrderDtl.document.getElementById("location_code").value +"\" " ;
	xmlStr += "report_srl_no=\""+ parent.ViewOrderDtl.document.getElementById("report_srl_no").value +"\" " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ResultViewOrderValidate.jsp?bean_id=" + bean_id + "&validate=PRINT", false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText ) ;

	//alert(parent.ViewOrderDtl.document.getElementById("report_srl_no").value);
    //alert(getOrMessage("RPT_SUBMIT_TO_PRINTER"));
}
async function auditValues(order_id,order_line_num,reporting_date,reporting_practitioner) {
    //alert(parent.ViewOrderTop.document.getElementById("querystring").value);

    var dialogHeight ='22' ;
		var dialogWidth = '30' ;
		var dialogTop	= '189';
		var dialogLeft = '167' ;
		var title = ''
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';

		var arguments = "";
		var finalString	= "order_id="+order_id+"&order_line_num="+order_line_num+"&reporting_date="+reporting_date+"&reporting_practitioner="+reporting_practitioner;
		//alert(finalString)
		var retVals = await window.showModalDialog("../../eOR/jsp/ViewAuditTrialFrameset.jsp?"+finalString,arguments,features);
}

//IN070610, starts
function uploadedDocuments(accession_num, discr_msr_panel_id){	
	window_id = window.open("../../eOR/jsp/ImageVideosFileUploadMain.jsp?p_called_from=View&p_acc_no="+accession_num+"&p_discr_msr_panel_id="+discr_msr_panel_id,'',"height=700,width=700,top=80,left=130,resizable=yes,directories=no,location=no,menubar=no,status=no");
}
//IN070610, ends
//ml-mmoh-crf-1261.1 starts
function run(event_code){
	var accession_num=document.getElementById("accession_num").value;
	var facilty=document.getElementById("facilty").value;
	var login_user=document.getElementById("login_user").value;
	var operating_facility_id=document.getElementById("performing_facility_id").value;
	var facility_id=document.getElementById("facilityid").value;
	var session_id=document.getElementById("session_id").value;
	var locale=document.getElementById("locale").value;
	var patient_id=document.getElementById("patient_id").value;
	var machine_name=document.getElementById("machine_name").value;
	var reqdate=document.getElementById("reqdate").value;
	var  report_id='RLRRSENQ';
	var  p_module_id='RL';
	var report=document.getElementById("report").value;
	var server=document.getElementById("server").value;
	var copies=document.getElementById("copies").value;
	var queue_name=document.getElementById("queue_name").value;
	var  message=document.getElementById("message").value;
	var app_server_ip=document.getElementById("app_server_ip").value;
	var rep_server_key=document.getElementById("rep_server_key").value;
	var report_Server=document.getElementById("report_Server").value;
	var desformat=document.getElementById("desformat").value;
	var report_option=document.getElementById("report_option").value;
	var self_submit=document.getElementById("self_submit").value;
	var destype=document.getElementById("destype").value;
	var userid=document.getElementById("userid").value;
	
	var urlVal = "../../eOR/jsp/ExistingOrdersPrintResultPdf.jsp?accession_num="+accession_num+"&facilty="+facilty+"&login_user="+login_user+"&operating_facility_id="+operating_facility_id+"&facility_id="+facility_id+"&login_user="+login_user+"&report_id="+report_id+"&p_module_id="+p_module_id+"&eventCode="+event_code+"&session_id="+session_id+"&patient_id="+patient_id+"&machine_name="+machine_name+"&reqdate="+reqdate+"&p_language_id="+locale+"&Mode=ViewResult";
	$.ajax({		type: "Post",
		url	:	urlVal,
		data	: "",
		dataType:"text",
		async:false,
		success: function(data){
		},
		error: function(data){
		}
	});
	window.open(report_Server+"?"+"server="+server+"+"+"report="+report+"+"+"desformat="+desformat+"+"+"destype="+destype+"+"+"recursive_load=no"+"+"+"userid="+userid+"+"+"SELF_SUBMIT="+self_submit+"+"+"REPORT_OPTION="+report_option+"+"+"P_SPECIMEN_NO="+accession_num+"+"+"USER_ID="+login_user+"+"+"OPERATING_FACILITY_ID="+facilty+"+"+"FACILITY_ID="+facilty+"+"+"REQ_DATE="+reqdate+"+"+"SESSION_ID="+session_id+"+"+"P_LANGUAGE_ID="+locale+"+"+"P_REPORT_ID="+report_id+"+"+"P_MODULE_ID=" +p_module_id+ "+" + "P_LANGUAGE_ID="+locale)
}
//ml-mmoh-crf-1261.1 ends
//31792 starts 
async function NeonatalMotherSpecimenDetails(order_id,order_category,performing_facility_id,accession_num,patient_id,specimen_num)
{
	var dialogHeight ='10' ;
    var dialogWidth = '38' ;
    var dialogTop	= '129';
    var dialogLeft = '30' ;
	var title = '';		
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';

	var arguments = "";
		
	var retVals = await window.showModalDialog("../../eOR/jsp/NeoNatalMotherSpecimenDetails.jsp?p_order_id="+order_id+"&order_category="+order_category+"&p_performing_facility_id="+performing_facility_id+"&accession_num="+accession_num+"&patient_id="+patient_id+"&specimen_num="+specimen_num,arguments,features);
}
//31792 ends 
