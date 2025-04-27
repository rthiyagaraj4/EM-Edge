<!DOCTYPE html>
<%@ page import="java.util.*,javax.naming.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title><fmt:message key="eCA.UserTree.label" bundle="${ca_labels}"/></title>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	StringTokenizer userRespToken = null;
	StringTokenizer strToken = null;
	String userName = "";
	String userResponsibility = "";
	String tokUserName = "";
	String tokUserResp = "";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />


<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
 <script src='../../eCA/js/InstantMessengerChat.js' language='javascript'></script>
 <script src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 <STYLE>
	TR {
		BACKGROUND-COLOR:white;
	}

	TD{
	  font-family:  verdana ;
	  FONT-SIZE: 10pt ;
	  BACKGROUND-COLOR: white;
	  COLOR:green;
	}
</STYLE>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" bgcolor=#E2E3F0 onload="timer()">
<form name='treeForm' id='treeForm'>
<script>
document.body.style.scrollbarBaseColor='#E2E3F0';
document.body.style.scrollbarArrowColor='#000080';
</script>
<script>
var obj;
obj = new dTree('obj');
obj.completed=true;
obj.add(0,-1,'Friends','javascript:','','','','','','Friends');
obj.config.useStatusText=true;
//obj.add(1,0,'Users','javascript:','','','','','','Users');	
<%  
	String loginUserId = (String)session.getValue("login_user")==null?"":(String)session.getValue("login_user");
	//String responsibilityId  = (String)session.getValue("responsibility_id") == null ? "" : (String)session.getValue("responsibility_id");
	Context ctx = new InitialContext();
	TreeSet userNameSet = new TreeSet();
	TreeSet userRespSet = new TreeSet();
	ArrayList userRespList = new ArrayList();
	boolean boolName = false;
	boolean boolResp = false;
	HashMap map = (HashMap)ctx.lookup("chat");
	Set hset = (Set)map.keySet();	
	Iterator hiter = hset.iterator();
	
	String strkey =  "";
	//iterating through the hashtable to get the online users
	while(hiter.hasNext())
	{
		strkey =  (String)hiter.next();
		userRespToken = new StringTokenizer(strkey,"~");
		userName = userRespToken.nextToken();
		userResponsibility = userRespToken.nextToken();
		boolName = userNameSet.add(userName+"`"+userResponsibility);
		boolResp = userRespSet.add(userResponsibility);
		userRespList.add(userResponsibility);
	}

	Iterator nameIterator = userNameSet.iterator();
	String displayUserName = "";
	String prevDisplayUserResp = "";
	int p = userRespSet.size() + 1;//id for the tree element
	int i = 0;
	int cnt = 1;
	int tempCnt = 1;
	int cntOfUsers = 1;

	while(nameIterator.hasNext())
	{
		displayUserName = (String)nameIterator.next();
		strToken = new StringTokenizer(displayUserName,"`");
		tokUserName = strToken.nextToken();
		tokUserResp = strToken.nextToken();

		if(!prevDisplayUserResp.equals(tokUserResp))
		{
			//if(i >= 0)
			{
%>
				obj.add(<%=cnt%>,0,'<%=tokUserResp%>','javascript:','','','','','','<%=tokUserResp%>','');
<%			
			}
			tempCnt = cnt;			
			prevDisplayUserResp = tokUserResp;
			cnt++;
		}
		if(!tokUserName.equals(loginUserId))
		{
%>
			obj.add(<%=p%>,<%=tempCnt%>,'<%=tokUserName%>','javascript:','','','','','','<%=tokUserName%>','<%=tokUserResp%>');			
<%		
			p++;			
		}
		i++;
		cntOfUsers++;
	}
%>
document.write(obj);
obj.openAll();
//function for timeout
function timehandle()
{
	var size = "<%=map.size()%>"
	parent.tableFrame.document.getElementById("no_of_users").innerHTML = "<font color=brown size=2 style=font-weight:bold >Number of Users:" +size+"</font>"
}
function timer()
{
	var time=setTimeout("timehandle()",200);
}
<%
//map.clear();
%>
</script>
<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>
<TABLE border=1 width='100%' bgcolor='white' bordercolor='#10319C'>
	<tr>
		<td>
			<TABLE border=0 width='100%' bgcolor='white'>
				<tr>
					<td class='label'><fmt:message key="Common.SearchUser.label" bundle="${common_labels}"/></td><td class='fields'><input type='text' name='filText' id='filText' size='3'>&nbsp;<input type='button' class='button' name='filBtn' id='filBtn' onclick='selUser(obj)' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Go.label","common_labels")%>' height='400'></td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<input type='hidden' name='hiddenNumOfUsers' id='hiddenNumOfUsers' value='<%=userRespList.size()+userNameSet.size()%>'>
</form>
</body>
</html>

