
function create(){  
	var cmf=commontoolbarFrame.document.forms[0];
	if(cmf.apply.disabled==true){
      cmf.apply.disabled=false;
    }
	var source=document.forms[0].source.value;
	f_query_add_mod.location.href='../../eOH/jsp/PeriodontalChartMain.jsp?mode=insert&'+source;
}

 /* added on 03/02/2010 for 18555 */
function apply(){
	var formObj1 = window.parent.content.f_query_add_mod.document.forms[0]; 
	var arr1 = formObj1.elements;
	var j = 0;
	var flag;
	var k = 0;
	var n = 0;
	for(var i = 0 ; i < arr1.length; i++){
		
		if(j >= 3){
			if(j == k){
				if(parseInt(arr1[k].value) == 0 || arr1[k].value == ""){
					if(arr1[k].value == null || arr1[k].value == ""){
						var msg = getMessage("CANNOT_BE_BLANK","OT");
						var msgArray = msg.split("&");
						var maxv  = getLabel("Common.MaxValue.label","Common");
						var msgnew = msgArray[0]+maxv+(msgArray[1]);
						//k = parseInt(j) + 14;
						flag = false;
						window.parent.content.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msgnew;	
						break;
					}else{
						//k = parseInt(j) + 14;
						var msgnew = "";
						window.parent.content.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msgnew;	
						//break;
					}
					var mesg = getMessage("APP-OH000149",'OH');
					flag = false;
					window.parent.content.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;	
					break;
			}else{
				//k = parseInt(j) + 14;
				var msgnew = "";
				window.parent.content.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msgnew;	
				//break;
				}
				if(parseInt(arr1[k].value) < parseInt(arr1[k+1].value)){//Added by Sridevi Joshi on 2/14/2010 for IN019311
					k = parseInt(j) + 14;
					n = parseInt(n) + 14;
					var compVal = arr1[n].value
					var msg_1 = getMessage("APP-OH0002","OH");
					var msgArray = msg_1.split("#");
					//alert(msgArray[0]+" "+compVal+" "+(getLabel("eOH.RedIfGreaterEqual.Label","OH"))+msgArray[1]+(getLabel("Common.MaxValue.label","Common")));
					
					alert(msgArray[0]+" "+(getLabel("eOH.RedIfGreaterEqual.Label","OH"))+msgArray[1]+(getLabel("Common.MaxValue.label","Common")));
					//alert("APP-OH0002 "+ compVal +" "+" Red if >= should not be greater than Max Value")
					var mesg="";
					window.parent.content.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
					return false;
				}else{
					k = parseInt(j) + 14;
					n = parseInt(n) + 14;

					flag = true;
				}
			}
			if(j == 6){
				if(parseInt(arr1[j].value) < parseInt(arr1[j+1].value)){
					k = parseInt(j) + 14;
					var compVal = arr1[n].value
					var msg_1 = getMessage("APP-OH0002","OH");
					var msgArray = msg_1.split("#");
					alert(msgArray[0]+" "+compVal+" "+(getLabel("eOH.RedIfGreaterEqual.Label","OH"))+msgArray[1]+(getLabel("Common.MaxValue.label","Common")));
					//	alert("APP-OH0002 "+ compVal +" "+"Red if >= should not be greater than Max Value")
					var mesg="";
					window.parent.content.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
					return false;
				}else{
					k = parseInt(j) + 14;
					flag = true;
				}
			}
			if(j == 3){
				n = parseInt(j);
			}
		}
			j++;
	}
	if(flag == true){
		apply1();
	}
}

function apply1(){	
	var frm=f_query_add_mod.document.forms[0];
	if(frm == null){
		commontoolbarFrame.location.reload();
	}
	else if(frm != null){ 
		var frm=f_query_add_mod.document.forms[0];
		var fields = new Array (frm.chartid,frm.chart_desc);

		var chartid = getLabel("Common.ChartID.label","Common");
		var chart_desc = getLabel("Common.description.label","Common")
		var redif_label = getLabel("eOH.RedIfGreaterEqual.Label","OH")
		
		var names = new Array (chartid,chart_desc);
		/* Added by Sridevi Joshi on 2/10/2010 for IN019026 */
		var y=2;
		var z=2;
		
		var arrObj = frm.elements;
		var total_records = 0;
		for(var p=0;p<arrObj.length;p++){
		   if(arrObj[p].type == "checkbox"){
			   total_records++;
		   }
		 }
	  
		for(var p=0;p<total_records-2;p++){
			var redif_comp_code = eval("frm.select_"+p+".component_desc"+p);
			if(eval("frm.select_"+p).checked == true){
				fields[y] = eval("frm.redif_"+p);
				y = parseInt(y)+1;

				names[z] = redif_comp_code+" "+redif_label;
				z = parseInt(z)+1;
			}
		}
		/* End */

		if(checkFieldsofMst( fields, names, messageFrame)&&chksequence()&&CheckDupeSeq()){	
			var call_servlet_yn = "Y";
			
			var formObj = window.parent.content.f_query_add_mod.document.forms[0]; //window.parent.frames[2].frames[1]
			var params = formObj.params.value;
			var mode = formObj.mode.value;
			var arr = formObj.elements;
			var total_records = 0;
			for(var p=0;p<arr.length;p++){
			   if(arr[p].type == "checkbox"){
				   //if(arr[p].checked == true){
						total_records++;
				  // }
			   }
			}

			for(var l=0;l<=total_records-2;l++){
				var target1 = eval("frm.hdb_mode_"+l);

				if(target1.value=="D"){
					var chart_code=frm.chartid.value;
					//var component_code = eval("frm.comp_code_"+l).value;
					var component_code = eval("frm.select_"+l+".component_code"+l);//Added by Sridevi Joshi on 4/7/2010 for IN020529..component_code was coming as 'undefined' because with this validation was not firing
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "component_code="+component_code+"&chart_code="+chart_code;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","MCommonValidation.jsp?func_mode=countDtlRecords&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal = trimString(xmlHttp.responseText);
					retVal = trimString(retVal);
					if(parseInt(retVal) > 0){
						call_servlet_yn = "N";
						alert(getMessage("APP-OH00084","OH"));
						break;
					}
				}
			}
			
			var xmlStr=formXMLString(formObj);	
			if(xmlStr!="<root></root>"){
				var action="../../servlet/eOH.PeriodontalChartServlet?mode="+mode;
				var xmlDoc = "";
				var xmlHttp = new XMLHttpRequest();
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST",action,false);
				xmlHttp.send(xmlDoc);
				var retVal = xmlHttp.responseText;
				var mesg = retVal;
				var mesg1=mesg.split(" ");
			
				if(mesg1[0]=="APP-000064")
				{  
					window.parent.content.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
				}
				else if(mesg1[0]!="APP-000064")
				{
				onSuccess();
				window.parent.content.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
				}
			}else {
				var msg = getMessage("NO_CHANGE_TO_SAVE","common");
				messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
			} 
		}
		else
		{  
			commontoolbarFrame.location.reload();
			var flag=checkFieldsofMst( fields, names, messageFrame);
			
			if(flag==false)
			{
				var errors = "" ;
				for( var i=0; i<fields.length; i++ ) {
				if(trimCheck(fields[i].value)) {
				fields[i].value = trimString(fields[i].value);
				}
				else   {

				errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(names[i])))+"<br>"
				}
				}
				if ( errors.length != 0 ) {
				messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
			    }
			}
		}
	}
}

function reset(){
	var frm=f_query_add_mod.document.forms[0];
	
	if(frm == null){
		commontoolbarFrame.location.reload();
	}
	else if(frm != null){
		f_query_add_mod.document.forms[0].reset();
	}
}

function query(){
	var cmf=commontoolbarFrame.document.forms[0];
	var source=document.forms[0].source.value;
	if(cmf.apply.disabled==false){
      cmf.apply.disabled=true;
    }
	f_query_add_mod.location.href='../../eOH/jsp/PeriodontalChartQueryCriteria.jsp'
}


function setCheckValue(){
	if(document.forms[0].status.checked==true) {
		document.forms[0].status.value="E";
		document.forms[0].status.db_change='Y';
	}	else {
		document.forms[0].status.value="D";
		document.forms[0].status.db_change='Y';
	}
}

function assignGraphCheckboxValue(obj){
	if(obj.checked==true)
	{obj.value="Y";
	    document.forms[0].status.db_change='Y';}
	else
	{obj.value="N";
	document.forms[0].status.db_change='Y';}
}

