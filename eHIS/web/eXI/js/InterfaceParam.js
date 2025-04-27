//*************************************************************************************************
// Function apply()
//**************************************************************************************************
function apply()
{


if(f_query_add_mod.document.forms[0].rac_cluster.value=='Y')
	{

var fields = new Array (f_query_add_mod.document.forms[0].DBconnection_string_txt,f_query_add_mod.document.forms[0].Application_type);
var names = new Array (getLabel("eXI.clustertns.Label","XI"),getLabel("eXI.ExtApplication.Label","XI"));
if(!window.f_query_add_mod.checkFields( fields, names, messageFrame))
{ 

} 
else
{
f_query_add_mod.document.forms[0].db_conn_string_txt.value=f_query_add_mod.document.forms[0].DBconnection_string_txt.value;
window.f_query_add_mod.document.forms[0].submit();

		}
	}
	else
	{
var fields = new Array ( f_query_add_mod.document.forms[0].db_conn_string1,
					     f_query_add_mod.document.forms[0].db_conn_string2,
						 f_query_add_mod.document.forms[0].db_conn_string3,f_query_add_mod.document.forms[0].Application_type) ;
var names = new Array ( getLabel("eXH.DBConnectString.Label","XH"),
						getLabel("eXH.DBConnectString1.Label","XH"),
						getLabel("eXH.DBConnectString2.Label","XH"),getLabel("eXI.ExtApplication.Label","XI"));
if(!window.f_query_add_mod.checkFields( fields, names, messageFrame))
{ 

} 
else
{ 
	
//f_query_add_mod.document.forms[0].rac_cluster.value='N';
f_query_add_mod.document.forms[0].db_conn_string_txt.value=f_query_add_mod.document.forms[0].db_conn_string1.value+':'+f_query_add_mod.document.forms[0].db_conn_string2.value+':'+f_query_add_mod.document.forms[0].db_conn_string3.value;

window.f_query_add_mod.document.forms[0].submit();
}




	}
 window.commontoolbarFrame.document.location.href='../../eCommon/jsp/MstCodeToolbar.jsp';
window.commontoolbarFrame.document.location.reload();



}

//******************************************************************************************************
// Function reset()
//*******************************************************************************************************
function reset() 
{

	if(window.f_query_add_mod.document.forms[0])
    {
	 window.f_query_add_mod.document.forms[0].reset();
	}
}
//**********************************************************************************************************


async function searchItemClass(){
     
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit=getLabel("Common.ItemClass.label","common");
		
            var target=document.forms[0].item_class;
            var segment_id=document.forms[0].Itemclass_txt;
		
		/*
            sql="SELECT SEGMENT_NAME description,SEGMENT_TYPE code FROM XH_SEGMENT "+
                    "   WHERE UPPER(SEGMENT_TYPE) LIKE UPPER(?) AND "+ 
                    "           UPPER(SEGMENT_NAME) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";
*/


			sql="select ITEM_CLASS_CODE code,short_desc description from MM_ITEM_CLASS "+
                    "   WHERE  NVL(Eff_status, 'D') = 'E' and UPPER(ITEM_CLASS_CODE) LIKE UPPER(?) AND "+ 
                    "           UPPER(short_desc) LIKE UPPER(?) "+
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
}// End of searchItem class searchDefaul
async function searchItemType(){
     
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit="Application Type" ;
		
            var target=document.forms[0].item_type;
            var segment_id=document.forms[0].ItemType_txt;
		
		/*
            sql="SELECT SEGMENT_NAME description,SEGMENT_TYPE code FROM XH_SEGMENT "+
                    "   WHERE UPPER(SEGMENT_TYPE) LIKE UPPER(?) AND "+ 
                    "           UPPER(SEGMENT_NAME) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";
*/


			sql="select ITEM_CLASS_CODE code,short_desc description from MM_ITEM_CLASS "+
                    "   WHERE  NVL(Eff_status, 'D') = 'E' and UPPER(ITEM_CLASS_CODE) LIKE UPPER(?) AND "+ 
                    "           UPPER(short_desc) LIKE UPPER(?) "+
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


async function searchProfileID(){
     
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit=getLabel("eXI.ExtApplication.Label","XI");
            var target=this.document.forms[0].Application_type;
            var Profile_id=this.document.forms[0].Application_type_id;
			var sql="SELECT PROFILE_ID code,SHORT_DESC description FROM XH_STANDARD_PROFILE "+
                    "   WHERE UPPER(PROFILE_ID) LIKE UPPER(?) AND "+ 
                    "           UPPER(SHORT_DESC) LIKE UPPER(?) "+
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
                Profile_id.value=arr[0];
			
            }
            else{
                target.value=tdesc;
               Profile_id.value=tcode;
            }
}

