<%@page contentType="text/html;charset=UTF-8" import=" eST.SalesHistoryBean,java.util.Hashtable,webbeans.eCommon.XMLStringParser"%> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
	SalesHistoryBean bean = (SalesHistoryBean)getBeanObject( "SalesHistoryBean","eST.SalesHistoryBean", request ) ;  
	String validate		=	request.getParameter("validate");
//	String item_desc	=	request.getParameter("item_desc");
	
	Hashtable htFormValues = (Hashtable) XMLobj.parseXMLString(request);
    htFormValues = (Hashtable) htFormValues.get ("SEARCH");

	String message			=	"";
	String flag				=	"";
//	String facility_id=(String)session.getValue("facility_id");
//	HashMap hashmapDtl=new HashMap();
//	String item_code				=	request.getParameter("item_code");
//	String store_code				=	request.getParameter("store_code");
//	String item_qty					=	request.getParameter("item_qty");
//	String uom_desc					=	request.getParameter("uom_desc");
//	String uom_code					=	request.getParameter("uom_code");
//	String stock_available			=	request.getParameter("stock_available");
//	String remarks					=	request.getParameter("remarks");
	String patient_id				=	request.getParameter("patient_id");

	//String doc_srl_no				=	request.getParameter("doc_srl_no");
//	String item_unit_cost			=	request.getParameter("item_unit_cost");
//	String item_cost_value			=	request.getParameter("item_cost_value");
//	String expiry_yn				=	request.getParameter("expiry_yn");
//	String stock_item_yn			=	request.getParameter("stock_item_yn");
//	String index					=	request.getParameter("index");

	boolean	result					=	false;
	try {
		 if (validate.equals("PATIENT_NAME")){


			if (patient_id.trim().equals("")) {
				out.println("setPatientName('','');");
				result			=	true;
				return ;
			}
			try{
				out.println("setPatientName(\""+bean.getPatientName(patient_id)+"\",\""+bean.getPatientNationality(patient_id)+"\")");

			}
			catch(Exception exception){
				flag			=	"INVALID_PATIENT";
				result			=	false;
				out.println("setPatientName('','');");
			}
		}
		
	}
	catch (Exception exception) {
		result		=	false;
		message		=	exception.getMessage();
		exception.printStackTrace();
	}
	finally{
		//out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
	}
	
%>
<%
//putObjectInBean("SalesHistoryBean",bean,request);
%>
