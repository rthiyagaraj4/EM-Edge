//********************************************************************************************
//FUNCTION CREATE
//********************************************************************************************
function create()
{
		//window.commontoolbarFrame.document.forms[0].apply.style.display='block';
		window.f_query_add_mod.location.href="../../eXH/jsp/OutboundTriggersSelectMaster.jsp?mode=I";		
		window.messageFrame.location.href="../../eCommon/html/blank.html";

}
//********************************************************************************************
//FUNCTION QUERY
//********************************************************************************************
function query()
{
		//window.commontoolbarFrame.document.forms[0].apply.style.display='none';
		window.f_query_add_mod.location.href="../../eXH/jsp/OutboundTriggersQueryCriteria.jsp";		
		window.messageFrame.location.href="../../eCommon/html/blank.html";

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
//	alert("Mode : "+frames[1].document.forms[0].act_mode.value);

	var mode = frames[1].document.forms[0].act_mode.value;

	var fields = new Array ( frames[1].document.forms[0].trig_name,
								frames[1].document.forms[0].trig_event,
								frames[1].document.forms[0].table_name,
								frames[1].document.forms[0].profile_id,
								frames[1].document.forms[0].trig_type,
								frames[1].document.forms[0].event_type_id,
								frames[1].document.forms[0].facility_id,
					frames[1].document.forms[0].insert_stat) ;

	var names = new Array ( getLabel("eXH.TriggerName.Label","XH"),
							getLabel("eXH.TriggerEvent.Label","XH"),
							getLabel("eXH.TriggeringTable.Label","XH"),
							getLabel("Common.Profile.label","Common"),				
							getLabel("eXH.TriggerType.Label","XH"),
							getLabel("Common.EventType.label","Common"),
							getLabel("Common.facility.label","Common"),
					getLabel("eXH.InsertingStatement.Label","XH") );
  
//	if(!f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	if(!f_query_add_mod.checkFields( fields, names, messageFrame))
	{
   
	}else
		{
//			alert("OutboundTriggers apply")
			window.f_query_add_mod.document.forms[0].submit();
			if(mode=='I'){
				window.f_query_add_mod.document.forms[0].reset();
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
	}
}

//********************************************************************************************
//function funSubmit
//*******************************************************************************************
function funSubmit()
{
	var act = "";
	if(document.forms[0].name=='OUTBOUND_TRIGGERS'){
		act = '../../eXH/jsp/OutboundTriggersQueryResult.jsp';
	}
	else if(document.forms[0].name=='OutboundTriggerResult'){
		act = '../../eXH/jsp/OutboundTriggerInsertQueryResult.jsp';
	}
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
	var fac_idVal = "";
	var facility_id   = unescape(obj.getAttribute('facility_id'));
	var trig_cond   = unescape(obj.getAttribute('trig_cond'));
	for(var i=0;i<trig_cond.length;i++){
		trig_cond	=	trig_cond.replace('+'," ");
	}
	var newfac_id = facility_id.split('.');
	if(newfac_id[0]==':NEW'){
		this.document.forms[0].facility_type.value='N';
	}

	this.document.forms[0].trig_name.value = obj.getAttribute('trig_name');
	this.document.forms[0].trig_event.value = obj.getAttribute('trig_event');
	this.document.forms[0].table_name.value = obj.getAttribute('table_name');
	this.document.forms[0].trig_type.value = obj.getAttribute('trig_type');
	this.document.forms[0].trig_cond.value = trig_cond;
	this.document.forms[0].event_type_id.value = obj.getAttribute('event_type_id');
	this.document.forms[0].event_type.value = obj.getAttribute('event_type');
	this.document.forms[0].facility_id.value = facility_id;
	this.document.forms[0].facility_name.value = obj.getAttribute('facility_name');
	this.document.forms[0].insert_stat.value = obj.getAttribute('insert_stat');
	this.document.forms[0].profile_id.value = obj.getAttribute('profile_id');
	this.document.forms[0].profile_desc.value = obj.getAttribute('profile_desc');	

//	this.document.forms[0].lang_id.value = obj.getAttribute('lang_id');
	var act = '../../eXH/jsp/OutboundTriggersSelectMaster.jsp';
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

//********************************************************************************************
//function funGenerate
//*******************************************************************************************

function funGenerate(){

//	alert("frmNam : "+document.forms[0].name);
	
 		var fields = new Array ( document.forms[0].trig_name,
								document.forms[0].trig_event,
								document.forms[0].table_name,
								document.forms[0].profile_id,
								document.forms[0].trig_type,
								document.forms[0].event_type_id,
								document.forms[0].facility_id,
					      document.forms[0].insert_stat) ;

		var names = new Array ( getLabel("eXH.TriggerName.Label","XH"),
							getLabel("eXH.TriggerEvent.Label","XH"),
							getLabel("eXH.TriggeringTable.Label","XH"),
							getLabel("Common.Profile.label","Common"),
							getLabel("eXH.TriggerType.Label","XH"),
							getLabel("eXH.EventType.Label","XH"),
							getLabel("eXH.FacilityId.Label","XH"),
					getLabel("eXH.InsertingStatement.Label","XH") );

	var f_query_add_mod  = parent.frames[1];
    var messageFrame	 = parent.frames[2];
 	
//	if(!f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	if(!f_query_add_mod.checkFields( fields, names, messageFrame))
	{
   
	}
	else{
		document.forms[0].gen_flag.value='G'; 
		document.forms[0].submit();
	}

}

//********************************************************************************************
//function searchTables
//*******************************************************************************************

function searchTables(){

            var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit="Tables" ;
            var target=this.document.forms[0].table_name;
            var tabl_id=this.document.forms[0].table_id;

			sql="SELECT object_id code,object_name description FROM ALL_OBJECTS "+
                    "   WHERE UPPER(object_id) LIKE UPPER(?) AND "+ 
                    "         UPPER(object_name) LIKE UPPER(?) AND "+
                    "         OBJECT_TYPE='TABLE' AND OWNER='IBAEHIS' ORDER BY 1 ";

//				SELECT OBJECT_NAME FROM ALL_OBJECTS WHERE OBJECT_TYPE='TABLE' AND OWNER='IBAEHIS'
//				AND OBJECT_NAME LIKE '__\_%' ESCAPE '\';

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
                tabl_id.value=arr[0];
				var fac_name = document.forms[0].facility_name.value;
				var newfac_name = fac_name.split('.');
				if(newfac_name[0]==':NEW'){
					document.forms[0].facility_type.value = "";
					document.forms[0].facility_id.value = "";
					document.forms[0].facility_name.value = "";
				}
            }
            else{
                target.value=tdesc;
                tabl_id.value=tcode;
            }
}// End of searchTables

//********************************************************************************************
//function searchFacility
//*******************************************************************************************

function searchFacility(){

            var tdesc="";
            var tcode="";

			var facility_type = this.document.forms[0].facility_type.value;
//			alert("fac_type : "+facility_type);
            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit="Facility" ;
            var target=this.document.forms[0].facility_name;
            var faclty_id=this.document.forms[0].facility_id;
			var tab_name = this.document.forms[0].table_name.value;
//			alert("tab_name : "+tab_name);
			if(facility_type=='S'){

				sql="SELECT facility_id code,facility_name description FROM sm_facility_param WHERE UPPER(facility_id) LIKE UPPER(?) AND       UPPER(facility_name) LIKE UPPER(?)                                ORDER BY 1 "; 
			}
			else if(facility_type=='N'){
	
				sql="select distinct ':NEW.'||column_name code,':NEW.'||column_name description from all_tab_columns WHERE UPPER(table_name) LIKE UPPER('"+tab_name+"') AND UPPER(column_name) LIKE UPPER(?) AND UPPER(column_name) LIKE UPPER(?) ORDER BY 1 ";
			}

			if(faclty_id.value!=""){
				dataNameArray[0]	= "FACILITY_ID" ;
				dataValueArray[0]	= faclty_id.value;
				dataTypeArray[0]	= STRING ;
			}
			argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
	        argumentArray[4] = "1,2";
//		    argumentArray[4] = "2,1";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                faclty_id.value=arr[0];
            }
            else{
                target.value=tdesc;
                faclty_id.value=tcode;
            }
}// End of searchFacility


