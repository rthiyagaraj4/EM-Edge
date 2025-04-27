<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>

<script language='javascript' src='../../eAE/js/AEPatientByCriteria.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 

<script>

	function allowPositiveNumber1()  
	{		
			callchk_toage();
			var key = window.event.keyCode;
			if(((key >=48 ) && (key<58))) 
			{
				return true;
			}
			else
				return false;
		
	}
	function callchk_toage()
	{
		if(document.forms[0].p_fm_age.value=="")
		{
			document.forms[0].p_fm_age.focus();
			return false;
		}
		else 
			return true;


	}
    function callagevalid(obj,obj1)
	  {
		 if(obj1.value!='')
		 {
		 if(eval(obj.value) > eval(obj1.value))
		  {
			var error=getMessage("MRDATE1_LT_DATE2",'MR')
			error=error.replace('#','From Age')
			error=error.replace('$','To Age')
			 alert(error);
			 obj1.select();
			 obj1.focus();
		  }
		 }
	  }
	

</script>
</head>

 <%	
     request.setCharacterEncoding("UTF-8");
     Connection con 					= null;
	 java.sql.Statement stmt				        = null;
	 PreparedStatement pstmt            = null;
	 ResultSet rset					    = null;
	 ResultSet rs					    = null;
	 String facilityId					= (String)session.getValue("facility_id");
	 String sqlstr						= "";
	 String pid_length					= "";
	 String location_code					="";
 	 String location_desc					="";
	 String locale						= (String)session.getAttribute("LOCALE");



