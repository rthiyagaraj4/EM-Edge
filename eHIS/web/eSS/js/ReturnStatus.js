/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var	function_id	=	"" ;
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;

var show=0;
var menu="";
var group_code		= "";
var group_desc		= "";
var tray_no		= "";
var trn_type = "";

function query(){
	f_query_add_mod.location.href = "../../eSS/jsp/ReturnStatusMain.jsp?function_id="+function_id;
}

function reset() { 
	
	parent.content.f_query_add_mod.qryCriteriaReturnStatus.document.forms[0].reset();
	parent.content.f_query_add_mod.qryResultReturnStatus.location.href="../../eCommon/html/blank.html";
	
}

function showTrayDtl()
{
		
	var from_date   =  document.ReturnStatusQuery.from_date.value ;
	var to_date		=  document.ReturnStatusQuery.to_date.value ;
	var locale		= document.ReturnStatusQuery.p_language_id.value;
	var sys_date	= document.ReturnStatusQuery.p_system_date.value;
	
	   if(locale != "en") {
			from_date = convertDate(from_date, "DMY", locale, "en");
			to_date = convertDate(to_date, "DMY", locale, "en");
			sys_date = convertDate(sys_date, "DMY", locale, "en");
		}
	  
	   if(from_date==""){
		   alert(getMessage("FROM_DATE_NOT_BLANK", "SS"));
		   document.ReturnStatusQuery.from_date.focus();
		   parent.qryResultReturnStatus.location.href="../../eCommon/html/blank.html";
		   return ;
		   }else{
			   if (to_date=="")
			   {
				 document.ReturnStatusQuery.submit();
			   }else if(!isBefore(from_date,to_date,"DMY",'en'.value)) {
				   alert(getMessage("FM_DATE_GR_TO_DATE", "SS"));
				   document.ReturnStatusQuery.from_date.focus();
				   parent.qryResultReturnStatus.location.href="../../eCommon/html/blank.html";
				   return ;
		   
			   }/*else if(!checkDateWithSysDate(from_date,to_date,sys_date)){
				   alert(getMessage("BOTH_DATE_LESS_SYS_DATE", "SS"));
				   document.ReturnStatusQuery.from_date.focus();
				   parent.qryResultReturnStatus.location.href="../../eCommon/html/blank.html";
				   return ;		
			   }*/else{
					document.ReturnStatusQuery.submit(); 
				}
				
		   }

}

async function Modify(obj,finalize_yn)
{
	
	if(finalize_yn== "N"){
		return ;
	}
	
	var doc_type_code		=	obj.cells[11].innerText; 
	var doc_no				=	obj.cells[1].innerText;
	
	var dialogHeight = "80vh" ;
	var dialogWidth	= "80vw" ;

	var dialogTop = "-60px" ;//265
	var center = "1" ;

	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; center: " + center + "; dialogTop :" + dialogTop +"; scroll=no; status=no;" ;
	var arguments = "" ;
	var title="Return Detail";
	var params = "doc_type_code="+doc_type_code.trim()+"&doc_no="+doc_no;
	console.log(doc_type_code);
	console.log(doc_no);
	
	retVal = await window.showModalDialog("../../eSS/jsp/ReturnStatusQueryDetailFrame.jsp?"+params,arguments,features);
	
}

function displaytraydtls(facility_id,doc_type_code,doc_no,group_desc,group_code)
{
	
	var dialogHeight = "70vh" ;
	var dialogWidth	= "97vw" ;

	var dialogTop = "265" ;
	var center = "1" ;

	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; center: " + center + "; dialogTop :" + dialogTop +"; scroll=no; status=no;" ;
	var arguments = "" ;
	var title="Return Detail";
	var params = "doc_type_code="+doc_type_code+"&doc_no="+doc_no+"&facility_id="+facility_id+"&group_desc="+decodeURIComponent(group_desc)+"&group_code="+group_code;
	
	retVal = window.showModalDialog("../../eSS/jsp/ReturnStatusQueryDetailTray.jsp?"+params,arguments,features);
	
	
}

function CloseWindow()
{
//	parent.window.close();
	
    const dialogTag = parent.parent.document.getElementById('dialog_tag');    
    dialogTag.close();   
}



//Tray discrepancy and Return Discrepancy Remarks popup display and hide logic Started
function showPopup(i,count_tray_disc,count_ret_disc,group_code_new,tray_no_new,group_desc_new){
	
	 show=1;
	 menu=document.getElementById("manage_menu");
	 menu.style.visibility="visible";
	
	 if(count_tray_disc>0){
		 document.getElementById("tray_disc").style.fontWeight='bold';
	 }else{
		 document.getElementById("tray_disc").style.fontWeight='normal';
	 }
	 if(count_ret_disc>0){
		 document.getElementById("ret_disc").style.fontWeight='bold';
	 }else{
		 document.getElementById("ret_disc").style.fontWeight='normal';
	 }
	 
	  	
		 group_code			= group_code_new;
		
		 group_desc			 = group_desc_new;
		 tray_no				 = tray_no_new;
		 

		 		var rightedge=document.body.clientWidth-(event.clientX+15);
				var bottomedge=document.body.clientHeight-(event.clientY +15);

				if (rightedge<menu.offsetWidth)
					menu.style.left=document.body.scrollLeft+event.clientX-menu.offsetWidth;
				else
					menu.style.left=document.body.scrollLeft+event.clientX;

				if (bottomedge<menu.offsetHeight)
					menu.style.top=document.body.scrollTop+event.clientY-menu.offsetHeight-15;
				else
					menu.style.top=document.body.scrollTop+event.clientY+15;
				
				 
}