//********************************************************************************************
//function searchEventType
//*******************************************************************************************

function searchEventType(){
     
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit="Event Type" ;
            var target=this.document.forms[0].event_type;
            var event_id=this.document.forms[0].event_type_id;

			sql="SELECT distinct EVENT_TYPE code,EVENT_NAME description FROM XH_EVENT_TYPE_LANG_VW "+
                    "   WHERE UPPER(EVENT_TYPE) LIKE UPPER(?) AND "+ 
                    "           UPPER(EVENT_NAME) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";

			if(event_id.value!=""){
				dataNameArray[0]	= "EVENT_TYPE" ;
				dataValueArray[0]	= event_id.value;
				dataTypeArray[0]	= STRING ;
			}
            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
	        argumentArray[4] = "1,2";
//	        argumentArray[4] = "2,1";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                event_id.value=arr[0];
            }
            else{
                target.value=tdesc;
                event_id.value=tcode;
            }
}// End of searchEventType

//********************************************************************************************
//function searchProfile
//*******************************************************************************************

function searchProfile(){
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit="Profile" ;
            var target=this.document.forms[0].profile_desc;
            var profile_id=this.document.forms[0].profile_id;

            sql="SELECT profile_id code,short_desc description FROM XH_STANDARD_PROFILE "+
                    "   WHERE UPPER(profile_id) LIKE UPPER(?) AND "+ 
                    "           UPPER(short_desc) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";

			if(profile_id.value!=""){
				dataNameArray[0]	= "profile_id" ;
				dataValueArray[0]	= profile_id.value;
				dataTypeArray[0]	= STRING ;
			}
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
                profile_id.value=arr[0];
            }
            else{
                target.value=tdesc;
                profile_id.value=tcode;
            }
}// End of searchProfile


