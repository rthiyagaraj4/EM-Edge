/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function checkcurrdate(dates) 
{
	var fromarray;
	var toarray;
	var date = dates.value;	     
	var d =  new Date(); 
	fromarray =date.split("/");
	var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
	var todt = new Date(d.getYear(),d.getMonth() + 1,d.getDate());	

	if(date.length > 0 )
	{		
		if(dates.name=='msg_dt1')
		{
			if(Date.parse(todt) < Date.parse(fromdt))
			{				
				alert(getMessage("XH1010",'XH'));
				return false;												 
			}
			else if(Date.parse(todt) >= Date.parse(fromdt)) 
				return true;
		}	

		if(dates.name=='msg_dt2')
		{
			if(Date.parse(todt) < Date.parse(fromdt))
			{				
				alert(getMessage("XH1010",'XH'));
				return false;
			}
			else 
				if(Date.parse(todt) >= Date.parse(fromdt)) 
				return true;
		}	
		if(dates.name=='msg_date')
		{
			if(Date.parse(todt) < Date.parse(fromdt))
			{				
				alert(getMessage("XH1010",'XH'));
				return false;
			}
			else 
				if(Date.parse(todt) >= Date.parse(fromdt)) 
				return true;
		}	
		else
		{
			if(Date.parse(todt) < Date.parse(fromdt))
			{				
				alert(getMessage("XH1010",'XH'));
				return false;
			}
			else if(Date.parse(todt) >= Date.parse(fromdt)) 
			{
				return true;
			}
		}
	}
	else return true;	
}

function isAfterCurrDate(obj)
{
	var date = obj.value;
	var locale = document.getElementById("locale").value;	

	if(isValidDate(obj) && date.length > 0 )
	{
		if(!isBeforeNow(date,'DMY',locale))
		{
			alert(getMessage("XH1010",'XH'));
			obj.value = "";
			obj.focus();
			return false;
		}															    
		else
		{
			if(!compareDates())
			{
				obj.value = "";
				obj.focus();
				return false;
			}
		}
	}
}																							   

function isValidDate(obj)
{	
	var date = obj.value;
	var locale = document.getElementById("locale").value;

	if(date.length > 0 )
	{
		if(!validDate(date,'DMY',locale))
		{
			var msg = getMessage("INVALID_VALUE",'COMMON');
			msg = msg.replace('#','Date Format');
			alert(msg);

			obj.value = "";
			obj.focus();
			return false;
		}
		else
		{
			return true;
		}
	}
}

