/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
08/02/2012	  IN030996		Menaka V	 CA>Patient Chart>Clinical event history>When the already recorded details
										 are accessed we get Java Lang null pointer exception Script Error.		
21/02/2012	  IN036181		Chowminya G	 reports which has special characters such as an airstrisk (*) or a semicolon 	
06/03/2013	  IN035891		Ramesh G	 SKR-SCF-0671		
13/03/2013    IN038581      Ramesh G     When we Link Results using Result Linked Sections we get Script Error		
15/03/2013    IN038581.1    Chowminya G  When we Link Results using Result Linked Sections we get Script Error		 							 
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
30/04/2014    IN041284		 Ramesh G		Sunil KV      	30/04/2014			The alignment for result Link for laboratory  results in a clinical note section template does not display neatly .	
28/11/2014	IN052716		Ramesh G		Result Link In Template Based Section In  Clinical Notes For ?Table? And ?Text?.
24/05/2016	IN055439		Karthi L										MO_CRF_20102	
31/03/2017	IN061907	Krishna Gowtham J							ML-MMOH-CRF-0559	
10/05/2017  IN063865		Raja S			11/05/2017		Ramesh Goli			ML-MMOH-CRF-0534.1
30/08/2017  IN065040		Raja S			30/08/2017		Ramesh Goli			ML-MMOH-SCF-0787
19/03/2019  IN069927		Raja S			19/03/2019		Ramesh Goli			ML-MMOH-SCF-1181
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
var dtArr = new Array();

function getcomponent1(obj)
{
	if(obj.value!='')
	{
		getcomponent();
	}
}
String.prototype.replaceAll=function(s1, s2) {return this.split(s1).join(s2)};//IN036181
async function getcomponent()
{
		var retVal				=  new String();
		var dialogTop			= "40";
		var dialogHeight		= "10" ;
		var dialogWidth			= "40" ;
		var features			="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var locale = document.forms[0].locale.value;
		var search_desc="";
		var title = getLabel("Common.Component.label","Common");
		var result_linked_rec_type      = document.forms[0].hist_rec_type.value; 
		var target  = document.forms[0].comp_id;

		var sql="Select event_code code, short_desc description from CR_CLN_EVT_MST_LANG_VW where hist_rec_type = '"+result_linked_rec_type+"' and language_id = '"+locale+"' and UPPER(short_desc) like upper(?) AND event_code like upper(?)";

		var argArray		= new Array();
		var namesArray		= new Array();
		var valuesArray		= new Array();
		var datatypesArray	= new Array();
		
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "2,1";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		retVal = await CommonLookup( title, argArray )
		
		var arr=new Array();

		if (retVal != null && retVal != '' && retVal != "null")
		{

			//var retVal=unescape(retVal);
		   	// arr=retVal.split("::");
			var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) { 
			arr[1]="";
			arr[0]="";
			}
		    	
				document.forms[0].comp_id.value=arr[1];
				document.forms[0].comp_id_code.value=arr[0];
		}
		else
		{
			document.forms[0].comp_id.value="";
			document.forms[0].comp_id_code.value="";
		}
		
}

function makeVisible(obj)
{
	
	if(obj.value == 'Less Criteria >>')
	{
	document.getElementById("moreCriteria").style.display = 'none';
	//parent.notes.rows = "21%,*,3%";
	parent.document.getElementById('RecClinicalNotesLinkHistRepCriteriaFramenew').style.height='17vh';
	parent.document.getElementById('messageFrameReference').style.height='3vh';
	//parent.notes1.rows = "50%,10%,30%,10%";
	parent.document.getElementById('RecClinicalNotesLinkHistRepResultFramenew').style.height='45vh';
	parent.document.getElementById('RecClinicalNotesLinkHistRepShowButtonsFramenew').style.height='6vh';
	parent.document.getElementById('RecClinicalNotesLinkHistSelectedTextFramenew').style.height='20vh';
	parent.document.getElementById('RecClinicalNotesLinkHistRepSelectButtonsFramenew').style.height='9vh';
	
	document.forms[0].more.value="More Criteria >>";
	}
	else
	{
		
		document.getElementById("moreCriteria").style="display";
		//parent.notes.rows = "35%,*,3%";
		parent.document.getElementById('RecClinicalNotesLinkHistRepCriteriaFramenew').style.height='29vh';
		parent.document.getElementById('messageFrameReference').style.height='3vh';
		//parent.notes1.rows = "48%,11%,30%,11%";
		parent.document.getElementById('RecClinicalNotesLinkHistRepResultFramenew').style.height='40vh';
		parent.document.getElementById('RecClinicalNotesLinkHistRepShowButtonsFramenew').style.height='6vh';
		parent.document.getElementById('RecClinicalNotesLinkHistSelectedTextFramenew').style.height='14vh';
		parent.document.getElementById('RecClinicalNotesLinkHistRepSelectButtonsFramenew').style.height='9vh';
		document.forms[0].more.value="Less Criteria >>";
	}
}

function clearClick()
{	


	
	parent.RecClinicalNotesLinkHistRepResultFramenew.location.href="../../eCommon/html/blank.html";
	parent.RecClinicalNotesLinkHistSelectedTextFramenew.location.href="../../eCommon/html/blank.html";
    parent.RecClinicalNotesLinkHistRepShowButtonsFramenew.location.href="../../eCA/jsp/RecClinicalNotesLinkHistRepShowButtons.jsp";
    parent.RecClinicalNotesLinkHistRepSelectButtonsFramenew.location.href="../../eCA/jsp/RecClinicalNotesLinkHistRepSelectButtons.jsp";
	//document.location.reload();	
}


function checkIsNull(obj)
{
	if(trimCheck(obj.value)=='')
		return true;
	else
		return false;
}


/*function checkDateWithCurrentDate(toDateTime)
{
	var toDate = toDateTime.split(" ");
	var toarray = toDate[0].split("/");
	var enteredDate = new Date(toarray[2],toarray[1],toarray[0]);

	var today = new Date();
	var date= today.getDate();
	var month = today.getMonth() + 1;
	var year = today.getYear();
	today = new Date(year,month,date);
	if(enteredDate > today)
	{
		return true;
	}
	return false;
}

function checkPeriodFromTo()
{
	
	var from_date_time	=	document.forms[0].from_date_time;
	var to_date_time	=	document.forms[0].to_date_time;
	if(checkIsNull(from_date_time) && checkIsNull(to_date_time) ) 
	{
		return true;
	}

	if(checkIsNull(from_date_time)==false)
	if(!doDateTimeChk(from_date_time))
	{
		parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp?err_num="+getMessage("INVALID_DATE_TIME","CA");
		from_date_time.value='';
		//from_date_time.select();
		from_date_time.focus();
		return false;
	}
    if(checkIsNull(to_date_time)==false)
	if(!doDateTimeChk(to_date_time)) 
	{
		parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp?err_num="+getMessage("INVALID_DATE_TIME","CA");
		//to_date_time.select();
		to_date_time.value='';
		to_date_time.focus();
		return false;
	}
	if(checkIsNull(to_date_time)==false)
	if(checkDateWithCurrentDate(to_date_time.value))
	{
		parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp?err_num="+getMessage("FROM_DATE_GREATER_SYSDATE","CA");		
		
		//to_date_time.select();
		to_date_time.value='';
		to_date_time.focus();
		return false;
	}
	if(!checkIsNull(to_date_time) && !checkIsNull(from_date_time))
	if(!ValidateDateTime(from_date_time,to_date_time))
	{
		parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp?err_num="+getMessage("TO_DT_GR_EQ_FM_DT","CA");		
		///to_date_time.select();
		
		to_date_time.value='';
		to_date_time.focus();
		return false;
	}
	
	
	
	parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp";
	return true;
}

*/
function showCalendarValidate(str)
{
	var flg = showCalendar(str,null,'hh:mm');
	document.getElementById(str).focus();
	return flg;
}

