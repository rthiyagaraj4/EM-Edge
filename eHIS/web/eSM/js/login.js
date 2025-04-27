var login_resp_flag=false;
var login_fac_flag=false;
function check_user_password_event(e){	
	var level =document.forms[0].level.value;
	document.getElementById("errMSGID0").style.display="None";
	if(e.keyCode==13||e.keyCode==32)
		var key = new Array(13,32);
	if(key!=null){
		for(var i=0;i<key.length;i++){
			if(e.keyCode==key[i]){
				if(e.keyCode==32){
					return true;
				}
				if(level=="1"){
					check_user_password();
					return event.returnValue=false;
				}else{
					loginAppl();
				}
				break;
			}
		}
	}
}
function login_enter_event(e){
	//Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2
	var isSSOIntegrationAppl = document.forms[0].isSSOIntegrationAppl.value;

	if(e.keyCode==13 || e.keyCode==32){
		check_user_password();
	}else{
		//Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2
		if(isSSOIntegrationAppl != 'true'){
			var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_';
			var allowed_spl_char_in_password=document.forms[0].allowed_spl_char_in_password.value;
			var enforce_password_policy_yn=document.forms[0].enforce_password_policy_yn.value;
			var allowed_spl_char_in_password1=decodeURIComponent(allowed_spl_char_in_password,'UTF-8');
			allowed_spl_char_in_password1 = allowed_spl_char_in_password1.replace("+",'')
			if(enforce_password_policy_yn=='Y')
				{
				strCheck= strCheck.concat(allowed_spl_char_in_password1);
				}
			var whichCode = (window.Event) ? event.which : event.keyCode;
			key = String.fromCharCode(whichCode);  // Get key value from key code
			if (strCheck.indexOf(key) == -1){
				return event.returnValue=false;
			}else{
				return true ;
			}
		}
	}
}
function check_password_event(e){
	if(e.keyCode==13){
		ChangeUpperCase(login_form.password);
		check_user_password();
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
	document.getElementById("errMSGID").innerHTML="";
	document.getElementById("errMSGID0").style.display="None";
	if(event.keyCode==13){
		if((document.login_form.responsibility_id.value!=null && document.login_form.responsibility_id.value!="") && (document.login_form.facility_id.value!=null && document.login_form.facility_id.value!="")){
			if(login_resp_flag){
				loginAppl();
			}else{
				login_resp_flag=true;
			}
		}else{
			if(document.login_form.responsibility_id.value=="" && document.login_form.facility_id.value==""){
				document.getElementById("errMSGID0").style.display="";
				document.getElementById("errMSGID").innerHTML=getMessage("INAVLID_RESP_FACILITY","Common");
			}else if(document.login_form.responsibility_id.value==""){
				document.getElementById("errMSGID0").style.display="";
				document.getElementById("errMSGID").innerHTML=getMessage("INAVLID_RESPONSIBILITY","Common");
				login_resp_flag=false;
			}else{
				document.getElementById("errMSGID0").style.display="";
				document.getElementById("errMSGID").innerHTML=getMessage("INAVLID_FACILITY","Common");
				login_fac_flag=false;
			}
		}
	}else{
		login_resp_flag=false;
	}
}
function loginAppl_fac_event(e){
	document.getElementById("errMSGID").innerHTML="";
	document.getElementById("errMSGID0").style.display="None";
	if(event.keyCode==13){
		if((document.login_form.responsibility_id.value!=null && document.login_form.responsibility_id.value!="") && (document.login_form.facility_id.value!=null && document.login_form.facility_id.value!="")){
			if(login_fac_flag){
				loginAppl();
			}else{
				login_fac_flag=true;
			}
		}else{
			if(document.login_form.responsibility_id.value=="" && document.login_form.facility_id.value==""){
				document.getElementById("errMSGID0").style.display="";
				document.getElementById("errMSGID").innerHTML=getMessage("INAVLID_RESP_FACILITY","Common");
			}else if(document.login_form.responsibility_id.value==""){
				document.getElementById("errMSGID0").style.display="";
				document.getElementById("errMSGID").innerHTML=getMessage("INAVLID_RESPONSIBILITY","Common");
				login_fac_flag=false;
			}else{
				document.getElementById("errMSGID0").style.display="";
				document.getElementById("errMSGID").innerHTML=getMessage("INAVLID_FACILITY","Common");
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
	login_form.facility_id.value = id ;
	login_form.facility_name.value = name ;
	return true ;
}

function changeResponsibility( listvalue ) {
	var lists 	= listvalue.split( "|" ) ;
	var id 	= lists[0] ;
	var name 	= lists[1] ;

	login_form.responsibility_id.value = id ;
	login_form.responsibility_name.value = name ;
	return true ;
}
function check_user_password(){
	if(document.forms[0].level.value=="1"){
		if (login_form.compname.value == null || login_form.compname.value == ''){
			alert('Activex properties not enabled, cannot proceed...');
			login_form.name.focus();
			return false;
		}
		if(login_form.name.value==''){
			alert('APP-SM0019 User Id/Password Cannot be Blank');
			login_form.name.focus();
			return event.returnValue=false;
		}else{
			if(login_form.password.value==''){
				alert('APP-SM0007 Password Should be Entered');
				login_form.password.focus();
				return event.returnValue=false;
			}else{
				submit_user_pwd();
				/*
				if(login_form.everyvisit.value == '3') {
					if(login_form.proxy_check.value == '1' && login_form.ProxyEnable.value == '1' && login_form.ProxyOverride.value.indexOf(";<local>") <=0  ) {
						alert('Your proxy setting is not proper, Application usage will result in inconsistency.. Please contact System Administrator');
					}else{
						submit_user_pwd();
					}
				}else{
					alert('Your browser setting is not proper, Application usage will result in inconsistency.. Please contact System Administrator');
					return event.returnValue=false;
				}
				//login_form.submit();
				*/
			}
		}
	}else if(document.forms[0].level.value=="2"){
		loginAppl();
	}
}
function checkvisible(){
	document.getElementById("errMSGID").innerHTML="";
	document.getElementById("errMSGID0").style.display="None";
}
	
function MyAddress(data) {

	var hostIP;

	var index = data.indexOf("&");
	hostName = data.substr(0,index);
	hostIP = data.substr(index+1,data.length);

	document.getElementById("clientIP").value = hostIP;
} 
function cancelbutton(){
	if(document.forms[0].level.value=='1'){
		document.getElementById("errMSGID0").style.display="None";
		document.forms[0].name.value="";
		document.forms[0].password.value="";
		document.forms[0].name.focus();
	}else if(document.forms[0].level.value=='2'){
		var userId = document.forms[0].login_user.value;
		fnLogout(userId);
		backtoLogin();
	}
}
function change_resp(obj){
		var user_name=document.forms[0].login_user.value;
		var resp_ID=obj.getSelectedValue();
		if(resp_ID){
			changeResponsibility(resp_ID);
			if(document.forms[0].facilitySelect){
			var facilityVal = document.forms[0].facilitySelect;
			while(facilityVal.options.length >=1)
			facilityVal.options.length=0;
			}
			document.login_form.facility_id.value="";
			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();
			xmlStr	="<root><SEARCH " ;
			xmlStr += " resp_ID=\"" + login_form.responsibility_id.value + "\"";
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST","../../eSM/jsp/FacilitySelect.jsp", false ) ;
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText;
			responseText = trimString(responseText);
			addfacility(responseText);
		}else{
			document.getElementById("errMSGID0").style.display="none";
			login_form.responsibility_id.value="";
			login_resp_flag=false;
		}

}
function addfacility(valueText){
	document.getElementById("errMSGID").innerHTML="";
	var cap_sep=valueText.split('^')
	var fc_value=cap_sep[0];
	var fc_count=cap_sep[1];
	var ival=0;
	if(fc_count=='0'){
		document.getElementById("passwordTextID").style.display="None";
		document.getElementById("errMSGID0").style.display="";
		document.getElementById("errMSGID").innerHTML=getMessage("NO_FACILITIES","Common");
		document.getElementById("loginID").disabled="true";
		document.getElementById("loginID").style.cursor="default";
		//document.forms[0].all.checkFac.style.visibility="visible";		
	}else{
		var dol_facility=fc_value.split('$');
		var len=dol_facility.length;
		var facilityString="<select class='select' style='width: 290px'  name='facility' id='facility' id=\"facility\" tabIndex=\"2\" onchange=\"selectfacility(this)\" onkeypress=\"loginAppl_fac_event(this)\" onblur=\"facility_blur(facility)\">";	
		for(var i=0;i<len;i++){
			if(document.getElementById("facilitySelect")){
				var split_fac=dol_facility[i].split('~');
				var resp_id = document.getElementById("facilitySelect");
				var option = document.createElement("OPTION");
				option.text  = split_fac[1];
				option.value = split_fac[0]+"|"+split_fac[1];
				resp_id.add(option);
				if(i==0){
					option.selected='true';
					login_form.facility_id.value=split_fac[0];
					login_form.facility_name.value=split_fac[1];
					document.getElementById("loginID").disabled=false;
					document.getElementById("loginID").style.cursor="hand";
				}
				document.getElementById("errMSGID0").style.display="none";
				document.getElementById("passwordTextID").style.display="";
				document.login_form.level.value="2";
			}else{
				var split_fac=dol_facility[i].split('~');
				var facID=split_fac[0];
				var facName=split_fac[1];
				if(i%2==0){
					classvalue="option1";
				}else{
					classvalue="option2";
				}
				if(i==0){
					document.login_form.facility_id.value=facID;
					document.login_form.facility_name.value=facName;
					document.getElementById("loginID").disabled=false;
					document.getElementById("loginID").style.cursor="hand";
				}
				document.getElementById("errMSGID0").style.display="none";
				document.getElementById("passwordTextID").style.display="";
				document.login_form.level.value="2";	
				var isSelect	 = "";
				if(facID==document.getElementById("dfltFacilityId").value){
					isSelect	= "selected";
					document.getElementById("facility_id").value=facID;
					document.getElementById("facility_name").value=facName;
				}				
				facilityString +="<option  value='"+facID+"|"+facName+"' "+isSelect+">"+facName+"</option>";			
			}
		}
		facilityString +="</select>";
		document.getElementById("loginID").value=getLabel("Common.ok.label","Common");
		//document.getElementById("loginID").style.display	=	'none';
		//document.getElementById("okID").style.display	=	'block';
		if(document.getElementById("facilitySelect")){
		}else{
			document.getElementById("passwordTextID").innerHTML=facilityString;
			//eval("var facility=dhtmlXComboFromSelect(\"facility\");facility.enableFilteringMode(true);facility.enableOptionAutoPositioning(true);dhtmlxEvent(facility.DOMelem,\"click\",function(){facility._last=(new Date()).valueOf();});facility.attachEvent(\"onOpen\",function(){window.setTimeout(function(){if ((new Date()).valueOf()-(facility._last||0) > 100) return;var text = facility.getComboText();facility.setComboText(\"\");facility.filterSelf();facility.setComboText(text);},1);});dhtmlxEvent(facility.DOMelem_input,\"keypress\",function(){loginAppl_fac_event(this)});dhtmlxEvent(facility.DOMelem_input,\"blur\",function(){facility_blur(facility)});");
			eval("var facility=dhtmlXComboFromSelect(\"facility\");facility.enableFilteringMode(true);facility.enableOptionAutoPositioning(true);dhtmlxEvent(facility.DOMelem,\"click\",function(){facility._last=(new Date()).valueOf();});facility.attachEvent(\"onOpen\",function(){window.setTimeout(function(){if ((new Date()).valueOf()-(facility._last||0) > 100) return;var text = facility.getComboText();facility.setComboText(\"\");facility.filterSelf();},1);return true;});dhtmlxEvent(facility.DOMelem_input,\"onchange\",function(){selectfacility(this)});dhtmlxEvent(facility.DOMelem_input,\"keypress\",function(){loginAppl_fac_event(this)});dhtmlxEvent(facility.DOMelem_input,\"blur\",function(){facility_blur(facility)});");
			eval('var obj=document.forms[0].elements[0];obj.focus();obj.select();');
		}
	}
}
function loginAppl(){
	document.getElementById("errMSGID").innerHTML="";
	if((document.login_form.responsibility_id.value!=null && document.login_form.responsibility_id.value!="") && (document.login_form.facility_id.value!=null && document.login_form.facility_id.value!="")){
		document.forms[0].level.value=3;
		//document.forms[0].submit();	
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr += " name=\"" +encodeURIComponent(document.forms[0].name.value)+ "\""	;
		xmlStr += " level=\"" + document.forms[0].level.value + "\"";
		xmlStr += " mode=\"" + document.forms[0].mode.value + "\"";
		xmlStr += " responsibility_id=\"" +encodeURIComponent(document.login_form.responsibility_id.value)+ "\"";
		xmlStr += " responsibility_name=\"" +encodeURIComponent(document.login_form.responsibility_name.value)+ "\"";
		xmlStr += " facility_id=\"" +encodeURIComponent(document.login_form.facility_id.value)+ "\"";
		xmlStr += " facility_name=\"" +encodeURIComponent(document.login_form.facility_name.value)+ "\"";
		xmlStr += " compname=\"" +login_form.compname.value+ "\"";
		xmlStr += " domain=\"" +login_form.domain.value+ "\"";
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","../../servlet/eSM.LoginResponseServlet", false ) ;
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseText = trimString(responseText);
		loginApplication(responseText);	
	}else{
		if(document.login_form.responsibility_id.value=="" && document.login_form.facility_id.value==""){
			document.getElementById("errMSGID0").style.display="";
			document.getElementById("errMSGID").innerHTML=getMessage("INAVLID_RESP_FACILITY","Common");
		}else if(document.login_form.responsibility_id.value==""){
			document.getElementById("errMSGID0").style.display="";
			document.getElementById("errMSGID").innerHTML=getMessage("INAVLID_RESPONSIBILITY","Common");
			login_resp_flag=false;
		}else{
			document.getElementById("errMSGID0").style.display="";
			document.getElementById("errMSGID").innerHTML=getMessage("INAVLID_FACILITY","Common");
			login_fac_flag=false;
		}
		document.getElementById("loginID").disabled="true";
		document.getElementById("loginID").style.cursor="default";
	}
}
function loginApplication(flagval){
		document.getElementById("action").value="loggedin";//Added By Dharma on 17th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613]
		location.href = '../../eCommon/jsp/'+flagval;

}
function backtoLogin(){

	//Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2
	var isSSOIntegrationAppl = document.getElementById("isSSOIntegrationAppl").value;

	document.getElementById("errMSGID").innerHTML="";
	//document.getElementById("displayUserID").style.display="none"; //Commented by Suji Keerthi for PMG2021-COMN-CRF-0002 US002
	//document.getElementById("errMSGID").innerHTML="none";
	document.getElementById("errMSGID0").style.display="none";
	document.getElementById("userNameID").innerHTML=getLabel("Common.username.label","Common");
	if(isSSOIntegrationAppl == 'true'){
		document.getElementById("userNameTextID").innerHTML='<input name="name" id="name" style="padding-top:5px; padding-left:5px;" type="text" size="46" maxlength="40" height="30px" onKeyPress="checkvisible();return CheckForSpecChars(event);checkuser_event(event)" onblur="checkvisible();checkADAndEMUserYN(this);" tabIndex="1" class="inputH"/>';
	}else{
		document.getElementById("userNameTextID").innerHTML='<input name="name" id="name" style="padding-top:5px; padding-left:5px;" type="text" size="46" maxlength="40" height="30px" onKeyPress="checkvisible();return CheckForSpecChars(event);checkuser_event(event)" onblur="checkvisible()" tabIndex="1" class="inputH"/>';
	}
	document.getElementById("passwordID").innerHTML=getLabel("Common.password.label","Common");
	document.getElementById("passwordTextID").style.display="";
	//document.getElementById("passwordTextID").innerHTML='<input name="password" id="password" type="password" size="38" maxlength="30" onBlur="ChangeUpperCase(this);" onkeypress="check_user_password_event(event)" tabIndex="2"/>';
	document.getElementById("passwordTextID").innerHTML='<input name="password" id="password" style="padding-top:5px;padding-left:5px;" type="password" size="47" maxlength="30"  onkeypress="check_user_password_event(event)" tabIndex="2" class="inputH" />';
	document.login_form.level.value="1";
	document.getElementById("name").focus();
	//document.getElementById("loginID").style.display	=	'block';
	//document.getElementById("okID").style.display	=	'none';
	
	document.getElementById("loginID").disabled=false;
	document.getElementById("loginID").value=getLabel("Common.loginhome.label","Common"); //Modified by Suji Keerthi for PMG2021-COMN-CRF-0002
	
	//Below line added  for this SCF AMS-SCF-0597
	document.getElementById("cancelID").disabled=false;
	document.getElementById("cancelID").value=getLabel("Common.cancelhome.label","Common"); //Modified by Suji Keerthi for PMG2021-COMN-CRF-0002
	//End this SCF AMS-SCF-0597	
	
	login_resp_flag=false;
	login_fac_flag=false;
	document.getElementById("name").focus();
}
function selectfacility(obj){
	if(obj.getSelectedValue()!=null){
		changeFacility(obj.getSelectedValue());		
	}else{
		document.login_form.facility_id.value="";
		document.login_form.facility_name.value="";
		//document.getElementById("errMSGID0").style.display="";
		//document.getElementById("errMSGID").innerHTML=getMessage("INAVLID_FACILITY","Common");
		login_fac_flag=false;
	}
}
function loadResp(){
	document.login_form.all.loginresponsibility.focus();
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
	//Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2
	var isSSOIntegrationAppl = document.forms[0].isSSOIntegrationAppl.value;

	if(event.keyCode==13){
		checkuser_event(event);
	}else{
		//Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2
		if(isSSOIntegrationAppl != 'true'){
			var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_';
			var whichCode = (window.Event) ? event.which : event.keyCode;
			key = String.fromCharCode(whichCode);  // Get key value from key code
			if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
		}

		if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
		return true ;
	}
}
function checkuser_event(event){
	if(event.keyCode==13){
		if(login_form.password.value!=''){
			check_user_password();
		}else{
			document.forms[0].password.focus();
		}

	}
}
function submit_user_pwd(){
	
	//Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2
	var isSSOIntegrationAppl = document.forms[0].isSSOIntegrationAppl.value;
	var login_user_type = document.forms[0].login_user_type.value;
	var loginID = trimString(document.forms[0].name.value);
	var password = document.forms[0].password.value;
	
	var active_dir_id		= "";
	var appl_user_id		= "";
	var appl_user_paswd		= "";
	var retValApi			= "";
	var lnkd_actv_dir_id	= "";
	
	if(isSSOIntegrationAppl == 'true' && login_user_type != 'EM'){
		var xmlDoc=""
		var xmlHttp = new XMLHttpRequest()
		xmlStr = "<root><SEARCH  action='getLinkedADUserDetails' loginID=\""+encodeURIComponent(loginID)+"\" /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","../../eSM/jsp/SMIntermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText = xmlHttp.responseText
		responseText = trimString(responseText)

		var retVal_arr = responseText.split("~");

		active_dir_id = retVal_arr[0];
		appl_user_id = retVal_arr[1];
		appl_user_paswd = retVal_arr[2];

		if(active_dir_id != ""){

			retValApi = callSingleSignOnAuth('AUTH',loginID,password);

			retValApi = retValApi.split("$!^");

			retValApi = trimString(retValApi[0]);

			loginID = appl_user_id;
			password = appl_user_paswd;
			login_user_type = "AD";
		}else{

			var xmlDoc=""
			var xmlHttp = new XMLHttpRequest()
			xmlStr = "<root><SEARCH  action='getEMUserLinkedToADUserDetails' loginID=\""+encodeURIComponent(loginID)+"\" /></root>"
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","../../eSM/jsp/SMIntermediate.jsp",false)
			xmlHttp.send(xmlDoc)
			responseText = xmlHttp.responseText
			responseText = trimString(responseText)

			lnkd_actv_dir_id = responseText;

			if(lnkd_actv_dir_id != "")
			{
				var errors = getMessage('EM_USER_LINKED_TO_AD_USER','SM');
				errors = errors.replace("#",loginID);
				alert(errors);
				document.forms[0].name.focus();
				return event.returnValue = false;
			}else{
				login_user_type = "EM";
			}
		}
	}

	document.getElementById("loginID").disabled=true;
	document.getElementById("cancelID").disabled=true;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " name=\""+encodeURIComponent(loginID)+"\""	;
	xmlStr += " password=\""+encodeURIComponent(password)+"\"";
	xmlStr += " level=\""+document.forms[0].level.value+"\"";
	xmlStr += " mode=\""+document.forms[0].mode.value+"\"";
	xmlStr += " compname=\"" +login_form.compname.value+ "\"";
	xmlStr += " domain=\"" +login_form.domain.value+ "\"";
	xmlStr += " first_login_change_password_yn=\"" +login_form.first_login_change_password_yn.value+ "\"";
	xmlStr += " case_sensitive_password_yn=\"" +login_form.case_sensitive_password_yn.value+ "\"";//Maheshwaran added for the MMS-QH-CRF-0149
	xmlStr += " multiple_login_allowed_yn=\"" +login_form.multiple_login_allowed_yn.value+ "\"";//Added By Dharma on 17th Oct 2016 against MO-CRF-20113 [IN:060974]
	
	//Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2
	xmlStr += " active_dir_id=\""+encodeURIComponent(active_dir_id)+"\"";
	xmlStr += " login_user_type=\""+login_user_type+"\"";
	xmlStr += " retValApi=\""+retValApi+"\"";
	
	xmlStr +=" /></root>" ;  
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../servlet/eSM.LoginResponseServlet", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;	
	responseText = trimString(responseText);
	addResposibility(responseText);

}
async function addResposibility(valueText){
var result_val2='';
var continue_flow='Y';
	if(valueText=='home.jsp'){
		loginApplication(valueText);
	}else{
		//Added by Maheshwaran K for the Password Validation as on 11/07/2012
		//Start 
		var multi_err=(valueText.split("error_num").length - 1);
		//Below line added for this SCF AMS-SCF-0597
		var first_login_change_password_yn=document.forms[0].first_login_change_password_yn.value;
		//End this SCF AMS-SCF-0597
		if(multi_err==2)
			{
			var result_val_final=valueText.split("&");
			var result_val_text=result_val_final[0];
			valueText=result_val_final[1];
			//Maheshwaran K added for the Incident NO :35515 as on 10/10/2012
			valueText=valueText.replace(/^\s+/,"");
			//End
			//Changed related to change password mandatory is added by Maheshwaran for AMs-CRF-0098
			
		  //Below line commented for this SCF AMS-SCF-0597
		  //var first_login_change_password_yn=document.forms[0].first_login_change_password_yn.value;
		  //End this SCF AMS-SCF-0597
		  
			var change_password_mandatory_yn=document.forms[0].change_password_mandatory_yn.value;
			var result_val=result_val_text.split("||");
			var result_val0=result_val[0];
			var result_val1=result_val[1];
			result_val2=result_val[2];	
			
			if(first_login_change_password_yn=='Y'){
				var chk1=result_val2.indexOf("First");		
				var chk2=result_val2.indexOf("Reset");	
				if(chk1!=-1 || chk2!=-1){
					//if(window.confirm(result_val2)){
						var retVal = new Array();
						//var features	= 'dialogHeight:20; dialogWidth:28;dialogTop:150;status=no;scroll=no';
						var features	= 'dialogHeight:400px; dialogWidth:480px; dialogTop:150px; dialogLeft:150px;status=no;scroll=no';
						var arguments	= '' ;
						retVal = await window.showModalDialog('../../eSM/jsp/change_password_frames.jsp',arguments,features);
					
						if(retVal=='F'|| retVal=='undefined' || retVal== undefined) {
						if(change_password_mandatory_yn=='Y')
							{ 
								if(result_val2.indexOf("First")!=-1){
									alert('APP-SM0006 It is mandatory to change the password during the first login of a User');
									}else{
									alert('APP-SM0006 It is mandatory to change the password on first login after a Password Reset');	
									}
							backtoLogin();
							return;
							}
							
						}
						else
							{
							document.forms[0].password.value=retVal;
							}
				  //  }	
				}else{	
						
					//Below line modified for this SCF AMS-SCF-0597						
					//if((result_val2 !=='' && chk1==-1) || (result_val2 !=='' && chk2==-1)){
					if(result_val2 !==''){
					    
						if(window.confirm(result_val2)) {							   
							var retVal = new Array();
							//var features	= 'dialogHeight:20; dialogWidth:28;dialogTop:150;status=no;scroll=no';
							var features	= 'dialogHeight:400px; dialogWidth:480px; dialogTop:150px; dialogLeft:150px;status=no;scroll=no';
							var arguments	= '' ;
							retVal = await window.showModalDialog('../../eSM/jsp/change_password_frames.jsp',arguments,features);				
						}else{
								continue_flow='Y';
						}
					}
                    //End this SCF AMS-SCF-0597 					
					
					}
				}
			}
		//End	
        
        //Below line modified for this SCF AMS-SCF-0597
		if(result_val2 !=='' && first_login_change_password_yn=="N"){
			
			if(window.confirm(result_val2)) {
				var retVal = new Array();
				//var features	= 'dialogHeight:20; dialogWidth:28;dialogTop:150;status=no;scroll=no';
				var features	= 'dialogHeight:400px; dialogWidth:480px; dialogTop:150px; dialogLeft:150px;status=no;scroll=no';
				var arguments	= '' ;
				retVal = await window.showModalDialog('../../eSM/jsp/change_password_frames.jsp',arguments,features);
			}else{
				continue_flow='Y';
			}


		}
		
		if(continue_flow=='Y'){
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
				var dfltFacilityId=facilityval[2];
				document.login_form.dfltFacilityId.value=dfltFacilityId;
				
				var respString="<select class='select' style='width: 290px' name=\"loginresponsibility\" tabIndex=\"1\" id=\"loginresponsibility\" onchange=\"change_resp(this)\" onkeypress=\"loginAppl_resp_event(this)\" onblur=\"responsibility_blur(loginresponsibility)\">"; 
				if(respcount=="1" && facCount=="1"){
						var responsibilities=respCode_desc.split("~");
						var facilities=facCode_desc.split("~");
						var respID=responsibilities[0];
						var respName=responsibilities[1];
						var facID=facilities[0];
						var facName=facilities[1];
						document.login_form.responsibility_id.value=respID;
						document.login_form.responsibility_name.value=respName;
						document.login_form.facility_id.value=facID;
						document.login_form.facility_name.value=facName;
						loginAppl();
				}else{
				if(respcount > 0){
					login_resp_flag=true;
					//document.getElementById("displayUserID").style.display=""; //Commented by Suji Keerthi for PMG2021-COMN-CRF-0002
					//document.getElementById("displayUserID").innerHTML=result1; //Commented by Suji Keerthi for PMG2021-COMN-CRF-0002
					var responsibilities=respCode_desc.split("^^");
					var	resp;
					for (var i=0; i<respcount; i++){
						resp=(responsibilities[i]).split("~");
						var respID=resp[0];
						var respName=resp[1];
						if(i==0){
							document.login_form.responsibility_id.value=respID;
							document.login_form.responsibility_name.value=respName;
							respString +="<option value="+respID+" selected>"+respName+"</option>";
						}else{
							respString +="<option value="+respID+">"+respName+"</option>";
						}
					}
					respString +="</select>";
					
						document.getElementById("userNameID").innerHTML=getLabel("Common.responsibility.label","Common");
						document.getElementById("userNameTextID").innerHTML=respString;   
						
						
						//eval("var loginresponsibility=dhtmlXComboFromSelect(\"loginresponsibility\");loginresponsibility.enableFilteringMode(true);loginresponsibility.enableOptionAutoPositioning(true);dhtmlxEvent(loginresponsibility.DOMelem,\"click\",function(){loginresponsibility._last=(new Date()).valueOf();});loginresponsibility.attachEvent(\"onOpen\",function(){window.setTimeout(function(){if ((new Date()).valueOf()-(loginresponsibility._last||0) > 100) return;var text = loginresponsibility.getComboText();loginresponsibility.setComboText(\"\");loginresponsibility.filterSelf();loginresponsibility.setComboText(text);},1);});dhtmlxEvent(loginresponsibility.DOMelem_input,\"keypress\",function(){loginAppl_resp_event(this)});dhtmlxEvent(loginresponsibility.DOMelem_input,\"blur\",function(){responsibility_blur(loginresponsibility)});");
						  eval("var loginresponsibility=dhtmlXComboFromSelect(\"loginresponsibility\");loginresponsibility.enableFilteringMode(true);loginresponsibility.enableOptionAutoPositioning(true);dhtmlxEvent(loginresponsibility.DOMelem,\"click\",function(){loginresponsibility._last=(new Date()).valueOf();});loginresponsibility.attachEvent(\"onOpen\",function(){window.setTimeout(function(){if ((new Date()).valueOf()-(loginresponsibility._last||0) > 100) return;var text = loginresponsibility.getComboText();loginresponsibility.setComboText(\"\");loginresponsibility.filterSelf();},1);return true;});dhtmlxEvent(loginresponsibility.DOMelem_input,\"keypress\",function(){loginAppl_resp_event(this)});dhtmlxEvent(loginresponsibility.DOMelem_input,\"blur\",function(){responsibility_blur(loginresponsibility)});");
						document.getElementById("passwordID").innerHTML=getLabel("Common.facility.label","Common");
						if(facCount==0){
							document.getElementById("passwordTextID").style.display="None";
							document.getElementById("errMSGID0").style.display="";
							document.getElementById("errMSGID").innerHTML=getMessage("NO_FACILITIES","Common");
							document.getElementById("loginID").disabled="true";
							document.getElementById("loginID").style.cursor="default";
							document.login_form.level.value="2";
						}else{
							var facilityString="<select class='select' style='width: 290px'  name='facility' id='facility' id=\"facility\" tabIndex=\"2\" onchange=\"selectfacility(this)\" onkeypress=\"loginAppl_fac_event(this)\" onblur=\"facility_blur(facility)\">";
							var facilities=facCode_desc.split("^^");
							for (var i=0; i<facCount; i++){
								var	fac;
								fac=(facilities[i]).split("~");
								var facID=fac[0];
								var facName=fac[1];
								if(i==0){
									document.login_form.facility_id.value=facID;
									document.login_form.facility_name.value=facName;
								}
								var isSelect	 = "";
								if(facID==dfltFacilityId){
									isSelect	= "selected";
									document.login_form.facility_id.value=facID;
									document.login_form.facility_name.value=facName;								
								}else{
									isSelect	= "";
								}
								facilityString +="<option value="+facID+"|"+facName+" "+isSelect+">"+facName+"</option>";
							}
							facilityString +="</select>";
						
							
							document.getElementById("passwordTextID").innerHTML=facilityString;
							
							//eval("var facility=dhtmlXComboFromSelect(\"facility\");facility.enableFilteringMode(true);facility.enableOptionAutoPositioning(true);dhtmlxEvent(facility.DOMelem,\"click\",function(){facility._last=(new Date()).valueOf();});facility.attachEvent(\"onOpen\",function(){window.setTimeout(function(){if ((new Date()).valueOf()-(facility._last||0) > 100) return;var text = facility.getComboText();facility.setComboText(\"\");facility.filterSelf();facility.setComboText(text);},1);});dhtmlxEvent(facility.DOMelem_input,\"keypress\",function(){loginAppl_fac_event(this)});dhtmlxEvent(facility.DOMelem_input,\"blur\",function(){facility_blur(facility)});");
							  eval("var facility=dhtmlXComboFromSelect(\"facility\");facility.enableFilteringMode(true);facility.enableOptionAutoPositioning(true);dhtmlxEvent(facility.DOMelem,\"click\",function(){facility._last=(new Date()).valueOf();});facility.attachEvent(\"onOpen\",function(){window.setTimeout(function(){if ((new Date()).valueOf()-(facility._last||0) > 100) return;var text = facility.getComboText();facility.setComboText(\"\");facility.filterSelf();},1);return true;});dhtmlxEvent(facility.DOMelem_input,\"onchange\",function(){selectfacility(this)});dhtmlxEvent(facility.DOMelem_input,\"keypress\",function(){loginAppl_fac_event(this)});dhtmlxEvent(facility.DOMelem_input,\"blur\",function(){facility_blur(facility)});");
							
							//document.getElementById("loginID").innerHTML=getLabel("Common.ok.label","Common");
							document.getElementById("loginID").value=getLabel("Common.ok.label","Common");
							document.getElementById("cancelID").value=getLabel("Common.cancelhome.label","Common");  //Modified by Suji Keerthi for PMG2021-COMN-CRF-0002
							document.login_form.level.value="2";
							login_fac_flag=true;
							document.getElementById("action").value="logout";//Added By Dharma on 17th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613]
						}				
					}
				}		
				var obj=document.forms[0].elements[0];
				obj.focus();
				obj.select();
			}
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
	document.getElementById("userNameID").innerHTML=getLabel("Common.userid.label","Common");
	document.getElementById("passwordID").innerHTML=getLabel("Common.password.label","Common");
	document.getElementById("loginID").value=getLabel("Common.loginhome.label","Common"); //Modified by Suji Keerthi for PMG2021-COMN-CRF-0002
	document.getElementById("cancelID").value=getLabel("Common.cancelhome.label","Common"); //Modified by Suji Keerthi for PMG2021-COMN-CRF-0002
}
function facility_blur(obj){
	obj.setComboText((obj.getSelectedText()).replace(/\&amp;/g,'&'));
	document.getElementById("errMSGID0").style.display="None";
	document.getElementById("loginID").disabled=false;
	document.getElementById("loginID").style.cursor="hand";
	if(obj.getSelectedValue()==null){
		document.login_form.facility_id.value="";
		login_fac_flag=false;
	}else{
		login_fac_flag=true;
	}
}
function responsibility_blur(obj){
	document.getElementById("errMSGID0").style.display="None";
	document.getElementById("loginID").disabled=false;
	document.getElementById("loginID").style.cursor="hand";
	obj.setComboText((obj.getSelectedText()).replace(/\&amp;/g,'&'));
	if(obj.getSelectedValue()==null){
		document.login_form.responsibility_id.value="";
		login_resp_flag=false;
	}else{
		login_resp_flag=true;
	}
}

function noescUser() {
	return !(window.event && window.event.keyCode == 27);
}
function noescPassword() {
	return !(window.event && window.event.keyCode == 27);
}

//Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2
function checkADAndEMUserYN(obj){
	var loginID = trimString(obj.value);

	var xmlDoc=""
	var xmlHttp = new XMLHttpRequest()
	xmlStr = "<root><SEARCH  action='getADAndEMUserYN' loginID=\""+encodeURIComponent(loginID)+"\" /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../../eSM/jsp/SMIntermediate.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText = xmlHttp.responseText
	responseText = trimString(responseText)

	if(responseText == 'Y'){
		if(confirm(getMessage("LOGIN_AS_AD_OR_EM_USER","SM"))){
			document.forms[0].login_user_type.value = 'AD';
		}else{
			document.forms[0].login_user_type.value = 'EM';
		}
	}else{
		document.forms[0].login_user_type.value = '';
	}
}

