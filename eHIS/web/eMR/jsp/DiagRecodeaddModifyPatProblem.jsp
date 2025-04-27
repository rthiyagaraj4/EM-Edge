<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<html>
<head>
<%
 request.setCharacterEncoding("UTF-8");
 request= new XSSRequestWrapper(request);
 response.addHeader("X-XSS-Protection", "1; mode=block");
 response.addHeader("X-Content-Type-Options", "nosniff");

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"> 
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/common.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<!--<script src='../../eCommon/js/messages.js' language='javascript'></SCRIPT>-->
<script src='../js/DiagRecodePatProblem.js' language='javascript'></SCRIPT>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<!--<script src='../../eMR/js/DiagRecodeDatevalidation.js' language='javascript'></SCRIPT>
<script src='../../eMR/js/DiagRecodePathighrisk.js' language='javascript'></SCRIPT>-->
<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
    String scheme_desc  ="";
    String scheme="";
	String flagAut="";
	String disAut="";
	String autAut="N";
	String disAutPract="";
	String disReviewPract ="";
	String record_type ="";
	String diag_code_scheme ="";
	String calledFromDeathReg = checkForNull(request.getParameter("calledFromDeathReg"));
	if(calledFromDeathReg.equals("")) calledFromDeathReg = "N";

%>

<script>


function openPatientChart(Patient_Id)
{

	var dialogHeight= "13" ;
	var dialogWidth = "40" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
	var arguments   = "" ;
	retVal = window.open("../../eCA/jsp/OpenChartWrapper.jsp?Patient_Id="+document.forms[0].patient_id,arguments,features);
}


var scheme=""

async function showdetails(srl_no,Patient_Id)
{
	var dialogHeight= "13vh" ;
	var dialogWidth = "40vw" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
	var arguments   = "" ;
	retVal =await  window.showModalDialog("../../eMR/jsp/DiagRecodePatProblemShowdetails.jsp?Patient_Id="+Patient_Id+"&srl_no="+srl_no,arguments,features);

}


/*function show_window()
{
	var dob = document.RecDaignosis_form.dob.value;
	var age = document.RecDaignosis_form.age.value;
	var sex = document.RecDaignosis_form.sex.value;
	var searchtext = document.RecDaignosis_form.diagprob_code.value;
	var practitioner_id = document.RecDaignosis_form.Practitioner_Id.value;
	var term_set_id = document.RecDaignosis_form.code_set.value;
	var Encounter_Id = document.RecDaignosis_form.Encounter_Id.value;
	var speciality_code = document.RecDaignosis_form.speciality_code.value;

	var p_auth_yn = "N";
	var retVal =    new String();
	var dialogHeight= "27.22" ;
	var dialogWidth = "44" ;
	var status = "no";
	var arguments = "";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

	retVal = window.showModalDialog("TermCodeSearchMainFrame.jsp?speciality_code="+speciality_code+"&term_set_id="+term_set_id+"&practitioner_id="+practitioner_id+"&termsetid="+term_set_id+"&Dob="+dob+"&Age="+age+"&Sex="+sex+"&Encounter_Id="+Encounter_Id,arguments,features);

	if(retVal != null)
	{
		var arr = new Array();
		retcode = retVal.split("/");
		document.RecDaignosis_form.diagprob_code.value = retcode;
		document.RecDaignosis_form.diagprob_code.onblur();
	}
}*/


async function show_window(scheme,scheme_desc)
{
	var s = document.PatProblem_form.scheme.value;
	var practitioner_id = document.PatProblem_form.Practitioner_Id.value;
	scheme_desc= document.PatProblem_form.scheme_desc.value; 
	var Encounter_Id= document.PatProblem_form.Encounter_Id.value ;
	var  p_auth_yn="N";

	var age = document.PatProblem_form.age.value;
	var sex = document.PatProblem_form.sex.value;
	var dob = document.PatProblem_form.dob.value;

	if(parent.PatProblemQueryTools.document.forms[0].authorize!=null)
	{
	   if(parent.PatProblemQueryTools.document.forms[0].authorize.value=="Normal Mode")
				p_auth_yn='Y';
	}

	if (s == 5)
	{
		var retVal = "test Value";
		var dialogHeight= "28vh" ;
		var dialogWidth = "43vw" ;
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
		var arguments   = "" ;
		retVal = await window.showModalDialog("../../eCA/html/eCISLUE.html",arguments,features);

			var arr = new Array();
			arr = retVal.split("|");
			var stra = arr[0];
			var strc = arr[1];
			var strb = arr[2];

	document.PatProblem_form.code.value         = stra;
	document.PatProblem_form.Description1.value = strb;
	document.PatProblem_form.Description.value  = strb;
	document.PatProblem_form.term_id.value      = strc;

	}
	if (s == 1 || s == 2)
	{
		var retVal =    new String();
		var dialogHeight= "27.22vh" ;
		var dialogWidth = "44vw" ;
		var status = "no";

		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		
		var cause_ind='';
		if(scheme=="2")
		 cause_ind=document.forms[0].cause_ind.value
		
		//retVal = window.showModalDialog("PaintConsultationFrame.jsp?title="+scheme_desc+"Code List&p_diag_code="+s+"&p_diag_scheme_desc="+scheme_desc+"&Encounter_Id="+Encounter_Id+"&p_auth_yn="+p_auth_yn+"&cause_indicator=&Age="+age+"&Sex="+sex+"&Dob="+dob+"&practitioner_id="+practitioner_id+"&term_set_id="+scheme_desc+"&mode=DiagSearch",arguments,features);

		retVal =await window.showModalDialog("TermCodeSearchMainFrame.jsp?term_set_id="+scheme_desc+"&practitioner_id="+practitioner_id+"&termsetid="+scheme_desc+"&Dob="+dob+"&Age="+age+"&Sex="+sex+"&Encounter_Id="+Encounter_Id,arguments,features);

		
		if (!(retVal == null))
		{
			var retdata;
			if(scheme=="2")
			{
			 retdata=retVal.split("/") ;
			retVal=retdata[0];

			if(retdata[1]==document.forms[0].cause_ind.options[1].value)
					document.forms[0].cause_ind.options[1].selected=true;
			}
			document.PatProblem_form.code.value=retVal;
		}
			document.PatProblem_form.code.focus();
			document.PatProblem_form.remarks.focus();
			document.PatProblem_form.AddAssociateCodes.disabled=true;
	}

}

