/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var count=0;


function create()
{
	
	var cmf=commontoolbarFrame.document.forms[0];
	if(cmf.apply.disabled==true)
	{
      cmf.apply.disabled=false;
	 // cmf.reset.disabled=false;
    }
	f_query_add_mod.location.href='../../eOT/jsp/StoresforOperatingRoomFrame.jsp?mode=insert';
}
async function searchTheatre(obj,target){
	var formObj = document.forms[0];
	var locale = formObj.locale.value;
	var tcode = obj.value;
	var tdesc = target.value;

	var retVal =    new String();
	var facility_id = document.forms[0].facility_id.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit=getLabel("Common.Theatre.label","common");
	//var	sql="Select nursing_unit_code code,short_desc description from Ip_nursing_unit where nvl(eff_status,'E')='E' and  upper(nursing_unit_code) like upper(?) and upper(short_desc) like upper(?) order by 2";
	var sql="SELECT  OPER_ROOM_CODE code,SHORT_DESC description FROM OT_OPER_ROOM_LANG_VW  WHERE LANGUAGE_ID='"+locale+"' AND OPERATING_FACILITY_ID = '"+facility_id+"' and  upper(OPER_ROOM_CODE) like upper(?) and upper(short_desc) like upper(?) order by 2";
						
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK  ;
	argumentArray[7] = CODE_DESC ;

	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		obj.value=arr[0];
		target.value=arr[1];
	}else{
		target.value='';
		obj.value='';
	}
	var oper_room_code=formObj.oper_room_code.value;
	var facility_name1=formObj.facility_name1.value;
	var hash = new Hashtable();
	hash = parent.parent.frames[3].hash;
	hash.clear();
	//alert("oper_room_code---->"+oper_room_code)
	if(oper_room_code!='')
	{
	parent.detail_frame.location.href="../../eOT/jsp/StoresforOperatingRoomDetailForm.jsp?mode=insert"+"&oper_room_code="+oper_room_code+"&facility_name1="+facility_name1;
	}
	else
	{parent.detail_frame.location.href="../../eCommon/html/blank.html";
	}
}
function loadDtlForm()
{ 
document.forms[0].oper_room_code.value='';
parent.detail_frame.location.href="../../eCommon/html/blank.html";
}

function reset() {
if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("StoresforOperatingRoomFrame.jsp") != -1){
	if(typeof parent.content.f_query_add_mod=="undefined")
		  return false;
	 else
		 f_query_add_mod.document.location.reload();
}else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("StoresforOperatingRoomQueryCriteria.jsp") != -1)
	{
	f_query_add_mod.document.forms[0].reset();
	}
}

function query()
{
	var cmf=commontoolbarFrame.document.forms[0];
	//alert("commontoolbarFrame document==="+cmf.name);
	if(cmf.apply.disabled==false)
	{
      cmf.apply.disabled=true;
	 //commontoolbarFrame.document.forms[0].reset.disabled=true;
    }
	f_query_add_mod.location.href='../../eOT/jsp/StoresforOperatingRoomQueryCriteria.jsp';
}
function next(){
	var hash = new Hashtable();
	hash = parent.parent.frames[3].hash;
	//alert("hash-------->"+hash)
	var keys = hash.keys();
	var frm=window.parent.frames[0].document.forms[0];    
	var formObj = document.forms[0];
	//var modified_flag=formObj.modified_flag.value;
	var facility_name1=frm.facility_name1.value;
	var oper_room_code=frm.oper_room_code.value;
	//alert("oper_room_code--->"+oper_room_code)
	var start = formObj.start.value;
	formObj.start.value=parseInt(start)+14;
	start = formObj.start.value;
	var end = formObj.end.value;
	formObj.end.value=parseInt(end)+14;
	end = formObj.end.value;
    var masterFrame=window.parent.frames[0];
    var detailFrame=window.parent.frames[1];
	tot=document.forms[0].totalSelected.value;	
	var count=formObj.count.value;
	//alert("count--next->"+count)
	//alert("keys--->"+keys)
	 document.location.href="../../eOT/jsp/StoresforOperatingRoomDetailForm.jsp?from="+start+"&to="+end+"&facility_name1="+facility_name1+"&oper_room_code="+oper_room_code+"&totalSelected="+keys+"&count="+count;
}

