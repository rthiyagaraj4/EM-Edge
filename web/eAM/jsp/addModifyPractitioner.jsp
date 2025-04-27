<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 <%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.*,java.sql.*,java.io.*, java.util.*, java.text.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
 <%request.setCharacterEncoding("UTF-8");
 //MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	%>
 <head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
        <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
      	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script src='../../eAM/js/Practitioner.js' language='javascript'></script>
		<script src='../../eAM/js/ExternalPractitioner.js' language='javascript'></script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>
		<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
		<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
		<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script>
		
      	<script>
		var isShift = false;

	function tab_click2(id){
			selectTab(id);
			objClick(id);
	}

	function setShift(){
		var keyCode=window.event.keyCode;
		if(keyCode == 16) isShift=true;
	}

	function shift_tab(){
		
		var keyCode=window.event.keyCode;
		if(keyCode == 9 && isShift == true){
		parent.frames[1].document.practitioner1_form.b_age.focus();
	
		}
		
	}
	
    function shift_tab2(){		
		var keyCode=window.event.keyCode;		
		if(keyCode == 9 && isShift == true){
		parent.frames[1].document.practitioner1_form.offtelno.focus();
	//alert(parent.frames[1].document.getElementById("rtno").tabIndex);
		}	
	}

    function shift_tab3(){	
		var keyCode=window.event.keyCode;
		if(keyCode == 9 && isShift == true){
			parent.frames[1].document.practitioner1_form.year1.focus();
		}        
    }

    function shift_tab4(){	
		var keyCode=window.event.keyCode;
		if(keyCode == 9 && isShift == true){
        parent.frames[1].document.practitioner1_form.marital_status1.focus();
		}
		
	}	
			
			var currentLink = new String();
			currentLink = "identity_link";
			function changeToextn(obj)
			{
				if(obj.checked==true)
				{
					 parent.parent.frames[1].frames[1].location.href="../../eAM/jsp/addModifyPractitioner.jsp?fcall=call&function_id=EXT_PRACT";	
				}
			    else
			    {
					parent.parent.frames[1].frames[1].location.href="../../eAM/jsp/addModifyPractitioner.jsp?fcall=call&function_id=PRACTITIONER";
			
				}
			}
			function enabledata(obj)
			{
			if(obj.name=="degree1" )
			{		
			if(obj.value!="")
			{
			parent.frames[1].document.practitioner1_form.year1.readOnly=false;
			parent.frames[1].document.practitioner1_form.univ1.readOnly=false;
			
			}	
			else
			{
			parent.frames[1].document.practitioner1_form.year1.value="";
			parent.frames[1].document.practitioner1_form.year1.readOnly=true;
			parent.frames[1].document.practitioner1_form.univ1.value="";
			parent.frames[1].document.practitioner1_form.univ1.readOnly=true;
           	
			//obj.focus();
			}
			}
				
			
			if(obj.name=="degree2" )
			{		
			if(obj.value!="")
			{
			parent.frames[1].document.practitioner1_form.year2.readOnly=false;
			parent.frames[1].document.practitioner1_form.univ2.readOnly=false;
			
			}	
			else
			{
           	parent.frames[1].document.practitioner1_form.year2.value="";
				parent.frames[1].document.practitioner1_form.year2.readOnly=true;
			parent.frames[1].document.practitioner1_form.univ2.value="";
		   
			parent.frames[1].document.practitioner1_form.univ2.readOnly=true;
		//	obj.focus();
		
			}
			}

			if(obj.name=="degree3" )
			{		
			if(obj.value!="")
			{
			parent.frames[1].document.practitioner1_form.year3.readOnly=false;
			parent.frames[1].document.practitioner1_form.univ3.readOnly=false;
			
			}	
			else
			{
			parent.frames[1].document.practitioner1_form.year3.value="";
			parent.frames[1].document.practitioner1_form.year3.readOnly=true;
			parent.frames[1].document.practitioner1_form.univ3.value="";
		    parent.frames[1].document.practitioner1_form.univ3.readOnly=true;
			//obj.focus();
		
			}
			}


          if(obj.name=="degree4" )
			{		
			if(obj.value!="")
			{
			parent.frames[1].document.practitioner1_form.year4.readOnly=false;
			parent.frames[1].document.practitioner1_form.univ4.readOnly=false;
			
			}	
			else
			{
			parent.frames[1].document.practitioner1_form.year4.value="";
			parent.frames[1].document.practitioner1_form.year4.readOnly=true;
			parent.frames[1].document.practitioner1_form.univ4.value="";
			parent.frames[1].document.practitioner1_form.univ4.readOnly=true;
		   
		//	obj.focus();
		
			}
			}

			
			
			
			
			}
			function chkyear1(year1)
			{
				var curyear = new Date();
				var curyear1 =  curyear.getFullYear();
					if(year1.value > curyear1)
				{
				//alert('APP-AM0024 Year of Passing cannot be greater than current Year');
				alert(getMessage("AM0164","AM"));
					year1.value = "";
					year1.focus();
				}
			}

		function chkyear2(year2)
			{
				var curyear = new Date();
				var curyear2 =  curyear.getFullYear();
					if(year2.value > curyear2)
				{
				//alert('APP-AM0024 Year of Passing cannot be greater than current Year');
				alert(getMessage("AM0164","AM"));
				year2.value = "";
					year2.focus();
				}
			}

			function chkyear3(year3)
			{
				var curyear = new Date();
				var curyear3 =  curyear.getFullYear();
					if(year3.value > curyear3)
				{
				//alert('APP-AM0024 Year of Passing cannot be greater than current Year');
				alert(getMessage("AM0164","AM"));
				year3.value = "";
					year3.focus();
				}
			}
			function detailsoftraining()
			{
				document.getElementById('degree1').focus();
			}			
			

			function chkyear4(year4)
			{
				var curyear = new Date();
				var curyear4 =  curyear.getYear();
					if(year4.value > curyear4)
				{
				//alert('APP-AM0024 Year of Passing cannot be greater than current Year');
				alert(getMessage("AM0164","AM"));
				year4.value = "";
					year4.focus();
				}
			}

			function chkY(b_age)
			{
				
				if(b_age.value > 150)
				{
						alert(getMessage("INVALID_AGE_YEAR","AM"));
				}
			}
			function objClick(objName)
			{
				//changeLink(objName);
				if (objName == 'demogrp_tab')
					parent.practitioner_sub.moveToLink(1);
				else if(objName == 'others_tab')
				{
					parent.practitioner_sub.moveToLink(2);
				}
				else if(objName == 'findtl_tab')
				{
					parent.practitioner_sub.moveToLink(3);
				}
			}
			
			async function searchCountryCode(obj,target,callVal)
			{
				var retVal =    new String();
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var tit=getLabel("eMP.CountryCode.label","mp");

				sql = "select country_code code, short_name description from mp_country where eff_status = 'E' and upper(country_code) like upper(?) and upper(short_name) like upper(?) order by 2";
					
				argumentArray[0] = sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target.value;
				argumentArray[6] = DESC_LINK  ;
				argumentArray[7] = DESC_CODE ;
				retVal = await CommonLookup( tit, argumentArray );
				if(retVal != null && retVal != "" )
				{
					var ret1=unescape(retVal);
					arr=ret1.split(",");
					target.value=arr[1];
					if(callVal == 'residence')
					{
						practitioner1_form.res_add_country_code.value= arr[0];
					}
					else if(callVal == 'office')
					{
						practitioner1_form.off_add_country_code.value= arr[0];
					}
					else if(callVal == 'mail')
					{
						practitioner1_form.mail_add_country_code.value= arr[0];
					}
				}
				else
				{
					target.value = '';
					if(callVal == 'residence')
					{
						practitioner1_form.res_add_country_code.value= "";
					}
					else if(callVal == 'office')
					{
						practitioner1_form.off_add_country_code.value= "";
					}
					else if(callVal == 'mail')
					{
						practitioner1_form.mail_add_country_code.value= "";
					}
				}
				if(callVal == 'residence')
				{
					if(document.practitioner1_form.practid.value != '')
					{
						check9()
					}
				}
				else if(callVal == 'office')
				{
					if(document.practitioner1_form.practid.value != '')
					{
						check11();
					}
				}
				else if(callVal == 'mail')
				{
					if(document.practitioner1_form.practid.value != '')
					{
						check13();
					}
				}
				
			}
			function changeLink(LinkName) 
			{
				if (currentLink=='identity_link')
					document.getElementById('identity_link').src='../../eAM/images/Identity_click.gif';
				else if (currentLink=='contactno_link')
					document.getElementById('contactno_link').src = '../../eAM/images/Contact_Addr_click.gif';
				else if (currentLink=='deg_link')
					document.getElementById('deg_link').src = '../../eAM/images/Qualification_and_Training_click.gif';

				if(LinkName=='identity_link')
					document.getElementById('identity_link').src='../../eAM/images/Identity.gif';
				else if(LinkName=='contactno_link')
					document.getElementById('contactno_link').src='../../eAM/images/Contact_Addr.gif';
				else if(LinkName=='deg_link')
					document.getElementById('deg_link').src='../../eAM/images/Qualification_and_Training.gif';
				currentLink = LinkName;
			}
   			function echeck1(Obj)
   			{
     			if(Obj.value == "T") 
				{
				document.getElementById('popempid').innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Empl ID &nbsp;<input id='employee_id'  type='text' value='' onBlur='makeValidString(this)'  name='employee_id' maxlength='30' size ='30'>";	
				}
     			else 	
     			 	document.getElementById('popempid').innerHTML="";	
     		}	
     		function change(totApptCount) 
			{
				if(totApptCount >0)
				{
					alert(getMessage('FUTURE_APPT_EXISTS','AM'));
					practitioner_form.eff_status.value="E";
					practitioner_form.eff_status.checked=true;
				}
				else
				{
					if (practitioner_form.eff_status.checked == true)
					{
						practitioner_form.eff_status.value="E";
					}
					else
					{
						practitioner_form.eff_status.value="D";
					}
				}
       		}
	      	function check() 
			{ 
								
				if(document.practitioner1_form.function_id)
				{
				if(document.practitioner1_form.function_id.value=="PRACTITIONER")
				{
	      		if(practitioner1_form.all_facilities.checked == true) 
				{
					practitioner1_form.all_facilities.value="Y";
					practitioner1_form.all_facilities1.value="Y"; // added by mujafar for MOHE-SCF-0002
     				
					if(document.getElementById('rep_facility')!=null)	{
						document.getElementById('rep_facility').value="";
						document.getElementById('rep_facility').disabled=true;					
					}
			
			   }
	      	else 
			{
				practitioner1_form.all_facilities.value="N";
				practitioner1_form.all_facilities1.value="N"; // added by mujafar for MOHE-SCF-0002
				if(document.getElementById('rep_facility')!=null)
					document.getElementById('rep_facility').disabled=false;
			}
				}
				}
      	}
		
		
		function checkpract()
		{
			
			if(practitioner1_form.function_name.value == "insert") 
			{
				parent.frames[1].document.practitioner1_form.pract_type1.value=parent.frames[1].document.practitioner_form.pract_type.value;
				
			}
			else if(practitioner1_form.function_name.value == "modify") 
			{    
			 	check1();
				practitioner1_form.pract_type1.value=practitioner_form.pract_type3.value;
			}
		}
		function check1() {
		if(practitioner_form.pract_type){
			practitioner_form.pract_type3.value = practitioner_form.pract_type.value;}
		}
		function check2() {
			practitioner1_form.sex2.value=practitioner1_form.sex.value;
		}
		function check3() {
			practitioner1_form.empl_status2.value=practitioner1_form.empl_status.value;
		}
		function check4() {
			practitioner1_form.pref_contact_mode2.value=practitioner1_form.pref_contact_mode.value;
		}
		function check5() {
			practitioner1_form.marital_status2.value=practitioner1_form.marital_status.value;
		}
		function check6() {
			practitioner1_form.citizen2.value=practitioner1_form.citizen.value;
		}
		
		function check8() {
			practitioner1_form.res_add_postal_code2.value=practitioner1_form.res_add_postal_code.value;
		}
		function check9() {
			practitioner1_form.res_add_country_code2.value= practitioner1_form.res_add_country_code.value;
		}
		function check10() {
			practitioner1_form.off_add_postal_code2.value =practitioner1_form.off_add_postal_code.value;
		}
		function check11() {
			practitioner1_form.off_add_country_code2.value =practitioner1_form.off_add_country_code.value;
		}
		function check12() {
			practitioner1_form.mail_add_postal_code2.value =practitioner1_form.mail_add_postal_code.value;
		}
		function check13() {
			practitioner1_form.mail_add_country_code2.value =practitioner1_form.mail_add_country_code.value;
		}
		function check14() {
			practitioner_form.primary_speciality_code2.value =practitioner_form.primary_speciality_code.value;
		}
		function moveto() {
		parent.frames[1].document.practitioner1_form.sex.focus();
	}
function allowValidNumber(fld, e, maxInt, deci)
{
	var count=fld.value.length;
	var whichCode = (window.Event) ? e.which : e.keyCode;
	if(count>=maxInt)
	{
		if(count==maxInt)
		{
		    var dotOccurance = fld.value.indexOf('.');
			if(((dotOccurance>=maxInt)||(dotOccurance==-1)) && (count==maxInt))
			{
				if(whichCode!=46)
				{
					//var errors = "APP-0001 Reached Maximum Integer value";
					var errors = getMessage("AM0126","AM");
					//parent.parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
					return false;
				}
			}
		}
		else if(count>maxInt)
		{
			var objectValue = fld.value;
		    var dotOccurance = objectValue.indexOf('.');
			if((objectValue.charAt(maxInt))!='.')
			{
				if(dotOccurance==-1)
				{
					fld.value = objectValue.substring(0,maxInt)+".";
					return false;
				}
			}
		}
	}
	if (parseInt(deci)==1)//For Minus,Decimal Point and 0-9
	  var strCheck = '.0123456789-';
	else if (parseInt(deci)==2) //For Decimal Point and 0-9
	{
	   var strCheck = '.0123456789';
	}
	else if (parseInt(deci)==0)//For Only Nos 0 - 9
	{
		var strCheck = '0123456789';
	}
	else if (parseInt(deci)==3)//For Minus and 0-9 Only
	{
		var strCheck = '0123456789-';
	}
	if (parseInt(deci)==1)
	{
		var fldvalue=fld.value;
		if (whichCode == 45 && (fldvalue.length==0)) return true;  // minus 
		if (whichCode == 45 && (fldvalue.length>0)) return false;  // minus 
	}

	var fldvalue=fld.value;
	var whichCode = (window.Event) ? e.which : e.keyCode;
	if (whichCode == 13) return true;  // Enter
	var pointCount=0;
	for(var i=0;i<fldvalue.length;i++)
	{
		if(fldvalue.charAt(i)=='.') pointCount++;
	}
	if (pointCount>0 && whichCode == 46) return false;

	var fldValue	=	fld.value;
	var dotIndex	=	fldValue.indexOf(".");
	var fldLength	=	fldValue.length;

	if(dotIndex!=-1)
		if( fldLength > (dotIndex+3) ) return false;

	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true;
}
function resMove()
{
	//alert('Welcome to eHIS');
	//alert(getMessage("WELCOME","Common"));

}
function changeFocus()
{
	if (document.getElementById("pract_type")){
		document.getElementById("pract_type").focus();
	}
}
/*function changeFocus3()
{
	if (document.getElementById('pract_type2')){
		document.getElementById('pract_type2').focus();
	}
}*/

function changeFocus1()
{
	//objClick('identity_link');	
	if(parent.practitioner_main.document.getElementById('eff_status').value=='E')
		{
	document.practitioner1_form.sex.focus();
		}
	else
		document.practitioner1_form.sex1.focus();
}
function changeFocus2()
{
	parent.frames[1].document.practitioner1_form.sex1.focus();

	
}

function changeFocus10()
{	
	if (parent.practitioner_main.document.getElementById("pract_type"))
		parent.practitioner_main.document.getElementById("pract_type").focus();
	else{
		if (parent.practitioner_main.document.getElementById('pract_type2'))
		parent.practitioner_main.document.getElementById('pract_type2').focus();
  }
}
function changeFocus1_app()
{ 
      if(parent.practitioner_main.document.practitioner_form.changeext.checked==true)
	{
	 document.practitioner1_form.sex.focus();
	}

	  if(parent.frames[1].document.practitioner1_form.function_id.value=="EXT_PRACT")
	  objClick('identity_link');	
}
function callfunFocus()
{
	//objClick('contactno_link');	
	document.getElementById('residencetelno').focus();
}

function changeFocus1_new(obj)
{
	if(obj.checked==true)
	 objClick('identity_link');
	
	//document.getElementById('sex').focus();
	
}
function chkyearlen(obj)
{
	if(obj.length < 4)
	{
		alert(getMessage("INVALID_YR_FORMAT","Common"));
		obj.focus();
	}
}
async function searchCitizenship(obj,target)
{
	//Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011
	var isResidencyApplYN = document.practitioner1_form.isResidencyApplYN.value;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit=encodeURIComponent(getLabel("Common.Citizenship.label","common"));

	sql = "select country_code code, long_desc description from mp_country where eff_status = 'E' and upper(country_code) like upper(?) and upper(long_desc) like upper(?) and long_desc is not null order by 2";
		
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		document.practitioner1_form.citizen.value= arr[0];
		
	}
	else{
		target.value='';
		document.practitioner1_form.citizen.value= '';
		}
	if(document.practitioner1_form.practid.value != '')
	{
		check6();
	}
	
	//Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011
	if(isResidencyApplYN == "true")
	{
		checkCitznOrNonCitzn();
	}
}

