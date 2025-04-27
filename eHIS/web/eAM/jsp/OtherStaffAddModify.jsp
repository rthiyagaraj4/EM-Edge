<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*, java.lang.*,webbeans.eCommon.*" 
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%		
			String locale = (String)session.getAttribute("LOCALE");
			String otherstafftype="";
			String otherstaffid="";
			String otherstaffname="";
			String shortname="";
			String effstatus="";
			String Position="";
			String Position1="";
			String job_title="";
			String birthdate_disp="";
			String max_patient_age="";
			ArrayList position_list = new ArrayList();
		 otherstafftype = request.getParameter("other_staff_type")==null ? "":request.getParameter("other_staff_type");
		 otherstaffid = request.getParameter("other_staff_id")==null ? "":request.getParameter("other_staff_id");
		 otherstaffname = request.getParameter("other_staff_name")==null ? "":request.getParameter("other_staff_name");
		 shortname=request.getParameter("short_name")==null ? "":request.getParameter("short_name");
		 effstatus = request.getParameter("eff_staus")==null ? "":request.getParameter("eff_staus");

		  %>	
 <head>
		<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
        <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
      	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script src='../../eAM/js/OtherStaff.js' language='javascript'></script>
     	<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
		<script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

      </head>
<script>
var tabKeyFlag=false;
function scroll_vw()
{
	if(parent.frames[1].document.getElementById('identitylink')){
		parent.frames[1].document.getElementById('identitylink').scrollIntoView();
		}
}

function registerLastKey(evt){
	if(evt.keyCode==9) 
		tabKeyFlag=true; 
}

function getfocus()
{	
	if(tabKeyFlag){
	  if(document.getElementById("other_staff_type"))
	     document.getElementById("other_staff_type").focus();
      if(document.getElementById('other_staff_type2'))
          document.getElementById('other_staff_type2').focus();
	} 	
}
function tabfocus()
{	
	document.getElementById('sex').focus();	
}

