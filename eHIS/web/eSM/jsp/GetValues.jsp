
<%String sStyle	=
            (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>



<%												   
			Connection con=null;
			con = ConnectionManager.getConnection(request);
			Hashtable hash = (Hashtable)obj.parseXMLString( request );
		 	hash = (Hashtable)hash.get("SEARCH") ;
            request.setCharacterEncoding("UTF-8");
			String Log_user= (String) session.getValue("login_user");
			String responsibility_id= (String) session.getValue("responsibility_id");
			String facilityId = (String) session.getValue("facility_id");
			java.sql.Statement stmt= con.createStatement();
			java.sql.Statement stmt1 = con.createStatement();
			java.sql.Statement stmt2 = con.createStatement();
			java.sql.Statement mystmt = con.createStatement();
			java.sql.Statement rootstmt= con.createStatement();
			ResultSet rset=null;
			ResultSet rs=null;
			ResultSet rset1=null;
			ResultSet rootrset=null;
			ResultSet myrset=null;
			int cntr=0;

			String moduleid="";
			String moduledesc="";
			String chksrc = (String) hash.get("Chksrc") ;
			if(chksrc == null) chksrc=""; 
			String common = (String) hash.get("Common_Text") ;
			
			if(common == null) common="";
			String common1 = (String) hash.get("Common_Text1") ;	
			
			String mod_id=(String) hash.get("mod_id") ;
			if(mod_id == null) mod_id="";	

			if(common1 == null) common1="";			
			String menu_id="";
			String option_type="";
			String module_id="";
			String function_id="";
			String submenu_id ="";
			String option_descriptor="";
			String array[][]=null;
			String root_yn="";
	try
	{
			if(chksrc.trim().equals("one"))
	    	{
		    	String sql = "select report_id,report_desc from sm_report where ACCEPT_ADHOC_EMAILID_YN='N' and module_id='" + common.trim() + "' order by report_desc";
			

				rset = stmt1.executeQuery(sql);		
				
				if(rset != null) 			
				{
%>
					document.getElementById('locnimg').style.visibility = 'hidden';
					document.getElementById('locnimg1').style.visibility = 'hidden';				
					var tp ="  -----------" +getLabel("Common.defaultSelect.label","Common")+ "--------"
					var opt=document.createElement("OPTION");
					opt.text=tp;
					opt.value="";
					document.forms[0].report_id.add(opt);					

					var facility ="-----------" +getLabel("Common.defaultSelect.label","Common")+ "--------"
					var opt=document.createElement("OPTION");
					opt.text=facility;
					opt.value="";
					document.forms[0].facility_id.add(opt);

					var dest_locn_type ="  -----------" +getLabel("Common.defaultSelect.label","Common")+ "--------"
					var opt=document.createElement("OPTION");
					opt.text=dest_locn_type;
					opt.value="";
					document.forms[0].dest_locn_type.add(opt);
					
					var dest_locn_code ="  -----------" +getLabel("Common.defaultSelect.label","Common")+ "--------"
					var opt=document.createElement("OPTION");
					opt.text=dest_locn_code;
					opt.value="";
					document.forms[0].dest_locn_code.add(opt);
					
<%				
				    while( rset.next() ) 
				    {
				      	moduleid = rset.getString( "report_id" ) ;	
				       	moduledesc= rset.getString( "report_desc" ) ;
					
%>
						var temp = "<%=moduleid%>";						
						var temp1="<%=moduledesc%>";	
					
						var opt=document.createElement("OPTION");					
						opt.text=temp1;
						opt.value=temp;							
						document.forms[0].report_id.add(opt);	
					
<%			  					}
					}
			}
			else if(chksrc.trim().equals("two"))
		    {
		    	String sql="SELECT FACILITY_BASED_YN FROM SM_REPORT WHERE REPORT_ID='"+ common1.trim() +"'";
				
				
				
				if(rset!=null)rset.close();
				rset = stmt1.executeQuery(sql);
				if(rset.next())
				{
					String str=rset.getString("FACILITY_BASED_YN").trim();					
					if (str.equals("N"))
					{
						%>
						var n=document.forms[0].facility_id.options.length;
						for(var i=0;i<n;i++)
						{
							document.forms[0].facility_id.remove("facility_id");
						}
						
						var tp1 ="  -----------" +getLabel("Common.defaultSelect.label","Common")+ "--------"
						var opt1=document.createElement("OPTION");
						opt1.text=tp1;
						opt1.value="";
						document.forms[0].facility_id.add(opt1);	
						
						/*document.forms[0].man.height=0;
						document.forms[0].man.width=0;
						document.forms[0].man.src ='';*/

						document.forms[0].facility_id.disabled = true;
						document.getElementById('facimg').style.visibility = 'hidden'; 
						

						var m=document.forms[0].dest_locn_code.options.length;
						for(var i=0;i<m;i++)
						{
							document.forms[0].dest_locn_code.remove("dest_locn_code");
						}
						<%
					}
					else
					{
						%>
						var n=document.forms[0].facility_id.options.length;
						for(var i=0;i<n;i++)
						{
							document.forms[0].facility_id.remove("facility_id");
						}

						
						document.forms[0].facility_id.disabled = false;
						document.getElementById('facimg').style.visibility = 'visible';
						document.forms[0].facilityYN.value="Y";	

						var tp ="-----------"+getLabel("Common.defaultSelect.label","Common")+ "--------"
						var opt=document.createElement("OPTION");
						opt.text=tp;
						opt.value="";
						document.forms[0].facility_id.add(opt);
						/*document.forms[0].man.height=10
						document.forms[0].man.width=10
						document.forms[0].man.src ='../../eCommon/images/mandatory.gif';*/

						var m=document.forms[0].dest_locn_code.options.length;
						for(var i=0;i<m;i++)
						{
							document.forms[0].dest_locn_code.remove("dest_locn_code");
						}
						<%						
						String sql1= "select a.facility_id, b.facility_name from sm_report_for_fcy a, sm_facility_param b where a.facility_id = b.facility_id and module_id='" + common.trim() + "'and report_id='"+ common1.trim() +"' ORDER BY b.facility_name";
						
									if(rset!=null)rset.close();
						rset = stmt1.executeQuery(sql1);
						if(rset != null)
						{
					        while( rset.next() )
					        {
					        	moduleid = rset.getString( "facility_id" ) ;
								moduledesc=rset.getString( "facility_name" ) ;
								%>
								var temp = "<%=moduleid%>";
								var temp1="<%=moduledesc%>";
								var opt=document.createElement("OPTION");
								opt.text=  temp1;
								opt.value=temp;
								document.forms[0].facility_id.add(opt);
								<%
							}
						 }
					}
		        }

	    		String sql2= "select transaction_based_yn from sm_report where module_id='" + common.trim() + "'and report_id='"+ common1.trim() +"'";
				if(rset!=null)rset.close();
				
				rset = stmt1.executeQuery(sql2);
				if(rset != null)
				{
			        if( rset.next() )
			        {
			        	moduleid = rset.getString( "transaction_based_yn" ) ;

				 	
						 if(moduleid.equals("Y"))
				 		 {

							 if(common.equals("AE")){%>							
							
								var txt = new Array(" ---"+getLabel("Common.defaultSelect.label","Common")+" ---",getLabel("Common.clinic.label","Common"));
								var values = new Array("","C");
							
								for(var i=0;i<txt.length;i++)
								{
									var opt=document.createElement("OPTION");
									opt.text=txt[i];
									opt.value=values[i];
									document.forms[0].dest_locn_type.add(opt);
								}
								var dest_locn_code =" ----------"+getLabel("Common.defaultSelect.label","Common")+"---------- ";
								var opt=document.createElement("OPTION");
								opt.text=dest_locn_code;
								opt.value="";
								document.forms[0].dest_locn_code.add(opt);
							<%}else if(common.equals("OP")){%>
								var txt = new Array(" ---"+getLabel("Common.defaultSelect.label","Common")+" ---",getLabel("Common.clinic.label","Common"),getLabel("Common.ProcedureUnit.label","Common"));
								var values = new Array("","C","E");
							
								for(var i=0;i<txt.length;i++)
								{
									var opt=document.createElement("OPTION");
									opt.text=txt[i];
									opt.value=values[i];
									document.forms[0].dest_locn_type.add(opt);
								}
								var dest_locn_code =" ----------"+getLabel("Common.defaultSelect.label","Common")+"---------- ";
								var opt=document.createElement("OPTION");
								opt.text=dest_locn_code;
								opt.value="";
								document.forms[0].dest_locn_code.add(opt);


							<%}else if(common.equals("IP")){%>

								var txt = new Array(" ---"+getLabel("Common.defaultSelect.label","Common")+" ---",getLabel("Common.DaycareUnit.label","Common"),getLabel("Common.nursingUnit.label","Common"));
									var values = new Array("","Y","N");
								
								for(var i=0;i<txt.length;i++)
								{
									var opt=document.createElement("OPTION");
									opt.text=txt[i];
									opt.value=values[i];
									document.forms[0].dest_locn_type.add(opt);
								}
								var dest_locn_code =" ----------"+getLabel("Common.defaultSelect.label","Common")+"---------- ";
								var opt=document.createElement("OPTION");
								opt.text=dest_locn_code;
								opt.value="";
								document.forms[0].dest_locn_code.add(opt);
							<%}else if(common.equals("OA")){%>

								var txt = new Array(" ---"+getLabel("Common.defaultSelect.label","Common")+" ---",getLabel("Common.clinic.label","Common"),getLabel("Common.DaycareUnit.label","Common"),getLabel("Common.ProcedureUnit.label","Common"));
									var values = new Array("","C","Y","E");
								
								for(var i=0;i<txt.length;i++)
								{
									var opt=document.createElement("OPTION");
									opt.text=txt[i];
									opt.value=values[i];
									document.forms[0].dest_locn_type.add(opt);
								}
								var dest_locn_code =" ----------"+getLabel("Common.defaultSelect.label","Common")+"---------- ";
								var opt=document.createElement("OPTION");
								opt.text=dest_locn_code;
								opt.value="";
								document.forms[0].dest_locn_code.add(opt);
							<%}else if(common.equals("DS")){%>

								var txt = new Array(" ---"+getLabel("Common.defaultSelect.label","Common")+" ---",getLabel("Common.DaycareUnit.label","Common"),getLabel("Common.nursingUnit.label","Common"),getLabel("Common.ProcedureUnit.label","Common"));
									var values = new Array("","Y","N","E");
								
								for(var i=0;i<txt.length;i++)
								{
									var opt=document.createElement("OPTION");
									opt.text=txt[i];
									opt.value=values[i];
									document.forms[0].dest_locn_type.add(opt);
								}
								var dest_locn_code =" ----------"+getLabel("Common.defaultSelect.label","Common")+"---------- ";
								var opt=document.createElement("OPTION");
								opt.text=dest_locn_code;
								opt.value="";
								document.forms[0].dest_locn_code.add(opt);
							<%}else if(common.equals("FM")){%>

								var txt = new Array(" ---"+getLabel("Common.defaultSelect.label","Common")+" ---",getLabel("Common.clinic.label","Common"),getLabel("Common.DaycareUnit.label","Common"),getLabel("Common.nursingUnit.label","Common"),getLabel("eFM.PermanentFSLocation.label","FM"),getLabel("Common.ProcedureUnit.label","Common"));
									var values = new Array("","C","Y","N","F","E");
								
								for(var i=0;i<txt.length;i++)
								{
									var opt=document.createElement("OPTION");
									opt.text=txt[i];
									opt.value=values[i];
									document.forms[0].dest_locn_type.add(opt);
								}
								var dest_locn_code =" ----------"+getLabel("Common.defaultSelect.label","Common")+"---------- ";
								var opt=document.createElement("OPTION");
								opt.text=dest_locn_code;
								opt.value="";
								document.forms[0].dest_locn_code.add(opt);
							<%}else if(common.equals("OR")){%>

								var txt = new Array(" ---"+getLabel("Common.defaultSelect.label","Common")+" ---",getLabel("Common.clinic.label","Common"),getLabel("Common.DaycareUnit.label","Common"),getLabel("Common.nursingUnit.label","Common"),getLabel("Common.ProcedureUnit.label","Common"));
									var values = new Array("","C","Y","N","E");
								
								for(var i=0;i<txt.length;i++)
								{
									var opt=document.createElement("OPTION");
									opt.text=txt[i];
									opt.value=values[i];
									document.forms[0].dest_locn_type.add(opt);
								}
								var dest_locn_code =" ----------"+getLabel("Common.defaultSelect.label","Common")+"---------- ";
								var opt=document.createElement("OPTION");
								opt.text=dest_locn_code;
								opt.value="";
								document.forms[0].dest_locn_code.add(opt);

							<%}else if(common.equals("RL")){%>

								var txt = new Array(" ---"+getLabel("Common.defaultSelect.label","Common")+" ---",getLabel("Common.clinic.label","Common"),getLabel("Common.nursingUnit.label","Common"),getLabel("Common.ProcedureUnit.label","Common"),getLabel("Common.external.label","Common"));
									var values = new Array("","C","N","E","R");
								
								for(var i=0;i<txt.length;i++)
								{
									var opt=document.createElement("OPTION");
									opt.text=txt[i];
									opt.value=values[i];
									document.forms[0].dest_locn_type.add(opt);
								}
								var dest_locn_code =" ----------"+getLabel("Common.defaultSelect.label","Common")+"---------- ";
								var opt=document.createElement("OPTION");
								opt.text=dest_locn_code;
								opt.value="";
								document.forms[0].dest_locn_code.add(opt);

							<%}else{%>

								var txt = new Array(" ---"+getLabel("Common.defaultSelect.label","Common")+" ---",getLabel("Common.clinic.label","Common"),getLabel("Common.DaycareUnit.label","Common"),getLabel("Common.nursingUnit.label","Common"),getLabel("Common.pharmacy.label","Common"),getLabel("Common.ProcedureUnit.label","Common"),getLabel("Common.Store.label","Common"));
								var values = new Array("","C","Y","N","P","E","S");
							
								for(var i=0;i<txt.length;i++)
								{
									var opt=document.createElement("OPTION");
									opt.text=txt[i];
									opt.value=values[i];
									document.forms[0].dest_locn_type.add(opt);
								}
								var dest_locn_code =" ----------"+getLabel("Common.defaultSelect.label","Common")+"---------- ";
								var opt=document.createElement("OPTION");
								opt.text=dest_locn_code;
								opt.value="";
								document.forms[0].dest_locn_code.add(opt);

							<%}%>

							document.getElementById('locnimg').style.visibility = 'hidden';
							document.getElementById('locnimg1').style.visibility = 'hidden';
							<%
					  	}
				  	  	else
				  	  	{
%>							var opt=document.createElement("OPTION");
							opt.text=getLabel("Common.Location.label","Common");
							opt.value="L";
							document.forms[0].dest_locn_type.add(opt);

							document.forms[0].dest_locn_code1.disabled=false;
							document.getElementById('locnimg1').style.visibility = 'visible';
							document.getElementById('locnimg').style.visibility = 'hidden';
							document.forms[0].dest_locn_code.disabled=true;
<%
				  	  	}
					}
				}
    			if(rset!=null)rset.close();
               String stl="";
				String sl= "select report_class from sm_report where module_id='" + common.trim() + "'and report_id='"+ common1.trim() +"'";
			
				rset = stmt1.executeQuery(sl);
				if(rset.next())
				{
				stl=rset.getString("report_class");
				 }%>
				document.forms[0].reportclass.value='<%=stl%>'
	    		<%String sl2= "select dflt_report_mode from sm_report where module_id='" + common.trim() + "'and report_id='"+ common1.trim() +"'";

		

				if(rset!=null)rset.close();
				rset = stmt1.executeQuery(sl2);
				if(rset != null)
				{
			        while( rset.next() )
			        {
			        	moduleid = rset.getString( "dflt_report_mode" ) ;
						if(moduleid.equals("B"))
						{
%>
							var n=document.forms[0].dflt_report_mode.options.length;
							for(var i=0;i<n;i++)
							{
								document.forms[0].dflt_report_mode.remove("dflt_report_mode");
							}

							var opt=document.createElement("OPTION");
							opt.text=getLabel("eSM.Bitmap.label","SM");
							opt.value="B";
							document.forms[0].dflt_report_mode.add(opt);

							var opt=document.createElement("OPTION");
							opt.text=getLabel("eSM.Character.label","SM");;
							opt.value="C";
							document.forms[0].dflt_report_mode.add(opt);
<%
						}
						else
						{
%>
							var n=document.forms[0].dflt_report_mode.options.length;
							for(var i=0;i<n;i++)
							{
								document.forms[0].dflt_report_mode.remove("dflt_report_mode");
							}

							var opt=document.createElement("OPTION");
							opt.text=getLabel("eSM.Character.label","SM");
							opt.value="C";
							document.forms[0].dflt_report_mode.add(opt);

							var opt=document.createElement("OPTION");
							opt.text=getLabel("eSM.Bitmap.label","SM");
							opt.value="B";
							document.forms[0].dflt_report_mode.add(opt);
<%
						}
					}
				 }
				 if(common1.equals("")||common1==null){%>
				var dest_locn_code1 =" ----------"+getLabel("Common.defaultSelect.label","Common")+"---------- ";
				var opt=document.createElement("OPTION");
				opt.text=dest_locn_code1;
				opt.value="";
				document.forms[0].dest_locn_type.add(opt);


				 <%}
			}
			else if(chksrc.trim().equals("three"))
			{

%>				
				document.getElementById('locnimg').style.visibility = 'visible';
				document.getElementById('locnimg1').style.visibility = 'hidden';
				var common1 = "<%=common1%>";
<%
				String fid ="";
				String rid ="";				
				StringTokenizer st = new StringTokenizer(common1,"#");
				while(st.hasMoreTokens()){
						fid = st.nextToken();
						if (st.hasMoreTokens())
							rid = st.nextToken();
				}
				
				String sql="";
				String facid="";
				String code = "";
				String desc = "";
				sql="SELECT FACILITY_BASED_YN,TRANSACTION_BASED_YN FROM SM_REPORT WHERE REPORT_ID='"+ rid.trim() +"'";
				if(rset!=null)rset.close();					
				rset = stmt1.executeQuery(sql);			
				if(rset.next())
				{
					String facyn=rset.getString("FACILITY_BASED_YN").trim();
					String tranyn = rset.getString("TRANSACTION_BASED_YN").trim();					
					if (facyn.equals("N") && tranyn.equals("Y"))
							facid=facilityId;
					else if(facyn.equals("Y") && tranyn.equals("Y")){
							if(fid.equals(" ") || fid == null || fid.equals(""))
							{
								%>
								var err=getMessage('CAN_NOT_BE_BLANK','Common');
								err=err.replace('$',getLabel("Common.facility.label","Common"));
								document.write(err);
							<%
							}
							else
								facid=fid;
					}
				}	
				if(common.trim().equals("C"))
		   		{
					%>
					document.forms[0].dest_locn_code1.value='';
					document.forms[0].dest_locn_code1.disabled = true;						
					document.forms[0].dest_locn_code.disabled = false;			   
										
					var tp =" -------"+getLabel("Common.defaultSelect.label","Common")+" -------";
					var opt=document.createElement("OPTION");
					opt.text=tp;
					opt.value="";
					document.forms[0].dest_locn_code.add(opt);		
					
					var tp1 ="*"+getLabel("Common.all.label","Common");
					var opt=document.createElement("OPTION");
					opt.text=tp1;
					opt.value="*A";
					document.forms[0].dest_locn_code.add(opt);
		
			<%			
					sql = "select INSTALL_YN from sm_module where MODULE_ID='OP' " ;
					if(rset!=null)rset.close();
					
					rset = stmt1.executeQuery(sql);
					sql="";
					if(rset.next())
					{
						String installyn = rset.getString("INSTALL_YN");
						if(installyn.equals("Y"))
						{	
							if(mod_id.equals("AE")){								
								sql= "select clinic_code,short_desc  from op_clinic where eff_status='E' and facility_id='"+facid.trim()+"' and sysdate between nvl(eff_date_from,to_date('01/01/1472','dd/mm/rrrr')) and nvl(eff_date_to,to_date('31/12/5000','dd/mm/rrrr')) and care_locn_type_ind = 'C' and LEVEL_OF_CARE_IND='E' order by short_desc "; 
							}else{
														
								sql= "select clinic_code,short_desc  from op_clinic where eff_status='E' and facility_id='"+facid.trim()+"' and sysdate between nvl(eff_date_from,to_date('01/01/1472','dd/mm/rrrr')) and nvl(eff_date_to,to_date('31/12/5000','dd/mm/rrrr')) and care_locn_type_ind = 'C' and LEVEL_OF_CARE_IND in('A','E') order by short_desc ";
							}

					
							rs = stmt2.executeQuery(sql);			
							sql="";
							if(rs != null)
							{
								while( rs.next() ) 
								{
									code = rs.getString( "clinic_code" ) ;	
									desc = rs.getString( "short_desc" ) ;	
	                    						
						 %>					
									
	                         
							 var temp = "<%=code%>";
									var opt=document.createElement("OPTION");
									opt.text= "<%=desc%>";
									opt.value=temp;
									document.forms[0].dest_locn_code.add(opt);
	<%				   	  
								}
							}if(rs!=null)rs.close();
						}
						else %>
							alert(getMessage('OP_NOT_INSTALLED','SM'));
	<%				}
					else
					{ %>
						alert(getMessage('OP_NOT_INSTALLED','SM'));
<%					}

				}
		   		else if(common.trim().equals("N"))
				{
			%>
					document.forms[0].dest_locn_code1.value='';
					document.forms[0].dest_locn_code1.disabled = true;			   
					document.forms[0].dest_locn_code.disabled = false;			   
										
					var tp =" -------"+getLabel("Common.defaultSelect.label","Common")+" -------";
					var opt=document.createElement("OPTION");
					opt.text=tp;
					opt.value="";
					document.forms[0].dest_locn_code.add(opt);

					var tp1 ="*"+getLabel("Common.all.label","Common");
					var opt=document.createElement("OPTION");
					opt.text=tp1;
					opt.value="*A";
					document.forms[0].dest_locn_code.add(opt);
			<%			

					sql = "select INSTALL_YN from sm_module where MODULE_ID='IP' " ;
					if(rset!=null)rset.close();
					rset = stmt1.executeQuery(sql);
					if(rset.next())
					{
						String installyn = rset.getString("INSTALL_YN");
						if(installyn.equals("Y"))
						{
							sql= "select nursing_unit_code,short_desc from ip_nursing_unit  where facility_id = '"+facid.trim()+"' and eff_status = 'E'  order by short_desc";	
							if(rset!=null)rset.close();
							rset = stmt1.executeQuery(sql);			
			
							if(rset != null)
							{
								while( rset.next() ) 
								{
									code = rset.getString( "nursing_unit_code" ) ;	
									desc = rset.getString( "short_desc" ) ;	
									%>		
									var temp = "<%=code%>";
									var opt=document.createElement("OPTION");
									opt.text= "<%=desc%>";
									opt.value=temp;
									document.forms[0].dest_locn_code.add(opt);
		<%				   	  	}
							}
						}
						else %>
							alert(getMessage('IP_NOT_INSTALLED','SM'));
<%					}
					else %>
						alert(getMessage('IP_NOT_INSTALLED','SM'));
<%				}
				else if(common.trim().equals("P"))
				{
					%>
					document.forms[0].dest_locn_code1.value='';
					document.forms[0].dest_locn_code1.disabled = true;			   
					document.forms[0].dest_locn_code.disabled = false;			   
										
					var tp =" -------"+getLabel("Common.defaultSelect.label","Common")+" -------";
					var opt=document.createElement("OPTION");
					opt.text=tp;
					opt.value="";
					document.forms[0].dest_locn_code.add(opt);		

					var tp1 ="*"+getLabel("Common.all.label","Common");
					var opt=document.createElement("OPTION");
					opt.text=tp1;
					opt.value="*A";
					document.forms[0].dest_locn_code.add(opt);
				<%			
					sql = "select INSTALL_YN from sm_module where MODULE_ID='PH' " ;
					if(rset!=null)rset.close();
					rset = stmt1.executeQuery(sql);
					if(rset.next())
					{
						String installyn = rset.getString("INSTALL_YN");
						if(installyn.equals("Y"))
						{
							sql= "select DISP_LOCN_CODE PHARMACY_CODE,SHORT_DESC PHARMACY_DESC from ph_disp_locn where EFF_STATUS = 'E' and facility_id = '"+facid.trim()+"' order by SHORT_DESC";	
							if(rset!=null)rset.close();
							rset = stmt1.executeQuery(sql);			
							if(rset != null)
							{
								while( rset.next() ) 
								{
									code = rset.getString( "PHARMACY_CODE" ) ;	
									desc = rset.getString( "PHARMACY_DESC" ) ;	
								%>		
									var temp = "<%=code%>";
									var opt=document.createElement("OPTION");
									opt.text= "<%=desc%>";
									opt.value=temp;
									document.forms[0].dest_locn_code.add(opt);
								<%				   	  
								}	
		    				}
		 					
					   }
					   else %>
						   alert(getMessage('PH_NOT_INSTALLED','SM'));
					<%
					 }
						else %>
							alert(getMessage('PH_NOT_INSTALLED','SM'));
				<%
				}
				else if(common.trim().equals("S"))
				{
					
					%>
					document.forms[0].dest_locn_code1.value='';
					document.forms[0].dest_locn_code1.disabled = true;			   
					document.forms[0].dest_locn_code.disabled = false;			   
										
					var tp =" -------"+getLabel("Common.defaultSelect.label","Common")+" -------";
					var opt=document.createElement("OPTION");
					opt.text=tp;
					opt.value="";
					document.forms[0].dest_locn_code.add(opt);		

					var tp1 ="*"+getLabel("Common.all.label","Common");
					var opt=document.createElement("OPTION");
					opt.text=tp1;
					opt.value="*A";
					document.forms[0].dest_locn_code.add(opt);
					<%			

					sql = "select INSTALL_YN from sm_module where MODULE_ID='ST' " ;
					if(rset!=null)rset.close();
					rset = stmt1.executeQuery(sql);
					if(rset.next())
					{
						String installyn = rset.getString("INSTALL_YN");
						if(installyn.equals("Y"))
						{
						
							sql= "select store_code, short_desc from mm_store where eff_status = 'E' and facility_id = '"+facid.trim()+"' order by SHORT_DESC";	
							if(rset!=null)rset.close();
							rset = stmt1.executeQuery(sql);			
							if(rset != null)
							{
								while( rset.next() ) 
								{
									code = rset.getString( "store_code" ) ;	
									desc = rset.getString( "short_desc" ) ;	
									%>		
									var temp = "<%=code%>";
									var opt=document.createElement("OPTION");
									opt.text= "<%=desc%>";
									opt.value=temp;
									document.forms[0].dest_locn_code.add(opt);
									<%				   	  
								}
							}							
						}
						else %>
							alert(getMessage('ST_NOT_INSTALLED','SM'));
				<%	}
					else %>
						alert(getMessage('ST_NOT_INSTALLED','SM'));
			<%	}
				else if(common.trim().equals("O"))
				{
					%>
					document.forms[0].dest_locn_code1.value='';
					document.forms[0].dest_locn_code1.disabled = true;			   
					document.forms[0].dest_locn_code.disabled = false;			   
										
					var tp =" -------"+getLabel("Common.defaultSelect.label","Common")+" -------";
					var opt=document.createElement("OPTION");
					opt.text=tp;
					opt.value="";
					document.forms[0].dest_locn_code.add(opt);		

					var tp1 ="*"+getLabel("Common.all.label","Common");
					var opt=document.createElement("OPTION");
					opt.text=tp1;
					opt.value="*A";
					document.forms[0].dest_locn_code.add(opt);
					<%			

					sql = "select INSTALL_YN from sm_module where MODULE_ID='OR' " ;
					if(rset!=null)rset.close();
					rset = stmt1.executeQuery(sql);
					if(rset.next())
					{
						String installyn = rset.getString("INSTALL_YN");
						if(installyn.equals("Y"))
						{
							sql= "select SERVICE_LOCATION_CODE, SHORT_DESC from or_service_location where eff_status = 'E'  order by SHORT_DESC";	
							if(rset!=null)rset.close();
							rset = stmt1.executeQuery(sql);			
							if(rset != null)
							{
								while( rset.next() ) 
								{
									code = rset.getString( "SERVICE_LOCATION_CODE" ) ;	
									desc = rset.getString( "SHORT_DESC" ) ;	
									%>										
									var temp = "<%=code%>";
									var opt=document.createElement("OPTION");
									opt.text= "<%=desc%>";
									opt.value=temp;
									document.forms[0].dest_locn_code.add(opt);
									<%				   	  
								}
							}							
						}
						else %>
							alert(getMessage('OR_NOT_INSTALLED','SM'));
				<%	}
					else %>
						alert(getMessage('OR_NOT_INSTALLED','SM'));
			<%	}
				else if(common.trim().equals("E"))
				{
					%>
					document.forms[0].dest_locn_code1.value='';
					document.forms[0].dest_locn_code1.disabled = true;			   
					document.forms[0].dest_locn_code.disabled = false;			   
										
					var tp =" -------"+getLabel("Common.defaultSelect.label","Common")+" -------";
					var opt=document.createElement("OPTION");
					opt.text=tp;
					opt.value="";
					document.forms[0].dest_locn_code.add(opt);					

					var tp1 ="*"+getLabel("Common.all.label","Common");
					var opt=document.createElement("OPTION");
					opt.text=tp1;
					opt.value="*A";
					document.forms[0].dest_locn_code.add(opt);
			<%			

					sql = "select INSTALL_YN from sm_module where MODULE_ID='OP' " ;
					if(rset!=null)rset.close();
					rset = stmt1.executeQuery(sql);
					sql="";
					if(rset.next())
					{
						String installyn = rset.getString("INSTALL_YN");
						if(installyn.equals("Y"))
						{
							

							if(mod_id.equals("AE")){								
								sql= "select clinic_code,short_desc  from op_clinic where eff_status='E' and facility_id='"+facid.trim()+"' and sysdate between nvl(eff_date_from,to_date('01/01/1472','dd/mm/rrrr')) and nvl(eff_date_to,to_date('31/12/5000','dd/mm/rrrr')) and care_locn_type_ind = 'E' and LEVEL_OF_CARE_IND='E' order by short_desc "; 
							}else{
								sql= "select clinic_code,short_desc  from op_clinic where eff_status='E' and facility_id='"+facid.trim()+"' and sysdate between nvl(eff_date_from,to_date('01/01/1472','dd/mm/rrrr')) and nvl(eff_date_to,to_date('31/12/5000','dd/mm/rrrr')) and care_locn_type_ind = 'E' and LEVEL_OF_CARE_IND in('A','E') order by short_desc "; 
							}


							rs = stmt2.executeQuery(sql);			
							sql="";
							if(rs != null)
							{
								while( rs.next() ) 
								{
									code = rs.getString( "clinic_code" ) ;	
									desc = rs.getString( "short_desc" ) ;	
	%>					
									var temp = "<%=code%>";
									var opt=document.createElement("OPTION");
									opt.text= "<%=desc%>";
									opt.value=temp;
									document.forms[0].dest_locn_code.add(opt);
	<%				   	  
								}
							}if(rs!=null)rs.close();
						}
						else %>
							alert(getMessage('OP_NOT_INSTALLED','SM'));
	<%				}
					else
					{ %>
						alert(getMessage('OP_NOT_INSTALLED','SM'));
<%					}

				}
				else if(common.trim().equals("Y"))
				{
					%>
					document.forms[0].dest_locn_code1.value='';
					document.forms[0].dest_locn_code1.disabled = true;			   
					document.forms[0].dest_locn_code.disabled = false;			   
										
				var tp =" -------"+getLabel("Common.defaultSelect.label","Common")+" -------";
					var opt=document.createElement("OPTION");
					opt.text=tp;
					opt.value="";
					document.forms[0].dest_locn_code.add(opt);					

					var tp1 ="*"+getLabel("Common.all.label","Common");
					var opt=document.createElement("OPTION");
					opt.text=tp1;
					opt.value="*A";
					document.forms[0].dest_locn_code.add(opt);
			<%			

					sql = "select INSTALL_YN from sm_module where MODULE_ID='OP' " ;
					if(rset!=null)rset.close();
					rset = stmt1.executeQuery(sql);
					sql="";
					if(rset.next())
					{
						String installyn = rset.getString("INSTALL_YN");
						if(installyn.equals("Y"))
						{
							
							if(mod_id.equals("AE")){
								sql= "select clinic_code,short_desc  from op_clinic where eff_status='E' and facility_id='"+facid.trim()+"' and sysdate between nvl(eff_date_from,to_date('01/01/1472','dd/mm/rrrr')) and nvl(eff_date_to,to_date('31/12/5000','dd/mm/rrrr')) and care_locn_type_ind = 'D' and LEVEL_OF_CARE_IND='E' order by short_desc "; 
							}else{
								sql= "select clinic_code,short_desc  from op_clinic where eff_status='E' and facility_id='"+facid.trim()+"' and sysdate between nvl(eff_date_from,to_date('01/01/1472','dd/mm/rrrr')) and nvl(eff_date_to,to_date('31/12/5000','dd/mm/rrrr')) and care_locn_type_ind = 'D' and LEVEL_OF_CARE_IND in('A','E') order by short_desc "; 
							}

					
							rs = stmt2.executeQuery(sql);			
							sql="";
							if(rs != null)
							{
								while( rs.next() ) 
								{
									code = rs.getString( "clinic_code" ) ;	
									desc = rs.getString( "short_desc" ) ;	
	%>					
									var temp = "<%=code%>";
									var opt=document.createElement("OPTION");
									opt.text= "<%=desc%>";
									opt.value=temp;
									document.forms[0].dest_locn_code.add(opt);
	<%				   	  
								}
							}if(rs!=null)rs.close();
						}
						else %>
							alert(getMessage('OP_NOT_INSTALLED','SM'));
	<%				}
					else
					{ %>
						alert(getMessage('OP_NOT_INSTALLED','SM'));
<%					}

				}
				else if(common.trim().equals("F"))
				{
					%>
					document.forms[0].dest_locn_code1.value='';
					document.forms[0].dest_locn_code1.disabled =true ;			   
					document.forms[0].dest_locn_code.disabled = false;			   
										
					var tp =" -------"+getLabel("Common.defaultSelect.label","Common")+" -------";
					var opt=document.createElement("OPTION");
					opt.text=tp;
					opt.value="";
					document.forms[0].dest_locn_code.add(opt);					

					var tp1 ="*"+getLabel("Common.all.label","Common");
					var opt=document.createElement("OPTION");
					opt.text=tp1;
					opt.value="*A";
					document.forms[0].dest_locn_code.add(opt);
			<%			

					sql = "select INSTALL_YN from sm_module where MODULE_ID='FM' " ;
					if(rset!=null)rset.close();
					rset = stmt1.executeQuery(sql);
					sql="";
					if(rset.next())
					{
						String installyn = rset.getString("INSTALL_YN");
						if(installyn.equals("Y"))
						{
				
					sql="SELECT fs_locn_code, short_desc long_desc FROM fm_storage_locn WHERE eff_status = 'E' AND mr_locn_yn='Y' AND permanent_file_area_yn = 'Y' and  facility_id = '"+facid.trim()+"' ORDER BY 2";
							rs = stmt2.executeQuery(sql);			
							sql="";
							if(rs != null)
							{
								while( rs.next() ) 
								{
									code = rs.getString( "fs_locn_code") ;	
									desc = rs.getString( "long_desc") ;	
	%>					
									var temp ="<%=code%>";
									var opt=document.createElement("OPTION");
									opt.text= "<%=desc%>";
									opt.value=temp;
									document.forms[0].dest_locn_code.add(opt);
	<%				   	  
								}
							}if(rs!=null)rs.close();
						}
						else %>
							alert(getMessage('FM_NOT_INSTALLED','FM'));
	<%				}
					else
					{ %>
						alert(getMessage('FM_NOT_INSTALLED','FM'));
<%					}

				}else if(common.trim().equals("R"))	{
				
					%>
					document.forms[0].dest_locn_code1.value='';
					document.forms[0].dest_locn_code1.disabled =true ;			   
					document.forms[0].dest_locn_code.disabled = false;			   
										
					var tp =" -------"+getLabel("Common.defaultSelect.label","Common")+" -------";
					var opt=document.createElement("OPTION");
					opt.text=tp;
					opt.value="";
					document.forms[0].dest_locn_code.add(opt);					

					var tp1 ="*"+getLabel("Common.all.label","Common");
					var opt=document.createElement("OPTION");
					opt.text=tp1;
					opt.value="*A";
					document.forms[0].dest_locn_code.add(opt);
			<%			

								
					sql=" SELECT referral_code , long_desc short_desc   FROM am_referral  WHERE  eff_status = 'E' AND NVL (applicability_for_direct_ord, 'N') != 'N'    ORDER BY 2";

					
							rs = stmt2.executeQuery(sql);			
							sql="";
							if(rs != null)
							{
								while( rs.next() ) 
								{
									code = rs.getString( "referral_code") ;	
									desc = rs.getString( "short_desc") ;	
	%>					
									//var temp ="<%=code%>";
									var opt=document.createElement("OPTION");
									opt.text= "<%=desc%>";
									opt.value="<%=code%>";
									document.forms[0].dest_locn_code.add(opt);
	<%				   	  
								}
							}
							
							if(rs!=null)rs.close();
						

				}else
		   		{
					//modified by Chitra on 11/9/2001	
					%>				
					document.forms[0].dest_locn_code1.disabled = false;		
					document.forms[0].dest_locn_code.disabled = true;		
					document.getElementById('locnimg').style.visibility = 'hidden';					
					if(document.forms[0].dest_locn_type.value != 'L')
						document.getElementById('locnimg1').style.visibility = 'hidden';
					else
					   document.getElementById('locnimg1').style.visibility = 'visible';
<%	
				}
			}
			else if(chksrc.trim().equals("five"))
			{

	    		String sql1= "select dflt_report_mode from sm_report where module_id='" + common.trim() + "'and report_id='"+ common1.trim() +"'";
				
				if(rset!=null)rset.close();
				rset = stmt1.executeQuery(sql1);
		   		out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='nam1' id='nam1'>");
				if(rset != null)
				{
				        while( rset.next() )
				        {
				        	moduleid = rset.getString( "dflt_report_mode" ) ;

						if(moduleid.equals("B"))
						{

%>

					<script>
						var opt=parent.document.frames[1].document.createElement("OPTION");
						opt.text="BitMap";
						opt.value="B";
						parent.document.frames[1].document.forms[0].dflt_report_mode.add(opt);

						var opt=parent.document.frames[1].document.createElement("OPTION");
						opt.text="Character";
						opt.value="C";
						parent.document.frames[1].document.forms[0].dflt_report_mode.add(opt);

					</script>
<%
						}
						else
						{

%>
					<script>

						var opt=parent.document.frames[1].document.createElement("OPTION");
						opt.text=getLabel("eSM.Character.label","SM");
						opt.value="C";
						parent.document.frames[1].document.forms[0].dflt_report_mode.add(opt);

						var opt=parent.document.frames[1].document.createElement("OPTION");
						opt.text=getLabel("eSM.Bitmap.label","SM");
						opt.value="B";
						parent.document.frames[1].document.forms[0].dflt_report_mode.add(opt);


					</script>


<%


						}

					}
				 }
				 out.println("</form></body></html>");



			}else if(chksrc.trim().equals("six")){

		    		String common2=request.getParameter("Common_Text2");

				out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='nam1' id='nam1'>");
		    		if(common.trim().equals("B"))
		    		{

		    			String sql1= "select executable_name_bm from sm_report where module_id='" + common1.trim() + "'and report_id='"+ common2.trim() +"'";
					if(rset!=null)rset.close();
					rset = stmt1.executeQuery(sql1);

					if(rset.getString("executable_name_bm")==null)
					{
%>
					<script>

						var n=parent.document.frames[1].document.forms[0].dflt_report_mode.options.length;
						for(var i=0;i<n;i++)
						{
							parent.document.frames[1].document.forms[0].dflt_report_mode.remove("dflt_report_mode");
						}

						var opt=parent.document.frames[1].document.createElement("OPTION");
						opt.text=getLabel("eSM.Character.label","SM");
						opt.value="C";
						parent.document.frames[1].document.forms[0].dflt_report_mode.add(opt);

						var opt=parent.document.frames[1].document.createElement("OPTION");
						opt.text=getLabel("eSM.Bitmap.label","SM");
						opt.value="B";
						parent.document.frames[1].document.forms[0].dflt_report_mode.add(opt);



					</script>

<%

					}
					else
					{
%>

					<script>

						var n=parent.document.frames[1].document.forms[0].dflt_report_mode.options.length;
						for(var i=0;i<n;i++)
						{
							parent.document.frames[1].document.forms[0].dflt_report_mode.remove("dflt_report_mode");
						}

						var opt=parent.document.frames[1].document.createElement("OPTION");
						opt.text=getLabel("eSM.Bitmap.label","SM");
						opt.value="B";
						parent.document.frames[1].document.forms[0].dflt_report_mode.add(opt);

						var opt=parent.document.frames[1].document.createElement("OPTION");
						opt.text=getLabel("eSM.Character.label","SM");
						opt.value="C";
						parent.document.frames[1].document.forms[0].dflt_report_mode.add(opt);

					</script>


<%			}
		}else if(common.trim().equals("C"))
   		{

		    			String sql1= "select executable_name_ch from sm_report where module_id='" + common1.trim() + "'and report_id='"+ common2.trim() +"'";
					if(rset!=null)rset.close();
					rset = stmt1.executeQuery(sql1);
		   			rset.next();
					if((rset.getString("executable_name_ch")==null ))
					{


%>

					<script>

						var n=parent.document.frames[1].document.forms[0].dflt_report_mode.options.length;
						for(var i=0;i<n;i++)
						{
							parent.document.frames[1].document.forms[0].dflt_report_mode.remove("dflt_report_mode");
						}

						var opt=parent.document.frames[1].document.createElement("OPTION");
						opt.text=getLabel("eSM.Bitmap.label","SM");
						opt.value="B";
						parent.document.frames[1].document.forms[0].dflt_report_mode.add(opt);

						var opt=parent.document.frames[1].document.createElement("OPTION");
						opt.text=getLabel("eSM.Character.label","SM");
						opt.value="C";
						parent.document.frames[1].document.forms[0].dflt_report_mode.add(opt);

					</script>

<%

					}
					else
					{
%>

					<script>
						var n=parent.document.frames[1].document.forms[0].dflt_report_mode.options.length;
						for(var i=0;i<n;i++)
						{
							parent.document.frames[1].document.forms[0].dflt_report_mode.remove("dflt_report_mode");
						}

						var opt=parent.document.frames[1].document.createElement("OPTION");
						opt.text=getLabel("eSM.Character.label","SM");
						opt.value="C";
						parent.document.frames[1].document.forms[0].dflt_report_mode.add(opt);

						var opt=parent.document.frames[1].document.createElement("OPTION");
						opt.text=getLabel("eSM.Bitmap.label","SM");
						opt.value="B";
						parent.document.frames[1].document.forms[0].dflt_report_mode.add(opt);

				       </script>

<%			}
				}
			 out.println("</form></body></html>");
			}
			else if(chksrc.trim().equals("seven")) 
			{
				String dev_tool="";
				//String sys_defined_yn ="";
		
			//	String rootsql=" select ROOT_MENU_YN,dev_tool,sys_defined_yn  from sm_menu_hdr  where MENU_ID='" + common.trim() + "' ";

			/*Above query Commented by Senthil on 11-10-2011 incident[27210]*/

				String rootsql=" select ROOT_MENU_YN,dev_tool from sm_menu_hdr  where MENU_ID='" + common.trim() + "' ";
				
				rootrset=rootstmt.executeQuery(rootsql);
				if(rootrset.next()) {
						root_yn = rootrset.getString(1);
						dev_tool=rootrset.getString(2);
						//sys_defined_yn =rootrset.getString("sys_defined_yn");
				}
				/*Commented by Senthil on 11-10-2011 incident[27210]*/
                //if(sys_defined_yn.equals("Y")){
					%>
						//	alert(getMessage('CANT_MODIFY_MENU','SM'));
					//parent.frames[1].document.forms[0].Menu.options(0).selected=true;
					
					<%
				//}else{
				/*commented End*/
				String countsql="select count(*) from Sm_Menu_Dtl where Menu_Id='" + common.trim() + "'";
				rset1=stmt1.executeQuery(countsql);
				if(rset1.next()) {
					int row=rset1.getInt(1);

					if(rset1!=null)rset1.close();
					array=new String[row][6];
					if(row==0) 
					{%>
						document.forms[0].norows.value='N';
					<%}
					else
					{%>
						document.forms[0].norows.value='Y';
					<%
					}

				}
				String sql = "select menu_id,option_type,module_id,function_id,submenu_id,option_descriptor from Sm_Menu_Dtl where Menu_Id='" + common.trim() + "' order by option_sequence_no, srl_no"; 
				
				/*Above query modified for this incident RUT-SCF-0252 [IN:038574] */
				
				
				
				rset = stmt1.executeQuery(sql);
		   		
				if(rset != null) 
				{
					int row=0;
				    while( rset.next() ) 
					{
						array[row][0]=rset.getString(1);
						array[row][1]=rset.getString(2);
						array[row][2]=rset.getString(3);
						array[row][3]=rset.getString(4);
						array[row][4]=rset.getString(5);
						array[row][5]=rset.getString(6);
						row++;
					}
				}
				for(int i=0;i<array.length;i++) 
				{
					menu_id = array[i][0]==null ? "" : array[i][0];
					option_type = array[i][1]==null ? "" : array[i][1];
					module_id = array[i][2]==null ? "" : array[i][2];
					function_id = array[i][3]==null ? "" : array[i][3];
					submenu_id = array[i][4]==null ? "" : array[i][4];
					option_descriptor = array[i][5]==null ? "" : array[i][5];
%>
		
					var rootyn= '<%=root_yn%>';
					var spc="" ;
					document.forms[0].root_menu.value = rootyn;
					var opt=document.createElement("OPTION");
					var opt_type="<%=option_type%>";
					if(document.forms[0].root_menu.value == 'N')
							spc="              " ;
					if(opt_type=="F") opt.text= spc  +  "<%=option_descriptor%>" ;
					else opt.text= spc  +"<%=option_descriptor%>" ;
					opt.value="<%=menu_id%>" + "#" + "<%=module_id%>" + "#" + "<%=function_id%>" + "#" + "<%=submenu_id%>" + "#" + opt_type ;
					document.forms[0].MainMenus.add(opt);
<%
					String colour = "";
					String sql1 = "select menu_id,option_type,module_id,function_id,submenu_id,option_descriptor from Sm_Menu_Dtl where Menu_Id='" + submenu_id.trim() + "' order by option_sequence_no,srl_no";
					
					rset1 = stmt1.executeQuery(sql1);

					if(rset1 != null) {
						while( rset1.next() ) {
							menu_id = rset1.getString( "menu_id" )==null ? "" :  rset1.getString( "menu_id" );
							option_type = rset1.getString( "option_type" )==null ? "" :  rset1.getString( "option_type" );
							module_id = rset1.getString("module_id")==null ? "" : rset1.getString("module_id");
							function_id = rset1.getString("function_id")==null ? "" : rset1.getString("function_id");
							submenu_id = rset1.getString("submenu_id")==null ? "" : rset1.getString("submenu_id");
							option_descriptor = rset1.getString( "option_descriptor" )==null ? "" : rset1.getString( "option_descriptor" );
							if(submenu_id == null || submenu_id.equals(""))
								colour = "";
							else{
								colour="RED";
								option_type="S";
							}
%>

								var spc="             ";
								var opt=document.createElement("OPTION");
								if(document.forms[0].root_menu.value == 'N')
								spc="                        ";
								var opt_type="<%=option_type%>";
								if(opt_type=="F") opt.text= spc +  "<%=option_descriptor%>" ;
								else opt.text=spc +"<%=option_descriptor%>" ;
								opt.style.color="<%=colour%>";
								opt.value="<%=menu_id%>" + "#" + "<%=module_id%>" + "#" + "<%=function_id%>" + "#" + "<%=submenu_id%>" + "#" + opt_type ;
								document.forms[0].MainMenus.add(opt);
<%
						%>

						<%
								while(!(submenu_id.equals("") || submenu_id == null ))
								{
									cntr=0;
									String subsql = "select menu_id,option_type,module_id,function_id,submenu_id,option_descriptor from Sm_Menu_Dtl where Menu_Id='" + submenu_id.trim() + "' order by option_sequence_no,srl_no";
									
									myrset = mystmt.executeQuery(subsql);
									//if(myrset != null) {
									
										//while( myrset.next() ) {
										
										while(myrset!=null && myrset.next()){
											cntr=cntr++;
											menu_id = myrset.getString( "menu_id" )==null ? "" :  myrset.getString( "menu_id" );
											option_type = myrset.getString( "option_type" )==null ? "" :  myrset.getString( "option_type" );
											module_id = myrset.getString("module_id")==null ? "" : myrset.getString("module_id");
											function_id = myrset.getString("function_id")==null ? "" : myrset.getString("function_id");
											submenu_id = myrset.getString("submenu_id")==null ? "" : myrset.getString("submenu_id");
											option_descriptor = myrset.getString( "option_descriptor" )==null ? "" : myrset.getString( "option_descriptor" );
											if(!(submenu_id == null || submenu_id.equals("")))
											{ %> spc+="              ";<%}

				%>
											var opt=document.createElement("OPTION");
												var opt_type="<%=option_type%>";
												if(opt_type=="F") opt.text= spc +"              "+ "<%=option_descriptor%>" ;
												else opt.text=spc+"<%=option_descriptor%>" ;
												opt.value="<%=menu_id%>" + "#" + "<%=module_id%>" + "#" + "<%=function_id%>" + "#" + "<%=submenu_id%>" + "#" + "S" ;
												document.forms[0].MainMenus.add(opt);
				<%
										}
									//}
									if(myrset != null) myrset.close();
									%> 
									spc+="              ";
									<%
									if(cntr==0){
										break;
									}
								}// end while
						}
					}if(rset1!=null)rset1.close();
					}
			String Role="";
		
			try{
			String sqlResp="select ora_role_id  from sm_resp  where resp_id='"+responsibility_id+"'";
			ResultSet rsResp=stmt.executeQuery(sqlResp);
			if (rsResp !=null)
			{
				while (rsResp.next())
				{
					Role=rsResp.getString(1);
					if(Role==null) Role="";
				}
			}
			
			if(rsResp!=null)rsResp.close();
			}//try
			catch(Exception ee){
			out.println(ee.toString());
			ee.printStackTrace();
			}
				StringBuffer sql1=new StringBuffer();
				//if (Role.equalsIgnoreCase("MEDADMIN"))
				//{
					if(dev_tool.equals("F"))
					sql1.append("select menu_id,menu_name from sm_menu_hdr where root_menu_yn='N' and menu_id <> '" + common.trim() + "' and dev_tool='"+dev_tool+"' order by menu_name");
					else
					sql1.append("select menu_id,menu_name from sm_menu_hdr where root_menu_yn='N' and menu_id <> '" + common.trim() + "' order by menu_name");
				/*}
				else
				{
					if(dev_tool.equals("F"))
					{
					sql1.append("select  a.menu_id,a.menu_name  from sm_menu_hdr a");
					sql1.append("  where ");
					sql1.append("  a.menu_id <> '"+ common.trim()+"' and dev_tool='"+dev_tool+"' and a.root_menu_yn='N' and a.resp_group_id in (select  resp_group_id  from sm_menu_admin where menu_admin_id='"+Log_user+"')  order by a.menu_name");
					}
					else
					{
					sql1.append("select  a.menu_id,a.menu_name  from sm_menu_hdr a");
					sql1.append("  where ");
					sql1.append("  a.menu_id <> '"+ common.trim()+"'  and a.root_menu_yn='N' and a.resp_group_id in (select  resp_group_id  from sm_menu_admin where menu_admin_id='"+Log_user+"')  order by a.menu_name");
					
					}
				}*/

				
				rset1 = stmt1.executeQuery(sql1.toString());
				if(rset1 != null) {
				        while( rset1.next() ) {
				        	menu_id = rset1.getString( "menu_id" ) ;
				        	String menu_name = rset1.getString( "menu_name" ) ;
%>

					var opt=document.createElement("OPTION");
					//commanded and Added below line by Senthil on 10-Oct-2011 for this incident[IN:027210] 
					//opt.text=  "<%=menu_name%>" ;					
					opt.text=  "<%=menu_name%>"+" ["+"<%=menu_id%>"+"]" ;
					opt.value="" + "#" + "" + "#" + "<%=menu_id%>" + "#" + "M";					
					document.forms[0].SubMenus.add(opt);
					
<%
					}
				 }
			   //}
			}

			//This is for Menu Details
			else if(chksrc.trim().equals("eight")) 
			{
				String menuID = request.getParameter("menuID");
				if(menuID == null) menuID="";
				module_id=common.trim();
				String Role="";
				StringBuffer sqlfun=new StringBuffer();
				String sqlResp="select ora_role_id  from sm_resp  where resp_id='"+responsibility_id+"'";
				ResultSet rsResp=stmt.executeQuery(sqlResp);
				if (rsResp !=null)
				{
					while (rsResp.next())
					{
						Role=rsResp.getString(1);
						if(Role==null) Role="";
					}
				}if(rsResp!=null)rsResp.close();
				String sql12=" select dev_tool from sm_menu_hdr where menu_id = '"+menuID+"' ";
			    java.sql.Statement stmt12=con.createStatement();
				ResultSet rset12 = stmt12.executeQuery(sql12);
				String devTool="";
				if(rset12.next())
					devTool=rset12.getString(1);
			    if(rset12 !=null)rset12.close();
				if(stmt12 != null) stmt12.close();
			
				//if (Role.equalsIgnoreCase("MEDADMIN"))
				//{
					if(devTool.equals("F"))
					sqlfun.append("select function_id,function_name,function_type from Sm_Function where module_id='" + module_id + "' and dev_tool = '"+devTool+"' order by function_name");
					else
					sqlfun.append("select function_id,function_name,function_type from Sm_Function where module_id='" + module_id + "'  order by function_name");
			/*	}
				else
				{
					if(devTool.equals("F"))
					{
					sqlfun.append("select a.FUNCTION_ID,a.FUNCTION_NAME,a.function_type  from Sm_Function a");
					sqlfun.append(",sm_func_by_resp_grp b where a.function_id=b.function_id ");
					sqlfun.append(" and b.resp_group_id in (select  resp_group_id  from sm_menu_admin where menu_admin_id='"+Log_user+"')");
					sqlfun.append(" and a.module_id='"+module_id+"' and dev_tool = '"+devTool+"'");
					}
					else
					{
					sqlfun.append("select a.FUNCTION_ID,a.FUNCTION_NAME,a.function_type  from Sm_Function a");
					sqlfun.append(",sm_func_by_resp_grp b where a.function_id=b.function_id ");
					sqlfun.append(" and b.resp_group_id in (select  resp_group_id  from sm_menu_admin where menu_admin_id='"+Log_user+"')");
					sqlfun.append(" and a.module_id='"+module_id+"' ");
					}

				}*/
				
				if(rset!=null)rset.close();
				rset = stmt1.executeQuery(sqlfun.toString());
				if(rset != null) {
			        while( rset.next() ) {
			        	String function_name = rset.getString( "function_name" ) ;
			        	function_id = rset.getString( "function_id" ) ;
						String function_type=rset.getString( "function_type" ) ;
%>
						var opt=document.createElement("OPTION");						
						opt.text=  "<%=function_name%>" ;						
						opt.value= "<%=module_id%>" + "#" + "<%=function_id%>" + "#" + "" + "#" + "<%=function_type%>";
						document.forms[0].Functions.add(opt);
<%
					}
				 }
			}
			else if(chksrc.trim().equals("nine")) 
			{
				int index=Integer.parseInt((String) hash.get("Index"));
				String minus="F";
				if(index==-1) minus="T";


				String sql1 = "select menu_id,option_type,module_id,function_id,submenu_id,option_descriptor from Sm_Menu_Dtl where Menu_Id='" + common.trim() + "' order by option_sequence_no,srl_no";
				if(rset1!=null)rset1.close();
				rset1 = stmt1.executeQuery(sql1);
					if( rset1.next() ) {
					do{
						menu_id = rset1.getString( "menu_id" )==null ? "" :  rset1.getString( "menu_id" );
						option_type = rset1.getString( "option_type" )==null ? "" :  rset1.getString( "option_type" );
						module_id = rset1.getString("module_id")==null ? "" : rset1.getString("module_id");
						function_id = rset1.getString("function_id")==null ? "" : rset1.getString("function_id");
						submenu_id = rset1.getString("submenu_id")==null ? "" : rset1.getString("submenu_id");
						option_descriptor = rset1.getString( "option_descriptor" )==null ? "" : rset1.getString( "option_descriptor" );
%>						
						var spc="             ";
						var opt=document.createElement("OPTION");
						if(document.forms[0].root_menu.value == 'N')
							spc="                        ";
							var indx=<%=index%>;
							var n="<%=minus%>";
							var opt_type="<%=option_type%>";
							if(opt_type=="F"){
								opt.text=spc+ "<%=option_descriptor%>" ;
								opt.value="<%=menu_id%>" + "#" + "<%=module_id%>" + "#" + "<%=function_id%>" + "#" + "<%=submenu_id%>" + "#" + opt_type ;
								
							}
							else {
								opt.text=spc+"<%=option_descriptor%>" ;
								opt.style.color="RED";
								opt.value="<%=menu_id%>" + "#" + "<%=module_id%>" + "#" + "<%=function_id%>" + "#" + "<%=submenu_id%>" + "#" + "S" ;
								
							}
							 if(n=="T") document.forms[0].MainMenus.add(opt);
							else document.forms[0].MainMenus.add(opt,indx+1); 
							
							

						
<%
					index++;
					}while(rset1.next());	
			
					}
					else
					{
						index--;
						%>
						<script>
						
						document.frames[1].Delete('<%=index%>');
						
						alert(top.header.getMessage('CANNOT_ATTACH_SUBMENU','SM'));
						</script>
					<%}
			}
			else 
			{
		    	String sql = "select Report_Id,Report_Desc from Sm_Report where facility_based_YN ='Y' and Module_Id='" + common.trim()+"' order by Report_Desc";
				if(rset!=null)rset.close();
				rset = stmt1.executeQuery(sql);		   		
				if(rset != null) {
%>
					var tp ="----"+getLabel("Common.defaultSelect.label","Common")+"----";
					var opt=document.createElement("OPTION");
					opt.text=tp;
					opt.value="";
					document.forms[0].Report_Id.add(opt);
					<%
				    while( rset.next() ) {
				       	String reportid = rset.getString( "Report_Id" ) ;
				       	String reportdesc = rset.getString( "Report_Desc" );
						%>
						var opt=document.createElement("OPTION");
						opt.text=  "<%=reportdesc%>" ;
						opt.value="<%=reportid%>";
						document.forms[0].Report_Id.add(opt);
						<%
					}
				 }
			}
			hash.clear();
			if(rset != null) rset.close();
			if(rset1 != null) rset1.close();
			
			if(rootrset!=null)rootrset.close();
			if(stmt != null) stmt.close();
			if(stmt1 != null) stmt1.close();
			if(stmt2 != null) stmt2.close();
			
			
			if(mystmt != null) mystmt.close();
			if(rootstmt !=null) rootstmt.close();

		}catch(Exception e){
			out.println(e);
			e.printStackTrace();
			}
		finally { 
			ConnectionManager.returnConnection(con,request);
		}
%>

