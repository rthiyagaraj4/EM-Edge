<!DOCTYPE html>
<%--
	Created On : 4/26/2006 9:20 AM	  By Vinod
	Modified On : 5/5/2006 9:21 AM
	Modified By : Vinod
	Patient Names Component 
	-------------------------
	A common component to draw the patient Names, included in "ChangePatientSubNames.jsp"
	The table definition part in "ChangePatientSubnames.jsp" is required to be included in any jsp for alignment purposes.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.sql.*, java.util.HashMap, java.util.ArrayList,eCommon.XSSRequestWrapper, webbeans.eCommon.*,java.util.*" contentType="text/html;charset=UTF-8"  %> 
<SCRIPT LANGUAGE="JavaScript"> 
	var NamePrefixArray = new Array(); 
	var NamePrefixLocArray = new Array(); 
	var PrefixSexArray = new Array();
	var NameSuffixArray = new Array();
	var NameSuffixLocArray = new Array();
	var SuffixSexArray = new Array();
	var NamePrefixLocArrayTemp = new Array();//added By Sudhakar during UAT-3
	var NameSuffixLocArrayTemp = new Array();//added By Sudhakar during UAT-3


	function populateLocalValues(obj,fromobj,toobj,lang,CalledFromFunction){		
		if(CalledFromFunction=='FatherDtls') { 
			fromobj = fromobj[0];
			toobj = toobj[0];		
		}else if(CalledFromFunction=='NewbornDtls') {
			fromobj = fromobj[1];
			toobj = toobj[1];			
		}else{
			toobj =eval("document.forms[0]."+toobj.name)				
		}
		if(document.forms[0].language_direction.value == "R"){
				if(fromobj.name == "family_name" || fromobj.name=="family_name_oth_lang"){
					var familyname = "Y";
				}
				 var xmlStr ="<root><SEARCH ";
				 xmlStr +=" /></root>";
				 var param="called_function=MP&othername="+encodeURIComponent(obj.value)+"&lang="+lang+"&familyname="+familyname;
				 var temp_jsp="../../eMP/jsp/PopulateNames.jsp?"+param;				 
				 var xmlDoc = "" ;
				 var xmlHttp = new XMLHttpRequest() ;
				 xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				 xmlHttp.open("POST",temp_jsp,false);
				 xmlHttp.send(xmlDoc);
				 responseText=trimString(xmlHttp.responseText);				 
				 var retVal =responseText.split("#")					 
				 if(retVal[1] != ""){		
											
					toobj.value = retVal[1]
				 } else {		
					if(lang=="E"){						
						toobj.value = "";						
					}
				}	
		}	
		putLocalLangPatientName('',CalledFromFunction);
		if(lang=="O"){
			putPatientName('',CalledFromFunction);
		}
	}




	async function callSearch(fromobj, toobj, field_lang,CalledFromFunction){   
		if(CalledFromFunction=='FatherDtls') { 
			fromobj = fromobj[0];
			toobj = toobj[0];		
		}else if(CalledFromFunction=='NewbornDtls') {
			fromobj = fromobj[1];
			toobj = toobj[1];	
		}else{
			fromobj = fromobj;
			toobj = toobj;	
		}
		var names_in_oth_lang = "";
		if(document.forms[0].pat_names_in_oth_lang_yn.length > 0){
			names_in_oth_lang = document.forms[0].pat_names_in_oth_lang_yn[1].value;
		}else{
			names_in_oth_lang = document.forms[0].pat_names_in_oth_lang_yn.value;
		}
		var lang_dir = ""; 
		if(document.forms[0].language_direction.length > 0) {	
			lang_dir = document.forms[0].language_direction[1].value;	
		}else{
			lang_dir = document.forms[0].language_direction.value;	
		}
		if(lang_dir == 'R'){
			var jsp_name ="../../eMP/jsp/SearchStdOtherName.jsp?names_in_oth_lang="+names_in_oth_lang+"&param_value="+encodeURIComponent(fromobj.value)+"&field_lang="+field_lang;
			if(fromobj.name == "family_name" || fromobj.name=="family_name_oth_lang"){
				jsp_name ="../../eMP/jsp/SearchStdFamilyName.jsp?names_in_oth_lang="+names_in_oth_lang+"&param_value="+encodeURIComponent(fromobj.value)+"&field_lang="+field_lang;
			}
			var retVal = new String();
			//var dialogHeight = "28";
			//var dialogWidth = "43";
			var dialogHeight = "400px";
			var dialogWidth = "700px";
			var dialogTop = "10px";
			var status = "no";
			var arguments = "";
			var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = await window.showModalDialog( jsp_name,arguments,features);
			if(retVal != null){
				var arr = retVal.split("`");
				if((fromobj.name).indexOf("oth_lang") == -1){
					fromobj.value =arr[0]
					toobj =eval("document.forms[0]."+toobj)
					if(toobj != null){
						toobj.value = arr[1]
					}
				}else{
					toobj.value = arr[0]
					fromobj.value =arr[1]
					ChangeInitCase(toobj)
				}
				fromobj.focus();
			}
		}
	}

	function sel_prefix_gen(obj,CalledFromFunction){
		var val=obj.value;
		var prefix_length;
			/*Added By Dharma Start*/
	var fatherDtlsIndex			= 0;
	var newBornDtlsIndex		= 1;
	var isNewBornChngsAppl		= "";
	var called_function			= "";
	if(document.getElementById("called_function")){
		called_function	= document.getElementById("called_function").value;
	}
	if(document.getElementById("isNewBornChngsAppl")){
		isNewBornChngsAppl	= document.getElementById("isNewBornChngsAppl").value;
	}
	if(called_function=="IP" && isNewBornChngsAppl	=="true"){
		var fatherDtlsIndex		= 1;
		var newBornDtlsIndex	= 0;
	}
	/*Added By Dharma End*/
		if((document.getElementById("op_call") && document.getElementById("op_call").value=='OA') && document.getElementById("sex").disabled){
			document.getElementById("sex").disabled=false;
		}
		if(obj.value != ""){
			if(obj.name=="name_prefix"){
				prefix_length=NamePrefixArray.length;
				for(i = 0; i < prefix_length; i++){                      
					if(unescape(NamePrefixArray[i])==val){			
						if(CalledFromFunction=='FatherDtls'){ 
								if(document.getElementById("name_prefix_oth_lang") && document.getElementById("name_prefix_oth_lang")[fatherDtlsIndex]) { // Issue Fix AAKH-SCF-0011 [IN:037789]
								document.getElementById("name_prefix_oth_lang")[fatherDtlsIndex].value=unescape(NamePrefixLocArray[i]);
							} 
						}else if(CalledFromFunction=='NewbornDtls'){
							if(document.getElementById("name_prefix_oth_lang") && document.getElementById("name_prefix_oth_lang")[newBornDtlsIndex]) { 
								document.getElementById("name_prefix_oth_lang")[newBornDtlsIndex].value=unescape(NamePrefixLocArray[i]);
							} 				
						}else{ 
							if(document.getElementById("name_prefix_oth_lang")){ 
								document.getElementById("name_prefix_oth_lang").value=unescape(NamePrefixLocArray[i]);
						}
						if(unescape(PrefixSexArray[i])!='B')
							document.getElementById("sex").value=unescape(PrefixSexArray[i]);
						else
							document.getElementById("sex").value=""; 
						}
					}
				}
			}else{
				prefix_length=NamePrefixLocArray.length;
				for(i = 0; i < prefix_length; i++){                      
					if(unescape(NamePrefixLocArray[i])==val){
						if(CalledFromFunction=='FatherDtls'){ 
							if(document.getElementById("name_prefix")[fatherDtlsIndex])			
								document.getElementById("name_prefix")[fatherDtlsIndex].value=unescape(NamePrefixArray[i]);
						}else if(CalledFromFunction=='NewbornDtls'){
							if(document.getElementById("name_prefix") && document.getElementById("name_prefix")[newBornDtlsIndex])				
								document.getElementById("name_prefix")[newBornDtlsIndex].value=unescape(NamePrefixArray[i]);
						}else{
							if(document.getElementById("name_prefix"))				
								document.getElementById("name_prefix").value=unescape(NamePrefixArray[i]); 
							if(unescape(PrefixSexArray[i])!='B')
								document.getElementById("sex").value=unescape(PrefixSexArray[i]);
							else
								document.getElementById("sex").value="";
						}							
					}
				}

			}
		}else{
			if(CalledFromFunction=='FatherDtls') { 
				if(document.getElementById("name_prefix_oth_lang") && document.getElementById("name_prefix_oth_lang")[fatherDtlsIndex])// Issue Fix AAKH-SCF-0011 [IN:037789]
					document.getElementById("name_prefix_oth_lang")[fatherDtlsIndex].value="";
				if(document.getElementById("name_prefix")[fatherDtlsIndex])
					document.getElementById("name_prefix")[fatherDtlsIndex].value="";
			}else if(CalledFromFunction=='NewbornDtls') {
				if(document.getElementById("name_prefix_oth_lang") && document.getElementById("name_prefix_oth_lang")[newBornDtlsIndex])
					document.getElementById("name_prefix_oth_lang")[newBornDtlsIndex].value="";
				if(document.getElementById("name_prefix")[newBornDtlsIndex])
					document.getElementById("name_prefix")[newBornDtlsIndex].value="";
			}else{
				if(document.getElementById("name_prefix_oth_lang"))
					document.getElementById("name_prefix_oth_lang").value="";
				if(document.getElementById("name_prefix"))
					document.getElementById("name_prefix").value="";
				document.getElementById("sex").value="";
			}
		}
		putLocalLangPatientName('',CalledFromFunction);
		putPatientName('',CalledFromFunction);
	}

	function sel_suffix_gen(obj,CalledFromFunction){
		var val=obj.value;
		var prefix_length;
		if(obj.value != ""){
		if(obj.name=="name_suffix"){
			prefix_length=NameSuffixArray.length;
			for(i = 0; i < prefix_length; i++){                      
				if(unescape(NameSuffixArray[i])==val){
					if(CalledFromFunction=='FatherDtls') { 
						if(document.getElementById("name_suffix_oth_lang") && document.getElementById("name_suffix_oth_lang")[0]) {	// Issue Fix AAKH-SCF-0011 [IN:037789]
							document.getElementById("name_suffix_oth_lang")[0].value=unescape(NameSuffixLocArray[i]);
						}
					}else if(CalledFromFunction=='NewbornDtls') {
						if(document.getElementById("name_suffix_oth_lang") && document.getElementById("name_suffix_oth_lang")[1]) {	
							document.getElementById("name_suffix_oth_lang")[1].value=unescape(NameSuffixLocArray[i]);
						}
					}else {
						if(document.getElementById("name_suffix_oth_lang")) {	
							document.getElementById("name_suffix_oth_lang").value=unescape(NameSuffixLocArray[i]);
						}
						if(unescape(SuffixSexArray[i])!='B')
							document.getElementById("sex").value=unescape(SuffixSexArray[i]);
						else
							document.getElementById("sex").value="";
					} 			
				}
			}
		}else{
			prefix_length=NameSuffixLocArray.length;
			for(i = 0; i < prefix_length; i++){                      
				if(unescape(NameSuffixLocArray[i])==val){
					if(CalledFromFunction=='FatherDtls') { 
						if(document.getElementById("name_suffix")[0]) {
							document.getElementById("name_suffix")[0].value = unescape(NameSuffixArray[i]);
						}
					} else if(CalledFromFunction=='NewbornDtls') {
						if(document.getElementById("name_suffix") && document.getElementById("name_suffix")[1]) {
							document.getElementById("name_suffix")[1].value = unescape(NameSuffixArray[i]);
						}
					} else {
						if(document.getElementById("name_suffix")) {
							document.getElementById("name_suffix").value = unescape(NameSuffixArray[i]);
						}
						if(unescape(SuffixSexArray[i])!='B')
							document.getElementById("sex").value=unescape(SuffixSexArray[i]);
						else
							document.getElementById("sex").value="";
					}				
				}
			}
		} 
		}else{
			if(CalledFromFunction=='FatherDtls') { 
				if(document.getElementById("name_suffix_oth_lang") && document.getElementById("name_suffix_oth_lang")[0]) // Issue Fix AAKH-SCF-0011 [IN:037789]
					document.getElementById("name_suffix_oth_lang")[0].value="";
				if(document.getElementById("name_suffix")[0])
					document.getElementById("name_suffix")[0].value="";
			}else if(CalledFromFunction=='NewbornDtls'){
				if(document.getElementById("name_suffix_oth_lang") && document.getElementById("name_suffix_oth_lang")[1])
					document.getElementById("name_suffix_oth_lang")[1].value="";
				if(document.getElementById("name_suffix")[1])
					document.getElementById("name_suffix")[1].value="";

			}else{
				if(document.getElementById("name_suffix_oth_lang"))
					document.getElementById("name_suffix_oth_lang").value="";
				if(document.getElementById("name_suffix"))
					document.getElementById("name_suffix").value="";
				document.getElementById("sex").value="";
			}
		}
		putLocalLangPatientName('',CalledFromFunction);
		putPatientName('',CalledFromFunction);
	}

function CheckForPipeChars(event){
		var strCheck = '|,~,=,#';	//Added by Sathish.S for 20824 on Thursday, April 22, 2010
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);  // Get key value from key code
		if (strCheck.indexOf(key) == -1) return true;  // Not a valid key
		if( (event.keyCode >= 97) && (event.keyCode <= 122) )
			return (event.keyCode -= 32);
		return false ;
}

/*	
function pipeCharsChk(elementRef)
{
 var checkValue = new String(elementRef.value);
 var newValue = ''; 
 for (var i=0; i<checkValue.length; i++)
 {
  var currentChar = checkValue.charAt(i);

  if (currentChar != '|')  
   newValue += currentChar;
 }
 
 elementRef.value = newValue;
}*/
//Below line added for this SCF AAKH-SCF-0261
function SpecialCharsChk(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-+';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) ) 
		return (event.keyCode -= 32);
	return true ;
}

function isValidCharacter(elementRef) {   
	
   var regExp ="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-+";
   var checkValue = new String(elementRef.value);     
 for (var i=0; i<checkValue.length; i++)
 {	
	if (regExp.indexOf(checkValue.charAt(i)) == -1) {	
	        var msg = getMessage("RES_MOB_NO_SPL_NOT_ALLOWED",'MP');
            elementRef.value = "";
			alert(msg);
			elementRef.focus();
			return false;  	
		  
	}
	  
 }  
}

