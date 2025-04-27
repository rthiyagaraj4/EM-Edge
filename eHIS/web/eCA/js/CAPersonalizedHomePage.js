function callfunction()
{ 
	var target = parent.frame3.document.personalizedPractLookUpForm.qry_sub;
	/*if(target.value =="ALL")
	 {
		target.value = "";
	 }*/
	var serviceVal   = parent.frame3.document.personalizedPractLookUpForm.qry_sub.value;
	var retVal = new String();
	var his_type = parent.frame3.document.personalizedPractLookUpForm.pract_type.value;
	if(his_type=="")
		{
				return parent.frames[0].document.forms[0];
		}
	var search_desc	= "";
	var title			= getLabel("Common.practitioner.label","COMMON");
	whereClause = "and PRACT_TYPE='"+his_type+"'";
	var sql = "SELECT PRACTITIONER_ID code , PRACTITIONER_NAME description  FROM AM_PRACTITIONER WHERE   EFF_STATUS = 'E' and upper(PRACTITIONER_ID) LIKE upper(?) and  upper(PRACTITIONER_NAME) LIKE upper(?) "+whereClause
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	retArray = CommonLookup( "Practitioner Name", argArray );
	if(retArray != null && retArray !="")	
		{
			parent.frame3.document.personalizedPractLookUpForm.qry_sub.value = retArray[1];
			parent.frame3.document.personalizedPractLookUpForm.hid_sub.value = retArray[0];
		}
		else
		{
			parent.frame3.document.personalizedPractLookUpForm.qry_sub.value = getLabel("Common.all.label","Common");
			parent.frame3.document.personalizedPractLookUpForm.hid_sub.value = "*ALL";
		}
	parent.frame3.document.personalizedPractLookUpForm.flag.value='true';
	parent.frame3.document.personalizedPractLookUpForm.look_up.disabled=false;
	parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
 }
function default_value()
{
		parent.resultFrame.location.href = "../../eCommon/html/blank.html";
		document.personalizedPractLookUpForm.qry_sub.value=getLabel("Common.all.label","Common");
		document.personalizedPractLookUpForm.hid_sub.value="*ALL"
		parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
}