function checkVal(obj)
{
	if(obj.checked == true)
		document.forms[0].abnormal.value = "Y";
	else
		document.forms[0].abnormal.value = "N";
}

function showSearchLinkResult1()
{
	
 	if(parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm != null)
	{	parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.selectitems.value=',';		
	parent.RecClinicalNotesLinkHistSelectedTextFramenew.location.href="../../eCommon/html/blank.html";
    parent.RecClinicalNotesLinkHistRepShowButtonsFramenew.location.href="../../eCA/jsp/RecClinicalNotesLinkHistRepShowButtons.jsp";
    //parent.RecClinicalNotesLinkHistRepSelectButtonsFramenew.location.href="../../eCA/jsp/RecClinicalNotesLinkHistRepSelectButtons.jsp";

	}

	var from_date_time	=	document.forms[0].from_date_time.value;
	var to_date_time	=	document.forms[0].to_date_time.value;
	var patient_id      = document.forms[0].patient_id.value;
	var encounter_id      = document.forms[0].encounter_id.value;
	var return_format      = document.forms[0].return_format.value;
	var result_linked_rec_type      = document.forms[0].hist_rec_type.value;
	var sec_hdg_code      = document.forms[0].sec_hdg_code.value;
	var event_group		=		document.forms[0].event_group.value;
	var class1			=	document.forms[0].class1.value;
	var abnormal		=	document.forms[0].abnormal.value;
	var comp_id			=	document.forms[0].comp_id.value;
	
	var comp_id_code		=	document.forms[0].comp_id_code.value;
	//alert("comp_id_code"+comp_id_code);
	var comp_val		=	document.forms[0].comp_val.value;
	var search_criteria		=	document.forms[0].search_criteria.value;
	//var current_encounter	=	document.forms[0].current_encounter.value;
	var order_by1		=	document.forms[0].order_by1.value;
	
	var order_by2		=	document.forms[0].order_by2.value;
	
	if(parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.current_encounter.checked==true)
	parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.current_encounter.value='Y';
	else
	parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.current_encounter.value='N';
	
	var current_encounter	=	parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.current_encounter.value
	
	//alert(current_encounter);
	//alert(parent.RecClinicalNotesLinkHistRepResultFrame.name);
	/*Below parameter 'clearBean=Y' added by Archana Dhal on 5/26/2010 for IN021332 */
	
	parent.RecClinicalNotesLinkHistRepResultFramenew.location.href = "../../eCA/jsp/RecClinicalNotesLinkHistRepResult.jsp?from_date_time="+from_date_time+"&to_date_time="+to_date_time+"&patient_id="+patient_id+"&hist_rec_type="+result_linked_rec_type+"&sec_hdg_code="+sec_hdg_code+"&return_format="+return_format+"&event_group="+event_group+"&class1="+class1+"&abnormal="+abnormal+"&comp_id="+comp_id+"&comp_id_code="+comp_id_code+"&comp_val="+comp_val+"&search_criteria="+search_criteria+"&current_encounter="+current_encounter+"&order_by1="+order_by1+"&order_by2="+order_by2+" &encounter_id="+encounter_id+'&clearBean=Y'; 
	
}


