<%@page  import="java.sql.*, java.util.*, java.io.*, ePH.Common.*, ePH.*,eST.*,eST.Common.*" contentType="text/html;charset=ISO-8859-1 " %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
	try {
		String called_from			= request.getParameter("called_from");
		Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash						= (Hashtable)hash.get( "SEARCH" ) ;
		String bean_id				= (String) hash.get( "bean_id" );
		String bean_name			= (String) hash.get( "bean_name" );
		if(called_from!= null && called_from.equals("populateDispNo")) {
			String patient_id		= (String) hash.get( "p_patient_id" );
			String disp_date		= (String) hash.get( "p_disp_date" );
			String pat_class		= (String) hash.get( "p_pat_class" );
			String stage			= (String) hash.get( "stage" );
			String order_type		= (String) hash.get( "order_type" );
			String p_doc_no		= hash.get( "p_doc_no" )==null?"":(String) hash.get( "p_doc_no" ); //added for AMS-CRF-0079 [IN:050762] -start
			String display_doc_no = hash.get( "display_doc_no" )==null?"":(String) hash.get( "display_doc_no" ); //added for AMS-CRF-0079 [IN:050762] -start
			if(order_type == null) {
				order_type = "";
			}
			String fm_disp_no		= "";
			String to_disp_no		= "";
			ArrayList disp_nos	=	new ArrayList();
			PHRepDispStatisByDispBean beanObj	= (PHRepDispStatisByDispBean)getBeanObject(bean_id, bean_name, request);
			if(stage.equals("F") || stage.equals("A")){
				disp_nos	=	beanObj.getDispNosFill(patient_id,disp_date,pat_class,order_type, p_doc_no); // , p_doc_no added for AMS-CRF-0079 [IN:050762] 
			}
			else if(stage.equals("D")){
				disp_nos	=	beanObj.getDispNos(patient_id,disp_date,pat_class,order_type, p_doc_no); // , p_doc_no added for AMS-CRF-0079 [IN:050762]
			}
			if(disp_nos.size()!=0) {
				fm_disp_no	=	(String)disp_nos.get(0);
				to_disp_no	=	(String)disp_nos.get(disp_nos.size()-2);
			}
			System.err.println("disp_nos.size()==38===>"+disp_nos.size());
			StringBuffer dispNo = new StringBuffer();//SKR-SCF-1278
			for(int i=0;i<disp_nos.size();i=i+2){
								
					if(i==0){
						//dispNo.append("");
						dispNo.append((String)disp_nos.get(0));
						if(disp_nos.size()>2) //changed 1 to 2 for SKR-SCF-1278.1
							dispNo.append(",");
					}else{
						if(i==(disp_nos.size()-2)){
							dispNo.append((String)disp_nos.get(i));
							
						}else{
							dispNo.append((String)disp_nos.get(i));
							dispNo.append(",");
							//dispNo.append(")");
						}
					}
			}
			System.err.println("dispNo.size()==38=58==>"+dispNo);
			out.println("setDispNos('"+fm_disp_no+"','"+to_disp_no+"','"+dispNo.toString()+"')");  			
			out.println("clearDispNos()");
			for(int k=0; k<disp_nos.size(); k=k+2) {
			    out.println("loadDispNos('"+(String)disp_nos.get(k)+"','"+(String)disp_nos.get(k+1)+"')");
			}
			if(patient_id.equals("") && !p_doc_no.equals("") &&display_doc_no.equals("Y")){ //added for AMS-CRF-0079 [IN:050762]
				patient_id = beanObj.getPatientID(p_doc_no);
				if(patient_id==null)
					patient_id="";
				out.println("populatePatientID('"+patient_id+"');");
			}
			putObjectInBean(bean_id,beanObj,request);
		}
		else  if(called_from!= null && called_from.equals("populateSyrngDispNo")){
			String patient_id		= (String) hash.get( "p_patient_id" );
			String disp_date		= (String) hash.get( "p_disp_date" );
			String pat_class		= (String) hash.get( "p_patient_class" );
			
			ArrayList disp_nos	=	new ArrayList();
			PHRepDispStatisByDispBean beanObj	= (PHRepDispStatisByDispBean)getBeanObject(bean_id, bean_name, request);
			disp_nos	=	beanObj.getSyrngDispNos(patient_id,disp_date,pat_class);
			out.println("clearDispNos()");
			for(int k=0; k<disp_nos.size(); k++) {
			    out.println("loadDispNos('"+(String)disp_nos.get(k)+"','"+(String)disp_nos.get(k)+"')");
			}
			putObjectInBean(bean_id,beanObj,request);
		}
		else if(called_from!= null && called_from.equals("release")) {
			ReleaseBatchesBean beanObj		= (ReleaseBatchesBean)getBeanObject(bean_id, bean_name, request);
			Enumeration keys		= hash.keys();
			String key				=	null;
			String value			=  null;
		
			while(keys.hasMoreElements()) {
				key				= (String)keys.nextElement();
				value			= (String)hash.get(key);
				if(key.startsWith("chk_")){
					beanObj.getRecordStatus().put(key.substring(4,key.length()),value);
				}
			}
			putObjectInBean(bean_id,beanObj,request);	
		}
		else if(called_from!= null && called_from.equals("populateLabelNos")) {
			String disp_no		= (String) hash.get( "disp_no" );
			String pat_class	= (String) hash.get( "p_pat_class" );

			PHRepDispStatisByDispBean beanObj	= (PHRepDispStatisByDispBean)getBeanObject(bean_id, bean_name, request);
			ArrayList label_nos		=	beanObj.getLabelNos(disp_no);
			if(pat_class.equals("OP")) {
				out.println("clearLabelNos()");
				for(int k=0; k<label_nos.size(); k++) {
					out.println("loadLabelNos('"+(String)label_nos.get(k)+"');");
				}
			}
			putObjectInBean(bean_id,beanObj,request);
		}  
		else if(called_from!= null && called_from.equals("populateEncounter")) {
			String patient_id	= (String) hash.get( "patient_id" );
			QueryMednAdminChartBean beanObj	= (QueryMednAdminChartBean)getBeanObject(bean_id, bean_name, request);
			//String encounter_id		 =	beanObj.getEncounter(patient_id);	//Commented for ML-BRU-SCF-0499[IN035594]				
			ArrayList encounter_id_class =	(ArrayList)beanObj.getEncounterPatientClass(patient_id);	//added for ML-BRU-SCF-0499[IN035594] - start
			if(encounter_id_class.size() > 0){
				 for (int i=0;i<encounter_id_class.size();i++){
					out.println("setEncounterID('" +(String)encounter_id_class.get(i)+"')");
				}
			}		//added for for ML-BRU-SCF-0499[IN035594] - end	
			else // else part added for ML-BRU-SCF-0499[IN035594] and SKR-SCF-0721[IN036365]
			   out.println("defaultOption()");
			/*if(encounter_id!=null && !encounter_id.equals("")) {
				out.println("setEncounterID('"+encounter_id+"')");

			}*/ //commented for for ML-BRU-SCF-0499[IN035594]
			putObjectInBean(bean_id,beanObj,request);
		}
		else if(called_from!= null && called_from.equals("routeForDrug")) {
			String drugCode     =  request.getParameter("drug_code");
			String route_desc = ""; 
			String  route_color =  "", fntColor="", backgrndColor="";// added for CRF RUT-CRF-0034.1[IN:037389]
			bean_id     =  request.getParameter("bean_id");
			bean_name     =  request.getParameter("bean_name");
			
			QueryPresVsDispDrugsBean bean = (QueryPresVsDispDrugsBean)getBeanObject( bean_id, bean_name, request ) ;
			out.println("clearList()");
			ArrayList routeCodes = (ArrayList) bean.getRouteCodesForDrug(drugCode);
			out.println("addOption('','All')");
			for(int i=0;i<routeCodes.size();i=i+3){
				route_desc = routeCodes.get(i+1)==null?"":(String)routeCodes.get(i+1);	//added for IN26128reopen --09/02/2011-- priya
				route_desc=route_desc.replaceAll(" ","%20");
				route_desc=java.net.URLEncoder.encode(route_desc,"UTF-8");
				route_desc=route_desc.replaceAll("%2520","%20"); //added for IN26128reopen -end	
				
				route_color =(String)routeCodes.get(i+2);// added for CRF RUT-CRF-0034.1[IN:037389]-start
				if(route_color!= null && !route_color.equals("")){
					if(route_color.length()==12){
						fntColor= route_color.substring(0, 6);
						backgrndColor= route_color.substring(6, 12);
					}
				}
				else{
					fntColor= "";
					backgrndColor= "";
				}// added for CRF RUT-CRF-0034.1[IN:037389]-end

				out.println("addOption('"+routeCodes.get(i)+"','"+route_desc+"','"+fntColor+"','"+backgrndColor+"')");
			}
			putObjectInBean(bean_id, bean, request);
		} 
		else if(called_from!= null && called_from.equals("defRoutes")) {
			String route_desc = ""; 
			String  route_color =  "", fntColor="", backgrndColor="";// added for CRF RUT-CRF-0034.1[IN:037389]
			bean_id     =  request.getParameter("bean_id");
			bean_name     =  request.getParameter("bean_name");
			QueryPresVsDispDrugsBean bean = (QueryPresVsDispDrugsBean)getBeanObject( bean_id, bean_name, request ) ;
			out.println("clearList()");
			ArrayList routeCodes		  =  bean.getRouteCodes();
			for(int i=0;i<routeCodes.size();i=i+3){
				route_desc = routeCodes.get(i+1)==null?"":(String)routeCodes.get(i+1);	//added for IN26128reopen --09/02/2011-- priya
				route_desc=route_desc.replaceAll(" ","%20");
				route_desc=java.net.URLEncoder.encode(route_desc,"UTF-8");
				route_desc=route_desc.replaceAll("%2520","%20"); //added for IN26128reopen -end	
				
				route_color =(String)routeCodes.get(i+2);// added for CRF RUT-CRF-0034.1[IN:037389]-start
				if(route_color!= null && !route_color.equals("")){
					if(route_color.length()==12){
						fntColor= route_color.substring(0, 6);
						backgrndColor= route_color.substring(6, 12);
					}
				}
				else{
					fntColor= "";
					backgrndColor= "";
				}// added for CRF RUT-CRF-0034.1[IN:037389]-end

				out.println("addOption('"+routeCodes.get(i)+"','"+route_desc+"','"+fntColor+"','"+backgrndColor+"')");
			}
			putObjectInBean(bean_id, bean, request);
		}
		else if(called_from.equals("Fill_proc_id")){
			String nursing_unit = (String)hash.get("nuint");
			String  bean_id1 = (String)hash.get("bean_id1");
			String bean_name1 = (String)hash.get("bean_name1");
			PHReportsBean bean = (PHReportsBean)getBeanObject( bean_id1, bean_name1, request ) ;
			out.println("clearList()");
			ArrayList process_id = (ArrayList) bean.getProcessIds(nursing_unit);
	  		int j = process_id.size();
			if(j==0){
				out.println("addEmpty()");
			}
    		if (j==1){
				String procid = (String)process_id.get(0);
				ArrayList disp_id1 = (ArrayList)bean.getDispIds(procid,nursing_unit);
				if(disp_id1.size() >0 ){
					out.println("loadFillProcNos('"+(String)process_id.get(0)+"')");
					out.println("loadDispNos('"+(String)disp_id1.get(0)+"','"+(String)disp_id1.get(1)+"','"+procid+"') ");
				}
			}
			if(process_id.size() >1){
				out.println("addEmpty()");
				try{
					for(int i=0;i<process_id.size();i=i+1){
						out.println("loadFillProcNos('"+(String)process_id.get(i)+"')");
					}
				}
				catch(Exception e1){	
					out.println("alert(\"" + e1 + "\");") ;
					e1.printStackTrace();
				}
			}
			putObjectInBean(bean_id1, bean, request);
		}
		else if(called_from.equals("Disp_order_id")){
			String fill_proc_id = (String)hash.get("procid");
			String nur_unit_code  = (String)hash.get("nunit");
			String  bean_id1 = (String)hash.get("bean_id1");
			String bean_name1 = (String)hash.get("bean_name1");
			PHReportsBean bean = (PHReportsBean)getBeanObject( bean_id1, bean_name1, request ) ;
			ArrayList disp_id = (ArrayList) bean.getDispIds(fill_proc_id,nur_unit_code);
			if(disp_id.size() > 0){
				out.println("loadDispNos('"+(String)disp_id.get(0)+"','"+(String)disp_id.get(1)+"','"+fill_proc_id+"') ");
			}

			putObjectInBean(bean_id1, bean, request);
		} 
		else if(called_from!= null &&  called_from.equals("Disp_Date")){
			
			String disp_date1=request.getParameter("disp_date");
			String bean_id1=request.getParameter("bean_id");
			String bean_name1=request.getParameter("bean_name");
			PHRepDispStatisByDispBean bean = (PHRepDispStatisByDispBean)getBeanObject( bean_id1, bean_name1, request ) ;
			ArrayList fill_id=(ArrayList)bean.populateFillProcessId(disp_date1);
			out.println("clearFillProcList()");
			out.println("addSelect()");
			if(fill_id.size() > 0){
				 for (int i=0;i<fill_id.size();i=i+1){
					out.println("addData('" +(String)fill_id.get(i)+"','document.formPHRepPatFillCriteria.p_fill_proc_id')");
				}
			}
			putObjectInBean(bean_id1, bean, request);

		} 
		else if(called_from!= null &&  called_from.equals("Dispense_Facility")){//Add on date 16-03-2009         Dispensing Facility
			
			String disp_facility_code=request.getParameter("disp_facility_code");
			String bean_id1=request.getParameter("bean_id");
			String bean_name1=request.getParameter("bean_name");
			//For Dispense Location
			HashMap p_dispense_locn=new HashMap();
			ArrayList displocn_code=new ArrayList();
			ArrayList displocn_desc=new ArrayList();
						
			PHRepDispStatisByDispBean bean = (PHRepDispStatisByDispBean)getBeanObject( bean_id1, bean_name1, request ) ;
			//Dispense Location
			p_dispense_locn=bean.populateDispenselocn(disp_facility_code);
			displocn_code=(ArrayList)p_dispense_locn.get("code");
			displocn_desc=(ArrayList)p_dispense_locn.get("desc");

			out.println("clearDisp_locnList()");
			out.println("addSelectToDisp_locnList()");
		
			if(displocn_code.size() > 0){
				 for (int i=0;i<displocn_code.size();i=i+1){
					out.println("addDataToDisp_locnList('" +(String)displocn_code.get(i)+"','" +(String)displocn_desc.get(i)+"','document.formPHRepPatFillCriteria.p_disp_locn_code')");
				}
			}
			putObjectInBean(bean_id1, bean, request);
			// End ----------------
		}
		else if(called_from.equals("get_duration")){
			String wrksht_id      = (String)hash.get("wrksht_id");
            String ws_type        = (String)hash.get("ws_type");
			String disp_locn_code = (String)hash.get("disp_locn_code");
			
			ArrayList duration_values   =   new ArrayList();
			String duration     = "";
			String ord_type     = "";
			String repeat_value = "";				
			 
   	   		bean_id = (String)hash.get("bean_id");
			bean_name = (String)hash.get("bean_name");
	  		DispMedicationBean bean = (DispMedicationBean)getBeanObject( bean_id, bean_name, request ) ;
			if(!wrksht_id.equals("")){
				duration_values = (ArrayList)bean.getDurnValue(wrksht_id,ws_type,disp_locn_code);
				duration = (String)duration_values.get(0);
				ord_type = (String)duration_values.get(1);
				repeat_value = (String)duration_values.get(2);

				out.println("assignDuration('"+duration+"','"+ord_type+"','"+repeat_value+"') ");
			}
			putObjectInBean(bean_id, bean, request);
		} 
		else if(called_from.equals("print_label")){

   	   	     String  bean_id1		= (String)hash.get("bean_id1");
			 String bean_name1		= (String)hash.get("bean_name1");
			 String report_id		= (String)hash.get("p_report_id");
			 String p_nursing_unit	= (String)hash.get("p_nursing_unit");
			 String p_order_type	= (String)hash.get("p_order_type");
			 String p_facility_id	= (String)hash.get("p_facility_id");
			 String p_user_name		= (String)hash.get("p_user_name");
			 String p_module_id		= (String)hash.get("p_module_id");
			 String p_disp_fm_no	= (String)hash.get("p_disp_fm_no");
			 String p_disp_to_no	= (String)hash.get("p_disp_to_no");
			 String p_fill_prc_id	= (String)hash.get("p_fill_prc_id");
			 String p_language_id	= (String)hash.get("p_language_id");
			 String p_ord_facility_id	= (String)hash.get("p_ord_facility_id");

			 String ReportOutput	= "";
		
			 int starting_disp_no	= Integer.parseInt(p_disp_fm_no);
			 int last_disp_no		= Integer.parseInt(p_disp_to_no);

			 ecis.utils.OnlineReports onlineReports1 		= new ecis.utils.OnlineReports() ;
			 ecis.utils.OnlineReport report1				=	null;

			for(int i=starting_disp_no ;i<=last_disp_no;i++){
				report1				= new ecis.utils.OnlineReport( p_facility_id, "PH",report_id) ;
				report1.addParameter("p_report_id",report_id) ;
				report1.addParameter("p_disp_fm_no",i+"");
				report1.addParameter("p_disp_to_no",i+"");
				//report1.addParameter("p_srl_no", "1") ;
				report1.addParameter("nunit",p_nursing_unit) ;
				report1.addParameter("p_facility_id",p_facility_id) ;
				report1.addParameter("p_module_id", "PH") ;
				report1.addParameter("p_user_name",p_user_name) ;
				report1.addParameter("p_fill_prc_id",p_fill_prc_id);
				report1.addParameter("p_language_id",p_language_id);
				report1.addParameter("p_ord_facility_id",p_ord_facility_id);
				onlineReports1.add( report1) ;	
			}
			ReportOutput = onlineReports1.execute( request, response );
			onlineReports1 =null;
			out.println("assignResult('Y') ");
		}
		else if(called_from.equals("print_disp_lables")){
			String bean_id1		= (String)hash.get("bean_id");
			String bean_name1		= (String)hash.get("bean_name");
			String p_report_id		= (String)hash.get("p_report_id");
			String p_disp_no		= (String)hash.get("p_disp_no");
			String p_user_name		= (String)hash.get("p_user_name");
			String p_facility_id	= (String)hash.get("p_facility_id");
			String p_patient_id	= (String)hash.get("p_patient_id");
			String p_patient_class	= (String)hash.get("p_patient_class");
			String stage			= (String)hash.get("stage");
			String p_language_id   =(String)hash.get("p_language_id");
			ArrayList	disp_no_text	=	new ArrayList();//Added for IN047510
			 /*	A--->allocation/filling
		        D---->delivery/allstages*/
		    StringTokenizer disp_nos_tokens	=	new StringTokenizer(p_disp_no,"~");//Added for IN047510--start
		     while(disp_nos_tokens.hasMoreTokens()) {
		    	String txt	=	(String)disp_nos_tokens.nextToken();
		    	disp_no_text.add(txt);
		    	}//Added for IN047510--end
			if (stage.equals("F") || stage.equals("A")) {
				stage = "A";
			}

			PHRepDispStatisByDispBean bean = (PHRepDispStatisByDispBean)getBeanObject( bean_id1, bean_name1, request ) ;
			//ArrayList disp_srl_no			= (ArrayList)bean.getDispSrlNO(p_disp_no,stage);
			String ReportOutput	= "";

			ecis.utils.OnlineReports onlineReports		= new ecis.utils.OnlineReports() ;
			ecis.utils.OnlineReport report				=	null;
System.err.println("====print_disp_lables======p_report_id======>"+p_report_id);

			if(disp_no_text.size()>0){//Modified for IN047510 disp_srl_no changed to  disp_no_text
				for(int n=0;n<disp_no_text.size();n++){//Modified for IN047510
					report				= new ecis.utils.OnlineReport( p_facility_id, "PH",p_report_id) ;
					report.addParameter("p_report_id",p_report_id) ;
					report.addParameter("p_disp_no",(String)disp_no_text.get(n));
					//report.addParameter("p_srl_no", (String)disp_no_text.get(n)) ;//Commented for IN047510
					report.addParameter("p_user_name",p_user_name) ;
					report.addParameter("p_facility_id",p_facility_id) ;
					report.addParameter("p_patient_id",p_patient_id) ;							
					report.addParameter("p_patient_class",p_patient_class);
					report.addParameter("p_module_id", "PH") ;
					//report.addParameter("p_order_id", bean.getOrderId(p_disp_no,stage)) ;//Commented for IN047510
					report.addParameter("p_language_id", p_language_id) ;
					onlineReports.add( report) ;
System.err.println("====print_disp_lables======p_report_id======>"+p_report_id+" p_disp_no="+(String)disp_no_text.get(n)+" p_user_name="+p_user_name+" p_facility_id="+p_facility_id+" p_patient_id"+p_patient_id+" p_patient_class="+p_patient_class+" p_language_id"+p_language_id);
				}									
			}
			ReportOutput = onlineReports.execute( request, response );
System.err.println("====print_disp_lables======p_report_id======>"+p_report_id+"==ReportOutput=="+ReportOutput);
			onlineReports =null;
			out.println("assignResult('Y') ");
		}
		else if(called_from.equals("print_ivdisp_lables")){

   	   	    String bean_id1		= (String)hash.get("bean_id");
			String bean_name1		= (String)hash.get("bean_name");

			String p_report_id		= (String)hash.get("p_report_id");
			String p_disp_no		= (String)hash.get("p_disp_no");
			String p_user_name		= (String)hash.get("p_user_name");
			String p_facility_id	= (String)hash.get("p_facility_id");
			String p_patient_id	= (String)hash.get("p_patient_id");
			String p_patient_class	= (String)hash.get("p_patient_class");
			String stage			= (String)hash.get("stage");
			String p_disp_date		= (String)hash.get("p_disp_date");
			String p_language_id   =(String)hash.get("p_language_id");

			 /*	A--->allocation/filling
		        D---->delivery/allstages*/
			if (stage.equals("F") || stage.equals("A")) {
				stage = "A";
			}
			String ReportOutput	= "";
			ArrayList  order_line_field_values	= new ArrayList();	
			int repeat_value			= 0;

	   		PHRepDispStatisByDispBean bean		= (PHRepDispStatisByDispBean)getBeanObject( bean_id1, bean_name1, request ) ;
			ArrayList disp_srl_no				= (ArrayList)bean.getDispSrlNO(p_disp_no,stage);

			//String order_id					=	(String)bean.getOrderId(p_disp_no,stage);
			/*if(p_report_id.equals("PHRIVINTTFILL")||p_report_id.equals("PHRIVINTT")){
				order_line_field_values			=	(ArrayList)bean.getOrderLineFieldValues(order_id);
			}*/
			/*else if(p_report_id.equals("PHRIVCONTFILL")||p_report_id.equals("PHRIVCONT")){
				//repeat_value					=	bean.getRepeatValue(order_id);
			}*/
 
			ecis.utils.OnlineReports onlineReports		= new ecis.utils.OnlineReports() ;
			ecis.utils.OnlineReport report				= null;

			if(disp_srl_no.size()>0){
				for(int n=0;n<disp_srl_no.size();n++){
					if(p_report_id.equals("PHRIVINTTFILL")||p_report_id.equals("PHRIVINTT")){
					//	for(int m=0;m<order_line_field_values.size();m++){ commented for ARYU-SCF-0042 && ARYU-SCF-0047
							report				= new ecis.utils.OnlineReport( p_facility_id, "PH",p_report_id) ;
							report.addParameter("p_report_id",p_report_id) ;
							report.addParameter("p_user_name",p_user_name) ;
							report.addParameter("p_module_id", "PH") ;
							report.addParameter("p_patient_id",p_patient_id) ;							
							report.addParameter("p_disp_no",p_disp_no);
							report.addParameter("p_facility_id",p_facility_id) ;
							report.addParameter("p_disp_date",p_disp_date) ;
							report.addParameter("p_patient_class",p_patient_class);
							report.addParameter("p_srl_no", (String)disp_srl_no.get(n)) ;
							//report.addParameter("p_order_line_field_value", (String)order_line_field_values.get(m)) ;
							report.addParameter("p_mode", "PRINT") ;
							report.addParameter("p_language_id", p_language_id) ;
							onlineReports.add( report) ;										
						//}
					}
					else if(p_report_id.equals("PHRIVCONTFILL")||p_report_id.equals("PHRIVCONT")){
						//for(int m=1;m<=repeat_value;m++){commented ARYU-SCF-0042 && ARYU-SCF-0047
							report				= new ecis.utils.OnlineReport( p_facility_id, "PH",p_report_id) ;
							report.addParameter("p_report_id",p_report_id) ;
							report.addParameter("p_user_name",p_user_name) ;
							report.addParameter("p_module_id", "PH") ;
							report.addParameter("p_patient_id",p_patient_id) ;							
							report.addParameter("p_disp_no",p_disp_no);
							report.addParameter("p_facility_id",p_facility_id) ;
							report.addParameter("p_disp_date",p_disp_date) ;
							report.addParameter("p_patient_class",p_patient_class);
							report.addParameter("p_srl_no", (String)disp_srl_no.get(n)) ;
							report.addParameter("p_seq_no", n+"") ;
							report.addParameter("p_mode", "PRINT") ;	
							report.addParameter("p_language_id", p_language_id) ;
							onlineReports.add( report) ;										
						//}	
					}else if(p_report_id.equals("PHRFILLCONWOADD") || p_report_id.equals("PHRIVCONTWOADD")){//added for ARYU-SCF-0042 && ARYU-SCF-0047
						//System.err.println("p_report_id====>"+p_report_id);
					//	for(int m=0;m<order_line_field_values.size();m++){ commented ARYU-SCF-0042 && ARYU-SCF-0047
							report				= new ecis.utils.OnlineReport( p_facility_id, "PH",p_report_id) ;
							report.addParameter("p_report_id",p_report_id) ;
							report.addParameter("p_user_name",p_user_name) ;
							report.addParameter("p_module_id", "PH") ;
							report.addParameter("p_patient_id",p_patient_id) ;							
							report.addParameter("p_disp_no",p_disp_no);
							report.addParameter("p_facility_id",p_facility_id) ;
							report.addParameter("p_disp_date",p_disp_date) ;
							report.addParameter("p_patient_class",p_patient_class);
							report.addParameter("p_disp_fm_no", p_disp_no) ;
							report.addParameter("p_disp_to_no", p_disp_no) ;
							report.addParameter("p_mode", "PRINT") ;
							report.addParameter("p_language_id", p_language_id) ;
							onlineReports.add( report) ;										
						//}
					}
				}
				ReportOutput = onlineReports.execute( request, response );
			}
			onlineReports =null;
			out.println("assignResult('Y') ");
		} 
		else if(called_from != null && called_from.equals("patientsearch" ) ){// added for ML-BRU-SCF-0498 [IN035593]
			String patient_id					= (String) hash.get("patient_id");
			String bean_id1					= (String) hash.get("bean_id");
			String bean_name1					= (String) hash.get("bean_name");
			PHReportsBean bean = (PHReportsBean)getBeanObject( bean_id1, bean_name1, request ) ;
			ArrayList patientdetails	= bean.getPatientDetails(patient_id);
			if(patientdetails.size()==0){
				out.println("chkpatID('N');") ;
			}
			else{
				out.println("chkpatID('Y');") ;
			}
		}		
		else if(called_from!= null && called_from.equals("populateDocNo")) { //code added for GHL-CRF-0323[IN:040527]--Start 
			String patient_id		= (String) hash.get( "p_patient_id" );
			String disp_date		= (String) hash.get( "p_disp_date" );
			String pat_class		= (String) hash.get( "p_pat_class" );
			String stage			= (String) hash.get( "stage" );			
						
			ArrayList doc_nos	=	new ArrayList();
			PHRepDispStatisByDispBean beanObj	= (PHRepDispStatisByDispBean)getBeanObject(bean_id, bean_name, request);
			doc_nos	=	beanObj.getDocNos(patient_id,disp_date,pat_class,stage);			
			out.println("clearDocNos()");
			for(int k=0; k<doc_nos.size(); k++) {
			    out.println("loadDocNos('"+(String)doc_nos.get(k)+"')");
			}
			putObjectInBean(bean_id,beanObj,request);
		}//code added for GHL-CRF-0323[IN:040527]--End 
		else if(called_from!= null && called_from.equals("ReportSubmit")) { //Added for MMS-QH-CRF-0106 [IN:039374]
		    String beanid				=	hash.get("bean_id").toString();
		    String beanname			=	hash.get("bean_name").toString();
			String disp_locn_code		= 	hash.get("disp_locn_code").toString();
			String dt_from				=	hash.get("dt_from").toString();
			String dt_to				=	hash.get("dt_to").toString();
			String customer_code		=	hash.get("customer_code").toString();
			String pat_class		=	hash.get("p_pat_class").toString();
			String customer_group_frm	=	hash.get("customer_group_frm").toString();
			String customer_group_to	=	hash.get("customer_group_to").toString();
						
			//ArrayList recCount	=	new ArrayList();
			PHReportsBean beanObj = (PHReportsBean)getBeanObject(beanid, beanname, request);
			//recCount	=	beanObj.getRecord(disp_locn_code,dt_from,dt_to,customer_code,pat_class,customer_group_frm,customer_group_to);			
			int recCount	=	beanObj.getRecord(disp_locn_code,dt_from,dt_to,customer_code,pat_class,customer_group_frm,customer_group_to);			
			out.println(""+recCount+"");
			
			putObjectInBean(bean_id,beanObj,request);
		}
		else if(called_from!= null && called_from.equals("chkDuplicateRec")) { //Added for MMS-QH-CRF-0106 [IN:039374]
		    String beanid				=	hash.get("bean_id").toString();
		    String beanname				=	hash.get("bean_name").toString();
			String item_desc			= 	hash.get("item_desc").toString();
			String instruction			=	hash.get("instruction").toString();
			String qty_value			=	hash.get("qty_value").toString();
			boolean duplicate			=	true;
						
			ArrayList recDuplicate	=	new ArrayList();
			PhReprintHomeMednBean beanObj = (PhReprintHomeMednBean)getBeanObject(beanid, beanname, request);
			duplicate	=	beanObj.chkDuplicate(item_desc,instruction,qty_value);			
			out.println(""+duplicate+"");
			
			putObjectInBean(bean_id,beanObj,request);
		}
		else if(called_from!= null && called_from.equals("updateDuplicateRec")) { //Added for RUT-CRF-0061 - Start
		    String beanid				=	hash.get("bean_id").toString();
		    String beanname				=	hash.get("bean_name").toString();
			String item_desc			= 	hash.get("item_desc").toString();
			String instruction			=	hash.get("instruction").toString();
			String qty_value			=	hash.get("qty_value").toString();
			boolean udpateduplicate			=	true;
						
			ArrayList recDuplicate	=	new ArrayList();
			PhReprintHomeMednBean beanObj = (PhReprintHomeMednBean)getBeanObject(beanid, beanname, request);
			udpateduplicate	=	beanObj.updateDuplicateRec(item_desc,instruction,qty_value);			
			out.println(""+udpateduplicate+"");
			
			putObjectInBean(bean_id,beanObj,request);
		}
		else if(called_from!= null && called_from.equals("InsertPrintRec")) { 
		    String beanid				=	hash.get("bean_id").toString();
		    String beanname				=	hash.get("bean_name").toString();
			//String selected_data		= 	hash.get("selected_data")==null?"":hash.get("selected_data").toString();//Commented for RUT-SCF-0383[IN46980]
			String edit_data			=	hash.get("edit_data")==null?"":hash.get("edit_data").toString();
			String view_opt				=	hash.get("view_opt")==null?"":hash.get("view_opt").toString();//Added for [IN45914]
			PhReprintHomeMednBean beanObj = (PhReprintHomeMednBean)getBeanObject(beanid, beanname, request);
			HashMap InsertRecord	=	beanObj.InsertPrintRecord(edit_data);//Modified for RUT-SCF-0383[IN46980]
			String patient_id		=	beanObj.getPatientId();//Added for RUT-SCF-0384[IN46988]
			String	result="false";
			String message="";
			String print_seq_no="";
			if(InsertRecord.containsKey("result") && InsertRecord.containsKey("message")){
			    result=InsertRecord.get("result")==null?"":InsertRecord.get("result").toString();
			    message=InsertRecord.get("message")==null?"":InsertRecord.get("message").toString();
			    print_seq_no=InsertRecord.get("print_seq_no")==null?"":InsertRecord.get("print_seq_no").toString();
			}
			out.println("assignresult('"+result+"','"+message+"','"+print_seq_no+"','"+view_opt+"','"+patient_id+"')");//Added for [IN45914]//Added 'patiend_id' for RUT-SCF-0384[IN46988]
			
			putObjectInBean(bean_id,beanObj,request);
		}
		else if(called_from.equals("PRINT_HOME_MED_SUMM")){

			String beanid			=	hash.get("bean_id").toString();
		    String beanname			=	hash.get("bean_name").toString();
			String p_print_seq_no	=	hash.get("p_print_seq_no").toString();
			String p_report_id		=	hash.get("p_report_id").toString();
			String p_user_name		=	hash.get("p_user_name").toString();
			String p_facility_id	=	hash.get("p_facility_id").toString();
			String p_language_id   	=	hash.get("p_language_id").toString();
			String p_reprint		=	hash.get("p_reprint").toString();
			String ReportOutput	= "";
			PhReprintHomeMednBean beanObj = (PhReprintHomeMednBean)getBeanObject(beanid, beanname, request);
			ecis.utils.OnlineReports onlineReports		= new ecis.utils.OnlineReports() ;
			ecis.utils.OnlineReport report				=	null;

			report				= new ecis.utils.OnlineReport( p_facility_id, "PH",p_report_id) ;
			report.addParameter("p_report_id",p_report_id) ;
			report.addParameter("p_user_name",p_user_name) ;
			report.addParameter("p_facility_id",p_facility_id) ;
			report.addParameter("p_module_id", "PH") ;
			report.addParameter("p_language_id", p_language_id) ;
			report.addParameter("p_print_seq_no", p_print_seq_no) ;
			report.addParameter("p_reprint", p_reprint) ;
			onlineReports.add( report) ;
			ReportOutput = onlineReports.execute( request, response );
			onlineReports =null;
			out.println("Success");
			putObjectInBean(bean_id,beanObj,request);
		}//Added for RUT-CRF-0061 - End
		else if(called_from!= null && called_from.equals("populateMedicalItemDispNo")) { //Added for Bru-HIMS-CRF-394 [IN:043205]
			String patient_id		= (String) hash.get( "p_patient_id" );
			String disp_date		= (String) hash.get( "p_disp_date" );
			String pat_class		= (String) hash.get( "p_pat_class" );
			String stage		= (String) hash.get( "stage" );
			String fm_disp_no		= "";
			String to_disp_no		= "";
			ArrayList disp_nos	=	new ArrayList();
			PHRepDispStatisByDispBean beanObj	= (PHRepDispStatisByDispBean)getBeanObject(bean_id, bean_name, request);
			disp_nos	=	beanObj.getMedicalItemDispNos(patient_id,disp_date,pat_class, stage);
			if(disp_nos.size()!=0) {
				fm_disp_no	=	(String)disp_nos.get(0);
				to_disp_no	=	(String)disp_nos.get(disp_nos.size()-1);
			}
			out.println("setDispNos('"+fm_disp_no+"','"+to_disp_no+"')");  			
			out.println("clearDispNos()");
			for(int k=0; k<disp_nos.size(); k++) {
			    out.println("loadDispNos('"+(String)disp_nos.get(k)+"')");
			}
			putObjectInBean(bean_id,beanObj,request);
		}
		else if(called_from.equals("clearPresId")){//Added to show only onclick of prescription id details for RUT-SCF-0385[IN46989]
			String beanid			=	hash.get("bean_id").toString();
		    String beanname			=	hash.get("bean_name").toString();
			String pres_order_id	= hash.get("pres_order_id").toString();//Added for RUT-SCF-0383[IN46980]
			PhReprintHomeMednBean beanObj = (PhReprintHomeMednBean)getBeanObject(beanid, beanname, request);
			beanObj.clear();
			beanObj.setPresidList(pres_order_id,"");//Added for RUT-SCF-0383[IN46980]
			putObjectInBean(bean_id,beanObj,request);
		}
		//Added for RUT-SCF-0383[Inc:46980]-AlphaReOpen-Start
		else if(called_from.equals("StoreCheckValue")){
			String beanid			=	hash.get("bean_id").toString();
		    String beanname			=	hash.get("bean_name").toString();
			List<String> selected_data	=   Arrays.asList(hash.get("selected_data").toString());//Modified for RUT-SCF-0383[IN46980] - Start
			String chk_yn			=   hash.get("chk_yn").toString();
			PhReprintHomeMednBean beanObj = (PhReprintHomeMednBean)getBeanObject(beanid, beanname, request);
			beanObj.setSelectedchecks(selected_data,chk_yn);
			//Modified for RUT-SCF-0383[IN46980] - End
			putObjectInBean(bean_id,beanObj,request);
		}
	  	//Added if and else for RUT-SCF-0383[Inc:46980]-AlphaReOpen-End
		else if(called_from.equals("setPatientId")){//Added for RUT-SCF-0384[IN46988] - Start
			String beanid			=	hash.get("bean_id").toString();
		    String beanname			=	hash.get("bean_name").toString();
			String patient_id		=   hash.get("patient_id")==null?"":hash.get("patient_id").toString();//Modified for RUT-SCF-0383[IN46980] - Start
			PhReprintHomeMednBean beanObj = (PhReprintHomeMednBean)getBeanObject(beanid, beanname, request);
			beanObj.setPatientId(patient_id);
			putObjectInBean(bean_id,beanObj,request);
		}
		else if(called_from.equals("Checkpatient")){
			String beanid			=	hash.get("bean_id").toString();
		    String beanname			=	hash.get("bean_name").toString();
			PhReprintHomeMednBean beanObj = (PhReprintHomeMednBean)getBeanObject(beanid, beanname, request);
			boolean patient_select=false;
			ArrayList presid_list=beanObj.getPresidList();
			if(presid_list.size()!=0)
				patient_select=true;
			out.println(patient_select);
			putObjectInBean(bean_id,beanObj,request);
		}//Added for RUT-SCF-0384[IN46988] - End
		else if(called_from!= null && called_from.equals("ReportConsumptionByDoctor")) { //Added for MMS-QH-CRF-0108-Start
			String beanid			=	hash.get("bean_id").toString();
			String beanname			=	hash.get("bean_name").toString();
			String p_date_from		= 	hash.get("p_date_from").toString();
			String p_date_to		=	hash.get("p_date_to").toString();
			String p_patient_class		=	hash.get("p_patient_class").toString();
			String p_pract_id		=	hash.get("p_pract_id").toString();
			String p_locn_code		=	hash.get("p_locn_code").toString();
			String p_cust_grp_frm_code	=	hash.get("p_cust_grp_frm_code").toString();
			String p_cust_grp_to_code	=	hash.get("p_cust_grp_to_code").toString();
			String p_cust_frm_code		=	hash.get("p_cust_frm_code").toString();
			String p_policy_type_code	=	hash.get("p_policy_type_code").toString();
			PHReportsBean beanObj = (PHReportsBean)getBeanObject(beanid, beanname, request);
			int recCount	=	beanObj.getConsumptionByDoctor(p_date_from,p_date_to,p_patient_class,p_pract_id,p_locn_code,p_cust_grp_frm_code,p_cust_grp_to_code,p_cust_frm_code,p_policy_type_code);
			out.println(""+recCount+"");
			putObjectInBean(bean_id,beanObj,request);
		}//Added for MMS-QH-CRF-0108-End
		else if(called_from!= null && called_from.equals("Duplicate")) { //added for HSA-CRF-0236 [IN:051488]
			String patient_id		= (String) hash.get( "patientId" );		
			String chk_Patient	= (String) hash.get("chkPatientID");		
			String main_patientid   = "";		
			PHReportsBean bean = (PHReportsBean)getBeanObject( bean_id, bean_name,request);
			main_patientid  = bean.DuplicateCheck(patient_id);
			if(main_patientid != null && main_patientid!="" ){
				out.println("mergedPatientAlert('"+main_patientid+"');");			
			 }			
			else if(chk_Patient!= null && chk_Patient.equals("true")){
			   out.println("chkPatientID('"+patient_id+"');");	
			}		
			putObjectInBean(bean_id,bean,request);
		} 
		else if(called_from!= null && called_from.equals("PRESCRIPTIONTYPE")) { //added for ML-MMOH-CRF-1089  START
			String worksheet_id		= (String) hash.get( "wrksht_id" );		
			//String chk_Patient	= (String) hash.get("chkPatientID");		
			String in_prep_yn   = "";		
			PHReportsBean bean = (PHReportsBean)getBeanObject( bean_id, bean_name,request);
			in_prep_yn=bean.getiv_prep_yn(worksheet_id);
			if(in_prep_yn != null && in_prep_yn!="" ){
				out.println("in_prep_yn('"+in_prep_yn+"');");			
			 }		
			putObjectInBean(bean_id,bean,request);
		} //added for ML-MMOH-CRF-1089 END
	}
	catch (Exception e) {
		out.println("alert(\"" + e + "\");") ;
		e.printStackTrace();
	}	
%>
