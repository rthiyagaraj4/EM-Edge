//********************************************************************************************
//FUNCTION CREATE
//********************************************************************************************
/*
function create()
{
//window.commontoolbarFrame.document.forms[0].apply.style.display='block';
window.f_query_add_mod.location.href="../../eXH/jsp/QuerybasedInboundDetail.jsp?mode=I"+"&inb_typ=Q";
//window.f_query_add_mod.location.href="../../eXH/jsp/QuerybasedInboundSelectMaster.jsp?mode=I";		
window.f_query_add_mod_detail.location.href="../../eCommon/html/blank.html";
window.messageFrame.location.href="../../eCommon/html/blank.html";

}
//********************************************************************************************
//FUNCTION QUERY
//********************************************************************************************
function query()
{
		//window.commontoolbarFrame.document.forms[0].apply.style.display='none';
		window.f_query_add_mod.location.href="../../eXH/jsp/QuerybasedInboundQueryCriteria.jsp";		
		window.messageFrame.location.href="../../eCommon/html/blank.html";

}
*/
//********************************************************************************************
//function funNew
//*******************************************************************************************
function funNew()
{
//	document.forms[0].detail_flag.value = 'N';
	parent.f_query_add_mod.location.href="../../eXH/jsp/QuerybasedInboundSelectMaster.jsp?mode=I";	
	parent.f_query_add_mod_detail.location.href="../../eCommon/html/blank.html";	
	
}

//********************************************************************************************
//FUNCTION DELETE
//********************************************************************************************
/*
function deleterecord()
{
//		alert("Delete");
			if(frames[2].document.QueryBasedInbAddMod){ 
// 				alert("Query Add Modify");
//				alert("form nam : "+window.f_query_add_mod_detail.document.forms[0].name);
				window.f_query_add_mod_detail.document.forms[0].act_mode.value = 'D';
//				alert("APIbased_Inb_AddMod del");
				apply();
			}

			else if(frames[1].document.QuerybasedInboundDetail){
//				alert("Querybasedheaderform");
				window.f_query_add_mod.document.forms[0].act_mode.value = 'D';
//				alert("form nam : "+window.f_query_add_mod.document.forms[0].name);
				apply();
			}

}
//********************************************************************************************
//FUNCTION APPLY()
//********************************************************************************************
function apply()
{
	var mode = frames[1].document.forms[0].act_mode.value;

    if(frames[1].document.Querybasedheaderform){

//	alert("frm 65 : "+frames[1].document.forms[0].name);
//	alert("appl : "+ frames[1].document.forms[0].application_name.value);
			var fields = new Array (  
					      frames[1].document.forms[0].application_name,
						  frames[1].document.forms[0].facility_name,
						  frames[1].document.forms[0].event_type,
						  frames[1].document.forms[0].segment_type,
						  frames[1].document.forms[0].inboundapi_name);
	
			var names = new Array ( 
						getLabel("Common.Application.label","Common"),
						getLabel("eXH.Facility.Label","XH"),
						getLabel("eXH.EventType.Label","XH"),
						getLabel("eXH.SegmentType.Label","XH"),
						getLabel("eXH.InboundAPI.Label","XH"));

//		alert("frm name : "+frames[1].document.forms[0].name);
	/*
		if(!f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
		{
   
		}else{  
			*/
