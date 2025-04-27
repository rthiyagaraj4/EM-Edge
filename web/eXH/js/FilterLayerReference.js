 async function searchApplicationType(){
			var locale=document.forms[0].locale.value;
			var tdesc="";
            var tcode="";
		    document.forms[0].Message_type.value='';
		    document.forms[0].Message__id.value='';
            var retVal =new String();
            var argumentArray  = new Array() ;								 
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit=getLabel("Common.Application.label","common") ; 
		    var target=document.forms[0].Application_type;
            var segment_id=document.forms[0].Application_type_id; 
		
		/*
            sql="SELECT SEGMENT_NAME description,SEGMENT_TYPE code FROM XH_SEGMENT "+
                    "   WHERE UPPER(SEGMENT_TYPE) LIKE UPPER(?) AND "+ 
                    "           UPPER(SEGMENT_NAME) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";
*/
			sql="SELECT application_id code,application_name description FROM XH_APPLICATION_LANG_VW "+
                    "   WHERE LANGUAGE_ID='"+locale+"' and UPPER(application_id) LIKE UPPER(?) AND "+ 
                    "           UPPER(application_name) LIKE UPPER(?) "+
                    " UNION SELECT '*A' ,'ALL'  FROM DUAL ORDER BY 1 "; 

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
}// End of searchSegmentType searchDefaul


async function searchProtocolType(){
		  var locale=document.forms[0].locale.value;
			var tdesc="";
            var tcode="";
		  document.forms[0].Message_type.value='';
		    document.forms[0].Message__id.value='';
            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ; 
            var dataValueArray = new Array() ;  
            var dataTypeArray  = new Array() ;
            var tit=getLabel("eXH.Gateway.Label","XH") ;
            var target=document.forms[0].Protocol_link_type;
            var segment_id=document.forms[0].Protocol_Link_id;

			
/*
            sql="SELECT SEGMENT_NAME description,SEGMENT_TYPE code FROM XH_SEGMENT "+
                    "   WHERE UPPER(SEGMENT_TYPE) LIKE UPPER(?) AND "+ 
                    "           UPPER(SEGMENT_NAME) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";
*/
			sql="SELECT PROTOCOL_LINK_ID code,PROTOCOL_LINK_NAME description FROM XH_PROTOCOL_LINK_LANG_VW "+
                    "   WHERE LANGUAGE_ID='"+locale+"' and UPPER(PROTOCOL_LINK_ID) LIKE UPPER(?) AND "+ 
                    "           UPPER(PROTOCOL_LINK_NAME) LIKE UPPER(?) "+
                    "  UNION SELECT '*A' code,'ALL' description FROM DUAL ORDER BY 1";

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
				getCommMode(segment_id.value);
				document.forms[0].MessageTypeSearch.disabled=false;
				document.forms[0].Message_type.disabled=false;
            }
            else{
                target.value=tdesc;
                segment_id.value=tcode;
            }
}// End of searchSegmentType searchDefaul


