<!DOCTYPE html>
	<%@page import="java.sql.*, java.util.*, java.io.*, webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>	
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>


	<head>
<%
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
		<!-- Added by Arvind @ 08-12-08 -->
		
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="JavaScript" src ="../../eCA/js/SectionChart.js"></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body OnMouseDown='CodeArrest();' onKeyDown='lockKey()'>
	<form name='sectionChartDtlForm' id='sectionChartDtlForm'>
	<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

	<%
		eCA.SectionChartBean bean = (eCA.SectionChartBean)getObjectFromBean("bean","eCA.SectionChartBean",session);
	%>
	
	<%
		ArrayList retArray = null;
		String trRowId = "";
		int start = 0;
		int end = 0;
		int index = 0;
		StringTokenizer tokenPipe = null;
		StringTokenizer tokenTilde = null;
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		int rowCount = 0;
		int maxRecord = 0;
		String error_msg = "";
		Connection con = null;
		String searchText = request.getParameter("chartDesc");	
		String mode = request.getParameter("mode")==null ? "" : request.getParameter("mode");
		String selectYN = "";
		String classValue = "";
		String sectionCode = "";
		String finalString = "";
		String flagYN="";
		String tempString="";
		if(to == null)
			end = 6;
		else
			end = Integer.parseInt(to);

		if(from == null)
			start = 1;
		else
			start = Integer.parseInt(from);
		String chartId = request.getParameter("chartId");
		if(searchText==null || searchText.equals("")||searchText.equals("%"))
				searchText = "%";
		else
			searchText = searchText.toUpperCase() +"%";
		if(chartId==null || chartId.equals(""))
				chartId = "";
		ArrayList arrayDesc =null;
		
		ArrayList flag = null;
		ArrayList arrayCodeCmp =null;
		ArrayList arrayFlag = null;	
		retArray = null;
		ArrayList discreteMeasureId = null;
		ArrayList orderSeqNo = null;
		try
		{	bean.clearArray(retArray);
			con = ConnectionManager.getConnection(request);
			maxRecord = bean.getMaxRecord(chartId,searchText,con);
			//out.println("maxRecord"+maxRecord);
			//out.println("searchText"+searchText);
%>
<%	
		finalString = bean.getConcatenatedString();
		if(finalString==null || finalString.equals(""))
			{
				finalString = "";
			}
		retArray = bean.getQueryForChart(chartId,searchText,con,start,end);	
		if(retArray != null)
			{
				if( retArray.size()!=0)
				{
						
					arrayDesc = (ArrayList)retArray.get(0);

					
					discreteMeasureId  = (ArrayList)retArray.get(2);
					orderSeqNo = (ArrayList)retArray.get(1);
					flag = (ArrayList)retArray.get(3);
					if(arrayDesc.size()==0 || discreteMeasureId.size()==0||orderSeqNo.size()==0 || flag.size()==0)
					{
						error_msg ="NO_RECORD_FOUND_FOR_CRITERIA";
						out.println("<script>alert(getMessage('"+error_msg+"','Common'));</script>");
						out.println("<script>parent.sectionChartSearchFrame.document.sectionChartSearchForm.searchtext.value=''</script>");
					
						out.println("<script>document.URL='../../eCommon/html/blank.html'</script>");
						
					}
					if(!finalString.equals(""))
					{
						
						tokenTilde = new StringTokenizer(finalString,"~");
						arrayCodeCmp = new ArrayList();
						arrayFlag =  new ArrayList();
						while(tokenTilde.hasMoreTokens())
						{
							tokenPipe = new StringTokenizer(tokenTilde.nextToken(),"||");
							tempString = tokenPipe.nextToken();
							arrayCodeCmp.add(index,tokenPipe.nextToken());
							tempString = tokenPipe.nextToken();
							arrayFlag.add(index,tokenPipe.nextToken());
							index++;
						}
					}
				
%>
<table cellpadding='0' cellspacing='0' border='0' width='100%' align='center'>
	<tr>
	 <td class='white' width='100%' ></td> <!-- <updated by Arvind width 84 to 100 and added nowrap@ 29-12-08> -->
	<td class='label' width='0%' align='right' nowrap>
	<%
		if ( !(start <= 1) )
			out.println("<A class='gridLink' HREF='../../eCA/jsp/SectionChartDtl.jsp?from="+(start-6)+"&chartDesc="+java.net.URLEncoder.encode(searchText)+"&chartId="+chartId+"&mode=modify"+"&to="+(end-6)+"'text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
		if ( !( (start+6) > maxRecord ) )
			out.println("&nbsp;<A class='gridLink' HREF='../../eCA/jsp/SectionChartDtl.jsp?from="+(start+6)+"&chartId="+chartId+"&chartDesc="+java.net.URLEncoder.encode(searchText)+"&mode=modify"+"&to="+(end+6)+"'text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
	%>
		</td>
	</tr>
</table>	

<div id='divDataTitle' style='postion:relative'>
<table cellpadding='3' cellspacing='0' border='1' id='dataTitleTable' width='100%' align='center' >
		<tr align='left'>
			<th class='columnheadercenter' width='73%'><fmt:message key="Common.SectionDescription.label" bundle="${common_labels}"/></th>
			<th class='columnheadercenter' width='20%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
		</tr>
</table>	
</div>	                      
<table class='grid' cellpadding='3' cellspacing='0' border='1' id='dataTitleTable1' width='100%' align='center' >	
<%	
	
					for(rowCount=0;rowCount < arrayDesc.size();rowCount++)
					{
						//out.println("<script>alert('arrayDesc "+arrayDesc.size()+"')</script>");

							trRowId = "trRowId"+rowCount;
							if(finalString.equals(""))
							{
						
								if( !(mode.equals("modify")))
								{
									if(((String)flag.get(rowCount)).equals("Y"))
										selectYN = "checked";
									else
										selectYN = "";
								}
								else
								{
									int descLength = bean.getLength();
									if(descLength > 0)
									{
										if(((String)flag.get(rowCount)).equals("Y"))
										selectYN = "checked";
									else
										selectYN = "";
									}
									else
									{
										selectYN = "";
									}
											
								}
							}
							else
							{
								selectYN = "";
								for(index = 0;index < arrayCodeCmp.size();index++)
								{
									
									tempString = (String)arrayCodeCmp.get(index);
									sectionCode = (String)discreteMeasureId.get(rowCount);
									if(sectionCode.equalsIgnoreCase(tempString))
									{
											flagYN = (String)arrayFlag.get(index);
											if(flagYN.equals("Y"))
													selectYN = "checked";
												else
													selectYN = "";
									}
									
								}
							}
							if(rowCount % 2 ==0) 
								classValue = "gridData";
							else
								classValue = "gridData";
%>
			<tr  id='<%=trRowId%>'>
				<td class='<%=classValue%>' width='73%' >
					<%=(String)arrayDesc.get(rowCount)%>
				</td>
				<td class='<%=classValue%>' width='20%' >
					<input type='checkbox' name='select_yn<%=rowCount%>' id='select_yn<%=rowCount%>'   value='<%=(String)flag.get(rowCount)%>' <%=selectYN%> onClick="stringConCatenate(<%=rowCount%>,<%=trRowId%>)">
				</td>
			</tr>
			<INPUT TYPE="hidden" name="sectionCode<%=rowCount%>" id="sectionCode<%=rowCount%>" value='<%=(String)discreteMeasureId.get(rowCount)%>'>
			<input type='hidden' name='sequence_num<%=rowCount%>' id='sequence_num<%=rowCount%>' value='<%=(String)orderSeqNo.get(rowCount)%>'>
<%				}
			}	
				else
				{
					error_msg ="NO_RECORD_FOUND_FOR_CRITERIA";

					out.println("<script>alert(getMessage('"+error_msg+"','Common'));</script>");
					out.println("<script>parent.sectionChartSearchFrame.document.sectionChartSearchForm.searchtext.value=''</script>");

					out.println("<script>document.URL='../../eCommon/html/blank.html'</script>");
					
				}
			}
			out.println("<input type='hidden' name='sequence' id='sequence' value='"+rowCount+"'> ");
			
			//bean.returnConnection();
	}
		catch(Exception e)
		{
			//out.println("Exception in Section Chart Dtl Block :"+e.toString());//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
	%>
	</table>		
	</form>
	</body>
</html>

