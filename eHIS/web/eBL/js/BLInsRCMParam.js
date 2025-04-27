function changeStatus(obj)
{
	if(obj.checked)
	{
		obj.value = "Y";
	}
	else
	{
		obj.value = "N";
	}
} 

function apply() {	

		var err_mess="";
		
		var frm=BLInsRCMParamDtls.document.forms[0];
		
		if(frm.maxNumOfEncIncl.value!=""&&frm.maxNumOfEncIncl.value<1){

			err_mess="Max Number of Encounters included Can't be less than 1";
		}
		
		if(err_mess==""){
			BLInsRCMParamDtls.document.forms[0].submit();
		}else{
			
			messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err_mess;
		}
		
		
		

}	
function onSuccess()
{	

	BLInsRCMParamDtls.document.location.reload();
	
}

function reset()
{
	BLInsRCMParamDtls.location.href="../../eBL/jsp/BLInsRCMParamDtls.jsp";
}

function checkNumberonBlur(obj){
	if(isNaN(obj.value)){
		alert(getMessage('BL8532','BL'));
		obj.select();
	}
	
}
