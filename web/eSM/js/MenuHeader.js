function create() {

	f_query_add_mod.location.href = "../../eSM/jsp/MenuHeader_Form.jsp" ;
}

function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {
	f_query_add_mod.location.href ="../../eSM/jsp/queryMenuHeaderPage.jsp";
}

function apply() 
{ 
//alert("apply");
if(f_query_add_mod.document.menu_form)
	{
	if(f_query_add_mod.document.menu_form.adhocmenu.disabled == false && f_query_add_mod.document.menu_form.adhocmenu.checked == true)
	{
		var fields=new Array(f_query_add_mod.document.menu_form.menuid,f_query_add_mod.document.menu_form.menuname,f_query_add_mod.document.menu_form.tool_used,f_query_add_mod.document.menu_form.from_date,f_query_add_mod.document.menu_form.to_date);
       
		var names = new Array (getLabel("Common.identification.label","Common"), getLabel("Common.name.label","Common"),getLabel("eSM.ToolUsed.label","SM"),getLabel('eSM.AdhocMenuEffectiveDate.label','SM')+""+getLabel('Common.from.label','Common'),getLabel('eSM.AdhocMenuEffectiveDate.label','SM')+""+getLabel('Common.to.label','Common'))
	}
	else
	{
		var fields=new Array(f_query_add_mod.document.menu_form.menuid,f_query_add_mod.document.menu_form.menuname,f_query_add_mod.document.menu_form.tool_used);
		var names = new Array (getLabel("Common.identification.label","Common"), getLabel("Common.name.label","Common"),getLabel("eSM.ToolUsed.label","SM"));
	} 
	var field=new Array(f_query_add_mod.document.menu_form.menuid);
	var name = new Array (getLabel("Common.identification.label","Common"));

	if(f_query_add_mod.CheckMaxLen1(getLabel("Common.remarks.label","Common"),f_query_add_mod.document.menu_form.remarks,200,messageFrame))
	{
		if(f_query_add_mod.checkFieldsofMst(fields,names,messageFrame))
		{
			if (f_query_add_mod.SpecialCharCheck (field,name,messageFrame,'M','MstCodeError.jsp'))
				{
					if(f_query_add_mod.document.menu_form.rootmenu.checked == true)
						f_query_add_mod.document.menu_form.rootmenu.value = "Y";

					if(f_query_add_mod.document.menu_form.from_date.value != "")
						f_query_add_mod.document.menu_form.adhocmenu.value = "Y";

					f_query_add_mod.document.menu_form.tool_used.disabled = false;
					f_query_add_mod.document.menu_form.rootmenu.disabled=false; //Added on 3/23/2005
f_query_add_mod.document.forms[0].action="../../servlet/eSM.MenuHeaderServlet";
f_query_add_mod.document.forms[0].target="messageFrame";
					f_query_add_mod.document.menu_form.submit();
				}
				var fn_status = f_query_add_mod.document.menu_form.function_name.value ;
		}

	}
	}
	else
	{
		frames[0].location.reload();
		return false;
	}
}

function onSuccess() {
frames[0].document.location.reload();
}

function reset() {

    if(  f_query_add_mod.document.forms[0])
		//f_query_add_mod.document.forms[0].giffrom.style.visibility="hidden";
	    //f_query_add_mod.document.forms[0].gifto.style.visibility="hidden";
		//f_query_add_mod.document.forms[0].reset() ;
		f_query_add_mod.document.location.reload();
}

