	
	function create() {
		var formObj = document.forms[0];
		var params = formObj.params.value;
		f_query_add_mod.location.href="../../eDS/jsp/MealTypeAddModify.jsp?"+params+"&mode=insert";
	}
	
	function apply() {
		var frm=f_query_add_mod.document.forms[0];
		var fields = new Array (f_query_add_mod.document.forms[0].meal_Type,f_query_add_mod.document.forms[0].long_Desc,f_query_add_mod.document.forms[0].short_Desc,f_query_add_mod.document.forms[0].order_no);
		var mealType=getLabel("eOT.MealType.Label","ot");
		var longDesc=getLabel("eOT.LongDescription.Label","ot");
		var shortDesc=getLabel("eOT.ShortDescription.Label","ot");
		var order = getLabel("eOT.Order.Label","ot");
		
		//ML-MMOH-CRF-409 STARTS
		var ServingStartTime=f_query_add_mod.document.forms[0].ServingStartTime.value;
		var ServingEndTime=f_query_add_mod.document.forms[0].ServingEndTime.value;
		var IrregularStartTime=f_query_add_mod.document.forms[0].IrregularStartTime.value;
		var IrregularEndTime=f_query_add_mod.document.forms[0].IrregularEndTime.value;
		var order_no=f_query_add_mod.document.forms[0].order_no.value;
		var acceptDietForIndMealYn=f_query_add_mod.document.forms[0].acceptDietForIndMealYn.value;
		var irregular_diet_ord_yn=f_query_add_mod.document.forms[0].irregular_diet_ord_yn.value;			
		//ML-MMOH-CRF-409 ENDS		
		/* Added Against Start ML-MMOH-CRF-825  */		
		var OpServingStartTime=frm.OpServingStartTime.value;
		var OpServingEndTime=frm.OpServingEndTime.value;
		var OpIrregularStartTime=frm.OpIrregularStartTime.value;
		var OpIrregularEndTime=frm.OpIrregularEndTime.value;
		
	 	var EmServingStartTime=frm.EmServingStartTime.value;
		var EmServingEndTime=frm.EmServingEndTime.value;
		var EmIrregularStartTime=frm.EmIrregularStartTime.value;
		var EmIrregularEndTime=frm.EmIrregularEndTime.value;
		
		var SupplementServingStartTime=frm.SupplementServingStartTime.value;
		var SupplementServingEndTime=frm.SupplementServingEndTime.value;
		var SupplementIrregularStartTime=frm.SupplementIrregularStartTime.value;
		var SupplementIrregularEndTime=frm.SupplementIrregularEndTime.value;
		
		var DocServingStartTime=frm.DocServingStartTime.value;
		var DocServingEndTime=frm.DocServingEndTime.value;
		var DocIrregularStartTime=frm.DocIrregularStartTime.value;
		var DocIrregularEndTime=frm.DocIrregularEndTime.value;
		
		var OpsServingStartTime=frm.OpsServingStartTime.value;
		var OpsServingEndTime=frm.OpsServingEndTime.value;
		var OpsIrregularStartTime=frm.OpsIrregularStartTime.value;
		var OpsIrregularEndTime=frm.OpsIrregularEndTime.value;
		
		var OncServingStartTime=frm.OncServingStartTime.value;
		var OncServingEndTime=frm.OncServingEndTime.value;
		var OncIrregularStartTime=frm.OncIrregularStartTime.value;
		var OncIrregularEndTime=frm.OncIrregularEndTime.value;
		
		var StaffServingStartTime=frm.StaffServingStartTime.value;
		var StaffServingEndTime=frm.StaffServingEndTime.value;
		var StaffIrregularStartTime=frm.StaffIrregularStartTime.value;
		var StaffIrregularEndTime=frm.StaffIrregularEndTime.value;
		
		var StudentServingStartTime=frm.StudentServingStartTime.value;
		var StudentServingEndTime=frm.StudentServingEndTime.value;
		var StudentIrregularStartTime=frm.StudentIrregularStartTime.value;
		var StudentIrregularEndTime=frm.StudentIrregularEndTime.value; 	
		/* Added Against End ML-MMOH-CRF-825 */
	
		var names = new Array ( mealType,longDesc,shortDesc,order);
		if(checkFieldsofMst( fields, names, messageFrame)) 
			{	
				//IN::39910
	if(!(f_query_add_mod.document.forms[0].order_no.disabled)){
		if((CheckConstraint(f_query_add_mod.document.forms[0].order_no))){
		//ML-MMOH-CRF-409 STARTS (Checking whether the serving start_time and serving end_time overlapse with any other order_no)						
			if(checkMealTimeOverLap(ServingStartTime,ServingEndTime,IrregularStartTime,IrregularEndTime,order_no ,OpServingStartTime,OpServingEndTime,OpIrregularStartTime,OpIrregularEndTime,EmServingStartTime,EmServingEndTime,EmIrregularStartTime,EmIrregularEndTime,SupplementServingStartTime,SupplementServingEndTime,SupplementIrregularStartTime,SupplementIrregularEndTime,DocServingStartTime,DocServingEndTime,DocIrregularStartTime,DocIrregularEndTime,OpsServingStartTime,OpsServingEndTime,OpsIrregularStartTime,OpsIrregularEndTime,OncServingStartTime,OncServingEndTime,OncIrregularStartTime,OncIrregularEndTime,StaffServingStartTime,StaffServingEndTime,StaffIrregularStartTime,StaffIrregularEndTime,StudentServingStartTime,StudentServingEndTime,StudentIrregularStartTime,StudentIrregularEndTime)){
							/* Commented Against ML-MOH-CRF-825
							if(acceptDietForIndMealYn!="Y" || irregular_diet_ord_yn!="Y"){
								f_query_add_mod.document.forms[0].ServingStartTime.disabled=false;
								f_query_add_mod.document.forms[0].ServingEndTime.disabled=false;
								f_query_add_mod.document.forms[0].IrregularStartTime.disabled=false;
								f_query_add_mod.document.forms[0].IrregularEndTime.disabled=false;
							}	
							*/					
						//ML-MMOH-CRF-409 ENDS
						f_query_add_mod.document.forms[0].submit();
			}
			else{
				return false;
				//break;
				}
		} //2nd if close
		else{
				return false;
		}
		} //1st if-end 
		else
		{
					if(checkMealTimeOverLap(ServingStartTime,ServingEndTime,IrregularStartTime,IrregularEndTime,order_no,OpServingStartTime,OpServingEndTime,OpIrregularStartTime,OpIrregularEndTime,EmServingStartTime,EmServingEndTime,EmIrregularStartTime,EmIrregularEndTime,SupplementServingStartTime,SupplementServingEndTime,SupplementIrregularStartTime,SupplementIrregularEndTime,DocServingStartTime,DocServingEndTime,DocIrregularStartTime,DocIrregularEndTime,OpsServingStartTime,OpsServingEndTime,OpsIrregularStartTime,OpsIrregularEndTime,OncServingStartTime,OncServingEndTime,OncIrregularStartTime,OncIrregularEndTime,StaffServingStartTime,StaffServingEndTime,StaffIrregularStartTime,StaffIrregularEndTime,StudentServingStartTime,StudentServingEndTime,StudentIrregularStartTime,StudentIrregularEndTime)){
					/* Commented Against ML-MOH-CRF-825
					if(acceptDietForIndMealYn!="Y" || irregular_diet_ord_yn!="Y"){
								f_query_add_mod.document.forms[0].ServingStartTime.disabled=false;
								f_query_add_mod.document.forms[0].ServingEndTime.disabled=false;
								f_query_add_mod.document.forms[0].IrregularStartTime.disabled=false;
								f_query_add_mod.document.forms[0].IrregularEndTime.disabled=false;
							} */
					f_query_add_mod.document.forms[0].submit();
					}else{
						return false;
						//break;
					}
				}
			}
		}
	
	
	
	function query() {
		var formObj = document.forms[0];
		var params = formObj.params.value;
		commontoolbarFrame.document.forms[0].apply.disabled=true;
		f_query_add_mod.location.href="../../eDS/jsp/MealTypeQueryCriteria.jsp?"+params;
	}	
 	 
	 function reset(){
		 if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("MealTypeAddModify.jsp") != -1){

			 if(f_query_add_mod.document.location.href.indexOf("MealTypeMain.jsp") != -1)
				  return false;
			 else
				 f_query_add_mod.document.location.reload();
		 }
		 else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("MealTypeQueryCriteria.jsp") != -1)
		 {
			 f_query_add_mod.document.forms[0].reset();
		 }
	}
		
	function setFieldToUpperCase(obj) {
		obj.value = obj.value.toUpperCase();
		return obj;
	}
	
	function checkAlpha(event){
		var strCheck = '~!@#$%^&*()+=`{}|[]<>"\'';
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);  
		if (strCheck.indexOf(key) != -1) return false;  
		return true ;
	}
	
	function onSuccess()
	{
		var formObj = document.forms[0];
		var params = formObj.params.value;
		if(f_query_add_mod.document.forms[0].mode.value=="insert")
			f_query_add_mod.location.href="../../eDS/jsp/MealTypeAddModify.jsp?"+params+"&mode=insert";
		else
	         f_query_add_mod.location.reload();

	}
	
	function CheckPosNumber(obj) {
	    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {
	        return true;
	    }
	    else {
	        if ( obj.value.length > 0 ) {

	            alert(getMessage("NUM_ALLOWED", "SM"));
	            document.getElementById("order_no").value = "";
	            return false;
	        }
	    }
	}
	
	function localTrimString(sInString) {
		  return sInString.replace(/^\s+|\s+$/g,"");
		}
	
	function CheckConstraint(obj){
		if(obj.value>0){
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			var param="func_mode=chkOrderEntry&order="+obj.value;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","../../eDS/jsp/DLCommonValidation.jsp?"+param,false);
			xmlHttp.send(xmlDoc);
			var retVal = localTrimString(xmlHttp.responseText);	
			var msgframe = "";
			//IN::39910
			if(parent.messageFrame)
				msgframe = parent.messageFrame;
			else
				msgframe = messageFrame;
			if(retVal>0){
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+"Duplicate Order Number" ;
				return false ;
			}
			else{
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+"" ;
			    return true ;
			}
		}
	}
	//ML-MMOH-CRF-409 Starts	
	
	function enableDisabletextField(obj1,obj2){		
		var start_time=$("#"+obj1).val();
		var end_time=$("#"+obj2).val();
		if(start_time.length=="5" && end_time.length=="5"){ //enable
			if($('#ServingStartTime').val()!=""){
			$('#IrregularStartTime').prop('disabled', false);
			$('#IrregularEndTime').prop('disabled', false);
			}
			if($('#OpServingStartTime').val()!=""){
			$('#OpIrregularStartTime').prop('disabled', false);
			$('#OpIrregularEndTime').prop('disabled', false);
			}
			if($('#EmServingStartTime').val()!=""){
			$('#EmIrregularStartTime').prop('disabled', false);
			$('#EmIrregularEndTime').prop('disabled', false);
			}
			if($('#SupplementServingStartTime').val()!=""){
			$('#SupplementIrregularStartTime').prop('disabled', false);
			$('#SupplementIrregularEndTime').prop('disabled', false);
			}
			if($('#DocServingStartTime').val()!=""){
			$('#DocIrregularStartTime').prop('disabled', false);
			$('#DocIrregularEndTime').prop('disabled', false);
			}
			if($('#OpsServingStartTime').val()!=""){
			$('#OpsIrregularStartTime').prop('disabled', false);
			$('#OpsIrregularEndTime').prop('disabled', false);
			}
			if($('#OncServingStartTime').val()!=""){
			$('#OncIrregularStartTime').prop('disabled', false);
			$('#OncIrregularEndTime').prop('disabled', false);
			}
			if($('#StaffServingStartTime').val()!=""){
			$('#StaffIrregularStartTime').prop('disabled', false);
			$('#StaffIrregularEndTime').prop('disabled', false);
			}
			if($('#StudentServingStartTime').val()!=""){
			$('#StudentIrregularStartTime').prop('disabled', false);
			$('#StudentIrregularEndTime').prop('disabled', false);
			}			
		}else{
			if($('#ServingEndTime').val()=="" || $('#ServingStartTime').val()==""){ //disable
			$('#IrregularStartTime').prop('disabled', true);
			$('#IrregularEndTime').prop('disabled', true);
			}
			if($('#OpServingEndTime').val()=="" || $('#OpServingStartTime').val()==""){
			$('#OpIrregularStartTime').prop('disabled', true);
			$('#OpIrregularEndTime').prop('disabled', true);
			}
			if($('#EmServingEndTime').val()=="" || $('#EmServingStartTime').val()==""){
			$('#EmIrregularStartTime').prop('disabled', true);
			$('#EmIrregularEndTime').prop('disabled', true);
			}
			if($('#SupplementServingEndTime').val()=="" || $('#SupplementServingStartTime').val()==""){
			$('#SupplementIrregularStartTime').prop('disabled', true);
			$('#SupplementIrregularEndTime').prop('disabled', true);
			}
			if($('#DocServingEndTime').val()=="" || $('#DocServingStartTime').val()==""){
			$('#DocIrregularStartTime').prop('disabled', true);
			$('#DocIrregularEndTime').prop('disabled', true);
			}
			if($('#OpsServingEndTime').val()=="" || $('#OpsServingStartTime').val()==""){
			$('#OpsIrregularStartTime').prop('disabled', true);
			$('#OpsIrregularEndTime').prop('disabled', true);
			}
			if($('#OncServingEndTime').val()=="" || $('#OncServingStartTime').val()==""){
			$('#OncIrregularStartTime').prop('disabled', true);
			$('#OncIrregularEndTime').prop('disabled', true);
			}
			if($('#StaffServingEndTime').val()=="" || $('#StaffServingStartTime').val()==""){
			$('#StaffIrregularStartTime').prop('disabled', true);
			$('#StaffIrregularEndTime').prop('disabled', true);
			}
			if($('#StudentServingEndTime').val()=="" || $('#StudentServingStartTime').val()==""){
			$('#StudentIrregularStartTime').prop('disabled', true);
			$('#StudentIrregularEndTime').prop('disabled', true);
			}
				
		}		
}
	