</script>
     <%
      	Connection conn = null; 
		conn = ConnectionManager.getConnection(request);	

		/*Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011*/
		Boolean isResidencyApplYN = eCommon.Common.CommonBean.isSiteSpecific(conn, "SM", "NATID_MAND_PRACT_OTHSTAFF");
		Boolean isSplCharNotAllowApplYN = eCommon.Common.CommonBean.isSiteSpecific(conn, "AM", "SPL_CHAR_NOT_ALLOWED"); //Added by Suji Keerthi for MOHE-CRF-0113 US001
		String natid_mand_yn = eAM.AMCommonBean.getNatIdMandYN(conn);
		String oth_alt_val = eAM.AMCommonBean.getOthAltDefaultValue(conn, "SM", "NATID_MAND_PRACT_OTHSTAFF");
		String citizen_nat_code = "";
		String citizenship_code = "";
		String citizenChk = "Checked";
		String nonCitizenChk = "";
		String natIdDis = "";
		String nat_visibility = "";
		String other_alt_type_dis = "";
		String other_alt_no_dis = "disabled";
		String oth_alt_visibility = "hidden";
		String alt_id1_type = "";
		String alt_id1_length = "";
		String oth_alt_length = "20";
		/*End MOHE-CRF-0011*/
      	
      	String accept_national_id_no_yn = "N",nat_id_prompt="",nat_id_chk_len="",nat_id_check_digit_id="",nat_data_source_id="";
      		
		if(otherstaffid==null) otherstaffid = "null";
		String shortdesc="";
		String strt="";
    	String strt1="";
    	String strt2="";
      	String otherstafftype1="";
   	 	String str1="";
   	 	String strs1="";
   	 	String strs2="";
		String str2="";
		String strm1="";
		String strm2="";
		String str3="";
		String strc1="";
		String strc2="";
		String str4="";
		String strr1="";
		String strr2="";
		String str5="";
		String stre1="";
		String stre2="";
		String str6="";
		String strp1="";
		String strp2="";
		String str7="";
		String strrep1="";
		String strrep2="";
		String str8="";
		String strrec1="";
		String strrec2="";
		String strofp1="";
		String strofp2="";
		String str10="";
		String strofc1="";
		String strofc2="";
		String strmap1="";
		String strmap2="";
		String str12="";
		String strmac1="";
		String strmac2="";
		String str13="";
		String str14="";
		String sex="";
		String sex1="";
		String emplstatus="";
		String emplstatus1="";
		String prefmode="";
		String prefmode1="";
		String birthdate="";
		String birthplace="";
		String maritalstatus="";
		String maritaldesc="";
		String maritalstatus1="";
		String maritaldesc1="";
		String aliasname="";
		String citizen="";
		String citizendesc="";
		String citizen1="";
		String citizendesc1="";
		String nationalidno="";
		String shortdesc1="";
		String degree="";
		String repfacility="";
		String repfacilityname="";
		String repfacility1="";
		String repfacilityname1="";
		String allfacilities="";
		String restelnum="";
		String offtelnum="";
		String offtelext="";
		String pagernum="";
		String faxnum="";
		String mobilenum="";
		String emailid="";
		String resaddln1="";
		String resaddln2="";
		String resaddln3="";
		String resaddln4="";
		String offaddln1="";
		String offaddln2="";
		String offaddln3="";
		String offaddln4="";
		String mailaddln1="";
		String mailaddln2="";
		String mailaddln3="";
		String mailaddln4="";
		String respostalcode="";
		String offpostalcode="";
		String mailpostalcode="";
		String rescountrycode="";
		String rescountrydesc="";
		String rescountrycode1="";
		String rescountrydesc1="";
		String offcountrycode="";
		String offcountrydesc="";
		String offcountrycode1="";
		String offcountrydesc1="";
		String mailcountrycode="";
		String mailcountrydesc="";
		String mailcountrycode1="";
		String mailcountrydesc1="";
		String Position_one="";
		String sql11="";
		String bage="";
		String bmonths="";
		String bdays="";
		int count=0;
   	 	String codeTextAttribute="";
		String otherTextAttribute="";
		String checkBoxAttribute="";
		String checkBoxAttribute1="";
		String eventFunctionForCase="";
		String fcall="";		
		String cnc = "";
		String employeeid ="";
		String disablerecord="";
		String nat_id_accept_alphanumeric_yn="";
		String longname="";
		String longname1="";
		
		//Added HSA-CRF-160
		Statement other_altstat=null;
		ResultSet other_altrs=null;
		String alt_type_code="",alt_type_desc="",other_alt_type_no="",other_alt_type_desc="",other_alt_select="";


			PreparedStatement pstmtsv=null;
			ResultSet rsv = null;

		try{

			String sql_maxage="select max_patient_age, citizen_nationality_code citizen_nat_code, alt_id1_type, alt_id1_length from mp_param_lang_vw mp_param  WHERE  module_id = 'MP' AND language_id = '"+locale+"'";
			pstmtsv=conn.prepareStatement(sql_maxage);
			rsv=pstmtsv.executeQuery();
			if(rsv.next())
			{
		  		max_patient_age=rsv.getString("max_patient_age");
				//Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011
				citizen_nat_code = rsv.getString("citizen_nat_code");
				if (citizen_nat_code == null || citizen_nat_code.equals("null")) citizen_nat_code = "";
				alt_id1_type = rsv.getString("alt_id1_type");
				if (alt_id1_type == null || alt_id1_type.equals("null")) alt_id1_type = "";
				alt_id1_length = rsv.getString("alt_id1_length");
				if (alt_id1_length == null || alt_id1_length.equals("null")) alt_id1_length = "";

			}
			if(pstmtsv != null) pstmtsv.close();
		      if(rsv != null) rsv.close();

		    }catch(Exception e) {
		     out.println("errors="+e);
			 e.printStackTrace();
		     }

		PreparedStatement pstmt9=null;
		ResultSet rs9=null;
		String sql9="select to_char(sysdate,'dd/mm/yyyy') from dual";	
		pstmt9=conn.prepareStatement(sql9);
		rs9=pstmt9.executeQuery();
					  	
		if(rs9.next())
		{		  	
		str13=rs9.getString(1);
		}
			
	try{
      	boolean newOtherStaff=false;
   	 	fcall = request.getParameter("fcall")==null ? "":request.getParameter("fcall"); 

			String male=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			String female=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
			String unknown=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
			String defaultselect=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
			String associate=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Associate.label","common_labels");
			String fulltime=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FullTime.label","common_labels");
			String PartTime=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PartTime.label","common_labels");
			String Visitor=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Visitor.label","common_labels");
			String email=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.email.label","common_labels");
			String fax=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fax.label","common_labels");
			String mobile=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mobile.label","common_labels");
			String office=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.office.label","common_labels");
			String pager=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Pager.label","am_labels");
			String residence =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.residence.label","common_labels");
//out.println("<script>alert(\"otherstaffid:"+otherstaffid+"\");</script>");

   	 	if(otherstaffid==null || otherstaffid.equals("") || otherstaffid.equals("null")) 
			{
			
		  
   	 		otherstaffid = "";
			otherstaffname="";
			shortname="";
   	 		str1="<select name='sex' id='sex' ><option value='M'>"+male+"<option value='F'>"+female+"<option value='U'>"+unknown+"</select>";
			birthdate="";
			birthplace="";
   	 		PreparedStatement pstmtty = null;
			PreparedStatement pstmt = null;
			PreparedStatement pstmt1= null;
			PreparedStatement pstmt2= null;
   	 		PreparedStatement pstmt4=null;
			PreparedStatement pstmt6=null;
			PreparedStatement pstmt8=null;
			PreparedStatement pstmt10=null;
			PreparedStatement pstmtf=null;
			PreparedStatement pstmtc=null;
			ResultSet rst = null;
			ResultSet rs = null;
			ResultSet rs1 = null;
			ResultSet rs2 = null;
			ResultSet rs4= null;
			ResultSet rs6=null;
			ResultSet rs8=null;
			ResultSet rs10=null;
			ResultSet rsf=null;
			ResultSet rsc=null;

	

			
try{

			String sqlf="select count(*) as total from sm_facility_param";
			pstmtf=conn.prepareStatement(sqlf);
			rsf=pstmtf.executeQuery();
			if(rsf.next())
			{
				count=rsf.getInt("total");
			}if(pstmtf != null) pstmtf.close();
		      if(rsf != null) rsf.close();

		    }catch(Exception e) {
		     out.println("errors="+e);
			 e.printStackTrace();
		     }
		try {
		  	String sqlt="select other_staff_type,short_desc from am_other_staff_type where eff_status='E' order by short_desc";
		  	pstmtty=conn.prepareStatement(sqlt);
			rst=pstmtty.executeQuery();
		  	strt="<select name='other_staff_type' id='other_staff_type' onChange='checkPosition(this.form,this)' ><option value=''>---------"+defaultselect+"--------------";
		  	 while(rst.next()) 
		  	 {
		  		otherstafftype=rst.getString("other_staff_type");
		  		shortdesc=rst.getString("short_desc");
		  		strt=strt+"<option value='"+ otherstafftype+"' onClick='checkothersatff()' >"+shortdesc;

		  	 }if(pstmtty != null) pstmtty.close();
		      if(rst != null) rst.close();
		  	 
		  	strt=strt+"</select>";
			String sql="select mar_status_code,short_desc from mp_marital_status where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and 		  	nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by short_desc ";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			str2="<select name='marital_status' id='marital_status' ><option value=''>---"+defaultselect+"-----";
			 while(rs.next())
			 {
				maritalstatus=rs.getString("mar_status_code");
				if(maritalstatus == null) maritalstatus="";
				maritaldesc=rs.getString("short_desc");
				str2=str2+"<option value='"+maritalstatus+"'>"+maritaldesc+"</option>";
			 }if(pstmt != null) pstmt.close();
		      if(rs != null) rs.close();
			str2=str2+"</select>";
			String sqlc="select citizen_nationality_code from mp_param";
			pstmtc=conn.prepareStatement(sqlc);
			rsc=pstmtc.executeQuery();
			if(rsc != null)
			{		
				while(rsc.next())
				{
					cnc=rsc.getString("citizen_nationality_code");
				}	
			}if(pstmtc != null) pstmtc.close();
		      if(rsc != null) rsc.close();

			String sql1="select country_code,long_desc from mp_country where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')))  and long_desc is not null order by long_desc ";
			pstmt1=conn.prepareStatement(sql1);
			rs1=pstmt1.executeQuery();
			//Modified by Ashwini on 20-Mar-2020 for MOHE-CRF-0011
			if(isResidencyApplYN){
				str3="<select name='citizen' id='citizen' onChange='checkCitznOrNonCitzn();'><option value=''>---"+defaultselect+"-----"+"</option>";
			}else
			{
				str3="<select name='citizen' id='citizen'><option value=''>---"+defaultselect+"-----"+"</option>";
			}
			 while(rs1.next())
			 {
				citizen=rs1.getString("country_code");
				citizendesc=rs1.getString("long_desc");
				if(citizen==null) citizen = "";
				if(citizendesc==null) citizendesc = "";
				if(cnc==null) cnc = "";

				if(cnc.equals(citizen)) 
				{
					str3=str3+"<option value='"+citizen+"' selected>"+citizendesc+"</option>";
				}
				else 
				{
					str3=str3+"<option value='"+citizen+"'>"+citizendesc+"</option>";
				}
			 }
			 if(pstmt1 != null) pstmt1.close();
		      if(rs1 != null) rs1.close();
			str3=str3+"</select>";
			String sql2="select facility_id,facility_name from sm_facility_param where facility_type='F' and STATUS ='E' order by facility_name ";
			pstmt2=conn.prepareStatement(sql2);
			rs2=pstmt2.executeQuery();
			 while(rs2.next())
			 {
				repfacility=rs2.getString("facility_id");
				if(repfacility == null) repfacility="";
				repfacilityname=rs2.getString("facility_name");
				str4=str4+"<option value='"+repfacility+"'>"+repfacilityname+"</option>" ;
			 }if(pstmt2 != null) pstmt2.close();
		      if(rs2 != null) rs2.close();
			str4=str4+"</select>";
			String sql4="select country_code,short_name from mp_country where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by short_name";
			pstmt4=conn.prepareStatement(sql4);
			rs4=pstmt4.executeQuery();
			str8="<select name='res_add_country_code' id='res_add_country_code'><option value=''>---"+defaultselect+"-----"+"</option>";
			while(rs4.next())
			{
				rescountrycode=rs4.getString("country_code");
				rescountrydesc=rs4.getString("short_name");
				str8=str8+"<option value='"+rescountrycode+"'>"+rescountrydesc+"</option>";
			}if(pstmt4 != null) pstmt4.close();
		      if(rs4 != null) rs4.close();
			 str8=str8+"</select>";
			String sql6="select country_code,short_name from mp_country where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by short_name";
			pstmt6=conn.prepareStatement(sql6);
			rs6=pstmt6.executeQuery();
			str10="<select name='off_add_country_code' id='off_add_country_code'><option value=''>---"+defaultselect+"-----"+"</option>";
			 while(rs6.next())
		  	 {
		  		offcountrycode=rs6.getString("country_code");
		  		offcountrydesc=rs6.getString("short_name");
		  		str10=str10+"<option value='"+offcountrycode+"'>"+offcountrydesc+"</option>";
		  	 } if(pstmt6 != null) pstmt6.close();
		      if(rs6 != null) rs6.close();
		  	 str10=str10+"</select>";
		  	String sql8="select country_code,short_name from mp_country where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by short_name";
		   	pstmt8=conn.prepareStatement(sql8);
			rs8=pstmt8.executeQuery();
		  	str12="<select name='mail_add_country_code' id='mail_add_country_code' onBlur=document.getElementById('residencetelno').focus()><option value=''>---"+defaultselect+"-----"+"</option>";
		  	 while (rs8.next())
		  	 {
		  		mailcountrycode=rs8.getString("country_code");
		  		mailcountrydesc=rs8.getString("short_name");
		  		str12=str12+"<option value='"+mailcountrycode+"'>"+mailcountrydesc+"</option>";
		  	 }
			 if(pstmt8 != null) pstmt8.close();
		      if(rs8 != null) rs8.close();
		  	 str12=str12+"</select>";
		  	String sql10="select nat_id_length ,accept_national_id_no_yn,nat_id_prompt, nat_id_chk_len, nat_id_check_digit_id ,nat_data_source_id,nat_id_accept_alphanumeric_yn from mp_param";
		  	pstmt10=conn.prepareStatement(sql10);
		  	rs10=pstmt10.executeQuery();
		  	if(rs10 != null)
		  	{		
		  		while(rs10.next())
		  		{
		  			str14=rs10.getString(1);
		  			accept_national_id_no_yn=rs10.getString(2);
		  			if(accept_national_id_no_yn == null) accept_national_id_no_yn ="N";
		  			nat_id_prompt=rs10.getString(3);if(nat_id_prompt == null) nat_id_prompt="National ID  No";
		  			nat_id_chk_len=rs10.getString(4);if(nat_id_chk_len == null) nat_id_chk_len="";
		  			nat_id_check_digit_id=rs10.getString(5);if(nat_id_check_digit_id == null) nat_id_check_digit_id="";
		  			nat_data_source_id=rs10.getString(6);if(nat_data_source_id == null) nat_data_source_id="";
					nat_id_accept_alphanumeric_yn=rs10.getString("nat_id_accept_alphanumeric_yn")==null?"N":rs10.getString("nat_id_accept_alphanumeric_yn");
		  			
		  		}	
		  	}	
			if(pstmt10 != null) pstmt10.close();
		      if(rs10 != null) rs10.close();
		 }catch(Exception e)
		{
			out.println("ERROR is -->"+e);
			e.printStackTrace();
		}finally
		{
			if (rst != null) rst.close();
			if (rs != null) rs.close();
			if (rs1 != null) rs1.close();
			if (rs2 != null) rs2.close();
			if (rs4 != null) rs4.close();
			if (rs6 != null) rs6.close();
			if (rs8 != null) rs8.close();
			if (rs9 != null) rs9.close();
			if (rs10 != null) rs10.close();
			if (rsc != null) rsc.close();
			if (rsf != null) rsf.close();
			if (pstmtty != null)pstmtty.close();
			if (pstmt != null)  pstmt.close();
			if (pstmt1 != null) pstmt1.close();
			if (pstmt2 != null) pstmt2.close();
			if (pstmt4 != null) pstmt4.close();
			if (pstmt6 != null) pstmt6.close();
			if (pstmt8 != null) pstmt8.close();
			if (pstmt9 != null) pstmt9.close();
			if (pstmt10 != null)pstmt10.close();
			if (pstmtc != null) pstmtc.close();

		}

		effstatus="E";
		bage="";
		aliasname="";
		nationalidno="";
		Position="";
		str5="<select name='empl_status' id='empl_status' onChange='echeck1(this);'><option value=''>----------"+defaultselect+"---------<option value='S'>"+associate+"<option value='F'>"+fulltime+"<option value='P'>"+PartTime+"<option value='V'>"+Visitor+"</select>";
		degree="";
		allfacilities="N";
		restelnum="";
		offtelnum="";
		offtelext="";
		pagernum="";
		faxnum="";
		mobilenum="";
		emailid="";
		str6="<select name='pref_contact_mode' id='pref_contact_mode'><option value=''>----------"+defaultselect+"---------<option value='E'>"+email+"<option value='F'>"+fax+"<option value='M'>"+mobile+"<option value='O'>"+office+"<option value='P'>"+pager+"<option value='R'>"+residence+"</select>";
		resaddln1="";
		resaddln2="";
		resaddln3="";
		resaddln4="";
		offaddln1="";
		offaddln2="";
		offaddln3="";
		offaddln4="";
		mailaddln1="";
		mailaddln2="";
		mailaddln3="";
		mailaddln4="";
		codeTextAttribute="";
		otherTextAttribute="";
		checkBoxAttribute="CHECKED";
		if(allfacilities.equals("N"))
				checkBoxAttribute1=" ";
		else
			checkBoxAttribute1="CHECKED";

		if(allfacilities.equals("N"))
				checkBoxAttribute1=" ";
		else
			checkBoxAttribute1="CHECKED";
		newOtherStaff=true;
		//Below Modified by Suji Keerthi for PAS-OP-MOHE-CRF-0113/01-OP Code Setup-Clinic
		if(isSplCharNotAllowApplYN)
			{
			eventFunctionForCase="OnBlur='ChangeUpperCase(this);CheckSplCharsforIdValidation(this)'";		
			}
			else 
			{
			eventFunctionForCase="OnBlur='ChangeUpperCase(this)'";		
			}
		}
	else
	{

		PreparedStatement pstmtstmt=null;
		PreparedStatement pstmt10=null;
		PreparedStatement pstmt11=null;
		PreparedStatement pstmt12=null;
		PreparedStatement pstmt13=null;
		PreparedStatement pstmt14=null;
		PreparedStatement pstmt15=null;
		PreparedStatement pstmt17=null;
		PreparedStatement pstmt19=null;
		PreparedStatement pstmt21=null;
		PreparedStatement pstmt25=null;
		PreparedStatement pstmt26=null;
		PreparedStatement pstmt27=null;
		PreparedStatement pstmtp=null;
		PreparedStatement pstmtm=null;
		PreparedStatement pstmtc=null;
		PreparedStatement pstmtr=null;
		PreparedStatement pstmtrec=null;
		PreparedStatement pstmtofc=null;
		PreparedStatement pstmtmac=null;
		PreparedStatement pstmtf=null;
		ResultSet rset=null;
		ResultSet rs10=null;
		ResultSet rs12=null;
		ResultSet rs13=null;
		ResultSet rs14=null;
		ResultSet rs15=null;
		ResultSet rs17=null;
		ResultSet rs19=null;
		ResultSet rs21=null;
		ResultSet rs25=null;
		ResultSet rs26=null;
		ResultSet rs27=null;
		ResultSet rsp=null;
		ResultSet rsm=null;
		ResultSet rsc=null;
		ResultSet rsr=null;
		ResultSet rsrec=null;
		ResultSet rsofc=null;
		ResultSet rsmac=null;
		ResultSet rsf=null;
		ResultSet rss=null;
try{
					String sqlf="select count(*) as total from sm_facility_param";
					pstmtf=conn.prepareStatement(sqlf);
					rsf=pstmtf.executeQuery();
					if(rsf != null)
					{     
						while(rsf.next())
						{
							count=rsf.getInt("total");
						}	
					}	if(pstmtf != null) pstmtf.close();
		      if(rsf != null) rsf.close();

				    }catch(Exception e) {
				    out.println("errors="+e);
					e.printStackTrace();
				     }
		
	try
		{   
		//Modified for this HAS-CRF-160
		
			sql11 ="select other_staff_id,other_staff_name,short_name,other_staff_type,gender,date_of_birth,place_of_birth,mar_status_code,alias_name,citizenship_code,national_id_num,position_code,empl_status,employee_id,degree,all_facilities_yn,reporting_facility_id,res_tel_num,pager_num,mobile_num,off_tel_num,off_tel_ext,fax_num,email_id,pref_contact_mode,res_add_ln1,res_add_ln2,res_add_ln3,res_add_ln4,res_add_postal_code,res_add_country_code,off_add_ln1,off_add_ln2,off_add_ln3,off_add_ln4,off_add_postal_code,off_add_country_code,mail_add_ln1,mail_add_ln2,mail_add_ln3,mail_add_ln4,mail_add_postal_code,mail_add_country_code,eff_date_from,eff_date_to,eff_status ,JOB_TITLE,LONG_NAME,OTH_ALT_ID_TYPE, OTH_ALT_ID_NO from am_other_staff where other_staff_id=?";			
			pstmt11 = conn.prepareStatement(sql11);
			pstmt11.setString(1,otherstaffid);
			rset=pstmt11.executeQuery();
			System.out.println("rset"+rset);
			rset.next();
			  	otherstaffid=rset.getString("other_staff_id");
				otherstaffname=rset.getString("other_staff_name");
				shortname=rset.getString("short_name");
				 sex=rset.getString("gender");
				 allfacilities=rset.getString("all_facilities_yn");
				
				employeeid=rset.getString("employee_id");
				 otherstafftype=rset.getString("other_staff_type");
				 Position=rset.getString("position_code");
				 System.out.println("Position"+Position);
				job_title=rset.getString("JOB_TITLE");
				longname=rset.getString("LONG_NAME");
				if(longname == null) longname = "";
				
				//Added  for this HAS-CRF-160
				other_alt_type_no=rset.getString("OTH_ALT_ID_TYPE")==null?"":rset.getString("OTH_ALT_ID_TYPE");
                other_alt_type_desc=rset.getString("OTH_ALT_ID_NO")==null?"":rset.getString("OTH_ALT_ID_NO");
				
				//Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011
				citizenship_code = rset.getString("citizenship_code");
				if(citizenship_code == null) citizenship_code = "";
				
				 if(Position==null || Position.equals("null"))
			{
                 Position="";
			}
				 effstatus=rset.getString("eff_status");
				 System.out.println("effstatus"+effstatus);
				 
		try
			{
						
				if(effstatus.equals("E"))
				{
				String sqlsql="select position_desc,position_code from am_position where role_type='O' and (staff_type is null or staff_type=?) and eff_status='E' order by position_desc";
				pstmtstmt=conn.prepareStatement(sqlsql);
				System.out.println("sqlsql"+sqlsql);
				pstmtstmt.setString(1,otherstafftype);
				
				rss=pstmtstmt.executeQuery();
				System.out.println("rss"+rss);
				while(rss.next())
				{
					position_list.add(rss.getString("position_code"));
					position_list.add(rss.getString("position_desc"));

					Position_one=rss.getString("position_code");
					Position1=rss.getString("position_desc");
				}
				System.out.println("position_list"+position_list);
				
				if(pstmtstmt != null) pstmtstmt.close();
		      if(rss != null) rss.close();
				}
				else
				{
					String sqlsql="select position_desc,position_code from am_position where role_type='O' and (staff_type is null or staff_type=?) and eff_status='E' and position_code='"+Position+"' order by position_desc";
					pstmtstmt=conn.prepareStatement(sqlsql);
					pstmtstmt.setString(1,otherstafftype);
					rss=pstmtstmt.executeQuery();
					while(rss.next())
						{
							
							Position=rss.getString("position_code");
							Position1=rss.getString("position_desc");

					
						}
						if(pstmtstmt != null) pstmtstmt.close();
		      if(rss != null) rss.close();
				}
			}catch(Exception e)
				{
					e.printStackTrace();
				}
		if (sex.equals("M")) 
			{
				sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				str1="<select name='sex' id='sex' onClick='check2()' >";
				str1=str1+"<option value='M' selected>"+male+"<option value='F'>"+female+"<option value='U'>"+unknown+" </select>";
				strs1="<input type='text' name='sex1' id='sex1' size='7' maxlength='7' value='"+sex1+"' readonly>";
				strs2="<input type='hidden' name='sex2' id='sex2' size='15' maxlength='15' value='"+sex+"' >";
			}
			else if (sex.equals("F")) 
			{
				sex1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
				str1="<select name='sex' id='sex' onClick='check2()'>";
				str1=str1+"<option value='M' >"+male+"<option value='F' selected>"+female+"<option value='U'>"+unknown+" </select>";
				strs1="<input type='text' name='sex1' id='sex1' size='7' maxlength='7' value='"+sex1+"' readonly>";
				strs2="<input type='hidden' name='sex2' id='sex2' size='15' maxlength='15' value='"+sex+"' >";
			}
			else if (sex.equals("U")) 
			{
				sex1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
				str1="<select name='sex' id='sex' onClick='check2()'>";
				str1=str1+"<option value='M' >"+male+"<option value='F'>"+female+"<option value='U' selected>"+unknown+" </select>";
				strs1="<input type='text' name='sex1' id='sex1' size='7' maxlength='7' value='"+sex1+"' readonly>";
				strs2="<input type='hidden' name='sex2' id='sex2' size='15' maxlength='15' value='"+sex+"' >";
			}
				emplstatus=rset.getString("empl_status");
				
				if(emplstatus.equals("F")) 
				{
					emplstatus1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FullTime.label","common_labels");
					str5="<select name='empl_status' id='empl_status' onClick='check3();'>";
                        		str5=str5+"<option value=>---"+defaultselect+"-----";
					stre2="<input type='hidden' name='empl_status2' id='empl_status2' size='15' maxlength='15' value='"+emplstatus+"'>";
					str5=str5+"<option value='S'>"+associate+"<option value='F' selected>"+fulltime+"<option value='P'>"+PartTime+"<option value='V'>"+Visitor+" </select>";
					stre1="<input type='text' name='empl_status1' id='empl_status1' size='15' maxlength='15' value='"+emplstatus1+"' readonly>";
					
				}
				else if (emplstatus.equals("P")) 
				{
					emplstatus1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PartTime.label","common_labels");
					str5="<select name='empl_status' id='empl_status' onClick='check3();'>";
					str5=str5+"<option value=>---"+defaultselect+"-----";
					stre2="<input type='hidden' name='empl_status2' id='empl_status2' size='15' maxlength='15' value='"+emplstatus+"'>";
					str5=str5+"<option value='S'>"+associate+"<option value='F' >"+fulltime+"<option value='P' selected>"+PartTime+"<option value='V'>"+Visitor+" </select>";
					stre1="<input type='text' name='empl_status1' id='empl_status1' size='15' maxlength='15' value='"+emplstatus1+"' readonly>";
					
				}
				else if (emplstatus.equals("V")) 
				{
					emplstatus1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Visitor.label","common_labels");
					str5="<select name='empl_status' id='empl_status' onClick='check3();echeck10()'>";
					str5=str5+"<option value=>---"+defaultselect+"-----";
					stre2="<input type='hidden' name='empl_status2' id='empl_status2' size='15' maxlength='15' value='"+emplstatus+"'>";
					str5=str5+"<option value='S'>"+associate+" <option value='F' >"+fulltime+"<option value='P'>"+PartTime+"<option value='V' selected>"+Visitor+"</select>";
					stre1="<input type='text' name='empl_status1' id='empl_status1' size='15' maxlength='15' value='"+emplstatus1+"' readonly>";
				}
				else if(emplstatus.equals("S")) 
				{
					emplstatus1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Associate.label","common_labels");
					str5="<select name='empl_status' id='empl_status' onClick='check3();'>";
					str5=str5+"<option value=>---"+defaultselect+"-----";
					stre2="<input type='hidden' name='empl_status2' id='empl_status2' size='15' maxlength='15' value='"+emplstatus+"'>";
					str5=str5+"<option value='S' selected>"+associate+" <option value='F' >"+fulltime+"<option value='P'>"+PartTime+"<option value='V' >"+Visitor+"</select>";
					stre1="<input type='text' name='empl_status1' id='empl_status1' size='15' maxlength='15' value='"+emplstatus1+"' readonly>";
					
				}

			prefmode=rset.getString("pref_contact_mode");
			if(prefmode != null) 
				{
					 if (prefmode.equals("R")) 
					 {															
						 prefmode1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.residence.label","common_labels");
						str6="<select name='pref_contact_mode' id='pref_contact_mode' onClick='check4()'><option value=''>---"+defaultselect+"-----";
						str6=str6+"<option value='E'>"+email+"<option value='F'>"+fax+"<option value='M'>"+mobile+"<option value='O'>"+office+"<option value='P'>"+pager+"<option value='R' selected>"+residence+" </select>";
						strp1="<input type='text' name='pref_contact_mode1' id='pref_contact_mode1' size='15' maxlength='15' value='"+prefmode1+"' readonly>";
						strp2="<input type='hidden' name='pref_contact_mode2' id='pref_contact_mode2' size='15' maxlength='15' value='"+prefmode+"' >";
					}
					else if (prefmode.equals("O")) 
					{
						prefmode1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.office.label","common_labels");
						str6="<select name='pref_contact_mode' id='pref_contact_mode' onClick='check4()'><option value=''>---"+defaultselect+"-----";
						str6=str6+"<option value='E'>"+email+"<option value='F'>"+fax+"<option value='M'>"+mobile+"<option value='O' selected>"+office+"<option value='P'>"+pager+"<option value='R'>"+residence+" </select>";
						strp1="<input type='text' name='pref_contact_mode1' id='pref_contact_mode1' size='15' maxlength='15' value='"+prefmode1+"' readonly>";
						strp2="<input type='hidden' name='pref_contact_mode2' id='pref_contact_mode2' size='15' maxlength='15' value='"+prefmode+"' >";
					}
					else if(prefmode.equals("F")) 
					{
						prefmode1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fax.label","common_labels");
						str6="<select name='pref_contact_mode' id='pref_contact_mode' onClick='check4()'><option value=''>---"+defaultselect+"-----";
						str6=str6+"<option value='E'>"+email+"<option value='F' selected>"+fax+"<option value='M'>"+mobile+"<option value='O'>"+office+"<option value='P'>"+pager+"<option value='R' >"+residence+" </select>";
						strp1="<input type='text' name='pref_contact_mode1' id='pref_contact_mode1' size='15' maxlength='15' value='"+prefmode1+"' readonly>";
						strp2="<input type='hidden' name='pref_contact_mode2' id='pref_contact_mode2' size='15' maxlength='15' value='"+prefmode+"' >";
					}
					else if(prefmode.equals("M")) 
					{
						prefmode1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fax.label","common_labels");
						str6="<select name='pref_contact_mode' id='pref_contact_mode' onClick='check4()'><option value=''>---"+defaultselect+"-----";
						str6=str6+"<option value='E'>"+email+"<option value='F'>"+fax+"<option value='M' selected>"+mobile+"<option value='O'>"+office+"<option value='P'>"+pager+"<option value='R' >"+residence+" </select>";
						strp1="<input type='text' name='pref_contact_mode1' id='pref_contact_mode1' size='15' maxlength='15' value='"+prefmode1+"' readonly>";
						strp2="<input type='hidden' name='pref_contact_mode2' id='pref_contact_mode2' size='15' maxlength='15' value='"+prefmode+"' >";
					}
					else if(prefmode.equals("P")) 
					{
						prefmode1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Pager.label","am_labels");
						str6="<select name='pref_contact_mode' id='pref_contact_mode' onClick='check4()'><option value=''>---"+defaultselect+"-----";
						str6=str6+"<option value='E'>"+email+"<option value='F'>"+fax+"<option value='M'>"+mobile+"<option value='O'>"+office+"<option value='P' selected>"+pager+"<option value='R'>"+residence+" </select>";
						strp1="<input type='text' name='pref_contact_mode1' id='pref_contact_mode1' size='15' maxlength='15' value='"+prefmode1+"' readonly>";
						strp2="<input type='hidden' name='pref_contact_mode2' id='pref_contact_mode2' size='15' maxlength='15' value='"+prefmode+"' >";
					}
					else if(prefmode.equals("E")) 
					{
						prefmode1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.email.label","common_labels");
						str6="<select name='pref_contact_mode' id='pref_contact_mode' onClick='check4()'><option value=''>---"+defaultselect+"-----";
						str6=str6+"<option value='E' selected>"+email+"<option value='F'>"+fax+"<option value='M'>"+mobile+"<option value='O'>"+office+"<option value='P'>"+pager+"<option value='R'>"+residence+" </select>";
						strp1="<input type='text' name='pref_contact_mode1' id='pref_contact_mode1' size='15' maxlength='15' value='"+prefmode1+"' readonly>";
						strp2="<input type='hidden' name='pref_contact_mode2' id='pref_contact_mode2' size='15' maxlength='15' value='"+prefmode+"' >";
					}
					else if(prefmode.equals(" ") || prefmode.equals("null")) 
					{
						prefmode1="---"+defaultselect+"-----";
						str6="<select name='pref_contact_mode' id='pref_contact_mode' onClick='check4()'><option value='' selected>---"+defaultselect+"-----";
						str6=str6+"<option value='E'>"+email+"<option value='F'>"+fax+"<option value='M'>"+mobile+"<option value='O'>"+office+"<option value='P'>"+pager+"<option value='R'>"+residence+" </select>";
						strp1="<input type='text' name='pref_contact_mode1' id='pref_contact_mode1' size='15' maxlength='15' value='"+prefmode1+"' readonly>";
						strp2="<input type='hidden' name='pref_contact_mode2' id='pref_contact_mode2' size='15' maxlength='15' value='"+prefmode+"' >";
					}
			     }else{
					prefmode=" ";
					prefmode1=" ";
			str6="<select name='pref_contact_mode' id='pref_contact_mode' onClick='check4()'><option value='' selected>---"+defaultselect+"-----";
			str6=str6+"<option value='E'>"+email+"<option value='F'>"+fax+"<option value='M'>"+mobile+"<option value='O'>"+office+"<option value='P'>"+pager+"<option value='R' selected>"+residence+" </select>";
					strp1="<input type='text' name='pref_contact_mode1' id='pref_contact_mode1' size='15' maxlength='15' value='"+prefmode1+"' readonly>";
					strp2="<input type='hidden' name='pref_contact_mode2' id='pref_contact_mode2' size='15' maxlength='15' value='"+prefmode+"' >";
			     }

			java.util.Date date2 = rset.getDate("date_of_birth");
			SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
			birthdate=formatter1.format(date2);
			birthdate_disp=DateUtils.convertDate(birthdate,"DMY","en",localeName);

			formatter1 = null;
			String sqldb="select calculate_age(?,1) from dual";
			pstmt25=conn.prepareStatement(sqldb);
			pstmt25.setString(1,birthdate);
			rs25=pstmt25.executeQuery();
			
			if(rs25 != null)
			{
				while(rs25.next())
				{
					bage=rs25.getString(1);
				}	
			}

			
			
			if (rs25 != null) rs25.close();
		if (pstmt25 != null) pstmt25.close();
			if(bage==null) bage="";
			String sqldb1="select calculate_age(?,2) from dual";
			pstmt26=conn.prepareStatement(sqldb1);
			pstmt26.setString(1,birthdate);
			rs26=pstmt26.executeQuery();
			if(rs26 != null )
			{
				while(rs26.next())
				{
					bmonths=rs26.getString(1);
				}	
			}if (rs26 != null) rs26.close();
		     if (pstmt26 != null) pstmt26.close();
			
			if(bmonths==null) bmonths="";
			String sqldb2="select calculate_age(?,3) from dual";
			pstmt27=conn.prepareStatement(sqldb2);
			pstmt27.setString(1,birthdate);
			rs27=pstmt27.executeQuery();
			if(rs27 != null )
			{
				while(rs27.next())	
				{
					bdays=rs27.getString(1);
				}	
			}	if (rs27 != null) rs27.close();
		     if (pstmt27 != null) pstmt27.close();
			if(bdays==null) bdays="";
			birthplace=rset.getString("place_of_birth");
			if(birthplace == null) birthplace="";

			aliasname=rset.getString("alias_name");
			if(aliasname == null) aliasname="";
			nationalidno=(rset.getString("national_id_num")==null || rset.getString("national_id_num").equals("null"))? "":rset.getString("national_id_num");
			degree=rset.getString("degree");
			if(degree == null) degree="";
			restelnum=rset.getString("res_tel_num");
			if(restelnum==null) restelnum="";
			pagernum=rset.getString("pager_num");
			if(pagernum==null) pagernum="";
			mobilenum=rset.getString("mobile_num");
			if(mobilenum==null) mobilenum="";
			offtelnum=rset.getString("off_tel_num");
			if(offtelnum==null) offtelnum="";
			offtelext=rset.getString("off_tel_ext");
			if(offtelext==null) offtelext="";
			faxnum=rset.getString("fax_num");
			if(faxnum==null) faxnum="";
			emailid=rset.getString("email_id");
			if(emailid==null) emailid="";
			resaddln1=rset.getString("res_add_ln1");
			if(resaddln1==null) resaddln1="";
			resaddln2=rset.getString("res_add_ln2");
			if(resaddln2==null) resaddln2="";
			resaddln3=rset.getString("res_add_ln3");
			if(resaddln3==null) resaddln3="";
			resaddln4=rset.getString("res_add_ln4");
			if(resaddln4==null) resaddln4="";
			offaddln1=rset.getString("off_add_ln1");
			if(offaddln1==null) offaddln1="";
			offaddln2=rset.getString("off_add_ln2");
			if(offaddln2==null) offaddln2="";
			offaddln3=rset.getString("off_add_ln3");
			if(offaddln3==null) offaddln3="";
			offaddln4=rset.getString("off_add_ln4");
			if(offaddln4==null) offaddln4="";
			mailaddln1=rset.getString("mail_add_ln1");
			if(mailaddln1==null) mailaddln1="";
			mailaddln2=rset.getString("mail_add_ln2");
			if(mailaddln2==null) mailaddln2="";
			mailaddln3=rset.getString("mail_add_ln3");
			if(mailaddln3==null) mailaddln3="";
			mailaddln4=rset.getString("mail_add_ln4");
			if(mailaddln4==null) mailaddln4="";
			if ( rset.getDate("eff_date_from") != null )
			{
				//java.util.Date date = rset.getDate("eff_date_from");
				// formatter = new SimpleDateFormat ("dd/MM/yyyy");
				//date = null;
				//formatter = null;
			}
			if ( rset.getDate("eff_date_to") != null)
			{
				//java.util.Date date1 = rset.getDate("eff_date_to");
				// formatter = new SimpleDateFormat ("dd/MM/yyyy");
				
			        //date1 = null;
				//formatter = null;
			}

			effstatus=rset.getString("eff_status");
			if(effstatus.equals("D"))
			{
				otherTextAttribute="READONLY";
				disablerecord="disabled";
				checkBoxAttribute="";

			}else
			{

				otherTextAttribute="";
				checkBoxAttribute="CHECKED";
 			}
			String sql10="select nat_id_length ,accept_national_id_no_yn,nat_id_prompt, nat_id_chk_len, nat_id_check_digit_id ,nat_data_source_id, nat_id_accept_alphanumeric_yn from mp_param";
			pstmt10=conn.prepareStatement(sql10);
			rs10=pstmt10.executeQuery();
			if(rs10 != null)
			{		
				while(rs10.next())
				{
					str14=rs10.getString(1);
					accept_national_id_no_yn=rs10.getString(2);
					if(accept_national_id_no_yn == null) accept_national_id_no_yn="N";
					nat_id_prompt=rs10.getString(3);if(nat_id_prompt == null) nat_id_prompt="National ID No";
					nat_id_chk_len=rs10.getString(4);if(nat_id_chk_len == null) nat_id_chk_len="";
					nat_id_check_digit_id=rs10.getString(5);if(nat_id_check_digit_id == null) nat_id_check_digit_id="";
					nat_data_source_id=rs10.getString(6);if(nat_data_source_id == null) nat_data_source_id="";
					
					allfacilities=rset.getString("all_facilities_yn");
					nat_id_accept_alphanumeric_yn=rs10.getString("nat_id_accept_alphanumeric_yn")==null?"N":rs10.getString("nat_id_accept_alphanumeric_yn");
				}	
			}	if (rs10 != null) rs10.close();
		         if (pstmt10 != null) pstmt10.close();
			if(effstatus.equals("E") || effstatus.equals("D"))
			{
				if(allfacilities.equals("Y"))
					checkBoxAttribute1="CHECKED";
				else
					checkBoxAttribute1=" ";
			}
			respostalcode=rset.getString("res_add_postal_code");
			if(respostalcode==null || respostalcode.equals("null"))respostalcode="";
			strrep1="<input type='text' name='res_add_postal_code2' id='res_add_postal_code2' size='15' maxlength='15' value='"+respostalcode+"' readonly>";
			rescountrycode=rset.getString("res_add_country_code");
			if(rescountrycode != null)
			{
				String sqlrec="select short_name from mp_country where country_code=? ";
				pstmtrec=conn.prepareStatement(sqlrec);
				pstmtrec.setString(1,rescountrycode);
				rsrec=pstmtrec.executeQuery();
				if(rsrec != null )
				{
					while(rsrec.next())
					{
						rescountrydesc=rsrec.getString("short_name");
					}	
				}	if (rsrec != null) rsrec.close();
		if (pstmtrec != null) pstmtrec.close();
			}
			else
			{
				rescountrydesc=" ";
			}
			String sql17="select country_code,short_name from mp_country where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by short_name";
			pstmt17=conn.prepareStatement(sql17);
			rs17=pstmt17.executeQuery();
			str8="<select name='res_add_country_code' id='res_add_country_code' onClick='check9()'><option value=''>---"+defaultselect+"-----";
			if(rs17 !=null)
			{
			 while(rs17.next())
			 {
				rescountrycode1=rs17.getString("country_code");
				rescountrydesc1=rs17.getString("short_name");
				if((rescountrycode1.equals(rescountrycode)) && (rescountrydesc1.equals(rescountrydesc)))
				{

					str8=str8+"<option value='"+rescountrycode1+"' selected>"+rescountrydesc1;
				}
				else 
				{
					str8=str8+"<option value='"+rescountrycode1+"' >"+rescountrydesc1;
				}
			 }
			} if (rs17 != null) rs17.close();
		if (pstmt17 != null) pstmt17.close();
			str8=str8+"</select>";
			strrec1="<input type='text' name='res_add_country_code1' id='res_add_country_code1' size='15' maxlength='15' value='"+rescountrydesc+"' readonly>";
			if(rescountrycode == null) 
			{
				strrec2="<input type='hidden' name='res_add_country_code2' id='res_add_country_code2' size='15' maxlength='15' value='' >";
			}
			else if(rescountrycode != null) 
			{
				if(effstatus.equals("E")) 
				{
					strrec2="<input type='hidden' name='res_add_country_code2' id='res_add_country_code2' size='15' maxlength='15' value='"+rescountrycode+"' >";
				}
				else if(effstatus.equals("D")) 
				{
					strrec2="<input type='hidden' name='res_add_country_code2' id='res_add_country_code2' size='15' maxlength='15' value='"+rescountrycode+"' >";
				}
			}

			offpostalcode=rset.getString("off_add_postal_code");
			if(offpostalcode==null || offpostalcode.equals("null")) offpostalcode="";
			strofp1="<input type='text' name='off_add_postal_code2' id='off_add_postal_code2' size='15' maxlength='15' value='"+offpostalcode+"' readonly>";
			offcountrycode=rset.getString("off_add_country_code");
			if(offcountrycode != null)
			{
					String sqlofc="select short_name from mp_country where country_code=? ";
					pstmtofc=conn.prepareStatement(sqlofc);
					pstmtofc.setString(1,offcountrycode);
					rsofc=pstmtofc.executeQuery();
					if(rsofc != null)
					{
						while(rsofc.next())
						{
							offcountrydesc=rsofc.getString("short_name");
						}	
					}	if (rsofc != null) rsofc.close();
		                if (pstmtofc != null) pstmtofc.close();
			}
			else
			{
					offcountrydesc= " ";
			}

			String sql19="select country_code,short_name from mp_country where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by short_name";
			pstmt19=conn.prepareStatement(sql19);
			rs19=pstmt19.executeQuery();

			str10="<select name='off_add_country_code' id='off_add_country_code' onClick='check11()'><option value=''>---"+defaultselect+"-----";
			if(rs19 != null )
			{
			 while(rs19.next())
			 {
				offcountrycode1=rs19.getString("country_code");
				offcountrydesc1=rs19.getString("short_name");
				if((offcountrycode1.equals(offcountrycode)) && (offcountrydesc1.equals(offcountrydesc)) && (offcountrycode != null) && (!offcountrydesc.equals(" ")))
				{
					str10=str10+"<option value='"+offcountrycode1+"' selected>"+offcountrydesc1;
				}
				else if((!offcountrycode1.equals(offcountrycode)) && (!offcountrydesc1.equals(offcountrydesc)) && (offcountrycode != null) && (!offcountrydesc.equals(" ")))
				{
					str10=str10+"<option value='"+offcountrycode1+"' >"+offcountrydesc1;
				}
				else if((offcountrycode == null) && (offcountrydesc.equals(" ")))
				{
					str10=str10+"<option value='"+offcountrycode1+"' >"+offcountrydesc1;
				}

			 }
			}   
			
			if (rs19 != null) rs19.close();
		                if (pstmt19 != null) pstmt19.close();
			str10=str10+"</select>";
			strofc1="<input type='text' name='off_add_country_code1' id='off_add_country_code1' size='15' maxlength='15' value='"+offcountrydesc+"' readonly>";
			if(offcountrycode == null)
			{
				strofc2="<input type='hidden' name='off_add_country_code2' id='off_add_country_code2' size='15' maxlength='15' value='' >";
			}
			else if(offcountrycode != null)
			{
				if(effstatus.equals("E"))
				{
				strofc2="<input type='hidden' name='off_add_country_code2' id='off_add_country_code2' size='15' maxlength='15' value='"+offcountrycode+"' >";
				}
				else if(effstatus.equals("D"))
				{
				strofc2="<input type='hidden' name='off_add_country_code2' id='off_add_country_code2' size='15' maxlength='15' value='"+offcountrycode+"' >";
				}
			}

			mailpostalcode=rset.getString("mail_add_postal_code");
			if(mailpostalcode==null || mailpostalcode.equals("null")) mailpostalcode="";
			
			
			strmap1="<input type='text' name='mail_add_postal_code2' id='mail_add_postal_code2' size='15' maxlength='15' value='"+mailpostalcode+"' readonly>";
			
			mailcountrycode=rset.getString("mail_add_country_code");
			if(mailcountrycode != null)
			{
			String sqlmac="select short_name from mp_country where country_code=? ";
			pstmtmac=conn.prepareStatement(sqlmac);
			pstmtmac.setString(1,mailcountrycode);
			rsmac=pstmtmac.executeQuery();
			
			  if(rsmac != null)
			  {
			   while(rsmac.next())
			  	{
			 		mailcountrydesc =rsmac.getString("short_name");
			 	}	
			  }			if (rsmac != null) rsmac.close();
		                if (pstmtmac != null) pstmtmac.close();
			}
			else
			{
				mailcountrydesc=" ";
			}

			String sql21="select country_code,short_name from mp_country where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')))order by short_name";
			pstmt21=conn.prepareStatement(sql21);
			rs21=pstmt21.executeQuery();
			str12="<select name='mail_add_country_code' id='mail_add_country_code' onClick='check13()'><option value=''>---"+defaultselect+"-----";
			if(rs21 != null )
			{
			 while(rs21.next())
			 {
					mailcountrycode1=rs21.getString("country_code");
					mailcountrydesc1=rs21.getString("short_name");
					if((mailcountrycode1.equals(mailcountrycode)) && (mailcountrydesc1.equals(mailcountrydesc)) && (mailcountrycode != null) && (!mailcountrydesc.equals(" ")))
					{
						str12=str12+"<option value='"+mailcountrycode1+"' selected>"+mailcountrydesc1;
					}
					else if((!mailcountrycode1.equals(mailcountrycode)) && (!mailcountrydesc1.equals(offcountrydesc)) && (offcountrycode != null) && (!offcountrydesc.equals(" ")))
					{
						str12=str12+"<option value='"+mailcountrycode1+"' >"+mailcountrydesc1;
					}
					else if((mailcountrycode == null) && (mailcountrydesc.equals(" ")))
					{
						str12=str12+"<option value='"+mailcountrycode1+"' >"+mailcountrydesc1;
					}

			 }
			} if (rs21 != null) rs21.close();
		                if (pstmt21 != null) pstmt21.close();
			
			str12=str12+"</select>";
			strmac1="<input type='text' name='mail_add_country_code1' id='mail_add_country_code1' size='15' maxlength='15' value='"+mailcountrydesc+"' readonly onBlur='document.getElementById('residencetelno').focus()'>";
			if(mailcountrycode == null)
			{
				strmac2="<input type='hidden' name='mail_add_country_code2' id='mail_add_country_code2' size='15' maxlength='15' value='' >";
			}
			else if(mailcountrycode != null)
			{
				if(effstatus.equals("E"))
				{
				strmac2="<input type='hidden' name='mail_add_country_code2' id='mail_add_country_code2' size='15' maxlength='15' value='"+mailcountrycode+"' >";
				}
				else if(effstatus.equals("D"))
				{
				strmac2="<input type='hidden' name='mail_add_country_code2' id='mail_add_country_code2' size='15' maxlength='15' value='"+mailcountrycode+"' >";
				}
			}
repfacility=rset.getString("reporting_facility_id");
if(repfacility == null) repfacility="";

			if(repfacility != null)
			{
				String sqlr="select facility_name from sm_facility_param where facility_id=? ";
				pstmtr = conn.prepareStatement(sqlr);
				pstmtr.setString(1,repfacility);
				rsr=pstmtr.executeQuery();
				if(rsr != null )
				{
					while(rsr.next())
					{
						repfacilityname=rsr.getString("facility_name");
					}	
				}	if (rsr != null) rsr.close();
		            if (pstmtr != null) pstmtr.close();
			}
			else
				{
					repfacilityname=" ";
				}

				String sql15="select facility_id,facility_name from sm_facility_param where facility_type='F' order by facility_name";
				pstmt15=conn.prepareStatement(sql15);
				rs15=pstmt15.executeQuery();
				if(rs15 != null)
				{
				 while (rs15.next())
				 {
					repfacility1=rs15.getString("facility_id");
					if(repfacility1 == null) repfacility1="";
					repfacilityname1=rs15.getString("facility_name");
					if((repfacility1.equals(repfacility)) && (repfacilityname1.equals(repfacilityname)) && (repfacility != null) && (!repfacilityname.equals(" ")))
					{
						str4=str4+"<option value='"+repfacility1+"' selected>"+repfacilityname1;
					}
					else if((!repfacility1.equals(repfacility)) && (!repfacilityname1.equals(repfacilityname)) && (repfacility != null) && (!repfacilityname.equals(" ")))
					{
						str4=str4+"<option value='"+repfacility1+"'>"+repfacilityname1;
					}
					else if((repfacility == null) && (repfacilityname.equals(" ")))
					{
						str4=str4+"<option value='"+repfacility1+"'>"+repfacilityname1;
					}
				 }
				}
				if (rs15 != null) rs15.close();
		            if (pstmt15 != null) pstmt15.close();
				str4=str4+"</select>";
				strr1="<input type='text' name='rep_facility1' id='rep_facility1' size='30' maxlength='30' value='"+repfacilityname+"' readonly>";
				if(repfacility == null)
				{
				strr2="<input type='hidden' name='rep_facility2' id='rep_facility2' size='15' maxlength='15' value=''>";
				}
				else if(repfacility != null)
				{
				if(effstatus.equals("E"))
				{
				strr2="<input type='hidden' name='rep_facility2' id='rep_facility2' size='15' maxlength='15' value='"+repfacility+"'>";
				}
				else if(effstatus.equals("D"))
				{
				strr2="<input type='hidden' name='rep_facility' id='rep_facility' size='15' maxlength='15' value='"+repfacility+"'>";
				}
 			}
			otherstafftype=rset.getString("other_staff_type");
			String sqlp="select short_desc from am_other_staff_type where other_staff_type=? ";
			pstmtp=conn.prepareStatement(sqlp);
			pstmtp.setString(1,otherstafftype);
			rsp=pstmtp.executeQuery();
			
			if(rsp != null )
			{
				while(rsp.next())
				{
					shortdesc=rsp.getString("short_desc");
				}	
			}	    if (rsp != null) rsp.close();
		            if (pstmtp != null) pstmtp.close();

			String sql12 = "select other_staff_type,short_desc from am_other_staff_type where eff_status='E' order by short_desc";
			pstmt12=conn.prepareStatement(sql12);
			rs12=pstmt12.executeQuery();
			strt="<select name='other_staff_type' id='other_staff_type' onClick='checkOtherStaff();check1()' onChange='checkPosition(this.form,this)' ><option  value=''>-----"+defaultselect+"-------";			
			if(rs12 != null)
			{
			while (rs12.next())
			{
				otherstafftype1=rs12.getString("other_staff_type");
				
				shortdesc1=rs12.getString("short_desc");
				if((otherstafftype1.equals(otherstafftype)) && (shortdesc1.equals(shortdesc)))
				{
					strt=strt+"<option value='"+otherstafftype+"' selected>"+shortdesc1;
						if(effstatus.equals("E"))
								{

								strt2="<input type='hidden' name='other_staff_type3' id='other_staff_type3' size='15' maxlength='15' value='"+otherstafftype+"'>";
								}
				}
				else if((!otherstafftype1.equals(otherstafftype)) && (!shortdesc1.equals(shortdesc)))
				{
					strt=strt+"<option value='"+otherstafftype1+"'>"+shortdesc1;
					if(effstatus.equals("E"))
					{
						strt2="<input type='hidden' name='other_staff_type3' id='other_staff_type3' size='15' maxlength='15' value='"+otherstafftype+"'>";
					}
				}

			 }
		        }if (rs12 != null) rs12.close();
		            if (pstmt12 != null) pstmt12.close();
			strt=strt+"</select>";
			strt1="<input type='text' name='other_staff_type2' id='other_staff_type2' size='15' maxlength='15' value='"+shortdesc+"' readonly>";

 			if(effstatus.equals("D"))
 			{
 				strt2="<input type='hidden' name='other_staff_type3' id='other_staff_type3' size='15' maxlength='15' value='"+otherstafftype+"'>";
 			}
			
	
 				maritalstatus=rset.getString("mar_status_code");
				if(maritalstatus == null) maritalstatus="";
 			if(maritalstatus != null)
 			{

 				String sqlm="select short_desc from mp_marital_status where mar_status_code=?";
 				pstmtm=conn.prepareStatement(sqlm);
				pstmtm.setString(1,maritalstatus);
 				rsm=pstmtm.executeQuery();
 				if(rsm != null)
 				{
 					while(rsm.next())
 					{
 						maritaldesc=rsm.getString("short_desc");
 					}	
 				}	
 			}
 			else
 			{
 				maritaldesc=" ";
 			}
 			String sql13="select mar_status_code,short_desc from mp_marital_status where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by short_desc";
 			pstmt13=conn.prepareStatement(sql13);
 			rs13=pstmt13.executeQuery();
 			str2="<select name='marital_status' id='marital_status' onClick='check5()' ><option value=''>---"+defaultselect+"-----";
 			if(rs13 != null)
 			{
 			 while (rs13.next())
 			 {
 				maritalstatus1=rs13.getString("mar_status_code");
				if(maritalstatus1 == null) maritalstatus1="";
 				maritaldesc1=rs13.getString("short_desc");
				
 				if((maritalstatus1.equals(maritalstatus)) && (maritaldesc1.equals(maritaldesc)) && (maritalstatus != null) && (!maritaldesc.equals(" ")))
 				{
					if(effstatus.equals("E"))
					{
 					str2=str2+"<option value='"+maritalstatus1+"' selected>"+maritaldesc1;
					}
 				}
 				else if((!maritalstatus1.equals(maritalstatus)) && (!maritaldesc1.equals(maritaldesc)) && (maritalstatus != null) && (!maritaldesc.equals(" ")))
 				{
					if(effstatus.equals("E"))
					{
 					str2=str2+"<option value='"+maritalstatus1+"' >"+maritaldesc1;
					}
 				}
 				else if ((maritalstatus == null) && (maritaldesc.equals(" ")))
 				{
					if(effstatus.equals("E"))
					{
 					str2=str2+"<option value='"+maritalstatus1+"'>"+maritaldesc1;
					}
 				}
 			 }
 		        } if (rs13 != null) rs13.close();
		if (pstmt13 != null) pstmt13.close();	
 			str2=str2+"</select>";

 			strm1="<input type='text' name='marital_status1' id='marital_status1' size='15' maxlength='15' value='"+maritaldesc+"' readonly>";
 			if(maritalstatus == null)
 			{
 			strm2="<input type='hidden' name='marital_status' id='marital_status' size='15' maxlength='15' value='"+maritalstatus+"'>";
 			}
 			else if(maritalstatus != null)
 			{
 			if(effstatus.equals("E"))
 			{

 			strm2="<input type='hidden' name='marital_status' id='marital_status' size='15' maxlength='15' value='"+maritalstatus+"'>";
 			}
 			if(effstatus.equals("D"))
 			{
 			strm2="<input type='hidden' name='marital_status' id='marital_status' size='15' maxlength='15' value='"+maritalstatus+"'>";
 			}
 			}
	
			citizen=rset.getString("citizenship_code");
			if (citizen == null) citizen="";
			if(citizen != null)
 			{
 				String sqlc="select long_desc from mp_country where country_code=?";
 				pstmtc=conn.prepareStatement(sqlc);
				pstmtc.setString(1,citizen);
 				rsc=pstmtc.executeQuery();
 				if(rsc != null )
 				{
 					while(rsc.next())
 					{
 						citizendesc = rsc.getString("long_desc");
						if(citizendesc==null)citizendesc="";
 					}	
 				}	 if (rsc != null) rsc.close();
		if (pstmtc != null) pstmtc.close();
 			}
 			else
 			{
 				citizendesc="";
 			}
 			String sql14="select country_code,long_desc from mp_country where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) and long_desc is not null order by long_desc";
 			pstmt14=conn.prepareStatement(sql14);
 			rs14=pstmt14.executeQuery();
			//Modified by Ashwini on 20-Mar-2020 for MOHE-CRF-0011
			if(isResidencyApplYN){
 				str3="<select name='citizen' id='citizen' onChange='checkCitznOrNonCitzn();' onClick='check6()'><option value=''>---"+defaultselect+"-----";
			}else
			{
				str3="<select name='citizen' id='citizen' onClick='check6()'><option value=''>---"+defaultselect+"-----";
			}
 			if(rs14 != null)
 			{
 			while (rs14.next())
 			{
 				citizen1=rs14.getString("country_code");
 				if(citizen1 == null) citizen1="";
 				citizendesc1=rs14.getString("long_desc");
 				if (citizendesc1==null)citizendesc1="";
 				if((citizen1.equals(citizen)) && (citizendesc1.equals(citizendesc)) && (citizen != null) && (!citizendesc.equals(" ")))
 				{
					
 					str3=str3+"<option value='"+citizen1+"' selected>"+citizendesc1;
 				}
 				else if((!citizen1.equals(citizen)) && (!citizendesc1.equals(citizendesc)) && (citizen != null) && (!citizendesc.equals(" ")))
 				{
					
 					str3=str3+"<option value='"+citizen1+"'>"+citizendesc1;
 				}
 				else if((citizen == null) && (citizendesc.equals("")))
 				{
					
 					str3=str3+"<option value='"+citizen1+"'>"+citizendesc1;

 				}
 			 }
 			} if (rs14 != null) rs14.close();
		if (pstmt14 != null) pstmt14.close();
			
 			str3=str3+"</select>";

 			strc1="<input type='text' name='citizen1' id='citizen1' size='15' maxlength='15' value='"+citizendesc+"' readonly>";

 			if(citizen==null)
 			{
 			strc2="<input type='hidden' name='citizen2' id='citizen2' size='15' maxlength='15' value=''>";
 			}
 			else if(citizen != null)
 			{

 			if(effstatus.equals("E"))
 			{
 			strc2="<input type='hidden' name='citizen2' id='citizen2' size='15' maxlength='15' value='"+citizen+"'>";
 			}
 			else if(effstatus.equals("D"))
 			{
 			strc2="<input type='hidden' name='citizen2' id='citizen2' size='15' maxlength='15' value='"+citizen+"'>";
 			}

 			}
		}catch(Exception e) {
					e.printStackTrace();
				    }
			finally     {		
								if(pstmtstmt != null) pstmtstmt.close();
								if(pstmt10 != null) pstmt10.close();
								if(pstmt11 != null) pstmt11.close();
								if(pstmt12 != null) pstmt12.close();
								if(pstmt13 != null) pstmt13.close();
								if(pstmt14 != null) pstmt14.close();
								if(pstmt15 != null) pstmt15.close();
								if(pstmt17 != null) pstmt17.close();
								if(pstmt19 != null) pstmt19.close();
								if(pstmt21 != null) pstmt21.close();
								if(pstmt25 != null) pstmt25.close();
								if(pstmt26 != null) pstmt26.close();
								if(pstmt27 != null) pstmt27.close();
								if(pstmtp  != null) pstmtp.close();
								if(pstmtm  != null) pstmtm.close();
								if(pstmtc  != null) pstmtc.close();
								if(pstmtr  != null) pstmtr.close();
								if(pstmtrec!= null) pstmtrec.close();
								if(pstmtofc!= null) pstmtofc.close();
					 			if(pstmtmac!= null) pstmtmac.close();			 			
								if(rset != null) rset.close();
								if(rs10 != null) rs10.close();
								if(rs12 != null) rs12.close();
								if(rs13 != null) rs13.close();
								if(rs14 != null) rs14.close();
								if(rs15 != null) rs15.close();
								if(rs17 != null) rs17.close();
								if(rs19 != null) rs19.close();
								if(rs21 != null) rs21.close();
								if(rs25 != null) rs25.close();
								if(rs26 != null) rs26.close();
								if(rs27 != null) rs27.close();
								if(rsp != null) rsp.close();
								if(rsm != null) rsm.close();
								if(rsc != null) rsc.close();
								if(rsr != null) rsr.close();
								if(rsrec!= null) rsrec.close();
								if(rsofc!= null) rsofc.close();
					 			if(rsmac!= null) rsmac.close();
								if(rss  != null) rss.close();

			}

			codeTextAttribute="READONLY";
			newOtherStaff=false;
 			eventFunctionForCase="";

		}

// checkPosition(document.forms[0].other_staff_type.form,document.forms[0].other_staff_type) Removed Against Script Error 		
%><body onLoad="FocusFirstElement();check();scroll_vw();setfocus();" onSelect = "resMove()" onKeyDown = 'lockKey()' OnMouseDown='CodeArrest()' onKeyPress='return ChkKey(event);'> 
    	<form name='OtherStaff_form' id='OtherStaff_form'>
	<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
		<tr>
			<td class='label' width="20%" ><fmt:message key="Common.OtherStaffType.label" bundle="${common_labels}"/></td>
			<td class="fields" width="35%" >
<%	
	if(effstatus.equals("E")) 
	{
%>		<%=strt%><%=strt2%>
		<img src='../../eMP/images/mandatory.gif' align='center'></img>
		
<%	}
	else if(effstatus.equals("D")) {%>
	<%=strt1%><%=strt2%><img src='../../eMP/images/mandatory.gif' align='center'></img>
	<%}%>
	</td>
	<td class="label" colspan='2' width="45%"></td>
	</tr>
		<tr>
			<td class='label' width="20%"><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
			<td class="fields" width="35%">
			<input type='text' name='other_staff_id' id='other_staff_id' <%if(isSplCharNotAllowApplYN){%> onKeyPress="return CheckForSpecCharsValidation2(event);"  <%}else{%> onKeyPress="return CheckForSpecChars(event)" <%}%>  size='15' maxlength='15' value="<%=otherstaffid%>" <%=codeTextAttribute%> <%=eventFunctionForCase%>><!--Modified by Suji Keerthi for MOHE-CRF-0113 US001-->
			<img src='../../eMP/images/mandatory.gif' align='center'></img>
			</td>
			<td class="label" colspan='2' width="45%"></td>
		</tr>
		<tr>
			<td class='label' width="20%" ><fmt:message key="Common.FullName.label" bundle="${common_labels}"/></td>
			<td class="fields" width="35%">
			<input type='text' <%if(isSplCharNotAllowApplYN){%> onKeyPress="return CheckForSpecCharsValidation1(event);" onBlur='CheckSplCharsValidation(this); makeValidString(this);' <%}else{%> onBlur="makeValidString(this)" <%}%> name='other_staff_name' id='other_staff_name' size='30' maxlength='30' value="<%=otherstaffname%>" <%=otherTextAttribute%> ><!--Modified by Suji Keerthi for MOHE-CRF-0113 US001-->
			<img src='../../eMP/images/mandatory.gif' align='center'></img>
			</td>
			<td class='label' width="15%"><fmt:message key="Common.shortname.label" bundle="${common_labels}"/></td>
			<td class="fields" width="30%"><input type='text' <%if(isSplCharNotAllowApplYN){%> onKeyPress="return CheckForSpecCharsValidation1(event);" onBlur='CheckSplCharsValidation(this); makeValidString(this);' <%}else{%> onBlur="makeValidString(this)" <%}%> name='short_name' id='short_name' size='15' maxlength='15' value="<%=shortname%>" <%=otherTextAttribute%> ><!--Modified by Suji Keerthi for MOHE-CRF-0113 US001-->
			<img src='../../eMP/images/mandatory.gif' align='center'></img>
			</td>
		</tr>
<%if(!(longname.equals("")))
{
int len = longname.length();
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
		
		longname1=longname1+""+longname.substring((i1*75),max);
		n_incre = 1;
    }}