/*function RemoveSpecialChar(txtVal){
	if(txtVal.value.indexOf("'")!=-1 || txtVal.value.indexOf("''")!=-1 || txtVal.value.indexOf('"')!=-1){
		 txtVal.value = txtVal.value.replace("'", ''); 
		 txtVal.value = txtVal.value.replace("''", '');
		 txtVal.value = txtVal.value.replace('"', '');
	}
 }*/
 function RemoveSpecialChar(txtVal){
	if(txtVal.value.indexOf("'")!=-1 || txtVal.value.indexOf("''")!=-1 || txtVal.value.indexOf('"')!=-1){
		  txtVal.value = txtVal.value.replace(/'/g, '');
		  txtVal.value = txtVal.value.replace(/""/g, '');
		  txtVal.value = txtVal.value.replace(/''/g, '');
          txtVal.value = txtVal.value.replace(/"/g, '');		  
	}
 } 

</script>
</head>
<%
      	Connection conn = null; 
		conn = ConnectionManager.getConnection(request);
		
		Boolean isVIRTUAL_CONSULTATION  = eCommon.Common.CommonBean.isSiteSpecific(conn,"OP","VIRTUAL_CONSULTATION");//<!--added by Himanshu Saxena for ML-MMOH-CRF-1930 on 17-04-2023 -->
		
		//<!--added by lakshmanan for MO-CRF-20183.2 start-->
		String practEmployeeServiceNo="";
		
		//<!--added by lakshmanan for MO-CRF-20183.2 end-->
		
		boolean isPractEmployeeServiceNumber  = false ; // Added for PMG2023-COMN-CRF-0043 by Kamatchi S
		
      	String accept_national_id_no_yn = "N",/*nat_id_length="",*/nat_id_prompt="",nat_id_chk_len="",nat_id_check_digit_id="",nat_data_source_id="";
      	String practitionerid="";
      	String nat_id_accept_alphanumeric_yn = "";
      		
      	practitionerid=request.getParameter("practitioner_id");
		
		if(practitionerid==null) practitionerid = "null";
		String facilityid=(String)session.getValue("facility_id");
      	int totApptCount=0;
      	StringBuffer strt=new StringBuffer();;
      	String strt1="";
      	String strt2="";
      	String practtype="";
      	String practtypedesc="";
      	String practtype1="";
      	String practtypedesc1="";
		String birthdate_disp="";
		String reporting_facility_id="";      		
      	String practitionername="";
		InputStream practitioner_sign = null; // added by mujafar for AAKH-CRF-0079.4
		InputStream practitioner_stamp = null; // added by manjunath for TH-KW-CRF-0161.1
		String includevisibility = "disabled";
        String includevisibility1 = "disabled";// added by manjunath for TH-KW-CRF-0161.1
		String shortname="";
      	String effstatus="";
   	 	StringBuffer str1=new StringBuffer();
   	 	String strs1="";
   	 	String strs2="";
		StringBuffer str2=new StringBuffer();
		String strm1="";
		String strm2="";
		//String str3="";
		String strc1="";
		String strc2="";
		StringBuffer str4=new StringBuffer();
		String strr1="";
		String strr2="";
		StringBuffer str5=new StringBuffer();
		String stre1="";
		String stre2="";
		StringBuffer str15=new StringBuffer();
		String strpr1="";
		String strpr2="";
		StringBuffer str6=new StringBuffer();;
		String strp1="";
		String strp2="";
		
		String strrep1="";
		String strrep2="";
		//String str8="";
		String strrec1="";
		String strrec2="";
		String strofp1="";
		String strofp2="";
		//String str10="";
		String strofc1="";
		String strofc2="";
		String strmap1="";
		String strmap2="";
		//String str12="";
		String strmac1="";
		String strmac2="";
		String str13="";
		String str14="";
		String sex="";
		String sex1="";
		String emplstatus="";
		String emplstatus1="";
		String prefmode="";
		String prefmode1="";
		String birthdate="";
		String birthplace="";
		String mar_status_code="";
		String maritalstatus="";
		String maritaldesc="";
		String maritalstatus1="";
		String maritaldesc1="";
		String aliasname="";
		String citizen="";
		String citizendesc="";
		String citizen1="";
		String citizendesc1="";
		String nationalidno="";
		//Variables added on 22/04/2003 by Mallikarjuna Reddy for Credential 1,2,3
		String credentialid1="";
		String credentialid2="";
		String credentialid3="";
		//End of addition on 22/04/2003 by Mallikarjuna Reddy for Credential 1,2,3
		String jobtitle="";
		String degree="";
		String repfacility="";
		String repfacilityname="";
		String repfacility1="";
		String repfacilityname1="";
		String prspcode="";
		String prspdesc="";
		String prspcode1="";
		String prspdesc1="";
		String allfacilities="";
		String restelnum="";
		String offtelnum="";
		String offtelext="";
		String pagernum="";
		String faxnum="";
		String mobilenum="";
		String emailid="";
		String resaddln1="";
		String resaddln2="";
		String resaddln3="";
		String resaddln4="";
		String offaddln1="";
		String offaddln2="";
		String offaddln3="";
		String offaddln4="";
		String mailaddln1="";
		String mailaddln2="";
		String mailaddln3="";
		String mailaddln4="";
		String respostalcode="";
		String offpostalcode="";
		String mailpostalcode="";
		String rescountrycode="";
		String rescountrydesc="";
		String respostaldesc="";
		String offpostaldesc="";
		String mailpostaldesc="";
		//String rescountrycode1="";
		//String rescountrydesc1="";
		String offcountrycode="";
		String offcountrydesc="";
		//String offcountrycode1="";
		//String offcountrydesc1="";
		String mailcountrycode="";
		String mailcountrydesc="";
		//String mailcountrycode1="";
		//String mailcountrydesc1="";
		String poscode="";
		String sql11="";
		String bage="";
		String bmonths="";
		String bdays="";
		int count=0;
   	 	String codeTextAttribute="";
		String otherTextAttribute="";
		String otherTextAttributeEmpSrvNo=""; //added by lakshmanan for MO-CRF-20183
		String checkBoxAttribute="";
		String checkBoxAttribute1="";
		String checkBoxAttribute_EVC=""; //added by Himanshu Saxena for ML-MMOH-CRF-1930(U1)
		String effstatus_EVC=""; //added by Himanshu Saxena for ML-MMOH-CRF-1930(U1)
		String disable_checkbox="";//added by Himanshu Saxena for ML-MMOH-CRF-1930(U1)
		String eventFunctionForCase="";
		String fcall="";		
		String cnc = "";
		String cncdesc = "";
		String employeeid ="";
		String disablerecord="";
		String apc_no="";

		String degree1 = "";
		String degree2 = "";
		String degree3 = "";
		String degree4 = "";

		String year1 = "";
		String year2 = "";
		String year3 = "";
		String year4 = "";
		
		String univ1 = "";
		String chkvalue1="";
		String univ2 = "";
		String univ3 = "";
		String univ4 = "";

		String con1 = "";
		String con2 = "";
		String con3 = "";
		String con4 = "";
		
		String det1 = "";
		String det2 = "";
		String det3 = "";
		String det4 = "";
		String function_id="";
		String disableextn="";
	    String readProperty="";	
	    //Added for the CRF - Bru-HIMS-CRF-198
	    String multi_Spec_disabled="";	
	    String multi_speciality_yn="";	
	    String longname="";
	    String longname1="";
	   // String mode12="";
	   	java.sql.Statement stmt2= null;
		ResultSet rs2 = null;

		java.sql.Statement stmt = null;
		ResultSet rs = null;

	   //Added HSA-CRF-160
		Statement other_altstat=null;
		ResultSet other_altrs=null;
		String alt_type_code="",alt_type_desc="",other_alt_type_no="",other_alt_type_desc="",other_alt_select="";
		
		//Below line added for this CRF ML-MMOH-CRF-0862
	    boolean isCernerpractitioner = false; 
		String cerner_prac_id="";
		String shortdescMaxLength="15";
		String shortdescMaxSize="15";
		
		/*Added by Thamizh selvi on 28th June 2018 against ML-MMOH-CRF-1184 Start*/
		boolean isFPPPractApplicable	= false;
		String	fppPractYn				= "";
		/*End*/
		
		/*Added By Dharma on 19th Aug 2020 against AAKH-CRF-0122.4 Start*/
		boolean isCoderDiagAppl	= false;
		String supervisor_yn	= "N";
		/*Added By Dharma on 19th Aug 2020 against AAKH-CRF-0122.4 End*/

		/*Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011*/
		Boolean isResidencyApplYN = false;
		String citizen_nat_code = "";
		String citizen_nat_desc = "";
		String citizen_code = "";
		String citizenChk = "Checked";
		String nonCitizenChk = "";
		String natIdDis = "";
		String nat_visibility = "";
		String natid_mand_yn = "";
		String oth_alt_val = "";
		String other_alt_type_dis = "";
		String other_alt_no_dis = "disabled";
		String oth_alt_visibility = "hidden";
		String alt_id1_type = "";
		String alt_id1_length = "";
		String oth_alt_length = "20";
		/*End MOHE-CRF-0011*/
		
		boolean isMMCLblchngesAppl		= false;////Added By Dharma on 23rd Dec 2019 against  ML-MMOH-CRF-1488
		boolean isSplCharNotAllowApplYN = false; //Added by Suji Keerthi for MOHE-CRF-0113 US001
		
	 //  if(mode12.equals("update"))
     //disableextn="disabled";

		java.sql.Statement stmtcit = null;
		ResultSet rscit = null;
		java.sql.Statement stmt9=null;
		stmt9=conn.createStatement();
		String sql9="select to_char(sysdate,'dd/mm/yyyy') from dual";
		ResultSet rs9=null;
		rs9=stmt9.executeQuery(sql9);
				  	
		if(rs9.next())
		{		  	
		str13=rs9.getString(1);
		} 


		try
		{
		
			isFPPPractApplicable = eCommon.Common.CommonBean.isSiteSpecific(conn, "AM","FULL_PAYING_PATIENT_PRACT");//Modified by Thamizh selvi on 28th June 2018 against ML-MMOH-CRF-1184
			isPractEmployeeServiceNumber = eCommon.Common.CommonBean.isSiteSpecific(conn,"AM","PRACT_EMPLOYEE_SERVICE_NO");// Added for PMG2023-COMN-CRF-0043 by Kamatchi S
			isMMCLblchngesAppl  = eCommon.Common.CommonBean.isSiteSpecific(conn, "AM","AM_MMCNO_LBL_APPL_YN");//Added By Dharma on 23rd Dec 2019 against  ML-MMOH-CRF-1488

			isCoderDiagAppl =  eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","MR_CODER_DIAGNOSIS"); //Added By Dharma on 19th Aug 2020 against AAKH-CRF-0122.4 
			
			//Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011
			isResidencyApplYN = eCommon.Common.CommonBean.isSiteSpecific(conn, "SM", "NATID_MAND_PRACT_OTHSTAFF");
			natid_mand_yn = eAM.AMCommonBean.getNatIdMandYN(conn);
			oth_alt_val = eAM.AMCommonBean.getOthAltDefaultValue(conn, "SM", "NATID_MAND_PRACT_OTHSTAFF");

		//Below line added for this CRF ML-MMOH-CRF-0862	    
		isCernerpractitioner=CommonBean.isSiteSpecific(conn, "AM","CERNER_PRACTITIONER_ID");
		if(isCernerpractitioner){
		shortdescMaxLength="40";
		shortdescMaxSize="60";
		}
		//End this ML-MMOH-CRF-0862

		isSplCharNotAllowApplYN = eCommon.Common.CommonBean.isSiteSpecific(conn, "AM", "SPL_CHAR_NOT_ALLOWED"); //Added by Suji Keerthi for MOHE-CRF-0113 US001
		
		
		
			///////////////////////////
			stmtcit=conn.createStatement();
			
			rscit=stmtcit.executeQuery("select a.citizen_nationality_code citizen_nat_code, b.country_code , b.long_desc longDesc from mp_param a, mp_country b where b.eff_status = 'E' and  a.citizen_nationality_code = b.country_code");
			if(rscit != null && rscit.next())
			{		
				cnc=rscit.getString("citizen_nat_code");
				cncdesc=rscit.getString("longDesc");

				//Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011
				citizen_nat_code = rscit.getString("citizen_nat_code");
				if (citizen_nat_code == null || citizen_nat_code.equals("null")) citizen_nat_code = "";
				citizen_nat_desc = rscit.getString("longDesc");
				if (citizen_nat_desc == null || citizen_nat_desc.equals("null")) citizen_nat_desc = "";
			}
			 if(rscit != null) rscit.close();
			 if(stmtcit != null) stmtcit.close();
		////////////////////////////
       	boolean newPractitioner=false;
   	 	fcall = request.getParameter("fcall"); 
		if (fcall == null) fcall="";
			function_id=request.getParameter("function_id");
         if(function_id.equals("EXT_PRACT"))
			{
			  chkvalue1="checked";
			 // chk_value_new="Y";
			}
			else{
              chkvalue1="";
			 // chk_value_new="N";
			}
		if(function_id == null) function_id="";
	 	if(practitionerid!=null && practitionerid.equals("null")) 
		{
   	 		practitionerid = "";
			
			practitionername="";
			shortname="";
   	 		str1.append("<select name='sex' id='sex' tabindex='9' onkeyDown='shift_tab()'  ><option value='M'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")+"<option value='F'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")+"<option value='U'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels")+"</select>");

			birthdate="";
			birthplace="";

   	 		java.sql.Statement stmtty = null;
			
			java.sql.Statement stmt1= null;
		
			java.sql.Statement stmt3=null;
   	 		java.sql.Statement stmt4=null;
			java.sql.Statement stmt5=null;
			java.sql.Statement stmt6=null;
			java.sql.Statement stmt7=null;
			java.sql.Statement stmt8=null;
			
			java.sql.Statement stmt10=null;
			java.sql.Statement stmtpr=null;
			java.sql.Statement stmtf=null;
			//java.sql.Statement stmtc=null;
			ResultSet rst = null;
			
			ResultSet rs1 = null;
			
			ResultSet rs3 = null;
			ResultSet rs4= null;
			ResultSet rs5=null;
			ResultSet rs6=null;
			ResultSet rs7=null;
			ResultSet rs8=null;
			
			ResultSet rs10=null;
			ResultSet rspr=null;
			ResultSet rsf=null;
			//ResultSet rsc=null;

		try
			{
			stmtf=conn.createStatement();
			String sqlf="select count(*) as total from sm_facility_param";
			rsf=stmtf.executeQuery(sqlf);
			if(rsf.next())
			{
				count=rsf.getInt("total");
			}
		    }
			catch(Exception e) 
			{
		     out.println("errors="+e);
		     }
			 finally 
			 {
				 try
				 {
					 if(stmtf != null) stmtf.close();
					 if(rsf != null) rsf.close();
				  }
				  catch(Exception e)
				 {
					  e.printStackTrace();
				  }
			 }

		try {
		  	stmtty=conn.createStatement();
		  	String sqlt = "select pract_type,Desc_Userdef  from am_pract_type where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by Desc_Userdef";
		  	rst=stmtty.executeQuery(sqlt);
  strt.append("<select name='pract_type' id='pract_type' onChange='populateValues();enaDisSupervisorChkbox(this.value);validateEnablevirtualConst(this.value)' tabindex='1'><option value=''> -----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-------");	
		  	 while(rst.next()) 
		  	 {
		  		practtype=rst.getString("pract_type");
		  		practtypedesc=rst.getString("Desc_Userdef");
		  		strt.append("<option value='"+ practtype+"' onClick='checkpract()' >"+practtypedesc);
				

		  	 }
		  	strt.append("</select>");
			
			stmt1=conn.createStatement();
			String sql1="select country_code,long_desc from mp_country where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')))  and long_desc is not null order by long_desc ";
			rs1=stmt1.executeQuery(sql1);
			//str3="<select name='citizen' id='citizen'><option value=''>-----Select-----"+"</option>";
			 while(rs1.next())
			 {
				citizen=rs1.getString("country_code");
				citizendesc=rs1.getString("long_desc");
				if(citizen==null) citizen = "";
				if(citizendesc==null) citizendesc = "";
				if(cnc==null) cnc = "";

				/*if(cnc.equals(citizen)) 
				{
					str3+="<option value='"+citizen+"' selected>"+citizendesc+"</option>";
				}
				else 
				{
					str3+="<option value='"+citizen+"'>"+citizendesc+"</option>";
				}*/
			 }
			//str3+="</select>";
			
			stmt4=conn.createStatement();
			String sql4="select country_code,short_name from mp_country where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by short_name";
			rs4=stmt4.executeQuery(sql4);
			//str8="<select name='res_add_country_code' id='res_add_country_code'><option value=''>-----Select-----"+"</option>";
			while(rs4.next())
			{
				rescountrycode=rs4.getString("country_code");
				rescountrydesc=rs4.getString("short_name");
				//str8+="<option value='"+rescountrycode+"'>"+rescountrydesc+"</option>";
			}
			//str8+="</select>";
			
			stmt6=conn.createStatement();
			String sql6="select country_code,short_name from mp_country where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by short_name";
			rs6=stmt6.executeQuery(sql6);
			//str10="<select name='off_add_country_code' id='off_add_country_code'><option value=''>-----Select-----"+"</option>";
			 while(rs6.next())
		  	 {
		  		offcountrycode=rs6.getString("country_code");
		  		offcountrydesc=rs6.getString("short_name");
		  		//str10+="<option value='"+offcountrycode+"'>"+offcountrydesc+"</option>";
		  	 } 
		  	//str10+="</select>";
		  	
		  	stmt8=conn.createStatement();
		  	String sql8="select country_code,short_name from mp_country where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by short_name";
		  	rs8=stmt8.executeQuery(sql8);
		  	//str12="<select name='mail_add_country_code' id='mail_add_country_code' onBlur='document.getElementById("residencetelno").focus()'><option value=''>-----Select-----"+"</option>";
		  	while (rs8.next())
		  	{
		  		mailcountrycode=rs8.getString("country_code");
		  		mailcountrydesc=rs8.getString("short_name");
		  		//str12+="<option value='"+mailcountrycode+"'>"+mailcountrydesc+"</option>";
		  	}
		  	//str12+="</select>";
			
		  	stmt10=conn.createStatement();
		  	String sql10="select nat_id_length,accept_national_id_no_yn,nat_id_prompt, nat_id_chk_len, nat_id_check_digit_id ,nat_data_source_id,nat_id_accept_alphanumeric_yn, alt_id1_type, alt_id1_length from mp_param";
		  	rs10=stmt10.executeQuery(sql10);
		  	
		  	if(rs10 != null)
		  	{		
		  		while(rs10.next())
		  		{
		  			str14=rs10.getString(1);
		  			accept_national_id_no_yn=rs10.getString(2);
					if(accept_national_id_no_yn == null) accept_national_id_no_yn ="N";
		  			nat_id_accept_alphanumeric_yn=rs10.getString("nat_id_accept_alphanumeric_yn");
		  			if(nat_id_accept_alphanumeric_yn == null) nat_id_accept_alphanumeric_yn ="N";
		  			nat_id_prompt=rs10.getString(3);if(nat_id_prompt == null) nat_id_prompt=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.NationalIDNo.label","am_labels");
		  			nat_id_chk_len=rs10.getString(4);if(nat_id_chk_len == null) nat_id_chk_len="";
		  			nat_id_check_digit_id=rs10.getString(5);if(nat_id_check_digit_id == null) nat_id_check_digit_id="";
		  			nat_data_source_id=rs10.getString(6);if(nat_data_source_id == null) nat_data_source_id="";
					//Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011
					alt_id1_type = rs10.getString("alt_id1_type");if(alt_id1_type == null) alt_id1_type="";
					alt_id1_length = rs10.getString("alt_id1_length");if(alt_id1_length == null) alt_id1_length="";	  			
		  		}	
		  	}	
		 	
		  	stmtpr=conn.createStatement();
		  	String sqlpr="select speciality_code,short_desc from am_speciality where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by short_desc ";
		  	rspr=stmtpr.executeQuery(sqlpr);
		  	str15.append("<select name='primary_speciality_code' id='primary_speciality_code' tabindex='7'><option value=''>-------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---------"+"</option>");
		  	while (rspr.next())
		  	{
		  		prspcode=rspr.getString("speciality_code");
		  		prspdesc=rspr.getString("short_desc");
		  		str15.append("<option value='"+prspcode+"'>"+prspdesc+"</option>");
		  	}
		  	str15.append("</select>");
		}
		catch(Exception e)
		{
			out.println("ERROR is -->"+e);
		}
		finally
		{
			try
			{
			if (stmtty != null) stmtty.close();
			if (rst != null) rst.close();
			if (rs != null) rs.close();
			if (rs1 != null) rs1.close();
			if (rs2 != null) rs2.close();
			if (rs3 != null) rs3.close();
			if (rs4 != null) rs4.close();
			if (rs5 != null) rs5.close();
			if (rs6 != null) rs6.close();
			if (rs7 != null) rs7.close();
			if (rs8 != null) rs8.close();
			if (rs9 != null) rs9.close();
			if (rs10 != null) rs10.close();
			if (rspr != null) rspr.close();

			if (stmt != null) stmt.close();
			if (stmt1 != null) stmt1.close();
			if (stmt2 != null) stmt2.close();
			if (stmt3 != null) stmt3.close();
			if (stmt4 != null) stmt4.close();
			if (stmt5 != null) stmt5.close();
			if (stmt6 != null) stmt6.close();
			if (stmt7 != null) stmt7.close();
			if (stmt8 != null) stmt8.close();
			if (stmt9 != null) stmt9.close();
			if (stmt10 != null) stmt10.close();
			if (stmtpr != null) stmtpr.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		effstatus="E";
		bage="0";
		aliasname="";
		nationalidno="";
		credentialid1="";
		credentialid2="";
		credentialid3="";
		jobtitle="";
		str5.append("<select name='empl_status' id='empl_status' onChange='echeck1(this); 'tabindex='23'><option value=''>----------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---------<option value='S'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Associate.label","common_labels")+"<option value='F'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FullTime.label","common_labels")+"<option value='P'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PartTime.label","common_labels")+"<option value='V'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.VisitingSpecialist.label","am_labels")+"</select>");
		
		degree="";
		allfacilities="N";
		restelnum="";
		offtelnum="";
		offtelext="";
		pagernum="";
		faxnum="";
		mobilenum="";
		emailid="";
		str6.append("<select name='pref_contact_mode' id='pref_contact_mode' tabindex='34'><option value=''>-------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---------<option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.email.label","common_labels")+"<option value='F'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fax.label","common_labels")+"<option value='M'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mobile.label","common_labels")+"<option value='O'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.office.label","common_labels")+"<option value='P'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Pager.label","am_labels")+"<option value='R'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.residence.label","common_labels")+"</select>");
		resaddln1="";
		resaddln2="";
		resaddln3="";
		resaddln4="";
		offaddln1="";
		offaddln2="";
		offaddln3="";
		offaddln4="";
		mailaddln1="";
		mailaddln2="";
		mailaddln3="";
		mailaddln4="";
		codeTextAttribute="";
		otherTextAttribute="";
		checkBoxAttribute="CHECKED";
		//added by Himanshu Saxena for ML-MMOH-CRF-1930(U1) Started //
			checkBoxAttribute_EVC="";
			effstatus_EVC="D";	
			disable_checkbox="";
		//added by Himanshu Saxena for ML-MMOH-CRF-1930(U1) end //
				
		if(allfacilities.equals("N"))
				checkBoxAttribute1=" ";
		else
			checkBoxAttribute1="CHECKED";

		newPractitioner=true;
		//Below Modified by Suji Keerthi for PAS-OP-MOHE-CRF-0113/01-OP Code Setup-Clinic
		if(isSplCharNotAllowApplYN)
			{
			eventFunctionForCase="OnBlur='ChangeUpperCase(this);CheckSplCharsforIdValidation(this)'";		
			}
			else 
			{
		    eventFunctionForCase="OnBlur='ChangeUpperCase(this)'";	
			}
	}
	else
	{
		// Commented by Krishnan on 28/08/2012 for ORA-600 Error
		//String sqlap="select count(1) as total from oa_appt where facility_id = '"+facilityid+"' and practitioner_id='"+practitionerid+"' AND trunc(appt_date) >= trunc(sysdate) and nvl(appt_status,1)!='A' ";
		//String sqlap="select count(1) count_total from oa_appt where facility_id = '"+facilityid+"' and practitioner_id='"+practitionerid+"' AND appt_date between to_date(to_char(sysdate, 'DD/MM/YYYY') || ' 00:00', 'DD/MM/YYYY HH24:MI') and sysdate+36524 and nvl(appt_status,1)!='A' ";
		
		//java.sql.Statement stmtap=conn.createStatement();
      		//ResultSet rsap=stmtap.executeQuery(sqlap);
			
		String sqlap="select count(1) count_total from oa_appt where facility_id = ? and practitioner_id=? AND appt_date between to_date(to_char(sysdate, 'DD/MM/YYYY') || ' 00:00', 'DD/MM/YYYY HH24:MI') and sysdate+36524 and nvl(appt_status,1)!='A' ";
			
		PreparedStatement pstmt   = conn.prepareStatement(sqlap);
		pstmt.setString	(	1,	facilityid		);
		pstmt.setString	(	2,	practitionerid		);
		ResultSet rsap		 = pstmt.executeQuery();
		if(rsap!=null)
		rsap.next();
		totApptCount = rsap.getInt("count_total");

        if(rsap != null) rsap.close();
      //  if(stmtap != null) stmtap.close();
        if(pstmt != null) pstmt.close();
				
		java.sql.Statement stmt10=null;
		java.sql.Statement stmt11=null;
		java.sql.Statement stmt12=null;
		java.sql.Statement stmt13=null;
		java.sql.Statement stmt14=null;
		java.sql.Statement stmt15=null;
		java.sql.Statement stmt16=null;
		java.sql.Statement stmt17=null;
		java.sql.Statement stmt18=null;
		java.sql.Statement stmt19=null;
		java.sql.Statement stmt20=null;
		java.sql.Statement stmt21=null;
		java.sql.Statement stmt22=null;
		java.sql.Statement stmt23=null;
		java.sql.Statement stmt24=null;
		java.sql.Statement stmt25=null;
		java.sql.Statement stmt26=null;
		java.sql.Statement stmt27=null;
		java.sql.Statement stmtp=null;
		java.sql.Statement stmtm=null;
		java.sql.Statement stmtc=null;
		java.sql.Statement stmtr=null;
		java.sql.Statement stmtrep=null;
		java.sql.Statement stmtrec=null;
		java.sql.Statement stmtofp=null;
		java.sql.Statement stmtofc=null;
		java.sql.Statement stmtmap=null;
		java.sql.Statement stmtmac=null;
		java.sql.Statement stmtpr=null;
		java.sql.Statement stmtpr1=null;
		java.sql.Statement stmtf=null;

		ResultSet rset=null;
      		ResultSet rset1=null;
		ResultSet rs10=null;
		ResultSet rs12=null;
		ResultSet rs13=null;
		ResultSet rs14=null;
		ResultSet rs15=null;
		ResultSet rs16=null;
		ResultSet rs17=null;
		ResultSet rs18=null;
		ResultSet rs19=null;
		ResultSet rs20=null;
		ResultSet rs21=null;
		ResultSet rs22=null;
		ResultSet rs23=null;
		ResultSet rs24=null;
		ResultSet rs25=null;
		ResultSet rs26=null;
		ResultSet rs27=null;
		ResultSet rsp=null;
		ResultSet rsm=null;
		ResultSet rsc=null;
		ResultSet rsr=null;
		ResultSet rsrep=null;
		ResultSet rsrec=null;
		ResultSet rsofp=null;
		ResultSet rsofc=null;
		ResultSet rsmap=null;
		ResultSet rsmac=null;
		ResultSet rspr=null;
		ResultSet rspr1=null;
		ResultSet rsf=null;
		try{
				stmtf=conn.createStatement();
					String sqlf="select count(*) count_total from sm_facility_param";
					rsf=stmtf.executeQuery(sqlf);
					if(rsf != null)
					{     
						while(rsf.next())
						{
							count=rsf.getInt("count_total");
						}	
					}	

				    }
					catch(Exception e) 
					{
						e.printStackTrace();
				    }
				     finally 
					{
					try
					{
				      if(stmtf != null) stmtf.close();
				      if(rsf != null) rsf.close();
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
		      }


		try {

			stmt11 = conn.createStatement();
			if(function_id.equals("PRACTITIONER"))
			{     /*Below query modified for this CRF HSA-CRF-160*/
				sql11 ="select APC_NO,DEGREE_1, DEGREE_1_UNIV, DEGREE_1_YEAR, DEGREE_2, DEGREE_2_UNIV, DEGREE_2_YEAR, DEGREE_3, DEGREE_3_UNIV, DEGREE_3_YEAR, DEGREE_4, DEGREE_4_UNIV, DEGREE_4_YEAR,TRAINING_COND_BY_1, TRAINING_COND_BY_2, TRAINING_COND_BY_3, TRAINING_COND_BY_4, TRAINING_DTLS_1, TRAINING_DTLS_2, TRAINING_DTLS_3,TRAINING_DTLS_4,practitioner_id,practitioner_name,short_name,pract_type,gender,date_of_birth,place_of_birth,mar_status_code,alias_name,citizenship_code,national_id_num,credential_id1,credential_id2,credential_id3,POSITION_CODE,empl_status,employee_id,degree,primary_speciality_code,all_facilities_yn,reporting_facility_id,res_tel_num,pager_num,mobile_num,off_tel_num,off_tel_ext,fax_num,email_id,pref_contact_mode,res_add_ln1,res_add_ln2,res_add_ln3,res_add_ln4,res_add_postal_code,res_add_country_code,off_add_ln1,off_add_ln2,off_add_ln3,off_add_ln4,off_add_postal_code,off_add_country_code,mail_add_ln1,mail_add_ln2,mail_add_ln3,mail_add_ln4,mail_add_postal_code,mail_add_country_code,eff_date_from,eff_date_to,eff_status,Enable_virtual_cons,LONG_NAME,OTH_ALT_ID_TYPE,OTH_ALT_ID_NO,practitioner_long_id,fpp_pract_yn,PRACTITIONER_SIGN,supervisor_yn,PRACTITIONER_STAMP , EMPLOYEE_SERVICE_NO from am_practitioner where practitioner_id='"+practitionerid+"' ";//Modified by Thamizh selvi on 28th June 2018 against ML-MMOH-CRF-1184	
				// modified by mujafar for AAKH-CRF-0079.4 // added by manjunath for TH-KW-CRF-0161.1
			}
			else
			{
				if(function_id.equals("EXT_PRACT"))
				{    /*Below query modified for this CRF HSA-CRF-160*/
					sql11 ="select APC_NO,DEGREE_1, DEGREE_1_UNIV, DEGREE_1_YEAR, DEGREE_2, DEGREE_2_UNIV, DEGREE_2_YEAR, DEGREE_3, DEGREE_3_UNIV, DEGREE_3_YEAR, DEGREE_4, DEGREE_4_UNIV, DEGREE_4_YEAR,TRAINING_COND_BY_1, TRAINING_COND_BY_2, TRAINING_COND_BY_3, TRAINING_COND_BY_4, TRAINING_DTLS_1, TRAINING_DTLS_2, TRAINING_DTLS_3,TRAINING_DTLS_4,practitioner_id,practitioner_name,short_name,pract_type,gender,date_of_birth,place_of_birth,mar_status_code,alias_name,citizenship_code,national_id_num,credential_id1,credential_id2,credential_id3,POSITION_CODE,empl_status,employee_id,degree,primary_speciality_code,res_tel_num,pager_num,mobile_num,off_tel_num,off_tel_ext,fax_num,email_id,pref_contact_mode,res_add_ln1,res_add_ln2,res_add_ln3,res_add_ln4,res_add_postal_code,res_add_country_code,off_add_ln1,off_add_ln2,off_add_ln3,off_add_ln4,off_add_postal_code,off_add_country_code,mail_add_ln1,mail_add_ln2,mail_add_ln3,mail_add_ln4,mail_add_postal_code,mail_add_country_code,eff_date_from,eff_date_to,eff_status,Enable_virtual_cons,LONG_NAME,OTH_ALT_ID_TYPE,OTH_ALT_ID_NO,practitioner_long_id,fpp_pract_yn,PRACTITIONER_SIGN,supervisor_yn,PRACTITIONER_STAMP , EMPLOYEE_SERVICE_NO from am_ext_practitioner where practitioner_id='"+practitionerid+"' ";	//Modified by Thamizh selvi on 28th June 2018 against ML-MMOH-CRF-1184
					// modified by mujafar for AAKH-CRF-0079.4 // added by manjunath for TH-KW-CRF-0161.1
				}
			}
			rset=stmt11.executeQuery(sql11);
			rset.next();
			   	
				practitioner_sign = rset.getBinaryStream("practitioner_sign");
				if(practitioner_sign!=null)
				includevisibility = "";
				practitioner_stamp = rset.getBinaryStream("practitioner_stamp"); // added by manjunath for TH-KW-CRF-0161.1
				if(practitioner_stamp!=null)
				includevisibility1 = "";
               
				practitionerid=rset.getString("practitioner_id");
				practitionername=rset.getString("practitioner_name");
				shortname=rset.getString("short_name");
				sex=rset.getString("gender");
				employeeid=rset.getString("employee_id");
				if(employeeid == null) employeeid = "";
				apc_no = rset.getString("APC_NO");
				degree1 = rset.getString("DEGREE_1");
				if(apc_no == null) apc_no = "";
				if(degree1 == null) degree1 = "";
				degree2 = rset.getString("DEGREE_2");
				if(degree2 == null) degree2 = "";
				degree3 = rset.getString("DEGREE_3");
				if(degree3 == null) degree3 = "";
				degree4 = rset.getString("DEGREE_4");
				if(degree4 == null) degree4 = "";

				year1 = rset.getString("DEGREE_1_YEAR");
				if(year1 == null) year1 = "";
				year2 = rset.getString("DEGREE_2_YEAR");
				if(year2 == null) year2 = "";
				year3 = rset.getString("DEGREE_3_YEAR");
				if(year3 == null) year3 = "";
				year4 = rset.getString("DEGREE_4_YEAR");
				if(year4 == null) year4 = "";

				univ1 = rset.getString("DEGREE_1_UNIV");
				if(univ1 == null) univ1 = "";
				univ2 = rset.getString("DEGREE_2_UNIV");
				if(univ2 == null) univ2 = "";
				univ3 = rset.getString("DEGREE_3_UNIV");
				if(univ3 == null) univ3 = "";
				univ4 = rset.getString("DEGREE_4_UNIV");
				if(univ4 == null) univ4 = "";
				

				con1 = rset.getString("TRAINING_COND_BY_1");
				if(con1 == null) con1 = "";
				con2 = rset.getString("TRAINING_COND_BY_2");
				if(con2 == null) con2 = "";
				con3 = rset.getString("TRAINING_COND_BY_3");
				if(con3 == null) con3 = "";
				con4 = rset.getString("TRAINING_COND_BY_4");
				if(con4 == null) con4 = "";

				det1 = rset.getString("TRAINING_DTLS_1");
				if(det1 == null) det1 = "";
				det2 = rset.getString("TRAINING_DTLS_2");
				if(det2 == null) det2 = "";
				det3 = rset.getString("TRAINING_DTLS_3");
				if(det3 == null) det3 = "";
				det4 = rset.getString("TRAINING_DTLS_4");
				if(det4 == null) det4 = "";
				longname = rset.getString("LONG_NAME");
				if(longname == null) longname = "";
				/*Added by Thamizh selvi on 28 June 2018 against ML-MMOH-CRF-1184 Start*/
				fppPractYn = rset.getString("FPP_PRACT_YN");
				if(fppPractYn == null || fppPractYn.equals("null")) fppPractYn = "N";
				/*End*/

				/*Added by Dharma on 19th Aug 2020 against AAKH-CRF-0122.4 Start*/
				supervisor_yn = rset.getString("supervisor_yn");
				if(supervisor_yn == null || supervisor_yn.equals("null")) supervisor_yn = "N";
				/*End*/

				/*Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011*/
				citizen_code = rset.getString("citizenship_code");
				if (citizen_code == null || citizen_code.equals("null")) citizen_code = "";
				/*End MOHE-CRF-0011*/
			
				/*Added by lakshmanan For MO-CRF-20183.2 start*/
				
				practEmployeeServiceNo=rset.getString("employee_service_no");
					if (practEmployeeServiceNo==null || practEmployeeServiceNo.equals("null")) practEmployeeServiceNo="";
				
				/*Added by lakshmanan For MO-CRF-20183.2 end*/
			
				if(function_id.equals("PRACTITIONER"))	{
					reporting_facility_id=rset.getString("reporting_facility_id");
				}
				mar_status_code=rset.getString("mar_status_code");
			if (sex.equals("M")) 
			{
				sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				str1.append("<select name='sex' id='sex' onClick='check2()' onChange='check2()' tabindex='8' onkeyDown='shift_tab()' >");
				str1.append("<option value='M' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")+"<option value='F'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")+"<option value='U'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels")+" </select>");
				strs1="<input type='text' name='sex1' id='sex1' size='7' maxlength='7' onkeyDown='shift_tab4();' value='"+sex1+"' readonly >";
				strs2="<input type='hidden' name='sex2' id='sex2' size='15' maxlength='15' value='"+sex+"' >";
			}
			else if (sex.equals("F")) 
			{
				sex1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
				str1.append("<select name='sex' id='sex' onClick='check2()' onChange='check2()' tabindex='8' onkeyDown='shift_tab();' >");
				str1.append("<option value='M' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")+"&nbsp;<option value='F' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")+"<option value='U'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels")+"</select>");
				strs1="<input type='text' name='sex1' id='sex1' size='7' maxlength='7' onkeyDown='shift_tab4();' value='"+sex1+"' readonly>";
				strs2="<input type='hidden' name='sex2' id='sex2' size='15' maxlength='15' value='"+sex+"' >";
			}
			else if (sex.equals("U")) 
			{
				sex1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
				str1.append("<select name='sex' id='sex' onClick='check2()' onChange='check2()' tabindex='8' onkeyDown='shift_tab();' >");
				str1.append("<option value='M' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")+"&nbsp;<option value='F'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")+"<option value='U' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels")+"</select>");
				strs1="<input type='text' name='sex1' id='sex1' size='7' maxlength='7'onkeyDown='shift_tab4();' value='"+sex1+"' readonly>";
				strs2="<input type='hidden' name='sex2' id='sex2' size='15' maxlength='15' value='"+sex+"' >";
			}
				emplstatus=rset.getString("empl_status");
				

				if(emplstatus.equals("F")) 
				{
					emplstatus1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FullTime.label","common_labels");
					str5.append("<select name='empl_status' id='empl_status' onClick='check3();' onChange='check3()' tabindex='23'>");
                    str5.append("<option value=>---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----");
					stre2="<input type='hidden' name='empl_status2' id='empl_status2' size='15' maxlength='15' value='"+emplstatus+"'>";
					str5.append("<option value='S'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Associate.label","common_labels")+"&nbsp;<option value='F' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FullTime.label","common_labels")+"<option value='P'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PartTime.label","common_labels")+"<option value='V'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.VisitingSpecialist.label","am_labels")+" </select>");
					stre1="<input type='text' name='empl_status1' id='empl_status1' size='15' maxlength='15' value='"+emplstatus1+"' readonly>";
					
				}
				else if (emplstatus.equals("P")) 
				{
					emplstatus1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PartTime.label","common_labels");
					str5.append("<select name='empl_status' id='empl_status' onClick='check3();' onChange='check3()' tabindex='23'>");
					str5.append("<option value=>---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----");
					stre2="<input type='hidden' name='empl_status2' id='empl_status2' size='15' maxlength='15' value='"+emplstatus+"'>";
					str5.append("<option value='S'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Associate.label","common_labels")+"&nbsp;<option value='F' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FullTime.label","common_labels")+"<option value='P' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PartTime.label","common_labels")+"<option value='V'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.VisitingSpecialist.label","am_labels")+" </select>");
					stre1="<input type='text' name='empl_status1' id='empl_status1' size='15' maxlength='15' value='"+emplstatus1+"' readonly>";
					
				}
				else if (emplstatus.equals("V")) 
				{
					emplstatus1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Visitor.label","common_labels");
					str5.append("<select name='empl_status' id='empl_status' onClick='check3();echeck10()' onChange='check3(); echeck10();' tabindex='23'>");
					str5.append("<option value=>---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----");
					stre2="<input type='hidden' name='empl_status2' id='empl_status2' size='15' maxlength='15' value='"+emplstatus+"'>";
					str5.append("<option value='S'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Associate.label","common_labels")+"&nbsp; <option value='F' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FullTime.label","common_labels")+"<option value='P'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PartTime.label","common_labels")+"<option value='V' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.VisitingSpecialist.label","am_labels")+"</select>");
					stre1="<input type='text' name='empl_status1' id='empl_status1' size='15' maxlength='15' value='"+emplstatus1+"' readonly>";
				}
				else if(emplstatus.equals("S")) 
				{
					emplstatus1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Associate.label","common_labels");
					str5.append("<select name='empl_status' id='empl_status' onClick='check3();' onChange='check3();' tabindex='23'>");
					str5.append("<option value=>---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----");
					stre2="<input type='hidden' name='empl_status2' id='empl_status2' size='15' maxlength='15' value='"+emplstatus+"'>";
					str5.append("<option value='S' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Associate.label","common_labels")+"&nbsp; <option value='F' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FullTime.label","common_labels")+"<option value='P'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PartTime.label","common_labels")+"<option value='V' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.VisitingSpecialist.label","am_labels")+"</select>");
					stre1="<input type='text' name='empl_status1' id='empl_status1' size='15' maxlength='15' value='"+emplstatus1+"' readonly>";
				}
				prefmode=rset.getString("pref_contact_mode");
				if(prefmode != null) 
				{
					 if (prefmode.equals("R")) 
					 {	
						prefmode1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.residence.label","common_labels");
						str6.append("<select name='pref_contact_mode' id='pref_contact_mode' onClick='check4()' tabindex='34'><option value=''>-----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----");
						str6.append("<option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.email.label","common_labels")+"<option value='F'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fax.label","common_labels")+"<option value='M'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mobile.label","common_labels")+"<option value='O'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.office.label","common_labels")+"<option value='P'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Pager.label","am_labels")+"<option value='R'selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.residence.label","common_labels")+" </select>");
						strp1="<input type='text' name='pref_contact_mode1' id='pref_contact_mode1' size='15' maxlength='15' value='"+prefmode1+"' readonly>";
						strp2="<input type='hidden' name='pref_contact_mode2' id='pref_contact_mode2' size='15' maxlength='15' value='"+prefmode+"' >";
					}
					else if (prefmode.equals("O")) 
					{
						prefmode1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.office.label","common_labels");
						str6.append("<select name='pref_contact_mode' id='pref_contact_mode' onClick='check4()' tabindex='34'><option value=''>-----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----");
			str6.append("<option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.email.label","common_labels")+"<option value='F'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fax.label","common_labels")+"<option value='M'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mobile.label","common_labels")+"<option value='O' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.office.label","common_labels")+"<option value='P'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Pager.label","am_labels")+"<option value='R'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.residence.label","common_labels")+" </select>");
						strp1="<input type='text' name='pref_contact_mode1' id='pref_contact_mode1' size='15' maxlength='15' value='"+prefmode1+"' readonly>";
						strp2="<input type='hidden' name='pref_contact_mode2' id='pref_contact_mode2' size='15' maxlength='15' value='"+prefmode+"' >";
					}
					else if(prefmode.equals("F")) 
					{
						prefmode1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fax.label","common_labels");
						str6.append("<select name='pref_contact_mode' id='pref_contact_mode' onClick='check4()' tabindex='34'><option value=''>-----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----");
						str6.append("<option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.email.label","common_labels")+"<option value='F' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fax.label","common_labels")+"<option value='M'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mobile.label","common_labels")+"<option value='O'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.office.label","common_labels")+"<option value='P'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Pager.label","am_labels")+"<option value='R' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.residence.label","common_labels")+" </select>");
						strp1="<input type='text' name='pref_contact_mode1' id='pref_contact_mode1' size='15' maxlength='15' value='"+prefmode1+"' readonly>";
						strp2="<input type='hidden' name='pref_contact_mode2' id='pref_contact_mode2' size='15' maxlength='15' value='"+prefmode+"' >";
					}
					else if(prefmode.equals("M")) 
					{
						prefmode1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mobile.label","common_labels");
						str6.append("<select name='pref_contact_mode' id='pref_contact_mode' onClick='check4()' tabindex='34'><option value=''>-----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----");
						str6.append("<option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.email.label","common_labels")+"<option value='F'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fax.label","common_labels")+"<option value='M' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mobile.label","common_labels")+"<option value='O'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.office.label","common_labels")+"<option value='P'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Pager.label","am_labels")+"<option value='R' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.residence.label","common_labels")+" </select>");
						strp1="<input type='text' name='pref_contact_mode1' id='pref_contact_mode1' size='15' maxlength='15' value='"+prefmode1+"' readonly>";
						strp2="<input type='hidden' name='pref_contact_mode2' id='pref_contact_mode2' size='15' maxlength='15' value='"+prefmode+"' >";
					}
					else if(prefmode.equals("P")) 
					{
						prefmode1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Pager.label","am_labels");
						str6.append("<select name='pref_contact_mode' id='pref_contact_mode' onClick='check4()' tabindex='34'><option value=''>-----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----");
						str6.append("<option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.email.label","common_labels")+"<option value='F'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fax.label","common_labels")+"<option value='M'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mobile.label","common_labels")+"<option value='O'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.office.label","common_labels")+"<option value='P' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Pager.label","am_labels")+"<option value='R'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.residence.label","common_labels")+" </select>");
						strp1="<input type='text' name='pref_contact_mode1' id='pref_contact_mode1' size='15' maxlength='15' value='"+prefmode1+"' readonly>";
						strp2="<input type='hidden' name='pref_contact_mode2' id='pref_contact_mode2' size='15' maxlength='15' value='"+prefmode+"' >";
					}
					else if(prefmode.equals("E")) 
					{
						prefmode1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.email.label","common_labels");
						str6.append("<select name='pref_contact_mode' id='pref_contact_mode' onClick='check4()' tabindex='34'><option value=''>-----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----");
						str6.append("<option value='E' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.email.label","common_labels")+"<option value='F'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fax.label","common_labels")+"<option value='M'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mobile.label","common_labels")+"<option value='O'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.office.label","common_labels")+"<option value='P'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Pager.label","am_labels")+"<option value='R'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.residence.label","common_labels")+" </select>");
						strp1="<input type='text' name='pref_contact_mode1' id='pref_contact_mode1' size='15' maxlength='15' value='"+prefmode1+"' readonly>";
						strp2="<input type='hidden' name='pref_contact_mode2' id='pref_contact_mode2' size='15' maxlength='15' value='"+prefmode+"' >";
					}
					else if(prefmode.equals(" ") || prefmode.equals("null")) 
					{
						prefmode1="-----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----";
						str6.append("<select name='pref_contact_mode' id='pref_contact_mode' onClick='check4()' tabindex='34'><option value='' selected>-----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----");
						str6.append("<option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.email.label","common_labels")+"<option value='F'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fax.label","common_labels")+"<option value='M'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mobile.label","common_labels")+"<option value='O'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.office.label","common_labels")+"<option value='P'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Pager.label","am_labels")+"<option value='R'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.residence.label","common_labels")+" </select>");
						strp1="<input type='text' name='pref_contact_mode1' id='pref_contact_mode1' size='15' maxlength='15' value='"+prefmode1+"' readonly>";
						strp2="<input type='hidden' name='pref_contact_mode2' id='pref_contact_mode2' size='15' maxlength='15' value='"+prefmode+"' >";
					}
			     }
				 else
					{
					prefmode=" ";
					prefmode1=" ";
					str6.append("<select name='pref_contact_mode' id='pref_contact_mode' onClick='check4()' tabindex='34'><option value='' selected>-----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----");
					str6.append("<option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.email.label","common_labels")+"<option value='F'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fax.label","common_labels")+"<option value='M'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mobile.label","common_labels")+"<option value='O'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.office.label","common_labels")+"<option value='P'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Pager.label","am_labels")+"<option value='R' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.residence.label","common_labels")+" </select>");
					strp1="<input type='text' name='pref_contact_mode1' id='pref_contact_mode1' size='15' maxlength='15' value='"+prefmode1+"' readonly>";
					strp2="<input type='hidden' name='pref_contact_mode2' id='pref_contact_mode2' size='15' maxlength='15' value='"+prefmode+"' >";
			     }
			java.util.Date date2 = rset.getDate("date_of_birth");

			SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
			birthdate=formatter1.format(date2);
			birthdate_disp=DateUtils.convertDate(birthdate,"DMY","en",localeName);

			//date2 = null;
			formatter1 = null;
			stmt25=conn.createStatement();
			String sqldb="select calculate_age('"+birthdate+"',1) from dual";
			rs25=stmt25.executeQuery(sqldb);
			
			if(rs25 != null)
			{
				while(rs25.next())
				{
					bage=rs25.getString(1);
				}	
			}	
			if(bage==null) bage="0";
			stmt26=conn.createStatement();
			String sqldb1="select calculate_age('"+birthdate+"',2) from dual";
			rs26=stmt26.executeQuery(sqldb1);
			if(rs26 != null )
			{
				while(rs26.next())
				{
					bmonths=rs26.getString(1);
				}	
			}	
			if(bmonths==null) bmonths="0";
			stmt27=conn.createStatement();
			String sqldb2="select calculate_age('"+birthdate+"',3) from dual";
			rs27=stmt27.executeQuery(sqldb2);
			if(rs27 != null )
			{
				while(rs27.next())	
				{
					bdays=rs27.getString(1);
				}	
			}	
			if(bdays==null) bdays="0";
			birthplace=rset.getString("place_of_birth");
			if(birthplace == null) birthplace="";
			aliasname=rset.getString("alias_name");
			if(aliasname == null) aliasname="";
			nationalidno=rset.getString("national_id_num");

			if(nationalidno == null || nationalidno.equals("") || nationalidno.equals(" ")) nationalidno="";
			//Added on 22/04/2003 by Mallikarjuna Reddy for Credential 1,2,3
			credentialid1=rset.getString("credential_id1");
			if(credentialid1==null) credentialid1="";
			
			credentialid2=rset.getString("credential_id2");
			if(credentialid2==null) credentialid2="";

			credentialid3=rset.getString("credential_id3");
			if(credentialid3==null) credentialid3="";
			//End of Addition on 24/04/2003 by Mallikarjuna Reddy for Credential 1,2,3
			jobtitle=rset.getString("POSITION_CODE");
			if(jobtitle==null) jobtitle="";
			
			degree=rset.getString("degree");
			if(degree == null) degree="";
			
			restelnum=rset.getString("res_tel_num");
			if(restelnum==null) restelnum="";
			
			pagernum=rset.getString("pager_num");
			if(pagernum==null) pagernum="";
			
			mobilenum=rset.getString("mobile_num");
			if(mobilenum==null) mobilenum="";
			
			offtelnum=rset.getString("off_tel_num");
			if(offtelnum==null) offtelnum="";
			
			offtelext=rset.getString("off_tel_ext");
			if(offtelext==null) offtelext="";
			
			faxnum=rset.getString("fax_num");
			if(faxnum==null) faxnum="";
			
			emailid=rset.getString("email_id");
			if(emailid==null) emailid="";

			resaddln1=rset.getString("res_add_ln1");
			if(resaddln1==null) resaddln1="";

			resaddln2=rset.getString("res_add_ln2");
			if(resaddln2==null) resaddln2="";
			
			resaddln3=rset.getString("res_add_ln3");
			if(resaddln3==null) resaddln3="";
			
			resaddln4=rset.getString("res_add_ln4");
			if(resaddln4==null) resaddln4="";
			
			offaddln1=rset.getString("off_add_ln1");
			if(offaddln1==null) offaddln1="";
			
			offaddln2=rset.getString("off_add_ln2");
			if(offaddln2==null) offaddln2="";
			
			offaddln3=rset.getString("off_add_ln3");
			if(offaddln3==null) offaddln3="";
			
			offaddln4=rset.getString("off_add_ln4");
			if(offaddln4==null) offaddln4="";
			
			mailaddln1=rset.getString("mail_add_ln1");
			if(mailaddln1==null) mailaddln1="";
			
			mailaddln2=rset.getString("mail_add_ln2");
			if(mailaddln2==null) mailaddln2="";
			
			mailaddln3=rset.getString("mail_add_ln3");
			if(mailaddln3==null) mailaddln3="";
			
			mailaddln4=rset.getString("mail_add_ln4");
			if(mailaddln4==null) mailaddln4="";

         	effstatus=rset.getString("eff_status");
         	//added by Himanshu Saxena for ML-MMOH-CRF-1930(U1) Started //
         	effstatus_EVC=rset.getString("Enable_virtual_cons");
         	//added by Himanshu Saxena for ML-MMOH-CRF-1930(U1) Started //
			
			//Added for HSA-CRF-160
			other_alt_type_no=rset.getString("OTH_ALT_ID_TYPE")==null?"":rset.getString("OTH_ALT_ID_TYPE");
			other_alt_type_desc=rset.getString("OTH_ALT_ID_NO")==null?"":rset.getString("OTH_ALT_ID_NO");			
			
			//Added for this CRF ML-MMOH-CRF-0862
			cerner_prac_id=rset.getString("practitioner_long_id")==null?"":rset.getString("practitioner_long_id");
			

			if(effstatus.equals("D"))
			{
				otherTextAttribute="READONLY";
				disablerecord="disabled";
				checkBoxAttribute="";
			}
			else
			{
				otherTextAttribute="";
				checkBoxAttribute="CHECKED";
 			}
			//added by Himanshu Saxena for ML-MMOH-CRF-1930(U1) Started //
         	if(effstatus_EVC.equals("D"))
			{
				checkBoxAttribute_EVC="";
				
			}
			else
			{
				checkBoxAttribute_EVC="CHECKED";
 			}
			
			
         	//added by Himanshu Saxena for ML-MMOH-CRF-1930(U1) Started //
			if(jobtitle!="")
			{
			stmt10=conn.createStatement();
			
			String sql10="select POSITION_CODE,POSITION_DESC from am_position where POSITION_CODE='"+jobtitle+"'";
			
			rs10=stmt10.executeQuery(sql10);
              rs10.next();
            poscode=rs10.getString(1);
           	if(rs10!=null)rs10.close();
			if(stmt10!=null)stmt10.close();
			}
			stmt10=conn.createStatement();
			String sql10="select nat_id_length ,accept_national_id_no_yn,nat_id_prompt, nat_id_chk_len, nat_id_check_digit_id ,nat_data_source_id, nat_id_accept_alphanumeric_yn, alt_id1_type, alt_id1_length from mp_param";
			rs10=stmt10.executeQuery(sql10);

			if(rs10 != null)
			{		
				while(rs10.next())
				{
					str14=rs10.getString(1);
					accept_national_id_no_yn=rs10.getString(2);
					if(accept_national_id_no_yn == null) accept_national_id_no_yn="N";
					nat_id_accept_alphanumeric_yn=rs10.getString("nat_id_accept_alphanumeric_yn");
		  			if(nat_id_accept_alphanumeric_yn == null) nat_id_accept_alphanumeric_yn ="N";
					nat_id_prompt=rs10.getString(3);if(nat_id_prompt == null) nat_id_prompt=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.NationalIDNo.label","am_labels");
					nat_id_chk_len=rs10.getString(4);if(nat_id_chk_len == null) nat_id_chk_len="";
					nat_id_check_digit_id=rs10.getString(5);if(nat_id_check_digit_id == null) nat_id_check_digit_id="";
					nat_data_source_id=rs10.getString(6);if(nat_data_source_id == null) nat_data_source_id="";
					if(function_id.equals("PRACTITIONER"))
					{
					allfacilities=rset.getString("all_facilities_yn");
					}
					//Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011
					alt_id1_type = rs10.getString("alt_id1_type");if(alt_id1_type == null) alt_id1_type="";
					alt_id1_length = rs10.getString("alt_id1_length");if(alt_id1_length == null) alt_id1_length="";
				}	
			}	
			if(effstatus.equals("E") || effstatus.equals("D"))
			{
				if(allfacilities.equals("Y"))
					checkBoxAttribute1="CHECKED";
				else
					checkBoxAttribute1=" ";
			}
			respostalcode=rset.getString("res_add_postal_code");
			if(respostalcode==null || respostalcode.equals("null"))respostalcode="";

			strrep1="<input type='text' name='res_add_postal_code2' id='res_add_postal_code2' size='15' maxlength='15' value='"+respostalcode+"' readonly>";
			rescountrycode=rset.getString("res_add_country_code");
			if(rescountrycode != null)

			{
				stmtrec=conn.createStatement();
				String sqlrec="select short_name from mp_country where country_code='"+rescountrycode+"' ";
				rsrec=stmtrec.executeQuery(sqlrec);
				if(rsrec != null )
				{
					while(rsrec.next())
					{
						rescountrydesc=rsrec.getString("short_name");
					}	
				}	
			}
			else
			{
				rescountrydesc=" ";
			}

			stmt17=conn.createStatement();
			String sql17="select country_code,short_name from mp_country where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by short_name";
			rs17=stmt17.executeQuery(sql17);
			//str8="<select name='res_add_country_code' id='res_add_country_code' onClick='check9()'><option value=''>-----Select-----";
			if(rs17 !=null)
			{
			 while(rs17.next())
			 {
				//rescountrycode1=rs17.getString("country_code");
				//rescountrydesc1=rs17.getString("short_name");
				/*if((rescountrycode1.equals(rescountrycode)) && (rescountrydesc1.equals(rescountrydesc)))
				{
					str8+="<option value='"+rescountrycode1+"' selected>"+rescountrydesc1;
				}
				else 
				{
					str8+="<option value='"+rescountrycode1+"' >"+rescountrydesc1;
				}*/
			 }
			} 
			//str8+="</select>";
			
			strrec1="<input type='text' name='res_add_country_code1' id='res_add_country_code1' size='15' maxlength='15' value='"+rescountrydesc+"' readonly>";
			if(rescountrycode == null) 
			{
				strrec2="<input type='hidden' name='res_add_country_code2' id='res_add_country_code2' size='15' maxlength='15' value='' >";
			}
			else if(rescountrycode != null) 
			{
				if(effstatus.equals("E")) 
				{
					strrec2="<input type='hidden' name='res_add_country_code2' id='res_add_country_code2' size='15' maxlength='15' value='"+rescountrycode+"' >";
				}
				else if(effstatus.equals("D")) 
				{
					strrec2="<input type='hidden' name='res_add_country_code2' id='res_add_country_code2' size='15' maxlength='15' value='"+rescountrycode+"' >";
				}
			}
			offpostalcode=rset.getString("off_add_postal_code");
			if(offpostalcode==null || offpostalcode.equals("null")) offpostalcode="";

			strofp1="<input type='text' name='off_add_postal_code2' id='off_add_postal_code2' size='15' maxlength='15' value='"+offpostalcode+"' readonly>";
			offcountrycode=rset.getString("off_add_country_code");
			if(offcountrycode != null)
			{
					stmtofc=conn.createStatement();
					String sqlofc="select short_name from mp_country where country_code='"+offcountrycode+"' ";
					rsofc=stmtofc.executeQuery(sqlofc);
					if(rsofc != null)
					{
						while(rsofc.next())
						{
							offcountrydesc=rsofc.getString("short_name");
						}	
					}	
			}
			else
			{
					offcountrydesc= " ";
			}
			stmt19=conn.createStatement();
			String sql19="select country_code,short_name from mp_country where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by short_name";
			rs19=stmt19.executeQuery(sql19);
			//str10="<select name='off_add_country_code' id='off_add_country_code' onClick='check11()'><option value=''>-----Select-----";
			if(rs19 != null )
			{
			 while(rs19.next())
			 {
				//offcountrycode1=rs19.getString("country_code");
				//offcountrydesc1=rs19.getString("short_name");
				/*if((offcountrycode1.equals(offcountrycode)) && (offcountrydesc1.equals(offcountrydesc)) && (offcountrycode != null) && (!offcountrydesc.equals(" ")))
				{
					str10+="<option value='"+offcountrycode1+"' selected>"+offcountrydesc1;
				}
				else if((!offcountrycode1.equals(offcountrycode)) && (!offcountrydesc1.equals(offcountrydesc)) && (offcountrycode != null) && (!offcountrydesc.equals(" ")))
				{
					str10+="<option value='"+offcountrycode1+"' >"+offcountrydesc1;
				}
				else if((offcountrycode == null) && (offcountrydesc.equals(" ")))
				{
					str10+="<option value='"+offcountrycode1+"' >"+offcountrydesc1;
				}*/

			 }
			}
			//str10+="</select>";
			strofc1="<input type='text' name='off_add_country_code1' id='off_add_country_code1' size='15' maxlength='15' value='"+offcountrydesc+"' readonly>";
			if(offcountrycode == null)
			{
				strofc2="<input type='hidden' name='off_add_country_code2' id='off_add_country_code2' size='15' maxlength='15' value='' >";
			}
			else if(offcountrycode != null)
			{
				if(effstatus.equals("E"))
				{
				strofc2="<input type='hidden' name='off_add_country_code2' id='off_add_country_code2' size='15' maxlength='15' value='"+offcountrycode+"' >";
				}
				else if(effstatus.equals("D"))
				{
				strofc2="<input type='hidden' name='off_add_country_code2' id='off_add_country_code2' size='15' maxlength='15' value='"+offcountrycode+"' >";
				}
			}

			mailpostalcode=rset.getString("mail_add_postal_code");
			if(mailpostalcode==null || mailpostalcode.equals("null")) mailpostalcode="";
			
			
			strmap1="<input type='text' name='mail_add_postal_code2' id='mail_add_postal_code2' size='15' maxlength='15' value='"+mailpostalcode+"' readonly>";
			
			mailcountrycode=rset.getString("mail_add_country_code");
			if(mailcountrycode != null)
			{
			stmtmac=conn.createStatement();
			String sqlmac="select short_name from mp_country where country_code='"+mailcountrycode+"' ";
			rsmac=stmtmac.executeQuery(sqlmac);
			  if(rsmac != null)
			  {
			   while(rsmac.next())
			  	{
			 		mailcountrydesc =rsmac.getString("short_name");
			 	}	
			  }	
			}
			else
			{
				mailcountrydesc=" ";
			}
			stmt21=conn.createStatement();
			String sql21="select country_code,short_name from mp_country where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')))order by short_name";
			rs21=stmt21.executeQuery(sql21);
			//str12="<select name='mail_add_country_code' id='mail_add_country_code' onClick='check13()'><option value=''>-----Select-----";
			if(rs21 != null )
			{
			 while(rs21.next())
			 {
					//mailcountrycode1=rs21.getString("country_code");
					//mailcountrydesc1=rs21.getString("short_name");
					/*if((mailcountrycode1.equals(mailcountrycode)) && (mailcountrydesc1.equals(mailcountrydesc)) && (mailcountrycode != null) && (!mailcountrydesc.equals(" ")))
					{
						str12+="<option value='"+mailcountrycode1+"' selected>"+mailcountrydesc1;
					}
					else if((!mailcountrycode1.equals(mailcountrycode)) && (!mailcountrydesc1.equals(offcountrydesc)) && (offcountrycode != null) && (!offcountrydesc.equals(" ")))
					{
						str12+="<option value='"+mailcountrycode1+"' >"+mailcountrydesc1;
					}
					else if((mailcountrycode == null) && (mailcountrydesc.equals(" ")))
					{
						str12+="<option value='"+mailcountrycode1+"' >"+mailcountrydesc1;
					}*/
			 }
			} 
			//str12+="</select>";
			strmac1="<input type='text' name='mail_add_country_code1' id='mail_add_country_code1' size='15' maxlength='15' value='"+mailcountrydesc+"' readonly onBlur='document.getElementById('residencetelno').focus()'>";
			if(mailcountrycode == null)
			{
				strmac2="<input type='hidden' name='mail_add_country_code2' id='mail_add_country_code2' size='15' maxlength='15' value='' >";
			}
			else if(mailcountrycode != null)
			{
				if(effstatus.equals("E"))
				{
				strmac2="<input type='hidden' name='mail_add_country_code2' id='mail_add_country_code2' size='15' maxlength='15' value='"+mailcountrycode+"' >";
				}
				else if(effstatus.equals("D"))
				{
				strmac2="<input type='hidden' name='mail_add_country_code2' id='mail_add_country_code2' size='15' maxlength='15' value='"+mailcountrycode+"' >";
				}
			}
			
			practtype=rset.getString("pract_type");
			stmtp=conn.createStatement();
			String sqlp="select Desc_Userdef from am_pract_type where pract_type='"+practtype+"' ";
			rsp=stmtp.executeQuery(sqlp);
			
			if(rsp != null )
			{
				while(rsp.next())
				{
					practtypedesc=rsp.getString("Desc_Userdef");
				}	
			}	
			stmt12=conn.createStatement();
			String sql12 = "select pract_type,Desc_Userdef from am_pract_type where eff_status='E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by Desc_Userdef";
			rs12=stmt12.executeQuery(sql12);
			strt.append("<select name='pract_type' id='pract_type' tabindex='1' onChange='populateValues();enaDisSupervisorChkbox(this.value);validateEnablevirtualConst(this.value);' onClick='checkpract();check1();' >");			
			if(rs12 != null)
			{
			while (rs12.next())
			{
				practtype1=rs12.getString("pract_type");
				practtypedesc1=rs12.getString("Desc_Userdef");
				if((practtype1.equals(practtype)) && (practtypedesc1.equals(practtypedesc)))
				{
					strt.append("<option value='"+practtype1+"' selected>"+practtypedesc1);
					
					if(effstatus.equals("E"))
					{

						strt2="<input type='hidden' name='pract_type3' id='pract_type3' size='15' maxlength='15' value='"+practtype+"'>";
					}
				}
				else if((!practtype1.equals(practtype)) && (!practtypedesc1.equals(practtypedesc)))
				{
					strt.append("<option value='"+practtype1+"'>"+practtypedesc1);
					if(effstatus.equals("E"))
					{
						strt2="<input type='hidden' name='pract_type3' id='pract_type3' size='15' maxlength='15' value='"+practtype+"'>";
					}
					
				}
			 }
		    }
			strt.append("<option value=''>---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----");
			strt.append("</select>");
			
			strt1="<input type='text' name='pract_type2' id='pract_type2' size='15' maxlength='15' tabindex='1' value='"+practtypedesc+"' readonly>";
 			if(effstatus.equals("D"))
 			{
 				strt2="<input type='hidden' name='pract_type3' id='pract_type3' size='15' maxlength='15' value='"+practtype+"'>";
 			}
 			
			citizen=rset.getString("citizenship_code");
			if (citizen == null || citizen.equals("null")) citizen="";
			if(!citizen.equals(""))
 			{
 				stmtc=conn.createStatement();
 				String sqlc="select long_desc from mp_country where country_code='"+citizen+"' ";
 				rsc=stmtc.executeQuery(sqlc);
 				if(rsc != null )
 				{
 					while(rsc.next())
 					{
 						citizendesc = rsc.getString("long_desc");
						if(citizendesc==null)citizendesc="";
 					}	
 				}if(rsc != null) rsc.close();
				if(stmtc != null) stmtc.close();	
 			}
 			else
 			{
 				citizendesc="";
 			}
			if(!citizen.equals("")) cnc = citizen;
			if(!citizendesc.equals("")) cncdesc = citizendesc;
			
 			stmt14=conn.createStatement();
 			String sql14="select country_code,long_desc from mp_country where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) and long_desc is not null order by long_desc";
 			rs14=stmt14.executeQuery(sql14);
 			//str3="<select name='citizen' id='citizen' onClick='check6()'><option value=''>-----Select-----";
 			if(rs14 != null)
 			{
 			while (rs14.next())
 			{
 				citizen1=rs14.getString("country_code");
 				if(citizen1 == null) citizen1="";
 				citizendesc1=rs14.getString("long_desc");
 				if (citizendesc1==null)citizendesc1="";
 				/*if((citizen1.equals(citizen)) && (citizendesc1.equals(citizendesc)) && (citizen != null) && (!citizendesc.equals(" ")))
 				{
					str3+="<option value='"+citizen1+"' selected>"+citizendesc1;
 				}
 				else if((!citizen1.equals(citizen)) && (!citizendesc1.equals(citizendesc)) && (citizen != null) && (!citizendesc.equals(" ")))
 				{
					str3+="<option value='"+citizen1+"'>"+citizendesc1;
 				}
 				else if((citizen == null) && (citizendesc.equals("")))
 				{
					str3+="<option value='"+citizen1+"'>"+citizendesc1;
 				}*/
 			 }
 			}
			//str3+="</select>";
 			strc1="<input type='text' name='citizen1' id='citizen1' size='15' maxlength='15' value='"+citizendesc+"' readonly>";
 			if(citizen==null)
 			{
 			strc2="<input type='hidden' name='citizen2' id='citizen2' size='15' maxlength='15' value=''>";
 			}
 			else if(citizen != null)
 			{

 			if(effstatus.equals("E"))
 			{
 			strc2="<input type='hidden' name='citizen2' id='citizen2' size='15' maxlength='15' value='"+citizen+"'>";
 			}
 			else if(effstatus.equals("D"))
 			{
 			strc2="<input type='hidden' name='citizen2' id='citizen2' size='15' maxlength='15' value='"+citizen+"'>";
 			}

 			}
 			prspcode=rset.getString("primary_speciality_code");
 			stmtpr1=conn.createStatement();
			String sqlpr1="select speciality_code,short_desc,multi_speciality_yn from am_speciality where speciality_code='"+prspcode+"' ";
			rspr1=stmtpr1.executeQuery(sqlpr1);
			if(rspr1 != null)
			{
			 while(rspr1.next())
			 {
 				prspdesc = rspr1.getString("short_desc");
 				multi_speciality_yn = rspr1.getString("multi_speciality_yn")==null?"N":rspr1.getString("multi_speciality_yn");//Added for the CRF - Bru-HIMS-CRF-0198
			 }
			} 
			//Added for the CRF - Bru-HIMS-CRF-0198 - start
			if(multi_speciality_yn.equals("Y")){
				multi_Spec_disabled="disabled";
			}
			//Added for the CRF - Bru-HIMS-CRF-0198 - End

			stmtpr=conn.createStatement();
			String sqlpr="select speciality_code,short_desc from am_speciality where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by short_desc ";

			rspr=stmtpr.executeQuery(sqlpr);
			str15.append("<select name='primary_speciality_code' id='primary_speciality_code' onClick='check14()' onChange='check14()' "+multi_Spec_disabled +" tabindex='7'><option value=''>-------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"------");//modified for the CRF - Bru-HIMS-CRF - 0198
						
			if(rspr != null)
			{
			 while(rspr.next())	
			 {
				prspcode1=rspr.getString("speciality_code");
				prspdesc1=rspr.getString("short_desc");
				if( prspcode1.equals(prspcode)&&
					prspdesc1.equals(prspdesc)){
				str15.append("<option value='"+prspcode1+"'selected >"+prspdesc1);
				} else
				str15.append("<option value='"+prspcode1+"' >"+prspdesc1);
			    
			 }
			} 
			str15.append("</select>");
			strpr1="<input type='text' name='primary_speciality_code1' id='primary_speciality_code1' value='"+prspdesc+"' readonly tabindex='7'>";
			strpr2="<input type='hidden' name='primary_speciality_code2' id='primary_speciality_code2' size='15' maxlength='15' value='"+prspcode+"'>";

			java.sql.Statement stmt_res=null;
			ResultSet rs_res=null;
			stmt_res=conn.createStatement();
			if(respostalcode !=null)
			{
			String sql_res="select short_desc from mp_postal_code where postal_code='"+respostalcode+"' ";
			
			rs_res=stmt_res.executeQuery(sql_res);
			if(rs_res != null && rs_res.next() )
				{
					respostaldesc=rs_res.getString("short_desc");
				}
				if(rs_res!=null)rs_res.close();
				if(stmt_res!=null)stmt_res.close();
			}
			if(offpostalcode !=null)
			{
				stmt_res =conn.createStatement();
				String sql_res="select short_desc from mp_postal_code where postal_code='"+offpostalcode+"' ";
			
				rs_res=stmt_res.executeQuery(sql_res);
				if(rs_res != null && rs_res.next() )
				{
					offpostaldesc=rs_res.getString("short_desc");
				}
				if(rs_res!=null)rs_res.close();
				if(stmt_res!=null)stmt_res.close();
			}
			if(mailpostalcode !=null)
			{
				stmt_res =conn.createStatement();
				String sql_res="select short_desc from mp_postal_code where postal_code='"+mailpostalcode+"' ";
			
				rs_res=stmt_res.executeQuery(sql_res);
				if(rs_res != null && rs_res.next() )
				{
					mailpostaldesc=rs_res.getString("short_desc");
				}
				if(rs_res!=null)rs_res.close();
				if(stmt_res!=null)stmt_res.close();
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
				{
			if(stmt10 != null) stmt10.close();
			if(stmt11 != null) stmt11.close();
			if(stmt12 != null) stmt12.close();
			if(stmt13 != null) stmt13.close();
			if(stmt14 != null) stmt14.close();
			if(stmt15 != null) stmt15.close();
			if(stmt16 != null) stmt16.close();
			if(stmt17 != null) stmt17.close();
			if(stmt18 != null) stmt18.close();
			if(stmt19 != null) stmt19.close();
			if(stmt20 != null) stmt20.close();
			if(stmt21 != null) stmt21.close();
			if(stmt22 != null) stmt22.close();
			if(stmt23 != null) stmt23.close();
			if(stmt24 != null) stmt24.close();
			if(stmt25 != null) stmt25.close();
			if(stmt26 != null) stmt26.close();
			if(stmt27 != null) stmt27.close();
			if(stmtp != null) stmtp.close();
			if(stmtm != null) stmtm.close();
			if(stmtr != null) stmtr.close();
			if(stmtrep != null) stmtrep.close();
			if(stmtrec != null) stmtrec.close();
			if(stmtofp != null) stmtofp.close();
			if(stmtofc != null) stmtofc.close();
			if(stmtmap != null) stmtmap.close();
			if(stmtmac != null) stmtmac.close();
			if(stmtpr != null) stmtpr.close();
			if(stmtpr1 != null) stmtpr1.close();

			if(rset != null) rset.close();
			if(rs10 != null) rs10.close();
			if(rs12 != null) rs12.close();
			if(rs13 != null) rs13.close();
			if(rs14 != null) rs14.close();
			if(rs15 != null) rs15.close();
			if(rs16 != null) rs16.close();
			if(rs17 != null) rs17.close();
			if(rs18 != null) rs18.close();
			if(rs19 != null) rs19.close();
			if(rs20 != null) rs20.close();
			if(rs21 != null) rs21.close();
			if(rs22 != null) rs22.close();
			if(rs23 != null) rs23.close();
			if(rs24 != null) rs24.close();
			if(rs25 != null) rs25.close();
			if(rs26 != null) rs26.close();
			if(rs27 != null) rs27.close();

			if(rsp != null) rsp.close();
			if(rsm != null) rsm.close();
			if(rsc != null) rsc.close();
			if(rsr != null) rsr.close();
			if(rsrep != null) rsrep.close();
			if(rsrec != null) rsrec.close();
			if(rsofp != null) rsofp.close();
			if(rsofc != null) rsofc.close();
			if(rsmap != null) rsmap.close();
			if(rsmac != null) rsmac.close();
			if(rspr != null) rspr.close();
			if(rspr1 != null) rspr1.close();
			}

			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
			codeTextAttribute="READONLY";
			disableextn="disabled";

			newPractitioner=false;
 			eventFunctionForCase="";
	}		
		if(!(practitionerid.equals(""))){
		%>
<body onLoad="populateValue1();changeFocus10(); check();if(parent.frames[1].document.getElementById('identitylink')){parent.frames[1].document.getElementById('identitylink').scrollIntoView();}" onSelect = "resMove()" OnMouseDown='CodeArrest()' onkeydown="setShift();lockKey()" onKeyPress='return ChkKey(event);' > 
<%}else
			{%>
<body onLoad="FocusFirstElement(); changeFocus(); check();if(parent.frames[1].document.getElementById('identitylink')){parent.frames[1].document.getElementById('identitylink').scrollIntoView();}" onSelect = "resMove()" OnMouseDown='CodeArrest()' onkeydown="setShift();lockKey()" onKeyPress='return ChkKey(event);'> 
			
		<%	}
		if(fcall.equals("nocall")){%>
<form name='practitioner_form' id='practitioner_form' >
<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
<tr>
	<td class='label' width="20%"><fmt:message key="Common.type.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td class='fields' width="28%" colspan='2'>
<%	
		if(effstatus.equals("E")) 
	{
	
%>		<%=strt%><%=strt2%>
		<img src='../../eCommon/images/mandatory.gif' align='center'></img>
		
<%	}
	else if(effstatus.equals("D")) {%>
	<%=strt1%><%=strt2%><img src='../../eCommon/images/mandatory.gif' align='center'></img>
	<%}%>
	</td>
	<!--Below line added for ML-MMOH-CRF-0862 -->
	<!--<td class='label' width="13%">&nbsp;</td>-->
	<td class='label' width="18%"><%if(isCernerpractitioner){%><fmt:message key="Common.CernerId.label" bundle="${common_labels}"/>&nbsp;<%}%>&nbsp;</td>
	<td class='label' width="14%">&nbsp;<%if(isCernerpractitioner){%>
	<input type='text' name='cerner_practitioner_id1' id='cerner_practitioner_id1' size='42' maxlength='30' value="<%=cerner_prac_id%>" onkeyup="javascript:RemoveSpecialChar(this)"  tabindex='2' /><%}%>&nbsp;</td>
	<td class='label' width="15%">&nbsp;</td>
	<!--End this CRF ML-MMOH-CRF-0862 -->
</tr>
<tr>
	<td   class='label' ><%if(isCernerpractitioner){%><fmt:message key="Common.EmId.label" bundle="${common_labels}"/><%}else{%><fmt:message key="Common.identification.label" bundle="${common_labels}"/><%}%>
	</td>
	<td class='fields' colspan='2'>
		<input type='text' name='practitioner_id' id='practitioner_id' <%if(isSplCharNotAllowApplYN){%> onKeyPress="return CheckForSpecCharsValidation2(event)" <%}else{%> onKeyPress="return CheckForSpecChars(event)"  <%}%> tabindex='2' size='15' maxlength='15' value="<%=practitionerid%>" <%=codeTextAttribute%> <%=eventFunctionForCase%> ><!--Modified by Suji Keerthi for MOHE-CRF-0113 US001-->
		<img src='../../eCommon/images/mandatory.gif' align='center'></img>
	</td>
	
	<!--<td class='label'>&nbsp;</td>-->
	<td class='label'><fmt:message key="Common.ExternalPractitioner.label" bundle="${common_labels}"/></td>
	<td class='label'><input type='checkbox'  <%=disableextn%>  <%=chkvalue1%> name='changeext' tabindex='3' onClick="changeToextn(this);"></td>
	<td class='label'>&nbsp;</td>
</tr>
<tr>
	<td class='label'  ><fmt:message key="Common.FullName.label" bundle="${common_labels}"/>&nbsp;&nbsp;
	</td>
	<td class='fields' colspan='2'>
		<input type='text' <%if(isSplCharNotAllowApplYN){%> onKeyPress="return CheckForSpecCharsValidation1(event)" onBlur='CheckSplCharsValidation(this); makeValidString(this);' <%}else{%> onBlur="makeValidString(this)" <%}%> name='practitioner_name' size='30' maxlength='30' value="<%=practitionername%>" <%=otherTextAttribute%> tabindex='4'><!--Modified by Suji Keerthi for MOHE-CRF-0113 US001-->
		<img src='../../eCommon/images/mandatory.gif' align='center'></img>	</td>
	<!--<td class='label'  >&nbsp;</td>-->
	<td class='label' ><fmt:message key="Common.shortname.label" bundle="${common_labels}"/>&nbsp;</td>
	<td class='label' colspan="2">&nbsp;<input type='text' <%if(isSplCharNotAllowApplYN){%> onKeyPress="return CheckForSpecCharsValidation1(event)" onBlur='CheckSplCharsValidation(this); makeValidString(this);' <%}else{%> onBlur="makeValidString(this)" <%}%> name='short_name' size='<%=shortdescMaxSize%>' maxlength='<%=shortdescMaxLength%>' value="<%=shortname%>" <%=otherTextAttribute%> tabindex='5' ><img src='../../eCommon/images/mandatory.gif' align='center'></img>&nbsp;</td><!--Modified by Suji Keerthi for MOHE-CRF-0113 US001-->
	<!--<td class='label'>&nbsp;</td>-->
</tr>
<%if(!(longname.equals("")))
{
int len = longname.length();
int i1=0;
int n_incre = 0;
int max = 0;

if (len > 75) 
{ 
    for ( i1=0; i1 <= (len/75);i1++) 
	{   
		if((i1+1)*75 < len)
			max = (i1+1)*75;
		 else
		  max = len;
		
		longname1=longname1+""+longname.substring((i1*75),max);
		n_incre = 1;
    }}
else  {
	longname1=longname;
 }} %>
<tr>

<style>
textarea {
  resize: none;
}
</style>
<td class="label"width="20%"><fmt:message key="Common.longname.label" bundle="${common_labels}"/></td>
<td <% if(isFPPPractApplicable || isCoderDiagAppl){ %> colspan='2'<%}else{%> colspan='5' <%}%> class='fields'><textarea name='long_name'  id='long_name' rows='4' cols='72' <%if(isSplCharNotAllowApplYN){%> onKeyPress="return CheckForSpecCharsValidation1(event); checkMaxLimit(this,"300");" onBlur='CheckSplCharsValidation(this); return maxLength(this,"300");' onpaste='return maxLengthPaste(this,"300");' <%}else{%>  onKeyPress='checkMaxLimit(this,"300");' <%}%><%=otherTextAttribute%> tabindex='6'>
<%=longname1%></textarea><!--Modified by Suji Keerthi for MOHE-CRF-0113 US001-->				
</td>
<!--Added by Thamizh selvi on 28 June 2018 against ML-MMOH-CRF-1184 Start-->
<% if(isFPPPractApplicable){ %>
<td class='label'>
	<fmt:message key="Common.FullPayngPatient.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>&nbsp;(<fmt:message key="Common.FPP.label" bundle="${common_labels}"/>)
</td>
<td class='label'>
	<input type='checkbox' name='FPPPract' id='FPPPract' tabindex='7' <%if(fppPractYn.equals("Y")){%> checked <%}%> value='<%=fppPractYn%>'>
</td>
<td class='label'>&nbsp;</td>
<% } %>
<!--Added by Dharma 19th Aug 2020 against AAKH-CRF-0122.4 Start-->
<% if(isCoderDiagAppl){ %>
<td class='label' align="left">
	<fmt:message key="eAM.Supervisor.label" bundle="${am_labels}"/>
</td>
<td class='label'>
	<input type='checkbox' name='supervisorchk' id='supervisorchk' tabindex='7' <%if(!practtype.equals("MA")){%> disabled <%}%><%if(supervisor_yn.equals("Y")){%> checked <%}%> value='Y'>
</td>
<td class='label'>&nbsp;</td>
<% } %>
<!--End-->
<!--<td class='label'  >&nbsp;</td>
	<td class='fields' ></td>
	<td class='label'  >&nbsp;</td>
	<td class='fields' ></td>-->
	</tr>
<tr>
	<td class='label' ><fmt:message key="Common.primaryspeciality.label" bundle="${common_labels}"/>&nbsp;</td>
		<td class='fields' colspan='2'>
		<%if(effstatus.equals("E")) {%>
			<%=str15%><%=strpr2%>
		<%}
		else if(effstatus.equals("D")) {%>
			<%=strpr1%><%=strpr2%>
		<%}%>
		<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
	<!--<td  class='label'>&nbsp;</td>-->
	<td class='label' ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td class='label'><input type='checkbox' name='eff_status' id='eff_status' tabindex='8' value="<%=effstatus%>" <%=checkBoxAttribute%> onClick="change(<%=totApptCount%>);changeFocus() " onBlur='changeFocus10();'></td>
	<td class='label'>&nbsp;</td>
</tr>

<!--added by Himanshu Saxena for ML-MMOH-CRF-1930 (U1) on 17-04-2023 Started -->
<%
if(isVIRTUAL_CONSULTATION)
{
	if(practtype.equals("MD")) // Only for Physician
	{
		disable_checkbox="";
	}
	else
	{
		disable_checkbox="display:none;";
	}
%>

	<tr id='pract_Physician_div' style=<%=disable_checkbox %>>
		<td class='label'>&nbsp;</td><td class='label'>&nbsp;</td><td class='label'>&nbsp;</td>
		<td class='label' ><fmt:message key="Common.Enable.label" bundle="${common_labels}"/> <fmt:message key="Common.virtualConsultation.label" bundle="${common_labels}"/></td>
		<td class='label'><input type='checkbox' name='enable_virtual_consultation' id='enable_virtual_consultation' id='enable_virtual_consultation'  value="<%=effstatus_EVC%>" <%=checkBoxAttribute_EVC%> onclick="changevalue()" tabindex='8'></td>
		<td class='label'>&nbsp;</td>
	</tr>

<%
}else
{
	%>
	<input type='hidden' name='enable_virtual_consultation' id='enable_virtual_consultation' id='enable_virtual_consultation' value="D">	
	<%
}
%>
<!--added by Himanshu Saxena for ML-MMOH-CRF-1930 (U1) on 17-04-2023 End -->

<tr><td colspan='6'>
<ul id="tablist" class="tablist" style="padding-left:0px" >
			<li class="tablistitem" title="Demographic details">
				<a onclick="tab_click2('demogrp_tab')" class="tabClicked" id="demogrp_tab" >
					<span class="tabSpanclicked" id="demogrp_tabspan"><fmt:message key="Common.Identity.label" bundle="${common_labels}"/></span>
				</a>
			</li>
		
			<li class="tablistitem" title="Other details">
				<a onclick="tab_click2('others_tab')" class="tabA" id="others_tab" >
					<span class="tabAspan" id="others_tabspan"><fmt:message key="Common.ContactNoAddr.label" bundle="${common_labels}"/></span>
				</a>
			</li>	

				<li class="tablistitem" title="Financial details">
				<a onclick="tab_click2('findtl_tab')" class="tabA" id="findtl_tab" >
					<span class="tabAspan" id="findtl_tabspan"><fmt:message key="Common.QualificationTraining.label" bundle="${common_labels}"/></span>
				</a>
			</li>	
		</ul>
</td></tr>
</table>
</form>
<%}%>
					<script>prevTabObj='demogrp_tab';</script>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<form name='practitioner1_form' id='practitioner1_form'    action='../../servlet/eAM.PractitionerServlet'  method='post' enctype = 'multipart/form-data' target='messageFrame'> <!-- multiform added by mujafar for AAKH-CRF-0079.4 -->
<a name='identitylink' id='identitylink'></a>
<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center' valign='top'  name='sub_tab1' id='sub_tab1'>

<tr>
   <td width="100%" class="Border">
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr>
	<td  class='label' width='20%'><fmt:message key="Common.gender.label" bundle="${common_labels}"/>&nbsp;&nbsp;
	</td>
	<td class='fields' >
	<%if(effstatus.equals("E")) {%>
		<%=str1%><%=strs2%>
	<%}
	else if(effstatus.equals("D")) {%>
		<%=strs1%><%=strs2%>
	<%}%>
		<img src='../../eCommon/images/mandatory.gif' align='center'></img>
	
	<td class='label'>&nbsp;</td>
	<td class='label'>&nbsp;</td>
	<input type="hidden" name="max_pa_age" id="max_pa_age" value="120">

</tr>
<tr>

	<td  class='label'><fmt:message key="Common.age.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td class='fields'>
		<%
		if(effstatus.equals("D")) {
		%>
		<input type="text" name="b_age" id="b_age" maxlength="3" size="3" value='<%=bage%>' tabindex='9' onKeyPress='return  allowValidNumber(this,event,3,0);' onChange='calculateAge(this,2)' disabled onblur='chkY(this)'>&nbsp;Y&nbsp;
		<input type="text" name="b_months" id="b_months" maxlength="2" value='<%=bmonths%>' size="2" tabindex='10' onKeyPress='return  allowValidNumber(this,event,2,0);' onChange='calculateAge(this,2)' disabled >&nbsp;M&nbsp;
		<input type="text" name="b_days" id="b_days" maxlength="2" size="2" value='<%=bdays%>' tabindex='11' onKeyPress='return  allowValidNumber(this,event,2,0);' onChange='calculateAge(this,2)'  disabled>&nbsp;D&nbsp;
		<%
		}else{
		%>
		<input type="text" name="b_age" id="b_age" maxlength="3" size="3" value='<%=bage%>' tabindex='9'  onKeyPress='return  allowValidNumber(this,event,3,0);' onChange='calculateAge(this,2)' onblur='chkY(this)'>&nbsp;Y&nbsp;
		<input type="text" name="b_months" id="b_months" maxlength="2" value='<%=bmonths%>' size="2" onKeyPress='return  allowValidNumber(this,event,2,0);' tabindex='10' onBlur='calculateAge(this,2)' >&nbsp;M&nbsp;
		<input type="text" name="b_days" id="b_days" maxlength="2" size="2" tabindex='11' value='<%=bdays%>'onKeyPress='return  allowValidNumber(this,event,2,0);' onBlur='calculateAge(this,2)'  >&nbsp;D&nbsp;
		<%
		}
		%>
	</td>
	<td  class='label' width='22%'><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td  class='fields' width='34%' >
	<input type='hidden' name='ServerDate' id='ServerDate' value='<%=str13%>'>	
	<!-- <input type="text" name="date_of_birth" id="date_of_birth" maxlength="10" size="8"  value='<%=birthdate%>' onBlur='calcage(this,ServerDate)'  <%=otherTextAttribute%> <%=disablerecord%> > -->
	<input type='hidden' name='greg_date_of_birth' id='greg_date_of_birth' value="">
	<input type='hidden' name='greg_date_of_birth_mod' id='greg_date_of_birth_mod' value="<%=birthdate%>">
	<input type="text" name="date_of_birth" id="date_of_birth" maxlength="10" size="8" tabindex='12' value='<%=birthdate_disp%>' onblur='calculateAge(this,1);'  <%=otherTextAttribute%> <%=disablerecord%>><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('date_of_birth');" <%=disablerecord%> >&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>
	</td>
</tr>
<tr>
	<td  class='label' width='12%'><fmt:message key="Common.birthPlace.label" bundle="${common_labels}"/>&nbsp;&nbsp;	</td>
	<td  class='fields' width='30%'>
		<input type='text' name="birth_place" id="birth_place" onBlur="makeValidString(this)" maxlength='30' size='30' tabindex='13' value="<%=birthplace%>" <%=otherTextAttribute%> >
	</td>

		<td class='label'><fmt:message key="eMP.maritalstatus.label" bundle="${mp_labels}"/> &nbsp;&nbsp;</td>
	<td class='fields' ><select name='marital_status' id='marital_status' tabindex='26' id="idrep_facility" onBlur='changeFocus1()'><option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option><%
	stmt=conn.createStatement();
	String sql="select mar_status_code,short_desc from mp_marital_status where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by short_desc ";
	rs=stmt.executeQuery(sql);
	String maritalstatusSelected="";
	while(rs.next()){
		maritalstatus=rs.getString("mar_status_code")==null?"":rs.getString("mar_status_code");
		maritaldesc=rs.getString("short_desc")==null?"":rs.getString("short_desc");	 
		 if(maritalstatus.equals(mar_status_code)){
			maritalstatusSelected="selected";
		}else{
			maritalstatusSelected="";
		}		
	 
	 %>
	 <option value="<%=maritalstatus%>" <%=maritalstatusSelected%>><%=maritaldesc%></option>
	 
	 <%}%>
	
	</td>	
</tr>
<tr>
<td colspan='4'>&nbsp</td>
</tr>
</table>
</td>
</tr>
</table>
<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center' valign='top'  name='sub_tab' id='sub_tab'>
<th>&nbsp;</th>
<tr>
<td width="100%" class="Border">
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr>
	<td class='label' colspan='4'>&nbsp;</td>
<tr>

<!--Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011-->
<%if(isResidencyApplYN){
	
	if(natid_mand_yn.equals("Y"))
	{
		nat_visibility = "visible";
	}else
	{
		nat_visibility = "hidden";
	}

	if(!citizen_code.equals(""))
	{
		if(citizen_nat_code.equals(citizen_code))
		{
			citizenChk = "Checked";
			natIdDis = "";
			if(!other_alt_type_no.equals(""))
			{
				other_alt_no_dis = "";
			}else
			{
				other_alt_no_dis = "disabled";
			}
			if(natid_mand_yn.equals("Y"))
			{
				nat_visibility = "visible";
			}
		}else
		{
			nonCitizenChk = "Checked";
			natIdDis = "disabled";
			nationalidno = "";
			nat_visibility = "hidden";
			if(alt_id1_type.equals(oth_alt_val))
			{
				oth_alt_length = alt_id1_length;
			}else
			{
				oth_alt_length = "20";
			}
			if(!oth_alt_val.equals(""))
			{
				if(oth_alt_val.equals(other_alt_type_no))
				{
					other_alt_type_no = oth_alt_val;
					other_alt_type_dis = "disabled";
					other_alt_no_dis = "";
					oth_alt_visibility = "visible";
				}else
				{
					other_alt_type_no = oth_alt_val;
					other_alt_type_dis = "disabled";
					other_alt_type_desc = "";
					other_alt_no_dis = "";
					oth_alt_visibility = "visible";
				}
			}else
			{
				other_alt_type_no = "";
				other_alt_type_dis = "disabled";
				other_alt_type_desc = "";
				other_alt_no_dis = "disabled";
			}
		}
	}
	
	if(effstatus.equals("D"))
	{
		other_alt_type_dis = "disabled";
		other_alt_no_dis = "disabled";
	}
%>
<tr>
	<td class="label" colspan='2'>&nbsp;</td>
	<td class="label"><fmt:message key="Common.residency.label" bundle="${common_labels}"/></td>
	<td>
		<table width='53%'>
			<tr>
				<td class="oaBorder" nowrap>
				<%if(effstatus.equals("E")){%>
					<input type='radio' name='res_citizen' id='res_citizen' <%=citizenChk%> 
					onClick='validateCitizen("<%=citizen_nat_desc%>","<%=citizen_nat_code%>");'><fmt:message key="Common.citizen.label" bundle="${common_labels}"/>
					<input type='radio' name='res_citizen' id='res_citizen' <%=nonCitizenChk%> 
					onClick='validateNonCitizen("<%=cncdesc%>","<%=cnc%>");'><fmt:message key="Common.noncitizen.label" bundle="${common_labels}"/>
				<%}else if(effstatus.equals("D")){%>
					<input type='radio' name='res_citizen' id='res_citizen' <%=citizenChk%> disabled><fmt:message key="Common.citizen.label" bundle="${common_labels}"/>
					<input type='radio' name='res_citizen' id='res_citizen' <%=nonCitizenChk%> disabled><fmt:message key="Common.noncitizen.label" bundle="${common_labels}"/>
				<%}%>
				</td>
				<td width='15%'>&nbsp;</td>
			</tr>
		</table>
	</td>
</tr>
<%}%>
<!--End MOHE-CRF-0011-->

<tr>
	<td class='label' width=20% ><fmt:message key="eMP.AliasName.label" bundle="${mp_labels}"/>&nbsp;&nbsp;</td>
	<td class='fields' width=30% >
		<input type='text' name="alias_name" id="alias_name" onBlur="makeValidString(this)" tabindex='15' maxlength='25' size='25' value="<%=aliasname%>" <%=otherTextAttribute%> >
	</td>
	<td  class='label' width='23%'><fmt:message key="Common.Citizenship.label" bundle="${common_labels}"/>&nbsp;&nbsp;
	</td><td class='fields'  width='32%'>
	<% if(effstatus.equals("E")) 
	{ 
		%>
		<!--Modified by Ashwini on 20-Mar-2020 for MOHE-CRF-0011-->
		<input type='text' name='citizenshipDesc' id='citizenshipDesc' size='15' tabindex='16' value="<%=cncdesc%>" onblur='if(this.value != "") searchCitizenship(this,citizenshipDesc);<%if(isResidencyApplYN){%>checkCitznOrNonCitzn();<%}%>'><input type='button' name='citizenshipButton' id='citizenshipButton' value='?' tabindex='16' class='button' onclick='searchCitizenship(this,citizenshipDesc)'><input type='hidden' name='citizen' id='citizen' value="<%=cnc%>"><%=strc2%>&nbsp;
		<!--Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011-->
		<%if(isResidencyApplYN){%><img src='../../eCommon/images/mandatory.gif' align='center'></img><%}%>
	<%}
	else if(effstatus.equals("D")) {%>
		<%=strc1%><%=strc2%>&nbsp;
	<%}%>
	</td>
</tr>
<tr>
	<%if(accept_national_id_no_yn.equals("Y")){
		
			String nat_id_onKeyPress="";

					/*
					if ( nat_id_check_digit_id.equals("M11") )
						nat_id_onKeyPress = "return CheckForCharsNatID(event);";
					else
						nat_id_onKeyPress = "return  allowValidNumber(this,event,'"+str14+"',0);";
					*/

					if(nat_id_accept_alphanumeric_yn.equals("Y"))
					{
						nat_id_onKeyPress = "CheckForAlphaCharsNatID(event);";
					}
					else
					{
						if(nat_id_check_digit_id.equals("M11"))
							nat_id_onKeyPress = "CheckForCharsNatID(event);";
						else
							nat_id_onKeyPress = "allowValidNumber(this,event,'"+str14+"', 0);";
					}
		
		%>
	<td  class='label'><%=nat_id_prompt%>&nbsp;&nbsp;
	</td>
	<td class='fields' >
		<!--Modified by Ashwini on 20-Mar-2020 for MOHE-CRF-0011-->
		<input type='text' name="national_id_no" id="national_id_no" maxlength='<%=str14%>' <%=natIdDis%> onBlur="makeValidString(this);validateNationality(this,'<%=nat_id_prompt%>','<%=nat_id_check_digit_id%>');" tabindex='17' size='15' value="<%=nationalidno%>" <%=otherTextAttribute%>  
		onKeyPress="return <%=nat_id_onKeyPress%>">
		<!--Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011-->
		<%if(isResidencyApplYN && effstatus.equals("E")){%><img name='nat_mandatory' style='visibility:<%=nat_visibility%>' src='../../eCommon/images/mandatory.gif'><%}%>
		<input type='hidden' name='oldnationalid' id='oldnationalid' value="<%=nationalidno%>">
	</td> <!--Added HSA-CRF-160 -->
	<td class='label'><fmt:message key="eMP.OtherAltNo.label" bundle="${mp_labels}"/> &nbsp;&nbsp;</td>
	<td class='fields' nowrap><select name="other_alt_type" id="other_alt_type" onchange="enabledOtherAltId()" <%=other_alt_type_dis%>><option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option><%
	 String alt_no="select alt_id_type, long_desc from mp_alternate_id_type where eff_Status='E' order by alt_id_type";
	 other_altstat=conn.createStatement();
	 other_altrs=other_altstat.executeQuery(alt_no);
	 while(other_altrs.next()){
	 alt_type_code=other_altrs.getString("alt_id_type")==null?"":other_altrs.getString("alt_id_type");
	 alt_type_desc=other_altrs.getString("long_desc")==null?"":other_altrs.getString("long_desc");
	 if(alt_type_code.equals(other_alt_type_no)){
	  other_alt_select="selected";
	 }else{
	    other_alt_select="";
      }		
	 
	 %>
	  <!--Modified by Ashwini on 20-Mar-2020 for MOHE-CRF-0011-->
	 <option value="<%=alt_type_code%>" <%=other_alt_select%>><%=alt_type_desc%></option>	 
	 <%}%></select><input type='text' name="other_alt_no" id="other_alt_no" onBlur="makeValidString(this);<%if(isResidencyApplYN && effstatus.equals("E")){%>duplicateOthAltIdValidation(this,'<%=oth_alt_val%>');<%}%>" maxlength='<%=oth_alt_length%>' size='20' tabindex='18' value="<%=other_alt_type_desc%>" <%=other_alt_no_dis%>>
	<%if(isResidencyApplYN && effstatus.equals("E")){%><img name='oth_alt_mand' style='visibility:<%=oth_alt_visibility%>' src='../../eCommon/images/mandatory.gif'><%}%>
	
	</td>
			</tr><tr>
			<!-- Added on 22/04/2003 by Mallikarjuna Reddy for Credential 1,2,3 -->
			
					<td class='label'><fmt:message key="Common.Credential.label" bundle="${common_labels}"/> 1&nbsp;&nbsp;</td>
	<td class='fields' ><input type='text' name="credential_id1" id="credential_id1" onBlur="makeValidString(this)" maxlength='20' size='20' tabindex='18' value="<%=credentialid1%>"  <%=otherTextAttribute%> >
		
	</td>
			<td  class='label' ><fmt:message key="Common.Credential.label" bundle="${common_labels}"/> 2&nbsp;&nbsp;</td>
	<td class='fields' >
		<input type='text' name="credential_id2" id="credential_id2" onBlur="makeValidString(this)" maxlength='20' size='20' tabindex='19'  value="<%=credentialid2%>"  <%=otherTextAttribute%> >
	</td>
	
			<!-- End of addition on 22/04/2003 by Mallikarjuna Reddy for Credential-->
	<%} else {%>
<!--Below line Added HSA-CRF-160 -->
<td class='label'><fmt:message key="Common.Credential.label" bundle="${common_labels}"/> 1&nbsp;&nbsp; </td>
	<td class='fields' ><input type='text' name="credential_id1" id="credential_id1" onBlur="makeValidString(this)" maxlength='20' size='20' value="<%=credentialid1%>"  <%=otherTextAttribute%> >
	   
	</td>
	<td  class='label'><fmt:message key="eMP.OtherAltNo.label" bundle="${common_labels}"/></td>
		<td class='fields' nowrap><select name="other_alt_type" id="other_alt_type" onchange="enabledOtherAltId()" <%=other_alt_type_dis%>>
	<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option><%
	 String alt_no="select alt_id_type, long_desc from mp_alternate_id_type where eff_Status='E' order by alt_id_type";
	 other_altstat=conn.createStatement();
	 other_altrs=other_altstat.executeQuery(alt_no);
	 while(other_altrs.next()){
	 alt_type_code=other_altrs.getString("alt_id_type")==null?"":other_altrs.getString("alt_id_type");
	 alt_type_desc=other_altrs.getString("long_desc")==null?"":other_altrs.getString("long_desc");
	 	 if(alt_type_code.equals(other_alt_type_no)){
             other_alt_select="selected";
	     }else{
	         other_alt_select="";
		 }	 
	 %>
	  <!--Modified by Ashwini on 20-Mar-2020 for MOHE-CRF-0011-->
	 <option value="<%=alt_type_code%>" <%=other_alt_select%>><%=alt_type_desc%></option>	 
	 <%}%></select><input type='text' name="other_alt_no" id="other_alt_no" onBlur="makeValidString(this);<%if(isResidencyApplYN && effstatus.equals("E")){%>duplicateOthAltIdValidation(this,'<%=oth_alt_val%>');<%}%>" maxlength='<%=oth_alt_length%>' size='20' tabindex='18' value="<%=other_alt_type_desc%>" <%=other_alt_no_dis%>>
	<%if(isResidencyApplYN && effstatus.equals("E")){%><img name='oth_alt_mand' style='visibility:<%=oth_alt_visibility%>' src='../../eCommon/images/mandatory.gif'><%}%>
		
		</td>
		</tr>
		<!-- End of addition on 22/04/2003 by Mallikarjuna Reddy for Credential-->
		<tr>
		<td class='label'><fmt:message key="Common.Credential.label" bundle="${common_labels}"/> 2&nbsp;&nbsp;&nbsp;</td><td  class='fields'><input type='text' name="credential_id2" id="credential_id2" onBlur="makeValidString(this)" maxlength='20' size='20' value="<%=credentialid2%>"  <%=otherTextAttribute%> >&nbsp;</td>
		<td   class='label'><fmt:message key="Common.Credential.label" bundle="${common_labels}"/> 3&nbsp;&nbsp;</td>
		<td class='fields' ><input type='text' name="credential_id3" id="credential_id3" onBlur="makeValidString(this)" maxlength='20' size='20' tabindex='20'   value="<%=credentialid3%>"  <%=otherTextAttribute%> ></td>
		
		
	<% } %>
</tr>
<tr>
	<td   class='label'><fmt:message key="Common.Position.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td class='fields' >
      <select name='job_title' id='job_title' tabindex='21'>
	 <option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
   	</td>
	<td   class='label' ><%if(accept_national_id_no_yn.equals("Y")){%><fmt:message key="Common.Credential.label" bundle="${common_labels}"/> 3<%}%>&nbsp;&nbsp;</td>
	<td class='fields'><%if(accept_national_id_no_yn.equals("Y")){%><input type='text' name="credential_id3" id="credential_id3" onBlur="makeValidString(this)" maxlength='20' size='20' tabindex='20'   value="<%=credentialid3%>"  <%=otherTextAttribute%> ><%}%>	&nbsp;&nbsp;</td>
</tr>
<tr>
	<td  class='label' ><fmt:message key="Common.EmplStatus.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td  class= 'fields'>
		<%if(effstatus.equals("E")) {%>
			<%=str5%><%=stre2%>
		<%}
		else if(effstatus.equals("D")) {%>
			<%=stre1%><%=stre2%>
		<%}%>		
			<img src='../../eCommon/images/mandatory.gif' align='center'></img>
	</td>
	<td   class='label'><fmt:message key="eAM.ProfessionalQualification.label" bundle="${am_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td class='fields' > <input type='text' name="degree" id="degree" onBlur="makeValidString(this)" maxlength='30' size='30' tabindex='22'  value="<%=degree%>" <%=otherTextAttribute%> >
		</td>
</tr>

<TR><TD colspan ='4' id = 'popempid' class='label'></TD></TR>	
<tr>
	<%
      if(!function_id.equals("EXT_PRACT")) {%>
	<td class='label'><fmt:message key="Common.AllFacilities.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<%if(count > 1){%><%if(effstatus.equals("E")) {%><td class='fields'><input type='checkbox' onBlur='changeFocus1_new(this)'  name='all_facilities' id='all_facilities' tabindex='25' value="<%=allfacilities%>" onClick='check();changeFocus1();' <%=checkBoxAttribute1%> align='left' ><input type='hidden' name='all_facilities1' id='all_facilities1' value="<%=allfacilities%>"  align='left'></td>
	<% }
	else if(effstatus.equals("D")) {%><td class='fields' ><input type='checkbox'   name='all_facilities' id='all_facilities' value="<%=allfacilities%>" disabled <%=checkBoxAttribute1%> align='left'><input type='hidden' name='all_facilities1' id='all_facilities1' value="<%=allfacilities%>"  ></td>
	<%}%>
	<%}
	else {%><td  class='fields' ><input type='checkbox' name='all_facilities' id='all_facilities'  value="<%=allfacilities%>" disabled <%=checkBoxAttribute1%> align='left'><input type='hidden' name='all_facilities1' id='all_facilities1' value="<%=allfacilities%>"  align='left'></td>
	<%}%>
	
	<td   class='label'>
	<%if(isMMCLblchngesAppl){%>
		<fmt:message key="eAM.MMCNO.label" bundle="${am_labels}"/>
	<%}else{ %> 
		<fmt:message key="eAM.APCNo.label" bundle="${am_labels}"/>
	<%} %>
	</td>
		<td class='fields' >
		<%
			if(practitionerid.equals("")){
		%>
		<input type='text' name="apc_no" id="apc_no" onBlur="makeValidString(this);changeFocus1_app();"  tabindex='24' maxlength='20' size='20' value="">
			<%
		}
		else{%>
			<input type='text' name="apc_no" id="apc_no" onBlur="makeValidString(this);changeFocus1_app();changeFocus1();" tabindex='24' maxlength='20' size='20' value="<%=apc_no%>"  <%=otherTextAttribute%> >
			 <%}%>
		</td>
	
	</tr>
	<tr><td colspan ='2'>&nbsp;</td>	
	<td class='label'><fmt:message key="eAM.RepFacility.label" bundle="${am_labels}"/> &nbsp;&nbsp;</td>
	<td class='fields' ><select name='rep_facility' id='rep_facility' tabindex='26' id="idrep_facility" onBlur='changeFocus1()'><option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option><%
	stmt2=conn.createStatement();
	String sql2="select facility_id,facility_name from sm_facility_param where facility_type='F' and STATUS ='E' order by facility_name ";
	String repfacilitySelected="";	
	rs2=stmt2.executeQuery(sql2);
	
	 while(rs2.next()){
		repfacility=rs2.getString("facility_id")==null?"":rs2.getString("facility_id");				
		repfacilityname=rs2.getString("facility_name")==null?"":rs2.getString("facility_name");
	 
	 if(repfacility.equals(reporting_facility_id)){
	  repfacilitySelected="selected";
	 }else{
	    repfacilitySelected="";
      }		
	 
	 %>
	 <option value="<%=repfacility%>" <%=repfacilitySelected%>><%=repfacilityname%></option>
	 
	 <%}%>
	</select><img name='mandatory' style='visibility: hidden' src='../../eCommon/images/mandatory.gif'>
