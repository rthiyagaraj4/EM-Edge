 <!--/**** Master for entering the Manufacturer Details ******/-->
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8");%>
 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import="java.sql.*, java.util.*, java.text.*, eCommon.XSSRequestWrapper, webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eMP/jsp/PatientAddressLegends.jsp"%>


<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eAM/js/Manufacturer.js' language='javascript'></script>
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script>
<script>
function ChangeUpperCase(Object) {
    var objectfield = Object ;
    objectfield.value = objectfield.value.toUpperCase();
}

</script>
</head>
<body onLoad = 'FocusFirstElement();' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
Connection conn = null;
Statement stmt=null;
PreparedStatement pstmt = null;
ResultSet rs=null;


ResultSet rs1=null;
ResultSet rs2=null;
ResultSet rs3=null;
java.sql.Statement stmt4=null;
java.sql.Statement stmt5=null;
java.sql.Statement stmt6=null;

Boolean increasedaddressLength=false; //Added for ML-MMOH-CRF-0860.2

try{

String operation=request.getParameter("operation");
System.out.println("operation"+ operation);
if(operation==null || operation.equals("null")) operation="insert";

String manufacturer_id=request.getParameter("manufacturer_id");
if(manufacturer_id==null || manufacturer_id.equals("null")) manufacturer_id="";
conn = ConnectionManager.getConnection(request);

//Below line added for ML-MMOH-CRF-0860.2
increasedaddressLength = eCommon.Common.CommonBean.isSiteSpecific(conn, "MP","INCREASED_ADDRESS_LINE_LENGTH");

String long_name              	 = ""; 
String short_name             	 = ""; 
//String addr_line1             	 = ""; 
//String addr_line2             	 = ""; 
//String addr_line3             	 = ""; 
//String addr_line4				 = ""; 
String tel_no                 	 = ""; 
String tlx_no                 	 = ""; 
String fax_no                 	 = ""; 
String email                  	 = ""; 
String website                	 = ""; 
String eff_status			   	 = ""; 
//String res_town_code             = "";  
//String res_area_code             = ""; 
	Properties p		= (java.util.Properties) session.getValue("jdbc");
	String checked          = "checked";										
//	String addr_line_1		= "";
//	String addr_line_2		= "";
//	String addr_line_3		= "";
	//String addr_line_4		= "";
	String postal_code		= "";  
//	String postal_code1		= "";
//	String res_area_prompt = "";
//	String res_town_prompt = "";
	String sql = "";	
	String addrl1="";
	String addrl2="";
	String addrl3="";
	String addrl4="";
//	String postalcodeget="";
//	String countrycodeget="";
//	String postalcode="";
//	String postaldesc="";
//	String postalcode1="";
//	String postaldesc1="";
//	String countrycode="";
 //	String countrydesc="";
 	//String countrycode1="";
 	//String countrydesc1="";
	//String res_area_prompt1="";
	//String res_town_prompt1="";
	//String Area = "";
	//String Town = "";
	String country_code = "";
	String disableVal = "";
	String readonlyVal = "";
	String disableReadOnly="";
	String country_code_qry="";
	String country_short_name="";

	String Resi_Area_code="";
	String Resi_Town_code="";
	String Resi_Region_code="";

	String Resi_Area_Desc="";
	String Resi_Region_Desc="";
	String Resi_Town_Desc="";
	String postal_code_Desc="";

	String[] contact_col_names	= null ;
	String[] contact_prompts	= null ;
	String[] contact_fields		= null ;
	int tabIndex		= 1;
	//int tindex=0;

	//String[] address_col_names=	{"ADDR_LINE1_PROMPT","ADDR_LINE2_PROMPT","ADDR_LINE3_PROMPT","ADDR_LINE4_PROMPT","","","","POSTAL_CODE_PROMPT"};

	//String[] address1_fld_names=	{"addr_line_1","addr_line_2","addr_line_3","addr_line_4","","","","postal_code"};
	
	ArrayList contact_addr = fetchContactAddresses(conn,out,"parent.parent.messageFrame",p) ;
	System.out.println("array" +contact_addr);
	//String Site				= (String)contact_addr.get(0) ;
	contact_col_names		= (String[])contact_addr.get(1) ;
	contact_prompts			= (String[])contact_addr.get(2) ;
    contact_fields			= (String[])contact_addr.get(3) ;
	contact_addr				= null;
	System.out.println("operation" +operation);
if (operation.equals("modify"))
{

	stmt4     =  conn.createStatement();
	stmt5    =  conn.createStatement();
	stmt6    =  conn.createStatement();

 readonlyVal="readonly";
 sql="SELECT  MANUFACTURER_ID,LONG_NAME,SHORT_NAME,ADDR_LINE1,ADDR_LINE2,ADDR_LINE3,ADDR_LINE4,TEL_NO         ,TLX_NO, FAX_NO,EMAIL_ID,WEBSITE,EFF_STATUS,POSTAL_CODE,COUNTRY_CODE,RES_TOWN_CODE,RES_AREA_CODE,REGION_CODE from am_manufacturer where MANUFACTURER_ID=?";
 
 
		pstmt   = conn.prepareStatement(sql);
		System.out.println("pstmt" +pstmt);
		pstmt.setString	(	1,	manufacturer_id		);
		rs		 = pstmt.executeQuery();
		System.out.println("rs:"+rs);
   if(rs!=null)
	{
		   if( rs.next() )
				{
                
				manufacturer_id			=rs.getString("MANUFACTURER_ID");           
				 	if(manufacturer_id == null || manufacturer_id.equals("null")) manufacturer_id="";
				long_name			=rs.getString("LONG_NAME");           
				 	if(long_name == null || long_name.equals("null")) long_name="";
							 
				short_name			 =rs.getString("SHORT_NAME");
					 	if(short_name == null || short_name.equals("null")) short_name="";
				 
				addrl1           =rs.getString("ADDR_LINE1");
				System.out.println("addrl1"+addrl1);
				 	if(addrl1 == null || addrl1.equals("null")) addrl1="";
				addrl2           =rs.getString("ADDR_LINE2");
				System.out.println("addrl2"+addrl2);
				 	if(addrl2 == null || addrl2.equals("null")) addrl2="";
				addrl3           =rs.getString("ADDR_LINE3");
				 	 	if(addrl3 == null || addrl3.equals("null")) addrl3="";
			    addrl4             =rs.getString("ADDR_LINE4");
			 	 	if(addrl4 == null || addrl4.equals("null")) addrl4="";
			    tel_no                 =rs.getString("TEL_NO");
				 		if(tel_no == null || tel_no.equals("null")) tel_no="";
			    tlx_no                 =rs.getString("TLX_NO");
				 	 	if(tlx_no == null || tlx_no.equals("null")) tlx_no="";
			    fax_no                 =rs.getString("FAX_NO");
					 	if(fax_no == null || fax_no.equals("null")) fax_no="";
			    email                  =rs.getString("EMAIL_ID");
				 	 	if(email == null || email.equals("null")) email="";
				website                =rs.getString("WEBSITE");
				 	 	if(website == null || website.equals("null")) website="";
				
				eff_status             =rs.getString("EFF_STATUS");
				 if(eff_status == null || eff_status.equals("null")) eff_status="";
					if( eff_status.equals("E")) checked="checked";
					else if( eff_status.equals("D"))
					{
						checked="";
						disableReadOnly="readonly";
						disableVal = "disabled";
					}
				 postal_code            =rs.getString("POSTAL_CODE");
				 				 	if(postal_code == null || postal_code.equals("null")) postal_code="";
			 
				 country_code           =rs.getString("COUNTRY_CODE");
				 				 	if(country_code == null || country_code.equals("null")) country_code="";

				
					Resi_Area_code=rs.getString("RES_AREA_CODE");
					if(Resi_Area_code==null)Resi_Area_code="";

					Resi_Town_code=rs.getString("RES_TOWN_CODE");
					  if(Resi_Town_code==null)Resi_Town_code="";

					 Resi_Region_code=rs.getString("REGION_CODE");
					 if(Resi_Region_code==null)Resi_Region_code="";

				

	
					   }
          	} if(rs!=null) rs.close();
                 if(stmt!=null) stmt.close();



		String sql_t="SELECT SHORT_DESC FROM Mp_res_town  WHERE  RES_TOWN_CODE='"+Resi_Town_code+"'";

		
		rs1 = stmt4.executeQuery(sql_t);
		if(rs1 !=null && rs1.next())
			{
		Resi_Town_Desc=rs1.getString("SHORT_DESC");
        if(Resi_Town_Desc==null)Resi_Town_Desc="";
			}

		 if(rs1!=null) 	rs1.close();

		 String sql_r="SELECT SHORT_DESC FROM mp_region where  REGION_CODE='"+Resi_Region_code+"'";
	
		rs2= stmt5.executeQuery(sql_r);
		if(rs2 !=null && rs2.next())
			{
		Resi_Region_Desc=rs2.getString("SHORT_DESC");
        if(Resi_Region_Desc==null)Resi_Region_Desc="";
			}

		 if(rs2!=null) 	rs2.close();

		 String sql_a="SELECT SHORT_DESC FROM mp_res_area   WHERE RES_AREA_CODE ='"+Resi_Area_code+"'";
		 
		rs3 = stmt6.executeQuery(sql_a);
		if(rs3 !=null && rs3.next())
			{
		 Resi_Area_Desc=rs3.getString("SHORT_DESC");
        if(Resi_Area_Desc==null)Resi_Area_Desc="";
			}

		 if(rs3!=null) 	rs3.close();


		  String sql_p="SELECT SHORT_DESC FROM mp_postal_code   WHERE POSTAL_CODE ='"+postal_code+"'";
		 
		rs3 = stmt6.executeQuery(sql_p);
		if(rs3 !=null && rs3.next())
			{
		 postal_code_Desc=rs3.getString("SHORT_DESC");
        if(postal_code_Desc==null)postal_code_Desc="";
			}

		 if(rs3!=null) 	rs3.close();

}

//String[] address_fld_values=	{addrl1,addrl2,addrl3,addrl4,"","","",postal_code};

%>
<form name='Manufacturer_form' id='Manufacturer_form' action='../../servlet/eAM.ManufacturerServlet' method='post' target='messageFrame'>
<table border='0' cellpadding='0' cellspacing='0' width='90%' align='center'>
 <BR>  <BR>  <BR> 
<!-- <tr><td width='100%' colspan=2>&nbsp;</td></tr> -->
<tr>
		<td class='label' width='30%'><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<input type='text' name='manufacturer_id' id='manufacturer_id' value="<%=manufacturer_id%>" size='21' maxlength='20'  onKeyPress="return CheckForSpecChars(event)" <%=readonlyVal%> onblur="return  ChangeUpperCase(this);" tabindex='<%=tabIndex%>'>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
</tr>
<tr>
		<td   class=label><fmt:message key="Common.longname.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<input type='text' name='long_name' id='long_name' size='42' maxlength='40' value="<%=long_name%>"  onblur="return makeValidString(this);"  tabindex='<%=tabIndex++%>' <%=disableReadOnly%>>&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
</tr>
<tr>
		<td  class=label><fmt:message key="Common.shortname.label" bundle="${common_labels}"/></td>		
		<td class='fields'>&nbsp;&nbsp;<input type='text' name='short_name' id='short_name' size='21' maxlength='20' value="<%=short_name%>"  onblur="return makeValidString(this);"  <%=disableReadOnly%> tabindex='<%=tabIndex++%>'>
		<img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
</tr>
<tr>
		<td class=label><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<input type='checkbox' name='eff_status' id='eff_status' value="E"    <%=checked%> tabindex='<%=tabIndex++%>' ></td>
</tr>
<!-- <tr>
			<td    class=label>Enabled</td>
				<td>&nbsp;<input type='checkbox' name='eff_status' id='eff_status' value="E"    <%=checked%> tabindex='<%//=tabIndex++%>'>
</tr> -->
<tr>
<td class='columnheader' colspan=2 ><fmt:message key="Common.AddressDetails.label" bundle="${common_labels}"/></td>
</tr>
<%
		tabIndex++;
	/*	for(int i=0;i<contact_col_names.length;i++) 
		{
			if( !( contact_col_names[i].equalsIgnoreCase("REGION_PROMPT") ||contact_col_names[i].equalsIgnoreCase("RES_AREA_PROMPT") || contact_col_names[i].equalsIgnoreCase("RES_TOWN_PROMPT")) )
			{
				out.println("<tr>");
				out.println("<td class='LABEL' nowrap>"+contact_prompts[i]+"</td>") ;		
				for(int j=0; j<address_col_names.length; j++)
				{
					if(address_col_names[j].equalsIgnoreCase(contact_col_names[i]))
					{
						if(address_col_names[j].equalsIgnoreCase("POSTAL_CODE_PROMPT"))
						{
							out.println("<td class='fields' >&nbsp;&nbsp;<input type='text' name='"+address1_fld_names[j]+"' id='"+address1_fld_names[j]+"' value=\""+ecis.utils.HTMLUtilities.getDisplayString(address_fld_values[j])+"\"	maxLength='8' size='8' tabindex='"+tabIndex+"' "+disableReadOnly+" onKeyPress='return CheckForSpecChars(event)' ONBLUR='callSearch("+address1_fld_names[j]+");' ><input type='button' name='postal_search' id='postal_search' class='BUTTON' value='?' tabindex=-1 onClick='callSearch("+address1_fld_names[j]+")' "+disableVal+"></td>") ;  			
							tabIndex++;
						}
						else
						{
						out.println("<td class='fields' >&nbsp;&nbsp;<input type='text' name='"+address1_fld_names[j]+"' id='"+address1_fld_names[j]+"' value=\""+address_fld_values[j]+"\"		maxLength='30' size='32' tabindex='"+tabIndex+"' onBlur='makeValidString(this)' "+disableReadOnly+"></td>") ;
						tabIndex++;			
						}
						
					}
				}   
			}
		}  */


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
									out.println("<td class='label'  >"+contact_prompts[i]+"</td>") ;	
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
									
						/*Below line added for ML-MMOH-CRF-0860.2*/
						if(increasedaddressLength){
							if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt")) {
								out.println("<td class='fields' >&nbsp;&nbsp;<input type='text' name='add_ln1' id='add_ln1' maxlength='30' size='25' value='' tabIndex='1' onBlur='makeValidString(this)'></td>");							   							  
							}else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt")) {
								out.println("<td class='fields' >&nbsp;&nbsp;<input type='text' name='add_ln2' id='add_ln2' maxlength='30' size='25' value='' tabIndex='1' onBlur='makeValidString(this)'></td>");							   							  
							}else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt")) {
								out.println("<td class='fields' >&nbsp;&nbsp;<input type='text' name='add_ln3' id='add_ln3' maxlength='30' size='25' value='' tabIndex='1' onBlur='makeValidString(this)'></td>");							   							  
							}else{									
                                out.println("<td class='fields'>&nbsp;&nbsp;"+val) ;									
						        out.println("</td>");
						    }
						}else{
							out.println("<td class='fields'>&nbsp;&nbsp;"+val) ;									
							out.println("</td>");
						}
						   
						   
						  // out.println("<td class='label'  colspan='2'>&nbsp;</td>");
						   out.println("</tr>") ;
						   sb12.delete(0,sb12.length());
						   fieldVal2.delete(0,fieldVal2.length());
						   sb2.delete(0,sb2.length());
						   sba2.delete(0,sba2.length());
						   sbar2.delete(0,sbar2.length());
                            } 

