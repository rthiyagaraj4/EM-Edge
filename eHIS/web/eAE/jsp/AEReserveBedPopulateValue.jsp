<!DOCTYPE html>
<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ page import="webbeans.eCommon.*,java.sql.*,javax.servlet.jsp.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='Javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<%
	Connection connection			=	null;
	PreparedStatement pStatement	=	null;
	ResultSet		resultSet		=	null;
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	String locale			= (String)session.getAttribute("LOCALE");
	StringBuffer sqlBuffer			=	new StringBuffer();
	String		function_name		=	"";
	String		sub_function_name	=	"";
	String		field1				=	""; 
	String		field2				=	"";
	String		field3				=	"";
	String		field4				=	"";
	String		code				=	"";
	String		desc				=	"";
	String		facilityID			=	"";
	String treatment_val="";
	String priority_zone = "";
	String flag_chk = "";
	
	try
	{
		facilityID			=	checkForNull((String) session.getValue("facility_id"));
		function_name		=	checkForNull(request.getParameter("function_name"));
		sub_function_name	=	checkForNull(request.getParameter("sub_function_name"));
		field1				=	checkForNull(request.getParameter("field1"));
		field2				=	checkForNull(request.getParameter("field2"));
		field3				=	checkForNull(request.getParameter("field3"));
		field4				=	checkForNull(request.getParameter("field4"));
		flag_chk			=   checkForNull(request.getParameter("flag_chk"));
		connection			= ConnectionManager.getConnection(request);
		treatment_val=checkForNull(request.getParameter("treatment_val"));
           
		if ((function_name.equals("ReserveBed")) && (sub_function_name.equals("TreatmentArea")))
		{
			%>
			<script>
				
				var select = parent.frames[1].document.reserve_bed_form.treatment_area;
				var length = select.length;
				for(i=0;i<length;i++)
					select.remove(0);
				var option		=  parent.frames[1].document.createElement("OPTION");
				option.text		=  '----------' +getLabel("Common.defaultSelect.label","Common")+ '----------';
				option.value	=  ""	;
				option.selected	=  true;
				select.add(option);
			</script>
			<%
			sqlBuffer.append("select treatment_area_code, short_desc,priority_zone from ae_tmt_area_for_clinic_lang_vw where LANGUAGE_ID ='"+locale+"' and clinic_code = ? and facility_id = ? and eff_status='E' ");

			if(!field2.equals(""))
			{
			sqlBuffer.append(" and priority_zone=? order by 2");  
			}
			
			if(field2.equals("")&&treatment_val.equals(""))
			{%>
              <script>
				parent.frames[1].document.reserve_bed_form.bed_no.innerText='';
				parent.frames[1].document.reserve_bed_form.bed_no.value='';
              </script>
			 <%
				}
			pStatement	= connection.prepareStatement(sqlBuffer.toString());
			pStatement.setString(1, field1);
			pStatement.setString(2, facilityID);
			if( !field2.equals(""))
			{
			pStatement.setString(3, field2);
			}

			resultSet	= pStatement.executeQuery();
			if (resultSet != null)
			{
				while(resultSet.next())
				{
					code = checkForNull(resultSet.getString("treatment_area_code"));
					desc = checkForNull(resultSet.getString("short_desc"));					
						priority_zone= checkForNull(resultSet.getString("priority_zone"));
					
				%>
					<script>
					var option		=  parent.frames[1].document.createElement("OPTION");
					option.text		=  "<%=desc%>";
					
					option.value	=  "<%=code%>";
					
					select.add(option);

					</script> 
				<%
				}
			}
			if (resultSet != null)	resultSet.close();
			if (pStatement != null)	pStatement.close();

			if(!treatment_val.equals(""))
			{
				%>
					<script>
					select.value="<%=treatment_val%>";
				
				if(parent.frames[1].document.reserve_bed_form.priority_value.value == "")
				{
				parent.frames[1].document.reserve_bed_form.priority_value.value="<%=priority_zone%>";
				}
					</script>
					<%
			}

		}
		if ((function_name.equals("ReserveBed")) && (sub_function_name.equals("ValidBed")))
		{
			
			try
			{
			String treatment_area	=	field1;
			String bed				=	field2;
			String facility_id		=	field3;
			String clinic			=	field4;
			String occupying_patient_id	 = "";
			String current_status		 = "";
			String resrvExp		 = "";

			int countValue			= 0;
			if (sqlBuffer.length() > 0)
				sqlBuffer.delete(0, sqlBuffer.length());
			sqlBuffer.append("select 1 countValue,occupying_patient_id, current_status,case when sysdate < occupied_until_date_time then 1 else 0 end resrvExp  from ae_bed_for_trmt_area where clinic_code ");
			sqlBuffer.append("= ? and treatment_area_code = ? and bed_no = ? and facility_id = ? ");
            
			if (pStatement != null)	pStatement.close();
			pStatement	= connection.prepareStatement(sqlBuffer.toString());
			
			pStatement.setString(1, clinic);
			pStatement.setString(2, treatment_area);
			pStatement.setString(3, bed);
			pStatement.setString(4, facility_id);

			resultSet	= pStatement.executeQuery();
			if ((resultSet != null) && (resultSet.next()))
				{
				countValue			 =	resultSet.getInt("countValue");
				occupying_patient_id = checkForNull(resultSet.getString("occupying_patient_id"));
				current_status		 = checkForNull(resultSet.getString("current_status"));
				resrvExp			 =  checkForNull(resultSet.getString("resrvExp"));
				}

			if (resultSet != null)	resultSet.close();
			if (pStatement != null)	pStatement.close();

			if (countValue == 0)
			{
				%>
					<script>
						alert(getMessage("INVALID_BED",'AE'));
						parent.frames[1].document.reserve_bed_form.bed_no.select();
						parent.frames[1].document.reserve_bed_form.bed_no.value="";

					</script>
				<%
			}
			if (countValue > 0)
			{
				/* 
				String occupying_patient_id	 = "";
				String current_status		 = "";
				String resrvExp		 = "";
				if (sqlBuffer.length() > 0)
					sqlBuffer.delete(0, sqlBuffer.length());
				sqlBuffer.append("select occupying_patient_id, current_status,case when sysdate < occupied_until_date_time then 1 else 0 end resrvExp from ");
				sqlBuffer.append("ae_bed_for_trmt_area where  clinic_code = ? and treatment_area_code ");
				sqlBuffer.append("= ? and bed_no = ? and facility_id = ? ");
				
				if (pStatement != null)	pStatement.close();
				pStatement	= connection.prepareStatement(sqlBuffer.toString());
				
				pStatement.setString(1, clinic);
				pStatement.setString(2, treatment_area);
				pStatement.setString(3, bed);
				pStatement.setString(4, facility_id);

				resultSet	= pStatement.executeQuery();
				if ((resultSet != null) && (resultSet.next()))
				{
					occupying_patient_id = checkForNull(resultSet.getString("occupying_patient_id"));
					current_status		 = checkForNull(resultSet.getString("current_status"));
					resrvExp =  checkForNull(resultSet.getString("resrvExp"));
				}
			    if (resultSet != null)	resultSet.close();
			    if (pStatement != null)	pStatement.close();
*/
				if (!occupying_patient_id.equals(""))
				{
				%>
					<script>
						alert(getMessage("BED_OCCUPIED",'AE'));
						parent.frames[1].document.reserve_bed_form.bed_no.select();
					</script>
				<%	
				}
				if (current_status.equals("R")&&resrvExp.equals("1"))
				{
				%>
					<script>
					
						alert(getMessage("BED_RESERVED",'AE'));
						parent.frames[1].document.reserve_bed_form.bed_no.select();
					</script>
				<%	
				}
			}
		}
		catch(Exception e)
			{
			e.printStackTrace() ;
			}

		}
		
			
		if ((function_name.equals("BedAvailChart")) && (sub_function_name.equals("TreatmentArea")))
		{
			%>
			 <script>
				var select = parent.frames[1].document.AEBedAvailChartForm.treatment_area;
				var length = select.length;
				for(i=0;i<length;i++)
					select.remove(0);
				var option		=  parent.frames[1].document.createElement("OPTION");
				option.text		=  '----------' +getLabel("Common.defaultSelect.label","Common")+ '----------';
				option.value	=  ""	;
				option.selected	=  true;
				select.add(option);
			</script> 
			<%
			sqlBuffer.append("select treatment_area_code, short_desc from ae_tmt_area_for_clinic_lang_vw where clinic_code = ? and facility_id = ? and LANGUAGE_ID ='"+locale+"' and eff_status='E' order by 2 ");	
            pStatement	= connection.prepareStatement(sqlBuffer.toString());
			pStatement.setString(1, field1);
			pStatement.setString(2, facilityID);
			resultSet	= pStatement.executeQuery();
			if (resultSet != null)
			{
				while(resultSet.next())
				{
					code = checkForNull(resultSet.getString("treatment_area_code"));
					desc = checkForNull(resultSet.getString("short_desc"));
				%>
					<script>
					var option		=  parent.frames[1].document.createElement("OPTION");
					option.text		=  "<%=desc%>";
					option.value	=  "<%=code%>";
					
					if ("<%=field2%>"=="<%=code%>")
						option.selected = true;
					    select.add(option);
					</script> 
				<%
				}
			}
			if (resultSet != null)	resultSet.close();
			if (pStatement != null)	pStatement.close();
			if (sqlBuffer.length() > 0)
					sqlBuffer.delete(0, sqlBuffer.length());
			out.println("<script>parent.frames[1].document.AEBedAvailChartForm.search.click();</script>");
			out.println("<script>parent.frames[4].document.location.href='../../eCommon/jsp/error.jsp&err_num='</script>");
		}


		if ((function_name.equals("RevertAEChkout")) && (sub_function_name.equals("ValidBed")))
		{
try{
			String treatment_area	=	field1;
			String bed				=	field2;
			String facility_id		=	field3;
			String clinic			=	field4;
			int countValue			= 0;
			String occupying_patient_id	 = "";
			String current_status		 = "";
			String resrvExp		 = "";

			if (sqlBuffer.length() > 0)
				sqlBuffer.delete(0, sqlBuffer.length());
			// Friday, May 28, 2010 PE_EXE Venkat S
			sqlBuffer.append("select 1 countValue,occupying_patient_id, current_status,case when sysdate < occupied_until_date_time then 1 else 0 end resrvExp  from ae_bed_for_trmt_area where clinic_code ");
			sqlBuffer.append("= ? and treatment_area_code = ? and bed_no = ? and facility_id = ? ");
            
            if (pStatement != null)	pStatement.close();
			pStatement	= connection.prepareStatement(sqlBuffer.toString());
			
			pStatement.setString(1, clinic);
			pStatement.setString(2, treatment_area);
			pStatement.setString(3, bed);
			pStatement.setString(4, facility_id);

			resultSet	= pStatement.executeQuery();
			if ((resultSet != null) && (resultSet.next()))
			{
					countValue			 =	resultSet.getInt("countValue");
					occupying_patient_id = checkForNull(resultSet.getString("occupying_patient_id"));
					current_status		 = checkForNull(resultSet.getString("current_status"));
					resrvExp			 =  checkForNull(resultSet.getString("resrvExp"));
			}	

			if (resultSet != null)	resultSet.close();
			if (pStatement != null)	pStatement.close();
			%>
			<script>
				parent.frames[1].document.OPCancelChkoutResult.flag_chk.value="N";			
			</script>

			<%


			if (countValue == 0)
			{
				%>
					<script>
						alert(getMessage("INVALID_BED",'AE'));
						parent.frames[1].document.OPCancelChkoutResult.bed_no.select();
						parent.frames[1].document.OPCancelChkoutResult.bed_no.value="";
						parent.frames[1].document.OPCancelChkoutResult.flag_chk.value="Y";
					</script>
				<%
			}else if (countValue >0){

				/* String occupying_patient_id	 = ""; Friday, May 28, 2010 PE_EXE Venkat S
				String current_status		 = "";
				String resrvExp		 = "";
				if (sqlBuffer.length() > 0)
					sqlBuffer.delete(0, sqlBuffer.length());
				sqlBuffer.append("select occupying_patient_id, current_status,case when sysdate < occupied_until_date_time then 1 else 0 end resrvExp from ");
				sqlBuffer.append("ae_bed_for_trmt_area where  clinic_code = ? and treatment_area_code ");
				sqlBuffer.append("= ? and bed_no = ? and facility_id = ? ");
				
				if (pStatement != null)	pStatement.close();
				pStatement	= connection.prepareStatement(sqlBuffer.toString());
				
				pStatement.setString(1, clinic);
				pStatement.setString(2, treatment_area);
				pStatement.setString(3, bed);
				pStatement.setString(4, facility_id);

				resultSet	= pStatement.executeQuery();
				if ((resultSet != null) && (resultSet.next())){
					occupying_patient_id = checkForNull(resultSet.getString("occupying_patient_id"));
					current_status		 = checkForNull(resultSet.getString("current_status"));
					resrvExp =  checkForNull(resultSet.getString("resrvExp"));
				}
			    if (resultSet != null)	resultSet.close();
			    if (pStatement != null)	pStatement.close(); */

				if(!occupying_patient_id.equals("")){
				%>
					<script>
						alert(getMessage("BED_OCCUPIED",'AE'));
						parent.frames[1].document.OPCancelChkoutResult.bed_no.value="";
						parent.frames[1].document.OPCancelChkoutResult.flag_chk.value="Y";
					</script>
				<%	
				}else if (current_status.equals("R")&&resrvExp.equals("1")){
				%>
					<script>
					
						alert(getMessage("BED_RESERVED",'AE'));
						parent.frames[1].document.OPCancelChkoutResult.bed_no.select();
						parent.frames[1].document.OPCancelChkoutResult.flag_chk.value="Y";
					</script>
				<%	
				}else{

				/*Added by Ashwini on 30-Mar-2018 for PMG2018-COMN-CRF-0001*/
				String eff_status =  eAE.AECommonBean.getBedBayEffStatus(connection,bed,clinic,facility_id);

				if(("D").equals(eff_status)){%>
						
					<script>
						alert(getMessage("BED_DISABLED",'AE'));
						parent.frames[1].document.OPCancelChkoutResult.bed_no.value="";
						parent.frames[1].document.OPCancelChkoutResult.flag_chk.value="Y";
					</script>

				<%}else{%>

					<script>
						parent.frames[1].document.forms[0].submit();
					</script>

				<%}%>
				<!--End PMG2018-COMN-CRF-0001-->

				<%}
			}
				
		}
		catch(Exception exception)
	{
		exception.printStackTrace();
	}
		

	}
		
	}catch(Exception exception)
	{
		//out.println("Exception : " + exception.toString());
		exception.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(connection, request);
	}
%>
<script>
parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=";</script>
</html>

<%!
	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equalsIgnoreCase("null"))) ? "" : inputString );
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return ( ((inputString == null) || (inputString.equalsIgnoreCase("null"))) ? defaultValue : inputString );
	}
%>

