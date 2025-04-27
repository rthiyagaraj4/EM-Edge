<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>
<html>
<head>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eMP/js/TerminalDigit.js" language="javascript"></script>
<script src="../../eMP/js/TerminalDigit1.js" language="javascript"></script>
<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<script language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
//parent.parent.frames[1].frames[0].document.getElementById("apply").disabled= false;
parent.frames[0].document.getElementById("apply").disabled= false;
function calldis()
{
	//parent.parent.frames[1].frames[0].document.getElementById("apply").disabled= true;
	parent.frames[0].document.getElementById("apply").disabled= true;
}
</script>
</head>
<% 
Connection con = null;
try { %>
<%	
	PreparedStatement pstmt=null;
	PreparedStatement pstmt2=null;
	ResultSet rs=null;
	ResultSet rs2=null;
	ResultSet rs1 =null;
	int count = 0;
	PreparedStatement pstmt1 =null;
    ResultSet rs3=null;
	String tm_req="";
	
	String level = "";
	String mr_section = "";
	String facility_id = "";
	String terminal_digit_count="";
	int terminal_digits=0;
	String group_count = "";
	String terminal_digit1_position="";
	String terminal_digit2_position="";
	String terminal_digit3_position="";
	String terminal_digit4_position="";
	String terminal_digit5_position="";
	String terminal_digit6_position="";
	String terminal_digit7_position="";
	String pt1="";
	String pt2="";
	String pt3="";
	String pt4="";
	String pt5="";
	String pt6="";
	String pt7="";
	String pt8="";
	String st1="";
	String st2="";
	String st3="";
	String st4="";
	String st5="";
	String st6="";
	String st7="";
	String st8="";
	String tt1="";
	String tt2="";
	String tt3="";
	String tt4="";
	String tt5="";
	String tt6="";
	String tt7="";
	String tt8="";
	String disabledFields =""; 
	String single_or_multi_files_ind="";
	String patient_id_length = "";
	String separate_file_no_yn ="";
%>
  <%	
		String facilityid = request.getParameter("facility_id")==null?"":request.getParameter("facility_id");

		facilityid = facilityid.toUpperCase();	
		String mrsectioncode = request.getParameter("mr_section_code")==null?"":request.getParameter("mr_section_code");
		mrsectioncode = mrsectioncode.toUpperCase();

		String term_digit_level = request.getParameter("term_digit_level")==null?"":request.getParameter("term_digit_level");
		term_digit_level = term_digit_level.toUpperCase();
		String operation = "";
		if(term_digit_level.equals(""))
		operation = "insert";
		else operation = "modify";
		/*Added by lakshmanan for security issue ID 174131244 on 21-08-2023 start */
		java.util.HashMap psthashmap		=	new java.util.HashMap() ;
		int psthmcount=0;
		/*Added by lakshmanan for security issue ID 174131244 on 21-08-2023 end */
		con = ConnectionManager.getConnection(request);
		try {
		String str_sql = "select count(*) count from mr_terminal_digit_hdr where  term_digit_level = ? ";
		psthashmap.put(++psthmcount,term_digit_level);
		if (!facilityid.equals("")) {
			str_sql = str_sql + " and facility_id = ? ";	
			psthashmap.put(++psthmcount,facilityid);
		}
		if (!mrsectioncode.equals("")) {
			str_sql = str_sql + " and mr_section_code = ? ";
			psthashmap.put(++psthmcount,mrsectioncode);
		}
	
		if(pstmt!=null)pstmt.close();
		if (rs1!=null)rs1.close();
		pstmt = con.prepareStatement(str_sql);
		int pstcount=1;
		while ( pstcount<=psthashmap.size()) {
		pstmt.setString(pstcount,(String) psthashmap.get(pstcount));
		pstcount++;
		}
		psthashmap.clear();
		psthmcount=0;
		rs1 = pstmt.executeQuery();
			
		
		while(rs1.next()) 
		{
			count = rs1.getInt("count");
			
			if (count>0) disabledFields = "disabled";
			
		}
		
		} catch(Exception e) {}			
		try { 
		if (!term_digit_level.equals("")) {
		String strsql = "SELECT a.term_digit_level term_digit_level, a.facility_id facility_id, a.mr_section_code mr_section_code, a.no_of_term_digit no_of_term_digit,a.no_of_term_digit_group no_of_term_digit_group, a.term_digit1_position term_digit1_position, a.term_digit2_position term_digit2_position, a.term_digit3_position term_digit3_position, a.term_digit4_position term_digit4_position, a.term_digit5_position term_digit5_position,a.term_digit6_position term_digit6_position, a.term_digit7_position term_digit7_position, b.term_digit_grp1_id term_digit_grp1_id,b.term_digit_grp2_id term_digit_grp2_id, b.term_digit_grp3_id term_digit_grp3_id,b.term_digit_grp1_position1 term_digit_grp1_position1, b.term_digit_grp1_position2 term_digit_grp1_position2, b.term_digit_grp1_position3 term_digit_grp1_position3,b.term_digit_grp1_position4 term_digit_grp1_position4, b.term_digit_grp1_position5 term_digit_grp1_position5, b.term_digit_grp1_position6 term_digit_grp1_position6,b.term_digit_grp1_position7 term_digit_grp1_position7, b.term_digit_grp2_position1 term_digit_grp2_position1, b.term_digit_grp2_position2 term_digit_grp2_position2,b.term_digit_grp2_position3 term_digit_grp2_position3, b.term_digit_grp2_position4 term_digit_grp2_position4, b.term_digit_grp2_position5 term_digit_grp2_position5,b.term_digit_grp2_position6 term_digit_grp2_position6, b.term_digit_grp2_position7 term_digit_grp2_position7, b.term_digit_grp3_position1 term_digit_grp3_position1,b.term_digit_grp3_position2 term_digit_grp3_position2, b.term_digit_grp3_position3 term_digit_grp3_position3, b.term_digit_grp3_position4 term_digit_grp3_position4,b.term_digit_grp3_position5 term_digit_grp3_position5, b.term_digit_grp3_position6 term_digit_grp3_position6, b.term_digit_grp3_position7 term_digit_grp3_position7 FROM mr_terminal_digit_hdr a , mr_terminal_digit_dtl b";
		

		if (!term_digit_level.equals("")) {
			strsql = strsql + " where a.term_digit_level = ? and a.term_digit_level = b.term_digit_level ";	
			psthashmap.put(++psthmcount,term_digit_level);
		}
		if (!facilityid.equals("")) {
			strsql = strsql + " and a.facility_id = ? and a.facility_id = b.facility_id ";
			psthashmap.put(++psthmcount,facilityid);
		}
		
		if (!mrsectioncode.equals("")) {
			strsql = strsql + " and a.mr_section_code = ? and a.mr_section_code = b.mr_section_code";	
			psthashmap.put(++psthmcount,mrsectioncode);
		}
		
		pstmt2 = con.prepareStatement(strsql);		
		int pstcount=1;
		while ( pstcount<=psthashmap.size()) {
			pstmt2.setString(pstcount,(String) psthashmap.get(pstcount));
			pstcount++;
		}
		psthashmap.clear();
		psthmcount=0;
		rs2 = pstmt2.executeQuery();
		if(rs2.next()) 
		{
		level = rs2.getString("term_digit_level")==null?"":rs2.getString("term_digit_level");
		

		mr_section = rs2.getString("mr_section_code")==null?"":rs2.getString("mr_section_code");

		facility_id = rs2.getString("facility_id")==null?"":rs2.getString("facility_id");	

		terminal_digit_count = rs2.getString("no_of_term_digit")==null?"0":rs2.getString("no_of_term_digit");


		terminal_digits = Integer.parseInt(terminal_digit_count);


		group_count =   
	  rs2.getString("no_of_term_digit_group")==null?"":rs2.getString("no_of_term_digit_group"); 
	  

		 terminal_digit1_position= rs2.getString("term_digit1_position")==null?"":rs2.getString("term_digit1_position");
	  

		 terminal_digit2_position= rs2.getString("term_digit2_position")==null?"":rs2.getString("term_digit2_position");
	  

		 terminal_digit3_position= rs2.getString("term_digit3_position")==null?"":rs2.getString("term_digit3_position");
	  
		 terminal_digit4_position= rs2.getString("term_digit4_position")==null?"":rs2.getString("term_digit4_position");
  
		 terminal_digit5_position= rs2.getString("term_digit5_position")==null?"":rs2.getString("term_digit5_position");
  
		 terminal_digit6_position= rs2.getString("term_digit6_position")==null?"":rs2.getString("term_digit6_position");
  
		terminal_digit7_position= rs2.getString("term_digit7_position")==null?"":rs2.getString("term_digit7_position");
  
		 pt1=rs2.getString("term_digit_grp1_position1")==null?"":rs2.getString("term_digit_grp1_position1"); 
  
		 pt2=rs2.getString("term_digit_grp1_position2")==null?"":rs2.getString("term_digit_grp1_position2"); 
  
		 pt3=rs2.getString("term_digit_grp1_position3")==null?"":rs2.getString("term_digit_grp1_position3"); 
	    pt4=rs2.getString("term_digit_grp1_position4")==null?"":rs2.getString("term_digit_grp1_position4"); 
	    pt5=rs2.getString("term_digit_grp1_position5")==null?"":rs2.getString("term_digit_grp1_position5"); 
	   pt6=rs2.getString("term_digit_grp1_position6")==null?"":rs2.getString("term_digit_grp1_position6"); 
  	     pt7=rs2.getString("term_digit_grp1_position7")==null?"":rs2.getString("term_digit_grp1_position7"); 
	    pt8=rs2.getString("term_digit_grp1_id")==null?"":rs2.getString("term_digit_grp1_id"); 
	  	    st1=rs2.getString("term_digit_grp2_position1")==null?"":rs2.getString("term_digit_grp2_position1");
  	  	    
			st2=rs2.getString("term_digit_grp2_position2")==null?"":rs2.getString("term_digit_grp2_position2");
	  st3=rs2.getString("term_digit_grp2_position3")==null?"":rs2.getString("term_digit_grp2_position3");
	  st4=rs2.getString("term_digit_grp2_position4")==null?"":rs2.getString("term_digit_grp2_position4");
	  	  st5=rs2.getString("term_digit_grp2_position5")==null?"":rs2.getString("term_digit_grp2_position5");
	  	  	  st6=rs2.getString("term_digit_grp2_position6")==null?"":rs2.getString("term_digit_grp2_position6");
 	    st7=rs2.getString("term_digit_grp2_position7")==null?"":rs2.getString("term_digit_grp2_position7");
	  
st8=rs2.getString("term_digit_grp2_id")==null?"":rs2.getString("term_digit_grp2_id"); 
	  tt1=rs2.getString("term_digit_grp3_position1")==null?"":rs2.getString("term_digit_grp3_position1");
	  	  tt2=rs2.getString("term_digit_grp3_position2")==null?"":rs2.getString("term_digit_grp3_position2");
 	  	  	  tt3=rs2.getString("term_digit_grp3_position3")==null?"":rs2.getString("term_digit_grp3_position3");
	  	  	  tt4=rs2.getString("term_digit_grp3_position4")==null?"":rs2.getString("term_digit_grp3_position4");
  	  tt5=rs2.getString("term_digit_grp3_position5")==null?"":rs2.getString("term_digit_grp3_position5");
	    	  tt6=rs2.getString("term_digit_grp3_position6")==null?"":rs2.getString("term_digit_grp3_position6");
  	  
	   tt7=rs2.getString("term_digit_grp3_position7")==null?"":rs2.getString("term_digit_grp3_position7");
	    	  tt8=rs2.getString("term_digit_grp3_id")==null?"":rs2.getString("term_digit_grp3_id"); 
  	  
	   }
     }
	try {
		
		String str_sql1 = "Select SINGLE_OR_MULTI_FILES_IND,SEPARATE_FILE_NO_YN, PATIENT_ID_LENGTH from mp_param";
		pstmt1 = con.prepareStatement(str_sql1);		
		rs3 = pstmt1.executeQuery();
		if(rs3.next())
		{
		single_or_multi_files_ind = rs3.getString("SINGLE_OR_MULTI_FILES_IND")==null?"":rs3.getString("SINGLE_OR_MULTI_FILES_IND");
		patient_id_length=rs3.getString("PATIENT_ID_LENGTH")==null?"":rs3.getString("PATIENT_ID_LENGTH");
		separate_file_no_yn=rs3.getString("SEPARATE_FILE_NO_YN")==null?"":rs3.getString("SEPARATE_FILE_NO_YN");		
		}
	}
	catch(Exception e)
			{
			}

	}catch(Exception e) { 
		//out.println("Error:"+e.toString());
		e.printStackTrace(); // Added by lakshmanan for security issue ID 174091131 on 24-08-2023
		}
	finally
	{
		if (rs1 != null) rs1.close();
		if (rs3 != null) rs3.close();
		if (rs2 != null) rs2.close();
		if (pstmt != null) pstmt.close();
		if (pstmt1 != null) pstmt1.close();
		if (pstmt2 != null) pstmt2.close();


	}
%>

<!-- <body onLoad="Focusing('Facility')"> -->
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="terminal_level_form" id="terminal_level_form" action="../../servlet/eMP.TerminalDigitServlet" method="post" target="messageFrame" >
<!--div -->
<br><br><br><br><br><br><br>

  <table border="0" cellpadding="3" cellspacing="0" width="100%" align='center'><!--97%-->
<!--		<%
			if(tm_req.equals("N"))
			{
		%> -->
     <tr>
	 <td>&nbsp;</td>
	 <td>&nbsp;</td>
  	 <td>&nbsp;</td>
  	 <td>&nbsp;</td>	 
  </tr> 
<!-- <%}%> -->
    <tr><td class="label" ><fmt:message key="eMP.Atthelevelof.label" bundle="${mp_labels}"/>
	  <td class="fields" colspan=3><% if (level==null || level.equals("")) {%>
	  <Select name="level" id="level" onchange="enable_select();">
	  <option value='' selected>-------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------</option>
      <option value='E'><fmt:message key="Common.enterprise.label" bundle="${common_labels}"/>  </option>
	  <option value='F'><fmt:message key="Common.facility.label" bundle="${common_labels}"/>    </option>
	<% if (single_or_multi_files_ind.equals("S")&& separate_file_no_yn.equals("N"))
		  {}else{
    %><option value='S'><fmt:message key="Common.MRSection.label" bundle="${common_labels}"/>  </option>
	<% } %>
	  </select><img src='../images/mandatory.gif'></img></td>
	<% } else if (level.equals("E")) { %>
	 <Select name="level" id="level" disabled ><option value='E' selected><fmt:message key="Common.enterprise.label" bundle="${common_labels}"/></option></select>
	   <img src='../images/mandatory.gif'></img></td>
 	<% } else if (level.equals("F")) { %>
	 <Select name="level" id="level" disabled ><option value='F' selected><fmt:message key="Common.facility.label" bundle="${common_labels}"/></option></select>
 	   <img src='../images/mandatory.gif'></img></td>
  	<% } else if (level.equals("S")) { %>
	 <Select name="level" id="level" disabled ><option value='S' selected><fmt:message key="Common.MRSection.label" bundle="${common_labels}"/></option></select> <img src='../images/mandatory.gif'></img></td>
	<%  } %>

	</tr>
	<tr>
      <td  class="label"><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></td>
      <td  class="fields">
	<% if (facility_id==null || facility_id.equals("")) {%>
	  <Select name="Facility_Name" id="Facility_Name" disabled onchange="getMRSection(this);">
      <option value='' selected>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
  <%
	try { pstmt=con.prepareStatement("select facility_id, facility_name from sm_facility_param order by facility_name");
			rs = pstmt.executeQuery();
      		if(rs != null) {
      			while(rs.next()) {
				String classcode  	= rs.getString("facility_id");
				String classname	= rs.getString("facility_name");
%>
			<option value='<%=classcode%>'><%=classname%>
<%    			}
      		}
	}catch(Exception e) { 
		//out.println(e.toString());
		e.printStackTrace(); // Added by lakshmanan for security issue ID 174224988 on 24-08-2023
		}
	finally {
		if(pstmt !=null) pstmt.close();
		if(rs !=null) rs.close();
	}
%><img src='../images/mandatory.gif' style='visibility:hidden' id='img01'></img>
<% } else {%>
<Select name="Facility_Name" id="Facility_Name" disabled>
<%	
	try {
			pstmt=con.prepareStatement("select facility_name from sm_facility_param where facility_id=?");
			pstmt.setString(1,facility_id);
			rs = pstmt.executeQuery();
      		if(rs != null) {
      			while(rs.next()) {
				String classcode     	= facility_id;
				String classname	= rs.getString("facility_name");
%>
			<option value='<%=classcode%>' selected ><%=classname%>
<%
      			}
      		}
	}catch(Exception e) { 
		//out.println(e.toString());
		e.printStackTrace(); // Added by lakshmanan for security issue ID 174224989 on 24-08-2023
		}
	finally {
		if(pstmt !=null) pstmt.close();
		if(rs !=null) rs.close();
	}
%>
<% } %>
	</select><img src='../images/mandatory.gif' style='visibility:hidden' id='img01'></img></td>

	<td class="label" ><fmt:message key="Common.MRSection.label" bundle="${common_labels}"/></td>	
	<td class="fields">
	<% if (mr_section==null || mr_section.equals("")) {%>
	<Select name="mr_section" id="mr_section" disabled noresize>
    <option value='' selected >-------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------</option>
	</select><% } else { %>
	<Select name="mr_section" id="mr_section" disabled>
	<%	
	try {
			pstmt=con.prepareStatement("select short_name from mr_section where mr_section_code=?");
			pstmt.setString(1,mr_section);
			rs = pstmt.executeQuery();
      		if(rs != null) {
      			while(rs.next()) {
				String classcode     	= mr_section;
				String classname	= rs.getString("short_name");
	%>
			<option value='<%= classcode %>' selected ><%= classname %>
	<%
      			}
      		}
	}catch(Exception e) { 
		//out.println(e.toString());
		e.printStackTrace(); // Added by lakshmanan for security issue ID 174224990 on 24-08-2023
	}
	finally {
		if(pstmt !=null) pstmt.close();
		if(rs !=null) rs.close();
	}
%>
	<% } %><img src='../images/mandatory.gif' style='visibility:hidden' id='img02'></img>
    </tr>
<% if (count<1) {%>	
    <tr><td class="label" ><fmt:message key="eMP.TerminalDigitBy.label" bundle="${mp_labels}"/></td>
	  <td colspan=3 class="fields"><Select name="sorttermin" id="sorttermin" onchange="populatePositionGroup()">
	  <option value='' selected>-------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------</option>
      <option value='P'><fmt:message key="Common.Position.label" bundle="${common_labels}"/></option>
	  <option value='PG'><fmt:message key="Common.Group.label" bundle="${common_labels}"/> </option>
	</select><img  src='../images/mandatory.gif'></td>
	  </tr>
		  <% } %>
	<tr>    	
	<% if (count<1) {%>	
	<td class="label"  ><label id=pos style='visibility:hidden'><fmt:message key="eMP.NoofPositions.label" bundle="${mp_labels}"/><label>	
		
		<td class="fields"><INPUT TYPE="text" size="1" maxlength="1" name="terminal_digit_count" id="terminal_digit_count" style='visibility:hidden' onKeyPress="return allowValidNumber(this,event,1,0);"   onBlur="chkvalue(this);chkData(this);clearData();"  >  <img id=imgid style='visibility:hidden' src='../images/mandatory.gif'></td>	
		<% } else { %>
		<td  class="label"  ><fmt:message key="eMP.NoofPositions.label" bundle="${mp_labels}"/>
		<td  class="fields">
		<INPUT TYPE="text" size="1" maxlength="1" name="terminal_digit_count" id="terminal_digit_count" value='<%=terminal_digit_count%>' disabled> <img src='../images/mandatory.gif'></img></td>
		<% } %>			
		<% if (count<1) {%>
		<td class="label" ><label id=pos1 style='visibility:hidden'><fmt:message key="eMP.NoofGroups.label" bundle="${mp_labels}"/></label></td>	
		<td class="fields" class="fields" >
		<INPUT TYPE="text" size="1"  style='visibility:hidden' maxlength="1" disabled name="group_count" id="group_count" onKeyPress="return allowValidNumber(this,event,1,0);" onBlur="chkgroup(this);chkgrouplength(this);clearAll();CheckNum(this);" > <img id=imgid1 style='visibility:hidden' src='../images/mandatory.gif'></td>
		<% } else { %>
		<td  class="label" ><fmt:message key="eMP.NoofGroups.label" bundle="${mp_labels}"/></td>	
		
		<td class="fields" >
		<INPUT TYPE="text" size="1" maxlength="1" name="group_count" id="group_count" value='<%=group_count%>' disabled></td>
		<% } %>
	</tr>
	</table>    
    <table border="0" cellpadding="0" align="center" cellspacing="0" width="100%">
	<tr>
		<% if (!group_count.equals("")||!terminal_digit_count.equals("")) { %>
		<td class='columnheader'><b><span id='div14'><fmt:message key="eMP.TerminalDigitsPosition.label" bundle="${mp_labels}"/></span></b></td>
		<% } else { %>
    	<td class='columnheader'><b><span style='visibility:hidden' id='div14'><fmt:message key="eMP.TerminalDigitsPosition.label" bundle="${mp_labels}"/></span></b></td>
		<% } %>
    </tr>	
	<tr>	
	<td  class="fields"><% if (group_count.equals("")&&(terminal_digits>=1)){ %>
			<INPUT TYPE="text" size="2" maxlength="2" name="terminal_digit1_position" id="terminal_digit1_position" value='<%=terminal_digit1_position%>' <%=disabledFields%> >
			<img name="img1" src='../images/mandatory.gif'></img>
			<% } else { %>			
			<INPUT TYPE="text" size="2" maxlength="2" name="terminal_digit1_position" id="terminal_digit1_position" style="visibility:hidden" onkeypress='return allowValidNumber(this,event,2, 0);' onBlur="CheckIdLen(this)" <%=disabledFields%> >
			<img name="img1" src='../images/mandatory.gif' style="visibility:hidden"></img>
			<% } %>

			<% if (group_count.equals("")&&(terminal_digits>=2)){ %>
			<INPUT TYPE="text" size="2" maxlength="2" name="terminal_digit2_position" id="terminal_digit2_position"  value='<%=terminal_digit2_position%>' <%=disabledFields%>>
			<img name="img2" src='../images/mandatory.gif'></img>	
			<% } else { %>
			<INPUT TYPE="text" size="2" maxlength="2" name="terminal_digit2_position" id="terminal_digit2_position" style="visibility:hidden" onkeypress='return allowValidNumber(this,event,2, 0);' onBlur="CheckIdLen(this)" <%=disabledFields%>>
			<img name="img2" src='../images/mandatory.gif' style="visibility:hidden"></img>	
			<% } %>

			<% if (group_count.equals("")&&(terminal_digits>=3)){ %>
			<INPUT TYPE="text" size="2" maxlength="2" name="terminal_digit3_position" id="terminal_digit3_position" value='<%=terminal_digit3_position%>' <%=disabledFields%>>
			<img name="img3" src='../images/mandatory.gif'></img>
			<% } else { %>
			<INPUT TYPE="text" size="2" maxlength="2" name="terminal_digit3_position" id="terminal_digit3_position" style="visibility:hidden" onkeypress='return allowValidNumber(this,event,2, 0);' onBlur="CheckIdLen(this)" <%=disabledFields%>>
			<img name="img3" src='../images/mandatory.gif' style="visibility:hidden"></img>
			<% } %>

			<% if (group_count.equals("")&&(terminal_digits>=4)){ %>
			<INPUT TYPE="text" size="2" maxlength="2" name="terminal_digit4_position" id="terminal_digit4_position" value='<%=terminal_digit4_position%>' <%=disabledFields%>>
			<img name="img4" src='../images/mandatory.gif'></img>
			<% } else { %>
			<INPUT TYPE="text" size="2" maxlength="2" name="terminal_digit4_position" id="terminal_digit4_position" style="visibility:hidden" onkeypress='return allowValidNumber(this,event,2, 0);' onBlur="CheckIdLen(this)" <%=disabledFields%>>
			<img name="img4" src='../images/mandatory.gif' style="visibility:hidden"></img>
			<% } %>

			<% if (group_count.equals("")&&(terminal_digits>=5)){ %>
			<INPUT TYPE="text" size="2" maxlength="2" name="terminal_digit5_position" id="terminal_digit5_position" value='<%=terminal_digit5_position%>' <%=disabledFields%>>
			<img name="img5" src='../images/mandatory.gif'></img>
			<% } else { %>
			<INPUT TYPE="text" size="2" maxlength="2" name="terminal_digit5_position" id="terminal_digit5_position" style="visibility:hidden" onkeypress='return allowValidNumber(this,event,2, 0);' onBlur="CheckIdLen(this)" <%=disabledFields%>>
			<img name="img5" src='../images/mandatory.gif' style="visibility:hidden"></img>
			<% } %>

			<% if (group_count.equals("")&&(terminal_digits>=6)){ %>
			<INPUT TYPE="text" size="2" maxlength="2" name="terminal_digit6_position" id="terminal_digit6_position" value='<%=terminal_digit6_position%>' <%=disabledFields%>>
			<img name="img6" src='../images/mandatory.gif'></img>
			<% } else { %>
			<INPUT TYPE="text" size="2" maxlength="2" name="terminal_digit6_position" id="terminal_digit6_position" style="visibility:hidden" onkeypress='return allowValidNumber(this,event,2, 0);' onBlur="CheckIdLen(this)" <%=disabledFields%>>
			<img name="img6" src='../images/mandatory.gif' style="visibility:hidden"></img>
			<% } %>
			
			<% if (group_count.equals("")&&(terminal_digits==7)){ %>
			<INPUT TYPE="text" size="2" maxlength="2" name="terminal_digit7_position" id="terminal_digit7_position" value='<%=terminal_digit7_position%>' <%=disabledFields%>>
			<img name="img7" src='../images/mandatory.gif'></img>
			<% } else { %>
			<INPUT TYPE="text" size="2" maxlength="2" name="terminal_digit7_position" id="terminal_digit7_position" style="visibility:hidden" onkeypress='return allowValidNumber(this,event,2, 0);' onBlur="CheckIdLen(this)" <%=disabledFields%>>
			<img name="img7" src='../images/mandatory.gif' style="visibility:hidden"></img>
			<% } %></td>
  </tr>
  <td width=100% class="BORDER">
  		<table border="0" cellpadding="3" cellspacing="0" width="100%" align='center'>
  		<tr>
		<td width=10% class="label">
		<% if (!group_count.equals("")) { %>
		<span id='div2'><fmt:message key="Common.Group.label" bundle="${common_labels}"/></span></td>
		<% } else { %>
		<span style='visibility:hidden' id='div2'><fmt:message key="Common.Group.label" bundle="${common_labels}"/></span></td>
		<% } %>
		<% if (!group_count.equals("") && (terminal_digits>=1)) { %>
		<td width=10% class="fields"><span id='div3'>&nbsp;&nbsp;1st</span></td>
		<% } else {%>
		<td width=10% class="fields"><span style='visibility:hidden' id='div3'>&nbsp;&nbsp;1st</span></td>
		<% } %>
		<% if (!group_count.equals("") && (terminal_digits>=2)) { %>
		<td width=10% class="fields"><span  id='div4'>&nbsp;&nbsp;2nd</span></td>
		<% } else { %>
		<td width=10% class="fields"><span style='visibility:hidden' id='div4'>&nbsp;&nbsp;2nd</span></td>
		<% } %>
		<% if (!group_count.equals("")&& (terminal_digits>=3) ) { %>
		<td width=10%  class="fields"><span id='div5'>&nbsp;&nbsp;3rd</span></td>
		<% } else { %>
		<td width=10% class="fields"><span style='visibility:hidden' id='div5'>&nbsp;&nbsp;3rd</span></td>
		<% } %>
		<% if (!group_count.equals("")&& (terminal_digits>=4)) { %>
		<td width=10%  class="fields"><span  id='div6'>&nbsp;&nbsp;4th</span></td>
		<% } else { %>		
		<td width=10%  class="fields"><span style='visibility:hidden' id='div6'>&nbsp;&nbsp;4th</span></td>
		<% } %>
		<% if (!group_count.equals("") && (terminal_digits>=5)) { %>
		<td width=10% class="fields"><span id='div7'>&nbsp;&nbsp;5th</span></td>
		<% } else { %>		
		<td width=10% class="fields"><span style='visibility:hidden' id='div7'>&nbsp;&nbsp;5th</span></td>
		<% } %>
		<% if (!group_count.equals("") && (terminal_digits>=6)) { %>
		<td width=10% class="fields"><span  id='div8'>&nbsp;&nbsp;6th</span></td>
		<% } else { %>		
		<td width=10% class="fields"><span style='visibility:hidden' id='div8'>&nbsp;&nbsp;6th</span></td>
		<% } %>
		<% if (!group_count.equals("") && (terminal_digits>=7)) { %>
		<td width=10% class="fields"><span id='div9'>&nbsp;&nbsp;7th</span></td>
		<% } else { %>		
		<td width=10% class="fields"><span style='visibility:hidden' id='div9'>&nbsp;&nbsp;7th</span></td>
		<% } %>
		<% if (!group_count.equals("")) { %>
		<td width=10%  class="fields"><span id='div10'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></span></td>
		<% } else { %>
		<td width=10%  class="fields"><span style='visibility:hidden' id='div10'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></span></td>
		<% } %>
		</tr>
		<% if (!pt8.equals("")||!st8.equals("") || !tt8.equals("")) { %>
		<td width=10% class="label"><span id='div11'><fmt:message key="Common.primary.label" bundle="${common_labels}"/></span></td>
		<% } else { %>
		<td width=10% class="label"><span style='visibility:hidden' id='div11'><fmt:message key="Common.primary.label" bundle="${common_labels}"/></span></td>
		<% } %>
		<% if (!group_count.equals("")&& (terminal_digits>=1)) { %>
		<td class="fields"><input type="text" name="pt1" id="pt1" size="2" maxlength="2" Value='<%=pt1%>' <%=disabledFields%>></td>
		<% } else { %>
		<td class="fields"><input type="text" name="pt1" id="pt1" size="2" maxlength="2" Value="" onBlur="makeValidString(this);CheckIdLen(this)" style="visibility:hidden" onkeypress='return allowValidNumber(this,event,2, 0);' <%=disabledFields%>></td>
		<% } %>
		<% if (!group_count.equals("")&& (terminal_digits>=2)) { %>
		<td class="fields"><input type="text" name="pt2" id="pt2" size="2" maxlength="2" Value='<%=pt2%>'  <%=disabledFields%>></td>
		<% } else { %>
		<td class="fields"><input type="text" name="pt2" id="pt2" size="2" maxlength="2" Value="" onBlur="makeValidString(this);CheckIdLen(this)" style="visibility:hidden" onkeypress='return allowValidNumber(this,event,2, 0);' <%=disabledFields%>></td>
		<% } %>
		<% if (!group_count.equals("")&& (terminal_digits>=3)) { %>
		<td class="fields"><input type="text" name="pt3" id="pt3" size="2" maxlength="2" Value='<%=pt3%>'  <%=disabledFields%>></td>
		<% } else { %>
		<td class="fields"><input type="text" name="pt3" id="pt3" size="2" maxlength="2" Value="" onBlur="makeValidString(this);CheckIdLen(this)" style="visibility:hidden" onkeypress='return allowValidNumber(this,event,2, 0);' <%=disabledFields%>></td>
		<% } %>
		<% if (!group_count.equals("")&& (terminal_digits>=4)) { %>
		<td class="fields"><input type="text" name="pt4" id="pt4" size="2" maxlength="2" Value='<%=pt4%>'  <%=disabledFields%>></td>
		<% } else { %>
		<td class="fields"><input type="text" name="pt4" id="pt4" size="2" maxlength="2" Value="" onBlur="makeValidString(this);CheckIdLen(this)" style="visibility:hidden" onkeypress='return allowValidNumber(this,event,2, 0);' <%=disabledFields%>></td>
		<% } %>
		<% if (!group_count.equals("")&& (terminal_digits>=5)) { %>
		<td class="fields"><input type="text" name="pt5" id="pt5" size="2" maxlength="2" Value='<%=pt5%>'  <%=disabledFields%>></td>
		<% } else { %>
		<td class="fields"><input type="text" name="pt5" id="pt5" size="2" maxlength="2" Value="" onBlur="makeValidString(this);CheckIdLen(this)" style="visibility:hidden" onkeypress='return allowValidNumber(this,event,2, 0);' <%=disabledFields%>></td>
		<% } %>
		<% if (!group_count.equals("")&& (terminal_digits>=6)){ %>
		<td class="fields"><input type="text" name="pt6" id="pt6" size="2" maxlength="2" Value='<%=pt6%>'  <%=disabledFields%>></td>
		<% } else { %>
		<td class="fields"><input type="text" name="pt6" id="pt6" size="2" maxlength="2" Value="" onBlur="makeValidString(this);CheckIdLen(this)" style="visibility:hidden" onkeypress='return allowValidNumber(this,event,2, 0);' <%=disabledFields%>></td>
		<% } %>
		<% if (!group_count.equals("")&& (terminal_digits==7)) { %>
		<td class="fields"><input type="text" name="pt7" id="pt7" size="2" maxlength="2" Value='<%=pt7%>'  <%=disabledFields%>></td>
		<% } else { %>
		<td class="fields"><input type="text" name="pt7" id="pt7" size="2" maxlength="2" Value="" onBlur="makeValidString(this);CheckIdLen(this)" style="visibility:hidden" onkeypress='return allowValidNumber(this,event,2, 0);' <%=disabledFields%>></td>
		<% } %>
				
		<% if (!pt8.equals("")){ %>
		<td class="fields"><input type="checkbox" name="pt8" id="pt8" Value='<%=pt8%>' checked <%=disabledFields%>></td>
		<% } else { %>
		<td class="fields"><input type="checkbox" name="pt8" id="pt8" Value="" style="visibility:hidden" <%=disabledFields%>></td>
		<% } %>
		</tr>
    	<tr>
		<%
			int iGroupCount=0;
			if(!group_count.equals("")){
				try{
					iGroupCount = Integer.parseInt(group_count);
				}catch(NumberFormatException nfe){
					nfe.printStackTrace();
				}			
			}			
		%>
		<% if ( (!pt8.equals("")||!st8.equals("") || !tt8.equals("") )  && iGroupCount > 1) { %>
		<td width=10% class="label"><span id='div12'><fmt:message key="Common.secondary.label" bundle="${common_labels}"/></span></td>
		<% } else { %>
		<td width=10% class="label"><span style='visibility:hidden' id='div12'><fmt:message key="Common.secondary.label" bundle="${common_labels}"/></span></td>
		<% } %>
		<% if (!group_count.equals("") && (terminal_digits>=1) &&  iGroupCount > 1) { %>
		<td class="fields"><input type="text" name="st1" id="st1" size="2" maxlength="2" Value='<%=st1%>' <%=disabledFields%>></td>
		<% } else { %>
		<td class="fields"><input type="text" name="st1" id="st1" size="2" maxlength="2" Value="" onBlur="makeValidString(this);CheckIdLen(this)" style="visibility:hidden" onkeypress='return allowValidNumber(this,event,2, 0);' <%=disabledFields%>></td>
		<% } %>
		<% if (!group_count.equals("") && (terminal_digits>=2) &&  iGroupCount > 1) { %>
		<td class="fields"><input type="text" name="st2" id="st2" size="2" maxlength="2" Value='<%=st2%>'  <%=disabledFields%>></td>
		<% } else { %>
		<td class="fields"><input type="text" name="st2" id="st2" size="2" maxlength="2" Value="" onBlur="makeValidString(this);CheckIdLen(this)" style="visibility:hidden" onkeypress='return allowValidNumber(this,event,2, 0);' <%=disabledFields%>></td>
		<% } %>
		<% if (!group_count.equals("")&& (terminal_digits>=3) &&  iGroupCount > 1) { %>
		<td class="fields"><input type="text" name="st3" id="st3" size="2" maxlength="2" Value='<%=st3%>'  <%=disabledFields%>></td>
		<% } else { %>
		<td class="fields"><input type="text" name="st3" id="st3" size="2" maxlength="2" Value="" onBlur="makeValidString(this);CheckIdLen(this)" style="visibility:hidden" onkeypress='return allowValidNumber(this,event,2, 0);' <%=disabledFields%>></td>
		<% } %>
		<% if (!group_count.equals("")&& (terminal_digits>=4) &&  iGroupCount > 1) { %>
		<td class="fields"><input type="text" name="st4" id="st4" size="2" maxlength="2" Value='<%=st4%>'  <%=disabledFields%>></td>
		<% } else { %>
		<td class="fields"><input type="text" name="st4" id="st4" size="2" maxlength="2" Value="" onBlur="makeValidString(this);CheckIdLen(this)" style="visibility:hidden" onkeypress='return allowValidNumber(this,event,2, 0);' <%=disabledFields%>></td>
		<% } %>
		<% if (!group_count.equals("")&& (terminal_digits>=5) &&  iGroupCount > 1) { %>
		<td class="fields"><input type="text" name="st5" id="st5" size="2" maxlength="2" Value='<%=st5%>'  <%=disabledFields%>></td>
		<% } else { %>
		<td class="fields"><input type="text" name="st5" id="st5" size="2" maxlength="2" Value="" onBlur="makeValidString(this);CheckIdLen(this)" style="visibility:hidden" onkeypress='return allowValidNumber(this,event,2, 0);' <%=disabledFields%>></td>
		<% } %>
		<% if (!group_count.equals("")&& (terminal_digits>=6) &&  iGroupCount > 1){ %>
		<td class="fields"><input type="text" name="st6" id="st6" size="2" maxlength="2" Value='<%=st6%>'  <%=disabledFields%>></td>
		<% } else { %>
		<td class="fields"><input type="text" name="st6" id="st6" size="2" maxlength="2" Value="" onBlur="makeValidString(this);CheckIdLen(this)" style="visibility:hidden" onkeypress='return allowValidNumber(this,event,2, 0);' <%=disabledFields%>></td>
		<% } %>
		<% if (!group_count.equals("")&& (terminal_digits==7) &&  iGroupCount > 1) { %>
		<td class="fields"><input type="text" name="st7" id="st7" size="2" maxlength="2" Value='<%=st7%>'  <%=disabledFields%>></td>
		<% } else { %>
		<td class="fields"><input type="text" name="st7" id="st7" size="2" maxlength="2" Value="" onBlur="makeValidString(this);CheckIdLen(this)" style="visibility:hidden" onkeypress='return allowValidNumber(this,event,2, 0);' <%=disabledFields%>></td>
		<% } %>
		<% if (!st8.equals(""))  { %>
		<td class="fields"><input type="checkbox" name="st8" id="st8" Value='<%=st8%>' checked <%=disabledFields%>></td>		
		<% } else { %>
		<td class="fields"><input type="checkbox" name="st8" id="st8" Value=""  style="visibility:hidden" <%=disabledFields%>></td>		
		<% } %>
		</tr>

		<tr>
		<% if( (!pt8.equals("")||!st8.equals("") || !tt8.equals("") ) &&  iGroupCount > 2) { %>
		<td width=10% class="label"><span id='div13'><fmt:message key="Common.tertiary.label" bundle="${common_labels}"/></span></td>
		<% } else { %>
		<td width=10% class="label"><span style='visibility:hidden' id='div13'><fmt:message key="Common.tertiary.label" bundle="${common_labels}"/></span></td>
		<% } %>
		<% if (!group_count.equals("")&& (terminal_digits>=1) &&  iGroupCount > 2) { %>
		<td class="fields"><input type="text" name="tt1" id="tt1" size="2" maxlength="2" Value='<%=tt1%>'  <%=disabledFields%>></td>
		<% } else { %>
		<td class="fields"><input type="text" name="tt1" id="tt1" size="2" maxlength="2" Value="" onBlur="makeValidString(this);CheckIdLen(this)" style="visibility:hidden" onkeypress='return allowValidNumber(this,event,2, 0);' <%=disabledFields%>></td>
		<% } %>
		<% if (!group_count.equals("")&& (terminal_digits>=2) &&  iGroupCount > 2) { %>
		<td class="fields"><input type="text" name="tt2" id="tt2" size="2" maxlength="2" Value='<%=tt2%>'  <%=disabledFields%>></td>
		<% } else { %>
		<td class="fields"><input type="text" name="tt2" id="tt2" size="2" maxlength="2" Value="" onBlur="makeValidString(this);CheckIdLen(this)" style="visibility:hidden" onkeypress='return allowValidNumber(this,event,2, 0);' <%=disabledFields%>></td>
		<% } %>
		<% if (!group_count.equals("")&& (terminal_digits>=3) &&  iGroupCount > 2) { %>
		<td class="fields"><input type="text" name="tt3" id="tt3" size="2" maxlength="2" Value='<%=tt3%>'  <%=disabledFields%>></td>
		<% } else { %>
		<td class="fields"><input type="text" name="tt3" id="tt3" size="2" maxlength="2" Value="" onBlur="makeValidString(this);CheckIdLen(this)" style="visibility:hidden" onkeypress='return allowValidNumber(this,event,2, 0);' <%=disabledFields%>></td>
		<% } %>
		<% if (!group_count.equals("")&& (terminal_digits>=4) &&  iGroupCount > 2) { %>
		<td class="fields"><input type="text" name="tt4" id="tt4" size="2" maxlength="2" Value='<%=tt4%>'  <%=disabledFields%>></td>
		<% } else { %>
		<td class="fields"><input type="text" name="tt4" id="tt4" size="2" maxlength="2" Value="" onBlur="makeValidString(this);CheckIdLen(this)" style="visibility:hidden" onkeypress='return allowValidNumber(this,event,2, 0);' <%=disabledFields%>></td>
		<% } %>
		<% if (!group_count.equals("")&& (terminal_digits>=5) &&  iGroupCount > 2) { %>
		<td class="fields"><input type="text" name="tt5" id="tt5" size="2" maxlength="2" Value='<%=tt5%>'  <%=disabledFields%>></td>
		<% } else { %>
		<td class="fields"><input type="text" name="tt5" id="tt5" size="2" maxlength="2" Value="" onBlur="makeValidString(this);CheckIdLen(this)" style="visibility:hidden" onkeypress='return allowValidNumber(this,event,2, 0);' <%=disabledFields%>></td>
		<% } %>
		<% if (!group_count.equals("")&& (terminal_digits>=6) &&  iGroupCount > 2){ %>
		<td class="fields"><input type="text" name="tt6" id="tt6" size="2" maxlength="2" Value='<%=tt6%>'  <%=disabledFields%>></td>
		<% } else { %>
		<td class="fields"><input type="text" name="tt6" id="tt6" size="2" maxlength="2" Value="" onBlur="makeValidString(this);CheckIdLen(this)" style="visibility:hidden" onkeypress='return allowValidNumber(this,event,2, 0);' <%=disabledFields%>></td>
		<% } %>
		<% if (!group_count.equals("")&& (terminal_digits==7) &&  iGroupCount > 2) { %>
		<td class="fields"><input type="text" name="tt7" id="tt7" size="2" maxlength="2" Value='<%=tt7%>'  <%=disabledFields%>></td>
		<% } else { %>
		<td class="fields"><input type="text" name="tt7" id="tt7" size="2" maxlength="2" Value="" onBlur="makeValidString(this);CheckIdLen(this)" style="visibility:hidden" onkeypress='return allowValidNumber(this,event,2, 0);' <%=disabledFields%>></td>
		<% } %>
		<% if(!tt8.equals("")) { %>
		<td class="fields"><input type="checkbox" name="tt8" id="tt8" Value='<%=tt8%>' checked <%=disabledFields%>></td>		
		<% } else { %>
		<td class="fields"><input type="checkbox" name="tt8" id="tt8" Value="" style="visibility:hidden" <%=disabledFields%>></td>		
		<% } %>
		</tr>
		<tr><td colspan=6>&nbsp;</td></tr>
		</table>
	</td>
</tr>
</table>
</div>

<input type="hidden" name="sStyle" id="sStyle" value="<%=sStyle%>">
<input type="hidden" name="function1" id="function1" value="<%=operation%>">
<input type="hidden" name="terminal_reqd" id="terminal_reqd" value="<%=tm_req%>">
<input type="hidden" name="Numbering" id="Numbering" value="">
<input type="hidden" name="Chart" id="Chart" value="">
<input type="hidden" name="Chart" id="Chart" value="">

<input type="hidden" name="Patient_Card_Title" id="Patient_Card_Title" value="">
<input type="hidden" name="Face_Sheet_1" id="Face_Sheet_1" value="">
<input type="hidden" name="Face_Sheet_2" id="Face_Sheet_2" value="">
<input type="hidden" name="Face_Sheet_3" id="Face_Sheet_3" value="">
<input type="hidden" name="Face_Sheet_4" id="Face_Sheet_4" value="">
<input type="hidden" name="Face_Sheet_5" id="Face_Sheet_5" value="">
<input type="hidden" name="Face_Sheet_6" id="Face_Sheet_6" value="">
<input type="hidden" name="Face_Sheet_7" id="Face_Sheet_7" value="">
<input type="hidden" name="Face_Sheet_8" id="Face_Sheet_8" value="">
<input type="hidden" name="Face_Sheet_9" id="Face_Sheet_9" value="">
<input type="hidden" name="Face_Sheet_10" id="Face_Sheet_10" value="">
<input type="hidden" name="ChartMaintenance" id="ChartMaintenance" value="">
<input type="hidden" name="NumberingControl" id="NumberingControl" value="">

<input type="hidden" name = "enterprise_old" value = <%=level%> >
<input type="hidden" name = "facility_old" value = <%=facility_id%>>
<input type="hidden" name = "mr_section_old" value = <%=mr_section%>>
<input type="hidden" name = "patient_id_length" value = <%=patient_id_length%>>
<% }
catch(Exception e)
{
}
finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>

</form>
<script>
if(document.terminal_level_form.function1.value !="insert")
{
	calldis();
}
</script>
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

