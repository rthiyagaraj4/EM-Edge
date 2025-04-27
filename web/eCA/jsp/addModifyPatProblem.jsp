<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"> 
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<script src='../../eCommon/js/common.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<script src='../js/PatProblem.js' language='javascript'></SCRIPT>
<script src='../js/DateValidation.js' language='javascript'></SCRIPT> 
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script src="../../eCommon/js/DateUtils.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
    String scheme_desc  ="";
    String scheme="";
	String flagAut="";
	String disAut="";
	String autAut="N";
	String disAutPract="";
	String disReviewPract ="";
	String sysdate		=	"";
	 Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");

	sysdate		=	com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
%>

<script>

var scheme=""

function ShowPractitioner()
{
	var target			= parent.addModifyPatProblem.document.forms[0].reviwedby;
	var locale=parent.addModifyPatProblem.document.forms[0].locale.value;
	var retVal			=  new String();

	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var search_desc			= "";
	var title				= getLabel("Common.practitioner.label","Common");

	var sql="SELECT practitioner_id,short_name  from am_practitioner_lang_Vw where eff_status=`E`  and language_id = `"+locale+"`";
	search_code="practitioner_id";
	search_desc="short_name";
	retVal=window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(title,"UTF-8")+"&dispDescFirst=dispDescFirst",arguments,features);
	var arr=new Array();
	
	if (retVal != null && retVal != '' && retVal != "null")
	{
		var retVal=unescape(retVal);
		arr=retVal.split("::");
		parent.addModifyPatProblem.document.forms[0].reviwedby.value=arr[0];
		parent.addModifyPatProblem.document.forms[0].reviwedbyid.value=arr[1];
		parent.addModifyPatProblem.document.forms[0].reviwedby.focus();
	}
}

async function AuthorizePract()
{
	var target			= parent.addModifyPatProblem.document.forms[0].authorizepract;
	var locale=parent.addModifyPatProblem.document.forms[0].locale.value;
	var retVal			=  new String();
	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var search_desc			= "";
	var title			= getLabel("Common.practitioner.label","Common");
	//var sql="SELECT practitioner_id,short_name from am_practitioner where eff_status=`E`";
	var sql="SELECT practitioner_id,short_name  from am_practitioner_lang_Vw where eff_status=`E`  and language_id = `"+locale+"`";
	
	search_code="practitioner_id";
	search_desc="short_name";
	retVal =await  window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(title,"UTF-8")+"&dispDescFirst=dispDescFirst",arguments,features);
	var arr=new Array();
	if (retVal != null && retVal != '' && retVal != "null")
	{
		var retVal=unescape(retVal);
		arr=retVal.split("::");
		parent.addModifyPatProblem.document.forms[0].authorizepract.value=arr[0];
		parent.addModifyPatProblem.document.forms[0].authorizepractid.value=arr[1];
		parent.addModifyPatProblem.document.forms[0].authorizepract.focus();
	}
}
async function showdetails(srl_no,Patient_Id)
{

	var dialogHeight= "13" ;
	var dialogWidth = "40" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
	var arguments   = "" ;
	retVal =await window.showModalDialog("../../eCA/jsp/PatProblemShowdetails.jsp?Patient_Id="+Patient_Id+"&srl_no="+srl_no,arguments,features);

}

async function show_window(scheme,scheme_desc)
{
	var s = document.PatProblem_form.scheme.value;
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
		var dialogHeight= "28" ;
		var dialogWidth = "83" ;
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
		var arguments   = "" ;
		retVal =await window.showModalDialog("../../eCA/html/eCISLUE.html",arguments,features);

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
		var dialogHeight= "27.22" ;
		var dialogWidth = "44" ;
		var status = "no";

		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		
		var cause_ind='';
		if(scheme=="2")
		 cause_ind=document.forms[0].cause_ind.value
		
		retVal =await  window.showModalDialog("PaintConsultationFrame.jsp?title="+scheme_desc+" Code List&p_diag_code="+s+"&p_diag_scheme_desc="+scheme_desc+"&Encounter_Id="+Encounter_Id+"&p_auth_yn="+p_auth_yn+"&cause_indicator=&Age=" + age + "&Sex=" + sex + "&Dob=" + dob+"&mode=DiagSearch",arguments,features);
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
	}
}

function check_enc(obj)
{
	if(obj.checked == true)
			document.forms[0].include_enc.value = "Y";
	else
			document.forms[0].include_enc.value = "N";
}
</script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
    Connection con          = null; 
	StringBuffer sqlStrBufr=new StringBuffer();
    //java.util.Properties p  =(java.util.Properties) session.getValue( "jdbc" );
