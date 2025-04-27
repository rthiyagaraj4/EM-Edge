<!DOCTYPE html>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History   Name       Description
-------------------------------------------------------------------------------------------------------------------------------------
?           100            ?          created
27/11/2012	IN035914	   Nijitha	  CHL Hospital suggested that the presentation of the Clinician desktop be changed and 
									  more appealing. Keeping the display of information more clear and visible.
20/08/2013	IN041295 	   Nijitha	  TTM-SCF-0002: Personalize Home Page? the screen display null
03/04/2015	IN054674 	   Nijitha	  AAKH-CRF-0063.1 : New menu option in CA->Desktop->Summary & Navigation
08/05/2018	IN066237	   Prakash C 	 MMS-DM-CRF-0123
14/11/2023		51215		Ramesh												ML-MMOH-CRF-1930.2
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<STYLE>
.gridData1
{
	background-color: #FFFFFF;
	height:18px;
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 8pt;//Changed from 10px to 8pt for IN044106
	color: #000000;
	font-weight:normal;
	text-align:left;
	vertical-align:middle;
	border-bottom:0px;
	border-top:0px;
	border-left:0px;
	border-right:0px;
	border-style:none;//IN044106
	border-color:#EEEEEE;
//	padding-left:10px; //Commented for IN044106
	//padding-right:10px; //Commented for IN044106
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
		String sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String SummaryPreviewPage=request.getParameter("SummaryPreviewPage") == null ? "" : request.getParameter("SummaryPreviewPage");			
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src='../../eCA/js/CAMainMenu.js' language='javascript'></script>
	<script src='../../eCA/js/CASummaryMenu.js' language='javascript'></script>	
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
		Connection con = null;
		String desktopID = request.getParameter("desktopID") == null ? "" : request.getParameter("desktopID");	
		
		String facility_id=(String) session.getValue("facility_id");
		String Clin_id=(String)session.getValue("ca_practitioner_id");
		//---IN054674/Start----
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		//---IN054674/End------
		String User_id	=	(String)session.getValue("login_user");		
		String responsibility_id		= (String)session.getValue("responsibility_id");
		ArrayList arrList = new ArrayList();
		PreparedStatement pstmtComp = null,pstmtcnt=null,c4cStmt=null;
		ResultSet rsComp = null,rscount=null,rsC4c=null;		
		String summaryHdr="";		
		String summarySubHrd="";	
		String prevsummaryHdr="";
		String summary_comp_id="";
		String prefixspace="";
		String sourceSQL="";
		String tempStr1 = "";				
		String tempStr = "";		
		String totCount="0";
		String desktopFunctionID="";		
//		String strLink = "";
		String summarySubHrdbg ="";//IN035914
				
	try
	{
		con = ConnectionManager.getConnection(request);
		boolean isVirtualConsSDGSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","VIRTUAL_CONSALTATION_SDG");  //51215
		//pstmtComp = con.prepareStatement("SELECT     MIN (LEVEL) level1,           LPAD ('&nbsp;', (MIN (LEVEL) - 1) * 12, '&nbsp;') prefixspace,           c.summary_comp_desc summary_comp_desc,           a.summary_comp_id || summary_comp_occ_num summary_comp_id,              a.hdr_summary_comp_id           || hdr_summary_comp_occ_num hdr_summary_comp_id,           ds.source_sql, c.executable_name, order_seq      FROM sm_desktop_sum_dtl a, sm_desktop_sum_comp c, sm_data_source ds     WHERE a.desktop_summary_id = ?      AND c.summary_comp_id(+) = a.summary_comp_id        AND ds.source_id(+) = c.summary_data_source_id  GROUP BY c.summary_comp_desc,           a.summary_comp_id || summary_comp_occ_num,           a.hdr_summary_comp_id || hdr_summary_comp_occ_num,           ds.source_sql,           c.executable_name,           order_seq START WITH hdr_summary_comp_id = ? AND hdr_summary_comp_occ_num = 1 CONNECT BY PRIOR a.summary_comp_id = a.hdr_summary_comp_id       AND a.summary_comp_occ_num = a.hdr_summary_comp_occ_num  ORDER BY order_seq ");	
		//pstmtComp = con.prepareStatement("SELECT     MIN (LEVEL) level1,           LPAD ('&nbsp;', (MIN (LEVEL) - 1) * 12, '&nbsp;') prefixspace,    c.summary_comp_desc_user summary_comp_desc, NVL(C.SUMMARY_COMP_DESC_LEGEND,c.summary_comp_desc_user) summary_comp_desc_bg,           a.summary_comp_id || summary_comp_occ_num summary_comp_id,              a.hdr_summary_comp_id           || hdr_summary_comp_occ_num hdr_summary_comp_id,           ds.source_sql, c.executable_name, order_seq      FROM sm_desktop_sum_dtl a, sm_desktop_sum_comp c, sm_data_source ds     WHERE a.desktop_summary_id = ?      AND c.summary_comp_id(+) = a.summary_comp_id        AND ds.source_id(+) = c.summary_data_source_id  GROUP BY c.summary_comp_desc_user,NVL(C.SUMMARY_COMP_DESC_LEGEND,c.summary_comp_desc_user),           a.summary_comp_id || summary_comp_occ_num,           a.hdr_summary_comp_id || hdr_summary_comp_occ_num,           ds.source_sql,           c.executable_name,           order_seq START WITH hdr_summary_comp_id = ? AND hdr_summary_comp_occ_num = 1 CONNECT BY PRIOR a.summary_comp_id = a.hdr_summary_comp_id       AND a.summary_comp_occ_num = a.hdr_summary_comp_occ_num  ORDER BY order_seq ");//IN035914
		pstmtComp = con.prepareStatement("SELECT     MIN (LEVEL) level1,           LPAD ('&nbsp;', (MIN (LEVEL) - 1) * 12, '&nbsp;') prefixspace,    nvl(c.summary_comp_desc_user, c.summary_comp_desc) summary_comp_desc, NVL(C.SUMMARY_COMP_DESC_LEGEND,nvl(c.summary_comp_desc_user,c.summary_comp_desc)) summary_comp_desc_bg,           a.summary_comp_id || summary_comp_occ_num summary_comp_id,              a.hdr_summary_comp_id           || hdr_summary_comp_occ_num hdr_summary_comp_id,           ds.source_sql, c.executable_name, order_seq      FROM sm_desktop_sum_dtl a, sm_desktop_sum_comp c, sm_data_source ds     WHERE a.desktop_summary_id = ?      AND c.summary_comp_id(+) = a.summary_comp_id        AND ds.source_id(+) = c.summary_data_source_id  GROUP BY nvl(c.summary_comp_desc_user,c.summary_comp_desc), NVL(C.SUMMARY_COMP_DESC_LEGEND,nvl(c.summary_comp_desc_user,c.summary_comp_desc)),           a.summary_comp_id || summary_comp_occ_num,           a.hdr_summary_comp_id || hdr_summary_comp_occ_num,           ds.source_sql,           c.executable_name,           order_seq START WITH hdr_summary_comp_id = ? AND hdr_summary_comp_occ_num = 1 CONNECT BY PRIOR a.summary_comp_id = a.hdr_summary_comp_id       AND a.summary_comp_occ_num = a.hdr_summary_comp_occ_num  ORDER BY order_seq ");//IN035914//IN041295 
				
				pstmtComp.setString(1,desktopID);
				pstmtComp.setString(2,desktopID);
				rsComp = pstmtComp.executeQuery();

				
				while(rsComp.next()){	
						totCount = "0";
						arrList.clear();
						summary_comp_id=rsComp.getString("summary_comp_id");
						if (prevsummaryHdr.equals(summary_comp_id))
							{
								continue;
							}
							else
							{
								prevsummaryHdr=summary_comp_id;
				
							}
						summaryHdr=rsComp.getString("LEVEL1");
						summarySubHrd=rsComp.getString("SUMMARY_COMP_DESC");	
						summarySubHrdbg=rsComp.getString("summary_comp_desc_bg");//IN035914
						sourceSQL=rsComp.getString("SOURCE_SQL")==null?"":rsComp.getString("SOURCE_SQL");	
						
						prefixspace=rsComp.getString("prefixspace")==null?"":rsComp.getString("prefixspace");	
						desktopFunctionID=rsComp.getString("EXECUTABLE_NAME")==null?"":rsComp.getString("EXECUTABLE_NAME");						
						if (!sourceSQL.equals(""))
						{							
							tempStr = sourceSQL;
							for (int i=0;i<tempStr.length()-1 ;i++ )
							{
								if (tempStr.indexOf("&&") > 0)
								{
									tempStr1 = tempStr.substring(tempStr.indexOf("&&"),tempStr.indexOf("##")+2);				
									sourceSQL  = sourceSQL.replace(tempStr1,"?");
									arrList.add( tempStr1.substring(tempStr1.indexOf("&&")+2,tempStr1.indexOf("##")));										
								}
									
								if (tempStr.indexOf("##") > 0)
								{									
									tempStr = tempStr.substring(tempStr.indexOf("##")+2);									
								}									
							}	
							
							pstmtcnt = con.prepareStatement(sourceSQL);							
							for (int j = 0 ;j<arrList.size() ;j++ )
							{
								
								if (((String)arrList.get(j)).equals("LOGGED_IN_FACILITY"))
								{									
									pstmtcnt.setString(j+1,facility_id);	
								}else if (((String)arrList.get(j)).equals("LOGGED_IN_PRACT"))
								{									
									pstmtcnt.setString(j+1,Clin_id);
								}else if (((String)arrList.get(j)).equals("LOGGED_IN_RESP"))
								{									
									pstmtcnt.setString(j+1,responsibility_id);
								}else if (((String)arrList.get(j)).equals("LOGGED_IN_USERID"))
								{									
									pstmtcnt.setString(j+1,User_id);
								}
								//---IN054674/Start----
								else if (((String)arrList.get(j)).equals("LANGUAGE_ID"))
								{
									pstmtcnt.setString(j+1,locale);
								}
								//---IN054674/End------	
							}
							
							rscount = pstmtcnt.executeQuery();
							if (rscount.next())
							{
								totCount = rscount.getString(1);

								
								if (totCount==null)  totCount="0";
							}
							else 
								totCount="0";
								if(rscount != null)
									rscount.close();
								if(pstmtcnt != null)
									pstmtcnt.close();							
						}	
						if(summaryHdr.equals("1") && sourceSQL.equals(""))
						{%>
							<!--<tr><td align="left" class='gridData1'nowrap> IN037982	-->
								<tr><td align="left" class='gridData1' title='<%=summarySubHrd%>' nowrap>
								<!--<b><%=prefixspace%><%=summarySubHrd%></b> //IN035914-->
								<!--<b><%=prefixspace%><%=summarySubHrdbg%></b>-->
								<%=prefixspace%><%=summarySubHrdbg%><!--//IN035914,IN038450-->
							</td></tr>
						<%	
						}
						else if (sourceSQL.equals(""))
						{%>
							<!--<tr><td align="left" class='gridData1'nowrapnowrap>	IN037982-->
							<tr><td align="left" class='gridData1' title='<%=summarySubHrd%>' nowrap >	
								<!--<%=prefixspace%><%=summarySubHrd%>//IN035914-->
								<%=prefixspace%><%=summarySubHrdbg%><!--//IN035914-->
							</td></tr>
						<%
						}
						else if (totCount.equals("0"))
						{
						%>
						
							<!--<tr><td align="left" class='gridData1' nowrap> IN037982-->
							<!-- <tr><td align="left" class='gridData1'   title='<%=summarySubHrd%>' nowrap>IN066237-->
							<tr><td align="left" class='gridData1' id='<%=summary_comp_id%>'  title='<%=summarySubHrd%>' nowrap><!--IN066237-->							
								<%=prefixspace%><%=summarySubHrd%>(0)	
							</td></tr>
						<%
						}
						else
						{
							if(SummaryPreviewPage.equals("SummaryPreviewPage")){
									totCount="0";
									%>
									<!--<tr><td class="gridData1" nowrap><%=prefixspace%><%=summarySubHrd%>(<%=totCount%>)</td> </tr> IN037982-->
									<tr><td class="gridData1" title='<%=summarySubHrd%>' nowrap><%=prefixspace%><%=summarySubHrd%>(<%=totCount%>)</td> </tr>
							<%}else{
						%>
						
							<!--<tr><td class="gridData1" nowrap><%=prefixspace%><a href='<%=desktopFunctionID%>'  onclick="loadTitleName('<%=summarySubHrd%>')  "target="workAreaFrame" ><%=summarySubHrd%>(<%=totCount%>)</a></td> </tr> IN035914 -->
							   <!--   <tr><td class="gridData1" nowrap><%=prefixspace%><a  href='<%=desktopFunctionID%>'  onclick="loadTitleName('<%=summarySubHrd%>')" title='<%=summarySubHrd%>' target="workAreaFrame" ><%=summarySubHrdbg%>(<%=totCount%>)</a></td> </tr>-- IN035914 -->
								<tr><td class="gridData1" id='<%=summary_comp_id%>' nowrap><%=prefixspace%><a  href='<%=desktopFunctionID%>'  onclick="loadTitleName('<%=summarySubHrd%>')" title='<%=summarySubHrd%>' target="workAreaFrame" ><%=summarySubHrdbg%>(<%=totCount%>)</a>
								<%
								if(isVirtualConsSDGSpec && "Outpatients".equals(summarySubHrd)){
									int c4cRecCount=0;
									c4cStmt = con.prepareStatement("SELECT Count(*) TOTALRECOD FROM pr_encounter p WHERE p.facility_id =? AND p.attend_practitioner_id = ? AND ( (    'Y' = (SELECT ca_rest_unbilled_patient FROM ca_cons_param) AND 'N' = blcommonproc.unbld_outst_amt_exists_yn (p.facility_id,p.patient_id,DECODE (p.patient_class,'OP', 'O','EM', 'E','IP', 'I','DC', 'D'),NULL,NULL,p.encounter_id,NULL) ) OR ('N' = (SELECT ca_rest_unbilled_patient FROM ca_cons_param)) )  AND p.visit_status IN ('01', '02', '03', '04', '05', '06') AND p.visit_adm_date_time BETWEEN TRUNC (SYSDATE) AND TRUNC (SYSDATE) + 1 AND p.patient_class = 'OP' AND OP_PATIENT_C4C_STATUS_DISPLAY(p.facility_id,p.patient_id,p.encounter_id,p.patient_class)='Y'");
									c4cStmt.setString(1,facility_id);
									c4cStmt.setString(2,Clin_id);
									rsC4c = c4cStmt.executeQuery();
									if (rsC4c.next())
									{
										c4cRecCount=rsC4c.getInt("TOTALRECOD");
									}	
									if(c4cRecCount>0){
								%>
									<img src='../../eCA/images/bellIcon.png' alt='Patients Waiting for Virtual Consultation'/>
								<%
									}
								}
								%>
								</td> </tr><!-- IN066237 -->
						<%
							
								

							}
						
						
						}%>
					
<%				}									
	}
	catch(Exception e)
	{
		e.printStackTrace();
		//out.println("Error while gettting the menu: "+e);//COMMON-ICN-0181
		
	}
	finally
	{
		try
		{
			if(rsComp!= null) rsComp.close();
			if(pstmtComp!=null) pstmtComp.close();
			
			if(con!= null) ConnectionManager.returnConnection(con,request);
		}
		catch(Exception e)
		{
		//	out.println("Exception in CAMainMenu.jsp"+e.toString());//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
			
		}
	}
	%>		
</TABLE>
</FORM>
</body>
</html>