//**********************************************COMPARE DATE*********************************************
function compare(date1,date2) 
{
	var fromarray;
	var toarray;
	var frmdat = date1.value;
	var todat = date2.value;
	var d = new Date(); 
	fromarray = frmdat.split("/");
	toarray = todat.split("/");
	var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
	var todt = new Date(toarray[2],toarray[1],toarray[0]);	

	if((frmdat.length > 0) && (todat.length > 0))
	{
		if(Date.parse(todt) < Date.parse(fromdt))
		{	
			alert(getMessage("XH1009",'XH'));
			return false;
		}
		else 
		{
			if(Date.parse(todt) >= Date.parse(fromdt)) 
			return true;
		}
	}	
	else return true;
}
//********************************************OPEN RESULT PAGE*****************************************************
function func1()
{  
		var msg_dt1 = document.forms[0].msg_dt1.value;
		var msg_dt2 = document.forms[0].msg_dt2.value;
		var msg_id1= document.forms[0].msg_id1.value;
		var msg_id2= document.forms[0].msg_id2.value;
		var applnname= document.forms[0].applnname.value;
		var eventtype= document.forms[0].eventtype.value;
		document.forms[0].comm_mode.disabled = false;
		var comm_mode= document.forms[0].comm_mode.value;
		var facility= document.forms[0].facility.value;
		var event_status= document.forms[0].event_status.value;									 
		var msg_status= document.forms[0].msg_status.value;
		var protocol_link_name= document.forms[0].protocol_link_name.value;
		var purge_status= document.forms[0].purge_status.value;
		var dispMode= document.forms[0].dispMode.value;
		var interface_module= document.forms[0].interface_module.value;
        var params =  "msg_dt1="+msg_dt1+"&msg_dt2="+msg_dt2+"&msg_id1="+msg_id1+"&msg_id2="+msg_id2+"&applnname="+applnname+"&eventtype="+eventtype+"&comm_mode="+comm_mode+"&facility="+facility+"&event_status="+event_status+"&msg_status="+msg_status+"&protocol_link_name="+protocol_link_name+"&purge_status="+purge_status+"&dispMode="+dispMode+"&interface_module="+interface_module;
	//	alert("params "+params);

	module = document.forms[0].interface_module.value;	
	sub_module=document.forms[0].sub_module.value;	
	
	/*if(module == "")
	{		
	//	tab_click('search_tab');
		alert(getMessage('XH1034','XH'));	
		document.forms[0].interface_module.focus();
		return false;
	}
	if(sub_module == "")
	{
	//	tab_click('search_tab');
	//	alert(getMessage('XH1035','XH'));
		alert(getMessage('XH1034','XH'));	
		document.forms[0].sub_module.focus();
		return false;
	} */
// commented as per the new changes
	if(msg_status=='H'){
		if(eventtype=='' || eventtype==null){
			alert(getMessage('XH1011','XH')); 
			document.forms[0].eventtype.focus();
			return false;
		}
	} 

//	document.forms[0].interface_module.value="";
	document.forms[0].comm_mode.disabled = false;
	comm_mode = document.forms[0].comm_mode.value;
	dispMode     = document.forms[0].dispMode.value;	
	
	if(comm_mode == "outbound")
	{
		this.document.forms[0].Rule.value='O';
		if(dispMode == "display") 
		{
			this.document.forms[0].action='../../eXB/jsp/ViewEventseBillDtlsResultPageMain.jsp?'+params;
		}
		else
		{
			this.document.forms[0].action='../../servlet/eXB.GenerateOutboundEventsToXLServlet';
		} 
	}
	else if(comm_mode == "inbound") 
	{
		this.document.forms[0].Rule.value='I';	
		if(dispMode == "display")
		{
			this.document.forms[0].action='../../eXH/jsp/ViewEventsInboundDtlTest1.jsp';		
		}																							   
		else
		{
			this.document.forms[0].action='../../servlet/eXH.GenerateInboundEventsToXLServlet';
		}
	}
	else if(comm_mode == "InterActive")					    
	{
		this.document.forms[0].Rule.value='I';			
		this.document.forms[0].action='../../eXH/jsp/ViewEventsInteractiveDtlTest1.jsp';
	}
//	this.document.forms[0].target=parent.f_query_add_mod;
	this.document.forms[0].submit();
	document.forms[0].interface_module.value = module;
//	parent.messageFrame.location.href='../../eCommon/html/blank.html';
	parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
}

//********************************************Export **************************************************
var selectCnt = 0;
var Selected_MsgId_List = new Array();

function genExcel()
{

	 document.forms[0].action_type.value="R";
	 var msgIdsList = '';
	// if(selectCnt>0 || this.document.forms[0].SelectAll.checked==true){
		  
		 msgIdsList = '';
		 if(selectCnt>0) {
			 for(i=0;i<Selected_MsgId_List.length;i++){
				 if(i==0){
					msgIdsList = "'"+Selected_MsgId_List[i]+"'";
				 }
				 else{
					 msgIdsList = msgIdsList+",'"+Selected_MsgId_List[i]+"'";
				 }
			 }
		 }
		 else if(this.document.forms[0].SelectAll.checked==true){
			 
			  msgIdsList = '';
			  for(i=0;i<Tot_Msg_IdsList.length;i++){
				 if(i==0){
					msgIdsList = "'"+Tot_Msg_IdsList[i]+"'";
				 }
				 else{
					 msgIdsList = msgIdsList+",'"+Tot_Msg_IdsList[i]+"'";
				 }
			 }
		 }						    
					
 	this.document.forms[0].action='../../servlet/eXB.GenerateOutboundEventsToXLServlet?msgIdsList='+msgIdsList;
		this.document.forms[0].submit();
	 //}
	// else
	//{
	   	//alert("Atleast One Record should be selected ... ");
	//}
//	this.document.forms[0].action='../../servlet/eXB.GenerateOutboundEventsToXLServlet';
													  
}

