
/*
	Developer   : Muraleedhar
	Created On  : 01/10/2009
*/

function create()
{
	f_query_add_mod.location.href='../../eOH/jsp/MFailureRemarksAddModify.jsp?mode=insert';
}

function apply(){								   
	var frm=f_query_add_mod.document.forms[0];
	if(frm == null){
		commontoolbarFrame.location.reload();
	}
	else if(frm != null){
		var fields = new Array (f_query_add_mod.document.forms[0].reason_code,f_query_add_mod.document.forms[0].reason_desc);
		var code_title=getLabel("eOH.ReasonCode.Label","OH");
		var description_title = getLabel("eOH.ReasonDescription.Label","OH");

		var names = new Array (code_title,description_title);

		if(checkFieldsofMst( fields, names, messageFrame)){	
			var fields1 = new Array (f_query_add_mod.document.forms[0].reason_code);
			var names1 = new Array ( code_title);
			var error_page = "../../eCommon/jsp/MstCodeError.jsp";	

			if (f_query_add_mod.SpecialCharCheck123(fields1,names1,messageFrame,"M",error_page)){
				//f_query_add_mod.document.forms[0].submit();
				var formObj = f_query_add_mod.document.forms[0];
				var row_count = formObj.row_count.value;
				var mode = formObj.mode.value;
				var chk_count = 0;
				for(i = 1;i<=row_count;i++){
					if(eval("formObj.chk_"+i).checked == true){
						eval("formObj.chk_"+i).value = "Y";
						chk_count++;
					}else{
						eval("formObj.chk_"+i).value = "N";
					}
				}
				if(chk_count=="0"){
					var err_msg = getMessage("APP-OH00065","OH");
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+err_msg;
					return;
				}

				if(chk_count!="0"){
					if(chkDuplicateReasonCode()){
						f_query_add_mod.document.forms[0].submit();
					}
				}
			}
		}
			
	}
}

function assignValue(obj,row){
	var formObj = document.forms[0];
	if(obj.checked==true)
		obj.value="Y";	
	else
		obj.value = "N";
}

function onSuccess(){
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eOH/jsp/MFailureRemarksAddModify.jsp?mode=insert';
	else
        f_query_add_mod.location.reload();
}

function reset(){
    //f_query_add_mod.location.reload();

	/* Added by Sridevi Joshi on 6/9/2010 for IN021926*/
	if(f_query_add_mod.document.location.href.indexOf("MFailureRemarksQueryResult.jsp") != -1){
		  return false;
	}
	else{
		 f_query_add_mod.document.location.reload();
	}
}

function query(){
	commontoolbarFrame.document.forms[0].apply.disabled=true;
	f_query_add_mod.location.href='../../eOH/jsp/MFailureRemarksQueryCriteria.jsp';
}

function setCheckValue(){
	if(document.forms[0].eff_status.checked==true)
		document.forms[0].eff_status.value="E";
	else
		document.forms[0].eff_status.value="D";
}


function ChkMaxchar(size){
	var reason_desc=document.forms[0].reason_desc.value;
	if((reason_desc).length > size){
			alert(getMessage("APP-OH00014",'OH'));
			document.forms[0].reason_desc.value=reason_desc.substring(0,size-1);
		}
}

function chkDuplicateReasonCode(){
	var reason_code=f_query_add_mod.document.forms[0].reason_code.value;
	var mode=f_query_add_mod.document.forms[0].mode.value;
	if(mode != "modify"){//Added by Sridevi Joshi on 5/11/2010 for IN021292
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "reason_code="+reason_code;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?func_mode=chkDupReasonCode&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = localTrimString(xmlHttp.responseText);
		if(retVal=="X"){
			var err_msg = getMessage("CODE_ALREADY_EXISTS","common");
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+err_msg;
			return false;
		}else{
			return true;
		}
	}
	return true;
}

function localTrimString(sInString) {
  return sInString.replace(/^\s+|\s+$/g,"");
}

function SpecialCharCheck123( fields, names, messageFrame,disp_type,error_jsp) {
        var errors = "" ;
        for( var i=0; i<fields.length; i++ ) {
            if(CheckChars(fields[i])) {
            }
            else{
                if (disp_type=="A")errors += "APP-000014 Reason Code OR Description Should Not have Special Characters";
                else if(disp_type=="M")errors += "APP-000014 Reason Code OR Description Should Not have Special Characters";
            }
        }
        if ( errors.length != 0 ) {
            var loc_route = error_jsp+"?err_num="+errors;
            if (disp_type=="M")messageFrame.document.location.href=loc_route;
            else if (disp_type=="A")alert(errors);
            return false ;
        }
        return true ;
    }
function CheckChars(Obj){
        var str = Obj.value;
        var specCharsExist = true;
        for (u=0;u<str.length;u++){
            if (((str.charCodeAt(u)>=48) && (str.charCodeAt(u)<=57))||((str.charCodeAt(u)>=65) && (str.charCodeAt(u)<=90))||((str.charCodeAt(u)>=97) && (str.charCodeAt(u)<=122))||(str.charCodeAt(u)==95)||(str.charCodeAt(u)==42));
            else{
                specCharsExist = false;
                break;
            }
        }
        return specCharsExist;
    }