/*function searchFacilityType(){
			 var locale=document.forms[0].locale.value;
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit=getLabel("Common.Facility.label","common")  ;
            var target=document.forms[0].Facility_type;
            var segment_id=document.forms[0].Facility__id;
/* 
            sql="SELECT SEGMENT_NAME description,SEGMENT_TYPE code FROM XH_SEGMENT "+
                    "   WHERE UPPER(SEGMENT_TYPE) LIKE UPPER(?) AND "+ 
                    "           UPPER(SEGMENT_NAME) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";
*/
		/*	sql="SELECT DISTINCT Y.FACILITY_ID Code,Z.FACILITY_NAME Description FROM XH_APPLICATION_LANG_VW X,XH_APPL_FOR_FACILITY Y,SM_FACILITY_PARAM_LANG_VW Z  WHERE X.APPLICATION_ID=Y.APPLICATION_ID AND Y.FACILITY_ID=Z.FACILITY_ID and Z.LANGUAGE_ID='"+locale+"' AND UPPER(Y.FACILITY_ID) LIKE UPPER(?) AND "+ 
                    " UPPER(Z.FACILITY_NAME) LIKE UPPER(?) "+
                    "      UNION SELECT '*A' code,'ALL' description FROM DUAL     ORDER BY 2";*/
				/*	sql="SELECT X.FACILITY_ID code,X.FACILITY_NAME description FROM SM_FACILITY_PARAM_LANG_VW X,XH_PARAM_FOR_FACILITY Y,SM_MODULES_FACILITY Z WHERE  X.LANGUAGE_ID='"+locale+"' AND Z.MODULE_ID='XH' AND Z.OPERATIONAL_YN='Y' AND X.FACILITY_ID=Y.FACILITY_ID AND X.FACILITY_ID=Z.FACILITY_ID and UPPER(X.FACILITY_ID) LIKE UPPER(?) AND    UPPER(X.FACILITY_NAME) LIKE UPPER(?)   ORDER BY 1"

alert(sql);
			/*sql="SELECT DISTINCT Y.FACILITY_ID Code,Z.FACILITY_NAME Description FROM SM_FACILITY_PARAM_LANG_VW X,XH_PARAM_FOR_FACILITY Y,SM_MODULES_FACILITY Z  WHERE  X.FACILITY_ID=Z.FACILITY_ID AND X.FACILITY_ID=Z.FACILITY_ID and Z.LANGUAGE_ID='"+locale+"' AND UPPER(X.FACILITY_ID) LIKE UPPER(?) AND "+ 
                    " UPPER(X.FACILITY_NAME) LIKE UPPER(?) "+
                    "      UNION SELECT '*A' code,'ALL' description FROM DUAL     ORDER BY 2";*/


		/*	sql="SELECT X.FACILITY_ID code,X.FACILITY_NAME description FROM SM_FACILITY_PARAM_LANG_VW X,XH_PARAM_FOR_FACILITY Y,SM_MODULES_FACILITY Z WHERE  X.LANGUAGE_ID='"+locale+"' AND Z.MODULE_ID='XH' AND Z.OPERATIONAL_YN='Y' AND X.FACILITY_ID=Y.FACILITY_ID AND X.FACILITY_ID=Z.FACILITY_ID and UPPER(X.FACILITY_ID) LIKE UPPER(?) AND  UPPER(X.FACILITY_NAME) LIKE UPPER(?) "+
                    "      UNION SELECT '*A' code,'ALL' description FROM DUAL     ORDER BY 1";*/


           /* argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ; 
            argumentArray[3] = dataTypeArray ;
      //    argumentArray[4] = "2,1";
	        argumentArray[4] = "1,2"; 
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         alert();
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
}// End of searchSegmentType searchDefaul*/
async function searchFacilityType(){
            var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit= getLabel("Common.facility.label","common");
			
          var target=document.forms[0].Facility_type;
            var segment_id=document.forms[0].Facility__id;
           var locale=document.forms[0].locale.value;
		//	sql="SELECT a.facility_id code,b.facility_name description FROM XH_PARAM_FOR_FACILITY a,  SM_FACILITY_PARAM_LANG_VW b WHERE a.facility_id=b.facility_id and UPPER(b.facility_id) LIKE UPPER(?) AND    UPPER(b.facility_name) LIKE UPPER(?) and b.language_id='en'  ORDER BY 1 ";
		//sql="SELECT a.facility_id code,b.facility_name description FROM XH_PARAM_FOR_FACILITY a,  SM_FACILITY_PARAM_LANG_VW b WHERE a.facility_id=b.facility_id and UPPER(b.facility_id) LIKE UPPER(?) AND    UPPER(b.facility_name) LIKE UPPER(?) and b.language_id='en'  ORDER BY 1 ";

			sql="SELECT X.FACILITY_ID code,X.FACILITY_NAME description FROM SM_FACILITY_PARAM_LANG_VW X,XH_PARAM_FOR_FACILITY Y,SM_MODULES_FACILITY Z WHERE  X.LANGUAGE_ID='"+locale+"' AND Z.MODULE_ID='XH' AND Z.OPERATIONAL_YN='Y' AND X.FACILITY_ID=Y.FACILITY_ID AND X.FACILITY_ID=Z.FACILITY_ID and UPPER(X.FACILITY_ID) LIKE UPPER(?) AND    UPPER(X.FACILITY_NAME) LIKE UPPER(?)   ORDER BY 1";
/*
			if(faclty_id.value!=""){
				dataNameArray[0]	= "FACILITY_ID" ;
				dataValueArray[0]	= faclty_id.value;
				dataTypeArray[0]	= STRING ;
			} */
 
			argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
	        argumentArray[4] = "1,2";
//			argumentArray[4] = "2,1";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
//				alert();
                segment_id.value=arr[0];
            }
            else{
                target.value=tdesc;
                segment_id.value=tcode;
            }
}// End of searchFacility