function validateCheckBox(obj,indx){
	var formObj = document.forms[0];
	var arrObj = document.forms[0].elements;
	var mode = document.forms[0].mode.value;
	var chart_code = document.forms[0].chart_code.value;
    var count= document.forms[0].count.value;
	var k=0;

	var user_min_value = "";
	var user_max_value = "";
	var user_cutoff = "";
	var sys_min_value = "";
	var sys_max_value = "";
	var sys_cut_off = "";
		
   var target=eval("document.forms[0].select_"+indx);
   var target1=eval("document.forms[0].sequence_"+indx);
   var chartid=formObj.chartid.value;
   var comp_code = eval("obj.component_code"+indx);

   /* if((comp_code == "PD" || comp_code == "CEJ") && obj.checked == true){
		document.forms[0].select_3.checked == true
	}*/

   if(comp_code == "CAL" && obj.checked == true){
	   var PD_selected = "N";
	   var CEJ_selected = "N";
	   var arrObj = formObj.elements;
	   var total_records = 0;
	   for(var p=0;p<arrObj.length;p++){
		   if(arrObj[p].type == "checkbox"){
			   total_records++;
		   }
	   }
	   
	   for(var p=0;p<total_records-2;p++){
			if(eval("document.forms[0].select_"+p+".component_code"+p) == "PD"){
				if(eval("document.forms[0].select_"+p).checked == true){
					PD_selected = "Y";
				}
			}
			else if(eval("document.forms[0].select_"+p+".component_code"+p) == "CEJ"){
				if(eval("document.forms[0].select_"+p).checked == true){
					CEJ_selected = "Y";
				}
			}
	   }

	   if(PD_selected != "Y" || CEJ_selected != "Y"){
			alert(getMessage("APP-OH00082","OH"));
			obj.checked = false;
			obj.value = "N";
			return;
	   }
   }
   else{
	   var CAL_selected = "N";
	   if((comp_code == "PD" || comp_code == "CEJ" ) && obj.checked == false){
			for(var k=0;k<12;k++){
				if(eval("document.forms[0].select_"+k+".component_code"+k) == "CAL"){
					if(eval("document.forms[0].select_"+k).checked == true){
						CAL_selected = "Y";
					}
				}
			}
			if(CAL_selected == "Y"){
			   alert(getMessage("APP-OH00082","OH"));
				obj.checked = true;
				obj.value = "Y";
				return;
			}
	   }
   }
	
	if(formObj.status.db_change=='Y'){
		formObj.status.db_change='N'
	}

	var db_mode="";
	validatevalues(indx);
	if (mode=="insert"){
		var objname=obj.name;
		var id = objname.replace("select_","");
		var target1 = eval("formObj.hdb_mode_"+id);
		target1.value="I";
	} else if (mode=="modify"){
			var objname=obj.name;
			var id = objname.replace("select_","");
			//removed from if condition and Added it as globaly by Sridevi Joshi on 2/10/2010 for IN019189
			var target2 = eval("formObj.sequence_"+id);
			target2.value=eval("formObj.sequence_"+id).value;
				
			var target3 = eval("formObj.minvalue_"+id);
			target3.value=eval("formObj.hmin_value"+id).value;
				
			var target4 = eval("formObj.maxvalue_"+id);
			target4.value=eval("formObj.hmax_value"+id).value;

			var target5 = eval("formObj.redif_"+id);
			target5.value=eval("formObj.hcut_off"+id).value;
			
		if(obj.checked==true){
			db_mode=Insmodcheck(obj,indx);
			
			var target1 = eval("formObj.hdb_mode_"+id);
			if(db_mode=="I"){
				target1.value="I";
			}else {
				target1.value="M";
			}
		}else{
			var objname=obj.name;
			var id = objname.replace("select_","");
			var target1 = eval("formObj.hdb_mode_"+id);
			
			//var target2 = eval("formObj.sequence_"+id);
			//target2.value="";
			
			target1.value="D";
		}

		validatevalues(indx)
	}

	if(obj.value!="" || obj.value!=null){
		formObj.modified_flag.value="true";
		obj.selected_yn="Y";
		obj.db_change="Y";
		var target1=eval("document.forms[0].hselect_"+indx);
		target1.value='Y';
	}

	if(comp_code == "CAL" && obj.checked == true){
		var PD_min_value=formObj.minvalue_11.value;
		var PD_max_value=formObj.maxvalue_11.value;
		var PD_redif_value=formObj.redif_11.value;

		var CEJ_min_value=formObj.minvalue_1.value;
		var CEJ_max_value=formObj.maxvalue_1.value;
		var CEJ_redif_value=formObj.redif_1.value;

		var CAL_min_value=formObj.minvalue_3.value;
		var CAL_max_value=formObj.maxvalue_3.value;
		var CAL_redif_value=formObj.redif_3.value;

		//To get the max and min values from OH_PERIODONTAL_CHART_DEF_DTL(user defined) added by Sridevi Joshi on 1/13/2010 for IN017876
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "component_code="+comp_code+"&chart_code="+chart_code+"&mode="+mode;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","MCommonValidation.jsp?func_mode=populateUserMinMaxValue&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		if(retVal.length >1){
			var retVal_arr=retVal.split("~");
			for(i=0;i<retVal_arr.length-1;i++){
				var user_min_maxvalue = retVal_arr[i].split("##");	
				user_min_value	= user_min_maxvalue[0];
				user_max_value 	= user_min_maxvalue[1];
				user_cutoff	= user_min_maxvalue[2];
			}
		}

		var cut_off = 0;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "component_code="+comp_code;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","MCommonValidation.jsp?func_mode=populateMinMaxValue&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		if(retVal.length >1){
			var retVal_arr=retVal.split("~");
			for(i=0;i<retVal_arr.length-1;i++){
				var min_maxvalue = retVal_arr[i].split("##");	
				sys_min_value	= min_maxvalue[0];
				sys_max_value 	= min_maxvalue[1];
				sys_cut_off 	= min_maxvalue[2];
			}
		}


		if(user_cutoff == ""){
			user_cutoff = cut_off;
		}

		/* Added by Sridevi Joshi on 1/7/2010 for IN017778 */
		if(parseInt(CEJ_max_value) >= parseInt(PD_max_value)){
			//Codes commented by rajesh for changing the logic of adding CEJ and PD to CAL instead of > Number for Inc IN018426

			/*if(parseInt(CEJ_max_value) >= parseInt(CAL_redif_value)){
				formObj.maxvalue_3.value = CEJ_max_value;
			}else{
				//alert(getMessage("APP-OH000151","OH"));
				//formObj.maxvalue_11.focus();
				//formObj.maxvalue_11.value = user_max_value;
				//eval("formObj.redif_"+indx).value = user_cutoff;
				//return false;
			}*/
			formObj.maxvalue_3.value=parseInt(CEJ_max_value) + parseInt(PD_max_value);
		}
		else if(parseInt(CEJ_max_value) <= parseInt(PD_max_value)){
			//Codes commented by rajesh for changing the logic of adding CEJ and PD to CAL instead of > Number for Inc IN018426
			formObj.maxvalue_3.value=parseInt(CEJ_max_value) + parseInt(PD_max_value);
			/*if(parseInt(PD_max_value) >= parseInt(CAL_redif_value)){
				formObj.maxvalue_3.value = PD_max_value;
			}else{
				//alert(getMessage("APP-OH000151","OH"));
				//formObj.maxvalue_11.focus();
				//formObj.maxvalue_11.value = user_max_value;
				//eval("formObj.redif_"+indx).value = user_cutoff;
				//return false;
			}*/
		}

		if(parseInt(CEJ_min_value) <= parseInt(PD_min_value)){
			if(parseInt(CEJ_min_value) <= parseInt(CAL_redif_value)){
				formObj.minvalue_3.value = CEJ_min_value;
			}else{
				//alert(getMessage("APP-OH000150","OH"));
				//formObj.minvalue_11.focus();
				//formObj.maxvalue_11.value = user_min_value;
				//eval("formObj.redif_"+indx).value = user_cutoff;
				//return false;
			}
		}
		else if(parseInt(CEJ_min_value) >= parseInt(PD_min_value)){
			if(parseInt(PD_min_value) <= parseInt(CAL_redif_value)){
				formObj.minvalue_3.value = PD_min_value;
			}else{
				//alert(getMessage("APP-OH000150","OH"));
				//formObj.minvalue_11.focus();
				//formObj.maxvalue_11.value = user_min_value;
				//eval("formObj.redif_"+indx).value = user_cutoff;
				//return false;
			}
		}

		if(parseInt(PD_max_value) >= parseInt(CEJ_max_value)){
			//Codes commented by rajesh for changing the logic of adding CEJ and PD to CAL instead of > Number for Inc IN018426
			formObj.maxvalue_3.value=parseInt(PD_max_value) + parseInt(CEJ_max_value);
			/*if(parseInt(PD_max_value) >= parseInt(CAL_redif_value)){
				formObj.maxvalue_3.value = PD_max_value;
			}else{
				//alert(getMessage("APP-OH000151","OH"));
				//formObj.maxvalue_1.focus();
				//formObj.maxvalue_1.value = user_max_value;
				//eval("formObj.redif_"+indx).value = user_cutoff;
				//return false;
			}*/
		}
		else if(parseInt(PD_max_value) <= parseInt(CEJ_max_value)){
			//Codes commented by rajesh for changing the logic of adding CEJ and PD to CAL instead of > Number for Inc IN018426
			formObj.maxvalue_3.value=(parseInt(PD_max_value) + parseInt(CEJ_max_value));
/*			if(parseInt(CEJ_max_value) >= parseInt(CAL_redif_value)){
				formObj.maxvalue_3.value = CEJ_max_value;
			}else{
				//alert(getMessage("APP-OH000151","OH"));
				//formObj.maxvalue_1.value = user_max_value;
				//eval("formObj.redif_"+indx).value = user_cutoff;
				//formObj.maxvalue_1.focus();
				//return false;
			}*/
		}


		if(parseInt(PD_min_value) <= parseInt(CEJ_min_value)){
			if(parseInt(PD_min_value) <= parseInt(CAL_redif_value)){
				formObj.minvalue_3.value = PD_min_value;
			}else{
				//alert(getMessage("APP-OH000150","OH"));
				//formObj.maxvalue_1.value = user_min_value;
				//eval("formObj.redif_"+indx).value = user_cutoff;
				//formObj.minvalue_1.focus();
				//return false;
			}
		}
		else if(parseInt(PD_min_value) >= parseInt(CEJ_min_value)){
			if(parseInt(CEJ_min_value) <= parseInt(CAL_redif_value)){
				formObj.minvalue_3.value = CEJ_min_value;
			}else{
				//alert(getMessage("APP-OH000150","OH"));
				//formObj.maxvalue_1.value = user_min_value;
				//eval("formObj.redif_"+indx).value = user_cutoff;
				//formObj.minvalue_1.focus();
				//return false;
			}
		}
	}
}

