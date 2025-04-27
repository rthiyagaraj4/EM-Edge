 function create()
  {
		
	f_query_add_mod.location.href = "../../eAM/jsp/addModifyTradeName.jsp" ;
  }

function query()
  {
  f_query_add_mod.location.href ="../../eAM/jsp/TradeNameQueryCriteria.jsp" ;
  }
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


	var fields = new Array (f_query_add_mod.document.TradeName_form.tradeid);
	var names  =  new Array (getLabel("Common.identification.label",'Common'));
	//var messageFrame = parent.frames[1].frames[2]; 
	var error_page = "../../eCommon/jsp/MstCodeError.jsp";

	if(f_query_add_mod.SpecialCharCheck(fields,names,messageFrame,"M", error_page))
	{  
	var fields = new Array(
				f_query_add_mod.document.TradeName_form.tradeid,
	 	     	f_query_add_mod.document.TradeName_form.long_name,
				f_query_add_mod.document.TradeName_form.short_name,
				f_query_add_mod.document.TradeName_form.Manufacturer
			      );
		 
	          var names = new Array (getLabel("Common.identification.label",'Common'),
				getLabel("Common.longname.label",'Common'),
			    getLabel("Common.shortname.label",'Common'),
				getLabel("Common.Manufacturer.label",'Common'))
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
					  
	{
		if(f_query_add_mod.document.forms[0].drug.disabled == true)
			f_query_add_mod.document.forms[0].drug.disabled = false;
		f_query_add_mod.document.TradeName_form.submit();
	}
  }
}
function onSuccess()
{
	f_query_add_mod.location.reload() ;
}
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
   if(  f_query_add_mod.document.forms[0].name == "TradeName_form")
   {
	 var function_name=f_query_add_mod.document.TradeName_form.function_name.value;
      if(function_name=='modify')
	 {
		//	f_query_add_mod.document.forms[0].reset() ;
			f_query_add_mod.document.location.reload() ;
			//f_query_add_mod.document.TradeName_form.long_name.focus();
		 }
		 else
		 {
			//f_query_add_mod.document.forms[0].reset() ;
			f_query_add_mod.document.location.reload() ;
			f_query_add_mod.document.TradeName_form.tradeid.focus();
		 }
		
    }     
    else
         f_query_add_mod.document.location.reload() ;
       //  f_query_add_mod.document.query_form.reset() ;
    }


function page_ref(obj){
	var function_name=parent.frames[1].document.forms[0].function_name.value;
	if(function_name=='modify'){
		
			var tradeid=parent.frames[1].document.forms[0].tradeid.value;
			parent.frames[1].location.href = "../../eAM/jsp/addModifyTradeName.jsp?allow_alter=Y&tradeid="+tradeid ;

		
	}
}

/*function callSearch()
{
		var target = document.forms[0].Manufacturer;
		var retVal = 	new String();
		var dialogHeight= "28" ;
		var dialogWidth	= "43" ;
		var status = "no";
		var arguments	= "" ;
		var sql="select MANUFACTURER_ID,SHORT_NAME from AM_MANUFACTURER where eff_status=`E`";
		var search_code="MANUFACTURER_ID";
		var search_desc="SHORT_NAME";
		var tit= encodeURIComponent(getLabel("Common.Manufacturer.label","Common"));

		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit+"&dispDescFirst=dispDescFirst",arguments,features);
		
		if (!(retVal == null))
		{
			arr=unescape(retVal).split("::");
			document.forms[0].Manufacturer_desc.value=arr[0];
			target.value=arr[1];
		}
}
*/

async function callSearch(obj,target_desc,target_code)
				{
				var retVal =    new String();
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var tit=getLabel("Common.Manufacturer.label","Common");
				var sql="";
				if(obj.value!="")
				{
				sql="select MANUFACTURER_ID code ,SHORT_NAME description from AM_MANUFACTURER where eff_status='E' and upper(MANUFACTURER_ID) like upper(?) and upper(SHORT_NAME) like upper(?) order by 2";

				//sql="select level_of_care_code code,level_of_care_desc description from AM_LEVEL_OF_CARE where  upper(level_of_care_code) like upper(?) and upper(level_of_care_desc) like upper(?) order by 2";
				
											
				argumentArray[0] = sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target_desc.value;
				argumentArray[6] = CODE_LINK ;
				argumentArray[7] = CODE_DESC ;
				
				retVal = await CommonLookup( tit, argumentArray );
				if (retVal !=null && retVal !="")
				{
					var ret1=unescape(retVal);
					arr=ret1.split(",");
					target_desc.value=arr[1];
					target_code.value=arr[0];
				}else
				{
				target_desc.value="";
				target_code.value="";
				}
				}
				else
					{
					document.forms[0].Manufacturer.value='';
					document.forms[0].Manufacturer_desc.value='';
					}
			
			}
