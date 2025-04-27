<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,eOR.*,eOR.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	HttpSession httpSession = request.getSession(false);
	//Properties p = (Properties)httpSession.getValue("jdbc");		
	Connection con = null;
	PreparedStatement pstmt = null ;
	ResultSet rs23 = null; ResultSet rscurr=null;			
	String queryString="";
	String p_episode_type=""; String p_patient_id=""; String p_visit_id="";String p_episode_id="";
	String locale	= (String)session.getAttribute("LOCALE");
	String p_module_id="";String p_service_date=""; String p_service_panel_ind=""; String p_service_panel_code="";
	String include_label="";String exclude_label="";String stradd_services_during_entry_yn="";
	String facility_id="";	String str_encounter_id="";	String str_acct_seq_no="";String rate_label="";
	String charge_label="";String p_order_id=""; String p_order_line_no=""; 
	String str_or_bean_id=""; // Added for BL_OR Enhancement
	String str_or_key ="";String str_or_key_line_no="";
	String dirIndirChrgsFlag=""; 
	int noofdecimal=2;
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");		
	con	=	ConnectionManager.getConnection(request);
	String orig_qty="";
	/****ghl-crf-1.2**************/
	String calledfrmencYN="N";
	String bean_id_bl ="";
	//String bean_name_bl="";
//	HashMap finDtls		= new HashMap();
	/******end*******************/ 

	try
	{
		
		
		 orig_qty=request.getParameter("original_qty");
		System.out.println("original_qty"+orig_qty);
		facility_id = (String)httpSession.getValue("facility_id");
		//login_user =  p.getProperty("login_user");
		queryString=(request.getQueryString());
//		System.out.println("queryString btn"+queryString);
		p_episode_type = request.getParameter("episode_type");
		if(p_episode_type==null || p_episode_type.equals("")) p_episode_type="";
		p_patient_id = request.getParameter("patient_id");
		if(p_patient_id==null || p_patient_id.equals("")) p_patient_id="";
		p_visit_id = request.getParameter("visit_id");
		if(p_visit_id==null || p_visit_id.equals("")) p_visit_id="0";
		p_episode_id = request.getParameter("episode_id");
		if(p_episode_id==null || p_episode_id.equals("")) p_episode_id="0";
		p_module_id = request.getParameter("module_id");
		if(p_module_id==null || p_module_id.equals("")) p_module_id="";
		p_service_date = request.getParameter("service_date");			
		if(p_service_date==null || p_service_date.equals("")) p_service_date="";
//		p_service_date=com.ehis.util.DateUtils.convertDate(p_service_date,"DMYHMS","en",locale);
		p_service_panel_ind = request.getParameter("service_panel_ind");
		if(p_service_panel_ind==null || p_service_panel_ind.equals("")) p_service_panel_ind="";		
		p_service_panel_code = request.getParameter("service_panel_code");
		if(p_service_panel_code==null || p_service_panel_code.equals("")) p_service_panel_code="";		
		dirIndirChrgsFlag = request.getParameter("dirIndirChrgsFlag");
		if(dirIndirChrgsFlag==null || dirIndirChrgsFlag.equals("")) dirIndirChrgsFlag="";		
		/*include_label=request.getParameter("include_label");
		if(include_label==null || include_label.equals("")) include_label="";
		exclude_label=request.getParameter("exclude_label");
		if(exclude_label==null || exclude_label.equals("")) exclude_label="";
		rate_label=request.getParameter("rate_label");
		if(rate_label==null || rate_label.equals("")) rate_label="";		
		charge_label=request.getParameter("charge_label");
		if(charge_label==null || charge_label.equals("")) charge_label="";*/
		p_order_id = request.getParameter("order_id");
		if(p_order_id==null || p_order_id.equals("")) p_order_id="";	
		p_order_line_no= request.getParameter("order_line_no");
		if(p_order_line_no==null || p_order_line_no.equals("")) p_order_line_no="";	
		include_label=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Included.label","common_labels");
		exclude_label=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.Excluded.label","bl_labels");
		rate_label=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.RATE.label","bl_labels");
		charge_label=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Charge.label","common_labels");
	/****ghl-crf-1.2*************/	
		calledfrmencYN=request.getParameter("patregnchargeYN");
		if(calledfrmencYN==null) calledfrmencYN="";
	/******end*******************/
		if(calledfrmencYN.equals("Y"))
		{
			bean_id_bl=request.getParameter("bean_id");
			if(bean_id_bl==null) bean_id_bl="";
		}else{			
			str_or_bean_id=request.getParameter("bean_id");
			if(str_or_bean_id==null) str_or_bean_id="";
		}
			
		str_or_key=request.getParameter("key");
		if(str_or_key==null) str_or_key="";

		str_or_key_line_no=request.getParameter("key_line_no");
		if(str_or_key_line_no==null) str_or_key_line_no="";

		str_encounter_id=request.getParameter("encounter_id");
		if(str_encounter_id==null || str_encounter_id.equals("")) str_encounter_id="0";
		str_acct_seq_no=request.getParameter("acct_seq_no");
		if(str_acct_seq_no==null || str_acct_seq_no.equals("")) str_acct_seq_no="0";
		String sql_pan_desc= "";
		if(p_service_panel_ind.equals("L"))
		{
// Commented for PE Changes
//			sql_pan_desc= "SELECT nvl(add_services_during_entry,'N') FROM bl_panel_hdr_lang_vw WHERE OPERATING_FACILITY_ID  ='"+facility_id+"'AND  panel_code = '"+p_service_panel_code+"' AND language_id='"+locale+"'";

			sql_pan_desc= "SELECT nvl(add_services_during_entry,'N') FROM bl_panel_hdr WHERE OPERATING_FACILITY_ID  ='"+facility_id+"'AND  panel_code = '"+p_service_panel_code+"'";
			pstmt = con.prepareStatement(sql_pan_desc);
			rs23 = pstmt.executeQuery() ;
			if( rs23 != null ) 
			{
				while( rs23.next() )
				{  
					stradd_services_during_entry_yn =  rs23.getString(1);
					if(stradd_services_during_entry_yn==null) stradd_services_during_entry_yn="";
				}//while
			}//if 
				rs23.close();
				pstmt.close();
		 }
			else
			{
				stradd_services_during_entry_yn="N";
			}

			try
			{		
				pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
				rscurr = pstmt.executeQuery();	
				while(rscurr.next())
				{
					noofdecimal  =  rscurr.getInt(1);		
				}
				rscurr.close();
				pstmt.close();
			}catch(Exception e) {System.out.println("3="+e.toString());}

	}catch(Exception eX)
	{	
		out.println("Error= "+eX);			
	}
	finally{
		if(con!=null) {
		ConnectionManager.returnConnection(con, request);
						}
		}
%>

<html>
	<head>
		<script>
//				var decimal=document.forms[0].noofdecimal.value;
				var service="";
				var blng_service_code="";
				var incl_excl="";
				var incl_excl_action="";
				var reason="";
				var action_reason_code="";
				var charge="";
				var original_qty="";
				var uom="";
				var uom_code="";
				var revise_qty="";
				var total_qty="";
				var rate="";
				var practioner_type="";
				var pract_id="";
				var practioner="";
				var pract_staff_id="";
				var total_pay="";
				var patient_pay="";
				var patient_paid="";
				var preappr="";
				var cbflag="";
	        	var total_records="";
				var totalRecords=0;
				var formObj="";
				var modify_qty_yn="";
				var ratecharge_desc="";
				var charged_yn="";
				var serv_amt_changed="";
				var excl_incl_ind_for_screen="";

