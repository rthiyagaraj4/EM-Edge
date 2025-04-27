<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title>Summary Preview</title>
	<%
		request.setCharacterEncoding("UTF-8");
		String sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
/*		Properties p	= (Properties)session.getValue("jdbc");
		String locale	= (String) p.getProperty("LOCALE");*/
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />	
	<script src='../../eCA/js/CAMainMenu.js' language='javascript'></script>
	<script src='../../eCA/js/CASummaryMenu.js' language='javascript'></script>	
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>	
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 	
	<script>
	var obj;
	obj = new dTree('obj');
	obj.add('Summary','-1','<font size=1 style=font-weight:bold style=color:#000000>Summary</font>');
	obj.config.useStatusText=true;	
	</script>
</head>
<body  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<FORM METHOD=POST ACTION="" name="frmMenu" id="frmMenu">
<TABLE width='100%' border="0" align='center'>
<TR>
	<TD align='right' width='90%'><img src='../../eCommon/images/close-all.gif' onclick="changeTree(this)" id='toggleTreeCollapse' style='display' alt = 'Collapse All'></img>&nbsp;<img src='../../eCommon/images/expand-all.gif' onclick="changeTree(this)" id='toggleTreeExpand' style='display' alt = 'Expand All'></img></TD>
	<TD align='right' width='10%'><img src='../../eCA/images/MI_CloseT1.gif' onclick="window.close();" width="24" height="20" style='display' alt = 'Close'></img></TD>
	
</TR>
</TABLE>
<%
	Connection con = null;		
		
//		String pract_type =(String) session.getValue("practitioner_type") == null ? "" :(String)											session.getValue("practitioner_type");
	//	String practitioner_id=(String)request.getParameter("practitioner_id") == null ? "" :											(String)request.getParameter("practitioner_id");
		String desktop_summary_id=(String)request.getParameter("desktop_summary_id") == null ? "" :											(String)request.getParameter("desktop_summary_id");
		String facility_id=(String) session.getValue("facility_id");
		String Clin_id=(String)session.getValue("ca_practitioner_id");
		String User_id	=	(String)session.getValue("login_user");		
		String responsibility_id		= (String)session.getValue("responsibility_id");
		ArrayList arrList = new ArrayList();
		PreparedStatement pstmtComp = null,pstmtcnt=null;
		ResultSet rsComp = null,rscount=null;	
	
		String summaryHdr="";		
		String summarySubHrd="";	
		String prevsummaryHdr="";
		String sourceSQL="";
		String tempStr1 = "";				
		String tempStr = "";		
		//String totCount="0";
		String executable_name="";
//		StringBuffer sql=null,sql1=null;	
	//	String target="";
		
	try
	{
		con=ConnectionManager.getConnection(request);
				//pstmtComp = con.prepareStatement("SELECT C.SUMMARY_COMP_DESC,									A.SUMMARY_COMP_ID,H.SUMMARY_COMP_DESC HEAD_ID, A.HDR_SUMMARY_COMP_ID,DS.SOURCE_SQL,C.EXECUTABLE_NAME FROM  SM_DESKTOP_SUM_DTL A, SM_DESKTOP_SUM_COMP C, SM_DESKTOP_SUM_COMP H,SM_DATA_SOURCE DS WHERE a.DESKTOP_SUMMARY_ID='"+desktop_summary_id+"' and C.SUMMARY_COMP_ID=A.SUMMARY_COMP_ID   AND H.SUMMARY_COMP_ID=A.HDR_SUMMARY_COMP_ID   AND DS.SOURCE_ID(+)=C.SUMMARY_DATA_SOURCE_ID ORDER BY HEAD_ID");//common-icn-0180
				pstmtComp = con.prepareStatement("SELECT C.SUMMARY_COMP_DESC,									A.SUMMARY_COMP_ID,H.SUMMARY_COMP_DESC HEAD_ID, A.HDR_SUMMARY_COMP_ID,DS.SOURCE_SQL,C.EXECUTABLE_NAME FROM  SM_DESKTOP_SUM_DTL A, SM_DESKTOP_SUM_COMP C, SM_DESKTOP_SUM_COMP H,SM_DATA_SOURCE DS WHERE a.DESKTOP_SUMMARY_ID=? and C.SUMMARY_COMP_ID=A.SUMMARY_COMP_ID   AND H.SUMMARY_COMP_ID=A.HDR_SUMMARY_COMP_ID   AND DS.SOURCE_ID(+)=C.SUMMARY_DATA_SOURCE_ID ORDER BY HEAD_ID");//common-icn-0180
				
				pstmtComp.setString(1, desktop_summary_id);//common-icn-0180
				rsComp = pstmtComp.executeQuery();					
				while(rsComp.next()){	
						//totCount = "0";
						arrList.clear();
						summarySubHrd=rsComp.getString("SUMMARY_COMP_DESC");	
						summaryHdr=rsComp.getString("HEAD_ID");	
						sourceSQL=rsComp.getString("SOURCE_SQL")==null?"":rsComp.getString("SOURCE_SQL");	
						executable_name=rsComp.getString("EXECUTABLE_NAME")==null?"":rsComp.getString("EXECUTABLE_NAME");						
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
														
							}	
							rscount = pstmtcnt.executeQuery();
							if (rscount.next())
							{
								//totCount = rscount.getString(1);
							}

								if(rscount != null)
									rscount.close();
								if(pstmtcnt != null)
									pstmtcnt.close();							
						}						
						out.println("<script>");	
						if(!prevsummaryHdr.equals(summaryHdr)) 
						{
							out.println("obj.add('"+summaryHdr+"','Summary','<font size=1 style=font-weight:bold style=color:#000000>"+summaryHdr+"</font>');");							
							prevsummaryHdr = summaryHdr;
						}					
							out.println("obj.add('"+summarySubHrd+"','"+summaryHdr+"','"+summarySubHrd+" ')");				
						out.println("</script>");	
							
				}									
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
			//out.println("Exception in CAMainMenu.jsp"+e.toString());//COMMON-ICN-0181
              e.printStackTrace();//COMMON-ICN-0181
		}
	}
	%>		
	<script>		
	document.write(obj);
	obj.openAll();	
	</script>
</FORM>
</body>
</html>