function Insmodcheck(obj,indx){
	var formObj = document.forms[0];
	var arrObj = document.forms[0].elements;
	var mode = document.forms[0].mode.value;
	
	var objname=obj.name;
	var id = objname.replace("select_","");
	var target1 = eval("formObj.sequence_"+id+".value");
	var target2 = eval("formObj.hsequence_no"+id+".value");
	var target3 = eval("formObj.minvalue_"+id+".value");
	var target4 = eval("formObj.hmin_value"+id+".value");
	var target5 = eval("formObj.maxvalue_"+id+".value");
	var target6 = eval("formObj.hmax_value"+id+".value");
	var target7 = eval("formObj.redif_"+id+".value");
	var target8 = eval("formObj.hcut_off"+id+".value");
	var db_mode="";
	if(target1==target2 || target3==target4 || target5==target6 || target7==target8 ){
		db_mode="I";
	} else if(target2=="" || target4=="" || target6=="" || target8=="") {
		db_mode="I";
	}else if (target1!=target2 || target3!=target4 || target5!=target6 || target7!=target8 ) {
		db_mode="M";
	}
	return db_mode;
}



function formXMLString(formObj){
	var mode=formObj.mode.value;
	var arrObj = formObj.elements;
		
	var xmlString="<root>";

	for(var i=0;i<arrObj.length;i++){ //Added by Sridevi Joshi on 4/8/2010 for IN020529...If used deselect one component and selects the other with same sequence then to delete the record first and to insert next..
		if(arrObj[i].type=="checkbox" && arrObj[i].db_change=="Y"){
			var indx =  arrObj[i].name;
			if (indx.length==9){
			     indx = indx.substr(indx.length-2,2);
			} else {
	           indx = indx.substr(indx.length-1,1);
			}

			var chart_desc = formObj.chart_desc.value;
			chart_desc = escape(chart_desc);
			if(eval('formObj.hdb_mode_'+indx+'.value') != "D"){
				xmlString+="<RECORD_"+indx+" ";
				xmlString+=" chart_id=\""+formObj.chartid.value+"\""+" ";
				xmlString+=" chart_desc=\""+chart_desc+"\""+" ";
				xmlString+=" status=\""+formObj.status.value+"\""+" ";
				 
				if (arrObj[i].name!='status' && eval("formObj.hselect_"+indx+".value")=='Y'){
					xmlString+=" db_mode=\""+eval('formObj.hdb_mode_'+indx+'.value')+"\""+" ";
					xmlString+=" component_code=\""+eval('arrObj[i].component_code'+indx)+"\""+" ";
					xmlString+=" sequence_no=\""+eval('formObj.sequence_'+indx+'.value')+"\""+" ";
					xmlString+=" min_value=\""+eval('formObj.minvalue_'+indx+'.value')+"\""+" ";
					xmlString+=" max_value=\""+eval("formObj.maxvalue_"+indx+'.value')+"\""+" ";
					xmlString+=" redif_value=\""+eval("formObj.redif_"+indx+'.value')+"\""+" ";
					xmlString+=" selected_value=\""+eval("arrObj[i].select_yn_"+indx)+"\""+" "+" />";
				
				} 
				else if(formObj.status.db_change=='Y'){
					xmlString+=" db_mode=\"H\""+" />";
				} 
				else {
				   xmlString="<root>";
				}
			}
		}
	}

	for(var i=0;i<arrObj.length;i++){
		if(arrObj[i].type=="checkbox" && arrObj[i].db_change=="Y"){
			var indx =  arrObj[i].name;
			if (indx.length==9){
			     indx = indx.substr(indx.length-2,2);
			} else {
	           indx = indx.substr(indx.length-1,1);
			}

			var chart_desc = formObj.chart_desc.value;
			chart_desc = escape(chart_desc);
			if(eval('formObj.hdb_mode_'+indx+'.value') == "D"){//Added by Sridevi Joshi on 4/8/2010 for IN020529...If used deselect one component and selects the other with same sequence then to delete the record first and to insert next..
				xmlString+="<RECORD_"+indx+" ";
				xmlString+=" chart_id=\""+formObj.chartid.value+"\""+" ";
				xmlString+=" chart_desc=\""+chart_desc+"\""+" ";
				xmlString+=" status=\""+formObj.status.value+"\""+" ";
				 
				if (arrObj[i].name!='status' && eval("formObj.hselect_"+indx+".value")=='Y'){
					xmlString+=" db_mode=\""+eval('formObj.hdb_mode_'+indx+'.value')+"\""+" ";
					xmlString+=" component_code=\""+eval('arrObj[i].component_code'+indx)+"\""+" ";
					xmlString+=" sequence_no=\""+eval('formObj.sequence_'+indx+'.value')+"\""+" ";
					xmlString+=" min_value=\""+eval('formObj.minvalue_'+indx+'.value')+"\""+" ";
					xmlString+=" max_value=\""+eval("formObj.maxvalue_"+indx+'.value')+"\""+" ";
					xmlString+=" redif_value=\""+eval("formObj.redif_"+indx+'.value')+"\""+" ";
					xmlString+=" selected_value=\""+eval("arrObj[i].select_yn_"+indx)+"\""+" "+" />";
				
				} 
				else if(formObj.status.db_change=='Y'){
					xmlString+=" db_mode=\"H\""+" />";
				} 
				else {
				   xmlString="<root>";
				}
			}
		}
	}

	
	xmlString+="</root>";
	return xmlString;
}

function Checkdbmode(obj,indx){
	if(obj.value.length!=0){
		var formObj=document.forms[0];
		var mode=formObj.mode;
		var target=eval("document.forms[0].select_"+indx);
		if(target.checked && obj.value==""){obj.focus();}

		if (mode.value=="modify" && obj.type=="text"){
			var target="";
			if (("sequence_"+indx)==obj.name) {
				target=eval("formObj.hsequence_no"+indx+".value");
			} else if (("minvalue_"+indx)==obj.name) {
				target=eval("formObj.hmin_value"+indx+".value");
			} else if (("maxvalue_"+indx)==obj.name) {
				target=eval("formObj.hmax_value"+indx+".value");
			} else if (("redif_"+indx)==obj.name) {
				target=eval("formObj.hcut_off"+indx+".value");
			}

			if(obj.value!="" && target!="") {
				var target3=eval("formObj.hdb_mode_"+indx);
				target3.value="M";
				var tempu=eval("formObj.select_"+indx);
				tempu.db_change="Y";
			} else {
				if(eval("document.forms[0].select_"+indx).checked==true){
					var target4=eval("formObj.hdb_mode_"+indx);
					target4.value="I";
					var tempu=eval("formObj.select_"+indx);
					tempu.db_change="Y";
				}
			}
		}else if(mode.value="insert"){
			if(eval("document.forms[0].select_"+indx).checked==true){
					var target4=eval("formObj.hdb_mode_"+indx);
					target4.value="I";
					var tempu=eval("formObj.select_"+indx);
					tempu.db_change="Y";
				}
		}
	}
}

