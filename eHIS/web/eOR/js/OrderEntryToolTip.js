/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
// In Order Entry Module all the places, this method is called to hide the tool tip
/*-------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
-------------------------------------------------------------------------------------------------
29/04/2016	    IN060148   		Raja S												MMS-MD-SCF-0009 (Order entry scrren,EXPLANATORY_TEXT
																					is not showing while the mouse moveover(IE11))
-------------------------------------------------------------------------------------------------
*/
function hideToolTip()	
{
	if(document.getElementById("tooltiplayer"))
		document.getElementById("tooltiplayer").style.visibility = 'hidden'
}

// In Order Entry Module all the places, this method is called to display the tool tip
function showToolTip(catalog_code, form_name) {

 	// All the places except Amend Order
	/*
	if(eval("document."+form_name+".explanatory_text"+catalog_code))
	 	explanatory_text	= eval("document."+form_name+".explanatory_text"+catalog_code+".value");
	else   // For Amend Orders
		explanatory_text	= eval("document."+form_name+".amend_explanatory_text"+catalog_code+".value");
	*/
	var form = document.getElementById(form_name);

	if(form["explanatory_text"+catalog_code])
	 	explanatory_text	= form["explanatory_text"+catalog_code].value;
	else   // For Amend Orders
		explanatory_text	= form["amend_explanatory_text"+catalog_code].value;

	if(explanatory_text!=null && explanatory_text!="")
    {
		buildToolTable(explanatory_text);
 		resizeWindow();
	}
}
 
function buildToolTable(val) {

	var tab_dat		= "<table id='tooltiptable1' class='contextMenu' width='100%' height='100%' align='center'>"
		tab_dat     += "<tr>"
		tab_dat     += "<td class = 'contextMenuItem'><B>"+val+" </B></td>"
 		tab_dat     += "</tr> "
 		tab_dat     += "</table> "
	document.getElementById("t").innerHTML = tab_dat;
		
}

