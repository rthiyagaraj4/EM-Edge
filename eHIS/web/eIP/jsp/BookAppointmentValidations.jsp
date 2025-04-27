<%@ page  contentType="text/html;charset=UTF-8" import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,eCommon.XSSRequestWrapper" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>

<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%

request.setCharacterEncoding("UTF-8");
//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
String CA_Pat			= request.getParameter("CA_Pat");
String Unregpatbkgyn	= request.getParameter("Unregpatbkgyn");
String fromLookup		= request.getParameter("fromLookup");
String locale			= (String)session.getAttribute("LOCALE");
boolean continue_yn		= true;

if(fromLookup == null)		fromLookup		= "N";
if(Unregpatbkgyn == null)	Unregpatbkgyn	= "N";
if(CA_Pat == null)			CA_Pat			= "N";
%>
<script>

var continueFlag = "Y";
var continue_yn = 'Y';
var fromLookup = "<%=fromLookup%>";

function ClearValues()
{
	parent.document.frames[1].document.forms[0].date_of_birth.readOnly = false;
	parent.document.frames[1].document.forms[0].b_age.readOnly = false;
	parent.document.frames[1].document.forms[0].b_months.readOnly = false;
	parent.document.frames[1].document.forms[0].b_days.readOnly = false;
	parent.document.frames[1].document.forms[0].nationality_code1.disabled = false;
	parent.document.frames[1].document.forms[0].sex.disabled = false;

	parent.document.frames[1].document.forms[0].alt_id1_type.value = "";
	parent.document.frames[1].document.forms[0].patient_name.value = "";
	parent.document.frames[1].document.forms[0].date_of_birth.value = "";
	parent.document.frames[1].document.forms[0].b_age.value = "";
	parent.document.frames[1].document.forms[0].b_months.value = "";
	parent.document.frames[1].document.forms[0].b_days.value = "";
	parent.document.frames[1].document.forms[0].nationality_code1.value = "";
	parent.document.frames[1].document.forms[0].nationality_desc.value = "";
	parent.document.frames[1].document.forms[0].sex.value = "";
	parent.document.frames[1].document.forms[0].race_code.value = "";
	if(	parent.document.frames[1].document.forms[0].race_desc)
		parent.document.frames[1].document.forms[0].race_desc.value = "";

	if(parent.document.frames[1].document.forms[0].name_prefix1 != null)
	{
	   parent.document.frames[1].document.forms[0].name_prefix1.disabled = false;
	   parent.document.frames[1].document.forms[0].name_prefix1.value = "";
	}

	if(parent.document.frames[1].document.forms[0].first_name != null)
	{
	   parent.document.frames[1].document.forms[0].first_name.readOnly = false;
	   parent.document.frames[1].document.forms[0].first_name.value = "";
	}

	if(parent.document.frames[1].document.forms[0].second_name != null)
	{
	   parent.document.frames[1].document.forms[0].second_name.readOnly = false;
	   parent.document.frames[1].document.forms[0].second_name.value = "";
	}

	if(parent.document.frames[1].document.forms[0].third_name != null)
	{
	   parent.document.frames[1].document.forms[0].third_name.readOnly = false;
	   parent.document.frames[1].document.forms[0].third_name.value = "";
	}

	if(parent.document.frames[1].document.forms[0].family_name != null)
	{
	   parent.document.frames[1].document.forms[0].family_name.readOnly = false;
	   parent.document.frames[1].document.forms[0].family_name.value = "";
	}

	if(parent.document.frames[1].document.forms[0].name_suffix1 != null)
	{
	   parent.document.frames[1].document.forms[0].name_suffix1.disabled = false;
	   parent.document.frames[1].document.forms[0].name_suffix1.value = "";
	}

	if(parent.document.frames[1].document.forms[0].national_id_no)
	{
		parent.document.frames[1].document.forms[0].national_id_no.value = "";
		parent.document.frames[1].document.forms[0].national_id_no.disabled = false
	}



	if(parent.document.frames[1].document.forms[0].name_prefix_oth_lang != null)
	{
		parent.document.frames[1].document.forms[0].name_prefix_oth_lang.value = "";
	}


	if(parent.document.frames[1].document.forms[0].first_name_oth_lang != null)
	{
		parent.document.frames[1].document.forms[0].first_name_oth_lang.value = "";
	}

	if(parent.document.frames[1].document.forms[0].second_name_oth_lang != null)
	{
		parent.document.frames[1].document.forms[0].second_name_oth_lang.value = "";
	}

	if(parent.document.frames[1].document.forms[0].third_name_oth_lang != null)
	{
		parent.document.frames[1].document.forms[0].third_name_oth_lang.value = "";
	}

	if(parent.document.frames[1].document.forms[0].family_name_oth_lang != null)
	{
		parent.document.frames[1].document.forms[0].family_name_oth_lang.value = "";
	}


	if(parent.document.frames[1].document.forms[0].name_suffix_oth_lang != null)
	{
		parent.document.frames[1].document.forms[0].name_suffix_oth_lang.value = "";
	}
}

