<!DOCTYPE html>
<!-- Last modified Date : 10/1/2005 10:26 AM -->
<%@page  import ="java.sql.*,java.util.*,eCommon.XSSRequestWrapper" %>
<% request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
%>
<Script language="JavaScript" src="../../eCommon/js/CommonLookup.js" ></Script>
<Script language='javascript' src='../../eMP/js/AddressLookup.js'></Script>
<script> 


function sendToValidation(Val,areaobj,messageFrame)  
{ 
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	if ( Val == 7 )
	{  
        if(areaobj.value !='')
        {
           
			if(messageFrame=="parent.parent.messageFrame")
			{
			xmlStr+=" process_id=\"7\"";
			}
			else
			{
			xmlStr+=" process_id=\"20\"";
			}

			var mode =areaobj.name;
			
			
			if (mode=="r_region_code") {
				xmlStr+=" region_code=\""+document.getElementById("r_region").value+"\"";				
			}
				
			if( mode=="m_region_code") {
				xmlStr+=" region_code=\""+document.getElementById("m_region").value+"\"";
			}
				
			if( mode=="contact1_region_code") {
				xmlStr+=" region_code=\""+document.getElementById("n_region").value+"\"";
			}
				
			if( mode=="contact2_region_code") {
				xmlStr+=" region_code=\""+document.getElementById("f_region").value+"\"";
			}
				
			if( mode=="contact3_region_code") {
				xmlStr+=" region_code=\""+document.getElementById("e_region").value+"\"";
			}
				
			if (mode=="r_area_code")
				xmlStr+=" res_area_code=\""+document.getElementById("r_area").value+"\"";
				
			if( mode=="m_area_code")
				xmlStr+=" res_area_code=\""+document.getElementById("m_area").value+"\"";
				
			if( mode=="contact1_res_area_code")
				xmlStr+=" res_area_code=\""+document.getElementById("n_area").value+"\"";
				
			if( mode=="contact2_res_area_code")
				xmlStr+=" res_area_code=\""+document.getElementById("f_area").value+"\"";
				
			if( mode=="contact3_res_area_code")
				xmlStr+=" res_area_code=\""+document.getElementById("e_area").value+"\"";
				
			if (mode=="r_town_code")
				xmlStr+=" res_town_code=\""+document.getElementById("r_town").value+"\"";
				
			if( mode=="m_town_code")
				xmlStr+=" res_town_code=\""+document.getElementById("m_town").value+"\"";
				
			if( mode=="contact1_res_town_code")
				xmlStr+=" res_town_code=\""+document.getElementById("n_town").value+"\"";
				
			if( mode=="contact2_res_town_code")
				xmlStr+=" res_town_code=\""+document.getElementById("f_town").value+"\"";
				
			if( mode=="contact3_res_town_code")
				xmlStr+=" res_town_code=\""+document.getElementById("e_town").value+"\"";
				
			//Below line added for ML-MMOH-CRF-0601
            if (mode=="a_town_code")
				xmlStr+=" res_town_code=\""+document.getElementById("a_town").value+"\"";	
    
            if( mode=="a_area_code")
				xmlStr+=" res_area_code=\""+document.getElementById("a_area").value+"\"";
				
			if (mode=="a_region_code") 
				xmlStr+=" region_code=\""+document.getElementById("a_region").value+"\"";	
		    //End this ML-MMOH-CRF-0601	
			
		   
			
		//Below line modified for ML-MMOH-CRF-0601		
		if (mode=="r_postal_code" || mode=="m_postal_code" || mode=="alt_postal_code" || mode=="next_postal_code" || mode=="first_postal_code" || mode=="employ_postal_code")
				xmlStr+=" postal_code=\""+areaobj.value+"\"";
			           
           xmlStr+=" mode=\""+mode+"\"";
			xmlStr +=" /></root>";
			 xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			
			var url = "../../eMP/jsp/ServerValidationXML.jsp";
			xmlHttp.open("POST", url, false);
			xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			//alert(xmlHttp);
			xmlHttp.send(xmlDoc);
			//alert(xmlHttp.responseText);
			eval(xmlHttp.responseText);
        }
        
} 
}

function fun1()
{
}
 	
