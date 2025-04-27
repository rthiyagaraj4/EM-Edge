function create()
{
	f_query_add_mod.location.href='../../eCA/jsp/AccessRightForResearchStudiesMaster.jsp?mode=insert';
	messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0'
}
function onSuccess()
{
	f_query_add_mod.location.reload();
}
function reset()
{	
	if(f_query_add_mod.f_query_add_mod_query.document.forms[0])
		f_query_add_mod.f_query_add_mod_query.document.forms[0].reset();
		
	f_query_add_mod.f_query_add_mod_res.location.href='../../eCommon/html/blank.html'
}
function apply()
{
	var formResultObj = f_query_add_mod.f_query_add_mod_res.document.formAccessRightForResearchStudiesResult;
	var from = f_query_add_mod.f_query_add_mod_res.document.formAccessRightForResearchStudiesResult.fm_disp.value;		
	var to = f_query_add_mod.f_query_add_mod_res.document.formAccessRightForResearchStudiesResult.to_disp.value;
	var optionValStr = "", practitionerId ="", practitionerName = "", resFromDate = "", resToDate = "", resRecord = "", resUpdate = "", studyAllowedIU="", studyRightsIU="";
	
	for (i=from; i<=to; i++){
		practitionerId = eval("formResultObj.practitionerId"+i+".value");
		practitionerName = eval("formResultObj.practitionerName"+i+".value");
		resFromDate = eval("formResultObj.resFromDate"+i+".value");
		resToDate = eval("formResultObj.resToDate"+i+".value");
		resRecord = eval("formResultObj.resRecord"+i+".value");
		resUpdate = eval("formResultObj.resUpdate"+i+".value");
		studyAllowedIU = eval("formResultObj.studyAllowedIU"+i+".value");
		studyRightsIU = eval("formResultObj.studyRightsIU"+i+".value");		
		optionValStr += practitionerId +"||"+practitionerName+"||"+resFromDate +" ||"+resToDate+" ||"+resRecord +"||"+resUpdate+"||"+studyAllowedIU +"||"+studyRightsIU+"||"+i+"~";
	}
	f_query_add_mod.f_query_add_mod_res.document.formAccessRightForResearchStudiesResult.optionValStr.value = optionValStr;
	f_query_add_mod.f_query_add_mod_res.document.forms[0].action="../../servlet/eCA.AccessRightForResearchStudiesServlet";
	f_query_add_mod.f_query_add_mod_res.document.formAccessRightForResearchStudiesResult.target="messageFrame";
	f_query_add_mod.f_query_add_mod_res.document.formAccessRightForResearchStudiesResult.method="post";
	f_query_add_mod.f_query_add_mod_res.document.formAccessRightForResearchStudiesResult.submit();	
	
}

function getReseaFactors(){
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr += " p_research_category=\""+ document.forms[0].resePatCategory.value + "\" ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml") ;
	xmlHttp.open( "POST", "AccessRightForResearchStudiesValidate.jsp", false );
	xmlHttp.send(xmlDoc) ;
	responseText = xmlHttp.responseText ;
		eval(responseText);
}
function addResearchFactorsList(code,desc)
{
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = desc ;	
	eval("document.forms.AccessRightForResearchStudiesQueryform.reseCategoryFact.add(element)");		
}
function clearResearchFactorsList() 
{
	eval("document.forms.AccessRightForResearchStudiesQueryform.reseCategoryFact.length=0");
	var tp = getLabel("Common.defaultSelect.label","Common");
	var element = document.createElement('OPTION') ;
	element.value = "" ;
	element.text = "----------"+tp+"----------" ;	
	eval("document.forms.AccessRightForResearchStudiesQueryform.reseCategoryFact.add(element)");		
} 
function searchClick(){	
	parent.frames[0].selected='';
	var fields = new Array ( parent.frames[0].document.forms[0].resePatCategory,parent.frames[0].document.forms[0].reseCategoryFact);
	var names = new Array ( getLabel("eCA.ResearchPatientCategory.label","ca_labels"),getLabel("eCA.ResearchCategoryFactor.label","ca_labels"));
	if(parent.frames[0].checkFieldsofMst( fields, names, parent.parent.frames[2])) {
		var resePatCategory= parent.frames[0].document.forms[0].resePatCategory.value;
		var reseCategoryFact= parent.frames[0].document.forms[0].reseCategoryFact.value;
			 var search_by= parent.frames[0].document.forms[0].search_by.value;
			 var search_txt= parent.frames[0].document.forms[0].search_txt.value;
			if(search_txt.indexOf("'")!=-1)
			{			
				search_txt = search_txt.replace("'","''");
			}
			
			parent.frames[1].location.href='../../eCA/jsp/AccessRightForResearchStudiesResult.jsp?resePatCategory='+resePatCategory+'&reseCategoryFact='+reseCategoryFact+'&search_by='+search_by+'&search_txt='+search_txt;
			
			parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_val=&err_num='
	}

}
function showCalendarValidate(str){
	
	var flg = newShowCalendar(str,null,'hh:mm');
	document.getElementById(str).focus();
    return flg;
}
var  enableFlag=false;
function newShowCalendar(id, date_format,time_format) {
			
			 var el = document.getElementById(id);
			 var isModal="isDiv";
			 var timeSet="";
			if ( (date_format==undefined) || (date_format=='') || (date_format==null) || (date_format=='null'))
			{
					timeSet="dd/mm/yyyy"
			}
			else 
			{
					timeSet=date_format
			}
			if ( (time_format!=undefined) && (time_format!='') && (time_format!=null) && (time_format!='null') )
			{

				timeSet = timeSet +' '+ time_format;
			}

			

			if(enableFlag)
			{
					return false
			}
			else
			{
				enableFlag=true;
			}

			newShowInModal(el,timeSet,id);
			return false;
		
}
async function newShowInModal(args,timeSet,vid)
	{
			var dialogHeight= "49vh" ;
			var dialogWidth	= "25vw" ;
			var status = "no";
			
			var features	=  "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll:no; status:" + status;
			var  dateValue= await window.showModalDialog('../../eCommon/jsp/CommonStaticCalenderGlad.jsp?timeSet='+timeSet,args, features);		
		   
			
			var formatedDate = dateValue;	

			if(dateValue==undefined)
			{
					 args.value= "";
			}
			else
			{
					var temp_date=dateValue.split(" ");
					formatedDate = temp_date[0];
					args.value =formatedDate;
			}
			
			enableFlag=false;
    }
function checkVal(obj)
{
	document.forms[0].dispMode.value = obj;
	document.forms[0].submit();
}
function checkRecUpd(obj){
	if(eval("document.forms[0]."+obj).checked)
		eval("document.forms[0]."+obj).value="Y";
	else
		eval("document.forms[0]."+obj).value="N";
}
function showAccessRightsHistory(facilityId,practitionerId,practitionerName){	
	var dialogTop		=	"10" ;
	var dialogHeight	=	"80vh" ;
	var dialogWidth		=	"50vw" ;
	var status			=	"no";
	var arguments		=	"" ;
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	
	 window.showModalDialog("../../eCA/jsp/AccessRightHistoryDetails.jsp?practitionerId="+practitionerId+"&facilityId="+facilityId+"&practitionerName="+encodeURIComponent(practitionerName),arguments,features);
}