function acceptvalidation()
{
	var formObj = parent.query2.document.edit_enter_main;
	var totalRecords =eval(formObj.total_records.value);
	var module_id=document.forms[0].h_module_id.value;
		
	if(module_id != 'OP' && module_id != 'AE')
	{
		if(totalRecords==0)
		{
		 alert(getMessage("BL6196","BL"));
		 return false;
		}
	}
	
    var service_code_arr=new Array();

	for(var i=0;i<totalRecords;i++)
		{
			var blng_serv_code=eval("parent.frames[2].document.forms[0].blng_serv_code"+i);
			var serv_code=blng_serv_code.value;	
			service_code_arr[i]=serv_code;			
		}

		for (var i=0;i<service_code_arr.length;i++)
		{
		    var serv_code1 = service_code_arr[i];
			var j = i;

		    while(!((j+1)>totalRecords))
		    {
				j++;
				var serv_code2 = service_code_arr[j];
				if(serv_code1==serv_code2)
				{					
					alert(getMessage('BL9604','BL'));
					return false;
				}
		    }
		}



	var a1=new Array();var a2=new Array();var a3=new Array();var a4=new Array();
	var a5=new Array();var a6=new Array();var a7=new Array();var a8=new Array();
	var a8=new Array();var a9=new Array();var a10=new Array();var a11=new Array();
	var asercode=new Array();var aresncode=new Array();var apractid=new Array();
	var auomcode=new Array();var revise_qty=new Array();
	var str_override_yn="";
	//var formObj = parent.query2.document.edit_enter_main;
	//var	totalRecords =eval(formObj.total_records.value);	
	var include_label=document.forms[0].include_label.value;
	var exclude_label=document.forms[0].exclude_label.value;	
	var p_str ="";
	if(formObj.p_service_panel_ind.value == "L")
	{
		p_str =formObj.panel_code.value+":"+totalRecords+"<NR>";
	}
	else if(formObj.p_service_panel_ind.value == "S")
	{
		p_str ="<NR>";
	}

	var i=0;
	for(i=0;i<totalRecords;i++)
	{
	var ser=eval("parent.frames[2].document.forms[0].service"+i);
	a1[i]=ser.value;
	if(false){
		if(a1[i]=="")a1[i]=" ";
	}
	
	
	var charge=eval("parent.frames[2].document.forms[0].charge"+i);
	
	a2[i]=charge.value;	
	if(false){
		if(a2[i]=="")a2[i]=" ";
	}
	
	
	var incl_excl1=eval("parent.frames[2].document.forms[0].incl_excl"+i);
	var incl_excl=incl_excl1.value;
	if((incl_excl==include_label) || (incl_excl=="Include"))
	{	
		a3[i]="I";
	}
	else if((incl_excl==exclude_label) || (incl_excl=="Exclude"))
	{
		a3[i]="E";
	}
	else
	{
		a3[i]="";
	}
	
	if(false){
		if(a3[i]=="")a3[i]=" ";
	}
	
//	a3[i]=incl_excl.value;
//	if(a3[i]=="")a3[i]=" ";
	
	var reason=eval("parent.frames[2].document.forms[0].reason"+i);
	a4[i]=reason.value;
	if(false){
	if(a4[i]=="")a4[i]=" ";
	}
	
	var pract_id=eval("parent.frames[2].document.forms[0].pract_id"+i);
	a5[i]=pract_id.value;
	if(false){
	if(a5[i]=="")a5[i]=" ";
	}
/*	if(a5[i]=="Practitioner") a5[i]="P";
	else a5[i]="O";
*/	
	var pract_staff_id=eval("parent.frames[2].document.forms[0].pract_staff_id"+i);
	a6[i]=pract_staff_id.value;
	if(false){
	if(a6[i]=="")a6[i]=" ";
	}
	
	var uom=eval("parent.frames[2].document.forms[0].uom"+i);
	a7[i]=uom.value;
	if(false){
	if(a7[i]=="")a7[i]=" ";
	}
	
	var rate_charge_ind=eval("parent.frames[2].document.forms[0].charge"+i);
	a8[i]=rate_charge_ind.value;
	if(false){
	if(a8[i]=="")a8[i]=" ";
	}
	
	var serv_amt=eval("parent.frames[2].document.forms[0].rate"+i);
	a9[i]=serv_amt.value;
	if(false){
	if(a9[i]=="")a9[i]=" ";
	}
	var rate_temp=a9[i];

	
	var incl_excl_act=eval("parent.frames[2].document.forms[0].incl_excl_action"+i);
	var incl_excl_act1=incl_excl_act.value;
	
	if((incl_excl_act1==include_label) || (incl_excl_act1=="Include"))
	{	
		a10[i]="I";
	}
	else if((incl_excl_act1==exclude_label) || (incl_excl_act1=="Exclude"))
	{
		a10[i]="E";
	}
	else
	{
		a10[i]="";
	}	

	if(false){
	if(a10[i]=="")a10[i]=" ";	
	}
	var preappr_reqd=eval("parent.frames[2].document.forms[0].preappr_reqd"+i);
	/*a11[i]=preappr_reqd.value;
	if(a11[i]=="")a11[i]=" ";*/
	if(preappr_reqd.checked)
		{
		a11[i]="Y";
		}
		else{
			if(false){
			a11[i]=" ";
			}
			else{
				a11[i]="";
			}
			}
	var blng_serv_code=eval("parent.frames[2].document.forms[0].blng_serv_code"+i);
	asercode[i]=blng_serv_code.value;
	if(false){
	if(asercode[i]=="")asercode[i]=" ";
	}
	var action_reason_code=eval("parent.frames[2].document.forms[0].action_reason_code"+i);
	aresncode[i]=action_reason_code.value;
	if(false){
	if(aresncode[i]=="")aresncode[i]=" ";
	}
	var pract_id=eval("parent.frames[2].document.forms[0].pract_id"+i);
	apractid[i]=pract_id.value;
	if(false){
	if(apractid[i]=="")apractid[i]=" ";
	}
	var uom_code=eval("parent.frames[2].document.forms[0].uom_code"+i);
	auomcode[i]=uom_code.value;
	if(false){
	if(auomcode[i]=="")auomcode[i]=" ";
	}
	var revise_qty1=eval("parent.frames[2].document.forms[0].revise_qty"+i);
	revise_qty[i]=revise_qty1.value;
	if(false){
	if(revise_qty[i]=="")revise_qty[i]=" ";
	}
	

	var override_yn=eval("parent.frames[2].document.forms[0].override_allowed_yn"+i);
    var v_override_yn=override_yn.value;
	
	}
	//alert("str_override_yn :"+str_override_yn);

	var retArr=new Array();
	var j=0;	
	for(var i=0;i<totalRecords;i++)
	{	 	retArr[i]=asercode[i]+"#"+a2[i]+"#"+a10[i]+"#"+aresncode[i]+"#"+a5[i]+"#"+a6[i]+"#"+auomcode[i]+"#"+a3[i]+"#"+a11[i]+"#"+revise_qty[i]+"#"+a9[i];
	if(!(i==(totalRecords-1)))
		{
	retArr[i]=retArr[i]+"<NR>";
		}
 //alert("retArr[i] " + retArr[i]);
	}
	
	var total_payable=document.forms[0].total.value;
	var patient_payable=document.forms[0].patient.value;
	var service_panel_ind=document.forms[0].service_panel_ind.value;
	var patient_paid=document.forms[0].patient_paid.value;
	var rate="";
	var retStr="";
	var quantity="";
	var incl_excl_action="";
	var action_reason_code="";
	var mod_pract_ind="";
	var mod_physician_id="";
	var incl_excl_ind_for_serv = "";
	if(service_panel_ind=="S")
	{
		for(var i=0;i<totalRecords;i++)
		{
			var quantity1=eval("parent.frames[2].document.forms[0].revise_qty"+i);
			quantity=quantity1.value;

			var rate1=eval("parent.frames[2].document.forms[0].rate"+i);
			rate=rate1.value;

			var incl_excl_action1=eval("parent.frames[2].document.forms[0].incl_excl_action"+i);
			incl_excl_action=incl_excl_action1.value;

			var action_reason_code1=eval("parent.frames[2].document.forms[0].action_reason_code"+i);
			action_reason_code=action_reason_code1.value;

			var incl_excl1=eval("parent.frames[2].document.forms[0].incl_excl"+i);
			var incl_excl=incl_excl1.value;

			if((incl_excl==include_label) || (incl_excl=="Include"))
			{	
				a3[i]="I";
				excl_incl_ind_for_screen = "I";
			}
			else if((incl_excl==exclude_label) || (incl_excl=="Exclude"))
			{
				a3[i]="E";
				excl_incl_ind_for_screen = "E";
			}
			
			/*if(incl_excl_action=="")
			{
				excl_incl_ind_for_screen=a3[i];
			}
			else
			{
			if(incl_excl_action==include_label)
			{	
				excl_incl_ind_for_screen="I";			
			}
			else if(incl_excl_action==exclude_label)
			{
				excl_incl_ind_for_screen="E";			
			}
			
			}*/
			//excl_incl_ind_for_screen=eval("parent.frames[2].document.forms[0].excl_incl_ind_for_screen"+i);
			//excl_incl_ind_for_screen=excl_incl_ind_for_screen.value;			
	
			var mod_pract_ind=eval("parent.frames[2].document.forms[0].pract_id"+i);
			mod_pract_ind = mod_pract_ind.value;
			var mod_physician_id=eval("parent.frames[2].document.forms[0].pract_staff_id"+i);
			mod_physician_id = mod_physician_id.value;
		}
		if((include_label==incl_excl_action) || ("Include"==incl_excl_action))
		{
			incl_excl_action="I";
		}
		else if((exclude_label==incl_excl_action) || ("Exclude"==incl_excl_action))
		{
			incl_excl_action="E";
		}
		else
		{
			incl_excl_action="";
		}
		
		document.forms[0].incl_excl_action_code_to_or.value=incl_excl_action;
		//alert("378::::::::::::"+ document.forms[0].incl_excl_action_code_to_or.value);
		document.forms[0].action_reason_code_to_or.value=action_reason_code;
		//alert("380::::::::::::"+ document.forms[0].action_reason_code_to_or.value);
		document.forms[0].rate_temp.value=rate_temp;
		document.forms[0].mod_pract_ind.value=mod_pract_ind;
		document.forms[0].mod_physician_id.value=mod_physician_id;
	}
	document.forms[0].override_yn.value=str_override_yn;

	for(var l=0;l<retArr.length;l++)
	{
		retStr=retStr+retArr[l];
	}	
 
	document.forms[0].p_str.value=p_str;
	document.forms[0].p_str1.value=retStr;
	document.forms[0].excl_incl_ind_for_screen.value=excl_incl_ind_for_screen;
	

	if(module_id == 'OR' || module_id == 'OT'){  // Only when called_from is 'OT' this Function will be Returned - Karthik 06/Jan/2016 AMRI-SCF-0427 KDAH-SCF-0367 [IN:060929] 
	
//	var retString="status_flag=true"+"&"+"total_payable="+total_payable+"&patient_payable="+patient_payable+"&quantity="+quantity+"&rate="+rate;
		
	var retArray=new Array();
	retArray[0]="Y";
	retArray[1]=total_payable;
	retArray[2]=patient_payable;
	retArray[3]=patient_paid;
	retArray[4]=quantity;
	retArray[5]=rate;
	retArray[6]=incl_excl_action;
	retArray[7]=action_reason_code;
	retArray[8]=excl_incl_ind_for_screen;
	retArray[9]=mod_pract_ind;
	retArray[10]=mod_physician_id;

/*	alert("Include Exclude Action:"+retArray[6]);
	alert("Action Reason Code:"+retArray[7]);

	
	alert("retArray[0] :" +retArray[0]);
	alert("retArray[1] :" +retArray[1]);
	alert("retArray[2] :" +retArray[2]);
	alert("retArray[3] :" +retArray[3]);*/
	//alert("retArray btn :"+retArray)
	
	//parent.window.returnValue = retArray;
	let dialogBody = parent.parent.document.querySelectorAll("#dialog-body")[parent.parent.document.querySelectorAll("#dialog-body").length-1];
    dialogBody.contentWindow.returnValue = retArray;
    
    /* const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();   */ 
    parent.parent.document.querySelectorAll("#dialog_tag")[parent.parent.document.querySelectorAll("#dialog_tag").length-1].close();
    
    
	//document.forms(0).action="../../servlet/eBL.BLEnterEditChrDetailsServlet";	
	//	parent.window.close();
/*	for(var k=0;k<totalRecords;k++)
	{
		alert("a8[k]" + a8[k]);
		alert("a9[k]" + a9[k]);
	if(a8[k]=="C" && a9[k] == 0 )
	{		
		 alert(getMessage('BL0628','BL'));
		 return;
	}
  	alert("a5[k]" + a5[k]);
	if(a5[k]== "")
	{
	 
	 // parent.frames[2].document.forms[0].practioner_type.focus();	  
  		 alert(getMessage('SY1470','BL'));
		  return;
	}
	
  	
  	if(a5[k]=="")
	{
  		//Focus -- nd_physician_id;
		parent.frames[2].document.forms[0].practioner.focus();	  
		 alert(getMessage('SY1470','BL'));
		  return;
  		
  	}
  		alert("a10[k]" + a10[k]);
		alert("a3[k]" + a3[k]);
		alert("a4[k]" + a4[k]);
  	if((a10[k] != a3[k]) && a4[k] =="")
	{
  		parent.frames[2].document.forms[0].reason.focus();
		alert(getMessage('SY1470','BL'));
		 return;
  	}
	}*/
  	
/*document.forms[0].action="../../eBL/jsp/BLEnterEditChrDtsSubmit.jsp";
	document.forms[0].submit();
	parent.window.close();
*/
document.forms[0].action="../../eBL/jsp/BLEnterEditChrDtsSubmit.jsp";
	document.forms[0].submit();

	}else {
		//parent.window.returnValue = p_str+retStr+"<DELIM>"+total_payable+"<DELIM>"+patient_payable+"<DELIM>"+patient_paid;
		//parent.window.close();
		//let dialogBody = parent.parent.document.getElementById('dialog-body');
	    //dialogBody.contentWindow.returnValue = p_str+retStr+"<DELIM>"+total_payable+"<DELIM>"+patient_payable+"<DELIM>"+patient_paid;
		let dialogBody = parent.parent.document.querySelectorAll("#dialog-body")[parent.parent.document.querySelectorAll("#dialog-body").length-1];
		dialogBody.contentWindow.returnValue = p_str+retStr+"<DELIM>"+total_payable+"<DELIM>"+patient_payable+"<DELIM>"+patient_paid;
	    
	    parent.parent.document.querySelectorAll("#dialog_tag")[parent.parent.document.querySelectorAll("#dialog_tag").length-1].close();
    
	}
}				

