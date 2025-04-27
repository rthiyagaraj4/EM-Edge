<!DOCTYPE html>
<!-- Last Modified Date Time : 9/23/2005 11:29 AM -->
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
    <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<Script language="JavaScript" src="../../eCommon/js/common.js" ></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body class='message' onKeyDown = 'lockKey()'>
<%
	Connection con = null;
	
	try
	{
		request.setCharacterEncoding("UTF-8");
		String facility_id = (String) session.getValue("facility_id");
		String funcId = request.getParameter("funcId");
		if(funcId == null) funcId = "";
		con = ConnectionManager.getConnection(request);
		boolean pat_exists = false;
		if(funcId.equals("registerPatient"))
		{
			java.sql.Statement stmt1 = null;
			ResultSet rst1  = null;
			stmt1 = con.createStatement();
			String short_desc = "";
			String clinic_code = "";
			String nursing_unit_code = "";
			String wing_code = "";

			String calledFor = request.getParameter("calledFor");
			if(calledFor == null || calledFor.equals("null")) calledFor = "";
		
			if(calledFor.equals("popLocation"))
			{
				String location = request.getParameter("location");
				if(location == null) location = "";
		
				if(location.equals("C"))
				{
					%>
					<SCRIPT>
					var obj = parent.frames[0].document.forms[0].locationValue;
					var len = Math.abs(obj.length);
					for(i=0;i<len;i++) obj.remove(0);
					var opt = parent.frames[0].document.createElement("OPTION");
					opt.text = '---'+getLabel("Common.defaultSelect.label","Common")+'---';
					opt.value = '';
					parent.frames[0].document.forms[0].locationValue.add(opt);
					</SCRIPT>
					<%
					rst1 = stmt1.executeQuery(" SELECT long_desc, clinic_code FROM op_clinic WHERE facility_id = '"+facility_id+"' AND care_locn_type_ind = 'C' AND clinic_type = 'C' AND level_of_care_ind = 'A' AND eff_status = 'E' ORDER BY 1");
				
					if(rst1 != null)
					{ 
						while(rst1.next())
						{ 							
							short_desc = rst1.getString("long_desc");
							clinic_code = rst1.getString("clinic_code");
							if(short_desc == null) short_desc = "";
							if(clinic_code == null) clinic_code = "";
							%>
							<SCRIPT>
								var opt = parent.frames[0].document.createElement("OPTION");
								opt.text = "<%=short_desc%>";
								opt.value = "<%=clinic_code%>";
								parent.frames[0].document.forms[0].locationValue.add(opt);
							</SCRIPT>
							<%
						} 
					}if(rst1 !=null) rst1.close();
				}
				else if(location.equals("E"))
				{
					%>
					<SCRIPT>
					var obj = parent.frames[0].document.forms[0].locationValue;
					var len = Math.abs(obj.length);
					for(i=0;i<len;i++) obj.remove(0);
					var opt = parent.frames[0].document.createElement("OPTION");
					opt.text = '---'+getLabel("Common.defaultSelect.label","Common")+'---';
					opt.value = '';
					parent.frames[0].document.forms[0].locationValue.add(opt);
					</SCRIPT>
					<%
					rst1 = stmt1.executeQuery(" SELECT long_desc, clinic_code FROM op_clinic WHERE facility_id = '"+facility_id+"' AND care_locn_type_ind = 'E' AND clinic_type = 'E' AND level_of_care_ind = 'A' AND eff_status = 'E' ORDER BY 1");
				
					if(rst1 != null)
					{ 
						while(rst1.next())
						{ 
							
							short_desc = rst1.getString("long_desc");
							clinic_code = rst1.getString("clinic_code");
							if(short_desc == null) short_desc = "";
							if(clinic_code == null) clinic_code = "";
							%>
							<SCRIPT>
								var opt = parent.frames[0].document.createElement("OPTION");
								opt.text = "<%=short_desc%>";
								opt.value = "<%=clinic_code%>";
								parent.frames[0].document.forms[0].locationValue.add(opt);
							</SCRIPT>
							<%
						} 
					}if(rst1 !=null) rst1.close();
				}
				else if(location.equals("Y"))
				{
					%>
					<SCRIPT>
					var obj = parent.frames[0].document.forms[0].locationValue;
					var len = Math.abs(obj.length);
					for(i=0;i<len;i++) obj.remove(0);
					var opt = parent.frames[0].document.createElement("OPTION");
					opt.text = '---'+getLabel("Common.defaultSelect.label","Common")+'---';
					opt.value = '';
					parent.frames[0].document.forms[0].locationValue.add(opt);
					</SCRIPT>
					<%
					rst1 = stmt1.executeQuery(" SELECT long_desc, clinic_code FROM op_clinic WHERE facility_id = '"+facility_id+"' AND care_locn_type_ind = 'D' AND clinic_type = 'Y' AND level_of_care_ind = 'A' AND eff_status = 'E' ORDER BY 1");
					
					if(rst1 != null)
					{ 
						while(rst1.next())
						{ 
							
							short_desc = rst1.getString("long_desc");
							clinic_code = rst1.getString("clinic_code");
							if(short_desc == null) short_desc = "";
							if(clinic_code == null) clinic_code = "";
							%>
							<SCRIPT>
								var opt = parent.frames[0].document.createElement("OPTION");
								opt.text = "<%=short_desc%>";
								opt.value = "<%=clinic_code%>";
								parent.frames[0].document.forms[0].locationValue.add(opt);
							</SCRIPT>
							<%
						} 
					}if(rst1 !=null) rst1.close();
				}
				else if(location.equals("N"))
				{ 
					%>
					<SCRIPT>
						var obj = parent.frames[0].document.forms[0].locationValue;
						var len = Math.abs(obj.length);
						for(i=0;i<len;i++) obj.remove(0);
						var opt = parent.frames[0].document.createElement("OPTION");
						opt.text = '---'+getLabel("Common.defaultSelect.label","Common")+'---';
						opt.value = '';
						parent.frames[0].document.forms[0].locationValue.add(opt);
					</SCRIPT>
					<%
					rst1 = stmt1.executeQuery(" SELECT long_desc short_desc, nursing_unit_code FROM ip_nursing_unit_lang_vw WHERE facility_id = '"+facility_id+"' and language_id='"+localeName+"' AND locn_type = 'N' AND patient_class = 'IP' AND eff_status = 'E' ORDER BY 1");
					
					if(rst1 != null)
					{ 
						while(rst1.next())
						{ 
							short_desc = rst1.getString("short_desc");
							nursing_unit_code = rst1.getString("nursing_unit_code");
							if(short_desc == null) short_desc = "";
							if(nursing_unit_code == null) nursing_unit_code = "";
							%>
							<SCRIPT>
								var opt = parent.frames[0].document.createElement("OPTION");
								opt.text = "<%=short_desc%>";
								opt.value = "<%=nursing_unit_code%>";
								parent.frames[0].document.forms[0].locationValue.add(opt);
							</SCRIPT>
							<%
						} 
					}if(rst1 !=null) rst1.close();
				}
				else if(location.equals("W"))
				{ 
					%>
					<SCRIPT>
						var obj = parent.frames[0].document.forms[0].locationValue;
						var len = Math.abs(obj.length);
						for(i=0;i<len;i++) obj.remove(0);
						var opt = parent.frames[0].document.createElement("OPTION");
						opt.text = '---'+getLabel("Common.defaultSelect.label","Common")+'---';
						opt.value = '';
						parent.frames[0].document.forms[0].locationValue.add(opt);
					</SCRIPT>
					<%
					rst1 = stmt1.executeQuery(" SELECT short_desc, wing_code FROM rd_wings WHERE operating_facility_id = '"+facility_id+"' AND int_or_ext = 'I' AND status IS null ORDER BY 1");
					
					if(rst1 != null)
					{ 
						while(rst1.next())
						{ 
							short_desc = rst1.getString("short_desc");
							wing_code = rst1.getString("wing_code");
							if(short_desc == null) short_desc = "";
							if(wing_code == null) wing_code = "";
							%>
							<SCRIPT>
								var opt = parent.frames[0].document.createElement("OPTION");
								opt.text = "<%=short_desc%>";
								opt.value = "<%=wing_code%>";
								parent.frames[0].document.forms[0].locationValue.add(opt);
							</SCRIPT>
							<%
						} 
					}if(rst1 !=null) rst1.close();
				}
				if(stmt1 !=null) stmt1.close();
			}
			else
			{
				String RefVal = "";
				String  refrlAappt = request.getParameter("refrlAappt");
				if(refrlAappt == null) refrlAappt = "";
				String  refIDValue = request.getParameter("refIDValue");
				if(refIDValue == null) refIDValue = "";
				
				

				if(refrlAappt.equals("P"))
				{
				%>
					<script>
					//parent.frames[1].frames[0].document.forms[0].patient_id.value = parent.frames[1].frames[0].document.forms[0].refIDValue.value;

					</script>
					<%
						rst1 = stmt1.executeQuery(" select 'X' from mp_patient where patient_id='"+refIDValue+"'");
					if(rst1 != null && rst1.next())
					{
						pat_exists = true;
	
					} if(rst1 !=null) rst1.close();

					if(!pat_exists)
					{%>
						<script>alert(getMessage("INVALID_PATIENT","MP"));
						parent.frames[1].frames[0].document.forms[0].refIDValue.value='';
						parent.frames[1].frames[0].document.forms[0].refIDValue.focus();
					
					</script>
					<%					
					}
					else
					{
					%>
					
					<script>
					setTimeout("parent.frames[1].frames[0].callResultPage(parent.frames[1].frames[0].document.forms[0].refIDValue.value)",2000);
				//	parent.frames[1].frames[0].callResultPage(parent.frames[1].frames[0].document.forms[0].refIDValue.value);
					</script>
					<%
					}
				}
				else
				{
				if(refrlAappt.equals("A"))
				{

					rst1 = stmt1.executeQuery(" SELECT 1 AS RefVal FROM oa_appt WHERE facility_id  = '"+facility_id+"' AND appt_ref_no = '"+refIDValue+"' AND appt_status = '1' AND trunc(appt_date) >= trunc(sysdate) AND patient_id IS NULL ");
					if(rst1 != null && rst1.next())
					{
						RefVal = rst1.getString("RefVal");
						if(RefVal == null || RefVal.equals("null")) RefVal = "";
					} if(rst1 !=null) rst1.close();
				}
				else if(refrlAappt.equals("L"))
				{
					rst1 = stmt1.executeQuery(" SELECT 1 AS RefVal FROM pr_referral_register WHERE referral_id = '"+refIDValue+"' AND status = 'O' AND to_facility_id = '"+facility_id+"'  AND ( preferred_treatment_date is null or trunc(preferred_treatment_date) >= trunc(sysdate)) AND patient_id IS NULL");
					
					if(rst1 != null && rst1.next())
					{
						RefVal = rst1.getString("RefVal");
						if(RefVal == null || RefVal.equals("null")) RefVal = "";
					} if(rst1 !=null) rst1.close();
				}
				else if(refrlAappt.equals("I"))
				{
					rst1 = stmt1.executeQuery(" SELECT 1 AS RefVal FROM ip_booking_list WHERE bkg_lst_ref_no = '"+refIDValue+"' AND booking_status = '1'  AND facility_id = '"+facility_id+"' AND  trunc(preferred_date) >= trunc(sysdate) AND patient_id IS NULL");
					
					if(rst1 != null && rst1.next())
					{
						RefVal = rst1.getString("RefVal");
						if(RefVal == null || RefVal.equals("null")) RefVal = "";
					} if(rst1 !=null) rst1.close();
				}
				else if(refrlAappt.equals("R"))
				{
					rst1 = stmt1.executeQuery(" SELECT 1 AS RefVal FROM rd_appt WHERE operating_Facility_id = '"+facility_id+"' AND appt_ref_num = '"+refIDValue+"' AND trunc(appt_date) >= trunc(sysdate) AND patient_id IS NULL AND appt_status = '1' ");
					
					if(rst1 != null && rst1.next())
					{
						RefVal = rst1.getString("RefVal");
						if(RefVal == null || RefVal.equals("null")) RefVal = "";
					} if(rst1 !=null) rst1.close();
				}
				if(RefVal.equals("1"))
				{ 
					%>
					<script>
					setTimeout("parent.frames[1].frames[0].callResultPage(parent.frames[1].frames[0].document.forms[0].refIDValue.value)",2000);
					</script>
					<%
				}
				else 
				{	
					%>
					<script>
						var msg = getMessage('INVALID_VALUE','Common');

					if('<%=refrlAappt%>' != 'P')
					{
						if('<%=refrlAappt%>' == 'A')
						{
							msg = msg.replace('#',getLabel("Common.Appt.RefNo.label","common"));
						}
						if('<%=refrlAappt%>' == 'I')
						{
							msg = msg.replace('#',getLabel("Common.BookingRefNo.label","common"));
						}
						if('<%=refrlAappt%>' == 'L')
						{
							msg = msg.replace('#',getLabel("Common.referralid.label","common"));
						}
						if('<%=refrlAappt%>' == 'R')
						{
							msg = msg.replace('#','RD '+getLabel("Common.referralid.label","common"));
						}
						alert(msg);
						parent.frames[1].frames[0].document.forms[0].refIDValue.value = '';
					}
					</script>
					<%
					}
				}
			}
		}
		else
		{
			java.sql.Date current_date = null ;
			String  alt_id_exp_date = request.getParameter("expiry_date") ;
			if (localeName.equals("th"))
			{
					alt_id_exp_date = DateUtils.convertDate(alt_id_exp_date,"DMY","th","en");
			}
			String alt_id_exp_warn_yn = "" ;
			String alt_id_adv_alert_reqd_yn = "";
			int alt_id_adv_alert_days = 0 ;
			int  alt_id_exp_grace_days = 0 ;
			java.util.Date p_alt_id_total_exp_date = null ;
			int  IdNo  = Integer.parseInt(request.getParameter("expdateno")) ;
			int p_alt_id_diff_days = 0;
			java.sql.Date p_alt_id_exp_date1 = null;
			String flag = "true";

			java.sql.Statement stmt = con.createStatement() ;
			ResultSet rset = null ;

			StringBuffer expsql=new StringBuffer("");
						
			if(IdNo == 1) 
			{
				expsql.append("Select alt_id1_exp_warn_yn,alt_id1_exp_grace_days, alt_id1_adv_alert_reqd_yn, nvl(alt_id1_adv_alert_days,0) alt_id_adv_alert_days,to_date('"+alt_id_exp_date+"','dd/mm/yyyy')-trunc(sysdate) p_alt_id_exp_date ,");
			}
			if(IdNo == 2) 
			{
				expsql.append("Select alt_id2_exp_warn_yn,alt_id2_exp_grace_days, alt_id2_adv_alert_reqd_yn, nvl(alt_id2_adv_alert_days,0) alt_id_adv_alert_days,to_date('"+alt_id_exp_date+"','dd/mm/yyyy')-trunc(sysdate) p_alt_id_exp_date ," );
			}
			if(IdNo == 3) 
			{
				expsql.append("Select alt_id3_exp_warn_yn,alt_id3_exp_grace_days, alt_id3_adv_alert_reqd_yn, nvl(alt_id3_adv_alert_days,0) alt_id_adv_alert_days,to_date('"+alt_id_exp_date+"','dd/mm/yyyy')-trunc(sysdate) p_alt_id_exp_date ," );
			}
			if(IdNo == 4 ) 
			{
				expsql.append("Select alt_id4_exp_warn_yn,alt_id4_exp_grace_days, alt_id4_adv_alert_reqd_yn, nvl(alt_id4_adv_alert_days,0) alt_id_adv_alert_days,to_date('"+alt_id_exp_date+"','dd/mm/yyyy')-trunc(sysdate) p_alt_id_exp_date ,") ;
			}
			expsql.append(" trunc(sysdate),to_date( '"+alt_id_exp_date+"','dd/mm/yyyy') from mp_param");
			rset = stmt.executeQuery( expsql.toString());
			if(rset.next()) 
			{
				alt_id_exp_warn_yn=rset.getString(1);if(alt_id_exp_warn_yn==null)alt_id_exp_warn_yn="";
				alt_id_exp_grace_days=rset.getInt(2);
				alt_id_adv_alert_reqd_yn = rset.getString(3);if(alt_id_adv_alert_reqd_yn==null) alt_id_adv_alert_reqd_yn="";
				alt_id_adv_alert_days = rset.getInt(4);
				p_alt_id_diff_days = rset.getInt(5);
				current_date=rset.getDate(6);
				p_alt_id_exp_date1 = rset.getDate(7);
			}
			if((expsql != null) && (expsql.length()> 0))
			{
				expsql.delete(0,expsql.length());
			}
			if(alt_id_exp_warn_yn.equals("Y"))
			{
				p_alt_id_total_exp_date=new java.util.Date(p_alt_id_exp_date1.getTime());
				p_alt_id_total_exp_date.setDate(p_alt_id_exp_date1.getDate()+alt_id_exp_grace_days);   
				if((p_alt_id_exp_date1.compareTo(current_date))< 0)
				{
					if((p_alt_id_total_exp_date.compareTo(current_date))< 0)
					{
						flag="false";
					}
					else
					{
						%>
						<script>
					    	msg = parent.f_query_add_mod.patient_sub.getMessage("ALT_ID_EXP_WITH_GRACE",'MP')
							if('<%=IdNo%>'== 1)
							{
								msg = msg.replace('$',parent.f_query_add_mod.patient_sub.document.getElementById('altId1Desc').value)
								//msg = msg.replace('$',"HC.Expiry")
							}
							else if('<%=IdNo%>'== 2)
							{
								msg = msg.replace('$',parent.f_query_add_mod.patient_sub.document.getElementById('altId2Desc').value)
							}
							else if('<%=IdNo%>'== 3)
							{
								msg = msg.replace('$',parent.f_query_add_mod.patient_sub.document.getElementById('altId3Desc').value)
							}
							else if('<%=IdNo%>'== 4)
							{
								msg = msg.replace('$',parent.f_query_add_mod.patient_sub.document.getElementById('altId4Desc').value)
							}
							alert(msg);
							if('<%=IdNo%>'== 1)
							{
								parent.f_query_add_mod.patient_sub.document.getElementById('alt_id2_no').focus();
							}
							else if('<%=IdNo%>'== 2)
							{
								parent.f_query_add_mod.patient_sub.document.getElementById('alt_id3_no').focus();
							}
							else if('<%=IdNo%>'== 3)
							{
								parent.f_query_add_mod.patient_sub.document.getElementById('alt_id4_no').focus();
							}
							else if('<%=IdNo%>'== 4)
							{
								parent.f_query_add_mod.patient_sub.document.getElementById('family_link_no').focus();
							}	

						</script>
						<%
					}
				}
			}
				
			if(alt_id_adv_alert_reqd_yn.equals("Y"))
			{
				if((p_alt_id_exp_date1.compareTo(current_date))> 0)
				{
					if (p_alt_id_diff_days > 0) 
					{
						if ( p_alt_id_diff_days <= alt_id_adv_alert_days)
						{
							%>
							<script>
								var alt_days = '<%=alt_id_adv_alert_days%>';
								var p_alt_id_diff_days = '<%=p_alt_id_diff_days%>';
								//alert(parent.f_query_add_mod.patient_sub.getMessage("ALT_ID_EXP_WITHIN")+alt_days+' days');
								msg = parent.f_query_add_mod.patient_sub.getMessage("ALT_ID_EXP_WITHIN",'MP')
								if('<%=IdNo%>'== 1)
								{
									msg = msg.replace('$',parent.f_query_add_mod.patient_sub.document.getElementById('altId1Desc').value)
									//msg = msg.replace('$','HC.Expiry')
								}
								else if('<%=IdNo%>'== 2)
								{
									msg = msg.replace('$',parent.f_query_add_mod.patient_sub.document.getElementById('altId2Desc').value)
								}
								else if('<%=IdNo%>'== 3)
								{
									msg = msg.replace('$',parent.f_query_add_mod.patient_sub.document.getElementById('altId3Desc').value)
								}
								else if('<%=IdNo%>'== 4)
								{
									msg = msg.replace('$',parent.f_query_add_mod.patient_sub.document.getElementById('altId4Desc').value)
								}
								alert( (msg +" "+p_alt_id_diff_days+' days') );
								location.href = '../../eCommon/jsp/error.jsp'
							</script>
							<%
						}
					}
				}
			}
			if(flag.equals("false"))
			{
				%>
				<script>
					msg = parent.f_query_add_mod.patient_sub.getMessage('ALT_ID_EXPIRED','MP')
					var eval_txts= "";
					if('<%=IdNo%>'== 1)
					{
						eval_txts = "parent.f_query_add_mod.patient_sub.document.getElementById('alt_id1_exp_date').focus();"+"parent.f_query_add_mod.patient_sub.document.getElementById('alt_id1_exp_date').select();"
						msg = msg.replace('$',parent.f_query_add_mod.patient_sub.document.getElementById('altId1Desc').value)
						//msg = msg.replace('$','HC.Expiry')
					}
					else if('<%=IdNo%>'== 2)
					{
						eval_txts = "parent.f_query_add_mod.patient_sub.document.getElementById('alt_id2_exp_date').focus();"+"parent.f_query_add_mod.patient_sub.document.getElementById('alt_id2_exp_date').select();"
						msg = msg.replace('$',parent.f_query_add_mod.patient_sub.document.getElementById('altId2Desc').value)
					}
					else if('<%=IdNo%>'== 3)
					{
						eval_txts = "parent.f_query_add_mod.patient_sub.document.getElementById('alt_id3_exp_date').focus();"+"parent.f_query_add_mod.patient_sub.document.getElementById('alt_id3_exp_date').select();"
						msg = msg.replace('$',parent.f_query_add_mod.patient_sub.document.getElementById('altId3Desc').value)
					}
					else if('<%=IdNo%>'== 4)
					{
						eval_txts = "parent.f_query_add_mod.patient_sub.document.getElementById('alt_id1_exp_date').focus();"+
						"parent.f_query_add_mod.patient_sub.document.getElementById('alt_id1_exp_date').select();"
						msg = msg.replace('$',parent.f_query_add_mod.patient_sub.document.getElementById('altId4Desc').value)
					}
					alert(msg);
					//Commented by kumar on 15/10/2002 for displaying Expired as Warning always.
					//eval(eval_txts)
				</script>
				<%
			}
			if(rset != null) rset.close();
			if(stmt != null) stmt.close();
		}
	}catch(Exception e) { out.println(e.toString());}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
	%>
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" : inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

