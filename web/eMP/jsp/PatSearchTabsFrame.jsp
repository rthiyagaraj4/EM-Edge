<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.net.*, webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%  
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");
	String jsp_name						=request.getParameter("jsp_name")==null?"":request.getParameter("jsp_name");
	String window_styl					=request.getParameter("window_styl")==null?"":request.getParameter("window_styl");
	String close_yn							=request.getParameter("close_yn")==null?"":request.getParameter("close_yn");
	String win_height						=request.getParameter("win_height")==null?"":request.getParameter("win_height");
	String win_width						=request.getParameter("win_width")==null?"":request.getParameter("win_width");
	String win_top							=request.getParameter("win_top")==null?"":request.getParameter("win_top");
	String act_yn  							=request.getParameter("act_yn")==null?"":request.getParameter("act_yn"); 
	String srr									=request.getParameter("srr")==null?"":request.getParameter("srr");
	String register_button_yn			=request.getParameter("register_button_yn")==null?"":request.getParameter("register_button_yn");
	String func_act							=request.getParameter("func_act")==null?"":request.getParameter("func_act");
	String defaultgender				=request.getParameter("default_gender")==null?"":request.getParameter("default_gender");
	String enablegenderyn			=request.getParameter("enable_gender_yn")==null?"":request.getParameter("enable_gender_yn");
	String dr_function_id=request.getParameter("dr_function_id")==null?"":request.getParameter("dr_function_id");
	String func_idpassed=request.getParameter("func_idpassed")==null?"":request.getParameter("func_idpassed");
	// Added for IN0 by Suresh M on 20.12.2010
	String patient_class=request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
	//Added for this CRF HSA-CRF-0289
	String alterIdSearch=request.getParameter("alterIdSearch")==null?"":request.getParameter("alterIdSearch");
	String isAlternateId=request.getParameter("isAlternateId")==null?"":request.getParameter("isAlternateId");
	String alternate_no=request.getParameter("alternate_no")==null?"":request.getParameter("alternate_no");

	String contact_no=request.getParameter("contact_no")==null?"":request.getParameter("contact_no");//Added by Ashwin K for AAKH-CRF-0150
	//Maheshwaran K added for MMS-DM-CRF-0208.1 
	String suspend_inactive_pat_yn=request.getParameter("suspend_inactive_pat_yn")==null?"N":request.getParameter("suspend_inactive_pat_yn");
	
	
	//End HSA-CRF-0289
     String pat_search_tab ="";
	 Connection con			   = null;
     ResultSet rset			   = null ;
      PreparedStatement pstmt    = null;
	try
	{
	con					    = ConnectionManager.getConnection(request); 
    pstmt                   = con.prepareStatement("select  PAT_SEARCH_DFLT_TAB from mp_param");
    rset                    = pstmt.executeQuery();
	if(rset.next())
	 pat_search_tab=rset.getString("PAT_SEARCH_DFLT_TAB");
	 if(pat_search_tab.equals("B"))
	 pat_search_tab="BasicTab";
	  else
      pat_search_tab="AdvanceTab";
		   if(rset != null) rset.close();
		   if(pstmt != null) pstmt.close();
		   
	}catch(Exception e) 
	{
	e.printStackTrace();
	}
  if(con!=null) ConnectionManager.returnConnection(con,request);
		
 
