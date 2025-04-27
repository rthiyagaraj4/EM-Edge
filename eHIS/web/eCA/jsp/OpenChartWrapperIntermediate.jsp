<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, webbeans.eCommon.*, eCA.CAOpenChartServlet,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script> var  firstwindow = top.window ;</script>
<BODY OnMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String patientId = request.getParameter("patientID") == null ? "" : request.getParameter("patientID");
	String episodeId = request.getParameter("episodeID") == null ? "" : request.getParameter("episodeID");
	String visitId = request.getParameter("visitID") == null ? "" : request.getParameter("visitID");
	String fromPatChart = request.getParameter("FromPatChart") == null ? "" : request.getParameter("FromPatChart"); 
	String fromCloseOrSwitch = request.getParameter("FromCloseOrSwitch") == null ? "" : request.getParameter("FromCloseOrSwitch");
	if(fromCloseOrSwitch.equals("unLoad")) fromCloseOrSwitch = "Close";

    String child_window = request.getParameter("child_window") == null ? "" : request.getParameter("child_window");
    String windName = request.getParameter("windName") == null ? "" : request.getParameter("windName");
    String currentWindowName = request.getParameter("currentWindowName") == null ? "" : request.getParameter("currentWindowName");
//	String function_id = request.getParameter("function_id")==null?"":request.getParameter("function_id");
//	String queryStringForChart = request.getParameter("queryStringForChart")==null?"":request.getParameter("queryStringForChart");
	String ca_user_desktop_yn=(String)session.getValue("ca_user_desktop_yn");
						if (ca_user_desktop_yn==null) ca_user_desktop_yn="N";
	//String windowName = patientId+episodeId+visitId;

	int mapSize = 0;

	HashMap sessionPatMap = null;
	ArrayList sessionIDList = null;
	Set sessSet = null;
	Iterator sessIter = null;

	HashMap patTempMap = null;

	try
	{
		sessionPatMap = (HashMap) session.getAttribute("sessionMainMap"+session.getId()) == null ? new HashMap() : (HashMap) session.getAttribute("sessionMainMap"+session.getId());

		sessionIDList = (ArrayList) session.getAttribute("sessionList"+session.getId()) == null ? new ArrayList() : (ArrayList) session.getAttribute("sessionList"+session.getId());

		//out.println("<script>alert('sessionIDList "+sessionIDList+"')</script>");

		if(sessionPatMap != null && sessionPatMap != new HashMap())
			mapSize = sessionPatMap.size();
		else
			mapSize = 0;

		sessSet = (Set) sessionPatMap.keySet();
		sessIter = sessSet.iterator();	

	}
	catch(Exception e)
	{
		
		out.println("Exception 1 in OpenChartWrapperIntermediate.jsp --"+e.toString()+"--");
		e.printStackTrace();
	}



%>
<script>
if('<%=fromCloseOrSwitch%>' == 'Switch') showPats();

else if('<%=fromCloseOrSwitch%>' == 'unLoad' || '<%=fromCloseOrSwitch%>' == 'Close')
{
		if('<%=child_window%>' == "Y")
		{
	<%
			if(currentWindowName.equals(""))
			{
		
				patTempMap = (HashMap) sessionPatMap.get(windName) == null ? new HashMap() : (HashMap) sessionPatMap.get(windName);
				patTempMap.remove(windName);
				sessionPatMap.remove(windName);
				sessionIDList.remove(windName);
				session.setAttribute("sessionMainMap"+session.getId(),sessionPatMap);
				session.setAttribute("sessionList"+session.getId(),sessionIDList);
			}
			else
			{
				patTempMap = (HashMap) sessionPatMap.get(currentWindowName) == null ? new HashMap() : (HashMap) sessionPatMap.get(currentWindowName);
				patTempMap.remove(currentWindowName);
				sessionPatMap.remove(currentWindowName);
				sessionIDList.remove(currentWindowName);
				session.setAttribute("sessionMainMap"+session.getId(),sessionPatMap);
				session.setAttribute("sessionList"+session.getId(),sessionIDList);
			}
	%>	
			
			top.window.close();
		}
		else if('<%=child_window%>' == "N")
		{
			if('<%=mapSize%>' > 0)
			{
				alert(getMessage("CLOSE_ALL_CHARTS","CA"));
			}
			else
			{
				<%
						sessionPatMap = new HashMap();
						sessionIDList = new ArrayList();					

				%>
//				top.content.location.href = '../../eCommon/jsp/dmenu.jsp';
				/* for PMG20089-CRF-0120 by Deepa on 3/11/2009 at 4:12 PM*/

				if ('<%=ca_user_desktop_yn%>' == "N")
				{
				top.content.location.href = '../../eCommon/jsp/dmenu.jsp?desktopFlag=Y';

				if(top.headerFrameset != null)
				{
					if(top.headerFrameset.rows == '8.5%,*')
						top.headerFrameset.rows = '11.3%,*';
				}
				}
				else
				{
					parent.parent.content.location.href='../../eCommon/jsp/logoff.jsp';
				}
				/*ends here*/
			}

		}
		
}

