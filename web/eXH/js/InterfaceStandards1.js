//********************************************************************************************
//FUNCTION CREATE
//********************************************************************************************
function create()
{
//window.commontoolbarFrame.document.forms[0].apply.style.display='block';
window.f_query_add_mod.location.href="../../eXH/jsp/InterfaceStandardsSelectMaster.jsp?mode=I";		
window.f_query_add_mod_detail.location.href="../../eXH/jsp/InterfaceStandardMainTab.jsp";		
window.messageFrame.location.href="../../eCommon/html/blank.html";

}
//********************************************************************************************
//FUNCTION QUERY
//********************************************************************************************
function query()
{
		//window.commontoolbarFrame.document.forms[0].apply.style.display='none';
		window.f_query_add_mod.location.href="../../eXH/jsp/InterfaceStandardsQueryCriteria.jsp";		
		window.messageFrame.location.href="../../eCommon/html/blank.html";

		window.f_query_add_mod_detail.location.href="../../eCommon/html/blank.html";
		//this.window.f_query_add_mod_detail.controlstructure.location.href="../../eCommon/html/blank.html";





}
//********************************************************************************************
//FUNCTION DELETE
//********************************************************************************************
function deleterecord()
{
//		alert("Delete");
		window.f_query_add_mod.document.forms[0].act_mode.value = 'D';
//		if (confirm(getMessage("DELETE_RECORD"))){
//			alert("Conf Del ");
			apply();
//		}
}
//********************************************************************************************
//FUNCTION APPLY()
//********************************************************************************************
function apply()
{

// frames[1].document.forms[0].dg_code,
//	alert("apply");
//var tab2=document.getElementById("Profile_struct");
var tab=this.window.f_query_add_mod_detail.controlstructure.document.forms[0].tab.value;
alert("tab"+tab);
if(tab=="Profile")
	{
var act="../../servlet/eXH.InterfaceStandaredProfileServlet?Profile_Id="+this.window.frames[2].frames[1].document.forms[0].Profile_Id.value+"&standard_code="+this.window.frames[2].frames[1].document.forms[0].standard_code.value;
//act="../../servlet/eXH.DataElementCrossRefSearchServlet?application_id="+application_id1+"&element_id="+element_id1;

this.window.frames[2].frames[1].document.forms[0].action=act;
this.window.frames[2].frames[1].document.forms[0].target='messageFrame';
this.window.frames[2].frames[1].document.forms[0].submit();

}
	else if(tab=="ControlStructure")
	{

	this.window.frames[2].frames[1].document.forms[0].submit();

	}
else
	{

	var fields = new Array (  
						  frames[1].document.forms[0].standard_code,
					      frames[1].document.forms[0].standard_desc,
					      frames[1].document.forms[0].standard_type,
						  frames[1].document.forms[0].msg_start,
					      frames[1].document.forms[0].msg_end,
						  frames[1].document.forms[0].seg_start,
						  frames[1].document.forms[0].seg_end,
						  frames[1].document.forms[0].fld_separator,
					      frames[1].document.forms[0].elmnt_separator);

// getLabel("eXH.Data.Label","XH"),

	var names = new Array ( 
						getLabel("eXH.Code.Label","XH"),
						getLabel("eXH.Description.Label","XH"),
						getLabel("eXH.StandardType.Label","XH"),
						getLabel("eXH.MsgStart.Label","XH"),
						getLabel("eXH.MsgEnd.Label","XH"),
						getLabel("eXH.SegStart.Label","XH"),
						getLabel("eXH.SegEnd.Label","XH"),
						getLabel("eXH.FldSeparator.Label","XH"),
						getLabel("eXH.ElmntSeparator.Label","XH"));
  
	if(!f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	{
   
	}else
		{  
//			alert("Mode : "+frames[1].document.forms[0].act_mode.value);
//          alert("dg_code : "+frames[1].document.forms[0].dg_code.value);
//			alert("protocol_link_id : "+frames[1].document.forms[0].protocol_link_id.value);



   		   
		}
 window.f_query_add_mod.document.forms[0].submit();


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

	}
}

//******************************************************************/
//function callJSPs
//******************************************************************/

function callJSPs(str)
{

var Standard_value=parent.frames[0].document.forms[0].standard_code.value;
	//document.forms[0].standard_code.value;
	


var tab11=document.getElementById("tab11");

	var tabspan1=document.getElementById("tab1_tabspan");
	var tab22=document.getElementById("tab12");
	var tabspan2=document.getElementById("tab2_tabspan");
if(str=='tab12')
	{
alert(str);
if(Standard_value=="" || Standard_value==null)
	{
		alert("Enter the Standard code");
	}
	//this.window.parent.parent.controlstructure

	else
		{
		document.forms[0].tab.value='Profile';

		tab11.className='tabA';
		tabspan1.className='tabAspan';
		tab22.className='tabClicked';
		tabspan2.className='tabSpanclicked';
	    var mode1='I';
        var standard_code=parent.frames[0].document.forms[0].standard_code.value;
		alert(standard_code);
        this.parent.frames[2].location.href ="../../eXH/jsp/InterfaceStandardProfileStructure.jsp?standard_code="+standard_code+"&mode="+mode1; 
        parent.parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp';
		}
}



if(str=='tab11')
	{
	
		//this.window.parent.parent.frames[1].
		document.forms[0].tab.value='ControlStructure';
		
		tab11.className='tabClicked';
		tabspan1.className='tabSpanclicked';
		tab22.className='tabA';
		tabspan2.className='tabAspan';
		alert("come1");

//alert(this.parent.frames[2].name);
	this.parent.frames[2].location.href = '../../eXH/jsp/InterfaceStandardControlStructure.jsp?mode=I';
	parent.parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp';
	
}

//var tab11=document.getElementById("tab1");
	//var tabspan1=document.getElementById("tab1_tabspan");
	




/*if(str=='tab2')
	{
		this.window.parent.parent.frames[1].document.forms[0].tab.value='table_values';
		tab11.className='tabA';
		tabspan1.className='tabAspan';
		tab22.className='tabClicked';
		tabspan2.className='tabSpanclicked';
		tab33.className='tabA';
		tabspan3.className='tabAspan';
        this.parent.frames[1].document.location.href='../../eXH/jsp/DataElementCrossRefModuleCodeSetupMain.jsp?application='+appl;
		parent.parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp';
	}
	if(str=='tab3')
	{
		this.window.parent.parent.frames[1].document.forms[0].tab.value='non_table_values';
		tab11.className='tabA';
		tabspan1.className='tabAspan';
		tab22.className='tabA';
		tabspan2.className='tabAspan';
		tab33.className='tabClicked';
		tabspan3.className='tabSpanclicked';
        this.parent.frames[1].document.location.href='../../eXH/jsp/DataElementCrossRefNonTableValuesSetupMain.jsp?application='+appl;
		parent.parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp';
	}*/


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
	parent.commontoolbarFrame.document.forms[0].apply.style.display='block';

	alert("fn mdfy standard_code : "+obj.getAttribute('standard_code'));
	this.document.forms[0].standard_code.value = obj.getAttribute('standard_code');
	this.document.forms[0].standard_desc.value = obj.getAttribute('standard_desc');
	this.document.forms[0].standard_type.value = obj.getAttribute('standard_type');
	this.document.forms[0].msg_start.value = obj.getAttribute('msg_start');
	this.document.forms[0].msg_end.value = obj.getAttribute('msg_end');
	this.document.forms[0].seg_start.value = obj.getAttribute('seg_start');
	this.document.forms[0].seg_end.value = obj.getAttribute('seg_end');
	this.document.forms[0].fld_separator.value = obj.getAttribute('fld_separator');
	this.document.forms[0].elmnt_separator.value = obj.getAttribute('elmnt_separator');
	
//	this.document.forms[0].lang_id.value = obj.getAttribute('lang_id');
	var act = '../../eXH/jsp/InterfaceQryMain.jsp';
	this.document.forms[0].action = act;
	this.document.forms[0].submit();
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

function searchSegmentType(){
     
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

function searchDefaultVal(){
     
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
 
function searchApplication(){
    
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit="Application" ;
            var target=this.document.forms[0].Application_Specific_txt;
            var appl_id=this.document.forms[0].application_id;

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