</td>
		<%}%>
</tr>
<!-- added by mujafar for AAKH-CRF-0079.4 -->
<tr>
<td class='label' ><fmt:message key="Common.Signature.label" bundle="${common_labels}"/>&nbsp;</td>
<td class='fields' ><input type='file' name='signimage' id='signimage'  id='signimage'  value=''  size=40 maxlength=40  onkeypress='return onkeyPressEvent(event);' onblur='ValidateFileType(this)'>&nbsp;
<input type='button' name='preview' id='preview'  <%=includevisibility%>   value='<fmt:message key="Common.Preview.label" bundle="${common_labels}" />' 
onClick="showPractSign('<%=practitionerid%>','<%=function_id%>','Sign')" size=40 maxlength=40 ></td>
<!-- added by Lakshmanan For MO-CRF-20183.2 US001 start -->
<%
if(practEmployeeServiceNo=="" && otherTextAttribute.equals("READONLY")){
otherTextAttributeEmpSrvNo="";
} else {
	otherTextAttributeEmpSrvNo=otherTextAttribute;
}
%>
<td class='label' ><fmt:message key="eAM.EmployeeServiceNumber.label" bundle="${am_labels}"/></td>
<td class='fields' ><input type='text' name='employee_service_number' id='employee_service_number'  id='employee_service_number'  value='<%=practEmployeeServiceNo%>'  maxlength='15' size='20' onkeypress='return CheckForAlphaCharsNatID(event); return CheckSplCharsValidation_EmpSrvNo(this);'  <%=otherTextAttributeEmpSrvNo%> /> <input type='hidden' name='employee_service_number_1' id='employee_service_number_1'  id='employee_service_number_1'  value='<%=practEmployeeServiceNo%>'/>
<%if(isPractEmployeeServiceNumber==true){%><!--Added for PMG2023-COMN-CRF-0043 by Kamatchi S-->
 <img src='../../eCommon/images/mandatory.gif' align='center'></img>
<%}%>
</td>
<!-- added by Lakshmanan For MO-CRF-20183.2 US001 end -->
</tr>
<!--Added by manjunath for TH-KW-CRF-0.161.1   -->
<tr>
	<td class='label' ><fmt:message key="Common.Stamp.label" bundle="${common_labels}"/>&nbsp;</td>
	<td class='fields' colspan='2'><input type='file' name='stampimage' id='stampimage'  id='stampimage'  value=''  size=40 maxlength=40  onkeypress='return onkeyPressEvent(event);' onblur='ValidateFileType(this)'>&nbsp;
	<input type='button' name='preview' id='preview'  <%=includevisibility1%>   value='<fmt:message key="Common.Preview.label" bundle="${common_labels}" />' 
	onClick="showPractSign('<%=practitionerid%>','<%=function_id%>','Stamp')" size=40 maxlength=40 ></td>
	<td>&nbsp;</td><td>&nbsp;</td>
