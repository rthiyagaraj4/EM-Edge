

function reset() {
	
	menuFrame.document.forms[0].reset();
	f_query_add_mod.location.href='../../eCommon/html/blank.html';
	
	if(f_query_add_mod.document.repSectionForNoteType){
	f_query_add_mod.document.repSectionForNoteType.reset() ;
	}
	if(f_query_add_mod.document.repNoteTypeByService){
	f_query_add_mod.document.repNoteTypeByService.reset() ;
	}
	if(f_query_add_mod.document.repNoteTypeForResp){
	f_query_add_mod.document.repNoteTypeForResp.reset() ;
	}
	if(f_query_add_mod.document.repSubSection){
	f_query_add_mod.document.repSubSection.reset() ;
	}
	if(f_query_add_mod.document.repSection){
	f_query_add_mod.document.repSection.reset() ;
	}
	if(f_query_add_mod.document.repNoteType){
	f_query_add_mod.document.repNoteType.reset() ;
	}
	if(f_query_add_mod.document.repTextBlock){
	f_query_add_mod.document.repTextBlock.reset() ;
	}
	if(f_query_add_mod.document.repLocnForPract){
	f_query_add_mod.document.repLocnForPract.reset() ;
	}
	if(f_query_add_mod.document.repUnsignedNote){
	f_query_add_mod.document.repUnsignedNote.reset() ;
	}
}//e.o.reset

function run()
{
	
	if(f_query_add_mod.document.forms[0])
		{	alert(f_query_add_mod.getMessage('GEN_REP','CA'));
		}
		else
	{
			var msg =menuFrame.getMessage('SELECT_PLEASE','CA')+" "+menuFrame.getLabel("Common.code.label","Common");
			alert(msg);
	}

if(f_query_add_mod.document.repSectionForNoteType)
{
	if( f_query_add_mod.document.repSectionForNoteType.p_fr_note_type1.value==''|| f_query_add_mod.document.repSectionForNoteType.p_fr_note_type1.value==null){
		f_query_add_mod.document.repSectionForNoteType.p_fr_note_type.value='';
	}
	
	if( f_query_add_mod.document.repSectionForNoteType.p_to_note_type1.value==''|| f_query_add_mod.document.repSectionForNoteType.p_to_note_type1.value==null){
		f_query_add_mod.document.repSectionForNoteType.p_to_note_type.value='';
	}	

	if( f_query_add_mod.ValidateCheckString('Note Type', f_query_add_mod.document.repSectionForNoteType.p_fr_note_type,f_query_add_mod.document.repSectionForNoteType.p_to_note_type, messageFrame )  )
			f_query_add_mod.document.repSectionForNoteType.submit() ;
}
if(f_query_add_mod.document.repNoteTypeByService)
{
	if( f_query_add_mod.document.repNoteTypeByService.p_fr_note_type1.value==''|| f_query_add_mod.document.repNoteTypeByService.p_fr_note_type1.value==null){
		f_query_add_mod.document.repNoteTypeByService.p_fr_note_type.value='';
	}
	if( f_query_add_mod.document.repNoteTypeByService.p_to_note_type1.value==''|| f_query_add_mod.document.repNoteTypeByService.p_to_note_type1.value==null){
		f_query_add_mod.document.repNoteTypeByService.p_to_note_type.value='';
	}
	if( f_query_add_mod.ValidateCheckString('Service', f_query_add_mod.document.repNoteTypeByService.p_fr_note_type,f_query_add_mod.document.repNoteTypeByService.p_to_note_type, messageFrame )  )
			f_query_add_mod.document.repNoteTypeByService.submit() ;
}

if(f_query_add_mod.document.repNoteTypeForResp)
{
	if( f_query_add_mod.document.repNoteTypeForResp.p_fr_resp_id1.value==''|| f_query_add_mod.document.repNoteTypeForResp.p_fr_resp_id1.value==null){
		f_query_add_mod.document.repNoteTypeForResp.p_fr_resp_id.value='';
	}
	if( f_query_add_mod.document.repNoteTypeForResp.p_to_resp_id1.value==''|| f_query_add_mod.document.repNoteTypeForResp.p_to_resp_id1.value==null){
		f_query_add_mod.document.repNoteTypeForResp.p_to_resp_id.value='';
	}
	if( f_query_add_mod.ValidateCheckString('Note Type', f_query_add_mod.document.repNoteTypeForResp.p_fr_resp_id,f_query_add_mod.document.repNoteTypeForResp.p_to_resp_id, messageFrame )  )
			f_query_add_mod.document.repNoteTypeForResp.submit() ;
}

if(f_query_add_mod.document.repSubSection)
{
	if( f_query_add_mod.document.repSubSection.p_fr_header_code1.value==''|| f_query_add_mod.document.repSubSection.p_fr_header_code1.value==null){
		f_query_add_mod.document.repSubSection.p_fr_header_code.value='';
	}
	if( f_query_add_mod.document.repSubSection.p_to_header_code1.value==''|| f_query_add_mod.document.repSubSection.p_to_header_code1.value==null){
		f_query_add_mod.document.repSubSection.p_to_header_code.value='';
	}
	if( f_query_add_mod.ValidateCheckString('Sub-Section', f_query_add_mod.document.repSubSection.p_fr_header_code,f_query_add_mod.document.repSubSection.p_to_header_code, messageFrame )  )
			f_query_add_mod.document.repSubSection.submit() ;
	
}

if(f_query_add_mod.document.repSection)
{
	if( f_query_add_mod.document.repSection.p_fr_sec_hdg_code1.value==''|| f_query_add_mod.document.repSection.p_fr_sec_hdg_code1.value==null){
		f_query_add_mod.document.repSection.p_fr_sec_hdg_code.value='';
	}
	if( f_query_add_mod.document.repSection.p_to_sec_hdg_code1.value==''|| f_query_add_mod.document.repSection.p_to_sec_hdg_code1.value==null){
		f_query_add_mod.document.repSection.p_to_sec_hdg_code.value='';
	}
	if( f_query_add_mod.ValidateCheckString('Section', f_query_add_mod.document.repSection.p_fr_sec_hdg_code,f_query_add_mod.document.repSection.p_to_sec_hdg_code, messageFrame )  )
			f_query_add_mod.document.repSection.submit() ;
	
}

if(f_query_add_mod.document.repNoteType){

	if( f_query_add_mod.document.repNoteType.p_fr_note_type1.value==''|| f_query_add_mod.document.repNoteType.p_fr_note_type1.value==null){
		 f_query_add_mod.document.repNoteType.p_fr_note_type.value='';
	}
	if(	f_query_add_mod.document.repNoteType.p_to_note_type1.value==''|| f_query_add_mod.document.repNoteType.p_to_note_type1.value==null){
		 f_query_add_mod.document.repNoteType.p_to_note_type.value='';
	}
	
	if( f_query_add_mod.ValidateCheckString('Note Type', f_query_add_mod.document.repNoteType.p_fr_note_type,f_query_add_mod.document.repNoteType.p_to_note_type, messageFrame )  )
			f_query_add_mod.document.repNoteType.submit() ;
	}

if(f_query_add_mod.document.repTextBlock){

	if(f_query_add_mod.document.repTextBlock.p_fr_text_blk_id.value==''||f_query_add_mod.document.repTextBlock.p_fr_text_blk_id.value==null){
		f_query_add_mod.document.repTextBlock.p_fr_text_blk_id.value='';
	}
	if(f_query_add_mod.document.repTextBlock.p_to_text_blk_id.value==''||f_query_add_mod.document.repTextBlock.p_to_text_blk_id.value==null){
		f_query_add_mod.document.repTextBlock.p_to_text_blk_id.value='';
	}
	if( f_query_add_mod.ValidateCheckString('Text Block', f_query_add_mod.document.repTextBlock.p_fr_text_blk_id.value,f_query_add_mod.document.repTextBlock.p_to_text_blk_id.value, messageFrame )  )
			f_query_add_mod.document.repTextBlock.submit() ;
}

if(f_query_add_mod.document.repLocnForPract){	
	
	if(f_query_add_mod.document.repLocnForPract.p_fr_practitioner_id1.value==''||f_query_add_mod.document.repLocnForPract.p_fr_practitioner_id1.value==null){
		f_query_add_mod.document.repLocnForPract.p_fr_practitioner_id.value='';
	}
	if(f_query_add_mod.document.repLocnForPract.p_to_practitioner_id1.value==''||f_query_add_mod.document.repLocnForPract.p_to_practitioner_id1.value==null){
		f_query_add_mod.document.repLocnForPract.p_to_practitioner_id.value='';
	}	
	
	//f_query_add_mod.document.repLocnForPract.p_fr_practitioner_id1.blur();
	//f_query_add_mod.document.repLocnForPract.p_to_practitioner_id1.blur();

	if( f_query_add_mod.ValidateCheckString('Practitioner ', f_query_add_mod.document.repLocnForPract.p_fr_practitioner_id,f_query_add_mod.document.repLocnForPract.p_to_practitioner_id, messageFrame )  )		
			f_query_add_mod.document.repLocnForPract.submit() ;
}
}//e.o.run