//				window.frames[1].document.forms[0].submit();
//		}
/*
   }
   

   else if((frames[1].document.QuerybasedInboundDetail)&&(frames[2].document.QueryBasedInbAddMod)){

//		alert("frmnam 95 : "+frames[1].document.forms[0].name);

		var application_id  = frames[1].document.forms[0].application_name.value;
		var facility_id   = frames[1].document.forms[0].facility_name.value;
		var event_type_id  = frames[1].document.forms[0].event_type.value;
		var segment_type_id = frames[1].document.forms[0].segment_type.value;
		var inboundapi_id  = frames[1].document.forms[0].inbound_api.value;
		var param    = "application_id="+application_id+"&facility_id="+facility_id+"&event_type_id="+
			event_type_id+"&segment_type_id="+segment_type_id+"&inboundapi_id="+inboundapi_id+"&mode=I";
//			alert("Mode : "+frames[2].document.forms[0].act_mode.value);
//			alert("update_Query : "+frames[2].document.forms[0].update_Query.value);
	
			var fields = new Array (  
						  frames[2].document.forms[0].executionOrder);				

			var names = new Array ( 
						getLabel("eXH.ExecOrder.Label","XH"));

	 	    var messageFrame = window.frames[3];
			if(!f_query_add_mod_detail.checkFieldsofMst( fields, names, messageFrame))
			{
   
			}
			else{
				window.frames[2].document.forms[0].action = '../../servlet/eXH.QuerybasedInboundAddModifyServlet?'+param;
				window.frames[2].document.forms[0].submit();
				if(mode=='I'){
					window.f_query_add_mod.document.forms[0].reset();
				}
			}
			window.frames[0].document.location.reload();

		} 

		else if(frames[1].document.QuerybasedInboundDetail){
			if(frames[1].document.QuerybasedInboundDetail.act_mode.value=='D'){
				window.frames[1].document.forms[0].action = '../../servlet/eXH.QueryBasedHeaderServlet';
				window.frames[1].document.forms[0].submit();
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
*/
//********************************************************************************************
//FUNCTION resetQryInfo 
//********************************************************************************************
function resetQryInfo(){
	document.forms[0].reset();
  	document.forms[0].where_cond.disabled = true;
 	document.forms[0].whr_text.disabled	  = true; 
 	document.forms[0].add.disabled		  = true;
 	document.forms[0].addWhrCls.disabled  = true;
 	document.forms[0].resetflag.value=0;
}

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

			dataNameArray[0]	= "stnd_code" ;
			dataValueArray[0]	= stnd_code.value;
			dataTypeArray[0]	= STRING ;

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

			dataNameArray[0]	= "profile_id" ;
			dataValueArray[0]	= profile_id.value;
			dataTypeArray[0]	= STRING ;

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
//function funAdd
//*******************************************************************************************
/*
function funAdd()
{
//	alert("funAdd API");
//	alert("Loc : "+parent.f_query_add_mod_detail.location);
/*
	var appl_id  = parent.frames[1].document.QuerybasedInboundDetail.application_name.value;
	var fac_id   = parent.frames[1].document.QuerybasedInboundDetail.facility_name.value;
	var evnt_id  = parent.frames[1].document.QuerybasedInboundDetail.event_type.value;
	var sgmnt_id = parent.frames[1].document.QuerybasedInboundDetail.segment_type.value;
	var inb_api  = parent.frames[1].document.QuerybasedInboundDetail.inbound_api.value;
	var param    = "appl_id="+appl_id+"&fac_id="+fac_id+"&evnt_id="+evnt_id+"&sgmnt_id="+
            sgmnt_id+"&inb_api="+inb_api+"&mode=I";

	var inb_typ  = parent.frames[1].document.QuerybasedInboundDetail.inb_type.value;	
	if(inb_typ=='A'){
//		alert("API Based Inb");
		parent.f_query_add_mod_detail.location.href="../../eXH/jsp/APIbasedInboundAddModify.jsp?"+param;	
	}
	else if(inb_typ=='Q'){
//		alert("Qry Based Inb");
		parent.f_query_add_mod_detail.location.href="../../eXH/jsp/QuerybasedInboundAddModify.jsp?"+param;		
	}

//	parent.f_query_add_mod_detail.location.href="../../eXH/jsp/QuerybasedInboundAddModify.jsp?mode=I";	
	
}

//********************************************************************************************
//function funSearch
//*******************************************************************************************
function funSearch()
{
//	alert("funSearch API");
//	alert("Loc : "+parent.f_query_add_mod_detail.location);
//	alert("inb_typ : "+parent.frames[1].document.QuerybasedInboundDetail.inb_type.value);

//	alert(parent.frames[1].document.QuerybasedInboundDetail.application_name.value);
	var appl_id  = parent.frames[1].document.QuerybasedInboundDetail.application_name.value;
	var fac_id   = parent.frames[1].document.QuerybasedInboundDetail.facility_name.value;
	var evnt_id  = parent.frames[1].document.QuerybasedInboundDetail.event_type.value;
	var sgmnt_id = parent.frames[1].document.QuerybasedInboundDetail.segment_type.value;
	var inb_api  = parent.frames[1].document.QuerybasedInboundDetail.inbound_api.value;
	var param    = "appl_id="+appl_id+"&fac_id="+fac_id+"&evnt_id="+evnt_id+"&sgmnt_id="+
            sgmnt_id+"&inb_api="+inb_api+"&mode=U";
//	alert("param : "+param);
    var inb_typ  = parent.frames[1].document.QuerybasedInboundDetail.inb_type.value;	
	if(inb_typ=='A'){
		parent.f_query_add_mod_detail.location.href="../../eXH/jsp/APIbasedInboundSearchResult.jsp?"+param;	
	}
	else if(inb_typ=='Q'){
		parent.f_query_add_mod_detail.location.href="../../eXH/jsp/QuerybasedInboundSearchResult.jsp?"+param;		
	}

}
*/
//********************************************************************************************
//function searchApplication
//*******************************************************************************************
/*
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
/*
            sql="SELECT application_name description,application_id code FROM XH_APPLICATION "+
                    "   WHERE UPPER(application_id) LIKE UPPER(?) AND "+ 
                    "           UPPER(application_name) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";
*/
   /*
			sql="SELECT application_id code,application_name description FROM XH_APPLICATION "+
                    "   WHERE UPPER(application_id) LIKE UPPER(?) AND "+ 
                    "           UPPER(application_name) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";

            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
//            argumentArray[4] = "2,1";
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
/*
            sql="SELECT b.facility_name description,a.facility_id code FROM XP_PARAM_FOR_FACILITY a, "+
                    "  SM_FACILITY_PARAM_LANG_VW b WHERE a.facility_id=b.facility_id and UPPER(b.facility_id) LIKE UPPER(?) AND "+ 
                    "           UPPER(b.facility_name) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";
*/
/*			sql="SELECT a.facility_id code,b.facility_name description FROM XP_PARAM_FOR_FACILITY a, "+
                    "  SM_FACILITY_PARAM_LANG_VW b WHERE a.facility_id=b.facility_id and UPPER(b.facility_id) LIKE UPPER(?) AND "+ 
                    "           UPPER(b.facility_name) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";

			argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
     //     argumentArray[4] = "2,1";
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
				return_val = argumentArray[0];
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
/*
            sql="SELECT EVENT_NAME description,EVENT_TYPE code FROM XH_EVENT_TYPE_LANG_VW "+
                    "   WHERE UPPER(EVENT_TYPE) LIKE UPPER(?) AND "+ 
                    "           UPPER(EVENT_NAME) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";
*/
/*			sql="SELECT distinct EVENT_TYPE code,EVENT_NAME description FROM XH_EVENT_TYPE_LANG_VW "+
                    "   WHERE UPPER(EVENT_TYPE) LIKE UPPER(?) AND "+ 
                    "           UPPER(EVENT_NAME) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";

            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
     //     argumentArray[4] = "2,1";
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
/*
            sql="SELECT API_DESC description,API_CODE code FROM XH_API "+
                    "   WHERE API_TYPE='I' AND UPPER(API_CODE) LIKE UPPER(?) AND "+ 
                    "           UPPER(API_DESC) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";
			*/