function perform(obj, hist_rec_type, objType, objCnt)
{
	/*Modified by Archana Dhal on 5/26/2010 for IN021332 start*/
	
	if(obj.checked)
	{
		var return_format	= parent.frames[0].document.forms[0].return_format.value ;
		var index			= obj.value;		
		
		//var cat = '';
		var temp = '';		

		if(objType == 'HDR')
		{
			var hdrNo =  parseInt(objCnt);
			var subHdrCnt = 1;
			var isHidChkVal = true;

			var histtype =  eval("document.RecClinicalNotesLinkMedResultForm.hidHDR_"+hdrNo+"_SUB_0_ELE_1");

			if(histtype == null || histtype == undefined)
			{
				histtype =  eval("document.RecClinicalNotesLinkMedResultForm.hidHDR_"+hdrNo+"_SUB_1_ELE_1");
			}

			if(return_format == 'TEXT' && histtype.value == "HTM" && hist_rec_type != 'SUNT')
			{
				alert(getMessage("NO_TABLE_RETURN_RECORDS","CA"));
				obj.checked = false;
				return false;
			}

			while(true)
			{
				var subHdrChk =  eval("document.RecClinicalNotesLinkMedResultForm.ChkHDR_"+hdrNo+"_SUB_"+subHdrCnt);
				if(subHdrChk != null)
				{
					subHdrChk.checked = true;
					subHdrCnt++;
				}
				else
				{
					break;
				}
			}

			var eleCnt = 1;
		
			for(var subHdr = 0; subHdr < subHdrCnt; subHdr++)
			{
				var isHidChkVal = true;
				while(true)
				{
					var eleChk =  eval("document.RecClinicalNotesLinkMedResultForm.ChkHDR_"+hdrNo+"_SUB_"+subHdr+"_ELE_"+eleCnt);

					if(eleChk != null)
					{
						eleChk.checked = true;
					}
					else
					{
						break;
					}
					eleCnt++;
					
				}
				eleCnt = 1;
			}
		}
		else if(objType == 'SUB')
		{			
			var subHdr = parseInt(objCnt);			
			var objName = obj.name;
			var hdrNo = objName.substring(objName.indexOf("_")+1,objName.indexOf("_")+2);
			if(hdrNo.length > 1)
			{
				hdrNo = objName.substring(objName.indexOf("_")+1,objName.indexOf("_")+3);
			}
			hdrNo = parseInt(hdrNo);

			var histtype =  eval("document.RecClinicalNotesLinkMedResultForm.hidHDR_"+hdrNo+"_SUB_"+subHdr+"_ELE_1");

			if(histtype != null)
			{
				if(return_format == 'TEXT' && histtype.value == "HTM" && hist_rec_type != 'SUNT')
				{
					alert(getMessage("NO_TABLE_RETURN_RECORDS","CA"));
					obj.checked = false;
					return false;
				}
			}
			var eleCnt = 1;			
			var isHidChkVal = true;
			var subHdrChkCnt = 0;
			var subHdrCnt = 1;

			while(true)
			{
				var subHdrChk =  eval("document.RecClinicalNotesLinkMedResultForm.ChkHDR_"+hdrNo+"_SUB_"+subHdrCnt);
				
				if(subHdrChk != null)
				{
					if(subHdrChk.checked)
					{
						subHdrChkCnt++;
					} 
					subHdrCnt++;
				}
				else
				{
					break;
				}
			}
			subHdrCnt--;
			

			while(true)
			{
				var eleChk =  eval("document.RecClinicalNotesLinkMedResultForm.ChkHDR_"+hdrNo+"_SUB_"+subHdr+"_ELE_"+eleCnt);
				

				if(eleChk != null)
				{
					eleChk.checked = true;
				}
				else
				{
					break;
				}
				eleCnt++;					
			}

			var eleCnt = 1;
			var otherEleCnt = 0;
			var otherEleChkCnt = 0;

			var subHdrIndex = objName.substring(objName.indexOf("_SUB_")+6, objName.indexOf("_SUB_")+5);

			if(subHdrIndex.length > 1)
			{
				subHdrIndex = objName.substring(objName.indexOf("_SUB_")+6, objName.indexOf("_SUB_")+6);
			}
			subHdrIndex = parseInt(subHdrIndex);

			for(var subHdr = 0; subHdr <= subHdrIndex; subHdr++)
			{
				while(true)
				{
					var eleChk =  eval("document.RecClinicalNotesLinkMedResultForm.ChkHDR_"+hdrNo+"_SUB_"+subHdr+"_ELE_"+eleCnt);

					if(eleChk != null && subHdr == 0)
					{
						
						if (eleChk.checked)
						{
							otherEleChkCnt++;
						}
						otherEleCnt++;
					}
					else
					{
						break;
					}
					eleCnt++;
				}
				eleCnt = 1;
			}

			if ((otherEleCnt == otherEleChkCnt) && (subHdrChkCnt == subHdrCnt))
			{
				var chkHDR =  eval("document.RecClinicalNotesLinkMedResultForm.ChkHDR_"+hdrNo);
				if (chkHDR != null)
				{
					chkHDR.checked = true;
				}
			}	
			

		}	//parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.selectitems.value+=cat;		
	}
	else
	{
		//var catrem = '';

		if(objType == 'HDR')
		{
			var hdrNo =  parseInt(objCnt);
			var subHdrCnt = 1;
			var isHidChkVal = true

			while(true)
			{
				var subHdrChk =  eval("document.RecClinicalNotesLinkMedResultForm.ChkHDR_"+hdrNo+"_SUB_"+subHdrCnt);

				if(subHdrChk != null)
				{
					subHdrChk.checked = false;
					subHdrCnt++;
				}
				else
				{
					break;
				}
			}

			var eleCnt = 1;
		
			for(var subHdr = 0; subHdr < subHdrCnt; subHdr++)
			{
				while(true)
				{
					var eleChk =  eval("document.RecClinicalNotesLinkMedResultForm.ChkHDR_"+hdrNo+"_SUB_"+subHdr+"_ELE_"+eleCnt);

					var subHdrChk =  eval("document.RecClinicalNotesLinkMedResultForm.ChkHDR_"+hdrNo+"_SUB_"+subHdrCnt);
					
					if(eleChk != null)
					{
						eleChk.checked = false;
					}
					else
					{
						break;
					}
					eleCnt++;
					
				}
				eleCnt = 1;
			}

		}
		else if(objType == 'SUB')
		{
			
			var subHdr = parseInt(objCnt);
			
			var objName = obj.name;
			var hdrNo = objName.substring(objName.indexOf("_")+1,objName.indexOf("_")+2);
			if(hdrNo.length > 1)
			{
				hdrNo = objName.substring(objName.indexOf("_")+1,objName.indexOf("_")+3);
			}
			hdrNo = parseInt(hdrNo);
			var eleCnt = 1;

			while(true)
			{
				var eleChk =  eval("document.RecClinicalNotesLinkMedResultForm.ChkHDR_"+hdrNo+"_SUB_"+subHdr+"_ELE_"+eleCnt);				

				if(eleChk != null)
				{
					eleChk.checked = false;
				}
				else
				{
					break;
				}
				eleCnt++;					
			}

			var eleCnt = 1;
			var otherEleCnt = 0;
			var otherEleChkCnt = 0;

			var subHdrIndex = objName.substring(objName.indexOf("_SUB_")+6, objName.indexOf("_SUB_")+5);

			if(subHdrIndex.length > 1)
			{
				subHdrIndex = objName.substring(objName.indexOf("_SUB_")+6, objName.indexOf("_SUB_")+6);
			}
			subHdrIndex = parseInt(subHdrIndex);

			for(var subHdr = 0; subHdr <= subHdrIndex; subHdr++)
			{
				while(true)
				{
					var eleChk =  eval("document.RecClinicalNotesLinkMedResultForm.ChkHDR_"+hdrNo+"_SUB_"+subHdr+"_ELE_"+eleCnt);

					if(eleChk != null && subHdr == 0)
					{
						
						if (eleChk.checked)
						{
							otherEleChkCnt++;
						}
						otherEleCnt++;
					}
					else
					{
						break;
					}
					eleCnt++;
				}
				eleCnt = 1;
			}

			if (otherEleCnt == otherEleChkCnt)
			{
				var chkHDR =  eval("document.RecClinicalNotesLinkMedResultForm.ChkHDR_"+hdrNo);
				if (chkHDR != null)
				{
					chkHDR.checked = false;
				}
			}
		}
		//parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.remitems.value+=catrem;
	}
	getSelectedObjs('perform');

	//end

 var disbutval=parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.selectitems.value;
 //alert(disbutval);
 if( disbutval != '' || disbutval != ',' )
	{
   
  	parent.RecClinicalNotesLinkHistRepShowButtonsFramenew.document.RecClinicalNotesLinkHistNoteAddButtonsForm.select.disabled=false;
    parent.RecClinicalNotesLinkHistRepSelectButtonsFramenew.document.RecClinicalNotesLinkHistRepSelectButtonsnewForm.select.disabled=false;

	}
	else
	{
   parent.RecClinicalNotesLinkHistRepShowButtonsFramenew.document.RecClinicalNotesLinkHistNoteAddButtonsForm.select.disabled=true;
   parent.RecClinicalNotesLinkHistRepSelectButtonsFramenew.document.RecClinicalNotesLinkHistRepSelectButtonsnewForm.select.disabled=true;
	}

 
}


function perform1()
{
	
		var prev=parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.selectitems.value
		if(prev != ',' || prev != '')
	{

        
		var str=prev.split(',');
        
		var count1=document.RecClinicalNotesLinkMedResultForm.countcheck.value;
		
		var	rowobjnew='';
		var rowidnew='';
		
		
		for(u=1;u<=count1;u++)
		{
			
			 var rowidct;
            var rowobjct=eval("document.RecClinicalNotesLinkMedResultForm.chk_value"+u);
			if (rowobjct != null)
			{
				 rowidct = rowobjct.value; 
			}
		   
			for(p=1;p<str.length;p++)
		{
			if(rowidct == str[p])
			{
             var rowchkbox=eval("document.RecClinicalNotesLinkMedResultForm.chkbox"+u);
			 rowchkbox.checked=true;
			 break;
			}
			
		}
			
		}	
	}	
}