function DispalyValues(patinetid,referral_id)
{
	
	var CA_Pat = "<%=CA_Pat%>";
	if(referral_id != "")
	{
		var HTMLVal1 = new String();
		HTMLVal1 = "<HTML><BODY onKeyDown='lockKey()'><form name='form2' id='form2' method='post' action='../jsp/BookApptCheckForNat.jsp'><input type='hidden' name='step' id='step' value='first'><input name='referral_id' id='referral_id' type='hidden' value=\""+referral_id+"\"></form></form></BODY></HTML>";
		parent.document.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal1);
		parent.document.frames[2].document.forms[0].submit();
		
		parent.document.frames[1].document.forms[0].referral_id.readOnly = true;
		parent.document.frames[1].document.forms[0].referral_details.disabled = true;
	
	}
	else
	{
		
		var HTMLVal1 = new String();
		HTMLVal1 = "<HTML><BODY onKeyDown='lockKey()'><form name='form2' id='form2' method='post' action='../jsp/BookAppointmentValues.jsp'><input type='hidden' name='step' id='step' value='P'><input name='pat_id1' id='pat_id1' type='hidden' value=\""+patinetid+"\"><input name='CA_Pat' id='CA_Pat' type='hidden' value=\""+CA_Pat+"\"></form></BODY></HTML>";
		parent.document.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal1);
		
		parent.document.frames[2].document.form2.submit();

	}
}

</script>
<%
webbeans.op.PatientData patdata = new webbeans.op.PatientData();
Connection conn = null;
String facilityID=(String)session.getValue("facility_id");
String loginUser = (String)session.getValue("login_user");
ResultSet rs	= null;
ResultSet rs_p	= null;
ResultSet rset1	= null;
Statement stmt	= null;
Statement stmt1	= null;
Statement stmt1_p = null;
Statement stmta = null;
Statement stmtb = null;
StringBuffer sqlQuery = new StringBuffer();
String cont_yn = "Y";
int cnt = 0;

