function show() {
	}

function create() {
	f_query_add_mod.location.href = "../../eSM/jsp/addSiteParameter.jsp" ;
	
}

function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {
	f_query_add_mod.location.href ="../../eSM/jsp/querySiteParameter.jsp?function=siteparameter" ;
}

function apply() {	
	if(f_query_add_mod.document.siteparameter_form!=null){
		var transform = new Array (	f_query_add_mod.document.siteparameter_form,
							f_query_add_mod.document.siteparameter_form.eff_date_from,
							f_query_add_mod.document.siteparameter_form.eff_date_from1,
							f_query_add_mod.document.siteparameter_form.eff_date_to,
							f_query_add_mod.document.siteparameter_form.eff_date_to1
						   );		
		var flag=0;
				var a1= f_query_add_mod.document.siteparameter_form.addr_line1_prompt.value;
				var o1=f_query_add_mod.document.siteparameter_form.addr_line1_order.value;
				//f_query_add_mod.document.siteparameter_form.ADDR_LINE1_APPL_YN.value='Y';
				var cv1  = f_query_add_mod.document.siteparameter_form.ADDR_LINE1_APPL_YN.value;
				var c1  = f_query_add_mod.document.siteparameter_form.ADDR_LINE1_APPL_YN.checked;
											
				var a2= f_query_add_mod.document.siteparameter_form.addr_line2_prompt.value;
				var o2=f_query_add_mod.document.siteparameter_form.addr_line2_order.value;
				//f_query_add_mod.document.siteparameter_form.ADDR_LINE2_APPL_YN.value='Y';
				var cv2 = f_query_add_mod.document.siteparameter_form.ADDR_LINE2_APPL_YN.value;
				var c2 = f_query_add_mod.document.siteparameter_form.ADDR_LINE2_APPL_YN.checked;				
											

				var a3= f_query_add_mod.document.siteparameter_form.addr_line3_prompt.value;
				var o3=f_query_add_mod.document.siteparameter_form.addr_line3_order.value;
				//f_query_add_mod.document.siteparameter_form.ADDR_LINE3_APPL_YN.value='Y';
				var cv3 = f_query_add_mod.document.siteparameter_form.ADDR_LINE3_APPL_YN.value;
				var c3 = f_query_add_mod.document.siteparameter_form.ADDR_LINE3_APPL_YN.checked;
				
							

				var a4= f_query_add_mod.document.siteparameter_form.addr_line4_prompt.value;
				var o4=f_query_add_mod.document.siteparameter_form.addr_line4_order.value;
                //f_query_add_mod.document.siteparameter_form.ADDR_LINE4_APPL_YN.value='Y'
				var cv4 = f_query_add_mod.document.siteparameter_form.ADDR_LINE4_APPL_YN.value;
				var c4 = f_query_add_mod.document.siteparameter_form.ADDR_LINE4_APPL_YN.checked;
                
							
				var a5= f_query_add_mod.document.siteparameter_form.res_area_prompt.value;
				var o5=f_query_add_mod.document.siteparameter_form.res_area_order.value;
				//f_query_add_mod.document.siteparameter_form.RES_AREA_APPL_YN.value='Y'
				var cv5 = f_query_add_mod.document.siteparameter_form.RES_AREA_APPL_YN.value;
				var c5 = f_query_add_mod.document.siteparameter_form.RES_AREA_APPL_YN.checked;

				
							

				var a6= f_query_add_mod.document.siteparameter_form.res_town_prompt.value;
				var o6=f_query_add_mod.document.siteparameter_form.res_town_order.value;
				//f_query_add_mod.document.siteparameter_form.RES_TOWN_APPL_YN.value='Y'
				var cv6 = f_query_add_mod.document.siteparameter_form.RES_TOWN_APPL_YN.value;
				var c6 = f_query_add_mod.document.siteparameter_form.RES_TOWN_APPL_YN.checked;

										

				var a7= f_query_add_mod.document.siteparameter_form.REGION_PROMPT.value;
				var o7=f_query_add_mod.document.siteparameter_form.REGION_ORDER.value;
				//f_query_add_mod.document.siteparameter_form.REGION_APPL_YN.value='Y'
				var cv7 = f_query_add_mod.document.siteparameter_form.REGION_APPL_YN.value;
				var c7 = f_query_add_mod.document.siteparameter_form.REGION_APPL_YN.checked;
                					
				

				var a8= f_query_add_mod.document.siteparameter_form.postal_code_prompt.value;
				var o8=f_query_add_mod.document.siteparameter_form.postal_code_order.value;
				//f_query_add_mod.document.siteparameter_form.POSTAL_CODE_APPL_YN.value='Y'
				var cv8 = f_query_add_mod.document.siteparameter_form.POSTAL_CODE_APPL_YN.value;
				var c8 = f_query_add_mod.document.siteparameter_form.POSTAL_CODE_APPL_YN.checked;
					
				/*Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132*/
				var isGSTCodeApplicable = f_query_add_mod.document.siteparameter_form.isGSTCodeApplicable.value;
				if(isGSTCodeApplicable == "true")
				{
				var fields=new Array( f_query_add_mod.document.siteparameter_form.site_id, f_query_add_mod.document.siteparameter_form.gstin_site,
					 f_query_add_mod.document.siteparameter_form.site_name);
				
				var names=new Array(f_query_add_mod.getLabel("eSM.SiteID.label","SM"), f_query_add_mod.getLabel("Common.GoodsandServicesTaxID.label","Common"),
						f_query_add_mod.getLabel("Common.SiteName.label","Common"));
				}else
				{
				var fields=new Array( f_query_add_mod.document.siteparameter_form.site_id,
					 f_query_add_mod.document.siteparameter_form.site_name);
				
				var names=new Array(f_query_add_mod.getLabel("eSM.SiteID.label","SM"), 
						f_query_add_mod.getLabel("Common.SiteName.label","Common"));
				}
				
				if(c1)
				{
					
					if(o1 == "")
					{
						var orderline1=f_query_add_mod.getLabel("eSM.OrderofLine.label","SM")+" 1";
						var fields1 = new Array (f_query_add_mod.document.siteparameter_form.addr_line1_order);	
						var names1 = new Array (orderline1);
						fields=fields.concat(fields1);
						names=names.concat(names1);
						

					 }
					
				}
				if(c2)
				{
					if(o2 == "")
					{  ;
						var orderline2=f_query_add_mod.getLabel("eSM.OrderofLine.label","SM")+" 2";
						var fields1=new  Array(f_query_add_mod.document.siteparameter_form.addr_line2_order);
						var names1 = new Array(orderline2);
						fields=fields.concat(fields1);
						names=names.concat(names1);
								
						
					 }
					 
				}
				if(c3)
				{
					if(o3 == "")
					{
						;
						var orderline3=f_query_add_mod.getLabel("eSM.OrderofLine.label","SM")+" 3";
						var fields1 = new Array (					f_query_add_mod.document.siteparameter_form.addr_line3_order
						);	
						var names1 = new Array ( orderline3);
						fields=fields.concat(fields1);
						names=names.concat(names1);
								

					 }
				}

				if(c4)
				{
					if(o4 == "")
					{
						;
						var orderline4=f_query_add_mod.getLabel("eSM.OrderofLine.label","SM")+" 4";
						var fields1 = new Array ( 
						f_query_add_mod.document.siteparameter_form.addr_line4_order
						);	
						var names1 = new Array (orderline4);
						fields=fields.concat(fields1);
						names=names.concat(names1);

					 }
				}

				if(c5)
				{
					if(o5 == "")
					{
						;
						var fields1 = new Array (f_query_add_mod.document.siteparameter_form.res_area_order
						);	
						var names1 = new Array (f_query_add_mod.getLabel("eSM.OrderofArea.label","SM"));
						fields=fields.concat(fields1);
						names=names.concat(names1);

					 }
				}

				if(c6)
				{
					if(o6 == "")
					{
						;
						var fields1 = new Array ( 
						f_query_add_mod.document.siteparameter_form.res_town_order
						);	
						var names1 = new Array (f_query_add_mod.getLabel("eSM.OrderofTown.label","SM")   );
						fields=fields.concat(fields1);
						names=names.concat(names1);

					 }
				}

				if(c7)
				{
					if(o7 == "")
					{
						
						var fields1 = new Array (
						f_query_add_mod.document.siteparameter_form.region_order
						);	
						var names1= new Array (f_query_add_mod.getLabel("eSM.OrderofRegion.label","SM"));
						fields=fields.concat(fields1);
						names=names.concat(names1);

					 }
				}

				if(c8)
				{
					if(o8 == "")
					{
						
						var fields1 = new Array (
						f_query_add_mod.document.siteparameter_form.postal_code_order
						);	
						var names1= new Array (f_query_add_mod.getLabel("eSM.OrderofPostalCode.label","SM") );
						fields=fields.concat(fields1);
						names=names.concat(names1);

					 }
				}

	var fieldsSpl = new Array ( f_query_add_mod.document.siteparameter_form.addr_line1_order,
					f_query_add_mod.document.siteparameter_form.addr_line2_order,
					f_query_add_mod.document.siteparameter_form.addr_line3_order,
					f_query_add_mod.document.siteparameter_form.addr_line4_order,
					f_query_add_mod.document.siteparameter_form.res_area_order,
					f_query_add_mod.document.siteparameter_form.res_town_order,
					f_query_add_mod.document.siteparameter_form.postal_code_order,
		
		            f_query_add_mod.document.siteparameter_form.ADDR_LINE1_APPL_YN,
		            f_query_add_mod.document.siteparameter_form.ADDR_LINE2_APPL_YN,
		            f_query_add_mod.document.siteparameter_form.ADDR_LINE3_APPL_YN,
		            f_query_add_mod.document.siteparameter_form.ADDR_LINE4_APPL_YN,
		            f_query_add_mod.document.siteparameter_form.RES_AREA_APPL_YN,
		            f_query_add_mod.document.siteparameter_form.RES_TOWN_APPL_YN,
		            f_query_add_mod.document.siteparameter_form.REGION_APPL_YN,
		            f_query_add_mod.document.siteparameter_form.POSTAL_CODE_APPL_YN );
					
					
	var namesSpl  =  new Array ( f_query_add_mod.getLabel("Common.DisplayOrder.label","Common"),f_query_add_mod.getLabel("Common.DisplayOrder.label","Common"),f_query_add_mod.getLabel("Common.DisplayOrder.label","Common"),f_query_add_mod.getLabel("Common.DisplayOrder.label","Common"),f_query_add_mod.getLabel("Common.DisplayOrder.label","Common"),f_query_add_mod.getLabel("Common.DisplayOrder.label","Common"),f_query_add_mod.getLabel("Common.DisplayOrder.label","Common"),f_query_add_mod.getLabel("Common.DisplayOrder.label","Common")  );
var error_page = "../../eCommon/jsp/MstCodeError.jsp";

		if(f_query_add_mod.SpecialCharCheck(fieldsSpl,namesSpl,messageFrame,"M", error_page)){
			if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
				{
						//f_query_add_mod.document.siteparameter_form.change_wsid_at_facility.disabled = false;
				
					var a1=checkNumberRange();
					if(a1 == "")
					{
						if(f_query_add_mod.DateTransform(transform,messageFrame))	
						{
							var fn_status = f_query_add_mod.document.siteparameter_form.function_name.value ;
						}	
					}
					else
					{
						
						messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+a1+"&err_value=0";
						setTimeout('delay()',500);
					    if(f_query_add_mod.document.siteparameter_form.change_wsid_at_facility!=null)
						f_query_add_mod.document.siteparameter_form.change_wsid_at_facility.disabled=true;
						return false;
						
					}
					
			}
			else
			{if(f_query_add_mod.document.siteparameter_form.change_wsid_at_facility!=null)
				f_query_add_mod.document.siteparameter_form.change_wsid_at_facility.disabled=true;
			}
			setTimeout('delay()',500);
		}
 	}
else
	{
	return false;
	}
	
	
	
	
	}

