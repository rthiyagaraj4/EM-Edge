<!DOCTYPE html>
<%@ page import ="webbeans.eCommon.*,java.sql.*, java.util.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
    <html><head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></head></html>
<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

	StringBuffer strbuff;
	Connection con=null ;
	
	try 
	{
		con = ConnectionManager.getConnection(request);
		
		ArrayList finAr = new ArrayList();
		
		ArrayList firstItem = new ArrayList();
		
		firstItem.add("Text");  		
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FSLocationCode.label","fm_labels"));
		firstItem.add("fs_locn_code");
		firstItem.add("8");			
		firstItem.add("8");			

		finAr.add(firstItem);			

		ArrayList secondItem = new ArrayList();
		
		secondItem.add("Text");  		 
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileStorageLocationDesc.label","fm_labels"));	 
		secondItem.add("fs_locn_short_desc");		 
		secondItem.add("15");			 
		secondItem.add("15");	
		
		finAr.add(secondItem);			 

		ArrayList thirdItem = new ArrayList();
		thirdItem.add("Text");   		
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.FileTypeCode.label","mp_labels"));
		thirdItem.add("file_type_code");
		thirdItem.add("4");			
		thirdItem.add("4");			
		
		finAr.add(thirdItem); 		

		ArrayList fourthItem = new ArrayList();
		fourthItem.add("Text");   	
		fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FileTypeDescription.label","common_labels"));
		fourthItem.add("file_type_short_desc"); 
		fourthItem.add("15");			
		fourthItem.add("15");	
		
		finAr.add(fourthItem); 			

		ArrayList fifthItem = new ArrayList();

		fifthItem.add("List");  		
		fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  		
		fifthItem.add("eff_status");	
		fifthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));  

		finAr.add(fifthItem); 			       

		String orderByCols[]	= new String[4];
		String orderByColVals[] = new String[4];

		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FSLocationCode.label","fm_labels");
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileStorageLocationDesc.label","fm_labels");
		orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.FileTypeCode.label","mp_labels");
		orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FileTypeDescription.label","common_labels");

		orderByColVals[0] = "fs_locn_code";
		orderByColVals[1] = "fs_locn_short_desc";
		orderByColVals[2] = "file_type_code";
		orderByColVals[3] = "file_type_short_desc";

		strbuff = qrypg.getQueryPage(con,finAr,"FM File Type","../jsp/FMFileTypeforFSLocnQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols,orderByColVals,"Execute Query");

		out.println(strbuff.toString());
		finAr.clear(); 
		firstItem.clear(); 
		secondItem.clear(); 
		thirdItem.clear(); 
		fourthItem.clear(); 
		fifthItem.clear();
	}
	catch(Exception e){out.println("In Exception :"+e.toString());}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
