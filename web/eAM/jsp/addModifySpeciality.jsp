<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,eCommon.XSSRequestWrapper" %>

      <head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
      	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>

      	<script>
      	function change() 
		{
      		
      		var isMRSpecialtyApp = document.forms[0].isMRSpecialtyApp.value;
      		if (speciality_form.eff_status.checked == true){
	      	 	speciality_form.eff_status.value="E";
	      	 	if(isMRSpecialtyApp=="true"){
	      	 		speciality_form.mr_appl_yn.disabled	= false;
	      	 	}
	      	 	
	      	}else{
	      		speciality_form.eff_status.value="D";
	      		if(isMRSpecialtyApp=="true"){
		      		speciality_form.mr_appl_yn.checked	= false;
		      		speciality_form.mr_appl_yn.disabled	= true;
	      		}
			}
	      	
	      	
		}
      	
      	//Added for the CRf - Bru-HIMS-CRF-0198
      	function changeSpeciality(){
      		if (speciality_form.multi_speciality_chk_yn.checked == true){
          	 	speciality_form.multi_speciality_chk_yn.value="Y";
          	 	speciality_form.multi_speciality_yn.value="Y";
      		}
          	 else{
          		speciality_form.multi_speciality_chk_yn.value="N";
          		speciality_form.multi_speciality_yn.value="N";
          	 }
      	}
      	</script>

      </head>

      <body OnMouseDown='CodeArrest()' onLoad="FocusFirstElement();" onKeyDown = 'lockKey()'>


<%
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
   String  specialitycode="";
   String longdesc="";
   String shortdesc="";
   String effstatus="";
   String vitalsignbattery = "";
   String multi_speciality_yn = "";//Added for the CRF - Bru-HIMS-CRF-0198
   String multi_spclty_checked = "";//Added for the CRF - Bru-HIMS-CRF-0198
   String multi_spclty_disabled = "";//Added for the CRF - Bru-HIMS-CRF-0198
   boolean isMultiSpeciality=false;//Added for the CRF - Bru-HIMS-CRF-0198
   String codeTextAttribute="";
   String otherTextAttribute="";
   String listAttribute="";
   String checkBoxAttribute="checked";
   String eventFunctionForCase="";
   String mrApplYN		= "Y";
   boolean newSpeciality=false;
   String sql="";
   PreparedStatement pstmt = null;
   PreparedStatement pstmt1 = null;
   ResultSet rs = null;
   ResultSet rs1 = null;
   Connection conn =null;
   int mrOpenReqCount	= 0;
   boolean isMRSpecialtyApp	= false;//Added By Dharma on Dec 6th 2019 against ML-MMOH-CRF-1454
