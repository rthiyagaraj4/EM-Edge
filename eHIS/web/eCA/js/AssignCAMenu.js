	function create()
	{
		f_query_add_mod.location.href='../../eCA/jsp/AssignCAMenu.jsp?mode=insert';
	}

	function query()
	{
		f_query_add_mod.location.href='../../eCA/jsp/AssignCAMenuCriteria.jsp';
	}

	function apply()
	{
		if(f_query_add_mod.document.Assign_menu_form!=null)
		{
		var fields = new Array(f_query_add_mod.document.Assign_menu_form.menu_id1);

		var names = new Array (getLabel("Common.menu.label",'common'));
		
		if(checkFieldsofMst(fields, names, messageFrame))
		{
			f_query_add_mod.document.Assign_menu_form.submit();
		}
		}
		else
		{
			messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=';
			return false;
		}
	}

	function onSuccess(){
		if(f_query_add_mod.document.Assign_menu_form.mode.value=="insert"){
			f_query_add_mod.location.reload();
		}else{	
				if(f_query_add_mod.document.Assign_menu_form.mode.value=="modify"){
					//f_query_add_mod.location.reload();
				}else{
					 f_query_add_mod.location.href='../../eCommon/html/blank.html';
				}
		}
	}

	function deleterecord()
	{
		
		if(f_query_add_mod.document.Assign_menu_form!=null && f_query_add_mod.document.Assign_menu_form.mode!=null)
		{
			var mode = f_query_add_mod.document.Assign_menu_form.mode.value;

			if(mode != "insert"){
				var chkJsp = f_query_add_mod.location.href;
				var mode1="delete";
				var msg=getMessage("DELETE_RECORD",'common');
				if(confirm(msg) == true)
				{
					f_query_add_mod.document.Assign_menu_form.mode.value=mode1;
					f_query_add_mod.document.Assign_menu_form.submit();
				}
				else
				{
					commontoolbarFrame.location.reload();
				}
			}
			else
			{
			
				var error=getMessage("RECORD_CANNOT_DELETE",'CA');	
				messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error
			}
		}
		else
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}
	 
	function reset()
	{
	//CHL_CRF_005 Starts
			//if(f_query_add_mod.document.forms[0])
			//f_query_add_mod.document.forms[0].reset();
			if(f_query_add_mod.location.href.indexOf("AssignCAMenuCriteria.jsp") != -1)
			{	
					f_query_add_mod.location.reload();
					return false;
			}
			if(f_query_add_mod.document.forms[0] != null)
			{
			  if(f_query_add_mod.document.forms[0].mode.value=="insert")
			   f_query_add_mod.location.reload();
				if(f_query_add_mod.document.forms[0].mode.value=="modify")
				{
					f_query_add_mod.location.reload();
				}
			 
			}
			 messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp'
	 //CHL_CRF_005 Ends
	}

	
   function checkSpeciality(obj)
	{
			if(obj.value=="" || obj.value=="null"){
				obj.value=getLabel("Common.all.label","Common");
				document.forms[0].speciality_code2.value="*ALL";
			}
			if(obj.value!="" && obj.value!= getLabel("Common.all.label","Common")){
						var HTMLVal="<html><head><link ref='stylesheet' type='text/css' href='../../eCommon/html/IeStyle/css'> </link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown='lockKey()'> <form name=tempForm method=post action='../../eCA/jsp/AssignCAMenuSpecSearch.jsp'><input type=hidden name=specId value='"+obj.value+"'></form></body></html>"
						top.frames[1].frames[1].frames[2].document.write(HTMLVal);
						top.frames[1].frames[1].frames[2].document.tempForm.submit();
			}
	}

	function checkPractitioner(obj){		
		
		if(obj.value=="" || obj.value=="null"){
			//obj.value=getLabel("Common.all.label","Common");
			document.forms[0].practitioner_id1.value="*ALL";
			document.Assign_menu_form.flag.value='true';
			return false;
		}
		else
		{
		if(obj.value!="" && obj.value!= getLabel("Common.all.label","Common")){
				var HTMLVal="<html><head><link ref='stylesheet' type='text/css' href='../../eCommon/html/IeStyle/css'> </link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown='lockKey()'> <form name=tempForm method=post action='../../eCA/jsp/AssignCAMenuPracSearch.jsp'><input type=hidden name=pract value='"+obj.value+"'></form></body></html>";
				//top.frames[1].frames[1].document.write(HTMLVal);
				//top.frames[1].frames[1].document.tempForm.submit();
				parent.messageFrame.document.write(HTMLVal);
				parent.messageFrame.document.tempForm.submit();
			}
		}

		}
		
	async function getSpeciality()
	{
		var target				= document.Assign_menu_form.speciality_code1;
		var retVal				=  new String();
		var dialogTop			= "40";
		var dialogHeight		= "10" ;
		var dialogWidth			= "40" ;
		var features			="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments	= "" ;
		var search_desc="";
		var title=getLabel("eCA.SpecialitySearch.label","CA");
		var sql=" select speciality_code,short_desc from am_speciality where eff_status=`E`";
		
		search_code="speciality_code";
		search_desc="short_desc";
		retVal= await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(title,"UTF-8")+"&dispDescFirst=dispDescFirst",arguments,features);
		
		var arr=new Array();

		if (retVal != null && retVal != '' ){

			var retVal=unescape(retVal);
			arr=retVal.split("::");

		    document.Assign_menu_form.speciality_code1.value=arr[0];
			document.Assign_menu_form.speciality_code2.value=arr[1];
			document.Assign_menu_form.speciality_code1.focus();
		}
		
	}
	
	function getPractitioners(obj)
	{
		if(obj.name=='practitioner_id2')
		{
			checkPractitioner(obj);
		}
		else if(obj.name=='prac_desc_search')
		{
			
		if(document.Assign_menu_form.flag.value=='false')
			return false;
		else
			getPractitioner();
		
		}
	}

	//getPractitioner()
