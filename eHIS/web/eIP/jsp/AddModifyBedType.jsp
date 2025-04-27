<!DOCTYPE html>
<%
/// MODULE			:	InPatient Management..(IP)
/// Function Name	:	IPCodeSetup -> Bed Type
%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con		= null;
/* 	Statement stmt		= null; */
	PreparedStatement pstmt = null;
	ResultSet rset		= null;
	ResultSet rs		= null;
	ResultSet rset_bl_service	=	null;
	String dat			= "";
	String ID			= "";
	String sel			= "";
	String dly_charge	= "";
	String facilityId	= (String)session.getValue("facility_id");
try {
	con = ConnectionManager.getConnection(request);
	/* stmt = con.createStatement(); */
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
  <head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	
	<script src='../js/BedType.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	

	<script>
	</script>
</head>

<body onLoad='FocusFirstElement();' onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<%
   String bed_type_code			="";
   String longdesc				="";
   String shortdesc				="";
//   String deposit_appl_yn		="";
//   String addl_dep_yn			="";
   String bed_class_code		="";
   String effstatus				="";
   String codeTextAttribute		="";
   String otherTextAttribute	="";
	String checkBoxAttribute1	="";
	String special_bed_type_yn = "";
	String spcl_bedtype_disable = "";
   String checkBoxAttribute		="";
   String eventFunctionForCase	="";
   StringBuffer sql				= new StringBuffer();
   StringBuffer sql_bl_service  = new StringBuffer();
   String blng_class_code		="";
   String blng_serv_code		="";
   String setup_bl_dtls_in_ip_yn="N";
   boolean newSpeciality		=false;
   long	bed_count=0;	
%>
<%
	bed_type_code=request.getParameter("bed_type_code");

		try
		{
			StringBuffer sql_bl = new StringBuffer();
			sql_bl.append("select setup_bl_dtls_in_ip_yn from ip_param where facility_id=? ");
			pstmt = con.prepareStatement(sql_bl.toString());
			pstmt.setString(1, facilityId);			
			rs = pstmt.executeQuery();
			
/* 			stmt = con.createStatement();
			rs = stmt.executeQuery(sql_bl.toString()); */

			if(rs!=null )
			{
				while(rs.next())
				 {
						setup_bl_dtls_in_ip_yn = rs.getString("setup_bl_dtls_in_ip_yn");
				 }
			}

			if(setup_bl_dtls_in_ip_yn == null || setup_bl_dtls_in_ip_yn.equals("") || setup_bl_dtls_in_ip_yn == "") 	setup_bl_dtls_in_ip_yn = "";

			if ( rs != null) rs.close();
			if ( pstmt != null) pstmt.close();
	  }
	  catch(Exception e)
		{
			//out.print("Exception here1 :"+e);
			e.printStackTrace();
		}

	if(bed_type_code==null)
	 {
		bed_type_code		="";
		longdesc			="";
		shortdesc			="";
//		deposit_appl_yn		="";
//		addl_dep_yn			="";
		effstatus			="E";
		codeTextAttribute	="";
		otherTextAttribute	="";
		checkBoxAttribute1	="CHECKED";
		checkBoxAttribute	="CHECKED";
		newSpeciality		=true;
		eventFunctionForCase="OnBlur='ChangeUpperCase(this)'";
	 }
	 else
	 {
		try{

			
		sql.append("SELECT * from ip_bed_type where bed_type_code=?");
		pstmt = con.prepareStatement(sql.toString());
		
		pstmt.setString(1, bed_type_code);
		rset = pstmt.executeQuery();
		
		/* 		stmt = con.createStatement();
		rset = stmt.executeQuery(sql.toString()); */
		rset.next();
		bed_type_code	=	rset.getString("bed_type_code");
		longdesc		=	rset.getString("long_desc");
		shortdesc		=	rset.getString("short_desc");
		effstatus		=	rset.getString("eff_status");
		special_bed_type_yn		=	rset.getString("special_bed_type_yn")==null?"":rset.getString("special_bed_type_yn");
		bed_class_code	=	rset.getString("bed_class_code")==null?"":rset.getString("bed_class_code");

	   if(rset!=null) rset.close();
	   if(pstmt!=null) pstmt.close();
		
		if(special_bed_type_yn.equals("N"))
		{
			checkBoxAttribute1 = "";
		}
		else
			if(special_bed_type_yn.equals("Y"))
		{
			checkBoxAttribute1 = "checked";
			
		}
		spcl_bedtype_disable = "disabled";
		

		if(effstatus.equals("D"))
		{
		    otherTextAttribute	= "READONLY";
		    checkBoxAttribute	= "";
		}
		else
		{
			otherTextAttribute	="";
			checkBoxAttribute	="CHECKED";
		}
		}catch(Exception e)
		{
	/* 		out.println("Exception ip_bed_type : "+e);
			e.toString(); */
			e.printStackTrace();
		}

	   if(sql.length() > 0) sql.delete(0,sql.length());
	   if(pstmt != null) pstmt.close();
	   sql.append("SELECT count(1) as bed_count from ip_nursing_unit_bed where facility_id = ? and bed_type_code=? ");
		pstmt = con.prepareStatement(sql.toString());
		
		pstmt.setString(1, facilityId);
		pstmt.setString(2, bed_type_code);
		
		rset = pstmt.executeQuery();
	   
	   /* 	   stmt = con.createStatement();
	   rset = stmt.executeQuery(sql.toString()); */
	   rset.next();
	   bed_count=rset.getLong("bed_count");

	   if(rset!=null) rset.close();
	   if(pstmt!=null) pstmt.close();

		if(setup_bl_dtls_in_ip_yn.equals("Y"))
		{
		try
		{
			//added by shubha
			sql_bl_service.append("SELECT * from bl_ip_bed_type where bed_type_code=?");
			pstmt = con.prepareStatement(sql_bl_service.toString());
			pstmt.setString(1, bed_type_code);
			rset_bl_service = pstmt.executeQuery();
				
			/* 		stmt = con.createStatement();
			rset_bl_service = stmt.executeQuery(sql_bl_service.toString());*/
			if(rset_bl_service!=null)
			{
				while(rset_bl_service.next())
				{
				blng_class_code=rset_bl_service.getString("blng_class_code")==null?"":rset_bl_service.getString("blng_class_code");
				blng_serv_code=rset_bl_service.getString("blng_serv_code")==null?"":rset_bl_service.getString("blng_serv_code");
				}

			}
	      if(rset_bl_service!=null) rset_bl_service.close();
		if(pstmt!=null)	pstmt.close();
		if(rset!=null)	rset.close();
		}catch(Exception e)
		{
			/* out.println("Exception bl_ip_bed_type : "+e);
			e.toString(); */
			e.printStackTrace();
		}
    }
		codeTextAttribute	="READONLY";
		newSpeciality		=false;
		eventFunctionForCase="";
	}
%>

	<form name='bedtype_form' id='bedtype_form' action='../../servlet/eIP.BedTypeServlet' method='post' target='messageFrame'>
	<div>
	<br><br>
<%
	if (setup_bl_dtls_in_ip_yn.equals("N")) 
	{ %>
		<BR><BR> 
<%}%>
		<br><br><br><br>

	<table border='0' cellpadding='0' cellspacing='0' width='auto' align='center'>
	<tr>
      	<td class='label' width='10%'>&nbsp;</td>
				<td class='label'>&nbsp;</td>
				<td class='label'>&nbsp;</td>
				<td class='label' width='10%'>&nbsp;</td>
		</tr>
      		<tr>
      		    <td class='label'>&nbsp;</td>
      		    <td align='right' class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      		    <td class='fields'><input type='text' name='code' id='code' value="<%=bed_type_code%>" size='2' maxlength='2' <%=codeTextAttribute%> <%=eventFunctionForCase%> onBlur='ChangeUpperCase(this)' onKeyPress="return CheckForSpecChars(event)"><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>

      		    <td class='label'>&nbsp;</td>
      		</tr>
      		<tr>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
		</tr>
		<tr>
				 <td class='label'>&nbsp;</td>
				<td align='right' class='label'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type='text' name='long_desc' id='long_desc' size='30' maxlength='30' value="<%=longdesc%>" <%=otherTextAttribute%> onBlur="makeValidString(this)"><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
				<td class='label'>&nbsp;</td>
		</tr>
		<tr>
					<td class='label'>&nbsp;</td>
					<td class='label'>&nbsp;</td>
					<td class='label'>&nbsp;</td>
					<td class='label'>&nbsp;</td>
			</tr>
      <tr>
			<td class='label'>&nbsp;</td>
		    <td align='right' class='label'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		    <td class='fields'><input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' value="<%=shortdesc%>" <%=otherTextAttribute%> onBlur="makeValidString(this)"><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
		    <td class='label'>&nbsp;</td>
			</tr>
			<tr>
				<td class='label'>&nbsp;</td>
				<td class='label'>&nbsp;</td>
				<td class='label'>&nbsp;</td>
				<td class='label'>&nbsp;</td>
			</tr>
			<tr>
					<td class='label'>&nbsp;</td>
					<td  align='right' class='label'><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/></td>
								<%if(effstatus.equals("E"))
								{
									%>
										<td  align='left' class='fields' ><select name="bedclass" id="bedclass"><option value=''>---&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---<%
	/* 								stmt=con.createStatement(); */
									pstmt = con.prepareStatement("select short_desc, bed_class_code from ip_bed_class where eff_status='E' order by short_desc");
									rset = pstmt.executeQuery();
/* 										rset=stmt.executeQuery(""); */
									if(rset!=null)
									{
										 while(rset.next())
										 {
											dat=rset.getString("short_desc");
											ID=rset.getString("bed_class_code");

											if(bed_class_code.equals(ID))
											sel = "selected";
											else
											sel = "";
											out.println("<option value='"+ID+"'" +sel+">"+dat+"</option>");
										}
										out.println("</select>");
									}
									if(rset!=null) rset.close();
									if(pstmt!=null) pstmt.close();
								}
								else
								{
	/* 								stmt=con.createStatement(); */
									pstmt = con.prepareStatement("select short_desc, bed_class_code from ip_bed_class where  bed_class_code=?");
									pstmt.setString(1, bed_class_code);
									
									rset=pstmt.executeQuery();
									rset.next();
									%>
									<td  align='left' class='fields' >
									<input type='text' name='bedclass1' id='bedclass1' value ="<%=rset.getString(1)%>" readonly>
									<input type='hidden' name='bedclass' id='bedclass' value ="<%=bed_class_code%>">
									<%
									if(rset!=null) rset.close();
									if(pstmt!=null) pstmt.close();
								}
					%><img src='../../eCommon/images/mandatory.gif'align='center'></img>
					</td>
				 <td class='label'>&nbsp;</td>
			 </tr>
				<tr>
					<td class='label'>&nbsp;</td>
					<td class='label'>&nbsp;</td>
					<td class='label'>&nbsp;</td>
					<td class='label'>&nbsp;</td>
				</tr>
				<tr>
					 <td class='label'>&nbsp;</td>
					 <td  align='right' class='label'><fmt:message key="eIP.SpecialBedType.label" bundle="${ip_labels}"/></td>
					 <td  align='left' class='fields'><input type='checkbox' name='special_bed_type' id='special_bed_type' value="Y" <%=checkBoxAttribute1%> <%=spcl_bedtype_disable%> ></td>
					 <td class='label'>&nbsp;</td>
				</tr>
				 <tr>
					<td class='label'>&nbsp;</td>
					<td class='label'>&nbsp;</td>
					<td class='label'>&nbsp;</td>
					<td class='label'>&nbsp;</td>
				</tr>
				<tr>
					 <td class='label'>&nbsp;</td>
					 <td  align='right' class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
					 <td  align='left' class='fields'><input type='checkbox' name='eff_status' id='eff_status' value="<%=effstatus%>" <%=checkBoxAttribute%> onClick="Change1()"></td>
					 <td class='label'>&nbsp;</td>
				</tr>
				<tr>
					<td class='label'>&nbsp;</td>
					<td class='label'>&nbsp;</td>
					<td class='label'>&nbsp;</td>
					<td class='label'>&nbsp;</td>
				</tr>
			</table><br>

	<table id ='bl_field'  style=visibility:hidden; border='0' cellpadding='0' cellspacing='0' width='65%' align='center'>
	<th colspan='4' align='left' ><fmt:message key="eIP.BillingParameter.label" bundle="${ip_labels}"/></th>
	<tr>
		<td  class='label'width='10%'>&nbsp;</td>
		<td class='label'>&nbsp;</td>
		<td class='label'>&nbsp;</td>
		<td  class='label' width='10%'>&nbsp;</td>
	</tr>
		<% if (setup_bl_dtls_in_ip_yn.equals("Y")) { %>
		<tr>
		<td class='label'>&nbsp;</td>
		<td width='24%' align='right' class='label'>---&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---</td>
		<td  align='left' class='fields' >
		<select name="billingclass" id="billingclass"><option value=''><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/>
		<%
		pstmt=con.prepareStatement("select blng_class_code, short_desc from bl_blng_class  where status is null order by short_desc");
		rset=pstmt.executeQuery();

		if(rset!=null)
		{
			 while(rset.next())
			 {
				dat=rset.getString("short_desc");
				ID=rset.getString("blng_class_code");

				if(ID.equals(blng_class_code))
				sel = "selected";
				else
				sel = "";
				out.println("<option value='"+ID+"'" +sel+">"+dat+"</option>");

			}
			out.println("</select>");
			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();
		}
	%><img src='../../eCommon/images/mandatory.gif'align='center'></img>
		<td  align='left' class='label' >&nbsp;
		</td>

		</tr>
		<tr>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
		</tr>

		<tr>
			<td class='label'>&nbsp;</td>
			<td  align='right' class='label'><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/></td>
			<td  align='left' class='fields' >
			<select name="billingservice" id="billingservice"><option value=''>---&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---
			<%
				pstmt=con.prepareStatement("select blng_serv_code, short_desc from bl_blng_serv  where status is null order by short_desc");
				rset=pstmt.executeQuery();
				if(rset!=null)
				{
					 while(rset.next())
					 {
						dat=rset.getString("short_desc");
						ID=rset.getString("blng_serv_code");

						if(ID.equals(blng_serv_code))
						sel = "selected";
						else
						sel = "";
						out.println("<option value='"+ID+"'" +sel+">"+dat+"</option>");
					}
					out.println("</select>");
				}
				if (rset != null) rset.close();
				if (pstmt != null) pstmt.close();
			%><img src='../../eCommon/images/mandatory.gif'align='center'></img>
			<td  align='left' class='label' >&nbsp;
			</td>
		</tr>
		<tr>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
		 </tr>
		<tr>
			<td class='label'>&nbsp;</td>
			<td  align='right' class='label'><fmt:message key="eIP.DailyCharge.label" bundle="${ip_labels}"/></td>
			<td  align='left' class='fields' ><input type='text' style="text-align:right" name='daily_charge' id='daily_charge' value="<%=dly_charge%>" onBlur='putDecimal(this,9,2)' onKeyPress='return(ChkNumberInput(this,event,2))' maxlength=9 size="16" <%=otherTextAttribute%>><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
			<td class='label'>&nbsp;</td>
		</tr>
		<tr>
				<td class='label'>&nbsp;</td>
				<td class='label'>&nbsp;</td>
				<td class='label'>&nbsp;</td>
				<td class='label'>&nbsp;</td>
		</tr>
<% } %>
	 <script>
	 <%
		if(setup_bl_dtls_in_ip_yn.equals("Y"))
		{
			out.println("document.getElementById('bl_field').style.visibility='visible';");
		}
		
	%>
	
	</script>
</table >

	</div>
	<input type="hidden" name="setup_bl_dtls_in_ip_yn" id="setup_bl_dtls_in_ip_yn" value="<%=setup_bl_dtls_in_ip_yn%>">
	<input type='hidden' name='bed_count' id='bed_count' value="<%=bed_count%>">
<%
	if(newSpeciality)
	{
%>
		<input type='hidden' name='function' id='function' value='insert'>
		<input type='hidden' name='function_name' id='function_name' value='insert'>
<%  }
  	else
	{
%>
		<input type='hidden' name='function' id='function' value='modify'>
		<input type='hidden' name='function_name' id='function_name' value='modify'>
<%
	}
	if (rset != null) rset.close();
	if (rs != null) rs.close();
	if (rset_bl_service != null) rset_bl_service.close();
	if (pstmt != null) pstmt.close();

	}catch(Exception e) {
		/* out.println(e.toString()); */
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
	%>
	<script>
	bedClsDef();
	</script>
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

