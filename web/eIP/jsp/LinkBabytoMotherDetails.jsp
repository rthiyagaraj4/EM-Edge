<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.text.*,com.ehis.util.*,webbeans.eCommon.ConnectionManager,eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
<TITLE><!--  <fmt:message key="eIP.BabyToMotherDetails.label" bundle="${ip_labels}"/>  --></TITLE>
	<link type="text/css" rel="stylesheet" href="../../eCommon/html/<%=sStyle%>"></link>
	<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
	<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
	 
<%
		request.setCharacterEncoding("UTF-8");
		String practitioner_id	= checkForNull(request.getParameter("practitioner_id"));
		String gender			= checkForNull(request.getParameter("Sex"));
		String nurs_unit_code	= checkForNull(request.getParameter("nursing_code"));
		String main_bed_no		= checkForNull(request.getParameter("bed_no"));
		String patient_class	= checkForNull(request.getParameter("patient_class"));
		String mother_encounterid = checkForNull(request.getParameter("encounterid"));
		String facilityid		= checkForNull(request.getParameter("facilityid"));
		String call_function	= checkForNull(request.getParameter("call_function"));
		String mother_patient_id= checkForNull(request.getParameter("mother_patient_id"));
        String locale			= (String)session.getAttribute("LOCALE");
	    String outcome ="";
%>

	<script language="JavaScript">
	<!--
	function submit_page()
	{
		var babyCount =  document.forms[0].babyCount;
		
		var error = "";
		var arrayBedCount = new Array();
		var   outcome    ="";   
		for(var indexI=0;indexI < parseInt(babyCount.value);indexI++)
		{
			var patid = eval("document.forms[0].baby_patient_id"+indexI) 
		
			var objText = eval("document.forms[0].to_bed_no"+indexI)

			outcome = eval("document.forms[0].outcome"+indexI).value;
			if(outcome!="S")
			{
				 if(objText.value=="")
				{
					alert(getMessage("BED_NO_NOTNULL",'IP'));
					objText.focus();
					return false;
				}
				else
				{
					arrayBedCount[indexI] = objText.value;
				}
			}
			
			
		}
		for(var indexI=0 ;indexI < arrayBedCount.length;indexI++)
		{
			for(var indexJ=indexI + 1  ;indexJ <arrayBedCount.length;indexJ++)
			{
				if(arrayBedCount[indexJ] == arrayBedCount[indexI])
				{
					alert(getMessage("DUPLICATE_BED_NO",'IP'));
					objText = eval("document.forms[0].to_bed_no"+indexJ);
					objText.select();
					return false;     
				}
			}
		}
		if(!arrayBedCount.length == 0)
		{
			document.BabyMother_Link_Form.record_button.disabled= true;
			document.BabyMother_Link_Form.submit();
		}else
		{
			alert(getMessage('NO_CHANGE_TO_SAVE','Common'));
			window.close();
		}
	}

	function closeWindow()
	{
		window.close();
	}

	async function callBedAvailChart(obj)
	{
		var nursing_unit_code ="<%=nurs_unit_code%>";
		var practitionerid = "<%=practitioner_id%>";
		var specialitycode = "";
		var ipparam_bed_yn = "";
		var bedclasscode = "";
		var main_bed_no = "<%=main_bed_no%>";
		var bedtypecode = "";
		var gender = "<%=gender%>";
		var agevalue = "";
		var age = "";
		var yr = eval(agevalue.indexOf("Y"));
		var mon = eval(agevalue.indexOf("M"));
		var retVal = 	new String();
		var dialogHeight= "1200px";
		var dialogWidth = "1200px";
		var dialogTop	= "10px";

		var status = "no";
		var arguments	= "" ;
		var wherecondn  = "EMERGENCY_TFR_YN"; 
		var features	= "dialogHeight:" + dialogHeight + ";dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

		retVal = await window.showModalDialog("../../eIP/jsp/BedAvailabilityChart.jsp?nursing_unit_code="+nursing_unit_code+"&main_bed_no="+main_bed_no+"&call_function=NEW_BORN_REGN&bed_type=baby",arguments,features);
		if(retVal!=null)
		{
			var arr = retVal.split("^");
			if(arr.length > 2)
			{
				var arr1 = arr[1].split("/");
				obj.value = arr1[0];
				var arrsplty = arr[11].split("*All SPLTY*");
			
				if(arr[4] ==null )  	arr[4] ='';
				
				if(arr[14] =='Pseudo Bed')
				var pseudo_yn='Y';
				else
				var pseudo_yn='N';
			
			}
			
		}
	}
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
 <form name="BabyMother_Link_Form" id="BabyMother_Link_Form" action='../../servlet/eIP.LinkBabytoMotherServlet' method='post' target='MessageFrame'> 