/*
          sql="SELECT API_CODE code,API_DESC description FROM XH_API "+
                    "   WHERE API_TYPE='I' AND UPPER(API_CODE) LIKE UPPER(?) AND "+ 
                    "           UPPER(API_DESC) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";

            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
//            argumentArray[4] = "2,1";
            argumentArray[4] = "1,2";
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
}// End of searchApplication

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
/*			sql="SELECT SEGMENT_TYPE code,SEGMENT_NAME description FROM XH_SEGMENT "+
                    "   WHERE UPPER(SEGMENT_TYPE) LIKE UPPER(?) AND "+ 
                    "           UPPER(SEGMENT_NAME) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";

            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
//            argumentArray[4] = "2,1";
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
*/
//********************************************************************************************
//function funSubmit
//*******************************************************************************************
/*
function funSubmit()
{
	
	// #MOD#01
	var act = '../../eXH/jsp/QuerybasedInboundQueryResult.jsp';
	this.document.forms[0].action = act;
	this.document.forms[0].submit();
}
//*******************************************************************************************
//function funModify
//*******************************************************************************************

function funModify(obj)
{
	var ins_qry = unescape(obj.getAttribute('insert_Query'))
	for(var i=0;i<ins_qry.length;i++){
		ins_qry	=	ins_qry.replace('+'," ");
	}

	var upd_qry = unescape(obj.getAttribute('update_Query'))
	for(var i=0;i<upd_qry.length;i++){
		upd_qry	=	upd_qry.replace('+'," ");
	}

//	alert("mode : "+obj.getAttribute('mode'));
//	alert("application_id : "+obj.getAttribute('application_id'));
	
//	alert("formname : "+frames[1].document.forms[0].name);
//	alert("formname : "+parent.frames[1].document.forms[0].name);
	var appl_id = obj.getAttribute('application_id');
	var applObj = parent.frames[1].document.forms[0].application_name;
	for( var j=0;j<applObj.options.length;j++)
	{
	   if(applObj.options[j].value ==appl_id)
       applObj.options[j].selected=true;
	}


	var fac_id = obj.getAttribute('facility_id');
	var applObj = parent.frames[1].document.forms[0].facility_name;
	for( var j=0;j<applObj.options.length;j++)
	{
	   if(applObj.options[j].value ==fac_id)
       applObj.options[j].selected=true;
	}

	var evnt_id = obj.getAttribute('event_type_id');
//	alert("evnt_id : "+evnt_id);
	var applObj = parent.frames[1].document.forms[0].event_type;
	for( var j=0;j<applObj.options.length;j++)
	{
	   if(applObj.options[j].value ==evnt_id)
       applObj.options[j].selected=true;
	}

	var sgmnt_id = obj.getAttribute('segment_type_id');
//	alert("sgmnt : "+sgmnt_id);
	var applObj = parent.frames[1].document.forms[0].segment_type;
	for( var j=0;j<applObj.options.length;j++)
	{
	   if(applObj.options[j].value ==sgmnt_id)
       applObj.options[j].selected=true;
	}
	
	var inb_id = obj.getAttribute('inboundapi_id');
	var applObj = parent.frames[1].document.forms[0].inbound_api;
	for( var j=0;j<applObj.options.length;j++)
	{
	   if(applObj.options[j].value ==inb_id)
       applObj.options[j].selected=true;
	}

	this.document.forms[0].executionOrder.value = obj.getAttribute('executionOrder');
	this.document.forms[0].insert_Query.value = ins_qry;
	this.document.forms[0].update_Query.value = upd_qry;

	var act = '../../eXH/jsp/QuerybasedInboundAddModify.jsp';
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
*/
//*******************************************************************************************
//function getHeaderValues
//*******************************************************************************************

