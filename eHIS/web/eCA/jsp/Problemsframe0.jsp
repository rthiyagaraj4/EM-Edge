<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"
contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
 
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	Connection			conn 	= null;
	PreparedStatement	stmt1	= null;
	PreparedStatement	pstmt1	= null;
	PreparedStatement	pstmt	= null;
	PreparedStatement	stmt	= null;
	ResultSet			rs1		= null;
	ResultSet			oRs		= null;
	ResultSet			rset	= null;
	ResultSet			rset1	= null;
	ResultSet			rs		= null;
	
	String patientid=request.getParameter("Patient_Id");
	//****added for PH function usage
	String P_function_id=request.getParameter("P_function_id");
	String P_no_of_items=request.getParameter("P_no_of_items");
	String P_option_type=request.getParameter("P_option_type");
	String dob =(request.getParameter("Dob")==null)?"":request.getParameter("Dob");
	String age =(request.getParameter("Age")==null)?"":request.getParameter("Age");
	String sex1 =(request.getParameter("Sex")==null)?"":request.getParameter("Sex");
	String Practitioner_Id =(request.getParameter("Practitioner_Id")==null)?"":request.getParameter("Practitioner_Id");
	String speciality_code =(request.getParameter("speciality_code")==null)?"":request.getParameter("speciality_code");
	//****
%>
<html>
<head>
<%

String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
// added by Arvind @ 03-12-08 
String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }

%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
		<script language='javascript' src='../../eCA/js/DateCheck.js' ></script>
		<script language="javascript" src="../../eCommon/js/dchk.js"></script>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script type="text/javascript" src="../../eCA/js/ProblemList.js"></script>
		<script language='javascript' src="../../eCommon/js/FieldFormatMethods.js"></script>

	<script language=javascript>
		
	//	function funSearch()
	//	{
	//		//parent.problemsframe1.funTest();
	//	}

	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<%
