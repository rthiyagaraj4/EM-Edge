<!DOCTYPE html>
<%@ page  import="webbeans.eCommon.*,java.sql.*, java.util.*, org.json.simple.*,java.text.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html> 
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
  <% 
  /* below lines are add by venkateshs on 29/06/2012 against  the crf SKR-CRF-0021 [IN028173] */
    String sql              ="";
	String color            ="";
	String  green           ="";
	String red              ="";
    String yellow           ="";
    String unassigned       ="";	
    PreparedStatement pstmt	= null;
	ResultSet rset			= null;
	String locale		    = (String)session.getAttribute("LOCALE");
	Connection con		= null ;
	con				= ConnectionManager.getConnection(request);
	/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar2nd 2014 Start*/
	//Added by Sangeetha for ML-MMOH-CRF-0642 on 27/apr/2017
	Boolean boldPriorityZoneTab = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "BOLD_PRIORITY_ZONE_TAB");
	//Added by Sangeetha for ML-MMOH-CRF-0643 on 02/may/2017
	Boolean rearrangePriorityZoneTab = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "REARRANGE_PRIORITY_ZONE_TAB");
	//Maheshwaran K added for ML-MMOH-CRF-1973 as on 21-07-2023
	//Starts	
	String tabIndicator=(request.getParameter("tabIndicator")==null)? "" : request.getParameter("tabIndicator");
	//Added by santhosh for ML-MMOH-CRF-1973
	String char_tab_aClass=(checkForNull(tabIndicator).equals("others_tab"))?"tabA":"tabClicked";
	String char_tab_spanClass=(checkForNull(tabIndicator).equals("others_tab"))?"tabAspan":"tabSpanclicked";
	String others_tab_aClass=(checkForNull(tabIndicator).equals("others_tab"))?"tabClicked":"tabA";
	String others_tab_spanClass=(checkForNull(tabIndicator).equals("others_tab"))?"tabSpanclicked":"tabAspan";
	//END
	
	Boolean isAppearAsTabEnable  = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","AE_TREATMENT_AREA_TAB"); 
	String	short_desc ="";
	String	tab_colour ="";
	String tab_font_colour ="";
	String treat_area_code="";		
	String treatment_area_all_codes="";		
	int tab_count=0;
	int first_tab_cnt=5;	
	String facility_id		=	(String) session.getValue("facility_id");
	String appear_as_tab_yn = "";//Added for ML-MMOH-CRF-1973
	int tab_row_cnt=1;
	ResultSet			rs			=	null;
	String	treatment_area_code				=	"";
	String	clinic_code						=	"";
	String clinic_code2 ="";
	clinic_code=request.getParameter("clinic_code"); 
	clinic_code2=clinic_code;
