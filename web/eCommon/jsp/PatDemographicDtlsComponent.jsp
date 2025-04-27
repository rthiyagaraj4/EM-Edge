<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import ="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
	Connection con			= null;
    PreparedStatement pstmt	= null;
    ResultSet rs			= null;	
	Statement stmt=null;
	ResultSet alcn_rs=null;
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 

	String strBodyFrame		= request.getParameter("bodyFrame");
	String strSubmitFrame	= request.getParameter("submitFrame");
	String op_call			= request.getParameter("op_call");
	String function_id		= request.getParameter("function_id");
	String citizen_yn		= request.getParameter("citizen_yn") == null ? "N" : request.getParameter("citizen_yn");
	String alcn_criteria_mp=request.getParameter("alcn_criteria")==null?"":request.getParameter("alcn_criteria");
	String clinic_code_mp=request.getParameter("clinic_code")==null?"":request.getParameter("clinic_code");
	String pract_id_mp=request.getParameter("i_practitioner_id")==null?"":request.getParameter("i_practitioner_id");
	String appt_date_mp=request.getParameter("i_appt_date")==null?"":request.getParameter("i_appt_date");
	String facility_id_mp=(String)(session.getValue("facility_id")==null?"":session.getValue("facility_id"));
	if(function_id == null) function_id = "";
	String alcn_srl_no_sql="";
	String alcn_srl_no="";
	String alcn_sql="";

	if(op_call == null) op_call = "";
	if(op_call.equals("reg_pat") || op_call.equals("ae_reg_pat"))
	  strBodyFrame = "parent.parent.frames[1].frames[0]";
