

var detailUpperDoc		=null;
var detailLowerDoc		=null;
var detailUpperForm		=null;
var detailLowerForm		=null;
var detailPageMode		 = "N";	//Select,Associated,None{S,A,N}
var selFlag			     = false ;
function create(){
	var cmf=commontoolbarFrame.document.forms[0];
	if(cmf.apply.disabled==true){
      cmf.apply.disabled=false;
      cmf.reset.disabled=false;
    }
	f_query_add_mod.location.href='../../eOH/jsp/MTasksFrameInCreateMode.jsp?mode=insert';
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
	clearBean();
	//var hash = new Hashtable();
	//hash = window.frames[3].hash;
	if(frm == null){
		try{
			//var mainformobj = window.parent.frames[1].frames[1].frames[0].document.forms[0]; //master_frame
			var mainformobj = window.parent.content.f_query_add_mod.master_frame.document.forms[0]; //master_frame
			
			//var formobj = window.parent.frames[1].frames[1].frames[1].detail.document.forms[0];
			/*
			if ( window.parent.frames[1].frames[1].frames[1].document.location.href.indexOf("MTasksLinkFrames.jsp") != -1 ){	
				window.parent.frames[1].frames[1].frames[1].location.reload(); //detail_frame
				//window.parent.frames[1].frames[1].frames[1].frames[1].location.reload();
			}
			*/
			if (window.parent.content.f_query_add_mod.detail_frame.document.location.href.indexOf("MTasksLinkFrames.jsp") != -1 ){	
				window.parent.content.f_query_add_mod.detail_frame.location.reload(); //detail_frame
				//window.parent.frames[1].frames[1].frames[1].frames[1].location.reload();
			}
			else if(mainformobj != null){
				//window.parent.frames[1].frames[1].frames[0].location.reload();
				window.parent.content.f_query_add_mod.master_frame.location.href='../../eOH/jsp/MTasksLinkMain.jsp?mode=insert'; //master_frame
			}
			else{
				commontoolbarFrame.location.reload();
			}
		}
		catch(failed){
			//alert("failed---->"+failed);
		}
	}
	else{
		//f_query_add_mod.location.reload();	
		/* Added by Sridevi Joshi on 6/9/2010 for IN021926*/
		if(f_query_add_mod.document.location.href.indexOf("MTasksLinkQueryResult.jsp") != -1){
			  return false;
		}
		else{
			 f_query_add_mod.document.location.reload();
		}
		
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
	var frmObj=window.parent.detail_frame;
	var frm=document.forms[0];
	var treatment_code=frm.treatment_code.value;
	var treatment_title = getLabel("Common.Treatment.label","Common");
    var fields = new Array (frm.treatment_code);
	var names = new Array (treatment_title);
	var messageFrame= parent.parent.document.frames.messageFrame;
	clearBean();
    // var hash = new Hashtable();
    // hash = window.parent.parent.frames[3].hash;
    // hash.clear();
	if(checkFieldsofMst( fields, names, messageFrame)){	
		frmObj.location.href="../../eOH/jsp/MTasksLinkFrames.jsp?treatment_code="+treatment_code;
		//parent.parent.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp";
	} 

	parent.parent.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp";
	
}

function clearvalues(){
	window.parent.detail_frame.location.href="../../eCommon/html/blank.html";
	window.parent.master_frame.document.location.reload();
	parent.parent.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp";
}

function clearDtl_Frame(){
	window.parent.detail_frame.location.href="../../eCommon/html/blank.html";
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
		/*var ret1=unescape(retVal);
		//arr=retVal;
		arr=ret1.split(",");
		obj.value = arr[0];
		target.value=arr[1];*/

		obj.value = retVal[0];//Added by Sridevi Joshi on 5/24/2010 during IN021549 changes
		target.value=retVal[1];//Added by Sridevi Joshi on 5/24/2010 during IN021549 changes
	}else{
		target.value="";
		obj.value="";	
	}
}

