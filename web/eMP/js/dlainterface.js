/**************************** dalinterface.js ***********************/
 
function storeVal(currad) {
    radioval=currad.value;

	var div1=document.getElementById("national_div");
    var div2=document.getElementById("name_div");

    if(radioval=='N')
    {
	   div1.style.display="block";
	   div2.style.display="none";
	   this.document.forms[0].d_flag.value="N";
	   this.document.forms[0].first_name.value="";
	   this.document.forms[0].sur_name.value="";
	   this.document.forms[0].national_id_name.focus();	
    }
    if(radioval=='S')
    {
       div2.style.display="block";
	   div1.style.display="none";
	   this.document.forms[0].d_flag.value="S";
	   this.document.forms[0].national_id_name.value="";
	   this.document.forms[0].first_name.focus();	
    }

	parent.action_frame.location.href="../../eCommon/html/blank.html";
}

function serachFunction()
{  	

	parent.message_frame.location.href="../../eCommon/html/blank.html";	

//	Clearing action frame on click of every search
	top.action_frame.document.open();
	top.action_frame.document.write('<body color="white">');
	top.action_frame.document.close();
	
	var fun_id=this.document.forms[0].fucntion_id.value;

//	Clearing image frame on click of every search
	if(parent.image_frame)	
	{
	//	top.image_frame.location.href="../../eCommon/html/blank.html";
		top.image_frame.document.open();
		top.image_frame.document.write('<body color="white">');
		top.image_frame.document.close();
	}

	var sir_user=this.document.forms[0].user_name.value;
	var sir_password=this.document.forms[0].pass_word.value;

	var dla_user_id=getLabel("eMP.DLAUserID.label","MP");	
	var dla_password=getLabel("Common.password.label","Ccommon");

	if(sir_user=="")
	{
		var field= this.document.forms[0].user_name;
		var name = getLabel("eMP.DLAUserID.label","MP");	
		checkField( field, name);
	}
	else if(sir_password=="")
	{
		var field= this.document.forms[0].pass_word;
		var name = getLabel("Common.password.label","Ccommon");						
		checkField( field, name);
	} 
	else if(this.document.forms[0].d_flag.value=='N')
	{
		var sir_national_id_name=this.document.forms[0].national_id_name.value;

		if(sir_national_id_name=="")
		{
			var field= this.document.forms[0].national_id_name;
			var name = this.document.forms[0].nat_id_prompt.value;						
			checkField( field, name);
		}
		else if(!CheckNum(this.document.forms[0].national_id_name))
		{
		}
		else
		{				
			parent.message_frame.location.href="../../eCommon/html/process.html";							

			var act = '../../servlet/eMP.DLATransactionServlet';

			this.document.forms[0].action = act;
			this.document.forms[0].target='action_frame';
			this.document.forms[0].submit();			
		}
	}
	else if(this.document.forms[0].d_flag.value=='S')
	{ 
		var sir_first_name=this.document.forms[0].first_name.value;
		var sir_sur_name=this.document.forms[0].sur_name.value;

		if(sir_first_name=="")
		{
			var msg_dla=getMessage('NOT_BLANK','MP');
			msg_dla=msg_dla.replace('%',this.document.forms[0].first_name_prompt.value);			
			alert(msg_dla); 
			this.document.forms[0].first_name.focus();
		}
		else
		{
			parent.message_frame.location.href="../../eCommon/html/process.html";			
			var act = '../../servlet/eMP.DLATransactionServlet';
			this.document.forms[0].action = act;
			this.document.forms[0].target='action_frame';
			this.document.forms[0].submit();
		}

	}
}	

function resetForm()
{  
	     this.document.forms[0].reset();
		 this.document.forms[0].d_flag.value='N'
		 storeVal(this.document.forms[0].d_flag);
		 parent.action_frame.location.href="../../eCommon/html/blank.html";
		 parent.message_frame.location.href="../../eCommon/html/blank.html";
}


