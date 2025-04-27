//********************************************************************************************

//********************************************************************************************
function create()
{
	//InterfaceStandardFrame.rows="15,100,100,15";
	
	document.getElementById("commontoolbarFrame").style.height="7vh";
	document.getElementById("f_query_add_mod").style.height="36vh";
	document.getElementById("f_query_add_mod_detail").style.height="45vh";
	document.getElementById("messageFrame").style.height="8vh";
	
	/*parent.document.getElementById("commontoolbarFrame").style.height="7vh";
	parent.document.getElementById("f_query_add_mod").style.height="36vh";
	parent.document.getElementById("f_query_add_mod_detail").style.height="45vh";
	parent.document.getElementById("messageFrame").style.height="8vh";*/
	
	
	var rule='NR';
	window.f_query_add_mod.location.href="../../eXH/jsp/InterfaceStandardsSelectMaster.jsp?rule="+rule+"&mode=I";
	window.f_query_add_mod_detail.location.href="../../eCommon/html/blank.html";

/*var rule='NR';
window.f_query_add_mod.location.href="../../eXH/jsp/InterfaceStandardsSelectMaster.jsp?rule="+rule+"&mode=I";		
window.f_query_add_mod_detail.location.href="../../eCommon/html/blank.html";		
window.messageFrame.location.href="../../eCommon/html/blank.html";*/

}
//********************************************************************************************

//********************************************************************************************
function query()
{
	//InterfaceStandardFrame.rows="30,320,50,30";
	document.getElementById("commontoolbarFrame").style.height="7vh";
	document.getElementById("f_query_add_mod").style.height="80vh";
	document.getElementById("f_query_add_mod_detail").style.height="13vh";
	document.getElementById("messageFrame").style.height="8vh";

	window.f_query_add_mod.location.href="../../eXH/jsp/InterfaceStandardsQueryCriteria.jsp?mode=U";	
	window.messageFrame.location.href="../../eCommon/html/blank.html";
	window.f_query_add_mod_detail.location.href="../../eCommon/html/blank.html";
 
}
//********************************************************************************************

