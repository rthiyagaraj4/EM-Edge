/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function create(){
	var cmf=commontoolbarFrame.document.forms[0];
	if(cmf.apply.disabled==true){
      cmf.apply.disabled=false;
      cmf.reset.disabled=false;
    }
	f_query_add_mod.location.href='../../eOH/jsp/MTasksFrameInCreateMode.jsp?mode=insert';
}

function apply(){
	var count = 0;
	var frm=f_query_add_mod.document.forms[0];
	var hash = new Hashtable();
	hash = window.frames[3].hash;
	var keys = hash.keys();
	if(frm == null){
		try{
			var formObj = window.parent.frames[1].frames[1].frames[1].document.forms[0];
			//var formObj = window.parent.master_pages.f_query_add_mod.detal_frame.document.forms[0];
			if(formObj==null){
				var mesg= getMessage("NO_CHANGE_TO_SAVE","Common");
				window.parent.frames[1].frames[2].document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
				return;
			}
			var mainformObj = window.parent.frames[1].frames[1].frames[0].document.forms[0];
			if(mainformObj == null){
				commontoolbarFrame.location.reload();
			}
			else{
				var sel_val = "";
				var change_seq_no = "";
				var treatment_code = formObj.treatment_code.value;
				//var called_from = formObj.called_from.value;
				//formObj.called_from.value = "";
				var multiple_yn = formObj.multiple_yn.value;
				var arrObj = formObj.elements;
				var mode=formObj.mode.value;
				var treatment_title = getLabel("eOH.Treatment.Label","OH");
				var sqno_title = getLabel("eOR.SeqNo.label","OR");
				var msg = getMessage("CAN_NOT_BE_BLANK","COMMON");
				var msgArray = msg.split("$");
				var fields = new Array (mainformObj.treatment_code);
				var names = new Array (treatment_title);
				//var change = "Y";
				//var db_change="Y";
				var flag_field=chkFields();
				if(checkFieldsofMst( fields, names, messageFrame)&&flag_field==true){
					var arr = formObj.elements;
					var xmlStr=formXMLString();
					var ind = xmlStr.indexOf("\" />");
					if(ind != -1){
						sel_val = xmlStr.substring(ind-1,ind);
					}
					
					var checkedbox_yn = "N";
					//This for loop added by sridevi
					for(var i=0;i<arrObj.length;i++){
						if(arrObj[i].type=="checkbox"){
							if((arrObj[i].value != arrObj[i].select_yn) && arrObj[i].checked == true){
								checkedbox_yn = "Y";
							}
							else{
								checkedbox_yn = "N";
							}
						}
						if(arrObj[i].type=="text"){
							if((arrObj[i].value== null || arrObj[i].value== "null" || arrObj[i].value== "" ) && (arrObj[i+1].checked == true)){
								alert(msgArray[0]+ sqno_title + msgArray[1]); //seq_no should not be blank
								var mesg="";
								window.parent.frames[1].frames[2].document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
								return;
							}
						}
					}
								
					//To get the no of check boxes which are checked...
					var change = "N";
					if(mode == "update"){
						 change = "Y";
					}
					
					if((keys==null)||(keys=='')){
						for(var i=0;i<arrObj.length;i++){
							if(arrObj[i].type=="checkbox"){
								if(arrObj[i].checked == true){
									count++;
									if(arrObj[i].db_change == "Y"){
										change = "Y";
									}
								}
							}
						
						}
					}
					else{
						count++;
						change = "Y";
					}
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "treatment_code="+treatment_code;
					var xmlStr1 ="<root><SEARCH ";
					xmlStr1 +=" /></root>";
					xmlDoc.loadXML(xmlStr1);
					xmlHttp.open("POST","MCommonValidation.jsp?func_mode=countOfCheckedObjects&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal = trimString(xmlHttp.responseText);
					retVal = localTrimString(retVal);
					if(change != "Y"){
						var mesg= getMessage("NO_CHANGE_TO_SAVE","Common");
						window.parent.frames[1].frames[2].document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
					}
					/*
					else 
					if((retVal > 0 && multiple_yn == "N" && sel_val != "N") ||( count > 1 && multiple_yn == "N")){
						var mesg= getMessage("APP-OH00016","OH");
						window.parent.frames[1].frames[2].document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
						//window.parent.frames[1].frames[1].frames[1].document.location.reload();
						return;
					}
					*/
					else{
						if(xmlStr!="<root></root>"){
						//if(count >=0){
							var action="../../servlet/eOH.MTasksLinkServlet?treatment_code="+treatment_code+"&mode="+mode;
							var xmlDoc = "";
							var xmlHttp = new XMLHttpRequest();
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST",action,false);
							xmlHttp.send(xmlDoc);
							var retVal = xmlHttp.responseText;
							var mesg = retVal;
							//f_query_add_mod.location.href='../../eOH/jsp/MTasksFrameInCreateMode.jsp?mode=insert&called_from=';
							window.parent.frames[1].frames[1].frames[1].location.href='../../eOH/jsp/MTasksLinkDetailForm.jsp?mode=insert&called_from=&treatment_code='+treatment_code;
							//callDetailForm();
							window.parent.frames[1].frames[2].document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
						}else{
							//var mesg= getMessage("NO_CHANGE_TO_SAVE","Common");
							var mesg= getMessage("APP-OH00066","OH");
							window.parent.frames[1].frames[2].document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
						}
					}
				} //End of Mandatory check
				else{
					var frm=f_query_add_mod.document.forms[0];
					var hash = new Hashtable();
					hash = window.frames[3].hash;
					if(frm == null){
						try{
							var formobj = window.parent.frames[1].frames[1].frames[1].document.forms[0];
							var mainformobj = window.parent.frames[1].frames[1].frames[0].document.forms[0];
							if (formobj != null){	
								hash.clear();
								window.parent.frames[1].frames[1].frames[1].location.reload();
							}
							else if(mainformobj != null){
								window.parent.frames[1].frames[1].frames[0].location.reload();
							}
							else{
								commontoolbarFrame.location.reload();
							}
						}
						catch(failed){
						}
					}
					else{
						f_query_add_mod.location.reload();	
						  
					}
					commontoolbarFrame.location.reload();
					return;
				}
			}
			
		}
		catch(failed){
			commontoolbarFrame.location.reload();
		}
	}
}

function formXMLString(){
	var formObj = window.parent.frames[1].frames[1].frames[1].document.forms[0];
	var maxRecord=formObj.maxRecord.value;
	var arrObj=formObj.elements;
	var hash = new Hashtable();
	hash = window.frames[3].hash;
	var xmlString="<root>";
	var key = hash.keys();
	for(var i=0;i<hash.size();i++){
		       xmlString+="<RECORD_"+i+" ";
			   xmlString+="task_code=\""+hash.get(key[i])[0]+"\""+" ";
			   xmlString+="seq_no=\""+hash.get(key[i])[2]+"\""+" ";
			   xmlString+="select_value=\""+hash.get(key[i])[3]+"\""+" />";
	}
	xmlString+="</root>";
	hash.clear();
	return xmlString;
}

function onSuccess(){
	if(f_query_add_mod.document.forms[0].mode.value=="insert"){
		f_query_add_mod.location.href='../../eOH/jsp/MTasksLinkFrameInCreateMode.jsp?mode=insert&called_from=';
	}
	else{
         f_query_add_mod.location.reload();
	}
}

function reset(){
	var frm=f_query_add_mod.document.forms[0];
	var hash = new Hashtable();
	hash = window.frames[3].hash;
	if(frm == null){
		try{
			var formobj = window.parent.frames[1].frames[1].frames[1].document.forms[0];
			var mainformobj = window.parent.frames[1].frames[1].frames[0].document.forms[0];
			if (formobj != null){	
				hash.clear();
				window.parent.frames[1].frames[1].frames[1].location.reload();
			}
			else if(mainformobj != null){
				window.parent.frames[1].frames[1].frames[0].location.reload();
			}
			else{
				commontoolbarFrame.location.reload();
			}
		}
		catch(failed){
		}
	}
	else{
		f_query_add_mod.location.reload();	
		
	}
}

function query(){
	var cmf=commontoolbarFrame.document.forms[0];
	if(cmf.apply.disabled==false){
		  cmf.apply.disabled=true;
		  cmf.reset.disabled=true;
    }
	f_query_add_mod.location.href='../../eOH/jsp/MTasksLinkQueryCriteria.jsp';
}

function setCheckValue(){
	if(document.forms[0].status.checked==true)
		document.forms[0].status.value="E";
	else
		document.forms[0].status.value="D";
}

function callDetailForm(){
	var frmObj=window.parent.frames[1];
	var frm=document.forms[0];
	var treatment_code=frm.treatment_code.value;
	//var search_criteria=frm.search_criteria.value;
	//var task_search_text=frm.task_search_text.value;
	var treatment_title = getLabel("eOH.Treatment.Label","OH");

	var fields = new Array (frm.treatment_code);
	var names = new Array (treatment_title);
	var messageFrame= parent.parent.document.frames.messageFrame;
    var hash = new Hashtable();
    hash = window.parent.parent.frames[3].hash;
    hash.clear();
   
	if(checkFieldsofMst( fields, names, messageFrame)){	
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "treatment_code="+treatment_code;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","MCommonValidation.jsp?func_mode=populateMultipleTrmtYN&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		retVal = localTrimString(retVal);
		//frmObj.location.href="../../eOH/jsp/MTasksLinkDetailForm.jsp?treatment_code="+treatment_code+"&multiple_yn="+retVal+"&search_criteria="+search_criteria+"&task_search_text="+task_search_text;
		frmObj.location.href="../../eOH/jsp/MTasksLinkDetailForm.jsp?treatment_code="+treatment_code+"&multiple_yn="+retVal;
		parent.parent.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp";
	} 
	
}

function clearvalues(){
	window.parent.frames[1].location.href="../../eCommon/html/blank.html";
	window.parent.frames[0].document.location.reload();
	parent.parent.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp";
}

function clearDtl_Frame(){
	window.parent.frames[1].location.href="../../eCommon/html/blank.html";
}

function localTrimString(sInString) {
  sInString = sInString.replace( /^\s+/g, "" );// strip leading
  return sInString.replace( /\s+$/g, "" );// strip trailing
}

function getTreatmentLookUp(obj,target){
	
	var locale = document.forms[0].locale.value;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var sql="";
	var frmObj=document.forms[0];
	var treatment_desc = frmObj.treatment_desc.value;
	if (tit_flag="Treatment Search"){
		sql="SELECT TRMT_DESC DESCRIPTION, TRMT_CODE CODE FROM OH_TREATMENT_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND EFF_STATUS = 'E' AND UPPER(TRMT_DESC) LIKE UPPER(?) AND UPPER(TRMT_CODE) LIKE UPPER(?) ORDER BY 1";
	}
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = treatment_desc;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	
	retVal = await CommonLookup( tit_flag, argumentArray );
	if(retVal != null && retVal != "" ){
		var ret1=unescape(retVal);
		//arr=retVal;
		arr=ret1.split(",");
		obj.value = arr[0];
		target.value=arr[1];
	}else{
		target.value="";
		obj.value="";	
	}
}

function validateCheckBox(obj,multiple_yn){
	var formObj = document.forms[0];
	formObj.modified_flag.value="false";
	var frmObj = window.parent.parent.frames[3];
	var record= new Array();
	var task_code=obj.task_code;
	var task_desc=obj.task_desc;
	var seq_no=obj.seq_no;
	
	var frm=window.parent.frames[0].document.forms[0];
	var multiple_yn = formObj.multiple_yn.value;
    var treatment_code=frm.treatment_code.value;
	//var db_value = obj.value_yn;
	//var db_value=eval("formObj.seq_no"+indx).value_yn;
	
	var arrObj=formObj.elements;
	var flag="flag1";
	var count=0;
   
	var hash = new Hashtable();
	hash = frmObj.hash;
	//var key=hash.keys();
	var indx = obj.name.replace("chk_select" , "");
	var obj3=eval("formObj.seq_no"+indx);
	/* if(obj.checked!=false )
	{
	if(indx!=1)
	{
	if(obj3.value!="")
	{
		var ret=validateSeqNo(obj3,indx);
		if(ret==false){count=1;}
		flag="flag2";
	}
	}
	if(indx==1)
	{
		if(arrObj[0].value!="")
		{
			var ret=validateSeqNo(obj3,indx);
		    if((ret==true &&obj.checked==true) ||ret==false){count=1;}
			flag="flag2";
		}
		
	}
	}*/
	
	var name;
	if(indx==1){
		name=arrObj[0].name;
	}
	else{
		name=eval("formObj.seq_no"+indx).name;
	}
    
	if(obj.checked==false){
		//if(hash.size()>0){alert("hash.get(key[indx])[3]"+hash.get(key[indx])[3])}
		eval("formObj.seq_no"+indx).value="";
		obj.seq_no='';
		if(indx==1){
			arrObj[0].value="";
		}
	}
	if(indx!=1){
		var val_yn=eval("formObj.seq_no"+indx).value_yn;
	}
	else if(indx==1){
		var val_yn=arrObj[0].value_yn;
	}
		
	if(obj.checked==true){
		if((seq_no==null)||(seq_no=='')){   
			var sqno_title = getLabel("eOR.SeqNo.label","OR");
			var msg = getMessage("CAN_NOT_BE_BLANK","COMMON");
			var msgArray = msg.split("$");
			obj.select_yn="N";
			alert(msgArray[0]+ sqno_title + msgArray[1]);
			obj.checked=false;
		}
		else{ 
			obj.checked=true;
			obj.select_yn="Y";
			record[0]=task_code;
			record[1]=task_desc;
			record[2]=seq_no;
			record[3]="Y";
			//using in validateSeqNo for checking record already exists.
		}
		/* 
		else  if(val_yn!=""){
			obj.checked=true;
			obj.select_yn="Y";
			record[0]=task_code;
			record[1]=task_desc;
			record[2]=seq_no;
			record[3]="Y";
			record[4]=indx;// only for database(already recorded) values to update
		}
		*/
		
	}
	else{
		obj.select_yn="N";
		record[0]=task_code;
		record[1]=task_desc;
		record[2]=seq_no;	
		record[3]="N";
		
		//if(hash.get(indx)!=null){
		//	hash.remove(indx);
		//}
	}
	
	var arrObj = document.forms[0].elements;
	for(var i=0;i<arrObj.length;i++){
		if(arrObj[i].type=="checkbox"){
			if(arrObj[i].value==arrObj[i].select_yn){
				arrObj[i].db_change="N";
				continue;
			}else{
				formObj.modified_flag.value="true";
				arrObj[i].db_change="Y";
				
			}
		}
	}
	if(hash.get(indx)!=null){
		hash.remove(indx);
        
	}else if(record!="") {
		hash.put(indx,record);	
	}
 }

// Copied from jsp by rajesh on 13/09/07
 function previous(){
	var frm=window.parent.frames[0].document.forms[0];
	var formObj = document.forms[0];
	var modified_flag=formObj.modified_flag.value;
	var multiple_yn = formObj.multiple_yn.value;

	/*if(modified_flag=="true"){
		return;
	}*/
	var treatment_code=frm.treatment_code.value;
	//var search_criteria=frm.search_criteria.value;
	//var task_search_text=frm.task_search_text.value;

	var start = formObj.start.value;
	formObj.start.value=start-14;
	var end = formObj.end.value;
	formObj.end.value=end-14;
	start = formObj.start.value;
	end = formObj.end.value;
	var hash = new Hashtable();
	hash = window.parent.parent.frames[3].hash;
	var keys = hash.keys();
	//document.location.href="../../eOH/jsp/MTasksLinkDetailForm.jsp?from="+start+"&to="+end+"&totalSelected="+keys+"&treatment_code="+treatment_code+"&called_from=P&multiple_yn="+multiple_yn+"&search_criteria="+search_criteria+"&task_search_text="+task_search_text;
	document.location.href="../../eOH/jsp/MTasksLinkDetailForm.jsp?from="+start+"&to="+end+"&totalSelected="+keys+"&treatment_code="+treatment_code+"&called_from=P&multiple_yn="+multiple_yn;
	parent.parent.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp";
}


function next(){
	var frm=window.parent.frames[0].document.forms[0];    //.frames[0].document.forms[0];
	var formObj = document.forms[0];
	var multiple_yn = formObj.multiple_yn.value;
	var modified_flag=formObj.modified_flag.value;
	//var db_change=formObj.db_change.value;
	/*if(modified_flag=="true"){
		alert(getMessage("APP-OH00017","OH"));
		return;
	}*/
	var treatment_code=frm.treatment_code.value;
	///var search_criteria=frm.search_criteria.value;
	//var task_search_text=frm.task_search_text.value;

	var start = formObj.start.value;
	formObj.start.value=parseInt(start)+14;
	start = formObj.start.value;
	var end = formObj.end.value;
	formObj.end.value=parseInt(end)+14;
	end = formObj.end.value;
	var hash = new Hashtable();
	hash = window.parent.parent.frames[3].hash;
	var keys = hash.keys();
	var masterFrame=window.parent.frames[0];
	var detailFrame=window.parent.frames[1];
	//document.location.href="../../eOH/jsp/MTasksLinkDetailForm.jsp?from="+start+"&to="+end+"&totalSelected="+keys+"&treatment_code="+treatment_code+"&called_from=N&multiple_yn="+multiple_yn+"&search_criteria="+search_criteria+"&task_search_text="+task_search_text;
	document.location.href="../../eOH/jsp/MTasksLinkDetailForm.jsp?from="+start+"&to="+end+"&totalSelected="+keys+"&treatment_code="+treatment_code+"&called_from=N&multiple_yn="+multiple_yn;
	parent.parent.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp";
}


function chkCurrentObject(obj,obj2){
	var formObj=document.forms[0];
	var db_value = obj.value_yn;
	var frm=window.parent.frames[0].document.forms[0];    
	var treatment_code=frm.treatment_code.value;
	var record= new Array();
	var task_code=obj.task_code;
	var task_desc=obj.task_desc;
	var seq_no=obj.value;
	var hash = new Hashtable();
    hash = window.parent.parent.frames[3].hash;
    var keys = hash.keys();
	var indx= obj2.name.replace("chk_select","");
	var flag="flag1";
	if( obj.value_yn!=""){ 
     /* for(var i=0;i<hash.size();i++)
		{ 
		  if(hash.get(keys[i])[5]=="undefined"){hash.get(keys[i])[5]=""}
		 
		  if(obj2.checked==true && hash.get(keys[i])[5]!=obj.name &&  obj.value==hash.get(keys[i])[2])
			{
		    alert(getMessage("CODE_ALREADY_EXISTS","COMMON"));
		    obj.value = '';
		    obj.select();
			flag="flag2";
			}
		}*/
		if(obj2.checked==true && flag!="flag2"){
			record[0]=task_code;
			record[1]=task_desc;
			record[2]=seq_no;
			record[3]="Y";
			record[4]=indx;
			if(hash.get(indx)!=null ){
				hash.remove(indx);
			}else{
				hash.put(indx,record);	
			}
		}
	}
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "func_mode=VALIDATESEQ_NO1&treatment_code="+treatment_code+"&seq_no="+seq_no;
	var xmlStr1 ="<root><SEARCH ";
	xmlStr1 +=" /></root>";
	xmlDoc.loadXML(xmlStr1);
	xmlHttp.open("POST","MCommonValidation.jsp?"+params,false);
	xmlHttp.send(xmlDoc);
	var val = trimString(xmlHttp.responseText);
	val = localTrimString(val);
	return val;	
}

  function validateSeqNo(obj,rownum){
	if (obj.value =='' || obj.value == null){
		return;
	}
	var formObj=document.forms[0];
	var key = obj.name.replace("seq_no","");
	var record= new Array();
	var task_code=obj.task_code;
	var task_desc=obj.task_desc;
	var seq_no=obj.value;
	var hash = new Hashtable();
    hash = window.parent.parent.frames[3].hash;
    var keys = hash.keys();
	var obj2=eval("formObj.chk_select"+rownum);
	var key1 = obj2.name.replace("chk_select","");
	
	ChkNumber(obj);
	/*var db_dup_val="";
	var db_value = obj.value_yn;
	if(db_value != obj.value){ 
		db_dup_val=chkCurrentObject(obj,obj2);
	}
	var value_yn = obj.value;
	var seq_no_yn="";
	var arrObj = document.forms[0].elements;
	var frm=window.parent.frames[0].document.forms[0];    
	var treatment_code=frm.treatment_code.value;*/
	//hash.remove(key1);
	for(var i=0;i<hash.size();i++){ 
		// if(obj2.checked==true && hash.get(keys[i])[0]==task_code)
		if(obj2.checked==true){
			record= new Array();
			record[0]=task_code;
			record[1]=task_desc;
			record[2]=seq_no;
			record[3]="Y";
			
			hash.put(key1,record);	
		}
	}
	
	/*seq_no_yn="Y"; // Initialize
	if(db_dup_val=="" || db_dup_val==null){
		seq_no_yn="Y";		
	}else{
		seq_no_yn="N";
	}
   
   if(seq_no_yn=="Y"){ // If DB duplicate check is fine
		/*for(var i=0;i<arrObj.length;i++){
			if(arrObj[i].type=="text" ){
				if(obj.name != arrObj[i].name && obj.value==arrObj[i].value){
					seq_no_yn="N";
				}				
			}
		}----->commentclose
		
		if(hash.size()!=null||hash.size()!='')
	   {
		for(var i=0;i<hash.size();i++)
		{ 
		 
		   if( obj.value_yn==""){
		    if(obj2.checked==true && hash.get(keys[i])[0]==task_code)
			{
			hash.get(keys[i])[2]=obj.value;
			}
			
			if(obj2.checked==true && hash.get(keys[i])[5]!=obj.name &&obj.value==hash.get(keys[i])[2])
				{ 
					seq_no_yn="N";
					
				}
		   }
		  
			if( obj2.checked==false && keys!=key && obj.value==hash.get(keys[i])[2])
			{
			
			seq_no_yn="N";
			}
			 /*if( obj.value_yn==""){
			 if(obj2.checked==true && hash.get(keys[i])[0]!=task_code && key1!=key)
			 {
				seq_no_yn="N";
			  }
			 }--->commentclose
          
		}
	   }
	}
	if(seq_no_yn=="N"){
		
		alert(getMessage("CODE_ALREADY_EXISTS","COMMON"));
		
		obj.value = '';
		obj.select();
		if( obj.value_yn==""||obj.value_yn==''){
		obj2.value="N";
		obj2.checked=false;
		hash.remove(key);
		return false;
		
		}
		else
		{  
			if(obj2.checked==true)
		   {
			record[0]=task_code;
			record[1]=task_desc;
			record[2]=seq_no;
			record[3]="Y";
			record[4]=key;
			if(hash.get(key)!=null){
			hash.remove(key);
			
			}else{
			hash.put(key,record);	
			}

		   }
		return true;
		}
	}else{
		var ob=eval("formObj.chk_select"+key);
		ob.seq_no=obj.value;
	}
	*/
	var ob=eval("formObj.chk_select"+key);
	ob.seq_no=obj.value;		
	return true;
  }

//Used for checking the numerical values....
function ChkNumber(obj){
	var quantity=obj.value;
	var sqno_title = getLabel("eOR.SeqNo.label","OR");
	if(isNaN(quantity)==true)	{
		alert(getMessage("NUM_ALLOWED","CA"));
	   obj.select();
	}
	if(obj.value!="" && quantity==0){
	  var msg = getMessage("APP-OH0003","OH");
	  var msgArray = msg.split("#");
	  alert(msgArray[0]+sqno_title+msgArray[1]+" Zero"); //used for showing seq no must be > 0
	  obj.select();
	}
}

function seq_no_update(obj){
	var formObj = document.forms[0];
	var value_yn = obj.value;
	var arrObj = document.forms[0].elements;
	for(var i=0;i<arrObj.length;i++){
		if(arrObj[i].type=="text"){
			if(arrObj[i].value==arrObj[i].value_yn){
				arrObj[i].db_change_seq_no="N";
				continue;
			}else{
				formObj.modified_flag.value="true";
				arrObj[i].db_change_seq_no="Y";
			}
		}
	}
}

function allowNumOnly(event){
	var strCheck = '0123456789';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1)
		return false;  
	else
		return true ;			
}
 
