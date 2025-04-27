<!DOCTYPE html>
<%@  page import ="java.sql.Connection,java.sql.PreparedStatement,eCommon.Common.*,java.sql.CallableStatement,java.sql.ResultSet,eCommon.XSSRequestWrapper,webbeans.eCommon.ConnectionManager" %>
<%@  page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends 
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>

<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language='javascript' src='../../eDS/js/ModifyMealPlan.js'></script>
<script language="Javascript" src="../../eDS/js/DSCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<!--Added Against ML-MMOH-CRF-0674-->

</head>
<body onLoad="" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>

<%
		String facility_id	= (String) session.getValue("facility_id");
		//Checkstyle Violation commented by Munisekhar
		//String func_mode = request.getParameter("func_mode") ;
		//String patient_id	= "";
		//String encounter_id	= "";
		//String kitchenCode="";
		//String dietType="";
		//String mealType="";
		String strSysDate="";
		String status="";
		String mode = request.getParameter("mode");
		String PatIDLen ="";
		Connection conn=null;
		//CallableStatement cstmt = null;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		PreparedStatement pstmt3=null;
		ResultSet rs=null;
		ResultSet rst=null;
		ResultSet rs1=null;
		ResultSet rs2=null;
		ResultSet rs3=null;
		boolean isMultiDietType =false; //Added By Gaurav Against MMS-KH-SCF-0207
		try
		{
		conn = ConnectionManager.getConnection(request);
		isMultiDietType = CommonBean.isSiteSpecific(conn,"DS","DS_MULTI_DIET_TYPES"); //Added By Gaurav Against MMS-KH-SCF-0207
		pstmt=conn.prepareCall("SELECT PATIENT_ID_LENGTH,to_char(SYSDATE,'dd/mm/yyyy') SYSDATE1 from MP_PARAM");
		rs=pstmt.executeQuery();

		if(rs!=null &&rs.next()==true)
		{
		     PatIDLen   = (rs.getString("PATIENT_ID_LENGTH")==null)?"0":rs.getString("PATIENT_ID_LENGTH");
			strSysDate=com.ehis.util.DateUtils.convertDate(rs.getString("SYSDATE1"),"DMY","en",locale);
		}
		if(rs!=null)		rs.close();
		if(pstmt !=null) pstmt.close();


%>

<form name="ModifyMealPlan_form" id="ModifyMealPlan_form"  onload='FocusFirstElement()'  action="../../servlet/eDL.ModifyMealPlanServlet" method="post" target="messageFrame">

<script>
async function getPatID()
{
	var pat_id= await PatientSearch();
	var enc_id=await PatientSearch();
	if( pat_id != null && enc_id != null  )
	document.forms[0].patient_id.value = pat_id;
	document.forms[0].encounter_id.value = enc_id;
}

async function PatientSearch()
{
	var window_styl='O';
	var close_yn='Y';
	var   jsp_name='';
	var win_top= '61';
	var win_height= '44';
	var win_width= '65';
	var act_yn= 'N';
	var register_button_yn = 'N';
	var func_act='';	
	var dr_function_id='';
	var srr='Y';

	window_styl = window_styl.toUpperCase();
	close_yn = close_yn.toUpperCase();
	act_yn = act_yn.toUpperCase();
	
	var patient_class='';	
		
    var url     = "../../eMP/jsp/ModelPatientSearch.jsp?jsp_name="+jsp_name+"&window_styl="+window_styl+"&close_yn="+close_yn+"&win_top="+win_top+"&win_height="+win_height+"&win_width="+win_width+"&act_yn="+act_yn+"&srr="+srr+"&register_button_yn="+register_button_yn+"&func_act="+func_act+"&dr_function_id="+dr_function_id+"&patient_class="+patient_class;
	
	var dialogTop       = "61";
	var dialogHeight    = "500px" ;
	var dialogWidth = "800px" ;
	var arguments   = "" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status:no" ;
	var returnval =await window.showModalDialog( url, arguments, features ) ;
	return returnval;
}

</script>

<br><br><br><br><br><br>
<table border='0' cellpadding='2' cellspacing='0' width='90%' align='center'>
	<tr>
		<td  class="label"><fmt:message key="eOT.ServingDate.Label" bundle="${ot_labels}"/></td>
		<td class='fields' width='25%'>
			<input type="text" name="service_date" id="service_date" size="10" maxlength=10 value="<%=strSysDate%>" onkeypress="return checkForSpecCharsforID(event);" onblur='isValidDate(this);' >
			<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('service_date');">
			<img src='../../eCommon/images/mandatory.gif'></img>
		</td>
		<td  class="label"><fmt:message key="eOT.Kitchen.Label" bundle="${ot_labels}"/></td>
			<td class='fields' width='25%'>
			<select name="kitchenCode" id="kitchenCode" onChange="">
			<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
			<%
			try{
						String kitchen_temp   = "";
						//Checkstyle Violation commented by Munisekhar
						//String kitchen_select = "";
						String kitchen_desc = "";
						String sql_kitchen ="SELECT KITCHEN_CODE, DS_GET_DESC.DS_KITCHENS('"+facility_id+"',KITCHEN_CODE,'"+locale+"','2') FROM DS_KITCHENS WHERE operating_facility_id ='"+facility_id+"' AND NVL (EFF_STATUS, 'E') = 'E' ORDER BY 2";
// 						conn			= ConnectionManager.getConnection(request);
						pstmt1			= conn.prepareStatement(sql_kitchen) ;
						rs1				= pstmt1.executeQuery();
						while(rs!=null && rs1.next()){
						kitchen_temp=rs1.getString(1);
						kitchen_desc=rs1.getString(2);
			%>
				<option value="<%=kitchen_temp%>">
				<%=kitchen_desc%>
				</option>
			<%
						}
						}catch(Exception e){
						e.printStackTrace();
					   }finally{
				try{
						if(rs1!=null)rs1.close();
						if(pstmt1!=null)pstmt1.close();
// 						if(conn!=null) ConnectionManager.returnConnection(conn,request);
				}catch(Exception e){}
				}
			%>
			</select>
			<img src='../../eCommon/images/mandatory.gif'></img>
		</td>
	</tr>

	<tr><%  String pat_id_length="";
	      try{
	         pstmt = conn.prepareStatement("select patient_id_length from mp_param where MODULE_ID='MP'");
			  rs	=	pstmt.executeQuery();
			if (rs.next() && rs != null)
			{
				pat_id_length = rs.getString(1);
				

			}
			}catch(Exception e){
						e.printStackTrace();
					   }finally{
				try{
						if(rs!=null)rs.close();
						if(pstmt!=null)pstmt.close();
					
				}catch(Exception e){}
				}
			%>
			
		<td class="label" width="10%"><fmt:message key="Common.patientId.label"   bundle="${common_labels}"/></td>
		<td class="fields" width="10%">
		<INPUT TYPE="TEXT"  name="patient_id" id="patient_id" SIZE="12" maxlength="<%=pat_id_length%>" VALUE='' onKeypress='return CheckForSpecChars(event);' onBlur="makeValidString(this);ChangeUpperCase(this);encounterLookup1();">
		<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="patientLookup()" >
		</td>

		<td  class="label"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		<td width='25%' class='fields'>
		<input type="text" name="encounter_id" id="encounter_id" value="" size='12' maxlength='12' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur="CheckNumVal(this)" >
		<img src='../../eCommon/images/mandatory.gif'></img>
		</td>
	</tr>

	<tr>
		<td  class="label"><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></td>
		<td width='25%' class='fields'>
			<input type="checkbox" name="frequency" id="frequency" onClick='chkFrequency();' value="E" >
		</td>
	</tr>

	<tr>
		<td  class="label"><fmt:message key="eOT.DietType.Label" bundle="${ot_labels}"/></td>
		<td width='25%' class='fields'>
		<%if(isMultiDietType){%>
			<!-- Commented Against ML-MMOH-CRF-1818 -->
				<!-- Added Against ML-MMOH-CRF-1818 Starts-->
		<input type="text" value="" id="dietTypeDesc" name="dietTypeDesc" id="dietTypeDesc" onblur="if(this.value!='') return              dietTypeLookup('dietTypeDesc'); else dietType.value=''"/>
		<input type="hidden"  value="" name="dietType" id="dietType" />
		<input type="button" id="bt" class="BUTTON" value="?" onclick="dietTypeLookup('dietTypeDesc')" />
		<img id="mand1" src='../../eCommon/images/mandatory.gif'></img>
		<!-- Added Against ML-MMOH-CRF-1818 Ends-->
		<%}else{%>
		        <!-- Commented Against ML-MMOH-CRF-1818 -->
				<select name="dietType" id="dietType"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
				<%
					 try
						{
							String dietTypeCode = "";
							String dietTypeDesc =  "";
							//String sql_diet_type ="select diet_type,short_Desc from ds_diet_type_lang_vw where language_Id like '"+locale+"' and eff_Status ='E' order by short_Desc ASC";
							String sql_diet_type ="select diet_type,short_Desc from ds_diet_type_lang_vw where language_Id like '"+locale+"' order by short_Desc ASC";//59957
							pstmt=conn.prepareStatement(sql_diet_type);
							rst = pstmt.executeQuery();
							while(rst.next()){
							dietTypeCode = rst.getString(1);
							dietTypeDesc =  rst.getString(2);
				%>
					<option value="<%=dietTypeCode%>">	<%=dietTypeDesc%> </option>
				<% }
						}
						catch(Exception DCat)
						{
							DCat.printStackTrace();
							System.out.println("MealOrderList==DietType==>"+DCat);
						}
						finally
						{
							if(rst != null) rst.close();
							if(pstmt != null) pstmt.close();
						} 

				%>
					</select>
				
		<%}%>
		</td>

		<td  class="label"><fmt:message key="eOT.MealType.Label" bundle="${ot_labels}"/></td>
		<td class='fields' width='25%'>
			<select name="mealType" id="mealType" onChange="">
				<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>

			<%
			try{
						String meal_temp   = "";
						//Checkstyle Violation commented by Munisekhar
						//String meal_select = "";
						String meal_desc = "";
						String sql_meal ="SELECT MEAL_TYPE, DS_GET_DESC.DS_MEAL_TYPE(MEAL_TYPE,'"+locale+"','2') FROM DS_MEAL_TYPE WHERE NVL (EFF_STATUS, 'E') = 'E' AND nvl(IP_MEAL_ORDER_YN,'N') = 'Y' ORDER BY MEAL_ORDER";//ML-MMOH-CRF-1006 - US4
						pstmt3			= conn.prepareStatement(sql_meal) ;
						rs3				= pstmt3.executeQuery();
						while(rs3!=null && rs3.next()){
						meal_temp=rs3.getString(1);
						meal_desc=rs3.getString(2);
			%>
				<option value="<%=meal_temp%>">
				<%=meal_desc%>
				</option>
			<%
						}
						}catch(Exception e){
						e.printStackTrace();
					   }finally{
				try{
						if(rs3!=null)rs3.close();
						if(pstmt3!=null)pstmt3.close();
						//if(conn!=null) ConnectionManager.returnConnection(conn,request);
				}catch(Exception e){}
				}
			%>
			</select><img  id="mand2"  src='../../eCommon/images/mandatory.gif'></img>
		</td>
	</tr>

	<tr>
	   <td width='25%' class="fields"> </td>
	   <td width='25%' class="fields"> </td>
	   <td width='25%' class="fields"> </td>
	   <td width='25%' class="fields"> </td>
		<td width='25%' class="fields">
			<input type="button" class="button" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick="showModifyMealPlanRecords()">
		</td>
	</tr>
</table>

<table border='0' cellpadding='2' cellspacing='0' width='100%' align='center'>
	<th align="center" colspan=8 class='CAGROUPHEADING'>
		<fmt:message key="eOT.ItemDtls.Label" bundle="${ot_labels}"/>
	</th>

	<tr>
	   <td width='25%' class="fields"> </td>
	   <td width='91%' class="fields"> </td>
		<td class="label" colspan=3>
			<fmt:message key="eOT.DontServe.Label" bundle="${ot_labels}"/>
		</td>
		<td  width='25%' class='fields'>
		<%--IN:39963--%>
		<% if("Y".equalsIgnoreCase(status)){ %>
			<input type="checkbox" name="status" id="status" onClick='callStatus();' checked value='<%=status%>'>
		<%} else{ %>
			<input type="checkbox" name="status" id="status" onClick='callStatus();' value='<%=status%>'>
		<%} %>
		</td>
	</tr>
</table>

<%}catch(Exception e)
	{
	e.printStackTrace();

	}finally
		{
			try{

				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) ConnectionManager.returnConnection(conn,request);
			}catch(Exception ee){}
		}%>


<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
<input type='hidden' name='hdnstatus' id='hdnstatus' value=''>
<input type=hidden name="facility_id" id="facility_id" value="<%=facility_id%>" />
<input type=hidden name="date_compare" id="date_compare" value="<%=strSysDate%>" />
<!-- Added against ML-MMOH-CRF-0674-->
<INPUT type="hidden" name="diettype_auto" id="diettype_auto" id="diettype_auto" value="">
<INPUT type="hidden" name="auto_flag" id="auto_flag" id="auto_flag" value="false">
<!-- Added against ML-MMOH-CRF-0674-->
</form>
</body>
</html>