async function getPractitioner()
	{
		var target=document.Assign_menu_form.practitioner_id2;		
		var retVal=  new String();
		var dialogTop	= "40";
		var dialogHeight= "10" ;
		var dialogWidth= "40" ;
		var features= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments	= "" ;
		var search_desc	= "";
		var title=getLabel("Common.practitioner.label","Common");

		var sql="select practitioner_id code,short_name description from am_practitioner where eff_status='E' and upper(short_name ) like upper(?) and upper(practitioner_id) like upper(?)";

				var argArray = new Array();
				var namesArray = new Array();
				var valuesArray = new Array();
				var datatypesArray = new Array();
				argArray[0] = sql;
				argArray[1] = namesArray;
				argArray[2] = valuesArray;
				argArray[3] = datatypesArray;
				argArray[4] = "2,1";
				argArray[5] = target.value;
				argArray[6] = DESC_LINK;
				argArray[7] = DESC_CODE;
				if(document.forms[0].practitioner_id2.value!="All" )
				{
						 retArray = await CommonLookup(title,argArray);
						 var ret1=unescape(retArray);
							var arr=ret1.split(",");
							if(arr[1]==undefined) 
							{
								arr[0]="";	
								arr[1]="";	
							}
						if(retArray != null && retArray !="")
						{
								document.forms[0].practitioner_id2.value = arr[1];
								document.forms[0].practitioner_id1.value=arr[0];
								//document.forms[0].service_desc_search.disabled=false;
						}
						else
						{
								document.forms[0].practitioner_id2.value= getLabel("Common.all.label","Common");
								document.forms[0].practitioner_id1.value="*ALL";
								//document.forms[0].service_desc_search.disabled=false;
						}
				}
					document.Assign_menu_form.flag.value='true'

	}

	function getvalue(){
		document.Assign_menu_form.menu_id_hddn.value=document.Assign_menu_form.menu_id1.value;
		var me_id=document.Assign_menu_form.menu_id1.value;
	}
	

	function CheckForSpecCharsWithSpaceBlur(ObjText)
	{
		var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*& ';//CHL_CRF_005
		var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_-/ ';//CHL_CRF_005
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);  // Get key value from key code
		if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
		return true ;
	}


	function resetValues()
	{
	
	   parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
		
	}
	function setValue()
	{
		document.Assign_menu_form.flag.value='false';
	}
	async function callfunction()
	{
		var target=parent.frames[1].document.forms[0].speciality_code1;
		var splval= parent.frames[1].document.forms[0].speciality_code1.value;
		var retVal=  new String();
		var dialogTop	= "40";
		var dialogHeight= "10" ;
		var dialogWidth= "40" ;
		var features= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments	= "" ;
		var search_desc	= "";
		var title=getLabel("Common.speciality.label","COMMON");

		var sql="SELECT speciality_code code, short_desc description from am_speciality where eff_status='E' and upper(short_desc) like upper(?) and upper(speciality_code) like upper(?)";

				var argArray = new Array();
				var namesArray = new Array();
				var valuesArray = new Array();
				var datatypesArray = new Array();
				argArray[0] = sql;
				argArray[1] = namesArray;
				argArray[2] = valuesArray;
				argArray[3] = datatypesArray;
				argArray[4] = "2,1";
				argArray[5] = target.value;
				argArray[6] = DESC_LINK;
				argArray[7] = DESC_CODE;
				if(parent.frames[1].document.forms[0].speciality_code1.value!="ALL" && parent.frames[1].document.forms[0].speciality_code1.value!="")
				{
						retArray =await CommonLookup(title,argArray);
						var str =unescape(retArray);
						var arr = str.split(",");
						if(retArray != null && retArray !="")
						{
								parent.frames[1].document.forms[0].speciality_code1.value = arr[1];
								parent.frames[1].document.forms[0].speciality_code2.value=arr[0];
								parent.frames[1].document.forms[0].service_desc_search.disabled=false;
						}
						else
						{
								parent.frames[1].document.forms[0].speciality_code1.value= "All";
								parent.frames[1].document.forms[0].speciality_code2.value="*ALL";
								parent.frames[1].document.forms[0].service_desc_search.disabled=false;
						}
				}
					parent.frames[2].location.href='../../eCommon/jsp/error.jsp';
		}

			
	async function callfunction1()
	{
			
			var target=parent.frames[1].document.forms[0].practitioner_id2;
			var practval= parent.frames[1].document.forms[0].practitioner_id2.value;
			var retVal=  new String();
			var dialogTop	= "40";
			var dialogHeight= "10" ;
			var dialogWidth= "40" ;
			var features= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
			var arguments	= "" ;
			var search_desc	= "";
			var title=getLabel("Common.practitioner.label","COMMON");
			var sql="SELECT practitioner_id code,short_name description FROM am_practitioner where EFF_STATUS ='E' and upper( short_name) like upper(?) and upper(practitioner_id) like upper(?)";
			var argArray = new Array();
			var namesArray = new Array();
			var valuesArray = new Array();
			var datatypesArray = new Array();
			argArray[0] = sql;
			argArray[1] = namesArray;
			argArray[2] = valuesArray;
			argArray[3] = datatypesArray;
			argArray[4] = "2,1";
			argArray[5] = target.value;
			argArray[6] = DESC_LINK;
			argArray[7] = DESC_CODE;
			if(parent.frames[1].document.forms[0].practitioner_id2.value!=getLabel("Common.all.label","Common") && parent.frames[1].document.forms[0].practitioner_id2.value!=""){
				retArray =await CommonLookup(title,argArray);
				var str =unescape(retArray);
				var arr = str.split(",");
					if(retArray != null && retArray !=""){
						parent.frames[1].document.forms[0].practitioner_id2.value = arr[1];
						parent.frames[1].document.forms[0].practitioner_id1.value=arr[0];
						parent.frames[1].document.forms[0].prac_desc_search.disabled=false;
					}else {
						parent.frames[1].document.forms[0].practitioner_id2.value = getLabel("Common.all.label","Common");
						parent.frames[1].document.forms[0].practitioner_id1.value = "*ALL";
						parent.frames[1].document.forms[0].prac_desc_search.disabled=false;
			}
		}
		parent.frames[2].location.href='../../eCommon/jsp/error.jsp';
}
//IN035912 Starts
function func_assign()
{
	document.Assign_menu_form.legendSummary.value= document.Assign_menu_form.summary.value;
	document.Assign_menu_form.legendNavigation.value= document.Assign_menu_form.navigation.value;
}

