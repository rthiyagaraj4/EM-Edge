<!DOCTYPE html>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>


<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   	 request.setCharacterEncoding("UTF-8");
     String	facility_id =  (String) session.getValue( "facility_id" ) ;
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link   rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>	
	<script language='javascript' src='../../eCommon/js/dchk.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script> 
	<script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></Script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language='javascript' src='../../eMO/js/MORegisterAttn.js'> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<!-- <title> MORegnDtlsQueryCriteria.jsp </title> -->
	<%
	 String patient_length=   "";
	 Connection con		=	null;
	 Statement	st		=	null;
	 PreparedStatement pstmt=null;
	 ResultSet	rs		=	null;
	 String defaultdate1="";
	 Boolean isBIDRegnAppl	= false;//Added by Thamizh selvi on 25th July 2017 for ML-MMOH-CRF-0689
	 try 
		{	
			
			
			
		String getdate="select to_char(sysdate,'dd/mm/yyyy') date1	from dual";
        con	 =	(Connection)ConnectionManager.getConnection(request);
		isBIDRegnAppl    = eCommon.Common.CommonBean.isSiteSpecific(con,"MO","MO_BID_REGN");//Added by Thamizh selvi on 25th July 2017 for ML-MMOH-CRF-0689
        st               = con.createStatement();
	    rs               = st.executeQuery(getdate);
	    while( rs.next())
	    {
				 defaultdate1=rs.getString("date1")==null?"":rs.getString("date1");	 
		}

		if(defaultdate1!=null && !defaultdate1.equals(""))
		{
			defaultdate1 = DateUtils.convertDate(defaultdate1,"DMY","en",localeName); 	
		}
			
		
			if (rs!=null) rs.close();
			if (st!=null) st.close();

			st	 =	con.createStatement();
			rs=st.executeQuery("select patient_id_length from mp_param");
			while(rs.next())
			{
			patient_length = rs.getString(1);
			}
			if (rs!=null) rs.close();
			if (st!=null) st.close();
			

	
%>

    

	 
<script>
	var careArray=new Array();
	var i=1;	
</script>

</head>
<body  onMouseDown='CodeArrest()' onLoad='document.forms[0].search.click();'  onKeyDown="lockKey()">

 <center>
 <form name='AreaAvailForm' id='AreaAvailForm' target='messageFrame' >
 <table border='0' cellpadding='0' cellspacing='0' width='100%'>
  <tr>
  <td class='label' width='20%'><fmt:message key="eMO.DeceasedPatientID.label" bundle="${mo_labels}"/></td>
  <td class='fields' width='30%'><input type='text' name=patient_id  id=patient_id value="" maxLength='<%=patient_length%>' onBlur="ChangeCase(this);"  size='20' onKeyPress="return CheckForSpecChars(event);"><input type="button" name="patient_search" id="patient_search" class=BUTTON value="?" onClick="callpatientsearch(this,'<%=facility_id%>',patient_id)" ></td> 
  <td class='label' width='20%'><fmt:message key="eMO.BurialPermitNumber.label" bundle="${mo_labels}"/></td>
  <td class='fields' width='30%'><input type='text'  name='BURIAL_PERMIT_NO' id='BURIAL_PERMIT_NO' value=""  maxLength='16' size='20' 
  onKeyPress="return CheckForSpecCharsLocal(event)" ><input type="button" name="burialno_search" id="burialno_search" class=BUTTON value="?" onClick="callpatientsearch(this,'<%=facility_id%>',BURIAL_PERMIT_NO)" ></td>  
  </tr>  
  <tr>
   <td class='label'><fmt:message key="Common.DeceasedDate.label" bundle="${common_labels}"/></td>
   <td class='fields'><input type="text"  name="dec_date_time" id="dec_date_time" value='<%=defaultdate1%>' size=10 maxlength=10    onblur='validDateObj(this,"DMY",localeName);'><img src='../../eCommon/images/CommonCalendar.gif' id='decdate'  name='OTDate' onClick="document.forms[0].dec_date_time.select();return showCalendar('dec_date_time',null,null);"  tabindex=-1 style="cursor='hand'">&nbsp;/&nbsp;<input type="text"  value='<%=defaultdate1%>'  name="dec_date_time1" size=10 maxlength=10    tabindex='13' onblur='validDateObj(this,"DMY",localeName);'><input type='image' src='../../eCommon/images/CommonCalendar.gif' id='decdate1'  name='OTDate1' id='OTDate1' onClick="document.forms[0].dec_date_time1.select();return showCalendar('dec_date_time1',null,null);"  tabindex=-1> <img name='mandatory' src='../../eCommon/images/mandatory.gif'></img></td>   
   <td class='label'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
   <td class='fields'><select name="clinic_code" id="clinic_code" onchange="PopulateValues(this);">
   <option value='' >------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------</option>
		 <%						    
			 
				pstmt=con.prepareStatement("select short_desc,locn_type,care_locn_type_ind from am_care_locn_type_lang_vw where care_locn_type_ind in ('C','E','D') and locn_type in ('C','E','Y') and  SYS_USER_DEF_IND='S' and language_id = '"+localeName+"'order by short_desc");
				rs=pstmt.executeQuery() ;
					if(rs!=null)
					{
						while(rs.next())
								{
									String dat=rs.getString("short_desc");
									String id=rs.getString("locn_type");
									String careind=rs.getString("care_locn_type_ind");
									%>
									<option value='<%=id%>' ><%=dat%>
									<script>
										careArray[i]="<%=careind%>";
									      i++;
									</script>
									
									<%
																
									}%>
                        <option value='N'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>

							<%}

							if(pstmt != null) pstmt.close();
							if(rs != null) rs.close();
						}catch(Exception e)
	{
	out.println("Error"+e);
	}finally
	{
	 ConnectionManager.returnConnection(con,request);
	}
				%>
					
				
			 </select>&nbsp;/&nbsp;
		
		
		<SELECT name="clinic_code1" id="clinic_code1" onchange="PopulateValues(this)" >
		<option selected value="">------ <fmt:message key="Common.defaultSelect.label" 
		bundle="${common_labels}"/> ------</option></SELECT>
		</td>		
  <input type=hidden name=locationcode value=''>
  <input type=hidden name=locationcode1 value=''>
  <input type=hidden name='careind' id='careind' value=''>

  
  </tr>
  
	<tr>
	<td class='label'><fmt:message key="Common.broughtindead.label" bundle="${common_labels}"/></td>
	<td class='fields'><INPUT TYPE="checkbox" name="broughtindead" id="broughtindead" ></td>	
	<td class='label'><fmt:message key="eFM.MedicoLegalCase.label" bundle="${fm_labels}"/></td>
	<td class='fields'><INPUT TYPE="checkbox" name="mlcyn" id="mlcyn" ></td>	
	</tr>  	
