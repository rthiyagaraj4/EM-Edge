<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*,eOT.*, eOT.Common.*, eCommon.Common.*" contentType="text/html; charset=UTF-8"%>

<html>

<%	request.setCharacterEncoding("UTF-8");	%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
Connection conn=null;
CallableStatement callableStatement=null;
String strColorInd="";
String strStageDesc="";
String strStageCode="";
String strResultString="";


StringTokenizer strToken=null;
StringTokenizer strSubToken=null;


ArrayList colorDesc=new ArrayList();
ArrayList stageCode=new ArrayList();




try
{
	

conn = ConnectionManager.getConnection(request);

//sql=OTRepository.getOTKeyValue("OT_VERIFICATION_SELECT1");
//System.out.println("EBT before ColorInd ");
callableStatement=conn.prepareCall("{ call BT_CONSUMBTION_COLOR(null,null,null,null,?,null,?,?)}");



callableStatement.setString(1,"1");
callableStatement.registerOutParameter(2,Types.VARCHAR);
callableStatement.registerOutParameter(3,Types.VARCHAR);
callableStatement.execute();
strResultString = callableStatement.getString(2);

	//System.out.println("EBT After ColorInd "+strResultString);
%>
<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eOT/js/Slate.js"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script src="../../eOT/js/OTMessages.js" language="javascript"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<style>
<%
	int column_count = 0;
	int count=0;

	strToken=new StringTokenizer(strResultString,"#");
	while(strToken.hasMoreElements())
		{			
			strSubToken=new StringTokenizer(strToken.nextToken(),"@");
			 while(strSubToken.hasMoreElements())
			{
			
			
			strColorInd=strSubToken.nextToken();
			strStageCode=strSubToken.nextToken();
			strStageDesc=strSubToken.nextToken();
			}
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
	<form name="BTTransfusionColorInd" id="BTTransfusionColorInd">
	
		<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
		<%

for(int pos=0;pos<count;pos++)
	{
			strStageDesc=""+colorDesc.get(pos);
			strStageCode=""+stageCode.get(pos);
			


	column_count++;
	if(column_count==1){
					out.println("<tr>");
				}
		%>
		<td class='<%=strStageCode%>' width='1%'>&nbsp;</td>
		<td class='white' nowrap>&nbsp;
		<label nowrap style="font-size:9;font-weight:bold"><fmt:message key="<%=strStageDesc%>" bundle="${bt_labels}"/>&nbsp;</label>
					</td>
		<%
	if(column_count==5){
						column_count=0;		
						out.println("</tr>");
						}
			}


}catch(Exception ee)
{
	System.out.println("EBT Exception "+ee);
	out.println("Exception "+ee);
}
finally
{
callableStatement.close();
ConnectionManager.returnConnection(conn,request);
colorDesc=null;
stageCode=null;
}
%>
		
	</table>
	</form>
</body>
</html>