//********************************************************************************************
//function searchTrigSeq
//*******************************************************************************************

function searchTrigSeq(){
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
			// eXH.Message/QryID.Label
            var tit="Message / Query Identifier" ;
            var target=this.document.forms[0].trig_seq;
            var trig_id=this.document.forms[0].trig_id;
		
            sql="SELECT sequence_name code,sequence_name description from all_sequences WHERE sequence_owner = 'IBAEHIS'  AND UPPER(sequence_name) LIKE UPPER(?) AND  UPPER(sequence_name) LIKE UPPER(?)   ORDER BY 1 ";

			dataNameArray[0]	= "trig_id" ;
			dataValueArray[0]	= 'XH';
			dataTypeArray[0]	= STRING ;

            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
	        argumentArray[4] = "1,2";
//	        argumentArray[4] = "2,1";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                trig_id.value=arr[0];
            }
            else{
                target.value=tdesc;
                trig_id.value=tcode;
            }
}// End of searchTrigSeq

//*******************************************************************************************
//function showQueryInfo
//*******************************************************************************************
async function showQueryInfo(obj)
{
	var fields = new Array ( 
								document.forms[0].table_name,
								document.forms[0].trig_seq,
								document.forms[0].event_type_id,
								document.forms[0].facility_id) ;

	var names = new Array ( 
							getLabel("eXH.TriggeringTable.Label","XH"),
							getLabel("eXH.Message/QryID.Label","XH"),
							getLabel("Common.EventType.label","Common"),
							getLabel("Common.facility.label","Common")
			);
  
	if(!parent.frames[1].checkFields( fields, names, parent.frames[2]))
	{
   
	}else{

		var trig_tblname = document.forms[0].table_name.value; 
		var trig_seq = document.forms[0].trig_seq.value; 
		var facility_id = document.forms[0].facility_id.value; 
		var facility_name = document.forms[0].facility_name.value; 
		var trig_event = document.forms[0].trig_event.value; 
		var event_type_id = document.forms[0].event_type_id.value; 
		var event_type = document.forms[0].event_type.value; 		
		var insert_stat = document.forms[0].insert_stat.value; 
//		alert("insert_stat : "+insert_stat);
        var domain_name = insert_stat.substr(12,2);
//		alert("domain_name : "+domain_name);
		var insert_tbl_name = insert_stat.substr(12,8);
//		alert("substr - tblName : "+insert_tbl_name);
		if(insert_tbl_name=='XH_EVENT'){
				insert_tbl_name = 'O';
		}
		else{
			insert_tbl_name = insert_stat.substr(12,20);
	//		alert("substr - tblName : "+insert_tbl_name);
			if(insert_tbl_name=='XH_APPLICATION_QUERY'){
				insert_tbl_name = 'Q';
			}
		}

//        var evntColVals = buildInsertParams(insert_stat);


        var params = "trig_tblname="+trig_tblname+"&trig_seq="+trig_seq+"&facility_id="+facility_id+"&facility_name="+facility_name+"&event_type_id="+event_type_id+"&event_type="+event_type+"&insert_tbl_name="+insert_tbl_name+"&domain_name="+domain_name+"&insert_stat="+escape(insert_stat);
//		alert("trig_tblname : "+trig_tblname);
//		if(trig_tblname!=''){
//			if(trig_seq!=""){
			var url     = "../../eXH/jsp/OutboundTriggerInsertQueryMain.jsp?"+params;
//        var url     = "../../eXH/jsp/OutboundTriggersInsertQueryInfo.jsp?qryType="+qryType;
			var dialogTop   = "65";
			var dialogHeight= "50vh" ; //30.5
			var dialogWidth = "70vw" ;
			var arguments   = "" ;
			var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status: no" ;
			var returnval =await window.showModalDialog( url, arguments, features ) ;
//			alert("returnval : "+returnval);
			if( returnval == null || returnval == "" ){
			}
			else{
				document.forms[0].insert_stat.value = returnval;
//				document.forms[0].insert_stat.value = (returnval.split("!"))[1];
			}
	/*		}
			else{
					alert("Trigger Sequence is not selected");
			}
		}
		else{
			alert("Trigger Table is not selected");
		}
		*/
	}
}

