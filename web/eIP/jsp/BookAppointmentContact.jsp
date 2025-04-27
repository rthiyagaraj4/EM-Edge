<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, eCommon.XSSRequestWrapper, java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eMP/jsp/PatientAddressLegends.jsp"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>

<head>
<title><fmt:message key="Common.ContactDetails.label" bundle="${common_labels}"/></title>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<Script src="../../eCommon/js/locale.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
 	String patid			= checkForNull(request.getParameter("patient_id"));
  	String contactdetails	= checkForNull(request.getParameter("contactdetails"));
	String booking_ref_no	= checkForNull(request.getParameter("booking_ref_no"));
	String FromQuery		= checkForNull(request.getParameter("FromQuery"));

	String disableVal = "";
	String readonlyVal = "";

	if(FromQuery.equals("Y"))
	{
		disableVal = "Disabled";
		readonlyVal = "readOnly";
	}
%>

<script>
var GlobalVal ="";
var chk_for_close=false;

	GlobalVal = window.dialogArguments;

function exitContact() 
{
	chk_for_close=true;
	chkval();
	window.returnValue=Bkappt1_form.contactdata.value;
	window.close();  
}

function cancelContact()
{
	if(!chk_for_close)
	{
		window.returnValue=Bkappt1_form.contactdata.value;
		window.close();
	}
}

function chkval() {
if(Bkappt1_form.email_id)
	{
		if((Bkappt1_form.email_id.value=="")||(Bkappt1_form.email_id.value==null))
		{
			Bkappt1_form.email_id.value="";
			email_id = "";		
		}
		else
				email_id = Bkappt1_form.email_id.value;
	}
else
	email_id = "";

if(Bkappt1_form.res_tel_no)
	{
		if((Bkappt1_form.res_tel_no.value=="")||(Bkappt1_form.res_tel_no.value==null))
		{
				Bkappt1_form.res_tel_no.value="";	
				res_tel_no = "";
		}
		else
				res_tel_no = Bkappt1_form.res_tel_no.value;
	}
else
	res_tel_no = "";
if(Bkappt1_form.other_tel_no)
	{
		if((Bkappt1_form.other_tel_no.value=="")||(Bkappt1_form.other_tel_no.value==null))
		{	
			Bkappt1_form.other_tel_no.value="";
			other_tel_no = "";
		}
		else
				other_tel_no = Bkappt1_form.other_tel_no.value;

	}	
else
	other_tel_no = "";
if(Bkappt1_form.addr_line_1)
	{
		if((Bkappt1_form.addr_line_1.value=="")||(Bkappt1_form.addr_line_1.value==null))
		{
			Bkappt1_form.addr_line_1.value="";
			addr_line_1 = "";
		}
		else
				addr_line_1 = Bkappt1_form.addr_line_1.value;
	}
else
	addr_line_1 = "";
if(Bkappt1_form.addr_line_2)
	{
		if((Bkappt1_form.addr_line_2.value=="")||(Bkappt1_form.addr_line_2.value==null))
		{
			Bkappt1_form.addr_line_2.value="";
			addr_line_2 = "";
		}
		else
				addr_line_2 = Bkappt1_form.addr_line_2.value;
	}
else
	addr_line_2 = "";
if(Bkappt1_form.addr_line_3)
	{
		if((Bkappt1_form.addr_line_3.value=="")||(Bkappt1_form.addr_line_3.value==null))
		{
			Bkappt1_form.addr_line_3.value="";
			addr_line_3 = "";
		}
		else
				addr_line_3 = Bkappt1_form.addr_line_3.value;
	}
else
	addr_line_3 = "";
if(Bkappt1_form.addr_line_4)
	{
		if((Bkappt1_form.addr_line_4.value=="")||(Bkappt1_form.addr_line_4.value==null))
		{
			Bkappt1_form.addr_line_4.value="";
			addr_line_4 = "";
		}
		else
				addr_line_4 = Bkappt1_form.addr_line_4.value;
				
	}
else
	addr_line_4 = "";
if(Bkappt1_form.postal_code)
	{
	if((Bkappt1_form.postal_code.value=="null")||(Bkappt1_form.postal_code.value=="")||(Bkappt1_form.postal_code.value==null))
		{
			Bkappt1_form.postal_code.value="";
			postal_code = "";
		}
		else
				postal_code = Bkappt1_form.postal_code.value;
	}
else
	postal_code = "";

if(Bkappt1_form.country_code)
	{
		if((Bkappt1_form.country_code.value=="null")||(Bkappt1_form.country_code.value==""))
		{
			Bkappt1_form.country_code.value="";
			country_code = "";
		}
		else
				country_code = Bkappt1_form.country_code.value;
	}
else
	country_code = "";

Bkappt1_form.contactdata.value = res_tel_no+"||";
Bkappt1_form.contactdata.value +=other_tel_no+"||";
Bkappt1_form.contactdata.value +=email_id+"||";
Bkappt1_form.contactdata.value +=postal_code+"||";
Bkappt1_form.contactdata.value +=country_code+"||";
Bkappt1_form.contactdata.value +=addr_line_1+"||";
Bkappt1_form.contactdata.value +=addr_line_2+"||";
Bkappt1_form.contactdata.value +=addr_line_3+"||";
Bkappt1_form.contactdata.value +=addr_line_4;

}