//    SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy" ) ;
  //  String currentdate      = dateFormat.format(new java.util.Date()) ;

	String currentdate		=	"";
	currentdate				=	com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
    String facilityId       = checkForNull((String) session.getValue( "facility_id" ));
	String diag_code= "";
	String dup_diag_code="";
	String modal_yn				= checkForNull(request.getParameter("modal_yn"));
    String srl_no           = request.getParameter("srl_no");
    String Patient_Id       = checkForNull(request.getParameter("Patient_Id"));
	String patient_class    = checkForNull(request.getParameter("patient_class"));
	String called_from_ip   = checkForNull(request.getParameter("called_from_ip"));	
	String retVal_auth		=checkForNull(request.getParameter("retVal_auth"));
	String associate_codes  =checkForNull(request.getParameter("associate_codes"));
	
	String code_indicator   =checkForNull(request.getParameter("code_indicator"));

	String oper_num= checkForNull(request.getParameter("oper_num"));
	

	String encounter_clor	=checkForNull(request.getParameter("encounter_clor"));
	String age				= checkForNull(request.getParameter("Age"));	
	String dob				= checkForNull(request.getParameter("Dob"));	
	String sex				= checkForNull(request.getParameter("Sex"));
	
	if(called_from_ip == null || called_from_ip.equals("null") || called_from_ip.equals(""))called_from_ip="N";

	PreparedStatement pstmt		=null;
	PreparedStatement stmt		=null;
	PreparedStatement stmt_1    =null;
    ResultSet rs				=null;
    ResultSet rs_1				=null;

	String srl_no_from_table ="";
    String diag_desc="";
    String diag_long_desc="";
    String primary_yn="N";
    String primary_status="";
    String onset_date=currentdate;
    String close_date="";
    String problem_status ="";
    String dis="";
    String dis_add_associate="disabled";
	String from_ip_stage="";

	String reviewed_by_pract	  ="";     
	String reviewed_by_pract_name ="";     
	String authorized_yn          ="";

	String authorized_by_pract    ="";
	String authorized_by_pract_name  ="";

    String id[] ={"","B","W","S","C"};
    String val[]={"--"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+ "--",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Better.label","ca_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Worse.label","ca_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Same.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")};

    String select_val="";

    String read_only    ="";
    String read_onlycode    ="readonly";
    String data_state   ="insert";
    String db_date="";
   // String sql=" select diag_code_scheme scheme, decode(diag_code_scheme,'1','ICD10','2','ICD9-CM','5','READ') scheme_desc, to_char(trunc(sysdate),'dd/mm/yyyy') db_date,(select PRACTITIONER_NAME from am_practitioner where practitioner_id=?) Recorded_by_pract_name from mr_parameter ";

   String sql="select diag_code_scheme scheme, decode(diag_code_scheme,'1','ICD10','2','ICD9-CM','5','READ') scheme_desc, to_char(trunc(sysdate),'dd/mm/yyyy') db_date,AM_GET_DESC.AM_PRACTITIONER(?,?,'1') Recorded_by_pract_name from mr_parameter";
    String check_box_value="N";
    String cause_ind="";

    String diagstage = "";
    String diagstagecode = "";
    String problemremarks = "";
    String diagtype = "";
 
	String significant_status = "", significant_yn = "N";
    String sel1 = "", sel2 ="", sel3 = "";

    String spanval= "";
	
	String agey="";
	String agem="";
	String aged="";
	String accession_num = "",notifiable_yn="",visible="visibility:hidden",visibleexclamation="visibility:hidden";

    String Encounter_Id      = request.getParameter("Encounter_Id");

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
	// end
	if(called_from_ip.equals("Y"))
	{	
		Practitioner_Id      = request.getParameter("Practitioner_Id");
//		Practitioner		 = request.getParameter("practitioner_name");

	}
	else
	{
		Practitioner_Id   = (String) session.getValue("ca_practitioner_id");
		Practitioner = (String) session.getValue("practitioner_name");
	}	
	
	if(Practitioner==null || Practitioner.equals("null"))
		Practitioner="";
	
	String Locn_Code         = request.getParameter("Locn_Code");
    String Locn_Type         = request.getParameter("Locn_Type");
    String f_authorize_yn    = request.getParameter("f_authorize_yn");
    //String chk_status        =checkForNull(request.getParameter("problem_status"));
    String invoking_function         =checkForNull(request.getParameter("Function"));
    
	String context  = request.getParameter("P_context");
	if (patient_class.equals("OP") || patient_class.equals("EM")||patient_class.equals("XT"))
		context  = "OP_Q";
	else
		context  = "IP_Q";

    String stagedesc =checkForNull(request.getParameter("stage_desc"));
    String stagecode =checkForNull(request.getParameter("stage_code"));

	//added for notes
	String visit_adm_date =checkForNull(request.getParameter("visit_adm_date"));
	String episode_type =checkForNull(request.getParameter("episode_type"));
	//-------
    String logicalseqno =checkForNull(request.getParameter("Logical_Seq"));
    String diagtypeselected =checkForNull(request.getParameter("diag_type"));
    String remarksselected =checkForNull(request.getParameter("remarks"));
	String QueryString =checkForNull(request.getParameter("QueryString"));

	primary_yn		=	(request.getParameter("primary_yn")==null)?"N" : request.getParameter("primary_yn");
	significant_yn	=	(request.getParameter("significant_yn")==null)?"N" : request.getParameter("significant_yn");
	String sql_1=""; 

   

try
{
	con = ConnectionManager.getConnection(request);

		//added new by kishore on 5/30/2005
		if(modal_yn.equals("Y"))
		{
			read_only   = "readonly";
			dis_add_associate = "disabled";
			dis = "disabled";

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
		pstmt.setString(2,locale);
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
			read_only   = "readonly";

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
		//sql_1 = "Select srl_no,diag_code,diag_desc,primary_yn,to_char(onset_date,'dd/mm/yyyy') onset_date,to_char(close_date,'dd/mm/yyyy') close_date, problem_status, cause_indicator, ip_diag_stage, decode(ip_diag_stage,'I','Intermediate','A','Admission','D','Discharge') diag_stage_desc, problem_remarks, diag_type, significant_yn,accession_num,notifiable_yn,reviewed_by_pract, (select short_name from am_practitioner where practitioner_id=reviewed_by_pract) reviewed_by_pract_name, authorized_yn, authorized_by_pract, (select short_name from am_practitioner where practitioner_id = authorized_by_pract) authorized_by_pract_name ,recorded_by_pract, (select short_name from am_practitioner where practitioner_id=recorded_by_pract) recorded_by_pract_name,(select long_desc from mr_icd_code where diag_code=pr_problem.diag_code and rownum=1 ) long_desc from pr_problem where patient_id = ? and srl_no = ? " ;

		sql_1="Select srl_no,diag_code,diag_desc,primary_yn,to_char(onset_date,'dd/mm/yyyy') onset_date,to_char(close_date,'dd/mm/yyyy') close_date, problem_status, cause_indicator, ip_diag_stage, ip_diag_stage diag_stage_desc, problem_remarks, diag_type, significant_yn,accession_num,notifiable_yn,reviewed_by_pract, (select short_name from am_practitioner_lang_vw where practitioner_id=reviewed_by_pract and language_id = ?) reviewed_by_pract_name, authorized_yn, authorized_by_pract, (select short_name from am_practitioner_lang_vw where practitioner_id = authorized_by_pract and language_id = ?) authorized_by_pract_name ,recorded_by_pract, (select short_name from am_practitioner_lang_Vw where practitioner_id=recorded_by_pract and language_id = ?) recorded_by_pract_name ,(select long_desc from mr_icd_code where diag_code=pr_problem.diag_code and rownum=1 ) long_desc from pr_problem where patient_id = ? and srl_no = ? ";

		stmt_1 = con.prepareStatement(sql_1);
		stmt_1.setString(1,locale);
		stmt_1.setString(2,locale);
		stmt_1.setString(3,locale);
		stmt_1.setString(4,Patient_Id);

		stmt_1.setString(5,srl_no);
        rs_1 = stmt_1.executeQuery();

        if (rs_1.next())
        {
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
			onset_date		= com.ehis.util.DateUtils.convertDate(onset_date,"DMY","en",locale);
			close_date		= com.ehis.util.DateUtils.convertDate(close_date,"DMY","en",locale);
			if(diagstage.equals("I"))
				diagstage=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Intermediate.label","common_labels");
			if(diagstage.equals("A"))
				diagstage=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.admission.label","common_labels");
			if(diagstage.equals("D"))
			
			diagstage=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Discharge.label","common_labels");
			
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
			authorized_by_pract_name = rs_1.getString("authorized_by_pract_name")==null?"":rs_1.getString("authorized_by_pract_name");
			
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

	/*function validate_date1(from,to) {
		var fromarray;
		var toarray;
		var fromdate = from.value ;
		var todate = to.value ;
		if(fromdate.length > 0 && todate.length > 0 ) {
				fromarray = fromdate.split("/");
				toarray = todate.split("/");
				var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
				var todt = new Date(toarray[2],toarray[1],toarray[0]);
				if(Date.parse(todt) > Date.parse(fromdt)) 
				{
					var invaldt = getMessage("INVALID_CLOSE_DATE","CA") ;
					alert(invaldt);
					document.forms[0].close.value='';
					document.forms[0].close.focus();
				}
				else if(Date.parse(todt) <= Date.parse(fromdt)) return true;
		}
		return true;
	}*/

/*function DateCheck(from,to) {
   	var fromarray;
	var toarray;
	var fromdate = from.value ;
	var todate = to.value ;
	if(fromdate.length > 0 && todate.length > 0 ) {
			fromarray = fromdate.split("/");
			toarray = todate.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt   = new Date(toarray[2],toarray[1],toarray[0]);
			if(Date.parse(todt) > Date.parse(fromdt)) {
				var invaldt=getMessage("INVALID_ONSET_DATE","CA");
					alert(invaldt);
					document.forms[0].onset.value='';
					document.forms[0].onset.focus();

				}
			else if(Date.parse(todt) <= Date.parse(fromdt)) return true;
	}
return true;
}*/

function datechk(from,to,foc)
{
    DateValidation(from,to,foc,'DATE_GREATER_SYSDATE')
}

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
	if(function_name=="modify")
	{
		return false;
	}
	if(trimCheck(Obj.value)=="")
	{
		document.PatProblem_form.Description1.disabled = false;
		document.PatProblem_form.Description1.focus();
		return false;
	}
	else
	{
		document.PatProblem_form.Description1.disabled = true;
		document.PatProblem_form.Description1.value = '';
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


        htmlVal = "<html><body><form name='form1' id='form1' method='post' action='../../eCA/jsp/PatProblemVal.jsp'><input type='hidden' name='p_stage_code' id='p_stage_code' value='"+stagecode+"'><input type='hidden' name='p_diag_code' id='p_diag_code' value='"+p_diag_code+"'><input type='hidden' name='p_scheme' id='p_scheme' value='"+p_scheme+"'><input type='hidden' name='p_cause_indicator' id='p_cause_indicator' value='"+indicator+"'><input type='hidden' name='p_sensitive_yn' id='p_sensitive_yn' value='"+sensitive+"'><input type='hidden' name='authorizeButton' id='authorizeButton' value='"+authorizeButton+"'><input type='hidden' name='Sex' id='Sex' value='"+sex+"'><input type='hidden' name='Dob' id='Dob' value='"+dob+"'><input type='hidden' name= 'associate_codes' value='" + document.PatProblem_form.associate_codes.value + "'></form></body></html>";

		if(called_from_ip == "Y" ||modal_yn=="Y")
		{ //new check added on 5th may 2004
	        parent.msgframe0.document.body.insertAdjacentHTML('afterbegin',htmlVal);
		    parent.msgframe0.document.form1.submit();
		}
		else
		{
	        top.content.workAreaFrame.support.document.body.insertAdjacentHTML('afterbegin',htmlVal);
		    top.content.workAreaFrame.support.document.form1.submit();
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
			document.PatProblem_form.authorizepract.value=pract_name;
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
			parent.support.location.href="../../eCA/jsp/Authorize.jsp?stage_code=<%=stagecode%>&stage_desc=<%=stagedesc%>&Context=<%=context%>&Access_Type=E&Context=PatientQueue&Access_Data=SD&Patient_Id=<%=Patient_Id%>&Practitioner_Id=<%=Practitioner_Id%>&jsp_name=PatProblemQueryResult.jsp&Encounter_Id=<%=Encounter_Id%>&Patient_Type=C&Fn_Name=Ass&Clinic_Code=<%=Locn_Code%>&Location_Type=<%=Locn_Type%>&significant_yn=<%=significant_yn%>&patient_class=<%=patient_class%>&called_from_ip=<%=called_from_ip%>&QueryString=" + escape(QueryString) + "&Sex=<%=sex%>&Dob=<%=dob%>&code_indicator=" + code_indicator + "&associate_codes=" + escape(document.PatProblem_form.associate_codes.value)	;
			
		}
		else if (Obj.value == 'Normal Mode')
		{	
			
			parent.PatProblemQueryResult.location.href="../../eCA/jsp/PatProblemQueryResult.jsp?Encounter_Id=<%=Encounter_Id%>&Practitioner_Id=<%=Practitioner_Id%>&Locn_Code=<%=Locn_Code%>&Patient_Id=<%=Patient_Id%>&Locn_Type=<%=Locn_Type%>&f_authorize_yn=N&significant_yn=<%=significant_yn%>&patient_class=<%=patient_class%>&called_from_ip=<%=called_from_ip%>&Sex=<%=sex%>&Dob=<%=dob%>&code_indicator=" + code_indicator;
            parent.addModifyPatProblem.location.href="../../eCA/jsp/addModifyPatProblem.jsp?Logical_Seq=<%=logicalseqno%>&stage_code=<%=stagecode%>&stage_desc=<%=stagedesc%>&Encounter_Id=<%=Encounter_Id%>&Practitioner_Id=<%=Practitioner_Id%>&Locn_Code=<%=Locn_Code%>&Patient_Id=<%=Patient_Id%>&Locn_Type=<%=Locn_Type%>&f_authorize_yn=N&significant_yn=<%=significant_yn%>&P_context=<%=context%>&patient_class=<%=patient_class%>&called_from_ip=<%=called_from_ip%>&Sex=<%=sex%>&Dob=<%=dob%>&code_indicator=" + code_indicator;
			parent.PatProblemQueryTools.document.forms[0].authorize.value='Authorize Mode';
        }  
		
    }
function showLongDescription()
{
	var dialogHeight= "20" ;
    var dialogWidth = "23" ;
	var a = document.forms[0].LongDescription.value;
	
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no";
	window.showModalDialog("../../eCA/jsp/PatProblemDialogLongDesc.jsp?longDesc="+a,"",features);
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
	var dialogHeight		= "15" ;
	var dialogWidth			= "40" ;
	var features			= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	
	var scheme_desc= document.PatProblem_form.scheme_desc.value; 
	var Encounter_Id= document.PatProblem_form.Encounter_Id.value ;
	var p_auth_yn="N";
    var s = document.PatProblem_form.scheme.value;
	var age = document.PatProblem_form.age.value;
	var sex = document.PatProblem_form.sex.value;
	var dob = document.PatProblem_form.dob.value;
	
	//alert("sex "+sex+"dob"+dob+"age"+age);
//	var con = confirm("Do you want to associate codes to this diagnosis?\nPress OK to continue...");
//	if(con)
/***************************************************************************/
	//{
		var arguments			= "" ;
		//alert(" code_indicator "+code_indicator+" diag_code " +diag_desc);
		var qs1 = "code_indicator=" + code_indicator + "&diag_desc=" + diag_desc + "&title="+scheme_desc+" Code List&p_diag_code="+s+"&p_diag_scheme_desc="+scheme_desc+"&Encounter_Id="+Encounter_Id+"&p_auth_yn="+p_auth_yn+"&cause_indicator=&Age=" + age + "&Sex=" + sex + "&Dob=" + dob + "&p_scheme=" +  p_scheme +"&diag_code="+diag_code+"&associate_codes=" + associate_codes;
//		alert(qs1);
		retVal =await window.showModalDialog("../../eCA/jsp/AddAssociateCodeFrames.jsp?" + qs1,arguments,features);
		//alert(retVal);
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
	//alert('new');
	code_indicator = document.PatProblem_form.code_indicator.value;
	if(code_indicator == 'C')
			code_indicator = 'E';
	else
	if(code_indicator == 'D')
			code_indicator = 'A';
	
	diag_desc = document.PatProblem_form.Description1.value;
	p_scheme = '<%=scheme%>';
	associate_codes = document.PatProblem_form.associate_codes.value;
	//alert('associate_codes :'+associate_codes);
	diag_code = document.PatProblem_form.code.value;
	//alert(diag_code);
	
	var retVal				= "";
	//var dialogTop			= "0";
	var dialogHeight		= "15" ;
	var dialogWidth			= "40" ;
	var features			= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	
	var scheme_desc= document.PatProblem_form.scheme_desc.value; 
	var Encounter_Id= document.PatProblem_form.Encounter_Id.value ;
	var p_auth_yn="N";
    var s = document.PatProblem_form.scheme.value;
	var age = document.PatProblem_form.age.value;
	var sex = document.PatProblem_form.sex.value;
	var dob = document.PatProblem_form.dob.value;
	
	//alert("sex "+sex+"dob"+dob+"age"+age);
//	var con = confirm("Do you want to associate codes to this diagnosis?\nPress OK to continue...");
//	if(con)
	//{
		var arguments			= "" ;
		var qs1 = "code_indicator=" + code_indicator + "&diag_desc=" + diag_desc + "&title="+scheme_desc+" Code List&p_diag_code="+s+"&p_diag_scheme_desc="+scheme_desc+"&Encounter_Id="+Encounter_Id+"&p_auth_yn="+p_auth_yn+"&cause_indicator=&Age=" + age + "&Sex=" + sex + "&Dob=" + dob + "&p_scheme=" +  p_scheme +"&diag_code="+diag_code+"&associate_codes="+associate_codes;
//		alert(qs1);
		retVal =await window.showModalDialog("../../eCA/jsp/AddDaggerCodeFrames.jsp?" + qs1,arguments,features);
		//retVal = window.open("../../eCA/jsp/AddDaggerCodeFrames.jsp?" + qs1,arguments,features);
		
		if(retVal != null )
			document.PatProblem_form.associate_codes.value = retVal;
		/*else
			document.PatProblem_form.associate_codes.value = "";*/

		//return retVal;
	//}
}
</script>
<form name="PatProblem_form" id="PatProblem_form"  action="../../servlet/eCA.PatProblemServlet?patient_id=<%=Patient_Id%>&encounter_id=<%=Encounter_Id%>&practitioner_id=<%=Practitioner_Id%>&locn_code=<%=Locn_Code%>&locn_type=<%=Locn_Type%>&oper_num=<%=oper_num%>" method="post" target="messageFrame">
<div align='center'>
<table border='0' cellpadding='3' cellspacing='0' width="100%" align='center'>
<tr>
		<td class='columnheader' colspan='3'><fmt:message key="Common.ProblemAssessment.label" bundle="${common_labels}"/></td><td class='columnheader' id=disMar  colspan=3></td>
</tr>
<tr>
<%
	//String qry="select b.short_desc from ip_adt_trn a, ip_discharge_type b where a.facility_id = ? and a.encounter_id = ? and a.trn_type='D' and b.discharge_type_code=a.trn_code"; 

	String qry="select IP_GET_DESC.IP_DISCHARGE_TYPE(a.trn_code,?,'2') from ip_adt_trn a  where a.facility_id = ? and a.encounter_id = ? and a.trn_type='D' ";

	PreparedStatement stmt5 = null;
	ResultSet rs5 = null;

	try{
		stmt5 =	con.prepareStatement(qry);
		stmt5.setString(1, locale);
		stmt5.setString(2, facilityId);
		stmt5.setLong(3, Long.parseLong(Encounter_Id));

		rs5=stmt5.executeQuery();

	    if(context.equals("IP_Q"))
        {
            /*if(called_from_ip.equals("Y"))
			{
				stagecode="D";
				stagedesc="D";
			}*/
			if(data_state.equals("insert"))
            {
                if(!(stagecode.equals("") && stagedesc.equals(""))){
                    out.print("<td class='label' width='25%' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stage.label","common_labels")+"&nbsp;</td><td colspan=1><input type='text' width='25%' value='"+stagedesc+"' readonly size=15><img src='../../eCommon/images/mandatory.gif'></img><input type='hidden' name='diag_stage' id='diag_stage' value='"+stagecode+"'></td>");                                    
                }else{
                    out.print("<td class='label' width='25%' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stage.label","common_labels")+"&nbsp;</td><td colspan=1 width='25%'><select name='diag_stage' id='diag_stage'><option >&nbsp;----------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---------&nbsp;</option><option value='A' "+dsel1+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.admission.label","common_labels")+"</option><option value='I' "+dsel2+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Intermediate.label","common_labels")+"</option><option value='D' "+dsel3+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Discharge.label","common_labels")+"</option></select><img src='../../eCommon/images/mandatory.gif'></img></td>");
				}
            }
            else
			{
				/*if(diagstage.equals(""))

				{*/
				String diastgSel_1="";String diastgSel_2="";String diastgSel_3="";
				
				if(diagstagecode.equals("A"))
						diastgSel_1="selected";
				else if(diagstagecode.equals("I"))
						diastgSel_2="selected";
				else if(diagstagecode.equals("D"))
						diastgSel_3="selected";

				if(called_from_ip.equals("Y"))
				{
					diastgSel_1="";
					diastgSel_2="";
					diastgSel_3 ="selected";
					from_ip_stage="disabled";
					
				}

                    out.print("<td class='label' width='25%' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stage.label","common_labels")+"&nbsp;</td><td colspan=1><select name='diag_stage' id='diag_stage' "+from_ip_stage+"><option >&nbsp;----------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---------&nbsp;</option><option value='A' "+diastgSel_1+" >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.admission.label","common_labels")+"</option><option value='I' "+diastgSel_2+" >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Intermediate.label","common_labels")+"</option><option value='D' "+diastgSel_3+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Discharge.label","common_labels")+"</option></select><img src='../../eCommon/images/mandatory.gif'></img></td>");			
				/*}
				else
				{
					out.print("<td class='label' align=right>Stage&nbsp;</td><td colspan=1><input type='text' value='"+diagstage+"' readonly size=15>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img><input type='hidden' name='diag_stage' id='diag_stage' value='"+diagstagecode+"'></td>");        
				}*/
			}
			if(rs5.next())
			{
				out.print("<td colspan=1 class='label' width='25%' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.dischargetype.label","common_labels")+" :<b>"+rs5.getString(1)+"</b></td>"); 
			}
			else
				out.print("<td colspan=1 class='label' width='25%' >&nbsp;</td>"); 


        }
        else spanval = "5";
	}//end of try
	catch(Exception e){
		e.printStackTrace() ;
	}
	finally{
		if(rs5!=null) rs5.close();
		if(stmt5 != null) stmt5.close();
	}
