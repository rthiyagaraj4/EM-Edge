<!DOCTYPE html>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
21/11/2012		IN035950		Nijitha			CHL Hospital suggested that the presentation of the Clinician desktop be 												changed and more appealing. Keeping the display of information more clear 												 and visible.   								 
15/04/2020		IN072852 		Durga Natarajan	For Theme change 
-------------------------------------------------------------------------------------------------------------------------------------

*/
%>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<% 	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<%
//String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String sStyle = (session.getAttribute("PREFERRED_STYLE") != null && !((String) session.getAttribute("PREFERRED_STYLE")).isEmpty()) 
                 ? (String) session.getAttribute("PREFERRED_STYLE") 
                 : "IeStyle.css";
%>
<style>
TD.COLUMNHEADERCENTERNEW {
	background-color: #83AAB4;
	font-family: Verdana;
	font-size: 8pt;
	color: white;
	font-weight:bold;
	text-align:left;
	vertical-align:middle;
	border-bottom:1px;
	border-top:0px;
	border-left:0px;
	border-right:0px;
	border-style:solid;
	border-color:#EEEEEE;	
}
</style>
<!-- <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />-->
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<TITLE><fmt:message key="eCA.PatientChartSummaryTemplatePreview.label" bundle="${ca_labels}"/></TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
<%
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ArrayList positionsList = new ArrayList();
	int temp =0,tempRowId=0,totalRows = 0, tempExists = 0,totalCols=0;
	float widthPerCell=0,heightPerCell=0;
	String summaryId = request.getParameter("summaryId");
	String summaryDesc = request.getParameter("summaryDesc");
	if(summaryId == null || summaryId.equals("")) summaryId = "";
	if(summaryDesc == null || summaryDesc.equals("")) summaryDesc = "";
	//IN035950	Starts
	String patientClass = request.getParameter("patClass");
	String practitioner = request.getParameter("practitioner");
	String speciality =request.getParameter("speciality");
	String styleSheetName="";
	String content_id="";
	String called_from =request.getParameter("called_from");
//String strSql = "SELECT CSH.NO_OF_ROWS,CSH.NO_OF_COLS,CSD.ROW_POS,CSD.COL_POS,nvl(CSD.ROW_SPAN,'1') ROW_SPAN,nvl(CSD.COL_SPAN,'1') COL_SPAN,NVL(CSCN.CONTENT_USERDEF_DESC,CSCN.CONTENT_SYSDEF_DESC) TITLE_CONTENT, SUMMARY_DESC summaryDesc  FROM CA_CHART_SUMM_HEADER CSH,CA_CHART_SUMM_DETAIL CSD,CA_CHART_SUMM_CONTENT CSCN WHERE CSH.SUMMARY_ID=CSD.SUMMARY_ID AND CSD.CONTENT_ID=CSCN.CONTENT_ID AND CSH.SUMMARY_ID=? ORDER BY CSD.ROW_POS,CSD.COL_POS";
String strSql = "SELECT CSH.NO_OF_ROWS,CSH.NO_OF_COLS,CSD.ROW_POS,CSD.COL_POS,nvl(CSD.ROW_SPAN,'1') ROW_SPAN,nvl(CSD.COL_SPAN,'1') COL_SPAN,NVL(CSCN.CONTENT_USERDEF_DESC,CSCN.CONTENT_SYSDEF_DESC) TITLE_CONTENT, SUMMARY_DESC summaryDesc,CSCN.CONTENT_ID  FROM CA_CHART_SUMM_HEADER CSH,CA_CHART_SUMM_DETAIL CSD,CA_CHART_SUMM_CONTENT CSCN WHERE CSH.SUMMARY_ID=CSD.SUMMARY_ID AND CSD.CONTENT_ID=CSCN.CONTENT_ID AND CSH.SUMMARY_ID=? ORDER BY CSD.ROW_POS,CSD.COL_POS";
String stlyeSheetQry = "SELECT STYLE_SHEET,CONTENT_ID FROM CA_CHART_SUMM_STYLE_SHEET WHERE SUMMARY_ID=? AND PATIENT_CLASS=? AND SPECILITY_ID=? AND PRACTITIONER_ID=?";
int totalWidgets = 0;
String tempQuery = "INSERT INTO CA_WIDGET_STYLE1(CONTENT_ID, STYLE_SHEET) VALUES(?,?)";
String deleteQry = "DELETE FROM CA_WIDGET_STYLE1";
StringBuilder sblQry = new StringBuilder();
	sblQry.append("SELECT MODULE_ID,WIDGET_THEME_ICON_YN,WIDGET_THEME_YN,WIDGET_ICON_YN FROM CA_WIDGET_PARAM where MODULE_ID=? ");
