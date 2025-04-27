//********************************************************************************************
//function funAdd
//*******************************************************************************************
function funAdd() 
{
//	alert("Prtcl FlStr funAdd");
//	parent.Protocolframeset.rows="35,260,210,30";
    parent.Protocolframeset.rows="35,300,140,30";	
	parent.f_query_add_mod_detail.location.href="../../eXH/jsp/CommProtocolIdControlStructure.jsp?mode=I";	
	parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
}

//********************************************************************************************
//function funSearch
//*******************************************************************************************
function funSearch()
{
//	alert("Prtcl FlStr funSearch");
//	parent.Protocolframeset.rows="35,260,210,30";
    parent.Protocolframeset.rows="35,300,140,30";	
	var prot_id  = parent.frames[1].document.forms[0].protocol_id.value ;
	if(prot_id!=""){
		parent.f_query_add_mod_detail.location.href="../../eXH/jsp/CommProtFileCtrlStructureSearchResult.jsp?prot_id="+prot_id;	
	}	
	parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
}


//********************************************************************************************
//function record()
//********************************************************************************************
function record(){
	var mode = document.forms[0].act_mode.value;
//	alert("mode :"+mode);
	var fields = new Array ( 
						  document.forms[0].file_ctrl_type,
						  document.forms[0].segment_type) ;
  
	var names = new Array ("File Control Type","Segment Type");
		
//	if(!parent.frames[2].checkFieldsofMst( fields, names, parent.frames[3]))
	if(!parent.frames[2].checkFields( fields, names, parent.frames[3]))
	{
   
	}
	else
	{
//		    alert("else");
			var protocol_id  = parent.frames[1].document.forms[0].protocol_id.value;
			document.forms[0].action = '../../servlet/eXH.CommProtocolIdFileCtrlStrAddModifyServlet?protocol_id='+protocol_id;
			document.forms[0].submit();		
			if(mode=='I' ) {
				document.forms[0].reset();
//				alert("formNm : "+document.forms[0].name);
			}
			else if ( mode=='D' ){
//				alert("Delete");			
				document.forms[0].segment_type_id.value = "";
				document.forms[0].segment_type.value = "";
				document.forms[0].file_ctrl_type.value = "";
//				document.forms[0].reload();
//				parent.f_query_add_mod_detail.location.href="../../eXH/jsp/CommProtFileCtrlStructureSearchResult.jsp?prot_id="+protocol_id;	
	       }
	}
	parent.frames[0].document.location.reload();
}

//********************************************************************************************
//function DELETE
//********************************************************************************************
function deleteRecord()
{
	document.forms[0].act_mode.value = 'D';
	record();
}

//********************************************************************************************
//function cancel
//*******************************************************************************************
function cancel()
{
	parent.f_query_add_mod_detail.location.href='../../eCommon/html/blank.html';
}

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
            var tit= "Segment Type";
            var target=this.document.forms[0].segment_type;
            var segment_id=this.document.forms[0].segment_type_id;

			sql="SELECT SEGMENT_TYPE code,SEGMENT_NAME description FROM XH_SEGMENT "+
                    "   WHERE UPPER(SEGMENT_TYPE) LIKE UPPER(?) AND "+ 
                    "           UPPER(SEGMENT_NAME) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";

			dataNameArray[0]	= "SEGMENT_ID" ;
			dataValueArray[0]	= this.document.forms[0].segment_type_id.value;
			dataTypeArray[0]	= STRING ;

            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
	        argumentArray[4] = "2,1";
//	        argumentArray[4] = "1,2";
            argumentArray[5] = target.value;
//			argumentArray[6] = CODE_LINK ;
//			argumentArray[7] = CODE_DESC ;

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
//function funSubmit
//*******************************************************************************************

function funSubmit()
{
	// #MOD#01

	var act = '../../eXH/jsp/CommProtFileCtrlStructureSearchResult.jsp';
    parent.f_query_add_mod_detail.document.forms[0].action = act;
	parent.f_query_add_mod_detail.document.forms[0].submit();

}
//*******************************************************************************************
//function funModify
//*******************************************************************************************

function funModify(obj)
{
	// #MOD#02
	//parent.commontoolbarFrame.document.forms[0].apply.style.display='block';

	parent.frames[1].document.forms[0].protocol_name.readOnly = true;
//	parent.frames[1].document.forms[0].datainput_api.readOnly = true;
//	parent.frames[1].document.forms[0].CommDataIOAPISearch.disabled = true;	
//	parent.frames[1].document.forms[0].statistics_api.readOnly = true;
//	parent.frames[1].document.forms[0].CommStatAPISearch.disabled = true;	
	parent.frames[1].document.forms[0].module_Id.readOnly = true;
	parent.frames[1].document.forms[0].module_Name.readOnly = true;
	parent.frames[1].document.forms[0].moduleNameSearch.disabled = true;	
	parent.frames[1].document.forms[0].solicitedYN.disabled = true;		
	parent.frames[1].document.forms[0].ack_type.disabled=true;
	parent.frames[1].document.forms[0].protocol_mode.disabled=true;	
	parent.frames[1].document.forms[0].file_dir.readOnly = true;
	parent.frames[1].document.forms[0].ack_dir.readOnly = true;
	parent.frames[1].document.forms[0].filenaming_api.readOnly = true;	
	parent.frames[1].document.forms[0].fileNamingSearch.disabled = true;	
	parent.frames[1].document.forms[0].file_type.disabled=true;	
	parent.frames[1].document.forms[0].file_intrvl.readOnly = true;
	parent.frames[1].document.forms[0].data_intrvl.readOnly = true;	
	parent.frames[1].document.forms[0].error_dir.readOnly = true;	
	
	this.document.forms[0].srlno.value = obj.getAttribute('srlno');
	this.document.forms[0].file_ctrl_type.value = obj.getAttribute('file_ctrl_type');
   	this.document.forms[0].segment_type_id.value = obj.getAttribute('segment_type_id');
   	this.document.forms[0].segment_type.value = obj.getAttribute('segment_type');

	var act = '../../eXH/jsp/CommProtocolIdControlStructure.jsp';

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
