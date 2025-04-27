<!DOCTYPE html>
<!--[if IE 6]>  
  <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<![endif]-->  
<!--[if IE 7]>  
  <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<![endif]-->  
<!--[if gte IE 7]>  
	<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd"> 
<![endif]-->
<%@ page language="java" import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.*, eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%	
	//request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	eCA.EncSummCompRecBean summRecCompBean = (eCA.EncSummCompRecBean)getObjectFromBean("summRecCompBean","eCA.EncSummCompRecBean",session);	
%>
<html>
	<head>
		<title><fmt:message key="eCA.AttachedComponents.label" bundle="${ca_labels}"/></title>
		<%
			
			String sStyle =
			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			Properties p = (Properties)session.getValue("jdbc");
			String locale	= (String) p.getProperty("LOCALE");
			
			EncSummGroup summGrpDetails = new EncSummGroup();		
			
			String mode = request.getParameter("mode") == null ? "" : request.getParameter("mode");
			
			String groupFlag = request.getParameter("groupFlag") == null ? "" : request.getParameter("groupFlag");
			String groupType = request.getParameter("groupType") == null ? "" : request.getParameter("groupType");
			String groupCode = request.getParameter("groupCode") == null ? "" : request.getParameter("groupCode");	
			
			String btnDisabled = "";			
			
			if (groupFlag.equalsIgnoreCase("0"))
				btnDisabled = "";
			else
				btnDisabled = "disabled";
			
			String flag_for_list = request.getParameter("flag_for_list") == null ? "true" : request.getParameter("flag_for_list");
			String noOfRows = request.getParameter("noOfRows") == null ? "0" : request.getParameter("noOfRows");
			String firstPosition = request.getParameter("firstPosition") == null ? "0" : request.getParameter("firstPosition");
			String secondPosition = request.getParameter("secondPosition") == null ? "0" : request.getParameter("secondPosition");
			String classValue = "";
			int cnt = 0;
			String chk="";
			String disable="disabled";
			int count=0;
			
			int compFlag = 0, compTemplate = 0, compColumns = 0;
			String compSubGroup="", subGroupType="", compFlagDesc="", compCode="", compType="", compRemarks="", compTemplateDesc="",  compStatus="", compSubGroupDesc="", compDesc="", compTempDef="", compColumnType="";			
			
			int j = 0;
			int k = 0;
			int noOfRows1 = 0;
			int ctr=0;
			int sequenceNumber = 0;
			boolean subGroupFlag = false;
			int colSpan = 6;
			
		%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language='javascript' src='../../eCA/js/EncSummGroupComp.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
		<script>
			
			var tableOffset;
			var $header;
			var $fixedHeader;
			
			$(document).ready(function() {
				 tableOffset = $("#table-1").offset().top;
				 $header = $("#table-1 > thead").clone();
				 $fixedHeader = $("#header-fixed").append($header);
			});
	
			$(window).bind("scroll", function() {
			    var offset = $(this).scrollTop();
	
			    if (offset >= tableOffset && $fixedHeader.is(":hidden")) { 		    	
			        $fixedHeader.show();
			    }
			    else if (offset < tableOffset) {
			        $fixedHeader.hide();
			    }
			});
			
		</script>
		<style>			
			#header-fixed {
			    position: fixed;
			    top: 0px; 
			    display:none;
			    background-color:white;
			    clear:both;
			}	
			.gridData
			{
				background-color: #FFFFFF;
				height:18px;
				font-family: Verdana, Arial, Helvetica, sans-serif;
				font-size: 8pt;
				color: #000000;
				font-weight:normal;
				text-align:left;
				padding-left:10px;
				padding-right:10px;
				vertical-align:middle;
				border-bottom:1px;
				border-top:0px;
				border-left:0px;
				border-right:0px;
				border-style:solid;
				border-color:#EEEEEE;
			}
			
		</style>	
	</head>
	<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name = 'encSummGroupSelCompForm' action='../../servlet/eCA.EncSummGroupCompServlet' method='post' target='messageFrame'>
 
			<table id="header-fixed" class='grid' cellpadding='3' cellspacing='0' border='1' width='100%'  align='center'></table>	
			<table id="table-1" class='grid' width='100%'  cellpadding='3' cellspacing=0  align='center'>
				<thead>					
					<tr id='trcoll'>	
						<%						
							if(mode.equals("insert"))
							{
								colSpan = 5;
						%>				
						<td class='COLUMNHEADER' colSpan='5' align=left><input type='button' name='addSubGroupbtn' id='addSubGroupbtn' class='button' 
												value = '<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AddComponent.label","ca_labels")%>'
												onclick='loadComponentPage()'>
						</td>
						<%
							}
						%>			
					</tr>
					<tr id='trcoll'>
						<td class='COLUMNHEADER' colspan='<%=colSpan %>' align=left><fmt:message key="eCA.AttachedComponents.label" bundle="${ca_labels}"/></td>					
					</tr>			
					<tr id='trcoll'>
						<td class='COLUMNHEADERCENTER' width="200" ><fmt:message key="Common.SubGroup.label" bundle="${common_labels}"/></td>
						<td class='COLUMNHEADERCENTER' width="200" ><fmt:message key="eCA.ComponentCode.label" bundle="${ca_labels}"/></td>
						<td class='COLUMNHEADERCENTER' width="350" ><fmt:message key="eCA.ComponentDescription.label" bundle="${ca_labels}"/></td>					
						<td class='COLUMNHEADERCENTER' width="250" ><fmt:message key="eCA.TemplateType.label" bundle="${ca_labels}"/></td>
						<td class='COLUMNHEADERCENTER' width="100" ><fmt:message key="eCA.ColumnNumbers.label" bundle="${ca_labels}"/></td>
						<%						
							if(!mode.equals("insert"))
							{
						%>	
						<td class='COLUMNHEADERCENTER'><fmt:message key="Common.Remove.label" bundle="${common_labels}"/></td>			
						<%
							}
						%>		
					</tr>
				</thead>
			</table>

			<table id="table-2" class='grid' width='100%'  cellpadding='3' cellspacing=0  align='center'>
				<%										
					List<EncSummGroupBean> oSummGroupCompList = null;
					EncSummGroupBean sSummGroupBean = null;
					
					String mapKey = "", mapValue = "";
					int srlNo = 1;
					
					int nGroupCompListSize = 0;
					
					String prevSubGroup = "", currentSubGroup = "", emptySubGroup = "";

					try
					{
						oSummGroupCompList = new ArrayList<EncSummGroupBean>();
						sSummGroupBean = new EncSummGroupBean();
						
						sSummGroupBean.setRequest(request);
						sSummGroupBean.setiGroupFlag(Integer.parseInt(groupFlag));
						sSummGroupBean.setsGroupType(groupType);
						sSummGroupBean.setsGroupCode(groupCode);						
						
						oSummGroupCompList = summGrpDetails.getSummaryGroupCompDetails(sSummGroupBean, locale);		
						
						nGroupCompListSize = oSummGroupCompList.size();	
						
						classValue = "gridData";
						
						for (int i=0;i<nGroupCompListSize;i++){
							
							sSummGroupBean = oSummGroupCompList.get(i);
							compSubGroup = sSummGroupBean.getsSubCompSubGroup();
							compSubGroupDesc = sSummGroupBean.getsSubCompSubGroupDesc();
							subGroupType = sSummGroupBean.getsSubGroupType();
							compFlag = sSummGroupBean.getiSubCompFlag();
							compType = sSummGroupBean.getsSubCompType();
							compCode = sSummGroupBean.getsSubCompCode();								
							compTemplate = sSummGroupBean.getiSubCompTemplate();
							compColumns = sSummGroupBean.getiSubCompColumns();
							compTemplateDesc = sSummGroupBean.getsSubCompTemplate();
							compDesc = sSummGroupBean.getsSubCompDesc();							
							
							currentSubGroup = compSubGroup.toLowerCase();	
							compTempDef = sSummGroupBean.getsSubCompTempDesc();		
							compColumnType = sSummGroupBean.getsSubCompColumnType();
							
							if (compTempDef != null)
								compTempDef = compTempDef.replace("'", "@");						
							
							subGroupFlag = false;
							
							//j = i;
							
							if (!currentSubGroup.equalsIgnoreCase(prevSubGroup)){
								
								//mapKey = compSubGroup + "~" + subGroupType ;
								//mapValue = compSubGroup + "~" + subGroupType;
								
								subGroupFlag = true;
								
								out.println("<tr width='100%' id = 'trGrpHeader"+j+"'><td colspan='5' class='CAGROUP'> ");
								out.println("<input type='hidden' name = 'comp_subgroup"+j+"' value = '"+compSubGroup+"' >");						
								out.println("<input type='hidden' name='comp_subgrouptype"+j+"' id='comp_subgrouptype"+j+"' value = '"+subGroupType+"' >");								
								out.println(compSubGroupDesc+" </td>");
								out.println("<td style='display:none'> <input type='hidden' name = 'comp_Flag"+j+"' value = '"+compFlag+"' > </td>");
								out.println("<td style='display:none'> <input type='hidden' name='comp_type"+j+"' id='comp_type"+j+"' value = '"+subGroupType+"' > </td>");
								out.println("<td style='display:none'> <input type='hidden' name='comp_code"+j+"' id='comp_code"+j+"' value = '"+compSubGroup+"' > </td>");	
								out.println("<td class='gridData'   align = 'center' style='display:none'> <input type='hidden' name='seq_num_text"+j+"' id='seq_num_text"+j+"' value = '"+j+"'> </td>");
								if(!mode.equals("insert"))
								{
									out.println("<td colspan='1' class='gridData'> <input type='checkbox' name='secChk"+j+"' id='secChk"+j+"' onclick=\"resetValues(this)\"> </td>");
								}
								out.println("</tr>");
								noOfRows1 = 0;
								k = j;
								
								j++;
								
								//j = i + 1;
								
								//summRecCompBean.addRecords(mapKey,mapValue);								
								//summRecCompBean.addToList(cnt,mapKey);
							}
							
							out.println("<tr id ='trRowId"+i+"'>");								
							out.println("<td style='display:none'> <input type='hidden' name ='comp_Flag"+j+"' value = '"+compFlag+"' > </td>");
							out.println("<td style='display:none'> <input type='hidden' name ='comp_type"+j+"' value = '"+compType+"' > </td>");
							out.println("<td style='display:none'> <input type='hidden' name ='comp_code"+j+"' value = '"+compCode+"' > </td>");
							out.println("<td style='display:none'> <input type='hidden' name ='comp_desc"+j+"' value = '"+compDesc+"' > </td>");
							out.println("<td style='display:none'> <input type='hidden' name ='comp_columns"+j+"' value = '"+compColumns+"' > </td>");
							out.println("<td style='display:none'> <input type='hidden' name ='comp_def"+j+"' value = '"+compTempDef+"' > </td>");
							out.println("<td style='display:none'> <input type='hidden' name ='comp_template"+j+"' value = '"+compTemplate+"' > </td>");
							out.println("<td style='display:none'> <input type='hidden' name ='comp_col_type"+j+"' value = '"+compColumnType+"' > </td>");
							
							//mapKey = compFlag+ "~" + compType + "~" + compCode;
							//mapValue = compFlag+ "~" + compType + "~" + compCode + "~" +compTemplate+ "~"+compColumns;	
							out.println("<td class='gridData' width='200'> "+emptySubGroup+" </td>");
							out.println("<td class='gridData' width='200'> "+compCode+" </td>");
							out.println("<td class='gridData' width='350'> <a href='javascript:openModifyComp("+j+");'>"+compDesc+" </a> </td>");
							out.println("<td class='gridData' width='250'> "+compTemplateDesc+" </td>");
							
							if (compTemplate == 2)
								out.println("<td class='gridData' width='100'> "+compColumns+" </td>");
							else
								out.println("<td class='gridData' width='100'> </td>");								
							
							out.println("<td class='gridData'   align = 'center' style='display:none'> <input type='hidden' name='seq_num_text"+j+"' id='seq_num_text"+j+"' value = '"+j+"'> </td>");
												
							if(!mode.equals("insert"))
							{						
								if (currentSubGroup == ""){
									out.println("<td class='gridData'   align='center'> <input type='checkbox' name='secChk"+j+"' id='secChk"+j+"' onclick=\"resetValues(this)\"> </td>");
								}
								else if (!currentSubGroup.equalsIgnoreCase(prevSubGroup) & !(subGroupFlag)){
									out.println("<td class='gridData'   align='center'> <input type='checkbox' name='secChk"+j+"' id='secChk"+j+"' onclick=\"resetValues(this)\"> </td>");
								}
								else
									out.println("<td class='gridData'   align='center'> </td>");
							}
							out.println("</tr>");																
													
							j++;
							cnt++;
							srlNo++;
							
							prevSubGroup = currentSubGroup.toLowerCase();
							
						}							
						out.println("<tr style='display:none' id='extraRow'><td align=\"center\" id='extraTD'><a class='gridLink'  href=\"javaScript:changeColor('"+j+"','"+srlNo+"')\">"+srlNo+"</td><td></td><td ></td></tr>");
					}
					catch(Exception e)
					{
						//out.println("Exception in try of EncSummGroupCompList.jsp"+e.toString());//COMMON-ICN-0181
						e.printStackTrace();
					}				
			%>
			</table>			
			<input type='hidden' name='conc_string' id='conc_string' value=''>
			<input type='hidden' name='countOfRows' id='countOfRows' value='<%=cnt%>'>
			<input type='hidden' name='firstPos' id='firstPos' value=''>
			<input type='hidden' name='secPos' id='secPos' value=''>
			<input type='hidden' name='flag' id='flag' value="true">
			<input type='hidden' name='count' id='count' value=<%=count%>>
			<input type='hidden' name='mode' id='mode' value=<%=mode%>>
			<input type='hidden' name='groupFlag' id='groupFlag' value='<%=groupFlag%>'>
			<input type='hidden' name='groupType' id='groupType' value='<%=groupType%>'>
			<input type='hidden' name='groupCode' id='groupCode' value='<%=groupCode%>'>
		</form>		
	</body>
</html>

