<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.* ,javax.servlet.*,javax.servlet.http.*,webbeans.eCommon.*,org.json.simple.parser.JSONParser,org.json.simple.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	String function_id	= checkForNull(request.getParameter("function_id"),"");
	String action	= "approval";
	if("PAT_INACTIVE".equals(function_id)){
		action	= "inActive";
	}
%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	<Script language='javascript' src='../js/PatDispArchApproval.js'></Script> 
	<script language="JavaScript" src="../../eCommon/js/tableheaderscroll.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<script>


		window.onload=function(){
			parent.frames[0].document.getElementById("imgLoad").style.display= "none";
			parent.frames[0].document.getElementById("searchBtn").disabled=false;
			if(parent.frames[0].document.getElementById("dispApprBtn")!=null)
			parent.frames[0].document.getElementById("dispApprBtn").disabled=false;
			if(document.getElementById("patientList")!=null)			
				fxheaderInit('patientList',480);			
		};
		


	</script>
	<style>
		
    </style>
	</style>
</head>
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name="test_form" id="test_form" action="../../servlet/eMR.PatDispArchServlet" method="post" target="messageFrame"  >
<%
	Connection con = null;
	String patientIds	= "";
	String patientName	= "";
	String nationaIds	= "";
	String altIdsType	= "";
	String altIds		= "";
	String patLastEncSpe		= "";
	String patLastEncLoc		= "";
	String patLastEncDiscDate		= "";
	String patStatus		= "";
	String patAge		= "";
	/*String gender		= "";
	String dob			= "";*/
	String[] patientIdArr = null;	
	String[] patientNameArr  = null; 
	String[] nationaIdArr  = null;	
	String[] altIdsTypeArr  = null;	
	String[] altIdArr  = null;	
	String[] patLastEncSpeArr  = null;
	String[] patLastEncLocArr  = null;	
	String[] patLastEncDiscDateArr  = null;		
	String[] patStatusArr  = null;	
	String[] patAgeArr  = null;	
	/*String[] genderArr;	
	String[] dobArr;	*/
	int count	= 0;
	
	try	{
		con = ConnectionManager.getConnection(request);
		String locale			= (String)session.getAttribute("LOCALE");
		String arch_disp		= checkForNull(request.getParameter("arch_disp"),"0");
		String from_date		= checkForNull(request.getParameter("from_date"));
		String patient_id		= checkForNull(request.getParameter("PatientId"));
		JSONArray specialityJsonArr	= new JSONArray();
		String classValue = "" ;
		CallableStatement statement=null;


		statement=con.prepareCall("{call  MR_DISP_ARCH_PAT( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}" );
		int i =1;

		statement.setString( i++, arch_disp );
		statement.setString( i++, from_date );
		statement.registerOutParameter(i++,Types.CLOB);
		statement.registerOutParameter(i++,Types.CLOB);
		statement.registerOutParameter(i++,Types.CLOB);
		statement.registerOutParameter(i++,Types.CLOB);
		statement.registerOutParameter(i++,Types.CLOB);
		statement.registerOutParameter(i++,Types.CLOB);
		statement.registerOutParameter(i++,Types.CLOB);
		statement.registerOutParameter(i++,Types.CLOB);
		statement.setString(i++,patient_id);
		statement.registerOutParameter(i++,Types.CLOB);
		statement.registerOutParameter(i++,Types.CLOB);
		statement.registerOutParameter(i++,Types.CLOB);
		statement.registerOutParameter(i++,Types.CLOB);
		statement.registerOutParameter(i++,Types.CLOB);
		statement.execute() ;
		

		patientIds				= checkForNull(statement.getString(3));
		patientName				= checkForNull(statement.getString(4));
		/*dob				= statement.getString(5);
		gender			= statement.getString(6);*/
		nationaIds				= statement.getString(7);
		altIdsType				= statement.getString(8);
		altIds					= statement.getString(9);
		patStatus				= statement.getString(12);
		patAge					= statement.getString(13);
		patLastEncSpe			= statement.getString(14);
		patLastEncLoc			= statement.getString(15);
		patLastEncDiscDate		= statement.getString(16);

		if(!patientIds.equals("")){
			patientIdArr			= patientIds.split("\\^#~!"); 
			patientNameArr			= patientName.split("\\^#~!"); 
			nationaIdArr			= nationaIds.split("\\^#~!"); 
			altIdsTypeArr			= altIdsType.split("\\^#~!"); 
			altIdArr				= altIds.split("\\^#~!"); 
			patLastEncSpeArr		= patLastEncSpe.split("\\^#~!"); 
			patLastEncLocArr		= patLastEncLoc.split("\\^#~!"); 
			patLastEncDiscDateArr	= patLastEncDiscDate.split("\\^#~!"); 
			patStatusArr			= patStatus.split("\\^#~!"); 
			patAgeArr				= patAge.split("\\^#~!"); 
			/*genderArr		= gender.split("\\^#~!"); 
			dobArr			= dob.split("\\^#~!"); */

		/*System.err.println("patientIds==>"+patientIds);
		System.err.println("patientName==>"+patientName);
		System.err.println("nationaIds==>"+nationaIds);
		System.err.println("altIdsType==>"+altIdsType);
		System.err.println("altIds==>"+altIds);*/
			System.err.println("patientIdArr==>"+patientIdArr.length);
			System.err.println("patientNameArr==>"+patientNameArr.length);
			System.err.println("nationaIdArr==>"+nationaIdArr.length);
			System.err.println("altIdsTypeArr==>"+altIdsTypeArr.length);
			System.err.println("altIdArr==>"+altIdArr.length);
			System.err.println("patLastEncSpeArr==>"+patLastEncSpeArr.length);
			System.err.println("patLastEncLocArr==>"+patLastEncLocArr.length);
			System.err.println("patLastEncDiscDateArr==>"+patLastEncDiscDateArr.length);
			System.err.println("patStatusArr==>"+patStatusArr.length);
			System.err.println("patAgeArr==>"+patAgeArr.length);
		/*System.err.println("genderArr==>"+genderArr.length);
		System.err.println("dobArr==>"+dobArr.length);*/
		
		}
		
		if(statement !=null) statement.close();
		//if(!patientIds.equals("") && !patientName.equals("")) {
		if(patientIdArr!= null) {
		
%>
			
		
			<table  border='1' cellpadding='0' cellspacing='0'   width="99%" id="patientList" style="margin-left:3px;" >
				<tr>
					<th class="COLUMNHEADER" width="5%" nowrap><fmt:message key="Common.SlNo.label" bundle="${common_labels}"/></th>
					<th class="COLUMNHEADER" width="10%" nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
					<th class="COLUMNHEADER"  width="17%" nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
					<th class="COLUMNHEADER"  width="12%" nowrap><fmt:message key="Common.dischargedate.label" bundle="${common_labels}"/></th>
					<th class="COLUMNHEADER"  width="10%" nowrap><fmt:message key="Common.Specialty.label" bundle="${common_labels}"/></th>
					<th class="COLUMNHEADER"  width="10%" nowrap><fmt:message key="Common.age.label" bundle="${common_labels}"/></th>
					<th class="COLUMNHEADER" width="11%"nowrap >
					<!--<fmt:message key="Common.National.label" bundle="${common_labels}"/> / <fmt:message key="Common.AlternateID.label" bundle="${common_labels}"/>-->
<fmt:message key="Common.NRICAltID.label" bundle="${common_labels}"/>
					</th>
					<th class="COLUMNHEADER"  width="10%" nowrap><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></th>
					<th class="COLUMNHEADER"  width="7%" nowrap><fmt:message key="Common.status.label" bundle="${common_labels}"/></th>
					<th class="COLUMNHEADER"width="7%" nowrap><fmt:message key="Common.selectall.label" bundle="${common_labels}"/><input type= "checkbox" name="chkAll" id="chkAll" onclick="chkSelAll(this);"/></th>
				</tr>
				<%for(int j=0;j<patientIdArr.length;j++){
					if(!patientIdArr[j].equals("") && !patientNameArr[j].equals("")){
						
						
						
						String last_disch_date			= patLastEncDiscDateArr[j].equals("@")?"":patLastEncDiscDateArr[j];
						String last_enc_specaility	= patLastEncSpeArr[j].equals("@")?"":patLastEncSpeArr[j];
						
						String last_enc_pat_class		= patLastEncLocArr[j].equals("@")?"":patLastEncLocArr[j];
						String last_enc_pat_class_disp	= "";
						String specialityDesc			= "";
						last_enc_pat_class_disp	= last_enc_pat_class.equals("IP")?"Inpatient":last_enc_pat_class.equals("OP")?"Outpatient":last_enc_pat_class.equals("EM")?"Emergency":last_enc_pat_class.equals("DC")?"DayCare":"&nbsp;";
						if(!last_enc_specaility.equals("")){
							specialityDesc	= eMR.MRCommonBean.getSpecialityDesc(con,locale,last_enc_specaility);
						}
				%>
					
					<tr>
					<td  class="<%=classValue%>" width="5%"><%=j%></td>
					<td  class="<%=classValue%>" width="8%"><%=patientIdArr[j]%></td>

					<td  class="<%=classValue%>" style='width:17%;word-wrap: break-word; word-break: break-all;'><%=patientNameArr[j]%></td>
					<td  class="<%=classValue%>" width="12%"><%=last_disch_date%>&nbsp;</td>
					<td  class="<%=classValue%>" width="10%">&nbsp;<%=specialityDesc%></td>
					<td  class="<%=classValue%>" width="10%" nowrap>&nbsp;<%=patAgeArr[j]%></td>
					<td  class="<%=classValue%>" width="11%" >
						<%
							if(!nationaIdArr[j].equals("@")){
								out.println(nationaIdArr[j]);
							}else if(!altIdArr[j].equals("@")){
								out.println(altIdArr[j]);
							}else{
								out.println("&nbsp;");
							}
						%>
					
					</td>
					<td  class="<%=classValue%>" width="10%">&nbsp;<%=last_enc_pat_class_disp%></td>
					<td  class="<%=classValue%>" width="7%">&nbsp;
					<%
							if(!patStatusArr[j].equals("N")){
								out.println("Death");
							}
						%>
					</td>
					<td  class="<%=classValue%>" nowrap><input type="checkbox" name="chkApproval" id="chkApproval" value="<%=patientIdArr[j]%>" /> </td>
					</tr>
					<input type="hidden" name="last_disch_date_<%=patientIdArr[j]%>" id="last_disch_date_<%=patientIdArr[j]%>"  value ="<%=last_disch_date%>"/>
					<input type="hidden" name="last_enc_specaility_<%=patientIdArr[j]%>" id="last_enc_specaility_<%=patientIdArr[j]%>" value="<%=last_enc_specaility%>"/>
					<input type="hidden" name="last_enc_pat_class_<%=patientIdArr[j]%>" id="last_enc_pat_class_<%=patientIdArr[j]%>" value="<%=last_enc_pat_class%>" />
					<input type="hidden" name="pat_age_<%=patientIdArr[j]%>" id="pat_age_<%=patientIdArr[j]%>" value="<%=patAgeArr[j]%>" />
					<input type="hidden" name="pat_status_<%=patientIdArr[j]%>" id="pat_status_<%=patientIdArr[j]%>" value="<%=patStatusArr[j]%>" />
				<%
					}
				}%>

			</table>


			<%}else{%>
				<script>
					parent.frames[0].document.getElementById("imgLoad").style.display= "none";
					fnShowNoRecords();
				</script>
			<%}%>
			<input type="hidden" name="selectedPatientIds" id="selectedPatientIds"  />
			<input type="hidden" name="arch_disp" id="arch_disp" value="<%=arch_disp%>" />
			<input type="hidden" name="action" id="action" value="<%=action%>" />
			<input type="hidden" name="function_id" id="function_id" value="<%=function_id%>" /> 
	
</form>

</body>
</html>

<%

	} catch(Exception e) {
		e.printStackTrace();
		
		//out.println(e.getMessage());
		}
	
	finally {
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>

<%!	
	private String checkForNull(String inputString)	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

