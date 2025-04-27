<!DOCTYPE html>
<!-- 
Sr No        Version           TFS/Incident        SCF/CRF            		 Developer Name
--------------------------------------------------------------------------------------------------------
1            V210129             13523         	 MOHE-CRF-0060       		  Shikha Seth
--------------------------------------------------------------------------------------------------------
-->

<%@ page   import="java.sql.*,java.util.*, java.text.*, webbeans.eCommon.* , java.io.*,webbeans.op.CurrencyFormat,eOR.*,eOR.Common.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
//	PreparedStatement pstmt = null ;	
	Statement stmt = null; 
	ResultSet rs1=null;	

	//Added by Ashwini on 08-Nov-2023 for ML-MMOH-CRF-1844.5
    boolean isSSOIntegrationAppl = false;
 
	try
	{
		String disable_chk_box = "", str_existing_reason_desc="",str_existing_reason_code="", str_cancel_reason_desc="",str_cancel_reason_code="";
		String str_voidNumber=""; 
		con	=	ConnectionManager.getConnection(request);

		//Added by Ashwini on 08-Nov-2023 for ML-MMOH-CRF-1844.5
		isSSOIntegrationAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "SM", "SSO_INTEGRATION");
		
		String include=request.getParameter("mode");
		if(include==null) include="N";	
		include="N";
		
		String print = request.getParameter("print");	
		if(print == null) print = "";
		String rec_ref_flag = request.getParameter("rec_ref_flag");
		System.out.println("rec_ref_flag= "+rec_ref_flag);
		if(rec_ref_flag == null) rec_ref_flag = "";
		
		String recept_Refund_ind = request.getParameter("recept_Refund_ind");
		System.out.println("recept_Refund_indrecept_Refund_ind= "+recept_Refund_ind);
		if(recept_Refund_ind == null) recept_Refund_ind = "";
		String void_number= request.getParameter("void_number");	
		System.out.println("void_number11111="+void_number);
		if(void_number == null) void_number = "";
		String called_frm = request.getParameter("called_frm");
		if(called_frm == null) called_frm="";
	
		String blng_serv_date = request.getParameter("blng_serv_date");
		if(blng_serv_date == null) blng_serv_date="";
	
		String blng_serv_code = request.getParameter("blng_serv_code");
		if(blng_serv_code == null) blng_serv_code="";
	
		String serv_item_code = request.getParameter("serv_item_code");
		if(serv_item_code == null) serv_item_code="";
		
		String serv_module_id = request.getParameter("serv_module_id");
		if(serv_module_id == null) serv_module_id="";
	
		str_existing_reason_code = request.getParameter("existing_reason_code");	
		if(str_existing_reason_code==null) str_existing_reason_code="";		
	//	System.err.println("str_existing_reason_code:"+str_existing_reason_code);
		String locale	= (String)session.getAttribute("LOCALE");	
		if(locale==null || locale.equals("")) locale="en";
	
		String loggeduser=request.getParameter("loggeduser");
		if(loggeduser==null) loggeduser="";
		
		if(str_existing_reason_code.equals(""))	{
			disable_chk_box="DISABLED";
		}
		if(!str_existing_reason_code.equals("")){
			try	{
	/*			String exist_act_reason_code_qry= "select a.action_reason_desc description from bl_action_reason_lang_vw a where nvl(status,'!') != 'S' and upper(language_id) = upper('"+locale+"') AND exists (select b.action_reason_code from bl_action_reason_by_type b  where A.action_reason_code = '"+str_existing_reason_code+"' and b.action_reason_code = a.action_reason_code and b.active_yn = 'Y' and  ACTION_TYPE='SD')";8*/
	
				String exist_act_reason_code_qry= "select a.action_reason_desc description from bl_action_reason_lang_vw a,bl_action_reason_by_type b where a.action_reason_code  = b.action_reason_code and nvl(a.status,'X') <> 'S' and NVL(b.active_yn, 'N') = 'Y' and upper(language_id) = upper('"+locale+"') AND ACTION_TYPE='OR' and A.action_reason_code = '"+str_existing_reason_code+"'";
	
				stmt = con.createStatement();
				rs1 = stmt.executeQuery(exist_act_reason_code_qry);	
			
				while(rs1.next())
				{
				   str_existing_reason_desc  =  rs1.getString(1);	
				}	
				if(str_existing_reason_desc == null) str_existing_reason_desc="";
				rs1.close();
				stmt.close();	
			}catch(Exception e)	{
				System.err.println("exist_act_reason_code_qry:"+e.toString());
			}
		}
