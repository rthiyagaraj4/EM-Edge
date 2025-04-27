<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8");  %>
	<%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.*, java.util.*, java.text.*,java.sql.*, java.net.*" %>
	<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
 	<%
 		Connection conn = null;
	 	String unregisteredpatientsbkgyn= "";
	%>
	<head>
		
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		
		<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
		<Script language='javascript' src='../../eMP/js/PatientRegistration1.js'></Script>
	<script>
	// ============== Added by ranjani starts==============

	function enableAltID(){
					
				if(document.getElementById('other_alt_id').selectedIndex != 0)
				{
					document.getElementById('other_alt_Id_text').disabled = false;
				}
				else 
					document.getElementById('other_alt_Id_text').disabled = true;
			}

			 function ChangeInitCase(obj)
            {
              var name=obj.value;
              var spltval = name.split(" ") ;
              var temp_name = ""
             for(var i=0;i<spltval.length;i++)
             {
                var length= obj.value.length;
              var letter = spltval[i].substring(0,length-(length-1));
              var rest = spltval[i].substring(1,length);
              letter=letter.toUpperCase();
              rest=rest.toLowerCase();
              var  namenow= letter.concat(rest);
			  temp_name+= namenow+" ";
             }
             obj.value= temp_name.substring(0,temp_name.length-1);

            }
			function enableOtherAltIdText(val)
		{
			
			if(val != "")
			{
				document.forms[0].contact1_oth_alt_id_no.disabled= false;
			}
			else
			{
				document.forms[0].contact1_oth_alt_id_no.value="";
				document.forms[0].contact1_oth_alt_id_no.disabled= true;
			}
		}

	function populateDetail(filedname, details, addresses)
	{

	  if (details == "DECEASED"|| details == "SUSPENDED"|| details == "INACTIVE")
	  {
		alert(details);
	  }
	  else{
			
		var arr = new Array();
		arr = details.split("||");
			  
	       if (arr[0]=="NAT_ID_VALUES")
			{
				// Assign the values to the fields	
			
				document.forms[0].date_of_birth.value = arr[1];
				document.forms[0].b_age.value = arr[2];
				document.forms[0].b_months.value = arr[3];
				document.forms[0].b_days.value = arr[4];
				document.forms[0].gender_obj.value = arr[5];
				document.forms[0].gender_obj.disabled = true;
			 }
	      else
		  {
				if(document.forms[0].patient_id)
				document.forms[0].patient_id.value = arr[0];
				
				if(document.forms[0].patient_name)
				document.forms[0].patient_name.value = arr[1];
				
				if(document.forms[0].national_id_no)
				document.forms[0].national_id_no.value = arr[2];
				
				if(document.forms[0].alt_id1_no)
				document.forms[0].alt_id1_no.value = arr[3];
				
				if(document.forms[0].alt_id2_no)
				document.forms[0].alt_id2_no.value = arr[4];
				
				if(document.forms[0].alt_id3_no)
				document.forms[0].alt_id3_no.value = arr[5];
			
			if(document.forms[0].alt_id4_no)
			document.forms[0].alt_id4_no.value = arr[6];
			
			if(document.forms[0].name_prefix)
			document.forms[0].name_prefixz.value = arr[7];
			
			if(document.forms[0].first_name)
			document.forms[0].first_name.value = arr[8];
	
			if(document.forms[0].second_name)
			document.forms[0].second_name.value = arr[9];
			
			if(document.forms[0].third_name)
			document.forms[0].third_name.value = arr[10];
	
			if(document.forms[0].family_name)
			document.forms[0].family_name.value = arr[11];
	
	if(document.forms[0].name_suffix)
			document.forms[0].name_suffix.value = arr[12];

		if(document.forms[0].gender_obj)
		  {
			document.forms[0].gender_obj.value = arr[13];
		    document.forms[0].gender_obj.disabled = true;
		  }
	if(document.forms[0].b_days)
			document.forms[0].b_days.value = arr[25];
	
	if(document.forms[0].b_months)
			document.forms[0].b_months.value = arr[24];
	
	if(document.forms[0].b_age)
			document.forms[0].b_age.value = arr[23];
	
	if(document.forms[0].date_of_birth)
			document.forms[0].date_of_birth.value = arr[14];
	
	if(document.forms[0].contact1_no)
			document.forms[0].contact1_no.value = arr[15];
	
	if(document.forms[0].contact2_no)
			document.forms[0].contact2_no.value = arr[16];
	
	if(document.forms[0].email_id)
			document.forms[0].email_id.value = arr[17];
	
	if(document.forms[0].nationality)
		document.forms[0].nationality.value = arr[18];
	 
	 }
	 }
	}

	// ============== Added by ranjani ends==============

	function ChangeInitCase(obj)
	{
     var name=obj.value;
     var spltval = name.split(" ") ;
     var temp_name = ""
     for(var i=0;i<spltval.length;i++)
     {
         var length= obj.value.length;
         var letter = spltval[i].substring(0,length-(length-1));
         var rest = spltval[i].substring(1,length);
         letter=letter.toUpperCase();
         rest=rest.toLowerCase();
         var  namenow= letter.concat(rest);
	     temp_name+= namenow+" ";
     }
     obj.value= temp_name.substring(0,temp_name.length-1);
}	

function ClearValues(Objval)
{
	if(Objval == "")
	{
	document.forms[0].patient_id.readOnly = false;
	document.forms[0].Splcode_desc.readOnly = false;
	document.forms[0].alt_id1_no.readOnly = false;
	document.forms[0].date_of_birth.readOnly = false;
	document.forms[0].b_age.readOnly = false;
	document.forms[0].b_months.readOnly = false;
	document.forms[0].b_days.readOnly = false;
	document.forms[0].nationality.disabled = false;
	document.forms[0].gender_obj.disabled = false;
	document.forms[0].pref_adm_date.value = "";
	document.forms[0].Splcode.value = "";
	document.forms[0].patient_id.value = "";
	document.forms[0].Splcode_desc.value = "";
	document.forms[0].alt_id1_no.value = "";
	document.forms[0].patient_name.value = "";
	document.forms[0].date_of_birth.value = "";
	document.forms[0].b_age.value = "";
	document.forms[0].b_months.value = "";
	document.forms[0].b_days.value = "";
	document.forms[0].nationality.value = "";
	document.forms[0].gender_obj.value = "";

	if(document.forms[0].name_prefixz != null)
	{
	   document.forms[0].name_prefixz.disabled = false;
	   document.forms[0].name_prefixz.value = "";
	}

	if(document.forms[0].first_name != null)
	{
	   document.forms[0].first_name.readOnly = false;
	   document.forms[0].first_name.value = "";
	}

	if(document.forms[0].second_name != null)
	{
	   document.forms[0].second_name.readOnly = false;
	   document.forms[0].second_name.value = "";
	}

	if(document.forms[0].third_name != null)
	{
	   document.forms[0].third_name.readOnly = false;
	   document.forms[0].third_name.value = "";
	}

	if(document.forms[0].family_name != null)
	{
	   document.forms[0].family_name.readOnly = false;
	   document.forms[0].family_name.value = "";
	}

	if(document.forms[0].name_suffixz != null)
	{
	   document.forms[0].name_suffixz.disabled = false;
	   document.forms[0].name_suffixz.value = "";
	}
	}
}

function specialChar(obj,val)
{
	if(obj.value!='')
	{
		var fields1 = new Array(obj);
		var names1 = new Array(obj.name.toUpperCase());
		var messageFrame = ""; var error_page = "";
		if(SpecialCharCheck(fields1,names1,messageFrame,"A",error_page) )
		{
			if(val=="Num")
			{
				if(CheckNum(obj))
					{
						 return true;
					}
					else 
					{
						 obj.focus();
						 obj.value='';
						 return false;
					}
			}
			else if(val=="Char")
			{
				return true;
			}


			return true;
		}
		else
		{
		   obj.focus()
		   obj.value='';
		   return false;
		}
	}

}
	function OpenModel() 
	{
		
		var HTMLVal = new String();
		var HTMLVal1 = new String();
			var patid=PatientSearch('','','','','','','Y','','','OTHER');
			if( patid ==null)patid="";
			if (patid != "")document.forms[0].patient_id.value=patid;

			if(patid != "" && patid !=null) {
			HTMLVal = "<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+IeStyle.css+"'></link></head><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eIP/jsp/BookAppointmentValidations.jsp'><input name='pat_id' id='pat_id' type='hidden' value='"+escape(document.forms[0].patient_id.value)+"'><input name='Unregpatbkgyn' id='Unregpatbkgyn' type='hidden' value='"+escape(document.forms[0].unregisteredpatientsbkgyn.value)+"'>	</form></BODY></HTML>";
			parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.messageFrame.document.form1.submit();
			}
	}
		
	function validpatient(obj) 
	{
		var CA_Pat = "";
		if(document.forms[0].CA_Patient_ID.value != "")
			CA_Pat = "Y";
		else
			CA_Pat = "N";
		
		if(document.forms[0].patient_id.value !="" && document.forms[0].patient_id.value !=null)
		{	document.forms[0].checkval.value = "1";
			if(specialChar(obj,'Char')==true)
			{
				var HTMLVal = new String();
				HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eIP/jsp/BookAppointmentValidations.jsp'><input name='pat_id' id='pat_id' type='hidden' value='"+escape(document.forms[0].patient_id.value)+"'><input name='CA_Pat' id='CA_Pat' type='hidden' value='"+CA_Pat+"'><input name='Unregpatbkgyn' id='Unregpatbkgyn' type='hidden' value='"+escape(document.forms[0].unregisteredpatientsbkgyn.value)+"'></form></BODY></HTML>";
				parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
				parent.messageFrame.document.form1.submit();
				
			}
		}
		else
		{
			
			if(document.forms[0].call_function)
			{
				if(document.forms[0].call_function.value=="Revise_Booking")
				{	
					document.forms[0].patient_id.value="";
					if(document.forms[0].national_id !=null)
					{
						document.forms[0].national_id.disabled=false;
					}
					if(document.forms[0].alternate_id !=null)
					{
						document.forms[0].alternate_id.disabled=false;
					}

					if(document.forms[0].name_prefixz != null)
					{
						document.forms[0].name_prefixz.value="";
					}
				
					if(document.forms[0].first_name !=null)
					{
						document.forms[0].first_name.readOnly=false;
					}
				
					if(document.forms[0].second_name !=null)
					{
						document.forms[0].second_name.readOnly=false;
					}
					if(document.forms[0].third_name !=null)
					{
						document.forms[0].third_name.readOnly=false;
					}
					if(document.forms[0].family_name !=null)
					{
						document.forms[0].family_name.readOnly=false;
					}
					if(document.forms[0].name_suffixz !=null)
					{
						document.forms[0].name_suffixz.disabled=false;
					}
					document.forms[0].gender_obj.disabled=false;
					document.forms[0].date_of_birth.readOnly=false;
					document.forms[0].b_age.readOnly=false;
					document.forms[0].b_months.readOnly=false;
					document.forms[0].b_days.readOnly=false;
				}
			}
			else
			{
				document.forms[0].patient_id.value="";
				document.forms[0].patient_name.value="";
				
				if(document.forms[0].national_id !=null)
				{
				document.forms[0].national_id.value="";
				document.forms[0].national_id.disabled=false;
				}
				if(document.forms[0].alternate_id !=null)
				{
				document.forms[0].alternate_id.value="";
				document.forms[0].alternate_id.disabled=false;
				}

				if(document.forms[0].name_prefixz != null)
				{
				document.forms[0].name_prefixz.disabled=false;
				document.forms[0].name_prefixz.value="";
				}
				
				if(document.forms[0].first_name !=null)
				{
				document.forms[0].first_name.value="";
				document.forms[0].first_name.readOnly=false;
				}
				
				if(document.forms[0].second_name !=null)
				{
				document.forms[0].second_name.value="";
				document.forms[0].second_name.readOnly=false;
				}
				if(document.forms[0].third_name !=null)
				{
				document.forms[0].third_name.value="";
				document.forms[0].third_name.readOnly=false;
				}
				if(document.forms[0].family_name !=null)
				{
				document.forms[0].family_name.value="";
				document.forms[0].family_name.readOnly=false;
				}
				if(document.forms[0].name_suffixz !=null)
				{
				document.forms[0].name_suffixz.value="";
				document.forms[0].name_suffixz.disabled=false;
				}
				document.forms[0].gender_obj.value="";
				document.forms[0].gender_obj.disabled=false;
				
				document.forms[0].date_of_birth.value="";
				document.forms[0].date_of_birth.readOnly=false;
				
				document.forms[0].b_age.value="";
				document.forms[0].b_age.readOnly=false;
				
				document.forms[0].b_months.value="";
				document.forms[0].b_months.readOnly=false;
				
				document.forms[0].b_days.value="";
				document.forms[0].b_days.readOnly=false;
			}
		}
	}

	///////////// This function is used to validate Nationality ID////////////////	
		
