
<%@page contentType="text/html;charset=ISO-8859-1" import=" eST.*,eST.Common.*,java.util.*,java.sql.*,webbeans.eCommon.*"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
		//String bean_id = "ReprintCountSheetBean";
		//String bean_name = "eST.ReprintCountSheetBean";
	ReprintCountSheetBean bean = (ReprintCountSheetBean)getBeanObject( "ReprintCountSheetBean", "eST.ReprintCountSheetBean",request ) ;  
//	String validate		=	request.getParameter("validate");

	
	Hashtable htFormValues = (Hashtable) XMLobj.parseXMLString(request);
    htFormValues = (Hashtable) htFormValues.get ("SEARCH");

	String message			=	"";
//	String flag				=	"";
	String facility_id=(String)session.getValue("facility_id");
	//HashMap hashmapDtl=new HashMap();
	String phy_inv_id				=	request.getParameter("phy_id");
	//String val = request.getParameter("validate");
	//String rec =request.getParameter("rec");	
	
	boolean	result					=	false;
	try {
		 
		
				ArrayList	arraylist		=	null;
				HashMap		hmItemCode		=	null;	
				String datecode = "";
				String dateval = "";
				arraylist		=	bean.getDateValues(phy_inv_id,facility_id);
				int arrLength		=	arraylist.size();
					for(int i=0;i<arrLength; i++)
					{
						hmItemCode      	=	(HashMap) arraylist.get(i);
						
						datecode			=	(String)hmItemCode.get("count_sheet_date");
						dateval				= (String)hmItemCode.get("phy_inv_proc_mode");	
					}
					out.println("setDateValue(\""+datecode+","+dateval+"\");");
	}catch (Exception exception) {
		result		=	false;
		message		=	exception.getMessage();
		out.println("setDateValue('');");
		exception.printStackTrace();
	}
	finally{
		//out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
	}
%>
<%
putObjectInBean("ReprintCountSheetBean",bean,request);
%>
