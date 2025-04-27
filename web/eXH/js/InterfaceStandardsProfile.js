
async function searchApplication1(){
   
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit="Application" ;
					

//			document.forms[0].Application_Specific_txt1.value
//parent.frames[1].
            var target=document.forms[0].Application_Specific_txt1;
            var appl_id=document.forms[0].application_id1;
			
 
            sql="SELECT application_id code,application_name description FROM XH_APPLICATION "+
                    "   WHERE UPPER(application_id) LIKE UPPER(?) AND "+ 
                    "           UPPER(application_name) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";

            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
	        argumentArray[4] = "1,2";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
            retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                appl_id.value=arr[0];
				
            }
            else{
                target.value=tdesc;
                appl_id.value=tcode;
				
            }
}



function Geographycheck()
{

document.forms[0].Geography_Specific.value='Y';


if(this.document.forms[0].Geography_Specific.checked==true)
{
		document.Interface_Profile_form.Geography_Specific_txt.disabled=false;

//document.forms[0].Geography_Specific_txt.style.visibility='';
}
else
	{
	document.forms[0].Geography_Specific.value='N';
	document.Interface_Profile_form.Geography_Specific_txt.value="";
		document.Interface_Profile_form.Geography_Specific_txt.disabled=true;
//	document.forms[0].Geography_Specific_txt.style.visibility='hidden';
	}


}
/*function Geographycheck()
{
if(this.document.forms[0].Geography_Specific.checked==true)
{
document.forms[0].Geography_specific_txt.style.visibility='';
}
else
	{
	document.forms[0].Geography_specific_txt.style.visibility='hidden';
	}
}*/


function funSearch()
{
if(document.forms[0].Profile_Id.value==""|| document.forms[0].Profile_Id.value==null)
	{

	alert("Profile ID Cannot Be Blank...");
				return false;
	}
if(document.forms[0].Application_Specific_txt1.value==""|| document.forms[0].Application_Specific_txt1.value==null)
	{

	alert("Appliction Id Cannot Be Blank...");
				return false;
	}

parent.parent.frames[3].document.location.href="../../eXH/jsp/InterfacestandardprofileSearch.jsp?standard_code="+parent.parent.frames[1].document.forms[0].standard_code.value+"&profile_id="+document.forms[0].Profile_Id.value;


	//}
}
function funCancel()
{
document.location.reload();
}
function Applicationcheck()
{

if(this.document.forms[0].Application_Specific.checked==true)
{
	document.forms[0].Application_Specific.value='Y';
	document.Interface_Profile_form.Application_Specific_txt1.disabled=false;
	document.Interface_Profile_form.TableSearch.style.disabled=false;
	document.Interface_Profile_form.TableSearch.disabled=false;
//document.forms[0].Application_Specific_txt.style.visibility='';
}
else
	{
	document.forms[0].Application_Specific.value='N';
	document.Interface_Profile_form.Application_Specific_txt1.value="";
	document.Interface_Profile_form.Application_Specific_txt1.value="";
	document.Interface_Profile_form.application_id1.value="";
	document.Interface_Profile_form.Application_Specific_txt1.disabled=true;
	document.Interface_Profile_form.TableSearch.disabled=false;
	document.Interface_Profile_form.TableSearch.disabled=true;
	//document.forms[0].Application_Specific_txt.style.visibility='hidden';
	}
}
//style="display:none;"