function defaultValue()
{
		document.personalizedPractLookUpForm.qry_sub.value=getLabel("Common.all.label","Common");
		document.personalizedPractLookUpForm.hid_sub.value="*ALL"
}
function Search_Value()
{
		var error = new String();
		error = "";
		if(document.personalizedPractLookUpForm.pract_type.value =="")
			{
				error = getMessage("PRACTITIONER_CANNOT_BE_BLANK",'CA');
				parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+error+"&err_value=";
			}
		else
		{
			parent.resultFrame.location.href="CAPersonalizedCriteria.jsp?pract_type="+document.personalizedPractLookUpForm.pract_type.value+"&pract_name="+document. personalizedPractLookUpForm.qry_sub.value+"&hid_sub="+document.personalizedPractLookUpForm.hid_sub.value;
		}
}
function pass_value(qry_sub)
{
	with(document.personalizedPractLookUpForm)
	   {
			if(document.personalizedPractLookUpForm.pract_type.value =="")
			{
				if(qry_sub.value == "")
				{
					qry_sub.value=getLabel("Common.all.label","Common");
					hid_sub.value = "*ALL"
					document.personalizedPractLookUpForm.flag.value='true'
					return false
				}
				else
				{
					error = getMessage("PRACTITIONER_CANNOT_BE_BLANK",'CA');
					parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+error+"&err_value=";
					return false;
				}
				
			}
			else	if(qry_sub.value==getLabel("Common.all.label","Common"))
			   {
					document.personalizedPractLookUpForm.flag.value='true'
					return false
			   }
				else if(qry_sub.value == "")
				{
					
					qry_sub.value=getLabel("Common.all.label","Common");
					hid_sub.value = "*ALL"
					document.personalizedPractLookUpForm.flag.value='true'
					parent.resultFrame.location.href	= "../../eCommon/html/blank.html";
					return false
				}
				parent.messageFrame.document.write("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()' class=MESSAGE><form name='tempform' id='tempform' method='post' action='CAPersonalizedQueryResult.jsp'><input type=hidden name='pract_id' id='pract_id' value='"+pract_type.value+"'><input type=hidden name='pract_name' id='pract_name' value='"+qry_sub.value+"'><input type=hidden name='selFunVal' id='selFunVal' value='Pract'> </form></body></html>");
				parent.messageFrame.tempform.submit();
	}
}
async function validate()
{
var error = new String();
	error = "";		
	document.personalizedPractLookUpForm.flag.value ="false"
	if(document.personalizedPractLookUpForm.pract_type.value =="")
	{
		error = getMessage("PRACTITIONER_CANNOT_BE_BLANK",'CA');
		parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+error+"&err_value=";
		return false;
	}
	var target = document.personalizedPractLookUpForm.qry_sub;
	target.value=""
	var serviceVal   = document.personalizedPractLookUpForm.qry_sub.value;
	var retVal = new String();
	var his_type = document.personalizedPractLookUpForm.pract_type.value;
	var search_desc	= "";
	var title			= getLabel("Common.practitioner.label","COMMON");
	whereClause = "and PRACT_TYPE='"+his_type+"'";
	var sql = "SELECT PRACTITIONER_ID code , PRACTITIONER_NAME description  FROM AM_PRACTITIONER WHERE   EFF_STATUS = 'E' and upper(PRACTITIONER_ID) LIKE upper(?) and  upper(PRACTITIONER_NAME) LIKE upper(?) "+whereClause
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
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
			document.personalizedPractLookUpForm.qry_sub.value = arr[1];
			document.personalizedPractLookUpForm.hid_sub.value = arr[0];
		}
		else
		{
			document.personalizedPractLookUpForm.qry_sub.value = getLabel("Common.all.label","Common");
			document.personalizedPractLookUpForm.hid_sub.value = "*ALL";
		}
	document.personalizedPractLookUpForm.look_up.disabled=false;
	document.personalizedPractLookUpForm.flag.value='true';
	parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
}
function getPractitionerName()
{

	
	if(document.personalizedPractLookUpForm.flag.value !="true")
	{
		return false
	}
	else
	{
		validate()		
	}
}
function disableApplicableCheckBox(objCheck)
{
	var i = 0
	var j = 0;
	for(i = 0 ; i < document.personalizedCriteriaForm.check_value.length ; i++)
	{
		if(document.personalizedCriteriaForm.check_value(i).checked == false)
		{
			j++;
		}
	}
	if(j==document.personalizedCriteriaForm.check_value.length)
		{
			document.personalizedCriteriaForm.defalut_check.checked = false;
		}
}
function CheckAllBox()
{
		if(document.personalizedCriteriaForm.defalut_check.checked == true )
		{	
				for (var i=0;i<document.personalizedCriteriaForm.check_value.length;i++)
					{
							document.personalizedCriteriaForm.check_value(i).checked = true
					}	
		}
		else
		{	
				for (var i=0;i<document.personalizedCriteriaForm.check_value.length;i++)
					{
							document.personalizedCriteriaForm.check_value(i).checked = false

					}	
		}
}
function create()
{
		frame3.location.href = "../../eCA/jsp/CAPersonalizedPractLookup.jsp?mode=insert";
}
function query()
{
	 frame3.location.href='../../eCA/jsp/CAPersonalizedCriteria.jsp';
}
function apply()
{		
		if(frame3.document.personalizedPractLookUpForm!=null)
	{
		var error = new String();
		error = "";
		
	 /* if(frame3.document.personalizedPractLookUpForm.pract_type.value=="")
	 {
		error = getMessage("PRACTITIONER_CANNOT_BE_BLANK",'CA');
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+error+"&err_value=";
	 }
		
	  else
	  {
		  alert("it enters");
		frame3.document.personalizedPractLookUpForm.submit();
	  }*/

	  if(frame3.document.personalizedPractLookUpForm.mode.value == "insert"){
		var fields = new Array (frame3.document.personalizedPractLookUpForm.pract_type,frame3.document.personalizedPractLookUpForm.desk_sub);
		var names = new Array ( getLabel("Common.practitionertype.label",'common'),getLabel("eCA.Desktop.label",'ca'));
		
		if(frame3.checkFieldsofMst( fields, names, messageFrame)){
			frame3.document.personalizedPractLookUpForm.submit();	
		}
	}
	
	else if(frame3.document.personalizedPractLookUpForm.mode.value == "modify"){
		var fields = new Array (frame3.document.personalizedPractLookUpForm.pract_type,frame3.document.personalizedPractLookUpForm.desk_sub);	

		var names = new Array ( getLabel("Common.practitionertype.label",'common'),getLabel("eCA.Desktop.label",'ca'));

		if(frame3.checkFieldsofMst( fields, names, messageFrame)) {
			frame3.document.personalizedPractLookUpForm.submit();	
		}
	}
   }
	else
	{
		//alert("here2");
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=';
		return false;
	}
}
		

