//This file is saved on 18/10/2005.

var curr_obj ="document.getElementById('associated_lbl')";
var prev_obj= "";

function getLevels(obj){
	var termSetid=obj.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eCP/jsp/TermCodeLookupDynamicValues.jsp?termSetid="+termSetid+"&validate=LEVEL", false);
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText);
}

function assignLevels(values)
{
		var levels=values.split("||");
		var frmobj=document.formTermCodeCriteria;
		var obj = eval(frmobj.type);
		var obj1 = eval(frmobj.classificationLevel);
		var flag=0;

		clearData(obj);
		clearData(obj1);

		if(levels[1]=='Y'){
		var opt	= eval(document.createElement('OPTION'));
		opt.value =	trimString("PR");
		opt.text =getLabel("Common.Procedure.label","Common");
		obj.add(opt);
		flag=1;
		}
		if(levels[2]=='Y'){
		var opt	= eval(document.createElement('OPTION'));
		opt.value =	trimString("DX");
		opt.text =getLabel("Common.diagnosis.label","Common");
		obj.add(opt);
		flag=1;
		}
		if(flag==0){
			var opt	= eval(document.createElement('OPTION'));
			opt.value =	trimString("");
			opt.text ="--"+getLabel("Common.defaultSelect.label","Common")+"--";
			obj.add(opt);
		}
		

for(var i=1;i<=parseInt(levels[3]);i++)
		{
			var opt	= eval(document.createElement('OPTION'));
			opt.value =i;
			opt.text =levels[i+3];
			obj1.add(opt);
			
		}
}

function clearData(obj) {
	obj = eval(obj);
	var len = obj.length;
	for (var i=0; i<=len; i++) {
		obj.remove("");
	}
}
function searchDetails(){
	var formObj=document.getElementById("formTermCodeCriteria");
	var termset=formObj.terminologySet.value;
	var type=formObj.type.value;
	var libraryid=formObj.libraryid.value;
	var versionno=formObj.versionno.value;
	var classificationLevel=formObj.classificationLevel.value;
	if(termset !='' && type !='' && classificationLevel!='')
	{
		parent.TermcodeLookup_hyperlink.location.href='../../eCP/jsp/TermCodeLookupHyperlinks.jsp?termset='+termset+'&type='+type+'&classificationLevel='+classificationLevel+'&libraryid='+libraryid+'&versionno='+versionno+'&termcode='+formObj.terminologyCode.value+'&termdesc='+formObj.terminologydesc.value+'&searchcriteria='+formObj.search_criteria.value;
		parent.TermcodeLookup_details.location.href='../../eCP/jsp/TermCodeLookupResult.jsp?alphalink=&terminologySetId='+termset+'&type='+type+'&classificationLevel='+classificationLevel+'&termcode='+formObj.terminologyCode.value+'&termdesc='+formObj.terminologydesc.value+'&searchcriteria='+formObj.search_criteria.value+'&libraryid='+libraryid+'&versionno='+versionno;
		formObj.search_button.disabled=true;
		
	}else
		alert(getMessage("TERMSET_MUST_BE_SELECT","CP"));
}

function resetForm(formObj){
	formObj.reset();
	formObj.search_button.disabled=false;

	var obj=formObj.type;
	clearData(obj);
	var opt	= eval(document.createElement('OPTION'));
			opt.value =	trimString("");
			opt.text ="--"+getLabel("Common.defaultSelect.label","Common")+"--";
			obj.add(opt);

	var obj1=formObj.classificationLevel;
	clearData(obj1);
	var opt1	= eval(document.createElement('OPTION'));
			opt1.value =	trimString("");
			opt1.text ="--"+getLabel("Common.defaultSelect.label","Common")+"--";
			obj1.add(opt1);
	
	
    parent.TermcodeLookup_hyperlink.location.href = "../../eCommon/html/blank.html";
	parent.TermcodeLookup_details.location.href = "../../eCommon/html/blank.html";
	}


function navigation(frmObj,link)
	{
		var start		=	frmObj.start.value;
		var end		=	frmObj.end.value;
		var alphalink=frmObj.alphalink.value;
		var termcode=frmObj.termcode.value;
		var termdesc=frmObj.termdesc.value;
		var searchcriteria=frmObj.searchcriteria.value;
		var classificationLevel=frmObj.classificationLevel.value;
		var terminologySetId=frmObj.terminologySetId.value;
		var type=frmObj.type.value;
		var libraryid=frmObj.libraryid.value;
		var versionno=frmObj.versionno.value;
					
		if (link=="next")
		{
			start		=	parseInt(start)+8;
			end		=	parseInt(end)+8;
		}
		else if(link=="previous")
		{
		start		=	parseInt(start)-8;
		end		=	parseInt(end)-8;
		}

		parent.TermcodeLookup_details.location.href	=	"../../eCP/jsp/TermCodeLookupResult.jsp?from="+start+"&to="+end+"&alphalink="+alphalink +"&termcode="+termcode+"&termdesc="+termdesc+"&searchcriteria="+searchcriteria+"&classificationLevel="+classificationLevel+"&terminologySetId="+terminologySetId+"&type="+type+"&libraryid="+libraryid+"&versionno="+versionno;
}

function updateCodeValue(obj,index)
{
	var flag=0;
	if(obj.checked==true)
		flag=1;
	else
		flag=0;
	var frmobj=document.getElementById("TerminologycodeLookupDetailForm");
	var termset = frmobj.terminologySetId.value;
	var tableName=frmobj.tableName.value;
	var code=obj.value;
	var obj = eval("frmobj.desc"+index);
	//alert(obj.value);
	var desc=obj.value;
	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eCP/jsp/TermCodeLookupDynamicValues.jsp?code="+code+"&flag="+flag+"&desc="+desc+"&termSet="+termset+"&tableName="+tableName+"&validate=CODEUPDATE", false);
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	//alert(responseText);
	eval(responseText);
	
}

function closeW()
{
	//alert("inside");
	formObj=parent.TermcodeLookup_details.document.getElementById("TerminologycodeLookupDetailForm");
	tableName=formObj.tableName.value;
	//window.returnValue=tableName;
	
	let dialogBody = parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = tableName;
    
}
function closewindow(){
	//parent.window.close();
	parent.parent.document.getElementById("dialog_tag").close();
}

function loadDetail(obj,terminologySet,type,classificationLevel,libraryid,versionno,termcode,termdesc,searchcriteria,alphalink)
	{
		
		prev_obj	=	eval(curr_obj);
		var curr_obj = document.getElementById(obj.id);

		new_obj		=	eval(curr_obj);
		old_obj		=	eval(prev_obj);

		new_obj.innerHTML	=	"<u><font color='maroon'>"+new_obj.innerText+"</font></u>";
		old_obj.innerHTML	=	"<td><u>"+old_obj.innerText+"</u></td>";

		parent.TermcodeLookup_details.location.href="../../eCP/jsp/TermCodeLookupResult.jsp?alphalink="+alphalink+"&terminologySetId="+terminologySet+"&type="+type+"&classificationLevel="+classificationLevel+"&libraryid="+libraryid+"&versionno="+versionno+"&termcode="+termcode+"&termdesc="+termdesc+"&searchcriteria="+searchcriteria;
	
	}
