<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>   
<%@ page  contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.text.*,webbeans.eCommon.*, eCommon.XSSRequestWrapper" %>	 
<%
Connection con=null;
Statement stmt1 = null;
Statement stmt2 = null;

Statement stmt   	= null ;
Statement stmtlen   = null ;
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
ResultSet rs	   	= null;
ResultSet rs2	   	= null;
ResultSet rslen	   	= null;
PreparedStatement pstmt   = null; //Saanthaakumar  Bru-HIMS-CRF-302 [IN:035020] 
//String function_id = request.getParameter("function_id")==null?"":request.getParameter("function_id");


String function_id = request.getParameter("function_id")==null?"":request.getParameter("function_id");

boolean defalut_pract=false;
String currentdate="";


String fac_id    	= (String) session.getValue( "facility_id" ) ;
String locale = (String)session.getAttribute("LOCALE");
String sysdate1="";
String patient_id=request.getParameter("patient_id");

if(patient_id==null) patient_id="";
String readonly="";
String disabled="";
String module_id=request.getParameter("module_id");
if(module_id ==null) module_id="";
if(patient_id!=null && !(patient_id.equals("")))
{
	readonly="readonly";
	disabled="disabled";
}
	
try{
con = ConnectionManager.getConnection(request);
 stmt1 = con.createStatement();

 stmt   	= con.createStatement() ;
 stmt2   	= con.createStatement() ;
 stmtlen   = con.createStatement() ;


int pat_id_len=0;
	if (rslen!=null) rslen.close();
	rslen=stmtlen.executeQuery("Select Patient_Id_Length,Nat_Id_Length,alt_id1_length,pat_name_as_multipart_yn ,to_char(sysdate,'dd/mm/yyyy') d from mp_param,dual");

	if(rslen !=null && rslen.next())
	{
	pat_id_len=rslen.getInt("Patient_Id_Length");
	currentdate = rslen.getString("d");
	currentdate=DateUtils.convertDate(currentdate,"DMY","en",locale);
	}

   String str="select to_char(sysdate+2,'dd/mm/yyyy') sysdate1 from dual";
		 
	rs2=stmt2.executeQuery(str);
	if(rs2!=null){
		if(rs2.next()){
	sysdate1 =rs2.getString("sysdate1");
	sysdate1=DateUtils.convertDate(sysdate1,"DMY","en",locale);
	
		}
	}
	%>
	
	<script>
	// Thursday, February 18, 2010 19335 Venkat S.
	function locn_change()
	{
		document.forms[0].speciality.value=document.forms[0].b_speciality.value;
	}
   </script>
	<html>
	<head>
	<script src="../../eOA/js/QueryApptForPatient.js"></script>
	<script src="../../eCommon/js/common.js"></script>
	<script src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"> </script>
	<script language="javascript" src="../../eCommon/js/dchk.js"> </script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	
	
	
	<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
	<Script language="JavaScript"src="../../eCommon/js/DateUtils.js" ></Script>
	<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
	
	<script>
	
	async function searchCategory(obj,target)
{    
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="";
	if(target.name == 'pat_cat_desc')
	{
		tit=getLabel("Common.category.label","common");
		//sql="SELECT pat_cat_code code, short_desc description FROM mp_pat_category_lang_vw WHERE language_id = '"+localeName+"' and eff_status = 'E' and upper(pat_cat_code) like upper(?) and upper(short_desc) like upper(?) ORDER BY 2";
		sql = "SELECT pat_cat_code code, short_desc description FROM mp_pat_category_lang_vw WHERE language_id = '"+localeName+"' and eff_status = 'E' and upper(pat_cat_code) like upper(?) and upper(short_desc) like upper(?)";

	}

	argumentArray[0] = encodeURIComponent(sql);
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;

	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		if(target.name == 'pat_cat_desc')
		{
		document.forms[0].pat_cat_code.value= arr[0];
		}
	}
	else{
		target.value='';
		document.forms[0].pat_cat_code.value='';
	}
	
}
	
	
	</script>
	
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	 <link rel='stylesheet' type='text/css'  href='../../eCommon/html/CommonCalendar.css'></link>
    <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

			