%>
<html lang="en">
<head>
 <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<!--
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>
	-->
		<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>

<!-- 	<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script language='javascript' src='../../eBL/js/AddModifyPatFinDetails.js'></script>
	<script language='javascript'>
			function retModal(obj)
			{				
				var called_frm = document.forms[0].called_frm.value;
				var upd_fin_dtl="";				
				var returnArray = new Array ("N")			
				parent.window.returnValue = returnArray;					
				parent.window.close();
				/*let dialogBody = parent.parent.document.getElementById('dialog-body');
				dialogBody.contentWindow.returnValue = returnArray;
    
			const dialogTag = parent.parent.document.getElementById("dialog_tag");    
			dialogTag.close();*/
			}

			function confirmPasswdchk(obj)
			{
				//alert("confirmPasswdchk inside 126");
				//Added by Ashwini on 08-Nov-2023 for ML-MMOH-CRF-1844.5
				var isSSOIntegrationAppl = document.forms[0].isSSOIntegrationAppl.value;
				var login_user_type = document.forms[0].login_user_type.value;
				var user_ID = document.forms[0].user_id.value;
				var usr_id = user_ID.toUpperCase();

				var active_dir_id	= "";
				var appl_user_id	= "";

				if(isSSOIntegrationAppl == 'true' && login_user_type != 'EM'){
					var xmlDoc = "";
					var xmlHttp = new XMLHttpRequest();
					xmlStr = "<root><SEARCH  action='getLinkedADUserDetails' loginID=\""+encodeURIComponent(usr_id)+"\" /></root>"
					xmlDoc.loadXML(xmlStr)
					xmlHttp.open("POST","../../eSM/jsp/SMIntermediate.jsp",false)
					xmlHttp.send(xmlDoc)
					responseText = xmlHttp.responseText
					responseText = trimString(responseText)

					var retVal_arr = responseText.split("~");

					active_dir_id = retVal_arr[0];
					appl_user_id = retVal_arr[1];

					if(active_dir_id != ""){

						usr_id = appl_user_id;
						login_user_type = "AD";
					}else{
						var xmlDoc = "";
						var xmlHttp = new XMLHttpRequest();
						xmlStr = "<root><SEARCH  action='getEMUserLinkedToADUserDetails' loginID=\""+encodeURIComponent(usr_id)+"\" /></root>"
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","../../eSM/jsp/SMIntermediate.jsp",false)
						xmlHttp.send(xmlDoc)
						responseText = xmlHttp.responseText
						responseText = trimString(responseText)

						lnkd_actv_dir_id = responseText;

						if(lnkd_actv_dir_id != "")
						{
							var errors = getMessage('EM_USER_LINKED_TO_AD_USER','SM');
							errors = errors.replace("#",usr_id);
							alert(errors);
							document.forms[0].user_id.focus();
							return false;
						}else{
							login_user_type = "EM";
						}
					}
				}
		//alert("confirmPasswdchk outside 178");
					var called_frm = document.forms[0].called_frm.value;
					var blng_serv_date = document.forms[0].blng_serv_date.value;
					var blng_serv_code = document.forms[0].blng_serv_code.value;
					var serv_item_code = document.forms[0].serv_item_code.value;
					var serv_module_id = document.forms[0].serv_module_id.value;
					var loggeduser=document.forms[0].loggeduser;
					
					
					var cancel_reason_code = document.forms[0].cancel_reason_code.value;
					var cancel_reason_desc = document.forms[0].cancel_reason_desc.value;
					
					var void_Number=document.forms[0].voidNumber.value;
					var pass_wd=document.forms[0].passwd;
					var rmks=document.forms[0].remarks;
					var reimb_reason_code = '';
					//alert("confirmPasswdchk 194");
					if (document.forms[0].reimb_reason_code != null && document.forms[0].reimb_reason_code != 'undefined' && document.forms[0].reimb_reason_code != undefined)
						//alert("196");
					 reimb_reason_code = document.forms[0].reimb_reason_code.value;	
					var upd_fin_dtl=document.forms[0].upd_fin_dtl;								
					var print  = 'N';
					//alert("200");
					if (document.forms[0].print != null && document.forms[0].print != 'undefined' && document.forms[0].print != undefined)
					 print = document.forms[0].print.value;		
//alert("203");				 
					var recept_Refund_ind =document.forms[0].recept_Refund_ind.value;	
					var rec_ref_flag=document.forms[0].rec_ref_flag.value;
					//alert("206");
					if(upd_fin_dtl.checked==true){
						//alert("208");
						upd_fin_dtl.value='Y';
					}
					else{
						//alert("212");
						upd_fin_dtl.value='N';
					}				
					//alert("outside the else");
						if(usr_id=="")
						{
						//	alert("217");
//							alert(getMessage("BL9112"));
							alert(getMessage("BL9112","BL"));
							document.forms[0].user_id.focus();
							return false;
						}
						if(pass_wd.value=="")
						{
							//alert("225");
//							alert(getMessage("BL9113"));
							alert(getMessage("BL9113","BL"));
							pass_wd.focus();
							return false;
						}
						
						if(called_frm == ""  || called_frm == "PKG_BULK_UPD_ACCESS" || (called_frm == "EBL_TRANS_SETL_RECEIPT" && print=="Y") )
						{
							//alert("234");
							if(rmks.value=="")
							{ 
						//alert("237");
	//							alert(getMessage("BL9306"));
								alert(getMessage("BL9306","BL"));
								rmks.focus();
								return false;
							}	
						}
					else if(called_frm == "BILL_REIMB_AMT")
						{
							//alert("247");
							if(reimb_reason_code == "")
							{
							//	alert("250");
								alert(getMessage("BL1356","BL"));
								return false;
							}
						}						
						if( (called_frm == "EBL_TRANS_SETL_REPRNT"  && print != "Y")|| (called_frm == "EBL_TRANS_SETL_RECEIPT"  && print != "Y"))
						{
							//alert("257");
							if(cancel_reason_code == "" || cancel_reason_desc == "")
							{
							//	alert("260");
								alert(getMessage("BL1356","BL"));
								//cancel_reason_desc.focus();
								return false;
							}
						}
						//alert("266");
						var HTMLVal="<html><body><form name='BLConfirmPassWdForm' id='BLConfirmPassWdForm' method='post' action='../../eBL/jsp/BLConfirmPassWd.jsp'>"+
						"<input type='hidden' name='usr_id' id='usr_id' value='"+usr_id+"'>"+
						"<input type='hidden' name='pass_wd' id='pass_wd' value='"+pass_wd.value+"'>"+
						"<input type='hidden' name='upd_fin_dtl' id='upd_fin_dtl' value='"+upd_fin_dtl.value+"'>"+
						"<input type='hidden' name='remarks' id='remarks' value='"+rmks.value+"'>"+
                        "<input type='hidden' name='mod_fin_chk' id='mod_fin_chk' value='Y'>"+
                        "<input type='hidden' name='called_frm' id='called_frm' value='"+called_frm+"'>"+
                        "<input type='hidden' name='blng_serv_date' id='blng_serv_date' value='"+blng_serv_date+"'>"+
                        "<input type='hidden' name='blng_serv_code' id='blng_serv_code' value='"+blng_serv_code+"'>"+
                        "<input type='hidden' name='serv_item_code' id='serv_item_code' value='"+serv_item_code+"'>"+
                        "<input type='hidden' name='serv_module_id' id='serv_module_id' value='"+serv_module_id+"'>"+
                        "<input type='hidden' name='reimb_reason_code' id='reimb_reason_code' value='"+reimb_reason_code+"'>"+
                        "<input type='hidden' name='cancel_reason_code' id='cancel_reason_code' value='"+cancel_reason_code+"'>"+
                        "<input type='hidden' name='cancel_reason_desc' id='cancel_reason_desc' value='"+cancel_reason_desc+"'>"+
                        "<input type='hidden' name='void_Number' id='void_Number' value='"+void_Number+"'>"+
                        "<input type='hidden' name='print' id='print' value='"+print+"'>"+
                        "<input type='hidden' name='loggeduser' id='loggeduser' value='"+loggeduser.value+"'>"+
                        "<input type='hidden' name='recept_Refund_ind' id='recept_Refund_ind' value='"+recept_Refund_ind+"'>"+ //V210129 
                        
						"</form></body></html>";
					//alert("287");
						parent.frames[1].document.body.insertAdjacentHTML('afterbegin', HTMLVal);
						//alert("289");
						/* parent.frames[1].document.BLConfirmPassWdForm.action="../../eCommon/jsp/report_options.jsp";
 
						parent.frames[1].document.BLConfirmPassWdForm.target="messageFrame"; */
						parent.frames[1].document.BLConfirmPassWdForm.submit();	
//alert("291");						
						return true;
			}
