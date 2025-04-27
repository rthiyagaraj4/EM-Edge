//******************************************************************************/
//function funSubmit
//**************************************************************************************/
function funSubmit() 
{ 
	var act = '../../eXH/jsp/DataElementCrossRefApplicationElementSetupResult.jsp';
	this.document.forms[0].action = act;
	this.document.forms[0].target = '';
	this.document.forms[0].submit(); 
	parent.frames[3].document.location.href='../../eCommon/jsp/MstCodeError.jsp';
}
//*************************************************************************************/
//function funCheck
//**************************************************************************************/
function funCheck(obj,cou)
{ 
//	alert(document.getElementById("_field"+cou).value);
		document.getElementById("_field"+cou).value="Y";
	if (obj.checked == true)
	{
		
		obj.value = 'Y';
         if((document.getElementById("ehisentity_id"+cou).value=='') || (document.getElementById("ehis_entityname"+cou).value==''))
			{
				alert(getMessage('XH0077','XH'));

				document.getElementById("ehis_entityname"+cou).focus();
			}
            else
			{

			}
 
	}  
	else
	{
		obj.value = 'N';
	}
}
//**************************************************************************************/
//function funAction
//**************************************************************************************/

function changeForm(typ)
{
document.forms[0].action_type.value = typ;
	funSubmit();
}

function funAction(typ)
{

	document.forms[0].action_type.value = typ;
	funSubmit();
}   
//*************************************************************************************/

function myClick(e,j)
{

searchehisEntity(e.srcElement.name,j);

 

}
function searchehisEntity(whichfield,whichelement)
{
	document.getElementById("_field"+whichelement).value="Y";
	var tdesc="";
	var desc=new Array();
            var tcode="";
            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit=getLabel("eXH.ehisentity.Label","XH") ;
 			var sql="";
            var translate="";        
var secondlistitem ="ehis_entityname"+whichelement;
var firstlistitem="ehisentity_id"+whichelement;
var masterid="medicom_master"+whichelement;
var obj=document.getElementById(masterid);
var target=document.getElementById(secondlistitem);
var appl_id=document.getElementById(firstlistitem);


sql="SELECT  DISTINCT MASTER_TABLE_ID code,TABLE_DESC||'-'||TRANS_TABLE_ID description from XH_MAPPING "+
				"WHERE MASTER_TABLE_ID=NVL('"+obj.value+"',MASTER_TABLE_ID) and UPPER(MASTER_TABLE_ID) LIKE UPPER(?) AND"+
			"           UPPER(TABLE_DESC) LIKE UPPER(?) "+
				"ORDER BY 1 ";

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
               desc=arr[1].split("-");
              target.value=desc[0];
              appl_id.value=arr[0];
                translate=arr[2];

				//this.document.forms[0].ehis_entity_id.value=appl_id.value;
            }
        else{
                target.value=tdesc;
                appl_id.value=tcode;
               //this.document.forms[0].ehis_entity_id.value=appl_id.value;

            }
    if(desc[1]!=null || desc[1]!='undefined')
	{
	
	  document.getElementById("Translate_entity"+whichelement).value=desc[1];
	  changeText(whichelement);
   // searchTranslateentity(appl_id.value,whichelement);
	}
}

async function searchTranslateentity(ehisentity,whichelement)
{
	//changeForm('0');
	var dialogHeight= "0" ;
	var dialogWidth	= "0" ;
	var dialogTop = "0" ;
	var center = "0" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments="";
	var str=await window.showModalDialog("../../eXH/jsp/Datacrossehisentityonblur.jsp?&ehisentity="+ehisentity+"&Title=Transaltion Query events",arguments,features);
   document.getElementById("Translate_entity"+whichelement).value=str;
//document.getElementById("Translate_entitya2"+whichelement).value=str;




changeText(whichelement);
}