function changeColor(i,obj,min_max_redif,chart_code,user_min_val,user_max_val,user_cutoff,comp_code){
	var formObj=document.forms[0];
	var min_value=eval("formObj.minvalue_"+i).value;
	var max_value=eval("formObj.maxvalue_"+i).value;
	var cutoff=eval("formObj.redif_"+i).value;

	//var user_min_value = ""
	//var user_max_value = ""
	
	var cut_off=obj.value;
	if(cutoff=="") cutoff="0"
	
	// put else if condition on 29/01/2010 for incident 18428
	if(min_value=="") {
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		var minv  = getLabel("eAM.MinValue.label","AM");
		target1=eval("formObj.minvalue_"+i);

		// commented on 29/01/2010 for incident 18428
		//target1.focus();
		alert(msgArray[0]+minv+(msgArray[1]));

		if(min_max_redif == "min"){ //Added by Sridevi Joshi on 2/9/2010 for IN019026
			eval("formObj.minvalue_"+i).value = user_min_val;
		}
		else if(min_max_redif == "max"){//Added by Sridevi Joshi on 2/9/2010 for IN019026
			eval("formObj.maxvalue_"+i).value = user_max_val;
		} 

		if(comp_code == "CEJ" || comp_code == "PD"){
			if(min_max_redif == "min"){ //Added by Sridevi Joshi on 2/9/2010 for IN019026
				//formObj.minvalue_3.value = parseInt(formObj.minvalue_1.value)+parseInt(formObj.minvalue_11.value);
				if(parseInt(formObj.minvalue_1.value)<=parseInt(formObj.minvalue_11.value)){
					formObj.minvalue_3.value = parseInt(formObj.minvalue_1.value);
				}
				else if(parseInt(formObj.minvalue_1.value)>=parseInt(formObj.minvalue_11.value)){
					formObj.minvalue_3.value = parseInt(formObj.minvalue_11.value);
				}
			}
			else if(min_max_redif == "max"){//Added by Sridevi Joshi on 2/9/2010 for IN019026
				formObj.maxvalue_3.value = parseInt(formObj.maxvalue_1.value)+parseInt(formObj.maxvalue_11.value);
			} 
		}

		return;

	}else if(max_value=="") {
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		var maxv  = getLabel("Common.MaxValue.label","Common");
		target1=eval("formObj.maxvalue_"+i);

		// commented on 29/01/2010 for incident 18428

		//target1.focus();
		alert(msgArray[0]+maxv+(msgArray[1]));

		if(min_max_redif == "min"){//Added by Sridevi Joshi on 2/9/2010 for IN019026
			eval("formObj.minvalue_"+i).value = user_min_val;
		}
		else if(min_max_redif == "max"){//Added by Sridevi Joshi on 2/9/2010 for IN019026
			eval("formObj.maxvalue_"+i).value = user_max_val;
		} 

		if(comp_code == "CEJ" || comp_code == "PD"){
			if(min_max_redif == "min"){ //Added by Sridevi Joshi on 2/9/2010 for IN019026
				//formObj.minvalue_3.value = parseInt(formObj.minvalue_1.value)+parseInt(formObj.minvalue_11.value);
				if(parseInt(formObj.minvalue_1.value)<=parseInt(formObj.minvalue_11.value)){
					formObj.minvalue_3.value = parseInt(formObj.minvalue_1.value);
				}
				else if(parseInt(formObj.minvalue_1.value)>=parseInt(formObj.minvalue_11.value)){
					formObj.minvalue_3.value = parseInt(formObj.minvalue_11.value);
				}
			}
			else if(min_max_redif == "max"){//Added by Sridevi Joshi on 2/9/2010 for IN019026
				formObj.maxvalue_3.value = parseInt(formObj.maxvalue_1.value)+parseInt(formObj.maxvalue_11.value);
			} 
		}

		return;
	}
	
	max_value= parseInt(max_value);
	min_value= parseInt(min_value);
	cutoff= parseInt(cutoff);

	
	if(cutoff > max_value){
		//obj.style.color="#FF0033";
		//eval("formObj.redif_"+i).style.color="#FF0033";
		if(max_value != "0"){
			var redif_comp_desc = eval("formObj.select_"+i+".component_desc"+i); //Added by Sridevi Joshi on 4/12/2010
			var msg_1 = getMessage("APP-OH0002","OH");
			var msgArray = msg_1.split("#");
			//obj.focus();
			//eval("formObj.redif_"+i).focus();
			alert(msgArray[0]+redif_comp_desc+" "+(getLabel("eOH.RedIfGreaterEqual.Label","OH"))+msgArray[1]+(getLabel("Common.MaxValue.label","Common")));
			//Added by rajesh for IN018424 on 22/01/10
			if(comp_code=="CAL" || comp_code=="CEJ" || comp_code=="PD"){
				eval("formObj.redif_"+i).value = "";
			}else{
				eval("formObj.redif_"+i).value = user_cutoff;
			}

			if(min_max_redif == "min"){
				eval("formObj.minvalue_"+i).value = user_min_val;
			}
			else if(min_max_redif == "max"){
				eval("formObj.maxvalue_"+i).value = user_max_val;
			} 

			
			if(comp_code == "CEJ" || comp_code == "PD"){
				if(min_max_redif == "min"){ //Added by Sridevi Joshi on 2/9/2010 for IN019026
					//formObj.minvalue_3.value = parseInt(formObj.minvalue_1.value)+parseInt(formObj.minvalue_11.value);
					if(parseInt(formObj.minvalue_1.value)<=parseInt(formObj.minvalue_11.value)){
						formObj.minvalue_3.value = parseInt(formObj.minvalue_1.value);
					}
					else if(parseInt(formObj.minvalue_1.value)>=parseInt(formObj.minvalue_11.value)){
						formObj.minvalue_3.value = parseInt(formObj.minvalue_11.value);
					}
				}
				else if(min_max_redif == "max"){//Added by Sridevi Joshi on 2/9/2010 for IN019026
					formObj.maxvalue_3.value = parseInt(formObj.maxvalue_1.value)+parseInt(formObj.maxvalue_11.value);
				} 
			}

			return;
		}
	}
	else if(cutoff < min_value){
		//eval("formObj.redif_"+i).style.color="#FF0033";
		/*
		var msg_2 = getMessage("APP-OH0003","OH");
		var msgArray = msg_2.split("#");
		//obj.focus();
		eval("formObj.redif_"+i).focus();
		alert(msgArray[0]+(getLabel("eOH.RedIfGreaterEqual.Label","OH"))+msgArray[1]+(getLabel("eAM.MinValue.label","AM")));	
		*/

		//eval("formObj.redif_"+i).focus();
		alert(getMessage("APP-OH000152","OH"));

		//eval("formObj.redif_"+i).value = user_cutoff;
		if(comp_code=="CAL" || comp_code=="CEJ" || comp_code=="PD"){ //Added by Sridevi Joshi on 2/14/2010 for IN019311
				eval("formObj.redif_"+i).value = "";
			}else{
				eval("formObj.redif_"+i).value = user_cutoff;
			}
		if(min_max_redif == "min"){
			eval("formObj.minvalue_"+i).value = user_min_val;
		}
		else if(min_max_redif == "max"){
			eval("formObj.maxvalue_"+i).value = user_max_val;
		} 

		

		if(comp_code == "CEJ" || comp_code == "PD"){
			if(min_max_redif == "min"){ //Added by Sridevi Joshi on 2/9/2010 for IN019026
				//formObj.minvalue_3.value = parseInt(formObj.minvalue_1.value)+parseInt(formObj.minvalue_11.value);
				if(parseInt(formObj.minvalue_1.value)<=parseInt(formObj.minvalue_11.value)){
					formObj.minvalue_3.value = parseInt(formObj.minvalue_1.value);
				}
				else if(parseInt(formObj.minvalue_1.value)>=parseInt(formObj.minvalue_11.value)){
					formObj.minvalue_3.value = parseInt(formObj.minvalue_11.value);
				}
			}
			else if(min_max_redif == "max"){//Added by Sridevi Joshi on 2/9/2010 for IN019026
				formObj.maxvalue_3.value = parseInt(formObj.maxvalue_1.value)+parseInt(formObj.maxvalue_11.value);
			} 
		}
		return;
	}
	else if(cutoff==""){	
		obj.style.color="#400040";
	}else{
		obj.style.color="#400040";
	}
}


