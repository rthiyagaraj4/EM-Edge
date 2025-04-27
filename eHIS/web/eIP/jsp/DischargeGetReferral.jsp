<!DOCTYPE html>
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
		Connection con			= null;
		ResultSet rs			= null;
		Statement stmt			= null;
		Statement stmt_loc		= null;
		Statement stmt_loc1		= null;
		ResultSet rs_loc		= null;
		ResultSet rs_loc1		= null;
		Statement st_new		= null;

	try{
		con = ConnectionManager.getConnection(request);
		String facility_id	= (String) session.getValue( "facility_id" ) ;
	
		String sql						= "";
		String sql_loc					= "";
		String sql_loc1					= "";
		String org_type					= "";
		String org_type_desc			= "";
		String nursingUnitDesc			= "";
		String nursingUnitCode			= "";
		String clinicDesc				= "";
		String clinicCode				= "";
		String referredtoid				= "";
		String referredtodesc			= "";
		String hcare_setting_type_desc	= "";
		String hcare_setting_type_code	= "";
		String hcare_setting_type		= "";
		
		int ip	= 0;
		int op	= 0;

		String ref_type	=	request.getParameter("ref_type");
		if(ref_type==null) ref_type="";
		
		String loc_type=request.getParameter("loc_type");
		if(loc_type==null) loc_type="";

		String ref_to=request.getParameter("ref_to");
		if(ref_to==null) ref_to="";

		String location1=request.getParameter("location1");
		if(location1==null) location1="";

		String specLoad=request.getParameter("specLoad");
		if(specLoad==null) specLoad="";

		String Option = request.getParameter("Option");
		if(Option == null) Option = "Y";

		String resetHcare = request.getParameter("resetHcare");
		if(resetHcare == null) resetHcare = "N";

		String referred_to_id=request.getParameter("referred_to_id");
		if(referred_to_id==null) referred_to_id="";

		String referred_to_desc=request.getParameter("referred_to_desc");
		if(referred_to_desc==null) referred_to_desc="";

		String loc0=request.getParameter("loc0");
		if(loc0==null) loc0="";

		String src1=request.getParameter("src1");
		if(src1 == null) src1 = "";

		String specialty=request.getParameter("specialty");
		if (specialty == null ) specialty = "";

		String service=request.getParameter("service");
		if (service == null ) service = "";

		String jsp_val=request.getParameter("jsp_val");
		if (jsp_val == null ) jsp_val = "";

		String BodyFrame = request.getParameter("BodyFrame");
		if (BodyFrame == null ) BodyFrame = "";

		String Module = request.getParameter("Module");
		if (Module == null ) Module = "";

		String hcare_type_code = request.getParameter("hcare_type");
		if(hcare_type_code==null) hcare_type_code="";

		%>
		<script>
			var BodyFrame = "<%=BodyFrame%>"	
		</script>
		<%

/*
	Referral Types	:	Login Facility		[ code : L ]
					:	Enterprise			[ code : E ]
					:	External			[ code : X ]

		Module		: Outpatient MAnagement [ code : OP ]
					: Inpatient MAnagement	[ code : IP ]


*/
/// Setting the Value For [ ORG TYPE ] For Different Referral Types ... 
		
		sql="SELECT Nvl(org_type, ' ') as org_type FROM am_referral WHERE referral_code='"+referred_to_id+"'";

		stmt=con.createStatement();
		rs=stmt.executeQuery(sql);
		
		if(rs.next())
		{
		   org_type=rs.getString("org_type").trim();
		}
		if(rs!=null)		rs.close();
		if(stmt!=null)		stmt.close();
	
		if(ref_type.equals("X"))
		{
			if(org_type.equals("G") || org_type.length() == 0 || org_type==null) 			org_type_desc="<b>Government</b>";

			if(org_type.equals("P")) 
				org_type_desc="<b>Private</b>";
		}
		
		if(ref_type.equals("E") || ref_type.equals("L"))
			org_type_desc="<b>Government</b>";
%>
	<script>
	var ref_type = "<%=ref_type%>";
	if(ref_type == 'L')
		if(eval(BodyFrame).document.getElementById('org_type')) 
			eval(BodyFrame).document.getElementById('org_type').innerHTML="<%=org_type_desc%>"; 
	</script>
<%

if(src1.equals("populateBlankORG"))
{
org_type_desc="<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b>";
%>
	<script>
		if(eval(BodyFrame).document.getElementById('org_type')) 
			eval(BodyFrame).document.getElementById('org_type').innerHTML="<%=org_type_desc%>"; 
	</script>
<%
}


/// Func used to Populate Hcare Values based on Referral type & Module...
if(src1.equals("populateHcare"))
{

	if(ref_type.equals("L"))
	{
		/// Func used to Populate Hcare Values If Referral type is Login facilty...

		sql="select a.FACILITY_ID referred_to_id,a.FACILITY_NAME referred_to_id_desc ,a.hcare_setting_type_code hcare_setting_type_code, b.short_desc  hcare_setting_type_desc from sm_facility_param a, am_hcare_setting_type b where a.facility_id = '"+facility_id+"' and a.hcare_setting_type_code=b.hcare_setting_type_code and a.hcare_setting_type_code in ( select to_hcare_setting_type_code from am_hcare_setting_type_rstrn where from_hcare_setting_type_code = (select hcare_setting_type_code from sm_facility_param where facility_id = '"+facility_id+"' ) and (ip_referral_yn = 'Y'  or op_referral_yn = 'Y') ) order by a.facility_name ";	

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
				var ref_type= "<%=ref_type%>";
				var temp	= "<%=referredtoid%>";
				var temp1	= "<%=referredtodesc%>";
				var jsp_val = "<%=jsp_val%>";

				var hcare_setting_type_desc	= "<%=hcare_setting_type_desc%>";
				var hcare_setting_type		= "<%=hcare_setting_type%>";

				var hcareOpt	= eval(BodyFrame).document.createElement("OPTION");
				hcareOpt.text	= hcare_setting_type_desc;
				hcareOpt.value	= hcare_setting_type;
				hcareOpt.selected=true;

		if(ref_type == "L" || ref_type == "E")
		{
			var opt3=eval(BodyFrame).document.createElement("OPTION");
			opt3.text=temp1;
			opt3.value=temp;
			
			if (jsp_val != "")
			{
				var ref_code = eval(BodyFrame).document.forms[0].referral_type.value;
				if (ref_code == temp)
				if(ref_type == "L" || ref_type == "E")
				{	
					opt3.selected=true;
				}
			}

			<%if(referred_to_id.equals(referredtoid) || ref_type.equals("L") || ref_type.equals("E")) 
			{%>
				opt3.selected=true;
			<%} %>
			
			eval(BodyFrame).document.forms[0].referred_to.add(opt3);
		}
		eval(BodyFrame).document.forms[0].hcare_setting_type.add(hcareOpt);
		eval(BodyFrame).document.forms[0].hcare_setting_type_desc.value=hcare_setting_type_desc;
		</script>
	<%
		}// E.O While
		if(rs!=null)		rs.close();
		if(stmt!=null)		stmt.close();
	  }// E.O If
	}// E.O if(ref_type.equals("L")
	else
	if(ref_type.equals("E") || ref_type.equals("X"))
	{
		if(Module.equals("IP"))
		{
//			out.println("<script>alert('IP Module & ref_type : "+ref_type+"');</script>");
			/// Func used to Populate Hcare Values If Referral type is External or Enterprise  and Module is IP...
			String hcareSql = " SELECT HCARE_SETTING_TYPE_CODE, SHORT_DESC FROM AM_HCARE_SETTING_TYPE WHERE EFF_STATUS = 'E' AND HCARE_SETTING_TYPE_CODE = (SELECT FROM_HCARE_SETTING_TYPE_CODE FROM AM_HCARE_SETTING_TYPE_RSTRN WHERE IP_REFERRAL_YN = 'Y' AND FROM_HCARE_SETTING_TYPE_CODE = HCARE_SETTING_TYPE_CODE UNION SELECT TO_HCARE_SETTING_TYPE_CODE FROM AM_HCARE_SETTING_TYPE_RSTRN WHERE IP_REFERRAL_YN = 'Y' AND TO_HCARE_SETTING_TYPE_CODE = HCARE_SETTING_TYPE_CODE) order by SHORT_DESC ";

			stmt=con.createStatement();
			rs=stmt.executeQuery(hcareSql);

			if(rs!=null)
			{
				while(rs.next())
				{
					hcare_setting_type_desc	= rs.getString("SHORT_DESC");
					hcare_setting_type_code = rs.getString("HCARE_SETTING_TYPE_CODE");
				%>
				<script>
					var hcare_setting_type_desc = "<%=hcare_setting_type_desc%>";
					var hcare_setting_type_code = "<%=hcare_setting_type_code%>";
							
					var hcareOpt = eval(BodyFrame).document.createElement("OPTION");
					hcareOpt.text	= hcare_setting_type_desc;
					hcareOpt.value	= hcare_setting_type_code;
				eval(BodyFrame).document.forms[0].hcare_setting_type.add(hcareOpt);
				</script>
				<%
				}// E.O While
			if(rs!=null)		rs.close();
			if(stmt!=null)		stmt.close();
			}// E.O if
		}
		else
		if(Module.equals("OP"))
		{
//			out.println("<script>alert('OP Module & ref_type : "+ref_type+"');</script>");
			/// Func used to Populate Hcare Values If Referral type is External or Enterprise  and Module is OP...
			String hcareSql = " SELECT HCARE_SETTING_TYPE_CODE, SHORT_DESC FROM AM_HCARE_SETTING_TYPE WHERE EFF_STATUS = 'E' AND HCARE_SETTING_TYPE_CODE = (SELECT FROM_HCARE_SETTING_TYPE_CODE FROM AM_HCARE_SETTING_TYPE_RSTRN WHERE OP_REFERRAL_YN = 'Y' AND FROM_HCARE_SETTING_TYPE_CODE = HCARE_SETTING_TYPE_CODE UNION SELECT TO_HCARE_SETTING_TYPE_CODE FROM AM_HCARE_SETTING_TYPE_RSTRN WHERE OP_REFERRAL_YN = 'Y' AND TO_HCARE_SETTING_TYPE_CODE = HCARE_SETTING_TYPE_CODE) order by SHORT_DESC ";

			stmt=con.createStatement();
			rs=stmt.executeQuery(hcareSql);

			if(rs!=null)
			{
				while(rs.next())
				{
					hcare_setting_type_desc	= rs.getString("SHORT_DESC");
					hcare_setting_type_code = rs.getString("HCARE_SETTING_TYPE_CODE");
				%>
				<script>
					var hcare_setting_type_desc = "<%=hcare_setting_type_desc%>";
					var hcare_setting_type_code = "<%=hcare_setting_type_code%>";
							
					var hcareOpt = eval(BodyFrame).document.createElement("OPTION");
					hcareOpt.text	= hcare_setting_type_desc;
					hcareOpt.value	= hcare_setting_type_code;
				eval(BodyFrame).document.forms[0].hcare_setting_type.add(hcareOpt);
				</script>
				<%
				}// E.O While
		if(rs!=null)		rs.close();
		if(stmt!=null)		stmt.close();
			}// E.O if
		}
	}// E.O ref_type

	if(ref_type.equals("E") || ref_type.equals("L"))
	{

		/// <<<<< OP + IP >>>>> Value	
		sql_loc="select count(distinct decode(ip_referral_yn,'N',null,ip_referral_yn) ) ip, count(distinct decode(op_referral_yn,'N',null,op_referral_yn) ) op from am_hcare_setting_type_rstrn where from_hcare_setting_type_code= (select hcare_setting_type_code from sm_facility_param where facility_id = '"+facility_id+"' ) and (ip_referral_yn='Y' or op_referral_yn = 'Y') ";

		stmt_loc=con.createStatement();
		rs_loc=stmt_loc.executeQuery(sql_loc);
		
		if(rs_loc!=null)
		{
			if (rs_loc.next())
			{
				ip	= rs_loc.getInt(1);
				op	= rs_loc.getInt(2);
			}
			if(rs_loc!=null)	rs_loc.close();
			if(stmt_loc!= null)stmt_loc.close();		
		}

			if (ip > 0 )
			{
				if (ref_type.equals("L") && op > 0)
				{
					if(Option.equals("Y"))
					{	%>
						<script>
						opt=eval(BodyFrame).document.createElement("OPTION");
						opt.text="Nursing Unit";
						opt.value="N";
						eval(BodyFrame).document.forms[0].location0.add(opt);
			eval(BodyFrame).location0_array[eval(BodyFrame).location0_array.length] = opt
					</script>
				<%	}	%>
					<script>
					opt=eval(BodyFrame).document.createElement("OPTION");
					opt.text="Clinic";
					opt.value="C";
					eval(BodyFrame).document.forms[0].location0.add(opt);
					eval(BodyFrame).location0_array[ eval(BodyFrame).location0_array.length] = opt;
					opt=eval(BodyFrame).document.createElement("OPTION");
					opt.text="Day Care";
					opt.value="D";
					eval(BodyFrame).document.forms[0].location0.add(opt);
			eval(BodyFrame).location0_array[eval(BodyFrame).location0_array.length] = opt;
					</script>
	<%		}
			else if (op > 0)
			{
				if(Option.equals("Y"))
				{
			%>
					<script>			
						opt=eval(BodyFrame).document.createElement("OPTION");
						opt.text="Nursing Unit";
						opt.value="N";
						eval(BodyFrame).document.forms[0].location0.add(opt);
			eval(BodyFrame).location0_array[eval(BodyFrame).location0_array.length] = opt
					</script>
				<%	}	%>
					<script>
				opt=eval(BodyFrame).document.createElement("OPTION");
				opt.text="Clinic";
				opt.value="C";
				eval(BodyFrame).document.forms[0].location0.add(opt);
			eval(BodyFrame).location0_array[eval(BodyFrame).location0_array.length] = opt
				opt=eval(BodyFrame).document.createElement("OPTION");
				opt.text="Day Care";
				opt.value="D";
				eval(BodyFrame).document.forms[0].location0.add(opt);
			eval(BodyFrame).location0_array[eval(BodyFrame).location0_array.length] = opt;
			</script>
			<%
			}
			else
			{
%>           <script>
				opt=eval(BodyFrame).document.createElement("OPTION");
				opt.text="Nursing Unit";
				opt.value="N";
				eval(BodyFrame).document.forms[0].location0.add(opt);
				eval(BodyFrame).location0_array[eval(BodyFrame).location0_array.length] = opt
			</script>
			<%
			}
	}
	else
	if(op>0)
	{
	%>
		<script>
			opt=eval(BodyFrame).document.createElement("OPTION");
			opt.text="Clinic";
			opt.value="C";
			eval(BodyFrame).document.forms[0].location0.add(opt);
			eval(BodyFrame).location0_array[eval(BodyFrame).location0_array.length] = opt
		</script>
<%	}
}

