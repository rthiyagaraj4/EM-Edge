<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html> 
<head>
<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script language='javascript' src='../../eMO/js/MORegistration.js'></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
	<%	
		Connection con 			    = null;
		Statement stmt	            = null;
		ResultSet rset				= null;
	   request.setCharacterEncoding("UTF-8");
		String	facilityId 			= (String) session.getValue( "facility_id" ) ;
		String mode				    = "";
		try
	    {
		con					                = ConnectionManager.getConnection(request);
		String	  START_NUM                 = "";
		String	  NEXT_NUM                  = ""; 
		String	  MAX_NUM                   = ""; 
		String	  ASSO_DTLS_REQD_YN         = "";	
		String	  PREFIX_FACILITY_ID_YN     = "";
		String	  SUFFIX_FACILITY_ID_YN     = "";
		String	  PREFIX_YEAR_YN		    = "";	
		String	  SUFFIX_YEAR_YN		    = "";
		String checkBoxAttribute			= "";
		String checkBoxAttribute1			= "";
		String checkBoxAttribute2			= "";
		String checkBoxAttribute3			= "";
		String checkBoxAttribute4			= "";
		String Chk_Status1					= "";
		String Chk_Status2					= "";
		String Chk_Status3					= "";
		String Chk_Status4					= "";
		String Addmodify					= "";
		mode							    = "INSERT";
		StringBuffer  sql					= new StringBuffer();
		sql.setLength(0);
		sql.append("select START_NUM,NEXT_NUM,MAX_NUM,ASSO_DTLS_REQD_YN,PREFIX_FACILITY_ID_YN, SUFFIX_FACILITY_ID_YN,PREFIX_YEAR_YN,SUFFIX_YEAR_YN from MO_REGN_NUM_CONTROL where FACILITY_ID='"+facilityId +"' ");
		stmt								= con.createStatement();
		rset								= stmt.executeQuery(sql.toString());
		sql.setLength(0);
		while(rset!=null && rset.next())
		{
			START_NUM			      = rset.getString("START_NUM"); 
			START_NUM 		          = (START_NUM == null)?"":START_NUM;
			NEXT_NUM			      = rset.getString("NEXT_NUM");
			NEXT_NUM 			      = (NEXT_NUM == null)?"":NEXT_NUM;
			MAX_NUM				      = rset.getString("MAX_NUM");
			MAX_NUM 			      = (MAX_NUM == null)?"":MAX_NUM;
			ASSO_DTLS_REQD_YN	      = rset.getString("ASSO_DTLS_REQD_YN"); 
			if(ASSO_DTLS_REQD_YN!= null && ASSO_DTLS_REQD_YN.equalsIgnoreCase("Y"))
				 checkBoxAttribute    = "CHECKED";					
			PREFIX_FACILITY_ID_YN     = rset.getString("PREFIX_FACILITY_ID_YN");
			if(PREFIX_FACILITY_ID_YN!= null && PREFIX_FACILITY_ID_YN.equalsIgnoreCase("Y"))				
				 checkBoxAttribute1   = "CHECKED";
			else 
				 Chk_Status1	      = "DISABLED";
			SUFFIX_FACILITY_ID_YN	  = rset.getString("SUFFIX_FACILITY_ID_YN");
			if(SUFFIX_FACILITY_ID_YN!= null && SUFFIX_FACILITY_ID_YN.equalsIgnoreCase("Y"))
			checkBoxAttribute2        = "CHECKED";
			else Chk_Status2	      = "DISABLED";			
			PREFIX_YEAR_YN		      = rset.getString("PREFIX_YEAR_YN");
			if(PREFIX_YEAR_YN!= null && PREFIX_YEAR_YN.equalsIgnoreCase("Y"))
			checkBoxAttribute3        = "CHECKED";
			else Chk_Status3	      = "DISABLED";
			SUFFIX_YEAR_YN		      = rset.getString("SUFFIX_YEAR_YN");
			if(SUFFIX_YEAR_YN!= null && SUFFIX_YEAR_YN.equalsIgnoreCase("Y"))
			checkBoxAttribute4        = "CHECKED";
			else Chk_Status4	      = "DISABLED";
			mode					  = "MODIFY";
			if(mode!= null && mode.equalsIgnoreCase("MODIFY"))
				Addmodify             = "DISABLED";
	  }
	  if(rset!=null)  rset.close();
	  if(stmt!=null)  stmt.close();
    %>
	 <body onLoad = 'FocusFirstElement();checkout(this);prefixsuffixcheck();'OnMouseDown='CodeArrest();' onKeyDown = 'lockKey()'>
	 <form name="MORegistration_form" id="MORegistration_form" action="../../servlet/eMO.MORegistrationNumControlServlet" method="post" target="messageFrame">
	 <br>
	 <br>
	 <table border="0" cellpadding="5" cellspacing="0" align='center' width='100%'>
	 <tr>	
		<td class='label' width='30%'><fmt:message key="eMO.MortuaryRegStartNo.label" bundle="${mo_labels}"/></td>
		<td class='fields' width='16%'><INPUT TYPE="text" name="mortuary_start_num" id="mortuary_start_num" onkeypress="return allowValidNumber(this,event,2,0);" maxLength='10' size='10'   value='<%=START_NUM%>'<%=Addmodify%>
			OnBlur='if(ChkPosNum(this)){checkout(this);document.forms[0].mortuary_next_num.value=this.value;chkzero(this);}'>
			<img src='../../eCommon/images/mandatory.gif' align='center'></img>
	    </td> 	
        <td width='13%'>&nbsp;</td>
    </tr>
	<tr>		      
		<td class='label' ><fmt:message key="eMO.MortuaryNextRegNo.label" bundle="${mo_labels}"/></td>
		<td class='fields' ><INPUT TYPE="text" name="mortuary_next_num" id="mortuary_next_num" maxLength='10'  size='10' value='<%=NEXT_NUM%>'   disabled  onBlur='' >
		   <img src='../../eCommon/images/mandatory.gif'align='center'></img>	  
		</td> 	

		<td>&nbsp;</td>
	</tr>
	<tr>		      
		<td class='label' ><fmt:message key="eMO.MortuaryRegEndNo.label" bundle="${mo_labels}"/></td>
		<td class='fields'><INPUT TYPE="text" name="mortuary_max_num" id="mortuary_max_num" maxLength='10' size='10' value='<%=MAX_NUM%>' onkeypress="return  allowValidNumber(this,event,2,0);" onBlur='if(ChkPosNum(this)){checkout(this);chkgrt(this);}'>
			<img src='../../eCommon/images/mandatory.gif'align='center'></img>	  
		</td> 	
		<td >&nbsp;</td>
    </tr>
	<tr>	     
		  <td class='label'><fmt:message key="eMO.MortuaryRegNoRequired.label" bundle="${mo_labels}"/> </td>
		  <td class='fields' ><INPUT TYPE="checkbox"  name="asso_dtls_reqd_yn" id="asso_dtls_reqd_yn"  value='<%=ASSO_DTLS_REQD_YN%>'<%=checkBoxAttribute%> onClick='prefixsuffixcheck();checkout(this)' onBlur=''>
		  </td> 	
		  <td >&nbsp;</td>
	</tr>
	<tr>	     
		  <td class='label' ></td>
		  <td class='label' ><fmt:message key="eMO.PrefixSuffix.label" bundle="${mo_labels}"/></td> 	
		  <td >&nbsp;</td>
	</tr>
	<tr>	     
		  <td class='label'><fmt:message key="Common.FacilityID.label" bundle="${common_labels}"/></td>
		  <td class='fields'><INPUT TYPE="checkbox" name="prefix_facility_id" id="prefix_facility_id" value='<%=PREFIX_FACILITY_ID_YN%>'<%=checkBoxAttribute1%> <%=Chk_Status1%>  onClick='prefixfacilitycheck(this);checkout(this);'> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<INPUT TYPE="checkbox" name="suffix_facility_id" id="suffix_facility_id" value='<%=SUFFIX_FACILITY_ID_YN%>' <%=checkBoxAttribute2%> <%=Chk_Status2%> onClick='suffixfacilitycheck(this);checkout(this);'>
		  </td> 	
		  <td >&nbsp;</td>
	</tr>
	<tr>	     
	      <td class='label'><fmt:message key="Common.year.label" bundle="${common_labels}"/> </td>
	      <td class='fields'><INPUT TYPE="checkbox" name="prefix_year" id="prefix_year" value='<%=PREFIX_YEAR_YN%>' <%=checkBoxAttribute3%> <%=Chk_Status3%> onClick='prefixyearcheck(this);checkout(this);'> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<INPUT TYPE="checkbox" name="suffix_year" id="suffix_year" value='<%=SUFFIX_YEAR_YN%>' <%=checkBoxAttribute4%> <%=Chk_Status4%> onClick='suffixyearcheck(this);checkout(this);'></td> 	
	      <td >&nbsp;</td>
	</tr>
	<tr>        
	      <td class='label'><fmt:message key="eMO.DeceasedMortuaryRegNoFormat.label" bundle="${mo_labels}"/></td>
	      <td class='fields'><INPUT TYPE="text" name="calculate" id="calculate" maxlength='16' disabled ></td> 	
	      <td >&nbsp;</td>
	</tr>
	</table>
	<input type='hidden' name='mode' id='mode' value='<%=mode%>' >	
 </form>
 </body>
	 <%
            if(rset!=null) rset.close(); 
    	    if(stmt!=null) stmt.close();	 
     }
	 catch(Exception e){out.println(e.toString());}
	 finally
     {
      ConnectionManager.returnConnection(con,request);
     }
	%>
</html>