function getHeaderValues() {
//		alert("getHeaderValues");
//		var bean_name	=	document.forms[0].strBeanName.value;
//		var param	=	obj.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
//		xmlStr += " bean_name=\""+bean_name+"\"";
//		xmlStr += " param=\""+param+"\"";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","QueryBasedInboundValidateQry.jsp?func_mode=getHeader",false);
		xmlHttp.send(xmlDoc);
//		alert(xmlHttp.responseText);
		eval(xmlHttp.responseText);	

}

//*******************************************************************************************
//function dispAllCols
//*******************************************************************************************
function dispAllCols(){
	if(document.forms[0].insert_type.value=='A'){
		var flag=0;
		var ColListVals = "";
		ColList	= document.forms[0].column_name.options;
		for(i=1;i<ColList.length;i++){
			if(flag==0){
				ColListVals	 = ColList[i].text;
				flag =	1;
			}
			else{
				ColListVals	=	ColListVals+", "+ColList[i].text;
			}
		}
		document.forms[0].selectedCols.value	= ColListVals;
		document.forms[0].column_name.value		= "";
		document.forms[0].col_val.value			= "";
		document.forms[0].selectedColVals.value = "";	
 	    document.forms[0].add.disabled			= true;
		flag1 = 0;
	}
	else{
		document.forms[0].selectedCols.value	= "";
		document.forms[0].column_name.value		= "";
		document.forms[0].col_val.value			= "";
		document.forms[0].selectedColVals.value = "";	
 	    document.forms[0].add.disabled			= true;
		flag1 = 0;
	}
}

//*******************************************************************************************
//function showQueryInfo
//*******************************************************************************************
async function showQueryInfo(obj)
{
//		alert("Obj : "+obj.name);
		var qryType = obj.name;
        var url     = "../../eXH/jsp/QueryBasedInsertUpdateQueryInfo.jsp?qryType="+qryType;
        var dialogTop   = "65";
        var dialogHeight= "50vh" ; //30.5
        var dialogWidth = "70vw" ;
        var arguments   = "" ;
        var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status: no" ;
        var returnval =await window.showModalDialog( url, arguments, features ) ;
		if( returnval == null || returnval == "" ){
		}
		else{
			var qryType = (returnval.split("!"))[0];
			if(qryType=='insertquery'){ 
				document.forms[0].insert_Query.value = (returnval.split("!"))[1];
			}			
			else if(qryType=='updatequery'){
				document.forms[0].update_Query.value = (returnval.split("!"))[1];
			}
		}
}

//*******************************************************************************************
//function setValues
//*******************************************************************************************
function setValues(obj) {

		if(document.forms[0].name=='queryInfo'){
			document.forms[0].whrcolumn_name.value	=	"";
			document.forms[0].where_cond.value	=	"";
			document.forms[0].whr_text.value	=	"";
			document.forms[0].whrClauseTxt.value=	"";
			document.forms[0].QueryResult.value	=	"";
			document.forms[0].qryError.value	=	"";
//			document.forms[0].insert_type.value=	"";
			document.forms[0].column_name.value	=	"";
			document.forms[0].col_val.value		=	"";
			document.forms[0].selectedCols.value	=	"";
			document.forms[0].selectedColVals.value	=	"";			
		 	document.forms[0].add.disabled		  = true;
		}

		var bean_name	=	document.forms[0].strBeanName.value;
		var param	=	obj.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " bean_name=\""+bean_name+"\"";
		xmlStr += " param=\""+param+"\"";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		if(obj.name=='module_name'){
			xmlHttp.open("POST","QueryBasedInboundValidateQry.jsp?func_mode=setTables",false);
		}
		else if(obj.name=='table_name'){
			xmlHttp.open("POST","QueryBasedInboundValidateQry.jsp?func_mode=setCols",false);
		}
		xmlHttp.send(xmlDoc);
//		alert(xmlHttp.responseText);
		eval(xmlHttp.responseText);	

}

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
}

