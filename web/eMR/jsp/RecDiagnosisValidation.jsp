<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.Connection, java.sql.PreparedStatement, java.sql.ResultSet, java.util.StringTokenizer, java.util.HashMap,java.util.Hashtable, java.util.ArrayList, java.io.InputStreamReader, java.io.ByteArrayInputStream, java.io.BufferedReader, webbeans.eCommon.ConnectionManager,com.ehis.util.*,org.json.simple.*"%>

 
<html>
<head>
	<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script src='../js/RecDiagnosis.js' language='javascript'></script>
	<script src='../js/RecDiagnosisMain.js' language='javascript'></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
</head>
<body onKeyDown='lockKey()'>
<%
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue 
	Connection con = null; 
	PreparedStatement stmt_appln_yn=null;
	ResultSet rs_appln_yn = null;
	//Statement stmt_one=null;
	PreparedStatement stmt_one=null;
	Statement stmtOral=null;
	ResultSet rset = null;
	PreparedStatement stmt=null;
	ResultSet rs = null;
	PreparedStatement stmt1=null;
	ResultSet rs1 = null;
	ResultSet rs_free = null;
	ResultSet oralRS = null;
	PreparedStatement pstmtpat = null;
	ResultSet rsetpat = null;

	ResultSet rsset				= null;
	PreparedStatement prepstmt	= null;
	
	String diagcode="";

		
	String b_age = request.getParameter("b_age")==null?"":request.getParameter("b_age");
	String b_months = request.getParameter("b_months")==null?"":request.getParameter("b_months");
	String b_days = request.getParameter("b_days")==null?"":request.getParameter("b_days");
	String b_hours = request.getParameter("b_hours")==null?"":request.getParameter("b_hours");
	String onset_date = request.getParameter("onset_date")==null?"":request.getParameter("onset_date");

	
	String term_set_id = request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
	
	

	String term_set_code = request.getParameter("term_set_code")==null?"":request.getParameter("term_set_code");
	String term_sht_desc = request.getParameter("term_sht_desc")==null?"":request.getParameter("term_sht_desc"); // Added by mujafar for ML-MMOH-CRF-1281 US3
	term_sht_desc = java.net.URLDecoder.decode(term_sht_desc);
	String isMultiDescAppl = request.getParameter("isMultiDescAppl")==null?"":request.getParameter("isMultiDescAppl");
	int descCount = 0;

	String sex = request.getParameter("Sex")==null?"":request.getParameter("Sex");

	String dob = request.getParameter("Dob")==null?"":request.getParameter("Dob");

	String code_indicator = request.getParameter("code_indicator")==null?"":request.getParameter("code_indicator");

	term_set_code = term_set_code.toUpperCase();

	String modal_yn = request.getParameter("modal_yn")==null?"":request.getParameter("modal_yn"); 

	String step = request.getParameter("step")==null?"":request.getParameter("step"); 
	String mode = request.getParameter("mode")==null?"R":request.getParameter("mode"); 
	String anatomical_site_val = request.getParameter("anatomical_site_val")==null?"":request.getParameter("anatomical_site_val"); 
	String diag_class = request.getParameter("diag_class")==null?"":request.getParameter("diag_class"); 

	//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
	String function_id = request.getParameter("function_id")==null?"":request.getParameter("function_id");
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");

	String locale			= (String)session.getAttribute("LOCALE");


	String short_desc = "";
	String long_desc = "";
	String link_Complaint = "";
	/*Added by Maheshwaran K for the SKR-CRF-0020 as on 03/05/2012*/
	/*Start*/
	String default_status="";
	/*End*/

	String age_spec_ind_val = "";
	String age_group_appl_yn = "";
	//String sensitivity_appl_yn = "";
	//String term_set_desc = "";
	//String notification_appl_yn = "";
	String notifiable_yn = "";

	int recordcnt = 0;
	int maxrecord = 0;
	StringBuffer sql = new StringBuffer();
	String sql_appln_yn = "";
	String sql_cnt = "";
	String free_text_applicable_yn = "";
	String oralSites			="";
	String anatomical_site_code	="";
	String anatomical_short_desc="";
	
	//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
	Boolean isDeceasedDiagClassDeathRegAppl = false;
	String deceased_yn = "N";
	String primary_diag_class = "";
	String secondary_diag_class = "";

	try
	{
		con = ConnectionManager.getConnection(request);

		isDeceasedDiagClassDeathRegAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","DECEASED_DIAG_CLASS_DEATH_REG");//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742

		String mr_param_sql = "SELECT primary_diag_class, secondary_diag_class FROM mr_parameter";
		
		prepstmt = con.prepareStatement(mr_param_sql);
		rsset = prepstmt.executeQuery();

		if(rsset!=null && rsset.next()){
			primary_diag_class = (rsset.getString("primary_diag_class")==null || rsset.getString("primary_diag_class")=="")?"" : rsset.getString("primary_diag_class");
			secondary_diag_class = (rsset.getString("secondary_diag_class")==null || rsset.getString("secondary_diag_class")=="")?"" : rsset.getString("secondary_diag_class");
		}

		if(prepstmt!=null) prepstmt.close();
		if(rsset!=null) rsset.close();

		//stmt_one=con.createStatement();
		/**/

	  //if( !step.equals("4") && !step.equals("5")){  // modified for PE
	  if( step.equals("1") ){

		if(!mode.equals("modify") )
		{
			String free_text = "Select FREE_text_applicable_yn from mr_term_set where term_set_id =? and eff_status = 'E' ";
			stmt_one=con.prepareStatement(free_text);
			stmt_one.setString(1,term_set_id);
			rs_free=stmt_one.executeQuery();

			if(rs_free != null && rs_free.next())
			{
				free_text_applicable_yn = rs_free.getString("free_text_applicable_yn");

			}
			if(free_text_applicable_yn.equals("Y"))
			{
				out.println("<script>if(parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc)				parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.disabled=false;</script>");
				
				
			}else
			{
				out.println("<script>parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.disabled=true;</script>");
				
			}
		if (rs_free != null) rs_free.close();
		}
		else
			out.println("<script>parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.disabled=true;</script>");

	  }
		/**/
if(step.equals("2")){
		sql_cnt="select short_desc ,long_desc,code_indicator,notifiable_yn from MR_D_"+term_set_id+"_VW where term_code = ? " ; 
		stmt1 = con.prepareStatement(sql_cnt);
		stmt1.setString(1,term_set_code);
		rs1 =  stmt1.executeQuery();
		while(rs1.next())
		{
				short_desc = rs1.getString("short_desc");
				long_desc = rs1.getString("long_desc");
				code_indicator = rs1.getString("code_indicator");
				notifiable_yn = rs1.getString("notifiable_yn");
				maxrecord++;

		}
		
		if(maxrecord == 0){
				out.println("<script>alert(getMessage('INVALID_DIAGCODE'));parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.value='';parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.select();parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.focus();</script>");
		}else{
			sql_appln_yn = "select AGE_GROUP_APPL_YN,SENSITIVITY_APPL_YN,TERM_SET_DESC,NOTIFICATION_APPL_YN from mr_term_set where TERM_SET_ID = ?";
			stmt_appln_yn = con.prepareStatement(sql_appln_yn);
			stmt_appln_yn.setString(1,term_set_id);
			rs_appln_yn = stmt_appln_yn.executeQuery();
			while(rs_appln_yn.next()){
				age_group_appl_yn = rs_appln_yn.getString("AGE_GROUP_APPL_YN");
				//sensitivity_appl_yn = rs_appln_yn.getString("SENSITIVITY_APPL_YN");
				//term_set_desc = rs_appln_yn.getString("TERM_SET_DESC");
				//notification_appl_yn = rs_appln_yn.getString("NOTIFICATION_APPL_YN");
			}
			if(rs_appln_yn!=null)  rs_appln_yn.close();
			if(stmt_appln_yn!=null)  stmt_appln_yn.close();
			if(age_group_appl_yn.equals("Y")){
				String sql_age_spec_ind = " select case when sysdate-to_date(?,'dd-mm-yyyy') between          NVL(ADULT_MIN_AGE_VALUE,0)*decode(ADULT_MIN_AGE_UNIT,'Y',365,'M',30,'D',1,1) AND NVL(ADULT_MAX_AGE_VALUE,0) *decode(ADULT_MAX_AGE_UNIT,'Y',365,'M',30,'D',1,1) THEN 'A'	WHEN  Sysdate-to_date(?,'dd-mm-yyyy') between NVL(PEAD_MIN_AGE_VALUE,0)*decode(PEAD_MIN_AGE_UNIT,'Y',365,'M',30,'D',1,1) AND NVL(PEAD_MAX_AGE_VALUE,0) *decode(PEAD_MAX_AGE_UNIT,'Y',365,'M',30,'D',1,1) THEN 'P' WHEN Sysdate-to_date(?,'dd-mm-yyyy') between NVL(NB_MIN_AGE_VALUE ,0)*decode(NB_MIN_AGE_UNIT,'Y',365,'M',30,'D',1,1) AND NVL(NB_MAX_AGE_VALUE,0) *decode(NB_MAX_AGE_UNIT,'Y',365,'M',30,'D',1,1) THEN 'N'  END FROM MR_PARAMETER ";
				stmt_appln_yn = con.prepareStatement(sql_age_spec_ind);
				stmt_appln_yn.setString(1,dob);
				stmt_appln_yn.setString(2,dob);
				stmt_appln_yn.setString(3,dob);
				rs_appln_yn = stmt_appln_yn.executeQuery();
				while(rs_appln_yn.next())
					age_spec_ind_val = rs_appln_yn.getString(1)==null?"":rs_appln_yn.getString(1);	
//			}	
			
			if(rs_appln_yn!=null)  rs_appln_yn.close();
			if(stmt_appln_yn!=null)  stmt_appln_yn.close();
			int j = 0;
			j++;
			sql.append("select short_desc,long_desc,code_indicator,notifiable_yn from MR_D_"+term_set_id+"_VW where term_code = ? " ); 
			if(!sex.equals("")){
				sql.append(" and ( gender_spec_ind = ? OR gender_spec_ind IS NULL) ");
			}
			if(age_group_appl_yn.equals("Y") && (!age_spec_ind_val.equals(""))){
				//sql.append(" and (age_spec_ind is null or age_spec_ind =?)");
				sql.append(" and (nvl(age_spec_ind,'O') NOT IN ('A','P','N') or age_spec_ind =?)");
			}
			stmt = con.prepareStatement(sql.toString());
			stmt.setString(j++,term_set_code);
			
			if(!sex.equals("")){
				stmt.setString(j++,sex);
			}
			if( age_group_appl_yn.equals("Y") && (!age_spec_ind_val.equals(""))){
				stmt.setString(j++,age_spec_ind_val);
			}
			rs = stmt.executeQuery();
			while(rs.next()){
				short_desc = rs.getString("short_desc");
				long_desc = rs.getString("long_desc");
				code_indicator = rs.getString("code_indicator");
				notifiable_yn = rs.getString("notifiable_yn");
				recordcnt++;
			}

			if(recordcnt == 0){
				out.println("<script>alert(getMessage('MR_INVALID_DIAG_CODE_FOR_PATIENT','MR'));parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.value='';parent.RecDiagnosisAddModify.document.RecDaignosis_form.LongDescription.value='';parent.RecDiagnosisAddModify.document.RecDaignosis_form.notifiable_yn.value='';parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.select();parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.focus();</script>");
			}else{
				if(modal_yn.equals("Y")){
					out.println("<script>parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.value=\""+short_desc+"\";parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.LongDescription.value=\""+long_desc+"\";parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value=\""+term_set_code+"\";parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.code_indicator.value=\""+code_indicator+"\";parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.notifiable_yn.value=\""+notifiable_yn+"\";parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.onblur();"); 	
				}else{	
					out.println("<script>parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.value=\""+short_desc+"\";parent.RecDiagnosisAddModify.document.RecDaignosis_form.LongDescription.value=\""+long_desc+"\";parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value=\""+term_set_code+"\";parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_indicator.value=\""+code_indicator+"\";parent.RecDiagnosisAddModify.document.RecDaignosis_form.notifiable_yn.value=\""+notifiable_yn+"\";parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.onblur();"); 
			}
		if(long_desc!=null )
					{
					if(modal_yn.equals("Y"))
						{
						out.println("parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.exclamation.style.visibility='visible';");
						}
					else
						{
						out.println("parent.RecDiagnosisAddModify.document.RecDaignosis_form.exclamation.style.visibility='visible';");
						}
					}
			else
					{
						if(modal_yn.equals("Y"))
						{
						out.println("parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.exclamation.style.visibility='hidden';");
						}
					else
						{
						out.println("parent.RecDiagnosisAddModify.document.RecDaignosis_form.exclamation.style.visibility='hidden';");
						}
						
					}
			}
			 out.println("</script>");
		  }
		 else
		{
			
		if(modal_yn.equals("Y")){
			out.println("<script>parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.value=\""+short_desc+"\";parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value=\""+term_set_code+"\";parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.code_indicator.value=\""+code_indicator+"\";parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.notifiable_yn.value=\""+notifiable_yn+"\";parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.onblur();"); 
		}else{
			out.println("<script>parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.value=\""+short_desc+"\";parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value=\""+term_set_code+"\";parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_indicator.value=\""+code_indicator+"\";parent.RecDiagnosisAddModify.document.RecDaignosis_form.notifiable_yn.value=\""+notifiable_yn+"\";parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.onblur();"); 
		}
			if(long_desc!=null )
					{
						
					if(modal_yn.equals("Y"))
						{
						out.println("parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.exclamation.style.visibility='visible';");
						}
					else
						{
						out.println("parent.RecDiagnosisAddModify.document.RecDaignosis_form.exclamation.style.visibility='visible';");
						}
					}
			else
					{
						if(modal_yn.equals("Y"))
						{
						out.println("parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.exclamation.style.visibility='hidden';");
						}
					else
						{
						out.println("parent.RecDiagnosisAddModify.document.RecDaignosis_form.exclamation.style.visibility='hidden';");
						}
						
					}
			 out.println("</script>");
		}
		}
	}else if(step.equals("1"))
	{
	
	
	if(isMultiDescAppl.equals("true") && term_set_id.equals("ICD10"))
	{  // Added by mujafar for ML-MMOH-CRF-1281 US3
		
			JSONObject DescriptionJsonObj		= new JSONObject();
		DescriptionJsonObj = eMR.MRCommonBean.getTermCodeDescription(con,term_set_id,term_set_code);
		JSONArray DescriptionJsonArray 		= (JSONArray)DescriptionJsonObj.get("results");
		JSONObject termCodeCountObj = new JSONObject();
		JSONObject multi_desc_ynObj = new JSONObject();
		Integer termCodeCount =0;
		String multi_desc_yn = "N";
		if(DescriptionJsonArray.size() > 0)
		{
		termCodeCountObj	= (JSONObject)DescriptionJsonArray.get(0);
		

		termCodeCount = (Integer)termCodeCountObj.get("termCodeCount");
		multi_desc_yn = checkForNull((String)termCodeCountObj.get("multi_desc_yn"));
		if(isMultiDescAppl.equals("true") && termCodeCount == 1 && multi_desc_yn.equals("Y")) 
			descCount = 1;
		}
		
		
		if(descCount == 1)
		{
			
			%>
		<script>
		
		parent.RecDiagnosisAddModify.document.getElementById('other_disp1').style.visibility='visible';
		parent.RecDiagnosisAddModify.document.getElementById('other_disp2').style.visibility='visible';
		
		
		var select = parent.RecDiagnosisAddModify.document.forms[0].term_oth_desc;
						
						 if (select.type!='hidden')
						{
							
							while (select.options.length > 0 )
							select.remove(select.options[0]);
							var element =parent.RecDiagnosisAddModify.document.createElement('OPTION');
							element.text = '-----'+getLabel("Common.defaultSelect.label","Common")+'----- ';
							element.value= '';
							parent.RecDiagnosisAddModify.document.forms[0].term_oth_desc.add(element);
							<%
							JSONObject temCodeDescListObj = new JSONObject();
							if(DescriptionJsonArray.size() > 0)
							temCodeDescListObj	= (JSONObject)DescriptionJsonArray.get(0);

							String descriptions="";
							for(int i=1;i<=10;i++)
							{
								descriptions = checkForNull((String)temCodeDescListObj.get("description"+i));
								
							%>	
							var element =parent.RecDiagnosisAddModify.document.createElement('OPTION');
							element.text = "<%=descriptions%>";
							element.value= "<%=descriptions%>";
							if(element.value!='')
							parent.RecDiagnosisAddModify.document.forms[0].term_oth_desc.add(element);
							<%
							
							if(term_sht_desc.equals(descriptions))
							{
								%>
								
								element.selected=true;
								
								<%
							}
								
							}	
							%>
				   
					
					     }	
		
		
		
			
		</script>
			
			
			<%
			
		}
	
	}	
		

//out.println("<script>alert(\"@@@inter term_set_id :"+term_set_id+"\");</script>");			
/*
Anjaneya Added fore the code if list values are added if we selected diffrent set
Clearing the prevous values
*/%>
<script>
		var build_diag_class_type	 ="";// Added For SRR-CRF-303.2
		var obj_type = parent.RecDiagnosisAddModify.document.forms[0].diag_classfication;
		var length1  = obj_type.length;
		for(i=0;i<length1;i++) {
		obj_type.remove(1);
		}
</script>

<%

//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
if(isDeceasedDiagClassDeathRegAppl){

String sqlpatid = " SELECT deceased_yn FROM mp_patient WHERE patient_id = ? ";

pstmtpat = con.prepareStatement(sqlpatid);
pstmtpat.setString(1,patient_id);
rsetpat = pstmtpat.executeQuery();

if(rsetpat!=null && rsetpat.next()){
	deceased_yn	= rsetpat.getString("deceased_yn")==null?"N":rsetpat.getString("deceased_yn");
}

}

// Logic end here.
String shortdesc="";
			/*Default_status column was added in the query by Maheshwaran K for the SKR-CRF-0020 as on 03/05/2012*/
			String sql_diag="SELECT A.DIAG_CLASS_CODE, mr_get_desc.mr_diag_class(a.diag_class_code,?,'2')SHORT_DESC,DIAG_CLASS_TYPE,B.DEFAULT_STATUS FROM MR_DIAG_CLASS A, MR_DIAG_CLASS_DTL B WHERE A.DIAG_CLASS_CODE = B.DIAG_CLASS_CODE AND B.TERM_SET_ID=? AND A.EFF_STATUS='E' ORDER BY SHORT_DESC ";
			//String sql_diag="SELECT A.DIAG_CLASS_CODE, mr_get_desc.mr_diag_class(a.diag_class_code,'"+locale+"','2')SHORT_DESC,DIAG_CLASS_TYPE FROM MR_DIAG_CLASS A, MR_DIAG_CLASS_DTL B WHERE A.DIAG_CLASS_CODE = B.DIAG_CLASS_CODE AND B.TERM_SET_ID='"+term_set_id+"' AND A.EFF_STATUS='E' ORDER BY SHORT_DESC ";
			int  i=1;
			String diag_class_type="";
			String defSelDiagClsCode = ""; //Added by Ajay H. for TH-KW-CRF-165.1
			String defSelDiagClsType = "";
			stmt_one=con.prepareStatement(sql_diag);
			stmt_one.setString(1,locale);
			stmt_one.setString(2,term_set_id);
			rset=stmt_one.executeQuery();

			while( rset.next() ){
					 diagcode				= rset.getString( "DIAG_CLASS_CODE" ) ;
					 shortdesc				=rset.getString("SHORT_DESC");
					 diag_class_type	=rset.getString("DIAG_CLASS_TYPE");
					 /*Added by Maheshwaran K for the SKR-CRF-0020 as on 03/05/2012*/
					/*Start*/
					default_status	=rset.getString("DEFAULT_STATUS");
					 /*End*/
					
					//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
					if(isDeceasedDiagClassDeathRegAppl){
						if(deceased_yn.equals("Y") || function_id.equals("RECORD_DIAGNOSIS_FROM_POPUP")){
							if(diag_class.equals(diagcode)){%>
								<script>
								var obj=parent.RecDiagnosisAddModify.document.forms[0].diag_classfication;
								opt=parent.RecDiagnosisAddModify.document.createElement('OPTION');
								opt.value="<%=diagcode%>";
								opt.text="<%=shortdesc%>";
								obj.add(opt);
								opt.selected = true;
								</script>					
								<% 
							}else{%>
								<script>
								var obj=parent.RecDiagnosisAddModify.document.forms[0].diag_classf_desc;
								opt=parent.RecDiagnosisAddModify.document.createElement('OPTION');
								opt.value="<%=diagcode%>";
								opt.text="<%=shortdesc%>";
								obj.add(opt);
								<%if((default_status.equals("Y"))&&(diag_class.equals(""))){%>
									opt.selected = true;
								<%
									defSelDiagClsCode = diagcode;
									defSelDiagClsType = diag_class_type;
								}%>
								build_diag_class_type	=	build_diag_class_type+"<input type='hidden' name='diag_class_type_<%=i%>' value='<%=diag_class_type%>'>";
								</script>
							<%}
						}else{
							if(!diagcode.equals(primary_diag_class) && !diagcode.equals(secondary_diag_class)){
								if(diag_class.equals(diagcode)){%>
									<script>
									var obj=parent.RecDiagnosisAddModify.document.forms[0].diag_classfication;
									opt=parent.RecDiagnosisAddModify.document.createElement('OPTION');
									opt.value="<%=diagcode%>";
									opt.text="<%=shortdesc%>";
									obj.add(opt);
									opt.selected = true;
									</script>					
									<% 
								}else{%>
									<script>
									var obj=parent.RecDiagnosisAddModify.document.forms[0].diag_classf_desc;
									opt=parent.RecDiagnosisAddModify.document.createElement('OPTION');
									opt.value="<%=diagcode%>";
									opt.text="<%=shortdesc%>";
									obj.add(opt);
									<%if((default_status.equals("Y"))&&(diag_class.equals(""))){%>
										opt.selected = true;
									<%
										defSelDiagClsCode = diagcode;
										defSelDiagClsType = diag_class_type;
									}%>
									build_diag_class_type	=	build_diag_class_type+"<input type='hidden' name='diag_class_type_<%=i%>' value='<%=diag_class_type%>'>";
									</script>
								<%}
							}
						}
					}else{
						if(diag_class.equals(diagcode)){%>
							<script>
							var obj=parent.RecDiagnosisAddModify.document.forms[0].diag_classfication;
							opt=parent.RecDiagnosisAddModify.document.createElement('OPTION');
							opt.value="<%=diagcode%>";
							opt.text="<%=shortdesc%>";
							obj.add(opt);
							opt.selected = true;
							</script>					
							<% 
						}else{%>
							<script>
							var obj=parent.RecDiagnosisAddModify.document.forms[0].diag_classf_desc;
							opt=parent.RecDiagnosisAddModify.document.createElement('OPTION');
							opt.value="<%=diagcode%>";
							opt.text="<%=shortdesc%>";
							obj.add(opt);
							<%
							/*Added by Maheshwaran K for the SKR-CRF-0020 as on 03/05/2012*/
							/*Start*/
							if((default_status.equals("Y"))&&(diag_class.equals("")))
								{
								%>
								opt.selected = true;
								<%
								defSelDiagClsCode = diagcode; //Added by Ajay H. for TH-KW-CRF-165.1
								defSelDiagClsType = diag_class_type;
								}
							/*End*/	
							%>
							build_diag_class_type	=	build_diag_class_type+"<input type='hidden' name='diag_class_type_<%=i%>' value='<%=diag_class_type%>'>";
							</script>
						<% 
						}
					}
						i++;
				}
				//Added by Ajay H. for TH-KW-CRF-165.1
				if(!defSelDiagClsCode.equals("")){
					%><script>onDefltDiagCls('<%=defSelDiagClsCode%>', '<%=defSelDiagClsType%>')</script><%
				
				}%>
			<SCRIPT LANGUAGE="JavaScript">
			<!--
				 
					parent.RecDiagnosisAddModify.document.getElementById("id_diag_class_type").innerHTML=build_diag_class_type;
			//-->
			</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



		
	<%}
	/**/
	else if(step.equals("3"))	{
	%>
	<script>
	
	var obj_type = parent.RecDiagnosisAddModify.document.forms[0].anatomical_oral_sites;
	var length1  = obj_type.length;

	for(i=0;i<length1;i++) 
	{
	obj_type.remove(1);
	}
	</script>
	<%
		if(anatomical_site_val.equals("C"))	
		{
			oralSites = "select anatomical_site_code,am_get_desc.am_anatomical_site(anatomical_site_code,'"+locale+"',2)short_desc from am_anatomical_site where oral_cavity_yn = 'Y' and eff_status = 'E' order by short_desc";
		}else
		{
			oralSites = "select anatomical_site_code,am_get_desc.am_anatomical_site(anatomical_site_code,'"+locale+"',2)short_desc from am_anatomical_site where oral_cavity_yn = 'N' and eff_status = 'E' order by short_desc"; //Newly added  by Name :Selvin M  Date :31 May 2011 INCIDENT NO: 27497 Changes:newly added order by	
		}
	    //out.println("oralSites.."+oralSites);
			stmtOral=con.createStatement();
			oralRS = stmtOral.executeQuery(oralSites);
			while( oralRS.next() )
			{
					 anatomical_site_code = oralRS.getString( "ANATOMICAL_SITE_CODE" ) ;
					 anatomical_short_desc= oralRS.getString("SHORT_DESC");
		
			%><script>
			var obj=parent.RecDiagnosisAddModify.document.forms[0].anatomical_oral_sites;
			//var opt="";
			opt=parent.RecDiagnosisAddModify.document.createElement('OPTION');
			opt.value="<%=anatomical_site_code%>";
			opt.text="<%=anatomical_short_desc%>";
			obj.add(opt);
			</script>					
				<% 
			}	
	}
	else if(step.equals("4"))
	{	
		int n_days = 0;
		int n_months = 0;
		int n_age = 0;
		int n_hours = 0;

		
			if ( !b_days.equals("")) 
				n_days = Integer.parseInt(b_days);
			if ( !b_months.equals("")) 
				n_months = Integer.parseInt(b_months);
	        if (! b_age.equals("")) 
				n_age = Integer.parseInt(b_age);
	        if ( !b_hours.equals(""))
				n_hours = Integer.parseInt(b_hours);
			


			String DOB = "";
		    //String sql_dob = "select calculate_date_of_birth_hours ("+b_age+","+b_months+","+b_days+","+b_hours+") from dual";
		    String sql_dob = "select To_Char(To_Date( CALCULATE_DATE_OF_BIRTH_YMDH ("+n_age+","+n_months+","+n_days+","+n_hours+"),'dd/mm/yyyy hh24:mi:ss'),'dd/mm/yyyy hh24:mi') from dual";
		
			stmt = con.prepareStatement(sql_dob);
			rs = stmt.executeQuery();
			if (rs != null){
				rs.next();
		        DOB = rs.getString(1);
			}
			if ( DOB !=null && !DOB.equals("") ){
				if (!locale.equals("en")){
					DOB = DateUtils.convertDate(DOB,"DMYHM","en",locale);
				}
			}

			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		

			out.println("<script>parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.onset_date.value=\""+DOB+"\";parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';</script>"); 
		
			


			if(stmt != null) stmt.close();
	}
	else if(step.equals("5"))
	{

			String age_value = "";
			String year_value = "";
			String month_value = "";
			String day_value = "";
			String hours_value = "";
			
			if (!locale.equals("en")) {	
			onset_date = DateUtils.convertDate(onset_date,"DMYHM",locale,"en");				
			}

		    String sql_dmy = "select MP_CALCULATE_AGE_YMD(to_date(?,'dd/mm/yyyy hh24:mi'),'YMDH',sysdate) from dual";
			stmt = con.prepareStatement(sql_dmy);
			stmt.setString(1,onset_date);
			rs = stmt.executeQuery();

			
			if (rs != null){

				rs.next();
			   age_value = rs.getString(1);	
			}
			StringTokenizer st = new StringTokenizer(age_value," ");

			while ( st.hasMoreTokens() ) {

			String date_elmnt = st.nextToken();			

			char ymdh_char = date_elmnt.charAt(date_elmnt.length()-1);			

			String ymdh_elmnt = date_elmnt.substring(0,(date_elmnt.length()-1));			

			if(ymdh_char=='Y') {
				year_value = ymdh_elmnt;
			} else if (ymdh_char=='M') {
				month_value	= ymdh_elmnt;
			} else if (ymdh_char=='D') {
				day_value	= ymdh_elmnt;
			} else if (ymdh_char=='H') {
				hours_value	= ymdh_elmnt;
			}
		}
		

			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		

			out.println("<script>parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.b_days.value=\""+day_value+"\";parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.b_months.value=\""+month_value+"\";parent.parent.frames[1].RecDiagnosisAddModify.document.RecDaignosis_form.b_age.value=\""+year_value+"\";parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';</script>"); 
		

	
	
	}
	/**/
	if (rset != null) rset.close();
	if(rs1!=null) rs1.close();

	if(stmt1!=null) stmt1.close();

	if(rs!=null) rs.close();
	if(oralRS!=null) oralRS.close();
	if(stmt!=null) stmt.close();
	if(stmtOral!=null) stmtOral.close();
	if(stmt_one!=null) stmt_one.close();
	if(pstmtpat!=null) pstmtpat.close();
	if(rsetpat!=null) rsetpat.close();
	}
	catch(Exception e){
		e.printStackTrace();
	}
	finally
	{
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
	

%>
<%!
public static String checkForNull(String inputString){ // Added by mujafar for ML-MMOH-CRF-1281 US3
return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}
public static String checkForNull(String inputString, String defaultValue){
return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
%>
<input type="hidden" name="diagcode" id="diagcode" value="<%=diagcode%>">
</body>
</html>