%>
<td></td></tr><tr>	
<td  class=label width='25%'><fmt:message key="eCA.DiagType.label" bundle="${ca_labels}"/></td>
    <td class='feilds' width='25%'><select name="diag_type" id="diag_type"><option value=''>----- ----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- -----</option>
            <option value='P' <%=sel1%>><fmt:message key="Common.Provisional.label" bundle="${common_labels}"/></option>
            <option  value='D' <%=sel2%>><fmt:message key="Common.Differential.label" bundle="${common_labels}"/></option>
            <option  value='F' <%=sel3%>><fmt:message key="Common.final.label" bundle="${common_labels}"/></option>
        </select><img src='../../eCommon/images/mandatory.gif'></img>
	
</td>
	<%
			
			if(data_state.equals("modify") )
			{
   		   	visibleexclamation="visibility:visible";
			}
			else
	       {
             read_onlycode="";
		   }
			if(code_indicator == null || code_indicator.equals("null") || code_indicator.equals(""))
	        { 
				dis_add_associate = "disabled";
			}
			else
	       {
				dis_add_associate = "";
		   }

			
			%>
   <td></td><td></td>  </tr><tr>
    <td  class='label' width='25%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
    <td class='fields' width='25%' nowrap>
		<input type="text"  name="code" id="code" value="<%=diag_code%>" size='10' maxlength='10' onblur='ChangeUpperCase(this);callDesc(this)' <%=read_onlycode%> onchange="document.PatProblem_form.associate_codes.value = '';">
		<img src='../../eCommon/images/mandatory.gif'></img>
		<input type="button" name="AddAssociateCodes" id="AddAssociateCodes" value = '<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.SupportingDiagCode.label","ca_labels")%>' onclick = "decider()"  class="button" <%=dis_add_associate%>>
	</td>
     <%
        if(scheme.equals("2"))
        {
            String sel="";
            %>
                <td class='label'  width='25%' ><fmt:message key="Common.CauseInd.label" bundle="${common_labels}"/></td>
                <td class='fields' width='25%'><select name='cause_ind' id='cause_ind' onchange="callDesc(code)"  <%=dis%>>
                                <option	 value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
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
            out.print("<td width='25%'>&nbsp;</td>");
        }
    %>
    <td width='25%' class='label' ><%=scheme_desc%>
    <input type="button" class='Button' name="search_button" id="search_button" title='Search' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>" onClick="document.forms[0].code.value='';show_window('<%=scheme%>')"  <%=dis%>>
    </td>
    </tr>

    <tr>
        <td class='label' width ='25%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
        <td  class='fields' width ='25%'><input type="text"  name="Description1" id="Description1" value="<%=diag_desc%>" size=40 readonly><input class="button" type="button" value="!" name = "exclamation" onclick = "javascript:showLongDescription();" style="<%=visibleexclamation%>" > 
        <input type="hidden"  name = "Description" value="<%=diag_desc%>">
        <input type="hidden"  name = "LongDescription" value="<%=diag_long_desc%>">
		</td>
		<td>
		 <input type="button" class='Button' name="ntf_button" id="ntf_button"  value="Record Notifiable Form" onClick="callNotifiableNotes()" style="<%= visible %>"  >
        </td> <td></td>

    </tr>

    <!--  added by chitra on 19/10/2001  -->
    <tr>
		    <td  class='label' width='25%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
            <td class='fields' width='25%'><textarea name="remarks" rows="3" cols="40" maxlength='2000' onKeyPress='checkMaxLimit(this,2000);'    onBlur="makeValidString(this)" ><%=problemremarks%></textarea></td>
	<%
		if(data_state.equals("modify") && encounter_clor.equals("N"))
		{
	%>		
			<td  class='label' width='25%' ><fmt:message key="Common.IncludeinCurrentEncounter.label" bundle="${common_labels}"/>
			<input type='checkbox' checked name='inc_encounter' id='inc_encounter' onClick="check_enc(this);"></td>
	<%
		}
		else
		{
	%>
		<td>&nbsp;</td>
	<%
		}
	%>
	<td>&nbsp;</td>
	</tr>
    <!--  added by chitra on 19/10/2001  ends -->

