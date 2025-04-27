<!DOCTYPE html>
<!-- Latest Modified Date : 10/1/2005 4:36 PM -->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@page contentType="text/html;charset=UTF-8" import="java.sql.*,java.util.*,org.json.simple.*,java.io.*,webbeans.eCommon.ConnectionManager" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eMP/js/checkNationality.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script>
function chkForAltID1Length(obj)
{
	var ald_id_desc = document.forms[0].alt_id_no.name;
	alt_id1_length=document.forms[0].alt_id1_length.value;
	if((obj.value.length > 0) && (obj.value.length !=alt_id1_length))
	{
		 msg = getMessage("ALT_ID_CHARS","MP");
		 msg =msg.replace('$',ald_id_desc);
		 msg =msg.replace('@',alt_id1_length);
		 alert(msg);
		 obj.value = '';
	}
}


function CheckSplCharsNatID(Obj){
		var nat_id_accept_alphanumeric_yn = document.forms[0].nat_id_accept_alphanumeric_yn.value;
		
        var str = Obj.value;
        var specCharsExist = true;
		if(nat_id_accept_alphanumeric_yn=="Y")
			strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-';
		else
			strCheck = '0123456789X';
		//strCheck = '0123456789X';
        for (i=0;i<str.length;i++){
            if (strCheck.indexOf(str.charAt(i)) == -1) 
			{
				alert(getMessage("NAT_ID_SPL_NOT_ALLOWED",'MP'));
				Obj.value=''; //smarth card
				Obj.focus();
				return false;  
			}
        }
        return specCharsExist;
         }

function checkXInNatID(Nat_Id)
{
	var ind = -1;
	if (!CheckSplCharsNatID(Nat_Id))
	{
		return false;
	}
	if ( (document.forms[0].nat_id_check_digit_id.value=='M11') && ( (ind = Nat_Id.value.indexOf('X')) != -1) )
	{
		if (ind < 12)           // X can be entered only at 13th position
		{
			msg = getMessage('INVALID_NAT_ID','MP');
			msg = msg.replace("#",document.getElementById('nat_prompt_id').innerHTML);
			alert(msg);
			//Nat_Id.select();
			Nat_Id.value = '';
			Nat_Id.focus();
			return false;
		}
	}
}
</script>
<%@ include file="HealthCardInterface.jsp"%>