/***************************************************************/
function over(){
	menu=document.getElementById("manage_menu");
	menu.style.backgroundColor="#83AAB4";
	event.target.style.backgroundColor="white";
	event.target.style.color="#83AAB4";
}
/***************************************************************/
/***************************************************************/
function out(){
	menu=document.getElementById("manage_menu");
	menu.style.backgroundColor="#83AAB4";
	event.target.style.backgroundColor="#83AAB4";//#B44664
	event.target.style.color="white";
}
/***************************************************************/
/***************************************************************/
function hidePopup(){
	if(show==0){
		menu=document.getElementById("manage_menu");
		menu.style.visibility="hidden";
		
	}
	show=0;
}
/***************************************************************/

function showWindow(doc_no, doc_type_code, facility_id,count_tray_disc,count_ret_disc){
	
	show = 1;
		
	if(count_tray_disc == 0 || count_ret_disc == 0) {
		document.getElementById("manage_menu").style.visibility="visible";
	} 
	
	if (event.target.style.fontWeight=="bold"){
		document.getElementById("manage_menu").style.visibility="hidden";
		var opt = event.target.value;
		var url = "";

		var dialogHeight ='30' ;
		var dialogWidth = '70' ;
		var dialogTop	= '265';
		var dialogLeft = '124' ;

		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
		var arguments = "";
		
		switch(opt){
			
			case 'T':
				url="../../eSS/jsp/TrayDiscrepancyRemarks.jsp?group_desc="+encodeURIComponent(group_desc,"UTF-8")+"&group_code="+group_code+"&tray_no="+tray_no;
				break;

			case  'R':
				url="../../eSS/jsp/ReturnDiscrepancyRemarks.jsp?group_desc="+encodeURIComponent(group_desc,"UTF-8")+"&group_code="+group_code+"&tray_no="+tray_no+"&doc_no="+doc_no+"&doc_type_code="+doc_type_code+"&facility_id="+facility_id;
				break;
				
		}
		retVal = window.showModalDialog(url,arguments,features);
	}
}
//Tray discrepancy and Return Discrepancy Remarks popup display and hide logic ended

function details(group_code,group_desc)
{
  
	if(group_code!="")
	{
	var dialogHeight = "30" ;
	var dialogWidth	= "40" ;

	var dialogTop = "265" ;
	var center = "1" ;

	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; center: " + center + "; dialogTop :" + dialogTop +"; scroll=yes; status=no;" ;
	
	var arguments = "" ;
	var title="Request Detail";
	var params = "group_code="+group_code+"&group_desc="+group_desc;
	
	retVal = window.showModalDialog("../../eSS/jsp/GroupItemDetails.jsp?"+params,arguments,features);
	}

}

function disablefinalize(){
	if(document.ReturnStatusQuery.entry_completed_yn.value=="N") {
		document.ReturnStatusQuery.finalized_yn.disabled =true;
		document.ReturnStatusQuery.finalized_yn.value ="%";
			}else{
				document.ReturnStatusQuery.finalized_yn.disabled =false;
				}
}

//Added by Sakti against inc#49268 to display remarks description in tooltip
function onMOut(obj) {
	obj.innerHTML = "";
	obj.style.width = 0;
	obj.style.borderColor = "";
	obj.style.borderWidth = "";
	obj.style.borderStyle = "";
}

function onMOver(obj, e, remarks_code,remarks_desc) {

	remarks_desc = decodeURIComponent(remarks_desc,"UTF-8");

	obj.style.left = e.x - 180;
	//obj.style.left = 30; 
	obj.style.top = e.y + 30;
	obj.style.borderColor = "";
	obj.style.borderWidth = "thin";
	obj.style.borderStyle = "groove";
	obj.style.width = 30;
		
	if(remarks_desc !="" ) {
	obj.innerHTML = "<table cellspacing='0' cellpadding='0' border='1' height=100% ><tr><td class='ITEMSELECT' width=300 nowrap align=left><b> " + "Reason Code "+ " :</b>"+  remarks_code+ "</td></tr> <tr><th width=300 nowrap align=center>" + getLabel("Common.description.label", "common") + "</tr></th><tr><td class='OAQRYODD' align='left' >" +  remarks_desc + "</td></tr></table>";
	return;
	} 

}
//Added ends
