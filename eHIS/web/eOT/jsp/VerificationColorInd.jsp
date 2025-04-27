<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.util.ArrayList,eCommon.XSSRequestWrapper,webbeans.eCommon.ConnectionManager"  contentType="text/html;charset=UTF-8" %>

<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<html>
<%
Connection conn=null;
PreparedStatement pstmt=null;
ResultSet rs=null;
int pos=0;

String strColorInd="";
String strStageDesc="";
String strStageCode="";

String sql="";


ArrayList colorDesc=new ArrayList();
ArrayList stageCode=new ArrayList();


try
{
conn = ConnectionManager.getConnection(request);

//sql=OTRepository.getOTKeyValue("OT_VERIFICATION_SELECT1");

//sql="SELECT STAGE_CODE STAGE_CODE1, POST_STAGE_DESC POST_STAGE_DESC1, COLOR_IND COLOR_IND1, TEXT_COLOR TEXT_COLOR1 FROM OT_BOOKING_FIN_STAGES ORDER BY SERIAL_NO";

sql="SELECT STAGE_CODE STAGE_CODE1, POST_STAGE_DESC POST_STAGE_DESC1, COLOR_IND COLOR_IND1, TEXT_COLOR TEXT_COLOR1 FROM OT_BOOKING_FIN_STAGES_LANG_VW WHERE LANGUAGE_ID='"+locale+"' ORDER BY SERIAL_NO";


pstmt = conn.prepareStatement(sql);

rs=pstmt.executeQuery();


%>
<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/Tabs.css"></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eOT/js/Slate.js"></script>
	
	<!--<script src="../../eOT/js/OTMessages.js" language="javascript"></script>-->
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<style>
<%
	int column_count = 0;
	int count=0;
	while(rs.next())
		{			
			strColorInd=checkForNull(rs.getString("COLOR_IND1"));;
			strStageCode=checkForNull(rs.getString("STAGE_CODE1"));;
			strStageDesc=checkForNull(rs.getString("POST_STAGE_DESC1"));;

			colorDesc.add(count,strStageDesc);
			stageCode.add(count,strStageCode);
			
			count++;		
%>
		TD.<%=strStageCode%>{
		BACKGROUND-COLOR:<%=strColorInd%>;
		FONT-SIZE: 8pt ;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #CC9966 0px solid;
		BORDER-LEFT: #CC9966 0px solid;
		BORDER-RIGHT: #CC9966 0px solid;
		BORDER-TOP: #CC9966 1px solid;
		}
<%
		}


%>
</style>
</head>
<body >
	<form name="VerficationColorInd" id="VerficationColorInd">
		<table cellpadding="3" cellspacing="0" width="100%" align="center" border="3">
		<%

for(pos=0;pos<count;pos++)
	{
			strStageDesc=""+colorDesc.get(pos);
			strStageCode=""+stageCode.get(pos);
			


	column_count++;
	if(column_count==1){
					out.println("<tr>");
				}
		%>
		<td class='<%=strStageCode%>' width='1%'></td>
		<td class='white' nowrap>
		<label nowrap style="font-size:9;font-weight:bold"><%=strStageDesc%></label>
					</td>
		<%
	if(column_count==5){
						column_count=0;		
						out.println("</tr>");
						}
			}


}catch(Exception ee)
{
	out.println("Exception "+ee);
}
finally
{
if(rs!=null)		  rs.close();
pstmt.close();
ConnectionManager.returnConnection(conn,request);
colorDesc=null;
stageCode=null;
}
%>
		
	</table>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	</form>
</body>
</html>
<!-- <div id='tooltiptext' style='display:none; width=40%' >	</div> -->


<!--
function createXML()
{

	var arrObj=rows;
var x=0;
var len=	arrObj.length;

var xmlString="<root>";
	for(x=0;x<len;x++)
	{

		xmlString+="<Detail"+x+"  ";
		xmlString+="Desc=\""++";
		xmlString+="code=\""++";
		xmlString+="remarks=\""++";
		xmlString+="/>";
	}
	return xmlString;
}

-->

