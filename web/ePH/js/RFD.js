  var result		= false ;
var message		= "" ;
var flag		= "" ;
var mode=0;

var firstTime=true;
var pageNum=1;
var totalRows=0;
// contains the number of records per page
var pageSize=10;

function create() {
	mode=1;
	RFDFrame.location.href="../../ePH/jsp/RFDMiddleFrame.jsp?mode="+MODE_INSERT;
}

async function DrugSearch( target ) {
    var argumentArray  = new Array() ;
    var dataNameArray  = new Array() ;
    var dataValueArray = new Array() ;
    var dataTypeArray  = new Array() ;

/*	dataNameArray[0]   = "FACILITY_ID" ;
    dataValueArray[0]  = document.formPHGenerateFillList.facility_id.value;
	dataTypeArray[0]   = STRING ;

	dataNameArray[1]   = "RTN_ORD_DISP_LOCN_CODE" ;
    dataValueArray[1]  = document.formPHGenerateFillList.Disp_Locn.value;
	dataTypeArray[1]   = STRING;
*/

	argumentArray[0]   = document.formRFDDrug.drug_name_query.value;

    argumentArray[4]   = "1,2";

    argumentArray[1]   = dataNameArray ;
    argumentArray[2]   = dataValueArray ;
    argumentArray[3]   = dataTypeArray ;
	argumentArray[5]   = target.value ;
    argumentArray[6]   = DESC_LINK ;
    argumentArray[7]   = CODE_DESC ;

	retVal=await CommonLookup(getLabel("ePH.DrugSearch.label","PH"), argumentArray );
	
	var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if (retVal!="")
	{
		target.value = arr[1];
		document.formRFDDrug.drug_code.value=arr[0];
		target.disabled=true;
		document.formRFDDrug.drug_name_button.disabled=true;
		loadButtonandDetailFrame();

	}


}
//This function loads the button frame and the detail frame based on the drug code selected
function loadButtonandDetailFrame()
{

	var code	=	document.formRFDDrug.drug_code.value;
	//parent.f_buttons.location.href="../../ePh/jsp/RFDButtons.jsp?form_code="+code;
	parent.f_RFDDetails.location.href="../../ePH/jsp/RFForDrug.jsp?drug_code="+code+"&mode="+MODE_INSERT;
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";

}
//This function is called on click of the select button