//Function for the file name CAMasterCodeList
function callFunctionTextBlock(sql,title,target)
{
	
	var serviceVal   ="";
	var search_desc	= "";
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
	argArray[8] = "C";
	retArray = CACommonLookup(title, argArray );	
	return retArray;
 }

async function callFunction(sql,title,target)
{
	
	var serviceVal   ="";
	var search_desc	= "";
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

	retArray =await CommonLookup(title, argArray );
	return retArray;
 }
/* function callFunctionTextBlock(sql,title,target)
{
	
	var serviceVal   ="";
	var search_desc	= "";
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
	argArray[7] = CODE_DESC;
	retArray = CommonLookup(title, argArray );
	return retArray;
 }*/
//Function for the file name repMasterCodeList.jsp-start
function codeCheck(Obj){
var u=Obj;
if(u==''){
parent.f_query_add_mod.location.href='../../eCommon/html/blank.html';
}
if(u==1){
parent.f_query_add_mod.location.href ="../../eCA/jsp/repLocnForPract.jsp";
}
if(u==2){
parent.f_query_add_mod.location.href ="../../eCA/jsp/repSection.jsp";
}
if(u==3){
parent.f_query_add_mod.location.href ="../../eCA/jsp/repSubSection.jsp";
}
if(u==4){
parent.f_query_add_mod.location.href ="../../eCA/jsp/repNoteType.jsp";
}
if(u==5){
parent.f_query_add_mod.location.href ="../../eCA/jsp/repSectionForNoteType.jsp";
}
if(u==6){
parent.f_query_add_mod.location.href ="../../eCA/jsp/repNoteTypeByService.jsp";
}
if(u==7){
parent.f_query_add_mod.location.href ="../../eCA/jsp/repNoteTypeForResp.jsp";
}

if(u==8){
parent.f_query_add_mod.location.href ="../../eCA/jsp/repTextBlock.jsp";
}
/*if(u==9){
parent.f_query_add_mod.location.href ="../../eCA/jsp/repTemplateComponent.jsp";
}
if(u==10){
parent.f_query_add_mod.location.href ="../../eCA/jsp/repSectionTemplate.jsp";
}
*/
}
//

//Function for the file name repMasterCodeList.jsp-end


//Function for the file name repSection.jsp-start




async function search_Code(obj,target)
{
	var p_facility_id= document.repSection.p_facility_id.value;
	if(obj.name=='p_fr_sec_hdg_code1')
	{
		if((obj.value) == "null" || (obj.value ==""))
		{
			return false;			
		}
		else
		{
			//searchCode(obj,target);
			var objname=obj.name;
			var descriptionval=obj.value;
			parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	        var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/CAMasterCodeListIntermediate.jsp'><input type='hidden' name='description' id='description' value='"+descriptionval+"'><input type='hidden' name='p_facility_id' id='p_facility_id' value='"+p_facility_id+"'><input type=hidden name='selFunVal' id='selFunVal' value='From_codesection'><input type=hidden name='PageName' id='PageName' value='repSection'></form></body></html>";
			parent.f_query_intermediate.document.write(HTMLVal);
			if(parent.f_query_intermediate.document.tempform1)
				parent.f_query_intermediate.document.tempform1.submit(); 
		}
	}
	else if(obj.name=='p_to_sec_hdg_code1')
	{
		if((obj.value) == "null" || (obj.value ==""))
		{
			return false;			
		}
		else
		{
			//searchCode(obj,target);
			var objname=obj.name;
			var descriptionval=obj.value;
			parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	        var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body  onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/CAMasterCodeListIntermediate.jsp'><input type='hidden' name='description' id='description' value='"+descriptionval+"'><input type='hidden' name='p_facility_id' id='p_facility_id' value='"+p_facility_id+"'><input type=hidden name='selFunVal' id='selFunVal' value='To_codesection'><input type=hidden name='PageName' id='PageName' value='repSection'></form></body></html>";
			parent.f_query_intermediate.document.write(HTMLVal);
			if(parent.f_query_intermediate.document.tempform1)
				parent.f_query_intermediate.document.tempform1.submit(); 
		}
	}
	else if(obj.name=='locn' || obj.name=='locn1')
	{		
		searchCode(obj,target);
	}	
}