function funonload()
{
	//document.getElementById("colon1").style.display="block";
//document.getElementById("colon2").style.display="none";
	if(this.document.forms[0].rac_cluster.value=='Y')
	{
		//document.forms[0].db_conn_string1.disabled=true;
			//		     document.forms[0].db_conn_string2.disabled=true;
						 //document.forms[0].db_conn_string3.disabled=true;
document.getElementById("colon").style.display="";
document.getElementById("colon1").style.display="";
document.getElementById("colon2").style.display="";
document.getElementById("colon3").style.display="";
	//	document.forms[0].db_conn_string1.style.display="none";
  //  document.forms[0].db_conn_string2.style.display="none";
					//	 document.forms[0].db_conn_string3.style.display="none";				 
	}
else
	{
	this.document.forms[0].rac_cluster.value='N';
	document.getElementById("colon").style.display="";
document.getElementById("colon1").style.display="";
document.getElementById("colon2").style.display="none";
document.getElementById("colon3").style.display="none";
//document.forms[0].db_conn_string1.disabled=true;
//					     document.forms[0].db_conn_string2.disabled=true;
//						document.forms[0].db_conn_string3.disabled=true;

	//document.forms[0].db_conn_string1.style.display="block";
                   //      document.forms[0].db_conn_string2.style.display="block";
					//	 document.forms[0].db_conn_string3.style.display="block";
	
	}
}

function connStringArea()
{



	if(this.document.forms[0].rac_cluster.checked==true)
	{
this.document.forms[0].rac_cluster.value='Y';
document.getElementById("colon1").style.display="none";
document.getElementById("colon").style.display="none";
document.getElementById("colon3").style.display="";
document.getElementById("colon2").style.display="";
//document.forms[0].db_conn_string1.style.display="none";
   // document.forms[0].db_conn_string2.style.display="none";
					///	document.forms[0].db_conn_string3.style.display="none";
			//		document.forms[0].db_conn_string1.disabled=true;
//document.forms[0].db_conn_string2.disabled=true;
//document.forms[0].db_conn_string3.disabled=true;
document.forms[0].DBconnection_string_txt.value="";

//	url = "../../eXI/jsp/InterfaceParamsetupAdminCheckbox.jsp?";
	
   /// var ret = window.showModalDialog(url,arguments,features); 


//document.forms[0].db_conn_string_txt.value=ret;

	}
	else
	{
		this.document.forms[0].rac_cluster.value='N';
		
		document.getElementById("colon").style.display="";
document.getElementById("colon1").style.display="";
document.getElementById("colon2").style.display="none";
document.getElementById("colon3").style.display="none";

		//document.forms[0].db_conn_string1.style.display="block";
    //document.forms[0].db_conn_string2.style.display="block";
		//				 document.forms[0].db_conn_string3.style.display="block";
document.forms[0].db_conn_string1.disabled=false;
document.forms[0].db_conn_string2.disabled=false;
document.forms[0].db_conn_string3.disabled=false;
document.forms[0].db_conn_string1.value='';
document.forms[0].db_conn_string2.value='';
document.forms[0].db_conn_string3.value='';


	} 

} 
