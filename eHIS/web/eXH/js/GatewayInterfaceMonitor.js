async function showModal() {
		await window.showModalDialog(
						"../servlet/eXH.CentralizedServlet?frame=header&gatewayoperation=retrivegateway&gatewayserverID="
								+ document.getElementById("gatewayserverID").value+"&serverclientid="+document.getElementById("serverclientid").value+"&application="+document.getElementById("application").value+"&facility="+
								document.getElementById("facility").value+"&selectedcommunimode="+document.getElementById("selectedcommunimode").value
								+ "", " ",
						"dialogWidth:100vw; dialogHeight:100vh; dialogLeft:10;");

	}

async function showGatewayDisplay( param ) {
	await window.showModalDialog(
					"../servlet/eXH.CentralizedServlet?"+param
							+ "", " ",
					"dialogWidth:100vw; dialogHeight:100vh; dialogLeft:10; ");

}

	
	function retriveCommProcessApp() {
		alert();
		var dataElements = "operation=retrivegateway";
		$.ajax({
			type : "POST",
			async : true,
			url : '../servlet/eXH.CentralizedServlet',
			data : dataElements,
			success : function() {
				window.showModalDialog("/Centralizedcommunicationprocess.jsp");
			},
			dataType : 'text'
		});

	}

	function checkBoxChecked() {

	if (document.forms[0].mastercheckbox.checked == true) {
		if (document.forms[0].gatewayservers.length != undefined) {
			for ( var a = 0; a < document.forms[0].gatewayservers.length; a++) {
				document.forms[0].gatewayservers[a].checked = true;
			}
		} else if (document.forms[0].gatewayservers.length == undefined) {
			document.forms[0].gatewayservers.checked = true;
		}
	}
	else {
		if (document.forms[0].gatewayservers.length != undefined) {
			for ( var a = 0; a < document.forms[0].gatewayservers.length; a++) {
				document.forms[0].gatewayservers[a].checked = false;
			}
		} else if (document.forms[0].gatewayservers.length == undefined) {
			document.forms[0].gatewayservers.checked = false;
		}
	}
	return true;
}

	function dropdownBox() {
	
			var a = document.gatewayserverform.selectedcommunimode.selectedIndex;
			document.getElementById('communicmode').value = document.gatewayserverform.selectedcommunimode.options[a].value;
	
	}
	