function validatevalues(indx){
	var formObj=document.forms[0];
    var seq_no=eval('formObj.sequence_'+indx);
    var min_value=eval('formObj.minvalue_'+indx);
    var max_value=eval('formObj.maxvalue_'+indx);
    var redif_value=eval('formObj.redif_'+indx);
	//var fields = new Array (seq_no,min_value,max_value,redif_value);
	var fields = new Array (seq_no,min_value,max_value);
	var seq_no_title = getLabel("eOH.Sequence.Label","OH");
	var min_value_title = getLabel("eAM.MinValue.label","AM")
	var max_value_title  = getLabel("Common.MaxValue.label","Common");
	var redif_value_title  = getLabel("eOH.RedIfGreaterEqual.Label","OH");
	//var names = new Array (seq_no_title,min_value_title, max_value_title,redif_value_title);
	var names = new Array (seq_no_title,min_value_title, max_value_title);
	messageFrame=window.parent.messageFrame;

	/* Added by Sridevi Joshi on 4/7/2010 for IN020529 */
		var y=3;
		var z=3;
		
		var arrObj = formObj.elements;
		var total_records = 0;
		for(var p=0;p<arrObj.length;p++){
		   if(arrObj[p].type == "checkbox"){
			   total_records++;
		   }
		 }
	  
		for(var p=0;p<total_records-2;p++){
			var redif_comp_code = eval("formObj.select_"+p+".component_desc"+p);
			if(eval("formObj.select_"+p).checked == true){
				fields[y] = eval("formObj.redif_"+p);
				y = parseInt(y)+1;

				names[z] = redif_comp_code+" "+redif_value_title;
				z = parseInt(z)+1;
			}
		}
		/* End */

	if(eval('formObj.select_'+indx+'.checked')){
		var msg_yn = checkFieldsofMst( fields, names, messageFrame);
		if(msg_yn == true){ //Added by Sridevi Joshi on 1/20/2010 for IN017778 to clear the msg frame if the field is not blank.
			messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp";
		}

		if (seq_no.value==""){
			seq_no.focus();
		}
		else if(min_value.value=="" && min_value.disabled==false){
			min_value.focus();
		}else if (max_value.value=="" && max_value.disabled==false ){
			max_value.focus();
		}else if (redif_value.value=="" && redif_value.disabled==false ){
			redif_value.focus();
		} else {
			return true;
		}
	}
	else{
		messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp";
	}
}


function CheckDupeSeq(val,indx){
    var exist=false;
	var formObj=document.forms[0];
	var obj=eval("formObj.sequence_"+indx);
	var j=formObj.ival.value;
	for(i=0;i<j;i++){
		var seq=eval("formObj.sequence_"+i);
		if(obj!=seq && seq!=null){
			seq=parseInt(seq.value);
			val=parseInt(val);
			if(seq==val){
				exist=true;
				break;
			} 
		}
	}
    if(exist){
		obj.focus();
		alert(getMessage("RECORD_ALREADY_EXISTS","common"));
		if(formObj.mode.value=="modify"){
		obj.select();
	     return false;
		}
    }else{
	     return true;
    }
}


function CheckNum(obj) {

    if ( trimCheck(obj.value) && isNaN(obj.value) == false && (obj.value >= -10 ||  obj.value <= 10)) {
		var value=trimString(obj.value);
		obj.value=value;
        return true;
    }
    else {
        if ( obj.value.length > 0 ) {

            alert(getMessage("NUM_ALLOWED", "SM"));
            obj.select();
            obj.focus();
            return false;
        }
    }
}