function reset() {
		if(f_query_add_mod.document.forms[0].name == "siteparameter_form"){ 
		f_query_add_mod.document.location.reload();																							
		//parent.frames[1].location.href='../../servlet/eSM.SiteParameterServlet?module_id=SM&function_id=SITE_PARAMETER&function_name=Site&function_type=F&access=NYNNN';

		}
			else f_query_add_mod.document.query_form.reload() ;
}

function onSuccess(){
		f_query_add_mod.document.location.reload();
		parent.frames[1].location.href='../../servlet/eSM.SiteParameterServlet?module_id=SM&function_id=SITE_PARAMETER&function_name=Site&function_type=F&access=NYNNN';
	}

function delay()
{
		//f_query_add_mod.document.siteparameter_form.change_wsid_at_facility.disabled=true;
}



function checkNumberRange()
	{

			var o1=f_query_add_mod.document.siteparameter_form.addr_line1_order.value;
			var o2=f_query_add_mod.document.siteparameter_form.addr_line2_order.value;
			var o3=f_query_add_mod.document.siteparameter_form.addr_line3_order.value;
			var o4=f_query_add_mod.document.siteparameter_form.addr_line4_order.value;
			var o5=f_query_add_mod.document.siteparameter_form.res_area_order.value;
			var o6=f_query_add_mod.document.siteparameter_form.res_town_order.value;
			var o7=f_query_add_mod.document.siteparameter_form.postal_code_order.value;
			var o8=f_query_add_mod.document.siteparameter_form.REGION_ORDER.value;

			var errors="";
			var flag=false;
			var dup = false;
			if((o1 != "") && (o1 <1) ||(o1 >8))
			{
				flag=true;
			}
			if((o2 != "") && (o2 <1) ||(o2 >8))
			{
				flag=true;
				
			}
			
			if((o3 != "") && (o3 <1) ||(o3 >8))
			{
				flag=true;
				
			}
			if((o4 != "") && (o4 <1) ||(o4 >8))
			{
				flag=true;				
			}
			if((o5 != "") && (o5 <1) ||(o5 >8))
			{
				flag=true;				
			}
			if((o6 != "") && (o6 <1) ||(o6 >8))
			{
				flag=true;				
			}
			if((o7 != "") && (o7 <1) ||(o7 >8))
			{
				flag=true;				
			}
			if((o8 != "") && (o8 <1) ||(o8 >8))
			{
				flag=true;				
			}
			if(o1 != "")
			if((o1 == o2)||(o1==o3)||(o1==o4)||(o1==o5) ||(o1==o6)||(o1==o7))
				dup=true;
			if(o2 != "")
			if((o2 == o1)||(o2==o3)||(o2==o4)||(o2==o5) ||(o2==o6)||(o2==o7))
				dup=true;
			if(o3 !="")
			if((o3 == o1)||(o3==o2)||(o3==o4)||(o1==o5) ||(o1==o6)||(o1==o7))
				dup=true;
			if(o4 != "")
			if((o4 == o1)||(o4==o2)||(o4==o3)||(o4==o5) ||(o4==o6)||(o4==o7))
				dup=true;
			if(o5 != "")
			if((o5 == o1)||(o5==o2)||(o5==o3)||(o5==o4) ||(o5==o6)||(o1==o7))
				dup=true;
			if(o6 !="")
			if((o6 == o1)||(o6==o2)||(o6==o3)||(o6==o4) ||(o6==o5)||(o6==o7))
				dup=true;
			if(o7 !="")
			if((o7 == o1)||(o7==o2)||(o7==o3)||(o7==o4) ||(o7==o5)||(o7==o6))
				dup=true;
			if(o8 !="")
			if((o8 == o1)||(o8==o2)||(o8==o3)||(o8==o4) ||(o8==o5)||(o8==o6))
				dup=true;
			if(dup)
			{
				errors=errors+ parent.frames[0].getMessage("ORDER_ALREADY_EXISTS",'SM');
			}
			if(flag)
			{
					errors=errors+ parent.frames[0].getMessage("ORDER_BET_1_8",'SM');
			}
			return errors;
	}