/// Added by Sridhar R on 8 June 2004
/// This will clear all the values of Specialty onChange of Refferal Type & default its initial Values ...
	if(specLoad.equals("1"))
	{
		String Specialty_Desc = "";
		String Specialty_Code = "";

		sql = "Select Short_Desc,Speciality_Code from Am_Speciality where Eff_Status = 'E' order by 1";
		stmt=con.createStatement();
		rs = stmt.executeQuery(sql);
%>
	<script>
		var specialty = eval(BodyFrame).document.forms[0].speciality;
		while(specialty.options.length > 0)
			specialty.remove(specialty.options[1]);

		var specialtyOpt	= eval(BodyFrame).document.createElement("OPTION");
		specialtyOpt.text	= "--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
		specialtyOpt.value	= "";
		eval(BodyFrame).document.forms[0].speciality.add(specialtyOpt);
	</script>
	<%
		while(rs.next())
		{
			Specialty_Code = rs.getString("Speciality_Code"); 
			Specialty_Desc = rs.getString("Short_Desc");
			if(Specialty_Code==null) Specialty_Code="";
			if(Specialty_Desc==null) Specialty_Desc="";
		%>	<script>
				var specialtyOpt	= eval(BodyFrame).document.createElement("OPTION");
				specialtyOpt.text	= "<%=Specialty_Desc%>";
				specialtyOpt.value	= "<%=Specialty_Code%>";
				eval(BodyFrame).document.forms[0].speciality.add(specialtyOpt);
			</script>
		<%
		}
		if(rs!=null)	rs.close();
		if(stmt!= null)stmt.close();		
	%>	
	<script>
		eval(BodyFrame).document.forms[0].service.value = "";
		eval(BodyFrame).document.forms[0].priority.value = "";
	</script>
<%
	}//E.O SpecLoad
}// E.O if(src1.equals("populateHcare"))

