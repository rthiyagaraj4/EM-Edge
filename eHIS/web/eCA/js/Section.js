/*

---------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
---------------------------------------------------------------------------------------------------------------------------------------------------------------
26/04/2017	IN061907	Krishna Gowtham J	26/02/2017		Ramesh G			ML-MMOH-CRF-0559
---------------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
function create()
{
	f_query_add_mod.location.href='../../eCA/jsp/AddModifySection.jsp';
	SectionConfigDispFlds.location.href='../../eCommon/html/blank.html';
}
function query()
{
	//confDispID.rows = "42,*,0,0,50";
	
	    document.getElementById("commontoolbarFrame").style.height="8vh";
		document.getElementById("f_query_add_mod").style.height="73vh";
		document.getElementById("SectionConfigDispFlds").style.height="0vh";
		document.getElementById("IntermediateSectionConfigDispFlds").style.height="0vh";
		document.getElementById("IntermediateSectionConfigDispFlds").style.display='none';//HSA
		document.getElementById("messageFrame").style.height="9vh";
		
	//Modified by Arvind On 17-12-08
	//confDispID.rows = "8%,*,0,0,6%";
	f_query_add_mod.location.href='../../eCA/jsp/QueryCriteriaSection.jsp';
	SectionConfigDispFlds.location.href='../../eCommon/html/blank.html';
}
function apply()
{	
		if(f_query_add_mod.document.Section_form != null)
		{
			
				 var mode = f_query_add_mod.document.Section_form.mode.value;
		// var preserve_yn=f_query_add_mod.document.forms[0].preserve_format_yn.value
		//var include_filled_yn=f_query_add_mod.document.forms[0].include_filled_yn.value
		/*if(f_query_add_mod.document.forms[0].preserve_format_yn.checked==true)
			{
				f_query_add_mod.document.forms[0].preserve_format_yn.value='Y';
			}
			else
			{
				f_query_add_mod.document.forms[0].preserve_format_yn.value='N';
			}

			if(f_query_add_mod.document.forms[0].include_filled_yn.checked==true)
			{
				f_query_add_mod.document.forms[0].include_filled_yn.value='Y';
			}
			else
			{
				f_query_add_mod.document.forms[0].include_filled_yn.value='N';
			}*/
	
		 if(mode != null)
		{
			if(mode=='modify')
			{
				//alert("value ="+f_query_add_mod.document.forms[0].sec_hdr_meta_desc1.value)
				f_query_add_mod.document.forms[0].sec_hdr_meta_desc1.value= f_query_add_mod.document.forms[0].sec_hdr_meta_desc.value
					
				
				
			}	
		}
		if(f_query_add_mod.document.Section_form.content_type.value == "R")
		{
			
			var selection_type = f_query_add_mod.document.Section_form.result_sel.value;
			//alert("disp_ord..."+f_query_add_mod.document.Section_form.disp_ord.value);
			
			if(selection_type=="M")
			{
			var fields = new Array ( f_query_add_mod.document.Section_form.sec_hdg_code,
						f_query_add_mod.document.Section_form.sec_hdg_desc,
						f_query_add_mod.document.Section_form.content_type
					    );
			
			var names = new Array ( getLabel("Common.code.label",'COMMON'),
							getLabel("Common.description.label",'COMMON'),
							getLabel("Common.type.label",'COMMON')
						    );
			}
			else
			{
			var fields = new Array ( f_query_add_mod.document.Section_form.sec_hdg_code,
						f_query_add_mod.document.Section_form.sec_hdg_desc,
						f_query_add_mod.document.Section_form.content_type,
						f_query_add_mod.document.Section_form.result_linked_rec_type
					    );
			
			var names = new Array ( getLabel("Common.code.label",'COMMON'),
							getLabel("Common.description.label",'COMMON'),
							getLabel("Common.type.label",'COMMON'),
							getLabel("eCA.ResultCategory.label",'CA')
						    );

			}
			/*if(f_query_add_mod.document.Section_form.image_linked_yn.checked)
			{
				fields[4] = f_query_add_mod.document.Section_form.image_ref_url;
				names[4] = "Image Reference";
			}*/
		}else{
			var fields = new Array ( f_query_add_mod.document.Section_form.sec_hdg_code,
						f_query_add_mod.document.Section_form.sec_hdg_desc,
						f_query_add_mod.document.Section_form.content_type
					    );
			var names = new Array ( getLabel("Common.code.label",'COMMON'),
							getLabel("Common.description.label",'COMMON'),
							getLabel("Common.type.label",'COMMON')
						      );
			/*if(f_query_add_mod.document.Section_form.image_linked_yn.checked)
			{
				fields[3] = f_query_add_mod.document.Section_form.image_ref_url;
				names[3] = "Image Reference";
			}*/
		}
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
		{			
			var fields1 = new Array ( f_query_add_mod.document.Section_form.sec_hdg_code
													);
			var names1 = new Array ( getLabel("Common.code.label",'COMMON'));

			if (f_query_add_mod.SpecialCharCheck (fields1,names1,messageFrame,'M','MstCodeError.jsp'))
			{
				if(SectionConfigDispFlds.formSectionConfigDispFlds)
				if(SectionConfigDispFlds.formSectionConfigDispFlds.readioAppl[0].checked)
				{
					f_query_add_mod.Section_form.applicable.value = "A";
				}
				else if(SectionConfigDispFlds.formSectionConfigDispFlds.readioAppl[1].checked)
				{
					f_query_add_mod.Section_form.applicable.value = "NA";
				}
				f_query_add_mod.document.Section_form.submit();
				SectionConfigDispFlds.location.href='../../eCommon/html/blank.html';
			}
		}
	}
	else
	{
		//messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		//return false;
	
		message  = getMessage("NOT_VALID","CA");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}

	
	}