function CheckForNumber(obj) 
	{
		
		if (obj.value.length > 0 )
		{
			if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0)
			{		
				alert(getMessage('INVALID_INTEGER','SM'));
				obj.value='';
				obj.select();
				obj.focus();
				return false;
			}

		}
	}

	function CheckSpecialChar(obj)
	{
		
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
		SpChar[32] = '0';
		SpChar[33] = '1';
		SpChar[34] = '2';
		SpChar[35] = '3';
		SpChar[36] = '4';
		SpChar[37] = '5';
		SpChar[38] = '6';
		SpChar[39] = '7';
		SpChar[40] = '8';
		SpChar[41] = '9';

		if (fieldval.substr(0,1) == '_' ) 
		{
			to_check = false;
		}

		for (var i=0;i<fieldlen;i++)
		{

			if (fieldval.substr(i,1) == ' ' || fieldval.substr(i,1) == null)
			{
				to_check = false;
			}

			for (var j=0;j<=41;j++)
			{
				if (fieldval.substr(i,1) == SpChar[j])
				{
					to_check = false;
				}
			}
		}

		if (to_check == false)
		{
			alert(getMessage('ONLY_ALPHABETS','SM'));
			obj.select();
			obj.focus();
			obj.value='';
		}
	}

	function assign_resp(obj)
	{
		document.forms[0].resp_group_id1.value=obj.value;
	}

	function CheckSubMenu()
	{
		
		if (document.forms[0].rootmenu.checked==true)
		{
			if (document.forms[0].submenu_id.value=="Y")
			{
				alert(getMessage('MENU_CANNOT_ROOTMENU','SM'));			
				document.forms[0].rootmenu.select();
				document.forms[0].rootmenu.focus();
				document.forms[0].rootmenu.checked=false;
				document.forms[0].rootmenu.value = "N";
			}
			else
			{
				 document.forms[0].rootmenu.checked=true;
				 document.forms[0].rootmenu.value = "Y";
				 document.forms[0].adhocmenu.disabled = false;
			}
		}
		else
		{
			document.forms[0].rootmenu.checked=false;
			document.forms[0].adhocmenu.checked = false;
			document.forms[0].adhocmenu.disabled = true;
			document.forms[0].from_date.value = "";
			document.forms[0].to_date.value = "";
			document.forms[0].from_date.readOnly = true;
			document.forms[0].to_date.readOnly = true;
			document.getElementById("from_cal").disabled = true;
			document.getElementById("to_cal").disabled = true;
			document.getElementById("giffrom").style.visibility="hidden";
			document.getElementById("gifto").style.visibility="hidden";
		}
	}

	function CheckAdhocMenu()
	{

		if (document.forms[0].adhocmenu.checked == true)
		{
			document.forms[0].adhocmenu.value = "Y";
			document.forms[0].from_date.readOnly = false;
			document.forms[0].to_date.readOnly = false;
			document.getElementById("from_cal").disabled = false;
			document.getElementById("to_cal").disabled = false;
			document.getElementById("giffrom").style.visibility="visible";
			document.getElementById("gifto").style.visibility="visible";
		}
		else
		{
			document.forms[0].adhocmenu.value = "N";
			document.forms[0].from_date.value = "";
			document.forms[0].to_date.value = "";
			document.forms[0].from_date.readOnly = true;
			document.forms[0].to_date.readOnly = true;
			document.getElementById("from_cal").disabled = true;
			document.getElementById("to_cal").disabled = true;
			document.getElementById("giffrom").style.visibility="hidden";
			document.getElementById("gifto").style.visibility="hidden";
		}
	}

	function CheckMaxLen1(lab,obj,max,messageFrame) {

			if(obj.value.length > max) {
			    messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("REMARKS_NOT_EXCEED_200_CH",'SM');
				return false;
			} else return true;
	}

	function trimcheck(obj) {
	var msg = self.getMessage("MENU_ID_NO_SPACE","SM");
	var inString = obj.value;
	var startPos;
	var ch;
	startPos = 0;
	strlength = inString.length;

	for(var i=0;i<=strlength;i++) {
		ch = inString.charAt(i);
		if((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
			startPos++;
		}
	}
	if(startPos >0) {
		alert(msg);
		obj.focus();
		obj.select();
	}
	else return true;
}

   function gifpop(adhoc_menu)
		{	
			
			var diffdate1 = document.forms[0].diffdate1.value;
			if(diffdate1 >0)
			{
			document.forms[0].from_date.readOnly = true;
			document.getElementById("from_cal").disabled =true;
			document.forms[0].to_date.readOnly = false;
			document.getElementById("to_cal").disabled = false;
			}
			else{
			if(adhoc_menu == "Checked")
			{
				document.forms[0].adhocmenu.disabled = false;
				document.forms[0].from_date.readOnly = false;
				document.forms[0].to_date.readOnly = false;
				document.getElementById("from_cal").disabled =false;
				document.getElementById("to_cal").disabled = false;
				document.getElementById("giffrom").style.visibility="visible";
				document.getElementById("gifto").style.visibility="visible";
			}
			else
			{
				document.getElementById("giffrom").style.visibility="hidden";
				document.getElementById("gifto").style.visibility="hidden";
			}
			}
		}

/** Added for Date Validation **/

function ChkDates1(obj)
 {
     if(obj.value != "")
	 {
		if(validDateObj(obj,"DMY",localeName))
				  {
					DateValidation(obj);
				  }
	 }
	 if(document.forms[0].from_date.value!="" && document.forms[0].to_date.value!="")
					{
							 if(!(isBefore(document.forms[0].from_date.value,document.forms[0].to_date.value,"DMY",localeName)))
								{
									    alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
										document.forms[0].to_date.value='';
										document.forms[0].to_date.select();
										document.forms[0].to_date.focus();
								}	
					}
}

function ChkDates(obj)
 {
		if(validDateObj(obj,"DMY",localeName))
				  {
					DateValidation1(obj);

					if(document.forms[0].from_date.value!="" && document.forms[0].to_date.value!="")
					{
							 if(!(isBefore(document.forms[0].from_date.value,document.forms[0].to_date.value,"DMY",localeName)))
								{
									    alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
									    obj.value='';
										obj.select();
										obj.focus();						
								}	
					}
				  }
 }

function DateValidation(obj)
{
   var msg="";
	if(obj.name=="from_date")
	   msg = getMessage("FROM_DATE_LESS_SYSDATE","SM");
	if((!isAfterNow(obj.value,"DMY",localeName)))
	{
		obj.focus();
		obj.select();
		obj.value='';
		alert(msg);
	}
}

function DateValidation1(obj)
{
   var msg="";
	if(obj.name=="to_date")
	   msg = getMessage("TO_DATE_LESS_SYSDATE","SM");
	if(!(isAfterNow(obj.value,"DMY",localeName)))
	{
		obj.focus();
		obj.select();
		obj.value='';
		alert(msg);
	}
}