//alert("294");
			async function searchReason(clng_evnt)
			{
			//	alert("297");
				if(clng_evnt == 'B')
				{
					if(document.forms[0].reimb_reason_desc.value == "")
					{
						document.forms[0].reimb_reason_desc.value="";
						document.forms[0].reimb_reason_code.value="";	
						return;
					}
				}
				var target			= document.forms[0].reimb_reason_desc;
				var retVal			=  new String();
				var dialogTop	 = "10";
				var dialogHeight = "90vh" ;
				var dialogWidth	 = "80vw" ;
				var features			= "dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
				var arguments			= "" ;
				var search_desc			= "";
				var title =getLabel("eBL.ADHOC_DISC_REASON.label","BL");		
		//		var title = encodeURIComponent(title);		
				var locale  = document.forms[0].locale.value;		
				
				var sql2="select  a.action_reason_code code,a.action_reason_desc description from bl_action_reason_lang_vw a,bl_action_reason_by_type b where a.action_reason_code  = b.action_reason_code and nvl(a.status,'X') <> 'S' and NVL(b.active_yn, 'N') = 'Y' and upper(language_id) = upper('"+locale+"') AND ACTION_TYPE='OR' and upper(a.action_reason_code) like upper(?) and upper(a.action_reason_desc) like upper(?) order by 1";

				var argArray = new Array();
				var namesArray = new Array();
				var valuesArray = new Array();
				var datatypesArray = new Array();

				argArray[0] = sql2;
				argArray[1] = namesArray;
				argArray[2] = valuesArray;
				argArray[3] = datatypesArray;
				argArray[4] = "1,2";
				argArray[5] = target.value;
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
					document.forms[0].reimb_reason_code.value=arr[0];
					document.forms[0].reimb_reason_desc.value=arr[1];			
				}
				else
				{			
					document.forms[0].reimb_reason_desc.value="";
					document.forms[0].reimb_reason_code.value="";		
				}
			}
			
			async function searchCancelReason()
			{				
					/*if(document.forms[0].cancel_reason_desc.value == "")
					{
						document.forms[0].cancel_reason_desc.value="";
						document.forms[0].cancel_reason_code.value="";	
						return;
					}*/
				var target			= document.forms[0].cancel_reason_desc;
				var retVal			=  new String();
				var dialogTop	 = "";
				var dialogHeight = "90vh" ;
				var dialogWidth	 = "80vw" ;
				var features			= "dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
				var arguments			= "" ;
				var search_desc			= "";
				var title ="Cancel Reason"//getLabel("eBL.ADHOC_DISC_REASON.label","BL");		
		//		var title = encodeURIComponent(title);		
				var called_frm = document.forms[0].called_frm.value;
				var locale  = document.forms[0].locale.value;	
			
				 if(called_frm == "EBL_TRANS_SETL_RECEIPT"){							
				     var sql2="select a.ACTION_REASON_CODE code,a.ACTION_REASON_DESC description  from BL_ACTION_REASON_LANG_VW a, BL_ACTION_REASON_BY_TYPE b where a.ACTION_REASON_CODE=b.ACTION_REASON_CODE and ACTION_TYPE = 'CR' and active_yn ='Y' AND  upper(a.language_id) = upper('"+locale+"')and upper(a.action_reason_code) like upper(?) and upper(a.action_reason_desc) like upper(?) ORDER BY 1 ";			
				 }	else{	
          	 			var sql2="select a.ACTION_REASON_CODE code,a.ACTION_REASON_DESC description from BL_ACTION_REASON_lang_vw a, BL_ACTION_REASON_BY_TYPE b where a.ACTION_REASON_CODE=b.ACTION_REASON_CODE and ACTION_TYPE = 'CB' and active_yn ='Y' and  upper(a.language_id) = upper('"+locale+"') and upper(a.action_reason_code) like upper(?) and upper(a.action_reason_desc) like upper(?) ORDER BY 1 ";
				 }
				 //  var sql2="select  a.action_reason_code code,a.action_reason_desc description from bl_action_reason_lang_vw a,bl_action_reason_by_type b where a.action_reason_code  = b.action_reason_code and nvl(a.status,'X') <> 'S' and NVL(b.active_yn, 'N') = 'Y' and upper(language_id) = upper('"+locale+"') AND ACTION_TYPE='OR' and upper(a.action_reason_code) like upper(?) and upper(a.action_reason_desc) like upper(?) order by 1";

				var argArray = new Array();
				var namesArray = new Array();
				var valuesArray = new Array();
				var datatypesArray = new Array();

				argArray[0] = sql2;
				argArray[1] = namesArray;
				argArray[2] = valuesArray;
				argArray[3] = datatypesArray;
				argArray[4] = "1,2";
				argArray[5] = target.value;
				argArray[6] = DESC_LINK;
				argArray[7] = DESC_CODE;		
				retVal = await searchCancelReasonLookup( title, argArray );	
				/* var ret1=unescape(retVal);
				 var arr=ret1.split(",");

					if(arr[1]==undefined) 
					{
						arr[0]="";	
						arr[1]="";	
						
					} */
				if(retVal != null && retVal !="")
				{	
					var ret1=unescape(retVal);
					 var arr=ret1.split(",");

						if(arr[1]==undefined) 
						{
							arr[0]="";	
							arr[1]="";	
							
						} 
					document.getElementById("cancel_reason_code").setAttribute("value",arr[0]);		
					

					document.getElementById("cancel_reason_desc").value=arr[1];
					document.getElementById("cancel_reason_desc").setAttribute("value",arr[1]);
				}
				else
				{			
					document.forms[0].cancel_reason_code.value="";
					document.forms[0].cancel_reason_desc.value="";		
				}
			}
			
			async function searchCancelReasonLookup(title, pArgumentArray) {

			    var retVal = new String();
			    /*
			    var dialogHeight= "30" ;
			    var dialogWidth = "50" ;
			    */
			    
			    var dialogTop   = "10px";
			    var dialogHeight= "450px" ;
			    var dialogWidth = "700px" ;
			    
			    var status = "no";
				//var fin_Val=pArgumentArray.split(",");
			    var xmlDoc = "" ;
			    var xmlHttp = new XMLHttpRequest() ;

				firstCodeVal = "" ;
				firstDescVal = "" ;

			    xmlStr ="<root><SEARCH " ;
			    xmlStr +=" /></root>" ;
			    
			    // added for PE on 26th April 2010
			    
			    if (pArgumentArray[5] != "")
			    {
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open( "GET", "../../eCommon/jsp/CommonLookupResult.jsp?callFrom=0&" + formQueryString(pArgumentArray,0) , false ) ;
					xmlHttp.send( xmlDoc ) ;
					responseText=xmlHttp.responseText ;
					responseText = trimString(responseText);
					eval(responseText) ;
				}
			    if(firstCodeVal == "")
			    {

					var dialogUrl       = "../../eCommon/jsp/CommonLookup.jsp?title="+title;
					
					pArgumentArray[9] = title;

					var dialogArguments = pArgumentArray ;
			        var dialogFeatures  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			        
			        var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
			        
					//var returnVal = window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);	
			        
			        var returnVal = "";  
			        
			        returnVal =   await top.window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);	
			        
			        if( returnVal == null || returnVal == "" )
			            return "";
			        else
			            return returnVal.split("\"") ;
					
			     }
				 
			     else
			     {
			         if(pArgumentArray[7] == CODE_DESC )
			         {
			            var temp = firstCodeVal
			            firstCodeVal = firstDescVal
			            firstDescVal = temp
			         }
					 
			          returnVal = firstCodeVal + "\"" + firstDescVal

			         return returnVal.split("\"") ;
			     }
			}


			function dflt_prev_reason()
			{
				if(document.forms[0].sel_frm_prev_reason.checked)
				{
					document.forms[0].reimb_reason_desc.value = document.forms[0].existing_reason_desc.value;
					document.forms[0].reimb_reason_code.value = document.forms[0].existing_reason_code.value;
				}
				else
				{
					document.forms[0].reimb_reason_desc.value = "";
					document.forms[0].reimb_reason_code.value = "";
				}
			}