function onSuccess()
{
	var selection_type = f_query_add_mod.document.forms[0].result_sel.value;
	
	if(selection_type=="M"&&f_query_add_mod.document.forms[0].mode.value=="insert")
	{
		
		var confirm_flag = confirm(getMessage("DEFINE_RESULT_CATEG","CA"));
	
		if(confirm_flag==true)
		{
			
			var sec_hdg_code = f_query_add_mod.document.forms[0].sec_hdg_code.value;
			var sec_hdg_desc = f_query_add_mod.document.forms[0].sec_hdg_desc.value;

			//var popup = window.open('../../eCA/jsp/SectionMultiResCatMain.jsp?sec_hdg_code='+sec_hdg_code,null,"height=600,width=1000,top=120,left=0,status=NO,toolbar=no,menubar=no,location=no");
			var arguments ="";
			var features	=	"dialogTop:120;dialogHeight:600;dialogWidth:1000; status=no" ;
			var popup = window.showModalDialog('../../eCA/jsp/SectionMultiResCatMain.jsp?sec_hdg_code='+sec_hdg_code+'&sec_hdg_desc='+sec_hdg_desc,arguments,features);

			f_query_add_mod.location.href='../../eCA/jsp/AddModifySection.jsp?sec_hdg_code='+sec_hdg_code;
			
		
		}
		else
		{

			if(f_query_add_mod.document.forms[0].mode.value=="insert")
			{
				f_query_add_mod.location.href='../../eCA/jsp/AddModifySection.jsp';
			}
			else
			{ 
				f_query_add_mod.location.reload();
			}
			
		}
	
	}
	else
	{

		if(f_query_add_mod.document.forms[0].mode.value=="insert")
		{
				f_query_add_mod.location.href='../../eCA/jsp/AddModifySection.jsp';
		}
		else
		{ 
			f_query_add_mod.location.reload();
		}
	}

}


function reset()
{
	if(f_query_add_mod.document.forms[0].mode)
	{
		
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
	{
		
		SectionConfigDispFlds.location.href='../../eCommon/html/blank.html';
		f_query_add_mod.location.href='../../eCA/jsp/AddModifySection.jsp';
	}
	else
	{ 
		if(SectionConfigDispFlds.document.forms[0])
		SectionConfigDispFlds.document.forms[0].reset();
	}
	}

//	if(f_query_add_mod.document.forms[0].name=="Section_form")
	if(f_query_add_mod.document.forms[0])
		f_query_add_mod.document.forms[0].reset();

//	else
//		f_query_add_mod.location.reload();
}

/*
function reset()
{
	
		if(f_query_add_mod.document.forms[0]!=null){
	if(f_query_add_mod.document.forms[0].mode != null)
		{
			if(f_query_add_mod.document.forms[0].mode.value=="insert"|| f_query_add_mod.document.forms[0].mode.value=="modify")
			
				f_query_add_mod.location.href='../../eCA/jsp/AddModifySection.jsp';
	}
	else
		f_query_add_mod.location.href='../../eCA/jsp/QueryCriteriaSection.jsp';
}
}

*/


//Functions for AddModifySection.jsp-start


/*function PopulateCategory(obj)
{
	var content_type=document.forms[0].content_type.value;
	if(content_type=="R")
	{
		document.getElementById("mandatory").style.visibility = "visible";
		document.forms[0].result_linked_rec_type.disabled=false;
		var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link></HEAD><BODY CLASS='MESSAGE'><form name='form1' id='form1' method='post' action='PopulateCategory.jsp?content_type="+content_type+"'></form></BODY></HTML>";
		parent.messageFrame.document.write(HTMLVal);
		parent.messageFrame.document.forms[0].submit();
	}
	else
	{
		document.getElementById("mandatory").style.visibility = "hidden";
		document.forms[0].result_linked_rec_type.disabled=true;
	}
	delete_values(parent.frames[1].document.forms[0].result_linked_rec_type);
	if(content_type == 'R' || content_type == 'F')
	{
		document.forms[0].image_linked_yn.disabled = false;
	}
	else
	{
		document.forms[0].image_linked_yn.disabled = true;
	}
}

function delete_values(field)
{
	var selected = field;
	while ( selected.options.length > 0 )
		selected.remove(selected.options[0]);
	var opt		=	parent.frames[1].document.createElement("Option");
	opt.text	=	"     ------ Select ------     ";
	opt.value	=	"";
	field.add(opt);
}
function showImageLinkingDialog(obj)
{
	var action_url = "";
	var retVal			=	"";
	var dialogTop		=	"80" ;
	var dialogHeight	=	"30" ;
	var dialogWidth		=	"80" ;
	var status			=	"no";
	var arguments		=	"" ;
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	action_url = '../../eCA/jsp/AddModifyImages.jsp';
	retVal				=	window.showModalDialog(action_url,arguments,features);
}*/
//Functions for AddModifySection.jsp-end



//Functions for AddmodifyImageLinking.jsp-start

function scrollTitle()
{
	var y = parent.RecClinicalNotesImageLinkingFrame.document.body.scrollTop;
	if(y == 0)
	{
		parent.RecClinicalNotesImageLinkingFrame.document.getElementById("divDataTitle").style.position = 'static';
		parent.RecClinicalNotesImageLinkingFrame.document.getElementById("divDataTitle").style.posTop  = 0;
	}else{
		parent.RecClinicalNotesImageLinkingFrame.document.getElementById("divDataTitle").style.position = 'relative';
		parent.RecClinicalNotesImageLinkingFrame.document.getElementById("divDataTitle").style.posTop  = y-2;
	}
}
function alignWidth()
{
	var totalRows =  parent.RecClinicalNotesImageLinkingFrame.document.getElementById("dataTable").rows.length;	
	var counter = totalRows-1;
	var temp = parent.RecClinicalNotesImageLinkingFrame.document.getElementById("dataTitleTable").rows(0).cells.length;
	for(var i=0;i<temp;i++) 
	{			
		parent.RecClinicalNotesImageLinkingFrame.document.getElementById("dataTitleTable").rows(0).cells(i).width = 	parent.RecClinicalNotesImageLinkingFrame.document.getElementById("dataTable").rows(counter).cells(i).offsetWidth;			
	}
}
//Functions for AddmodifyImageLinking.jsp-end


//Functions for AddModifyImageLinkingButtons.jsp-start


function ReturnValue(obj)
{
	if(obj.name=='OK')
	{
		var valid, no_of_defaults = 0, i;
		var returnVal = "";
		var rows = parent.RecClinicalNotesImageLinkingFrame.document.forms[0].counterImage.value;
		for(i=0; i<rows ;i++)
		{
			var checkbox = eval("parent.RecClinicalNotesImageLinkingFrame.document.forms[0].default_yn" + i); 
			if(checkbox.checked)
				no_of_defaults++;
		}
		if(no_of_defaults > 1)
			alert(getMessage("ONLY_ONE_DEFAULT_IMAGE",'CA'));
		else if(no_of_defaults == 0)
			alert(getMessage("NO_DEFAULT_IMAGE",'CA'));
		else
		{
			for(i=0; i<rows ;i++)
			{
				var default_yn = eval("parent.RecClinicalNotesImageLinkingFrame.document.forms[0].default_yn" + i); 
				var image_ref = eval("parent.RecClinicalNotesImageLinkingFrame.document.forms[0].image_ref" + i); 
				if(default_yn.checked && !image_ref.checked)
				{
					alert(getMessage("IMAGE_DEFAULT_SELECTION",'CA'));
					returnVal = "";
					i=0;
					break;
				}
				if(image_ref.checked)
				{
					if(default_yn.checked)
						returnVal += (i==0?"":"~") + (image_ref.id + "||Y");
					else
						returnVal += (i==0?"":"~") + (image_ref.id + "||N");
				}				
			}
			//alert(returnVal);
			if(returnVal != "")
			{
				window.retrnValue = returnVal;
				window.close();
			}
			else
				alert(getMessage("NO_IMAGE_ASSOCIATED",'CA'));
		}
	}
	else
	{
		window.returnValue = "";
		window.close();
	}
}

