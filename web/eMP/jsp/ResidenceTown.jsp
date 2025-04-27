<!DOCTYPE html>
<%--
/**
  *
  * @filename ResidenceTown.jsp
  * @version 3.0 updated on 2/19/2005
  */
--%>

<%@ page import ="webbeans.eCommon.ConnectionManager, java.sql.Connection, java.sql.PreparedStatement, java.sql.ResultSet" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle					=	checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css") ; 
	Connection con				=	null ;
	PreparedStatement stmt	=	null ;
	ResultSet rs					=	null ;
    String  postal_code_link_yn="";
	
	/*Below Line Added for this CRF [Bru-HIMS-CRF-256]*/
	int count_lang=0;
	String shortmaxlength="15";
	String longmaxlength="30";
	String shortsize="20";
	String longsize="35";
	
	 try {
		  con = ConnectionManager.getConnection(request);
		  stmt = con.prepareStatement("SELECT COUNT (*) dflt_lang_appl_cnt FROM sm_site_param a, sm_function_control b WHERE a.customer_id = b.site_id AND module_id = 'MP' AND functionality_id = 'MP_TOWN_MAST'");
	      rs = stmt.executeQuery();
      if( rs.next() )
	      {
		  count_lang=rs.getInt("dflt_lang_appl_cnt");		  
		  }
		  }catch(Exception e) {
			e.printStackTrace();
	}finally{
		if ( rs != null ) rs.close() ;
		if ( stmt != null ) stmt.close() ;
		
	}	
	if(count_lang>0){
	shortmaxlength="30";
	longmaxlength="60";
	shortsize="35";
    longsize="70";
	}	
/*Above Line Added for this CRF [Bru-HIMS-CRF-256]*/
%>

<html>
	<head>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
		
	</head>
	<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onLoad="Focusing('res_town_code')">
		<form name="res_town_form" id="res_town_form" action="../../servlet/eMP.ResidenceTownServlet" method="post" target="messageFrame">
		<BR><BR><BR><BR><BR><BR><BR><BR>
		<div align="left">
			<table border="0" cellpadding="3" cellspacing="0" width="75%" align='center'>
				<tr>
					<td width='40%'>&nbsp;</td>
					<td width='60%' colspan='2'></td>
				</tr>
				<tr>
					  <td width="40%" class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
					  <td width="60%" colspan="2" class='fields'><input type="text" name="res_town_code" id="res_town_code" size="6" maxlength="6" OnBlur="ChangeUpperCase(this)" onKeyPress="return CheckForSpecChars(event)"><img src='../images/mandatory.gif'></img></td>
				</tr>
				<!-- long and short description changed the maxlength for this [Bru-HIMS-CRF-256]-->
				<tr>
					<td width="40%" class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
					<td width="60%" colspan="2" class='fields'>
					<input type="text" name="long_desc" id="long_desc" size="<%=longsize%>" maxlength="<%=longmaxlength%>" onBlur='makeValidString(this)' style='{ font-size: ;}'><img src='../images/mandatory.gif'></img></td>
				</tr>
				<tr>
					<td width="40%" class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
					<td width="60%" colspan="2" class='fields'>
					<input type="text" name="short_desc" id="short_desc" size="<%=shortsize%>" maxlength="<%=shortmaxlength%>" onBlur='makeValidString(this)'><img src='../images/mandatory.gif'></img></td>
				</tr>
				
				<tr>
					<td width="40%" class="label"><fmt:message key="Common.area.label" bundle="${common_labels}"/></td>
					<td width="60%" colspan="2" class='fields'><select name="res_area_code" id="res_area_code">
					<option value='' selected>-------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------
<%
	 try {
		 // con = ConnectionManager.getConnection(request);
	      //String sql = "Select Res_Area_Code,Short_Desc from Mp_Res_Area where eff_status='E' and ( trunc(eff_date_from) <= trunc(sysdate) and trunc(eff_date_to) >= trunc(sysdate) ) or ( trunc(eff_date_from) <= trunc(sysdate) and eff_date_to is null ) or ( trunc(eff_date_to) >= trunc(sysdate) and trunc(eff_date_from) is null) or ( eff_date_from is null and eff_date_to is null ) order by Short_Desc";
	      String sql="Select Res_Area_Code,long_desc area_short_desc from Mp_Res_Area  where eff_status='E' and trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) order by area_short_desc ";
  	      stmt = con.prepareStatement(sql);
	      rs = stmt.executeQuery();
	      if( rs != null ){
			String classcode = "";
			String classname = "";
			while( rs.next() ){
				classcode = rs.getString( "res_area_code" ) ;
				classname = rs.getString( "area_short_desc" ) ;
%>
				<OPTION VALUE='<%= classcode %>'><%= classname %>
<%
	          }
	      }
	
	    if ( rs != null ) rs.close() ;
		if ( stmt != null ) stmt.close() ;
	stmt = con.prepareStatement("SELECT POSTAL_CODE_LINK_YN from  SM_SITE_PARAM");
	rs = stmt.executeQuery();
      if( rs != null )
	      {
	          while( rs.next() )
	          {
			postal_code_link_yn = rs.getString( "POSTAL_CODE_LINK_YN" ) ;
		        }
	      }
   	if ( rs != null ) rs.close() ;
	if ( stmt != null ) stmt.close() ;

	
	
	
	} catch(Exception e) {
		// out.println(e);
		e.printStackTrace();
	}finally{
		if ( rs != null ) rs.close() ;
		if ( stmt != null ) stmt.close() ;
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>
					</select> <%if(postal_code_link_yn.equals("Y")) {%>  <img src="../images/mandatory.gif"></img> <%}%> </td>
				</tr>

				<!--tr>
				  <td width="40%" class="label">Effective From </td>
				  <td width="13%" >&nbsp;&nbsp;&nbsp;--><input type="hidden" name="eff_date_from1" id="eff_date_from1" size="10"   maxlength="10">
				  <!--td width="47%" class="label">&nbsp;&nbsp;To&nbsp;&nbsp;&nbsp;--><input type="hidden" name="eff_date_to1" id="eff_date_to1" size="10"   maxlength="10"><!--/td-->
				<!--/tr-->

				  <!--tr>
					<td width='40%'>&nbsp;</td>
					<td width='60%' colspan='2'></td>
				</tr-->

				<tr>
					<td width="40%" class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
					<td width="60%" class='fields' colspan="2"><input type="checkbox" name="eff_status" id="eff_status" value="E" checked></td>
				</tr>

				<tr>
					<td width='40%'>&nbsp;</td>
					<td width='60%' colspan='2'></td>
				</tr>

		</table>
		</div>
		<input type="hidden" name="function" id="function" value="insert">
		<input type="hidden" name="function_name" id="function_name" value="insert">
		<input type="hidden" name="eff_date_from" id="eff_date_from" >
		<input type="hidden" name="eff_date_to" id="eff_date_to" >
	    <input type="hidden" name="postal_code_link_yn" id="postal_code_link_yn" value="<%=postal_code_link_yn%>" >
	</form>
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