async function callSearch()
{
		var target = document.forms[0].postal_code;
		var retVal = 	new String();
		var dialogHeight= "28" ;
		var dialogWidth	= "43" ;
		var status = "no";
		var arguments	= "" ;
		var sql="select POSTAL_CODE,SHORT_DESC from mp_postal_code";
		var search_code="POSTAL_CODE";
		var search_desc="SHORT_DESC";
		var tit=getLabel('eMP.postalcode.label','MP');

		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);
		if (!(retVal == null))
		{
			target.value=retVal;
		}
		else
			target.focus();
}

function onbodyLoad()
{
	var GlobalValue = GlobalVal.value;
	if(GlobalValue==null && GlobalValue =='null') GlobalValue="";

	if(GlobalValue != "PopulateValues" && GlobalValue != "||||||||||||||||")
	{
		var assignVal = GlobalValue.split('||');

		Bkappt1_form.res_tel_no.value	= checkForNull(assignVal[0]) ;
		Bkappt1_form.other_tel_no.value = checkForNull(assignVal[1]);
		Bkappt1_form.email_id.value		= checkForNull(assignVal[2]);
		Bkappt1_form.postal_code.value	= checkForNull(assignVal[3]);
		Bkappt1_form.country_code.value	= checkForNull(assignVal[4]);

		if(Bkappt1_form.addr_line_1)
			Bkappt1_form.addr_line_1.value	= checkForNull(assignVal[5]);

		if(Bkappt1_form.addr_line_2)
			Bkappt1_form.addr_line_2.value	= checkForNull(assignVal[6]);

		if(Bkappt1_form.addr_line_3)
			Bkappt1_form.addr_line_3.value	= checkForNull(assignVal[7]);

		if(Bkappt1_form.addr_line_4)
			Bkappt1_form.addr_line_4.value	= checkForNull(assignVal[8]);
	}
	else
	{
		var contactvals = "<%=contactdetails%>";
		if(contactvals == null || contactvals == 'null') contactvals = "";
		
		if(contactvals != "||||||||||||||||" && contactvals != "")
		{
			var assignVal = contactvals.split("||");

			Bkappt1_form.res_tel_no.value	= checkForNull(assignVal[0]) ;
			Bkappt1_form.other_tel_no.value = checkForNull(assignVal[1]);
			Bkappt1_form.email_id.value		= checkForNull(assignVal[2]);
			Bkappt1_form.postal_code.value	= checkForNull(assignVal[3]);
			Bkappt1_form.country_code.value	= checkForNull(assignVal[4]);

			if(Bkappt1_form.addr_line_1)
				Bkappt1_form.addr_line_1.value	= checkForNull(assignVal[5]);

			if(Bkappt1_form.addr_line_2)
				Bkappt1_form.addr_line_2.value	= checkForNull(assignVal[6]);

			if(Bkappt1_form.addr_line_3)
				Bkappt1_form.addr_line_3.value	= checkForNull(assignVal[7]);

			if(Bkappt1_form.addr_line_4)
				Bkappt1_form.addr_line_4.value	= checkForNull(assignVal[8]);
		}
	}
}

