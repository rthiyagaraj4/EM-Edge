 <%@page import="java.util.*, ePH.Common.*, ePH.* " contentType="text/html;charset=UTF-8"%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	request.setCharacterEncoding("UTF-8");	
	String locale			= (String)session.getAttribute("LOCALE");
	


	String bean_id	= request.getParameter( "bean_id" ) ;
	String bean_name= request.getParameter( "bean_name" ) ;
	String ordering_source_type	= (request.getParameter( "ordering_source_type" )==null?"":request.getParameter( "ordering_source_type" ));
	String disp_locn_type = request.getParameter("disp_locn_type");
	String routing_level = request.getParameter( "routing_level" );
	String facility_id	=	request.getParameter("facility_id");
	String routing_code =   request.getParameter("routing_code");
	String identity		=	request.getParameter("identity");
	String modifyMode = request.getParameter("modifyMode");
	Hashtable hash		= (Hashtable)XMLobj.parseXMLString( request ) ;
	hash				= (Hashtable)hash.get( "SEARCH" ) ;
	OrderRoutingBean bean = (OrderRoutingBean)getBeanObject( bean_id,  bean_name , request) ;
	bean.setLanguageId(locale);
	bean.clear();

	if (modifyMode==null){
		modifyMode = "";
	}
	if(identity==null){
		identity = "";
	}

	if(identity.equals("S")){
		ArrayList all = bean.getDefaultDispLocDataForSource(facility_id.trim(),ordering_source_type); //shyampriya
		for (int i=0;i<all.size();i++){
			out.println("addRoutineStatList('"+all.get(i)+"','"+all.get(++i)+"')");
		}
		ArrayList allD = bean.getDefaultDispLocDataForSourceD(facility_id.trim()); //shyampriya
		for (int i=0;i<allD.size();i++){
			out.println("addDischargeList('"+allD.get(i)+"','"+allD.get(++i)+"')");
		}
		return;
	}

	if (!modifyMode.equals("Yes")){
		if (ordering_source_type != null){
			ArrayList arrList = bean.loadRelatedLocation(facility_id,ordering_source_type);
			for (int i=0;i<arrList.size();i++){
				//out.println("loadIntoLocation('"+(String)arrList.get(i)+"','"+(String)arrList.get(++i)+"')");
				 String QryMode=request.getParameter("QryMode");
				if(QryMode!=null){
					out.println( "loadIntoLocationQry(\"" +(String)arrList.get(i)+ "\",\"" +(String)arrList.get(++i)+ "\") ; " ) ;
			    }else{
             	out.println( "loadIntoLocation(\"" +(String)arrList.get(i)+ "\",\"" +(String)arrList.get(++i)+ "\") ; " ) ;
				}
			}
		}
		if(routing_code != null){
			if(routing_code.equals("ALLA") || routing_code.equals("CMPA") || routing_code.equals("IVOA") || routing_code.equals("ONCA") || routing_code.equals("TPNA")){
				bean.setDispLocnForAdmixtures("Y");
			}else{
				bean.setDispLocnForAdmixtures("N");
			}
		}
		if (routing_code ==null && identity.equals(""))	{
			if ((routing_level != null)){
				ArrayList all = bean.getDataForList();
				ArrayList routingCode = (ArrayList)all.get(2);
				for (int i=0;i<routingCode.size();i++){
					out.println("addDataToRoutingCode('"+routingCode.get(i)+"','"+routingCode.get(++i)+"','"+routingCode.get(++i)+"')");
				}
			}
		}else if ((routing_code != null)&&(!routing_level.equals("G"))){

			ArrayList all = bean.getDataForDefaultDispenseLocation(facility_id.trim(),disp_locn_type.trim(),routing_code.trim(),routing_level.trim());
			for (int i=0;i<all.size();i++){
				out.println("addRoutineStatList('"+all.get(i)+"','"+all.get(++i)+"')");
			}
			ArrayList allD = bean.getDataForDefaultDispenseLocationD(facility_id.trim(),disp_locn_type.trim(),routing_code.trim(),routing_level.trim());
			for (int i=0;i<allD.size();i++){
				out.println("addDischargeList('"+allD.get(i)+"','"+allD.get(++i)+"')");
			}
		}else if ((routing_code != null)&&(routing_level.equals("G"))){
			ArrayList all = bean.getDefaultDispLocDataForDrug(facility_id.trim(),disp_locn_type.trim(),routing_code.trim());
			for (int i=0;i<all.size();i++){
				out.println("addRoutineStatList('"+all.get(i)+"','"+all.get(++i)+"')");
			}
			ArrayList allD = bean.getDefaultDispLocDataForDrugD(facility_id.trim(),disp_locn_type.trim(),routing_code.trim());
			for (int i=0;i<allD.size();i++){
				out.println("addDischargeList('"+allD.get(i)+"','"+allD.get(++i)+"')");
			}
		}
	}
	if (modifyMode.equals("Yes")){
		ArrayList all = bean.getDataForDefaultDispenseLocation(facility_id.trim(),disp_locn_type.trim(),routing_code.trim(),routing_level.trim());
		out.println(all.size());
		for (int i=0;i<all.size();i++){
			out.println("addRoutineStatListInModify('"+all.get(i)+"','"+all.get(++i)+"')");
		}

		ArrayList allD = bean.getDataForDefaultDispenseLocationD(facility_id.trim(),disp_locn_type.trim(),routing_code.trim(),routing_level.trim());
		out.println(allD.size());
		for (int i=0;i<allD.size();i++){
			out.println("addDischargeListInModify('"+allD.get(i)+"','"+allD.get(++i)+"')");
		}
	}
%>

<%
putObjectInBean(bean_id,bean,request);
%>