function formatTime(obj) {
    	var result = false, m;	
    	var re = /^\s*([01]?\d|2[0-3]):?([0-5]\d)\s*$/;	
		var time=$("#"+obj.name).val();	
		var msgframe = "";
	if(parent.messageFrame)
		msgframe = parent.messageFrame;
	else
		msgframe = messageFrame;
	if(time!="null" && time!="" && time!="undefined"){
		if((m = time.match(re))){
			result = (m[1].length === 2 ? "" : "0") + m[1] + ":" + m[2];
		}
		if(result==false ){	
			var msg=getMessage("DS_INVAL_TIMEFORMAT","DS");
			msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg ;
			$("#"+obj.name).focus();
			$("#"+obj.name).select();
			return false;
		}else{
			var msg="";
			msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg ;
			return true;
		}
	}
}
function isValidTime(obj){
	var formObj = document.forms[0];
	var retVal=true;
	var from_time=obj.value
	var splt_from_dur=from_time.split(":");

if(from_time!=''){
	if(from_time.length!="5"){
		//alert(getMessage("APP-OT0040","OT"));
		alert(getMessage("APP-OT0130","OT"));
		obj.value="";
		obj.select();
		obj.focus()
		return;
	}
	if(splt_from_dur[0].length!=2 ||splt_from_dur[1].length!=2 ){
		alert(getMessage("APP-OT0130","OT"));
		obj.value="";
		obj.select();
		obj.focus()
		return;
	}
}

	var RE_EXP =/^(0[0-9]|1[0-9]|2[0-3]):(0[0-9]|[12345][0-9])$/;
	if(obj.value!="" && !RE_EXP.test(obj.value) ){
		var err_text="";
	    var time = obj.value;
	    var arr_time =  time.split(":")
        if(arr_time.length!=2 || arr_time[1]=='' || arr_time[0]==''){
			//cal_error("Invalid Time format! Allowed Format is HH24:MI",obj);
			cal_error(getMessage("VALID_TIME_SLOTS","OT"),obj);
		}

		if(arr_time[0]<0 || arr_time[0]>23 || arr_time[1]<0 || arr_time[1]>59 ){
			//err_text+= "Invalid Hours! Allowed Hours 00 - 23\n";
			err_text+=getMessage("APP-OT0040","OT");
		}

		if(err_text.length>0)
			retVal=false;
			cal_error(err_text,obj);
			obj.value="";
			obj.select();
			obj.focus()
		}

	return retVal;


}
//ML-MMOH-CRF-409 Starts
function compareTime(obj1,obj2,field)
{	
	var start_time=obj1;
	var end_time=obj2;	
	var msgframe = "";
	var msg="";
	if(parent.messageFrame)
		msgframe = parent.messageFrame;
	else
		msgframe = messageFrame;
	if(start_time.length=="5" && end_time.length=="5"){
			start_time=wrapTime(start_time);
			end_time=wrapTime(end_time);	
			if(start_time>end_time){
			if(field=="ServingStartTime"){
				msg="Serving Start Time Cannot be Greater than End Time";
			}else if(field=="IrregularStartTime"){
				msg="Late/Irregular Start Time Cannot be Greater than End Time";
			}
			//Added Against ML-ML-MMOH-CRF-825 Starts
			// OP start
			if(field=="OpServingStartTime"){
				msg="OP Serving Start Time Cannot be Greater than End Time";
			}else if(field=="OpIrregularStartTime"){
				msg="Op Late/Irregular Start Time Cannot be Greater than End Time";

			}
			// Op end
			// EM start
			if(field=="EmServingStartTime"){
				msg="EM Serving Start Time Cannot be Greater than End Time";

			}else if(field=="EmIrregularStartTime"){
				msg="EM Late/Irregular Start Time Cannot be Greater than End Time";

			}
			// EM end
			// Supplement start
			if(field=="SupplementServingStartTime"){
				msg="SUP Serving Start Time Cannot be Greater than End Time";

			}else if(field=="SupplementIrregularStartTime"){
				msg="SUP Late/Irregular Start Time Cannot be Greater than End Time";

			}
			// Supplement end
			// DOC start
			if(field=="DocServingStartTime"){
				msg="DOC Serving Start Time Cannot be Greater than End Time";

			}else if(field=="DocIrregularStartTime"){
				msg="DOC Late/Irregular Start Time Cannot be Greater than End Time";

			}
			// DOC end
			// OPS start
			if(field=="OpsServingStartTime"){
				msg="OPS Serving Start Time Cannot be Greater than End Time";

			}else if(field=="OpsIrregularStartTime"){
				msg="OPS Late/Irregular Start Time Cannot be Greater than End Time";

			}
			// OPS end
			// OnCall start
			if(field=="OncServingStartTime"){
				msg="ONC Serving Start Time Cannot be Greater than End Time";

			}else if(field=="OncIrregularStartTime"){
				msg="ONC Late/Irregular Start Time Cannot be Greater than End Time";

			}
			// OnCall end
			// Staff start
			if(field=="StaffServingStartTime"){
				msg="STF Serving Start Time Cannot be Greater than End Time";

			}else if(field=="StaffIrregularStartTime"){
				msg="STF Late/Irregular Start Time Cannot be Greater than End Time";

			}
			// Staff end
			// Student start
			if(field=="StudentServingStartTime"){
				msg="STU Serving Start Time Cannot be Greater than End Time";

			}else if(field=="StudentIrregularStartTime"){
				msg="STU Late/Irregular Start Time Cannot be Greater than End Time";

			}
			// Student end
			//Added Against ML-ML-MMOH-CRF-825 End
			
			messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
				
	if(field=="ServingStartTime"){
			f_query_add_mod.document.forms[0].ServingStartTime.focus();
			f_query_add_mod.document.forms[0].ServingStartTime.select();
	}else if(field=="IrregularStartTime"){
			f_query_add_mod.document.forms[0].IrregularStartTime.focus();
			f_query_add_mod.document.forms[0].IrregularStartTime.select();
	}
	//Added Against ML-ML-MMOH-CRF-825 Starts Here
	// Op start
	if(field=="OpServingStartTime"){
			f_query_add_mod.document.forms[0].OpServingStartTime.focus();
			f_query_add_mod.document.forms[0].OpServingStartTime.select();
	}else if(field=="OpIrregularStartTime"){
			f_query_add_mod.document.forms[0].OpIrregularStartTime.focus();
			f_query_add_mod.document.forms[0].OpIrregularStartTime.select();
	}
	// Op end		
	// EM start
	if(field=="EmServingStartTime"){
			f_query_add_mod.document.forms[0].EmServingStartTime.focus();
			f_query_add_mod.document.forms[0].EmServingStartTime.select();
	}else if(field=="EmIrregularStartTime"){
			f_query_add_mod.document.forms[0].EmIrregularStartTime.focus();
			f_query_add_mod.document.forms[0].EmIrregularStartTime.select();
	}
	// EM end
	// Sup start
	if(field=="SupplementServingStartTime"){
			f_query_add_mod.document.forms[0].SupplementServingStartTime.focus();
			f_query_add_mod.document.forms[0].SupplementServingStartTime.select();
	}else if(field=="SupplementIrregularStartTime"){
			f_query_add_mod.document.forms[0].SupplementIrregularStartTime.focus();
			f_query_add_mod.document.forms[0].SupplementIrregularStartTime.select();
	}
	// Sup end
	// DOC start
	if(field=="DocServingStartTime"){
			f_query_add_mod.document.forms[0].DocServingStartTime.focus();
			f_query_add_mod.document.forms[0].DocServingStartTime.select();
	}else if(field=="DocIrregularStartTime"){
			f_query_add_mod.document.forms[0].DocIrregularStartTime.focus();
			f_query_add_mod.document.forms[0].DocIrregularStartTime.select();
	}
	// DOC end
	// OPS start
	if(field=="OpsServingStartTime"){
			f_query_add_mod.document.forms[0].OpsServingStartTime.focus();
			f_query_add_mod.document.forms[0].OpsServingStartTime.select();
	}else if(field=="OpsIrregularStartTime"){
			f_query_add_mod.document.forms[0].OpsIrregularStartTime.focus();
			f_query_add_mod.document.forms[0].OpsIrregularStartTime.select();
	}
	// OPS end
	// OCN start
	if(field=="OncServingStartTime"){
			f_query_add_mod.document.forms[0].OncServingStartTime.focus();
			f_query_add_mod.document.forms[0].OncServingStartTime.select();
	}else if(field=="OncIrregularStartTime"){
			f_query_add_mod.document.forms[0].OncIrregularStartTime.focus();
			f_query_add_mod.document.forms[0].OncIrregularStartTime.select();
	}
	// OCN end
	// STF start
	if(field=="StaffServingStartTime"){
			f_query_add_mod.document.forms[0].StaffServingStartTime.focus();
			f_query_add_mod.document.forms[0].StaffServingStartTime.select();
	}else if(field=="StaffIrregularStartTime"){
			f_query_add_mod.document.forms[0].StaffIrregularStartTime.focus();
			f_query_add_mod.document.forms[0].StaffIrregularStartTime.select();
	}
	// STF end
	// STU start
	if(field=="StudentServingStartTime"){
			f_query_add_mod.document.forms[0].StudentServingStartTime.focus();
			f_query_add_mod.document.forms[0].StudentServingStartTime.select();
	}else if(field=="StudentIrregularStartTime"){
			f_query_add_mod.document.forms[0].StudentIrregularStartTime.focus();
			f_query_add_mod.document.forms[0].StudentIrregularStartTime.select();
	}
	// STU end
	//Added Against ML-ML-MMOH-CRF-825 Ends Here
	return false;
	}else{
		msg="";		
		messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		return true;
	}
	}
	else{	
		msg="";
		messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		return true;
	}
}

