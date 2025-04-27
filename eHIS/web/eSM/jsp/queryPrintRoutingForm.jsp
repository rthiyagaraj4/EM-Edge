<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*,eSM.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>



<%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>
    <jsp:useBean id="qrypg"   scope="page"  class="eSM.PrintRoutingQueryPage"/>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>

<%
	//PrintRoutingQueryPage qrypg = new PrintRoutingQueryPage();
	StringBuffer strbuff;
	Connection con=null;
	String locale = (String)session.getAttribute("LOCALE");
	try{

		con = ConnectionManager.getConnection(request);
		java.util.ArrayList finAr = new java.util.ArrayList();
		java.util.ArrayList firstItem = new java.util.ArrayList();
        String module=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Module.label","common_labels");
		firstItem.add("List");  		 //Type of item
		firstItem.add(module);	  // label
		firstItem.add("module_id");	//name of field
		firstItem.add("Select distinct a.module_id,a.module_name from sm_module a , sm_report b where install_yn='Y' and b.module_id=a.module_id order by module_name");	

		finAr.add(firstItem);//add to ArrayList obj finAr

		java.util.ArrayList secondItem = new java.util.ArrayList();
        String rep_id=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReportID.label","common_labels");
		secondItem.add("Text");  		 //Type of item
		secondItem.add(rep_id);	  // label
		secondItem.add("report_id");	//name of field
		secondItem.add("30");	// SIZE
		secondItem.add("30");	//LENGTH

		finAr.add(secondItem);//add to ArrayList obj finAr
        String rep_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReportDesc.label","common_labels");
		java.util.ArrayList thirdItem = new java.util.ArrayList();
		thirdItem.add("Text");  		 //Type of item
		thirdItem.add(rep_desc);	  // label
		thirdItem.add("report_desc");	//name of field
		thirdItem.add("30");	// SIZE
		thirdItem.add("60");	//LENGTH
		finAr.add(thirdItem);//add to ArrayList obj finAr


		java.util.ArrayList fourthItem = new java.util.ArrayList();
        String fac_id=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels");
		fourthItem.add("Text");  		 //Type of item
		fourthItem.add(fac_id);	  // label
		fourthItem.add("facility_id");	//name of field
		fourthItem.add("2");	// SIZE
		fourthItem.add("2");	//LENGTH
		finAr.add(fourthItem);//add to ArrayList obj finAr


		java.util.ArrayList fifthItem = new java.util.ArrayList();
		String fac_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","common_labels");
		fifthItem.add("List");  		 //Type of item
		fifthItem.add(fac_name);	  // label
		fifthItem.add("facility_name");	//name of field
		fifthItem.add("select facility_id,facility_name from SM_FACILITY_PARAM_LANG_VW where language_id='"+locale+"' order by 2");
		finAr.add(fifthItem);//add to ArrayList obj finAr


		java.util.ArrayList sixthItem = new java.util.ArrayList();
		String dest_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DestinationType.label","common_labels");
		sixthItem.add("List");  		 //Type of item
		sixthItem.add(dest_type);	  // label
		sixthItem.add("dest_locn_type");	//name of field
		sixthItem.add("null,-----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ----- ,C,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels")+",L,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels")+",P,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.pharmacy.label","common_labels")+",S,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Store.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels")+",F,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.PermanentFSLocation.label","fm_labels")+",R,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels")+"");	
		//sixthItem.add("30");	//LENGTH
		finAr.add(sixthItem);//add to ArrayList obj finAr
   

		java.util.ArrayList seventhItem = new java.util.ArrayList();
		String dest_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.DestCode.label","sm_labels"); 
		seventhItem.add("Text");  		 //Type of item
		seventhItem.add(dest_code);	  // label
		seventhItem.add("dest_locn_code");	//name of field
		seventhItem.add("6");	// SIZE
		seventhItem.add("6");	//LENGTH
		finAr.add(seventhItem);//add to ArrayList obj finAr


		java.util.ArrayList eightItem = new java.util.ArrayList();
		String dest_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.DestDesc.label","sm_labels");
		eightItem.add("Text");  		 //Type of item
		eightItem.add(dest_desc);	  // label
		eightItem.add("dest_locn_desc");	//name of field
		eightItem.add("30");	// SIZE
		eightItem.add("40");	//LENGTH
		finAr.add(eightItem);//add to ArrayList obj finAr

		java.util.ArrayList ninthItem = new java.util.ArrayList();
		ninthItem.add("Text");  		 //Type of item
		ninthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.workstation.label","common_labels"));	  // label
		ninthItem.add("ws_no");	//name of field
		ninthItem.add("32");	// SIZE
		ninthItem.add("30");	//LENGTH
		finAr.add(ninthItem);//add to ArrayList obj finAr

		java.util.ArrayList tenthItem = new java.util.ArrayList();
		tenthItem.add("Lookup");  		 //Type of item
		tenthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.Printer.label","sm_labels"));	  // label
		tenthItem.add("printer");	//name of field
		tenthItem.add("30");	// SIZE
		tenthItem.add("30");	//LENGTH
		//tenthItem.add("select printer_id, printer_name from sm_printer  where eff_status='E' order by printer_name");	// SIZE
		//tenthItem.add("30");	//LENGTH
		finAr.add(tenthItem);//add to ArrayList obj finAr

		java.util.ArrayList eleventhItem = new java.util.ArrayList();
		eleventhItem.add("Text");  		 //Type of item
		eleventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.QueueName.label","sm_labels"));	  // label
		eleventhItem.add("queue_name");	//name of field
		eleventhItem.add("40");	// SIZE
		eleventhItem.add("60");	//LENGTH
		finAr.add(eleventhItem);//add to ArrayList obj finAr

		String orderByCols[] = new String[8];
		String orderByColVals[] = new String[8];


		orderByCols[0] = module;
		orderByCols[1] = rep_id;
		orderByCols[2] = rep_desc;
		orderByCols[3] = fac_id;
		orderByCols[4] = fac_name;
		orderByCols[5] = dest_type;
		orderByCols[6] = dest_code;
		orderByCols[7] = dest_desc;


		orderByColVals[0] = "pr.module_name";
		orderByColVals[1] = "pr.report_id";
		orderByColVals[2] = "pr.report_desc";
		orderByColVals[3] = "pr.facility_id";
		orderByColVals[4] = "pr.facility_name";
		orderByColVals[5] = "pr.dest_locn_type";
		orderByColVals[6] = "pr.dest_locn_code";
		orderByColVals[7] = "pr.dest_locn_desc";


		strbuff = qrypg.getMultiColumnQueryPage(con,finAr,"Find Print Routing ","../../eSM/jsp/queryPrintRouting.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols,orderByColVals,"Execute Query",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"));

		out.println(strbuff.toString());

		strbuff.setLength(0);
		finAr.clear();
		firstItem.clear();
		secondItem.clear();
		thirdItem.clear();
		fourthItem.clear();
		fifthItem.clear();
		sixthItem.clear();
		seventhItem.clear();
		eightItem.clear();
		ninthItem.clear();
		tenthItem.clear();
		eleventhItem.clear();
		}catch(Exception e){out.println(e);}
		
	finally { 
		ConnectionManager.returnConnection(con,request);
}
%>