//*******************************************************************************************
//function buildInsertParams
//*******************************************************************************************
function buildInsertParams(insert_stat,insrt_tblName) {
	var indx1 = insert_stat.indexOf('(');
//		alert("indx1 : "+indx1);
	var indx2 = insert_stat.indexOf(')');
//		alert("indx2 : "+indx2);
//	alert("arr1 : "+insert_stat.substr(indx1+1,indx2-1));
//	alert("arr2 : "+insert_stat.substr(indx2+1,insert_stat.length-2))
	var arr2 = insert_stat.substr(indx2+1,insert_stat.length-2);
		var indx3 = insert_stat.indexOf('(');
//		var indx4 = insert_stat.indexOf(')');
//	alert("arr2Params : "+arr2.substr(indx3,insert_stat.length-2));
		var evntColVals = arr2.substr(indx3,insert_stat.length-2);
        evntColValsArr = evntColVals.split(',');
//		alert("evntColValsArr : "+evntColValsArr);
//		return evntColValsArr;
		var patient_id = "";
		var merged_patient_id ="";
		var episode_type ="";
		var  episode_id ="";
		var  visit_id = "";
		var  acc_no = "";

		patient_id = trimString(evntColValsArr[4]);
//			alert("patient_id1 : "+patient_id);
		patient_id = patient_id.substr(1,patient_id.length-2)
//			alert("patient_id2 : "+patient_id);
		merged_patient_id = evntColValsArr[6];
/*
		for(var i=0;i<=evntColValsArr;i++){
				switch(i){
				/*		Default Values List cannot be modified by the User 
				application_id,
				message_id,
				facility_id,
				message_date,
				event_type,
				*/ /*
					case 5 : patient_id = evntColValsArr[5];
								break;
					case 6 : merged_patient_id = evntColValsArr[6];
								break;
					case 7 : episode_type = evntColValsArr[7];
								break;
					case 8 : episode_id = evntColValsArr[8];
								break;
					case 9 : visit_id = evntColValsArr[9];
								break;
					case 10 : acc_no = evntColValsArr[10];
								break;
					default: break;
	
				action_type,
					LAST_PROC_DATE
						event_status,
				EXT_ACCESSION_NUM,
				added_by_id,		
				added_date,
				modified_by_id,
				modified_date,
				added_at_ws_no,
				modified_at_ws_no,
				added_facility_id,
				modified_facility_id

			}
		}
		*/
			var evntParams = "&patient_id="+patient_id+"&merged_patient_id="+merged_patient_id+"&episode_type="+episode_type+"&episode_id="+episode_id+"&visit_id="+visit_id+"&acc_no="+acc_no;

			return evntParams;
		}


