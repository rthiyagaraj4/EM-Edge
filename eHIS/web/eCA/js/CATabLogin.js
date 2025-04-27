/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      		Name        		Rev.Date				Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------------------------------
25/01/2019		IN057997			Kamalakannan G	  		25/01/2019				Ramesh G.		AAKH-CRF-0079
---------------------------------------------------------------------------------------------------------------------------------------------
*/
function trim(myString) {
	return myString.replace(/^\s+|\s+$/g, '');
}

function submit_user_pwd() {
	xmlStr = "<root><SEARCH ";
	xmlStr += " name=\"" + document.forms[0].name.value + "\"";
	xmlStr += " password=\"" + document.forms[0].password.value + "\"";
	xmlStr += " level=\"" + document.forms[0].level.value + "\"";
	xmlStr += " mode=\"" + document.forms[0].mode.value + "\"";
	xmlStr += " compname=\"" + document.forms[0].compname.value + "\"";
	xmlStr += " domain=\"" + document.forms[0].domain.value + "\"";
	xmlStr += " ext_user_yn=\"Y\"";
	xmlStr += " /></root>";
	var xmlDoc;
	var xmlHttp;
	if (navigator.appName.indexOf("Internet") == -1) {
		xmlHttp = new XMLHttpRequest();
		var oParser = new DOMParser();
		xmlDoc = oParser.parseFromString(xmlStr,"text/xml");

	} else {
		xmlHttp = new XMLHttpRequest();
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	}
	xmlHttp.open("POST", contextPath+"/servlet/eSM.LoginResponseServlet", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText ;
	var rText = "";
				rText = responseText;
				if (rText != null)
					rText = rText.replace(/^\s+|\s+$/g, '');
			
				if (rText != null && rText != "home.jsp") {
					var result = rText.split("||");
					var result0 = result[0];
					var result1 = result[1];
					var result2 = result[2];
					
					if (result0 == "error_num=1") {
						var result1plt = result2.split("=");
						document.getElementById("errMSGID0").style.display="block";
						document.getElementById("errMSGID").innerHTML=result1plt[1];
					}else {
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
						if( respcount == "0" || facCount == "0" ){
							alert("You do not have sufficient rights to Login");
						
						}
						else if (respcount == "1" && facCount == "1") { // checks whether the
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
							var loginformObj = document.getElementById("login_form");							
							if (loginformObj) {
								loginformObj.action = contextPath+"/tablogin";
								loginformObj.submit();
							}
						} 
						else 
						{ // IF there are morethan one responsibilityID
							var RespFaciHdnObj = document.getElementById("RespFaciList");
							var loginformObj = document.getElementById("login_form");
							if (RespFaciHdnObj) {
								RespFaciHdnObj.value = result2;
							}
							if (loginformObj) {
								loginformObj.action = contextPath+"/tablogin";
								loginformObj.submit();
							}

						}
					}
				}	
}

