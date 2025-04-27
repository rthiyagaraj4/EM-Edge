<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>

<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	Connection con = null;
	PreparedStatement pstmt1 = null;
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	ResultSet reset=null;
	ResultSet rstt=null;
	ResultSet rs=null;
	ResultSet rst=null;			
	ResultSet rss=null;
	ResultSet rset1=null;

	String moduleid="";
	String moduledesc="";
	String common=request.getParameter("Common_Text");	
	String common1=request.getParameter("Common_Text1");
	String chksrc = request.getParameter("Chksrc");
	String used_status = "";
	String scheme_id = "";

	String start_srl_no="";
	String max_srl_no="";
	String gen_pid_using_alt_id1_rule_yn1="";
	String pid_use_alt_id1_or_sys_gen="";



	try
	{
	con = ConnectionManager.getConnection(request);

	if(chksrc.trim().equals("forpatnum")) 
		{			
			String st="";
		try
		{	
//Added by sen on 3/07/2004
		try {
			String strsql = "select used_status from mp_pat_ser_facility where pat_ser_grp_code = '"+common.trim()+"' ";	

			
			pstmt = con.prepareStatement(strsql);
			reset=pstmt.executeQuery();					
			if(reset.next())
				{
				used_status = reset.getString("used_status")==null?"":reset.getString("used_status");
				}
					
			
	%>
		<script>parent.f_query_add_mod.document.getElementById('used_status').value='<%=used_status%>'
		
//		alert(parent.document.frames[1].document.forms[0].used_status.value);
		</script>
		
		<%

		}
		catch (Exception e)
		{
		}
		finally{
			if(pstmt!=null)pstmt.close();
			if(reset!=null)reset.close();
		}
//addition ends



			String sq="select pat_no_ctrl,scheme_id from mp_pat_ser_grp where  pat_ser_grp_code ='"+ common.trim() + "'"; 
			pstmt1 = con.prepareStatement(sq);
			rset = pstmt1.executeQuery();	
			out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='nam1' id='nam1'>");
			if(rset.next())
			{
				 st=rset.getString("pat_no_ctrl");
				 scheme_id=rset.getString("scheme_id")==null ? "" : rset.getString("scheme_id");
			}	
		}catch(Exception e) { /* out.println("ERROR IN ST FETCHING :"+e.toString()); */ e.printStackTrace();}
		
		finally
		{
			if (pstmt1 != null) pstmt1.close();
			if (rset != null) rset.close();
		}

		if(st.equals("U"))
		{
%>
		
		<Script language="JavaScript">
			
			var temp = "parent.f_query_add_mod.document.getElementById('siteorfac').firstChild.nodeValue ='Facility';";
			eval(temp);	


			parent.f_query_add_mod.document.getElementById('siteorfac').style.visibility='visible';
			parent.f_query_add_mod.document.getElementById('site_or_facility_id').style.visibility='visible';
			parent.f_query_add_mod.document.getElementById('sno').style.visibility='visible';
			parent.f_query_add_mod.document.getElementById('start_srl_no').style.visibility='visible';
			parent.f_query_add_mod.document.getElementById('maxlabel').style.visibility='visible';
			parent.f_query_add_mod.document.getElementById('max_srl_no').style.visibility='visible';
			parent.f_query_add_mod.document.getElementById('st').style.visibility='visible';
			parent.f_query_add_mod.document.getElementById('st1').style.visibility='visible';
			parent.f_query_add_mod.document.getElementById('st2').style.visibility='visible';



			parent.f_query_add_mod.document.forms[0].site_or_facility_id.disabled=false;

			parent.f_query_add_mod.document.forms[0].pat_no_ctrl.value="<%=st%>";

			parent.f_query_add_mod.document.getElementById('mr_section_code_tr').style.visibility='visible';
			parent.result.location.href = "../../eCommon/html/blank.html";
		</Script>
<%
			
		
		try{
			String sql2="select facility_id,facility_name from sm_facility_param order by facility_name"; 
			pstmt1 = con.prepareStatement(sql2);
			rs = pstmt1.executeQuery();

%>
	
			<script>	
				var tp =" ---"+getLabel("Common.defaultSelect.label","Common")+"--- "
				var opt=parent.f_query_add_mod.document.createElement("OPTION");
				opt.text=tp;
				opt.value="";
				parent.f_query_add_mod.document.forms[0].site_or_facility_id.add(opt);					
			</script>	        
				
<%				
				while( rs.next() ) 
				{
					moduleid = rs.getString( "facility_id" ) ;	
					moduledesc= rs.getString( "facility_name" );
%>

				<script>
				
					var temp = "<%=moduleid%>";
					var temp1="<%=moduledesc%>";
					var opt=parent.f_query_add_mod.document.createElement("OPTION");
					opt.text=temp1;
					opt.value=temp;
					parent.f_query_add_mod.document.forms[0].site_or_facility_id.add(opt);
				</script>
<%			   			
					
			 }
			%>
				<script>
				parent.f_query_add_mod.document.forms[0].site_or_facility.value="F";

			parent.f_query_add_mod.document.forms[0].start_srl_no.value="";
			parent.f_query_add_mod.document.forms[0].max_srl_no.value="";
				</script>
					<%
	
		}catch(Exception e) 
		{ /* out.println("ERROR IN U FETCHING :"+e.toString()); */
	    	e.printStackTrace();
		}
		finally
		{
			if (pstmt1 != null) pstmt1.close();
			if (rs != null) rs.close();
		}
			
			}	
		else if(st.equals("Z"))
		{

			String sql1="select START_SRL_NO,MAX_SRL_NO from mp_pat_ser_facility where pat_ser_grp_code='"+common.trim()+"'";

			pstmt1 = con.prepareStatement(sql1);
			rset = pstmt1.executeQuery();	
			//out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE'><form name='nam1' id='nam1'>");
			if(rset.next())
			{
				 start_srl_no=rset.getString("START_SRL_NO");
				 max_srl_no=rset.getString("MAX_SRL_NO");
			}	
			

				if (pstmt1 != null) pstmt1.close();
				if (rset != null) rset.close();

	%>
		
		<Script language="JavaScript">
			
			var temp1 = "parent.f_query_add_mod.document.getElementById('siteorfac').firstChild.nodeValue ='Site';";
			eval(temp1);

			parent.f_query_add_mod.document.getElementById('siteorfac').style.visibility='visible';
			parent.f_query_add_mod.document.getElementById('site_or_facility_id').style.visibility='visible';
			parent.f_query_add_mod.document.getElementById('sno').style.visibility='visible';
			parent.f_query_add_mod.document.getElementById('start_srl_no').style.visibility='visible';
			parent.f_query_add_mod.document.getElementById('maxlabel').style.visibility='visible';
			parent.f_query_add_mod.document.getElementById('max_srl_no').style.visibility='visible';
			parent.f_query_add_mod.document.getElementById('st').style.visibility='visible';
			parent.f_query_add_mod.document.getElementById('st1').style.visibility='visible';
			parent.f_query_add_mod.document.getElementById('st2').style.visibility='visible';


			parent.f_query_add_mod.document.forms[0].site_or_facility_id.disabled=false;
			parent.f_query_add_mod.document.forms[0].start_srl_no.disabled=false;
			parent.f_query_add_mod.document.forms[0].max_srl_no.disabled=false;
			parent.f_query_add_mod.document.forms[0].start_srl_no.value="<%=start_srl_no%>";
			parent.f_query_add_mod.document.forms[0].max_srl_no.value="<%=max_srl_no%>";
			if(parent.f_query_add_mod.document.forms[0].start_srl_no.value!="" && parent.f_query_add_mod.document.forms[0].max_srl_no.value!="")
			{
			parent.f_query_add_mod.document.forms[0].max_srl_no.readOnly = true;
			parent.f_query_add_mod.document.forms[0].start_srl_no.readOnly = true;
			parent.f_query_add_mod.document.forms[0].readonly_flag.value ="Y";
			}
			
			var pat_ser_grp_code1=parent.f_query_add_mod.document.getElementById('pat_ser_grp_code').value;

			parent.f_query_add_mod.document.forms[0].pat_no_ctrl.value="<%=st%>";
			parent.f_query_add_mod.document.getElementById('mr_section_code_tr').style.visibility='hidden';
			parent.result.location.href = "../../eMP/jsp/addPatientNumberingDetail_Result.jsp?pat_ser_grp_code="+pat_ser_grp_code1;
		</Script>




<%

		try{
			String stt="select site_id,site_name from sm_site_param ";
			pstmt1 = con.prepareStatement(stt);
			rset = pstmt1.executeQuery();
			rset.next();
			moduleid=rset.getString("site_id");
			moduledesc=rset.getString("site_name");
		}catch(Exception e) { /* out.println(e.toString()); */
		e.printStackTrace();}
		finally
		{
			if (pstmt1 != null) pstmt1.close();
			if (rset != null) rset.close();
		}
%>
			<script>
		
				var temp = "<%=moduleid%>";
				var temp1="<%=moduledesc%>";
				var opt=parent.f_query_add_mod.document.createElement("OPTION");
				opt.text=temp1;
				opt.value=temp;
				parent.f_query_add_mod.document.forms[0].site_or_facility_id.add(opt);
				parent.f_query_add_mod.document.forms[0].site_or_facility.value="S";
			</script>
		
<%

//CODE FOR MR SECTION

try{
	String srt="select mr_section_code,short_name from mr_section where mr_section_type ='C' and  eff_status='E' and trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) order by short_name "; 		
	pstmt1 = con.prepareStatement(srt);
	rstt = pstmt1.executeQuery();	

%>


	<script>	

		var n=parent.f_query_add_mod.document.forms[0].mr_section_code.options.length;
		for(var i=0;i<n;i++)
		{
		parent.f_query_add_mod.document.forms[0].mr_section_code.remove("mr_section_code");				

		}					
		var tp =" --"+getLabel("Common.defaultSelect.label","Common")+"--- "
		var opt=parent.f_query_add_mod.document.createElement("OPTION");
		opt.text=tp;
		opt.value="";
		parent.f_query_add_mod.document.forms[0].mr_section_code.add(opt);					

	</script>	        

<%				
	 while( rstt.next() ) 
	 {
		moduleid = rstt.getString( "mr_section_code" ) ;	
		moduledesc= rstt.getString( "short_name" ) ;
%>

		<script>
			//alert("here");

			var temp = "<%=moduleid%>";
			var temp1="<%=moduledesc%>";
			var opt=parent.f_query_add_mod.document.createElement("OPTION");
			opt.text=temp1;
			opt.value=temp;
			parent.f_query_add_mod.document.forms[0].mr_section_code.add(opt);
		</script>
<%	

	 }

}catch(Exception e) { /* out.println("Error MR Section "+e.toString()); */ e.printStackTrace();}
finally
{
if (pstmt1 != null) pstmt1.close();
if (rstt != null) rstt.close();
}
}


else
	{
	
	
			String sqt1="select gen_pid_using_alt_id1_rule_yn,pid_use_alt_id1_or_sys_gen from MP_PAT_SER_GRP where pat_ser_grp_code='"+common.trim()+"'";

			pstmt1 = con.prepareStatement(sqt1);
			rset1 = pstmt1.executeQuery();	
			
			if(rset1.next())
			{
				gen_pid_using_alt_id1_rule_yn1 = rset1.getString("gen_pid_using_alt_id1_rule_yn");
				pid_use_alt_id1_or_sys_gen = rset1.getString("pid_use_alt_id1_or_sys_gen");			
				
			}	
			

				if (pstmt1 != null) pstmt1.close();
				if (rset1 != null) rset1.close();

			if(gen_pid_using_alt_id1_rule_yn1.equals("Y") && pid_use_alt_id1_or_sys_gen.equals("A"))
			{
			%>

			<script language='Javascript'>

				
			//alert(parent.document.frames[1].document.forms[0].used_status.value);
			parent.f_query_add_mod.document.getElementById('gen_pid_using_alt_id1_rule_yn').value="<%=gen_pid_using_alt_id1_rule_yn1%>";

			//alert(parent.document.frames[1].document.forms[0].gen_pid_using_alt_id1_rule_yn.value);

			parent.f_query_add_mod.document.getElementById('mr_section_code_tr').style.visibility='hidden';

			parent.f_query_add_mod.document.getElementById('siteorfac').style.visibility='hidden';
			parent.f_query_add_mod.document.getElementById('site_or_facility_id').style.visibility='hidden';
			parent.f_query_add_mod.document.getElementById('sno').style.visibility='hidden';
			parent.f_query_add_mod.document.getElementById('start_srl_no').style.visibility='hidden';
			parent.f_query_add_mod.document.getElementById('maxlabel').style.visibility='hidden';
			parent.f_query_add_mod.document.getElementById('max_srl_no').style.visibility='hidden';
			parent.f_query_add_mod.document.getElementById('st').style.visibility='hidden';
			parent.f_query_add_mod.document.getElementById('st1').style.visibility='hidden';
			parent.f_query_add_mod.document.getElementById('st2').style.visibility='hidden';


			parent.f_query_add_mod.document.forms[0].site_or_facility.value="";
			parent.f_query_add_mod.document.forms[0].site_or_facility_id.value="";
			//parent.document.frames[1].document.forms[0].site_or_facility_id.disabled=true;
			//parent.document.frames[1].document.forms[0].start_srl_no.value="";
			//parent.document.frames[1].document.forms[0].max_srl_no.value="";
			//parent.document.frames[1].document.forms[0].start_srl_no.disabled=true;
			//parent.document.frames[1].document.forms[0].max_srl_no.disabled=true;
			parent.f_query_add_mod.document.forms[0].readonly_flag.value ="Y";

			var pat_ser_grp_code1=parent.f_query_add_mod.document.getElementById('pat_ser_grp_code').value;
			parent.result.location.href = "../../eMP/jsp/addPatientNumberingDetail_Result.jsp?pat_ser_grp_code="+pat_ser_grp_code1;

			</script>
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script>





			<%
			}
	}







	try{
		pstmt1=con.prepareStatement("select patient_id_length from mp_param");
		rset = pstmt1.executeQuery();	
		if(rset.next())
		{
			int patlen=rset.getInt("patient_id_length");
			if(scheme_id.equals("VDG"))
			{
			patlen=patlen-1;
			}
			int patlen2=patlen-2;

		try{				
			if(pstmt1!=null) pstmt1.close();
			pstmt1=con.prepareStatement("select prefix_reqd_yn from mp_pat_ser_grp where pat_ser_grp_code ='"+common.trim()+"'"); 
			rst=pstmt1.executeQuery();	
			if(rst.next())
			{
				String pxreq=rst.getString("prefix_reqd_yn");
		%><script>parent.f_query_add_mod.document.getElementById('pref_val').value="<%=pxreq%>";
		</script><%
				if(pxreq.equals("Y"))
				{
				
%>

		<script>
				
		
			//alert("<%=patlen%>");
		//	alert("<%=patlen2%>");
			parent.f_query_add_mod.document.getElementById('max_srl_no').maxLength="<%=patlen2%>";
			parent.f_query_add_mod.document.getElementById('start_srl_no').maxLength="<%=patlen2%>";
			
			
		
		</script>
		
	

<%	


				}
				else
				{

%>

	<script>
				
		//alert("<%=pxreq%>");
		parent.f_query_add_mod.document.forms[0].max_srl_no.maxLength="<%=patlen%>";
		parent.f_query_add_mod.document.forms[0].start_srl_no.maxLength="<%=patlen%>";
			
		
		
	</script>
					

<%

				}
				
			}

		
	}catch(Exception e) { /* out.println(e.toString()); */ e.printStackTrace();}
	finally
	{
		if (pstmt1 != null) pstmt1.close();
		if (rst != null) rst.close();
		if (rset!=null) rset.close();
	}		 		
		}
		out.println("</form></body></html>");
}catch(Exception e) { /* out.println(e.toString()); */ e.printStackTrace();}
finally
{
if (pstmt1 != null) pstmt1.close();
if (rset != null) rset.close();
}
	}
	else if(chksrc.trim().equals("formrsect")) 
		{		
	//select prefix_reqd_yn from mp_pat_ser_grp where pat_ser_grp_code ='"+common.trim()+"'"; 
	out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='nam1' id='nam1'>");
	
	String sr="";
	String slct="";
try{	
	pstmt1 = con.prepareStatement(" select pat_no_ctrl from mp_pat_ser_grp where pat_ser_grp_code='"+common1.trim()+"'");
	rss=pstmt1.executeQuery();	
	if(rss.next())
	{
		slct=rss.getString("pat_no_ctrl");
		//rss.close();	
	}
}catch(Exception e) { /* out.println(e.toString()); */ e.printStackTrace();}
finally
{
	if (pstmt1 != null) pstmt1.close();
	if (rss != null) rss.close();
}

	
 if(slct.trim().equals("Z"))
 {
	try{
	sr="select mr_section_code,short_name from mr_section where mr_section_type ='C' and  eff_status='E' and trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) order by short_name "; 	
	pstmt1 = con.prepareStatement(sr);
	rstt = pstmt1.executeQuery();	
	
%>


	<script>
		
		//alert("1");
		var n=parent.f_query_add_mod.document.forms[0].mr_section_code.options.length;
		for(var i=0;i<n;i++)
		{
		parent.f_query_add_mod.document.forms[0].mr_section_code.remove("mr_section_code");				

		}					
		var tp =" ---"+getLabel("Common.defaultSelect.label","Common")+"--- "
		var opt=parent.f_query_add_mod.document.createElement("OPTION");
		opt.text=tp;
		opt.value="";
		parent.f_query_add_mod.document.forms[0].mr_section_code.add(opt);					

	</script>	        

<%				
	 while( rstt.next() ) 
	 {
		moduleid = rstt.getString( "mr_section_code" ) ;	
		moduledesc= rstt.getString( "short_name" ) ;
%>

		<script>
			//alert("here");

			var temp = "<%=moduleid%>";
			var temp1="<%=moduledesc%>";
			var opt=parent.f_query_add_mod.document.createElement("OPTION");
			opt.text=temp1;
			opt.value=temp;
			parent.f_query_add_mod.document.forms[0].mr_section_code.add(opt);
		</script>
<%	

	 }

}catch(Exception e) { /* out.println(e.toString()); */ e.printStackTrace();}
finally
{
	if (pstmt1 != null) pstmt1.close();
	if (rstt != null) rstt.close();
}
	
 }
	
	else if(slct.trim().equals("U"))
	{
try{		 	
	sr="select mr_section_code,short_name from mr_section where facility_id='"+common.trim()+"' and mr_section_type ='C' and  eff_status='E' and trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) order by short_name ";  
	pstmt1 = con.prepareStatement(sr);
	rstt = pstmt1.executeQuery();	
	
%>

		<script>
				//alert("2");
				var n=parent.f_query_add_mod.document.forms[0].mr_section_code.options.length;
				for(var i=0;i<n;i++)
				{
				parent.f_query_add_mod.document.forms[0].mr_section_code.remove("mr_section_code");				
			
				}					
				var tp =" --"+getLabel("Common.defaultSelect.label","Common")+"--- "
				var opt=parent.f_query_add_mod.document.createElement("OPTION");
				opt.text=tp;
				opt.value="";
				parent.f_query_add_mod.document.forms[0].mr_section_code.add(opt);					

			</script>	        
				
<%				
				while( rstt.next() ) 
				{
					moduleid = rstt.getString( "mr_section_code" ) ;	
					moduledesc= rstt.getString( "short_name" ) ;
%>

				<script>
					//alert("here");
				
					var temp = "<%=moduleid%>";
					var temp1="<%=moduledesc%>";
					var opt=parent.f_query_add_mod.document.createElement("OPTION");
					opt.text=temp1;
					opt.value=temp;
					parent.f_query_add_mod.document.forms[0].mr_section_code.add(opt);
				</script>
			<%	

			 }
		}catch(Exception e) { /* out.println(e.toString()); */e.printStackTrace(); }
		finally
		{
			if (pstmt1 != null) pstmt1.close();
			if (rstt != null) rstt.close();
		}

	}
	out.println("</form></body></html>");
}

	}catch(Exception e){/* out.println(e); */ e.printStackTrace();}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
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