<!-- <tr>
<td colspan=5>
<table border=1 cellpadding='3' cellspacing='0' width="100%"> -->
	<tr> 
		<td  class="label" width='15%' ><fmt:message key="Common.RecordedBy.label" bundle="${common_labels}"/></td>
		<td class="fields"><input type='textbox' name='recordedby' id='recordedby' align='left' size='30' value='<%=java.net.URLDecoder.decode(Practitioner)%>' readOnly ></input><input type='hidden' name='recordedbyid' id='recordedbyid' value='<%=Practitioner_Id%>'></td>
		
		<td  class="label" width='15%'><fmt:message key="eCA.ReviewedBy.label" bundle="${ca_labels}"/></td>
		<td class="fields"><input type='textbox' name='reviwedby' id='reviwedby' align='left' size='15' value='<%=reviewed_by_pract_name%>' <%=disReviewPract%>></input>&nbsp;<input type='button' class='button' value='?' onclick='ShowPractitioner()' <%=disReviewPract%>><input type='hidden' name='reviwedbyid' id='reviwedbyid' value='<%=reviewed_by_pract%>'></input></td>
   </tr><tr>
		<td class='label'  width='15%'><fmt:message key="Common.Authorize.label" bundle="${common_labels}"/>&nbsp;
		<input type="checkbox"   value="<%=autAut%>" name="authorizeCheck" onclick="callAuthorize(this,'<%=Practitioner_Id%>','<%=Practitioner%>')"  <%=flagAut%> <%=disAut%>></td>

		<td class="fields"><input type='text' name='authorizepract' id='authorizepract' size='15' value="<%=authorized_by_pract_name%>" <%=disAutPract%>></input>&nbsp;<input type='button' class='button' value='?' onclick='AuthorizePract()' name='authorizepractbtn' id='authorizepractbtn'<%=disAutPract%>>
		<input type='hidden' name='authorizepractid' id='authorizepractid' value='<%=authorized_by_pract%>'></input></td> 


