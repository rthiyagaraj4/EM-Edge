/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var param="";

function funPreOpeartiveSearch(){
var locale = parent.frames[1].document.forms[0].locale.value;
var frmObj=parent.frames[1].document.forms[0];
var change_from_date = dateUtils(frmObj.from_date.value,locale); 
var change_to_date = dateUtils(frmObj.to_date.value,locale); 
//var sql="SELECT PATIENT_ID PATIENT_ID1,PERFORMING_TEAM_SURGEON PERFORMING_TEAM_SURGEON1,SHORT_NAME SHORT_NAME1, SEX SEX1, SURGERY_NATURE_DESC SURGERY_TYPE1, SPECIALITY_DESC SPECIALITY_DESC1, TEAM_SURGEON_NAME TEAM_SURGEON_NAME1, ORDER_ID ORDER_ID1, to_char(PREF_SURG_DATE,'dd/mm/yyyy') PREF_SURG_DATE1 FROM OT_PENDING_ORDERS_VW   WHERE PERFORMING_FACILITY_ID = '"+frmObj.facility_id.value+"'";
if(frmObj.order_catagory.value==''){
		//var err=getMessage("ORDER_CATEGORY_NULL");
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		var orderCategory =getLabel("Common.OrderCategory.label","Common");
		
		alert(msgArray[0]+orderCategory+msgArray[1]);
		//alert(err);
		return;
	}

	//Added for 23903 on 9/21/2010 by AnithaJ
	if(frmObj.order_type_code.value == '')
	{
		frmObj.order_catalog_code.value="";
	}
var sql='';
if(frmObj.order_catagory.value!='*A')
	{//AND A.ORDER_CATEOGRY <> 'OT'
	sql="SELECT A.ORDER_ID ORDER_ID1,G.SHORT_DESC ORDER_CATEGORY1, A.ORDER_LINE_NUM ORDER_LINE_NUM1, to_char(A.ORD_DATE_TIME,'dd/mm/yyyy hh24:mi') ORD_DATE_TIME1, DECODE(A.PRIORITY,'R','Routine','U','Urgent','S','Stat')  PRIORITY_DESC1, A.ORDER_TYPE_CODE ORDER_TYPE_CODE1, B.SHORT_DESC ORDER_TYPE_DESC1,C.SHORT_DESC ORDER_CATALOG_DESC1,D.SHORT_NAME ORDERED_BY1,E.SHORT_DESC ORDER_STATUS_DESC1 FROM OR_ORDER_LINE A,OR_ORDER F, OR_ORDER_TYPE_LANG_VW B,OR_ORDER_CATALOG_LANG_VW C, AM_PRACTITIONER_LANG_VW D, OR_ORDER_STATUS_CODE_LANG_VW E,OR_ORDER_CATEGORY_LANG_VW G WHERE C.LANGUAGE_ID='"+locale+"' AND B.LANGUAGE_ID='"+locale+"' AND E.LANGUAGE_ID='"+locale+"' AND G.LANGUAGE_ID='"+locale+"' AND D.LANGUAGE_ID='"+locale+"' AND G.ORDER_CATEGORY  =A.ORDER_CATEGORY AND  A.ORDER_CATEGORY IN ('RD','LB','PC','NC') AND A.ORDER_CATEGORY  = '"+frmObj.order_catagory.value+"' AND ";
	}
else
	
	{//alert(locale);
	sql="SELECT A.ORDER_ID ORDER_ID1,G.SHORT_DESC ORDER_CATEGORY1, A.ORDER_LINE_NUM ORDER_LINE_NUM1, to_char(A.ORD_DATE_TIME,'dd/mm/yyyy hh24:mi') ORD_DATE_TIME1, DECODE(A.PRIORITY,'R','Routine','U','Urgent','S','Stat')  PRIORITY_DESC1, A.ORDER_TYPE_CODE ORDER_TYPE_CODE1, B.SHORT_DESC ORDER_TYPE_DESC1,C.SHORT_DESC ORDER_CATALOG_DESC1,D.SHORT_NAME ORDERED_BY1,E.SHORT_DESC ORDER_STATUS_DESC1 FROM OR_ORDER_LINE A,OR_ORDER F, OR_ORDER_TYPE_LANG_VW B,OR_ORDER_CATALOG_LANG_VW C, AM_PRACTITIONER_LANG_VW D, OR_ORDER_STATUS_CODE_LANG_VW E,OR_ORDER_CATEGORY_LANG_VW G WHERE C.LANGUAGE_ID='"+locale+"' AND B.LANGUAGE_ID='"+locale+"' AND E.LANGUAGE_ID='"+locale+"' AND G.LANGUAGE_ID='"+locale+"' AND D.LANGUAGE_ID='"+locale+"' AND G.ORDER_CATEGORY  =A.ORDER_CATEGORY  AND A.ORDER_CATEGORY IN ('RD','LB','PC','NC') AND";
	sql+=" A.ORDER_ID	= F.ORDER_ID AND	 F.PATIENT_ID = '"+frmObj.patient_id.value+"' AND A.ORDER_TYPE_CODE= B.ORDER_TYPE_CODE AND	 A.ORDER_CATEGORY = C.ORDER_CATEGORY AND A.ORDER_CATALOG_CODE = C.ORDER_CATALOG_CODE AND A.ORD_PRACT_ID = D.PRACTITIONER_ID AND A.ORDER_LINE_STATUS= E.ORDER_STATUS_CODE ";
	}
var where="";
if(frmObj.order_type_code.value!=null && frmObj.order_type_code.value!='' && frmObj.order_type_code.value!= '*A')
where=escape(" and A.ORDER_TYPE_CODE ='"+frmObj.order_type_code.value+"'");

if(frmObj.orderid.value!=null && frmObj.orderid.value!='')
where+=escape(" and A.ORDER_ID  ='"+frmObj.orderid.value+"'");


//if((frmObj.from_date.value!=null && frmObj.from_date.value!='')||(frmObj.to_date.value!=null && frmObj.to_date.value!=''))
if((change_from_date!=null && change_from_date!='')||(change_to_date!=null && change_to_date!=''))
 where +=escape(" AND A.ORD_DATE_TIME  BETWEEN  NVL(TO_DATE('"+change_from_date+"','dd/mm/yyyy hh24:mi'),SYSDATE-15) AND  NVL(TO_DATE('"+change_to_date+"','dd/mm/yyyy hh24:mi'),SYSDATE)");

if(frmObj.order_catalog_code.value !=null && frmObj.order_catalog_code.value!='')
	where+= escape(" AND A.ORDER_CATALOG_CODE  ='"+frmObj.order_catalog_code.value+"'");

if(frmObj.status.value =='A')	
	where+="AND A.ORDER_LINE_STATUS NOT IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE_LANG_VW  WHERE LANGUAGE_ID='"+locale+"' AND ORDER_STATUS_TYPE IN 	('90', '93', '95', '96', '97', '99'))";
else	
if(frmObj.status.value =='P')	
	where+="AND A.ORDER_LINE_STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND ORDER_STATUS_TYPE IN ('00', '03', '05'))";
else	
 if(frmObj.status.value =='O')
	 where+="AND A.ORDER_LINE_STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE_LANG_VW  WHERE LANGUAGE_ID='"+locale+"' AND ORDER_STATUS_TYPE IN ('10'))";
else
 if(frmObj.status.value =='V')
	 where+="AND A.ORDER_LINE_STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE_LANG_VW   WHERE LANGUAGE_ID='"+locale+"' AND ORDER_STATUS_TYPE IN ('90', '93', '95', '96', '97', '99','60','00','03','05','10' ))";
else
 if(frmObj.status.value =='C')
	 where+="AND A.ORDER_LINE_STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND ORDER_STATUS_TYPE IN ('60'))";

sql+=where;  
//alert(unescape(sql));

param='sql='+unescape(sql)+'&patient_id='+frmObj.patient_id.value+'&booking_no='+frmObj.booking_no.value;
parent.message_search_frame.location.href = '../../eOT/jsp/PreOperativeDtlFrame.jsp?'+param;	
}