//Functions for AddModifyImageLinkingButtons.jsp-end

function preserveyn()
{	
	if(document.forms[0].preserve_format_yn.checked==true)
	{
		document.forms[0].include_filled_yn.checked=false;
		document.forms[0].include_filled_yn.value="N";
		document.forms[0].include_filled_yn.disabled=true;
	}
	else if(document.forms[0].preserve_format_yn.checked==false)
	{
		document.forms[0].include_filled_yn.checked=false;
		document.forms[0].include_filled_yn.value="N";
		document.forms[0].include_filled_yn.disabled=false;	
	}
	
}

function check(obj)
{
	var mode=document.forms[0].mode.value;
	if(mode=='insert' || mode=='modify')
	{
		if(document.forms[0].eff_status.checked==true)
		{
			document.forms[0].eff_status.value='E';
		}
		else
		{
			document.forms[0].eff_status.value='D';
		}
	}
}

function checkpreserve(obj)
{
	var mode=document.forms[0].mode.value;
	if(mode=='insert' || mode=='modify')
	{
		if(document.forms[0].preserve_format_yn.checked==true)
		{
			document.forms[0].preserve_format_yn1.value='Y';
			document.forms[0].preserve_format_yn.value='Y';
			document.forms[0].include_filled_yn1.value='N';
		}
		else
		{
			document.forms[0].preserve_format_yn1.value='N';
			document.forms[0].preserve_format_yn.value='N';
		}
	}
}

function checkinclude(obj)
{
	var mode=document.forms[0].mode.value;
	if(mode=='insert' || mode=='modify')
	{
		if(document.forms[0].include_filled_yn.checked==true)
		{
			document.forms[0].include_filled_yn1.value='Y';
			document.forms[0].include_filled_yn.value='Y';
		}
		else
		{
			document.forms[0].include_filled_yn1.value='N';
			document.forms[0].include_filled_yn.value='N';
		}
	}
}
function imageCheck(obj)
{
	var mode=document.forms[0].mode.value;
	if(mode=='insert' || mode=='modify')
	{
		if(document.forms[0].image_linked_yn.checked==true)
		{
			document.forms[0].image_linked_yn1.value='Y';
			document.forms[0].image_linked_yn.value='Y';
		}
		else
		{
			document.forms[0].image_linked_yn1.value='N';
			document.forms[0].image_linked_yn.value='N';
		}
	}
}

function changeOutputYN (obj)

{
	
	if(obj.checked==true)
	{
		document.getElementById("outputYN").value="Y";
	}
	else
	{
		document.getElementById("outputYN").value="N";
	}
	

}

function changeResultSel(obj)
{
	//IN061907 Start
	if(obj.value != "S")
	{
		document.getElementById("res_auto_link_desc").style.display = 'none';
		document.getElementById("res_auto_link_id").style.display = 'none';
	}
	//IN061907 Ends
	if(obj.value=="M")
	{
		document.forms[0].disp_ord.disabled=false;
		document.forms[0].ord_multi.disabled=false;
		document.getElementById("mandatory").style.visibility = "hidden"; //image_linked_yn
		document.forms[0].image_linked_yn.value='N';
		document.forms[0].image_linked_yn.checked=false;
		document.forms[0].image_linked_yn.disabled=true;
		document.forms[0].result_linked_rec_type.disabled=true;
		document.forms[0].result_linked_rec_type.value='';
		//parent.confDispID.rows = "42,*,0,0,50";
		parent.document.getElementById("commontoolbarFrame").style.height="8vh";
		parent.document.getElementById("f_query_add_mod").style.height="70vh";
		parent.document.getElementById("SectionConfigDispFlds").style.height="0vh";
		parent.document.getElementById("IntermediateSectionConfigDispFlds").style.height="0vh";
		parent.document.getElementById("messageFrame").style.height="9vh";
		
		//Modified by Arvind On 17-12-08
		//parent.confDispID.rows = "8%,35%,*,0,6%";
	}
	else
	{
		//parent.confDispID.rows = "42,*,290,0,50";

		//Modified by Arvind On 17-12-08
		//parent.confDispID.rows = "8%,35%,*,0,6%";
		parent.document.getElementById("commontoolbarFrame").style.height="8vh";
		parent.document.getElementById("f_query_add_mod").style.height="71vh";
		parent.document.getElementById("SectionConfigDispFlds").style.height="0vh";
		parent.document.getElementById("IntermediateSectionConfigDispFlds").style.height="0vh";
		parent.document.getElementById("messageFrame").style.height="9vh";
		
		parent.SectionConfigDispFlds.location.href='../../eCommon/html/blank.html';
		document.getElementById("mandatory").style.visibility = "visible";
                document.forms[0].ord_multi.disabled=true;
		document.forms[0].disp_ord.value='';
		document.forms[0].disp_ord.disabled=true;
		document.forms[0].image_linked_yn.disabled=false;
		document.forms[0].result_linked_rec_type.disabled=false;
	}

}

