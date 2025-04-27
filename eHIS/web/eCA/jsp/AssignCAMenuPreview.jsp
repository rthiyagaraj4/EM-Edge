<!DOCTYPE html>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
10/07/2013		IN043597		Nijitha			Alpha-CA-Blank Menu displayed when patient chart Menu is selected at Assign CA Menu.   								 
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		String dfltFunctionId = request.getParameter("dfltFunctionId") == null ? "" : request.getParameter("dfltFunctionId");
		
		String homeValue= (String)request.getParameter("homepage") == null ? "" : (String)request.getParameter("homepage");
		
		String MenuPreviewPage=request.getParameter("MenuPreviewPage") == null ? "" : request.getParameter("MenuPreviewPage");//IN036733

		String styleMap = "";
		if(sStyle.equals("IeStyleBlue.css"))
		{
			styleMap = "Blue";
		}
		else if(sStyle.equals("IeStyleLime.css"))
		{
			styleMap = "Lime";
		}
		else if(sStyle.equals("IeStyleOrange.css"))
		{
			styleMap = "Orange";
		}
		else if(sStyle.equals("IeStyleVoilet.css"))
		{
			styleMap = "Violet";
		}
		else
		{
			styleMap = "";
		}

	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script src='../../eCA/js/CAMainMenu.js' language='javascript'></script>
	<script src='../../eCA/js/CAMenu.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>	
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 

	<STYLE>

	

	</STYLE>
	
</head>
<%
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	
	int counter = 0,totalRecords = 0;
	String function_type="";
	String currentPosition="",nodePoistions="",toolTips="",defaultUrl="",currentToolTip="",function_id="",function_name="";
	StringBuffer detl_sql = new StringBuffer();
	String option_id = "",header_option_id="",option_desc="";
	
	String executable_name = "",option_type="", only_option_id ="";
	String respid="",relationcode="",facilityid="";
	PreparedStatement pstmt = null,pstmtMenu=null;
	Connection con = null;
	ResultSet rs = null,rsMenu=null;
	String queryString = request.getQueryString()== null?"":request.getQueryString() ; 

	String patient_id = request.getParameter("patient_id");
	String episode_id = request.getParameter("episode_id");
	String limit_function_id = request.getParameter("limit_function_id") == null? "" : request.getParameter("limit_function_id");
	String ConsOrdChartYn = request.getParameter("ConsOrdChartYn") == null ? "N" : request.getParameter("ConsOrdChartYn");
	String mode = request.getParameter("mode")==null?"V":request.getParameter("mode");
	if (!limit_function_id.equals(""))
		mode="R";
	respid = (String) session.getValue("responsibility_id");
	if(respid == null) respid="";
	boolean pat_sel = false ;
	if( patient_id!=null || episode_id != null )
		pat_sel = true;
	if(patient_id == null) patient_id="";
	if(episode_id == null) episode_id="";
	String practitioner_id = (String)session.getValue("ca_practitioner_id");


	facilityid = (String)session.getValue("facility_id");

	relationcode = request.getParameter("relationship_id");

	if(relationcode == null) relationcode = "";
	String menu_short_desc = "";
	boolean Self_menu_exists = false;
	String default_yn = "", icon_file_name = "";
	String pre_header_option_id = "";
	StringBuffer icons = new StringBuffer("");
	int k = 0;

	StringBuffer strOption = new StringBuffer();

	
	String speciality_code = request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");
	String menu_id = request.getParameter("menuId")==null?"MED_DFLT":request.getParameter("menuId");
	
%>
<body  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">

<FORM METHOD=POST ACTION="" name="frmMenu" id="frmMenu">
<TABLE width='100%' align='center'>
<TR>
	<td width='13%'></td><td align='right' id = 'exp_collapse_img'><IMG SRC="../../eCommon/images/close-all.gif" style="cursor:pointer"	 BORDER='0' ALT='<fmt:message key="Common.closeAll.label" bundle="${common_labels}"/>' id='toggleTreeCollapse' onClick="javascript:changeTree(this);"></td>
	