</script>

</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad="callDesc(document.forms[0].code)">
<BR><BR>
<%
    Connection con          = null; 
	StringBuffer sqlStrBufr=new StringBuffer();
    //java.util.Properties p  =(java.util.Properties) session.getValue( "jdbc" );
    SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy" ) ;
    String currentdate      = dateFormat.format(new java.util.Date()) ;
    String facilityId       = checkForNull((String) session.getValue( "facility_id" ));
	String Encounter_Id     = request.getParameter("Encounter_Id");	 
	String diag_code= "";
	String dup_diag_code="";
	String modal_yn			= checkForNull(request.getParameter("modal_yn"));
	String srl_no           = request.getParameter("srl_no");
    String Patient_Id       = checkForNull(request.getParameter("Patient_Id"));
	String patient_class    = checkForNull(request.getParameter("patient_class"));
	String called_from_ip   = checkForNull(request.getParameter("called_from_ip"));	
	String retVal_auth		=checkForNull(request.getParameter("retVal_auth"));
	String associate_codes  =checkForNull(request.getParameter("associate_codes"));
	String code_indicator   =checkForNull(request.getParameter("code_indicator"));

//	String oper_num= checkForNull(request.getParameter("oper_num"));
//	String patLineYN = checkForNull(request.getParameter("patLineYN"));	
//	String encounter_clor	=checkForNull(request.getParameter("encounter_clor"));
	String age				= checkForNull(request.getParameter("Age"));	
	String dob				= checkForNull(request.getParameter("Dob"));	
	String sex				= checkForNull(request.getParameter("Sex"));
	
	
	if(called_from_ip == null || called_from_ip.equals("null") || called_from_ip.equals(""))called_from_ip="N";

	PreparedStatement pstmt		=null;
	PreparedStatement stmt		=null;
	PreparedStatement stmt_1    =null;
    ResultSet rs				=null;
    ResultSet rs_1				=null;

	String srl_no_from_table	="";
//  String diag_code			="";
    String diag_desc			="";
    String diag_long_desc		="";
    String primary_yn			="N";
    String primary_status		="";
    String onset_date			=currentdate;
    String close_date			="";
    String problem_status		="";
    String dis					="disabled";
    String dis_add_associate	="disabled";
	String reviewed_by_pract	  ="";     
	String reviewed_by_pract_name ="";     
	String authorized_yn          ="";
	String authorized_by_pract    ="";	

//    String id[] ={"","B","W","S","C"};
//    String val[]={"-- Select --","Better","Worse","Same","Close"};
    
    String read_only    ="";
    String read_onlycode    ="readonly";
    String data_state   ="insert";
    String db_date="";
    String sql=" select diag_code_scheme scheme, decode(diag_code_scheme,'1','ICD10','2','ICD9-CM','5','READ') scheme_desc, to_char(trunc(sysdate),'dd/mm/yyyy') db_date,(select PRACTITIONER_NAME from am_practitioner where practitioner_id=?) Recorded_by_pract_name from mr_parameter ";
    String check_box_value="N";
    String cause_ind="";

    String diagstage = "";
    String diagstagecode = "";
    String problemremarks = "";
    String diagtype = "";
 
	String significant_status = "", significant_yn = "N";
    String sel1 = "", sel2 ="", sel3 = "";    
	
	String accession_num = "",notifiable_yn="",visible="visibility:hidden",visibleexclamation="visibility:hidden";

   if (Encounter_Id ==null||Encounter_Id.equals(""))
		Encounter_Id="0";
	
	String Practitioner_Id   = "";
	String Practitioner ="";

	// added for displaying values from the authorixed screen
	String dsel1="",dsel2="",dsel3="";
			diagstage=checkForNull(request.getParameter("diag_stage"));
			diag_code=checkForNull(request.getParameter("diag_code"));

			dup_diag_code=diag_code;
			diagtype=checkForNull(request.getParameter("diagtype"));
			if(diagtype.equals("P")) sel1 = "selected";
			else if(diagtype.equals("D")) sel2 = "selected";
			else if(diagtype.equals("F")) sel3 = "selected";
			
			if(!diagstage.equals("")) 
			{
				if(diagstage.equals("A"))
				{
					dsel1="selected";
				}
				else if(diagstage.equals("I"))
				{
					dsel2="selected";
				}
				else if(diagstage.equals("D"))
				{
					dsel3="selected";
				}
			}

	if( called_from_ip.equals("Y") || calledFromDeathReg.equals("Y") || modal_yn.equals("Y") )
	{	
		Practitioner_Id			= request.getParameter("Practitioner_Id");
//		Practitioner			= request.getParameter("practitioner_name");

	}
	else
	{
		Practitioner_Id			= (String) session.getValue("ca_practitioner_id");
		Practitioner			= (String) session.getValue("practitioner_name");
	}
	
	if(Practitioner==null || Practitioner.equals("null"))
		Practitioner="";

	String trn_srl_no			=checkForNull(request.getParameter("trn_srl_no"));
	String Locn_Code			= request.getParameter("Locn_Code");
    String Locn_Type			= request.getParameter("Locn_Type");
    String f_authorize_yn		= request.getParameter("f_authorize_yn");
    //String chk_status			=checkForNull(request.getParameter("problem_status"));
    String invoking_function    =checkForNull(request.getParameter("Function"));
    
	String context				= request.getParameter("P_context");
	if (patient_class.equals("OP") || patient_class.equals("EM")||patient_class.equals("XT"))
		context  = "OP_Q";
	else
		context  = "IP_Q";

    String stagedesc		=checkForNull(request.getParameter("stage_desc"));
    String stagecode		=checkForNull(request.getParameter("stage_code"));
	//added for notes
	String visit_adm_date	=checkForNull(request.getParameter("visit_adm_date"));
	String episode_type		=checkForNull(request.getParameter("episode_type"));
	//-------
    String logicalseqno		=checkForNull(request.getParameter("Logical_Seq"));
    String diagtypeselected =checkForNull(request.getParameter("diag_type"));
    String remarksselected	=checkForNull(request.getParameter("remarks"));
	String QueryString		=checkForNull(request.getParameter("QueryString"));


	primary_yn			=	(request.getParameter("primary_yn")==null)?"N" : request.getParameter("primary_yn");
	significant_yn		=	(request.getParameter("significant_yn")==null)?"N" : request.getParameter("significant_yn");
	String sql_1		="";    