<%

	String alt_id1_type						= "";
	String nat_id_check_digit_id			= "";
	String KeyVal							= "";
	String nat_id_onKeyPress							= "";
	String alt_id1_accept_alphanumeric_yn	= "N";
	String nat_id_accept_alphanumeric_yn	= "N";
	/*Added by Thamizh selvi on 1st Aug 2018 for ML-MMOH-CRF-1177 Start*/
	JSONObject dobJSONObj = new JSONObject();
	String dateOfBirthNOK = "";
	String resDOB		  = "";
	String errMesg		  = "";
	/*End*/
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection conn			= null;
	java.sql.Statement stmt = null;
	ResultSet rs			= null;
	boolean flag = true ;
	int natIDCountInMPPatTable=1;
	String deceased_yn="N";
	try
	{
		conn	= ConnectionManager.getConnection(request);
		stmt	= conn.createStatement();
		
		String sql ;
		String function = checkForNull(request.getParameter("step"));
		String calledFunction = checkForNull(request.getParameter("calledFunction"));
		String from_newBorn = checkForNull(request.getParameter("from_newBorn"),"N");
		String isNatIdAltIdMandVisaType = request.getParameter("isNatIdAltIdMandVisaType");
		if(isNatIdAltIdMandVisaType==null)
			isNatIdAltIdMandVisaType="false";
		String dftNationalId = checkForNull(request.getParameter("dftNationalId"),"");
	
		//out.println("function :'"+function+"'");
		if(function.equals("first"))
		{
			sql = "SELECT dflt_pat_ser_grp_type, nat_id_length, NVL (nat_id_chk_len, 'N') nat_id_chk_len, NVL (nat_id_prompt, 'National ID No') nat_id_prompt, b.long_desc alt_id1_type, alt_id1_length, alt_id1_len_validation_yn, alt_id1_routine_yn,     alt_id1_data_source_id alt_id1_routine, alt_id1_chk_digit_scheme, alt_id1_unique_yn, alt_id1_accept_alphanumeric_yn, nat_id_accept_alphanumeric_yn, nat_id_check_digit_id FROM mp_param_lang_vw a, mp_alternate_id_type b WHERE a.alt_id1_type = b.alt_id_type and language_id='"+localeName+"' and module_id='MP'";

			rs = stmt.executeQuery(sql);

			if(!rs.next())
				response.sendRedirect("../../eCommon/jsp/error.jsp?err_num=No Record found in MP Parameter table");
			else
			{
				alt_id1_accept_alphanumeric_yn = rs.getString("alt_id1_accept_alphanumeric_yn");
				nat_id_accept_alphanumeric_yn = rs.getString("nat_id_accept_alphanumeric_yn");
				if(alt_id1_accept_alphanumeric_yn == null) alt_id1_accept_alphanumeric_yn = "N";
				if(nat_id_accept_alphanumeric_yn == null) nat_id_accept_alphanumeric_yn = "N";

					KeyVal = rs.getString("dflt_pat_ser_grp_type");
					nat_id_check_digit_id = checkForNull(rs.getString("nat_id_check_digit_id"));
				if(KeyVal.equals("N"))
				{
					%>
					<html>
					<head>
						<title><fmt:message key="Common.Check.label" bundle="${common_labels}"/> <%=rs.getString("nat_id_prompt")%></title>
						<script language='javascript'>
							top.document.title ='Check <%=rs.getString("nat_id_prompt")%>'
						</script>




					</head>
					<%
				   String nat_id_val = checkForNull(request.getParameter("National_Id_No")) ;
				   if(nat_id_val == null)   nat_id_val = "";
				   if(nat_id_val.equals("null") )nat_id_val  = "";  
				   

			
					out.println("<body onKeyDown='lockKey()'><br><form name='nat_form' id='nat_form' method='post' action='../../eMP/jsp/checkNationality.jsp?step=second' target='errMsg'><table width='100%' cellspacing='0' cellpadding='0'><tr><td colspan='2'>&nbsp;</td></tr><tr><td align='right' width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NationalIDHolder.label","mp_labels")+"</td><td width='60%' align='left'>&nbsp;&nbsp;<input type='checkbox' name='nat_holder_yn' id='nat_holder_yn' onclick='checkBoxClicked()' value='' checked><input type='hidden' name='nat_id_accept_alphanumeric_yn' id='nat_id_accept_alphanumeric_yn' value='"+nat_id_accept_alphanumeric_yn+"'></td></tr>");

					/*
					if ( nat_id_check_digit_id.equals("M11") )
							nat_id_onKeyPress = "CheckForCharsNatID(event);";
					else
							nat_id_onKeyPress = "allowValidNumber(this,event,2, 0);";
					*/

					if(nat_id_accept_alphanumeric_yn.equals("Y"))
					{
						nat_id_onKeyPress = "CheckForAlphaCharsNatID(event);";
					}
					else
					{
						if(nat_id_check_digit_id.equals("M11"))
							nat_id_onKeyPress = "CheckForCharsNatID(event);";
						else
							nat_id_onKeyPress = "allowValidNumber(this,event,2, 0);";
					}

					out.println("<tr><td align='right' width='40%' class='label' id='nat_prompt_id'>"+rs.getString("nat_id_prompt")+"</td><td width='60%' align='left'>&nbsp;&nbsp;&nbsp;<input type='text' name='nat_id_no' id='nat_id_no' onBlur='checkXInNatID(this);'  value=\""+nat_id_val +"\"  onKeyPress='return "+nat_id_onKeyPress+"'  size='20' maxlength='"+rs.getInt("nat_id_length")+"'  ><input type='hidden' name='group' id='group' value='N'></input><input type='hidden' name='nat_id_prompt' id='nat_id_prompt' value=\""+rs.getString("nat_id_prompt")+"\"></input><input type='hidden' name='output' id='output' value='W'></input></td></tr>");

					out.println("<tr><td colspan='2'>&nbsp;</td></tr><tr><td colspan='2' align='center'><input type='Button' name='ok' id='ok' value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")+"' class='Button' onclick=\"submitAll('"+rs.getString("nat_id_chk_len")+"')\">&nbsp;&nbsp;<input type='Button' name='cancel' id='cancel' value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")+"' class='Button' onclick='CancelModal()'></td></tr><tr><td colspan='2'>&nbsp;</td></tr></table>");
					out.println("<input type='text' name='nat_id_no_for_disp' id='nat_id_no_for_disp'></input><input type='hidden' name='step' id='step' value='second'><input type='hidden' name='nat_id_check_digit_id' id='nat_id_check_digit_id' value=''+nat_id_check_digit_id+''>") ;
					out.println("</form><script>document.getElementById('nat_id_no_for_disp').style.visibility='hidden';document.getElementById('nat_id_no').focus();</script></body></html>");
	
					if(stmt != null) stmt.close();

				} // End of FIRST INTERNAL IF

				if(KeyVal.equals("A"))
				{
					%>
					<html>
						<head>
							<%
							alt_id1_type = rs.getString("alt_id1_type");
							%>
							<title><fmt:message key="Common.Check.label" bundle="${common_labels}"/> <%=alt_id1_type%></title>
							<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
							<script language='javascript'>
								function checkAltNo(check)
								{
									if(check =='Y')
									{
										if(document.getElementById('alt_holder_yn').checked == true)
										{
											if(checkField(document.getElementById('alt_id_no'),"<%=alt_id1_type%>"+' No'))
											{
												if('<%=alt_id1_accept_alphanumeric_yn%>' == 'N')
												{
													if(isNaN(document.getElementById('alt_id_no').value))
													{
														document.getElementById('alt_id_no').focus();					
														var chk_dig_mes = getMessage("ALT_ID_NO",'MP');
														chk_dig_mes = chk_dig_mes.replace('$',"<%=alt_id1_type%>");
														alert(chk_dig_mes);
														return false;
													}
												}
		
												if(document.getElementById('alt_id_no').value.length == 			document.getElementById('alt_id_no').maxLength)
												{
													return true;
												}
												else
												{
													var msg = getMessage("ALT_ID_CHARS",'MP')
													msg =msg.replace('$',"<%=alt_id1_type%>")
													msg =msg.replace('@',document.getElementById('alt_id_no').maxLength)
													alert(msg)
													document.getElementById('alt_id_no').focus();
													return false;
												}
											} // END of second IF
										}
										else
										{
											parent.window.returnValue = 'G';
											parent.window.close();
										}
										//End of the Main IF
									}
									else if ( document.getElementById('alt_holder_yn').checked == true )
									{
										 if ( checkField(document.getElementById('alt_id_no'),"<%=alt_id1_type%>"+' No') )
											return true;
									}
									else
									{
										parent.window.returnValue = 'G';
										parent.window.close();
									}
								}  // End of the Function

								function submitAll(check,unique_yn)
								{
									if (checkAltNo(check) == true)
									{
										//document.alt_form.submit();
										var params = "?";
										for(var i=0;i<document.alt_form.elements.length;i++)
										{
											params = params+document.alt_form.elements[i].name+"="+escape(document.alt_form.elements[i].value)+"&"
										}
										params=params+"alt_unique="+unique_yn
										location.href ="../../eMP/jsp/checkNationality.jsp"+params
									}
								}

								function CancelModal()
								{
									parent.window.returnValue='G';
									parent.window.close();
								}

								function checkBoxClicked()  
								{
									if(document.getElementById('alt_holder_yn').checked == true)
									{
										document.getElementById('alt_id_no').readOnly = false;
										document.getElementById('alt_holder_yn').checked = true;
										document.getElementById('alt_id_no').focus();
									}
									else
									{
										document.getElementById('alt_holder_yn').checked = false;
										document.getElementById('alt_id_no').readOnly = true;
										document.getElementById('alt_id_no').value = '';
									}
								}
								function CheckSplCharsAltID(event){
									var alt_id1_accept_alphanumeric_yn = document.alt_form.alt_id1_accept_alphanumeric_yn.value;
									var whichCode = (window.Event) ? event.which : event.keyCode;
									key = String.fromCharCode(whichCode);
									var specCharsExist = true;
									if(alt_id1_accept_alphanumeric_yn=="Y")
										strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-';
									else
										strCheck = '0123456789';
									if (strCheck.indexOf(key) == -1){
										return false;
									}
									if( (event.keyCode >= 97) && (event.keyCode <= 122) )
										return (event.keyCode -= 32);
									return true ;
								}
							</script>


						</head>
						<%
						String alt_id_val = checkForNull(request.getParameter("alt_id"));
						if(alt_id_val == null)alt_id_val ="";
						if(alt_id_val.equals("null"))   alt_id_val ="" ;
						out.println("<body onKeyDown='lockKey()'><br><form name='alt_form' id='alt_form' method='post' action='../../eMP/jsp/checkNationality.jsp?step=second&routine_chk="+rs.getString("alt_id1_routine_yn")+"&routine_name="+rs.getString("alt_id1_routine")+"' target='msgFrame'><table width='100%' align='center' cellspacing='0' cellpadding='0' border='0'><tr><td colspan='2'>&nbsp;</td></tr><tr><td align='right' width='40%' class='label'>"+rs.getString("alt_id1_type")+" Holder</td><td width='60%' align='left'>&nbsp;&nbsp;<input type='checkbox' name='alt_holder_yn' id='alt_holder_yn' value='' checked onclick='checkBoxClicked();'/></td></tr>");
						out.println("<tr><td align='right' width='40%' class='label'>"+ rs.getString("alt_id1_type") + " No</td>");

						out.println("<td width='60%' align='left'>&nbsp;&nbsp;&nbsp;<input type='text' name='alt_id_no' id='alt_id_no' value=\""+alt_id_val+"\" size='"+rs.getInt("alt_id1_length")+"' maxlength='"+rs.getInt("alt_id1_length")+"' onKeyPress='return CheckSplCharsAltID(event);' onBlur='chkForAltID1Length(this);SpeCharCheck(this); return makeValidString(this);'/><input type='hidden' name='group' id='group' value='A'/><input type='hidden' name='alt_id1_accept_alphanumeric_yn' id='alt_id1_accept_alphanumeric_yn' value='"+alt_id1_accept_alphanumeric_yn+"'/></td></tr>");


						out.println("<tr><td colspan='2'>&nbsp</td></tr><tr><td colspan='2' align='center'><input type='button' name='ok' id='ok' Value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")+"' class='Button' onclick=\"submitAll('"+rs.getString("alt_id1_len_validation_yn")+"','"+rs.getString("ALT_ID1_UNIQUE_YN")+"')\"/>&nbsp;&nbsp;<input type='Button' name='cancel' id='cancel' value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")+"' class='Button' onclick='CancelModal()'/></td></tr><tr><td colspan='2'>&nbsp;<input type='hidden' name='alt_id_type' id='alt_id_type' value="+ rs.getString("alt_id1_type") + " No /></td></tr></table>");
						out.println("<input type='text' name='alt_id_no_for_disp' id='alt_id_no_for_disp'></input><input type='hidden' name='step' id='step' value='second'/><input type='hidden' name='nat_id_check_digit_id' id='nat_id_check_digit_id' value='"+nat_id_check_digit_id+"'/><input type='hidden' name='alt_id1_length' id='alt_id1_length' value='"+rs.getInt("alt_id1_length")+"'/><input type='hidden' name='routine_chk' id='routine_chk' value=\""+rs.getString("alt_id1_routine_yn")+"\"/><input type='hidden' name='rouroutine_name' id='rouroutine_name' value=\""+rs.getString("alt_id1_routine")+"\"/>");
						out.println("</form><script>document.forms[0].alt_id_no_for_disp.style.visibility='hidden';document.forms[0].alt_id_no.focus()</script></body></html>");

						if(stmt != null) stmt.close();
					}
				}	
			}	

			//SECOND SET OF OPERATIONS STARTS HERE //