%>
	<tr>
	<td class='LABEL' ><fmt:message key="Common.country.label" bundle="${common_labels}"/></td><td class='fields' >&nbsp;&nbsp;<select name='country_code' id='country_code' tabindex='<%=tabIndex%>' <%=disableVal%>><option value='' >----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
	<%

/**************************************************************************************************************/
	
    if(rs!=null)rs.close();
    if(stmt!=null)stmt.close();

	 sql="Select Country_Code,short_name from Mp_Country where eff_status='E' and trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) order by 2";

                stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
              
				while ( rs.next() )
                {
					country_code_qry = rs.getString("Country_Code");
					
					country_short_name = rs.getString("short_name");
					
                 
/*	commented on 25-11-2003 by dhanasekaran
	out.println("<script>") ;
                    out.println("if(document.getElementById('country_code') != null) {") ;
                        out.println("var element = document.createElement('OPTION');") ;
                        out.println("element.text=\""+rs.getString(2)+"\"") ;
                        out.println("element.value=\""+rs.getString(1)+"\"") ;
						String testVal = rs.getString(1);
						if (testVal == null) testVal = "";
    					//out.println("if(element.value==\""+country_code+"\")    element.selected = true;") ;
						
                        out.println("document.getElementById('country_code').add(element)") ;
						if(testVal.equals(country_code))
							out.println(" element.selected = true") ;

                    out.println("}") ;
                    out.println("</script>") ;
*///end comment
				   if(country_code_qry.equals(country_code))
					   out.print("<option value=" + country_code_qry + " selected>" + country_short_name + "</option>"); 
				   else					  
					   out.print("<option value=" + country_code_qry + ">" + country_short_name + "</option>"); 
                }if(rs!=null) rs.close();
                 if(stmt!=null) stmt.close();