try{
    con	= ConnectionManager.getConnection(request);
	

    sqlstr = "select patient_id_length from mp_param";
	stmt = con.createStatement();
    rset = stmt.executeQuery(sqlstr);
    if(rset != null)
       if(rset.next())
          pid_length = rset.getString(1);
          
    if(pid_length==null || pid_length.equals(""))
       pid_length = "20";
 
	if(stmt!=null) stmt.close();
	if(rset!=null) rset.close();  

	 %>  
<body onLoad='callfocus()' onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<center>
<form name='AEPatientByCriteriaForm' id='AEPatientByCriteriaForm'>   
<table border='0' cellpadding='2' cellspacing='0' width='100%'>
<tr><td colspan='4' height='5'></td></tr>
<tr>
	<td class='LABEL' width="25%"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
	<td  class='field' width="25%"><input type='text' onKeyPress="return(CheckForSpecChars(event))" name='patient_id' id='patient_id' value='' size='20' maxlength='<%=pid_length%>' onBlur='changeCase(this);'><input type='button' class='BUTTON' value='?' name='patient_search' id='patient_search' onClick = 'parent.callPatientSearch()'></td>
	<td  class='LABEL'  width="25%"><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
	<td class='field'  width="25%"><select name='gender' id='gender' ><option value=''>&nbsp;&nbsp;-- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --&nbsp;&nbsp;</option>
		<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
		<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
		<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
		</select>
	</td>
</tr>

<tr>
	<td  class='LABEL'  width="25%"><fmt:message key="Common.Location.label" bundle="${common_labels}"/> </td>
	<td class='field'  width="25%"><select name='ae_patbycriteria_location' id='ae_patbycriteria_location' >
	<option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>  -----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
<%	
String sql_locn="select clinic_code, long_desc clinic_desc from op_clinic_lang_vw where facility_id = ? and care_locn_type_ind = 'C' and level_of_care_ind = 'E' and eff_status = 'E' and language_id = '"+locale+"' order by 2";

pstmt	= con.prepareStatement(sql_locn);
pstmt.setString(1,facilityId);
rset	= pstmt.executeQuery();

		while(rset!=null  && rset.next())
		{
		 location_code=rset.getString(1);
		 location_desc=rset.getString(2);
		 out.println("<option value='"+location_code+"'>"+location_desc+"</option>");
         }
		if(rset!=null)  rset.close();
		if(pstmt!=null) pstmt.close();
%>
	</select> 
	</td>
	<td class='LABEL'  width="25%"><fmt:message key="eAE.ContactTelNo.label" bundle="${ae_labels}"/></td>
	<td class='field'  width="25%"><input type='text' name='ctelno' id='ctelno'  value="" size='20' maxlength='20' onBlur="makeValidString(this)">
</tr>

<tr>
	<td  class='LABEL'  width="25%"> <fmt:message key="Common.DateFrom.label" bundle="${common_labels}"/> </td>
	<td class='field'  width="25%"><input type='text' id='patfrom' maxlength='10' size='9' name='ae_patbycriteria_datefrom' id='ae_patbycriteria_datefrom' size='15' onBlur="if(validDateObj(this,'DMY','<%=localeName%>')){checkDate(this);}"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('patfrom');" style='cursor:pointer' ></img><img  src='../../eCommon/images/mandatory.gif'></img></td>


	<td  class='LABEL'  width="25%"> <fmt:message key="Common.to.label" bundle="${common_labels}"/> </td>
	<td class='field'  width="25%"><input type='text' id='patto' maxlength='10' size='9' name='ae_patbycriteria_dateto' id='ae_patbycriteria_dateto' size='15' onBlur="if(validDateObj(this,'DMY','<%=localeName%>')){checkDate(this);}"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('patto');" style='cursor:pointer'></img><img  src='../../eCommon/images/mandatory.gif'></img></td>

</tr>  
<tr>
	<td  class='LABEL'  width="25%"><fmt:message key="Common.race.label" bundle="${common_labels}"/></td>
	<td  class='field'  width="25%"><select name="RACE_CODE" id="RACE_CODE">
	<option value =''>--------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---------</option>
	<%
	pstmt = con.prepareStatement("select RACE_CODE, LONG_DESC from MP_RACE_lang_vw where EFF_STATUS='E' and language_id = '"+locale+"' order by LONG_DESC ");

			    rs = pstmt.executeQuery();
			    if( rs != null )
				{
					String code="";
					String desc="";
					while( rs.next() )
					{
						code = rs.getString( "RACE_CODE" ) ;
						desc = rs.getString( "LONG_DESC" ) ;
						%>
						<option value="<%=code%>"><%=desc%></option>
						<%
					}

				}
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();%>
					</select>
	</td>
	<td class='LABEL'  width="25%"><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>
	<td  class='field'  width="25%"><select name="citizen_nationality_code" id="citizen_nationality_code" style='width: 150px'>
                <option value =''>--------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---------</option>
                            <%

                                pstmt = con.prepareStatement( "select country_code, long_desc from mp_country_lang_vw where eff_status='E' and language_id = '"+locale+"' order by long_desc" ) ;
                                rs = pstmt.executeQuery() ;
                                 String countryCode="";
									 String countryName="";
                                if( rs != null ) {
                                    while( rs.next() ) {
                                         countryCode = rs.getString( "country_code" ) ;
                                         countryName = rs.getString( "long_desc" ) ;
                                
                                         %><option value='<%=countryCode%>' ><%=countryName%> </option>
                                    <%}
                                }

                               if(pstmt!=null) pstmt.close() ;
							   if(rs!=null)	rs.close();
                        %>
                </select></td>
   </tr>
   <tr>
	<td class='LABEL' width="25%"><fmt:message key="Common.age.label" bundle="${common_labels}"/></td>
	<td class='field' width="25%"><input type='text' name='p_fm_age' id='p_fm_age'  value="" size='4' maxlength='3' onblur="callagevalid(this,document.forms[0].p_to_age);" onKeyPress="return allowPositiveNumber1();"> <span class='LABEL'> <fmt:message key="Common.Years.label" bundle="${common_labels}"/></span>&nbsp;&nbsp;-&nbsp;&nbsp;<input type='text' name='p_to_age' id='p_to_age'  onblur="callagevalid(document.forms[0].p_fm_age,this);"  onkeypress="return allowPositiveNumber1();" value="" size='4' maxlength='3' >&nbsp;<span class='LABEL'><fmt:message key="Common.Years.label" bundle="${common_labels}"/></span></td>

    <td>&nbsp;</td>
	<td class='button' width="25%" align="right">
	<input type='button' class='BUTTON' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick='parent.callSearch(patient_id,ctelno,ae_patbycriteria_datefrom,ae_patbycriteria_dateto,ae_patbycriteria_location,gender,RACE_CODE,citizen_nationality_code,p_fm_age,p_to_age,parent.messageFrame)'>
	<input type='button' class='BUTTON' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>'  onClick="parent.clear()"></td>
</tr>
		<tr><td colspan='4' class='label' height='5'></td></tr>
</table>
<input type=hidden name='facilityId' id='facilityId' value='<%=facilityId%>'>
</form>
<script>
	//parent.frames[0].document.forms[0].reset.disabled=true;
</script>

</body>   
		<% } catch(Exception e){e.printStackTrace();}
   finally
    {
    	if(con!=null)
		ConnectionManager.returnConnection(con,request);
    }
%>

</html>