/*	StringBuffer query_location  = new StringBuffer();
	StringBuffer query_treatment_area = new StringBuffer();
	String where_condition	=	"";
	String  checkout_yn	=	"";
	String  first_clinic_code	=	"";
	int rowIndex =	1;
	String login_user_id	=	(String)session.getValue("login_user");
    String oper_stn_id     =	(request.getParameter("oper_stn_id")==null)? "" : request.getParameter("oper_stn_id");
	*/
	//Ends
	System.err.println("***************************AEManagePatGITabs Called ******************************** ");
	String priority_zone_code				= "";
	String priority_zone_desc			= "";
	String priority_zone_color			= "";
	String priority_zone_all_codes		= "";
	String five_level_triage_appl_yn	=  (request.getParameter("five_level_triage_appl_yn")==null || request.getParameter("five_level_triage_appl_yn")=="")?"N":request.getParameter("five_level_triage_appl_yn");
	String search_treatment_area_code = checkForNull(request.getParameter("treatment_area_code"));
	Map<String, String> colorMap = new HashMap<String, String>();
	Map<String, String> colorFontMap = new HashMap<String, String>();//Maheshwaran K added for ML-MMOH-CRF-1973 as on 21-07-2023
	colorMap.put("G", "Green");
	colorMap.put("R", "Red");
	colorMap.put("Y", "Yellow");
	colorMap.put("U", "ORANGE");
	//Maheshwaran K added for ML-MMOH-CRF-1973 as on 21-07-2023
	//Starts
	if(isAppearAsTabEnable){
	colorMap.put("PR", "Purple");
	colorMap.put("BR", "Brown");
	colorMap.put("BL", "Blue");
	colorMap.put("DB", "#00008B");
	colorMap.put("MG", "Magenta");
	colorMap.put("PK", "Pink");
	colorMap.put("CY", "Cyan");
	colorMap.put("GY", "Grey");
	colorFontMap.put("G", "Green");
	colorFontMap.put("R", "Red");
	colorFontMap.put("Y", "Yellow");
	colorFontMap.put("U", "ORANGE");
	colorFontMap.put("PR", "White");
	colorFontMap.put("BR", "White");
	colorFontMap.put("BL", "White");
	colorFontMap.put("DB", "White");
	colorFontMap.put("MG", "White");
	colorFontMap.put("PK", "Black");
	colorFontMap.put("CY", "Black");
	colorFontMap.put("GY", "White");
	}
	//Ends
	System.err.println("colorMap------>"+colorMap);
	System.err.println("colorFontMap------>"+colorFontMap);
	/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar2nd 2014 End*/
	//Added by Sangeetha for ML-MMOH-CRF-0643 on 02/may/2017
	String priority_zone_desc_unassign			= "";
	String priority_zone_color_unassign			= "";
	String priority_zone_code_unassign			= "";
	
	/*Commented For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 2nd 2014 Start*/
	/*try
	{  
	  sql="SELECT PRIORITY_ZONE,PRIORITY_ZONE_TAB_DESC FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID= ? and EFF_STATUS='E'";
				
			    pstmt   = con.prepareStatement(sql.toString());
			 	pstmt.setString(1,locale) ;
			    rset    = pstmt.executeQuery();
				while(rset!=null && rset.next())
				{
				 color      =rset.getString("PRIORITY_ZONE");
				 if (color.equals("G")) {green=rset.getString("PRIORITY_ZONE_TAB_DESC");}
				 if (color.equals("R")) {red=rset.getString("PRIORITY_ZONE_TAB_DESC");}
				 if (color.equals("Y")) {yellow=rset.getString("PRIORITY_ZONE_TAB_DESC");}
				 if (color.equals("U")) {unassigned=rset.getString("PRIORITY_ZONE_TAB_DESC");}
				
				 
				 }
	
	
    }catch(Exception e){e.printStackTrace();}
	finally 
	{
	if (rset !=null) rset.close();
	if (pstmt !=null) pstmt.close();
	if(con!=null) ConnectionManager.returnConnection(con,request);
	}
				
				
				*/
	
 /* CRF  SKR-CRF-0021 [IN028173] end  */
 /*Commented For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 End*/
 %>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
<script src='../../eAE/js/AEManagePatientGI.js' language="javascript"></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

	function tab_click1(id) 
		{ 
			if(prevTabObj == null){
				prevTabObj="char_tab";
			}
			selectTab(id);
			tab_click(id);
		}

</script> 
</head>
<body  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'> 
<%
try{ 

%>
<form name="AEManagePatTabsForm" id="AEManagePatTabsForm"  onLoad="javascript:tab_click('char_tab');" OnMouseDown="CodeArrest()"> 

<table cellspacing='0' cellpadding='0' width='100%' border=0 align='center'>
  <tr><td class='white'>
		<ul id="tablist" class="tablist" >
			<li class="tablistitem" title="Patient Management">
				<a onclick="tab_click1('char_tab')" class="<%=char_tab_aClass%>" id='char_tab' >
					<span class="<%=char_tab_spanClass%>" id="char_tabspan"><fmt:message key="eAE.PatientManagement.label" bundle="${ae_labels}"/></span>
				</a>
			 </li>
			    <li class="tablistitem" title="Unassigned List">
				<a onclick="tab_click1('others_tab')" class="<%=others_tab_aClass%>" id="others_tab" >
				<span class="<%=others_tab_spanClass%>" id="others_tabspan"><fmt:message key="eAE.UnassignedList.label" bundle="${ae_labels}"/></span>
					
				</a>
		   </li>
       </ul>
	 </td>
   </tr>
</table>

<table cellspacing=0 cellpadding=0 align="center" width="100%" border="0">
<tr>
	<table id='priority_table' name='table_priority' id='table_priority' border=1 align='left' cellpadding='0' cellspacing='0' width='80%' style='visibility:visible'>
	<tr>		
	
<!-- below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] -->
	<!--   <td class=RESUSCITATION id="critical" align=center  style='cursor:pointer' alt="Critical" nowrap onclick="showCritical()"><%=red%></td>	
	<td class=OAYELLOW id="semicritical"  align=center style='cursor:pointer' alt="Semi-Critical" onclick="showSemiCritical()" nowrap><font size=2 color='black'><%=yellow%></font></td>	
	<td class=URGENT id="noncritical"  align=center style='cursor:pointer' alt="Non-Critical" nowrap onclick="showNonCritical()"><font color='WHITE'><%=green%></font></td>	
	<td class=EMERGENT id="Unassigned"  align=center style='cursor:pointer' alt="unassigned" nowrap onclick="showUnassigned()"><font color='WHITE'><%=unassigned%></font></td>-->
		
	
