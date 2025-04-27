var prevObjID;
var prevObjClass;
var prevImgObj;
var disappeardelay= 200;

function reset()
{
	 BLNursingUnitBlngDtlsMainFrame.document.location.reload();
}


async function nursing_unit_lkup(clng_evnt)
{
	
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facility_id.value;
	var logged_user = document.forms[0].logged_user.value;

	var target_code	= document.forms[0].nursing_unit_code ;
	var target = document.forms[0].nursing_unit_desc;
	
	if(clng_evnt == 'B')
	{
		if( target.value == "")
		{	
			document.forms[0].nursing_unit_desc.value='';
			document.forms[0].nursing_unit_code.value = '';
			document.forms[0].dflt_forecast_days.value = '';
			document.forms[0].available_beds.value = '';
			document.forms[0].occupied_beds.value = '';
			document.forms[0].expect_discharge.value = '';
			document.forms[0].discharged_pat.value = '';
//			document.getElementById("inp_dtls_tab").style.display="none";
			parent.BLNursingUnitQueryResultsFrame.location.href="../../eCommon/html/blank.html";
			return;
		}
	}
	parent.BLNursingUnitQueryResultsFrame.location.href="../../eCommon/html/blank.html";

	var message="";
	var retVal				= new String();
	var dialogTop			= "40";
	var dialogHeight		= "800px" ;
	var dialogWidth			= "700px" ;
	var features			= "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql					= "";
	var title				= "";
	var column_descriptions = "";

	var title=getLabel("Common.nursingUnit.label","common"); 
	title=encodeURIComponent(title);		
		
	sql="SELECT nursing_unit_code Code , short_desc Description,DEFAULT_YN DEFAULT_YN,DFLT_FORECAST_DAYS DFLT_FORECAST_DAYS from BL_VW_FIN_NURS_UNIT_BY_USER_VW where LANGUAGE_ID='"+locale+"' and facility_id='"+facility_id+"' and user_id='"+logged_user+"'";

	var column_sizes = escape("30px,70px,0px,0px");
	var code=getLabel("Common.code.label","common");
	code=encodeURIComponent(code);
	var desc=getLabel("Common.description.label","common");
	desc=encodeURIComponent(desc);
	var dflt_yn="DEFAULT_YN";
	dflt_yn=encodeURIComponent(dflt_yn);
	var dflt_fc_days="DEFAULT_FORECAST_DAYS";
	dflt_fc_days=encodeURIComponent(dflt_fc_days);

	column_descriptions = code+","+desc+","+dflt_yn+","+dflt_fc_days;

	sql=escape(sql);

	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YYNN";

	retVal=await window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);	
	
	var arr=new Array();

	if (!(retVal == null))
	{
  	    var retVal=unescape(retVal);
		arr=retVal.split("^~^");

		target.value=arr[1];
		target_code.value = arr[0];
		document.forms[0].dflt_forecast_days.value = arr[3];

		bed_occupancy(target_code.value);

//		document.getElementById("inp_dtls_tab").style.display="inline";
//		tab_change(document.getElementById("curr_inp_tab"),'CIP');
//		tab_change(document.getElementById("tod_exp_dischrg_tab"),'TED');
		parent.frames[1].location.href = '../../eBL/jsp/BLNursingUnitQueryResultsFrame.jsp?nursing_unit_code='+arr[0]+"&exp_dischrg="+document.forms[0].expect_discharge.value+"&dflt_forecast_days="+document.forms[0].dflt_forecast_days.value;
	}
	else
	{	
		target.value='';
		target_code.value = '';

		bed_occupancy(target_code.value);

		document.forms[0].dflt_forecast_days.value = '';
		document.forms[0].available_beds.value = '';
		document.forms[0].occupied_beds.value = '';
		document.forms[0].expect_discharge.value = '';
		document.forms[0].discharged_pat.value = '';
//		document.getElementById("inp_dtls_tab").style.display="none";
		parent.frames[1].location.href = '../../eCommon/html/blank.html';
	}
}

