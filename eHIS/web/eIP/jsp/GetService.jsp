<!DOCTYPE html>
<%@ page  contentType="text/html;charset=UTF-8"  import ="webbeans.eCommon.*, eCommon.XSSRequestWrapper, java.sql.*" %>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8");  
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con 			= null;
	PreparedStatement pstmt	= null;
	PreparedStatement pstmt3= null;
	PreparedStatement pstmt4= null;
	ResultSet rs			= null;
	ResultSet rs2			= null; 
	ResultSet dfrset		= null; 
	Statement dfstmt		= null; 
	ResultSet rs4			= null; 
	Statement stmt			= null;
	ResultSet rset			= null; 
	ResultSet rs3			= null;
	
	String facilityId		= (String) session.getValue("facility_id");
	String centralValue		= checkForNull(request.getParameter("centralValue"));
	String fmInstallyn		= checkForNull(request.getParameter("fminstall"));
	String sectionType		= checkForNull(request.getParameter("sectionType"));
	String levelfcare		= checkForNull(request.getParameter("levelfcare"));
	String defaultlocn		= checkForNull(request.getParameter("defaultlocn"));
	String criteria			= checkForNull(request.getParameter("criteria"));
	String deptcode			= checkForNull(request.getParameter("dept_code"));
	String servicecode		= checkForNull(request.getParameter("service_code"));
	String MRSectionCode	= checkForNull(request.getParameter("mr_section_type"));
	String applicable_to	= checkForNull(request.getParameter("applicable_to"));
	String sectioncode		= checkForNull(request.getParameter("section_code"));
	String fm_setup_ip		= request.getParameter("fm_setup_ip");
		if(fm_setup_ip == null) fm_setup_ip	=	"N";