//********************************************************************************************
function deleterecord()
{

		window.f_query_add_mod.document.forms[0].act_mode.value = 'D';
			apply();
}
//********************************************************************************************
//FUNCTION APPLY()
//********************************************************************************************
function apply()
{

var tab=this.window.frames[1].document.forms[0].tab.value;
if(tab=="Profile")
	{
	
var act="../../servlet/eXH.InterfaceStandaredProfileServlet?Profile_Id="+this.window.frames[1].document.forms[0].Profile_Id.value+"&standard_code="+window.frames[1].document.forms[0].standard_code.value+"&act_mode=U";

this.window.frames[1].document.forms[0].action=act;

this.window.frames[1].document.forms[0].target='messageFrame';

this.window.frames[1].document.forms[0].submit();



	var fields = new Array (  
						  frames[1].document.forms[0].standard_code,
					      frames[1].document.forms[0].standard_desc,
					      frames[1].document.forms[0].standard_type,
						  frames[1].document.forms[0].msg_start,
					      frames[1].document.forms[0].msg_end,
						  frames[1].document.forms[0].seg_end,
						  frames[1].document.forms[0].fld_separator
					     );

// getLabel("eXH.Data.Label","XH"),

	var names = new Array ( 
						getLabel("Common.code.label","XH"),
						getLabel("Common.description.label","common"),
						getLabel("eXH.StandardType.Label","XH"),
						getLabel("eXH.MsgStart.Label","XH"),
						getLabel("eXH.MsgEnd.Label","XH"),
						getLabel("eXH.SegEnd.Label","XH"),
						getLabel("eXH.FldSeparator.Label","XH")
						);
  
	if(!f_query_add_mod.checkFields( fields, names, messageFrame))
	{
   
	}else
		{  
//			alert("Mode : "+frames[1].document.forms[0].act_mode.value);
//          alert("dg_code : "+frames[1].document.forms[0].dg_code.value);
//			alert("protocol_link_id : "+frames[1].document.forms[0].protocol_link_id.value);



   		   
		}

 window.f_query_add_mod.document.forms[0].submit()




}
	else if(tab=="ControlStructure")
	{

	//this.window.frames[2].frames[1].document.forms[0].submit();

	}
else
	{

	var fields = new Array (  
						  frames[1].document.forms[0].standard_code,
					      frames[1].document.forms[0].standard_desc,
					      frames[1].document.forms[0].standard_type,
						  frames[1].document.forms[0].msg_start,
					      frames[1].document.forms[0].msg_end,
						  frames[1].document.forms[0].seg_end,
						  frames[1].document.forms[0].fld_separator
					     );

// getLabel("eXH.Data.Label","XH"),

	var names = new Array ( 
						getLabel("Common.code.label","XH"),
						getLabel("Common.description.label","common"),
						getLabel("eXH.StandardType.Label","XH"),
						getLabel("eXH.MsgStart.Label","XH"),
						getLabel("eXH.MsgEnd.Label","XH"),
						getLabel("eXH.SegEnd.Label","XH"),
						getLabel("eXH.FldSeparator.Label","XH")
					);
  
	if(!f_query_add_mod.checkFields( fields, names, messageFrame))
	{
   
	}else
		{  



window.f_query_add_mod.document.forms[0].target='messageFrame';
 window.f_query_add_mod.document.forms[0].submit();

   		   
		}
		
	}




	

window.commontoolbarFrame.document.location.reload();






}
//********************************************************************************************
//FUNCTION RESET 
//********************************************************************************************
function reset()
{

	
	if(window.f_query_add_mod.document.forms[0])
    {
	
	 window.f_query_add_mod.document.forms[0].reset();
	 //window.bodyframe.
	}
}




//********************************************************************************************
//function funSubmit
//*******************************************************************************************
function funSubmit()
{
	// #MOD#01
	var act = '../../eXH/jsp/InterfaceStandardsQueryResult.jsp';
	this.document.forms[0].action = act;
	this.document.forms[0].submit();
}
//*******************************************************************************************
//function funModify
//*******************************************************************************************

function funModify(obj)
{
	
	// #MOD#02
	//parent.commontoolbarFrame.document.forms[0].apply.style.display='block';

	//parent.frames[1].rows="15,100,100,15";
	this.document.forms[0].standard_code.value = obj.getAttribute('standard_code');
	this.document.forms[0].standard_desc.value = obj.getAttribute('standard_desc');
	this.document.forms[0].standard_type.value = obj.getAttribute('standard_type');
	this.document.forms[0].msg_start.value = obj.getAttribute('msg_start');
	this.document.forms[0].msg_end.value = obj.getAttribute('msg_end');
	this.document.forms[0].seg_start.value = obj.getAttribute('seg_start');
	this.document.forms[0].seg_end.value = obj.getAttribute('seg_end');
	this.document.forms[0].fld_separator.value = obj.getAttribute('fld_separator');
	this.document.forms[0].elmnt_separator.value = obj.getAttribute('elmnt_separator');

//parent.frames[1].location.href="../../eXH/jsp/InterfaceStandardsSelectMaster.jsp?mode=U";
//parent.frames[2].location.href="../../eXH/jsp/InterfaceStandardMainTab.jsp";

//parent.parent.f_query_add_mod_detail.location.href="../../eXH/jsp/InterfaceStandardMainTab.jsp";

//	window.f_query_add_mod_detail.location.href="../../eXH/jsp/InterfaceStandardMainTab.jsp";		
//window.messageFrame.location.href="../../eCommon/html/blank.html";
//	this.document.forms[0].lang_id.value = obj.getAttribute('lang_id');
	var act = '../../eXH/jsp/InterfaceStandardsSelectMaster.jsp?mode=U';
	//this.document.forms[0].target='messageFrame';
	this.document.forms[0].action = act;
	this.document.forms[0].submit();
//	parent.frames[1].rows="15,100,100,15";
	//window.parent.InterfaceStandardFrame.rows="15,100,100,15";
	
	parent.document.getElementById("commontoolbarFrame").style.height="7vh";
	parent.document.getElementById("f_query_add_mod").style.height="36vh";
	parent.document.getElementById("f_query_add_mod_detail").style.height="45vh";
	parent.document.getElementById("messageFrame").style.height="8vh";
	
//create();

//window.f_query_add_mod.location.href="../../eXH/jsp/InterfaceStandardsSelectMaster.jsp?mode=U";		






}
//*******************************************************************************************
//function funAction
//*******************************************************************************************