function searchleval()
	{


this.document.forms[0].action='../../eXH/jsp/FilterLayerLevalNumber.jsp?filter_code='+this.document.forms[0].Filter_group_desc_id.value;
this.document.forms[0].submit();

	}


async function searchEventType(){
			var comm_mode=this.document.forms[0].comm_mode.value;
	        var locale=document.forms[0].locale.value;
			var tdesc="";
            var tcode="";
            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
			  var message__id=document.forms[0].Message__id.value;
            var tit=getLabel("Common.EventType.label","common")  ;
            var target=document.forms[0].Event_type;
            var Event_id1=document.forms[0].Event__id;
/*
            sql="SELECT SEGMENT_NAME description,SEGMENT_TYPE code FROM XH_SEGMENT "+
                    "   WHERE UPPER(SEGMENT_TYPE) LIKE UPPER(?) AND "+ 
                    "           UPPER(SEGMENT_NAME) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";
*/
			sql="SELECT distinct EVENT_TYPE code,EVENT_NAME description FROM XH_EVENT_TYPE_LANG_VW "+
                    "   WHERE MESSAGE_TYPE =nvl('"+message__id+"',MESSAGE_TYPE) and COMMUNICATION_TYPE in('"+comm_mode+"','*') and LANGUAGE_ID='"+locale+"' and UPPER(EVENT_TYPE) LIKE UPPER(?) AND "+ 
                    "           UPPER(EVENT_NAME) LIKE UPPER(?) "+
                    "       UNION SELECT '*A' code,'ALL' description FROM DUAL    ORDER BY 1";

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
                Event_id1.value=arr[0];
            }
            else{
                target.value=tdesc;

                Event_id1.value=tcode;
            }
}// End of searchSegmentType searchDefaul

async function searchMessageType(){
			var comm_mode=this.document.forms[0].comm_mode.value;
			var locale=document.forms[0].locale.value;
			var tdesc="";
            var tcode="";
			document.forms[0].Event_type.value='';
            document.forms[0].Event__id.value='';
			var obj=document.forms[0].Application_type_id.value;
            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit=getLabel("Common.MessageType.label","common") ; 
            var target=document.forms[0].Message_type;
            var segment_id=document.forms[0].Message__id;
 			sql="SELECT a.MESSAGE_TYPE code,a.DESCRIPTION description FROM XH_MESSAGE_TYPE_LANG_VW a,(SELECT DISTINCT MESSAGE_TYPE FROM XH_EVENT_TYPE b,xh_application_event_type f where  f.APPLICATION_ID='"+obj+"' and f.IN_USE_YN='Y' and f.EVENT_TYPE=b.EVENT_TYPE and b.COMMUNICATION_TYPE in('"+comm_mode+"','*')) c WHERE a.MESSAGE_TYPE=c.MESSAGE_TYPE AND a.LANGUAGE_ID='"+locale+"' and UPPER(a.message_type) LIKE UPPER(?) AND "+ 
                    " UPPER(a.description) LIKE UPPER(?) "+
                    " UNION SELECT '*A' code,'ALL' description FROM DUAL ORDER BY 1 ";
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
             document.forms[0].Message_type.value=arr[1];
             segment_id.value=arr[0];
			document.forms[0].eventTypeSearch.disabled=false;
			document.forms[0].Event_type.disabled=false; 
            }
            else{
                target.value=tdesc;
                segment_id.value=tcode;
				document.forms[0].eventTypeSearch.disabled=true;
				document.forms[0].Event_type.disabled=true;
            }
}// End of searchSegmentType searchDefaul