function funDelete(Mode)
{

	
	
var act="../../eXH/jsp/Interfacesatndaredqueryrecord.jsp?standard_code="+parent.frames[1].document.forms[0].standard_code.value;

this.document.forms[0].action=act;
this.document.forms[0].act_mode.value =Mode;
//this.document.forms[0].standard_code.value= Standard_code;
this.document.forms[0].target="messageFrame";

this.document.forms[0].submit();


}
function check()
{
	document.forms[0].Version_Specific.value='Y';
if(this.document.forms[0].Version_Specific.checked==true)
{
document.forms[0].Version_Specific_txt.disabled=false;
}
else
	{
	document.forms[0].Version_Specific_txt.value="";
	document.forms[0].Version_Specific_txt.disabled=true;
	}


}
function Sitecheck()
{
if(this.document.forms[0].Site_Specific.checked==true)
{
	document.forms[0].Site_Specific.value='Y';
	document.Interface_Profile_form.Site_Specific_txt.disabled=false;
//document.forms[0].Site_Specific_txt.style.visibility='';
}
else
	{
	document.forms[0].Site_Specific.value='N';
	document.Interface_Profile_form.Site_Specific_txt.value="";
	document.Interface_Profile_form.Site_Specific_txt.disabled=true;
	//document.forms[0].Site_Specific_txt.style.visibility='hidden';
	}


}

function hidevalue()
{
var frmObj=document.forms[0];
if (frmObj.act_mode.value=='U')
{
parent.frames[2].document.forms[0].Delete.disabled=false;


this.document.forms[0].profile_id1value.disabled=true;


	
}
else
	{
	this.document.forms[0].profile_id.disabled=false;
	}

if(frmObj.versionverify.value=='Y')
{
	document.forms[0].Version_Specific.value='Y';
frmObj.Version_Specific.checked=true;
	frmObj.Version_Specific_txt.disabled=false;
}
else
	{
	document.forms[0].Version_Specific.value='N';
frmObj.Version_Specific.checked=false;
	frmObj.Version_Specific_txt.disabled=true;

	}

if(frmObj.Grodrphyverify.value=='Y')
	{
	document.forms[0].Geography_Specific.value='Y';
frmObj.Geography_Specific.checked=true;
	frmObj.Geography_Specific_txt.disabled=false;
}
else
	{
	document.forms[0].Geography_Specific.value='N';
frmObj.Geography_Specific.checked=false;
	frmObj.Geography_Specific_txt.disabled=true;

	}

if(frmObj.Siteverify.value=='Y')
	{
frmObj.Site_Specific.checked=true;
document.forms[0].Site_Specific.value='Y';
	frmObj.Site_Specific_txt.disabled=false;
}
else
	{
frmObj.Site_Specific.checked=false;
document.forms[0].Site_Specific.value='N';
	frmObj.Site_Specific_txt.disabled=true;

	}

	
if(frmObj.Applicationverify.value=='Y')
	{
	document.forms[0].Application_Specific.value='Y';
frmObj.Application_Specific.checked=true;
		frmObj.Application_Specific_txt1.disabled=false;
}
else
	{
	document.forms[0].Application_Specific.value='N';
frmObj.Application_Specific.checked=false;
	frmObj.Application_Specific_txt1.disabled=true;

	}
}

function record()
{
	
	document.forms[0].profile_id.value=document.forms[0].profile_id1value.value;
	
	var fields = new Array (  document.forms[0].profile_id,
							document.forms[0].short_desc,
						     document.forms[0].Long_desc					     
						   );
	
	
	var names = new Array ( 
							getLabel("eXH.ProfileId.Label","XH"),
							getLabel("eXH.Short Description.Label","XH"),
							getLabel("eXH.Long Description.Label","XH"));
	if(!checkFieldsofMst( fields, names, parent.messageFrame,'1'))
	{
	 //parent.frames[0].location.href="../../eCommon/jsp/commonToolbar.jsp?<%=params2%>";

	}
	else
	{
		if(this.document.forms[0].act_mode.value=='U')
		{


    	}
		else
		{
		
			this.document.forms[0].profile_id.value=this.document.forms[0].profile_id1value.value;
		}
		var act="../../eXH/jsp/Interfacesatndaredqueryrecord.jsp?standard_code="+parent.frames[1].document.forms[0].standard_code.value;
		this.document.forms[0].action=act;
		//this.document.forms[0].standard_code.value= Standard_code;
		this.document.forms[0].target="messageFrame";
		this.document.forms[0].submit();
	}
	parent.commontoolbarFrame.document.location.reload();
}