function CheckNumMaxMin(obj,obj1,obj2,component_code,chart_code){
	var formObj=document.forms[0];
    var min_value="";
	var max_value="";
	var user_min_value="";
	var user_max_value="";
	var user_cutoff="";
	var comp_val = obj.value;

	// added on 04/03/2010 for incident 19400
	if(obj.value != "" && obj.value != "0"){ // condition for '0' is added by Sridevi joshi on 4/6/2010 for IN020487
		if(obj.value.substring(0,1) == 0 && obj.value.substring(0,2) != 00){
			comp_val = obj.value.substring(1,3)
			obj.value = comp_val;
		}
		if(obj.value.substring(0,1) == 0 && obj.value.substring(0,2) == 00){
			comp_val = obj.value.substring(2,3)
			obj.value = comp_val;
		}
	}

	var mode = formObj.mode.value;

	var min_val_1 =eval("formObj.minvalue_"+obj2+".value");
	var max_val_1 = eval("formObj.maxvalue_"+obj2+".value");
	var selected_yn = formObj.select_3.checked;

	//To get the max and min values from OH_PERIODONTAL_CHART_DEF_DTL(user defined) added by Sridevi Joshi on 1/13/2010 for IN017876
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "component_code="+component_code+"&chart_code="+chart_code+"&mode="+mode;

	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","MCommonValidation.jsp?func_mode=populateUserMinMaxValue&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	if(retVal.length >1){
		var retVal_arr=retVal.split("~");
        for(i=0;i<retVal_arr.length-1;i++){
			var user_min_maxvalue = retVal_arr[i].split("##");	
		    user_min_value	= user_min_maxvalue[0];
			user_max_value 	= user_min_maxvalue[1];
			user_cutoff	= user_min_maxvalue[2];
	    }
	}

	/* Added by Sridevi Joshi on 12/30/2009 for IN017778 */
	if(obj1 == "max" && parseInt(comp_val) == 0){
		alert(getMessage("APP-OH000149",'OH'));
		//obj.focus();
		obj.value = user_max_value;

		if(component_code == "CEJ" || component_code == "PD"){
			if(obj1 == "max"){//Added by Sridevi Joshi on 2/9/2010 for IN019026
			
				formObj.maxvalue_3.value = parseInt(formObj.maxvalue_1.value)+parseInt(formObj.maxvalue_11.value);
			} 
		}
		return false;
	}

	var cut_off = 0;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "component_code="+component_code;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","MCommonValidation.jsp?func_mode=populateMinMaxValue&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	if(retVal.length >1){
		var retVal_arr=retVal.split("~");
        for(i=0;i<retVal_arr.length-1;i++){
			var min_maxvalue = retVal_arr[i].split("##");	
		    min_value	= min_maxvalue[0];
			max_value 	= min_maxvalue[1];
			cut_off 	= min_maxvalue[2];

		}
	}

	if(user_cutoff == ""){
		user_cutoff = cut_off;
	}

	if(user_max_value == "" && obj1 == "max"){
		user_max_value = max_value;
	}

	if(user_min_value == "" && obj1 == "min"){
		user_min_value = min_value;
	}

	/*if(max_val_1 == "" && user_max_value == ""){
		user_max_value = max_value;
	}

	if(min_val_1 == "" && user_min_value == ""){
		user_min_value = min_value;
	}*/


	if(parseInt(min_val_1) > parseInt(max_val_1)){ //Added by Sridevi Joshi on 1/13/2010 for IN017876
		//alert("APP-OH000156 Min Val Cannot be grater than Max Val");
		alert(getMessage("APP-OH000156","OH"));
		if(obj1 == "min"){
			obj.value=user_min_value;
			if(component_code == "CEJ" || component_code == "PD"){//Added by Sridevi Joshi on 2/9/2010 for IN019026
				//formObj.minvalue_3.value = parseInt(formObj.minvalue_1.value)+parseInt(formObj.minvalue_11.value);
				if(parseInt(formObj.minvalue_1.value)<=parseInt(formObj.minvalue_11.value)){
					formObj.minvalue_3.value = parseInt(formObj.minvalue_1.value);
				}
				else if(parseInt(formObj.minvalue_1.value)>=parseInt(formObj.minvalue_11.value)){
					formObj.minvalue_3.value = parseInt(formObj.minvalue_11.value);
				}
			}
		}
		else if(obj1 == "max"){
			obj.value=user_max_value;
			if(component_code == "CEJ" || component_code == "PD"){//Added by Sridevi Joshi on 2/9/2010 for IN019026
				formObj.maxvalue_3.value = parseInt(formObj.maxvalue_1.value)+parseInt(formObj.maxvalue_11.value);
			}
		}

		return false;
	}

	if(component_code == "PD" || component_code == "CEJ"){ //This block is to assign min and max values CAL based on PD and CEJ values 
		var PD_min_value=formObj.minvalue_11.value;
		var PD_max_value=formObj.maxvalue_11.value;
		var PD_redif_value=formObj.redif_11.value;

		var CEJ_min_value=formObj.minvalue_1.value;
		var CEJ_max_value=formObj.maxvalue_1.value;
		var CEJ_redif_value=formObj.redif_1.value;

		var CAL_min_value=formObj.minvalue_3.value;
		var CAL_max_value=formObj.maxvalue_3.value;
		var CAL_redif_value=formObj.redif_3.value;
		/* Added by Sridevi Joshi on 1/5/2010 for IN017778 */

		/*
		Altered by rajesh for IN018426.. Min value of CAl must be the Min of PD & CEJ and Max value of CAL should be the addition of PD and CEJ
		*/
		if(component_code == "PD" && obj1 == "max" && parseInt(CEJ_max_value) >= parseInt(comp_val)){
			if(parseInt(CEJ_max_value) >= parseInt(CAL_redif_value)){
				var total=parseInt(CEJ_max_value)+parseInt(comp_val);
				//formObj.maxvalue_3.value = CEJ_max_value;
				formObj.maxvalue_3.value = total;
			}else{
				formObj.maxvalue_3.value = parseInt(formObj.maxvalue_1.value)+parseInt(formObj.maxvalue_11.value);//Added by Sridevi Joshi on 2/9/2010 for IN019026
				if(parseInt(formObj.maxvalue_3.value) > parseInt(CAL_redif_value)){//Added by Sridevi Joshi on 2/15/2010
					alert(getMessage("APP-OH000151","OH"));
					formObj.maxvalue_11.value = user_max_value;
					formObj.maxvalue_3.value = parseInt(formObj.maxvalue_1.value)+parseInt(formObj.maxvalue_11.value);//Added by Sridevi Joshi on 2/9/2010 for IN019128
					return false;
				}
			}
		}
		else if(component_code == "PD" && obj1 == "max" && parseInt(CEJ_max_value) <= parseInt(comp_val)){
			if(parseInt(comp_val) >= parseInt(CAL_redif_value)){
				var total=parseInt(CEJ_max_value)+parseInt(comp_val);
				//formObj.maxvalue_3.value = comp_val;
				formObj.maxvalue_3.value = total;
			}else{
				
				//formObj.maxvalue_11.focus();
				
				formObj.maxvalue_3.value = parseInt(formObj.maxvalue_1.value)+parseInt(formObj.maxvalue_11.value);//Added by Sridevi Joshi on 2/9/2010 for IN019026
				if(parseInt(formObj.maxvalue_3.value) > parseInt(CAL_redif_value)){//Added by Sridevi Joshi on 2/15/2010
					alert(getMessage("APP-OH000151","OH"));
					formObj.maxvalue_11.value = user_max_value;
					formObj.maxvalue_3.value = parseInt(formObj.maxvalue_1.value)+parseInt(formObj.maxvalue_11.value);//Added by Sridevi Joshi on 2/9/2010 for IN019128
					return false;
				}
				
			}
		}
		else if(component_code == "PD" && obj1 == "min" && parseInt(CEJ_min_value) <= parseInt(comp_val)){
			if(parseInt(CEJ_min_value) <= parseInt(CAL_redif_value)){
				//var total=parseInt(CEJ_min_value)+parseInt(comp_val);
				formObj.minvalue_3.value = CEJ_min_value;
				//formObj.minvalue_3.value = total;
			}else{
				
				//formObj.minvalue_11.focus();
				
				//formObj.minvalue_3.value = parseInt(formObj.minvalue_1.value)+parseInt(formObj.minvalue_11.value);//Added by Sridevi Joshi on 2/9/2010 for IN019026
				if(parseInt(formObj.minvalue_1.value)<=parseInt(formObj.minvalue_11.value)){
					formObj.minvalue_3.value = parseInt(formObj.minvalue_1.value);
				}
				else if(parseInt(formObj.minvalue_1.value)>=parseInt(formObj.minvalue_11.value)){
					formObj.minvalue_3.value = parseInt(formObj.minvalue_11.value);
				}
				alert(getMessage("APP-OH000150","OH"));
				formObj.minvalue_11.value = user_min_value;
				//formObj.minvalue_3.value = parseInt(formObj.minvalue_1.value)+parseInt(formObj.minvalue_11.value);//Added by Sridevi Joshi on 2/9/2010 for IN019128
				if(parseInt(formObj.minvalue_1.value)<=parseInt(formObj.minvalue_11.value)){
					formObj.minvalue_3.value = parseInt(formObj.minvalue_1.value);
				}
				else if(parseInt(formObj.minvalue_1.value)>=parseInt(formObj.minvalue_11.value)){
					formObj.minvalue_3.value = parseInt(formObj.minvalue_11.value);
				}
				return false;
			}
		}
		else if(component_code == "PD" && obj1 == "min" && parseInt(CEJ_min_value) >= parseInt(comp_val)){
			if(parseInt(comp_val) <= parseInt(CAL_redif_value)){
			//	var total=parseInt(CEJ_min_value)+parseInt(comp_val);
			//	formObj.minvalue_3.value = total;
				formObj.minvalue_3.value = comp_val;
			}else{
				
				//formObj.minvalue_11.focus();
				
				//formObj.minvalue_3.value = parseInt(formObj.minvalue_1.value)+parseInt(formObj.minvalue_11.value);//Added by Sridevi Joshi on 2/9/2010 for IN019026
				if(parseInt(formObj.minvalue_1.value)<=parseInt(formObj.minvalue_11.value)){
					formObj.minvalue_3.value = parseInt(formObj.minvalue_1.value);
				}
				else if(parseInt(formObj.minvalue_1.value)>=parseInt(formObj.minvalue_11.value)){
					formObj.minvalue_3.value = parseInt(formObj.minvalue_11.value);
				}
				alert(getMessage("APP-OH000150","OH"));
				formObj.minvalue_11.value = user_min_value;
				//formObj.minvalue_3.value = parseInt(formObj.minvalue_1.value)+parseInt(formObj.minvalue_11.value);//Added by Sridevi Joshi on 2/9/2010 for IN019128
				if(parseInt(formObj.minvalue_1.value)<=parseInt(formObj.minvalue_11.value)){
					formObj.minvalue_3.value = parseInt(formObj.minvalue_1.value);
				}
				else if(parseInt(formObj.minvalue_1.value)>=parseInt(formObj.minvalue_11.value)){
					formObj.minvalue_3.value = parseInt(formObj.minvalue_11.value);
				}
				return false;
			}
		}
		else if(component_code == "CEJ" && obj1 == "max" && parseInt(PD_max_value) >= parseInt(comp_val)){
			if(parseInt(PD_max_value) >= parseInt(CAL_redif_value)){
				//Added by rajesh for IN018426 instructed by vishwa on 22/01/2010
				//formObj.maxvalue_3.value = PD_max_value;
				var total=parseInt(PD_max_value)+parseInt(comp_val);
				formObj.maxvalue_3.value = total;
			}else{
				
				//formObj.maxvalue_1.focus();
				
				formObj.maxvalue_3.value = parseInt(formObj.maxvalue_1.value)+parseInt(formObj.maxvalue_11.value);//Added by Sridevi Joshi on 2/9/2010 for IN019026
				if(parseInt(formObj.maxvalue_3.value) > parseInt(CAL_redif_value)){//Added by Sridevi Joshi on 2/15/2010
					alert(getMessage("APP-OH000151","OH"));
					formObj.maxvalue_1.value = user_max_value;
					formObj.maxvalue_3.value = parseInt(formObj.maxvalue_1.value)+parseInt(formObj.maxvalue_11.value);//Added by Sridevi Joshi on 2/9/2010 for IN019128
					return false;
				}
			}
		}
		else if(component_code == "CEJ" && obj1 == "max" && parseInt(PD_max_value) <= parseInt(comp_val)){
			if(parseInt(comp_val) >= parseInt(CAL_redif_value)){
				var total=parseInt(PD_max_value)+parseInt(comp_val);
				//formObj.maxvalue_3.value = comp_val;
				formObj.maxvalue_3.value = total;
			}else{
				
				//formObj.maxvalue_1.focus();
				
				formObj.maxvalue_3.value = parseInt(formObj.maxvalue_1.value)+parseInt(formObj.maxvalue_11.value);//Added by Sridevi Joshi on 2/9/2010 for IN019026
				if(parseInt(formObj.maxvalue_3.value) > parseInt(CAL_redif_value)){//Added by Sridevi Joshi on 2/15/2010
					alert(getMessage("APP-OH000151","OH"));
					formObj.maxvalue_1.value = user_max_value;
					formObj.maxvalue_3.value = parseInt(formObj.maxvalue_1.value)+parseInt(formObj.maxvalue_11.value);//Added by Sridevi Joshi on 2/9/2010 for IN019128
					return false;
				}
			}
		}
		else if(component_code == "CEJ" && obj1 == "min" && parseInt(PD_min_value) <= parseInt(comp_val)){
			if(parseInt(PD_min_value) <= parseInt(CAL_redif_value)){
				//var total=parseInt(PD_min_value)+parseInt(comp_val);
				formObj.minvalue_3.value = PD_min_value;
				//formObj.minvalue_3.value = total;
			}else{
				
				//formObj.minvalue_1.focus();
				
				//formObj.minvalue_3.value = parseInt(formObj.minvalue_1.value)+parseInt(formObj.minvalue_11.value);//Added by Sridevi Joshi on 2/9/2010 for IN019026
				if(parseInt(formObj.minvalue_1.value)<=parseInt(formObj.minvalue_11.value)){
					formObj.minvalue_3.value = parseInt(formObj.minvalue_1.value);
				}
				else if(parseInt(formObj.minvalue_1.value)>=parseInt(formObj.minvalue_11.value)){
					formObj.minvalue_3.value = parseInt(formObj.minvalue_11.value);
				}
				alert(getMessage("APP-OH000150","OH"));
				formObj.minvalue_1.value = user_min_value;
				//formObj.minvalue_3.value = parseInt(formObj.minvalue_1.value)+parseInt(formObj.minvalue_11.value);//Added by Sridevi Joshi on 2/9/2010 for IN019128
				if(parseInt(formObj.minvalue_1.value)<=parseInt(formObj.minvalue_11.value)){
					formObj.minvalue_3.value = parseInt(formObj.minvalue_1.value);
				}
				else if(parseInt(formObj.minvalue_1.value)>=parseInt(formObj.minvalue_11.value)){
					formObj.minvalue_3.value = parseInt(formObj.minvalue_11.value);
				}
				return false;
			}
		}
		else if(component_code == "CEJ" && obj1 == "min" && parseInt(PD_min_value) >= parseInt(comp_val)){
			if(parseInt(comp_val) <= parseInt(CAL_redif_value)){
				//var total=parseInt(PD_min_value)+parseInt(comp_val);
				formObj.minvalue_3.value = comp_val;
				//formObj.minvalue_3.value = total;
			}else{
				
				//formObj.minvalue_1.focus();
				
				//formObj.minvalue_3.value = parseInt(formObj.minvalue_1.value)+parseInt(formObj.minvalue_11.value);//Added by Sridevi Joshi on 2/9/2010 for IN019026
				if(parseInt(formObj.minvalue_1.value)<=parseInt(formObj.minvalue_11.value)){
					formObj.minvalue_3.value = parseInt(formObj.minvalue_1.value);
				}
				else if(parseInt(formObj.minvalue_1.value)>=parseInt(formObj.minvalue_11.value)){
					formObj.minvalue_3.value = parseInt(formObj.minvalue_11.value);
				}
				alert(getMessage("APP-OH000150","OH"));
				formObj.minvalue_1.value = user_min_value;
				//formObj.minvalue_3.value = parseInt(formObj.minvalue_1.value)+parseInt(formObj.minvalue_11.value);//Added by Sridevi Joshi on 2/9/2010 for IN019128
				if(parseInt(formObj.minvalue_1.value)<=parseInt(formObj.minvalue_11.value)){
					formObj.minvalue_3.value = parseInt(formObj.minvalue_1.value);
				}
				else if(parseInt(formObj.minvalue_1.value)>=parseInt(formObj.minvalue_11.value)){
					formObj.minvalue_3.value = parseInt(formObj.minvalue_11.value);
				}
				return false;
			}
		}
	}

	/* End Added by Sridevi Joshi on 12/30/2009 for IN017778 */
	
	if(trimCheck(obj.value) && isNaN(obj.value) == false){
		var value=trimString(obj.value);
		obj.value=parseInt(value);
		if(obj.name!="minvalue_11"){
			if(value=="-09"){
				obj.value=parseInt(-9);
			} 

			if(value=="-08"){
				obj.value=parseInt(-8);
			}
		}

		if(obj.name!="maxvalue_11"){
			   if(value=="-09"){
				obj.value=parseInt(-9);
			 } if(value=="-08"){
				obj.value=parseInt(-8);
			 } if(value=="08"){
				obj.value=parseInt(8);
			 } if(value=="09"){
				obj.value=parseInt(9);
			 }
		}

		if(obj.name=="maxvalue_11"){
			   if(value=="08"){
				obj.value=parseInt(8);
			 } if(value=="09"){
				obj.value=parseInt(9);
			 }
		}

		if(obj.name!="minvalue_11"){
			if(obj.value >= parseInt(max_value)){
				if(obj.value > parseInt(min_value)){
					//		return true;
				}else{
				 	obj.focus();
					
					var msg_1 = getMessage("APP-OH00039","OH");
					var msgArray = msg_1.split("#");
					if(obj1=="max"){
						var title  = getLabel("Common.MaxValue.label","Common");
						if(component_code == "PD"){//Added by Sridevi Joshi on 2/15/2010
							alert(msgArray[0]+msgArray[1]+min_value+" and "+max_value);
						}
						else{
							alert(msgArray[0]+msgArray[1]+min_value+" to -1 and 1 to "+max_value);
						}
					}	
					else{
						var title = getLabel("eAM.MinValue.label","AM")
							alert(msgArray[0]+msgArray[1]+min_value+"  and  "+max_value);
					}

					return;
					
				}
			}

			if(obj1=="min"){
				if(obj.value < parseInt(min_value)){
					obj.focus();
					
					var msg_1 = getMessage("APP-OH00039","OH");
					var msgArray = msg_1.split("#");
					if(obj1=="max"){
						var title  = getLabel("Common.MaxValue.label","Common");
					}	
					else {
						var title = getLabel("eAM.MinValue.label","AM")
					}
					alert(msgArray[0]+msgArray[1]+min_value+"  and  "+max_value);
					return;
				}
			}

			if(obj1=="min"){
				if(obj.value <= parseInt(max_value)){
				}else	 {
					obj.focus();
					
					var msg_1 = getMessage("APP-OH00039","OH");
					var msgArray = msg_1.split("#");
					if(obj1=="max"){
						var title  = getLabel("Common.MaxValue.label","Common");
					}	
					else {
						var title = getLabel("eAM.MinValue.label","AM")
					}
					alert(msgArray[0]+msgArray[1]+min_value+"  and  "+max_value);
					return;
				}
			}
	
			if(obj1=="max"){
				if (obj.value <=parseInt(max_value)&&(obj.value >=parseInt(min_value))){
				} else {
					obj.focus();
					
					var msg_1 = getMessage("APP-OH00039","OH");
					var msgArray = msg_1.split("#");
					if(obj1=="max"){
						var title  = getLabel("Common.MaxValue.label","Common");
						if(component_code == "PD"){//Added by Sridevi Joshi on 2/15/2010
							alert(msgArray[0]+msgArray[1]+min_value+" and "+max_value);
						}
						else{
							alert(msgArray[0]+msgArray[1]+min_value+" to -1 and 1 to "+max_value);
						}
					}	
					else {

						var title = getLabel("eAM.MinValue.label","AM")
							alert(msgArray[0]+msgArray[1]+min_value+"  and  "+max_value);
					}
					return;
					
				}
			}
	
		}

		if(obj.name=="minvalue_11"){ 
			if(obj.value<parseInt(min_value)){
				obj.focus();
				
				var msg_1 = getMessage("APP-OH00039","OH");
			    var msgArray = msg_1.split("#");
				if(obj1=="max"){
					var title  = getLabel("Common.MaxValue.label","Common");
					alert(msgArray[0]+msgArray[1]+min_value+" and "+max_value);
				}	
				else{
					var title = getLabel("eAM.MinValue.label","AM")
						alert(msgArray[0]+msgArray[1]+min_value+"  and  "+max_value);
				}

				return;
				
			}
		}
		  
		if(obj.name=="minvalue_11"){ 
			if (obj.value <=parseInt( max_value)){
			}else {
				obj.focus();
				
				var msg_1 = getMessage("APP-OH00039","OH");
				var msgArray = msg_1.split("#");
				if(obj1=="max"){
					var title  = getLabel("Common.MaxValue.label","Common");
					//alert(msgArray[0]+msgArray[1]+min_value+" to -1 and 1 to "+max_value);
					alert(msgArray[0]+msgArray[1]+min_value+" and "+max_value);
				}	
				else{
					var title = getLabel("eAM.MinValue.label","AM")
						alert(msgArray[0]+msgArray[1]+min_value+"  and  "+max_value);
				}

				return;
				
			}
		}
			
		if(obj1=="max"){
			var min=eval("formObj.minvalue_"+obj2+".value");
			var max=eval("formObj.maxvalue_"+obj2+".value");
			if(parseInt(min)>parseInt(max)) {
				obj.focus();
				var msg_1 = getMessage("APP-OH0004","OH");
				var msgArr = msg_1.split("#");
				var minvalue = getLabel("eAM.MinValue.label","AM");
				var maxvalue =getLabel("Common.MaxValue.label","Common");
			}
		}

		if(obj1=="min"){
			var min=eval("formObj.minvalue_"+obj2+".value");
			var max=eval("formObj.maxvalue_"+obj2+".value");
			if(parseInt(min)>parseInt(max)) {
				obj.focus();
				var msg_1 = getMessage("APP-OH0001","OH");
				var msgArr = msg_1.split("#");
				var minvalue = getLabel("eAM.MinValue.label","AM");
				var maxvalue =getLabel("Common.MaxValue.label","Common");
			}
		}
	} 
	else{
        if( obj.value.length > 0 ) {
            alert(getMessage("NUM_ALLOWED", "SM"));
            obj.select();
            obj.focus();
            return false;
        }
    }
	
	changeColor(obj2,obj,obj1,chart_code,user_min_value,user_max_value,user_cutoff,component_code);
}