function showItems()
{
	
	var remval = parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.remitems.value	
	
	if(remval !='')
	{
		removeItems();
	}
	
	getSelectedObjs('showItems'); //Added by Archana Dhal on 5/26/2010 for IN021332.

var selectitems=parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.selectitems.value;

var patient_id=parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.patient_id.value;

var hist_rec_type=parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.hist_rec_type.value;
var sec_hdg_code=parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.sec_hdg_code.value;
var return_format=parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.return_format.value;
//IN069927 Start.
var order_by1 = parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.order_by1.value;
var order_by2 = parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.order_by2.value;
// IN069927 End.
parent.messageFrameReference.location.href="../../eCommon/html/blank.html";
HTMLVal = "<form name='patientcare_dummy_form' id='patientcare_dummy_form' method='post' action='../../eCA/jsp/RecClinicalNotesLinkHistRepSelectedText.jsp'><input type=hidden name='ret_str' id='ret_str' value='"+selectitems+"'><input type=hidden name='patient_id' id='patient_id' value='"+patient_id+"'><input type=hidden name='order_by1' id='order_by1' value='"+order_by1+"'><input type=hidden name='order_by2' id='order_by2' value='"+order_by2+"'><input type=hidden name='hist_rec_type' id='hist_rec_type' value='"+hist_rec_type+"'><input type=hidden name='sec_hdg_code' id='sec_hdg_code' value='"+sec_hdg_code+"'><input type=hidden name='return_format' id='return_format' value='"+return_format+"'></form>";
parent.messageFrameReference.document.body.insertAdjacentHTML('beforeend',HTMLVal);
	
parent.messageFrameReference.document.patientcare_dummy_form.target = "RecClinicalNotesLinkHistSelectedTextFramenew";
parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.remitems.value='';
parent.messageFrameReference.document.patientcare_dummy_form.submit();
}




function removeItems()
{
var selectval=parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.selectitems.value ;

var remval=parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.remitems.value ;
//alert('remval'+remval);

    if(remval != '')
	{
		var remarr=remval.split(',');
        
		var remarrlen=remarr.length;
//		alert('remarrlen'+remarrlen);
				
		var	rowobjrem='';
		var rowidnewrem='';
		var chkcatrem='';
		var tmpcatrem='';
		
		
		for(p=1;p<remarrlen;p++)
		{
			//alert('selectval.lastIndexOf(remarr[p])'+selectval.lastIndexOf(remarr[p]));
			if(selectval.lastIndexOf(remarr[p])>0)
			{
            chkcatrem=selectval.substring(0,selectval.lastIndexOf(remarr[p])-1)+selectval.substring(selectval.lastIndexOf(remarr[p])+remarr[p].length,selectval.length);
			 
			}
			selectval=chkcatrem;
			
			
		}
			
	}
    if(chkcatrem == '')
	{
    chkcatrem=',';
	}
	
  	parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.selectitems.value=chkcatrem;	
 
	}