function callMultiWin()
{

	var sec_hdg_code = document.Section_form.sec_hdg_code.value;
	var sec_hdg_desc = document.Section_form.sec_hdg_desc.value;
	var mode = document.Section_form.mode.value;
	//alert("sec_hdg_code..."+sec_hdg_code);
	//var popup = window.open('../../eCA/jsp/SectionMultiResCatMain.jsp?'+query_string+'&categ_id='+schedule_catog,null,"height=600,width=1000,top=120,left=0,status=NO,toolbar=no,menubar=no,location=no");
	if(mode=="insert")
		{
		//alert('record and continue...');
		alert(getMessage("REC_AND_CONTINUE","CA"));
		}
		else
		{
		//var popup = window.open('../../eCA/jsp/SectionMultiResCatMain.jsp?sec_hdg_code='+sec_hdg_code,null,"height=615,width=1010,top=85,left=0,status=NO,toolbar=no,menubar=no,location=no");
		var arguments ="";
		var features	="dialogTop:500;dialogHeight:600;dialogWidth:1010;status=no" ;
		var popup = window.showModalDialog('../../eCA/jsp/SectionMultiResCatMain.jsp?sec_hdg_code='+sec_hdg_code+'&sec_hdg_desc='+sec_hdg_desc,arguments,features);
	}
}
function populateOrdType(obj)
{
	//deleteOrdType(parent.frames[0].document.forms[0].ord_type);
	deleteOrdType(parent.MultiOrdSelAdd.document.forms[0].ord_type_comp);
	
	var order_category = document.forms[0].res_categ.value;
	//alert("order_category.."+order_category);

	if(order_category!="")
	{

		var HTMLVal = "<HTML><HEAD><link rel='StyleSheet' href='../../eCommon/html/IeStyle.css' type='text/css' /></HEAD><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><BODY  onKeyDown='lockKey()' CLASS='MESSAGE'><form name='form1' id='form1' method='post' action='SectionPopulateOrderType.jsp?order_category="+order_category+"'></form></BODY></HTML>";

		parent.messageFrame.document.write(HTMLVal);
		parent.messageFrame.document.forms[0].submit();
	}else{
			document.getElementById('ord_type_label1').innerText =getLabel("Common.OrderType.label","COMMON");
			document.getElementById('ord_catlog_label').innerText =getLabel("Common.ordercatalog.label","COMMON");
	}
	document.forms[0].ord_catlog.value = "";
	document.forms[0].ord_catlog_desc.value = "";

	if (order_category=="DIAG")
	{
		//compbxOrdType
		//lookupOrdType
		document.getElementById("lookupOrdType").style.display	= 'none';
		document.getElementById("compbxOrdType").style='display';
		
		document.getElementById("lookup").style.display	= 'none';
		document.getElementById("compList").style='display';
	}
	else if (order_category=="ALGY")
	{
		document.getElementById("lookupOrdType").style='display';
		document.getElementById("compbxOrdType").style.display	= 'none';

		document.forms[0].ord_type.value = "";
		document.forms[0].ord_type_desc.value = "";

		document.getElementById("lookup").style.display	= 'none';
		document.getElementById("compList").style.display	= 'none';
	}
	else if (order_category=="BLTF")
	{
		document.getElementById("lookupOrdType").style.display	= 'none';
		document.getElementById("compbxOrdType").style='display';
		
		document.getElementById("lookup").style.display	= 'none';
		document.getElementById("compList").style.display	= 'none';
	}
	
	else if (order_category=="FEVT")
	{
		document.getElementById("lookupOrdType").style.display	= 'none';
		document.getElementById("compbxOrdType").style='display';
		
		document.getElementById("lookup").style.display	= 'none';
		document.getElementById("compList").style.display	= 'none';
	}
	else if (order_category=="NBDT")
	{   
		document.getElementById("lookupOrdType").style.display	= 'none';
		document.getElementById("compbxOrdType").style='display';
		
		document.getElementById("lookup").style.display	= 'none';
		document.getElementById("compList").style.display	= 'none';
	}
	else
	{
		document.getElementById("lookupOrdType").style='display';
		document.getElementById("compbxOrdType").style.display	= 'none';
		document.forms[0].ord_type.value = "";
		document.forms[0].ord_type_desc.value = "";
		
		document.getElementById("lookup").style='display';
		document.getElementById("compList").style.display	= 'none';
	}

}
function deleteOrdType(field)
{
	var selected = field;
	while ( selected.options.length > 0 )
		selected.remove(selected.options[0]);
	var opt		=	parent.MultiOrdSelAdd.document.createElement("Option");
	opt.text	=	"----"+getLabel("Common.defaultSelect.label","COMMON")+"----" ;
	opt.value	=	"";
	field.add(opt);
}