function populateVals(contdetails)
{
		var assignVal = contdetails.split('||');

		Bkappt1_form.res_tel_no.value	= checkForNull(assignVal[0]) ;
		Bkappt1_form.other_tel_no.value = checkForNull(assignVal[1]);
		Bkappt1_form.email_id.value		= checkForNull(assignVal[2]);
		Bkappt1_form.postal_code.value	= checkForNull(assignVal[3]);
		Bkappt1_form.country_code.value	= checkForNull(assignVal[4]);

		if(Bkappt1_form.addr_line_1)
			Bkappt1_form.addr_line_1.value	= checkForNull(assignVal[5]);

		if(Bkappt1_form.addr_line_2)
			Bkappt1_form.addr_line_2.value	= checkForNull(assignVal[6]);

		if(Bkappt1_form.addr_line_3)
			Bkappt1_form.addr_line_3.value	= checkForNull(assignVal[7]);

		if(Bkappt1_form.addr_line_4)
			Bkappt1_form.addr_line_4.value	= checkForNull(assignVal[8]);
}

function checkForNull(inString)
{
	return (trimCheck(inString))	?	inString	:	"";
}

</script>

</head>
<body onLoad='onbodyLoad()' onUnload='cancelContact()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%

Connection conn = null;
Statement stmt=null;
Statement stmt1=null;
Statement stmt2=null;
Statement stmt3=null;
ResultSet rs=null;
ResultSet rs1=null;
ResultSet rset=null;
ResultSet rset3=null;