async function searchCommonCode(obj,target,title,messageFrame,locale){ 
	var retVal	= new String();                
	var tit		= title;
	var serverlet=new String();
	if(messageFrame==="parent.messageFrame")
	{
		serverlet="yes";
	}
	else
	{
		serverlet="no";
	}	
	//alert("Inside PatientAddressdLegends.jsp");
	retVal	= await AddressLookup( tit, obj.name ,target.value,serverlet);
	var arr	= new Array();
    if(retVal != null && retVal != ""){  
		var ret1 = unescape(retVal);
		arr = ret1.split("::");
		target.value=arr[1];
		
		if(target.name == 'r_postal_code1'){	 				
			document.forms[0].r_postal_code.value= arr[0];
			sendToValidation(7, document.forms[0].r_postal_code,messageFrame);
		}else if(target.name == 'm_postal_code1'){
			document.forms[0].m_postal_code.value= arr[0];
			sendToValidation(7, document.forms[0].m_postal_code,messageFrame);
		}else if(target.name == 'next_postal_code1'){
			document.forms[0].next_postal_code.value= arr[0];
			sendToValidation(7, document.forms[0].next_postal_code,messageFrame);

		//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008
		}else if(target.name == 'n_ma_postal_code1'){
			document.forms[0].n_ma_postal_code.value= arr[0];
			sendToValidation(7, document.forms[0].n_ma_postal_code,messageFrame);
		}else if(target.name == 'fst_no_ma_pos_cod1'){
			document.forms[0].fst_no_ma_pos_cod.value= arr[0];
			sendToValidation(7, document.forms[0].fst_no_ma_pos_cod,messageFrame);
        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008

		}else if(target.name == 'first_postal_code1'){
			document.forms[0].first_postal_code.value= arr[0];
			sendToValidation(7, document.forms[0].first_postal_code,messageFrame);
		}else if(target.name == 'employ_postal_code1'){
			document.forms[0].employ_postal_code.value= arr[0];
			sendToValidation(7, document.forms[0].employ_postal_code,messageFrame);
		}else if(target.name == 'r_area_code'){
			document.forms[0].r_area.value= arr[0];	
			//Added by santhosh for AMRI-SCF-0714
			//if(document.forms[0].r_region_code)
				//document.forms[0].r_region_code.value="";
			//if(document.forms[0].r_postal_code1)
				//document.forms[0].r_postal_code1.value="";	
			//End
			sendToValidation(7, document.forms[0].r_area_code,messageFrame);
		}else if(target.name == 'm_area_code'){
			document.forms[0].m_area.value= arr[0];
			//Added by santhosh for AMRI-SCF-0714
			//if(document.forms[0].m_region_code)
				//document.forms[0].m_region_code.value="";
			//if(document.forms[0].m_postal_code1)
				//document.forms[0].m_postal_code1.value="";
			//End
			sendToValidation(7, document.forms[0].m_area_code,messageFrame);
		}else if(target.name == 'contact1_res_area_code'){
			document.forms[0].n_area.value= arr[0];
			sendToValidation(7, document.forms[0].contact1_res_area_code,messageFrame);

		//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008
		}else if(target.name == 'n_contact_ma_area_code'){
			document.forms[0].nkma_area.value= arr[0];
			sendToValidation(7, document.forms[0].n_contact_ma_area_code,messageFrame);
		}else if(target.name == 'fst_to_no_ma_area_code'){
			document.forms[0].contact2_res_area.value= arr[0];
			sendToValidation(7, document.forms[0].fst_to_no_ma_area_code,messageFrame);
        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008

		}else if(target.name == 'contact2_res_area_code'){
			document.forms[0].f_area.value= arr[0];
			sendToValidation(7, document.forms[0].contact2_res_area_code,messageFrame);
		}else if(target.name == 'contact3_res_area_code'){
			document.forms[0].e_area.value= arr[0];
			sendToValidation(7, document.forms[0].contact3_res_area_code,messageFrame);
		}else if(target.name == 'r_region_code'){
			prev_region = document.forms[0].r_region.value;
			document.forms[0].r_region.value= arr[0];
			//Added by santhosh for AMRI-SCF-0714
			//if(document.forms[0].r_postal_code1)
				//document.forms[0].r_postal_code1.value="";	
			//End
			sendToValidation('7', document.forms[0].r_region_code,messageFrame,prev_region);
		}else if(target.name == 'm_region_code'){
			prev_region = document.forms[0].m_region.value;	  
			document.forms[0].m_region.value= arr[0];				
			//Added by santhosh for AMRI-SCF-0714
			//if(document.forms[0].m_postal_code1)
				//document.forms[0].m_postal_code1.value="";
			//End
			sendToValidation(7, document.forms[0].m_region_code,messageFrame,prev_region);
		}else if(target.name == 'contact1_region_code'){
			prev_region = document.forms[0].n_region.value;
			document.forms[0].n_region.value= arr[0];
			sendToValidation(7, document.forms[0].contact1_region_code,messageFrame,prev_region);

		//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008
		}else if(target.name == 'n_contac_region_code'){
			prev_region = document.forms[0].contact1_region.value;
			document.forms[0].contact1_region.value= arr[0];
			sendToValidation(7, document.forms[0].n_contac_region_code,messageFrame,prev_region);
		}else if(target.name == 'fst_to_no_ma_reg_cod'){
			prev_region = document.forms[0].contact2_region.value;
			document.forms[0].contact2_region.value= arr[0];
			sendToValidation(7, document.forms[0].fst_to_no_ma_reg_cod,messageFrame,prev_region);
        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008

		}else if(target.name == 'contact2_region_code'){
			prev_region = document.forms[0].f_region.value;
			document.forms[0].f_region.value= arr[0];
			sendToValidation(7, document.forms[0].contact2_region_code,messageFrame,prev_region);
		}else if(target.name == 'contact3_region_code'){
			prev_region = document.forms[0].e_region.value;
			document.forms[0].e_region.value= arr[0];
			sendToValidation(7, document.forms[0].contact3_region_code,messageFrame,prev_region);
		}else if(target.name == 'r_town_code'){
			document.forms[0].r_town.value= arr[0];	
            //Added for ML-MMOH-CRF-0860.2
			//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi 
			if(document.forms[0].r_region_code)
				document.forms[0].r_region_code.value="";
			if(document.forms[0].r_area_code)
				document.forms[0].r_area_code.value=""; 
			if(document.forms[0].r_postal_code1)
				document.forms[0].r_postal_code1.value="";			
			sendToValidation(7, document.forms[0].r_town_code,messageFrame);
		}else if(target.name == 'm_town_code'){
			document.forms[0].m_town.value= arr[0];
			//Added for ML-MMOH-CRF-0860.2
			//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi 
			if(document.forms[0].m_region_code)
				document.forms[0].m_region_code.value="";
			if(document.forms[0].m_area_code)
				document.forms[0].m_area_code.value="";
			if(document.forms[0].m_postal_code1)
				document.forms[0].m_postal_code1.value="";
			
			sendToValidation(7, document.forms[0].m_town_code,messageFrame);
		}else if(target.name == 'contact1_res_town_code'){
			document.forms[0].n_town.value= arr[0];
			sendToValidation(7, document.forms[0].contact1_res_town_code,messageFrame);
			

		//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008
		}else if(target.name == 'n_contact_ma_town_code'){
			document.forms[0].nkma_town.value= arr[0];
			sendToValidation(7, document.forms[0].n_contact_ma_town_code,messageFrame);
			
		}else if(target.name == 'fst_to_no_ma_town_code'){
			document.forms[0].contact2_res_town.value= arr[0];
			sendToValidation(7, document.forms[0].fst_to_no_ma_town_code,messageFrame);
        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008

		}else if(target.name == 'contact2_res_town_code'){
			document.forms[0].f_town.value= arr[0];
			sendToValidation(7, document.forms[0].contact2_res_town_code,messageFrame);
		}else if(target.name == 'contact3_res_town_code'){
			document.forms[0].e_town.value= arr[0];
			sendToValidation(7, document.forms[0].contact3_res_town_code,messageFrame);
		/*Below line added for this CRF ML-MMOH-CRF-0860.2*/	
		}else if(target.name == 'alt_postal_code1'){	 				
			document.forms[0].alt_postal_code.value= arr[0];	
			sendToValidation(7, document.forms[0].alt_postal_code,messageFrame);
		}else if(target.name == 'a_area_code'){
			document.forms[0].a_area.value= arr[0];	
			sendToValidation(7, document.forms[0].a_area_code,messageFrame);
		}else if(target.name == 'a_town_code'){
			document.forms[0].a_town.value= arr[0];	
			//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi 
			if(document.forms[0].a_region_code)
				document.forms[0].a_region_code.value="";
			if(document.forms[0].a_area_code)
				document.forms[0].a_area_code.value="";  
			if(document.forms[0].alt_postal_code1)
				document.forms[0].alt_postal_code1.value="";			
			sendToValidation(7, document.forms[0].a_town_code,messageFrame);
		}else if(target.name == 'a_region_code'){
			prev_region = document.forms[0].a_region.value;
			document.forms[0].a_region.value= arr[0];
			sendToValidation('7', document.forms[0].a_region_code,messageFrame,prev_region);
		}
		//else if(target.name == 'a_town_code'){
			//document.forms[0].a_town.value= arr[0];
			//sendToValidation(7, document.forms[0].a_town_code,messageFrame);
		//}
		//End this ML-MMOH-CRF-0860.2
		
	}else{  
		if(target.name == 'r_postal_code'){
			document.forms[0].r_postal_code='';
		}else if(target.name == 'm_postal_code'){
			document.forms[0].m_postal_code='';
		}else if(target.name == 'next_postal_code'){
			document.forms[0].next_postal_code='';
		//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008
		}else if(target.name == 'n_ma_postal_code'){
			document.forms[0].n_ma_postal_code='';
		}else if(target.name == 'fst_no_ma_pos_cod'){
			document.forms[0].fst_no_ma_pos_cod='';
         //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008
		}else if(target.name == 'first_postal_code'){
			document.forms[0].first_postal_code='';
		}else if(target.name == 'employ_postal_code'){
			document.forms[0].employ_postal_code='';
		}else if(target.name == 'r_area_code'){
			document.forms[0].r_area.value= '';
		}else if(target.name == 'm_area_code'){
			document.forms[0].m_area.value = '';
		}else if(target.name == 'contact1_res_area_code'){
			document.forms[0].n_area.value = '';
		//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008
		}else if(target.name == 'n_contact_ma_area_code'){
			document.forms[0].nkma_area.value = '';
        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008
		}else if(target.name == 'contact2_res_area_code'){
			document.forms[0].f_area.value = '';
		}else if(target.name == 'contact3_res_area_code'){
			document.forms[0].e_area.value = '';
		}else if(target.name == 'r_region_code'){
			document.forms[0].r_region.value = '';
		}else if(target.name == 'm_region_code'){
			document.forms[0].m_region.value = '';
		}else if(target.name == 'contact1_region_code'){
			document.forms[0].n_region.value = '';
		//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008
		}else if(target.name == 'n_contac_region_code'){
			document.forms[0].contact1_region.value = '';
        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008
		}else if(target.name=='contact2_region_code'){
			document.forms[0].f_region.value = '';
		}else if(target.name == 'contact3_region_code'){
			document.forms[0].e_region.value = '';
		}else if(target.name == 'r_town_code'){
			document.forms[0].r_town.value = '';
		}else if(target.name == 'm_town_code'){  
			document.forms[0].m_town.value = '';
		}else if(target.name == 'contact1_res_town_code'){
			document.forms[0].n_town.value= '';
		//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008
		}else if(target.name == 'n_contact_ma_town_code'){
			document.forms[0].nkma_town.value= '';
        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008
		}else if(target.name == 'contact2_res_town_code'){
			document.forms[0].f_town.value = '';
		}else if(target.name == 'contact3_res_town_code'){
			document.forms[0].e_town.value = '';
		}
		//}
		target.value = '';
	}
} 


