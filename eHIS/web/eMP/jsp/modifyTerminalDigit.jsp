<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<% String facility_id = request.getParameter("facility_id"); %>
<%
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rset=null;

	String facility_name = "";
	String Chart = "";
	String Numbering ="";
	String Soundex ="";
	String CardTitle ="";
	String Line1 ="";
	String Line2 ="";
	String Line3 ="";
	String Line4 ="";
	String Line5 ="";
	String Line6 ="";
	String Line7 ="";
	String Line8 ="";
	String Line9 ="";
	String Line10 ="";
	String terminal_digit_count="";
	String terminal_digit1_position="";
	String terminal_digit2_position="";
	String terminal_digit3_position="";
	String terminal_digit4_position="";
	String terminal_digit5_position="";
	String tm_req="";
    PreparedStatement pstmt1 =null;
	ResultSet rs3=null;
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<script src="../../eMP/js/FacilityLevel.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body  OnMouseDown='CodeArrest()' onLoad="FocusFirstElement()" onKeyDown = 'lockKey()'>
<form name="facility_level_form" id="facility_level_form" action="../../servlet/eMP.FacilityLevelServlet" method="post" target="messageFrame">
<%
	try {
		con = ConnectionManager.getConnection(request);
		pstmt=con.prepareStatement("Select facility_name from sm_facility_param where facility_id ='"+facility_id+"' order by facility_name");
		rset = pstmt.executeQuery();
		if (rset.next()) facility_name = rset.getString("facility_name");
		try{
			pstmt1 = con.prepareStatement("Select terminal_digit_reqd_yn from mp_param");
		rs3= pstmt1.executeQuery();
		if(rs3.next())
		{
			tm_req=rs3.getString(1);
			if(tm_req==null)tm_req="N";
		}
		pstmt=con.prepareStatement("select Single_Or_Multi_Files_Ind, Separate_File_No_Yn, Dflt_Sndx_Type,Id_Card_Title,terminal_digit_count, terminal_digit1_position,terminal_digit2_position, terminal_digit3_position,terminal_digit4_position, terminal_digit5_position,Line1_Face_Sheet_Text,Line2_Face_Sheet_Text, Line3_Face_Sheet_Text,Line4_Face_Sheet_Text,Line5_Face_Sheet_Text,Line6_Face_Sheet_Text,  Line7_Face_Sheet_Text,Line8_Face_Sheet_Text,Line9_Face_Sheet_Text,Line10_Face_Sheet_Text from mp_param_for_facility where facility_id='"+facility_id+"'");
			rset = pstmt.executeQuery();
			if(rset.next()) 
			{
		    	terminal_digit_count = rset.getString("terminal_digit_count")==null ? "" : rset.getString("terminal_digit_count");
		    	terminal_digit1_position = rset.getString("terminal_digit1_position")==null ? "" : rset.getString("terminal_digit1_position");
		    	terminal_digit2_position = rset.getString("terminal_digit2_position")==null ? "" : rset.getString("terminal_digit2_position");
		    	terminal_digit3_position = rset.getString("terminal_digit3_position")==null ? "" : rset.getString("terminal_digit3_position");
		    	terminal_digit4_position = rset.getString("terminal_digit4_position")==null ? "" : rset.getString("terminal_digit4_position");
		    	terminal_digit5_position = rset.getString("terminal_digit5_position")==null ? "" : rset.getString("terminal_digit5_position");
			Chart = rset.getString("Single_Or_Multi_Files_Ind")==null ? "S" : rset.getString("Single_Or_Multi_Files_Ind").trim();
			Numbering = rset.getString("Separate_File_No_Yn")==null ? "N" : rset.getString("Separate_File_No_Yn").trim();
			Soundex = rset.getString("Dflt_Sndx_Type")==null ? "" : rset.getString("Dflt_Sndx_Type").trim();
			CardTitle = rset.getString("Id_Card_Title")== null ? "" : rset.getString("Id_Card_Title").trim();
			Line1 = rset.getString("Line1_Face_Sheet_Text")==null ? "" : rset.getString("Line1_Face_Sheet_Text").trim();
			Line2 = rset.getString("Line2_Face_Sheet_Text")==null ? "" : rset.getString("Line2_Face_Sheet_Text").trim();
			Line3 = rset.getString("Line3_Face_Sheet_Text")==null ? "" : rset.getString("Line3_Face_Sheet_Text").trim();
			Line4 = rset.getString("Line4_Face_Sheet_Text")==null ? "" : rset.getString("Line4_Face_Sheet_Text").trim();
			Line5 = rset.getString("Line5_Face_Sheet_Text")==null ? "" : rset.getString("Line5_Face_Sheet_Text").trim();
			Line6 = rset.getString("Line6_Face_Sheet_Text")==null ? "" : rset.getString("Line6_Face_Sheet_Text").trim();
			Line7 = rset.getString("Line7_Face_Sheet_Text")==null ? "" : rset.getString("Line7_Face_Sheet_Text").trim();
			Line8 = rset.getString("Line8_Face_Sheet_Text")==null ? "" : rset.getString("Line8_Face_Sheet_Text").trim();
			Line9 = rset.getString("Line9_Face_Sheet_Text")==null ? "" : rset.getString("Line9_Face_Sheet_Text").trim();
			Line10 = rset.getString("Line10_Face_Sheet_Text") ==null ? "" : rset.getString("Line10_Face_Sheet_Text").trim();
			}
		}catch(Exception e) { out.println(e.toString());}
		finally
		{
			if (pstmt != null) pstmt.close();
			if (rset != null) rset.close();
		}
		
	}catch(Exception e) { out.println(e.toString());}
	finally
	{
		if (pstmt != null) pstmt.close();
		if (rset != null) rset.close();
		if (pstmt1 != null) pstmt1.close();
		if (rs3 != null) rs3.close();		
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>
<div align="left">
  <table border="0" cellpadding="0" cellspacing="0" width="100%">
    <tr>
    	<td width="40%">&nbsp;</td>
    	 <td width="60%">&nbsp;</td>
  </tr>
    <tr>
      <td width="35%" align="right" class="label"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
      <td width="65%" align=left>&nbsp; <input type="text" name="Facility_Name" id="Facility_Name" value="<%=facility_name%>" size='40' readonly></td>
    </tr>
	<%
			if(tm_req.equals("N"))
			{
		%>

  <tr>
	  	<td width="40%">&nbsp;</td>
	  	 <td width="60%">&nbsp;</td>
  </tr> <% } %>
    </table>
    <table border="0" cellpadding="0" cellspacing="0" width="100%">
  	<tr>
    		<th align=left><b><fmt:message key="eMP.MedicalRecordAdministration.label" bundle="${mp_labels}"/></b></th>
    	</tr>
    </table>

  <table border="0" cellpadding="0" cellspacing="0" width="100%">
  	<tr>
  	    	<td width="100%" class="BORDER">
  			<table border="0" cellpadding="0" cellspacing="0" width="100%">
    			<tr>
  				<td align=left width=35% class="label" colspan=2>&nbsp;<b><fmt:message key="eMP.ChartMaintenance.label" bundle="${mp_labels}"/></b></td>
    				<td align=left width=40% class="label" colspan=2>&nbsp;<b><fmt:message key="eMP.NumberingControl.label" bundle="${mp_labels}"/></b></td>
    				<td align=left width=25% class="label" colspan=2>&nbsp;<b><fmt:message key="eMP.DefaultSoundexType.label" bundle="${mp_labels}"/></b></td>
    			</tr>
    			<tr>
    				<td align="left" class="label" width=5%>&nbsp;&nbsp;
				<%
					String Numdisable = "";
					String SeparateCheck = "checked";
					//String MRNSameCheck = "";
					if(Chart.equals("M")) 
						Numdisable = "disabled";
					/*if(Numbering.equals("Y"))
					{
						SeparateCheck = "checked";
						MRNSameCheck = "";
					}
					else
					{
						SeparateCheck = "";
						MRNSameCheck = "checked";
					} */

					if(Chart.equals("S")) out.println("<input type='radio' name='ChartMaintenance' id='ChartMaintenance' value='S' onClick=\"checkNumberingControl('S')\" checked>");
					else out.println("<input type='radio' name='ChartMaintenance' id='ChartMaintenance' onClick=\"checkNumberingControl('S')\" value='S' "+Numdisable+">");
				%>
	       			</td>
				<td width=30% align="left" class="label"><fmt:message key="Common.single.label" bundle="${common_labels}"/>
    				</td>
    				<td align="left" class="label" width=5%>&nbsp;&nbsp;
				<%
					String disableNumbering = "";   
					if(Chart.equals("M")) disableNumbering = "disabled";
					if(Numbering.equals("Y")) out.println("<input type='radio' name='NumberingControl' id='NumberingControl' value='Y' "+SeparateCheck+" "+disableNumbering+">"); //"+Numdisable+"
					else out.println("<input type='radio' name='NumberingControl' id='NumberingControl' value='Y' "+disableNumbering+">");
				%>
    				</td>
				<td width=35% align="left" class="label"><fmt:message key="eMP.AllowseparateMRN.label" bundle="${mp_labels}"/>
    				</td>
					<td align="left" class="label" width=5%>&nbsp;&nbsp;</td>
				<td width=30% align="left" class="label">
				<select name="Soundex" id="Soundex" >
                            <%
                                if (Soundex.equals(""))
                                    out.println( "<option selected value=''>--"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--" ) ;
                                else
                                    out.println( "<option value=''>--"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--" ) ;

                                if ( Soundex.equals( "G" ) )
                                    out.println( "<option selected value='G'>Generic" ) ;
                                else
                                    out.println( "<option value='G'>Generic" ) ;

                                if ( Soundex.equals( "E" ) )
									out.println( "<option selected value='E'>Ethnic" ) ;
                                else
                                   out.println( "<option value='E'>Ethnic" ) ;

                            %>
                            </select>
				</td>
    				<!--<td align="left" class="label" width=1%>&nbsp;&nbsp;
				<%
					if(Soundex.equals("G")) out.println("<input type='radio' name='Soundex' id='Soundex' value='G' Checked>");
					else out.println("<input type='radio' name='Soundex' id='Soundex' value='G'>");
				%>
				</td>
				<td width=24% align="left" class="label">Generic
				</td>-->
    			</tr>
    			<tr>
    				<td align="left" class="label" width=5%>&nbsp;&nbsp;
				<%
					if(Chart.equals("M")) out.println("<input type='radio' name='ChartMaintenance' id='ChartMaintenance' value='M' onClick=\"checkNumberingControl('M')\" checked>");
					else out.println("<input type='radio' name='ChartMaintenance' id='ChartMaintenance' value='M' onClick=\"checkNumberingControl('M')\" >");
				%>
			        </td>
				<td width=30% align="left" class="label"><fmt:message key="Common.multiple.label" bundle="${common_labels}"/>
    				</td>
    				<td align="left" class="label" width=5%>&nbsp;&nbsp;
				<%
					if(Numbering.equals("N")) out.println("<input type='radio' name='NumberingControl' id='NumberingControl' value='N' "+SeparateCheck+" "+disableNumbering+">");
					else out.println("<input type='radio' name='NumberingControl' id='NumberingControl' value='N' "+disableNumbering+">"); //"+Numdisable+"
				%>
			    	</td>
				<td width=31% align="left" class="label"><fmt:message key="eMP.KeepMRNsameasPatientID.label" bundle="${mp_labels}"/>
			    	</td>
			    	<!--<td align="left" class="label" width=5%>&nbsp;&nbsp;
				<%
					if(Soundex.equals("E")) out.println("<input type='radio' name='Soundex' id='Soundex' value='E' Checked>");
					else out.println("<input type='radio' name='Soundex' id='Soundex' value='E'>");
				%>
			        </td>
			        <td width=24% align="left" class="label">Ethnic
				</td>-->
			</tr>
  			</table>
		</td>
	</tr>
		<%
			if(tm_req.equals("N"))
			{
		%>
		     <tr>
	  	<td colspan=2>&nbsp;</td>
  </tr> 

	<%
			}
	if(tm_req.equals("Y"))
	{
	%>
		    <tr>
    	<th align=left><b><fmt:message key="eMP.TerminalDigitDerivationLogic.label" bundle="${mp_labels}"/></b></th>
    </tr>

		<tr>
			<td class="label" align="left">&nbsp;<fmt:message key="eMP.NoofTerminalDigits.label" bundle="${mp_labels}"/>&nbsp;&nbsp;<INPUT TYPE="text" name="TDC" id="TDC" SIZE ='2' MAXLENGTH='2' VALUE="<%=terminal_digit_count%>" READONLY>

		<%
			if(!terminal_digit_count.equals(""))
			{
		%>
				Terminal Digits 
				&nbsp;&nbsp;<INPUT TYPE="text" name="TP1" id="TP1" SIZE ='2' MAXLENGTH='2' VALUE="<%=terminal_digit1_position%>" READONLY>
				&nbsp;<INPUT TYPE="text" name="TP2" id="TP2" SIZE ='2' MAXLENGTH='2' VALUE="<%=terminal_digit2_position%>" READONLY>
				&nbsp;<INPUT TYPE="text" name="TP3" id="TP3" SIZE ='2' MAXLENGTH='2' VALUE="<%=terminal_digit3_position%>" READONLY>
				<%
					if(!terminal_digit_count.equals("3"))
					{
				%>
						&nbsp;<INPUT TYPE="text" name="TP4" id="TP4" SIZE ='2' MAXLENGTH='2' VALUE="<%=terminal_digit4_position%>" READONLY>
				<%
					}
					if(terminal_digit_count.equals("5"))
					{ %>
						&nbsp;<INPUT TYPE="text" name="TP5" id="TP5" SIZE ='2' MAXLENGTH='2' VALUE="<%=terminal_digit5_position%>" READONLY>
				 <% } %> </td>
				</tr>
		<%
			}
		}
%>
  	<tr>
  	  	<th align=left><b><fmt:message key="eMP.RegistrationOutput.label" bundle="${mp_labels}"/></b></th>
  	 </tr>
	  <tr>
	  	<td width=100% class="BORDER">
	  		<table border="0" cellpadding="0" cellspacing="0" width="100%">
  			<tr>
			    	<td width=23% align="right" class="label"><fmt:message key="eMP.PatientCardTitle.label" bundle="${mp_labels}"/></td>
			    	<td width=77% align="left">
				&nbsp;<input type="text" name="Patient_Card_Title" id="Patient_Card_Title" size="40" maxlength="40" Value="<%=CardTitle%>"></td>
			 </tr>
			 <tr><td width=23% align="right" class="label"><fmt:message key="eMP.FaceSheetDeclaration.label" bundle="${mp_labels}"/></td><td width=77% align='left' valign='top'>&nbsp;<input type='text' name='Face_Sheet_1' id='Face_Sheet_1' size='70' maxlength='80' onBlur="makeValidString(this);" Value="<%=Line1%>"></td></tr>
			 <tr><td width=23%>&nbsp;</td><td width=77% align='left' valign='top'>&nbsp;<input type='text' name='Face_Sheet_2' id='Face_Sheet_2' size='70' maxlength='80' onBlur="makeValidString(this);" Value="<%=Line2%>"></td></tr>
			 <tr><td width=23%>&nbsp;</td><td width=77% align='left' valign='top'>&nbsp;<input type='text' name='Face_Sheet_3' id='Face_Sheet_3' size='70' maxlength='80' onBlur="makeValidString(this);" Value="<%=Line3%>"></td></tr>
			 <tr><td width=23%>&nbsp;</td><td width=77% align='left' valign='top'>&nbsp;<input type='text' name='Face_Sheet_4' id='Face_Sheet_4' size='70' maxlength='80' onBlur="makeValidString(this);" Value="<%=Line4%>"></td></tr>
			 <tr><td width=23%>&nbsp;</td><td width=77% align='left' valign='top'>&nbsp;<input type='text' name='Face_Sheet_5' id='Face_Sheet_5' size='70' maxlength='80' onBlur="makeValidString(this);" Value="<%=Line5%>"></td></tr>
			 <tr><td width=23%>&nbsp;</td><td width=77% align='left' valign='top'>&nbsp;<input type='text' name='Face_Sheet_6' id='Face_Sheet_6' size='70' maxlength='80' onBlur="makeValidString(this);" Value="<%=Line6%>"></td></tr>
			 <tr><td width=23%>&nbsp;</td><td width=77% align='left' valign='top'>&nbsp;<input type='text' name='Face_Sheet_7' id='Face_Sheet_7' size='70' maxlength='80' onBlur="makeValidString(this);" Value="<%=Line7%>"></td></tr>
			 <tr><td width=23%>&nbsp;</td><td width=77% align='left' valign='top'>&nbsp;<input type='text' name='Face_Sheet_8' id='Face_Sheet_8' size='70' maxlength='80' onBlur="makeValidString(this);" Value="<%=Line8%>"></td></tr>
			 <tr><td width=23%>&nbsp;</td><td width=77% align='left' valign='top'>&nbsp;<input type='text' name='Face_Sheet_9' id='Face_Sheet_9' size='70' maxlength='80' onBlur="makeValidString(this);" Value="<%=Line9%>"></td></tr>
			 <tr><td width=23%>&nbsp;</td><td width=77% align='left' valign='top'>&nbsp;<input type='text' name='Face_Sheet_10' id='Face_Sheet_10' size='70' maxlength='80' onBlur="makeValidString(this);" Value="<%=Line10%>"></td></tr>
			 <input type='hidden' name='Facility_Id' id='Facility_Id' value='<%=facility_id%>'>
			 <tr>
			 			<td width='23%'>&nbsp;</td>
			 			<td width='77%'>&nbsp;</td>
			</tr>
  		</table>
	</td>
</tr>
</table>
</div>
<input type="hidden" name="function1" id="function1" value="modify">
<input type="hidden" name="terminal_digit_count" id="terminal_digit_count" value=<%=terminal_digit_count%>>
<input type="hidden" name="terminal_digit1_position" id="terminal_digit1_position" value=<%=terminal_digit1_position%>>
<input type="hidden" name="terminal_digit2_position" id="terminal_digit2_position" value=<%=terminal_digit2_position%>>
<input type="hidden" name="terminal_digit3_position" id="terminal_digit3_position" value=<%=terminal_digit3_position%>>
<input type="hidden" name="terminal_digit4_position" id="terminal_digit4_position" value=<%=terminal_digit4_position%>>
<input type="hidden" name="terminal_digit5_position" id="terminal_digit5_position" value=<%=terminal_digit5_position%>>
<input type="hidden" name="terminal_reqd" id="terminal_reqd" value="<%=tm_req%>">
<input type="hidden" name="Numbering" id="Numbering" value="<%=Numbering%>">
<input type="hidden" name="Chart" id="Chart" value="<%=Chart%>">
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