async function showPats(FromPatChart)
{
	if('<%=fromPatChart%>' != 'FromPatChart' )
	{
		/*for (var nCtr =0; nCtr < 701; nCtr++)
		{}*/
		var ref = firstwindow.top.content.CommonToolbar;
		var pat_info_temp = new Array();
		var pat_info_backup = new Array();
		pat_info_backup = ref.pat_info;
		if(ref.pat_info.length == 0 && '<%=child_window%>' != "N")
		{		
			pat_info_backup = top.opener.top.content.CommonToolbar.pat_info;
		
		}
		
		var j=0 ;
		var pat_info_len;
		if( pat_info_backup != null)
			pat_info_len = pat_info_backup.length;

		if(pat_info_backup != null)
		{
		  for(var i=0;i<pat_info_len;i++)
		  {
			 if(!pat_info_backup[i].window_obj.closed  )
				{
				  pat_info_temp[j] = pat_info_backup[i]
				  j++
				}
			}
		}

		ref.pat_info = pat_info_temp;
		pat_info_backup = pat_info_temp;
		
		if(pat_info_backup != null)
		{
			pat_info_len = pat_info_backup.length;

			if(pat_info_len > 1)
			{
				var j=0
				pat_info_temp = new Array()
				
				for(var i=0;i<pat_info_len;i++)
				{
					if(pat_info_backup[i].winname!=null && pat_info_backup[i].winname !=top.name )
					{
						pat_info_temp[j] = pat_info_backup[i]
						j++
					}
				}
			}
	   }	
	  

		if(pat_info_backup != null)
		{				
			pat_info_len = pat_info_backup.length;
			if(pat_info_len > 1)
			{	
				var dialogHeight= 1 ;
				if(ref.pat_info.length > 4)
					dialogHeight = ref.pat_info.length *2;
				var dialogWidth = "45" ;
				var dialogTop = "117" ;
				var dialogLeft = "50" ;
				var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";dialogTop:"+dialogTop+";dialogLeft:"+dialogLeft+";status=no;scroll=no;"
				var arguments   = "" ;
				if('<%=child_window%>'=="Y")
					pat_info_temp[pat_info_temp.length] ="CY"
				retVal =await  window.showModalDialog("ShowPatients.jsp?child_window=<%=child_window%>&patientID=<%=patientId%>&episodeID=<%=episodeId%>&visitID=<%=visitId%>",pat_info_temp,features);
				if(retVal != "CD" )
				{					
					if(retVal != null )
					{
						for(var i=0;i<pat_info_temp.length;i++)
						{
							//alert(pat_info_temp[i].winname);
							if(pat_info_temp[i].winname == retVal)
							{								
								pat_info_temp[i] .window_obj.focus();
								break;
							}
						}
					}
				}
				else
				{					
					top.opener.document.focus() ;
					//alert(top.opener.name);
				//	window.top.opener.focus();
					//eHISMain1
					
					//top.opener.focus() ;
					//top.opener.close() ;
				}
			}
			else
			{
				if(pat_info_len == 1)
				{
					 if('<%=child_window%>'=="Y"){
						   //top.opener.top.focus();
						  top.opener.document.focus();
						   }
					else
					{
						pat_info_temp[0].window_obj.focus();}
				}
				else
					alert(getMessage("NO_PATIENT_SELECTED","CA"))
			}	
		} // not patinfo null
	}
	/*else if('<%=fromPatChart%>' == "FromPatChart")
	{
		if('<%=child_window%>'=="Y")
		{
			top.opener.focus();
			top.opener.top.content.CommonToolbar.document.getElementById("searchPatHome").click();
		}
	}*/
}
</script>
<script>
	top.content.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
</script>
<%
	//if(sessionPatMap != null) sessionPatMap.clear();
	//if(sessionIDList != null) sessionIDList.clear();
	//if(patTempMap != null) patTempMap.clear();
%>

</BODY>
</HTML>

