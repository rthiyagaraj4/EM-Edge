<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History     Name      			Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
21/01/2019      IN067541        Sivabagyam M       21/01/2019       Ramesh G        ML-MMOH-CRF-1159
4/02/2019      IN069501        Sivabagyam M       4/02/2019       Ramesh G      CA-Common-Record Charts
---------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	Connection con = null;
	try
	{
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");

		con = ConnectionManager.getConnection(request);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	 
		String encounterId		=	request.getParameter("episode_id") == null ? "" : request.getParameter("episode_id");

		if(encounterId.equals("")) encounterId = "0";

		String detailDate		=	request.getParameter("detailDate") == null ? "" : request.getParameter("detailDate");
		String sort_by			=	request.getParameter("sort_by") == null ? "D" : request.getParameter("sort_by");
		String adm_date			=	request.getParameter("visit_adm_date") == null ? "" : request.getParameter("visit_adm_date");

		int daySummary = 0;
	
		if(request.getParameter("summaryText") == null || request.getParameter("summaryText").equals(""))
			daySummary = 0;
		else
			daySummary = Integer.parseInt(request.getParameter("summaryText"));

		if(daySummary == 0 && !sort_by.equals("A")) 
			adm_date = detailDate + " 00:00";
		else 
			adm_date = request.getParameter("visit_adm_date") == null ? "" : request.getParameter("visit_adm_date");

		String summaryYN		=	request.getParameter("summaryYN") == null ? "" : request.getParameter("summaryYN");
		String detailYN			=	request.getParameter("detailYN") == null ? "Y" : request.getParameter("detailYN");
	
		String facilityId		=	(String)session.getValue("facility_id") == null ? "" : (String)session.getValue("facility_id");
		String patientId		=	request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
		String chartId			=	request.getParameter("chartId") == null ? "" : request.getParameter("chartId");
		String fromDate			=	request.getParameter("fromDate") == null ? "" : request.getParameter("fromDate");
		String toDate			=	request.getParameter("toDate") == null ? "" : request.getParameter("toDate");
		
		String strSql= "",	chartName = "";
		String pline = "", patient_name = "";
		StringBuffer summaryVal = new StringBuffer();
		StringTokenizer token = null;

		HashMap grpList = new HashMap();
		HashMap discrList = new HashMap();
		HashMap finalHash = new HashMap();
		HashMap hash = new HashMap();
		
		fromDate				=	com.ehis.util.DateUtils.convertDate(fromDate,"DMYHM", locale,"en");
		toDate					=	com.ehis.util.DateUtils.convertDate(toDate,"DMYHM", locale,"en");

		try
		{
			if(encounterId.equals(""))
			{
				strSql="select get_patient.get_line_detail(?,?) Pline FROM dual";
			}
			else
			{
				strSql="select get_patient.get_line_detail(?,?,?) Pline FROM dual";
			}
			pstmt = con.prepareStatement(strSql);
			if(encounterId.equals(""))
			{
				pstmt.setString(1, patientId);
				pstmt.setString(2, locale);
			}else{
				pstmt.setString(1, facilityId);
				pstmt.setString(2, encounterId);
				pstmt.setString(3, locale);
			}
			rs = pstmt.executeQuery();
			while(rs.next()){
					pline = rs.getString(1);
				}

			if(pline != null)
			{
				token = new StringTokenizer(pline,"|");
				patient_name = token.nextToken();
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			
			strSql = "select a.SHORT_DESC from ca_chart_LANG_VW a where a.eff_status='E' and language_id = ? and chart_id = ?";
			pstmt = con.prepareStatement(strSql);
			pstmt.setString(1, locale);
			pstmt.setString(2, chartId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
					chartName = rs.getString(1);
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}
	
		catch(Exception e)
		{
			//out.println(" from Charting Recording List Population :"+e.toString());//common-icn-0181
			e.printStackTrace();
		}
		finally
		{
			if(pstmt!=null) pstmt.close();
			if(rs!=null) rs.close();
			if(con!=null)
				ConnectionManager.returnConnection(con,request);
		}
		finalHash = (HashMap)session.getValue("dataHash"+encounterId);
		ArrayList dates = (ArrayList)session.getValue("dateArray"+encounterId);
		HashMap hashData = (HashMap)session.getValue("chartEvents"+encounterId);
		ArrayList arrayChartGrp = (ArrayList)session.getValue("chartGrp"+encounterId);
		ArrayList arrayResultType = (ArrayList)session.getValue("arrayResultType"+encounterId);
		ArrayList arrList = (ArrayList)session.getValue("arrList"+encounterId);
		
		if(dates.size()>0)
		{
%>
	<html>
		<head>
		<title><%=chartName%></title>
<%
		
			String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		
		<script language="javascript" src="../../eCA/js/ChartRecording.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script Language="vbscript">
			Dim WSHShell
			Dim myHeader
			Dim myFooter
			Dim myMarginleft 
			Dim myMarginright 
			Set WSHShell = CreateObject("WScript.Shell")

			WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\header", "&bPage &p of &P"
			WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\footer", "&b&d"
			WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\margin_left", "0.5"
			WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\margin_right", "0.3"

  
		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



		<style>
			
			TD.CACHARTQRYEVEN {
				FONT-SIZE: 7PT ;
				BORDER-STYLE: THIN;
				BORDER-COLOR: black;
			}

			TD.CACHARTFOURTHLEVELCOLOR 
			{
				height: 3px;
				BORDER-COLOR: black;
			}

			TD.CRITICAL{
				FONT-SIZE: 7PT ;
				BORDER-STYLE: THIN;
				background-color:#D2B48C;
				BORDER-COLOR: black;
			}

			TD.ABNORMAL{
				FONT-SIZE: 7PT ;
				BORDER-STYLE: THIN;
				background-color:#FFF8DC;
				BORDER-COLOR: black;
			}
			TD.HIGH{
				FONT-SIZE: 7PT ;
				BORDER-STYLE: THIN;
				background-color:#FFDAB9
			}
			TD.LOW{
				FONT-SIZE: 7PT ;
				BORDER-STYLE: THIN;
				background-color:#F0FFFF;
				BORDER-COLOR: black;
			}
			TD.CRITICALLOW{
				FONT-SIZE: 7PT ;
				BORDER-STYLE: THIN;
				background-color:#D8BFD8;
				BORDER-COLOR: black;
			}
			TD.CRITICALHIGH{
				FONT-SIZE: 7PT ;
				BORDER-STYLE: THIN;
				background-color:#F4A460;
				BORDER-COLOR: black;
			}
			TD.DELTAFAIL{
				FONT-SIZE: 7PT ;
				BORDER-STYLE: THIN;
				background-color:#FFE4E1;
				BORDER-COLOR: black;
			}
		</style>
	</head>
		<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad = "Print()">
			<form name ="ChartLayoutListForm">
			<table width='95%'>
				<tr>
					<td><b><%=patient_name%>,<%=patientId%></b></td>
				</tr>
				<tr><td><center><b><%=chartName%></b></center></td></tr>
			</table>
			<table  id='titleTable' width='95%' class='grid'>
			<tr id='divTitleTable'>
			<td rowspan='2' class='COLUMNHEADERCENTER'><fmt:message key="Common.Event.label" bundle="${common_labels}"/></td>
			<td rowspan='2' class='COLUMNHEADERCENTER'><fmt:message key="Common.Unit.label" bundle="${common_labels}"/></td>
<%
					String groupId = "",	groupDesc = "",		prevGroupId = "";
					String discrId = "",	discrDesc = "",		uom = "";
					int i=0;

					for(i=0;i<arrList.size();i++)
					{
						hash = (HashMap)arrList.get(i);
						groupId = (String)(hash.get("CHART_GROUP_ID")) == null ? "" : (String)(hash.get("CHART_GROUP_ID"));
						groupDesc = (String)(hash.get("CHART_GORUP_DESC")) == null ? "" : (String)(hash.get("CHART_GORUP_DESC"));
						if(!prevGroupId.equals(groupId))
						{
							grpList.put(groupId,groupDesc);
						}
						uom = (String)(hash.get("UOM")) == null ? "&nbsp;" : (String)(hash.get("UOM"));
						if(uom.equals("")) uom = "&nbsp;";
						discrId = (String)(hash.get("DISCR_MSR_ID")) == null ? "" : (String)(hash.get("DISCR_MSR_ID"));
						discrDesc = (String)(hash.get("SHORT_DESC")) == null ? "" : (String)(hash.get("SHORT_DESC"));
						if(!discrId.equals(""))
							discrList.put(discrId,discrDesc+"`"+uom);
					}

					StringTokenizer tokenizeSpace = null;
					String dt = "";
					String currDate="";
					String prevDateTemp = "";
					String dummyDateString = "";
					int ii = 0;
					int index = 0;
					boolean flag = true;;
					int actualIndex = 0;
					if(dates != null)
					{
						for(ii=0;ii<dates.size();ii++)
						{
							dt = (String)dates.get(ii);
							tokenizeSpace = new StringTokenizer(dt," ");
							currDate = tokenizeSpace.nextToken();
							if(!currDate.equals(prevDateTemp)){
								
								out.println("<td class='DateLink' width='40px' id='rowId"+index+"'>"+com.ehis.util.DateUtils.convertDate(currDate,"DMY","en",locale)+"</td>");
								prevDateTemp = currDate;
								actualIndex = index;
								index++;
							}
							else
							{
								
%>
								<script>
									var rowValue = "<%=actualIndex%>"
									//var thRowId = eval("document.getElementById("rowId")"+rowValue)
									var thRowId = document.getElementById("rowId" + rowValue);
									thRowId.colSpan += 1
								</script>
<%							}
						}
					}
					String dummyString="";
					String currDate1="";
					String anchorObj = "";
					String anchorObjEnd = "";
					out.println("</tr>");
					out.println("<tr id='divTitleTable1'>");
					if(dates!=null)
					{
						for( ii=0;ii<dates.size();ii++)
						{
							dt = (String)dates.get(ii);
							dummyString=(String)arrayResultType.get(ii);
							tokenizeSpace = new StringTokenizer(dt," ");
							currDate1 = tokenizeSpace.nextToken();
							currDate = tokenizeSpace.nextToken();
							if(!currDate.equals(prevDateTemp))
							{
								dummyDateString = currDate1;
								currDate1= currDate1.replace('/','_');
								//IN067541 STARTS
								if(dummyString.equals("S")){
									currDate="Day Summary";
								}
								 if(dummyString.equals("S1")){
										currDate="Shift1 Summary";
								 }
								 if(dummyString.equals("S2")){
										currDate="Shift2 Summary";
								 }
								if(dummyString.equals("S3")){
									currDate="Shift3 Summary";
								}								
								String strSuminthai = currDate;
								if(strSuminthai.equals("Day Summary"))
								{
									strSuminthai=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DaySummary.label","ca_labels");
									summaryVal = summaryVal.append(ii+"`");
								}
								if(strSuminthai.equals("Shift1 Summary")){
									strSuminthai=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AMShift.label","ca_labels");//IN067541
									summaryVal = summaryVal.append(ii+"`");
								}
								if(strSuminthai.equals("Shift2 Summary")){
									strSuminthai=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.PMShift.label","ca_labels");//IN067541
									summaryVal = summaryVal.append(ii+"`");
								}
								if(strSuminthai.equals("Shift3 Summary")){
									strSuminthai=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ONShift.label","ca_labels");//IN067541
									summaryVal = summaryVal.append(ii+"`");
									}
								out.println("<td class='TimeLink' nowrap width='40px' id='thId"+currDate1+ii+"'> "+anchorObj+" "+strSuminthai+" "+anchorObjEnd+" </td>");
								prevDateTemp =currDate;
								
							}
							/*else
							{
								if(dummyString.equals("S"))
									currDate="DAY/SUM";
								String strsum_thai=currDate;
								if(strsum_thai.equals("DAY/SUM")){
									//strsum_thai=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Daysum.label","ca_labels");//IN069501
									strsum_thai=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DaySum.label","ca_labels");//IN069501
								}
								out.println("<td class='columnHeadercenter'  width='40px' id='thId"+currDate1+ii+"'>"+strsum_thai+"</td>");
							}*/
							//IN067541 ends
						}
					}
				%>
			</tr>
			<INPUT TYPE="hidden" name="detailYN" id="detailYN" value='<%=detailYN%>'>
			<INPUT TYPE="hidden" name="summaryYN" id="summaryYN" value='<%=summaryYN%>'>

			<%
					ArrayList cols = new ArrayList();
					ArrayList discrArray = new ArrayList();
					HashMap setOfValues = new HashMap();
					String printVal = "";
					String classValue = "gridDataChart";
					String styleValue = "";
					String result_type = "";
					String discrMsrId = "", discrMsrDesc = "";
					String tempStringTemp = "";
					String tempString1 = "";
					int indexJ = 0;
					String normalStr="",normalRangeColor = "",criticalStr = "";
					String currGroupId ="", currGroupDesc = "";
					String eventDate = "";
					String tooltip = "";
					String currEventDate="";
					StringTokenizer tk = null;
					int z =0 ;int indexK = 0;int k=0;
					int tempIntForGraph = 0;
				String shiftColor="";//IN067541
				String resultTypeTemp="";//IN067541
					for( indexJ= 0 ; indexJ < arrayChartGrp.size();indexJ++){
							flag = true;
							index = 0;
							currGroupId = (String)arrayChartGrp.get(indexJ)==null ? "" : (String)arrayChartGrp.get(indexJ) ;
							discrArray	= (ArrayList)hashData.get(currGroupId);
							currGroupDesc = (String)grpList.get(currGroupId);
							//out.println("<tr >&nbsp</tr>");//IN058155(Removed the extra space)
							out.println("<tr ><td colspan=4>&nbsp;<td></tr>");//IN058155
							out.println("<tr >");
							out.println("<td class='COLUMNHEADER' colspan='2' >"+currGroupDesc+"</td>");
							for(k=0;k<dates.size();k++)
							{
								out.println("<td class='COLUMNHEADER'>&nbsp;</td>");
							}
							out.println("</tr>");
							for(indexK =0 ;indexK <discrArray.size();indexK++)
							{
								discrMsrId = (String)discrArray.get(indexK);
								out.println("<tr id='tdrowId"+indexJ+indexK+"'>");
								discrMsrDesc = (String)discrList.get(discrMsrId);
								tk = new StringTokenizer(discrMsrDesc,"`");
								
								out.println("<td class='gridDataChart' border='1'>"+tk.nextToken()+"</td>");
								out.println("<td class='gridDataChart' border='1'>"+tk.nextToken()+"</td>");
								cols = (ArrayList)finalHash.get(currGroupId+"~"+discrMsrId);
								for(k=0,z=0;k<dates.size();k++)
								{
									resultTypeTemp= (String)arrayResultType.get(k);//IN067541
									if(cols != null)
									{
										if(cols.size() > z)
										{
											setOfValues = (HashMap)cols.get(z);
											eventDate = (String)dates.get(k);
										
											currEventDate = (String)(setOfValues.get("VALUE_DATE"))==null ? "" : (String)(setOfValues.get("VALUE_DATE"));
											if(currEventDate.equals(eventDate))
											{
											//IN067541 starts
												//IN065535 Start.
												result_type = (String)(setOfValues.get("RESULT_TYPE")==null?"":setOfValues.get("RESULT_TYPE"));
												if((!result_type.equals("S") && !result_type.equals("S1") && !result_type.equals("S2") && !result_type.equals("S3")) ||
													((result_type.equals("S") || result_type.equals("S1") || result_type.equals("S2") || result_type.equals("S3")) && (result_type.equals(arrayResultType.get(k))))){
													//IN065535 End.
													//IN067541 ends
												printVal = (String)setOfValues.get("VALUE")== null ? "" :(String)setOfValues.get("VALUE") ;
												
												normalStr = (String)(setOfValues.get("NORMALSTR")==null?"":setOfValues.get("NORMALSTR"));
												normalRangeColor = (String)(setOfValues.get("COLOR")==null?"":setOfValues.get("COLOR"));
	
												criticalStr = (String)(setOfValues.get("CRITICALSTR")==null?"":setOfValues.get("CRITICALSTR"));
												result_type = (String)(setOfValues.get("RESULT_TYPE")==null?"":setOfValues.get("RESULT_TYPE"));
												//IN067541 STARTS
												if(result_type.equals("S")||result_type.equals("S1")||result_type.equals("S2")||result_type.equals("S3"))
												{
													shiftColor="style='background-color:#d3d3d3;'";
												}else{
													shiftColor="";
												}
												//IN067541 ends
												if(result_type.equals("L")){
													if(!printVal.equals("")){
														if(printVal.indexOf("||") !=-1){
																tokenizeSpace =  new StringTokenizer(printVal,"||");
																tempString1 = tokenizeSpace.nextToken();
	
																tempStringTemp = tokenizeSpace.nextToken();
																
																printVal=tempStringTemp;
	
														}
														printVal = tempString1 + " " + printVal;
													}		
												}
												if(flag==true){
												if(!printVal.equals(""))
												{
													if(!normalStr.equals("") && !criticalStr.equals(""))
														tooltip = normalStr+", "+criticalStr;
													else if(!normalStr.equals(""))
														tooltip = normalStr;
													else if(!criticalStr.equals(""))
														tooltip = criticalStr;
													else
														tooltip="";
												}
												else
												{
													tooltip="";
												}
											}
											if(!result_type.equals("S")){
											if(!normalRangeColor.equals(""))
											{
												//styleValue = "STYLE= 'FONT-SIZE: 7PT;BORDER-STYLE: THIN ;background-color:"+normalRangeColor+"' ";
												classValue	=	"gridDataChart";
												styleValue = "class = '"+classValue+"' ";
											}
											else
											{
													if((indexK%2)==0)
													{
														classValue	=	"gridDataChart";
														styleValue = "class = '"+classValue+"' ";
													}
													else
													{
														classValue	=	"gridDataChart";
														styleValue = "class = '"+classValue+"' ";
													}
												}
											}
											else if(result_type.equals("S"))
											{

												classValue = "gridDataChart";
												styleValue = "class = '"+classValue+"' ";

											}
											//out.println("<td width='40px' "+styleValue+">"+printVal+"</td>");//IN067541
											out.println("<td width='40px'  "+shiftColor+" "+styleValue+">"+printVal+"</td>");//IN067541
											
											z++;
											printVal="";
												//IN067541 starts
											//IN065535 Start.
											}else{
												if(resultTypeTemp.equals("S")||resultTypeTemp.equals("S1") || resultTypeTemp.equals("S2") || resultTypeTemp.equals("S3")){
													shiftColor="style='background-color:#d3d3d3;'";
												}//IN067541 ENDS
												if((indexK%2)==0){
													classValue	=	"gridDataChart";
													styleValue = "class = '"+classValue+"' ";
												}else{
													classValue	=	"gridDataChart";
													styleValue = "class = '"+classValue+"' ";
												}
												//out.println("<td width='"+widPc+"px' "+styleValue+" >&nbsp; "+remStrDisplay+"</td><input type='hidden' id='values"+tempIntForGraph+"ForGraphs"+k+"' value='"+hiddenDateForGraph+"^%"+hiddenValueForGraph+"^%"+result_type+"'><input type='hidden' id='remarks"+tempIntForGraph+"ForDisp"+k+"' value='"+remarks+"'>");//IN067541
												out.println("<td width='40px'  "+shiftColor+" "+styleValue+">"+printVal+"</td>");//IN067541
											}
											//IN065535 End.
											//IN067541ends
										}
										else
										{
										//IN067541 starts
											if(resultTypeTemp.equals("S")||resultTypeTemp.equals("S1")||resultTypeTemp.equals("S2")||resultTypeTemp.equals("S3"))
											{
												shiftColor="style='background-color:#d3d3d3;'";
											}else{
												shiftColor="";
											}
											//IN067541ends
											if((indexK%2)==0)
											{
												classValue	=	"gridDataChart";
												styleValue = "class = '"+classValue+"' ";
											}
											else
											{
												classValue	=	"gridDataChart";
												styleValue = "class = '"+classValue+"' ";
											}
											//out.println("<td width='40px' "+styleValue+"></td>");//IN067541
											out.println("<td width='40px' "+shiftColor+" "+styleValue+" >&nbsp;</td>");//IN067541
										}
									}
									else
									{
										//IN067541starts
										if(resultTypeTemp.equals("S")||resultTypeTemp.equals("S1")||resultTypeTemp.equals("S2")||resultTypeTemp.equals("S3"))
										{
											shiftColor="style='background-color:#d3d3d3;'";
										}else{
											shiftColor="";
										}
										//IN067541ends
										if((indexK%2)==0)
										{
											classValue	=	"gridDataChart";
											styleValue = "class = '"+classValue+"' ";
										}
										else
										{
											classValue	=	"gridDataChart";
											styleValue = "class = '"+classValue+"' ";
										}
										//out.println("<td width='40px' "+styleValue+">"+printVal+"</td>");//IN067541
										out.println("<td width='40px' "+shiftColor+"  "+styleValue+" >&nbsp;</td>");//IN067541
									}
								}
								else
								{
									//IN067541 starts
									if(resultTypeTemp.equals("S")||resultTypeTemp.equals("S1")||resultTypeTemp.equals("S2")||resultTypeTemp.equals("S3"))
									{
										shiftColor="style='background-color:#d3d3d3;'";
									}else{
										shiftColor="";
									}
									//IN067541ends
									if((indexK%2)==0)
									{
										classValue	=	"gridDataChart";
										styleValue = "class = '"+classValue+"' ";
									}
									else
									{
										classValue	=	"gridDataChart";
										styleValue = "class = '"+classValue+"' ";
									}
									//out.println("<td width='40px' "+styleValue+">"+printVal+"</td>");//IN067541
									out.println("<td width='40px' "+shiftColor+" "+styleValue+" >&nbsp;</td>");//IN067541
								}
							}
							tempIntForGraph++;
							out.println("</tr>");					
						}
				}

				%>

			</table>
				<INPUT TYPE="hidden" name="sumVal" id="sumVal" value='<%=summaryVal.toString()%>'>	
		</form>
				<script>
					/*var count = document.getElementById("titleTable").rows.length;
					var sumVal = document.getElementById("sumVal").value;
					var values = sumVal.split("`");
					var length = values.length;
					for(var i=3;i<count;i++)
					{
						for(var j=0;j<length-1;j++)
						{
							var val = values[j];
							val = parseInt(val,10)+2;
							if(document.getElementById("titleTable").rows(i).cells(val) != null)
							{
								if(document.getElementById("titleTable").rows(i).cells(val).className != 'CAFOURTHLEVELCOLOR')
								{
									document.getElementById("titleTable").rows(i).cells(val).className= 'CASUMMARY';
								}
							}
						}
					}*/
					
					function Print() 
					{
						if (document.all)
						{
							var res = confirm('Continue printing?');
							if(res)  
							{
								window.print();
							}
							window.close();
						}
					}
				</script>
		</body>
	</html>
<%}

if(discrList != null) discrList.clear();
if(grpList != null) grpList.clear();
//if(hash != null) hash.clear();
}//end of try
catch(Exception ee)
{

	
	ee.printStackTrace();
}
finally
{
	if(con != null) ConnectionManager.returnConnection(con,request);
}
%>
		