//********************************************WriteToExcel **************************************************
function genExport()
{
																			    
 
//	if(selectCnt<1 && this.document.forms[0].SelectAll.checked==false){
//		alert("Atleast One Record should be selected ... ");
//	}
//	else if(selectCnt>0 || this.document.forms[0].SelectAll.checked==true){
		 var msgIdsList = '';
		 if(selectCnt>0) {												 
			 for(i=0;i<Selected_MsgId_List.length;i++){
				 if(i==0){
					msgIdsList = "'"+Selected_MsgId_List[i]+"'";
				 }
				 else{
					 msgIdsList = msgIdsList+",'"+Selected_MsgId_List[i]+"'";
				 }						   
			 }
		 }
		 else if(this.document.forms[0].SelectAll.checked==true){
			  for(i=0;i<Tot_Msg_IdsList.length;i++){
				 if(i==0){
					msgIdsList = "'"+Tot_Msg_IdsList[i]+"'";
				 }
				 else{
					 msgIdsList = msgIdsList+",'"+Tot_Msg_IdsList[i]+"'";
				 }
			 }
		 }
//		alert("Selected MsgId List : "+Selected_MsgId_List);
//		alert("Total MsgsId List : "+Tot_Msg_IdsList);
		var conf=confirm("Do you want to export the selected records?")
		if(conf)
		{
		//	alert("msgIdsList : "+msgIdsList);
		//	var QryCols	=	escape(this.document.forms[0].QryCols.value);
			var whereClause	=	escape(this.document.forms[0].whereClause.value);
		//	alert("whereClause :"+whereClause);
			var orderBy	=	this.document.forms[0].orderBy.value;
			var eventtype = this.document.forms[0].eventtype.value;

			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			var xmlStr ="<root><SEARCH ";	

			xmlStr += " whereClause=\""+whereClause+"\"";	
			xmlStr += " orderBy=\""+orderBy+"\"";														 
			xmlStr += " eventtype=\""+eventtype+"\"";						   
			xmlStr += " msgIdsList=\""+msgIdsList+"\"";								  
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");			
			xmlHttp.open("POST","ViewEventsBillExport.jsp?func_mode=genExport",false);	
			xmlHttp.send(xmlDoc);	
			eval(xmlHttp.responseText);	

			
//			alert("Selected Records Exported Successfully ...");
		//    var function_id=parent.parent.f_query_add_mod.document.getElementById("function_id").value;
		//	alert("function_id : "+function_id);
			var function_id = 'XB_J_ADMINISTER_EVENTS ';
			parent.parent.f_query_add_mod.location.href='../../eXB/jsp/ViewEventsOutboundHeader.jsp?function_id='+function_id;
			parent.parent.messageFrame.location.href='../../eCommon/html/blank.html';
		//	return xmlHttp.responseText;	
		}
	//}
}

//********************************************exportReload **************************************************
function exportReload()
{
//	alert("exportReload");
//	alert("Messages Exported Successfully ...");
//	alert(window.frames[0].name);
//	window.f_query_add_mod.location.href='../../eXB/jsp/ViewEventsOutboundHeader.jsp?function_id='+function_id;
//	window.messageFrame.location.href='../../eCommon/html/blank.html'

/*	document.forms[0].action = "../../eXB/jsp/ViewEventseBillResult.jsp";		
	this.document.forms[0].target = "f_query_add_mod_dtl";
	document.forms[0].submit(); */						    
}
//********************************************selectAll **************************************************
var Tot_Msg_IdsList = new Array();
function selectAll()
{
//	alert("Tot_Inv_Amount : "+document.forms[0].Tot_Inv_Amount.value);
	var Tot_Inv_Amount = 0;															    
	var rsCnt = document.forms[0].rsCount.value;
//	alert("rsCnt : "+rsCnt);
//	alert(	"ChkBx1 Val : "+this.document.getElementById("SelectAll").value);
	for(var i=0;i<rsCnt;i++){
		if(this.document.forms[0].SelectAll.checked==true){		      
			document.getElementById("select_yn_"+i).checked=true;
			 	  this.document.getElementById("select_yn_"+i).value='Y';
		 this.document.getElementById("select_yn_dubli"+i).value='Y'; 
			  																		    
			Tot_Msg_IdsList[i] = this.document.getElementById("msg_id_"+i).value;
			Tot_Inv_Amount = document.forms[0].Tot_Inv_Amount.value;
			document.forms[0].cum_amount.value = Tot_Inv_Amount;
		}
		else{
			document.getElementById("select_yn_"+i).checked=false;
				  this.document.getElementById("select_yn_"+i).value='N';
		 this.document.getElementById("select_yn_dubli"+i).value='N'; 
			Tot_Msg_IdsList[i] = '';
			document.forms[0].cum_amount.value = Tot_Inv_Amount;		 
		}
	}
}

