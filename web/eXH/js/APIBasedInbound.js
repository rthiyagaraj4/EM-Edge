//********************************************************************************************
//FUNCTION CREATE
//********************************************************************************************
function create()
{
	window.f_query_add_mod.location.href="../../eXH/jsp/APIbasedInboundSelectMaster.jsp?mode=I";		
	window.f_query_add_mod_detail.location.href="../../eCommon/html/blank.html";
	window.messageFrame.location.href="../../eCommon/html/blank.html";

}
//********************************************************************************************
//FUNCTION QUERY
//********************************************************************************************
function query()
{
	APIBasedframeset.rows='30,290,90,30';
	window.f_query_add_mod.location.href="../../eXH/jsp/APIbasedInboundQueryCriteria.jsp";		
	window.f_query_add_mod_detail.location.href="../../eCommon/html/blank.html";
	window.messageFrame.location.href="../../eCommon/html/blank.html";

}
//********************************************************************************************
//FUNCTION DELETE
//********************************************************************************************
function deleterecord()
{
			if(frames[2].document.APIBasedSearchResult){
//				alert("APIBasedSearchResult");
			}

			else if(frames[2].document.QueryBasedInbAddMod){
				window.f_query_add_mod_detail.document.forms[0].act_mode.value = 'D';
				apply();
			}

			else if((frames[2].document.TableBasedInbAddMod)){
				window.f_query_add_mod_detail.document.forms[0].act_mode.value = 'D';
				apply();
			}

			else if((frames[1].document.APIbased_Inb_Select)){
				window.f_query_add_mod.document.forms[0].act_mode.value = 'D';
				apply();
			}
//			else{
				window.commontoolbarFrame.document.location.reload();
//			}	
}
//********************************************************************************************
//FUNCTION GENERATE()
//********************************************************************************************
function funGenerate(){
		exec_nature= parent.frames[1].document.forms[0].exec_nature.value;
		var gen_flag='G';
		parent.frames[1].document.forms[0].action = '../../servlet/eXH.QuerybasedInboundAddModifyServlet?exec_nature='+exec_nature+'&gen_flag='+gen_flag;
		parent.frames[1].document.forms[0].submit();
}
//********************************************************************************************
//FUNCTION APPLY()
//********************************************************************************************
function apply()
{
			var mode = frames[1].document.forms[0].act_mode.value;
	//		eval("document.forms[0].element_val_"+srl_no).disabled = false;
	//		document.getElementById(srl_no+'_element_pos').disabled = false;

			var application_id  = frames[1].document.forms[0].application_id.value;
			var facility_id   = frames[1].document.forms[0].facility_id.value;
			var event_type_id  = frames[1].document.forms[0].event_type_id.value;
			var segment_type_id = frames[1].document.forms[0].segment_type_id.value;
			var inboundapi_id  = frames[1].document.forms[0].inboundapi_id.value;
			var profile_id  = frames[1].document.forms[0].profile_id.value;
			var param    = "application_id="+application_id+"&facility_id="+facility_id+"&event_type_id="+
							event_type_id+"&segment_type_id="+segment_type_id+"&inboundapi_id="+inboundapi_id+"&profile_id="+profile_id;

			var f_query_add_mod = window.frames[1];
			var messageFrame = window.frames[3];

			if(frames[2].document.APIBasedSearchResult){
//					alert("APIBasedSearchResult");
//					alert("APIBasedSearchResult frmSrl_no : "+frames[2].document.forms[0].frmSrl_no.value);
					window.frames[2].document.forms[0].target = 	'messageFrame';
					window.frames[2].document.forms[0].action = '../../servlet/eXH.APIbasedInboundAddModifyServlet?'+param+'&act_mode=U';
					window.frames[2].document.forms[0].submit();
			}

			else if(frames[2].document.QueryBasedInbAddMod)
			{
/*
						var fields = new Array (  
							frames[2].document.forms[0].stnd_code);
	
						var names = new Array ( 
							getLabel("Common.Standard.label","Common"));

						if(!f_query_add_mod.checkFields( fields, names, messageFrame))			
						{
   
						}

						else{
							*/
							window.frames[2].document.forms[0].action = '../../servlet/eXH.QuerybasedInboundAddModifyServlet?'+param;
							window.frames[2].document.forms[0].submit();
	//					}
			}

			else if(frames[2].document.TableBasedInbAddMod){
						
						var fields = new Array (  
							frames[2].document.forms[0].module_name,
							frames[2].document.forms[0].table_name);
	
						var names = new Array ( 
							getLabel("eXH.InterfaceDomain.Label","XH"),
							getLabel("Common.Table.label","Common"));

						if(!f_query_add_mod.checkFields( fields, names, messageFrame))			
						{
   
						}

						else{

							window.frames[2].document.forms[0].action = '../../servlet/eXH.QuerybasedInboundAddModifyServlet?'+param;
							window.frames[2].document.forms[0].submit();
						}
			}

			else if((frames[1].document.APIbased_Inb_Select)){

					if(mode=='D'){
						window.frames[1].document.forms[0].action = '../../servlet/eXH.QueryBasedHeaderServlet';
						window.frames[1].document.forms[0].submit();
					}

					else{

					var fields = new Array (  
					      frames[1].document.forms[0].application_name,
						  frames[1].document.forms[0].facility_name,
						  frames[1].document.forms[0].event_type,
						  frames[1].document.forms[0].segment_type,
						  frames[1].document.forms[0].inboundapi_name,
						  frames[1].document.forms[0].profile_desc);
	
					var names = new Array ( 
						getLabel("Common.Application.label","Common"),
						getLabel("Common.facility.label","Common"),
						getLabel("Common.EventType.label","Common"),
						getLabel("eXH.SegmentType.Label","XH"),
						getLabel("eXH.InboundAPI.Label","XH"),
						getLabel("Common.Profile.label","Common"));

				if(!f_query_add_mod.checkFields( fields, names, messageFrame))			
				{
   
				}
				else{
					window.frames[1].document.forms[0].action = '../../servlet/eXH.QueryBasedHeaderServlet';
					window.frames[1].document.forms[0].submit();
					if(mode=='I'){
						window.f_query_add_mod.document.forms[0].reset();
						}
					}
				} // end if else
			} // APIbased_Inb_Select
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
//function funAdd
//*******************************************************************************************
function funAdd()
{
	parent.APIBasedframeset.rows='30,120,215,30';
	parent.frames[3].location.href="../../eCommon/html/blank.html";
	var exec_nature = parent.frames[1].document.forms[0].exec_nature.value;

	if(exec_nature=='A'){
		parent.f_query_add_mod_detail.location.href="../../eXH/jsp/APIbasedInboundAddModify.jsp?mode=I";	

	}
	else if(exec_nature=='Q'){
		parent.f_query_add_mod_detail.location.href="../../eXH/jsp/QuerybasedInboundAddModify.jsp?mode=I";
		
	}
	else if(exec_nature=='T'){
		parent.f_query_add_mod_detail.location.href="../../eXH/jsp/TablebasedInboundAddModify.jsp?mode=I";
	}

}

//********************************************************************************************
//function funSearch
//*******************************************************************************************
function funSearch()
{
	var exec_nature = parent.frames[1].document.forms[0].exec_nature.value;
//	parent.APIBasedframeset.rows='30,130,200,30';
		parent.APIBasedframeset.rows='30,120,215,30';
		var application_id  = parent.frames[1].document.forms[0].application_id.value;
		var facility_id   = parent.frames[1].document.forms[0].facility_id.value;
		var event_type_id  = parent.frames[1].document.forms[0].event_type_id.value;
		var segment_type_id = parent.frames[1].document.forms[0].segment_type_id.value;
		var inboundapi_id  = parent.frames[1].document.forms[0].inboundapi_id.value;
	
		var param    = "appl_id="+application_id+"&fac_id="+facility_id+"&evnt_id="+
			event_type_id+"&sgmnt_id="+segment_type_id+"&inb_api="+inboundapi_id+"&exec_nature="+exec_nature+"&mode=I";

	if(exec_nature=='A'){
		parent.f_query_add_mod_detail.location.href="../../eXH/jsp/APIbasedInboundSearchResult.jsp?"+param;
		parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
//		parent.f_query_add_mod_detail.location.href="../../eXH/jsp/APIbasedInboundSearchDisplay.jsp?"+param;
	}
	else if(exec_nature=='Q'){
		parent.f_query_add_mod_detail.location.href="../../eXH/jsp/QuerybasedInboundSearchResult.jsp?"+param;
		parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
	}
	else if(exec_nature=='T'){
//		parent.f_query_add_mod.document.forms[0].generate_butt.disabled=false;
		parent.f_query_add_mod_detail.location.href="../../eXH/jsp/TablebasedInboundSearchResult.jsp?"+param;
		parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
	}
}

//********************************************************************************************
//function searchApplication
//*******************************************************************************************

function searchApplication(){
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit="Application" ;
            var target=this.document.forms[0].application_name;
            var appl_id=this.document.forms[0].application_id;

            sql="SELECT application_id code,application_name description FROM XH_APPLICATION "+
                    "   WHERE UPPER(application_id) LIKE UPPER(?) AND "+ 
                    "           UPPER(application_name) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";

			if(appl_id.value!=""){
				dataNameArray[0]	= "application_id" ;
				dataValueArray[0]	= appl_id.value;
				dataTypeArray[0]	= STRING ;
			}

            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
	        argumentArray[4] = "1,2";
//			argumentArray[4] = "2,1";
            argumentArray[5] = target.value;
//            argumentArray[6] = DESC_LINK  ;
//            argumentArray[7] = DESC_CODE ;
			argumentArray[6]   = CODE_LINK ;
			argumentArray[7]   = CODE_DESC ;
         
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

//********************************************************************************************
//function searchFacility
//*******************************************************************************************

function searchFacility(){

            var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit="Facility" ;
            var target=this.document.forms[0].facility_name;
            var faclty_id=this.document.forms[0].facility_id;

			sql="SELECT a.facility_id code,b.facility_name description FROM XP_PARAM_FOR_FACILITY a, "+
                    "  SM_FACILITY_PARAM_LANG_VW b WHERE a.facility_id=b.facility_id and UPPER(b.facility_id) LIKE UPPER(?) AND "+ 
                    "           UPPER(b.facility_name) LIKE UPPER(?) and b.language_id='en' "+
                    "           ORDER BY 1 ";

			if(faclty_id.value!=""){
				dataNameArray[0]	= "facility_id" ;
				dataValueArray[0]	= faclty_id.value;
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
            var appl_id=this.document.forms[0].application_id.value;

			sql="SELECT EVENT_TYPE code,EVENT_NAME description FROM XH_EVENT_TYPE "+
                    "   WHERE UPPER(EVENT_TYPE) LIKE UPPER(?) AND "+ 
                    "           UPPER(EVENT_NAME) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";

			if(event_id.value!=""){
				dataNameArray[0]	= "event_type_id" ;
				dataValueArray[0]	= event_id.value;
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
                event_id.value=arr[0];
            }
            else{
                target.value=tdesc;
                event_id.value=tcode;
            }
}// End of searchEventType

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

			sql="SELECT SEGMENT_TYPE code,SEGMENT_NAME description FROM XH_SEGMENT "+
                    "   WHERE UPPER(SEGMENT_TYPE) LIKE UPPER(?) AND "+ 
                    "           UPPER(SEGMENT_NAME) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";

			if(segment_id.value!=""){
				dataNameArray[0]	= "segment_type_id" ;
				dataValueArray[0]	= segment_id.value;
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
                segment_id.value=arr[0];
            }
            else{
                target.value=tdesc;
                segment_id.value=tcode;
            }
}// End of searchSegmentType


//********************************************************************************************
//function searchInboundAPI
//*******************************************************************************************

function searchInboundAPI(){

            var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit="Inbound API" ;
            var target=this.document.forms[0].inboundapi_name;
            var inbound_id=this.document.forms[0].inboundapi_id;

            sql="SELECT API_DESC description,API_CODE code FROM XH_API "+
                    "   WHERE UPPER(API_CODE) LIKE UPPER(?) AND "+ 
                    "           UPPER(API_DESC) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";

			if(inbound_id.value!=""){
				dataNameArray[0]	= "inboundapi_id" ;
				dataValueArray[0]	= inbound_id.value;
				dataTypeArray[0]	= STRING ;
			}
            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
            argumentArray[4] = "2,1";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                inbound_id.value=arr[0];
            }
            else{
                target.value=tdesc;
                inbound_id.value=tcode;
            }
}// End of searchInboundAPI

//********************************************************************************************
//function searchElement
//*******************************************************************************************

function searchElement(srl_no){
		//	alert("s_no : "+srl_no);

			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit="Element" ;

			var target=document.getElementById(srl_no+'_element_pos');
			var elmnt_id=document.getElementById(srl_no+'_element_id');

            sql="SELECT element_id code,element_name description FROM XH_ELEMENT_CROSSREF "+
                    "   WHERE UPPER(element_id) LIKE UPPER(?) AND "+ 
                    "           UPPER(element_name) LIKE UPPER(?) "+
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
	//		   alert("arr[0] : "+arr[0]);
               elmnt_id.value=arr[0];
  			   eval("document.forms[0].element_val_"+srl_no).disabled = true;
            }
            else{
                target.value=tdesc;
                elmnt_id.value=tcode;
            }
}// End of searchElement

