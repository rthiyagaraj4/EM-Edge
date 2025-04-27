function fnSendback(){
	var frm = document.frmCollectionReports;
	var arrObj = frm.elements;
	var retVal = '';
	for(var i=0;i<arrObj.length;i++){
		if(arrObj[i].type == "checkbox")
		{
			if(arrObj[i].checked)
			{
				val = arrObj[i].value;
				if(arrObj[i].name != null && arrObj[i].name != "")
					retVal+= arrObj[i].value+ ":::" ;
			}
        }
	}
	window.returnValue = retVal;
	window.close();
}

function fnClose(){
	window.close();
}
