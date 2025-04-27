// *** Automatically Generated Using Java Program *** //

var messageArray = new Array() ;

// General Messages

/*messageArray["TXT_PRACT_NULL"] = "BT0141 Transfuse Practitioner Name should be Null" ;
messageArray["DATE_ST_NULL"] = "BT0113 Transfuse start date can not be Null" ;
messageArray["DATE_ST_GT_ISSUE"] = "BT0114 Transfuse start date should be greater then ISSUED Date" ;
messageArray["DATE_ST_LT_RESER"] = "BT0115 Transfuse start date should be less then RESERVED Date" ;

messageArray["DATE_EN_NULL"] = "BT0116 Transfuse End date can not be Null";
messageArray["DATE_EN_LT_SYS"] = "BT0117 Transfuse end date should not be greater then SYSTEM Date";
messageArray["DATE_EN_GT_TRANS"] = "BT0118 Transfuse end date should be greater then  Transfuse start date";
messageArray["DATE_EN_LT_RESER"] = "BT0119 Transfuse end date should be less then RESERVED Date";
messageArray["VOLUME_NULL"]="BT0120 Transfused volume should not be Null";
messageArray["VOLUME_LT"]="BT0121 Transfused volume should  be less than Current Volume";
messageArray["PARCT_ID_CURRENT_USER"]="BT0122 Error in Practitioner Selection";
messageArray["REACTION_CODE_NULL"]="BT0131 Reaction code should not be Null";
messageArray["PARTIAL_TRANS_CODE"]="BT0132 Partial Transfusion Reason  should not be Null";

// FM Messages Ends


function getBTMessage( message_ref ) {
    var message = messageArray[message_ref] ;
    if ( message == null ) message = "Message Not Available"  ;
    return message ;
}
*/

function getBTMessage( message_ref, moduleId ) {

  var xmlHttp
		if(navigator.appName.indexOf("Internet") ==-1)
			xmlHttp = new XMLHttpRequest();
		else
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");


		message_ref=message_ref.toUpperCase();
		moduleId = moduleId.toLowerCase()


		var urlString ="?msg_id="+message_ref+"&moduleId="+moduleId

			//alert(urlString);

		xmlHttp.open("POST","../../servlet/eBT.BTMessages"+urlString, false);
		xmlHttp.setRequestHeader("Content-Type","text/html;charset=UTF-8")
		xmlHttp.send();

		var xmlText = xmlHttp.responseText
		
		return(TrimStr(xmlHttp.responseText))
}