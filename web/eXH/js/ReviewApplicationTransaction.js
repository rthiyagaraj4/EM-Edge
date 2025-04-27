

function query()
{
		
}

function apply()
{

	

		
}

function reset()
{
	
}

function callPatientID(obj,target)
 {
 var retVal =  new String();
 var argumentArray  = new Array() ;
 var dataNameArray  = new Array() ;
 var dataValueArray = new Array() ;
 var dataTypeArray  = new Array() ;
 var tit="Patient Search" ;
 
    var sql="SELECT SHORT_NAME DESCRIPTION, PATIENT_ID CODE FROM  mp_patient_mast WHERE UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PATIENT_ID) LIKE UPPER(?)  ORDER BY 1";
 	 alert("inside js");

 argumentArray[0] = sql;
 
 argumentArray[1] = dataNameArray;

 argumentArray[2] = dataValueArray;
 

 argumentArray[3] = dataTypeArray;
 

 argumentArray[4] = "2,1";
 

 argumentArray[5] = target.value;
 
 argumentArray[6] = DESC_LINK;
 
 argumentArray[7] = DESC_CODE;

 


 
  

 retVal = await CommonLookup( tit, argumentArray );


 if(retVal != null && retVal != "" )
 {
  var ret1=unescape(retVal);
  arr=ret1.split(",");
  obj.value = arr[0];
  target.value=arr[1];
 }else{
  target.value="";
  obj.value="";
 }
 }
 