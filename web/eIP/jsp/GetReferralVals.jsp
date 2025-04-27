<!DOCTYPE html>
<!-- Same coding from GetCheckoutVals.jsp -->
<%@ page  contentType="text/html;charset=UTF-8"  import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
    <head>
        <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
        <script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
        <script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
			request.setCharacterEncoding("UTF-8"); 
            Connection con=null;
	        Statement stmt=null;
			Statement stmt_pract=null;
			Statement stmt_loc=null;
			Statement stmt_loc1=null;
            ResultSet rs=null;
			ResultSet rs_pract=null;
			ResultSet rs_speciality=null;
			ResultSet rs_loc=null;
			ResultSet rs_loc1=null;

            try{
            con = ConnectionManager.getConnection(request);

            String facility_id= (String) session.getValue( "facility_id" ) ;
            String ref_type=request.getParameter("ref_type");
            if(ref_type==null) ref_type="";
            
			String pract_id=request.getParameter("pract_id");
            if(pract_id==null) pract_id="";
	        String loc_type=request.getParameter("loc_type");
            if(loc_type==null) loc_type="";
            String ref_to=request.getParameter("ref_to");
            if(ref_to==null) ref_to="";
            String location1=request.getParameter("location1");
            if(location1==null) location1="";

            String sql="";
            String sql_loc="";
			StringBuffer sql_loc1 = new StringBuffer();
            String sql_pract="";
			String org_type="";
			String org_type_desc="";
            
            String referred_to_id=request.getParameter("referred_to_id");
            if(referred_to_id==null) referred_to_id="";
            String referred_to_desc=request.getParameter("referred_to_desc");
            if(referred_to_desc==null) referred_to_desc="";
            String loc0=request.getParameter("loc0");
            if(loc0==null) loc0="";
            String src1=request.getParameter("src1");
			if(src1 == null) src1 = "";
			String speciality_val = request.getParameter("speciality_val"); 
			if (speciality_val == null ) speciality_val = "";
            String specialty=request.getParameter("specialty");
			if (specialty == null ) specialty = "";
            String service=request.getParameter("service");
			if (service == null ) service = "";
            String jsp_val=request.getParameter("jsp_val");
			if (jsp_val == null ) jsp_val = "";

            String referredtoid="";
            String referredtodesc="";
            String hcare_setting_type_desc="";
            String hcare_setting_type="";
            String clinicid="";
            String clinicdesc="";
            String open_to_all_pract_yn="";

            String practitioner_id="";
            String practitioner_name="";

            int ip=0;
            int op=0;
            
			//added on 15-11-2003 by dhanasekaran
			sql="SELECT Nvl(org_type, ' ') as org_type FROM am_referral WHERE referral_code='"+referred_to_id+"'";

            stmt=con.createStatement();
            rs=stmt.executeQuery(sql);
            
            if(rs.next())
            {
               org_type=rs.getString("org_type").trim();
			}
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(ref_type.equals("X") && src1.equals("6"))
			{
				if(org_type.equals("G") || org_type.length() == 0 || org_type==null) org_type_desc="<b>Government</b>";
				if(org_type.equals("P")) org_type_desc="<b>Private</b>";
			}
			
			if(ref_type.equals("E") || ref_type.equals("L"))
			{
				org_type_desc="<b>Government</b>";
			}
%>
			<script>										
if(parent.document.frames[1].document.getElementById('org_type')) 
parent.document.frames[1].document.getElementById('org_type').innerHTML="<%=org_type_desc%>"; 
				</script>

<%  		//end addition
		if(src1.equals("1"))
        {
			 String hcare_type_code = request.getParameter("hcare_type");
			 if(hcare_type_code==null) ref_type="";
			
            if(ref_type.equals("X"))
            {
				if (!hcare_type_code.equals(""))
				{
                sql="Select a.SHORT_DESC referred_to_id_desc, a.REFERRAL_CODE referred_to_id, a.healthcare_setting_type hcare_setting_type, b.short_desc hcare_setting_type_desc from am_referral a, am_hcare_setting_type b where a.healthcare_setting_type = b.hcare_setting_type_code and nvl(a.dest_use_at_disch_yn,'N') = 'Y' and a.eff_status = 'E' and  a.healthcare_setting_type='"+hcare_type_code+"' order by a.short_desc ";        
				}
				else
				{
                sql="Select a.SHORT_DESC referred_to_id_desc, a.REFERRAL_CODE referred_to_id, a.healthcare_setting_type hcare_setting_type, b.short_desc hcare_setting_type_desc from am_referral a, am_hcare_setting_type b where a.healthcare_setting_type = b.hcare_setting_type_code and nvl(a.dest_use_at_concl_yn,'N') = 'Y' and a.eff_status = 'E' order by a.short_desc ";        
				}
            stmt=con.createStatement();
            rs=stmt.executeQuery(sql);
            if(rs!=null)
            {
                while(rs.next())
                {
                    referredtoid			=	rs.getString("referred_to_id");
                    referredtodesc			=	rs.getString("referred_to_id_desc");
                    hcare_setting_type_desc	=	rs.getString("hcare_setting_type_desc");
                    hcare_setting_type		=	rs.getString("hcare_setting_type");
                %>
                <script>
                        var temp = "<%=referredtoid%>";
                        var temp1="<%=referredtodesc%>";
						var jsp_val = "<%=jsp_val%>";
                        var hcare_setting_type_desc="<%=hcare_setting_type_desc%>";
                        var hcare_setting_type="<%=hcare_setting_type%>";
                        var opt=parent.document.frames[1].document.createElement("OPTION");
                        opt.text=temp1;
	                    opt.value=temp;
						if (jsp_val != "")
						{
							var ref_code = parent.document.frames[1].document.forms[0].ref_code.value;
							if (ref_code == temp)
								opt.selected=true;
						}
                        <%if(referred_to_id.equals(referredtoid) ) {%>
                            opt.selected=true;
                        <%} %>
                        
                        parent.document.frames[1].document.forms[0].referred_to.add(opt);
                        parent.document.frames[1].document.forms[0].hcare_setting_type.value=hcare_setting_type;
                        parent.document.frames[1].document.forms[0].hcare_setting_type_desc.value=hcare_setting_type_desc;
                </script>
            <%
                }
            }
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
            %>
            <script>
            </script>
            <%
            }
            else if(ref_type.equals("E") || ref_type.equals("L"))
            {
				if(ref_type.equals("E"))
				{
					if (!hcare_type_code.equals(""))
					{
                sql="select a.FACILITY_ID referred_to_id,a.FACILITY_NAME referred_to_id_desc ,a.hcare_setting_type_code hcare_setting_type_code, b.short_desc  hcare_setting_type_desc from sm_facility_param a, am_hcare_setting_type b where a.facility_id != '"+facility_id+"' and  a.hcare_setting_type_code='"+hcare_type_code+"' and a.hcare_setting_type_code=b.hcare_setting_type_code and a.hcare_setting_type_code in ( select to_hcare_setting_type_code from am_hcare_setting_type_rstrn where from_hcare_setting_type_code = (select hcare_setting_type_code from sm_facility_param where facility_id = '"+facility_id+"' ) and (ip_referral_yn = 'Y'  or op_referral_yn = 'Y') ) order by a.facility_name ";	
					}
					else
					{
                sql="select a.FACILITY_ID referred_to_id,a.FACILITY_NAME referred_to_id_desc ,a.hcare_setting_type_code hcare_setting_type_code, b.short_desc  hcare_setting_type_desc from sm_facility_param a, am_hcare_setting_type b where a.facility_id != '"+facility_id+"' and a.hcare_setting_type_code=b.hcare_setting_type_code and a.hcare_setting_type_code in ( select to_hcare_setting_type_code from am_hcare_setting_type_rstrn where from_hcare_setting_type_code = (select hcare_setting_type_code from sm_facility_param where facility_id = '"+facility_id+"' ) and (ip_referral_yn = 'Y'  or op_referral_yn = 'Y') ) order by a.facility_name ";	
					}
				}
				else if(ref_type.equals("L"))
				{
                sql="select a.FACILITY_ID referred_to_id,a.FACILITY_NAME referred_to_id_desc ,a.hcare_setting_type_code hcare_setting_type_code, b.short_desc  hcare_setting_type_desc from sm_facility_param a, am_hcare_setting_type b where a.facility_id = '"+facility_id+"' and a.hcare_setting_type_code=b.hcare_setting_type_code and a.hcare_setting_type_code in ( select to_hcare_setting_type_code from am_hcare_setting_type_rstrn where from_hcare_setting_type_code = (select hcare_setting_type_code from sm_facility_param where facility_id = '"+facility_id+"' ) and (ip_referral_yn = 'Y'  or op_referral_yn = 'Y') ) order by a.facility_name ";	
				}

				stmt=con.createStatement();
                rs=stmt.executeQuery(sql);
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
							var ref_type = "<%=ref_type%>";
                            var temp = "<%=referredtoid%>";
                            var temp1="<%=referredtodesc%>";
							var jsp_val = "<%=jsp_val%>";

	                            var hcare_setting_type_desc="<%=hcare_setting_type_desc%>";
		                        var hcare_setting_type="<%=hcare_setting_type%>";
                            var opt3=parent.document.frames[1].document.createElement("OPTION");

                            opt3.text=temp1;
                            opt3.value=temp;
							if (jsp_val != "")
							{
								var ref_code = parent.document.frames[1].document.forms[0].referral_type.value;
								if (ref_code == temp)
								opt3.selected=true;
							}

                            <%if(referred_to_id.equals(referredtoid) || ref_type.equals("L") || ref_type.equals("E")) {%>
                                opt3.selected=true;
                            <%} %>
                            
                            parent.document.frames[1].document.forms[0].referred_to.add(opt3);
							parent.document.frames[1].document.forms[0].hcare_setting_type.value=hcare_setting_type;
                            parent.document.frames[1].document.forms[0].hcare_setting_type_desc.value=hcare_setting_type_desc;
							//}
                    </script>
                <%
                    }
                }
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();

				sql_loc="select count(distinct decode(ip_referral_yn,'N',null,ip_referral_yn) ) ip, count(distinct           decode(op_referral_yn,'N',null,op_referral_yn) ) op from am_hcare_setting_type_rstrn where from_hcare_setting_type_code= (select hcare_setting_type_code from sm_facility_param where facility_id = '"+facility_id+"' ) and (ip_referral_yn='Y' or op_referral_yn = 'Y') ";
                stmt_loc=con.createStatement();
                rs_loc=stmt_loc.executeQuery(sql_loc);
                if(rs_loc!=null)
                {
                    if (rs_loc.next())
                    {
                        ip=rs_loc.getInt(1);
                        op=rs_loc.getInt(2);
                    }
                }
                        if (ip> 0 )
                        {
							if (ref_type.equals("L") && op > 0)
							{
%>							<script>
							var jsp_val = "<%=jsp_val%>";
							if (jsp_val != "")
							var locn_type_value = parent.document.frames[1].document.forms[0].locn_type_val.value;
							opt=parent.document.frames[1].document.createElement("OPTION");
                            opt.text="Nursing Unit";
                            opt.value="N";
							if (jsp_val != "")
							if (locn_type_value == "N")
	                           opt.selected=true;
                            parent.document.frames[1].document.forms[0].location0.add(opt);
                            parent.document.frames[1].location0_array[parent.document.frames[1].location0_array.length] = opt
                            opt=parent.document.frames[1].document.createElement("OPTION");
                            opt.text="Clinic";
                            opt.value="C";
							if (jsp_val != "")
							if (locn_type_value=="C")
	                            opt.selected=true;
                            parent.document.frames[1].document.forms[0].location0.add(opt);
                            parent.document.frames[1].location0_array[parent.document.frames[1].location0_array.length] = opt;
                            opt=parent.document.frames[1].document.createElement("OPTION");
                            opt.text="Day Care";
                            opt.value="D";
							if (jsp_val != "")
							if (locn_type_value=="D")
	                            opt.selected=true;
                            parent.document.frames[1].document.forms[0].location0.add(opt);
                            parent.document.frames[1].location0_array[parent.document.frames[1].location0_array.length] = opt;
							</script>
<%							}
                            else if (op > 0)
                            {
						%>
                        <script>

                            opt=parent.document.frames[1].document.createElement("OPTION");
                            opt.text="Nursing Unit";
                            opt.value="N";
                            parent.document.frames[1].document.forms[0].location0.add(opt);
                            parent.document.frames[1].location0_array[parent.document.frames[1].location0_array.length] = opt

                            opt=parent.document.frames[1].document.createElement("OPTION");
                            opt.text="Clinic";
                            opt.value="C";
                            parent.document.frames[1].document.forms[0].location0.add(opt);
                            parent.document.frames[1].location0_array[parent.document.frames[1].location0_array.length] = opt
                            opt=parent.document.frames[1].document.createElement("OPTION");
                            opt.text="Day Care";
                            opt.value="D";
                            parent.document.frames[1].document.forms[0].location0.add(opt);
                            parent.document.frames[1].location0_array[parent.document.frames[1].location0_array.length] = opt;
                    </script>
                    <%
                            }
                    else
                            {
%>
                        <script>
                            
                            opt=parent.document.frames[1].document.createElement("OPTION");
                            opt.text="Nursing Unit";
                            opt.value="N";
                            parent.document.frames[1].document.forms[0].location0.add(opt);
                            parent.document.frames[1].location0_array[parent.document.frames[1].location0_array.length] = opt
                        </script>
                    <%
                            }
                        }
                        else
                        {       
                            if(op>0)
                            {
                            %>
                        <script>

                            opt=parent.document.frames[1].document.createElement("OPTION");
                            opt.text="Clinic";
                            opt.value="C";
                            parent.document.frames[1].document.forms[0].location0.add(opt);
                            parent.document.frames[1].location0_array[parent.document.frames[1].location0_array.length] = opt
                        </script>
                    <%
                        }
                        else
                            {
                        %>
                        <script>
                        </script>
                    <%
                            }
                        }
				 }
				 if (!jsp_val.equals(""))
				{
				 %>
				<script>
				 var speciality_value = '<%=speciality_val%>';
				 var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='GetReferralVals.jsp?src1=4&jsp_val=discharge&speciality="+speciality_value+"'></form></BODY></HTML>";
		    	 parent.frames[2].document.write(HTMLVal);
				 parent.frames[2].document.forms[0].submit();

				 
				 </script>
				 <%
				}
			}
            else if(src1.equals("2"))
            {
                    if(loc_type.equals("C"))
                    {
						if(sql_loc1.length() > 0) sql_loc1.delete(0,sql_loc1.length());
						sql_loc1.append("Select short_desc dat, clinic_code id, open_to_all_pract_yn from op_clinic where facility_id = '"+ref_to+"'  and allow_visit_regn_yn = 'Y' and level_of_care_ind = 'A' and eff_status = 'E'  and speciality_code = '"+specialty+"' and service_code = nvl('"+service+"',service_code)");
                    }
                    else if (loc_type.equals("N"))
                    {
					  if(sql_loc1.length() > 0) sql_loc1.delete(0,sql_loc1.length());
                       sql_loc1.append("Select a.short_desc dat, a.nursing_unit_code id from ip_nursing_unit a, ip_nurs_unit_for_specialty b  where a.facility_id = '"+ref_to+"' and a.eff_status = 'E' and  a.nursing_unit_code = b.nursing_unit_code and a.facility_id = b.facility_id and b.specialty_code = '"+specialty+"'and a.service_code = nvl('"+service+"',a.service_code) and a.appl_patient_class = 'IP' ");
                    }
                    else if (loc_type.equals("D"))
                    {
			           if(sql_loc1.length() > 0) sql_loc1.delete(0,sql_loc1.length());
                       sql_loc1.append("Select a.short_desc dat, a.nursing_unit_code id from ip_nursing_unit a, ip_nurs_unit_for_specialty b  where a.facility_id = '"+ref_to+"' and a.eff_status = 'E' and  a.nursing_unit_code = b.nursing_unit_code and a.facility_id = b.facility_id and b.specialty_code = '"+specialty+"'and a.service_code = nvl('"+service+"',a.service_code) and a.appl_patient_class = 'DC' ");
                    }
                    sql_loc1.append(" order by 1");
                    stmt_loc1=con.createStatement();
                    rs_loc1=stmt_loc1.executeQuery(sql_loc1.toString());
                    if(rs_loc1!=null)
                    {
                        while(rs_loc1.next())
                        {
                            clinicdesc=rs_loc1.getString(1);
                            clinicid=rs_loc1.getString(2);
                            if(loc_type.equals("C"))
                            open_to_all_pract_yn=rs_loc1.getString(3);
                            else 
                            open_to_all_pract_yn="";
                            %>
                            <script>
                            var temp = "<%=clinicid%>";
                            var temp1="<%=clinicdesc%>";
                            var temp3="<%=open_to_all_pract_yn%>";
							var jsp_val = "<%=jsp_val%>";
                            var opt=parent.document.frames[1].document.createElement("OPTION");
                            parent.document.frames[1].document.forms[0].open_to_all_pract_yn.value=temp3;
                            opt.text=temp1;
							if (jsp_val != "")
							{
								opt.value	=	temp+":::"+temp1;
								var locn_code_value = parent.frames[1].document.forms[0].locn_code_value.value;
								if (locn_code_value == temp)
									opt.selected = true;
							}
							else
							{
								opt.value=temp+":::"+temp1;
							}
                            <%if(location1.equals(clinicid) ) {%>
                            opt.selected=true;
                        <%} %>
                            parent.document.frames[1].document.forms[0].location1.add(opt);
                            parent.document.frames[1].document.forms[0].location1_desc.value=temp1;
                            </script>
                        <%
                        }
                    }
            }
            else if( src1.equals("3"))
            {
                if(loc_type.equals("C"))
                {
                    if (open_to_all_pract_yn.equals("Y"))
                    {
                        sql_pract="Select practitioner_id, practitioner_name from am_practitioner where practitioner_id in (Select practitioner_id from am_pract_for_facility where facility_id = '"+ref_to+"' and eff_status = 'E' ) and eff_status = 'E' order by practitioner_name ";
                    }
                    else
                    {
                        sql_pract="Select practitioner_id, practitioner_name from am_practitioner where practitioner_id in (Select practitioner_id from op_pract_for_clinic where facility_id = '"+ref_to+"' and clinic_code = '"+location1+"' and eff_status = 'E' ) and eff_status = 'E' ";
                    }
                }          
            else if(loc_type.equals("N"))
                {
                    sql_pract="Select practitioner_id, practitioner_name from am_practitioner where practitioner_id in (Select practitioner_id from ip_nursing_unit_for_pract where facility_id =  '"+ref_to+"'  and nursing_unit_code =  '"+location1+"' and eff_status = 'E' ) ";
                }

                stmt_pract=con.createStatement();
                rs_pract=stmt_pract.executeQuery(sql_pract);

                if(rs_pract!=null)
                {
                    while(rs_pract.next())
                    {
                        practitioner_id=rs_pract.getString(1);
                        if(practitioner_id==null) practitioner_id="";
                        practitioner_name=rs_pract.getString(2);
                        if(practitioner_name==null) practitioner_name="";
                        %>
                            <script>
                
                            var temp = "<%=practitioner_id%>";
                            var temp1="<%=practitioner_name%>";
                            var opt=parent.document.frames[1].document.createElement("OPTION");
                            opt.text=temp1;
                            opt.value=temp;
                            <%if(pract_id.equals(practitioner_id) ) {%>
                            opt.selected=true;
                        <%} %>
                            parent.document.frames[1].document.forms[0].practitioner.add(opt);
                            parent.document.frames[1].document.forms[0].practitioner_name.value=temp1;
                            </script>
                            <%
                    }
                }
            }
			if( src1.equals("4")) 
			{
	       		    String speciality_code = request.getParameter("speciality");
	    			StringBuffer sql_service = new StringBuffer();
	    			sql_service.append("Select Distinct A.Service_Code service_code, B.Short_Desc  short_desc from Op_Clinic A, Am_Service B where A.Speciality_Code = '"+speciality_code+"' and A.Facility_Id = '"+facility_id+"'and A.Service_Code = B.Service_Code ");
					String ip_install_yn="";
					String ip_install = "select install_yn from sm_module where module_id = 'IP'";
	                stmt_pract=con.createStatement();
					rs_speciality=stmt_pract.executeQuery(ip_install);
	    			while ( rs_speciality!=null&&rs_speciality.next() )			 ip_install_yn=rs_speciality.getString(1);
                    if (ip_install_yn.equals("Y"))
					{
                    sql_service.append(" union Select Distinct A.Service_Code service_code, B.Short_Desc  short_desc from ip_nursing_unit A, am_service B, ip_nurs_unit_for_specialty c  where a.nursing_unit_code = c.nursing_unit_code and c.specialty_code= '"+speciality_code+"' and A.Facility_Id = '"+facility_id+"'and A.Service_Code = B.Service_Code ");
					}
					sql_service.append(" order by 2 ");
	                rs_speciality=stmt_pract.executeQuery(sql_service.toString());

	    			while ( rs_speciality.next() )
	    			{	
	    				%>
	    					<script>
	    						var oOption = parent.document.frames[1].document.createElement("OPTION");
								var code =  '<%=rs_speciality.getString("Service_code")%>';
	    						oOption.text='<%=rs_speciality.getString("short_desc")%>';
	    						oOption.value='<%=rs_speciality.getString("Service_code")%>';
								var jsp_val = "<%=jsp_val%>";
								if (jsp_val != "")
								{
									var serv_code = parent.document.frames[1].document.forms[0].serv_code.value;	
									if (serv_code == code)
										oOption.selected = true;
								}
	                             parent.document.frames[1].document.forms[0].service.add(oOption);
	    					</script>
	    				<%
	    			}
					if (!(jsp_val.equals("")))
					{
				%>
						<script>
							var loc_type_value	= parent.frames[1].document.forms[0].location0.value;
							var ref_to_value	= parent.frames[1].document.forms[0].referred_to.value;
							var specialty_value	= parent.frames[1].document.forms[0].speciality.value;
							var service_value	= parent.frames[1].document.forms[0].serv_code.value;
							var HTMLValue = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='GetReferralVals.jsp?src1=2&jsp_val=discharge&loc_type="+loc_type_value+"&ref_to="+ref_to_value+"&specialty="+specialty_value+"&service="+service_value+"'></form></BODY></HTML>";
							parent.frames[2].document.write(HTMLValue);
							parent.frames[2].document.forms[0].submit();
						</script>

				<%
					}			
				}

%>
        </head>
    <body class=message onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
        <form name='dummyform' id='dummyform'>
        </form>
    </body>
<%
}catch(Exception e){out.println(e);}
            finally { 
    ConnectionManager.returnConnection(con,request);
	if(stmt!=null) stmt.close();
	if(stmt_pract!=null) stmt_pract.close();
	if(rs!=null) rs.close();
	if(rs_pract!=null) rs_pract.close();
	if(rs_speciality!=null) rs_speciality.close();
	if(stmt_loc!= null) stmt_loc.close();
	if(stmt_loc1!= null) stmt_loc1.close();
	if(rs_loc!=null) rs_loc.close();
	if(rs_loc1!=null) rs_loc1.close();
}
%>
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

