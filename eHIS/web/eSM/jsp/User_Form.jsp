<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
  <head>
      	<%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<script language='javascript' src='../../eSM/js/User.js'></script>
	<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script>
   	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
   	<script src='../../eCommon/js/common.js' language='javascript'></script>
     <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
	    <script language='javascript' src='../../eCommon/js/DateUtils.js'> </script> 

 	<script>
	
// NOTE:if the user has javascript disabled this will not work.

function emailvalidate(email) {
   var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
   if(reg.test(email.value) == false) {
      alert('Invalid Email Address');
	  email.value='';
      return false;
   }
}

//Modified by Kamatchi S for ML-MMOH-CRF-1844.2 
function CheckForSpecCharsforID(event){

	var isSSOIntegrationAppl = document.forms[0].isSSOIntegrationAppl.value;

	if(isSSOIntegrationAppl == 'true'){
		var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_$#';
	}else{
		var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_';
	}

    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}

//Modified by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2
function checkSpecChar()
{
	appl_user_id = document.forms[0].appl_user_id.value;
	firstChar = appl_user_id.charAt(0);

	var isSSOIntegrationAppl = document.forms[0].isSSOIntegrationAppl.value;

	if(isSSOIntegrationAppl == 'true'){
		if(firstChar == "_" || firstChar == "$" || firstChar == "#"){
			alert(getMessage('ID_CANT_HAVE_SPEC_CHAR_FIRST','SM'));
			//document.forms[0].appl_user_id.focus();
			document.getElementById('appl_user_id').focus();
			return false;
		}
	}else{
		if(firstChar == "_"){
			alert(getMessage('ID_CANT_HAVE_UNDER_SCORE','SM'));
			//document.forms[0].appl_user_id.focus();
			document.getElementById('appl_user_id').focus();
			return false;
		}
	}
}

function validate_from_date(obj)
	{
		if(document.forms[0].function_name.value=="insert")
		{
			if(obj.value.length>0)
			if(validDateObj(obj,"DMY",localeName)){
			DateValidation(obj);
			}
		}
		else if(document.forms[0].function_name.value=="modify")
		{
			if(document.forms[0].old_eff_date_from.value=="")
			{
				if(obj.value.length>0)
				{
					if(validDateObj(obj,"DMY",localeName)){
					DateValidation(obj);
					}
				}
			}
			else
			{
				if(obj.value.length<=0)
				{
/*
Commented on 13 Apr by Sridhar as [ Effective From ] value is not a mandatory field...						alert(getMessage("FROM_DATE_CANNOT_BE_BLANK"));
					obj.select();
					obj.focus();
*/
				}
				else
				{
					if(validDateObj(obj,"DMY",localeName)){
					DateValidation(obj);
					}
				}
			}
		}
		datecopmare();
	}
var flag=1;
		function validate_to_date(obj)
		{
			if(document.forms[0].function_name.value=="insert")
		{
			if(obj.value.length>0)
			if(validDateObj(obj,"DMY",localeName)){
			DateValidation(obj);
			}
		}
			
			
			if(document.forms[0].function_name.value=="insert")
			{
				if(document.forms[0].eff_date_from1.value!="" && document.forms[0].eff_date_to1.value!="")
				{
					if(flag){
						datecopmare();
					}
				}
				else
				{
					if(obj.value.length<0)
					{
						validDateObj(obj,"DMY",localeName);
					}
				}
			}
			else if(document.forms[0].function_name.value=="modify")
			{
				
				if(document.forms[0].eff_date_from1.value=="")
				{
					if(obj.value.length>0)
					{
						
						if(validDateObj(obj,"DMY",localeName)){
						DateValidation(obj)/**/
						}
					}
				}
				else
				{
					
					if(obj.value.length>0){
							
					if(validDateObj(obj,"DMY",localeName)){
						if(DateValidation(obj)!=false)
						datecopmare();
					}
					}
					
					//alert(doDateCheck1(document.forms[0].eff_date_from,document.forms[0].eff_date_to));
					/*if(!doDateCheck1(document.forms[0].eff_date_from1,document.forms[0].eff_date_to1))
					{
						alert(getMessage('TO_DT_GR_EQ_FM_DT','SM'));
						obj.select();
						obj.focus();
					}*/
				}
			}
		}
function datecopmare(){
	   if(document.forms[0].eff_date_from1.value!="" && document.forms[0].eff_date_to1.value!=""){
			   if(!(isBefore(document.forms[0].eff_date_from1.value,document.forms[0].eff_date_to1.value,"DMY",localeName)))
		   {
									   alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
									   //document.forms[0].eff_date_to1.value='';
									   document.getElementById('eff_date_to1').value='';
										//document.forms[0].eff_date_to1.select();
										document.getElementById('eff_date_to1').select();
										//document.forms[0].eff_date_to1.focus();
											alert("3:"+document.getElementById('eff_date_to1'));
										document.getElementById('eff_date_to1').focus();

		}
			   

   }
}
		
			
function callpract(obj1,obj,target_id)
{
	if(obj.value == "")
	{obj.value="";
	target_id.value="";
	return ;
	}

  displayUser(obj1,obj,target_id)
}

			
			function DateValidation(obj){
				curdate = document.user_form.cur_date;
				
				var msg="";
				if(obj.name=="eff_date_from1")
				 msg = getMessage("FROM_DATE_LESS_SYSDATE","SM");
				if(obj.name=="eff_date_to1")
				msg = getMessage("TO_DATE_LESS_SYSDATE","SM");
				
				if(!(isAfterNow(obj.value,"DMY",localeName))) {
					flag=0;

					obj.focus();
					obj.select();
					alert(msg);
					return false;
				}
		}

		function doDateCheck1(from,to,messageFrame,val) 
		{
		var fromarray; var toarray;
		var fromdate = from.value ;
		var todate = to.value ;
		if(fromdate.length > 0 && todate.length > 0 ) 
		{
			fromarray = fromdate.split("/");
			toarray = todate.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt = new Date(toarray[2],toarray[1],toarray[0]);	
			if(Date.parse(todt) < Date.parse(fromdt)) 
			{
				{
				if(val=="1")  
				{
					to.select();

				to.focus();
				}
				else if(val=="2") 
				{
					from.select();

					from.focus();
				}
				else if(val=="3")
				{
					to.select();

					to.focus();
				}
				else if(val=="4")
				{
					to.select();

					to.focus();
				}
				
				return false;
			}
		}
		else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
	}	
return true;
}
/*function changeLabl()
{
	var roletype 		= document.user_form.role_type.value;
	if (roletype!='' || roletype!=null )
	{
		if(roletype=='O')
		{
			document.getElementById('typeLabl').innerText="Other Staff Type";
			document.getElementById('typeLablName').innerText="Other Staff Name";
		}else if(roletype.=='P'){
			document.getElementById('typeLabl').innerText="Practitioner Type";
			document.getElementById('typeLablName').innerText="Practitioner Name";
		}
	}
}*/
function clearName()
{
document.forms[0].pract_name.value='';
}
	function onSuccess(){
	//alert('success');
	}

//Added by Maheshwaran K for the Password Validation as on 11/07/2012
//Start
//This method is called by onblur from Password field
function chk_pass()
	{
	var chkpassvalue=document.forms[0].appl_user_password.value
	if(chkpassvalue!="")
	document.forms[0].password_value_Y.value="Y";
	}
//End	
</script>
		
