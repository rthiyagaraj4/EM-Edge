
 <%@page  import="java.sql.*, java.util.*, java.io.*, ePH.Common.*, eOR.Common.*, ePH.*, eOR.* " contentType="text/html;charset=ISO-8859-1"%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
/*

	dispLocDetails structure
index - value
	0 - LOCN_CODE
	1 - LOCN_DESC
	2 - DB_ACTION
	3 - EffStatus
	4 - ChangedYN
	
	
*/

	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
   // Hashtable hash				= (Hashtable)xmlObj.parseXMLString(request) ;
String bean_id="@StoreForLocationBean";
	String bean_name="ePH.StoreForLocationBean";
   String disp_loc_code1	= request.getParameter( "disp_loc_code" ) ;
   String validate		= request.getParameter("validate");
 //  String facility_id   = (String)session.getValue( "facility_id" );
   	StoreForLocationBean bean			= (StoreForLocationBean)getBeanObject( bean_id, bean_name, request);

 bean.setLanguageId(locale);

if(validate.equals("STORECODE")){

	  ArrayList storeDetails = bean.getStoreDetails(disp_loc_code1);
		
	if(storeDetails.size()!=0)
			{
				
				 String store_desc  = (String)storeDetails.get(1);
			 out.println("assignStoreCode('"+store_desc+"');") ;	 
			}
}else if(validate.equals("X")){

	
	ArrayList		dispLocDetails = new ArrayList(bean.getdispLocDetails());

String disp_loc_code= (String)request.getParameter("disp_type_code")==null?"":(String)request.getParameter("disp_type_code");	


String selected_yn =   (String)request.getParameter("selected")==null?"":(String)request.getParameter("selected");
String temp_disp_type="";
int count=0;
if(!disp_loc_code.equals("")){
		while((dispLocDetails != null) && (count < dispLocDetails.size())){
			temp_disp_type = (String)dispLocDetails.get(count);
			if(disp_loc_code.equals(temp_disp_type)){
				if(selected_yn.equals("Y"))
					 dispLocDetails.set(count+3, "E");
				else
					 dispLocDetails.set(count+3, "D");

				if(dispLocDetails.get(count+4).equals("N"))
					dispLocDetails.set(count+4, "Y");
				else
					dispLocDetails.set(count+4,"N");
			}
			count+=5;

		}
	}else{
		int from =   Integer.parseInt(request.getParameter("from")==null?"0":request.getParameter("from"));
		int to =   Integer.parseInt(request.getParameter("to")==null?"0":request.getParameter("to"));
		count= from *5;
		to = to *5;
		if(to > dispLocDetails.size())
			to = dispLocDetails.size();
		while((dispLocDetails != null) && (count <=to)){
				if(selected_yn.equals("Y"))
					 dispLocDetails.set(count+3, "E");
				else
					 dispLocDetails.set(count+3, "D");

				if(dispLocDetails.get(count+4).equals("N"))
					dispLocDetails.set(count+4, "Y");
				else
					dispLocDetails.set(count+4,"N");
			count+=5;
		}
		
	}
	
	bean.setdispLocDetails(dispLocDetails);

}
	putObjectInBean(bean_id,bean,request);
%>