%>
<%
	try
	{
		conn = ConnectionManager.getConnection(request);
		specialitycode=request.getParameter("speciality_code");
		//Added for the CRF - Bru-HIMS-CRF-0198
		isMultiSpeciality	= eOP.QMSInterface.isSiteSpecific(conn, "OP", "MULTI_SPECIALTY");
		isMRSpecialtyApp	= eCommon.Common.CommonBean.isSiteSpecific(conn, "MR", "MR_SPECIALTY_DEF_APPL_YN");//Added By Dharma on Dec 6th 2019 against ML-MMOH-CRF-1454
		
		if(specialitycode==null)
		{
			specialitycode="";
			longdesc="";
			shortdesc="";
			effstatus="E";
			vitalsignbattery="";
			multi_speciality_yn="N";//Added for the CRF - Bru-HIMS-CRF-0198
			multi_spclty_checked="";//Added for the CRF - Bru-HIMS-CRF-0198
			codeTextAttribute="";
			otherTextAttribute="";
			listAttribute = "";
			checkBoxAttribute="CHECKED";
			newSpeciality=true;
			eventFunctionForCase="OnBlur='ChangeUpperCase(this)'";
		}
		else
		{
	       Statement stmt=null;
		   PreparedStatement pstmt2 = null;
	    	ResultSet rset=null;
			try
			{
				stmt = conn.createStatement();
				sql = "select speciality_code, long_desc, short_desc, eff_date_from,eff_date_to,eff_status, vital_signs_battery_id, multi_speciality_yn, mr_appl_yn  from am_speciality where speciality_code=?";
				//rset = stmt.executeQuery(sql);
				
				pstmt2   = conn.prepareStatement(sql);
				pstmt2.setString	(	1,	specialitycode		);

				rset		 = pstmt2.executeQuery();
				rset.next();
				specialitycode	= rset.getString("speciality_code");
				longdesc		= rset.getString("long_desc");
				shortdesc		= rset.getString("short_desc");
				effstatus		= rset.getString("eff_status");
				vitalsignbattery= rset.getString("vital_signs_battery_id");
				multi_speciality_yn= rset.getString("multi_speciality_yn");//Added for the CRF - Bru-HIMS-CRF-0198
				mrApplYN		= rset.getString("mr_appl_yn");
				if(effstatus.equals("D"))
				{
					listAttribute = "DISABLED";
					otherTextAttribute="READONLY";
					checkBoxAttribute="";
				}
				else
				{
					listAttribute = "";
					otherTextAttribute="";
					checkBoxAttribute="CHECKED";
				}
				//Added for the CRF - Bru-HIMS-CRF-0198
				if(multi_speciality_yn != null && multi_speciality_yn.equals("Y")){
					multi_spclty_checked="checked";
					multi_spclty_disabled="disabled";
				}
				/*Added By Dharma on Dec 6th 2019 against ML-MMOH-CRF-1454 Start*/
				if(isMRSpecialtyApp){
					mrOpenReqCount	= eMR.MRCommonBean.getMROpenReqCount(conn,specialitycode);
				}
				/*Added By Dharma on Dec 6th 2019 against ML-MMOH-CRF-1454 End*/		
			}
			catch(Exception e)
			{	
				e.toString();	
			}
			finally
			{
				try
				{
	     		if(rset!=null)	rset.close();
				if(stmt!=null)	stmt.close();
				if(pstmt2!=null)	pstmt2.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
		     }
			codeTextAttribute="READONLY";
			newSpeciality=false;
			eventFunctionForCase="";
		}
%>
      	<form name='speciality_form' id='speciality_form' action='../../servlet/eAM.SpecialityServlet' method='post' target='messageFrame'>
      	<div>
      	<br><br><br><br><br><br><br><br>
      	<table border='0' cellpadding='0' cellspacing='0' width='auto' align='center'>
      	<tr>
      		<td width='10%'>&nbsp;</td>
      		<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td width='10%'>&nbsp;</td>
		</tr>
      	<tr>
      		    <td class='label'>&nbsp;</td>
      		    <td  class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      		    <td class='fields'>&nbsp;&nbsp;
      		    <input type='text' name='speciality_code' id='speciality_code' onKeyPress="return CheckForSpecChars(event)"  value="<%=specialitycode%>" size='4' maxlength='4' <%=codeTextAttribute%> <%=eventFunctionForCase%>>&nbsp;
      		    <img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
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
      		    <td    class=label><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
      		    <td class='fields'>&nbsp;&nbsp;
      		    <input type='text' name='long_desc' id='long_desc' onBlur="makeValidString(this)" size='30' maxlength='30' value="<%=longdesc%>" <%=otherTextAttribute%> >
      		    <img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
      		    <td>&nbsp;</td>
      	</tr>
      	<tr>
      			<td class='label'>&nbsp;</td>
      			<td class='label'>&nbsp;</td>
				<td class='label'>&nbsp;</td>
				<td class='label'>&nbsp;</td>
		</tr>
      	<tr>
      		    <td class='label'>&nbsp;</td>
      		    <td  class=label><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
			    <td class='fields'>&nbsp;&nbsp;
				<input type='text' onBlur="makeValidString(this)" name='short_desc' id='short_desc' size='15' maxlength='15' value="<%=shortdesc%>" <%=otherTextAttribute%> >
			    <img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
			    <td>&nbsp;</td>
      	</tr>
      	<tr>
      			<td class='label'>&nbsp;</td>
      			<td class='label'>&nbsp;</td>
				<td class='label'>&nbsp;</td>
				<td class='label'>&nbsp;</td>
		</tr>

   		<tr>
      		    <td class='label'>&nbsp;</td>
      		    <td  class=label><fmt:message key="Common.VitalSignsBattery.label" bundle="${common_labels}"/></td>
			    <td class='fields'>&nbsp;&nbsp;
				<select name="vital_signs_battery" id="vital_signs_battery" <%=listAttribute%>>
				<option value="">-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------- </option>		
<%
			pstmt = conn.prepareStatement("select short_desc,discr_msr_id from am_discr_msr where eff_Status ='E' and result_type ='V' order by 1");
			rs = pstmt.executeQuery();

			if(rs != null)
			{
				while(rs.next())
				{
					String vscode = rs.getString("discr_msr_id");
					String vsdesc = rs.getString("short_desc");
					if(vscode.equals(vitalsignbattery))
						out.println("<option value='"+vscode+"' selected>"+vsdesc+"</option>");
					else
						out.println("<option value='"+vscode+"'>"+vsdesc+"</option>");
				}
			}
%>
			</select>
			</td>
		    <td class='label'>&nbsp;</td>
      	</tr>
      	<tr>
      			<td class='label'>&nbsp;</td>
      			<td class='label'>&nbsp;</td>
				<td class='label'>&nbsp;</td>
				<td class='label'>&nbsp;</td>
		</tr>
		<%//Added for the CRF - Bru-HIMS-CRF-0198
		if(isMultiSpeciality){ %>
		<tr>
    		      <td>&nbsp;</td>
      		     <td   class='label'><fmt:message key="eAM.Multispeciality.label" bundle="${am_labels}"/></td>
      		     <td  class='fields'>&nbsp;&nbsp;
      		     <input type='checkbox' name='multi_speciality_chk_yn' id='multi_speciality_chk_yn' value="<%=multi_speciality_yn%>" <%=multi_spclty_checked%>  onClick="changeSpeciality()" <%=multi_spclty_disabled %>></td>
      		     <input type='hidden' name='multi_speciality_yn' id='multi_speciality_yn' value='<%=multi_speciality_yn%>'/>
      		     <td>&nbsp;</td>
   		</tr>
   		<%}%>

   		<tr>
      			<td class='label'>&nbsp;</td>
      			<td class='label'>&nbsp;</td>
				<td class='label'>&nbsp;</td>
				<td class='label'>&nbsp;</td>
		</tr>
		
   		<tr>
    		      <td>&nbsp;</td>
      		     <td   class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
      		     <td  class='fields'>&nbsp;&nbsp;
      		     <input type='checkbox' name='eff_status' id='eff_status' value="<%=effstatus%>" <%=checkBoxAttribute%> onClick="change()"></td>
      		     <td>&nbsp;</td>
   		</tr>
   		<tr>
      			<td class='label'>&nbsp;</td>
      			<td class='label'>&nbsp;</td>
				<td class='label'>&nbsp;</td>
				<td class='label'>&nbsp;</td>
		</tr>
		<!-- Added By Dharma on 29th Nov 2019 against ML-MMOH-CRF-1454 Start -->
		<% if(isMRSpecialtyApp){ %>
		<tr>
    		      <td>&nbsp;</td>
      		     <td   class='label'><fmt:message key="eMR.ApplicableForMR.label" bundle="${mr_labels}"/></td>
      		     <td  class='fields'>&nbsp;&nbsp;
      		     <input type='checkbox' name='mr_appl_yn' id='mr_appl_yn' value="Y" <%if(mrApplYN.equals("Y") && effstatus.equals("E")){%>checked<%}%> <%if(!effstatus.equals("E")){%>disabled<%}%>  /></td>
      		     <td>&nbsp;</td>
   		</tr>
   		<tr>
      			<td class='label'>&nbsp;</td>
      			<td class='label'>&nbsp;</td>
				<td class='label'>&nbsp;</td>
				<td class='label'>&nbsp;</td>
		</tr>
		<%} %>
		<input type='hidden' name='isMRSpecialtyApp' id='isMRSpecialtyApp' value ='<%=isMRSpecialtyApp%>' />
		<input type='hidden' name='mrOpenReqCount' id='mrOpenReqCount' value ='<%=mrOpenReqCount%>' />
		<!-- Added By Dharma on 29th Nov 2019 against ML-MMOH-CRF-1454 End -->
   	</table>
 	</div>
 	
    <%  if(newSpeciality){%>

      	<input type='hidden' name='function' id='function' value='insert'>
      	<input type='hidden' name='function_name' id='function_name' value='insert'>

      <%}else{%>

      	<input type='hidden' name='function' id='function' value='modify'>
      	<input type='hidden' name='function_name' id='function_name' value='modify'>
     <%}
     }
	 catch(Exception e)
	 {}
     finally
	{
		try
		{
		if(rs != null)		rs.close();
		if(pstmt != null)	pstmt.close();
		if(rs1 != null)		rs1.close();
		if(pstmt1 != null)	pstmt1.close();
		}
		catch(Exception re)
		{
			re.printStackTrace();
		}

		if(conn != null)
     	ConnectionManager.returnConnection(conn,request);
     }
     %>
 	</form>
   </body>
  </html>