async function getOrdCatalogue()
{

	var target			= document.forms[0].ord_catlog_desc;
	//var stdval          = document.forms[0].creating_user.value;
	//var val				= document.forms[0].facilityid.value;
	//var pract_id		= document.forms[0].ca_practitioner_id.value;
	var retVal			=  new String();
	var dialogTop		= "40";
	var dialogHeight	= "10" ;
	var dialogWidth		= "40" ;
	var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments		= "" ;
	var search_desc		= "";
	//var title			= getLabel("Common.practitioner.label","COMMON");
	//var title			= document.getElementById("ord_catlog").innerText;
	var title			= document.getElementById("ord_catlog_label").innerText;
	var locale			= document.forms[0].locale.value;
	var order_type		= document.forms[0].ord_type.value;
	var res_categ		= document.forms[0].res_categ.value;
	var sql="";

	//alert("res_categ...."+res_categ+"...order_type.."+order_type);
	//var loc_type		= document.forms[0].locationType.value;
	//var sql="Select locn_code code,decode(locn_type,'C',OP_GET_DESC.OP_CLINIC('"+val+"',locn_code,'"+locale+"','1'), 'W',IP_GET_DESC.IP_NURSING_UNIT('"+val+"',locn_code,'"+locale+"','1') ) description  from ca_pract_by_locn_view where  upper(locn_code) like upper(?) AND UPPER(decode(locn_type,'C',OP_GET_DESC.OP_CLINIC('"+val+"',locn_code,'"+locale+"','1'), 'W',IP_GET_DESC.IP_NURSING_UNIT('"+val+"',locn_code,'"+locale+"','1') )) like upper(?) AND practitioner_id= '"+pract_id+"' and locn_type in ('C','W') and facility_id = '"+val+"' and PATIENT_CLASS = '"+loc_type+"' order by 2";
	if(res_categ=="ALGY")
	{
		document.forms[0].ord_catlog.value = 'ALL';
		document.forms[0].ord_catlog_desc.value = 'ALL';
		return;
		
	}
	else if(res_categ=="BLTF")
	{
		document.forms[0].ord_catlog.value = 'ALL';
		document.forms[0].ord_catlog_desc.value = 'ALL';
		
	}
	else if(res_categ=="CLNT")
	{
		//sql ="select a.SEC_HDG_CODE code ,ca_get_desc.CA_SECTION_HDG(a.SEC_HDG_CODE,'"+locale+"',1) description from CA_NOTE_SECTION  a where a.NOTE_TYPE='"+order_type+"' and upper(SEC_HDG_CODE) like upper(?) AND upper(ca_get_desc.CA_SECTION_HDG(a.SEC_HDG_CODE,'"+locale+"',1)) like upper(?)"; 
	
		sql ="select a.NOTE_TYPE code ,NOTE_TYPE_DESC description from CA_NOTE_TYPE  a where a.NOTE_GROUP_ID='"+order_type+"' and upper(NOTE_TYPE) like upper(?) AND upper(NOTE_TYPE_DESC) like upper(?)"; 
		
	}
	else if(res_categ=="RXIN")
	{
		sql="select oc.ORDER_CATALOG_CODE code,oc.SHORT_DESC description from OR_ORDER_CATALOG_LANG_VW oc where oc.ORDER_TYPE_CODE='"+order_type+"' and oc.ORDER_CATEGORY='RX' and oc.LANGUAGE_ID='"+locale+"' and upper(ORDER_CATALOG_CODE) like upper(?) AND UPPER(SHORT_DESC) like upper(?)";
	}
	else if(res_categ=="DIET")
	{
		sql="select oc.ORDER_CATALOG_CODE code,oc.SHORT_DESC description from OR_ORDER_CATALOG_LANG_VW oc where oc.ORDER_TYPE_CODE='"+order_type+"' and oc.ORDER_CATEGORY='DS' and oc.LANGUAGE_ID='"+locale+"' and upper(ORDER_CATALOG_CODE) like upper(?) AND UPPER(SHORT_DESC) like upper(?)";
	}
	else if(res_categ=="FEVT")
	{
		document.forms[0].ord_catlog.value = 'ALL';
		document.forms[0].ord_catlog_desc.value = 'ALL';
		return;
	}
	else if(res_categ=="LBIN")
	{
		sql="select oc.ORDER_CATALOG_CODE code,oc.SHORT_DESC description from OR_ORDER_CATALOG_LANG_VW oc where oc.ORDER_TYPE_CODE='"+order_type+"' and oc.ORDER_CATEGORY='LB' and oc.LANGUAGE_ID='"+locale+"' and upper(ORDER_CATALOG_CODE) like upper(?) AND UPPER(SHORT_DESC) like upper(?)";
	}
	else if(res_categ=="MEDN")
	{
		sql="select oc.ORDER_CATALOG_CODE code,oc.SHORT_DESC description from OR_ORDER_CATALOG_LANG_VW oc where oc.ORDER_TYPE_CODE='"+order_type+"' and oc.ORDER_CATEGORY='PH' and oc.LANGUAGE_ID='"+locale+"' and upper(ORDER_CATALOG_CODE) like upper(?) AND UPPER(SHORT_DESC) like upper(?)";
	}
	else if(res_categ=="RDIN")
	{
		sql="select oc.ORDER_CATALOG_CODE code,oc.SHORT_DESC description from OR_ORDER_CATALOG_LANG_VW oc where oc.ORDER_TYPE_CODE='"+order_type+"' and oc.ORDER_CATEGORY='RD' and oc.LANGUAGE_ID='"+locale+"' and upper(ORDER_CATALOG_CODE) like upper(?) AND UPPER(SHORT_DESC) like upper(?)";
	}
	else if(res_categ=="NBDT")
	{
		document.forms[0].ord_catlog.value = 'ALL';
		document.forms[0].ord_catlog_desc.value = 'ALL';
		
	}
	else if(res_categ=="PTCR")
	{
		sql="select oc.ORDER_CATALOG_CODE code,oc.SHORT_DESC description from OR_ORDER_CATALOG_LANG_VW oc where oc.ORDER_TYPE_CODE='"+order_type+"' and oc.ORDER_CATEGORY='PC' and oc.LANGUAGE_ID='"+locale+"' and upper(ORDER_CATALOG_CODE) like upper(?) AND UPPER(SHORT_DESC) like upper(?)";
	}
	else if(res_categ=="DIAG")
	{
		
		//Admission
		//Discharge
		//Intermediate
	}
	else if(res_categ=="SUNT")
	{
		sql="select oc.ORDER_CATALOG_CODE code,oc.SHORT_DESC description from OR_ORDER_CATALOG_LANG_VW oc where oc.ORDER_TYPE_CODE='"+order_type+"' and oc.ORDER_CATEGORY='OT' and oc.LANGUAGE_ID='"+locale+"' and upper(ORDER_CATALOG_CODE) like upper(?) AND UPPER(SHORT_DESC) like upper(?)";
	}
	else if(res_categ=="TRET")
	{
		sql="select oc.ORDER_CATALOG_CODE code,oc.SHORT_DESC description from OR_ORDER_CATALOG_LANG_VW oc where oc.ORDER_TYPE_CODE='"+order_type+"' and oc.ORDER_CATEGORY='TR' and oc.LANGUAGE_ID='"+locale+"' and upper(ORDER_CATALOG_CODE) like upper(?) AND UPPER(SHORT_DESC) like upper(?)";
	}


	
//	var sql="select oc.ORDER_CATALOG_CODE code,oc.SHORT_DESC description from OR_ORDER_CATALOG_LANG_VW oc where oc.ORDER_TYPE_CODE='"+order_type+"' and oc.ORDER_CATEGORY='"+order_categ+"' and oc.LANGUAGE_ID='"+locale+"' and upper(ORDER_CATALOG_CODE) like upper(?) AND UPPER(SHORT_DESC) like upper(?)";
if((res_categ=="CLNT")||(res_categ=="RXIN")||(res_categ=="DIET")||(res_categ=="LBIN")||(res_categ=="MEDN")||(res_categ=="RDIN")||(res_categ=="PTCR")||(res_categ=="SUNT")||(res_categ=="TRET"))
{
	
	var argArray		= new Array();
	var namesArray		= new Array();
	var valuesArray		= new Array();
	var datatypesArray	= new Array();
	
	//alert("sql..."+sql);
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
							
		retArray = await CommonLookup( title, argArray );	
		var str =unescape(retArray);
		var arr = str.split(",");		
		if(retArray != null && retArray !="")
		{

		document.forms[0].ord_catlog.value = arr[0];
		document.forms[0].ord_catlog_desc.value = arr[1];
					//document.forms[0].performed_by_code.value = retArray[0];
					
		}
		else
		{
			document.forms[0].ord_catlog.value = "";
			document.forms[0].ord_catlog_desc.value = "";
		}
	}
	//alert('ord_catlog..'+document.forms[0].ord_catlog.value);


}

function recOrdMultiRes()
{
	
	
	var ord_catlog ='';

	if(document.forms[0].res_categ.value=="DIAG")
	{
		ord_catlog =document.forms[0].ord_catlog1;
	}
	else
	{
	ord_catlog =document.forms[0].ord_catlog;	
	}
	//alert("ord_catlog..."+document.forms[0].ord_catlog.value);
	
	var fields = new Array ( document.forms[0].sec_hdg_code,
							document.forms[0].res_categ						
							);
	//var names = new Array ( getLabel("Common.code.label",'COMMON'),"order category",
							//"Order Type"
						  // );
	var names = new Array ( getLabel("Common.code.label",'COMMON'),getLabel("eCA.ResultCategory.label",'CA')
						   );
			
	if(checkFieldsofMst( fields, names, parent.messageFrame)) 
		{			
		
			document.forms[0].mode.value = 'insMulti';
			document.MultiResCat_form.submit();
		
		
		}
		document.forms[0].searchresult_button.disabled=false;
	
}

