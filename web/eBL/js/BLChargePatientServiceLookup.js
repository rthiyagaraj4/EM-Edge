async function servClassLkup(serv_class_desc,serv_class_code,empty_chk)
{		
	//alert("entServGrpLkup");
	if(empty_chk=='Y' && serv_class_desc.value=='')
	{
		return false;
	}
	var locale  = document.forms[0].locale.value;		
	var facility_id  = document.forms[0].facility_id.value;			
	var target			= document.forms[0].serv_class;		
	var serv_code=document.forms[0].serviceCode.value;		

//	alert("target>>>>"+target);
	var retVal			=  new String();
	var dialogTop	= "40";
	var dialogHeight		= "10" ;
	var dialogWidth	= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var search_desc			= "";
	var title			= 'Service Classification';
	
	//var sql1="SELECT SERV_CLASSIFICATION_CODE CODE,SHORT_DESC description FROM BL_SERV_CLASSIFICATION_LANG_VW WHERE NVL(STATUS,'N')='N' and language_id='"+locale+"'	and (UPPER(SUBSTR(SERV_CLASSIFICATION_CODE,1,2))) ='"+serv_code+"' ";
	
	//var sql1="SELECT DISTINCT G.NURSING_UNIT_CODE code, G.SHORT_DESC description FROM IP_NURSING_UNIT_LANG_VW G, IP_OPEN_EPISODE I WHERE G.FACILITY_ID ='"+facility_id+"' AND G.NURSING_UNIT_CODE = i.CUR_WARD_CODE AND UPPER(G.LANGUAGE_ID) = UPPER('"+locale+"') and upper(G.NURSING_UNIT_CODE) like upper(?) and upper(G.SHORT_DESC) like upper(?) order by 1";
	
	var sql1;
	
	if($.trim(serv_code) == ''){
		sql1 = "SELECT SERV_CLASSIFICATION_CODE Code,SHORT_DESC description FROM BL_SERV_CLASSIFICATION_LANG_VW WHERE NVL(STATUS,'N')='N' and language_id='"+locale+"'   and upper(SERV_CLASSIFICATION_CODE) like upper(?) and upper(SHORT_DESC) like upper(?) order by 1";
	}else{
		sql1 = "SELECT SERV_CLASSIFICATION_CODE Code,SHORT_DESC description FROM BL_SERV_CLASSIFICATION_LANG_VW WHERE NVL(STATUS,'N')='N' and language_id='"+locale+"'  and (UPPER(SUBSTR(SERV_CLASSIFICATION_CODE,1,2))) ='"+serv_code+"' and upper(SERV_CLASSIFICATION_CODE) like upper(?) and upper(SHORT_DESC) like upper(?) order by 1";
	}

	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql1;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
    argArray[5] = serv_class_desc.value;				
	argArray[6] = DESC_LINK;
	argArray[7] = DESC_CODE;			
	
	retArray = await CommonLookup( title, argArray );		
	var ret1=unescape(retArray);
		 	arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}

	if(retArray != null && retArray !="")
	{					
		
		serv_class_code.value=arr[0];
		serv_class_desc.value=arr[1];								
	}
	else
	{
		serv_class_code.value=arr[1];
		serv_class_desc.value=arr[0];	
	}
	
}



async function billingServLkup(billserv_desc,billserv_code,empty_chk)
{		
	if(empty_chk=='Y' && billserv_desc.value=='')
	{
		return false;
	}
	var locale  = document.forms[0].locale.value;		
	var facility_id  = document.forms[0].facility_id.value;		
	
	var target			= document.forms[0].entServGrp;
	var serv_code=document.forms[0].serviceCode.value;	
	var retVal			=  new String();
	var dialogTop	= "40";
	var dialogHeight		= "10" ;
	var dialogWidth	= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var search_desc			= "";
	var title			= 'Billing Services';

	
	var sql1;

	if($.trim(serv_code) == ''){
		sql1 ="SELECT short_desc description,blng_serv_code code FROM bl_blng_serv_lang_vw WHERE  nvl(status,'N') != 'S'  AND LANGUAGE_ID = '"+locale+"'  and upper(BLNG_SERV_CODE) like upper(?) and upper(SHORT_DESC) like upper(?) order by 1";
	}else{
		sql1 ="SELECT short_desc description,blng_serv_code code FROM bl_blng_serv_lang_vw WHERE upper(substr(blng_serv_code,1,2)) = upper('"+serv_code+"') and  nvl(status,'N') != 'S'  AND LANGUAGE_ID = '"+locale+"'  and upper(BLNG_SERV_CODE) like upper(?) and upper(SHORT_DESC) like upper(?) order by 1";
	}
	
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql1;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
    argArray[5] = billserv_desc.value;				
	argArray[6] = DESC_LINK;
	argArray[7] = DESC_CODE;		
	retArray =await  CommonLookup( title, argArray );		
	
	retArray = await CommonLookup( title, argArray );		
	var ret1=unescape(retArray);
		 	arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retArray != null && retArray !="")
	{					
		
		billserv_code.value=arr[0];
		billserv_desc.value=arr[1];								
	}
	else
	{
		billserv_code.value=arr[1];
		billserv_desc.value=arr[0];	
	}
	
}
async function entServGrpLkup(entServGrp_desc,entServGrp_code,empty_chk)
{		
	if(empty_chk=='Y' && entServGrp_desc.value=='')
	{
		return false;
	}
	var locale  = document.forms[0].locale.value;		
	var facility_id  = document.forms[0].facility_id.value;		
	
	var target			= document.forms[0].ent_serv_grp.value;
	
	var retVal			=  new String();
	var dialogTop	= "40";
	var dialogHeight		= "10" ;
	var dialogWidth	= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var search_desc			= "";
	var title			= getLabel("eBL.EnterpriseServiceGroup.Label","COMMON");

	
	var sql1="SELECT prt_grp_hdr_code code, short_desc description FROM bl_blng_prt_grp_hdr  where  upper(prt_grp_hdr_code) like upper(?) and upper(SHORT_DESC) like upper(?) order by 1";

	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql1;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = entServGrp_desc.value;				
	argArray[6] = DESC_LINK;
	argArray[7] = DESC_CODE;		
	retArray = await CommonLookup( title, argArray );	
		var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
		
	if(retArray != null && retArray !="")
	{					
		
		entServGrp_code.value=arr[0];
		entServGrp_desc.value=arr[1];								
	}
	else
	{
		entServGrp_code.value=arr[1];
		entServGrp_desc.value=arr[0];	
	}
	
}