</TR>
</TABLE>

<script>
	var obj;
	obj = new dTree('obj');
	
		

<%

	try
	{
		StringBuffer desktopynQry = new StringBuffer();
		StringBuffer qry = new StringBuffer();
		int count=0;
		String desktopYN = "";
		String patientChartYN = "";
		con = ConnectionManager.getConnection(request);
		
		desktopynQry.append("SELECt DESKTOP_YN,PATIENT_CHART_YN FROM CA_MENU_HEADER WHERE MENU_ID=? ");
		pstmt = con.prepareStatement(desktopynQry.toString());
		
		pstmt.setString(1,menu_id);
		rs = pstmt.executeQuery();
		if(rs.next())
		{
			desktopYN = rs.getString("DESKTOP_YN");
			patientChartYN = rs.getString("PATIENT_CHART_YN");
		}
		
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		
		qry.append("SELECt count(*) FROM CA_MENU_DETAIL WHERE MENU_ID=? and DESKTOP_CHART='D'");
		pstmt = con.prepareStatement(qry.toString());
		
		pstmt.setString(1,menu_id);
		rs = pstmt.executeQuery();
		if(rs.next())
		{
			count = rs.getInt(1);
			
		}
		
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

		strOption.append("SELECT '1' FROM ca_custom_option a WHERE practitioner_id = ? and exists (select '1' from ca_option where option_id = a.option_id ");
		if(desktopYN.equals("Y"))
		{
			strOption.append(" AND DESKTOP_YN = 'Y' )" );
		}
		else
		{
			strOption.append(" AND DESKTOP_YN = 'N' )");
		}
 		pstmt = con.prepareStatement(strOption.toString());
		pstmt.setString(1,practitioner_id);
		rs = pstmt.executeQuery();

		
		if(rs.next())
		{
			Self_menu_exists = true;
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		

		if(detl_sql.length() > 0) detl_sql.delete(0,detl_sql.length());

		
		detl_sql.append(" SELECT    DISTINCT  B.OPTION_ID||B.OPTION_OCCURANCE OPTION_ID  , B.OPTION_ID ONLY_OPTION_ID, NVL(NVL(NVL(C.user_def_short_desc_legend ,C.USER_DEF_SHORT_DESC), C.SHORT_DESC),(SELECT SHORT_DESC FROM CA_MENU_HEADER WHERE MENU_ID=b.OPTION_ID)) OPTION_DESC  , NVL(NVL(C.USER_DEF_LONG_DESC,C.LONG_DESC) ,(SELECT LONG_DESC FROM CA_MENU_HEADER WHERE MENU_ID=b.OPTION_ID)) FUNCTION_NAME  ,'H' MENU_POSITION  , NVL(C.OPTION_TYPE,'M') OPTION_TYPE  , C.EXECUTABLE_NAME  , DECODE(?, a.HEADER_OPTION_ID,'0', a.HEADER_OPTION_ID||B.HEADER_OPTION_OCCURANCE) HEADER_OPTION_ID  , a.ORDER_SEQ_NO  , nvl(C.OPEN_IN_MODAL_WINDOW_YN,'N') OPEN_IN_MODAL_WINDOW_YN   , C.HIST_OR_RECORD ");//IN035914
		if(Self_menu_exists)
			detl_sql.append(" , NVL((SELECT 'Y' FROM ca_custom_option WHERE PRACTITIONER_ID = ? AND OPTION_ID = B.OPTION_ID ),'N') default_yn ");
		else
			detl_sql.append("  , C.Dflt_toolbar_option_yn default_yn ");

		detl_sql.append(" , C.ICON_FILE_NAME FROM  ( SELECT LEVEL LVL,OPTION_ID,ORDER_SEQ_NO,HEADER_OPTION_ID ,HEADER_OPTION_OCCURANCE,OPTION_OCCURANCE   FROM CA_MENU_DETAIL   WHERE MENU_ID=?  ");

		if (desktopYN.equals("Y") && patientChartYN.equals("Y") && count>0)
		{
			detl_sql.append(" AND DESKTOP_CHART = 'D' ");
		}
		else if(patientChartYN.equals("Y") || desktopYN.equals("N"))
		{
			detl_sql.append(" AND DESKTOP_CHART = 'P' " );
		}
		else if (desktopYN.equals("Y") || patientChartYN.equals("N"))
		{
			detl_sql.append(" AND DESKTOP_CHART = 'D' ");
		}
		
		detl_sql.append(" START WITH HEADER_OPTION_ID=? and HEADER_OPTION_OCCURANCE=1 " );

		if (desktopYN.equals("Y") && patientChartYN.equals("Y") && count>0)
		{
			detl_sql.append(" AND DESKTOP_CHART = 'D' ");
		}
		else if(patientChartYN.equals("Y") || desktopYN.equals("N"))
		{
			detl_sql.append(" AND DESKTOP_CHART = 'P' " );
		}
		else if (desktopYN.equals("Y") || patientChartYN.equals("N"))
		{
			detl_sql.append(" AND DESKTOP_CHART = 'D' ");
		}

		detl_sql.append(" CONNECT BY PRIOR  OPTION_ID=HEADER_OPTION_ID AND  OPTION_OCCURANCE=HEADER_OPTION_OCCURANCE) A  ,(SELECT  DISTINCT OPTION_ID,HEADER_OPTION_ID,HEADER_OPTION_OCCURANCE,OPTION_OCCURANCE FROM CA_MENU_DETAIL  WHERE MENU_ID=? "); 
		if(desktopYN.equals("N"))
		{
			detl_sql.append(" AND DESKTOP_CHART = 'P' " ); 
			if((eCA._ca_license_rights.getKey()).equals("CABASIC"))
				detl_sql.append(" AND OPTION_ID not in ( 'CLINICAL_NOTES' ,'CLINICAL_NOTES_NEW','PATCHIEFCOMPLAINT','REL_PAT_TREAT_PAT','CA_TASK_LIST','CA_TASK_LIST_DT')" );
			if(!limit_function_id.equals(""))
				detl_sql.append(" AND OPTION_ID = ? ");
		}
		else
		{
			if((eCA._ca_license_rights.getKey()).equals("CABASIC"))
				detl_sql.append(" AND OPTION_ID not in ( 'CA_TASK_LIST','REL_PAT_TREAT','CA_TASK_LIST_DT')" );
			if(count>0)
			{
				detl_sql.append(" AND DESKTOP_CHART = 'D' ");
			}
			else
			{
				detl_sql.append(" AND DESKTOP_CHART = 'P' ");
			}
		}
		detl_sql.append(" START WITH MENU_ID=? AND ");
		if(desktopYN.equals("N"))
		{
			detl_sql.append(" DESKTOP_CHART = 'P' " );
		}
		else
		{
			if(count>0)
			{
				detl_sql.append("  DESKTOP_CHART = 'D' ");
			}
			else
			{
				detl_sql.append("  DESKTOP_CHART = 'P' ");
			}
		}
		detl_sql.append(" AND OPTION_ID IN (SELECT B.OPTION_ID FROM CA_APPL_TASK a, ca_option b WHERE a.option_id=b.option_id and 'A'=Get_Task_Applicability(APPL_TASK_ID,DFLT_PRIVILEGE_STATUS ,?,?,?,?,?) and (a.BASE_MODULE_ID='CA' or  exists( select 1 from sm_module where install_yn='Y' and MODULE_ID =a.BASE_MODULE_ID ");
	

		detl_sql.append(" )) "); 
		
		
		try
		{			
			String qry_menu_short_desc = "SELECT CA_GET_DESC.CA_MENU_HEADER(?,?,'2') SHORT_DESC FROM DUAL";
			pstmtMenu = con.prepareStatement(qry_menu_short_desc);
			pstmtMenu.setString(1, menu_id);
			pstmtMenu.setString(2, locale);
			rsMenu = pstmtMenu.executeQuery();
			
			while(rsMenu.next())
			{				
				menu_short_desc = rsMenu.getString("SHORT_DESC") ;
			}
			if(rsMenu!=null) rsMenu.close();
			if(pstmtMenu!=null) pstmtMenu.close();
		
		}
		catch(Exception e)
		{
			//out.println(e.getMessage());//COMMON-ICN-0181
                        e.printStackTrace();//COMMON-ICN-0181
		}

		if (menu_id.equals("MED_DFLT"))
		{
			if (desktopYN.equals("Y") || patientChartYN.equals("N"))
			{%>				
				obj.add(0,-1,'<font size=2 style=font-weight:bold style=color:#333>'+getLabel("eCA.Desktop.label","CA")+'</font>');
				obj.config.useStatusText=true;
			<%}
			else 
			{%>
				obj.add(0,-1,'<font size=2 style=font-weight:bold style=color:#333>'+getLabel("Common.patientchart.label","Common")+'</font>');
				obj.config.useStatusText=true;
		<%	}
		}
		else 
		{
			if (desktopYN.equals("Y") || patientChartYN.equals("N"))
			{
			%>				
				obj.add(0,-1,'<font size=2 style=font-weight:bold style=color:#333>'+getLabel("eCA.Desktop.label","CA")+'-(<%=menu_short_desc%>) </font>');
				obj.config.useStatusText=true;	
			<%}
			else 
			{%>
				obj.add(0,-1,'<font size=2 style=font-weight:bold style=color:#333>'+getLabel("Common.patientchart.label","Common")+'-(<%=menu_short_desc%>) </font>');
				obj.config.useStatusText=true;
			<%}			   
		}
		if (desktopYN.equals("Y") || patientChartYN.equals("N") )
		{
		    if(count>0)
		    {
				detl_sql.append(" and b.DESKTOP_YN='Y' ");
		    }
		    else
		    {
		    	detl_sql.append(" and b.DESKTOP_YN='N' ");
		    }
		}
		

		detl_sql.append(" ) "); 

		if(desktopYN.equals("N") )
		{
			detl_sql.append(" AND DESKTOP_CHART = 'P' " );
		}
		else
		{
			if(count>0)
			{
				detl_sql.append(" AND DESKTOP_CHART = 'D' ");
			}
			else
			{
				detl_sql.append(" AND DESKTOP_CHART = 'P' ");
			}
		}

		detl_sql.append("  CONNECT BY PRIOR  HEADER_OPTION_ID =OPTION_ID and HEADER_OPTION_OCCURANCE=OPTION_OCCURANCE ) B   , CA_OPTION_LANG_VW C   WHERE C.LANGUAGE_ID = ?  AND A.OPTION_ID=B.OPTION_ID AND A.HEADER_OPTION_ID=B.HEADER_OPTION_ID AND A.HEADER_OPTION_OCCURANCE=B.HEADER_OPTION_OCCURANCE AND A.OPTION_OCCURANCE=B.OPTION_OCCURANCE AND C.OPTION_ID(+)=B.OPTION_ID   ORDER BY A.ORDER_SEQ_NO ");


		
		pstmt = con.prepareStatement(detl_sql.toString());
		int indval =1;
		pstmt.setString(indval++,menu_id);
		if(Self_menu_exists)
			pstmt.setString(indval++,practitioner_id);
		pstmt.setString(indval++,menu_id);
		pstmt.setString(indval++,menu_id);
		pstmt.setString(indval++,menu_id);
		if(!limit_function_id.equals(""))
		{
			pstmt.setString(indval++,limit_function_id);
		}
		pstmt.setString(indval++,menu_id);
		pstmt.setString(indval++,respid);
		pstmt.setString(indval++,relationcode);
		pstmt.setString(indval++,facilityid);
		pstmt.setString(indval++,episode_id);
		pstmt.setString(indval++,patient_id);
		if(pat_sel )
		{
			pstmt.setString(indval++,speciality_code);
		}
		pstmt.setString(indval++,locale);
		
		rs = pstmt.executeQuery();

		

		icons.append("<table border='0' align='left' cellpadding='0' cellspacing='0'><tr class='iconBarRow"+styleMap+"'>");
		if(rs != null)
		{
			while(rs.next())
			{
				option_id = rs.getString("OPTION_ID");
				header_option_id = rs.getString("HEADER_OPTION_ID");
				option_desc = rs.getString("OPTION_DESC");
				executable_name = rs.getString("EXECUTABLE_NAME");
				//IN036733 Starts
				if("MenuPreviewPage".equals(MenuPreviewPage))
				{
					executable_name = "";
				}
				//IN036733 Ends
				function_name = rs.getString("FUNCTION_NAME");
				function_type= rs.getString("HIST_OR_RECORD");
				option_type = rs.getString("OPTION_TYPE");
				only_option_id = rs.getString("ONLY_OPTION_ID");
				if(executable_name == null||option_type.equals("M")) executable_name="";
			
				if(function_name == null) function_name="";
				//out.println("alert('only_option_id=="+only_option_id+"')");		
				counter++;
				if(executable_name != "")
				{
					if(executable_name.indexOf("?") != -1)
					{
						executable_name=executable_name + "&option_id="+only_option_id;
					}
					else
					{
						executable_name=executable_name+"?"+"option_id="+only_option_id;
					}
					if (pat_sel)
						executable_name=executable_name +"&"+queryString+"&Patient_ID="+patient_id;
					if (defaultUrl.equals(""))
					{
						defaultUrl=executable_name;
						currentPosition = "1";
						currentToolTip = function_name;
						function_id = only_option_id;
					}
				}
				if (dfltFunctionId.equals(only_option_id))
				{
					defaultUrl=executable_name;
					currentPosition = "1";
					currentToolTip = "User Home - "+function_name;
					function_id = only_option_id;
				}

		%>

		<%	
				if(!function_type.equals("R"))
					option_desc = option_desc + " (V)";
				
				if(option_type.equals("M"))
				{ 
		%>
					obj.add('<%=option_id%>','<%=header_option_id%>','<font style="font-weight:bold"><%=option_desc%></font>','','<%=function_name%>','','','','','<%=function_type%>','<%=only_option_id%>');
						

			<%
				}//font-size:8pt
				else
				{
					totalRecords++;
					//toolTips=toolTips+"$"+function_name;
					//urls =urls + "$"+executable_name;
					//nodePoistions =nodePoistions +"$"+counter;
				
			%>
				obj.add('<%=option_id%>','<%=header_option_id%>','<font style:color:><%=option_desc%></font>','<%=executable_name%>','<%=function_name%>','workAreaFrame','','','','<%=function_type%>','<%=only_option_id%>');
					
			<%
				}
				default_yn = rs.getString("default_yn");
				if(default_yn.equals("Y"))
				{
					icon_file_name = rs.getString("icon_file_name");
					if(k > 0)
					{
						if(header_option_id.equals(pre_header_option_id))
						{
							//icons.append("<td class='iconBar'><img class='imageClass' id='divider' src='../../eCA/images/MI_Divider.gif' alt='' ></img></td>");
						}
						else
						{
							icons.append("<td><img id='seperator' src='../../eCA/images/MI_GroupSeperator"+styleMap+".jpg' alt=''></img></td>");
						}
					}
					icons.append("<td><a href='#' class='imageClass1' name='"+function_name+"' onmouseover='hotStateImage(this)' onmouseout='restorePrevState(this)'><img src='../../eCA/images/"+icon_file_name+"' id='"+option_id+"' onclick=~callFunction('"+only_option_id+"','"+function_name+"','"+executable_name+"')~  alt='"+function_name+"' title='"+function_name+"'></img></a></td>");
					pre_header_option_id = header_option_id;
					k++;
				}
			%>
		<%
			}//end of rs.next()
			if(rs!= null) rs.close();
			if(pstmt!=null) pstmt.close();
		}
		else
		{
			icons.append("<td>&nbsp;</td>");
		}
		icons.append("</tr></table>");
		String finalString = icons.toString();

		%>
			if('<%=limit_function_id%>' == "")
			{
				if('<%=homeValue%>' == "home"){
					//alert();
					parent.parent.CommonToolbar.displayIcons("<%=finalString%>");
					//alert('<%=homeValue%>');
				}
				else{
				if(parent.CommonToolbar!=null)	//IN036733
				parent.CommonToolbar.displayIcons("<%=finalString%>");
				//parent.parent.CommonToolbar.displayIcons("<%=finalString%>");
				}
			}
		<%
		/*if(nodePoistions.length()>1)
		{
			nodePoistions = nodePoistions.substring(1);
			toolTips = toolTips.substring(1);
			urls = urls.substring(1);
			if(totalRecords == 1)
			{
				defaultUrl = urls;
				currentPosition = nodePoistions;
				currentToolTip = toolTips;
			}else
			{
				defaultUrl = urls.substring(0,urls.indexOf("$"));
				currentPosition = nodePoistions.substring(0,nodePoistions.indexOf("$"));
				currentToolTip = toolTips.substring(0,toolTips.indexOf("$"));
			}


		}*/
	}
	catch(Exception e)
	{
	//	out.println("Error while gettting the menu: "+e);//COMMON-ICN-0181
                   e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		try
		{
			if(rs!= null) rs.close();
			if(pstmt!=null) pstmt.close();
			
			if(con!= null) ConnectionManager.returnConnection(con,request);
		}
		catch(Exception e)
		{
			out.println("Exception in CAMainMenu.jsp"+e.toString());
		}
	}
	%>
</script>
	<input type="hidden" name="txtNodePoistions" id="txtNodePoistions" value="<%=nodePoistions%>">
	<input type='hidden' name='txtCurrentPosition' id='txtCurrentPosition' value='<%=currentPosition%>'>
	<input type='hidden' name='txtToolTips' id='txtToolTips' value='<%=toolTips%>'>
	<input type='hidden' name='matfrmval' id='matfrmval' value='0'>
	<input type='hidden' name='homepage' id='homepage' value="<%=homeValue%>">
	<input type='hidden' name='ConsOrdChartYn' id='ConsOrdChartYn' value="<%=ConsOrdChartYn%>">
	<script>
		if('<%=limit_function_id%>' == "")
		{		
			document.write(obj);
			obj.openAll();
		  if('<%=defaultUrl%>' != "")
  		  {
			parent.workAreaFrame.location.href='<%=defaultUrl%>';
			parent.CommonToolbar.displayFunctionName("<%=currentToolTip%>","<%=function_id%>");
			if ((parent.CommonToolbar.home != null)&&("<%=dfltFunctionId%>"==""))
     		  {
					//parent.CommonToolbar.home.style.display = 'none';
			
			  }

		  }
  		  else
		  {
				//alert("Testing RIS Issue");
				//IN036733 Starts
				/* alert(getMessage("FUNC_NOT_APPLICABLE","CA"))
				top.window.close(); */
				if(!"MenuPreviewPage"=="<%=MenuPreviewPage%>")
				{
				 alert(getMessage("FUNC_NOT_APPLICABLE","CA"))
				 top.window.close();
				}
				//IN036733 Ends
		  }
		}
		else
		{
			
			if('<%=executable_name%>' != "")
			{
				//parent.workArea.rows = "0%,*";
				parent.parent.workArea.rows = "6%,*";
				parent.CommonToolbar.displayFunctionName("<%=currentToolTip%>","<%=function_id%>");
				parent.workAreaFrame.location.href='<%=executable_name%>';
				
			}
			else
			{
				//IN036733 Starts
				/* alert(getMessage("FUNC_NOT_APPLICABLE","CA"))
				 top.window.close(); */
				if(!"MenuPreviewPage"=="<%=MenuPreviewPage%>")
				{
				 alert(getMessage("FUNC_NOT_APPLICABLE","CA"))
				 top.window.close();
				}
				//IN036733 Ends
			}

		}
	</script>
</FORM>
</body>
</html>