function addchargedet()
{
	var retVal = new String();
	var episode_type=document.forms[0].h_episode_type.value;
	var patient_id=document.forms[0].h_patient_id.value;
	var visit_id=document.forms[0].h_visit_id.value;
	var episode_id=document.forms[0].h_episode_id.value;	
	var module_id=document.forms[0].h_module_id.value;
	var service_date=document.forms[0].service_date.value;
	var include_label=document.forms[0].include_label.value;
	var exclude_label=document.forms[0].exclude_label.value;
	var service_panel_ind=document.forms[0].service_panel_ind.value;
	var p_order_id=document.forms[0].p_order_id.value;
	var p_order_line_no=document.forms[0].p_order_line_no.value;
	var practioner_type1="";
	var pract_id1="";
	var practioner1="";
	var pract_staff_id1="";
	var dirIndirChrgsFlag=document.forms[0].dirIndirChrgsFlag.value;
	var original_qty=document.forms[0].orig_qty.value;
	if(original_qty==null || original_qty== "null" || original_qty== "")original_qty="1.00";
	/**Added by Ram ghl-1.2**/
		var calledfrmencYN=document.forms[0].calledfrmencYN.value;
		var bean_id_bl=document.forms[0].bean_id_bl.value;
		//alert("calledfrmencYN btn"+calledfrmencYN);
		//alert("bean_id_bl btn"+bean_id_bl);
	/**End **********************/	

	var str_epi_type_clinic_code=parent.frames[2].document.forms[0].str_epi_type_clinic_code.value;
	str_epi_type_clinic_code=encodeURIComponent(str_epi_type_clinic_code);
	
	var formObj = parent.parent.query2.document.edit_enter_main;
	var total_records=formObj.total_records.value;

	if(total_records !=0)
	{
		var v_charged_yn=eval("parent.frames[2].document.forms[0].charged_yn"+0);	
		if(v_charged_yn.value=="Y")
		{
			alert(getMessage('BL9780','BL'));
			return false;
		}
	}
	var practioner_type="",pract_id="",practioner="",pract_staff_id="";

	for( var i=0;i<total_records;i++)
	{
		if((i+1) == total_records)
		{	
			practioner_type=eval("parent.frames[2].document.forms[0].practioner_type"+i);	
			practioner_type1=practioner_type.value;
			pract_id=eval("parent.frames[2].document.forms[0].pract_id"+i);	
			pract_id1=pract_id.value;
			practioner=eval("parent.frames[2].document.forms[0].practioner"+i);	
			practioner1=practioner.value;
			pract_staff_id=eval("parent.frames[2].document.forms[0].pract_staff_id"+i);	
			pract_staff_id1=pract_staff_id.value;

		}
	}
	
	for(var j=0;j<total_records;j++)
	{
		var temp=eval("formObj.selected_row"+j);
		temp.checked=false;
	}
//	service_date=convertDate(service_date,'DMYHMS',locale,"en"); 
/*
	var dialogTop = "100";
	var dialogHeight = "20" ;
	var dialogWidth = "40" ;
	var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
*/
	var dialogTop = window.dialogTop;
	var dialogHeight = "20" ;
	var dialogWidth = "40" ;
	var dialogLeft="360";
	var features= "dialogTop:" + (eval((dialogTop.substr(0,(dialogTop.indexOf('px')))))+115) + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";dialogLeft:"+dialogLeft+";status=no" ;

	var title=encodeURIComponent(getLabel("eBL.EDIT_ENTER_CHARGE_DETAILS.label","BL"));
	var arguments = "" ;
	var column_sizes = escape("");               
	var column_descriptions ="";	

//var param = "title="+title+"&column_sizes="+column_sizes+"&column_descriptions="+column_descriptions+"&episode_type="+episode_type+"&patient_id="+patient_id+"&visit_id="+visit_id+"&episode_id="+episode_id+"&action=add"+"&module_id="+module_id+"&service_date="+service_date;

/* Added by karthik on Oct-18-2012 to default select a practitioner */
 var totalRecordsInForm =eval(formObj.total_records.value);
 if(totalRecordsInForm==0){
 pract_id1=formObj.session_staff_ind.value;
 practioner1=formObj.session_practitioner.value;
 pract_staff_id1=formObj.session_staff_id.value;
 }

	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"episode_type="+episode_type+"&"+"patient_id="+patient_id+"&"+"visit_id="+visit_id+"&"+"episode_id="+episode_id+"&action=add"+"&"+"module_id="+module_id+"&"+"service_date="+service_date+"&"+"modify_qty_yn="+modify_qty_yn+"&include_label="+encodeURIComponent(include_label)+"&exclude_label="+encodeURIComponent(exclude_label)+"&service_panel_ind="+service_panel_ind+"&p_order_id="+p_order_id+"&p_order_line_no="+p_order_line_no+"&str_epi_type_clinic_code="+str_epi_type_clinic_code+"&practioner_type="+practioner_type1+"&practioner="+encodeURIComponent(practioner1)+"&pract_id="+pract_id1+"&pract_staff_id="+pract_staff_id1+"&calledfrmencYN="+calledfrmencYN+"&bean_id_bl="+bean_id_bl+"&dirIndirChrgsFlag="+dirIndirChrgsFlag+"&original_qty="+original_qty;
	retVal=window.showModalDialog("../../eBL/jsp/BLEnterEditChargeDetailsValidationFrame.jsp?"+param,arguments,features);

	var count="";
	var formObj="";
	var classval="";
	if(retVal!=null)
	{
		var formObj = parent.query2.document.edit_enter_main;
		totalRecords =eval(formObj.total_records.value);
		count =totalRecords + 1; 
		var classval="";
		var arr=new Array();
		if(retVal == null) retVal='';
		if (retVal != null || retVal!="")
		{
			var retVal=unescape(retVal);
			
			
			if(retVal != null && retVal.length>0)
			{			
				arr=retVal.split("::");	
				service=decodeURIComponent(arr[0]);
				if(service==" ")service="";
				blng_service_code=arr[1];
				if(service==" ")service="";
				incl_excl=arr[2];			
				if(incl_excl==" ")incl_excl="";
				incl_excl_action=arr[3];	
				if(incl_excl_action==" ")incl_excl_action="";
				reason=decodeURIComponent(arr[4]);				
				if(reason==" ")reason="";
				action_reason_code=arr[5];
				if(action_reason_code==" ")action_reason_code="";
				charge=arr[6];				
				if(charge==" ")charge="";
				
				original_qty=arr[7];
				if(original_qty==" ")original_qty="";
				modify_qty_yn=arr[8];
				if(modify_qty_yn==" ")modify_qty_yn="";
				uom=decodeURIComponent(arr[9]);
				if(uom==" ")uom="";
				uom_code=arr[10];	
				if(uom_code==" ")uom_code="";
				revise_qty=arr[11];			
				if(revise_qty==" ")revise_qty="";
				total_qty=arr[12];			
				if(total_qty==" ")total_qty="";
				rate=arr[13];				
				if(rate==" ")rate="";
				practioner_type=arr[14];
				if(practioner_type==" ")practioner_type="";
//				if(practioner_type=="P"){practioner_type="Practioner";}
//				if(practioner_type=="O"){practioner_type="OtherStaff";}
				pract_id=arr[15];
				if(pract_id==" ")pract_id="";
				practioner=decodeURIComponent(arr[16]);			
				if(practioner==" ")practioner="";
				pract_staff_id=arr[21];
				if(pract_staff_id==" ")pract_staff_id="";
				total_pay=arr[17];			
				if(total_pay==" ")total_pay="";
				patient_pay=arr[18];
				if(patient_pay==" ")patient_pay="";
				patient_paid=arr[19];
				if(patient_paid==" ")patient_paid="";
				cbflag=arr[20];		
				if(cbflag==" ")cbflag="";
				ratecharge_desc=arr[22];
				if(ratecharge_desc==" ")ratecharge_desc="";
				charged_yn=arr[23];
				if(charged_yn==" ")charged_yn="";

				override_yn=arr[24];
				if(override_yn==" ")override_yn="";

			//	net_amount=arr[25];
			//	if(net_amount==" ")net_amount="";

				serv_amt_changed=arr[25];
				if(serv_amt_changed==" ")serv_amt_changed="";

				excl_incl_ind_for_screen = arr[26];
				if(excl_incl_ind_for_screen == " ") excl_incl_ind_for_screen="";
				
			}
		}
		var record_select=count;

		for(var j=totalRecords;j<count;j++ )
		{
				if(j % 2 == 0 )
				{
					classval	=	"QRYEVEN";
				}
				else
				{
					classval	=	"QRYODD";
				}		
			
			curr_row	=	formObj.ins_data.insertRow();
			curr_row.id= "row"+eval(totalRecords+1);
	
			cell	=	curr_row.insertCell();
			curr_row.cells[0].className	= classval;
			curr_row.cells[0].WIDTH	= "9%";
			curr_row.cells[0].insertAdjacentHTML("beforeend", "<input type='checkbox'  name='selected_row"+j+"' id='selected_row"+j+"' style='text-align:right'  value='' onClick='selected("+j+");' >");
			//curr_row.cells[0].insertAdjacentHTML("beforeend", "<a onClick='modify_remove_payer("+j+");'><u>"+record_select+"</u></a>");

			cell	=	curr_row.insertCell();
			curr_row.cells[1].className	= classval;
			curr_row.cells[1].WIDTH	= "10%";
			curr_row.cells[1].insertAdjacentHTML("beforeend", "<input maxlength='30' size='10' type=text readonly name='service"+j+"' id='service"+j+"'  value=\""+service+"\" onFocus='check("+j+");' ><input type=hidden name='blng_serv_code"+j+"' id='blng_serv_code"+j+"' value=\""+blng_service_code+"\"  >");
		

			cell	=	curr_row.insertCell();
			curr_row.cells[2].className	=classval;
			curr_row.cells[2].WIDTH	= "18%";
			curr_row.cells[2].insertAdjacentHTML("beforeend", "<input type='text' maxlength='15' size='10' readonly name='incl_excl"+j+"' id='incl_excl"+j+"'   value=\""+incl_excl+"\" onFocus='check("+j+");' >");

	
			cell	=	curr_row.insertCell();
			curr_row.cells[3].className	=classval;
			curr_row.cells[3].WIDTH	= "18%";
			curr_row.cells[3].insertAdjacentHTML("beforeend", "<input type='text' maxlength='15' size='10' readonly name='incl_excl_action"+j+"' id='incl_excl_action"+j+"'   value=\""+incl_excl_action+"\" onFocus='check("+j+");' >");
		
			cell	=	curr_row.insertCell();
			curr_row.cells[4].className	=classval;
			curr_row.cells[4].WIDTH	= "15%";
			curr_row.cells[4].insertAdjacentHTML("beforeend", "<input type='text' maxlength='5' size='10' readonly name='reason"+j+"' id='reason"+j+"'  value='"+reason+"' onFocus='check("+j+");' ><input type=hidden name='action_reason_code"+j+"' id='action_reason_code"+j+"' value=\""+action_reason_code+"\" >");
		
			cell	=	curr_row.insertCell();
			curr_row.cells[5].className	=classval;
			curr_row.cells[5].WIDTH	= "5%";
			curr_row.cells[5].insertAdjacentHTML("beforeend", "<input type='text' maxlength='30' size='10' readonly name='ratecharge_desc"+j+"' id='ratecharge_desc"+j+"'  value='"+ratecharge_desc+"' onFocus='check("+j+");' ><input type='hidden'  name='charge"+j+"' id='charge"+j+"'  value=\""+charge+"\" onFocus='check("+j+");' >");
		
			cell	=	curr_row.insertCell();
			curr_row.cells[6].className	=classval;
			curr_row.cells[6].WIDTH	= "15%";
			curr_row.cells[6].insertAdjacentHTML("beforeend", "<input type='text' maxlength='7' size='10' readonly name='original_qty"+j+"' id='original_qty"+j+"' style='text-align:right'  value='"+original_qty+"' onFocus='check("+j+")' style='text-align:right' ><input type=hidden name='modify_qty_yn"+j+"' id='modify_qty_yn"+j+"' value=\""+modify_qty_yn+"\" >");

			cell	=	curr_row.insertCell();
			curr_row.cells[7].className	=classval;
			curr_row.cells[7].WIDTH	= "10%";
			curr_row.cells[7].insertAdjacentHTML("beforeend", "<input type='text' maxlength='30' size='4' readonly name='uom"+j+"' id='uom"+j+"'   value='"+uom+"' onFocus='check("+j+")' ><input type=hidden name='uom_code"+j+"' id='uom_code"+j+"' value=\""+uom_code+"\" >");
	
			cell	=	curr_row.insertCell();
			curr_row.cells[8].className	=classval;
			curr_row.cells[8].WIDTH	= "20%";
			curr_row.cells[8].insertAdjacentHTML("beforeend", "<input type='text' maxlength='7' size='10' readonly name='revise_qty"+j+"' id='revise_qty"+j+"' style='text-align:right'  value=\""+revise_qty+"\" onFocus='check("+j+");changeColor("+j+");' style='text-align:right' ><input type='hidden'  name='serv_amt_changed"+j+"' id='serv_amt_changed"+j+"'  value=\""+serv_amt_changed+"\" onFocus='check("+j+");' >");
	
			cell	=	curr_row.insertCell();
			curr_row.cells[9].className	=classval;
			curr_row.cells[9].WIDTH	= "4%";
			curr_row.cells[9].insertAdjacentHTML("beforeend", "<input type='text' maxlength='7' size='10' readonly name='total_qty"+j+"' id='total_qty"+j+"' style='text-align:right'  value=\""+total_qty+"\" onFocus='check("+j+");' style='text-align:right'>");
	
		
			curr_row	=	formObj.ins_data.insertRow();
			curr_row.id= "row"+eval(totalRecords+1);
		
			cell	=	curr_row.insertCell();
			curr_row.cells[0].className	= classval;
			curr_row.cells[0].WIDTH	= "9%";
			curr_row.cells[0].insertAdjacentHTML("beforeend", "");		
		
			cell	=	curr_row.insertCell();
			curr_row.cells[1].className	=classval;
			curr_row.cells[1].WIDTH	= "10%";
			curr_row.cells[1].insertAdjacentHTML("beforeend", "<input type='text' maxlength='10' size='14' readonly name='rate"+j+"' id='rate"+j+"' style='text-align:right'  value=\""+rate+"\" onFocus='check("+j+");' >");
	
			cell	=	curr_row.insertCell();
			curr_row.cells[2].className	=classval;
			curr_row.cells[2].WIDTH	= "18%";
			curr_row.cells[2].insertAdjacentHTML("beforeend", "<input type='text' maxlength='30' size='10' readonly name='practioner_type"+j+"' id='practioner_type"+j+"'  value=\""+practioner_type+"\" onFocus='check("+j+");' ><input type=hidden name='pract_id"+j+"' id='pract_id"+j+"' value='"+pract_id+"' >");

			cell	=	curr_row.insertCell();
			curr_row.cells[3].className	=classval;
			curr_row.cells[3].WIDTH	= "18%";
			curr_row.cells[3].insertAdjacentHTML("beforeend", "<input type='text' maxlength='30' size='10' readonly 	name='practioner"+j+"' id='practioner"+j+"'  value=\""+practioner+"\" onFocus='check("+j+");' ><input type=hidden name='pract_staff_id"+j+"' id='pract_staff_id"+j+"' value='"+pract_staff_id+"' >");
		
			cell	=	curr_row.insertCell();
			curr_row.cells[4].className	=classval;
			curr_row.cells[4].WIDTH	= "15%";
			curr_row.cells[4].insertAdjacentHTML("beforeend", "<input type='text' maxlength='30' size='14' readonly name='total_pay"+j+"' id='total_pay"+j+"' style='text-align:right'  value=\""+total_pay+"\" onFocus='check("+j+");' style='text-align:right'>");
		
			cell	=	curr_row.insertCell();
			curr_row.cells[5].className	=classval;
			curr_row.cells[5].WIDTH	= "5%";
			curr_row.cells[5].insertAdjacentHTML("beforeend", "<input type='text' maxlength='30' size='14' readonly name='patient_pay"+j+"' id='patient_pay"+j+"' style='text-align:right'  value=\""+patient_pay+"\" onFocus='check("+j+");' style='text-align:right' ><input type=hidden name='override_allowed_yn"+j+"' id='override_allowed_yn"+j+"' value=\""+override_yn+"\" >");

			cell	=	curr_row.insertCell();
			curr_row.cells[6].className	=classval;
			curr_row.cells[6].WIDTH	= "15%";
			curr_row.cells[6].insertAdjacentHTML("beforeend", "<input type='text' maxlength='30' size='14' readonly name='patient_paid"+j+"' id='patient_paid"+j+"' style='text-align:right'  value='"+patient_paid+"' onFocus='check("+j+");' style='text-align:right' ><input type=hidden name='charged_yn"+j+"' id='charged_yn"+j+"' value=\""+charged_yn+"\" ><input type=hidden name='excl_incl_ind_for_screen"+j+"' id='excl_incl_ind_for_screen"+j+"' value=\""+excl_incl_ind_for_screen+"\" >");		
		
			cell	=	curr_row.insertCell();
			curr_row.cells[7].className	=classval;
			curr_row.cells[7].WIDTH	= "10%";
			curr_row.cells[7].insertAdjacentHTML("beforeend", "<input type='checkbox' maxlength='30' size='10'  "+cbflag+"	name='preappr_reqd"+j+"' id='preappr_reqd"+j+"' value="+cbflag+" onFocus='check("+j+");' onclick='check_box("+j+")'>");
		
			cell	=	curr_row.insertCell();
			curr_row.cells[8].className	=classval;
			curr_row.cells[8].WIDTH="20%";
			curr_row.cells[8].insertAdjacentHTML("beforeend", "");

					cell	=	curr_row.insertCell();
			curr_row.cells[9].className	=classval;
			curr_row.cells[9].WIDTH="4%";
			curr_row.cells[9].insertAdjacentHTML("beforeend", "");

			record_select++;
		}
		formObj.total_records.value=count;

		totpayable();
	}
	else
	{
//		alert("closed");
	}
	
}
		
		

