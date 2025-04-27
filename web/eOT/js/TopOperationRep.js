/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
	function run() {
		var formObj = f_query_rep.document.TopOperationRep;
		var flag = checkNull();
		if(flag==true){
			var p_facility_id = formObj.facility_id.value;
			var P_FROM_DATE = formObj.fromOperationDate.value;
			var p_language_id = formObj.p_language_id.value;
			var p_module_id = formObj.p_module_id.value;
			var p_report_id = formObj.p_report_id.value;
			var P_ROWCOUNT = formObj.count.value;
			while( P_ROWCOUNT.charAt(0) === '0' ){
				P_ROWCOUNT = P_ROWCOUNT.slice(1);
			}
			var P_TO_DATE = formObj.toOperationDate.value;
			var p_user_id = formObj.user_id.value;
			var p_user_name = formObj.p_user_name.value;
			
			var mon_val=isBefore(P_FROM_DATE, P_TO_DATE, "DMY", p_language_id);
			if (mon_val==false){
				var msg = getMessage("DATE1_NOT_GREATER_THAN_DATE2","OT");
				var msgArray = msg.split("#");
				var from_month=getLabel("eOT.FromOperationDate.Label","ot_labels");
				var to_month=getLabel("eOT.ToOperationDate.Label","ot_labels");
				alert(msgArray[0]+from_month+(msgArray[1])+to_month+(msgArray[2]));
					return false;
			}
			
			
			
			formObj.action = "../../eCommon/jsp/report_options.jsp?P_FROM_DATE="+P_FROM_DATE+"&p_language_id="+p_language_id+"&p_module_id="+p_module_id+"&p_report_id="+p_report_id+"&P_ROWCOUNT="+P_ROWCOUNT+"&P_TO_DATE="+P_TO_DATE+"&p_user_id="+p_user_id+"&p_user_name="+p_user_name+"&p_facility_id="+p_facility_id;
			formObj.submit();
		}
		
	}
	function checkNull(){
		var flag;
	 	var error="";
	 	
		var formObj = parent.content.f_query_rep.TopOperationRep
		
		var fromDate=formObj.fromOperationDate.value;
	 	var fromDate_label=getLabel("eOT.FromOperationDate.Label","ot");
	 	
	 	if(fromDate=="") {
	 		flag=false;
	 		error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",fromDate_label)+"<br>";
	 	}
	 	
		var toDate=formObj.toOperationDate.value;
	 	var toDate_label=getLabel("eOT.ToOperationDate.Label","ot");
	 	if(toDate=="") {
	 		flag=false;
	 		error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",toDate_label)+"<br>";
	 	}

		var count=formObj.count.value;
	 	var countL=getLabel("eOT.count.Label","ot");
	 	if(count=="") {
	 		flag=false;
	 		error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",countL)+"<br>";
	 	}
	 	messageFrame.location.href ='../../eCommon/jsp/error.jsp?err_num='+error;
		if(flag==false) return false; else return true;
	}
	
	
	function isValidDate(obj){


		if(obj.value!=""){
		var	locale = document.getElementById("p_language_id").value;	
				
		var flag=true;
			var RE_NUM =  /^\/?\d+$/;
			var str_date = obj.value;
			var arr_date = str_date.split('/');
			if (arr_date.length != 3) return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);//flag=false;
			
			if(arr_date[0]!=null)
			{
			if (arr_date[0].length !=2 ) flag=false;
			}
			if(arr_date[1]!=null)
			{
			if (arr_date[1].length !=2 ) flag=false;
			}
			if(arr_date[2]!=null)
			{
			if (arr_date[2].length !=4 ) flag=false;
			}

			if (!arr_date[0]) flag=false;
			if (!RE_NUM.exec(arr_date[0])) flag=false;
			if (!arr_date[1]) flag=false;
			if (!RE_NUM.exec(arr_date[1])) flag=false;
			if (!arr_date[2]) flag=false;
			if (arr_date[2].length!=4) flag=false;
			var dt_date = new Date();
			dt_date.setDate(1);
	//Modified by DhanasekarV on 21/02/2011
			var str_date1;
		  if( flag != false)
			{
			str_date1 = convertDate(str_date,'DMY',locale,'en');
			//alert('dt '+str_date1);
			arr_date = str_date1.split('/');
			}
			

			//alert('year '+ arr_date[2]);

			dt_date.setYear(arr_date[2]);

			if (arr_date[1] < 1 || arr_date[1] > 12) flag=false;

			dt_date.setMonth(arr_date[1]-1);
			
			var dt_numdays = new Date(arr_date[2], arr_date[1], 0);

			dt_date.setDate(arr_date[0]);

			//alert('before flag '+flag);
			if (dt_date.getMonth() != (arr_date[1]-1)) flag=false;
			//alert('after flag '+flag);

		//	alert('value dt month '+dt_date.getMonth()+' month 1 '+(arr_date[1]-1));

			if (flag==false){
				return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);
			}


		//Added by MuthuN 43650
		if(obj.name=='fromOperationDate_disp'){
			document.forms[0].fromOperationDate.value=convertDate(obj.value,'DMY',locale,'en');
		}else if(obj.name=='toOperationDate_disp'){
			document.forms[0].toOperationDate.value=convertDate(obj.value,'DMY',locale,'en');
		}
	}else{
		//Added by MuthuN 43650
		if(obj.name=='fromOperationDate_disp'){
			document.forms[0].fromOperationDate.value='';
		}else if(obj.name=='toOperationDate_disp'){
			document.forms[0].toOperationDate.value='';
		}		
	}

		return true;
	}
	
	function reset(){
		f_query_rep.document.TopOperationRep.reset();
	}
	
	function numericFilter(){
		  obj =  String.fromCharCode(window.event.keyCode);
		var alphaFilter =/^[0-9]+$/;
		if (!(alphaFilter.test(obj))) {
			window.event.keyCode = 27;
		}
	}
	
	function checkNum(){
		var num = document.getElementById("count").value;
		if(num <= 0 || num > 99999 ){
			document.getElementById("count").value = "";
		}
	}