%>
</select></td></tr>
<tr>
<td class='columnheader' colspan=2 ><fmt:message key="Common.ContactDetails.label" bundle="${common_labels}"/></td>
</tr>
<tr>
		<td class='label'><fmt:message key="Common.telno.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<input type='text' name='tel_no' id='tel_no' value="<%=tel_no%>" <%=disableReadOnly%> size='22' maxlength='20' onkeypress="return chkchar(this,event)" tabindex='<%=tabIndex+1%>'>
			&nbsp;&nbsp;<fmt:message key="Common.TelexNo.label" bundle="${common_labels}"/>&nbsp;&nbsp;<input type='text' name='tlx_no' id='tlx_no' size='22' maxlength='20' value="<%=tlx_no%>"  <%=disableReadOnly%> onblur="return makeValidString(this);" onkeypress="return chkchar(this,event)" tabindex='<%=tabIndex+1%>'>
		</td>
</tr>
<!-- <tr>
		<td    class=label>Telex No</td>
		<td>&nbsp;&nbsp;<input type='text' name='tlx_no' id='tlx_no' size='18' maxlength='18' value="<%=tlx_no%>"  onblur="return makeValidString(this);" tabindex='<%//=tabIndex+1%>'></td>
</tr> -->
<tr>
			<td class=label><fmt:message key="Common.FaxNo.label" bundle="${common_labels}"/></td>
			<td class='fields'>&nbsp;&nbsp;<input type='text' name='fax_no' id='fax_no' size='25' maxlength='20' value="<%=fax_no%>"  <%=disableReadOnly%> onblur="return makeValidString(this);" onkeypress="return chkchar(this,event)" tabindex='<%=tabIndex+1%>'>
			</td>