</head>
<body onMouseDown="CodeArrest();" onKeyDown = 'lockKey()' onload='chkmangif()'>
<form name="QueryApptForPatient" id="QueryApptForPatient">
<table width='100%' cellspacing='0' cellpadding='0' border='0'>
	<tr>
		<%if(patient_id.equals("")){%>	
			<td  class=label  nowrap width='22%'><fmt:message key="eOA.SearchWith.label" bundle="${oa_labels}"/></td>
			
			<td class='fields' nowrap width='35%'><select name='sel_with' id='sel_with' onchange ="visman(this)">
			<!--<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------- -->
			<option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/>
			<option value='W'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
			</select><img  src="../../eCommon/images/mandatory.gif" align='center'></img>

		<%}else {
			%>
			<td  class=label width='25%'><fmt:message key="eOA.SearchWith.label" bundle="${oa_labels}"/></td>

			<td class='fields'><select name='sel_with' id='sel_with' onchange ="visman()" disabled>
			<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------
			<option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/>
			<option value='W'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
			</select></td>

		<%}%>

	    <td class=label nowrap width='22%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>

		<td class='fields' nowrap width='22%'>
			<input type='text' name='b_patient_id' id='b_patient_id' size='<%=pat_id_len%>' maxlength='<%=pat_id_len%>' value='<%=patient_id%>' <%=readonly%> onBlur="ChangeUpperCase(this);"><input type='button' name="search" id="search" value="?" onClick="patqry()" class='button' <%=disabled%>><img  id='patientMan' align='center'  src="../../eCommon/images/mandatory.gif"></img>
		</td>

   </tr>
	
   <tr>

		<td class='label'  nowrap ><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
			
		<td class='fields' >
			<!-- <input type=text name='patientName' id='patientName' size='40' maxlength='60' value='' readonly tabindex=7></input> Commented for the RUT-SCF-103 32223-->
			 <input type=text name='patientName' id='patientName' size='40' maxlength='60' value='' tabindex=7></input>
		</td>	
			
		<td class=label nowrap ><fmt:message key="Common.category.label" bundle="${common_labels}"/></td>

		<td class='fields' nowrap>
			<input type='text' name='pat_cat_desc' id='pat_cat_desc' size='20' maxlength='20' value="" onblur='if(this.value!=""){searchCategory(pat_cat_code,pat_cat_desc);}'   ><input type='button'  name='pat_cat_code_id' id='pat_cat_code_id' value='?' class='button' onclick='searchCategory(this,pat_cat_desc)' >
					<input type='hidden' name='pat_cat_code' id='pat_cat_code' value=""> 
	    </td>
		
</tr>