function resizeWindow(){

    var bodwidth = document.body.offsetWidth;
    var bodheight = document.body.offsetHeight;
    var x = event.clientX;  // Get the current mouse X position
    var y = event.clientY;  // Get the current mouse Y position

    // Position tooltip to the right and below the cursor
    var offsetX = 10;  // 10px to the right of the cursor
    var offsetY = 10;  // 10px below the cursor

    // Set the tooltip position to be below and to the right of the cursor
    x = x + offsetX;  
    y = y + offsetY;

    // If the tooltip goes out of the window's bounds horizontally, adjust the position
    if (x + document.getElementById("tooltiplayer").offsetWidth > bodwidth) {
        x = x - document.getElementById("tooltiplayer").offsetWidth - offsetX;  // Move to the left if it exceeds the window width
    }

    // If the tooltip is going out of the window's bounds vertically, adjust the position
    if (y + document.getElementById("tooltiplayer").offsetHeight > bodheight) {
        y = y - document.getElementById("tooltiplayer").offsetHeight - offsetY;  // Move it above the cursor if it's too far below
    }

    // Set the tooltip position (right and below the cursor)
    document.getElementById("tooltiplayer").style.left = x + 'px';  // Set X position to the right of the cursor
    document.getElementById("tooltiplayer").style.top = y + 'px';   // Set Y position below the cursor

    // Make the tooltip visible
    document.getElementById("tooltiplayer").style.visibility = 'visible';
}

 // from here  multifulConsent   added on 02/05/2007  by Hari

 async function callMultipleConsent(catalog_code,catalog_desc,order_id,order_line_num,order_category,index)
{
	var dialogHeight		= '62vh';
	var dialogWidth			= '37vw';
	var dialogTop			= '267';
	var dialogLeft			= '200' ;
	var title				= ''
	var	arguments			= "";	
	var	features			= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth + ';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
	var bean_id				=  "";
	var bean_name			=  "";
	var consent_form_id		=  "";
	var new_consent_format_label =  "";
	var buttn_label = "Orders";
	
	if(document.forms[0].name == "consent_order_dtl"){
		buttn_label = "Consent";
		bean_id		= document.consent_order_dtl.bean_id.value;
		bean_name	= document.consent_order_dtl.bean_name.value;
		if(document.getElementById("details"+index).style.visibility == 'visible'){
			consent_form_id	= document.consent_order_dtl.consent_form_id+index.value;
		}
		//alert("consent_form_id="+consent_form_id);
	}else{
		bean_id		= document.placeOrderForm.bean_id.value;
		bean_name	= document.placeOrderForm.bean_name.value;
	}
	
	if( catalog_desc.indexOf("(") != -1)		
		catalog_desc = catalog_desc.substring(1,(catalog_desc.length-1));
	
	global_index			= index;
	global_form_id			= consent_form_id;	

	var retVals				=  await top.window.showModalDialog("../../eOR/jsp/AssociateMultipleConsentFrameSet.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&index="+index+"&consent_form_id="+escape(consent_form_id)+"&consent_format_label="+escape(new_consent_format_label)+"&order_catalog_code="+catalog_code+"&order_catalog_desc="+catalog_desc+"&order_id="+order_id+"&order_line_num="+order_line_num+"&order_category="+order_category+"&buttn_label="+buttn_label,arguments,features);

	var type ="";
//alert("retVals="+retVals);
	if(document.forms[0].name == "consent_order_dtl" && retVals == "RELOAD" ){
		
		if(eval(document.getElementById("consent_form_id"+index)) && eval(document.getElementById("consent_form_id"+index)).type == "select-one" ){
			clearList(global_index);
			type = eval(document.getElementById("consent_form_id"+index)).type ;
		}
	
		var consent_id ="",consent_desc ="",noteligible_consent_id="";

		var xmlDoc = ""; 
		var xmlHttp = new XMLHttpRequest();
		xmlStr ="<root><SEARCH " ;
		xmlStr += "order_catalog_code=\""+ catalog_code+"\" " ;
		xmlStr += "order_id=\""+ order_id+"\" " ;
		xmlStr += "order_line_num=\""+ order_line_num+"\" " ;
		xmlStr += "type=\""+ type+"\" " ;
		xmlStr +=" /></root>" ;

		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "ConsentOrdersValidate.jsp?bean_id=" + bean_id + "&validate=MULTI_CONSENT", false ) ;

		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval(responseText )
		
		if(eval("document.consent_order_dtl.noteligible_consent_id"+global_index)){
			eval("document.consent_order_dtl.noteligible_consent_id"+global_index).value = noteligible_consent_id ;
		}

		if (!eval(document.getElementById("consent_form_id"+index)) ||(eval(document.getElementById("consent_form_id"+index)) && eval(document.getElementById("consent_form_id"+index)).type != "select-one"))
		{
			
			if (eval(document.getElementById("consent_form_id"+index)) && eval(document.getElementById("consent_form_id"+index)).value != consent_id)
			{
				clearConsents(global_index,'Text');
				var details_link=eval("parent.ConsentOrdersBottomRight1.document.consent_order_dtl.details"+index);
				details_link.style.visibility = "hidden";
				var val=eval("parent.ConsentOrdersBottomRight1.document.consent_order_dtl.chk"+index);
				val.checked=false;
				val.value=""; 
			}
			
			eval(document.getElementById("multi_consent"+global_index)).innerHTML = "<font size=1><BR><A class='gridLink' HREF='javascript:displayDetails(\""+global_index+"\")' title='Consent to be Recorded'>"+consent_desc+"</A></font><input type='hidden' name='consent_form_id"+global_index+"' id='consent_form_id"+global_index+"' value='"+consent_id+"'><input type='hidden' name='noteligible_consent_id"+global_index+"' id='noteligible_consent_id"+global_index+"' value='"+noteligible_consent_id+"'>";
		}
		//eval("document.getElementById("link_consent")"+global_index).style.visibility = "visible";
		eval(document.getElementById("multi_label"+global_index)).innerText =getLabel("eOR.Redefine.label","OR");
		
		alignHeading();
	}
if(document.forms[0].name == "consent_order_dtl")
	 {
		document.forms[0].submit();
	 }
	
	
 }