function callSelect()
{

	document.getElementById("association_col").className="TDNORMAL";
	document.getElementById("select_col").className="TDCLICKED";
	pageNum=1;
	displayPage(1);


}
function setColumnClass(rowObj,className)
{
			rowObj.children[0].className=className;
			rowObj.children[1].className=className;
			rowObj.children[2].className=className;
			rowObj.children[3].className=className;
			rowObj.children[4].className=className;
			rowObj.children[5].className=className;

}
function setColumnColor(rowObj,color)
{
			rowObj.children[0].style.color=color;
			rowObj.children[1].style.color=color;
			rowObj.children[2].style.color=color;
		
}
function callAssociation()
{
	document.getElementById("association_col").className="TDCLICKED";
	document.getElementById("select_col").className="TDNORMAL";
	isNoRows=true;
	count=0;
	// Display only selected things 
	rowObj=document.querySelectorAll("#ROW");
	selectObj=document.querySelectorAll("#SELECT");

	for (i=0;i<totalRows;i++ )
	{
		if(selectObj[i]==null) {
			selectObj[i]	=	selectObj;
		}
		if(rowObj[i]==null) {
			rowObj[i]	=	rowObj;
		}
		if(document.formReconstituentFluid.Associated[i]==null) {
			document.formReconstituentFluid.Associated[i]=document.formReconstituentFluid.Associated;
		}

		if (selectObj[i].checked==true)
		{
			rowObj[i].style.display="";
			count++;
			//This is for checking if the row comes from the database or not...if it comes from the database, it is displayed in red color
	
			if (count%2==0)
			{
				setColumnClass(rowObj[i],"QRYODD");
			
			}
			else
			{
				setColumnClass(rowObj[i],"QRYEVEN");
				if (document.formReconstituentFluid.Associated[i].value=='Y')
				{
							setColumnColor(rowObj[i],"RED");
				}


			}

			isNoRows=false;
		}
		else
		{
				rowObj[i].style.display="none";
		}

	}
	document.getElementById("next").style.display="none";
	document.getElementById("prev").style.display="none";
	if (isNoRows)
	{
		alert (getMessage("NO_RECORDS_HAVE_BEEN_SELECTED","PH"));
		callSelect();
	}
}
function displayPage(pagenum)
{
	//This is the total no of rows in the page
totalRows=parseInt(document.formReconstituentFluid.tot_rows.value);
rowObj=document.getElementById("ROW");
endNo=parseInt(pagenum)*parseInt(pageSize);
startNo=parseInt(endNo)-parseInt(pageSize)+1;

document.formReconstituentFluid.totalrows.value=totalRows;

if (endNo>totalRows)
{
	endNo=totalRows;
}


//As form length starts with 0 and here we have calculated with 1 as starting point, reduce 1 from startNo and endNo


endNo=parseInt(endNo)-1
startNo=parseInt(startNo)-1


for (j=0;j<totalRows ;j++ )
{
	if ((j>=startNo)&&(j<=endNo))
	{
			if(rowObj[j]==null) {
				rowObj[j]	=	rowObj;
			}

			rowObj[j].style.display="";
			if (j%2==0)
			{
				setColumnClass(rowObj[j],"QRYEVEN");
			}
			else
			{
				setColumnClass(rowObj[j],"QRYODD");
			}
			if(document.formReconstituentFluid.Associated[j]==null) {
				if (document.formReconstituentFluid.Associated.value=='Y'){
					setColumnColor(rowObj[j],"RED");
				}
			} else {
				if (document.formReconstituentFluid.Associated[j].value=='Y'){
					setColumnColor(rowObj[j],"RED");
				}
			}



	}
	else
	{
		rowObj[j].style.display="none";
	}
}
//For displaying the previous and next buttons


document.getElementById("prev").style.display="none";
document.getElementById("next").style.display="none";

if (parseInt(endNo)+1<totalRows)
{
	document.getElementById("next").style.display="";

}
if (parseInt(startNo)+1>1)
{
	document.getElementById("prev").style.display="";

}


}
function goNext()
{
pageNum++;
displayPage(pageNum);
}
function goPrev()
{
pageNum--;
displayPage(pageNum);
}
async function showInfo(sel)
{
	//sel is the index of selected info..we populate the info which is already there in the modal dialogbox and the returned value in the corresponding RFINfo  hidden field
	var bean_id = "RFDBean" ;
	var bean_name = "ePH.RFDBean";
	var dialogHeight= "12" ;
	var dialogWidth	= "15" ;
	var dialogTop = "169" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments=new Array();
	if(document.formReconstituentFluid.RFINFO[sel]==null) {
		val=document.formReconstituentFluid.RFINFO;
		
	} else {
		val=document.formReconstituentFluid.RFINFO[sel];
		
	}

	arguments[0]=val;
	retVal = await window.showModalDialog("../../ePH/jsp/RFDInfo.jsp?bean_id="+bean_id+"&bean_name="+bean_name,arguments,features);
	
	if (retVal!="&") {
		if(document.formReconstituentFluid.RFINFO[sel]==null) {
			document.formReconstituentFluid.RFINFO.value=retVal;
		} else {
			if(retVal!=undefined){ //Added for 15181
				document.formReconstituentFluid.RFINFO[sel].value=retVal;
			}
		}
	} 
	//alert("retVal--->"+retVal+"  ---"+document.formReconstituentFluid.RFINFO[sel].value);
} 

function selectCheck(sel,obj)
{
	defaultObj=document.formReconstituentFluid.DEFAULT;

	if (obj.checked==true)
	{
		if (document.formReconstituentFluid.RFQTY[sel]==null) {
			if (document.formReconstituentFluid.RFQTY.value=="") {
				document.formReconstituentFluid.RFQTY.value="0";
			}
		} else {
			if (document.formReconstituentFluid.RFQTY[sel].value=="") {
				document.formReconstituentFluid.RFQTY[sel].value="0";
			}
		}
		return;
	}
	if(defaultObj[sel]==null) {
		defaultObj.checked=false;
	} else {
		defaultObj[sel].checked=false;
	}
	
}


function defaultCheck(sel,obj)
{
	defaultObj=document.formReconstituentFluid.DEFAULT;
	if (obj.checked==false)
	{
		return;
	}
	for (i=0;i<totalRows;i++ )
	{
		if (i!=sel)
		{
			defaultObj[i].checked=false;
		}
		
	}
	// also set the corresponding 'select' check box to checked
	if(document.formReconstituentFluid.SELECT[sel]==null) {
		document.formReconstituentFluid.SELECT.checked=true;
		if (document.formReconstituentFluid.RFQTY.value=="") {
				document.formReconstituentFluid.RFQTY.value="0";
		}
	} else {
		document.formReconstituentFluid.SELECT[sel].checked=true;
		if (document.formReconstituentFluid.RFQTY[sel].value=="")
		{
				document.formReconstituentFluid.RFQTY[sel].value="0";
		}
	}
	
}
function query(){
	mode=3;
	RFDFrame.location.href="../../ePH/jsp/RFDQueryCriteria.jsp?function_id=Reconstituent Fluid for drug" ;
}

