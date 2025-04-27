async function AddressLookup(title, fieldname,fieldvalue,serverlet) { 
    var retVal = new String();
    var dialogHeight= "400px" ;
    var dialogWidth = "700px" ;
	
    var status = "no";
    //var fin_Val=pArgumentArray.split(",");
    var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;
    xmlStr ="<root><SEARCH " ;
    xmlStr +=" /></root>" ;
        if(serverlet==="yes")
		{   
			var dialogUrl       = "../eMP/jsp/AddressLookupMain.jsp?title="+encodeURIComponent(title)+"&fieldname="+fieldname+"&fieldvalue="+encodeURIComponent(fieldvalue);
		}
		else
		{
			
    	var dialogUrl       = "../../eMP/jsp/AddressLookupMain.jsp?title="+encodeURIComponent(title)+"&fieldname="+fieldname+"&fieldvalue="+encodeURIComponent(fieldvalue);
		
		}

		var dialogArguments = "" ;
        var dialogFeatures  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
        
		var returnVal = await window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);		

        if( returnVal == null || returnVal == "" )
            return "";
        else
            return returnVal.split("\"") ;
}


function ReturnValues(pos)
{   
    var code_var="code"+pos;
	var desc_var="desc"+pos;
	var code = document.getElementById(code_var).value;
	var desc = document.getElementById(desc_var).value; 		
	//window.parent.parent.returnValue=code+"::"+desc;;
	//window.parent.parent.close();
	var retVal=code+"::"+desc;
	let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = retVal;
    const dialogTag = parent.parent.document.getElementById("dialog_tag");  
    dialogTag.close(); 
} 