//********************************************************************************************
//function clearCols
//*******************************************************************************************
function clearCols()	{ 
	var list_obj1	=document.forms[0].column_name;
	var list_obj2	=document.forms[0].whrcolumn_name;
	var len1 =list_obj1.options.length;
	var len2 =list_obj2.options.length;
	for(var i=0;i<len1;i++) {
		list_obj1.remove("column_name");
	}
	for(var j=0;j<len2;j++) {
		list_obj2.remove("whrcolumn_name") ;
	}

	var tp = "---------Select--------" ;
	var opt1 = document.createElement("OPTION") ;
	var opt2 = document.createElement("OPTION") ;
	opt1.text = tp ;
	opt1.value = "" ;
	opt2.text = tp ;
	opt2.value = "" ;
	list_obj1.add(opt1);
	list_obj2.add(opt2);
}

//********************************************************************************************
//function addColumn
//*******************************************************************************************
function addColumn(type,desc)	{ 
	var element1 = document.createElement('OPTION') ;
	var element2 = document.createElement('OPTION') ;
	element1.value		=  type ;
	element1.text		= desc ;
	element2.value		=  type ;
	element2.text		= desc ;
	document.forms[0].column_name.add(element1);
	document.forms[0].whrcolumn_name.add(element2);
}

//********************************************************************************************
//function clearAppNames
//*******************************************************************************************
function clearAppNames(val)	{ 
//	alert("clearAppNames");
//  alert("clrvals : "+val);
	var	list_obj1 = ""; 
	switch(val){
		case 'App'	:	
			list_obj1	=document.forms[0].application_name;break;	
		case 'Fac'	:	
			list_obj1	=document.forms[0].facility_name;break;	
		case 'Evnt'	:	
			list_obj1	=document.forms[0].event_type;break;	
		case 'Sgmnt'	:	
			list_obj1	=document.forms[0].segment_type;break;	
		case 'InbApi'	:	
			list_obj1	=document.forms[0].inbound_api;break;	
	}
	var len1 =list_obj1.options.length;
	for(var i=0;i<len1;i++) {
		list_obj1.remove("column_name");
	}
	var tp = "---------Select--------" ;
	var opt1 = document.createElement("OPTION") ;
	opt1.text = tp ;
	opt1.value = "" ;
	list_obj1.add(opt1);
}

//********************************************************************************************
//function addAppNames
//*******************************************************************************************
function addAppNames(val,type,desc)	{ 
//	alert("addAppNames");
//	alert("val : "+val);
//	alert("frm name : "+document.forms[0].name);	
	var element1 = document.createElement('OPTION') ;
	var element2 = document.createElement('OPTION') ;
	element1.value		=  type ;
	element1.text		= desc ;
	element2.value		=  type ;
	element2.text		= desc ;
	switch(val){
		case 'App'	:	
			document.forms[0].application_name.add(element1);break;
		case 'Fac'	:	
			document.forms[0].facility_name.add(element1);break;
		case 'Evnt'	:	
			document.forms[0].event_type.add(element1);break;
		case 'Sgmnt'	:	
			document.forms[0].segment_type.add(element1);break;
		case 'InbApi'	:	
			document.forms[0].inbound_api.add(element1);break;
	}
}

