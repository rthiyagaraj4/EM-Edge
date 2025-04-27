<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.util.*,java.io.*,webbeans.eCommon.ConnectionManager" %>	

<html>
	<title><fmt:message key="eMP.ReferralNotes.label" bundle="${mp_labels}"/></title>
	<head>
		<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
		<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    String locale =((String)session.getAttribute("LOCALE"));
    request.setCharacterEncoding("UTF-8");
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
	</head>
	<body class='MESSAGE' onKeyDown = 'lockKey();'>			
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		
		<script src='../../eMP/js/RegPatReferral.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	String pr_id = request.getParameter("process_id");
	boolean fromProcess9=false;     
	
	String practitioner = request.getParameter("practitioner");
	if (practitioner==null)practitioner="";
	String referral_type = request.getParameter("referral_type");
	if (referral_type==null)referral_type="";
	String service_code = request.getParameter("service_code");
	if (service_code==null)service_code="";

    String p_call_func=request.getParameter("pcallfunc");
	if(p_call_func == null || p_call_func.equals("null")) p_call_func="";

	String funid=request.getParameter("funid");
	if(funid== null || funid.equals("null")) funid="";
	String locntypecode="";
	String locntypedesc="";
	
	String facilityname = "";

	int process = Integer.parseInt(pr_id);
	

	String rd_operational_yn=request.getParameter("rd_operational_yn");
	if(rd_operational_yn == null)rd_operational_yn="N";
	
	Connection con = null;
	
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	ResultSet rs = null;
	ResultSet rs1 = null;
		
	String loginfacility = (String) session.getValue("facility_id");
	String sql = "";
	StringBuffer sql1= new StringBuffer();
	try
	{
		con = ConnectionManager.getConnection(request);

		if (process == 7)
		{
			String referral_text = request.getParameter("referral_text") ;
			if(referral_text ==null)    referral_text  = "";
			StringBuffer text=new StringBuffer();
			text.setLength(0);
			StringTokenizer token=new StringTokenizer(referral_text,"`,");
			while(token.hasMoreTokens())
			{                
			  text.append(token.nextToken()).append("\n");
			}
			%>
			<form method=post action="">
				<table cellpadding=0 cellspacing=0 width='100%' align=center>
					<tr>
						<td width='2%'>&nbsp;</td>
						<td>&nbsp;</td>
						<td width='2%'>&nbsp;</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td><textarea name="referral_notes" id="referral_notes"   onBlur = 'makeValidString(this);checkMaxLen(this);' rows="6" cols="100"><%=text.toString()%></textarea></td>
						<td>&nbsp;</td>
					</tr> 
					<tr>
						<td>&nbsp;</td>
						<td align=center>	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp<input type=button class=button name=Close value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onclick='close_me()'></td>
						<td>&nbsp;</td>
					</tr>			
					<tr>
						<td width='2%'>&nbsp;</td>
						<td>&nbsp;</td>
						<td width='2%'>&nbsp;</td>
					</tr>

		<%
			text.setLength(0);
		}
		else
		{			

			if(process == 4)
			{
			webbeans.op.PatientData patdata = new webbeans.op.PatientData();
			String pat_id = request.getParameter("pat_id");
			sql1.append("Select a.patient_id,name_prefix,first_name,second_name,third_name,family_name_prefix,family_name, name_suffix,patient_name,sex,to_char(date_of_birth,'dd/mm/yyyy') date_of_birth,nationality_code,contact1_no primary_resi_no,contact2_no Other_Resi_No,nvl(active_yn,'N') active_yn,nvl(suspend_yn,'N') suspend_yn, nvl(deceased_yn,'N')  deceased_yn  ,");			
			sql1.append(" b.addr1_line1,b.addr1_line2,b.addr1_line3,b.addr1_line4,pref_facility_id, calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),1) y,calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),2) m,calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),3) d ");
			sql1.append(" from mp_patient a, mp_pat_addresses b where a.patient_id = '"+pat_id+"' and a.patient_id = b.patient_id ");

			pstmt=con.prepareStatement(sql1.toString());
			rs = pstmt1.executeQuery();			
			if ( rs != null && rs.next() )
			{
				int DAYSq=0,MONTHSq=0,AGEq=0;	
				String pop_flag = "Y";
				AGEq= rs.getInt("y");
				MONTHSq = rs.getInt("m");
				DAYSq = rs.getInt("d");
			
				if(rs.getString("deceased_yn").equals("Y") && pop_flag.equals("Y"))
				{	
					%>
					<script>
						alert(getMessage('PAT_DECEASED_NOT_ALLOWE','MP'));					parent.f_query_add_mod.document.frames[0].document.getElementById("patient_id").value =""; 					parent.f_query_add_mod.document.frames[0].document.getElementById("patient_id").focus();
					</script>
					<%
					pop_flag = "N";
				}

				if(rs.getString("suspend_yn").equals("Y") && pop_flag.equals("Y"))
				{	
					%>
					<script>
						alert(getMessage('PAT_SUSPENDED_NOT_ALLOWED','MP'));
						parent.f_query_add_mod.document.frames[0].document.getElementById('patient_id').value =""; 
						parent.f_query_add_mod.document.frames[0].document.getElementById('patient_id').focus();
					</script>
					<%
					pop_flag = "N";
				}
				if (rs.getString("active_yn").equals("N") && pop_flag.equals("Y")) 
				{	
					%>
					<script>
						alert(getMessage('PATIENT_INACTIVE','MP'));
						parent.f_query_add_mod.document.frames[0].document.getElementById('patient_id').value =""; 
						parent.f_query_add_mod.document.frames[0].document.getElementById('patient_id').focus();
					</script>
					<%
					pop_flag = "N";
				}

				if (pop_flag.equals("Y"))
				{
					if(!rs.getString("pref_facility_id").equals(loginfacility))
					{						
						pstmt1=con.prepareStatement("select facility_name from sm_facility_param_lang_vw where FACILITY_ID = '"+rs.getString("pref_facility_id")+"' and language_id='"+locale+"'");
						
						rs1= pstmt1.executeQuery();
						if(rs1.next())
						{
							facilityname = rs1.getString("facility_name");
						}
						
						if(rs1 != null) rs1.close();
						if(pstmt1 != null) pstmt1.close();
						%>
							<script>
								var mes=getMessage("PATIENT_DESIG_FACILITY","MP");
								mes=mes.replace('"','<%=facilityname%>');
								alert(mes);
							</script>
						<%						
					}
					%>
					<script>				
						if(parent.f_query_add_mod.document.frames[0].document.getElementById('name_prefix') != null)
						{
							var obj = parent.f_query_add_mod.document.frames[0].document.getElementById('name_prefix').options;
							for(var k=0;k<obj.options.length;k++)
							{	
								if(obj.options[k].value == "<%=rs.getString("name_prefix")%>")
									obj.options[k].selected = true;
							}
						}						
						if(parent.f_query_add_mod.document.frames[0].document.getElementById('first_name') != null)
							parent.f_query_add_mod.document.frames[0].document.getElementById('first_name').value = "<%=rs.getString("first_name")==null?"":rs.getString("first_name")%>"
						if(parent.f_query_add_mod.document.frames[0].document.getElementById('second_name') != null)
							parent.f_query_add_mod.document.frames[0].document.getElementById('second_name').value = "<%=rs.getString("second_name")==null?"":rs.getString("second_name")%>"
						if(parent.f_query_add_mod.document.frames[0].document.getElementById('third_name') != null)
									parent.f_query_add_mod.document.frames[0].document.getElementById('third_name').value = "<%=rs.getString("third_name")==null?"":rs.getString("third_name")%>"
						if(parent.f_query_add_mod.document.frames[0].document.getElementById('family_name') != null)
									parent.f_query_add_mod.document.frames[0].document.getElementById('family_name').value = "<%=rs.getString("family_name")==null?"":rs.getString("family_name")%>"

						if(parent.f_query_add_mod.document.frames[0].document.getElementById('name_suffix') != null)
						{
							var obj = parent.f_query_add_mod.document.frames[0].document.getElementById('name_suffix').options;
							for(var k=0;k<obj.options.length;k++)
							{
								if(obj.options[k].value == '<%=rs.getString("name_suffix")%>')
										obj.options[k].selected = true;
							}
						}

						var obj = parent.f_query_add_mod.document.frames[0].document.getElementById('sex').options;
						for(var k=0;k<obj.options.length;k++)
						{
							if(obj.options[k].value == '<%=rs.getString("sex")%>')
									obj.options[k].selected = true;
						}

						parent.f_query_add_mod.document.frames[0].document.getElementById('date_of_birth').value = '<%=rs.getString("date_of_birth")%>'
						parent.f_query_add_mod.document.frames[0].document.getElementById('b_age').value = '<%=AGEq%>';
						parent.f_query_add_mod.document.frames[0].document.getElementById('b_months').value = '<%=MONTHSq%>';
						parent.f_query_add_mod.document.frames[0].document.getElementById('b_days').value ='<%=DAYSq%>';

						var obj = parent.f_query_add_mod.document.frames[0].document.getElementById('nationality_code').options;
						for(var k=0;k<obj.options.length;k++)
						{
							if(obj.options[k].value == '<%=rs.getString("nationality_code")%>')
									obj.options[k].selected = true;
						}
						if(parent.f_query_add_mod.document.frames[0].document.getElementById('primary_resi_no'))
							parent.f_query_add_mod.document.frames[0].document.getElementById('primary_resi_no').value = "<%=rs.getString("primary_resi_no")==null?"":rs.getString("primary_resi_no")%>"
						if(parent.f_query_add_mod.document.frames[0].document.getElementById('other_resi_no'))
							parent.f_query_add_mod.document.frames[0].document.getElementById('other_resi_no').value = "<%=rs.getString("Other_Resi_No")==null?"":rs.getString("Other_Resi_No")%>"
								
						if(parent.f_query_add_mod.document.frames[0].document.getElementById('addr1_line1'))
							parent.f_query_add_mod.document.frames[0].document.getElementById('addr1_line1').value = "<%=rs.getString("addr1_line1")==null?"":rs.getString("addr1_line1")%>"
						if(parent.f_query_add_mod.document.frames[0].document.getElementById('addr1_line2'))	
							parent.f_query_add_mod.document.frames[0].document.getElementById('addr1_line2').value = "<%=rs.getString("addr1_line2")==null?"":rs.getString("addr1_line2")%>"
						if(parent.f_query_add_mod.document.frames[0].document.getElementById('addr1_line3'))	
							parent.f_query_add_mod.document.frames[0].document.getElementById('addr1_line3').value = "<%=rs.getString("addr1_line3")==null?"":rs.getString("addr1_line3")%>"
						if(parent.f_query_add_mod.document.frames[0].document.getElementById('addr1_line4'))
							parent.f_query_add_mod.document.frames[0].document.getElementById('addr1_line4').value = "<%=rs.getString("addr1_line4")==null?"":rs.getString("addr1_line4")%>"

						putPatientName();	
						disableItems();
							
					</script>
				<%

				String alt_status1 = patdata.CheckAlternateId(con,pat_id,localeName);
				char alt_stat1 = 'Y';
				if (alt_status1.equals("alt_id1_expired") && alt_stat1 != 'N')
				{
					alt_stat1 = 'N';
					pstmt1=con.prepareStatement("select alt_id1_type from mp_param_lang_vw where language_id='"+locale+"'");
					rs1 = pstmt1.executeQuery();
					rs1.next();
					String alt_id1_type=rs1.getString("alt_id1_type");
					%>
						<script>
						var err_age3 = getMessage( "ALT_ID_EXPIRED","MP");
						err_age3 = err_age3.replace('$',"<%=alt_id1_type%>");
						alert(err_age3);	
						</script> 						
					 <%
					if(rs1 != null) rs1.close();
					if(pstmt1 != null) pstmt1.close();
				}
				else if (alt_status1.equals("alt_id2_expired") && alt_stat1 != 'N')
				{
					pstmt1=con.prepareStatement("select alt_id2_type from mp_param_lang_vw where language_id='"+locale+"'");
					rs1 = pstmt1.executeQuery();
					rs1.next();
					String alt_id2_type=rs1.getString("alt_id2_type");
					out.println("<script>var msg = getMessage('ALT_ID_EXPIRED','MP')");
					out.println("msg = msg.replace('$','"+alt_id2_type+"');alert(msg);</script>");       

					if(rs1 != null) rs1.close();
					if(pstmt1 != null) pstmt1.close();

					alt_stat1 = 'N';
				}
				else if (alt_status1.equals("alt_id3_expired") && alt_stat1 != 'N')
				{
					pstmt1=con.prepareStatement("select alt_id3_type from mp_param_lang_vw where language_id='"+locale+"'");
					rs1 = pstmt1.executeQuery();
					rs1.next();
					String alt_id3_type=rs1.getString("alt_id3_type");
					out.println("<script>var msg = getMessage('ALT_ID_EXPIRED','MP')");
					out.println("msg = msg.replace('$','"+alt_id3_type+"');alert(msg);</script>");        
					if(rs1 != null) rs1.close();
					if(pstmt1 != null) pstmt1.close();
					alt_stat1 = 'N';
				}
				else if (alt_status1.equals("alt_id4_expired") && alt_stat1 != 'N')
				{
					pstmt1=con.prepareStatement("select alt_id4_type from mp_param_lang_vw where language_id='"+locale+"'");
					rs1 = pstmt1.executeQuery();
					rs1.next();
					String alt_id4_type=rs1.getString("alt_id4_type");
					out.println("<script>var msg = getMessage('ALT_ID_EXPIRED','MP')");
					out.println("msg = msg.replace('$','"+alt_id4_type+"');alert(msg);</script>");        
					if(rs1 != null) rs1.close();
					if(pstmt1 != null) pstmt1.close();
					alt_stat1 = 'N';
				}	
				if (alt_stat1!='N'&& alt_status1!="")
				{
					if (alt_status1.indexOf("ALT_ID1_IN_GRACE")>=0)
					{
						alt_stat1 = 'N';
						pstmt1=con.prepareStatement("select alt_id1_type from mp_param_lang_vw where language_id='"+locale+"'");
						rs1 = pstmt1.executeQuery();
						rs1.next();

						String alt_id1_type=rs1.getString("alt_id1_type");
						
						%>
							<script>
							var err_age3 = getMessage( "ALT_ID_EXP_WITH_GRACE","MP");
							err_age3 = err_age3.replace('$',"<%=alt_id1_type%>");
							alert(err_age3);	
							</script>
						<%	
						if(rs1 != null) rs1.close();
						if(pstmt1 != null) pstmt1.close();
					}
					else if (alt_status1.indexOf("ALT_ID2_IN_GRACE")>=0 && alt_stat1 != 'N')
					{
						pstmt1 = con.prepareStatement("select alt_id2_type from mp_param_lang_vw where language_id='"+locale+"'");
						rs1 = pstmt1.executeQuery();
						rs1.next();

						String alt_id2_type=rs1.getString("alt_id2_type");
						%>
							<script>
							var msg = getMessage('ALT_ID_EXPIRED','MP')"
							msg = msg.replace('$',"<%=alt_id2_type%>");
							alert(msg);
							</script>
						<%
						if(rs1 != null) rs1.close();
						if(pstmt1 != null) pstmt1.close();
						alt_stat1 = 'N';
					}		
					else if (alt_status1.indexOf("ALT_ID3_IN_GRACE")>=0 && alt_stat1 != 'N')
					{
						pstmt1=con.prepareStatement("select alt_id3_type from mp_param_lang_vw where language_id='"+locale+"'");
						rs1 = pstmt1.executeQuery();
						rs1.next();

						String alt_id3_type=rs1.getString("alt_id3_type");
						%>
						<script>
						var msg = getMessage('ALT_ID_EXPIRED','MP')"
						msg = msg.replace('$',"<%=alt_id3_type%>");
						alert(msg);
						</script>
						<%
						if(rs1 != null) rs1.close();
						if(pstmt1 != null) pstmt1.close();
						alt_stat1 = 'N';
					}		
					else if (alt_status1.indexOf("ALT_ID4_IN_GRACE")>=0 && alt_stat1 != 'N')
					{
						pstmt=con.prepareStatement("select alt_id4_type from mp_param_lang_vw where language_id='"+locale+"'");
						rs1 = pstmt1.executeQuery();
						rs1.next();

						String alt_id4_type=rs1.getString("alt_id4_type");
						%>
						<script>
						var msg = getMessage('ALT_ID_EXPIRED','MP')"
						msg = msg.replace('$',"<%=alt_id4_type%>");
						alert(msg);
						</script>
						<%
						if(rs1 != null) rs1.close();
						if(pstmt1 != null) pstmt1.close();
						alt_stat1 = 'N';
					}
				}
				if (alt_stat1!='N'&& alt_status1!="")
				{
					if (alt_status1.indexOf("ALT_ID1_EXP_WITHIN")>=0 && alt_stat1 != 'N')
					{
						pstmt1 = con.prepareStatement("select alt_id1_type from mp_param_lang_vw where language_id='"+locale+"'") ;
						rs1 = pstmt1.executeQuery();
						rs1.next();
						alt_stat1 = 'N';
						StringTokenizer token=new StringTokenizer(alt_status1,"$");
						String days1 = token.nextToken();
						days1 = token.nextToken();
						alt_stat1='N';

						String alt_id1_type=rs1.getString("alt_id1_type");
						%>
						<script>
							var err_age3 = getMessage( "ALT_ID_EXP_WITHIN","MP");
							err_age3 = err_age3.replace('$',"<%=alt_id1_type%>");

							/*added by Raj on 10/3/2003 to display 0 days as Today */
							var diffdays = <%= days1%>;
							if(diffdays=='0')
							{
								err_age3 = err_age3.replace('within','');
								alert(err_age3+"Today");
							}
							else 		/*end of addition by Raj**/	
								alert(err_age3+" "+"<%=days1%> Days");	
						</script>
						<%	
						if(rs1 != null) rs1.close();
						if(pstmt1 != null) pstmt1.close();
					}
					else if (alt_status1.indexOf("ALT_ID2_EXP_WITHIN")>=0 && alt_stat1 != 'N')
					{
						StringTokenizer token=new StringTokenizer(alt_status1,"$");
						String days1 = token.nextToken();
						days1 = token.nextToken();
						pstmt1=con.prepareStatement("select alt_id2_type from mp_param_lang_vw where language_id='"+locale+"'");
						rs1 = pstmt1.executeQuery();
						rs1.next();

						String alt_id2_type=rs1.getString("alt_id2_type");
						%>
						<script>
							var msg = getMessage('ALT_ID_EXP_WITHIN','MP')"
							msg = msg.replace('$',"<%=alt_id2_type%>");

							/*added by Raj on 10/3/2003 to display 0 days as Today */
							var diffdays = <%= days1%>;
							if(diffdays=='0')
							{
								
								msg = msg.replace("'"+getLabel('Common.within.label','Common')+"'",'');
								alert(msg+" '"+getLabel('Common.within.label','Common')+"'");
							}
							else 	
								alert(msg+" "+"<%=days1%>"+"'"+getLabel('Common.days.label','Common')+"'");	
						</script>
						<%
						if(rs1 != null) rs1.close();
						if(pstmt1 != null) pstmt1.close();
						alt_stat1 = 'N';
					}		
					else if (alt_status1.indexOf("ALT_ID3_EXP_WITHIN")>=0 && alt_stat1 != 'N')
					{
						StringTokenizer token=new StringTokenizer(alt_status1,"$");
						String days1 = token.nextToken();
						days1 = token.nextToken();
						pstmt1=con.prepareStatement("select alt_id3_type from mp_param_lang_vw where language_id='"+locale+"'");
						rs1 = pstmt1.executeQuery();
						rs1.next();
						String alt_id3_type=rs1.getString("alt_id3_type");
						%>
						<script>
							var msg = getMessage('ALT_ID_EXP_WITHIN','MP')"
							msg = msg.replace('$',"<%=alt_id3_type%>");
		
							/*added by Raj on 10/3/2003 to display 0 days as Today */
							var diffdays = <%= days1%>;
							if(diffdays=='0')
							{
										msg = msg.replace("'"+getLabel('Common.within.label','Common')+"'",'');
								alert(msg+" '"+getLabel('Common.within.label','Common')+"'");
							}
							else 	
								alert(msg+" "+"<%=days1%>"+"'"+getLabel('Common.days.label','Common')+"'");	
						</script>
						<%
						if(rs1 != null) rs1.close();
						if(pstmt1 != null) pstmt1.close();
						alt_stat1 = 'N';
					}		
					else if (alt_status1.indexOf("ALT_ID4_EXP_WITHIN")>=0 && alt_stat1 != 'N')
					{
						StringTokenizer token=new StringTokenizer(alt_status1,"$");
						String days1 = token.nextToken();
						days1 = token.nextToken();
						pstmt1 = con.prepareStatement("select alt_id4_type from mp_param_lang_vw where language_id='"+locale+"'") ;
						rs1 = pstmt1.executeQuery();
						rs1.next();

						String alt_id4_type=rs1.getString("alt_id4_type");
						%>
						<script>
							var msg = getMessage('ALT_ID_EXP_WITHIN','MP')"
							msg = msg.replace('$',"<%=alt_id4_type%>");

								/*added by Raj on 10/3/2003 to display 0 days as Today */
							var diffdays = <%= days1%>;
							if(diffdays=='0')
							{
										msg = msg.replace("'"+getLabel('Common.within.label','Common')+"'",'');
								alert(msg+" '"+getLabel('Common.within.label','Common')+"'");
							}
							else 	
								alert(msg+" "+"<%=days1%>"+"'"+getLabel('Common.days.label','Common')+"'");		
						</script>
						<%
						if(rs1 != null) rs1.close();
						if(pstmt1 != null) pstmt1.close();
						alt_stat1 = 'N';
					}
				}					
				}
			}
			else
			{
				String chkst=patdata.CheckStatus(con,pat_id);
				if (chkst.indexOf("PATIENT_MERGED_VALID")>=0 )
				{
					StringTokenizer token=new StringTokenizer(chkst,"$");
					String valid_patient_id = token.nextToken();
					valid_patient_id = token.nextToken();
				%> 
					<script>
						var error= getMessage( "PATIENT_MERGED_VALID","MP");
						error = error.replace('#',"<%=valid_patient_id%>");
						alert(error);	
						parent.f_query_add_mod.document.getElementById('patient_id').value="<%=valid_patient_id%>";
						parent.f_query_add_mod.document.frames[0].document.getElementById('patient_id').focus();
						parent.f_query_add_mod.document.frames[0].document.getElementById('patient_id').select();
					</script> 
					<%		
				}	
				else{	out.println("<script>alert(getMessage('INVALID_PATIENT','MP'));parent.f_query_add_mod.document.frames[0].document.getElementById('patient_id').focus();</script>");
				}
			}

			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			sql1.setLength(0);
		}

		if(process == 5)
		{		
			String objval = request.getParameter("objval");		
		
			String objarray="";
			if(objval.equals("to_speciality_code"))
			{

				objval="locationT0";
				objarray="locationT0_array";
			}
			else
			{
				objval = "location0";
				objarray="location0_array";
			}
			%>
			<script>
				var objval="<%=objval%>";
			
				var objarray="<%=objarray%>";
				var len=0;
			</script>

			<%
		sql1.append("select locn_type,short_desc from AM_CARE_LOCN_TYPE_LANG_VW  where");
		if( p_call_func.equals("AE_REGISTER_ATTN") || p_call_func.equals("CHG_REG_DTLS") || p_call_func.equalsIgnoreCase("REV_VISIT_DTLS"))
		{
			sql1.append(" care_locn_type_ind in ('C') and locn_type in('C') and ");
		}
		else if(p_call_func.equals("IP_BOOKING") || p_call_func.equals("IP_ADMIT"))
		{
			sql1.append(" care_locn_type_ind in ('N') and locn_type in('N') and ");
		}
		else if(p_call_func.equals("OP_REG_VISIT") && funid.equals("VISIT_REGISTRATION"))
		{
			sql1.append(" care_locn_type_ind in ('E','C') and locn_type in('E','C') and ");
		}
		else if(p_call_func.equals("OA_BOOK_APPT") || p_call_func.equals("OA_MODIFY_APPT"))
		{
			sql1.append(" care_locn_type_ind in ('C','D','E') and locn_type in('C','Y','E') and ");
		}
		else
		{
			if(rd_operational_yn.equals("Y"))
			{
			sql1.append(" care_locn_type_ind in ('C','D','E','N','W') and locn_type in('C','Y','E','N','W') and  ");
			}else
			{
			sql1.append(" care_locn_type_ind in ('C','D','E','N') and locn_type in('C','Y','E','N') and ");
			}

		}
		sql1.append(" sys_user_def_ind='S' and language_id='"+locale+"' order by 2");			 
		pstmt=con.prepareStatement(sql1.toString());
		rs=pstmt.executeQuery();
		if(rs != null)
		{
			while(rs.next())
			{	
				 locntypecode=rs.getString("locn_type");
				 locntypedesc=rs.getString("short_desc");
				%>
				<script>
				
					opt=parent.document.f_query_add_mod.document.tab_comp.document.createElement("OPTION");   
					eval("parent.document.f_query_add_mod.document.tab_comp.document.forms[0]."+objval).add(opt);
					opt.text="<%=locntypedesc%>";
					opt.value="<%=locntypecode%>";			                   
					len=eval("parent.document.f_query_add_mod.document.tab_comp."+objarray).length;
					eval("parent.document.f_query_add_mod.document.tab_comp."+objarray)[len] = opt
				</script>
							
				<%			 
			}
		}
		if(rs != null) rs.close();
		if(pstmt !=null) pstmt.close();
		sql1.setLength(0);	
	}

	if(process == 6)
	{
		String locntype = request.getParameter("locn_type");
		String locncode = request.getParameter("locn_code");
		String opentoallyn = request.getParameter("open_to_all_yn")==null?"":request.getParameter("open_to_all_yn");
		
		if(locntype.equals("C"))
		{
			if(opentoallyn.equals("Y"))
			{
				sql1.append("Select AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"','2') short_name,a.practitioner_id From am_pract_for_facility a, am_practitioner b     Where a.facility_id = '"+loginfacility+"'  And a.practitioner_id =b.practitioner_id   And a.eff_status = 'E' order by 1 ");
			}
			else
			{
				sql1.append(" Select AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"','2') short_name,a.practitioner_id From op_pract_for_clinic a,am_practitioner b Where a.facility_id = '"+loginfacility+"' ");
				sql1.append(" And a.clinic_code = '"+locncode+"'  And a.practitioner_id =b.practitioner_id And a.eff_status = 'E' order by 1 ");
			}
		}
		else if(locntype.equals("N"))
		{
			sql1.append(" Select AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"','1') short_name,a.practitioner_id From ip_nursing_unit_for_pract a,am_practitioner b Where a.facility_id = '"+loginfacility+"' ");                 
			sql1.append(" And a.nursing_unit_code = '"+locncode+"'  And a.practitioner_id = b.practitioner_id order by 1 ");
		}
		pstmt=con.prepareStatement(sql1.toString());
		rs = pstmt.executeQuery();
		while ( rs.next() )
		{
			%>
				<script>
					var oOption = parent.f_query_add_mod.document.tab_comp.document.createElement("OPTION");
					oOption.text='<%=rs.getString("short_name")%>';
					oOption.value='<%=rs.getString("practitioner_id")%>';
					parent.f_query_add_mod.document.tab_comp.document.getElementById("to_practitioner").add(oOption);
				</script>
			<%
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		sql1.setLength(0);
	}

	if(process == 8)
	{
		String speciality_code = request.getParameter("speciality");	
		String locncode=request.getParameter("loc_code");	
		String loc_type=request.getParameter("loc_type");
		
		if(locncode == null) locncode ="";
		

		if(loc_type.equals("C"))
		{
			sql="select service_code,short_desc from am_service_lang_vw where service_code in(select a.service_code from op_clinic a where a.speciality_code = '"+speciality_code+"' and a.clinic_code ='"+locncode+"' and a.facility_id='"+loginfacility+"' and a.care_locn_type_ind = 'C' and a.clinic_type='C' union select a.service_code from op_clinic_for_service a,op_clinic b where a.clinic_code = b.clinic_code and a.facility_id=b.facility_id and a.facility_id='"+loginfacility+"' and b.speciality_code ='"+speciality_code+"' and a.clinic_code = '"+locncode+"' ) and language_id='"+locale+"' order by short_desc";
		}
		else if(loc_type.equals("E"))
		{
			sql="select service_code,short_desc from am_service_lang_vw where service_code in(select a.service_code from op_clinic a where a.speciality_code = '"+speciality_code+"' and a.clinic_code ='"+locncode+"' and a.facility_id='"+loginfacility+"' and a.care_locn_type_ind = 'E' union select a.service_code from op_clinic_for_service a,op_clinic b where a.clinic_code = b.clinic_code and a.facility_id=b.facility_id and a.facility_id='"+loginfacility+"' and b.speciality_code ='"+speciality_code+"' and a.clinic_code = '"+locncode+"' ) and language_id='"+locale+"' order by short_desc";
		}
		else if(loc_type.equals("N"))
		{
			sql="select service_code,short_desc from AM_SERVICE_LANG_VW   where service_code in(select a.service_code from ip_nursing_unit a where a.nursing_unit_code ='"+locncode+"' and a.facility_id='"+loginfacility+"' and a.appl_patient_class = 'IP' union select a.service_code from ip_nurs_unit_for_service a,ip_nursing_unit b where a.nursing_unit_code = b.nursing_unit_code and a.facility_id=b.facility_id and a.facility_id='"+loginfacility+"'and b.appl_patient_class = 'IP' and a.nursing_unit_code = '"+locncode+"') and language_id='"+locale+"' order by short_desc";

		}
		else if (loc_type.equals("W"))
		{
			sql="SELECT distinct C.SERVICE_CODE service_code,D.SHORT_DESC short_desc FROM RD_SECTION_CTL A,RD_WINGS B,RD_SECTION C,AM_SERVICE D WHERE   A.OPERATING_FACILITY_ID='"+loginfacility+"' AND A.WING_CODE = NVL('"+locncode+"',A.WING_CODE) AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND A.WING_CODE = B.WING_CODE AND A.SECTION_CODE = C.SECTION_CODE AND C.SERVICE_CODE = D.SERVICE_CODE AND B.INT_OR_EXT = 'I'";
		}
		else
		{
	
			sql="select service_code,short_desc from am_service_lang_vw where service_code in(select a.service_code from op_clinic a where a.speciality_code = '"+speciality_code+"' and a.clinic_code ='"+locncode+"' and a.facility_id='"+loginfacility+"' and a.care_locn_type_ind = 'D' and a.clinic_type='Y' union select a.service_code from op_clinic_for_service a,op_clinic b where a.clinic_code = b.clinic_code and a.facility_id=b.facility_id and a.facility_id='"+loginfacility+"' and b.speciality_code ='"+speciality_code+"' and a.clinic_code = '"+locncode+"' )and language_id='"+locale+"' order by short_desc";
		}
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while ( rs.next() )
		{
			%>
				<script>
					/*var oOption = parent.f_query_add_mod.document.frames[1].document.createElement("OPTION");
					oOption.text='<%=rs.getString("short_desc")%>';
					oOption.value='<%=rs.getString("Service_code")%>';
					parent.f_query_add_mod.document.frames[1].document.getElementById('to_service_code').add(oOption);*/
				</script>
			<%
		}
		
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	}

	if(process == 9)
	{
		 String ref_type = request.getParameter("ref_type");
		 if(ref_type==null) ref_type="";
		 String hcare_type_code = request.getParameter("hcare_type");
		 if(hcare_type_code==null) ref_type="";

		 String referredtoid="";
		 String referredtodesc="";
		 String hcare_setting_type_desc="";
		 String hcare_setting_type="";
		 
		if(ref_type.equals("X"))
		{
			//sql="Select a.LONG_DESC referred_to_id_desc, a.REFERRAL_CODE referred_to_id, a.healthcare_setting_type hcare_setting_type, b.short_desc hcare_setting_type_desc from am_referral_lang_vw  a, am_hcare_setting_type_lang_vw   b where a.healthcare_setting_type = b.hcare_setting_type_code and nvl(a.dest_use_at_concl_yn,'N') = 'Y' and a.eff_status = 'E' and  a.healthcare_setting_type='"+hcare_type_code+"'   and a.language_id='"+locale+"' and b.language_id='"+locale+"' order by a.short_desc ";

			//pstmt=con.prepareStatement(sql);
			//rs=pstmt.executeQuery();

			//if(rs!=null)
			//{
				//while(rs.next())
				//{
					//referredtoid			=rs.getString("referred_to_id");
					//referredtodesc			=rs.getString("referred_to_id_desc");
					//hcare_setting_type_desc	=rs.getString("hcare_setting_type_desc");
					//hcare_setting_type		=rs.getString("hcare_setting_type");
					%>
					<script>
						//var temp  = "<%=referredtoid%>";
						//var temp1 = "<%=referredtodesc%>";
						//var hcare_setting_type_desc ="<%=hcare_setting_type_desc%>";
						//var hcare_setting_type		="<%=hcare_setting_type%>";
						//var opt=parent.document.frames[1].document.frames[1].document.createElement("OPTION");
						//opt.text=temp1;
						//opt.value=hcare_setting_type+"~"+temp;
						//parent.document.frames[1].document.frames[1].document.forms[0].referral_source.add(opt);		
					</script>
					<%
				//}
			//}
			//if(rs != null)  rs.close();
			//if(pstmt != null) pstmt.close();
		}
		else if(ref_type.equals("E") || ref_type.equals("L"))
		{
		
			if(ref_type.equals("E"))
			{%>
			
			<%
				//sql="select a.FACILITY_ID referred_to_id,a.FACILITY_NAME referred_to_id_desc ,a.hcare_setting_type_code hcare_setting_type_code, b.short_desc  hcare_setting_type_desc from SM_FACILITY_PARAM_LANG_VW   a, AM_HCARE_SETTING_TYPE_LANG_VW b where a.facility_id != '"+loginfacility+"' and  a.hcare_setting_type_code='"+hcare_type_code+"' and a.hcare_setting_type_code=b.hcare_setting_type_code and a.hcare_setting_type_code in ( select to_hcare_setting_type_code from am_hcare_setting_type_rstrn where from_hcare_setting_type_code = (select hcare_setting_type_code from SM_FACILITY_PARAM where facility_id = '"+loginfacility+"' ) and (ip_referral_yn = 'Y'  or op_referral_yn = 'Y') ) and a.language_id='"+locale+"' and b.language_id='"+locale+"' order by a.facility_name ";
				sql="SELECT a.FACILITY_ID referred_to_id ,a.FACILITY_NAME referred_to_id_desc   ,a.hcare_setting_type_code hcare_setting_type_code, b.short_desc hcare_setting_type_desc FROM SM_FACILITY_PARAM_LANG_VW a  , AM_HCARE_SETTING_TYPE_LANG_VW b WHERE a.facility_id != '"+loginfacility+"'  AND a.hcare_setting_type_code='"+hcare_type_code+"'   AND a.hcare_setting_type_code=b.hcare_setting_type_code   AND a.hcare_setting_type_code IN (SELECT to_hcare_setting_type_code FROM    am_hcare_setting_type_rstrn   WHERE from_hcare_setting_type_code = a.HCARE_SETTING_TYPE_CODE AND (ip_referral_yn = 'Y' OR op_referral_yn = 'Y'    )   )   AND a.language_id='"+locale+"'   AND b.language_id='"+locale+"' ORDER BY  a.facility_name";
				
			}
			else
			{
		

				sql="select a.FACILITY_ID referred_to_id,a.FACILITY_NAME referred_to_id_desc ,a.hcare_setting_type_code hcare_setting_type_code, b.short_desc hcare_setting_type_desc from SM_FACILITY_PARAM_LANG_VW a, AM_HCARE_SETTING_TYPE_LANG_VW b where a.hcare_setting_type_code=b.hcare_setting_type_code and a.hcare_setting_type_code in ( select to_hcare_setting_type_code from am_hcare_setting_type_rstrn where from_hcare_setting_type_code = (select hcare_setting_type_code from SM_FACILITY_PARAM where facility_id = '"+loginfacility+"' ) and (ip_referral_yn = 'Y'  or op_referral_yn = 'Y') ) and a.language_id='"+locale+"' and b.language_id='"+locale+"' and a.facility_id='"+loginfacility+"' order by a.facility_name";
			}
			
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs!=null)
			{
				while(rs.next())
				{
					referredtoid=rs.getString("referred_to_id");
					referredtodesc=rs.getString("referred_to_id_desc");
					hcare_setting_type_desc=rs.getString("hcare_setting_type_desc");
					hcare_setting_type=rs.getString("hcare_setting_type_code");
					%>
					<script>
						var temp = "<%=referredtoid%>";
						var temp1="<%=referredtodesc%>";
						var hcare_setting_type_desc="<%=hcare_setting_type_desc%>";
						var hcare_setting_type="<%=hcare_setting_type%>";
						
						//alert("785 in RegPatReferralValidation.jsp");
						// var opt3=parent.document.frames[1].document.frames[1].document.createElement("OPTION");
						var opt3=parent.document.f_query_add_mod.document.tab_comp.document.createElement("OPTION");
						
						
						opt3.text=temp1;
						opt3.value=hcare_setting_type+"~"+temp;          
						//parent.document.frames[1].document.frames[1].document.forms[0].referral_source.add(opt3);
						<%
						if(ref_type.equals("L"))
						{
						%>							//parent.document.frames[1].document.frames[1].document.forms[0].referral_source.options[1].selected=true;
						//parent.document.frames[1].document.frames[1].document.forms[0].referral_source.disabled=true;
						
						
						parent.document.f_query_add_mod.document.tab_comp.document.forms[0].referral_source.value=temp1;
						parent.document.f_query_add_mod.document.tab_comp.document.forms[0].referral_source.disabled=true;
						parent.document.f_query_add_mod.document.tab_comp.document.forms[0].referral_source_lkp_bkup_text.value=temp1;

						parent.document.f_query_add_mod.document.tab_comp.document.forms[0].referral_source_lkp_but.disabled=true;
						parent.document.f_query_add_mod.document.tab_comp.document.forms[0].referral_source_lkp_id.value=hcare_setting_type+"~"+temp;


						parent.document.f_query_add_mod.document.tab_comp.document.forms[0].referral_source1.value=temp;
						parent.document.f_query_add_mod.document.tab_comp.document.forms[0].hcare_type.disabled=false;
						parent.document.f_query_add_mod.document.tab_comp.document.forms[0].from_hcare_setting_type.value=hcare_setting_type;
						parent.document.f_query_add_mod.document.tab_comp.document.forms[0].hcare_type.value=hcare_setting_type;
						parent.document.f_query_add_mod.document.tab_comp.document.forms[0].hcare_type.disabled=true;
						<%
						}
						%>
					</script>
					<%
				}
			}	 
			if (rs!=null) rs.close();
			if(pstmt != null) pstmt.close();
			
			int ip=0;
			int op=0;

			sql1.append("select locn_type,short_desc from am_care_locn_type_lang_vw  where ");

			if(ref_type.equals("E"))
			{				
				sql="select count(distinct decode(ip_referral_yn,'N',null,ip_referral_yn) ) ip, count(distinct           decode(op_referral_yn,'N',null,op_referral_yn) ) op from am_hcare_setting_type_rstrn where from_hcare_setting_type_code= (select hcare_setting_type_code from SM_FACILITY_PARAM where facility_id = '"+loginfacility+"' ) and (ip_referral_yn='Y' or op_referral_yn = 'Y') ";
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				if(rs!=null)
				{
					if (rs.next())
					{
						ip=rs.getInt(1);
						op=rs.getInt(2);
					}
				}
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
		

				if (ip> 0 )
				{
				   if (op > 0)
					{
					   sql1.append(" care_locn_type_ind in ('C','E','D','N') and locn_type in('C','E','Y','N') and ");
				
					}
					else
					{
						sql1.append(" care_locn_type_ind in ('N') and locn_type in('N') and ");				
					}
				}
				else
				{       
					if(op>0)
					{
						sql1.append(" care_locn_type_ind in ('C') and locn_type in('C') and ");
					
					}
				
				}
			} //main if ends here
			else{
					sql1.append(" care_locn_type_ind in ('C','E','D','N') and locn_type in('C','E','Y','N') and ");				
				}
			sql1.append(" sys_user_def_ind='S' and  language_id='"+locale+"' order by 2");

			pstmt=con.prepareStatement(sql1.toString());
			rs=pstmt.executeQuery();
			if(rs !=null)
			{
				while(rs.next())
				{
					locntypecode=rs.getString("locn_type");
					locntypedesc=rs.getString("short_desc");
					%>
					<script>
						opt=parent.document.f_query_add_mod.document.tab_comp.document.createElement("OPTION");
						opt.text="<%=locntypedesc%>";
						opt.value="<%=locntypecode%>";
						parent.document.f_query_add_mod.document.tab_comp.document.forms[0].location0.add(opt);                          parent.document.f_query_add_mod.document.tab_comp.location0_array[parent.document.f_query_add_mod.document.tab_comp.location0_array.length] = opt
					</script>
					<%
				}
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			sql1.setLength(0);
		}
		process=11;
		fromProcess9=true;
	}

	if(process == 10)
	{
		String loc_type		= request.getParameter("loc_type");	
		String ref_type		= "";	
		String speciality	= request.getParameter("speciality");	
		String ref_to		= "";
		String objval		= request.getParameter("objval");

		if(objval.equals("locationT0"))
		{
			ref_type= "L";
			ref_to	= loginfacility;	
		}
		else
		{
			 ref_type	= request.getParameter("ref_type");	
			 ref_to		= request.getParameter("referral_source");
		}

		String clinicdesc			="";
		String clinicid				="";
		String open_to_all_pract_yn ="";
		
		String lcare="";

		String ssql="";

		if(p_call_func.equals("CHG_REG_DTLS")||p_call_func.equals("AE_REGISTER_ATTN"))
			lcare="and level_of_care_ind ='E' ";
		else 
			lcare="and level_of_care_ind in ('A','E') ";

	
		if(ref_type.equals("L") || ref_type.equals("E"))
		{
			if(loc_type.equals("C"))
			{
				sql="Select long_desc dat, clinic_code id, open_to_all_pract_yn from OP_CLINIC_LANG_VW where facility_id = '"+ref_to+"' and CARE_LOCN_TYPE_IND='C' "+lcare+" and allow_visit_regn_yn = 'Y' and ALLOW_REFERRAL_YN='Y' and eff_status = 'E'  and speciality_code = '"+speciality+"' and clinic_type='C'  and  language_id='"+locale+"' order by 1 ";

				

			}
			else if (loc_type.equals("N"))
			{
				sql="Select a.long_desc dat, a.nursing_unit_code id,'N' open_to_all_pract_yn from IP_NURSING_UNIT_LANG_VW  a, ip_nurs_unit_for_specialty b  where a.facility_id = '"+ref_to+"' and a.eff_status = 'E' and  a.nursing_unit_code = b.nursing_unit_code and a.locn_type='N' and a.Patient_Class = 'IP' and a.facility_id = b.facility_id and b.specialty_code = '"+speciality+"' and a.language_id='"+locale+"'  order by 1";
			}
			else if(loc_type.equals("Y"))
			{		

				sql="Select long_desc dat, clinic_code id, open_to_all_pract_yn from OP_CLINIC_LANG_VW where facility_id = '"+ref_to+"' and CARE_LOCN_TYPE_IND='D' and allow_visit_regn_yn = 'Y' and eff_status = 'E'  and speciality_code = '"+speciality+"' and clinic_type='Y' and language_id='"+locale+"'  order by 1 ";
			}
			else if(loc_type.equals("E"))
			{
				sql="Select long_desc dat, clinic_code id, open_to_all_pract_yn from OP_CLINIC_LANG_VW where facility_id = '"+ref_to+"' and CARE_LOCN_TYPE_IND='E' and allow_visit_regn_yn = 'Y' and eff_status = 'E'  and speciality_code = '"+speciality+"' and language_id='"+locale+"' order by 1 "; 
			}
			else if(loc_type.equals("W"))
			{
				sql="SELECT  SHORT_DESC dat,WING_CODE id, 'N' open_to_all_pract_yn FROM RD_WINGS WHERE  OPERATING_FACILITY_ID  ='"+loginfacility+"' AND INT_OR_EXT= 'I' AND STATUS IS NULL";
			}

			
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs!=null)
			{
				while(rs.next())
				{
					clinicdesc=rs.getString("dat");
					clinicid  =rs.getString("id");
					if(loc_type.equals("C"))
						open_to_all_pract_yn=rs.getString("open_to_all_pract_yn");
					else 
						open_to_all_pract_yn="N";

					
					%>
					<script>
						var objval="<%=objval%>";
						var temp = "<%=clinicid%>";
						var temp1="<%=clinicdesc%>";
						var temp3="<%=open_to_all_pract_yn%>";
						var opt=parent.document.f_query_add_mod.document.tab_comp.document.createElement("OPTION");
						opt.text=temp1;
						// code added for 20854
						opt.value=temp+"$"+temp3;					
						if(objval =="location0")
						{
						parent.document.f_query_add_mod.document.tab_comp.document.forms[0].from_locn.add(opt);
						}
						else
						{
							parent.document.f_query_add_mod.document.tab_comp.document.forms[0].to_locn.add(opt);
						}
					</script>
					<%
				}
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}
	
	

	if(!objval.equals("location0"))
	{
	if (loc_type.equals("W"))
	{
	ssql="SELECT  distinct C.SERVICE_CODE service_code,D.SHORT_DESC short_desc FROM RD_SECTION_CTL A,RD_WINGS B,RD_SECTION C,AM_SERVICE_LANG_VW   D WHERE   A.OPERATING_FACILITY_ID='"+loginfacility+"' AND A.WING_CODE = NVL('',A.WING_CODE) AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND A.WING_CODE = B.WING_CODE AND A.SECTION_CODE = C.SECTION_CODE AND C.SERVICE_CODE = D.SERVICE_CODE AND B.INT_OR_EXT = 'I' and D.language_id='"+locale+"'";
	}else
	{
	ssql="Select Distinct service_code, short_desc from AM_SERVICE_LANG_VW  where eff_status='E' and language_id='"+locale+"' order by short_desc";
	}
	
	
	String cdesc="";
	String ccode="";

	pstmt=con.prepareStatement(ssql);
	rs=pstmt.executeQuery();
	
	if(rs != null)
		{
	while ( rs.next() )
	{
		cdesc=rs.getString("short_desc");
		ccode=rs.getString("service_code");

	%>
		<script>
					
/*
			var oOption = parent.f_query_add_mod.document.frames[1].document.createElement("OPTION");
			oOption.text="<%=cdesc%>";
			oOption.value="<%=ccode%>";
			parent.f_query_add_mod.document.frames[1].document.getElementById('to_service_code').add(oOption);*/
		</script>
	<%
	}
	}
		
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

	}
	}

	if (process == 11)
	{	
		String hcare_code     = request.getParameter("hcare_code");
		if(hcare_code==null) hcare_code="";
		String ref_to_code        = request.getParameter("ref_to_code");
		if(ref_to_code ==null) ref_to_code  ="";
		String ref_type        = request.getParameter("ref_type");
		String specialty_short_desc="";
		String specialty_code="";
		

		if(ref_type ==null) ref_type  ="";            
		if(ref_type.equals("X"))
		{
			sql="Select specialty_code,am_get_desc.am_speciality(SPECIALTY_CODE,'"+locale+"','2') specialty_short_desc from am_referral_for_specialty_vw where referral_code='"+ref_to_code+"'  order by 2";
			
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs!=null)
			{
				while(rs.next())
				{
					specialty_code=rs.getString("specialty_code");
					specialty_short_desc=rs.getString("specialty_short_desc");
					%>
					<script>
						var temp = "<%=specialty_code%>";
						var temp1="<%=specialty_short_desc%>";
						var opt=parent.document.f_query_add_mod.document.tab_comp.document.createElement("OPTION");
						opt.text=temp1;
						opt.value=temp;
						parent.document.f_query_add_mod.document.tab_comp.document.forms[0].speciality.add(opt);
					</script>
					<%                        
				}
			}

			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

		}//if ref type='X'
		else
		{
			sql="Select Short_Desc specialty_short_desc,Speciality_Code specialty_code from AM_SPECIALITY_LANG_VW where Eff_Status = 'E' and language_id='"+locale+"' order by 1";

			
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs!=null)
			{
				while(rs.next())
				{
					specialty_code=rs.getString("specialty_code");
					specialty_short_desc=rs.getString("specialty_short_desc");
					%>
					<script>
						var temp = "<%=specialty_code%>";
						var temp1="<%=specialty_short_desc%>";
						var opt = parent.document.f_query_add_mod.document.tab_comp.document.createElement("OPTION");
						opt.text=temp1;
						opt.value=temp;
						parent.document.f_query_add_mod.document.tab_comp.document.forms[0].speciality.add(opt);
					</script>
					<%
				}
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}	
		%>
		<script>	
		if("<%=hcare_code%>"!="")
			parent.document.f_query_add_mod.document.tab_comp.document.forms[0].hcare_type.value="<%=hcare_code%>";
		</script>
		<%

		if(!fromProcess9)
		{	
		%>
		<script>		
		if("<%=hcare_code%>"!="")
			parent.document.f_query_add_mod.document.tab_comp.document.forms[0].hcare_type.value="<%=hcare_code%>";
		</script>
		<%	
		}//if fromProcess9
	}

	if (process == 12)
	{
		String from_pract_id     = request.getParameter("from_pract_id");
		if(from_pract_id==null) from_pract_id="";

		sql="SELECT RES_TEL_NUM,MOBILE_NUM,PAGER_NUM FROM am_practitioner where PRACTITIONER_ID='"+from_pract_id+"'";
		
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		if(rs!=null  && rs.next())
		{	
			
			String RES_TEL_NUM	=rs.getString("RES_TEL_NUM");
			if(RES_TEL_NUM==null) RES_TEL_NUM="";
			String MOBILE_NUM	=rs.getString("MOBILE_NUM");
			if(MOBILE_NUM==null) MOBILE_NUM="";
			String PAGER_NUM		=rs.getString("PAGER_NUM");
			if(PAGER_NUM==null) PAGER_NUM="";
			%>
			<script>
				parent.document.f_query_add_mod.document.frames[0].document.forms[0].tel_no.value="<%=RES_TEL_NUM%>";
				parent.document.f_query_add_mod.document.frames[0].document.forms[0].mobile_no.value="<%=MOBILE_NUM%>";
				parent.document.f_query_add_mod.document.frames[0].document.forms[0].pager_no.value="<%=PAGER_NUM%>";
			</script>
			<%	
			}

			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}	
		
	
		if(process==1024){

		//	pstmt = con.prepareStatement("select off_tel_num,mobile_num,pager_num,am_get_desc.AM_POSITION(POSITION_CODE, '"+locale+"','1') job_title,pract_type,am_get_desc.am_pract_type(pract_type,'"+locale+"',2) pract_type_desc from am_practitioner  where practitioner_id='"+practitioner+"'");
		
			if(referral_type.equals("X")){	 
				pstmt = con.prepareStatement("select off_tel_num,mobile_num,pager_num from am_ext_practitioner where practitioner_id='"+practitioner+"'");
			}else{
				pstmt = con.prepareStatement("select off_tel_num,mobile_num,pager_num from am_practitioner where practitioner_id='"+practitioner+"'");
			}

			rs = pstmt.executeQuery();

			if( rs !=null  && rs.next()){
				
				String off_tel_num	=rs.getString("off_tel_num");
				if(off_tel_num==null) off_tel_num="";
				String mobile_num	=rs.getString("mobile_num");
				if(mobile_num==null) mobile_num="";
				String pager_num		=rs.getString("pager_num");
				if(pager_num==null) pager_num="";
					%>
					<script>						 
						parent.document.f_query_add_mod.document.tab_comp.document.forms[0].tel_no.value="<%=off_tel_num%>";
						parent.document.f_query_add_mod.document.tab_comp.document.forms[0].mobile_no.value="<%=mobile_num%>";
						parent.document.f_query_add_mod.document.tab_comp.document.forms[0].pager_no.value="<%=pager_num%>";
					</script>
							
			   <%
			}

			if(pstmt != null)    pstmt.close();
			if(rs != null)    rs.close();

		}	
	}
}catch(Exception e){
	
	e.printStackTrace();
}
finally
{
	try{
			if(rs != null)		rs.close();
			if(rs1 != null) rs1.close();
			if(pstmt != null) pstmt.close();
			if(pstmt1 != null) pstmt1.close();
	}catch(Exception ee){
			
			ee.printStackTrace();

	}
	if(con != null) ConnectionManager.returnConnection(con,request);
}	
	%>
	</body>
</html>