function wrapTime(str){
	var now  = new Date();
	//IN059019
	if(str==""){
		str="24:00";
	}
	//IN059019
	var arr = str.split(":");
	var date = new Date(now.getFullYear() , now.getMonth(),now.getDate(), arr[0], arr[1], "00");
	return date
}

function addSubTime(time,mode)
{
	
	var obj=wrapTime(time);
	if(mode=="increment")
	{
		obj.setSeconds(obj.getSeconds() + 60);
	}else if(mode="decrement"){
		obj.setSeconds(obj.getSeconds() - 60);
	}
	
	var hr=obj.getHours();
	var mi=obj.getMinutes();
	if(hr<9){
		hr="0"+hr;
	}
	if(mi<9)
	{
		mi="0"+mi;
	}		
	return (""+hr+":"+mi);
	
}

function checkMealTimeOverLap(ServingStartTime,ServingEndTime,IrregularStartTime,IrregularEndTime,order_no, OpServingStartTime,OpServingEndTime,OpIrregularStartTime,OpIrregularEndTime,EmServingStartTime,EmServingEndTime,EmIrregularStartTime,EmIrregularEndTime,SupplementServingStartTime,SupplementServingEndTime,SupplementIrregularStartTime,SupplementIrregularEndTime,DocServingStartTime,DocServingEndTime,DocIrregularStartTime,DocIrregularEndTime,OpsServingStartTime,OpsServingEndTime,OpsIrregularStartTime,OpsIrregularEndTime,OncServingStartTime,OncServingEndTime,OncIrregularStartTime,OncIrregularEndTime,StaffServingStartTime,StaffServingEndTime,StaffIrregularStartTime,StaffIrregularEndTime,StudentServingStartTime,StudentServingEndTime,StudentIrregularStartTime,StudentIrregularEndTime)
{
	
	var flag=compareTime(ServingStartTime,ServingEndTime,'ServingStartTime')
	if(flag==true){
		flag=compareTime(IrregularStartTime,IrregularEndTime,'IrregularStartTime')
	}
	if(ServingStartTime=="" && ServingEndTime=="" && IrregularStartTime!="" && IrregularEndTime!=""){
		
		flag=window.confirm(getMessage("DS_AUTOMATIC_REMOVE_IRREGULAR_TIME","DS"));		
	}
	/* Added Againt Start ML-MOH-CRF-825*/
	/* OP Validation Start */
	if(flag==true){
		var flag=compareTime(OpServingStartTime,OpServingEndTime,'OpServingStartTime')
		if(flag==true){
			flag=compareTime(OpIrregularStartTime,OpIrregularEndTime,'OpIrregularStartTime')
		}
		if(OpServingStartTime=="" && OpServingEndTime=="" && OpIrregularStartTime!="" && OpIrregularEndTime!=""){
			flag=window.confirm("OP Serving Start/End Time has been removed. Saving the meal type without Serving Start/End Time will automatically remove the Late/Irregular Diet Order Start/End Time. Do you wish to continue?");		
		}
	}
	/* OP Validation End */
	/* EM Validation Start */
	if(flag==true){
		var flag=compareTime(EmServingStartTime,EmServingEndTime,'EmServingStartTime')
		if(flag==true){
			flag=compareTime(EmIrregularStartTime,EmIrregularEndTime,'EmIrregularStartTime')
		}
		if(EmServingStartTime=="" && EmServingEndTime=="" && EmIrregularStartTime!="" && EmIrregularEndTime!=""){
			
			flag=window.confirm("EM Serving Start/End Time has been removed. Saving the meal type without Serving Start/End Time will automatically remove the Late/Irregular Diet Order Start/End Time. Do you wish to continue?");		
		}
	}
	/* EM Validation End */
	/* Supplement Validation Start*/
	if(flag==true){
		var flag=compareTime(SupplementServingStartTime,SupplementServingEndTime,'SupplementServingStartTime')
		if(flag==true){
			flag=compareTime(SupplementIrregularStartTime,SupplementIrregularEndTime,'SupplementIrregularStartTime')
		}
		if(SupplementServingStartTime=="" && SupplementServingEndTime=="" && SupplementIrregularStartTime!="" && SupplementIrregularEndTime!=""){		
			flag=window.confirm("Supplement Serving Start/End Time has been removed. Saving the meal type without Serving Start/End Time will automatically remove the Late/Irregular Diet Order Start/End Time. Do you wish to continue?");		
		}
	}
	/* Supplement Validation End */
	/* Doctor On-Call Validation Start*/
	if(flag==true){
		var flag=compareTime(DocServingStartTime,DocServingEndTime,'DocServingStartTime')
		if(flag==true){
			flag=compareTime(DocIrregularStartTime,DocIrregularEndTime,'DocIrregularStartTime')
		}
		if(DocServingStartTime=="" && DocServingEndTime=="" && DocIrregularStartTime!="" && DocIrregularEndTime!=""){	
			flag=window.confirm("Doctor On-Call Serving Start/End Time has been removed. Saving the meal type without Serving Start/End Time will automatically remove the Late/Irregular Diet Order Start/End Time. Do you wish to continue?");		
		}
	}
	/* Doctor On-Call Validation End */
	/* OT/Paramedic Staff Validation Start*/
	if(flag==true){
		var flag=compareTime(OpsServingStartTime,OpsServingEndTime,'OpsServingStartTime')
		if(flag==true){
			flag=compareTime(OpsIrregularStartTime,OpsIrregularEndTime,'OpsIrregularStartTime')
		}
		if(OpsServingStartTime=="" && OpsServingEndTime=="" && OpsIrregularStartTime!="" && OpsIrregularEndTime!=""){	
			flag=window.confirm("OT/Paramedic Staff Serving Start/End Time has been removed. Saving the meal type without Serving Start/End Time will automatically remove the Late/Irregular Diet Order Start/End Time. Do you wish to continue?");		
		}
	}
	/* OT/Paramedic Staff Validation End */
	/* On Call Staff  Validation Start*/
	if(flag==true){
		var flag=compareTime(OncServingStartTime,OncServingEndTime,'OncServingStartTime')
		if(flag==true){
			flag=compareTime(OncIrregularStartTime,OncIrregularEndTime,'OncIrregularStartTime')
		}
		if(OncServingStartTime=="" && OncServingEndTime=="" && OncIrregularStartTime!="" && OncIrregularEndTime!=""){
			flag=window.confirm("On Call Staff Serving Start/End Time has been removed. Saving the meal type without Serving Start/End Time will automatically remove the Late/Irregular Diet Order Start/End Time. Do you wish to continue?");		
		}
	}
	/* On Call Staff Validation End */
	/* Staff Validation Start*/
	if(flag==true){
		var flag=compareTime(StaffServingStartTime,StaffServingEndTime,'StaffServingStartTime')
		if(flag==true){
			flag=compareTime(StaffIrregularStartTime,StaffIrregularEndTime,'StaffIrregularStartTime')
		}
		if(StaffServingStartTime=="" && StaffServingEndTime=="" && StaffIrregularStartTime!="" && StaffIrregularEndTime!=""){	
			flag=window.confirm("Staff Serving Start/End Time has been removed. Saving the meal type without Serving Start/End Time will automatically remove the Late/Irregular Diet Order Start/End Time. Do you wish to continue?");		
		}
	}
	/* Staff Validation End */
	/* Students Validation Start*/
	if(flag==true){
		var flag=compareTime(StudentServingStartTime,StudentServingEndTime,'StudentServingStartTime')
		if(flag==true){
			flag=compareTime(StudentIrregularStartTime,StudentIrregularEndTime,'StudentIrregularStartTime')
		}
		if(StudentServingStartTime=="" && StudentServingEndTime=="" && StudentIrregularStartTime!="" && StudentIrregularEndTime!=""){
			flag=window.confirm("Students Serving Start/End Time has been removed. Saving the meal type without Serving Start/End Time will automatically remove the Late/Irregular Diet Order Start/End Time. Do you wish to continue?");		
		}
	}
	/* Students Validation End */
	/* Added Againt End ML-MOH-CRF-825*/
	if(flag==true){
	//First check for -->Time Cannot be Blank validation if either serving from or to is entered and similarly check for irregular timing also --Starts
			var msgframe = "";
			var msg="";
			var error="";
			if(parent.messageFrame)
					msgframe = parent.messageFrame;
			else
					msgframe = messageFrame;
			
			if(ServingStartTime=="" && ServingEndTime!=""){		
				error=getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("eDS.ServingStartTime.Label","DS"))));
				f_query_add_mod.document.forms[0].ServingStartTime.select();
				f_query_add_mod.document.forms[0].ServingStartTime.focus();
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
				return false;
			}
			else if(ServingStartTime!="" && ServingEndTime==""){
				error=getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("eDS.ServingEndTime.Label","DS"))));
				f_query_add_mod.document.forms[0].ServingEndTime.select();
				f_query_add_mod.document.forms[0].ServingEndTime.focus();
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
				return false;
			}
			else if(IrregularStartTime=="" && IrregularEndTime!=""){
				error=getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("eDS.LateIrregularDietOrderStartTime.Label","DS"))));
				f_query_add_mod.document.forms[0].IrregularStartTime.select();
				f_query_add_mod.document.forms[0].IrregularStartTime.focus();
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
				return false;
			}
			else if(IrregularStartTime!="" && IrregularEndTime==""){
				error=getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("eDS.LateIrregularDietOrderEndTime.Label","DS"))));
				f_query_add_mod.document.forms[0].IrregularEndTime.select();
				f_query_add_mod.document.forms[0].IrregularEndTime.focus();
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
				return false;
			}
			// OP start
			if(OpServingStartTime=="" && OpServingEndTime!=""){		
				error=getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("eDS.ServingStartTime.Label","DS"))));
				f_query_add_mod.document.forms[0].OpServingStartTime.select();
				f_query_add_mod.document.forms[0].OpServingStartTime.focus();
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
				return false;
			}
			else if(OpServingStartTime!="" && OpServingEndTime==""){
				error=getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("eDS.ServingEndTime.Label","DS"))));
				f_query_add_mod.document.forms[0].OpServingEndTime.select();
				f_query_add_mod.document.forms[0].OpServingEndTime.focus();
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
				return false;
			}
			else if(OpIrregularStartTime=="" && OpIrregularEndTime!=""){
				error=getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("eDS.LateIrregularDietOrderStartTime.Label","DS"))));
				f_query_add_mod.document.forms[0].OpIrregularStartTime.select();
				f_query_add_mod.document.forms[0].OpIrregularStartTime.focus();
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
				return false;
			}
			else if(OpIrregularStartTime!="" && OpIrregularEndTime==""){
				error=getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("eDS.LateIrregularDietOrderEndTime.Label","DS"))));
				f_query_add_mod.document.forms[0].OpIrregularEndTime.select();
				f_query_add_mod.document.forms[0].OpIrregularEndTime.focus();
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
				return false;
			} 
			// OP end
			// EM start
			if(EmServingStartTime=="" && EmServingEndTime!=""){		
				error=getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("eDS.ServingStartTime.Label","DS"))));
				f_query_add_mod.document.forms[0].EmServingStartTime.select();
				f_query_add_mod.document.forms[0].EmServingStartTime.focus();
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
				return false;
			}
			else if(EmServingStartTime!="" && EmServingEndTime==""){
				error=getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("eDS.ServingEndTime.Label","DS"))));
				f_query_add_mod.document.forms[0].EmServingEndTime.select();
				f_query_add_mod.document.forms[0].EmServingEndTime.focus();
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
				return false;
			}
			else if(EmIrregularStartTime=="" && EmIrregularEndTime!=""){
				error=getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("eDS.LateIrregularDietOrderStartTime.Label","DS"))));
				f_query_add_mod.document.forms[0].EmIrregularStartTime.select();
				f_query_add_mod.document.forms[0].EmIrregularStartTime.focus();
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
				return false;
			}
			else if(EmIrregularStartTime!="" && EmIrregularEndTime==""){
				error=getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("eDS.LateIrregularDietOrderEndTime.Label","DS"))));
				f_query_add_mod.document.forms[0].EmIrregularEndTime.select();
				f_query_add_mod.document.forms[0].EmIrregularEndTime.focus();
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
				return false;
			} 
			// EM end
			// Supplement start
			if(SupplementServingStartTime=="" && SupplementServingEndTime!=""){		
				error=getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("eDS.ServingStartTime.Label","DS"))));
				f_query_add_mod.document.forms[0].SupplementServingStartTime.select();
				f_query_add_mod.document.forms[0].SupplementServingStartTime.focus();
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
				return false;
			}
			else if(SupplementServingStartTime!="" && SupplementServingEndTime==""){
				error=getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("eDS.ServingEndTime.Label","DS"))));
				f_query_add_mod.document.forms[0].SupplementServingEndTime.select();
				f_query_add_mod.document.forms[0].SupplementServingEndTime.focus();
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
				return false;
			}
			else if(SupplementIrregularStartTime=="" && SupplementIrregularEndTime!=""){
				error=getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("eDS.LateIrregularDietOrderStartTime.Label","DS"))));
				f_query_add_mod.document.forms[0].SupplementIrregularStartTime.select();
				f_query_add_mod.document.forms[0].SupplementIrregularStartTime.focus();
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
				return false;
			}
			else if(SupplementIrregularStartTime!="" && SupplementIrregularEndTime==""){
				error=getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("eDS.LateIrregularDietOrderEndTime.Label","DS"))));
				f_query_add_mod.document.forms[0].SupplementIrregularEndTime.select();
				f_query_add_mod.document.forms[0].SupplementIrregularEndTime.focus();
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
				return false;
			} 
			// Supplement end
			// Doctor On-Call Start
			if(DocServingStartTime=="" && DocServingEndTime!=""){		
				error=getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("eDS.ServingStartTime.Label","DS"))));
				f_query_add_mod.document.forms[0].DocServingStartTime.select();
				f_query_add_mod.document.forms[0].DocServingStartTime.focus();
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
				return false;
			}
			else if(DocServingStartTime!="" && DocServingEndTime==""){
				error=getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("eDS.ServingEndTime.Label","DS"))));
				f_query_add_mod.document.forms[0].DocServingEndTime.select();
				f_query_add_mod.document.forms[0].DocServingEndTime.focus();
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
				return false;
			}
			else if(DocIrregularStartTime=="" && DocIrregularEndTime!=""){
				error=getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("eDS.LateIrregularDietOrderStartTime.Label","DS"))));
				f_query_add_mod.document.forms[0].DocIrregularStartTime.select();
				f_query_add_mod.document.forms[0].DocIrregularStartTime.focus();
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
				return false;
			}
			else if(DocIrregularStartTime!="" && DocIrregularEndTime==""){
				error=getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("eDS.LateIrregularDietOrderEndTime.Label","DS"))));
				f_query_add_mod.document.forms[0].DocIrregularEndTime.select();
				f_query_add_mod.document.forms[0].DocIrregularEndTime.focus();
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
				return false;
			}
			// Doctor On-Call Start End
			// OT/Paramedic Staff start
			if(OpsServingStartTime=="" && OpsServingEndTime!=""){		
				error=getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("eDS.ServingStartTime.Label","DS"))));
				f_query_add_mod.document.forms[0].OpsServingStartTime.select();
				f_query_add_mod.document.forms[0].OpsServingStartTime.focus();
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
				return false;
			}
			else if(OpsServingStartTime!="" && OpsServingEndTime==""){
				error=getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("eDS.ServingEndTime.Label","DS"))));
				f_query_add_mod.document.forms[0].OpsServingEndTime.select();
				f_query_add_mod.document.forms[0].OpsServingEndTime.focus();
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
				return false;
			}
			else if(OpsIrregularStartTime=="" && OpsIrregularEndTime!=""){
				error=getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("eDS.LateIrregularDietOrderStartTime.Label","DS"))));
				f_query_add_mod.document.forms[0].OpsIrregularStartTime.select();
				f_query_add_mod.document.forms[0].OpsIrregularStartTime.focus();
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
				return false;
			}
			else if(OpsIrregularStartTime!="" && OpsIrregularEndTime==""){
				error=getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("eDS.LateIrregularDietOrderEndTime.Label","DS"))));
				f_query_add_mod.document.forms[0].OpsIrregularEndTime.select();
				f_query_add_mod.document.forms[0].OpsIrregularEndTime.focus();
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
				return false;
			} 
			// OT/Paramedic Staff end
			// On Call Staff  start
			if(OncServingStartTime=="" && OncServingEndTime!=""){		
				error=getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("eDS.ServingStartTime.Label","DS"))));
				f_query_add_mod.document.forms[0].OncServingStartTime.select();
				f_query_add_mod.document.forms[0].OncServingStartTime.focus();
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
				return false;
			}
			else if(OncServingStartTime!="" && OncServingEndTime==""){
				error=getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("eDS.ServingEndTime.Label","DS"))));
				f_query_add_mod.document.forms[0].OncServingEndTime.select();
				f_query_add_mod.document.forms[0].OncServingEndTime.focus();
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
				return false;
			}
			else if(OncIrregularStartTime=="" && OncIrregularEndTime!=""){
				error=getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("eDS.LateIrregularDietOrderStartTime.Label","DS"))));
				f_query_add_mod.document.forms[0].OncIrregularStartTime.select();
				f_query_add_mod.document.forms[0].OncIrregularStartTime.focus();
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
				return false;
			}
			else if(OncIrregularStartTime!="" && OncIrregularEndTime==""){
				error=getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("eDS.LateIrregularDietOrderEndTime.Label","DS"))));
				f_query_add_mod.document.forms[0].OncIrregularEndTime.select();
				f_query_add_mod.document.forms[0].OncIrregularEndTime.focus();
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
				return false;
			} 
			// On Call Staff end
			// Staff start
			if(StaffServingStartTime=="" && StaffServingEndTime!=""){		
				error=getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("eDS.ServingStartTime.Label","DS"))));
				f_query_add_mod.document.forms[0].StaffServingStartTime.select();
				f_query_add_mod.document.forms[0].StaffServingStartTime.focus();
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
				return false;
			}
			else if(StaffServingStartTime!="" && StaffServingEndTime==""){
				error=getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("eDS.ServingEndTime.Label","DS"))));
				f_query_add_mod.document.forms[0].StaffServingEndTime.select();
				f_query_add_mod.document.forms[0].StaffServingEndTime.focus();
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
				return false;
			}
			else if(StaffIrregularStartTime=="" && StaffIrregularEndTime!=""){
				error=getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("eDS.LateIrregularDietOrderStartTime.Label","DS"))));
				f_query_add_mod.document.forms[0].StaffIrregularStartTime.select();
				f_query_add_mod.document.forms[0].StaffIrregularStartTime.focus();
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
				return false;
			}
			else if(StaffIrregularStartTime!="" && StaffIrregularEndTime==""){
				error=getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("eDS.LateIrregularDietOrderEndTime.Label","DS"))));
				f_query_add_mod.document.forms[0].StaffIrregularEndTime.select();
				f_query_add_mod.document.forms[0].StaffIrregularEndTime.focus();
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
				return false;
			} 
			// Staff end
			// Student start
			if(StudentServingStartTime=="" && StudentServingEndTime!=""){		
				error=getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("eDS.ServingStartTime.Label","DS"))));
				f_query_add_mod.document.forms[0].StudentServingStartTime.select();
				f_query_add_mod.document.forms[0].StudentServingStartTime.focus();
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
				return false;
			}
			else if(StudentServingStartTime!="" && StudentServingEndTime==""){
				error=getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("eDS.ServingEndTime.Label","DS"))));
				f_query_add_mod.document.forms[0].StudentServingEndTime.select();
				f_query_add_mod.document.forms[0].StudentServingEndTime.focus();
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
				return false;
			}
			else if(StudentIrregularStartTime=="" && StudentIrregularEndTime!=""){
				error=getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("eDS.LateIrregularDietOrderStartTime.Label","DS"))));
				f_query_add_mod.document.forms[0].StudentIrregularStartTime.select();
				f_query_add_mod.document.forms[0].StudentIrregularStartTime.focus();
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
				return false;
			}
			else if(StudentIrregularStartTime!="" && StudentIrregularEndTime==""){
				error=getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("eDS.LateIrregularDietOrderEndTime.Label","DS"))));
				f_query_add_mod.document.forms[0].StudentIrregularEndTime.select();
				f_query_add_mod.document.forms[0].StudentIrregularEndTime.focus();
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
				return false;
			} 
			// Student end
			else{
				error="";
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
			}
			// For IP AJAX-Call
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			var param="func_mode=checkMealTimeOverLap&ServingStartTime="+ServingStartTime+"&ServingEndTime="+ServingEndTime+"&IrregularStartTime="+IrregularStartTime+"&IrregularEndTime="+IrregularEndTime+"&order_no="+order_no;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","../../eDS/jsp/DLCommonValidation.jsp?"+param,false);
			xmlHttp.send(xmlDoc);
			var retVal = localTrimString(xmlHttp.responseText);			
			var arr=retVal.split("#");
			// OP AJAX-Call Start
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			var paramOp="func_mode=checkMealTimeOverLapOp&OpServingStartTime="+OpServingStartTime+"&OpServingEndTime="+OpServingEndTime+"&OpIrregularStartTime="+OpIrregularStartTime+"&OpIrregularEndTime="+OpIrregularEndTime+"&order_no="+order_no;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","../../eDS/jsp/DLCommonValidation.jsp?"+paramOp,false);
			xmlHttp.send(xmlDoc);
			var retValOp = localTrimString(xmlHttp.responseText);		
			var arrOP=retValOp.split("#");
			// OP end
			// EM start
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			var paramEm="func_mode=checkMealTimeOverLapEm&EmServingStartTime="+EmServingStartTime+"&EmServingEndTime="+EmServingEndTime+"&EmIrregularStartTime="+EmIrregularStartTime+"&EmIrregularEndTime="+EmIrregularEndTime+"&order_no="+order_no;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","../../eDS/jsp/DLCommonValidation.jsp?"+paramEm,false);
			xmlHttp.send(xmlDoc);
			var retValEm = localTrimString(xmlHttp.responseText);		
			var arrEM=retValEm.split("#");
			// EM end
			// Supplement start
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			var paramSupplement="func_mode=checkMealTimeOverLapSupplement&SupplementServingStartTime="+SupplementServingStartTime+"&SupplementServingEndTime="+SupplementServingEndTime+"&SupplementIrregularStartTime="+SupplementIrregularStartTime+"&SupplementIrregularEndTime="+SupplementIrregularEndTime+"&order_no="+order_no;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","../../eDS/jsp/DLCommonValidation.jsp?"+paramSupplement,false);
			xmlHttp.send(xmlDoc);
			var retValSupplement = localTrimString(xmlHttp.responseText);		
			var arrSupplement=retValSupplement.split("#");
			// Supplement end	
			// Doctor On Call start
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			var paramDoc="func_mode=checkMealTimeOverLapDoc&DocServingStartTime="+DocServingStartTime+"&DocServingEndTime="+DocServingEndTime+"&DocIrregularStartTime="+DocIrregularStartTime+"&DocIrregularEndTime="+DocIrregularEndTime+"&order_no="+order_no;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","../../eDS/jsp/DLCommonValidation.jsp?"+paramDoc,false);
			xmlHttp.send(xmlDoc);
			var retValDoc = localTrimString(xmlHttp.responseText);		
			var arrDoc=retValDoc.split("#");
			// Doctor On Call end				
			// OT/Paramedic Staff start
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			var paramOps="func_mode=checkMealTimeOverLapOps&OpsServingStartTime="+OpsServingStartTime+"&OpsServingEndTime="+OpsServingEndTime+"&OpsIrregularStartTime="+OpsIrregularStartTime+"&OpsIrregularEndTime="+OpsIrregularEndTime+"&order_no="+order_no;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","../../eDS/jsp/DLCommonValidation.jsp?"+paramOps,false);
			xmlHttp.send(xmlDoc);
			var retValOps = localTrimString(xmlHttp.responseText);		
			var arrOps=retValOps.split("#");
			// OT/Paramedic Staff end
			// On Call Staff  start
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			var paramOnc="func_mode=checkMealTimeOverLapOnc&OncServingStartTime="+OncServingStartTime+"&OncServingEndTime="+OncServingEndTime+"&OncIrregularStartTime="+OncIrregularStartTime+"&OncIrregularEndTime="+OncIrregularEndTime+"&order_no="+order_no;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","../../eDS/jsp/DLCommonValidation.jsp?"+paramOnc,false);
			xmlHttp.send(xmlDoc);
			var retValOnc = localTrimString(xmlHttp.responseText);		
			var arrOnc=retValOnc.split("#");
			// On Call Staff end
			// Staff  start
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			var paramStaff="func_mode=checkMealTimeOverLapStaff&StaffServingStartTime="+StaffServingStartTime+"&StaffServingEndTime="+StaffServingEndTime+"&StaffIrregularStartTime="+StaffIrregularStartTime+"&StaffIrregularEndTime="+StaffIrregularEndTime+"&order_no="+order_no;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","../../eDS/jsp/DLCommonValidation.jsp?"+paramStaff,false);
			xmlHttp.send(xmlDoc);
			var retValStaff = localTrimString(xmlHttp.responseText);		
			var arrStaff=retValStaff.split("#");
			// On Call Staff end
			// Students start
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			var paramStudent="func_mode=checkMealTimeOverLapStudent&StudentServingStartTime="+StudentServingStartTime+"&StudentServingEndTime="+StudentServingEndTime+"&StudentIrregularStartTime="+StudentIrregularStartTime+"&StudentIrregularEndTime="+StudentIrregularEndTime+"&order_no="+order_no;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","../../eDS/jsp/DLCommonValidation.jsp?"+paramStudent,false);
			xmlHttp.send(xmlDoc);
			var retValStudent = localTrimString(xmlHttp.responseText);		
			var arrStudent=retValStudent.split("#");
			// Students  end	
			if(arr[0]!="" || arr[1]!="")
			{
				var fieldName=getLabel("eDS.ServingTime.Label","ds_labels");
				msg=getMessage("DS_SHOULD_BE_AFTER_BEFORE","DS");
				var msgArray=msg.split("#");
				error="";
				error+=fieldName;
				error+=msgArray[1];
				//ICN-61684 
				if(arr[3]=="")
				{
				 	error+="00:01";
				}
				error+=arr[3];
				error+=msgArray[2];
				if(arr[4]=="")
				{
				  	error+="23:59";
				}
				error+=arr[4];
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
				f_query_add_mod.document.forms[0].ServingStartTime.select();
				f_query_add_mod.document.forms[0].ServingStartTime.focus();
				return false;
			}
			else if(arr[2]!=""){
				//irregular time is overlapped
				var fieldName=getLabel("eDS.LateIrregularDietOrderTime.Label","ds_labels");
				msg=getMessage("DS_SHOULD_BE_WITHIN","DS");
				var msgArray=msg.split("#");
				error="";
				error+=fieldName;
				error+=msgArray[1];
				error+=addSubTime(arr[3],"increment");
				error+=msgArray[2];
				error+=addSubTime(arr[4],"decrement");
				error="";
				//error="Late/Irregular Diet Order End Time Should be before "+addSubTime(arr[4],"decrement");
				error="Late/Irregular Diet Order End Time Should be before "+arr[4];
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;	
				f_query_add_mod.document.forms[0].IrregularEndTime.select();
				f_query_add_mod.document.forms[0].IrregularEndTime.focus();				
				return false;
				
			}
		/* Added Against End ML-MOH-CRF-825 */		
			/* Start OP */
			 if(arrOP[0]!="" || arrOP[1]!="")
			{
				var fieldName=getLabel("eDS.ServingTime.Label","ds_labels");
				msg=getMessage("DS_SHOULD_BE_AFTER_BEFORE","DS");
				var msgArray=msg.split("#");
				error="";
				error+=fieldName;
				error+=msgArray[1];
				if(arrOP[3]=="")
				{
				 	error+="00:01";
				}
				error+=arrOP[3];
				error+=msgArray[2];
				if(arrOP[4]=="")
				{
				  	error+="23:59";
				}
				error+=arrOP[4];
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
				f_query_add_mod.document.forms[0].OpServingStartTime.select();
				f_query_add_mod.document.forms[0].OpServingStartTime.focus();
				return false;
			}
			else if(arrOP[2]!=""){
				var fieldName=getLabel("eDS.LateIrregularDietOrderTime.Label","ds_labels");
				msg=getMessage("DS_SHOULD_BE_WITHIN","DS");
				var msgArray=msg.split("#");
				error="";
				error+=fieldName;
				error+=msgArray[1];
				error+=addSubTime(arrOP[3],"increment");
				error+=msgArray[2];
				error+=addSubTime(arrOP[4],"decrement");
				error="";
				error="Late/Irregular Diet Order End Time Should be before "+arrOP[4];
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;	
				f_query_add_mod.document.forms[0].OpIrregularEndTime.select();
				f_query_add_mod.document.forms[0].OpIrregularEndTime.focus();				
				return false;
				
			}
			/* End OP */
			/* Start EM */
			if(arrEM[0]=='undefined')
				arrEM[0]="";
				if(arrEM[1]=='undefined')
				arrEM[1]="";
			 if(arrEM[0]!="" || arrEM[1]!="")
			{
				var fieldName=getLabel("eDS.ServingTime.Label","ds_labels");
				msg=getMessage("DS_SHOULD_BE_AFTER_BEFORE","DS");
				var msgArray=msg.split("#");
				error="";
				error+=fieldName;
				error+=msgArray[1];
				if(arrEM[3]=="")
				{
				 	error+="00:01";
				}
				error+=arrEM[3];
				error+=msgArray[2];
				if(arrEM[4]=="")
				{
				  	error+="23:59";
				}
				error+=arrEM[4];
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
				f_query_add_mod.document.forms[0].EmServingStartTime.select();
				f_query_add_mod.document.forms[0].EmServingStartTime.focus();
				return false;
			}
			else if(arrEM[2]!=""){
				var fieldName=getLabel("eDS.LateIrregularDietOrderTime.Label","ds_labels");
				msg=getMessage("DS_SHOULD_BE_WITHIN","DS");
				var msgArray=msg.split("#");
				error="";
				error+=fieldName;
				error+=msgArray[1];
				error+=addSubTime(arrEM[3],"increment");
				error+=msgArray[2];
				error+=addSubTime(arrEM[4],"decrement");
				error="";
				error="Late/Irregular Diet Order End Time Should be before "+arrEM[4];
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;	
				f_query_add_mod.document.forms[0].EmIrregularEndTime.select();
				f_query_add_mod.document.forms[0].EmIrregularEndTime.focus();				
				return false;
				
			}
			/* End EM */
			/* Start Supplement */
			if(arrSupplement[0]=='undefined')
				arrSupplement[0]="";
				if(arrSupplement[1]=='undefined')
				arrSupplement[1]="";
			 if(arrSupplement[0]!="" || arrSupplement[1]!="")
			{
				var fieldName=getLabel("eDS.ServingTime.Label","ds_labels");
				msg=getMessage("DS_SHOULD_BE_AFTER_BEFORE","DS");
				var msgArray=msg.split("#");
				error="";
				error+=fieldName;
				error+=msgArray[1];
				if(arrSupplement[3]=="")
				{
				 	error+="00:01";
				}
				error+=arrSupplement[3];
				error+=msgArray[2];
				if(arrSupplement[4]=="")
				{
				  	error+="23:59";
				}
				error+=arrSupplement[4];
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
				f_query_add_mod.document.forms[0].SupplementServingStartTime.select();
				f_query_add_mod.document.forms[0].SupplementServingStartTime.focus();
				return false;
			}
			else if(arrSupplement[2]!=""){
				var fieldName=getLabel("eDS.LateIrregularDietOrderTime.Label","ds_labels");
				msg=getMessage("DS_SHOULD_BE_WITHIN","DS");
				var msgArray=msg.split("#");
				error="";
				error+=fieldName;
				error+=msgArray[1];
				error+=addSubTime(arrSupplement[3],"increment");
				error+=msgArray[2];
				error+=addSubTime(arrSupplement[4],"decrement");
				error="";
				error="Late/Irregular Diet Order End Time Should be before "+arrSupplement[4];
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;	
				f_query_add_mod.document.forms[0].SupplementIrregularEndTime.select();
				f_query_add_mod.document.forms[0].SupplementIrregularEndTime.focus();				
				return false;
				
			}
			/* End Supplement */	
			/* Start Doctor On Call */
			if(arrDoc[0]=='undefined')
				arrDoc[0]="";
				if(arrDoc[1]=='undefined')
				arrDoc[1]="";
			 if(arrDoc[0]!="" || arrDoc[1]!="")
			{
				var fieldName=getLabel("eDS.ServingTime.Label","ds_labels");
				msg=getMessage("DS_SHOULD_BE_AFTER_BEFORE","DS");
				var msgArray=msg.split("#");
				error="";
				error+=fieldName;
				error+=msgArray[1];
				if(arrDoc[3]=="")
				{
				 	error+="00:01";
				}
				error+=arrDoc[3];
				error+=msgArray[2];
				if(arrDoc[4]=="")
				{
				  	error+="23:59";
				}
				error+=arrDoc[4];
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
				f_query_add_mod.document.forms[0].DocServingStartTime.select();
				f_query_add_mod.document.forms[0].DocServingStartTime.focus();
				return false;
			}
			else if(arrDoc[2]!=""){
				var fieldName=getLabel("eDS.LateIrregularDietOrderTime.Label","ds_labels");
				msg=getMessage("DS_SHOULD_BE_WITHIN","DS");
				var msgArray=msg.split("#");
				error="";
				error+=fieldName;
				error+=msgArray[1];
				error+=addSubTime(arrDoc[3],"increment");
				error+=msgArray[2];
				error+=addSubTime(arrDoc[4],"decrement");
				error="";
				error="Late/Irregular Diet Order End Time Should be before "+arrDoc[4];
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;	
				f_query_add_mod.document.forms[0].DocIrregularEndTime.select();
				f_query_add_mod.document.forms[0].DocIrregularEndTime.focus();				
				return false;
				
			}
			/* End Doctor On Call */		
			/* Start OT/Paramedic Staff  */
			if(arrOnc[0]=='undefined')
				arrOnc[0]="";
				if(arrOnc[1]=='undefined')
				arrOnc[1]="";
			 if(arrOnc[0]!="" || arrOnc[1]!="")
			{
				var fieldName=getLabel("eDS.ServingTime.Label","ds_labels");
				msg=getMessage("DS_SHOULD_BE_AFTER_BEFORE","DS");
				var msgArray=msg.split("#");
				error="";
				error+=fieldName;
				error+=msgArray[1];
				if(arrOnc[3]=="")
				{
				 	error+="00:01";
				}
				error+=arrOnc[3];
				error+=msgArray[2];
				if(arrOnc[4]=="")
				{
				  	error+="23:59";
				}
				error+=arrOnc[4];
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
				f_query_add_mod.document.forms[0].OncServingStartTime.select();
				f_query_add_mod.document.forms[0].OncServingStartTime.focus();
				return false;
			}
			else if(arrOnc[2]!=""){
				var fieldName=getLabel("eDS.LateIrregularDietOrderTime.Label","ds_labels");
				msg=getMessage("DS_SHOULD_BE_WITHIN","DS");
				var msgArray=msg.split("#");
				error="";
				error+=fieldName;
				error+=msgArray[1];
				error+=addSubTime(arrOnc[3],"increment");
				error+=msgArray[2];
				error+=addSubTime(arrOnc[4],"decrement");
				error="";
				error="Late/Irregular Diet Order End Time Should be before "+arrOnc[4];
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;	
				f_query_add_mod.document.forms[0].OncIrregularEndTime.select();
				f_query_add_mod.document.forms[0].OncIrregularEndTime.focus();				
				return false;
				
			}
			/* End OT/Paramedic Staff */		
			/* Start On Call Staff   */
			if(arrOnc[0]=='undefined')
				arrOnc[0]="";
				if(arrOnc[1]=='undefined')
				arrOnc[1]="";
			 if(arrOnc[0]!="" || arrOnc[1]!="")
			{
				var fieldName=getLabel("eDS.ServingTime.Label","ds_labels");
				msg=getMessage("DS_SHOULD_BE_AFTER_BEFORE","DS");
				var msgArray=msg.split("#");
				error="";
				error+=fieldName;
				error+=msgArray[1];
				if(arrOnc[3]=="")
				{
				 	error+="00:01";
				}
				error+=arrOnc[3];
				error+=msgArray[2];
				if(arrOnc[4]=="")
				{
				  	error+="23:59";
				}
				error+=arrOnc[4];
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
				f_query_add_mod.document.forms[0].OncServingStartTime.select();
				f_query_add_mod.document.forms[0].OncServingStartTime.focus();
				return false;
			}
			else if(arrOnc[2]!=""){
				var fieldName=getLabel("eDS.LateIrregularDietOrderTime.Label","ds_labels");
				msg=getMessage("DS_SHOULD_BE_WITHIN","DS");
				var msgArray=msg.split("#");
				error="";
				error+=fieldName;
				error+=msgArray[1];
				error+=addSubTime(arrOnc[3],"increment");
				error+=msgArray[2];
				error+=addSubTime(arrOnc[4],"decrement");
				error="";
				error="Late/Irregular Diet Order End Time Should be before "+arrOnc[4];
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;	
				f_query_add_mod.document.forms[0].OncIrregularEndTime.select();
				f_query_add_mod.document.forms[0].OncIrregularEndTime.focus();				
				return false;
				
			}
			/*End On Call Staff */	
			/* Start Staff */
			if(arrStaff[0]=='undefined')
				arrStaff[0]="";
				if(arrStaff[1]=='undefined')
				arrStaff[1]="";
			 if(arrStaff[0]!="" || arrStaff[1]!="")
			{
				var fieldName=getLabel("eDS.ServingTime.Label","ds_labels");
				msg=getMessage("DS_SHOULD_BE_AFTER_BEFORE","DS");
				var msgArray=msg.split("#");
				error="";
				error+=fieldName;
				error+=msgArray[1];
				if(arrStaff[3]=="")
				{
				 	error+="00:01";
				}
				error+=arrStaff[3];
				error+=msgArray[2];
				if(arrStaff[4]=="")
				{
				  	error+="23:59";
				}
				error+=arrStaff[4];
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
				f_query_add_mod.document.forms[0].StaffServingStartTime.select();
				f_query_add_mod.document.forms[0].StaffServingStartTime.focus();
				return false;
			}
			else if(arrStaff[2]!=""){
				var fieldName=getLabel("eDS.LateIrregularDietOrderTime.Label","ds_labels");
				msg=getMessage("DS_SHOULD_BE_WITHIN","DS");
				var msgArray=msg.split("#");
				error="";
				error+=fieldName;
				error+=msgArray[1];
				error+=addSubTime(arrStaff[3],"increment");
				error+=msgArray[2];
				error+=addSubTime(arrStaff[4],"decrement");
				error="";
				error="Late/Irregular Diet Order End Time Should be before "+arrStaff[4];
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;	
				f_query_add_mod.document.forms[0].StaffIrregularEndTime.select();
				f_query_add_mod.document.forms[0].StaffIrregularEndTime.focus();				
				return false;
				
			}
			/*E nd Staff */	
			/* Start Students */
			if(arrStudent[0]=='undefined')
				arrStudent[0]="";
				if(arrStudent[1]=='undefined')
				arrStudent[1]="";
			 if(arrStudent[0]!="" || arrStudent[1]!="")
			{
				var fieldName=getLabel("eDS.ServingTime.Label","ds_labels");
				msg=getMessage("DS_SHOULD_BE_AFTER_BEFORE","DS");
				var msgArray=msg.split("#");
				error="";
				error+=fieldName;
				error+=msgArray[1];
				if(arrStudent[3]=="")
				{
				 	error+="00:01";
				}
				error+=arrStudent[3];
				error+=msgArray[2];
				if(arrStudent[4]=="")
				{
				  	error+="23:59";
				}
				error+=arrStudent[4];
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
				f_query_add_mod.document.forms[0].StudentServingStartTime.select();
				f_query_add_mod.document.forms[0].StudentServingStartTime.focus();
				return false;
			}
			else if(arrStudent[2]!=""){
				var fieldName=getLabel("eDS.LateIrregularDietOrderTime.Label","ds_labels");
				msg=getMessage("DS_SHOULD_BE_WITHIN","DS");
				var msgArray=msg.split("#");
				error="";
				error+=fieldName;
				error+=msgArray[1];
				error+=addSubTime(arrStudent[3],"increment");
				error+=msgArray[2];
				error+=addSubTime(arrStudent[4],"decrement");
				error="";
				error="Late/Irregular Diet Order End Time Should be before "+arrStudent[4];
				msgframe.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;	
				f_query_add_mod.document.forms[0].StudentIrregularEndTime.select();
				f_query_add_mod.document.forms[0].StudentIrregularEndTime.focus();				
				return false;
				
			}
			/* End Students */	
			/* Added Against End ML-MOH-CRF-825 */		
			else{
				return true;
			}			
		}//newly added
		
}

