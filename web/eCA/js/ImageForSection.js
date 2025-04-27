/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------------------------------------------		
11/05/2017	IN064233		Raja S			16/05/2017		Ramesh G 		Alpha-CA-image not showing After select image reference
---------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
function create()
{
	f_query_add_mod.location.href='../../eCA/jsp/AddModifyImageForSection.jsp';
}
function query()
{
	f_query_add_mod.location.href='../../eCA/jsp/QueryCriteriaImageForSection.jsp';
}
function apply()
{
	if(f_query_add_mod.document.ImageForSectionFrm!=null)
	{
	var fields = new Array ( f_query_add_mod.document.ImageForSectionFrm.sec_hdg_code,
						f_query_add_mod.document.ImageForSectionFrm.image_ref
					    );
	var names =  new Array ( f_query_add_mod.getLabel("eCA.SectionHeading.label",'CA'),							f_query_add_mod.getLabel("eCA.ImageReference.label",'CA')
						    );
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
	{
		f_query_add_mod.document.ImageForSectionFrm.submit();
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
	
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eCA/jsp/AddModifyImageForSection.jsp';
	else if(f_query_add_mod.document.forms[0].mode.value=="delete")
		f_query_add_mod.location.href='../../eCommon/html/blank.html';
	else
         f_query_add_mod.location.reload();

}
function reset()
{
	/*if(f_query_add_mod.document.forms[0] != null)
	{
		if(f_query_add_mod.document.forms[0].name=="ImageListForm")
			f_query_add_mod.document.forms[0].reset();
		else
			f_query_add_mod.location.reload();
	}*/
	
   
	if(f_query_add_mod.document.forms[0])
	{
		if(f_query_add_mod.document.forms[0].mode)
		{
			if(f_query_add_mod.document.forms[0].mode.value=="insert")
			{
				f_query_add_mod.document.forms[0].reset();
				f_query_add_mod.document.forms[0].image_previewer.src="";
				f_query_add_mod.document.getElementById("refimage").style.display="none"; //IN064233
			}			
			else
			{
				f_query_add_mod.document.forms[0].reset();
			}
		}
		else
		{
			f_query_add_mod.document.forms[0].reset();
		}
	}
}

function deleterecord()
{
	var message=f_query_add_mod.getMessage("RECORD_CANNOT_DELETE",'CA');
	if(f_query_add_mod.document.forms[0]!=null )
	{
		if(f_query_add_mod.document.forms[0].mode != null)
		{
			if(f_query_add_mod.document.forms[0].mode.value=="insert")
			{
			//commontoolbarFrame.location.reload();
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
			}
			else
			{
				var confrm=f_query_add_mod.getMessage("DELETE_RECORD",'common');
				if((window.confirm(confrm)) == true)
				{
					f_query_add_mod.document.forms[0].mode.value="delete";
					f_query_add_mod.document.ImageForSectionFrm.submit();
				}
				else
				{
					commontoolbarFrame.location.reload();
				}
			}
		}
		else
		{
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="
		}
	}
	else
	{
	 
     messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}
}

function CheckForSpecCharsWithSpaceBlur(ObjText)
{
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*& ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true ;
}


function resetValues()
{
   parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	
}


async function showSectionWindow(sectionObject)
{
	if(sectionObject.name=='sec_hdg_desc')
	{
		var target  = document.forms[0].sec_hdg_desc;
		
		if((target.value) == "null" || (target.value ==""))
		{
			return false;			
		}
		else
		{
			await showSection();
		}
	}
	else if(sectionObject.name=='section_button')
	{		
		await showSection();
	}

}

async function showSection(){
		var target	= document.forms[0].sec_hdg_desc;		
		var search_code="sec_hdg_code";
		var search_desc="sec_hdg_desc";		
		var sql="select sec_hdg_code code,sec_hdg_desc description from ca_section_hdg where image_linked_yn ='Y' and eff_status='E' and upper(sec_hdg_code) like upper(?) and upper(sec_hdg_desc) like upper(?) order by 2";
		var title	= getLabel("Common.Section.label","COMMON");
		var argArray = new Array();
		var namesArray = new Array();
		var valuesArray = new Array();
		var datatypesArray = new Array();
		
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		retArray = await CommonLookup( title,argArray );
		
		var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		} 
		if(retArray != null && retArray !="")	
		{
			document.forms[0].sec_hdg_desc.value = arr[1];
			document.forms[0].sec_hdg_code.value = arr[0];
		}
		else
		{
			document.forms[0].sec_hdg_desc.value=arr[1];
			document.forms[0].sec_hdg_code.value=arr[0];
			//target.focus();
		}
}
/*function showSectionWindow(){
		var target			= document.forms[0].sec_hdg_desc;
		var retVal			=  new String();
		var dialogTop	= "40";
		var dialogHeight		= "10" ;
		var dialogWidth	= "40" ;
		var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var search_desc			= "";
		var title			= getLabel("Common.Section.label","COMMON");
		var sql="select sec_hdg_code,sec_hdg_desc,sec_hdr_meta_desc from ca_section_hdg where image_linked_yn =`Y` and eff_status=`E`";

		search_code="sec_hdg_code";
		search_desc="sec_hdg_desc";
		retVal=window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(title,"UTF-8")+"&dispDescFirst=dispDescFirst",arguments,features);
		
		var arr=new Array();
		if (retVal != null && retVal != '' && retVal != "null")
		{

			var retVal=unescape(retVal);

		   	arr=retVal.split("::");
		   	document.forms[0].sec_hdg_desc.value=arr[0];
			document.forms[0].sec_hdg_code.value=arr[1];
			//document.forms[0].sec_hdg_desc.focus();
		}
		else
		{
			document.forms[0].sec_hdg_desc.value="";
			document.forms[0].sec_hdg_code.value="";
			//target.focus();
		}
}*/



async function showImageWindow(imageObject){
	if(imageObject.name=='image_ref_desc')
	{
		var target  = document.forms[0].image_ref_desc;
		
		if((target.value) == "null" || (target.value ==""))
		{
			document.getElementById("refimage").style.display="none";
			return false;			
		}
		else
		{
			await showImage();
		}
	}
	else if(imageObject.name=='image_button')
	{		
		await showImage();
	}


}
async function showImage(){
	

	var target	= document.forms[0].image_ref_desc;
	if(!(target.value =="" || target.value ==null))
	{
      document.getElementById("refimage").style.display="inline";
	}
	else
	{
		document.getElementById("refimage").style.display="none";
	}
		var search_code="image_ref";
		var search_desc="image_ref_desc";		
		var sql="select image_ref code, image_ref_desc description from ca_note_image_list where eff_status='E' and upper(image_ref) like upper(?) and upper(image_ref_desc) like upper(?) order by 2";
		var title = getLabel("eCA.ImageReference.label","CA");
		var argArray = new Array();
		var namesArray = new Array();
		var valuesArray = new Array();
		var datatypesArray = new Array();
		
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		retArray = await CommonLookup( title,argArray );
		var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		} 
		if(retArray != null && retArray !="")	
		{
			document.forms[0].image_ref_desc.value = arr[1];
			document.forms[0].image_ref.value = arr[0];
			var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()' class=MESSAGE><form name='tempformforImage' id='tempformforImage' method='post' action='../../eCA/jsp/ImageForSectionIntermediate.jsp'><input type=hidden name='image_ref' id='image_ref' value='"+retArray[0]+"'></form></body></html>";
			parent.blankFrame.document.write(HtmlVal);
			parent.blankFrame.document.tempformforImage.submit();
		}
		else
		{
			document.forms[0].image_ref_desc.value=arr[1];
			document.forms[0].image_ref.value=arr[0];			
			target.focus();
		}
}