function performchkbox(obj, hist_rec_type)
{
	/*Modified by Archana Dhal on 5/26/2010 for IN021332 start*/

	var objName = obj.name;
	var hdrNo = objName.substring(objName.indexOf("_")+1,objName.indexOf("_")+2);

	if(hdrNo.length > 1)
	{
		hdrNo = objName.substring(objName.indexOf("_")+1,objName.indexOf("_")+3);
	}
	hdrNo = parseInt(hdrNo);


	if(obj.checked)
	{
		//alert("here");
		var return_format = parent.frames[0].document.forms[0].return_format.value ;
		
		var hidName = objName.substring(objName.indexOf("_")+1, objName.length);
		var histtype =  eval("document.RecClinicalNotesLinkMedResultForm.hidHDR_"+hidName);
	
		
		if(return_format == 'TEXT' && histtype.value == "HTM" && hist_rec_type != 'SUNT')
		{
			alert(getMessage("NO_TABLE_RETURN_RECORDS","CA"));
			obj.checked = false;			
			return false;
		}
		
		var eleCnt = 1;
		var subEleCnt = 0;
		var eleChkCnt = 0;
		var otherEleCnt = 0;
		var otherEleChkCnt = 0;

		var subHdrIndex = objName.substring(objName.indexOf("_SUB_")+6, objName.indexOf("_SUB_")+5);

		if(subHdrIndex.length > 1)
		{
			subHdrIndex = objName.substring(objName.indexOf("_SUB_")+6, objName.indexOf("_SUB_")+6);
		}
		subHdrIndex = parseInt(subHdrIndex);

		
		while(true)
		{
			var eleChk =  eval("document.RecClinicalNotesLinkMedResultForm.ChkHDR_"+hdrNo+"_SUB_"+subHdrIndex+"_ELE_"+eleCnt);
			
			if(eleChk != null)
			{
				if (eleChk.checked)
				{
					eleChkCnt++;
				}
				subEleCnt++;
			}
			else
			{
				break;
			}	
			eleCnt++;
		}
		eleCnt = 1;
		var isOtherEle = false;
		while(true)
		{
			var eleChk =  eval("document.RecClinicalNotesLinkMedResultForm.ChkHDR_"+hdrNo+"_SUB_0_ELE_"+eleCnt);

			if(eleChk != null)
			{
				
				if (eleChk.checked)
				{
					otherEleChkCnt++;
				}
				otherEleCnt++;
				isOtherEle = true;
			}			
			else
			{
				break;
			}	
			eleCnt++;
		}

		

		var chkHDR =  eval("document.RecClinicalNotesLinkMedResultForm.ChkHDR_"+hdrNo);
		var chkSUBHDR =  eval("document.RecClinicalNotesLinkMedResultForm.ChkHDR_"+hdrNo+"_SUB_"+subHdrIndex);


		if(subEleCnt == eleChkCnt && (eleChkCnt > 0 && subEleCnt > 0) )
		{
			if (chkSUBHDR != null)
			{
				chkSUBHDR.checked = true;
				subHdrChkCnt++;
			}
		}


		var subHdrCnt = 1;
		var subHdrChkCnt = 0;
		var isHidChkVal = true

		while(true)
		{
			var subHdrChk =  eval("document.RecClinicalNotesLinkMedResultForm.ChkHDR_"+hdrNo+"_SUB_"+subHdrCnt);
			
			if(subHdrChk != null)
			{
				if(subHdrChk.checked)
				{
					subHdrChkCnt++;
				} 
				subHdrCnt++;
			}
			else
			{
				break;
			}
		}
		
		subHdrCnt--;

		if((subHdrCnt == subHdrChkCnt) )
		{
			
			if (chkHDR != null)
			{
				if (isOtherEle && otherEleChkCnt != 0 && (otherEleChkCnt == otherEleCnt))
				{
					chkHDR.checked =  true;
				}
				else if(!isOtherEle)
				{
					chkHDR.checked =  true;
				}
				
			}
		}
		else if(subHdrCnt == 0  && (isOtherEle && otherEleChkCnt != 0 && (otherEleChkCnt == otherEleCnt)))
		{
			if (chkHDR != null)
			{
				chkHDR.checked =  true;
			}
		}


		/*var rIndex = objName.substring(objName.lastIndexOf("_")+1, objName.length);

		if(rIndex != '')
		{
			rIndex = parseInt(rIndex);
			var rowobj = eval("document.RecClinicalNotesLinkMedResultForm.hidChkVal_"+hdrNo+"_SUB_"+subHdrIndex+"_ELE_"+rIndex);
			var rowid = rowobj.value;			parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.selectitems.value+=","+rowid;
		}*/
	}
	else
	{
		var subHdrIndex = objName.substring(objName.indexOf("_SUB_")+6, objName.indexOf("_SUB_")+5);

		if(subHdrIndex.length > 1)
		{
			subHdrIndex = objName.substring(objName.indexOf("_SUB_")+6, objName.indexOf("_SUB_")+6);
		}
		subHdrIndex = parseInt(subHdrIndex);		

	   var rIndex = objName.substring(objName.lastIndexOf("_")+1, objName.length);

		if(rIndex != '')
		{
			rIndex = parseInt(rIndex);
			var rowobj = eval("document.RecClinicalNotesLinkMedResultForm.hidChkVal_"+hdrNo+"_SUB_"+subHdrIndex+"_ELE_"+rIndex);
			var rowidchk = rowobj.value;
			
		    var remval=parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.remitems.value;
	 
			if(remval != '' || remval != ',')
			{
				parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.remitems.value+=","+rowidchk;
			}
			else
			{
				parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.remitems.value=","+rowidchk;
			}
		}


	var return_format = parent.frames[0].document.forms[0].return_format.value ;
	var objName = obj.name;
	var hidName = objName.substring(objName.indexOf("_")+1, objName.length);
	var histtype =  eval("document.RecClinicalNotesLinkMedResultForm.hidHDR_"+hidName);
	
	if(return_format == 'TEXT' && histtype.value == "HTM" && hist_rec_type != 'SUNT')
	{
		alert(getMessage("NO_TABLE_RETURN_RECORDS","CA"));
		obj.checked = false;			
		return false;
	}

	var hdrNo = objName.substring(objName.indexOf("_")+1,objName.indexOf("_")+2);

	if(hdrNo.length > 1)
	{
		hdrNo = objName.substring(objName.indexOf("_")+1,objName.indexOf("_")+3);
	}
	hdrNo = parseInt(hdrNo);	
		

	var subHdrIndex = objName.substring(objName.indexOf("_SUB_")+6, objName.indexOf("_SUB_")+5);

	if(subHdrIndex.length > 1)
	{
		subHdrIndex = objName.substring(objName.indexOf("_SUB_")+6, objName.indexOf("_SUB_")+6);
	}
	subHdrIndex = parseInt(subHdrIndex);
	var chkHDR =  eval("document.RecClinicalNotesLinkMedResultForm.ChkHDR_"+hdrNo);
	var chkSUBHDR =  eval("document.RecClinicalNotesLinkMedResultForm.ChkHDR_"+hdrNo+"_SUB_"+subHdrIndex);

	if (chkHDR != null)
	{
		chkHDR.checked = false;
	}

	if (chkSUBHDR != null)
	{
		chkSUBHDR.checked = false;		
	}
		
		
}
getSelectedObjs('performchkbox');
//end

//alert('valuesindiv'+parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.remitems.value);
	
	var disbutval=parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.selectitems.value;
	

 if( disbutval != '' || disbutval != ',' )
	{
	parent.RecClinicalNotesLinkHistRepShowButtonsFramenew.document.RecClinicalNotesLinkHistNoteAddButtonsForm.select.disabled=false;
	parent.RecClinicalNotesLinkHistRepSelectButtonsFramenew.document.RecClinicalNotesLinkHistRepSelectButtonsnewForm.select.disabled=false;
	}
	else
	{
    parent.RecClinicalNotesLinkHistRepShowButtonsFramenew.document.RecClinicalNotesLinkHistNoteAddButtonsForm.select.disabled=true;
    parent.RecClinicalNotesLinkHistRepSelectButtonsFramenew.document.RecClinicalNotesLinkHistRepSelectButtonsnewForm.select.disabled=true;
	}
}
function returnDataApprove(){
	var dispResLinkHYMLYN = parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.forms[0].dispResLinkHYMLYN.value; //IN061907
	//  MO_CRF_20102[IN055439] - Start
	//IN061907 start
	/*if(document.getElementById("chkt").checked) {
		//parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.forms[0].return_format.value='TEXTLINK';
	}*/
	if(dispResLinkHYMLYN == "Y")
	{
		if(parent.RecClinicalNotesLinkHistRepSelectButtonsFramenew.document.RecClinicalNotesLinkHistRepSelectButtonsnewForm.chkl.checked) 
		{
			parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.forms[0].return_format.value='HTML';
		}
		else
		{
			parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.forms[0].return_format.value='TEXTLINK';
		}
	}
	else
	{
		if(parent.RecClinicalNotesLinkHistRepSelectButtonsFramenew.document.RecClinicalNotesLinkHistRepSelectButtonsnewForm.chkl.checked) 
		{
			parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.forms[0].return_format.value='HTML';
		}
		else
		{
			parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.forms[0].return_format.value='TEXT';
		}
	}
		//IN061907 ends
	//  MO_CRF_20102[IN055439] - End	
	var returnValue ='';	
	var return_format=parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.forms[0].return_format.value;
	var return_format_HTML = parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.forms[0].return_format_HTML.value; //IN041284
	//IN041284 Start.
	if(return_format=="HTML" && return_format_HTML=="HTML"){
		if(parent.RecClinicalNotesLinkHistSelectedTextFramenew.document.forms[0] != null)
			returnValue=decodeURIComponent(((parent.RecClinicalNotesLinkHistSelectedTextFramenew.document.forms[0].tempHtml.value).replaceAll("+","%20")),"UTF-8");
		if(returnValue!=''){
				returnValue = returnValue+"\n";				
			}	
		
		if(returnValue=='' ){
			alert(getMessage("MIN_ONE_ITEM_SEL_REQ","CA"));		  
		}else
		{			
			parent.window.returnValue=returnValue;
			parent.window.close();	
		}
	}else if(return_format=="TEXTLINK" && return_format_HTML=="HTML"){
		
		if(parent.RecClinicalNotesLinkHistSelectedTextFramenew.document.getElementById("inhtml") != null)
		{	//IN052716 Start.
			//returnValue=parent.RecClinicalNotesLinkHistSelectedTextFramenew.document.getElementById('inhtml').innerText;
			returnValue=decodeURIComponent(((parent.RecClinicalNotesLinkHistSelectedTextFramenew.document.forms[0].tempHtmlText.value).replaceAll("+","%20")),"UTF-8");
			//IN052716 End.
			if(returnValue!=''){
				//returnValue = "<TABLE width='540'><TR><TD valign='top'>"+returnValue+"</TD></TR></TABLE>";	
				returnValue = returnValue+"\n";					
			}
		}
		if(returnValue=='' ){
			alert(getMessage("MIN_ONE_ITEM_SEL_REQ","CA"));		  
		}else
		{			
			parent.window.returnValue=returnValue;
			parent.window.close();	
		}
	}else {
	//IN041284 End.
		if(return_format=="TEXTLINK")
		{
			if(parent.RecClinicalNotesLinkHistSelectedTextFramenew.document.forms[0] != null)
			returnValue=parent.RecClinicalNotesLinkHistSelectedTextFramenew.document.forms[0].temptext.value;
		}
		else if(return_format=="TEXT")
		{
			 if(parent.RecClinicalNotesLinkHistSelectedTextFramenew.document.getElementById("inhtml") != null)
			{
			/*	 Sathya Sai facing problem for text allignment for Text format, so reverting IN035891 and fixing the allignment issue
			//Sikarin IN035891 Start.
				//returnValue=parent.RecClinicalNotesLinkHistSelectedTextFramenew.document.forms[0].temptext.value;
				returnValue=encodeURIComponent(parent.RecClinicalNotesLinkHistSelectedTextFramenew.document.getElementById('inhtml').innerText,"UTF-8");//IN038581
			//Sikarin IN035891 End.
			*/
			returnValue=parent.RecClinicalNotesLinkHistSelectedTextFramenew.document.forms[0].temptext.value;
			}
			 //returnValue=returnValue.replace("<br","\n");
		}
		else
		{
		
			if(parent.RecClinicalNotesLinkHistSelectedTextFramenew.document.getElementById("inhtml") != null)
			{
				returnValue=parent.RecClinicalNotesLinkHistSelectedTextFramenew.document.getElementById("divDataTitle").innerHTML;
				returnValue+=parent.RecClinicalNotesLinkHistSelectedTextFramenew.document.getElementById("inhtml").innerHTML;
				returnValue=encodeURIComponent(returnValue,"UTF-8");//IN038581.1
			}
		}
		returnValue = returnValue.replaceAll("+","%20");//IN036181 
		if(returnValue=='' )
			alert(getMessage("MIN_ONE_ITEM_SEL_REQ","CA"));
		  
		else
		{		
			parent.window.returnValue=decodeURIComponent(returnValue,"UTF-8");//IN036181//IN038581			
			parent.window.close();	
		}
	} //IN041284 
	
}