/*function validateCheckBox(obj,multiple_yn){
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
	}--/
	
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
		--/
		
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
 }*/

 function validateCheckBox(obj){
	var formObj = document.forms[0];
	var frmObj = window.parent.parent.parent.frames[3];
	var record= new Array();
	var task_code=obj.task_code;
	var task_desc=obj.task_desc;
	var seq_no=obj.seq_no;
	var selAlphabet=obj.selAlphabet;
	
	var hash = new Hashtable();
	hash = frmObj.hash;
	var hash1 = new Hashtable();
	hash1 = frmObj.hash;
	
	var indx = obj.name.replace("chk_select" , "");
	//var obj3=eval("formObj.seq_no"+indx);
	
	/*
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
	*/

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
			record[4]=selAlphabet;
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
		record[4]=selAlphabet;
	}

	if(hash.get(indx)!=null){
		hash.remove(indx);
        
	}else if(record!=""){
		hash.put(indx,record);	
	}	
 }

// Copied from jsp by rajesh on 13/09/07
 /*function previous(){
	var frm=window.parent.frames[0].document.forms[0];
	var formObj = document.forms[0];
	var modified_flag=formObj.modified_flag.value;
	var multiple_yn = formObj.multiple_yn.value;

	/*if(modified_flag=="true"){
		return;
	}--//
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
}*/



/*function next(){
	var frm=window.parent.frames[0].document.forms[0];    //.frames[0].document.forms[0];
	var formObj = document.forms[0];
	var multiple_yn = formObj.multiple_yn.value;
	var modified_flag=formObj.modified_flag.value;
	//var db_change=formObj.db_change.value;
	/*if(modified_flag=="true"){
		alert(getMessage("APP-OH00017","OH"));
		return;
	}---//
	var treatment_code=frm.treatment_code.value;
	///var search_criteria=frm.search_criteria.value;
	//var task_search_text=frm.task_search_text.value;

	var start = formObj.start.value;
	formObj.start.value=parseInt(start)+7;
	start = formObj.start.value;
	var end = formObj.end.value;
	formObj.end.value=parseInt(end)+7;
	end = formObj.end.value;
	var hash = new Hashtable();
	hash = window.parent.parent.frames[3].hash;
	var keys = hash.keys();
	var masterFrame=window.parent.frames[0];
	var detailFrame=window.parent.frames[1];
	//document.location.href="../../eOH/jsp/MTasksLinkDetailForm.jsp?from="+start+"&to="+end+"&totalSelected="+keys+"&treatment_code="+treatment_code+"&called_from=N&multiple_yn="+multiple_yn+"&search_criteria="+search_criteria+"&task_search_text="+task_search_text;
	document.location.href="../../eOH/jsp/MTasksLinkDetailForm.jsp?from="+start+"&to="+end+"&totalSelected="+keys+"&treatment_code="+treatment_code+"&called_from=N&multiple_yn="+multiple_yn;
	parent.parent.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp";
}*/