function onSuccess()
{
	if(f_query_add_mod.document.forms[0].mode.value=="insert") {
		f_query_add_mod.location.href="../../eOH/jsp/PeriodontalChartMain.jsp?mode=insert";
	} else {
         f_query_add_mod.location.reload();
	}
}

 function alreadyExist(){
	var formObj = document.forms[0];
	var codeDtl = parent.frames[1].code;
	var rows = parent.parent.parent.ObjectCollect.personnel_rows;
	var chart_id=formObj.chartid.value;

	var codeRecord = chart_id;
	if(codeDtl.indexOf(codeRecord)>=0)
	   return false;
	else
	  return true;
 }

function CheckSeqNum(obj) {
	if(obj.value !="" &&obj.value !=null &&obj.value !="null" &&obj.value==parseInt("0")){
		alert( getMessage("APP-OH00087","OH"));
		obj.focus();
		obj.select();
		return false;
	}

	// added on 04/03/2010 for incident 19400

    if(trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {
		//var value=trimString(obj.value);
		if(obj.value != "" ){
			if(obj.value.substring(0,1) == 0 && obj.value.substring(0,2) != 00){
				comp_val = obj.value.substring(1,3)
				obj.value = comp_val;
			}
			if(obj.value.substring(0,1) == 0 && obj.value.substring(0,2) == 00){
				comp_val = obj.value.substring(2,3)
				obj.value = comp_val;
			}
		}
        return true;
	}
    else{
        if( obj.value.length >0 ) {
            alert(getMessage("NUM_ALLOWED", "SM"));
            obj.select();
            obj.focus();
            return false;
        }
    }
}

function CheckRedifNum(obj,i,comp_code,chart_code) {
	var j=0;
	var m=0;

	var formObj=document.forms[0];
	var min_value=eval("formObj.minvalue_"+i).value;
	var max_value=eval("formObj.maxvalue_"+i).value;
	var cutoff=eval("formObj.redif_"+i).value;
	
	// added on 04/03/2010 for incident 19400

	if(obj.value != "" && obj.value != "0"){// condition for '0' is added by Sridevi joshi on 4/6/2010 for IN020487
		if(obj.value.substring(0,1) == 0 && obj.value.substring(0,2) != 00){
			comp_val = obj.value.substring(1,3)
			obj.value = comp_val;
		}
		if(obj.value.substring(0,1) == 0 && obj.value.substring(0,2) == 00){
			comp_val = obj.value.substring(2,3)
			obj.value = comp_val;
		}
	}

	var mode = formObj.mode.value

	var user_min_value="";
	var user_max_value="";
	var user_cutoff="";

	var sys_min_value="";
	var sys_max_value="";
	var sys_cutoff="";

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "component_code="+comp_code;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","MCommonValidation.jsp?func_mode=populateMinMaxValue&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	if(retVal.length >1){
		var retVal_arr=retVal.split("~");
		for(m=0;m<retVal_arr.length-1;m++){
			var min_maxvalue = retVal_arr[m].split("##");	
			sys_min_value	= min_maxvalue[0];
			sys_max_value 	= min_maxvalue[1];
			sys_cut_off 	= min_maxvalue[2];
		}
	}



	//To get the max and min values from OH_PERIODONTAL_CHART_DEF_DTL(user defined) added by Sridevi Joshi on 1/13/2010 for IN017876
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "component_code="+comp_code+"&chart_code="+chart_code+"&mode="+mode;

	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","MCommonValidation.jsp?func_mode=populateUserMinMaxValue&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	if(retVal.length >1){
		var retVal_arr=retVal.split("~");
		for(j=0;j<retVal_arr.length-1;j++){
			var user_min_maxvalue = retVal_arr[j].split("##");	
			user_min_value	= user_min_maxvalue[0];
			user_max_value 	= user_min_maxvalue[1];
			user_cutoff	= user_min_maxvalue[2];
		}
	}


	if(user_cutoff == ""){
		user_cutoff = sys_cut_off;
	}

	
    if ( trimCheck(obj.value) && isNaN(obj.value) == false && (obj.value >= -10 ||  obj.value <= 10)) {
		var value=trimString(obj.value);
		obj.value=parseInt(value);
		if (value=="09"){
			obj.value=parseInt(9);
		}if (value=="08")
		{
			obj.value=parseInt(8);
		}if (value=="-09")
		{
			obj.value=parseInt(-9);
		}if (value=="-08")
		{
			obj.value=parseInt(-8);
		}

		

		/*if(cutoff > max_value) {
			obj.style.color="#FF0033";
			if(max_value != "0"){
				var msg_1 = getMessage("APP-OH0002","OH");
				var msgArray = msg_1.split("#");
				//obj.focus();
				eval("formObj.redif_"+i).focus();
				alert(msgArray[0]+(getLabel("eOH.RedIfGreaterEqual.Label","OH"))+msgArray[1]+(getLabel("Common.MaxValue.label","Common")));
			}
		}
		else if(cutoff < min_value){
			obj.style.color="#FF0033";
			var msg_2 = getMessage("APP-OH0003","OH");
			var msgArray = msg_2.split("#");
			//obj.focus();
			eval("formObj.redif_"+i).focus();
			alert(msgArray[0]+(getLabel("eOH.RedIfGreaterEqual.Label","OH"))+msgArray[1]+(getLabel("eAM.MinValue.label","AM")));	
			
			return;
		}*/
		changeColor(i,obj,"redif",chart_code,user_min_value,user_max_value,user_cutoff,comp_code);
        return true;
    }
    else {
        if ( obj.value.length > 0 ) {
           alert(getMessage("NUM_ALLOWED", "SM"));
            obj.select();
            obj.focus();
            return false;
        }
    }
}

function uncheck(indx){
	var count= document.forms[0].count.value;
	var k=0;
	for(i=0;i<count;i++){   
		var target=eval("document.forms[0].select_"+i);
		var target1=eval("document.forms[0].sequence_"+i);
		 
	    if(k==0 && target.checked && target1.value=="" && indx==i ){
			var msg = getMessage("CANNOT_BE_BLANK","OT");
			var msgArray = msg.split("&");
			var sequence  = getLabel("eOH.Sequence.Label","OH");
			alert(msgArray[0]+sequence+(msgArray[1]));
			target1.focus();
		  
			target.checked=true;
			target.value="Y";
			k++;
		}
         
		if(k>0 && target.checked && target1.value=="" && indx!=i){
		  target.checked=false;
		  target.value="N";
		}
	}
}

function chksequence(){
	var i;
	var errors="";
	var frm=f_query_add_mod.document.forms[0];
	var Sequence = getLabel("eOH.Sequence.Label","OH")
	var not_blank = getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(Sequence)));
	var chkmsg=getMessage("APP-OH00041","OH");
	var j=frm.ival.value;
	var flag;
	for(i=0;i<j;i++){
		if(eval('frm.select_'+i+'.checked')){        
			if(eval("frm.sequence_"+i).value==""||eval("frm.sequence_"+i).value==null){
				errors +=not_blank;
				messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
				
				return false;	
			}
			else{
			  if(i>11)
			  return true;
			}
		}
	}

	var count = 0;
	for(i=0;i<j;i++ ){
		if(eval("frm.sequence_"+i).value!=""||eval("frm.sequence_"+i).value!=null){
			if(eval('frm.select_'+i+'.checked')==true){
				count++;
			}
		}
	}

	if(parseInt(count) <= 0){
		messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+chkmsg;
		return false;
	}

	return true;
}