function scrollTitle()
{
	
  var y = parent.RecClinicalNotesLinkHistRepResultFramenew.document.RecClinicalNotesLinkMedResultForm.document.body.scrollTop;

  if(y == 0){
	parent.RecClinicalNotesLinkHistRepResultFramenew.document.RecClinicalNotesLinkMedResultForm.document.getElementById("divDataTitle").style.position = 'static';
	parent.RecClinicalNotesLinkHistRepResultFramenew.document.RecClinicalNotesLinkMedResultForm.document.getElementById("divDataTitle").style.posTop  = 0;
  }else{
	parent.RecClinicalNotesLinkHistRepResultFramenew.document.RecClinicalNotesLinkMedResultForm.document.getElementById("divDataTitle").style.position = 'relative';
	parent.RecClinicalNotesLinkHistRepResultFramenew.document.RecClinicalNotesLinkMedResultForm.document.getElementById("divDataTitle").style.posTop  = y-2;
  }

}

function scrollTitle1()
{
	
  var y = parent.RecClinicalNotesLinkHistSelectedTextFramenew.document.RecClinicalNotesLinkMedSelectedTextForm.document.body.scrollTop;

  if(y == 0){
	parent.RecClinicalNotesLinkHistSelectedTextFramenew.document.RecClinicalNotesLinkMedSelectedTextForm.document.getElementById("divDataTitle").style.position = 'static';
	parent.RecClinicalNotesLinkHistSelectedTextFramenew.document.RecClinicalNotesLinkMedSelectedTextForm.document.getElementById("divDataTitle").style.posTop  = 0;
  }else{
	parent.RecClinicalNotesLinkHistSelectedTextFramenew.document.RecClinicalNotesLinkMedSelectedTextForm.document.getElementById("divDataTitle").style.position = 'relative';
	parent.RecClinicalNotesLinkHistSelectedTextFramenew.document.RecClinicalNotesLinkMedSelectedTextForm.document.getElementById("divDataTitle").style.posTop  = y-2;
  }

}

async function getText(Histrectype,Contrsysid,Accessionnum,Contrsyseventcode)
{
	var patient_id = document.forms[0].patient_id.value;//IN030996
	var enc_id = document.forms[0].enc_id.value;//IN030996
	//alert("Histrectype"+Histrectype);
	//alert("Contrsysid"+Contrsysid);
	//alert("Accessionnum"+Accessionnum);
	//alert("Contrsyseventcode"+Contrsyseventcode);

	//document.forms[0].txtFlagQuickText.value = 'Y';
	var win_height		= "37.5";
	var win_width		= "50";
	var win_scroll_yn	= "yes";

	if(Histrectype != 'CLNT'){
		win_height		= "27.75";
		win_width		= "37";
		win_scroll_yn	= "no";
}


var retVal = new String();
var dialogHeight = win_height ;
var dialogWidth = win_width ;
var dialogTop = "122";
var status = "no";
var scroll = win_scroll_yn;
var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll+";dialogTop :" + dialogTop;
var arguments	= Accessionnum ;

Accessionnum	=	escape(Accessionnum);
var finalString	= "Histrectype="+Histrectype+"&Contrsysid="+Contrsysid+"&Accessionnum="+Accessionnum+"&Contrsyseventcode="+Contrsyseventcode+"&patient_id="+patient_id+"&enc_id="+enc_id;//IN030996
//retVal = window.showModalDialog("../../eCA/jsp/FlowSheetText.jsp?Histrectype="+Histrectype+"&Contrsysid="+Contrsysid+"&Accessionnum="+Accessionnum+"&Contrsyseventcode="+Contrsyseventcode,arguments,features);
retVal = await window.showModalDialog("../../eCA/jsp/FlowSheetText.jsp?"+finalString,arguments,features);//IN030996
/*for(var i=0;i<arrObjects.length;i++){
	if(arrObjects[i] != null){
		var temp1 = arrClassValues[i];
		arrObjects[i].className = temp1;
	}
}
arrObjects = new Array();
arrValues = new Array();
arrClassValues = new Array();*/
return false;
}

function chgretn(Obj)
{

if(Obj.value == 't')
parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.forms[0].return_format.value='TEXTLINK';
else
parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.forms[0].return_format.value='';

}

function doDateCheck1(fromDate,toDate,currDate,format,locale)
{
	if((!fromDate.value=="")&&(!toDate.value==""))
	{
	if(isBeforeNow(fromDate.value, format, locale))
	{
		if(isBeforeNow(toDate.value, format, locale))
		{
			if(isAfter(toDate.value, fromDate.value, format, locale))
				return true;
			else
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","CA"));	
				toDate.focus();
				return false;
			}
		}
		else
		{
			alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
			toDate.select();
			toDate.focus();
			return false;
		}

	}
	else
	{
		alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
		
		fromDate.select();
		fromDate.focus();
		return false;
	}
	}


}