async function searchCommonCodenew(obj,target,title,messageFrame,locale){ 
	var retVal	= new String();                
	var tit		= title;
	//alert("Inside PatientAddressdLegends.jsp");
	alert(obj);
	alert(target);
	alert(title);
	alert(messageFrame);
	alert(locale);
	retVal	= await AddressLookupnew( tit, obj.name ,target.value);
	//alert(retVal);
	var arr	= new Array();
    if(retVal != null && retVal != ""){  
		var ret1 = unescape(retVal);
		arr = ret1.split("::");
		target.value=arr[1];
		
		if(target.name == 'r_postal_code1'){	 				
			document.forms[0].r_postal_code.value= arr[0];
			sendToValidation(7, document.forms[0].r_postal_code,messageFrame);
		}else if(target.name == 'm_postal_code1'){
			document.forms[0].m_postal_code.value= arr[0];
			sendToValidation(7, document.forms[0].m_postal_code,messageFrame);
		}else if(target.name == 'next_postal_code1'){
			document.forms[0].next_postal_code.value= arr[0];
			sendToValidation(7, document.forms[0].next_postal_code,messageFrame);

		//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008
		}else if(target.name == 'n_ma_postal_code1'){
			document.forms[0].n_ma_postal_code.value= arr[0];
			sendToValidation(7, document.forms[0].n_ma_postal_code,messageFrame);
		}else if(target.name == 'fst_no_ma_pos_cod1'){
			document.forms[0].fst_no_ma_pos_cod.value= arr[0];
			sendToValidation(7, document.forms[0].fst_no_ma_pos_cod,messageFrame);
        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008

		}else if(target.name == 'first_postal_code1'){
			document.forms[0].first_postal_code.value= arr[0];
			sendToValidation(7, document.forms[0].first_postal_code,messageFrame);
		}else if(target.name == 'employ_postal_code1'){
			document.forms[0].employ_postal_code.value= arr[0];
			sendToValidation(7, document.forms[0].employ_postal_code,messageFrame);
		}else if(target.name == 'r_area_code'){
			document.forms[0].r_area.value= arr[0];	
			//Added by santhosh for AMRI-SCF-0714
			//if(document.forms[0].r_region_code)
				//document.forms[0].r_region_code.value="";
			//if(document.forms[0].r_postal_code1)
				//document.forms[0].r_postal_code1.value="";	
			//End
			sendToValidation(7, document.forms[0].r_area_code,messageFrame);
		}else if(target.name == 'm_area_code'){
			document.forms[0].m_area.value= arr[0];
			//Added by santhosh for AMRI-SCF-0714
			//if(document.forms[0].m_region_code)
				//document.forms[0].m_region_code.value="";
			//if(document.forms[0].m_postal_code1)
				//document.forms[0].m_postal_code1.value="";
			//End
			sendToValidation(7, document.forms[0].m_area_code,messageFrame);
		}else if(target.name == 'contact1_res_area_code'){
			document.forms[0].n_area.value= arr[0];
			sendToValidation(7, document.forms[0].contact1_res_area_code,messageFrame);

		//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008
		}else if(target.name == 'n_contact_ma_area_code'){
			document.forms[0].nkma_area.value= arr[0];
			sendToValidation(7, document.forms[0].n_contact_ma_area_code,messageFrame);
		}else if(target.name == 'fst_to_no_ma_area_code'){
			document.forms[0].contact2_res_area.value= arr[0];
			sendToValidation(7, document.forms[0].fst_to_no_ma_area_code,messageFrame);
        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008

		}else if(target.name == 'contact2_res_area_code'){
			document.forms[0].f_area.value= arr[0];
			sendToValidation(7, document.forms[0].contact2_res_area_code,messageFrame);
		}else if(target.name == 'contact3_res_area_code'){
			document.forms[0].e_area.value= arr[0];
			sendToValidation(7, document.forms[0].contact3_res_area_code,messageFrame);
		}else if(target.name == 'r_region_code'){
			prev_region = document.forms[0].r_region.value;
			document.forms[0].r_region.value= arr[0];
			//Added by santhosh for AMRI-SCF-0714
			//if(document.forms[0].r_postal_code1)
				//document.forms[0].r_postal_code1.value="";	
			//End
			sendToValidation('7', document.forms[0].r_region_code,messageFrame,prev_region);
		}else if(target.name == 'm_region_code'){
			prev_region = document.forms[0].m_region.value;	  
			document.forms[0].m_region.value= arr[0];				
			//Added by santhosh for AMRI-SCF-0714
			//if(document.forms[0].m_postal_code1)
				//document.forms[0].m_postal_code1.value="";
			//End
			sendToValidation(7, document.forms[0].m_region_code,messageFrame,prev_region);
		}else if(target.name == 'contact1_region_code'){
			prev_region = document.forms[0].n_region.value;
			document.forms[0].n_region.value= arr[0];
			sendToValidation(7, document.forms[0].contact1_region_code,messageFrame,prev_region);

		//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008
		}else if(target.name == 'n_contac_region_code'){
			prev_region = document.forms[0].contact1_region.value;
			document.forms[0].contact1_region.value= arr[0];
			sendToValidation(7, document.forms[0].n_contac_region_code,messageFrame,prev_region);
		}else if(target.name == 'fst_to_no_ma_reg_cod'){
			prev_region = document.forms[0].contact2_region.value;
			document.forms[0].contact2_region.value= arr[0];
			sendToValidation(7, document.forms[0].fst_to_no_ma_reg_cod,messageFrame,prev_region);
        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008

		}else if(target.name == 'contact2_region_code'){
			prev_region = document.forms[0].f_region.value;
			document.forms[0].f_region.value= arr[0];
			sendToValidation(7, document.forms[0].contact2_region_code,messageFrame,prev_region);
		}else if(target.name == 'contact3_region_code'){
			prev_region = document.forms[0].e_region.value;
			document.forms[0].e_region.value= arr[0];
			sendToValidation(7, document.forms[0].contact3_region_code,messageFrame,prev_region);
		}else if(target.name == 'r_town_code'){
			document.forms[0].r_town.value= arr[0];	
            //Added for ML-MMOH-CRF-0860.2
			//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi 
			if(document.forms[0].r_region_code)
				document.forms[0].r_region_code.value="";
			if(document.forms[0].r_area_code)
				document.forms[0].r_area_code.value=""; 
			if(document.forms[0].r_postal_code1)
				document.forms[0].r_postal_code1.value="";			
			sendToValidation(7, document.forms[0].r_town_code,messageFrame);
		}else if(target.name == 'm_town_code'){
			document.forms[0].m_town.value= arr[0];
			//Added for ML-MMOH-CRF-0860.2
			//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi 
			if(document.forms[0].m_region_code)
				document.forms[0].m_region_code.value="";
			if(document.forms[0].m_area_code)
				document.forms[0].m_area_code.value="";
			if(document.forms[0].m_postal_code1)
				document.forms[0].m_postal_code1.value="";
			
			sendToValidation(7, document.forms[0].m_town_code,messageFrame);
		}else if(target.name == 'contact1_res_town_code'){
			document.forms[0].n_town.value= arr[0];
			sendToValidation(7, document.forms[0].contact1_res_town_code,messageFrame);
			

		//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008
		}else if(target.name == 'n_contact_ma_town_code'){
			document.forms[0].nkma_town.value= arr[0];
			sendToValidation(7, document.forms[0].n_contact_ma_town_code,messageFrame);
			
		}else if(target.name == 'fst_to_no_ma_town_code'){
			document.forms[0].contact2_res_town.value= arr[0];
			sendToValidation(7, document.forms[0].fst_to_no_ma_town_code,messageFrame);
        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008

		}else if(target.name == 'contact2_res_town_code'){
			document.forms[0].f_town.value= arr[0];
			sendToValidation(7, document.forms[0].contact2_res_town_code,messageFrame);
		}else if(target.name == 'contact3_res_town_code'){
			document.forms[0].e_town.value= arr[0];
			sendToValidation(7, document.forms[0].contact3_res_town_code,messageFrame);
		/*Below line added for this CRF ML-MMOH-CRF-0860.2*/	
		}else if(target.name == 'alt_postal_code1'){	 				
			document.forms[0].alt_postal_code.value= arr[0];	
			sendToValidation(7, document.forms[0].alt_postal_code,messageFrame);
		}else if(target.name == 'a_area_code'){
			document.forms[0].a_area.value= arr[0];	
			sendToValidation(7, document.forms[0].a_area_code,messageFrame);
		}else if(target.name == 'a_town_code'){
			document.forms[0].a_town.value= arr[0];	
			//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi 
			if(document.forms[0].a_region_code)
				document.forms[0].a_region_code.value="";
			if(document.forms[0].a_area_code)
				document.forms[0].a_area_code.value="";  
			if(document.forms[0].alt_postal_code1)
				document.forms[0].alt_postal_code1.value="";			
			sendToValidation(7, document.forms[0].a_town_code,messageFrame);
		}else if(target.name == 'a_region_code'){
			prev_region = document.forms[0].a_region.value;
			document.forms[0].a_region.value= arr[0];
			sendToValidation('7', document.forms[0].a_region_code,messageFrame,prev_region);
		}
		//else if(target.name == 'a_town_code'){
			//document.forms[0].a_town.value= arr[0];
			//sendToValidation(7, document.forms[0].a_town_code,messageFrame);
		//}
		//End this ML-MMOH-CRF-0860.2
		
	}else{  
		if(target.name == 'r_postal_code'){
			document.forms[0].r_postal_code='';
		}else if(target.name == 'm_postal_code'){
			document.forms[0].m_postal_code='';
		}else if(target.name == 'next_postal_code'){
			document.forms[0].next_postal_code='';
		//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008
		}else if(target.name == 'n_ma_postal_code'){
			document.forms[0].n_ma_postal_code='';
		}else if(target.name == 'fst_no_ma_pos_cod'){
			document.forms[0].fst_no_ma_pos_cod='';
         //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008
		}else if(target.name == 'first_postal_code'){
			document.forms[0].first_postal_code='';
		}else if(target.name == 'employ_postal_code'){
			document.forms[0].employ_postal_code='';
		}else if(target.name == 'r_area_code'){
			document.forms[0].r_area.value= '';
		}else if(target.name == 'm_area_code'){
			document.forms[0].m_area.value = '';
		}else if(target.name == 'contact1_res_area_code'){
			document.forms[0].n_area.value = '';
		//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008
		}else if(target.name == 'n_contact_ma_area_code'){
			document.forms[0].nkma_area.value = '';
        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008
		}else if(target.name == 'contact2_res_area_code'){
			document.forms[0].f_area.value = '';
		}else if(target.name == 'contact3_res_area_code'){
			document.forms[0].e_area.value = '';
		}else if(target.name == 'r_region_code'){
			document.forms[0].r_region.value = '';
		}else if(target.name == 'm_region_code'){
			document.forms[0].m_region.value = '';
		}else if(target.name == 'contact1_region_code'){
			document.forms[0].n_region.value = '';
		//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008
		}else if(target.name == 'n_contac_region_code'){
			document.forms[0].contact1_region.value = '';
        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008
		}else if(target.name=='contact2_region_code'){
			document.forms[0].f_region.value = '';
		}else if(target.name == 'contact3_region_code'){
			document.forms[0].e_region.value = '';
		}else if(target.name == 'r_town_code'){
			document.forms[0].r_town.value = '';
		}else if(target.name == 'm_town_code'){  
			document.forms[0].m_town.value = '';
		}else if(target.name == 'contact1_res_town_code'){
			document.forms[0].n_town.value= '';
		//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008
		}else if(target.name == 'n_contact_ma_town_code'){
			document.forms[0].nkma_town.value= '';
        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008
		}else if(target.name == 'contact2_res_town_code'){
			document.forms[0].f_town.value = '';
		}else if(target.name == 'contact3_res_town_code'){
			document.forms[0].e_town.value = '';
		}
		//}
		target.value = '';
	}
}
function clearCommonCode(target){ 
 
	            if(target.name == 'r_postal_code1')
				{
					document.forms[0].r_postal_code.value='';
				}
				else if(target.name == 'm_postal_code1')
				{
					document.forms[0].m_postal_code.value='';
				}
				else if(target.name == 'next_postal_code1')
				{
					document.forms[0].next_postal_code.value='';
				}
				else if(target.name == 'first_postal_code1')
				{
					document.forms[0].first_postal_code.value='';
				}
				else if(target.name == 'employ_postal_code1')
				{
					document.forms[0].employ_postal_code.value='';
				}
				else if(target.name == 'r_area_code')
				{
					document.forms[0].r_area.value= '';
				}
				else if(target.name == 'm_area_code')
				{
					document.forms[0].m_area.value = '';
				}
				else if(target.name == 'contact1_res_area_code')
				{
					document.forms[0].n_area.value = '';
				}
  				else if(target.name == 'contact2_res_area_code')
				{
					document.forms[0].f_area.value = '';
				}
				else if(target.name == 'contact3_res_area_code')
				{
					document.forms[0].e_area.value = '';
				}
				else if(target.name == 'r_region_code')
				{
					document.forms[0].r_region.value = '';
				}
				else if(target.name == 'm_region_code')
				{
					document.forms[0].m_region.value = '';
				}
				else if(target.name == 'contact1_region_code')
				{
					document.forms[0].n_region.value = '';
				}
				else if(target.name=='contact2_region_code')
				{
					document.forms[0].f_region.value = '';
				}
				else if(target.name == 'contact3_region_code')
				{
					document.forms[0].e_region.value = '';
				}
				else if(target.name == 'r_town_code')
				{
					document.forms[0].r_town.value = '';
				}
				else if(target.name == 'm_town_code')
				{
					document.forms[0].m_town.value = '';
				}
				else if(target.name == 'contact1_res_town_code')
				{
					document.forms[0].n_town.value= '';
				}
				else if(target.name == 'contact2_res_town_code')
				{
					document.forms[0].f_town.value = '';					
				}
				else if(target.name == 'contact3_res_town_code')
				{
					document.forms[0].e_town.value = '';
				//Below line added for this CRF ML-MMOH-CRF-0601
					
				}else if(target.name == 'a_town_code')
				{
					document.forms[0].a_town.value = '';
					
				}else if(target.name == 'a_area_code')
				{
					document.forms[0].a_area.value= '';
				}
				else if(target.name == 'a_region_code')
				{
					document.forms[0].a_region.value = '';
				}
                else if(target.name == 'alt_postal_code1')
				{
					document.forms[0].alt_postal_code.value='';
				} 				
				//Above line added for this CRF ML-MMOH-CRF-0601
}
 