//********************************************************************************************
//function getQuery
//*******************************************************************************************
var qryResult = "";
function getQuery(qryType)
{
	if(document.forms[0].insert_type.value=='A'){
		var ColLen = (document.forms[0].column_name.options.length)-1;
//		alert("Col Lennn : "+ColLen);
		var TotColVals = document.forms[0].selectedColVals.value.split(",");
//		alert("tot col len : "+TotColVals.length);
		if(ColLen!=TotColVals.length){
//			alert("Insufficient Column Values ");
		}
	}
	else{
	var setUpdateParam = getSetParam();
	var insert_type   = document.getElementById("insert_type").value;
	var col_selected  = document.getElementById("column_name").value;
	var index1		  = document.forms[0].column_name.options.selectedIndex;
 	var slctd_ColVal  = document.forms[0].column_name.options[index1].text;
	var col_val		  = document.getElementById("col_val").value;	
	var slctdColumns  = document.getElementById("selectedCols").value;
	var slctdColVals  = document.getElementById("selectedColVals").value;
	var slctdtbl_name = document.getElementById("table_name").value;
	var index2		  = document.forms[0].whrcolumn_name.options.selectedIndex;
 	var slctdwhrcol	  = document.forms[0].whrcolumn_name.options[index2].text;
	var slctdwhrcond  = document.getElementById("where_cond").value;
	var slctdwhrtxt   = document.getElementById("whr_text").value;
	var whrclause	  = " \nWHERE "+slctdwhrcol+slctdwhrcond+"'"+slctdwhrtxt+"'";
	if(qryType=='insertquery'){
		if(insert_type=='A'){
			qryResult = "INSERT INTO "+slctdtbl_name+"\n VALUES( "+slctdColVals+" )";
		}
		else if(insert_type=='S'){
			qryResult = "INSERT INTO "+slctdtbl_name+"("+slctdColumns+")"+"\n VALUES( "+slctdColVals+" )";
		}
		document.getElementById("QueryResult").value = qryResult;
	}

	else if(qryType=='updatequery'){
		if((col_val!="")&&(slctdwhrtxt!="")){
			var whrClsCols = "\nWHERE "+document.forms[0].whrClauseTxt.value;
		 	var whrcol	  = document.forms[0].whrcolumn_name.value;
			if(whrcol==""||whrcol==''){
				qryResult = "UPDATE "+slctdtbl_name+"\nSET "+setUpdateParam;
			}
			else{
				qryResult = "UPDATE "+slctdtbl_name+"\nSET "+setUpdateParam+whrClsCols;
			}
		document.getElementById("QueryResult").value = qryResult;
		}
	}
	}
	
}

//********************************************************************************************
//function chkForNotNull
//*******************************************************************************************

function chkForNotNull(){
//	alert("tbl_name : "+document.forms[0].table_name.value);
	var tbl_name	  = document.forms[0].table_name.value;
	var index1		  = document.forms[0].column_name.options.selectedIndex;
 	var slctd_ColVal  = document.forms[0].column_name.options[index1].text;
//	alert("col_name : "+slctd_ColVal);
	
	if(document.forms[0].col_val.value!=''){
			slctColumnVal();
	}
	else {
//		alert("ChkForNtNull");
		var bean_name	=	document.forms[0].strBeanName.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " bean_name=\""+bean_name+"\"";
		xmlStr += " tbl_name=\""+tbl_name+"\"";
		xmlStr += " slctd_ColVal=\""+slctd_ColVal+"\"";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","QueryBasedInboundValidateQry.jsp?func_mode=chkNotNull",false);
		xmlHttp.send(xmlDoc);
		eval(xmlHttp.responseText);	
	}
}

//********************************************************************************************
//function slctColumnVal
//*******************************************************************************************

function slctColumnVal()
{
	 if(document.forms[0].qryType.value=='updatequery'){
			  update.style.display='block';
	 }
 //	 alert(document.forms[0].column_name.value);
	 if(flag1!=1){
		 var index		= document.forms[0].column_name.options.selectedIndex;
 		 var slctd_Col	= document.forms[0].column_name.options[index].text;
		 var slctd_ColValObj = document.forms[0].col_val;	     
		 var slctd_ColVal  = document.forms[0].col_val.value;
 		 var slctd_ColType  = document.forms[0].column_name.value;
		 var slctd_Cols = document.forms[0].selectedColVals.value;
		 var insert_type = document.forms[0].insert_type.value;
		 if(slctd_ColType=='VARCHAR2'){
			 if(insert_type=='S'){
	   	    document.forms[0].selectedCols.value = slctd_Col;
			 }
			document.forms[0].selectedColVals.value = "'"+slctd_ColVal+"'";
			flag1 = 1;
		 }
		 else if(slctd_ColType=='DATE'){
			if(CheckDateCol(document.forms[0].col_val)){
	    	    document.forms[0].selectedCols.value = slctd_Col;
				document.forms[0].selectedColVals.value = "'"+slctd_ColVal+"'";
  				flag1 = 1;
			}
		 }
		 else if(slctd_ColType=='NUMBER'){
			if(CheckForNumberCol(slctd_ColValObj)){
	    	    document.forms[0].selectedCols.value = slctd_Col;
				document.forms[0].selectedColVals.value = slctd_ColVal;
				flag1 = 1;
			}
		 }
	 }
}


//********************************************************************************************
//function CheckDateCol
//*******************************************************************************************

