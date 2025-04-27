/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function apply()
{
	var fields = new Array (f_query_add_mod.document.forms[0].blngGrpID,
							f_query_add_mod.document.forms[0].custGrpCode,
							f_query_add_mod.document.forms[0].custCode,
							f_query_add_mod.document.forms[0].polNoInd,
							f_query_add_mod.document.forms[0].polTypeCode,
							f_query_add_mod.document.forms[0].userID) ;

	var names = new Array ("Billing Group",
							"Payer Group",
							"Payer",
							"Policy Number Indicator",
							"Policy Type Code",
							getLabel("eXH.AUTH_USER_ID.Label","xh"));

	if(!window.f_query_add_mod.checkFields( fields, names, messageFrame)) { 
	} 
	else {
		var polInd = f_query_add_mod.document.getElementById("polNoInd").value;
		if(polInd == "D") f_query_add_mod.document.getElementById("policyNo").value = f_query_add_mod.document.getElementById("dPolicyNo").value;
		window.f_query_add_mod.document.forms[0].submit();
	}

	window.commontoolbarFrame.document.location.reload();
}

function reset() 
{
	if(window.f_query_add_mod.document.forms[0])
	{
		window.f_query_add_mod.document.forms[0].reset();
	}
}

function initFunc()
{
	parent.messageFrame.location.href="../../eXH/jsp/DisplayRefResult.jsp?message="+document.getElementById("resultMessage").value;
}

function processPolInd()
{
	var polInd = document.getElementById("polNoInd").value;

	if(polInd == "D") document.getElementById("dPolicyNo").disabled = false;
	else 
	{
		document.getElementById("dPolicyNo").value = document.getElementById("policyNo").value;
		document.getElementById("dPolicyNo").disabled = true;		
	}
}
