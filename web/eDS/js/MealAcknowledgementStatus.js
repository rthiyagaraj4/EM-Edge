//New file MealAcknowledgementStatus.js created against ML-MMOH-CRF-1061
function apply() {
		var error ="";
		var formObj = parent.content.f_query_add_mod.MealAcknowledgementStatusForm;
		formObj.querySelector("#noOfStatusRequired_OP").disabled=false;
		formObj.querySelector("#noOfStatusRequired_IP").disabled=false;
	   	formObj.querySelector("#patient_class_OP").disabled=false;
		formObj.querySelector("#patient_class_IP").disabled=false;
		formObj.querySelector("#status_code1").disabled=false;
		formObj.querySelector("#status_code2").disabled=false;
		formObj.querySelector("#status_code3").disabled=false;
		formObj.querySelector("#served").disabled=false;
		formObj.querySelector("#accept").disabled=false;
		formObj.querySelector("#reject").disabled=false;
//		formObj.querySelector("status_desc1").disabled=false;
//		formObj.querySelector("status_desc2").disabled=false;
//		formObj.querySelector("status_desc3").disabled=false;
		formObj.querySelector("#MealPrepared").disabled=false;
		formObj.querySelector("#MealReceived").disabled=false;
		formObj.querySelector("#MealServed").disabled=false;
		formObj.querySelector("#MealRejected").disabled=false;
		formObj.querySelector("#status_code_MP").disabled=false;
		formObj.querySelector("#status_code_MR").disabled=false;
		formObj.querySelector("#status_code_MS").disabled=false;
		formObj.querySelector("#status_code_MJ").disabled=false;
//		formObj.querySelector("status_desc_MP").disabled=false;
//		formObj.querySelector("status_desc_MR").disabled=false;
//		formObj.querySelector("status_desc_MS").disabled=false;
//		formObj.querySelector("status_desc_MJ").disabled=false;
		formObj.querySelector("#facility_id").disabled=false;
		if (checkNull_OP() && checkNull_IP()) {
			formObj.method='post';
			formObj.action="../../servlet/eDS.MealAcknowledgeServlet";
			formObj.submit();
		}
	}

function changeStatus_OP()
{
	var noOfStatusRequired_OP = document.getElementById("noOfStatusRequired_OP").value;
	if(noOfStatusRequired_OP == '3'){
		document.getElementById("OP_served").style.visibility='visible'
		document.getElementById("OPstatus_Ser_YN").value="Y";
		document.getElementById("OP_accept").style.visibility='visible'
		document.getElementById("OP_reject").style.visibility='visible'
	}else if(noOfStatusRequired_OP == '2'){
		document.getElementById("OP_served").style.visibility='hidden'
		document.getElementById("OPstatus_Ser_YN").value="N";
		document.getElementById("OP_accept").style.visibility='visible'
		document.getElementById("OP_reject").style.visibility='visible'
	}
}

function changeStatus_IP()
{
	var noOfStatusRequired_IP = document.getElementById("noOfStatusRequired_IP").value;
	if(noOfStatusRequired_IP == '4'){
		document.getElementById("IP_MealPrepared").style.visibility='visible'
		document.getElementById("IPstatus_Pre_YN").value="Y";
		document.getElementById("IP_MealReceived").style.visibility='visible'
		document.getElementById("IPstatus_Rec_YN").value="Y";
		document.getElementById("IP_MealServed").style.visibility='visible'
		document.getElementById("IP_MealRejected").style.visibility='visible'
	}else if(noOfStatusRequired_IP == '3'){
		document.getElementById("IP_MealPrepared").style.visibility='hidden'
		document.getElementById("IPstatus_Pre_YN").value="N";
		document.getElementById("IP_MealReceived").style.visibility='visible'
		document.getElementById("IPstatus_Rec_YN").value="Y";
		document.getElementById("IP_MealServed").style.visibility='visible'
		document.getElementById("IP_MealRejected").style.visibility='visible'
	}else if(noOfStatusRequired_IP == '2'){
		document.getElementById("IP_MealPrepared").style.visibility='hidden'
		document.getElementById("IPstatus_Pre_YN").value="N";
		document.getElementById("IP_MealReceived").style.visibility='hidden'
		document.getElementById("IPstatus_Rec_YN").value="N";
		document.getElementById("IP_MealServed").style.visibility='visible'
		document.getElementById("IP_MealRejected").style.visibility='visible'
	}
	
}

