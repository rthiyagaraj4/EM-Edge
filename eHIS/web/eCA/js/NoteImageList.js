function create()
{
	f_query_add_mod.location.href='../../eCA/jsp/AddModifyNoteImageList.jsp';
}
function query()
{
	f_query_add_mod.location.href='../../eCA/jsp/QueryCriteriaNoteImageList.jsp';
}

function apply()
{	
	if(f_query_add_mod.document.ImageListForm != null)
	{
		var image_url = "";
		var mode = f_query_add_mod.document.ImageListForm.mode.value;
		var image_mode = f_query_add_mod.document.ImageListForm.image_mode.value;

		if(mode == "modify")
		{
			var imgExists="";
			if(f_query_add_mod.document.ImageListForm.imgExists)
			imgExists = f_query_add_mod.document.ImageListForm.imgExists.value;
			var fields = new Array ( f_query_add_mod.document.ImageListForm.image_ref_desc );
			var names = new Array (getLabel("Common.ImageDescription.label",'COMMON'));
			if(imgExists!="")
				image_url = f_query_add_mod.document.ImageListForm.image_url_add.value;
			else
				image_url = f_query_add_mod.document.ImageListForm.image_url.value;
		}
		else
		{
			if(image_mode=="upload")
			{
				var fields = new Array ( f_query_add_mod.document.ImageListForm.image_ref,
							f_query_add_mod.document.ImageListForm.image_ref_desc
							);
				var names = new Array ( getLabel("eCA.ImageReferenceID.label",'CA'),
								getLabel("Common.ImageDescription.label",'COMMON')
								);
				image_url = f_query_add_mod.document.ImageListForm.image_url.value;
			}
			else
			{
				var fields = new Array ( f_query_add_mod.document.ImageListForm.image_ref,
							f_query_add_mod.document.ImageListForm.image_ref_desc
							);
				
				var names = new Array ( getLabel("eCA.ImageReferenceID.label",'CA'),
								getLabel("Common.ImageDescription.label",'COMMON')
								);
				image_url = f_query_add_mod.document.ImageListForm.image_url_add.value;
			}
		}

		var filesplit = image_url.split("\\");
		var length = filesplit.length;
		f_query_add_mod.document.ImageListForm.image_name.value = filesplit[length-1];

		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
		{
			var fields1 = new Array ( f_query_add_mod.document.ImageListForm.image_ref);
			var names1 = new Array (getLabel("eCA.ImageReferenceID.label",'CA'));
	
			if (f_query_add_mod.SpecialCharCheck (fields1,names1,messageFrame,'M','MstCodeError.jsp'))
			{
				if(image_mode =="upload" && mode =="insert")
				{
							f_query_add_mod.document.forms[0].flag.value=false;
							f_query_add_mod.document.forms[0].record.value='Y';
							f_query_add_mod.document.forms[0].action="../../servlet/eCA.NoteImageListServlet";
							f_query_add_mod.document.forms[0].target="messageFrame";
							f_query_add_mod.document.forms[0].submit();

//					 var htmlVal = "<html><head><link ref='stylesheet' type='text/css' href='../../eCommon/html/IeStyle/css'> </link> </head> <body> <form name=tempForm method=post action='../../eCA/jsp/NoteImageListIntermediate.jsp'><input type=hidden name=image_name value='"+f_query_add_mod.document.ImageListForm.image_name.value+"'></form></body></html>"

//					 parent.frames[1].frames[2].document.write(htmlVal);
//					 parent.frames[1].frames[2].document.tempForm.submit();
//		  			 parent.frames[1].frames[0].location.reload();
		  		}
				else
				{
					f_query_add_mod.document.ImageListForm.flag.value=true;
					f_query_add_mod.document.forms[0].action="../../servlet/eCA.NoteImageListServlet";
					f_query_add_mod.document.forms[0].target="messageFrame";
					f_query_add_mod.document.ImageListForm.submit();
				}
			}
		}
	}
	else
	{
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=';
		return false;
	}
}
function onSuccess()
{
	
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
	{
		
		f_query_add_mod.location.href='../../eCA/jsp/AddModifyNoteImageList.jsp';
	}
	else
	{
	
	//	f_query_add_mod.location.reload();
		/*var image_ref = f_query_add_mod.document.ImageListForm.image_ref.value;
		var image_ref_desc = f_query_add_mod.document.ImageListForm.image_ref_desc.value;	
		var image_url = f_query_add_mod.document.ImageListForm.image_url.value;
		var eff_status =  f_query_add_mod.document.ImageListForm.enabled.value;
		var  mode =  f_query_add_mod.document.ImageListForm.mode.value;
		f_query_add_mod.location.href='../../eCA/jsp/AddModifyNoteImageList.jsp?image_ref='+ image_ref+'&image_ref_desc='+image_ref_desc+'&image_url='+image_url+'&eff_status='+eff_status+'&mode='+mode;*/
	}

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
		f_query_add_mod.document.forms[0].reset();

}

