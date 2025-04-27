<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.*, eSS.Common.*, eSS.* "%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	String bean_id = "changeBinLocationForTrayBean";
	String bean_name = "eSS.ChangeBinLocationForTrayBean";
	int functionType = Integer.parseInt(request.getParameter("function_type"));
	
	ChangeBinLocationForTrayBean bean = (ChangeBinLocationForTrayBean) getBeanObject(bean_id , bean_name, request);
	Hashtable hash = (Hashtable) XMLobj.parseXMLString(request);
    hash = (Hashtable) hash.get ("SEARCH");
	switch (functionType) {
	case 1:
		{
				String owner_store_code = (String) hash.get("owner_store_code");
				if (owner_store_code.trim().equals("")) {
					out.println("errorDisplay();");
					return;
				}
				bean.setOwner_store_code(owner_store_code);
				out.println("clearListItems('formChangeBinLocationForTrayQueryCriteria.bin_location_code'); ");
				out.println("clearListItems('formChangeBinLocationForTrayQueryCriteria.new_bin_location_code'); ");
				ArrayList alparams	= new ArrayList();
				alparams.add(owner_store_code);
				alparams.add(bean.getLanguageId());
				
				ArrayList alRecords	=	bean.fetchRecords(bean.getSsRepositoryValue("SQL_MM_BIN_LOCATION_SELECT_LIST"),alparams);

				for (int i=0; i<alRecords.size(); i++){
					HashMap hmRecord	=	(HashMap)alRecords.get(i);
					out.println(  "addListItem(\"formChangeBinLocationForTrayQueryCriteria.bin_location_code\",\""+hmRecord.get("BIN_LOCATION_CODE")+"\",\""+hmRecord.get("SHORT_DESC")+"\");"  );
					out.println(  "addListItem(\"formChangeBinLocationForTrayQueryCriteria.new_bin_location_code\",\""+hmRecord.get("BIN_LOCATION_CODE")+"\",\""+hmRecord.get("SHORT_DESC")+"\");"  );
					}
				
		}
		break;
	
	case 2:
		{
		String owner_store_code				= request.getParameter("owner_store_code");
		String bin_location_code			= request.getParameter("bin_location_code" );
		String tray_no						= request.getParameter( "tray_no");
		String group_code					= request.getParameter("group_code");
		String new_bin_location_code		= request.getParameter("new_bin_location_code");
		String new_bin_location_desc		= request.getParameter("new_bin_location_desc");
		String doc_type_code				= request.getParameter("doc_type_code");
		String doc_no						= request.getParameter("doc_no");
		String locale						= request.getParameter("locale");
		owner_store_code					= CommonBean.checkForNull(owner_store_code,"%");
		//bean.setOwner_store_code(owner_store_code);
		bin_location_code					= CommonBean.checkForNull(bin_location_code,"%");
		bean.setNew_bin_location_code(new_bin_location_code);
		bean.setNew_bin_location_desc(new_bin_location_desc);
		group_code							=	CommonBean.checkForNull(group_code,"%");
		//bean.setGroup_code(group_code);
		tray_no								= CommonBean.checkForNull(tray_no,"%");
		doc_type_code						= CommonBean.checkForNull(doc_type_code,"%");
		doc_no								= CommonBean.checkForNull(doc_no,"%");

		bean.loadResultPage(new_bin_location_code,new_bin_location_desc,owner_store_code,bin_location_code,group_code,tray_no,doc_type_code,doc_no,locale);
		
		}
		break;

	case 3:
		{
			String index				=	request.getParameter("index");
			String new_bin_location_code			=	request.getParameter("new_bin_location_code");
			String new_bin_location_code_desc			=	request.getParameter("new_bin_location_code_desc");

			ArrayList result=(ArrayList)bean.getResultList();
			HashMap hmListItems	=	(HashMap)result.get(Integer.parseInt(index));
					out.println(hmListItems);
					hmListItems.put("NEW_BIN_LOCATION",		new_bin_location_code);
					hmListItems.put("NEW_BIN_LOCATION_DESC",		new_bin_location_code_desc);
					result.set(Integer.parseInt(index),hmListItems);
			
					out.println(result);
		}
	break;

	default :
		out.println("alert(\'Invalid Function\');");
		return;
	}
	putObjectInBean(bean_id,bean,request);
%>