function validateNationality(Nat_Id)	
	{
		var HTMLVal = new String();
			var nid = new String();
			nid = trimString(Nat_Id.value);
			Nat_Id.value = nid;
		
			if (nid.length != 0)
			{
				HTMLVal = "<html><body onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eIP/jsp/BookApptCheckForNat.jsp?step=second'><input type='hidden' name='national_id_no' id='national_id_no' value='"+escape(Nat_Id.value)+"'></form></body></html>";
				parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
				parent.messageFrame.document.form1.submit();
		
			}
			else
			{
			}
	}

	function validateExpiryDate(obj)
	{
		if(obj.value != '')
		{
		}
	}
/////////////////// This function is used to validate Alternate Id ///////////
function altid(Alt_Id) 
{
	if(specialChar(document.forms[0].alternate_id,'Char')==true)
	{
		var altid=document.forms[0].alternate_id.value;
		var HTMLVal1 = new String();
	}
	setTimeout('altidval()',2000);
}

function altidval()
{
	if(document.forms[0].alternate_id.value !="")  
	{
		if(specialChar(document.forms[0].alternate_id,'Char')==true)
		{
			if(document.forms[0].alternate_id.readOnly==false) 
			{
				document.forms[0].checkval.value = "1";
			HTMLVal1 = "<HTML><BODY onKeyDown='lockKey()'><form name='form3' id='form3' method='post' action='../../eIP/jsp/BookAppointmentValidations.jsp'><input name='alt_id' id='alt_id' type='hidden' value='"+escape(document.forms[0].alternate_id.value)+"'><input name='alt_id_prompt' id='alt_id_prompt' type='hidden' value='"+document.forms[0].Alt_Id1_Type.value+"'><input name='step' id='step' type='hidden' value='Alternate'><input name='Unregpatbkgyn' id='Unregpatbkgyn' type='hidden' value='"+escape(document.forms[0].unregisteredpatientsbkgyn.value)+"'></form></BODY></HTML>";
			parent.document.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal1);
			parent.messageFrame.document.form3.submit();
			}
		}
	}
}
/////////////// This function is used to put the values into the name field //////////

function putPatientName(from1,from)
{
	if(makeValidString(from1) == false) 
	{
		return false;
	}
	else
	{
	
	var logic = new String();
	logic = document.forms[0].name_drvn_logic.value;
	var derievedName = "";
	var logicElements = new Array();
	logicElements = logic.split('+');
	var i=0;

		for ( i=0;i<logicElements.length;i++)
		{
		if ( logicElements[i] == '1N' && document.getElementById('first_name') != null)
			{
				if ( document.forms[0].first_name.value != '' )
					derievedName = derievedName + document.forms[0].first_name.value;
			}
			else if ( logicElements[i] == '2N' && document.forms[0].second_name != null )
			{
				if ( document.forms[0].second_name.value != '' )
					derievedName = derievedName + document.forms[0].second_name.value;
			}
			else if ( logicElements[i] == '3N' && document.forms[0].third_name != null)
			{
				if ( document.forms[0].third_name.value != '' )
					derievedName = derievedName + document.forms[0].third_name.value;
			}
			else if ( logicElements[i] == 'FN' && document.forms[0].family_name != null)
			{
				if ( document.forms[0].family_name.value != '' )
					derievedName = derievedName + document.forms[0].family_name.value;
			}
			else if ( logicElements[i] == 'PR' &&  document.forms[0].name_prefixz != null)
			{
				if ( document.forms[0].name_prefixz.value != '' )
					derievedName = derievedName +document.forms[0].name_prefixz.value;
			}
			else if ( logicElements[i] == 'SF' &&  document.forms[0].name_suffixz != null)
			{
				if ( document.forms[0].name_suffixz.value != '' )
					derievedName = derievedName + document.forms[0].name_suffixz.value;
			}
			else
			{
				if ( logicElements[i] != '1N' &&  logicElements[i] != '2N' && logicElements[i] != '3N' && logicElements[i] != 'FN' && logicElements[i] != 'PR' && logicElements[i] != 'SF' )
				{
					var arLen = logicElements[i].length;
					var tempVal = logicElements[i].substring(1,arLen - 1);
					if(derievedName == "")  tempVal="";
					derievedName = derievedName + tempVal;
				}
			}
		}

	if (document.forms[0].pat_name_as_multipart_yn.value=='N')
	{
		if ( derievedName.length >= 60 )
		{
			derievedName = derievedName.substr(0,60);
		}
	}
	else
	{
		if ( derievedName.length >= 40 )
		{
			derievedName = derievedName.substr(0,40);
		}
	}
	document.forms[0].patient_name.value = derievedName;
	}
}// End of FUNCTION

////////////////// This function is used to pop up modal window for address details

 	async function show_window(Val,Val2,Val3,Val4)
	{
		
		var patid=document.forms[0].patient_id.value;
		var natid = document.forms[0].national_id_no.value;
		var altid = " ";
			if(Val =="One") 
			{
				var retVal = 	new String();
				var dialogHeight= "22" ;
				var dialogWidth	= "30" ;
				var status = "no";
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no;status:" + status;
				var arguments	= "";

				if(document.forms[0].checkval.value == "1")
				{	arguments	= Val4;   document.forms[0].checkval.value = "2";   }
				else	
					arguments	= Val3;

				var contactdetails=Val3.value;

				var url="../../eIP/jsp/BookAppointmentContact.jsp?patient_id="+escape(patid)+"&natid="+escape(natid)+"&altid="+escape(altid)+"&booking_ref_no="+escape(Val2)+"&contactdetails="+escape(contactdetails);
			retVal = await window.showModalDialog(url,arguments,features);		
				if(retVal != "")
				{
					document.forms[0].contactvals.value=retVal;	
					var contact_vals = retVal;
					var contacts = contact_vals.split("||");

						document.forms[0].restelno.value = contacts[0];
						document.forms[0].othertelno.value = contacts[1];
						document.forms[0].emailid.value = contacts[2];
						document.forms[0].postalcode.value = contacts[3];
						document.forms[0].countrycode.value = contacts[4];
						document.forms[0].resaddrline1.value = contacts[5];
						document.forms[0].resaddrline2.value = contacts[6];
						document.forms[0].resaddrline3.value = contacts[7];
						document.forms[0].resaddrline4.value = contacts[8];
				}
			}
		}

	//////////// This Function Calculates Year,Month and Days given D.O.B/////////
	function calc()
	{
	    var b_days  = document.forms[0].b_days.value;	
	    var b_months  = document.forms[0].b_months.value;
	    var b_age  = document.forms[0].b_age.value;
	    
	    var HTMLVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+IeStyle.css+"'></link></head><body class='message' onKeyDown='lockKey()'><form name='fetchvalforbooking' id='fetchvalforbooking' method='post' action='../../eIP/jsp/FetchValForBooking.jsp'><input type='hidden' name='source_type' id='source_type' value='DOB_CALC'><input type='hidden' name='b_days' id='b_days' value='"+b_days+"'><input type='hidden' name='b_months' id='b_months' value='"+b_months+"'><input type='hidden' name='b_age' id='b_age' value='"+b_age+"'></form></body></html>";
	    parent.frames[0].document.write(HTMLVal);	    
	    parent.frames[0].document.forms[0].submit();
	}		