else  {
	longname1=longname;
 }} %>
<tr>
<style>
textarea {
  resize: none;
}
</style>
<td class="label" width="20%"><fmt:message key="Common.longname.label" bundle="${common_labels}"/></td>
<td class='fields' colspan='2'><textarea name='long_name' id='long_name'  rows='4' cols='72' <%if(isSplCharNotAllowApplYN){%> onKeyPress='return CheckForSpecCharsValidation1(event); checkMaxLimit(this,"300");' onBlur='CheckSplCharsValidation(this); return maxLength(this,"300");' onpaste='return maxLengthPaste(this,"300");' <%}else{%>	onKeyPress='checkMaxLimit(this,"300");' onpaste='return maxLengthPaste(this,"300");' <%}%> <%=otherTextAttribute%>>
<%=longname1 %></textarea><!--Modified by Suji Keerthi for MOHE-CRF-0113 US001-->	
	
</td>
<td class='label'  >&nbsp;</td>
	<td class='fields' ></td>
		</tr>
<tr>
		<tr>
			<td class='label' width="20%"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td class="fields" width="35%"><input type='checkbox' name='eff_status' id='eff_status'  value="<%=effstatus%>" <%=checkBoxAttribute%> onclick="checkActive(this)" onKeydown="registerLastKey(event)" onblur="getfocus()" >
			</td>
			<td class="label" colspan='2' width="45%"></td>
		</tr>
