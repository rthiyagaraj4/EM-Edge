<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<%
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
    String postal_code_link_yn ="";
    Boolean isGSTCodeApplicable = false; //Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132

try {
	con = ConnectionManager.getConnection(request);
	//Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132
	isGSTCodeApplicable = eCommon.Common.CommonBean.isSiteSpecific(con, "MP", "GST_CODE");

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<!--Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132-->
<script src="../js/Region.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()" onKeyDown='lockKey();' OnLoad="Focusing('region_code')">
<form name="region_form" id="region_form" action="../../servlet/eMP.RegionServlet" method="post" target="messageFrame">
<BR><BR><BR><BR><BR><BR><BR><BR><BR>
<div align="left">
  <table border="0" cellpadding="3" cellspacing="0" width="75%" align='center'>

  <tr>
  	<td width='40%'>&nbsp;</td>
  	<td width='60%' colspan='2'>&nbsp;</td>
  </tr>

    <tr>
      <td width="40%" class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      <td width="60%" colspan="2" class='fields'><input type="text" name="region_code" id="region_code" size="6" maxlength="6" OnBlur="ChangeUpperCase(this)" onKeyPress="return CheckForSpecChars(event)"><img src='../images/mandatory.gif'></img>
      </td>
    </tr>

	<!--Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132-->
	<%if(isGSTCodeApplicable)
	{%>
	<tr>
      <td width="40%" class="label"><fmt:message key="Common.GoodsandServicesTax.label" bundle="${common_labels}"/> <fmt:message key="eMP.Regioncode.label" bundle="${mp_labels}"/></td>
      <td width="60%" colspan="2" class='fields'><input type="text" name="GST_Region" id="GST_Region" size="2" maxlength="2" onKeyPress="return NumChkForRegion(event);" onBlur="ZeroChkForRegion(this);CodeLen(this)"><img src='../images/mandatory.gif'></img>
      </td>
    </tr>
	<%}%>

    <tr>
      <td width="40%" class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
      <td width="60%" colspan="2" class='fields'><input type="text" name="long_desc" id="long_desc" size="30" maxlength="30" onBlur='makeValidString(this)'><img src='../images/mandatory.gif'></img></td>
    </tr>

         <tr>
      <td width="40%" class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
      <td width="60%" colspan="2" class='fields'><input type="text" name="short_desc" id="short_desc" size="15" maxlength="15" onBlur='makeValidString(this)'><img src='../images/mandatory.gif'></img></td>
    </tr>

 <tr>
      <td width="40%" class="label"><fmt:message key="Common.country.label" bundle="${common_labels}"/></td>
      <td width="60%" colspan="2" class='fields'><select name="country_code" id="country_code"><option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option> 
	  <%

	      String sql="Select country_Code,SHORT_NAME country_short_desc  from Mp_country where eff_status='E' and trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) order by country_short_desc ";
		pstmt = con.prepareStatement( sql);
		rs = pstmt.executeQuery();

	      if( rs != null )
	      {
	          while( rs.next() )
	          {
			String classcode = rs.getString( "country_Code" ) ;
			String classname = rs.getString( "country_short_desc" ) ;
%>
			<OPTION VALUE='<%= classcode %>' ><%= classname %>
<%
	          }
	      }
   	if ( rs != null ) rs.close() ;
	if ( pstmt != null ) pstmt.close() ;
	pstmt = con.prepareStatement("SELECT POSTAL_CODE_LINK_YN from  SM_SITE_PARAM");
	rs = pstmt.executeQuery();
      if( rs != null )
	      {
	          while( rs.next() )
	          {
			postal_code_link_yn = rs.getString( "POSTAL_CODE_LINK_YN" ) ;
		        }
	      }
   	if ( rs != null ) rs.close() ;
	if ( pstmt != null ) pstmt.close() ;



} catch(Exception e) { 
	// out.println(e.toString());
	e.printStackTrace();
}finally{
 	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
    </select><img src="../images/mandatory.gif"></img></td>
	  </tr>
  <!--tr>
      <td width="40%"  class="label" >Effective From </td>
      <td width="13%" >&nbsp;&nbsp;&nbsp;--><input type="hidden" name="eff_date_from1" id="eff_date_from1" size="10"   maxlength="10"><!--/td-->
      <!--td width="47%"  class="label">&nbsp;&nbsp;To&nbsp;&nbsp;&nbsp;--><input type="hidden" name="eff_date_to1" id="eff_date_to1" size="10"  maxlength="10"><!--/td-->
    <!--/tr-->

	  <!--tr>
	  	<td width='40%'>&nbsp;</td>
	  	<td width='60%' colspan='2'>&nbsp;</td>
  </tr-->

	<tr>
	<td class="label" width="40%"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
    <td class='fields' width="60%" colspan="2"><input type="checkbox" name="eff_status" id="eff_status" value="E" checked></td></tr>

    <tr>
    	<td width='40%'>&nbsp;</td>
    	<td width='60%' colspan='2'>&nbsp;</td>
  </tr>

  </table>
</div>
<input type="hidden" name="function" id="function" value="insert">
<input type="hidden" name="function_name" id="function_name" value="insert">
<input type="hidden" name="eff_date_from" id="eff_date_from" >
<input type="hidden" name="eff_date_to" id="eff_date_to" >

<!--Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132-->
<input type="hidden" name="isGSTCodeApplicable" id="isGSTCodeApplicable" value="<%=isGSTCodeApplicable%>">

</form>
</body>
</html>