<%
		Connection con			= null;
		PreparedStatement pstmt = null;
		ResultSet rset			=null;
		
	try{
		con			= ConnectionManager.getConnection(request);
		Boolean isLabelChangeApplicable = CommonBean.isSiteSpecific(con, "IP","GRAVIDA_PARITY_LEGEND_CHG");//Added by Rameswar on 23rd June 2015 against HSA-CRF-0223 IN050565
		
		StringBuffer sqlQuery = new StringBuffer();
		sqlQuery.append("select to_char(a.time_of_birth,'dd/mm/rrrr') date_of_birth, to_char(a.time_of_birth,'hh24:mi') time_of_birth,a.outcome , a.nb_sex gender, decode('"+locale+"','en',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name, a.patient_id, a.weight, a.weight_unit, am_get_desc.am_practitioner(a.attend_physician_id, '"+locale+"', 1) practitioner_name, d.bed_no from mp_birth_register a, mp_patient b, ip_nursing_unit_bed d  where a.encounter_facility_id = '"+facilityid+"' and a.mother_encounter_id = '"+mother_encounterid+"'and a.mother_patient_id = '"+mother_patient_id+"' and a.patient_id = b.patient_id and a.mother_encounter_id = d.mothers_encounter_id (+) and a.patient_id = d.occupying_patient_id (+) and not exists (select patient_id from ip_open_encounter where patient_id = a.patient_id)  order by time_of_birth");
		pstmt	= con.prepareStatement(sqlQuery.toString());

		rset	= pstmt.executeQuery();
		int i	= 0;
		String classValue	= "";
		String birth_weight = "";
		String baby_bed_no	= "";
		int babycount		= 0;

		if(rset!=null && rset.next())
		{			
			%>
			<table border=0 cellpadding=0 cellspacing=0 width='100%'>
			<tr><td colspan = '10' class='label'>&nbsp;</tr><tr><td class='label' colspan = '10'>&nbsp;</tr><tr><td class='label' colspan = '10'>&nbsp;</tr><tr><td colspan = '10' class='label'><table border=1 cellpadding=0 cellspacing=0 width='100%'><tr><th><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th><th><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th><th><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></th><th><fmt:message key="Common.time.label" bundle="${common_labels}"/></th><th><fmt:message key="Common.gender.label" bundle="${common_labels}"/></th><th><fmt:message key="Common.weight.label" bundle="${common_labels}"/></th><th><fmt:message key="Common.outcome.label" bundle="${common_labels}"/></th><th><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th><th><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></th></tr>
			<%
			do
			{
				i++;

				if(i%2 == 0) 
					classValue="QRYEVEN";
				else
					classValue = "QRYODD";

				String date_of_birth_converted = rset.getString("date_of_birth");

				if(date_of_birth_converted==null || date_of_birth_converted.equals(""))
					date_of_birth_converted = "";
				else
					date_of_birth_converted = DateUtils.convertDate(date_of_birth_converted,"DMY","en",locale);
				
				String time_of_birth_converted = rset.getString("time_of_birth");
				
				if(time_of_birth_converted==null || time_of_birth_converted.equals(""))
					time_of_birth_converted = "";
				else
					time_of_birth_converted = DateUtils.convertDate(time_of_birth_converted,"HM","en",locale);
				
				


				out.println("<tr>");
				out.println("<td nowrap class='"+classValue+"'>"+rset.getString("patient_id")+"</td>");
				out.println("<td nowrap class='"+classValue+"'>"+rset.getString("patient_name")+"</td>");	
				out.println("<td nowrap class='"+classValue+"'>"+date_of_birth_converted+"</td>");
				out.println("<td nowrap class='"+classValue+"'>"+time_of_birth_converted+"</td>");
		        gender=rset.getString("gender");	
		        if(gender.toUpperCase().equals("M"))
	             {%>
	                  <td class='"+classValue+"''><fmt:message key="Common.male.label" bundle="${common_labels}"/></td> 
	           <%}else if(gender.toUpperCase().equals("F"))
	                    {%>
	                  <td class='"+classValue+"'><fmt:message key="Common.female.label" bundle="${common_labels}"/></td> 
	                  <%}else if(gender.toUpperCase().equals("U"))
	                    {%>
	                   <td class='"+classValue+"'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></td>
	  <%}
				
				birth_weight	= checkForNull(rset.getString("weight"));
				baby_bed_no		= checkForNull(rset.getString("bed_no"));
                String weight_unit= checkForNull(rset.getString("weight_unit") );
				if(weight_unit.toUpperCase().equals("K"))
                {
				weight_unit=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.kg.label","common_labels");
				}
				else if(weight_unit.toUpperCase().equals("L"))
                {
			   weight_unit=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.lb.label","common_labels");
				}
				if(!birth_weight.equals(""))
				out.println("<td nowrap class='"+classValue+"'>"+birth_weight+" "+weight_unit+"</td>");
				else
				out.println("<td nowrap class='"+classValue+"'>"+birth_weight+"</td>");
				 outcome=checkForNull(rset.getString("outcome"));
				if(outcome.equals("L"))
				{ 
					if(isLabelChangeApplicable){
					out.println("<td nowrap class='"+classValue+"'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Alive.label","mp_labels")+"</td>");//Modified by Rameswar on 23rd June 2015 against HSA-CRF-0223 IN050565
					}else{
					out.println("<td nowrap class='"+classValue+"'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Live.label","mp_labels")+"</td>");
					
					}
				}
				else 
				{
					out.println("<td nowrap 	class='"+classValue+"'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.StillBorn.option.label","mp_labels")+"</td>");
				}
				out.println("<td nowrap class='"+classValue+"'>"+checkForNull(rset.getString("practitioner_name"))+"</td>");

				if (call_function.equals("IPList"))
				{
					if(baby_bed_no.equals("")||baby_bed_no==null)
					{
						baby_bed_no = "&nbsp;";
					}
					out.println("<td nowrap class='"+classValue+"'> "+baby_bed_no+"</td></tr>");
				}
				else
				if (call_function.equals("BabyLinktoMother"))
				{
					if(baby_bed_no.equals("")||baby_bed_no==null)
					{
						if(outcome.equals("S"))
						{
                    out.println("<td nowrap class='"+classValue+"'><input type='text' name='to_bed_no"+babycount+"' id='to_bed_no"+babycount+"' value='' size=8 maxlength=8 readonly> <input type='button' class='button' value='?' id='bedlookkup' onclick='callBedAvailChart(document.forms[0].to_bed_no"+babycount+");' disabled></td></tr><input type='HIDDEN' name='baby_patient_id"+babycount+"' id='baby_patient_id"+babycount+"' value='"+rset.getString("patient_id")+"'><input type='HIDDEN' name='outcome"+babycount+"' id='outcome"+babycount+"' value='"+outcome+"'>");			

						}else{
						out.println("<td nowrap class='"+classValue+"'><input type='text' name='to_bed_no"+babycount+"' id='to_bed_no"+babycount+"' value='' size=8 maxlength=8 readonly> <input type='button' class='button' value='?' id='bedlookkup' onclick='callBedAvailChart(document.forms[0].to_bed_no"+babycount+");' >&nbsp;&nbsp;<img align='center' id='bedoimg'src='../../eCommon/images/mandatory.gif'></td></tr><input type='HIDDEN' name='baby_patient_id"+babycount+"' id='baby_patient_id"+babycount+"' value='"+rset.getString("patient_id")+"'><input type='HIDDEN' name='outcome"+babycount+"' id='outcome"+babycount+"' value='"+outcome+"'>");					
						}
					}
					else
					{
						out.println("<td nowrap class='"+classValue+"'><input type='text' name='to_bed_no"+babycount+"' id='to_bed_no"+babycount+"' value='"+baby_bed_no+"' size=8 maxlength=8 readonly> <input type='button' class='button' value='?' id='bedlookkup' onclick='callBedAvailChart(document.forms[0].to_bed_no"+babycount+");' disabled>&nbsp;&nbsp;<img align='center' id='bedoimg'src='../../eCommon/images/mandatory.gif'></td></tr><input type='HIDDEN' name='baby_patient_id"+babycount+"' id='baby_patient_id"+babycount+"' value='"+rset.getString("patient_id")+"'><input type='HIDDEN' name='outcome"+babycount+"' id='outcome"+babycount+"' value='"+outcome+"'>");
					}
					babycount++;
				}
			}while(rset.next());
			out.println("</table>");
			out.println(" <input type='HIDDEN' name='babyCount' id='babyCount' value='"+babycount+"'>");
			out.println(" <input type='HIDDEN' name='practitioner_id' id='practitioner_id' value='"+practitioner_id+"'>");
			
			
			out.println(" <input type='HIDDEN' name='gender' id='gender' value='"+gender+"'>");
			out.println(" <input type='HIDDEN' name='nurs_unit_code' id='nurs_unit_code' value='"+nurs_unit_code+"'>");
			out.println(" <input type='HIDDEN' name='main_bed_no' id='main_bed_no' value='"+main_bed_no+"'>");
			out.println(" <input type='HIDDEN' name='patient_class' id='patient_class' value='"+patient_class+"'>");
			out.println(" <input type='HIDDEN' name='mother_encounterid' id='mother_encounterid' value='"+mother_encounterid+"'>");
			out.println(" <input type='HIDDEN' name='facilityid ' id='facilityid ' value='"+facilityid +"'>");
			out.println(" <input type='HIDDEN' name='call_function' id='call_function' value='"+call_function+"'>");
			out.println(" <input type='HIDDEN' name='mother_patient_id' id='mother_patient_id' value='"+mother_patient_id+"'>");

			out.println("<table  width='100%' cellspacing=0 cellpadding=0><tr><td class='label'>&nbsp;</tr><tr><td class='label'>&nbsp;</tr><tr><td class='label'>&nbsp;</tr><tr><td align='right' class='label'><br><br><br>");

			if (call_function.equals("BabyLinktoMother"))
			{
				out.println("<input type='button' name='record_button' id='record_button' class='button' value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")+"' onclick='submit_page()'>");
			}

			out.println("<input type='button' name='close' id='close' class='button' value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")+"' onclick='closeWindow()'></td></tr></table></td></tr></table>");
		}
		else
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));parent.window.close();</script>");
		}
	}catch(Exception e) { out.println(e.toString()); e.printStackTrace();}
	finally
	{
		if (pstmt != null) pstmt.close();
		if (rset != null) rset.close();
		ConnectionManager.returnConnection(con,request);
	}
%>
</form>
</body>
</html>

<%!

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals(""))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals(""))) ? defaultValue : inputString);
	}
%>