</tr>
<tr>
			<td  class=label><fmt:message key="Common.email.label" bundle="${common_labels}"/></td>
			<td class='fields'>&nbsp;&nbsp;<input type='text' name='email' id='email' size='50' maxlength='30' value="<%=email%>"  <%=disableReadOnly%> onblur="return makeValidString(this);" tabindex='<%=tabIndex+1%>'>
			</td>
</tr>
<tr>
			<td   class=label><fmt:message key="eAM.WebSite.label" bundle="${am_labels}"/></td>
			<td class='fields'>&nbsp;&nbsp;<input type='text' name='website' id='website' size='50' maxlength='30' value="<%=website%>"  <%=disableReadOnly%> onblur="return makeValidString(this);" tabindex='<%=tabIndex+1%>'>
			</td>
</tr>

<tr><td colspan=2>&nbsp;</td></tr>
</table>

<input type='hidden' name='operation' id='operation' value='<%=operation%>'>
<input type='hidden' name='function' id='function' value='insert'>
<input type='hidden' name='m_town' id='m_town' value=''>
<input type='hidden' name='m_area' id='m_area' value=''>
<input type='hidden' name='m_region' id='m_region' value=''>
<input type='hidden' name='m_postal_code' id='m_postal_code' value=''>

<INPUT TYPE="hidden" name="town_code" id="town_code">
<INPUT TYPE="hidden" name="area_code" id="area_code">
<INPUT TYPE="hidden" name="region_code" id="region_code">
<INPUT TYPE="hidden" name="postal_code" id="postal_code">