async function searchCode(obj,target)
{
			var p_facility_id=document.repSection.p_facility_id.value;
			var retVal = 	new String();
			var dialogHeight= "400px" ;
			var dialogWidth	= "700px" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var title="";		
			var  fac_id='';
			if(obj.name=="locn")
			{
				title=getLabel("Common.Section.label","Common");
				sql="select sec_hdg_code code, sec_hdg_desc description from ca_section_hdg where upper(sec_hdg_code) like upper(?) and upper(sec_hdg_desc) like upper(?)";
				search_code="sec_hdg_code";
				search_desc= "sec_hdg_desc";
			}
			
			if(obj.name=="locn1")
			{
				title=getLabel("Common.Section.label","Common");
				sql="select sec_hdg_code code, sec_hdg_desc description from ca_section_hdg where upper(sec_hdg_code) like upper(?) and upper(sec_hdg_desc) like upper(?)";
				search_code="SEC_HDG_CODE";
				search_desc= "sec_hdg_desc";
			}
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
				retArray =  await CommonLookup( title,argArray );
				if(retArray != null && retArray !="")	
				{
					var str =unescape(retArray);
				 	var arr = str.split(",");
					if(obj.name=="locn")
					{							
						document.repSection.p_fr_sec_hdg_code1.value= arr[1];						
						document.repSection.p_fr_sec_hdg_code.value= arr[0];						
					}
					else if(obj.name=="locn1")
					{
						document.repSection.p_to_sec_hdg_code1.value= arr[1];
						document.repSection.p_to_sec_hdg_code.value= arr[0];
					}
				}
				else
				{
					if(obj.name=="locn")
					{							
						document.repSection.p_fr_sec_hdg_code1.value="";						
						document.repSection.p_fr_sec_hdg_code.value="";						
					}
					else if(obj.name=="locn1")
					{
						document.repSection.p_to_sec_hdg_code1.value="";
						document.repSection.p_to_sec_hdg_code.value="";
					}	
				}
}


/*function searchCode(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			//var facility=obj1.value;
			if(obj.name=="locn")
			{
				tit=getLabel("Common.Section.label","Common");
				sql="select sec_hdg_code, sec_hdg_desc from ca_section_hdg";
				search_code="sec_hdg_code";
				search_desc= "sec_hdg_desc";
			}
			
			if(obj.name=="locn1")
			{
				tit=getLabel("Common.Section.label","Common");
				sql="select sec_hdg_code, sec_hdg_desc from ca_section_hdg";
				search_code="SEC_HDG_CODE";
				search_desc= "sec_hdg_desc";
			}
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
			target.focus();
	}*/
//Function for the file name repSection.jsp-end

//Function for the file name repSubSection.jsp-start

async function search_Codeforsubsection(obj,target)
{
	var p_facility_id=await document.repSubSection.p_facility_id.value;
	if(obj.name=='p_fr_header_code1')
	{
		if((obj.value) == "null" || (obj.value ==""))
		{
			return false;			
		}
		else
		{
			//searchCodeforsubsection(obj,target);
			var objname=obj.name;
			var descriptionval=obj.value;
			parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	        var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body  onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/CAMasterCodeListIntermediate.jsp'><input type='hidden' name='description' id='description' value='"+descriptionval+"'><input type='hidden' name='p_facility_id' id='p_facility_id' value='"+p_facility_id+"'><input type=hidden name='selFunVal' id='selFunVal' value='From_subSection'><input type=hidden name='PageName' id='PageName' value='repsubSection'></form></body></html>";
			parent.f_query_intermediate.document.write(HTMLVal);
			if(parent.f_query_intermediate.document.tempform1)
				parent.f_query_intermediate.document.tempform1.submit(); 
		}
	}
	else if(obj.name=='p_to_header_code1')
	{
		if((obj.value) == "null" || (obj.value ==""))
		{
			return false;			
		}
		else
		{
			//searchCodeforsubsection(obj,target);
			var objname=obj.name;
			var descriptionval=obj.value;
			parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	        var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body  onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/CAMasterCodeListIntermediate.jsp'><input type='hidden' name='description' id='description' value='"+descriptionval+"'><input type='hidden' name='p_facility_id' id='p_facility_id' value='"+p_facility_id+"'><input type=hidden name='selFunVal' id='selFunVal' value='To_subSection'><input type=hidden name='PageName' id='PageName' value='repsubSection'></form></body></html>";
			parent.f_query_intermediate.document.write(HTMLVal);
			if(parent.f_query_intermediate.document.tempform1)
				parent.f_query_intermediate.document.tempform1.submit(); 

		}
	}
	else if(obj.name=='ssec' || obj.name=='ssec1')
	{		
		searchCodeforsubsection(obj,target);
	}	
}

async function searchCodeforsubsection(obj,target)
{
			var p_facility_id=await document.repSubSection.p_facility_id.value;
			var retVal = 	new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var title="";		
			var  fac_id='';
					
			if(obj.name=="ssec"||obj.name=="ssec1")
			{
				title=getLabel("Common.Section.label","Common");	
				sql="SELECT sec_hdg_code code, sec_hdg_desc description from ca_section_hdg where content_type ='S' and upper(sec_hdg_code) like upper(?) and upper(sec_hdg_desc) like upper(?) ";
				search_code="sec_hdg_code";
				search_desc= "sec_hdg_desc";
			}			
			
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
				retArray =await CommonLookup( title,argArray );
				if(retArray != null && retArray !="")	
				{
					var str =unescape(retArray);
				 	var arr = str.split(",");
					if(obj.name=="ssec"||obj.name=="p_fr_header_code1")
					{							
						document.repSubSection.p_fr_header_code1.value= arr[1];						
						document.repSubSection.p_fr_header_code.value= arr[0];						
					}
					else if(obj.name=="ssec1"||obj.name=="p_to_header_code1")
					{
						document.repSubSection.p_to_header_code1.value= arr[1];
						document.repSubSection.p_to_header_code.value= arr[0];
					}
				}
				else
				{
					if(obj.name=="ssec"||obj.name=="p_fr_header_code1")
					{							
						document.repSubSection.p_fr_header_code1.value="";						
						document.repSubSection.p_fr_header_code.value="";						
					}
					else if(obj.name=="ssec1"||obj.name=="p_to_header_code1")
					{
						document.repSubSection.p_to_header_code1.value="";
						document.repSubSection.p_to_header_code.value="";
					}	
				}
}