function funAction(typ)
{
	document.forms[0].action_type.value = typ;
	funSubmit();
}
//*******************************************************************************************

//********************************************************************************************
//function searchSegmentType
//*******************************************************************************************

async function searchSegmentType(){
     
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit="Segment Type" ;
            var target=this.document.forms[0].segment_type;
            var segment_id=this.document.forms[0].segment_type_id;
/*
            sql="SELECT SEGMENT_NAME description,SEGMENT_TYPE code FROM XH_SEGMENT "+
                    "   WHERE UPPER(SEGMENT_TYPE) LIKE UPPER(?) AND "+ 
                    "           UPPER(SEGMENT_NAME) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";
*/
			sql="SELECT SEGMENT_TYPE code,SEGMENT_NAME description FROM XH_SEGMENT "+
                    "   WHERE UPPER(SEGMENT_TYPE) LIKE UPPER(?) AND "+ 
                    "           UPPER(SEGMENT_NAME) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";

            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
      //    argumentArray[4] = "2,1";
	        argumentArray[4] = "1,2";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                segment_id.value=arr[0];
            }
            else{
                target.value=tdesc;
                segment_id.value=tcode;
            }
}// End of searchSegmentType searchDefaultVal
 
 //********************************************************************************************
//function searchDefaultVal
//*******************************************************************************************

async function searchDefaultVal(){
     
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit="Reference Name" ;
            var target=this.document.forms[0].default_val;
            var def_val_id=this.document.forms[0].def_val_id;
/*
            sql="SELECT SEGMENT_NAME description,SEGMENT_TYPE code FROM XH_SEGMENT "+
                    "   WHERE UPPER(SEGMENT_TYPE) LIKE UPPER(?) AND "+ 
                    "           UPPER(SEGMENT_NAME) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";
*/

			sql="SELECT REFERENCE_ID code,REFERNECE_NAME description FROM XH_GLOBAL_REFERNCES "+
                    "   WHERE UPPER(REFERENCE_ID) LIKE UPPER(?) AND "+ 
                    "           UPPER(REFERNECE_NAME) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";

            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
      //    argumentArray[4] = "2,1";
	        argumentArray[4] = "1,2";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                def_val_id.value=arr[0];
            }
            else{
                target.value=tdesc;
                def_val_id.value=tcode;
            }
}// End of searchDefaultVal 
 
async function searchApplication(){
   
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit="Application" ;
				
				 
            var target=document.forms[0].Application_Specific_txt;
		
            var appl_id=document.forms[0].application_id;
 
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
}// End of searchApplication


//******************************************************************/
//function callJSPs
//******************************************************************/

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

async function searchElement(){
   
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
            var target=document.forms[0].element_name;
            var appl_id=document.forms[0].ele_val_id;
			
 
            sql="SELECT ELEMENT_ID code,ELEMENT_NAME description FROM XH_ELEMENT_CROSSREF "+
                    "   WHERE UPPER(ELEMENT_ID) LIKE UPPER(?) AND "+ 
                    "           UPPER(ELEMENT_NAME) LIKE UPPER(?) "+
                    "           ORDER BY 1 " ;

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
				document.forms[0].element_idvalue.value=arr[0];
            } 
            else{
                target.value=tdesc;
                appl_id.value=tcode;
				
            }
} 