async function modifychargedet()
{
	var checked_row=parent.frames[2].document.forms[0].checked_row.value;
	var episode_type=document.forms[0].h_episode_type.value;
	var patient_id=document.forms[0].h_patient_id.value;
	var visit_id=document.forms[0].h_visit_id.value;
	var episode_id=document.forms[0].h_episode_id.value;
	var service_date=document.forms[0].service_date.value;
	var module_id=document.forms[0].h_module_id.value;
	var include_label=document.forms[0].include_label.value;
	var exclude_label=document.forms[0].exclude_label.value;
	var str_encounter_id=document.forms[0].encounter_id.value;
	var str_acc_seq_no=document.forms[0].acc_seq_no.value;
	var service_panel_ind=document.forms[0].service_panel_ind.value;
	var panel_qty=parent.frames[2].document.forms[0].panel_qty.value;
/**Added by Ram ghl-1.2**/
		var calledfrmencYN=document.forms[0].calledfrmencYN.value;
		var bean_id_bl=document.forms[0].bean_id_bl.value;
	//	alert("calledfrmencYN btn"+calledfrmencYN);
	//	alert("bean_id_bl btn"+bean_id_bl);
/**End **********************/	
	var str_epi_type_clinic_code=parent.frames[2].document.forms[0].str_epi_type_clinic_code.value;
	str_epi_type_clinic_code=encodeURIComponent(str_epi_type_clinic_code);
	var cbflag="";
    var dirIndirChrgsFlag=  document.forms[0].dirIndirChrgsFlag.value;       

	var p_order_id=document.forms[0].p_order_id.value;
	var p_order_line_no=document.forms[0].p_order_line_no.value;
//	service_date=convertDate(service_date,'DMYHMS',locale,"en"); 
	if(checked_row=="")
	{		
		alert(getMessage("ATLEAST_ONE_SELECTED","common"));
	}
	else
	{
		
		var service1=parent.frames[2].document.getElementById('service'+checked_row);
		service=service1.value;	

		var blng_serv_code1=parent.frames[2].document.getElementById('blng_serv_code'+checked_row);
		blng_serv_code=blng_serv_code1.value;	
		
		
		var incl_excl1=parent.frames[2].document.getElementById('incl_excl'+checked_row);
		incl_excl=incl_excl1.value;		
		
		

		var incl_excl_action1=parent.frames[2].document.getElementById('incl_excl_action'+checked_row);
		incl_excl_action=incl_excl_action1.value;		


		var reason1=parent.frames[2].document.getElementById('reason'+checked_row);
		reason=reason1.value;

		var action_reason_code1=parent.frames[2].document.getElementById('action_reason_code'+checked_row);
		action_reason_code=action_reason_code1.value;		

		var ratecharge_desc1=parent.frames[2].document.getElementById('ratecharge_desc'+checked_row);
		ratecharge_desc=ratecharge_desc1.value;
		

		var charge1=parent.frames[2].document.getElementById('charge'+checked_row);
		charge=charge1.value;

		var original_qty1=parent.frames[2].document.getElementById('original_qty'+checked_row);
		original_qty=original_qty1.value;

		var modify_qty_yn1=parent.frames[2].document.getElementById('modify_qty_yn'+checked_row);
		modify_qty_yn=modify_qty_yn1.value;
		
		var uom1=parent.frames[2].document.getElementById('uom'+checked_row);
		uom=uom1.value;

		var uom_code1=parent.frames[2].document.getElementById('uom_code'+checked_row);
		uom_code=uom_code1.value;

		var revise_qty1=parent.frames[2].document.getElementById('revise_qty'+checked_row);
		revise_qty=revise_qty1.value;

		var total_qty1=parent.frames[2].document.getElementById('total_qty'+checked_row);
		total_qty=total_qty1.value;

		var rate1=parent.frames[2].document.getElementById('rate'+checked_row);
		rate=rate1.value;

		var practioner_type1=parent.frames[2].document.getElementById('practioner_type'+checked_row);
		practioner_type=practioner_type1.value;
		
		var pract_id1=parent.frames[2].document.getElementById('pract_id'+checked_row);
		pract_id=pract_id1.value;
				
		var practioner1=parent.frames[2].document.getElementById('practioner'+checked_row);
		practioner=practioner1.value;	

		var pract_staff_id1=parent.frames[2].document.getElementById('pract_staff_id'+checked_row);
		pract_staff_id=pract_staff_id1.value;				

		var total_pay1=parent.frames[2].document.getElementById('total_pay'+checked_row);
		total_pay=total_pay1.value;

		var patient_pay1=parent.frames[2].document.getElementById('patient_pay'+checked_row);
		patient_pay=patient_pay1.value;

		var patient_paid1=parent.frames[2].document.getElementById('patient_paid'+checked_row);
		patient_paid=patient_paid1.value;

		
		var cbflag1=parent.frames[2].document.getElementById('preappr_reqd'+checked_row);
		if(cbflag1.checked)
		{
			 cbflag="checked";
		}
		else
		{
			cbflag="";
		}
		var charged_yn1=parent.frames[2].document.getElementById('charged_yn'+checked_row);
		charged_yn=charged_yn1.value;
		
		var override_allowed_yn1=parent.frames[2].document.getElementById('override_allowed_yn'+checked_row);
		override_allowed_yn=override_allowed_yn1.value;

		var serv_amt_changed=parent.frames[2].document.getElementById('serv_amt_changed'+checked_row);
		serv_amt_changed=serv_amt_changed.value;
		
		


		var retVal			= new String();
		//var dialogTop = window.dialogTop;
		var dialogTop = "2vh";
		var dialogHeight = "62vh" ;
		var dialogWidth = "73vw" ;
		var dialogLeft="6";
		var features= "dialogTop:" + dialogTop+ "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";dialogLeft:"+dialogLeft+";status=no" ;

		//var features			= "dialogTop:"+eval(window.dialogTop+100)+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		
		var title=getLabel("eBL.EDIT_ENTER_CHARGE_DETAILS.label","BL");
		title=encodeURIComponent(title);			
	var arguments			= "" ;
	var column_sizes = escape("");               
	var column_descriptions ="";	




		//var getString=document.forms[0].queryString.value;
		
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"&action=modify&service="+encodeURIComponent(service)+"&blng_serv_code="+blng_serv_code+"&incl_excl="+encodeURIComponent(incl_excl)+"&incl_excl_action="+encodeURIComponent(incl_excl_action)+"&reason="+encodeURIComponent(reason)+"&action_reason_code="+action_reason_code+"&charge="+charge+"&original_qty="+original_qty+"&uom="+encodeURIComponent(uom)+"&uom_code="+uom_code+"&revise_qty="+revise_qty+"&total_qty="+total_qty+"&rate="+rate+"&practioner_type="+practioner_type+"&practioner="+encodeURIComponent(practioner)+"&pract_id="+pract_id+"&pract_staff_id="+pract_staff_id+"&total_pay="+total_pay+"&patient_pay="+patient_pay+"&patient_paid="+patient_paid+"&cbflag="+cbflag+"&episode_type="+episode_type+"&patient_id="+patient_id+"&episode_id="+episode_id+"&visit_id="+visit_id+"&service_date="+service_date+"&modify_qty_yn="+modify_qty_yn+"&module_id="+module_id+"&include_label="+encodeURIComponent(include_label)+"&exclude_label="+encodeURIComponent(exclude_label)+"&encounter_id="+str_encounter_id+"&acc_seq_no="+str_acc_seq_no+"&ratecharge_desc="+ratecharge_desc+"&p_order_id="+p_order_id+"&p_order_line_no="+p_order_line_no+"&charged_yn="+charged_yn+"&service_panel_ind="+service_panel_ind+"&override_allowed_yn="+override_allowed_yn+"&str_epi_type_clinic_code="+str_epi_type_clinic_code+"&panel_qty="+panel_qty+"&serv_amt_changed="+serv_amt_changed+"&calledfrmencYN="+calledfrmencYN+"&bean_id_bl="+bean_id_bl+"&dirIndirChrgsFlag="+dirIndirChrgsFlag;
		//alert("param:"+param);
		
	retVal= await window.showModalDialog("../../eBL/jsp/BLEnterEditChargeDetailsValidationFrame.jsp?"+param,arguments,features);
		var formObj = parent.query2.document.edit_enter_main;
		total_records=formObj.total_records.value;
		for(var j=0;j<total_records;j++)
		{
			var temp=eval("formObj.selected_row"+j);
			temp.checked=false;
		}

//		formObj.selected_row.checked=false;
		if(retVal!=null)
		{
		var arr=new Array();
		if(retVal == null) retVal='';

		if (retVal != null || retVal!="")
		{
			var retVal=unescape(retVal);					  
			if(retVal != null && retVal.length>0)
			{
				formObj =  parent.query2.document.edit_enter_main;
				arr=retVal.split("::");	

				var service1=eval("parent.frames[2].document.forms[0].service"+checked_row);
				service1.value=decodeURIComponent(arr[0]);

				var blng_serv_code1=eval("parent.frames[2].document.forms[0].blng_serv_code"+checked_row);
				blng_serv_code1.value=arr[1];

				var incl_excl1=eval("parent.frames[2].document.forms[0].incl_excl"+checked_row);
				incl_excl1.value=arr[2];
				var incl_excl_action1=eval("parent.frames[2].document.forms[0].incl_excl_action"+checked_row);
				incl_excl_action1.value=arr[3];
				var reason2=eval("parent.frames[2].document.forms[0].reason"+checked_row);
				reason2.value=decodeURIComponent(arr[4]);
				var action_reason_code1=eval("parent.frames[2].document.forms[0].action_reason_code"+checked_row);
				action_reason_code1.value=arr[5];

				var ratecharge_desc1=eval("parent.frames[2].document.forms[0].ratecharge_desc"+checked_row);
				ratecharge_desc1.value=arr[22];

				var charge1=eval("parent.frames[2].document.forms[0].charge"+checked_row);
				charge1.value=arr[6];
				var original_qty1=eval("parent.frames[2].document.forms[0].original_qty"+checked_row);
				original_qty1.value=arr[7];	
				
				var modify_qty_yn1=eval("parent.frames[2].document.forms[0].modify_qty_yn"+checked_row);
				modify_qty_yn1.value=arr[8];					
				
				var uom1=eval("parent.frames[2].document.forms[0].uom"+checked_row);
				uom1.value=decodeURIComponent(arr[9]);	
				
				var uom_code1=eval("parent.frames[2].document.forms[0].uom_code"+checked_row);
				uom_code1.value=arr[10];	
				
				var revise_qty1=eval("parent.frames[2].document.forms[0].revise_qty"+checked_row);
				revise_qty1.value=arr[11];
				var total_qty1=eval("parent.frames[2].document.forms[0].total_qty"+checked_row);
				total_qty1.value=arr[12];
				var rate1=eval("parent.frames[2].document.forms[0].rate"+checked_row);
				rate1.value=arr[13];
				var practioner_type1=eval("parent.frames[2].document.forms[0].practioner_type"+checked_row);
				practioner_type1.value=arr[14];

				var pract_id1=eval("parent.frames[2].document.forms[0].pract_id"+checked_row);
				pract_id1.value=arr[15];

				var practioner1=eval("parent.frames[2].document.forms[0].practioner"+checked_row);
				practioner1.value=decodeURIComponent(arr[16]);

				var pract_staff_id1=eval("parent.frames[2].document.forms[0].pract_staff_id"+checked_row);
				pract_staff_id1.value=arr[21];

				var total_pay1=eval("parent.frames[2].document.forms[0].total_pay"+checked_row);
				total_pay1.value=arr[17];
				var patient_pay1=eval("parent.frames[2].document.forms[0].patient_pay"+checked_row);
				patient_pay1.value=arr[18];

				var patient_paid1=eval("parent.frames[2].document.forms[0].patient_paid"+checked_row);
				patient_paid1.value=arr[19];

				var cbflag1=eval("parent.frames[2].document.forms[0].preappr_reqd"+checked_row);
				cbflag1.checked=arr[20];
				var ckcbflag=arr[20];
				//alert("ckcbflag :"+ckcbflag);
				if(ckcbflag=="checked")
				{	
					cbflag1.checked=true;
				}
				else{
					cbflag1.checked=false;
				}
				var charged_yn1=eval("parent.frames[2].document.forms[0].charged_yn"+checked_row);
				charged_yn1.value=arr[23];

				//alert("arr[24] "+arr[24]);

				var override_allowed_yn1=eval("parent.frames[2].document.forms[0].override_allowed_yn"+checked_row);
				override_allowed_yn1.value=arr[24];

				var serv_amt_changed=eval("parent.frames[2].document.forms[0].serv_amt_changed"+checked_row);
				serv_amt_changed.value=arr[25];

				var excl_incl_ind_for_screen=eval("parent.frames[2].document.forms[0].excl_incl_ind_for_screen"+checked_row);
				excl_incl_ind_for_screen.value=arr[26];
				





		}
		}
		totpayable();
		}
		else
		{
//			alert("closed");
		}
	}
	parent.frames[2].document.forms[0].checked_row.value="";
}