/*function searchCodeforsubsection(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";

			if(obj.name=="sec")
			{
				tit=getLabel("Common.Section.label","Common");
				sql="SELECT sec_hdg_code code, sec_hdg_desc description from ca_section_hdg where content_type = 'S' and upper(sec_hdg_code) like upper(?) and upper(sec_hdg_desc) like upper(?)" ;
				search_code="sec_hdg_code";
				search_desc= "sec_hdg_desc";
			}

			if(obj.name=="sec1")
			{
				tit=getLabel("Common.Section.label","Common");
				sql="SELECT sec_hdg_code code, sec_hdg_desc description FROM ca_section_hdg where content_type ='S' and upper(sec_hdg_code) like upper(?) and upper(sec_hdg_desc) like upper(?) ";
				//sql="SELECT sec_hdg_code, sec_hdg_desc from ca_section_hdg where  eff_status="+E ;
				search_code="SEC_HDG_CODE";
				search_desc= "sec_hdg_desc";
			}

			if(obj.name=="ssec")
			{
				tit=getLabel("Common.Section.label","Common");
	//			sql="SELECT sec_hdg_code, sec_hdg_desc from ca_section_hdg WHERE eff_status="+E;
				sql="SELECT sec_hdg_code code, sec_hdg_desc description from ca_section_hdg where content_type ='S' and upper(sec_hdg_code) like upper(?) and upper(sec_hdg_desc) like upper(?) ";
				search_code="sec_hdg_code";
				search_desc= "sec_hdg_desc";
			}
			
			if(obj.name=="ssec1")
			{
				tit=getLabel("Common.Section.label","Common");
//				sql="SELECT sec_hdg_code, sec_hdg_desc FROM ca_section_hdg WHERE eff_status="+E;
				sql="SELECT sec_hdg_code code, sec_hdg_desc description from ca_section_hdg where content_type ='S' and upper(sec_hdg_code) like upper(?) and upper(sec_hdg_desc) like upper(?)";
				search_code="SEC_HDG_CODE";
				search_desc= "sec_hdg_desc";
			}

			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			//retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);
			
			var argArray		= new Array();
			var namesArray		= new Array();
			var valuesArray		= new Array();
			var datatypesArray	= new Array();
		
			argArray[0] = sql;
			argArray[1] = namesArray;
			argArray[2] = valuesArray;
			argArray[3] = datatypesArray;
			argArray[4] = "2,1";
			argArray[5] = "";//target.value;
			argArray[6] = DESC_LINK;
			argArray[7] = CODE_DESC;
			retVal = await CommonLookup( tit, argArray );
			
			if (retVal != null && retVal != '' && retVal != "null")
			{
				target.value=retVal[0];
				
			}
			else{
			target.value="";
			target.focus();
			}
	}*/

//Function for the file name repSubSection.jsp-end

//Function for the file name repNoteType.jsp-start


async function search_Codefornotetype(obj,target)
{
	var p_facility_id=document.repNoteType.p_facility_id.value;
	if(obj.name=='p_fr_note_type1')
	{
		if((obj.value) == "null" || (obj.value ==""))
		{
			return false;			
		}
		else
		{
			//searchCodefornotetype(obj,target);
			var objname=obj.name;
			var descriptionval=obj.value;
			parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	        var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body  onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/CAMasterCodeListIntermediate.jsp'><input type='hidden' name='description' id='description' value='"+descriptionval+"'><input type='hidden' name='p_facility_id' id='p_facility_id' value='"+p_facility_id+"'><input type=hidden name='selFunVal' id='selFunVal' value='From_code'><input type=hidden name='PageName' id='PageName' value='repNoteType'></form></body></html>";
			parent.f_query_intermediate.document.write(HTMLVal);
			if(parent.f_query_intermediate.document.tempform1)
				parent.f_query_intermediate.document.tempform1.submit(); 


		}
	}
	else if(obj.name=='p_to_note_type1')
	{
		if((obj.value) == "null" || (obj.value ==""))
		{
			return false;			
		}
		else
		{
			//searchCodefornotetype(obj,target);
			var objname=obj.name;
			var descriptionval=obj.value;
			parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	        var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body  onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/CAMasterCodeListIntermediate.jsp'><input type='hidden' name='description' id='description' value='"+descriptionval+"'><input type='hidden' name='p_facility_id' id='p_facility_id' value='"+p_facility_id+"'><input type=hidden name='selFunVal' id='selFunVal' value='To_code'><input type=hidden name='PageName' id='PageName' value='repNoteType'></form></body></html>";
			parent.f_query_intermediate.document.write(HTMLVal);
			if(parent.f_query_intermediate.document.tempform1)
				parent.f_query_intermediate.document.tempform1.submit(); 
		}
	}
	else if(obj.name=='locn' || obj.name=='locn1')
	{		
		searchCodefornotetype(obj,target);
	}	
}

async function searchCodefornotetype(obj,target)
{
			var p_facility_id=document.repNoteType.p_facility_id.value;
			var retVal = 	new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var title="";		
			var  fac_id='';
			if(obj.name=="locn") 
			{
				title=getLabel("Common.NoteType.label","Common");
				sql="select note_type code, note_type_desc description from ca_note_type where upper(note_type) like upper(?) and upper(note_type_desc) like upper(?) order by 2";
				search_code="note_type";
				search_desc= "note_type_desc";
			}		
	
			if(obj.name=="locn1")
			{
				title=getLabel("Common.NoteType.label","Common");
				sql="select note_type code, note_type_desc description from ca_note_type where upper(note_type) like upper(?) and upper(note_type_desc) like upper(?) order by 2";
				search_code="note_type";
				search_desc= "note_type_desc";
			}
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
				retArray =await CommonLookup( title,argArray );
				if(retArray != null && retArray !="")	
				{
					var str =unescape(retArray);
				 	var arr = str.split(",");
					if(obj.name=="locn")
					{							
						document.repNoteType.p_fr_note_type1.value= arr[1];						
						document.repNoteType.p_fr_note_type.value= arr[0];						
					}
					else if(obj.name=="locn1" )
					{
						document.repNoteType.p_to_note_type1.value= arr[1];
						document.repNoteType.p_to_note_type.value= arr[0];
					}
				}
				else
				{
					if(obj.name=="locn")
					{							
						document.repNoteType.p_fr_note_type1.value="";						
						document.repNoteType.p_fr_note_type.value="";						
					}
					else if(obj.name=="locn1")
					{
						document.repNoteType.p_to_note_type1.value="";
						document.repNoteType.p_to_note_type.value="";
					}		
				}
}