<tr>
		<td class='label'><fmt:message key="Common.apptno.label" bundle="${common_labels}"/></td>

		<td  nowrap class='fields'><input type='text' name='b_appt_ref_no' id='b_appt_ref_no' size='8' maxlength='8' value=''>
			
		</td>

		<td  class=label ><fmt:message key="Common.apptdate.label" bundle="${common_labels}"/></td>
      <td nowrap class='fields'><input type='text' id='patfrom' name='b_from_date' id='b_from_date' size='10' maxlength='10' onBlur="DateCompare_from('from',this,'<%=currentdate%>');ValidateDate_from(this,b_to_date);"><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].b_from_date.select();return showCalendar('patfrom');"><img  id='fromdategif' align='center'  src="../../eCommon/images/mandatory.gif"></img>
				
			&nbsp;<input type='text' id='patto' name='b_to_date' id='b_to_date' size='10' maxlength='10' onBlur="DateCompare_from('To',this,'<%=currentdate%>');ValidateDate_to(this,b_from_date);"><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].b_to_date.select();return showCalendar('patto');"><img  id='todategif' align='center'  src="../../eCommon/images/mandatory.gif"></img></td>
			</tr>
		<tr>	
		<td  class=label ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
		<td class='fields'>
			<!-- Thursday, February 18, 2010 19335 Venkat S.-->
				<select name='b_speciality' id='b_speciality' onchange='locn_change()'> 
			<%if (rs!=null) rs.close();%>
				<option value=''>-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------- </option>
			
			<% rs	= stmt.executeQuery("select short_desc, speciality_code from am_speciality_lang_vw where eff_status = 'E' and language_id='"+locale+"' order by short_desc" ) ;				
					String sp_code = "" ;
					String sp_desc = "" ;				
					if (rs != null)
					{
						while (rs.next())
						{
							sp_code = rs.getString("speciality_code") ;	
							sp_desc = rs.getString("short_desc") ;%>
							<option value='<%=sp_code%>' ><%=sp_desc%>
						<%
						}
					}

				%> 
				</select>
		 </td>
		 <td  class=label >&nbsp;</td>
		 <td  class=label >&nbsp;</td>
			
  </tr>

  <tr>
			
			<td  class=label ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>

			<td class='fields'>
					<SELECT name='location_type' id='location_type' onChange="javascript:populateLocations(this)" style="width:105">
					<option value=''>&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;</option>
					<%
					String care_locn="";
					String short_desc="";
					if (rs!=null) rs.close();
					rs=stmt.executeQuery( "select locn_type,short_desc,CARE_LOCN_TYPE_IND from am_care_locn_type_lang_vw where SYS_USER_DEF_IND='S' and locn_type in ('C','E','Y') and language_id='"+locale+"' order by short_desc ");
						if(rs!=null){
						   while(rs.next()) {
							   care_locn=rs.getString("CARE_LOCN_TYPE_IND");
							   short_desc=rs.getString("short_desc");
							   %>
					<option value='<%=rs.getString("CARE_LOCN_TYPE_IND")%>|<%=care_locn%>|<%=short_desc%>'><%=rs.getString("short_desc")%></option>
						<%	}
						}
					%>
					</select>
			  </td>
						
			  <td  class=label ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>	
					
				<td class='fields'>
					<!-- <select name='b_loc' id='b_loc' onChange ='ena_pract(this)' >	
					<option value=''>---------------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----------------------</option>
					</select> -->	


					<input type='text' name='b_loc_val' id='b_loc_val' size='25' maxlength='25' value='' onBlur="ena_loc_lookup(this);"><input type='button' name="b_loc_search" id="b_loc_search" value="?" onClick="open_loc_lookup()" class='button' >
					<input type="hidden" name="b_loc" id="b_loc" value="">
 </tr>	
	
 