async function searchctrlElement(){
   
   
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
            var target=document.forms[0].element_control;
            var appl_id=document.forms[0].element_controlID;
			
 
            sql="SELECT ELEMENT_ID code,ELEMENT_DESC description FROM XH_CONTROL_ELEMENT "+
                    "   WHERE UPPER(ELEMENT_ID) LIKE UPPER(?) AND "+ 
                    "           UPPER(ELEMENT_DESC) LIKE UPPER(?) "+
                    "           ORDER BY 1";
				
			
			
			/*"SELECT ELEMENT_ID code,ELEMENT_DESC description FROM XH_CONTROL_ELEMENT "+
                    "   WHERE UPPER(ELEMENT_ID) LIKE UPPER(?) AND "+ 
                    "           UPPER(ELEMENT_DESC) LIKE UPPER(?) "+
                    "           ORDER BY 1 " ;*/

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
				document.forms[0].element_ctrlidvalue.value=arr[0];
            } 
            else{
                target.value=tdesc;
                appl_id.value=tcode;
				
            }
} 







function funModify1(obj)
{
	
	// #MOD#02


	
	this.document.forms[0].standard_code.value = obj.getAttribute('standard_code');
	this.document.forms[0].standard_desc.value = obj.getAttribute('standard_desc');
	this.document.forms[0].standard_type.value = obj.getAttribute('standard_type');
	this.document.forms[0].msg_start.value = obj.getAttribute('msg_start');
	this.document.forms[0].msg_end.value = obj.getAttribute('msg_end');
	this.document.forms[0].seg_start.value = obj.getAttribute('seg_start');
	this.document.forms[0].seg_end.value = obj.getAttribute('seg_end');
	this.document.forms[0].fld_separator.value = obj.getAttribute('fld_separator');
	this.document.forms[0].elmnt_separator.value = obj.getAttribute('elmnt_separator');


//parent.frames[1].location.href="../../eXH/jsp/InterfaceStandardsSelectMaster.jsp?mode=U";
//parent.frames[2].location.href="../../eXH/jsp/InterfaceStandardMainTab.jsp";

//parent.parent.f_query_add_mod_detail.location.href="../../eXH/jsp/InterfaceStandardMainTab.jsp";

//	window.f_query_add_mod_detail.location.href="../../eXH/jsp/InterfaceStandardMainTab.jsp";		
//window.messageFrame.location.href="../../eCommon/html/blank.html";
//	this.document.forms[0].lang_id.value = obj.getAttribute('lang_id');




//window.f_query_add_mod.location.href="../../eXH/jsp/InterfaceStandardsSelectMaster.jsp?mode=U";		

var act = '../../eXH/jsp/InterfaceStandardsSelectMaster.jsp?mode=U&rule=R';
this.document.forms[0].target='';
	this.document.forms[0].action = act;
	this.document.forms[0].submit();

//parent.frames[1].document.location.href='../../eXH/jsp/InterfaceStandardsSelectMaster.jsp?mode=I';
//parent.frames[1].hide1(obj);

}
function refresh()
{

parent.frames[2].document.forms[0].profile_id.value="";
parent.frames[2].document.forms[0].short_desc.value="";
parent.frames[2].document.forms[0].Long_desc.value="";
parent.frames[2].document.forms[0].Version_Specific_txt.value="";
parent.frames[2].document.forms[0].Geography_Specific_txt.value="";
parent.frames[2].document.forms[0].Site_Specific_txt.value="";
parent.frames[2].document.forms[0].Application_Specific_txt1.value="";
parent.frames[2].document.forms[0].Version_Specific.checked=false;
parent.frames[2].document.forms[0].Geography_Specific.checked=false;
parent.frames[2].document.forms[0].Site_Specific.checked=false;
parent.frames[2].document.forms[0].Application_Specific.checked=false;


}


