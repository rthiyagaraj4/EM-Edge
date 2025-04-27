<!DOCTYPE html>
<%@ page import="java.sql.Connection, java.sql.Statement, java.sql.PreparedStatement, java.sql.ResultSet, java.util.ArrayList, webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head><title><fmt:message key="Common.ContactDetails.label" bundle="${common_labels}"/></title>
<%@ include file="../../eMP/jsp/PatientAddressLegends.jsp"%>


 <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<Script language='javascript' src='../../eMP/js/PatientRegistration.js'></Script>
<Script language='javascript' src='../../eMP/js/PatientRegistration1.js'></Script>
<Script language='javascript' src='../../eMP/js/PatientRegistration2.js'></Script>
<Script language='javascript' src='../../eMP/js/PatientRegistration3.js'></Script>

<%
	  Connection con				= null;
	java.sql.Statement oth_stmt = null;
	java.sql.Statement stmt		= null;
	PreparedStatement pstmt		= null;
	ResultSet oth_rset			= null;
	ResultSet rs				= null;
	ResultSet prs				= null;
	Properties p		= (java.util.Properties) session.getValue("jdbc");
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String calling_from	= request.getParameter("calling_from"); 
	String readonly_yn	= request.getParameter("readonly_yn");
	String op_call_check= request.getParameter("op_call_check");
	if(op_call_check == null) op_call_check = "";
	String oa_contact_num_reqd_yn="";
	String oa_mob_num_req_yn="";
	String oa_rule_appl_yn="";

	if (calling_from == null) calling_from = "";
	if(readonly_yn == null) readonly_yn = "N";

	String readcheck		= "";
	String Site				= "";
	String sql				= "";
	
	if(readonly_yn.equals("Y")) readcheck = "readonly";
	
	ArrayList codes = null;
	ArrayList descs = null; 

	Object countrydesc[]	= null;
	Object countrycode[]	= null;

	String[] contact_col_names	= null;
	String[] contact_prompts	= null;
	String[] contact_fields		= null;
	
	con			= ConnectionManager.getConnection(request);
	oth_stmt	= con.createStatement();
	stmt		= con.createStatement();

	java.util.ArrayList contact_modes = new java.util.ArrayList();

	ArrayList contact_addr = fetchContactAddresses(con, out,"parent.parent.frames[1]",p) ;

    Site				= (String) contact_addr.get(0);
    contact_col_names	= (String[]) contact_addr.get(1);
    contact_prompts		= (String[]) contact_addr.get(2);
	
	//Below line commented for ML-MMOH-CRF-0860.2 
    contact_fields		= (String[]) contact_addr.get(3); 
    contact_addr		= null;
	
	//Below line added for this CRF ML-MMOH-CRF-0860.2
	Boolean increasedaddressLength = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INCREASED_ADDRESS_LINE_LENGTH");
	
	/*if(increasedaddressLength && contact_addr.size()==5){
		//nextofkin_contact_fields = (String[])contact_addr.get(4) ;
		contact_fields = (String[])contact_addr.get(4) ;
	}else{	
	    contact_fields		= (String[]) contact_addr.get(3);
	}
        contact_addr = null; */	
	//End ML-MMOH-CRF-0860.2	
	

	/* to get the array of nationality*/

	codes = new ArrayList();
	descs = new ArrayList();			
	
	try
	{
		stmt = con.createStatement();
		if(op_call_check!=null && !(op_call_check.equals(""))){
		String oa_sql="select CONTACT_NUM_REQD_YN, MOB_NUM_REQ_YN, RULE_APPL_YN from OA_param";
		if(rs!=null)rs.close();
		rs = stmt.executeQuery(oa_sql);
		if(rs!=null && rs.next()){
			oa_contact_num_reqd_yn=rs.getString("CONTACT_NUM_REQD_YN");
			if(oa_contact_num_reqd_yn==null)oa_contact_num_reqd_yn="";
			oa_mob_num_req_yn=rs.getString("MOB_NUM_REQ_YN");
			if(oa_mob_num_req_yn==null)oa_mob_num_req_yn="";
			oa_rule_appl_yn=rs.getString("RULE_APPL_YN");
			if(oa_rule_appl_yn==null)oa_rule_appl_yn="";
		}
		}
		if(rs!=null)rs.close();
		sql = "Select Country_Code,Long_Desc,long_name short_name from Mp_Country_lang_vw where language_id = '"+locale+"' AND eff_status='E' and trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) order by 2";
		
		rs = stmt.executeQuery(sql);
	
		String code = "";
		String desc = "";
	
		if(rs != null)
		while(rs.next())
		{
			code = rs.getString("Country_Code");
			desc = rs.getString("Long_Desc");

			codes.add(rs.getString("Country_Code"));
			descs.add(rs.getString("Long_Desc"));
		}

		countrycode  = codes.toArray();
		countrydesc  = descs.toArray();

		codes = null;
		descs = null;						
		String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eMP/js/RegPatReferral.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
	<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>

		function searchCountry(obj,target)
		{
			var retVal =    new String();
			var argumentArray  = new Array() ;
					var dataNameArray  = new Array() ;
					var dataValueArray = new Array() ;
					var dataTypeArray  = new Array() ;
					var locale=document.forms[0].locale.value;

					var tit="";				
					if(obj.name == "contry_code" )
					{
						
						if(target.name == 'nationality_desc'){
							tit=getLabel("Common.nationality.label","common");
						//tit="Nationality"
						sql="Select country_code code,long_desc description from Mp_Country_lang_vw where language_id = '"+locale+"' AND eff_status='E' and  upper(country_code) like upper(?) and upper(long_desc) like upper(?)";
						}
						else{
							tit=getLabel("Common.country.label","common");
							
							
							sql="Select country_code code,long_name description from Mp_Country_lang_vw where language_id = '"+locale+"' AND eff_status='E' and upper(country_code) like upper(?) and upper(long_name) like upper(?)";
						}
					  }
					argumentArray[0] =sql;
					argumentArray[1] = dataNameArray ;
					argumentArray[2] = dataValueArray ;
					argumentArray[3] = dataTypeArray ;
					argumentArray[4] = "1,2";
					argumentArray[5] = target.value;
					argumentArray[6] = DESC_LINK  ;
					argumentArray[7] = DESC_CODE ;

					retVal = await CommonLookup( tit, argumentArray );
					if(!(retVal== null && retVal== "" ))
					{
						var ret1=unescape(retVal);
						arr=ret1.split(",");
						target.value=arr[1];
						if(target.name == 'nationality_desc')
						   document.forms[0].nationality_code.value= arr[0];
						else if(target.name == 'r_country_desc')
						  document.forms[0].r_country_code.value= arr[0];
							
						else if(target.name == 'm_country_desc')
							document.forms[0].m_country_code.value= arr[0];
						else if(target.name == 'first_country_desc')
							document.forms[0].first_country_code.value= arr[0];
						else if(target.name == 'next_country_desc')
							document.forms[0].next_country_code.value= arr[0];
						else if(target.name == 'empyr_country_desc')
							document.forms[0].empyr_country_code.value= arr[0];
					}
					if(retVal==null || retVal=="")
					{
						target.value='';
						target.focus();
					}
				}	
	  
				function close_me()
				{
					if(document.forms[0].r_addr_line1)
					{
						if(document.forms[0].r_addr_line1.value != "")
							document.forms[0].addr1_line1.value		= document.forms[0].r_addr_line1.value; 
						else document.forms[0].addr1_line1.value	="";
					}
					if(document.forms[0].r_addr_line2)
						document.forms[0].addr1_line2.value		= document.forms[0].r_addr_line2.value; 
					else
					{
						document.forms[0].addr1_line2.value	= "";
					}
					if(document.forms[0].r_addr_line3)
						document.forms[0].addr1_line3.value	= document.forms[0].r_addr_line3.value; 
					else
					{
						document.forms[0].addr1_line3.value	= "";
					}
					if(document.forms[0].r_addr_line4)
						document.forms[0].addr1_line4.value	= document.forms[0].r_addr_line4.value;
					else
					{
						document.forms[0].addr1_line4.value = "";
					}
					if(document.forms[0].r_town_code != null)
					{	
						if(document.forms[0].r_town_code.value != "")
							document.forms[0].res_town_code.value= document.forms[0].r_town_code.value; 
						if(document.forms[0].r_town_code == null)
						{
							document.forms[0].r_town.value = "";
							document.forms[0].r_town_code.value = "";
							document.forms[0].res_town_code.value = "";
						}
					}
					if(document.forms[0].r_area_code != null)
					{
						if(document.forms[0].r_area_code.value != "")
							document.forms[0].res_area_code.value	= document.forms[0].r_area.value; 
						else
						{
							document.forms[0].r_area.value = "";
							document.forms[0].res_area_code.value = "";
						}
					}
					if(document.forms[0].r_postal_code)
					{
						if(document.forms[0].r_postal_code.value != "")
						document.forms[0].postal1_code.value	= document.forms[0].r_postal_code.value ;
						else
						{
							document.forms[0].postal1_code.value ="";
							document.forms[0].r_postal_code.value="";
							document.forms[0].postal1_code.value		="";
						}
					}
					
					if(document.forms[0].r_region_code)
					{
						if(document.forms[0].r_region_code.value!="")
							document.forms[0].region_code1.value= document.forms[0].r_region.value;
						else
						{
							document.forms[0].r_region.value="";
							document.forms[0].r_region_code.value = "";
							document.forms[0].region_code1.value= "";
						}
					}
					if(document.forms[0].r_country_code)
					{
						if(document.forms[0].r_country_code.value != "")
							document.forms[0].country1_code.value = document.forms[0].r_country_code.value;
						else
						{
							document.forms[0].r_country_desc.value	= "";
							document.forms[0].r_country_code.value	= "";
							document.forms[0].country1_code.value	= "";
						}
					}
					if(document.forms[0].m_addr_line1)
						document.forms[0].addr2_line1.value = document.forms[0].m_addr_line1.value;   
					else document.forms[0].addr2_line1.value = "";
					if(document.forms[0].m_addr_line2)
					document.forms[0].addr2_line2.value = document.forms[0].m_addr_line2.value;  
					else document.forms[0].addr2_line2.value = "";
					if(document.forms[0].m_addr_line3)
					document.forms[0].addr2_line3.value	= document.forms[0].m_addr_line3.value;   
					else document.forms[0].addr2_line3.value = "";
					if(document.forms[0].m_addr_line4)
						document.forms[0].addr2_line4.value = document.forms[0].m_addr_line4.value;   
					else document.forms[0].addr2_line4.value = "";
					if(document.forms[0].m_town_code)
					{
						if(document.forms[0].m_town_code.value != "")
							document.forms[0].res2_town_code.value = document.forms[0].m_town_code.value; 
						else
						{
							document.forms[0].m_town_code.value		= "";
							document.forms[0].m_town.value			= "";
							document.forms[0].res2_town_code.value	= "";
						}
					}
					if(document.forms[0].m_area_code != null)
					{
						if(document.forms[0].m_area_code.value != "")
							document.forms[0].res2_area_code.value	= document.forms[0].m_area_code.value; 
						else
						{
							document.forms[0].m_area_code.value		= "";
							document.forms[0].m_area.value			= "";
							document.forms[0].res2_area_code.value	= "";
						}
					}
					if(document.forms[0].m_postal_code)
						document.forms[0].postal2_code.value = document.forms[0].m_postal_code.value;
					else
					{
						if(document.forms[0].m_postal_code)
							document.forms[0].m_postal_code.value = "";
						if(document.forms[0].postal2_code)
							document.forms[0].postal2_code.value = "";
					}
					if(document.forms[0].m_region_code)
					{
						if(document.forms[0].m_region_code.value != "")
							document.forms[0].region2_code.value	= document.forms[0].m_region_code.value; 
						else
						{
							document.forms[0].m_region_code.value	= "";
							document.forms[0].m_region.value		= "";
							document.forms[0].region2_code.value	= "";
						}
					}
					if(document.forms[0].m_country_code)
						document.forms[0].country2_code.value = document.forms[0].m_country_code.value;
					else
					{
						document.forms[0].m_country_code.value	= "";
						document.forms[0].m_country_desc.value	= "";
						document.forms[0].country2_code.value	= "";
					}

					if(document.forms[0].txtPrimResNo)
						document.forms[0].contact1_no.value = document.forms[0].txtPrimResNo.value;
					else 
						document.forms[0].contact1_no.value = "";
					if(document.forms[0].txtOtherResNo)
						document.forms[0].contact2_no.value	= document.forms[0].txtOtherResNo.value;
					else 
						document.forms[0].contact2_no.value = "";
					if(document.forms[0].txtEmail)
						document.forms[0].email.value = document.forms[0].txtEmail.value;
					else
						document.forms[0].email.value = "";
					
					if(document.forms[0].r_country_desc)
					{
						 if(document.forms[0].r_country_desc.value != "")
							document.forms[0].country1_desc.value = document.forms[0].r_country_desc.value;
						else
						{
							document.forms[0].r_country_desc.value	= "";
							document.forms[0].r_country_code.value	= "";
							document.forms[0].country1_desc.value	= "";
						}
					}
					if(document.forms[0].m_country_desc)
					{
						if(document.forms[0].m_country_desc.value != "")
							document.forms[0].country2_desc.value = document.forms[0].m_country_desc.value;
						else
						{
							document.forms[0].m_country_code.value	= "";
							document.forms[0].m_country_code.value	= "";
							document.forms[0].country2_desc.value	= "";
						}
					}
					
					//the symbol used to concatenate is ALT 15

				var addr1_line1 = "";
				var addr1_line2 = "";
				var addr1_line3 = "";
				var addr1_line4 = "";

				var addr2_line1 = "";
				var addr2_line2 = "";
				var addr2_line3 = "";
				var addr2_line4 = "";
		
				var r_town_code_value = "";
				var r_town_desc_value = "";
				var m_town_code_value = "";
				var m_town_desc_value = "";

				var r_area_code_value = "";
				var r_area_desc_value = "";
				var m_area_code_value = "";
				var m_area_desc_value = "";

				var r_region_code_value = "";
				var r_region_desc_value = "";
				var m_region_code_value = "";
				var m_region_desc_value = "";

				var postal1_code = "";
				var postal2_code = "";

				if(document.forms[0].addr1_line1!=null)
					addr1_line1 = document.forms[0].addr1_line1.value;
				if(document.forms[0].addr1_line2!=null)
					addr1_line2 = document.forms[0].addr1_line2.value;
				if(document.forms[0].addr1_line3!=null)
					addr1_line3 = document.forms[0].addr1_line3.value;
				if(document.forms[0].addr1_line4!=null)
					addr1_line4 = document.forms[0].addr1_line4.value;
				
				if(document.forms[0].addr2_line1!=null)
					addr2_line1 = document.forms[0].addr2_line1.value;
				if(document.forms[0].addr2_line2!=null)
					addr2_line2 = document.forms[0].addr2_line2.value;
				if(document.forms[0].addr2_line3!=null)
					addr2_line3 = document.forms[0].addr2_line3.value;
				if(document.forms[0].addr2_line4!=null)
					addr2_line4 = document.forms[0].addr2_line4.value;
				
				if(document.forms[0].r_town_code!=null && document.forms[0].r_town != null) 
				{
					r_town_code_value = document.forms[0].r_town.value;
					r_town_desc_value = document.forms[0].r_town_code.value;
				}
				if(document.forms[0].m_town_code!=null && document.forms[0].m_town != null) 
				{
					m_town_code_value = document.forms[0].m_town.value;
					m_town_desc_value = document.forms[0].m_town_code.value;
				}
				if(document.forms[0].r_area_code!=null && document.forms[0].r_area != null) 
				{
					r_area_code_value = document.forms[0].r_area.value;
					r_area_desc_value = document.forms[0].r_area_code.value;
				}
				if(document.forms[0].m_area_code!=null && document.forms[0].m_area != null) 
				{
					m_area_code_value = document.forms[0].m_area.value;
					m_area_desc_value = document.forms[0].m_area_code.value;
				}
				if(document.forms[0].r_region_code!=null && document.forms[0].r_region!=null)
				{
					r_region_code_value = document.forms[0].r_region.value;
					r_region_desc_value = document.forms[0].r_region_code.value;
				}
				if(document.forms[0].m_region_code!=null && document.forms[0].m_region!=null) 
				{
					m_region_code_value = document.forms[0].m_region.value;
					m_region_desc_value = document.forms[0].m_region_code.value;
				}
				if(document.forms[0].postal1_code!=null)
					postal1_code = document.forms[0].postal1_code.value;
				if(document.forms[0].postal2_code!=null)
					postal2_code = document.forms[0].postal2_code.value;
				var r_postal_code1="";
				var m_postal_code1="";
				if(document.forms[0].r_postal_code1!=null)
					r_postal_code1 = document.forms[0].r_postal_code1.value;
				if(document.forms[0].m_postal_code1!=null)
					m_postal_code1 = document.forms[0].m_postal_code1.value;

			var concat_vals = document.forms[0].addr1_type.value +"^^"
			+addr1_line1 +"^^"
			+addr1_line2 +"^^"
			+addr1_line3 +"^^"
			+addr1_line4 +"^^"				 
			+r_town_code_value +"^^"
			+r_area_code_value +"^^"
			+postal1_code +"^^"  
			+r_region_code_value +"^^"
			+document.forms[0].r_country_code.value	+"^^"  
			+document.forms[0].contact1_name.value	+"^^"   
			+document.forms[0].invalid1_yn.value +"^^"   
			+document.forms[0].addr2_type.value	+"^^"   
			+addr2_line1 +"^^"   
			+addr2_line2 +"^^"   
			+addr2_line3 +"^^"   
			+addr2_line4 +"^^"   
			+m_town_code_value +"^^"
			+m_area_code_value +"^^"		
			+postal2_code +"^^"  
			+m_region_code_value +"^^"
			+document.forms[0].m_country_code.value	+"^^"  
			+document.forms[0].contact2_name.value +"^^" 
			+document.forms[0].invalid2_yn.value +"^^"
			+document.forms[0].contact1_no.value +"^^"
			+document.forms[0].contact2_no.value +"^^"
			+document.forms[0].email.value +"^^"
			+r_town_desc_value +"^^"
			+r_area_desc_value +"^^"
			+r_region_desc_value +"^^"
			+m_town_desc_value +"^^"
			+m_area_desc_value +"^^"
			+m_region_desc_value +"^^"
			+document.forms[0].country1_desc.value +"^^"
			+document.forms[0].country2_desc.value +"^^"
			+r_postal_code1+"^^"
			+m_postal_code1;

			window.close();	
			window.returnValue =concat_vals;
		}

		/********************************************************/
		function populateContactdetails()
		{
			
			
			var concat_vals=parent.window.dialogArguments;
			if(concat_vals == null || concat_vals == 'null')
			{
				concat_vals='';
			}
			
			var arr_concat_vals=concat_vals.split("^^");
			var change = unescape(arr_concat_vals[36]);
					
			if(arr_concat_vals[0])
				document.forms[0].addr1_type.value	= unescape(arr_concat_vals[0]);      
			if(arr_concat_vals[1])
				document.forms[0].addr1_line1.value	= unescape(arr_concat_vals[1]); 
			if(arr_concat_vals[2])
				document.forms[0].addr1_line2.value	= unescape(arr_concat_vals[2]); 
			if(arr_concat_vals[3])
				document.forms[0].addr1_line3.value	= unescape(arr_concat_vals[3]); 
			if(arr_concat_vals[4])
				document.forms[0].addr1_line4.value	= unescape(arr_concat_vals[4])
			if(arr_concat_vals[5])
			{
				
				document.forms[0].r_town.value			= unescape(arr_concat_vals[28]);
				document.forms[0].res_town_code.value	= unescape(arr_concat_vals[5]);
				
			}
			if(arr_concat_vals[6])
			{
				document.forms[0].r_area.value			= unescape(arr_concat_vals[6]);
				document.forms[0].res_area_code.value	= unescape(arr_concat_vals[27]);
			}
			
			if(arr_concat_vals[7])
				document.forms[0].postal1_code.value	= unescape(arr_concat_vals[7]);
			if(arr_concat_vals[8])
				document.forms[0].r_region.value		= unescape(arr_concat_vals[8]);
			
			if(arr_concat_vals[9])
			{
				document.forms[0].r_country_code.value		= 
				unescape(arr_concat_vals[9]);       
			}
			if(arr_concat_vals[10])
				document.forms[0].contact1_name.value	= unescape(arr_concat_vals[10]);
			if(arr_concat_vals[11])
				document.forms[0].invalid1_yn.value		= unescape(arr_concat_vals[11]);
			if(arr_concat_vals[12])
				document.forms[0].addr2_type.value		= unescape(arr_concat_vals[12]);       
			if(arr_concat_vals[13])
				document.forms[0].addr2_line1.value		= unescape(arr_concat_vals[13]);   
			if(arr_concat_vals[14])
				document.forms[0].addr2_line2.value		= unescape(arr_concat_vals[14]);  
			if(arr_concat_vals[15])
				document.forms[0].addr2_line3.value		= unescape(arr_concat_vals[15]);   
			if(arr_concat_vals[16])
				document.forms[0].addr2_line4.value		= unescape(arr_concat_vals[16]);   
			if(arr_concat_vals[17])
			{
				document.forms[0].m_town.value	= unescape(arr_concat_vals[30]);
				document.forms[0].res2_town_code.value	= unescape(arr_concat_vals[17]);
			}
			if(arr_concat_vals[18])
			{
				document.forms[0].m_area.value			= unescape(arr_concat_vals[31]);
				document.forms[0].res2_area_code.value	= unescape(arr_concat_vals[18]);
			}
			if(arr_concat_vals[19])
				document.forms[0].postal2_code.value	= unescape(arr_concat_vals[19]);
			if(arr_concat_vals[20])
				document.forms[0].region_code1.value	= unescape(arr_concat_vals[20]);
			if(arr_concat_vals[21])
				document.forms[0].country2_code.value	= unescape(arr_concat_vals[21]);
			if(arr_concat_vals[22])
				document.forms[0].contact2_name.value	= unescape(arr_concat_vals[22]);
			if(arr_concat_vals[23])
				document.forms[0].invalid2_yn.value		= unescape(arr_concat_vals[23]); 
			if(arr_concat_vals[24])
				document.forms[0].txtPrimResNo.value	= unescape(arr_concat_vals[24]); 
			if(arr_concat_vals[25])
				document.forms[0].txtOtherResNo.value	= unescape(arr_concat_vals[25]); 
			if(arr_concat_vals[26])
				document.forms[0].txtEmail.value		= unescape(arr_concat_vals[26]); 

			var readonly_yn = document.forms[0].readonly_yn.value;
			if(readonly_yn=="Y")
			{
				if(document.forms[0].r_addr_line1!=null && document.forms[0].m_addr_line1!=null)
				{
					document.forms[0].r_addr_line1.disabled = true;
					document.forms[0].m_addr_line1.disabled = true;
				}
				if(document.forms[0].r_addr_line2!=null && document.forms[0].m_addr_line2!=null)
				{
					document.forms[0].r_addr_line2.disabled = true;
					document.forms[0].m_addr_line2.disabled = true;
				}
				if(document.forms[0].r_addr_line3!=null && document.forms[0].m_addr_line3!=null)
				{
					document.forms[0].r_addr_line3.disabled = true;
					document.forms[0].m_addr_line3.disabled = true;
				}
				if(document.forms[0].r_addr_line4!=null && document.forms[0].m_addr_line4 != null)
				{
					document.forms[0].r_addr_line4.disabled = true;
					document.forms[0].m_addr_line4.disabled = true;
				}
				if(document.forms[0].r_town_code!=null && document.forms[0].m_town_code != null)
				{
					document.forms[0].r_town_code.disabled = true;
					document.forms[0].m_town_code.disabled = true;
				}
				if(document.forms[0].r_area_code!=null && document.forms[0].m_area_code != null)
				{
					document.forms[0].r_area_code.disabled	= true;
					document.forms[0].m_area_code.disabled	= true;
					document.forms[0].area_code.disabled	= true;
				}
				if(document.forms[0].r_region_code!=null && document.forms[0].m_region_code != null)
				{
					document.forms[0].r_region_code.disabled	= true;
					document.forms[0].m_region_code.disabled	= true;
					document.forms[0].region_code.disabled		= true;
				}
				if(document.forms[0].r_postal_code1 != null && document.forms[0].m_postal_code1 != null)
				{
					document.forms[0].r_postal_code1.disabled = true;
					document.forms[0].m_postal_code1.disabled = true;
					document.forms[0].postal_code.disabled = true;
				}
				if(document.forms[0].r_country_desc != null)
					document.forms[0].r_country_desc.disabled = true;
				if(document.forms[0].m_country_desc != null)
					document.forms[0].m_country_desc.disabled = true;
				if(document.forms[0].txtPrimResNo != null)
					document.forms[0].txtPrimResNo.disabled = true;
				if(document.forms[0].txtOtherResNo != null)
					document.forms[0].txtOtherResNo.disabled = true;
				if(document.forms[0].txtEmail != null)
					document.forms[0].txtEmail.disabled = true;
				if(document.getElementById("copydet") != null)
					document.getElementById("copydet").style.visibility = 'hidden';

			}

			//////////////////////////////////////////////////////////////////

			var addr1_type	= unescape(arr_concat_vals[0]);	//addr1_type,          
			var addr11		= unescape(arr_concat_vals[1]);	//  addr1_line1,         
			var addr12		= unescape(arr_concat_vals[2]);	//  addr1_line2,         
			var addr13		= unescape(arr_concat_vals[3]);	// addr1_line3,         
			var addr14		= unescape(arr_concat_vals[4]);	//  addr1_line4,         
			var addr15		= unescape(arr_concat_vals[5]);	//  town_code,       
			var addr16		= unescape(arr_concat_vals[6]);	//  area_code,     
			var addr17		= unescape(arr_concat_vals[7]);	//  postal    
			var addr18		= unescape(arr_concat_vals[8]);	//  region
			var addr19		= unescape(arr_concat_vals[9]);	// country
					 
			if(document.forms[0].r_addr_line1)
				if(addr11)
					document.forms[0].r_addr_line1.value = addr11;
			if(document.forms[0].r_addr_line2)
				if(addr12)
					document.forms[0].r_addr_line2.value = addr12;
			if(document.forms[0].r_addr_line3)
				if(addr13)
					document.forms[0].r_addr_line3.value = addr13;
			if(document.forms[0].r_addr_line4)
				if(addr14)
					document.forms[0].r_addr_line4.value = addr14;
			if(document.forms[0].r_town_code)
				if(addr15)
				{
					document.forms[0].r_town.value = unescape(arr_concat_vals[5]);
					document.forms[0].r_town_code.value = unescape(arr_concat_vals[28]); 
				
				}
			if(document.forms[0].r_area_code)
				if(addr16)
					document.forms[0].r_area_code.value = unescape(arr_concat_vals[29]); 
			if(document.forms[0].r_postal_code1)
			{
				if(addr17)
				{
					document.forms[0].r_postal_code.value = addr17;
					//document.forms[0].r_postal_code1.value = addr17;
					document.forms[0].r_postal_code1.value = unescape(arr_concat_vals[36]);
				}
			}
			if(document.forms[0].r_region_code)
				if(addr18)
					document.forms[0].r_region_code.value = unescape(arr_concat_vals[30]); 
			if(document.forms[0].r_country_code)
				if(addr19)
					document.forms[0].r_country_code.value = addr19;
		
			///////////////////////////////////////////////////////////
		
			var addr21	= unescape(arr_concat_vals[13]);	//addr2_line1
			var addr22	= unescape(arr_concat_vals[14]);	//addr2_line2
			var addr23	= unescape(arr_concat_vals[15]);	//addr2_line3
			var addr24	= unescape(arr_concat_vals[16]);	//addr2_line4
			var addr25	= unescape(arr_concat_vals[17]);	//town
			var addr26	= unescape(arr_concat_vals[18]);	//area
			var addr27	= unescape(arr_concat_vals[19]);	//postal
			var addr28	= unescape(arr_concat_vals[20]);	//region
			var addr29	= unescape(arr_concat_vals[21]);	//country

			var countrydesc1	= unescape(arr_concat_vals[34]);
			var countrydesc2	= unescape(arr_concat_vals[35]); 

			if(document.forms[0].m_addr_line1)
				if(addr21)
					document.forms[0].m_addr_line1.value = addr21;
			if(document.forms[0].m_addr_line2)
				if(addr22)
					document.forms[0].m_addr_line2.value = addr22;
			if(document.forms[0].m_addr_line3)
				if(addr23)
					document.forms[0].m_addr_line3.value = addr23;
			if(document.forms[0].m_addr_line4)
				if(addr24)
					document.forms[0].m_addr_line4.value = addr24;
			if(document.forms[0].m_town_code)
				if(addr25)
				{
					document.forms[0].m_town_code.value = unescape(arr_concat_vals[31]);
					document.forms[0].m_town.value = unescape(arr_concat_vals[17]);
				}
			if(document.forms[0].m_area_code)
				if(addr26)
				{
					document.forms[0].m_area_code.value = unescape(arr_concat_vals[32]);
					document.forms[0].m_area.value = unescape(arr_concat_vals[18]);
				}
			if(document.forms[0].m_postal_code){
				if(addr27)
				{
					document.forms[0].m_postal_code.value = addr27;
					//document.forms[0].m_postal_code1.value = addr27;
					document.forms[0].m_postal_code1.value = unescape(arr_concat_vals[37]);
				}
					}
			if(document.forms[0].m_region_code)
				if(addr28)
				{
					document.forms[0].m_region_code.value = unescape(arr_concat_vals[33]);
					document.forms[0].m_region.value = unescape(arr_concat_vals[20]);
				}
			if(document.forms[0].m_country_code)
				if(addr29)
					document.forms[0].m_country_code.value = addr29;
			if(document.forms[0].r_country_desc)
				if(countrydesc1)
					document.forms[0].r_country_desc.value = countrydesc1;
			if(document.forms[0].m_country_code)
				if(countrydesc2)
					document.forms[0].m_country_desc.value = countrydesc2;
		}
	</script>
</head>
<body onLoad='populateContactdetails()'onKeyDown='lockKey();' >
	<form name='Contact_Details_form' id='Contact_Details_form' method='post' action='' target='messageFrame'>
		<input type='hidden' name='readonly_yn' id='readonly_yn' value="<%=readonly_yn%>">
		<!-- <table width='100%' cellpadding='0' cellspacing='0' border =0>
			<tr>
				<td align='left' class='BODYCOLORFILLED' width='1%'>&nbsp;</td>
				<td width='65%' align='center' class='BODYCOLORFILLED' valign='top'> -->
					<table  width='90%'cellpadding='0' cellspacing='0' border='0' height='100%' align='center'>
						<tr>
							<td class='COLUMNHEADER' width='15%'>&nbsp;</td>
							<td align='left' width='35%' class='COLUMNHEADER'><fmt:message key="eMO.ApplicantAddress.label" bundle="${mo_labels}"/></td>
							<td align='left' width='50%' colspan='2' class='COLUMNHEADER'><fmt:message key="eMO.EmbalmAddress.label" bundle="${mo_labels}"/></td>
						</tr>
						<%
						int num		= 42;
						int num2	= 51;
						
						StringBuffer sb = new StringBuffer();
						StringBuffer sbap = new StringBuffer();
						StringBuffer sbar = new StringBuffer();
						StringBuffer sb1 = new StringBuffer();
						StringBuffer sb2 = new StringBuffer();
						StringBuffer sb3 = new StringBuffer();
						StringBuffer sb4 = new StringBuffer();
						
						for(int i=0;i<contact_col_names.length; i++)
						{
						
						    
							if(	contact_prompts[i]!=null)
							{
								num = num+1;
								num2 = num2+1;
								String number = String.valueOf(num);
								String number1 = String.valueOf(num2);								
								out.println("<tr>") ;
								out.println("<td  class='label'  nowrap>"+contact_prompts[i]+"&nbsp;&nbsp;</td>") ;
								String val  = contact_fields[i] ;
								 
								sb1.append(val);
								
								if(sb1.indexOf("@")!=-1) {
									sb1 = sb1.replace(sb1.indexOf("@"),sb1.indexOf("@")+1,number);
								}
								sb3=sb1;	
							
								if(sb3.indexOf("@")!=-1) {
									sb3 = sb3.replace(sb3.indexOf("@"),sb3.indexOf("@")+1,number);
								}	
								
								val = sb3.toString();								
								out.println("<td class='fields'  >"+val+"</td>");
								val = contact_fields[i] ;
								 
								sb.append(val);
								int j = 0 ;
								int j1 = 0 ;
								String old_val = "";
								String new_val = "" ;
								
								if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt"))
								{
									old_val = "r_addr_line1";
									new_val = "m_addr_line1";
								}
								else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt"))
								{
									old_val = "r_addr_line2";
									new_val = "m_addr_line2";
								}
								else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt"))
								{
									old_val = "r_addr_line3";
									new_val = "m_addr_line3";
								}
								else if(contact_col_names[i].equalsIgnoreCase("addr_line4_prompt"))
								{
									old_val = "r_addr_line4";
									new_val = "m_addr_line4";
								}
								else if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
								{
									old_val = "r_area_code";
									new_val = "m_area_code";
								}
								else if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
								{
									old_val = "r_town_code";
									new_val = "m_town_code";
								}
								else if(contact_col_names[i].equalsIgnoreCase("postal_code_prompt"))
								{
									old_val = "r_postal_code";
									new_val = "m_postal_code";
								}
								else if(contact_col_names[i].equalsIgnoreCase("region_prompt"))
								{
									old_val = "r_region_code";
									new_val = "m_region_code";
								}
				
								while(val.indexOf(old_val) != -1)
								{
									j = val.indexOf(old_val,j);
									sb = sb.replace(j,(j+old_val.length()),new_val);
									val = sb.toString();
								}
								if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
								{
									sbap.append(val);
									while(val.indexOf("r_postal_code") != -1)
									{
										j1 = val.indexOf("r_postal_code",j1) ;
										sbap = sbap.replace(j1,(j1+"r_postal_code".length()),"m_postal_code");
										val = sbap.toString();
								
									}
								}
								if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
								{
									j1 = 0;
									sbar.append(val);
									while(val.indexOf("r_postal_code") != -1)
									{
										
										j1 = val.indexOf("r_postal_code",j1) ;
										
										sbar = sbar.replace(j1,(j1+"r_postal_code".length()),"m_postal_code");
										val = sbar.toString();
										
									}
								}
								sb2.append(val);			
								
								if(sb2.indexOf("@")!=-1) {
									sb2 = sb2.replace(sb2.indexOf("@"),sb2.indexOf("@")+1,number1);
								}
								sb4=sb2;
				
								if(sb4.indexOf("@")!=-1) {
									sb4 = sb4.replace(sb4.indexOf("@"),sb4.indexOf("@")+1,number1);
								}
								
			    				val = sb4.toString();
								
								if(i == 0)
								{
									
									out.println("<td class='fields' colspan='2'>"+val+"<a id='copydet' name='copydet' href='javascript:copyDetails(4)'>&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage( pageContext,"eMO.CopyApplicantAddress.label","mo_labels")+"</a> </td>");
								}
								else
								{
									out.println("<td class='fields' colspan='2' >"+val+"</td>");
								}
								out.println("</tr>");
							}
							sbar.setLength(0);
							sbap.setLength(0);
							sb.setLength(0);
							sb1.setLength(0);
							sb2.setLength(0);
						}
						%>
						<tr>
							<td  class='label'><fmt:message key="Common.country.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
							<td class='fields'><input type='text' name='r_country_desc' id='r_country_desc'                       size='15' maxlength='15' onblur='if(this.value !="")searchCountry(contry_code[0],r_country_desc);'  tabindex='51' value=''><input type='button' name='contry_code' id='contry_code' value='?' class='button' onclick='searchCountry(this,r_country_desc)' tabindex='51'>
							<input type='hidden' name='r_country_code' id='r_country_code' value=''>
							</td>
							<td class='fields'><input type='text' name='m_country_desc' id='m_country_desc'        size='15' maxlength='15' onblur='if(this.value !="")searchCountry(contry_code[0],m_country_desc);'  tabindex='60'><input type='button' name='contry_code' id='contry_code' value='?' class='button' onclick='searchCountry(this,m_country_desc)' tabindex='60'>
							<input type='hidden' name='m_country_code' id='m_country_code' value=''>
							</td>
						</tr>
						<tr>
							<td class='COLUMNHEADER' width='15%'>&nbsp;</td>
							<td align='left' class='COLUMNHEADER' width='35%'><fmt:message key="eMP.ContactModes.label" bundle="${mp_labels}"/></td>
							<td class='COLUMNHEADER' width='50%' colspan='2'>&nbsp;</td>
						</tr>
						<%
						String psql = "select short_desc from mp_contact_mode_lang_vw where language_id = '"+locale+"' AND contact_mode in ('PRN','ORN') and eff_status = 'E' order by contact_mode desc";
						pstmt = con.prepareStatement(psql);
						prs = pstmt.executeQuery();
						if(prs!=null ) 
						{
							while(prs.next())
							{				
								contact_modes.add(prs.getString(1)==null?"":prs.getString(1));
							}
						}	
						%>
						<tr>
						<% 
						int lth = contact_modes.size();	
						if(lth > 0)
						{	
							if((String)contact_modes.get(0)!="")
							{			
								%>
								<td class='label' nowrap ><%=(String)contact_modes.get(0)%> &nbsp;&nbsp;</td>	<td><input type='text' name='txtPrimResNo' id='txtPrimResNo' size='20' maxlength='20' tabindex='61'><%if( oa_contact_num_reqd_yn.equals("Y") && op_call_check.equals("OA") ){%><img src='../../eCommon/images/mandatory.gif'></img><%}%> </td>
								<%
							}
							if(lth > 1)
							{
								if((String)contact_modes.get(1) != "") 
								{ 
									%>				
									<td class='label' nowrap ><%=(String)contact_modes.get(1)%> &nbsp;&nbsp;<span class='fields'><input type='text' name='txtOtherResNo' id='txtOtherResNo' size='20' maxlength='20' tabindex='62'><%if( (oa_mob_num_req_yn.equals("Y")&& oa_rule_appl_yn.equals("Y")) && op_call_check.equals("OA")){%><img src='../../eCommon/images/mandatory.gif'></img><%}%></span></td>
									<%
								}
							}
							else
							{
								%><td class='label' colspan=2>&nbsp;</td><%       
							} 
						}
						%>
						</tr>
						<tr>
							<td class='label' nowrap ><fmt:message key="Common.email.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
							<td colspan='2' class='fields'><input type='text' name='txtEmail' id='txtEmail' size='50' maxlength='50' tabindex='63'></td>
						</tr>
						<tr>
						  <td colspan='2'>&nbsp;</td>
						  <td colspan='2' align='right'><input type='button' name='close' id='close' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onclick='close_me();' class='button' tabindex='64'></td>
						</tr>
						<%
						if(stmt != null) stmt.close();
						if(oth_stmt != null) oth_stmt.close();
						if(pstmt != null)pstmt.close();
						if(prs != null) prs.close();
						if(oth_rset != null) oth_rset.close();
						if(rs != null) rs.close();
			        }
					catch(Exception e)
					{
						out.print(e.toString());
						e.printStackTrace();
					}
					finally
					{
						ConnectionManager.returnConnection(con,request);
					} 
					%>
					<input type='hidden' name='change_patient' id='change_patient' value="">
					<input type='hidden' name='addr1_type' id='addr1_type' value=''>
					<input type='hidden' name='addr1_line1' id='addr1_line1' value=''>
					<input type='hidden' name='addr1_line2' id='addr1_line2' value=''>
					<input type='hidden' name='addr1_line3' id='addr1_line3' value=''>
					<input type='hidden' name='addr1_line4' id='addr1_line4' value=''>
					<input type='hidden' name='res_town_code' id='res_town_code' value=''>
					<input type='hidden' name='res_town_desc' id='res_town_desc' value=''>

					<input type='hidden' name='res_area_code' id='res_area_code' value=''>
					<input type='hidden' name='postal1_code' id='postal1_code' value=''>
					<input type='hidden' name='region_code1' id='region_code1' value=''>
					<input type='hidden' name='country1_code' id='country1_code' value=''>
					<input type='hidden' name='contact1_name' id='contact1_name' value=''>
					<input type='hidden' name='invalid1_yn' id='invalid1_yn' value=''>

					<input type='hidden' name='addr2_type' id='addr2_type' value=''>
					<input type='hidden' name='addr2_line1' id='addr2_line1' value=''>
					<input type='hidden' name='addr2_line2' id='addr2_line2' value=''>
					<input type='hidden' name='addr2_line3' id='addr2_line3' value=''>
					<input type='hidden' name='addr2_line4' id='addr2_line4' value=''>
					<input type='hidden' name='res2_town_code' id='res2_town_code' value=''>
					<input type='hidden' name='res2_area_code' id='res2_area_code' value=''>
					<input type='hidden' name='postal2_code' id='postal2_code' value=''>
					<input type='hidden' name='region2_code' id='region2_code' value=''>
					<input type='hidden' name='country2_code' id='country2_code' value=''>
					<input type='hidden' name='contact2_name' id='contact2_name' value=''>
					<input type='hidden' name='invalid2_yn' id='invalid2_yn' value=''>

					<input type='hidden' name='contact1_no' id='contact1_no' value=''>
					<input type='hidden' name='contact2_no' id='contact2_no' value=''>
					<input type='hidden' name='email' id='email' value=''>

					<input type='hidden' name='r_postal_code' id='r_postal_code' value=''>
					<input type='hidden' name='m_postal_code' id='m_postal_code' value=''>
					<input type='hidden' name='r_town' id='r_town' value='' >
					<input type='hidden' name='r_area' id='r_area' value=''>
					<input type='hidden' name='r_region' id='r_region' value='' >	

					<input type='hidden' name='m_town' id='m_town' value='' maxlength='6'>
					<input type='hidden' name='m_area' id='m_area' value='' maxlength='6'>
					<input type='hidden' name='m_region' id='m_region' value='' maxlength='8'>

					<input type='hidden' name='country1_desc' id='country1_desc' value='' >
					<input type='hidden' name='country2_desc' id='country2_desc' value=''>
					<input type='hidden' name='mail_postal_code_desc' id='mail_postal_code_desc' value=''>
					<input type='hidden' name='postal_code_desc' id='postal_code_desc' value='' >
					<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
				</table>
			<!-- </tr>
		</table> -->
	</form>
	<script>
		var readonly_yn = document.forms[0].readonly_yn.value;
		if(readonly_yn == 'Y')
		{
			var length = document.forms[0].elements.length;
			for(i=0;i<length;i++)
			{
				document.getElementById("Contact_Details_form").elements[i].disabled=true;
			}
			document.Contact_Details_form.close.disabled=false;
		}
	</script>
	</body>
</html>

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

