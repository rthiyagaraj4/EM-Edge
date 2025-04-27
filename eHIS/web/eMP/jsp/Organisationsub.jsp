<!DOCTYPE html>

<%@ page contentType="text/html; charset=UTF-8" import="java.sql.*,java.util.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%@ include file="PatientAddressLegends.jsp"%>


<%
request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eMP/js/Organization.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function resetval()
{
	if(document.forms[0].r_addr_line1)
	  document.forms[0].r_addr_line1.value = "" ;
	if(document.forms[0].r_addr_line2)
		document.forms[0].r_addr_line2.value = "" ;
	if(document.forms[0].r_addr_line3)
		document.forms[0].r_addr_line3.value = "" ;
	if(document.forms[0].r_addr_line4)
		document.forms[0].r_addr_line4.value = "" ;
	if(document.forms[0].r_town_code)
	{
			document.forms[0].r_town_code.value = "";
			document.forms[0].r_town.value = "";
	}
	
	if(document.forms[0].r_region_code)
	{
			document.forms[0].r_region_code.value = "";
			document.forms[0].r_region.value = "";
	}
	if(document.forms[0].r_area_code)
	{
			document.forms[0].r_area_code.value = "";
			document.forms[0].r_area.value=""
	}
	if(document.forms[0].r_postal_code) {
		document.forms[0].r_postal_code.value = "";
		document.forms[0].r_postal_code1.value = "";
	}

	document.forms[0].subunit_id.value='';
	document.forms[0].subunit_desc.value='';
	document.forms[0].subunit_contactname.value='';
	document.forms[0].hphone_no.value='';
	document.forms[0].ophone_no.value='';
	document.forms[0].next_country_desc.value='';
	document.forms[0].next_country_code.value='';
	document.forms[0].mode_sub.value="insert";
	document.forms[0].subunit_id.readOnly=false;

	
}
async function searchCountry(obj,target)
{
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="";				
	if(obj.name == "contry_code" )
	{
		if(target.name == 'nationality_desc'){
			tit="Nationality"
			sql="Select country_code code,long_desc description from Mp_Country where eff_status='E' and  upper(country_code) like upper(?) and upper(long_desc) like upper(?)";
		}
		else{
			tit="Country"
			sql="Select country_code code,long_name description from Mp_Country where eff_status='E' and upper(country_code) like upper(?) and upper(short_name) like upper(?)";
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
</script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown='lockKey()' onload="FocusFirstElement();">
<form name="contact_form" id="contact_form" action="../../servlet/eMP.OrganizationServlet" method="post" target="messageFrame">
<table border="0" cellpadding="3" cellspacing="0" width="100%" align='center'>
<input type='hidden' name='r_town' id='r_town'>
<input type='hidden' name='n_town' id='n_town'>
<input type='hidden' name='f_town' id='f_town'>
<input type='hidden' name='e_town' id='e_town'>
<input type='hidden' name='r_area' id='r_area' value=''>
<input type='hidden' name='m_area' id='m_area' value=''>
<input type='hidden' name='n_area' id='n_area' value=''>
<input type='hidden' name='f_area' id='f_area' value=''>
<input type='hidden' name='e_area' id='e_area' value=''>
<input type='hidden' name='r_region' id='r_region' value=''>
<input type='hidden' name='m_region' id='m_region' value=''>
<input type='hidden' name='n_region' id='n_region' value=''>
<input type='hidden' name='f_region' id='f_region' value=''>
<input type='hidden' name='e_region' id='e_region' value=''>
<%int tindex=46;
 String org_id=checkForNull(request.getParameter("org_id"));
 String org_name=checkForNull(request.getParameter("org_name"));
 String org_sub_id=checkForNull(request.getParameter("org_sub_id"));
 ResultSet rs					= null;
 Statement stmt					= null;
 Connection con					= null;

 //String family_org_id			= "";
 String family_org_sub_id		= "";
 String family_org_sub_name		= "";
 String org_contact_name		= "";
 String org_addr_line_1			= "";
 String org_addr_line_2			= "";
 String  org_addr_line_3		= "";
 String org_addr_line_4			= "";
 String  res_area_code			= ""; 
 String res_town_code			= ""; 
 String region_code				= "";
 String postal_code			= "";
 String postal_desc			= "";
 String country_code			= ""; 
 String res_tel_no				= ""; 
 String off_tel_no				= "";
 String res_area_desc			= "";
 String res_town_desc			= "";
 String res_region_desc			= "";
 String res_country_desc		= "";
 String mode					= "";
 String sub_org_id_rd			= "";
 String eff_statusnew			= "";
 String Record_dis			= "";
 
 Boolean increasedaddressLength=false; //Added for ML-MMOH-CRF-0860.2

mode=checkForNull(request.getParameter("mode"));
eff_statusnew=checkForNull(request.getParameter("eff_statusnew"));
if(eff_statusnew.equals("D"))
{
   Record_dis="disabled";
}
if(mode.equals(""))
mode="insert";
if(mode.equals("update"))
sub_org_id_rd="readonly";
 try{
	 con = ConnectionManager.getConnection(request);
	 
	 //Below line added for ML-MMOH-CRF-0860.2
     increasedaddressLength = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INCREASED_ADDRESS_LINE_LENGTH");
	 
	 
	 if(!org_sub_id.equals(""))
	  {
		String sql="SELECT a.family_org_id, a.family_org_sub_id, a.family_org_sub_name,a.org_contact_name, a.org_addr_line_1, a.org_addr_line_2,a.org_addr_line_3, a.org_addr_line_4, a.res_area_code res_area_code,(SELECT LONG_DESC FROM mp_res_area WHERE res_area_code = a.res_area_code) res_area_desc, a.res_town_code res_town_code,(SELECT LONG_DESC FROM mp_res_town WHERE res_town_code = a.res_town_code) res_town_desc, a.region_code region_code,(SELECT LONG_DESC FROM mp_region WHERE region_code = a.region_code) res_region_desc, a.postal_code postal_code, (SELECT SHORT_DESC FROM mp_postal_code WHERE postal_code = a.postal_code) postal_desc, a.country_code,(SELECT long_name FROM mp_country  WHERE country_code = a.country_code) res_country_desc, a.res_tel_no,  a.off_tel_no FROM mp_family_org_sub a where a.FAMILY_ORG_SUB_ID='"+org_sub_id+"' and a.family_org_id='"+org_id+ "'";
		stmt=con.createStatement();
		rs=stmt.executeQuery(sql);
		if(rs.next())
	    {
               org_id					= checkForNull(rs.getString("FAMILY_ORG_ID"));
               family_org_sub_id		= checkForNull(rs.getString("FAMILY_ORG_SUB_ID"));
               family_org_sub_name		= checkForNull(rs.getString("FAMILY_ORG_SUB_NAME"));
               org_contact_name			= checkForNull(rs.getString("ORG_CONTACT_NAME"));
               org_addr_line_1			= checkForNull(rs.getString("ORG_ADDR_LINE_1"));
               org_addr_line_2			= checkForNull(rs.getString("ORG_ADDR_LINE_2"));
               org_addr_line_3			= checkForNull(rs.getString("ORG_ADDR_LINE_3"));
               org_addr_line_4			= checkForNull(rs.getString("ORG_ADDR_LINE_4"));
               res_area_code			= checkForNull(rs.getString("RES_AREA_CODE"));
               res_town_code			= checkForNull(rs.getString("RES_TOWN_CODE"));
               region_code				= checkForNull(rs.getString("REGION_CODE"));
               postal_code				= checkForNull(rs.getString("POSTAL_CODE"));
               postal_desc				= checkForNull(rs.getString("POSTAL_DESC"));
               country_code				= checkForNull(rs.getString("COUNTRY_CODE"));
               res_tel_no				= checkForNull(rs.getString("RES_TEL_NO"));
               off_tel_no				= checkForNull(rs.getString("OFF_TEL_NO"));
			   res_area_desc			= checkForNull(rs.getString("res_area_desc"));
			   res_town_desc			= checkForNull(rs.getString("res_town_desc"));
			   res_region_desc			= checkForNull(rs.getString("res_region_desc"));
			   res_country_desc		    = checkForNull(rs.getString("res_country_desc"));
              
			}
			
	 }

 
%>
<td colspan=2 class='columnheader'><fmt:message key="eMP.OrganizationSubUnit.label" bundle="${mp_labels}"/></td>
<tr>
  <td colspan=1 width='40%' ></td>
  <td colspan=2 width='60%'></td>
  </tr>
  <input type='hidden' maxlength=10 name="org_id" id="org_id" readonly value="<%=org_name%>" tabindex='<%=++tindex%>'>
	<input type='hidden' maxlength=10 name="org_id_hd" id="org_id_hd"  value="<%=org_id%>" >
  <tr>
  <td class='label'><fmt:message key="eMP.SubUnitID.label" bundle="${mp_labels}"/></td>
  <td class='fields'><input type="text" <%=sub_org_id_rd%> maxlength=10 name="subunit_id" size=10 onBlur="ChangeUpperCase(this);MPCheckNumber(this);" onKeyPress="return CheckForSpecChars(event);"  tabindex='<%=++tindex%>' value="<%=family_org_sub_id%>"><img src='../images/mandatory.gif'></img></td>
  </tr>
  <tr>
  <td class='label'><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
  <td class='fields'><input type="text" maxlength=30 size=30 value="<%=family_org_sub_name%>" name="subunit_desc" tabindex='<%=++tindex%>'><img src='../images/mandatory.gif'></img></td>
  </tr>
  <tr>
  <td class='label'><fmt:message key="Common.ContactName.label" bundle="${common_labels}"/></td>
  <td class='fields'><input type="text" maxlength=30 size=30 name="subunit_contactname" id="subunit_contactname" tabindex='<%=++tindex%>' value="<%=org_contact_name%>"><img src='../images/mandatory.gif'></img></td>
  </tr>
  <!-- <th colspan=2 >Address</th> -->

<%
 tindex=1;
    Properties p		= (java.util.Properties) session.getValue("jdbc");
    ArrayList contact_addr = fetchContactAddresses(con, out,"parent.parent.messageFrame",p);
    String Site="";
	Site = (String)contact_addr.get(0);
	String[] contact_col_names	= null;
	String[] contact_prompts	= null;
	String[] contact_fields		= null;

	contact_col_names = (String[])contact_addr.get(1);
	contact_prompts   = (String[])contact_addr.get(2);
	contact_fields    = (String[])contact_addr.get(3);%>
<%
	StringBuffer sb1a = new StringBuffer();
	StringBuffer fieldVala = new StringBuffer();
	StringBuffer sba = new StringBuffer();
	StringBuffer sbap = new StringBuffer();
	StringBuffer sbar = new StringBuffer();
	StringBuffer sb1aa = new StringBuffer();
	StringBuffer fieldValaa = new StringBuffer();

	for(int i=0;i<contact_col_names.length; i++)
	{ 
		%>
		<tr><td class='label' ><%=contact_prompts[i]%></td>
		<% 
			String val  = contact_fields[i];
			sb1a.append(val);
			fieldVala.append("");
			for(int z=0;z<val.length();z++)
			{
				String tempVal=sb1a.substring(z,z+1);
				
				if(tempVal.equals("@"))
				{
					fieldVala.append("50");
				}
				else
				{
					fieldVala.append(tempVal);
				}
			}
			val = fieldVala.toString();
			
			/*Below line added for ML-MMOH-CRF-0860.2*/
				    if(increasedaddressLength){
						if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt")) {
								out.println("<td class='fields' ><input type='text' name='r_addr_line1' id='r_addr_line1' maxlength='30' size='25' value='' tabIndex='1' onBlur='makeValidString(this)'></td>");							   							  
						}else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt")) {
								out.println("<td class='fields' ><input type='text' name='r_addr_line2' id='r_addr_line2' maxlength='30' size='25' value='' tabIndex='1' onBlur='makeValidString(this)'></td>");							   							  
						}else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt")) {
								out.println("<td class='fields' ><input type='text' name='r_addr_line3' id='r_addr_line3' maxlength='30' size='25' value='' tabIndex='1' onBlur='makeValidString(this)'></td>");							   							  
						}else{%>									
                            <td class='fields'><%=val%></td>
						<%}
					}else{%> 
						  <td class='fields'><%=val%></td>
					<%}
			
			val = contact_fields[i] ;
			sba.append(val) ;
			 int j=0 ;
			 int j1=0 ;
			 String old_val = "" ;
			 String new_val = "" ;
		   
			if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt"))
			 {
				old_val = "r_addr_line1" ;
				new_val = "m_addr_line1" ;
			 }
			 else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt"))
			 {
				old_val = "r_addr_line2" ;
				new_val = "m_addr_line2" ;
			 }
			 else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt"))
			 {
				old_val = "r_addr_line3" ;
				new_val = "m_addr_line3" ;
			 }
			 else if(contact_col_names[i].equalsIgnoreCase("addr_line4_prompt"))
			 {
				old_val = "r_addr_line4" ;
				new_val = "m_addr_line4" ;
			 }
			 else if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
			 {
				old_val = "r_town_code" ;
				new_val = "m_town_code" ;
			 }
			 else if(contact_col_names[i].equalsIgnoreCase("region_prompt"))
			 {
				old_val = "r_region_code" ;
				new_val = "m_region_code" ;
			 }
			 else if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
			 {
				old_val = "r_area_code" ;
				new_val = "m_area_code" ;
			 }                                     
			 else if(contact_col_names[i].equalsIgnoreCase("postal_code_prompt"))
			 {
				old_val = "r_postal_code" ;
				new_val = "m_postal_code" ;
			 }
		
			 while(val.indexOf(old_val) != -1)
			 {
				j = val.indexOf(old_val,j) ;
				sba = sba.replace(j,(j+old_val.length()),new_val);
				val = sba.toString();
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
			
			sb1aa.append(val) ;
			fieldValaa.append("");
			for(int z=0;z<val.length();z++)
			{
				String tempVal=sb1aa.substring(z,z+1);
				if(tempVal.equals("@"))
				{
					fieldValaa.append("65");
				}
				else
				{
					fieldValaa.append(tempVal);
				}
			}
			
			val = fieldValaa.toString();
			sb1a.setLength(0);
			fieldVala.setLength(0);
			sba.setLength(0);
			sb1aa.setLength(0);
			fieldValaa.setLength(0);
			sbap.setLength(0);
			sbar.setLength(0);
	}
			%>
			<%tindex=61;%>
	
	<tr>
	<td class='label'><fmt:message key="Common.country.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type='text' maxlength=4 name='next_country_desc' id='next_country_desc' value="<%=res_country_desc%>"       size='15' maxlength='15' value='' onblur='if(this.value !="")searchCountry(contry_code[0],next_country_desc);' tabindex=<%=++tindex%>><input type='button' name='contry_code' id='contry_code' value='?' class='button' onclick='searchCountry(this,next_country_desc)' tabindex=<%=++tindex%>>
		<input type='hidden' name='next_country_code' id='next_country_code' value='<%=country_code%>'>
	</td>
   </tr>
   <tr>
   <td class='label' ><fmt:message key="Common.homephoneno.label" bundle="${common_labels}"/></td>
   <td class='fields'><input type="text" maxlength=20 name="hphone_no" id="hphone_no" value="<%=res_tel_no%>" tabindex='<%=++tindex%>'></td>
   </tr>
   <tr>
   <td class='label' ><fmt:message key="Common.officephoneno.label" bundle="${common_labels}"/></td>
   <td class='fields'><input type="text" maxlength=20 name="ophone_no" id="ophone_no" value="<%=off_tel_no%>" tabindex='<%=++tindex%>'></td>
   </tr>
   <tr>
    <td colspan=1 >&nbsp;</td>
	<td class='button'><input type='button' name=record1 id=record1 tabindex='<%=++tindex%>' class='button' <%=Record_dis%> value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onClick="record2();"><input type='button'  tabindex='<%=++tindex%>' class='button' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onclick="resetval()">
	</td>
   </tr>
  </table>
	<input type='hidden' name='m_town' id='m_town' value=''>
	<input type='hidden' name='town_code' id='town_code' >
	<input type='hidden' name='area_code' id='area_code' >
	<input type='hidden' name='region_code' id='region_code' >
	<input type='hidden' name='postal_code' id='postal_code' >
	<input type='hidden' name='contry_code' id='contry_code' >
	<input type="hidden" name="function" id="function" value='Organization_sub'>
	<input type="hidden" name="mode_sub" id="mode_sub" value='<%=mode%>'>
	<input type="hidden" name="r_postal_code" id="r_postal_code" value=''>
	<script>
	if(document.forms[0].r_addr_line1)
		document.forms[0].r_addr_line1.value = "<%=org_addr_line_1%>" ;
	if(document.forms[0].r_addr_line2)
		document.forms[0].r_addr_line2.value = "<%=org_addr_line_2%>" ;
	if(document.forms[0].r_addr_line3)
		document.forms[0].r_addr_line3.value = "<%=org_addr_line_3%>" ;
	if(document.forms[0].r_addr_line4)
		document.forms[0].r_addr_line4.value = "<%=org_addr_line_4%>" ;
	if(document.forms[0].r_town_code)
	{
		document.forms[0].r_town_code.value = "<%=res_town_desc%>";
		document.forms[0].r_town.value = "<%=res_town_code%>";
	}
	if(document.forms[0].r_region_code)
	{
		document.forms[0].r_region_code.value = "<%=res_region_desc%>";
		document.forms[0].r_region.value = "<%=region_code%>";
	}
	if(document.forms[0].r_area_code)
	{
		document.forms[0].r_area_code.value = "<%=res_area_desc%>";
		document.forms[0].r_area.value="<%=res_area_code%>"
	}
	if(document.forms[0].r_postal_code)	{		
		document.forms[0].r_postal_code.value = "<%=postal_code%>";
		document.forms[0].r_postal_code1.value = "<%=postal_desc%>";		
	}
	</script>


  </form>
 <%}catch(Exception e)
 {
	 e.printStackTrace();
 }
 finally 
 {
	   if(con!=null) ConnectionManager.returnConnection(con,request);
 }%>
  </body>
  </html>
  <%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>
  <!-- New function -->