//*******************************************************************************************
//function clrFlds
//*******************************************************************************************
function clrFlds(obj) {
    parent.f_query_add_mod_detail.document.location.href='../../eCommon/html/blank.html';
	if(obj.value=='Q'){
		document.forms[0].obevents.checked = false;
	}
	else if(obj.value='O'){
		document.forms[0].query.checked = false;
	}
		document.forms[0].module_name.value = "";
//    clearTables();
}


//*******************************************************************************************
//function setValues
//*******************************************************************************************
/*function setValues1(obj) {

			var mdl_name = obj.value;
			var tbl_name = "";
			if(document.forms[0].query.checked){
	//			tblQuery = "select object_name from all_objects where object_type='TABLE' and object_name like ?" ;
				tbl_name = mdl_name+"_APPLICATION_QUERY";
			}
			else if(document.forms[0].obevents.checked){
	//			tblQuery = "select object_name from all_objects where object_type='TABLE' and object_name like ?" ;
				tbl_name = mdl_name+"_EVENT";
			}
//		alert("tbl_name : "+tbl_name);
//		alert("frm : "+parent.frames[1].name);
//		var trg_tbl = document.forms[0].trg_tbl.value;
		var trig_tblname = document.forms[0].trg_tbl.value; 
		var trig_seq = document.forms[0].trig_seq.value; 
		var facility_id = document.forms[0].facility_id.value; 
		var facility_name = document.forms[0].facility_name.value; 
		var event_type_id = document.forms[0].event_type_id.value; 
		var event_type = document.forms[0].event_type.value; 	
//		var evntColVals = document.forms[0].evntColVals.value; 	
		var insert_tbl_name = document.forms[0].insert_tbl_name.value; 	
		var insert_stat = unescape(document.forms[0].insert_stat.value); 		
		insert_stat = insert_stat.replace('+'," ");
//		alert("insert_stat : "+insert_stat);

        var params = "trig_tblname="+trig_tblname+"&trig_seq="+trig_seq+"&facility_id="+facility_id+"&facility_name="+facility_name+"&tbl_name="+tbl_name+"&event_type_id="+event_type_id+"&event_type="+event_type+"&insert_tbl_name="+insert_tbl_name+"&insert_stat="+escape(insert_stat);

		parent.f_query_add_mod_detail.location.href="../../eXH/jsp/OutboundTriggerInsertQuerySearch.jsp?"+params;				

}
*/

//********************************************************************************************
//function clearTables
//*******************************************************************************************
function clearTables()	{ 
	var list_obj	=document.forms[0].table_name;
	var len =list_obj.options.length;
	for(var i=0;i<len;i++) {
		list_obj.remove("table_name") ;
	}

	var tp = "---------Select--------" ;
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = "" ;
	list_obj.add(opt);
}

//********************************************************************************************
//function addTable
//*******************************************************************************************
function addTable(code,desc)	{ 
	var element = document.createElement('OPTION') ;
	element.value		=  code ;
	element.text		= desc ;
	document.forms[0].table_name.add(element); 
//	alert("frame : "+parent.frames[1].name);
//    alert(desc);
	parent.f_query_add_mod_detail.location.href="../../eXH/jsp/OutboundTriggerInsertQueryResult.jsp?tbl_name="+desc;		
}

//********************************************************************************************
//function searchDataFieldRef
//*******************************************************************************************