//********************************************chkEvntImage**************************************************
function chkEvntImage(obj){
	//alert(obj.value);
//	if(obj.value=='H'){
	if(obj=='SRREBL'){
	//	document.getElementById("dispEvntMndtChk").style.display='block';
	//	document.getElementById("dispEvntMndtChkdup").style.display='none';	 

		 document["myImage1"].src='../../eCommon/images/mandatory.gif';
		
	}
	else{
		
		//document.getElementById("dispEvntMndtChk").style.display='none';  
	//	document.getElementById("dispEvntMndtChkdup").style.display='block';  
	 document["myImage1"].src='../../eCommon/images/empty.gif';
	}
}

//********************************************dispAmount**************************************************

function dispAmount(obj,i,cou){


			/*	if(obj.checked==true)
				{
				  obj.value='Y';
				}
				else
				{
				  obj.value='N';
				}
			   var whereClause='';
				  var orderBy='';
		  	 var accession_number=this.document.getElementById("acc_no_"+i).value;
			 var xmlDoc = "" ;
			 var xmlHttp = new XMLHttpRequest() ;
			var xmlStr ="<root><SEARCH ";	
			xmlStr += " whereClause=\""+whereClause+"\"";	
			xmlStr += " orderBy=\""+orderBy+"\"";														 
			xmlStr += " OptionYN=\""+obj.value+"\"";						   
			xmlStr += " accession_number=\""+escape(accession_number)+"\"";		  						  
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","ViewEventsBillExport.jsp?func_mode=genAccessionNum",false);	
			xmlHttp.send(xmlDoc);
	
			eval(xmlHttp.responseText);		*/					    



		
																											 
	var y=0;
	var totalvalues="";											    
		var totalcou=parseInt(i)+parseInt(cou);	  		
		var totalList=document.forms[0].totalMsgList.value;
	if(this.document.getElementById("select_yn_"+i).checked==true){
	   for (var z=i;z<totalcou;z++)
	  {			
	//	   alert("Z = "+z);
    	   this.document.getElementById("select_yn_"+z).enabled=true;	
		 this.document.getElementById("select_yn_"+z).checked=true;	
		  this.document.getElementById("select_yn_"+z).value='Y';
		 this.document.getElementById("select_yn_dubli"+z).value='Y'; 
		
		
	  }
	   for (var k=i;k<totalcou;k++)
	  {

			 if(this.document.getElementById("select_yn_"+k).checked==true){
			//	this.document.getElementById("select_yn_dubli"+k).value='Y'; 
				selectCnt = selectCnt+1;
				Selected_MsgId_List[k] = this.document.getElementById("msg_id_"+k).value;
				

			}
			else if(this.document.getElementById("select_yn_"+k).checked==false){
				//this.document.getElementById("select_yn_dubli"+k).value='N'; 
				selectCnt = selectCnt-1;
				Selected_MsgId_List[k] = '';
			}

	  }

	}
	 else
	{
		 for (var z=i;z<totalcou;z++)
	  {
		 
		 
		 this.document.getElementById("select_yn_"+z).checked=false;   
		   this.document.getElementById("select_yn_"+z).value='N';
		 this.document.getElementById("select_yn_dubli"+z).value='N';      
	  }
	  for (var k=i;k<totalcou;k++)
	  {
			 if(this.document.getElementById("select_yn_"+k).checked==true){
			//	 this.document.getElementById("select_yn_dubli"+z).value='Y'; 
				selectCnt = selectCnt+1;
				Selected_MsgId_List[k] = this.document.getElementById("msg_id_"+k).value;
				

			}
			else if(this.document.getElementById("select_yn_"+k).checked==false){
			//	this.document.getElementById("select_yn_dubli"+z).value='N'; 
				selectCnt = selectCnt-1;
				Selected_MsgId_List[k] = '';
			}

	  }
	}		      

	
	/*if(this.document.getElementById("select_yn_"+i).checked==true){
		selectCnt = selectCnt+1;
		Selected_MsgId_List[i] = this.document.getElementById("msg_id_"+i).value;
	}																				
	else if(this.document.getElementById("select_yn_"+i).checked==false){
		selectCnt = selectCnt-1;
		Selected_MsgId_List[i] = '';
	} */

			   


	/*  for (var z=0;z<parseInt(document.forms[0].rsCount.value);z++)
	  { 
		  if(this.document.getElementById("select_yn_"+z).checked==true){
		totalvalues=totalvalues+document.getElementById("acc_no_"+z).value+",";
		   
	} 	 
		  
	  }	*/								 
	var cum_amount = 0.00;
	var amount = 0.00;
	var result = 0.00;
	cum_amount = parseFloat(this.document.forms[0].cum_amount.value);
	amount = parseFloat(this.document.getElementById("inv_amnt_"+i).value);
	/*if(obj.checked==true){
		result = parseFloat(cum_amount+amount);
		this.document.forms[0].cum_amount.value = result;
	}
	else if(obj.checked==false){
		result = parseFloat(cum_amount-amount);
		this.document.forms[0].cum_amount.value = result;
	} 

*/
	if(obj.checked==true){
		cum_amount = parseFloat(this.document.forms[0].cum_amount.value);
		result = cum_amount;
		for (var cnt=i;cnt<totalcou;cnt++){
			amount = parseFloat(this.document.getElementById("inv_amnt_"+cnt).value);
			result = parseFloat(result)+parseFloat(amount);		
	//		alert("result : "+result);
		}
		this.document.forms[0].cum_amount.value = result;
	}
	else if(obj.checked==false){
		for (var cnt=i;cnt<totalcou;cnt++){
			amount = parseFloat(this.document.getElementById("inv_amnt_"+cnt).value);
			cum_amount = parseFloat(cum_amount-amount);			
	//		alert("cum_amount : "+cum_amount);
		}
		this.document.forms[0].cum_amount.value = cum_amount;
	} 
	 if(totalList==''||totalList==null)
	{
		 document.forms[0].totalMsgList.value=totalList+Selected_MsgId_List;
	}
	else
	{
		document.forms[0].totalMsgList.value=totalList+","+Selected_MsgId_List;
	}
}