//Function for the file name repNoteType.jsp-end

//Function for the file name repNoteTypeByService.jsp-start


async function search_Codeforservice(obj,target)
{
	var p_facility_id=document.repNoteTypeByService.p_facility_id.value;
	if(obj.name=='p_fr_note_type1')
	{
		if((obj.value) == "null" || (obj.value ==""))
		{
			return false;			
		}
		else
		{
			//searchCodeforservice(obj,target);
			var objname=obj.name;
			var descriptionval=obj.value;
			parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	        var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body  onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/CAMasterCodeListIntermediate.jsp'><input type='hidden' name='description' id='description' value='"+descriptionval+"'><input type='hidden' name='p_facility_id' id='p_facility_id' value='"+p_facility_id+"'><input type=hidden name='selFunVal' id='selFunVal' value='From_NoteTypeService'><input type=hidden name='PageName' id='PageName' value='repNoteTypeByService'></form></body></html>";
			parent.f_query_intermediate.document.write(HTMLVal);
			if(parent.f_query_intermediate.document.tempform1)
				parent.f_query_intermediate.document.tempform1.submit(); 
		}
	}
	else if(obj.name=='p_to_note_type1')
	{
		if((obj.value) == "null" || (obj.value ==""))
		{
			return false;			
		}
		else
		{
			//searchCodeforservice(obj,target);
			var objname=obj.name;
			var descriptionval=obj.value;
			parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	        var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body  onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/CAMasterCodeListIntermediate.jsp'><input type='hidden' name='description' id='description' value='"+descriptionval+"'><input type='hidden' name='p_facility_id' id='p_facility_id' value='"+p_facility_id+"'><input type=hidden name='selFunVal' id='selFunVal' value='To_NoteTypeService'><input type=hidden name='PageName' id='PageName' value='repNoteTypeByService'></form></body></html>";
			parent.f_query_intermediate.document.write(HTMLVal);
			if(parent.f_query_intermediate.document.tempform1)
				parent.f_query_intermediate.document.tempform1.submit(); 
		}
	}
	else if(obj.name=='note' || obj.name=='note1')
	{		
		searchCodeforservice(obj,target);
	}	
}

async function searchCodeforservice(obj,target)
{
			var p_facility_id=document.repNoteTypeByService.p_facility_id.value;
			var retVal = 	new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var title="";		
			var  fac_id='';
			if(obj.name=="note"||obj.name=="note1")
			{
				title=getLabel("Common.NoteType.label","Common");
				sql=" Select note_type code,note_type_desc description  from ca_note_type where upper(note_type) like upper(?) and upper(note_type_desc) like upper(?) and SERV_FACL_SPEC_YN = 'Y' order by 2 ";
				search_code="note_type";
				search_desc= "note_type_desc";
			}
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
				retArray =await CommonLookup( title,argArray );
				if(retArray != null && retArray !="")	
				{
					var str =unescape(retArray);
				 	var arr = str.split(",");
					if(obj.name=="note")
					{							
						document.repNoteTypeByService.p_fr_note_type1.value= arr[1];						
						document.repNoteTypeByService.p_fr_note_type.value= arr[0];						
					}
					else if(obj.name=="note1" )
					{
						document.repNoteTypeByService.p_to_note_type1.value= arr[1];
						document.repNoteTypeByService.p_to_note_type.value= arr[0];
					}
				}
				else
				{
					if(obj.name=="note")
					{							
						document.repNoteTypeByService.p_fr_note_type1.value="";						
						document.repNoteTypeByService.p_fr_note_type.value="";						
					}
					else if(obj.name=="note1")
					{
						document.repNoteTypeByService.p_to_note_type1.value="";
						document.repNoteTypeByService.p_to_note_type.value="";
					}		
				}
}


/*function searchCodeforservice(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
	
			if(obj.name=="serv")
			{
				//tit="Service"
				tit=getLabel("Common.service.label","Common");
				sql=" Select service_code code,service_desc from ca_note_type_by_serv_vw where upper(service_code) like upper(?) and upper(service_desc) like upper(?) ";
				search_code="service_code";
				search_desc= "service_desc";
			}

			if(obj.name=="serv1")
			{
				//tit="Service"
				tit=getLabel("Common.service.label","Common");
				sql=" Select service_code code,service_desc description from ca_note_type_by_serv_vw where upper(service_code) like upper(?) and upper(service_desc) like upper(?) ";
				search_code="service_code";
				search_desc= "service_desc";
			}

			if(obj.name=="note")
			{
				//tit="Note Type"
				tit=getLabel("Common.NoteType.label","Common");
				sql=" Select note_type code,note_type_desc description  from ca_note_type where upper(note_type) like upper(?) and upper(note_type_desc) like upper(?) and SERV_FACL_SPEC_YN = 'Y' ";
				search_code="note_type";
				search_desc= "note_type_desc";
			}
			
			if(obj.name=="note1")
			{
				//tit="Note Type"
				tit=getLabel("Common.NoteType.label","Common");
				sql=" Select note_type code,note_type_desc description from ca_note_type where upper(note_type) like upper(?) and upper(note_type_desc) like upper(?) and SERV_FACL_SPEC_YN = 'Y'";
				search_code="note_type";
				search_desc= "note_type_desc";
			}
			//and upper(locn_code) like upper(?) and upper(short_desc) like upper(?)
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			//retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);
			
			var argArray		= new Array();
			var namesArray		= new Array();
			var valuesArray		= new Array();
			var datatypesArray	= new Array();
		
			argArray[0] = sql;
			argArray[1] = namesArray;
			argArray[2] = valuesArray;
			argArray[3] = datatypesArray;
			argArray[4] = "2,1";
			argArray[5] = "";//target.value;
			argArray[6] = DESC_LINK;
			argArray[7] = CODE_DESC;
			retVal = await CommonLookup( tit, argArray );	
			
				
			if (!(retVal == null) && !(retVal == ""))
			{
				target.value=retVal[0];
				
					
			}
			else{
			target.value="";
			target.focus();}
	}*/