try{
		conn 	=	ConnectionManager.getConnection(request);
		String facilityId 	=	(String) session.getValue( "facility_id" ) ;
		String modal_yn=request.getParameter("modal_yn")==null?"N":request.getParameter("modal_yn");
		java.util.Properties p=(java.util.Properties) session.getValue( "jdbc" );
		String locale = (String) p.getProperty("LOCALE");
		String login_user=p.getProperty( "login_user" ) ;
		String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");

		if (encounter_id.equals("0"))
			encounter_id="";

		String context_value =request.getParameter("PQ"); //request.getParameter("Context");
		if (context_value==null) context_value="Y";
		String sql=" select diag_code_scheme scheme, decode(diag_code_scheme,'1','ICD10','2','ICD9-CM','5','READ') scheme_desc, to_char(trunc(sysdate),'dd/mm/yyyy') db_date from mr_parameter ";
		stmt = null;
		oRs  = null;
		String scheme = "";
		String scheme_desc="";
		String db_date = "";
        stmt = conn.prepareStatement(sql);
        oRs = stmt.executeQuery();
        
        if(oRs.next())
		{
            scheme      = oRs.getString("scheme");
            out.print("<script>scheme='"+scheme+"'</script>");
            scheme_desc = oRs.getString("scheme_desc");
            db_date     = oRs.getString("db_date");
        }
		// endshere
    
		String sql1 ="";

		//String set_flag="";
		int count=0;

		String P_patient_type="";
		String P_access_type="V";
		String P_access_data="SD";

		String term_set_id="";
		String term_set_desc="";

		if(context_value.equals("Y"))
				P_patient_type="O";
		else
				P_patient_type="C";

		//String sql="";
		
		rset=null;
try{

		if (context_value.equals("Y")){
			sql1= "Select '1' from mr_user_access_rights_vw where appl_user_id=? and access_type='V' and patient_type='C' and access_scope='SD' and facility_id=?";
		}else{
			sql1="Select '1' from mr_user_access_rights_vw where appl_user_id=? and access_type='V' and patient_type='O' and access_scope='SD' and facility_id=?";
		}

		stmt1 = conn.prepareStatement(sql1);
		stmt1.setString(1,login_user);
		stmt1.setString(2,facilityId);
		rs1 = stmt1.executeQuery();

		/*if (!(rs1.next()))
			set_flag="Y";
		else
			set_flag="N";*/
	}catch(Exception e){
		//out.println("Error"+e);//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
		}

	try{
			 StringBuffer strBuff_sql = new StringBuffer();
				
			strBuff_sql.append("select 'x' from mr_user_access_rights_vw where  FACILITY_ID   =?  and APPL_USER_ID=? and ACCESS_TYPE    ='V'  and access_scope='SD' and ");	
			   if(context_value.equals("Y")){
				   strBuff_sql.append(" PATIENT_TYPE='C' ");
			   }else{
				   strBuff_sql.append(" PATIENT_TYPE='O' ");
			   }
			strBuff_sql.append(" and exists(Select 'Y' from PR_DIAGNOSIS A,MR_TERM_CODE D WHERE D.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_CODE=A.TERM_CODE and patient_id=? and nvl(sensitive_yn,'N') ='Y' AND ROWNUM=1 ) ");
			pstmt=conn.prepareStatement(strBuff_sql.toString());
			pstmt.setString(1,facilityId);
			pstmt.setString(2,login_user);
			pstmt.setString(3,patientid);

		 rset = pstmt.executeQuery();
		 if (rset.next())
		 	count=1;
		  }

		 catch(Exception e){
			e.toString();
		 }		 
	%>


<script>
	var rb;
	var pr="N";
	var dt="";

	

	function callSenseProb(obj){
		   if(rb==null)	rb='A';
			if (document.radioform.senseprob.value=='Authorize Mode'){
				pr="Y";
				//alert('111...');
				authorised(obj);
			}else{
				pr="N";
				document.radioform.senseprob.value='Authorize Mode'
				//alert('2222...');
				callProbRadio();
			}
	}


	function callProbRadio(){
		//alert("document.radioform.code_set.value;="+document.radioform.code_set.value);
		if(rb=="A"){
			//alert('3333...');
			document.getElementById("x1").width="10%";
			document.getElementById("x").width="10%";
			document.getElementById("z").width="10%";
			document.getElementById("h").width="15%";
			//document.getElementById("h").innerText="";
			document.getElementById("h").innerText='Status'
			document.getElementById("h").style.visibility='visible'
			document.getElementById("a").width="40%";
			document.getElementById("c").width="9%";
			document.getElementById("th1").width="100%";
		}else{
			//alert('44444...');
//			document.getElementById("x1").width="5%";
			document.getElementById("x").width="5%";
			document.getElementById("z").width="5%";
			document.getElementById("a").width="40%"
			document.getElementById("c").width="13%"
			document.getElementById("h").width='15%'
			document.getElementById("h").innerText='Status'
			document.getElementById("h").style.visibility='visible'
			document.getElementById("th1").width='100%'
		}

		var orderBy =document.radioform.orderBy.value;
		var reOrder = document.radioform.reOrder.value;

			if("<%=modal_yn%>" == "Y"){
				parent.problemsdetails.location.href='ProblemsDetails.jsp?modal_yn=<%=modal_yn%>'
				parent.problemsassessments.location.href='ProblemsAssessment.jsp?modal_yn=<%=modal_yn%>'
				parent.problemsframe1.location.href="Problemsframe1.jsp?probstatus="+rb+"&pr="+pr+"&diag_type="+dt+"&Patient_Id=<%=patientid%>&P_function_id=<%=P_function_id%>&P_no_of_items=<%=P_no_of_items%>&P_option_type=<%=P_option_type%>&modal_yn=<%=modal_yn%>&orderBy="+orderBy+"&reOrder="+reOrder+"&term_set_id="+document.radioform.code_set.value;
			}else{
				top.content.workAreaFrame.problemsdetails.location.href='ProblemsDetails.jsp?modal_yn=<%=modal_yn%>'
				top.content.workAreaFrame.problemsassessments.location.href='ProblemsAssessment.jsp?modal_yn=<%=modal_yn%>'
				top.content.workAreaFrame.problemsframe1.location.href="Problemsframe1.jsp?probstatus="+rb+"&pr="+pr+"&diag_type="+dt+"&Patient_Id=<%=patientid%>&P_function_id=<%=P_function_id%>&P_no_of_items=<%=P_no_of_items%>&P_option_type=<%=P_option_type%>&modal_yn=<%=modal_yn%>&orderBy="+orderBy+"&reOrder="+reOrder+"&term_set_id="+document.radioform.code_set.value;
			}
	}

	function funSearch()
	{
		var problems_radio="";
		if (document.radioform.problems_radio[0].checked)
			problems_radio=document.radioform.problems_radio[0].value;
		else
			problems_radio=document.radioform.problems_radio[1].value;			

		var diag_type = "";
		var code = document.radioform.code.value;
		var from_date = document.radioform.txtFromDate.value;
		var to_date= document.radioform.txtToDate.value;
		var encounter_id = document.radioform.encounter_id.value;
		//if(encounter_id == null || encounter_id == '')
			//encounter_id = document.radioform.Encounter_Id.value;
		var orderBy =document.radioform.orderBy.value;
		var reOrder = document.radioform.reOrder.value;
		var term_set_id = document.radioform.code_set.value;
		if (!CheckDate(document.radioform.txtToDate,null))
			return false;

		if (!CheckDate(document.radioform.txtFromDate,null))
			return false;

		
		if("<%=modal_yn%>" == "Y")
		{
			parent.problemsdetails.location.href='ProblemsDetails.jsp?modal_yn=<%=modal_yn%>'
			parent.problemsassessments.location.href='ProblemsAssessment.jsp?modal_yn=<%=modal_yn%>'
			parent.problemsframe1.location.href="Problemsframe1.jsp?probstatus="+problems_radio+"&pr="+pr+"&diag_type="+diag_type+"&Patient_Id=<%=patientid%>&P_function_id=<%=P_function_id%>&P_no_of_items=<%=P_no_of_items%>&P_option_type=<%=P_option_type%>&modal_yn=<%=modal_yn%>&code="+code+"&from_date="+from_date+"&to_date="+to_date+"&orderBy="+orderBy+"&reOrder="+reOrder+"&encounter_id="+encounter_id+"&term_set_id="+term_set_id;
		}
		else
		{
			top.content.workAreaFrame.problemsdetails.location.href='ProblemsDetails.jsp?modal_yn=<%=modal_yn%>'
			top.content.workAreaFrame.problemsassessments.location.href='ProblemsAssessment.jsp?modal_yn=<%=modal_yn%>'
			top.content.workAreaFrame.problemsframe1.location.href="Problemsframe1.jsp?probstatus="+problems_radio+"&pr="+pr+"&diag_type="+diag_type+"&Patient_Id=<%=patientid%>&P_function_id=<%=P_function_id%>&P_no_of_items=<%=P_no_of_items%>&P_option_type=<%=P_option_type%>&modal_yn=<%=modal_yn%>&code="+code+"&from_date="+from_date+"&to_date="+to_date+"&orderBy="+orderBy+"&reOrder="+reOrder+"&encounter_id="+encounter_id+"&term_set_id="+term_set_id;
		}
	}
	
	function callProg(obj){
		rb = obj.value;
		callProbRadio()
	}

	function callProg2(obj){
			dt = obj.value;
			if("<%=modal_yn%>" == "Y"){
				parent.problemsdetails.location.href='ProblemsDetails.jsp?modal_yn=<%=modal_yn%>'
				parent.problemsassessments.location.href='ProblemsAssessment.jsp?modal_yn=<%=modal_yn%>'
				parent.problemsframe1.location.href="Problemsframe1.jsp?probstatus="+rb+"&pr="+pr+"&diag_type="+obj.value+"&Patient_Id=<%=patientid%>&P_function_id=<%=P_function_id%>&P_no_of_items=<%=P_no_of_items%>&P_option_type=<%=P_option_type%>&modal_yn=<%=modal_yn%>&term_set_id="+document.radioform.code_set.value;
			}else{
				top.content.workAreaFrame.problemsdetails.location.href='ProblemsDetails.jsp?modal_yn=<%=modal_yn%>'
				top.content.workAreaFrame.problemsassessments.location.href='ProblemsAssessment.jsp?modal_yn=<%=modal_yn%>'
				top.content.workAreaFrame.problemsframe1.location.href="Problemsframe1.jsp?probstatus="+rb+"&pr="+pr+"&diag_type="+obj.value+"&Patient_Id=<%=patientid%>&P_function_id=<%=P_function_id%>&P_no_of_items=<%=P_no_of_items%>&P_option_type=<%=P_option_type%>&term_set_id="+document.radioform.code_set.value;
			}
	}

			async function authorised(Obj)
			{
				if(document.forms[0].mode.value == 'normal')
				{
					pr = "Y";
					document.forms[0].mode.value = 'authorized';
					await show_window();
				}
				else if(document.forms[0].mode.value == 'authorized')
				{
					pr = "N";
					document.forms[0].mode.value = 'normal';
					funSearch();
					document.radioform.senseprob.value='Authorize Mode';
				}
			}

			async function show_window()
			{
				var val1 = '<%=P_access_type%>' ;
				var val2 = '<%=P_access_data%>' ;
				var val3 = '<%=P_patient_type%>' ;
				var val5=	 '<%=patientid%>'
				var val = val1+'/'+val2+'/'+val3+'/';
				var retVal = 	new String();
				var dialogHeight= "9" ;
				var dialogWidth	= "25" ;
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
				var arguments	= "" ;
				retVal = await window.showModalDialog("AuthorizeMRAccess.jsp?constr="+val,arguments,features);
				if(retVal == "T" )
				{
					funSearch();
					radioform.senseprob.value  ="Normal Mode";
				}
				else
				{
					pr = "N";
				}
			}

	function CheckForSpecCharsNoCaps(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_* ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return true ;
	}

</script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<%
			String sysdateSql="select to_char(sysdate,'dd/mm/yyyy') toDate from dual";
			String toDate="";	
			pstmt1 = conn.prepareStatement(sysdateSql);
			rset1 = pstmt1.executeQuery();
			if(rset1.next()){
					toDate=rset1.getString(1);
			}
	%>
<form name="radioform" id="radioform">
<table align=center border='0' width=100%  cellspacing='0' cellpadding='3'>
<tr>
	<th class='columnHeader'  colspan=6 align="left"><b><fmt:message key="Common.Problems.label" bundle="${common_labels}"/></b></th>
</tr>	
<tr>
		<td class=fields width='25%' colspan=2 >
		<input type="radio" name="problems_radio" id="problems_radio" class="label" value="A" onClick="" checked ><font size='1'><fmt:message key="eCA.ActiveOnly.label" bundle="${ca_labels}"/>&nbsp;
		<input type="radio" name="problems_radio" id="problems_radio" class="label" value="O" onClick="">
		<font size='1'>
		<fmt:message key="Common.all.label" bundle="${common_labels}"/>

</td>
<!-- <td colspan=1></td>
 -->	<td class=label width='25%' colspan=2><!--<fmt:message key="Common.type.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="diag_type" id="diag_type" onChange=""><option value=''>---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------
			<option value='P' ><fmt:message key="Common.Provisional.label" bundle="${common_labels}"/>
			<option  value='D' ><fmt:message key="Common.Differential.label" bundle="${common_labels}"/>
			<option  value='F' ><fmt:message key="Common.final.label" bundle="${common_labels}"/>
		</select> -->
</td> 

</tr>
	<tr>
		<td class = label  ><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		<td class = 'fields' colspan=2  >
		<select name="code_set" id="code_set"  onChange="enableCode(this);" ><option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
		
		<%
		String diagset_qry ="select a.term_set_id,term_set_desc from MR_TERM_SET a where eff_status = 'E' ";

		 try
		{
		  pstmt = conn.prepareStatement(diagset_qry);
		  rs = pstmt.executeQuery();
		  while(rs!=null && rs.next())
		  {
			term_set_id   =rs.getString(1);
			term_set_desc =rs.getString(2);
			out.println("<option value='"+term_set_id+"' >"+term_set_desc+"</option>");
							
		  }
		  if(rs!=null) 
			  rs.close();
		  if(pstmt!=null) 
			  pstmt.close();
		}//try 
		catch(Exception eg)
		{
		 //  out.println("Exception="+eg.toString());//COMMON-ICN-0181
			eg.printStackTrace();//COMMON-ICN-0181
		}


		%>
		
		</select>
		<input type="text" name="code" id="code" size=5 Onblur='show_desc(this)' readOnly><input type="button" class='Button' name="search_button" id="search_button" title='Search' value="?" onClick="show_window1('<%=scheme%>')" disabled > &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' name='code_desc' id='code_desc' size=25 readOnly></input></td>
		<td colspan=1></td>
	</tr>
	<tr>
		<td class=label width='25%'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		<td class = 'fields'  width='25%' colspan=1 ><input type="text" name="encounter_id" id="encounter_id" size=12 maxlength=12 value='<%=encounter_id%>' onKeyPress='return(ChkNumberInput(this,event,0))' ><input type="button" class='Button' name="encounter_search_button" id="encounter_search_button" title='Encounter Search' value="?" onClick="View_Encounter('<%=patientid%>','<%=encounter_id%>')"  ></td>
		<td  class=label width='25%' colspan=2><fmt:message key="Common.Period.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;
				<input type="text" name='txtFromDate' id='txtFromDate' value='' size=9 onBlur='CheckDate(this,null);doDateCheck(this,txtToDate, "<%=toDate%>","DMY","<%=locale%>");'><input type='image'  src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('txtFromDate');" > - 
				<input type="text" name="txtToDate" id="txtToDate" onBlur='CheckDate(this,null);doDateCheck(txtFromDate,this, "<%=toDate%>","DMY","<%=locale%>");' size=9><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('txtToDate');" > 		
		</td>

	</tr>
<%
	/*if( count>0)
	{ */
%>	<!--&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspSensitive 	Problem<inputtype="checkbox" name="senseprob"  value='N' align="right" onclick="callSenseProb(this)">-->
<!-- <tr>
	<td width='25%'></td><td width='25%'></td><td width='25%'></td>
	<td width='25%' >
	<input type='button' name='senseprob' id='senseprob'  value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorize.label","common_labels")%>' onclick="callSenseProb(this)" class='button'> -->
<%
	/*}
	else
	{*/
%>
	<tr>
	<td colspan=3>
<%	
	if( count>0)
	{
%>	
	<input type='button' name='senseprob' id='senseprob'  value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorize.label","common_labels")%>&nbsp;<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mode.label","common_labels")%>' onclick="authorised(this)" class='button'>
<%
	}
	else
		out.println("&nbsp;");