function showSearchLinkMultiResult()
{
	
	var from_date_time	=	document.forms[0].from_date_time.value;
	var to_date_time	=	document.forms[0].to_date_time.value;
	var current_encounter	=	document.forms[0].current_encounter.value;
	//var past_encounter_yn	=	document.forms[0].past_encounter_yn.value;
	var past_encounter	=	document.forms[0].past_encounter.value;
	var pat_class	=	document.forms[0].pat_class.value;
	//var pat_class_yn	=	document.forms[0].pat_class_yn.value;
	//var med_template	=	document.forms[0].med_template.value;
	var patient_id      = document.forms[0].patient_id.value;
	var encounter_id      = document.forms[0].encounter_id.value;
	var hist_rec_type      = document.forms[0].hist_rec_type.value;
	var sec_hdg_code      = document.forms[0].sec_hdg_code.value;
	var child_sec_hdg_code      = document.forms[0].child_sec_hdg_code.value;
	var operation_mode      = document.forms[0].operation_mode.value;
	var accession_num      = document.forms[0].accession_num.value;
	var facilityIdSel      = document.forms[0].facilityIdSel.value;
	//alert("operation_mode..."+operation_mode+"....accession_num..."+accession_num);
	
	//parent.RecClinicalNotesLinkMultiHistPrevNextFrame.location.href = "../../eCA/jsp/RecClinicalNotesLinkMultiHistPrevNext.jsp?from_date_time="+from_date_time+"&to_date_time="+to_date_time+"&current_encounter="+current_encounter+"&past_encounter_yn="+past_encounter_yn+"&past_encounter="+past_encounter+"&pat_class_yn="+pat_class_yn+"&pat_class="+pat_class+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&hist_rec_type="+hist_rec_type+"&sec_hdg_code="+sec_hdg_code+"&child_sec_hdg_code="+child_sec_hdg_code+"&operation_mode="+operation_mode+"&accession_num="+accession_num;
	parent.RecClinicalNotesLinkMultiHistPrevNextFrame.location.href = "../../eCA/jsp/RecClinicalNotesLinkMultiHistPrevNext.jsp?from_date_time="+from_date_time+"&to_date_time="+to_date_time+"&current_encounter="+current_encounter+"&past_encounter="+past_encounter+"&pat_class="+pat_class+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&hist_rec_type="+hist_rec_type+"&sec_hdg_code="+sec_hdg_code+"&child_sec_hdg_code="+child_sec_hdg_code+"&operation_mode="+operation_mode+"&accession_num="+accession_num+"&facilityIdSel="+facilityIdSel;
	//alert("pat_class_yn..."+pat_class_yn+"..pat_class..."+pat_class+"...past_encounter.."+past_encounter+"..past_encounter_yn..."+past_encounter_yn+"...current_encounter.."+current_encounter);
	//parent.RecClinicalNotesLinkMultiHistDetFrame.location.href = "../../eCA/jsp/RecClinicalNotesLinkMultiHistDetails.jsp?from_date_time="+from_date_time+"&to_date_time="+to_date_time+"&current_encounter="+current_encounter+"&past_encounter_yn="+past_encounter_yn+"&past_encounter="+past_encounter+"&pat_class_yn="+pat_class_yn+"&pat_class="+pat_class+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&hist_rec_type="+hist_rec_type+"&sec_hdg_code="+sec_hdg_code+"&child_sec_hdg_code="+child_sec_hdg_code; 
		

	// "../../eCA/jsp/RecClinicalNotesLinkHistRepResult.jsp?from_date_time="+from_date_time+"&to_date_time="+to_date_time+"&patient_id="+patient_id+"&hist_rec_type="+result_linked_rec_type+"&return_format="+return_format+"&event_group="+event_group+"&class1="+class1+"&abnormal="+abnormal+"&comp_id="+comp_id+"&comp_id_code="+comp_id_code+"&comp_val="+comp_val+"&search_criteria="+search_criteria+"&current_encounter="+current_encounter+"&order_by1="+order_by1+"&order_by2="+order_by2+" &encounter_id="+encounter_id;
	
}

function loadPrevNext1(obj,start,end)
{
	var NxtBtn		= parent.RecClinicalNotesLinkMultiHistPrevNextFrame.document.forms[0].next;
	
	var PrvBtn		= parent.RecClinicalNotesLinkMultiHistPrevNextFrame.document.forms[0].prev;

	
	var curidxval	= parseInt(parent.RecClinicalNotesLinkMultiHistPrevNextFrame.document.forms[0].curidxval.value);
	
	var noofpages	= eval(parent.RecClinicalNotesLinkMultiHistPrevNextFrame.document.forms[0].noofpages.value);

		
	if(obj.name == 'next')
	{
		start =parseInt(start)+14;
		end = parseInt(end)+14;
		curidxval++;
	}
	else if(obj.name == 'prev')
	{
		start =parseInt(start)-14;
		end = parseInt(end)-14;
		curidxval--;
	}
	displstart = curidxval;
	
	parent.RecClinicalNotesLinkMultiHistPrevNextFrame.document.forms[0].curidxval.value = curidxval;
	parent.RecClinicalNotesLinkMultiHistPrevNextFrame.document.forms[0].label_cap.value = displstart + " of " + noofpages;

	parent.RecClinicalNotesLinkMultiHistPrevNextFrame.document.forms[0].from.value =start;
	parent.RecClinicalNotesLinkMultiHistPrevNextFrame.document.forms[0].to.value =end;

	if (curidxval == 1)
		PrvBtn.disabled = true;
	else
		PrvBtn.disabled = false;

	if (curidxval == noofpages )
		NxtBtn.disabled = true;
	else
		NxtBtn.disabled = false;


	
	//alert("curidxval.."+curidxval+'..start...'+start+'..end...'+end);
	
	populateControl1(start,end);
	
/*	var uptoidxval = 0;

	if(obj.name == 'next')
	{
		
		if(curidxval < totalidx)
		{
			curidxval++;
			uptoidxval = curidxval+1;
			PrvBtn.disabled = false;
		
			if(uptoidxval >= totalidx)
				{
				uptoidxval = curidxval+1;
				NxtBtn.disabled = true;
				}
		}		
	}
	else if(obj.name == 'prev')
	{
		if(curidxval > 0)
		{
			curidxval--;
			uptoidxval = eval(curidxval)+1;
			NxtBtn.disabled = false;
			
			if(curidxval <= 0)
			{
				uptoidxval = eval(curidxval)+1;
				PrvBtn.disabled = true;
			}
		}
	}

	

	var displstart	= eval(curidxval) + 1;
	var displend	= eval(totalidx); 

	parent.RecClinicalNotesLinkMultiHistPrevNextFrame.document.forms[0].label_cap.value = displstart + " of " + displend;
	parent.RecClinicalNotesLinkMultiHistPrevNextFrame.document.forms[0].cur_idx_value.value = curidxval;

	/*
	if (uptoidxval == totalidx )
		NxtBtn.disabled = true;
	else
		NxtBtn.disabled = false;
	
	if (curidxval == 0)
		PrvBtn.disabled = true;
	else
		PrvBtn.disabled = false;
		
	*/
	/*var firstDateTime;
	var lastDateTime;

	alert("dtArr..."+dtArr);
		firstDateTime	= dtArr[curidxval]
		lastDateTime	= dtArr[uptoidxval]
	
		populateControl1(firstDateTime,lastDateTime); */
}


