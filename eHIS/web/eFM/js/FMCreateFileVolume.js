function apply()
{	
	if(createvolume_criteria.document.forms[0] != null)
	{
		if(createvolume_header.document.forms[0].file_type_appl_yn.value == "N")
		{	
			var fields = new Array (createvolume_header.document.forms[0].patient_id,createvolume_header.document.forms[0].file_no);
			var names  = new Array (getLabel("Common.patientId.label","common"), getLabel("Common.fileno.label","common"));	
			if(createvolume_header.checkFields( fields, names, messageFrame))
			{   
				createvolume_criteria.document.forms[0].submit();
			}
		}
		else if(createvolume_header.document.forms[0].file_type_appl_yn.value == "Y")
		{
			var fields = new Array (frames[1].parent.createvolume_header.document.forms[0].patient_id,createvolume_header.document.forms[0].patient_file_type);
			var names  = new Array (getLabel("Common.patientId.label","common"), getLabel("Common.filetype.label","common"));	
			if(createvolume_header.checkFields(fields, names, messageFrame))
			{   
				if(frames[1].parent.createvolume_header.document.forms[0].patient_id.disabled == true)
					frames[1].parent.createvolume_header.document.forms[0].patient_id.disabled = false;
				createvolume_criteria.document.forms[0].submit();
			}
		}
	}
	else
	{
		frames[1].parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
	}
}
function fetchResults()
{
	var patient_id			= document.FMCreateFileVolumeSearchForm.patient_id.value;
	var file_type_appl_yn   = document.FMCreateFileVolumeSearchForm.file_type_appl_yn.value;
	var file_no				= "";
	var file_type_code		= "";
	var fields				= "";
	var names				= "";
	
	if(file_type_appl_yn == 'N')
	{
		fields = new Array (document.FMCreateFileVolumeSearchForm.patient_id,document.FMCreateFileVolumeSearchForm.file_no);
		names  = new Array ( getLabel("Common.patientId.label","common"), getLabel("Common.fileno.label","common"));
	}
	else if(file_type_appl_yn == 'Y')
	{
		file_type_code = document.FMCreateFileVolumeSearchForm.patient_file_type.value
	
		fields =  new Array (document.FMCreateFileVolumeSearchForm.patient_id,document.FMCreateFileVolumeSearchForm.patient_file_type);
		names  =  new Array (getLabel("Common.patientId.label","common"), getLabel("Common.filetype.label","common"));
	}
	if(checkFields(fields,names,parent.messageFrame))
	{
		parent.frames[3].document.location.href="../../eCommon/jsp/error.jsp";
		
		file_no = document.FMCreateFileVolumeSearchForm.file_no.value;

		parent.createvolume_criteria.location.href="../../eFM/jsp/FMCreateFileVolumeResult.jsp?file_type_appl_yn="+file_type_appl_yn+"&file_type_code="+file_type_code+"&patient_id="+patient_id+"&file_no="+file_no+" ";
		
		return true;
	}
}
function ClearAll()
{
	parent.createvolume_criteria.location.href='../../eCommon/html/blank.html';
	parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
}
function reset()
{
	frames[1].location.reload();
	frames[1].parent.createvolume_criteria.location.href="../../eCommon/html/blank.html";
	frames[1].parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
}
function onSuccess()
{
	frames[1].location.reload();
	frames[1].parent.createvolume_criteria.location.href='../../eCommon/html/blank.html';
}