function previous(){
	var hash = new Hashtable();
	hash = parent.parent.frames[3].hash;
	//alert("hash-------->"+hash)
	var keys = hash.keys();
	var frm=window.parent.frames[0].document.forms[0];
	var formObj = document.forms[0];
	//var modified_flag=formObj.modified_flag.value;
	var facility_name1=frm.facility_name1.value;
	var oper_room_code=frm.oper_room_code.value;
	//alert("oper_room_code--->"+oper_room_code)
	var start = formObj.start.value;
	formObj.start.value=start-14;
	var end = formObj.end.value;
	formObj.end.value=end-14;
	start = formObj.start.value;
	end = formObj.end.value;
	tot=document.forms[0].totalSelected.value;
	var count=formObj.count.value;
	//alert("count--PREVIOUS->"+count)
	document.location.href="../../eOT/jsp/StoresforOperatingRoomDetailForm.jsp?from="+start+"&to="+end+"&facility_name1="+facility_name1+"&oper_room_code="+oper_room_code+"&totalSelected="+keys+"&count="+count;
}

function validateCheckBox(obj){
	var formObj = document.forms[0];
	var arrObj = document.forms[0].elements;
	var hash = new Hashtable();
	var hash1 = new Hashtable();
	hash = parent.parent.frames[3].hash;
	hash1 = parent.parent.frames[3].dupChk;
	var indx = obj.name.replace("chk_select" , "");
	var target = eval("formObj.dflt_select"+indx);
	var target1 = eval("formObj.type_desc"+indx);
    if(target1.value=='')
	{   //alert("Please Select Store Type");
	   alert(getMessage("APP-OT0142","OT"));
	    obj.setAttribute("select_yn","N");
	    obj.checked=false;
		return;
	}
	if(target.checked==true)
	{target.dflt_select_yn="Y";}
	else
	{target.dflt_select_yn="N";}
	
	if(obj.checked==true ){
	obj.setAttribute("select_yn","Y");
	if(hash.get(indx)==null){
	hash.put(indx,obj.type_desc+"@@"+obj.getAttribute("select_yn")+"@@"+target.dflt_select_yn+"@@"+obj.getAttribute("facility_name")+"@@"+obj.getAttribute("store_desc"));		
	}else{
		if(hash.get(indx)!=null){
			var val = hash.get(indx).split("@@");
			if(val[5]!='I' || val[5]!='undefined')
			{
            val[5]="U";
			val[1]="Y";
			
			hash.put(indx,val[0]+"@@"+val[1]+"@@"+target.dflt_select_yn+"@@"+val[3]+"@@"+val[4]+"@@"+val[5]+"@@"+val[6]);
			}else
			{
				hash.remove(indx);// only for Insert mode records
			}
		}
	}
	}else{
	obj.setAttribute("select_yn","N");
	if(hash.get(indx)==null){
	hash.put(indx,obj.type_desc+"@@"+obj.getAttribute("select_yn")+"@@"+target.dflt_select_yn+"@@"+obj.getAttribute("facility_name")+"@@"+obj.getAttribute("store_desc"));	
	}else
	{
	//alert("257")
	if(hash.get(indx)!=null){
		var val = hash.get(indx).split("@@");
		//alert("val[6]###############"+val[6])
		//if(val[5]!='I' && obj.select_yn=='N') val[6]='YN';
		if(val[5]!='U') hash.remove(indx);
		else
		hash.put(indx,val[0]+"@@"+obj.getAttribute("select_yn")+"@@"+target.dflt_select_yn+"@@"+val[3]+"@@"+val[4]+"@@"+"D"+"@@"+val[6]);		
	}
	}
	}
}		

