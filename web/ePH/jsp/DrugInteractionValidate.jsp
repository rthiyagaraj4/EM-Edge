<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History	Name				Rev.Date	Rev.Name			Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
05/11/2019	IN070606		Ramesh Goli											MMS-KH-CRF-0029							
23/08/2020	IN073641		Manickavasagam			MMS-KH-CRF-0034 
------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.util.*, ePH.Common.*, ePH.*,eCommon.XSSRequestWrapper " contentType="text/html;charset=UTF-8" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	

	String locale			= (String)session.getAttribute("LOCALE");
%>
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
try{
	String func_mode			    =		request.getParameter( "func_mode" )==null?"":request.getParameter( "func_mode" ) ;
	Hashtable hash = ( Hashtable )XMLobj.parseXMLString( request ) ;
    hash = ( Hashtable )hash.get( "SEARCH" ) ;
	String bean_id				=		(String)hash.get( "bean_id" ) ==null?"":(String)hash.get( "bean_id" ) ;
	String bean_name		    =		(String)hash.get( "bean_name" ) ==null?"":(String)hash.get( "bean_name" ) ;
	DrugInteractionBean bean = (DrugInteractionBean)getBeanObject( bean_id,bean_name,request) ;
	String intr_option,intr_name1,intr_name2,intr_code1,intr_code2, severity_level, significant_level, probability, interaction_desc, restrict_transaction, form_code1, form_code2, form_desc1, form_desc2,term_set_code;//term_set_code added for MMS-DM-CRF-0229
	String intr_Type=""; //IN070606
	if ( func_mode.equals( "checkForDuplicate" ) ){
		ArrayList DrugInteractionDtl=new ArrayList();
		HashMap hmDrugIntList=null;
		intr_option = (String)hash.get("intr_option");
		intr_code1 = (String)hash.get("intr_code1");
		intr_code2 =(String)hash.get("intr_code2"); 
		intr_name1 = (String)hash.get("intr_name1");
		intr_name2 = (String)hash.get("intr_name2"); 
		form_code1 = (String)hash.get("form_code1"); 
		form_code2 = (String)hash.get("form_code2"); 
		intr_Type	= (String)hash.get("intr_type");
		boolean dupFound = bean.checkForDuplicate( intr_option,  intr_code1,  intr_code2, form_code1, form_code2, intr_Type);  //intr_Type add for IN070606
		if(dupFound){
			out.println("alert(getMessage('CODE_ALREADY_EXISTS','Common'));");
		}
		else{
			String key = intr_option+"_"+intr_code1+"_"+form_code1+"_"+intr_code2+"_"+form_code2;
			String key2 = intr_option+"_"+intr_code2+"_"+form_code2+"_"+intr_code1+"_"+form_code1;
			hmDrugIntList = bean.getDrugIntrList();
			if(hmDrugIntList.containsKey(key) || hmDrugIntList.containsKey(key2)){
				out.println("confirm(getMessage('PH_INTERACTION_ALREADY_ADDED','PH'))");
			}
			else
				out.println("AddRecord()");
		}
	}
	else if ( func_mode.equals( "AddRecord" ) ){
		ArrayList DrugInteractionDtl=new ArrayList();
		String lab_ord_check_for_upto = ""; //MMS-KH-CRF-0034
 		HashMap hmDrugIntList=null;
		intr_Type	= (String)hash.get("intr_Type"); //IN070606
		intr_option = (String)hash.get("intr_option");
		intr_code1 = (String)hash.get("intr_code1");
		intr_code2 =(String)hash.get("intr_code2"); 
		intr_name1 = (String)hash.get("intr_name1");
		intr_name2 = (String)hash.get("intr_name2"); 
		severity_level = (String)hash.get("severity_level");
		significant_level = (String)hash.get("significant_level");
		probability = (String)hash.get("probability");
		restrict_transaction = (String)hash.get("restrict_transaction");
		interaction_desc = (String)hash.get("interaction_desc");
		form_code1 = (String)hash.get("form_code1"); 
		form_code2 = (String)hash.get("form_code2"); 
		form_desc1 = (String)hash.get("form_desc1"); 
		form_desc2 = (String)hash.get("form_desc2"); 
		lab_ord_check_for_upto = (String)hash.get("lab_ord_check_for_upto");  //MMS-KH-CRF-0034
		term_set_code = (String)hash.get("term_set_code");
		DrugInteractionDtl.add(intr_option); //0
		DrugInteractionDtl.add(intr_code1); //1
		DrugInteractionDtl.add(intr_code2);
		DrugInteractionDtl.add(java.net.URLDecoder.decode(intr_name1,"UTF-8"));
		DrugInteractionDtl.add(java.net.URLDecoder.decode(intr_name2,"UTF-8")); //4
		DrugInteractionDtl.add(severity_level); //5
		DrugInteractionDtl.add(significant_level); //6
		DrugInteractionDtl.add(probability);
		DrugInteractionDtl.add(restrict_transaction);
		DrugInteractionDtl.add(java.net.URLDecoder.decode(interaction_desc,"UTF-8")); //9
		DrugInteractionDtl.add("E"); //10
		DrugInteractionDtl.add(form_code1); //11
		DrugInteractionDtl.add(form_code2);
		DrugInteractionDtl.add(java.net.URLDecoder.decode(form_desc1,"UTF-8"));
		DrugInteractionDtl.add(java.net.URLDecoder.decode(form_desc2,"UTF-8")); //14
		DrugInteractionDtl.add(intr_Type); //15 //IN070606
		DrugInteractionDtl.add(lab_ord_check_for_upto);// 16 MMS-KH-CRF-0034
		DrugInteractionDtl.add(term_set_code);// 17 MMS-KH-CRF-0034
		hmDrugIntList = bean.getDrugIntrList();
		hmDrugIntList.put(intr_option+"_"+intr_code1+"_"+form_code1+"_"+intr_code2+"_"+form_code2,DrugInteractionDtl);
		out.println("LoadDrugIntrList();");	
	}
	else if ( func_mode.equals( "loadDosageForm" ) ){
		intr_option = (String)hash.get("intr_option");
		String intrCode = (String)hash.get("intrCode");
		String objNum = (String)hash.get("objNum");
		ArrayList dosageFormList =bean.getDosageForms(intr_option, intrCode);
		String dosageForm[] = null;
		out.println("clearDosageForm('"+ objNum+ "');");
		for (int i = 0; i < dosageFormList.size(); i++) {
			dosageForm =(String[]) dosageFormList.get(i);
			dosageForm[1]=dosageForm[1].replaceAll(" ","%20");
			dosageForm[1] = java.net.URLEncoder.encode(dosageForm[1],"UTF-8");
			dosageForm[1]=dosageForm[1].replaceAll("%2520","%20");
			out.println("addDosageForm('"+dosageForm[0]+ "','"+ dosageForm[1] + "','"+objNum+"');");
		}
	}
	putObjectInBean(bean_id,bean,request);
}
catch(Exception e){
	e.printStackTrace();
}
%>