%>
	</td>
	<td width='25%' align='right'>
<%
	//}
%>
		<input type="button" class="button" name="btnSearch" id="btnSearch" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick="funSearch();"><input type="button" class="button" name="clearSearch" id="clearSearch" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onClick="Clear_All();">	
</td>
</tr>
<!--<tr>
<td colspan=8 width=100% >
<table align=left width=99% border=1 cellspacing='0' cellpadding='3' id='th1'>
<td class='columnHeadercenter' width="11%"  id='x1'><fmt:message key="Common.type.label" bundle="${common_labels}"/></td> 
<td class='columnHeadercenter' width="11%"  id='x'><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></td> 
<td class='columnHeadercenter' width="20%"  id='a'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
<td class='columnHeadercenter' width="10%"  id='a'><fmt:message key="eCA.RecordedDateAndTime.label" bundle="${ca_labels}"/></td>
<td class='columnHeadercenter' width="11%"  id='b'><fmt:message key="Common.Stage.label" bundle="${common_labels}"/></td>
<td class='columnHeadercenter' width="8%"  id='c'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
<td class='columnHeadercenter' width="11%"  id='d'><fmt:message key="Common.scheme.label" bundle="${common_labels}"/></td>
<td class='columnHeadercenter' width='7%' ID='h'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
<td class='columnHeadercenter'   id='z' width="11%"><fmt:message key="eCA.CloseDate.label" bundle="${ca_labels}"/></td>
<td class='columnHeadercenter'  id='sc' width="5%"><fmt:message key="eCA.SupportingDiagCode.label" bundle="${ca_labels}"/></td>