//out.println("<script>alert('function :"+function+"');</script>");
			if(function.equals("second"))
			{
				String nat_id_no = "";
				String nat_id_name ="";
				String ext_system_interface_yn ="N";
				String nat_data_source_id ="";
				String selected_id = checkForNull(request.getParameter("selected_id"));
				String validate_dup = checkForNull(request.getParameter("validate_dup"),"Y");
				String populateDOBYn = checkForNull(request.getParameter("populateDOBYn"),"N");//Added by Thamizh selvi on 1st Aug 2018 against ML-MMOH-CRF-1177
				//System.out.println("group :'"+request.getParameter("group")+"'");
//out.println("<script>alert('group "+request.getParameter("group")+"')</script>");
				//String validate_dup = checkForNull(request.getParameter("validate_dup"),"N");
				if(checkForNull(request.getParameter("group")).equals("N")   )
				{
					String outArea					= checkForNull(request.getParameter("output"));
				    nat_id_check_digit_id	= checkForNull(request.getParameter("nat_id_check_digit_id"));
			    	nat_id_no						= checkForNull(request.getParameter("nat_id_no"));
					nat_id_name					= checkForNull(request.getParameter("nat_id_name"));
					ext_system_interface_yn		= checkForNull(request.getParameter("ext_system_interface_yn"),"N");

					nat_data_source_id  = checkForNull(request.getParameter("routine_name"));

					String result = "Y";    

				    stmt = conn.createStatement();
				   //out.println("<script>alert('nat_id_check_digit_id "+nat_id_check_digit_id+"');</script>");
				   //out.println("<script>alert('nat_data_source_id "+nat_data_source_id+"');</script>");
				   //System.out.println("nat_id_check_digit_id :'"+nat_id_check_digit_id+"'");
				   //System.out.println("nat_data_source_id :'"+nat_data_source_id+"'");
				    //if(nat_id_check_digit_id != null && !nat_id_check_digit_id.equals("") && ext_system_interface_yn.equals("N") && nat_data_source_id.equals(""))
				    if(nat_id_check_digit_id != null && !nat_id_check_digit_id.equals("") && nat_data_source_id.equals(""))
					{
						sql = "SELECT program_name FROM mp_check_digit_scheme WHERE scheme_id = '"+nat_id_check_digit_id+"' ";
						//out.println("<script>alert('"+sql+"');</script>");
				        rs = stmt.executeQuery(sql);
				        if(rs.next())
				        {
				            nat_id_check_digit_id = rs.getString(1);
  //out.println("<script>alert('nat_id_check_digit_id "+nat_id_check_digit_id+" "+nat_id_no+"');</script>");
  //System.out.println("nat_id_check_digit_id 2:'"+nat_id_check_digit_id+"'");
				            if(rs != null)  rs.close();

							sql	= "select "+nat_id_check_digit_id+"('"+nat_id_no+"') from dual";
					        rs = stmt.executeQuery(sql);
				     			if(rs.next())
								result = rs.getString(1);
				            if(rs != null)  rs.close();
						}
					}
				    if(rs != null)  rs.close();
 //out.println("<script>alert('result "+result+"');</script>");
 //out.println("<script>alert('validate_dup "+validate_dup+"');</script>");
 //System.out.println("result :'"+result+"'");
 //System.out.println("validate_dup :'"+validate_dup+"'");
					String dup_nat_id = checkForNull(request.getParameter("dup_nat_id"));
		            if(dup_nat_id == null)  dup_nat_id = "" ;
					
					
					if(result.equals("Y") ) // 2
					{
						if (validate_dup.equals("Y"))
						{
			            String duplicateSql = "select patient_id from mp_patient where national_id_no = '"+nat_id_no+"'";
						
					    stmt = conn.createStatement();
				        rs = stmt.executeQuery(duplicateSql);
//out.println("<script>alert('dup_nat_id "+dup_nat_id+"')</script>");
//out.println("<script>alert('nat_id_no "+nat_id_no+"')</script>");
//System.out.println("dup_nat_id :'"+dup_nat_id+"'");
//System.out.println("nat_id_no :'"+nat_id_no+"'");

						int inActiveNatIdCount	= eMP.MPCommonBean.getInactiveNatIdCnt(conn,nat_id_no); // Added by Dharma on 19th Dec 2018 against ML-MMOH-CRF-0723 [IN:062858]
						if((rs.next() && !dup_nat_id.equals(nat_id_no)) || inActiveNatIdCount > 0) // 1
				        {
						natIDCountInMPPatTable=0;
						String msgID	= "DUP_NAT_ID";
						if(inActiveNatIdCount > 0){
							msgID	= "NAT_ID_INACTIVE";
						}
						if(isNatIdAltIdMandVisaType.equals("true") && dftNationalId.equals(nat_id_no))
								{
									
								}
								else {
				           if(outArea.equals("W"))
							{
				                out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body onKeyDown='lockKey()'><center><br><br>"+
							    "  <script>val1 = getMessage('"+msgID+"','MP'); "+
			                    "val1 = val1.replace('#','"+checkForNull(request.getParameter("nat_id_prompt"))+"');"+
						        "document.write(val1)</script>"+
				                "<br><br><center><input type='Button' name='back' id='back' value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Back.label","common_labels")+"' class='Button'  onclick=\"callPrev('N')\" ></center></body></html>");
							}
				            else if(outArea.equals("A"))
							{
								natIDCountInMPPatTable=0;
								%>
								
					            <html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></head>
					            <body class='MESSAGE' onKeyDown='lockKey()'>								
			                   <script>
								if ('<%=from_newBorn%>'=='Y')
									frameRef = "parent.f_query_add_mod.frames[2]";
								else
								{
									frameRef = "parent.f_query_add_mod.patient_sub";
									eval(frameRef+".document.getElementById('nat_id_val').value ='F'");
								}
								val1 = eval(frameRef+".getMessage('<%=msgID%>','MP')");
								val1 = val1.replace('#',eval(frameRef+".document.getElementById('nat_id_prompt').value"));
								eval(frameRef).window.alert(val1);								
								let natIdElement = frameRef.document.getElementById('<%=nat_id_name%>');
										natIdElement.value = "";
										natIdElement.focus();
						        </script>
								</body></html>
						        <%
							}
								}
						} else if(!dup_nat_id.equals(nat_id_no))
						{//out.println("<script>alert('dup_nat_id and nat_id_no are not equal:')</script>");
						//System.out.println("dup_nat_id and nat_id_no are not equal:");
				            out.println("<body class='message' onKeyDown='lockKey()'>");
				            String from_pat= request.getParameter("from_pat"); 
							String Site = request.getParameter("Site") ;
							String def_nat_id  = request.getParameter("def_nat_id") ;
							String routine_name  = request.getParameter("routine_name");
							if (routine_name==null) routine_name="";
							String nat_routine = "N";
							int natcnt=0;
							
							Properties p				=	(java.util.Properties) session.getValue("jdbc");
							String userId				= (String)session.getAttribute("login_user");
							HashMap hashMap12		= new HashMap();
							
							
							
							hashMap12 = eMP.ChangePatientDetails.getSetupData((String)session.getValue("facility_id"),"",conn,p);
							String pat_ser_access_by_user_yn = checkForNull((String)hashMap12.get("PAT_SER_ACCESS_BY_USER_YN"));
							String userAccessSql	= "";
							
						
							if(pat_ser_access_by_user_yn.equals("Y")){
								userAccessSql	= " and pat_ser_grp_code IN (SELECT pat_ser_grp_code FROM MP_PAT_SER_GRP_FOR_USER WHERE APPL_USER_ID = '"+userId+"') ";
							}
							
							
							
							rs = stmt.executeQuery("select pat_ser_grp_code from mp_pat_ser_grp where id_type = 'N' and id_type not in ('R', 'X') and pat_ser_grp_code in (select pat_ser_grp_code from mp_pat_ser_facility where site_or_facility_id = decode(site_or_facility,'S','"+Site+"','F','"+(String)session.getValue("facility_id")+"') and used_status = 'N' ) "+userAccessSql+" ");
						
							
							
							if(rs.next())
								natcnt = 1;
							if(routine_name.equals("NRIC"))
							{
								routine_name = "VERIFY_NATIONAL_ID";
								nat_routine = "Y";
							}
							if(rs!=null) rs.close();
							//if(stmt!=null) stmt.close();
//out.println("<script>alert('from_pat "+from_pat+"')</script>");
//out.println("<script>alert('from_newBorn "+from_newBorn+"')</script>");
//out.println("<script>alert('routine_name "+routine_name+"')</script>");
//System.out.println("from_pat :'"+from_pat+"'");
//System.out.println("from_newBorn :'"+from_newBorn+"'");
//System.out.println("routine_name :'"+routine_name+"'");
//System.out.println("outArea :"+outArea);
							if ( (from_pat != null) && (!from_newBorn.equals("Y") ) )
							{
									if(routine_name.equals("VERIFY_NATIONAL_ID") && nat_routine.equals("Y"))
									{
										String result1 = "";
										String error_message = "";
										String date_of_birth = "";
										//stmt = con.prepareStatement("select VERIFY_NATIONAL_ID('"+nat_id_no+"') FROM DUAL");
										rs = stmt.executeQuery("select VERIFY_NATIONAL_ID('"+nat_id_no+"') FROM DUAL");
										if (rs.next())
											result1 = rs.getString(1);
										
										StringTokenizer strTok = new StringTokenizer(result1,"$");
												
										String age_in_years  = "";
										String age_in_months = "";
										String age_in_days   = "";
										String sex = "";
										String place_of_birth_code="";
										String place_of_birth_desc = "";				
										if (strTok.hasMoreTokens())
											result1 = strTok.nextToken();
										
										if ( result1.equals("TRUE") ){
											if (strTok.hasMoreTokens())
												date_of_birth = strTok.nextToken();	
											if (strTok.hasMoreTokens())
												age_in_years = strTok.nextToken();	
											if (strTok.hasMoreTokens())
												age_in_months = strTok.nextToken();	
											if (strTok.hasMoreTokens())
												age_in_days = strTok.nextToken();	
											if (strTok.hasMoreTokens())
												sex = strTok.nextToken();
											if (strTok.hasMoreTokens())
												place_of_birth_code = strTok.nextToken();
											if (strTok.hasMoreTokens())
												place_of_birth_desc = strTok.nextToken();
											if (!localeName.equals("en"))
											{
												date_of_birth = DateUtils.convertDate(date_of_birth,"DMY","en",localeName); 
											}
											//ADDED for ML-MMOH-SCF-3108
											String sDate_of_birth = checkForNull(request.getParameter("Birth_Date"));
											System.out.println("sDate_of_birth=========================>"+sDate_of_birth);
											String[] parts = sDate_of_birth.split(" ");
											String time = parts.length > 1 ? parts[1] : ""; 
											System.out.println("Extracted Time: " + time); // END ML-MMOH-SCF-3108
											%>
											<script>
												parent.f_query_add_mod.patient_sub.document.getElementById('date_of_birth').value="<%=date_of_birth%>";						
												parent.f_query_add_mod.patient_sub.document.getElementById('Birth_Date').value="<%=date_of_birth +" "+ time%>"; //modified for ML-MMOH-SCF-3108 
												parent.f_query_add_mod.patient_sub.document.getElementById('b_age').value="<%=age_in_years%>";
												parent.f_query_add_mod.patient_sub.document.getElementById('b_months').value="<%=age_in_months%>";
												parent.f_query_add_mod.patient_sub.document.getElementById('b_days').value="<%=age_in_days%>";
												parent.f_query_add_mod.patient_sub.document.getElementById('place_of_birth_code').value="<%=place_of_birth_code%>";
												parent.f_query_add_mod.patient_sub.document.getElementById('sex').value="<%=sex%>";
												parent.f_query_add_mod.patient_sub.document.getElementById('place_of_birth_desc').value="<%=place_of_birth_desc%>";
											
												if('<%=place_of_birth_code%>' != null){
													parent.f_query_add_mod.patient_sub.document.getElementById('place_of_birth').value='';											parent.f_query_add_mod.patient_sub.document.getElementById('place_of_birth_desc').disabled=false;	parent.f_query_add_mod.patient_sub.document.getElementById('birth_place').disabled=false;
												}
												if('<%=place_of_birth_desc%>'=="") {										parent.f_query_add_mod.patient_sub.document.getElementById('place_of_birth').disabled=false;
												}
											</script>
											<%
										}
										else if ( result1.equals("FALSE") ){
											if(strTok.hasMoreTokens()) 
												error_message = strTok.nextToken();
												flag = false ;
											%>
											<script>
												var msg = getMessage('<%=error_message%>','MP'); msg = msg.replace('#', parent.f_query_add_mod.patient_sub.document.getElementById('nat_id_prompt').value);alert(msg);
												parent.f_query_add_mod.patient_sub.document.getElementById('national_id_no').value = "" ;
												
											</script>
											<%
										}else{
											if (strTok.hasMoreTokens())
												error_message = strTok.nextToken();
											out.println("alert(\""+error_message+"\")");											
											flag = false ;
										}
										strTok = null;
									}
									//out.println("<script>alert('flag before "+flag+"')</script>");
									//out.println("<script>alert('natIDCountInMPPatTable before "+natIDCountInMPPatTable+"')</script>");
									//System.out.println("flag :'"+flag+"'");
									//System.out.println("natIDCountInMPPatTable :'"+natIDCountInMPPatTable+"'");
									if(flag || natIDCountInMPPatTable==1){
										/*Bru-HIMS-CRF-124 starts*/
										/*Bru-HIMS-CRF-124 ends*/
										String xf_personSQL="select NATIONAL_ID_NO,EXT_PAT_ID,EHIS_PAT_ID,ALT_ID1_TYPE,ALT_ID1_NO,TO_CHAR (ALT_ID1_EXP_DATE, 'dd/mm/yyyy')ALT_ID1_EXP_DATE,NAME_PREFIX,FIRST_NAME,SECOND_NAME,THIRD_NAME,FAMILY_NAME,FAMILY_NAME_PREFIX,NAME_SUFFIX,SEX GENDER,to_char(DATE_OF_BIRTH, 'dd/mm/yyyy') DATE_OF_BIRTH,NATIONALITY_CODE,(CASE WHEN NATIONALITY_CODE IS NOT NULL THEN (mp_get_desc.mp_country(NATIONALITY_CODE,'"+localeName+"',3)) END ) nationality_desc,RACE_CODE,(CASE WHEN RACE_CODE IS NOT NULL THEN (mp_get_desc.mp_race(RACE_CODE,'"+localeName+"',2)) END ) RACE_DESC,RELIGION_CODE, (CASE WHEN RELIGION_CODE IS NOT NULL THEN (mp_get_desc.mp_religion(RELIGION_CODE,'"+localeName+"',2)) END ) RELIGION_DESC,RES_ADDR_LINE_1,RES_ADDR_LINE_2,RES_ADDR_LINE_3,RES_ADDR_LINE_4,RES_TOWN_CODE,(CASE WHEN RES_TOWN_CODE IS NOT NULL  THEN (mp_get_desc.mp_res_town(RES_TOWN_CODE,'"+localeName+"',2)) END ) RES_TOWN_DESC,RES_AREA_CODE,(CASE WHEN RES_AREA_CODE IS NOT NULL THEN (mp_get_desc.mp_res_area(RES_AREA_CODE,'"+localeName+"',2)) END ) RES_AREA_DESC,RES_REGION_CODE,(CASE WHEN RES_REGION_CODE IS NOT NULL THEN (mp_get_desc.mp_region(RES_REGION_CODE,'"+localeName+"',2)) END ) RES_REGION_DESC,RES_POSTAL_CODE,mp_get_desc.mp_postal_code(RES_POSTAL_CODE,'"+localeName+"',2) RES_POSTAL_DESC,RES_COUNTRY_CODE, (CASE WHEN RES_COUNTRY_CODE IS NOT NULL THEN (mp_get_desc.mp_country(RES_COUNTRY_CODE,'"+localeName+"',1)) END ) RES_COUNTRY_DESC,DECEASED_YN,DOC1_TYPE,(CASE WHEN DOC1_TYPE IS NOT NULL THEN(mp_get_desc.mp_document_type(DOC1_TYPE, '"+localeName+"', 2)) END) DOC1_TYPE_DESC,DOC1_NUM,TO_CHAR(DOC1_EXP_DATE, 'DD/MM/YYYY')DOC1_EXP_DATE,DOC1_PLACE_OF_ISSUE,TO_CHAR(DOC1_ISS_DATE, 'DD/MM/YYYY') DOC1_ISS_DATE,STATUS from xf_person where national_id_no='"+nat_id_no+"'";
										//System.out.println("checkNationality.jsp xf_personSQL:"+xf_personSQL);
										if(rs!=null)rs.close();
										rs = stmt.executeQuery(xf_personSQL);
										if(rs!=null && rs.next()){
										String alt_id1_tyep=rs.getString("ALT_ID1_TYPE")==null?"":rs.getString("ALT_ID1_TYPE");
										String alt_id1_no=rs.getString("ALT_ID1_NO")==null?"":rs.getString("ALT_ID1_NO");
										String alt_id1_exp_date=rs.getString("ALT_ID1_EXP_DATE")==null?"":rs.getString("ALT_ID1_EXP_DATE");
										String name_prefix=rs.getString("NAME_PREFIX")==null?"":rs.getString("NAME_PREFIX");
										String first_name=rs.getString("FIRST_NAME")==null?"":rs.getString("FIRST_NAME");
										String second_name=rs.getString("SECOND_NAME")==null?"":rs.getString("SECOND_NAME");
										String third_name=rs.getString("THIRD_NAME")==null?"":rs.getString("THIRD_NAME");
										String family_name=rs.getString("FAMILY_NAME")==null?"":rs.getString("FAMILY_NAME");
										String family_name_prefix=rs.getString("FAMILY_NAME_PREFIX")==null?"":rs.getString("FAMILY_NAME_PREFIX");
										String name_suffix=rs.getString("NAME_SUFFIX")==null?"":rs.getString("NAME_SUFFIX");
										String gender=rs.getString("GENDER")==null?"":rs.getString("GENDER");
										String date_of_birth=rs.getString("date_of_birth")==null?"":rs.getString("date_of_birth");
										String nationality_code=rs.getString("NATIONALITY_CODE")==null?"":rs.getString("NATIONALITY_CODE");
										String nationality_desc=rs.getString("NATIONALITY_DESC")==null?"":rs.getString("NATIONALITY_DESC");
										String race_code=rs.getString("RACE_CODE")==null?"":rs.getString("RACE_CODE");
										String race_desc=rs.getString("RACE_DESC")==null?"":rs.getString("RACE_DESC");
										String religion_code=rs.getString("RELIGION_CODE")==null?"":rs.getString("RELIGION_CODE");
										String religion_desc=rs.getString("RELIGION_DESC")==null?"":rs.getString("RELIGION_DESC");
										String res_addr_line_1=rs.getString("res_addr_line_1")==null?"":rs.getString("res_addr_line_1");
										String res_addr_line_2=rs.getString("res_addr_line_2")==null?"":rs.getString("res_addr_line_2");
										String res_addr_line_3=rs.getString("res_addr_line_3")==null?"":rs.getString("res_addr_line_3");
										String res_addr_line_4=rs.getString("res_addr_line_4")==null?"":rs.getString("res_addr_line_4");
										String res_town_code=rs.getString("RES_TOWN_CODE")==null?"":rs.getString("RES_TOWN_CODE");
										String res_town_desc=rs.getString("RES_TOWN_DESC")==null?"":rs.getString("RES_TOWN_DESC");
										String res_area_code=rs.getString("RES_AREA_CODE")==null?"":rs.getString("RES_AREA_CODE");
										String res_area_desc=rs.getString("RES_AREA_DESC")==null?"":rs.getString("RES_AREA_DESC");
										String res_region_code=rs.getString("RES_REGION_CODE")==null?"":rs.getString("RES_REGION_CODE");
										String res_region_desc=rs.getString("RES_REGION_DESC")==null?"":rs.getString("RES_REGION_DESC");
										String res_postal_desc=rs.getString("RES_POSTAL_DESC")==null?"":rs.getString("RES_POSTAL_DESC");
										String res_country_code=rs.getString("RES_COUNTRY_CODE")==null?"":rs.getString("RES_COUNTRY_CODE");
										String res_country_desc=rs.getString("RES_COUNTRY_DESC")==null?"":rs.getString("RES_COUNTRY_DESC");
										String doc1_type=rs.getString("DOC1_TYPE")==null?"":rs.getString("DOC1_TYPE");
										String doc1_type_desc=rs.getString("DOC1_TYPE_DESC")==null?"":rs.getString("DOC1_TYPE_DESC");
										String doc1_num=rs.getString("DOC1_NUM")==null?"":rs.getString("DOC1_NUM");
										String doc1_exp_date=rs.getString("DOC1_EXP_DATE")==null?"":rs.getString("DOC1_EXP_DATE");
										String doc1_place_of_issue=rs.getString("DOC1_PLACE_OF_ISSUE")==null?"":rs.getString("DOC1_PLACE_OF_ISSUE");
										String doc1_iss_date=rs.getString("DOC1_ISS_DATE")==null?"":rs.getString("DOC1_ISS_DATE");
										deceased_yn=rs.getString("DECEASED_YN")==null?"N":rs.getString("DECEASED_YN");
										%>
											<script>
											if('<%=deceased_yn%>'=='N'){
												if(parent.f_query_add_mod.patient_sub.document.getElementById('alt_id1_no'))
													parent.f_query_add_mod.patient_sub.document.getElementById('alt_id1_no').value='<%=alt_id1_no%>';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('alt_id1_exp_date'))
													parent.f_query_add_mod.patient_sub.document.getElementById('alt_id1_exp_date').value='<%=alt_id1_exp_date%>';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('name_prefix'))
													parent.f_query_add_mod.patient_sub.document.getElementById('name_prefix').value='<%=name_prefix%>';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('first_name'))
													parent.f_query_add_mod.patient_sub.document.getElementById('first_name').value='<%=first_name%>';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('second_name'))
													parent.f_query_add_mod.patient_sub.document.getElementById('second_name').value='<%=second_name%>';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('third_name'))
													parent.f_query_add_mod.patient_sub.document.getElementById('third_name').value='<%=third_name%>';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('family_name'))
													parent.f_query_add_mod.patient_sub.document.getElementById('family_name').value='<%=family_name%>';	
												if(parent.f_query_add_mod.patient_sub.document.getElementById('family_name_prefix'))
													parent.f_query_add_mod.patient_sub.document.getElementById('family_name_prefix').value='<%=family_name_prefix%>';	
												if(parent.f_query_add_mod.patient_sub.document.getElementById('name_suffix'))
													parent.f_query_add_mod.patient_sub.document.getElementById('name_suffix').value='<%=name_suffix%>';
													
												/* As of now external interface will not populate local lang data.
												if(parent.f_query_add_mod.patient_sub.document.getElementById('name_prefix_oth_lang'))
													parent.f_query_add_mod.patient_sub.document.getElementById('name_prefix_oth_lang').value='';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('first_name_oth_lang'))
													parent.f_query_add_mod.patient_sub.document.getElementById('first_name_oth_lang').value='';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('second_name_oth_lang'))
													parent.f_query_add_mod.patient_sub.document.getElementById('second_name_oth_lang').value='';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('third_name_oth_lang'))
													parent.f_query_add_mod.patient_sub.document.getElementById('third_name_oth_lang').value='';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('family_name_oth_lang'))
													parent.f_query_add_mod.patient_sub.document.getElementById('family_name_oth_lang').value='';	
												if(parent.f_query_add_mod.patient_sub.document.getElementById('name_suffix_oth_lang'))
													parent.f_query_add_mod.patient_sub.document.getElementById('name_suffix_oth_lang').value='';
												*/
												if(parent.f_query_add_mod.patient_sub.document.getElementById('sex'))
													parent.f_query_add_mod.patient_sub.document.getElementById('sex').value='<%=gender%>';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('date_of_birth') && '<%=date_of_birth%>'!=''){
													parent.f_query_add_mod.patient_sub.document.getElementById('date_of_birth').value='<%=date_of_birth%>';
													parent.f_query_add_mod.patient_sub.gotoNext(parent.f_query_add_mod.patient_sub.document.getElementById('date_of_birth'));
													parent.f_query_add_mod.patient_sub.disableEnableYMDH(parent.f_query_add_mod.patient_sub.document.getElementById('date_of_birth'));
												}
												if(parent.f_query_add_mod.patient_sub.document.getElementById('nationality_code'))
													parent.f_query_add_mod.patient_sub.document.getElementById('nationality_code').value='<%=nationality_code%>';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('nationality_desc'))
													parent.f_query_add_mod.patient_sub.document.getElementById('nationality_desc').value='<%=nationality_desc%>';	
												if(parent.f_query_add_mod.patient_sub.document.getElementById('race_code'))
													parent.f_query_add_mod.patient_sub.document.getElementById('race_code').value='<%=race_code%>';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('race_desc'))
													parent.f_query_add_mod.patient_sub.document.getElementById('race_desc').value='<%=race_desc%>';	
												if(parent.f_query_add_mod.patient_sub.document.getElementById('relgn_code'))
													parent.f_query_add_mod.patient_sub.document.getElementById('relgn_code').value='<%=religion_code%>';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('relgn_desc'))
													parent.f_query_add_mod.patient_sub.document.getElementById('relgn_desc').value='<%=religion_desc%>';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('r_addr_line1'))
													parent.f_query_add_mod.patient_sub.document.getElementById('r_addr_line1').value='<%=res_addr_line_1%>';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('r_addr_line2'))
													parent.f_query_add_mod.patient_sub.document.getElementById('r_addr_line2').value='<%=res_addr_line_2%>';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('r_addr_line3'))
													parent.f_query_add_mod.patient_sub.document.getElementById('r_addr_line3').value='<%=res_addr_line_3%>';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('r_addr_line4'))
													parent.f_query_add_mod.patient_sub.document.getElementById('r_addr_line4').value='<%=res_addr_line_4%>';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('r_town'))
													parent.f_query_add_mod.patient_sub.document.getElementById('r_town').value='<%=res_town_code%>';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('r_town_code'))
													parent.f_query_add_mod.patient_sub.document.getElementById('r_town_code').value='<%=res_town_desc%>';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('r_area'))
													parent.f_query_add_mod.patient_sub.document.getElementById('r_area').value='<%=res_area_code%>';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('r_area_code'))
													parent.f_query_add_mod.patient_sub.document.getElementById('r_area_code').value='<%=res_area_desc%>';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('r_region'))
													parent.f_query_add_mod.patient_sub.document.getElementById('r_region').value='<%=res_region_code%>';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('r_region_code'))
													parent.f_query_add_mod.patient_sub.document.getElementById('r_region_code').value='<%=res_region_desc%>';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('r_postal_code1'))
													parent.f_query_add_mod.patient_sub.document.getElementById('r_postal_code1').value='<%=res_postal_desc%>';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('r_country_code'))
													parent.f_query_add_mod.patient_sub.document.getElementById('r_country_code').value='<%=res_country_code%>';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('r_country_desc'))
													parent.f_query_add_mod.patient_sub.document.getElementById('r_country_desc').value='<%=res_country_desc%>';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('doc_id1'))
													parent.f_query_add_mod.patient_sub.document.getElementById('doc_id1').value='<%=doc1_type%>';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('doc_id1_desc'))
													parent.f_query_add_mod.patient_sub.document.getElementById('doc_id1_desc').value='<%=doc1_type_desc%>';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('doc_num1'))
													parent.f_query_add_mod.patient_sub.document.getElementById('doc_num1').value='<%=doc1_num%>';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('doc_exp_dt1'))
													parent.f_query_add_mod.patient_sub.document.getElementById('doc_exp_dt1').value='<%=doc1_exp_date%>';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('place_of_issue1'))
													parent.f_query_add_mod.patient_sub.document.getElementById('place_of_issue1').value='<%=doc1_place_of_issue%>';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('issue_date1'))
													parent.f_query_add_mod.patient_sub.document.getElementById('issue_date1').value='<%=doc1_iss_date%>';
												parent.f_query_add_mod.patient_sub.putPatientName('');
												//parent.f_query_add_mod.patient_sub.putLocalLangPatientName('');
											}else{
													alert(getMessage('PAT_DECEASED_NOT_ALLOWED','MP'));
													parent.f_query_add_mod.patient_sub.document.getElementById('national_id_no').value=''; 
												if(parent.f_query_add_mod.patient_sub.document.getElementById('alt_id1_no'))
													parent.f_query_add_mod.patient_sub.document.getElementById('alt_id1_no').value='';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('alt_id1_exp_date'))
													parent.f_query_add_mod.patient_sub.document.getElementById('alt_id1_exp_date').value='';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('name_prefix'))
													parent.f_query_add_mod.patient_sub.document.getElementById('name_prefix').value='';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('first_name'))
													parent.f_query_add_mod.patient_sub.document.getElementById('first_name').value='';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('second_name'))
													parent.f_query_add_mod.patient_sub.document.getElementById('second_name').value='';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('third_name'))
													parent.f_query_add_mod.patient_sub.document.getElementById('third_name').value='';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('family_name'))
													parent.f_query_add_mod.patient_sub.document.getElementById('family_name').value='';	
												if(parent.f_query_add_mod.patient_sub.document.getElementById('family_name_prefix'))
													parent.f_query_add_mod.patient_sub.document.getElementById('family_name_prefix').value='';	
												if(parent.f_query_add_mod.patient_sub.document.getElementById('name_suffix'))
													parent.f_query_add_mod.patient_sub.document.getElementById('name_suffix').value='';
													
												/* As of now external interface will not populate local lang data.
												if(parent.f_query_add_mod.patient_sub.document.getElementById('name_prefix_oth_lang'))
													parent.f_query_add_mod.patient_sub.document.getElementById('name_prefix_oth_lang').value='';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('first_name_oth_lang'))
													parent.f_query_add_mod.patient_sub.document.getElementById('first_name_oth_lang').value='';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('second_name_oth_lang'))
													parent.f_query_add_mod.patient_sub.document.getElementById('second_name_oth_lang').value='';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('third_name_oth_lang'))
													parent.f_query_add_mod.patient_sub.document.getElementById('third_name_oth_lang').value='';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('family_name_oth_lang'))
													parent.f_query_add_mod.patient_sub.document.getElementById('family_name_oth_lang').value='';	
												if(parent.f_query_add_mod.patient_sub.document.getElementById('family_name_prefix'))
													parent.f_query_add_mod.patient_sub.document.getElementById('family_name_prefix').value='';	
												if(parent.f_query_add_mod.patient_sub.document.getElementById('name_suffix_oth_lang'))
													parent.f_query_add_mod.patient_sub.document.getElementById('name_suffix_oth_lang').value='';
												*/
												
												if(parent.f_query_add_mod.patient_sub.document.getElementById('sex'))
													parent.f_query_add_mod.patient_sub.document.getElementById('sex').value='';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('date_of_birth')){
													parent.f_query_add_mod.patient_sub.document.getElementById('date_of_birth').value='';
													parent.f_query_add_mod.patient_sub.gotoNext(parent.f_query_add_mod.patient_sub.document.getElementById('date_of_birth'));
													parent.f_query_add_mod.patient_sub.disableEnableYMDH(parent.f_query_add_mod.patient_sub.document.getElementById('date_of_birth'));
												}
												if(parent.f_query_add_mod.patient_sub.document.getElementById('nationality_code'))
													parent.f_query_add_mod.patient_sub.document.getElementById('nationality_code').value='';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('nationality_desc'))
													parent.f_query_add_mod.patient_sub.document.getElementById('nationality_desc').value='';	
												if(parent.f_query_add_mod.patient_sub.document.getElementById('race_code'))
													parent.f_query_add_mod.patient_sub.document.getElementById('race_code').value='';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('race_desc'))
													parent.f_query_add_mod.patient_sub.document.getElementById('race_desc').value='';	
												if(parent.f_query_add_mod.patient_sub.document.getElementById('religion_code'))
													parent.f_query_add_mod.patient_sub.document.getElementById('religion_code').value='';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('relgn_desc'))
													parent.f_query_add_mod.patient_sub.document.getElementById('relgn_desc').value='';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('r_addr_line1'))
													parent.f_query_add_mod.patient_sub.document.getElementById('r_addr_line1').value='';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('r_addr_line2'))
													parent.f_query_add_mod.patient_sub.document.getElementById('r_addr_line2').value='';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('r_addr_line3'))
													parent.f_query_add_mod.patient_sub.document.getElementById('r_addr_line3').value='';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('r_addr_line4'))
													parent.f_query_add_mod.patient_sub.document.getElementById('r_addr_line4').value='';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('r_town'))
													parent.f_query_add_mod.patient_sub.document.getElementById('r_town').value='';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('r_town_code'))
													parent.f_query_add_mod.patient_sub.document.getElementById('r_town_code').value='';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('r_area'))
													parent.f_query_add_mod.patient_sub.document.getElementById('r_area').value='';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('r_area_code'))
													parent.f_query_add_mod.patient_sub.document.getElementById('r_area_code').value='';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('r_region'))
													parent.f_query_add_mod.patient_sub.document.getElementById('r_region').value='';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('r_region_code'))
													parent.f_query_add_mod.patient_sub.document.getElementById('r_region_code').value='';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('r_postal_code1'))
													parent.f_query_add_mod.patient_sub.document.getElementById('r_postal_code1').value='';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('r_country_code'))
													parent.f_query_add_mod.patient_sub.document.getElementById('r_country_code').value='';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('r_country_desc'))
													parent.f_query_add_mod.patient_sub.document.getElementById('r_country_desc').value='';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('doc_id1'))
													parent.f_query_add_mod.patient_sub.document.getElementById('doc_id1').value='';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('doc_id1_desc'))
													parent.f_query_add_mod.patient_sub.document.getElementById('doc_id1_desc').value='';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('doc_num1'))
													parent.f_query_add_mod.patient_sub.document.getElementById('doc_num1').value='';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('doc_exp_dt1'))
													parent.f_query_add_mod.patient_sub.document.getElementById('doc_exp_dt1').value='';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('place_of_issue1'))
													parent.f_query_add_mod.patient_sub.document.getElementById('place_of_issue1').value='';
												if(parent.f_query_add_mod.patient_sub.document.getElementById('issue_date1'))
													parent.f_query_add_mod.patient_sub.document.getElementById('issue_date1').value='';
												parent.f_query_add_mod.patient_sub.putPatientName('');
												//parent.f_query_add_mod.patient_sub.putLocalLangPatientName('');
											}												
											</script>
										<%}
										%>
									<html>
										<head>
											<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
										</head>
										<body class= 'message' onKeyDown='lockKey()' >
											<form name='construct_nat' id='construct_nat' action='../../eMP/jsp/ServerValidation.jsp' method='post'>
												<input type='hidden' name='process_id' id='process_id' value='11'>
												<input type='hidden' name='Site' id='Site' value="<%=Site%>">
												<input type='hidden' name='def_nat_id' id='def_nat_id' value="<%=def_nat_id%>">
												<input type='hidden' name='nat_id_val' id='nat_id_val' value="<%=nat_id_no%>">
												<input type='hidden' name='nat_routine' id='nat_routine' value="<%=nat_routine%>">
												<input type='hidden' name='nat_id_name' id='nat_id_name' value="<%=nat_id_name%>">
												<%
												if( !routine_name.equals(""))
													out.println("<input type='hidden' name='curr_ds_id' id='curr_ds_id' value=\""+routine_name+"\">") ;
												%>
											</form>
										</body>
									</html>
									<script>
									//if(parent.f_query_add_mod.patient_sub.document.getElementById('patient_group').value != 'N' && '<%=selected_id%>' != "N" && "<%=natcnt%>" > 0  && '<%=deceased_yn%>'=='N')
									//if(parent.f_query_add_mod.patient_sub.document.getElementById('nat_series_loaded').value == 'N' && '<%=selected_id%>' != "N" && "<%=natcnt%>" > 0  && '<%=deceased_yn%>'=='N')
									if((((parent.f_query_add_mod.patient_sub.document.getElementById('nat_series_loaded') && parent.f_query_add_mod.patient_sub.document.getElementById('nat_series_loaded').value == 'N')||parent.f_query_add_mod.patient_sub.document.getElementById('patient_group').value != 'N') && '<%=selected_id%>' != "N" && "<%=natcnt%>" > 0  && '<%=deceased_yn%>'=='N')&& '<%=calledFunction%>'!='ChangePatDtls'){
										if(confirm(getMessage("CONFIRM_NAT_SERIES",'MP'))) {
											parent.frames[1].frames[0].document.getElementById('patient_id').value = '';
											parent.frames[1].frames[0].document.getElementById('patient_id').readOnly = true;
											parent.frames[1].frames[1].document.getElementById('pat_no_gen_yn').value = 'Y';
											if ('<%=from_newBorn%>'=='Y'){
												parent.f_query_add_mod.frames[2].document.getElementById('txtSmartcard_dup').value="1";
											}else{
												parent.f_query_add_mod.patient_sub.document.getElementById('txtSmartcard_dup').value="1";
												
											}
											if(parent.f_query_add_mod.patient_sub.document.getElementById('nat_series_loaded'))
												parent.f_query_add_mod.patient_sub.document.getElementById('nat_series_loaded').value='Y';
											document.construct_nat.submit();
										} else {
											if(parent.f_query_add_mod.patient_sub.document.getElementById('nat_series_loaded'))
												parent.f_query_add_mod.patient_sub.document.getElementById('nat_series_loaded').value='Y';
											//added for Sekure
											if(parent.frames[1].frames[1].document.getElementById('txtSmart_fn_name').value=='02'){
												parent.f_query_add_mod.patient_sub.document.getElementById('txtSmartcard_dup').value="1";
											}
										<%
											if(!routine_name.equals("")) { %>
												document.forms[0].process_id.value=11;
												document.construct_nat.submit();
											<% } %>
										}
									} else { <%
										if(!routine_name.equals("")) { %>
											document.forms[0].process_id.value=11;
											document.construct_nat.submit();
										<% } %>
									} 
							
								</script>  <%
							  }
							} else {
				                if(outArea.equals("W"))
								{
				                   
								   out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body onKeyDown='lockKey()'><script language='javascript'> 	let dialogBody = parent.parent.document.getElementById('dialog-body');   dialogBody.contentWindow.returnValue = 'N"+nat_id_no+"'; const dialogTag = parent.parent.document.getElementById('dialog_tag');     dialogTag.close();</script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></BODY></HTML>");
								}
							    else if(outArea.equals("A"))
								{
					                out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body class='MESSAGE' onKeyDown='lockKey()'><script language='javascript'>parent.f_query_add_mod.patient_sub.document.getElementById('nat_id_val').value ='T';</script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></body></html>");
								}
							}
				            // End of 1
						}
						else
						{
							%>
								<script language='javascript'>
								if(parent.messageFrame)
								 {	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="
								 }
								</script>
								
							
						}
					  }
					 else
					 {
							%>
								<!--Commented below code on 20th Aug 2018 against ML-MMOH-CRF-1177-->
								<!--<script language='javascript'>
								var nric_fn=parent.f_query_add_mod.patient_sub.document.getElementById('txtSmart_fn_name').value;
								if(nric_fn=='02'){
									if(parent.f_query_add_mod.patient_sub.document.getElementById('contact1_new_nat_id_no')){
										var nk_nat_id=parent.f_query_add_mod.patient_sub.document.getElementById('contact1_new_nat_id_no').value;
										if(nk_nat_id!=''){															
											if(parseInt(nk_nat_id.substr(0,2)) > parseInt(parent.f_query_add_mod.patient_sub.document.getElementById('ServerDate').value.substr(8,2))){
												parent.f_query_add_mod.patient_sub.document.getElementById('contact1_birth_date').value=nk_nat_id.substr(4,2)+"/"+nk_nat_id.substr(2,2)+"/19"+nk_nat_id.substr(0,2);												
											}else{
												parent.f_query_add_mod.patient_sub.document.getElementById('contact1_birth_date').value=nk_nat_id.substr(4,2)+"/"+nk_nat_id.substr(2,2)+"/20"+nk_nat_id.substr(0,2);
											}
											if(!ChkDate(parent.f_query_add_mod.patient_sub.document.getElementById('contact1_birth_date'))){
												alert(getMessage("INVALID_DATE_FMT", "SM"));
												parent.f_query_add_mod.patient_sub.document.getElementById('contact1_birth_date').select();
												parent.f_query_add_mod.patient_sub.document.getElementById('contact1_birth_date').focus();
											}
										}
									}
								}-->
								<%/*Added by Thamizh selvi on 2nd Aug 2018 for ML-MMOH-CRF-1177 Start*/
								if(("Y").equals(populateDOBYn)){
									dobJSONObj		= eMP.MPCommonBean.getDOBFrmNationalityId(conn, nat_id_no);
									dateOfBirthNOK	= (String)dobJSONObj.get("dateOfBirth");
									resDOB			= (String)dobJSONObj.get("result");
									errMesg			= (String)dobJSONObj.get("errorMsg");
								}
								%>
								<script>
								if('<%=populateDOBYn%>' == 'Y'){
									if('<%=resDOB%>' == 'TRUE'){
										if('<%=dateOfBirthNOK%>' != '')
											parent.f_query_add_mod.patient_sub.document.getElementById('contact1_birth_date').value='<%=dateOfBirthNOK%>';
										else
											parent.f_query_add_mod.patient_sub.document.getElementById('contact1_birth_date').value='';
									}else if('<%=resDOB%>' == 'FALSE'){
										var msg = getMessage('<%=errMesg%>','MP'); msg = msg.replace('#', parent.f_query_add_mod.patient_sub.document.getElementById('nat_id_prompt').value);alert(msg);
										parent.f_query_add_mod.patient_sub.document.getElementById('contact1_new_nat_id_no').value = "" ;
										parent.f_query_add_mod.patient_sub.document.getElementById('contact1_new_nat_id_no').focus();
									}else{
										alert('<%=errMesg%>');
										parent.f_query_add_mod.patient_sub.document.getElementById('contact1_new_nat_id_no').value = "" ;
										parent.f_query_add_mod.patient_sub.document.getElementById('contact1_new_nat_id_no').focus();
									}
								}/*End*/
								if(parent.messageFrame)
								 {	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="
								 }
								</script>
								
							<%
						}
				    } // End of 2
				    else
					{
//out.println("<script>alert('outArea "+outArea+"')</script>");
						
					    if(outArea.equals("W"))
						{
							    out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body onKeyDown='lockKey()'><center><br><br>"+
							    "  <script>val1 = getMessage('INVALID_NAT_ID','MP'); "+
			                    "val1 = val1.replace('#','"+request.getParameter("nat_id_prompt")+"');"+
						        "document.write(val1)</script>"+
				                "<br><br><center><input type='Button' name='back' id='back' value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Back.label","common_labels")+"' class='Button'  onclick=\"callPrev('N')\" ></center></body></html>");
						}
					    else if(outArea.equals("A"))
						{
							%>
							<html>
								<head>
									<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
								</head>
								<body class='MESSAGE' onKeyDown='lockKey()'>
								<script language='javascript'>
									if ('<%=from_newBorn%>'=='Y')
										frameRef = "parent.f_query_add_mod.frames[2]";
									else
									{
										frameRef = "parent.f_query_add_mod.patient_sub";
										eval(frameRef+".document.getElementById('nat_id_val').value ='F'");
									}
									val1 = eval(frameRef+".getMessage('INVALID_NAT_ID','MP')");
									val1 = val1.replace('#',eval(frameRef+".document.getElementById('nat_id_prompt').value"));
									eval(frameRef).window.alert(val1);
									let natIdElement = frameRef.document.getElementById('<%=nat_id_name%>');
										natIdElement.value = "";
										natIdElement.focus();
								</script>


								</body>
							</html>
							<%
						}
					}
					if(stmt != null) stmt.close();
				} // Second IF-ELSE End
				if(request.getParameter("group").equals("A"))
				{
					String alt_id_no = request.getParameter("alt_id_no");
					out.println(alt_id_no);
					String alt_id_check_digit = request.getParameter("alt_id1_chk_digit_scheme");

					stmt = conn.createStatement();
				    result = "TRUE";
    
				    if(alt_id_check_digit != null)
				    {
				        sql = "select program_name from mp_check_digit_scheme where scheme_id='"+alt_id_check_digit+"'" ;
					    rs = stmt.executeQuery(sql);
					    if(rs.next())
				        {
				            alt_id_check_digit = rs.getString(1);
							if(rs != null)  rs.close();
							sql = "select "+alt_id_check_digit+"('"+alt_id_no+"') from dual";
							rs = stmt.executeQuery(sql);
				            if(rs.next())
				                result = rs.getString(1);
				            if(rs != null)  rs.close();
						}
					}
				    if(rs != null)  rs.close();
				    String alt_unique = request.getParameter("alt_unique") ;
				    if(alt_unique == null) alt_unique = "N" ;
				    if(result.equals("Y") && alt_unique.equals("Y")) // 2
					{
				        stmt = conn.createStatement();
						String duplicateSql = "select patient_id from mp_patient where alt_id1_no = '"+ alt_id_no+"'";
				        stmt = conn.createStatement();
				        rs = stmt.executeQuery(duplicateSql);
						if(rs.next()) // 1
						{
				            out.println("<head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body onKeyDown='lockKey()'><br><br><center><SCRIPT>var val=getMessage('DUP_ALT_ID','MP');val = val.replace('$','"+request.getParameter("alt_id_type")+"');document.writeln(val);</SCRIPT><br><br><input type='Button' class='Button' value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Back.label","common_labels")+"'  name='back' id='back' onclick=\"callPrev('A')\"></center></body></html>");
						}
						else
						{
							if(request.getParameter("routine_chk").equals("Y"))
							{
								String curr_ds_id = request.getParameter("routine_name") ;
								HashMap ret_hash = HealthCardData(conn,curr_ds_id, "alt_id1_no",alt_id_no,out,"") ;            
								if(!ret_hash.isEmpty()) {
				
								out.println("<head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body onKeyDown='lockKey()'><script language='javascript'>	let dialogBody = parent.parent.document.getElementById('dialog-body');    dialogBody.contentWindow.returnValue = 'A" + alt_id_no +"';    const dialogTag = parent.parent.document.getElementById('dialog_tag');    dialogTag.close();</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script></BODY></HTML>");	}								
								else {
									
								out.println("<head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body onKeyDown='lockKey()'><script language='javascript'>	let dialogBody = parent.parent.document.getElementById('dialog-body');   dialogBody.contentWindow.returnValue = 'A" + alt_id_no +"';   const dialogTag = parent.parent.document.getElementById('dialog_tag');  dialogTag.close();   </script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script></BODY></HTML>"); }
							}
							else	{
			
							out.println("<head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body onKeyDown='lockKey()'><script language='javascript'>	let dialogBody = parent.parent.document.getElementById('dialog-body'); dialogBody.contentWindow.returnValue = 'A" + alt_id_no +"'; const dialogTag = parent.parent.document.getElementById('dialog_tag');   dialogTag.close();</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script></BODY></HTML>"); }
						} // End of 2
					}
					else
					{
						
						out.println("<head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body onKeyDown='lockKey()'><script language='javascript'>	let dialogBody = parent.parent.document.getElementById('dialog-body'); dialogBody.contentWindow.returnValue = 'A" + alt_id_no +"';    const dialogTag = parent.parent.document.getElementById('dialog_tag');    dialogTag.close();   </script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script></BODY></HTML>");
					}

					if(stmt != null) stmt.close();
				} // Second IF-ELSE End
			} // END OF 'A' Check
			if(rs != null) rs.close() ;
			if(stmt != null) stmt.close();
			// for smart card
			%>
				<script>
				if ('<%=from_newBorn%>'=='Y'){
					parent.f_query_add_mod.frames[2].document.getElementById('txtSmartcard_dup').value="1";
				}else{
					parent.f_query_add_mod.patient_sub.document.getElementById('txtSmartcard_dup').value="1";
					
				}
				
				</script>
			<%
			// for smart card
	}
		}
		catch(Exception e)
		{ 
			out.println(e);
			e.printStackTrace();
		}
		finally
		{
		     ConnectionManager.returnConnection(conn,request);
		}
		%>
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
		<SCRIPT LANGUAGE="JavaScript">