<tr><td colspan='5'>

<ul id="tablist" class="tablist" >
			<li class="tablistitem" title="General">
				<a onclick="tab_click2('search_tab')" class="tabClicked" id='search_tab' >
					<span class="tabSpanclicked" id="search_tabspan" ><fmt:message key="Common.Identity.label" bundle="${common_labels}"/></span>
				</a>
			</li>
		<li class="tablistitem" title="Additional details">
				<a onclick="tab_click2('additional_tab')" class="tabA" id='additional_tab'>
					<span class="tabAspan" id="additional_tabspan" ><fmt:message key="Common.ContactNoAddr.label" bundle="${common_labels}"/></span>
				</a>
			</li>
		</ul>
</td></tr>		
	</table>
</form>

<script>prevTabObj='search_tab';</script>
<!-- <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br> -->  
<form name='OtherStaff1_form' id='OtherStaff1_form' action='../../servlet/eAM.OtherStaffServlet' method='post' target='messageFrame'>
	<a name='identitylink'  id='identitylink'></a>
	<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center' valign='top'  name='sub_tab' id='sub_tab'>
		<tr>
			
      	<td width="100%" class="Border"><table border='0' cellpadding='0' cellspacing='0' width='100%'>
		<td class='label' width='12%'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
		<td class='fields' width="35%">
			<% 
		if(effstatus.equals("E")) {%>
				<%=str1%><%=strs2%>
			<%}
			else if(effstatus.equals("D")) {%>
				<%=strs1%><%=strs2%>
			<%}%>
			<img src='../../eMP/images/mandatory.gif' align='center'></img>
		</td>

	<!--Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011-->
	<%if(isResidencyApplYN){

	if(natid_mand_yn.equals("Y"))
	{
		nat_visibility = "visible";
	}else
	{
		nat_visibility = "hidden";
	}

	if(!citizenship_code.equals(""))
	{
		if(citizen_nat_code.equals(citizenship_code))
		{
			citizenChk = "Checked";
			natIdDis = "";
			if(!other_alt_type_no.equals(""))
			{
				other_alt_no_dis = "";
			}else
			{
				other_alt_no_dis = "disabled";
			}
			if(natid_mand_yn.equals("Y"))
			{
				nat_visibility = "visible";
			}
		}else
		{
			nonCitizenChk = "Checked";
			natIdDis = "disabled";
			nationalidno = "";
			nat_visibility = "hidden";
			if(alt_id1_type.equals(oth_alt_val))
			{
				oth_alt_length = alt_id1_length;
			}else
			{
				oth_alt_length = "20";
			}
			if(!oth_alt_val.equals(""))
			{
				if(oth_alt_val.equals(other_alt_type_no))
				{
					other_alt_type_no = oth_alt_val;
					other_alt_type_dis = "disabled";
					other_alt_no_dis = "";
					oth_alt_visibility = "visible";
				}else
				{
					other_alt_type_no = oth_alt_val;
					other_alt_type_dis = "disabled";
					other_alt_type_desc = "";
					other_alt_no_dis = "";
					oth_alt_visibility = "visible";
				}
			}else
			{
				other_alt_type_no = "";
				other_alt_type_dis = "disabled";
				other_alt_type_desc = "";
				other_alt_no_dis = "disabled";
			}
		}
	}
	
	if(effstatus.equals("D"))
	{
		other_alt_type_dis = "disabled";
		other_alt_no_dis = "disabled";
	}
%>
	<td class="label"><fmt:message key="Common.residency.label" bundle="${common_labels}"/></td>
	<td>
		<table width='53%'>
			<tr>
				<td class="oaBorder" nowrap>
				<%if(effstatus.equals("E")){%>
					<input type='radio' name='res_citizen' id='res_citizen' <%=citizenChk%> 
					onClick='validateCitizen("<%=citizen_nat_code%>");'><fmt:message key="Common.citizen.label" bundle="${common_labels}"/>
					<input type='radio' name='res_citizen' id='res_citizen' <%=nonCitizenChk%> 
					onClick='validateNonCitizen("<%=citizen_nat_code%>","<%=citizenship_code%>");'><fmt:message key="Common.noncitizen.label" bundle="${common_labels}"/>
				<%}else if(effstatus.equals("D")){%>
					<input type='radio' name='res_citizen' id='res_citizen' <%=citizenChk%> disabled><fmt:message key="Common.citizen.label" bundle="${common_labels}"/>
					<input type='radio' name='res_citizen' id='res_citizen' <%=nonCitizenChk%> disabled><fmt:message key="Common.noncitizen.label" bundle="${common_labels}"/>
				<%}%>
				</td>
				<td width='15%'>&nbsp;</td>
			</tr>
		</table>
	</td>
	<%}else{%>
	<td class='label'>&nbsp;</td>
	<td class='label'>&nbsp;</td>
	<%}%>
	<!--End MOHE-CRF-0011-->
	<input type='hidden' name='max_pa_age' id='max_pa_age' value='<%=max_patient_age%>'>

	</tr>
			
		<tr>
		<td class='label' width='20%'><fmt:message key="Common.age.label" bundle="${common_labels}"/></td>
		<td class='fields' width='35%'>
				<%
				if(effstatus.equals("D")) {
				%>
				<input type="text" name="b_age" id="b_age" maxlength="3"  size="3" value='<%=bage%>' onKeyPress='return  allowValidNumber(this,event,3,0);' onChange='calculateAge(this,2)' disabled  onblur='chkY()'>&nbsp;Y&nbsp;
				<input type="text" name="b_months" id="b_months" maxlength="2" value='<%=bmonths%>' size="2" onKeyPress='return  allowValidNumber(this,event,2,0);' onChange='calculateAge(this,2)' disabled >&nbsp;M&nbsp;
				<input type="text" name="b_days" id="b_days"  maxlength="2" size="2" value='<%=bdays%>' onKeyPress='return  allowValidNumber(this,event,2,0);' onChange='calculateAge(this,2)'  disabled>&nbsp;D&nbsp;
				<%
				}else{
				%>
				<input type="text" name="b_age" id="b_age"  maxlength="3" size="3" value='<%=bage%>' onKeyPress='return  allowValidNumber(this,event,3,0);' onChange='calculateAge(this,2)' onblur='chkY()' >&nbsp;Y&nbsp;
				<input type="text" name="b_months" id="b_months"  maxlength="2" value='<%=bmonths%>' size="2" onKeyPress='return  allowValidNumber(this,event,2,0);' onBlur='calculateAge(this,2)' >&nbsp;M&nbsp;
				<input type="text" name="b_days" id="b_days"  maxlength="2" size="2" value='<%=bdays%>'onKeyPress='return  allowValidNumber(this,event,2,0);' onBlur='calculateAge(this,2)'  >&nbsp;D&nbsp;
				<%
				}
				%>
			</td>
			<td class='label' width="15%"><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></td>
			<td class="fields" width="30%" >
				<input type='hidden' name='ServerDate' id='ServerDate' value='<%=str13%>'>
				<input type='hidden' name='effstatus' id='effstatus' value='<%=effstatus%>'>
				<input type='hidden' name='greg_date_of_birth' id='greg_date_of_birth' value=''>
				<input type='hidden' name='greg_date_of_birth_mod' id='greg_date_of_birth_mod' value='<%=birthdate%>'>
				<input type="text"  name="date_of_birth" id="date_of_birth" maxlength="10" size="8"  value='<%=birthdate_disp%>' onblur='calculateAge(this,1);'  <%=otherTextAttribute%> <%=disablerecord%>>
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('date_of_birth');" <%=disablerecord%> >
				<img src='../../eMP/images/mandatory.gif' align='center'></img>
			</td>
		</tr>
		<tr>
			<td class='label' width='12%'><fmt:message key="Common.birthPlace.label" bundle="${common_labels}"/></td>
			<td class='fields' width="35%">
				<input type='text' name="birth_place" id="birth_place"  onBlur="makeValidString(this)" maxlength='30' size='30' value="<%=birthplace%>" <%=otherTextAttribute%> >
			</td>
			<td class='label' width="15%"><fmt:message key="eMP.maritalstatus.label" bundle="${mp_labels}"/></td>
			<td class="fields" width="30%">
				<%if(effstatus.equals("E")) {%>
					<%=str2%><%=strm2%>
				<%}
				else if(effstatus.equals("D")) {%>
					<%=strm1%><%=strm2%>
				<%}%>
			</td>
		</tr>
	</table>