<%
  request.setCharacterEncoding("UTF-8");
  String locale					= (String)session.getAttribute("LOCALE");
  String visibilityPract="hidden";
  String lang_id			="";
  String practName = request.getParameter("practName");
 	if(practName == null) practName="";
 	 String diffdate = "0";
   String redOnly = "";
   String appl_user_id="";
   String appl_user_name="";
   String appl_user_password="";
   String appl_pin_no="";
   String reporting_facility="";
   StringBuffer str1=new StringBuffer();
   String facilityid="";
   String facilityname="";
   String telephone="";
   String fax="";
   String email="";
   String cpassword="";
   String effdatefrom="";
   String effdateto="";
   String effstatus="";
   String codeTextAttribute="";
   String otherTextAttribute="";
   String checkBoxAttribute="";
   String eventFunctionForCase="";
   String dat="";
   String id="";
   String sel="";
   String resp_group_id="";
   String responsibility_group=""; //Added by Suji Keerthi for MMS-MD-SCF-0173
   String func_id="";
	String fnvalue="insert";
   String appl_pract_type="";
	String	appl_pract_name="";
	String	employee_no="";
	String FIRST_LOGIN_YN="N";
	String responsibility_grp="";
	String reports_home_dir="";

   boolean newUser=false;
   boolean isSplCharNotAllowApplYN=false; //Added by Suji Keerthi for MOHE-CRF-0113 US001
   
   //Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2
   boolean isSSOIntegrationAppl = false;
   String defpass_sso = "";

   // Added by sri
   String str12="";
   String str21="";
	//Added by Maheshwaran K for the Password Validation as on 11/07/2012
	//Start
	String ws_no="";
	//End
	String old_eff_date_from="";
	String old_eff_date_to="";
	String eff_date_from="";
	String eff_date_to="";
	String sql = "";
	String selP ="";
	String selO ="";
	String appluserlongname="";
	String appluserlongname1="";
	String active_dir_id="";
	String link_ad_user="";//Added by Kamatchi S for ML-MMOH-CRF-1844.2
	Connection conn=null;
	try{
	conn = ConnectionManager.getConnection(request);
	isSplCharNotAllowApplYN = eCommon.Common.CommonBean.isSiteSpecific(conn, "AM", "SPL_CHAR_NOT_ALLOWED"); //Added by Suji Keerthi for MOHE-CRF-0113 US001
	
	//Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2
	isSSOIntegrationAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "SM", "SSO_INTEGRATION");
	HashMap hashdata  = eCommon.Common.CommonBean.getSiteSpecificDetails(conn,"SM","SSO_INTEGRATION");
	defpass_sso = (String)hashdata.get("value1");

	java.sql.Statement stmt = null;
	java.sql.Statement stmt1=null;
	java.sql.Statement stmt2=null;
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	ResultSet rs=null;

	int countRec=0;

	
	String tel_no ="";
	String fax_no = "";
	String emailid = "";
	String func_role = "";
	String func_role_id = "";
	String pract_type = "";

	String P_flag = "N";

	String listDisable = "";
	String disableToFld = "";
	int count_am_practitioner = 0;
	//Maheshwaran added for the MMS-QH-CRF-0149
	//Start
	String ENFORCE_PASSWORD_POLICY_YN="";
	String CASE_SENSITIVE_PASSWORD_YN="";
	String ALLOWED_SPL_CHAR_IN_PASSWORD="";
	int PASSWORD_LENGTH_MIN=0;
	int PASSWORD_LENGTH_MAX=0;
	//End
	SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy" ) ;