</tr>



<!-- Added by N Munisekhar on 25-July-2013 against MMS-QH-CRF-0104 [IN:039242] -->
<%
	boolean isSiteSpecific=eOP.QMSInterface.isSiteSpecific(conn,"AM","AM_PRACT_EMP");
	if(isSiteSpecific){
	%>
<tr>
	<td class='label' width=20% ><fmt:message key="Common.EmployeeID.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td class='fields' width=30% >
	<input type='text' value='<%=employeeid%>' name='employee_id' maxlength='30' size ='30' disabled/>
	<input type='hidden' name='employee_id' id='employee_id' value='<%=employeeid%>'>
	</td>
</tr>
<%}%>
<!--End of MMS-QH-CRF-0104 [IN:039242] -->
	<input type='hidden' name='ServerDate' id='ServerDate' value='<%=str13%>'>

<tr>
<td colspan='4'>&nbsp;</td>
</tr>
</table>
</td>
</tr>
</table>
<br><br><br><br><br><br>
<br><br><br><br><br><br>
<br><br><br>
<br><br><br><br><br><br>
<br><br><br><br><br><br>
<br><br><br>
<br><br><br><br><br><br>
<br><br><br><br><br><br>
<br><br><br>
<a name='contactnolink' id='contactnolink'></a>
<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
<tr>
  	<td width="100%" class="Border">
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr>
	<td  class='label' width="14%"><fmt:message key="Common.ResTelNo.label"bundle="${common_labels}"/>&nbsp;</td>

	<td class='fields' width="29%" onkeyDown='shift_tab2()'>
		<input type='text' onBlur="makeValidString(this)" name="residencetelno" id="residencetelno" maxlength='18' size='18' tabindex='27' value="<%=restelnum%>" <%=otherTextAttribute%> >
			</td>

	<td  class='label' width="30%" ><fmt:message key="Common.officephoneno.label" bundle="${common_labels}"/>&nbsp;</td>

	<td class='fields' width="25%">
	<input type='text' name="offtelno" id="offtelno" tabindex='28' onBlur="makeValidString(this)" maxlength='18' size='18' value="<%=offtelnum%>" <%=otherTextAttribute%> >
	</td>