</td>
</tr>
</table>
<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center' valign='top'  name='sub_tab' id='sub_tab'>

<tr>
    <td width="100%" class="Border">
	<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr>
	<tr>
		<tr>
			<td class='label' width="20%" NOWRAP><fmt:message key="eMP.AliasName.label" bundle="${mp_labels}"/></td>
			<td class="fields" width="35%">
				<input type='text' name="alias_name" id="alias_name"  
            onBlur="makeValidString(this)" maxlength='30' size='30' value="<%=aliasname%>" <%=otherTextAttribute%> >
			</td>
			<td class='label' width="15%" NOWRAP><fmt:message key="Common.Citizenship.label" bundle="${common_labels}"/></td>
			<td class="fields" width="30%">
				<%  if(effstatus.equals("E")) {%>
					<%=str3%><%=strc2%>&nbsp;
					<!--Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011-->
					<%if(isResidencyApplYN){%><img src='../../eCommon/images/mandatory.gif' align='center'></img><%}%>
				<%}
				else if(effstatus.equals("D")) {%>
					<%=strc1%><%=strc2%>&nbsp;
				<%}%>
			</td>
		</tr>
		<tr>	
			<% 		
			if(accept_national_id_no_yn.equals("Y")){
					
					String nat_id_onKeyPress="";

					/*
					if ( nat_id_check_digit_id.equals("M11") )
						nat_id_onKeyPress = "return CheckForCharsNatID(event);";
					else
						nat_id_onKeyPress = "return  allowValidNumber(this,event,'"+str14+"',0);";
					*/

					if(nat_id_accept_alphanumeric_yn.equals("Y"))
					{
						nat_id_onKeyPress = "CheckForAlphaCharsNatID(event);";
					}
					else
					{
						if(nat_id_check_digit_id.equals("M11"))
							nat_id_onKeyPress = "CheckForCharsNatID(event);";
						else
							nat_id_onKeyPress = "allowValidNumber(this,event,'"+str14+"', 0);";
					}

					%>


			<td class='label' width="12%" NOWRAP><%=nat_id_prompt%></td>
			<td class="fields" width="35%">
				<!--Modified by Ashwini on 20-Mar-2020 for MOHE-CRF-0011-->
				<input type='text' name="national_id_no" id="national_id_no"   maxlength='<%=str14%>' <%=natIdDis%> onkeypress="return <%=nat_id_onKeyPress%>" onBlur="makeValidString(this);validateNationality(this,'<%=nat_id_prompt%>','<%=nat_id_check_digit_id%>');" size='15' value="<%=nationalidno%>" <%=otherTextAttribute%> >
				<!--Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011-->
				<%if(isResidencyApplYN && effstatus.equals("E")){%><img name='nat_mandatory' style='visibility:<%=nat_visibility%>' src='../../eCommon/images/mandatory.gif'><%}%>
				<input type='hidden' name='oldnationalid' id='oldnationalid' value="<%=nationalidno%>">
			</td>
					<%}%>
			<!--Added for this HSA-CRF-160 -->		
			<%if(!accept_national_id_no_yn.equals("Y")){%>
			<td class='label' width="15%" NOWRAP><fmt:message key="Common.Position.label" bundle="${common_labels}"/></td>
			<td class= 'fields' width="30%"> <%
				System.out.println("effstatusend "+effstatus);
				if(effstatus.equals("E"))
				{%>
					
						
						<select name="Position" id="Position" >
							 <option value=''>--------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------------------</option>  
						<% 
				
				 Iterator eee=position_list.iterator();
				 System.out.println("eee "+eee);
				// Iterator enu=position_list.iterator();
				 String tempvariable="";int iop=0;
				/* while(enu.hasNext())
			     {
              
				   
				   iop=iop+1;
				   
				 }*/
				while(eee.hasNext())
			    { 
					tempvariable=(String)eee.next();
					System.out.println("tempvariable "+tempvariable);
					iop=iop+1;
				if(Position.equals(tempvariable))
				{
					%>
					<option value="<%=tempvariable%>" 
						selected><%=(String)eee.next() %> </option><%
				}else
					{
					%>
					<option value="<%=tempvariable%>" 
						><%= (String)eee.next() %> </option>

				<%}
				}%>
				</select>
			<% }else
				{%>
				<input type='hidden' name="Position" id="Position" value="<%=Position%>" > 	 
				<input type='text' name="Position1" id="Position1" value="<%=Position1%>" readonly> 
			<%}	}%>
			
			
			
			
			<td class='label' width="15%" NOWRAP><fmt:message key="eMP.OtherAltNo.label" bundle="${mp_labels}"/></td>
			<td class="fields" width="30%" nowrap><select name="other_alt_type" id="other_alt_type" onchange="enabledOtherAltId()" <%=other_alt_type_dis%>><option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option><%
	 String alt_no="select alt_id_type, long_desc from mp_alternate_id_type where eff_Status='E' order by alt_id_type";
	 other_altstat=conn.createStatement();
	 other_altrs=other_altstat.executeQuery(alt_no);
	 while(other_altrs.next()){
	 alt_type_code=other_altrs.getString("alt_id_type")==null?"":other_altrs.getString("alt_id_type");
	 alt_type_desc=other_altrs.getString("long_desc")==null?"":other_altrs.getString("long_desc");
	 if(alt_type_code.equals(other_alt_type_no)){
	  other_alt_select="selected";
	 }else{
	    other_alt_select="";
      }		
	 
	 %>
	 <!--Modified by Ashwini on 20-Mar-2020 for MOHE-CRF-0011-->
	 <option value="<%=alt_type_code%>" <%=other_alt_select%>><%=alt_type_desc%></option>	 
	 <%}%></select><input type='text' name="other_alt_no" id="other_alt_no" onBlur="makeValidString(this);<%if(isResidencyApplYN && effstatus.equals("E")){%>duplicateOthAltIdValidation(this,'<%=oth_alt_val%>');<%}%>" maxlength='<%=oth_alt_length%>' size='20' tabindex='18' value="<%=other_alt_type_desc%>" <%=other_alt_no_dis%>>
	 <%if(isResidencyApplYN && effstatus.equals("E")){%><img name='oth_alt_mand' style='visibility:<%=oth_alt_visibility%>' src='../../eCommon/images/mandatory.gif'><%}%>
	        <input type='hidden' name="other_alt_no1" id="other_alt_no1"  value="<%=other_alt_type_desc%>" >
	 </td>
		</tr>
		<tr>
			<td class='label' width="12%" NOWRAP><fmt:message key="Common.Degree.label" bundle="${common_labels}"/></td>
			<td class="fields" width="35%">
				<input type='text' name="degree" id="degree"  