function searchDataFieldRef(col_name){
            alert("searchDataFieldRef col_name : "+col_name);
            var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit="DataFieldRef" ;

//			alert("Trig tblName : "+document.forms[0].trg_tbl.value);
			var target=document.getElementById(col_name+'_datafield_ref');
			var datafield_col=document.getElementById(col_name+'_datafield_col');
			var trig_tblname = document.forms[0].trg_tbl.value;
			alert("trig_tblname : "+trig_tblname);
//			alert("tab_name : "+tab_name);

			sql="select column_name code,':NEW.'||column_name description from all_tab_columns WHERE OWNER='IBAEHIS' AND UPPER(table_name) LIKE UPPER('"+trig_tblname+"') AND UPPER(column_name) LIKE UPPER(?) AND UPPER(column_name) LIKE UPPER(?)  ";

            alert("sql : "+sql);
/*	
			dataNameArray[0]	= "DATA_FIELD" ;
			dataValueArray[0]	= this.document.forms[0].facility_id.value;
			dataTypeArray[0]	= STRING ;
*/
			argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
	        argumentArray[4] = "1,2";
//		    argumentArray[4] = "2,1";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
			alert("retVal : "+retVal);
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                datafield_col.value=arr[0];
				document.getElementById(col_name+'_default_val').disabled = true;
            }
            else{
                target.value=tdesc;
                datafield_col.value=tcode;
            }
}// End of searchDataFieldRef

//********************************************************************************************
//function getInsertQuery
//*******************************************************************************************

function getInsertQuery(colVals){
//			colVals.replace('[','');
//			colVals.replace(']','');
			colVals = colVals.substr(1,colVals.length-2);
//			alert(colVals);
	        var arrCol = colVals;
	        var tbl_name = document.forms[0].tbl_name.value;
			var qryResult = "INSERT INTO "+tbl_name;
			arr=arrCol.split(",");
			var totcols = "";
			var totColVals = "";
//			alert(arr.length);
//			alert(arr[8]);
//			alert("ColVal ProcID: "+document.getElementById(trimString(arr[8])+'_datafield_ref').value);
			for(i=0;i<arr.length;i++){
//				alert("Col : "+arr[i]);
//				alert(arr[i],document.getElementById(arr[i]+'_datafield_ref').value);
				if(i==arr.length-1){
					totcols = totcols+arr[i];
					if(document.getElementById(trimString(arr[i])+'_default_val').value!=''){
						if(document.getElementById(trimString(arr[i])+'_default_val').value=='sysdate'){
	//						alert("sysdate");
							totColVals = totColVals+document.getElementById(trimString(arr[i])+'_default_val').value;
						}
						else{
							totColVals = totColVals+"'"+document.getElementById(trimString(arr[i])+'_default_val').value+"'";
						}
					}
					else if(document.getElementById(trimString(arr[i])+'_datafield_ref').value!=''){
						totColVals = totColVals+document.getElementById(trimString(arr[i])+'_datafield_ref').value;
					}
					else{
						totColVals = totColVals+"''";
					}
				}
				else{
					totcols = totcols+arr[i]+",";
					if(document.getElementById(trimString(arr[i])+'_default_val').value!=''){
						if(document.getElementById(trimString(arr[i])+'_default_val').value=='sysdate'){
							totColVals = totColVals+document.getElementById(trimString(arr[i])+'_default_val').value+",";
						}
						else{
							totColVals = totColVals+"'"+document.getElementById(trimString(arr[i])+'_default_val').value+"',";
						}
					}
					else if(document.getElementById(trimString(arr[i])+'_datafield_ref').value!=''){
						totColVals = totColVals+document.getElementById(trimString(arr[i])+'_datafield_ref').value+",";
					}
					else{
						totColVals = totColVals+"'',";
					}
				}
//				alert("ColVal : "+document.getElementById(arr[i]+'_datafield_ref').value);
			}
			qryResult = qryResult+"("+totcols+") \nVALUES("+totColVals+")";
//			alert("Insert Qry : "+qryResult);
//		alert(document.getElementById("Process_ID"+'_datafield_ref').value);
            window.returnValue = qryResult;
			window.close();
}