try{
		conn = ConnectionManager.getConnection(request);
		String patientid = request.getParameter("pat_id");
		out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='nam1' id='nam1'>");

		String step			= checkForNull(request.getParameter("step"));
		String alternateid	= checkForNull(request.getParameter("alt_id"));
		String referral_id	= checkForNull(request.getParameter("referral_id"));
		String step1		= checkForNull(request.getParameter("step1"));
		if(step1.equals("PatientClass"))
		{
			
			String patientClass = request.getParameter("patClass");
			String p_oper_stn_id = request.getParameter("p_oper_stn_id");
			String medservdesc   = "";
			String medservcode   = "";
			String generatenumyn = "";
			String app_pat_class = "";
			out.println("<script>");
			out.println("var obj =parent.document.frames[1].document.forms[0].med_service_grp;");
			out.println("var length  = obj.length;");
			out.println("for(i=0;i<length;i++) {obj.remove(1);}");

			sqlQuery.append(" select distinct IP_GET_DESC.IP_MEDICAL_SERVICE_GROUP(FACILITY_ID,med_ser_grp_code,'"+locale+"','2') med_ser_grp_short_desc, med_ser_grp_code, generate_num_yn, APPL_PATIENT_CLASS FROM IP_MED_SER_GRP_NURS_UT_TYPE_VW where facility_id = '"+facilityID+"' and nursing_unit_type_code IN(SELECT DISTINCT nursing_unit_type_code FROM IP_NURSING_UNIT a, am_os_user_locn_access_vw b WHERE a.facility_id='"+facilityID+"' AND a.facility_id=b.facility_id AND a.nursing_unit_code=b.locn_code AND b.oper_stn_id='"+p_oper_stn_id+"' AND b.appl_user_id='"+loginUser+"' AND b.admit_pat_yn='Y' and a.locn_type=b.locn_type AND A.EFF_STATUS='E') AND eff_status = 'E' and appl_patient_class = '"+patientClass+"' order by med_ser_grp_short_desc  ");
			try
			{
				stmt = conn.createStatement();
				rs	 = stmt.executeQuery(sqlQuery.toString());
			
       			if( rs != null )
				{
					while( rs.next() )
	  				{
					 
						 medservdesc   = rs.getString("med_ser_grp_short_desc") ;
						 medservcode   = rs.getString("med_ser_grp_code") ;	
						 generatenumyn = rs.getString("generate_num_yn") ;  
						 app_pat_class = rs.getString("APPL_PATIENT_CLASS") ;	
						
						String strTmp  = medservcode+"#"+generatenumyn+"#"+app_pat_class;
						
						out.println ("var opt= parent.document.frames[1].document.createElement('Option');\nopt.text=\""+medservdesc+"\"; opt.value=\""+strTmp+"\";\nobj.add(opt)") ;
						out.println ("parent.document.frames[1].document.createElement('Option')") ;
 					}
				out.println("</script>");
				if(rs !=null) rs.close(); if(stmt != null) stmt.close();
       		}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{	
		if(step.equals("Alternate"))
		{
			
			String alt_id_prompt = checkForNull(request.getParameter("alt_id_prompt"));
			stmt	= conn.createStatement();
			if(sqlQuery.length()>0) sqlQuery.delete(0,sqlQuery.length());
			sqlQuery.append("select count(*) as total from mp_patient where alt_id1_no='"+alternateid+"' ");
			rs = stmt.executeQuery(sqlQuery.toString());
			if(rs !=null && rs.next())
			cnt = rs.getInt("total");
			if(rs !=null) rs.close(); if(stmt != null) stmt.close();
			if(cnt > 1) 
			{
			%>
				<script>
					
					var error = getMessage("MORE_ALT_ID_FOUND",'common')
					error = error.replace('#',"<%=alt_id_prompt%>");
					alert(error);
					parent.document.frames[1].document.forms[0].alternate_id.value='';
					parent.document.frames[1].document.forms[0].alternate_id.focus();
				</script>
			<%
			}
			else if(cnt == 0) 
			{
			%>
				<script>
					
					var err = getMessage("INVALID_VALUE",'common');
					err = err.replace('#',"<%=alt_id_prompt%>");
					alert(err);
					parent.document.frames[1].document.forms[0].alternate_id.value='';
					parent.document.frames[1].document.forms[0].alternate_id.focus();
				</script>
			<%
			}
			else if(cnt == 1) 
			{
				patientid = "";
				stmt = conn.createStatement();
				if(sqlQuery.length()>0) sqlQuery.delete(0,sqlQuery.length());
				sqlQuery.append("select patient_id from mp_patient where alt_id1_no='"+alternateid+"'");
				rs = stmt.executeQuery(sqlQuery.toString());
				if(rs != null && rs.next())
				patientid = rs.getString("patient_id");
				if(rs != null)rs.close();if(stmt !=null) stmt.close();
			}
		}

		if(step.equals("Referral"))
		{
			String qryString = request.getParameter("qryString");
			session.putValue( "queryString", qryString ) ;
			patientid = "";
			stmt = conn.createStatement();
			if(sqlQuery.length()>0) sqlQuery.delete(0,sqlQuery.length());
			sqlQuery.append("select count(*) as total from pr_referral_register where referral_id ='"+referral_id+"' and REFERRED_FOR_IP= 'B' and STATUS = 'O' ");/*added status for IN016586*/
			/*Tuesday, July 13, 2010 , To_Facility_Id = '"+facilityId+"' added in where criteria for SRR20056-SCF-4837 [IN:022644]*/
			sqlQuery.append (" and To_Facility_Id = '"+facilityID+"'");
			rs = stmt.executeQuery(sqlQuery.toString());
			if(rs != null && rs.next())
			cnt = rs.getInt("total");
			if(rs !=null) rs.close(); if(stmt != null) stmt.close();
			if(cnt == 0) 
			{
				cont_yn = "N";
			%>
				<script>
					
					alert(getMessage("INV_REF_ID",'IP'));
					fromLookup = "Y";
					continue_yn = 'N';
					continueFlag = 'N';
					parent.document.frames[1].document.forms[0].referral_id.value="";
					parent.document.frames[1].document.forms[0].patient_id.value="";
					parent.document.frames[1].document.forms[0].referral_id.focus();
					ClearValues();
				
				</script>
			<%
			}
			else
			{
				stmt = conn.createStatement();
				if(sqlQuery.length()>0) sqlQuery.delete(0,sqlQuery.length());
				sqlQuery.append("select patient_id from  pr_referral_register where referral_id ='"+referral_id+"' and REFERRED_FOR_IP= 'B'");
				rs = stmt.executeQuery(sqlQuery.toString());
				if(rs != null && rs.next())
				patientid = checkForNull(rs.getString("patient_id"));
				if(rs !=null) rs.close(); if(stmt != null) stmt.close();
			}
		}

if(!patientid.equals("")) 
{
	String chkst=patdata.CheckStatus(conn,patientid);
	if(chkst.equals("DECEASED")) 
	{
		continue_yn = false;
	%>
		<script>
			
			alert(getMessage("PAT_DECEASED_NOT_ALLOWED","MP"));
			
			
			parent.document.frames[1].document.forms[0].referral_id.value="";
			parent.document.frames[1].document.forms[0].patient_id.value="";
			continue_yn = 'N';
			continueFlag = 'N';
			ClearValues();
			parent.document.frames[1].document.forms[0].referral_details.disabled = false;			
			parent.document.frames[1].document.forms[0].referral_id.disabled = false;  // Added by Suresh M on 22.July.2010 for IN022827
			parent.document.frames[1].document.forms[0].referral_id.focus();
			
		
		</script>
	<%
		patientid = ""; 
		
	}
	if(chkst.equals("SUSPENDED"))
		
	{
		continue_yn = false;
	%>
		<script >
			
			var err_age2 = getMessage( "PAT_SUSPENDED_NOT_ALLOWED","MP");
			
			parent.document.frames[1].document.forms[0].patient_id.value="";
			ClearValues();
			alert(err_age2);
			parent.document.frames[1].document.forms[0].patient_id.focus();
			parent.window.reset();
			if(parent.document.frames[1].document.forms[0].referral_id)	
				parent.document.frames[1].document.forms[0].referral_id.value="";

			parent.document.frames[1].document.forms[0].patient_id.value="";
			continue_yn = 'N';
			continueFlag = 'N';
			parent.document.frames[1].document.forms[0].patient_id.focus();
			
		</script>
<%

		patientid = ""; 
	
	}
	if(chkst.equals("INACTIVE")) 
	{
		continue_yn = false;
%>
		<script >
			
			parent.document.frames[1].document.forms[0].patient_id.value="";
			ClearValues();
			var err_age3 = getMessage( "PAT_INACTIVE_NOT_ALLOWED","MP" ) ;
			alert(err_age3);
			parent.document.frames[1].document.forms[0].patient_id.focus();
				
			parent.window.reset();
			

			
			if(parent.document.frames[1].document.forms[0].referral_id)	
				parent.document.frames[1].document.forms[0].referral_id.value="";

			parent.document.frames[1].document.forms[0].patient_id.value="";
			continue_yn = 'N';
			continueFlag = 'N';
			ClearValues();
			parent.document.frames[1].document.forms[0].patient_id.focus();

		</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%
		
		patientid = ""; 
		
	}
	if(chkst.equals("INVALID_PATIENT")) 
	{
		continue_yn = false;
%>
		<script>
			
			alert(getMessage("INVALID_PATIENT","MP"));
			parent.document.frames[1].document.forms[0].patient_id.value='';
			parent.document.frames[1].document.forms[0].patient_id.focus();
			parent.document.frames[1].document.forms[0].patient_id.select();
			continue_yn = 'N';
			continueFlag = 'N';
			ClearValues();
			
		</script>
<%
	}
	if (chkst.indexOf("PATIENT_MERGED_VALID")>=0 )
	{
		continue_yn = false;
				StringTokenizer token=new StringTokenizer(chkst,"$");
				String valid_patient_id = token.nextToken();
				valid_patient_id = token.nextToken();
			%> 
				<script>
					
					var error= getMessage( "PATIENT_MERGED_VALID","MP");
					error = error.replace('#',"<%=valid_patient_id%>");
					alert(error);	
					continue_yn = 'N';
					continueFlag = 'N';
					parent.document.frames[1].document.forms[0].patient_id.value="<%=valid_patient_id%>";
					parent.document.frames[1].document.forms[0].patient_id.focus();
					parent.document.frames[1].document.forms[0].patient_id.select();
				</script> 
				<%		
	}
	if(continue_yn == true)
	{
		String alt_status = patdata.CheckAlternateId(conn,patientid,locale);

		  char alt_stat = 'Y';
		  if (alt_status.equals("alt_id1_expired") && alt_stat != 'N')
		  {
			alt_stat = 'N';
			stmt = conn.createStatement() ;
			rs = stmt.executeQuery("select alt_id1_type from mp_param");
			String altid_type  = "";
			if( rs != null && rs.next())
			altid_type = rs.getString("alt_id1_type");
			%> 
			<script>
			
			var err_age3 = getMessage( "ALT_ID_EXPIRED_CONFIRM","MP");
			err_age3 = err_age3.replace('$',"<%=altid_type%>");
			var p = confirm(err_age3);	

			if (!p)	
			{
				parent.window.reset();

			}
			else DispalyValues("<%=patientid%>","<%=referral_id%>");
			 </script> 
			<%
				 if(rs !=null) rs.close(); if(stmt != null) stmt.close();
		  }
		  else if (alt_status.equals("alt_id2_expired") && alt_stat != 'N')
		  {
				stmt = conn.createStatement() ;
				rs = stmt.executeQuery("select alt_id2_type from mp_param");
				rs.next();
			%> 
			<script>
				
				var msg = getMessage('ALT_ID_EXPIRED','MP');
				msg = msg.replace('$',"<%=rs.getString(1)%>");
				alert(msg);	
				DispalyValues("<%=patientid%>","<%=referral_id%>");
			</script> 
			<%
			if(rs !=null) rs.close(); if(stmt1 != null) stmt1.close();
			alt_stat = 'N';
		  }
		  else if (alt_status.equals("alt_id3_expired") && alt_stat != 'N')
		  {
			//continue_yn = 'N';
			stmt1 = conn.createStatement() ;
			rs = stmt1.executeQuery("select alt_id3_type from mp_param");
			rs.next();
			%> 
			<script>
				
				var msg = getMessage('ALT_ID_EXPIRED','MP')
				msg = msg.replace('$',"<%=rs.getString(1)%>");
				alert(msg);	
				DispalyValues("<%=patientid%>","<%=referral_id%>");
			</script> 
			<%
			if(rs !=null) rs.close(); if(stmt1 != null) stmt1.close();
			alt_stat = 'N';
		  }
		  else if (alt_status.equals("alt_id4_expired") && alt_stat != 'N')
		  {
			stmt1 = conn.createStatement() ;
			rs = stmt1.executeQuery("select alt_id4_type from mp_param");
			rs.next();
			%> 
			<script>
				
				var msg = getMessage('ALT_ID_EXPIRED','MP')
				msg = msg.replace('$',"<%=rs.getString(1)%>");
				alert(msg);	
				DispalyValues("<%=patientid%>","<%=referral_id%>");
			</script> 
			<%
				if(rs !=null) rs.close(); if(stmt1 != null) stmt1.close();
			alt_stat = 'N';
		  }
 
		  if (alt_stat!='N'&& alt_status!="")
		  {
				if (alt_status.indexOf("ALT_ID1_IN_GRACE")>=0)
				{
				alt_stat = 'N';
				stmt1 = conn.createStatement() ;
			rs = stmt1.executeQuery("select alt_id1_type from mp_param");
			rs.next();
				%> 
				<script>
					
					var err_age3 = getMessage( "ALT_ID_EXP_WITH_GRACE","MP");
					err_age3 = err_age3.replace('$',"<%=rs.getString(1)%>");
					alert(err_age3);	
				 </script> 
				<%	
					 if(rs !=null) rs.close(); if(stmt1 != null) stmt1.close();
				}
				else if (alt_status.indexOf("ALT_ID2_IN_GRACE")>=0 && alt_stat != 'N')
				{
					stmt1_p = conn.createStatement() ;
					rs_p = stmt1_p.executeQuery("select alt_id2_type from mp_param");
					rs_p.next();
					%> 
					<script>
						
						var msg = getMessage('ALT_ID_EXPIRED','MP')
						msg = msg.replace('$',"<%=rs_p.getString(1)%>");
						alert(msg);
					</script> 
					<%
					if(rs_p !=null) rs_p.close(); if(stmt1_p != null) stmt1_p.close();
					alt_stat = 'N';
				}		
				else if (alt_status.indexOf("ALT_ID3_IN_GRACE")>=0 && alt_stat != 'N')
				{
					stmt1_p = conn.createStatement() ;
					rs_p = stmt1_p.executeQuery("select alt_id3_type from mp_param");
					rs_p.next();
			%> 
				<script>
					
					var msg = getMessage('ALT_ID_EXPIRED','MP')
					msg = msg.replace('$',"<%=rs_p.getString(1)%>");
					alert(msg);
				</script> 
			<%
					if(rs_p !=null) rs_p.close(); if(stmt1_p != null) stmt1_p.close();
					alt_stat = 'N';
				}		
				else if (alt_status.indexOf("ALT_ID4_IN_GRACE")>=0 && alt_stat != 'N')
				{
					stmt1_p = conn.createStatement() ;
					rs_p = stmt1_p.executeQuery("select alt_id4_type from mp_param");
					rs_p.next();
			%> 
				<script>
					
					var msg = getMessage('ALT_ID_EXPIRED','MP')
					msg = msg.replace('$',"<%=rs_p.getString(1)%>");
					alert(msg);
				</script> 
				<%
					if(rs_p !=null) rs_p.close(); if(stmt1_p != null) stmt1_p.close();
					alt_stat = 'N';
			  }		
		}

		if (alt_stat!='N'&& alt_status!="")
		{
			if (alt_status.indexOf("ALT_ID1_EXP_WITHIN")>=0 && alt_stat != 'N')
			{
				alt_stat = 'N';
				StringTokenizer token=new StringTokenizer(alt_status,"$");
				String days1 = token.nextToken();
				days1 = token.nextToken();
				alt_stat='N';
				stmt1 = conn.createStatement() ;
			rs = stmt1.executeQuery("select alt_id1_type from mp_param");
			rs.next();
			%> 
				<script>
					
					var err_age3 = getMessage( "ALT_ID_EXP_WITHIN","MP");
					err_age3 = err_age3.replace('$',"<%=rs.getString(1)%>");
					alert(err_age3+" "+"<%=days1%> "+getLabel("Common.days.label","Common"));	
				</script> 
				<%
				if(rs !=null) rs.close(); if(stmt1 != null) stmt1.close();
			}
			else if (alt_status.indexOf("ALT_ID2_EXP_WITHIN")>=0 && alt_stat != 'N')
			{
				StringTokenizer token=new StringTokenizer(alt_status,"$");
				String days1 = token.nextToken();
				days1 = token.nextToken();
				stmt1_p = conn.createStatement() ;
				rs_p = stmt1_p.executeQuery("select alt_id2_type from mp_param");
				rs_p.next();
			%> 
				<script>
					
					var msg = getMessage('ALT_ID_EXP_WITHIN',"MP");
					msg = msg.replace('$',"<%=rs_p.getString(1)%>");
					alert(msg+" "+"<%=days1%> "+getLabel("Common.days.label","Common"));	
				</script> 
				<%
				if(rs_p !=null) rs_p.close(); if(stmt1_p != null) stmt1_p.close();
				alt_stat = 'N';
			}		
			else if (alt_status.indexOf("ALT_ID3_EXP_WITHIN")>=0 && alt_stat != 'N')
			{
				StringTokenizer token=new StringTokenizer(alt_status,"$");
				String days1 = token.nextToken();
				days1 = token.nextToken();
				stmt1_p = conn.createStatement() ;
				rs_p = stmt1_p.executeQuery("select alt_id3_type from mp_param");
				rs_p.next();
			%> <script>
				
				var msg = getMessage('ALT_ID_EXP_WITHIN',"MP")
				msg = msg.replace('$',"<%=rs_p.getString(1)%>");
				alert(msg+" "+"<%=days1%> "+getLabel("Common.days.label","Common"));	
			</script> <%
				if(rs_p !=null) rs_p.close(); if(stmt1_p != null) stmt1_p.close();
				alt_stat = 'N';
			}		
			else if (alt_status.indexOf("ALT_ID4_EXP_WITHIN")>=0 && alt_stat != 'N')
			{
				StringTokenizer token=new StringTokenizer(alt_status,"$");
				String days1 = token.nextToken();
				days1 = token.nextToken();
				stmt1_p = conn.createStatement() ;
				rs_p = stmt1_p.executeQuery("select alt_id4_type from mp_param");
				rs_p.next();
				%> 
				<script>
					
					var msg = getMessage('ALT_ID_EXP_WITHIN',"MP")
					msg = msg.replace('$',"<%=rs_p.getString(1)%>");
					alert(msg+" "+"<%=days1%> "+getLabel("Common.days.label","Common"));	
					</script> 
				<%
				if(rs_p !=null) rs_p.close(); if(stmt1_p != null) stmt1_p.close();
				alt_stat = 'N';
			}		
		}

		
%>		
			<script>

		if (continue_yn != 'N')
		{
				DispalyValues("<%=patientid%>","<%=referral_id%>");
		}
			</script>
<%		
	}
}
else
{	
	%>
	<script>
		async function bookAppointMentvalidation(){
		var Unregpatbkgyn = "<%=Unregpatbkgyn%>";
		var step = "<%=step%>";
		
		if(fromLookup =="N"  && step!="Alternate")
		{
			if(Unregpatbkgyn == "N")
			{
			var referral_id = "<%=referral_id%>"
			var retVal =    new String();
			var dialogHeight= "50vh" ;
			var dialogWidth = "40vw" ;
			var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
			var arguments   = "" ;
			
			retVal = await window.showModalDialog("../../eMP/jsp/VisitRegistrationPromptPatID.jsp?func_act=REF_SEARCH&q_from_funct=IP_ADMISSION&calledFrom=Booking&Unregpatbkgyn="+Unregpatbkgyn+"&p_referral_id="+referral_id,arguments,features);
			}
		
		if(retVal!=null) 
		{	
			if(retVal!='C' && retVal!='undefined')
			{	
				//parent.frames[1].document.booking_form.patient_id.value="<%=referral_id%>";
				/*Above line commented and below line Added for this incident [IN043737]*/
				parent.frames[1].document.booking_form.patient_id.value=retVal;
				parent.frames[1].document.booking_form.med_service_grp.focus();
			}
			else
			{
				alert(getMessage( "ALLOW_UNREGISTERED","IP"));
				parent.frames[1].document.booking_form.referral_id.value ='';
				continueFlag = "N";
				parent.frames[1].document.booking_form.pref_adm_date.focus();
				
				
			}
		}
		else
		{  
			if(Unregpatbkgyn == "Y")
			{
				if(retVal!= undefined)	 // if condition added on 26-09-2003 by dhanasekaran
				{
					parent.frames[1].document.booking_form.patient_id.value=retVal;
					parent.frames[1].document.booking_form.med_service_grp.focus();
				}
			}
			else{
			
			alert(getMessage( "ALLOW_UNREGISTERED","IP"));
			parent.frames[1].document.booking_form.referral_id.value ='';
			continueFlag = "N";
			parent.frames[1].document.booking_form.pref_adm_date.focus();
			
			}
		}
	}
}
		bookAppointMentvalidation();
	</script>

<%
	
}
if(step.equals("Referral") && cont_yn.equals("Y"))
{%>
	  <script>
	if(continueFlag == "Y")
	{
		var HTMLVal1 = new String();
		HTMLVal1 = "<HTML><BODY onKeyDown='lockKey()'><form name='form3' id='form3' method='post' action='../jsp/BookApptCheckForNat.jsp'><input type='hidden' name='step' id='step' value='first'><input name='referral_id' id='referral_id' type='hidden' value=\"<%=referral_id%>\"></form></form></BODY></HTML>";
		parent.document.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal1);
		parent.document.frames[2].document.form3.submit();
	}
	 </script>	
<%}
}
}
catch(Exception e) {
	//out.println(e.toString());
	e.printStackTrace();}
finally
{
	if(rs != null) rs.close();	
	if(rs_p != null) rs_p.close();	
	if(rset1 != null) rset1.close();	
	if(stmt !=null) stmt.close();
	if(stmt1 !=null) stmt1.close();
	if(stmt1_p !=null) stmt1_p.close();
	if(stmta !=null) stmta.close();
	if(stmtb !=null) stmtb.close();
	ConnectionManager.returnConnection(conn,request);
}
%>
<script>
function  enableNatId1(callobj)
{
	if(callobj == "Apply")
	{
		varBodyFrame = "f_query_add_mod.document";
	}
	else
	{
		varBodyFrame = "parent.document.frames[1]";
	}
	if(eval(varBodyFrame+".document.getElementById("birth_place")") != null)
		eval(varBodyFrame+".document.getElementById("birth_place")").disabled = false;
	if(eval(varBodyFrame+".document.getElementById("ethnic_group")") != null)
		eval(varBodyFrame+".document.getElementById("ethnic_group")").disabled = false;
	if(eval(varBodyFrame+".document.getElementById("place_of_birth")") != null)
		eval(varBodyFrame+".document.getElementById("place_of_birth")").disabled = false;
	/*
	if(eval(varBodyFrame+".document.getElementById("race_code")") != null)
		eval(varBodyFrame+".document.getElementById("race_code")").disabled = false;
	*/
	if(eval(varBodyFrame+".document.getElementById("race_desc")") != null) {
		eval(varBodyFrame+".document.getElementById("race_desc")").disabled = false;
		eval(varBodyFrame+".document.getElementById("race_desc_id")").disabled = false;
	}

	if(eval(varBodyFrame+".document.getElementById("patient_name")") != null)
		eval(varBodyFrame+".document.getElementById("patient_name")").disabled = false;
	if(eval(varBodyFrame+".document.getElementById("name_prefix1")") != null)
		eval(varBodyFrame+".document.getElementById("name_prefix1")").disabled = false;
	if(eval(varBodyFrame+".document.getElementById("name_prefix")") != null)
		eval(varBodyFrame+".document.getElementById("name_prefix")").disabled = false;
	if(eval(varBodyFrame+".document.getElementById("first_name")") != null)
		eval(varBodyFrame+".document.getElementById("first_name")").disabled = false;
	if(eval(varBodyFrame+".document.getElementById("second_name")") != null)
		eval(varBodyFrame+".document.getElementById("second_name")").disabled = false
	if(eval(varBodyFrame+".document.getElementById("third_name")") != null)
		eval(varBodyFrame+".document.getElementById("third_name")").disabled = false;
	if(eval(varBodyFrame+".document.getElementById("family_name")") != null)
		eval(varBodyFrame+".document.getElementById("family_name")").disabled = false;
	if(eval(varBodyFrame+".document.getElementById("name_suffix1")") != null)
		eval(varBodyFrame+".document.getElementById("name_suffix1")").disabled = false;
	if(eval(varBodyFrame+".document.getElementById("name_suffix")") != null)
		eval(varBodyFrame+".document.getElementById("name_suffix")").disabled = false;
	if(eval(varBodyFrame+".document.getElementById("sex")") != null)
		eval(varBodyFrame+".document.getElementById("sex")").disabled = false;
	if(eval(varBodyFrame+".document.getElementById("date_of_birth")") != null)
		eval(varBodyFrame+".document.getElementById("date_of_birth")").disabled = false;
	if(eval(varBodyFrame+".document.getElementById("b_age")") != null)
		eval(varBodyFrame+".document.getElementById("b_age")").disabled = false;
	if(eval(varBodyFrame+".document.getElementById("b_months")") != null)
		eval(varBodyFrame+".document.getElementById("b_months")").disabled = false;
	if(eval(varBodyFrame+".document.getElementById("b_days")") != null)
		eval(varBodyFrame+".document.getElementById("b_days")").disabled = false;
	if(eval(varBodyFrame+".document.getElementById("dob")") != null)
		eval(varBodyFrame+".document.getElementById("dob")").disabled = false;
	if(eval(varBodyFrame+".document.getElementById("nationality_code1")") != null)
		eval(varBodyFrame+".document.getElementById("nationality_code1")").disabled = false
	if(eval(varBodyFrame+".document.getElementById("citizen_yn")[0]") != null)
		eval(varBodyFrame+".document.getElementById("citizen_yn")[0]").disabled = false;		
	if(eval(varBodyFrame+".document.getElementById("citizen_yn")[1]") != null)
		eval(varBodyFrame+".document.getElementById("citizen_yn")[1]").disabled = false;	
	if(eval(varBodyFrame+".document.getElementById("national_id_no")") != null)
		eval(varBodyFrame+".document.getElementById("national_id_no")").disabled = false;
	if(eval(varBodyFrame+".document.getElementById("alt_id1_no")") != null)
		eval(varBodyFrame+".document.getElementById("alt_id1_no")").disabled = false;
	if(eval(varBodyFrame+".document.getElementById("alt_id2_no")") != null)
		eval(varBodyFrame+".document.getElementById("alt_id2_no")").disabled = false;
	if(eval(varBodyFrame+".document.getElementById("alt_id3_no")") != null)
		eval(varBodyFrame+".document.getElementById("alt_id3_no")").disabled = false;
	if(eval(varBodyFrame+".document.getElementById("alt_id4_no")") != null)
		eval(varBodyFrame+".document.getElementById("alt_id4_no")").disabled = false;			
	if(eval(varBodyFrame+".document.getElementById("alt_id1_exp_date")") != null)
		eval(varBodyFrame+".document.getElementById("alt_id1_exp_date")").disabled = false;
	if(eval(varBodyFrame+".document.getElementById("alt_id2_exp_date")") != null)
		eval(varBodyFrame+".document.getElementById("alt_id2_exp_date")").disabled = false;
	if(eval(varBodyFrame+".document.getElementById("alt_id3_exp_date")") != null)
		eval(varBodyFrame+".document.getElementById("alt_id3_exp_date")").disabled = false;
	if(eval(varBodyFrame+".document.getElementById("alt_id4_exp_date")") != null)
		eval(varBodyFrame+".document.getElementById("alt_id4_exp_date")").disabled = false;	
	if(eval(varBodyFrame+".document.getElementById("other_alt_type")") != null)
		eval(varBodyFrame+".document.getElementById("other_alt_type")").disabled = false;
	if(eval(varBodyFrame+".document.getElementById("other_alt_Id")") != null)
		eval(varBodyFrame+".document.getElementById("other_alt_Id")").disabled = false;
	return true;
}

</script>
</html>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

