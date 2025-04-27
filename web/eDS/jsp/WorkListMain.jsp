<!DOCTYPE html>
<%@ page import="webbeans.eCommon.ConnectionManager,java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,eCommon.XSSRequestWrapper,eCommon.Common.*"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
<head>
	<%  
	    //Added Against MMS Vulnerability Issue - Starts
	    request= new XSSRequestWrapper(request);
	    response.addHeader("X-XSS-Protection", "1; mode=block");
	    response.addHeader("X-Content-Type-Options", "nosniff");
		//Added Against MMS Vulnerability Issue - Ends
		String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")) ?
		(String) session.getAttribute("PREFERRED_STYLE"):"IeStyle.css" ;
				if(sStyle==null)sStyle="IeStyle.css";

		String facility_id	= (String)session.getAttribute("facility_id");
		String language_Id  = (String)session.getAttribute("LOCALE");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		conn = ConnectionManager.getConnection(request);
		//Added Below Against ML-MMOH-CRF-1123-US2
		boolean isAlaCarte=false;
		isAlaCarte=CommonBean.isSiteSpecific(conn,"DS","PLACE_ORDER_FOR_ATTENDANT");
		//Added Below Against KDAH-CRF-0511
		boolean isReOrder=false; 
		isReOrder=CommonBean.isSiteSpecific(conn,"DS","DS_MEAL_MENU_ITEMS");
	%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script type="text/javascript">
	function check(){
		//ML-MMOH-CRF-1123-US2
		var isAlaCarte=document.getElementById("isAlaCarte").value;
		var alaCarte="";
		if(isAlaCarte=='true'){
			alaCarte=document.getElementById("alaCarte").value;
		}else{
			alaCarte=""
		}
		//ML-MMOH-CRF-1123-US2		
		if(document.getElementById("nursing_Unit").value == ""){
			alert(getMessage("DS_NURSGUNIT_NOT_BLANK","DS"));
			return false;
		}
		//ML-MMOH-CRF-1123-US2
		else if(isAlaCarte=='true' && document.getElementById("alaCarte").value == ""){
			alert(getMessage("DS_PLACEORDER_NOT_BLANK","DS"));
			return false;
		}
		//ML-MMOH-CRF-1123-US2
		else{
			//IN::39925
			var flag = compareDate(document.getElementById("dateFrom").value,document.getElementById("dateTo").value);
			if(flag== 1){
				var error=getMessage("DS_ADMTODAT_GRTREQL_FRMDAT","DS"); //"Admission To Date should be greater than or equal to Admission From Date";
				parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error
				return false;
			}else
			{
				var error="";
				parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error
			}
			
			var nursingUnit = document.getElementById("nursing_Unit").value;
			var encounterId = document.getElementById("encounter_id").value;
			var patientId = document.getElementById("patient_id").value;
			var sex = document.getElementById("sex").value;
			//var practitionerId = document.getElementById("practitioner_name").value;//59404
			var practitionerId = document.getElementById("practitioner_id").value;//59404
			var fromDate = document.getElementById("dateFrom").value;
			var toDate = document.getElementById("dateTo").value;
			var status = document.getElementById("status").value;
			var SearchFor=document.getElementById("SearchFor").value;//MMS-CRF-006
			parent.workListResult.location.href ="../../eDS/jsp/WorkListFrame.jsp?NursingUnit="+nursingUnit+"&encounterId="+encounterId+"&patientId="+patientId+"&sex="+sex+"&practitionerId="+practitionerId+"&fromDate="+fromDate+"&toDate="+toDate+"&status="+status+"&SearchFor="+SearchFor+"&alaCarte="+alaCarte;//MMS-CRF-006 & ML-MMOH-CRF-1123-US2
	}
	}
   function CheckNumVal(obj)
    {
		if (parseInt(obj.value) <= 0)
		{
			alert(getMessage('IP_VAL_NOT_LESS_ZERO',"IP"));
			obj.select();
		}
		else
		{
			CheckNum(obj);
		}
    }
   async function callPatientSearch(){
		var pat_id = await  PatientSearch();
		if(pat_id != null)
		document.getElementById("patient_id").value = pat_id;
		}
		
	function compareDate(date1,date2) {
	var flag="";
    if(date1.length > 0 && date2.length > 0 ) {
			var date1_array = date1.split(" ");
			var date1_temp= date1_array[0];
			
			var date2_array = date2.split(" ");
			var date2_temp = date2_array[0];
			
	        var date1array = date1_temp.split("/");
            var date2array = date2_temp.split("/");
            
			var date1dt = new Date(date1array[2],date1array[1],date1array[0]);
            var date2dt = new Date(date2array[2],date2array[1],date2array[0]);
			//alert(new Date(2004,11,24,23,11)); is the format used above yyyy,mm,dd,hh24,mi
			if(Date.parse(date1dt) > Date.parse(date2dt)) {
                flag=1;
            }
			else if(Date.parse(date1dt) == Date.parse(date2dt)) {
				flag=0;
			}
			else flag=-1;
			
    }
	return flag;
	}

	async function PatientSearch(jsp_name,window_styl,close_yn,win_top,win_height,win_width,act_yn,srr,register_button_yn,func_act,dr_function_id) {
        if (window_styl == null || window_styl.length     == 0)         window_styl='O';
        if (close_yn    == null || close_yn.length         == 0)        close_yn='Y';
        if (jsp_name    == null || jsp_name.length        ==0   )   jsp_name='';
        if (win_top == null || win_top.length == 0) win_top= '61';
        if (win_height == null || win_height.length == 0) win_height= '90vh';
        if (win_width == null || win_width.length == 0) win_width= '80vw';
        if (act_yn == null || act_yn.length == 0) act_yn= 'N';
        if (register_button_yn == null || register_button_yn.length == 0) register_button_yn = 'N';
        if(func_act == null || func_act.length == 0) func_act='';
        if(dr_function_id == null || dr_function_id.length == 0) dr_function_id='';

         if (srr == null || srr.length == 0) srr='Y';

        window_styl = window_styl.toUpperCase();
        close_yn = close_yn.toUpperCase();
        act_yn = act_yn.toUpperCase();
		var url ="";
		url     ="../../eMP/jsp/ModelPatientSearch.jsp?jsp_name="+jsp_name+"&window_styl="+window_styl+"&close_yn="+close_yn+"&win_top="+win_top+"&win_height="+win_height+"&win_width="+win_width+"&act_yn="+act_yn+"&srr="+srr+"&register_button_yn="+register_button_yn+"&func_act="+func_act+"&dr_function_id="+dr_function_id;
		var dialogTop   = "65";
        var dialogHeight    = "90vh" ; //30.5
        var dialogWidth = "80vw" ;
        var arguments   = "" ;
        var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status: no" ;
        var returnval = await top.window.showModalDialog( url, arguments, features ) ;
        return returnval;
	}
	function onblurcheck(obj,target)
	{
		if(target.value == "")
		{
			document.getElementById("practitioner_name").value ="";
			document.getElementById("practitioner_id").value ="";//59404
		return;
		}
		callPractSearch(obj,target)

	}

	function callPractSearch(obj,val)
	{
		if(obj.value==""){
		document.forms[0].practitioner.value="";//59404
		document.forms[0].practitioner_id.value="";//59404
		}
		var	target = document.all("practitioner_name")

		var practName_FName="";
		var practName_FValue="";
		var practId_FName="";

		practName_FName=target.name;
		practName_FValue=target.value;

		var sql="";
		var sql2="";
		var open_to_all_pract_yn = "Y";
		var language_Id = document.all("language_Id")
		//var facility_id = document.all("facility_Id")
		var facility_id = "<%=facility_id%>";// IN::39851
		var clinic_code ="";
		clinic_code = "";

		sql= "SELECT a.PRACTITIONER_ID practitioner_id, a.PRACTITIONER_NAME practitioner_name,	b.pract_type_desc practitioner_type,b.primary_splty_short_desc primary_specialty,DECODE(b.job_title,'CC','Chief Consultant', 'CO', 'Consultant','RG',  'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC',  'Sr.Consultant','SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' )job_title,b.gender	FROM am_pract_for_facility_vw a, am_practitioner_vw b 	WHERE operating_facility_id = '"+facility_id+"' 	 AND a.practitioner_id = b.practitioner_id  	AND UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type))    AND UPPER(a.primary_speciality_code) LIKE UPPER(NVL(?,a.primary_speciality_code)) 	AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) 	OR UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name)))	AND DECODE(UPPER(b.gender),'MALE','M','FEMALE','F','Unknown','U')	LIKE NVL(UPPER(?),DECODE(UPPER(b.gender),'MALE','M','FEMALE','F','Unknown','U'))AND UPPER(NVL(job_title,'123')) LIKE UPPER(NVL(?,NVL(job_title,'123')))" ;

		sql2="SELECT a.PRACTITIONER_ID practitioner_id, a.PRACTITIONER_NAME practitioner_name,	b.pract_type_desc practitioner_type,b.primary_splty_short_desc primary_specialty,DECODE(b.job_title,'CC','Chief Consultant', 'CO', 'Consultant','RG',  'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC',  'Sr.Consultant','SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' )job_title,b.gender	FROM am_pract_for_facility_vw a, am_practitioner_vw b 	WHERE operating_facility_id = '"+facility_id+"' 	 AND a.practitioner_id = b.practitioner_id  	AND UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type))    AND UPPER(a.primary_speciality_code) LIKE UPPER(NVL(?,a.primary_speciality_code)) 	AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) 	AND UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name)))	AND DECODE(UPPER(b.gender),'MALE','M','FEMALE','F','Unknown','U')	LIKE NVL(UPPER(?),DECODE(UPPER(b.gender),'MALE','M','FEMALE','F','Unknown','U'))AND UPPER(NVL(job_title,'123')) LIKE UPPER(NVL(?,NVL(job_title,'123')))" ;
		/* var xmlDoc= new ActiveXObject( "Microsoft.XMLDom" ) ;
		var xmlHttp= new ActiveXObject( "Microsoft.XMLHTTP" ) ; */
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr += " practName_FName=\"" + encodeURIComponent(practName_FName) + "\"";
		xmlStr += " practName_FValue=\"" + encodeURIComponent(practName_FValue) + "\"";
		xmlStr += " practId_FName=\"" + practId_FName + "\"";
		xmlStr += " sql=\"" +escape(sql)+ "\"";
		xmlStr += " sqlSec=\"" +escape(sql2)+ "\"";
		xmlStr += " practitioner_type=\"" + "" + "\"";
		xmlStr += " specialty_code=\"" + "" + "\"";
		xmlStr += " job_title=\"" + "" + "\"";
		xmlStr += " gender=\"" + "" + "\"";

		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

		xmlHttp.open( "POST","<%=request.getContextPath()%>/eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;

		xmlHttp.send(xmlDoc);

		responseText=xmlHttp.responseText;
		responseText = trimString(responseText);
		eval(responseText);
	}
	
// IN::39851
// GeneralPratitionerLookup. It's called by the GeneralPratitionerLookup. 
function PractLookupRetVal(retVal,objName)
{
	var arr;
	if (retVal != null)
	{
		arr=retVal.split("~");
		if(objName == "practitioner_name")
		{
			document.forms[0].practitioner_name.value=arr[1];
			document.forms[0].practitioner_id.value=arr[0];//59404
			
		}
	}
	else
	{
		document.forms[0].practitioner_name.value="";
		document.forms[0].practitioner_id.value="";//59404
	}
} // End of PractLookupRetVal()
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='workList' id='workList' target="workListResult">
	<table border="0" cellpadding="2" cellspacing="0" width="100%" align="center">
		<tr>
			<TD class="label" >
					<fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>
			</TD>
			<td>
				<select name="nursing_Unit" id="nursing_Unit" onChange="">
					<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
					<%
						try{
							String nursing_code = "";
							String nursing_desc = "";
							String sql_nursing_unit = "select nursing_Unit_Code, short_Desc from Ip_Nursing_Unit_Lang_Vw where language_Id = ? and eff_Status ='E' and facility_Id = ?  order by 2"; // for Pagignation
							pstmt = conn.prepareStatement(sql_nursing_unit) ;
							pstmt.setString(1,language_Id); // for Pagignation 
							pstmt.setString(2,facility_id); // for Pagignation
							rs	= pstmt.executeQuery();
							while(rs != null && rs.next()){
								nursing_code=rs.getString(1);
								nursing_desc=rs.getString(2);

					 %>
						<option value="<%=nursing_code%>">
							<%=nursing_desc%>
						</option>
					<%
						}
						}
						catch(Exception e){
							e.printStackTrace();
						}
						finally	{
                          if(rs !=null) rs.close();
						  if(pstmt != null) pstmt.close();
						  //if(conn != null)ConnectionManager.returnConnection(conn,request); // for Pagignation
						        }
					 %>
				</select>
				<img src='../../eCommon/images/mandatory.gif'></img>
			</td>
			<TD class="label">
					<fmt:message key="eOT.admDate.Label" bundle="${ot_labels}"/>
			</TD>
			<TD>
				<fmt:message key="Common.from.label" bundle="${common_labels}"/>
				<Input type="text"  name="dateFrom" id="dateFrom" size="10" maxlength="10"/>
				<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('dateFrom');">
				<fmt:message key="Common.to.label" bundle="${common_labels}"/>
				<Input type="text"  name="dateTo" id="dateTo" size="10" maxlength="10"/>
				<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('dateTo');">
			</TD>
		</tr>
		<tr>
		<%   String pat_id_length="";
					try{
					    pstmt = conn.prepareStatement("select patient_id_length from mp_param where MODULE_ID='MP'");
			            rs	=pstmt.executeQuery();
			            if (rs.next() && rs != null)
			             {
			 	          pat_id_length = rs.getString(1);
						  
						 }
						}catch(Exception e){
							e.printStackTrace();
						}
						finally	{
                          if(rs !=null) rs.close();
						  if(pstmt != null) pstmt.close();
					      if(conn != null)ConnectionManager.returnConnection(conn,request);
						        }
					 %>
			<td class="label" width="10%"><fmt:message key="Common.patientId.label"   bundle="${common_labels}"/></td>
			<td>
			<INPUT TYPE="TEXT"  name="patient_id" id="patient_id" SIZE="12" maxlength="<%=pat_id_length%>" VALUE='' onKeypress='return CheckForSpecChars(event);' onBlur="makeValidString(this);ChangeUpperCase(this);">
			<input type='button' class='button' name=search value='?' class=button tabIndex="4" onClick="callPatientSearch()">
			</td>

			<td  class="label"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
			<td>
			<input type="text" name="encounter_id" id="encounter_id" value="" size='12' maxlength='12' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur="CheckNumVal(this)"  >
			</td>
		</tr>
		<TR>
			<TD class="label" >
				<fmt:message key="eOT.practitioner.Label" bundle="${ot_labels}" />
			</TD>
			<TD>
				<!-- <input type="text" name="practitioner_name" id="practitioner_name" value="" onblur="onblurcheck(this,practitioner_name)"> -->
				<input type="text" name="practitioner_name" id="practitioner_name" value="" onblur="onblurcheck(this,practitioner_name)"> 
				<input type="button" name="click" id="click" value="?" onClick="callPractSearch(this,practitioner_name);" class="button"/>
				<input type="hidden" name="practitioner_id" id="practitioner_id" id="practitioner_id" value=""><!--59404-->
			</TD>
			<TD class="label" >
				<fmt:message key="Common.gender.label" bundle="${common_labels}" />
			</TD>
			<TD>
				<select name="sex" id="sex" onChange="">
					<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" /></option>
					<option value="M"><fmt:message key="Common.male.label" bundle="${common_labels}" /></option>
					<option value="F"><fmt:message key="Common.female.label" bundle="${common_labels}" /></option>
					<option value="U"><fmt:message key="Common.unknown.label" bundle="${common_labels}" /></option>
				</select>
			</TD>
		</TR>
		<!--MMS-CRF-006-->
		      <TR>
				<TD  class="label">
					<fmt:message key="eDS.SearchFor.Label" bundle="${ds_labels}"/>
					</TD>
					<TD>
					 <select name="SearchFor" id="SearchFor" id="SearchFor">
					    <option value="ALL"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" /></option>
		                <option value="RD"><fmt:message key="eDS.ReferredToDietician.Label" bundle="${ds_labels}"/>
						</option>
						<option value="CD"><fmt:message key="eDS.CurrentDietTypeModified.Label" bundle="${ds_labels}"/></option>
						<option value="FD"><fmt:message key="eDS.FutureDietTypeModified.Label" bundle="${ds_labels}"/></option>
						</select>
						</TD>
			<!--MMS-CRF-006-->
			<TD class="label" >
				<fmt:message key="Common.status.label" bundle="${common_labels}" />
			</TD>
			<TD>
				<select name="status" id="status" onChange="">
					<option value="ALL" selected><fmt:message key="Common.all.label" bundle="${common_labels}" /></option>
 					<!-- Added Against Start KDAH-CRF-0511 -->
					<%if(isReOrder==true){%>
					<option value="R"><fmt:message key="eDS.Reorder.Label" bundle="${ds_labels}" /></option> 
					<%}%>
					<!-- Added Against End KDAH-CRF-0511 -->
					<option value="A"><fmt:message key="eOT.OrderPlaced.Label" bundle="${ot_labels}" /></option>
					<option value="P"><fmt:message key="eOT.OrderPending.Label" bundle="${ot_labels}" /></option>
					<option value="M"><fmt:message key="eOT.OrderModified.Label" bundle="${ot_labels}" /></option>
				</select>
			</TD>
		</TR>	
		<!-- Added Against ML-MMOH-CRF-1123[IN067026]-US2-->	
		<TR>
		<%
		if(isAlaCarte==true){
		%>			
			<TD  class="label">
				<fmt:message key="eDS.placeOrderFor.Label" bundle="${ds_labels}"/>
			</td>
			<TD>
				<select name="alaCarte" id="alaCarte" id="alaCarte">
					<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
					<option value="AC"><fmt:message key="eDS.AlaCartePatient.Label" bundle="${ds_labels}" /></option>
					<option value="NAC"><fmt:message key="eDS.NonAlaCartePatient.Label" bundle="${ds_labels}" /></option>					
				</select>
				<img src='../../eCommon/images/mandatory.gif'></img>
			</TD>
		<%
		}
		%>
		<!-- Added Against ML-MMOH-CRF-1123[IN067026]-US2 -->
			<TD colspan="4" align="right">			
				<INPUT type="button" name="button1" id="button1" value="<fmt:message key="Common.search.label" bundle="${common_labels}" />" class="button" onClick="check()"/>
				<INPUT type="Reset" name="button2" id="button2" value="<fmt:message key="Common.clear.label" bundle="${common_labels}" />" class="button" onClick="reset()"/>
			</TD>
		</TR>

	</table>
	<input type="hidden" name="from" id="from" value="">
	<input type="hidden" name="to" id="to" value="">
	<input type="hidden" name="isAlaCarte" id="isAlaCarte" id ="isAlaCarte" value="<%=isAlaCarte%>"><!-- ML-MMOH-CRF-1123[IN067026]-US2 -->	
	</form>
</body>
</html>