function apply()
{
		//Nothing to validate..directly call insert method
		
		if ((RFDFrame.frames.length>0)&&(RFDFrame.f_RFDDetails.document.forms.length>0))
		{
				var frmobj =RFDFrame.f_RFDDetails.document.formReconstituentFluid;
				var errorPage	= "../../eCommon/jsp/error.jsp" ;

				//alert(formApplyRFD(frmobj, PH_CONTROLLER) ) ;
				eval(formApplyRFD(frmobj, PH_CONTROLLER) ) ;
				//alert(formApplyRFD(frmobj, PH_CONTROLLER) ) ;

				if (result){
						onSuccess(frmobj);
				}


		}
		else
		{
			//this.commontoolbarFrame.location.reload();
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
			return false;
		}

}
function onSuccess(frmobj)
{
			//alert("THIS IS THE MESSGE"+message);
			create();
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
		

}
function reset()
{
	if (mode==1)
	{
			create();
	}
	else if (mode==3)
	{
		 url=RFDFrame.document.location.href;
		
		if (url.indexOf("RFDQueryCriteria.jsp")!=-1)
		{
					query();
		}

	}

}


//Creating own formApply function here to handle check boxes.This function is created primarily because the common function does not handle arrays of checkboxes
function formApplyRFD(frmObj,controllerJSP){

    var xmlDoc="";
    var xmlHttp = new XMLHttpRequest();
    var xmlStr ="<root><SEARCH ";
    var arrObj = frmObj.elements;
	var updateableCount=0;
	
	//First add all the hidden elements except RFInfo ,Associated and RFId

     for(var i=0;i<arrObj.length;i++) {
            var val = "" ;
			myObj=arrObj[i];
			if (myObj.type=="hidden")
			{
				if (( myObj.name=="RFINFO")||(myObj.name=="RFID")||(myObj.name=="Associated") )
				{
							continue;
				}
				else
				{
					val = myObj.value;
		             xmlStr+= myObj.name+"=\"" + checkSpl(val) + "\" " ;
				}
					
			}

          }//end of elements loop
		  // now add check boxes
		  trows=frmObj.totalrows.value;
		  count=0;

		  for (i=0;i<trows;i++ )
		  {
			  //check if value has to be passed to the bean for operation
			
				if(frmObj.Associated[i]==null) {
					myObj=frmObj.Associated;
				} else {
					myObj=frmObj.Associated[i];
				}
				val = myObj.value;

				if(frmObj.SELECT[i]==null) {
					myObj1=frmObj.SELECT;
				} else {
					myObj1=frmObj.SELECT[i];
				}

				if (myObj1.checked)	{
					val1='Y'
				} else {
					val1='N';
				}

				/* If it was already associated in the db,and now its removed we have to pass the value*/

				if  (myObj1.checked==false)
				{
					if (val=='N')
					{
							continue;
					}
				}
				
				updateableCount++;

				xmlStr+= myObj.name+(count+1)+"=\"" + checkSpl(val) + "\" " ;
		        xmlStr+= myObj1.name+(count+1)+"=\"" + checkSpl(val1) + "\" " ;
				if(frmObj.DEFAULT[i]==null) {
					myObj=frmObj.DEFAULT;
				} else {
					myObj=frmObj.DEFAULT[i];
				}

				if (myObj.checked) {
					val='Y'
				} else {
					val='N';
				}
		        xmlStr+= myObj.name+(count+1)+"=\"" + checkSpl(val) + "\" " ;
		
				if(frmObj.RFQTY[i]==null) {
					myObj=frmObj.RFQTY;
				} else{
					myObj=frmObj.RFQTY[i];
				}
				val = myObj.value;
		        xmlStr+= myObj.name+(count+1)+"=\"" + checkSpl(val) + "\" " ;

				if(frmObj.RFINFO[i]==null) {
					myObj=frmObj.RFINFO;
					//alert("if--->myObj--->"+myObj+"valva===in apply=="+myObj.value);
				} else {
					myObj=frmObj.RFINFO[i];
					//alert("else----->myObj--->"+myObj+"valva===in apply=="+myObj.value);
				}

				val = myObj.value;
				
		        xmlStr+= myObj.name+(count+1)+"=\"" + checkSpl(val) + "\" " ;

				if(frmObj.RFID[i]==null) {
					myObj=frmObj.RFID;
				} else {
					myObj=frmObj.RFID[i];
				}

				val = myObj.value;
		        xmlStr+= myObj.name+(count+1)+"=\"" + checkSpl(val) + "\" " ;

				count++;

		  }
		
        xmlStr+= "UpdateableRows=\"" + updateableCount + "\" " ;
		xmlStr +=" /></root>";
//	  return;
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    beforePost(xmlStr) ;
    xmlHttp.open("POST", controllerJSP, false);
    xmlHttp.send(xmlDoc);
	return xmlHttp.responseText  ;

 
}

function assignResult( result1, message1, flag1 ,temp) {
	result	= result1 ;
    message	= message1 ;
    flag	= flag1 ;
}

function beforePost(xmlstr) {
//	alert("str"+xmlstr);
}

function noFluidsAvailable()
{ alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","PH"));
return;		
	//alert(getMessage("NO_FLUIDS_AVAILABLE","PH"));
}