function previous(){
	//var frm=window.parent.frames[0].document.forms[0];
	var frm=window.parent.tab.document.forms[0];
	var formObj = document.forms[0];
	var modified_flag=formObj.modified_flag.value;
	var multiple_yn = formObj.multiple_yn.value;

	/*if(modified_flag=="true"){
		return;
	}*/
	var treatment_code=document.forms[0].treatment_code.value;
	var selAlphabet=document.forms[0].selAlphabet.value;
	
	//var search_criteria=frm.search_criteria.value;
	//var task_search_text=frm.task_search_text.value;

	var start = formObj.start.value;
	formObj.start.value=start-7;
	var end = formObj.end.value;
	formObj.end.value=end-7;
	start = formObj.start.value;
	end = formObj.end.value;
	var hash = new Hashtable();
	hash = window.parent.parent.parent.frames[3].hash;
	var keys = hash.keys();
	//document.location.href="../../eOH/jsp/MTasksLinkDetailForm.jsp?from="+start+"&to="+end+"&totalSelected="+keys+"&treatment_code="+treatment_code+"&called_from=P&multiple_yn="+multiple_yn+"&search_criteria="+search_criteria+"&task_search_text="+task_search_text;
	document.location.href="../../eOH/jsp/MTLinkComponentDetailForm.jsp?from="+start+"&to="+end+"&totalSelected="+keys+"&called_from=N&multiple_yn="+multiple_yn+"&treatment_code="+treatment_code+"&selAlphabet="+selAlphabet+"&totalSelected="+keys;
	parent.parent.parent.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp";
}
function next(){
	//var frm=window.parent.frames[0].document.forms[0];    //.frames[0].document.forms[0];
	var frm=window.parent.tab.document.forms[0];    //.frames[0].document.forms[0];
	var formObj = document.forms[0];
	var multiple_yn = formObj.multiple_yn.value;
	var modified_flag=formObj.modified_flag.value;
	var treatment_code=document.forms[0].treatment_code.value;
	var selAlphabet=document.forms[0].selAlphabet.value;
	
	var start = formObj.start.value;
	formObj.start.value=parseInt(start)+7;
	start = formObj.start.value;
	var end = formObj.end.value;
	formObj.end.value=parseInt(end)+7;
	end = formObj.end.value;
	var hash = new Hashtable();
	hash = window.parent.parent.parent.frames[3].hash;
	var keys = hash.keys();
	var masterFrame=window.parent.master_frame;
	var detailFrame=window.parent.detail_frame;
	//document.location.href="../../eOH/jsp/MTasksLinkDetailForm.jsp?from="+start+"&to="+end+"&totalSelected="+keys+"&treatment_code="+treatment_code+"&called_from=N&multiple_yn="+multiple_yn+"&search_criteria="+search_criteria+"&task_search_text="+task_search_text;
	document.location.href="../../eOH/jsp/MTLinkComponentDetailForm.jsp?from="+start+"&to="+end+"&totalSelected="+keys+"&called_from=N&multiple_yn="+multiple_yn+"&treatment_code="+treatment_code+"&selAlphabet="+selAlphabet+"&totalSelected="+keys;
	parent.parent.parent.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp";
}
function next_associate(){
    var formObj = document.forms[0];
    var start = formObj.start.value;
	var treatment_code=document.forms[0].treatment_code.value;
	formObj.start.value=parseInt(start)+7;
	start = formObj.start.value;
	var end = formObj.end.value;
	formObj.end.value=parseInt(end)+7;
	end = formObj.end.value;

	document.location.href="../../eOH/jsp/MTLinkAssociateTab.jsp?from="+start+"&to="+end+"&treatment_code="+treatment_code;
	parent.parent.parent.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp";
}
function previous_associate(){
	
	var formObj = document.forms[0];
    var start = formObj.start.value;
	var treatment_code=document.forms[0].treatment_code.value;
	formObj.start.value=start-7;
	var end = formObj.end.value;
	formObj.end.value=end-7;
	start = formObj.start.value;
	end = formObj.end.value;
	
	document.location.href="../../eOH/jsp/MTLinkAssociateTab.jsp?from="+start+"&to="+end+"&treatment_code="+treatment_code;
	parent.parent.parent.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp";
}

//This Function not used anywhere
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
	var formObj=document.forms[0];
	var obj2=eval("formObj.chk_select"+rownum);
	var key = obj.name.replace("seq_no","");
	var record= new Array();
	var task_code=obj.task_code;
	var task_desc=obj.task_desc;
	var seq_no=obj.value;
	var selAlphabet=obj.selAlphabet;
	var hash = new Hashtable();
    hash = window.parent.parent.parent.frames[3].hash;
    var keys = hash.keys();
	//var obj2=eval("formObj.chk_select"+rownum);
	var key1 = obj2.name.replace("chk_select","");
	
	if ((obj.value =='' || obj.value == null)&&obj2.checked==false){
		return;
	}
	else if((obj.value =='' || obj.value == null)&&obj2.checked==true)
   { 
	
	var	select_value="N";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += " task_code=\""+ task_code + "\" ";	
	xmlStr += " task_desc=\""+ encodeURIComponent(task_desc)+ "\" ";	
	xmlStr += " seq_no=\""+ seq_no+ "\" ";
	xmlStr += " selAlphabet=\""+ selAlphabet+ "\" ";	
	xmlStr += " select_value=\""+ select_value+ "\" ";	
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","MTTasksLinkValidation.jsp?func_mode=removeCheckedRow"+" ",false);
	xmlHttp.send(xmlDoc);
	retval=xmlHttp.responseText; 
	obj.focus();
   }
		
	ChkNumber(obj);
	/*for(var i=0;i<hash.size();i++){ 
		if(obj2.checked==true){
			record= new Array();
			record[0]=task_code;
			record[1]=task_desc;
			record[2]=seq_no;
			record[3]="Y";
			hash.put(key1,record);	
		}
	}*/
	var ob=eval("formObj.chk_select"+key);
	ob.seq_no=obj.value;	
	setCheckedRow(obj2);
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
 
