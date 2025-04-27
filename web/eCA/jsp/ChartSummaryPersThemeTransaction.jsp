<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?       created
12/02/2013		CHL_CRF		Nijitha		CHL_CRF - File Added and Changes as part of Default and Personlised themes to be applied for All widgets								 
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<% 	request.setCharacterEncoding("UTF-8");	%>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String modifiedById= "";
String modifiedAtWorkstation="";
String client_ip_address= "";
HttpSession sess = request.getSession(false);
java.util.Properties p = (java.util.Properties) sess.getValue( "jdbc" ) ;
modifiedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;  
client_ip_address = p.getProperty("client_ip_address");         
modifiedAtWorkstation   = (client_ip_address==null)?"":client_ip_address;        

String facilityId = (String)session.getValue("facility_id") == null ? "" : (String)session.getValue("facility_id");
String contentID = request.getParameter("contentID");
if(contentID == null || contentID.equals("") || "undefined".equals(contentID)) contentID = "";
String summaryId = request.getParameter("summaryId");
if(summaryId == null || summaryId.equals("")) summaryId = "";
String patientClass = request.getParameter("patientClass");
if(patientClass == null || patientClass.equals("") || "undefined".equals(patientClass)) patientClass = "";
String speciality = request.getParameter("speciality");
if(speciality == null || speciality.equals("") || "undefined".equals(speciality)) speciality = "";
String practitioner = request.getParameter("practitioner");
if(practitioner == null || practitioner.equals("") || "undefined".equals(practitioner)) practitioner = "";
String persStyleSheet = request.getParameter("personalizeTheme");
if(persStyleSheet == null || persStyleSheet.equals("") ) persStyleSheet = "";
String applyToAllWidget = request.getParameter("applyToAllWidget");
if(applyToAllWidget == null || applyToAllWidget.equals("") ) applyToAllWidget = "";
String recordInserted = "";
String requestFor = request.getParameter("requestFor");
String count="";
int totalWidget = 0;
HashMap hashMap=null;
Connection con=null;
PreparedStatement pstmt=null;
ResultSet rs = null;
String style_sheet_id="";
String style_sheet_name="";
String strSql = "SELECT CSH.NO_OF_ROWS,CSH.NO_OF_COLS,CSD.ROW_POS,CSD.COL_POS,nvl(CSD.ROW_SPAN,'1') ROW_SPAN,nvl(CSD.COL_SPAN,'1') COL_SPAN,NVL(CSCN.CONTENT_USERDEF_DESC,CSCN.CONTENT_SYSDEF_DESC) TITLE_CONTENT, SUMMARY_DESC summaryDesc,CSCN.CONTENT_ID  FROM CA_CHART_SUMM_HEADER CSH,CA_CHART_SUMM_DETAIL CSD,CA_CHART_SUMM_CONTENT CSCN WHERE CSH.SUMMARY_ID=CSD.SUMMARY_ID AND CSD.CONTENT_ID=CSCN.CONTENT_ID AND CSH.SUMMARY_ID=? ORDER BY CSD.ROW_POS,CSD.COL_POS";
StringBuilder styleSheetIDQry = new StringBuilder();
styleSheetIDQry.append("select style_sheet_id from CA_WIDGET_STYLE_SHEET where style_sheet =?");
String styleSheetQuery = "SELECT STYLE_SHEET FROM CA_WIDGET_STYLE_SHEET WHERE CONTENT_ID=? AND STYLE_SHEET_ID=? ";
%>

<%try

{
			con =ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(styleSheetIDQry.toString());
			pstmt.setString(1,persStyleSheet);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				style_sheet_id =rs.getString("style_sheet_id");
			}
			
			if(!"Y".equals(applyToAllWidget))
			{
				if(session.getAttribute("allStyles")!=null)
				{
					hashMap = (HashMap)session.getAttribute("allStyles");
					hashMap.put("PREFERRED_STYLE_WIDGET"+contentID, persStyleSheet);
					session.setAttribute("allStyles", hashMap);
					
				}
				else
				{
					hashMap = new HashMap();
					hashMap.put("PREFERRED_STYLE_WIDGET"+contentID, persStyleSheet);
					session.setAttribute("allStyles", hashMap);
					
				}
			}
			else
			{
				ArrayList positionsList = new ArrayList();
				pstmt = con.prepareStatement(strSql);
				pstmt.setString(1,summaryId);
				rs = pstmt.executeQuery();
				while(rs.next())
				{	
					positionsList.add(rs.getString("CONTENT_ID")); //CONTENT_ID		
				}
					
					for (int i = 0; i < positionsList.size(); i++) 
					{
						pstmt = con.prepareStatement(styleSheetQuery);
						pstmt.setString(1,(String)positionsList.get(i));
						pstmt.setString(2,style_sheet_id);
						rs = pstmt.executeQuery();
						while(rs.next())
						{	
							style_sheet_name =	rs.getString("STYLE_SHEET");		
						}
						if(session.getAttribute("allStyles")!=null)
						{
							hashMap = (HashMap)session.getAttribute("allStyles");
							hashMap.put("PREFERRED_STYLE_WIDGET"+(String)positionsList.get(i), style_sheet_name);
							session.setAttribute("allStyles", hashMap);
							
						}
						else
						{
							hashMap = new HashMap();
							hashMap.put("PREFERRED_STYLE_WIDGET"+(String)positionsList.get(i), style_sheet_name);
							session.setAttribute("allStyles", hashMap);
							
						}
						
					}
			}
		
		pstmt.close();
		rs.close();
	
	}
	catch(Exception e)
	{
	//	out.println("Exception in ChartSummaryPersThemeTransaction.jsp: "+e.toString());//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		if(con != null)ConnectionManager.returnConnection(con,request);
	} 
%>