function fnClearCode(obj){
	obj.value = '';
}

	//Added by Ashwini on 08-Nov-2023 for ML-MMOH-CRF-1844.5
	function checkADAndEMUserYN(obj){
		var loginID = trimString(obj.value);

		var xmlDoc=""
		var xmlHttp = new XMLHttpRequest()
		xmlStr = "<root><SEARCH  action='getADAndEMUserYN' loginID=\""+encodeURIComponent(loginID)+"\" /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","../../eSM/jsp/SMIntermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText = xmlHttp.responseText
		responseText = trimString(responseText)

		if(responseText == 'Y'){
			if(confirm(getMessage("LOGIN_AS_AD_OR_EM_USER","SM"))){
				document.forms[0].login_user_type.value = 'AD';
			}else{
				document.forms[0].login_user_type.value = 'EM';
			}
		}else{
			document.forms[0].login_user_type.value = '';
		}
	}

	</script>
<title><fmt:message key="eBL.AUTH_SCREEN.label" bundle="${bl_labels}"/></title> 
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<center>
<form name='AuthForm' id='AuthForm'>
<table border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>

<tr>
	<td colspan=15>&nbsp;</td>
</tr>

<tr>
<!--	<td width="35%" align="right" class="label">User ID</td> -->
	<td width="50%" class="label"><fmt:message key="Common.userid.label" bundle="${common_labels}"/></td>
	<td width="50%" class="fields"><input type='text' name='user_id' id='user_id' size='20' maxlength='20' onKeyPress='return makeUpperCase()' <%if(isSSOIntegrationAppl){%>onBlur="checkADAndEMUserYN(this);"<%}%>><img src='../../eCommon/images/mandatory.gif'></td>
 </tr>
 <tr>
