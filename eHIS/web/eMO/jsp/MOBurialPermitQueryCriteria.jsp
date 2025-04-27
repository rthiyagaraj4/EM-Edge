<!DOCTYPE html>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
	<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");
     String	facility_id			=  (String) session.getValue( "facility_id" ) ;
	 String patient_length		=   "";
	 Connection con				=	null;
	 Statement	st				=	null;
	 PreparedStatement pstmt	=	null;
	 ResultSet	rs				=	null;
	 String defaultdate1		=	"";
	 String locale		        = (String)session.getAttribute("LOCALE");
			 
	 try 
		{	
		String getdate			=	"select to_char(sysdate,'dd/mm/yyyy') date1	from dual";
        con						=	(Connection)ConnectionManager.getConnection(request);

        st						=	con.createStatement();
	    rs						=	st.executeQuery(getdate);
	    while( rs.next())
	    {
			defaultdate1		=	rs.getString("date1");
	    }
		if (rs!=null) rs.close();
		if (st!=null) st.close();
			
		st						=	con.createStatement();
		rs						=	st.executeQuery("select patient_id_length from mp_param");
		while(rs.next())
		{
			patient_length		=	rs.getString(1);
		}
		if (rs!=null) rs.close();
		if (st!=null) st.close();

%>

    <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link   rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/dchk.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script> 
	<script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></Script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language='javascript' src='../../eMO/js/MOBurialPermit.js'> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	 
<script>
	var careArray	=	new Array();
	var i			=	1;
</script>

</head>
<body  onMouseDown='CodeArrest()' onLoad='document.forms[0].search.click();' onKeyDown="lockKey()">
 <center>
 <form name='burialform' id='burialform' target='messageFrame' >
 <table border='0' cellpadding='2' cellspacing='0' width='100%'>
  <tr>
		<td class=label width='25%'><fmt:message key="eMO.DeceasedPatientID.label" bundle="${mo_labels}"/></td>
		<td class='field' width='25%'><input type='text'  name='patient_id' id='patient_id'  value="" maxLength='<%=patient_length%>'   size='20' onKeyPress="return CheckForSpecChars(event);"><input type="button" name="patient_search" id="patient_search" class=BUTTON value="?" onClick="callpatientsearch(this,'<%=facility_id%>',patient_id)" >	</td>
        <td width='25%'>&nbsp;</td>
        <td width='25%'>&nbsp;</td>
   </tr>
  <tr>
		<td class=label width='25%'><fmt:message key="Common.DeceasedDate.label" bundle="${common_labels}"/></td>
		<td class='field' colspan='2'><input type="text"  name="dec_date_time" id="dec_date_time" value='<%=DateUtils.convertDate(defaultdate1,"DMY","en",locale)%>' size=10 maxlength=10    onblur='if(this.value!="")CheckDateBurPermit(this,dec_date_time1)'><input type='image' src='../../eCommon/images/CommonCalendar.gif' id='decdate'  name='OTDate' id='OTDate' onClick="document.forms[0].dec_date_time.select();return showCalendar('dec_date_time',null,null);"  tabindex=-1>&nbsp;/&nbsp;<input type="text"    name="dec_date_time1" id="dec_date_time1" size=10 maxlength=10   value ="<%=DateUtils.convertDate(defaultdate1,"DMY","en",locale)%>" tabindex='13' onblur='if(this.value!="")todatecheck(dec_date_time,this)'><input type='image' src='../../eCommon/images/CommonCalendar.gif' id='decdate1'  name='OTDate1' id='OTDate1' onClick="document.forms[0].dec_date_time1.select();return showCalendar('dec_date_time1',null,null);"  tabindex=-1> <img name='mandatory' src='../../eCommon/images/mandatory.gif'></img></td>
		<td width='25%'>&nbsp;</td>
   </tr>
   <tr>

	 <td class=label width='25%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
     <td class='field' colspan='2'><select name="clinic_code" id="clinic_code" onchange="PopulateValues(this);">
	 <option value='' >------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------</option>
		 <%						    
			
				pstmt=con.prepareStatement("select short_desc,locn_type,care_locn_type_ind from am_care_locn_type_lang_vw where care_locn_type_ind in ('C','E','D') and locn_type in ('C','E','Y') and  SYS_USER_DEF_IND='S' and language_id='"+locale+"' order by short_desc");
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
		<option selected value="">---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option></SELECT>
		</td>
	  <input type='hidden' name='locationcode' id='locationcode' value=''>
	  <input type='hidden' name='locationcode1' id='locationcode1' value=''>
	  <input type='hidden' name='careind' id='careind' value=''>
      <td width='25%'>&nbsp;</td>
   </tr>
   <tr>
		 <td class='button' colspan=4 style="text-align: right;">
		 <input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='button' onClick='submitPage();'>
		 <input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='button' onclick='clearData()'>
		 </td>
	</tr>
  
  </table>
	
<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
<input type='hidden' name='locale' id='locale' value='<%=locale%>'>

  </form>
 </center>
</body>
</html>

