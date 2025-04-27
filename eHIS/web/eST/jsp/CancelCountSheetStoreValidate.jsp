<%@page import=" eST.*,eST.Common.*,java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 

<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
			request.setCharacterEncoding("UTF-8");
			String locale			= (String)session.getAttribute("LOCALE");
			
		//String bean_id = "CancelCountSheetBean";
		//String bean_name = "eST.CancelCountSheetBean";
	CancelCountSheetBean bean = (CancelCountSheetBean)getBeanObject( "CancelCountSheetBean","eST.CancelCountSheetBean",request ) ;  
	bean.setLanguageId(locale);
	//String validate		=	request.getParameter("validate");

	
	Hashtable htFormValues = (Hashtable) XMLobj.parseXMLString(request);
    htFormValues = (Hashtable) htFormValues.get ("SEARCH");
	//String message			=	"";
	//String flag				=	"";
	//String facility_id=(String)session.getValue("facility_id");
	//HashMap hashmapDtl=new HashMap();
	String phy_inv_id				=	request.getParameter("phy_id");
//  String val = request.getParameter("validate");
//	String rec =request.getParameter("rec");	
//	boolean	result					=	false;
	try {
				out.println("clearListItems('document.formCancelCountSheetQueryCriteria.store_code'); ");
			 	ArrayList alEncounterList = bean.getArrayList(phy_inv_id);
				HashMap record	= new HashMap();
				for(int i=0; i< alEncounterList.size(); i++) 
					{
					record	=	(HashMap)alEncounterList.get(i);
					String listRecord1	=	(String)record.get("store_code");
					bean.setStore_code(listRecord1);
					String listRecord2	=	(String)record.get("short_desc");
					out.println("addListItem(\"document.formCancelCountSheetQueryCriteria.store_code\", \"" +listRecord1+ "\",\"" +listRecord2+ "\",\"" +listRecord1+"\") ; ");
					}
	}catch (Exception exception) {
		//result		=	false;
	//	message		=	exception.getMessage();
		exception.printStackTrace();
	}
	finally{
	}
%>
<%
putObjectInBean("CancelCountSheetBean",bean,request);
%>