<!--	<td width="35%" align="right" class="label">Pin No</td> -->
	<td width="50%" class="label" ><fmt:message key="Common.PIN.label" bundle="${common_labels}"/></td>
	<td width="50%" class="fields"><input type='password' name='passwd' id='passwd' size='20' maxlength='64' autocomplete="off"><!--V230508-41626 --><img src='../../eCommon/images/mandatory.gif'></td>
 </tr>
<%
System.out.println("called_frm="+called_frm+"--print="+print+"qwwer="+(called_frm.equals("EBL_TRANS_SETL_RECEIPT")&&print.equals("Y")));
	if(!called_frm.equals("BILL_REIMB_AMT") && !called_frm.equals("EBL_TRANS_SETL_REPRNT") && !called_frm.equals("EBL_TRANS_SETL_RECEIPT") || (called_frm.equals("EBL_TRANS_SETL_RECEIPT")&&print.equals("Y")))
	{ System.out.println("called_frm=="+called_frm);
%>
 <tr>
<!--	<td width="35%" align="right" class="label">Remarks</td> -->
	<td width="50%"class="label" ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
	<td width="50%" class="fields" nowrap><textarea name='remarks'  id='remarks' rows="2" cols="25" style="resize:none" onKeyPress='checkMaxLimit(this,50)'></textarea><img src='../../eCommon/images/mandatory.gif'></td>
 </tr>
<%
	}
	else
	{
%>
	<input type= 'hidden' name="remarks" id="remarks"  value=''>
<%
	}
	if(include.equals("Y"))
	{
%>
	<tr>
<!--	<td width="35%" align="right" class="label" nowrap>Update Patient<br>Financial Details</td> -->
		<td width="50%" class="label" ><fmt:message key="eBL.UPDATE_PATIENT_FIN_DTL.label" bundle="${bl_labels}"/></td>
		<td width="50%" class="fields" ><input type='checkbox' name='upd_fin_dtl' id='upd_fin_dtl' value='' ></td>
	</tr>
<%
	}
	else
	{
%>
	<input type='hidden' name='upd_fin_dtl' id='upd_fin_dtl' value=''>
<%
	}
	if(called_frm.equals("BILL_REIMB_AMT"))
	{
%>
	<tr>
		<td width="25%"  class="label"><fmt:message key="eBL.USE_PREV_REASON.label" bundle="${bl_labels}"/></td>
		<td width="75%" class="fields"><INPUT TYPE="checkbox" name="sel_frm_prev_reason" id="sel_frm_prev_reason" onClick="dflt_prev_reason();" <%=disable_chk_box%>></td>
	</tr>
	<tr>
		<td width='25%' class='label'><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
		<td width='75%' class="fields" colspan='3'><textarea id="reimb_reason_desc" name="reimb_reason_desc" style="resize:none" rows="5" cols="20" value="" onBlur="searchReason('B')"></textarea><input type="button" class="Button" name="lookup" id="lookup" value="?" onClick="searchReason('C')" ><input type="hidden" name="reimb_reason_code" id="reimb_reason_code" value="" ><img src='../../eCommon/images/mandatory.gif'></td>			
	</tr>
<%
	}
	if(called_frm.equals("EBL_TRANS_SETL_REPRNT") && !print.equals("Y"))
	{
%>
	<tr>
		<td width='25%' class='label'><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
		<td width='75%' class="fields" colspan='3'><textarea name="cancel_reason_desc" id="cancel_reason_desc" style="resize:none" rows="5" cols="20" value="" ></textarea><input type="button" class="Button" name="lookup" id="lookup" value="?" onClick="searchCancelReason()"><img src='../../eCommon/images/mandatory.gif'></td>					
	</tr>
	<!-- <input type="hidden" name="cancel_reason_code" id="cancel_reason_code" value="" > -->
	<input type="hidden" name="reimb_reason_code" id="reimb_reason_code" value="" >
<%
	}
	if(called_frm.equals("EBL_TRANS_SETL_RECEIPT") && !print.equals("Y"))
	{
%>
	<tr>
		<td width='25%' class='label'><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
		<td width='75%' class="fields" colspan='2'><textarea name="cancel_reason_desc" id="cancel_reason_desc" style="resize:none" rows="5" cols="20" value="" ></textarea><input type="button" class="Button" name="lookup" id="lookup" value="?" onClick="searchCancelReason()"><input type="hidden" name="cancel_reason_code" id="cancel_reason_code" value="" ><img src='../../eCommon/images/mandatory.gif'></td>			
	</tr>
	<%if(called_frm.equals("EBL_TRANS_SETL_RECEIPT") && void_number.equals("A") && recept_Refund_ind.equals("R") )
	{ System.out.println("void_number in if"+void_number);
		%>
	<tr>
		<td width='50%' class='label'><fmt:message key="eBL.VOIDNUMBER.label" bundle="${bl_labels}"/></td>					   
		<td width="50%" class="fields"><input type='text' name='voidNumber' id='voidNumber' size='20' maxlength='30' onKeyPress='return makeUpperCase()'></td>
	 </tr>
	 <%}else{
		 System.out.println("void_number in else"+void_number);
	 %>
	 <tr>
						   
		<td width="50%" class="fields"><input type='hidden' name='voidNumber' id='voidNumber' size='20' maxlength='30' onKeyPress='return makeUpperCase()'></td>
	 </tr>
	 <%} %>
	<%--  <input type= 'hidden' name="cancel_reason_code" id="cancel_reason_code"  value='<%=str_cancel_reason_code%>'> --%>
	 <input type="hidden" name="reimb_reason_code" id="reimb_reason_code" value="" >
<%
	}
	if(called_frm.equals("EBL_TRANS_SETL_RECEIPT") && print.equals("Y")){
%>
	<input type= 'hidden' name="cancel_reason_code" id="cancel_reason_code"  value=''>
	<input type= 'hidden' name="voidNumber" id="voidNumber"  value=''>
	<input type= 'hidden' name="cancel_reason_desc" id="cancel_reason_desc"  value=''>
		<input type="hidden" name="reimb_reason_code" id="reimb_reason_code" value="" >
<%}
	if(called_frm.equals("EBL_TRANS_SETL_REPRNT") && print.equals("Y")){
		%>
				<input type="hidden" name="reimb_reason_code" id="reimb_reason_code" value="" >
		<%}