<%if(P_function_id.equals("PH")){%>
	<th class='columnHeader' width=7%  >&nbsp;&nbsp;&nbsp;</th>
<%}%>
</table>
</td>
</tr>-->
</table>

<!-- // added by Arvind @ 03-12-08  -->

<%  if(!imgUrl.equals("")){%>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>


				<!-- end here -->
		<input type="hidden" name="P_access_type" id="P_access_type" value=<%=P_access_type %> >
		<input type="hidden" name="P_access_data" id="P_access_data" value=<%=P_access_data %> >
		<input type="hidden" name="P_patient_type" id="P_patient_type" value=<%=P_patient_type %> >
		<input type="hidden" name="scheme" id="scheme" value="<%=scheme%>">
		<input type="hidden" name="scheme_desc" id="scheme_desc" value="<%=scheme_desc%>">
		<input type="hidden" name="db_date" id="db_date" value="<%=db_date%>">
		<input type=hidden name=orderBy value=''>
		<input type=hidden name=reOrder value=''>
		<input type='hidden' name='dob' id='dob'	value='<%=dob%>'>
		<input type='hidden' name='age' id='age'	value='<%=age%>'>
		<input type='hidden' name='sex1' id='sex1'	value='<%=sex1%>'>
		<input type='hidden' name='Practitioner_Id' id='Practitioner_Id'	value='<%=Practitioner_Id%>'>
		<input type='hidden' name='Encounter_Id' id='Encounter_Id'	value='<%=encounter_id%>'>
		<input type='hidden' name='speciality_code' id='speciality_code'	value='<%=speciality_code%>'>
		<input type='hidden' name='mode' id='mode' value='normal'>
</form>
</body>
</html>

<%
}catch(Exception e){
		//out.println(e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
}finally
{
	if(rs1!=null) rs1.close();
	if(oRs!=null) oRs.close();
	if(rset!=null) rset.close();
	if(rset1!=null) rset1.close();

	if(stmt1 !=null) stmt1.close();
	if(pstmt1 !=null) pstmt1.close();
	if(stmt !=null) stmt.close();	
	if(pstmt !=null) pstmt.close();	

	if(conn!=null) ConnectionManager.returnConnection(conn,request);
}
%>

