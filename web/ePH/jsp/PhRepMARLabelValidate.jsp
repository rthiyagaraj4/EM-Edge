<%@page  import="java.sql.*, java.util.*, java.io.*, ePH.Common.*, ePH.*" contentType="text/html;charset=UTF-8 " %>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
	hash						= (Hashtable)hash.get( "SEARCH" ) ;
	String bean_id				= (String) hash.get( "bean_id" );
	String bean_name			= (String) hash.get( "bean_name" );
	String from					= hash.get( "from" )==null?"0":(String) hash.get( "from" );

	PhRepMARLabelBean beanObj	= (PhRepMARLabelBean)getBeanObject(bean_id, bean_name, request);
	beanObj.setLanguageId(locale);
	try {
		String facility_id			= (String) hash.get( "facility_id" );
		String disp_locn_code		= (String) hash.get( "disp_locn_code" );
		String validate             = request.getParameter("validate")==null?"":request.getParameter("validate"); 
		if( validate.equals("patientsearch" ) ){
			String patient_id					= (String) hash.get("patient_id");
			ArrayList patientdetails	= beanObj.getPatientDetails(patient_id);
			if(patientdetails.size()==0){
				out.println("chkpatID('N');") ;
			}
			else{
				out.println("chkpatID('Y');") ;
			}
		}
		else if( validate.equals("UPDATESELECTION" ) ){
			String order_id					= (String) hash.get("order_id");
			String order_line_num					= (String) hash.get("order_line_num");
			String select_yn					= (String) hash.get("select_yn");
			String iv_prep_yn					= (String) hash.get("iv_prep_yn");
			String p_report_id = "";
			String key=order_id+"~"+order_line_num;
	
			if(iv_prep_yn.equals(""))
				p_report_id = "PHPRMARLBL";
			else if(iv_prep_yn.equals("3"))
				p_report_id = "PHPRMARINTLBL";
			else if (iv_prep_yn.equals("1"))
				p_report_id = "PHPRMARWALBL";
			else if (iv_prep_yn.equals("5"))
				p_report_id = "PHPRMARWOALBL";
			HashMap hmPrintList	= beanObj.getPrintList();
			if(hmPrintList!=null && select_yn.equals("N")) {
				hmPrintList.remove(key);
			}
			else if(select_yn.equals("Y"))
				hmPrintList.put(key, p_report_id);
			beanObj.setPrintList(hmPrintList);
		}
		else if(validate != null && validate.equals("UPDATESELECTIONALL" ) ){
			String selectAll_yn					= (String) hash.get("selectAll_yn");
			String order_id, order_line_num, key, iv_prep_yn, report_id="";
			ArrayList alOrdersList	= beanObj.getOrdersList();
			HashMap hmPrintList	= beanObj.getPrintList();
			for(int i=1;i<alOrdersList.size();i+=10){
				order_id=(String)alOrdersList.get(i+2);
				order_line_num=(String)alOrdersList.get(i+3);
				iv_prep_yn = (String)alOrdersList.get(i+9);
				key = order_id+"~"+order_line_num;
				if(!iv_prep_yn.equals("") && !order_line_num.equals("1")) //to avaoind duplicate label print when IV orders with fluid & Additives 
					continue;
				if(hmPrintList!=null && selectAll_yn.equals("N")) {
					hmPrintList.remove(key);
				}
				else if(selectAll_yn.equals("Y")){
					if(iv_prep_yn.equals(""))
						report_id = "PHPRMARLBL";
					else if(iv_prep_yn.equals("3"))
						report_id = "PHPRMARINTLBL";
					else if (iv_prep_yn.equals("1"))
						report_id = "PHPRMARWALBL";
					else if (iv_prep_yn.equals("5"))
						report_id = "PHPRMARWOALBL";
					hmPrintList.put(key, report_id);
				}
			}
			beanObj.setPrintList(hmPrintList);
		}		
		else if(validate.equals("PRINTMARLABELCHEK" ) ){
			HashMap hmPrintList	= beanObj.getPrintList();
			if(hmPrintList==null || hmPrintList.size()==0){
				out.println("alert(getMessage('PH_ATLEAST_ONE_SELECTED','PH'));") ;
			}
			else{
				out.println("assignResult('Y') ");
			}
			return ;
		}
		else if(validate.equals("PRINTMARLABEL" ) ){
			HashMap hmPrintList	= beanObj.getPrintList();
			String p_report_id = "",  ReportOutput="", key="", order_id="", order_line_num="" ;
			ecis.utils.OnlineReports onlineReports	= new ecis.utils.OnlineReports() ;
			ecis.utils.OnlineReport report  = null;
			ArrayList keyList = new ArrayList(hmPrintList.keySet());
			String p_user_name		= (String)hash.get("p_user_name");
			String p_facility_id	= (String)hash.get("p_facility_id");
			String p_language_id   =(String)hash.get("p_language_id");
			for(int i=0;i<keyList.size();i++){
				key = (String)keyList.get(i);
				if(key!=null && key.indexOf("~")>-1){
					order_id = key.substring(0, key.indexOf("~"));
					order_line_num = key.substring( key.indexOf("~")+1, key.length());
					p_report_id		= (String)hmPrintList.get(key);
					report		= new ecis.utils.OnlineReport( p_facility_id, "PH",p_report_id) ;
					report.addParameter("p_report_id",p_report_id) ;
					report.addParameter("p_order_id",order_id);
					report.addParameter("p_order_line_num",order_line_num);
					report.addParameter("p_user_name",p_user_name) ;
					report.addParameter("p_facility_id",p_facility_id) ;
					report.addParameter("p_module_id", "PH") ;
					report.addParameter("p_language_id", p_language_id) ;
					onlineReports.add( report) ;
				}
			}
			ReportOutput = onlineReports.execute( request, response );
			beanObj.clear();
		}
		putObjectInBean(bean_id,beanObj,request);
	}
	catch (Exception e) {
		e.printStackTrace();
	}
%>