if(src1.equals("populateReferredTo"))
{
	if(ref_type.equals("E"))
	{			
//		out.println("<script>alert('ref_type(E) IP/OP');</script>");

		String HCARE_TYPE_CODE = request.getParameter("hcare_type");
		String referredToSql = " SELECT FACILITY_ID REFERRED_TO_ID, FACILITY_NAME REFERRED_TO_ID_DESC FROM SM_FACILITY_PARAM WHERE FACILITY_ID != '"+facility_id+"' AND  HCARE_SETTING_TYPE_CODE='"+HCARE_TYPE_CODE+"' order by 2";

		stmt=con.createStatement();
		rs=stmt.executeQuery(referredToSql);

		if(rs!=null)
		{
			while(rs.next())
			{
				referredtoid			=	rs.getString("REFERRED_TO_ID");
				referredtodesc			=	rs.getString("REFERRED_TO_ID_DESC");
			%>
			<script>
				var referredToCode = "<%=referredtoid%>";
				var referredToDesc = "<%=referredtodesc%>";
						
				var referredToOpt = eval(BodyFrame).document.createElement("OPTION");
				referredToOpt.text	= referredToDesc;
				referredToOpt.value = referredToCode;
				eval(BodyFrame).document.forms[0].referred_to.add(referredToOpt);
			</script>
			<%
			}// E.O while
			if(rs!=null)	rs.close();
			if(stmt!= null)stmt.close();		
			}// E.O if
	}// E.O if(ref_type.equals("E"))
	else
	if( ref_type.equals("X"))
	{
		if(Module.equals("IP"))
		{
//			out.println("<script>alert('ref_type(X) & Module(IP)');</script>");

			String HCARE_TYPE_CODE = request.getParameter("hcare_type");
			String referredToSql = "SELECT SHORT_DESC, REFERRAL_CODE FROM AM_REFERRAL WHERE EFF_STATUS = 'E' AND DEST_USE_AT_DISCH_YN = 'Y' AND HEALTHCARE_SETTING_TYPE='"+HCARE_TYPE_CODE+"' order by 1 ";

			stmt=con.createStatement();
			rs=stmt.executeQuery(referredToSql);

			if(rs!=null)
			{
				while(rs.next())
				{
					referredtoid	=	rs.getString("REFERRAL_CODE");
					referredtodesc	=	rs.getString("SHORT_DESC");
				%>
				<script>
					var referredToCode = "<%=referredtoid%>";
					var referredToDesc = "<%=referredtodesc%>";
							
					var referredToOpt = eval(BodyFrame).document.createElement("OPTION");
					referredToOpt.text	= referredToDesc;
					referredToOpt.value = referredToCode;
					eval(BodyFrame).document.forms[0].referred_to.add(referredToOpt);
				</script>
				<%
				}// E.O while
			if(rs!=null)	rs.close();
			if(stmt!= null)stmt.close();		
			}// E.O if
		}
		else
		if(Module.equals("OP"))
		{
//			out.println("<script>alert('ref_type(X) & Module(OP)');</script>");

			String HCARE_TYPE_CODE = request.getParameter("hcare_type");
			String referredToSql = " SELECT SHORT_DESC, REFERRAL_ID FROM AM_REFERRAL WHERE EFF_STATUS = 'E' AND DEST_USE_AT_CONCL_YN = 'Y' AND HEALTHCARE_SETTING_TYPE = ='"+HCARE_TYPE_CODE+"' order by 1 ";

			stmt=con.createStatement();
			rs=stmt.executeQuery(referredToSql);

			if(rs!=null)
			{
				while(rs.next())
				{
					referredtoid	=	rs.getString("REFERRED_TO_ID");
					referredtodesc	=	rs.getString("REFERRED_TO_ID_DESC");
				%>
				<script>
					var referredToCode = "<%=referredtoid%>";
					var referredToDesc = "<%=referredtodesc%>";
							
					var referredToOpt = eval(BodyFrame).document.createElement("OPTION");
					referredToOpt.text	= referredToDesc;
					referredToOpt.value = referredToCode;
					eval(BodyFrame).document.forms[0].referred_to.add(referredToOpt);
				</script>
				<%
				}// E.O while
			}// E.O if
		}
	}
}