function reset()
{
	frame3.location.reload();
	frame3.location.href="../../eCommon/html/blank.html";
}
function onSuccess()
{
		frame3.location.reload();
		frame3.location.href="../../eCommon/html/blank.html";
}

//functions forCAPersonalizedPractLookup.jsp-starts
function setValue()
{
	document.forms[0].flag.value='false'
}
function getValue()
{
	if(document.forms[0].qry_sub.value==getLabel("Common.all.label","Common"))
	{
		document.forms[0].flag.value='true'
	}
}

//functions forCAPersonalizedPractLookup.jsp-ends

//functions for delete button-start

function deleterecord()
{

	if(frame3.document.personalizedPractLookUpForm!=null && frame3.document.personalizedPractLookUpForm.mode!=null)
	{

		if(frame3.document.personalizedPractLookUpForm.mode.value != 'insert')
		{
			frame3.document.personalizedPractLookUpForm.mode.value = 'delete';
			
			var confmsg = frame3.getMessage("DELETE_RECORD",'common');
			var confirmDelete = window.confirm(confmsg);

			if(confirmDelete==true)
			{
				frame3.document.personalizedPractLookUpForm.pract_type.disabled=false;
				frame3.document.personalizedPractLookUpForm.qry_sub.disabled=false;
				frame3.document.personalizedPractLookUpForm.submit();
				frame3.location.href = "../../eCA/jsp/CAPersonalizedPractLookup.jsp?mode=insert";

			}
			else
				commontoolbarFrame.location.reload();
		}
		else
		{
				var errorMsg =frame3.getMessage("RECORD_CANNOT_DELETE",'CA');
				messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+errorMsg;

		}
	}
	else
	{
		messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_val=1&err_num= ';
	}
}

//functions DesktopLookup-start

function setValue1()
{
	document.forms[0].flag.value='false'
}
function getValue1()
{
	if(document.forms[0].desk_sub.value==getLabel("Common.all.label","Common"))
	{
		document.forms[0].flag.value='true'
	}
}
function validatedesktop()
{
var error = new String();
	error = "";		
	document.personalizedPractLookUpForm.flag.value ="false"
	if(document.personalizedPractLookUpForm.pract_type.value =="")
	{
		error = getMessage("PRACTITIONER_CANNOT_BE_BLANK",'CA');
		parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+error+"&err_value=";
		return false;
	}
	var target = document.personalizedPractLookUpForm.desk_sub;
	target.value=""
	var serviceVal   = document.personalizedPractLookUpForm.desk_sub.value;
	var retVal = new String();
	var search_desc	= "";
	var title			= getLabel("eCA.Desktop.label","CA")

    var sql="SELECT DESKTOP_SUMMARY_ID code, DESKTOP_SUMMARY_NAME description FROM SM_DESKTOP_SUM_HDR WHERE DESKTOP_SUMMARY_TYPE = 'C' AND EFF_STATUS='E' and upper(DESKTOP_SUMMARY_ID) LIKE upper(?) and  upper(DESKTOP_SUMMARY_NAME) LIKE upper(?) order by 2";

	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	retArray = CommonLookup( title, argArray );
	if(retArray != null && retArray !="")	
		{
			document.personalizedPractLookUpForm.desk_sub.value = retArray[1];
			document.personalizedPractLookUpForm.hid_sub1.value = retArray[0];
		}
	document.personalizedPractLookUpForm.look_up1.disabled=false;
	document.personalizedPractLookUpForm.flag.value='true';
	parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
}
function getDesktopName()
{	
	if(document.personalizedPractLookUpForm.flag.value !="true")
	{
		return false
	}
	else
	{
		validatedesktop()		
	}
}


function desk_value(desk_sub)
{
	with(document.personalizedPractLookUpForm)
	   {
			if(document.personalizedPractLookUpForm.pract_type.value =="")
			{
				if(desk_sub.value == "")
				{
					//desk_sub.value=getLabel("Common.all.label","Common");
					//hid_sub1.value = "*ALL"
					document.personalizedPractLookUpForm.flag.value='true'
					return false
				}
				else
				{
					error = getMessage("PRACTITIONER_CANNOT_BE_BLANK",'CA');
					parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+error+"&err_value=";
					return false;
				}
				
			}
			/*else if(desk_sub.value==getLabel("Common.all.label","Common"))
			   {
					document.personalizedPractLookUpForm.flag.value='true'
					return false
			   }
				else if(desk_sub.value == "")
				{
					
					desk_sub.value=getLabel("Common.all.label","Common");
					hid_sub1.value = "*ALL"
					document.personalizedPractLookUpForm.flag.value='true'
					parent.resultFrame.location.href	= "../../eCommon/html/blank.html";
					return false
				}*/

				parent.messageFrame.document.write("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()' class=MESSAGE><form name='tempform' id='tempform' method='post' action='CAPersonalizedQueryResult.jsp'><input type=hidden name='pract_name' id='pract_name' value='"+desk_sub.value+"'><input type=hidden name='selFunVal' id='selFunVal' value='Desk'> </form></body></html>");
				parent.messageFrame.tempform.submit();
	}
}