</tr>
<tr>

	<td   class='label'><fmt:message key="Common.Ext.label" bundle="${common_labels}"/>&nbsp;</td>
	<td class='fields' width="6%" >
		<input type='text' name="offtelext" id="offtelext" tabindex='29' onBlur="makeValidString(this)" maxlength='6' size='6' value="<%=offtelext%>" <%=otherTextAttribute%> >
	</td>
	<td class='label' ><fmt:message key="Common.FaxNo.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td class='fields' width="6%">
		<input type='text' name="faxno" id="faxno" tabindex='30'  onBlur="makeValidString(this)" maxlength='18' size='18' value="<%=faxnum%>" <%=otherTextAttribute%> >
	</td>
</tr>
<tr>

	<td  class='label' width="6%" ><fmt:message key="Common.MobileNo.label" bundle="${common_labels}"/>&nbsp;</td>
	<td class='fields' width="6%">
			<input type='text' name="mobileno" id="mobileno" tabindex='31' onBlur="makeValidString(this)" maxlength='18' size='18' value="<%=mobilenum%>" <%=otherTextAttribute%> >
	</td>
	<td  class='label' width="6%"><fmt:message key="Common.PagerNo.label" bundle="${common_labels}"/></td>
	<td class='fields' width="6%">
		<input type='text' name="pagerno" id="pagerno" tabindex='32' onBlur="makeValidString(this)" maxlength='18' size='18' value="<%=pagernum%>" <%=otherTextAttribute%> >
	</td>
