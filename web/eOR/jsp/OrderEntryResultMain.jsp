<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%  request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id 				= request.getParameter("bean_id");
	String bean_name 			= request.getParameter("bean_name");
	//out.println("qry-->"+request.getQueryString());
	/* Mandatory checks end */
	/* Initialize Function specific start */
	//OrderEntryBean bean 		= (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	OrderEntryBean bean			= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
   bean.setLanguageId(localeName);
	/* Initialize Function specific end */
%>
<html>
<head><title><fmt:message key="eOR.OrderEntryResultMain.label" bundle="${or_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	<script language="JavaScript" src="../../eOR/js/OrderEntry.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntrySearch.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



	</head>
<%	
		/* Added By Arvind */
		session.removeAttribute("orderSetVal");
		session.removeAttribute("panelVal");
		session.removeAttribute("individualVal");
		session.removeAttribute("pageVist");
    	/* End Here */

    String order_category		= bean.checkForNull(request.getParameter("order_category"));
	String order_type			= bean.checkForNull(request.getParameter("order_type"));
	if(!order_type.equals("")) order_type = order_type.trim();
	String activity_type		= bean.checkForNull(request.getParameter("activity_type"));
	String order_catalog_nature	= bean.checkForNull(request.getParameter("order_catalog_nature"));
	String orderable_text		= bean.checkForNull(request.getParameter("orderable_text"));
	String criteria				= bean.checkForNull(request.getParameter("criteria"));
	String restrict_by			= bean.checkForNull(request.getParameter("restrict_by"));
	String priv_applicability_yn			= bean.checkForNull(request.getParameter("priv_applicability_yn"),"");
	//String function_from		= bean.checkForNull(request.getParameter("function_from"));
	// Set to the bean to maintain the category and the order_type
	bean.setOrderCategoryValue(order_category);
	bean.setOrderTypeValue(order_type);
	bean.setRestrictYn(restrict_by);   // Used for Pharmacy Orders
	//int atomic_frame_count		= 0;
	//int profile_frame_count		= 0;
	//int group_frame_count		= 0;
	String atomic_file_name		= "../../eCommon/html/blank.html";
	String group_file_name		= "../../eCommon/html/blank.html";
	String profile_file_name	= "../../eCommon/html/blank.html";
	String frame_size			= "0%,0%,0%";
	//String group_frame			= "", profile_frame		= "", 
	//String atomic_frame			= ""; 
	//String group_display_size 	= "0";
	//String profile_display_size 	= "0";
	//String atomic_display_size 	= "0";
	String frame_names			= "";
	int display_records			= OrRepository.DISPLAY_MAX_RECORDS;// 44 records as set in repository

