//******************************************************************************************/
// function funSubmit
//******************************************************************************************/
function funSubmit()
{
	// #MOD#01
	var act = '../../eXH/jsp/DataElementCrossRefModuleCodeSetup.jsp';
	this.document.forms[0].action = act;
	this.document.forms[0].submit(); 
}
//******************************************************************************************/
// function funAction
//******************************************************************************************/

function funAction(typ)
{
	document.forms[0].action_type.value = typ;
	funSubmit();
}
//******************************************************************************************/
// function chkvalidate
//******************************************************************************************/
function chkvalidate(obj)
{
	var oval=obj.value;
	if(oval!=''){
	var val1=obj.getAttribute("temp");
	var dd=document.getElementById(val1);  
	if(dd.value=='')
	{
		alert(getMessage('XH1023','XH'));
        dd.focus();
		return false;
    }  
	}

}
//******************************************************************************************/
//function funMasterCode
//******************************************************************************************/
function funMasterCode()
{
	if(this.document.forms[0].nontabelementid.value!='N') 
	{

parent.applnontablecode.document.location.href='../../eXH/jsp/DataElementCrossRefNonTableValuesSetupMain1.jsp?applicationid='+document.forms[0].applicationid.value+'&nontabelementid='+document.forms[0].nontabelementid.value;

		//this.document.forms[0].submit();
	}
	else{
         alert(getMessage( 'XH1055','XH' ));
	}
}      
//*********************************************************** *************/  
