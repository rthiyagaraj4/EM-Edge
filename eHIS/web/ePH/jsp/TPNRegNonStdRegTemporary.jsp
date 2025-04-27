<!DOCTYPE html>
<%-- saved 0n 24/10/2005 --%>
<%@page import="java.util.*, ePH.Common.*, ePH.* ,eOR.*" contentType="text/html;charset=UTF-8 "%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<% 
	String bean_id				= request.getParameter( "bean_id" ) ;
	String bean_name			= request.getParameter( "bean_name" ) ;
	String patient_id			= request.getParameter( "patient_id" ) ;
	String encounter_id		    = request.getParameter( "encounter_id" ) ;
	String locale			= (String)session.getAttribute("LOCALE"); //added for [IN:031523]

	if(request.getParameter("Mode")!=null && request.getParameter("Mode").equals("ClearBean")){
		TPNNonStandardRegimenBean bean	= (TPNNonStandardRegimenBean)getBeanObject(bean_id,bean_name,request) ;
		TPNRegimenBean oRegimenBean	= (TPNRegimenBean)getBeanObject( "@TPNRegimenBean"+patient_id+encounter_id, "ePH.TPNRegimenBean", request);
		TPNStandardRegimenBean oStandardRegimenBean = (TPNStandardRegimenBean)getBeanObject("@TPNStandardRegimenBean"+patient_id+encounter_id,"ePH.TPNStandardRegimenBean", request);
		bean.clear();
		oRegimenBean.clear();
		oStandardRegimenBean.clear();
	}
	else{
		String facility_id          = (String)session.getValue("facility_id");
		String login_user	        = (String)session.getValue("login_user");
		if ( bean_id == null || bean_id.equals( "" ) )
			return ;

		String gencode			               =request.getParameter("genarray");
		String genname			               =request.getParameter("descarray");
		String qty				               =request.getParameter("qtyarray");
		String unit				               =request.getParameter("unitarray");
		String calc				               =request.getParameter("calcarray");
		String ovrridereason			       =request.getParameter("ovrridereasonarray");
		String prefdrug				           =request.getParameter("prefdrugarray");
		String groupcode		               =request.getParameter("groupcodearray");
		String action			               =request.getParameter("action");
		String ncp_n_val                       =request.getParameter("ncp_n_val");
		StringTokenizer st;
		TPNNonStandardRegimenBean bean= (TPNNonStandardRegimenBean)getBeanObject(bean_id,bean_name,request);
		ArrayList arrgencode						=new ArrayList();
		ArrayList arrgenname						=new ArrayList();
		ArrayList arrqty								=new ArrayList();
		ArrayList arrunit								=new ArrayList();
		ArrayList arrcalc								=new ArrayList();

		ArrayList arroverridereason					=new ArrayList();
		ArrayList arrprefdrug					    =new ArrayList();

		ArrayList arrgroupcode					=new ArrayList();
		ArrayList storedgroups					=new ArrayList();
		
		if(action.equals("NONACCESSIONNUMBER")){
		
			HashMap record2=new HashMap(); 
			String tpn_screening_type="";
			String note_type="";
			String accession_num="";

			record2=bean.ChkAdMixture();
			tpn_screening_type=CommonBean.checkForNull((String)record2.get("TPN_SCREENING_TYPE"));
			note_type=CommonBean.checkForNull((String)record2.get("TPN_SCREENING_FORM_ID"));

			if(!tpn_screening_type.equals("")){
				HashMap record3=new HashMap();
				record3=bean.ChkScreeningDetails(facility_id,encounter_id,note_type);
				accession_num=CommonBean.checkForNull((String)record3.get("ACCESSION_NUM"));
			}
			out.println("CheckAccessionNumber(\""+ accession_num + "\",\""+ tpn_screening_type + "\");");
		}

		if (action.equals("NONDISCRETE")) {

			HashMap record2=new HashMap(); 
			String tpn_screening_type="";
			String note_type="";
			String test_observ_dt_tm="";

			record2=bean.ChkAdMixture();
			tpn_screening_type=CommonBean.checkForNull((String)record2.get("TPN_SCREENING_TYPE"));
			note_type=CommonBean.checkForNull((String)record2.get("TPN_SCREENING_FORM_ID"));
			   
			if(tpn_screening_type.equals("D")){
				HashMap record3=new HashMap();
				record3=bean.ChkDiscrete(facility_id,encounter_id,note_type);
				test_observ_dt_tm=CommonBean.checkForNull((String)record3.get("TEST_OBSERV_DT_TM"));
			}
			out.println("beforNonDiscrete(\""+ test_observ_dt_tm + "\",\""+ tpn_screening_type + "\");");
		}

		if (action.equals("STOREVALUES")){
			storedgroups									=bean.getStoredGroups();
			//Use String tokenizer to parse the string for ,s and put it into an arraylist
			st	 = new StringTokenizer(gencode, ",");
			while (st.hasMoreTokens()){
				arrgencode.add(st.nextToken());
			}
			st	 = new StringTokenizer(genname, ",");
			while (st.hasMoreTokens()){
				arrgenname.add(st.nextToken());
			}
			st = new StringTokenizer(qty, ",");
			while (st.hasMoreTokens()){
				arrqty.add(st.nextToken());
			}
			st = new StringTokenizer(unit, ",");
			while (st.hasMoreTokens()){
				arrunit.add(st.nextToken());
			}
			st = new StringTokenizer(calc, ",");
			while (st.hasMoreTokens()){
				arrcalc.add(st.nextToken());
			}	
			st	= new StringTokenizer(groupcode, ",");
			while (st.hasMoreTokens()){
				arrgroupcode.add(st.nextToken());
			}
			st = new StringTokenizer(ovrridereason, ",");
			while (st.hasMoreTokens()){
				
				arroverridereason.add(st.nextToken());
			}
			st	= new StringTokenizer(prefdrug, ",");
			while (st.hasMoreTokens()){
				
				arrprefdrug.add(st.nextToken());
			}
		}
		if (action.equals("storeovrridereason")){
		   String group=request.getParameter("group");
		   String row_no=request.getParameter("row_no");
		   String remarks=request.getParameter("remarks");
		   bean.setOverriddenRemarks(group,row_no,remarks);
		}
		if (action.equals("populatevolume")){
		   String genrc_code=request.getParameter("genrc_code");
		   String quantity=request.getParameter("quantity");
		   String fluid=request.getParameter("fluid");
		   String row_no=request.getParameter("row_no");
		   
		   String volume=bean.getVolume(quantity,genrc_code,fluid);
			 out.println("assignVolume('" + volume + "','" + row_no + "');");
		}
		try{
			if (action.equals("STOREVALUES")){ 
				for (int i=0;i<storedgroups.size();i++){ 
					String code=(String)storedgroups.get(i);
					ArrayList temp=new ArrayList();
					//ArrayList temp1=new ArrayList();
					
					for (int j=0;j<arrgencode.size();j++){
						
						String subcode=(String)arrgroupcode.get(j);
						if (subcode.equals(code)){	
							temp.add((String)arrgencode.get(j));
							temp.add((String)arrgenname.get(j));
							temp.add((String)arrqty.get(j));
							temp.add((String)arrunit.get(j));
							temp.add((String)arrcalc.get(j));
							temp.add((String)arrgroupcode.get(j));
							String reason=(String)arroverridereason.get(j);
							if(reason.equals("N"))
								reason="";
							temp.add(reason);
							temp.add((String)arrprefdrug.get(j));;
						}
					}
					bean.addGenerics(code,temp);
					bean.setNcpVal(ncp_n_val);
				}
			}
			else if (action.equals("CALCULATEENDDATE")){
				String sdate			= request.getParameter("sdate");
				if(!locale.equals("en"));  //added for [IN:031523] to avoid leap year issue
				sdate  = com.ehis.util.DateUtils.convertDate(sdate, "DMYHM",locale,"en"); //added for [IN:031523] to avoid leap year issue
				String durn			= request.getParameter("duration");
				String  enddate		="";
				enddate					=bean.getEndDate(sdate,durn);
				enddate  = com.ehis.util.DateUtils.convertDate(enddate, "DMYHM","en",locale); //added for [IN:031523] to avoid leap year 
				out.println("document.TpnAdmin.enddate.value='"+enddate+"';");
			}
			else if (action.equals("REMARKS")){

				String or_bean_name	= "eOR.OrderEntryBean";
				String or_bean_id	= "@orderentrybean"+patient_id+encounter_id;
				OrderEntryBean orbean = (OrderEntryBean)getBeanObject(or_bean_id,or_bean_name,request);
				eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) orbean.getOrderEntryRecordBean();

				String order_catalog_code	= request.getParameter("drug_code");
				String order_type				= request.getParameter("order_type");
				String click_yn				= request.getParameter("click_yn");// click_yn added for [IN:039576]
				//String form_code				= request.getParameter("form_code");
				//String route_code				= request.getParameter("route_code");
				String order_category			= "PH";

				String format_id					= bean.getFormatId(order_category, order_type, order_catalog_code);
				out.println("validateRemarks('" + format_id + "','" + click_yn + "');");// click_yn added for [IN:039576]
				putObjectInBean(or_bean_id,orbean,request);
			}
			else if(action.equals("OnlineReport")){
				 String patient_class=request.getParameter("patient_class"); 
				 String order_id=request.getParameter("order_id"); 
				 if(order_id == null){
						order_id="";
				 } 
				 String report_id = "PHBOPPTPN";
				 String ReportOutput		=	"";
				 if(order_id.equals("")){ 
					order_id=bean.getOrderID(); 
				 }
				ecis.utils.OnlineReports onlineReports		=	null;
				ecis.utils.OnlineReport report1				=	null;
				onlineReports 		= new ecis.utils.OnlineReports() ;
				report1				= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
				report1.addParameter("p_order_id",order_id);
				report1.addParameter("p_patclass",patient_class);
				report1.addParameter("p_locncode","");
				report1.addParameter("p_iv_prep_yn","8"); 
				report1.addParameter("p_report_id",report_id) ;  
				report1.addParameter("p_user_name",login_user) ;
				report1.addParameter("p_facility_id",facility_id) ;  
				report1.addParameter("p_module_id", "PH") ;
				report1.addParameter("P_LANGUAGE_ID",(String)session.getAttribute("LOCALE")) ;
				report1.addParameter("p_patient_id",patient_id) ;//code added for SKR-SCF-0915[IN046734]				
				onlineReports.add( report1) ; 
				ReportOutput = onlineReports.execute( request, response );  
			}
			else if (action.equals("SUBMIT")){
					
				String drugcode			= request.getParameter("drug_code")==null?"":request.getParameter("drug_code");
				String or_bean_name		= "eOR.OrderEntryBean";
				String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
				
				OrderEntryBean orbean	= (OrderEntryBean)getBeanObject(or_bean_id,or_bean_name,request);
				eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean)orbean.getOrderEntryRecordBean();

				TPNRegimenBean oRegimenBean	= (TPNRegimenBean)getBeanObject( "@TPNRegimenBean"+patient_id+encounter_id, "ePH.TPNRegimenBean", request);
				TPNStandardRegimenBean oStandardRegimenBean = (TPNStandardRegimenBean)getBeanObject("@TPNStandardRegimenBean"+patient_id+encounter_id,"ePH.TPNStandardRegimenBean", request);
				
				//ArrayList	Remarks	= new ArrayList();
				HashMap orderFormatHash	= new HashMap();	// To store it in the HashMap
				ArrayList arrSeq_num			= new ArrayList();	// get the seq in ArrayList
				Hashtable template				= new Hashtable();	// get the template values in the HashTable
				int seq_num 						= 0;
				String order_format_values	= "";
				String row_value				= (drugcode+"_"+"0");
				String catalog_code			=drugcode;
				arrSeq_num						= (java.util.ArrayList)orderEntryRecordBean.getOrderFormats(catalog_code, row_value);
				
				if(arrSeq_num != null && arrSeq_num.size() >0){
					int k	=0;
					for(k=0;k<arrSeq_num.size();k++){
						seq_num		= ((Integer)arrSeq_num.get(k)).intValue();	// get the seq_num
						template	= (java.util.Hashtable)orderEntryRecordBean.getOrderFormats(catalog_code, (catalog_code+seq_num));
						
						orderFormatHash.put("seq_num"+k,String.valueOf(seq_num));
						orderFormatHash.put("field_mnemonic"+k,(String) template.get("field_mnemonic"));
						orderFormatHash.put("label_text"+k,(String) template.get("label_text"));
						orderFormatHash.put("accept_option"+k,(String) template.get("accept_option"));
						orderFormatHash.put("field_type"+k,(String) template.get("field_type"));
						orderFormatHash.put("field_values"+k,(String) template.get("field_values"));
						order_format_values += ((String) template.get("label_text") + " : " + (String) template.get("field_values")) +",";
					}
					orderFormatHash.put("order_format_count", (String.valueOf(k)));
					orderFormatHash.put("order_format_values", order_format_values);
					bean.setRegimenRemarks(orderFormatHash);
				}
				//bean.clear();			
				oStandardRegimenBean.clear();
				oRegimenBean.clear();
				putObjectInBean(or_bean_id,orbean,request);
			}
		}//end of try
		catch(Exception e){
			e.printStackTrace();
		}
		putObjectInBean(bean_id,bean,request);
	}
%>