function reset(){
 	  var formObj = parent.content.f_query_add_mod.MealAcknowledgementStatusForm;
	  f_query_add_mod.location.reload(); 
}

function checkNull_OP(){
		var formObj = parent.content.f_query_add_mod.MealAcknowledgementStatusForm;
		var noOfStatusRequired_OP=formObj.querySelector("#noOfStatusRequired_OP").value;
		var patient_class_OP=formObj.querySelector("#patient_class_OP").value;
		var served=formObj.querySelector("#served").value;
//		var served1=formObj.querySelector("status_desc1").value;
		var accept=formObj.querySelector("#accept").value;
		var reject=formObj.querySelector("#reject").value;
	if(patient_class_OP){
		if(served==""){
			if(noOfStatusRequired_OP == '3'){
				var error="Served cannot be blank";
				parent.content.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
			}
			if(noOfStatusRequired_OP == '2'){
				if(served=="" && accept==""){
					var error="Accept cannot be blank";
					parent.content.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
				}
				else if(served=="" && reject==""){
					var error="Reject cannot be blank";
					parent.content.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
				}
				else return served1;
			}
		}else if(accept==""){
			var error="Accept cannot be blank";
			parent.content.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
		}else if(reject==""){
			var error="Reject cannot be blank";
			parent.content.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
		}
		else return true;		
	}
}
function checkNull_IP(){
		var formObj = parent.content.f_query_add_mod.MealAcknowledgementStatusForm;
	 	var noOfStatusRequired_IP = formObj.querySelector("#noOfStatusRequired_IP").value;
		var patient_class_IP = formObj.querySelector("#patient_class_IP").value;
		var MealPrepared = formObj.querySelector("#MealPrepared").value;
		var MealReceived = formObj.querySelector("#MealReceived").value;
		var MealServed = formObj.querySelector("#MealServed").value;
		var MealRejected = formObj.querySelector("#MealRejected").value;
//		var MealPrepared1 = formObj.querySelector("status_desc_MP").value;
//		var MealReceived1 = formObj.querySelector("status_desc_MR").value;
	if(patient_class_IP){
		if(MealPrepared==""){
			if(noOfStatusRequired_IP == '4'){
				var error="Meal Prepared cannot be blank";
				parent.content.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
			}
			if(noOfStatusRequired_IP == '3'){
				if(MealPrepared=="" && MealReceived==""){
					var error="Meal Received cannot be blank";
					parent.content.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
				}
				else if(MealPrepared=="" && MealServed==""){
					var error="Meal Served cannot be blank";
					parent.content.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
				}
				else if(MealPrepared=="" && MealRejected==""){
					var error="Meal Rejected cannot be blank";
					parent.content.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
				}
				else return MealPrepared1;
			}
			if(noOfStatusRequired_IP == '2'){ 
				if(MealPrepared=="" && MealServed==""){
					var error="Meal Served cannot be blank";
					parent.content.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
				}
				else if(MealPrepared=="" && MealRejected==""){
					var error="Meal Rejected cannot be blank";
					parent.content.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
				}
				else return MealPrepared1;
			}
		}
		else if(MealReceived==""){
			if(noOfStatusRequired_IP == '4'){
				var error="Meal Received cannot be blank";
				parent.content.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
			}
			if(noOfStatusRequired_IP == '3'){
				if(MealReceived=="" && MealServed==""){
					var error="Meal Received cannot be blank";
					parent.content.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
				}
				else if(MealReceived=="" && MealRejected==""){
					var error="Meal Rejected cannot be blank";
					parent.content.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
				}
				else return MealReceived1;
			}
			if(noOfStatusRequired_IP == '2'){
				if(MealReceived=="" && MealServed==""){
					var error="Meal Served cannot be blank";
					parent.content.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
				}
				else if(MealReceived=="" && MealRejected==""){
					var error="Meal Rejected cannot be blank";
					parent.content.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
				}
				else return MealReceived1;
			}
		}else if(MealServed==""){
			var error="Meal Served cannot be blank";
			parent.content.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
		}else if(MealRejected==""){
			var error="Meal Rejected cannot be blank";
			parent.content.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
		}			
		else return true; 
	}
} 