<!--CRF  SKR-CRF-0021 [IN028173] end-->
<%
sql="SELECT PRIORITY_ZONE,PRIORITY_ZONE_TAB_DESC,PRIORITY_ZONE_COLOR FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID=? and EFF_STATUS='E' ";
if(!five_level_triage_appl_yn.equals("Y")){
		sql	= sql + "  and priority_zone not in ('B','W') ";
}
sql= sql + " order by PRIORITY_ZONE_ORDER asc";
pstmt   = con.prepareStatement(sql.toString());
pstmt.setString(1,locale) ;
rset    = pstmt.executeQuery();
while(rset!=null && rset.next())
{
	priority_zone_code	= rset.getString("PRIORITY_ZONE");
	priority_zone_desc	= rset.getString("PRIORITY_ZONE_TAB_DESC");
	priority_zone_color = (rset.getString("PRIORITY_ZONE_COLOR")==null || rset.getString("PRIORITY_ZONE_COLOR")=="")?"":rset.getString("PRIORITY_ZONE_COLOR");
 	if(priority_zone_color.equals("")){
 		priority_zone_color	= colorMap.get(priority_zone_code);
 	}
 	priority_zone_all_codes	= priority_zone_all_codes + priority_zone_code + ",";

	if(rearrangePriorityZoneTab && priority_zone_code.equals("U")){ 
			priority_zone_color_unassign = priority_zone_color;
			priority_zone_desc_unassign  = priority_zone_desc;
			priority_zone_code_unassign  = priority_zone_code;
    } else { %>
	<td class=RESUSCITATION id="priority_zone_tab_<%=priority_zone_code%>" alt="<%=priority_zone_desc%>"  align=center  style='cursor:pointer;background-color:<%=priority_zone_color%>;width:210px;break-row;' nowrap  onclick="FnShowPriorityWise('<%=priority_zone_code%>')">&nbsp;<%=priority_zone_desc%></td>
	<input type='hidden' name='priority_zone_color_<%=priority_zone_code%>' id='priority_zone_color_<%=priority_zone_code%>' id='priority_zone_color_<%=priority_zone_code%>' value='<%=priority_zone_color%>'>
<%}

}
%>

	
	<td class=PATIENTLINECOLOR id="others" style='width:210px;break-row;'  align=center style='cursor:pointer' alt="All" onclick="showAll()" nowrap><font color='WHITE'><fmt:message key="Common.all.label" bundle="${common_labels}"/></font></td>		
	</td>
	<% //Added by Sangeetha for ML-MMOH-CRF-0643 on 02/may/2017
	if(rearrangePriorityZoneTab){%>
		<td class=RESUSCITATION id="priority_zone_tab_<%=priority_zone_code_unassign%>" alt="<%=priority_zone_desc_unassign%>"  align=center  style='cursor:pointer;background-color:<%=priority_zone_color_unassign%>;width:210px;break-row;' nowrap onclick="FnShowPriorityWise('<%=priority_zone_code_unassign%>')">&nbsp;<%=priority_zone_desc_unassign%></td>
		<input type='hidden' name='priority_zone_color_<%=priority_zone_code_unassign%>' id='priority_zone_color_<%=priority_zone_code_unassign%>' id='priority_zone_color_<%=priority_zone_code_unassign%>' value='<%=priority_zone_color_unassign%>'>
	<%}  
	//Maheshwaran K added for ML-MMOH-CRF-1973 as on 21-07-2023
	//Starts
	try {
	if(isAppearAsTabEnable) 
		{
	//	JSONObject AppearAsTabYNJson		= new JSONObject();
	//	AppearAsTabYNJson = eAE.AECommonBean.getAppearAsTabYN(con,facility_id,treatment_area_code,clinic_code);
	//	appear_as_tab_yn		= (String)AppearAsTabYNJson.get("appear_as_tab_yn");
	//	if(appear_as_tab_yn.equals("Y")) 
	//		{ 
				sql="SELECT TREATMENT_AREA_CODE,short_desc, appear_as_tab_yn, tab_colour FROM ae_tmt_area_for_clinic WHERE appear_as_tab_yn = 'Y' AND facility_id =? AND clinic_code =? and treatment_area_code=NVL(?,treatment_area_code) "; 			
				pstmt   = con.prepareStatement(sql.toString());
				pstmt.setString(1,facility_id) ;
				pstmt.setString(2,clinic_code) ;
				pstmt.setString(3,search_treatment_area_code) ;
			    rs    = pstmt.executeQuery();			
				while(rs!=null && rs.next())
					{					
					short_desc	= rs.getString("short_desc");
					appear_as_tab_yn	= rs.getString("appear_as_tab_yn");
					tab_colour	= rs.getString("tab_colour");
					treat_area_code	= rs.getString("TREATMENT_AREA_CODE");
					tab_font_colour	= colorFontMap.get(tab_colour);
				 	tab_colour	= colorMap.get(tab_colour);	
					treatment_area_all_codes = treatment_area_all_codes + treat_area_code + ",";				
					%>			
					<td style='width:212px;break-row;' class=RESUSCITATION id="treatment_area_tab_<%=treat_area_code%>" alt="<%=short_desc%>"  align=center  style='cursor:pointer;background-color:<%=tab_colour%>;color:<%=tab_font_colour%>;' nowrap onclick="FnShowPriorityWise('','<%=treat_area_code%>','<%=appear_as_tab_yn%>','treatmentAreaTab')">&nbsp;<%=short_desc%>
					</td>
					<input type='hidden' name='treatment_tab_color_<%=treat_area_code%>' id='treatment_tab_color_<%=treat_area_code%>' id='treatment_tab_color_<%=treat_area_code%>' value='<%=tab_colour%>'>
					<%
					tab_count++;
					if(tab_count==4 && first_tab_cnt==5)
						{
						tab_count=0;
						out.println("</tr>");
						out.println("<tr  width='50%'>");
						first_tab_cnt=0;
						tab_row_cnt++;
						}
					else if(tab_count==9)
						{
						tab_count=0;
						out.println("</tr>");
						out.println("<tr  width='50%'>");	
						tab_row_cnt++;
						}	 			
					}
					//System.err.println("tab_row_cnt in AEManagePatGITabs.jsp========"+tab_row_cnt);
			//	}
			%>
<input type='hidden' name='treatment_area_all_codes' id='treatment_area_all_codes' id="treatment_area_all_codes" value='<%=treatment_area_all_codes%>' >
	<%	}
	
	if (rset !=null) rset.close();
	if (pstmt !=null) pstmt.close();
	}
	catch(Exception e)
		{
		e.printStackTrace();
		}
	%>
	<!--End ML-MMOH-CRF-1973-->
	</tr>
	</table>
	<script>
	//Maheshwaran K added for ML-MMOH-CRF-1973 as on 21-07-2023
	if(<%=isAppearAsTabEnable%>){
	var row_ht =<%=tab_row_cnt%>*5;
	var frset = parent.document.getElementsByTagName("frameset")[0];
	frset.rows = "13%,"+row_ht+"%,*,0%";
	}
	var prevTabObj
	function loadingtab(obj)
		{
		 alert('loadingtab');
	//	 alert('document.getElementById("char_tab")  : '+document.getElementById("char_tab").name);
	//			eval("document.getElementById("char_tab")").className="tabClicked"
	//		eval("document.getElementById("char_tabspan")").className="tabSpanclicked"
		}
	</script> 