// The function will query the SPECIALTY options if Referral Type is External..
if(src1.equals("populateSpecialty"))
{
	String hcare_code   = request.getParameter("hcare_code");
	String ref_to_code	= request.getParameter("ref_to_code");
	if(ref_to_code ==null) ref_to_code  ="";
	if(hcare_code==null) hcare_code="";

	if(ref_type.equals("X"))
	{
		String specialty_short_desc	= "";
		String specialty_code		= "";
		
		String sql_ext_specialty = "Select specialty_code,specialty_short_desc from am_referral_for_specialty_vw where referral_code='"+ref_to_code+"' order by 2";
			
			st_new	= con.createStatement();
			rs		= st_new.executeQuery(sql_ext_specialty);
			if(rs!=null)
			{
				while(rs.next())
				{
					specialty_code		= rs.getString("specialty_code");
					specialty_short_desc= rs.getString("specialty_short_desc");
					%>
					<script>
						var temp = "<%=specialty_code%>";
						var temp1="<%=specialty_short_desc%>";
						var opt=eval(BodyFrame).document.createElement("OPTION");
						opt.text=temp1;
						opt.value=temp;
						eval(BodyFrame).document.forms[0].speciality.add(opt);
					</script>
			<%	}	
			if(rs!=null)	rs.close();
			if(st_new!= null)st_new.close();
}
	}//if ref type='X'
%>
	<script>
	var ref_type= "<%=ref_type%>";
	var org		= "<%=org_type_desc%>";
	if(ref_type == 'E' || ref_type == 'X')
	  if(eval(BodyFrame).document.getElementById('org_type')) 
		eval(BodyFrame).document.getElementById('org_type').innerHTML="<%=org_type_desc%>"; 
	</script>
<%
}