function searchElementID(e,whichelement)
{
	var fieldname=e.srcElement.name;
var tdesc="";
            var tcode="";
            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit="Attribute 1" ;
			var sql=""; 

//var secondlistitem ="element_name"+whichelement;
var firstlistitem="element_id"+whichelement;
var target=document.getElementById(secondlistitem);
var appl_id=document.getElementById(firstlistitem);

sql="SELECT ELEMENT_ID code,ELEMENT_NAME description FROM XH_ELEMENT_CROSSREF "+
                    "   WHERE UPPER(ELEMENT_ID) LIKE UPPER(?) AND "+ 
                    "           UPPER(ELEMENT_NAME) LIKE UPPER(?) "+
                    "           ORDER BY ELEMENT_SEQ ";

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
				//this.document.forms[0].ehis_entity_id.value=appl_id.value;
            }
            else{
                target.value=tdesc;
                appl_id.value=tcode;
//this.document.forms[0].ehis_entity_id.value=appl_id.value;

            }
 
}
function searchElementID1(e,whichelement)
{
	document.getElementById("_field"+whichelement).value="Y";

	var masterid="medicom_master"+whichelement;
var obj=document.getElementById(masterid);
	var fieldname=e.srcElement.name;
var tdesc="";
            var tcode="";
            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit=getLabel("Common.secondary.label","common")+" "+getLabel("Common.resource.label","common");  
			var sql="";
var element_id=document.getElementById("element_id"+whichelement).value;

var secondlistitem ="element_namea2"+whichelement;
var firstlistitem="element_ida2"+whichelement;
var target=document.getElementById(secondlistitem);
var appl_id=document.getElementById(firstlistitem);
if(obj.value=='')
	{
	 sql="SELECT ELEMENT_ID code,ELEMENT_NAME description FROM XH_ELEMENT_CROSSREF where UPPER(ELEMENT_ID) LIKE UPPER(?) AND "+ 
                    "           UPPER(ELEMENT_NAME) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";
	}
	else
	{
 sql="SELECT ELEMENT_ID code,ELEMENT_NAME description FROM XH_ELEMENT_CROSSREF where element_id=(select UPPER(SUBSTR(pk_element_ref,0,INSTR(pk_element_ref,'|')-1))  FROM XH_ELEMENT_CROSSREF where element_id= '"+element_id+"' ) and UPPER(ELEMENT_ID) LIKE UPPER(?) AND "+ 
                    "           UPPER(ELEMENT_NAME) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";
	}

/*sql="SELECT ELEMENT_ID code,ELEMENT_NAME description FROM XH_ELEMENT_CROSSREF "+
                    "   WHERE UPPER(ELEMENT_ID) LIKE UPPER(?) AND "+ 
                    "           UPPER(ELEMENT_NAME) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";*/

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
				//this.document.forms[0].ehis_entity_id.value=appl_id.value;
            }
            else{
                target.value=tdesc;
                appl_id.value=tcode;
//this.document.forms[0].ehis_entity_id.value=appl_id.value;

            }
		//	 retVal =CallCatalogSearch(sql,target); 

}