/*function SpeCharCheck(which) {
//var nat_id_accept_alphanumeric_yn = document.forms[0].nat_id_accept_alphanumeric_yn.value;
		var alt_id1_accept_alphanumeric_yn = document.alt_form.alt_id1_accept_alphanumeric_yn.value;
		
  fldval = which.value;
  fldval = fldval.replace(/^\s+/,""); // strip leading spaces
 if(alt_id1_accept_alphanumeric_yn=='Y')
{
if (/[^-a-z0-9\s]/i.test(fldval)) { // only alphanumeric and space allowed
alert(getMessage("NAT_ID_SPL_NOT_ALLOWED",'MP'));
which.value = "";
which.focus();
return false;
}

}
else
{
if (/[^a-z0-9\s]/i.test(fldval)) { // only alphanumeric and space allowed
alert(getMessage("NAT_ID_SPL_NOT_ALLOWED",'MP'));
which.value = "";
which.focus();
return false;
}
}
}*/
function SpeCharCheck(which) {
    var alt_id1_accept_alphanumeric_yn = document.alt_form.alt_id1_accept_alphanumeric_yn.value;
    var fldval = which.value;
    fldval = fldval.replace(/^\s+/, ""); // strip leading spaces
    if (alt_id1_accept_alphanumeric_yn == 'Y') {
        if (/[^-a-z0-9\s]/i.test(fldval)) { // only alphanumeric and space allowed
            alert(getMessage("NAT_ID_SPL_NOT_ALLOWED", 'MP'));
            which.value = "";
            which.focus();
            return false;
        }
    } else {
        if (/[^a-z0-9\s]/i.test(fldval)) { // only alphanumeric and space allowed
            alert(getMessage("NAT_ID_SPL_NOT_ALLOWED", 'MP'));
            which.value = "";
            which.focus();
            return false;
        }
    }
}
</SCRIPT>