function removechargedet()
{
	var checked_row=parent.frames[2].document.forms[0].checked_row.value;
	var queryString=document.forms[0].queryString.value;
	var formObj = parent.parent.query2.document.edit_enter_main;
	var total_records=formObj.total_records.value;
	var confirm_check = false;
	var single_rec_check = "N";
	if(total_records==0)
	{
		alert(getMessage("NO_RECORD_FOUND","common"));
		return false;
	}
	
	if(checked_row=="")
	{
		alert(getMessage("ATLEAST_ONE_SELECTED","common"));
	}
	else
	{
		if(total_records==1)
		{			
			if(!confirm(getMessage("BL6197","BL")))
			{
				for(var j=0;j<total_records;j++)
				{
					var temp=eval("formObj.selected_row"+j);
					temp.checked=false;
				}
				parent.frames[2].document.forms[0].checked_row.value="";
				return false;
			}
			else
			{
				single_rec_check = "Y";
				confirm_check = true;
			}
		}

		if(single_rec_check == "N")
		{
			confirm_check = confirm(getMessage("DELETE_RECORD","common"));
		}
		if(confirm_check) //BL9760
		{
			totalRecords =eval(formObj.total_records.value);
			//Added by karthik on Oct-18-2012 to default select a practitioner
			var practioner=eval("parent.frames[2].document.forms[0].practioner0");	
			var practioner_id=eval("parent.frames[2].document.forms[0].pract_id0");
			var pract_staff_id=eval("parent.frames[2].document.forms[0].pract_staff_id0");
			var URL="../../eBL/jsp/BLEnterEditChargeDetailsBody.jsp?remove_check=remove&"+"&checked_row="+checked_row+"&total_records="+totalRecords+"&"+queryString;
			if(totalRecords==1)
			{
			URL="../../eBL/jsp/BLEnterEditChargeDetailsBody.jsp?remove_check=remove&"+"&checked_row="+checked_row+"&total_records="+totalRecords+"&"+queryString+"&set_session_practitioner="+practioner.value+"&set_session_pract_staff_ind="+practioner_id.value+"&set_session_pract_staff_id="+pract_staff_id.value;
			}
			parent.frames[2].document.forms[0].action=URL;
			parent.frames[2].document.forms[0].submit();
		}
		else
		{
			for(var j=0;j<total_records;j++)
			{
				var temp=eval("formObj.selected_row"+j);
				temp.checked=false;
			}
			return false;			
		}
	}
	for(var j=0;j<total_records;j++)
	{
		var temp=eval("formObj.selected_row"+j);
		temp.checked=false;
	}
	parent.frames[2].document.forms[0].checked_row.value="";
	
}