function funAddcrl(Mode)
{

if(document.forms[0].segment_type_id.value==""||document.forms[0].segment_type_id.value==null)
	{
alert(getMessage("XH1039","XH"));
	return false
	}



parent.frames[2].document.location.href="../../eXH/jsp/InterfacestandardctrlAdd.jsp?standard_code="+document.forms[0].standard_code.value+"&Segment_id="+document.forms[0].segment_type_id.value+"&Mode="+Mode;
//parent.frames[2].document.forms[0].Delete.disabled=true;

}

function  func1(Profile_id,Standard_code,Short_desc,Long_desc,Version_specific,Version_desc,Geography_specific,Geography_desc,Application_specific,Application_id,Site_specific,Site_id)
{
	mode='U';
	var url="";

url='&Profile_id='+Profile_id+'&Standard_code='+Standard_code+'&Short_desc='+Short_desc+'&Long_desc='+Long_desc+'&Version_specific='+Version_specific+'&Version_desc='+Version_desc+'&Geography_specific='+Geography_specific+'&Geography_desc='+Geography_desc+'&Application_specific='+Application_specific+'&Application_id='+Application_id+'&Site_specific='+Site_specific+'&Site_id='+Site_id+'&Mode='+mode;
parent.frames[2].document.location.href="../../eXH/jsp/InterfacestandardProfileAdd.jsp?"+url;


}
function CheckForSpecCharsforID(event,objvalue)
{
	
   var strCheck = '0123456789|#$^&*(){}!|';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);

return true ;



}
function FunAdd()
{

	
parent.frames[2].document.location.href="../../eXH/jsp/InterfacestandardProfileAdd.jsp?Mode=I";


//?standard_code="+parent.parent.frames[1].document.forms[0].standard_code.value+"&segment_Id="+document.forms[0].segment_type_id.value;
}
function funSearch() 
{
if(document.forms[0].Profile_Id.value==""|| document.forms[0].Profile_Id.value==null)
	{

	alert("Profile ID Cannot Be Blank...");
				return false;
	}

parent.frames[2].document.location.href="../../eXH/jsp/InterfacestandardprofileSearch.jsp?standard_code="+document.forms[0].standard_code.value+"&profile_id="+document.forms[0].Profile_Id.value;


	//}
}
function funSearchcrl(Mode)
{



if(document.forms[0].segment_type_id.value=="" || document.forms[0].segment_type_id.value==null)
	{
alert(getMessage("XH1039","XH"));

	return false
	}
parent.frames[2].document.location.href="../../eXH/jsp/InterfacestandardctrlSearch.jsp?standard_code="+document.forms[0].standard_code.value+"&segment_Id="+document.forms[0].segment_type_id.value+"&Mode="+Mode;
parent.frames[3].document.location.href="../../eCommon/jsp/MstCodeError.jsp";
}


function callJSPs1(str,what)
{


var Standard_value=document.forms[0].standard_code.value;
var standard_desc=document.forms[0].standard_desc.value;
var tab11=document.getElementById("tab1");
var tabspan1=document.getElementById("tab1_tabspan");
var tab22=document.getElementById("tab2");
var tabspan2=document.getElementById("tab2_tabspan");

	
if(str=='tab2')
	{
//parent.frames[2].document.location.href="../../eCommon/html/blank.html";

document.forms[0].tab.value='Profile';
	//this.window.parent.parent.controlstructure
 document.getElementById('formtable1').style.display="none";
 document.getElementById(what).style.display="block";
		tab11.className='tabA';
		tabspan1.className='tabAspan';
		tab22.className='tabClicked';
		tabspan2.className='tabSpanclicked';

        var standard_code=parent.frames[1].document.forms[0].standard_code.value;
    
        parent.parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp'; 
}
}