function cancelMultiRes()
{
	parent.window.close();
}

function onSuccess1(sec_hdg_code)
{
	var sec_hdg_code = parent.MultiOrdSelAdd.document.getElementById('sec_hdg_code').value;
	parent.MultiOrdSelAdd.location.href='../eCA/jsp/SectionMultiResCatAddModify.jsp?sec_hdg_code='+sec_hdg_code;
	parent.MultiOrdSelDetails.location.href='../eCA/jsp/SectionMultiResCatResult.jsp?sec_hdg_code='+sec_hdg_code;
	//parent.MultiOrdSelAdd.location.reload();
	//parent.MultiOrdSelDetails.location.reload();
	//window.location.reload();
	
}
function removeRec(sec_hdg_code,reslnk_rec_type,main_type,sub_type)
{

	//alert("sec_hdg_code..."+sec_hdg_code+"...reslnk_rec_type..."+reslnk_rec_type+"..main_type..."+main_type+"...sub_type..."+sub_type);

	document.MultiResCatDet_form.mode.value="delMulti";
	document.MultiResCatDet_form.reslnk_rec_type.value= reslnk_rec_type;
	document.MultiResCatDet_form.main_type.value = main_type;
	document.MultiResCatDet_form.sub_type.value = sub_type;

	document.MultiResCatDet_form.submit();

}
function clearOrdcatlog(obj)
{
	document.forms[0].ord_type.value = obj.value;
	document.forms[0].ord_catlog.value = "";
	document.forms[0].ord_catlog_desc.value = "";

}
function clearpage()
{
	parent.MultiOrdSelAdd.document.forms[0].reset();
	
}