/*function removechargedet()
{
	var cbglag="";
	var checked_row=parent.frames[2].document.forms[0].checked_row.value;
	var include_label=document.forms[0].include_label.value;
	var exclude_label=document.forms[0].exclude_label.value;
	var p_string=parent.frames[2].document.forms[0].p_string.value;
	var queryString=document.forms[0].queryString.value;
	var str_epi_type_clinic_code=parent.frames[2].document.forms[0].str_epi_type_clinic_code.value;
	str_epi_type_clinic_code=encodeURIComponent(str_epi_type_clinic_code);
	if(checked_row=="")
	{
		alert(getMessage("ATLEAST_ONE_SELECTED","common"));
	}
	else
	{
		var service1=eval("parent.frames[2].document.forms[0].service"+checked_row);
		service=service1.value;
		
		var blng_serv_code1=eval("parent.frames[2].document.forms[0].blng_serv_code"+checked_row);
		blng_serv_code=blng_serv_code1.value;

		var incl_excl1=eval("parent.frames[2].document.forms[0].incl_excl"+checked_row);
		incl_excl=incl_excl1.value;

		var incl_excl_action1=eval("parent.frames[2].document.forms[0].incl_excl_action"+checked_row);
		incl_excl_action=incl_excl_action1.value;

		var reason1=eval("parent.frames[2].document.forms[0].reason"+checked_row);
		reason=reason1.value;

		var action_reason_code1=eval("parent.frames[2].document.forms[0].action_reason_code"+checked_row);
		action_reason_code=action_reason_code1.value;

		var ratecharge_desc1=eval("parent.frames[2].document.forms[0].ratecharge_desc"+checked_row);
		ratecharge_desc=ratecharge_desc1.value;
		

		var charge1=eval("parent.frames[2].document.forms[0].charge"+checked_row);
		charge=charge1.value;

		var original_qty1=eval("parent.frames[2].document.forms[0].original_qty"+checked_row);
		original_qty=original_qty1.value;

		var modify_qty_yn1=eval("parent.frames[2].document.forms[0].modify_qty_yn"+checked_row);
		modify_qty_yn=modify_qty_yn1.value;

		var uom1=eval("parent.frames[2].document.forms[0].uom"+checked_row);
		uom=uom1.value;

		var uom_code1=eval("parent.frames[2].document.forms[0].uom_code"+checked_row);
		uom_code=uom_code1.value;
				
		var revise_qty1=eval("parent.frames[2].document.forms[0].revise_qty"+checked_row);
		revise_qty=revise_qty1.value;

		var total_qty1=eval("parent.frames[2].document.forms[0].total_qty"+checked_row);
		total_qty=total_qty1.value;

		var rate1=eval("parent.frames[2].document.forms[0].rate"+checked_row);
		rate=rate1.value;

		var practioner_type1=eval("parent.frames[2].document.forms[0].practioner_type"+checked_row);
		practioner_type=practioner_type1.value;

		var pract_id1=eval("parent.frames[2].document.forms[0].pract_id"+checked_row);
		pract_id=pract_id1.value;

		var practioner1=eval("parent.frames[2].document.forms[0].practioner"+checked_row);
		practioner=practioner1.value;		

		var pract_staff_id1=eval("parent.frames[2].document.forms[0].pract_staff_id"+checked_row);
		pract_staff_id=pract_staff_id1.value;	

		var total_pay1=eval("parent.frames[2].document.forms[0].total_pay"+checked_row);
		total_pay=total_pay1.value;

		var patient_pay1=eval("parent.frames[2].document.forms[0].patient_pay"+checked_row);
		patient_pay=patient_pay1.value;

		var patient_paid1=eval("parent.frames[2].document.forms[0].patient_paid"+checked_row);
		patient_paid=patient_paid1.value;

		var cbflag1=eval("parent.frames[2].document.forms[0].preappr_reqd"+checked_row);			
				if(cbflag1.checked)
				{	
					cbflag="checked";
				}
				else{
					cbflag="";
				}
		var charged_yn1=eval("parent.frames[2].document.forms[0].charged_yn"+checked_row);
		charged_yn=charged_yn1.value;

		var override_allowed_yn1=eval("parent.frames[2].document.forms[0].override_allowed_yn"+checked_row);
		override_allowed_yn=override_allowed_yn1.value;
		//alert("override_allowed_yn btn:"+override_allowed_yn);

	
		var retVal	= new String();
/*
		var dialogTop = "100";
		var dialogHeight = "20" ;
		var dialogWidth = "40" ;
		var features			= "dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
*/
/*		var dialogTop = window.dialogTop;
		var dialogHeight = "20" ;
		var dialogWidth = "40" ;
		var dialogLeft="360";
		var features= "dialogTop:" + (eval((dialogTop.substr(0,(dialogTop.indexOf('px')))))+115) + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";dialogLeft:"+dialogLeft+";status=no" ;

		var arguments			= "" ;
		var title=getLabel("eBL.EDIT_ENTER_CHARGE_DETAILS.label","BL");
		title=encodeURIComponent(title);			
		//var getString=document.forms[0].queryString.value;
		var param = "title="+title+"&action=remove&service="+encodeURIComponent(service)+"&blng_serv_code="+blng_serv_code+"&incl_excl="+incl_excl+"&incl_excl_action="+incl_excl_action+"&reason="+encodeURIComponent(reason)+"&action_reason_code="+action_reason_code+"&charge="+charge+"&original_qty="+original_qty+"&uom="+encodeURIComponent(uom)+"&uom_code="+uom_code+"&revise_qty="+revise_qty+"&total_qty="+total_qty+"&rate="+rate+"&practioner_type="+practioner_type+"&pract_id="+pract_id+"&practioner="+practioner+"&pract_staff_id="+pract_staff_id+"&total_pay="+total_pay+"&patient_pay="+patient_pay+"&patient_paid="+patient_paid+"&cbflag="+cbflag+"&modify_qty_yn="+modify_qty_yn+"&include_label="+include_label+"&exclude_label="+exclude_label+"&p_string="+p_string+"&ratecharge_desc="+ratecharge_desc+"&charged_yn="+charged_yn+"&override_allowed_yn="+override_allowed_yn+"&str_epi_type_clinic_code="+str_epi_type_clinic_code;
		retVal=window.showModalDialog("../../eBL/jsp/BLEnterEditChargeDetailsValidationFrame.jsp?"+param,arguments,features);
		var formObj = parent.parent.query2.document.edit_enter_main;
		total_records=formObj.total_records.value;
		for(var j=0;j<total_records;j++)
		{
			var temp=eval("formObj.selected_row"+j);
			temp.checked=false;
		}
//		formObj.selected_row.checked=false;
		if(	retVal!=null)
		{
			var ret_val=retVal;
//			alert("retVal from 4" +retVal);
			if(ret_val=="remove")
			{	
					totalRecords =eval(formObj.total_records.value);
					//count =totalRecords - 1; 
					//formObj.total_records.value=count;						//parent.frames[2].location.href="../../eBL/jsp/AddModifyPatFinDetailsInsBody.jsp?remove_check=remove&"+getString+"&checked_row="+checked_row;
					parent.frames[2].document.forms[0].action="../../eBL/jsp/BLEnterEditChargeDetailsBody.jsp?remove_check=remove&"+"&checked_row="+checked_row+"&total_records="+totalRecords+"&"+queryString;
					parent.frames[2].document.forms[0].submit();
			}
		}
		else
		{
//			alert("closed");
		}
	}
	parent.frames[2].document.forms[0].checked_row.value="";
}*/

