function rgbToHex(rgb) {
    // Extract the numeric values for r, g, b from the rgb string
    const rgbArray = rgb.match(/\d+/g);
    if (!rgbArray) return null;

    // Convert each RGB component to a two-digit hexadecimal value
    const hexColor = `#${rgbArray.map(num => {
        const hex = parseInt(num).toString(16);
        return hex.length === 1 ? '0' + hex : hex;
    }).join('')}`;

    return hexColor;
}


function apply(){

	var HBColor = rgbToHex(f_query_add_mod.document.getElementById("HB").style.backgroundColor);
    var HCColor = rgbToHex(f_query_add_mod.document.getElementById("HC").style.backgroundColor);
    var HIVColor = rgbToHex(f_query_add_mod.document.getElementById("HIV").style.backgroundColor);
    var MRSAColor = rgbToHex(f_query_add_mod.document.getElementById("MRSA").style.backgroundColor);
    var MDROColor = rgbToHex(f_query_add_mod.document.getElementById("MDRO").style.backgroundColor);

	var concatIDColor = "HB~"+HBColor+"|HC~"+HCColor+"|HIV~"+HIVColor+"|MRSA~"+MRSAColor+"|MDRO~"+MDROColor;
    
	var termSetLists	= "";
	$.each(haadTermsetLists,function(index,value){
		termSetLists	+= value+"~";
	});
	var jsonArguments	= {
							'termSetLists':termSetLists,
							'IDANDCOLORCONCAT':concatIDColor
						  };
	$.ajax({  
		 url:'../../servlet/eMR.HAADcolorcodeServlet',  
		 type: 'post',  
		 data: jsonArguments,
		 dataType: 'json',
		 success: function(data) {
			if(data!=null){
				 if(data.error == ""){
					 alert(getMessage("RECORD_INSERTED","SM"));
					 reset();
				 }else{
					 alert(data.error);
				 }
			}
		 }
	 });
    window.commontoolbarFrame.document.location.reload();
}


function reset(){
	haadTermsetLists			= [];
	f_query_add_mod.location.href	= "../../eMR/jsp/HAADcolorcodeDtls.jsp";
}

function fnShowTermCode(id){

	$("#tr_"+id).show();
	$("#save_"+id).show();
	$("#edit_"+id).hide();
}

function fnSave(id){
	$("#tr_"+id).hide();
	$("#save_"+id).hide();
	$("#edit_"+id).show();
}

async function call_Diagnosis(field,obj,id) { 
	var dialogTop	  = "50";
	var dialogHeight  = "550px" ;
	var dialogWidth   = "950px" ;
	var features    ="dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments   = "" ;

	var diag_code	= document.forms[0].diag_code.value;
	var diag_desc	= document.forms[0].diag_desc.value;
	var term_set	= $("#termSet_"+id).val();
	var params  = "../../eMR/jsp/PaintConsultationFrame.jsp?term_set_id="+term_set+"&p_diag_code="+diag_code+"&p_diag_scheme_desc="+diag_desc;	
	var retVal = await window.showModalDialog(params,arguments,features);
	if (!(retVal == null))
	{
		 var retdata;
		 retdata = retVal.split("/")  ;		 
		 objname=field.name;
		 $.ajax({  
		 url:'../../servlet/eMR.HAADcolorcodeServlet',  
		 type: 'post',  
		 data: {'code_set':term_set,'p_diag_code':retdata[0],'action':'ValidateTermCode'},
		 dataType: 'json',
		 success: function(data) {
			if(data.Count!=null){
				 if(data.Count == 0){
					 alert(getMessage('INVALID_DIAG_CODE','MR'));
					 eval("document.forms[0]."+ objname+".value=''");
				 }else{
					 eval("document.forms[0]."+ objname+".value=retdata[0]");
				 }
			}
		 }
	 });
		 //eval("document.forms[0]."+ objname+".value=retdata[0]");	
    }
}

function fnAdd(id) {
	var termsetDesc			= $("#termSet_"+id+" option:selected").text();
	var termsetId			= $("#termSet_"+id).val();
	var termCode			= $("#termCode_"+id).val();
	var termCodeForId		= termCode.replace(".","-");
	var trId				= id+"_"+termsetId+"_"+termCodeForId;
	var haadId				= termsetId+"$$$"+termCode+"###"+id;
	var chkId				= termsetId+"$$$"+termCode;
	var isExist				= "N";
	var existHaadId			= "";
	$.each(parent.haadTermsetLists,function(index,value){
		var arr				= value.split("###");
		if(arr[0]==chkId){
			isExist			= "Y";
			existHaadId		= arr[1];
		}
	});

	if(termsetId!="" && termCode!=""){
		if(isExist=="N"){
			var contentToAppend		= '';
			contentToAppend			+= '<tr id="'+trId+'">';
			contentToAppend			+= '<td width="18%" align="left" valign="middle" class="row2">'+termsetDesc+'</td>';
			contentToAppend			+= '<td width="77%" align="left" valign="middle" class="row2">'+termCode+'</td>';
			contentToAppend			+= '<td width="5%" align="left" valign="middle" class="row2"><img src="../../eOA/patientportal/Close.png" width="24" height="24"  style="cursor:pointer;" onclick="fnRemoveTr(\''+trId+'\',\''+haadId+'\');" /></td>';
			contentToAppend			+= '</tr>';
			$("#tableList_"+id+" tbody").append(contentToAppend);
			parent.haadTermsetLists.push(haadId);
		}else{
			alert(getMessage("DIAGNOSIS_ALREADY_MAPPED", "MR").replace("$",existHaadId));
		}
		$("#termSet_"+id).val("");
		$("#termCode_"+id).val("");
	}

}

function fnRemoveTr(trId,haadId){
	if (confirm(getMessage("DELETE_RECORD","Common"))){
		$("#"+trId).remove();
		parent.haadTermsetLists.splice($.inArray(haadId, parent.haadTermsetLists),1);
	}
}