</tr>
<tr>
	<td class='label' ><fmt:message key="Common.email.label" bundle="${common_labels}"/> <fmt:message key="Common.identification.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td class='fields' ><input type='text' name='emailid' id='emailid' tabindex='33'  onBlur="makeValidString(this)" maxlength='50' size='18' value="<%=emailid%>" <%=otherTextAttribute%> ></td>
	<td  class='label' width="6%"><fmt:message key="eAM.PrefMode.label" bundle="${am_labels}"/>&nbsp;</td>
	<td class='fields' >
	<%if (effstatus.equals("E")) {%>
		<%=str6%><%=strp2%>
	<%}
	else if(effstatus.equals("D")) {%>
		<%=strp1%><%=strp2%>
	<%}%>

	</td>
</tr>
</table>
</td>
</tr>
</table>
<br>
<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
<tr>
 <td width="100%" class="Border">
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr>
<td colspan='4'>&nbsp;</td>
</tr>
<tr>
	<td class='label' width='3%'>&nbsp;</td>
	<td   width='3%' class='label'><b><fmt:message key="Common.residence.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
	<td   width='3%' class='label'><b><fmt:message key="Common.office.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
	<td   width='3%' class='label'><b><fmt:message key="Common.mail.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
<tr>
	<td  width='3%' class='label'><fmt:message key="Common.Address.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td class='fields' width='7%' >
		<input type='text' name='res_add_ln1' id='res_add_ln1' onBlur="makeValidString(this)" maxlength='30' size='20' tabindex='35' value="<%=resaddln1%>" <%=otherTextAttribute%> ></td>
	<td class='fields' width='7%' >
		<input type='text' name='off_add_ln1' id='off_add_ln1' onBlur="makeValidString(this)" maxlength='30' tabindex='35' size='20' value="<%=offaddln1%>" <%=otherTextAttribute%> ></td>
	<td class='fields' width='6%' >
		<input type='text' name='mail_add_ln1' id='mail_add_ln1' onBlur="makeValidString(this)" maxlength='30' tabindex='35' size='20' value="<%=mailaddln1%>" <%=otherTextAttribute%> ></td>
