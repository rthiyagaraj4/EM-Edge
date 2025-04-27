<!DOCTYPE html>
<!--
	Module		: Martuary Management(MO)
	Function	: MO CLAIMANT TYPE
	Description : This function is used for entering claimant type details.In this claimant type values                are hot coded  and country details are getting from Mp_Country table. Address fields                 are generating dynamically .In update mode all the fields are disabled or enabled based               on the eff_status value.
-->
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,org.json.simple.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eMP/jsp/PatientAddressLegends.jsp" %>


<head>
<%
	request.setCharacterEncoding("UTF-8"); 
	String locale = ((String)session.getAttribute("LOCALE"));
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 Properties p		= (java.util.Properties) session.getValue("jdbc");
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>


<script src='../../eMO/js/MOClaimants.js' language='javascript'></script>
</head>
<body onLoad = 'FocusFirstElement();ClaimantTypeValue();' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<!-- ClaimantTypeValue() method Added by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095-->
<%
Connection conn = null;
Statement stmt=null;
ResultSet rs=null;
try{
    request.setCharacterEncoding("UTF-8");
    String operation=request.getParameter("operation");// FROM moclaimantqueryresult.jsp
    if(operation==null || operation.equals("null")) operation="insert";
    String claimant_type_code=request.getParameter("claimant_type_code");// FROM moclaimantqueryresult.jsp
    if(claimant_type_code==null || claimant_type_code.equals("null")) claimant_type_code="";
	conn = ConnectionManager.getConnection(request);
	String long_desc              	= ""; 
	String short_desc             	= ""; 
    String claimant_type            = "";
	String tel_no                 	= ""; 
	String tlx_no                 	= ""; 
	String regioncode="";
	String areacode="";
	String towncode="";
	String fax_no                 	= ""; 
	String email                  	= ""; 
	String website                	= ""; 
	String eff_status			    = ""; 
	String checked					= "checked";										
	String postal_code				= "";  
	String postal_desc				= "";  
	StringBuffer  sql						= new StringBuffer();
	String addrl1					= "";
	String addrl2					= "";
	String addrl3					= "";
	String addrl4					= "";
	String country_code				= "";
	String country_code_qry			= "";
	String und="";
	String country_short_name		= "";	
   	String emba                     = "";//for claimant type
	String wel                      = "";//for claimant type
	String rel                      = "";//for claimant type
	String oth                      = "";//for claimant type
	String[] contact_col_names	    = null ;
	String regiondesc="";
	String areadesc="";
	String towndesc="";
	String[] contact_prompts	    = null ;
	String[] contact_fields		    = null ;
	String disableVal				= "";
	String readonlyVal				= "";
	String disableReadOnly			= "";
	int tabIndex		            = 1;

	/*Added by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095*/
	String function_id = "CLAIMANT_TYPE";
	JSONArray ClaimantTypeJsonArr = new JSONArray();
	ClaimantTypeJsonArr = eMO.MOCommonBean.getClaimantType(conn,function_id);
	/*End ML-MMOH-CRF-1095*/

//	String[] address_col_names=	{"ADDR_LINE1_PROMPT","ADDR_LINE2_PROMPT","ADDR_LINE3_PROMPT","ADDR_LINE4_PROMPT","REGION_PROMPT","RES_AREA_PROMPT","RES_TOWN_PROMPT","POSTAL_CODE_PROMPT"};

//	String[] address1_fld_names=	{"addr_line_1","addr_line_2","addr_line_3","addr_line_4","region","area","town","postal_code"};
	ArrayList contact_addr= fetchContactAddresses(conn,out,"parent.parent.messageFrame",p) ;
	contact_col_names		= (String[])contact_addr.get(1) ;
	contact_prompts			= (String[])contact_addr.get(2) ;
    contact_fields			= (String[])contact_addr.get(3) ;
	contact_addr				= null;

    if (operation.equals("modify"))
   {
    readonlyVal="readonly";
    sql.setLength(0);
	//sql.append(" SELECT CLAIMANT_TYPE_CODE,LONG_DESC,SHORT_DESC,CLAIMANT_TYPE,ADD_LINE1,ADD_LINE2,ADD_LINE3,ADD_LINE4,POSTAL_CODE,COUNTRY_CODE,TEL_NO,TLX_NO,FAX_NO,EMAIL_ID,WEBSITE,EFF_STATUS ,CLAIMANT_TYPE_CODE, RES_TOWN_CODE, RES_TOWN_DESC, RES_AREA_CODE, RES_AREA_DESC,REGION_CODE,REGION_DESC FROM MO_CLAIMANT_TYPE_vw WHERE CLAIMANT_TYPE_CODE='"+claimant_type_code+"'");

	sql.append("SELECT" );
	sql.append("  A.CLAIMANT_TYPE_CODE" );
	sql.append("  , A.LONG_DESC" );
	sql.append("  , A.SHORT_DESC" );
	sql.append("  , A.CLAIMANT_TYPE" );
	sql.append("  , A.ADD_LINE1" );
	sql.append("  , A.ADD_LINE2" );
	sql.append("  , A.ADD_LINE3" );
	sql.append("  , A.ADD_LINE4" );
	sql.append("  , A.POSTAL_CODE" );
	sql.append("  , A.COUNTRY_CODE" );
	sql.append("  , A.RES_TOWN_CODE" );
	sql.append(" , mp_get_desc.mp_res_town(a.res_town_code,'"+locale+"',1) RES_TOWN_DESC" );
	sql.append("  , A.RES_AREA_CODE" );
	sql.append(", mp_get_desc.mp_res_area(a.res_area_code,'"+locale+"',1) RES_AREA_DESC" );
	sql.append("  , A.REGION_CODE" );
	sql.append(", mp_get_desc.mp_region(a.region_code,'"+locale+"',1) REGION_DESC" );
	sql.append("  , A.TEL_NO" );
	sql.append("  , A.TLX_NO" );
	sql.append("  , A.FAX_NO" );
	sql.append("  , A.EMAIL_ID" );
	sql.append("  , A.WEBSITE" );
	sql.append("  , A.EFF_STATUS " );
	sql.append("  , mp_get_desc.MP_POSTAL_CODE(a.postal_code,'"+locale+"',2) POSTAL_DESC " );
	sql.append("FROM" );
	sql.append("  MO_CLAIMANT_TYPE_lang_vw A" );
	sql.append("  , MP_COUNTRY B" );
	sql.append("  , MP_REGION C" );
	sql.append("  , MP_RES_AREA D" );
	sql.append("  , MP_RES_TOWN E " );
	sql.append("  , MP_POSTAL_CODE F " );
	sql.append("WHERE A.COUNTRY_CODE=B.COUNTRY_CODE(+) " );
	sql.append("  AND A.REGION_CODE=C.REGION_CODE(+) " );
	sql.append("  AND A.RES_AREA_CODE=D.RES_AREA_CODE(+) " );
	sql.append("  AND A.RES_TOWN_CODE=E.RES_TOWN_CODE(+) " );
	sql.append("  AND A.POSTAL_CODE=F.POSTAL_CODE(+) " );
	sql.append("  AND A.CLAIMANT_TYPE_CODE='"+claimant_type_code+"'" );
	sql.append("  AND A.language_id='"+locale+"'" );
	
	 stmt = conn.createStatement();
	 rs = stmt.executeQuery(sql.toString());
    if(rs!=null)
	{
         if( rs.next() )
		{
			claimant_type_code=rs.getString("CLAIMANT_TYPE_CODE");           
			if(claimant_type_code == null || claimant_type_code.equals("null"))claimant_type_code="";
			long_desc=rs.getString("LONG_DESC");           
			if(long_desc == null || long_desc.equals("null")) long_desc="";  
			towncode=rs.getString("RES_TOWN_CODE");
			if(towncode == null || towncode.equals("null")) towncode="";   
			towndesc=rs.getString("RES_TOWN_DESC");
			if(towndesc == null || towndesc.equals("null")) towndesc="";   
			areacode=rs.getString("RES_AREA_CODE");
			if(areacode == null || areacode.equals("null")) areacode="";   
           	areadesc=	rs.getString("RES_AREA_DESC");
			if(areadesc == null || areadesc.equals("null")) areadesc="";   
		
		   	regioncode=	rs.getString("REGION_CODE");
			if(regioncode == null || regioncode.equals("null")) regioncode="";   
            regiondesc=	rs.getString("REGION_DESC");
			if(regiondesc == null || regiondesc.equals("null")) regiondesc="";   
			
			short_desc=	rs.getString("SHORT_DESC");
			if(short_desc == null || short_desc.equals("null")) short_desc="";   
			claimant_type=rs.getString("CLAIMANT_TYPE");
			if(claimant_type == null || claimant_type.equals("null")) claimant_type=""; 

			if(claimant_type.equals("M"))//for  embassy and country
			emba="SELECTED";  
			else if(claimant_type.equals("W"))//for  welfare 
			wel="SELECTED";
			else if(claimant_type.equals("R"))//for relational
			rel="SELECTED";  
			else if(claimant_type.equals("O"))//for others
			oth="SELECTED";
            else if(claimant_type.equals("U"))//for others
			und="SELECTED";
			 
			addrl1=rs.getString("ADD_LINE1");
			if(addrl1 == null || addrl1.equals("null")) addrl1="";

			addrl2=rs.getString("ADD_LINE2");
			if(addrl2 == null || addrl2.equals("null")) addrl2="";

			addrl3=rs.getString("ADD_LINE3");
			if(addrl3 == null || addrl3.equals("null")) addrl3="";

			addrl4=rs.getString("ADD_LINE4");
			if(addrl4 == null || addrl4.equals("null")) addrl4="";

			tel_no=rs.getString("TEL_NO");
			if(tel_no == null || tel_no.equals("null")) tel_no="";

			tlx_no=rs.getString("TLX_NO");
			if(tlx_no == null || tlx_no.equals("null")) tlx_no="";

			fax_no=rs.getString("FAX_NO");
			if(fax_no == null || fax_no.equals("null")) fax_no="";

			email=rs.getString("EMAIL_ID");
			if(email == null || email.equals("null")) email="";

			website=rs.getString("WEBSITE");
			if(website == null || website.equals("null")) website="";

			eff_status=rs.getString("EFF_STATUS");
			if(eff_status == null || eff_status.equals("null")) eff_status="";
			if( eff_status.equals("E")) checked="checked";

			else if( eff_status.equals("D"))
			{
			checked="";
			disableReadOnly="readonly";
			disableVal = "disabled";
			}
			postal_code=rs.getString("POSTAL_CODE");
			if(postal_code == null || postal_code.equals("null")) postal_code="";
			
			postal_desc=rs.getString("postal_desc");
			if(postal_desc == null || postal_desc.equals("null")) postal_desc="";
			

			country_code=rs.getString("COUNTRY_CODE");
			if(country_code == null || country_code.equals("null")) country_code="";
	        }
       }if(rs != null) rs.close();
        if(stmt != null) stmt.close();
}
          sql.setLength(0);
         // String[] address_fld_values={addrl1,addrl2,addrl3,addrl4,regiondesc,areadesc,towndesc,postal_code};

%>			
<form name='claimant_form' id='claimant_form' action='../../servlet/eMO.MOClaimantsServlet' method='post' target='messageFrame'>
<table border='0' cellpadding='3' cellspacing='0' width='90%' align='center'>
 <BR>  

 
     <tr>
	    	<td class='label' width='30%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		    <td class='fields'><input type='text' name='claimant__type_code' id='claimant__type_code' 
                value="<%=claimant_type_code%>"size='4' maxlength='4'onKeyPress="return CheckForSpecChars(event)" OnBlur='ChangeUpperCase(this)' <%=readonlyVal%> tabindex='<%=tabIndex++%>'>
    			<img src='../../eCommon/images/mandatory.gif' align='center'></img>
	        </td>
    </tr>
    <tr>
	       <td class=label><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
		   <td class='fields'><input type='text' name='long_desc' id='long_desc' size='40' maxlength='40'        value="<%=long_desc%>"onblur="return makeValidString(this);"tabindex='<%=tabIndex++%>' <%=disableReadOnly%>>
		       <img src='../../eCommon/images/mandatory.gif'align='center'></img>
		   </td>
   </tr>
   <tr>
	       <td class=label><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>		
		   <td class='fields'><input type='text' name='short_desc' id='short_desc' size='15' maxlength='15'       value="<%=short_desc%>"  onblur="return makeValidString(this);"<%=disableReadOnly%>           tabindex='<%=tabIndex++%>'>
		       <img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
  </tr>

  <tr>
	       <td class=label ><fmt:message key="eMO.ClaimantTypeRelat.label" bundle="${mo_labels}"/></td>
	       <td class='fields'><select name='Claimants_type' id='Claimants_type' tabindex='<%=tabIndex++%>'<%=disableVal%> onload='chkfields()' onchange='chkfields()' >
    		  <option value="">&nbsp;----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------- &nbsp;</option>

			  <!--Added by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095-->
			  <%
				for(int i = 0 ; i < ClaimantTypeJsonArr.size() ; i++) 
				{
					JSONObject json	= (JSONObject)ClaimantTypeJsonArr.get(i);
					String claimant_type_mstr_code = (String) json.get("claimant_type_mstr_code");
					String claimant_short_desc = (String) json.get("short_desc");
					out.println("<option value='"+claimant_type_mstr_code+"'>"+claimant_short_desc+"</option>");	
				}
			  %>
				<!--<option value='M'<%=emba%>><fmt:message key="eMO.EmbassyCountry.label" bundle="${mo_labels}"/></option>
 				<option value='O'<%=oth%> ><fmt:message key="Common.others.label" bundle="${common_labels}"/></option>
 				<option value='R'<%=rel%> ><fmt:message key="eMO.ReligiousOrgn.label" bundle="${mo_labels}"/></option>
				<option value='U'<%=und%> ><fmt:message key="eMO.UnderTaker.label" bundle="${mo_labels}"/></option>
				<option value='W' <%=wel%> ><fmt:message key="eMO.WelfareAssociations.label" bundle="${mo_labels}"/></option>-->
			
			 <!--End ML-MMOH-CRF-1095-->
			 
             </select>
		     <img src='../../eCommon/images/mandatory.gif'align='center'></img>
         </td>
 <tr>
		<td class=label><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type='checkbox' name='eff_status' id='eff_status' value="E" <%=checked%> tabindex='<%=tabIndex++%>'></td>
 </tr>
 <tr>
       <th colspan=2 class='columnheader' align="left"><fmt:message key="Common.AddressDetails.label" bundle="${common_labels}"/></th>
 </tr>
 <%   
	/* code for displaying address fields and postal code*/
		tabIndex++;
		out.println("<tr>") ; 
		StringBuffer sb2 = new StringBuffer() ;
		StringBuffer sb12 = new StringBuffer() ;
		StringBuffer sba2 = new StringBuffer() ;
		StringBuffer sbar2 = new StringBuffer();
        StringBuffer fieldVal2 = new StringBuffer("");
                    for(int i=0;i<contact_col_names.length; i++)
                            {
                                  String  val = contact_fields[i] ;
								  sb2.append(val);
                                   int j=0 ;
								   int j1 = 0;
                                   String old_val = "" ;
                                   String new_val = "" ;
                                     
                                     if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt"))
                                     {
                                        old_val = "r_addr_line1" ;
                                        new_val = "add_ln1" ;
										     
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt"))
                                     {
                                        old_val = "r_addr_line2" ;
                                        new_val = "add_ln2" ;
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt"))
                                     {
                                        old_val = "r_addr_line3" ;
                                        new_val = "add_ln3" ;
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("addr_line4_prompt"))
                                     {
                                        old_val = "r_addr_line4" ;
                                        new_val = "add_ln4" ;
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
                                     {
                                        old_val = "r_town_code" ;
                                        new_val = "m_town_code" ;
									 }//Added by kumar on 13/03/2003 for region 
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
									out.println("<td class=label  >"+contact_prompts[i]+"</td>") ;	
                                    while(val.indexOf(old_val) != -1)
                                    {
                                        j = val.indexOf(old_val,j) ;
                                        sb2 = sb2.replace(j,(j+old_val.length()),new_val);
                                        val = sb2.toString();
                                    }
             // Newly added
			if(contact_col_names[i].equalsIgnoreCase("res_town_prompt")) {
				sba2.append(val);
				while(val.indexOf("r_postal_code") != -1) {
					j1 = val.indexOf("r_postal_code",j1) ;
					sba2 = sba2.replace(j1,(j1+"r_postal_code".length()),"m_postal_code");
					val = sba2.toString();
				}
			}
			if(contact_col_names[i].equalsIgnoreCase("res_area_prompt")) {
				j1 = 0;
				sbar2.append(val);
				while(val.indexOf("r_postal_code") != -1) {
					j1 = val.indexOf("r_postal_code",j1) ;
					sbar2 = sbar2.replace(j1,(j1+"r_postal_code".length()),"m_postal_code");
					val = sbar2.toString();
				}
			}
								   sb12.append(val);
									for(int z=0;z<val.length();z++)
									{
										String tempVal=sb12.substring(z,z+1);
										if(tempVal.equals("@"))
										{
											fieldVal2.append(++tabIndex);
										}
										else
										{
											fieldVal2.append(tempVal);
										}
									}
                                    val = fieldVal2.toString();
                                    out.println("<td class='fields'>"+val) ;
									
						   out.println("</td>");
						 //  out.println("<td class='label'  colspan='2'>&nbsp;</td>");
						   out.println("</tr>") ;
						   sb12.delete(0,sb12.length());
						   fieldVal2.delete(0,fieldVal2.length());
						   sb2.delete(0,sb2.length());
						   sba2.delete(0,sba2.length());
						   sbar2.delete(0,sbar2.length());
                            } 
								

					
		       %>  
	<tr>
	<td class=label><fmt:message key="Common.country.label" bundle="${common_labels}"/></td><td class='fields' ><select name='country_code' id='country_code' tabindex='<%=tabIndex%>' <%=disableVal%>><option value='' >----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
	<%
	 sql.setLength(0);
	// sql.append("Select Country_Code,short_name from Mp_Country where eff_status='E' and trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) order by 2");
	 sql.append("select country_code, long_desc from mp_country_lang_vw where language_id='"+locale+"' and EFF_STATUS='E' order by 2");
	            
	stmt = conn.createStatement();
	rs = stmt.executeQuery(sql.toString());

	while ( rs.next() )
	{
	country_code_qry = rs.getString("Country_Code");
	country_short_name = rs.getString("long_desc");


	if(country_code_qry.equals(country_code))

	out.print("<option value=" + country_code_qry + " selected>" + country_short_name + "</option>"); 

	else					  
	out.print("<option value=" + country_code_qry + ">" + country_short_name + "</option>"); 
	}
	  if(rs != null) rs.close();
      if(stmt != null) stmt.close();
sql.setLength(0);
%>
  </select></td></tr>
  <tr>
        <th colspan=2 class='columnheader' align="left"><fmt:message key="Common.ContactDetails.label" bundle="${common_labels}"/></th>
  </tr>
  <tr>
		<td class=label><fmt:message key="Common.telno.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type='text' name='tel_no' id='tel_no' value="<%=tel_no%>" <%=disableReadOnly%> size='18' maxlength='18' tabindex='<%=tabIndex+1%>'>
		</td>
  </tr>
  <tr>
			<td class=label><fmt:message key="Common.TelexNo.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type='text' name='tlx_no' id='tlx_no' size='18' maxlength='18' value="<%=tlx_no%>"  <%=disableReadOnly%> onblur="return makeValidString(this);" tabindex='<%=tabIndex+1%>'>
			</td>		
  </tr>
  <tr>
			<td class=label><fmt:message key="Common.FaxNo.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type='text' name='fax_no' id='fax_no' size='18' maxlength='18' value="<%=fax_no%>"  <%=disableReadOnly%> onblur="return makeValidString(this);" tabindex='<%=tabIndex+1%>'>
			</td>
  </tr>
  <tr>
			<td class=label><fmt:message key="Common.email.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type='text' name='email' id='email' size='50' maxlength='50' value="<%=email%>"  <%=disableReadOnly%> onblur="return makeValidString(this);" tabindex='<%=tabIndex+1%>'>
			</td>
 </tr>
 <tr>
			<td class=label><fmt:message key="Common.Web.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type='text' name='website' id='website' size='50' maxlength='50' value="<%=website%>"  <%=disableReadOnly%> onblur="return makeValidString(this);" tabindex='<%=tabIndex+1%>'>
			</td>
 </tr>
 
 </table>

 <input type='hidden' name='m_town' id='m_town' value='<%=towncode%>'>
<input type='hidden' name='m_area' id='m_area' value='<%=areacode%>'>
<input type='hidden' name='m_region' id='m_region' value='<%=regioncode%>'>
<input type='hidden' name='m_postal_code' id='m_postal_code' value='<%=postal_code%>'>

<INPUT TYPE="hidden" name="town_code" id="town_code">
<INPUT TYPE="hidden" name="area_code" id="area_code">
<INPUT TYPE="hidden" name="region_code" id="region_code">
<INPUT TYPE="hidden" name="postal_code" id="postal_code">
	      
          <input type='hidden' name='region1' id='region1' value='<%=regioncode%>'>
	      <input type='hidden' name='area1' id='area1' value='<%=areacode%>'>
	      <input type='hidden' name='town1' id='town1' value='<%=towncode%>'>
          <input type='hidden' name='operation' id='operation' value='<%=operation%>'>

<!--Added by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095-->
<input type='hidden' name='claimant_type_mstr' id='claimant_type_mstr' value='<%=claimant_type%>'>
</form>
</body>
<%
  if (operation.equals("modify"))
   {%>
     <script>
			  if(document.getElementById('m_town_code'))
			  document.getElementById('m_town_code').value='<%=towndesc%>';

		   if(document.getElementById('m_area_code'))
			  document.getElementById('m_area_code').value='<%=areadesc%>';

		    if(document.getElementById('m_region_code'))
			  document.getElementById('m_region_code').value='<%=regiondesc%>';
				
				 if(document.getElementById('m_postal_code1'))
			  document.getElementById('m_postal_code1').value='<%=postal_desc%>';


			 if(document.getElementById('add_ln1'))
			  document.getElementById('add_ln1').value='<%=addrl1%>';

			  if(document.getElementById('add_ln2'))
			  document.getElementById('add_ln2').value='<%=addrl2%>';

			   if(document.getElementById('add_ln3'))
			  document.getElementById('add_ln3').value='<%=addrl3%>';

			    if(document.getElementById('add_ln4'))
			  document.getElementById('add_ln4').value='<%=addrl4%>';

			
	 </script>


	 <%

	 if(eff_status.equals("D"))
					{	%>
						<script>
							for(k=0;k<document.forms[0].elements.length;k++)
								document.forms[0].elements(k).disabled = true;

							document.forms[0].eff_status.disabled = false;
							document.forms[0].eff_status.focus();
						</script>
					<%	
					}


	
  }
%>
</html>
  <%
         if(rs != null) rs.close();
      if(stmt != null) stmt.close();}
catch(Exception e) 
{
	out.println("Exception in addModifyClaimants"+e.toString());
	e.printStackTrace();
}
finally
{
  
   ConnectionManager.returnConnection(conn,request);
}
%>