function bed_occupancy(nursing_unit_code)
{
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	
	var param="nursing_unit_code="+nursing_unit_code;

	var temp_jsp="../../eBL/jsp/BLNursingUnitPatientDetailsValidation.jsp?"+param;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=trimString(xmlHttp.responseText);

	if(responseText!="")
	{
		var bed_occ_array = new Array();
		bed_occ_array = responseText.split("|");

		var avail_bed_temp = bed_occ_array[0];
		if(avail_bed_temp == " ") avail_bed_temp="";
		document.forms[0].available_beds.value = avail_bed_temp;

		var occu_bed_temp = bed_occ_array[1];
		if(occu_bed_temp == " ") occu_bed_temp="";
		document.forms[0].occupied_beds.value = occu_bed_temp;

		var exp_discrg_temp = bed_occ_array[2];
		if(exp_discrg_temp == " ") exp_discrg_temp="";
		document.forms[0].expect_discharge.value = exp_discrg_temp;

		var discrgd_pat_temp = bed_occ_array[3];
		if(discrgd_pat_temp == " ") discrgd_pat_temp="";
		document.forms[0].discharged_pat.value = discrgd_pat_temp;
	}	
}

function callMouseOverOnTD(obj,obj1,imgObj,i)
{		
	if (prevObjID != null && prevObjID != obj.id)
	{/*
		if(i%2 == 0)
		{
			eval("document.all."+prevObjID).className = 'QRYEVEN';
		}
		else
		{
			eval("document.all."+prevObjID).className = 'QRYODD';
		}*/
	  document.getElementById('prevObjID').className =prevObjClass;
		document.getElementById('prevImgObj').src = "../../eCommon/images/inactiveArrow.gif";			 
		
	}		 
	
	obj.className = 'selectedTDData';
	document.getElementById('imgObj').src = "../../eCommon/images/activeArrow.gif";
	prevObjID = obj.id;
	prevObjClass = obj1.className;
	prevImgObj = imgObj;		
}

function getPos(inputElement) 
{
	var coords =  new Object();
	coords.x = 0;
	coords.y = 0;
	try 
	{
		targetElement = inputElement;

		if(targetElement.x && targetElement.y) 
		{
			coords.x = targetElement.x;
			coords.y = targetElement.y;
		}
		else 
		{
			if(targetElement.offsetParent) 
			{
				coords.x += targetElement.offsetLeft;
				coords.y += targetElement.offsetTop;
				while(targetElement = targetElement.offsetParent) 
				{
					coords.x += targetElement.offsetLeft;
					coords.y += targetElement.offsetTop;
				}
			}
			else 
			{
				//alert("Could not find any reference for coordinate positioning.");
			}
		}
		return coords;
	}
	catch(error) 
	{
		//alert(error.msg);
		return coords;
	}
}

function dynamichide(m, e,row)
{
	if (!this.isContained(m, e))
	{
		this.delayhidemenu(row)
	}
}

function isContained(m, e)
{
	var e=window.event || e;
	var c=e.relatedTarget || ((e.type=="mouseover")? e.fromElement : e.toElement);
	while (c && c!=m)
	try 
	{
		c=c.parentNode;
	}
	catch(e)
	{
		c=m;
	}
	if(c==m)
		return true;
	else
		return false;
}

function delayhidemenu(row)
{
	this.delayhide=setTimeout("hidemenu()", this.disappeardelay) //hide menu
	if(eval(document.getElementById('orderctl'+row)))
	{
		if(row%2 == 0)
		{
			eval(document.getElementById("orderctl"+row)).className='QRYEVEN';
		}
		else
		{
			eval(document.getElementById("orderctl"+row)).className='QRYODD';
		}
	}
	if(eval(document.getElementById("imgArrow"+row)))
		eval(document.getElementById("imgArrow"+row)).src = "../../eCommon/images/inactiveArrow.gif";
}

function hidemenu()
{
	document.getElementById("tooltiplayer").style.visibility = 'hidden';
}
