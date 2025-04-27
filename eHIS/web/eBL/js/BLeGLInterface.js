
function eGLInterface()
{
	//alert('eGLInterface');
	
	var formName = document.forms[0];
	
	var  id_type =  formName.identify_type.value;
	var  nid = formName.nid.value;
	
	//alert('id '+id_type+'  nid '+nid);
	if(id_type !='' && nid.length>4)		validateeGL();
	else	alert("Please enter  Identifier type & NID., before proceeding");   

}


async function validateeGL()
{
  // alert ("enter in to validateeGL");
	
	//<FACILITY_ID>RP$!^<PATIENT_ID>BN00004234$!^<ENCOUNTER_ID>200036650001$!^<USER>anilp$!^<WSNO>DFLT_WSNO$!^<NRICTYPE>02$!^<NRICVALUE>780101087716	
	
	var formName= document.forms[0];
	
	var dataElements="";
	dataElements+="<FACILITY_ID>"+formName.facility_id.value+"$!^";
	dataElements+="<PATIENT_ID>"+formName.patient_id.value+"$!^";
	dataElements+="<ENCOUNTER_ID>$!^";
	
	dataElements+="<USER>"+formName.logged_user_id.value+"$!^";
	dataElements+="<WSNO>"+formName.strclientip.value+"$!^";
	
	dataElements+="<NRICTYPE>"+formName.identify_type.value+"$!^";
	dataElements+="<NRICVALUE>"+formName.nid.value;
	
	
	//alert ('dataElements '+dataElements);
	
	var messageVal=invokeEGLapplication(dataElements);
	
	//var messageVal="SUCCESS$|#ADIBAH BINTI HASHIM$|#780504086208$|#PENTADBIR/KLINIKAL, PEGAWAI PERUBATAN, GRED UD43/UD44/UD47/UD48/UD51/UD52/UD53/UD54$|#$|#Kelas 1 Bilik Seorang$|#UNIT KAWALAN AMALAN PERUBATAN SWASTA (UKAPS)$|#HASHIM B. MOHAMAD SAID$|#411103085083$|#04^Father$|#QB^JKN$!#QB000001^JABATAN KESIHATAN NEGERI SELANGOR$|#UD52$|#HSEL/eGL/100001!S!";
	
	//alert("Return eGL Value #"+messageVal);
	if(messageVal!='' && messageVal!=null)
	{
		
		if (messageVal.charAt(0)=='S' ) 
		{				
			var retVal=new Array();
			var dialogHeight= "15" ;
			var dialogWidth	= "40" ;
			var dialogTop = "225" ;
			var center = "1" ;														   
			var status="no";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "" ;	
			retVal =await window.showModalDialog("../../eBL/jsp/BLeGLConfirmWindow.jsp?mesg="+encodeURIComponent(messageVal),arguments,features);
			
			
			if(retVal != 'N')
			{			
			    var formObj = parent.parent.frames[1].frames[0].document.forms[0];
			    var formReln = parent.parent.frames[0].document.forms[0];			     
			    
			    arr = retVal.split('^');
			    
			    var episode_type=formName.episode_type.value;
				var retValmsg = formeGLcustomerValidation(arr[1],arr[0],arr[2],episode_type);
				//alert('retValmsg '+retValmsg);
				arrval = retValmsg.split('^')
				
				if(arrval[2]==''||arrval[3]==''||arrval[2]=='Err'||arrval[3]=='Err')
				{
					alert(""+arr[1]+"  Customer Name is not available. Please contact System Administrator to create the Customer before proceeding.");
					//return;  // Karthik Commented as Customer asked all fields returning from eGL needs to  be filled except customer and Customer Group 
				}
				formObj.cust_group_code_2.value	=arr[0];
			    formObj.cust_2.value			=arr[1];
				formObj.cust_curr_code.value   = arr[1];	

				// Code Added by Sethu for ML-MMOH-CRF-1100 on 28/05/2018

				formObj.credit_doc_ref2.readOnly=false;
				
				if (arr.length == 5)
				{				
					formObj.credit_doc_ref2.value = arr[4];
					if (arr[4].length>0)
					{
						formObj.credit_doc_ref2.readOnly=true;
					}
				}

				// Code Added by Sethu for ML-MMOH-CRF-1100 on 28/05/2018				
				
				if(arrval[0]== null || arrval[0]=='null')
					formObj.cust_valid_from_date.value = '';
				else
				{
					formObj.cust_valid_from_date.value = arrval[0];
				}
				  
				  
				if(arrval[1]== null || arrval[1]=='null')  
					formObj.cust_valid_to_date.value='';
				else
				{
					formObj.cust_valid_to_date.value=arrval[1];
				}
				  
				formObj.cust_2_desc.value		=arrval[2];
				formObj.cust_curr_desc.value   = arrval[2];
				formObj.cust_group_desc_2.value	=arrval[3];


				// formObj.credit_doc_ref2.value				= 'T1222121';
				formObj.credit_doc_start_date2.value		= arrval[4];
				formObj.credit_doc_date2.value				= arrval[5];
				//added by sarathkumar 27/june/16 for ML-MMOH-SCF-0398.1 
				formObj.credit_doc_start_date2.readOnly=true;
				formObj.credit_doc_start_date2Img.disabled=true;
				formObj.credit_doc_date2.readOnly=true;
				formObj.credit_doc_date2Img.disabled=true;
				  
				/*alert(parent.frames[1].frames[0].document.credit_doc_ref2.value);
				alert(parent.frames[1].frames[0].document.credit_doc_start_date2.value);
				alert(parent.frames[1].frames[0].document.credit_doc_date2.value);*/
				if(arrval[6]!="") 
				{
					formReln.pat_reln_with_resp_person.value =arrval[6];
					//	formReln.pat_reln_with_resp_person.value ="";
					// Karthik Added the below validation to Truncate 30 chars , if the responsible persons name is greater than 30 characters 
					var resp_for_payment_str_truncated=arr[3];
					if(resp_for_payment_str_truncated!='' && resp_for_payment_str_truncated.length >30)
					{
						resp_for_payment_str_truncated=resp_for_payment_str_truncated.substring(0, 30);//30 chars from Zero
					}
					formReln.resp_for_payment.value =resp_for_payment_str_truncated;
					formReln.gl_holder_name.value =resp_for_payment_str_truncated;
					formReln.pat_reln_with_gl_holder.value =arrval[6];
					formReln.pat_reln_with_resp_person.disabled  =  false;
					formReln.patrelbut.disabled = false;
				}						   
			}		
		}
		else
		{

			var arr= messageVal.split("$|#");
			/*var msg6=  arr[5].split("^");
			var msg8=  arr[7].split("^");
			if (msg6[1] == undefined)  
				{				
				msg6[1] = arr[3];
				}
			if (msg8[1]==undefined)
				msg8[1] = '';
			*/
			//added by sarathkumar 27/june/16 for ML-MMOH-SCF-0398.1 
			if(arr[3] == undefined || arr[3] == '')
			{
				alert(""+arr[1]);
			}
			else
			{
				alert(""+arr[3]);
			}
		}			
	}
}


function formeGLcustomerValidation(cust_code,cust_grp_code,reln_code,episode_type)
{	
	
//	alert("inside formeGlCustomervalidation");
/*var xmlDoc = new ActiveXObject( "Microsoft.XMLDom" ) ;
var xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" ) ;*/
var xmlDoc = "";
var xmlHttp = new XMLHttpRequest();
var xmlStr="<root><report/></root>";
var param="func_mode=eGLCustGroup&cust_code="+cust_code+"&cust_grp_code="+cust_grp_code+"&reln_code="+reln_code+"&episode_type="+ episode_type;
//xmlDoc.loadXML(xmlStr);
new DOMParser().parseFromString(getXMLString(xmlStr), "text/xml");
xmlHttp.open("POST","../../eBL/jsp/EncounterCommonValidation.jsp?"+param,false);
xmlHttp.send(xmlDoc);
var responseText=trimString(xmlHttp.responseText);	
//alert("validation response #"+ responseText);
return responseText;
	
}
		

	
