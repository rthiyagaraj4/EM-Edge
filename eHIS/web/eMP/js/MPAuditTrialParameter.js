function create() 
{	}

function query() 
{	}

function apply() 
{
//if(auditTrialFrame.document.forms[0].
	for(var i=0;i < auditTrialFrame.document.forms[0].elements.length; i++)
	{
		if (auditTrialFrame.document.forms[0].elements[i].type=='checkbox')
		{
			if(auditTrialFrame.document.forms[0].elements[i].checked)
				auditTrialFrame.document.forms[0].elements[i].value = "Y";
			else
				auditTrialFrame.document.forms[0].elements[i].value = "N";
		}
	}
	auditTrialFrame.document.forms[0].submit();
}


function reset() 
{
	auditTrialFrame.document.forms[0].reset();
}

function onSuccess() 
{
	auditTrialFrame.location.href ="../../eMP/jsp/MPAuditTrialParameter.jsp" ;
}