try {
	
		String sqlforAM  = "";
		if(conn!= null)
		sqlforAM  = "select count(1) from all_tables where table_name='AM_PRACTITIONER'";
		stmt1 = conn.createStatement() ;
		rset = stmt1.executeQuery(sqlforAM) ;
		while(rset.next())
		{
			count_am_practitioner=rset.getInt(1);
		}			
	
	appl_user_id=request.getParameter("appl_user_id");

	if(appl_user_id==null){

		appl_user_id="";
		appl_user_name="";
		appl_user_password="";
        if(rset!=null)rset.close();
        if(stmt1!=null)stmt1.close();
		stmt = conn.createStatement();
		String sql_user="Select role from session_roles";
		rset=stmt.executeQuery(sql_user);
		
	
		
 		String sql1="select facility_id,facility_name from sm_facility_param where facility_type='F' order by facility_name";
		if(rset!=null)rset.close();
 		rset=stmt.executeQuery(sql1);
 		str1.append("<select name='rep_facility_id' id='rep_facility_id'><option value=''>--------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--------");
		while (rset.next()) {
		 facilityid=rset.getString("facility_id");
		 facilityname=rset.getString("facility_name");
		 str1.append("<option value='"+ facilityid+"'>"+facilityname);
		 }
		 str1.append("</select>");

		telephone="";
		appl_pin_no = "";
		fax="";
		email="";
		cpassword="";
		effdatefrom="";
		effdateto="";
		effstatus="E";
		codeTextAttribute="";
		otherTextAttribute="";
		checkBoxAttribute="CHECKED";
		newUser=true;
		  

	}

	else
		{
		if(stmt!=null)stmt.close();
		stmt = conn.createStatement();
		//Added by Maheshwaran K for the Password Validation as on 11/07/2012
		//"WS_NO" was added in the Query
		  sql = "select appl_user_id,language_id,appl_user_name,APP_PASSWORD.decrypt(appl_user_password) appl_user_password,employee_no, APP_PASSWORD.decrypt(pin_no) appl_pin_no,eff_date_from, trunc(sysdate)-trunc(eff_date_from) diffdate,eff_date_to ,ora_rsrc_group_id, eff_status, rep_facility_name facility_name, rep_facility_id, contact_tel_no, contact_fax_no , email_id,  FUNC_ROLE,resp_group_id,reports_home_dir, func_role_id, PRACT_TYPE, PRACTITIONER_NAME ,to_char(eff_date_from,'dd/mm/yyyy') eff_date_from1,to_char(eff_date_to,'dd/mm/yyyy') eff_date_to1 ,WS_NO,APPL_USER_LONG_NAME,ACTIVE_DIR_ID,FIRST_LOGIN_YN,LINK_AD_USER  from sm_appl_user_vw where  appl_user_id='"+appl_user_id+"'";
			 if(rset!=null)rset.close();
			rset = stmt.executeQuery(sql);
			if(rset!=null)
			rset.next();

			appl_user_id=rset.getString("appl_user_id");
			appl_user_name=rset.getString("appl_user_name");

			appl_user_password=rset.getString("appl_user_password");

			resp_group_id=rset.getString("ora_rsrc_group_id");
            lang_id=rset.getString("language_id")==null?"":rset.getString("language_id");
			employee_no=rset.getString("employee_no");

			tel_no = rset.getString("contact_tel_no");

			appl_pin_no = rset.getString("appl_pin_no");
			if(appl_pin_no == null) appl_pin_no = "";
			if (resp_group_id ==null   ) resp_group_id="";
			if (employee_no ==null) employee_no="";

			if(tel_no==null || tel_no.equals("") ||  tel_no.length() == 0)
				telephone="";
			else
				telephone=tel_no;

			fax_no = rset.getString("contact_fax_no");
			if(fax_no==null || fax_no.equals("") || fax_no.length() == 0)
				fax="";
			else
				fax=fax_no;

			emailid = rset.getString("email_id");
			if(emailid==null ||  emailid.equals("") || emailid.length() == 0)
				email="";
			else
				email=rset.getString("email_id");

			func_role = rset.getString("func_role");
		
 
			if(func_role==null ){
					P_flag = "N";
				}
			else{
				
					P_flag = "Y";
				}
		     if(func_role == null)
	            {
		          func_role="";
	            }
            if(!(func_role.equals("") || func_role == null ))	            
			{
				if(func_role.equals("P")){
					selP="selected";
					selO="";
				}else if(func_role.equals("O")){
					selP="";
					selO="selected";
				}else{
					selP="";
					selO="";
				}
			}
 		  
			func_role_id = rset.getString("func_role_id");
			if(func_role_id == null) func_role_id="";
			func_id = rset.getString("func_role_id");

			if(func_id == null) func_id="";
			


			pract_type=rset.getString("PRACT_TYPE");

			if(pract_type==null || pract_type.equals("") ){
					appl_pract_type = "";
			
				}
			else{
					/***************************/
					visibilityPract="visible";				
					appl_pract_type= pract_type;
					P_flag = "Y";
				}
			appl_pract_name=rset.getString("practitioner_name");

			if(appl_pract_name == null) appl_pract_name="";

			responsibility_grp=rset.getString("resp_group_id");

			if(responsibility_grp == null) responsibility_grp="";
            
			 //Below added by Suji Keerthi for MMS-MD-SCF-0173
			responsibility_group=rset.getString("resp_group_id");

			if(responsibility_group == null) responsibility_group="";
			 //Ended by Suji Keerthi for MMS-MD-SCF-0173
			
			reports_home_dir=rset.getString("reports_home_dir");

			if(reports_home_dir == null) reports_home_dir="";
			


			if(!(appl_pract_type.equals("") || appl_pract_type == null ))
				sel="SELECTED";
			else
				sel = "";
		  if ( rset.getDate("eff_date_to") != null )
		  {
			 java.util.Date date = rset.getDate("eff_date_to");
			 SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
		 	 effdateto = formatter.format(date);
			 effdateto=DateUtils.convertDate(effdateto,"DMY","en",locale);
		 	 date = null;
		 	 formatter = null;
		   }else {
 		 	effdateto="";
 		   }

 		   if ( rset.getDate("eff_date_from") != null)
 		   {
			 java.util.Date date1 = rset.getDate("eff_date_from");
			 SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
			 effdatefrom = formatter.format(date1);
			 effdatefrom=DateUtils.convertDate(effdatefrom,"DMY","en",locale);
			  date1 = null;
			 formatter = null;
		    }else {
			effdatefrom="";
		    }
			
			eff_date_from=rset.getString("eff_date_from1");
			if( eff_date_from==null ) 
			{
				eff_date_from="";
				old_eff_date_from="";
			}
			old_eff_date_from=eff_date_from;

			
			eff_date_to=rset.getString("eff_date_to1");
			if( eff_date_to==null ) 
			{
				eff_date_to="";
				old_eff_date_to="";
			}
			old_eff_date_to=eff_date_to;
			
			diffdate = rset.getString("diffdate");

			if (diffdate==null || diffdate.equals("") || Integer.parseInt(diffdate) < 0) diffdate = "0";

	
			effstatus=rset.getString("eff_status");

			if(effstatus.equals("D"))
			{
				otherTextAttribute="READONLY";
				checkBoxAttribute="";
				listDisable = "disabled";
		/* SM */disableToFld = "disabled";
		    }
			else
			{
				otherTextAttribute="";
				checkBoxAttribute="CHECKED";
								listDisable = "enabled";

		    }

		    reporting_facility=rset.getString("rep_facility_id");
			if (reporting_facility==null) reporting_facility="";
			//Added by Maheshwaran K for the Password Validation as on 11/07/2012
			//Start
			ws_no = rset.getString("WS_NO");
			if(ws_no == null) ws_no="";
			//End

			appluserlongname=rset.getString("APPL_USER_LONG_NAME");
			if(appluserlongname == null) appluserlongname="";
			active_dir_id=rset.getString("ACTIVE_DIR_ID");
			if(active_dir_id == null) active_dir_id="";
			FIRST_LOGIN_YN=rset.getString("FIRST_LOGIN_YN");
			if(FIRST_LOGIN_YN == null) FIRST_LOGIN_YN="N";
			
			//Added by Kamatchi S for ML-MMOH-CRF-1844.2
			link_ad_user=rset.getString("LINK_AD_USER");
			if(link_ad_user == null) link_ad_user="N";
			
			stmt2 = conn.createStatement();

		    String sql1="select facility_id,facility_name from sm_facility_param where facility_type='F' order by facility_name";

		    rs=stmt2.executeQuery(sql1);

		     String x="";
		     String rep_facility_id1="";
		     rep_facility_id1 = rset.getString("facility_name");
			 if(rep_facility_id1 == null) rep_facility_id1 ="";
		     
		     x = rset.getString("rep_facility_id");
			if(x == null) x="";
			if(str1.length() > 0) str1.delete(0,str1.length());
		 	str1.append("<select name='rep_facility_id' id='rep_facility_id' onClick='change1()'><option value=''>--------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--------");
					while (rs.next()) {
						facilityid=rs.getString(1);
						 facilityname=rs.getString(2);
						 if(x.equals(facilityid))
						 str1.append("<option selected value='"+ facilityid+"'>"+facilityname);
						 else
						  str1.append("<option  value='"+ facilityid+"'>"+facilityname);
						 } str1.append("</select>");

						 str12="<input type='text' name='rep_facility_id1' id='rep_facility_id1' size='30' maxlength='30' value=\""+rep_facility_id1+"\" readonly>";
						 if(x == null) {
						 str21 = "<input type='hidden' name='rep_facility_id2' id='rep_facility_id2' size='15' maxlength='15' value='' >";
						 }
						 else if(x != null){
						 String repFacID=rset.getString("rep_facility_id");
						 if(repFacID == null) repFacID="";
						 str21 = "<input type='hidden' name='rep_facility_id2' id='rep_facility_id2' size='15' maxlength='15' value='"+repFacID+"' >";
						 }

		codeTextAttribute="READONLY";
		
		newUser=false;
		fnvalue = "modify";
		eventFunctionForCase="";
		cpassword=appl_user_password;
		if(rset!=null) rset.close();
	}
//Maheshwaran added for the MMS-QH-CRF-0149	
	try
		{
		String sql3="select ENFORCE_PASSWORD_POLICY_YN,CASE_SENSITIVE_PASSWORD_YN,ALLOWED_SPL_CHAR_IN_PASSWORD,PASSWORD_LENGTH_MIN,PASSWORD_LENGTH_MAX from sm_site_param";
		if(rset!=null)rset.close();
		rset=stmt.executeQuery(sql3);
		if(rset.next())
			{
			ENFORCE_PASSWORD_POLICY_YN=rset.getString("ENFORCE_PASSWORD_POLICY_YN");
			CASE_SENSITIVE_PASSWORD_YN=rset.getString("CASE_SENSITIVE_PASSWORD_YN");
			ALLOWED_SPL_CHAR_IN_PASSWORD=rset.getString("ALLOWED_SPL_CHAR_IN_PASSWORD");
			PASSWORD_LENGTH_MIN=rset.getInt("PASSWORD_LENGTH_MIN");
			PASSWORD_LENGTH_MAX=rset.getInt("PASSWORD_LENGTH_MAX");
			}
		if(stmt!=null)stmt.close();	
		if(rset!=null)rset.close();	
		}
	catch(Exception e)	
		{
		System.out.println("Exception in sm_site_param : "+e);
		}
%>
	<script>
      	var flg = 1;
      	function change() {
      	 if (user_form.eff_status.checked == true)
      	 	user_form.eff_status.value="E";
      	 else
      		user_form.eff_status.value="D";
      	}

		//Added by Kamatchi S for ML-MMOH-CRF-1844.2
		function setVal(obj)
		{
			if(obj.checked == true)
			{
				obj.value = "Y";
				document.user_form.active_dir_id.disabled = false;
				document.user_form.active_dir_id_btn.disabled = false;
				document.user_form.active_dir_img.style.visibility = "visible";
				document.user_form.resp_group_id.disabled = true;
				document.user_form.resp_group_id.value = "";
			}
			else
			{
				obj.value = "N";
				document.user_form.active_dir_id.disabled = true;
				document.user_form.active_dir_id_btn.disabled = true;
				document.user_form.active_dir_id.value = "";
				document.user_form.active_dir_img.style.visibility = "hidden";
				document.user_form.resp_group_id.disabled = false;
				document.user_form.appl_user_password.disabled = false;
				document.user_form.appl_user_cpassword.disabled = false;
			}
		}
		
		function setVal1()
		{
			if(document.user_form.active_dir_id.value != ""){
				document.user_form.appl_user_password.disabled = true;
				document.user_form.appl_user_cpassword.disabled = true;
			}else{
				document.user_form.appl_user_password.disabled = false;
				document.user_form.appl_user_cpassword.disabled = false;
			}

			if(document.user_form.eff_status.checked == true){
				if(document.user_form.link_ad_user.value == "Y"){
					document.user_form.link_ad_user.checked = true;
					document.user_form.active_dir_id.disabled = false;
					document.user_form.active_dir_id_btn.disabled = false;
					document.user_form.active_dir_img.style.visibility="visible";
					document.user_form.resp_group_id.disabled = true;
					document.user_form.resp_group_id.value = "";
				}else{
					document.user_form.link_ad_user.checked = false;
					document.user_form.active_dir_id.disabled = true;
					document.user_form.active_dir_id_btn.disabled = true;
					if(document.user_form.active_dir_id.value == "")
					document.user_form.active_dir_id.value = "";
					document.user_form.active_dir_img.style.visibility = "hidden";
					document.user_form.resp_group_id.disabled = false;
				}
			}else{
				if(document.user_form.link_ad_user.value == "Y"){
					document.user_form.link_ad_user.checked = true;
					document.user_form.active_dir_img.style.visibility = "visible";
				}else{
					document.user_form.link_ad_user.checked = false;
					document.user_form.active_dir_img.style.visibility = "hidden";
				}
			}
		}

      	function change1() {
      	user_form.rep_facility_id2.value = user_form.rep_facility_id.value;
      	}
		//Maheshwaran modified for MMS-QH-CRF-0149
      	function checkLen_1(Obj,enforce_password_policy_yn,allowed_spl_char_in_password,password_length_min,password_length_max) {
		var allowed_spl_char_in_password1=decodeURIComponent(allowed_spl_char_in_password,'UTF-8');
		allowed_spl_char_in_password1 = allowed_spl_char_in_password1.replace("+",'')
			var errors = "" ;
			var len_one=Obj.value.length;
			//Maheshwaran added for MMS-QH-CRF-0149
				if(enforce_password_policy_yn=='Y')
					{
					ChkPWSplChar(Obj,allowed_spl_char_in_password1,'tab');
					}
			if (len_one < password_length_min)
				{
				errors = getMessage('PWD_MIN_CH','SM');
				errors=errors.replace("#",password_length_min);
				Obj.focus();
				return false;		
				}
				else if (len_one > password_length_max)//Maheshwaran changed from 20 to 10 for MMS-QH-CRF-0149
				{
				errors = getMessage('PWD_MAX_CH','SM');
				errors=errors.replace("#",password_length_max);
				Obj.focus();
				return false;			
				}			
				else {
				
				}
			}
		
function checkLen_2(len){
			var errors = "" ;
			var len_two=len.value.length;
			if (len_two <5)
				{
					errors = getMessage('PWD_MIN_CH','SM');
					errors=errors.replace("#",password_length_min);
					len.focus();
					return false;		
				}
				else if (len_two >10)
				{
					errors = getMessage('PWD_MAX_CH','SM');
					errors=errors.replace("#",password_length_max);
					len.focus();
					return false;		
				}
				else{
				
			
				
				}
			}

function PopPractType(){

   
	var practitioner_type;
	var practtype = "";
		//parent.frames[1].document.user_form.pract_type.value;

	


	var  HTMLVal = new String();

	clear_list(parent.frames[1].document.forms[0].pract_type);

	parent.frames[1].document.forms[0].pract_name.value='';
	parent.frames[1].document.forms[0].pract_name_desc.value='';
	var roletype 		= document.user_form.role_type.value;
	

	
	if (roletype == "P")
	{

		document.getElementById('typeLabl').innerText=getLabel("Common.practitionertype.label","Common");
		document.getElementById('typeLablName').innerText=getLabel("Common.practitionername.label","Common");
		document.getElementById('pract_type_gif').style.visibility="visible";
		document.getElementById('pract_name_gif').style.visibility="visible";
		
		
		HTMLVal = "<html><body onKeyDown = 'lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eSM/jsp/GetValUser.jsp'><input type='hidden' name='role_type' id='role_type' value='"+roletype+"'><input type='hidden' name='pract_type' id='pract_type' value='"+practtype+"'><input type='hidden' name='pract_name' id='pract_name' value=''></form></body></html>";
		

		parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.messageFrame.document.dum_form.submit();

	}
	else if (roletype == "O")
	{
		document.getElementById('typeLabl').innerText=getLabel("Common.OtherStaffType.label","Common");
		document.getElementById('typeLablName').innerText=getLabel("Common.OtherStaffName.label","Common");
		document.getElementById('pract_type_gif').style.visibility="visible";
		document.getElementById('pract_name_gif').style.visibility="visible";
    
		HTMLVal = "<html><body onKeyDown = 'lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eSM/jsp/GetValUser.jsp'><input type='hidden' name='role_type' id='role_type' value='"+roletype+"'><input type='hidden' name='pract_type' id='pract_type' value='"+practtype+"'><input type='hidden' name='pract_name' id='pract_name' value=''></form></body></html>";
		parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.messageFrame.document.dum_form.submit();

	}
	else
	{
		document.getElementById('typeLabl').innerText="Functional Type";
		document.getElementById('typeLablName').innerText="Functional Name";
		document.getElementById('pract_type_gif').style.visibility="hidden";
		document.getElementById('pract_name_gif').style.visibility="hidden";

	}

}

			function PopPractName(cod,code){
				
                       if(parent.frames[1].document.forms[0].pract_type.value=="")
				{
				parent.frames[1].document.getElementById("prid").disabled=true;
				parent.frames[1].document.forms[0].pract_name_desc.readOnly=true; 
				parent.frames[1].document.forms[0].pract_name.value='';
				parent.frames[1].document.forms[0].pract_name_desc.value='';
				}else{
					   parent.frames[1].document.getElementById("prid").disabled=false;
					   parent.frames[1].document.forms[0].pract_name_desc.readOnly=false;
					  // parent.frames[1].document.forms[0].pract_name_desc.value='';
				
				}

				if(parent.frames[1].document.forms[0].eff_status.value=='D'){
					
					parent.frames[1].document.forms[0].prid.disabled="true";
					
				}
		}
					function PopPractName1(cod,code){
				
                       if(parent.frames[1].document.forms[0].pract_type.value=="")
				{
				parent.frames[1].document.getElementById("prid").disabled=true;
				parent.frames[1].document.forms[0].pract_name_desc.readOnly=true; 
				parent.frames[1].document.forms[0].pract_name.value='';
				parent.frames[1].document.forms[0].pract_name_desc.value='';
				}else{
					   parent.frames[1].document.getElementById("prid").disabled=false;
					   parent.frames[1].document.forms[0].pract_name_desc.readOnly=false;
					  parent.frames[1].document.forms[0].pract_name_desc.value='';
				
				}
		}

		

		function clear_list(obj)
		{
				while ( obj.options.length > 0 )
			      {
				 	obj.remove(obj.options[0]);
				  }
				  

				
						var opt = parent.document.f_query_add_mod.document.createElement("OPTION");
						opt.text = '  --------'+getLabel("Common.defaultSelect.label","Common")+'--------  ';
						opt.value= '';
					
						obj.add(opt)

	}
		function clear_list1(obj)
		{
					while ( obj.options.length > 0 )
						obj.remove(obj.options[0]);

			
						var opt = parent.document.frames[1].document.createElement("OPTION");
						opt.text = '  --------'+getLabel("Common.defaultSelect.label","Common")+'--------  ';
						opt.value= '';

						obj.add(opt)


	}
	function ToDateValidation(obj){
			var curdate = document.user_form.cur_date;
			var msg = getMessage("TO_DATE_LESS_SYSDATE","SM");
			if(doDateCheckAlert(curdate,obj) == false	 ) {
				obj.focus();
				obj.select();
				alert(msg);
			}
		  }
	function CheckForNumber(obj) 
	{
		if (obj.value.length > 0 )
		{
			if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0)
			{		
				alert(getMessage('CANNOT_START_WITH_NUMERIC','SM'));
				obj.value='';
				obj.select();
				obj.focus();
				return false;
			}

			if (obj.value.substr(0,1) >= 0)
			{
				alert(getMessage('CANNOT_START_WITH_NUMERIC','SM'));
				obj.value='';
				obj.select();
				obj.focus();
				return false;
			}
		}
	}