try
{
	con = ConnectionManager.getConnection(request);

		//added new by kishore on 5/30/2005
		if(modal_yn.equals("Y"))
		{
			read_only   = "readonly";
			
			if(!calledFromDeathReg.equals("Y"))
				dis = "disabled";
				dis_add_associate = "disabled";

		if(sqlStrBufr.length() > 0) sqlStrBufr.delete(0,sqlStrBufr.length());
		sqlStrBufr.append("select srl_no from pr_problem_vw  where patient_id = ? and ");
		sqlStrBufr.append("diag_code=? and problem_status!='C' ");
		
		pstmt = con.prepareStatement( sqlStrBufr.toString() ) ;
		pstmt.setString( 1, Patient_Id) ;
		pstmt.setString( 2, diag_code) ;
		
		rs = pstmt.executeQuery() ;
		while(rs.next())
		{
			srl_no=rs.getString("SRL_NO");
		}
			if(srl_no== null)
			{
				//mode="modify";
				//diag_code ="";
				sel3 = "selected";
			}
		}	
		//ended here
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

        pstmt=con.prepareStatement(sql);
		pstmt.setString(1,Practitioner_Id);
        rs=pstmt.executeQuery();
        
        if(rs.next())
        {
            scheme      = rs.getString("scheme");
            out.print("<script>scheme='"+scheme+"'</script>");
            scheme_desc = rs.getString("scheme_desc");
            db_date     = rs.getString("db_date");
			Practitioner= rs.getString("Recorded_by_pract_name")==null?"":rs.getString("Recorded_by_pract_name");
        }
        else
             out.print("<script>scheme=''</script>");
		if(retVal_auth.equals("T"))
	{
			read_only   = "readonly";
			read_onlycode="";
			dis="";
	}

    if  (srl_no != null)
    {
		read_only   = "readonly";
        data_state = "modify";
        dis = "disabled";
        //dis_add_associate = "";
        if(code_indicator.equals(null) || code_indicator.equals("null") || code_indicator.equals("") ){
				//dis_add_associate = "disabled";
		}
		else{
			//dis_add_associate = "";
		}
		sql_1 = "Select RECORD_TYPE, DIAG_CODE_SCHEME, srl_no,diag_code,diag_desc,primary_yn,to_char(onset_date,'dd/mm/yyyy') onset_date,to_char(close_date,'dd/mm/yyyy') close_date, problem_status, cause_indicator, ip_diag_stage, decode(ip_diag_stage,'I','Intermediate','A','Admission','D','Discharge') diag_stage_desc, problem_remarks, diag_type, significant_yn,accession_num,notifiable_yn,reviewed_by_pract, (select short_name from am_practitioner where practitioner_id=reviewed_by_pract) reviewed_by_pract_name, authorized_yn, authorized_by_pract, recorded_by_pract, (select short_name from am_practitioner where practitioner_id=recorded_by_pract) recorded_by_pract_name,(select long_desc from mr_icd_code where diag_code=pr_problem.diag_code and rownum=1 ) long_desc from pr_problem where patient_id = ? and srl_no = ? " ;

		stmt_1 = con.prepareStatement(sql_1);
		stmt_1.setString(1,Patient_Id);

		stmt_1.setString(2,srl_no);
        rs_1 = stmt_1.executeQuery();

        if (rs_1.next())
        {
            diag_code_scheme = rs_1.getString("DIAG_CODE_SCHEME"); 
            record_type = rs_1.getString("RECORD_TYPE"); 
			srl_no_from_table=  rs_1.getString("srl_no");
            diag_code   =   rs_1.getString("diag_code");
            diag_desc   =   rs_1.getString("diag_desc");
            diag_long_desc   =   rs_1.getString("long_desc");
            primary_yn  =   rs_1.getString("primary_yn");
            onset_date  =   rs_1.getString("onset_date");
            close_date  =   rs_1.getString("close_date");
            problem_status= rs_1.getString("problem_status");
            cause_ind=rs_1.getString("cause_indicator");
            diagstage = rs_1.getString("diag_stage_desc")==null?"":rs_1.getString("diag_stage_desc");
            diagstagecode = rs_1.getString("ip_diag_stage")==null?"":rs_1.getString("ip_diag_stage");
            problemremarks = rs_1.getString("problem_remarks")==null?"":rs_1.getString("problem_remarks");
            diagtype = rs_1.getString("diag_type")==null?"":rs_1.getString("diag_type");
			significant_yn	=	rs_1.getString("significant_yn")==null?"N":rs_1.getString("significant_yn");
			if(diag_code==null) diag_code = "";
			
			// added code

			reviewed_by_pract	=rs_1.getString("reviewed_by_pract")==null?"":rs_1.getString("reviewed_by_pract");
			if(!reviewed_by_pract.equals(""))
				disReviewPract ="disabled";
			else
				disReviewPract ="";

			authorized_yn     =rs_1.getString("authorized_yn")==null?"":rs_1.getString("authorized_yn"); 
			if(authorized_yn.equals("Y")){
				autAut ="Y";
				disAut = "disabled";
				disAutPract ="disabled";
				flagAut ="checked";
			}
			else{
				autAut = "N";
				disAut = "";
				disAutPract ="disabled";
				flagAut ="";
			}

			authorized_by_pract =rs_1.getString("authorized_by_pract")==null?"":rs_1.getString("authorized_by_pract");
			reviewed_by_pract_name = rs_1.getString("reviewed_by_pract_name")==null?"":rs_1.getString("reviewed_by_pract_name");			
			accession_num = rs_1.getString("accession_num")==null?"":rs_1.getString("accession_num");
			notifiable_yn = rs_1.getString("notifiable_yn")==null?"":rs_1.getString("notifiable_yn");
			if(notifiable_yn.equals("Y"))
				visible = "visibility:visible";
            
            if(!(diagtypeselected.equals("") || diagtypeselected.equals("null")))
                diagtype = diagtypeselected;
            if(!(remarksselected.equals("") || remarksselected.equals("null")))
                    problemremarks = remarksselected;

            if(diagtype.equals("P")) sel1 = "selected";
            else if(diagtype.equals("D")) sel2 = "selected";
            else if(diagtype.equals("F")) sel3 = "selected";

            if(cause_ind==null) cause_ind="";

            if (close_date == null) close_date = "";

            if (problem_status.equals("A")) problem_status="";

        }
    }
        if(rs_1!=null)  rs_1.close();
		if(stmt_1!=null) stmt_1.close();
		if(primary_yn.equals("Y")) primary_status="checked";
		if(significant_yn.equals("Y")) significant_status=" checked ";


%>
<script>

function callDesc(Obj)
{	
	if(Obj.value == "")
	{
		document.PatProblem_form.LongDescription.value="";
		document.PatProblem_form.Description1.value="";
		document.PatProblem_form.Description.value="";		
	}
	if(makeValidString(Obj)==false)
	return false;

	var sex = document.PatProblem_form.sex.value;
	var dob = document.PatProblem_form.dob.value;

	var function_name =  document.forms[0].function_name.value;
	var called_from_ip =  document.forms[0].called_from_ip.value;
	var modal_yn = document.forms[0].modal_yn.value;
	//var code_set =  document.forms[0].code_set.value;
	



	if(function_name=="modify")
	{
		return false;
	}
	 var pq = document.PatProblem_form.scheme.value;
    var stagecode = document.PatProblem_form.stage_code.value;
    if (pq == 1 || pq == 2)
    {
        var p_diag_code = Obj.value;
        var indicator= "";
        if(scheme=='2')
            indicator = document.forms[0].cause_ind.value;
		
        var p_scheme  = <%=scheme%>;
        var sensitive='N';

		var authorizeButton=parent.PatProblemQueryTools.document.forms[0].authorizeButton.value;
        if(parent.PatProblemQueryTools.document.forms[0].authorize!=null)
        {
           if(parent.PatProblemQueryTools.document.forms[0].authorize.value=="Normal Mode")
                sensitive='Y';
        }

		
        htmlVal = "<html><body onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMR/jsp/DiagRecodePatProblemVal.jsp'><input type='hidden' name='p_stage_code' id='p_stage_code' value='"+stagecode+"'><input type='hidden' name='p_diag_code' id='p_diag_code' value='"+p_diag_code+"'><input type='hidden' name='p_scheme' id='p_scheme' value='"+p_scheme+"'><input type='hidden' name='p_cause_indicator' id='p_cause_indicator' value='"+indicator+"'><input type='hidden' name='p_sensitive_yn' id='p_sensitive_yn' value='"+sensitive+"'><input type='hidden' name='authorizeButton' id='authorizeButton' value='"+authorizeButton+"'><input type='hidden' name='Sex' id='Sex' value='"+sex+"'><input type='hidden' name='Dob' id='Dob' value='"+dob+"'><input type='hidden' name='code_set' id='code_set' value='ICD10'><input type='hidden' name= 'associate_codes' value='" + document.PatProblem_form.associate_codes.value + "'></form></body></html>";

		if(called_from_ip == "Y" || modal_yn == "Y" || '<%=calledFromDeathReg%>' == "Y")
		{ //new check added on 5th may 2004

			
			parent.messageFrame.document.write(htmlVal);
			parent.messageFrame.document.form1.submit();

			
	        //parent.msgframe0.document.body.insertAdjacentHTML('afterbegin',htmlVal);
		    //parent.msgframe0.document.form1.submit();
		}
		else
		{
	        //top.content.workAreaFrame.support.document.body.insertAdjacentHTML('afterbegin',htmlVal);
		    //top.content.workAreaFrame.support.document.form1.submit();
		}
    }

}

  function change_chkbox(Obj)
    {
        if (Obj.checked == true)
        {
            document.PatProblem_form.primary_yn.value="Y";
        }
        else if (Obj.checked == false)
                document.PatProblem_form.primary_yn.value="N";
    }
	
	function callOnClickSignificant(Obj)
    {
		if (Obj.checked == true)
			document.PatProblem_form.significant_yn.value="Y";
		else if (Obj.checked == false)
			document.PatProblem_form.significant_yn.value="N";
    }

	function callAuthorize(Obj,pract_id,pract_name){
		if (Obj.checked == true){
			document.PatProblem_form.authorizeCheck.value="Y";
			document.PatProblem_form.authorizepract.disabled=false;
			document.PatProblem_form.authorizepractbtn.disabled=false;
			document.PatProblem_form.authorizepract.value=decodeURIComponent(pract_name);
			document.PatProblem_form.authorizepractid.value=pract_id;
		}
		else if (Obj.checked == false){
			document.PatProblem_form.authorizeCheck.value="N";
			document.PatProblem_form.authorizepract.disabled=true;
			document.PatProblem_form.authorizepractbtn.disabled=true;
			document.PatProblem_form.authorizepract.value="";
			document.PatProblem_form.authorizepractid.value="";
		}

	}

	function chkAuthorize(Obj, code_indicator)
    {
		var QueryString= document.getElementById("QueryString").value;
		var called_from_ip =  parent.addModifyPatProblem.document.forms[0].called_from_ip.value;
		
		if (Obj.value == 'Authorize Mode')
		{
		
			parent.support.location.href="../../eMR/jsp/AuthorizeRecode.jsp?stage_code=<%=stagecode%>&stage_desc=<%=stagedesc%>&Context=<%=context%>&Access_Type=E&Context=PatientQueue&Access_Data=SD&Patient_Id=<%=Patient_Id%>&Practitioner_Id=<%=Practitioner_Id%>&jsp_name=DiagRecodePatProblemQueryResult.jsp&Encounter_Id=<%=Encounter_Id%>&Patient_Type=C&Fn_Name=Ass&Clinic_Code=<%=Locn_Code%>&Location_Type=<%=Locn_Type%>&significant_yn=<%=significant_yn%>&patient_class=<%=patient_class%>&called_from_ip=Y&QueryString=" + escape(QueryString) + "&Sex=<%=sex%>&Dob=<%=dob%>&code_indicator=" + code_indicator + "&associate_codes=" + escape(document.PatProblem_form.associate_codes.value)+"&practitioner_type=&modal_yn="+document.PatProblem_form.modal_yn.value;

		}
		else if (Obj.value == 'Normal Mode')
		{
			parent.PatProblemQueryResult.location.href="../../eMR/jsp/DiagRecodePatProblemQueryResult.jsp?Encounter_Id=<%=Encounter_Id%>&Practitioner_Id=<%=Practitioner_Id%>&Locn_Code=<%=Locn_Code%>&Patient_Id=<%=Patient_Id%>&Locn_Type=<%=Locn_Type%>&f_authorize_yn=N&significant_yn=<%=significant_yn%>&patient_class=<%=patient_class%>&called_from_ip=<%=called_from_ip%>&Sex=<%=sex%>&Dob=<%=dob%>&code_indicator=" + code_indicator;
                     
			//parent.addModifyPatProblem.location.href="../../eMR/jsp/DiagRecodeaddModifyPatProblem.jsp?Logical_Seq=<%=logicalseqno%>&stage_code=<%=stagecode%>&stage_desc=<%=stagedesc%>&Encounter_Id=<%=Encounter_Id%>&Practitioner_Id=<%=Practitioner_Id%>&Locn_Code=<%=Locn_Code%>&Patient_Id=<%=Patient_Id%>&Locn_Type=<%=Locn_Type%>&f_authorize_yn=N&significant_yn=<%=significant_yn%>&P_context=<%=context%>&patient_class=<%=patient_class%>&called_from_ip=<%=called_from_ip%>&Sex=<%=sex%>&Dob=<%=dob%>&code_indicator=" + code_indicator;

			parent.PatProblemQueryTools.document.forms[0].authorize.value='Authorize Mode';
		
        }
    }
async function showLongDescription()
{
	var dialogHeight= "20vh" ;
    var dialogWidth = "23vw" ;
	var a = document.forms[0].LongDescription.value;
	
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no";
	await window.showModalDialog("../../eMR/jsp/DiagRecodePatProblemDialogLongDesc.jsp?longDesc="+a,"",features);
}
function changeList(Obj)
{
    var obj_val = Obj.value;
    var diagtype = document.forms[0].diag_type.value;
    var remarks = document.forms[0].remarks.value;
	var significant_yn = document.forms[0].significant.value;
	var primary_yn		=	document.forms[0].primary.value;
	if(significant_yn.checked==true) significant_yn = "Y";
	else significant_yn = "N";

	if(primary_yn.checked==true) primary_yn = "Y";
	else primary_yn = "N";

	var dat=	document.getElementById("currentdate").value;

	if(document.getElementById("problem_status").value == ("C"))
	{	
		document.getElementById("close").readOnly = false ;

		document.forms[0].b_days1.disabled=false;
		document.forms[0].	b_months1.disabled=false;
		document.forms[0].	b_age1.disabled=false;
		document.getElementById("img1").disabled=false;
		document.forms[0].	close.disabled=false;

		document.getElementById("close").value=dat;
		document.getElementById("ServerDate1").value=dat;
		document.getElementById("close_date").value=dat;

	}else{

		document.getElementById("close").value='';
		document.getElementById("ServerDate1").value='';
		document.getElementById("close_date").value='';

		document.forms[0].b_days1.disabled='';
		document.forms[0].	b_months1.disabled='';
		document.forms[0].	b_age1.disabled='';

		document.forms[0].b_days1.disabled=true;
		document.forms[0].	b_months1.disabled=true;
		document.forms[0].	b_age1.disabled=true;
		document.getElementById("img1").disabled=true;
		document.forms[0].	close.disabled=true;

		document.getElementById("close").value = "" ;
		document.getElementById("close").readOnly = true ;
	}

}
function decider()
{
	
	code_indicator = document.PatProblem_form.code_indicator.value;
	
	if(code_indicator == 'C')
		addAssociateCodes();
	else if(code_indicator == 'D')
		addAssociateCodes1();
}
async function addAssociateCodes()
{
	
	code_indicator = document.PatProblem_form.code_indicator.value;
	if(code_indicator == 'C')
			code_indicator = 'E';
	else
	if(code_indicator == 'D')
			code_indicator = 'A';
	
	diag_desc = document.PatProblem_form.Description1.value;
	p_scheme = '<%=scheme%>';
	associate_codes = document.PatProblem_form.associate_codes.value;
	diag_code = document.PatProblem_form.code.value;
	
	var retVal				= "";
	//var dialogHeight		= "15" ;
	//modified on 10-06-08 for ICN NO 4284
	var dialogHeight		= "20" ;
	var dialogWidth			= "40" ;
	var features			= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	
	var scheme_desc= document.PatProblem_form.scheme_desc.value; 
	var Encounter_Id= document.PatProblem_form.Encounter_Id.value ;
	var p_auth_yn="N";
    var s = document.PatProblem_form.scheme.value;
	var age = document.PatProblem_form.age.value;
	var sex = document.PatProblem_form.sex.value;
	var dob = document.PatProblem_form.dob.value;
	var patient_id = document.PatProblem_form.patient_id.value;

	
//	var con = confirm("Do you want to associate codes to this diagnosis?\nPress OK to continue...");
//	if(con)
/***************************************************************************/
	//{
		var arguments			= "" ;
		//var qs1 = "code_indicator=" + code_indicator + "&diag_desc=" + diag_desc + "&title="+scheme_desc+" Code List&p_diag_code="+s+"&p_diag_scheme_desc="+scheme_desc+"&Encounter_Id="+Encounter_Id+"&p_auth_yn="+p_auth_yn+"&cause_indicator=&Age=" + age + "&Sex=" + sex + "&Dob=" + dob + "&p_scheme=" +  p_scheme +"&diag_code="+diag_code+"&associate_codes=" + associate_codes;

		//retVal = window.showModalDialog("../../eCA/jsp/AddAssociateCodeFrames.jsp?" + qs1,arguments,features);


		var qs1 = 'diag_code='+diag_code+'&diag_desc='+diag_desc+'&associate_codes='+associate_codes+'&term_set_id='+scheme_desc+'&Dob='+dob+'&Age='+age+'&Sex='+sex+'&Patient_Id='+patient_id+'&term_code='+diag_code+'&occur_srl_no=';		

		retVal = await window.showModalDialog("../../eMR/jsp/AddAssociateCodeFrames.jsp?" + qs1,arguments,features);

		if(retVal != null)
			document.PatProblem_form.associate_codes.value = retVal;
		/*else
			document.PatProblem_form.associate_codes.value = "";*/
		//return retVal;
	//}
/***************************************************************************/
}
async function addAssociateCodes1()
{
	var code_indicator = document.PatProblem_form.code_indicator.value;
	if(code_indicator == 'C')
			code_indicator = 'E';
	else
		if(code_indicator == 'D')
			code_indicator = 'A';
	
	var diag_desc = document.PatProblem_form.Description1.value;
	var p_scheme = '<%=scheme%>';
	var associate_codes = document.PatProblem_form.associate_codes.value;
	var diag_code = document.PatProblem_form.code.value;
	
	var retVal				= "";
	//var dialogTop			= "0";
	var dialogHeight		= "15vh" ;
	var dialogWidth			= "40vw" ;
	var features			= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	
	var scheme_desc= document.PatProblem_form.scheme_desc.value; 
	var Encounter_Id= document.PatProblem_form.Encounter_Id.value ;
	var p_auth_yn="N";
    var s = document.PatProblem_form.scheme.value;
	var age = document.PatProblem_form.age.value;
	var sex = document.PatProblem_form.sex.value;
	var dob = document.PatProblem_form.dob.value;
	var patient_id = document.PatProblem_form.patient_id.value;
	
	
//	var con = confirm("Do you want to associate codes to this diagnosis?\nPress OK to continue...");
//	if(con)
	//{
		var arguments			= "" ;
		//var qs1 = "code_indicator=" + code_indicator + "&diag_desc=" + diag_desc + "&title="+scheme_desc+" Code List&p_diag_code="+s+"&p_diag_scheme_desc="+scheme_desc+"&Encounter_Id="+Encounter_Id+"&p_auth_yn="+p_auth_yn+"&cause_indicator=&Age=" + age + "&Sex=" + sex + "&Dob=" + dob + "&p_scheme=" +  p_scheme +"&diag_code="+diag_code+"&associate_codes="+associate_codes;

	

		//retVal = window.showModalDialog("../../eCA/jsp/AddDaggerCodeFrames.jsp?" + qs1,arguments,features);
			
		var qs1 = 'diag_code='+diag_code+'&diag_desc='+diag_desc+'&associate_codes='+associate_codes+'&term_set_id='+scheme_desc+'&Dob='+dob+'&Age='+age+'&Sex='+sex+'&Patient_Id='+patient_id+'&term_code='+diag_code+'&occur_srl_no=';

		retVal = await window.showModalDialog("../../eMR/jsp/AddDaggerCodeFrames.jsp?" + qs1,arguments,features);
		if(retVal != null )
			document.PatProblem_form.associate_codes.value = retVal;
		/*else
			document.PatProblem_form.associate_codes.value = "";*/

		//return retVal;
	//}
}
</script>
<form name="PatProblem_form" id="PatProblem_form"  action="../../servlet/eMR.DiagnosisRecodeServlet?&encounter_id=
<%=Encounter_Id%>&facility_id=<%=facilityId%> " method="post" target="messageFrame">
 
<div align='center'>
<table border=0 cellpadding='3' cellspacing='0' width="90%">
<tr>		
	<th align='left' colspan='3'><fmt:message key="Common.ProblemAssessment.label" bundle="${common_labels}"/> &nbsp;</th><th id=disMar align=right colspan=3></th>
</tr>
<%
	if(code_indicator == null || code_indicator.equals("null") || code_indicator.equals(""))
	{ 
		dis_add_associate = "disabled";
	}
	else
	{
		dis_add_associate = "";
	}
%>
	<tr>
		<td   align="right" class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/>&nbsp;</td>
		<td><input type="text"  name="code" id="code" value="<%=diag_code%>" size='10' maxlength='10' onblur='ChangeUpperCase(this);callDesc(this)' <%=read_onlycode%> onchange="document.PatProblem_form.associate_codes.value = '';" >&nbsp;<img src='../../eCommon/images/mandatory.gif'></img><input type="button" name="AddAssociateCodes" id="AddAssociateCodes" value = '<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SupportingDiagnosis.label","common_labels")%>' onclick = "decider()"  <%=dis_add_associate%>  class="button"  id='AddCodesBtn'></td>
	<%
		if(scheme.equals("2"))
		{
			String sel="";
			%>
			<td class='label' nowrap><fmt:message key="Common.CauseIndicator.label" bundle="${common_labels}"/>&nbsp;</td>
			<td><select name='cause_ind' id='cause_ind' onchange="callDesc(code)"  <%=dis%>>
						<option	 value=''>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
							<%
								if(cause_ind.equals("E"))
									sel="selected";
							%>
						<option value='E' <%=sel%>><fmt:message key="Common.external.label" bundle="${common_labels}"/></option>
				</select>
			</td>
			<%
		}
		else
		{
			out.print("<td COLSPAN=2>&nbsp</td>");
		}
		%>
		<td  align="left" class='label'><%=scheme_desc%>&nbsp;<input type="button" class='Button' name="search_button" id="search_button" title='Search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>'  onClick="document.forms[0].code.value='';
		show_window('<%=scheme%>')" <%=dis%> ></td>
	</tr>
	<tr>
		<td align="right" class='label'><fmt:message key="Common.description.label" bundle="${common_labels}"/>&nbsp;</td>
		<td colspan=3><input type="text"  name="Description1" id="Description1" value="<%=diag_desc%>" size=50 readonly>&nbsp;&nbsp;&nbsp;<input class="button" type="button" value="!" name = "exclamation" onclick = "javascript:showLongDescription();" style="<%=visibleexclamation%>" ><input type="hidden"  name = "Description" value="<%=diag_desc%>"><input type="hidden"  name = "LongDescription" value="<%=diag_long_desc%>"></td>
		<td><input type="button" class='Button' name="ntf_button" id="ntf_button"  value="Record Notifiable Form" onClick="callNotifiableNotes()" style='display:none'><!-- <a onclick="openPatientChart()" >patient chart</a> --></td>
	</tr>
	<tr>
		<td align='right' class='label' valign='top'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/>&nbsp;</td>
		<td colspan='3' class='fields'><textarea name="remarks" rows="3" cols="60" maxlength='200' onKeyPress='checkMaxLimit(this,200);' onBlur="makeValidString(this);chkRemarkLength(this,200);" readonly ><%=problemremarks%></textarea></td>
		<td colspan=1></td>
	</tr>
</table>

<%
    if (scheme.equals("1") ||  scheme.equals("2"))
    {
%>

    <input type="hidden"  name="db_date" id="db_date"            value="<%=db_date%>">
    <input type="hidden"  name="diag_srl_no" id="diag_srl_no"        value="">
    <input type="hidden"  name="record_type" id="record_type"        value="">
    <input type="hidden"  name="cause_indicator" id="cause_indicator"    value="">
    <input type="hidden"  name="tab_list_no" id="tab_list_no"        value="">
    <input type="hidden"  name="analysis_code" id="analysis_code"      value="">
    <input type="hidden"  name="notifiable_yn" id="notifiable_yn"      value="">
    <input type="hidden"  name="sensitive_yn" id="sensitive_yn"       value="">
    <input type="hidden"  name="primary_yn" id="primary_yn"         value="<%=check_box_value%>" >
    <input type="hidden"  name="significant_yn" id="significant_yn"     value="<%=significant_yn%>" >
    <input type="hidden"  name="srl_no_from_table" id="srl_no_from_table"  value="<%=srl_no_from_table%>" >
    <input type="hidden"  name="term_id" id="term_id"            value="">
    <input type="hidden"  name="Sec_Hdg_Code" id="Sec_Hdg_Code"       value="">
    <input type="hidden"  name="associate_codes" id="associate_codes"    value="<%=java.net.URLEncoder.encode(associate_codes)%>">
    <input type="hidden"  name="code_indicator" id="code_indicator"     value="<%=code_indicator%>">
    <input type="hidden"  name="diag_code" id="diag_code"     value="<%=diag_code%>">
  <input type="hidden"  name="retVal_auth" id="retVal_auth"     value="<%=retVal_auth%>">

<%
    }
    else
    {
%>
    <input type="hidden"  name="db_date" id="db_date"            value="<%=db_date%>">
    <input type="hidden"  name="diag_srl_no" id="diag_srl_no"        value="">
    <input type="hidden"  name="record_type" id="record_type"        value="R">
    <input type="hidden"  name="cause_indicator" id="cause_indicator"    value="">
    <input type="hidden"  name="tab_list_no" id="tab_list_no"        value="">
    <input type="hidden"  name="analysis_code" id="analysis_code"      value="">
    <input type="hidden"  name="notifiable_yn" id="notifiable_yn"      value="N">
    <input type="hidden"  name="sensitive_yn" id="sensitive_yn"       value="N">
    <input type="hidden"  name="primary_yn" id="primary_yn"         value="<%=check_box_value%>" >
    <input type="hidden"  name="significant_yn" id="significant_yn"     value="<%=check_box_value%>" >
    <input type="hidden"  name="srl_no_from_table" id="srl_no_from_table"  value="<%=srl_no_from_table%>" >
    <input type="hidden"  name="term_id" id="term_id"            value="">
    <input type="hidden"  name="Sec_Hdg_Code" id="Sec_Hdg_Code"       value="">
	<input type="hidden"  name="code_indicator" id="code_indicator"     value="<%=code_indicator%>">
    <input type="hidden"  name="diag_code" id="diag_code"     value="<%=diag_code%>">
    <input type="hidden"  name="retVal_auth" id="retVal_auth"     value="<%=retVal_auth%>">
    <input type="hidden"  name="associate_codes" id="associate_codes"    value="<%=java.net.URLEncoder.encode(associate_codes)%>">

<%
    }
%>

</table>
</div>
<input type='hidden' name='text5' id='text5' value=''>
<input type='hidden' name='text6' id='text6' value=''>
<input type='hidden' name='text7' id='text7' value=''>
<input type='hidden' name='text8' id='text8' value=''>
<input type='hidden' name='text9' id='text9' value=''>
<input type="hidden"  name="Practitioner_Id" id="Practitioner_Id"  value="<%=Practitioner_Id%>" >
<input type='hidden'  name='scheme_desc' id='scheme_desc' value='<%=scheme_desc%>'></td></tr>
<input type='hidden' name='function' id='function' value='<%=data_state%>'>
<input type='hidden' name='facilityId' id='facilityId' value='<%=facilityId%>'>
<input type='hidden' name='function_name' id='function_name' value='<%=data_state%>'>
<input type='hidden' name='Invoking_Function' id='Invoking_Function' value='<%=invoking_function%>'>
<input type='hidden' name='currentdate' id='currentdate' value='<%=currentdate%>'>
<input type='hidden' name='current_date' id='current_date' value=''>
<input type='hidden' name='context' id='context' value='<%=context%>'>
<input type='hidden' name='stage_code' id='stage_code' value='<%=stagecode%>'>
<input type='hidden' name='stage_desc' id='stage_desc' value='<%=stagedesc%>'>
<input type='hidden' name='logical_seq_no' id='logical_seq_no' value='<%=logicalseqno%>'>
<input type='hidden' name='patient_class' id='patient_class' value='<%=patient_class%>'>
<input type='hidden' name='QueryString' id='QueryString' value="<%=QueryString%>">
<input type='hidden' name='called_from_ip' id='called_from_ip' value="<%=called_from_ip%>">
<input type='hidden' name='calledFromDeathReg' id='calledFromDeathReg' value="<%=calledFromDeathReg%>">
<input type='hidden' name='modal_yn' id='modal_yn' value="<%=modal_yn%>">
<input type='hidden' name='diag_code_scheme' id='diag_code_scheme' value="<%=diag_code_scheme%>">
<input type='hidden' name='record_type' id='record_type' value="<%=record_type%>">
<input type='hidden' name='cause_ind' id='cause_ind' value="<%=cause_ind%>">
<input type='hidden' name='age' id='age' value="<%=age%>">
<input type='hidden' name='sex' id='sex' value="<%=sex%>">
<input type='hidden' name='dob' id='dob' value="<%=dob%>">
<input type="hidden"  name="scheme" id="scheme"             value="<%=scheme%>">
<input type="hidden"  name="p_authorize" id="p_authorize"            value="<%=f_authorize_yn%>">

<!-- parameters for the notes function -->
<input type='hidden' name='patient_id' id='patient_id' value="<%=Patient_Id%>">
<input type='hidden' name='episode_id' id='episode_id' value="<%=Encounter_Id%>">
<input type='hidden' name='episode_type' id='episode_type' value="<%=episode_type%>">
<input type='hidden' name='visit_adm_date' id='visit_adm_date' value="<%=visit_adm_date%>">
<input type='hidden' name='accession_num' id='accession_num' value="<%=accession_num%>">
<input type='hidden' name='diagstage' id='diagstage' value="<%=diagstagecode%>">
<input type='hidden' name='diag_type' id='diag_type' value="<%=diagtype%>">

<%
    //out.print("x_problem_status "+problem_status);
}catch (Exception e)
{
    out.print("Exception in addModifyPatProblem.jsp:"+sql_1+""+e.toString());
}
finally{
    if(rs!=null) rs.close();
	if(stmt != null) stmt.close();
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
<input type="hidden" name="Encounter_Id" id="Encounter_Id" value="<%=Encounter_Id%>">
<input type="hidden" name="locn_code" id="locn_code" value="<%=Locn_Code%>">
<input type='hidden' name='help_function_id' id='help_function_id' value='RECORD_DIAGNOSIS'>
<input type=hidden name=errorRemarks value=''>
<input type="hidden" name='include_enc' id='include_enc' value='Y'></input>
<input type="hidden" name='fromFinalize' id='fromFinalize' value=''></input>
<input type='hidden' name='trn_srl_no' id='trn_srl_no' value='<%=trn_srl_no%>'>

<!-- <input type=hidden name=currentdate value='<%=currentdate%>'> -->
</form>
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
	}
%>