onBlur="makeValidString(this)" maxlength='15' size='15' 
value="<%=degree%>" <%=otherTextAttribute%> >
			</td>
			<%if(accept_national_id_no_yn.equals("Y")){%>
			<td class='label' width="15%" NOWRAP><fmt:message key="Common.Position.label" bundle="${common_labels}"/></td>
			<td class= 'fields' width="30%"> <%
				if(effstatus.equals("E"))
				{%>
					
						
						<select name="Position" id="Position" >
							 <option value=''>--------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------------------</option>  
						<% 
				
				 Iterator eee=position_list.iterator();
				// Iterator enu=position_list.iterator();
				 String tempvariable="";int iop=0;
				/* while(enu.hasNext())
			     {
              
				   
				   iop=iop+1;
				   
				 }*/
				while(eee.hasNext())
			    { 
					tempvariable=(String)eee.next();
					iop=iop+1;
				if(Position.equals(tempvariable))
				{
					%>
					<option value="<%=tempvariable%>" 
						selected><%=(String)eee.next() %> </option><%
				}else
					{
					%>
					<option value="<%=tempvariable%>" 
						><%= (String)eee.next() %> </option>

				<%}
				}%>
				</select>
			<% }else
				{%>
				<input type='hidden' name="Position" id="Position" value="<%=Position%>" > 	 
				<input type='text' name="Position1" id="Position1" value="<%=Position1%>" readonly> 
			<%}}%>
				
		</tr>
		<tr>
			<td class='label' width="12%" NOWRAP><fmt:message key="eAM.RepFacility.label" bundle="${am_labels}"/></td>
			<td class="fields" width="35%">
				<%if(effstatus.equals("E")) {%>
				<select name='rep_facility' id='rep_facility' onClick='check7()'>
				<option value=''>------------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------------------------&nbsp;

					<%=str4%><%=strr2%>
					<%}
				else if(effstatus.equals("D")) {%>
					<%=strr1%><%=strr2%>
				<%}%>
				</select><img name='mandatory' style='visibility: hidden' src='../../eCommon/images/mandatory.gif'></td>
			
			<td class='label' width="15%" ><fmt:message key="Common.EmplStatus.label" bundle="${common_labels}"/></td>
				
				<td class= 'fields' width="30%"> 
				<%if(effstatus.equals("E")) {%>
					<%=str5%><%=stre2%>
				<%}
				else if(effstatus.equals("D")) {%>
					<%=stre1%><%=stre2%>
				<%}%>	
				<img src='../../eMP/images/mandatory.gif' align='center'></img></td>	
	</tr>
							<TR class='label'><TD colspan ='4' id = 'popempid' class='label'></TD></TR>	

	<tr>
		<td>
		<input type='hidden' name='ServerDate' id='ServerDate' value='<%=str13%>'>
		</td>
	</tr>
	
	<tr>
	<td colspan='2'>&nbsp;</td>
	<td class='label' width="15%" ><fmt:message key="Common.AllFacilities.label" bundle="${common_labels}"/></td>