async function getOrdType()
{ 		
	var target			= document.forms[0].ord_type_desc;
	//var stdval          = document.forms[0].creating_user.value;
	//var val				= document.forms[0].facilityid.value;
	//var pract_id		= document.forms[0].ca_practitioner_id.value;
	var retVal			=  new String();
	var dialogTop		= "40";
	var dialogHeight	= "10" ;
	var dialogWidth		= "40" ;
	var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments		= "" ;
	var search_desc		= "";
	//var title			= getLabel("Common.practitioner.label","COMMON");
	//var title			= document.getElementById("ord_type").innerText;
	var title			= document.getElementById("ord_type_label1").innerText;
	var locale			= document.forms[0].locale.value;
	//var order_type		= document.forms[0].ord_type.value;
	var res_categ		= document.forms[0].res_categ.value;
	
	var sql="";

	if(res_categ=="ALGY")
	{
		sql="select adv_event_type_code code,short_desc description from mr_adv_event_type where eff_status='E' and upper(adv_event_type_code) like upper(?) AND UPPER(short_desc) like upper(?) ORDER BY 2";
	
		//sql="select oc.ORDER_CATALOG_CODE code,oc.SHORT_DESC description from OR_ORDER_CATALOG_LANG_VW oc where oc.ORDER_TYPE_CODE='"+order_type+"' and oc.ORDER_CATEGORY='DS' and oc.LANGUAGE_ID='"+locale+"' and upper(ORDER_CATALOG_CODE) like upper(?) AND UPPER(SHORT_DESC) like upper(?)";
	}
	else if(res_categ=="CLNT")
	{
		//sql="select a.NOTE_TYPE code,a.NOTE_TYPE_DESC description from CA_NOTE_TYPE a where eff_status='E' and upper(a.NOTE_TYPE) like upper(?) AND UPPER(a.NOTE_TYPE_DESC) like upper(?) ORDER BY 2";

		sql="select a.NOTE_GROUP code,a.NOTE_GROUP_DESC description from CA_NOTE_GROUP a where eff_status='E' and upper(a.NOTE_GROUP) like upper(?) AND UPPER(a.NOTE_GROUP_DESC) like upper(?) ORDER BY 2";
	
		//sql="select oc.ORDER_CATALOG_CODE code,oc.SHORT_DESC description from OR_ORDER_CATALOG_LANG_VW oc where oc.ORDER_TYPE_CODE='"+order_type+"' and oc.ORDER_CATEGORY='DS' and oc.LANGUAGE_ID='"+locale+"' and upper(ORDER_CATALOG_CODE) like upper(?) AND UPPER(SHORT_DESC) like upper(?)";
	}
	else if(res_categ=="RXIN")
	{
		sql="select od.ORDER_TYPE_CODE code ,od.SHORT_DESC description from OR_ORDER_TYPE_LANG_VW od where od.ORDER_CATEGORY= 'RX' and od.LANGUAGE_ID='"+locale+"' and upper(od.ORDER_TYPE_CODE) like upper(?) AND UPPER(od.SHORT_DESC) like upper(?)";
	
		//sql="select oc.ORDER_CATALOG_CODE code,oc.SHORT_DESC description from OR_ORDER_CATALOG_LANG_VW oc where oc.ORDER_TYPE_CODE='"+order_type+"' and oc.ORDER_CATEGORY='DS' and oc.LANGUAGE_ID='"+locale+"' and upper(ORDER_CATALOG_CODE) like upper(?) AND UPPER(SHORT_DESC) like upper(?)";
	}
	else if(res_categ=="DIET")
	{
		sql="select od.ORDER_TYPE_CODE code ,od.SHORT_DESC description from OR_ORDER_TYPE_LANG_VW od where od.ORDER_CATEGORY= 'DS' and od.LANGUAGE_ID='"+locale+"' and upper(od.ORDER_TYPE_CODE) like upper(?) AND UPPER(od.SHORT_DESC) like upper(?)";
	
		//sql="select oc.ORDER_CATALOG_CODE code,oc.SHORT_DESC description from OR_ORDER_CATALOG_LANG_VW oc where oc.ORDER_TYPE_CODE='"+order_type+"' and oc.ORDER_CATEGORY='DS' and oc.LANGUAGE_ID='"+locale+"' and upper(ORDER_CATALOG_CODE) like upper(?) AND UPPER(SHORT_DESC) like upper(?)";
	}
	else if(res_categ=="LBIN")
	{
		sql="select od.ORDER_TYPE_CODE code ,od.SHORT_DESC description from OR_ORDER_TYPE_LANG_VW od where od.ORDER_CATEGORY= 'LB' and od.LANGUAGE_ID='"+locale+"' and upper(od.ORDER_TYPE_CODE) like upper(?) AND UPPER(od.SHORT_DESC) like upper(?)";
	
		//sql="select oc.ORDER_CATALOG_CODE code,oc.SHORT_DESC description from OR_ORDER_CATALOG_LANG_VW oc where oc.ORDER_TYPE_CODE='"+order_type+"' and oc.ORDER_CATEGORY='DS' and oc.LANGUAGE_ID='"+locale+"' and upper(ORDER_CATALOG_CODE) like upper(?) AND UPPER(SHORT_DESC) like upper(?)";
	}
	else if(res_categ=="MEDN")
	{
		sql="select od.ORDER_TYPE_CODE code ,od.SHORT_DESC description from OR_ORDER_TYPE_LANG_VW od where od.ORDER_CATEGORY= 'PH' and od.LANGUAGE_ID='"+locale+"' and upper(od.ORDER_TYPE_CODE) like upper(?) AND UPPER(od.SHORT_DESC) like upper(?)";
	
		//sql="select oc.ORDER_CATALOG_CODE code,oc.SHORT_DESC description from OR_ORDER_CATALOG_LANG_VW oc where oc.ORDER_TYPE_CODE='"+order_type+"' and oc.ORDER_CATEGORY='DS' and oc.LANGUAGE_ID='"+locale+"' and upper(ORDER_CATALOG_CODE) like upper(?) AND UPPER(SHORT_DESC) like upper(?)";
	}
	else if(res_categ=="RDIN")
	{
		sql="select od.ORDER_TYPE_CODE code ,od.SHORT_DESC description from OR_ORDER_TYPE_LANG_VW od where od.ORDER_CATEGORY= 'RD' and od.LANGUAGE_ID='"+locale+"' and upper(od.ORDER_TYPE_CODE) like upper(?) AND UPPER(od.SHORT_DESC) like upper(?)";
	
		//sql="select oc.ORDER_CATALOG_CODE code,oc.SHORT_DESC description from OR_ORDER_CATALOG_LANG_VW oc where oc.ORDER_TYPE_CODE='"+order_type+"' and oc.ORDER_CATEGORY='DS' and oc.LANGUAGE_ID='"+locale+"' and upper(ORDER_CATALOG_CODE) like upper(?) AND UPPER(SHORT_DESC) like upper(?)";
	}
	else if(res_categ=="PTCR")
	{
		sql="select od.ORDER_TYPE_CODE code ,od.SHORT_DESC description from OR_ORDER_TYPE_LANG_VW od where od.ORDER_CATEGORY= 'PC' and od.LANGUAGE_ID='"+locale+"' and upper(od.ORDER_TYPE_CODE) like upper(?) AND UPPER(od.SHORT_DESC) like upper(?)";
	
		//sql="select oc.ORDER_CATALOG_CODE code,oc.SHORT_DESC description from OR_ORDER_CATALOG_LANG_VW oc where oc.ORDER_TYPE_CODE='"+order_type+"' and oc.ORDER_CATEGORY='DS' and oc.LANGUAGE_ID='"+locale+"' and upper(ORDER_CATALOG_CODE) like upper(?) AND UPPER(SHORT_DESC) like upper(?)";
	}
	else if(res_categ=="DIAG")
	{
		sql="select TERM_SET_ID code ,TERM_SET_DESC description from MR_TERM_SET  where EFF_STATUS='E' and upper(TERM_SET_ID) like upper(?) AND UPPER(TERM_SET_DESC) like upper(?)  ORDER BY 2";
	
		//sql="select oc.ORDER_CATALOG_CODE code,oc.SHORT_DESC description from OR_ORDER_CATALOG_LANG_VW oc where oc.ORDER_TYPE_CODE='"+order_type+"' and oc.ORDER_CATEGORY='DS' and oc.LANGUAGE_ID='"+locale+"' and upper(ORDER_CATALOG_CODE) like upper(?) AND UPPER(SHORT_DESC) like upper(?)";
	}
	else if(res_categ=="SUNT")
	{
		sql="select od.ORDER_TYPE_CODE code ,od.SHORT_DESC description from OR_ORDER_TYPE_LANG_VW od where od.ORDER_CATEGORY= 'OT' and od.LANGUAGE_ID='"+locale+"' and upper(od.ORDER_TYPE_CODE) like upper(?) AND UPPER(od.SHORT_DESC) like upper(?)";
	
		//sql="select oc.ORDER_CATALOG_CODE code,oc.SHORT_DESC description from OR_ORDER_CATALOG_LANG_VW oc where oc.ORDER_TYPE_CODE='"+order_type+"' and oc.ORDER_CATEGORY='DS' and oc.LANGUAGE_ID='"+locale+"' and upper(ORDER_CATALOG_CODE) like upper(?) AND UPPER(SHORT_DESC) like upper(?)";
	}
	else if(res_categ=="TRET")
	{
		sql="select ORDER_TYPE_CODE code ,SHORT_DESC description from OR_ORDER_TYPE_LANG_VW  where ORDER_CATEGORY= 'TR' and LANGUAGE_ID='"+locale+"' and upper(ORDER_TYPE_CODE) like upper(?) AND UPPER(SHORT_DESC) like upper(?)";
	
		//sql="select oc.ORDER_CATALOG_CODE code,oc.SHORT_DESC description from OR_ORDER_CATALOG_LANG_VW oc where oc.ORDER_TYPE_CODE='"+order_type+"' and oc.ORDER_CATEGORY='DS' and oc.LANGUAGE_ID='"+locale+"' and upper(ORDER_CATALOG_CODE) like upper(?) AND UPPER(SHORT_DESC) like upper(?)";
	}


	var argArray		= new Array();
	var namesArray		= new Array();
	var valuesArray		= new Array();
	var datatypesArray	= new Array();
	
	//alert("sql..."+sql);
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		
		if (res_categ != "")
		{		
			retArray = await CommonLookup( title, argArray );	
			var str =unescape(retArray);
			var arr = str.split(",");		
			if(retArray != null && retArray !="")
			{

			document.forms[0].ord_type.value = arr[0];
			document.forms[0].ord_type_desc.value = arr[1];
						//document.forms[0].performed_by_code.value = retArray[0];
						
			}
			else
			{
				document.forms[0].ord_type.value = "";
				document.forms[0].ord_type_desc.value = "";
				document.forms[0].ord_catlog_desc.value = "";
				document.forms[0].ord_catlog.value = "";
			}
		}else{
			document.forms[0].ord_type.value = "";
			document.forms[0].ord_type_desc.value = "";
			document.forms[0].ord_catlog_desc.value = "";
			document.forms[0].ord_catlog.value = "";
			var msg =getMessage("CAN_NOT_BE_BLANK","common");
			msg = msg.replace("$",getLabel("eCA.ResultCategory.label","CA"));			 
			alert(msg);			
		}

}