if(order_catalog_nature.equals("")) // For All
{

			HashMap map = new HashMap();
	        map.put("order_category",order_category);
	        map.put("order_type",order_type);
	        map.put("activity_type",activity_type);
			map.put("order_catalog_nature",order_catalog_nature);
	        map.put("orderable_text",orderable_text);
	        map.put("criteria",criteria);
	        map.put("restrict_by",restrict_by);
	        map.put("priv_applicability_yn",priv_applicability_yn);
			
			
		/*ArrayList orderCatalog = bean.getOrderCatalog(map); // to get the count

		if(orderCatalog!=null)
		{
			for(int i=0; i<orderCatalog.size(); i++)
			{
				String[] record = (String[])orderCatalog.get(i);
				if(record[1].equals("S")) // FOR ALL
				group_frame_count = Integer.parseInt(record[0]);
								
				else if(record[1].equals("A")) // For Atomic
				
					atomic_frame_count = Integer.parseInt(record[0]);
					
				
				else if(record[1].equals("P")) // For Profile
					profile_frame_count = Integer.parseInt(record[0]);
			}
		}*/
	// For External Order, Order Set tab not to be shown.
	// Make the group_frame_count = 0, so that the frame will not be displayed
	//if(function_from.equals("EXTERNAL_ORDER"))
	//	group_frame_count = 0;
//out.println("group_frame_count="+group_frame_count+" ,atomic_frame_count="+atomic_frame_count+", profile_frame_count="+profile_frame_count);
//order_category=LB,order_type=,activity_type=, order_catalog_nature=,orderable_text=,criteria=C,restrict_by=N group_frame_count=0 ,atomic_frame_count=2, profile_frame_count=0 



		//if(!(group_frame_count == 0 && profile_frame_count == 0  && atomic_frame_count ==0 ))
		//{
			/*
			 *  Calling the Method from the Bean to get the Frame Names and the Size of the Frames
			 */
			/*ArrayList FrameCount = bean.getFrameCount(group_frame_count,profile_frame_count,atomic_frame_count);
			for(int i=0; i<FrameCount.size(); i++)
			{
 				String[] record 	= (String[])FrameCount.get(i);
 				frame_names 		= record[0]; // Name of the Frames to be used for global variable in JS
				frame_size 			= record[1]; // Size of the Frame;
				//group_frame 		= record[2]; // Size of the Group Frame
				//profile_frame		= record[3]; // Size of the Profile Frame
				//atomic_frame		= record[4]; // Size of the Atomic Frame
				group_display_size	= record[5]; // Records to be displayed in group frame
				profile_display_size= record[6]; // Records to be displayed in profile frame
				atomic_display_size	= record[7]; // Records to be displayed in atomic frame
			}*/
			 group_file_name		= "../../eOR/jsp/OrderEntryOrderSetResult.jsp?"+request.getQueryString()+"&group_frame_count=&display_records=&order_nature=S&order_catalog_nature="+order_catalog_nature;
			//if(atomic_frame_count > 0)
			   atomic_file_name		= "../../eOR/jsp/OrderEntryOrderSetResult.jsp?"+request.getQueryString()+"&atomic_frame_count=&display_records=&order_nature=A&order_catalog_nature="+order_catalog_nature;
			//if(profile_frame_count > 0)
			   profile_file_name	= "../../eOR/jsp/OrderEntryOrderSetResult.jsp?"+request.getQueryString()+"&profile_frame_count=&display_records=&order_nature=P&order_catalog_nature"+order_catalog_nature;
			 
			
	%>
		<!-- <script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));parent.criteriaMainFrame.document.addlSearchCriteriaForm.search.disabled = false;</script> -->
	<%
		//}
}	 	// 	End of for all
else if(order_catalog_nature.equals("A"))
	frame_names				= "Atomic";
else if(order_catalog_nature.equals("P"))
	frame_names				= "Profile";
else if(order_catalog_nature.equals("S"))
	frame_names				= "Group"; //OrderSets and also