function calci(Obj)
	{
		var hide= document.forms[0].ServerDate.value;
		strDateArray = hide.split("/");
			if (strDateArray.length != 3) ;
			else {
				strDay = strDateArray[0];
				strMonth = strDateArray[1];
				strYear = strDateArray[2];
			}
		if(Obj.name == 'b_age' || Obj.value >0)
			{
			var yy=document.forms[0].b_age.value;
			days = new Date();
			gdate = days.getDate();
			gmonth = days.getMonth();
			gyear = days.getYear(); 
			age = strYear - yy;
			document.forms[0].date_of_birth.value=strDay+"/"+strMonth+"/"+age;
			document.forms[0].text5.value=document.forms[0].date_of_birth.value;
			
			document.forms[0].text6.value=document.forms[0].date_of_birth.value;


			}
			
		if(Obj.name == 'b_months' || (document.forms[0].b_months.value >0 && document.forms[0].b_months.value <12))
		{
		if(document.forms[0].text5.value == '') document.forms[0].text5.value=document.forms[0].ServerDate.value;
		var hide1= document.forms[0].text5.value;
		var mm=document.forms[0].b_months.value;
		
		strDateArray1 = hide1.split("/");
		
				strDay1 = strDateArray1[0];
				strMonth1 = strDateArray1[1];
				strYear1 = strDateArray1[2];
		strMonth1=strMonth1-mm;
		if(strMonth1 <=0)
		{
		strMonth1=12+strMonth1;
		strYear1=strYear1-1;
		}
		
		
		if(strMonth1 == "1") strMonth1="01";
		if(strMonth1 == "2") strMonth1="02";
		if(strMonth1 == "3") strMonth1="03";
		if(strMonth1 == "4") strMonth1="04";
		if(strMonth1 == "5") strMonth1="05";
		if(strMonth1 == "6") strMonth1="06";
		if(strMonth1 == "7") strMonth1="07";
		if(strMonth1 == "8") strMonth1="08";
		if(strMonth1 == "9") strMonth1="09";

		
		if(strDay == "1") strDay="01";
		if(strDay == "2") strDay="02";
		if(strDay == "3") strDay="03";
		if(strDay == "4") strDay="04";
		if(strDay == "5") strDay="05";
		if(strDay == "6") strDay="06";
		if(strDay == "7") strDay="07";
		if(strDay == "8") strDay="08";
		if(strDay == "9") strDay="09";
		
		
		document.forms[0].date_of_birth.value=strDay+"/"+strMonth1+"/"+strYear1;
		document.forms[0].text6.value=document.forms[0].date_of_birth.value;

	
		}
		
		if(Obj.name == 'b_days' || (document.forms[0].b_days.value >0 && document.forms[0].b_days.value <32))
		{
		if(document.forms[0].text6.value == '')  document.forms[0].text6.value=document.forms[0].ServerDate.value;
		var hide2= document.forms[0].text6.value;
		var dd=document.forms[0].b_days.value;
		strDateArray2 = hide2.split("/");
		
				strDay2 = strDateArray2[0];
				strMonth2= strDateArray2[1];
				strYear2 = strDateArray2[2];


		strDay=strDay2-dd;

		if(strDay <=0)
		{
		if( strMonth2 == 1){  strMonth2=13; strYear2--; } 
		strMonth2=strMonth2-1;
		if(strMonth2 == 2)
			{
			if(leapyear(strYear2))
				{
				strDay=29+strDay+2;
				}
				else
			strDay=28+strDay;
			}
			else
			if((strMonth2 == 4) || (strMonth2 == 6) || (strMonth2 == 9) || (strMonth2 == 11))
			{
			strDay=30+strDay;
			}
			else
			{
			strDay=31+strDay-1;
			}
			}
		if(strMonth2 == "1") strMonth2="01";
		if(strMonth2 == "2") strMonth2="02";
		if(strMonth2 == "3") strMonth2="03";
		if(strMonth2 == "4") strMonth2="04";
		if(strMonth2 == "5") strMonth2="05";
		if(strMonth2 == "6") strMonth2="06";
		if(strMonth2 == "7") strMonth2="07";
		if(strMonth2 == "8") strMonth2="08";
		if(strMonth2 == "9") strMonth2="09";
		
		if(strDay == "1") strDay="01";
		if(strDay == "2") strDay="02";
		if(strDay == "3") strDay="03";
		if(strDay == "4") strDay="04";
		if(strDay == "5") strDay="05";
		if(strDay == "6") strDay="06";
		if(strDay == "7") strDay="07";
		if(strDay == "8") strDay="08";
		if(strDay == "9") strDay="09";
		document.forms[0].date_of_birth.value=strDay+"/"+strMonth2+"/"+strYear2;
		}
	}

	function leapyear(a) {
	if(((a % 4 == 0) && (a % 100 != 0)) || (a % 400 == 0))
	return true;
	else
	return false;
	}

	function CheckForNumber_L(Objval) {
			val = Objval.value;
	
		if ( trimCheck(val) && isNaN(val) == false && val >=0)
			return true;
		else
			if ( val.length > 0 ) {
			document.forms[0].date_of_birth.value='';
				alert(getMessage("NUM_ALLOWED","SM"));
				Objval.select();
				Objval.focus();
				return false;
				
			}
	}

			function calcage(obj1,obj2) {
				if(doDateCheckAlert(obj1,obj2))
				{
				if(CheckDate(obj1) == false)
				obj1.focus();
				else
				{
				if(obj1.value.length !=0)
				{
				var datecal=obj1.value;
			strDateArray = datecal.split("/");
				if (strDateArray.length != 3) ;
				else {
					strDay = strDateArray[0];
					strMonth = strDateArray[1];
					strYear = strDateArray[2];
				}
		
			    var ageYears, ageMonths, ageDays
			    var datecal2=obj2.value;
			    bornDate = new Date(strMonth+'/'+strDay+'/'+strYear);
		
			    mm = bornDate.getMonth()+1 ;
			    dd = bornDate.getDate();
			    yy = bornDate.getYear();
		
				strDateArray1 = datecal2.split("/");
						if (strDateArray.length != 3) ;
						else {
							strDay1 = strDateArray1[0];
							strMonth1 = strDateArray1[1];
							strYear1 = strDateArray1[2];
				}
		
			    testDate = new Date(strMonth1+'/'+strDay1+'/'+strYear1);
			    mm2 = testDate.getMonth()+1 ;
			    dd2 = testDate.getDate();
			    yy2 = testDate.getYear();
		
		
		
				if (yy < 100 && yy > 20) {
					        yy = yy + 1900
					        }
						if (yy2 < 100){
							if (yy2 > 20) {
								yy2 = yy2 + 1900
					        }else{
								yy2 = yy2 + 2000
					        }
					    }
		
		
			    //calcualate # of years
			    ageYears = yy2 - yy
			    //adjust years by looking at months
			    //same month, no birthday yet (add 12 months)
			    if(mm2 == mm){
					if(dd2 < dd){
						mm2 = mm2 + 12;
						ageYears = ageYears - 1;
					}
			    }
			    //earlier month (add 12 months)
			    if(mm2 < mm){
					mm2 = mm2 + 12;
					ageYears = ageYears - 1;
					ageMonths = mm2 - mm;
				}
		
				ageMonths = mm2 - mm;
		
			    //adjust months by looking at days
			    if (dd2 < dd) {
					ageMonths = ageMonths - 1;
					if((ageMonths == 4) || (ageMonths == 6) || (ageMonths == 9) || (ageMonths == 11))
					{
					//commented on 25-09-2003 by dhanasekaran (shows incorrect days when dob is 28/04/1970)
						dd2 = dd2 + 31;
					}
					else
					if(ageMonths == 2)
					{
						dd2=dd2+30;
					}
					else
					{
						dd2=dd2+30;
					}
					if (mm2 == mm) 
					 {
						ageMonths = 0;
						ageYears = ageYears - 1;
					 }
			        }
			        ageDays = dd2 - dd;
			document.forms[0].b_age.value= ageYears ;
			if((document.forms[0].b_age.value.length == 1  || document.forms[0].b_age.value.length == 2) &&  document.forms[0].b_age.value !='0' ) 	
				document.forms[0].b_age.value=ageYears ;
			else
				document.forms[0].b_age.value = document.forms[0].b_age.value.substring(2,document.forms[0].b_age.value.length)

			document.forms[0].b_months.value=ageMonths;
			document.forms[0].b_days.value=ageDays;
			}
		}
		}
		else
		{
			alert(getMessage('BIRTH_DATE_GREATER_SYSDATE','MP'));
			obj1.focus();
		}
		}
		
		function enable(Obj)
		{
		if(Obj.checked)
		{
		year.disabled=false;
		month.disabled=false;
		day.disabled=false
		text4.disabled=true;
		}
		else
		{
		year.disabled=true;
		month.disabled=true;
		day.disabled=true;
		text4.disabled=false;
		}
		}
		
		function checkMonth(Obj)
		{
		if( Obj.value  > 11) { alert(getMessage('MONTH_NOT_GR_11','MP')); Obj.focus(); document.forms[0].date_of_birth.value='';}
		}
		
		function checkDays(Obj)
		{
		if( Obj.value  > 31) { alert(getMessage('DAYS_NOT_31_CH','MP')); Obj.focus(); document.forms[0].date_of_birth.value='';}
		}

	</script>	
	</head>
 	<%
	Statement stmt=null;
	Statement stmt4=null;
	Statement stmt5=null;
	Statement stmtsd=null;
	Statement stmtlen=null;
	Statement stmt10=null;
	Statement stmt20=null;
	PreparedStatement pstmt=null;	

	ResultSet oth_rset=null;
	ResultSet rset=null;
	ResultSet rst=null;
	ResultSet rs=null;
	ResultSet rs4=null;
	ResultSet rs5=null;
	ResultSet rssd=null;
	ResultSet rslen=null;
	ResultSet rs10=null;
	ResultSet rs20=null;

 	try
	{
	String ca_patient_id = request.getParameter("ca_patient_id");
		if(ca_patient_id==null || ca_patient_id.equals("")) ca_patient_id="";
	StringBuffer sql = new StringBuffer();

	//Added on 14/03/2003
	String pat_name_as_multipart_yn = "";
	String First_Name_Accept_Yn ="";
	int First_Name_Order=0;
	String First_Name_Prompt ="";
	String Second_Name_Accept_Yn ="";
	int Second_Name_Order =0;
	String Second_Name_Prompt ="";
	String Third_Name_Accept_Yn ="";
	int Third_Name_Order =0;
	String Third_Name_Prompt ="";
	String Family_Name_Accept_Yn ="";
	int Family_Name_Order =0;
	String Family_Name_Prompt ="";
	String Name_Suffix_Accept_Yn ="";
	String Name_Suffix_Prompt ="";
	String Name_Prefix_Accept_Yn = "";
	String Name_Prefix_Prompt = "";

	String First_Name_Reqd_Yn ="";
	String Second_Name_Reqd_Yn ="";
	String Third_Name_Reqd_Yn ="";
	String Family_Name_Reqd_Yn ="";
	String Name_Suffix_Reqd_Yn ="";
	String Name_Prefix_Reqd_Yn ="";
	String Alt_Id1_Type ="";
 	String NameDrvnLogic="";
 	String facilityid=(String)session.getValue("facility_id");
	
	conn = ConnectionManager.getConnection(request);
	
	StringBuffer len_check = new StringBuffer();
	len_check.append("Select Patient_Id_Length,Nat_Id_Length,alt_id1_length from mp_param");
	stmtlen=conn.createStatement();
	rslen=stmtlen.executeQuery(len_check.toString());
	rslen.next();
	String Patient_Id_Length=rslen.getString(1);
	String Nat_Id_Length=rslen.getString(2);
	String Alt_id1_length=rslen.getString(3);
	
	String patient_grp="";
	StringBuffer sqlGroup = new StringBuffer();
	sqlGroup.append("select dflt_pat_ser_grp_type from mp_param");
	stmtlen=conn.createStatement();
	rslen=stmtlen.executeQuery(sqlGroup.toString());
	if(rslen != null) {
		rslen.next() ;
		patient_grp = rslen.getString(1);}
	else
		patient_grp = "G";

	String Site="";
	StringBuffer sqlSite = new StringBuffer();
	sqlSite.append("select site_id from sm_site_param");
	stmtlen=conn.createStatement();
	rslen=stmtlen.executeQuery(sqlSite.toString());
	if(rslen != null) {
		rslen.next() ;
		Site = rslen.getString(1);
	}
	
	
	if(Patient_Id_Length==null)	Patient_Id_Length	=	"0";
	if(Nat_Id_Length==null)		Nat_Id_Length		=	"20";
	if(Alt_id1_length==null)	Alt_id1_length		=	"0";

	int pat_id_len=Integer.parseInt(Patient_Id_Length);

	String firstname="";
	String secondname="";
	String thirdname="";
	String familyname="";
	String gender="";
	String agey="";
	String agem="";
	String aged="";
	String addrl1="";
	String addrl2="";
	String addrl3="";
	String addrl4="";
	String postal_code1="";
	String prn_tel_no="";
	String orn_tel_no="";
	String email_id="";
	String countrycode="";
 	String booking_ref_no = "";
 	String nat_id_prompt ="";
	
	String names_in_oth_lang="";
	String accept_national_id_no_yn="";
	String alt_id1_accept_oth_pat_ser_yn="";
	String alt_id1_accept_alphanumeric_yn="";
	String max_pat_age="";
	String Accept_oth_alt_id_yn="";
	String a_national_id_no="";
	String a_alt_id1_no="";
	String exe_str="";
	String AltIdNo="";
	String AltIdNo2="";
	String AltIdNo3="";
	String AltIdNo4="";

 	booking_ref_no = request.getParameter("booking_ref_no");	
	String from_revise_booking = request.getParameter("from_revise_booking");

	if(booking_ref_no == null || booking_ref_no.equals("null")) booking_ref_no = "";
	if(from_revise_booking == null || from_revise_booking.equals("null")) from_revise_booking = "";

	stmtsd=conn.createStatement();
	String sqlsd="select to_char(sysdate,'dd/mm/rrrr') from dual";
	rssd=stmtsd.executeQuery(sqlsd);
	rssd.next();
	 String str13=rssd.getString(1);

	stmt=conn.createStatement();

	sql.append("select nvl(First_Name_Accept_Yn,'N'),First_Name_Order,nvl(First_Name_Prompt,'First Name'),nvl(Second_Name_Accept_Yn,'N'),Second_Name_Order,nvl(Second_Name_Prompt,'Second Name'),nvl(Third_Name_Accept_Yn,'N'),Third_Name_Order,nvl(Third_Name_Prompt,'Third Name'),nvl(Family_Name_Accept_Yn,'N'),Family_Name_Order,nvl(Family_Name_Prompt,'Family Name'),nvl(name_suffix_accept_yn,'N'),nvl(name_prefix_accept_yn,'N'),nvl(name_suffix_prompt,'Name Suffix'),nvl(name_prefix_prompt,'Name Prefix'),nvl(first_name_reqd_yn,'N'),nvl(second_name_reqd_yn,'N'),nvl(third_name_reqd_yn,'N'),nvl(family_name_reqd_yn,'N'),nvl(name_suffix_reqd_yn,'N'),nvl(name_prefix_reqd_yn,'N'),name_dervn_logic, nvl(Alt_Id1_reqd_yn,'N'), Alt_Id1_type, nvl(Alt_Id1_length,0), nvl(Alt_Id1_Unique_yn,'N'),nvl(nat_id_prompt,''),pat_name_as_multipart_yn from mp_param ");
	 
	rs=stmt.executeQuery(sql.toString());
	rs.next();
	First_Name_Accept_Yn = rs.getString(1);
	First_Name_Order = rs.getInt(2);
	First_Name_Prompt = rs.getString(3);
	Second_Name_Accept_Yn = rs.getString(4);
	Second_Name_Order = rs.getInt(5);
	Second_Name_Prompt = rs.getString(6);
	Third_Name_Accept_Yn = rs.getString(7);
	Third_Name_Order = rs.getInt(8);
	Third_Name_Prompt = rs.getString(9);
	Family_Name_Accept_Yn = rs.getString(10);
	Family_Name_Order = rs.getInt(11);
	Family_Name_Prompt = rs.getString(12);

	Name_Suffix_Accept_Yn = rs.getString(13);
	Name_Prefix_Accept_Yn = rs.getString(14);
	Name_Suffix_Prompt = rs.getString(15);
	Name_Prefix_Prompt = rs.getString(16);

	First_Name_Reqd_Yn = rs.getString(17);
	Second_Name_Reqd_Yn = rs.getString(18);
	Third_Name_Reqd_Yn = rs.getString(19);
	Family_Name_Reqd_Yn = rs.getString(20);
	Name_Suffix_Reqd_Yn = rs.getString(21);
	Name_Prefix_Reqd_Yn = rs.getString(22);
	NameDrvnLogic=rs.getString(23);
	Alt_Id1_Type = rs.getString(25) ;
	nat_id_prompt	=   rs.getString(28);
	
	//Added on 14/03/2003
	pat_name_as_multipart_yn = rs.getString(29);
	if(pat_name_as_multipart_yn==null) pat_name_as_multipart_yn="N";

	if (nat_id_prompt==null) nat_id_prompt="National Id No";
	StringBuffer unregBkSql = new StringBuffer();
	unregBkSql.append("Select  unregistered_patients_bkg_yn from ip_param where facility_id='"+facilityid+"'");
	stmt20 = conn.createStatement();
	rs20  = stmt20.executeQuery(unregBkSql.toString());
	if(unregBkSql != null)
	{
		if(rs20.next())
		{
			unregisteredpatientsbkgyn = rs20.getString("unregistered_patients_bkg_yn");
		} 	
	}
	StringBuffer contactsql = new StringBuffer();
	contactsql.append("select patient_id,res_addr_line1, res_addr_line2, res_addr_line3, res_addr_line4,postal_code,country_code, res_tel_no,oth_contact_no,email_id from ip_booking_list_vw where bkg_lst_ref_no = ?");
	pstmt=conn.prepareStatement(contactsql.toString());
	pstmt.setString(1,booking_ref_no);
	rst=pstmt.executeQuery();
	if(rst!=null)
	 {
	  if(rst.next())
	   {
		 addrl1=rst.getString("res_addr_line1");
		 addrl2=rst.getString("res_addr_line2");
		 addrl3=rst.getString("res_addr_line3");
		 addrl4=rst.getString("res_addr_line4");
		 postal_code1=rst.getString("postal_code");
		 prn_tel_no=rst.getString("res_tel_no");
		 orn_tel_no=rst.getString("oth_contact_no");
		 email_id=rst.getString("email_id");
		 countrycode=rst.getString("country_code");	
	   }
	 }  
	
	if(addrl1==null || addrl1.equals("")) addrl1="";
	if(addrl2==null || addrl2.equals("")) addrl2="";
	if(addrl3==null || addrl3.equals("")) addrl3="";
	if(addrl4==null || addrl4.equals("")) addrl4="";
	if(postal_code1==null || postal_code1.equals("")) postal_code1="";
	if(countrycode==null || countrycode.equals("")) countrycode="";
    if(prn_tel_no==null || prn_tel_no.equals("")) prn_tel_no="";
	if(orn_tel_no==null || orn_tel_no.equals("")) orn_tel_no="";	
    if(email_id==null || email_id.equals("") || email_id.equals("null")) email_id="";
	
 if(pstmt!=null) pstmt.close();
 if(rst!=null) rst.close();
					
					
		
%>
	
	     <body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>		
	     		<input type='hidden' name='name_drvn_logic' id='name_drvn_logic' value='<%=NameDrvnLogic%>' >
	     		<input type='hidden' name='contactvals' id='contactvals' value=''>
	     		<input type='hidden' name="checkval" id="checkval" value="1">
	     		<input type='hidden' name="firstvals" id="firstvals" value="PopulateValues">

	     		<input type='hidden' name='name_prefix' id='name_prefix' value=''>
			<input type='hidden' name='name_suffix' id='name_suffix' value=''>
   			<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center' valign='top' >
				<th align='left'><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></th>
				<tr>
					
				
					<td width="100%" class="Border">
					<!-- Table starting here for patient Details -->
					<table border='0' cellpadding='0' cellspacing='0' width='100%' >
						<tr>
		    				<td align='left' class='label' width="10%"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
							<td align='left' width="15%">
							
					<%
						
						if(from_revise_booking.equals("Y"))
						{
					%>
							<input type= 'text' name='patient_id' id='patient_id' value="" size="<%=pat_id_len%>" maxlength="<%=pat_id_len%>"><input type='button' name='search' id='search' value='?'  class="BUTTON" onClick='OpenModel()' tabIndex="-1" ><img id = "patidgif" src='../../eCommon/images/mandatory.gif'align='center'></td>
					<%
						}
						else
						{
					%>
							<input type= 'text' name='patient_id' id='patient_id' value="" onChange='ClearValues(this.value);' onBlur='ChangeUpperCase(this);validpatient(this)' onKeyPress='return CheckForSpecChars(event)' size="<%=pat_id_len%>" maxlength="<%=pat_id_len%>"><input type='button' name='search' id='search' value='?'  class="BUTTON" onClick='OpenModel()' tabIndex="-1" >	<img id = "patidgif" src='../../eCommon/images/mandatory.gif'align='center'></td>
					<%
						}
					%>		
						 <td align='right' class='label' width="10%"><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
							<!-- Added on 14/03/2003 for Name field -->
							<%
								if(pat_name_as_multipart_yn.equals("N"))
								{
							%>
							<td width="35%">
								<input type='text' name='patient_name' id='patient_name' value="" maxlength='60' size='40' readonly></td>
							<%
								}
								else
								{
							%>
								<td  width="45%">
								<input type='text' name='patient_name' id='patient_name' value="" maxlength='40' size='40' readonly></td>
									<%
									
								}%>

<%
	if(sql.length() > 0) sql.delete(0,sql.length());
	sql.append(" Select nvl(Alt_Id1_reqd_yn,'N') Alt_Id1_reqd_yn, nvl(Alt_Id2_reqd_yn,'N') Alt_Id2_reqd_yn, nvl(Alt_Id3_reqd_yn,'N') Alt_Id3_reqd_yn, nvl(Alt_Id4_reqd_yn,'N') Alt_Id4_reqd_yn, Alt_Id1_type,initcap(substr(alt_id1.short_desc,1,10)) alt_id1_desc, Alt_Id2_type,initcap(substr(alt_id2.short_desc,1,10)) alt_id2_desc, Alt_Id3_type,initcap(substr(alt_id3.short_desc,1,10)) alt_id3_desc,Alt_Id4_type,initcap(substr(alt_id4.short_desc,1,10)) alt_id4_desc, nvl(First_Name_Accept_Yn,'N') First_Name_Accept_Yn, First_Name_Order, nvl(First_Name_Prompt,'First Name')First_Name_Prompt, nvl(Second_Name_Accept_Yn,'N') Second_Name_Accept_Yn, Second_Name_Order, nvl(Second_Name_Prompt,'Second Name') Second_Name_Prompt, nvl(Third_Name_Accept_Yn,'N') Third_Name_Accept_Yn,Third_Name_Order, nvl(Third_Name_Prompt,'Third Name') Third_Name_Prompt, nvl(Family_Name_Accept_Yn,'N') Family_Name_Accept_Yn,Family_Name_Order, nvl(Family_Name_Prompt,'Family Name') Family_Name_Prompt,name_dervn_logic,  nvl(Alt_Id1_length,0)Alt_Id1_length,nvl(Alt_Id2_length,0)Alt_Id2_length, nvl(Alt_Id3_length,0) Alt_Id3_length,nvl(Alt_Id4_length,0)Alt_Id4_length, nvl(name_suffix_accept_yn,'N') name_suffix_accept_yn, nvl(name_prefix_accept_yn,'N')name_prefix_accept_yn, nvl(name_suffix_prompt,'Name Suffix')name_suffix_prompt, nvl(name_prefix_prompt,'Name Prefix')name_prefix_prompt,  nvl(first_name_reqd_yn,'N')first_name_reqd_yn, nvl(second_name_reqd_yn,'N')second_name_reqd_yn, nvl(third_name_reqd_yn,'N') third_name_reqd_yn, nvl(family_name_reqd_yn,'N')family_name_reqd_yn, nvl(name_suffix_reqd_yn,'N')name_suffix_reqd_yn, nvl(name_prefix_reqd_yn,'N')name_prefix_reqd_yn, nvl(family_no_link_yn,'N') family_no_link_yn, nvl(patient_id_length,0) patient_id_length,citizen_nationality_code, nvl(Alt_Id1_Unique_yn,'N')Alt_Id1_Unique_yn, nvl(Alt_Id2_Unique_yn,'N')Alt_Id2_Unique_yn, nvl(Alt_Id3_Unique_yn,'N')Alt_Id3_Unique_yn, nvl(Alt_Id4_Unique_yn,'N')Alt_Id4_Unique_yn,  decode('"+patient_grp+"','N',nat_id_pat_ser_grp,'A',alt_id_pat_ser_grp,'G',gen_pat_ser_grp) dfltPSG, nvl(alt_id_pat_ser_grp,'') AltdfltPSG, nat_id_length , nvl(ALT_ID1_LEN_VALIDATION_YN,'N') ALT_ID1_LEN_VALIDATION_YN, nvl(ALT_ID2_LEN_VALIDATION_YN,'N') ALT_ID2_LEN_VALIDATION_YN, nvl(ALT_ID3_LEN_VALIDATION_YN,'N') ALT_ID3_LEN_VALIDATION_YN, nvl(ALT_ID4_LEN_VALIDATION_YN,'N')ALT_ID4_LEN_VALIDATION_YN, alt_id1_exp_date_accept_yn,alt_id2_exp_date_accept_yn, alt_id3_exp_date_accept_yn,alt_id4_exp_date_accept_yn, alt_id1_routine_yn,  alt_id1_data_source_id alt_id1_routine,  alt_id2_routine_yn, alt_id2_data_source_id  alt_id2_routine, alt_id3_routine_yn, alt_id3_data_source_id  alt_id3_routine, alt_id4_routine_yn, alt_id4_data_source_id  alt_id4_routine, nvl(NAT_ID_PAT_SER_GRP,'') def_nat_id_pat_ser_grp, nvl(nat_id_prompt,'National ID No') nat_id_prompt, NAMES_IN_OTH_LANG_YN,  decode(dflt_pat_ser_grp_type,'N',nat_id_pat_ser_grp,'A',alt_id_pat_ser_grp,'G',gen_pat_ser_grp) dflt_grp,  alt_id1_chk_digit_scheme,alt_id2_chk_digit_scheme,alt_id3_chk_digit_scheme,  alt_id4_chk_digit_scheme,invoke_routine,nat_data_source_id,  nvl(nat_id_check_digit_id,'')  nat_id_check_digit_id, nvl(ADDL_FIELD1_PROMPT,'')ADDL_FIELD1_PROMPT,  nvl(ADDL_FIELD1_LENGTH,'0')ADDL_FIELD1_LENGTH, nvl(ADDL_FIELD1_SECTION,'')ADDL_FIELD1_SECTION, nvl(ADDL_FIELD2_PROMPT,'')ADDL_FIELD2_PROMPT, nvl(ADDL_FIELD2_LENGTH ,'0')ADDL_FIELD2_LENGTH, nvl(ADDL_FIELD2_SECTION ,'')ADDL_FIELD2_SECTION, nvl(ADDL_FIELD3_PROMPT ,'')ADDL_FIELD3_PROMPT, nvl(ADDL_FIELD3_LENGTH ,'0')ADDL_FIELD3_LENGTH, nvl(ADDL_FIELD3_SECTION ,'')ADDL_FIELD3_SECTION, nvl(ADDL_FIELD4_PROMPT ,'')ADDL_FIELD4_PROMPT, nvl(ADDL_FIELD4_LENGTH,'0')ADDL_FIELD4_LENGTH, nvl(ADDL_FIELD4_SECTION ,'')ADDL_FIELD4_SECTION, nvl(ADDL_FIELD5_PROMPT,'')ADDL_FIELD5_PROMPT, nvl(ADDL_FIELD5_LENGTH ,'0')ADDL_FIELD5_LENGTH, nvl(ADDL_FIELD5_SECTION ,'')ADDL_FIELD5_SECTION,nvl(NAT_ID_CHK_LEN,'N')NAT_ID_CHK_LEN,  to_char(sysdate,'dd/mm/rrrr')ServerDate,to_char(sysdate,'ddmmrrrrhhmmss')photo_file_name, nvl(NAT_ID_REQD_ALL_SERIES,'N') NAT_ID_REQD_ALL_SERIES, nvl(NAME_PREFIX_LOC_LANG_PROMPT,'')NAME_PREFIX_LOC_LANG_PROMPT, nvl(FIRST_NAME_LOC_LANG_PROMPT,'')FIRST_NAME_LOC_LANG_PROMPT , nvl(SECOND_NAME_LOC_LANG_PROMPT,'')SECOND_NAME_LOC_LANG_PROMPT,  nvl(THIRD_NAME_LOC_LANG_PROMPT,'')THIRD_NAME_LOC_LANG_PROMPT, nvl(FAMILY_NAME_LOC_LANG_PROMPT,'')FAMILY_NAME_LOC_LANG_PROMPT,  nvl(NAME_SUFFIX_LOC_LANG_PROMPT,'')NAME_SUFFIX_LOC_LANG_PROMPT,accept_national_id_no_yn, alt_id1_accept_oth_pat_ser_yn,alt_id1_accept_alphanumeric_yn, max_patient_age, name_dervn_logic_oth_lang, pat_name_as_multipart_yn,Accept_oth_alt_id_yn from mp_param,mp_alternate_id_type alt_id1,mp_alternate_id_type alt_id2,mp_alternate_id_type alt_id3,mp_alternate_id_type alt_id4 where alt_id1_type=alt_id1.alt_id_type and alt_id2_type=alt_id2.alt_id_type(+) and alt_id3_type=alt_id3.alt_id_type(+) and alt_id4_type=alt_id4.alt_id_type(+) " );           
					 
					 stmt = conn.createStatement();
					 rset = stmt.executeQuery(sql.toString()) ;
					if(rset != null)
						rset.next() ;

					names_in_oth_lang = rset.getString("NAMES_IN_OTH_LANG_YN");
					if (names_in_oth_lang ==null) names_in_oth_lang = "N";
					//Added by kumar for enhancements. Additional Restrictions for Alternate id1 and //national id no. 
					accept_national_id_no_yn = rset.getString("accept_national_id_no_yn");
					alt_id1_accept_oth_pat_ser_yn = rset.getString("alt_id1_accept_oth_pat_ser_yn");
					alt_id1_accept_alphanumeric_yn = rset.getString("alt_id1_accept_alphanumeric_yn");
					
					if (accept_national_id_no_yn==null) accept_national_id_no_yn = "N";
					if (alt_id1_accept_oth_pat_ser_yn==null) alt_id1_accept_oth_pat_ser_yn = "N";
					if (alt_id1_accept_alphanumeric_yn==null) alt_id1_accept_alphanumeric_yn = "N";

					pat_name_as_multipart_yn = rset.getString("pat_name_as_multipart_yn");
					Accept_oth_alt_id_yn = rset.getString("Accept_oth_alt_id_yn");
					if(Accept_oth_alt_id_yn == null) Accept_oth_alt_id_yn = "N"; %>
	
					<%	out.println("<input type='hidden' name='accept_national_id_no' id='accept_national_id_no' value='"+accept_national_id_no_yn+"'>");
					out.println("<input type='hidden' name='alt_id1_accept_oth_pat_ser_yn' id='alt_id1_accept_oth_pat_ser_yn' value='"+alt_id1_accept_oth_pat_ser_yn+"'>");
					out.println("<input type='hidden' name='alt_id1_accept_alphanumeric_yn' id='alt_id1_accept_alphanumeric_yn' value='"+alt_id1_accept_alphanumeric_yn+"'>");
					out.println("<input type='hidden' name='max_patient_age' id='max_patient_age' value="+max_pat_age+">");
					
					if (accept_national_id_no_yn.equals("Y"))
					{						
					%>
						<td width='10%' class= 'label' align = 'left' nowrap><%= (rset.getString("nat_id_prompt") 	== null? "National ID No;":rset.getString("nat_id_prompt")) %></td>	
					<%
					}
					else
					{
					%>
						<td width='10%'></td>
					<%
					}%>

                    <td width='20%' nowrap>
                        <%                          
							if ( patient_grp.equals("N") && accept_national_id_no_yn.equals("Y"))
                            {
                                a_national_id_no = request.getParameter("nat_id") ;
                            }
							if (accept_national_id_no_yn.equals("Y"))
							{
								%>
								<input type='text' name='national_id_no' id='national_id_no' maxlength='<%= rset.getString("nat_id_length") %>' onKeyPress='return CheckForSpecChars(event)' size='20' onblur="return validateNationality(this,'<%=Site%>','<%=rset.getString("def_nat_id_pat_ser_grp")%>','<%=rset.getString("invoke_routine")%>','<%=rset.getString("nat_data_source_id")%>','<%=rset.getString("nat_id_check_digit_id")%>','<%=rset.getString("NAT_ID_CHK_LEN")%>')" value="<%=(a_national_id_no == null ? "" : a_national_id_no) %>" tabIndex='3'>
								<input type=button value='M' class= 'button' tabindex=-1><img src='../../eCommon/images/mandatory.gif' style='visibility:hidden;' name='nat_gif'></img>
								<%
								if(!a_national_id_no.equals(""))
								{							
								}
								exe_str =rset.getString("nat_id_length")+"`"+ (rset.getString("nat_id_check_digit_id")== null ?" ":rset.getString("nat_id_check_digit_id"))+"`"+rset.getString("NAT_ID_CHK_LEN") ;
								out.println("<input type='hidden' name='Nat_id_Valid_data' id='Nat_id_Valid_data' value=\""+exe_str+"\">");
								out.println("<input type='hidden' name='nat_id_reqd_all_series' id='nat_id_reqd_all_series' value=\""+rset.getString("nat_id_reqd_all_series")+"\">");
								out.println("<input type='hidden' name='nat_id_prompt' id='nat_id_prompt' value=\""+rset.getString("nat_id_prompt")+"\">");
								out.println("<input type='hidden' name='invoke_routine' id='invoke_routine' value=\""+rset.getString("invoke_routine")+"\">");
								out.println("<input type='hidden' name='nat_data_source_id' id='nat_data_source_id' value=\""+rset.getString("nat_data_source_id")+"\">");
							}
							else
							{
								out.println("<input type='hidden' name='national_id_no' id='national_id_no' value=''>");	
							}
                        %>
                    
				</td>	
                </tr>

		</table>

		<table cellspacing=0 cellpadding=0 width='100%' border=0>
				 <tr></tr><tr></tr><tr></tr><tr></tr> 
                <tr> 
                    <%if( rset.getString("alt_id1_type") != null ) {%>
                        <td class= 'label' align = 'left' width='12%'><%= (rset.getString("alt_id1_desc") == null? "":rset.getString("alt_id1_desc")) %></td>
                        <td nowrap>
                            <%
                               if ( rset.getString("Alt_Id1_Unique_Yn").equals("Y") )
                                    exe_str = "checkAlternateIdForUnique(document.forms[0].alt_id1_no,1,'"+rset.getString("alt_id1_len_validation_yn")+"','"+rset.getString("alt_id1_routine_yn")+"','"+rset.getString("alt_id1_routine")+"','"+ (rset.getString("alt_id1_chk_digit_scheme")==null?"":rset.getString("alt_id1_chk_digit_scheme"))+"')";
                                else 
                                    exe_str = "checkAltIDLength(document.forms[0].alt_id1_no,1,'"+rset.getString("alt_id1_len_validation_yn")+"','"+rset.getString("alt_id1_routine_yn")+"','"+rset.getString("alt_id1_routine")+"','"+ (rset.getString("alt_id1_chk_digit_scheme")==null?"":rset.getString("alt_id1_chk_digit_scheme"))+"','"+alt_id1_accept_alphanumeric_yn+"')";

                                out.println("<input type='text' name='alt_id1_no' id='alt_id1_no' onBlur='return makeValidString(this);' maxlength='"+rset.getString("Alt_Id1_length")+"' size='15' value=\""+a_alt_id1_no+"\" onChange=\""+exe_str+"\" tabIndex='4'>");
                                out.println("<img src='../../eCommon/images/mandatory.gif' style='visibility:hidden;' name='alt1_gif'></img>") ;
                                out.println("<input type='hidden' name='alt_id1_reqd_yn' id='alt_id1_reqd_yn' value='"+rset.getString("alt_id1_reqd_yn")+"'> ");
                                

                                if(rset.getString("alt_id1_exp_date_accept_yn").equals("Y"))  
                                {
                                    out.println("</td><td class='label' nowrap align='right'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels")+"</td>") ;
                                    out.println("<td><input type='text' name='alt_id1_exp_date' id='alt_id1_exp_date' maxlength='10' size='8' id='altidexpdate1' onblur='makeValidString(this);checkExpiryDate(this,1)' tabIndex='5' readOnly onChange=\"document.getElementById('alt_exp_date_fromHCS').value='N'\"><input type='image' src='../../eCommon/images/CommonCalendar.gif' id='altidexpdt1' disabled onClick=\"document.forms[0].alt_id1_exp_date.select();return showCalendar('altidexpdate1');\" tabindex=-1></td>");
                                }
                                else
                                out.println("<td colspan=2> </td>") ;

                                out.println("<input type='hidden' name='alt_id1_type' id='alt_id1_type' value=\""+rset.getString("Alt_Id1_Type")+"\">");
                                
                                if(patient_grp.equals("A") ||!AltIdNo.equals("") )
								{
                                }
                                exe_str = exe_str.substring(0,exe_str.indexOf("("));
                                exe_str = exe_str+"`"+rset.getString("alt_id1_len_validation_yn")+"`"+rset.getString("Alt_Id1_length")+"`"+rset.getString("alt_id1_chk_digit_scheme") ;

                                out.println("<input type='hidden' name='Alt_id1_Valid_data' id='Alt_id1_Valid_data' value=\""+exe_str+"\">");
								if(rset.getString("alt_id1_exp_date_accept_yn").equals("N"))  
                                {
									out.println("</td>") ;
								}
                            %>
                    <%}%>

                    <%if( rset.getString("alt_id2_type") != null ) {%>
                        <td class= 'label' align = 'left' width='10%'><%= (rset.getString("alt_id2_desc") == null? "":rset.getString("alt_id2_desc")) %></td>
                        <td nowrap>
                            <%
                               if ( rset.getString("Alt_Id2_Unique_Yn").equals("Y") )
                                    exe_str = "checkAlternateIdForUnique(document.forms[0].alt_id2_no,2,'"+rset.getString("alt_id2_len_validation_yn")+"','"+rset.getString("alt_id2_routine_yn")+"','"+rset.getString("alt_id2_routine")+"','"+(rset.getString("alt_id2_chk_digit_scheme") == null ?"":rset.getString("alt_id2_chk_digit_scheme"))+"')";
                                else 
                                    exe_str = "checkAltIDLength(document.forms[0].alt_id2_no,2,'"+rset.getString("alt_id2_len_validation_yn")+"','"+rset.getString("alt_id2_routine_yn")+"','"+rset.getString("alt_id2_routine")+"','"+(rset.getString("alt_id2_chk_digit_scheme") == null ?"":rset.getString("alt_id2_chk_digit_scheme"))+"')";

                                out.println("<input type='text' name='alt_id2_no' id='alt_id2_no' onBlur='return makeValidString(this);' maxlength='"+rset.getString("alt_id2_length")+"' size='15' value=\""+AltIdNo2+"\" onChange=\""+exe_str+"\" tabIndex='6'>");
                                out.println("<input type='hidden' name='alt_id2_reqd_yn' id='alt_id2_reqd_yn' value='"+rset.getString("alt_id2_reqd_yn")+"'> ");
                                if(rset.getString("alt_id2_reqd_yn").equals("Y"))
                                    out.println("<img src='../../eCommon/images/mandatory.gif'></img>") ;
                                else
                                    out.println("");

                                if(rset.getString("alt_id2_exp_date_accept_yn").equals("Y"))  
                                {
                                    out.println("</td><td class='label' nowrap align='right'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels")+"</td>") ;
                                    out.println("<td><input type='text' name='alt_id2_exp_date' id='alt_id2_exp_date' maxlength='10' size='8' id='altidexpdate2' onblur='makeValidString(this);checkExpiryDate(this,2)' tabIndex='7' readOnly><input type='image' src='../../eCommon/images/CommonCalendar.gif' id='altidexpdt2' disabled onClick=\"document.forms[0].alt_id2_exp_date.select();return showCalendar('altidexpdate2');\" tabindex=-1></td>");
                                }
                                else
                                    out.println("<td colspan=2></td>") ;
                                out.println("<input type='hidden' name='alt_id2_type' id='alt_id2_type' value=\""+rset.getString("alt_id2_Type")+"\">");

								if(!AltIdNo2.equals(""))
								{
								}

								exe_str = exe_str.substring(0,exe_str.indexOf("("));
								exe_str=exe_str+"`"+rset.getString("alt_id2_len_validation_yn")+"`"+rset.getString("Alt_Id2_length")+"`"+rset.getString("alt_id2_chk_digit_scheme") ;

                                out.println("<input type='hidden' name='Alt_id2_Valid_data' id='Alt_id2_Valid_data' value=\""+exe_str+"\">");
                                if(rset.getString("alt_id2_exp_date_accept_yn").equals("N"))  
                                {
									out.println("</td>");
								}
                            %>
                    <%}
                      else
                        out.println("<td colspan='4'></td>");
                    %>
                </tr>

                <tr>
                    <%if( rset.getString("alt_id3_type") != null ) {%>
                        <td class= 'label' align = 'left' width='10%'><%= (rset.getString("alt_id3_desc") == null? "":rset.getString("alt_id3_desc")) %></td>
                        <td nowrap>
                            <%
                               if ( rset.getString("alt_id3_Unique_Yn").equals("Y") )
                                    exe_str = "checkAlternateIdForUnique(document.forms[0].alt_id3_no,3,'"+rset.getString("alt_id3_len_validation_yn")+"','"+rset.getString("alt_id3_routine_yn")+"','"+rset.getString("alt_id3_routine")+"','"+ (rset.getString("alt_id3_chk_digit_scheme") == null?"":rset.getString("alt_id3_chk_digit_scheme"))+"')";
                                else 
                                    exe_str = "checkAltIDLength(document.forms[0].alt_id3_no,3,'"+rset.getString("alt_id3_len_validation_yn")+"','"+rset.getString("alt_id3_routine_yn")+"','"+rset.getString("alt_id3_routine")+"','"+ (rset.getString("alt_id3_chk_digit_scheme") == null?"":rset.getString("alt_id3_chk_digit_scheme"))+"')";

                                out.println("<input type='text' name='alt_id3_no' id='alt_id3_no' maxlength='"+rset.getString("alt_id3_length")+"' onBlur='return makeValidString(this);' size='15' value=\""+AltIdNo3+"\" onChange=\""+exe_str+"\" tabIndex='8'>");
                                out.println("<input type='hidden' name='alt_id3_reqd_yn' id='alt_id3_reqd_yn' value='"+rset.getString("alt_id3_reqd_yn")+"'> ");
                                if(rset.getString("alt_id3_reqd_yn").equals("Y"))
                                    out.println("<img src='../../eCommon/images/mandatory.gif'></img>") ;
                                else
                                    out.println("");

                                if(rset.getString("alt_id3_exp_date_accept_yn").equals("Y"))  
                                {
                                    out.println("</td><td class='label' nowrap align='right'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels")+"</td>") ;
                                    out.println("<td><input type='text' name='alt_id3_exp_date' id='alt_id3_exp_date' maxlength='10' size='8'  onblur='makeValidString(this);checkExpiryDate(this,3)' tabIndex='9' readOnly><input type='image' src='../../eCommon/images/CommonCalendar.gif' id='alt_id_exp_dt3' disabled onClick=\"document.forms[0].alt_id3_exp_date.select();return showCalendar('alt_id_exp_dt3');\" tabindex=-1></td>");
                                }
                                else
                                     out.println("<td colspan=2></td>") ;

                                out.println("<input type='hidden' name='alt_id3_type' id='alt_id3_type' value=\""+rset.getString("alt_id3_Type")+"\">");

								if(!AltIdNo3.equals(""))
								{
								}
								exe_str = exe_str.substring(0,exe_str.indexOf("("));
								exe_str = exe_str+"`"+rset.getString("alt_id3_len_validation_yn")+"`"+rset.getString("Alt_Id3_length")+"`"+rset.getString("alt_id3_chk_digit_scheme") ;

                                out.println("<input type='hidden' name='Alt_id3_Valid_data' id='Alt_id3_Valid_data' value=\""+exe_str+"\">");
                                if(rset.getString("alt_id3_exp_date_accept_yn").equals("N"))  
                                {
									out.println("</td>");
								}
                            %>
                    <%}
                      else
                        out.println("<td colspan='4'></td>");
                    %>

                <%if( rset.getString("alt_id4_type") != null ) {%>
                    <td class= 'label' align = 'left' width='10%'><%= (rset.getString("alt_id4_desc") == null? "":rset.getString("alt_id4_desc")) %></td>
                    <td nowrap>
                        <%
                           if ( rset.getString("alt_id4_Unique_Yn").equals("Y") )
                                exe_str = "checkAlternateIdForUnique(document.forms[0].alt_id4_no,4,'"+rset.getString("alt_id4_len_validation_yn")+"','"+rset.getString("alt_id4_routine_yn")+"','"+rset.getString("alt_id4_routine")+"','"+ (rset.getString("alt_id4_chk_digit_scheme")==null?"":rset.getString("alt_id4_chk_digit_scheme"))+"')";

                            else 
                                exe_str = "checkAltIDLength(document.forms[0].alt_id4_no,4,'"+rset.getString("alt_id4_len_validation_yn")+"','"+rset.getString("alt_id4_routine_yn")+"','"+rset.getString("alt_id4_routine")+"','"+ (rset.getString("alt_id4_chk_digit_scheme")==null?"":rset.getString("alt_id4_chk_digit_scheme"))+"')";

                            out.println("<input type='text' name='alt_id4_no' id='alt_id4_no' onBlur='return makeValidString(this);' maxlength='"+rset.getString("alt_id4_length")+"' size='15' value=\""+AltIdNo4+"\" onChange=\""+exe_str+"\" tabIndex='10'>");
                            out.println("<input type='hidden' name='alt_id4_reqd_yn' id='alt_id4_reqd_yn' value=\""+rset.getString("alt_id4_reqd_yn")+"\"> ");
                            if(rset.getString("alt_id4_reqd_yn").equals("Y"))
                                out.println("<img src='../../eCommon/images/mandatory.gif'></img>") ;
                            else
                                 out.println("");

                            if(rset.getString("alt_id4_exp_date_accept_yn").equals("Y")) 
                            {
                               out.println("</td><td class='label' nowrap align='right'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels")+"</td>") ;
                               out.println("<td><input type='text' name='alt_id4_exp_date' id='alt_id4_exp_date' maxlength='10' size='8' id='altidexpdate4' onblur='makeValidString(this);checkExpiryDate(this,4)' tabIndex='11' readOnly><input type='image' src='../../eCommon/images/CommonCalendar.gif' id='altidexpdt4' disabled onClick=\"document.forms[0].alt_id4_exp_date.select();return showCalendar('altidexpdate4');\" tabindex=-1>");
                            }
                            else
                                out.println("<td colspan=2></td>") ;
                            out.println("<input type='hidden' name='alt_id4_type' id='alt_id4_type' value=\""+rset.getString("alt_id4_Type")+"\"></td>");

							if(!AltIdNo4.equals("") ) 
							{
							}
							exe_str = exe_str.substring(0,exe_str.indexOf("("));
							exe_str=exe_str +"`"+rset.getString("alt_id4_len_validation_yn")+"`"+rset.getString("Alt_Id4_length")+"`"+rset.getString("alt_id4_chk_digit_scheme") ;

							out.println("<input type='hidden' name='Alt_id4_Valid_data' id='Alt_id4_Valid_data' value=\""+exe_str+"\">");
							if(rset.getString("alt_id4_exp_date_accept_yn").equals("N")) 
                            {
								out.println("</td>");
							}
                        %>
                  <%}
                    else
                        out.println("<td colspan='4'></td>");
                  %> 
                </tr>
					  <%
					  
				  if(Accept_oth_alt_id_yn.equals("Y")){%>
					 <tr><td class='label' nowrap align='left' width='10%' ><fmt:message key="Common.otheraltid.label" bundle="${common_labels}"/></td>
					  <td colspan=3><select onchange='enableAltID();' name='other_alt_id' id='other_alt_id'  tabindex=11>
						 <option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---
					 <%
						 if(sql.length() > 0) sql.delete(0,sql.length());
					  sql.append("select alt_id_type,substr(SHORT_DESC,1,10) SHORT_DESC from mp_alternate_id_type where alt_id_type not in (select alt_id1_type from mp_param union select nvl(alt_id2_type,1) from mp_param union select nvl(alt_id3_type,2) from mp_param union select nvl(alt_id4_type,3) from mp_param) and eff_status='E' order by 2");
						stmt = conn.createStatement();
					oth_rset = stmt.executeQuery(sql.toString());
					if(oth_rset != null){
						while (oth_rset.next()){          
							out.println ( "<Option value=\""+oth_rset.getString("alt_id_type")+"\" >"+oth_rset.getString("SHORT_DESC")+"</Option>" ) ;
						}
					}
					  
				  
					%>
						  </select><input type ='text' name = 'other_alt_Id_text' value="" size='20' maxlength='20' tabindex=12 disabled></td>
							  <td></td><td></td><td></td><td></td></tr>
							  <%}%>
							  
					 <tr></tr><tr></tr><tr></tr> 