function showSelect(){
	
	if(eval(document.getElementById("consent_form_id"+global_index)) && eval(document.getElementById("consent_form_id"+global_index)).style.visibility == "hidden"){
		eval(document.getElementById("consent_form_id"+global_index)).style.visibility = "visible" ;
		if(eval(document.getElementById("consent_form_id"+global_index)) && eval(document.getElementById("consent_form_id"+global_index)).type == "select-one" )
			clearList(global_index);
	}
}

function callDefaultSelect(){
	
	if (eval("document.consent_order_dtl.details"+global_index).style.visibility == "visible")
	{
		if(eval("document.consent_order_dtl.consent_form_id"+global_index).type == "select-one"){
			var len = eval("document.consent_order_dtl.consent_form_id"+global_index).options.length ;
			for(var i=0;i<len;i++)
			{
				if(global_form_id == eval("document.consent_order_dtl.consent_form_id"+global_index).options[i].value ){
					eval("document.consent_order_dtl.consent_form_id"+global_index).options[i].selected = true;
					break;
				}
			}
		}
		if (global_form_id != "" && eval(document.getElementById("consent_form_id"+global_index)).value != global_form_id)
		{
			clearConsents(global_index,'Text');
			var details_link=eval("parent.ConsentOrdersBottomRight1.document.consent_order_dtl.details"+global_index);
			details_link.style.visibility = "hidden";
			var val=eval("parent.ConsentOrdersBottomRight1.document.consent_order_dtl.chk"+global_index);
			val.checked=false;
			val.value=""; 
		}
	}else
		defaultSelect(global_index)
	
}

function addConfirmedConsentList(code,value,recorded_yn) {
	var element		 = document.createElement('OPTION') ;
	element.value	 = code ;
	element.text	 = value ;
	
	if(recorded_yn == "Y")
		element.style.backgroundColor = "#FFA8A8" ;
	
	eval("document.consent_order_dtl.consent_form_id"+global_index).add(element);
}

function clearList(global_index) {
	//alert("here");
	var len = eval("document.consent_order_dtl.consent_form_id"+global_index).options.length ;
	for(var i=0;i<len;i++)
	{
		eval("document.consent_order_dtl.consent_form_id"+global_index).remove("atc_class_l2_code") ;
	}
	var element		 = document.createElement('OPTION') ;
	element.value	 = "" ;
	element.text	 = "----Select----" ;
	eval("document.consent_order_dtl.consent_form_id"+global_index).add(element);
}

 async function showConsent(target,code) {
	
  	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var localeName=document.multiple_consent_form.localeName.value;

	argumentArray[0]   = document.multiple_consent_form.consent_form_id_sql.value;
	argumentArray[0]=argumentArray[0].replace('?',"'"+localeName+"'");

	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = target.value ;
	//argumentArray[5]   = "" ;
	argumentArray[6]   = CODE_DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;
	var title=getLabel("eOR.AssociateConsent.label","OR");
	retVal = await CommonLookup( title, argumentArray );
	var ret1=unescape(retVal);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retVal != null && retVal != ""){
		code.value=arr[0];
		target.value=arr[1];
    }else
	 {
		code.value="";
		target.value="";
	 }
}

