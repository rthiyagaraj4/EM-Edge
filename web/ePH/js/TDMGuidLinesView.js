async function callMenuFunctionsFromTDM(colval1,colval,orderId,sex,patient_id){
	    var dialogHeight ='37vh' ;
	    var dialogWidth = '48vw' ;
	    var dialogTop	= '129';
	    var dialogLeft = '11' ;
	    var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';
	    var arguments = "";
		ord_cat_code = "PH";
	    var finalString	= "colval1="+colval1+ "&colval=" +escape(colval)+"&orderId="+ orderId+"&sex="+ sex+"&patient_id="+ patient_id+"&ord_cat_code="+ord_cat_code; 
	    var retVals = await window.showModalDialog("../../eOR/jsp/ExistingOrderTasks.jsp?"+finalString,arguments,features);
}
async function resultViewOrderFromTDM(colval1,colval,orderId,order_line_num,cont_order_ind,patient_id, ord_cat){

		var dialogHeight ='40vh' ;
		var dialogWidth = '55vw' ;
		var dialogTop	= '129';
		var dialogLeft = '11' ;

		if((screen.width==800) && (screen.height==600)){
			dialogHeight   = "46vh" ;
			dialogTop	= '129';
			dialogLeft = '11' ;
		}else{			
			dialogHeight   = "50vh" ;
			dialogTop	= '145';
			dialogLeft = '11' ;
		}

		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';

		var arguments = "";
		var ord_cat_code  = "PH";
		var finalString	= "colval1="+colval1+ "&colval=" +colval+"&orderId="+ orderId+"&order_line_num="+ order_line_num+"&cont_order_ind="+cont_order_ind+"&patient_id="+patient_id+"&ord_cat="+ord_cat+"&ord_cat_code="+ord_cat_code;
		var retVals = await window.showModalDialog("../../eOR/jsp/ExistingOrderTasks.jsp?"+finalString,arguments,features);
}
function chkTdmAttributes(){
	alert(getMessage("PH_TDM_ATTR_NOT_RECORDED","PH"));
	window.close();
}
async function callWindow(drug_code,patient_id,order_id,type) {
	
	    var dialogHeight			= "43vh";
		var dialogWidth				= "70vw";
		var dialogTop				= "50";
		var dialogLeft				= "200";
		var center					= "1";
		var status					= "no";
		var scrolling               = "yes";
		if(order_id==null)
			order_id="";
		if((order_id=="") && (type=="D"))
		{
			
			var dialogHeight			= "32vh";
			var dialogWidth				= "70vw";
			var dialogTop				= "100";
			var dialogLeft				= "200";
			var center					= "1";
			
			var status					= "no";
			var scrolling               ="yes";
			var features				= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop +";scroll:"+scrolling; 
			var arguments               = "";
			retVal = await window.showModalDialog("../../ePH/jsp/TDMGuidLinesView.jsp?drug_code="+drug_code+"&patient_id="+patient_id+"&order_id="+order_id+"&type="+type+"&identity=callWindow", arguments, features);
			return retVal;
		}else{
			
			var features				= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop +";scroll:"+scrolling;
			var arguments  = "";
			retVal = await window.showModalDialog("../../ePH/jsp/TDMGuidLinesView.jsp?drug_code="+drug_code+"&patient_id="+patient_id+"&order_id="+order_id+"&type="+type+"&identity=callOrdWindow", arguments, features);
			return retVal;
		}
}
async function showAdminWindow(time)
{

    var dialogHeight ='40vh' ;
    var dialogWidth = '60vh' ;
	var dialogTop	= '190';
	var dialogLeft  = '240';
	var center			= "1" ;
	var status			="no";
	var scrolling       ="no";
	var features		= "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status +";scroll:"+scrolling + "; dialogTop :" + dialogTop;
	var arguments		= "" ;
	 retVal = await window.showModalDialog("../../ePH/jsp/TDMDosageDetails.jsp?time="+time, arguments,features);
}