function formload()
{


var count=document.forms[0].count_field.value;

for(var i=0;i<count;i++)
	{
	document.getElementById("element_id"+i).disabled=false;
	//document.getElementById("select"+i).checked=true;
//	document.getElementById("select"+i).value='Y';
	//document.getElementById("element_name"+i).style.visibility = 'hidden';
//document.getElementById("elementIDSearch"+i).style.visibility = 'hidden';
//document.getElementById("element_namea2"+i).style.visibility = 'hidden';
document.getElementById("element_namea2"+i).disabled = true;
document.getElementById("elementIDSearcha2"+i).disabled = true;
//document.getElementById("Translation_query"+i).style.visibility = 'hidden';
var transentity=document.getElementById("Translate_entity"+i).value;
var formate=document.getElementById("formate_type1"+i).value;

//document.getElementById("Translation_query"+i).style.visibility = 'hidden';

if(transentity=="XH_OTH_APPL_DATA_SKEY" )
		{

//document.getElementById("Translation_query"+i).value='';
//document.getElementById("element_name"+i).style.visibility = '';
//document.getElementById("elementIDSearch"+i).style.visibility = '';
document.getElementById("element_namea2"+i).disabled = true;
document.getElementById("elementIDSearcha2"+i).disabled = true;

//document.getElementById("TranslateQry"+i).style.visibility = 'hidden';

	
//document.getElementById("formate_type"+i).options[0]=new Option("Code & Description","H",true, false); 
//document.getElementById("formate_type"+i).options[1]=new Option("Code","S",false, false);

//else
//{
//document.getElementById("formate_type"+i).options[0]=new Option("Code & Description","H",false, false); 
//document.getElementById("formate_type"+i).options[1]=new Option("Code","S",true, false);
//}	
				//document.getElementById("elementresource"+i).style.display='block';
//document.getElementById("Translation"+i).style.display='none';

		}
else if(transentity=="XH_OTH_APPL_DATA_DKEY")
	{
//document.getElementById("Translation_query"+i).value='';
	//document.getElementById("element_name"+i).style.visibility = '';

	document.getElementById("element_namea2"+i).disabled = false;
	document.getElementById("elementIDSearcha2"+i).disabled = false;
//document.getElementById("elementIDSearch"+i).style.visibility = '';

//document.getElementById("TranslateQry"+i).style.visibility = 'hidden';

/*if(formate=='H' || formate=='')
{
document.getElementById("formate_type"+i).options[0]=new Option("Code & Description","H",true, false); 
document.getElementById("formate_type"+i).options[1]=new Option("Code","S",false, false);
}
else
{
document.getElementById("formate_type"+i).options[0]=new Option("Code & Description","H",false, false); 
document.getElementById("formate_type"+i).options[1]=new Option("Code","S",true, false);
}	*/			
//document.getElementById("elementresource"+i).style.display='block';
//document.getElementById("Translation"+i).style.display='none';
	}
	else
	{
	
if(document.getElementById("ehis_entityname"+i).value!="" || document.getElementById("ehisentity_id"+i).value!="")
		{

	document.getElementById("element_namea2"+i).disabled = true;
document.getElementById("elementIDSearcha2"+i).disabled = true;
	document.getElementById("element_namea2"+i).value = '';
		document.getElementById("element_id"+i).disabled=true;
		document.getElementById("element_ida2"+i).value = '';



		//document.getElementById("element_name"+i).value = '';
		
			//document.getElementById("element_id"+i).value='';
		
//document.getElementById("element_id"+i).value = '';
	
	//document.getElementById("element_name"+i).style.visibility = 'hidden';
//document.getElementById("elementIDSearch"+i).style.visibility = 'hidden';

				//document.getElementById("elementresource"+i).style.display='block';
//document.getElementById("Translation"+i).style.display='none';
//document.getElementById("TranslateQry"+i).style.visibility='hidden';
//document.getElementById("formate_type"+i).options[0]=new Option("User Defined","U",true, false); 
//document.getElementById("formate_type"+i).options[0]=new Option("User Defined","U",true, false); 
	//	document.getElementById("elementresource"+i).style.display='none';
//document.getElementById("Translation"+i).style.display='none';
//for ( var k=0;k<document.getElementById("formate_type"+i).options.length;k++)
 //document.getElementById("formate_type"+i).options[k] = null;


//document.getElementById("TranslateQry"+i).style.visibility = 'hidden';
//document.getElementById("formate_type"+i).options[0]=new Option(getLabel("Common.UserDefined.label","common"),"U",true, false); 
		}
		else 
		{
	
			//document.getElementById("element_id"+i).value='';
			document.getElementById("element_id"+i).disabled=true;
				//document.getElementById("elementresource"+i).style.display='block';
//document.getElementById("Translation"+i).style.display='none';
			//document.getElementById("select"+i).checked=false;
			//document.getElementById("select"+i).value='N';
		//	document.getElementById("element_name"+i).value = '';
			document.getElementById("element_namea2"+i).value = '';
		//document.getElementById("element_id"+i).value = '';
	document.getElementById("element_ida2"+i).value = '';
//document.getElementById("element_name"+i).style.visibility = 'hidden';
//document.getElementById("elementIDSearch"+i).style.visibility = 'hidden';
document.getElementById("element_namea2"+i).disabled = true;
document.getElementById("elementIDSearcha2"+i).disabled = true;
//document.getElementById("TranslateQry"+i).style.visibility='hidden';
//if(document.getElementById("formate_type"+i)!=null)
//{
	//alert(document.getElementById("formate_type"+i).options.length);
  //for ( var k=0;k<document.getElementById("formate_type"+i).options.length;k++) 
  //document.getElementById("formate_type"+i).options[k] = null;
//}
//document.getElementById("TranslateQry"+i).style.visibility = 'hidden';
//document.getElementById("formate_type"+i).options[0]=new Option(getLabel("Common.code.label","common")+" & "+ getLabel("Common.description.label","common"),"H",true, false); 
//document.getElementById("formate_type"+i).options[1]=new Option(getLabel("Common.code.label","common"),"S",false, false);
//document.getElementById("formate_type"+i).options[0]=new Option("Code & Description","H",true, false); 
//document.getElementById("formate_type"+i).options[1]=new Option("Code","S",false, false);
///document.getElementById("formate_type"+i).options[0]=new Option("--------"+"Select"+"--------","",true, false); 

 
		}


	}

		
	}


}
function checkValid(obj,i)
{
	
document.getElementById("_field"+i).value="Y";
if(document.getElementById(obj).value=="")
	{
	//document.getElementById("formate_type"+i).disabled=true;
 //  for ( var k=0;k<document.getElementById("formate_type"+i).options.length;k++)
//  document.getElementById("formate_type"+i).options[k] = null;

for ( var k=0;k<document.getElementById("formate_type"+i).options.length;k++)
 document.getElementById("formate_type"+i).options[k] = null;


//document.getElementById("TranslateQry"+i).style.visibility = 'hidden';
document.getElementById("formate_type"+i).options[0]=new Option(getLabel("Common.code.label","common")+" & "+ getLabel("Common.description.label","common"),"H",true, false); 
document.getElementById("formate_type"+i).options[1]=new Option(getLabel("Common.code.label","common"),"S",false, false);


document.getElementById(obj).value='';
 document.getElementById("element_id"+i).disabled=true;
document.getElementById("select"+i).checked=false;
document.getElementById("select"+i).value='N';
document.getElementById("ehisentity_id"+i).value="";
//document.getElementById("element_name"+i).style.visibility = 'hidden';
//document.getElementById("elementIDSearch"+i).style.visibility = 'hidden';\
//document.getElementById("Translation"+i).style.display='none';
				//document.getElementById("elementresource"+i).style.display='block';
document.getElementById("element_namea2"+i).style.visibility = '';
document.getElementById("elementIDSearcha2"+i).style.visibility = '';
document.getElementById("ehisentity_id"+i).vlaue='';
			document.getElementById("element_id"+i).disabled=true;
document.getElementById("element_namea2"+i).value='';
document.getElementById("element_ida2"+i).value='';
document.getElementById("element_namea2"+i).disabled = true;
document.getElementById("elementIDSearcha2"+i).disabled = true;
//document.getElementById("Translation_query"+i).style.visibility='hidden';
//document.getElementById("Translate_entitya2"+i).value='';
//document.getElementById("formate_type"+i).options[0]=new Option("--------"+"Select"+"--------","",true, false); 

	}
}