<input type='hidden' name='ct_tab_name' id='ct_tab_name'  >
<input type='hidden' name='toggle_wait_patman' id='toggle_wait_patman'  value="char_tab">
<!--  Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 2nd 2014 Start-->
<input type='hidden' name='five_level_triage_appl_yn' id='five_level_triage_appl_yn' value='<%=five_level_triage_appl_yn %>'>
<input type='hidden' name='priority_zone_all_codes' id='priority_zone_all_codes' id="priority_zone_all_codes" value='<%=priority_zone_all_codes%>' >
<!--  Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 2nd 2014 End-->
<!-- Added by Sangeetha for ML-MMOH-CRF-0642 on 27/apr/17 -->
<input type='hidden' name='boldPriorityZoneTab' id='boldPriorityZoneTab' value="<%=boldPriorityZoneTab%>">
<!--Maheshwaran K added for ML-MMOH-CRF-1973 as on 05-07-2023-->
<!--Starts-->
<input type='hidden' name='appear_as_tab_yn' id='appear_as_tab_yn' value="">
<input type='hidden' name='treatment_area_code1' id='treatment_area_code1' value='' > 
<input type='hidden' name='isAppearAsTabEnable' id='isAppearAsTabEnable' value="<%=isAppearAsTabEnable%>">
<input type='hidden' name='clinic_code2' id='clinic_code2' value="<%=clinic_code2%>"> 
<!--Ends-->
</form>
</body>
  <%  }catch(Exception e){e.printStackTrace();}
	finally 
	{
	if (rset !=null) rset.close();
	if (pstmt !=null) pstmt.close();
	if(con!=null) ConnectionManager.returnConnection(con,request);
	}%>
</html>
 <%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