//Function for the file name repNoteTypeByService.jsp-end

//Function for the file name repNoteTypeForResp.jsp-start


async function search_Codeforres(obj,target)
{
	var p_facility_id=document.repNoteTypeForResp.p_facility_id.value;
	if(obj.name=='p_fr_resp_id1')
	{
		if((obj.value) == "null" || (obj.value ==""))
		{
			return false;			
		}
		else
		{
			//searchCodeforres(obj,target);
			var objname=obj.name;
			var descriptionval=obj.value;
			parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	        var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body  onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/CAMasterCodeListIntermediate.jsp'><input type='hidden' name='description' id='description' value='"+descriptionval+"'><input type='hidden' name='p_facility_id' id='p_facility_id' value='"+p_facility_id+"'><input type=hidden name='selFunVal' id='selFunVal' value='From_Resp'><input type=hidden name='PageName' id='PageName' value='repNoteTypeForResp'></form></body></html>";
			parent.f_query_intermediate.document.write(HTMLVal);
			if(parent.f_query_intermediate.document.tempform1)
				parent.f_query_intermediate.document.tempform1.submit(); 
		}
	}
	else if(obj.name=='p_to_resp_id1')
	{
		if((obj.value) == "null" || (obj.value ==""))
		{
			return false;			
		}
		else
		{
			//searchCodeforres(obj,target);
			var objname=obj.name;
			var descriptionval=obj.value;
			parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	        var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body  onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/CAMasterCodeListIntermediate.jsp'><input type='hidden' name='description' id='description' value='"+descriptionval+"'><input type='hidden' name='p_facility_id' id='p_facility_id' value='"+p_facility_id+"'><input type=hidden name='selFunVal' id='selFunVal' value='To_resp'><input type=hidden name='PageName' id='PageName' value='repNoteTypeForResp'></form></body></html>";
			parent.f_query_intermediate.document.write(HTMLVal);
			if(parent.f_query_intermediate.document.tempform1)
				parent.f_query_intermediate.document.tempform1.submit(); 
		}
	}
	else if(obj.name=='resp' || obj.name=='resp1')
	{		
		searchCodeforres(obj,target);
	}	
}

async function searchCodeforres(obj,target)
{
			var p_facility_id=document.repNoteTypeForResp.p_facility_id.value;
			var retVal = 	new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var title="";		
			var  fac_id='';

				title="Responsibility";
				sql=" Select resp_id code,resp_name description from sm_resp where upper(resp_id) like upper(?) and upper(resp_name) like upper(?) order by 2 ";
				search_code="resp_id";
				search_desc= "resp_name";			
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
				retArray =await CommonLookup( title,argArray );
				if(retArray != null && retArray !="")	
				{
					var str =unescape(retArray);
				 	var arr = str.split(",");
					if(obj.name=="resp" )//|| obj.name=="p_fr_resp_id1")
					{							
						document.repNoteTypeForResp.p_fr_resp_id1.value= arr[1];						
						document.repNoteTypeForResp.p_fr_resp_id.value= arr[0];						
					}
					else if(obj.name=="resp1")// || obj.name=="p_to_resp_id1")
					{
						document.repNoteTypeForResp.p_to_resp_id1.value= arr[1];
						document.repNoteTypeForResp.p_to_resp_id.value= arr[0];
					}
				}
				else
				{
					if(obj.name=="resp" )//|| obj.name=="p_fr_resp_id1")
					{							
						document.repNoteTypeForResp.p_fr_resp_id1.value= "";						
						document.repNoteTypeForResp.p_fr_resp_id.value= "";						
					}
					else if(obj.name=="resp1")// || obj.name=="p_to_resp_id1")
					{
						document.repNoteTypeForResp.p_to_resp_id1.value= "";
						document.repNoteTypeForResp.p_to_resp_id.value= "";
					}		
				}
}

//Function for the file name repNoteTypeForResp.jsp-end

//Function for the file name repTextBlock.jsp-start


async function search_Codefortextblock(obj,target)
{	
	var p_facility_id=document.repTextBlock.p_facility_id.value;
	if(obj.name=='p_fr_text_blk_id')
	{
		if((obj.value) == "null" || (obj.value ==""))
		{
			return false;			
		}
		else
		{
			searchCodefortextblock(obj,target);
			/*var objname=obj.name;
			var descriptionval=obj.value;
			parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	        var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body  onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/CAMasterCodeListIntermediate.jsp'><input type='hidden' name='description' id='description' value='"+descriptionval+"'><input type='hidden' name='p_facility_id' id='p_facility_id' value='"+p_facility_id+"'><input type=hidden name='selFunVal' id='selFunVal' value='From_TextBlockCode'><input type=hidden name='PageName' id='PageName' value='repTextBlock'></form></body></html>";
			parent.f_query_intermediate.document.write(HTMLVal);
			if(parent.f_query_intermediate.document.tempform1)
				parent.f_query_intermediate.document.tempform1.submit(); */
		}
	}
	else if(obj.name=='p_to_text_blk_id')
	{
		if((obj.value) == "null" || (obj.value ==""))
		{
			return false;			
		}
		else
		{
			searchCodefortextblock(obj,target);
			/*var objname=obj.name;
			var descriptionval=obj.value;
			parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	        var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body  onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/CAMasterCodeListIntermediate.jsp'><input type='hidden' name='description' id='description' value='"+descriptionval+"'><input type='hidden' name='p_facility_id' id='p_facility_id' value='"+p_facility_id+"'><input type=hidden name='selFunVal' id='selFunVal' value='To_TextBlockCode'><input type=hidden name='PageName' id='PageName' value='repTextBlock'></form></body></html>";
			parent.f_query_intermediate.document.write(HTMLVal);
			if(parent.f_query_intermediate.document.tempform1)
				parent.f_query_intermediate.document.tempform1.submit(); */
		}
	}
	else if(obj.name=='locn' || obj.name=='locn1')
	{		
		searchCodefortextblock(obj,target);
	}	
}