//********************************************************************************************
//function searchStandard
//*******************************************************************************************

function searchStandard(){
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit="Standard" ;
            var target=this.document.forms[0].stnd_desc;
            var stnd_code=this.document.forms[0].stnd_code;

            sql="SELECT standard_code code,standard_desc description FROM XH_STANDARD "+
                    "   WHERE UPPER(standard_code) LIKE UPPER(?) AND "+ 
                    "           UPPER(standard_desc) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";

			if(stnd_code.value!=""){
				dataNameArray[0]	= "stnd_code" ;
				dataValueArray[0]	= stnd_code.value;
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
                stnd_code.value=arr[0];
            }
            else{
                target.value=tdesc;
                stnd_code.value=tcode;
            }
}// End of searchStandard

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
//function funSubmit
//*******************************************************************************************
function funSubmit()
{
	var act = "";
	if(document.forms[0].name=='APIBasedSearchResult'){
		act = '../../eXH/jsp/APIbasedInboundSearchResult.jsp';
	}
	else if(document.forms[0].name=='APIBasedHeaderResult'){
		act = '../../eXH/jsp/APIbasedInboundQueryResult.jsp';
	}
	this.document.forms[0].action = act;
	this.document.forms[0].submit();
}
//*******************************************************************************************
//function funModify
//*******************************************************************************************