<!--</table> -->
</td>
<!-- <td colspan=5> <table border=1 width='100' cellpadding='3' align ='center'> 
	<tr> -->
    <td  class='label' width='20%'><fmt:message key="Common.primary.label" bundle="${common_labels}"/>&nbsp;
	<input type="checkbox" value="Y" name="primary" id="primary" onclick="change_chkbox(this)" <%=primary_status%> <%=read_only%> ></td>
    
    <td  class='fields'  width='20%'> <fmt:message key="Common.significant.label" bundle="${common_labels}"/>&nbsp;<input type="checkbox"   value="Y" name="significant" id="significant" onclick="callOnClickSignificant(this)" <%=significant_status%> <%=read_only%> ></td>
</tr><tr>

<%
    if (!data_state.equals("modify"))
    {
%>
	
		<td  class='label' width='25%'><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/>
			<input type='hidden' name='ServerDate' id='ServerDate' value='<%=onset_date%>'></td>
		<td width='25%'>	
			<input type='text' name='onset' id='onset' value='<%=onset_date%>' size='10' maxlength='10' readonly  Onblur='CheckDate(this);isVaidwithSysDate(this,"DMY","<%=locale%>");calci(b_age,"DMY","<%=locale%>",onset);calcage(this,ServerDate,onset)' ><input type='image' src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('onset');" ><img align='center'  src='../../eCommon/images/mandatory.gif'></td>
			<td width='25%' class='label' colspan=2 >	<fmt:message key="Common.from.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Last.label" bundle="${common_labels}"/> (
			<input type='hidden' name='onset_date' id='onset_date' value='<%=onset_date%>'>

			<input type="text" name="b_days" id="b_days" maxlength="2" size="2" value='<%=aged%>' 		onKeyPress='return(ChkNumberInput(this,event,0))'
		onBlur='CheckForNumber_L(this,onset);checkDays(this,onset);calci(this,"DMY","<%=locale%>",onset)'   tabIndex='4'>D&nbsp;

		<input type="text" name="b_months" id="b_months" maxlength="2" value='<%=agem%>' size="2" 
		onKeyPress='return(ChkNumberInput(this,event,0))'
		onBlur='CheckForNumber_L(this,onset);checkMonth(this,onset);calci(this,"DMY","<%=locale%>",onset)'   tabIndex='5'>M&nbsp;

		<input type="text" name="b_age" id="b_age" maxlength="3" size="3" value='<%=agey%>'    
		onKeyPress='return(ChkNumberInput(this,event,0))'
		onBlur='CheckForNumber_L(this,onset);calci(this,"DMY","<%=locale%>",onset)' tabIndex='6'>Y&nbsp;)
			
		
</td>
    </tr>
 <!--</table> -->
		
		</td>
<%  }  %>

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
    <input type="hidden"  name="code_indicator" id="code_indicator"     value="<%=code_indicator%>">z
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

    
<%
    if (data_state  == "modify")
    {
		%><!-- <td>&nbsp;</td> -->
		<td  class='label'  width='25%'><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type='text' name='onset' id='onset' value='<%=onset_date%>' size='10' maxlength='10' readonly></td>	
			<%
        out.println("<td  class='label'  > "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels")+"&nbsp;</td><td>");
    //    if(problem_status.equals("C"))
                close_date=""; //currentdate;
        out.println("<select name='problem_status' id='problem_status' onChange='return changeList(this)'>");
        for(int i=0; i<5; i++)
        {
          if(id[i].equals(problem_status))
			select_val="selected";
		  else
			select_val = "";
          out.print("<option value='"+id[i]+"' "+select_val+">"+val[i]+"</option>");
        }
        out.println("</select>");
        out.println("<img src='../../eCommon/images/mandatory.gif'align='center'>");
        out.println("</td></tr><tr><td  class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.CloseDate.label","ca_labels"));
    %><input type='hidden' name='ServerDate1' id='ServerDate1' value='<%=close_date%>'></td><td> <input type='text' name='close' id='close' value='<%=close_date%>' size='10' maxlength='10'  readonly Onblur='CheckDate(this);isBetweenCurrDate("<%=onset_date%>","<%=currentdate%>",this,"DMY","<%=locale%>");calcage(this,ServerDate1,close);calci1(b_age1,"DMY","<%=locale%>",close);' ><input type='image' id='img1' src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('close');" ><!-- <img align='center'  src='../../eCommon/images/mandatory.gif'> -->
		<input type='hidden' name='close_date' id='close_date' value='<%=close_date%>'> <!-- </td>  -->
		<!-- <td align='left'  colspan='1'  width='22%' nowrap class=label> --> <td class='label' colspan='2' >(&nbsp;<fmt:message key="Common.Before.label" bundle="${common_labels}"/>&nbsp;
		<input type="text" name="b_days1" id="b_days1" maxlength="2" size="2" value='<%=aged%>'  
	 	onKeyPress='return(ChkNumberInput(this,event,0))'
	    onBlur='CheckForNumber_L(this,close);checkDays(this,close);calci1(this,"DMY","<%=locale%>",close)'   tabIndex='6'>D&nbsp;	

		<input type="text" name="b_months1" id="b_months1" maxlength="2" value='<%=agem%>' size="2"    
	 	onKeyPress='return(ChkNumberInput(this,event,0))'
		onBlur='CheckForNumber_L(this,close);checkMonth(this,close);calci1(this,"DMY","<%=locale%>",close)'   tabIndex='5'>M&nbsp;
			
		<input type="text" name="b_age1" id="b_age1" maxlength="3" size="3" value='<%=agey%>'  
	 	onKeyPress='return(ChkNumberInput(this,event,0))'
		onBlur='CheckForNumber_L(this,close);calci1(this,"DMY","<%=locale%>",close)'   tabIndex='4'>Y&nbsp;)&nbsp;
		</td></tr>
    <%
        out.println("<input type='hidden'  name='close_date' id='close_date' value='"+close_date+"' ></td></tr>");
        }