function CheckForSpecCharsWithCopyPaste(textObj)
{
	
	var ValidChars = /^[0-9a-zA-Z-_\/]*$/; 
	var pasteData = window.clipboardData.getData("Text"); 
	pasteData = trimString(pasteData);
	
	if(ValidChars.test(pasteData))
	{
		
		textObj.value = pasteData;
	}
	else 
		return false; 
}
//IN035912 Ends
//IN036733 Starts
function showPreview()
{
	var MenuPreviewPage='MenuPreviewPage';
	var menuid = parent.f_query_add_mod.document.Assign_menu_form.menu_id1.value;
	//IN043533 Starts
	//window.open('../../eCA/jsp/CAMainMenu.jsp?menuId='+menuid+'&MenuPreviewPage='+MenuPreviewPage,'MenuPreview',' height= 500, width= 250,left = 500, top=100, status=no,scrollbars=yes,toolbar=no,fullscreen=no,location=no');
	if(menuid != null && menuid !=" ")
	{
		//window.open('../../eCA/jsp/CAMainMenu.jsp?menuId='+menuid+'&MenuPreviewPage='+MenuPreviewPage,'MenuPreview',' height= 500, width= 250,left = 500, top=100, status=no,scrollbars=yes,toolbar=no,fullscreen=no,location=no');//IN043597
		window.open('../../eCA/jsp/AssignCAMenuPreview.jsp?menuId='+menuid+'&MenuPreviewPage='+MenuPreviewPage,'MenuPreview',' height= 500, width= 250,left = 500, top=100, status=no,scrollbars=yes,toolbar=no,fullscreen=no,location=no');//IN043597
	}
	else
	{
		alert(getMessage("CA_SELECT_MENU",'CA'));
	}	
	//IN043533 Ends
}
//IN036733 Ends