function apply(){
	var objForm=parent.message_search_frame.schdule_dtl.document.PreoperativeDtlForm;
	var param1=objForm.param1.value;
	var messageFram = parent.messageFrame;
	var xmlStr= collectAllDetails(objForm);
	//alert(xmlStr);
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr="<root>"+xmlStr;
	xmlStr+="</root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eOT.PreOperativeServlet", false);
	xmlHttp.send(xmlDoc);
	var resTxt=xmlHttp.responseText;
	if(resTxt!=""){
		alert(resTxt);
	}else{
	alert("APP-000050 No Changes to Save ....");
	}
	window.close();
	//messageFram.document.location.href="../../eCommon/jsp/error.jsp?err_num="+"";
	//parent.message_search_frame.location.href = '../../eOT/jsp/PreOperativeDtlFrame.jsp?'+param1;	

}

/*function clearAllValue()
{

	var frmObj=document.forms[0];
	frmObj.order_catagory.value='';
	frmObj.order_type_code.value='';
	frmObj.order_catalog_code.value='';
	frmObj.order_catagory_disp.value='';
	frmObj.order_type_desc.value='';
	frmObj.from_date.value='';
	frmObj.to_date.value='';
	frmObj.orderid.value='';
	frmObj.catalog.value='';
}*/


