var login_resp_flag=false;
var login_fac_flag=false;

//-----mz changes start--------------
function getComputerName()
{
  	if(navigator.appName.indexOf("Internet") ==-1)
	{	
  	 var evt = document.createEvent("Events");
  	 evt.initEvent("MyExtensionEvent", true, false);
 	//element.dispatchEvent(evt);
 	 document.getElementById("compname").dispatchEvent(evt);
        	 if(document.getElementById("compname").value == "")
		{
 			 window.location = "computerdetails.xpi"
  		
 

		}
         alert("your computer name is " + document.getElementById("compname").value);
	}
}
//------mz changes end---------------
function check_user_password_event(e){
    //  alert("hitt");
	var level =document.forms[0].level.value; //Mz changes
	document.getElementById("errMSGID0").style.display="None"; //mz changes
	if(e.keyCode==13||e.keyCode==32)
		var key = new Array(13,32);
	if(key!=null){
		for(var i=0;i<key.length;i++){
			if(e.keyCode==key[i]){
				if(level=="1"){
					check_user_password(e); //mz changes --pwd
					//mz changes return event.returnValue=false;

                                      //----- mz changes code modified--------
                                     	 if (e.preventDefault) 
					{

						return e.preventDefault();
					}
					else 
					{
						return e.returnValue = false;
					}
                                      //------mz changes code modified end--------
                                       
				}else{
					loginAppl();
				}
				break;
			}
		}
	}
}
function login_enter_event(e){
       //alert(e.keyCode);
	if(e.keyCode==13 || e.keyCode==32){
		check_user_password(e); //mz changes--pwd

	}else{
		var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_';
		//--Mz changes commented-----var whichCode = (window.Event) ? window.event.which : window.event.keyCode;
               var whichCode = (window.Event) ? e.which : e.keyCode; //------Mz changes added-----

		key = String.fromCharCode(whichCode);  // Get key value from key code
               //alert(key);
		if (strCheck.indexOf(key) == -1){
                    
			//mz changes--return event.returnValue=false;
                //------mz changes modified---------
//alert(e.preventDefault);
		if (e.preventDefault) {
                      if(e.keyCode != 8 && e.keyCode != 9)
			return e.preventDefault();
                       //return false;
		} else {
			return e.returnValue = false;
                        }

                //-----mz changes modified end-------
        
                    

		}else{
			return true ;
		}
	}
}

function check_password_event(e){
	if(e.keyCode==13){
		ChangeUpperCase(document.forms[0].password); //mz changes
		check_user_password(e); // mz changes -pwd
	}
}
function cancelbutton_event(e){
	if(e.keyCode==13||e.keyCode==32)
		var key = new Array(13,32);
	if(key!=null){
		for(var i=0;i<key.length;i++){
			if(e.keyCode==key[i]){
				cancelbutton();
				break;
			}
		}
	}
}
function loginAppl_resp_event(e){
	document.getElementById("errMSGID").innerHTML=""; // mz changes
	document.getElementById("errMSGID0").style.display="None"; // mz changes
	if(event.keyCode==13){
		if((document.forms[0].responsibility_id.value!=null && document.forms[0].responsibility_id.value!="") && (document.forms[0].facility_id.value!=null && document.forms[0].facility_id.value!="")){ //mz changes
			if(login_resp_flag){
				loginAppl();
			}else{
				login_resp_flag=true;
			}
		}else{
			if(document.forms[0].responsibility_id.value=="" && document.forms[0].facility_id.value==""){ //mz changes
				document.getElementById("errMSGID0").style.display=""; //mz changes
				document.getElementById("errMSGID").innerHTML=getMessage("INAVLID_RESP_FACILITY","Common"); //mz changes
			}else if(document.forms[0].responsibility_id.value==""){ // mz changes
				document.getElementById("errMSGID0").style.display=""; //mz changes
				document.getElementById("errMSGID").innerHTML=getMessage("INAVLID_RESPONSIBILITY","Common"); //mz changes
				login_resp_flag=false;
			}else{
				document.getElementById("errMSGID0").style.display=""; //mz changes
				document.getElementById("errMSGID").innerHTML=getMessage("INAVLID_FACILITY","Common"); //mz changes
				login_fac_flag=false;
			}
		}
	}else{
		login_resp_flag=false;
	}
}
function loginAppl_fac_event(e){
	document.getElementById("errMSGID").innerHTML=""; // mz changes
	document.getElementById("errMSGID0").style.display="None"; // mz changes
	if(event.keyCode==13){
		if((document.forms[0].responsibility_id.value!=null && document.forms[0].responsibility_id.value!="") && (document.forms[0].facility_id.value!=null && document.forms[0].facility_id.value!="")){ // mz changes
			if(login_fac_flag){
				loginAppl();
			}else{
				login_fac_flag=true;
			}
		}else{
			if(document.forms[0].responsibility_id.value=="" && document.forms[0].facility_id.value==""){ // mz changes
				document.getElementById("errMSGID0").style.display=""; // mz changes
				document.getElementById("errMSGID").innerHTML=getMessage("INAVLID_RESP_FACILITY","Common"); // mz changes
			}else if(document.login_form.responsibility_id.value==""){
				document.getElementById("errMSGID0").style.display=""; //mz changes
				document.getElementById("errMSGID").innerHTML=getMessage("INAVLID_RESPONSIBILITY","Common"); // mz changes
				login_fac_flag=false;
			}else{
				document.getElementById("errMSGID0").style.display=""; //mz changes
				document.getElementById("errMSGID").innerHTML=getMessage("INAVLID_FACILITY","Common"); // mz changes
				login_fac_flag=false;
			}
		}
	}else{
		login_fac_flag=false;
	}
}
function backtoLogin_event(e){
	if(e.keyCode==13||e.keyCode==32)
		var key = new Array(13,32);
	if(key!=null){
		for(var i=0;i<key.length;i++){
			if(e.keyCode==key[i]){
				backtoLogin();
				break;
			}
		}
	}
}
function buttonOver( button ) {
	button.style.background="white" ;
	button.style.color="navy" ;
	button.style.fontWeight="700" ;
	button.style.borderStyle="solid" ;
}
function buttonOut( button ) {
	button.style.background="navy" ;
	button.style.color="yellow" ;
	button.style.fontWeight="700" ;
	button.style.borderStyle="solid" ;
}
function changeFacility( listvalue ) {
	var lists 	= listvalue.split( "|" ) ;
	var id 	= lists[0] ;
	var name 	= lists[1] ;
	document.forms[0].facility_id.value = id ; //mz changes
	document.forms[0].facility_name.value = name ; // mz changes
	return true ;
}