</table>
					<!--Table Ends here for Patient Details  -->
				<table border='0' cellpadding='0' cellspacing='0' width='99%' align='center' valign='top' >
			<tr>
		<%	
		if ( Name_Prefix_Accept_Yn.equals("Y") )
			out.println("<td align='left' class='label'>"+Name_Prefix_Prompt);

		if (Name_Prefix_Reqd_Yn.equals("Y")  )
			out.println("<img name='id2' src='../../eCommon/images/mandatory.gif' align='center'></img></td>");
		else
			out.println("</td>");
		
		if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) 
		{
			out.println("<td align='left' class='label' >"+First_Name_Prompt);
			if (First_Name_Reqd_Yn.equals("Y")  )
				out.println("<img name='fid' src='../../eCommon/images/mandatory.gif' align='center'></img></td>");
			else
				out.println("</td>");
		}
		else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ) 
		{
			out.println("<td align='left' class='label' >" + Second_Name_Prompt);
			if (Second_Name_Reqd_Yn.equals("Y")  )
				out.println("<img name='sid' src='../../eCommon/images/mandatory.gif' align='center'></img></td>");
			else
				out.println("</td>");
		}
		else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 )  
		{
			out.println("<td align='left' class='label' >" + Third_Name_Prompt);
			if (Third_Name_Reqd_Yn.equals("Y")  )
				out.println("<img name='tid' src='../../eCommon/images/mandatory.gif' align='center'></img></td>");
			else
				out.println("</td>");
		}
		
		else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 ) 
		{
			out.println("<td align='left' class='label' >"+Family_Name_Prompt);
			if ( Family_Name_Reqd_Yn.equals("Y") )
				out.println("<img name='faid' src='../../eCommon/images/mandatory.gif' align='center'></img></td>");
			else
				out.println("</td>");
		}

		
		if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) 
		{
			out.println("<td align='left' class='label' >"+ First_Name_Prompt);
			if (First_Name_Reqd_Yn.equals("Y")  )
				out.println("<img name='fid' src='../../eCommon/images/mandatory.gif' align='center'></img></td>");
			else
				out.println("</td>");
		}
		else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) 
		{
			out.println("<td align='left' class='label' >" + Second_Name_Prompt);
			if (Second_Name_Reqd_Yn.equals("Y")  )
				out.println("<img name='sid' src='../../eCommon/images/mandatory.gif' align='center'></img></td>");
			else
				out.println("</td>");
		}
		else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 )  
		{
			out.println("<td align='left' class='label' >" + Third_Name_Prompt);
			if (Third_Name_Reqd_Yn.equals("Y")  )
				out.println("<img name='tid' src='../../eCommon/images/mandatory.gif' align='center'></img></td>");
			else
				out.println("</td>");
		}
		else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 ) 
		{
			out.println("<td align='left' class='label' >"+Family_Name_Prompt);
			if ( Family_Name_Reqd_Yn.equals("Y") )
				out.println("<img name='faid' src='../../eCommon/images/mandatory.gif' align='center'></img></td>");
			else
				out.println("</td>");
		}
		

		if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 ) 
		{
			out.println("<td align='left' class='label' >"+ First_Name_Prompt);
			if (First_Name_Reqd_Yn.equals("Y")  )
				out.println("<img name='fid' src='../../eCommon/images/mandatory.gif' align='center'></img></td>");
			else
				out.println("</td>");
		}
		else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 ) 
		{
			out.println("<td align='left' class='label' >" + Second_Name_Prompt);
			if (Second_Name_Reqd_Yn.equals("Y")  )
				out.println("<img name='sid' src='../../eCommon/images/mandatory.gif' align='center'></img></td>");
			else
				out.println("</td>");
		}
		else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3 )  
		{
			out.println("<td align='left' class='label' >" + Third_Name_Prompt);
			if (Third_Name_Reqd_Yn.equals("Y")  )
				out.println("<img name='tid' src='../../eCommon/images/mandatory.gif' align='center'></img></td>");
			else
				out.println("</td>");
		}
		else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 ) 
		{
			out.println("<td align='left' class='label' >"+Family_Name_Prompt);
			if ( Family_Name_Reqd_Yn.equals("Y") )
				out.println("<img name='faid' src='../../eCommon/images/mandatory.gif' align='center'></img></td>");
			else
				out.println("</td>");
		}

		
		if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) 
		{
			out.println("<td align='left' class='label' >"+ First_Name_Prompt);
			if (First_Name_Reqd_Yn.equals("Y")  )
				out.println("<img name='fid' src='../../eCommon/images/mandatory.gif' align='center'></img></td>");
			else
				out.println("</td>");
		}
		else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 ) 
		{
			out.println("<td align='left' class='label' >" + Second_Name_Prompt);
			if (Second_Name_Reqd_Yn.equals("Y")  )
				out.println("<img name='sid' src='../../eCommon/images/mandatory.gif' align='center'></img></td>");
			else
				out.println("</td>");
		}
		else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 )  
		{
			out.println("<td align='left' class='label' >" + Third_Name_Prompt);
			if (Third_Name_Reqd_Yn.equals("Y")  )
				out.println("<img name='tid' src='../../eCommon/images/mandatory.gif' align='center'></img></td>");
			else
				out.println("</td>");
		}
		else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4 ) 
		{
			out.println("<td align='left' class='label' >"+Family_Name_Prompt);
			if ( Family_Name_Reqd_Yn.equals("Y") )
				out.println("<img name='faid' src='../../eCommon/images/mandatory.gif' align='center'></img></td>");
			else
				out.println("</td>");
		}
		
		if ( Name_Suffix_Accept_Yn.equals("Y") )
			out.println("<td align='left' class='label' >"+Name_Suffix_Prompt);

		if (Name_Suffix_Reqd_Yn.equals("Y")  )
			out.println("<img name='id1' src='../../eCommon/images/mandatory.gif' align='center'></img></td>");
		else
			out.println("</td>");
		
		%>
		</tr>
		<tr>
		<!-- Added on 14/03/2003 for Prifix select box -->
		<%
		if ( Name_Prefix_Accept_Yn.equals("Y") )
		{
			//Added on 14/03/2003
			out.println("<td align='left'>") ;
			if (pat_name_as_multipart_yn.equals("N"))
			{
				out.println("<select onchange='putPatientName(this);' name='name_prefixz' id='name_prefixz'  style='width: 200px'>") ; }
			else
			{	out.println("<select onchange='putPatientName(this);' name='name_prefixz' id='name_prefixz'  style='width: 90px'>") ;
			}
			//End of Addtion on 14/03/2003

			out.println("<Option value=''>&nbsp--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"&nbsp---</option>");
			stmt4=conn.createStatement();
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append("Select Name_Prefix from Mp_Name_Prefix where eff_status='E' and trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) order by 1");
			rs4 = stmt4.executeQuery(sql.toString());
				while( rs4.next() ) {
					String a=rs4.getString("Name_Prefix");

				%>
					<Option value="<%=a%>" > <%=rs4.getString("Name_Prefix")%>
				<%
				}
		
			if (Name_Prefix_Reqd_Yn.equals("Y")  )
			{
				out.println("</select><input type='hidden' name='name_prefix_reqd_yn' id='name_prefix_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("</select><input type='hidden' name='name_prefix_reqd_yn' id='name_prefix_reqd_yn' value='N'></input>");
			}
			
			if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==0 ) {
				out.println("<input type='hidden' name='first_name' id='first_name' size='15' maxlength='20'>");
			}
			else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==0 ) {
				out.println("<input type='hidden' name='second_name' id='second_name' size='15' maxlength='20'>");
			}
			else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==0 ) {
				out.println("<input type='hidden' name='third_name' id='third_name' size='15' maxlength='20'>");
			}
			else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==0 ) {
				out.println("<input type='hidden' name='family_name' id='family_name' size='15' maxlength='20'>");
			}
		
		out.println("</td>");
		}
		// Ended on 14/03/2003 for Prifix select box
	
		if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 )
		{
				out.println("<td align='left' nowrap><input type='text' name='first_name' id='first_name' maxlength='20' size='15' value='"+firstname+"'  onBlur=putPatientName(this,'firstname') >");
		
			if (First_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='N'></input>");
			}
			out.println("</td>");
		}
		else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 )
		{
			out.println("<td align='left' nowrap><input type='text' name='second_name' id='second_name' maxlength='20' size='15' value='"+secondname+"' onBlur=putPatientName(this,'secondname') >");
		
			if (Second_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='N'></input>");
			}
		
			out.println("</td>");
		}
		else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 )
		{
			out.println("<td align='left' nowrap><input type='text' name='third_name' id='third_name' maxlength='20' size='15' value='"+thirdname+"'  onBlur=putPatientName(this,'thirdname') >");
		
		
			if (Third_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='N'></input>");
			}
		
			out.println("</td>");
		}
		//Added on 14/03/2003 for Family Name
		else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 )
		{
			
			//Added on 14/03/2003 for Family name
			if(pat_name_as_multipart_yn.equals("N"))
			{
				out.println("<td align='left' nowrap><input type='text' name='family_name' id='family_name' maxlength='40' size='40' value='"+familyname+"'  onBlur=makeValidString(this);ChangeInitCase(this);putPatientName(this,'familyname') >");

			}
			else
			{	
				out.println("<td align='left' nowrap><input type='text' name='family_name' id='family_name' maxlength='15' size='15' value='"+familyname+"'  onBlur=makeValidString(this);ChangeInitCase(this);putPatientName(this,'familyname') >");			
			
			}
			//End of 14/03/2003

			if ( Family_Name_Reqd_Yn.equals("Y") )
			{
				out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='N'></input>");
			}
		
			out.println("</td>");
		}
		//Ended on 14/03/2003 for Family Name
		
		if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 )
		{
			out.println("<td align='left' nowrap><input type='text' name='first_name' id='first_name' maxlength='20' size='15' value='"+firstname+"' onBlur=putPatientName(this,'firstname') >");
		
			if (First_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='N'></input>");
			}
			out.println("</td>");
		}
		else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 )
		{
			out.println("<td align='left' nowrap><input type='text' name='second_name' id='second_name' maxlength='20' size='15' value='"+secondname+"'  onBlur=putPatientName(this,'secondname') >");
		
			if (Second_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='N'></input>");
			}
			out.println("</td>");
		}
		else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 )
		{
			out.println("<td align='left' nowrap><input type='text' name='third_name' id='third_name' maxlength='20' size='15' value='"+thirdname+"' onBlur=putPatientName(this,'thirdname') >");
		
			if (Third_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='N'></input>");
			}
		
		
			out.println("</td>");
		}
		else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 )
		{
			//Added on 14/03/2003 for Family name
			if(pat_name_as_multipart_yn.equals("N"))
			{
				out.println("<td align='left' nowrap><input type='text' name='family_name' id='family_name' maxlength='40' size='40' value='"+familyname+"'  onBlur=makeValidString(this);ChangeInitCase(this);putPatientName(this,'familyname') >");

			}
			else
			{	
				out.println("<td align='left' nowrap><input type='text' name='family_name' id='family_name' maxlength='15' size='15' value='"+familyname+"'  onBlur=makeValidString(this);ChangeInitCase(this);putPatientName(this,'familyname') >");			
			
			}
			//End of 14/03/2003
		
			if (Family_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='N'></input>");
			}
			out.println("</td>");
		}
		
		if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 )
		{
			out.println("<td align='left' nowrap><input type='text' name='first_name' id='first_name' maxlength='20' size='15' value='"+firstname+"'  onBlur=putPatientName(this,'firstname') >");
		
			if (First_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='N'></input>");
			}
		
			out.println("</td>");
		}
		else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 )
		{
			out.println("<td align='left' nowrap><input type='text' name='second_name' id='second_name' maxlength='20' size='15' value='"+secondname+"'  onBlur=putPatientName(this,'secondname') >");
		
			if (Second_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='N'></input>");
			}
			out.println("</td>");
		}
		else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3 )
		{
			out.println("<td align='left' nowrap><input type='text' name='third_name' id='third_name' maxlength='20' size='15' value='"+thirdname+"'  onBlur=putPatientName(this,'thirdname') >");
		
			if (Third_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='N'></input>");
			}
		
		
			out.println("</td>");
		}
		else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 )
		{
			//Added on 14/03/2003 for Family name
			if(pat_name_as_multipart_yn.equals("N"))
			{
				out.println("<td align='left' nowrap><input type='text' name='family_name' id='family_name' maxlength='40' size='40' value='"+familyname+"'  onBlur=makeValidString(this);ChangeInitCase(this);putPatientName(this,'familyname') >");

			}
			else
			{	
				out.println("<td align='left' nowrap><input type='text' name='family_name' id='family_name' maxlength='15' size='15' value='"+familyname+"'  onBlur=makeValidString(this);ChangeInitCase(this);putPatientName(this,'familyname') >");			
			
			}
			//End of 14/03/2003
			
			if (Family_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='N'></input>");
			}
			out.println("</td>");
		}
		
		if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 )
		{
			out.println("<td align='left' nowrap><input type='text' name='first_name' id='first_name' maxlength='20' size='15' value='"+firstname+"'  onBlur=putPatientName(this,'firstname') >");
		
			if (First_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='N'></input>");
			}
			out.println("</td>");
		}
		else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 )
		{
			out.println("<td align='left' nowrap><input type='text' name='second_name' id='second_name' maxlength='20' size='15' value='"+secondname+"'  onBlur=putPatientName(this,'secondname') >");
		
			if (Second_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='N'></input>");
			}
		
		
			out.println("</td>");
		}
		else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 )
		{
			out.println("<td align='left' nowrap><input type='text' name='third_name' id='third_name' maxlength='20' size='15' value='"+thirdname+"'  onBlur=putPatientName(this,'thirdname') >");
		
			if (Third_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='N'></input>");
			}
		
			out.println("</td>");
		}
		else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4 )
		{
			//Added on 14/03/2003 for Family name
			if(pat_name_as_multipart_yn.equals("N"))
			{
				out.println("<td align='left' nowrap><input type='text' name='family_name' id='family_name' maxlength='40' size='40' value='"+familyname+"'  onBlur=makeValidString(this);ChangeInitCase(this);putPatientName(this,'familyname') >");

			}
			else
			{	
				out.println("<td align='left' nowrap><input type='text' name='family_name' id='family_name' maxlength='15' size='15' value='"+familyname+"'  onBlur=makeValidString(this);ChangeInitCase(this);putPatientName(this,'familyname') >");			
			
			}
			//End of 14/03/2003
			
			if (Family_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='N'></input>");
			}
			out.println("</td>");
		}
		
		if ( Name_Suffix_Accept_Yn.equals("Y") )
		{
			out.println("<td align='left' nowrap><select name='name_suffixz' id='name_suffixz' onChange=putPatientName(this,'namesuffix')>");
			out.println("<Option value=''>---&nbsp"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"&nbsp---</option>");
			stmt5=conn.createStatement();
			sql.append("Select Name_Suffix from Mp_Name_Suffix where eff_status='E' and trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) order by 1");
			rs5 = stmt5.executeQuery(sql.toString());
			if(rs5 != null ) {
				while(rs5.next()) {
					String b=rs5.getString("name_suffix");
					%>
					<option value="<%= b %>" > <%=b%>
		
					<%
				}
			}
		
			if (Name_Suffix_Reqd_Yn.equals("Y")  )
			{
				out.println("</select><input type='hidden' name='name_suffix_reqd_yn' id='name_suffix_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("</select><input type='hidden' name='name_suffix_reqd_yn' id='name_suffix_reqd_yn' value='N'></input>");
			}
		
			out.println("</td>");
		}
		
%>	    										</tr>
	</table>
	<table border='0' cellpadding='0' cellspacing='0' width='100%'>
			<tr>
				<td align="left" class="label" width='15%'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
				<td align='left' class='label' width='20%'> <fmt:message key="Common.age.label" bundle="${common_labels}"/> </td>
				<td align='left' class='label' width='15%'><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></td>
				<td align='left' class='label' width='30%'><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>
				<td align='left' class='label' width='20%' ></td>
			</tr>
			
			<tr>
				<td align='left' width='15%' ><select name='gender_obj' id='gender_obj' >
			<%
			if(gender.equals("M")) {%>
										<option value=''>---&nbsp<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp--- 
									   <option value='M' selected><fmt:message key="Common.male.label" bundle="${common_labels}"/>
									   <option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/>
									   <option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/>
			<% } else if(gender.equals("F")) {%>
										<option value=''>---&nbsp<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp--- 
									   <option value='M' ><fmt:message key="Common.male.label" bundle="${common_labels}"/>
									   <option value='F' selected><fmt:message key="Common.female.label" bundle="${common_labels}"/>
									   <option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/>
			<% } else if(gender.equals("U")) {%>
										<option value=''>---&nbsp<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp---
										<option value='M' ><fmt:message key="Common.male.label" bundle="${common_labels}"/>
										<option value='F' ><fmt:message key="Common.female.label" bundle="${common_labels}"/>
									   <option value='U' selected><fmt:message key="Common.unknown.label" bundle="${common_labels}"/>
			<% } else if(gender.equals("") || gender==null) {%>
					<option value='' selected>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--- 
										<option value='M' ><fmt:message key="Common.male.label" bundle="${common_labels}"/>
										<option value='F' ><fmt:message key="Common.female.label" bundle="${common_labels}"/>
									   <option value='U' ><fmt:message key="Common.unknown.label" bundle="${common_labels}"/>
			<%}%>
					     </select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
			</td>
			<td align='left' width='20%' class='data' nowrap><input type="text" name="b_age" id="b_age" maxlength="3" size="2" value='<%=agey%>'   onChange='calci(this)' onBlur='CheckForNumber_L(this);' onKeyPress='return(ChkNumberInput(this,event,0))'>Y
				<input type="text"  name="b_months" id="b_months" maxlength="2" value='<%=agem%>' size="1"   onChange='calci(this)' onBlur='CheckForNumber_L(this);checkMonth(this)' onKeyPress='return(ChkNumberInput(this,event,0))'  >M
				<input type="text" name="b_days" id="b_days" maxlength="2" size="1" value='<%=aged%>'   onChange='calci(this)' onBlur='CheckForNumber_L(this);checkDays(this)'  onKeyPress='return(ChkNumberInput(this,event,0))'>D
			</td>
			<td align='left' width='15%' >
				<input type='hidden' name='ServerDate' id='ServerDate' value='<%=str13%>'>
				<input type="text" id = "dateofbirth" name="date_of_birth" id="date_of_birth" maxlength="10" size="10"  value='' onblur='calcage(this,ServerDate)' ><input type='image' name= "dob" src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].date_of_birth.select();return showCalendar('dateofbirth');"><img src='../../eCommon/images/mandatory.gif'align='center'>
				<input type='hidden' name='ServerTime' id='ServerTime' value=''>
				<input type='hidden' name='gen' id='gen' value=''>
			</td>
			<td align='left' width='30%' ><SELECT name='nationality' id='nationality'>
					<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%					

			String sql2 = "Select country_code,long_desc from mp_country where eff_status = 'E' order by long_desc";					
					out.println(sql2);
					stmt10= conn.createStatement();
					rs10 = stmt10.executeQuery(sql2);
					if( rs10 != null )
					 {
						while( rs10.next() )
						{
							String nationality   = rs10.getString(1) ;
							String natname = rs10.getString(2) ;
%>								<OPTION VALUE="<%= nationality %>" ><%= natname %>
<%			  			}
					 }
					
