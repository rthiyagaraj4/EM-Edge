<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");	
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
		String styleMap				=  "";		
		String summDesc				=  com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Transactions.label", "ph_labels");;
		String responsibility_id	=  (String)session.getValue("responsibility_id");
		String layout_value			=  request.getParameter("layoutValue")		== null ? "F" : request.getParameter("layoutValue");	
		String desktop_id			=  request.getParameter("deskTopID")		== null ? ""  : request.getParameter("deskTopID");	
		String dfltFunctionId		=  request.getParameter("dfltFunctionId")	== null ? ""  : request.getParameter("dfltFunctionId");	
		String userdef_desktop_desc	=  request.getParameter("userdef_desktop_desc")	== null ? summDesc  : request.getParameter("userdef_desktop_desc");	
		String params = request.getQueryString();
	
		if(sStyle.equals("IeStyleBlue.css")){
			styleMap = "Blue";
		}
		else if(sStyle.equals("IeStyleLime.css")){
			styleMap = "Lime";
		}
		else if(sStyle.equals("IeStyleOrange.css")){
			styleMap = "Orange";
		}
		else if(sStyle.equals("IeStyleVoilet.css")){
			styleMap = "Violet";
		}

%>	
	
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src='../../ePH/js/PharmacistHome.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>	
		<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
		</head>
		<body  class="NavigIconsBorder" OnMouseDown='CodeArrest()' onKeyDown="lockKey()" onload="setCustLayout('Summary','SummaryDtl','Navigation','Desktop')">
			<FORM name='desktopParam' id='desktopParam'>
				<input type='hidden' name='params' id='params' value='<%=params%>'>
				<div id="master" STYLE="position:absolute; left:0; top:0;" >
					<TABLE width="100%" CELLSPACING=0 class="COMMON_TOOLBAR" cellpadding="0" border=1>
						<TR >
							<TD >
								<IMG style="cursor:pointer" SRC="../../eCommon/images/Logout.gif" BORDER=0 ALT="" align="absmiddle"   TITLE='<fmt:message key="Common.logout.label" bundle="${common_labels}"/>' onclick="imagetoolFunction(1)">
								<IMG style="cursor:pointer" SRC="../../eCommon/images/switch_resp.gif" BORDER=0 ALT="" align="absmiddle" onclick="imagetoolFunction(2)" TITLE='<fmt:message key="Common.switchResponsibility.label" bundle="${common_labels}"/>'>
								<IMG style="cursor:pointer" SRC="../../eCommon/images/personalize02.gif" BORDER=0 ALT="" align="absmiddle"  onclick="imagetoolFunction(3)"  TITLE='<fmt:message key="Common.personalize.label" bundle="${common_labels}"/>'>
							</TD>
						</TR>
					</table>
				</div>

				<input type='hidden' name="layoutValue" id="layoutValue" value="<%=layout_value%>">
				<input type='hidden' name="desktop_id" id="desktop_id" value="<%=desktop_id%>">
<%
				if(!desktop_id.equals("") ){
%>	 
					<div id="mainDIV" nowrap>		
						<div id="Summary" class="divslideActive" style="top:20px" title='<%=userdef_desktop_desc%>' ><%=userdef_desktop_desc%>
						</div>	

						<div id="SummaryDtl" 
							style="position:absolute;
							 width:240px;
							 height:300px;           
							 top:40px;
							 left:0px;
							 background:#FFFFFF;
							 overflow:auto;display:inline"> 

							<jsp:include page="../../ePH/jsp/PharmacistHomeSummary.jsp" ><jsp:param name="flush" value="true" />
							<jsp:param name="desktopID" value="<%=desktop_id%>" />
							<jsp:param name="responsibility_id" value="<%=responsibility_id%>" />
							</jsp:include>
						</div>						
						<!--<div id="persMenuFrm" class="NavigIconsBorder" style="position:absolute;
								 width:197px;
								 height:150px;
								 top:525px;
								 left:0px;
								 background:#FFFFFF;
								 overflow:auto;
								display:none;">			
							<jsp:include page="../../eCommon/jsp/PersonalizeList.jsp" flush="true"> 
							<jsp:param name="persFrom" value="HomeSummary" />
							<jsp:param name="called_from" value="CA" />
							</jsp:include>
						</div>-->
					</div>
<% 
				}
%>
		 </FORM>
	</body>
</html>

