
<%@page  import=" eST.ItemLabelBean,java.util.ArrayList,java.util.HashMap"
contentType="text/html;charset=UTF-8"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
	ItemLabelBean bean = (ItemLabelBean)getBeanObject( "ItemLabelBean","eST.ItemLabelBean", request ) ;  
	bean.setLanguageId(locale);
	String validate		=	request.getParameter("validate");
	//String item_desc	=	request.getParameter("item_desc");
	
	Hashtable htFormValues = (Hashtable) XMLobj.parseXMLString(request);
    htFormValues = (Hashtable) htFormValues.get ("SEARCH");
	String message			=	"";
	String flag				=	"";
	boolean	result					=	false;
	try {
		if (validate.equals("RUN_REPORT")) {
			try{
				flag="";
				result			=	true;			String p_doc_type_code	=	(String)htFormValues.get("p_doc_type_code");
				String p_doc_no			=	(String)htFormValues.get("p_doc_no");
				String p_language_id	=	(String)htFormValues.get("p_language_id");
				String p_report_id		=	(String)htFormValues.get("p_report_id");
				String p_user_name		=	(String)htFormValues.get("p_user_name");
				String p_facility_id	=	(String)htFormValues.get("p_facility_id");
				int count=Integer.parseInt((String)	bean.fetchRecord("SELECT COUNT(*) COUNT FROM ST_GRN_DTL WHERE DOC_NO = ?",p_doc_no).get("COUNT"));
				ArrayList alResult = new ArrayList();
				alResult = bean.fetchRecords("SELECT ITEM_CODE,LABEL_REQD_YN, NO_OF_LABELS FROM ST_GRN_DTL WHERE DOC_NO = ?",p_doc_no);
				HashMap hmTemp = new HashMap();
				String ReportOutput	= "";
			
				ecis.utils.OnlineReports onlineReports		= new ecis.utils.OnlineReports() ;
				ecis.utils.OnlineReport report				=	null;
				for(int i=0;i<count;i++){
					hmTemp = (HashMap)alResult.get(i);
					if(((String)hmTemp.get("LABEL_REQD_YN")).equals("Y")){
						for(int j=0;j<Integer.parseInt((String)hmTemp.get("NO_OF_LABELS"));j++){
							//bean.doOnlineReportPrintingOfLabel(pdocno,(String)hmTemp.get("ITEM_CODE"),doc_type_code);
							report				= new ecis.utils.OnlineReport( p_facility_id, "ST",p_report_id) ;
							report.addParameter("p_report_id",p_report_id) ;
							report.addParameter("p_doc_no",p_doc_no);
							report.addParameter("p_doc_type_code", p_doc_type_code) ;
							report.addParameter("p_user_name",p_user_name) ;
							report.addParameter("p_facility_id",p_facility_id) ;
							report.addParameter("p_fm_item_code", (String)hmTemp.get("ITEM_CODE")) ;
							report.addParameter("p_to_item_code",(String)hmTemp.get("ITEM_CODE"));
							report.addParameter("p_module_id", "ST") ;
							report.addParameter("p_language_id", p_language_id) ;

						onlineReports.add( report) ;							
						}
					}
				}
				ReportOutput = onlineReports.execute( request, response );
				onlineReports =null;
				//bean.doOnlineReportPrintingOfLabel(pdocno);
				//bean.doOnlineReportPrinting(pdocno);	
			}catch(Exception e){
				e.printStackTrace();
				result = false;
			}
		}
	}
	catch (Exception exception) {
		result		=	false;
		message		=	exception.getMessage();
	}
	finally{
		out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
	}
%>
<%
putObjectInBean("ItemLabelBean",bean,request);
%>