function validateDfltCheckBox(obj)
{
	var formObj = document.forms[0];
	var arrObj = document.forms[0].elements;
	var hash = new Hashtable();
	hash = parent.parent.frames[3].hash;
	var indx = obj.name.replace("dflt_select" , "");
	var target = eval("formObj.chk_select"+indx);
    var count = document.forms[0].count.value;
	//alert("count-------->"+count)
    //if(count!=0)
    var cnt=count;

	//alert("cnt===="+cnt)
	if(obj.checked==true ){
		//obj.dflt_select_yn="Y";
		obj.setAttribute("dflt_select_yn","Y");
		if(cnt>=2)
	    {
		//alert("Two Default Stores Already Selected for this Theatre");
		 alert(getMessage("APP-OT0140","OT"));
		//obj.dflt_select_yn="N";
		 obj.setAttribute("dflt_select_yn","N");
		obj.checked=false;
		return false;
	   }
	   else
		{
		 count++;
		document.forms[0].count.value=count;

		}
	}
	else{
	   // obj.dflt_select_yn="N";
	    obj.setAttribute("dflt_select_yn","N");
		count--;
		document.forms[0].count.value=count;
	}
	
	if(target.checked==true)
	{   
		if(hash.get(indx)!=null){
			
		var val = hash.get(indx).split("@@");
		if(val[5]!='U') val[5]="I";
	
		if(obj.getAttribute("dflt_select_yn")=='N' && val[5]!='I') val[6]="YN";
		hash.put(indx,val[0]+"@@"+val[1]+"@@"+obj.getAttribute("dflt_select_yn")+"@@"+val[3]+"@@"+val[4]+"@@"+val[5]+"@@"+val[6]);		
		}
		else
		{

		hash.put(indx,obj.type_desc+"@@"+obj.getAttribute("select_yn")+"@@"+obj.getAttribute("dflt_select_yn")+"@@"+obj.getAttribute("facility_name")+"@@"+obj.getAttribute("store_desc"));		
		}
		return;

	}
	else
	{  
		if(hash.get(indx)!=null){
			var val = hash.get(indx).split("@@");
			if(val[1]=='N'){val[1]="N";val[5]="D";}
			if(obj.getAttribute("dflt_select_yn")=='N' && val[5]!='I') val[6]="YN";
			hash.put(indx,val[0]+"@@"+val[1]+"@@"+obj.getAttribute("dflt_select_yn")+"@@"+val[3]+"@@"+val[4]+"@@"+val[5]+"@@"+val[6]);
		}
	}
	if(obj.checked==true ){
		//obj.dflt_select_yn="Y";
		obj.setAttribute("dflt_select_yn","Y");
	}
	else{
	    //obj.dflt_select_yn="N";
		obj.setAttribute("dflt_select_yn","N");
	}
}

function assingListItemValue(key){
   	var formObj = document.forms[0];
	var hash = new Hashtable();
	hash = parent.parent.frames[3].hash;
	//alert("hash--230-->"+hash)
	if(hash.get(key)!=null){
		var val = hash.get(key).split("@@");
		eval("formObj.chk_select"+key).checked= (val[1]=="Y")?true:false
		eval("formObj.dflt_select"+key).checked= (val[2]=="Y")?true:false
		eval("formObj.type_desc"+key).value=val[0];
	}
}

