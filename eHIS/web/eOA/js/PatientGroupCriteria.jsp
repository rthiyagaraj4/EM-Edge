<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.net.*, webbeans.eCommon.*" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%

	Connection con 				= null;
	PreparedStatement pstmt 	= null;
	ResultSet rs				=null;
	
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
	String pat_name_as_multipart_yn	= "";
	String first_name_length 	= "";
	String second_name_length 	= "";
	String third_name_length 	= "";
	String family_name_length 	= "";
	String file_type_appl_yn 	= "";
	String errFlag				= "";
%>

	<html>
	<head>	
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>	
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
	<script language='javascript' src='../../eOA/js/PatientGroup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<body OnMouseDown="CodeArrest();" onKeyDown = 'lockKey()'>
	<form name="GroupSearchCriteria" id="GroupSearchCriteria" id="GroupSearchCriteria">
	<table cellpadding='1' cellspacing='1' width='100%' border='0'>
		<tr>
		<td class = 'label'  width = '10%' nowrap><fmt:message key="Common.GroupName.label" bundle="${common_labels}"/></td>
					<td width='10%' class='fields'>
						<input type="hidden" name="group_id" id="group_id" >
						<input type="hidden" name="min_patient" id="min_patient" id="min_patient" >
						<input type="hidden" name="max_patient" id="max_patient" id="max_patient" >	
						<input type="hidden" name="Existing_Group_Members" id="Existing_Group_Members" id="Existing_Group_Members" >
						<input type="hidden" name="group_location_id" id="group_location_id" id="group_location_id" >
						<input type="text" name="group_name" id="group_name"  onblur='if(this.value!=""){callgroupname(this,document.forms[0].group_name,"insert")}else{clearValues("insert");}'><input type="button" name="group_name_lookup" id="group_name_lookup" value="?" class="button" onclick="callgroupname(this,document.forms[0].group_name,'insert')"><img align='center' src='../../eCommon/images/mandatory.gif'></img>
					</td>
		<td width='80%'  id="TdLocationResult"></td>
		</tr>
		<tr></tr>
		<tr></tr>
			
	</table>
	<%
		con = ConnectionManager.getConnection(request);
		String Qry_For_Param="SELECT   pat_name_as_multipart_yn, first_name_length, second_name_length,third_name_length,family_name_length FROM mp_param where module_id='MP'";
		pstmt = con.prepareStatement(Qry_For_Param);
	    rs=pstmt.executeQuery();
	   if(rs.next()){
			pat_name_as_multipart_yn	= checkForNull(rs.getString("pat_name_as_multipart_yn"));
			first_name_length 			= rs.getString("first_name_length");
			second_name_length			= rs.getString("second_name_length");
			third_name_length 			= rs.getString("third_name_length");
			family_name_length 			= rs.getString("family_name_length");
	    }else{
	        errFlag = "Y";
	        out.println("<script>alert(getMessage('MP_PARAM_NOT_FOUND','MP'));</script>");
	        out.println("<script>parent.window.close();</script>");         
	    }
		if(pstmt != null) pstmt.close();
		if(rs != null) rs.close();
		String firstRowElement="";
		String firstRowCompleted ="";
	    String Family_No_Link_Yn 			= "";
	    String Family_No_Prompt				= ""; 
	    String First_Name_Accept_Yn 		= "";
	    int First_Name_Order				= 0;
	    String First_Name_Prompt 			= "";
	    String Second_Name_Accept_Yn 		= "";
	    int Second_Name_Order				= 0;
	    String Second_Name_Prompt 			= "";
	    String Third_Name_Accept_Yn			= "";
	    int Third_Name_Order 				= 0;
	    String Third_Name_Prompt 			= "";
	    String Family_Name_Accept_Yn 		= ""; 
	    int Family_Name_Order 				= 0;
	    String Family_Name_Prompt			= "";
	    int patient_id_length				= 0;
		String Family_Name_loc_lang_Prompt	= "";
		String First_Name_loc_lang_Prompt	= "";
		String Second_Name_loc_lang_Prompt	= "";
		String Third_Name_loc_lang_Prompt	= "";
		
		 
		 
		 
		 try{
			 String Qry_For_Slct_Flds="SELECT param.family_no_link_yn,param.family_no_prompt, param.first_name_accept_yn,param.first_name_order, param.first_name_prompt,param.second_name_accept_yn, param.second_name_order,param.second_name_prompt, param.third_name_accept_yn,param.third_name_order, param.third_name_prompt,param.family_name_accept_yn, param.family_name_order,param.family_name_prompt, first_name_loc_lang_prompt,second_name_loc_lang_prompt, third_name_loc_lang_prompt,family_name_loc_lang_prompt FROM   mp_param_lang_vw param WHERE  param.module_id = 'MP' AND param.language_id = ?";
            
			 pstmt = con.prepareStatement(Qry_For_Slct_Flds);
			 pstmt.setString(1,locale);
			 rs = pstmt.executeQuery();
             if (rs !=null){
                   if (rs.next()){
                      
	                 Family_No_Link_Yn =rs.getString("Family_No_Link_Yn")== null ?  "N" : rs.getString("Family_No_Link_Yn");
	                 Family_No_Prompt =rs.getString("Family_No_Prompt")== null ? "Head of the Family" : rs.getString("Family_No_Prompt");
	              	
	                 First_Name_Accept_Yn = rs.getString("First_Name_Accept_Yn")==null ? "N" : rs.getString("First_Name_Accept_Yn");
	                 First_Name_Order = rs.getInt("First_Name_Order");
	                 First_Name_Prompt = rs.getString("First_Name_Prompt")==null ? "First Name" : rs.getString("First_Name_Prompt");
	                
	                 Second_Name_Accept_Yn = rs.getString("Second_Name_Accept_Yn")==null ? "N" : rs.getString("Second_Name_Accept_Yn");
	                 Second_Name_Order = rs.getInt("Second_Name_Order");
	                 Second_Name_Prompt = rs.getString("Second_Name_Prompt")==null ? "Second Name" : rs.getString("Second_Name_Prompt");
	                
	                 Third_Name_Accept_Yn = rs.getString("Third_Name_Accept_Yn")==null ? "N" : rs.getString("Third_Name_Accept_Yn");
	                 Third_Name_Order = rs.getInt("Third_Name_Order");
	                 Third_Name_Prompt = rs.getString("Third_Name_Prompt")==null ? "Third Name" : rs.getString("Third_Name_Prompt");

					 First_Name_loc_lang_Prompt=checkForNull(rs.getString("First_Name_loc_lang_Prompt"));
					 Second_Name_loc_lang_Prompt=checkForNull(rs.getString("Second_Name_loc_lang_Prompt"));
					 Third_Name_loc_lang_Prompt=checkForNull(rs.getString("Third_Name_loc_lang_Prompt"));
					 Family_Name_loc_lang_Prompt=checkForNull(rs.getString("Family_Name_loc_lang_Prompt"));

                	 Family_Name_Accept_Yn = rs.getString("Family_Name_Accept_Yn")==null ? "N" : rs.getString("Family_Name_Accept_Yn");
                 	 Family_Name_Order = rs.getInt("Family_Name_Order");
              
					 if(pat_name_as_multipart_yn.equals("N")){
						Family_Name_Order = 4;
					 }
					 Family_Name_Prompt = rs.getString("Family_Name_Prompt")==null ? "Family Name" : rs.getString("Family_Name_Prompt");
                   }
               }
           }catch(Exception e) { out.println(e.toString());}
           finally
           {
               if (pstmt != null) pstmt.close();
               if (rs != null) rs.close();
               if(con!=null) ConnectionManager.returnConnection(con,request);
           }

		 
		
	%>
	<div id="PatientSearchContainer" style="display:none;">
			 <table border="0" cellpadding="0" cellspacing="0" width="100%">
	              <tr>
	              	<td width='100%' class="BORDER" valign=top>
						<table border="0" cellpadding="0" cellspacing="0" width="100%">
						
							<tr>
							<%
									
						
								if(pat_name_as_multipart_yn.equals("Y")){  
	                                    if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) {
	                                    	out.println("<td   width='25%' class='label'>" + First_Name_Prompt + "</td>");
	                                        out.println("<td   width='25%' class='fields'><input type='text' name='First_Name' id='First_Name' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'></td>");
											firstRowElement="Y";
	                                    }
	                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ) {
	                                        out.println("<td  width='25%' class='label'>" + Second_Name_Prompt + "</td>");
	                                        out.println("<td   width='25%' class='fields' ><input type='text' name='Second_Name' id='Second_Name' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
											firstRowElement="Y";
	                                    }
	                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 ) {
	                                        out.println("<td   width='25%' class='label'>" + Third_Name_Prompt + "</td>");
	                                        out.println("<td    width='25%' class='fields'><input type='text' name='Third_Name' id='Third_Name' size='25' maxlength='15' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
											firstRowElement="Y";
	                                    }
	                                    else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 ) {
	                                        out.println("<td   width='25%' class='label'>" + Family_Name_Prompt + "</td>");
	                                        out.println("<td   width='25%' class='fields'><input type='text' name='Family_Name' id='Family_Name' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'   style=\"text-align:left\"></td>");
											firstRowElement="Y";
	                                    }
	                                    if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==0 ) {
	                                    out.println("<input type='hidden' name='First_Name' id='First_Name' >");
	                                }
	                                else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==0 ) {
	                                    out.println("<input type='hidden' name='Second_Name' id='Second_Name' >");
	                                }
	                                else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==0 ) {
	                                    out.println("<input type='hidden' name='Third_Name' id='Third_Name' >");
	                                }
	                                else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==0 ) {
	                                    out.println("<input type='hidden' name='Family_Name' id='Family_Name' >");
	                                    }
										 if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) {
	                                        out.println("<td  width='25%' class='label'>" + First_Name_Prompt + "</td>");
	                                        out.println("<td  width='25%' class='fields' ><input type='text' name='First_Name' id='First_Name' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'   style=\"text-align:left\"></td>");
											if(firstRowElement.equals("Y")){
												firstRowCompleted="Y";
											}else{
												firstRowElement="Y";
											}
	                                    }
	                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) {
	                                        out.println("<td  width='25%' class='label'>" + Second_Name_Prompt + "</td>");
	                                        out.println("<td  width='25%' class='fields' ><input type='text' name='Second_Name' id='Second_Name' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'   style=\"text-align:left\"></td>");
											if(firstRowElement.equals("Y")){
												firstRowCompleted="Y";
											}else{
												firstRowElement="Y";
											}
	                                    }
	                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 ) {
	                                        out.println("<td  width='25%' class='label'>" + Third_Name_Prompt + "</td>");
	                                        out.println("<td   width='25%' class='fields'><input type='text' name='Third_Name' id='Third_Name' size='25' maxlength='"+third_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
											if(firstRowElement.equals("Y")){
												firstRowCompleted="Y";
											}else{
												firstRowElement="Y";
											}
	                                    }
	                                    else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 ) {
	                                        out.println("<td   width='25%' class='label'>" + Family_Name_Prompt + "</td>");
	                                        out.println("<td   width='25%' class='fields'><input type='text' name='Family_Name' id='Family_Name' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'   style=\"text-align:left\"></td>");
											if(firstRowElement.equals("Y")){
												firstRowCompleted="Y";
											}else{
												firstRowElement="Y";
											}
	                                    }
	                                   
	
										if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 ) {
											if(firstRowCompleted.equals("Y")){
												out.println("</tr><tr>");
											}
	                                        out.println("<td   width='25%' class='label'>" + First_Name_Prompt + "</td>");
	                                        out.println("<td   width='25%' class='fields'><input type='text' name='First_Name' id='First_Name' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
											if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
												firstRowCompleted="Y";
											}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
												firstRowCompleted="N";
											}
	                                    }
	                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 ) {
											if(firstRowCompleted.equals("Y")){
												out.println("</tr><tr>");
											}
	                                        out.println("<td  width='25%'  class='label'>" + Second_Name_Prompt + "</td>");
	                                        out.println("<td   width='25%' class='fields'><input type='text' name='Second_Name' id='Second_Name' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'   style=\"text-align:left\"></td>");
											if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
												firstRowCompleted="Y";
											}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
												firstRowCompleted="N";
											}
	                                    }
	                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3 ) {
											if(firstRowCompleted.equals("Y")){
												out.println("</tr><tr>");
											}
	                                        out.println("<td  width='25%' class='label'>" + Third_Name_Prompt + "</td>");
	                                        out.println("<td   width='25%' class='fields'><input type='text' name='Third_Name' id='Third_Name' size='25' maxlength='"+third_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
											if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
												firstRowCompleted="Y";
											}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
												firstRowCompleted="N";
											}
	                                    }
	                                    else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 ) {
											if(firstRowCompleted.equals("Y")){
												out.println("</tr><tr>");
											}
	                                        out.println("<td   width='25%' class='label'>" + Family_Name_Prompt + "</td>");
	                                        out.println("<td   width='25%' class='fields'><input type='text' name='Family_Name' id='Family_Name' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
											if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
												firstRowCompleted="Y";
											}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
												firstRowCompleted="N";
											}
	                                    }
	                         
	                                    if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) {
											if(firstRowCompleted.equals("Y")){
												out.println("</tr><tr>");
											}
	                                        out.println("<td  width='25%' class='label'>" + First_Name_Prompt + "</td>");
	                                        out.println("<td   width='25%' class='fields' ><input type='text' name='First_Name' id='First_Name' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
	                                    }
	                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 ) {
											if(firstRowCompleted.equals("Y")){
												out.println("</tr><tr>");
											}
	                                        out.println("<td  width='25%' class='label'>" + Second_Name_Prompt + "</td>");
	                                        out.println("<td   width='25%' class='fields'><input type='text' name='Second_Name' id='Second_Name' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
	                                    }
	                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 ) {
											if(firstRowCompleted.equals("Y")){
												out.println("</tr><tr>");
											}
	                                        out.println("<td  width='25%' class='label'>" + Third_Name_Prompt + "</td>");
	                                        out.println("<td   width='25%' class='fields'><input type='text' name='Third_Name' id='Third_Name' size='25' maxlength='"+third_name_length+"'	onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
	                                    }
	                                   else
										  if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4) {
										   if(firstRowCompleted.equals("Y")){
												out.println("</tr><tr>");
											}
	                                        out.println("<td   width='25%' class='label'>" + Family_Name_Prompt + "</td>");
	                                        out.println("<td  width='25%' class='fields'><input type='text' name='Family_Name' id='Family_Name' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
											
									   }
									      else {
	                                        out.println("<td   class='label'>&nbsp;</td>");
	                                        out.println("<td   class='label'>&nbsp;</td>");
	                                    }
									}
									
									if (pat_name_as_multipart_yn.equals("N"))	
									{			out.println("<td nowrap  width='25%' class='label'>" + Family_Name_Prompt + "</td>");
												out.println("<td  nowrap class='fields' width='25%'><input type='text' name='Family_Name' id='Family_Name' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);EnableSearchBy(this);'     style=\"text-align:left\">");
												String startwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels");
												String contains = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels");
												String endwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels");
												out.println("&nbsp;&nbsp;<select name='Search_By' id='Search_By'><option value='S'>"+startwith+"</option><option value='C'>"+contains+"</option><option value='E'>"+endwith+"</option></select></td>");
										}
											else
											out.println("</td>");
									%>
								</tr>
							<tr style="margin-top:5px;">
								<td  width='25%' class="label"><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
								<td  width='25%' class="fields"><Select name="Sex" id="Sex"><Option value="A" ><fmt:message key="Common.all.label" bundle="${common_labels}"/><Option value="M" ><fmt:message key="Common.male.label" bundle="${common_labels}"/></option><Option value="F" ><fmt:message key="Common.female.label" bundle="${common_labels}"/></option><option value="U"><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option></Select></td>
							
								<td  width='25%' class="label"><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/> </td>
								<td  width='25%' class="fields"><input type="text" name="Dob" id="Dob" size="11"  onBlur="validDateObj(this,'DMY',localeName)" maxlength="10" ><img style="cursor='hand'" name='dobCal' src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('Dob',null,null,true);" >
								&nbsp;&nbsp;</td>
							</tr> 
							<tr>
							 	<td  class='label' ><fmt:message key="Common.MobileNo.label" bundle="${common_labels}"/></td>
                 			   	<td class='fields'><input type='text' name='MobileNo' id='MobileNo' maxlength='20' size='25'  onblur='makeValidString(this);' ></td>
								<td class='button' colspan='1' width='25%' align="right" ><input type="button" class='button' name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="callSearchResult()"><input type="button" class='button' name="clear" id="clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick="clearAll()" sgtyle="float:right;!important"></td>
							</tr>
							<tr>
								
							</tr>
						</table>
					</td>
	              </tr>
	          </table>
	          
	   	</div>       
	</form> 