function CheckPositiveNumber1(obj)
		{	
	if ( !(trimCheck(obj.value) && isNaN(obj.value) == false && obj.value > 0)) {	

	  		if ( obj.value.length > 0 ) {
  			alert(getMessage("ONLY_POSITIVE_NUM","SM"));
  			obj.select();
  			obj.focus();
  		}

  	}
}

	async function displayUser(obj,target,target_id)
	{
	
	var retVal = 	new String();


	   var retVal =    new String();
	  var argumentArray  = new Array() ;
	  var dataNameArray  = new Array() ;
	  var dataValueArray = new Array() ;
	  var dataTypeArray  = new Array() ;
	  var tit="";				
      practtype  =document.forms[0].pract_type.value;
	  var roletype= document.user_form.role_type.value;

		 
		
	if('<%=count_am_practitioner%>' >0  && practtype !='')
	{ 
     tit=getLabel("Common.practitioner.label","Common");
		if (roletype == "P"){
			if(this.value==""){
				document.forms[0].pract_name_desc.value="";
				document.forms[0].pract_name.value="";

			}else{
			getPractitioner(target,target_id)
			}
		//parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='
		//sql="Select practitioner_id code,practitioner_NAME description from am_practitioner where   PRACT_TYPE ='"+practtype+"' and upper(practitioner_id) like upper(?) and upper(practitioner_NAME) like upper(?) and  eff_status = 'E'  order by 2";
	
	}
	else if (roletype == "O"){
	tit=getLabel("Common.OtherStaff.label","Common")	
		parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='
		sql="Select OTHER_STAFF_ID code,OTHER_STAFF_NAME description from AM_OTHER_STAFF where eff_status='E' and  OTHER_STAFF_TYPE ='"+practtype+"' and upper(OTHER_STAFF_ID) like upper(?) and upper(OTHER_STAFF_NAME) like upper(?)  order by 2";
		
	
	
	    argumentArray[0] =sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = DESC_LINK ;
		argumentArray[7] = DESC_CODE;
		retVal = await CommonLookup( tit, argumentArray );
	 

		
		var arr=new Array();
		if (!(retVal == null||retVal==""))
		{
			var ret1=unescape(retVal);
			arr=ret1.split(",");
			target.value=arr[1];
			target_id.value=arr[0];
		}
		else
		{
			target.value="";
			target_id.value="";
		}
	}
	}
	else
	{
	var err= getMessage('CAN_NOT_BE_BLANK','Common');
	
	if (roletype == "P"){
	err= err.replace("$",getLabel("Common.practitionertype.label","Common"));
	}
	
	else if (roletype == "O"){
		err= err.replace("$",getLabel("Common.OtherStaffType.label","Common"));
	}
	else if (roletype == ""){
		err= err.replace("$",getLabel("Common.RoleType.label","Common"));
	}
	parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err;
	
	}
	
}