//ML-MMOH-CRF-0860
function maxLengthPaste(obj)
 { 
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
	if (obj.getAttribute && obj.value.length>mlength)
	{
    	var errors1 = getMessage("EXCEED_MAX_LENGTH", "Sm",null);
        alert(errors1);	
		obj.value=obj.value.substring(0,mlength);
	}
 }
 
 function RemoveSpecialChar(txtVal){
	if(txtVal.value.indexOf("~")!=-1){
		 //txtVal.value = txtVal.value.replace("~", ''); 
          txtVal.value = txtVal.value.replace(/~/g, '');
          //txtVal.value = txtVal.value.replace(new RegExp('hello', 'g'), 'hi');		 
	}
 } 
 
//End ML-MMOH-CRF-0860
</script>
<%!
   ArrayList fetchContactAddresses(Connection con,  javax.servlet.jsp.JspWriter out,String messageFrame,java.util.Properties p)
    {
		java.sql.Statement stmt		= null;
        ResultSet rset				= null; 
		java.sql.Statement stmt1	= null;
		ResultSet rset1				= null;	
		
		//Added for this CRF ML-MMOH-CRF-0860.2
		boolean increasedaddressLength = false;

        ArrayList return_arrlist = new ArrayList();
        out = out;
		String locale = p.getProperty("LOCALE");
        try
        {
		    //Added for this CRF ML-MMOH-CRF-0860.2
			increasedaddressLength = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INCREASED_ADDRESS_LINE_LENGTH");
			
			 String prompt_sql = "SELECT initcap(res_area_prompt) res_area_prompt, initcap(res_town_prompt) res_town_prompt, postal_code_prompt, initcap(region_prompt) region_prompt FROM sm_site_param_LANG_VW where site_id='DS' and language_id='"+locale+"' ";

			String res_area_prompt		= "";
			String res_town_prompt		= "";
			String postal_code_prompt	= "";
			String region_prompt		= "";
			
			stmt1 = con.createStatement() ;
			rset1 = stmt1.executeQuery(prompt_sql) ;
	          
			while(rset1.next())
			{
				res_area_prompt		= rset1.getString("res_area_prompt");
				res_town_prompt		= rset1.getString("res_town_prompt");
				postal_code_prompt	= rset1.getString("postal_code_prompt");
				region_prompt		= rset1.getString("region_prompt");
			}
           
		    /*Below line modified for this CRF ML-MMOH-CRF-0860 (increase the maxlength from 30 to 100)*/		  
			/*String addr_line1 = "<input type='text' name='r_addr_line1' id='r_addr_line1' maxlength='100' size='25' value=\"\" tabIndex='@' onBlur='makeValidString(this)'>";
            String addr_line2 = "<input type='text' name='r_addr_line2' id='r_addr_line2' maxlength='100' size='25' value=\"\" tabIndex='@'onBlur='makeValidString(this)'>";
            String addr_line3 = "<input type='text' name='r_addr_line3' id='r_addr_line3' maxlength='100' size='25' value=\"\" tabIndex='@' onBlur='makeValidString(this)'>";
			*/
            //End this CRF ML-MMOH-CRF-0860
			 
			//below line added for this ML-MMOH-CRF-0860.2
			String addr_line1="";
			String addr_line2="";
			String addr_line3="";
			String town_length="40";
			String rapidreg_nextofkin_addr_line1="";
			String rapidreg_nextofkin_addr_line2="";
			String rapidreg_nextofkin_addr_line3="";
			if(increasedaddressLength){
             town_length="36";			
			/* addr_line1 = "<textarea name='r_addr_line1' rows=3 cols=50 onblur='makeValidString(this);' onpaste='return maxLengthPaste(this,100);' onkeypress='checkMaxLimit(this,100)'></textarea>";
			 addr_line2 = "<textarea name='r_addr_line2' rows=3 cols=50 onblur='makeValidString(this);' onpaste='return maxLengthPaste(this,100);' onkeypress='checkMaxLimit(this,100)'></textarea>";
			 addr_line3 = "<textarea name='r_addr_line3' rows=3 cols=50 onblur='makeValidString(this);' onpaste='return maxLengthPaste(this,100);' onkeypress='checkMaxLimit(this,100)'></textarea>";*/
			 
			 addr_line1 = "<textarea name='r_addr_line1' id='r_addr_line1' rows=3 maxlength=100 cols=50 tabIndex='@' onblur='makeValidString(this); maxLengthPaste(this);' onkeypress='checkMaxLimit(this,100)' onkeyup='RemoveSpecialChar(this)' ></textarea>"; //Modified by Suji Keerthi for PMG2020-ML-MMOH-CRF-0001
			 addr_line2 = "<textarea name='r_addr_line2' id='r_addr_line2' rows=3 maxlength=100 cols=50 tabIndex='@' onblur='makeValidString(this); maxLengthPaste(this);'  onkeypress='checkMaxLimit(this,100)' onkeyup='RemoveSpecialChar(this)' ></textarea>"; //Modified by Suji Keerthi for PMG2020-ML-MMOH-CRF-0001
			 addr_line3 = "<textarea name='r_addr_line3' id='r_addr_line3' rows=3 maxlength=100 cols=50 tabIndex='@' onblur='makeValidString(this); maxLengthPaste(this);'  onkeypress='checkMaxLimit(this,100)' onkeyup='RemoveSpecialChar(this)' ></textarea>"; //Modified by Suji Keerthi for PMG2020-ML-MMOH-CRF-0001
			 			 
			}else{			
		     addr_line1 = "<input type='text' name='r_addr_line1' id='r_addr_line1' maxlength='30' size='25' value=\"\" tabIndex='@' onBlur='makeValidString(this)'  onkeyup='RemoveSpecialChar(this)'>";
			 addr_line2 = "<input type='text' name='r_addr_line2' id='r_addr_line2' maxlength='30' size='25' value=\"\" tabIndex='@'onBlur='makeValidString(this)'  onkeyup='RemoveSpecialChar(this)'>";
             addr_line3 = "<input type='text' name='r_addr_line3' id='r_addr_line3' maxlength='30' size='25' value=\"\" tabIndex='@' onBlur='makeValidString(this)'  onkeyup='RemoveSpecialChar(this)'>";
			}			
			//End this ML-MMOH-CRF-0860.2
			
			
			String addr_line4 = "<input type='text' name='r_addr_line4' id='r_addr_line4' maxlength='30' size='25' value=\"\" tabIndex='@' onBlur='makeValidString(this)'  onkeyup='RemoveSpecialChar(this)'>";
			System.out.println("res_town_prompt"+res_town_prompt);
             
			String res_town = "<input align='left' type='text' name='r_town_code' id='r_town_code'  size='"+town_length+"'  maxlength='"+town_length+"' onBlur=\"if(this.value != ''){ searchCommonCode(town_code[0],r_town_code,'"+res_town_prompt+"','"+messageFrame+"','"+locale+"')}else{clearCommonCode(r_town_code)}\" tabindex='@'><input type='button' name='town_code' id='town_code' value='?' class='button' onclick=\"searchCommonCode(this,r_town_code,'"+res_town_prompt+"','"+messageFrame+"','"+locale+"')\"  tabindex='@'>";	
           
		   
			
			String res_area = "<input align='left' type='text' name='r_area_code' id='r_area_code'  size='27' maxlength='30' onBlur=\"if(this.value != ''){ searchCommonCode(area_code[0],r_area_code,'"+res_area_prompt+"','"+messageFrame+"','"+locale+"')} else { clearCommonCode(r_area_code)}\" tabindex='@'><input type='button' name='area_code' id='area_code' value='?' class='button' onclick=\"searchCommonCode(this,r_area_code,'"+res_area_prompt+"','"+messageFrame+"','"+locale+"')\"  tabindex='@'>";
			String region = "<input align='left' type='text' name='r_region_code' id='r_region_code'  size='27' maxlength='30' onBlur=\"if(this.value != '') {searchCommonCode(region_code[0],r_region_code,'"+region_prompt+"','"+messageFrame+"','"+locale+"')}else{clearCommonCode(r_region_code)}\" tabindex='@'><input type='button' name='region_code' id='region_code' value='?' class='button' onclick=\"searchCommonCode(this,r_region_code,'"+region_prompt+"','"+messageFrame+"','"+locale+"')\" tabindex='@'>";
           	String postal_code = "<input align='left' type='text' name='r_postal_code1' id='r_postal_code1'  size='15' maxlength='15'  onBlur=\"if(this.value != ''){ searchCommonCode(postal_code[0],r_postal_code1,'"+postal_code_prompt+"','"+messageFrame+"','"+locale+"')} else{ clearCommonCode(r_postal_code1)}\"tabindex='@'><input type='button' name='postal_code' id='postal_code' value='?' class='button' onclick=\"searchCommonCode(this,r_postal_code1,'"+postal_code_prompt+"','"+messageFrame+"','"+locale+"')\" tabindex='@'>";
            
            String[] prompts        = new String [8];
            String[] elements       = new String [8];
            String[] colnamearray	= new String [8];

            String[] elements_ord =  { "ADDR_LINE1", "ADDR_LINE2", "ADDR_LINE3", "ADDR_LINE4", "RES_TOWN", "RES_AREA", "REGION", "POSTAL_CODE" };
            String[] elements_val =  { addr_line1, addr_line2, addr_line3, addr_line4, res_town, res_area, region, postal_code };
            
            String sql = "SELECT site_id, initcap(addr_line1_prompt) addr_line1_prompt, addr_line1_order, initcap(addr_line2_prompt) addr_line2_prompt, addr_line2_order, initcap(addr_line3_prompt) addr_line3_prompt, addr_line3_order, initcap(addr_line4_prompt) addr_line4_prompt, addr_line4_order, initcap(res_area_prompt) res_area_prompt, res_area_order, initcap(res_town_prompt) res_town_prompt, res_town_order, postal_code_prompt, postal_code_order, region_prompt, region_order, addr_line1_appl_yn, addr_line2_appl_yn, addr_line3_appl_yn, addr_line4_appl_yn, res_area_appl_yn, res_town_appl_yn, region_appl_yn, postal_code_appl_yn FROM sm_site_param_LANG_VW where site_id='DS' AND language_id='"+locale+"'  ";

            stmt = con.createStatement();
            rset = stmt.executeQuery(sql);
            int tot_count = 0;
            
            if(rset != null)
            {
                if(rset.next())
                {
                    ResultSetMetaData rsmd = rset.getMetaData() ;
                    int numberOfColumns = rsmd.getColumnCount();
					String site = "";
					if ( rset.getString("site_id") != null )
						site = rset.getString("site_id");
                    return_arrlist.add(site) ;

                    for(int i=0; i<numberOfColumns; i++)
                    {
                        String columnName = rsmd.getColumnName(i+1) ;
                        
                        if(!columnName.equalsIgnoreCase("site_id"))
                        {
                            if( columnName.indexOf( "_ORDER" ) != -1)
                            {
                                String colname = (columnName.substring(0,columnName.indexOf( "_ORDER" )))+"_PROMPT" ;
								String applcolname = (columnName.substring(0,columnName.indexOf( "_ORDER" )))+"_APPL_YN" ;
								
								String appl_yn = "N";
								int ord = rset.getInt( columnName ) ;
								appl_yn = rset.getString(applcolname);
								if (appl_yn == null) appl_yn = "N";

                                if(ord!= 0 && appl_yn.equals("Y"))
                                {
                                    tot_count++ ;
                                    colnamearray[ord-1] = colname ;
                                    prompts[ord-1] = rset.getString(colname);
                                    if(prompts[ord-1] == null) prompts[ord-1] = "&nbsp;" ;

                                    for( int j=0; j<8;j++)
                                    {
                                        if( colname.indexOf(elements_ord[j]) != -1)
                                        {
                                            elements[ord-1] = elements_val[j] ;
                                            break ;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            
            String[] prompts_temp       = new String [tot_count];
            String[] elements_temp      = new String [tot_count];
            String[] colnamearray_temp	= new String [tot_count];
			
			
			
            tot_count = 0 ;
            for(int i=0; i<prompts.length; i++)
            {
                if(prompts[i] != null)
                {
                    prompts_temp[tot_count]      = prompts[i] ;
                    elements_temp[tot_count]     = elements[i] ;    
                    colnamearray_temp[tot_count] = colnamearray[i] ;
															
                    tot_count++ ;
                }
            }

            return_arrlist.add(colnamearray_temp);
            return_arrlist.add(prompts_temp);
            return_arrlist.add(elements_temp);
			
			

			if(rset != null) rset.close();
			if(rset1 != null) rset1.close();
			if(stmt != null) stmt.close();
			if(stmt1 != null) stmt1.close();
        }
		catch(Exception e)
        {
         
        e.printStackTrace();		 
         
		}
        return return_arrlist ;
    }
	   ArrayList fetchContactAddressesLocal(Connection con,  javax.servlet.jsp.JspWriter out,String messageFrame,java.util.Properties p)
    {
		java.sql.Statement stmt		= null;
        ResultSet rset				= null; 
		java.sql.Statement stmt1	= null;
		ResultSet rset1				= null;

        ArrayList return_arrlist = new ArrayList();
        out = out;
		String locale = p.getProperty("LOCALE");
        try
        {
			
			 String prompt_sql = "SELECT initcap(res_area_prompt) res_area_prompt, initcap(res_town_prompt) res_town_prompt, postal_code_prompt, initcap(region_prompt) region_prompt FROM sm_site_param_LANG_VW where site_id='DS' and language_id='"+locale+"' ";

			String res_area_prompt		= "";
			String res_town_prompt		= "";
			String postal_code_prompt	= "";
			String region_prompt		= "";
			
			stmt1 = con.createStatement() ;
			rset1 = stmt1.executeQuery(prompt_sql) ;
	
			while(rset1.next())
			{
				res_area_prompt		= rset1.getString("res_area_prompt");
				System.out.println("area"+res_area_prompt);
				res_town_prompt		= rset1.getString("res_town_prompt");
				System.out.println("town"+res_area_prompt);
				postal_code_prompt	= rset1.getString("postal_code_prompt");
				System.out.println("code"+res_area_prompt);
				region_prompt		= rset1.getString("region_prompt");
				System.out.println("region_prompt"+region_prompt);
			}
         
			String addr_line1 = "<input type='text' name='r_addr_line1' id='r_addr_line1' maxlength='30' size='25' value=\"\" tabIndex='@' onBlur='makeValidString(this)'>";
            String addr_line2 = "<input type='text' name='r_addr_line2' id='r_addr_line2' maxlength='30' size='25' value=\"\" tabIndex='@'onBlur='makeValidString(this)'>";
            String addr_line3 = "<input type='text' name='r_addr_line3' id='r_addr_line3' maxlength='30' size='25' value=\"\" tabIndex='@' onBlur='makeValidString(this)'>";
            String addr_line4 = "<input type='text' name='r_addr_line4' id='r_addr_line4' maxlength='30' size='25' value=\"\" tabIndex='@' onBlur='makeValidString(this)'>";
             
			String res_town = "<input align='left' type='text' name='r_town_code' id='r_town_code'  size='20'  maxlength='40' onBlur=\"if(this.value != ''){ searchCommonCode(town_code[0],r_town_code,'"+res_town_prompt+"','"+messageFrame+"','"+locale+"')}else{clearCommonCode(r_town_code)}\" tabindex='@'><input type='button' name='town_code' id='town_code' value='?' class='button' onclick=\"searchCommonCode(this,r_town_code,'"+res_town_prompt+"','"+messageFrame+"','"+locale+"')\"  tabindex='@'>";			
			String res_area = "<input align='left' type='text' name='r_area_code' id='r_area_code'  size='27' maxlength='30' onBlur=\"if(this.value != ''){ searchCommonCode(area_code[0],r_area_code,'"+res_area_prompt+"','"+messageFrame+"','"+locale+"')} else { clearCommonCode(r_area_code)}\" tabindex='@'><input type='button' name='area_code' id='area_code' value='?' class='button' onclick=\"searchCommonCode(this,r_area_code,'"+res_area_prompt+"','"+messageFrame+"','"+locale+"')\"  tabindex='@'>";
			String region = "<input align='left' type='text' name='r_region_code' id='r_region_code'  size='27' maxlength='30' onBlur=\"if(this.value != '') {searchCommonCode(region_code[0],r_region_code,'"+region_prompt+"','"+messageFrame+"','"+locale+"')}else{clearCommonCode(r_region_code)}\" tabindex='@'><input type='button' name='region_code' id='region_code' value='?' class='button' onclick=\"searchCommonCode(this,r_region_code,'"+region_prompt+"','"+messageFrame+"','"+locale+"')\" tabindex='@'>";
           	String postal_code = "<input align='left' type='text' name='r_postal_code1' id='r_postal_code1'  size='15' maxlength='15'  onBlur=\"if(this.value != ''){ searchCommonCode(postal_code[0],r_postal_code1,'"+postal_code_prompt+"','"+messageFrame+"','"+locale+"')} else{ clearCommonCode(r_postal_code1)}\"tabindex='@'><input type='button' name='postal_code' id='postal_code' value='?' class='button' onclick=\"searchCommonCode(this,r_postal_code1,'"+postal_code_prompt+"','"+messageFrame+"','"+locale+"')\" tabindex='@'>";
            
            String[] prompts        = new String [8];
            String[] elements       = new String [8];
            String[] colnamearray	= new String [8];

            String[] elements_ord =  { "ADDR_LINE1", "ADDR_LINE2", "ADDR_LINE3", "ADDR_LINE4", "RES_TOWN", "RES_AREA", "REGION", "POSTAL_CODE" };
            String[] elements_val =  { addr_line1, addr_line2, addr_line3, addr_line4, res_town, res_area, region, postal_code };
            
            String sql = "SELECT site_id, initcap(addr_line1_prompt) addr_line1_prompt, addr_line1_order, initcap(addr_line2_prompt) addr_line2_prompt, addr_line2_order, initcap(addr_line3_prompt) addr_line3_prompt, addr_line3_order, initcap(addr_line4_prompt) addr_line4_prompt, addr_line4_order, initcap(res_area_prompt) res_area_prompt, res_area_order, initcap(res_town_prompt) res_town_prompt, res_town_order, postal_code_prompt, postal_code_order, region_prompt, region_order, addr_line1_appl_yn, addr_line2_appl_yn, addr_line3_appl_yn, addr_line4_appl_yn, res_area_appl_yn, res_town_appl_yn, region_appl_yn, postal_code_appl_yn FROM sm_site_param_LANG_VW where site_id='DS' AND language_id='"+locale+"'  ";

            stmt = con.createStatement();
            rset = stmt.executeQuery(sql);
            int tot_count = 0;
            
            if(rset != null)
            {
                if(rset.next())
                {
                    ResultSetMetaData rsmd = rset.getMetaData() ;
                    int numberOfColumns = rsmd.getColumnCount();
					String site = "";
					if ( rset.getString("site_id") != null )
						site = rset.getString("site_id");
                    return_arrlist.add(site) ;

                    for(int i=0; i<numberOfColumns; i++)
                    {
                        String columnName = rsmd.getColumnName(i+1) ;
                        
                        if(!columnName.equalsIgnoreCase("site_id"))
                        {
                            if( columnName.indexOf( "_ORDER" ) != -1)
                            {
                                String colname = (columnName.substring(0,columnName.indexOf( "_ORDER" )))+"_PROMPT" ;
								String applcolname = (columnName.substring(0,columnName.indexOf( "_ORDER" )))+"_APPL_YN" ;
								
								String appl_yn = "N";
								int ord = rset.getInt( columnName ) ;
								appl_yn = rset.getString(applcolname);
								if (appl_yn == null) appl_yn = "N";

                                if(ord!= 0 && appl_yn.equals("Y"))
                                {
                                    tot_count++ ;
                                    colnamearray[ord-1] = colname ;
                                    prompts[ord-1] = rset.getString(colname);
                                    if(prompts[ord-1] == null) prompts[ord-1] = "&nbsp;" ;

                                    for( int j=0; j<8;j++)
                                    {
                                        if( colname.indexOf(elements_ord[j]) != -1)
                                        {
                                            elements[ord-1] = elements_val[j] ;
                                            break ;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            
            String[] prompts_temp       = new String [tot_count];
            String[] elements_temp      = new String [tot_count];
            String[] colnamearray_temp	= new String [tot_count];
            tot_count = 0 ;
            for(int i=0; i<prompts.length; i++)
            {
                if(prompts[i] != null)
                {
                    prompts_temp[tot_count]      = prompts[i] ;
                    elements_temp[tot_count]     = elements[i] ;    
                    colnamearray_temp[tot_count] = colnamearray[i] ;
                    tot_count++ ;
                }
            }

            return_arrlist.add(colnamearray_temp);
            return_arrlist.add(prompts_temp);
            return_arrlist.add(elements_temp);

			if(rset != null) rset.close();
			if(rset1 != null) rset1.close();
			if(stmt != null) stmt.close();
			if(stmt1 != null) stmt1.close();
        }
		catch(Exception e)
        { }
        return return_arrlist ;
    }
%>