<script>


function clearAll(){
	/*$('[name="First_Name"]').val('');
	$('[name="Second_Name"]').val('');
	$('[name="Third_Name"]').val('');
	$('[name="Family_Name"]').val('');
	$('[name="Dob"]').val('');
	$('[name="Sex"]').val('');
	$('[name="MobileNo"]').val('');*/
	parent.frames[2].location.href ="../../eCommon/html/blank.html";
}

function callSearchResult(){
	var First_Name = "";
	if(document.forms[0].First_Name) First_Name= document.forms[0].First_Name.value;
	var Second_Name = "";
	if(document.forms[0].Second_Name) Second_Name= document.forms[0].Second_Name.value;
	var Third_Name = "";
	if(document.forms[0].Third_Name) Third_Name= document.forms[0].Third_Name.value;
	var Family_Name = "";
	if(document.forms[0].Family_Name) First_Name= document.forms[0].Family_Name.value;

	var Dob = document.forms[0].Dob.value;
	var Sex = document.forms[0].Sex.value;
	var MobileNo	= document.forms[0].MobileNo.value;
	var GroupId	= document.forms[0].group_id.value;
	var Existing_Group_Members	= document.forms[0].Existing_Group_Members.value;
	var group_location_id	= document.forms[0].group_location_id.value;
	var max_patient	= document.forms[0].max_patient.value;
	if(First_Name=="" && Second_Name=="" && Third_Name=="" && Family_Name=="" && Dob=="" && Sex=="A" && MobileNo==""){
		alert(getMessage("ATLEAST_ONE_SELECTED", "common"));
		return;
	}
		parent.frames[2].location.href = "../../eOA/jsp/PatientGroupResult.jsp?First_Name="+First_Name+"&Second_Name="+Second_Name+"&Third_Name="+Third_Name+"&Family_Name="+Family_Name+"&Dob="+Dob+"&Sex="+Sex+"&MobileNo="+MobileNo+"&GroupId="+GroupId+"&Existing_Group_Members="+Existing_Group_Members+"&group_location_id="+group_location_id+"&max_patient="+max_patient+"&mode=insert";
}
function ChangeInitCase(obj){
	
  var name=obj.value;
  var spltval = name.split(" ") ;
  var temp_name = ""
 for(var i=0;i<spltval.length;i++) {
  var length= obj.value.length;
  var letter = spltval[i].substring(0,length-(length-1));
  var rest = spltval[i].substring(1,length);
  letter=letter.toUpperCase();
  rest=rest.toLowerCase();
  var  namenow= letter.concat(rest);
  temp_name+= namenow+" ";
 }
 obj.value= temp_name.substring(0,temp_name.length-1);

}
</script>
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
</body>
</html>

