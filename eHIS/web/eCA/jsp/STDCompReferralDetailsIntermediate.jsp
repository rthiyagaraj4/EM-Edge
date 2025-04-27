<!DOCTYPE html>
<%@page import='java.sql.*,java.util.*,webbeans.eCommon.*' contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");

	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get( "SEARCH" ) ;
	String listVal	= (String)hash.get("listVal");
	if(listVal == null)
		listVal = "L";
	String specialty	= (String)hash.get("specialty");
	if(specialty == null)
		specialty = "";
	String location_type	= (String)hash.get("location_type");
	if(location_type == null)
		location_type = "";

	String calledFrom = request.getParameter("called_from") == null ? "" : request.getParameter("called_from");
	String facilityID = (String)session.getValue("facility_id")==null ? "" : (String)session.getValue("facility_id");

	PreparedStatement pstmt = null;
	ResultSet res = null;
	PreparedStatement pstatmnt = null;
	ResultSet resultset = null;

	Connection con = null; 

	String sql = "";
	String sqlLocn = "";
	String locationCode = "";
	String locationDesc = "";

	try
	{
		con = ConnectionManager.getConnection(request);

		if(calledFrom.equals("refSource"))
		{
			if(listVal.equals("L"))
			{
				sql = "select a.FACILITY_NAME referred_to_id_desc ,a.FACILITY_ID referred_to_id  from sm_facility_param a, am_hcare_setting_type b where a.hcare_setting_type_code=b.hcare_setting_type_code and a.hcare_setting_type_code in ( select to_hcare_setting_type_code from am_hcare_setting_type_rstrn where from_hcare_setting_type_code = (select hcare_setting_type_code from sm_facility_param where facility_id = ? ) and (ip_referral_yn = 'Y'  or op_referral_yn = 'Y') ) order by a.facility_name";
			}
			else if(listVal.equals("E"))
			{
				sql ="select facility_name from sm_facility_param where facility_id = ? ";
			}
			else if(listVal.equals("X"))
			{
				sql = "Select a.SHORT_DESC referred_to_id_desc, a.REFERRAL_CODE referred_to_id from am_referral a, am_hcare_setting_type b where a.healthcare_setting_type = b.hcare_setting_type_code and nvl(a.dest_use_at_concl_yn,'N') = 'Y' and a.eff_status = 'E' order by a.short_desc";
			}
				
			try
			{
				pstmt = con.prepareStatement(sql);
				if(!listVal.equals("X"))
				{
					pstmt.setString(1,facilityID);
				}

				res = pstmt.executeQuery();

				while(res.next())
				{
					out.println("var selObj = parent.detailsFrame.document.createElement(\"OPTION\")");

					if(!listVal.equals("E"))
					{
						out.println("selObj.value = \""+res.getString(2)+"\"");
					}
					else
					{
						out.println("selObj.value = \""+facilityID+"\"");
					}
					out.println("selObj.text = \""+res.getString(1)+"\"");	
					out.println("parent.detailsFrame.document.refDetailsForm.referralSource.add(selObj);");
				}
					
				if(res != null) res.close();
				if(pstmt != null) pstmt.close();

				if(!listVal.equals("X"))
				{
					int ip=0;
					int op=0;

					StringBuffer sqlBuff = new StringBuffer();

					sqlLocn = "select count(distinct decode(ip_referral_yn,'N',null,ip_referral_yn) ) ip, count(distinct decode(op_referral_yn,'N',null,op_referral_yn) ) op from am_hcare_setting_type_rstrn where from_hcare_setting_type_code= (select hcare_setting_type_code from sm_facility_param where facility_id = ? ) and (ip_referral_yn='Y' or op_referral_yn = 'Y') ";  

					try
					{
						pstmt=con.prepareStatement(sqlLocn);
						pstmt.setString(1,facilityID);
						res = pstmt.executeQuery();

						while(res.next())
						{
							ip= res.getInt("ip");
							op= res.getInt("op");
						}
						if(res != null) res.close();
						if(pstmt != null) pstmt.close();

						sqlBuff.append("select locn_type,short_desc from am_care_locn_type where care_locn_type_ind in (");
						
						if (op>0)
						{
							sqlBuff.append("'C',");
						}
						sqlBuff.append("'E','D'");
						if(ip>0)
						{
						  sqlBuff.append(",'N'");
						}
						sqlBuff.append(") and locn_type in(");
						if(op>0)
						{
						  sqlBuff.append("'C',");
						}
						sqlBuff.append("'E','Y' ");
						if(ip>0)
						{
						  sqlBuff.append(",'N'");
						}
						sqlBuff.append(" ) and sys_user_def_ind='S' order by 2");

						pstatmnt = con.prepareStatement(sqlBuff.toString());
						resultset = pstatmnt.executeQuery();

						while(resultset.next())
						{
							locationCode = resultset.getString("locn_type")==null?"":resultset.getString("locn_type");
							locationDesc = resultset.getString("short_desc")==null?"":resultset.getString("short_desc");
							out.println("var selObj = parent.detailsFrame.document.createElement(\"OPTION\")");
							out.println("selObj.value = \""+locationCode+"\"");
							out.println("selObj.text = \""+locationDesc+"\"");	
							out.println("parent.detailsFrame.document.refDetailsForm.locationVal.add(selObj);");
						}
						if(resultset != null) resultset.close();
						if(pstatmnt != null) pstatmnt.close();
					}
					catch(Exception e)
					{
						
						e.printStackTrace();
					}
				}
				else
				{
					out.println("parent.detailsFrame.document.refDetailsForm.locnText.style.display='inline';");
					out.println("parent.detailsFrame.document.refDetailsForm.locationVal.style.display='none';");
					out.println("parent.detailsFrame.document.refDetailsForm.locationValues2.style.display='none';");
				}
			}
			catch(Exception e)
			{
				
				e.printStackTrace();
			}
		}
		else if(calledFrom.equals("popuLocn"))
		{
			try
			{
				if(listVal.equals("L") || listVal.equals("E"))
				{
					if(location_type.equals("C"))
					{
						sql = "Select short_desc dat, clinic_code id from op_clinic where facility_id = ? and CARE_LOCN_TYPE_IND= 'C' and allow_visit_regn_yn = 'Y' and eff_status = 'E'  and speciality_code = ? and clinic_type='C'  order by 1";
					}
					else if(location_type.equals("N"))
					{
						sql="Select a.short_desc dat, a.nursing_unit_code id from ip_nursing_unit a, ip_nurs_unit_for_specialty b  where a.facility_id = ? and a.eff_status = 'E' and  a.nursing_unit_code = b.nursing_unit_code and locn_type='N' and appl_patient_class = 'IP' and a.facility_id = b.facility_id and b.specialty_code = ? order by 1";
					}
					else if(location_type.equals("Y"))
					{
						sql="Select short_desc dat, clinic_code id, open_to_all_pract_yn from op_clinic where facility_id = ? and CARE_LOCN_TYPE_IND='D' and allow_visit_regn_yn = 'Y' and eff_status = 'E'  and speciality_code = ? and clinic_type='Y'  order by 1 ";
					}
					else if(location_type.equals("E"))
					{
						sql="Select short_desc dat, clinic_code id, open_to_all_pract_yn from op_clinic where facility_id = ? and CARE_LOCN_TYPE_IND='E' and allow_visit_regn_yn = 'Y' and eff_status = 'E'  and speciality_code = ?  order by 1 "; 
					}
					else if(location_type.equals("W"))
					{
						sql="SELECT  SHORT_DESC dat,WING_CODE id, 'N' open_to_all_pract_yn FROM RD_WINGS WHERE  OPERATING_FACILITY_ID  = ? AND INT_OR_EXT= 'I' AND STATUS IS NULL";
					}	

					pstmt = con.prepareStatement(sql);
					
					if(location_type.equals("W"))
					{
						pstmt.setString(1,facilityID);
					}
					else
					{
						pstmt.setString(1,facilityID);
						pstmt.setString(2,specialty);
					}
	
					res = pstmt.executeQuery();
					
					while(res.next())
					{
						/***********modified by Deepa on 8/19/2009 at 4:34 PM for the incident IN013582 ******/
						//locationCode = res.getString("clinic_code")==null?"":res.getString("clinic_code");
						//locationDesc = res.getString("short_desc")==null?"":res.getString("short_desc");

						locationCode = res.getString("id")==null?"":res.getString("id");
						locationDesc = res.getString("dat")==null?"":res.getString("dat");
						/***********modified by Deepa on 8/19/2009 at 4:34 PM for the incident IN013582 ******/

						out.println("var selObj = parent.detailsFrame.document.createElement(\"OPTION\")");
						out.println("selObj.value = \""+locationCode+"\"");
						out.println("selObj.text = \""+locationDesc+"\"");	
						out.println("parent.detailsFrame.document.refDetailsForm.locationValues2.add(selObj)");
					}

					if(res!=null) res.close();
					if(pstmt!=null) pstmt.close();
				}
			}
			catch(Exception e)
			{
				
				e.printStackTrace();
			}
		}
	
	}
	catch(Exception e)
	{
		e.printStackTrace() ;		
	}
	finally
	{
		if(con!=null)
		ConnectionManager.returnConnection(con,request);
	}
	%>
