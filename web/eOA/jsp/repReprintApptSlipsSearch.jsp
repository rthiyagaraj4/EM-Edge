
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>    
<%@ page contentType="text/html;charset=UTF-8"  import = "java.sql.*,java.text.*,webbeans.eCommon.*,java.util.*" %>
<html>
		<head>
		   <!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>
		    -->
			<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>


	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
		   <script language='javascript' src='../../eCommon/js/common.js'></script>
		   <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		   <script language='javascript' src='../../eOA/js/repReprintApptSlips.js'></script>
		   <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
			<script language="javascript" src="../../eCommon/js/CommonLookup.js"> </script>
			<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
			<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		</head>
<%
		   String facilityId = (String) session.getValue("facility_id");
		   Connection con = null;  
		   java.util.Properties p = (Properties) session.getValue("jdbc");
		   String user_name = (String) p.getProperty("login_user");
		   String p_passing_local_date="";
		   String locale = (String)session.getAttribute("LOCALE");
			if(locale.equals("th"))
			{
				p_passing_local_date="Y";
			}else 
			{
				p_passing_local_date="N";
			}
			


		   Statement stmt1=null;
		   ResultSet rs1 = null;
		   String sql1="";

		   Statement stmtk=null;
		   ResultSet rsk = null;
		   String sqlk="";


		   Statement stmt2=null;
		   ResultSet rs2 = null;
		   String sql2="";

		   Statement stmt4=null;
		   ResultSet rs4 = null;
		   String sql4="";
		  
		   String oper_stn_id="";
		   int max_length = 0;
		   request.setCharacterEncoding("UTF-8");

  
  try
  {
	  con = ConnectionManager.getConnection(request);  
   	sql1 = "select PATIENT_ID_LENGTH from mp_param";
   	stmt1 = con.createStatement();
   	rs1 = stmt1.executeQuery(sql1);

   	if (rs1 != null && rs1.next()) {
   	   max_length= rs1.getInt("PATIENT_ID_LENGTH");
	}
if(rs1 !=null) rs1.close();

   	      sql2 = "select a.oper_stn_id from am_oper_stn a, am_user_for_oper_stn b where a.facility_id ='"+facilityId+"' and a.facility_id = b.facility_id and a.oper_stn_id = b.oper_stn_id and b.appl_user_id = '"+ user_name +"' and trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to, trunc(sysdate)) ";

   	      stmt2 = con.createStatement();
   	      rs2 = stmt2.executeQuery(sql2);

	if(rs2 !=null){
   	      if(rs2.next()) {
                oper_stn_id = rs2.getString("oper_stn_id");
				if(oper_stn_id ==null) oper_stn_id="";
                if(rs2.next()) {
%>
                  <script language='javascript'>
                    var err1 = getMessage('MULTI_OPER_STN_FOR_USER','Common');
                    parent.messageFrame.document.location.href = "../../eCommon/jsp/error.jsp?err_num="+err1;
                  </script>
<%
                  return;
                }
   	      }
   	      else {
%>
                  <script language='javascript'>
                    var err2 = getMessage('NO_OPER_STN_FOR_USER','Common');
                    parent.messageFrame.document.location.href = "../../eCommon/jsp/error?err_num="+err2;
                  </script>

<%
		 return;
   	      }
		}   

%>
 <body onmousedown='CodeArrest()' onKeyDown = 'lockKey()'> 
  <form name='query_criteria_form' id='query_criteria_form' >
    <div>
    <table cellspacing='0' cellpadding='0' border='0' align='center' width='99%'>
      <tr>
				<td class='Label' width='25%' nowrap><fmt:message key="Common.apptno.label" bundle="${common_labels}"/></td>
				<td class='fields' width='25%'>
				<!--Mahesh addded for the IN:034921 GetApptDetails() in onblur as on 04/09/2012-->
				  <input type='text' name='appt_ref_no' id='appt_ref_no' size='8' onblur='GetApptDetails(appt_ref_no)' onKeyPress='return allowValidNumber(this,event,8,0)' maxlength='8' value=''></input>
				</td>
				<td class='Label' width='25%' ><fmt:message key="Common.apptdate.label" bundle="${common_labels}"/></td>
				<td class='fields' width='25%'>
				  <input type='text' id='apptdate' name='appt_date' id='appt_date' size='10' maxlength='10' value='' onblur='ValidateDate(this)'><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('apptdate');"></input></td>
				
      </tr>
      <tr>
				<td class='Label' width='25%' ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/> </td>
				<td class='fields' width='25%'  nowrap>
					 <% sqlk = " Select Locn_Type, Short_Desc,care_locn_type_ind from am_care_locn_type_lang_vw where sys_user_def_ind = 'S' and language_id='"+locale+"' and locn_type in ('C','E','Y') order by 2";
							   stmtk = con.createStatement();
								  rsk = stmtk.executeQuery(sqlk);
								  %>
									<SELECT name='p_location_type1' id='p_location_type1'  onchange="changeVal(this);//javascript:populateLocations(this);"> 						<option value='' style='align:center'>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --- 
											<%
										 String locn_type="";
															String short_desc="";
															while(rsk.next() && rsk !=null){
																locn_type=rsk.getString("care_locn_type_ind");
																short_desc=rsk.getString("short_desc");
																out.println("<option value='"+locn_type+"'>"+short_desc);
													}
													%>

									</SELECT></td>
					<td class='Label' width='25%' ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%'  nowrap>					
						<input type=text name='location_name' id='location_name' onblur='searchCode(this,location_name,location)' size='14' ><input type='hidden' name='location' id='location'  size='30' maxlength='30' ></input><input type='button' class='button' value='?'  name='search_location' id='search_location'  onClick="searchCode1(this,location_name,location);enable_disp_next(this);resource_enable();" >		  
						<input type=hidden name='resource_class' id='resource_class'  value="" ></input>
									<%
										sql4="select a.clinic_code,INITCAP(a.long_desc) long_desc from op_clinic_LANG_VW a, am_locn_for_oper_stn b where a.facility_id='"+facilityId+"' and a.facility_id = b.facility_id and a.clinic_code=b.locn_code and a.allow_appt_yn='Y' and a.level_of_care_ind = 'A' and a.eff_status='E' and b.oper_stn_id='"+oper_stn_id+"' AND language_id='"+locale+"' and b.eff_status='E'";
										
										stmt4 = con.createStatement();
										rs4 = stmt4.executeQuery(sql4);

											   if ( (rs4!=null) &&(rs4.next())) {

												}
												else {
									%>
													 <script language='javascropt'>
														var err5 = getMessage('NO_CLINICS_FOR_USER','Common');
														parent.messageFrame.document.location.href = "../../eCommon/jsp/error.jsp?err_num="+err5;
													 </script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



									<%
								 
							}

							%>
						  </select></td>
						
			</tr>

			<tr>
						<td class='Label' width='25%' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/> </td>
						<td class='fields' width='25%'>
						  <input type='text' name='patient_id' id='patient_id' size=<%=max_length%> maxlength=<%=max_length%> value='' onBlur="ChangeUpperCase(this);"></input><input type='button' name='search' id='search' value='?' class='Button' title='Search' onclick='search_click()' ></input> </td>

						  <jsp:include page="../../eOA/jsp/OAResourcelookupframe.jsp" ><jsp:param name="flush" value="true" />
						  <jsp:param name ="from_page" value= "reprint" />
						  <jsp:param name ="pract_value" value= "" />
						  </jsp:include>

						<!-- <td class='Label' width='25%'><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>
						<td class='fields' width='25%'>
							<input type=text name='practitioner_name' id='practitioner_name' disabled onblur="onblurcheck(this,practitioner_name);"  size='30' maxlength='30' ><input type=hidden name='practitioner' id='practitioner'  size='30' maxlength='30' ></input><input type='button' class='button' value='?'  disabled name='search_pract' id='search_pract' onMouseOver='resource_enable();' onClick="callPractSearch(this,practitioner_name)"></input></td> -->
						
		</tr>
		 <tr>
						<td class='Label'><fmt:message key="Common.Createdby.label" bundle="${common_labels}"/></td>
						<td class='fields' width='25%'>
						<input type=text name='entered_by_name' id='entered_by_name'  size='30' onblur='searchCode(this,entered_by_name,entered_by_id)' maxlength='30'><input type='hidden' name='entered_by_id' id='entered_by_id'  size='30' maxlength='30' ></input><input type='button' class='button' value='?' name='search_user' id='search_user'  onClick="searchCode1(this,entered_by_name,entered_by_id)"  >
						</td>
						<td class='Label'nowrap><fmt:message key="Common.CreatedOn.label" bundle="${common_labels}"/></td>
						<td class='fields' width='25%'>
						   <input type='text' id="entereddate" name='entered_date' id='entered_date' size='10' maxlength='10' value='' onblur='ValidateDate(this)'></input><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('entereddate');">
						</td>
					  
      </tr>

	  <tr>
					 <td class='button' colspan ='4' align="right">
						   <input type='button' name='select' id='select' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class='Button' title='Select' onclick='select_click1()'></input>
						   <input type='button' name='reprint_all'  id='reprint_all' value='<fmt:message key="Common.ReprintAll.label" bundle="${common_labels}"/>' class='Button' title='Reprint All' onclick='reprint_all_click()' disabled></input>
						</td>
		</tr>
	 
	
	</table>
<input type=hidden name='oper_stn_id' id='oper_stn_id'  size='30' maxlength='30' value = "<%=oper_stn_id%>" >
			   <input type="hidden" name="P_LOCATION_TYPE" id="P_LOCATION_TYPE"	value=''>
			    <input type="hidden" name="P_RESOURCE_CLASS" id="P_RESOURCE_CLASS" value=''>
				<input type='hidden' name='locale' id='locale' value='<%=locale%>'>


		   <div>

<%
     if (rs1 != null) rs1.close();
     if (rs2 != null) rs2.close();
	 if (rs4 != null) rs4.close();
	 if(rsk !=null)rsk.close();
	 if (stmt1 != null) stmt1.close();
     if (stmt2 != null) stmt2.close();
     if (stmt4 != null) stmt4.close();
	 if (stmt1 != null) stmt1.close();
	if(stmtk !=null)stmtk.close();
   } catch(Exception e) {
    // out.println("Exception"+e.toString());
	e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
   }
   finally {
  
	 ConnectionManager.returnConnection(con,request);
   }
%>

  </form>
</body><script>document.forms[0].appt_ref_no.focus();</script>
</html>
</html>