function getAccept()
{
	
	var formObj = parent.action_frame.view_dla_interface_result_form;	
	var imageFormObj = parent.image_frame.view_dla_interface_result_form1;
			
	var usrname = formObj.usr_name.value;
	var surname = formObj.sur_name.value;
	var usrgender = formObj.gender.value;
	var usrdob = formObj.usr_dob.value;
	var usrfname = formObj.father_name.value;
	var usrmname = formObj.mother_name.value;
	var usrnation = formObj.nat_code.value;	
	var usrnid = formObj.national_id.value;
	var loc_code = formObj.loc_code.value;
	var isFromOracleDB = "false";
	var patient_id = formObj.patient_id.value;
	var town = formObj.dla_town.value;
	var area = formObj.dla_area.value;
	var region = formObj.dla_region.value;
	var town_code = formObj.dla_town_code.value;
	var area_code = formObj.dla_area_code.value;
	var region_code = formObj.dla_region_code.value;
	var usr_title_eng = formObj.ret_title_eng.value;
	var usr_title_thai = formObj.ret_title_thai.value;
	var deceasedYN = formObj.deceased_yn.value;
	var deceased_date = formObj.deceased_date.value;
	var dla_image_yn = imageFormObj.dla_image_yn.value;
	var middleName = formObj.middleName.value;
	var estDOB = formObj.estDOB.value;	

	var addr1 = formObj.address_1.value;
	var addr2 = formObj.address_2.value;
	var addr3 = formObj.address_3.value;
	var addr4 = formObj.address_4.value;

	var usraddr = addr1 + addr2 + addr3 + addr4;
	
	window.returnValue = usrname+"|"+surname+"|"+usrgender+"|"+usrdob+"|"+usrfname+"|"+usrmname+"|"+usrnation+"|"+usraddr+"|"+usrnid+"|"+loc_code+"|"+isFromOracleDB+"|"+patient_id+"|"+town+"|"+area+"|"+region+"|"+usr_title_eng+"|"+deceasedYN+"|"+deceased_date+"|"+usr_title_thai+"|"+addr1+"|"+addr2+"|"+addr3+"|"+addr4+"|"+town_code+"|"+area_code+"|"+region_code+"|"+dla_image_yn+"|"+middleName+"|"+estDOB;
	window.close();
}

function dispAttr()
{
	var formObj=parent.image_frame.view_dla_interface_result_form1;
	
	var isFromOracle=formObj.isFromOracleDB.value;
	var nat_id=formObj.nat_id.value;
	var national_id=formObj.national_id.value;
	var function_id=formObj.function_id.value;
	
	if(isFromOracle == "true")
	{
		var msg=getMessage('DUP_NAT_ID','MP');
		msg=msg.replace('#',nat_id);
		parent.image_frame.location.href="../../eCommon/html/blank.html";
		parent.action_frame.location.href="../../eCommon/html/blank.html";
		alert(msg);					
	}
	else
	{		
		document.getElementById("image_body").style.visibility="visible";
	//	Commented the below code for SRR20056-SCF-5529 [IN:024247] by Suresh M on 09.12.2010
		//parent.action_frame.location.href="../../eMP/jsp/DlauiInterfaceSearchResult.jsp?national_id="+national_id;
	}
}

function chkAlphaNumeric(obj)
{
	var iChars = "!@#$%^&*()+=[]\';,/{}|\":<>?";
	
	for (var i = 0; i < obj.value.length; i++) 
	{
		if (iChars.indexOf(obj.value.charAt(i)) != -1) 
		{
			alert(getMessage('CANNOT_BE_SPECIAL_CHAR','common'));
			obj.focus();
			return false;
		}
	}
	
}

function validatePassword(obj)
{						
	if (obj.value.indexOf(' ') > -1) 
	{
		var msg=getMessage('INVALID_VALUE','common');
		msg=msg.replace('#','Password');
		alert(msg);
		obj.focus();
		return false;					
	}
}
