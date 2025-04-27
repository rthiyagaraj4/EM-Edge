<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import ="java.sql.*,java.net.*,java.text.*, webbeans.eCommon.*,eCommon.Common.*,org.json.simple.*"%> <!-- modified by mujafar for ML-MMOH-CRF-1281 US3-->
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../js/RecDiagnosis.js' language='javascript'></script>
<script src='../js/RecDiagnosisMain.js' language='javascript'></script>

<%
	Connection con = null; 
    PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet rs = null;
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String locale = checkForNull((String)session.getAttribute("LOCALE")); 
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<%


	try
	{
		con = ConnectionManager.getConnection(request);
		String code_set			=	checkForNull(request.getParameter("code_set"));
		String p_p_diag_code	= 	request.getParameter("p_diag_code");
		String p_scheme			=	request.getParameter("p_scheme");
		String cause_indicator	=	request.getParameter("p_cause_indicator");
		String sensitive_yn		=	request.getParameter("p_sensitive_yn");
		String sex		=	request.getParameter("Sex");
		String dob		=	request.getParameter("Dob");
		int descCount=0;
		String isMultiDescAppl = request.getParameter("isMultiDescAppl"); // added by mujafar for ML-MMOH-CRF-1281
		JSONObject DescriptionJsonObj		= new JSONObject();
		DescriptionJsonObj = eMR.MRCommonBean.getTermCodeDescription(con,code_set,p_p_diag_code);
		JSONArray DescriptionJsonArray 		= (JSONArray)DescriptionJsonObj.get("results");
		JSONObject termCodeCountObj = new JSONObject();
		JSONObject multi_desc_ynObj = new JSONObject();
		Integer termCodeCount =0;
		String multi_desc_yn = "N";
		if(DescriptionJsonArray.size() > 0)
		{
		termCodeCountObj	= (JSONObject)DescriptionJsonArray.get(0);
		//multi_desc_ynObj	= (JSONObject)DescriptionJsonArray.get("multi_desc_yn");

		termCodeCount = (Integer)termCodeCountObj.get("termCodeCount");
		multi_desc_yn = checkForNull((String)termCodeCountObj.get("multi_desc_yn"));
		if(isMultiDescAppl.equals("true") && termCodeCount == 1 && multi_desc_yn.equals("Y")) descCount = 1;
		}

		String code_indicator		= "";
		String select_yn		 = "";
		String dagger_independent_yn = "";//Added For SRR-CRF-303.2 added For 1/25/2010.
		String valid_diag	= "Y";//Added For SRR-CRF-303.2 added For 1/25/2010.
		String age_check	= "Y";//Added For SRR-CRF-303.2 added For 1/25/2010.
		boolean proceed		= true;//Added For SRR-CRF-303.2 added For 1/25/2010.
		//String associate_codes  = request.getParameter("associate_codes")==null?"N":request.getParameter("associate_codes");
		
		
		String authorizeButton=request.getParameter("authorizeButton")==null?"N":request.getParameter("authorizeButton");
//		String p_diag_code		=   p_p_diag_code.trim();
		String p_diag_code		=   p_p_diag_code;
		/*Below line added for this CRF GDOH-CRF-0082*/	
		String pmb_code="";
		boolean diagnosisPmb=CommonBean.isSiteSpecific(con, "MR","DIAG_MAPPED_PMB"); 	
		//End GDOH-CRF-0082
		
		if (!(p_diag_code == null || p_diag_code.equals("null")||p_diag_code.length()==0)){
			String p_diag_desc ="";
			String p_cause_indicator ="";
			String p_notifiable_yn ="";
			String p_sensitive_yn ="";
			String p_longdescription="";
			int record_count=0;
			StringBuffer sql = new StringBuffer();
			String high_risk_code="";
			String highRiskDesc="";  // Saantha
/*****************modify this query*******************************/
			//sql.append(" select b.short_desc, b.cause_indicator, b.notifiable_yn, b.sensitive_yn, b.long_desc, b.code_indicator from MR_TERM_CODE a, MR_ICD_CODE b where a.term_code = b.diag_code and b.diag_code = ? and b.diag_code_scheme = ? and (b.code_indicator in ('D','C') OR b.code_indicator IS NULL) ");

//--from  MR_D_"+term_set_id+"_VW
/*****************modify this query*******************************/
			sql.append(" select a.short_desc,a.cause_indicator,a.notifiable_yn, a.sensitive_yn, a.long_desc, a.code_indicator,a.dagger_independent_yn,a.high_risk_code,mr_get_desc.mr_high_risk(a.high_risk_code,'"+locale+"','1') highRiskDesc,a.select_yn from   MR_D_"+code_set+"_lang_VW a where  a.TERM_CODE=upper('"+p_diag_code+"') and a.TERM_SET_ID = '"+code_set+"' and a.eff_status='E' and language_id='"+locale+"' ");

			stmt=con.createStatement();
			rs = stmt.executeQuery(sql.toString());
			String t_cause_indicator = "";
			while( rs.next() ){
				t_cause_indicator	=	checkForNull( rs.getString("cause_indicator") );
				if( (record_count==0) || (cause_indicator.equals(t_cause_indicator)) ){
					p_cause_indicator	=	t_cause_indicator;
					p_diag_desc 		=	checkForNull( rs.getString("short_desc") );
					p_notifiable_yn		=	checkForNull( rs.getString("notifiable_yn") );
					p_sensitive_yn		=	checkForNull( rs.getString("sensitive_yn") );
					p_longdescription	=   checkForNull(rs.getString("long_desc"));
					code_indicator		= checkForNull(rs.getString("code_indicator"));
					dagger_independent_yn		= checkForNull(rs.getString("dagger_independent_yn"),"N");
					select_yn			= checkForNull(rs.getString("select_yn"),"N");
					high_risk_code		= checkForNull(rs.getString("high_risk_code"));
					highRiskDesc		= checkForNull(rs.getString("highRiskDesc"));   //Saantha
				}
				record_count++;
			}
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			
			/*Below line added for this CRF GDOH-CRF-0082*/	
            if(diagnosisPmb){				
				 pmb_code=eMR.MRQueryPMBCode.getPMBCode(con,p_diag_code);
            }			
			//End GDOH-CRF-0082
			
			int view_cnt = 0;
			String view_link = "SELECT Count(*) FROM mr_equivalent_term_code  WHERE term_code = ? and CROSS_REF_TYPE='EQ'";
			pstmt = con.prepareStatement( view_link ) ;
			pstmt.setString( 1, p_diag_code) ;
			rs = pstmt.executeQuery();
			if(rs != null && rs.next())
				view_cnt = rs.getInt(1);
			if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			if(record_count==0){%>
				<script>
					alert(getMessage('INVALID_DIAG_CODE','MR'));
					if(parent.RecDiagnosisAddModify!=null){
						parent.RecDiagnosisAddModify.document.forms[0].Description.value='';
						parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.value='';
						parent.RecDiagnosisAddModify.document.forms[0].diagprob_code.focus();
						parent.RecDiagnosisAddModify.document.forms[0].diagprob_code.value='';//select();
						parent.RecDiagnosisAddModify.document.forms[0].ntf_button.style.visibility='hidden'; 
						parent.RecDiagnosisAddModify.document.forms[0].exclamation.style.visibility='hidden';
						//parent.RecDiagnosisAddModify.document.forms[0].view_link.style.visibility='hidden';
						<!--Below line added for Bru-HIMS-CRF-024.2-->
	   		            if((parent.RecDiagnosisAddModify.document.forms[0].notification_setup&&parent.RecDiagnosisAddModify.document.forms[0].notification_setup.value!='')&&(parent.RecDiagnosisAddModify.document.forms[0].diagprob_code&&parent.RecDiagnosisAddModify.document.forms[0].diagprob_code.value!='')&&(parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc&& parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.value!=''))
		                {     
			                   parent.RecDiagnosisAddModify.document.forms[0].Addnotification.disabled=false;
		                }
						if((parent.RecDiagnosisAddModify.document.forms[0].notification_setup&&parent.RecDiagnosisAddModify.document.forms[0].notification_setup.value!='')&&(parent.RecDiagnosisAddModify.document.forms[0].diagprob_code&&parent.RecDiagnosisAddModify.document.forms[0].diagprob_code.disabled)&&(parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc&& parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.value!=''))
	                    {     
	                     parent.RecDiagnosisAddModify.document.forms[0].Addnotification.disabled=false;
	                    }
						if((parent.RecDiagnosisAddModify.document.forms[0].notification_setup&&parent.RecDiagnosisAddModify.document.forms[0].notification_setup.value!='')&&(parent.RecDiagnosisAddModify.document.forms[0].diagprob_code&&parent.RecDiagnosisAddModify.document.forms[0].diagprob_code.value=='')&&(parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc&& parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.value==''))
		                {     
			                   parent.RecDiagnosisAddModify.document.forms[0].Addnotification.disabled=true;
		                }
						//Below line added for this CRF GDOH-CRF-0082
						if("<%=diagnosisPmb%>"=="true"){
							parent.RecDiagnosisAddModify.document.getElementById('pmb_diagnosis').style.visibility='hidden';						
							parent.RecDiagnosisAddModify.document.getElementById('pmb_diagnosis').innerHTML="";
						}
						//End GDOH-CRF-0082
						
					}else if(parent.addModifyPatProblem!=null){
						parent.addModifyPatProblem.document.forms[0].code.value='';
						parent.addModifyPatProblem.document.forms[0].Description1.value='';
						parent.addModifyPatProblem.document.forms[0].code.focus();
					}
					getCodeSet();setTermCode1();
					parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
				</script>
		<%
			}else if(select_yn.equals("N")){%>
					<script>
						alert(getMessage('CODE_NOT_SELECTABLE','MR'));
						if(parent.RecDiagnosisAddModify!=null){
							parent.RecDiagnosisAddModify.document.forms[0].Description.value='';
							parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.value='';
							parent.RecDiagnosisAddModify.document.forms[0].diagprob_code.focus();
							parent.RecDiagnosisAddModify.document.forms[0].diagprob_code.value='';//select();
							parent.RecDiagnosisAddModify.document.forms[0].ntf_button.style.visibility='hidden'; 
							parent.RecDiagnosisAddModify.document.forms[0].exclamation.style.visibility='hidden';
							//parent.RecDiagnosisAddModify.document.forms[0].view_link.style.visibility='hidden';
						  //Below line added for this CRF GDOH-CRF-0082
						  if("<%=diagnosisPmb%>"=="true"){
							parent.RecDiagnosisAddModify.document.getElementById('pmb_diagnosis').style.visibility='hidden';						
							parent.RecDiagnosisAddModify.document.getElementById('pmb_diagnosis').innerHTML="";
						  }
						 //End GDOH-CRF-0082							
						}else if(parent.addModifyPatProblem!=null){
							parent.addModifyPatProblem.document.forms[0].code.value='';
							parent.addModifyPatProblem.document.forms[0].Description1.value='';
							parent.addModifyPatProblem.document.forms[0].code.focus();
						}
						getCodeSet();setTermCode1();
						parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
					</script>
				<%
			}else{
				int valid_cnt=0;
				int age_cnt=0;
				sql = new StringBuffer();
//				String QUERY_FOR_VALID_CODE ="";
				String QUERY_FOR_PAT_AGE ="";
				//sql.append("select count(*) from mr_icd_code where diag_code=? and diag_code_scheme=?  and ( gender_spec_ind = ? OR gender_spec_ind IS NULL)  and ( nvl(age_spec_ind,'O') NOT IN ('A','P','N') or age_spec_ind IN  ( select case when sysdate-to_date(?,'dd-mm-yyyy') between          NVL(ADULT_MIN_AGE_VALUE,0)*decode(ADULT_MIN_AGE_UNIT,'Y',365,'M',12,'D',30,1) AND NVL(ADULT_MAX_AGE_VALUE,0) *decode(ADULT_MAX_AGE_UNIT,'Y',365,'M',12,'D',30,1) THEN 'A'	WHEN  Sysdate-to_date(?,'dd-mm-yyyy') between NVL(PEAD_MIN_AGE_VALUE,0)*decode(PEAD_MIN_AGE_UNIT,'Y',365,'M',12,'D',30,1) AND NVL(PEAD_MAX_AGE_VALUE,0) *decode(PEAD_MAX_AGE_UNIT,'Y',365,'M',12,'D',30,1) THEN 'P' WHEN Sysdate-to_date(?,'dd-mm-yyyy') between NVL(NB_MIN_AGE_VALUE ,0)*decode(NB_MIN_AGE_UNIT,'Y',365,'M',12,'D',30,1) AND NVL(NB_MAX_AGE_VALUE,0) *decode(NB_MAX_AGE_UNIT,'Y',365,'M',12,'D',30,1) THEN 'N'  END FROM MR_PARAMETER )) AND (code_indicator not in ('A','E') OR code_indicator IS NULL) ");
				//sql.append("select count(*) from MR_D_"+code_set+"_VW where TERM_SET_ID =? AND TERM_CODE=upper(?) and ( gender_spec_ind = ? OR gender_spec_ind IS NULL)  and ( nvl(age_spec_ind,'O') NOT IN ('A','P','N') or age_spec_ind IN  ( select case when sysdate-to_date(?,'dd-mm-yyyy') between          NVL(ADULT_MIN_AGE_VALUE,0)*decode(ADULT_MIN_AGE_UNIT,'Y',365,'M',12,'D',30,1) AND NVL(ADULT_MAX_AGE_VALUE,0) *decode(ADULT_MAX_AGE_UNIT,'Y',365,'M',12,'D',30,1) THEN 'A'	WHEN  Sysdate-to_date(?,'dd-mm-yyyy') between NVL(PEAD_MIN_AGE_VALUE,0)*decode(PEAD_MIN_AGE_UNIT,'Y',365,'M',12,'D',30,1) AND NVL(PEAD_MAX_AGE_VALUE,0) *decode(PEAD_MAX_AGE_UNIT,'Y',365,'M',12,'D',30,1) THEN 'P' WHEN Sysdate-to_date(?,'dd-mm-yyyy') between NVL(NB_MIN_AGE_VALUE ,0)*decode(NB_MIN_AGE_UNIT,'Y',365,'M',12,'D',30,1) AND NVL(NB_MAX_AGE_VALUE,0) *decode(NB_MAX_AGE_UNIT,'Y',365,'M',12,'D',30,1) THEN 'N'  END FROM MR_PARAMETER )) AND (code_indicator not in ('A','E') OR code_indicator IS NULL) ");

				// 
				/* 
					6/5/2009 modified for IN011172
				*/
				/*sql.append("select count(*) from MR_D_"+code_set+"_VW a where TERM_SET_ID =? AND TERM_CODE=upper(?)and (gender_spec_ind = ? OR gender_spec_ind IS NULL) AND (code_indicator not in ('A','E') OR code_indicator IS NULL or dagger_independent_yn='Y')  AND (1 = (SELECT check_age_between (to_date(?,'dd-mm-yyyy'),min_age,age_unit,max_age + 1,age_unit_max) FROM AM_AGE_GROUP WHERE AGE_GROUP_CODE = A.AGE_SPEC_IND) OR a.age_spec_ind IS null) ");*/
//				sql.append("select count(*) from MR_D_"+code_set+"_VW a where TERM_SET_ID =? AND TERM_CODE=upper(?)and (gender_spec_ind = ? OR gender_spec_ind IS NULL) AND (code_indicator not in ('A','E') OR code_indicator IS NULL)  AND (1 = (SELECT check_age_between (to_date(?,'dd-mm-yyyy'),min_age,age_unit,max_age + 1,age_unit_max) FROM AM_AGE_GROUP WHERE AGE_GROUP_CODE = A.AGE_SPEC_IND) OR a.age_spec_ind IS null) ");

				String cd_ind="";
				String dag_ind="";
				QUERY_FOR_PAT_AGE ="SELECT COUNT(*) COUNT,CODE_INDICATOR,DAGGER_INDEPENDENT_YN FROM MR_D_"+code_set+"_VW A WHERE TERM_SET_ID =? AND TERM_CODE=UPPER(?)AND (GENDER_SPEC_IND = ? OR GENDER_SPEC_IND IS NULL) AND (1 = (SELECT CHECK_AGE_BETWEEN (TO_DATE(?,'DD-MM-YYYY'),MIN_AGE,AGE_UNIT,MAX_AGE + 1,AGE_UNIT_MAX) FROM AM_AGE_GROUP WHERE AGE_GROUP_CODE = A.AGE_SPEC_IND) OR A.AGE_SPEC_IND IS NULL)group by CODE_INDICATOR,DAGGER_INDEPENDENT_YN";
					pstmt=con.prepareStatement(QUERY_FOR_PAT_AGE);
					pstmt.setString(1,code_set);
					pstmt.setString(2,p_diag_code);
					pstmt.setString(3,sex);
					pstmt.setString(4,dob);
					rs = pstmt.executeQuery();

					if(rs!=null && rs.next()){
						age_cnt=rs.getInt("COUNT");
						cd_ind=checkForNull(rs.getString("CODE_INDICATOR"));
						dag_ind=checkForNull(rs.getString("DAGGER_INDEPENDENT_YN"));
						if(cd_ind.equals("") || cd_ind.equals("D")||cd_ind.equals("C") || dag_ind.equals("Y") ){
							valid_cnt=1;						
						}
						
					}
					/*Below age_cnt is added by Rameswar on 17-OCT-2016 for IN062122*/
				if(age_cnt==0){
						age_check="N";
						}
				
				/*QUERY_FOR_VALID_CODE ="SELECT COUNT(*) COUNT FROM MR_D_"+code_set+"_VW A WHERE TERM_SET_ID =? AND TERM_CODE = UPPER (?) AND ( CODE_INDICATOR NOT IN ('A', 'E') OR CODE_INDICATOR IS NULL OR DAGGER_INDEPENDENT_YN = 'Y') ";
				pstmt=con.prepareStatement(QUERY_FOR_VALID_CODE);
				pstmt.setString(1,code_set);
				pstmt.setString(2,p_diag_code);
				rs = pstmt.executeQuery();
				if(rs!=null&&rs.next()){
					valid_cnt=rs.getInt("COUNT");
				}
				*/
				if(pstmt!=null)pstmt.close();
				if(rs!=null)rs.close();

				if(valid_cnt>0){
					/*QUERY_FOR_PAT_AGE ="SELECT COUNT(*) COUNT FROM MR_D_"+code_set+"_VW A WHERE TERM_SET_ID =? AND TERM_CODE=UPPER(?)AND (GENDER_SPEC_IND = ? OR GENDER_SPEC_IND IS NULL) AND (1 = (SELECT CHECK_AGE_BETWEEN (TO_DATE(?,'DD-MM-YYYY'),MIN_AGE,AGE_UNIT,MAX_AGE + 1,AGE_UNIT_MAX) FROM AM_AGE_GROUP WHERE AGE_GROUP_CODE = A.AGE_SPEC_IND) OR A.AGE_SPEC_IND IS NULL)";
					pstmt=con.prepareStatement(QUERY_FOR_PAT_AGE);
					pstmt.setString(1,code_set);
					pstmt.setString(2,p_diag_code);
					pstmt.setString(3,sex);
					pstmt.setString(4,dob);
					rs = pstmt.executeQuery();
					if(rs!=null&&rs.next()){
						age_cnt=rs.getInt("COUNT");
					}
					*/
					/*if(age_cnt==0){
						age_check="N";
					}*/// age_cnt is Commented by Rameswar on 17-OCT-2016 for IN062122
				}else{
					valid_diag="N";
				}
				if(valid_diag.equals("N")||age_check.equals("N")){
					proceed=false;
				}

				/*pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1,code_set);
				pstmt.setString(2,p_diag_code);
				pstmt.setString(3,sex);
				pstmt.setString(4,dob);
				rs = pstmt.executeQuery();
				rs.next();*/
				if(proceed){
				%>
				<script>
				
				if(parent.RecDiagnosisAddModify!=null)
					{
						parent.RecDiagnosisAddModify.document.forms[0].Description.value="<%=p_diag_desc%>";
						parent.RecDiagnosisAddModify.document.forms[0].cause_indicator.value="<%=p_cause_indicator%>";
						parent.RecDiagnosisAddModify.document.forms[0].notifiable_yn.value="<%=p_notifiable_yn%>";
						parent.RecDiagnosisAddModify.document.forms[0].sensitive_yn.value="<%=p_sensitive_yn%>";
						parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.value="<%=p_diag_desc%>";
						
						<%if(descCount>0){%>
						if(parent.RecDiagnosisAddModify.document.getElementById('other_disp1')) // Added by mujafar for ML-MMOH-CRF-1281 US3
						{
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
							element.text = "<%=descriptions%>";//  description<%=i%>
							element.value= "<%=descriptions%>";
							if(element.value!='')
							parent.RecDiagnosisAddModify.document.forms[0].term_oth_desc.add(element);
							<%
							}	
							%>
				   
					
					     }	

	



						}
					<%}
					else{
					%>
						
						if(parent.RecDiagnosisAddModify.document.getElementById('other_disp1'))
						{
						parent.RecDiagnosisAddModify.document.getElementById('other_disp1').style.visibility='hidden'; 
						parent.RecDiagnosisAddModify.document.getElementById('other_disp2').style.visibility='hidden';
						
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
								System.out.println("descriptions else:"+descriptions);
							%>	
							var element =parent.RecDiagnosisAddModify.document.createElement('OPTION');
							element.text = "<%=descriptions%>";
							element.value= "<%=descriptions%>";
							if(element.value!='')
							parent.RecDiagnosisAddModify.document.forms[0].term_oth_desc.add(element);
							<%
							}	
							%>
				   
					
					     }	

	



						}

						
						
						<%
						}	
						%>

						/*Below line added for this CRF GDOH-CRF-0082*/
						if("<%=diagnosisPmb%>"=="true"){
							if('<%=pmb_code%>'!=""){ 	
								var pmb=getLabel("eMR.ThisisPMB.label","MR");						
								parent.RecDiagnosisAddModify.document.getElementById('pmb_diagnosis').style.visibility='visible';		
								parent.RecDiagnosisAddModify.document.getElementById('pmb_diagnosis').innerHTML=pmb;							
							}else{ 	
								var notpmb=getLabel("eMR.ThisisnotPMB.label","MR");						
								parent.RecDiagnosisAddModify.document.getElementById('pmb_diagnosis').style.visibility='visible';						
								parent.RecDiagnosisAddModify.document.getElementById('pmb_diagnosis').innerHTML=notpmb;						 
							}
						}
                        //End this CRF GDOH-CRF-0082 						

						parent.RecDiagnosisAddModify.document.forms[0].LongDescription.value="<%=p_longdescription%>"; 

						parent.RecDiagnosisAddModify.document.forms[0].exclamation.style.visibility='visible';	
						parent.RecDiagnosisAddModify.document.forms[0].ComplaintSrch.disabled=false;
						parent.RecDiagnosisAddModify.document.forms[0].dagger_independent_yn.value="<%=dagger_independent_yn%>";//Added for SRR-CRF-303.2 1/27/2010
						parent.RecDiagnosisAddModify.restirctPrimaryDiag(parent.RecDiagnosisAddModify.document.forms[0].diag_classfication)
						//parent.RecDiagnosisAddModify.document.forms[0].view_link.value='viewLink';	
						<%if(view_cnt>0){%>
						parent.RecDiagnosisAddModify.document.getElementById("view_link").style.visibility='visible';	
						/*parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";*/
						<%}/*else{*/%>
						//parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
						<%--}--%>
					}
					else if(parent.addModifyPatProblem!=null)
					{
						parent.addModifyPatProblem.document.forms[0].Description.value="<%=p_diag_desc%>";
						parent.addModifyPatProblem.document.forms[0].cause_indicator.value="<%=p_cause_indicator%>";
						parent.addModifyPatProblem.document.forms[0].notifiable_yn.value="<%=p_notifiable_yn%>";
						parent.addModifyPatProblem.document.forms[0].sensitive_yn.value="<%=p_sensitive_yn%>";
						parent.addModifyPatProblem.document.forms[0].LongDescription.value="<%=p_longdescription%>"; 
						parent.addModifyPatProblem.document.forms[0].exclamation.style.visibility='visible';
						parent.addModifyPatProblem.document.forms[0].Description1.value="<%=p_diag_desc%>";
					
					}
					</script>
				<%
				if(high_risk_code!=""){%>
					<script> 
						parent.RecDiagnosisAddModify.document.forms[0].high_risk.style.visibility='visible';
						parent.RecDiagnosisAddModify.document.forms[0].high_risk_code.value='<%=high_risk_code%>';
						if(parent.RecDiagnosisAddModify.document.forms[0].high_risk.style.visibility=='visible'){							
							parent.RecDiagnosisAddModify.document.getElementById("high_risk").title = '<%=highRiskDesc%>' ;   
						}
					</script>
				<%}else{
						%>
					<script>
						parent.RecDiagnosisAddModify.document.forms[0].high_risk.style.visibility='hidden'; 
					</script>
					<%
					}
				
					if(p_notifiable_yn.equals("Y") )
					{	%>
					<script>
						if(parent.RecDiagnosisAddModify!=null){ //alert('279');
							parent.RecDiagnosisAddModify.document.forms[0].ntf_button.style.visibility='visible';	
							<!--Below line added for Bru-HIMS-CRF-024.2-->
	   		                 if((parent.RecDiagnosisAddModify.document.forms[0].notification_setup!=null&&parent.RecDiagnosisAddModify.document.forms[0].notification_setup.value!='')&&(parent.RecDiagnosisAddModify.document.forms[0].diagprob_code!=null&&parent.RecDiagnosisAddModify.document.forms[0].diagprob_code.value!='')&&(parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc!=null&& parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.value!=''))
		                     {
			                   parent.RecDiagnosisAddModify.document.forms[0].Addnotification.disabled=false;
		                     }
							 if((parent.RecDiagnosisAddModify.document.forms[0].notification_setup&&parent.RecDiagnosisAddModify.document.forms[0].notification_setup.value!='')&&(parent.RecDiagnosisAddModify.document.forms[0].diagprob_code&&parent.RecDiagnosisAddModify.document.forms[0].diagprob_code.disabled)&&(parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc&& parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.value!=''))
	                         {     
	                            parent.RecDiagnosisAddModify.document.forms[0].Addnotification.disabled=false;
	                        }
		             	}else if(parent.addModifyPatProblem!=null){
							parent.addModifyPatProblem.document.forms[0].ntf_button.style.visibility='visible';
							}
					</script>
				<%
					}
					else
					{	%>
					<script>
						if(parent.RecDiagnosisAddModify!=null){
							parent.RecDiagnosisAddModify.document.forms[0].ntf_button.style.visibility='hidden';
							<!--Below line added for Bru-HIMS-CRF-024.2--> 
							//alert('298');
	   		                 if((parent.RecDiagnosisAddModify.document.forms[0].notification_setup!=null&&parent.RecDiagnosisAddModify.document.forms[0].notification_setup.value!='')&&(parent.RecDiagnosisAddModify.document.forms[0].diagprob_code!=null&&parent.RecDiagnosisAddModify.document.forms[0].diagprob_code.value!='')&&(parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc!=null&& parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.value!=''))
		                     {
			                   parent.RecDiagnosisAddModify.document.forms[0].Addnotification.disabled=false;
		                     }
							 if((parent.RecDiagnosisAddModify.document.forms[0].notification_setup&&parent.RecDiagnosisAddModify.document.forms[0].notification_setup.value!='')&&(parent.RecDiagnosisAddModify.document.forms[0].diagprob_code&&parent.RecDiagnosisAddModify.document.forms[0].diagprob_code.disabled)&&(parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc&& parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.value!=''))
	                        {     
	                           parent.RecDiagnosisAddModify.document.forms[0].Addnotification.disabled=false;
	                        }
						}else if(parent.addModifyPatProblem!=null){
							parent.addModifyPatProblem.document.forms[0].ntf_button.style.visibility='hidden';
						}	
					</script>
								<%	}

					/*
					if(p_longdescription!=null )
					{
						a1.append("parent.RecDiagnosisAddModify.document.forms[0].exclamation.style.visibility='visible';");
					}
					else
					{
						a1.append("parent.RecDiagnosisAddModify.document.forms[0].exclamation.style.visibility='hidden';");
					}
					*/
					if(p_cause_indicator!=null)
					{
						if(p_cause_indicator.equals("E") && p_scheme.equals("2"))
						out.println("<script>parent.RecDiagnosisAddModify.document.forms[0].cause_ind.options[1].selected=true;</script>");	
					}else
					{
						if(p_scheme.equals("2"))
							out.println("<script>parent.RecDiagnosisAddModify.document.forms[0].cause_ind.options[0].selected=true;</script>");
					}
					if(record_count==1)
					{
						if(p_scheme.equals("2"))
						{
							if(p_cause_indicator.equals("E"))
							out.println("<script>parent.RecDiagnosisAddModify.document.forms[0].cause_ind.selectedIndex=1;</script>");
							else
							out.println("<script>parent.RecDiagnosisAddModify.document.forms[0].cause_ind.selectedIndex=0;</script>");
							out.println("<script>parent.RecDiagnosisAddModify.document.forms[0].cause_ind.disabled=true;</script>");
						}
					}
					if(record_count>1)
						out.println("<script>parent.RecDiagnosisAddModify.document.forms[0].cause_ind.disabled=false;</script>");
					
					
					if(!sensitive_yn.equals("Y"))
					{
						if(p_sensitive_yn.equals("Y"))
						{

							if (authorizeButton.equals("N"))
							{ 
								
								out.println("<script>alert(getMessage('DIAG_AUTH_REQD','CA'));</script>");
								out.println("<script>parent.RecDiagnosisAddModify.document.forms[0].Description.value='';</script>");
								out.println("<script>parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.value='';</script>");
								%>
								<script>	
								if(parent.RecDiagnosisAddModify.document.forms[0].isMultiDescAppl.value=="true" && parent.RecDiagnosisAddModify.document.getElementById('other_disp1'))
									{ // Added by mujafar for ML-MMOH-CRF-1281 US3
									parent.RecDiagnosisAddModify.document.getElementById('other_disp1').style.visibility = "hidden";
									parent.RecDiagnosisAddModify.document.getElementById('other_disp2').style.visibility = "hidden";
									}
								
								</script>
								<%
							}

							if (authorizeButton.equals("N"))
							{
								out.println("<script>parent.RecDiagnosisAddModify.document.forms[0].diagprob_code.focus();</script>");
								out.println("<script>parent.RecDiagnosisAddModify.document.forms[0].diagprob_code.value='';/*select();*/</script>");
							}

							
							if (authorizeButton.equals("Y"))
							{
								//out.println("<script>parent.RecDiagnosisAddModify.chkAuthorize(parent.PatProblemQueryTools.document.forms[0].authorize,'"+code_indicator+"');</script>");
								//out.println("<script>parent.RecDiagnosisAddModify.chkAuthorize('Authorize Mode','"+code_indicator+"');</script>");	
							
								out.println("<script>								if(parent.RecDiagnosisAddModify!=null)parent.RecDiagnosisAddModify.chkAuthorize(parent.RecDiagnosisOpernToolbar.document.forms[0].mode,'"+code_indicator+"'); else if(parent.addModifyPatProblem!=null)parent.addModifyPatProblem.chkAuthorize(parent.PatProblemQueryTools.document.forms[0].mode,'"+code_indicator+"');</script>");	
									
							}
					
						}
					}
									
					
					%>
					
					<script>
						if(parent.RecDiagnosisAddModify!=null)
							parent.RecDiagnosisAddModify.document.forms[0].code_indicator.value="<%=code_indicator%>";
						else if(parent.addModifyPatProblem!=null)
							parent.addModifyPatProblem.document.forms[0].code_indicator.value="<%=code_indicator%>";
				
					</script>

				<script>
					if("<%=code_indicator%>" == 'D' || "<%=code_indicator%>" == 'C')
					{
						if(parent.RecDiagnosisAddModify!=null)
							parent.RecDiagnosisAddModify.document.forms[0].AddAssociateCodes.disabled=false;
						else if(parent.addModifyPatProblem!=null)
							parent.addModifyPatProblem.document.forms[0].AddAssociateCodes.disabled=false;
		
					}
					else
					{     
						if(parent.RecDiagnosisAddModify!=null)
						{
							parent.RecDiagnosisAddModify.document.forms[0].AddAssociateCodes.disabled=true;
							parent.RecDiagnosisAddModify.document.forms[0].associate_codes.value = '';
						}
						else if(parent.addModifyPatProblem!=null)
						{
							parent.addModifyPatProblem.document.forms[0].AddAssociateCodes.disabled=true;
							parent.addModifyPatProblem.document.forms[0].associate_codes.value = '';
						}

					}
					parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
				</script>
