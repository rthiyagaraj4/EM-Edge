 <%@page  import="java.sql.*, java.util.*, java.io.*, ePH.Common.*, eOR.Common.*, ePH.*, eOR.* " contentType="text/html;charset=ISO-8859-1"%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
/*

	locForDetails structure
index - value
	0 - item_code
	1 - item_DESC
	2 - DB_ACTION
	3 - EffStatus
	4 - ChangedYN
	
	
*/

	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
 //   Hashtable hash				= (Hashtable)xmlObj.parseXMLString(request) ;
String bean_id="@LocationStoreItemsBean";
	String bean_name="ePH.LocationStoreItemsBean";
   String disp_loc_code1	= request.getParameter( "disp_loc_code" ) ;
   String validate		= request.getParameter("validate");
 //  String facility_id   = (String)session.getValue( "facility_id" );
   	LocationStoreItemsBean bean			= (LocationStoreItemsBean)getBeanObject( bean_id, bean_name, request);

 bean.setLanguageId(locale);

if(validate.equals("STORECODE")){

	  ArrayList storeDetails = bean.getStoreDetails(disp_loc_code1);
		
	if(storeDetails.size()!=0)
			{
				
				 String store_desc  = (String)storeDetails.get(1);
			 out.println("assignStoreCode('"+store_desc+"');") ;	 
			}
}else if(validate.equals("X")){

	
	ArrayList		locForDetails = new ArrayList(bean.getlocForDetails());
	
String disp_loc_code= (String)request.getParameter("disp_type_code")==null?"":(String)request.getParameter("disp_type_code");	


String selected_yn =   (String)request.getParameter("selected")==null?"":(String)request.getParameter("selected");
String temp_disp_type="";
int count=0;
if(!disp_loc_code.equals("")){


		while((locForDetails != null) && (count < locForDetails.size())){
			temp_disp_type = (String)locForDetails.get(count);
			if(disp_loc_code.equals(temp_disp_type)){
				if(selected_yn.equals("Y"))
					 locForDetails.set(count+3, "E");
				else
					 locForDetails.set(count+3, "D");

				if(locForDetails.get(count+4).equals("N"))
					locForDetails.set(count+4, "Y");
				else
					locForDetails.set(count+4,"N");
			}
			count+=5;

		}
	}else{
		int from =   Integer.parseInt(request.getParameter("from")==null?"0":request.getParameter("from"));
		int to =   Integer.parseInt(request.getParameter("to")==null?"0":request.getParameter("to"));
		count= from *5;
		to = to *5;
		if(to > locForDetails.size())
			to = locForDetails.size();
		while((locForDetails != null) && (count <=to)){
				if(selected_yn.equals("Y"))
					 locForDetails.set(count+3, "E");
				else
					 locForDetails.set(count+3, "D");

				if(locForDetails.get(count+4).equals("N"))
					locForDetails.set(count+4, "Y");
				else
					locForDetails.set(count+4,"N");
			count+=5;
		}
		
	}
	
	bean.setlocForDetails(locForDetails);

}
	putObjectInBean(bean_id,bean,request);
%>