function callJSPs(str,what)
{
	
var Standard_value=document.forms[0].standard_code.value;
var standard_desc=document.forms[0].standard_desc.value;
var tab11=document.getElementById("tab1");
var tabspan1=document.getElementById("tab1_tabspan");
var tab22=document.getElementById("tab2");
var tabspan2=document.getElementById("tab2_tabspan");

	
if(str=='tab2')
	{
//parent.frames[2].document.location.href="../../eCommon/html/blank.html";
if(Standard_value=="" || Standard_value==null )
	{
		alert(getMessage("XH1037","XH"));
				return false;
	}
if(standard_desc=="" || standard_desc==null )
{
	alert(getMessage("XH1038","XH"));
		return false;
}
document.forms[0].tab.value='Profile';
	//this.window.parent.parent.controlstructure
 document.getElementById('formtable1').style.display="none";

 document.getElementById(what).style.display="block";
  document.getElementById('formtable3').style.display="block";
		tab11.className='tabA';
		tabspan1.className='tabAspan';
		tab22.className='tabClicked';
		tabspan2.className='tabSpanclicked';
	    var mode1='U';
        var standard_code=parent.frames[1].document.forms[0].standard_code.value;
     this.parent.frames[2].document.location.href ="../../eCommon/html/blank.html";
       parent.frames[3].location.href ='../../eCommon/jsp/MstCodeError.jsp'; 
}



if(str=='tab1')
	{
	//parent.frames[2].document.location.href="../../eCommon/html/blank.html";

if(Standard_value=="" || Standard_value==null )
	{
		alert(getMessage("XH1037","XH"));
				return false;
	}
	if(standard_desc=="" || standard_desc==null )
{
		alert(getMessage("XH1038","XH"));
		return false;
}
	//this.window.parent.parent.frames[1].
//alert(document.forms[0].what.name);
	document.forms[0].tab.value='ControlStructure';
	// alert(document.getElementById(what));

document.getElementById('formtable2').style.display="none";
	 document.getElementById(what).style.display="block";

  document.getElementById('formtable3').style.display="none";

		tab11.className='tabClicked';
		tabspan1.className='tabSpanclicked';
		tab22.className='tabA';
		tabspan2.className='tabAspan';
		this.parent.frames[2].document.location.href ="../../eCommon/html/blank.html";
	//this.parent.frames[2].document.location.href = '../../eXH/jsp/InterfaceStandardControlStructure.jsp?standard_code='+Standard_value+'&mode=I';
	parent.frames[3].location.href ='../../eCommon/jsp/MstCodeError.jsp';
}

}

function refresh1(obj)
{


	obj.setAttribute("standard_desc",document.forms[0].standard_desc.value);
	obj.setAttribute("standard_type",document.forms[0].standard_type.value);
	obj.setAttribute("msg_start",document.forms[0].msg_start.value);
	obj.setAttribute("msg_end",document.forms[0].msg_end.value);
	obj.setAttribute("seg_start",document.forms[0].seg_start.value);
	obj.setAttribute("seg_end",document.forms[0].seg_end.value);
	obj.setAttribute("fld_separator",document.forms[0].fld_separator.value); 
	obj.setAttribute("elmnt_separator",document.forms[0].elmnt_separator.value );
    obj.setAttribute("standard_code",document.forms[0].standard_code.value);
    funModify1(obj);

}
function hide()
{

/*if(parent.f_query_add_mod.document.forms[0].rule.value=='NR')
	{
		parent.f_query_add_mod.location.href="../../eXH/jsp/InterfaceStandardsSelectMaster.jsp?mode=I";		
parent.f_query_add_mod_detail.location.href="../../eCommon/html/blank.html";		
parent.messageFrame.location.href="../../eCommon/html/blank.html";

	}*/

	//callJSPs('tab2','formtable2');



if(document.forms[0].act_mode.value=='U')
	{

	document.getElementById("tablist").style.display='block';
	}
	 if(document.forms[0].rule.value=='R')
	{
callJSPs('tab2','formtable2');
	}
}
