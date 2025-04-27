
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eMO/js/MOEmbalm.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	 Connection con               = null;
	 ResultSet rset	              = null;
	 PreparedStatement pstmt      = null;
     request.setCharacterEncoding("UTF-8");
	 String mode                  = "insert";
	 String	facilityId            = (String)session.getValue("facility_id" );
	 String start_num             = "";
	 String next_num              = "";
	 String max_num               = "";
	 String prefix_facility_id_yn = "";
	 String suffix_facility_id_yn = "";
	 String prefix_year_yn		  = "";
	 String suffix_year_yn		  = "";
	 String asso_dtls_reqd_yn     = "";
  try
	{

	 con = ConnectionManager.getConnection(request);
	 StringBuffer sql = new StringBuffer();
	 sql.setLength(0);
	 sql.append("select * from MO_EMBALM_NUM_CONTROL where FACILITY_ID=?");
	 pstmt= con.prepareStatement(sql.toString());
	 pstmt.setString(1,facilityId);
	 rset= pstmt.executeQuery();
	 sql.setLength(0);
     if(rset!=null)
     {
		 while(rset.next())
		 {
			start_num = rset.getString("start_num");
			next_num = rset.getString("next_num");
			max_num = rset.getString("max_num");
			asso_dtls_reqd_yn = rset.getString("asso_dtls_reqd_yn");
			prefix_facility_id_yn = rset.getString("prefix_facility_id_yn");
			suffix_facility_id_yn = rset.getString("suffix_facility_id_yn");
			prefix_year_yn = rset.getString("prefix_year_yn");
			suffix_year_yn = rset.getString("suffix_year_yn");
			mode = "modify";
		 }
	 }
 %>
	 <body onLoad = 'FocusFirstElement();anumberformat();prefixsuffixcheck();' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	 <form name="PostmortemForm" id="PostmortemForm" action="../../servlet/eMO.MOEmbalmNumControlServlet" method="post" target="messageFrame">
	 <br>
	 <br>
	 <table border="0" cellpadding="5" cellspacing="0" align='center' width='100%'>
	   <tr>		      
		      <td class='label' width='30%'><fmt:message key="eMO.StartingEmbalmNo.label" bundle="${mo_labels}"/></td>
		      <td class='fields' width='16%'>
			  <%if(mode.equals("insert")){%>
			  <INPUT TYPE="text" name="start_num" id="start_num" maxLength='10' size='10' value='' onkeypress="return allowValidNumber(this,event,2,0);" onblur='if(ChkPosNum(this)){nextdefault();}'>
			  <%}else{%>
			  <INPUT TYPE="text" name="start_num" id="start_num" maxLength='10' size='10' value='<%=start_num%>' onkeypress="return allowValidNumber(this,event,2,0);" onblur='if(ChkPosNum(this)){anumberformat();}' disabled><%}%>
				  <img src='../../eCommon/images/mandatory.gif'align='center'></img>
			  </td> 	

		      <td width='13%'>&nbsp;</td>
	    </tr>
		<tr>		      
		      <td class='label'><fmt:message key="eMO.NextEmbalmNo.label" bundle="${mo_labels}"/></td>
		      <td class='fields'>
			  <%if(mode.equals("insert")){%>
			  <INPUT TYPE="text" name="next_num" id="next_num" maxLength='10' size='10' value='' disabled>
			  <%}else{%>
			   <INPUT TYPE="text" name="next_num" id="next_num" maxLength='10' size='10' value='<%=next_num%>' disabled> <%}%>
			   <img src='../../eCommon/images/mandatory.gif'align='center'></img>
			  </td> 	

		      <td >&nbsp;</td>
	    </tr>
		<tr>		      
		      <td class='label' ><fmt:message key="eMO.EndEmbalmNo.label" bundle="${mo_labels}"/></td>
		      <td class='fields'>
			  <%if(mode.equals("insert")){%>
			  <INPUT TYPE="text" name="end_num" id="end_num" maxLength='10' size='10' value='' onkeypress="return allowValidNumber(this,event,2,0);" onblur='if(ChkPosNum(this)){numcheck(this);}'>
			  <%}else{%>
			  <INPUT TYPE="text" name="end_num" id="end_num" maxLength='10' size='10' onkeypress="return allowValidNumber(this,event,2,0);" value='<%=max_num%>' onblur='if(ChkPosNum(this)){numcheck(this);}' onfocus='anumberformat()'><%}%>
			  <img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
				   	

		      <td >&nbsp;</td>
	    </tr>
        <tr>	     
		      <td class='label'><fmt:message key="eMO.EmbalmNoDetailsRequired.label" bundle="${mo_labels}"/> </td>
		      <td class='fields'>
			  <%if(mode.equals("insert")){%>
			  <INPUT TYPE="checkbox" name="post_associate_details" id="post_associate_details" onclick='prefixsuffixcheck();anumberformat()'>
			  <%}else{%>
			  <%if(asso_dtls_reqd_yn.equals("Y")){%>
			  <INPUT TYPE="checkbox" name="post_associate_details" id="post_associate_details" checked  onclick='prefixsuffixcheck();anumberformat()' value="Y" >
			  <%}if(asso_dtls_reqd_yn.equals("N")){%>
			  <INPUT TYPE="checkbox" name="post_associate_details" id="post_associate_details"  onclick='prefixsuffixcheck();anumberformat()' value="N">
				<%}}%>
			  </td> 	
		     <td >&nbsp;</td>
	    </tr>
		<tr>	     
		     <td class='label'></td>
		     <td class='label'><fmt:message key="eMO.PrefixSuffix.label" bundle="${mo_labels}"/>
		     </td> 	
		     <td>&nbsp;</td>
	    </tr>
		<tr>	     
		     <td class='label'><fmt:message key="Common.FacilityID.label" bundle="${common_labels}"/></td>
		     <td class='fields'>
			 <%if(mode.equals("insert")){%>
			 <INPUT TYPE="checkbox" name="prefix_facility_id_yn" id="prefix_facility_id_yn" value="N" disabled onclick='prefixfacilitycheck(this);anumberformat()'>
			 <%}else{%>
			 <%if(prefix_facility_id_yn.equals("Y")){%>
			 <INPUT TYPE="checkbox" name="prefix_facility_id_yn" id="prefix_facility_id_yn" value="Y" checked  onclick='prefixfacilitycheck(this);anumberformat()'>
			 <%}if(prefix_facility_id_yn.equals("N")){%>
			 <INPUT TYPE="checkbox" name="prefix_facility_id_yn" id="prefix_facility_id_yn" value="N" disabled onclick='prefixfacilitycheck(this);anumberformat()'>
			 <%}}%>
			 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			 <%if(mode.equals("insert")){%>
			 <INPUT TYPE="checkbox" name="suffix_facility_id_yn" id="suffix_facility_id_yn" value="N" disabled onclick='suffixfacilitycheck(this);anumberformat()'>
			 <%}else{%>
			 <%if(suffix_facility_id_yn.equals("Y")){%>
		     <INPUT TYPE="checkbox" name="suffix_facility_id_yn" id="suffix_facility_id_yn" value="Y" checked  onclick='suffixfacilitycheck(this);anumberformat()'>
			 <%}if(suffix_facility_id_yn.equals("N")){%>
			 <INPUT TYPE="checkbox" name="suffix_facility_id_yn" id="suffix_facility_id_yn" value="N" disabled onclick='suffixfacilitycheck(this);anumberformat()'>
			 <%}}%>
			 </td> 	
		     <td >&nbsp;</td>
	    </tr>
		<tr>	     
		     <td class='label'><fmt:message key="Common.year.label" bundle="${common_labels}"/>
			 </td>
		     <td class='fields'>
			 <%if(mode.equals("insert")){%>
			 <INPUT TYPE="checkbox" name="prefix_year_yn" id="prefix_year_yn" value="N" disabled onclick='prefixyearcheck(this);anumberformat()'>
		  	 <%}else{%>
			 <%if(prefix_year_yn.equals("Y")){%>
    		 <INPUT TYPE="checkbox" name="prefix_year_yn" id="prefix_year_yn" value="Y" checked  onclick='prefixyearcheck(this);anumberformat()'>
			 <%}if(prefix_year_yn.equals("N")){%>
			 <INPUT TYPE="checkbox" name="prefix_year_yn" id="prefix_year_yn" value="N" disabled onclick='prefixyearcheck(this);anumberformat()'>
			 <%}}%>
			 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			 <%if(mode.equals("insert")){%>
			 <INPUT TYPE="checkbox" name="suffix_year_yn" id="suffix_year_yn" value="N" disabled onclick='suffixyearcheck(this);anumberformat();'>
			 <%}else{%>
			 <%if(suffix_year_yn.equals("Y")){%>
			 <INPUT TYPE="checkbox" name="suffix_year_yn" id="suffix_year_yn" value="Y" checked  onclick='suffixyearcheck(this);anumberformat();'> 
			 <%}if(suffix_year_yn.equals("N")){%>
			 <INPUT TYPE="checkbox" name="suffix_year_yn" id="suffix_year_yn" value="N" disabled onclick='suffixyearcheck(this);anumberformat();'>
			 <%}}%>
			 </td> 	
		     <td >&nbsp;</td>
	    </tr>
		<tr>		      
		     <td class='label' ><fmt:message key="eMO.EmbalmNoFormat.label" bundle="${mo_labels}"/></td>
		     <td class='fields'><INPUT TYPE="text" name="post_number_format" id="post_number_format"  maxlength='15' disabled >
			 </td> 	
    	     <td >&nbsp;</td>
	    </tr>
	 </table>
	   	 <input type='hidden' name='mode' id='mode' value='<%=mode%>'>	 
    </form>
    </body>
 <%
	if (rset!=null) rset.close();
	if (pstmt!=null) pstmt.close();
	}
	catch(Exception e)
	{
		out.println(e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
</html>