function assingListItemValue(key,rownum){
	var formObj = document.forms[0];
	var hash = new Hashtable();
	hash = window.parent.parent.frames[3].hash;
	if(hash.get(key)!=null){
		if(hash.get(key)[3]=="Y"){   
			eval("formObj.chk_select"+key).checked=true;
			eval("formObj.seq_no"+key).value=hash.get(key)[2];
		}
		else{
			eval("formObj.chk_select"+key).checked=false;
		  // eval("formObj.seq_no"+key).value=hash.get(key)[2];
		}
	}
}

function clearListItemValue(key){
	var formObj = document.forms[0];
	eval("formObj.chk_select"+key).checked=false;
	eval("formObj.seq_no"+key).value="";
}

function chkFields(){  
	var formObj=window.parent.frames[1].frames[1].frames[1].document.forms[0];
	//	var db_value = obj.value_yn;
	var frm=window.parent.frames[1].frames[1].frames[0].document.forms[0];    
	var treatment_code=frm.treatment_code.value;
	//var val= new Array();
//	var task_code=obj.task_code;
//	var task_desc=obj.task_desc;
    var hash = new Hashtable();
	hash = window.frames[3].hash;
	var keys = hash.keys();
	var seq_no;
	var maxRecord=formObj.maxRecord.value
	var flag=0;
  
	for(var i=0;i<hash.size();i++){
		seq_no=hash.get(keys[i])[2];
		/*var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "func_mode=VALIDATESEQ_NO1&treatment_code="+treatment_code+"&seq_no="+seq_no;
		var xmlStr1 ="<root><SEARCH ";
		xmlStr1 +=" /></root>";
		xmlDoc.loadXML(xmlStr1);
		xmlHttp.open("POST","MCommonValidation.jsp?"+params,false);
		xmlHttp.send(xmlDoc);
		var val = trimString(xmlHttp.responseText);
		val = localTrimString(val);
	
		
		if(val==hash.get(keys[i])[2] && hash.get(keys[i])[3]=="Y" )
			{
			flag=1;
			}*/
		for(j=0;j<hash.size();j++)		{
			if(hash.get(keys[j])[2]==hash.get(keys[i])[2] && hash.get(keys[j])[0]!=hash.get(keys[i])[0])			{
				flag=1;
			}
		}
	}
	if(flag==0)	{
		return true;
	}
	else{   
		alert(getMessage("RECORD_ALREADY_EXISTS","common"));
		return false;
	}
}



