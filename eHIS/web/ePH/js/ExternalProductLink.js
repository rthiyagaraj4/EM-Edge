  //saved on 07/11/2005
var result		= false ;
var message		= "" ;
var flag		= "" ;
var mode=0;

var firstTime=true;
var pageNum=1;
var totalRows=0;


var startpos=new Array();
startpos[0]=0;

function create() {
	mode=1;
	f_query_add_mod.location.href="../../ePH/jsp/ExternalProductLinkFrames.jsp?mode="+MODE_MODIFY;
}
function query() {
	mode=3;
	f_query_add_mod.location.href="../../ePH/jsp/ExternalProductLinkQueryCriteria.jsp?function_id=External Product Link" ;
}

//Generic Name lookup
function searchGenericName(obj){
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0]   =document.FormExtProductCriteria.lookup_query.value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   =obj.value;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ; 
	retVal = await CommonLookup( "Generic Name", argumentArray );
	if(retVal != null && retVal != "" )  {
		obj.value = retVal[1] ;
		document.FormExtProductCriteria.ext_generic_name.value=retVal[1];
		document.FormExtProductCriteria.generic_code.value = retVal[0];
	//	obj.disabled	=	true;
		}

}
function noDrugs()
{
alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA"));
parent.FrameCriteria.FormExtProductCriteria.mm_generic_name.select();
parent.FrameCriteria.FormExtProductCriteria.mm_generic_name.focus();
parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
}


//This function loads the button frame and the detail frame based on the drug code selected
function callResultPage()
{
	//Check for ext database-mandatory
	var formObj	=	document.FormExtProductCriteria;
	
	var fields=new Array();
	fields[0]=formObj.ext_generic_name;
	fields[1]=formObj.mm_generic_name;

	var names=new Array();
	names[0]="External Database-Generic Name";
	names[1]="eHIS Database-Generic Name";

	var errorPage	= "../../eCommon/jsp/MstCodeError.jsp" ;
	
	var blankObject  = getBlankField( fields, names, parent.parent.messageFrame, errorPage) ;
	
	if (blankObject==null)
	{
	codename=formObj.mm_generic_name.value;
	extgeneric=formObj.ext_generic_name.value;
	parent.FrameAction.location.href="../../ePH/jsp/ExternalProductDrug.jsp?generic_name="+codename+"&ext_generic="+extgeneric+"&mode="+MODE_MODIFY;
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
	
	}
}
function changeGroupValues(groupno,obj)
{
	groupno=parseInt(groupno);
	formobj=document.FormExternalProductDrug;	
	//get the product id for the entire group
	prodid=eval("document.FormExternalProductDrug.productGroup"+groupno).value;
	len=startpos.length;
	stval=startpos[groupno];
	endval=startpos[groupno]+1;
	
	//check if this is the last group..for the last group the end value will not be specified
	if (groupno==len-1)
	{
		endval=formobj.totalrows.value;
		for (i=stval;i<=endval ;i++ )
		{
			obj1=eval("document.FormExternalProductDrug.FROMDB"+i);
			if (typeof(obj1)=="object")
			{
				fromdb=obj1.value;
				if (fromdb!='Y')
				{
							eval("document.FormExternalProductDrug.RECORD"+i).value=obj.value;
							eval("document.FormExternalProductDrug.EXTPRODUCTID"+i).value=prodid;
							eval("document.FormExternalProductDrug.chkRECORD"+i).checked=true;
				}

			}

		}

	}
	else
	{
		endval=startpos[groupno+1];
		for (i=stval;i<endval ;i++ )
		{
			fromdb=eval("document.FormExternalProductDrug.FROMDB"+i).value;
			if (fromdb!='Y')
			{
						eval("document.FormExternalProductDrug.RECORD"+i).value=obj.value;
						eval("document.FormExternalProductDrug.EXTPRODUCTID"+i).value=prodid;
						eval("document.FormExternalProductDrug.chkRECORD"+i).checked=true;
			}

		}

	}




}
function selectGroup (groupno,obj)
{
	if (obj.checked==false)
	{
		return;
	}
	groupno=parseInt(groupno);
	formobj=document.FormExternalProductDrug;	
	len=startpos.length;
	stval=startpos[groupno];
	endval=startpos[groupno]+1;
	
	//check if this is the last group..for the last group the end value will not be specified
	if (groupno==len-1)
	{

		endval=formobj.totalrows.value;
		for (i=stval;i<=endval ;i++ )
		{
			obj=eval("document.FormExternalProductDrug.chkRECORD"+i);

			if (typeof(obj)=="object")
			{
							obj.checked=true;
			}

		}

	}
	else
	{
		endval=startpos[groupno+1];
		for (i=stval;i<endval ;i++ )
		{
			obj=eval("document.FormExternalProductDrug.chkRECORD"+i);
			obj.checked=true;
		}

	}


}
function deSelectGroup (groupno,obj)
{
	if (obj.checked==true)
	{
		return;
	}
    nobj=eval("document.FormExternalProductDrug.chkGROUP"+groupno);
	nobj.checked=false;
	
}
function checkValidExternalProduct(val)
{
	return true;
}
function externalProductLookup(objstr,routedesc,num,groupnum)
{

	obj						=	eval(objstr);

    var argumentArray  = new Array() ;
    var dataNameArray  = new Array() ;
    var dataValueArray = new Array() ;
    var dataTypeArray  = new Array() ;

	dataNameArray[0]   = "GENERIC_ID" ;
	dataValueArray[0]  = document.FormExternalProductDrug.GENERIC_ID.value;
	dataTypeArray[0]   = STRING ;

	dataNameArray[1]   = "ROUTE_CODE" ;
    dataValueArray[1]  = routedesc;
	dataTypeArray[1]   = STRING;

	argumentArray[0]   = document.FormExternalProductDrug.external_lookup_query.value;

    argumentArray[4]   = "3,4";

    argumentArray[1]   = dataNameArray ;
    argumentArray[2]   = dataValueArray ;
    argumentArray[3]   = dataTypeArray ;
	argumentArray[5]   = obj.value ;
	// if the record comes from the database,we should allow it to be changed.therefore, we set the text to null
	if (num!=0)
	{
			if (eval("document.FormExternalProductDrug.FROMDB"+num).value=='Y')
			{
				argumentArray[5]   = "";
			}

	}

    argumentArray[6]   = DESC_LINK ;
    argumentArray[7]   = DESC_CODE ;

	retVal=CommonLookup('External Product Search', argumentArray );
	if (retVal!="")
	{
		obj.value = retVal[1];

		if (num!=0)
		{
			eval("document.FormExternalProductDrug.EXTPRODUCTID"+num).value=retVal[0];
			eval("document.FormExternalProductDrug.chkRECORD"+num).checked=true;
		}
		else if (groupnum!=0)
		{
			eval("document.FormExternalProductDrug.productGroup"+groupnum).value=retVal[0];
			changeGroupValues(groupnum,eval("document.FormExternalProductDrug.GROUP"+groupnum));
		}

	}

}

