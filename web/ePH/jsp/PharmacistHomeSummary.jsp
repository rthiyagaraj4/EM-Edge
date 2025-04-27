<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,java.util.*, ePH.PharmacistHomeBean, ePH.Common.*"  contentType="text/html;charset=UTF-8"%> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<STYLE>
			.gridData1
			{
				background-color: #FFFFFF;
				height:18px;
				font-family: Verdana, Arial, Helvetica, sans-serif;
				font-size: 10px;
				color: #000000;
				font-weight:normal;
				text-align:left;
				vertical-align:middle;
				border-bottom:0px;
				border-top:0px;
				border-left:0px;
				border-right:0px;
				border-style:solid;
				border-color:#EEEEEE;
				padding-left:10px;
				padding-right:10px;
			}
			.gridDataBlue1
			{
				height:18px;
				font-family: Verdana, Arial, Helvetica, sans-serif;
				font-size: 8pt;
				color: #0000FF;
				font-weight:normal;
				text-align:left;
				vertical-align:middle;
				border-bottom:0px;
				border-top:0px;
				border-left:0px;
				border-right:0px;	
				background-color: #FFFFFF;	
				border-style:none;
				border-color:#EEEEEE;
			}
		</STYLE>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		String SummaryPreviewPage=request.getParameter("SummaryPreviewPage") == null ? "" : request.getParameter("SummaryPreviewPage");			
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src='../../ePH/js/PharmacistHome.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>	
		<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 			
<%
		if(SummaryPreviewPage.equals("SummaryPreviewPage")){			
%>
			<title>Summary Preview</title>
<%
		}
%>
	</head>
	<body  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
		<FORM METHOD=POST ACTION="" name="frmMenu" id="frmMenu">
			<TABLE width='100%' border="0" align='center'>
