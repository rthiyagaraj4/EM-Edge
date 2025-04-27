<!DOCTYPE html>
<!--Created by Thamizh selvi on 04/10/2016 for GDOH-CRF-0082-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*, java.lang.*,webbeans.eCommon.*,org.json.simple.parser.JSONParser,org.json.simple.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
		<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eMR/js/PMBCode.js"></script>
		<script language="JavaScript" src="../../eCommon/js/tableheaderscroll.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	
	<script>
		window.onload=function(){
			if(document.getElementById("pmb_table")!=null && document.getElementById("allResults")!=null)			
				fxheaderInit('pmb_table',480);
			else{
				document.getElementById("loadImg").style.display="none";
				document.getElementById("allResults").style.display="none";
			}
		};

		window.onbeforeunload=function(){
			if(document.forms[0].isPrevClicked!=null && document.forms[0].isNextClicked!=null){
				if(document.forms[0].isPrevClicked.value=="Y" || document.forms[0].isNextClicked.value=="Y"){
					document.getElementById("loadImg").style.display="block";
					document.getElementById("allResults").style.display="none";
				}
			}
		};

	</script>
	
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
		<form name="PMBCodeQueryResult_Form" id="PMBCodeQueryResult_Form" >
			<%
			Connection con = null;
			try{
				request.setCharacterEncoding("UTF-8");
				request= new XSSRequestWrapper(request);
				response.addHeader("X-XSS-Protection", "1; mode=block");
				response.addHeader("X-Content-Type-Options", "nosniff");
				String classValue = "" ;	
				int currentPageNo 	= 1;
				if(request.getParameter("currentPageNo") != null)
					currentPageNo = Integer.parseInt(request.getParameter("currentPageNo"));
				
				String pmbCode = (request.getParameter("PMBCode")==null || request.getParameter("PMBCode")=="")?"":request.getParameter("PMBCode");
				
				String pmbCode_Desc = (request.getParameter("PMBCode_Desc")==null || request.getParameter("PMBCode_Desc")=="")?"":request.getParameter("PMBCode_Desc");
				
				String termCode = (request.getParameter("TermCode")==null || request.getParameter("TermCode")=="")?"":request.getParameter("TermCode");
				
				String termCode_Desc = (request.getParameter("TermCode_Desc")==null || request.getParameter("TermCode_Desc")=="")?"":request.getParameter("TermCode_Desc");
			
				String ord[] = request.getParameterValues("orderbycolumns");
				StringBuffer ordSb = new StringBuffer();

				if ( !(ord == null || ord .equals("")) )
				{
					for ( int i=0;i < ord.length;i++ )
					{
						if(ord[i]==null) ord[i]="";
						if( i == ord.length - 1 )
							ordSb.append(" "+ord[i]+" ");
						else
							ordSb.append(" "+ord[i]+" ,");
					}
				}
				else{
					ordSb.append("PMB_CODE");
				}
				
				
				con = ConnectionManager.getConnection(request);

				JSONObject jsonObj 	= new JSONObject();
				JSONArray pmbArr	= new JSONArray();

				jsonObj  = eMR.MRQueryPMBCode.getPMBandTermCode(con,pmbCode,pmbCode_Desc,termCode,termCode_Desc,ordSb,currentPageNo);	
					
				int curPageNo		= 0;
				curPageNo		= (Integer) jsonObj.get("currentPageNo");
					
				int noOfRecords		= 0;
				noOfRecords		= (Integer) jsonObj.get("noOfRecords");
				
				int noOfPages		= 0;
				noOfPages		= (Integer) jsonObj.get("noOfPages");
				
				int prevPageNo	= curPageNo - 1;		
				int nextPageNo	= curPageNo + 1;		

				if(noOfRecords == 0)
				{
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
				}
			%>
			<div id="loadImg" style="margin:250px 0 0 500px;display: none;" >
				<img src="../../eOA/patientportal/ajax-loader.gif" width="24" height="24"/>
			</div>
			
			<div id="allResults">
				<table align='right'>
					<tr>
					<% if ( curPageNo > 1 ){ %>
						<td align ='right' id='prev'><A HREF="../../eMR/jsp/PMBCodeQueryResult.jsp?PMBCode=<%=pmbCode%>&PMBCode_Desc=<%=pmbCode_Desc%>&TermCode=<%=termCode%>&TermCode_Desc=<%=termCode_Desc%>&currentPageNo=<%=prevPageNo%>&orderbycolumns=<%=ordSb%>" text-decoration='none' onclick="fnSetvalue('P');" ><fmt:message key="Common.previous.label" bundle="${common_labels}" /></A></td>
					<%}
					if ( curPageNo >=1 && curPageNo != noOfPages ){%>
						<td align ='right' id='next'><A HREF="../../eMR/jsp/PMBCodeQueryResult.jsp?PMBCode=<%=pmbCode%>&PMBCode_Desc=<%=pmbCode_Desc%>&TermCode=<%=termCode%>&TermCode_Desc=<%=termCode_Desc%>&currentPageNo=<%=nextPageNo%>&orderbycolumns=<%=ordSb%>" text-decoration='none' onclick="fnSetvalue('N');"><fmt:message key="Common.next.label" bundle="${common_labels}"/></A></td>
					<%}%>
					</tr>
				</table>
				<br><br>
				<table border='1' cellpadding='0' cellspacing='0'   width="100%"  id='pmb_table'>
					<tr>
						<th class="columnheader"><fmt:message key="eMR.PMBCode.label" bundle="${mr_labels}"/></th>
						<th class="columnheader"><fmt:message key="eMR.PMBCodeDescription.label" bundle="${mr_labels}"/></th>
						<th class="columnheader"><fmt:message key="eMR.TreatmentDesc.label" bundle="${mr_labels}"/></th>
						<th class="columnheader"><fmt:message key="Common.TermCode.label" bundle="${common_labels}"/></th>
						<th class="columnheader"><fmt:message key="eMR.SupportingCode.label" bundle="${mr_labels}"/></th>
						<th class="columnheader"><fmt:message key="Common.TermCodeDescription.label" bundle="${common_labels}"/></th>
					</tr>
					<tr></tr>
					<%
						pmbArr = (JSONArray)jsonObj.get("PMBArray");
						for(int i = 0 ; i < pmbArr.size() ; i++) {	
							JSONObject pmbCodeListObj	= (JSONObject)pmbArr.get(i);
							String PMB_CODE  = (String) pmbCodeListObj.get("PMB_CODE");
							String PMB_DESC1 = (String) pmbCodeListObj.get("PMB_DESC");
							String PMB_DESC2 = (String) pmbCodeListObj.get("TREATMENT_DESC");
							String TERM_CODE = (String) pmbCodeListObj.get("TERM_CODE");
							String SUPP_CODE = (String) pmbCodeListObj.get("SUPPORT_CODE");
							String TERM_DESC = (String) pmbCodeListObj.get("TERM_DESC");
							int j= i+1;
							if (j%2 == 0)
								classValue = "QRYEVEN" ;
							else
								classValue = "QRYODD" ;										
					%>
							<tr>
								<td align="left" valign="middle"  class="<%=classValue%>"><%=PMB_CODE%></td>
								<td align="left" valign="middle"  class="<%=classValue%>"><%=PMB_DESC1%></td>
								<td align="left" valign="middle"  class="<%=classValue%>"><%=PMB_DESC2%></td>
								<td align="left" valign="middle"  class="<%=classValue%>"><%=TERM_CODE%></td>
								<td align="left" valign="middle"  class="<%=classValue%>"><%=SUPP_CODE%>&nbsp;</td>
								<td align="left" valign="middle"  class="<%=classValue%>"><%=TERM_DESC%></td>
							</tr>

							<input type='hidden' name='isPrevClicked' id='isPrevClicked' value = ""></input>
							<input type='hidden' name='isNextClicked' id='isNextClicked' value = ""></input>

					
					<% } %>
				</table>
			</div>
			<%
			}catch(Exception e){/* out.println(e); */
				e.printStackTrace();
			}
			finally {
				try{
					ConnectionManager.returnConnection(con,request);
				}catch(Exception e) {}
			}
			%>
		</form>
	</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