function checkValues(obj){
	
	
	if(obj.checked){
		obj.value='Y';
	}else{
		obj.value='N';
	}
	
}
function fac_logo_check(){
	 if(document.forms[0].siteLogoUrl.value!=""){
        var ext = document.forms[0].siteLogoUrl.value;
        faclogourl = ext.substring(ext.length-3,ext.length);
        faclogourl = faclogourl.toLowerCase();
        if((faclogourl != 'jpg') && (faclogourl != 'gif')) {
        alert(getMessage('UPLOAD_JPG_OR_GIF_FILE','SM'));
        var elem = document.getElementById("fac_logo_id");
        elem.parentNode.innerHTML = elem.parentNode.innerHTML;

        return false;
        }
       else
       return true;
	}
	
}
function spl_char_display(obj)
	{
	if(obj.checked)
	{
	document.getElementById('spl_char_display').style.display  = '';
	document.getElementById('spl_char_legend_display').style.display  = '';
	}
	else
	{
	document.getElementById('spl_char_display').style.display  = 'none';
	document.getElementById('spl_char_legend_display').style.display  = 'none';
	}
	
	}
	
//Added by Maheshwaran for AMs-CRF-0098
function FirstLoginChangePassword(obj)
	{
	if(obj.checked)
		{
		obj.value="Y";
		document.siteparameter_form.change_password_mandatory_yn.disabled=false;
		}
	else
		{
		obj.value="N";
		document.siteparameter_form.change_password_mandatory_yn.disabled=true;
		document.siteparameter_form.change_password_mandatory_yn.value="N";
		document.siteparameter_form.change_password_mandatory_yn.checked=false;
		}
	}