<!-- </table>
<table border='0' cellpadding='0' cellspacing='0' width='100%'>  -->
	<tr>
		<td class='label' width='20%'><fmt:message key="eMO.ClinicalPostmortem.label" bundle="${mo_labels}"/></td>
		<td class='fields' width='30%'><INPUT TYPE="checkbox" name="pmyn" id="pmyn" ></td>	
		<td class='label' width='20%'><fmt:message key="eMO.RegisteredCases.label" bundle="${mo_labels}"/></td>
		<td class='fields'><INPUT TYPE="checkbox" name="regcase" id="regcase" ></td>
		
	</tr>
	<tr>
		
		<td class='button' colspan="4" align="right">
		<!--Added by Thamizh selvi on 21st July 2017 for ML-MMOH-CRF-0689 Start-->
		<% if(isBIDRegnAppl){ %>
			<input type='button' name='bidRegn' id='bidRegn' value='<fmt:message key="Common.bid.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Registration.label" bundle="${common_labels}"/>' class='button' onClick='openEmergRegn()'>
		<% } %>
		<!--End-->
		<input type='button' name='external' id='external' value='<fmt:message key="eMO.ExternalDeath.label" bundle="${mo_labels}"/>' class='button' onClick='toggle();'><!--bundle change for PAS-MO-PMG2020-TECH-CRF-0010/02-Label Name-->
		<input type='button' name='search' id='search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class='button' onClick='submitPage();'><input type='button' name='clear' id='clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' class='button' onclick='clearData()'></td>	
		</td>
</table>


  
 <!--  <tr>
		 <td align='right' class='white'colspan=8>
		 <input type='button' name='search' id='search' value='Search' class='button' onClick='submitPage();'>
		 <input type='button' name='clear' id='clear' value='Clear' class='button' onclick='clearData()'>
		 </td>
	</tr>
  --> 
  </table>
<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>

  </form>
 </center>
</body>
</html>