function StoreValues(){
	
	var total_recs	 = parent.multi_detail.document.multiple_consent_form.total_recs.value;
	var index		 = parent.multi_detail.document.multiple_consent_form.index.value;
	var ord_catalog_code = parent.multi_detail.document.multiple_consent_form.ord_catalog_code.value;
	var order_category = parent.multi_detail.document.multiple_consent_form.order_category.value;
	var formObj		 = parent.multi_detail.document.multiple_consent_form;
	var record		 = false;
	var num_of_consent_req_bo = 0;
	var num_of_consent_req_br = 0;
	if(formObj.num_of_consent_req_bo){
		num_of_consent_req_bo = formObj.num_of_consent_req_bo.value;
		num_of_consent_req_br = formObj.num_of_consent_req_br.value;
	}
	//alert(total_recs+index+ord_catalog_code+order_category);

	var tmp_cnt_bo	 = 0;
	var tmp_cnt_br	 = 0;
	var atleast_one	 = 0;
	var consent_chk	 = "N";
	var bean_id		 = parent.multi_detail.document.multiple_consent_form.beanOr_id.value;
	var bean_name	 = parent.multi_detail.document.multiple_consent_form.beanOr_name.value;
	
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr			= "<root><SEARCH " ;
	xmlStr			+= "bean_id=\"" +bean_id +"\" ";
	xmlStr			+= "bean_name=\"" +bean_name +"\" ";
	xmlStr			+= "index=\"" +index +"\" ";
	xmlStr			+= "ord_catalog_code=\"" +ord_catalog_code +"\" ";
	xmlStr			+= "order_category=\"" +order_category +"\" ";
	xmlStr			+= "count=\"" +total_recs +"\" ";

	for(var i=0;i<total_recs;i++){
		
		if(eval("formObj.consent_chk"+i)){
			//alert(eval("formObj.consent_chk"+i));
			
			if(eval("formObj.consent_chk"+i).type == 'checkbox' && eval("formObj.consent_chk"+i).checked){
				
				consent_chk	 = "Y";
				record		 = true;
				if(eval("formObj.consent_stage"+i).value == "A"){
					if(++tmp_cnt_bo > num_of_consent_req_bo){
						record = false;
						//alert("APP-OR00282 No of Consent to be Recorded Before Order Release Exceeds the Specified Count:"+num_of_consent_req_bo);
						alert(getMessage("NO_OF_CONSENT_RECORDED_BEFOR_ORDER_REALEASE_EXC_SPEC_COUNT","OR")+"..."+num_of_consent_req_bo);

						
						return false;
					}
				}
				if(eval("formObj.consent_stage"+i).value == "R"){
					if(++tmp_cnt_br > num_of_consent_req_br){
						record = false;
						//alert("APP-OR00283 No of Consent to be Recorded Before Order Registration Exceeds the Specified Count:"+num_of_consent_req_br);
						alert(getMessage("NO_OF_CONSENT_RECORDED_BEFOR_ORDER_REGISTRATION_EXC_SPEC_COUNT","OR")+"..."+num_of_consent_req_br);

						
						return false;
					}

				}
			}else if (eval("formObj.consent_chk"+i).type == 'hidden')
			{
				record		= true;
				consent_chk = "Y";
			}else{
				consent_chk = "N";
			}
		}else if(eval(parent.multi_detail.document.getElementById("assign_consent"+i))){

			//alert(eval("formObj.consent_stage"+i).value);
			//alert(eval("formObj.consent_form_id"+i).value);
			//alert(eval("formObj.consent_form_desc"+i).value);
					
			if(eval("formObj.consent_form_id"+i) && eval("formObj.consent_form_id"+i).value == "" ){
				consent_chk = "N";
				if(atleast_one == 0 && i == (total_recs-1)){
					//alert("APP-OR00284 Please Assign a Consent Form to Record");
					alert(getMessage("ASSIGN_CONSENT_FORM_TO_RECORD","OR"));
	
					if(eval("formObj.consent_form_id"+i).type != "hidden")
						eval("formObj.consent_form_id"+i).focus();
					else
						eval("formObj.consent_form_desc"+i).focus();
					return false;
				}
			}else{
				record		 = true;
				consent_chk  = "Y";
				atleast_one++;
				if(eval("formObj.consent_form_desc"+i))
					xmlStr	+= "consent_form_desc"+i+"=\""+eval("formObj.consent_form_desc"+i).value+"\" ";
			}
			if((eval("formObj.consent_form_desc"+i)) && (eval("formObj.consent_stage"+i)) &&(eval("formObj.consent_form_id"+i)) )
			{
				if(eval("formObj.consent_stage"+i).value == "A" && ((eval("formObj.consent_form_desc"+i) && eval("formObj.consent_form_desc"+i).value != "" ) || eval("formObj.consent_form_id"+i).value !="" ) ){
					if(++tmp_cnt_bo > num_of_consent_req_bo){
						record = false;
						//alert("APP-OR00282 No of Consent to be Recorded Before Order Release Exceeds the Specified Count:"+num_of_consent_req_bo);
						alert(getMessage("NO_OF_CONSENT_RECORDED_BEFOR_ORDER_REALEASE_EXC_SPEC_COUNT","OR")+"..."+num_of_consent_req_bo);

						
						return false;
					}
			}
			}
			if((eval("formObj.consent_form_desc"+i)) && (eval("formObj.consent_stage"+i)) &&(eval("formObj.consent_form_id"+i)) )
			{
			  if(eval("formObj.consent_stage"+i).value == "R" && ((eval("formObj.consent_form_desc"+i) && eval("formObj.consent_form_desc"+i).value != "" ) || (eval("formObj.consent_form_id"+i) && eval("formObj.consent_form_id"+i).value !="" ))){
				if(++tmp_cnt_br > num_of_consent_req_br){
					record = false;
					//alert("APP-OR00283 No of Consent to be Recorded Before Order Registration Exceeds the Specified Count:"+num_of_consent_req_br);
					
					alert(getMessage("NO_OF_CONSENT_RECORDED_BEFOR_ORDER_REGISTRATION_EXC_SPEC_COUNT","OR")+"..."+num_of_consent_req_br);
				
					return false;
				}
	
			}
			//break;
			}
			
		}
		var consent_form_id	 = "";
		var consent_stage	 = "";
		if(eval("formObj.consent_form_id"+i))
			consent_form_id	 = eval("formObj.consent_form_id"+i).value;
		if(eval("formObj.consent_stage"+i))
			consent_stage	 = eval("formObj.consent_stage"+i).value;

		xmlStr		+= "consent_chk"+i+"=\"" +consent_chk+"\" ";
		xmlStr		+= "consent_form_id"+i+"=\""+consent_form_id+"\" ";
		xmlStr		+= "consent_stage"+i+"=\""+consent_stage+"\" ";
		
	}
	var form_idarr = new Array();
	var form_descarr = new Array();  
	for(var i=0;i<total_recs;i++){

		if (eval("formObj.consent_form_id"+i) && eval("formObj.consent_form_desc"+i) && eval("formObj.consent_form_id"+i).value != "")
		{
			form_idarr[i]=eval("formObj.consent_form_id"+i).value ;  
			form_descarr[i]=eval("formObj.consent_form_desc"+i).value ;  
			
		}

		for (var j=i+1;j<total_recs;j++)
		{ 
			if(eval("formObj.consent_form_desc"+j) && eval("formObj.consent_form_desc"+j).value != "" && eval("formObj.consent_form_id"+j).value ==""){	
				
				for (key in form_descarr)					// Iterate the array.
				{
					if(eval("formObj.consent_form_desc"+j).value == form_descarr[key])
						eval("formObj.consent_form_id"+j).value = form_idarr[key];
					
					break;
				}
			}
				
			
			if(eval("formObj.consent_form_id"+i) && eval("formObj.consent_form_id"+i).value != "" && eval("formObj.consent_form_id"+j).value != "" && eval("formObj.consent_form_id"+i).value == eval("formObj.consent_form_id"+j).value ){
				//alert('APP-OR0285 Duplicate Consent Form are Not Allowed');
				alert(getMessage("DUPLICATE_CONSENT_FORM_NOT_ALLOWED","OR"));
				
				eval("formObj.consent_form_desc"+j).select();
				return false;
			}
			
			
		}
		

	}
	var confirm_val = true;
	if (tmp_cnt_bo < num_of_consent_req_bo && tmp_cnt_br < num_of_consent_req_br)
	{	
		//confirm_val = window.confirm("APP-OR00282 No of Consent to be Recorded Before Order Release and Before Registration is Less Than the Specified Count: "+num_of_consent_req_bo+" and "+num_of_consent_req_br+" Respectively");
		 confirm_val = window.confirm(getMessage("NO_OF_CONSENT_RECORDED_BEFOR_BEFOR_ORDER_REALEASE_AND_ORDER_REGISTRATION_LESS_THAN_SPEC_COUNT","OR")+"..."+num_of_consent_req_bo+" "+getLabel("Common.and.label","Common") +" "+num_of_consent_req_br+" "+"Respectively");

	}else{
		if(tmp_cnt_bo < num_of_consent_req_bo){
		//	confirm_val = window.confirm("APP-OR00282 No of Consent to be Recorded Before Order Release is Less Than the Specified Count:"+num_of_consent_req_bo);
		confirm_val = window.confirm(getMessage("NO_OF_CONSENT_RECORDED_BEFOR_ORDER_REALEASE_LESS_THAN_SPEC_COUNT","OR")+"..."+num_of_consent_req_bo);

							
		}
		if(tmp_cnt_br < num_of_consent_req_br){
			//confirm_val = window.confirm("APP-OR00283 No of Consent to be Recorded Before Order Registration is Less Than the Specified Count:"+num_of_consent_req_br);
		
				confirm_val = window.confirm(getMessage("NO_OF_CONSENT_RECORDED_BEFOR_ORDER_REGISTRATION_LESS_THAN_SPEC_COUNT","OR")+"..."+num_of_consent_req_br);

		}
	}
	if (!confirm_val)
	{
			return false;
	}
	if (!record)
	{
		//alert('APP-OR0281 Check Atleast One Consent Form to Record');
		alert(getMessage("CHECK_ATLEAST_ONE_CONSENT_FORM_TO_RECORD","OR"));

		return false;
	}
	
	xmlStr 					+=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "OrderEntryValidate.jsp?&bean_id="+bean_id+"&bean_name="+bean_name+"&func_mode=MULTICONSENT_DTLS", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;
	//window.close();
	const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close(); 
}