function checkFieldsofMst( fields, names, messageFrame) {
    var errors = "" ;
    for( var i=0; i<fields.length; i++ ) {
        if(trimCheck(fields[i].value)) {
            fields[i].value = trimString(fields[i].value);
        }
        else   {
			
			errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(names[i])))+"<br>"
		}
    }
    if ( errors.length != 0 ) {
        messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
        return false ;
    }
    return true ;
}

function CheckDupeSeq(){
    var exist=false;
	var flag;
	var formObj=document.forms[0];
	var frm=f_query_add_mod.document.forms[0];
	var indx;
	var errors="";
	for(indx=0;indx<13;indx++){
		var obj=eval("frm.sequence_"+indx);
		var val=eval("frm.sequence_"+indx).value;
		var dup = getMessage("RECORD_ALREADY_EXISTS","common");
		var j=frm.ival.value;
		for(i=0;i<j;i++){
			var seq=eval("frm.sequence_"+i);
			if(obj!=seq && seq!=null){
				seq=parseInt(seq.value);
				val=parseInt(val);
				if(seq==val){
					exist=true;
					break;
				}
			}
		}
	}    
	
	if(exist){
		errors +=dup;
		messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
		return false;
    }
	else{
	   return true;
    }
}
 

function checkForSpecCharsforID(event)
{
    var strCheck = '0123456789-';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}


function checkForSpecCharsforIDSeq(event)
{
    var strCheck = '0123456789';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}
