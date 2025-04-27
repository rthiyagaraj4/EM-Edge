function selCountAreaRegTwn1(obj,target)
{
	if(obj.value == "")
	{obj.value="";
	  return ;
	}
selCountAreaRegTwn(obj,target)

}
async function selCountAreaRegTwn(obj,target)
   {
		tar=target.value
		var retVal =    new String();
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var tit="";	
		
	   if(target.name=='town')
	   {
		tit=getLabel("Common.Town.label","Common");	
		sql="select res_town_code code,short_desc description from mp_res_town  where eff_status='E' and upper(res_town_code) like upper(?) and upper(short_desc) like upper(?) order by 2"
	   }else if(target.name=='area')
	   {
		tit=getLabel("Common.area.label","Common");
		sql="select RES_AREA_CODE code, short_desc description from mp_res_area where eff_status='E' and upper(RES_AREA_CODE) like upper(?) and upper(short_desc) like upper(?) order by 2"
	   }else if(target.name=='region')
	   {
		tit=getLabel("eMP.region.label","MP");
		sql="select REGION_CODE code, short_desc  description from mp_region where eff_status='E' and upper(REGION_CODE) like upper(?) and upper(short_desc) like upper(?) order by 2"
	   }
		argumentArray[0] =sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = tar;
		argumentArray[6] = DESC_LINK  ;
		argumentArray[7] = DESC_CODE ;
		retVal = await CommonLookup( tit, argumentArray );
		if(retVal != null && retVal != "" )
		  {
			
			var ret1=unescape(retVal);
			arr=ret1.split(",");
			if(target.name=='region')
			 {
			document.forms[0].region.value=arr[1];
			document.forms[0].region1.value=arr[0];
			  
			  }else  if(target.name=='town')
			  {
			  document.forms[0].town.value=arr[1];
			  document.forms[0].town1.value=arr[0];
			
			  } if(target.name=='area')
			  {
			  document.forms[0].area.value=arr[1];
			  document.forms[0].area1.value=arr[0];
			
			  }
					
				
					}
				else
				  {
					target.value='';
			      }
		}

 




function PopulatePostalCode(obj,mode)
{
 	   var xmlDoc=new ActiveXObject("Microsoft.XMLDom");
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

	    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	    xmlHttp.open("POST","PopulateValues.jsp",false);
       xmlHttp.send(xmlDoc);
	   responseText=xmlHttp.responseText;
	   responseText = trimString(responseText);
	   eval(responseText);
    
}


//FUNCTION FOR DISPLAYING POSTALCODE LOOK-UP
function callSearch()
{
		var target = document.forms[0].postal_code;
		var retVal = 	new String();
		var dialogHeight= "28" ;
		var dialogWidth	= "43" ;
		var status = "no";
		var arguments	= "" ;
		var sql="select POSTAL_CODE,SHORT_DESC from mp_postal_code where eff_status=`E`";
		var search_code="POSTAL_CODE";
		var search_desc="SHORT_DESC";
		var tit=getLabel("eMP.postalcode.label","MP");

		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);
		if (!(retVal == null))
		{
			target.value=retVal;
		}
		else
			target.focus();
}


// The following function called on click of the create button in common toolbar
function create()
{
	f_query_add_mod.location.href = "../../eMO/jsp/addModifyClaimants.jsp" ;
}



// The following function called on click of the query button for query mode 
function query()
{
  f_query_add_mod.location.href ="../../eMO/jsp/ClaimantsQueryCriteria.jsp?operation=modify" ;
}

// This function is called for showing  and checking the validation of the location href for the f_query_add_mod frame
  function checkIsValidForProceed()
  {
     var url = f_query_add_mod.location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
        return true;
    else
        return false;
 }

 // This function is for the apply button when the form is submitted to the servlet
