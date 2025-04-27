//frames[1] changed as frames[1]in apply for tree structure
//try ctach commented for this only
function create(){
	var cmf=commontoolbarFrame.document.forms[0];
	if(cmf.apply.disabled==true){
      cmf.apply.disabled=false;
    }
	f_query_add_mod.location.href='../../eAM/jsp/MSpecialityLinkFrameInCreateMode.jsp?mode=insert';
}
function checkIsValidForProceed()
  {
     var url = f_query_add_mod.location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
        return true;
    else
        return false;
  }
function apply(){	
	//alert("1");
	var messageFrame = frames[2]; 
	if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 

	var frm=f_query_add_mod.document.forms[0];
	if(frm == null){
		//try{
			var formObj = window.parent.frames[2].frames[1].frames[1].document.forms[0];
		//	alert(formObj);
			if(formObj==null){
				var mesg= getMessage("NO_CHANGE_TO_SAVE","Common");
				window.parent.frames[2].frames[2].document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
				return;
			}
			var mainformObj = window.parent.frames[2].frames[1].frames[0].document.forms[0];
			if(mainformObj == null){
				commontoolbarFrame.location.reload();
			}
			else{
				var fields = new Array (mainformObj.speciality_module);
				var spltymodule_title = getLabel("eAM.SpecialityModule.Label","AM");
				var names = new Array (spltymodule_title);
				
				if(checkFieldsofMst( fields, names, messageFrame)){	
					var speciality_module=formObj.speciality_module.value;
					var arr = formObj.elements;
					var xmlStr=formXMLString(arr);	
					if(xmlStr!="<root></root>"){
						var action="../../servlet/eAM.MSpecialityLinkServlet?speciality_module="+speciality_module;
						var xmlDoc = "";
						var xmlHttp = new XMLHttpRequest();
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST",action,false);
						xmlHttp.send(xmlDoc);
						var retVal = xmlHttp.responseText;
						var mesg = retVal;
						if(parent.frames[2].frames[1].frames[1].document.forms[0].prevnext.value=="14"){
							//window.parent.frames[1].frames[2].document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
							alert(mesg)
						}else{
						window.parent.frames[2].frames[1].frames[1].document.location.reload();
						window.parent.frames[2].frames[2].document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
						}
					}else{
						var mesg= getMessage("NO_CHANGE_TO_SAVE","Common");
						window.parent.frames[2].frames[2].document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
					}
				}
			}
		//}
		//catch(failed){
		//	alert("2");
		//	commontoolbarFrame.location.reload();
		//}
	}
}

function formXMLString(arrObj){
	var xmlString="<root>";
	for(var i=0;i<arrObj.length;i++){
		if(arrObj[i].type=="checkbox" && arrObj[i].db_change=="Y"){
			   xmlString+="<RECORD_"+i+" ";
			   xmlString+="speciality_code=\""+arrObj[i].speciality_code+"\""+" ";
			   xmlString+="select_value=\""+arrObj[i].select_yn+"\""+" />";
		 }
	}
	xmlString+="</root>";
	return xmlString;
}

function onSuccess(){
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eAM/jsp/MSpecialityLinkFrameInCreateMode.jsp?mode=insert';
	else
         f_query_add_mod.location.reload();
}

function reset(){
	var frm=f_query_add_mod.document.forms[0];
	if(f_query_add_mod.location.href.indexOf("MSpecialityLinkQueryResult.jsp")!=-1){
			return false;
	}
	if(frm == null){
		try{
			var formobj = window.parent.frames[2].frames[1].frames[1].document.forms[0];
			var mainformobj = window.parent.frames[2].frames[1].frames[0].document.forms[0];
			if (formobj != null)
				window.parent.frames[2].frames[1].frames[1].location.reload();
			else if(mainformobj != null)
				window.parent.frames[2].frames[1].frames[0].location.reload();
			else
				commontoolbarFrame.location.reload();
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
	if(cmf.apply.disabled==false)
	{
      cmf.apply.disabled=true;
    }
	f_query_add_mod.location.href='../../eAM/jsp/MSpecialityLinkQueryCriteria.jsp';
}
function setCheckValue(){
	if(document.forms[0].status.checked==true)
		document.forms[0].status.value="E";
	else
		document.forms[0].status.value="D";
}
function callDetailForm(){
	var msg11="";
    parent.parent.document.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg11;
	var frmObj=window.parent.frames[1];
	var frm=document.forms[0];
	var speciality_module=frm.speciality_module.value;
	var fields = new Array (frm.speciality_module);
	var splty_module_title = getLabel("eAM.SpecialityModule.Label","AM");
	var names = new Array (splty_module_title);
	var messageFrame= parent.parent.document.messageFrame;    
     
	var search_by=document.forms[0].search_by.value;
	var search_txt=document.forms[0].search_txt.value;
    if(search_txt.indexOf("'")!=-1)
		{			
			search_txt = search_txt.replace("'","''");
		}

	if(checkFieldsofMst( fields, names, messageFrame)){	
		frmObj.location.href="../../eAM/jsp/MSpecialityLinkDetailForm.jsp?speciality_module="+speciality_module+"&search_by="+search_by+"&search_txt="+encodeURIComponent(search_txt);
	} 
	
}
function clearvalues(){
	window.parent.frames[1].location.href="../../eCommon/html/blank.html";
	window.parent.frames[0].document.location.reload();
}
function clearDtl_Frame(){
	window.parent.frames[1].location.href="../../eCommon/html/blank.html";
}