function changeResponsibility( listvalue ) {
	var lists 	= listvalue.split( "|" ) ;
	var id 	= lists[0] ;
	var name 	= lists[1] ;

	document.forms[0].responsibility_id.value = id ; // mz changes
	document.forms[0].responsibility_name.value = name ; // mz changes
	return true ;
}
function check_user_password(e){ // mz changes -- pwd


	//---Mzchanges commented------if(document.forms[0].level.value=="1"){ 
              if(document.forms[0].level.value=="1"){ // Mz changes 
	//---Mzchanges commented------	if (login_form.compname.value == null || login_form.compname.value == ''){
           // alert(document.forms[0].compname.value) ;
//document.forms[0].compname.value = "";
              if (document.forms[0].compname.value == null || document.forms[0].compname.value == ''){  //--------Mz changes     
			alert('Activex properties not enabled, cannot proceed...');
			document.forms[0].name.focus(); //Mz changed
			return false;
		}
		if(document.forms[0].name.value==''){ //MZ changes
			alert('APP-SM0019 User Id/Password Cannot be Blank');
			document.forms[0].name.focus(); // Mz changed
			// mz changes return event.returnValue=false;
                       //--mz code modified---------------
                                       if (e.preventDefault) 
					{

						return e.preventDefault();
					}
					else 
					{
						return e.returnValue = false;
					}                       
                      //----mz code modified end----------
		}else{
			if(document.forms[0].password.value==''){ //Mz changes
				alert('APP-SM0007 Password Should be Entered');
				document.forms[0].password.focus(); //Mz changed
				//mz changes return event.returnValue=false;
                       //---mz code modified-----------
					if (e.preventDefault) 
					{

						return e.preventDefault();
					}
					else 
					{
						return e.returnValue = false;
					}
                       //----mz end-------------------
			}else{
				submit_user_pwd();
				//login_form.submit();
			}
		}
	}else if(document.forms[0].level.value=="2"){ // mz changed
		loginAppl();
	}
}
function checkvisible(){

        /*-----Mz changes commented-------------
	document.getElementById("errMSGID").innerHTML="";
	document.getElementById("errMSGID0").style.display="None";
------------mz changes end comment-----------*/

//----------mz changes modified code-----------
        document.getElementById("errMSGID").innerHTML="";
	document.getElementById("errMSGID0").style.display="None";

//---------mz changes end----------------------

}
	