function add_servicesYN()
{	
//	var add_services_yn=parent.frames[0].document.forms[0].add_services_yn.value;
	var add_services_yn=document.forms[0].add_services_yn.value;
	var service_panel_ind=document.forms[0].service_panel_ind.value;
//	alert("add_services_yn:"+add_services_yn);
if(add_services_yn=="N" || service_panel_ind=="S")
	{	
	document.forms[0].add_serv_button.disabled=true;	
	document.forms[0].remove_button.disabled=true;	
	}
else{		
	if(add_services_yn=="Y" || service_panel_ind=="L")
	{		
	document.forms[0].add_serv_button.disabled=false;	
	document.forms[0].remove_button.disabled=false;
	}
}
}
//add_servicesYN();

function totpayable()
{
	var totalpayable=0.0;
	var patientpayable=0.0;
	var patientpaid=0.00;
	var totpayable="";
	var patpayable="";
	var patpaid="";
	var a1=new Array();var a2=new Array();var a3=new Array();
	var formObj = parent.query2.document.edit_enter_main;
	var	totalRecords =eval(formObj.total_records.value);	
	var decimal=document.forms[0].noofdecimal.value;
	for(var i=0;i<totalRecords;i++)
	{
	  totpayable=eval("parent.frames[2].document.forms[0].total_pay"+i);
	  patpayable=eval("parent.frames[2].document.forms[0].patient_pay"+i);
	  patpaid=eval("parent.frames[2].document.forms[0].patient_paid"+i);
	  a1[i]=totpayable.value;
	  if(a1[i]==""){a1[i]="0.0";}
	  totalpayable=parseFloat(totalpayable) + parseFloat(a1[i]);
	  a2[i]=patpayable.value;	  
	  if(a2[i]==""){a2[i]="0.0";}
	  patientpayable=parseFloat(patientpayable) + parseFloat(a2[i]);

	  a3[i]=patpaid.value;
	  if(a3[i]=="") a3[i]="0.0";
	  patientpaid=parseFloat(patientpaid) + parseFloat(a3[i]);
	}	
	/*totalpayable=totalpayable.valueOf();
	patientpayable=patientpayable.valueOf();
	totalpayable=totalpayable+"";
	patientpayable=patientpayable+"";
	alert("patientpayable :"+patientpayable);
	var l1_length=totalpayable.indexOf('.');
	var l2_length=patientpayable.indexOf('.');
	if(l1_length>=0)
	{
	var t2=(totalpayable.substring(l1_length+1,totalpayable.length)).length;
	if(t2==1)
		totalpayable=totalpayable+"0";
	}
	if(l2_length>=0)
	{
	var t2=(patientpayable.substring(l1_length+1,patientpayable.length)).length;
	if(t2==1)
		patientpayable=patientpayable+"0";
	alert("patientpayable 1:"+patientpayable);
	}*/	
	totalpayable = totalpayable.toFixed(decimal);
	patientpayable = patientpayable.toFixed(decimal);
	patientpaid = patientpaid.toFixed(decimal);

	document.forms[0].total.value=totalpayable;
	var totp=eval("document.forms[0].total")
	putdeci(totp);
	document.forms[0].patient.value=patientpayable;
	var patp=eval("document.forms[0].patient")
	putdeci(patp);

	document.forms[0].patient_paid.value=patientpaid;	
	var patpd=eval("document.forms[0].patient_paid");
	
	putdeci(patpd);
}