function RecordValues(){
	

	var total_recs	 = parent.multi_detail.document.multiple_consent_form.total_recs.value;
	var formObj		 = parent.multi_detail.document.multiple_consent_form;
	var record		 = false;
	var num_of_consent_req_bo = 0;
	var num_of_consent_req_br = 0;
	var atleast_one	 = 0;
	if(formObj.num_of_consent_req_bo){
		num_of_consent_req_bo = formObj.num_of_consent_req_bo.value;
		num_of_consent_req_br = formObj.num_of_consent_req_br.value;
	}
	
	var tmp_cnt_bo	 = 0;
	var tmp_cnt_br	 = 0;
	
	for(var i=0;i<total_recs;i++){
		
		if(eval("formObj.consent_chk"+i)){
			
			if(eval("formObj.consent_chk"+i).checked){
				record = true;
				if(eval("formObj.consent_stage"+i).value == "A"){
					if(++tmp_cnt_bo > num_of_consent_req_bo){
						record = false;
						//alert("APP-OR00282 No of Consent to be Recorded Before Order Release Exceeds the Specified Count:"+num_of_consent_req_bo);
						
						alert(getMessage("NO_OF_CONSENT_RECORDED_BEFOR_ORDER_REALEASE_EXC_SPEC_COUNT","OR")+"..."+num_of_consent_req_bo);

						return false;
					}
				}
				if(eval("formObj.consent_stage"+i).value == "R"){
					if(++tmp_cnt_br > num_of_consent_req_br){
						record = false;
						//alert("APP-OR00283 No of Consent to be Recorded Before Order Registration Exceeds the Specified Count:"+num_of_consent_req_br);
						alert(getMessage("NO_OF_CONSENT_RECORDED_BEFOR_ORDER_REGISTRATION_EXC_SPEC_COUNT","OR")+"..."+num_of_consent_req_br);

						return false;
					}

				}
			}
		}else if(eval(parent.multi_detail.document.getElementById("assign_consent"+i))){
			record = true;
			
			if(eval("formObj.consent_form_id"+i).value == "" ){
				if(atleast_one == 0 && i == (total_recs-1)){
					//alert("APP-OR00284 Please Assign a Consent Form to Record");
					alert(getMessage("ASSIGN_CONSENT_FORM_TO_RECORD","OR"));			
					
					if(eval("formObj.consent_form_id"+i).type != "hidden")
						eval("formObj.consent_form_id0").focus();
					else
						eval("formObj.consent_form_desc0").focus();
					return false;
				}
			}else{
				atleast_one++;
			}
			//break;
		}
		

	}
	for(var i=0;i<total_recs;i++){
		
		for (var j=i+1;j<total_recs;j++)
		{ 
			if(eval("formObj.consent_form_id"+i) && eval("formObj.consent_form_id"+i).value != "" && eval("formObj.consent_form_id"+j).value != "" && eval("formObj.consent_form_id"+i).value == eval("formObj.consent_form_id"+j).value ){
				//alert('APP-OR0285 Duplicate Consent Form are Not Allowed');
				alert(getMessage("DUPLICATE_CONSENT_FORM_NOT_ALLOWED","OR"));
				eval("formObj.consent_form_desc"+j).select();
				return false;
			}
		}
		

	}
	if (!record)
	{
		//alert('APP-OR0281 Check Atleast One Consent Form to Record');
		
		alert(getMessage("CHECK_ATLEAST_ONE_CONSENT_FORM_TO_RECORD","OR"));
		return false;
	}
	for(var i=0;i<total_recs;i++){
		
		if(eval("formObj.consent_chk"+i)){
			if(eval("formObj.consent_chk"+i).disabled){
				//eval("formObj.consent_chk"+i).checked = false;
				eval("formObj.consent_chk"+i).checked = true;
			}
		}else if(eval(parent.multi_detail.document.getElementById("assign_consent"+i))){
						
		if(eval("formObj.consent_form_id"+i).value != "" && (eval("formObj.consent_form_desc"+i) && eval("formObj.consent_form_desc"+i).disabled )){
				//eval("formObj.consent_form_id"+i).value = "";
			}
		}
	}


	eval(formApply( parent.multi_detail.document.multiple_consent_form,OR_CONTROLLER)) ;
	
	if(result){
		
		if(message.indexOf("....<br>")!=-1)
		{
		alert(message.substring(0,(message.indexOf("....<br>"))));
		}
		else
		{
			alert(message);
		}
//		window.returnValue = "RELOAD";
//		window.close();
		let dialogBody = parent.parent.document.getElementById('dialog-body');
	    dialogBody.contentWindow.returnValue = "RELOAD";
	    
	    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
	    dialogTag.close();  
	}
		
}