%>		
	</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
				</SELECT>	
			</td>
			 <td align='left' width='20%'><input type='button' name='ContactDetails' id='ContactDetails' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.MailingAddress.label","common_labels")%>' onClick="show_window('One','<%=booking_ref_no%>',contactvals,firstvals)" class="BUTTON" >
			</td>
		</tr>
		</table>
		</td>
		</tr>
		</table>
</td>
</tr>
</table>
<input type='hidden' name='First_Name_Prompt' id='First_Name_Prompt' value="<%=First_Name_Prompt%>">
<input type='hidden' name='Second_Name_Prompt' id='Second_Name_Prompt' value="<%=Second_Name_Prompt%>">
<input type='hidden' name='Third_Name_Prompt' id='Third_Name_Prompt' value="<%=Third_Name_Prompt%>">
<input type='hidden' name='Family_Name_Prompt' id='Family_Name_Prompt' value="<%=Family_Name_Prompt%>">
<input type='hidden' name='Name_Suffix_Prompt' id='Name_Suffix_Prompt' value="<%=Name_Suffix_Prompt%>">
<input type='hidden' name='Name_Prefix_Prompt' id='Name_Prefix_Prompt' value="<%=Name_Prefix_Prompt%>">
<input type='hidden' name='CA_Patient_ID' id='CA_Patient_ID' value="<%=ca_patient_id%>">
<input type='hidden' name='Alt_Id1_Type' id='Alt_Id1_Type' value="<%=Alt_Id1_Type%>">