if(src1.equals("populateORG"))
{
%>
	<script>
	var ref_type = "<%=ref_type%>";
	var org = "<%=org_type_desc%>";
	if(ref_type == 'E' || ref_type == 'L')
		if(eval(BodyFrame).document.getElementById('org_type')) 
		eval(BodyFrame).document.getElementById('org_type').innerHTML="<%=org_type_desc%>"; 
	</script>
<%
}

if(src1.equals("populateLocation"))
{
	/// Func used to Display Location Values based on Location Type...
%>
	<script>
	// If Loaction Type is Clinic, then Referred For is Disabled...
		eval(BodyFrame).document.forms[0].ref_for_ip.disabled = false; 
	</script>
<%

	if(service == null) service = "";

	String referred_to = request.getParameter("ref_to");
	if(referred_to == null) referred_to = "";

/// FOR Location Type = "Clinic"
	if(loc_type.equals("C"))
	{	
		if(!service.equals(""))
		{
			sql_loc1=" SELECT SHORT_DESC CLINIC_DESC, CLINIC_CODE FROM OP_CLINIC WHERE EFF_STATUS = 'E' AND FACILITY_ID = '"+referred_to+"' AND SERVICE_CODE = '"+service+"' UNION SELECT CLINIC_SHORT_DESC CLINIC_DESC, CLINIC_CODE FROM OP_CLINIC_FOR_SERVICE_VW WHERE FACILITY_ID = '"+referred_to+"' AND SERVICE_CODE = '"+service+"' order by 1 ";		
		}
		else if(service.equals(""))
		{
		   sql_loc1=" SELECT SHORT_DESC CLINIC_DESC, CLINIC_CODE FROM OP_CLINIC WHERE EFF_STATUS = 'E' AND FACILITY_ID = '"+referred_to+"' and speciality_code = '"+specialty+"' order by 1 ";		
		}


		stmt_loc1=con.createStatement();
		rs_loc1=stmt_loc1.executeQuery(sql_loc1);
		if(rs_loc1!=null)
		{
			while(rs_loc1.next())
			{
				clinicDesc	= rs_loc1.getString("CLINIC_DESC");
				clinicCode	= rs_loc1.getString("CLINIC_CODE");
				%>
				<script>
					var opt=eval(BodyFrame).document.createElement("OPTION");
					opt.text	= "<%=clinicDesc%>"; 
					opt.value	= "<%=clinicCode%>";
				</script>
				<%if(location1.equals(clinicCode) ) 
				{%>
					<script>opt.selected=true;	</script>
				<%} %>
					<script>
						eval(BodyFrame).document.forms[0].location1.add(opt);
					</script>
			<%
			}// E.O While
			if(rs_loc!=null)	rs_loc.close();
			if(stmt_loc1!= null)stmt_loc1.close();
		}// E.O If
		%>
			<script>
			// If Loaction Type is Clinic, then Referred For is Disabled...
				eval(BodyFrame).document.forms[0].ref_for_ip.disabled = true; 
			</script>
		<%
	}// E.O if(loc_type.equals("C"))

/// FOR Location Type = "Nursing Unit"
	if (loc_type.equals("N"))
	{
		if(!service.equals(""))
		{
	
		   sql_loc1=" SELECT SHORT_DESC NU_DESC, NURSING_UNIT_CODE FROM IP_NURSING_UNIT WHERE EFF_STATUS = 'E' AND FACILITY_ID = '"+referred_to+"' AND SERVICE_CODE = '"+service+"' AND APPL_PATIENT_CLASS = 'IP' UNION SELECT SHORT_DESC NU_DESC, NURSING_UNIT_CODE FROM IP_NURS_UNIT_FOR_SERVICE_VW WHERE AND FACILITY_ID = '"+referred_to+"' AND SERVICE_CODE = '"+service+"' AND APPL_PATIENT_CLASS = 'IP' order by 1 ";
		}
		else if(service.equals(""))
		{
		   sql_loc1=" SELECT SHORT_DESC NU_DESC, NURSING_UNIT_CODE FROM IP_NURSING_UNIT WHERE EFF_STATUS = 'E' AND FACILITY_ID = '"+referred_to+"' AND APPL_PATIENT_CLASS = 'IP' order by 1 ";
		}

		stmt_loc1=con.createStatement();
		rs_loc1=stmt_loc1.executeQuery(sql_loc1);

		if(rs_loc1!=null)
		{
			while(rs_loc1.next())
			{
				nursingUnitDesc	= rs_loc1.getString("NU_DESC");
				nursingUnitCode	= rs_loc1.getString("NURSING_UNIT_CODE");
				%>
				<script>
					var opt=eval(BodyFrame).document.createElement("OPTION");
					opt.text	= "<%=nursingUnitDesc%>"; 
					opt.value	= "<%=nursingUnitCode%>";
				</script>
				<%if(location1.equals(nursingUnitCode) ) 
				{%>
					<script> opt.selected=true;	</script>
				<%} %>
					<script>
						eval(BodyFrame).document.forms[0].location1.add(opt);
//						eval(BodyFrame).document.forms[0].location1_desc.value=temp1;
					</script>
			<%
			}// E.O While
			if(rs_loc!=null)	rs_loc.close();
			if(stmt_loc1!= null)stmt_loc1.close();
		}// E.O If
	}// E.O if (loc_type.equals("N"))

/// FOR Location Type = "Day Care"
	if (loc_type.equals("D"))
	{
		if(!service.equals(""))
		{ 
		   sql_loc1=" SELECT SHORT_DESC NU_DESC, NURSING_UNIT_CODE FROM IP_NURSING_UNIT WHERE EFF_STATUS = 'E' AND FACILITY_ID = '"+referred_to+"' AND SERVICE_CODE = '"+service+"' AND APPL_PATIENT_CLASS = 'DC' UNION SELECT NURSING_UNIT_SHORT_DESC NU_DESC, NURSING_UNIT_CODE FROM IP_NURS_UNIT_FOR_SERVICE_VW WHERE FACILITY_ID = '"+referred_to+"' AND SERVICE_CODE = '"+service+"' AND APPL_PATIENT_CLASS = 'DC' order by 1 ";
		}
		else if(service.equals(""))
		{ 
		   sql_loc1=" SELECT SHORT_DESC NU_DESC, NURSING_UNIT_CODE FROM IP_NURSING_UNIT WHERE EFF_STATUS = 'E' AND FACILITY_ID = '"+referred_to+"' AND APPL_PATIENT_CLASS = 'IP' order by 1 ";
		}
		
		stmt_loc1=con.createStatement();
		rs_loc1=stmt_loc1.executeQuery(sql_loc1);
		if(rs_loc1!=null)
		{
			while(rs_loc1.next())
			{
				nursingUnitDesc	= rs_loc1.getString("NU_DESC");
				nursingUnitCode	= rs_loc1.getString("NURSING_UNIT_CODE");
				%>
				<script>
					var opt=eval(BodyFrame).document.createElement("OPTION");
					opt.text	= "<%=nursingUnitDesc%>"; 
					opt.value	= "<%=nursingUnitCode%>";
				</script>
			<%	if(location1.equals(nursingUnitCode)) 
				{	%>
					<script> opt.selected=true;	</script>
			<%	} %>
					<script>
						eval(BodyFrame).document.forms[0].location1.add(opt);
					</script>
			<%
			}// E.O While
			if(rs_loc!=null)	rs_loc.close();
			if(stmt_loc1!= null)stmt_loc1.close();
		}// E.O If
	}// E.O if (loc_type.equals("D"))
}// E.O if(src1.equals("populateLocation"))

%>
</head>
<body class=message onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name='dummyform' id='dummyform'></form>
</body>
	<%
	}catch(Exception e)
	{
		out.println(e);
	}
	finally 
	{ 
		if(stmt!=null)		stmt.close();
		if(rs!=null)		rs.close();
		if(stmt_loc!= null) stmt_loc.close();
		ConnectionManager.returnConnection(con,request);
		if(stmt_loc1!= null)stmt_loc1.close();
		if(rs_loc!=null)	rs_loc.close();
		if(rs_loc1!=null)	rs_loc1.close();
		if(st_new!=null)	st_new.close();
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

