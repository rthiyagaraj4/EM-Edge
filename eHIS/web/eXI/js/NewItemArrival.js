
 function sysDateCheck(from,to) {

    var fromarray;
    var toarray;
    var fromdate = from.value ;
    var todate = to.value ;
	
    if(fromdate.length > 0 && todate.length > 0 ) {
            fromarray = fromdate.split("/");
            toarray = todate.split("/");
            var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
            var todt = new Date(toarray[2],toarray[1],toarray[0]);

            if(Date.parse(todt) > Date.parse(fromdt)) 
            {
                var invaldt = getMessage("START_DATE_GREATER_SYSDATE","Common") ;
                alert(invaldt);
                to.select();
                to.focus();
                    
            }
            else if(Date.parse(todt) <= Date.parse(fromdt)) return true;
    }
    return true;
}
 function goSearch()
 {	 
	 parent.frames[2].document.location.href="../../eCommon/html/blank.html";
	 parent.frames[3].document.location.href="../../eCommon/jsp/MstCodeError.jsp";
var fields = new Array ( parent.frames[1].document.forms[0].after_date);
					   
var names = new Array ( getLabel("Common.date.label","common")
						);

if(!parent.frames[1].checkFields( fields, names, parent.messageFrame))
{ 

} 
else
{
	var date=parent.frames[1].document.forms[0].after_date.value;
	var itemcatagory=parent.frames[1].document.forms[0].Itemcategory_txt.value;
	var Organization_code=parent.frames[1].document.forms[0].organization_txt.value;
	var action_type=document.forms[0].action_type.value;
	
parent.frames[2].document.location.href="../../eXI/jsp/NewArrivalItemSearchQuery.jsp?after_date="+date+"&Item_Category="+itemcatagory+"&Organization_code="+Organization_code+"&action_type="+action_type;		

}
// window.commontoolbarFrame.document.location.href='../../eCommon/jsp/MstCodeToolbar.jsp';




 }
 function reset()
{
	window.frames[2].document.location.href='../../eCommon/html/blank.html';
	window.frames[1].document.forms[0].reset();
}

 async function searchCategory(){
    
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit="Application Type" ;
		
            var target=document.forms[0].item_Arrival;
            var segment_id=document.forms[0].Itemcategory_txt;
		
		/*
            sql="SELECT SEGMENT_NAME description,SEGMENT_TYPE code FROM XH_SEGMENT "+
                    "   WHERE UPPER(SEGMENT_TYPE) LIKE UPPER(?) AND "+ 
                    "           UPPER(SEGMENT_NAME) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";ItemCode
*/
			sql="SELECT XI_ITEM_CATEGORY_CODE Code,CATEGORY_TYPE_CODE description FROM XI_ITEM "+
                    "   WHERE UPPER(XI_ITEM_CATEGORY_CODE) LIKE UPPER(?) AND "+ 
                    "           UPPER(CATEGORY_TYPE_CODE) LIKE UPPER(?) "+
                    "  ORDER BY 1 ";

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
                target.value=arr[0];
                segment_id.value=arr[0];
            }
            else{
                target.value=tdesc;
               segment_id.value=tcode;
            }
}// End of searchSegmentType searchDefaul
 async function searchOrganization(){
     
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit="Application Type" ;
		
            var target=document.forms[0].Organization;
            var segment_id=document.forms[0].organization_txt;
		
	
	/*		sql="SELECT XI_ORGANIZATION_ID code,ITEM_CODE Description FROM XI_ITEM "+
                    "   WHERE UPPER(XI_ORGANIZATION_ID) LIKE UPPER(?)  AND "+ 
                    "           UPPER(ITEM_CODE) LIKE UPPER(?) "+
                     " ORDER BY 1 ";*/
					 sql="SELECT distinct ORGANIZATION_ID code,ORGANIZATION_ID description FROM XI_QRY_ORG_ITM_STATUS WHERE UPPER(ORGANIZATION_ID) LIKE UPPER(?) AND UPPER(ORGANIZATION_ID) LIKE UPPER(?) ORDER BY 1";

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
                target.value=arr[0];
                segment_id.value=arr[0];
            }
            else{
                target.value=tdesc;
               segment_id.value=tcode;
            }
}// End of searchSegmentType searchDefaul

function checkDatefun(to,format)
{
var d =new Date();
var from=d.getDate()+"/"+(d.getMonth()+1)+"/"+d.getYear();


alert(from);
	

	 if(!isBefore(to,from,format,localeName)){
		var error=getMessage("REMARKS_MUST_GR_EQUAL","common") ;
		error=error.replace("$",getLabel("Common.to.label","Common"));
			alert(error);
       document.forms[0].after_date.value='';
			return false;
		}
		else  
			return true;
}

//***************************************************************************
// function funAction
//***************************************************************************
function funAction(typ)
{	
	document.forms[0].action_type.value = typ;
	this.document.forms[0].target=''
	goSearch();
}

