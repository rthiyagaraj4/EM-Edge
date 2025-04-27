
var viewId;

function tabClicked(evt) {
	var selectedTabPane = evt.getTabPane();
	viewId = selectedTabPane.id;
}

function create()					    
	{
		var moduleId="LC";
		var functionId="LC_RECEIVE_LINEN_TO_LAUNDRY";
		content.location.href=contextPath+"/eLC/ReceiveLinenAtLaundry/jsp/ReceiveLinenAtLaundryMainFrames.jsp?&functionId="+functionId+"&moduleId="+moduleId;
	}
    	   
function checkNull() {
	var flag;
 	var error="";
 	var fieldName = new Array("com.iba.ehis.lc.receiveLinenAtLaundry.receiptNum", "com.iba.ehis.lc.receiveLinenAtLaundry.receivedDate", "com.iba.ehis.lc.linenItem","com.iba.ehis.lc.receiveLinenAtLaundry.receivedQty","com.iba.ehis.lc.receiveLinenAtLaundry.receivedBy");
	var fields = new Array(document.getElementById("vo.receiptNum"), document.getElementById("vo.receivedDate"), document.getElementById("vo.linenItem"),document.getElementById("vo.receivedQty"),document.getElementById("vo.receivedBy"));
	var key_value=new Array();
	
 	for(j=0;j<fieldName.length;j++)
 	{
 		if(fields[j].value=="")
		{	
	 		getServerMessage(fieldName[j]);
	 		key_value[j]=dwrMessage;
			getServerMessage("message.cannot.blank");
			msg=dwrMessage;
	 		msgArray=msg.split('#');
	 		error=error +msgArray[0]+ key_value[j] + " " + msgArray[1] +"<br>";
	 		flag=false;
 		}
 	}
	parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
	if(flag==false) return false; else return true;
}

//=========  date default===============



function linenItemLookup(){
	var linenItemDesc = document.getElementById("linenItemDesc").value;
	if(linenItemDesc != '')
		showLookup1();
}

function showLookup1() {
	var linenItem=document.getElementById("vo.linenItem");
	
		var linenItemDesc=document.getElementById("linenItemDesc");
		if(linenItem != ''){
		
			var argArray = new Array();
			var namesArray = new Array();
			var valuesArray = new Array(document.getElementById("vo.addedFacilityId").value,document.getElementById("locale").value);
			var datatypesArray = new Array();
			namesArray[0]="facilityId";
			namesArray[1]="languageId";
			argArray[0] = "ehis.lc.standardStock.linenItem"
//			argArray[0] = "ehis.lc.returnofLinenItemtoLaundry.linenItem"
						
			argArray[1] = namesArray;
			argArray[2] = valuesArray;
			argArray[3] = DESC_CODE;
			argArray[4] = DESC_LINK;
			argArray[5]=document.getElementById("linenItemDesc").value;
			
			retArr = Lookup("Linen Item", argArray);
						
			if(retArr!=null){
			
				linenItem.value = retArr[0];
				linenItemDesc.value = retArr[1];
			}
		}
	}
function getReceiptNo(data){
var max=0;
 for(prop in data)
 {
	 if(prop!=null)
	{
	if(parseInt(prop)>parseInt(max))
			max=parseInt(prop);

	}
 }
max=parseInt(max)+1;
document.getElementById("vo.receiptNum").value=max;

}  		


function settime(){
	window.setTimeout(AlertMsg,1000);	
	}

function AlertMsg(){
	var obj=document.getElementById("vo.receiptNum");
	var flag=checkNull();
		if(flag==true){ 
			getServerMessage("com.iba.ehis.lc.pnyrequestNum");
			alert(dwrMessage+" "+" : "+obj.value);
			apply();
		}
	}


function apply() {
			document.ReceiveLinenAtLaundryForm.submit();
	}
function reset()
{
	create();
}

/*function checkNumber1(obj) {
	var val=obj.value;
    if ( trimCheck(val) && isNaN(val) == false && val >=0)
        return true;
    else
        if ( val.length > 0 ) {
            	getServerMessage("message.Numbers.Allowed");
				parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+dwrMessage;
				window.event.keyCode = 27;
				obj.value="";
			return false;
        }
}  */

function checkNumber1(obj) {
	var val=obj.value;
    if ( trimCheck(val) && isNaN(val) == false && val >0)
        return true;
   	else 
		if ( val == 0 ) {
            	getServerMessage("APP-LC00018");
				parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+dwrMessage;
				window.event.keyCode = 27;
				obj.value="";
				return false;
        }else
        if ( val.length > 0 ) {
            	getServerMessage("message.Numbers.Allowed");
				parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+dwrMessage;
				window.event.keyCode = 27;
				obj.value="";
			return false;
        }
}
function textAreaLimit(field, maxlen) {
		if (field.value.length > maxlen + 1){
		field.value = field.value.substring(0, maxlen);
		getServerMessage("APP-LC00015");
		var msg = dwrMessage;
		subMsg = msg.split("#");
		var label =  subMsg[0]+" "+subMsg[1]+" "+maxlen
		parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+label;
		window.event.keyCode = 27;
		}
	}

//========================================================
 function checkAlpha(field){
	 	obj =  String.fromCharCode(window.event.keyCode);
	   	var alphaFilter =/^[a-z_A-Z]+$/;
	   	if (!(alphaFilter.test(obj))) { 
	   		getServerMessage("messages.Alphabet");
		parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+dwrMessage;
	   	window.event.keyCode = 27;
		field.value =""
   		}
   	}  	