function chkfields()
{
   if(document.forms[0].Claimants_type.value == "K" ||   document.forms[0].Claimants_type.value == "E")
	{
		if(document.forms[0].addr_line_1!=null)
		document.forms[0].addr_line_1.value="";
		if(document.forms[0].addr_line_2!=null)
		document.forms[0].addr_line_2.value="";
		if(document.forms[0].addr_line_3!=null)
		document.forms[0].addr_line_3.value="";
		if(document.forms[0].addr_line_4!=null)
		document.forms[0].addr_line_4.value="";
		if(document.forms[0].postal_code!=null)
		document.forms[0].postal_code.value="";
		document.forms[0].country_code.value="";
		document.forms[0].tel_no.value="";
		document.forms[0].tlx_no.value="";
		document.forms[0].fax_no.value="";
		document.forms[0].email.value="";
		document.forms[0].website.value="";

        if(document.forms[0].addr_line_1!=null) 
		document.forms[0].addr_line_1.disabled=true;
		if(document.forms[0].addr_line_2!=null)
		document.forms[0].addr_line_2.disabled=true;
		if(document.forms[0].addr_line_3!=null)
		document.forms[0].addr_line_3.disabled=true;
		if(document.forms[0].addr_line_4!=null)
		document.forms[0].addr_line_4.disabled=true;
		document.forms[0].postal_code.disabled=true;
		document.forms[0].country_code.disabled=true;
		document.forms[0].tel_no.disabled=true;
		document.forms[0].tlx_no.disabled=true;
		document.forms[0].fax_no.disabled=true;
		document.forms[0].email.disabled=true;
		document.forms[0].website.disabled=true;
	 }
	 else
	{
        if(document.forms[0].addr_line_1!=null)   
		document.forms[0].addr_line_1.disabled=false;
		if(document.forms[0].addr_line_2!=null) 
		document.forms[0].addr_line_2.disabled=false;
		if(document.forms[0].addr_line_3!=null) 
		document.forms[0].addr_line_3.disabled=false;
		if(document.forms[0].addr_line_4!=null) 
		document.forms[0].addr_line_4.disabled=false;
		document.forms[0].postal_code.disabled=false;
		//document.forms[0].country_code.disabled=false;
		document.forms[0].tel_no.disabled=false;
		document.forms[0].tlx_no.disabled=false;
		document.forms[0].fax_no.disabled=false;
		document.forms[0].email.disabled=false;
		document.forms[0].website.disabled=false;
	}
}
function apply()
{
     if (! (checkIsValidForProceed()) )
    {
        messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    }
	   f_query_add_mod.document.claimant_form.Claimants_type.disabled=false;
       f_query_add_mod.document.claimant_form.country_code.disabled=false;
	
    var fields1 = new Array ( f_query_add_mod.document.claimant_form.claimant__type_code);
	var names1  =  new Array ( f_query_add_mod.getLabel('Common.code.label','common') );
	var error_page = "../../eCommon/jsp/MstCodeError.jsp";
	    	
   
   var fields = new Array (f_query_add_mod.document.claimant_form.claimant__type_code,f_query_add_mod.document.claimant_form.long_desc,f_query_add_mod.document.claimant_form.short_desc,f_query_add_mod.document.claimant_form.Claimants_type);

   var names = new Array (f_query_add_mod.getLabel('Common.code.label','common'),f_query_add_mod.getLabel('Common.longdescription.label','common'),f_query_add_mod.getLabel('Common.shortdescription.label','common'),f_query_add_mod.getLabel("eMO.ClaimantTypeRelat.label","MO"));   /*
	 The checkfields function checks for the validity of the fields...The fields in the fields array passed are supposed to be mandatory field and they are not supposed to be null or blank.
	 If none of the mandatory fields are blank , the function returns true else it returns false alert the corresponding field name should not be blank.

	 The function checkFields( fields, names, messageFrame) is implemented in the common directories...in eCommon/js/common.js
   */

   if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	 {
      if(f_query_add_mod.SpecialCharCheck(fields1,names1,messageFrame,"M", error_page)){  

		
			for(var k=0;k<f_query_add_mod.document.claimant_form.elements.length;k++)
			f_query_add_mod.document.claimant_form.elements[k].disabled = false;

			f_query_add_mod.document.claimant_form.eff_status.disabled = false;
			f_query_add_mod.document.claimant_form.eff_status.focus();
		

      f_query_add_mod.document.claimant_form.submit();
	  }
	 }
}
// After the insertion and modification is carried out the following function is called from the servlet to reload the initial page.This happens only in case of insert mode.
function onSuccess() 
{ 
   f_query_add_mod.document.location.reload();
}


// The following function called on click of the reset button 
function reset()
{
	if(f_query_add_mod.document.forms[0])
		f_query_add_mod.document.location.reload();
   // if(f_query_add_mod.document.forms[0])
	//	f_query_add_mod.document.forms[0].reset() ;
	
}

/*Added by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095*/
function ClaimantTypeValue()
{
	if(document.forms[0].operation.value == "modify")
	{
		var ClaimantTypeValue = document.forms[0].claimant_type_mstr.value;
		for(var i=0;i<document.forms[0].Claimants_type.options.length;i++ )
		{
			if(document.forms[0].Claimants_type.options[i].value == ClaimantTypeValue)
				document.forms[0].Claimants_type.options[i].selected = true;
		}
	}
}
/*End ML-MMOH-CRF-1095*/
