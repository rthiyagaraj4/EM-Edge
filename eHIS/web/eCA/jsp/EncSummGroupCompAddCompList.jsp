<!DOCTYPE html>
<!--
Created By: D. Sethuraman
-->
<%@ page language="java" import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	eCA.EncSummCompRecBean summRecCompBean = (eCA.EncSummCompRecBean)getObjectFromBean("summRecCompBean","eCA.EncSummCompRecBean",session);
%>
<html>
	<head>
		<title><fmt:message key="eCA.AttachedSectionsForType.label" bundle="${ca_labels}"/></title>
		<%			
			String sStyle =
			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			Properties p = (Properties)session.getValue("jdbc");
			String locale	= (String) p.getProperty("LOCALE");
			
			String groupFlag = request.getParameter("groupFlag") == null ? "" : request.getParameter("groupFlag");
			String groupType = request.getParameter("groupType") == null ? "" : request.getParameter("groupType");
			String groupCode = request.getParameter("groupCode") == null ? "" : request.getParameter("groupCode");				
			
			int gFlag = Integer.parseInt(request.getParameter("gFlag"));
			
			String searchGroupType = request.getParameter("searchGroupType") == null ? "" : request.getParameter("searchGroupType");
			String searchText = request.getParameter("searchText") == null ? "" : request.getParameter("searchText");
			
			String mode = request.getParameter("mode") == null ? "" : request.getParameter("mode");
			String flag = request.getParameter("flag") == null ? "1" : request.getParameter("flag");
			String flagTemp = request.getParameter("flagTemp") == null ? "1" : request.getParameter("flagTemp");
						
			String startString =  request.getParameter("start") == null ? "0" : request.getParameter("start");
			String endString =  request.getParameter("end") == null ? "5" : request.getParameter("end");
			String loadFirst =  request.getParameter("loadFirst") == null ? "" : request.getParameter("loadFirst");
			String tempRowIds =  request.getParameter("tempRowIds") == null ? "" : request.getParameter("tempRowIds");
			
			int countForNext = request.getParameter("countForNext") == null ? 1 : Integer.parseInt(request.getParameter("countForNext"));
			
			if(tempRowIds.indexOf("^") != -1)
			{
				for(int y=0;y<tempRowIds.length();y++)
					tempRowIds = tempRowIds.replace('^','+');
			}
			
			if(!tempRowIds.equals("")){
				tempRowIds = tempRowIds.substring(0,tempRowIds.length()-1);				
			}			
			
			int start = Integer.parseInt(startString);
			int end = Integer.parseInt(endString);

			int tempSeq = 0;
			int count = 0;
			int tempCount = 0;

			if(mode.equals("modify"))
				searchText = "";			

			String imgUrl="";
			if(sStyle.equals("IeStyle.css"))
	 		{
				imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 		}

		%> 
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language='javascript' src='../../eCA/js/EncSummGroupComp.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onscroll='scrollTitle()' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name = 'addNewCompForm'>			
			<% 
			if(!groupType.equals("") & !groupCode.equals(""))
			{				
			%>			
			<table cellpadding='0' cellspacing='0' border='0' width='100%' align='center'>
				<tr align='right'>
					 <td class='white' width='95%'></td> 
					<td  align='right' width='5%'nowrap>
						<a style='visibility:hidden' id='prevRecs' class='gridLink'  href="javascript:loadPrevNextRecs('prev')"><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>&nbsp;
						<a id='nextRecs' class='gridLink'  href="javascript:loadPrevNextRecs('next')"><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
					</td>
				</tr>
			</table>
			
			<table class='grid' id='display_result' style='visibility:visible' cellpadding='3' cellspacing='0' border='1' width='100%' align='center'>
				<tr id='trcoll'>
				<%
					if (gFlag == 0)
					{					
				%>
						<td class='COLUMNHEADERCENTER'><fmt:message key="Common.SubGroup.label" bundle="${common_labels}"/></td>
				<%
					}
					else
					{
				%>
						<td class='COLUMNHEADERCENTER'><fmt:message key="eCA.ComponentID.label" bundle="${ca_labels}"/></td>
				<%
					}
				%>
					<td class='COLUMNHEADERCENTER'><fmt:message key="eCA.ComponentDescription.label" bundle="${ca_labels}"/></td>
					<td class='COLUMNHEADERCENTER'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
				</tr>
				<%
					String component_ID = "";
					String component_Desc = "";					
					String exist_yn = "";
					String chkSelBox = "";
					String rowID = "";
					
					List<EncSummCompBean> oSummCompList = null;
					EncSummCompBean sCompBean = null;
					
					EncSummGroup summGrpDetails = new EncSummGroup();	
					
					int nCompListSize = 0;

					int cnt = 0;	
					
					if(!mode.equals("modify"))
					{
						ArrayList keyCodeForChk = summRecCompBean.retrieveRecords();
						
						try
						{	
							oSummCompList = new ArrayList<EncSummCompBean>();
							sCompBean = new EncSummCompBean();
							
							sCompBean.setRequest(request);
							sCompBean.setiGFlag(gFlag);
							sCompBean.setsHistTypeRec(groupType);
							sCompBean.setsSubGroupType(searchGroupType);
							sCompBean.setsGroupCode(groupCode);
							sCompBean.setsRowId(tempRowIds);
							sCompBean.setsSearchText(searchText);
							
							oSummCompList = summGrpDetails.getSummaryComps(sCompBean, locale, countForNext);		
							
							nCompListSize = oSummCompList.size();	
							
							for (int i=0;i<nCompListSize;i++){
								sCompBean = oSummCompList.get(i);
								component_ID = sCompBean.getsCompCode();
								component_Desc = sCompBean.getsLongDesc();							
								rowID = sCompBean.getsRowId();

								if(keyCodeForChk != null)
								{
									for(int n=0;n<keyCodeForChk.size();n++)
									{
										if(((String) keyCodeForChk.get(n)).equals(component_ID))
										{
											chkSelBox = " checked ";
											tempSeq = n;											
											n = keyCodeForChk.size();
										}
										else
											chkSelBox = "";										
									}
								}
								if(loadFirst.equals("Yes"))
								{
								%>
									<script>
										parent.parent.rowIDCompForEncSumm[<%=cnt%>] = '<%=rowID%>';
									</script>
								<%
								}
								if(cnt < 6)
								{								
									out.println("<tr>");
									out.println("<td class='gridData'  > "+component_ID+" </td>");
									out.println("<td class='gridData'  > "+component_Desc+" </td>");
									out.println("<td class='gridData'   align='center'> <input type='checkbox' name='secChk"+cnt+"' id='secChk"+cnt+"' "+chkSelBox+" onclick='addComponents(this,\""+gFlag+"\",\""+searchGroupType+"\",\""+component_ID+"\",\""+component_Desc+"\",\""+tempSeq+"\")'> </td>");
									out.println("</tr>");
								}
	
								cnt++;
								
								summRecCompBean.addFrameRecords(component_ID,component_Desc);
							}
							count = cnt;
							if(loadFirst.equals("Yes"))
							{
								tempCount = cnt;
							}
							else
							{
								tempCount = request.getParameter("totalCount") == null ? 0 : Integer.parseInt(request.getParameter("totalCount"));
							}
							putObjectInBean("summRecCompBean",summRecCompBean,session);	
							if(cnt == 0)
							{
								%>
								<script>
									document.getElementById("nextRecs").style.visibility = 'hidden';
									document.getElementById("prevRecs").style.visibility = 'hidden';
								</script>
								<%
								out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
							}							
						}
						catch(Exception e)
						{
							//out.println("Exception in try of EncSummGroupCompAddCompList.jsp"+e.toString());//COMMON-ICN-0181 
							e.printStackTrace();
						}
						
					}	
					else if(mode.equals("modify"))
					{
						String keyCode = "";
						String keyValSec = "";						
						String chk_sel = "";
						String codeList = "";

						int k = 0;
						int i = 0;
						ArrayList list = summRecCompBean.retrieveArrayList();
						
						try
						{
							ArrayList keys = summRecCompBean.retrieveHashRecords();
							ArrayList keySection = summRecCompBean.retrieveRecords();

							HashMap recValues = summRecCompBean.getHashRecordValues();

							for(i=0; i<keys.size(); i++)
							{
								keyCode = (String)keys.get(i);
								component_Desc = (String)recValues.get(keyCode);

								for(int j=0; j<keySection.size(); j++)
								{
									keyValSec = (String)keySection.get(j);

									if(keyCode.equals(keyValSec))
									{
										chk_sel = " checked ";
										for(k=0;k<list.size();k++)
										{
											codeList = (String) list.get(k);
											if(codeList.equals(keyCode))
											{
												tempSeq = k;
												k = list.size();
											}
										}
										j = keySection.size();
									}
									else
										chk_sel = "";
								}

								if(i < 5)
								{									
									out.println("<tr>");
									out.println("<td class='gridData'   > "+keyCode+" </td>");
									out.println("<td class='gridData'   > "+component_Desc+" </td>");
									out.println("<td class='gridData'   align='center'> <input type='checkbox'   "+chk_sel+" onclick='addComponents(this,\""+keyCode+"\",\""+component_Desc+"\",\""+tempSeq+"\")'> </td>");
									out.println("</tr>");
								}
							}
							count = i;
						}
						catch(Exception e)
						{
							//out.println("Exception in try of EncSummGroupCompAddCompList.jsp "+e.toString());//COMMON-ICN-0181
							e.printStackTrace();
						}
					}
					
				%>
			</table>
			

			<script>				
				var tempVar = <%=tempCount%> / 5;
				if(<%=start%> == 0)
					document.getElementById("prevRecs").style.visibility = 'hidden';
				else
					document.getElementById("prevRecs").style.visibility = 'visible';
			
				if(<%=count%> < 5 || <%=countForNext%> == tempVar)
					document.getElementById("nextRecs").style.visibility = 'hidden';
				else
					document.getElementById("nextRecs").style.visibility = 'visible';
			</script>
			<%}%>
			<input type='hidden' name='from' id='from' value='<%=start%>'>
			<input type='hidden' name='to' id='to' value='<%=end%>'>
			<input type='hidden' name='searchText' id='searchText' value='<%=searchText%>'>
			<input type='hidden' name='searchGroupType' id='searchGroupType' value='<%=searchGroupType%>'>
			<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
			<input type='hidden' name='flag' id='flag' value='<%=flag%>'>
			<input type='hidden' name='groupFlag' id='groupFlag' value='<%=groupFlag%>'>
			<input type='hidden' name='groupType' id='groupType' value='<%=groupType%>'>
			<input type='hidden' name='groupCode' id='groupCode' value='<%=groupCode%>'>
			<input type='hidden' name='gFlag' id='gFlag' value='<%=gFlag%>'>
			<input type='hidden' name='totalCount' id='totalCount' value='<%=tempCount%>'>
			<input type='hidden' name='countForNext' id='countForNext' value='<%=countForNext%>'>
		</form>
		
	</body>
</html>

