<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*, eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%> 

<Html><head>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/DateUtils.js" language="javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></script>
<script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></script>
<script language='javascript' src='../../eOA/js/AppointmentGroup.js'></script>
</head>
  
 
 <%
Connection con=null;
Statement stmt   	= null ;
PreparedStatement pstmt=null;
ResultSet rset	   	= null;
Statement stmt1   	= null ;
ResultSet rset1	   	= null;String eff_status="E";
String  checkBoxAttribute="checked"; String ckdisable1="";
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String fac_id    	= (String) session.getValue( "facility_id" ) ;
String locale = (String)session.getAttribute("LOCALE");	

String group_id=checkForNull(request.getParameter("group_id"));
String operation=checkForNull(request.getParameter("operation"));
String mainquery="",defaultdisable="",groupid="",clinic_descs="",groupname="",loctype="",loccode="",maxpatient="",minpatient="",effstatus="" ,selected_idval="";
if(operation.equals("")){
	operation="insert";
	 defaultdisable="";
	 ckdisable1="";
}else{
	 ckdisable1="disabled";
	 defaultdisable="readOnly";
}		


//out.println("operation===>"+operation);


try{
	//mainquery="select GROUP_ID,op_get_desc.op_clinic('"+fac_id+"', LOCN_CODE, '"+locale+"','1') clinic_descs, GROUP_NAME,LOCN_TYPE,LOCN_CODE,MAX_PATIENTS ,MIN_PATIENTS,EFF_STATUS from oa_group_hdr where GROUP_ID='"+group_id+"'";
	mainquery="select GROUP_ID,op_get_desc.op_clinic(?, LOCN_CODE, ?,'1') clinic_descs, GROUP_NAME,LOCN_TYPE,LOCN_CODE,MAX_PATIENTS ,MIN_PATIENTS,EFF_STATUS from oa_group_hdr where GROUP_ID=? ";
	con = ConnectionManager.getConnection(request);
	stmt1   	= con.createStatement() ;
	//rset1 = stmt1.executeQuery(mainquery);
	pstmt = con.prepareStatement(mainquery);
	pstmt.setString(1,fac_id);
	pstmt.setString(2,locale);
	pstmt.setString(3,group_id);
	rset1 = pstmt.executeQuery();
	System.out.println("mainquery==>"+mainquery);
 if(rset1.next()){
	 groupid=rset1.getString("GROUP_ID"); 
	 clinic_descs=rset1.getString("clinic_descs"); 
	 groupname=rset1.getString("GROUP_NAME"); 
	 loctype=rset1.getString("LOCN_TYPE"); 
	 loccode=rset1.getString("LOCN_CODE");
	 maxpatient=rset1.getString("MAX_PATIENTS"); 
	 minpatient=rset1.getString("MIN_PATIENTS"); 
	 eff_status=rset1.getString("EFF_STATUS");
	 
	 if(eff_status.equals("D"))
		{
			  checkBoxAttribute="";
			
		}else
		{			
			 checkBoxAttribute="CHECKED";
			
		}
	
 
}	
 if(rset1 !=null) rset1.close();
if(stmt1 !=null) stmt1.close();

}catch(Exception es){
//out.println(es.toString());
es.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally { 
ConnectionManager.returnConnection(con,request);
}


	%>
  	<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
 <form name="create_group" id="create_group" action="../../servlet/eOA.AppointmentGroupServlet" method="post" target="messageFrame">
     <table border="0" cellpadding="2" cellspacing="0" align='center' width='50%' >
      <tr><td clospan="2"   height='100'>&nbsp;</tr>
      <tr> <td class='label'><fmt:message key="eOA.GroupId.label" bundle="${oa_labels}"/></td> 
        <td class='fields'><%if(operation.equals("insert")){%><input type="text" name="group_id" id="group_id" onKeyPress="return CheckForSpecChars(event)"  size='5' maxlength='5' OnBlur="ChangeUpperCase(this) value="<%=group_id%>"><img src='../../eCommon/images/mandatory.gif'><%}else{%><input type="text" name="group_id1" id="group_id1" size='5' maxlength='5'  value="<%=group_id%>" <%=ckdisable1%>><img src='../../eCommon/images/mandatory.gif'><input type="hidden" name="group_id" id="group_id" size='5' maxlength='5'  value="<%=group_id%>"><%}%></td>  
      </tr>
      <tr><td clospan="2">&nbsp;</tr>
      
      <tr> <td class='label'><fmt:message key="Common.GroupName.label" bundle="${common_labels}"/></td> 
        <td class='fields'><input type="text" name="group_name" id="group_name" size='32' maxlength='30' value="<%=groupname%>" <%=ckdisable1%> ><img src='../../eCommon/images/mandatory.gif'></td> 
      </tr>
       <tr><td clospan="2">&nbsp;</tr>
      <tr>
	<td   class='label' ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
	<TD class='fields'  ><SELECT name='locationType' id='locationType' onchange="locationPopulate(this)"   <%=ckdisable1%>  > 
	<option style='align:center'>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
		<%
		try{
			con = ConnectionManager.getConnection(request);
		    stmt   	= con.createStatement() ;
			
			String sql		= "" ;
			String sysdate	= "";
			
		String locn_type="";
		String short_desc="";
		sql  = "Select locn_type,short_desc,CARE_LOCN_TYPE_IND , to_char(sysdate,'dd/mm/yyyy') d from am_care_locn_type_lang_vw where sys_user_def_ind='S' and language_id='"+locale+"' and  locn_type in ('C','E','Y')   order by short_desc"; 
		rset = stmt.executeQuery(sql);

		
		while(rset.next() && rset !=null){
			locn_type=rset.getString("CARE_LOCN_TYPE_IND");
			short_desc=rset.getString("short_desc");
			
			if(locn_type.equals(loctype))
    		selected_idval = "selected";
	        else
			selected_idval = "";
			out.println("<option value='"+locn_type+"'" +selected_idval+">"+short_desc+"</option>");
			
			
		}
		
	if(rset !=null) rset.close();
	if(stmt !=null) stmt.close();

}catch(Exception es){
	//out.println(es.toString());
es.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally { 
	ConnectionManager.returnConnection(con,request);
}
%>

	</SELECT><img src='../../eCommon/images/mandatory.gif'> 
	</TD>
	</tr>
	 <tr><td clospan="2">&nbsp;</tr>
	<tr>
	<td class='label' nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
	<td class='fields' >
	<input type='text' name='b_loc_val' id='b_loc_val' value='<%=clinic_descs%> ' onblur='ena_loc_lookup(this);' size=30 maxlength=30 <%=ckdisable1%> ><input type='button' value='?' onclick='open_loc_lookup();' class='button' name='b_loc_search' id='b_loc_search' <%=ckdisable1%> >
	<img src='../../eCommon/images/mandatory.gif'><input type="hidden" name="blocation" id="blocation" value="<%=loccode%>">
		</td>
		
		</tr>	
	
	<input type="hidden" name="fac_id" id="fac_id" value="<%=fac_id%>">
	<input type="hidden" name="locale" id="locale" value="<%=locale%>">
	<input type='hidden' name='speciality' id='speciality' value=''>
	

       <tr><td clospan="2">&nbsp;</tr>
        <tr> <td class='label'><fmt:message key="Common.MIN.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.patient.label" bundle="${common_labels}"/></td> 
        <td class='fields'><input type="text" name="min_patient" id="min_patient" value="<%=minpatient%>" size='5' maxlength='3' onblur='CheckNum(this);if(this.value!="")checkValue(this);if(this.value!="")MaxminChk()' onKeyPress='return allowPositiveNumber();' ><img src='../../eCommon/images/mandatory.gif'></td>
        <tr><td clospan="2">&nbsp;</tr>
      </tr>
       <tr> <td class='label'><fmt:message key="Common.Max.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.patient.label" bundle="${common_labels}"/></td> 
        <td class='fields'><input type="text" name="max_patient" id="max_patient" value="<%=maxpatient%>" size='5' maxlength='3' onblur='CheckNum(this);if(this.value!="")checkValue(this);if(this.value!="")MaxminChk()' onKeyPress='return allowPositiveNumber();' ><img src='../../eCommon/images/mandatory.gif'></td>
      </tr>
       <tr><td clospan="2">&nbsp;</td></tr>
       <tr>	
	<td class='label' nowrap><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td  class='fields' colspan='3'><input type='checkbox' name='eff_status' id='eff_status' value="<%=eff_status%>" <%=checkBoxAttribute%> onclick='check_eff(this);'></td>	
<tr>
  
      </table>
      <input type='hidden' name='function_name' id='function_name' value='<%=operation%>'>
      <input type='hidden' name='change_flag' id='change_flag' value=''>
      </from></body>
   
 
<html>
<%!
	
	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
%>