</tr>
<tr>
	<td class='label' width='3%'> </td>
	<td class='fields' width='6%' >
		<input type='text' name='res_add_ln2' id='res_add_ln2' maxlength='30' tabindex='35' size='20' value="<%=resaddln2%>" onBlur="makeValidString(this)" <%=otherTextAttribute%> ></td>
	<td class='fields' width='6%' >
		<input type='text' name='off_add_ln2' id='off_add_ln2' maxlength='30' size='20' tabindex='35' value="<%=offaddln2%>"  onBlur="makeValidString(this)" <%=otherTextAttribute%> ></td>
	<td class='fields' width='6%' >
		<input type='text' name='mail_add_ln2' id='mail_add_ln2' maxlength='30' size='20' tabindex='35' value="<%=mailaddln2%>" onBlur="makeValidString(this)"  <%=otherTextAttribute%> ></td>
</tr>
<tr>
	<td width='3%'> </td>
	<td class='fields' width='6%' >
		<input type='text' name='res_add_ln3' id='res_add_ln3' maxlength='30' size='20' tabindex='35' value="<%=resaddln3%>" onBlur="makeValidString(this)" <%=otherTextAttribute%> ></td>
	<td class='fields' width='6%' >
		<input type='text' name='off_add_ln3' id='off_add_ln3' maxlength='30' size='20' tabindex='35' value="<%=offaddln3%>" onBlur="makeValidString(this)"  <%=otherTextAttribute%> ></td>
	<td class='fields' width='6%' >
		<input type='text' name='mail_add_ln3' id='mail_add_ln3' maxlength='30' size='20'  tabindex='35'value="<%=mailaddln3%>" onBlur="makeValidString(this)"  <%=otherTextAttribute%> ></td>
</tr>
<tr>
	<td class='label' width='3%'> </td>
	<td class='fields' width='6%' >
		<input type='text' name='res_add_ln4' id='res_add_ln4' maxlength='30' size='20' tabindex='35' value="<%=resaddln4%>" onBlur="makeValidString(this)"  <%=otherTextAttribute%> ></td>
	<td class='fields' width='6%' >
		<input type='text' name='off_add_ln4' id='off_add_ln4' maxlength='30' size='20' tabindex='35' value="<%=offaddln4%>" onBlur="makeValidString(this)"  <%=otherTextAttribute%> ></td>
	<td class='fields' width='6%' >
		<input type='text' name='mail_add_ln4' id='mail_add_ln4' maxlength='30' size='20' tabindex='35' value="<%=mailaddln4%>" onBlur="makeValidString(this)" <%=otherTextAttribute%> ></td>
</tr>
<tr>
	<td  width='3%' class='label'><fmt:message key="eMP.postalcode.label" bundle="${mp_labels}"/>&nbsp;</td>
	<%		
				
				if(effstatus.equals("E")) {
		%>
<td class='fields' width='6%' >
<%		
			
	
		if(fcall.equals("call"))
	{
	if(newPractitioner)
	{ %>
<input type='text' name='res_add_postal_code' id='res_add_postal_code' size='15'  tabindex='36' onBlur="makeValidString(this);if(this.value != ''){	searchCode(this,res_add_postal_code);}else{}" maxlength='15' ><input type='button' name='postal_code' id='postal_code' tabindex='36' value='?' class='button' onclick='searchCode(this,res_add_postal_code)'>
<% 
        }
        else								
        { 
        if(respostalcode != null) {%>
				<input type='text' name='res_add_postal_code2' id='res_add_postal_code2' tabindex='36' size='15' maxlength='15' value="<%=respostalcode%>" onBlur="makeValidString(this);if(this.value != ''){searchCode(this,res_add_postal_code2);}else { }" ><input type='button' name='postal_code' id='postal_code' tabindex='36' value='?' class='button' onclick='searchCode(this,res_add_postal_code2)'>
		<%}else{%>
				<input type='text' name='res_add_postal_code2' id='res_add_postal_code2' tabindex='36' onBlur="makeValidString(this);if(this.value != ''){searchCode(this,res_add_postal_code2);}else{ }" size='15' maxlength='15'><input type='button'  name='postal_code' id='postal_code' tabindex='36' value='?' class='button' onclick='searchCode(this,res_add_postal_code2)'>
		<%}
	}
	}
	%>
	<%=strrep2%></td>
	<td class='fields' width='6%' >
	<%    	if(fcall.equals("call"))
	        {
	        if(newPractitioner)
	        {%>
			<input type='text' name='off_add_postal_code' id='off_add_postal_code' tabindex='36' onBlur="makeValidString(this);if(this.value != ''){searchCode(this,off_add_postal_code);}else{}"  size='15' maxlength='15'><input type='button' name='postal_code' id='postal_code' tabindex='36' value='?' class='button' onclick='searchCode(this,off_add_postal_code)'>
	        <%		
	        }
	        else
	        {
				if(offpostalcode != null) {%>
					<input type='text' name='off_add_postal_code2' id='off_add_postal_code2' tabindex='36' size='15' maxlength='15'  onBlur="makeValidString(this);if(this.value != ''){searchCode(this,off_add_postal_code2);}else{}" value="<%=offpostalcode%>"  ><input type='button' name='postal_code' id='postal_code' tabindex='36' value='?' class='button' onclick='searchCode(this,off_add_postal_code2)'>
				<%}else{%>
					<input type='text' name='off_add_postal_code2' id='off_add_postal_code2' tabindex='36' onBlur="makeValidString(this);if(this.value != ''){searchCode(this,off_add_postal_code2);}else{}" size='15' maxlength='15'><input type='button' tabindex='36' name='postal_code' id='postal_code' value='?' class='button' onclick='searchCode(this,off_add_postal_code2)'>
				<%}
		}
	}
%>
	<%=strofp2%></td>
	<td class='fields' width='6%' >
	
	<%  if(fcall.equals("call"))
		{
		if(newPractitioner)
		{%>
			<input type='text' name='mail_add_postal_code' id='mail_add_postal_code'  tabindex='36' size='15' onBlur="makeValidString(this);if(this.value != ''){searchCode(this,mail_add_postal_code);}else{}" maxlength='15'><input type='button' name='postal_code' id='postal_code' tabindex='36' value='?' class='button' onclick='searchCode(this,mail_add_postal_code)'>

		<%		
		}else{
		if(mailpostalcode != null) {%>
			<input type='text' name='mail_add_postal_code2' id='mail_add_postal_code2' tabindex='36' onBlur="makeValidString(this);if(this.value != ''){searchCode(this,mail_add_postal_code2);}else{}"  size='15' maxlength='15' value="<%=mailpostalcode%>" ><input type='button' name='postal_code' id='postal_code' value='?' tabindex='36' class='button' onclick='searchCode(this,mail_add_postal_code2)'>
				<%}else{%>
					<input type='text' name='mail_add_postal_code2' id='mail_add_postal_code2' tabindex='36' onBlur="makeValidString(this);if(this.value != ''){searchCode(this,mail_add_postal_code2);}else{}"   size='15' maxlength='15'><input type='button' name='postal_code' id='postal_code' value='?' tabindex='36' class='button' onclick='searchCode(this,mail_add_postal_code2)'>
				<%}
		}
	}			
	%>
	<%=strmap2%></td>
	<% }
	else if(effstatus.equals("D")) {%>
	<td class='label' width='6%' ><%=strrep1%><%=strrep2%></td>
	<td class='label' width='6%' ><%=strofp1%><%=strofp2%></td>
	<td class='label' width='6%' ><%=strmap1%><%=strmap2%></td>
	<% }%>
		<input type='hidden' name='res_code_value' id='res_code_value' value='<%=respostalcode%>'>
		<input type='hidden' name='off_code_value' id='off_code_value' value='<%=offpostalcode%>'>
		<input type='hidden' name='mail_code_value' id='mail_code_value' value='<%=mailpostalcode%>'>
</tr>
<tr>
	<td  width='3%' class='label'><fmt:message key="Common.country.label" bundle="${common_labels}"/>&nbsp;</td>
	<%if(effstatus.equals("E")) {%>
		<td class='fields' width='6%' >
<% if(fcall.equals("call"))
	{
	if(newPractitioner)
	{ %>
<input type='text' name='resCountryDode' id='resCountryDode' size='20' value="" tabindex='37' onBlur="if(this.value != '') {searchCountryCode(this,resCountryDode,'residence');}" maxlength='30'> <input type='button' name='CountryButton' id='CountryButton' value='?' tabindex='37' class='button' onclick="searchCountryCode(this,resCountryDode,'residence')" ><input type='hidden' name='res_add_country_code' id='res_add_country_code' value=''>
<% 
        }
        else								
        { 
        if(rescountrycode != null) {%>
				<input type='text' name='resCountryDode' id='resCountryDode' size='20' tabindex='37' maxlength='30' value="<%=rescountrydesc%>" onBlur="if(this.value != '') 		{searchCountryCode(this,resCountryDode,'residence');}" ><input type='button' tabindex='37' name='CountryButton' id='CountryButton' value='?' class='button' onclick=" searchCountryCode(this,resCountryDode,'residence')" ><input type='hidden' name='res_add_country_code' id='res_add_country_code' value="<%=rescountrycode%>">
		<%}else{%>
				<input type='text' name='resCountryDode' id='resCountryDode' tabindex='37' size='20' maxlength='30'><input type='button' onClick="searchCountryCode(this,resCountryDode,'residence');" name='CountryButton' id='CountryButton' value='?' class='button' tabindex='37' onclick="searchCountryCode(this,resCountryDode,'residence')" ><input type='hidden' name='res_add_country_code' id='res_add_country_code' value=''>
		<%}
	}
	}
	%>
	<%=strrec2%></td>
	<td class='fields' width='6%' >
	<%    	if(fcall.equals("call"))
	        {
	        if(newPractitioner)
	        {%>
			<input type='text' name='offCountryDesc' id='offCountryDesc' value="" tabindex='37' onBlur="if(this.value != '') 		{searchCountryCode(this,offCountryDesc,'office');}" size='20' maxlength='30'><input type='button' tabindex='37'  name='CountryButton' id='CountryButton' value='?' class='button' onclick="searchCountryCode(this,offCountryDesc,'office')"><input type='hidden' name='off_add_country_code' id='off_add_country_code' value=''>
	        <%		
	        }
	        else
	        {
				if(offcountrycode != null) {%>
					<input type='text' name='offCountryDesc' id='offCountryDesc' size='20' tabindex='37' maxlength='30'  onBlur="if(this.value != '') 		{searchCountryCode(this,offCountryDesc,'office');}" value="<%=offcountrydesc%>"  ><input type='button' tabindex='37' name='CountryButton' id='CountryButton' value='?' class='button' onclick="searchCountryCode(this,offCountryDesc,'office')"><input type='hidden' name='off_add_country_code' id='off_add_country_code' value='<%=offcountrycode%>'>
				<%}else{%>
					<input type='text' name='offCountryDesc' id='offCountryDesc' value="" tabindex='37' onBlur="if(this.value != '') 		{searchCountryCode(this,offCountryDesc,'office');}" size='20' maxlength='30'><input type='button' tabindex='37'  name='CountryButton' id='CountryButton' value='?' class='button' onclick="searchCountryCode(this,offCountryDesc,'office')"><input type='hidden' name='off_add_country_code' id='off_add_country_code' value=''>
				<%}
		}
	}
%>
	<%=strofc2%></td>
	<td class='fields' width='6%' >
	 
	<%  if(fcall.equals("call"))
		{
		if(newPractitioner)
		{%>
			<input type='text' name='offCountryDode' id='offCountryDode' size='20' tabindex='37' value="" onBlur="if(this.value != '') {searchCountryCode(this,offCountryDode,'mail');}" maxlength='30'><input type='button' tabindex='37'  name='CountryButton' id='CountryButton' value='?' class='button' onclick="searchCountryCode(this,offCountryDode,'mail')"onblur="callfunFocus();"><input type='hidden' name='mail_add_country_code' id='mail_add_country_code' value=''>

		<%		
		}else{
		if(mailcountrycode != null) {%>
			<input type='text' name='offCountryDode' id='offCountryDode' size='20' tabindex='37' maxlength='30' value="<%=mailcountrydesc%>" onBlur="if(this.value != '') 		{searchCountryCode(this,offCountryDode,'mail');}"><input type='button' tabindex='37'  name='CountryButton' id='CountryButton' value='?' class='button' onclick="searchCode(this,offCountryDode,'mail')" onblur="callfunFocus();"><input type='hidden' name='mail_add_country_code' id='mail_add_country_code' value='<%=mailcountrycode%>'>
				<%}else{%>
					<input type='text' name='offCountryDode' id='offCountryDode' tabindex='37' value="" onBlur="if(this.value != '') 	{searchCountryCode(this,offCountryDode,'mail');}"   size='20' maxlength='30'><input type='button'  tabindex='37' name='CountryButton' id='CountryButton' value='?' class='button' onclick="searchCountryCode(this,offCountryDode,'mail')" onblur="callfunFocus();"><input type='hidden' name='mail_add_country_code' id='mail_add_country_code' value=''>
				<%}
		}
	}			
	%>
	<%=strmac2%></td>
		
	
	<% }
	else if(effstatus.equals("D")) {%>
	<td align='left' width='6%'><%=strrec1%><%=strrec2%></td>
	<td align='left' width='6%'><%=strofc1%><%=strofc2%></td>
	<td align='left' width='6%'><%=strmac1%><%=strmac2%></td>
	<%}%>
</tr>
</table>
</td>
</tr>
<tr>
<td>&nbsp;
</td>
</tr>
<tr>
<td class='BODYCOLORFILLED'>&nbsp;
</td>
</tr>
<tr>
<td class='BODYCOLORFILLED'>&nbsp;
</td>
</tr>
<tr>
<td class='BODYCOLORFILLED'>&nbsp;
</td>
</tr>
<tr>
<td class='BODYCOLORFILLED'>&nbsp;
</td>
</tr>
<tr>
<td class='BODYCOLORFILLED'>&nbsp;
</td>
</tr>
<tr>
<td class='BODYCOLORFILLED'>&nbsp;
</td>
</tr>
</table>
<br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br>
<a name='deglink' id='deglink'></a>
<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center' valign='top'  name='deg_link' id='deg_link'>
<tr><th COLSPAN='4'align='left'><fmt:message key="Common.QualificationDetails.label" bundle="${common_labels}"/></th></tr>
	<tr><td class='blankwhiterow' colspan='4'></td></tr>
<tr>
	<td class = 'columnheader' width='4%'>&nbsp;</td>
	<td class = 'columnheader' width='42%'><fmt:message key="Common.Degree.label" bundle="${common_labels}"/></td>
	<td class = 'columnheader' width='22%'><fmt:message key="Common.Yearofpassing.label" bundle="${common_labels}"/></td>
    <td class = 'columnheader' width='32%'><fmt:message key="Common.University.label" bundle="${common_labels}"/></td>
</tr>