%>
<html>
		<head>
			<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
			<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
			<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
			  
			<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>       
			<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
			<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>

			<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
			<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
			<Script src="../../eMP/js/SmartCard.js" language="JavaScript"></Script>
		<%
	
		if(session.getValue("smart_path")!= null) {
			if(!session.getValue("smart_path").equals(" ")){
				out.println(session.getValue("smart_path"));
			}
		}
		%>			
		
			<Script src="../../eMP/js/json02.js"></Script>
			<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>	
			<%
	    	if(session.getValue("sekure_ws_yn")!= null) {
				if(session.getValue("sekure_ws_yn").equals("Y")){
					out.println("<script src='http://localhost:9996/api/files/Sekure.js'></script>");
				}
			}
			%>
			<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
			<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
			<Script language="JavaScript"src="../../eCommon/js/DateUtils.js" ></Script>
			<script src="../../eMP/js/PatientSearch.js" language="JavaScript"></Script>
            <Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script>





		</head>
		<%
		if(!patient_class.equals("")){%>
			<body onKeyDown='lockKey()' onload ="ChangeTabs('AdvanceTab')" >
			<%}else{%>
			<!-- <body onKeyDown='lockKey()' onload ="ChangeTabs('<%=pat_search_tab%>')" >-->
			<body onKeyDown='lockKey()' onload ="ChangeTabs('<%=pat_search_tab%>')" >
			<%}%>
				<form name="Tabs_Form" id="Tabs_Form">
					 <ul id="tablist" class="tablist" style="padding-left:0px; font-size: 0.7rem;">
						<li class="tablistitem" title="Basic Search">
								<a onclick="ChangeTabs('BasicTab')" class="tabclicked" id='BasicTab' >
									<span class="tabspanclicked" id="BasicTabspan" ><fmt:message key="Common.basic.label" bundle="${common_labels}"/></span>
							</a>
					</li>
				<li class="tablistitem" title="Advance Search">
					<a onclick="ChangeTabs('AdvanceTab')" class="tabA" id="AdvanceTab" >
						<span class="tabAspan" id="AdvanceTabspan"><fmt:message key="Common.advanced.label" bundle="${common_labels}"/></span>
					</a>
				</li>
			</ul>
			<script>prevTabObj='BasicTab'</script>
				<input type="hidden" name="jsp_name" id="jsp_name" value="<%=jsp_name%>" >
	<input type="hidden" name="window_styl" id="window_styl" value="<%=window_styl%>" >
	<input type="hidden" name="close_yn" id="close_yn" value="<%=close_yn%>" >
	<input type="hidden" name="win_top" id="win_top" value="<%=win_top%>" >
	<input type="hidden" name="win_width" id="win_width" value="<%=win_width%>" >
	<input type="hidden" name="win_height" id="win_height" value="<%=win_height%>" >
	<input type="hidden" name="act_yn" id="act_yn" value="<%=act_yn%>" >
	<input type="hidden" name="srr" id="srr" value="<%=srr%>" >
	<input type="hidden" name="register_button_yn" id="register_button_yn" value="<%=register_button_yn%>" >
	<input type="hidden" name="func_act" id="func_act" value="<%=func_act%>" >
	<input type="hidden" name="default_gender" id="default_gender" value="<%=defaultgender%>" >
	<input type="hidden" name="enable_gender_yn" id="enable_gender_yn" value="<%=enablegenderyn%>" >
	<input type="hidden" name="dr_function_id" id="dr_function_id" value="<%=dr_function_id%>" >
	<input type="hidden" name="func_idpassed" id="func_idpassed" value="<%=func_idpassed%>" >
	<input type="hidden" name="patient_class" id="patient_class" value="<%=patient_class%>" >	
	<!--Added for this CRF HSA-CRF-0289-->
	<input type="hidden" name="alterIdSearch" id="alterIdSearch" value="<%=alterIdSearch%>" >
	<input type="hidden" name="isAlternateId" id="isAlternateId" value="<%=isAlternateId%>" >	
	<input type="hidden" name="alternate_no" id="alternate_no" value="<%=alternate_no%>" >	
	<!-- Added by Ashwin K for AAKH-CRF-0150 -->
	<input type="hidden" name="smart_contact_no" id="smart_contact_no" value="<%=contact_no%>" >		
	<!-- Ended by Ashwin K for AAKH-CRF-0150 -->
	<!--//Maheshwaran K added for MMS-DM-CRF-0208.1 - suspend_inactive_pat_yn-->
	<input type="hidden" name="suspend_inactive_pat_yn" id="suspend_inactive_pat_yn" value="<%=suspend_inactive_pat_yn%>" >		
	<!-- Added by Sethu for EDGE Requirements -->
	<input type="hidden" name="tab_id_clicked" id="tab_id_clicked">		
			</form>
		</body>
</html>