//********************************************ShowTotal**************************************************

function ShowTotal(){
//	    alert("ShowTotal");
		Tot_Inv_Amount = parseFloat(this.document.forms[0].Tot_Inv_Amount.value);
		alert("Total Invoice Amount : "+Tot_Inv_Amount+"/-");
}
//********************************************Change Protocol Value**************************************************
function changeProtocolVal()
{
//	document.getElementById("protocol_link_id").value=document.getElementById("protocol_link_name").value;
}
//

//*****************************************************TABVALUE**************************************************
function tab_click(obj)
{
	var div1=document.getElementById("general");
	var div2=document.getElementById("auditional");
	var div3=document.getElementById("audit");

	var tab1=document.getElementById("search_tab");			 
	var tabspan1=document.getElementById("search_tab_tabspan");
	var tab2=document.getElementById("additional_tab");
	var tabspan2=document.getElementById("additional_tab_tabspan");
	var tab3=document.getElementById("audit_tab");
	var tabspan3=document.getElementById("audit_tab_tabspan");

	this.document.forms[0].tabValue.value=obj;

	if(obj == 'search_tab')
	{  					
		tab1.className='tabClicked';				
		tabspan1.className='tabSpanclicked';				
		tab2.className='tabA';
		tabspan2.className='tabAspan';
		tab3.className='tabA';
		tabspan3.className='tabAspan';

		div1.style.display='block';							   
		div2.style.display='none';
		div3.style.display='none';
	}
	if(obj == 'additional_tab')
	{
		tab1.className='tabA';
		tabspan1.className='tabAspan';
		tab2.className='tabClicked';
		tabspan2.className='tabSpanclicked';
		tab3.className='tabA';
		tabspan3.className='tabAspan';

		div1.style.display='none';
		div2.style.display='block';
		div3.style.display='none';
	}
	if(obj == 'audit_tab')
	{
		tab1.className='tabA';
		tabspan1.className='tabAspan';
		tab2.className='tabA';
		tabspan2.className='tabAspan';
		tab3.className='tabClicked';
		tabspan3.className='tabSpanclicked';

		div1.style.display='none';
		div2.style.display='none';
		div3.style.display='block';
	}

//	parent.f_query_add_mod.location.href='../../eXH/jsp/ViewEventsOutboundHeader.jsp';
//	parent.messageFrame.location.href='../../eCommon/html/blank.html';
	parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
}

