
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.*, eSS.Common.*, eSS.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	request.setCharacterEncoding("UTF-8");
	String bean_id						=		request.getParameter("bean_id");
	String bean_name					=		request.getParameter("bean_name");
	int functionType					=		Integer.parseInt(request.getParameter("function_type"));

	if ((bean_id == null) || (bean_id.equals("")))
		return;

   	AutoclaveWashingUnitTestBean bean	=		 (AutoclaveWashingUnitTestBean) getBeanObject(bean_id , bean_name, request);
	Hashtable hash						=		(Hashtable) XMLobj.parseXMLString(request);
    hash								=		(Hashtable) hash.get ("SEARCH");
	

	switch (functionType) {
	case 1:
		{
                String unit_type		=		"" ; 
				unit_type				=		(String) hash.get("unit_type");
				
				if (unit_type.trim().equals("")) {
					out.println("errorDisplay();");
					return;
				}

				bean.setUnit_type(unit_type);
			out.println("clearListItems('parent.frameAutoclaveWashingUnitTestHeader.document.formAutoclaveWashingUnitTestHeader.autoclave_wash_unit_code'); ");
				out.println("clearListItems('parent.frameAutoclaveWashingUnitTestDetail.formAutoclaveWashingUnitTestDetail.test_code'); ");

		        ArrayList alParameters	=	new ArrayList(3);
				alParameters.add(unit_type);
				alParameters.add(bean.getLanguageId());
				alParameters.add(bean.getLoginFacilityId()); //Added by Rabbani #Bru-HIMS-CRF-390(42494) on 17-apr-2014

			
				ArrayList alRecords		=	bean.fetchRecords(bean.getSsRepositoryValue("SQL_SS_WASHING_UNIT_SELECT_LIST"),alParameters);
				
				for (int i=0; i<alRecords.size(); i++)
				{
					HashMap hmRecord	=	(HashMap)alRecords.get(i);
					out.println(  "addListItem(\"parent.frameAutoclaveWashingUnitTestHeader.document.formAutoclaveWashingUnitTestHeader.autoclave_wash_unit_code\",\""+hmRecord.get("AUTOCLAVE_WASH_UNIT_CODE")+"\",\""+hmRecord.get("SHORT_DESC")+"\");"  );
				}
				

				ArrayList alParameters1	=	new ArrayList(3);
				alParameters1.add(unit_type);
				alParameters1.add(bean.getLanguageId());
				alParameters1.add(bean.getLoginFacilityId());//Added by Rabbani #Bru-HIMS-CRF-390(42494) on 17-apr-2014
				
				ArrayList alRecords1	=	bean.fetchRecords(bean.getSsRepositoryValue("SQL_SS_WASHING_TEST_SELECT_LIST"),alParameters1);

				for (int i=0; i<alRecords1.size(); i++)
				{
					HashMap hmRecord1	=	(HashMap)alRecords1.get(i);
					out.println(  "addListItem(\"parent.frameAutoclaveWashingUnitTestDetail.document.formAutoclaveWashingUnitTestDetail.test_code\",\""+hmRecord1.get("TEST_CODE")+"\",\""+hmRecord1.get("SHORT_DESC")+"\");"  );
				}


				break;
		}
		case 2: //Added by Pankaj on 12/08/03 
			{
                String unit_type		=		 "" ; 
			    unit_type				=		(String) hash.get("unit_type");
				

				if (unit_type.trim().equals("")) {
					out.println("errorDisplay();");
					return;
				}

				bean.setUnit_type(unit_type);
				out.println("clearListItems('formAutoclaveWashingUnitTestQueryCriteria.autoclave_wash_unit_code'); ");
				
				ArrayList alParameters	=	new ArrayList(3);
				
				alParameters.add(unit_type);
				alParameters.add(bean.getLanguageId());
				alParameters.add(bean.getLoginFacilityId()); //Added by Rabbani #Bru-HIMS-CRF-390(42494) on 17-apr-2014
				
				ArrayList alRecords1	=	bean.fetchRecords(bean.getSsRepositoryValue("SQL_SS_WASHING_UNIT_TEST_SELECT_LIST"),alParameters);
				for (int i=0; i<alRecords1.size(); i++)
				{
					HashMap hmRecord1	=	(HashMap)alRecords1.get(i);
					out.println(  "addListItem(\"parent.frameAutoclaveWashingUnitTestQueryCriteria.document.formAutoclaveWashingUnitTestQueryCriteria.autoclave_wash_unit_code\",\""+hmRecord1.get("AUTOCLAVE_WASH_UNIT_CODE")+"\",\""+hmRecord1.get("SHORT_DESC")+"\");"  );
				}
		break;
		}
		
		case 3:
		{
                String unit_type		=		"A" ; 
				bean.setUnit_type(unit_type);
			out.println("clearListItems('parent.frameAutoclaveWashingUnitTestHeader.document.formAutoclaveWashingUnitTestHeader.autoclave_wash_unit_code'); ");
				out.println("clearListItems('parent.frameAutoclaveWashingUnitTestDetail.formAutoclaveWashingUnitTestDetail.test_code'); ");

		        ArrayList alParameters	=	new ArrayList(3);
				alParameters.add(unit_type);
				alParameters.add(bean.getLanguageId());
				alParameters.add(bean.getLoginFacilityId()); //Added by Rabbani #Bru-HIMS-CRF-390(42494) on 17-apr-2014

			
				ArrayList alRecords		=	bean.fetchRecords(bean.getSsRepositoryValue("SQL_SS_WASHING_UNIT_SELECT_LIST"),alParameters);
				
				for (int i=0; i<alRecords.size(); i++)
				{
					HashMap hmRecord	=	(HashMap)alRecords.get(i);
					out.println(  "addListItem(\"parent.frameAutoclaveWashingUnitTestHeader.document.formAutoclaveWashingUnitTestHeader.autoclave_wash_unit_code\",\""+hmRecord.get("AUTOCLAVE_WASH_UNIT_CODE")+"\",\""+hmRecord.get("SHORT_DESC")+"\");"  );
				}
				
				
				ArrayList alParameters1	=	new ArrayList(3);
				alParameters1.add(unit_type);
				alParameters1.add(bean.getLanguageId());
				alParameters1.add(bean.getLoginFacilityId()); //Added by Rabbani #Bru-HIMS-CRF-390(42494) on 17-apr-2014
				ArrayList alRecords1	=	bean.fetchRecords(bean.getSsRepositoryValue("SQL_SS_WASHING_TEST_SELECT_LIST"),alParameters1);

				for (int i=0; i<alRecords1.size(); i++)
				{
					HashMap hmRecord1	=	(HashMap)alRecords1.get(i);
					out.println(  "addListItem(\"parent.frameAutoclaveWashingUnitTestDetail.document.formAutoclaveWashingUnitTestDetail.test_code\",\""+hmRecord1.get("TEST_CODE")+"\",\""+hmRecord1.get("SHORT_DESC")+"\");"  );
				}


				break;
		}	
		default :
		out.println("alert(\'Invalid Function\');");
		return;
	}
	putObjectInBean(bean_id,bean,request);

%>