async function entGrpLineLkup(entGrpLine_desc,entGrpLine_code,empty_chk)
{		
	if(empty_chk=='Y' && entGrpLine_desc.value=='')
	{
		return false;
	}
	var locale  = document.forms[0].locale.value;		
	var facility_id  = document.forms[0].facility_id.value;		
	
	var target			= document.forms[0].entGrpLine;
	var retVal			=  new String();
	var dialogTop	= "40";
	var dialogHeight = "10" ;
	var dialogWidth	= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var search_desc			= "";
	var title			= getLabel("eBL.EntGrpLine.label","COMMON");

	var cprtGrpHdr_code=document.forms[0].entServ_Grp_code.value;	
	
	
	//var sql1="SELECT DISTINCT G.NURSING_UNIT_CODE code, G.SHORT_DESC description FROM IP_NURSING_UNIT_LANG_VW G, IP_OPEN_EPISODE I WHERE G.FACILITY_ID ='"+facility_id+"' AND G.NURSING_UNIT_CODE = i.CUR_WARD_CODE AND UPPER(G.LANGUAGE_ID) = UPPER('"+locale+"') and upper(G.NURSING_UNIT_CODE) like upper(?) and upper(G.SHORT_DESC) like upper(?) order by 1";

	var sql1; 
	
	if($.trim(cprtGrpHdr_code) == ''){
		sql1 ="SELECT prt_grp_line_code code, short_desc description FROM bl_blng_prt_grp_line WHERE  upper(prt_grp_line_code) like upper(?) and upper(SHORT_DESC) like upper(?) order by 1";
	}else{
		sql1 ="SELECT prt_grp_line_code code, short_desc description FROM bl_blng_prt_grp_line WHERE prt_grp_hdr_code  ='"+cprtGrpHdr_code+"' and upper(prt_grp_line_code) like upper(?) and upper(SHORT_DESC) like upper(?) order by 1";
	}
	
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql1;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
    argArray[5] = entGrpLine_desc.value;				
	argArray[6] = DESC_LINK;
	argArray[7] = DESC_CODE;		
	retArray = await CommonLookup( title, argArray );		
	var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}

	if(retArray != null && retArray !="")
	{					
		
		entGrpLine_code.value=arr[0];
		entGrpLine_desc.value=arr[1];								
	}
	else
	{
		entGrpLine_code.value=arr[1];
		entGrpLine_desc.value=arr[0];	
	}
	
}



async function itemLkup(item_desc,item_code,empty_chk)
{		
	if(empty_chk=='Y' && item_desc.value=='')
	{
		return false;
	}
	var locale  = document.forms[0].locale.value;			
	var facility_id  = document.forms[0].facility_id.value;			
	var target			= document.forms[0].item;		
	var retVal			=  new String();
	var dialogTop	= "40";
	var dialogHeight		= "10" ;
	var dialogWidth	= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var search_desc			= "";
	var title			= getLabel("Common.item.label","COMMON");

	
	var sql1="select b.item_code code, b.short_desc description from  bl_st_item a, mm_item b  where  a.item_code = b.item_code and upper(b.item_code) like upper(?) and upper(b.SHORT_DESC) like upper(?) order by 1";	
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql1;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";	
   	argArray[5] = item_desc.value;	
	argArray[6] = DESC_LINK;
	//alert(argArray[6]);
	argArray[7] = DESC_CODE;		
	retArray = await CommonLookup( title, argArray );		
	
	var ret1=unescape(retArray);
	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	
	if(retArray != null && retArray !="")
	{					
		
		item_code.value=arr[0];
		item_desc.value=arr[1];								
	}
	else
	{
		item_code.value=arr[1];
		item_desc.value=arr[0];	
	}
	
}