function funModify(obj)
{
	if(this.document.forms[0].name=='APIBasedHeaderResult'){
		this.document.forms[0].application_id.value = obj.getAttribute('application_id');
		this.document.forms[0].facility_id.value = obj.getAttribute('facility_id');
		this.document.forms[0].event_type_id.value = obj.getAttribute('event_type_id');
		this.document.forms[0].segment_type_id.value = obj.getAttribute('segment_type_id');
		this.document.forms[0].inboundapi_id.value = obj.getAttribute('inboundapi_id');
		this.document.forms[0].profile_id.value = obj.getAttribute('profile_id');

		this.document.forms[0].application_name.value = obj.getAttribute('application_name');
		this.document.forms[0].facility_name.value = obj.getAttribute('facility_name');
		this.document.forms[0].event_type.value = obj.getAttribute('event_type');
		this.document.forms[0].segment_type.value = obj.getAttribute('segment_type');
		this.document.forms[0].inboundapi_name.value = obj.getAttribute('inboundapi_name');
		this.document.forms[0].profile_desc.value = obj.getAttribute('profile_desc');

		this.document.forms[0].exec_nature.value = obj.getAttribute('exec_nature');

		var act = '../../eXH/jsp/APIbasedInboundSelectMaster.jsp';
		this.document.forms[0].action = act;
		this.document.forms[0].submit();
	}

	else if(this.document.forms[0].name=='APIbased_Inb_SearchDisplay'){
//		alert("APIbased_Inb_SearchDisplay");
		this.document.forms[0].arg_serial_no.value = obj.getAttribute('arg_serial_no');
		this.document.forms[0].arg_id.value = obj.getAttribute('arg_id');
		this.document.forms[0].arg_name.value = obj.getAttribute('arg_name');
		this.document.forms[0].element_pos.value = obj.getAttribute('element_pos');
		this.document.forms[0].element_val.value = obj.getAttribute('element_val');

		var act = '../../eXH/jsp/APIbasedInboundAddModify.jsp';
		this.document.forms[0].action = act;
		this.document.forms[0].target = 'f_query_add_mod_detail';
		this.document.forms[0].submit();
	}

	else if(this.document.forms[0].name=='QryBasedDetailResult'){
		parent.f_query_add_mod.document.forms[0].generate_butt.disabled=false;
		var ins_qry = unescape(obj.getAttribute('insert_Query'))
		for(var i=0;i<ins_qry.length;i++){
			ins_qry	=	ins_qry.replace('+'," ");
		}

		var upd_qry = unescape(obj.getAttribute('update_Query'))
		for(var i=0;i<upd_qry.length;i++){
			upd_qry	=	upd_qry.replace('+'," ");
		}

		this.document.forms[0].srl_no.value = obj.getAttribute('srl_no');
		this.document.forms[0].insert_Query.value = ins_qry;
		this.document.forms[0].update_Query.value = upd_qry;
//		this.document.forms[0].stnd_code.value = obj.getAttribute('stnd_code');
//		this.document.forms[0].stnd_desc.value = obj.getAttribute('stnd_desc');
		this.document.forms[0].sub_api.value = obj.getAttribute('sub_api');
//		this.document.forms[0].profile_id.value = obj.getAttribute('profile_id');
//		this.document.forms[0].profile_desc.value = obj.getAttribute('profile_desc');			
		var act = '../../eXH/jsp/QuerybasedInboundAddModify.jsp';
		this.document.forms[0].action = act;
		this.document.forms[0].submit();
	}

	else if(this.document.forms[0].name=='TableBasedDetailResult'){
		parent.f_query_add_mod.document.forms[0].generate_butt.disabled=false;
		this.document.forms[0].srl_no.value = obj.getAttribute('srl_no');
		var tbl_name = obj.getAttribute('table_name');
//				alert("tbl_nam : "+obj.getAttribute('table_name'));
		var mod_name = tbl_name.split("_");
//	 		    alert("mod_name : "+mod_name[0]);

    	this.document.forms[0].table_name.value = obj.getAttribute('table_name');
		this.document.forms[0].modl_name.value = mod_name[0];
//		this.document.forms[0].stnd_code.value = obj.getAttribute('stnd_code');
//		this.document.forms[0].stnd_desc.value = obj.getAttribute('stnd_desc');
		this.document.forms[0].sub_api.value = obj.getAttribute('sub_api');

		var act = '../../eXH/jsp/TablebasedInboundAddModify.jsp';
		this.document.forms[0].action = act;
		this.document.forms[0].submit();
	}
}

//*******************************************************************************************
//function funAction
//*******************************************************************************************

function funAction(typ){
	document.forms[0].target = 	"";
	parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
	document.forms[0].action_type.value = typ;
	funSubmit();
}
//*******************************************************************************************
