<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*" %>
<%	request.setCharacterEncoding("UTF-8");	%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<%          
	Connection conn = null;           
	PreparedStatement pstmt = null;
	ResultSet rs =null;
	StringBuffer sql1=new StringBuffer();
	//String oper_stn_id="";
	String locncode="";
	String locndesc="";
	String locale=(String)session.getAttribute("LOCALE"); 

	try{
         out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE'  onKeyDown='lockKey();'><form name='nam1' id='nam1'>");

         String facilityid=(String)session.getValue("facility_id");	
		// String userid           = (String) session.getValue("login_user");
		 String locntype=request.getParameter("locn_type");
		 locncode=request.getParameter("locn_code");
		 if(locncode == null) locncode = "";		 
		
	 	 String callvalue=request.getParameter("callval");
		 String locn_ind=request.getParameter("locn_ind");
		 if(locn_ind == null) locn_ind="";
		 
		  String enc_locn_type=request.getParameter("enc_locn_type");
		  if(enc_locn_type == null) enc_locn_type="";
		  String enc_locn_code=request.getParameter("enc_locn_code");
		  if(enc_locn_code == null) enc_locn_code="";
			 

 		 conn=ConnectionManager.getConnection(request);
			
		/* pstmt=conn.prepareStatement("select oper_stn_id from am_user_for_oper_stn where facility_id=? and appl_user_id=? and trunc(sysdate) between trunc(eff_date_from) and trunc(nvl(eff_date_to,sysdate))");

		 pstmt.setString(1,facilityid);
		 pstmt.setString(2,userid);		
		 rs=pstmt.executeQuery();
			if(rs != null)
				{
					while(rs.next())
					{
						oper_stn_id=rs.getString(1);
					}
				}

				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();*/
				%>
					
				<%

		

		  
		  if(locn_ind.equals("N"))
			{

				 //sql1.append("Select  a.nursing_unit_code id ,a.short_desc dat from ip_nursing_unit a  where a.facility_id = '"+facilityid+"' and a.eff_status = 'E' and a.locn_type='"+locntype+"' and a.appl_patient_class = 'IP' ");

				 sql1.append("Select a.nursing_unit_code id ,a.LONG_DESC dat from ip_nursing_unit_lang_vw a  where language_id='"+locale+"' and a.facility_id = '"+facilityid+"' and a.eff_status = 'E' and a.locn_type='"+locntype+"' and a.patient_class = 'IP' ");	

				 if(callvalue.equals("Departed") && !locncode.equals(""))
				{
						sql1.append(" and a.nursing_unit_code != '"+locncode+"'");
				}

				 sql1.append(" order by 2");				 
			}
		else if(locn_ind.equals("R"))
			{
				//sql1.append("Select Room_num Clinic_code, Short_desc from AM_FACILITY_ROOM ");
				//sql1.append("where eff_status = 'E' and operating_facility_id = '"+facilityid+"' and room_type = '"+locntype+"' order by 2");
				sql1.append("Select Room_num Clinic_code, Short_desc from AM_FACILITY_ROOM_lang_vw ");				
				sql1.append("where language_id='"+locale+"' AND eff_status = 'E' and operating_facility_id = '"+facilityid+"' and room_type = '"+locntype+"' order by 2");
			}
			else
			{
				/*sql1.append("select clinic_code,short_desc from op_clinic a");
				sql1.append(" where eff_status='E' ");
				sql1.append("and upper(clinic_type) in (select locn_type from am_care_locn_type where locn_type='"+locntype+"') and facility_id='"+facilityid+"' and (facility_id, clinic_type, clinic_code) in (select facility_id, locn_type, locn_code from am_locn_for_oper_stn where facility_id ='"+facilityid+"' ");
				sql1.append("and oper_stn_id ='"+oper_stn_id+"' )");*/
             sql1.append("select clinic_code,long_desc from op_clinic_lang_vw a where facility_id='"+facilityid+"' and language_id='"+locale+"' AND eff_status='E' and clinic_type = '"+locntype+"'"); 
							  
			//	sql1.append("select clinic_code,short_desc from op_clinic_lang_vw a where language_id='"+locale+"' AND eff_status='E' and upper(clinic_type) in (select locn_type from am_care_locn_type where locn_type='"+locntype+"') and facility_id='"+facilityid+"' and (facility_id, clinic_type, clinic_code) in (select facility_id, locn_type, locn_code from am_locn_for_oper_stn where facility_id ='"+facilityid+"' and oper_stn_id ='"+oper_stn_id+"')");

				if(callvalue.equals("Departed") && !locncode.equals(""))
				{
						sql1.append(" and a.clinic_code != '"+locncode+"'");
				}
				sql1.append(" order by 2");
			}
				
				
				pstmt=conn.prepareStatement(sql1.toString());
				rs=pstmt.executeQuery();				
				if(rs != null)
				{
					while(rs.next())
					{
						locncode=rs.getString(1);
						locndesc=rs.getString(2);
						
						
						%>
							<script>
							tp ="<%=locndesc%>";						
							tpval="<%=locncode%>"; 
							var opt;
							<%
						if(callvalue.equals("Criteria"))
						{
							%>
							 var opt=parent.document.frames[1].document.frames[1].document.createElement("OPTION");
							<%
						}
						else
						{%>
							var opt=parent.document.frames[1].document.createElement("OPTION");
								<%
						}
							%>
							opt.text=tp;
							opt.value=tpval;  
							<%
						if(callvalue.equals("Criteria"))
						{
							%>
							parent.document.frames[1].document.frames[1].document.forms[0].location_code.add(opt);  
							<%
						}
							else if(callvalue.equals("Departed"))
						{%>
							parent.document.frames[1].document.forms[0].location_code1.add(opt);
								<%
					if(enc_locn_type.equals(locntype))	
				    {%>
					  parent.document.frames[1].document.forms[0].location_code1.value="<%=enc_locn_code%>";
					//parent.document.frames[1].document.forms[0].location_code1.disabled=true;
					<%}
				 }
								%>
							</script>     
							<%
					}
				}

				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();

    }catch(Exception e) { 
		e.printStackTrace();
		}
    
	finally
    {
      if(conn!=null) ConnectionManager.returnConnection(conn,request);
    }
    out.println("</form></body></html>");       
                            
%>          
            
            