function populateControl1(from,to)
{
	//alert('fmDt...'+fmDt+'...toDt...'+toDt);
	
	//workAreaFrameReference = getWorkAreaCriteriaFrame();
/*
	var event_date		=	'';//document.forms[0].event_date.value;
	var patientid		= document.forms[0].patient_id.value;
	var episodetype		= document.forms[0].episode_type.value;
	
	var eventclass		= document.forms[0].event_class.value;
	
	var eventgroup		= document.forms[0].event_group.value;
	
	var eventitem		= document.forms[0].event_item.value;

	//var called_from= document.forms[0].called_from.value;
	

	//var stdParams		= document.forms[0].queryStrForCmnts.value;
	var viewConfRes		= document.forms[0].viewConfRes.value;
	var historytype		= document.forms[0].history_type.value;
	
	var facility_id		= document.forms[0].facility_id.value;
	
	//var graphorder		= workAreaFrameReference.document.forms[0].graphorder.value;
	
	
	var encounter_id	= document.forms[0].encounter_id.value;
	var enc_id	= document.forms[0].enc_id.value;

	//var fromdate		= workAreaFrameReference.document.forms[0].from_date.value;
	//var todate			= workAreaFrameReference.document.forms[0].to_date.value;

	if(fmDt == undefined)
		fmDt = '';
	if(toDt == undefined)
		toDt = '';
	

	var abnormal = "";
	var errorEvent ="N";

	//if(workAreaFrameReference.document.forms[0].chkAbnormal.checked)
	//	abnormal = "Y";
	//else
	//	abnormal = "N";
	var normalcy = "";//workAreaFrameReference.document.forms[0].cboNormalcyInd.value;
	var episode_wise = "N";
	var view_by="";

	//if(workAreaFrameReference.document.forms[0].view_by[0].checked)
				//view_by = workAreaFrameReference.document.forms[0].view_by[0].value;
	//else if(workAreaFrameReference.document.forms[0].view_by[1].checked)
				//view_by = workAreaFrameReference.document.forms[0].view_by[1].value;

*/

	//var params = 'patient_id='+patientid+'&episode_type='+episodetype+'&hist_type='+historytype+'&event_class='+eventclass+'&event_group='+eventgroup+'&event_item='+eventitem+'&from_date='+fmDt+'&to_date='+toDt+'&event_date='+event_date+'&abnormal='+abnormal+'&normalcy='+normalcy+'&viewConfRes='+viewConfRes+'&performed_by=&errorEvent='+errorEvent+'&episode_wise='+episode_wise+'&view_by='+view_by+'&facility_id='+facility_id+'&encounter_id='+encounter_id+'&graphorder='+graphorder+'&enc_id='+enc_id;
	
	//var params =
	
	//alert('params...'+params);

	var fmDt = document.forms[0].from_date.value;
	var toDt = document.forms[0].to_date.value;
	var current_encounter =document.forms[0].current_encounter.value;
	var past_encounter_yn =document.forms[0].past_encounter_yn.value;
	var pat_class_yn =document.forms[0].pat_class_yn.value;
	var pat_class =document.forms[0].pat_class.value;
	var patient_id = document.forms[0].patient_id.value;
	var encounter_id =document.forms[0].encounter_id.value;
	var hist_rec_type =document.forms[0].hist_rec_type.value;
	var sec_hdg_code =document.forms[0].sec_hdg_code.value;
	var child_sec_hdg_code =document.forms[0].child_sec_hdg_code.value;
	var past_encounter =document.forms[0].past_encounter.value;
	var operation_mode =document.forms[0].operation_mode.value;
	var accession_num =document.forms[0].accession_num.value;
	var sort_by =document.forms[0].sort_by.value;
	var facilityIdSel =document.forms[0].facilityIdSel.value;

	//alert("operation_mode..in js."+operation_mode+"...accession_num..."+accession_num);	//parent.RecClinicalNotesLinkMultiHistDetFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkMultiHistDetails.jsp?"+params;
	//alert('fromdate...'+document.forms[0].from_date.value);
	//alert("fmDt..."+fmDt+'..toDt..'+toDt);
	
	parent.RecClinicalNotesLinkMultiHistDetFrame.location.href = "../../eCA/jsp/RecClinicalNotesLinkMultiHistDetails.jsp?from="+from+"&to="+to+"&from_date_time="+fmDt+"&to_date_time="+toDt+"&current_encounter="+current_encounter+"&past_encounter_yn="+past_encounter_yn+"&past_encounter="+past_encounter+"&pat_class_yn="+pat_class_yn+"&pat_class="+pat_class+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&hist_rec_type="+hist_rec_type+"&sec_hdg_code="+sec_hdg_code+"&child_sec_hdg_code="+child_sec_hdg_code+"&operation_mode="+operation_mode+"&accession_num="+accession_num+"&sort_by="+sort_by+"&facilityIdSel="+facilityIdSel; 
				

			
}

function chEncVal(obj)
{
	if(obj.checked)
	{
		document.forms[0].current_encounter.value="Y";
	}
	else
	{
		document.forms[0].current_encounter.value="N";
	}

}
/*Added by Archana Dhal on 5/26/2010 for IN021332 */
//start
function getSelectedObjs(callFrom)
{
	var cat = '';
	var formObj = eval("parent.RecClinicalNotesLinkHistRepResultFramenew.document.RecClinicalNotesLinkMedResultForm");
	var root = formObj.document.getElementById("resultTable");//the root 	
	var allRows = root.getElementsByTagName('tr');
	//IN065040 Changes starts
	/*
	//IN063865 Changes starts
	if (callFrom != 'showItems')
	{
	putRowIDtoBean('', 'CLEAR');
	}
	//IN063865 Changes Ends
	*/ //commented for IN065040
	//IN065040 Changes Ends
	for(var k = 0; k < allRows.length; k++)
	{
		var allInp = allRows[k].getElementsByTagName('input'); 
		var isHidden = false;
		var objName1 = '';

		for (var i = 0; i < allInp.length ;i++ )
		{
			var objName = '';

			if(allInp[i].type == 'hidden')
			{
				objName = allInp[i].name;
				objName = objName.substring(0, 10);
			}

			if(allInp[i].type == 'checkbox' && allInp[i].checked )
			{
				isHidden = true;
				
			}
			if(isHidden && allInp[i].type == 'hidden' && objName == 'hidChkVal_')
			{
				var val =  allInp[i].value;
				var val1 =  val;
				val1 = val1.substring(4, val1.length);

				if (callFrom != 'showItems')
				{
					putRowIDtoBean(val, 'ADD');
				}				

				if(callFrom == 'showItems' && cat.indexOf(val1) == -1)
				{
					cat = cat+','+val1;
				}
				isHidden = false;				
			}
			else if(!isHidden && allInp[i].type == 'hidden' && objName == 'hidChkVal_')
			{
				if (callFrom != 'showItems')
				{
					putRowIDtoBean(allInp[i].value, 'REMOVE');
				}				
			}
		}
	}
	putRowNumtoBean(cat);

	if(callFrom == 'showItems')
	{
		putRowNumtoBean();
	}
}

function putRowIDtoBean(val, keyAction)
{
	var callFrom = 'PUTROWIDTOBEAN';
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;	
	xmlStr ="<root><SEARCH ";
	xmlStr += "rowID=\""+ val +"\" " ;			
	xmlStr += "keyAction=\""+ keyAction +"\" " ;			
	xmlStr += "callFrom=\""+ callFrom +"\" " ;			
	xmlStr +=" /></root>" ;		
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
	xmlHttp.open( "POST", "RecClinicalNotesLinkRepIntermediate.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
}

function putRowNumtoBean()
{
	var callFrom = 'PUTROWNUMTOBEAN';
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;	
	xmlStr ="<root><SEARCH ";	
	xmlStr += "callFrom=\""+ callFrom +"\" " ;			
	xmlStr +=" /></root>" ;		
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
	xmlHttp.open( "POST", "RecClinicalNotesLinkRepIntermediate.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
}
//end