function valueChanged(obj){
	var formObj = document.forms[0];
	var hash = new Hashtable();
	var indx = obj.name.replace("type_desc" , "");
	hash = parent.parent.frames[3].hash;
	//hash1 = parent.parent.frames[3].dupChk;
	var id = obj.name.replace("type_desc","");
	var target = eval("formObj.chk_select"+id);
	var target1 = eval("formObj.dflt_select"+id);
    var count = document.forms[0].count.value;
	if(obj.value!=""){
		target.type_desc=obj.value;
		target.checked = false;
		if(target1.checked==true)
		{
			target1.checked = false;
			count--;
			document.forms[0].count.value=count;
		}
		hash.remove(indx);
	}else{
		//alert("318")
		target.checked = false;
		if(target1.checked==true)
		{
		target1.checked = false;
		count--;
		document.forms[0].count.value=count;
		}
		hash.remove(indx);
	}
	/*if(obj.value!=""){
		alert("328")
		target.checked = false;
		target1.checked = false;
			hash.remove(indx);
		//isDuplicateRecord(target);
		//target.select_yn="N";
	
		//alert("type_desc======"+target.type_desc)  
		//hash1.remove(indx);
	}else{
	alert("337")
	hash.remove(indx);
	//hash1.remove(indx);
	onChange='changeOfFacility();'
	}*/
}

function onChangeStoreCode()
{
   var formObj=document.forms[0];
   var facility_name1=formObj.facility_name1.value;
   var oper_room_code=formObj.oper_room_code.value;
   var store_room_code=formObj.store_code.value;
   var hash = new Hashtable();
   hash = parent.parent.frames[3].hash;
   hash.clear();
   if(oper_room_code=='')
	{
	   //alert("Please select Operating Room");
	   alert(getMessage("APP-OT0141","OT"));
	   return false;
	}
   else{
	parent.detail_frame.location.href="../../eOT/jsp/StoresforOperatingRoomDetailForm.jsp?mode=insert"+"&facility_name1="+facility_name1+"&oper_room_code="+oper_room_code+"&store_room_code="+store_room_code;
   }


}


