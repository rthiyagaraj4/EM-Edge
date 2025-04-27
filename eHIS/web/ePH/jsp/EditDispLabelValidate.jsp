 <%@page  import=" java.util.*, java.io.*, ePH.Common.*, ePH.*, java.text.*" contentType="text/html;charset=UTF-8" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	try{ 
		request.setCharacterEncoding("UTF-8");	
		String locale			= (String)session.getAttribute("LOCALE");
		String bean_id			= request.getParameter( "bean_id" ) ;
		String bean_name		= request.getParameter( "bean_name" ) ;
		String func_mode		= request.getParameter( "func_mode" );

		Hashtable hash			= (Hashtable)XMLobj.parseXMLString( request ) ;
		hash					= (Hashtable)hash.get( "SEARCH" ) ;
		EditDispLabelBean bean	= (EditDispLabelBean)getBeanObject(bean_id,bean_name ,request) ;
		bean.setLanguageId(locale);

		if(func_mode != null && func_mode.equals("validatePassword" ) ){
			String homepage =  hash.get("homepage")==null?"":(String) hash.get("homepage"); //added for Bru-HIMS-CRF-073.1 [IN:047222]
			if(!homepage.equals("Y")){ // if condition and else block added for Bru-HIMS-CRF-073.1 [IN:047222]
				bean.setPassword((String) hash.get("password"));
				if(!bean.validateThePassword()){
					out.println("alert(getMessage('PH_INVALID_PASSWORD','PH'))");
					out.println("focusOnPasswordField('Y')");			
				}
				else{
					bean.setDispLocnCode((String) hash.get("disp_locn_code"));
					out.println("focusOnPasswordField('N')");	
				}
			} //added for Bru-HIMS-CRF-073.1 [IN:047222] -start
			else{
				String disp_locn_code =  hash.get("disp_locn_code")==null?"":(String) hash.get("disp_locn_code");
				String facility_id		= (String) session.getValue( "facility_id" );
				String disp_locn_desc="";
				boolean dispLocnFound = false;
				ArrayList dispLocn = bean.getDispLocs(facility_id.trim());
				bean.setDispLocnCode((String) hash.get("disp_locn_code"));
				for (int i=0; i<dispLocn.size(); i+=2) {
					if(disp_locn_code.equals((String) dispLocn.get(i))){
						disp_locn_desc =(String) dispLocn.get(i+1) ;
						dispLocnFound = true;
						break;
					}
				}
				if(dispLocnFound){
					bean.setDispLocnCode(disp_locn_code);
					out.println("retVal ='GOQUERYCRITERIA'");	
				}
				else
					out.println("retVal ='ACCESS_DENIED'");			
			} //added for Bru-HIMS-CRF-073.1 [IN:047222] -end
		}
		else if(func_mode!= null && func_mode.equals("changeLocalInstr")){ //This condtion is add for SRR20056-SCF-6260[Incident No.25586]

			String iLabelPairs			= (String) hash.get("iLabelPairs");
			String lang_id				= (String) hash.get("locale");
			//String formObj				= (String) hash.get("formObj");
			String instr				= (String) hash.get("instr");
			String instr_type			= (String) hash.get("instr_type");	

			//Add following lines  for Incident No.28951
			String loc_instr_txt		= bean.getLocalInstr(instr,lang_id);
			loc_instr_txt				= loc_instr_txt.replaceAll(" ","%20");
			loc_instr_txt				= java.net.URLEncoder.encode(loc_instr_txt,"UTF-8");
			loc_instr_txt				= loc_instr_txt.replaceAll("%2520","%20");
			out.println("assignLocaltxt('"+instr_type+"','"+iLabelPairs+"','"+loc_instr_txt+"');"); 
			putObjectInBean(bean_id,bean,request);

			/*if(instr_type.equals("C")){
			out.println("eval(document."+formObj+".loc_caution_1_"+iLabelPairs+").value=\""+bean.getLocalInstr(instr,lang_id)+"\""); 
			}else{
			out.println("eval(document."+formObj+".loc_special_1_"+iLabelPairs+").value=\""+bean.getLocalInstr(instr,lang_id)+"\"");
			} */
		}
		else if(func_mode != null && func_mode.equals("editLabels" ) ){
			ArrayList edit_details = new ArrayList();
			String dispense_no = (String) hash.get("dispense_no"); 
			String record_count =  (String) hash.get("no_of_records");
			edit_details.add(dispense_no);//0
			edit_details.add(record_count);//1
			String allow_edit_disp_label =  hash.get("allow_edit_disp_label")==null?"":(String) hash.get("allow_edit_disp_label");
			int no_of_records = Integer.parseInt(record_count) ;
			if(allow_edit_disp_label.equals("Y")){
				edit_details.add(bean.checkForNull((String)hash.get("facility_id")));//2
				edit_details.add(bean.checkForNull((String)hash.get("labelLangId")));//3
			}
			String caution          ="";
			String special          ="";
			String patient_int      ="";
			String loc_caution      =""; 
			String loc_special      ="";
			String loc_patient_int  ="";
			String drug_indication	= "";//Added for ML-BRU-CRF-072[Inc:29938]
			String line_bms_remarks_code="";//added for jd-crf-0221
			String i = "";
			for(int j =1; j <= no_of_records; j++){
				i = hash.get("dispSrlNo"+j)==null?j+"":(String)hash.get("dispSrlNo"+j)  ;  
				if(!allow_edit_disp_label.equals("Y")){
					caution			= hash.get("caution_"+i)==null?"":(String)hash.get("caution_"+i)  ;  
					caution  = java.net.URLDecoder.decode(caution,"UTF-8");
					special			= hash.get("special_"+i)==null?"":(String)hash.get("special_"+i)  ; 
					special  = java.net.URLDecoder.decode(special,"UTF-8");
					patient_int		= hash.get("patient_int_"+i)==null?"":(String)hash.get("patient_int_"+i)  ;
					patient_int  = java.net.URLDecoder.decode(patient_int,"UTF-8");
					loc_caution		= hash.get("loc_caution_"+i)==null?"":(String)hash.get("loc_caution_"+i);   
					loc_caution  = java.net.URLDecoder.decode(loc_caution,"UTF-8");
					loc_special		= hash.get("loc_special_"+i)==null?"":(String)hash.get("loc_special_"+i); 
					loc_special  = java.net.URLDecoder.decode(loc_special,"UTF-8");
					loc_patient_int	= hash.get("line_bms_remarks_code_"+i)==null?"":(String)hash.get("loc_patient_int_"+i);
					loc_patient_int  = java.net.URLDecoder.decode(loc_patient_int,"UTF-8");
					line_bms_remarks_code=hash.get("line_bms_remarks_code_"+i)==null?"":(String)hash.get("line_bms_remarks_code_"+i);//added for jd-crf-0221
					line_bms_remarks_code=java.net.URLDecoder.decode(line_bms_remarks_code,"UTF-8");//added for jd-crf-0221
					edit_details.add(caution);
					edit_details.add(special);
					edit_details.add(patient_int);
					edit_details.add(loc_caution);
					edit_details.add(loc_special);
					edit_details.add(loc_patient_int);
					edit_details.add((String) hash.get("pres_remarks_"+i)==null?"":hash.get("pres_remarks_"+i));
					drug_indication = (String) hash.get("drug_ind_"+i)==null?"":(String)hash.get("drug_ind_"+i);
					drug_indication  = java.net.URLDecoder.decode(drug_indication,"UTF-8");
					edit_details.add(drug_indication);//Added for ML-BRU-CRF-072[Inc:29938] End
					edit_details.add(i); //dispSrlNo
					edit_details.add(line_bms_remarks_code);//added for jd-crf-0221
				}
				else{
					edit_details.add(i); //dispSrlNo //4
					edit_details.add(bean.checkForNull((String)hash.get("dispQty"+i)));
					edit_details.add(bean.checkForNull((String)hash.get("disp_uom_code"+i)));
					edit_details.add(java.net.URLDecoder.decode(bean.checkForNull((String)hash.get("dosageDtl_"+i)),"UTF-8"));
					edit_details.add(bean.checkForNull((String)hash.get("pres_drug_code"+i)));
					edit_details.add(bean.checkForNull((String)hash.get("drug_code_"+i)));
					edit_details.add(bean.checkForNull((String)hash.get("noOfPrints"+i)));
					edit_details.add(java.net.URLDecoder.decode(bean.checkForNull((String)hash.get("instruction_"+i)),"UTF-8")); //11
				}
			}
			boolean result_flag = bean.modify(edit_details);
			if(result_flag){
				out.println("showalert();");
			}
		}
		else if(func_mode != null && func_mode.equals("printLabel" ) ){
			String ReportOutput		=	"";
			ecis.utils.OnlineReports onlineReports		=	null;
			ecis.utils.OnlineReport report1				=	null;
			String report_id = "";
			String language_id = (String) bean.getLanguageId();
			String no_of_records =  (String) hash.get("no_of_records");
			String dispense_no = (String) hash.get("dispense_no"); 
			String patient_id = (String) hash.get("patient_id"); 

			DateFormat df                      = new SimpleDateFormat("dd/MM/yyyy");   
			java.util.Date disp_date           = df.parse((String) hash.get("dispense_date_time"));
			String dispense_date_time          = df.format(disp_date);
			dispense_date_time                 =  com.ehis.util.DateUtils.convertDate(dispense_date_time,"DMY","en","en");

			String order_id                     = (String) hash.get("order_id");
			String iv_prep_yn                   =  (String) hash.get("iv_prep_yn");
			//String login_user                   = (String) bean.getUserName();
			String login_user                   = (String)session.getValue("login_user");
			String facility_id                  = (String) bean.getLoginFacilityId();
			String patient_class                = (String) bean.getPatientClass(dispense_no);
			ArrayList order_line_field_values	=	new ArrayList();
			int	 olfvSize;	

			if(iv_prep_yn == null || iv_prep_yn.equals("") ){
				if(patient_class.equals("IP"))
					report_id = "PHPRDISLB_AL_IP";
				else if(patient_class.equals("OP"))
					report_id = "PHPRDISLB_AL_OP";
			}
			if(iv_prep_yn.equals("1"))
				report_id = "PHRIVCONT";
			if(iv_prep_yn.equals("5"))
				report_id = "PHRIVCONTWOADD";
			if(iv_prep_yn.equals("3"))
				report_id = "PHRIVINTT";
			if(iv_prep_yn.equals("9"))
				report_id = "PHRCYTOLBDEL";

			for(int n=1;n<=Integer.parseInt(no_of_records);n++){
				onlineReports 		= new ecis.utils.OnlineReports() ;
				report1			= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
				if(report_id.equals("PHPRDISLB_AL_IP")	 || report_id.equals("PHPRDISLB_AL_OP")){
					report1.addParameter("p_report_id",report_id) ;
					report1.addParameter("p_user_name",login_user) ;
					report1.addParameter("p_module_id", "PH") ;
					report1.addParameter("p_patient_id",patient_id) ;
					report1.addParameter("p_disp_no",dispense_no);
					report1.addParameter("p_facility_id",facility_id) ;
					report1.addParameter("p_disp_date",dispense_date_time); // or system date
					report1.addParameter("p_patient_class",patient_class);
					report1.addParameter("p_srl_no",n+"");
					report1.addParameter("p_language_id",language_id) ;
					onlineReports.add( report1) ;
				}
				else if(report_id.equals("PHRIVCONT")){
					report1.addParameter("p_report_id",report_id) ;
					report1.addParameter("p_user_name",login_user) ;
					report1.addParameter("p_module_id", "PH") ;
					report1.addParameter("p_patient_id",patient_id) ;
					report1.addParameter("p_disp_no",dispense_no);
					report1.addParameter("p_facility_id",facility_id) ;
					report1.addParameter("p_disp_date",dispense_date_time); // or system date
					report1.addParameter("p_patient_class",patient_class);
					report1.addParameter("p_srl_no",n+"");				
					report1.addParameter("p_seq_no",n+"");	
					report1.addParameter("p_language_id",language_id) ;
					onlineReports.add( report1) ;
				}
				else if(report_id.equals("PHRIVCONTWOADD")){
					report1.addParameter("p_disp_date",dispense_date_time); //dispense_date_time
					report1.addParameter("p_pat_class",patient_class);
					onlineReports.add( report1) ;
				}
				if(report_id.equals("PHRIVINTT")	 || report_id.equals("PHRCYTOLBDEL")){
					order_line_field_values	=	(ArrayList)bean.getOrderLineFieldValues(order_id);
					olfvSize					=	order_line_field_values.size();
					for(int m=0;m<olfvSize;m++){
						report1.addParameter("p_report_id",report_id) ;
						report1.addParameter("p_user_name",login_user) ;
						report1.addParameter("p_module_id", "PH") ;
						report1.addParameter("p_patient_id",patient_id) ;
						report1.addParameter("p_disp_no",dispense_no);
						report1.addParameter("p_facility_id",facility_id) ;
						report1.addParameter("p_disp_date",dispense_date_time);
						report1.addParameter("p_patient_class",patient_class);
						report1.addParameter("p_srl_no",n+"");
						report1.addParameter("p_language_id",language_id) ;
						if(order_line_field_values.size() != 0){
							report1.addParameter("p_order_line_field_value",(String)order_line_field_values.get(m));
						}
						onlineReports.add( report1) ;
					}
				}
				report1 = null;
				ReportOutput = onlineReports.execute( request, response );
			}
		}
		else if(func_mode != null && func_mode.equals("patientsearch" ) ){
			String patient_id					= (String) hash.get("patient_id");
			ArrayList patientdetails	= bean.getPatientDetails1(patient_id);
			if(patientdetails.size()==0){
				out.println("chkpatID('N');") ;
			}
			else{
				out.println("chkpatID('Y');") ;
			}
		}
		else if(func_mode != null && func_mode.equals("setlabelLangId" ) ){
			String labelLangId	= (String) hash.get("labelLangId");
			bean.SetEditableLabelLangId(labelLangId);
		}
		putObjectInBean(bean_id,bean,request);
	}
	catch (Exception e) {
		e.printStackTrace();
		out.println("alert('"+e.toString()+"');");
	}
%>