/*function chk()
{
var formObj=window.parent.frames[1].frames[1].frames[1].document.forms[0];
	//	var db_value = obj.value_yn;
var frm=window.parent.frames[1].frames[1].frames[0].document.forms[0];    
var treatment_code=frm.treatment_code.value;	
var record= new Array();
var hash1 = new Hashtable();
hash1= window.frames[3].hash;
var keys = hash1.keys();
var maxRecord=formObj.maxRecord.value; 
    for(var i=1;i<maxRecord;i++)
	{
		if(eval("formObj.chk_select"+i).value=="Y")
		{
			alert(eval("formObj.chk_select"+i).value);	
		}
	
	}
	
}*/


function getAllTasksLink(){
	var formObj = document.forms[0];
	var frmObj = window.parent.parent.frames[3];
	var record= new Array();
	var treatment_code = formObj.treatment_code.value;
	var indx = 0;
	var hash = new Hashtable();
	hash = frmObj.hash;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "func_mode=getAllTasksLink&treatment_code="+treatment_code;
    var xmlStr1 ="<root><SEARCH ";
	xmlStr1 +=" /></root>";
	xmlDoc.loadXML(xmlStr1);
	xmlHttp.open("POST","MCommonValidation.jsp?"+params,false);
	xmlHttp.send(xmlDoc);
	var linked_tasks = trimString(xmlHttp.responseText);
	linked_tasks = localTrimString(linked_tasks);
	if(linked_tasks.length > 1){
		var linked_tasks_arr = linked_tasks.split("~");
		for(k=0;k<linked_tasks_arr.length-1;k++){
			var tasks_code_desc = linked_tasks_arr[k].split("##");
			record= new Array();
			record[0]=tasks_code_desc[0];
			record[1]=tasks_code_desc[1];
			record[2]=tasks_code_desc[2];
			record[3]="Y";

			indx = k+1;

			if(record!="") {
				hash.put(k+1,record);	
			}
			
		}
	}
}