function assingListItemValue(key){
	var formObj = document.forms[0];
	var selAlphabet=formObj.selAlphabet.value;
	var hash = new Hashtable();
	hash = window.parent.parent.parent.frames[3].hash;
	if(hash.get(key)!=null){
		
		if(hash.get(key)[3]=="Y"){  
		  if(selAlphabet==hash.get(key)[4]){
			eval("formObj.chk_select"+key).checked=true;
			eval("formObj.seq_no"+key).value=hash.get(key)[2];
			}
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

//This function not used anywhere
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
	var maxRecord=formObj.maxRecord.value;
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
/* new functions added*/
function selectInsert(){
	var messageFrame= parent.parent.parent.document.frames.messageFrame;
	
	//getHandleHeader();
	getHandleDetailUpper();
    getHandleDetailLower();

	ShowHtml();
   
	detailUpperDoc.all.SelectTab.className    ="clicked";
	detailUpperDoc.all.AssociateTab.className ="normal";
	detailUpperDoc.forms[0].search_text.value = "";
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
   /* if(detailPageMode != 'N'){
         
		if(detailLowerForm == null || detailLowerForm == undefined)
		  return ;

	 detailLowerForm.action.value="select";
	 eval(doSync(detailLowerForm)); //Syn the lower Frame

	}*/

	detailPageMode = 'N' ;	//Current Page mode after Blank page is loaded

}

function associated(){
	var treatment_code=document.forms[0].treatment_code.value;
   
	selFlag			 = true ;
    
	//getHandleHeader();
	getHandleDetailUpper();
	getHandleDetailLower();
    var treatment_code=document.forms[0].treatment_code.value;
	
	changeCellStyle("hide");
    
	detailUpperDoc.all.SelectTab.className	  ="normal";
	detailUpperDoc.all.AssociateTab.className ="clicked";
    
    
	/*if(detailPageMode != 'N'){ 	//Current Page mode
       
		if(detailLowerForm == null || detailLowerForm == undefined)
		  return ;
         
		detailLowerForm.nextPrevFlag.value ='next';
		detailLowerForm.action.value	   ="associated";
		eval(doSync(detailLowerForm)); //Syn the lower Frame
	}*/
	detailLowerDoc.location.href="../../eOH/jsp/MTLinkAssociateTab.jsp?&action=associated"  +"&nextPrevFlag=next" + "&detailPageMode="+detailPageMode+ "&treatment_code="+treatment_code;
	//detailLowerDoc.location.href="../../eCommon/html/blank.html?&action=associated"  +"&nextPrevFlag=next" + "&detailPageMode="+detailPageMode ;
	detailPageMode = 'A' ;	 	//Current Page mode after upper page is loaded
}


/*********************Header Handle*****************************/
function getHandleHeader(){
	if(f_query_add_mod.header == null){
		//alert();
		 return false;
	}
	headerDoc	     =f_query_add_mod.header.document ;
	formObjHeader   =headerDoc.header ;
 }
/*********************tab Handle*****************************/
function getHandleTab(){
if(f_query_add_mod.tab == null)
	 return false;
 tabDoc	        =f_query_add_mod.tab.document ;
 formObjTab		 =tabDoc.tab ;
 }
/*********************detail Handle*****************************/
function getHandleDetail(){
if(f_query_add_mod.detail == null)
	 return false;
else
	return true;
}
/*********************detail upper Handle*****************************/
function getHandleDetailUpper(){


/*if(!getHandleDetail())
 return false;*/


if(parent.tab == undefined)
	return false;


 detailUpperDoc			 =parent.tab.document ;

if(detailUpperDoc.forms[0] == null)
	return false;


if(detailUpperDoc.forms[0].name == "detailUpperForm"){
	 detailUpperDoc	     =parent.tab.document ;
	 detailUpperForm	 =detailUpperDoc.detailUpperForm ;
	 return true;
 }else{
	 return false;
 }
}
/*********************detail Lower Handle*****************************/
function getHandleDetailLower(){
/*if(!getHandleDetail()){
	 return false;
}*/


if(parent.detail== undefined)
	return ;

 detailLowerDoc			 =parent.detail.document ;

 if(detailLowerDoc.forms.length == 0)
 return false;


 if(detailLowerDoc.forms[0].name == "detailLowerForm"){
 detailLowerForm		= detailLowerDoc.detailLowerForm ;
 return true;
 }else{
 return false;
 }

}

function changeCellStyle(pattern){
getHandleDetailUpper();
if(pattern == "hide" ){
	detailUpperDoc.all.alphabet.style.display	 = "none" ;
	detailUpperDoc.all.searchTxt.style.display	 = "none" ;
}else if(pattern == "show" ){
	detailUpperDoc.all.alphabet.style.display	 = "inline" ;
	detailUpperDoc.all.alphabet.style.visibility = "visible" ;
}
}

/*function doSync(frmObj){
// alert("jsdosync");
 var xmlDoc="";
 var xmlHttp = new XMLHttpRequest();
 var  xmlString = buildXml(frmObj);
 xmlDoc.loadXML(xmlString);
// alert(xmlString);
 xmlHttp.open("POST","../../eOR/jsp/OrderSetSync.jsp",false);
// alert("xmlDoc="+xmlDoc);
 xmlHttp.send(xmlDoc);
 //alert(xmlHttp.responseText)
 eval(xmlHttp.responseText ) ;
}*/

function buildXml(frmObj){


    var arrObj = frmObj.elements;

    var frmObjs = new Array()
    if(frmObj.name == null)
        frmObjs = frmObj ;
    else frmObjs[0] = frmObj ;
    var xmlStr ="<root><SEARCH ";

	for(var frmCount=0; frmCount<frmObjs.length; frmCount++) {
	frmObj = frmObjs[frmCount]
	var arrObj = frmObj.elements;

		for(var i=0;i<arrObj.length;i++) {
			var val = "" ;
			if(arrObj[i].type == "checkbox") {
				if(arrObj[i].checked)
					val = arrObj[i].value;
				if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
			}
			else if(arrObj[i].type == "radio") {
				if(arrObj[i].checked) {
					val = arrObj[i].value;
					if(arrObj[i].name != null && arrObj[i].name != "")
						xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
				}
			}
			else if(arrObj[i].type == "select-multiple" )
			{
				for(var j=0; j<arrObj[i].options.length; j++)
				{
					if(arrObj[i].options[j].selected)
						val+=arrObj[i].options[j].value +"~"
				}
				val= val.substring(0,val.lastIndexOf('~'))
				if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;

			}
			else {
				val = arrObj[i].value;
				if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
			}
		}
	}

    xmlStr +=" /></root>";

	return xmlStr;

}
function syncStatus(flag) {
	return flag ;
}

function Includes(index){
	if((eval(document.getElementById("chk_select"+index)).checked)== true)
	{
	var hyper_link_val="<a href=\"javascript:callAdditionalRows('"+index+"')\">+</a></font>"
	
	//eval(document.getElementById("Includes"+index)).innerHTML=hyper_link_val;
	}
	else
	{
		eval(document.getElementById("Includes"+index)).innerHTML="";
	}
	
}


function showIncluded(order_category)
{
	if(order_category=="PH")
	{
	for(i=0;i<7;i++)
	{
		if(eval(document.getElementById("include"+i)))
		{
		if((eval(document.getElementById("include"+i)).checked)== true)
		{
			var hyper_link_val="<a href=\"javascript:callAdditionalRows('"+i+"')\">+</a></font>"
	
			eval(document.getElementById("Includes"+i)).innerHTML=hyper_link_val;

		}
		else
	{
		eval(document.getElementById("Includes"+i)).innerHTML="";
	}
		}

	}
	}
}


async function callAdditionalRows(index){
	var oCell;
    var oRow;
    var rowId;
	var queryString ="";

	var trText = eval(document.getElementById("row"+index));
	var eff_status=document.getElementById("eff_status").value;
	var order_category=document.getElementById("order_category").value;
  
	queryString = queryString + "&first="+trText.cells[2].innerText;
	queryString +="&second="+trText.cells[1].innerText;
	queryString +="&third="+trText.cells[4].innerText;
	queryString +="&fourth="+eval(document.getElementById("order_set_seq_num"+index)).value;
	queryString +="&five="+eval(document.getElementById("qty_unit"+index)).value;
	queryString +="&six="+eval(document.getElementById("qty_uom_desc"+index)).value;
	queryString +="&seven="+eval(document.getElementById("freq_code"+index)).value ;
	queryString +="&eight="+eval(document.getElementById("durn_value"+index)).value	;
	queryString +="&nine="+eval(document.getElementById("durn_type_desc"+index)).value;
	queryString +="&ten="+eval(document.getElementById("rel_start_date_time"+index)).value;
	queryString +="&eleven="+eval(document.getElementById("reqd_or_opt_ind"+index)).value;
	queryString +="&twelve="+eval(document.getElementById("durn_type"+index)).value;
	queryString +="&thirteen="+eval(document.getElementById("qty_uom"+index)).value;


	queryString +="&eff_status="+eff_status;
	queryString +="&order_category="+order_category;


	var retVal = 	new String();
	var dialogHeight= "55vh" ;
	var dialogWidth	= "75vw" ;
	var status = "no";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no;  status:" + status;
	queryString+="&modal_yn=Y";
	retVal=await window.showModalDialog("../../eOR/jsp/OrdersetComponentDetailAddedFrame.jsp?"+queryString,arguments,features);
			
}
function ShowHtml(){

	getHandleDetailUpper();
	getHandleDetailLower();

	changeCellStyle("show");
	detailLowerDoc.location.href="../../eCommon/html/blank.html";
}3/18/2008

function TaskForSelIndx(indx){
    var messageFrame= parent.parent.parent.document.frames.messageFrame;

	selFlag			 = true ;
	//getHandleHeader();
	getHandleDetailUpper();
	getHandleDetailLower();
    //
	var treatment_code=document.forms[0].treatment_code.value;
	var hash = new Hashtable();
	hash = window.parent.parent.parent.frames[3].hash;
	var keys = hash.keys();
	//var selAlphabet=parent.frames[1].document.forms[0].selAlphabet.value;
	if(detailPageMode != "N"){

	if(detailLowerForm == null || detailLowerForm == undefined)
		  return ;

//	detailLowerForm.nextPrevFlag.value			='next';
	//detailLowerForm.OrderCatalogIndex.value		=indx;
//	detailLowerForm.order_category.value		=order_category;
	detailLowerForm.action.value				="IndexSelect";
		//eval(doSync(detailLowerForm)); //Syn the lower Frame
	}

	detailLowerDoc.location.href="../../eOH/jsp/MTLinkComponentDetailForm.jsp?selAlphabet="+indx + "&action=IndexSelect"+ "&nextPrevFlag=next"  + "&detailPageMode="+detailPageMode+ "&treatment_code="+treatment_code+"&totalSelected="+keys  ;
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" ;

	detailPageMode = "S" ;	//Detail page mode becomes selected

}

function checkDecimal1(obj){ //Don't remove this

  if(!OrCheckPositiveNumber1(obj)){
	  return ;
  }else{
  	    var objVal  = obj.value ;
		if(objVal.indexOf(".") != -1) {
		  	alert(getMessage('DECIMAL_NOT_ALLOWED','OR'));
			obj.focus();
			obj.value = "";
		}
  }
}

function getNext(flagSelect){
	//getHandleHeader();
	getHandleDetailUpper();
	getHandleDetailLower();

	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?";
	detailLowerForm.nextPrevFlag.value=flagSelect;//set the Flag to next or Prevoius
	detailLowerForm.action.value="nextPrevFlag";
	//doSync(detailLowerForm); //Syn the lower Frame
	detailLowerForm.submit();  
}

function chkInclude(index){
	getHandleDetailLower();
	var include				= eval("detailLowerDoc.all.chk_select"+index);
	var	seq_no   = eval("detailLowerDoc.all.seq_no"+index);
}
function setCheckedRow(obj){   
	var frmObj = window.parent.parent.parent.frames[3];
	var record= new Array();
	var task_code=obj.task_code;
	var task_desc=obj.task_desc;
	var seq_no=obj.seq_no;
	var selAlphabet=obj.selAlphabet;
	var select_value=obj.value;
    var sel=obj.sel;
	if(obj.checked==true){
		if((seq_no==null)||(seq_no=='')){   
				var sqno_title = getLabel("eOR.SeqNo.label","OR");
				var msg = getMessage("CAN_NOT_BE_BLANK","COMMON");
				var msgArray = msg.split("$");
				obj.select_yn="N";
				//obj.seq_no='';
				alert(msgArray[0]+ sqno_title + msgArray[1]);
				//var msgArray1=msgArray[0]+ sqno_title + msgArray[1]
				/*window.parent.parent.parent.frames[2].document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msgArray1;*/
				obj.checked=false;	
				
		}
		else{
			var select_value=obj.value;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var xmlStr ="<root><SEARCH ";
			xmlStr += " task_code=\""+ task_code + "\" ";	
			xmlStr += " task_desc=\""+ encodeURIComponent(task_desc)+ "\" ";	
		//	xmlStr += " task_desc=\""+ encodeURIComponent(task_desc)+ "\" ";	
			xmlStr += " seq_no=\""+ seq_no+ "\" ";
			xmlStr += " selAlphabet=\""+ selAlphabet+ "\" ";	
			xmlStr += " select_value=\""+ select_value+ "\" ";	
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","MTTasksLinkValidation.jsp?func_mode=setCheckedRow"+" ",false);
			xmlHttp.send(xmlDoc);
			retval=xmlHttp.responseText; 
		}
	}
}
function removeCheckedRow(obj){   
	var frmObj = window.parent.parent.parent.frames[3];
	var record= new Array();
	var task_code=obj.task_code;
	var task_desc=obj.task_desc;
	var seq_no=obj.seq_no;
	var selAlphabet=obj.selAlphabet;
	var select_value=obj.value;
	var sel=obj.sel;
	
	if(obj.checked==false){
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var xmlStr ="<root><SEARCH ";
		xmlStr += " task_code=\""+ task_code + "\" ";	
		xmlStr += " task_desc=\""+ encodeURIComponent(task_desc)+ "\" ";	
		xmlStr += " seq_no=\""+ seq_no+ "\" ";
		xmlStr += " selAlphabet=\""+ selAlphabet+ "\" ";	
		xmlStr += " select_value=\""+ select_value+ "\" ";	
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","MTTasksLinkValidation.jsp?func_mode=removeCheckedRow"+" ",false);
		xmlHttp.send(xmlDoc);
		retval=xmlHttp.responseText; 
	}
}

function clearBean(){
	
	var dummy="dummy";
	var xmlStr ="<root><SEARCH ";
	xmlStr+=" dummy=\""+ dummy + "\" ";
	xmlStr +=" /></root>";
	return fieldValidation(xmlStr,"clearBean");
}

function fieldValidation(xmlStr,source){
	var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");    
	xmlHttp.open("POST","MTTasksLinkValidation.jsp?func_mode="+source,false);
    xmlHttp.send(xmlDoc);
    responseText=xmlHttp.responseText ;
	eval(responseText);
    return true;
}

function apply(){
	var count = 0;
	var frm=f_query_add_mod.document.forms[0];
	
	//if(frm == null){
		try{
			//var formObj = window.parent.frames[1].frames[1].frames[1].frames[1].document.forms[0];
			
			var formObj = window.parent.content.f_query_add_mod.detail_frame.detail.document.forms[0];
			//var mode=formObj.mode.value;
			if(formObj==null){
				var mesg= getMessage("NO_CHANGE_TO_SAVE","Common");
				//window.parent.frames[1].frames[2].document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
				window.parent.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
				return;
			}
			//var mainformObj = window.parent.frames[1].frames[1].frames[0].document.forms[0];
			
			var mainformObj = window.parent.content.f_query_add_mod.master_frame.document.forms[0];
			if(mainformObj == null){
				commontoolbarFrame.location.reload();
			}
			else{

			    var mode="insert";
				var sel_val = "";
				var change_seq_no = "";
				var treatment_code = formObj.treatment_code.value;
				//var multiple_yn = formObj.multiple_yn.value;

				//To get Multiple_yn
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "treatment_code="+treatment_code;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","CommonValidation.jsp?func_mode=getMultipleTasksFlag&"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
				retVal = localTrimString(retVal);
	
				//var arrObj = formObj.elements;
				//var mode=formObj.mode.value;
				var treatment_title = getLabel("Common.Treatment.label","Common");
				var sqno_title = getLabel("eOR.SeqNo.label","OR");
				var msg = getMessage("CAN_NOT_BE_BLANK","COMMON");
				var msgArray = msg.split("$");
				var fields = new Array (mainformObj.treatment_code);
				var names = new Array (treatment_title);
				var flag_field=chkDup();
                if(checkFieldsofMst( fields, names, messageFrame)&& flag_field==true){
					var xmlStr=formXMLString(retVal);
					
					var ind = xmlStr.indexOf("\" />");
						/*if(ind != -1){
							sel_val = xmlStr.substring(ind-1,ind);
						}*/
						//else{
						 if(xmlStr!="<root></root>"){
							var action="../../servlet/eOH.MTasksLinkServlet?treatment_code="+treatment_code+"&mode="+mode;
							var xmlDoc = "";
							var xmlHttp = new XMLHttpRequest();
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST",action,false);
							xmlHttp.send(xmlDoc);
							var retVal = xmlHttp.responseText;
							var mesg = retVal;
							
							/*
							window.parent.frames[1].frames[1].frames[0].location.href='../../eOH/jsp/MTasksLinkMain.jsp?mode=insert';
						    window.parent.frames[1].frames[1].frames[1].frames[0].location.href='../../eCommon/html/blank.html?mode=insert';
						    window.parent.frames[1].frames[1].frames[1].frames[1].location.href='../../eCommon/html/blank.html?mode=insert';
							window.parent.frames[1].frames[2].document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
							*/
							window.parent.content.f_query_add_mod.master_frame.location.href='../../eOH/jsp/MTasksLinkMain.jsp?mode=insert';
						    window.parent.content.f_query_add_mod.detail_frame.tab.location.href='../../eCommon/html/blank.html?mode=insert';
						    window.parent.content.f_query_add_mod.detail_frame.detail.location.href='../../eCommon/html/blank.html?mode=insert';
							
							window.parent.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
							onSuccess();
						}else{
							var mesg= getMessage("APP-OH00066","OH");
							window.parent.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
				           	}
					//}else
				} //End of Mandatory check
				else{
					var frm=f_query_add_mod.document.forms[0];
					if(frm == null){
						try{
							
							/*
							var formobj = window.parent.frames[1].frames[1].frames[1].frames[1].document.forms[0];
							var mainformobj = window.parent.frames[1].frames[1].frames[0].document.forms[0];
							*/
							var formobj = window.parent.content.f_query_add_mod.detail_frame.detail.document.forms[0];
							var mainformobj = window.parent.content.f_query_add_mod.master_frame.document.forms[0];

							if (formobj != null){	
								//hash.clear();
								//window.parent.frames[1].frames[1].frames[1].location.reload();
							}
							else if(mainformobj != null){
								window.parent.content.f_query_add_mod.master_frame.location.reload();
							}
							else{
								commontoolbarFrame.location.reload();
							}
						}
						catch(failed){
						
						//	alert(failed);
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
		//	alert("failed---->"+failed);
			commontoolbarFrame.location.reload();
		}
//	}
}
function chkDup()
{
	//var frmObj = window.parent.parent.parent.frames[3];
	
	var flag=0;
    var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","MTTasksLinkValidation.jsp?func_mode=chkDuplicate"+" ",false);
	xmlHttp.send(xmlDoc);
	retval=trimString(xmlHttp.responseText); 
	if(retval=='')
	{
		flag=0;
	}
	else
	{ flag=1;
	} 
	if(flag==0)	{
		return true;
	}
	else{ 
		alert(getMessage("RECORD_ALREADY_EXISTS","common"));
		return false;
	}


}

function formXMLString(multiple_yn){
	//var formObj = window.parent.frames[1].frames[1].frames[1].frames[1].document.forms[0];
	//var maxRecord=formObj.maxRecord.value;
    var record=new Array;
    var task_code="";
	var task_desc="";
    var seq_no="";
    var select_value="Y";
	

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
    xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","MTTasksLinkValidation.jsp?func_mode=getCheckedArray"+" ",false);
	xmlHttp.send(xmlDoc);
	//retval=xmlHttp.responseText; 
	var retVal = trimString(xmlHttp.responseText);
	var xmlString="<root>";
	if(retVal.length > 1){
		record= retVal.split("##");
		for(j=0;j<record.length-1;j=j+3){
			task_code=record[j];
			task_desc=record[j+1];
			seq_no=record[j+2];
			if(j==0){
				xmlString+="<RECORD_"+i+" ";
				xmlString+="task_code=\""+task_code+"\""+" ";
				xmlString+="seq_no=\""+seq_no+"\""+" ";
				xmlString+="select_value=\""+select_value+"\""+" />";
			}
			else if(j>=3 && multiple_yn == "Y"){
				xmlString+="<RECORD_"+i+" ";
				xmlString+="task_code=\""+task_code+"\""+" ";
				xmlString+="seq_no=\""+seq_no+"\""+" ";
				xmlString+="select_value=\""+select_value+"\""+" />";
			}
			else{
				alert(getMessage("APP-OH00016","OH"));
				return;
			}
		}
	}
	xmlString+="</root>";
	//hash.clear();
	return xmlString;

}