function MyAddress(data) {

	var hostIP;

	var index = data.indexOf("&");
	hostName = data.substr(0,index);
	hostIP = data.substr(index+1,data.length);

	document.getElementById("clientIP").value = hostIP;
} 
function cancelbutton(){
	if(document.forms[0].level.value=='1'){//mz changes
		document.getElementById("errMSGID0").style.display="None"; //mz changes
		document.forms[0].name.value="";//mz changes
		document.forms[0].password.value="";//mz changes
		document.forms[0].name.focus();//mz changes
	}else if(document.forms[0].level.value=='2'){//mz changes
		backtoLogin();
	}
}
function change_resp(obj,respName){
	
	document.getElementById("responsibility_id").value=obj;
	document.getElementById("responsibility_name").value=respName;
	var tdFac =  document.getElementById("tdFac");
	if(tdFac){
		tdFac.innerHTML = "";
	}
	// here comes the code which will validate
	// the responsibility id selected by the user
	xmlStr	="<root><SEARCH " ;
	xmlStr += " resp_ID=\"" + obj + "\"";
	xmlStr +=" /></root>" ;
	var xmlHttpObj;
	if (navigator.appName.indexOf("Internet") == -1) {
		xmlHttpObj = new XMLHttpRequest();
		var oParser = new DOMParser();
		xmlDoc = oParser.parseFromString(xmlStr, "text/xml");
	} else {
		xmlHttpObj = new ActiveXObject("Microsoft.XMLHTTP");
		xmlDoc = new ActiveXObject("Microsoft.XMLDom");
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	}  
	
	xmlHttpObj.onreadystatechange=function(){
		//alert(xmlHttp2.readyState+' '+xmlHttp2.status);
		if(xmlHttpObj.readyState==4 && xmlHttpObj.status==200){
			var respText = xmlHttpObj.responseText;
			
			if(respText.length > 0){
				var respNum = parseInt(respText);
				if(respNum <= 0){
					alert("You do not have sufficient rights to Login");
					
				}else{
					calculateResponsibility(obj);
				}
			}
			else{
				alert('Could not validate the responsibility selected by the user');
				
			}
		}
	}
	
	xmlHttpObj.open("POST", "../jsp/Login-Validate.jsp", true);
	xmlHttpObj.send(xmlDoc);

			
}
function showfacility(facID,facName){
	
	document.getElementById("facility_id").value=facID;
	document.getElementById("facility_name").value=facName; 	
	
}
function clearAll() {
	document.getElementById("name").value = "";
	document.getElementById("password").value = "";
}
function failedlogin(){
	
	clearAll();
	logOff();
	window.location.href="../html/loginIpad.html";
	
	
}
 function logOff()
   {
	   var 	xmlHttpObj;
	   if (navigator.appName.indexOf("Internet") == -1) {
			xmlHttpObj = new XMLHttpRequest();
			//var oParser = new DOMParser();
			//xmlDoc = oParser.parseFromString(xmlStr, "text/xml");
		} else {
			xmlHttpObj = new ActiveXObject("Microsoft.XMLHTTP");
			//xmlDoc = new ActiveXObject("Microsoft.XMLDom");
			//xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		}  
		
	   xmlHttpObj.open("POST", "../jsp/Logoff.jsp", true);
	   xmlHttpObj.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	   var sendString = "logoff=true";
	   xmlHttpObj.send(sendString);
   }
function calculateResponsibility(obj){
	
	xmlStr	="<root><SEARCH " ;
	xmlStr += " resp_ID=\"" + obj + "\"";
	xmlStr +=" /></root>" ;
	
	var xmlHttp;
	if (navigator.appName.indexOf("Internet") == -1) {
		xmlHttp = new XMLHttpRequest();
		var oParser = new DOMParser();
		xmlDoc = oParser.parseFromString(xmlStr, "text/xml");
	} else {

		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		xmlDoc = new ActiveXObject("Microsoft.XMLDom");
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	}  
	
	xmlHttp.open( "POST","../../eSM/jsp/FacilitySelect.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	addfacility(responseText,obj);
	
}
function trim(myString)
{
 return myString.replace(/^\s+|\s+$/g, ''); 
}
function addfacility(valueText,respId){
		
	if(valueText.length == 0){
		alert('Facility could not be obtained for the Responsibility '+respId);
		return false;
	}
	
	var facCount = 0;
	var facResult = valueText.split("^");
	var facResultStr = facResult[0];
	var facCntStr = facResult[1];
	facCount = parseInt(facCntStr);
	
	
	var facilities = facResultStr.split("$");
	var facilitiesLen = facilities.length;
	var facilityAppend = "";
	
		var tdFac =  document.getElementById("tdFac");
		for (var i=0; i<facCount; i++){
				var	fac;
				
				fac=(facilities[i]).split("~");
				var facID=trim(fac[0]);
				var facName=trim(fac[1]);
				
				//alert(facID);
				//var facilityAppend = '<table width="100%" border="0" cellpadding="0" cellspacing="0" class="itemborder"><tr><td align="left" valign="middle" class="radiocontent"><input type="radio" name="facradio" id="facradio" id="facradio'+i+'" value="'+facID+'" onclick = showfacility(\'' + facID + '\', \'' + facName + '\')>' + facName + '</td></tr></table>';
				
				 facilityAppend =  facilityAppend + '<table width="100%" border="0" cellpadding="0" cellspacing="0" class="itemborder"><tr><td align="left" valign="middle" class="radiocontent"><input type="radio" name="facradio" id="facradio" value="radio" onclick ="showfacility(\'' +facID+ '\',\'' +facName+ '\');">' + facName + '</td></tr></table>';
				
				//tdFac.innerHTML = tdFac.innerHTML + facilityAppend ;
				
				
				//document.login_form.level.value="3";
				login_fac_flag=true;
			}
		tdFac.innerHTML = facilityAppend ;
		//alert(tdFac.innerHTML);
		
			
	}

function loginAppl(){

//----------Mz changes modified code start---------------------
      //  document.getElementById("errMSGID").innerHTML="";
	if((document.forms[0].responsibility_id.value!=null && document.forms[0].responsibility_id.value!="") && (document.forms[0].facility_id.value!=null && document.forms[0].facility_id.value!="")){
		document.forms[0].level.value=3;
		//document.forms[0].submit();	
		//var xmlDoc="";
		//var xmlHttp = new XMLHttpRequest();
		//alert(document.forms[0].facility_id.value);
		xmlStr	="<root><SEARCH " ;
		xmlStr += " name=\"" + document.forms[0].name.value + "\""	;
		xmlStr += " level=\"" + document.forms[0].level.value + "\"";
		xmlStr += " mode=\"" + document.forms[0].mode.value + "\"";
		xmlStr += " responsibility_id=\"" +encodeURIComponent(document.forms[0].responsibility_id.value)+ "\"";
		xmlStr += " responsibility_name=\"" +encodeURIComponent(document.forms[0].responsibility_name.value)+ "\"";
		xmlStr += " facility_id=\"" +encodeURIComponent(document.forms[0].facility_id.value)+ "\"";
		xmlStr += " facility_name=\"" +encodeURIComponent(document.forms[0].facility_name.value)+ "\"";
		xmlStr += " compname=\"" +document.forms[0].compname.value+ "\"";
		xmlStr += " domain=\"" +document.forms[0].domain.value+ "\"";
		xmlStr +=" /></root>" ;
               // alert(xmlStr);
                var xmlDoc;
       		 var xmlHttp;
        	 if(navigator.appName.indexOf("Internet") ==-1)	
        	 {	
	    	  xmlHttp = new XMLHttpRequest();
            	  var oParser = new DOMParser();
             	  xmlDoc = oParser.parseFromString(xmlStr, "text/xml"); 

       		 }		
        	else
        	{

        	 xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
        	 xmlDoc	= new ActiveXObject( "Microsoft.XMLDom" ) ;
        	 xmlDoc.loadXML( xmlStr );
         
        	}   
                
		//xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
        
		xmlHttp.open( "POST","../../servlet/eSM.LoginResponseServlet", false ) ;
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		//alert(responseText);
		//responseText = trimString(responseText);
		loginApplication(responseText);	
	}


//----------Mz changes end of modified code--------------------
}
function loginApplication(flagval){

document.getElementById("login_form").submit();

}
function backtoLogin(){ 
	document.getElementById("errMSGID").innerHTML=""; // mz changes
	document.getElementById("displayUserID").style.display="none";// mz changes
	//document.getElementById("errMSGID").innerHTML="none";
	document.getElementById("errMSGID0").style.display="none"; //mz changes
	document.getElementById("userNameID").innerHTML=getLabel("Common.username.label","Common"); // mz changes
	document.getElementById("userNameTextID").innerHTML='<input name="name" id="name" type="text" size="30" maxlength="30" class="textbox" onKeyPress="checkvisible();return CheckForSpecChars(event);checkuser_event(event)" onblur="checkvisible()" tabIndex="1"/>';
	document.getElementById("passwordID").innerHTML=getLabel("Common.password.label","Common");
	document.getElementById("passwordTextID").style.display="";
	document.getElementById("passwordTextID").innerHTML='<input name="password" id="password" type="password" size="32" maxlength="30" class="textbox" onBlur="ChangeUpperCase(this);" onkeypress="check_user_password_event(event)" tabIndex="2"/>';
	document.forms[0].level.value="1"; // mz changes
	document.getElementById("name").focus();
	document.getElementById("loginID").disabled=false;
	document.getElementById("loginID").innerHTML=getLabel("Common.login.label","Common");
	login_resp_flag=false;
	login_fac_flag=false;
	document.getElementById("name").focus();
}
function selectfacility(obj){
	if(obj.getSelectedValue()!=null){
		changeFacility(obj.getSelectedValue());		
	}else{
		document.forms[0].facility_id.value=""; // mz changes
		document.forms[0].facility_name.value=""; // mz changes
		//document.getElementById("errMSGID0").style.display="";
		//document.getElementById("errMSGID").innerHTML=getMessage("INAVLID_FACILITY","Common");
		login_fac_flag=false;
	}
}
function loadResp(){
	document.forms[0].loginresponsibility.focus(); //mz changes
}
function CheckSpecialChar(obj){
	var fieldval = obj.value;
	var fieldlen = fieldval.length;
	var to_check = true;
	var SpChar = new Array();
	SpChar[0] = '~';
	SpChar[1] = '`';
	SpChar[2] = '!';
	SpChar[3] = '@';
	SpChar[4] = '#';
	SpChar[5] = '$';
	SpChar[6] = '%';
	SpChar[7] = '^';
	SpChar[8] = '&';
	SpChar[9] = '*';
	SpChar[10] = '(';
	SpChar[11] = ')';
	SpChar[12] = '-';
	SpChar[13] = '+';
	SpChar[14] = '=';
	SpChar[15] = '|';
	SpChar[16] = '\\';
	SpChar[17] = '[';
	SpChar[18] = ']';
	SpChar[19] = '{';
	SpChar[20] = '}';
	SpChar[21] = ':';
	SpChar[22] = ';';
	SpChar[23] = '"';
	SpChar[24] = '<';
	SpChar[25] = '>';
	SpChar[26] = '?';
	SpChar[27] = '/';
	SpChar[28] = '\'';
	SpChar[29] = '';
	SpChar[30] = ',';
	SpChar[31] = '.';
	if (fieldval.substr(0,1) == '_' ) 
	{
		to_check = false;
	}
	for (var i=0;i<fieldlen;i++){
		if (fieldval.substr(i,1) == ' ' || fieldval.substr(i,1) == null){
			to_check = false;
		}
		for (var j=0;j<=31;j++){
			if (fieldval.substr(i,1) == SpChar[j]){
				to_check = false;
			}
		}
	}
	if (to_check == false){
		alert('APP-SM0069 Special Characters are not allowed');
		obj.select();
		obj.focus();
		obj.value='';
	}
}
function lockKey(){
	if(event.keyCode == 93)
		alert('APP-000031 eHIS');
}
function CodeArrest() {
    if((window.event.button == 2) || (window.event.button == 3) || (window.event.button == 4)) {
        alert('APP-000031 eHIS');
    }
}
function CheckForSpecChars(event){
       
	//alert(event.keyCode);
	if(event.keyCode==13){
		checkuser_event(event);
	}else{
		var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_';
		var whichCode = (window.Event) ? event.which : event.keyCode;
              // alert(whichCode)
              // alert(String.fromCharCode(whichCode));
		key = String.fromCharCode(whichCode);  // Get key value from key code
              //  alert(key);  
              ////  alert(strCheck.indexOf(key))
              // alert(event.keyCode)
		if (strCheck.indexOf(key) == -1 && event.keyCode != 8 && event.keyCode != 9) return false;  // Not a valid key
               // var obj = null;
               //obj.type = "hi";
               
               // document.forms[0].name.value=document.forms[0].name.value.toUpperCase(); //mz changes
		//mz changes if( (event.keyCode >= 97) && (event.keyCode <= 122) )                
		//mz changes return (event.keyCode -= 32);
               
		return true ;
	}



}
function checkuser_event(event){

	if(event.keyCode==13){
		if(document.forms[0].password.value!=''){ // mz changes
			check_user_password(event); // mz changes --pwd
		}else{
			document.forms[0].password.focus(); //mz changes
		}

	}
}


function submit_user_pwd() {
	
	xmlStr = "<root><SEARCH ";
	xmlStr += " name=\"" + document.forms[0].name.value + "\"";
	xmlStr += " password=\"" + document.forms[0].password.value + "\"";
	xmlStr += " level=\"" + document.forms[0].level.value + "\"";
	xmlStr += " mode=\"" + document.forms[0].mode.value + "\"";
	xmlStr += " compname=\"" + document.forms[0].compname.value + "\"";
	xmlStr += " domain=\"" + document.forms[0].domain.value + "\"";
	xmlStr += " /></root>";
	//alert(xmlStr);
	var xmlDoc;
	var xmlHttp;
	if (navigator.appName.indexOf("Internet") == -1) {
		xmlHttp = new XMLHttpRequest();
		var oParser = new DOMParser();
		xmlDoc = oParser.parseFromString(xmlStr, "text/xml");

	} else {

		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		xmlDoc = new ActiveXObject("Microsoft.XMLDom");
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	}


	xmlHttp.open("POST", "../../servlet/eSM.LoginResponseServlet", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	//alert(responseText);
        var rText = "";
        rText = responseText; 
       // alert('rtext value='+rText+':');
        if(rText != null)
          rText = rText.replace(/^\s+|\s+$/g,'')

	if (responseText != null && rText != "home.jsp" ) {             
		var result = responseText.split("||");
		var result0 = result[0];
		var result1 = result[1];
		var result2 = result[2];
		
		if (result0 == "error_num=1") {
			var result1plt = result2.split("=");
			alert(result1plt[1]);
		} else {
			
			var colval = result2.split("==");
			var respval = colval[0].split("$$");
			var respcount = respval[0];
			var respCode_desc = respval[1];
			var classvalue;
			var facresult = colval[1];
			var facilityval = facresult.split("$$");
			var facCount = facilityval[0];
			var facCode_desc = facilityval[1];
			var blogin = false;

			if (respcount == "1" && facCount == "1") { // checks whether the
														// user has only one
														// responsibity ID and
														// facilityID
				var responsibilities = respCode_desc.split("~");
				var facilities = facCode_desc.split("~");
				var respID = responsibilities[0];
				var respName = responsibilities[1];
				var facID = facilities[0];
				var facName = facilities[1];
				document.getElementById("responsibility_id").value = respID;
				document.getElementById("responsibility_name").value = respName;
				document.getElementById("facility_id").value = facID;
				document.getElementById("facility_name").value = facName;
				loginAppl();
			} else { // IF there are morethan one responsibilityID
			}

			var responsibilities = respCode_desc.split("^^");
			var resp;
			var td = document.getElementById("tdRes");
			for ( var i = 0; i < respcount; i++) { // checks whether the user
													// has 'Clinical access' as
													// his responsibility ID.
				resp = (responsibilities[i]).split("~");
				var respID = trim(resp[0]);
				var respName = trim(resp[1]);
				var sbAppend = '<table width="100%" border="0" cellpadding="0" cellspacing="0" class="itemborder"><tr><td align="left" valign="middle" class="radiocontent"><input type="radio" name="respradio" id="respradio"  id="respRadio'+ i+ '" value="radio" onclick="change_resp(\''+ respID+ '\',\''+ respName+ '\');">' + respName + '</td></tr></table>';
				td.innerHTML = td.innerHTML + sbAppend;
				//alert(td.innerHTML);
				//document.forms[0].level.value="3";
			}
			
			var loginFrame = document.getElementById('loginFrame');
			if (loginFrame) {
				loginFrame.style.display = 'none';
			}

			var accessFrame = document.getElementById('AccessFrame');
			if (accessFrame) {
				accessFrame.style.display = 'block';
				var accessFrame1 = document.getElementById('AccessFrame1');
				if (accessFrame1) {
					accessFrame1.style.display = 'block';
				}
			}

		}
                //alert($("#tdRes").height());
                var tdHeight = $("#tdRes").height() + "px";
               // alert(tdHeight);
               // document.getElementById("tdFac").innerHTML = "&nbsp;"

		document.getElementById("tdFac").style.height = tdHeight;
               // $("#tdFac").css('min-height',tdHeight);
               // alert(document.getElementById("tbFac").style.height);$("#notesContentFrame").css('height', dvheight);
	}//end if 
	else
		{
		loginApplication("home.jsp");
		}

}

function addResposibility(valueText){   
	if(valueText=='home.jsp'){
		loginApplication(valueText);
	}else{
		document.getElementById("errMSGID").innerHTML="";
		document.getElementById("loginID").disabled=false;
		document.getElementById("cancelID").disabled=false;
		var result=valueText.split("||");
		var result0=result[0];
		var result1=result[1];
		var result2=result[2];		
		if(result0=="error_num=1"){
			document.getElementById("errMSGID0").style.display="";
			var result1plt=result2.split("=");			
			document.getElementById("errMSGID").innerHTML=result1plt[1];
			var name1=document.forms[0].name.value;
			document.forms[0].level.value=='1';
			document.forms[0].name.focus();
		}else{
			var colval = result2.split("==");
			var respval=colval[0].split("$$");
			var respcount=respval[0];
			var respCode_desc=respval[1];
			var classvalue;
			var facresult=colval[1];
			var facilityval=facresult.split("$$");
			var facCount=facilityval[0];
			var facCode_desc=facilityval[1];
			var respString="<select class='select' name=\"loginresponsibility\" tabIndex=\"1\" id=\"loginresponsibility\" onchange=\"change_resp(this)\" onkeypress=\"loginAppl_resp_event(this)\" onblur=\"responsibility_blur(loginresponsibility)\">"; 
			if(respcount=="1" && facCount=="1"){
					var responsibilities=respCode_desc.split("~");
					var facilities=facCode_desc.split("~");
					var respID=responsibilities[0];
					var respName=responsibilities[1];
					var facID=facilities[0];
					var facName=facilities[1];
					document.forms[0].responsibility_id.value=respID;
					document.forms[0].responsibility_name.value=respName;
					document.forms[0].facility_id.value=facID;
					document.forms[0].facility_name.value=facName;
					loginAppl();
			}else{
			if(respcount > 0){
				login_resp_flag=true;
				document.getElementById("displayUserID").style.display="";
				document.getElementById("displayUserID").innerHTML=result1;
				var responsibilities=respCode_desc.split("^^");
				var	resp;
				for (var i=0; i<respcount; i++){
					resp=(responsibilities[i]).split("~");
					var respID=resp[0];
					var respName=resp[1];
					if(i==0){
						document.forms[0].responsibility_id.value=respID;
						document.forms[0].responsibility_name.value=respName;
						respString +="<option value="+respID+" selected>"+respName+"</option>";
					}else{
						respString +="<option value="+respID+">"+respName+"</option>";
					}
				}
				respString +="</select>";
				
					///document.getElementById("userNameID").innerHTML=getLabel("Common.responsibility.label","Common");
					document.getElementById("userNameTextID").innerHTML=respString;
					//eval("var loginresponsibility=dhtmlXComboFromSelect(\"loginresponsibility\");loginresponsibility.enableFilteringMode(true);loginresponsibility.enableOptionAutoPositioning(true);dhtmlxEvent(loginresponsibility.DOMelem,\"click\",function(){loginresponsibility._last=(new Date()).valueOf();});loginresponsibility.attachEvent(\"onOpen\",function(){window.setTimeout(function(){if ((new Date()).valueOf()-(loginresponsibility._last||0) > 100) return;var text = loginresponsibility.getComboText();loginresponsibility.setComboText(\"\");loginresponsibility.filterSelf();loginresponsibility.setComboText(text);},1);});dhtmlxEvent(loginresponsibility.DOMelem_input,\"keypress\",function(){loginAppl_resp_event(this)});dhtmlxEvent(loginresponsibility.DOMelem_input,\"blur\",function(){responsibility_blur(loginresponsibility)});");
					  eval("var loginresponsibility=dhtmlXComboFromSelect(\"loginresponsibility\");loginresponsibility.enableFilteringMode(true);loginresponsibility.enableOptionAutoPositioning(true);dhtmlxEvent(loginresponsibility.DOMelem,\"click\",function(){loginresponsibility._last=(new Date()).valueOf();});loginresponsibility.attachEvent(\"onOpen\",function(){window.setTimeout(function(){if ((new Date()).valueOf()-(loginresponsibility._last||0) > 100) return;var text = loginresponsibility.getComboText();loginresponsibility.setComboText(\"\");loginresponsibility.filterSelf();},1);return true;});dhtmlxEvent(loginresponsibility.DOMelem_input,\"keypress\",function(){loginAppl_resp_event(this)});dhtmlxEvent(loginresponsibility.DOMelem_input,\"blur\",function(){responsibility_blur(loginresponsibility)});");
					///document.getElementById("passwordID").innerHTML=getLabel("Common.facility.label","Common");
					if(facCount==0){
						document.getElementById("passwordTextID").style.display="None";
						document.getElementById("errMSGID0").style.display="";
						document.getElementById("errMSGID").innerHTML=getMessage("NO_FACILITIES","Common");
						document.getElementById("loginID").disabled="true";
						document.getElementById("loginID").style.cursor="default";
						document.forms[0].level.value="2";
					}else{
						var facilityString="<select class='select' name='facility' id='facility' id=\"facility\" tabIndex=\"2\" onchange=\"selectfacility(this)\" onkeypress=\"loginAppl_fac_event(this)\" onblur=\"facility_blur(facility)\">";
						var facilities=facCode_desc.split("^^");
						for (var i=0; i<facCount; i++){
							var	fac;
							fac=(facilities[i]).split("~");
							var facID=fac[0];
							var facName=fac[1];
							if(i==0){
								document.forms[0].facility_id.value=facID;
								document.forms[0].facility_name.value=facName;
							}
							facilityString +="<option value="+facID+"|"+facName+">"+facName+"</option>";
						}
						facilityString +="</select>";
						
						document.getElementById("passwordTextID").innerHTML=facilityString;
						//eval("var facility=dhtmlXComboFromSelect(\"facility\");facility.enableFilteringMode(true);facility.enableOptionAutoPositioning(true);dhtmlxEvent(facility.DOMelem,\"click\",function(){facility._last=(new Date()).valueOf();});facility.attachEvent(\"onOpen\",function(){window.setTimeout(function(){if ((new Date()).valueOf()-(facility._last||0) > 100) return;var text = facility.getComboText();facility.setComboText(\"\");facility.filterSelf();facility.setComboText(text);},1);});dhtmlxEvent(facility.DOMelem_input,\"keypress\",function(){loginAppl_fac_event(this)});dhtmlxEvent(facility.DOMelem_input,\"blur\",function(){facility_blur(facility)});");
						  eval("var facility=dhtmlXComboFromSelect(\"facility\");facility.enableFilteringMode(true);facility.enableOptionAutoPositioning(true);dhtmlxEvent(facility.DOMelem,\"click\",function(){facility._last=(new Date()).valueOf();});facility.attachEvent(\"onOpen\",function(){window.setTimeout(function(){if ((new Date()).valueOf()-(facility._last||0) > 100) return;var text = facility.getComboText();facility.setComboText(\"\");facility.filterSelf();},1);return true;});dhtmlxEvent(facility.DOMelem_input,\"onchange\",function(){selectfacility(this)});dhtmlxEvent(facility.DOMelem_input,\"keypress\",function(){loginAppl_fac_event(this)});dhtmlxEvent(facility.DOMelem_input,\"blur\",function(){facility_blur(facility)});");
						document.getElementById("loginID").innerHTML=getLabel("Common.ok.label","Common");
						document.getElementById("cancelID").innerHTML=getLabel("Common.cancel.label","Common");
						document.forms[0].level.value="2";
						login_fac_flag=true;
					}				
				}
			}		
			var obj=document.forms[0].elements[0];
			obj.focus();
			obj.select();
		}
	}
}
async function helpfunction(){
	var dialogHeight= "38.8" ;
	var dialogTop = "125" ;
	var dialogWidth	= "63.8" ;
	var dialogLeft   = "0";	
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
	var arguments    = "" ;			
	retVal 	 	 = await window.showModalDialog("../../eCommon/html/Login.html",arguments,features); 
}
function getLabels(){
//var obj=null;
//obj.type="hi";
/*
	document.getElementById("userNameID").innerHTML=getLabel("Common.username.label","Common");
	document.getElementById("passwordID").innerHTML=getLabel("Common.password.label","Common");
	document.getElementById("loginID").innerHTML=getLabel("Common.login.label","Common");
	document.getElementById("cancelID").innerHTML=getLabel("Common.cancel.label","Common");
*/
//--------------mz changes----------------------
        document.getElementById("userNameID").innerHTML=getLabel("Common.username.label","Common");
	document.getElementById("passwordID").innerHTML=getLabel("Common.password.label","Common");
	document.getElementById("loginID").innerHTML=getLabel("Common.login.label","Common");
	document.getElementById("cancelID").innerHTML=getLabel("Common.cancel.label","Common");
//-----------mz changes-------------------------
}
function facility_blur(obj){
	obj.setComboText((obj.getSelectedText()).replace(/\&amp;/g,'&'));
	document.getElementById("errMSGID0").style.display="None"; //mz changes
	document.getElementById("loginID").disabled=false; //mz changes
	document.getElementById("loginID").style.cursor="pointer"; //mz changes
	if(obj.getSelectedValue()==null){
		document.forms[0].facility_id.value="";
		login_fac_flag=false;
	}else{
		login_fac_flag=true;
	}
}
function responsibility_blur(obj){
	document.getElementById("errMSGID0").style.display="None";//mz changes
	document.getElementById("loginID").disabled=false; // mz changes
	document.getElementById("loginID").style.cursor="pointer"; //mz changes
	obj.setComboText((obj.getSelectedText()).replace(/\&amp;/g,'&'));
	if(obj.getSelectedValue()==null){
		document.forms[0].responsibility_id.value=""; //mz changes
		login_resp_flag=false;
	}else{
		login_resp_flag=true;
	}
}

function noescUser(event) { //mz changes

	return !(window.event && event.keyCode == 27); //mz changes
}
function noescPassword(event) { // Mz changes
	return !(window.event && event.keyCode == 27);//mz changes
}