function checkForSpecCharsforID_mt(event)
{
	var strCheck = '0123456789:';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}
//ML-MMOH-CRF-409 Ends

/* Added Against Start ML-MMOH-CRF-825 */
function enable_disable(obj){
		var ipMealOrderYn = document.forms[0].ipmealorder_yn.checked;
		var opMealOrderYn = document.forms[0].opmealorder_yn.checked;
		var emMealOrderYn = document.forms[0].emmealorder_yn.checked;
		var supplementDietOrderYn = document.forms[0].supldietorder_yn.checked;
		var docOnCallMealOrderYn = document.forms[0].docMealOrderYn.checked;
		var OTParamedicStaff = document.forms[0].opsMealOrderYn.checked;
		var onCallStaffMealOrderYn = document.forms[0].oncMealOrderYn.checked;
		var staffMealOrderYn = document.forms[0].stcMealOrderYn.checked;
		var studentMealOrderYn = document.forms[0].stuMealOrderYn.checked;
		var IrregularStartTime = document.forms[0].IrregularStartTime.value;
		var IrregularEndTime = document.forms[0].IrregularStartTime.value;
	if(obj.checked==true){
		if(ipMealOrderYn==true){
			$('#ServingStartTime').prop('disabled', false);
			$('#ServingEndTime').prop('disabled', false);
			$('#IrregularStartTime').prop('disabled', false);
			$('#IrregularEndTime').prop('disabled', false);			
		}
		if(opMealOrderYn==true){
			$('#OpServingStartTime').prop('disabled', false);
			$('#OpServingEndTime').prop('disabled', false);
			$('#OpIrregularStartTime').prop('disabled', false);
			$('#OpIrregularEndTime').prop('disabled', false);						
		}
		if(emMealOrderYn==true){
			$('#EmServingStartTime').prop('disabled', false);
			$('#EmServingEndTime').prop('disabled', false);	
			$('#EmIrregularStartTime').prop('disabled', false);
			$('#EmIrregularEndTime').prop('disabled', false);								
		}
		if(supplementDietOrderYn==true){
			$('#SupplementServingStartTime').prop('disabled', false);
			$('#SupplementServingEndTime').prop('disabled', false);				
			$('#SupplementIrregularStartTime').prop('disabled', false);
			$('#SupplementIrregularEndTime').prop('disabled', false);						
		}		
		if(docOnCallMealOrderYn==true){
			$('#DocServingStartTime').prop('disabled', false);
			$('#DocServingEndTime').prop('disabled', false);				
			$('#DocIrregularStartTime').prop('disabled', false);
			$('#DocIrregularEndTime').prop('disabled', false);								
		}
		if(OTParamedicStaff==true){
			$('#OpsServingStartTime').prop('disabled', false);
			$('#OpsServingEndTime').prop('disabled', false);
			$('#OpsIrregularStartTime').prop('disabled', false);
			$('#OpsIrregularEndTime').prop('disabled', false);											
		}
		if(onCallStaffMealOrderYn==true){
			$('#OncServingStartTime').prop('disabled', false);
			$('#OncServingEndTime').prop('disabled', false);
			$('#OncIrregularStartTime').prop('disabled', false);
			$('#OncIrregularEndTime').prop('disabled', false);														
		}
		if(staffMealOrderYn==true){
			$('#StaffServingStartTime').prop('disabled', false);
			$('#StaffServingEndTime').prop('disabled', false);
			$('#StaffIrregularStartTime').prop('disabled', false);
			$('#StaffIrregularEndTime').prop('disabled', false);															
		}
		if(studentMealOrderYn==true){
			$('#StudentServingStartTime').prop('disabled', false);
			$('#StudentServingEndTime').prop('disabled', false);
			$('#StudentIrregularStartTime').prop('disabled', false);
			$('#StudentIrregularEndTime').prop('disabled', false);																
		}
		}else{
			if(ipMealOrderYn==false){
			$('#ServingStartTime').prop('disabled', true);
			$('#ServingEndTime').prop('disabled', true);
			$('#IrregularStartTime').prop('disabled', true);
			$('#IrregularEndTime').prop('disabled', true);
			}
			if(opMealOrderYn==false){
			$('#OpServingStartTime').prop('disabled', true);
			$('#OpServingEndTime').prop('disabled', true);		
			$('#OpIrregularStartTime').prop('disabled', true);
			$('#OpIrregularEndTime').prop('disabled', true);			
			}
			if(emMealOrderYn==false){
			$('#EmServingStartTime').prop('disabled', true);
			$('#EmServingEndTime').prop('disabled', true);		
			$('#EmIrregularStartTime').prop('disabled', true);
			$('#EmIrregularEndTime').prop('disabled', true);			
			}
			if(supplementDietOrderYn==false){
			$('#SupplementServingStartTime').prop('disabled', true);
			$('#SupplementServingEndTime').prop('disabled', true);		
			$('#SupplementIrregularStartTime').prop('disabled', true);
			$('#SupplementIrregularEndTime').prop('disabled', true);			
			}
			if(docOnCallMealOrderYn==false){
			$('#DocServingStartTime').prop('disabled', true);
			$('#DocServingEndTime').prop('disabled', true);		
			$('#DocIrregularStartTime').prop('disabled', true);
			$('#DocIrregularEndTime').prop('disabled', true);			
			}
			if(OTParamedicStaff==false){
			$('#OpsServingStartTime').prop('disabled', true);
			$('#OpsServingEndTime').prop('disabled', true);		
			$('#OpsIrregularStartTime').prop('disabled', true);
			$('#OpsIrregularEndTime').prop('disabled', true);			
			}
			if(onCallStaffMealOrderYn==false){
			$('#OncServingStartTime').prop('disabled', true);
			$('#OncServingEndTime').prop('disabled', true);		
			$('#OncIrregularStartTime').prop('disabled', true);
			$('#OncIrregularEndTime').prop('disabled', true);			
			}
			if(staffMealOrderYn==false){
			$('#StaffServingStartTime').prop('disabled', true);
			$('#StaffServingEndTime').prop('disabled', true);		
			$('#StaffIrregularStartTime').prop('disabled', true);
			$('#StaffIrregularEndTime').prop('disabled', true);			
			}
			if(studentMealOrderYn==false){
			$('#StudentServingStartTime').prop('disabled', true);
			$('#StudentServingEndTime').prop('disabled', true);		
			$('#StudentIrregularStartTime').prop('disabled', true);
			$('#StudentIrregularEndTime').prop('disabled', true);			
			}
	}
}
/* Added Against End ML-MMOH-CRF-825 */
/* Added Against Start ML-MMOH-CRF-825 */
function Onload_enab_disb(){
		var ipMealOrderYn = document.forms[0].ipmealorder_yn.checked;
		var opMealOrderYn = document.forms[0].opmealorder_yn.checked;
		var emMealOrderYn = document.forms[0].emmealorder_yn.checked;
		var supplementDietOrderYn = document.forms[0].supldietorder_yn.checked;
		var docOnCallMealOrderYn = document.forms[0].docMealOrderYn.checked;
		var OTParamedicStaff = document.forms[0].opsMealOrderYn.checked;
		var onCallStaffMealOrderYn = document.forms[0].oncMealOrderYn.checked;
		var staffMealOrderYn = document.forms[0].stcMealOrderYn.checked;
		var studentMealOrderYn = document.forms[0].stuMealOrderYn.checked;
		var IrregularStartTime = document.forms[0].IrregularStartTime.value;
		var IrregularEndTime = document.forms[0].IrregularStartTime.value;
		
		if(ipMealOrderYn==true){
			$('#ServingStartTime').prop('disabled', false);
			$('#ServingEndTime').prop('disabled', false);
			$('#IrregularStartTime').prop('disabled', false);
			$('#IrregularEndTime').prop('disabled', false);			
		}
		if(opMealOrderYn==true){
			$('#OpServingStartTime').prop('disabled', false);
			$('#OpServingEndTime').prop('disabled', false);
			$('#OpIrregularStartTime').prop('disabled', false);
			$('#OpIrregularEndTime').prop('disabled', false);						
		}
		if(emMealOrderYn==true){
			$('#EmServingStartTime').prop('disabled', false);
			$('#EmServingEndTime').prop('disabled', false);	
			$('#EmIrregularStartTime').prop('disabled', false);
			$('#EmIrregularEndTime').prop('disabled', false);								
		}
		if(supplementDietOrderYn==true){
			$('#SupplementServingStartTime').prop('disabled', false);
			$('#SupplementServingEndTime').prop('disabled', false);				
			$('#SupplementIrregularStartTime').prop('disabled', false);
			$('#SupplementIrregularEndTime').prop('disabled', false);						
		}		
		if(docOnCallMealOrderYn==true){
			$('#DocServingStartTime').prop('disabled', false);
			$('#DocServingEndTime').prop('disabled', false);				
			$('#DocIrregularStartTime').prop('disabled', false);
			$('#DocIrregularEndTime').prop('disabled', false);								
		}
		if(OTParamedicStaff==true){
			$('#OpsServingStartTime').prop('disabled', false);
			$('#OpsServingEndTime').prop('disabled', false);
			$('#OpsIrregularStartTime').prop('disabled', false);
			$('#OpsIrregularEndTime').prop('disabled', false);											
		}
		if(onCallStaffMealOrderYn==true){
			$('#OncServingStartTime').prop('disabled', false);
			$('#OncServingEndTime').prop('disabled', false);
			$('#OncIrregularStartTime').prop('disabled', false);
			$('#OncIrregularEndTime').prop('disabled', false);														
		}
		if(staffMealOrderYn==true){
			$('#StaffServingStartTime').prop('disabled', false);
			$('#StaffServingEndTime').prop('disabled', false);
			$('#StaffIrregularStartTime').prop('disabled', false);
			$('#StaffIrregularEndTime').prop('disabled', false);															
		}
		if(studentMealOrderYn==true){
			$('#StudentServingStartTime').prop('disabled', false);
			$('#StudentServingEndTime').prop('disabled', false);
			$('#StudentIrregularStartTime').prop('disabled', false);
			$('#StudentIrregularEndTime').prop('disabled', false);																
		}
		if(ipMealOrderYn==false){
		$('#ServingStartTime').prop('disabled', true);
		$('#ServingEndTime').prop('disabled', true);
		$('#IrregularStartTime').prop('disabled', true);
		$('#IrregularEndTime').prop('disabled', true);
		}
		if(opMealOrderYn==false){
		$('#OpServingStartTime').prop('disabled', true);
		$('#OpServingEndTime').prop('disabled', true);		
		$('#OpIrregularStartTime').prop('disabled', true);
		$('#OpIrregularEndTime').prop('disabled', true);			
		}
		if(emMealOrderYn==false){
		$('#EmServingStartTime').prop('disabled', true);
		$('#EmServingEndTime').prop('disabled', true);		
		$('#EmIrregularStartTime').prop('disabled', true);
		$('#EmIrregularEndTime').prop('disabled', true);			
		}
		if(supplementDietOrderYn==false){
		$('#SupplementServingStartTime').prop('disabled', true);
		$('#SupplementServingEndTime').prop('disabled', true);		
		$('#SupplementIrregularStartTime').prop('disabled', true);
		$('#SupplementIrregularEndTime').prop('disabled', true);			
		}
		if(docOnCallMealOrderYn==false){
		$('#DocServingStartTime').prop('disabled', true);
		$('#DocServingEndTime').prop('disabled', true);		
		$('#DocIrregularStartTime').prop('disabled', true);
		$('#DocIrregularEndTime').prop('disabled', true);			
		}
		if(OTParamedicStaff==false){
		$('#OpsServingStartTime').prop('disabled', true);
		$('#OpsServingEndTime').prop('disabled', true);		
		$('#OpsIrregularStartTime').prop('disabled', true);
		$('#OpsIrregularEndTime').prop('disabled', true);			
		}
		if(onCallStaffMealOrderYn==false){
		$('#OncServingStartTime').prop('disabled', true);
		$('#OncServingEndTime').prop('disabled', true);		
		$('#OncIrregularStartTime').prop('disabled', true);
		$('#OncIrregularEndTime').prop('disabled', true);			
		}
		if(staffMealOrderYn==false){
		$('#StaffServingStartTime').prop('disabled', true);
		$('#StaffServingEndTime').prop('disabled', true);		
		$('#StaffIrregularStartTime').prop('disabled', true);
		$('#StaffIrregularEndTime').prop('disabled', true);			
		}
		if(studentMealOrderYn==false){
		$('#StudentServingStartTime').prop('disabled', true);
		$('#StudentServingEndTime').prop('disabled', true);		
		$('#StudentIrregularStartTime').prop('disabled', true);
		$('#StudentIrregularEndTime').prop('disabled', true);			
		}
}
/* Added Against End ML-MMOH-CRF-825 */
