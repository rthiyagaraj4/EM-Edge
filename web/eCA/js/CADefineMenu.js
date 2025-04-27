/**	
* 	Application		:	eHIS/eCA
*	File name       :   CADefineMenu.js	
*	Created By		:	Deepa s
*	Created On		:	2nd Mar 2004.
*/

function create()
{
	f_query_add_mod.location.href='../../eCA/jsp/CADefineMenu.jsp?mode=insert';
}
function query()
{
	f_query_add_mod.location.href='../../eCA/jsp/CADefineMenuQueryCriteria.jsp';
}
function apply()
{
	if(f_query_add_mod.document.formCADefineMenu!=null)
	{
	var fields = new Array (f_query_add_mod.document.formCADefineMenu.menu_id,
							f_query_add_mod.document.formCADefineMenu.short_desc,
							f_query_add_mod.document.formCADefineMenu.long_desc);
	var names = new Array ( f_query_add_mod.getLabel("Common.identification.label",'common'),f_query_add_mod.getLabel("Common.shortdescription.label",'common'),f_query_add_mod.getLabel("Common.longdescription.label",'common'));
	var fields_1 = new Array (f_query_add_mod.document.formCADefineMenu.root_menu_yn,
							f_query_add_mod.document.formCADefineMenu.desktop_yn,
							f_query_add_mod.document.formCADefineMenu.paitent_chart);
	var names_1 = new Array ( f_query_add_mod.getLabel("eCA.RootMenu.label",'CA'),f_query_add_mod.getLabel("eCA.Desktop.label",'CA'),f_query_add_mod.getLabel("Common.PatientChart.label",'common'));
	if(( f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) ){			
		if(RootMenuCheck(fields_1, names_1, messageFrame))
		{
			f_query_add_mod.document.formCADefineMenu.submit();
		}
	}
	}
	else
	{
	
	messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;

	}
	
}
function onSuccess()
{
	if(f_query_add_mod.document.formCADefineMenu.mode.value=="insert"){
		f_query_add_mod.location.reload();
	}
	else 
	{
		if(f_query_add_mod.document.formCADefineMenu.mode.value=="modify"){
			f_query_add_mod.location.reload();
		}
		else{
			f_query_add_mod.location.href='../../eCommon/html/blank.html';
		}
	}
}
/*function reset()
{
	if(f_query_add_mod.document.forms[0].name=="formCADefineMenu"){
		f_query_add_mod.location.reload();
		f_query_add_mod.document.getElementById("root").style.display="none";
	}
	else
		f_query_add_mod.location.reload();
}*/

/*function reset(){
	if(f_query_add_mod.document.forms[0]!=null){
	if(f_query_add_mod.document.forms[0].mode != null)
	{
	if(f_query_add_mod.document.forms[0].mode.value=="insert" || f_query_add_mod.document.forms[0].mode.value=="modify")
		f_query_add_mod.location.href='../../eCA/jsp/CADefineMenu.jsp';
	
	}
	else
		f_query_add_mod.location.href='../../eCA/jsp/CADefineMenuQueryCriteria.jsp';
}
}*/

function reset()
{
	if(f_query_add_mod.document.forms[0])
		f_query_add_mod.document.forms[0].reset();
}

function RootMenuCheck( fields_1, names_1, messageFrame)
{
	var errors = "" ;
	if(fields_1[0].value=='Y'){
		if(fields_1[1].value=='Y' || fields_1[2].value=='Y')
		{
			fields_1[1].value = trimString(fields_1[1].value);
			fields_1[2].value = trimString(fields_1[2].value);
		}
        else{
			errors = errors + getMessage("DTP_PAT_CHART_SEL","CA"); + "<br>" ;
		}
    }
	if ( errors.length != 0 ) {
        messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
        return false ;
    }
    return true ;
}
function CheckSpecChar(event){
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_* ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return true ;
}
function func_assign(){
	document.formCADefineMenu.short_desc.value= document.formCADefineMenu.short_desc_hddn.value;
	document.formCADefineMenu.long_desc.value= document.formCADefineMenu.long_desc_hddn.value;
}
function fun_chk(){
	if(document.formCADefineMenu.root_menu_yn_hddn.checked==true)
	{
		document.getElementById("root").style.display="inline";
		document.formCADefineMenu.root_menu_yn_hddn.value="Y";
		document.formCADefineMenu.root_menu_yn.value= document.formCADefineMenu.root_menu_yn_hddn.value;				
	}
	else
	{
		document.getElementById("root").style.display="none";
		document.formCADefineMenu.root_menu_yn_hddn.value="";
		document.formCADefineMenu.root_menu_yn.value="";
		document.formCADefineMenu.desktop_yn_hdn.checked=false;
		document.formCADefineMenu.paitent_chart_hdn.checked=false;
		document.formCADefineMenu.desktop_yn.value="N";
		document.formCADefineMenu.paitent_chart.value="N";

	}
}
function func_desktop_check()
{

	if(document.formCADefineMenu.desktop_yn_hdn.checked==true){
			document.formCADefineMenu.desktop_yn.value="Y";
	}
	else{
		document.formCADefineMenu.desktop_yn.value="N";
	}
}

function func_patChart_check()
{
	if(document.formCADefineMenu.paitent_chart_hdn.checked==true){
		document.formCADefineMenu.paitent_chart.value="Y";
	}
	else{
		document.formCADefineMenu.paitent_chart.value="N";
	}
}