%>
    </table>
</div>
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
<input type='hidden' name='modal_yn' id='modal_yn' value="<%=modal_yn%>">


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
<input type='hidden' name='sys_date' id='sys_date' value="<%=sysdate%>">

<%

}catch (Exception e)
{
    e.printStackTrace() ;
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
<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
<!--<input type=hidden name=currentdate value='<%=currentdate%>'>-->
</form>
</body>
</html>
<% if(data_state  == "modify"){ %>
	<script language=javascript>
		document.forms[0].b_days1.disabled=true;
		document.forms[0].	b_months1.disabled=true;
		document.forms[0].	b_age1.disabled=true;
		document.getElementById("img1").disabled=true;
		document.forms[0].	close.disabled=true;
	</script>
<%}%>


<% if (!dup_diag_code.equals("")){  // this is for populating records if the privilage is not there  %>
	<script language=javascript>	
			document.PatProblem_form.code.focus();
			document.PatProblem_form.remarks.focus();
	</script>
<% } %>
<%if(called_from_ip.equals("Y"))
{%>
<script>
	var practitioner = '<%=Practitioner%>';
	if(practitioner == '')
	{
		alert(getMessage("PERFORMED_NOT_BLANK","CA"));
		//alert('APP-CA0001 Practitioner cannot be empty.....'); // this was done to avoid null practitioner name when diagnosis is recorded for the patient... if the pratitioner is empty, the dialog is closed when called from IP module
		window.close();
	}
</script>
<%}

%>
<script>
if('<%=retVal_auth%>' == 'T' && ('<%=code_indicator%>' == 'C' || '<%=code_indicator%>' == 'D' ))
document.PatProblem_form.AddAssociateCodes.disabled=false;
</script>
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