try{
	conn = ConnectionManager.getConnection(request);
	Properties p		= (java.util.Properties) session.getValue("jdbc");
	String prn_tel_no="";
	String orn_tel_no="";
	String email_id ="";
	String addrl1="";
	String addrl2="";
	String addrl3="";
	String addrl4="";

	String countrycode="";
 	String countrycode1="";
 	String countrydesc1="";
	String s="";
	String postal_code1		= "";
	String[] contact_col_names	= null ;
	String[] contact_prompts	= null ;
//	String[] contact_fields		= null ;
	int tabIndex		= 1;
	
	//Added for this CRF ML-MMOH-CRF-0860.2
	Boolean increasedaddressLength = eCommon.Common.CommonBean.isSiteSpecific(conn, "MP","INCREASED_ADDRESS_LINE_LENGTH");
	//End ML-MMOH-CRF-0860.2

	String[] address_col_names=	{"ADDR_LINE1_PROMPT","ADDR_LINE2_PROMPT","ADDR_LINE3_PROMPT","ADDR_LINE4_PROMPT","","","","POSTAL_CODE_PROMPT"};
	String[] address1_fld_names=	{"addr_line_1","addr_line_2","addr_line_3","addr_line_4","","","","postal_code"};

	ArrayList contact_addr = fetchContactAddresses(conn, out,"",p);


	contact_col_names	= (String[])contact_addr.get(1) ;
	contact_prompts		 = (String[])contact_addr.get(2) ;
	contact_addr		 = null;
 	stmt=conn.createStatement();
	String facilityId = (String)session.getValue("facility_id");
 	if ((!booking_ref_no.equals("")) && (!booking_ref_no.equals("null")) && contactdetails.equals("||||||||||||||||"))
	{
		 String sql="select patient_id,res_addr_line1, res_addr_line2, res_addr_line3, res_addr_line4,postal_code,country_code, res_tel_no,oth_contact_no,email_id from ip_booking_list_vw where bkg_lst_ref_no = '"+booking_ref_no+"' and Facility_id = '"+facilityId+"'";	

		 rs=stmt.executeQuery(sql);
		 if(rs!=null)
		 {
		   if(rs.next())
		   {
			 addrl1=rs.getString("res_addr_line1");
			 addrl2=rs.getString("res_addr_line2");
			 addrl3=rs.getString("res_addr_line3");
			 addrl4=rs.getString("res_addr_line4");
			 postal_code1=rs.getString("postal_code");
			 prn_tel_no=rs.getString("res_tel_no");
			 orn_tel_no=rs.getString("oth_contact_no");
			 email_id=checkForNull(rs.getString("email_id"));
			 countrycode=checkForNull(rs.getString("country_code"));	
		   }
		}
		if(countrycode !=null)
		{
			stmt2=conn.createStatement();
			 if(countrycode != "")
			 {
				String sql2="Select Country_Code, long_name Short_Name from Mp_Country where country_code='"+countrycode+"'";
				rset=stmt2.executeQuery(sql2);
				if(rset!=null && rset.next())
				 {
				 }
			}
		 }
	}//e.of.if

	if ((booking_ref_no == null) || (booking_ref_no.equals("null")) || (booking_ref_no.equals("")))
	{    
			if(!(patid == null || patid.equals("")))
			{
				String sql3="Select b.addr1_line1 resi_addr_line1, b.addr1_line2 resi_addr_line2, b.addr1_line3 resi_addr_line3, b.addr1_line4 resi_addr_line4, b.postal1_code resi_postal_code, b.country1_code resi_country_code, a.contact1_no prn_tel_no, a.contact2_no orn_tel_no, a.email_id  email_id from MP_PATIENT a,MP_PAT_ADDRESSES b where a.patient_id = b.patient_id and a.patient_id = '"+patid+"' ";
				stmt3=conn.createStatement();
				rset3=stmt3.executeQuery(sql3);
				if(rset3!=null)
				{
					if(rset3.next())
					{
						addrl1			= checkForNull(rset3.getString("resi_addr_line1"));                
						addrl2			= checkForNull(rset3.getString("resi_addr_line2"));      
						addrl3			= checkForNull(rset3.getString("resi_addr_line3"));                
						addrl4			= checkForNull(rset3.getString("resi_addr_line4"));                		
						postal_code1	= checkForNull(rset3.getString("resi_postal_code"));   
						countrycode		= checkForNull(rset3.getString("resi_country_code"));              		
						prn_tel_no		= checkForNull(rset3.getString("prn_tel_no"));                     
						orn_tel_no		= checkForNull(rset3.getString("orn_tel_no"));                     
						email_id		= checkForNull(rset3.getString("email_id"));      
						
					}
				}
			}
	}

	String[] address_fld_values=	{addrl1,addrl2,addrl3,addrl4,"","","",postal_code1};
	
%>
<form name="Bkappt1_form" id="Bkappt1_form">
				<table border='0' cellpadding='0' cellspacing='0' width='90%' align='center' valign='top' >
				<BR><br>
				<tr><td width="100%" class="Border"><table border='0' cellpadding='0' cellspacing='0' width='65%' align='center'>	<tr><td align='LEFT' class='label' width='5%'>&nbsp;<input type='hidden' name='contactdata' id='contactdata' value='<%=s%>'></td>
				</tr>
				</table>
				</tr>
				</table>

			<table border='0' cellpadding='0' cellspacing='2' width='90%' align='center' >
	<%

		for(int i=0;i<contact_col_names.length;i++) 
		{
			if( !(contact_col_names[i].equalsIgnoreCase("RES_AREA_PROMPT") || contact_col_names[i].equalsIgnoreCase("RES_TOWN_PROMPT")|| contact_col_names[i].equalsIgnoreCase("REGION_PROMPT")) )
			{ %>
				<tr><td class='label' width='5%'>&nbsp;</td>
				<td class='LABEL' align='LEFT' width='20%' nowrap><%=contact_prompts[i]%></td>		
			<%	for(int j=0; j<address_col_names.length; j++)
				{
					
					if(address_col_names[j].equalsIgnoreCase(contact_col_names[i]))
					{
						if(address_col_names[j].equalsIgnoreCase("POSTAL_CODE_PROMPT"))
						{ %>
							<td class='LABEL' align='left' width='40%'>&nbsp;&nbsp;<input type='text' name='<%=address1_fld_names[j]%>' id='<%=address1_fld_names[j]%>' value="<%=ecis.utils.HTMLUtilities.getDisplayString(address_fld_values[j])%>"	maxLength='8' size='8' tabindex='<%=tabIndex%>' onKeyPress='return CheckForSpecChars(event)' <%=readonlyVal%>><input type='button' name='postal_search' id='postal_search' class='BUTTON' value='?' onClick='callSearch(<%=address1_fld_names[j]%>)' <%=disableVal%> ></td>  
							<td class='LABEL' align='LEFT' width='10%' colspan='3'>&nbsp;</td></tr>
						<%}
						else
						{ 
						   //Below line added for this ML-MMOH-CRF-0860.2
						if(increasedaddressLength){					
						
			if(address1_fld_names[j].equalsIgnoreCase("addr_line_1")){ %>
			 <td class='fields' width='40%'>&nbsp;&nbsp;&nbsp;&nbsp;<textarea name='<%=address1_fld_names[j]%>' id='<%=address1_fld_names[j]%>' rows='3' maxlength='100' cols='50' onblur='makeValidString(this);' onkeypress='checkMaxLimit(this,100)' <%=readonlyVal%>><%=address_fld_values[j]%></textarea></td>
			 <%}else if(address1_fld_names[j].equalsIgnoreCase("addr_line_2")){%>
			 <td class='fields' width='40%'>&nbsp;&nbsp;&nbsp;&nbsp;<textarea name='<%=address1_fld_names[j]%>' id='<%=address1_fld_names[j]%>' rows='3' maxlength='100 ' cols='50' onblur='makeValidString(this);'  onkeypress='checkMaxLimit(this,100)' <%=readonlyVal%>><%=address_fld_values[j]%></textarea></td>
			 <%}else if(address1_fld_names[j].equalsIgnoreCase("addr_line_3")){%>
			 <td class='fields' width='40%'>&nbsp;&nbsp;&nbsp;&nbsp;<textarea name='<%=address1_fld_names[j]%>' id='<%=address1_fld_names[j]%>' rows='3' maxlength='100' cols='50' onblur='makeValidString(this);'  onkeypress='checkMaxLimit(this,100)' <%=readonlyVal%> ><%=address_fld_values[j]%></textarea></td>
			<% }else if(address1_fld_names[j].equalsIgnoreCase("addr_line_4")){%>
		<td class='LABEL' align='left' width='40%' colspan='3' >&nbsp;&nbsp;<input type='text' name='<%=address1_fld_names[j]%>' id='<%=address1_fld_names[j]%>' value="<%=ecis.utils.HTMLUtilities.getDisplayString(address_fld_values[j])%>"	maxLength='30' size='25' tabindex='<%=tabIndex%>' onBlur='makeValidString(this)' <%=readonlyVal%>></td>
			<td class='LABEL' align='LEFT' width='10%'>&nbsp;</td></tr>
			<% }					
				}else{%>							
			<td class='LABEL' align='left' width='40%' colspan='3' >&nbsp;&nbsp;<input type='text' name='<%=address1_fld_names[j]%>' id='<%=address1_fld_names[j]%>' value="<%=ecis.utils.HTMLUtilities.getDisplayString(address_fld_values[j])%>"		maxLength='30' size='25' tabindex='<%=tabIndex%>' onBlur='makeValidString(this)' <%=readonlyVal%>></td>
			<td class='LABEL' align='LEFT' width='10%'>&nbsp;</td></tr>
			<%} //End ML-MMOH-CRF-0860.2			
						
						}
						tabIndex++;
					}
				}   
			}
		}

%>
			<tr>	
				<td class='label' width='5%'>&nbsp;</td>
				<td class='LABEL' align='LEFT' width='35%' nowrap  ><fmt:message key="Common.country.label" bundle="${common_labels}"/></td>
<%
				String sql4="select country_code,long_name short_name from mp_country where eff_status='E' order by short_name";
				stmt1 = conn.createStatement();
				rs1=stmt1.executeQuery(sql4);
%>
				<td class='LABEL' align='left' width='40%' >&nbsp;&nbsp;<select name='country_code' id='country_code' <%=disableVal%>>
					<option value="" selected>&nbsp;&nbsp;&nbsp;----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;&nbsp;</option>
						<%											
							while (rs1.next()) {
								countrycode1=rs1.getString("country_code");
								countrydesc1=rs1.getString("short_name");

							if (countrycode1.equals(countrycode)) { %>
							<option value='<%=countrycode1%>' selected><%=countrydesc1%></option>
							<%}else { %>
							<option value='<%=countrycode1%>'><%=countrydesc1%></option>
						<%	}
							}
						%>
					</select>
				<td class='LABEL' align='LEFT' width='10%' colspan='3'>&nbsp;</td>
			</td>
			</tr>
			<tr>
				<td class='label' width='5%'>&nbsp;</td>
				<td class='LABEL' align='LEFT' width='35%' nowrap><fmt:message key="Common.ResTelNo.label" bundle="${common_labels}"/></td>
				<td class='LABEL' align='left' width='40%' >&nbsp;&nbsp;<input type='text' name='res_tel_no' id='res_tel_no' value="<%=prn_tel_no%>" size='20' maxlength='20' onBlur='return makeValidString(this)' <%=readonlyVal%>></td>
				<td class='LABEL' align='LEFT' width='10%' colspan='3'>&nbsp;</td>
			</tr>
			<tr>
				<td class='label' width='5%'>&nbsp;</td>
				<td class='LABEL' align='LEFT' width='35%' nowrap><fmt:message key="Common.othertelno.label" bundle="${common_labels}"/></td>
				<td class='LABEL' align='left' width='40%' >&nbsp;&nbsp;<input type='text' name='other_tel_no' id='other_tel_no' value="<%=orn_tel_no%>" size='20' maxlength='20' onBlur='return makeValidString(this)' <%=readonlyVal%>>
				</td>
				<td class='LABEL' align='LEFT' width='10%' colspan='3'>&nbsp;</td>
			</tr>
			<tr>
				<td class='label' width='5%'>&nbsp;</td>
				<td class='LABEL' align='LEFT' width='35%' nowrap><fmt:message key="Common.email.label" bundle="${common_labels}"/></td>
				<td class='LABEL' align='left' width='40%' >&nbsp;&nbsp;<input type='text' name='email_id' id='email_id' value="<%=email_id%>" size='30' maxlength='50'  onBlur="makeValidString(this)" <%=readonlyVal%>>
				<td class='LABEL' align='LEFT' width='10%' colspan='3'>&nbsp;</td>
			</td>
			</tr>
		</table>
    	<table border='0' cellpadding='0' cellspacing='2' width='90%' align='center'>
    				<tr>
    						<td align='RIGHT'><input type='button' name='close' id='close' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onClick='exitContact()' class="BUTTON">
							</td>
    				</tr>
    		</table>

    </form>
   </body>
	
   </html>
   <%
	}
catch(Exception e) 
{
	out.println(e.toString());
	e.printStackTrace();
}
finally
{
   if(rs != null) rs.close();
   if(rs1 != null) rs1.close();
   if(rset != null) rset.close();
   if(rset3!=null)  rset3.close();

   if(stmt != null) stmt.close();
   if(stmt1 != null) stmt1.close();
   if(stmt2 != null) stmt2.close();
   if(stmt3 != null) stmt3.close();
   ConnectionManager.returnConnection(conn,request);
}
%>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