//*******************************************************************************************************************
function onChangeApplication()
{	
/*	var function_id=parent.document.getElementById("function_id").value;
	document.getElementById("function_id").value=function_id;
	var act="../../eXH/jsp/ViewEventsOutboundHeader.jsp";
	this.document.forms[0].action=act;
//	this.document.forms[0].target="f_query_header";
	this.document.forms[0].submit();
*/															   
	locale = document.getElementById("locale").value;
	moduleID = document.getElementById("sub_module").value;
//	alert("moduleID : "+moduleID);
	var functionID = document.getElementById("function_id").value;
	applicationID  = document.getElementById("applnname").options[document.getElementById("applnname").selectedIndex].value;	
//	alert("applicationID : "+applicationID);
	var commMode = document.getElementById("comm_mode").value;

	chkEvntImage(applicationID);

	if(commMode == "inbound") commMode = "I";
	else commMode = "O";
	
	queryEventType = "SELECT DISTINCT me.EVENT_TYPE code, me.EVENT_NAME name FROM xh_application_event_type M,XH_EVENT_TYPE_LANG_VW me WHERE me.LANGUAGE_ID='"+locale+"' AND (me.communication_type = '"+commMode+"' OR me.communication_type = '*') AND M.APPLICATION_ID = NVL('"+applicationID+"',M.APPLICATION_ID) AND m.event_TYPE = ME.EVENT_TYPE AND m.event_type != 'A19'"+
					" AND m.event_type IN (SELECT EVENT_TYPE FROM XH_DATA_GROUP_DETAIL WHERE DATA_GROUP_ID IN "+
					" (SELECT DATA_GROUP_ID FROM xh_protocol_link xpl,xh_protocol xp WHERE xp.protocol_id=xpl.protocol_id and xp.INTERFACE_MODULE_ID='"+moduleID+"'))";
	queryFacility = "SELECT DISTINCT A.FACILITY_ID code, s.facility_name name FROM XH_DATA_GROUP_DETAIL a, sm_facility_param_lang_vw s  WHERE s.LANGUAGE_ID='"+locale+"' AND a.facility_id = s.facility_id AND a.application_id = NVL('"+applicationID+"', application_id) ";

	eval(sendRequest(queryEventType,'eventtype','All',"both"));
	if(functionID == "XH_J_ADMINISTER_EVENTS" || functionID == "XF_J_ADMINISTER_EVENTS" || functionID == "XI_J_ADMINISTER_EVENTS")
	{		
		eval(sendRequest(queryFacility,'facility','All'));
	}
							 
	 if(functionID == "XH_J_ADMINISTER_INTRC_EVENTS" )	    
	{		

		queryEventType	= "SELECT DISTINCT me.EVENT_TYPE code, me.EVENT_NAME name FROM xh_application_event_type M,XH_EVENT_TYPE_LANG_VW me	 WHERE me.LANGUAGE_ID='"+locale+"' AND (me.communication_type ='"+commMode+"' OR me.communication_type = '*')	  AND M.APPLICATION_ID = NVL('"+applicationID+"',M.APPLICATION_ID) AND m.event_TYPE = ME.EVENT_TYPE AND m.event_type != 'A19'";
		eval(sendRequest(queryEventType,'eventtype','All',"both"));  


	    queryFacility = "SELECT DISTINCT A.FACILITY_ID code, s.facility_name name FROM XH_DATA_GROUP_DETAIL a, sm_facility_param s  WHERE s.LANGUAGE_ID='"+locale+"' AND a.facility_id = s.facility_id AND a.application_id = NVL('"+applicationID+"', application_id) ";
		eval(sendRequest(queryFacility,'facility','All'));					 
	}		
}
//*******************************************************************************************************************
function populateApplication()
{
	var selectApp=document.getElementById("applnname");
	for(var i=0;i<selectApp.options.length;i++)
	{	
		if(selectApp.options[i].value=='<%=applicationId%>')
		{
			selectApp.options[i].selected=true;
		}
	}
}
//****************************************************************************************************************
function changeProtocolLink(){   
		document.forms[0].protocol_link_name.value = "";
		document.forms[0].protocol_link_id.value = "";
}
//****************************************************************************************************************
async function searchProtocolID(){     		
			var tdesc="";
            var tcode="";
			var appID=document.getElementById("applnname").value;
			var commMode=document.getElementById("comm_mode").value;
			if(commMode == "outbound") commMode="O";
			else if(commMode == "inbound") commMode="I";
			
            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit=getLabel("eXH.Gateway.Label",'XH');
            var target=this.document.forms[0].protocol_link_name;
			var id=this.document.forms[0].protocol_link_id;
			var eventtype= document.forms[0].eventtype.value;	
			if (eventtype=='')
			{
//				alert(getMessage('XB1060','XB'));
				alert("APP-XB1060 Select the Event Type");
			}
			else{
		
  /*          sql="SELECT PROTOCOL_LINK_ID code,PROTOCOL_LINK_NAME description FROM XH_PROTOCOL_LINK "+
                    "   WHERE UPPER(PROTOCOL_LINK_ID) LIKE UPPER(?) AND "+ 
                    "   UPPER(PROTOCOL_LINK_NAME) LIKE UPPER(?) AND "+
					"	PROTOCOL_ID IN (SELECT PROTOCOL_ID FROM xh_protocol WHERE PROTCOL_MODE='"+commMode+"') "; */

			 sql="SELECT a.protocol_link_id code, b.protocol_link_name description FROM  XH_DATA_GROUP_DETAIL a, XH_PROTOCOL_LINK b  WHERE a.protocol_link_id = b.protocol_link_id AND a.event_type ='"+eventtype+"' AND UPPER(a.PROTOCOL_LINK_ID) LIKE UPPER(?) AND               UPPER(b.PROTOCOL_LINK_NAME) LIKE UPPER(?) ";

			if(appID != "")
			{
				sql=sql+" AND a.application_id ='"+appID+"'";
			}
			sql=sql+" ORDER BY 1";
			
            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
	        argumentArray[4] = "1,2";
            argumentArray[5] = target.value;
            argumentArray[6] = "2"  ;
            argumentArray[7] = "DESC_CODE" ;
         
            retVal = await CommonLookup( tit, argumentArray );			
            
			var ret1=unescape(retVal);
			arr=ret1.split(",");
			id.value=arr[0];
			
			if(arr[1] == undefined)	target.value="";					 
			else target.value=arr[1];            
			}
}// End of searchProtocolLink