%>
<!--
 <tr>
	<td width="35%" ></td>
	<td width="50%"  colspan="2"></td>
 </tr>
 -->

<tr>
	<td width="50%"></td>
	<td width="50%">
	<input type='button' class='button' name='auth_ok' id='auth_ok' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>" onClick ='return confirmPasswdchk(this);'>
	<input type='button' class='button' name='auth_cancel' id='auth_cancel'  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" onClick='return retModal(this);'>
	</td>
</tr>

<tr>
	<td colspan=15>&nbsp;</td>
</tr>
<tr>
	<td colspan=15>&nbsp;</td>
</tr>

	<script>
		document.forms[0].user_id.focus();
	</script>
</table>
<input type= 'hidden' name="locale" id="locale"  value='<%=locale%>'>
<input type= 'hidden' name="called_frm" id="called_frm"  value='<%=called_frm%>'>
<input type= 'hidden' name="print" id="print"  value='<%=print%>'>
<input type= 'hidden' name="recept_Refund_ind" id="recept_Refund_ind"  value='<%=recept_Refund_ind%>'>
<input type= 'hidden' name="rec_ref_flag" id="rec_ref_flag"  value='<%=rec_ref_flag%>'>
<input type= 'hidden' name="blng_serv_date" id="blng_serv_date"  value='<%=blng_serv_date%>'>
<input type= 'hidden' name="blng_serv_code" id="blng_serv_code"  value='<%=blng_serv_code%>'>
<input type= 'hidden' name="serv_item_code" id="serv_item_code"  value='<%=serv_item_code%>'>
<input type= 'hidden' name="serv_module_id" id="serv_module_id"  value='<%=serv_module_id%>'>
<input type= 'hidden' name="existing_reason_code" id="existing_reason_code"  value='<%=str_existing_reason_code%>'>
<input type= 'hidden' name="existing_reason_desc" id="existing_reason_desc"  value='<%=str_existing_reason_desc%>'>
<input type= 'hidden' name="loggeduser" id="loggeduser"  value='<%=loggeduser%>'>

