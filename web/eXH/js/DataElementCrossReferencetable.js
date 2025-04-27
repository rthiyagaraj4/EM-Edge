//************************************************************************/
//function funFacility
//***************************************************************************/

function funFacility(obj)
{
}
//*************************************************************************/
//function funMasterCode
//***************************************************************************/

function funMasterCode()
{

if(this.document.forms[0].modulemaster.value=='')
	{
alert(getMessage('XH1054','XH'));
return false;
	}

	parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
	this.document.forms[0].submit();
}
//***************************************************************************/
//function funSelect
//***************************************************************************/

function funSelect(obj)
{
	var i = obj.selectedIndex;
	this.document.forms[0].mastertableid.value = obj.value;
	this.document.forms[0].moduleid.value = obj.options[i].getAttribute('moduleid')
	this.document.forms[0].facilitybased.value = obj.options[i].getAttribute('facility_based_yn')

}

//***************************************************************************/
//***************************************************************************/