/*function searchCodefortextblock(obj,target)
{
			var p_facility_id=document.repTextBlock.p_facility_id.value;
			var retVal = 	new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var title="";		
			var  fac_id='';
			if(obj.name=="locn"||obj.name=="locn1")
			{
				title="Text Block";
				sql="select text_blk_id code, text_blk description from  ca_text_blk_by_serv_pract where upper(text_blk_id) like upper(?) and upper(text_blk) like upper(?) order by 2";
				search_code="text_blk_id";
				search_desc= "text_blk";
			}
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
				//retArray = CommonLookup( title,argArray );
				retArray =ORCommonLookup( title, argumentArray )
				if(retArray != null && retArray !="")	
				{
					if(obj.name=="locn")//||obj.name=="p_fr_text_blk_id1")
					{							
						document.repTextBlock.p_fr_text_blk_id1.value= retArray[0];						
						document.repTextBlock.p_fr_text_blk_id.value= retArray[0];						
					}
					else if(obj.name=="locn1")//||obj.name=="p_to_text_blk_id1")
					{
						document.repTextBlock.p_to_text_blk_id1.value= retArray[0];
						document.repTextBlock.p_to_text_blk_id.value= retArray[0];
					}
				}
				else
				{
					if(obj.name=="locn")//||obj.name=="p_fr_text_blk_id1")
					{							
						document.repTextBlock.p_fr_text_blk_id1.value="";						
						document.repTextBlock.p_fr_text_blk_id.value="";						
					}
					else if(obj.name=="locn1")//||obj.name=="p_to_text_blk_id1")
					{
						document.repTextBlock.p_to_text_blk_id1.value="";
						document.repTextBlock.p_to_text_blk_id.value="";
					}		
				}
}*/

async function searchCodefortextblock(obj,target){

	var p_facility_id=document.repTextBlock.p_facility_id.value;
	if(obj.name=='p_fr_text_blk_id'||obj.name=='locn')
	{
		target=document.repTextBlock.p_fr_text_blk_id.value;}
	else{
		if(obj.name=='p_to_text_blk_id'||obj.name=='locn1')
		target=document.repTextBlock.p_to_text_blk_id.value;
	}	
			var retVal = 	new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var title="";		
			var  fac_id='';
			//if(obj.name=="locn"||obj.name=="locn1")
			//{
				title="Text Block";
				sql="select text_blk_id code, text_blk description from  ca_text_blk_by_serv_pract where upper(text_blk_id) like upper(?) and upper(text_blk) like upper(?) order by 2";
				search_code="text_blk_id";
				search_desc= "text_blk";
			//}
				var argArray = new Array();
				var namesArray = new Array();
				var valuesArray = new Array();
				var datatypesArray = new Array();
				
				argArray[0] = sql;
				var search_code="";
				var search_desc="";
				argArray[1] = namesArray;
				argArray[2] = valuesArray;
				argArray[3] = datatypesArray;
				argArray[4] = "1,2";
				argArray[5] = target;
				argArray[6] = CODE_LINK;
				argArray[7] = CODE_DESC;
				//argArray[8] = "C";
				retArray =await CommonLookup( title,argArray );
				//retArray =CACommonLookup( title, argArray )
				if(retArray!=undefined)
				{
					if(retArray[0] != null && retArray[0] !="")	
					{
						var str =unescape(retArray);
					 	var arr = str.split(",");
						if(obj.name=="locn"||obj.name=="p_fr_text_blk_id")
						{	
							document.repTextBlock.p_fr_text_blk_id.value= arr[0];
							document.repTextBlock.p_fr_text_blk_id.value= arr[0];						
						}
						else if(obj.name=="locn1"||obj.name=="p_to_text_blk_id")
						{
							document.repTextBlock.p_to_text_blk_id.value= arr[0];
							document.repTextBlock.p_to_text_blk_id.value= arr[0];			
						}
					}
					else
					{
						if(obj.name=="locn"|| obj.name=="p_fr_text_blk_id")
						{							
							document.repTextBlock.p_fr_text_blk_id.value="";						
							document.repTextBlock.p_fr_text_blk_id.value="";						
						}
						else if(obj.name=="locn1"||obj.name=="p_to_text_blk_id")
						{
							document.repTextBlock.p_to_text_blk_id.value="";
							document.repTextBlock.p_to_text_blk_id.value="";
						}		
					}
				}
				else
					{
						if(obj.name=="locn"|| obj.name=="p_fr_text_blk_id")
						{							
							document.repTextBlock.p_fr_text_blk_id.value="";						
							document.repTextBlock.p_fr_text_blk_id.value="";						
						}
						else if(obj.name=="locn1"||obj.name=="p_to_text_blk_id")
						{
							document.repTextBlock.p_to_text_blk_id.value="";
							document.repTextBlock.p_to_text_blk_id.value="";
						}		
					}
}
/*function searchCodefortextblock(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var searchCD="C";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			//var facility=obj1.value;
			if(obj.name=="locn")
			{
				tit="Text Block"
				sql="select text_blk_id, text_blk from ca_text_blk_by_serv_pract";
				search_code="text_blk_id";
				search_desc= "text_blk";
			}
			
			if(obj.name=="locn1")
			{
				tit="Text Block"
				sql="select text_blk_id, text_blk from ca_text_blk_by_serv_pract";
				search_code="text_blk_id";
				search_desc= "text_blk";
			}
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = window.showModalDialog("../../eCA/jsp/CommonLookUp.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit+"&searchCD="+searchCD,arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
			target.focus();
	}*/
//Function for the file name repTextBlock.jsp-end