<%
if (operation.equals("modify"))
{ %>

<script>

    if("<%=addrl1%>" != '' && document.getElementById('add_ln1') != null)
		document.getElementById('add_ln1').value="<%=addrl1%>"

	if("<%=addrl2%>" != '' && document.getElementById('add_ln2') != null)
		document.getElementById('add_ln2').value="<%=addrl2%>"

	if("<%=addrl3%>" != '' && document.getElementById('add_ln3') != null)
		document.getElementById('add_ln3').value="<%=addrl3%>"

	if("<%=addrl4%>" != '' && document.getElementById('add_ln4') != null)
		document.getElementById('add_ln4').value="<%=addrl4%>"

	if("<%=Resi_Town_Desc%>" != '' && document.getElementById('m_town_code') != null)
		document.getElementById('m_town_code').value="<%=Resi_Town_Desc%>"

	if("<%=Resi_Region_Desc%>" != '' && document.getElementById('m_region_code') != null)
		document.getElementById('m_region_code').value="<%=Resi_Region_Desc%>"


	if("<%=Resi_Area_Desc%>" != '' && document.getElementById('m_area_code') != null)
		document.getElementById('m_area_code').value="<%=Resi_Area_Desc%>"
	
	

	if("<%=postal_code_Desc%>" != '' && document.getElementById('m_postal_code1') != null)
		document.getElementById('m_postal_code1').value="<%=postal_code_Desc%>"


	if("<%=Resi_Town_code%>" != '' && document.getElementById('m_town') != null)
		document.getElementById('m_town').value="<%=Resi_Town_code%>";
	

	if("<%=Resi_Area_code%>" != '' && document.getElementById('m_area') != null)
		document.getElementById('m_area').value="<%=Resi_Area_code%>"

	if("<%=Resi_Region_code%>" != '' && document.getElementById('m_region') != null)
		document.getElementById('m_region').value="<%=Resi_Region_code%>"
	
	if("<%=postal_code%>" != '' && document.getElementById('m_postal_code') != null)
		document.getElementById('m_postal_code').value="<%=postal_code%>"
	

	
		
</script>
<%

	 if(eff_status.equals("D"))
					{	%>
						<script>
							for(k=0;k<document.forms[0].elements.length;k++)
								document.forms[0].elements(k).disabled = true;

							document.getElementById('eff_status').disabled = false;
							document.getElementById('eff_status').focus();
						</script>
					<%	
					}


	} %>

</form>
</body>
</html>
  <%
	if(rs != null) rs.close();

   if(stmt != null) stmt.close();
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