<input type='hidden' name='restelno' id='restelno' value="<%=prn_tel_no%>">
<input type='hidden' name='othertelno' id='othertelno' value="<%=orn_tel_no%>">
<input type='hidden' name='emailid' id='emailid' value="<%=email_id%>">
<input type='hidden' name='postalcode' id='postalcode' value="<%=postal_code1%>">
<input type='hidden' name='countrycode' id='countrycode' value="<%=countrycode%>">
<input type='hidden' name='resaddrline1' id='resaddrline1' value="<%=addrl1%>">
<input type='hidden' name='resaddrline2' id='resaddrline2' value="<%=addrl2%>">
<input type='hidden' name='resaddrline3' id='resaddrline3' value="<%=addrl3%>">
<input type='hidden' name='resaddrline4' id='resaddrline4' value="<%=addrl4%>">
<input type='hidden' name='pat_name_as_multipart_yn' id='pat_name_as_multipart_yn' value = "<%=pat_name_as_multipart_yn%>"> 

<!--- added on 26-09-2003 by dhanasekaran --->
<input type='hidden' name='unregisteredpatientsbkgyn' id='unregisteredpatientsbkgyn' value="<%=unregisteredpatientsbkgyn%>"> 
<!--- end addition --->

</body>
<script>
	
	if("<%=ca_patient_id%>"!='')
	{
	   document.forms[0].patient_id.value = "<%=ca_patient_id%>";
	   document.forms[0].patient_id.readOnly=true;
	   document.forms[0].search.disabled=true;
	   validpatient(document.forms[0].patient_id);
	}
	var unregisteredpatientsbkgyn = '<%=unregisteredpatientsbkgyn%>';
	setTimeout('calcage(document.forms[0].date_of_birth,document.forms[0].ServerDate)',1000);