<%		
				String bean_id   = "PharmacistHomeBean" ;
				String bean_name = "ePH.PharmacistHomeBean";
				PharmacistHomeBean bean = (PharmacistHomeBean)getBeanObject( bean_id, bean_name, request ) ;
				bean.setLanguageId(locale);

				Connection con = null;
				String desktopID = request.getParameter("desktopID") == null ? "" : request.getParameter("desktopID");	
				String facility_id=(String) session.getValue("facility_id");
				String store_code = "" ,from_date = "" ,to_date = "";
				String User_id	  =	(String)session.getValue("login_user");		
				ArrayList arrList = new ArrayList();
				PreparedStatement pstmtComp = null,pstmtcnt=null;
				ResultSet rsComp = null,rscount=null;		
				String summaryHdr="";		
				String summarySubHrd="";	
				String prevsummaryHdr="";
				String summary_comp_id="";
				String prefixspace="";
				String sourceSQL="";
				String tempStr1 = "";				
				String totCount="0";
				String desktopFunctionID="";		
				String summarySubHrdbg ="";
				String module_id ="";
				String function_id ="";
				String access ="";
				store_code	=  bean.getStore_code();
				//to_date		=  com.ehis.util.DateUtils.getCurrentDate("DMY",locale).toString();
				//from_date	=  com.ehis.util.DateUtils.minusDate(to_date,"DMY",locale,7,"d").toString();
				try{
					con = ConnectionManager.getConnection(request);
					//pstmtComp = con.prepareStatement("SELECT MIN (LEVEL) level1, LPAD (' ', (MIN (LEVEL) - 1) * 12, ' ') prefixspace, c.summary_comp_desc summary_comp_desc, NVL (c.summary_comp_desc_legend, c.summary_comp_desc ) summary_comp_desc_bg, a.summary_comp_id || summary_comp_occ_num summary_comp_id, a.hdr_summary_comp_id || hdr_summary_comp_occ_num hdr_summary_comp_id, ds.source_sql, c.executable_name, order_seq, (SELECT module_id FROM sm_function WHERE executable_name LIKE c.executable_name || '%' AND module_id IN ('ST', 'PH', 'MM') AND ROWNUM = 1) module_id, (SELECT function_id FROM sm_function WHERE executable_name LIKE c.executable_name || '%' AND module_id IN ('ST', 'PH', 'MM') AND ROWNUM = 1) function_id, (SELECT insert_access_yn || update_access_yn || query_only_access_yn || delete_access_yn || print_access_yn FROM sm_menu_dtl WHERE function_id = (SELECT function_id FROM sm_function WHERE executable_name LIKE c.executable_name || '%' AND module_id IN ('ST', 'PH', 'MM') AND ROWNUM = 1) AND ROWNUM = 1) access_yn, TO_CHAR (DECODE (c.APPLICABLE_MODULE_ID, 'PH', (SELECT SYSDATE - NVL (disp_beyond_no_of_days, 0) FROM ph_facility_param WHERE facility_id = ?), (SELECT SYSDATE - NVL (durn_for_start_date, 0) FROM st_facility_param WHERE facility_id = ?) ), 'dd/mm/yyyy' ) from_date, TO_CHAR (DECODE (c.APPLICABLE_MODULE_ID, 'PH', (SELECT SYSDATE + NVL (disp_before_no_of_days, 0) FROM ph_facility_param WHERE facility_id = ?), SYSDATE ), 'dd/mm/yyyy' ) TO_DATE FROM sm_desktop_sum_dtl a, sm_desktop_sum_comp c, sm_data_source ds WHERE a.desktop_summary_id = ? AND c.summary_comp_id(+) = a.summary_comp_id AND ds.source_id(+) = c.summary_data_source_id GROUP BY c.summary_comp_desc, NVL (c.summary_comp_desc_legend, c.summary_comp_desc), a.summary_comp_id || summary_comp_occ_num, a.hdr_summary_comp_id || hdr_summary_comp_occ_num, ds.source_sql, c.APPLICABLE_MODULE_ID, c.executable_name, order_seq START WITH hdr_summary_comp_id = ? AND hdr_summary_comp_occ_num = 1 CONNECT BY PRIOR a.summary_comp_id = a.hdr_summary_comp_id AND a.summary_comp_occ_num = a.hdr_summary_comp_occ_num ORDER BY order_seq");
					// ML-MMOH-CRF-1479 Start.
					//pstmtComp = con.prepareStatement("SELECT MIN (LEVEL) level1, LPAD ('&nbsp;&nbsp;', (MIN (LEVEL) - 1) * 12, '&nbsp;&nbsp;') prefixspace, c.summary_comp_desc summary_comp_desc, NVL (c.summary_comp_desc_legend, c.summary_comp_desc ) summary_comp_desc_bg, a.summary_comp_id || summary_comp_occ_num summary_comp_id, a.hdr_summary_comp_id || hdr_summary_comp_occ_num hdr_summary_comp_id, ds.source_sql, c.executable_name, order_seq, (SELECT module_id FROM sm_function WHERE FUNCTION_NAME like NVL (c.summary_comp_desc_legend, c.summary_comp_desc) AND module_id IN ('ST', 'PH', 'MM') AND ROWNUM = 1) module_id, (SELECT function_id FROM sm_function WHERE FUNCTION_NAME like NVL (c.summary_comp_desc_legend, c.summary_comp_desc) AND module_id IN ('ST', 'PH', 'MM') AND ROWNUM = 1) function_id, (SELECT insert_access_yn || update_access_yn || query_only_access_yn || delete_access_yn || print_access_yn FROM sm_menu_dtl WHERE function_id = (SELECT function_id FROM sm_function WHERE FUNCTION_NAME like NVL (c.summary_comp_desc_legend, c.summary_comp_desc) AND module_id IN ('ST', 'PH', 'MM') AND ROWNUM = 1) AND ROWNUM = 1) access_yn, TO_CHAR (DECODE (c.APPLICABLE_MODULE_ID, 'PH', (SELECT SYSDATE - NVL (disp_beyond_no_of_days, 0) FROM ph_facility_param WHERE facility_id = ?), (SELECT SYSDATE - NVL (durn_for_start_date, 0) FROM st_facility_param WHERE facility_id = ?) ), 'dd/mm/yyyy' ) from_date, TO_CHAR (DECODE (c.APPLICABLE_MODULE_ID, 'PH', (SELECT SYSDATE + NVL (disp_before_no_of_days, 0) FROM ph_facility_param WHERE facility_id = ?), SYSDATE ), 'dd/mm/yyyy' ) TO_DATE, TO_CHAR ( (SELECT SYSDATE - NVL (disp_beyond_no_of_days_IP, 0) FROM ph_facility_param WHERE facility_id = 'RP') , 'dd/mm/yyyy' ) from_date_IP, TO_CHAR ((SELECT SYSDATE + NVL (disp_before_no_of_days_IP, 0) FROM ph_facility_param WHERE facility_id = 'RP' ), 'dd/mm/yyyy' ) TO_DATE_IP, to_char(sysdate, 'dd/mm/yyyy') curr_date FROM sm_desktop_sum_dtl a, sm_desktop_sum_comp c, sm_data_source ds WHERE a.desktop_summary_id = ? AND c.summary_comp_id(+) = a.summary_comp_id AND ds.source_id(+) = c.summary_data_source_id GROUP BY c.summary_comp_desc, summary_comp_desc_legend, /* NVL (c.summary_comp_desc_legend, c.summary_comp_desc),*/ a.summary_comp_id || summary_comp_occ_num, a.hdr_summary_comp_id || hdr_summary_comp_occ_num, ds.source_sql, c.APPLICABLE_MODULE_ID, c.executable_name, order_seq START WITH hdr_summary_comp_id = ? AND hdr_summary_comp_occ_num = 1 CONNECT BY PRIOR a.summary_comp_id = a.hdr_summary_comp_id AND a.summary_comp_occ_num = a.hdr_summary_comp_occ_num ORDER BY order_seq");
				//	pstmtComp.setString(1,facility_id);
				//	pstmtComp.setString(2,facility_id);
				//	pstmtComp.setString(3,facility_id);
				//	pstmtComp.setString(4,desktopID);
				//	pstmtComp.setString(5,desktopID);
					
					pstmtComp = con.prepareStatement("SELECT MIN (LEVEL) level1, LPAD ('&nbsp;&nbsp;', (MIN (LEVEL) - 1) * 12, '&nbsp;&nbsp;') prefixspace, c.summary_comp_desc summary_comp_desc, NVL (c.summary_comp_desc_legend, c.summary_comp_desc ) summary_comp_desc_bg, a.summary_comp_id || summary_comp_occ_num summary_comp_id, a.hdr_summary_comp_id || hdr_summary_comp_occ_num hdr_summary_comp_id, ds.source_sql, c.executable_name, order_seq, (SELECT module_id FROM sm_function WHERE FUNCTION_NAME like NVL (c.summary_comp_desc_legend, c.summary_comp_desc) AND module_id IN ('ST', 'PH', 'MM') AND ROWNUM = 1) module_id, (SELECT function_id FROM sm_function WHERE FUNCTION_NAME like NVL (c.summary_comp_desc_legend, c.summary_comp_desc) AND module_id IN ('ST', 'PH', 'MM') AND ROWNUM = 1) function_id, (SELECT insert_access_yn || update_access_yn || query_only_access_yn || delete_access_yn || print_access_yn FROM sm_menu_dtl WHERE function_id = (SELECT function_id FROM sm_function WHERE FUNCTION_NAME like NVL (c.summary_comp_desc_legend, c.summary_comp_desc) AND module_id IN ('ST', 'PH', 'MM') AND ROWNUM = 1) AND ROWNUM = 1) access_yn, TO_CHAR (DECODE (c.APPLICABLE_MODULE_ID, 'PH', (SELECT SYSDATE - NVL (disp_beyond_no_of_days, 0) FROM ph_facility_param WHERE facility_id = ?), (SELECT SYSDATE - NVL (durn_for_start_date, 0) FROM st_facility_param WHERE facility_id = ?) ), 'dd/mm/yyyy' ) from_date, TO_CHAR (DECODE (c.APPLICABLE_MODULE_ID, 'PH', (SELECT SYSDATE + NVL (disp_before_no_of_days, 0) FROM ph_facility_param WHERE facility_id = ?), SYSDATE ), 'dd/mm/yyyy' ) TO_DATE, TO_CHAR ( (SELECT SYSDATE - NVL (disp_beyond_no_of_days_IP, 0) FROM ph_facility_param WHERE facility_id = ?) , 'dd/mm/yyyy' ) from_date_IP, TO_CHAR ((SELECT SYSDATE + NVL (disp_before_no_of_days_IP, 0) FROM ph_facility_param WHERE facility_id = ? ), 'dd/mm/yyyy' ) TO_DATE_IP, to_char(sysdate, 'dd/mm/yyyy') curr_date FROM sm_desktop_sum_dtl a, sm_desktop_sum_comp c, sm_data_source ds WHERE a.desktop_summary_id = ? AND c.summary_comp_id(+) = a.summary_comp_id AND ds.source_id(+) = c.summary_data_source_id GROUP BY c.summary_comp_desc, summary_comp_desc_legend, /* NVL (c.summary_comp_desc_legend, c.summary_comp_desc),*/ a.summary_comp_id || summary_comp_occ_num, a.hdr_summary_comp_id || hdr_summary_comp_occ_num, ds.source_sql, c.APPLICABLE_MODULE_ID, c.executable_name, order_seq START WITH hdr_summary_comp_id = ? AND hdr_summary_comp_occ_num = 1 CONNECT BY PRIOR a.summary_comp_id = a.hdr_summary_comp_id AND a.summary_comp_occ_num = a.hdr_summary_comp_occ_num ORDER BY order_seq");
					pstmtComp.setString(1,facility_id);
					pstmtComp.setString(2,facility_id);
					pstmtComp.setString(3,facility_id);
					pstmtComp.setString(4,facility_id);
					pstmtComp.setString(5,facility_id);
					pstmtComp.setString(6,desktopID);
					pstmtComp.setString(7,desktopID);
					
					//ML-MMOH-CRF-1479 End.
					rsComp = pstmtComp.executeQuery();

					while(rsComp.next()){	
						totCount = "0";
						arrList.clear();
						summary_comp_id=rsComp.getString("summary_comp_id");

						if (prevsummaryHdr.equals(summary_comp_id)){
							continue;
						}
						else{
							prevsummaryHdr=summary_comp_id;				
						}
						summaryHdr=rsComp.getString("LEVEL1");
						summarySubHrd=rsComp.getString("SUMMARY_COMP_DESC");
						summarySubHrdbg=rsComp.getString("summary_comp_desc_bg");
						sourceSQL=rsComp.getString("SOURCE_SQL")==null?"":rsComp.getString("SOURCE_SQL");	
						//sourceSQL="";
						prefixspace=rsComp.getString("prefixspace")==null?"":rsComp.getString("prefixspace");	
						desktopFunctionID=rsComp.getString("EXECUTABLE_NAME")==null?"":rsComp.getString("EXECUTABLE_NAME");	
						module_id=rsComp.getString("MODULE_ID")==null?"":rsComp.getString("MODULE_ID");					
						function_id=rsComp.getString("FUNCTION_ID")==null?"":rsComp.getString("FUNCTION_ID");					
						access=rsComp.getString("ACCESS_YN")==null?"NNNN":rsComp.getString("ACCESS_YN");
						
						if (!sourceSQL.equals("")){			
							while (sourceSQL.indexOf("&&") > 0){
								tempStr1 = sourceSQL.substring(sourceSQL.indexOf("&&"), (sourceSQL.indexOf("##")+2));		
								sourceSQL  = sourceSQL.replaceFirst(tempStr1,"?");
								arrList.add( tempStr1.substring((tempStr1.indexOf("&&")+2),tempStr1.indexOf("##")));
							}
//System.err.println("====sourceSQL===>"+sourceSQL);
//System.err.println("====arrList==>"+arrList+"  facility_id===>"+facility_id+"=="+rsComp.getString("from_date")+"=="+rsComp.getString("to_date")+"==User_id"+User_id);
							pstmtcnt = con.prepareStatement(sourceSQL);		
							for (int j = 0 ;j<arrList.size() ;j++ )	{
								if (((String)arrList.get(j)).equalsIgnoreCase("LOGGED_IN_FACILITY")){									
									pstmtcnt.setString(j+1,facility_id);
								}
								else if (((String)arrList.get(j)).equalsIgnoreCase("LOGGED_IN_STORE")){									
									pstmtcnt.setString(j+1,store_code);									
								}
								else if (((String)arrList.get(j)).equalsIgnoreCase("FROM_DATE")){	
									pstmtcnt.setString(j+1,rsComp.getString("from_date"));
								}
								else if (((String)arrList.get(j)).equalsIgnoreCase("TO_DATE")){									
									pstmtcnt.setString(j+1,rsComp.getString("to_date"));
								}
								else if (((String)arrList.get(j)).equalsIgnoreCase("FROM_DATE_IP")){	
									pstmtcnt.setString(j+1,rsComp.getString("FROM_DATE_IP"));
								}
								else if (((String)arrList.get(j)).equalsIgnoreCase("TO_DATE_IP")){									
									pstmtcnt.setString(j+1,rsComp.getString("TO_DATE_IP"));
								}
								else if (((String)arrList.get(j)).equalsIgnoreCase("LOGGED_IN_USERID")){									
									pstmtcnt.setString(j+1,User_id);
								}
								else if (((String)arrList.get(j)).equalsIgnoreCase("FILL_DATE")){									
									pstmtcnt.setString(j+1,rsComp.getString("CURR_DATE"));
								}
							}
							rscount = pstmtcnt.executeQuery();
							if (rscount.next()){
								totCount = rscount.getString(1);				
								if (totCount==null)  totCount="0";
							}
							else{
								totCount="0";
							}
							if(rscount != null)
								rscount.close();
							if(pstmtcnt != null)
								pstmtcnt.close();							
						}
					   if(!desktopFunctionID.equals("")){
							if(desktopFunctionID.indexOf("?")!= -1)
								desktopFunctionID = desktopFunctionID +"&homepage=Y&store_code="+store_code+"&home_required_yn=N&module_id="+module_id+"&function_id="+function_id+"&access="+access+"&count="+totCount+"&heading="+summarySubHrd;
							else
								desktopFunctionID = desktopFunctionID +"?homepage=Y&store_code="+store_code+"&home_required_yn=N&module_id="+module_id+"&function_id="+function_id+"&access="+access+"&count="+totCount+"&heading="+summarySubHrdbg;
						}
						if(summaryHdr.equals("1") || desktopFunctionID.equals("")){
%>
							<tr><td align="left" class='gridData1'nowrap><b><%=prefixspace%><%=summarySubHrd%></b></td></tr>
<%	
						}
						else{
							if(SummaryPreviewPage.equals("SummaryPreviewPage")){
								totCount="0";
%>
								<tr><td class="gridData1" nowrap><%=prefixspace%><%=summarySubHrd%>(<%=totCount%>)</td> </tr>
<%
							}
							else if(sourceSQL.equals("")){
%>
								<tr><td class="gridData1" nowrap><%=prefixspace%><a style='color:black;' href='<%=desktopFunctionID%>' onMouseOver='' onclick="loadTitleName('<%=summarySubHrdbg%>')  "target="workAreaFrame" ><%=summarySubHrd%></a></td> </tr>
<%
							}
							else{
								if(!totCount.equals("0")){
%>
									<tr><td class="gridData1" nowrap><%=prefixspace%><a style='color:blue;' href='<%=desktopFunctionID%>' onMouseOver='' onclick="loadTitleName('<%=summarySubHrdbg%>')  "target="workAreaFrame" ><%=summarySubHrd%>(<%=totCount%>)</a></td> </tr>
<%
								}
								else{
%>
									<tr><td class="gridData1" nowrap><%=prefixspace%><a style='color:black;' onMouseOver='' ><%=summarySubHrd%>(<%=totCount%>)</a></td> </tr>
<%
								}
							}
						}
					}									
				}
				catch(Exception e){
					e.printStackTrace();
					out.println("Error while gettting the menu: "+sourceSQL+" summary_comp_id="+summary_comp_id);
				}
				finally{
					try{
						if(rsComp!= null) rsComp.close();
						if(pstmtComp!=null) pstmtComp.close();
						if(con!= null) ConnectionManager.returnConnection(con,request);
					}
					catch(Exception e){
						e.printStackTrace();
						out.println("Exception in PharmacistHomeSummary.jsp"+e.toString());
						
					}
				}
%>		
			</TABLE>
		</FORM>
	</body>
</html>
<%
	putObjectInBean(bean_id,bean,request);
%>