//IN035950	Ends
%>
<!-- IN035950 Start-->
<SCRIPT>
async function showThemes(contentID,summaryId,patientClass,practitioner,speciality,titleContent,styleSheetName)
{
	
	var dialogHeight	= "500px" ;
	var dialogWidth		= "900px" ;
	var status			= "no";
	var scroll			= "YES";
	var dialogTop		= "100";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:"+ dialogTop + "; status:"+ status + "; scroll:"+ scroll;
	var queryString = "contentID="+contentID+"&summaryId="+summaryId+"&patClass="+patientClass+"&speciality="+speciality+"&practitioner="+practitioner+"&titleContent="+titleContent+"&styleSheetName="+styleSheetName;
	var retVal =await window.showModalDialog('ChartSummaryPersonalisedThemes.jsp?'+queryString,arguments,features);
	document.location.reload();
}
</SCRIPT>

<!-- IN035950 Ends-->
</HEAD>
<body onKeyDown="lockKey()">
<form name='assignChartSummaryPreview' id='assignChartSummaryPreview'>
<%
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(strSql);
		pstmt.setString(1,summaryId);
		rs = pstmt.executeQuery();
		while(rs.next()){
			summaryDesc= rs.getString("summaryDesc");
			totalRows = rs.getInt(1); //NO_OF_ROWS
			totalCols = rs.getInt(2);//NO_OF_COLS
			positionsList.add(rs.getString(3)); //ROW_POS
			positionsList.add(rs.getString(4)); //COL_POS
			positionsList.add(rs.getString(5)); //ROW_SPAN
			positionsList.add(rs.getString(6)); //COL_SPAN
			positionsList.add(rs.getString(7)); //TITLE_CONTENT
			positionsList.add("../../eCommon/html/blank.html"); //CONTENT_EXEC_NAME 	
			positionsList.add(rs.getString("CONTENT_ID")); //CONTENT_ID		
			totalWidgets++;//IN035950
		}
		if(totalRows ==0){
			out.flush();
			return;
		}
		widthPerCell = 100/totalCols;
		heightPerCell = 100/totalRows;
		tempExists = 0;
%>
<table width='100%' border=0 cellpadding ='3' align = "center" >
<tr>
<td height="10%"  class='label' colspan="<%=totalCols%>"><fmt:message key="eCA.ChartSummaryTemplatePreviewof.label" bundle="${ca_labels}"/> <b><%=summaryDesc%></b></td>
</tr>
</table>