function getPractitioner(obj,target){


	var practName_FName="";
	var practName_FValue="";
	var practId_FName="";
	obj.value=trimString(obj.value);
	practName_FName=obj.name;
	practName_FValue=obj.value;
	var sql1="";
	var sql2="";
	practtype  =document.forms[0].pract_type.value;

	sql1 = "SELECT a.practitioner_id practitioner_id, a.practitioner_name practitioner_name, a.PRACT_TYPE_DESC practitioner_type, a.PRIMARY_SPECIALITY_DESC primary_specialty, a.position_code, a.gender FROM am_practitioner_lang_vw a WHERE  a.pract_type = NVL ('"+practtype+"', a.pract_type) AND  a.eff_status = 'E' AND  a.language_id = '"+localeName+"' AND UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type)) AND UPPER(a.primary_speciality_code) LIKE UPPER(NVL(?,a.primary_speciality_code)) AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) OR UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND gender LIKE NVL(UPPER(?),gender) AND UPPER(NVL(a.POSITION_CODE ,'123')) LIKE UPPER(NVL(?,NVL(a.POSITION_CODE,'123')))";

	sql2="SELECT a.practitioner_id practitioner_id, a.practitioner_name practitioner_name, a.PRACT_TYPE_DESC practitioner_type, a.PRIMARY_SPECIALITY_DESC primary_specialty, a.position_code, a.gender FROM am_practitioner_lang_vw a WHERE  a.pract_type = NVL ('"+practtype+"', a.pract_type) AND  a.eff_status = 'E' AND  a.language_id = '"+localeName+"' AND UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type)) AND UPPER(a.primary_speciality_code) LIKE UPPER(NVL(?,a.primary_speciality_code)) AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) AND UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND gender LIKE NVL(UPPER(?),gender) AND UPPER(NVL(a.POSITION_CODE ,'123')) LIKE UPPER(NVL(?,NVL(a.POSITION_CODE,'123')))";

	var xmlDoc= "" ;
	var xmlHttp= new XMLHttpRequest();


	xmlStr	="<root><SEARCH " ;
	xmlStr += " practName_FName=\"" +practName_FName + "\"";
	xmlStr += " practName_FValue=\"" + encodeURIComponent(practName_FValue) + "\"";
	xmlStr += " sql=\"" +encodeURIComponent(sql1)+ "\"";
	xmlStr += " sqlSec=\"" +encodeURIComponent(sql2)+ "\"";
	xmlStr += " practitioner_type=\"" + practtype + "\"";
	xmlStr += " specialty_code=\"" + "" + "\"";
	xmlStr += " job_title=\"" + "" + "\"";
	xmlStr += " gender=\"" + "" + "\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText);	


}