/*******************************************************************************************/
//This function is called on click of the select button

function apply()
{
		var proceed=false;
		url=f_query_add_mod.location.href;
		if ((url.indexOf("blank.html")==-1)&&(url.indexOf("Query")==-1))
		{
				url=f_query_add_mod.FrameAction.location.href;
				if (url.indexOf("blank.html")==-1)
				{
					var frmobj =f_query_add_mod.FrameAction.document.FormExternalProductDrug;
					//Check if atleast one check box is selected
					for (i=1;i<=frmobj.totalrows.value ;i++ )
					{
						chkobj=eval("frmobj.chkRECORD"+i);
						if (chkobj.checked==true)
						{
							proceed=true;
							break;
						}
					}
					if (proceed)
					{
								var errorPage	= "../../eCommon/jsp/MstCodeError.jsp" ;
								eval(formApply(frmobj, PH_CONTROLLER) ) ;
								if (result){
										onSuccess(frmobj);
								}
								return;

					}
					else
					{
								alert(getMessage("PH_ATLEAST_ONE_SELECTED"));
					}

				}
		}
		//this.commontoolbarFrame.location.reload();
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
}
function onSuccess(frmobj)
{
			create();
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
		

}
function reset()
{
		url=f_query_add_mod.location.href;
		if (url.indexOf("blank.html")==-1)
		{
			if (mode==1)
			{
				create();
			}
			if ((mode==3)&&(url.indexOf("Result")==-1))
			{
				query();
			}
		}
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;

}


function assignResult( result1, message1, flag1 ,temp) {
	result	= result1 ;
    message	= message1 ;
    flag	= flag1 ;
}