function putdeci(object)
{
	var decimal=document.forms[0].noofdecimal.value;
	if(object.value!='')
	{
		putDecimal(object,17,decimal);
	}
	
}


function cancel(obj)
{
	//parent.window.close();
	parent.parent.document.querySelectorAll("#dialog_tag")[parent.parent.document.querySelectorAll("#dialog_tag").length-1].close();
}
</script>
			<title>			
			</title>
<!--
<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'>
-->
	<%	
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js"></script>	
		<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



		</head>
		<body onLoad="totpayable();" onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form>
		<table cellpadding=3 cellspacing=0  width="100%">
			<tr>
			<td width='15%'  class='label'></td>
			<td width='15%'  class='label'></td>
			<td width='15%' class='label'><b><fmt:message key="Common.total.label" bundle="${common_labels}"/></b></td>
			<td width='10%' class="fields"><input type='text' name='total' id='total' size='14' maxlength='30' 
			value='' readonly style='text-align:right' ></td>
			 <td class="fields"><input type='text' name='patient' id='patient' size='14'  maxlength='30' value='' readonly style='text-align:right'></td>
			 <td class="fields"><input type='text' name='patient_paid' id='patient_paid' size='14'  maxlength='30' value='' readonly style='text-align:right'></td>
			 <td width='15%'  class='label'></td>
			<td width='15%' class='label'></td>
			</tr>
	  </table>
			<table cellpadding=3 cellspacing=0  width="100%">

<%	
//		System.out.println("p_service_panel_ind:"+p_service_panel_ind);
//		System.out.println("stradd_services_during_entry_yn:"+stradd_services_during_entry_yn);
		if(p_service_panel_ind.equals("L") && stradd_services_during_entry_yn.equals("Y"))
		{
%>
		 <tr>
		 <td width="25%"  class='labels'>	</td>
		 <td width="25%"  class='labels'>	</td>
		 <td width="25%"  class='labels'>
			<input type='button' class='button' onclick='addchargedet()' name='add_serv_button' id='add_serv_button' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")%>" >
			 <input type='button' class='button' onclick='modifychargedet()' name='modify_serv_button' id='modify_serv_button' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels")%>" >
			 <input type='button' class='button' onclick='removechargedet()' name="remove_button" id="remove_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Remove.label","common_labels")%>" ></td>
		 <td width="25%"  class='labels'>		 
			 <input type='button' class='button' onclick='acceptvalidation()' name="accept_button" id="accept_button"  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Accept.label","common_labels")%>" >
			 <input type='button'  name="cancel_button" id="cancel_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" class='button' onClick='cancel(event)'></td>
		</td>
		</tr>

<%
		}
			else if((p_service_panel_ind.equals("S") || p_service_panel_ind.equals("L"))  && stradd_services_during_entry_yn.equals("N"))
			{
%>
				<td width="25%"  class='label'>	</td>
				<td width="25%"  class="label">	</td>
				<td width="25%"  class="label">	</td>
				<td width="25%"  class="label">
				<input type='button' class='button' onclick='modifychargedet()' name='modify_serv_button' id='modify_serv_button' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels")%>" >
				<input type='button' class='button' onclick='acceptvalidation()' name="accept_button" id="accept_button"  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Accept.label","common_labels")%>" >
				<input type='button'  name="cancel_button" id="cancel_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" class='button' onClick='cancel(event)'></td>
			</td>
<%
			}
%>

		</table>
<input type= hidden name="queryString" id="queryString"  value="<%=queryString%>">
<input type= hidden name="h_episode_type" id="h_episode_type"  value="<%=p_episode_type%>">
<input type= hidden name="h_patient_id" id="h_patient_id"  value="<%=p_patient_id%>">
<input type= hidden name="h_visit_id" id="h_visit_id"  value="<%=p_visit_id%>">
<input type= hidden name="h_episode_id" id="h_episode_id"  value="<%=p_episode_id%>">
<input type= hidden name="service_date" id="service_date"  value="<%=p_service_date%>">
<input type= hidden name="count1" id="count1"  value=''>
<input type= hidden name="h_module_id" id="h_module_id"  value="<%=p_module_id%>">
<input type='hidden' name='orig_qty' id='orig_qty' id='orig_qty' value="<%=orig_qty%>">


<input type= 'hidden' name='cbflag' id='cbflag'  value=''>
<input type= 'hidden' name='p_str' id='p_str'  value=''>
<input type= 'hidden' name='p_str1' id='p_str1'  value=''>
<input type= hidden name="add_services_yn" id="add_services_yn"  value="<%=stradd_services_during_entry_yn%>">	
<input type= 'hidden' name='accept_chk' id='accept_chk'  value='Y'>
<input type='hidden' name='service_panel_ind' id='service_panel_ind' value="<%=p_service_panel_ind%>" >
<input type='hidden' name='encounter_id' id='encounter_id' value="<%=str_encounter_id%>" >
<input type='hidden' name='acc_seq_no' id='acc_seq_no' value="<%=str_acct_seq_no%>" >
<input type='hidden' name='noofdecimal' id='noofdecimal' value="<%=noofdecimal%>" >

<input type='hidden' name='dirIndirChrgsFlag' id='dirIndirChrgsFlag' value="<%=dirIndirChrgsFlag%>" >
<input type='hidden' name='include_label' id='include_label' value="<%=include_label%>" >
<input type='hidden' name='exclude_label' id='exclude_label' value="<%=exclude_label%>" >
<input type='hidden' name='rate_label' id='rate_label' value="<%=rate_label%>" >
<input type='hidden' name='charge_label' id='charge_label' value="<%=charge_label%>" >

<input type='hidden' name='p_order_id' id='p_order_id' value="<%=p_order_id%>" >
<input type='hidden' name='p_order_line_no' id='p_order_line_no' value="<%=p_order_line_no%>" >
<input type='hidden' name='str_or_key_line_no' id='str_or_key_line_no' value="<%=str_or_key_line_no%>" >

<input type='hidden' name='str_or_key' id='str_or_key' value="<%=str_or_key%>" >
<input type='hidden' name='str_or_bean_id' id='str_or_bean_id' value="<%=str_or_bean_id%>" >

<input type='hidden' name='bean_id_bl' id='bean_id_bl' value="<%=bean_id_bl%>" >
<input type='hidden' name='calledfrmencYN' id='calledfrmencYN' value="<%=calledfrmencYN%>" >

<input type='hidden' name='incl_excl_action_code_to_or' id='incl_excl_action_code_to_or' value='' >
<input type='hidden' name='action_reason_code_to_or' id='action_reason_code_to_or' value='' >
<input type='hidden' name='excl_incl_ind_for_screen' id='excl_incl_ind_for_screen' value='' >
<input type='hidden' name='override_yn' id='override_yn' value='' >

<input type='hidden' name='rate_temp' id='rate_temp' value='' >


<input type='hidden' name='mod_pract_ind' id='mod_pract_ind' value='' >
<input type='hidden' name='mod_physician_id' id='mod_physician_id' value='' >

</form>
</body>
</html>