function changeOfFacility(){
	var formObj = document.StoresforOperatingRoom;
	var oper_room_code	=	formObj.oper_room_code.value;
	var facility_name1	=	formObj.facility_name1.value;
	var len_str_rm=formObj.store_code.length;
	var hash = new Hashtable();
    hash = parent.parent.frames[3].hash;
    hash.clear();
	var i=0;
	while(i<len_str_rm){
		formObj.store_code.remove(1);
		i++;
	}
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var params = "func_mode=getStoresRoomCode&facility_id="+facility_name1;
	xmlHttp.open("GET","../../eOT/jsp/OTCommonValidation.jsp?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);	
	var retVal_arr = retVal.split("~");
	for(k=0;k<retVal_arr.length-1;k++){
			var code_mixed = retVal_arr[k].split("##");
				var element 	= document.createElement('OPTION') ;
				element.value 	= code_mixed[0];
				element.text 	= code_mixed[1] ;
				document.forms[0].store_code.add(element);
	}
   if(oper_room_code=='')
	{
	   //alert("Please select Operating Room");
	   alert(getMessage("APP-OT0141","OT"));
	   return false;
	}
   else{
   parent.detail_frame.location.href="../../eOT/jsp/StoresforOperatingRoomDetailForm.jsp?mode=insert"+"&facility_name1="+facility_name1+"&oper_room_code="+oper_room_code;
   }
}



function apply()
{	
	var mesg=getMessage("NO_CHANGE_TO_SAVE","Common");

	
	if(typeof parent.content.f_query_add_mod.master_frame!="undefined"){
	var fields = new Array (parent.content.f_query_add_mod.master_frame.document.forms[0].oper_room_code);
	var operroom=getLabel("Common.OperatingRoom.label","OT");
	var names = new Array (operroom);
	 if(checkFieldsofMst( fields, names, messageFrame)) 
	{
	if(typeof parent.content.f_query_add_mod.detail_frame!="undefined" ){
    var formObj = parent.content.f_query_add_mod.detail_frame.document.forms[0];
	if(formObj!=null)
	{
	var params = formObj.params.value;
	//var speciality_code=formObj.speciality_code.value;
	var oper_room_code=parent.content.f_query_add_mod.master_frame.document.forms[0].oper_room_code.value;
	var store_code=parent.content.f_query_add_mod.master_frame.document.forms[0].store_code.value;
	var facility_name1=parent.content.f_query_add_mod.master_frame.document.forms[0].facility_name1.value;
	var facility_id=parent.content.f_query_add_mod.master_frame.document.forms[0].facility_id.value;
    
	var fields = new Array (parent.content.f_query_add_mod.master_frame.document.forms[0].oper_room_code);
	var operroom=getLabel("Common.OperatingRoom.label","OT");
	var names = new Array (operroom);
	//alert("oper_room_code--->"+oper_room_code)
	//var flag_man=checkFieldsofMst( fields, names, messageFrame);
	//alert("falg_man--->"+falg_man)
	
	var arr = formObj.elements;
	var hash = new Hashtable();
	
	hash = parent.content.hidden_frame.hash;
	var store_i="N";
	var sql_i="SELECT 'X' FROM OT_STORES_FOR_THEATRE WHERE OPERATING_FACILITY_ID  = '"+facility_id+"' AND   OPER_ROOM_CODE = '"+oper_room_code+"' AND   STORE_TYPE ='I' AND   NVL(DEFAULT_YN,'N') ='Y'";
	var param="sql="+sql_i;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
	xmlHttp.send(xmlDoc);;
	var return_val_i=xmlHttp.responseText;
	var store_i=eval(return_val_i);
    
	var store_r="N";
	var sql_i="SELECT 'X' FROM OT_STORES_FOR_THEATRE WHERE OPERATING_FACILITY_ID  = '"+facility_id+"' AND   OPER_ROOM_CODE = '"+oper_room_code+"' AND   STORE_TYPE ='R' AND   NVL(DEFAULT_YN,'N') ='Y'";
	var param="sql="+sql_i;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
	xmlHttp.send(xmlDoc);;
	var return_val_r=xmlHttp.responseText;
	var store_r=eval(return_val_r);
	//alert("store_i==="+store_i)
	//alert("store_r==="+store_r)

    var flag_store=chkDuplicationStoreType(store_i,store_r)
		//alert("flag_store===="+flag_store)
		//flag_store=false;
	if(flag_store==true)
	{
	var xmlStr=formXMLString(store_i,store_r);	
	if(xmlStr!="<root></root>"){
		var action="../../servlet/eOT.StoresforOperatingRoomServlet?oper_room_code="+oper_room_code;
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",action,false);
		xmlHttp.send(xmlDoc);
		var retVal = xmlHttp.responseText;
		mesg = retVal;
		//parent.content.f_query_add_mod.detail_frame.document.location.reload();
		parent.content.f_query_add_mod.detail_frame.location.href="../../eOT/jsp/StoresforOperatingRoomDetailForm.jsp?mode=insert"+"&facility_name1="+facility_name1+"&oper_room_code="+oper_room_code+"&store_room_code="+store_code;
		parent.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
	}else{
			parent.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
		}
	}
	else{
		//mesg="Please Select Differenct Default Stores";
		mesg=getMessage("APP-OT0139","OT");
		parent.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
	}
	//}
	
	}
	else
		{
		parent.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	    }
		}else
		{   //var mesg=getMessage("NO_CHANGE_TO_SAVE","Common");
			parent.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
		}
	}
	}
	else{
			
            parent.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
}
 // parent.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
}


function formXMLString(){
	var xmlString="<root>";
	var hash = new Hashtable();
	//hash = parent.frames[1].frames[3].hash;
	hash = parent.content.hidden_frame.hash;
	//alert("hash-------apply--->"+hash)
	if(hash.size()>0){
		var key = hash.keys();
		var arr=key.toString().split(",");
		for(var i=0;i<arr.length;i++){
			   xmlString+="<RECORD_"+i+" ";
			   var arr1=hash.get(arr[i]).split("@@");
			   xmlString+="type_desc=\""+arr1[0]+"\""+" ";
			   xmlString+="select_value=\""+arr1[1]+"\""+" ";
			   xmlString+=" dflt_select_value=\""+arr1[2]+"\""+" " 
			   xmlString+="facility_name=\""+arr1[3]+"\""+" " 
			   xmlString+="store_desc=\""+arr1[4]+"\""+" "  
			   xmlString+="mode=\""+arr1[5]+"\""+"  />";	   
		}
	}
	xmlString+="</root>";
	hash.clear();
	return xmlString;
}
function chkDuplicationStoreType(store_i,store_r)
{   
	var hash = new Hashtable();
	var cnt_i=0;
	var cnt_r=0;
	var flag=true;
	if(store_i=='X') cnt_i++;
	if(store_r=='X') cnt_r++;
	//alert("cnt_i----515--->"+cnt_i)
	//alert("cnt_r----516--->"+cnt_r)
	hash = parent.content.hidden_frame.hash;
	var count=0;
	if(hash.size()>0){
		var key = hash.keys();
		var arr=key.toString().split(",");
		for(var i=0;i<arr.length;i++){
			   var arr2=hash.get(arr[i]).split("@@");
			   if(arr2[5]=='undefined')arr2[5]='I'

			  // alert("arr2[6]******"+arr2[6])
			   if(arr2[1]=='Y' && arr2[2]=='Y' && arr2[0]=='I' && arr2[6]!='Y')
			    {
				   //alert("483")
					   //alert("cnt_i ########"+cnt_i)
				 cnt_i++;
				    //alert("cnt_i ########"+cnt_i)
			    }
				//alert("arr2[2]******"+arr2[2])
				//alert("arr2[0]******"+arr2[0])
				//alert("arr2[5]******"+arr2[5])
				//alert("arr2[6]******"+arr2[6])
			   if(arr2[2]=='N' && arr2[0]=='I' && arr2[5]!='I' && arr2[6]=='YN')
			   {
				     //alert("500")
				   // alert("cnt_i ########"+cnt_i)
					cnt_i--;
			   }


			   if(arr2[1]=='Y' && arr2[2]=='Y' && arr2[0]=='R' && arr2[6]!='Y')
			   {//alert("502")
					  //alert("cnt_r ########"+cnt_r)
			     cnt_r++;
			   }
			    if(arr2[2]=='N' && arr2[0]=='R' && arr2[5]!='I' && arr2[6]=='YN')
			   {   //alert("507")
				   cnt_r--;
			   }

			   //alert("cnt_i---478----->"+cnt_i)
			  // alert("cnt_r----480---->"+cnt_r)
				    //alert("count--->"+count)

				   count++;
			
}
//alert("cnt_i==="+cnt_i)
//alert("cnt_r==="+cnt_r)
	if(cnt_i==2 || cnt_r==2)
	{
		//alert("581")
	flag=false;
	//break;
	}
	else
	{
		//alert("586")
	   flag=true
	}
}
return flag;
}

function pushChkBox(indx,val){
		var hash = new Hashtable();
		hash = parent.parent.frames[3].hash;
		if(hash.get(indx)==null ||hash.get(indx)=='undefined'){
		hash.put(indx,val);
		}
		else if(hash.get(indx)!=null)
	    {
         var val1 = hash.get(indx).split("@@");
         var val = val.split("@@");
         if(val1[1]!=val[1]) val[1]=val1[1];
		 if(val1[2]!=val[2]) val[2]=val1[2];
		 if(val1[5]!=val[5] && val[5]!='') val[5]=val1[5];
		 if(val[5]=='undefined'&& val1[1]!='N') val[5]="U";
		 if(val1[6]!=val[6] && val[6]!='') val[6]=val1[6];
		  hash.put(indx,val[0]+"@@"+val[1]+"@@"+val[2]+"@@"+val[3]+"@@"+val[4]+"@@"+val1[5]+"@@"+val[6]);
		 //hash.put(indx,val);
	    }
}
function pushCount(val){
		var hash = new Hashtable();
		hash = parent.parent.frames[3].hash;
		hash.put(indx,val);
}

function setAssignValue(dat){
	return dat;
}