/*function reset()
{
	
		if(f_query_add_mod.document.forms[0]!=null){
	if(f_query_add_mod.document.forms[0].mode != null)
		{
			if(f_query_add_mod.document.forms[0].mode.value=="insert"|| f_query_add_mod.document.forms[0].mode.value=="modify")
			
				f_query_add_mod.location.href='../../eCA/jsp/AddModifyNoteImageList.jsp';
	}
	else
		f_query_add_mod.location.href='../../eCA/jsp/QueryCriteriaNoteImageList.jsp';
}
}*/

function Change_mode(obj)
{
	if(obj.value=="A")
	{
		//parent.f_query_add_mod.document.ImageListForm.all.img_add.style.display="inline";
		//parent.f_query_add_mod.document.ImageListForm.all.img_upload.style.display="none";
		parent.f_query_add_mod.document.getElementById(img_add).style.display="inline";
		parent.f_query_add_mod.document.getElementById(img_upload).style.display="none";
		parent.f_query_add_mod.document.getElementById(image_mode).value='add';
	}
	else
	{
		parent.f_query_add_mod.document.getElementById(img_upload).style.display="inline"
		parent.f_query_add_mod.document.getElementById(img_add).style.display="none"
		parent.f_query_add_mod.document.getElementById(image_mode).value='upload';
	}
}

function Change_status(obj)
{
	if(obj.checked== true)
		{
			document.forms[0].enabled1.value='E'
		}
		else
		{
			document.forms[0].enabled1.value='D'
		}
}
function chkPreviewFlag(obj){
	if(obj.value !=null && obj.value !='' && obj.value !="")
		document.ImageListForm.preview.disabled=false;
	else
		document.ImageListForm.preview.disabled=true;
}

function previewFile(){
	var filename	= document.ImageListForm.image_url.value;
	var mode	= document.ImageListForm.mode.value;
	var image_ref	=  document.ImageListForm.image_ref.value;
	var image_url_add	=  document.ImageListForm.image_url_add.value;
	if((mode=="modify") && (image_url_add !=""))
	{	/*fetches file from images folder or database */
		var filename="../../eCA/jsp/NoteImageListPreview.jsp?image_name="+escape(image_url_add)+"&image_ref="+image_ref+"&mode="+mode+"&imgExists="+document.ImageListForm.image_url_add.value;
		var window_obj = window.open(filename,'Preview',"height=570,width=790,top=0,left=0,resizable=yes,directories=no,location=no,menubar=no,status=no,scrollbars=yes");
		window_obj.addEventListener('load', function(){window_obj.document.body.style.backgroundColor = 'white';});
	}
	else
	{
		/*copies the file to a temp file and then reads the temp file.*/
		document.ImageListForm.previewMode.value="Y";		
		var filesplit = filename.split("\\");
		var length = filesplit.length;
		document.ImageListForm.image_name.value = filesplit[length-1];
		document.ImageListForm.submit();	
		
	}

}