<%	
				if(count > 1){%>
				<%if(effstatus.equals("E")) {%><td width="30%" class="fields"><input type='checkbox' name='all_facilities' id='all_facilities' value="<%=allfacilities%>" onClick="check();changeFocus1();" onblur="" <%=checkBoxAttribute1%> align='left' style="padding:0;"><input type='hidden' name='all_facilities1' id='all_facilities1' value="<%=allfacilities%>"  align='left'></td>
				<%}else if(effstatus.equals("D")) {%><td width="30%" class="fields"><input type='checkbox'   name='all_facilities' id='all_facilities' value="<%=allfacilities%>" disabled <%=checkBoxAttribute1%> align='left' onblur=""><input type='hidden' name='all_facilities1' id='all_facilities1' value="<%=allfacilities%>"  align='left'></td>
				<%}%>
				<%}else {%><td  width="30%" class="fields"><input type='checkbox' name='all_facilities' id='all_facilities'  value="<%=allfacilities%>" disabled <%=checkBoxAttribute1%> align='left' ><input type='hidden' name='all_facilities1' id='all_facilities1' value="<%=allfacilities%>"  align='left'></td>
				<%}%>
				
	</tr>

</table>
</td>
</tr>
</table>
<br><br><br><br><br><br>
<br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br>
<a name='contactnolink' id='contactnolink' ></a>
<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
<tr>
  	<td width="100%" class="Border">
		<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr>
	<td class='label' width="16%" ><fmt:message key="Common.ResTelNo.label" bundle="${common_labels}"/></td>
	<td class="fields" width="15%" ><input type='text'  onfocus="tab_click22()" onBlur="makeValidString(this)" name="residencetelno" id="residencetelno" maxlength='18' size='18' value="<%=restelnum%>" <%=otherTextAttribute%> ></td>
	<td class='label' width="16%" ><fmt:message key="Common.officephoneno.label" bundle="${common_labels}"/></td>
	<td class="fields" width="20%" >
		<input type='text' name="offtelno" id="offtelno" onBlur="makeValidString(this)" maxlength='18' size='18' value="<%=offtelnum%>" <%=otherTextAttribute%> >
	</td>
</tr>
<tr>
	<td class='label' width="15%"><fmt:message key="Common.Ext.label" bundle="${common_labels}"/></td>
	<td class='fields' width="25%">
		<input type='text' name="offtelext" id="offtelext" onBlur="makeValidString(this)" maxlength='6' size='6' value="<%=offtelext%>" <%=otherTextAttribute%> >
	</td>
	<td class='label' width="15%"><fmt:message key="Common.FaxNo.label" bundle="${common_labels}"/></td>
	<td class='fields' width="15%">
		<input type='text' name="faxno" id="faxno" onBlur="makeValidString(this)" maxlength='18' size='18' value="<%=faxnum%>" <%=otherTextAttribute%> >
	</td>
</tr>
<tr>
	<td class='label' width="15%"><fmt:message key="Common.MobileNo.label" bundle="${common_labels}"/></td>
	<td class='fields' width="20%">
			<input type='text' name="mobileno" id="mobileno" onBlur="makeValidString(this)" maxlength='18' size='18' value="<%=mobilenum%>" <%=otherTextAttribute%> >
	</td>
	<td class='label' width="15%"><fmt:message key="Common.PagerNo.label" bundle="${common_labels}"/></td>
	<td class='fields' width="25%">
		<input type='text' name="pagerno" id="pagerno" onBlur="makeValidString(this)" maxlength='18' size='18' value="<%=pagernum%>" <%=otherTextAttribute%> >
	</td>
</tr>
<tr>
	<td class='label' width="15%" ><fmt:message key="Common.email.label" bundle="${common_labels}"/> <fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
	<td class="fields" width="15%" ><input type='text' name='emailid' id='emailid' onBlur="makeValidString(this)" maxlength='50' size='18' value="<%=emailid%>" <%=otherTextAttribute%> ></td>
	<td class='label' width="15%" ><fmt:message key="eAM.PrefMode.label" bundle="${am_labels}"/></td>
	<td class="fields" width="20%">
	<%if (effstatus.equals("E")) {%>
		<%=str6%><%=strp2%>
	<%}
	else if(effstatus.equals("D")) {%>
		<%=strp1%><%=strp2%>
	<%}%>
	</td>
<!--  	<td class="label" width="40%" colspan='2'></td>-->
</tr>
</table>
</td>
</tr>
</table>
<br>


<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
<tr>
      	<td width="100%" class="Border">
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr>

</tr>

<tr>
	<td class="label" width='20%' colspan="1">&nbsp;</td>
	<td   width='20%' class='label'><b><fmt:message key="Common.residence.label" bundle="${common_labels}"/></b></td>
	<td   width='20%' class='label'><b><fmt:message key="Common.office.label" bundle="${common_labels}"/></b></td>
	<td   width='20%' class='label'><b><fmt:message key="Common.mail.label" bundle="${common_labels}"/></b></td>
	<td class="label" colspan='1' width="20%"></td>
<tr>
	<td width='20%' class='label'><fmt:message key="Common.Address.label" bundle="${common_labels}"/></td>
	<td width='20%' class="fields">
		<input type='text' name='res_add_ln1' id='res_add_ln1' onBlur="makeValidString(this)" maxlength='30' size='20' value="<%=resaddln1%>" <%=otherTextAttribute%> ></td>
	<td width='20%' class="fields">
		<input type='text' name='off_add_ln1' id='off_add_ln1' onBlur="makeValidString(this)" maxlength='30' size='20' value="<%=offaddln1%>" <%=otherTextAttribute%> ></td>
	<td width='20%' class="fields">
		<input type='text' name='mail_add_ln1' id='mail_add_ln1' onBlur="makeValidString(this)" maxlength='30' size='20' value="<%=mailaddln1%>" <%=otherTextAttribute%> ></td>
	<td class="label" colspan='1' width="20%"></td>
</tr>

<tr>
	<td class="label" width='20%' colspan="1"></td>
	<td width='20%' class="fields">
		<input type='text' name='res_add_ln2' id='res_add_ln2' maxlength='30' size='20' value="<%=resaddln2%>" onBlur="makeValidString(this)" <%=otherTextAttribute%> ></td>
	<td width='20%' class="fields">
		<input type='text' name='off_add_ln2' id='off_add_ln2' maxlength='30' size='20' value="<%=offaddln2%>"  onBlur="makeValidString(this)" <%=otherTextAttribute%> ></td>
	<td width='20%' class="fields">
		<input type='text' name='mail_add_ln2' id='mail_add_ln2' maxlength='30' size='20' value="<%=mailaddln2%>" onBlur="makeValidString(this)"  <%=otherTextAttribute%> ></td>
	<td class="label" colspan='1' width="20%"></td>
</tr>
<tr>
	<td class="label" width='20%' colspan="1"> </td>
	<td width='20%' class="fields">
		<input type='text' name='res_add_ln3' id='res_add_ln3' maxlength='30' size='20' value="<%=resaddln3%>" onBlur="makeValidString(this)" <%=otherTextAttribute%> ></td>
	<td width='20%' class="fields">
		<input type='text' name='off_add_ln3' id='off_add_ln3' maxlength='30' size='20' value="<%=offaddln3%>" onBlur="makeValidString(this)"  <%=otherTextAttribute%> ></td>
	<td width='20%' class="fields">
		<input type='text' name='mail_add_ln3' id='mail_add_ln3' maxlength='30' size='20' value="<%=mailaddln3%>" onBlur="makeValidString(this)"  <%=otherTextAttribute%> ></td>
	<td class="label" colspan='1' width="20%"></td>