<table width='100%' border=0 height='100%' cellpadding ='3' align = "center" >
	<%
		//IN035950 Starts
		HashMap styleMapDB=new HashMap();
		String styleSheetDB ="";
		HashMap sessionStyleMap = new HashMap();
		String styleSheetSession = "";
		String themeIcon="";
		String widgetThemeIconIndicator="";
		String widgetThemeIndicator="";
		String widgetIconIndicator="";
			
				try
				{
				pstmt = con.prepareStatement(sblQry.toString());
				pstmt.setString(1,"CA");
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					widgetThemeIconIndicator = rs.getString("WIDGET_THEME_ICON_YN");
					widgetThemeIndicator = rs.getString("WIDGET_THEME_YN");
					widgetIconIndicator = rs.getString("WIDGET_ICON_YN");
				}
				
				pstmt = con.prepareStatement(stlyeSheetQry);
				pstmt.setString(1,summaryId);
				pstmt.setString(2,patientClass);
				pstmt.setString(3,speciality);
				pstmt.setString(4,practitioner);
				rs = pstmt.executeQuery();
				
				sessionStyleMap =	(HashMap) session.getAttribute("allStyles");
				while(rs.next())
				{
					styleMapDB.put("PREFERRED_STYLE_WIDGET"+rs.getString("CONTENT_ID"),rs.getString("STYLE_SHEET"));
				}	
					if(null!= sessionStyleMap && !sessionStyleMap.isEmpty())
					{
						for(int i=0;i<positionsList.size();i+=7)//IN035950 Starts
						{
							
							if(!styleMapDB.containsKey("PREFERRED_STYLE_WIDGET"+(String)positionsList.get(i+6)))
							{
								styleSheetSession=	(String)sessionStyleMap.get("PREFERRED_STYLE_WIDGET"+(String)positionsList.get(i+6));
								
								if(null!=styleSheetSession && !"".equals(styleSheetSession))
								{
									styleMapDB.put("PREFERRED_STYLE_WIDGET"+(String)positionsList.get(i+6),styleSheetSession);
								}
								/*else
								{
									styleMapDB.put("PREFERRED_STYLE_WIDGET"+(String)positionsList.get(i),sStyle);
								}*/
							}
							else
							{
								//styleSheetDB = (String)styleMapDB.get("PREFERRED_STYLE_WIDGET"+(String)positionsList.get(i+6));//commented for IN072852 
								styleSheetSession=	(String)sessionStyleMap.get("PREFERRED_STYLE_WIDGET"+(String)positionsList.get(i+6));
								/*if(null!=styleSheetDB && styleSheetDB.equals(styleSheetSession))
								{
								System.out.println("AssignChartSummPreview.jsp:Line153:styleSheetSession"+styleSheetSession);
								styleMapDB.put("PREFERRED_STYLE_WIDGET"+(String)positionsList.get(i+6),styleSheetDB);
								}
								else if(null!=styleSheetDB && null!=styleSheetSession && !styleSheetDB.equals(styleSheetSession))
								{
									styleMapDB.put("PREFERRED_STYLE_WIDGET"+(String)positionsList.get(i+6),styleSheetSession);
								}*///commented for IN072852 
								styleMapDB.put("PREFERRED_STYLE_WIDGET"+(String)positionsList.get(i+6),styleSheetSession);//IN072852 
							}
						}
						
					}
					
					/*if(null!=styleSheetDB && !"".equals(styleSheetDB) && null!=styleSheetSession && !"".equals(styleSheetSession) && !styleSheetDB.equals(styleSheetSession))
					{
						styleMapDB.put("PREFERRED_STYLE_WIDGET"+rs.getString("CONTENT_ID"),styleSheetSession);
					}*/
					session.setAttribute("allStyles",styleMapDB);
					
					System.out.println("AssignChartSummPreview.jsp:Line137:"+session.getAttribute("allStyles"));
				
				}
				catch(Exception e)
				{
					//out.println("Error while getting the data Table--Exception in AssignChartSummPreview.jsp: "+e.toString());//COMMON-ICN-0181
					e.printStackTrace();
				}
				//IN035950 Ends
		for(int k=1;k<=totalRows;k++)
		{
			//for(int i=0;i<positionsList.size();i+=6)//IN035950
			for(int i=0;i<positionsList.size();i+=7)//IN035950
			{
				temp = Integer.parseInt((String)positionsList.get(i));
				
				if(k == temp)
				{
					tempExists++;
					
					if(tempRowId == 0)
						{
							out.println("<tr>");
							tempRowId = temp;// writes for first row
						}
						else
						{
							if(tempRowId != temp)
							{
								out.println("</tr><tr>");
							}
							tempRowId = temp;					
						}
					
						//IN035950 Starts
						content_id = (String)positionsList.get(i+6);
						HashMap styleMap = null;
						if(session.getAttribute("allStyles")!=null )
						{
							styleMap = (HashMap)session.getAttribute("allStyles");
							styleSheetName = (String) styleMap.get("PREFERRED_STYLE_WIDGET"+content_id);
						}
						
						if(!"null".equals(styleSheetName) && null!=styleSheetName && styleSheetName!="" && !"undefined".equals(styleSheetName) && "Y".equals(widgetThemeIconIndicator) && "Y".equals(widgetThemeIndicator))
						{
						out.println("<link rel='StyleSheet' href='../../eCommon/html/"+styleSheetName+"' type='text/css' />");
						}
						else
						{
						content_id="";
						out.println("<link rel='StyleSheet' href='../../eCommon/html/"+sStyle+"' type='text/css' />");
						styleSheetName=sStyle;
						}
						
						//IN035950 Ends
						//out.println("<td  colspan="+positionsList.get(i+3)+" rowspan="+positionsList.get(i+2)+" WIDTH='"+(widthPerCell*(Float.parseFloat((String)positionsList.get(i+3))))+"%' HEIGHT='"+(heightPerCell*(Float.parseFloat((String)positionsList.get(i+2))))+"%'><table width='100%' cellpadding ='3' align = 'center'><tr><td class='columnheader'>"+positionsList.get(i+4)+"</td></tr></table><iframe src='"+positionsList.get(i+5)+"' frameborder='0' scrolling='auto'  MARGINWIDTH='0px' MARGINHEIGHT='0px' width='100%' height='90%'  ></iframe></td>");//IN035950
						if("Y".equals(widgetThemeIconIndicator) && "Y".equals(widgetThemeIndicator)){
						themeIcon = "<a  href='javascript:showThemes(\""+positionsList.get(i+6)+"\",\""+summaryId+"\",\""+patientClass+"\",\""+practitioner+"\",\""+speciality+"\",\""+positionsList.get(i+4)+"\",\""+styleSheetName+"\");' title='Personalize Themes' style='text-decoration:underline;color=ffffff;text-align=right'><img  src='../../eCA/images/WidgetSettings.png' align='right'/></a>";
						}
						if(!sStyle.equals(styleSheetName))
						{
						out.println("<td  colspan="+positionsList.get(i+3)+" rowspan="+positionsList.get(i+2)+" WIDTH='"+(widthPerCell*(Float.parseFloat((String)positionsList.get(i+3))))+"%' HEIGHT='"+(heightPerCell*(Float.parseFloat((String)positionsList.get(i+2))))+"%'><table width='100%' cellpadding ='3' cellspacing='0' border='0' align = 'center'><tr><td class='COLUMNHEADERCENTERNEW"+content_id+"' nowrap>"+positionsList.get(i+4)+"</td><td class='COLUMNHEADERCENTERNEW"+content_id+"' nowrap>"+themeIcon+"</td></tr></table><iframe src='"+positionsList.get(i+5)+"' frameborder='0' scrolling='auto'  MARGINWIDTH='0px' MARGINHEIGHT='0px' width='100%' height='90vh'  ></iframe></td>");
						}
						else
						{
						out.println("<td  colspan="+positionsList.get(i+3)+" rowspan="+positionsList.get(i+2)+" WIDTH='"+(widthPerCell*(Float.parseFloat((String)positionsList.get(i+3))))+"%' HEIGHT='"+(heightPerCell*(Float.parseFloat((String)positionsList.get(i+2))))+"%'><table width='100%' cellpadding ='3' cellspacing='0' border='0' align = 'center'><tr><td class='COLUMNHEADERCENTERNEW' nowrap>"+positionsList.get(i+4)+"</td><td class='COLUMNHEADERCENTERNEW' nowrap>"+themeIcon+"</td></tr></table><iframe src='"+positionsList.get(i+5)+"' frameborder='0' scrolling='auto'  MARGINWIDTH='0px' MARGINHEIGHT='0px' width='100%' height='90vh'  ></iframe></td>");
						}
						
						out.println("<input type=hidden name='widgetName"+positionsList.get(i+6)+"' id='widgetName"+positionsList.get(i+6)+"' value=''>");//IN035950
						
				}
			styleSheetName="";//IN035950
			
			content_id="";//IN035950
		
			}
			if(tempExists == 0){
				out.println("<tr></tr>");
			}
			tempExists=0;
		}

}catch(Exception e){
	//out.println("Error while getting the display Table--Exception in AssignChartSummPreview.jsp: "+e.toString());//COMMON-ICN-0181
      e.printStackTrace();//COMMON-ICN-0181
}

finally{
	try{
		positionsList.clear();
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(con != null) ConnectionManager.returnConnection(con,request);
	}catch(Exception e){
		//out.println("Exception in AssignChartSummPreview.jsp: "+e.toString());//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
		
	}
}
%>
</tr>
</table>
</form><!--Niji-->
</BODY>
</HTML>