document.forms[0].contactvals.value	+=	'<%=prn_tel_no%>' +"||";
document.forms[0].contactvals.value +=	'<%=orn_tel_no%>' +"||";
document.forms[0].contactvals.value +=	'<%=email_id%>' +"||";
document.forms[0].contactvals.value +=	'<%=postal_code1%>' +"||";
document.forms[0].contactvals.value +=	'<%=countrycode%>' +"||";
document.forms[0].contactvals.value +=	'<%=addrl1%>' +"||";
document.forms[0].contactvals.value +=	'<%=addrl2%>' +"||";
document.forms[0].contactvals.value +=	'<%=addrl3%>' +"||";
document.forms[0].contactvals.value +=	'<%=addrl4%>';

</script>	

<%
	if(stmt!=null) stmt.close();
	if(stmt4!=null) stmt4.close();
	if(stmt5!=null) stmt5.close();

	if(stmtsd!=null) stmtsd.close();
	if(stmtlen!=null) stmtlen.close();
	if(rst!=null) rst.close();
	if(rs!=null) rs.close();
	if(rs4!=null) rs4.close();
	if(rs5!=null) rs5.close();
	if(rssd!=null) rssd.close();
	if(rslen!=null) rslen.close();
	if(rs10!=null) rs10.close();
	if(stmt10!=null) stmt10.close();
	if(rs20 != null) rs20.close();
	if(stmt20 != null) stmt20.close();

} catch(Exception e ){out.println("Exception@1: "+e);
}finally
{
	ConnectionManager.returnConnection(conn,request);
}%>
<input type='hidden' name='text5' id='text5' value=''>
<input type='hidden' name='text6' id='text6' value=''>
<input type='hidden' name='gifval' id='gifval' value=N>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