//****************************************************************************************************************

function onChangeCommMode(obj)
{
/*	var mod_name	=	obj.value;
	mod_name = mod_name.substring(mod_name.indexOf("_")+1,mod_name.length);
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";	
	xmlStr += " base_unit=\""+mod_name+"\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","AjaxUtil.jsp?func_mode=setTables",false);	
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);	
*/		
	locale = document.getElementById("locale").value;	
	moduleID = obj.options[obj.selectedIndex].value;	
	subModuleQuery = "SELECT INTERFACE_MODULE_ID code, INTERFACE_DESC name FROM XH_INTERFACE WHERE MODULE_ID='"+moduleID+"'";
	eval(sendRequest(subModuleQuery,'sub_module',getLabel("Common.defaultSelect.label",'common')));
}
function clearOptions()	{ 
	var list_obj	=document.forms[0].sub_module;
	var len =list_obj.options.length;
	for(var i=0;i<len;i++) {
		list_obj.remove("sub_module");
	}

	var tp = getLabel("Common.defaultSelect.label",'common');
	var opt = document.createElement("OPTION");
	opt.text = tp ;
	opt.value = "" ;
	list_obj.add(opt);
}

function addOption(id,desc)	
{ 
	var element = document.createElement('OPTION');
	element.value		=  '_'+id ;
	element.text		= desc ;
	document.forms[0].sub_module.add(element);
}

