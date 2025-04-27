<%@page  import="java.sql.*, java.util.*, java.io.*, ePH.Common.*, eOR.Common.*, ePH.*, eOR.* " contentType="text/html;charset=ISO-8859-1"%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
/*
	drugTypeDetails structure
	0 - DrugTYpeCode
	1 - DrugTypeDesc
	2 - DBAction
	3 - EffStatus
	4 - ChangedYN
*/
    Hashtable hash				= (Hashtable)xmlObj.parseXMLString(request) ;
	String bean_id="@DrugDrugTypeBean";
	String bean_name="ePH.DrugDrugTypeBean";
	DrugDrugTypeBean bean			= (DrugDrugTypeBean)getBeanObject( bean_id, bean_name, request);
	ArrayList		drugTypeDetails = new ArrayList(bean.getdrugTypeDetails());
	
	
	String drug_type_code= (String)request.getParameter("drug_type_code")==null?"":(String)request.getParameter("drug_type_code");
//	String selected_yn =   (String)hash.get("selected")==null?"":(String)hash.get("selected");
	String selected_yn =   (String)request.getParameter("selected")==null?"":(String)request.getParameter("selected");


	String temp_drug_type="";
	int count=0;
	//int index=0;
	if(!drug_type_code.equals("")){
		while((drugTypeDetails != null) && (count < drugTypeDetails.size())){
			temp_drug_type = (String)drugTypeDetails.get(count);
			if(drug_type_code.equals(temp_drug_type)){
				if(selected_yn.equals("Y"))
					 drugTypeDetails.set(count+3, "E");
				else
					 drugTypeDetails.set(count+3, "D");

				if(drugTypeDetails.get(count+4).equals("N"))
					drugTypeDetails.set(count+4, "Y");
				else
					drugTypeDetails.set(count+4,"N");
			}
			count+=5;
			//index++;
		}
	}
	else{
		int from =   Integer.parseInt(request.getParameter("from")==null?"0":request.getParameter("from"));
		int to =   Integer.parseInt(request.getParameter("to")==null?"0":request.getParameter("to"));
		count= from * 5;
		to = to *5;
		if(to > drugTypeDetails.size())
			to = drugTypeDetails.size();
		while((drugTypeDetails != null) && (count <=to)){
	//		if(drug_type_code.equals(temp_drug_type)){
				if(selected_yn.equals("Y"))
					 drugTypeDetails.set(count+3, "E");
				else
					 drugTypeDetails.set(count+3, "D");

				if(drugTypeDetails.get(count+4).equals("N"))
					drugTypeDetails.set(count+4, "Y");
				else
					drugTypeDetails.set(count+4,"N");
		//	}
			count+=5;
		}
	}
	bean.setdrugTypeDetails(drugTypeDetails);
%>
