function searchApplicationType(){
     
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit="Application Type" ;
		
            var target=document.forms[0].Application_type;
            var segment_id=document.forms[0].Application_type_id;
		
		/*
            sql="SELECT SEGMENT_NAME description,SEGMENT_TYPE code FROM XH_SEGMENT "+
                    "   WHERE UPPER(SEGMENT_TYPE) LIKE UPPER(?) AND "+ 
                    "           UPPER(SEGMENT_NAME) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";
*/
			sql="SELECT application_id code,application_name description FROM XH_APPLICATION "+
                    "   WHERE UPPER(application_id) LIKE UPPER(?) AND "+ 
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


function searchProtocolType(){
     
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit="Protocol Type" ;
            var target=document.forms[0].Protocol_link_type;
            var segment_id=document.forms[0].Protocol_Link_id;

			
/*
            sql="SELECT SEGMENT_NAME description,SEGMENT_TYPE code FROM XH_SEGMENT "+
                    "   WHERE UPPER(SEGMENT_TYPE) LIKE UPPER(?) AND "+ 
                    "           UPPER(SEGMENT_NAME) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";
*/
			sql="SELECT PROTOCOL_LINK_ID code,PROTOCOL_LINK_NAME description FROM XH_PROTOCOL_LINK "+
                    "   WHERE UPPER(PROTOCOL_LINK_ID) LIKE UPPER(?) AND "+ 
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
            }
            else{
                target.value=tdesc;
                segment_id.value=tcode;
            }
}// End of searchSegmentType searchDefaul


function searchFacilityType(){
     
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit="Facility Type" ;
            var target=document.forms[0].Facility_type;
            var segment_id=document.forms[0].Facility__id;
/*
            sql="SELECT SEGMENT_NAME description,SEGMENT_TYPE code FROM XH_SEGMENT "+
                    "   WHERE UPPER(SEGMENT_TYPE) LIKE UPPER(?) AND "+ 
                    "           UPPER(SEGMENT_NAME) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";
*/
			sql="SELECT DISTINCT Y.FACILITY_ID Code,Z.FACILITY_NAME Description FROM XH_APPLICATION_LANG_VW X,XH_APPL_FOR_FACILITY Y,SM_FACILITY_PARAM_LANG_VW Z  WHERE X.APPLICATION_ID=Y.APPLICATION_ID AND Y.FACILITY_ID=Z.FACILITY_ID AND UPPER(Y.FACILITY_ID) LIKE UPPER(?) AND "+ 
                    "           UPPER(Z.FACILITY_NAME) LIKE UPPER(?) "+
                    "      UNION SELECT '*A' code,'ALL' description FROM DUAL     ORDER BY 2";

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




function searchEventType(){
     
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit="Event Type" ;
            var target=document.forms[0].Event_type;
            var Event_id1=document.forms[0].Event__id;





/*
            sql="SELECT SEGMENT_NAME description,SEGMENT_TYPE code FROM XH_SEGMENT "+
                    "   WHERE UPPER(SEGMENT_TYPE) LIKE UPPER(?) AND "+ 
                    "           UPPER(SEGMENT_NAME) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";
*/
			sql="SELECT distinct EVENT_TYPE code,EVENT_NAME description FROM XH_EVENT_TYPE_LANG_VW "+
                    "   WHERE UPPER(EVENT_TYPE) LIKE UPPER(?) AND "+ 
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



function searchMessageType(){
 
			var tdesc="";
            var tcode="";
			

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit="Message Type" ;
            var target=document.forms[0].Message_type;

		          var segment_id=document.forms[0].Message__id;
/*
            sql="SELECT SEGMENT_NAME description,SEGMENT_TYPE code FROM XH_SEGMENT "+
                    "   WHERE UPPER(SEGMENT_TYPE) LIKE UPPER(?) AND "+ 
                    "           UPPER(SEGMENT_NAME) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";
*/
			sql="SELECT message_type code,description description FROM XH_MESSAGE_TYPE "+
                    "   WHERE UPPER(message_type) LIKE UPPER(?) AND "+ 
                    "           UPPER(description) LIKE UPPER(?) "+
                    "    UNION SELECT '*A' code,'ALL' description FROM DUAL ORDER BY 1 ";

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


            }
            else{
                target.value=tdesc;
                segment_id.value=tcode;
            }
}// End of searchSegmentType searchDefaul

async function searchFiltergroupType(){
	//alert("filert");
 
			var tdesc="";						
            var tcode="";
		

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit="Filter Group Code" ;
            var target=document.forms[0].Filter_group_desc;
	
		          var segment_id=document.forms[0].Filter_group_desc_id;
				  
/*
            sql="SELECT SEGMENT_NAME description,SEGMENT_TYPE code FROM XH_SEGMENT "+
                    "   WHERE UPPER(SEGMENT_TYPE) LIKE UPPER(?) AND "+ 
                    "           UPPER(SEGMENT_NAME) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";
*/
			sql="SELECT FILTER_GROUP_CODE code,FILTER_GROUP_DESC Description from XH_FILTER_GROUP "+
                    "   WHERE UPPER(FILTER_GROUP_CODE) LIKE UPPER(?) AND "+ 
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



argumentArray[0] = sql;
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

