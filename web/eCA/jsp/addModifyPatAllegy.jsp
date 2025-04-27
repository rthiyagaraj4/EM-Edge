<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page language="java" import ="java.sql.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>

<html>
	<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<%
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");

	String sStyle =(String)session.getAttribute("PREFERRED_STYLE") ;

	if(sStyle == null || sStyle.equals("") )
		sStyle = "IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />

	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
    <script language="javascript" src="../../eCommon/js/common.js" ></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language='javascript' src='../../eCA/js/PatAllergy.js'></script>
	<script language='javascript' src='../../ePH/js/DrugNameCommonLookup.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<head> 
<%
	Connection con		=	null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	PreparedStatement stmt=null;

	ResultSet rset=null ; 
	
	String drug_name	=	"",		generic_id		=	"";
	String drug_code	=	"",		generic_name	= 	"";	
	
	try
	{
	
	con = ConnectionManager.getConnection(request);

   	String currentdate1 		= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
	String Dob = (request.getParameter("Dob")==null?"": request.getParameter("Dob"));
		
	String dis2="disabled";
	String dis3="disabled";
	String agey="";
	String agem="";
	String aged="";
	String sqlqry="";
    String aitem="";
    String aclass="";
    String atypecode="";
    String  locn_type="";
    String alclass="";
    String allergicto="";
	
    String allergydesc="";
	String closedate = currentdate1;
	String onsetdate = currentdate1;
	String remarks="";
	String fnval="insert";
	String srlno="";
	String ID="";
	String dat="";
	String ID1="";
	String dat1="";
	String val1="";
	String id1="";
	String rdonly="";
 	String sel1="";
	String sel2="";
	String id[]={};
	String val[]={};

	int count = 0;
	
    pstmt=con.prepareStatement("select count(1) count from sm_module where module_id = 'PH' and install_yn = 'Y'");
    
	rset=pstmt.executeQuery();

		if(rset!=null)
		{
			if(rset.next())
				count=rset.getInt("count");
		}
            if (count!=0)
			{
				String id2[]={"","D","F","G","I","T"};
				id = id2;
				String val2[]={com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Drug.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Food.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.general.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Inhalant.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Topical.label","common_labels")};
				val=val2;		    
			}
			else
			{
				String id2[]={"","F","G","I","T"};
				id = id2;
				String val2[]={com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Food.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.general.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Inhalant.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Topical.label","common_labels")};
				val=val2;
			}
   
   String facilityId = (String) session.getValue( "facility_id" ) ;
   String adesc=request.getParameter("aclass");
   if(adesc == null) adesc="";
   
	aitem		=		request.getParameter("allergyitem");
	aclass		=		request.getParameter("allergyclass");
	atypecode	=		request.getParameter("allergytcode");
	srlno		=		request.getParameter("srl_no");

	String patient_id = request.getParameter("Patient_Id");
	String encounter_id = request.getParameter("Encounter_Id");
	if (encounter_id ==null )
		encounter_id = request.getParameter("encounter_id");

	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String clinic_code = request.getParameter("Clinic_Code");
	locn_type = request.getParameter("location_type");
	if (locn_type==null)
	  locn_type="";

try
{
	if(aclass != null )
	{
		fnval="modify";
			
		if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();

		pstmt=con.prepareStatement("select a.ALLERGY_CLASS, a.ALLERGIC_ITEM,a.ALLERGY_TYPE_CODE,(MR_GET_DESC.MR_ALLERGY_TYPE(a.ALLERGY_TYPE_CODE,?,'2')|| ', '||MR_GET_DESC.MR_ALLERGY_TYPE(a.ALLERGY_TYPE_CODE2,?,'2')|| ', '||MR_GET_DESC.MR_ALLERGY_TYPE(a.ALLERGY_TYPE_CODE3,?,'2')) short_desc, to_char(a.onset_date,'dd/mm/yyyy') d, a.remarks  from pr_allergy a  where a.ALLERGIC_ITEM=?  and   a.ALLERGY_CLASS =? and  a.ALLERGY_TYPE_CODE=? and srl_no=?");
		pstmt.setString(1,locale);
		pstmt.setString(2,locale);
		pstmt.setString(3,locale);
		pstmt.setString(4,aitem);
		pstmt.setString(5,aclass);
		pstmt.setString(6,atypecode);
		pstmt.setString(7,srlno);
		rset=pstmt.executeQuery();
		if(rset!=null)
			{
			while(rset.next())
				{
				alclass=rset.getString("ALLERGY_CLASS");
				allergicto=rset.getString("ALLERGIC_ITEM");
				allergydesc=rset.getString("short_desc");
				onsetdate=rset.getString("d");
				remarks=rset.getString("remarks");

				 if(onsetdate == null) 
					 onsetdate = "";
				 else
		 			rdonly="readonly";

				 onsetdate = com.ehis.util.DateUtils.convertDate(onsetdate,"DMY","en",locale);

				 if(remarks == null) remarks = "";
				}
			}
		if(rset!=null)rset.close();
	}
%>

<script>

function rfresh( )
{
  var objVal=document.forms[0].allergyclass.options.value;
  location.href='addModifyPatAllegy.jsp?Patient_Id=<%=patient_id%>&Practitioner_Id=<%=practitioner_id%>&P_facility_id=<%=facilityId%>&Clinic_Code=<%=clinic_code%>&P_locn_type=<%=locn_type%>&Encounter_Id	=<%=encounter_id%>&location_type=<%=locn_type%>&aclass='+objVal+"&Dob=<%=Dob%>";
}
</script>
</head>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload ="FocusFirstElement()">
<form name='PatientAllergy_form' id='PatientAllergy_form'  action='../../servlet/eCA.PatAllergyServlet' method='post' target='messageFrame'>
<table border='0' cellpadding='3' cellspacing='0' width='90%'  height='80%' align ='center'>
<tr>
		<td height='10%' class='columnHeader' ><fmt:message key="eCA.AllergyAssessment.label" bundle="${ca_labels}"/></td>
		<td id=disMar class='columnHeader'><font color=red></font></td>
</tr>
<tr>
		<td  width='25%' class=label nowrap><fmt:message key="Common.AllergyType.label" bundle="${common_labels}"/></td>
		<td class='fields' width='65%' colspan='1'>
		<%
			if (fnval == "modify")
			{
				for(int i=0; i<id.length; i++)
  				{
  					if(id[i].equals(alclass))
  					val1=val[i];
  					id1=id[i];
  				}
			
				out.print("<input type='text' name='allergyclass' id='allergyclass' value='"+val1+"' readonly>");
      			out.print("<input type='hidden' name='allergy_class' id='allergy_class' value='"+id1+"'>");
				out.print("<img src='../../eCommon/images/mandatory.gif'>");
  			}
  			else
  			{
				String sel="";
  				%>
				<select name='allergyclass' id='allergyclass' onChange='rfresh()'>
				<%
				for(int i=0; i<id.length; i++)
				{
					if(id[i].equals(adesc))
							sel="selected";

						val1=val[i];
						id1=id[i];
						out.print("<option value='"+id1+"' " +sel+ ">"+val1);
						sel="";
  				}
				%>
				</select><img  src='../../eCommon/images/mandatory.gif'>
				</td>
		</tr>
			<%}
		if(!(adesc.equals("D")))
		{
			%>
			<tr id="tr_allergic_to">
			<td width='30%'  class='label'><fmt:message key="eCA.AllergicTo.label" bundle="${ca_labels}"/></td>
			<td  class='fields' width='60%' colspan='2' >
			<%
				if(fnval.equals("modify"))
				{
					out.println("<input type='text' name='allergicto' id='allergicto' width=30 size=30 value='"+allergicto+"' readonly>");
					out.println("<img src='../../eCommon/images/mandatory.gif'></td>");
				}
				else
				{
				   if (!adesc.equals("D") )
					  %>
					   <input type="text" name='allergicto' id='allergicto'  value='' maxlength='30' onBlur="makeValidString(this);"><img src='../../eCommon/images/mandatory.gif'>
					  <%
				   else
					{
						%>
						<select name='allergicto' id='allergicto'>
						<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
						<% 
							stmt=con.prepareStatement("SELECT short_name, generic_drug_code generic_code from  ph_generic_drug    where eff_status='E' order by short_name "); 
							rset=stmt.executeQuery();
						
							if(rset!=null)
							{
								while(rset.next())
								{
									dat=rset.getString("short_name");
									ID=rset.getString("generic_code");
							
									if(dat.equals(allergicto))
										sel1="selected";
									else
										sel1="";
										out.println("<option value='"+ID+"' "+sel1+">"+dat+"</option>");
									}
									%>
									</select><img src='../../eCommon/images/mandatory.gif'>
								  <%
								}
								
								if(rset!=null)rset.close();
							}
							%>
			   </td></tr>
			   <%
			}
	}						
	else
	{
	%>
		<input type='hidden' name='drug_name' id='drug_name' value='<%=drug_name%>'>
		<input type='hidden' name='drug_code' id='drug_code' value='<%=drug_code%>'>
		<tr>
			<td  width='30%'  class='label'><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></td>
			<td width='60%'   class='fields'><input type='text' name='generic_name' id='generic_name' readOnly value='<%=generic_name%>' size='30' maxlength='30' ><input type="button" class="BUTTON" name="drug_search" id="drug_search" value="?" onClick="callGenericSearch(generic_name)"><img   src='../../eCommon/images/mandatory.gif'><input type='hidden' name='generic_id' id='generic_id' value='<%=generic_id%>'></td>
		</tr>
		<%
	}	
	%>
			<tr>
			<td width='30%'  class='label' ><fmt:message key="Common.AllergicDesc.label" bundle="${common_labels}"/></td>
			<td  class='fields' width='60%'  colspan='2'><%if(fnval.equals("modify"))
			 {
				out.println("<input type='text' name='allergydesc' id='allergydesc'   value='"+allergydesc+"' readonly>");
				out.println("<img src='../../eCommon/images/mandatory.gif'>");
			 }
			else
			{
				%><select name='allergydesc' id='allergydesc'  onchange='chekdup(this)'> 
					<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
				<%

				 //sqlqry="SELECT short_desc, allergy_type_code from mr_allergy_type where eff_status='E' and nvl(allergy_class,?)=? order by short_desc";
				 sqlqry="SELECT  short_desc, allergy_type_code from mr_allergy_type_LANG_VW where eff_status='E' and nvl(allergy_class,?)=? AND LANGUAGE_ID = ? order by short_desc";
				pstmt1=con.prepareStatement(sqlqry);
				pstmt1.setString(1,adesc);
				pstmt1.setString(2,adesc);
				pstmt1.setString(3,locale);
				rset=pstmt1.executeQuery();

				if(rset!=null)
				{
					while(rset.next())
					{
						dat1=rset.getString("short_desc");
						ID1=rset.getString("allergy_type_code");
						if(ID1.equals(allergydesc))
						  sel2="selected";
						else
							sel2="";
						out.println("<option value='"+ID1+ "' "+sel2+">"+dat1+"</option>");}%></select><img src='../../eCommon/images/mandatory.gif'>
						<b></b>	<%}%>
						
    			<%
				

					if (rset!=null) rset.close();
					if (stmt!=null) stmt.close();

					%>
						</select>
						
						
					<select name='allergydesc2' id='allergydesc2' <%=dis2%>
						onchange='chekdup(this)' >
					<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
				<%

				// sqlqry="SELECT short_desc, allergy_type_code from mr_allergy_type where eff_status='E' and nvl(allergy_class,?)=? order by short_desc";
				sqlqry="SELECT  short_desc, allergy_type_code from mr_allergy_type_LANG_VW where eff_status='E' and nvl(allergy_class,?)=? AND LANGUAGE_ID = ? order by short_desc";
				pstmt1=con.prepareStatement(sqlqry);
				pstmt1.setString(1,adesc);
				pstmt1.setString(2,adesc);
				pstmt1.setString(3,locale);
				rset=pstmt1.executeQuery();

				if(rset!=null)
				{
					while(rset.next())
					{
						dat1=rset.getString("short_desc");
						ID1=rset.getString("allergy_type_code");
						if(ID1.equals(allergydesc))
						  sel2="selected";
						else
							sel2="";
						out.println("<option value='"+ID1+ "' "+sel2+">"+dat1+"</option>");}%></select>
						<!--<img src='../../eCommon/images/mandatory.gif'align='center'>-->
						<b></b>	
							
							<%}%>

				<%
				

					if (rset!=null) rset.close();
					if (stmt!=null) stmt.close();

					%>

						</select>
							
							
						<select name='allergydesc3' id='allergydesc3' <%=dis3%> onchange='chekdup(this)' >
					<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
				<%

				 //sqlqry="SELECT short_desc, allergy_type_code from mr_allergy_type where eff_status='E' and nvl(allergy_class,?)=? order by short_desc";
				sqlqry="SELECT  short_desc, allergy_type_code from mr_allergy_type_LANG_VW where eff_status='E' and nvl(allergy_class,?)=? AND LANGUAGE_ID = ? order by short_desc";
				pstmt1=con.prepareStatement(sqlqry);
				pstmt1.setString(1,adesc);
				pstmt1.setString(2,adesc);
				pstmt1.setString(3,locale);
				rset=pstmt1.executeQuery();

				if(rset!=null)
				{
					while(rset.next())
					{
						dat1=rset.getString("short_desc");
						ID1=rset.getString("allergy_type_code");
						if(ID1.equals(allergydesc))
						  sel2="selected";
						else
							sel2="";
						out.println("<option value='"+ID1+ "' "+sel2+">"+dat1+"</option>");}%></select>
						<!--<img src='../../eCommon/images/mandatory.gif'align='center'>-->
								<%}%></td></tr>

				<%
				

					if (rset!=null) rset.close();
					if (stmt!=null) stmt.close();

					%>
			<%}
					%><input type='hidden' name='sys_date' id='sys_date' value='<%=currentdate1%>'>
					 	
						
					<tr>
					<td class='label' ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
					<td><textarea name="remarks" rows="3" cols="60" onKeyPress='checkMaxLimit(this,200);'    onBlur="makeValidString(this);checkMaxLimit(this,200)" ><%=remarks%> </textarea></td>
					</tr>

					<tr>
					<td width='30%'  class='label'><fmt:message key="Common.OnsetDateTime.label" bundle="${common_labels}"/></td>

						<%if (!(fnval == "modify")){ %>
					<td width='60%' colspan='2' class='fields'><input type='text' name='onset' id='onset' size='10' maxlength='10'  value='<%=onsetdate%>' <%=rdonly%>  Onblur='CheckDate(this);isVaidwithSysDate(this,"DMY","<%=locale%>");calci(b_age,"DMY","<%=locale%>",onset);calcage(this,ServerDate,onset)'><% } else { %><td width='60%' colspan='2' class='fields'><input type='text' name='onset' id='onset' size='10' maxlength='10'  value='<%=onsetdate%>' <%=rdonly%>  ><% } %><%if (!(fnval == "modify")){ %><input type='image' src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('onset');" >
					<input type='hidden' name='onset_date' id='onset_date' value='<%=onsetdate%>'>
						(<fmt:message key="Common.from.label" bundle="${common_labels}"/><fmt:message key="Common.Last.label" bundle="${common_labels}"/>
								<input type="text" name="b_days" id="b_days" maxlength="2" size="2" value='<%=aged%>'
								onKeyPress='return(ChkNumberInput(this,event,0))'
								onBlur= 'CheckForNumber_L(this,onset);checkDays(this,onset);calci(this,"DMY","<%=locale%>",onset);'   tabIndex='4'>D

								<input type="text" name="b_months" id="b_months" maxlength="2" value='<%=agem%>' size="2"
							 	onKeyPress='return(ChkNumberInput(this,event,0))'
							 	onBlur='CheckForNumber_L(this,onset);checkMonth(this,onset);calci(this,"DMY","<%=locale%>",onset)'   tabIndex='3'>M
								
									
								<input type="text" name="b_age" id="b_age" maxlength="3" size="3" value='<%=agey%>'  
								onKeyPress='return(ChkNumberInput(this,event,0))'
								onBlur='CheckForNumber_L(this,onset);calci(this,"DMY","<%=locale%>",onset)'   tabIndex='2'>Y)
																
								
								<input type='hidden' name='ServerDate' id='ServerDate' value='<%=onsetdate%>'>
				<%	} %>
			</td></tr>
					
					
					<% if (fnval.equals("modify")) { %>
					<td width='30%'  class='label'><fmt:message key="eCA.CloseDate.label" bundle="${ca_labels}"/></td>
					<td width='60%' class='fields' nowrap><input type='text' name='close' id='close' value='' size='10' maxlength='10' Onblur='CheckDate(this);return isBetweenCurrDate("<%=onsetdate%>","<%=currentdate1%>",this,"DMY","<%=locale%>");calcage(this,ServerDate1,close);calci1(b_age1,"DMY","<%=locale%>",close)' ><input type='image' src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('close');" ><input type='hidden' name='close_date' id='close_date' value='<%=closedate%>' >
							
						   <input type='hidden' name='close_date' id='close_date' value='<%=closedate%>'> 
								(<fmt:message key="eCA.Before.label" bundle="${ca_labels}"/>
								<input type="text" name="b_days1" id="b_days1" maxlength="2" size="2" value='<%=aged%>'  
								onKeyPress='return(ChkNumberInput(this,event,0))'
								onBlur= 'CheckForNumber_L(this,close);checkDays(this,close);calci1(this,"DMY","<%=locale%>",close)'   tabIndex='4'>D

								<input type="text" name="b_months1" id="b_months1" maxlength="2" value='<%=agem%>' size="2"  
								onKeyPress='return(ChkNumberInput(this,event,0))'
								onBlur= 'CheckForNumber_L(this,close);checkMonth(this,close);calci1(this,"DMY","<%=locale%>",close);'   tabIndex='3'>M
								
								<input type="text" name="b_age1" id="b_age1" maxlength="3" size="3" value='<%=agey%>'
							    onKeyPress='return(ChkNumberInput(this,event,0))'	onBlur='CheckForNumber_L(this,close);calci1(this,"DMY","<%=locale%>",close);'   tabIndex='2'>Y)
									
														
								<input type='hidden' name='ServerDate1' id='ServerDate1' value='<%=closedate%>'>


					
					<%}
			} catch  (Exception e) {
				// out.print("Exception in addModifyPatAllegy.jsp"+e.toString());//COMMON-ICN-0181
                                 e.printStackTrace();//COMMON-ICN-0181
			}
            %>
			<!--</tr></table>  -->
			</td></tr>
		</table>
	</div>
  		<input type='hidden' name='function_name' id='function_name'  value='<%=fnval%>'>
  		<input type='hidden' name='Patient_Id' id='Patient_Id' value='<%=patient_id%>'>
		<input type='hidden' name='Encounter_Id' id='Encounter_Id' value='<%=encounter_id%>'>
		<input type='hidden' name='Clinic_Code' id='Clinic_Code' value='<%=clinic_code%>'>
		<input type='hidden' name='Location_Type' id='Location_Type' value='<%=locn_type%>'>
		<input type='hidden' name='Practitioner_Id' id='Practitioner_Id' value='<%=practitioner_id%>'>
		<input type='hidden' name='srlno' id='srlno' value='<%=srlno%>'>
		<input type="hidden" name="help_function_id" id="help_function_id" value="RECORD_PATIENT_ALLERGY">
		<input type="hidden" name="tmpfld2" id="tmpfld2" value="">
		<input type="hidden" name="Dob" id="Dob" value ='<%=Dob%>'>
<!-- SS -->
						<input type=hidden name=errorRemarks value=''>
<!-- SE -->
	<%
		if(adesc.equals("D"))
		{
	%>
		<input type="hidden" name="allergicto" id="allergicto" value="">
	<%
		}
	%>
    </form>
    </body>
    </html>
    
   <% 
			if (rset!=null) rset.close();
			if (stmt!=null) stmt.close();
			if (pstmt!=null) pstmt.close();
			if (pstmt1!=null) pstmt1.close();
   } 
   catch(Exception e)
	{
		//out.println("Exception in addModifyPatAllegy.jsp"+e.toString());//COMMON-ICN-0181
		 e.printStackTrace();//COMMON-ICN-0181
		
	}
   finally
   {
		if (con!=null) ConnectionManager.returnConnection(con,request);
   }
  %>

