<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
         request.setCharacterEncoding("UTF-8");
		Connection con = null;
		try
		{

			con = ConnectionManager.getConnection(request);

			Hashtable hash = (Hashtable)obj.parseXMLString( request ) ;
		 	hash = (Hashtable)hash.get("SEARCH") ;

			String facilityId = (String) session.getValue("facility_id");
			java.sql.Statement stmt1 = con.createStatement();
			java.sql.Statement stmt2 = con.createStatement();
			ResultSet rset=null;
			ResultSet rs=null;
			String moduleid="";
			String moduledesc="";
			String chksrc = (String) hash.get("Chksrc") ;
			if(chksrc == null) chksrc="";
			String common = (String) hash.get("Common_Text") ;
			if(common == null) common="";
			String common1 = (String) hash.get("Common_Text1") ;
			if(common1 == null) common1="";			
			
	    	if(chksrc.trim().equals("one"))   	{
				
				
		    	
		    	String sql = "select report_id,report_desc from sm_report where module_id='" + common.trim() + "' order by report_desc";
				rset = stmt1.executeQuery(sql);			
				if(rset != null) 			
				{
%>
					document.getElementById('locnimg').style.visibility = 'hidden';
					document.getElementById('locnimg1').style.visibility = 'hidden';				
					var tp ="  --------------------------------- Select ---------------------------------  ";
					var opt=document.createElement("OPTION");
					opt.text=tp;
					opt.value="";
					document.forms[0].report_id.add(opt);					

					var facility =" ---------- Select ---------- ";
					var opt=document.createElement("OPTION");
					opt.text=facility;
					opt.value="";
					document.forms[0].facility_id.add(opt);

					var dest_locn_type =" -- Select -- ";
					var opt=document.createElement("OPTION");
					opt.text=dest_locn_type;
					opt.value="";
					document.forms[0].dest_locn_type.add(opt);
					
					var dest_locn_code =" ---------- Select ---------- ";
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
<%			   	  
					}
				 if(rset!=null)rset.close();
				 if(stmt1!=null)stmt1.close();
				 }
			}			
			else if(chksrc.trim().equals("two")) 
			{
				String sql="SELECT FACILITY_BASED_YN,TRANSACTION_BASED_YN FROM SM_REPORT WHERE REPORT_ID='"+ common1.trim() +"'";

				stmt1 = con.createStatement();
				rset = stmt1.executeQuery(sql);			
				out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script></HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='nam1' id='nam1'>");
				if(rset.next())
				{
					String str=rset.getString("FACILITY_BASED_YN").trim();
					
					if (str.equals("N"))
					{
%>
				<script>
						
				var n=parent.document.frames[1].document.forms[0].facility_id.options.length;
				for(var i=0;i<n;i++)
				{
					parent.document.frames[1].document.forms[0].facility_id.remove("facility_id");
				}							
					
				parent.document.frames[1].document.forms[0].facility_id.disabled = true;


				</script>
<%				
					}
					else
					{
%>					
				<script>
				
						
						var n=parent.document.frames[1].document.forms[0].facility_id.options.length;
						for(var i=0;i<n;i++)
						{
							parent.document.frames[1].document.forms[0].facility_id.remove("facility_id");
						}							
				
						
						parent.document.frames[1].document.forms[0].facility_id.disabled = false;
						
						
						var tp =" ---------- Select ---------- ";
						var opt=parent.document.frames[1].document.createElement("OPTION");
						opt.text=tp;
						opt.value="";
						parent.document.frames[1].document.forms[0].facility_id.add(opt);					
					
						
					
				</script>

<%						String sql1= "select facility_id from sm_report_for_fcy where module_id='" + common.trim() + "'and report_id='"+ common1.trim() +"'";
						if(rset!=null)rset.close();
						rset = stmt1.executeQuery(sql1);			
	   					out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script></HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='nam1' id='nam1'>");
						if(rset != null) 
						{
						        while( rset.next() ) 
						        {
						        	moduleid = rset.getString( "facility_id" ) ;
						
						String sg="select facility_name from sm_facility_param where facility_id='"+moduleid+"'";
						rset=stmt1.executeQuery(sg);	
						rset.next();
						
							moduledesc=rset.getString( "facility_name" ) ;

							if(rset!=null)rset.close();
%>	
						<script>				
							var temp = "<%=moduleid%>";
							var temp1="<%=moduledesc%>";
							var opt=parent.document.frames[1].document.createElement("OPTION");
							opt.text=  temp1;
							opt.value=temp;
							parent.document.frames[1].document.forms[0].facility_id.add(opt);
						</script>
<%				   	  
							}
						 }
						 
						 if(stmt1!=null)stmt1.close();
						
						 out.println("</form></body></html>");	
					}
					
					
					
				   if(rset!=null)rset.close();
				   if(stmt1!=null)stmt1.close();
					
			       }


				 
		    	
		    		String sql2= "select transaction_based_yn from sm_report where module_id='" + common.trim() + "'and report_id='"+ common1.trim() +"'";
				stmt1 = con.createStatement();
				rset = stmt1.executeQuery(sql2);			
		   		out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='nam1' id='nam1'>");
				
				
				if(rset != null) 
				{
				        if( rset.next() ) 
				        {
							moduleid = rset.getString( "transaction_based_yn" ) ;	
				 			if(moduleid.equals("Y"))
				 			{
%>
					<script>				
	
						var opt=parent.document.frames[1].document.createElement("OPTION");
						opt.text="Clinic";
						opt.value="C";
						parent.document.frames[1].document.forms[0].dest_locn_type.add(opt);
						parent.document.frames[1].document.forms[0].dest_locn_code1.disabled=true;
						parent.document.frames[1].document.forms[0].dest_locn_code.disabled=false;
	
						</script>
<%	
					  	}
				  	  	else
				  	  	{
%>		
							<script>	
								var opt=parent.document.frames[1].document.createElement("OPTION");
								opt.text="Location";
								opt.value="L";
								parent.document.frames[1].document.forms[0].dest_locn_type.add(opt);
								
								parent.document.frames[1].document.forms[0].dest_locn_code1.disabled=false;
								parent.document.frames[1].document.forms[0].dest_locn_code.disabled=true;
								
							</script>
<%		
				  	  	}
					}
					 out.println("</form></body></html>");		
    				if(rset!=null)rset.close();
    				if(stmt1!=null)stmt1.close();
				}
							 
//CODE ADDED
		
    				
    				
		    String sl= "select report_class from sm_report where module_id='" + common.trim() + "'and report_id='"+ common1.trim() +"'";
				stmt1 = con.createStatement();
				rset = stmt1.executeQuery(sl);			
		   		out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='nam1' id='nam1'>");
				
				out.println(sl);
				if(rset.next()) 
				{
					
					String stl=rset.getString("report_class");
								
					if(stl.equals("R"))
					{
						
%>
				<script>
						var tp ="-------------------------- Select ---------------------------";
						var opt=parent.document.frames[1].document.createElement("OPTION");
						opt.text=tp;
						opt.value="";
						parent.document.frames[1].document.forms[0].printer_id.add(opt);					
						parent.document.frames[1].document.forms[0].printer_id2.add(opt);					
						parent.document.frames[1].document.forms[0].printer_id3.add(opt);					
				
				</script>						
<%
						
						
						String sqq="select printer_id,printer_name from sm_printer where printer_type<>'L' order by printer_name";
						ResultSet rst=stmt1.executeQuery(sqq);	
				
				
				   	     while( rst.next() ) 
				   	     {
				   		     	moduleid = rset.getString( "printer_id" ) ;	
				   		     	moduledesc=rset.getString( "printer_name" ) ;	
									

%>
				<script>				
					var temp = "<%=moduleid%>";
					var temp1="<%=moduledesc%>";
					var opt=parent.document.frames[1].document.createElement("OPTION");
					opt.text= temp1;
					opt.value=temp;
					
					parent.document.frames[1].document.forms[0].printer_id.add(opt);
					var opt2=parent.document.frames[1].document.createElement("OPTION");
					opt2.text= temp1;
					opt2.value=temp;
					
					parent.document.frames[1].document.forms[0].printer_id2.add(opt2);
					var opt3=parent.document.frames[1].document.createElement("OPTION");
					opt3.text= temp1;
					opt3.value=temp;
					parent.document.frames[1].document.forms[0].printer_id3.add(opt3);
				</script>
<%			   	  
					     }
					    if(rst!=null)rst.close();
					    if(stmt1!=null)stmt1.close();
					    
				 	}
				 	else
				 	{
						
%>
				<script>
						var tp ="-------------------------- Select ---------------------------";
						var opt=parent.document.frames[1].document.createElement("OPTION");
						opt.text=tp;
						opt.value="";
						parent.document.frames[1].document.forms[0].printer_id.add(opt);	
						parent.document.frames[1].document.forms[0].printer_id2.add(opt);					
						parent.document.frames[1].document.forms[0].printer_id3.add(opt);		

				</script>						
<%
			
					String sq="select printer_id,printer_name from sm_printer order by printer_name";
					ResultSet rst=stmt1.executeQuery(sq);	
				
				   	     while( rst.next() ) 
				   	     {
			   		     	moduleid = rset.getString( "printer_id" ) ;
			   		     	moduledesc=rset.getString("printer_name");
			
%>
					<script>				
						var temp = "<%=moduleid%>";
						var temp1="<%=moduledesc%>";
						var opt=parent.document.frames[1].document.createElement("OPTION");
						opt.text=temp1;
						opt.value=temp;
						parent.document.frames[1].document.forms[0].printer_id.add(opt);
					</script>
<%			   	  
					    }	
					if(rst!=null)rst.close();
					if(stmt1!=null)stmt1.close();

				 	
				 	}
				 	
				 if(rset!=null)rset.close();
				 if(stmt1!=null)stmt1.close();
				 	
				 }
				 out.println("</form></body></html>");		
		


//CODE SECOND

		    	
		    		String sl2= "select dflt_report_mode from sm_report where module_id='" + common.trim() + "'and report_id='"+ common1.trim() +"'";
				stmt1 = con.createStatement();
				rset = stmt1.executeQuery(sl2);			
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
					
						var n=parent.document.frames[1].document.forms[0].dflt_report_mode.options.length;
						for(var i=0;i<n;i++)
						{
							parent.document.frames[1].document.forms[0].dflt_report_mode.remove("dflt_report_mode");
						}							
					
					
					
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
	
						var n=parent.document.frames[1].document.forms[0].dflt_report_mode.options.length;
						for(var i=0;i<n;i++)
						{
							parent.document.frames[1].document.forms[0].dflt_report_mode.remove("dflt_report_mode");
						}							
						
	
						var opt=parent.document.frames[1].document.createElement("OPTION");
						opt.text="Character";
						opt.value="C";
						parent.document.frames[1].document.forms[0].dflt_report_mode.add(opt);				
	
						var opt=parent.document.frames[1].document.createElement("OPTION");
						opt.text="BitMap";
						opt.value="B";
						parent.document.frames[1].document.forms[0].dflt_report_mode.add(opt);

				
					</script>							

<%
		
						}
					
					}
				 if(rset!=null)rset.close();
				 if(stmt1!=null)stmt1.close();
				 }
				 out.println("</form></body></html>");
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
				//modified by Chitra on 3/8/2001 
				sql="SELECT FACILITY_BASED_YN,TRANSACTION_BASED_YN FROM SM_REPORT WHERE REPORT_ID='"+ rid.trim() +"'";
				stmt1 = con.createStatement();
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
								err=err.replace('$','Facility');
								document.write(err);
							<%
							}
							else
								facid=fid;
					}
				if(rset!=null)rset.close();
				if(stmt1!=null)stmt1.close();
				}	
				if(common.trim().equals("C"))
		   		{
					%>
					document.forms[0].dest_locn_code1.disabled = true;			   
					document.forms[0].dest_locn_code.disabled = false;			   
										
					var tp =" ---------- Select ---------- ";
					var opt=document.createElement("OPTION");
					opt.text=tp;
					opt.value="";
					document.forms[0].dest_locn_code.add(opt);					
			<%			

					sql = "select INSTALL_YN from sm_module where MODULE_ID='OP' " ;
					stmt1 = con.createStatement();
					rset = stmt1.executeQuery(sql);
					sql="";
					if(rset.next())
					{
						String installyn = rset.getString("INSTALL_YN");
						if(installyn.equals("Y"))
						{
							sql= "select clinic_code,short_desc  from op_clinic where eff_status='E' and facility_id='"+facid.trim()+"' and sysdate between nvl(eff_date_from,to_date('01/01/1472','dd/mm/rrrr')) and nvl(eff_date_to,to_date('31/12/5000','dd/mm/rrrr')) order by short_desc "; 
					
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
							}
							if(rs!=null)rs.close();
							if(stmt2!=null)stmt2.close();
						}
						else %>
							alert(getMessage('OP_NOT_INSTALLED','SM'));
	<%				if(rset!=null)rset.close();
					if(stmt1!=null)stmt1.close();
}
					else
					{ %>
						alert(getMessage('OP_NOT_INSTALLED','SM'));
<%					}
				}
		   		else if(common.trim().equals("N"))
				{
			%>
					document.forms[0].dest_locn_code1.disabled = true;			   
					document.forms[0].dest_locn_code.disabled = false;			   
										
					var tp =" ---------- Select ---------- ";
					var opt=document.createElement("OPTION");
					opt.text=tp;
					opt.value="";
					document.forms[0].dest_locn_code.add(opt);
			<%			

					sql = "select INSTALL_YN from sm_module where MODULE_ID='IP' " ;
					stmt1 = con.createStatement();
					rset = stmt1.executeQuery(sql);
					if(rset.next())
					{
						String installyn = rset.getString("INSTALL_YN");
						if(installyn.equals("Y"))
						{
							sql= "select nursing_unit_code,short_desc from ip_nursing_unit  where facility_id = '"+facid.trim()+"' and eff_status = 'E'  order by short_desc";	

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
							if(rset!=null)rset.close();
					if(stmt1!=null)stmt1.close();
						}
						else %>
							alert(getMessage('IP_NOT_INSTALLED','SM'));
<%					if(rset!=null)rset.close();
					if(stmt1!=null)stmt1.close();
			}
					else %>
						alert(getMessage('IP_NOT_INSTALLED','SM'));
<%				}
				else if(common.trim().equals("P"))
				{
					%>
					document.forms[0].dest_locn_code1.disabled = true;			   
					document.forms[0].dest_locn_code.disabled = false;			   
										
					var tp =" ---------- Select ---------- ";
					var opt=document.createElement("OPTION");
					opt.text=tp;
					opt.value="";
					document.forms[0].dest_locn_code.add(opt);		
				<%			
					sql = "select INSTALL_YN from sm_module where MODULE_ID='PH' " ;
					stmt1 = con.createStatement();
					rset = stmt1.executeQuery(sql);
					if(rset.next())
					{
						String installyn = rset.getString("INSTALL_YN");
						if(installyn.equals("Y"))
						{
							sql= "select PHARMACY_CODE,PHARMACY_DESC from ph_pharmacy where EFF_STATUS = 'E' and facility_id = '"+facid.trim()+"' order by PHARMACY_DESC";	
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
							if(rset!=null)rset.close();
					if(stmt1!=null)stmt1.close();
		 					
					   }
					   else %>
						   alert(getMessage('PH_NOT_INSTALLED','SM'));
					<%
					if(rset!=null)rset.close();
					if(stmt1!=null)stmt1.close();
					 }
						else %>
							alert(getMessage('PH_NOT_INSTALLED','SM'));
				<%
				}
				else if(common.trim().equals("S"))
				{
					%>
					document.forms[0].dest_locn_code1.disabled = true;			   
					document.forms[0].dest_locn_code.disabled = false;			   
										
					var tp =" ---------- Select ---------- ";
					var opt=document.createElement("OPTION");
					opt.text=tp;
					opt.value="";
					document.forms[0].dest_locn_code.add(opt);		
					<%			

					sql = "select INSTALL_YN from sm_module where MODULE_ID='ST' " ;
					stmt1 = con.createStatement();
					rset = stmt1.executeQuery(sql);
					if(rset.next())
					{
						String installyn = rset.getString("INSTALL_YN");
						if(installyn.equals("Y"))
						{
							sql= "select store_code, short_desc from st_store where eff_status = 'E' and facility_id = '"+facid.trim()+"' order by SHORT_DESC";	
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
							if(rset!=null)rset.close();
					if(stmt1!=null)stmt1.close();
						}
						else %>
							alert(getMessage('ST_NOT_INSTALLED','SM'));
				<%
					if(rset!=null)rset.close();
					if(stmt1!=null)stmt1.close();
				}
					else %>
						alert(getMessage('ST_NOT_INSTALLED','SM'));
			<%	}
				else if(common.trim().equals("O"))
				{
					%>
					document.forms[0].dest_locn_code1.disabled = true;			   
					document.forms[0].dest_locn_code.disabled = false;			   
										
					var tp =" ---------- Select ---------- ";
					var opt=document.createElement("OPTION");
					opt.text=tp;
					opt.value="";
					document.forms[0].dest_locn_code.add(opt);		
					<%			

					sql = "select INSTALL_YN from sm_module where MODULE_ID='OR' " ;
					stmt1 = con.createStatement();
					rset = stmt1.executeQuery(sql);
					if(rset.next())
					{
						String installyn = rset.getString("INSTALL_YN");
						if(installyn.equals("Y"))
						{
							sql= "select SERVICE_LOCATION_CODE, SHORT_DESC from or_service_location where eff_status = 'E'  order by SHORT_DESC";	
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
							if(rset!=null)rset.close();
					if(stmt1!=null)stmt1.close();
						}
						else %>
							alert(getMessage('OR_NOT_INSTALLED','SM'));
				<%	
					if(rset!=null)rset.close();
					if(stmt1!=null)stmt1.close();
					}
					else %>
						alert(getMessage('OR_NOT_INSTALLED','SM'));
			<%	}
				else
		   		{
					//modified by Chitra on 11/9/2001	
					%>				
					document.forms[0].dest_locn_code1.disabled = false;		
					document.forms[0].dest_locn_code.disabled = true;		document.getElementById('locnimg').style.visibility = 'hidden';
					document.getElementById('locnimg1').style.visibility = 'hidden';
<%	
				}
			}
			else if(chksrc.trim().equals("five")) 
			{		    	
		    	String sql1= "select dflt_report_mode from sm_report where module_id='" + common.trim() + "'and report_id='"+ common1.trim() +"'";
				stmt1 = con.createStatement();
				rset = stmt1.executeQuery(sql1);			
				if(rset != null) 
				{
			        while( rset.next() ) 
			        {
			        	moduleid = rset.getString( "dflt_report_mode" ) ;	
						if(moduleid.equals("B"))
						{
					%>				
							var opt=document.createElement("OPTION");
							opt.text="BitMap";
							opt.value="B";
							document.forms[0].dflt_report_mode.add(opt);
					
							var opt=document.createElement("OPTION");
							opt.text="Character";
							opt.value="C";
							document.forms[0].dflt_report_mode.add(opt);				
					<%			   	  
						}
						else
						{
					%>
							var opt=document.createElement("OPTION");
							opt.text="Character";
							opt.value="C";
							document.forms[0].dflt_report_mode.add(opt);		
		
							var opt=document.createElement("OPTION");
							opt.text="BitMap";
							opt.value="B";
							document.forms[0].dflt_report_mode.add(opt);
					<%
						}					
					}
				 if(rset!=null)rset.close();
				if(stmt1!=null)stmt1.close();
				 }
			}			
			else if(chksrc.trim().equals("six")) 
			{
		    		
	    		String common2 = (String) hash.get("Common_Text2") ;
				if(common2 == null) common2="";			
	    		if(common.trim().equals("B")) 
	    		{		    		
		    		String sql1= "select executable_name_bm from sm_report where module_id='" + common1.trim() + "'and report_id='"+ common2.trim() +"'";
					stmt1 = con.createStatement();
					rset = stmt1.executeQuery(sql1);			
		   			rset.next();	
					if(rset.getString("executable_name_bm")==null) 
					{
						%>	
						var n=document.forms[0].dflt_report_mode.options.length;
						for(var i=0;i<n;i++)
						{
							document.forms[0].dflt_report_mode.remove("dflt_report_mode");
						}											
						var opt=document.createElement("OPTION");
						opt.text="Character";
						opt.value="C";
						document.forms[0].dflt_report_mode.add(opt);
			
						var opt=document.createElement("OPTION");
						opt.text="BitMap";
						opt.value="B";
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
						opt.text="BitMap";
						opt.value="B";
						document.forms[0].dflt_report_mode.add(opt);
					
						var opt=document.createElement("OPTION");
						opt.text="Character";
						opt.value="C";
						document.forms[0].dflt_report_mode.add(opt);				
						<%
					}
						if(rset!=null)rset.close();
					if(stmt1!=null)stmt1.close();
				}
	    		else if(common.trim().equals("C")) 
	    		{
		    		
		    		String sql1= "select executable_name_ch from sm_report where module_id='" + common1.trim() + "'and report_id='"+ common2.trim() +"'";
					stmt1 = con.createStatement();
					rset = stmt1.executeQuery(sql1);			
		   			rset.next();	
					if((rset.getString("executable_name_ch")==null ))
					{
						%>	
						var n=document.forms[0].dflt_report_mode.options.length;
						for(var i=0;i<n;i++)
						{
							document.forms[0].dflt_report_mode.remove("dflt_report_mode");
						}							
									
						var opt=document.createElement("OPTION");
						opt.text="BitMap";
						opt.value="B";
						document.forms[0].dflt_report_mode.add(opt);
					
						var opt=document.createElement("OPTION");
						opt.text="Character";
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
						opt.text="Character";
						opt.value="C";
						document.forms[0].dflt_report_mode.add(opt);
			
						var opt=document.createElement("OPTION");
						opt.text="BitMap";
						opt.value="B";
						document.forms[0].dflt_report_mode.add(opt);
						<%
					}
						if(rset!=null)rset.close();
					if(stmt1!=null)stmt1.close();
				}
			}
		    else 
			{
				//add for four !..................................
		    	String sql = "select Report_Id,Report_Desc from Sm_Report where Module_Id='" + common.trim() + "'";
				stmt1 = con.createStatement();
				rset = stmt1.executeQuery(sql);			
				if(rset != null) 
				{
					while( rset.next() ) 
					{
				       	String reportid = rset.getString( "Report_Id" ) ;	
				       	String reportdesc = rset.getString( "Report_Desc" );
						%>
					<script>				
						var opt=document.createElement("OPTION");
						opt.text=  "<%=reportdesc%>" ;
						opt.value="<%=reportid%>";
						document.forms[0].Report_Id.add(opt);
					</script>
<%
					}
					if(rset!=null)rset.close();
					if(stmt1!=null)stmt1.close();
				 }
			}
			hash.clear();
			
		}
		catch(Exception e){out.println(e);}
		finally 
		{ 
			ConnectionManager.returnConnection(con,request);
		}
%>	