<tr>
  <td class=label nowrap><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></td>
				  
			  <td class='fields'>
					<SELECT name='resourceType_1' id='resourceType_1'  onchange="enable_dsiable_res(this)" disabled>
					<option value=''>------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------- </option>
					<option value='P' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/> </option>
					<option value='E'><fmt:message key="Common.equipment.label" bundle="${common_labels}"/></option>
					<option value='R'><fmt:message key="Common.room.label" bundle="${common_labels}"/> </option>
					<option value='O'><fmt:message key="Common.other.label" bundle="${common_labels}"/> </option>
					</SELECT>

					
			  </td>

			 <jsp:include page="../../eOA/jsp/OAResourcelookupframe.jsp" ><jsp:param name="flush" value="true" />
				<jsp:param name ="from_page" value= "query" />
				<jsp:param name ="pract_value" value= "" />
				</jsp:include>

							
		    
			
			  <!-- <td class=label nowrap><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>

			  <td class='fields'>
				  <input type="text" name="b_pract_name" id="b_pract_name" onblur = "onblurcheck(this,b_pract_name)" size="25" maxlength="30" disabled ><input type="button" name="preact_butt" id="preact_butt" value="?" class="button" onCLick="callPractSearch(this,b_pract_name);" disabled><input type="hidden" value="" name="b_pract" id="b_pract">
			  </td> -->
 </tr>
		<%if(defalut_pract){%>
			<script>
				document.forms[0].b_pract.value=document.forms[0].b_pract1.value;
				document.forms[0].b_pract1.disabled=true;
				
			</script>
		<%}%>
            
		<tr>
			
		<td  nowrap class='label' ><fmt:message key="eOA.IncludePastAppts.label" bundle="${oa_labels}"/></td>
	    <td  class='fields'  ><input type='checkbox' name='incld_past_appts' id='incld_past_appts' value='N' onClick='checkValues(this)' disabled ></td>

			<td  nowrap class='label' ><fmt:message key="Common.MobileNo.label" bundle="${common_labels}"/></td>
	    <td  class='fields'  ><input type='text' name='b_mobileno' id='b_mobileno' value='' onKeyPress='return(ChkNumberInput(this,event,0))' size='10' maxlength='10' >
	    </td>
	</tr> 
	<tr>
	 <td class="label" width="22%"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
	 <td class="fields"><select name='facility' id='facility'>
	 <option value='' selected>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
	 <%
	  
      //Saanthaakumar  Bru-HIMS-CRF-302 [IN:035020] 
	  //StringBuffer sqlStr = new StringBuffer("");
	  pstmt = con.prepareStatement("select facility_id,facility_name from SM_FACILITY_PARAM_LANG_VW where language_id='"+locale+"' order by 2");try
	  {
	  rs = pstmt.executeQuery();
	  if(rs!=null)
	  {
		  while(rs.next())
		  {
			String id=rs.getString(1);
			String name = rs.getString(2);
			if(id.equals(fac_id))
			  {
			%>
				<option value=<%=id%> selected><%=name%></option>
		  <%
			  }
			  else
			  {%>
				<option value=<%=id%> ><%=name%> </option> 
			<%	}
				}
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
	  }
	  }catch(Exception e){
//out.println(e);
e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
	 finally
	 {
		if(con!=null) ConnectionManager.returnConnection(con,request); 
	 }
	  %>
	 </select></td>
  	<td nowrap class='button' colspan='3' align='right'><input type="button" class='button' name="select" id="select" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="callResult()" >&nbsp;
			<input type="button" class='button' name="clear" id="clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick="clearvals();" ></td>
			 <td colspan='2'></td>
	</tr> 
			
		
</table>
<input type='hidden' name='sys_date' id='sys_date' value='<%=currentdate%>'>
<input type='hidden' name='short_desc' id='short_desc' value='<%=short_desc%>'>
<input type='hidden' name='b_facility' id='b_facility' value='<%=fac_id%>'>
<input type='hidden' name='module_id' id='module_id' value='<%=module_id%>'>
<input type='hidden' name='patient_id_ca' id='patient_id_ca' value='<%=patient_id%>'>
<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
<input type='hidden' name='sysdate1' id='sysdate1' value='<%=sysdate1%>'></input>

<input type='hidden' name='appt_ref_no' id='appt_ref_no' value="">
<input type='hidden' name='orderCriteria' id='orderCriteria' value='apptno'>
<input type='hidden' name='orderCriteria_sensor' id='orderCriteria_sensor' value='apptno'>
<input type='hidden' name='asc_desc' id='asc_desc' value=' asc'>
<input type='hidden' name='asc_desc_sensor' id='asc_desc_sensor' value=''>
<input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'>
<input type='hidden' name='speciality' id='speciality' value=''> <!--Thursday, February 18, 2010 19335 Venkat S. -->






<!-- <input type='hidden' name='order' id='order' value=''>
<input type='hidden' name='orderCriteria' id='orderCriteria' value=''>

<input type='hidden' name='appt_ref_no' id='appt_ref_no' value="">
<input type='hidden' name='orderCriteria_sensor' id='orderCriteria_sensor' value=''>
<input type='hidden' name='order_sensor' id='order_sensor' value=''> -->


</form>
<%
	if(rs		!=null) rs.close();
	if(rs2		!=null) rs2.close();
	if(rslen	!=null) rslen.close();
	if(stmt		!=null) stmt.close();
	if(stmtlen	!=null) stmtlen.close();
	if(stmt1	!=null) stmt1.close();
	if(stmt2	!=null) stmt2.close();

}catch(Exception es){
	//out.println(es.toString());
es.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally { 
	if(con!=null) ConnectionManager.returnConnection(con,request);
}			
	
%>

</body><script>parent.frames[1].document.forms[0].b_patient_id.focus();
</script>
</html>