<%
				}else{%>
					<script>
						if("<%=valid_diag%>"=="N" && "<%=age_check%>"=="Y"){ /*age_checked added by Rameswar on 17-OCT-2016 for IN062122*/
						
							alert(getMessage('RECORDING_SUPPRT_DIAG_NOT_ALLOWED','MR'));
						}else if("<%=age_check%>"=="N"){
										
							alert(getMessage('MR_INVALID_DIAG_CODE_FOR_PATIENT','MR'));
						}
						if(parent.RecDiagnosisAddModify!=null){
							parent.RecDiagnosisAddModify.document.forms[0].Description.value='';
							parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.value='';
							parent.RecDiagnosisAddModify.document.forms[0].diagprob_code.focus();
							parent.RecDiagnosisAddModify.document.forms[0].diagprob_code.value='';
							parent.RecDiagnosisAddModify.document.forms[0].ntf_button.style.visibility='hidden';
							parent.RecDiagnosisAddModify.document.forms[0].AddAssociateCodes.disabled=true;
						}else if(parent.addModifyPatProblem!=null){
							parent.addModifyPatProblem.document.forms[0].Description.value='';
							parent.addModifyPatProblem.document.forms[0].Description1.value='';
							parent.addModifyPatProblem.document.forms[0].code.focus();
							parent.addModifyPatProblem.document.forms[0].code.value='';
							parent.addModifyPatProblem.document.forms[0].ntf_button.style.visibility='hidden';
							parent.addModifyPatProblem.document.forms[0].AddAssociateCodes.disabled=true;
						}
						getCodeSet();setTermCode1();
						parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
					</script>
				<%
				}
			}
		}else{
			out.println("<script>parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.value='';</script>");
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	}
	catch(Exception e)
	{	
		//out.println(e.toString()); 
		e.printStackTrace();
	}
	finally 
	{
		if(con!=null)ConnectionManager.returnConnection(con, request);
	}
%>
<%!
public static String checkForNull(String inputString){
return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}
public static String checkForNull(String inputString, String defaultValue){
return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
%>

