<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
		<%
		request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
		<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<body CLASS='MESSAGE' onKeyDown = 'lockKey();'>
	<%
		String facilityid=(String)session.getValue("facility_id");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="";
		StringBuffer sql1= new StringBuffer();
		
	try
	{
		con=ConnectionManager.getConnection(request);
		String step=request.getParameter("step");
		String funcid=request.getParameter("fun_name");
		String carelocntype="";
	
		if(step.equals("1"))
		{
			String unittype=request.getParameter("unittype");
			
			/*if(unittype.equals("C"))
			{
				sql="select clinic_code , long_desc from op_clinic where care_locn_type_ind='C' and facility_id='"+facilityid+"' and eff_status='E' order by long_desc";	
				
			}
			else if(unittype.equals("E"))
			{
				sql="select clinic_code , long_desc from op_clinic where care_locn_type_ind='E' and facility_id='"+facilityid+"' and eff_status='E' order by long_desc";

			}
			else if(unittype.equals("Y"))
			{
				sql="select clinic_code , long_desc from op_clinic where care_locn_type_ind='D' and facility_id='"+facilityid+"' and eff_status='E' order by long_desc";
			} */	
			
			if(unittype.equals(""))
			{
			%>
			<script>
				parent.document.f_query_add_mod.document.forms[0].reslookup_butt.disabled=true;
                parent.document.f_query_add_mod.document.forms[0].res_type.disabled=false; 
			</script>
			<%}
			String desc="";
			String code="";
			
			/*if(!sql.equals(""))
			{
				String desc="";
				String code="";
				try{
					
					pstmt=con.prepareStatement(sql);
					rs=pstmt.executeQuery();
					if(rs != null)
					{
						while(rs.next())
						{
							desc=rs.getString(2);
							code=rs.getString(1);*/
						 %>						
							<!-- <script>
							
								var opt="";
								opt=parent.f_query_add_mod.document.createElement("OPTION");
								opt.text="<%=desc%>";
								opt.value="<%=code%>";
								if(parent.document.f_query_add_mod.document.forms[0].res_unit != null)
									parent.document.f_query_add_mod.document.forms[0].res_unit.add(opt);
									
							</script>
							-->
						
							<%
						/*}
					}
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();

				}catch(Exception e)
				{
					
				}
			}*/
		}
		else if(step.equals("2"))
		{
			String resourceclass=request.getParameter("resourceclass");
			String res_unit=request.getParameter("res_unit");
			
			String practtype="";


			String clsql="select pract_type from op_clinic where clinic_code='"+res_unit+"' and primary_resource_class ='"+resourceclass+"' ";

			pstmt=con.prepareStatement(clsql);
			rs=pstmt.executeQuery();
			if(rs != null && rs.next())
			{
				practtype=(rs.getString("pract_type") == null)?"":rs.getString("pract_type");
			}

			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

			
			if(resourceclass.equals("P"))
			{
				sql="select pract_type, desc_sysdef from am_pract_type where eff_status='E' order by desc_sysdef";
			}
			else if(resourceclass.equals("R"))
			{
				sql="select locn_type,short_desc from am_care_locn_type where care_locn_type_ind='R' order by short_desc";
			}			
			else if(resourceclass.equals("E"))
			{
				sql="select resource_type,short_desc from am_resource_type where resource_class='E' order by short_desc";
			}
			else if(resourceclass.equals("O"))
			{
				sql="select resource_type,short_desc from am_resource_type where resource_class='O' order by short_desc";
			}
			
			if(resourceclass.equals(""))
			{%><script>
				parent.document.f_query_add_mod.document.forms[0].res_type.disabled=false;
				</script>

			<%}
			
			if(!sql.equals(""))
			{
				String desc="";
				String code="";
			try{
					pstmt=con.prepareStatement(sql);
					rs=pstmt.executeQuery();
					if(rs != null)
					{
						while(rs.next())
						{
							code=rs.getString(1);
							desc=rs.getString(2);
							%>
							<script>
								 var opt=parent.document.f_query_add_mod.document.createElement("OPTION");
								opt.text="<%=desc%>";
								opt.value="<%=code%>";
								if(parent.document.f_query_add_mod.document.forms[0].res_type != null)
									parent.document.f_query_add_mod.document.forms[0].res_type.add(opt);

								if("<%=practtype%>" != "")
							{
									parent.document.f_query_add_mod.document.forms[0].res_type.value="<%=practtype%>";
									parent.document.f_query_add_mod.document.forms[0].res_type.disabled=true;


							}
							else
							{
								parent.document.f_query_add_mod.document.forms[0].res_type.disabled=false;
							}
							</script>
							<%
						}
					}
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		else if(step.equals("3"))
		{			
			String callfunc=(request.getParameter("callfunc") == null)?"":request.getParameter("callfunc");
			String unittype="";
			String resunit="";
			String resclass="";
			String opentoallpract="";
					
			
			
			if(callfunc.equals("Pract_for_clinic"))
			{
				unittype="C";
				resunit=request.getParameter("clinic");
				funcid="insert";
				carelocntype=request.getParameter("carelocntype");
				
			}
			else if(callfunc.equals("Resource_unit"))
			{
				unittype=request.getParameter("unittype");
				resunit=request.getParameter("resourceunit");
				carelocntype=request.getParameter("carelocntype");
			}
			
			
			try{
				
				String firstvisit="";
				String followup="";
				String series="";
				String routine="";
				String emergency="";
				String consult="";
				String speciality_code="";
				String rd_appl_yn="";

				if(!callfunc.equals(""))
				{
					sql1.append("select clinic_code,working_week_1_day_1,working_week_1_day_2,working_week_1_day_3,working_week_1_day_4,working_week_1_day_5,working_week_1_day_6,working_week_1_day_7");
					sql1.append(",working_week_2_day_1,working_week_2_day_2,working_week_2_day_3,working_week_2_day_4,working_week_2_day_5,working_week_2_day_6,working_week_2_day_7");
					sql1.append(",working_week_3_day_1,working_week_3_day_2,working_week_3_day_3,working_week_3_day_4,working_week_3_day_5,working_week_3_day_6,working_week_3_day_7");
					sql1.append(",working_week_4_day_1,working_week_4_day_2,working_week_4_day_3,working_week_4_day_4,working_week_4_day_5,working_week_4_day_6,working_week_4_day_7");
					sql1.append(",working_week_5_day_1,working_week_5_day_2,working_week_5_day_3,working_week_5_day_4,working_week_5_day_5,working_week_5_day_6,working_week_5_day_7 ");
					sql1.append(",working_week_appl_day_1,working_week_appl_day_2,working_week_appl_day_3,working_week_appl_day_4,working_week_appl_day_5,working_week_appl_day_6,working_week_appl_day_7 ");
					sql1.append(",working_day_1,working_day_2,working_day_3,working_day_4,working_day_5,working_day_6,working_day_7 ,open_to_all_pract_yn ,primary_resource_class ");

					sql1.append(",FI_VISIT_TYPE_APPL_YN, FU_VISIT_TYPE_APPL_YN, RT_VISIT_TYPE_APPL_YN, SR_VISIT_TYPE_APPL_YN, CS_VISIT_TYPE_APPL_YN, EM_VISIT_TYPE_APPL_YN,SPECIALITY_CODE,rd_appl_yn ");
					sql1.append(" from op_clinic where care_locn_type_ind = '"+carelocntype+"' and clinic_type='"+unittype+"' and  clinic_code='"+resunit+"' and facility_id='"+facilityid+"'");
					
					
					pstmt=con.prepareStatement(sql1.toString());
					rs=pstmt.executeQuery();
					rs.next();
										
						firstvisit=rs.getString("FI_VISIT_TYPE_APPL_YN");
						followup=rs.getString("FU_VISIT_TYPE_APPL_YN");
						routine=rs.getString("RT_VISIT_TYPE_APPL_YN");
						series=rs.getString("SR_VISIT_TYPE_APPL_YN");
						consult=rs.getString("CS_VISIT_TYPE_APPL_YN");
                        emergency=rs.getString("EM_VISIT_TYPE_APPL_YN");
                        speciality_code = rs.getString("SPECIALITY_CODE");
                        rd_appl_yn = rs.getString("rd_appl_yn");

					 	out.println("<script>if(parent.f_query_add_mod.document.forms[0].speciality_code){parent.f_query_add_mod.document.forms[0].speciality_code.value='"+speciality_code+"';}</script>");
					
						
						for(int i=1;i<=5;i++)
						{
							for(int j=1;j<=7;j++)
							{
							%>
								<script>
									if('<%=rs.getString("working_week_appl_day_"+j)%>' =="W")
									{
										eval(parent.f_query_add_mod.document.getElementById("week_appl_day_<%=j%>")).innerText=getLabel('Common.specific.label','Common');
									}
									else
									{
										eval(parent.f_query_add_mod.document.getElementById("week_appl_day_<%=j%>")).innerText=getLabel('Common.all.label','Common');;
									}
									eval("parent.f_query_add_mod.document.forms[0].pract_week_appl_day_<%=j%>").value="<%=rs.getString("working_week_appl_day_"+j)%>"
									
									

									eval("parent.f_query_add_mod.document.forms[0].working_week_<%=i%>_day_<%=j%>").value = "<%=rs.getString("working_week_"+i+"_day_"+j)%>";

									if(eval("parent.f_query_add_mod.document.forms[0].working_week_<%=i%>_day_<%=j%>").value == "W")
									{
										eval("parent.f_query_add_mod.document.forms[0].working_week_<%=i%>_day_<%=j%>").checked = true;
										
									}
									else if(eval("parent.f_query_add_mod.document.forms[0].working_week_<%=i%>_day_<%=j%>").value =="N")
									{
										eval("parent.f_query_add_mod.document.forms[0].working_week_<%=i%>_day_<%=j%>").checked = false;
										
										
									
									}
									else if(eval("parent.f_query_add_mod.document.forms[0].working_week_<%=i%>_day_<%=j%>").value =="H")
									{
										eval("parent.f_query_add_mod.document.forms[0].working_week_<%=i%>_day_<%=j%>").checked = false;
									}

									eval("parent.f_query_add_mod.document.forms[0].pract_working_week_<%=i%>_day_<%=j%>").value = "<%=rs.getString("working_week_"+i+"_day_"+j)%>";
								
								 
									

									eval("parent.f_query_add_mod.document.forms[0].pract_working_week_<%=i%>_day_<%=j%>1").value = "<%=rs.getString("working_week_"+i+"_day_"+j)%>";

									if(eval("parent.f_query_add_mod.document.forms[0].pract_working_week_<%=i%>_day_<%=j%>").value == "W")
									{
										eval("parent.f_query_add_mod.document.forms[0].pract_working_week_<%=i%>_day_<%=j%>").checked = true;
										eval("parent.f_query_add_mod.document.forms[0].pract_working_week_<%=i%>_day_<%=j%>").disabled = false;
									}
									else if(eval("parent.f_query_add_mod.document.forms[0].pract_working_week_<%=i%>_day_<%=j%>").value =="N")
									{
										eval("parent.f_query_add_mod.document.forms[0].pract_working_week_<%=i%>_day_<%=j%>").checked = false;
									eval("parent.f_query_add_mod.document.forms[0].pract_working_week_<%=i%>_day_<%=j%>").disabled = true;	
									
									}
									else if(eval("parent.f_query_add_mod.document.forms[0].pract_working_week_<%=i%>_day_<%=j%>").value =="H")
									{
										eval("parent.f_query_add_mod.document.forms[0].pract_working_week_<%=i%>_day_<%=j%>").checked = false;
										eval("parent.f_query_add_mod.document.forms[0].pract_working_week_<%=i%>_day_<%=j%>").disabled = true;

									}
								</script>
							<%										
							}
						}

						opentoallpract=rs.getString("OPEN_TO_ALL_PRACT_YN");
						resclass=rs.getString("PRIMARY_RESOURCE_CLASS");
						
						
						if(!unittype.equals("Y"))
					{
						if(funcid.equals("insert")&&callfunc.equals("Resource_unit"))
						{
					
					if(opentoallpract.equals("Y") && resclass.equals("P"))
						{
								%>
								<script>
								
								var opt1=parent.f_query_add_mod.document.createElement("OPTION");				
								opt1.text=getLabel('Common.room.label','Common');
								opt1.value="R";	
								parent.f_query_add_mod.document.forms[0].res_class.add(opt1);	
								opt1=parent.f_query_add_mod.document.createElement("OPTION");	
								opt1.text=getLabel('Common.equipment.label','Common');
								opt1.value="E";	
								parent.f_query_add_mod.document.forms[0].res_class.add(opt1);
								opt1=parent.f_query_add_mod.document.createElement("OPTION");	
								opt1.text=getLabel('Common.other.label','Common');
								opt1.value="O";	
								parent.f_query_add_mod.document.forms[0].res_class.add(opt1);				
							
								
							

							
								</script>
								<%
								

						}
						else
						{
							%>
								<script>
								
								
								var opt1=parent.f_query_add_mod.document.createElement("OPTION");	
								opt1.text=getLabel('Common.practitioner.label','Common');
								opt1.value="P";	
								parent.f_query_add_mod.document.forms[0].res_class.add(opt1);
								opt1=parent.f_query_add_mod.document.createElement("OPTION");	
								opt1.text=getLabel('Common.room.label','Common');
								opt1.value="R";	
								parent.f_query_add_mod.document.forms[0].res_class.add(opt1);	
								opt1=parent.f_query_add_mod.document.createElement("OPTION");	
								opt1.text=getLabel('Common.equipment.label','Common');
								opt1.value="E";	
								parent.f_query_add_mod.document.forms[0].res_class.add(opt1);
								opt1=parent.f_query_add_mod.document.createElement("OPTION");	
								opt1.text=getLabel('Common.other.label','Common');
								opt1.value="O";	
								parent.f_query_add_mod.document.forms[0].res_class.add(opt1);						
								
								</script>
								<%
						}
						
						}
					}
					if(funcid.equals("insert"))
					{
					%>
						<script>
						var routine='<%=routine%>';
					    var first='<%=firstvisit%>';
						var fwup='<%=followup%>';
						var ser='<%=series%>';
						var consul='<%=consult%>';
						var emer='<%=emergency%>';
						

						   if(routine=="N"){
						parent.f_query_add_mod.document.forms[0].routine.checked=false;
						parent.f_query_add_mod.document.forms[0].routine.value='N';
						parent.f_query_add_mod.document.forms[0].routine1.value='N';
						parent.f_query_add_mod.document.forms[0].routine.disabled=true;  
						   }else{
							parent.f_query_add_mod.document.forms[0].routine.disabled=false;  
						   parent.f_query_add_mod.document.forms[0].routine.checked=true;
						   parent.f_query_add_mod.document.forms[0].routine.value='Y';
						parent.f_query_add_mod.document.forms[0].routine1.value='Y';
					
						   }
						if(first=="N"){
						parent.f_query_add_mod.document.forms[0].first.checked=false;
						parent.f_query_add_mod.document.forms[0].first.disabled=true;  
						parent.f_query_add_mod.document.forms[0].first.value='N';
						parent.f_query_add_mod.document.forms[0].first1.value='N';  
						
						   }else{
							  parent.f_query_add_mod.document.forms[0].first.value='Y';
						    parent.f_query_add_mod.document.forms[0].first1.value='Y';
							parent.f_query_add_mod.document.forms[0].first.disabled=false;  
						   parent.f_query_add_mod.document.forms[0].first.checked=true;
						   }
						if(fwup=="N"){
							 parent.f_query_add_mod.document.forms[0].follow.value='N';
						    parent.f_query_add_mod.document.forms[0].follow1.value='N';
						
						parent.f_query_add_mod.document.forms[0].follow.checked=false;
						parent.f_query_add_mod.document.forms[0].follow.disabled=true;  
						   }else{
							    parent.f_query_add_mod.document.forms[0].follow.value='Y';
						    parent.f_query_add_mod.document.forms[0].follow1.value='Y';
						
							parent.f_query_add_mod.document.forms[0].follow.disabled=false;  
						   parent.f_query_add_mod.document.forms[0].follow.checked=true;
						   }
						if(ser=="N"){
						parent.f_query_add_mod.document.forms[0].series.value='N';
						    parent.f_query_add_mod.document.forms[0].series1.value='N';
						parent.f_query_add_mod.document.forms[0].series.checked=false;
						parent.f_query_add_mod.document.forms[0].series.disabled=true;  
						   }else{
							   parent.f_query_add_mod.document.forms[0].series.value='Y';
						    parent.f_query_add_mod.document.forms[0].series1.value='Y';
					
							parent.f_query_add_mod.document.forms[0].series.disabled=false;  
						   parent.f_query_add_mod.document.forms[0].series.checked=true;
						   }
						if(consul=="N"){
						parent.f_query_add_mod.document.forms[0].consult.value='N';
						    parent.f_query_add_mod.document.forms[0].consult1.value='N';
					
						parent.f_query_add_mod.document.forms[0].consult.checked=false;
						parent.f_query_add_mod.document.forms[0].consult.disabled=true;  
						   }else{
							   
						parent.f_query_add_mod.document.forms[0].consult.value='Y';
						    parent.f_query_add_mod.document.forms[0].consult1.value='Y';
							parent.f_query_add_mod.document.forms[0].consult.disabled=false;  
						   parent.f_query_add_mod.document.forms[0].consult.checked=true;
						   }
						if(emer=="N"){
						parent.f_query_add_mod.document.forms[0].emergency.value='N';
						    parent.f_query_add_mod.document.forms[0].emergency1.value='N';
					
						parent.f_query_add_mod.document.forms[0].emergency.checked=false;
						parent.f_query_add_mod.document.forms[0].emergency.disabled=true;  
						   }else{
							   parent.f_query_add_mod.document.forms[0].emergency.value='Y';
						    parent.f_query_add_mod.document.forms[0].emergency1.value='Y';
					
							parent.f_query_add_mod.document.forms[0].emergency.disabled=false;  
						   parent.f_query_add_mod.document.forms[0].emergency.checked=true;
						   }


						</script>
					
					<%

						}
						if(unittype.equals("E") && rd_appl_yn.equals("Y")){%>
						<script>		
						 parent.f_query_add_mod.document.forms[0].rd_appl_yn.value="Y";
						 parent.f_query_add_mod.document.forms[0].res_class.selectedIndex=3;
						 parent.f_query_add_mod.document.forms[0].res_class.onchange();
						 parent.f_query_add_mod.document.forms[0].res_class.disabled=true;
						</script>
						<%}

					

					if(pstmt != null) pstmt.close();
					if(rs != null) rs.close();

					sql1.setLength(0);
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
  	 }
	}catch(Exception e)
	{
e.printStackTrace();	}
	finally{

		if(con != null)
			ConnectionManager.returnConnection(con,request);

	}
	%>
	</body>
</html>