function reset()
{
var cou=0;

  if( parent.frames[1].document.location.href.indexOf("PreOperativeSearch.jsp") != -1){
	
	      //parent.parent.header_frame.document.location.reload();
	      //parent.frames[2].frames[0].document.location.reload();
//		  message_search_frame.schdule_dtl.hashOrder.clear();
		  header_frame.document.forms[0].reset();
//		  message_search_frame.schdule_dtl.document.forms[0].reset();
		funPreOpeartiveSearch();
		  //parent.frames[2].document.forms[0].reset();
	 }
for(cou=1;cou<parent.frames[1].length;cou++)
{
parent.frames[1].frames(cou).location.reload();
}
}


function callNoRecord()
{
alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
}

function collectAllDetails(objForm)
	{
	var max=objForm.maxno.value;

	var maxno;
	var stage;	var priority;	var sequence;
	var modified;
	var xmlString="";

	if (max!=''&&max!=null)
	{
		maxno=parseInt(max,10);

		for(pos=1;pos<=maxno;pos++)
		{
		stage=eval("objForm.chk"+pos+".db_type");
		if(stage=='D'||stage=='I')		
			{
			xmlString+="<DTL"+pos+"  ";
			xmlString+=formXmlString(objForm,pos);
			xmlString+="/>";
			}
		 }	
	}

	return xmlString;
}


function clearAllValue()
{

	var frmObj=document.forms[0];
	
	frmObj.order_catagory.value='*A';
	frmObj.order_type_code.value='';
	frmObj.from_date.value=frmObj.strFromSysDate.value;
	frmObj.to_date.value='';
	frmObj.orderid.value='';
	frmObj.catalog.value='';
	frmObj.status.value='A';
	frmObj.order_catalog_code.value='';

	funPreOpeartiveSearch();
}


function formXmlString(frmObj,pos)
{
 var xmlString='patient_id=\"'+eval("frmObj.patient_id.value")+'\"';
 xmlString+='	booking_no=\"'+eval("frmObj.booking_no.value")+'\"';
 xmlString+='	orderid=\"'+eval("frmObj.orderid"+pos+".value")+'\"';
 xmlString+='	lineno=\"'+eval("frmObj.lineno"+pos+".value")+'\"';
 xmlString+='	db_type=\"'+eval("frmObj.chk"+pos+".db_type")+'\"';
 xmlString+=' order_code=\"'+eval("frmObj.order_code"+pos+".value")+'\"';

 return xmlString;
}