//End AAKH-SCF-0261

</SCRIPT>
<% 
    Connection conn			= null;
	PreparedStatement pstmt=null ;
	
    ResultSet rs=null ;
	try
	{
	String language_direction = "";
	String name_comp_visibility = "visibility:hidden";
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String facility_id=checkForNull((String)session.getAttribute("facility_id")); //added for the incident 34901

	int count=0;


	Properties p					=	 (java.util.Properties) session.getValue("jdbc");
	conn							=	 ConnectionManager.getConnection(request);
 	HashMap hash_Map				=	 new HashMap();
 	HashMap hash_Map1				=	 new HashMap();
	HashMap Name_Order 			=	 new HashMap(); 
	String downtime_regn_yn		= "N";//Added By Dharma on Sep 9th 2016 against PMG2015-GDOH-CRF-0006.1 [IN061724]

		pstmt = conn.prepareStatement( "select count(*) as total from sm_language where language_direction='R' and eff_status='E'" ) ;
		 
		rs = pstmt.executeQuery() ;
             
			
        if ( rs != null && rs.next() ) 
		 {
		  count = rs.getInt("total");
		 }

		
		if ( count==1 ) 
		{
			 language_direction = "R" ;
			 name_comp_visibility = "visibility:visible";
		}else
		{
			 language_direction = "L" ;
			 name_comp_visibility = "visibility:hidden";
		}


		 if(pstmt != null) pstmt.close();
		 if(rs != null) rs.close();


	String patient_id					= checkForNull(request.getParameter("patient_id"));
	String mother_patient_id			= checkForNull(request.getParameter("mother_patient_id"));
	String populatenewBornDtls			= checkForNull(request.getParameter("populatenewBornDtls"),"N");
	String group						= checkForNull(request.getParameter("group"));
	String CalledFromFunction			= checkForNull(request.getParameter("CalledFromFunction"));
	String isNewBornChngsAppl			= checkForNull(request.getParameter("isNewBornChngsAppl"),"false");
	String calling_module_id			= checkForNull(request.getParameter("calling_module_id"));
	String a_name_prefix				= checkForNull(request.getParameter("a_name_prefix"));
	
	String a_name_suffix				= checkForNull(request.getParameter("a_name_suffix"));
	String a_family_name				= checkForNull(request.getParameter("a_family_name"));
	String a_first_name					= checkForNull(request.getParameter("a_first_name"));
	
	String a_second_name				= checkForNull(request.getParameter("a_second_name"));
	String a_third_name					= checkForNull(request.getParameter("a_third_name"));

	String a_name_prefix_loc_lang		= checkForNull(request.getParameter("a_name_prefix_loc_lang"));
	String a_first_name_loc_lang		= checkForNull(request.getParameter("a_first_name_loc_lang"));
	String a_second_name_loc_lang		= checkForNull(request.getParameter("a_second_name_loc_lang"));
	String a_third_name_loc_lang		= checkForNull(request.getParameter("a_third_name_loc_lang"));
	String a_family_name_loc_lang		= checkForNull(request.getParameter("a_family_name_loc_lang"));
	String a_name_suffix_loc_lang		= checkForNull(request.getParameter("a_name_suffix_loc_lang"));	 	
	String nb_father_name_mandatory_yn	= "";


	String Name_Prefix_Accept_Yn		= checkForNull(request.getParameter("Name_Prefix_Accept_Yn"));
	String Name_Prefix_Reqd_Yn			= checkForNull(request.getParameter("Name_Prefix_Reqd_Yn"));
	String Name_Suffix_Accept_Yn		= checkForNull(request.getParameter("Name_Suffix_Accept_Yn"));
	String Name_Suffix_Reqd_Yn			= checkForNull(request.getParameter("Name_Suffix_Reqd_Yn"));
	String First_Name_Accept_Yn			= checkForNull(request.getParameter("First_Name_Accept_Yn"));
	String First_Name_Prompt			= checkForNull(request.getParameter("First_Name_Prompt"));
	String First_Name_Reqd_Yn			= checkForNull(request.getParameter("First_Name_Reqd_Yn"));
	String Second_Name_Accept_Yn		= checkForNull(request.getParameter("Second_Name_Accept_Yn"));
	String Second_Name_Prompt			= checkForNull(request.getParameter("Second_Name_Prompt"));
	String Third_Name_Accept_Yn			= checkForNull(request.getParameter("Third_Name_Accept_Yn"));
	String Third_Name_Prompt			= checkForNull(request.getParameter("Third_Name_Prompt"));
	String Family_Name_Accept_Yn		= checkForNull(request.getParameter("Family_Name_Accept_Yn"));
	String Family_Name_Prompt			= checkForNull(request.getParameter("Family_Name_Prompt"));
	String Second_Name_Reqd_Yn			= checkForNull(request.getParameter("Second_Name_Reqd_Yn"));
	String Third_Name_Reqd_Yn			= checkForNull(request.getParameter("Third_Name_Reqd_Yn"));
	String Family_Name_Reqd_Yn			= checkForNull(request.getParameter("Family_Name_Reqd_Yn"));
	String pat_name_as_multipart_yn		= checkForNull(request.getParameter("pat_name_as_multipart_yn"));
	String family_org_id_accept_yn		= checkForNull(request.getParameter("family_org_id_accept_yn "));
	String Name_Suffix_Prompt			= checkForNull(request.getParameter("Name_Suffix_Prompt"));
	String Name_Prefix_Prompt			= checkForNull(request.getParameter("Name_Prefix_Prompt"));
	String Family_Name_Order			= checkForNull(request.getParameter("Family_Name_Order"));
	String First_Name_Order			= checkForNull(request.getParameter("First_Name_Order"));
	String Second_Name_Order			= checkForNull(request.getParameter("Second_Name_Order"));
	String Third_Name_Order			= checkForNull(request.getParameter("Third_Name_Order"));	
	String first_name_length			= checkForNull(request.getParameter("first_name_length"),"0");
	String second_name_length			= checkForNull(request.getParameter("second_name_length"),"0");
	String third_name_length			= checkForNull(request.getParameter("third_name_length"),"0");
	String family_name_length			= checkForNull(request.getParameter("family_name_length"),"0");	
	String family_name_loc_lang_prompt = checkForNull(request.getParameter("family_name_loc_lang_prompt"));
	String pat_name_in_loc_lang_reqd_yn = checkForNull(request.getParameter("pat_name_in_loc_lang_reqd_yn"),"N");
	String name_suffix_loc_lang_prompt = checkForNull(request.getParameter("name_suffix_loc_lang_prompt"));
	String first_name_loc_lang_prompt = checkForNull(request.getParameter("first_name_loc_lang_prompt"));
	String second_name_loc_lang_prompt = checkForNull(request.getParameter("second_name_loc_lang_prompt"));
	String third_name_loc_lang_prompt = checkForNull(request.getParameter("third_name_loc_lang_prompt"));
	String name_prefix_loc_lang_prompt = checkForNull(request.getParameter("name_prefix_loc_lang_prompt"));		
	String names_in_oth_lang_yn = checkForNull(request.getParameter("names_in_oth_lang_yn"),"N");


	if(CalledFromFunction!=null && CalledFromFunction.equals("FatherDtls")){

		nb_father_name_mandatory_yn = checkForNull(request.getParameter("nb_father_name_mandatory_yn"),"N");
		/*
		stmt=conn.createStatement();
		rs=stmt.executeQuery("select nb_father_name_mandatory_yn from mp_param where module_id='MP'");
		if(rs!=null && rs.next()){					
			nb_father_name_mandatory_yn=rs.getString("nb_father_name_mandatory_yn")==null?"N":rs.getString("nb_father_name_mandatory_yn");
		}
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();
		*/
	}

	if(CalledFromFunction!=null && !CalledFromFunction.equals("FatherDtls") && !CalledFromFunction.equals("NewbornDtls")) {

		hash_Map	= eMP.ChangePatientDetails.getSetupData(facility_id,group, conn,p);

		Name_Prefix_Accept_Yn		= checkForNull((String) hash_Map.get("Name_Prefix_Accept_Yn"));
		Name_Prefix_Reqd_Yn			= checkForNull((String) hash_Map.get("Name_Prefix_Reqd_Yn"));
		Name_Suffix_Accept_Yn		= checkForNull((String) hash_Map.get("Name_Suffix_Accept_Yn"));
		Name_Suffix_Reqd_Yn			= checkForNull((String) hash_Map.get("Name_Suffix_Reqd_Yn"));
		First_Name_Accept_Yn			= checkForNull((String) hash_Map.get("First_Name_Accept_Yn"));
		First_Name_Prompt			= checkForNull((String) hash_Map.get("First_Name_Prompt"));
		First_Name_Reqd_Yn			= checkForNull((String) hash_Map.get("First_Name_Reqd_Yn"));
		Second_Name_Accept_Yn		= checkForNull((String) hash_Map.get("Second_Name_Accept_Yn"));
		Second_Name_Prompt			= checkForNull((String) hash_Map.get("Second_Name_Prompt"));
		Third_Name_Accept_Yn			= checkForNull((String) hash_Map.get("Third_Name_Accept_Yn"));
		Third_Name_Prompt			= checkForNull((String) hash_Map.get("Third_Name_Prompt"));
		Family_Name_Accept_Yn		= checkForNull((String) hash_Map.get("Family_Name_Accept_Yn"));
		Family_Name_Prompt			= checkForNull((String) hash_Map.get("Family_Name_Prompt"));

		Second_Name_Reqd_Yn			= checkForNull((String) hash_Map.get("Second_Name_Reqd_Yn"));
		Third_Name_Reqd_Yn			= checkForNull((String) hash_Map.get("Third_Name_Reqd_Yn"));
		Family_Name_Reqd_Yn			= checkForNull((String) hash_Map.get("Family_Name_Reqd_Yn"));
		pat_name_as_multipart_yn		= checkForNull((String) hash_Map.get("pat_name_as_multipart_yn"));
		family_org_id_accept_yn		= checkForNull((String) hash_Map.get("family_org_id_accept_yn "));
		Name_Suffix_Prompt			= checkForNull((String) hash_Map.get("Name_Suffix_Prompt"));
		Name_Prefix_Prompt			= checkForNull((String) hash_Map.get("Name_Prefix_Prompt"));
		Family_Name_Order			= checkForNull((String) hash_Map.get("Family_Name_Order"));
		First_Name_Order			= checkForNull((String) hash_Map.get("First_Name_Order"));
		Second_Name_Order			= checkForNull((String) hash_Map.get("Second_Name_Order"));
		Third_Name_Order			= checkForNull((String) hash_Map.get("Third_Name_Order")); 	
		first_name_length			= checkForNull((String) hash_Map.get("first_name_length"),"0");
		second_name_length			= checkForNull((String) hash_Map.get("second_name_length"),"0");
		third_name_length			= checkForNull((String) hash_Map.get("third_name_length"),"0");
		family_name_length			= checkForNull((String) hash_Map.get("family_name_length"),"0"); 
		names_in_oth_lang_yn		= checkForNull((String)hash_Map.get("names_in_oth_lang_yn"),"N");
	}

	if((CalledFromFunction!=null && CalledFromFunction.equals("FatherDtls")) && nb_father_name_mandatory_yn.equals("N")){
		//name component settings for father details in new born
		Name_Prefix_Reqd_Yn="N";
		Name_Suffix_Reqd_Yn="N";
		First_Name_Reqd_Yn="N";
		Second_Name_Reqd_Yn="N";
		Third_Name_Reqd_Yn="N";
		Family_Name_Reqd_Yn="N";
	}
	/* Added for HSA-CRF-0192 [IN:049807] By Dharma on 15th Oct 2014 Start*/
	String familyNametextBoxSize	= "20";
	if(!First_Name_Accept_Yn.equals("Y") && !Second_Name_Accept_Yn.equals("Y") && !Third_Name_Accept_Yn.equals("Y") && Family_Name_Accept_Yn.equals("Y")){
		
		familyNametextBoxSize	= family_name_length;

	}
	/* Added for HSA-CRF-0192 [IN:049807] By Dharma on 15th Oct 2014 End*/



	 /* Prompts and Orders are placed in Hash Map for easy retrieval */
	Name_Order.put(Family_Name_Order,"Family_Name_Order");
	Name_Order.put(First_Name_Order,"First_Name_Order");
	Name_Order.put(Second_Name_Order,"Second_Name_Order");
	Name_Order.put(Third_Name_Order,"Third_Name_Order");

	String name_suffix			= "";
	String name_prefix			= "";
	String family_name		= "";
	String first_name			= "";
	String second_name		= "";
	String third_name			= "";

	int		 emptyCnt			= 0;  /*To Count the Missing Name Fields as per MP Param*/

	ArrayList arrayList2 = new ArrayList();
	arrayList2 = eMP.ChangePatientDetails.getResultRows(conn,"mp_name_prefix",p);
	out.println("<script>");
	int a = 0;
	Set set = new HashSet();//added By Sudhakar during UAT-3
	for(int i=0;i<arrayList2.size();i+=3) 
	{
		set.add((String)arrayList2.get(i+1));//added By Sudhakar during UAT-3
		out.print("NamePrefixArray["+a+"]=escape(\""+(String)arrayList2.get(i)+"\");");
		out.print("NamePrefixLocArray["+a+"]=escape(\""+(String)arrayList2.get(i+1)+"\");");
		out.print("PrefixSexArray["+a+"]=escape(\""+(String)arrayList2.get(i+2)+"\");");				
		a++;
	} 
	//added By Sudhakar during UAT-3 starts
	Set sortedSet = new TreeSet(set);	
	Iterator iterator = sortedSet.iterator();
	a = 0;
	while(iterator.hasNext()){
		String prefix_loc=(String)iterator.next();
		out.print("NamePrefixLocArrayTemp["+a+"]=escape(\""+prefix_loc+"\");");
		a++;
	}
	set.clear();
	sortedSet.clear();
	//added By Sudhakar during UAT-3 ends
	out.println("</script>");
	arrayList2.clear();
	arrayList2 = eMP.ChangePatientDetails.getResultRows(conn,"mp_name_suffix2",p);
	out.println("<script>");
	a = 0;
	for(int i=0;i<arrayList2.size();i+=3) 
	{
		set.add((String)arrayList2.get(i+1));//added By Sudhakar during UAT-3
		out.print("NameSuffixArray["+a+"]=escape(\""+(String)arrayList2.get(i)+"\");");
		out.print("NameSuffixLocArray["+a+"]=escape(\""+(String)arrayList2.get(i+1)+"\");");
		out.print("SuffixSexArray["+a+"]=escape(\""+(String)arrayList2.get(i+2)+"\");");				
		a++;
	} 
	//added By Sudhakar during UAT-3 starts
	sortedSet = new TreeSet(set);	
	iterator = sortedSet.iterator();
	a = 0;
	while(iterator.hasNext()){
		String suffix_loc=(String)iterator.next();
		out.print("NameSuffixLocArrayTemp["+a+"]=escape(\""+suffix_loc+"\");");
		a++;
	}
	//added By Sudhakar during UAT-3 ends
	out.println("</script>");
	
	if(CalledFromFunction.equals("ChangePatDtls")) 
	{
		 hash_Map1				= eMP.ChangePatientDetails.getPatientData(patient_id, conn,p);
		/*Added By Dharma on Sep 9th 2016 against PMG2015-GDOH-CRF-0006.1 [IN061724] Start*/
		 downtime_regn_yn=checkForNull((String) hash_Map1.get("downtime_regn_yn"));
     	if(checkForNull((String)hash_Map1.get("regn_date")).equals("") && downtime_regn_yn.equals("Y")){
			hash_Map1.put("name_suffix","");
			hash_Map1.put("first_name","");
			hash_Map1.put("second_name","");
			hash_Map1.put("third_name","");
			hash_Map1.put("family_name","");
		
		}
		/*Added By Dharma on Sep 9th 2016 against PMG2015-GDOH-CRF-0006.1 [IN061724] End*/
		 
		 name_suffix			= checkForNull((String) hash_Map1.get("name_suffix"));
		 name_prefix			= checkForNull((String) hash_Map1.get("name_prefix"));
		 first_name				= checkForNull((String) hash_Map1.get("first_name"));
		 second_name			= checkForNull((String) hash_Map1.get("second_name"));
		 third_name				= checkForNull((String) hash_Map1.get("third_name"));
		 family_name			= checkForNull((String) hash_Map1.get("family_name"));
	}
	if(CalledFromFunction.equals("NewbornDtls") && populatenewBornDtls.equals("N")) {
		 hash_Map1				= eMP.ChangePatientDetails.getPatientData(mother_patient_id, conn,p);
		 //name_suffix			= checkForNull((String) hash_Map1.get("name_suffix"));
		 //name_prefix			= checkForNull((String) hash_Map1.get("name_prefix"));
		 /*first_name			= checkForNull((String) hash_Map1.get("first_name"));
		 second_name			= checkForNull((String) hash_Map1.get("second_name"));
		 third_name				= checkForNull((String) hash_Map1.get("third_name"));
		 family_name			= checkForNull((String) hash_Map1.get("family_name"));*/
	}
%>
	<tr>
		<%
				if(Name_Prefix_Accept_Yn.equals("Y")) 
				{ %>
					<input type='hidden' name='name_prefix_prompt' id='name_prefix_prompt' value='<%=Name_Prefix_Prompt%>'>
					<td  class='label'  nowrap><%=Name_Prefix_Prompt%>
					<img id= 'name_prefix_img' src='../../eCommon/images/mandatory.gif' style='visibility:hidden'></img>
					<% 
					if ( (Name_Prefix_Reqd_Yn.equals("Y")) || (( checkForNull((String)hash_Map1.get("MembershipType"))).equals("1")))
					{ 
						if ( Name_Prefix_Reqd_Yn.equals("Y")) {
						%>
						<script>
							if(document.forms[0].all.name_prefix_img.length > 0)
								document.forms[0].all.name_prefix_img[1].style.visibility='visible';
							else 
								document.forms[0].all.name_prefix_img.style.visibility='visible';
						</script>
						<input type='hidden' name='name_prefix_reqd_yn' id='name_prefix_reqd_yn' value='Y'>
						<%
						} else {
							// Added by Muthu on 23/01/2010 against incident IN018465 to correct the issue prefix should not be mandatory for newborn and father patient ids even though name_pfx_reqd_for_org_mem_yn is set to Y in MP Param 
							if(!CalledFromFunction.equals("FatherDtls") && !CalledFromFunction.equals("NewbornDtls")) {	
						%>
								<script>							
									if(document.forms[0].all.name_prefix_img && document.forms[0].all.name_pfx_reqd_for_org_mem_yn.value=='Y') {
										document.forms[0].all.name_prefix_img.style.visibility='visible';
									} else if(document.forms[0].all.name_prefix_img) {
										document.forms[0].all.name_prefix_img.style.visibility='hidden';
									}							
								</script>
								<input type='hidden' name='name_prefix_reqd_yn' id='name_prefix_reqd_yn' value='Y'>
						<%
							} else {
								%>
								<input type='hidden' name='name_prefix_reqd_yn' id='name_prefix_reqd_yn' value='N'>
								<%
							}
							// End of Comment
						}%>
						</td>
<%					}
					else
					{ 
						%><input type='hidden' name='name_prefix_reqd_yn' id='name_prefix_reqd_yn' value='N'></td> <% 
					}
					%><td class='label'>&nbsp;</td><%
				}
				
			/*If Multi Part Name is acceptable; Based on the name order in MP Param paint the prompts for names*/
			   if  (pat_name_as_multipart_yn.equals("Y"))
			   {
				     String order = "";
					 for(int i=1;i<=4;++i)
					 {
						 if (Name_Order.get((new Integer(i)).toString()) != null)
							 order = (String)Name_Order.get((new Integer(i)).toString());
						 else
							 order = ""; 

						
						 if (order.equals("First_Name_Order"))
						 {
							if(First_Name_Accept_Yn.equals("Y")) 
							{ 
								%>
								<td class='label'><%=First_Name_Prompt%>
								<%
								if(First_Name_Reqd_Yn.equals("Y")) 
								{%>
									<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='Y'></input>
									<img src='../../eCommon/images/mandatory.gif'></img></td>
									<input type='hidden' name='first_name_prompt' id='first_name_prompt' value="<%=First_Name_Prompt%>">
								<%} else { %> 
									<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='N'></input></td> 
									<input type='hidden' name='first_name_prompt' id='first_name_prompt' value="<%=First_Name_Prompt%>">
									<% }
									%><td class='label' >&nbsp;</td><%
							}
							 else
								emptyCnt++;						 
						 }
						 else
						 if (order.equals("Second_Name_Order"))
						 {
							 if(Second_Name_Accept_Yn.equals("Y")) 
							{
								%>
								<td  class='label' ><%=Second_Name_Prompt%>
								<% if(Second_Name_Reqd_Yn.equals("Y")) { %>
								<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='Y'></input><img src='../../eCommon/images/mandatory.gif'></img></td>
								<input type='hidden' name='second_name_prompt' id='second_name_prompt' value="<%=Second_Name_Prompt%>">
								<% } else { %> 
								<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='N'></input>
								<input type='hidden' name='second_name_prompt' id='second_name_prompt' value="<%=Second_Name_Prompt%>"></td> <% }
								%><td class='label' >&nbsp;</td><%
							}
							else
							{
								emptyCnt++;
							}
						 }
						 else
						 if (order.equals("Third_Name_Order"))
						 {
							 if (Third_Name_Accept_Yn.equals("Y") )
							{ 
								%>
								<td  class='label' ><%=Third_Name_Prompt%>
							   <% if(Third_Name_Reqd_Yn.equals("Y")) { %>
									<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='Y'></input><img src='../../eCommon/images/mandatory.gif'></img></td>
									<input type='hidden' name='third_name_prompt' id='third_name_prompt' value="<%=Third_Name_Prompt%>">
								<% } else { %> 
								<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='N'></input>
								<input type='hidden' name='third_name_prompt' id='third_name_prompt' value="<%=Third_Name_Prompt%>">
								</td> <% }
								%><td class='label' >&nbsp;</td><%
							}
							else
							{
								emptyCnt++;
							}
						 }
						 else
						 if (order.equals("Family_Name_Order"))
						 {
							 if (Family_Name_Accept_Yn.equals("Y") ) 
							{  %>
								<td  class='label'  nowrap ><%=Family_Name_Prompt%>
								<%
									 if(Family_Name_Reqd_Yn.equals("Y")) { %><img src='../../eCommon/images/mandatory.gif'  style='visibility:visible;'></img></td><input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='Y'></input>
									<input type='hidden' name='family_name_prompt' id='family_name_prompt' value="<%=Family_Name_Prompt%>">
								  <% } else { %>  <input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='N'></input><input type='hidden' name='family_name_prompt' id='family_name_prompt' value="<%=Family_Name_Prompt%>"></td> <% }
								  %><td class='label' >&nbsp;</td><%
							}
							else
							{
								emptyCnt++;
							}
						 }
						 else
						 {
							 emptyCnt++;
						 }
					}
			   }else{	   

					if(Family_Name_Accept_Yn.equals("Y")) 
					{ 
						%>
						<td  class='label'  ><%=Family_Name_Prompt%>
							<%  if(Family_Name_Reqd_Yn.equals("Y")) { %>
							<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='Y'></input><img src='../../eCommon/images/mandatory.gif' style='visibility:visible;'></img></td>
							<input type='hidden' name='family_name_prompt' id='family_name_prompt' value="<%=Family_Name_Prompt%>">
						<% 	} else { %> <input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='N'></input></td> <% }
					}
				}
					/*  if (pat_name_as_multipart_yn.equals("Y") */
				if(Name_Suffix_Accept_Yn.equals("Y")) 
				{ 
					%>
					<td  class='label' ><%=Name_Suffix_Prompt%>
					<input type='hidden' name='name_suffix_prompt' id='name_suffix_prompt' value="<%=Name_Suffix_Prompt%>">
					<%
					if(Name_Suffix_Reqd_Yn.equals("Y")) 
					{ 
						%>
						<img src='../../eCommon/images/mandatory.gif'></img><input type='hidden' name='name_suffix_reqd_yn' id='name_suffix_reqd_yn' value='Y'></input></td>
					<% }else{%><input type='hidden' name='name_suffix_reqd_yn' id='name_suffix_reqd_yn' value='N'></input></td>
					<td class='label'>&nbsp;</td>
				   <%	 }
				}else{		
					if(Name_Prefix_Accept_Yn.equals("Y")){
						emptyCnt++;
					}
					%><input type='hidden' name='name_suffix_reqd_yn' id='name_suffix_reqd_yn' value='N'><%
				}
				 /*To fill the blank spaces in the table with blank TDs*/
				for(int j=1;j<=emptyCnt;++j)
					{%><td class='label' colspan='2'>&nbsp;</td><%}
				%>
			</tr>
			<tr>

				<%	
				if(Name_Prefix_Accept_Yn.equals("Y"))
				{
					if(pat_name_as_multipart_yn.equals("N")) 
					{%>
						<td  class='fields' ><Select name='name_prefix' id='name_prefix' onchange="sel_prefix_gen(this,'<%=CalledFromFunction%>');putPatientName(this,'<%=CalledFromFunction%>');if (document.forms[0].entitlement_by_pat_cat_yn && document.forms[0].entitlement_by_pat_cat_yn.value=='Y'){getPatCategory();}">

					<%}
					else
					{ 
						%>
						<td    class='fields' ><Select name='name_prefix' id='name_prefix'  onchange="sel_prefix_gen(this,'<%=CalledFromFunction%>');putPatientName(this,'<%=CalledFromFunction%>');if (  document.forms[0].entitlement_by_pat_cat_yn && document.forms[0].entitlement_by_pat_cat_yn.value=='Y'){getPatCategory();}">
					<% 
					}
					%>
						<Option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
						<script>
							prefix_length = NamePrefixArray.length;
								for(i = 0; i < prefix_length; i++) {
									opt = document.createElement("OPTION");
									name_pfx = unescape(NamePrefixArray[i]);
									opt.text = name_pfx;
									opt.value = name_pfx; 
									
									if('<%=isNewBornChngsAppl%>'=='true' && "<%=calling_module_id%>" == "IP"){
									if('<%=CalledFromFunction%>'=='NewbornDtls') {
											if(document.forms[0].name_prefix){
												document.forms[0].name_prefix.options.add(opt);		
											}
										} else { 
											if(document.forms[0].name_prefix && document.forms[0].name_prefix[1])  {
											document.forms[0].name_prefix[1].options.add(opt);		
											}
										} 
									} else { 
										if('<%=CalledFromFunction%>'=='NewbornDtls') {
											if(document.forms[0].name_prefix && document.forms[0].name_prefix[1])  {
												document.forms[0].name_prefix[1].options.add(opt);		
											}
										} else { 
											if(document.forms[0].name_prefix){
											document.forms[0].name_prefix.options.add(opt);		
											}
										} 
									} 

		                            //document.forms[0].name_prefix.add(opt);
									if('<%=CalledFromFunction%>' == 'ChangePatDtls' || "<%=a_name_prefix%>"!='') {
										if('<%=CalledFromFunction%>' == 'ChangePatDtls' && name_pfx == "<%=name_prefix%>") {
											opt.selected=true;
										} else if(name_pfx == "<%=a_name_prefix%>") {							
											opt.selected=true;
										} 
									}	
								}
						</script>
						
						<% /*
						array_List1 = eMP.ChangePatientDetails.getResultRows(conn,"mp_name_prefix0",p);
						for(int i=0;i<array_List1.size();i++) {
						out.print("<Option value=\"" + (String)array_List1.get(i) + "\"" );
						if(CalledFromFunction.equals("ChangePatDtls") || !a_name_prefix.equals(""))
						{
							if((CalledFromFunction.equals("ChangePatDtls")) && ((String)array_List1.get(i)).equals(name_prefix)) 
								out.print(" selected >"+(String)array_List1.get(i)+"</option>");
							else if(((String)array_List1.get(i)).equals(a_name_prefix))
								out.print(" selected >"+(String)array_List1.get(i)+"</option>");
							else  out.print(" > " + (String)array_List1.get(i)+"</option>");
						} else out.print(" > " + (String)array_List1.get(i)+"</option>");
						} 
						*/
						%>
						</Select></td><td class='label'>&nbsp;</td>
					 <%
					if  (CalledFromFunction.equals("ChangePatDtls") && family_org_id_accept_yn.equals("Y"))
					{ %>
						<script>
								if (document.forms[0].all.family_org_membership.value=='1')
								{
									if (document.forms[0].all.name_prefix_img)
										document.forms[0].all.name_prefix_img.style.visibility='hidden';
									document.forms[0].all.name_prefix.disabled=true;
								} 
								else if(document.forms[0].all.name_prefix_img)
									document.forms[0].all.name_prefix.disabled=false;
						</script><%}
						}
						else
						{	
						}
			  
			    emptyCnt = 0;

			   	if (pat_name_as_multipart_yn.equals("Y") )
				{
					 String order = "";
					 for(int i=1;i<=4;++i)
					 {
						 if (Name_Order.get((new Integer(i)).toString()) != null)
							 order = (String)Name_Order.get((new Integer(i)).toString());
						 else
							 order = ""; 

						

						 if (order.equals("First_Name_Order"))
						 {
							if(First_Name_Accept_Yn.equals("Y")) 
							{ 
								%>
								<td   class='fields'  nowrap>
								<%
								out.print("<input type='text' name='first_name' id='first_name' maxlength='"+first_name_length+"' size='20' onKeyPress='return CheckForPipeChars(event)'   onblur=makeValidString(this);ChangeInitCase(this);putPatientName(this,'"+CalledFromFunction+"');");
								if(names_in_oth_lang_yn.equals("Y")){
									out.print("populateLocalValues(this,first_name,first_name_oth_lang,'E','"+CalledFromFunction+"')");
								}
								if(CalledFromFunction.equals("ChangePatDtls") || !a_first_name.equals("") || CalledFromFunction.equals("NewbornDtls"))
								{
									if(CalledFromFunction.equals("ChangePatDtls") || (CalledFromFunction.equals("NewbornDtls") && populatenewBornDtls.equals("N")))
									{
										if(!(((String)hash_Map1.get("first_name")).equals("")))
											out.print(" value=\""+(String)hash_Map1.get("first_name")+"\">");
										else out.print(" value=\"\" >"); 
									} 
									else if(!a_first_name.equals(""))
										out.print(" value=\""+a_first_name+"\">");
									else out.print(" value=\"\" >"); 
								}
								else out.print(" value = \"\" >");%><input type='button' style='<%=name_comp_visibility%>' class='button' value='?' onclick="callSearch(first_name,'first_name_oth_lang','English','<%=CalledFromFunction%>')" name='bf'></td><td class='label' ></td> <%
							}
							else
							{
								emptyCnt++;
							}
						 }
						 else
						 if (order.equals("Second_Name_Order"))
						 {
							 if (Second_Name_Accept_Yn.equals("Y")) 
							{ 
								%>
								<td   class='fields'  nowrap>
								<%  out.print("<input type='text' name='second_name' id='second_name' maxlength='"+second_name_length+"' size='20' onKeyPress='return CheckForPipeChars(event)' onblur=makeValidString(this);ChangeInitCase(this);putPatientName(this,'"+CalledFromFunction+"');");
								if(names_in_oth_lang_yn.equals("Y")){
									out.print("populateLocalValues(this,second_name,second_name_oth_lang,'E','"+CalledFromFunction+"')");
								}
								if(CalledFromFunction.equals("ChangePatDtls") || !a_second_name.equals("") || CalledFromFunction.equals("NewbornDtls"))
								{
									if(CalledFromFunction.equals("ChangePatDtls") || (CalledFromFunction.equals("NewbornDtls") && populatenewBornDtls.equals("N")))
									{
										if (!(((String)hash_Map1.get("second_name"))).equals(""))
											out.print(" value=\""+checkForNull((String)hash_Map1.get("second_name"))+"\">");
										else out.print(" value = \"\" >");
									}
									else if(!a_second_name.equals(""))
									{
										out.print(" value=\""+a_second_name+"\">");
									}
									else out.print(" value = \"\" >");
								} else out.print(" value = \"\" >");%><input type='button' style='<%=name_comp_visibility%>' class='button' value='?' onclick="callSearch(second_name,'second_name_oth_lang','English','<%=CalledFromFunction%>')" name='bs'></td><td class='label' >&nbsp;</td><%
							}
							else
							{
								emptyCnt++;
							}
						 }
						 else
						 if (order.equals("Third_Name_Order"))
						 {
							if(Third_Name_Accept_Yn.equals("Y")) 
							{ 
								%>
								<td class='fields' nowrap>
								<%  out.print("<input type='text' name='third_name' id='third_name' maxlength='"+third_name_length+"' size='20' onKeyPress='return CheckForPipeChars(event)'   onblur=makeValidString(this);ChangeInitCase(this);putPatientName(this,'"+CalledFromFunction+"');");
								if(names_in_oth_lang_yn.equals("Y")){
									out.print("populateLocalValues(this,third_name,third_name_oth_lang,'E','"+CalledFromFunction+"')");
								}
								if(CalledFromFunction.equals("ChangePatDtls") || !a_third_name.equals("") || CalledFromFunction.equals("NewbornDtls"))
								{
									if(CalledFromFunction.equals("ChangePatDtls") || (CalledFromFunction.equals("NewbornDtls") && populatenewBornDtls.equals("N")))
									{
										if(!(((String)hash_Map1.get("third_name")).equals("")))
											out.print(" value=\""+(String)hash_Map1.get("third_name")+"\">");
										else out.print(" value = \"\" >");    
									}
									else if(!a_third_name.equals(""))
									{
										out.print(" value=\""+a_third_name+"\">");
									}
									else out.print(" value = \"\" >");    
								}else out.print(" value = \"\" >");%><input type='button' style='<%=name_comp_visibility%>' class='button' value='?' onclick="callSearch(third_name,'third_name_oth_lang','English','<%=CalledFromFunction%>')" name='bt'></td><td class='label' >&nbsp;</td> <%
							}
							else
							{
								emptyCnt++;
							}
						 }
						 else
						 if (order.equals("Family_Name_Order"))
						 {
							 if(Family_Name_Accept_Yn.equals("Y")) 
							{   
								out.print("<td  class='fields'  nowrap><input type='text' name='family_name' id='family_name' maxlength='"+family_name_length+"' size='"+familyNametextBoxSize+"' onKeyPress='return CheckForPipeChars(event)'  onblur=makeValidString(this);ChangeInitCase(this);putPatientName(this,'"+CalledFromFunction+"');");
								if(names_in_oth_lang_yn.equals("Y")){
									out.print("populateLocalValues(this,family_name,family_name_oth_lang,'E','"+CalledFromFunction+"')");
								}
								if(CalledFromFunction.equals("ChangePatDtls") || !a_family_name.equals("") || CalledFromFunction.equals("NewbornDtls"))
								{
								if((CalledFromFunction.equals("ChangePatDtls") || (CalledFromFunction.equals("NewbornDtls") && populatenewBornDtls.equals("N"))) && !(((String)hash_Map1.get("family_name")).equals("")))
										
									out.print(" value=\""+(String)hash_Map1.get("family_name")+"\">");
									else if(!a_family_name.equals(""))
										out.print(" value=\""+a_family_name+"\">");
									else out.print(" value = \"\" >");    
								} else out.print(" value = \"\" >");    
								if (pat_name_as_multipart_yn.equals("Y")) { %><input type='button' style='<%=name_comp_visibility%>' class='button' value='?' onclick="callSearch(family_name,'family_name_oth_lang','English','<%=CalledFromFunction%>')" name='bfam'> 
								<% } %> 
								</td><td class='label' >&nbsp;</td>
								<% 
							}
							else
							{
								emptyCnt++;
							}
						 }
						  else
						  {
							 emptyCnt++;
						  }
						}
			}
			/* END of	if (pat_name_as_multipart_yn.equals("Y") ) */
			else
			{
				//new
				if(Family_Name_Accept_Yn.equals("Y"))  
			    { 
				out.print("<td class='fields' nowrap ><input type='text' name='family_name' id='family_name' maxlength='"+family_name_length+"' size='"+familyNametextBoxSize+"' onKeyPress='return CheckForPipeChars(event)' onblur=makeValidString(this);ChangeInitCase(this);putPatientName(this,'"+CalledFromFunction+"');");
				}
				
				if(CalledFromFunction.equals("ChangePatDtls") && Family_Name_Accept_Yn.equals("Y") || !a_family_name.equals("") &&Family_Name_Accept_Yn.equals("Y"))
				{   
					
					if( (CalledFromFunction.equals("ChangePatDtls")) && !(((String)hash_Map1.get("family_name")).equals("")))
						out.print(" value=\""+(String)hash_Map1.get("family_name")+"\">");
					else if(!a_family_name.equals(""))
						out.print(" value=\""+a_family_name+"\" >");
					else out.print(" value = \"\" >");   
				}  
				else if(Family_Name_Accept_Yn.equals("Y"))
				{	//Monday, December 27, 2010 
					/*This else part is modified to populate the Family name even if Multipart is Unchecked
						Added by Rameswar on  05-05-2016 for ML-MMOH-SCF-0336 Start
					*/
					if(CalledFromFunction.equals("NewbornDtls")|| !a_family_name.equals(""))
					{
					if( (CalledFromFunction.equals("NewbornDtls")) && !(((String)hash_Map1.get("family_name")).equals("")))
						out.print(" value=\""+(String)hash_Map1.get("family_name")+"\">");
					else if(!a_family_name.equals(""))
						out.print(" value=\""+a_family_name+"\" >");
					else 
					out.print(" value = \"\" >"); 
						/*Added by Rameswar on  05-05-2016 for ML-MMOH-SCF-0336 End*/
						out.println("<input type = 'hidden' name = 'Family_Name_Prompt' value='"+Family_Name_Prompt+"'>");
					} //Monday, December 27, 2010
					else{/*Added by Rameswar on  19-10-2016 for ML-MMOH-SCF-0530 End*/
						out.print(" value = \"\" >"); 
						out.println("<input type = 'hidden' name = 'Family_Name_Prompt' value='"+Family_Name_Prompt+"'>");
					}
				%></td><%
				}
					
			 }
			if(Name_Suffix_Accept_Yn.equals("Y")) 
			{  	
			 
					%>
					<td  class='label'  ><Select name='name_suffix' id='name_suffix' onchange="sel_suffix_gen(this,'<%=CalledFromFunction%>');putPatientName(this,'<%=CalledFromFunction%>');" ><Option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
					<script>
							suffix_length = NameSuffixArray.length;
								for(i = 0; i < suffix_length; i++) {
									opt = document.createElement("OPTION");
									name_sfx = unescape(NameSuffixArray[i]);
									opt.text = name_sfx;
									opt.value = name_sfx; 
									
									if('<%=CalledFromFunction%>'=='NewbornDtls') {
										if(document.getElementById("name_suffix") && document.getElementById("name_suffix")[1])  
											document.getElementById("name_suffix")[1].options.add(opt); 		 				
									} else { 
										if(document.getElementById("name_suffix")) 
											document.getElementById("name_suffix").options.add(opt);					
									}


		                            //document.forms[0].name_suffix.add(opt);
									if('<%=CalledFromFunction%>' == 'ChangePatDtls' || '<%=a_name_suffix%>'!='') {
										if('<%=CalledFromFunction%>' == 'ChangePatDtls' && name_sfx == '<%=(String)hash_Map1.get("name_suffix")%>') {
											opt.selected=true;
										} else if(name_sfx == '<%=a_name_suffix%>') {							
											opt.selected=true;
										} 
									}	
								}
					</script>

					 <% 
						/* 
						 array_List.clear();
					array_List = eMP.ChangePatientDetails.getResultRows(conn,"mp_name_suffix",p);
					for(int i=0;i<array_List.size();i++) {
					 out.print("<Option value=\""+(String)array_List.get(i)+"\"");
					if(CalledFromFunction.equals("ChangePatDtls") || !a_name_suffix.equals(""))
					{  
						if((CalledFromFunction.equals("ChangePatDtls")) && ((String)array_List.get(i)).equals((String)hash_Map1.get("name_suffix")) )
							out.print(" selected >");
						else if(((String)array_List.get(i)).equals(a_name_suffix))
							out.print(" selected >");
						else out.print(" value=\"\" >");     
					} else out.print(" value=\"\" >");     
					out.print((String)array_List.get(i)+"</option>");
				} 
				*/
		//  }
		%> 
		</select></td> 
		<td class='label'>&nbsp;</td>
		<%
		}
		else
		{
			if(Name_Prefix_Accept_Yn.equals("Y")) 
			{
				emptyCnt++;
			}
		}
		 /*To fill the blank spaces in the table with blank TDs*/
		for(int j=1;j<=emptyCnt;++j)
			{%><td class='label' colspan='2'>&nbsp;</td><%}
		%>
		</tr>	
		<%
		if (CalledFromFunction.equals("ChangePatDtls") ) { %>
				<script>
				if ( document.forms[0].all.name_prefix_oth_lang)
				{
					if ( (document.getElementById("family_org_membership")) && (document.getElementById("family_org_membership").value=='1')  ) 
					{
						document.forms[0].all.name_prefix_oth_lang.disabled=true;
					}else{
						document.forms[0].all.name_prefix_oth_lang.disabled=false;
					}
				}
				</script>
		<% }
	//String names_in_oth_lang_yn	= checkForNull(request.getParameter("names_in_oth_lang_yn"));

	if(CalledFromFunction!=null && !CalledFromFunction.equals("FatherDtls") && !CalledFromFunction.equals("NewbornDtls")) {
		
		family_name_loc_lang_prompt = checkForNull((String) hash_Map.get("family_name_loc_lang_prompt")); 		
		name_suffix_loc_lang_prompt = checkForNull((String)hash_Map.get("name_suffix_loc_lang_prompt"));
		first_name_loc_lang_prompt	= checkForNull((String)hash_Map.get("first_name_loc_lang_prompt"));
		second_name_loc_lang_prompt = checkForNull((String)hash_Map.get("second_name_loc_lang_prompt"));
		third_name_loc_lang_prompt  = checkForNull((String)hash_Map.get("third_name_loc_lang_prompt"));
		name_prefix_loc_lang_prompt = checkForNull((String)hash_Map.get("name_prefix_loc_lang_prompt"));	
		names_in_oth_lang_yn		= checkForNull((String)hash_Map.get("names_in_oth_lang_yn"),"N");
	}
/*
	if(CalledFromFunction.equals("ChangePatDtls")) 
	{
		hash_Map1 = eMP.ChangePatientDetails.getPatientData(patient_id, conn,p);		
	}
	*/
   String temp		= "";
   emptyCnt	= 0;  /*To Count the Missing Name Fields as per MP Param*/
    
   if(names_in_oth_lang_yn.equals("Y")) 
   {
	   if(!language_direction.equals("R"))
	   {
	   %>
		<tr>
			<%
		 	if(Name_Prefix_Accept_Yn.equals("Y")) 
		{ 
			%>
			<td class='label'  ><%=name_prefix_loc_lang_prompt%>&nbsp;<img src='../../eCommon/images/mandatory.gif' id='name_prefix_oth' style='visibility:hidden;'></img>
			<% 				
			if( (Name_Prefix_Reqd_Yn.equals("Y")) && pat_name_in_loc_lang_reqd_yn.equals("Y"))
			{ 
				if(Name_Prefix_Reqd_Yn.equals("Y"))
				{
				%>
				 <script>
					if(document.getElementById("name_prefix_oth").length > 0)	{
						if(document.getElementById("name_prefix_oth")[1])					
							document.getElementById("name_prefix_oth")[1].style.visibility='visible';
					} else { 						
						if(document.getElementById("name_prefix_oth"))					
							document.getElementById("name_prefix_oth").style.visibility='visible';
					}
				 </script>
				 <input type='hidden' name='name_prefix_oth_name_reqd_yn' id='name_prefix_oth_name_reqd_yn' value='Y'></input>
				<%
				}
				else
				{
					// Added by Muthu on 23/01/2010 against incident IN018465 to correct the issue prefix should not be mandatory for newborn and father patient ids even though name_pfx_reqd_for_org_mem_yn is set to Y in MP Param
					if(!CalledFromFunction.equals("FatherDtls") && !CalledFromFunction.equals("NewbornDtls")) {
					%>
						<script>							
							if ((document.getElementById("name_prefix_oth")) && (document.forms[0].all.name_pfx_reqd_for_org_mem_yn.value=='Y')) { 		document.getElementById("name_prefix_oth").style.visibility='visible' 
							} else {
								document.getElementById("name_prefix_oth").style.visibility='hidden' 
							}							
						</script>
						<input type='hidden' name='name_prefix_oth_name_reqd_yn' id='name_prefix_oth_name_reqd_yn' value='Y'></input>
					<%
					} else {
						%>
						<input type='hidden' name='name_prefix_reqd_yn' id='name_prefix_reqd_yn' value='N'>
						<%
					}
					// End of Comment
				}			
			}
			else
			{ 
				%> 
				 <input type='hidden' name='name_prefix_oth_name_reqd_yn' id='name_prefix_oth_name_reqd_yn' value='N'></input>
				 <script>
					if (document.getElementById("name_prefix_oth").length > 0) {
						if (document.getElementById("name_prefix_oth")[1]) {	
							document.getElementById("name_prefix_oth")[1].style.visibility='hidden'
						}
					} else {
						if (document.getElementById("name_prefix_oth")) {  
							document.getElementById("name_prefix_oth").style.visibility='hidden'
						}
					}
				</script>
				<%
			}		
	   
			temp = ((name_prefix_loc_lang_prompt).equals("&nbsp;")) ? Name_Prefix_Prompt:name_prefix_loc_lang_prompt ;%>
			<input type='hidden' name='name_prefix_oth_prompt' id='name_prefix_oth_prompt' value="<%=temp%>">
			</td>
			<td class='label'>&nbsp;</td>
			<%
		}
		else
		{ 
			%><input type='hidden' name='name_prefix_oth_name_reqd_yn' id='name_prefix_oth_name_reqd_yn' value='N'></td> <% 
		}
		
/*If Multi Part Name is acceptable; Based on the name order in MP Param paint the prompts for names*/
		if (pat_name_as_multipart_yn.equals("Y") )
		{
			
			 String order = "";
			 /*Prompts and Names to be painted in Reverse Order for Local Lang*/
			 for(int i=1;i<=4;++i)
			 {
				 if (Name_Order.get((new Integer(i)).toString()) != null)
							 order = (String)Name_Order.get((new Integer(i)).toString());
						 else
							 order = ""; 
				 if (order.equals("First_Name_Order"))
				 {
					 if (First_Name_Accept_Yn.equals("Y")) 
					 { 
						%>
						<td  class='label'><%=first_name_loc_lang_prompt%>&nbsp;<%
						if ( (First_Name_Reqd_Yn.equals("Y") ) && pat_name_in_loc_lang_reqd_yn.equals("Y")) 
						{ 
							%>
							<input type='hidden' name='first_oth_name_reqd_yn' id='first_oth_name_reqd_yn' value='Y'></input><img	id='first_oth' src='../../eCommon/images/mandatory.gif'></img>
							<%
						}
						else
						{
							%>
							<input type='hidden' name='first_oth_name_reqd_yn' id='first_oth_name_reqd_yn' value='N'><img	id='first_oth' src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></input> 
							<%
						}
						temp = ((first_name_loc_lang_prompt).equals("&nbsp;"))? First_Name_Prompt:first_name_loc_lang_prompt; %>
						
						<input type='hidden' name='first_name_oth_prompt' id='first_name_oth_prompt' value="<%=temp%>">
						</td><td class='label' >&nbsp;</td>
						<%
					}
					else
					{
						emptyCnt++;
					}
				 }
				 else
				 if (order.equals("Second_Name_Order"))
				 {
					  if(Second_Name_Accept_Yn.equals("Y")) 
					  {
						%>
						<td   class='label'><%=second_name_loc_lang_prompt%>
						<%
						if ((Second_Name_Reqd_Yn.equals("Y")) && pat_name_in_loc_lang_reqd_yn.equals("Y")) 
						{
							%>
							<input type='hidden' name='second_oth_name_reqd_yn' id='second_oth_name_reqd_yn' value='Y'></input><img id="sec_oth" src='../../eCommon/images/mandatory.gif'></img>
							<%
						}
						else
						{ 
							%>
							<input type='hidden' name='second_oth_name_reqd_yn' id='second_oth_name_reqd_yn' value='N'><img	id='sec_oth' src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></input> 
							<%
						}
						temp = ((second_name_loc_lang_prompt).equals("&nbsp;")) ? Second_Name_Prompt:second_name_loc_lang_prompt; 
						%>
						<input type='hidden' name='second_name_oth_prompt' id='second_name_oth_prompt' value="<%=temp%>"> 
						</td><td class='label' >&nbsp;</td>
						<%
					}
					else
					{
						emptyCnt++;
					}
				 }
				 else
				 if (order.equals("Third_Name_Order"))
				 {
					  if(Third_Name_Accept_Yn.equals("Y")) 
					  { 
						%>
						<td   class='label'><%=third_name_loc_lang_prompt%>
						<% 
						if ((Third_Name_Reqd_Yn.equals("Y")) && pat_name_in_loc_lang_reqd_yn.equals("Y")) 
						{ 
							%>
							<input type='hidden' name='third_oth_name_reqd_yn' id='third_oth_name_reqd_yn' value='Y'></input><img id='third_oth' src='../../eCommon/images/mandatory.gif'></img>
							<%
						}
						else
						{
							%>
							<input type='hidden' name='third_oth_name_reqd_yn' id='third_oth_name_reqd_yn' value='N'><img	id='third_oth' src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></input> 
							<%
						}
						temp = ((third_name_loc_lang_prompt).equals("&nbsp;")) ? Third_Name_Prompt:third_name_loc_lang_prompt; %>
						<input type='hidden' name='third_name_oth_prompt' id='third_name_oth_prompt' value="<%=temp%>">
						</td><td class='label' >&nbsp;</td> 
						<%
					}
					else
					{
						emptyCnt++;
					}
				 }
				 else
				 if (order.equals("Family_Name_Order"))
				 {
					if(Family_Name_Accept_Yn.equals("Y") ) 
					{
						%>
						<td  class='label' ><%=family_name_loc_lang_prompt%>
						<%
						if ((Family_Name_Reqd_Yn.equals("Y")) && pat_name_in_loc_lang_reqd_yn.equals("Y")) 
						{ 
							%>
							<input type='hidden' name='family_oth_name_reqd_yn' id='family_oth_name_reqd_yn' value='Y'></input><img id='fam_oth' src='../../eCommon/images/mandatory.gif'  style='visibility:visible'></img>
							<%
						}
						else
						{
							%>
							<input type='hidden' name='family_oth_name_reqd_yn' id='family_oth_name_reqd_yn' value='N'><img	id='fam_oth' src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></input>
							<%
						}
						temp = family_name_loc_lang_prompt.equals("&nbsp;") ? Family_Name_Prompt : family_name_loc_lang_prompt; %>
						<input type='hidden' name='family_name_oth_prompt' id='family_name_oth_prompt' value="<%=temp%>">
						</td><td class='label' >&nbsp;</td>            
						<%
					}
					else
					{
						emptyCnt++;
					}
			 }
			 else
			 {
				emptyCnt++;
			 }
  		  }
		}/* END of  if (pat_name_as_multipart_yn.equals("Y") )   */
		else
		{
			
		   if(Family_Name_Accept_Yn.equals("Y") ) 
			{
				%><td   class='label' ><%=family_name_loc_lang_prompt%>
				<%
				if ( (Family_Name_Reqd_Yn.equals("Y")) && pat_name_in_loc_lang_reqd_yn.equals("Y"))
					{
					out.print("<input type='hidden' name='family_oth_name_reqd_yn' id='family_oth_name_reqd_yn' value='Y'></input><img id='fam_oth' src='../../eCommon/images/mandatory.gif' style='visibility:visible'></img>");
				} else { %> <input type='hidden' name='family_oth_name_reqd_yn' id='family_oth_name_reqd_yn' value='N'><img	id='fam_oth' src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></input> <% }
						temp = family_name_loc_lang_prompt.equals("&nbsp;")? Family_Name_Prompt:family_name_loc_lang_prompt ; %>
						<input type='hidden' name='family_name_oth_prompt' id='family_name_oth_prompt' value="<%=temp%>"></td>
					<%
			}
		}


			if(Name_Suffix_Accept_Yn.equals("Y")) 
			{ 
				%>
				<td   class='label'><%=name_suffix_loc_lang_prompt%><img src='../../eCommon/images/mandatory.gif' id='name_suffix_oth' style='visibility:hidden'></img>
				
				<% 
					if ((Name_Suffix_Reqd_Yn.equals("Y")) && pat_name_in_loc_lang_reqd_yn.equals("Y"))
					{
						%>
						<input type='hidden' name='name_suffix_oth_name_reqd_yn' id='name_suffix_oth_name_reqd_yn' value='Y'></input>
						<script>
							if(document.forms[0].name_suffix_oth.length>0) {
								document.forms[0].name_suffix_oth[1].style.visibility='visible'
							} else {
								document.forms[0].name_suffix_oth.style.visibility='visible'
							}
						</script>
						<% 
					}
					else
					{ 
						%> 
						<input type='hidden' name='name_suffix_oth_name_reqd_yn' id='name_suffix_oth_name_reqd_yn' value='N'></input>
						<script>
							if(document.forms[0].name_suffix_oth.length>0) {
								if(document.forms[0].name_suffix_oth[1])
									document.forms[0].name_suffix_oth[1].style.visibility='hidden'
							} else {
								if(document.forms[0].name_suffix_oth)
									document.forms[0].name_suffix_oth.style.visibility='hidden'
							}
						</script>
						<%
					}
					temp = (name_suffix_loc_lang_prompt.equals("&nbsp;")) ? Name_Suffix_Prompt : name_suffix_loc_lang_prompt; 
				%>
				<input type='hidden' name='name_suffix_oth_prompt' id='name_suffix_oth_prompt' value="<%=temp%>">          
				</td>
				<td class='label'>&nbsp;</td>
				<%
			}
			else
			{ 
				%><input type='hidden' name='name_suffix_oth_name_reqd_yn' id='name_suffix_oth_name_reqd_yn' value='N'></td> <% 
			}

	
		 /*To fill the blank spaces in the table with blank TDs*/
		 for(int j=1;j<=emptyCnt;++j)
			   {%><td class='v' colspan='2'>&nbsp;</td><%}
		%>
		</tr>
		<tr>
		<%
	
			if(Name_Prefix_Accept_Yn.equals("Y")) 
			{
				if(pat_name_as_multipart_yn.equals("N")) 
				{ 
					%>
					<td class='fields'   ><Select name='name_prefix_oth_lang' id='name_prefix_oth_lang' onchange='sel_prefix_gen(this,"<%=CalledFromFunction%>");putLocalLangPatientName(this,"<%=CalledFromFunction%>");if (document.forms[0].entitlement_by_pat_cat_yn && document.forms[0].entitlement_by_pat_cat_yn.value=="Y"){getPatCategory();}' >
					<%
				}
				else
				{ 
					%>
					<td class='fields'  ><Select name='name_prefix_oth_lang' id='name_prefix_oth_lang' onchange='sel_prefix_gen(this,"<%=CalledFromFunction%>");putLocalLangPatientName(this,"<%=CalledFromFunction%>");if ( document.forms[0].entitlement_by_pat_cat_yn && document.forms[0].entitlement_by_pat_cat_yn.value=="Y"){getPatCategory();}' > 
					<%
				} 
				//if(Name_Prefix_Reqd_Yn.equals("N")) 
				//{ 
					%>
					<Option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>

					<script>
						prefix_loc_length = NamePrefixLocArrayTemp.length;//added By Sudhakar during UAT-3
							for(i = 0; i < prefix_loc_length; i++) {
								loc_name_pfx = unescape(NamePrefixLocArrayTemp[i]);//added By Sudhakar during UAT-3
								if(loc_name_pfx!='') {

									opt = document.createElement("OPTION");									
									opt.text = loc_name_pfx;
									opt.value = loc_name_pfx; 
									if('<%=isNewBornChngsAppl%>'=='true' && "<%=calling_module_id%>" == "IP"){
									if('<%=CalledFromFunction%>'=='NewbornDtls') {
											if(document.getElementById("name_prefix_oth_lang")) 
												document.getElementById("name_prefix_oth_lang").options.add(opt);
										}else { 
										if(document.getElementById("name_prefix_oth_lang") && document.getElementById("name_prefix_oth_lang")[1]) { 
											document.getElementById("name_prefix_oth_lang")[1].options.add(opt);
										} 				
										} 
									} else { 
										if('<%=CalledFromFunction%>'=='NewbornDtls') {
											if(document.getElementById("name_prefix_oth_lang") && document.getElementById("name_prefix_oth_lang")[1]) { 
												document.getElementById("name_prefix_oth_lang")[1].options.add(opt);
											} 				
										} else { 
										if(document.getElementById("name_prefix_oth_lang")) 
											document.getElementById("name_prefix_oth_lang").options.add(opt);	
										} 
									} 

									//document.forms[0].name_prefix_oth_lang.add(opt);

									if('<%=CalledFromFunction%>' == 'ChangePatDtls' || "<%=a_name_prefix_loc_lang%>"!='') {
										if('<%=CalledFromFunction%>' == 'ChangePatDtls' && loc_name_pfx == "<%=(String)hash_Map1.get("name_prefix_loc_lang")%>") {
											opt.selected=true;
										} else if(loc_name_pfx == "<%=a_name_prefix_loc_lang%>") {				
											opt.selected=true;
										} 
									}
								}
							}
					</script> 



					<% /*
						
				//} 									
				array_List.clear(); 
				array_List = eMP.ChangePatientDetails.getResultRows(conn,"mp_name_prefix1",p);
				for(int i=0;i<array_List.size();i+=2) 
				{ 
					if(!((String)array_List.get(i)).equals("")) 
					{
						out.print("<option  value=\""+(String)array_List.get(i)+"\"");
						if(CalledFromFunction.equals("ChangePatDtls")  || !a_name_prefix_loc_lang.equals("") ) {
						if ( ((String)array_List.get(i)).equals((String)hash_Map1.get("name_prefix_loc_lang")) ||
							((String)array_List.get(i)).equals(a_name_prefix_loc_lang) )
								out.print(" selected >" );
							else out.print(" > " );
						}
						else out.print(" > " );
						out.print((String)array_List.get(i)+"</option>");
						}
					} */ %>
					</Select></td>	<td class='label'>&nbsp;</td>
			<%}
   		    
		 if (pat_name_as_multipart_yn.equals("Y") )
		 {
			 String order = "";
			 //int tabIndex = 20;
			 emptyCnt = 0;
			 for(int i=1;i<=4;++i)
			 {
				 //tabIndex++; // To increase the tab order
				 //order = (String)Name_Order.get((new Integer(i)).toString());
				 if (Name_Order.get((new Integer(i)).toString()) != null)
							 order = (String)Name_Order.get((new Integer(i)).toString());
						 else
							 order = ""; 
				 if (order.equals("First_Name_Order"))
				 {
					if(First_Name_Accept_Yn.equals("Y")) 
					{ 
						out.println("<td     class='fields'><input type='text' name='first_name_oth_lang' id='first_name_oth_lang' maxlength='"+first_name_length+"' size='20' onKeyPress='return CheckForPipeChars(event)' onblur=makeValidString(this);putLocalLangPatientName(this,'"+CalledFromFunction+"');populateLocalValues(this,first_name_oth_lang,first_name,'O','"+CalledFromFunction+"') ");

						
						if ( CalledFromFunction.equals("ChangePatDtls")  || !a_first_name_loc_lang.equals("") || CalledFromFunction.equals("NewbornDtls"))
						{
							if (!a_first_name_loc_lang.equals(""))
								out.print(" value=\""+a_first_name_loc_lang+"\">");
							else
							if(!(((String)(hash_Map1.get("first_name_loc_lang")==null?"":hash_Map1.get("first_name_loc_lang"))).equals("")))
								out.print(" value=\""+(String)hash_Map1.get("first_name_loc_lang") +"\">");
							else 
							 out.print(" value = \"\" >");
								
						} else out.print(" value = \"\" >");  
						%><input type='button' class='button' value='?' style='visibility:hidden' onclick="document.forms[0].first_name_oth_lang.focus();callSearch('first_name_oth_lang','first_name','Others','<%=CalledFromFunction%>')" name='bfo'>
						</td><td class='label' >&nbsp;</td>
						<%
					}
					else
					{
						emptyCnt++;
					}
				 }
				 else
				 if (order.equals("Second_Name_Order"))
				 {
					if(Second_Name_Accept_Yn.equals("Y")) 
					{ 
						out.println("	<td     class='fields'><input type='text' name='second_name_oth_lang' id='second_name_oth_lang' maxlength='"+second_name_length+"' size='20' onKeyPress='return CheckForPipeChars(event)'  onblur=makeValidString(this);putLocalLangPatientName(this,'"+CalledFromFunction+"');populateLocalValues(this,second_name_oth_lang,second_name,'O','"+CalledFromFunction+"');  ");

						
						if( CalledFromFunction.equals("ChangePatDtls") || !a_second_name_loc_lang.equals("") || CalledFromFunction.equals("NewbornDtls"))
						{
							if (!a_second_name_loc_lang.equals(""))
								out.print(" value = \""+a_second_name_loc_lang+"\" >");   
							else
							if (!(((String)(hash_Map1.get("second_name_loc_lang")==null?"":hash_Map1.get("second_name_loc_lang"))).equals("")))
								out.print(" value=\""+(String)hash_Map1.get("second_name_loc_lang") +"\">");
							else 
								out.print(" value = \"\" >");    
						}
						else out.print(" value = \"\" >");
						%><input type='button' class='button' style='visibility:hidden' value='?'onclick="callSearch(second_name_oth_lang,second_name,'Others','<%=CalledFromFunction%>')" name='bso'> 
						</td><td class='label' >&nbsp;</td>
						<%
					}
					else
					{
						emptyCnt++;
					}
				 }
				 else
				 if (order.equals("Third_Name_Order"))
				 {
					if(Third_Name_Accept_Yn.equals("Y")) 
					{ 
						out.println("<td     class='fields'><input type='text' name='third_name_oth_lang' id='third_name_oth_lang' maxlength='"+third_name_length+"' size='20' onKeyPress='return CheckForPipeChars(event)' onblur=makeValidString(this);putLocalLangPatientName(this,'"+CalledFromFunction+"');populateLocalValues(this,third_name_oth_lang,third_name,'O','"+CalledFromFunction+"') ;");

						if ( CalledFromFunction.equals("ChangePatDtls") || !a_third_name_loc_lang.equals("") || CalledFromFunction.equals("NewbornDtls"))
						{
							if (!a_third_name_loc_lang.equals(""))
								out.print(" value = \""+a_third_name_loc_lang+"\" >");  
							else
							if(!(((String)(hash_Map1.get("third_name_loc_lang")==null?"":hash_Map1.get("third_name_loc_lang"))).equals("")))
								out.print(" value=\""+(String)hash_Map1.get("third_name_loc_lang")+"\">");
							else 
								out.print(" value = \"\" >");   
						} 
						else out.print(" value = \"\" >");
						%><input type='button' class='button' value='?' style='visibility:hidden' onclick="callSearch(third_name_oth_lang,third_name,'Others','<%=CalledFromFunction%>')" name='bto'>
						</td><td class='label' >&nbsp;</td>
						<%
					}
					else
					{
						emptyCnt++;
					}
				 }
				 else
				 if (order.equals("Family_Name_Order"))
				 {
					if(Family_Name_Accept_Yn.equals("Y")) 
					{
						out.println("<td  class='fields' ><input type='text' name='family_name_oth_lang' id='family_name_oth_lang' maxlength='"+family_name_length+"' size='"+familyNametextBoxSize+"' onKeyPress='return CheckForPipeChars(event)' onblur=makeValidString(this);putLocalLangPatientName(this,'"+CalledFromFunction+"');populateLocalValues(this,family_name_oth_lang,family_name,'O','"+CalledFromFunction+"') ; ");

						
						if(CalledFromFunction.equals("ChangePatDtls") || !a_family_name_loc_lang.equals("") || CalledFromFunction.equals("NewbornDtls"))
						{
							if (!a_family_name_loc_lang.equals(""))
								out.print(" value = \""+a_family_name_loc_lang+"\" >");  
							else
							if(!(((String)(hash_Map1.get("family_name_loc_lang")==null?"":hash_Map1.get("family_name_loc_lang"))).equals("")))
								out.print(" value=\""+(String)hash_Map1.get("family_name_loc_lang")+"\">");
							else
								out.print(" value = \"\" >");    
						}
						else out.print(" value = \"\" >"); 
					%><input type='button' class='button' value='?' style='visibility:hidden' onclick="callSearch(family_name_oth_lang,family_name,'Others','<%=CalledFromFunction%>')" name='bfamo'>
						</td><td class='label' >&nbsp;</td>
						<%
				  }
				  else
				  {
				 	emptyCnt++;
				  }
			  }
			  else
			  {
				 emptyCnt++;
			  }
			}
		 }
		 /* if (pat_name_as_multipart_yn.equals("Y") ) */
			else
			{
			   if(Family_Name_Accept_Yn.equals("Y") ) 
			   {
				out.print("<td  class='fields' ><input type='text' name='family_name_oth_lang' id='family_name_oth_lang' maxlength='"+family_name_length+"' size='"+familyNametextBoxSize+"' onKeyPress='return CheckForPipeChars(event)' onblur=makeValidString(this);putLocalLangPatientName(this,'"+CalledFromFunction+"'); ");

					

				if ( CalledFromFunction.equals("ChangePatDtls") || !a_name_suffix_loc_lang.equals("")  )
				{
					if(!(((String)hash_Map1.get("family_name_loc_lang")).equals("")))
						out.print(" value=\""+(String)hash_Map1.get("family_name_loc_lang")+"\">");
					else out.print(" value = \"\" >");    
				} 
				else out.print(" value = \""+a_name_suffix_loc_lang+"\" >");    
				%>
				</td>
				<%
			} 
		}

			if(Name_Suffix_Accept_Yn.equals("Y")) 
			{	 
				 if(pat_name_as_multipart_yn.equals("N")) 
				{ 
					%>
					<td   class='label'><Select name='name_suffix_oth_lang' id='name_suffix_oth_lang' onchange='sel_suffix_gen(this,"<%=CalledFromFunction%>");putLocalLangPatientName(this,"<%=CalledFromFunction%>");'>
					<%
				}
				else
				{ 
				  %>
				<td   class='label'><Select name='name_suffix_oth_lang' id='name_suffix_oth_lang' onchange='sel_suffix_gen(this,"<%=CalledFromFunction%>");putLocalLangPatientName(this,"<%=CalledFromFunction%>");'>
				<%}
				if(Name_Suffix_Reqd_Yn.equals("N")) 
				{
					out.print("<Option value=''>------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label" ,"common_labels")+"------</option>");
				} 
				%>

				<script>
					suffix_length = NameSuffixLocArrayTemp.length;//added By Sudhakar during UAT-3
					for(i = 0; i < suffix_length; i++) {
						opt = document.createElement("OPTION");
						loc_name_sfx = unescape(NameSuffixLocArrayTemp[i]);//added By Sudhakar during UAT-3
						opt.text = loc_name_sfx;
						opt.value = loc_name_sfx; 

									if('<%=CalledFromFunction%>'=='NewbornDtls') {
										if(document.getElementById("name_suffix_oth_lang") && document.getElementById("name_suffix_oth_lang")[1]) { 
											document.getElementById("name_suffix_oth_lang")[1].options.add(opt);
										} 				
									} else { 
										if(document.getElementById("name_suffix_oth_lang"))
											document.getElementById("name_suffix_oth_lang").options.add(opt);					
									}								
						

		                //document.forms[0].name_suffix_oth_lang.add(opt);
						if('<%=CalledFromFunction%>' == 'ChangePatDtls' || '<%=a_name_suffix_loc_lang%>'!='') {
							if('<%=CalledFromFunction%>' == 'ChangePatDtls' && loc_name_sfx == '<%=(String)hash_Map1.get("name_suffix_loc_lang")%>') {
								opt.selected=true;
							} else if(loc_name_sfx == '<%=a_name_suffix_loc_lang%>') {							
								opt.selected=true;
							} 
						}	
					}
				</script>
				
				<%

				/*
				array_List.clear();
				array_List = eMP.ChangePatientDetails.getResultRows(conn,"mp_name_suffix1",p);
				
				for(int i=0;i<array_List.size();i+=2) 
				{
					if(!((String)array_List.get(i)).equals("")) 
					{
						out.print("<Option value=\"" + (String)array_List.get(i) + "\" ");
						if ( CalledFromFunction.equals("ChangePatDtls")  || !a_name_suffix_loc_lang.equals("") )
						{
							if ( ((String)array_List.get(i)).equals((String)hash_Map1.get("name_suffix_loc_lang")) ||
							((String)array_List.get(i)).equals(a_name_suffix_loc_lang) )
								out.print(" selected > ");
							else out.print(" > "); 
						}
						else out.print(" > "); 
						out.print((String)array_List.get(i)+"</option>");
					} 
				}
				*/
			
			%>
			</td>
			<td class='label'>&nbsp;</td>
			<%
			}
			else
			{	
			}
		 /*To fill the blank spaces in the table with blank TDs*/
			 for(int j=1;j<=emptyCnt;++j)
			   {%><td class='label' colspan='2'>&nbsp;</td><%}
			%></tr>
		<%	
			if(CalledFromFunction.equals("PatientRegistration")) { %>
				<script>if (parent.frames[0].document.getElementById("patient_name_loc_lang")) parent.frames[0].document.getElementById("patient_name_loc_lang").style.visibility = 'visible';</script><% }
   }
   else if(language_direction.equals("R"))
		{

	   /*******Added for Arabic*********/

	   	   %>
		<tr>
			<%

		
			   
			if(Name_Suffix_Accept_Yn.equals("Y")) 
			{ 
				%>
				<td   class='arabic'><img src='../../eCommon/images/mandatory.gif' id='name_suffix_oth' style='visibility:hidden'></img><%=name_suffix_loc_lang_prompt%>
				
				<% 
					if ((Name_Suffix_Reqd_Yn.equals("Y")) && pat_name_in_loc_lang_reqd_yn.equals("Y"))
					{
						%>
						<input type='hidden' name='name_suffix_oth_name_reqd_yn' id='name_suffix_oth_name_reqd_yn' value='Y'></input>
						<script>
							if(document.forms[0].name_suffix_oth.length>0) {
								if(document.forms[0].name_suffix_oth[1])
									document.forms[0].name_suffix_oth[1].style.visibility='visible'
							} else {
								if(document.forms[0].name_suffix_oth)
									document.forms[0].name_suffix_oth.style.visibility='visible'
							}
						</script>
						<% 
					}
					else
					{ 
						%> 
						<input type='hidden' name='name_suffix_oth_name_reqd_yn' id='name_suffix_oth_name_reqd_yn' value='N'></input>
						<script>
							if(document.forms[0].name_suffix_oth.length>0) {
								if(document.forms[0].name_suffix_oth[1])
									document.forms[0].name_suffix_oth[1].style.visibility='hidden'
							} else {
								if(document.forms[0].name_suffix_oth)
									document.forms[0].name_suffix_oth.style.visibility='hidden'
							}
						</script>
						<%
					}
					temp = (name_suffix_loc_lang_prompt.equals("&nbsp;")) ? Name_Suffix_Prompt : name_suffix_loc_lang_prompt; 
				%>
				<input type='hidden' name='name_suffix_oth_prompt' id='name_suffix_oth_prompt' value="<%=temp%>">          
				</td>
				<td class='label'>&nbsp;</td>
				<%
			}
			else
			{ 
				%><input type='hidden' name='name_suffix_oth_name_reqd_yn' id='name_suffix_oth_name_reqd_yn' value='N'></td> <% 
			}


			/*If Multi Part Name is acceptable; Based on the name order in MP Param paint the prompts for names*/
		if (pat_name_as_multipart_yn.equals("Y") )
		{
			 String order = "";
			 /*Prompts and Names to be painted in Reverse Order for Local Lang*/
			// for(int i=1;i<=4;i++)
			 for(int i=4;i>0;--i)
			 {
				 if (Name_Order.get((new Integer(i)).toString()) != null)
							 order = (String)Name_Order.get((new Integer(i)).toString());
						 else
							 order = ""; 
				 
				 if (order.equals("Family_Name_Order"))
				 {
					if(Family_Name_Accept_Yn.equals("Y") ) 
					{
						%>
						<td  class='arabic' >
						<%
						if ((Family_Name_Reqd_Yn.equals("Y")) && pat_name_in_loc_lang_reqd_yn.equals("Y")) 
						{ 
							%>
							<input type='hidden' name='family_oth_name_reqd_yn' id='family_oth_name_reqd_yn' value='Y'></input><img id='fam_oth' src='../../eCommon/images/mandatory.gif'  style='visibility:visible'></img>
							<%
						}
						else
						{
							%>
							<input type='hidden' name='family_oth_name_reqd_yn' id='family_oth_name_reqd_yn' value='N'><img	id='fam_oth' src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></input>
							<%
						}
						%>
						<%=family_name_loc_lang_prompt%>
						<%

						temp = family_name_loc_lang_prompt.equals("&nbsp;") ? Family_Name_Prompt : family_name_loc_lang_prompt; %>
						<input type='hidden' name='family_name_oth_prompt' id='family_name_oth_prompt' value="<%=temp%>">
						</td><td class='label' >&nbsp;</td>            
						<%
					}
					else
					{
						emptyCnt++;
					}
				 }
				 else if (order.equals("Third_Name_Order"))
				 {
					  if(Third_Name_Accept_Yn.equals("Y")) 
					  { 
						%>
						<td   class='arabic'>
						<% 
						if ((Third_Name_Reqd_Yn.equals("Y")) && pat_name_in_loc_lang_reqd_yn.equals("Y")) 
						{ 
							%>
							<input type='hidden' name='third_oth_name_reqd_yn' id='third_oth_name_reqd_yn' value='Y'></input><img id='third_oth' src='../../eCommon/images/mandatory.gif'></img>
							<%
						}
						else
						{
							%>
							<input type='hidden' name='third_oth_name_reqd_yn' id='third_oth_name_reqd_yn' value='N'><img	id='third_oth' src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></input> 
							<%
						}

						%>
						<%=third_name_loc_lang_prompt%>
						<%

						temp = ((third_name_loc_lang_prompt).equals("&nbsp;")) ? Third_Name_Prompt:third_name_loc_lang_prompt; %>
						<input type='hidden' name='third_name_oth_prompt' id='third_name_oth_prompt' value="<%=temp%>">
						</td><td class='arabic' >&nbsp;</td> 
						<%
					}
					else
					{
						emptyCnt++;
					}
				 }
				 else if (order.equals("Second_Name_Order"))
				 {
					  if(Second_Name_Accept_Yn.equals("Y")) 
					  {
						%>
						<td   class='arabic'>
						<%
						if ((Second_Name_Reqd_Yn.equals("Y")) && pat_name_in_loc_lang_reqd_yn.equals("Y")) 
						{
							%>
							<input type='hidden' name='second_oth_name_reqd_yn' id='second_oth_name_reqd_yn' value='Y'></input><img id="sec_oth" src='../../eCommon/images/mandatory.gif'></img>
							<%
						}
						else
						{ 
							%>
							<input type='hidden' name='second_oth_name_reqd_yn' id='second_oth_name_reqd_yn' value='N'><img	id='sec_oth' src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></input> 
							<%
						}

						%>
						<%=second_name_loc_lang_prompt%>
						<%

						temp = ((second_name_loc_lang_prompt).equals("&nbsp;")) ? Second_Name_Prompt:second_name_loc_lang_prompt; 
						%>
						<input type='hidden' name='second_name_oth_prompt' id='second_name_oth_prompt' value="<%=temp%>"> 
						</td><td class='arabic' >&nbsp;</td>
						<%
					}
					else
					{
						emptyCnt++;
					}
				 }
				 else  if (order.equals("First_Name_Order"))
				 {
					 if (First_Name_Accept_Yn.equals("Y")) 
					 { 
						%>
						<td  class='arabic'>&nbsp;<%
						if ( (First_Name_Reqd_Yn.equals("Y") ) && pat_name_in_loc_lang_reqd_yn.equals("Y")) 
						{ 
							%>
							<input type='hidden' name='first_oth_name_reqd_yn' id='first_oth_name_reqd_yn' value='Y'></input><img	id='first_oth' src='../../eCommon/images/mandatory.gif'></img>
							<%
						}
						else
						{
							%>
							<input type='hidden' name='first_oth_name_reqd_yn' id='first_oth_name_reqd_yn' value='N'><img	id='first_oth' src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></input> 
							<%
						}

						%>
						<%=first_name_loc_lang_prompt%>
						<%
						temp = ((first_name_loc_lang_prompt).equals("&nbsp;"))? First_Name_Prompt:first_name_loc_lang_prompt; %>
						
						<input type='hidden' name='first_name_oth_prompt' id='first_name_oth_prompt' value="<%=temp%>">
						</td><td class='arabic' >&nbsp;</td>
						<%
					}
					else
					{
						emptyCnt++;
					}
				 }
				 else
			 {
				emptyCnt++;
			 }
  		  }
		}/* END of  if (pat_name_as_multipart_yn.equals("Y") )   */
		else
		{
		   if(Family_Name_Accept_Yn.equals("Y") ) 
			{
				%><td   class='arabic' >
				<%
				if ( (Family_Name_Reqd_Yn.equals("Y")) && pat_name_in_loc_lang_reqd_yn.equals("Y"))
					{
					out.print("<input type='hidden' name='family_oth_name_reqd_yn' id='family_oth_name_reqd_yn' value='Y'></input><img id='fam_oth' src='../../eCommon/images/mandatory.gif' style='visibility:visible'></img>");
				} else { %> <input type='hidden' name='family_oth_name_reqd_yn' id='family_oth_name_reqd_yn' value='N'><img	id='fam_oth' src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></input> <% }
			
				%>
				<%=family_name_loc_lang_prompt%>
				<%
						temp = family_name_loc_lang_prompt.equals("&nbsp;")? Family_Name_Prompt:family_name_loc_lang_prompt ; %>
						<input type='hidden' name='family_name_oth_prompt' id='family_name_oth_prompt' value="<%=temp%>"></td>
					<%
			}
		}

		 	if(Name_Prefix_Accept_Yn.equals("Y")) 
		{ 
			%>
			<td class='arabic'  ><img src='../../eCommon/images/mandatory.gif' id='name_prefix_oth' style='visibility:hidden;'></img>&nbsp;<%=name_prefix_loc_lang_prompt%>			  			
			<% 
			if( (Name_Prefix_Reqd_Yn.equals("Y")) && pat_name_in_loc_lang_reqd_yn.equals("Y"))
			{ 
				if(Name_Prefix_Reqd_Yn.equals("Y"))
				{
				%>
				 <script>	
					if(document.getElementById("name_prefix_oth").length > 0)	{						
						if(document.getElementById("name_prefix_oth")[1])					
							document.getElementById("name_prefix_oth")[1].style.visibility='visible';
					} else {						
						if(document.getElementById("name_prefix_oth"))					
							document.getElementById("name_prefix_oth").style.visibility='visible';
					}
				 </script>
				 <input type='hidden' name='name_prefix_oth_name_reqd_yn' id='name_prefix_oth_name_reqd_yn' value='Y'></input>
				<%
				}
				else
				{
					// Added by Muthu on 23/01/2010 against incident IN018465 to correct the issue prefix should not be mandatory for newborn and father patient ids even though name_pfx_reqd_for_org_mem_yn is set to Y in MP Param 
					if(!CalledFromFunction.equals("FatherDtls") && !CalledFromFunction.equals("NewbornDtls")) {
				%>
					<script>						
						if ((document.getElementById("name_prefix_oth")) && (document.forms[0].all.name_pfx_reqd_for_org_mem_yn.value=='Y')) { 			document.getElementById("name_prefix_oth").style.visibility='visible' 
						} else {
							document.getElementById("name_prefix_oth").style.visibility='hidden' 
						}	
					</script>
					<input type='hidden' name='name_prefix_oth_name_reqd_yn' id='name_prefix_oth_name_reqd_yn' value='Y'></input>
				<%
					} else {
						%>
						<input type='hidden' name='name_prefix_reqd_yn' id='name_prefix_reqd_yn' value='N'>
						<%
					}
					// End of Comment
				}				
			}
			else
			{ 
				%> 
				 <input type='hidden' name='name_prefix_oth_name_reqd_yn' id='name_prefix_oth_name_reqd_yn' value='N'></input>
				 <script>
					if (document.getElementById("name_prefix_oth").length>0) { 
						if (document.getElementById("name_prefix_oth")[1]) 
						{
							document.getElementById("name_prefix_oth")[1].style.visibility='hidden'
						}
					} else {
						if (document.getElementById("name_prefix_oth")) 
						{
							document.getElementById("name_prefix_oth").style.visibility='hidden'
						}
					}
				</script>
				<%
			}
			temp = ((name_prefix_loc_lang_prompt).equals("&nbsp;")) ? Name_Prefix_Prompt:name_prefix_loc_lang_prompt ;%>
			<input type='hidden' name='name_prefix_oth_prompt' id='name_prefix_oth_prompt' value="<%=temp%>">
			</td>
			<td class='arabic'>&nbsp;</td>
			<%
		}
		else
		{ 
			%><input type='hidden' name='name_prefix_oth_name_reqd_yn' id='name_prefix_oth_name_reqd_yn' value='N'></td> <% 
		}




	
		 /*To fill the blank spaces in the table with blank TDs*/
		 for(int j=1;j<=emptyCnt;++j)
		// for(int j=emptyCnt;j>0;--j)
			   {%><td class='v' colspan='2'>&nbsp;</td><%}
		%>
		</tr>
		<tr>
		<%

			if(Name_Suffix_Accept_Yn.equals("Y")) 
			{	 
				 if(pat_name_as_multipart_yn.equals("N")) 
				{ 
					%>
					<td   class='arabic'><Select name='name_suffix_oth_lang' id='name_suffix_oth_lang' onchange='sel_suffix_gen(this,"<%=CalledFromFunction%>");putLocalLangPatientName(this),"<%=CalledFromFunction%>";' dir='RTL'>
					<%
				}
				else
				{ 
				  %>
				<td   class='arabic'><Select name='name_suffix_oth_lang' id='name_suffix_oth_lang' onchange='sel_suffix_gen(this,"<%=CalledFromFunction%>");putLocalLangPatientName(this,"<%=CalledFromFunction%>");' dir='RTL'>
				<%}
				if(Name_Suffix_Reqd_Yn.equals("N")) 
				{
					out.print("<Option value=''>------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label" ,"common_labels")+"------</option>");
				}
				%>

				<script>
					suffix_length = NameSuffixLocArrayTemp.length;//added By Sudhakar during UAT-3
					for(i = 0; i < suffix_length; i++) {
						opt = document.createElement("OPTION");
						loc_name_sfx = unescape(NameSuffixLocArrayTemp[i]);//added By Sudhakar during UAT-3
						opt.text = loc_name_sfx;
						opt.value = loc_name_sfx; 
									if('<%=CalledFromFunction%>'=='NewbornDtls') {
										if(document.getElementById("name_suffix_oth_lang") && document.getElementById("name_suffix_oth_lang")[1]) { 
											document.getElementById("name_suffix_oth_lang")[1].options.add(opt);
										} 				
									} else { 
										if(document.getElementById("name_suffix_oth_lang")) 
											document.getElementById("name_suffix_oth_lang").options.add(opt);				
									}
		                //document.forms[0].name_suffix_oth_lang.add(opt);
						if('<%=CalledFromFunction%>' == 'ChangePatDtls' || '<%=a_name_suffix_loc_lang%>'!='') {
							if('<%=CalledFromFunction%>' == 'ChangePatDtls' && loc_name_sfx == '<%=(String)hash_Map1.get("name_suffix_loc_lang")%>') {
								opt.selected=true;
							} else if(loc_name_sfx == '<%=a_name_suffix_loc_lang%>') {							
								opt.selected=true;
							} 
						}	
					}
				</script>
				
				<%
				/*	
				array_List.clear();
				array_List = eMP.ChangePatientDetails.getResultRows(conn,"mp_name_suffix1",p);
				
				for(int i=0;i<array_List.size();i+=2) 
				{
					if(!((String)array_List.get(i)).equals("")) 
					{
						out.print("<Option value=\"" + (String)array_List.get(i) + "\" ");
						if ( CalledFromFunction.equals("ChangePatDtls")  || !a_name_suffix_loc_lang.equals("") )
						{
							if ( ((String)array_List.get(i)).equals((String)hash_Map1.get("name_suffix_loc_lang")) ||
							((String)array_List.get(i)).equals(a_name_suffix_loc_lang) )
								out.print(" selected > ");
							else out.print(" > "); 
						}
						else out.print(" > "); 
						out.print((String)array_List.get(i)+"</option>");
					} 
				}
				*/			
			%>
			</td>
			<td class='arabic'>&nbsp;</td>
			<%
			}
			else
			{	
			}

		if (pat_name_as_multipart_yn.equals("Y") )
		 {
			 String order = "";
			 //int tabIndex = 20;
			 emptyCnt = 0;
			 //for(int i=1;i<=4;++i)
			for(int i=4;i>0;--i)
			 {
				 //tabIndex++; // To increase the tab order
				 //order = (String)Name_Order.get((new Integer(i)).toString());
				 if (Name_Order.get((new Integer(i)).toString()) != null)
							 order = (String)Name_Order.get((new Integer(i)).toString());
						 else
							 order = ""; 

				 if (order.equals("Family_Name_Order"))
				 {
					if(Family_Name_Accept_Yn.equals("Y")) 
					{
						out.println("<td  class='arabic' ><input type='text' name='family_name_oth_lang' id='family_name_oth_lang' maxlength='"+family_name_length+"' size='"+familyNametextBoxSize+"' onKeyPress='return CheckForPipeChars(event)' onblur=makeValidString(this);putLocalLangPatientName(this,'"+CalledFromFunction+"');populateLocalValues(this,family_name_oth_lang,family_name,'O','"+CalledFromFunction+"') ; ");

						if(language_direction.equals("R"))
							{
							out.println( "dir='RTL' ");
							}

						if(CalledFromFunction.equals("ChangePatDtls") || !a_family_name_loc_lang.equals("") || CalledFromFunction.equals("NewbornDtls") )
						{
							if (!a_family_name_loc_lang.equals(""))
								out.print(" value = \""+a_family_name_loc_lang+"\" >");  
							else
							if(!(((String)(hash_Map1.get("family_name_loc_lang")==null?"":hash_Map1.get("family_name_loc_lang"))).equals("")))
								out.print(" value=\""+(String)hash_Map1.get("family_name_loc_lang")+"\">");
							else
								out.print(" value = \"\" >");    
						}
						else out.print(" value = \"\" >"); 
					%><input type='button' class='button' value='?' style='<%=name_comp_visibility%>' onclick="callSearch(family_name_oth_lang,family_name,'Others','<%=CalledFromFunction%>')" name='bfamo'>
						</td><td class='label' >&nbsp;</td>
						<%
				  }
				  else
				  {
				 	emptyCnt++;
				  }
			  }
			  else 	if (order.equals("Third_Name_Order"))
				 {
					if(Third_Name_Accept_Yn.equals("Y")) 
					{ 
						out.println("<td     class='arabic'><input type='text' name='third_name_oth_lang' id='third_name_oth_lang' maxlength='"+third_name_length+"' size='20' onKeyPress='return CheckForPipeChars(event)' onblur=makeValidString(this);putLocalLangPatientName(this,'"+CalledFromFunction+"');populateLocalValues(this,third_name_oth_lang,third_name,'O','"+CalledFromFunction+"') ; ");

						if(language_direction.equals("R"))
							{
							out.println( "dir='RTL' ");
							}

						if ( CalledFromFunction.equals("ChangePatDtls") || !a_third_name_loc_lang.equals("") || CalledFromFunction.equals("NewbornDtls"))
						{
							if (!a_third_name_loc_lang.equals(""))
								out.print(" value = \""+a_third_name_loc_lang+"\" >");  
							else
							if(!(((String)(hash_Map1.get("third_name_loc_lang")==null?"":hash_Map1.get("third_name_loc_lang"))).equals("")))
								out.print(" value=\""+(String)hash_Map1.get("third_name_loc_lang")+"\">");
							else 
								out.print(" value = \"\" >");   
						} 
						else out.print(" value = \"\" >");
						%><input type='button' class='button' value='?' style='<%=name_comp_visibility%>' onclick="callSearch(third_name_oth_lang,third_name,'Others','<%=CalledFromFunction%>')" name='bto'>
						</td><td class='label' >&nbsp;</td>
						<%
					}
					else
					{
						emptyCnt++;
					}
				 }
				 else if (order.equals("Second_Name_Order"))
				 {
					if(Second_Name_Accept_Yn.equals("Y")) 
					{ 
						out.println("	<td     class='arabic'><input type='text' name='second_name_oth_lang' id='second_name_oth_lang' maxlength='"+second_name_length+"' size='20' onKeyPress='return CheckForPipeChars(event)' onblur=makeValidString(this);putLocalLangPatientName(this,'"+CalledFromFunction+"');populateLocalValues(this,second_name_oth_lang,second_name,'O','"+CalledFromFunction+"') ; ");

						if(language_direction.equals("R"))
							{
							out.println( "dir='RTL' ");
							}

						if( CalledFromFunction.equals("ChangePatDtls") || !a_second_name_loc_lang.equals("") || CalledFromFunction.equals("NewbornDtls"))
						{
							if (!a_second_name_loc_lang.equals(""))
								out.print(" value = \""+a_second_name_loc_lang+"\" >");   
							else
							if (!(((String)(hash_Map1.get("second_name_loc_lang")==null?"":hash_Map1.get("second_name_loc_lang"))).equals("")))
								out.print(" value=\""+(String)hash_Map1.get("second_name_loc_lang") +"\">");
							else 
								out.print(" value = \"\" >");    
						}
						else out.print(" value = \"\" >");
						%><input type='button' class='button' style='<%=name_comp_visibility%>' value='?'onclick="callSearch(second_name_oth_lang,second_name,'Others','<%=CalledFromFunction%>')" name='bso'> 
						</td><td class='label' >&nbsp;</td>
						<%
					}
					else
					{
						emptyCnt++;
					}
				 }
				 else  if (order.equals("First_Name_Order"))
				 {
					if(First_Name_Accept_Yn.equals("Y")) 
					{ 
						out.println("<td     class='arabic'><input type='text' name='first_name_oth_lang' id='first_name_oth_lang' maxlength='"+first_name_length+"' size='20' onKeyPress='return CheckForPipeChars(event)' onblur=makeValidString(this);putLocalLangPatientName(this,'"+CalledFromFunction+"');populateLocalValues(this,first_name_oth_lang,first_name,'O','"+CalledFromFunction+"') ; ");

						if(language_direction.equals("R"))
							{
							out.println( "dir='RTL' ");
							}

						if ( CalledFromFunction.equals("ChangePatDtls")  || !a_first_name_loc_lang.equals("") || CalledFromFunction.equals("NewbornDtls") )
						{
							if (!a_first_name_loc_lang.equals(""))
								out.print(" value=\""+a_first_name_loc_lang+"\">");
							else
							if(!(((String)(hash_Map1.get("first_name_loc_lang")==null?"":hash_Map1.get("first_name_loc_lang"))).equals("")))
								out.print(" value=\""+(String)hash_Map1.get("first_name_loc_lang") +"\">");
							else 
							 out.print(" value = \"\" >");
								
						} else out.print(" value = \"\" >");  
						%><input type='button' class='button' value='?' style='<%=name_comp_visibility%>' onclick="callSearch(first_name_oth_lang,first_name,'Others','<%=CalledFromFunction%>')" name='bfo'>
						</td><td class='label' >&nbsp;</td>
						<%
					}
					else
					{
						emptyCnt++;
					}
				 }
				 else				
			  {
				 emptyCnt++;
			  }
			}
		 }
		 /* if (pat_name_as_multipart_yn.equals("Y") ) */
			else
			{
			   if(Family_Name_Accept_Yn.equals("Y") ) 
			   {
				out.print("<td  class='arabic' ><input type='text' name='family_name_oth_lang' id='family_name_oth_lang' maxlength='"+family_name_length+"' size='"+familyNametextBoxSize+"' onKeyPress='return CheckForPipeChars(event)' onblur=makeValidString(this);putLocalLangPatientName(this,'"+CalledFromFunction+"'); ");

					if(language_direction.equals("R"))
							{
							out.println( "dir='RTL' ");
							}

				if ( CalledFromFunction.equals("ChangePatDtls") || !a_name_suffix_loc_lang.equals("")  )
				{
					if(!(((String)hash_Map1.get("family_name_loc_lang")).equals("")))
						out.print(" value=\""+(String)hash_Map1.get("family_name_loc_lang")+"\">");
					else out.print(" value = \"\" >");    
				} 
				else out.print(" value = \""+a_name_suffix_loc_lang+"\" >");    
				%>
				</td>
				<%
			} 
		}
	
			if(Name_Prefix_Accept_Yn.equals("Y")) 
			{
				if(pat_name_as_multipart_yn.equals("N")) 
				{ 
					%>
					<td class='arabic'   ><Select name='name_prefix_oth_lang' id='name_prefix_oth_lang' onchange='sel_prefix_gen(this,"<%=CalledFromFunction%>");putLocalLangPatientName(this,"<%=CalledFromFunction%>");if (document.forms[0].entitlement_by_pat_cat_yn && document.forms[0].entitlement_by_pat_cat_yn.value=="Y"){getPatCategory();}' dir='RTL'  >
					<%
				}
				else
				{ 
					%>
					<td class='arabic'  ><Select name='name_prefix_oth_lang' id='name_prefix_oth_lang' onchange='sel_prefix_gen(this,"<%=CalledFromFunction%>");putLocalLangPatientName(this,"<%=CalledFromFunction%>");if ( document.forms[0].entitlement_by_pat_cat_yn && document.forms[0].entitlement_by_pat_cat_yn.value=="Y"){getPatCategory();}' dir='RTL' > 
					<%
				} 
				//if(Name_Prefix_Reqd_Yn.equals("N")) 
				//{ 
					%>
					<Option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>

					<script>
						prefix_loc_length = NamePrefixLocArrayTemp.length;//added By Sudhakar during UAT-3
							for(i = 0; i < prefix_loc_length; i++) {
								loc_name_pfx = unescape(NamePrefixLocArrayTemp[i]);//added By Sudhakar during UAT-3
								if(loc_name_pfx!='') {

									opt = document.createElement("OPTION");									
									opt.text = loc_name_pfx;
									opt.value = loc_name_pfx;
									if('<%=isNewBornChngsAppl%>'=='true' && "<%=calling_module_id%>" == "IP"){
										if('<%=CalledFromFunction%>'=='NewbornDtls') {
											if(document.getElementById("name_prefix_oth_lang")) 
												document.getElementById("name_prefix_oth_lang").options.add(opt);	
										} else { 
											if(document.getElementById("name_prefix_oth_lang") && document.getElementById("name_prefix_oth_lang")[1]) { 
												document.getElementById("name_prefix_oth_lang")[1].options.add(opt);
											} 
										}
									}else{
									if('<%=CalledFromFunction%>'=='NewbornDtls') {
										if(document.getElementById("name_prefix_oth_lang") && document.getElementById("name_prefix_oth_lang")[1]) { 
											document.getElementById("name_prefix_oth_lang")[1].options.add(opt);
										} 				
									} else { 
										if(document.getElementById("name_prefix_oth_lang")) 
											document.getElementById("name_prefix_oth_lang").options.add(opt);			
									} 
									}
									//document.forms[0].name_prefix_oth_lang.add(opt);

									if('<%=CalledFromFunction%>' == 'ChangePatDtls' || "<%=a_name_prefix_loc_lang%>"!='') {
										if('<%=CalledFromFunction%>' == 'ChangePatDtls' && loc_name_pfx == "<%=(String)hash_Map1.get("name_prefix_loc_lang")%>") {
											opt.selected=true;
										} else if(loc_name_pfx == "<%=a_name_prefix_loc_lang%>") {				
											opt.selected=true;
										} 
									}
								}
							}
					</script>

					<%
				//}
					/*
				array_List.clear(); 
				array_List = eMP.ChangePatientDetails.getResultRows(conn,"mp_name_prefix1",p);
				for(int i=0;i<array_List.size();i+=2) 
				{ 
					if(!((String)array_List.get(i)).equals("")) 
					{
						out.print("<option  value=\""+(String)array_List.get(i)+"\"");
						if(CalledFromFunction.equals("ChangePatDtls")  || !a_name_prefix_loc_lang.equals("") ) {
						if ( ((String)array_List.get(i)).equals((String)hash_Map1.get("name_prefix_loc_lang")) ||
							((String)array_List.get(i)).equals(a_name_prefix_loc_lang) )
								out.print(" selected >" );
							else out.print(" > " );
						}
						else out.print(" > " );
						out.print((String)array_List.get(i)+"</option>");
						}
					}*/ %></Select></td>	<!-- <td class='label'>&nbsp;</td> -->
			<%}
   		    
		 

	
		 /*To fill the blank spaces in the table with blank TDs*/
			 for(int j=1;j<=emptyCnt;++j)
			   {%><td class='label' colspan='2'>&nbsp;</td><%}
			%></tr>
		<%	
			if(CalledFromFunction.equals("PatientRegistration")) { %>
				<script>if (parent.frames[0].document.getElementById("patient_name_loc_lang")) parent.frames[0].document.getElementById("patient_name_loc_lang").style.visibility = 'visible';</script><% }

		}
		/*******end for Arabic*********/
		}
		if(!CalledFromFunction.equals("NewbornDtls"))	{
		%>
			<input type='hidden' name='language_direction' id='language_direction' value=<%=language_direction%>>
			<input type='hidden' name='pat_names_in_oth_lang_yn' id='pat_names_in_oth_lang_yn' value=<%=names_in_oth_lang_yn%>>		
		<%
		}

		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(conn,request);
	}
	%>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
	}
%>