/*Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132*/
function SpCharChkForSite(event)
{
	var strCheck = '0123456789abcdefghijlkmnopqrstuvwxyzABCDEFGHIJLKMNOPQRSTUVWXYZ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
} 

function ZeroChkForSite(obj2){	
	var message1 = getMessage('VALID_GSTIN',"Common");
	if(obj2.value!=""){
		if (obj2.value <= 0){
			alert(message1);
			obj2.value="";
			obj2.focus();		
		}	
	}
}
/*End AMS-CRF-0132*/

function checkRangeMaxCutoff(obj)
{
	if(obj.value!='')
	{
	  if (obj.value==0)
	  {
		  alert(getMessage('INVALID_POSITIVE_NUMBER','Common'));
		  obj.select();
	  }
    }
}
function checkUnlockSession(obj)
{ 
	if(obj.checked ==true)
	{  
		
		document.getElementById('unlock_user_hide').style.display  = 'none';
	}
	else
	{  
		
		document.getElementById('unlock_user_hide').style.display	= '';
		document.forms[0].unlock_user_session_hrs.value				= "";
	}
	
}
function chkSpltyNursUnitYN(){
		if(document.forms[0].SPL_NUR_UNIT_TO_ENABLE_YN.checked==true){
		document.forms[0].SPL_NUR_UNIT_TO_ENABLE_YN.value="Y";
	}else{
	document.forms[0].SPL_NUR_UNIT_TO_ENABLE_YN.value="N";
	}
}
//Added by Suji Keerthi for MOHE-CRF-0011 on 21-Apr-2020
function chkNatIDPractOthStaffYN(){
	if(document.forms[0].natid_mand_pract_othstaff_yn.checked==true){
	document.forms[0].natid_mand_pract_othstaff_yn.value="Y";
}else{
document.forms[0].natid_mand_pract_othstaff_yn.value="N";
}
}
//Ended for MOHE-CRF-0011

//Added by Kamatchi for ML-BRU-CRF-0594
function CheckZeroVal(obj) 
{
    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value > 0) {
        return true;
    }
    else {
        if ( obj.value.length > 0 && obj.value==0) {
            alert(getMessage("VALUE_SHOULD_BE_GR_ZERO","common"));
			obj.value='';
            obj.focus();
            return false;

        }
    }
}


function CheckNum(obj) {
    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {
        return true;
    }
    else {
        if ( obj.value.length > 0 ) {
            alert(getMessage("NUM_ALLOWED", "SM"));
            obj.value='';
            obj.focus();
            return false;
        }
    }
}
