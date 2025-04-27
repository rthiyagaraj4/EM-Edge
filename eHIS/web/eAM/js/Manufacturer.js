
 /***********************xmlHttp*******************************************************************************/
 function create()
{
	f_query_add_mod.location.href = "../../eAM/jsp/addModifyManufacturer.jsp" ;
}
/******************************************************************************************************/
function PopulatePostalCode(obj,mode)
{
 	   //var xmlDoc=new ActiveXObject("Microsoft.XMLDom");
	   var xmlHttp = new XMLHttpRequest();
		if (mode=="Area")
			{
			xmlStr ="<root><SEARCH res_area_code=\""+obj.value+"\"  /></root>";
			}
		if (mode=="Town")
			{
			xmlStr ="<root><SEARCH res_town_code=\""+obj.value+"\"  /></root>";
			}
		if (mode=="Postal")
			{
			xmlStr ="<root><SEARCH postal_code=\""+obj.value+"\"  /></root>";

			}	

	   var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	    xmlHttp.open("POST","PopulateValues.jsp",false);


	   xmlHttp.send(xmlDoc);
	   responseText=xmlHttp.responseText;
	   responseText = trimString(responseText);
	   eval(responseText);
    
}
/******************************************************************************************************/
async function callSearch()
{
	var target			=document.forms[0].postal_code;
	var retVal			=  new String();
	var dialogTop	= "40";
	var dialogHeight	= "10" ;
	var dialogWidth= "40" ;
	var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments	= "" ;
	var search_desc	= "";
	var title			=getLabel("eMP.postalcode.label","MP");

	var sql="select POSTAL_CODE code,SHORT_DESC description from mp_postal_code where eff_status='E'  and upper(SHORT_DESC) like upper(?) and upper(POSTAL_CODE) like upper(?) ";
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

	retArray = await CommonLookup( title, argArray );
	if(retArray != null && retArray !="")	{
		target.value=retArray[0];
	}else
	{
	target.value="";
	}
		
}
/******************************************************************************************************/

function query()
{
	f_query_add_mod.location.href ="../../eAM/jsp/ManufacturerQueryCriteria.jsp?operation=modify" ;
}
/******************************************************************************************************/
function checkIsValidForProceed()
  {
     var url = f_query_add_mod.location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
        return true;
    else
        return false;
  }



function apply()
  {
	  var messageFrame = frames[2]; 
if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 

	var fields = new Array (f_query_add_mod.document.Manufacturer_form.manufacturer_id);
	var names  =  new Array ( getLabel("Common.identification.label",'Common') );
//	var messageFrame = parent.frames[1].frames[2]; 
	
	var error_page = "../../eCommon/jsp/MstCodeError.jsp";
	if(f_query_add_mod.SpecialCharCheck(fields,names,messageFrame,"M", error_page))
	{  
	var fields = new Array(
				f_query_add_mod.document.Manufacturer_form.manufacturer_id,
	 	     	f_query_add_mod.document.Manufacturer_form.long_name,
				f_query_add_mod.document.Manufacturer_form.short_name
			      );
	
		
	var names = new Array (	getLabel("Common.identification.label",'Common'),
				getLabel("Common.longname.label",'Common'),
				getLabel("Common.shortname.label",'Common')
			      )
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	{	
		
		if(f_query_add_mod.document.Manufacturer_form.country_code.disabled==true)
			f_query_add_mod.document.Manufacturer_form.country_code.disabled=false;




	for(var k=0;k<f_query_add_mod.document.Manufacturer_form.elements.length;k++)
	f_query_add_mod.document.Manufacturer_form.elements[k].disabled = false;

	f_query_add_mod.document.Manufacturer_form.eff_status.disabled = false;
	f_query_add_mod.document.Manufacturer_form.eff_status.focus();
	
	
		f_query_add_mod.document.Manufacturer_form.submit();
		if (f_query_add_mod.document.Manufacturer_form.eff_status.checked==false)
			f_query_add_mod.document.Manufacturer_form.country_code.disabled==true
	}
  }
 }
/******************************************************************************************************/
function onSuccess()
 {
f_query_add_mod.location.reload() ;
 }
/******************************************************************************************************/
function reset()
{
	/*if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } */
   if(f_query_add_mod.document.forms[0].name == "Manufacturer_form")
    {
		var operation=f_query_add_mod.document.Manufacturer_form.operation.value;
        if(operation=='modify')
		 {
			//f_query_add_mod.document.forms[0].reset() ;
			f_query_add_mod.document.location.reload() ;
			//f_query_add_mod.document.Manufacturer_form.long_name.focus();
		 }
		else
		{
			//f_query_add_mod.document.forms[0].reset() ;
			f_query_add_mod.document.location.reload() ;
			f_query_add_mod.document.Manufacturer_form.manufacturer_id.focus();
		}
    }     
    else
         f_query_add_mod.document.location.reload() ;
      //   f_query_add_mod.document.query_form.reset() ;
}
function chkchar(obj,e)
{
 	var whichCode = (window.Event) ? e.which : e.keyCode;
	var sp=obj.value;
	var j=sp.length;
	
	if((whichCode >=48 && whichCode<=57) || (whichCode>=97 && whichCode<=122) || (whichCode>=65 && whichCode<=90))
		return true;
	else
		return false
}