</tr>
<tr>
	<td class="label" width='20%' colspan="1"> </td>
	<td width='20%' class="fields">
		<input type='text' name='res_add_ln4' id='res_add_ln4' maxlength='30' size='20' value="<%=resaddln4%>" onBlur="makeValidString(this)"  <%=otherTextAttribute%> ></td>
	<td width='20%' class="fields">
		<input type='text' name='off_add_ln4' id='off_add_ln4' maxlength='30' size='20' value="<%=offaddln4%>" onBlur="makeValidString(this)"  <%=otherTextAttribute%> ></td>
	<td width='20%' class="fields">
		<input type='text' name='mail_add_ln4' id='mail_add_ln4' maxlength='30' size='20' value="<%=mailaddln4%>" onBlur="makeValidString(this)" <%=otherTextAttribute%> ></td>
	<td class="label" colspan='1' width="20%"></td>
</tr>
<tr>
	<td class="label" width='20%'><fmt:message key="eMP.postalcode.label" bundle="${mp_labels}"/></td>
	
	<%if(effstatus.equals("E")) {%>
<td width='20%' class="fields">
<% if(fcall.equals("call"))
	{
	if(newOtherStaff)
	{ %>

        <input type='text' name='res_add_postal_code' id='res_add_postal_code' size='8' onBlur='makeValidString(this); if(this.value !="") searchCode(this,res_add_postal_code,res_add_postal) ' maxlength='8' ><input type="hidden" name="res_add_postal" id="res_add_postal"><input type='button' name='postal_code' id='postal_code' value='?' class='button' onclick='searchCode(this,res_add_postal_code,res_add_postal)'>
<%
	 
        }
        else								
        { 
        if(respostalcode != null) {%>
				<input type='text' name='res_add_postal_code2' id='res_add_postal_code2' size='8' maxlength='8' value="<%=respostalcode%>" onBlur='makeValidString(this); if(this.value !="") searchCode(this,res_add_postal_code2,res_add_postal2)' ><input type="hidden" name="res_add_postal2" id="res_add_postal2"><input type='button' name='postal_code' id='postal_code' value='?' class='button' onclick='searchCode(this,res_add_postal_code2,res_add_postal2)'>
		<%}else{%>
				<input type='text' name='res_add_postal_code2' id='res_add_postal_code2' size='8' maxlength='8' onblur='if(this.value !="") searchCode(this,res_add_postal_code2,res_add_postal2)'><input type="hidden" name="res_add_postal2" id="res_add_postal2"><input type='button' onBlur="makeValidString(this)" name='postal_code' id='postal_code' value='?' class='button' onclick='searchCode(this,res_add_postal_code2,res_add_postal2)'>
		<%}

		

	}
	}
	%>
<%=strrep2%></td>
	
	<td width='20%' class="fields">
	
	<%    	if(fcall.equals("call"))
	        {

			



        if(newOtherStaff)
	        {%>
			<input type='text' onBlur='makeValidString(this); if(this.value !="") searchCode(this,off_add_postal_code,off_add_postal)' name='off_add_postal_code' id='off_add_postal_code' size='8' maxlength='8'><input type="hidden" name="off_add_postal" id="off_add_postal"><input type='button' name='postal_code' id='postal_code' value='?' class='button' onclick='searchCode(this,off_add_postal_code,off_add_postal)'>
	        <%		
		
	        }
	        else
	        {
				if(offpostalcode != null) {%>
					<input type='text' name='off_add_postal_code2' id='off_add_postal_code2' size='8' maxlength='8'  onBlur='makeValidString(this); if(this.value !="") searchCode(this,off_add_postal_code2,off_add_postal2)' value="<%=offpostalcode%>"  ><input type="hidden" name="off_add_postal2" id="off_add_postal2"><input type='button' name='postal_code' id='postal_code' value='?' class='button' onclick='searchCode(this,off_add_postal_code2,off_add_postal2)'>
				<%}else{%>
					<input type='text' name='off_add_postal_code2' id='off_add_postal_code2' onBlur='makeValidString(this)  if(this.value !="") searchCode(this,off_add_postal_code2,off_add_postal2)' size='8' maxlength='8'><input type="hidden" name="off_add_postal2" id="off_add_postal2"><input type='button' name='postal_code' id='postal_code' value='?' class='button' onclick='searchCode(this,off_add_postal_code2,off_add_postal2)'>
				<%}

	}
	}%>
	
	<!--<%=str7%>--><%=strofp2%></td>
		
	
		
	<td width='20%' class="fields">
	
	<%  if(fcall.equals("call"))
		{
		if(newOtherStaff)
		{
			%>
			<input type='text' name='mail_add_postal_code' id='mail_add_postal_code' size='8' onBlur='makeValidString(this); if(this.value !="") searchCode(this,mail_add_postal_code,mail_add_postal)' maxlength='8'><input type="hidden" name="mail_add_postal" id="mail_add_postal"><input type='button' name='postal_code' id='postal_code' value='?' class='button' onclick='searchCode(this,mail_add_postal_code,mail_add_postal)'>

		<%		
		}else{
		if(mailpostalcode != null) {%>
			<input type='text' onBlur='makeValidString(this); if(this.value !="") searchCode(this,mail_add_postal_code2,mail_add_postal2)' name='mail_add_postal_code2' id='mail_add_postal_code2' size='8' maxlength='8' value="<%=mailpostalcode%>" ><input type="hidden" name="mail_add_postal2" id="mail_add_postal2"><input type='button' name='postal_code' id='postal_code' value='?' class='button' onclick='searchCode(this,mail_add_postal_code2,mail_add_postal2)'>
				<%}else{%>
					<input type='text' onBlur='makeValidString(this); if(this.value !="") searchCode(this,mail_add_postal_code2,mail_add_postal2)'  name='mail_add_postal_code2' id='mail_add_postal_code2' size='8' maxlength='8'><input type="hidden" name="mail_add_postal2" id="mail_add_postal2"><input type='button' name='postal_code' id='postal_code' value='?' class='button' onclick='searchCode(this,mail_add_postal_code2,mail_add_postal2)'>
				<%}

	}
	}			
	%>
	<!--<%=str7%>--><%=strmap2%></td>
	<% }
	else if(effstatus.equals("D")) {%>
	<td width='20%' class="fields"><%=strrep1%><%=strrep2%></td>
	<td width='20%' class="fields"><%=strofp1%><%=strofp2%></td>
	<td width='20%' class="fields"><%=strmap1%><%=strmap2%></td>
	<% }%>
</tr>
<tr>
	<td  width='3%' class='label'><fmt:message key="Common.country.label" bundle="${common_labels}"/>&nbsp;</td>
	<%if(effstatus.equals("E")) {%>
	<td width='20%' class="fields"><%=str8%><%=strrec2%></td>
	<td width='20%' class="fields"><%=str10%><%=strofc2%></td>
	<td width='20%' class="fields"><%=str12%><%=strmac2%></td>
	<% }
	else if(effstatus.equals("D")) {%>
	<td width='20%' class="fields"><%=strrec1%><%=strrec2%></td>
	<td width='20%' class="fields"><%=strofc1%><%=strofc2%></td>
	<td width='20%' class="fields"><%=strmac1%><%=strmac2%></td>
	<%}%>
</tr>
</table>
</td>
</tr>

<tr>
<td class='BODYCOLORFILLED'>&nbsp;
</td>
</tr>
<tr>
<td class='BODYCOLORFILLED'>&nbsp;
</td>
</tr>
<tr>
<td class='BODYCOLORFILLED'>&nbsp;
</td>
</tr>
<tr>
<td class='BODYCOLORFILLED'>&nbsp;
</td>
</tr>
<tr>
<td class='BODYCOLORFILLED'>&nbsp;
</td>
</tr>
<tr>
<td class='BODYCOLORFILLED'>&nbsp;
</td>
</tr>
<tr>
<td class='BODYCOLORFILLED'>&nbsp;
</td>
</tr>
<tr>
<td class='BODYCOLORFILLED'>&nbsp;
</td>
</tr>
<tr>
<td class='BODYCOLORFILLED'>&nbsp;
</td>
</tr>
<tr>
<td class='BODYCOLORFILLED'>&nbsp;
</td>
</tr>
<tr>
<td class='BODYCOLORFILLED'>&nbsp;
</td>
</tr>
<tr>
<td class='BODYCOLORFILLED'>&nbsp;
</td>
</tr>
<tr>
<td class='BODYCOLORFILLED'>&nbsp;
</td>
</tr>
<tr>
<td class='BODYCOLORFILLED'>&nbsp;
</td>
</tr>
</table>
	<%  

	if(newOtherStaff){%>

  	       	<input type='hidden' name='function' id='function' value='insert'>
  	       	<input type='hidden' name='function_name' id='function_name' value='insert'>
  	     

  	       <%}else{%>
               
  	       	<input type='hidden' name='function' id='function' value='modify'>
  	       	<input type='hidden' name='function_name' id='function_name' value='modify'>
  	       	<%}
  	       	
  	       	}catch(Exception e){
			e.printStackTrace();
			}
  	       	
		finally{
			ConnectionManager.returnConnection(conn,request);
		}%>


  	       	<input type='hidden' name='other_staff_type1' id='other_staff_type1' >
  	       	<input type='hidden' name='other_staff_id1' id='other_staff_id1'  >
  	       	<input type='hidden' name='other_staff_name1' id='other_staff_name1'  >
  	       	<input type='hidden' name='short_name1' id='short_name1' >
  	       	<input type='hidden' name='eff_status1' id='eff_status1' >
  	       	<input type='hidden' name='date_of_birth1' id='date_of_birth1' >
  	       	<input type='hidden' name='date_of_birth2' id='date_of_birth2' >
  	       	<input type='hidden' name='otherstaffid' id='otherstaffid' value=<%=otherstaffid%> >
  	 	    <input type='hidden' name='server_date' id='server_date' value=<%=str13%> >
		    <input type='hidden' name='text5' id='text5' value=''>
			<input type='hidden' name='text6' id='text6' value=''>
			<input type='hidden' name='nat_id_prompt' id='nat_id_prompt' value='<%=nat_id_prompt%>'>
			<input type='hidden' name='long_name1' id='long_name1' >

			<!--Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011-->
			<input type="hidden" name="eff_stat" id="eff_stat" value="<%=effstatus%>">
			<input type='hidden' name='citizenship_code' id='citizenship_code' value='<%=citizenship_code%>'>
			<input type='hidden' name='citizen_nat_code' id='citizen_nat_code' value='<%=citizen_nat_code%>'>
			<input type='hidden' name='isResidencyApplYN' id='isResidencyApplYN' value='<%=isResidencyApplYN%>'>
			<input type="hidden" name="natid_mand_yn" id="natid_mand_yn" value="<%=natid_mand_yn%>">
			<input type="hidden" name="oth_alt_val" id="oth_alt_val" value="<%=oth_alt_val%>">
			<input type="hidden" name="other_alt_type_no" id="other_alt_type_no" value="<%=other_alt_type_no%>">
			<input type="hidden" name="other_alt_type_desc" id="other_alt_type_desc" value="<%=other_alt_type_desc%>">
			<input type="hidden" name="alt_id1_type" id="alt_id1_type" value="<%=alt_id1_type%>">
			<input type="hidden" name="alt_id1_length" id="alt_id1_length" value="<%=alt_id1_length%>">
			<input type="hidden" name="oth_alt_length" id="oth_alt_length" value="<%=oth_alt_length%>">

<script>
		if('<%=emplstatus%>' == "T") 
		{
			document.getElementById('popempid').innerHTML="Empl ID <input type='text' value='<%=employeeid%>' name='employee_id' maxlength='30' size ='30' READONLY>";

		}
function echeck10()
     		{
     			if(OtherStaff1_form.empl_status.value == "T")			
				{
					document.getElementById('popempid').innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Empl ID &nbsp;<input type='text' value='<%=employeeid%>' name='employee_id' maxlength='30' size ='30' READONLY>";
					
				}
     			else 	
     			 	document.getElementById('popempid').innerHTML="&nbsp;";	
     		}
function echeck1(Obj)
     		{
     			if(Obj.value == "T") 
				{
				document.getElementById('popempid').innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Empl ID &nbsp;<input id='employee_id'  type='text' value='' onBlur='makeValidString(this)'  name='employee_id' maxlength='30' size ='30'>";	
				}
     			else 	
     			 	document.getElementById('popempid').innerHTML="";	
     		}
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

function maxLengthPaste(event, field, maxChars) {
    // Prevent the default paste behavior
    event.preventDefault();

    // Get the clipboard data
    let clipboardData;
    if (event.clipboardData) {
        clipboardData = event.clipboardData.getData('text');
    } else if (window.clipboardData) {
        clipboardData = window.clipboardData.getData('Text');
    } else {
        // Fallback if clipboardData is not available
        return;
    }

    // Calculate the new length if paste is allowed
    if ((field.value.length + clipboardData.length) > maxChars) {
        // Generate the error message
        const errors1 = getMessage('OBJ_CANNOT_EXCEED', 'Common').replace('$', maxChars);
        alert(errors1);
        return;
    }
    field.value += clipboardData;
}

const inputField = document.getElementById('myInputField');
inputField.addEventListener('paste', function(event) {
    maxLengthPaste(event, this, 100); // For example, limit to 100 characters
});

function ChkKey(evnt)
{ 
	if(evnt.keyCode == '13')
		return false;
}

//Added for this CRF HAS-CRF-160
function enabledOtherAltId(){  
        document.OtherStaff1_form.other_alt_no.value="";
		if(document.OtherStaff1_form.other_alt_type.selectedIndex != 0){ 
			document.OtherStaff1_form.other_alt_no.disabled = false;
			document.OtherStaff1_form.other_alt_no.value="";
			document.OtherStaff1_form.other_alt_no1.value="";
		}else { 
			document.OtherStaff1_form.other_alt_no.disabled = true;			
		}
}
</script>
</form>
</body>
</html>