async function searchFiltergroupType(){
  //alert("sm");

parent.frames[5].document.location.href='../../eCommon/jsp/MstCodeError.jsp';
			var tdesc="";
            var tcode="";
		

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ; 
            var tit=getLabel("eXH.FilterGroup.Label","XH");
            var target=document.forms[0].Filter_group_desc;
	
		          var segment_id=document.forms[0].Filter_group_desc_id;
				  
/*
            sql="SELECT SEGMENT_NAME description,SEGMENT_TYPE code FROM XH_SEGMENT "+
                    "   WHERE UPPER(SEGMENT_TYPE) LIKE UPPER(?) AND "+ 
                    "           UPPER(SEGMENT_NAME) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";
*/
			sql="SELECT FILTER_GROUP_CODE code,FILTER_GROUP_DESC Description from XH_FILTER_GROUP ";
                  //  "   WHERE UPPER(FILTER_GROUP_CODE) LIKE UPPER(?) AND "+ 
                   // "           UPPER(FILTER_GROUP_DESC) LIKE UPPER(?) "+
                    //"           ORDER BY 1 ";

            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
			argumentArray[4] = "2,1";
	        //argumentArray[4] = "1,2";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         retVal =await CallCatalogSearch(sql,target);
		
         /*  retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");


            target.value=arr[1];

			   
                segment_id.value=arr[0]; 


            }
            else{
                target.value=tdesc;
                segment_id.value=tcode;
            }*/
			
			
			//retArray = await CommonLookup( title, argArray );		
	var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		} 
		
 if(retVal != null && retVal != "" ){
	            //var ret1=unescape(retVal);
                //arr=ret1.split(",");
target.value=arr[1];
segment_id.value=arr[0];
filterDetails();


            }
            else{
                parent.frames[2].location.href="../../eCommon/html/blank.html";
                parent.frames[3].location.href="../../eCommon/html/blank.html";
				parent.frames[4].location.href="../../eCommon/html/blank.html";
                target.value=arr[1];
                segment_id.value=arr[0];
            }



}// End of searchSegmentType searchDefaul
/*function qrySystUsrDefStr(obj) {
		var FilterID=	document.forms[0].Filter_group_desc_id.value;
		
	
	alert("FilterID324"+FilterID);

		
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += "Filter_code=\""+FilterID+"\"";
		xmlStr +=" /></root>";
		
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		
		xmlHttp.open("POST","FilterLayerLevalNumber.jsp?func_mode=qryStructures",false);
		xmlHttp.send(xmlDoc);
		eval(xmlHttp.responseText);	

	
}*/ 