%>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
	<Script language="JavaScript"src="../../eCommon/js/DateUtils.js" ></Script>
	<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<Script src="../../eMP/js/natAltIdComponent.js" language="JavaScript"></Script>
	<Script src="../../eMP/js/PatientRegistration1.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script>
		varBodyFrame = '<%=strBodyFrame%>'
		varSubmitFrame = '<%=strSubmitFrame%>'

		function CheckBirthPlace()
		{
			if(document.forms[0].birth_place.value == "")			
			   document.forms[0].place_of_birth.disabled = false;
			else
			   document.forms[0].place_of_birth.disabled = true;
		}
		function CheckBirthCode()
		{
			if(document.forms[0].place_of_birth.value	== "")
			{
			   document.forms[0].birth_place.disabled	= false;
			}
			else
			{
			  document.forms[0].birth_place.disabled = true;
			}
		}

		function putPatientName()
		{
			var logic = new String();
		    logic = document.getElementById("name_dervn_logic").value;
			var derivedName = "";
			derivedName = '';
			var logicElements = new Array();
			logicElements = logic.split('!');
			var i = 0;
			for(i=0;i<logicElements.length;i++)
			{
				if(logicElements[i] == '1N' && eval(varBodyFrame).document.getElementById("first_name") != null)
				{
					if(eval(varBodyFrame).document.getElementById("first_name").value != '')
						derivedName = derivedName + eval(varBodyFrame).document.getElementById("first_name").value;
				}
				else if(logicElements[i] == '2N' && eval(varBodyFrame).document.getElementById("second_name") != null )
				{
					if(eval(varBodyFrame).document.getElementById("second_name").value != '')
						derivedName = derivedName + eval(varBodyFrame).document.getElementById("second_name").value;
				}
				else if(logicElements[i] == '3N' && eval(varBodyFrame).document.getElementById("third_name") != null)
				{
					if(eval(varBodyFrame).document.getElementById("third_name").value != '')
						derivedName = derivedName + eval(varBodyFrame).document.getElementById("third_name").value;
				}
				else if(logicElements[i] == 'FN' && eval(varBodyFrame).document.getElementById("family_name") != null)
				{
					if(eval(varBodyFrame).document.getElementById("family_name").value != '')
						derivedName = derivedName + eval(varBodyFrame).document.getElementById("family_name").value;
				}
				else if(logicElements[i] == 'PR' && eval(varBodyFrame).document.getElementById("name_prefix") != null)
				{
					
					if(eval(varBodyFrame).document.getElementById("name_prefix").value != '')
						derivedName = derivedName + eval(varBodyFrame).document.getElementById("name_prefix").value;
				}
				else if(logicElements[i] == 'SF' && eval(varBodyFrame).document.getElementById("name_suffix") != null)
				{
					if(eval(varBodyFrame).document.getElementById("name_suffix").value != '')
						derivedName = derivedName + eval(varBodyFrame).document.getElementById("name_suffix").value;
				}
				else
				{
					if(logicElements[i] != '1N' &&  logicElements[i] != '2N' && logicElements[i] != '3N' && logicElements[i] != 'FN' && logicElements[i] != 'PR' && logicElements[i] != 'SF')
					{
						var arLen	= logicElements[i].length;
						var tempVal = logicElements[i].substring(1,arLen - 1);
						if(derivedName == "")  tempVal="";
						derivedName = derivedName + tempVal;
					}
				}
			}
			if(eval(varBodyFrame).document.getElementById("pat_name_as_multipart_yn").value == "Y")
			{
				if ( derivedName.length >= 40 )
					derivedName = derivedName.substr(0,40);			
			}
			else
			{
				if ( derivedName.length >= 60 )
					derivedName = derivedName.substr(0,60);
			}

			//added by gomathi 
			if(eval(varBodyFrame).document.getElementById("name_prefix1") != null)
			{
				if(eval(varBodyFrame).document.getElementById("name_prefix1").value == '')
				{
					var s = derivedName.length;
					var temp = derivedName.substring(s);
					var temp1 = derivedName.substring(0,s);
					
					var n = temp1.charCodeAt(0);
					//if((n>=65 && n<=91)||(n>=97 && n<=123))
					if((n<48 || n>57)) // Only check for Numerals. Thai Name is allowed to be entered.
					{
						  derivedName = temp + temp1;
					}
					else
					{
						   derivedName = temp;
					}
				}
			}

			var derievedName1 = derivedName.split(',');
			if(derievedName1[1] == ' ')
			{
				derivedName = 	derievedName1[0];
			}
			eval(varBodyFrame).document.getElementById("patient_name1").innerHTML = "<b>"+derivedName;
			eval(varBodyFrame).document.getElementById("patient_name").value =derivedName;
		
		}
	
		function loadEthnicSubGroup()
		{
			var op_call = '<%=op_call%>';
			if(op_call == 'reg_pat' || op_call == 'ae_reg_pat')
			{
				 varSubmitFrame = "parent.parent.frames[2]"
				 varBodyFrame	= "parent.parent.frames[1].frames[0]"
			}

	 		HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/natAltIdDOB.jsp'><input type='hidden' name='process_id' id='process_id' value='3'><input name='race_code' id='race_code' type='hidden' value=\""+eval(varBodyFrame).document.getElementById("race_code").value + "\"><input type='hidden'  name='bodyFrameRef' id='bodyFrameRef' value=\""+varBodyFrame+"\"><input type='hidden'  name='op_call' id='op_call' value=\""+op_call+"\"></form></BODY></HTML>";

			//eval(varSubmitFrame).document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			eval(varSubmitFrame).document.write(HTMLVal);	
			eval(varSubmitFrame).document.form1.submit();
		}
	
		function disable_Legal_If_Citzen()
		{
			if(document.getElementById("citizen_yn")[0].checked==true)
			{
				document.getElementById("legal_yn")[0].checked=true;
				document.getElementById("citizen").value='Y';
				document.getElementById("citizen_yn").value='Y';
				document.getElementById("legal_yn").value='Y';
				document.getElementById("legal_yn")[0].disabled = true;
				document.getElementById("legal_yn")[1].disabled = true;
				document.getElementById("nationality_code1").value = document.getElementById("dflt_nationality_code").value
				document.getElementById("nationality_desc").value = document.getElementById("dflt_nationality_desc").value
				document.getElementById("eth_gif").style.visibility='visible';
				document.getElementById("race_yn").value='Y';
			
				document.getElementById("nationality_desc").value=document.getElementById("dflt_nationality_desc").value;
				document.getElementById("nationality_code1").value=document.getElementById("dflt_nationality_code").value;

				document.getElementById("race_code").disabled = false
								
				if(document.getElementById("default_race_code").value=='')
				{
					document.getElementById("race_code").options[0].selected = true;
				}
				else
				{
					document.getElementById("race_code").value=document.getElementById("default_race_code").value;
					document.getElementById("ethnic_group").disabled = false;
					loadEthnicSubGroup();
				}
			}
			else
			{
				document.getElementById("legal_yn")[0].checked=true;
				document.getElementById("citizen").value='N';
				document.getElementById("citizen_yn").value='N';
				document.getElementById("legal_yn").value='Y';
				document.getElementById("nationality_desc").value="";
				document.getElementById("nationality_code1").value = "";
				document.getElementById("legal_yn")[0].disabled = false;
				document.getElementById("legal_yn")[1].disabled = false;
				document.getElementById("eth_gif").style.visibility='hidden';
				document.getElementById("race_yn").value='N';

				document.getElementById("race_code").disabled = false
				document.getElementById("race_code").value="";
				document.getElementById("ethnic_group").disabled = false;

				loadEthnicSubGroup();
			}
		}

		function searchBirthPlace(obj,target)
        {
			var retVal =    new String();
            var argumentArray  = new Array();
			var dataNameArray  = new Array();
			var dataValueArray = new Array();
			var dataTypeArray  = new Array();

            var tit = "";				
			var locale= document.forms[0].locale.value;

			tit=getLabel("Common.birthPlace.label","common");
			sql="Select birth_place_code code,long_desc description from mp_birth_place_lang_vw where language_id = '"+localeName+"' AND eff_status='E' and upper(birth_place_code) like upper(?) and upper(long_desc) like upper(?)";

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
					
				eval(varBodyFrame).document.getElementById("Birth_place_code").value= arr[0];
			}
			else
			{
				target.value='';
			}
		}
		function searchCountry(obj,target)
        {
			var retVal =    new String();
            var argumentArray  = new Array() ;
			var dataNameArray  = new Array() ;
			var dataValueArray = new Array() ;
			var dataTypeArray  = new Array() ;
			var locale= document.forms[0].locale.value;
			var tit="";				
            tit=getLabel("Common.nationality.label","common")
			sql="Select country_code code,long_desc description from Mp_Country_lang_vw where language_id = '"+localeName+"' AND eff_status='E' and  upper(country_code) like upper(?) and upper(long_desc) like upper(?)";					
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
				eval(varBodyFrame).document.getElementById("nationality_code1").value= arr[0];
				dftCountryGroup();
			}
			else{
				target.value='';
			}
		}

	/*Commented as not required to fetch 
	function fetchLocalNames(obj)
	{
		var oth_name = obj.name
	    if(oth_name.indexOf("oth_lang")  == -1 )
		   oth_name = "document.forms[0]."+oth_name+"_oth_lang"
		var oth_lang = document.forms[0].names_in_oth_lang.value; 
		if( obj.value != ""  && oth_name !=null )
		{

			var HTMLVal = new String();
			HTMLVal = "<HTML><head></head><BODY class='message'><form name='form1' id='form1' method='post' action='../../eMP/jsp/ServerValidation.jsp'><input type='hidden' name='process_id' id='process_id' value='9'><input type='hidden' name='names_in_oth_lang' id='names_in_oth_lang' value='"+oth_lang+"'><input type='hidden' name='name_fld' id='name_fld' value='" + obj.name +"'><input type='hidden' name='from_nat_id' id='from_nat_id' value='Y'><input type='hidden' name='param_val' id='param_val' value='" + obj.value +"'>"
			HTMLVal += "</form></BODY></HTML>";
			//parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.parent.messageFrame.document.write(HTMLVal);
			parent.parent.messageFrame.document.form1.submit();
		}
	}*/

	function putLocalLangPatientName(from){

	var language_direction= document.getElementById("language_direction1").value;

	var logic = new String();
    //logic = document.getElementById("name_drvn_logic").value;
	logic = document.getElementById("name_drvn_logic_oth_lang").value;
	var pat_name_as_multipart_yn = document.getElementById("pat_name_as_multipart_yn").value;
    var derievedName = new String();
    derievedName = '';
    var logicElements = new Array();
    logicElements = logic.split('+');
    var i=0;

	//if(language_direction!="R")
	//{
	for(i=0;i<logicElements.length;i++)
		
	{
	    if ( logicElements[i] == '1N' && document.getElementById("first_name_oth_lang")!= null)
        {
            if ( document.getElementById("first_name_oth_lang").value != '' )
                derievedName =  derievedName+ document.getElementById("first_name_oth_lang").value  ;
        }
        else if ( logicElements[i] == '2N' && document.getElementById("second_name_oth_lang") != null )
        {
            if ( document.getElementById("second_name_oth_lang").value != '' )
                derievedName =  derievedName+ document.getElementById("second_name_oth_lang").value ;
        }
        else if ( logicElements[i] == '3N' && document.getElementById("third_name_oth_lang") != null)
        {
            if ( document.getElementById("third_name_oth_lang").value != '' )
                derievedName = derievedName+ document.getElementById("third_name_oth_lang").value ;
        }
        else if ( logicElements[i] == 'FN' && document.getElementById("family_name_oth_lang") != null)
        {
            if ( document.getElementById("family_name_oth_lang").value != '' )
                derievedName =  derievedName+ document.getElementById("family_name_oth_lang").value ;
        }
        else if ( logicElements[i] == 'PR' && document.getElementById("name_prefix_oth_lang") != null)
        {
            if ( (document.getElementById("name_prefix_oth_lang")) && (document.getElementById("name_prefix_oth_lang").value != '') )
            {
                var prefix_loc_lang = document.getElementById("name_prefix_oth_lang").value;
                prefix_loc_lang = prefix_loc_lang.substring(prefix_loc_lang.indexOf("$")+1,prefix_loc_lang.length);
                derievedName =   derievedName+prefix_loc_lang ;
            }
        }
        else if ( logicElements[i] == 'SF' && document.getElementById("name_suffix_oth_lang") != null)
        {
            if ( document.getElementById("name_suffix_oth_lang").value != '' )
            {
                var suffix_loc_lang = document.getElementById("name_suffix_oth_lang").value;
                suffix_loc_lang = suffix_loc_lang.substring(suffix_loc_lang.indexOf("$")+1,suffix_loc_lang.length);
                derievedName =   derievedName+suffix_loc_lang ;
            }
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
/*	}
	else
	{
		for ( i=logicElements.length-1;i>=0;i--)
		{
	    if ( logicElements[i] == '1N' && document.getElementById("first_name_oth_lang")!= null)
        {
            if ( document.getElementById("first_name_oth_lang").value != '' )
                derievedName =  derievedName+ document.getElementById("first_name_oth_lang").value  ;
        }
        else if ( logicElements[i] == '2N' && document.getElementById("second_name_oth_lang") != null )
        {
            if ( document.getElementById("second_name_oth_lang").value != '' )
                derievedName =  derievedName+ document.getElementById("second_name_oth_lang").value ;
        }
        else if ( logicElements[i] == '3N' && document.getElementById("third_name_oth_lang") != null)
        {
            if ( document.getElementById("third_name_oth_lang").value != '' )
                derievedName = derievedName+ document.getElementById("third_name_oth_lang").value ;
        }
        else if ( logicElements[i] == 'FN' && document.getElementById("family_name_oth_lang") != null)
        {
            if ( document.getElementById("family_name_oth_lang").value != '' )
                derievedName =  derievedName+ document.getElementById("family_name_oth_lang").value ;
        }
        else if ( logicElements[i] == 'PR' && document.getElementById("name_prefix_oth_lang") != null)
        {
            if ( (document.getElementById("name_prefix_oth_lang")) && (document.getElementById("name_prefix_oth_lang").value != '') )
            {
                var prefix_loc_lang = document.getElementById("name_prefix_oth_lang").value;
                prefix_loc_lang = prefix_loc_lang.substring(prefix_loc_lang.indexOf("$")+1,prefix_loc_lang.length);
                derievedName =   derievedName+prefix_loc_lang ;
            }
        }
        else if ( logicElements[i] == 'SF' && document.getElementById("name_suffix_oth_lang") != null)
        {
            if ( document.getElementById("name_suffix_oth_lang").value != '' )
            {
                var suffix_loc_lang = document.getElementById("name_suffix_oth_lang").value;
                suffix_loc_lang = suffix_loc_lang.substring(suffix_loc_lang.indexOf("$")+1,suffix_loc_lang.length);
                derievedName =   derievedName+suffix_loc_lang ;
            }
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
	
} */
	if (pat_name_as_multipart_yn == 'N')
	{
		if ( derievedName.length >= 60 )
			derievedName = derievedName.substr(0,60);
	}
	else
	{
		if ( derievedName.length >= 40 )
			derievedName = derievedName.substr(0,40);
	}
	//			eval(varBodyFrame).document.getElementById("patient_name1").innerHTML = "<b>"+derivedName;
	//		eval(varBodyFrame).document.getElementById("patient_name").value =derivedName;
		
	document.getElementById("patient_name_local_lang1").innerHTML = derievedName;
    document.getElementById("patient_name_local_lang").value = derievedName;
} // End of FUNCTION

	

</script>

<%!

	public ArrayList getData1(String sql,String[] whereClause,HttpServletRequest request,JspWriter out,Connection con) throws Exception
	{

	   ArrayList arrL_of_HashMap            = new ArrayList() ;
	   PreparedStatement pstmt1             = null ;
	   ResultSet resultSet                  = null ;
	   ResultSetMetaData resultSetMetaData	= null;
	   //ArrayList deBug                    = new ArrayList() ;

		try
		{			
			pstmt1	= con.prepareStatement(sql) ;

            if(whereClause != null)
                for(int index=0; index<whereClause.length ;index++ )
                   pstmt1.setString( index+1, whereClause[index]);

		    resultSet = pstmt1.executeQuery() ;
			if(resultSet != null)
			{
				resultSetMetaData   =   resultSet.getMetaData();
				HashMap hmRecord    =  new HashMap();
                while(resultSet.next())
				{
					
					for(int i=1; i<=resultSetMetaData.getColumnCount(); i++)
					{
						String column_Val=resultSet.getString(resultSetMetaData.getColumnName(i));
                        if(column_Val==null) column_Val="";     
						hmRecord.put(resultSetMetaData.getColumnName(i),column_Val);
                    }
                    arrL_of_HashMap.add(hmRecord);            
				}
				hmRecord.clear();
			}
			if(pstmt1!=null) pstmt1.close();
            if(resultSet!=null) resultSet.close();
		}
		catch(Exception e)
		{
			
			e.printStackTrace() ;
			out.println(e.toString());     
		}
		finally
		{
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
		return arrL_of_HashMap;
	}
%>
<!-- @Declare the  Variables used  -->
<%
	String mp_param_sql = "  select accept_national_id_no_yn,ALT_ID1_EXP_DATE_ACCEPT_YN, ALT_ID2_EXP_DATE_ACCEPT_YN, ALT_ID3_EXP_DATE_ACCEPT_YN,ALT_ID4_EXP_DATE_ACCEPT_YN,name_prefix_accept_yn, name_prefix_reqd_yn, name_suffix_reqd_yn,name_suffix_accept_yn,  nvl(name_prefix_prompt,'')name_prefix_prompt, first_name_accept_yn, first_name_reqd_yn, nvl(first_name_prompt,'')first_name_prompt, nvl(name_suffix_prompt,'')name_suffix_prompt,second_name_accept_yn, second_name_reqd_yn, nvl(second_name_prompt,'')second_name_prompt, third_name_accept_yn, third_name_reqd_yn, nvl(third_name_prompt,'')third_name_prompt, family_name_accept_yn, family_name_reqd_yn,first_name_order, second_name_order, third_name_order,pat_name_as_multipart_yn, family_name_order,nvl(family_name_prompt,'')family_name_prompt, name_dervn_logic,name_dervn_logic_oth_lang,patient_id_length,NVL(Alt_Id1_reqd_yn,'N') Alt_Id1_reqd_yn, NVL(Alt_Id2_reqd_yn,'N') Alt_Id2_reqd_yn, NVL(Alt_Id3_reqd_yn,'N') Alt_Id3_reqd_yn, NVL(Alt_Id4_reqd_yn,'N') Alt_Id4_reqd_yn,  Alt_Id1_type, Alt_Id2_type, Alt_Id3_type,Alt_Id4_type,NVL(Alt_Id1_length,0)Alt_Id1_length,NVL(Alt_Id2_length,0)Alt_Id2_length, NVL(Alt_Id3_length,0) Alt_Id3_length,NVL(Alt_Id4_length,0)Alt_Id4_length,NVL(Alt_Id1_Unique_yn,'N')Alt_Id1_Unique_yn, NVL(Alt_Id2_Unique_yn,'N')Alt_Id2_Unique_yn,  NVL(Alt_Id3_Unique_yn,'N')Alt_Id3_Unique_yn, NVL(Alt_Id4_Unique_yn,'N')Alt_Id4_Unique_yn,NVL(ALT_ID1_LEN_VALIDATION_YN,'N') ALT_ID1_LEN_VALIDATION_YN,NVL(ALT_ID2_LEN_VALIDATION_YN,'N') ALT_ID2_LEN_VALIDATION_YN, NVL(ALT_ID3_LEN_VALIDATION_YN,'N') ALT_ID3_LEN_VALIDATION_YN, NVL(ALT_ID4_LEN_VALIDATION_YN,'N')ALT_ID4_LEN_VALIDATION_YN, alt_id1_exp_date_accept_yn,alt_id2_exp_date_accept_yn, alt_id3_exp_date_accept_yn,alt_id4_exp_date_accept_yn, alt_id1_routine_yn,  alt_id1_data_source_id alt_id1_routine,  alt_id2_routine_yn, alt_id2_data_source_id  alt_id2_routine, alt_id3_routine_yn, alt_id3_data_source_id  alt_id3_routine, alt_id4_routine_yn, alt_id4_data_source_id  alt_id4_routine, NVL(nat_id_prompt,'National ID No') nat_id_prompt,alt_id1_chk_digit_scheme,alt_id2_chk_digit_scheme,alt_id3_chk_digit_scheme,  alt_id4_chk_digit_scheme,citizen_nationality_code,default_race_code, names_in_oth_lang_yn, (SELECT b.long_desc FROM mp_country_lang_vw b WHERE language_id = '"+locale+"' AND a.citizen_nationality_code=b.country_code)citizen_nationality_desc,RACE_REQUIRED_YN  from mp_param_lang_vw a where language_id = '"+locale+"'";


	String accept_national_id_no_yn		= "";
	String nat_id_prompt				= "";
	String alt_id1_type					= "";
	String alt_id2_type					= "";
	String alt_id3_type					= "";
	String alt_id4_type					= "";
	String alt_id1_reqd_yn				= "";
	String alt_id2_reqd_yn				= "";
	String alt_id3_reqd_yn				= "";
	String alt_id4_reqd_yn				= "";
	String alt_id1_exp_date_accept_yn	= "";
	String alt_id2_exp_date_accept_yn	= "";
	String alt_id3_exp_date_accept_yn	= "";
	String alt_id4_exp_date_accept_yn	= "";
	String strNamePrefixAcceptYN		= "";
	String strNamePrefixReqdYN			= "";
	String strNameSuffixAcceptYN		= "";
	String strNameSuffixReqdYN			= "";
	String strNamePrefixPrompt			= "";
	String strFirstNamePrompt			= "";
	String strSecondNamePrompt			= "";
	String strThirdNamePrompt			= "";
	String strFamilyNamePrompt			= "";
	String strNameSuffixPrompt			= "";		
	String pat_name_as_multipart_yn		= "";
	String first_name_disp				= "";
	String second_name_disp				= "";
	String third_name_disp				= "";
	String family_name_disp				= "";
	String name_dervn_logic				= "";
	String name_dervn_logic_oth_lang				= "";

	String[] names			= new String[4] ;
	String[] name_prompts	= new String[4] ;

	//Use of the the following two defaulting values has been removed on 30.10.2004

	String citizen_nationality_code = "";
	String citizen_nationality_desc = "";
	String default_race_code		= "";
	String names_in_oth_lang_yn		= "";
	String race_code				= "";
	String race_desc				= "";
	String temp						= "";
	String race_required_yn			= "";
		
	try
	{
		con = ConnectionManager.getConnection(request);
		pstmt	= con.prepareStatement(mp_param_sql);
		rs		= pstmt.executeQuery();		

		if(rs != null && rs.next())
		{
			accept_national_id_no_yn = rs.getString("accept_national_id_no_yn");
			if(accept_national_id_no_yn==null) accept_national_id_no_yn = "N";

			nat_id_prompt = rs.getString("nat_id_prompt");
			if(nat_id_prompt== null) nat_id_prompt = "";

			alt_id1_type = rs.getString("alt_id1_type");
			if(alt_id1_type == null) alt_id1_type = "";

			alt_id1_reqd_yn = rs.getString("alt_id1_reqd_yn");
			if(alt_id1_reqd_yn == null) alt_id1_reqd_yn = "N";

			alt_id2_reqd_yn = rs.getString("alt_id2_reqd_yn");
			if(alt_id2_reqd_yn == null) alt_id2_reqd_yn = "N";

			alt_id3_reqd_yn = rs.getString("alt_id3_reqd_yn");
			if(alt_id3_reqd_yn == null) alt_id3_reqd_yn = "N";

			alt_id4_reqd_yn = rs.getString("alt_id4_reqd_yn");
			if(alt_id4_reqd_yn == null) alt_id4_reqd_yn = "N";
			
			alt_id2_type = rs.getString("alt_id2_type");
			if(alt_id2_type == null) alt_id2_type = "";

			alt_id3_type = rs.getString("alt_id3_type");
			if(alt_id3_type == null) alt_id3_type = "";

			alt_id4_type = rs.getString("alt_id4_type");
			if(alt_id4_type == null) alt_id4_type = "";
			alt_id1_exp_date_accept_yn = rs.getString("alt_id1_exp_date_accept_yn");
			if(alt_id1_exp_date_accept_yn == null) alt_id1_exp_date_accept_yn = "N";

			alt_id2_exp_date_accept_yn=rs.getString("alt_id2_exp_date_accept_yn");
			if(alt_id2_exp_date_accept_yn== null) alt_id2_exp_date_accept_yn = "N";
			alt_id3_exp_date_accept_yn=rs.getString("alt_id3_exp_date_accept_yn");
			if(alt_id3_exp_date_accept_yn== null) alt_id3_exp_date_accept_yn = "N";

			alt_id4_exp_date_accept_yn=rs.getString("alt_id4_exp_date_accept_yn");
			if(alt_id4_exp_date_accept_yn== null) alt_id4_exp_date_accept_yn = "N";


			strNamePrefixAcceptYN = rs.getString("name_prefix_accept_yn");
			if(strNamePrefixAcceptYN == null) strNamePrefixAcceptYN = "N";
			strNamePrefixReqdYN = rs.getString("name_prefix_reqd_yn");
			if(strNamePrefixReqdYN == null) strNamePrefixReqdYN = "N";
			strNameSuffixAcceptYN = rs.getString("name_suffix_accept_yn");
			if(strNameSuffixAcceptYN == null) strNameSuffixAcceptYN = "N";
			strNameSuffixReqdYN	= rs.getString("name_suffix_reqd_yn");
			if(strNameSuffixReqdYN == null) strNameSuffixReqdYN="N";
			strNamePrefixPrompt = rs.getString("name_prefix_prompt");
			if(strNamePrefixPrompt == null) strNamePrefixPrompt="";
			strFirstNamePrompt = rs.getString("first_name_prompt");
			if(strFirstNamePrompt == null) strFirstNamePrompt="";
			strSecondNamePrompt	= rs.getString("second_name_prompt");
			if(strSecondNamePrompt == null) strSecondNamePrompt="";
			strThirdNamePrompt = rs.getString("third_name_prompt");
			if(strThirdNamePrompt == null) strThirdNamePrompt="";
			strFamilyNamePrompt	= rs.getString("family_name_prompt");
			if(strFamilyNamePrompt == null) strFamilyNamePrompt="";
			strNameSuffixPrompt = rs.getString("name_suffix_prompt");
			if(strNameSuffixPrompt == null) strNameSuffixPrompt	="";
			citizen_nationality_code = rs.getString("citizen_nationality_code");
				
			if(	citizen_nationality_code == null) citizen_nationality_code="";
			citizen_nationality_desc = rs.getString("citizen_nationality_desc");
			if(	citizen_nationality_desc == null) citizen_nationality_desc="";
			default_race_code = rs.getString("default_race_code");
			if(default_race_code == null) default_race_code="";

			names_in_oth_lang_yn = rs.getString("names_in_oth_lang_yn");
			if(names_in_oth_lang_yn == null) names_in_oth_lang_yn="";
			pat_name_as_multipart_yn = rs.getString("pat_name_as_multipart_yn");
			if(pat_name_as_multipart_yn == null) pat_name_as_multipart_yn="N";

			race_required_yn = rs.getString("RACE_REQUIRED_YN")==null?"":rs.getString("RACE_REQUIRED_YN");

			
	
			//patidlength = rs.getString("patient_id_length")==null?"":rs.getString("patient_id_length");
			name_dervn_logic = rs.getString("name_dervn_logic")==null?"":rs.getString("name_dervn_logic");
			name_dervn_logic_oth_lang = rs.getString("name_dervn_logic_oth_lang")==null?"":rs.getString("name_dervn_logic_oth_lang");
			first_name_disp	= "<input type='text' name='first_name' id='first_name' maxlength='15' size='15' value= '' onblur='makeValidString(this);ChangeInitCase(this);putPatientName(this);' ><input type='hidden' class='button' name='b_first' id='b_first' value='?' onclick=\"callSearch(first_name,'first_name_oth_lang','firstname')\" >" ; 
			second_name_disp = "<input type='text' name='second_name' id='second_name' maxlength='15' size='15' value= '' onblur='makeValidString(this);ChangeInitCase(this);putPatientName(this);'><input type='hidden' class='button' name='b_second' id='b_second' value='?' onclick=\"callSearch(second_name,'second_name_oth_lang','secondname')\" >" ; 
			third_name_disp	= "<input type='text' name='third_name' id='third_name' maxlength='15' size='15' value= '' onblur='makeValidString(this);ChangeInitCase(this);putPatientName(this);' ><input type='hidden' class='button' name='b_third' id='b_third' value='?' onclick=\"callSearch(third_name,'third_name_oth_lang','thirdname')\">" ;
			
			if (pat_name_as_multipart_yn.equals("N"))						
			{
				family_name_disp = "<input type='text' name='family_name' id='family_name' maxlength='40' size='40' value=''  onblur='makeValidString(this);ChangeInitCase(this);putPatientName(this);'><input type='hidden' class='button' name='b_family' id='b_family' value='?' onclick=\"callSearch(family_name,'family_name_oth_lang','familyname')\" >" ; 
			}
			else
			{
				family_name_disp = "<input type='text' name='family_name' id='family_name' maxlength='15' size='15' value= '' onblur='makeValidString(this);ChangeInitCase(this);putPatientName(this);'><input type='hidden' class='button' name='b_family' id='b_family' value='?' onclick=\"callSearch(family_name,'family_name_oth_lang','familyname')\" >" ; 					
			}
			
			if ( checkForNull(rs.getString("first_name_accept_yn")).equals("Y") )
			{
				String first_reqd = "" ;
				
				if(checkForNull(rs.getString("first_name_reqd_yn")).equals("Y"))
				{
					first_reqd  = first_reqd  +"<img src='../../eCommon/images/mandatory.gif'></img><input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='Y'> ";
				}	
				
				if( checkForNull(rs.getString("first_name_order")).equals("1") )
				{
					names[0]  =first_name_disp  ;
					name_prompts[0] = strFirstNamePrompt+first_reqd ;
				}
				else if(checkForNull(rs.getString("first_name_order")).equals("2"))
				{
					names[1]  =first_name_disp  ;
					name_prompts[1] = strFirstNamePrompt +first_reqd;
				}
				else if(checkForNull(rs.getString("first_name_order")).equals("3"))
				{
					names[2]  =first_name_disp  ;
					name_prompts[2] = strFirstNamePrompt +first_reqd;
				}
				else
				{
					names[3]  =first_name_disp  ;
					name_prompts[3] = strFirstNamePrompt +first_reqd;
				}
			}
					
			if ( checkForNull(rs.getString("second_name_accept_yn")).equals("Y") )
			{
				String sec_reqd = "" ;
				
				if(checkForNull(rs.getString("second_name_reqd_yn")).equals("Y"))
				{
					sec_reqd  = sec_reqd  +"<img src='../../eCommon/images/mandatory.gif'></img><input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='Y'>";
				}
				
				if( checkForNull(rs.getString("second_name_order")).equals("1") )
				{
					names[0]  =second_name_disp ;
					name_prompts[0] = strSecondNamePrompt+ sec_reqd ;
				}
				else if(checkForNull(rs.getString("second_name_order")).equals("2"))
				{
					names[1]  =second_name_disp ;
					name_prompts[1] = strSecondNamePrompt+sec_reqd ;
				}
				else if(checkForNull(rs.getString("second_name_order")).equals("3"))
				{
					names[2]  =second_name_disp ;
					name_prompts[2] = strSecondNamePrompt + sec_reqd;
				}
				else
				{
					names[3]  =second_name_disp ;
					name_prompts[3] = strSecondNamePrompt+sec_reqd ;
				}
			}

				
			if ( checkForNull(rs.getString("third_name_accept_yn")).equals("Y") )
			{
				String th_reqd = "" ;
				if(checkForNull(rs.getString("third_name_reqd_yn")).equals("Y"))
				{
					th_reqd  = th_reqd  +"<img src='../../eCommon/images/mandatory.gif'></img><input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='Y'>";
				}
				if( checkForNull(rs.getString("third_name_order")).equals("1") )
				{
					names[0]  =third_name_disp ;
					name_prompts[0] = strThirdNamePrompt +th_reqd;
				}
				else if(checkForNull(rs.getString("third_name_order")).equals("2"))
				{
					names[1]  =third_name_disp ;
					name_prompts[1] = strThirdNamePrompt+th_reqd ;
				}
				else if(checkForNull(rs.getString("third_name_order")).equals("3"))
				{
					names[2]  =third_name_disp ;
					name_prompts[2] = strThirdNamePrompt +th_reqd;
				}
				else
				{
					names[3]  =third_name_disp ;
					name_prompts[3] = strThirdNamePrompt+th_reqd ;
				}
			}

			if ( checkForNull(rs.getString("family_name_accept_yn")).equals("Y") )
			{
				String fam_reqd = "" ;
				if(checkForNull(rs.getString("family_name_reqd_yn")).equals("Y"))
				{
						fam_reqd   = fam_reqd   +"<img src='../../eCommon/images/mandatory.gif'></img><input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='Y'>";
				}		
				if( checkForNull(rs.getString("family_name_order")).equals("1") )
				{
					names[0]  =family_name_disp  ;
					name_prompts[0] = strFamilyNamePrompt +fam_reqd;
				}
				else if(checkForNull(rs.getString("family_name_order")).equals("2"))
				{
					names[1]  =family_name_disp  ;
					name_prompts[1] = strFamilyNamePrompt+fam_reqd ;
				}
				else if(checkForNull(rs.getString("family_name_order")).equals("3"))
				{
					names[2]  =family_name_disp  ;
					name_prompts[2] = strFamilyNamePrompt +fam_reqd;
				}
				else
				{
					names[3]  =family_name_disp  ;
					name_prompts[3] = strFamilyNamePrompt +fam_reqd ;
				}
			}
		}



		/**** Added for Arabic ****/

		String language_direction="";
		int count=0;

		if(pstmt != null) pstmt.close();
		if(rs != null) rs.close();

		pstmt = con.prepareStatement( "select count(*) as total from sm_language where language_direction='R' and eff_status='E'" ) ;
		
		rs = pstmt.executeQuery() ;
             
			
        if ( rs != null && rs.next() ) 
		 {
		  count = rs.getInt("total");
		 }

		if ( count==1 ) 
		{
			 language_direction = "R" ;
		}else
		{
			 language_direction = "L" ;
		}

	
		/**** End of Arabic changes ****/


%>
<%
		if (localeName.equals("th"))
		{%>
			<input type='hidden' name='other_era_diff' id='other_era_diff' value="543"></input>
		<%}else{%>
			<input type='hidden' name='other_era_diff' id='other_era_diff' value="0"></input>
	<%}%>
 <tr>
	<td colspan=1 width='100%'>
		<input type='hidden' name='names_in_oth_lang' id='names_in_oth_lang' value="<%=names_in_oth_lang_yn%>"></input>
		<input type='hidden' name='name_drvn_logic_oth_lang' id='name_drvn_logic_oth_lang' value="<%=name_dervn_logic_oth_lang%>"></input>
		<input type='hidden' name='language_direction1' id='language_direction1' value="<%=language_direction%>"></input>

	<%--	<table cellpadding=0 cellspacing=0 border='0' width="100%">
			<tr>
				<% if(strNamePrefixAcceptYN.equals("Y")) { %>	
					<td class='LABELLEFT' nowrap><%=strNamePrefixPrompt%>
				<% } if(strNamePrefixReqdYN.equals("Y")) { %>
						<img src='../../eCommon/images/mandatory.gif'></img><input type='hidden' name='name_prefix_reqd_yn' id='name_prefix_reqd_yn' value='Y'>
						</td> 
				<% } 
				for(int i=0; i<name_prompts.length; i++)
					if(name_prompts[i]!=null) { %>
						<td class='LABELLEFT'><%=name_prompts[i]%></td>
					<% }  if(strNameSuffixAcceptYN.equals("Y")) { %>
						<td class='LABELLEFT' nowrap><%=strNameSuffixPrompt%> 
					<% } if(strNameSuffixReqdYN.equals("Y")) { %>
						<img src='../../eCommon/images/mandatory.gif'></img><input type='hidden' name='name_suffix_reqd_yn' id='name_suffix_reqd_yn' value='Y'>
						</td> 
					<% } %> 
				</tr>
				<tr>
				<%
					if(strNamePrefixAcceptYN.equals("Y"))
					{
					out.println("<td class='fields'>");
					try{    
							String sql = null;
							sql="Select Name_Prefix,name_prefix_loc_lang,prefix_sex from Mp_Name_Prefix where eff_status='E' and trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) order by 1";
							if(pstmt!=null) pstmt.close();
							if(rs!=null) rs.close();
							pstmt = con.prepareStatement(sql);
							rs = pstmt.executeQuery();
							//Added on 15/03/2003 for Prifix
							if(pat_name_as_multipart_yn.equals("N"))
							{
							out.println("<select name='name_prefix1' id='name_prefix1' onblur='putPatientName(this)' onchange='checkPrefix();' >") ; 
							}
							else
							{
							out.println("<select name='name_prefix1' id='name_prefix1' onblur='putPatientName(this)' onchange='checkPrefix();' >") ; 
							}
							//End of addition on 15/03/2003
							out.println("<option value=''>&nbsp-"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-&nbsp</option>");
							if(rs != null)
							{
									int k=0;
									while (rs.next())
									{  %>        
										<option value="<%=rs.getString("Name_Prefix")%>"><%=rs.getString("Name_Prefix")%></option>
										<%k++;
									}
							}   
							out.println("</select></td>") ;
						}catch(Exception e) { 
							out.println(e.toString());
							e.printStackTrace();
						}
						finally
						{
							if (pstmt != null) pstmt.close();
							if (rs != null) rs.close();
						}
						%><input type='hidden' name='name_prefix' id='name_prefix' value=''><%
					} 

						for(int i=0; i<names.length; i++)
						{
							if(names[i] != null)
							{
								out.println("<td  nowrap>") ;
									out.println(names[i] == null? "":names[i]);
								out.println("</td>") ;
							}
						}
%>
		<td>
						<%
						if(strNameSuffixAcceptYN.equals("Y"))
						{
							try{   
									String sql = null;
									sql="Select Name_Suffix,name_suffix_loc_lang from Mp_Name_Suffix where  eff_status='E' and "+ 
										  " trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) "+
										  " and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) order by 1";
									pstmt = con.prepareStatement(sql);
									rs = pstmt.executeQuery();

									out.println("<select onchange='assignSuffixValue();' name='name_suffix1' id='name_suffix1' onblur='putPatientName(this)' >") ; 
									out.println("<option value=''>&nbsp- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-&nbsp</option>");
									if(rs != null)
									{
										while (rs.next())
										{    %>      
											<option value="<%=rs.getString("Name_Suffix")%>"><%=rs.getString("Name_Suffix")%></option>
										<%}
									}
									out.println("</select>") ;
							}catch(Exception e) { 
								out.println(e.toString());
								e.printStackTrace();
							}
							finally
							{								
								if (pstmt != null) pstmt.close();
								if (rs != null) rs.close();
							}
							%><input type='hidden' name='name_suffix' id='name_suffix' value=''><%
						}
						%>                              
			</td>
		</tr>
		</table>
		--%>
		<!--
		Names Component included from Change pat details 12/7/2006
		-->
		<table border='0' tabindex=-1>
		<jsp:include page="../../eMP/jsp/PatNamesComp.jsp" flush="true"/>
		
		</table>
	<%
			String strServerDate = "";
			String sqlDate="select to_char(sysdate,'dd/mm/yyyy') from dual";
			pstmt = con.prepareStatement(sqlDate);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
			 strServerDate =rs.getString(1);
			}
			if (pstmt != null) pstmt.close();
			if (rs != null) rs.close();
	%>
	<table cellpadding=0 cellspacing=0 border=0 width='100%' tabindex=-1>
	 <tr><td colspan='8' class='white'></td></tr>
	 	<input type=hidden name='op_call' id='op_call' value="<%=op_call%>">
			<tr>
	        <%if(!function_id.equals("CHECK_IN_ACCMP_PERSON")){%>
			<td class=label width='20%'><fmt:message key="Common.birthPlace.label" bundle="${common_labels}"/></td>
			<td  class='FIELDS' nowrap width='306pt'>
			<input type="text" name="birth_place" id="birth_place" id = "dateofbirth" maxlength="15" size="15"  onblur='if(this.value != "" )searchBirthPlace(b_birth,birth_place);'  value = '' tabIndex='25'><input type='button' name='b_birth' id='b_birth' value='?' class='button' onclick='searchBirthPlace(this,birth_place)' >
			<input type="text" name="place_of_birth" id="place_of_birth" maxlength="30" size="20"  onfocus='CheckBirthPlace();' tabIndex='26' onblur='makeValidString(this);CheckBirthCode();' value="">
			</TD>
			
			<td class=LABEL  width='240pt'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
			<td   class='FIELDS' >

			<%}else{%> 		
			<td class=label width='200pt'>
			<fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
			<td  width='31%'  class='FIELDS' >

			<%}%>
	        <select name="sex" id="sex" onchange='checkPrefix()' tabIndex='27'>
			<option value=''>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
			<option value='M' ><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
			<option value='F' ><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
			<option value='U' ><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
			</select><img src='../../eCommon/images/mandatory.gif'></img>
			</td>
			<%if(function_id.equals("CHECK_IN_ACCMP_PERSON")){
				String reln_with_patient = request.getParameter("lodger_relation_code")== null?"":request.getParameter("lodger_relation_code");
			%>
			
			
			<td class='label' colspan='1'  nowrap width='240pt'><fmt:message key="eMP.relationshipwithpatient.label" bundle="${mp_labels}"/></td><td  class='FIELDS'>
			<select name='reln_with_patient' id='reln_with_patient' tabIndex='28'>
			<option value=''>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
				<%
					String sql ="select relationship_code, short_desc from mp_relationship_lang_vw where language_id = '"+locale+"' AND eff_status = 'E'  order by short_desc ";
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();
					while(rs.next())
					{
						if(checkForNull(rs.getString("relationship_code")).equals(reln_with_patient))
						{
						%>
						<option value="<%=checkForNull(rs.getString("relationship_code"))%>"  selected><%=rs.getString("short_desc")%> </option> 
						<%
						}
						else
						{
							%>
							<option value="<%=checkForNull(rs.getString("relationship_code"))%>" ><%=rs.getString("short_desc")%> </option> 
						<%}
					}
					if(!reln_with_patient.equals("")){%>
					<script>document.getElementById("reln_with_patient").disabled = true;</script>
				<%}}%>
			</select>
			<tr>
			<td Class = 'label'   ><fmt:message key="Common.age.label" bundle="${common_labels}"/></td>
			<td  class='FIELDS'  >
			<input type="text" name="b_age" id="b_age" maxlength="3" size="3" tabIndex='29' onKeyPress='return(ChkNumberInput(this,event,0))' onblur="dateCheck(this,'<%=strBodyFrame%>','<%=strSubmitFrame%>')">Y
            <input type="text" name="b_months" id="b_months" maxlength="2" size="2" tabIndex='30' onKeyPress='return(ChkNumberInput(this,event,0))'                              onblur="dateCheck(this,'<%=strBodyFrame%>','<%=strSubmitFrame%>')"> M
            <input type="text" name="b_days" id="b_days" maxlength="2" size="2"  onKeyPress='return(ChkNumberInput(this,event,0))' tabIndex='31' onblur="dateCheck(this,'<%=strBodyFrame%>','<%=strSubmitFrame%>')" >D
			</td> 
			<%if(function_id.equals("CHECK_IN_ACCMP_PERSON"))
			{%>
				<td colspan=2>
			<input type='button' class='button' name='contact_details' id='contact_details' value='<fmt:message key="Common.ContactDetails.label" bundle="${common_labels}"/>'  tabIndex='32' onclick='Modal_Contact_Details(this);' id = '' style=''>
			<input type='hidden' name='date_of_birth' id='date_of_birth' value=''>
			</td></td></tr>
			<%}else{%>
			<td class=LABEL ><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></td>
			<td  class='FIELDS'><input type="text" name="date_of_birth" id="date_of_birth" id = "dateofbirthdb" maxlength="10" size="8" tabIndex='32' onblur="makeValidString(this);dateCheck(this,'<%=strBodyFrame%>','<%=strSubmitFrame%>')" value = ''><img name= "dob" src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].date_of_birth.focus();return showCalendar('dateofbirthdb')"><img src='../../eCommon/images/mandatory.gif'></img>
			</td>			
		</tr>
		<%}%>
		<input type='hidden' name='ServerDate' id='ServerDate' value="<%=strServerDate%>">
		<tr><td colspan='8' class='white'></td></tr>
		</table>

			<%if(!function_id.equals("CHECK_IN_ACCMP_PERSON")){%>
			<table cellpadding=0 cellspacing=0 border=0 width='100%' tabindex=-1>
     		<tr>
			<td  class="label" width='20%' ><fmt:message key="Common.residency.label" bundle="${common_labels}"/>
			<td  class='FIELDS'>
			<table cellpadding=0 cellspacing=0 border=0 width='100%' tabindex=-1><tr><td class=oaborder nowrap width=24%>	
			<input type='radio' name='citizen_yn' id='citizen_yn' value='Y' tabIndex='33'  onclick='disable_Legal_If_Citzen(this)' checked><fmt:message key="Common.citizen.label" bundle="${common_labels}"/><input type='radio' name='citizen_yn' id='citizen_yn' value='N' onclick='disable_Legal_If_Citzen(this)'><fmt:message key="Common.noncitizen.label" bundle="${common_labels}"/></td><td class=label>&nbsp;</td>
         
			</table></td>
				
			<td class='label'  ><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
			<td  class='FIELDS' >
			<table cellpadding=0 cellspacing=0 border=0 width='100%' tabindex=-1><tr><td class=oaborder nowrap WIDTH='17%'><input type='radio' name='legal_yn' id='legal_yn' value="Y" checked disabled><fmt:message key="Common.legal.label" bundle="${common_labels}"/><input type='radio' name='legal_yn' id='legal_yn' value="N" tabIndex='34' disabled><fmt:message key="Common.illegal.label" bundle="${common_labels}"/></td><td class=label>&nbsp;</td>
			</table></td>	
			</tr>
				<tr>
			<td  class="label" ><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td><td  class='FIELDS' width='306pt'><input type='text' name='nationality_desc' id='nationality_desc' size='20' tabIndex='35' maxlength='20' value="<%=citizen_nationality_desc%>" onblur='if(this.value !="")searchCountry(nationality_id,nationality_desc);' ><input type='button' name='nationality_id' id='nationality_id' value='?' class='button' onclick='searchCountry(this,nationality_desc)' ><input type='hidden' name='nationality_code1' id='nationality_code1' value="<%=citizen_nationality_code%>"><input type='hidden' name='nationality_desc1' id='nationality_desc1' value="<%=citizen_nationality_desc%>"><img id='nat_gif_nat_gif' src='../../eCommon/images/mandatory.gif' ></img>
			</td>
			
			<input type=hidden name='dflt_nationality_code' id='dflt_nationality_code' value="<%=citizen_nationality_code%>">
			
			<input type=hidden name='dflt_nationality_desc' id='dflt_nationality_desc' value="<%=citizen_nationality_desc%>">
			<input type=hidden name='nat_gif_yn' id='nat_gif_yn' value='Y'>
			<input type=hidden name='eth_gif_yn' id='eth_gif_yn' value='Y'>
			
		 
		
		<td class="label"  width='240pt'><fmt:message key="Common.race.label" bundle="${common_labels}"/></td><td  class='FIELDS'>
			<select name="race_code" id="race_code"  tabIndex='36' onchange='loadEthnicSubGroup(this);' >
				<option value="" >-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
				<%
			
			String sql_ethnic="select RACE_CODE,LONG_DESC from mp_race_lang_vw where language_id = '"+locale+"' AND EFF_STATUS='E' order by 2";
			if(pstmt!=null) pstmt.close();
			if(rs!=null) rs.close();
			pstmt = con.prepareStatement(sql_ethnic);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
              race_code=rs.getString("RACE_CODE");
			  race_desc=rs.getString("LONG_DESC");
              
              if(default_race_code.equals(race_code))
				{
				  
				  temp = race_code;
                out.println("<option value=\""+race_code+"\" selected >"+race_desc+"</option>");
				}
				else
				{
                    
                    out.println("<option value=\""+race_code+"\">"+race_desc+"</option>");
				}
			}
			if (pstmt != null) pstmt.close();
			if (rs != null) rs.close();
	%>
		</select><input type='hidden' name='race_required_yn' id='race_required_yn' value='<%=race_required_yn%>'>
		<img src='../../eCommon/images/mandatory.gif' id='eth_gif' name='eth_gif' style='visibility:hidden'></img>
		<%
		if(race_required_yn.equals("Y"))
		{
			if(citizen_yn.equals("N") || citizen_yn.equals("")){%>
				<script>document.forms[0].eth_gif.style.visibility = 'hidden';</script>
			<%}else if(citizen_yn.equals("Y")){%>
				<script>document.forms[0].eth_gif.style.visibility = 'visible';</script>
			<%}
		}
		%>
		</td>
		</tr>
	<%if(op_call!=null && op_call.equals("OA") && !alcn_criteria_mp.equals("")){%>
	<tr>
	<%
		alcn_srl_no_sql="select srl_no from oa_clinic_schedule where clinic_code='"+clinic_code_mp+"' and trunc(clinic_date)=to_date('"+appt_date_mp+"','DD/MM/YYYY') and facility_id='"+facility_id_mp+"' and nvl(practitioner_id,'X')=nvl('"+pract_id_mp+"','X')  and nvl(schedule_status,'X')!='B'";
	
		try{
			stmt=con.createStatement();
			alcn_rs=stmt.executeQuery(alcn_srl_no_sql);
			if(alcn_rs!=null && alcn_rs.next()){
				alcn_srl_no=alcn_rs.getString("srl_no")==null?"":alcn_rs.getString("srl_no");
			}
		
		//alcn_sql="select stat_grp_desc,stat_grp_id from am_stat_group where stat_grp_id in(select alcn_catg_code from oa_clinic_schedule_dtl where facility_id = '"+facility_id_mp+"' and clinic_code ='"+clinic_code_mp+"' and srl_no="+alcn_srl_no+") order by stat_grp_desc";
		alcn_sql="select stat_grp_desc,stat_grp_id from am_stat_group where stat_grp_id in(select stat_grp_id from AM_STAT_GRP_DETAIL where MEMBER_ID='"+citizen_nationality_code+"')";
		if(alcn_rs!=null) alcn_rs.close();
		alcn_rs=stmt.executeQuery(alcn_sql);
		int resultCount=0;
	%>
	<td class='label'><fmt:message key="eOA.Allocation.label" bundle="${oa_labels}"/></td>
	<td  class='FIELDS'>
	<select name="pat_cat" id="pat_cat">
	<%	
			while(alcn_rs!=null && alcn_rs.next()){%>
				<option value="<%=alcn_rs.getString("stat_grp_id")%>" ><%=alcn_rs.getString("stat_grp_desc")%></option>
				<%
				resultCount++;
			}
		if(resultCount==0){%>
		<option value="*O" >Others</option>
		<%}
		}catch(Exception ex){
			ex.printStackTrace();
		}%>
		</select>
		</td>
		<td class='label'><%=citizen_nationality_code%></td><td class='label'><%=citizen_nationality_desc%></td>
		</tr>
	<%}%>
		<tr>
		<td class="label"  ><fmt:message key="eMP.ethnicity.label" bundle="${mp_labels}"/></td>
			<td   class='FIELDS'><Select name="ethnic_group" id="ethnic_group" tabIndex='37'>
            <Option value="">------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------</option>
			<%
				
		 // out.println("<script>alert('here');</script>");

			String sqlethinic = "select ethnic_group_code, long_desc from mp_ethnic_group_lang_vw where language_id = '"+locale+"' AND race_code ='"+temp+"' and eff_status='E' order by long_desc ";

								pstmt = con.prepareStatement(sqlethinic);
								rs = pstmt.executeQuery();	
								while (rs.next()) 
									{	
											out.println("<option value=\"" + rs.getString("ethnic_group_code") + "\">" + rs.getString("long_desc")+"</option>");
									}
									
									if (pstmt != null) pstmt.close();
			                        if (rs != null) rs.close();
				

			%>
            </select>
        	</td>
			<td class='label'>&nbsp;</td>
			<td class='fields'>
			<input type='button' class='button' style='width:150pt' name='contact_details' id='contact_details' value='<fmt:message key="Common.ContactDetails.label" bundle="${common_labels}"/>'  onclick='Modal_Contact_Details(this);' id = '' tabIndex='38'>
			</td>
			<%}%>

			<input type='hidden' name='Birth_place_code' id='Birth_place_code' value=''>
			<input type='hidden' name='citizen' id='citizen' value='Y'>
			<input type='hidden' name='legal' id='legal' value='Y'>
			
	</tr>
</table>
</td>
</tr>
</table>
<input type='hidden' name='change_address' id='change_address' value=''>
<input type='hidden' name='concat_address_hidden' id='concat_address_hidden' value=''>		
<input type='hidden' name='concat_NatIdDetails_hidden' id='concat_NatIdDetails_hidden' value=''>		
<input type='hidden' name='addr1_type' id='addr1_type' value=''>

<input type='hidden' name='addr_line1' id='addr_line1' value='' >
<input type='hidden' name='addr_line2' id='addr_line2' value='' >
<input type='hidden' name='addr_line3' id='addr_line3' value='' >
<input type='hidden' name='addr_line4' id='addr_line4' value='' >
<input type='hidden' name='res_town_code' id='res_town_code' value='' >
<input type='hidden' name='res_town_desc' id='res_town_desc' value='' >

<input type='hidden' name='res_area_code' id='res_area_code' value=''>
<input type='hidden' name='res_area_desc' id='res_area_desc' value=''>

<input type='hidden' name='postal_code' id='postal_code' value='' >	
<input type='hidden' name='region_code' id='region_code' value='' >	
<input type='hidden' name='region_desc' id='region_desc' value='' >	
<input type='hidden' name='country_code' id='country_code' value='' >
<input type='hidden' name='country_desc' id='country_desc' value='' >
<input type='hidden' name='contact1_name' id='contact1_name' value=''>
<input type='hidden' name='invalid1_yn' id='invalid1_yn' value=''>

<input type='hidden' name='addr2_type' id='addr2_type' value=''>

<input type='hidden' name='mail_addr_line1' id='mail_addr_line1' maxlength='30' value=''>
<input type='hidden' name='mail_addr_line2' id='mail_addr_line2' maxlength='30' value=''>
<input type='hidden' name='mail_addr_line3' id='mail_addr_line3' value=''  maxlength='30'>
<input type='hidden' name='mail_addr_line4' id='mail_addr_line4' value='' maxlength='30'>
<input type='hidden' name='mail_res_town_code' id='mail_res_town_code' value='' maxlength='6'>
<input type='hidden' name='mail_res_town_desc' id='mail_res_town_desc' value='' maxlength='6'>

<input type='hidden' name='mail_res_area_code' id='mail_res_area_code' value='' maxlength='6'>
<input type='hidden' name='mail_res_area_desc' id='mail_res_area_desc' value='' maxlength='6'>
<input type='hidden' name='mail_postal_code' id='mail_postal_code' value='' maxlength='8'>
<input type='hidden' name='mail_region_code' id='mail_region_code' value='' maxlength='8'>
<input type='hidden' name='mail_region_desc' id='mail_region_desc' value='' maxlength='8'>
<input type='hidden' name='mail_country_code' id='mail_country_code' value='' maxlength='4'>
<input type='hidden' name='mail_country_desc' id='mail_country_desc' value='' maxlength='4'>
<input type='hidden' name='m_postal_code_desc' id='m_postal_code_desc' value='' maxlength='4'>
<input type='hidden' name='r_postal_code_desc' id='r_postal_code_desc' value='' maxlength='4'>


<input type='hidden' name='contact2_name' id='contact2_name' value=''>
<input type='hidden' name='invalid2_yn' id='invalid2_yn' value=''>
<input type='hidden' name='contact1_no' id='contact1_no' value=''>
<input type='hidden' name='contact2_no' id='contact2_no' value=''>
<input type='hidden' name='email' id='email' value=''>
<input type='hidden' name='default_race_code' id='default_race_code' value="<%=default_race_code%>">
<input type='hidden' name='First_Name_Prompt' id='First_Name_Prompt' value="<%=strFirstNamePrompt%>">
<input type='hidden' name='Second_Name_Prompt' id='Second_Name_Prompt' value="<%=strSecondNamePrompt%>">
<input type='hidden' name='Third_Name_Prompt' id='Third_Name_Prompt' value="<%=strThirdNamePrompt%>">
<input type='hidden' name='Family_Name_Prompt' id='Family_Name_Prompt' value="<%=strFamilyNamePrompt%>">
<input type='hidden' name='Name_Suffix_Prompt' id='Name_Suffix_Prompt' value="<%=strNameSuffixPrompt%>">
<input type='hidden' name='Name_Prefix_Prompt' id='Name_Prefix_Prompt' value="<%=strNamePrefixPrompt%>">
<input type='hidden' name='race_yn' id='race_yn' value="<%=citizen_yn%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='op_call_check' id='op_call_check' value='<%=op_call%>'>
	

<% 
}
catch(Exception e){

	e.printStackTrace();
}
finally{
	if(con!=null)
      ConnectionManager.returnConnection(con,request);
}
%>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