function itemChange(i)
{
	
var formate=document.getElementById("formate_type"+i).value;
var transentity=document.getElementById("Translate_entity"+i).value;
if(formate=='U')
		{
//document.getElementById("element_name"+i).style.visibility = 'hidden';
//document.getElementById("elementIDSearch"+i).style.visibility = 'hidden';


document.getElementById("element_namea2"+i).disabled = false;
document.getElementById("elementIDSearcha2"+i).disabled = false;
//document.getElementById("Translation_query"+i).style.visibility = '';
//document.getElementById("Translation_query"+i).disabled=true;
		}
		else
	{
if(transentity=="XH_OTH_APPL_DATA_DKEY" || transentity=="XH_OTH_APPL_DATA_SKEY" )
		{

document.getElementById("element_namea2"+i).disabled = false;
document.getElementById("elementIDSearcha2"+i).disabled = false;
		}

//document.getElementById("element_name"+i).style.visibility = '';
//document.getElementById("elementIDSearch"+i).style.visibility = '';
//document.getElementById("Translation_query"+i).style.visibility = 'hidden';


	}
}
async function openwindow(translate_query_string,translateqry)
{

var translate_query=document.getElementById(translate_query_string).value;
var translate_value=document.getElementById(translateqry).value;


// var SystemDef_id=document.forms[0].SystemDefine_id.value;
	var dialogHeight= "30vh" ;
	var dialogWidth	= "45vw" ;
	var dialogTop = "190" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
var str=await window.showModalDialog("../../eXH/jsp/datacrossrefTranslationQuery.jsp?translate_query="+escape(translate_query)+"&Title="+translate_query,arguments,features);


if(str=='undefined' || str=='' || str==null)
{

	 document.getElementById(translateqry).value=translate_value;
}
else
{

	document.getElementById(translateqry).value=str;

}

}
function changeText(i) 
{
	document.getElementById("_field"+i).value="Y";
document.getElementById("element_id"+i).disabled=false;
	document.getElementById("formate_type"+i).disabled=false;
//for ( var k=0;k<document.getElementById("formate_type"+i).options.length;k++)
  //document.getElementById("formate_type"+i).options[k] = null;

	//document.getElementById("select"+i).value='Y';
	//document.getElementById("select"+i).checked=true;
//var transentity=document.getElementById("Translate_entitya2"+i).value;
var transentity=document.getElementById("Translate_entity"+i).value;


//document.getElementById("element_name"+i).style.visibility = 'hidden';
//document.getElementById("elementIDSearch"+i).style.visibility = 'hidden';
document.getElementById("element_namea2"+i).disabled = true;
document.getElementById("elementIDSearcha2"+i).disabled = true;
//document.getElementById("TranslateQry"+i).style.visibility='hidden';
//document.getElementById("Translation_query"+i).style.visibility = 'hidden';
 if(transentity=="XH_OTH_APPL_DATA_SKEY" )
{
document.getElementById("Translation_query"+i).value = '';
//document.getElementById("element_name"+i).style.visibility = '';
//document.getElementById("elementIDSearch"+i).style.visibility = '';
document.getElementById("element_namea2"+i).disabled = true;
document.getElementById("elementIDSearcha2"+i).disabled = true;
for ( var k=0;k<document.getElementById("formate_type"+i).options.length;k++)
 document.getElementById("formate_type"+i).options[k] = null;


//document.getElementById("TranslateQry"+i).style.visibility = 'hidden';
document.getElementById("formate_type"+i).options[0]=new Option(getLabel("Common.code.label","common")+" & "+ getLabel("Common.description.label","common"),"H",false, false); 
document.getElementById("formate_type"+i).options[1]=new Option(getLabel("Common.code.label","common"),"S",true, false)
				//document.getElementById("elementresource"+i).style.display='block';
//document.getElementById("Translation"+i).style.display='none';

		} 
else if(transentity=="XH_OTH_APPL_DATA_DKEY")
	{
	document.getElementById("Translation_query"+i).value = '';
	//document.getElementById("element_name"+i).style.visibility = '';
	document.getElementById("element_namea2"+i).disabled = false;
//document.getElementById("elementIDSearch"+i).style.visibility = '';
document.getElementById("elementIDSearcha2"+i).disabled = false;


for ( var k=0;k<document.getElementById("formate_type"+i).options.length;k++)
 document.getElementById("formate_type"+i).options[k] = null;


//document.getElementById("TranslateQry"+i).style.visibility = 'hidden';
document.getElementById("formate_type"+i).options[0]=new Option(getLabel("Common.code.label","common")+" & "+ getLabel("Common.description.label","common"),"H",true, false); 
document.getElementById("formate_type"+i).options[1]=new Option(getLabel("Common.code.label","common"),"S",false, false)

//document.getElementById("TranslateQry"+i).style.visibility = 'hidden';
//document.getElementById("formate_type"+i).options[0]=new Option("Code & Description","H",true, false); 
//document.getElementById("formate_type"+i).options[1]=new Option("Code","S",false, false)
				//document.getElementById("elementresource"+i).style.display='block';
//document.getElementById("Translation"+i).style.display='none';
	}
	else
	{
		
if(document.getElementById("ehis_entityname"+i).value!="" || document.getElementById("ehisentity_id"+i).value!="")
		{
//document.getElementById("Translation_query"+i).disabled = false;

	//document.getElementById("element_name"+i).style.visibility = 'hidden';
//document.getElementById("elementIDSearch"+i).style.visibility = 'hidden';
//document.getElementById("element_id"+i).value='';



document.getElementById("element_id"+i).style.display='block';
/*document.getElementById("element_namea2"+i).style.display='block';*/
document.getElementById("elementIDSearcha2"+i).disabled = true;
document.getElementById("element_namea2"+i).disabled = true;
document.getElementById("elementIDSearcha2"+i).disabled = true;
//document.getElementById("elementresource"+i).style.display='block';
//document.getElementById("Translation"+i).style.display='none';
//document.getElementById("TranslateQry"+i).style.visibility='hidden';
//document.getElementById("formate_type"+i).options[0]=new Option("User Defined","U",true, false);
for ( var k=0;k<document.getElementById("formate_type"+i).options.length;k++)
 document.getElementById("formate_type"+i).options[k] = null;

document.getElementById("formate_type"+i).options[0]=new Option(getLabel("Common.UserDefined.label","common"),"U",true, false); 
		}
		else
		{
			document.getElementById("ehis_entityname"+i).value='';
			document.getElementById("ehisentity_id"+i).vlaue='';
			document.getElementById("element_id"+i).value='';
			document.getElementById("element_id"+i).disabled=true;
			document.getElementById("Translation_query"+i).value = '';
		//document.getElementById("elementresource"+i).style.display='block';
//document.getElementById("Translation"+i).style.display='none';
		document.getElementById("select"+i).checked=false;
		document.getElementById("select"+i).value='N';
//document.getElementById("element_name"+i).style.visibility = 'hidden';
//document.getElementById("elementIDSearch"+i).style.visibility = 'hidden';
document.getElementById("element_namea2"+i).disabled = true;
document.getElementById("elementIDSearcha2"+i).disabled = true;
//document.getElementById("TranslateQry"+i).style.visibility='hidden';
//document.getElementById("formate_type"+i).options[0]=new Option("--------"+"Select"+"--------","",true, false); 
document.getElementById("formate_type"+i).disabled=false;
//document.getElementById("formate_type"+i).options[0]=new Option("--------"+"Select"+"--------","",true, false); 
		}

 
	}

}
async function CallCatalogSearch(Query,target)
{
	var module_id='XH';
	var mode="";
	var searchtext=target.value;

	//var clinic_code = parent.frames[3].document.forms[0].assign_care_locn_code.value;
var dialogHeight = "55vh";
var dialogWidth  = "50vw";
var dialogTop    = "250";
var dialogLeft   = "250";
var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
/*	var dialogTop	= "56"; 
	var dialogHeight= "33" ; 
	var dialogWidth = "50" ;
	var status = "no";
	var scroll = "no";
	var features    = "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll;*/
	var arguments   = "" ;			
	var retVal=await window.showModalDialog("../../eXH/jsp/TranslationSettingLookupFrameset.jsp?searchText="+encodeURIComponent(searchtext)+"&sql_query="+encodeURIComponent(Query)+"&called_from=XH&mode="+mode,arguments,features);	




    return retVal;
	//var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='popordercatalog' id='popordercatalog' method='post' action='../../eOP/jsp/RoomValidationYN.jsp'><input type='hidden' name='callfunc' id='callfunc' value='OrderCatalog'></form></body></html>";		
				
	//parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal); 
	//parent.parent.messageFrame.document.popordercatalog.submit();
}