async function  callfunction1() { 
	var target = parent.frame3.document.personalizedPractLookUpForm.desk_sub;
	/*if(target.value =="ALL")
	 {
		target.value = "";
	 }*/
	var serviceVal   = parent.frame3.document.personalizedPractLookUpForm.desk_sub.value;
	var retVal = new String();
	var search_desc	= "";
	var title			= getLabel("eCA.Desktop.label","CA");
	
    var sql="SELECT DESKTOP_SUMMARY_ID code, DESKTOP_SUMMARY_NAME description FROM SM_DESKTOP_SUM_HDR WHERE DESKTOP_SUMMARY_TYPE = 'C' AND EFF_STATUS='E' and upper(DESKTOP_SUMMARY_ID) LIKE upper(?) and  upper(DESKTOP_SUMMARY_NAME) LIKE upper(?) order by 2";

	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	retArray = await CommonLookup( "Desktop", argArray );	
	var ret1=unescape(retArray);
		 var arr=ret1.split(",");
		 
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
				parent.frame3.document.personalizedPractLookUpForm.desk_sub.value = '';
				parent.frame3.document.personalizedPractLookUpForm.hid_sub1.value = '';
	 		}else{
					parent.frame3.document.personalizedPractLookUpForm.desk_sub.value = arr[1];
					parent.frame3.document.personalizedPractLookUpForm.hid_sub1.value = arr[0];
					DesktopView();
			}
	/*if(retArray != null && retArray !="")	
	{
		parent.frame3.document.personalizedPractLookUpForm.desk_sub.value = retArray[1];
		parent.frame3.document.personalizedPractLookUpForm.hid_sub1.value = retArray[0];
		DesktopView();
	}
	else
	{
		parent.frame3.document.personalizedPractLookUpForm.desk_sub.value = '';
		parent.frame3.document.personalizedPractLookUpForm.hid_sub1.value = '';
	}*/
	
	
	parent.frame3.document.personalizedPractLookUpForm.flag.value='true';
	parent.frame3.document.personalizedPractLookUpForm.look_up1.disabled=false;
	parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
 }


 function showText1()
{
	//var rem=document.forms[0].note_header_desc.value;
	//var rem=document.forms[0].footer_header_desc.value;
	/*var dialogHeight ='30' ;
	var dialogWidth = '40' ;
	var arguments			= "" ;
	var action_url		=	'../../eCA/jsp/CASummaryTreePreview.jsp';
		var title			= getLabel("Common.ViewDetails.label","COMMON");
		//var report_header_desc=document.forms[0].report_header_desc.value;
	    var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
		//action_url			+=	"?title="+encodeURIComponent(title,"UTF-8");
	    retVal			=	window.showModalDialog(action_url,arguments,features);*/
		var SummaryPreviewPage='SummaryPreviewPage';
		var desktopID=parent.frame3.document.personalizedPractLookUpForm.hid_sub1.value;

		window.open('../../eCA/jsp/CAMainHomePageTree.jsp?desktopID='+desktopID+'&SummaryPreviewPage='+SummaryPreviewPage,'SummaryPreview',' height= 500, width= 250,left = 500, top=100, status=no,scrollbars=yes,toolbar=no,fullscreen=no,location=no');

		//window.open('../../eCA/jsp/CASummaryTreePreview.jsp?desktop_summary_id='+desktop_summary_id,'SummaryPreview',' height= 500, width= 250,left = 500, top=100, status=no,scrollbars=yes,toolbar=no,fullscreen=no,location=no');
}



function DesktopView()
{
	var mode=parent.frame3.document.personalizedPractLookUpForm.mode.value;
	var desk_sub1=parent.frame3.document.personalizedPractLookUpForm.desk_sub.value;
	var pract_type1=parent.frame3.document.personalizedPractLookUpForm.pract_type.value;
	
	if((mode=='insert' || mode=='modify') && pract_type1!="" && desk_sub1!="")
	{
		document.getElementById("desk").style.visibility = 'visible';	
	}
}