function CheckDateCol(obj){
//	alert("chkDate");
	Object2 = obj.value;
	datefield = obj;
    if (ChkDate(Object2)) {
	    return true;
	}
	else{
//		alert("Date Format should be DD/MM/YYYY ");
        alert(getMessage("XH1045", "XH"));
        if (datefield.value != undefined)
        {
            datefield.select();
            datefield.focus();
        }
    }
 }

//********************************************************************************************
//function CheckForNumberCol
//*******************************************************************************************

function CheckForNumberCol(obj){
	var colfield = obj;
	var col_val  = obj.value;
	if ( trimCheck(col_val) && isNaN(col_val) == false && col_val >=0){
		return true;
	}
	else{
//		alert("INVALID_NUMBER_FORMAT-Not a Valid Number "); 
	    alert(getMessage("XH1028", "XH")); 
		colfield.select();
		colfield.focus();
	}
}

//********************************************************************************************
//function addField
//*******************************************************************************************

function addField()
{
	 var slctd_ColType  = document.forms[0].column_name.value;
 	 var index		= document.forms[0].column_name.options.selectedIndex;
	 var slctd_Col	= document.forms[0].column_name.options[index].text;
	 var slctd_Cols = document.forms[0].selectedCols.value;
 	 var slctd_ColVals = document.forms[0].selectedColVals.value;
	 var slctd_ColValObj = document.forms[0].col_val;
	 var insert_type = document.forms[0].insert_type.value;
	 var slctd_ColVal  = slctd_ColValObj.value;
	 colTxt = colTxt+"#"+slctd_Col;
	 colcount++;
//	 alert("slctd_Cols : "+slctd_Cols);  
//	 alert("colTxt : "+colTxt);
	 	 if(slctd_ColType=='VARCHAR2'){
		    if(insert_type=='S'){
	   	  		document.forms[0].selectedCols.value = slctd_Cols+","+slctd_Col;
			}
				document.forms[0].selectedColVals.value = slctd_ColVals+","+"'"+slctd_ColVal+"'";
		 }
		 else if(slctd_ColType=='DATE'){
			if(CheckDateCol(slctd_ColValObj)){
				document.forms[0].selectedCols.value = slctd_Cols+","+slctd_Col;
 				document.forms[0].selectedColVals.value = slctd_ColVals+","+"'"+slctd_ColVal+"'";
			}
		 }	
		 else if(slctd_ColType=='NUMBER'){
			if(CheckForNumberCol(slctd_ColValObj)){
				document.forms[0].selectedCols.value = slctd_Cols+","+slctd_Col;
 				document.forms[0].selectedColVals.value = slctd_ColVals+","+slctd_ColVal;
			}
		 }	
}

//********************************************************************************************
//function slctWhrClsVal
//*******************************************************************************************

function slctWhrClsVal()
{
	 if(document.forms[0].qryType.value=='updatequery'){
			  update.style.display='block';
	 }
 //	 alert(document.forms[0].column_name.value);
	 if(whrFlag!=1){
		 var index		= document.forms[0].whrcolumn_name.options.selectedIndex;
 		 var slctd_Col	= document.forms[0].whrcolumn_name.options[index].text;
		 var slctd_ColValObj = document.forms[0].whr_text;	     
		 var slctd_ColVal  = document.forms[0].whr_text.value;
 		 var slctd_ColType  = document.forms[0].whrcolumn_name.value;
	  	 var slctdwhrcond  = document.getElementById("where_cond").value;
		 var slctd_Cols = document.forms[0].whrClauseTxt.value;
		 var insert_type = document.forms[0].insert_type.value;
		 if(slctd_ColType=='VARCHAR2'){
	//		 if(insert_type=='S'){
//	   	    document.forms[0].selectedCols.value = slctd_Col;
//			 }
			document.forms[0].whrClauseTxt.value = slctd_Col+slctdwhrcond+"'"+slctd_ColVal+"'";
			whrFlag = 1;
		 }
		 else if(slctd_ColType=='DATE'){
			if(CheckDateCol(document.forms[0].col_val)){
			document.forms[0].whrClauseTxt.value = slctd_Col+slctdwhrcond+"'"+slctd_ColVal+"'";
			whrFlag = 1;
			}
		 }
		 else if(slctd_ColType=='NUMBER'){
			if(CheckForNumberCol(slctd_ColValObj)){
			document.forms[0].whrClauseTxt.value = slctd_Col+slctdwhrcond+slctd_ColVal;
			whrFlag = 1;
			}
		 }
	 }
}

//********************************************************************************************
//function addWhrClause
//*******************************************************************************************

