<!DOCTYPE html>
<%@page import="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="Common.details.label" bundle="${common_labels}"/></title>
		<%
			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src='../../eCA/js/STDCompReferralDetails.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onKeyDown='lockKey()'>
		<form name='refDetailsForm' id='refDetailsForm'>
			<%
				String encounterID = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
				//out.println("<script>alert('"+encounterID+"')</script>");
				String facilityID = (String)session.getValue("facility_id")==null ? "" : (String)session.getValue("facility_id");

				String radBtnVal = request.getParameter("radBtnVal") == null ? "C" : request.getParameter("radBtnVal");

				String hCareDesc = "";
				String referralDesc = "";
				String specilatyDesc = "";
				String referralType = "";
				String locationDesc = "";
				//String locationCode = "";
				String classValue = "";
				int i = 0;

				PreparedStatement pstmt = null;
				ResultSet res = null;
				Connection con = null;				
				
	try
		{
			con = ConnectionManager.getConnection(request);

				if(radBtnVal.equals("C"))
				{
			%>
			<table cellpadding='3' cellspacing='0' border='1' width='100%'>
				<%
					String sql = "select      decode(a.TO_REF_TYPE,'L','Login Facility','E','Enterprise','X','External') ref_type   , d.SHORT_DESC to_hcare_setting_type_desc  , c.SHORT_DESC specialty_desc  , case when a.TO_REF_TYPE='X' then 	(select b.short_desc from am_referral b where b.REFERRAL_CODE=a.to_ref_code)	 when a.TO_REF_TYPE in ('E','L') then	(select facility_name from sm_facility_param where facility_id = a.TO_FACILITY_ID)    end  ref_desc  , case when a.TO_REF_TYPE='X' then a.TO_LOCN_DESC         when a.TO_LOCN_TYPE in ('C','Y','E') then	   (select LONG_DESC from op_clinic where Facility_id=a.TO_FACILITY_ID and clinic_code=a.TO_LOCN_CODE)	when a.TO_LOCN_TYPE in ('N') then	   (select LONG_DESC from ip_nursing_unit where Facility_id=a.TO_FACILITY_ID and Nursing_unit_code=a.TO_LOCN_CODE)    end locn_desc   , a.TO_REF_CODE  , a.TO_HCARE_SETTING_TYPE  , a.TO_LOCN_TYPE  , a.TO_LOCN_CODE  , a.TO_SPECIALITY_CODE from   pr_referral_register a, am_speciality c, am_hcare_setting_type d where     a.FROM_FACILITY_ID=? AND a.FROM_ENCOUNTER_ID = ? and a.TO_HCARE_SETTING_TYPE = d.HCARE_SETTING_TYPE_CODE  and a.TO_SPECIALITY_CODE = c.SPECIALITY_CODE  ";
					
					
					try
					{
						
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1,facilityID);
						pstmt.setString(2,encounterID);
						res = pstmt.executeQuery();
						out.println("<tr>");
						out.println("<td class='columnheadercenter'></td>");
						out.println("<td class='columnheadercenter'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referraltype.label","common_labels")+"</td>");
						out.println("<td class='columnheadercenter'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.HealthcareSettingType.label","common_labels")+"</td>");
						out.println("<td class='columnheadercenter'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referralsource.label","common_labels")+"</td>");
						out.println("<td class='columnheadercenter'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+"</td>");
						out.println("<td class='columnheadercenter'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"</td>");
						out.println("</tr>");
						while(res.next())
						{
							hCareDesc = res.getString("to_hcare_setting_type_desc") == null ? "" : res.getString("to_hcare_setting_type_desc");
							referralDesc = res.getString("ref_desc") == null ? "&nbsp;" : res.getString("ref_desc");
							referralType = res.getString("ref_type") == null ? "&nbsp;" : res.getString("ref_type");
							locationDesc = res.getString("locn_desc") == null ? "&nbsp;" : res.getString("locn_desc");
							specilatyDesc = res.getString("specialty_desc") == null ? "&nbsp;" : res.getString("specialty_desc");

							if(i % 2 == 0)
								classValue = "QRYEVEN";
							else
								classValue = "QRYODD";				
						
							out.println("<tr>");
							out.println("<td class=\""+classValue+"\"><input type=checkbox name='chk"+i+"' id='chk"+i+"'></td>");
							out.println("<td class=\""+classValue+"\" id='tdID1"+i+"' >"+referralType.trim()+"");
							out.println("<td class=\""+classValue+"\" id='tdID2"+i+"'  >"+hCareDesc+"</td>");
							out.println("<td class=\""+classValue+"\" id='tdID3"+i+"' >"+referralDesc+"</td>");
							out.println("<td class=\""+classValue+"\" id='tdID4"+i+"'  >"+specilatyDesc+"</td>");
							out.println("<td class=\""+classValue+"\" id='tdID5"+i+"' >"+locationDesc+"</td>");
							out.println("</tr>");
							i++;
						}
						if(res!=null) res.close();
						if(pstmt!=null) pstmt.close();

					}
					catch(Exception e)
					{
						//out.println("Exception in referralDetails ---"+e.toString());//common-icn-0181
						e.printStackTrace();
					}
									
				%>
			</table>
				<%
				}//if of else - radBtnVal
				else
				{
				%>
				<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
				<%
					//String specialty = "";
					//String hcareSettingType = "";
					//String referralSource = "";

					String sql = "";
					sql = "SELECT hcare_setting_type_code,short_desc FROM am_hcare_setting_type WHERE eff_status='E' ORDER BY 2";
					
					
					out.println("<tr>");
					out.println("<td class='label' width='25%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referraltype.label","common_labels")+"&nbsp;</td>");
					out.println("<td class='fields' width='25%'><select name='referralType' id='referralType' onChange='changeRefSource(this)'>");
					out.println("<option value=''>------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"------</option>");
					out.println("<option value='L'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.loginfacility.label","common_labels")+"</option>");
					out.println("<option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enterprise.label","common_labels")+"</option>");
					out.println("<option value='X'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels")+"</option>");
					out.println("</select></td></tr>");

					try
					{
					
						pstmt = con.prepareStatement(sql);
						res = pstmt.executeQuery();
						out.println("<tr>");
						out.println("<td class='label' width='25%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.HealthcareSettingType.label","common_labels")+" &nbsp;</td>");
						out.println("<td class='fields' width='25%'><select name='healthCareSettingType' id='healthCareSettingType'>");
						out.println("<option value=''>------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"------</option>");
						try
						{
							pstmt = con.prepareStatement(sql);
							res = pstmt.executeQuery();
						
							while(res.next())
							{
								out.println("<option value="+res.getString(1)+"> "+res.getString(2)+" </option>");
							}
							if(res != null) res.close();
							if(pstmt != null) pstmt.close();
							
							out.println("</select></td></tr>");
							sql = "";
						}
						catch(Exception e)
						{
							//out.println("Exception in HCareSettingType Of STDCompReferralDetails.jsp --"+e.toString());//COMMON-ICN-0181
							e.printStackTrace();
						}
						
						out.println("<tr>");
						out.println("<td class = 'label' width='25%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referralsource.label","common_labels")+"</td>");
						out.println("<td class = 'fields' width='25%' ><select name='referralSource' id='referralSource' id='refSource'>");
						out.println("<option value=''>-------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-------</option>");
						
						out.println("</select></td></tr>");
						out.println("<tr>");

						out.println("<td class='label' width='25%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+"</td>");
						out.println("<td class='fields' width='25%'><select name='specialty' id='specialty'	onChange='clear_Locn(this)'>");
						out.println("<option value=''>-------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-------</option>");
						
						sql = "Select Short_Desc,Speciality_Code from Am_Speciality where Eff_Status = 'E' order by 1";

						try
						{	
							pstmt = con.prepareStatement(sql);
							res = pstmt.executeQuery();

							while(res.next())
							{
								out.println("<option value="+res.getString(2)+"> "+res.getString(1)+" </option>");
							}
							if(res != null) res.close();
							if(pstmt != null) pstmt.close();

							sql = "";
							out.println("</select></td></tr>");
						}
						catch(Exception e)
						{
							//out.println("Exception in Specialty of STDCompReferralDetails.jsp --"+e.toString());//common-icn-0181
							e.printStackTrace();
						}
						
						out.println("<tr>");
						out.println("<td class ='label' width='25%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"</td>");
						out.println("<td class ='fields' width='25%'><select name='locationVal' id='locationVal' style='display' onchange='clear_Locn(this);populateLocnVals(this);' > ");
						out.println("<option value=''>-------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-------</option>");
						out.println("</select><select name='locationValues2' id='locationValues2' style='display'><option value=''>-------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-------</option></select><input type='text' name='locnText' id='locnText' style='display:none' size=30 maxlength=30 onBlur = 'makeValidString(this)'></td>");
						out.println("</tr>");
						
					}
					catch(Exception e)
					{
						//out.println("Exception in STDCompReferralDetails.jsp -- else --"+e.toString());//common-icn-0181
						e.printStackTrace();
					}

				}//end of else - radBtnVal
				%>
			<input type='hidden' name='count' id='count' value='<%=i%>'>
			<input type='hidden' name='facility_id' id='facility_id' value='<%=facilityID%>'>
			<input type='hidden' name='encounter_id' id='encounter_id' value='<%=encounterID%>'>
		</form>
	<%
	}
	catch(Exception e)
	{
		//out.println("Exception @ final block STDCompReferralDetails.jsp "+e.toString());//COMMON-ICN-0181
                  e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		if(res != null) res.close();
		if(pstmt != null) pstmt.close();
		if(con != null) ConnectionManager.returnConnection(con,request);
	}
%>
	</body>
</html>