var result		 = false ;
var message		 = "" ;
var flag		 = "" ;
var invalidCode	 = "" ;
var global_index = 0 ;

function assignResult(_result, _message, _flag, _code){
	
	result		 = _result ;
	message		 = _message ;
	flag		 = _flag ;
	invalidCode	 = _code ;

}

function clearID(index){
	
	if(eval("document.multiple_consent_form.consent_form_desc"+index).value == "")
		eval("document.multiple_consent_form.consent_form_id"+index).value = "";

}


function consentEntered(index,obj,consent_form_id){

	var confirm_val = true;
	if(obj.type == "checkbox"){
		if(obj.checked == false && consent_form_id != "" && consent_form_id == eval("document.multiple_consent_form.consent_form_id"+index).value)
			//confirm_val = window.confirm("APP-OR0288 Unchecking the Consent Form will Clear the Entered Content");

			confirm_val = window.confirm(getMessage("UNCHECK_CONSENT_FORM_CLEAR_ENTERED_CONSENT","OR"));


	}else{
		if(consent_form_id != "" && consent_form_id != 				eval("document.multiple_consent_form.consent_form_id"+index).value)
		//confirm_val = window.confirm("APP-OR0288 Changing the Consent Form will Clear the Entered Content");
		confirm_val = window.confirm(getMessage("CHANGING_CONSENT_FORM_CLEAR_ENTERED_CONSENT","OR"));

	
	}
	if(!confirm_val){
		if(obj.type == "checkbox")
			obj.checked = true;
		else if (obj.type == "select-one")
		{
			var len = eval("document.multiple_consent_form.consent_form_id"+index).options.length ;
			for(var i=0;i<len;i++)
			{
				if(consent_form_id == eval("document.multiple_consent_form.consent_form_id"+index).options[i].value){
					eval("document.multiple_consent_form.consent_form_id"+index).options[i].selected = true;
					break
				}
			}
			
		}else if (obj.type == "text")
		{
			eval("document.multiple_consent_form.consent_form_desc"+index).value = eval("document.multiple_consent_form.consent_text"+index).value;
		}
		return false;
	}

	return true;
}

