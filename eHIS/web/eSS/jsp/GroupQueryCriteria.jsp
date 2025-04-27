<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
  
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
04/07/2021		TFS19249		 Shazana		ML-MMOH-CRF-1661-US001
---------------------------------------------------------------------------------------------------------------
*/ %>
<%@ page import ="java.util.ArrayList,eSS.*,java.util.*,java.util.HashMap,java.util.ArrayList,java.lang.*,webbeans.eCommon.*,java.sql.*, eCommon.Common.*" %>
<%
 String locale			= (String)session.getAttribute("LOCALE");
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
     <head>
	 		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	 </head>
<%
	Connection con			= null;//MMOH-CRF-1661 START
	boolean linen_applicable_yn = false ; 
	try {
		con				= ConnectionManager.getConnection(request);
		linen_applicable_yn = eCommon.Common.CommonBean.isSiteSpecific(con,"SS", "SS_GROUP_TYPE_LINEN"); //END 
		ecis.utils.CommonQueryPage queryPage = new ecis.utils.CommonQueryPage();
		StringBuffer htmlTag = new StringBuffer();
		String function_id = request.getParameter( "function_id" );
		String grp_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.GroupCode.label","ss_labels");
		String grp_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.GroupDescription.label","ss_labels");
		String grp_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.GroupType.label","ss_labels");
		String surg_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.SurgeryType.label","ss_labels");
		String usg_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.UsageType.label","ss_labels");
		String non_return=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.Non-returnable.label","ss_labels");
		String Nature = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
		String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
	    String Enabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
	    String Disabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
       
		String All_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
		String Set_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.Set.label","ss_labels");
		String Tray_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.Tray.label","ss_labels");
		String SPack_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.SoftPack.label","ss_labels");
		String Single_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.single.label","common_labels");
		String Linen_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.Linen.label","ss_labels"); //mmoh-crf-1661  
		String Yes_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");
		String No_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");
		String Nature_List="%,"+Both_legend+",E,"+Enabled_legend+",D,"+Disabled_legend;
		String grp_type_list = "";//MMOH-CRF-1661 
		if(linen_applicable_yn){  
			 grp_type_list="%,"+All_legend+",E,"+Set_legend+",T,"+Tray_legend+",P,"+SPack_legend+",S,"+Single_legend+",L,"+Linen_legend; 
		}else{
			 grp_type_list="%,"+All_legend+",E,"+Set_legend+",T,"+Tray_legend+",P,"+SPack_legend+",S,"+Single_legend;	
		}//end 
		 
		String Non_return_list="%,"+Both_legend+",Y,"+Yes_legend+",N,"+No_legend;
		ArrayList components = new ArrayList();
		ArrayList items = new ArrayList();

		items.add("Text");
		items.add(grp_code);
		items.add("group_code");
		items.add("10");
		items.add("10");
		components.add(items);

		items=new ArrayList();
		items.add("Text");
		items.add(grp_desc);
		items.add("long_desc");
		items.add("40");
		items.add("40");
		components.add(items);

		items=new ArrayList();
		items.add("List");
		items.add(grp_type);
		items.add("group_type");
		items.add(grp_type_list);
		items.add("1");
		items.add("1");	
		components.add(items);

		items=new ArrayList();
		items.add("List");		 //Type of item
		items.add(surg_type);	// label
		items.add("surgery_type");   //name of field
		items.add(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_SURGERY_TYPE_SELECT_LIST"));
		ArrayList alParameter	=	new ArrayList(1);
		alParameter.add(locale);
		items.add(alParameter);
		components .add(items);

		items=new ArrayList();
		items.add("List");		 //Type of item
		items.add(usg_type);	// label
		items.add("usage_type");   //name of field
		items.add(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_USAGE_TYPE_SELECT_LIST"));
		ArrayList alParameter1=	new ArrayList(1);
		alParameter1.add(locale);
		items.add(alParameter1);
		components .add(items);
		
		items=new ArrayList();
		items.add("List");
		items.add(non_return);
		items.add("non_returnable_yn");
		items.add(Non_return_list);
		items.add("1");
		items.add("1");	
		components.add(items);

		items=new ArrayList();
		items.add("List");
		items.add(Nature);
		items.add("eff_status");
		items.add(Nature_List);
		items.add("1");
		items.add("1");	
		components.add(items);

		items=new ArrayList();
		items.add("Hidden");
		items.add("function_id");
		items.add(function_id);
		components.add(items);

		String[] headers = new String[2];
		headers[0] = grp_code;
		headers[1] = grp_desc;

		String[] values = new String[2];
		values[0]="group_code";
		values[1]="long_desc";

		String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
		String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
		String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
		String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
		String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
		String grop=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Group.label","common_labels");

		htmlTag = queryPage.getQueryPage((( java.util.Properties ) session.getValue("jdbc")),components,grop ,"../../eSS/jsp/GroupQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,headers, values,ExecuteQuery,true);
		out.println(htmlTag);
	}
	catch (java.lang.Exception exception) 	{
		// out.println(exception.toString());
		exception.printStackTrace(); // COMMON-ICN-0185
	}
	finally{
		if(con != null)
			ConnectionManager.returnConnection(con,request);//END
	}
	
%>