//Function for the file name repSectionForNoteType.jsp-start
async function search_Codeforsectionnotetype(obj,target)
{
	var p_facility_id=document.repSectionForNoteType.p_facility_id.value;
	if(obj.name=='p_fr_note_type1')
	{
		if((obj.value) == "null" || (obj.value ==""))
		{
			return false;			
		}
		else
		{
			//searchCodeforsectionnotetype(obj,target);
			var objname=obj.name;
			var descriptionval=obj.value;
			parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	        var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body  onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/CAMasterCodeListIntermediate.jsp'><input type='hidden' name='description' id='description' value='"+descriptionval+"'><input type='hidden' name='p_facility_id' id='p_facility_id' value='"+p_facility_id+"'><input type=hidden name='selFunVal' id='selFunVal' value='From_SecNoteType'><input type=hidden name='PageName' id='PageName' value='repSectionForNoteType'></form></body></html>";
			parent.f_query_intermediate.document.write(HTMLVal);
			if(parent.f_query_intermediate.document.tempform1)
				parent.f_query_intermediate.document.tempform1.submit(); 
		}
	}
	else if(obj.name=='p_to_note_type1')
	{
		if((obj.value) == "null" || (obj.value ==""))
		{
			return false;			
		}
		else
		{
			//searchCodeforsectionnotetype(obj,target);
			var objname=obj.name;
			var descriptionval=obj.value;
			parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	        var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body  onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/CAMasterCodeListIntermediate.jsp'><input type='hidden' name='description' id='description' value='"+descriptionval+"'><input type='hidden' name='p_facility_id' id='p_facility_id' value='"+p_facility_id+"'><input type=hidden name='selFunVal' id='selFunVal' value='To_SecNoteType'><input type=hidden name='PageName' id='PageName' value='repSectionForNoteType'></form></body></html>";
			parent.f_query_intermediate.document.write(HTMLVal);
			if(parent.f_query_intermediate.document.tempform1)
				parent.f_query_intermediate.document.tempform1.submit(); 
		}
	}
	else if(obj.name=='note_type' || obj.name=='note_type1')
	{		
		searchCodeforsectionnotetype(obj,target);
	}	
}

async function searchCodeforsectionnotetype(obj,target)
{
		
			var p_facility_id=document.repSectionForNoteType.p_facility_id.value;
			var retVal = 	new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var title="";		
			
			if(obj.name=="note_type"||obj.name=="note_type1")
			{
				title=getLabel("Common.NoteType.label","Common");
				sql="select note_type code, note_type_desc description from ca_note_type where upper(note_type) like upper(?) and upper(note_type_desc) like upper(?) order by 2";
				search_code="note_type";
				search_desc= "note_type_desc";
			}
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
				retArray =await CommonLookup( title,argArray );
				if(retArray != null && retArray !="")	
				{
					var str =unescape(retArray);
				 	var arr = str.split(",");
					if(obj.name=="note_type" )
					{							
						document.repSectionForNoteType.p_fr_note_type1.value= arr[1];						
						document.repSectionForNoteType.p_fr_note_type.value= arr[0];						
					}
					else if(obj.name=="note_type1")
					{
						document.repSectionForNoteType.p_to_note_type1.value= arr[1];
						document.repSectionForNoteType.p_to_note_type.value= arr[0];
					}
				}
				else
				{
					if(obj.name=="note_type")
					{							
						document.repSectionForNoteType.p_fr_note_type1.value="";						
						document.repSectionForNoteType.p_fr_note_type.value="";						
					}
					else if(obj.name=="note_type1")
					{
						document.repSectionForNoteType.p_to_note_type1.value="";
						document.repSectionForNoteType.p_to_note_type.value="";
					}		
				}
}



/*function searchCodeforsectionnotetype(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			//var facility=obj1.value;
			if(obj.name=="note_type")
			{
				tit=getLabel("Common.NoteType.label","Common");
				sql="select note_type, note_type_desc from ca_note_type";
				search_code="note_type";
				search_desc= "note_type_desc";
			}
			
			if(obj.name=="note_type1")
			{
				tit=getLabel("Common.NoteType.label","Common");
				sql="select note_type, note_type_desc from ca_note_type";
				search_code="note_type";
				search_desc= "note_type_desc";
			}
			
			//			if(obj.name=="section")
			//			{
			//				tit="Section"
			//				sql="select sec_hdg_code, sec_hdg_desc from ca_section_hdg";
			//				search_code="sec_hdg_code";
			//				search_desc= "sec_hdg_desc";
			//			}
						
			//			if(obj.name=="section1")
			//			{
			//				tit="Section"
			//				sql="select sec_hdg_code, sec_hdg_desc from ca_section_hdg";
			//				search_code="SEC_HDG_CODE";
			//				search_desc= "sec_hdg_desc";
			//			}
			
			//alert(sql);
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
			target.focus();
	}*/

//Function for the file name repSectionForNoteType.jsp-end

function ValidateCheckString(str,fromobj,toobj,messageFrame) 
{

	 var arr = new Array(toobj.value,fromobj.value);
    if( trimCheck(fromobj.value) && trimCheck(toobj.value) ) 
	{
   		if(fromobj.value <= toobj.value) 
		{
            return true;
        }
        else 
		{
			var error=getMessage("REMARKS_MUST_GR","CA",arr);
			error=error.replace("$",str);
			error=error.replace("#",str);
            messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error  ;
            return false;
        }
    }
    else 
	{
        return true;
    }
}
function CACommonLookup(title, pArgumentArray) {
	
    var retVal = new String();
    var dialogHeight= "30" ;
    var dialogWidth = "40" ;
    var status = "no";
	var defaultselect="";
    var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;

    xmlStr ="<root><SEARCH " ;
    xmlStr +=" /></root>" ;

    //alert(pArgumentArray)

    firstCodeVal = "" ;
    firstDescVal = "" ;
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

    //alert(formQueryString(pArgumentArray,0))
	
    xmlHttp.open( "GET", "../../eCA/jsp/CommonLookUpResult.jsp?title="+escape(title)+"&callFrom=0&" + formQueryString(pArgumentArray,0) , false ) ;
	
    xmlHttp.send( xmlDoc ) ;
    responseText=xmlHttp.responseText ;
	
    //eval(responseText) ;

	if(pArgumentArray[8]=="C")
	{
		defaultselect="C";
	}
	else
	{
		defaultselect="D";

	}
	
    if(firstCodeVal == "")
    {
		
		var dialogUrl       = "../../eCA/jsp/CommonLookUp.jsp?title="+escape(title)+"&searchCD="+defaultselect ;
        var dialogArguments = pArgumentArray ;
        var dialogFeatures  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
        var returnVal = window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);
		if(returnVal!=undefined)
		{
			 if( returnVal[0] == null || returnVal[0] == "" )
				return "";
			else
				return returnVal;//.split("\"") ;
		}
     }
     else
     {
         if(pArgumentArray[7] == CODE_DESC )
         {
            var temp = firstCodeVal
            firstCodeVal = firstDescVal
            firstDescVal = temp
         }
          returnVal[0] = firstDescVal;
			returnVal[1]= firstCodeVal;
			return returnVal;
			
         //return returnVal.split("\"") ;
     }
}