function validateFields()
{
	var flag=true;
	flag=checkcurrdate(document.forms[0].msg_dt1);
	if(flag)
	{
		flag=checkcurrdate(document.forms[0].msg_dt2);
	}
	else
	{
		document.forms[0].msg_dt1.focus();
		return;
	}	
	if(flag)
	{		
		flag=checkcurrdate(document.forms[0].msg_date);
	}
	else
	{
		document.forms[0].msg_dt2.focus();
		return;
	}
	if(flag)
	{		
		flag=checkcurrdate(document.forms[0].last_processed_date);
	}
	else
	{		
		document.forms[0].msg_date.focus();				   
		return;
	}
	if(flag)
	{		
		flag=checkcurrdate(document.forms[0].last_processed_date);
	}																		   
	else
	{
		document.forms[0].last_processed_date.focus();				   
		return;
	}
	if(flag)
	{		
		flag=checkcurrdate(document.forms[0].modifieddate);
	}																		   
	else
	{
		document.forms[0].modifieddate.focus();				   
		return;
	}
	if(flag)
	{		
		flag=checkcurrdate(document.forms[0].addeddate);
	}
	else
	{
		document.forms[0].modifieddate.focus();				 
		return;
	}
	if(flag)
	{
		flag=compare(document.forms[0].msg_dt1,document.forms[0].msg_dt2); 
	}
	else
	{
		document.forms[0].addeddate.focus();					 
		return;
	}
	
	if(flag)
	{		
		flag=func1();		
	}
}

function compareDates()
{
	locale = document.getElementById("locale").value;
	msg_dt1 = document.forms[0].msg_dt1.value;
	msg_dt2 = document.forms[0].msg_dt2.value;

	if(msg_dt1.length > 0 && msg_dt2.length > 0)
	{
		if(!isBefore(msg_dt1,msg_dt2,'DMY',locale))				    
		{
			alert(getMessage("XH1009",'XH'));
			return false;
		}
		else
		{
			return true;
		}
	}
	else
	{
		return true;
	}
}
function hotStateImage(obj)
{	
	obj.className = 'linkClass2';
}

function restorePrevState(obj)
{
	obj.className = 'linkClass1';
}
									    
function funLoad()
{	
	funAction('R');
}

function getGatewayServer()
{
	var protocolLinkID = $("#protocolLinkID ").val();
	var applicationID = $("#applnname ").val();
	var facilityID = "XX";
	var gatewayServerID = getGatewayServerID(protocolLinkID, "eBilling");
	var reqParams = "protocolLinkID=" + protocolLinkID
					+ "&applicationID=" + applicationID
					+ "&facilityID=" + facilityID
					+ "&gatewayServerID=" + gatewayServerID
					+ "&commType=O";
/*	var req = "{protocolLinkID:" + protocolLinkID
					+ ",applicationID:" + applicationID
					+ ",facilityID:" + facilityID
					+ ",gatewayServerID:" + gatewayServerID
					+ ",commType:O}";
*/
//	$.post("../../servlet/eXH.GatewayServiceServlet", req,
//	function(data) {
//		alert("Data Loaded: " + data);
//	});

//	$.post('../../servlet/eXH.GatewayServiceServlet',
//		reqParams,
//		success:function(data) {
//	  alert(data);
//	},'text');

//	$.ajax({
//			type: "GET",
//			url: "../../servlet/eXH.GatewayServiceServlet",
//			data: reqParams,
//			success: function(){callTest1()},
//			error: function(){callTest1()},
//			complete: function(){callTest1()}
//		});
/*
	$.ajax({
	  type: 'GET',
	  url: '../../servlet/eXH.GatewayServiceServlet',
	  data: reqParams,
	  success: function(data) {alert(data);},
	  dataType: 'text'
	});
*/
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";	
	xmlStr += " query=\""+protocolLinkID+"\"";
	xmlStr += " field=\""+protocolLinkID+"\"";
	xmlStr += " toDisplay=\""+protocolLinkID+"\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("GET","../../servlet/eXH.GatewayServiceServlet?"+reqParams,false);	
	xmlHttp.send(xmlDoc);
	alert(xmlHttp.responseText);	
}