/* Added  for subservice & Section by Sridhar on 31/01/04 */

	String ID3				= "";
	String dat3				= "";
	String ID				= "";
	String dat				= "";
	String sql_1			= "";
	String default_code		= "";
	String default_desc		= "";
	String ID4				= "";
	String dat4				= "";

	try
	{
		con = ConnectionManager.getConnection(request);
		
	try
	{
		if(criteria.equals("populateFSFileType"))
		{

			String sqlString		=	"";
			String file_type_code	=	"";
			String file_type_desc	=	"";
			String mr_location_code		=	checkForNull(request.getParameter("mr_location_code"));

			if ((fm_setup_ip.equals("Y")) && (!mr_location_code.equals("")) && (applicable_to.equals("IP")))
			{
				sqlString	=	" SELECT distinct a.file_type_code file_type_code, c.short_desc file_type_desc FROM fm_file_type_for_fsl a, mr_file_type c WHERE c.facility_id = ? AND a.facility_id = c.facility_id AND a.fs_locn_code = ? AND a.file_type_code = c.file_type_code AND appl_to_ip = 'Y' ORDER BY file_type_desc ";
			}
			else if ((fm_setup_ip.equals("Y")) && (!mr_location_code.equals("")) && (applicable_to.equals("DC")))
			{
				sqlString	=	" SELECT distinct a.file_type_code file_type_code, c.short_desc file_type_desc FROM fm_file_type_for_fsl a, mr_file_type c WHERE c.facility_id = ? AND a.facility_id = c.facility_id AND a.fs_locn_code = ? AND a.file_type_code = c.file_type_code AND appl_to_dc = 'Y' ORDER BY file_type_desc ";
			}
			else if ((fm_setup_ip.equals("N")) && (applicable_to.equals("DC")))
			{
				sqlString	=	" SELECT  distinct file_type_code, short_desc file_type_desc FROM mr_file_type WHERE facility_id = ? AND appl_to_dc = 'Y' AND eff_status = 'E' ORDER BY short_desc ";
			}
			else if ((fm_setup_ip.equals("N")) && (applicable_to.equals("IP")))
			{
				sqlString	=	" SELECT  distinct file_type_code, short_desc file_type_desc FROM mr_file_type WHERE facility_id = ? AND appl_to_ip = 'Y' AND eff_status = 'E' ORDER BY short_desc ";
			}
			if (!sqlString.equals(""))
			{
				if(rs != null)		rs.close();
				if(pstmt != null)		pstmt.close();

				pstmt	=	con.prepareStatement(sqlString);
				pstmt.setString(1, facilityId);
				if (fm_setup_ip.equals("Y"))
				pstmt.setString(2, mr_location_code);
				rs	=	pstmt.executeQuery();
				if (rs != null)
				{
					%>
					<script>
						var select	=	parent.f_query_add_mod.document.forms[0].dflt_file_type;
						var length	=	Math.abs(select.length); 
						for (i=0;i<length;i++)
						select.remove(0);

						var option	=	parent.f_query_add_mod.document.createElement("OPTION");
						option.text	=	"--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
						option.value=	"";	
						select.add(option);
					</script>
					<%
					while(rs.next())
					{
						file_type_code	=	checkForNull(rs.getString("file_type_code"));
						file_type_desc	=	checkForNull(rs.getString("file_type_desc"));
						%>
						<script>
							var option	=	parent.f_query_add_mod.document.createElement("OPTION");
							option.text	=	"<%=file_type_desc%>";
							option.value=	"<%=file_type_code%>";
							select.add(option);
						</script>
						<%
					}
				}
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}
		}
	}catch(Exception e)
	{
		out.print("Exception in GetService populateFSFileType: "+e);
	}
	
	try
	{
		if (criteria.equals("populateFSLocation"))
		{

			String sqlString		=	"";
			String file_sto_code	=	"";
			String file_sto_desc	=	"";

			sqlString = " select fs_locn_code, short_desc from fm_storage_locn where facility_id = ? and eff_status = 'E' and permanent_file_area_yn = 'N' and locn_identity = '"+centralValue+"' ";
			if(rs != null)	rs.close();
			if(pstmt != null)pstmt.close();
			pstmt	=	con.prepareStatement(sqlString);
			pstmt.setString(1, facilityId);
			rs	=	pstmt.executeQuery();
			if (rs != null)
			{	
				%>
				<script>
					var select	=	parent.f_query_add_mod.document.forms[0].mr_location_code;
					var length	=	Math.abs(select.length); 
					for (i=0;i<length;i++)
						select.remove(0);
					var option	=	parent.f_query_add_mod.document.createElement("OPTION");
					option.text	=	"--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
					option.value=	"";	
					select.add(option);
				</script>
			<%	
				while(rs.next())
				{
					file_sto_code	=	checkForNull(rs.getString("fs_locn_code"));
					file_sto_desc	=	checkForNull(rs.getString("short_desc"));
				%>	<script>
						var option	=	parent.f_query_add_mod.document.createElement("OPTION");
						option.text	=	"<%=file_sto_desc%>";
						option.value=	"<%=file_sto_code%>";
						select.add(option);
					</script>
			<%	}
			}
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
		}
	}catch(Exception e)
	{
		out.print("Exception in GetService populateFSLocation : "+e);
	}

	try
	{
		if (criteria.equals("repopulateFSLocn"))
		{

			String sqlString		=	"";
			String file_sto_code	=	"";
			String file_sto_desc	=	"";

			if(fm_setup_ip.equals("Y"))
			{
				sqlString	= "select FS_LOCN_CODE, short_desc from fm_storage_locn where locn_identity='"+centralValue+"' and eff_status = 'E' and facility_id=? order by short_desc";

				if(rs != null)		rs.close();
				if(pstmt != null)		pstmt.close();
				pstmt	=	con.prepareStatement(sqlString);
				pstmt.setString(1, facilityId);
				rs	=	pstmt.executeQuery();
				
				if (rs != null)
				{	%>
					<script>
						var select	=	parent.f_query_add_mod.document.forms[0].mr_location_code;
						var length	=	Math.abs(select.length); 
						for (i=0;i<length;i++)
							select.remove(0);
						var option	=	parent.f_query_add_mod.document.createElement("OPTION");
						option.text	=	"--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
						option.value=	"";	
						select.add(option);
					</script>
			<%	}
			
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				while(rs.next())
				{
					file_sto_code	=	checkForNull(rs.getString("fs_locn_code"));
					file_sto_desc	=	checkForNull(rs.getString("short_desc"));
				%>	<script>
						var option	=	parent.f_query_add_mod.document.createElement("OPTION");
						option.text	=	"<%=file_sto_desc%>";
						option.value=	"<%=file_sto_code%>";
						select.add(option);
					</script>
			<%	}
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}
			else
			{	%>
				<script>
					var select	=	parent.f_query_add_mod.document.forms[0].mr_location_code;
					var length	=	Math.abs(select.length); 
					for (i=0;i<length;i++)
						select.remove(0);
					var option	=	parent.f_query_add_mod.document.createElement("OPTION");
					option.text	=	"--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
					option.value=	"";	
					select.add(option);
				</script>
		<%	}
		}
	}catch(Exception e)
	{
		out.print("Exception in GetService repopulateFSLocn : "+e);
	}

	try
	{
		pstmt	=	null;
		rs		=	null;
		if(servicecode == null) servicecode="";

		out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></HEAD><body onMouseDown='CodeArrest()' onKeyDown='lockKey()' CLASS='MESSAGE'><form name='testform' id='testform'>");


		/* MR SECTION - Added by Sridhar R on 18 JUNE 2004 */
		if (!(MRSectionCode == null || MRSectionCode.equals("")))
		{
			if(!MRSectionCode.equals("popfslocn"))
			{	

				
				%>
				<script>
					var n = parent.f_query_add_mod.document.NursingUnit_form.mr_section.length;
					for(var i=0;i<n;i++)
						parent.f_query_add_mod.document.NursingUnit_form.mr_section.remove("SHORT_NAME");	
					var temp = "";
					var temp1="--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
					var opt=parent.f_query_add_mod.document.createElement('OPTION');
					opt.text=temp1;
					opt.value=temp;
					parent.f_query_add_mod.document.NursingUnit_form.mr_section.add(opt);	
					parent.f_query_add_mod.document.NursingUnit_form.mr_section.options[0].selected = true;
				</script>
				<%
				if(rs4 != null)		rs4.close();
				if(pstmt4 != null)		pstmt4.close();
				pstmt4=con.prepareStatement("select SHORT_NAME,MR_SECTION_CODE from MR_SECTION where eff_status='E' and MR_SECTION_TYPE like ? and FACILITY_ID like ? order by SHORT_NAME");
				pstmt4.setString(1,MRSectionCode);
				pstmt4.setString(2,facilityId);
				rs4=pstmt4.executeQuery();
				
				if(rs4!=null)
				{
					while(rs4.next())
					{
						dat4 = checkForNull(rs4.getString("SHORT_NAME"));
						ID4 = checkForNull(rs4.getString("MR_SECTION_CODE"));	 
						%>
						<script>
							var element = parent.f_query_add_mod.document.createElement('OPTION');
							element.text = "<%=dat4%>";
							element.value= "<%=ID4%>";
							element.selected=false;
							parent.f_query_add_mod.document.NursingUnit_form.mr_section.add(element);
						</script> 
			<%		} //end of while
				}
				if(rs4!=null)rs4.close();
				if(pstmt4!=null)pstmt4.close();
			}//end of main if..
			
			//Population of fs location 
			String sqlString  = "";
			String file_sto_code = "";
			String file_sto_desc = "";

			if(fm_setup_ip.equals("Y"))
			{

				if(MRSectionCode.equals("D"))
				{
					sqlString	= "select fs_locn_code, short_desc from fm_storage_locn where facility_id = ? and mr_locn_yn ='Y' and permanent_file_area_yn = 'Y' and locn_identity = '"+centralValue+"' ";
				}
				else if(MRSectionCode.equals("C"))
				{
					sqlString	= "select FS_LOCN_CODE, short_desc from fm_storage_locn where locn_identity='"+centralValue+"' and eff_status = 'E' and permanent_file_area_yn = 'N' and facility_id=? order by short_desc";
				}
			}
			if(rs != null)		rs.close();
			if(pstmt != null)		pstmt.close();
	
			pstmt	=	con.prepareStatement(sqlString);
			pstmt.setString(1, facilityId);
			rs	=	pstmt.executeQuery();
			if (rs != null)
			{
				%>
				<script>
					var select	=	parent.f_query_add_mod.document.forms[0].mr_location_code;
					var length	=	Math.abs(select.length); 
					for (i=0;i<length;i++)
						select.remove(0);
					var option	=	parent.f_query_add_mod.document.createElement("OPTION");
					option.text	=	"--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
					option.value=	"";	
					select.add(option);
				</script>
		<%
				while(rs.next())
				{
					file_sto_code	=	checkForNull(rs.getString("fs_locn_code"));
					file_sto_desc	=	checkForNull(rs.getString("short_desc"));
				%>	<script>
						var option	=	parent.f_query_add_mod.document.createElement("OPTION");
						option.text	=	"<%=file_sto_desc%>";
						option.value=	"<%=file_sto_code%>";
						select.add(option);
					</script>
			<%	}
			}
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
		}

		if (!(deptcode == null || deptcode.equals("")))
		{
			if(rs != null)		rs.close();
			if(pstmt != null)		pstmt.close();

			pstmt=con.prepareStatement("select service_short_desc, service_code from am_facility_service_vw where operating_facility_id = ? and dept_code = ? and eff_status = 'E' order by service_short_desc");
			pstmt.setString(1,facilityId);
			pstmt.setString(2,deptcode);
			rs=pstmt.executeQuery();

			if(rs!=null)
			{
				while(rs.next())
				{  
					dat=checkForNull(rs.getString("service_short_desc"));
					ID  = checkForNull(rs.getString("service_code"));
					%>
					<script>
						var element = parent.f_query_add_mod.document.createElement('OPTION');
						element.text = "<%=dat%>";
						element.value= "<%=ID%>";
						if ("<%=servicecode%>" == "<%=ID%>")
							element.selected=true;
						parent.f_query_add_mod.document.NursingUnit_form.service_code.add(element);
					</script>
					<%
				}
			}
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
		}

		/* SECTION - Added by Sridhar on 01/02/04 */

		if (!(deptcode == null || deptcode.equals("")))
		{
			if(rs3 != null)		rs3.close();
			if(pstmt3 != null)		pstmt3.close();
			pstmt3=con.prepareStatement("select section_short_desc, section_code from am_dept_section_vw where dept_code = ? and eff_status = 'E' order by section_short_desc");
			pstmt3.setString(1,deptcode);
			rs3=pstmt3.executeQuery();

			if(rs3!=null)
			{
				while(rs3.next())
				{
					dat3 = checkForNull(rs3.getString("section_short_desc"));
					ID3  = checkForNull(rs3.getString("section_code"));
			%>		<script>
						var element = parent.f_query_add_mod.document.createElement('OPTION');
						element.text = "<%=dat3%>";
						element.value= "<%=ID3%>";
						if ("<%=sectioncode%>" == "<%=ID3%>")
							element.selected=true;
						parent.f_query_add_mod.document.NursingUnit_form.section.add(element);
						
					</script> 
		<%		}
			}	
		}

	}catch(Exception e)
	{
		out.print("Exception in GetService service Pop : "+e);
	}

	try
	{
		if(criteria.equals("populatefs"))
		{
		if(sectionType.equals("D") || sectionType.equals("C"))
			{
		%>
				<script>
					var n = parent.f_query_add_mod.document.NursingUnit_form.mr_section.length;
					for(var i=0;i<n;i++)
						parent.f_query_add_mod.document.NursingUnit_form.mr_section.remove("SHORT_NAME");	
					var temp = "";
					var temp1="--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
					var opt=parent.f_query_add_mod.document.createElement('OPTION');
					opt.text=temp1;
					opt.value=temp;
					parent.f_query_add_mod.document.NursingUnit_form.mr_section.add(opt);	
					parent.f_query_add_mod.document.NursingUnit_form.mr_section.options[0].selected = true;
				</script>
				<%
				if(rs4 != null)		rs4.close();
				if(pstmt4 != null)		pstmt4.close();
				pstmt4=con.prepareStatement("select SHORT_NAME,MR_SECTION_CODE from MR_SECTION where eff_status='E' and MR_SECTION_TYPE like ? and FACILITY_ID like ? order by SHORT_NAME");
				pstmt4.setString(1,sectionType);
				pstmt4.setString(2,facilityId);
				rs4=pstmt4.executeQuery();

				if(rs4!=null)
				{
					while(rs4.next())
					{
						dat4 = checkForNull(rs4.getString("SHORT_NAME"));
						ID4 = checkForNull(rs4.getString("MR_SECTION_CODE"));	 

						%>				 <script>

						var element = parent.f_query_add_mod.document.createElement('OPTION');
						element.text = "<%=dat4%>";
						element.value= "<%=ID4%>";
						element.selected=false;

						parent.f_query_add_mod.document.NursingUnit_form.mr_section.add(element);

						</script> 
						<%
					} //end of while
				}
				if(rs4!=null)rs4.close();
				if(pstmt4!=null)pstmt4.close();

			}
		
		if(sectionType.equals("C"))
		{
			sql_1 =" Select short_desc,fs_locn_code from fm_storage_locn where facility_id = '"+facilityId+"' and  permanent_file_area_yn='N' and locn_identity = '"+centralValue+"' and eff_status = 'E' order by short_desc ";
		}
		else if(sectionType.equals("D"))
		{
			sql_1 ="Select short_desc,fs_locn_code from fm_storage_locn where facility_id = '"+facilityId+"' and eff_status = 'E' and MR_LOCN_YN='Y' and permanent_file_area_yn='Y' and locn_identity ='"+centralValue+"' order by short_desc ";
		}
		else if(sectionType.equals(""))
		{
			sql_1="Select short_desc,fs_locn_code from fm_storage_locn where facility_id = '"+facilityId+"' and locn_identity ='"+centralValue+"' and permanent_file_area_yn='N' and eff_status = 'E' order by short_desc ";
		}

		stmt= con.createStatement();
		rset = stmt.executeQuery(sql_1);  

		if(rset != null) 
		{	
			while( rset.next() ) 
			{
				String mr_location_code=checkForNull(rset.getString("fs_locn_code"));
				String short_desc=checkForNull(rset.getString("short_desc"));     	
				%>
				<script>
					var temp = "<%=mr_location_code%>";
					var temp1="<%=short_desc%>";
					var opt=parent.f_query_add_mod.document.createElement("OPTION");
					opt.text=temp1;
					opt.value=temp;
					parent.f_query_add_mod.document.forms[0].mr_location_code.value="<%=servicecode%>";
					if(parent.f_query_add_mod.document.forms[0].mr_location_code != null)
						parent.f_query_add_mod.document.forms[0].mr_location_code.add(opt);
					
				</script>
		<%	}
		}           
			if(rset != null ) rset.close();
		}
	}catch(Exception e)
	{
		out.print("Exception in GetService populatefs : "+e);
	}

	try
	{
		if(criteria.equals("populateDF"))
		{
			StringBuffer dfsql = new StringBuffer();
			out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='nam1' id='nam1'>");

			if(fmInstallyn.equals("Y"))
			{

				if(dfsql.length() > 0) dfsql.delete(0,dfsql.length());
				dfsql.append(" select a.file_type_code file_type_code, b.short_desc file_type_desc from FM_FILE_TYPE_FOR_FSL a, MR_FILE_TYPE b where b.facility_id ='"+facilityId+"'  and a.facility_id = b.facility_id and a.fs_locn_code ='"+defaultlocn+"' and a.file_type_code = b.file_type_code and a.eff_status = 'E' "); 

				if(levelfcare.equals("A"))
					dfsql.append(" and b.appl_to_ip='Y' ");
				else if(levelfcare.equals("E"))
					dfsql.append(" and b.appl_to_em='Y' ");

			}
			else if(fmInstallyn.equals("N"))
			{
				if(dfsql.length() > 0) dfsql.delete(0,dfsql.length());
				dfsql.append(" select file_type_code, short_desc file_type_desc from MR_FILE_TYPE where facility_id ='"+facilityId+"' and EFF_STATUS = 'E' ");

				if(levelfcare.equals("A"))
					dfsql.append(" and appl_to_ip='Y' ");
				else if(levelfcare.equals("E"))
					dfsql.append(" and appl_to_em='Y' ");
			} 
			dfsql.append(" order by file_type_desc ");


//out.println("<script>alert(\""+dfsql.toString()+"\")</script>");

			if(dfrset != null) dfrset.close();
			if(dfstmt != null) dfstmt.close();
			dfstmt=con.createStatement();
			dfrset=dfstmt.executeQuery(dfsql.toString());

			if(dfsql.length() > 0) dfsql.delete(0,dfsql.length());



			if(dfrset!=null)
			{
				while(dfrset.next())
				{
					default_code = checkForNull(dfrset.getString("file_type_code"));
					default_desc = checkForNull(dfrset.getString("file_type_desc"));
			%>		<script>
						var opt= parent.f_query_add_mod.document.createElement("OPTION");
						opt.text="<%=default_desc%>";
						opt.value="<%=default_code%>";
						parent.f_query_add_mod.document.forms[0].dflt_file_type.add(opt);
					</script>
		<%		}
			}
			if(dfrset != null )dfrset.close();
			if(dfstmt != null )dfstmt.close();
		}

	}catch(Exception e)
	{
		out.print("Exception in GetService populateDF : "+e);
	}
	
	
	}catch(Exception e)
	{
		out.print("Exception in GetService : "+e);
	}
	finally
	{
		if(rs != null)		rs.close();
		if(pstmt != null)	pstmt.close();
		if(rs2 != null)		rs2.close();
		if(rs3 != null)		rs3.close();
		if(pstmt3 != null)	pstmt3.close();

		ConnectionManager.returnConnection(con,request);
	}
%>
</form>
</body>
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