function addWhrClause()
{
	 var slctd_ColType  = document.forms[0].whrcolumn_name.value;
 	 var index		= document.forms[0].whrcolumn_name.options.selectedIndex;
	 var slctd_Col	= document.forms[0].whrcolumn_name.options[index].text;
//	 var slctd_Cols = document.forms[0].whrClauseTxt.value;
 	 var slctd_WhrClsVals = document.forms[0].whrClauseTxt.value;
 	 var slctdwhrcond  = document.getElementById("where_cond").value;
	 var slctd_ColValObj = document.forms[0].whr_text;
	 var insert_type = document.forms[0].insert_type.value;
	 var slctd_ColVal  = slctd_ColValObj.value;
	 colTxt = colTxt+"#"+slctd_Col;
	 colcount++;
//	 alert("slctd_Cols : "+slctd_Cols);  
//	 alert("colTxt : "+colTxt);
	 	 if(slctd_ColType=='VARCHAR2'){
//		    if(insert_type=='S'){
//	   	  		document.forms[0].selectedCols.value = slctd_Cols+","+slctd_Col;
//			}
			col_val = slctd_Col+slctdwhrcond+"'"+slctd_ColVal+"'";
			document.forms[0].whrClauseTxt.value = slctd_WhrClsVals+" AND "+col_val;
		 }
		 else if(slctd_ColType=='DATE'){
			if(CheckDateCol(slctd_ColValObj)){
			col_val = slctd_Col+slctdwhrcond+"='"+slctd_ColVal+"'";
			document.forms[0].whrClauseTxt.value = slctd_WhrClsVals+" AND "+col_val;
			}
		 }	
		 else if(slctd_ColType=='NUMBER'){
			if(CheckForNumberCol(slctd_ColValObj)){
			col_val = slctd_Col+slctdwhrcond+slctd_ColVal;
			document.forms[0].whrClauseTxt.value = slctd_WhrClsVals+" AND "+col_val;
			}
		 }	
}
//********************************************************************************************
//function getSetParam
//*******************************************************************************************
function getSetParam(){
	var slctdColumns  = document.getElementById("selectedCols").value;
	var slctdColVals  = document.getElementById("selectedColVals").value;

	var flag		  = 0;
	colNameArr			  = slctdColumns.split(",");
	colValArr			  = slctdColVals.split(",");

	for(i=0;i<colNameArr.length;i++){
		setColName = colNameArr[i];
		setColVal  = colValArr[i];
		if(flag==0){
			setParam	= setColName+"="+setColVal;
			flag=1;
		}
		else{
			setParam	= setParam+","+setColName+"="+setColVal;
		}
	}
	return setParam;
}

//********************************************************************************************
//function validateQry
//*******************************************************************************************

function validateQry(){  

	var qResult		=  escape(document.forms[0].QueryResult.value);
//	alert("qResult : "+qResult);
	var tbl_name	=  document.forms[0].table_name.value;
	var qryType		=  document.forms[0].qryType.value;
	if(document.forms[0].QueryResult.value!=""){
		var bean_name	=	document.forms[0].strBeanName.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " bean_name=\""+bean_name+"\"";
		xmlStr += " qryType=\""+qryType+"\"";
		xmlStr += " qResult=\""+qResult+"\"";
		xmlStr += " tbl_name=\""+tbl_name+"\"";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","QueryBasedInboundValidateQry.jsp?func_mode=validateQry",false);
		xmlHttp.send(xmlDoc);
//		alert(xmlHttp.responseText);
		eval(xmlHttp.responseText);	
	}
}

//********************************************************************************************
//function setErrorTxt
//*******************************************************************************************
function setErrorTxt(errFlag,exceptions,message_text2,qryType,qryRslt){
	//	alert("errFlg : "+errFlag);
	//	alert("message_text2 : "+message_text2);


	if(message_text2=='N'){
//		alert("Field Value Cannot be null");
		document.forms[0].col_val.focus();
	}
	else if((message_text2!='null')&&(message_text2!='')&&(message_text2!="")){
//		alert("Insufficient Col Values ");
		document.forms[0].qryError.value = "Other Not null Fields : "+message_text2;
	}
	else if(errFlag==0){
		qryRslt =  unescape(qryRslt);
		for(var i=0;i<qryRslt.length;i++){
			qryRslt	=	qryRslt.replace('+'," ");
		}
		window.returnValue = qryType+"!"+qryRslt;
		window.close();
	}
	else if(errFlag==1){
		exceptions =  unescape(exceptions);
		for(var i=0;i<exceptions.length;i++){
			exceptions	=	exceptions.replace('+'," ");
		}
		document.forms[0].qryError.value = 	exceptions;
	}
}