//out.println("frame_names"+frame_names+"group_frame"+group_frame+"atomic_frame"+atomic_frame+"profile_frame"+profile_frame);
// if(!((group_frame_count == 0) && (profile_frame_count == 0)  && (atomic_frame_count ==0 ) )){
  if(order_catalog_nature.equals("")) // For All
   {
	// Below code change done for Edge Conversion 
	//start
	String style1 ="height:30vh;width:100vw";
    String style2 ="height:30vh;width:100vw";
    String style3 ="height:30vh;width:100vw";
   
    if (order_category.equals("RX")||order_category.equals("CN")||order_category.equals("OT"))
    {
    	style1 ="height:30vh;width:100vw;display: none;"; 
        style2 ="height:30vh;width:100vw;display: none;";  
    	style3 ="height:80vh;width:100vw";  
    }
    else if(order_category.equals("DS") || order_category.equals("PC") || order_category.equals("PH"))
    {
    	style1 ="height:49vh;width:100vw;"; 
        style2 ="height:0vh;width:100vw;display: none;";  
    	style3 ="height:49vh;width:100vw";  
    }
    //end	
    
%>
		<!--  <frameset rows='<%=frame_size%>' framespacing=3 name="sectionFrame" id="sectionFrame">-->
			<iframe name="resultHdrFrame" id="resultHdrFrame" src= "<%=group_file_name%>" framespacing="0" noresize frameborder="0"  scrolling="yes"  style='<%=style1 %>'></iframe>
			<iframe name="resultListFrame" id="resultListFrame" src= "<%=profile_file_name%>"  framespacing="0" noresize frameborder="0"  scrolling="yes" style='<%=style2 %>'></iframe>
			<iframe name="resultDtlFrame" id="resultDtlFrame" src= "<%=atomic_file_name%>" framespacing="0" noresize frameborder="0"  scrolling="yes" style='<%=style3 %>'></iframe>
		<!-- </frameset>-->
<% } else if(order_catalog_nature.equals("A")) // For Atomic
   {
%>
		<!-- <frameset rows="0%,0%,100%" framespacing=3 > -->
			<iframe name="resultHdrFrame" id="resultHdrFrame" src= "../../eCommon/html/blank.html" framespacing="0" noresize frameborder="0"  scrolling="yes" style='height:30vh;width:95vw'></iframe>
			<iframe name="resultListFrame" id="resultListFrame" src="../../eCommon/html/blank.html" framespacing="0" noresize frameborder="0"  scrolling="yes" style='height:0vh;width:95vw'></iframe>
			<iframe name="resultDtlFrame" id="resultDtlFrame" src="../../eOR/jsp/OrderEntryOrderSetResult.jsp?<%=request.getQueryString()%>&order_nature=A&display_records=<%=display_records%>&order_catalog_nature=<%=order_catalog_nature%>" framespacing="0" noresize frameborder="0"  scrolling="yes" style='height:30vh;width:95vw'></iframe>
			<!--<frame name="resultDtlFrame" id="resultDtlFrame" src='../../eOR/jsp/OrderEntryResultDtl.jsp?<%=request.getQueryString()%>&order_nature=A' framespacing="0" noresize frameborder="0"  scrolling="no"></frame>-->
		<!-- </frameset> -->

<% }else if(order_catalog_nature.equals("P")) // For Profile
   {
%>
		<!-- <frameset rows="0%,100%,0%" framespacing=3> -->
				<iframe name="resultHdrFrame" id="resultHdrFrame" src= "../../eCommon/html/blank.html" framespacing="0" noresize frameborder="0"  scrolling="yes" style='height:30vh;width:95vw'></iframe>
				<iframe name="resultListFrame" id="resultListFrame" src="../../eOR/jsp/OrderEntryOrderSetResult.jsp?<%=request.getQueryString()%>&order_nature=P&display_records=<%=display_records%>&order_catalog_nature=<%=order_catalog_nature%>" framespacing="0" noresize frameborder="0"  scrolling="yes" style='height:0vh;width:95vw'></iframe>
				<iframe name="resultDtlFrame" id="resultDtlFrame" src="../../eCommon/html/blank.html" framespacing="0" noresize frameborder="0"  scrolling="yes" style='height:60vh;width:95vw'></iframe>
		<!-- </frameset> -->
<% }else if(order_catalog_nature.equals("S")) // For OrderSets and function not called from EXTERNAL_ORDER
   {
%>
		<!-- <frameset rows="100%,0%,0%" framespacing=3> -->
				<iframe name="resultHdrFrame" id="resultHdrFrame" src="../../eOR/jsp/OrderEntryOrderSetResult.jsp?<%=request.getQueryString()%>&order_nature=S&display_records=<%=display_records%>&order_catalog_nature=<%=order_catalog_nature%>" framespacing="0" noresize frameborder="0"  scrolling="yes" style='height:30vh;width:95vw'></iframe>
				<iframe name="resultListFrame" id="resultListFrame" src= "../../eCommon/html/blank.html" framespacing="0" noresize frameborder="0"  scrolling="yes" style='height:0vh;width:95vw'></iframe>
				<iframe name="resultDtlFrame" id="resultDtlFrame" src="../../eCommon/html/blank.html" framespacing="0" noresize frameborder="0"  scrolling="yes" style='height:60vh;width:95vw'></iframe>
	<!-- 	</frameset> -->
<% }
else{%>
<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));</script>
	 <!--  <frameset rows="0%,0%,0%" framespacing=3 > -->
			<iframe name="resultHdrFrame" id="resultHdrFrame" src= "../../eCommon/html/blank.html" framespacing="0" noresize frameborder="0"  scrolling="no" style='height:39vh;width:95vw'></iframe>
			<iframe name="resultListFrame" id="resultListFrame" src="../../eCommon/html/blank.html" framespacing="0" noresize frameborder="0"  scrolling="no" style='height:0vh;width:95vw'></iframe>
			<iframe name="resultDtlFrame" id="resultDtlFrame" src="../../eCommon/html/blank.html" framespacing="0" noresize frameborder="0"  scrolling="no" style='height:60vh;width:95vw'></iframe>
	<!--  </frameset> -->  

<%}%>
		<script>parent.search_frames="<%=frame_names%>"; </script>
</html>

<%
	// set it back persistence (since few set methods have been used to set values in bean)
	putObjectInBean(bean_id,bean,request);
%>