function PractLookupRetVal(retVal,objName)
{
	var arr;
		if(retVal!=null){
		arr=retVal.split("~");
		document.forms[0].pract_name_desc.value=arr[1];
		document.forms[0].pract_name.value=arr[0];
     	}
		else{
			document.forms[0].pract_name_desc.value="";
			document.forms[0].pract_name.value="";
		}

}
//Maheshwaran added for MMS-QH-CRF-0149
function checkValidPW(obj,old_pw){
	  	  
	  /*Below line modified for this SCF AMS-SCF-0597*/
	  var newPassword=obj.value;
	  var oldPassword=old_pw;
	  
	  if(newPassword!="")newPassword=newPassword.toUpperCase();
	  if(oldPassword!="")oldPassword=oldPassword.toUpperCase();
	  
	  if((newPassword!="" && (newPassword!=oldPassword))){
		   document.forms[0].first_login_yn.value="R";
	  }
	  if((newPassword!="" && (newPassword==oldPassword))){
		   document.forms[0].first_login_yn.value=document.forms[0].first_login.value; 
	  }	  
	  //End this SCF AMS-SCF-0597
	  
}
   	</script>

      </head>

      <!--setVal1() Added by Kamatchi S for ML-MMOH-CRF-1844.2-->
      <body OnMouseDown='CodeArrest()' onKeyDown="lockKey()" oncontextmenu="return false" onload='<%if(isSSOIntegrationAppl){%>setVal1();<%}%>FocusFirstElement();PopPractName();' onKeyPress='return ChkKey(event);'> 
       <!--<body  onload='FocusFirstElement();PopPractName();' >-->

      	<form name='user_form' id='user_form' action='../../servlet/eSM.UserServlet' method='post' target='messageFrame'>

	     <table border='0' cellpadding='3' cellspacing='0' width='100%' >
      		<tr>
      		    <td  width='25%' class='label'><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
      		    <td  width='25%' class='fields'><input type='text' name='appl_user_id' id='appl_user_id' value="<%=appl_user_id%>" size='30' maxlength='30' <%=codeTextAttribute%> <%=eventFunctionForCase%>  <%if(isSplCharNotAllowApplYN){%> onKeyPress="return CheckForSpecCharsValidation2(event); return CheckForSpecCharsforID(event);" onBlur='ChangeUpperCase(this);makeValidString(this);checkSpecChar();CheckSplCharsforIdValidation(this);' onKeyUp="CheckForNumber(this);" <%}else{%> onBlur="ChangeUpperCase(this);makeValidString(this);checkSpecChar()"  onKeyUp="CheckForNumber(this);" onKeyPress="return CheckForSpecCharsforID(event)" <%}%>><img src='../../eCommon/images/mandatory.gif' align='center'></img></td><!--Modified by Suji Keerthi for MOHE-CRF-0113 US001-->
				<td class='label' width='20%'>&nbsp;</td>
				<td class='label' width='30%'>&nbsp;</td>
      		</tr>
      		<tr>
      		    <td  class=label><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
      		    <td class='fields'><input type='text' name='appl_user_name' id='appl_user_name' size='30' maxlength='60' value="<%=appl_user_name%>" <%if(isSplCharNotAllowApplYN){%> onKeyPress="return CheckForSpecCharsValidation1(event)" onBlur='CheckSplCharsValidation(this); makeValidString(this);' <%}else{%> onBlur="makeValidString(this)" <%}%> <%=otherTextAttribute%> ><img src='../../eCommon/images/mandatory.gif' align='center'></img></td><!--Modified by Suji Keerthi for MOHE-CRF-0113 US001-->
				<td class='label' >&nbsp;</td>
				<td class='label' >&nbsp;</td>
      		</tr>
      		
			 <tr>
      		    <td  class=label><fmt:message key="eSM.PreferredLanguage.label" bundle="${sm_labels}"/></td>
      		    <td  class='fields'><select name='language' id='language'  <%=listDisable%> >
		 	 	 <option value=''>&nbsp;&nbsp;-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------&nbsp;&nbsp;</option>
							<%
				
				sql="select LANGUAGE_ID,SHORT_NAME from sm_language where eff_status='E' and LANGUAGE_DIRECTION!='R' order by 2";
							if(pstmt!=null)pstmt.close();
							if(rset!=null)rset.close();

				 pstmt = conn.prepareStatement(sql.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
							rset = pstmt.executeQuery(sql) ;
							
							 if(rset != null)
							   {
								  rset.last();
								  countRec = rset.getRow();
								  rset.beforeFirst();
							   }

					if (countRec == 1)
					  {
						while(rset!=null && rset.next())
						  {
							%>
							<option value='<%=rset.getString("LANGUAGE_ID")%>' selected><%=rset.getString("SHORT_NAME")%> </option>
						  <%}
					  }
				   else if (countRec >= 1)
				   {
				  while(rset!=null && rset.next())
				  {
								dat=rset.getString("SHORT_NAME");
								id=rset.getString("LANGUAGE_ID");
								if (id.equals(lang_id))
								sel = "selected";
								else
								sel = "";
								%>
					   <option value='<%=id%>' <%=sel%>> <%=dat%></option>
				  <%}
				  }
							
				if(pstmt!=null)pstmt.close();
				if(rset!=null)rset.close();
				
								%>			
									</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>		 			
				</td>
				<td class='label' >&nbsp;</td>
				<td class='label' >&nbsp;</td>
      		</tr>
	
			<tr>
      		<td class='label'><fmt:message key="Common.EffectiveFrom.label" bundle="${common_labels}"/></td>
		    <td class='fields'>
				<%
				if (Integer.parseInt(diffdate)>0)
				{
					redOnly = "readonly";
				
				}
			else
				{
					redOnly = "";

				}
				
				%>
		    <input type='text' id='eff_date_from1' name='eff_date_from1'  <%=redOnly%> value="<%=effdatefrom%>" size='10' maxlength='10' <%=otherTextAttribute%> onblur='if (!this.readOnly) {validate_from_date(this);}'><img  src="../../eCommon/images/CommonCalendar.gif" <%=disableToFld%> onClick="document.getElementById('eff_date_from1').focus();return showCalendar('eff_date_from1',null,null,true);" style="cursor='hand'"></td>

			<td class=label><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type='text' id='eff_date_to1' name='eff_date_to1'  size='10' maxlength='10' value="<%=effdateto%>" <%=otherTextAttribute%> onblur='validate_to_date(this);' ><img  src="../../eCommon/images/CommonCalendar.gif" <%=disableToFld%> onClick="document.getElementById('eff_date_to1').focus();return showCalendar('eff_date_to1',null,null,true);" style="cursor='hand'"></td>
			
      		</tr>
<%if(!(appluserlongname.equals("")))
{
int len = appluserlongname.length();
int i1=0;
int n_incre = 0;
int max = 0;

if (len > 75) 
{ 
    for ( i1=0; i1 <= (len/75);i1++) 
	{   
		if((i1+1)*75 < len)
			max = (i1+1)*75;
		 else
		  max = len;
		
		appluserlongname1=appluserlongname1+""+appluserlongname.substring((i1*75),max);
		n_incre = 1;
    }}
else  {
	appluserlongname1=appluserlongname;
 }}%>
      	<tr>
<td class="label"  ><fmt:message key="Common.longname.label" bundle="${common_labels}"/></td>
<td class="fields" colspan='2' ><textarea name='long_name' id='long_name'  rows='4' cols='72' <%if(isSplCharNotAllowApplYN){%> onKeyPress="return CheckForSpecCharsValidation1(event); checkMaxLimit(this,300);" onBlur='CheckSplCharsValidation(this); return maxLength(this,"300");' onpaste='return maxLengthPaste(this,"300");' <%}else{%>	onKeyPress='checkMaxLimit(this,300);' onpaste='return maxLengthPaste(this,"300");' onBlur='return maxLength(this,"300");' <%}%> <%=otherTextAttribute%>>
<%=appluserlongname1%></textarea><!--Modified by Suji Keerthi for MOHE-CRF-0113 US001-->	

</td>
<td class='label'  >&nbsp;</td>
	<td class='fields' ></td>
		</tr>
<tr>

<!--Added by Kamatchi S for ML-MMOH-CRF-1844.2-->
<%if(isSSOIntegrationAppl){%>
<td class='label'><fmt:message key="eSM.LinkActDirUser.label" bundle="${sm_labels}"/></td>
<td class='fields'><input type='checkbox' name='link_ad_user' id='link_ad_user' value="<%=link_ad_user%>" onClick="setVal(this)" <%=otherTextAttribute%> <%=listDisable%>></td>
<%}%>

<%if(isSSOIntegrationAppl){%>
	<td  class=label>
		<fmt:message key="eSM.ActiveDirectoryID.label" bundle="${sm_labels}"/>
	</td>
	<td class='fields' clospan='2'>
		<input type='text' name='active_dir_id' id='active_dir_id' size='91' maxlength='80' value="<%=active_dir_id%>" onBlur="makeValidString(this);activeDirIdBlur(active_dir_id);" <%=otherTextAttribute%>><input type='button' class='button'  value='?'  id='active_dir_id_btn'   onClick='activeDirId(active_dir_id);' <%=listDisable%>><img id="active_dir_img" style="visibility:hidden" src='../../eCommon/images/mandatory.gif'></img>
	</td>
<%}else{%>
	<td  class=label><fmt:message key="eSM.ActiveDirectoryID.label" bundle="${sm_labels}"/></td>
	<td class='fields' clospan='2'><input type='text' name='active_dir_id' id='active_dir_id' size='91' maxlength='80' value="<%=active_dir_id%>" onBlur="makeValidString(this)" <%=otherTextAttribute%> ></td>
<%}%>

<td class='label'  >&nbsp;</td>
	<td class='fields' ></td>


</tr>		
      		<tr>
<%
String isEnableEffStatus	 ="";
if(fnvalue.equals("modify") && effstatus.equals("D") && ! ws_no.equals("")){
	isEnableEffStatus	= "disabled";
}
			
%>

      		     <td class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
      		     <td class='fields'><input type='checkbox' name='eff_status' id='eff_status' value="<%=effstatus%>" <%=checkBoxAttribute%> <%=isEnableEffStatus%> onClick="change()"></td>
				 <td class='label' >&nbsp;</td>
				<td class='label' >&nbsp;</td>
      		</tr>
   
		<tr><td class='columnheader' colspan='4'><fmt:message key="Common.ContactDetails.label" bundle="${common_labels}"/></td></tr>
      	<tr>
	      	    <td class='label'><fmt:message key="Common.RepFacility.label" bundle="${common_labels}"/></td>
  	   <%
		if(effstatus.equals("E")) {%>
      		    <td class='querydata'><%=str1.toString()%><%=str21%></td>
      		    <%}
		   else if(effstatus.equals("D")){
			   
			   %>
		    <td class='querydata' ><%=str12%><%=str21%></td>
      		    <%}str1.setLength(0);%>
      	
      		    <td class='label'><fmt:message key="Common.telephone.label" bundle="${common_labels}"/></td>
	      	    <td class='fields'><input type='text' name='contact_tel_no' id='contact_tel_no' size='20' maxlength='20' value="<%=telephone%>"  onBlur="makeValidString(this)" <%=otherTextAttribute%> >
	      	    </td>
	</tr>
	<tr>
	      	    <td class='label'><fmt:message key="Common.fax.label" bundle="${common_labels}"/> </td>
      		    <td class='fields'><input type='text' name='contact_fax_no' id='contact_fax_no' size='20' maxlength='20' onBlur="makeValidString(this)" value="<%=fax%>" <%=otherTextAttribute%> ></td>
	       	    <td class='label'><fmt:message key="Common.email.label" bundle="${common_labels}"/></td>
			    <td class='fields'><input type='text' name='email_id' id='email_id' size='25' maxlength='50' value="<%=email%>"  onBlur="makeValidString(this);if(this.value != ''){emailvalidate(this)}" <%=otherTextAttribute%> >
			  	</td>
    </tr>
      			

      <tr>	<td class='columnheader' colspan='4'><fmt:message key="eSM.FunctionalRoleDetails.label" bundle="${sm_labels}"/></td></tr>
	
		 <tr> 
		 <td  class=label> <fmt:message key="Common.RoleType.label" bundle="${common_labels}"/></td>
		  <td class='fields'><select name='role_type' id='role_type' onChange='PopPractType();PopPractName()'  <%=listDisable%>  >
						 <option value=''>-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
						 <option value='P' <%=selP%>><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
						 <option value='O' <%=selO%>><fmt:message key="Common.OtherStaff.label" bundle="${common_labels}"/></option>
						
						 </select>
			</td>
			<td class='label' >&nbsp;</td>
			<td class='label' >&nbsp;</td>
			</tr>
			<tr>
			 <td class=label id='typeLabl' nowrap><fmt:message key="eSM.FunctionalType.label" bundle="${sm_labels}"/></td>
		     <td class='fields'><select name='pract_type' id='pract_type' onChange='PopPractName1();'<%=listDisable%>>
		 	 					 <option value=''>&nbsp;&nbsp;---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------&nbsp;&nbsp;</option>
									<%
								
								
								if(fnvalue.equals("modify") && P_flag.equals("Y"))
								{
									
								if(func_role.equals("P"))
	                            {	
									if(count_am_practitioner > 0)
									{	
										
										sql="select PRACT_TYPE, DESC_USERDEF from am_pract_type where 	eff_status 	= 'E' and sysdate >= nvl(eff_date_from,sysdate) and 	sysdate <= nvl(eff_date_to,sysdate) order by 2";
										if(stmt!=null)stmt.close();
										stmt = conn.createStatement() ;
										if(rset!=null)rset.close();
										rset = stmt.executeQuery(sql) ;	 
										while (rset.next())
										{
											dat=rset.getString("DESC_USERDEF");
											id=rset.getString("PRACT_TYPE");
											if (id.equals(pract_type))
												sel = "selected";
											else
												sel = "";
											%>
											<option value='<%=rset.getString("pract_type")%>' <%=sel%>> <%=rset.getString("desc_userdef")%></option>
											<%
										}
									}
								 }
								 
								 else if(func_role.equals("O")) {
						
								 sql="select OTHER_STAFF_TYPE, SHORT_DESC from am_other_staff_type where eff_status = 'E' ORDER BY 2";
			
										if(stmt!=null)stmt.close();
										stmt = conn.createStatement() ;
										if(rset!=null)rset.close();
										rset = stmt.executeQuery(sql) ;	 
										while (rset.next())
										{
											dat=rset.getString("SHORT_DESC");
											id=rset.getString("OTHER_STAFF_TYPE");
											if (id.equals(pract_type))
												sel = "selected";
											else
												sel = "";
											%>
											<option value='<%=rset.getString("OTHER_STAFF_TYPE")%>' <%=sel%>> <%=rset.getString("SHORT_DESC")%></option>
											<%
										}
											if(rset!=null) rset.close();
								 }
                               }
								%>
								</select><img id='pract_type_gif' src='../../eCommon/images/mandatory.gif' align='center'  style='visibility:<%=visibilityPract%>' ></img>
			  </td>
			  <td id ='typeLablName' class=label><fmt:message key="eSM.FunctionalName.label" bundle="${sm_labels}"/></td>
			  <td class='fields'><input type='text' name='pract_name_desc' id='pract_name_desc' onBlur="makeValidString(this);if(this.value != ''){displayUser(this,pract_name_desc,pract_name);} else { clearName()}" <%=listDisable%> value="<%=appl_pract_name%>"   size='25' maxlength='30' readOnly><input type='hidden' name='pract_name' id='pract_name' value="<%=func_role_id%>"<%=listDisable%>><input type='button' class='button'  value='?'  id='prid' disabled  onClick='displayUser(this,pract_name_desc,pract_name)'<%=listDisable%>><img id='pract_name_gif'src='../../eCommon/images/mandatory.gif' align='center'  style='visibility:<%=visibilityPract%>'  ></img>
								
			</td>
			</tr>
	
<%
		if(fnvalue.equals("modify")){
		if(!(func_role.equals("") || func_role == null )){	            
        if(func_role.equals("P"))
		    {%><script>
				document.getElementById('typeLabl').innerText=getLabel("Common.practitionertype.label","Common");
	         	document.getElementById('typeLablName').innerText=getLabel("Common.practitionername.label","Common");
				</script>
			<%}else if(func_role.equals("O")){%>
			  <script>	
				document.getElementById('typeLabl').innerText=getLabel("Common.OtherStaffType.label","Common");
	         	document.getElementById('typeLablName').innerText=getLabel("Common.OtherStaffName.label","Common");
				</script>
			<%}else {%>
			  <script>
				document.getElementById('typeLabl').innerText=getLabel("eSM.FunctionalType.label","SM")
	         	document.getElementById('typeLablName').innerText=getLabel("eSM.FunctionalName.label","SM")
				</script>
			<%}
		  }
		}%>


		 <tr><td class='columnheader' colspan='4'><fmt:message key="Common.otherDetails.label" bundle="${common_labels}"/></td></tr>
		
		 <tr>
			<td class='label' nowrap><fmt:message key="eSM.ResourceGroup.label" bundle="${sm_labels}"/></td>
    		<td class='fields' ><select name='resp_group_id' id='resp_group_id' <%=listDisable%> >
							<option value=''>--------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>
							 <% 
							 String sqlresp="select ora_rsrc_group_id,ora_rsrc_group_name from sm_ora_rsrc_grp ";
							 if(stmt!=null)stmt.close();
							 stmt=conn.createStatement();
							 ResultSet rsresp = stmt.executeQuery(sqlresp);
							  while(rsresp.next()){
							id=rsresp.getString("ora_rsrc_group_id");
							dat=rsresp.getString("ora_rsrc_group_name");

							if(id.equals(resp_group_id))
							{%>
								<option value='<%=id %>' selected> <%=dat%>
							<%}
							else
								{%>

								<option value='<%=id%>'> <%=dat%>
								<%}

							  }
							  if(rsresp!=null) rsresp.close();%>
							 </select>&nbsp;&nbsp;
    				     </td>

				<td  class=label nowrap><fmt:message key="Common.EmployeeNo.label" bundle="${common_labels}"/></td>
      		    <td  class='fields'><input type='text' name='employee_no' id='employee_no' size='10' maxlength='10' value="<%=employee_no%>" onBlur="makeValidString(this)"  <%=otherTextAttribute%> ></td>
			</tr>
			
			<tr>
				<td class='label' nowrap><fmt:message key="eSM.ResponsibilityGroup.label" bundle="${sm_labels}"/></td>
    			 <td class='fields' ><select name='responsibility_group' id='responsibility_group' <%=listDisable%> >
							<option value=''>--------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>
							 <% 
							 sqlresp="select resp_group_id,resp_group_name from sm_resp_grp where eff_status='E' order by 1 ";
							 rsresp = stmt.executeQuery(sqlresp);
							  while(rsresp.next()){
								id=rsresp.getString("resp_group_id");
								dat=rsresp.getString("resp_group_name");

								if(id.equals(responsibility_grp))
								{%>
									<option value='<%=id%>' selected><%=dat%>
								<%}
								else{
								%>
								<option value='<%=id%>'><%=dat%>
								<%}

							  }
							  if(rsresp!=null) rsresp.close();%>
							 </select>
    				     </td>
				 <td class='label' >&nbsp;</td>
				<td class='label' >&nbsp;</td>
				</tr>
				 <tr>
				 <td  class=label nowrap><fmt:message key="eSM.ReportOutputDirectory.label" bundle="${sm_labels}"/></td>
      		    <td  class='fields'><input type='text' name='rpt_output_dir' id='rpt_output_dir' size='20' maxlength='60' value="<%=reports_home_dir%>" onBlur="makeValidString(this)"   <%=listDisable%> ></td>
				<td class='label' >&nbsp;</td>
				<td class='label' >&nbsp;</td>
				</tr>


	 <tr><td class='columnheader' colspan='4'><fmt:message key="Common.password.label" bundle="${common_labels}"/></td></tr>
	
      	<tr>
      		    <td class='label' ><fmt:message key="Common.password.label" bundle="${common_labels}"/>
	      	    </td>
				<!--chk_pass(); in onblur was added by Maheshwaran K for the Password Valiation as on 11/07/212-->
	      	    <td class='fields'><!--input type='password' name='appl_user_password' size='20' maxlength='20' value="<%=appl_user_password%>" onBlur="chk_pass(); makeValidString(this)" onChange="checkLen_1(this)"  <%=otherTextAttribute%>  onkeypress="return CheckForSpecCharsforID(event);checkMaxLimit(this,20);" OnKeyUp='CheckSpecialChar(this);CheckForNumber(this)' -->
				<!--Maheshwaran K modified for the MMS-QH-CRF-0149-->
				<input type='password' name='appl_user_password' id='appl_user_password' size='20' maxlength='20' value="<%=appl_user_password%>" onBlur="chk_pass();  makeValidString(this); checkValidPW(this,'<%=appl_user_password%>');" onChange="checkLen_1(this,'<%=ENFORCE_PASSWORD_POLICY_YN%>','<%=java.net.URLEncoder.encode(ALLOWED_SPL_CHAR_IN_PASSWORD)%>',<%=PASSWORD_LENGTH_MIN%>,<%=PASSWORD_LENGTH_MAX%>);"  <%=otherTextAttribute%>  onkeypress=" return  checkMaxLimit(this,20);" OnKeyUp="CheckSpecialChar(this,'<%=ENFORCE_PASSWORD_POLICY_YN%>','<%=java.net.URLEncoder.encode(ALLOWED_SPL_CHAR_IN_PASSWORD)%>'); CheckForNumber(this); " >
				<img src='../../eCommon/images/mandatory.gif' align='center'></img>
				<!--Added by Maheshwaran K for the Password Valiation as on 11/07/212-->
				<input type='hidden' name='password_value_Y' id='password_value_Y' value=''>
				<!--End-->
	      	    </td>
				<td class='label'><fmt:message key="Common.ConfirmPassword.label" bundle="${common_labels}"/>
				</td>
				<td class='fields'><!--input type='password' name='appl_user_cpassword' size='20' maxlength='20' value="<%=cpassword%>"  onChange='checkLen_2(this)'  <%=otherTextAttribute%>  onkeypress="return CheckForSpecCharsforID(event);checkMaxLimit(this,20);" OnKeyUp='CheckSpecialChar(this);CheckForNumber(this)' -->
				<!--Maheshwaran K modified for the MMS-QH-CRF-0149-->
				<input type='password' name='appl_user_cpassword' id='appl_user_cpassword' size='20' maxlength='20' value="<%=cpassword%>"  onChange="checkLen_1(this,'<%=ENFORCE_PASSWORD_POLICY_YN%>','<%=java.net.URLEncoder.encode(ALLOWED_SPL_CHAR_IN_PASSWORD)%>',<%=PASSWORD_LENGTH_MIN%>,<%=PASSWORD_LENGTH_MAX%>)"  <%=otherTextAttribute%>  onkeypress="return checkMaxLimit(this,20);" OnKeyUp="CheckSpecialChar(this,'<%=ENFORCE_PASSWORD_POLICY_YN%>','<%=java.net.URLEncoder.encode(ALLOWED_SPL_CHAR_IN_PASSWORD)%>'); CheckForNumber(this);" >
				<img src='../../eCommon/images/mandatory.gif' align='center'></img>  <!--onBlur="chkPassword(this)"-->
	      	    </td>
	</tr>
	<tr>
		    <td class='label'><fmt:message key="eSM.PINNo.label" bundle="${sm_labels}"/>
		    </td>
		    <td class='fields'><input type='password' name='appl_pin_no' id='appl_pin_no' size='20' maxlength='20' value="<%=appl_pin_no%>"  onChange=''  <%=otherTextAttribute%>>
		    </td>
			<%
			//Added by Maheshwaran K for the Password Validation as on 11/07/2012
			//Start
			if(fnvalue.equals("modify") && effstatus.equals("D") && ! ws_no.equals(""))
				{
				%>
				<td align='right' class=label nowrap></td>
				<td align='left' >&nbsp;&nbsp;
				<input type='button' name='Unlock_User' id='Unlock_User' value='Unlock User' class='button' onClick='applyunlock();' ></td>
				<% 
				}
			//End
		%>
	</tr>
	<!--Maheshwaran added for MMS-QH-CRF-0149-->
	<%if(ENFORCE_PASSWORD_POLICY_YN.equals("Y")) {%>
	<tr>
	 <td colspan='3' class='label' style='color:red'><b><fmt:message key="eSM.PASSWORD_POLICY.label" bundle="${sm_labels}"/></b>&nbsp;<fmt:message key="eSM.PASSWORD_POLICY1.label" bundle="${sm_labels}"/><%=ALLOWED_SPL_CHAR_IN_PASSWORD%></td>
	</tr>
	<%}%>
	</table>



    <%  if(newUser){%>

      	<input type='hidden' name='function' id='function' value='insert'>
      	<input type='hidden' name='function_name' id='function_name' value='insert'>

      <%}else { // function_name = "modify";%>

      	<input type='hidden' name='function' id='function' value='modify'>
      	<input type='hidden' name='function_name' id='function_name' value='modify'>
     <%}
		if(rs!=null) rs.close();
		if(rset != null) rset.close();
		if(stmt != null) stmt.close();
		if(stmt1 != null) stmt1.close();
		if(stmt2 != null) stmt2.close();
     	}
		catch(Exception e){out.print(e);}
		%>
		 <input type='hidden' name='func_id' id='func_id' value='<%=func_id%>' >
		<input type='hidden' name='old_password' id='old_password' value='<%=appl_user_password%>' >
		<input type='hidden' name='password_status' id='password_status' value='N' >
		<input type='hidden' name='old_resource_id' id='old_resource_id' value='<%=resp_group_id%>' >
		<input type='hidden' name='resource_status' id='resource_status' value='N' >
      	<input type='hidden' name='role_type1' id='role_type1' value=''>
      	<input type='hidden' name='pract_type1' id='pract_type1' value ="<%=pract_type%>">
      	<input type='hidden' name='pract_name1' id='pract_name1' >
      	<input type='hidden' name='resp_group_id1' id='resp_group_id1' >
      	<input type='hidden' name='eff_date_from' id='eff_date_from' >
      	<input type='hidden' name='eff_date_from_temp' id='eff_date_from_temp' >
      	<input type='hidden' name='eff_date_to_temp' id='eff_date_to_temp' >
      	<input type='hidden' name='eff_date_to' id='eff_date_to' >
		<input type='hidden' name='appl_pin_no1' id='appl_pin_no1' value = >
		<input type='hidden' name='old_eff_date_from' id='old_eff_date_from' value='<%=old_eff_date_from%>'>
		<input type='hidden' name='old_eff_date_to' id='old_eff_date_to' value='<%=old_eff_date_to%>'>
		<!--Below added by Suji Keerthi for MMS-MD-SCF-0173--> 
		<input type='hidden' name='old_response_id' id='old_response_id' value='<%=responsibility_group%>' >
	    <input type='hidden' name='responsibility_group1' id='responsibility_group1' >
		<input type='hidden' name='response_status' id='response_status' value='N' >
		<!--Ended by Suji Keerthi for MMS-MD-SCF-0173-->
		<!--Added by Maheshwaran K for the Password Validation as on 11/07/2012
		Start-->
		<input type='hidden' name='unlock_yn' id='unlock_yn' >
		<input type='hidden' name='ws_no' id='ws_no' value=<%=ws_no%>>
		<!--	//Maheshwaran added for the MMS-QH-CRF-0149-->
		<input type='hidden' name='allowed_spl_char_in_password' id='allowed_spl_char_in_password' value='<%=java.net.URLEncoder.encode(ALLOWED_SPL_CHAR_IN_PASSWORD)%>'>
		<input type='hidden' name='enforce_password_policy_yn' id='enforce_password_policy_yn' value='<%=ENFORCE_PASSWORD_POLICY_YN%>'>
		<input type='hidden' name='case_sensitive_password_yn' id='case_sensitive_password_yn' value='<%=CASE_SENSITIVE_PASSWORD_YN%>'>		
		<input type='hidden' name='password_length_min' id='password_length_min' value=<%=PASSWORD_LENGTH_MIN%>>	
		<input type='hidden' name='password_length_max' id='password_length_max' value=<%=PASSWORD_LENGTH_MAX%>>	
		<input type='hidden' name='first_login_yn' id='first_login_yn' value=<%=FIRST_LOGIN_YN%>>		
		<!--End-->
		<!--Below line added for this SCF AMS-SCF-0597-->
		<input type='hidden' name='first_login' id='first_login' value=<%=FIRST_LOGIN_YN%>>
		<!--End this SCF AMS-SCF-0597-->		
		<input type='hidden' name='cur_date' id='cur_date' value='<%=dateFormat.format( new java.util.Date() ) %>' >

		<!--Added by Ashwini on 20-Jul-2020 for AMS-SCF-0888-->
		<input type='hidden' name='curr_effstatus' id='curr_effstatus' value=<%=effstatus%>>

		<!--Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2-->
		<input type='hidden' name='isSSOIntegrationAppl' id='isSSOIntegrationAppl' value=<%=isSSOIntegrationAppl%>>
		<input type='hidden' name='defpass_sso' id='defpass_sso' value=<%=defpass_sso%>>

<script>
function maxLength(field,maxChars)
{
      //if(field.value.length >= maxChars) {
	   if(field.value.length > maxChars) {
	     var errors1 = getMessage('OBJ_CANNOT_EXCEED','Common');
		errors1 = errors1.replace('$', maxChars);		  
		  alert(errors1); 
             field.select();
             field.focus();		  
         return false;
      }
	   else{
	     return true;
	   }
}    

function maxLengthPaste(field,maxChars)
{
     event.returnValue=false;
     if((field.value.length +  window.clipboardData.getData("Text").length) > maxChars) {	 
	     var errors1 = getMessage('OBJ_CANNOT_EXCEED','Common');
		errors1 = errors1.replace('$', maxChars);		  
		  alert(errors1);  
	    return false;
     }
     event.returnValue=true;
}
function ChkKey(evnt)
{ 
	if(evnt.keyCode == '13')
		return false;
}
</script>		

      	</form>
      	</body>
      	</html>
		<%
		}catch(Exception e){out.println(e);}
		finally { 
					ConnectionManager.returnConnection(conn,request);
				}	
		%>