async function searchFiltergroupTypeConfig(){
			parent.frames[4].document.location.href='../../eCommon/jsp/MstCodeError.jsp';
			var tdesc="";
            var tcode="";
            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit=getLabel("eXH.FilterGroup.Label","XH");
            var target=document.forms[0].Filter_group_desc;
	        var segment_id=document.forms[0].Filter_group_desc_id;
			sql="SELECT FILTER_GROUP_CODE code,FILTER_GROUP_DESC Description from XH_FILTER_GROUP WHERE UPPER(FILTER_GROUP_CODE) LIKE UPPER(?) AND "+ 
                    "           UPPER(FILTER_GROUP_DESC) LIKE UPPER(?) "+
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
         //retVal =CallCatalogSearch(sql,target);
		
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
		
			if(retVal != null && retVal != "" ){
			var ret1=unescape(retVal);
			arr=ret1.split(",");
			target.value=arr[1];
			segment_id.value=arr[0];
			searchleval(); 
            }
            else{
             //   parent.frames[2].location.href="../../eCommon/html/blank.html";
              //  parent.frames[3].location.href="../../eCommon/html/blank.html";
				parent.frames[4].location.href="../../eCommon/jsp/error.jsp"; 
                target.value=tdesc; 
                segment_id.value=tcode;
            }
 


}
function searchElementcodeQuery(str,numb)
{

	
			var tdesc="";
            var tcode="";
            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit="Filter Group Code" ;
			var segment_id;
			var target;
			var query_count_fields;
			var query_field_text;
			var query_field_text_id;
			var sql="";
 var changeStr1="";
  var changeStr2="";
var count=document.forms[0].count_fields.value;
var secondlistitem = numb+"Filter_subtype_desc_combo";
var firstlistitem=numb+"Filter_element_desc";


var firstitemSel = document.getElementById(firstlistitem).value;
var seconditemsel=document.getElementById(secondlistitem).value;
var reFirst;
var reSecond;
reSecond = new RegExp("'"+seconditemsel+"'");
reFirst = new RegExp("'"+firstitemSel+"'");

changeStr1=new String(reFirst);
changeStr2=new String(reSecond);

var singlefirstitem=Trim(changeStr1);
var singleseconditem=Trim(changeStr2);
 
for (i=1;i<=count ;i++)
{
	 query_count_fields=i+"Element_code_Query_id";

if (str==query_count_fields+'b')
{
 query_field_text="Element_code_Query"+i;
 query_field_text_id="Element_code_Querys"+i+i;
sql=parent.frames[4].document.getElementById(query_count_fields).value;
if(sql.indexOf(':1')!=-1)
	{

sql = sql.replace(/:1/g,singlefirstitem);
	}
if(sql.indexOf(':2')!=-1)
{
	
sql = sql.replace(/:2/g,singleseconditem);
}


for(var k=0; k<document.FilterSearchForm.elements.length; k++)
{
	if(document.FilterSearchForm.elements[k].name==query_field_text)
	{
	target=window.parent.frames[4].document.FilterSearchForm.elements[k];
	
	}
	else if(document.FilterSearchForm.elements[k].name==query_field_text_id)
	{
segment_id=window.parent.frames[4].document.FilterSearchForm.elements[k];
 	}
	

	}
	
}
}   



/*argumentArray[0] = sql;
argumentArray[1] = dataNameArray ;
argumentArray[2] = dataValueArray ;
argumentArray[3] = dataTypeArray ;
argumentArray[4] = "1,2";
argumentArray[5] = target.value;
argumentArray[6] = DESC_LINK  ;
argumentArray[7] = DESC_CODE ;
//alert("enathu"+target.name)
         retVal = await CommonLookup( tit, argumentArray );
		
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
target.value=arr[0];
segment_id.value=arr[1];


            }
            else{
                target.value=tdesc;
                segment_id.value=tcode;
            } */
    
retVal =CallCatalogSearch(sql,target);
		
	            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
target.value=arr[0];
segment_id.value=arr[1];


            }
            else{
                target.value=tdesc;
                segment_id.value=tcode;
            }
 

}
function Trim(str)
{ 
while(str.charAt(0) == ("/") )
  {  str = str.substring(1);
  }
  while(str.charAt(str.length-1) == "/" )
  {  str = str.substring(0,str.length-1);
  }
  return str;
}



async function CallCatalogSearch(Query,target)
{
	var module_id='XH';
	var mode="";
	var searchtext=target.value;

	//var clinic_code = parent.frames[3].document.forms[0].assign_care_locn_code.value;
	/*
var dialogHeight = "350";
var dialogWidth  = "250";
var dialogTop    = "250";
var dialogLeft   = "250";

*/
	
	 var dialogTop   = "10px";
	 var dialogLeft   = "25px";
	    var dialogHeight= "55vh" ;
	    var dialogWidth = "75vw" ;
	    
	    
var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
/*	var dialogTop	= "56"; 
	var dialogHeight= "33" ; 
	var dialogWidth = "50" ;
	var status = "no";
	var scroll = "no";
	var features    = "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll;*/
	var arguments   = "" ;			
	var retVal=await window.showModalDialog("../../eXH/jsp/FilteringAndSchdulingLookupFrameset.jsp?searchText="+encodeURIComponent(searchtext)+"&sql_query="+encodeURIComponent(Query)+"&called_from=XH&mode="+mode,arguments,features);	



    return retVal;
	//var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='popordercatalog' id='popordercatalog' method='post' action='../../eOP/jsp/RoomValidationYN.jsp'><input type='hidden' name='callfunc' id='callfunc' value='OrderCatalog'></form></body></html>";		
				
	//parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal); 
	//parent.parent.messageFrame.document.popordercatalog.submit();
}


function getCommMode(protocol_id) { 
		var proc_id	=	proc_id;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " base_unit=\""+protocol_id+"\"";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");		
		xmlHttp.open("POST","FilterLayerGroupEvntList.jsp?func_mode=getCommMode",false);
		xmlHttp.send(xmlDoc);		
//		alert(xmlHttp.responseText);
		eval(xmlHttp.responseText);	
}


function setCommMode(comm_mode){
	

		this.document.forms[0].comm_mode.value = comm_mode; 
		
}