function getOrdType1(obj)
{
	var order_category = document.forms[0].res_categ.value;	
	
	if(obj.value !="" && order_category != "")
	{
		getOrdType();
	}
	else
	{
		document.forms[0].ord_type.value = "";
		document.forms[0].ord_type_desc.value = "";
		document.forms[0].ord_catlog_desc.value = "";
		document.forms[0].ord_catlog.value = "";
	/*	var msg =getMessage("CAN_NOT_BE_BLANK","common");
		msg = msg.replace("$",getLabel("eCA.ResultCategory.label","CA"));
		alert(msg);	*/
	}


}
function getOrdCatalogue1(obj)
{
	if(obj.value!="")
	{
		getOrdCatalogue();
	}
	else
	{
		document.forms[0].ord_catlog.value = "";
		document.forms[0].ord_catlog_desc.value = "";
	}

}

function changeColor(cnt, obj, rowCount)
{	
	
	
	var firstValue = document.formSectionConfigDispFlds.firstPos.value;
	var resCategory = document.formSectionConfigDispFlds.resCategoryKey.value;
	var qryMode = document.formSectionConfigDispFlds.qryMode.value;
	var rCount = parseInt(rowCount);

	
	if( firstValue == "")
	{
		
		//var temp = document.getElementById("tblResultLinked").rows(rCount).cells.length;
		var temp = eval(document.getElementById('numRows'+rowCount));
		var temp1 = temp.cells.length;

		if(firstValue == "")
		{
			for(var i=0;i<temp1;i++)
			{
				temp.cells[i].className = 'FIRSTSELECTED';
			}
		}
		document.formSectionConfigDispFlds.firstPos.value = cnt;
	}
	else if((resCategory == 'FEVT' || resCategory == 'MHD')  &&  firstValue != cnt) //Added resCategory == MHD for ML-MMOH-CRF-1759
	{
		
		var sql = "SELECT RESULT_CATEGORY, RESULT_SUB_CATEGORY, FIELD_REF, FIELD_REF_DESC,DEFAULT_ORDER_SEQ, MANDATORY_YN FROM CA_LINK_CATEG_FIELD_LIST WHERE RESULT_CATEGORY =? AND RESULT_SUB_CATEGORY=? ORDER BY DEFAULT_ORDER_SEQ";
		parent.SectionConfigDispFlds.location.href="../../eCA/jsp/SectionConfigDispFlds.jsp?resCategory="+resCategory+"&pos1="+firstValue+"&pos2="+cnt+"&strSql="+sql+"&resSubCategory="+obj+"&qryMode="+qryMode+"&pageReload=pageReload";;
	
	}
	else if(firstValue != cnt)
	{
		
		parent.SectionConfigDispFlds.location.href="../../eCA/jsp/SectionConfigDispFlds.jsp?resCategory="+obj+"&pos1="+firstValue+"&pos2="+cnt+"&qryMode="+qryMode+"&pageReload=pageReload";
	}
}


function getSelected(obj, key)
{
	var sql = "SELECT RESULT_CATEGORY, RESULT_SUB_CATEGORY, FIELD_REF, FIELD_REF_DESC, MANDATORY_YN FROM CA_LINK_CATEG_FIELD_LIST WHERE RESULT_CATEGORY =? AND RESULT_SUB_CATEGORY=? ORDER BY DEFAULT_ORDER_SEQ";
	parent.SectionConfigDispFlds.location.href="../../eCA/jsp/SectionConfigDispFlds.jsp?resCategory="+key+"&pos1=0&pos2=0&strSql="+sql+"&resSubCategory="+obj.value+"&pageReload1=pageReload";
}


function addSelected(obj, key, cnt)
{
	if(obj.checked == true)
	{
		parent.IntermediateSectionConfigDispFlds.location.href="../../eCA/jsp/SectionConfigDispFldsIntermediate.jsp?key="+unescape(key)+"&mode=ADD&fieldCount="+cnt;
	}
	else
	{
		parent.IntermediateSectionConfigDispFlds.location.href="../../eCA/jsp/SectionConfigDispFldsIntermediate.jsp?key="+unescape(key)+"&mode=REMOVE";	
	}
}

function loadConf(content_type)
{
	if(content_type == 'R'){

		//Modified by Arvind On 17-12-08
		//parent.confDispID.rows = "8%,35%,*,0,6%";

		//parent.confDispID.rows = "42,*,290,0,50";
		
	parent.document.getElementById("commontoolbarFrame").style.height="8vh";
	parent.document.getElementById("f_query_add_mod").style.height="28vh";
	parent.document.getElementById("SectionConfigDispFlds").style.height="48vh";
	parent.document.getElementById("IntermediateSectionConfigDispFlds").style.height="0vh";
	parent.document.getElementById("messageFrame").style.height="9vh";
	
	}
}

function checkApplicable(obj)
{
	parent.f_query_add_mod.Section_form.applicable.value = obj.value;
	var resCategory = document.formSectionConfigDispFlds.resCategoryKey.value;

	if(obj.value == 'A')
	{
		if(resCategory == 'FEVT')
		{
			document.getElementById("tblDisplayHrd").style='display';
			document.getElementById("listResultLinked").disabled = false;
		}
		else if(resCategory == 'MHD') //Added for ML-MMOH-CRF-1759 Start
		{
			document.getElementById('tblDisplayHrd').style.display = 'inline';
			document.getElementById('mhdListResultLinked').disabled = false;
		}//Added for ML-MMOH-CRF-1759 End
		else
		{
			document.getElementById("tblDisplayGrd").style='display';
		}
	}
	else
	{
		if(resCategory == 'FEVT')
		{
			document.getElementById("tblDisplayHrd").style.display = 'none';
			document.getElementById("listResultLinked").disabled = true;
		}
		else if(resCategory == 'MHD') //Added for ML-MMOH-CRF-1759 Start
		{
			document.getElementById('tblDisplayHrd').style.display = 'none';
			document.getElementById('mhdListResultLinked').disabled = true;
		}//Added for ML-MMOH-CRF-1759 End
		else
		{
			document.getElementById("tblDisplayGrd").style.display = 'none';
		}
	}
}
//IN061907 start
function checkDiagResAutoLink(obj)
{
	var mode=document.forms[0].mode.value;
	if(mode=='insert' || mode=='modify')
	{
		if(obj.checked==true)
		{
			document.Section_form.res_auto_lnk_yn.value='Y';
		}
		else
		{
			document.Section_form.res_auto_lnk_yn.value='N';
		}
	}
}

function resultLinkOnload()
{
	if(document.forms[0].result_linked_rec_type.value=="DIAG")
	{
		document.getElementById("res_auto_link_desc").style='display';
		document.getElementById("res_auto_link_id").style='display';
	}
	else
	{
		document.getElementById("res_auto_link_desc").style.display = 'none';
		document.getElementById("res_auto_link_id").style.display = 'none';
	}
}
//IN061907 ends