<tr>	<%
			if(!(practitionerid.equals(""))){
				if(degree1.equals(""))
					readProperty="readOnly";
				else
					readProperty = "";
		%>
	
		<td class='label'>&nbsp;</td>
		<td class='fields' onkeyDown='shift_tab3();'><input type='text' name="degree1" id="degree1" tabindex='38' onBlur='makeValidString(this);enabledata(this)' maxlength='60' size='45' value="<%=degree1%>" <%=otherTextAttribute%>   ></td><td class='fields'><input type='text' name="year1" id="year1" tabindex='38' onBlur="makeValidString(this);chkyearlen(this);chkyear1(this);CheckNum(this)" maxlength='4' size='4' value="<%=year1%>" <%=readProperty%> <%=otherTextAttribute%> onkeypress="return allowValidNumber(this,event,20, 0);"></td>
		<td class='fields'>
		<input type='text' name="univ1" id="univ1" tabindex='38' onBlur="makeValidString(this)" maxlength='30' size='30' value="<%=univ1%>" <%=readProperty%> <%=otherTextAttribute%> >
		</td>
			<% } else {%>
			<td class='label'>&nbsp;</td>
			<td class='fields' onkeyDown='shift_tab3()'><input type='text' name="degree1" id="degree1" tabindex='38' onBlur="makeValidString(this);enabledata(this)" maxlength='60' size='45' value=""  ></td>
			<td class='fields'><input type='text' name="year1" id="year1" tabindex='38' onBlur="makeValidString(this);chkyearlen(this);chkyear1(this);CheckNum(this) " maxlength='4' size='4' value=""  onkeypress="return allowValidNumber(this,event,20, 0);" readonly ></td>		
		<td class='fields'>
		<input type='text' name="univ1" id="univ1" tabindex='38' onBlur="makeValidString(this)" maxlength='30' size='30' value="" readOnly>
		</td><%}%>
		</tr>
			<tr>	<%
			if(!(practitionerid.equals(""))){
			if(degree2.equals(""))
	       		readProperty="readOnly";
			else
				readProperty = "";
		%>
	<td>&nbsp;</td>
	<td class='fields'><input type='text' name="degree2" id="degree2" tabindex='38' onBlur="makeValidString(this);enabledata(this)" maxlength='60' size='45' value="<%=degree2%>" <%=otherTextAttribute%> >
</td>
		
	<td class='fields'><input type='text' name="year2" id="year2" tabindex='38'  onBlur="makeValidString(this);chkyearlen(this);chkyear2(this);CheckNum(this) " maxlength='4' size='4' value="<%=year2%>" <%=readProperty%>  <%=otherTextAttribute%> onkeypress="return allowValidNumber(this,event,20, 0);"></td>
	<td class='fields'><input type='text' name="univ2" id="univ2" tabindex='38' onBlur="makeValidString(this)" maxlength='30' size='30' value="<%=univ2%>" <%=readProperty%><%=otherTextAttribute%> >
		</td>
			<% } else {%>
			<td class='label'>&nbsp;</td><td class='fields'><input type='text' name="degree2" id="degree2" tabindex='38' onBlur="makeValidString(this);enabledata(this)" maxlength='60' size='45' value=""  >
</td><td class='fields'><input type='text' name="year2" id="year2" tabindex='38' onBlur="makeValidString(this);chkyearlen(this);chkyear2(this);CheckNum(this) " maxlength='4' size='4' value=""  onkeypress="return allowValidNumber(this,event,20, 0);" readOnly></td>
	<td class='fields'>
		<input type='text' name="univ2" id="univ2" tabindex='38' onBlur="makeValidString(this)" maxlength='30' size='30' value="" readonly>
		</td><%}%>
		</tr>
			<tr>	<%
			if(!(practitionerid.equals(""))){
			if(degree3.equals(""))
	       		readProperty="readOnly";
			else
				readProperty = ""; 			
		%>
	<td class='label'>&nbsp;</td><td class='fields'><input type='text' name="degree3" id="degree3" tabindex='38' onBlur="makeValidString(this);enabledata(this);" maxlength='60' size='45' value="<%=degree3%>" <%=otherTextAttribute%> >
</td><td class='fields'><input type='text' name="year3" id="year3" tabindex='38' onBlur="makeValidString(this);chkyearlen(this);chkyear3(this);CheckNum(this) " maxlength='4' size='4' value="<%=year3%>" <%=readProperty%> <%=otherTextAttribute%> onkeypress="return allowValidNumber(this,event,20, 0);" ></td><td class='fields'>
		<input type='text' name="univ3" id="univ3" tabindex='38' onBlur="makeValidString(this)" maxlength='30' size='30' value="<%=univ3%>"  <%=otherTextAttribute%>  <%=readProperty%>>
		</td>
			<% } else {%>
			<td class='label'>&nbsp;</td><td class='fields'><input type='text' name="degree3" id="degree3" tabindex='38' onBlur="makeValidString(this);enabledata(this)" maxlength='60' size='45' value="" >
</td><td class='fields'><input type='text' name="year3" id="year3" tabindex='38' onBlur="makeValidString(this);chkyearlen(this);chkyear3(this);CheckNum(this) " maxlength='4' size='4' value="" onkeypress="return allowValidNumber(this,event,20, 0);" readonly></td><td>
		<input type='text' name="univ3" id="univ3" tabindex='38' onBlur="makeValidString(this)" maxlength='30' size='30' value="" readonly>
		</td><%}%>
		</tr>
			<tr>	<%
			if(!(practitionerid.equals(""))){			
				if(degree4.equals(""))
	       			readProperty="readOnly";
				else
					readProperty = "";
		%>
	<td class='label'>&nbsp;</td><td class='fields'><input type='text' name="degree4" id="degree4" tabindex='38' onBlur="makeValidString(this);enabledata(this)" maxlength='60' size='45' value="<%=degree4%>" <%=otherTextAttribute%> >
</td><td class='fields'><input type='text' name="year4" id="year4" tabindex='38' onBlur="makeValidString(this);chkyearlen(this);chkyear4(this);CheckNum(this) "  maxlength='4' size='4' value="<%=year4%>"<%=readProperty%> <%=otherTextAttribute%>onkeypress="return allowValidNumber(this,event,20, 0);" ></td><td class='fields'>
		<input type='text' name="univ4" id="univ4" tabindex='38' onBlur="makeValidString(this)" maxlength='30' size='30'  value="<%=univ4%>" <%=readProperty%><%=otherTextAttribute%> >
		</td>
			<% } else {%>
			<td class='label'>&nbsp;</td><td class='fields'><input type='text' name="degree4" id="degree4" tabindex='38' onBlur="makeValidString(this);enabledata(this)" maxlength='60' size='45' value=""  >
</td><td class='fields'><input type='text' name="year4" id="year4" tabindex='38' onBlur="makeValidString(this);chkyearlen(this);chkyear4(this);CheckNum(this) " maxlength='4' size='4' value=""  readonly onkeypress="return allowValidNumber(this,event,20, 0);"></td>
	<td class='fields'>
		<input type='text' name="univ4" id="univ4" readonly tabindex='38' onBlur="makeValidString(this)" maxlength='30' size='30' value="" readonly>
		</td><%}%>
		</tr>
</table>



<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center' valign='top'  name='deg_link' id='deg_link'>
<tr><th colspan="4" align="left"><fmt:message key="Common.TrainingDetails.label" bundle="${common_labels}"/></th></tr>
		<tr><td class='blankwhiterow' colspan='4'></td></tr>
<tr>
	<td class = 'columnheader' width='4%'>&nbsp;</td>
	<td class = 'columnheader' width='64%' colspan='2'><fmt:message key="Common.DetailsofTraining.label" bundle="${common_labels}"/></td>	
	<td class = 'columnheader' width='32%'><fmt:message key="Common.ConductedBy.label" bundle="${common_labels}"/></td>
</tr>
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr>
<%
	if(!(practitionerid.equals("")))
	{
%>
		<td class='label' width='4%'>&nbsp;</td>
		<td class='fields' width='64%' colspan='2'>
			<textarea name="det1" id="det1" rows='2' cols ='50' size='30' tabindex='39' onKeyPress='checkMaxLimit(this,100);' onBlur="makeValidString(this)" <%=otherTextAttribute%> width="5%"><%=det1%></textarea>
		</td>
		<td class='fields' width='32%'>
			<input type='text' name="con1" id="con1" tabindex='39' onBlur="makeValidString(this)" maxlength='30' size='30' value="<%=con1%>" <%=otherTextAttribute%> >
		</td>
<%  }
	else 
	{
%>
			<td class='label' width='4%'>&nbsp;</td>
			<td class='fields' width='64%' colspan='2'>
				<textarea name="det1" id="det1"  rows=2 cols =50 onKeyPress='checkMaxLimit(this,100);' tabindex='39' size='30' onBlur="makeValidString(this)" value="" width="5%"></textarea>
			</td>
			<td class='fields' width='32%'>
				<input type='text' name="con1" id="con1" tabindex='39' maxlength='30' size='30' onBlur="makeValidString(this)"  value="" >
			</td>
<%  
	}
%>
		</tr>
		<tr>
<%
			if(!(practitionerid.equals(""))){
		%>
		<td class='label' width='4%'>&nbsp;</td>
		<td class='fields' width='64%' colspan='2'><textarea name="det2" id="det2" tabindex='39' rows=2 cols =50 onBlur="makeValidString(this)" onKeyPress='checkMaxLimit(this,100);' size='30'  <%=otherTextAttribute%> width="5%"><%=det2%></textarea></td>
		<td class='fields' width='32%'>
		<input type='text' name="con2" id="con2" tabindex='39' onBlur="makeValidString(this)" maxlength='30' size='30' value="<%=con2%>" <%=otherTextAttribute%> >
		</td>
			<% } else {%>
			<td class='label' width='4%'>&nbsp;</td>
			<td class='fields' width='64%' colspan='2'><textarea name="det2" id="det2"  rows=2 cols =50 tabindex='39' onBlur="makeValidString(this)" onKeyPress='checkMaxLimit(this,100);' size='30' value="" width="5%"></textarea>
			</td>
			<td class='fields' width='32%'>
			<input type='text' name="con2" id="con2" tabindex='39'  onBlur="makeValidString(this)" maxlength='30' size='30' value="" >
			</td><%}%>
			</tr>
			<tr>	<%
			if(!(practitionerid.equals(""))){
		%>
		<td class='label' width='4%'>&nbsp;</td>
		<td class='fields' width='64%' colspan='2'><textarea name="det3" id="det3" rows=2 tabindex='39' cols =50 onBlur="makeValidString(this)" onKeyPress='checkMaxLimit(this,100);' size='30'  <%=otherTextAttribute%> width="5%"><%=det3%></textarea></td>
		<td class='fields' width='32%'>
		<input type='text' name="con3" id="con3" tabindex='39' onBlur="makeValidString(this)" maxlength='30' size='30' value="<%=con3%>" <%=otherTextAttribute%> >
		</td>
			<% } else {%>
			<td class='label' width='4%'>&nbsp;</td>
			<td class='fields' width='64%' colspan='2'><textarea name="det3" id="det3" rows=2 cols =50 tabindex='39' onBlur="makeValidString(this)" onKeyPress='checkMaxLimit(this,100);' size='30' value="" width="5%"></textarea>
			</td>
			<td class='fields'width='332%'>
			<input type='text' name="con3" id="con3" onBlur="makeValidString(this)" tabindex='39' maxlength='30' size='30' value="" >
		</td><%}%>
		</tr>
			<tr>	<%
			if(!(practitionerid.equals(""))){
		%>
		<td class = 'label'	width='4%'>&nbsp;</td>
		<td class='fields' width='64%' colspan='2'>
		<textarea name="det4" id="det4" rows=2 cols =50 tabindex='39' onBlur="makeValidString(this)" onKeyPress='checkMaxLimit(this,100);' size='30'  <%=otherTextAttribute%> width="5%"><%=det4%></textarea>
		</td>
		<td class='fields' width='32%'>
		<input type='text' name="con4" id="con4" onBlur="makeValidString(this); detailsoftraining();" tabindex='39' maxlength='30' size='30' value="<%=con4%>" <%=otherTextAttribute%> >
		</td>
			<% } else {%>
			<td class='label' width='4%'>&nbsp;</td>
			<td class='fields' width='64%' colspan='2'><textarea name="det4" id="det4" rows=2 cols =50 tabindex='39' onBlur="makeValidString(this)" onKeyPress='checkMaxLimit(this,100);' size='30' value="" width="5%"></textarea></td>
			<td class='fields' width='32%'>
			<input type='text' name="con4" id="con4" tabindex='39' onBlur="makeValidString(this); detailsoftraining();" maxlength='30' size='30' value="">
		</td><%}%>
		</tr>
</table>
<br><br><br><br><br><br>
<br><br><br><br><br><br>
<br><br><br><br><br><br>
<br><br><br><br><br><br>
<br><br><br><br><br><br>
<%  
	/*if(fcall.equals("nocall"))
		out.println("<script>parent.frames[1].document.getElementById('identitylink').scrollIntoView();</script>");*/
  	if(newPractitioner){%>
 	       	<input type='hidden' name='function' id='function' value='insert'>
  	       	<input type='hidden' name='function_name' id='function_name' value='insert'>

  	<%}else{%>
	       	<input type='hidden' name='function' id='function' value='modify'>
  		    <input type='hidden' name='function_name' id='function_name' value='modify'>
  
  	       	<%}
  	   	}catch(Exception e){}
  	  	finally
		{
			if (stmt2 != null) stmt2.close();
			if (stmt != null) stmt.close();
			if (rs2 != null) rs2.close();
			if (rs != null) rs.close();

			ConnectionManager.returnConnection(conn,request);
		}%>
 	       	<input type='hidden' name='pract_type1' id='pract_type1'>
			<input type='hidden' name='job_title1' id='job_title1'>			
  	       	<input type='hidden' name='practitioner_id1' id='practitioner_id1' >
  	       	<input type='hidden' name='practitioner_name1' id='practitioner_name1' >
  	       	<input type='hidden' name='short_name1' id='short_name1'>
  	       	<input type='hidden' name='eff_status1' id='eff_status1'>
			<input type='hidden' name='fpp_pract_yn' id='fpp_pract_yn'><!--Added by Thamizh selvi on 28th June 2018 against ML-MMOH-CRF-1184-->
			<input type='hidden' name='supervisor_yn' id='supervisor_yn'>
  	       	<input type='hidden' name='date_of_birth1' id='date_of_birth1'>
  	       	<input type='hidden' name='date_of_birth2' id='date_of_birth2'>
  	       	<input type='hidden' name='primary_speciality_codeh' id='primary_speciality_codeh'>
  	        <input type='hidden' name='practid' id='practid' value=<%=practitionerid%> >
  	 	   <input type='hidden' name='server_date' id='server_date' value=<%=str13%> >
		   <input type='hidden' name='text5' id='text5' value=''>
		   <input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'>
		    <input type='hidden' name='effstatus12' id='effstatus12' value='<%=effstatus%>'>
			 <input type='hidden' name='nat_id_prompt' id='nat_id_prompt' value='<%=nat_id_prompt%>'>
			<input type='hidden' name='long_name1' id='long_name1'>
			<input type='hidden' name='enable_virtual_consultation1' id='enable_virtual_consultation1'>//<!--added by Himanshu Saxena for ML-MMOH-CRF-1930 on 13-04-2023 -->
			<input type="hidden" name="other_alt_no1" id="other_alt_no1" value="<%=other_alt_type_desc%>"> <!--Added for this CRF HSA-CRF-160 -->
			
			<input type="hidden" name="cerner_practitioner_id" id="cerner_practitioner_id" value="<%=cerner_prac_id%>">  
			<input type="hidden" name="signimage1" id="signimage1" value=""> <!-- added by mujafar for AAKH-CRF-0079.4 -->
			<input type="hidden" name="stampimage1" id="stampimage1" value=""> <!-- added by manjunath for TH-KW-CRF-0161.1 -->
			<!--Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011-->
			<input type="hidden" name="eff_stat" id="eff_stat" value="<%=effstatus%>">
			<input type="hidden" name="citizen_nat_desc" id="citizen_nat_desc" value="<%=citizen_nat_desc%>">
			<input type="hidden" name="citizen_nat_code" id="citizen_nat_code" value="<%=citizen_nat_code%>">
			<input type="hidden" name="isResidencyApplYN" id="isResidencyApplYN" value="<%=isResidencyApplYN%>">

			<input type="hidden" name="isPractEmployeeServiceNumber" id="isPractEmployeeServiceNumber" value="<%=isPractEmployeeServiceNumber%>"> <!-- Added by Kamatchi S for PMG2023-COMN-CRF-0043 -->

			<input type="hidden" name="natid_mand_yn" id="natid_mand_yn" value="<%=natid_mand_yn%>">
			<input type="hidden" name="oth_alt_val" id="oth_alt_val" value="<%=oth_alt_val%>">
			<input type="hidden" name="other_alt_type_no" id="other_alt_type_no" value="<%=other_alt_type_no%>">
			<input type="hidden" name="other_alt_type_desc" id="other_alt_type_desc" value="<%=other_alt_type_desc%>">
			<input type="hidden" name="alt_id1_type" id="alt_id1_type" value="<%=alt_id1_type%>">
			<input type="hidden" name="alt_id1_length" id="alt_id1_length" value="<%=alt_id1_length%>">
			<input type="hidden" name="oth_alt_length" id="oth_alt_length" value="<%=oth_alt_length%>">
			
		   
<input type='hidden' name='text6' id='text6' value=''>
<script>
	if('<%=emplstatus%>' == "T") 
	{
		document.getElementById("popempid").innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Empl ID <input type='text' value='<%=employeeid%>' name='employee_id' maxlength='30' size ='30' READONLY>";
	}

</script>	
<%if(effstatus.equals("D")) { %>
<script>document.practitioner1_form.job_title.disabled=true</script>
<% } %>
</form>
</body>
<script>
function populateValues()
{
var obj=parent.practitioner_sub.document.practitioner1_form.job_title;
var length = obj.length;
 for(i=0;i<length;i++)
  obj.remove(1);
var pract_type=parent.practitioner_main.document.practitioner_form.pract_type.value;
var HTMLVal = "<html><body onKeyDown = 'lockKey()'><form name='practform' id='practform' method='post' action='../../eAM/jsp/PopulatePosition.jsp'><input type='hidden' name='pract_type' id='pract_type' value='"+pract_type+"'>	</form></body></html>";	
parent.parent.frames[3].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
parent.parent.frames[3].document.forms[0].submit();
}

function populateValue1()
{	
	var obj;
if(parent.practitioner_sub.document.practitioner1_form)
	{
	obj=parent.practitioner_sub.document.practitioner1_form.job_title;
	
var length = obj.length;
 for(i=0;i<length;i++)
  obj.remove(1);

 if(practitioner1_form.function_name.value == "modify") 
			{    
         var pract_type='<%=practtype%>';
		 var pos_code='<%=poscode%>';
  //setTimeout('populateValue1()',500); 		
var HTMLVal = "<html><body onKeyDown = 'lockKey()'><form name='practform' id='practform' method='post' action='../../eAM/jsp/PopulatePosition.jsp'><input type='hidden' name='pract_type' id='pract_type' value='"+pract_type+"'>	<input type='hidden' name='pos_code' id='pos_code' value='"+pos_code+"'></form></body></html>";

if(parent.parent.frames[3].document.body)
parent.parent.frames[3].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
parent.parent.frames[3].document.forms[0].submit();
			}
	}
}
function populateValue2()
{
	setTimeout('populateValue1()',5000); 
}

function echeck10()
{
	if(practitioner1_form.empl_status.value == "T")			
	{
		document.getElementById('popempid').innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Empl ID &nbsp;<input type='text' value='<%=employeeid%>' name='employee_id' maxlength='30' size ='30' READONLY>";
	}
	else 	
	 	document.getElementById('popempid').innerHTML="&nbsp;";	
}
function maxLength(field,maxChars)
 {
	   alert("feild"+field);
       //if(field.value.length >= maxChars) {
	   if(field.value.length > maxChars) {
	     var errors1 = getMessage('OBJ_CANNOT_EXCEED','Common');
		errors1 = errors1.replace('$', maxChars);		  
		  alert(errors1);
              field.select();
              field.focus();		  
          return false;
       }
	   else{
	     return true;
	   }
 }    

 function maxLengthPaste(field, maxChars) {
	    field.addEventListener('paste', function(event) {
	        event.preventDefault();
	        var pasteData = (event.clipboardData || window.clipboardData).getData('text');
	        var currentLength = field.value.length;
	        var pasteLength = pasteData.length;

	        if (currentLength + pasteLength > maxChars) {
	            var allowedLength = maxChars - currentLength;
	            var truncatedData = pasteData.substring(0, allowedLength);
	            var errors1 = getMessage('OBJ_CANNOT_EXCEED', 'Common');
	            errors1 = errors1.replace('$', maxChars);
	            alert(errors1);
	            var startPos = field.selectionStart;
	            field.value = field.value.substring(0, startPos) + truncatedData + field.value.substring(startPos);
	            field.setSelectionRange(startPos + truncatedData.length, startPos + truncatedData.length);
	        } else {
	            var startPos = field.selectionStart;
	            var endPos = field.selectionEnd;
	            field.value = field.value.substring(0, startPos) + pasteData + field.value.substring(endPos);
	            field.setSelectionRange(startPos + pasteData.length, startPos + pasteData.length);
	        }

	        // Trigger input event to ensure the field is editable immediately
	        var inputEvent = new Event('input', { bubbles: true });
	        field.dispatchEvent(inputEvent);
	    });
	}
function ChkKey(evnt)
{ 
	if(evnt.keyCode == '13')
		return false;
}
//Added for this CRF HAS-CRF-160
function enabledOtherAltId(){ 
  document.practitioner1_form.other_alt_no.value="";
		if(document.practitioner1_form.other_alt_type.selectedIndex != 0){
			document.practitioner1_form.other_alt_no.disabled = false;
			document.practitioner1_form.other_alt_no.value="";
			document.practitioner1_form.other_alt_no1.value="";
		}else { 
			document.practitioner1_form.other_alt_no.disabled = true;
			
		}
}
</script>
</html>