<!--Added by Ashwini on 08-Nov-2023 for ML-MMOH-CRF-1844.5-->
<input type='hidden' name='isSSOIntegrationAppl' id='isSSOIntegrationAppl' value=<%=isSSOIntegrationAppl%>>
<input type='hidden' name='login_user_type' id='login_user_type' value="">

<% if(!called_frm.equals("EBL_TRANS_SETL_RECEIPT") && !print.equals("Y") ){ %>
<% if(!called_frm.equals("EBL_TRANS_SETL_REPRNT")){ %>
<input type= 'hidden' name="cancel_reason_desc" id="cancel_reason_desc"  value='<%=str_cancel_reason_desc%>'>
<%} %>
<input type= 'hidden' name="voidNumber" id="voidNumber"  value='<%=str_voidNumber%>'>
<input type= 'hidden' name="cancel_reason_code" id="cancel_reason_code"  value='<%=str_cancel_reason_code%>'>
 <%} else if(!called_frm.equals("EBL_TRANS_SETL_RECEIPT") && print.equals("Y")){%>
 <input type= 'hidden' name="cancel_reason_desc" id="cancel_reason_desc"  value='<%=str_cancel_reason_desc%>'>
 <input type= 'hidden' name="voidNumber" id="voidNumber"  value='<%=str_voidNumber%>'>
<input type= 'hidden' name="cancel_reason_code" id="cancel_reason_code"  value='<%=str_cancel_reason_code%>'>

 <%} %> 
</form>
</center>

</body>
</html>

<%
	}
	catch(Exception ee)
	{
	  System.err.println("Error in BLFinDetailsAuthorise.jsp: " +ee);
	}
	finally 
	{
		if(con!=null)
		{
			ConnectionManager.returnConnection(con, request);
		}
	}
%>

