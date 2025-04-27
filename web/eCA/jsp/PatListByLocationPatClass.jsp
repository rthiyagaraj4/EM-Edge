<!DOCTYPE html>
<%@ page import="java.sql.*,java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")? (String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/ValidateControl.js'	language='javascript'></script>
<script src='../../eCA/js/PatientListByLocationResult.js'	language='javascript'></script>
<script src='../../eCA/js/PatListByLocation.js'	language='javascript'></script>
<script src='../../eCommon/js/common.js'			language='javascript'></script>
</head>

<STYLE TYPE="text/css">
A:link {
	COLOR: white;
}

A:visited {
	COLOR:white ;
}
A:active {
	COLOR: white;
}
</STYLE>

<%
	
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	eCA.PatSearch PatSearch = (eCA.PatSearch)getObjectFromBean("PatSearch","eCA.PatSearch",session);

	String queryString  = request.getQueryString();	
	String allowSecondLevel = request.getParameter("allowSecondLevel");
	String Summary=request.getParameter("Summary")==null?"":request.getParameter("Summary");
	String groupByEpisode = request.getParameter("groupByEpisode")==null?"":request.getParameter("groupByEpisode");

	String locnHandle;
	String rp_hanlde="";;
	if (Summary.equals("Summary"))
		locnHandle="parent.parent";
	else
		locnHandle="top.content.workAreaFrame";

	if(allowSecondLevel == null || allowSecondLevel.equals(""))
		allowSecondLevel="";

	String locationType     = request.getParameter("locationType");
	if(locationType == null || locationType =="") 
		locationType="";
	
	String classArray[] = new String[5];
	
	HashSet patClassSet =PatSearch.getFirstLevel();
	
	int j=0;
	
	
	if(patClassSet!=null && patClassSet.size()>0)
	{
		Iterator itr = patClassSet.iterator();

		while(itr.hasNext())
		{
			classArray[j] = (String)itr.next();
			j++;
		}
	}
		
	patClassSet = null;

	if(classArray[0]==null )
	{
		%>
		<script language=javascript>

		if(eval('<%=locnHandle%>').PatResultFr.LocnResult.location != null)
		{
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
			
		}
		
		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	}
		
		rp_hanlde = classArray[0]==null?"":classArray[0];
		
		
		
%>
<script>
function callLevelTwo(obj)
{
	parent.parent.document.getElementById("PatCriteriaFr").style.height = "26vh";
	parent.parent.document.getElementById("PatResultFr").style.height = "60vh";
	//alert("here <%=allowSecondLevel%>   "+obj);
	if('<%=allowSecondLevel%>' == "Y"&&obj!="RP")
	{
		//makeVisible1(eval('<%=locnHandle%>').PatCriteriaFr.PatCriteriaFrm,eval('<%=locnHandle%>').PatCriteriaFr.PatCriteriaFrm.more,'N');
		makeVisible1(eval('<%=locnHandle%>').PatCriteriaFr,eval('<%=locnHandle%>').PatCriteriaFr.PatCriteriaFrm.more,'N');
		var url = '<%=queryString%>&pat_type='+obj;
		var count = url.indexOf("&pat_type=");
		url = url.substring(0,count);
		url = url+'&pat_type='+obj;
		eval('<%=locnHandle%>').PatResultFr.LocnResultLocation.location.href='../../eCA/jsp/PatListByLocationPatLocn.jsp?'+url;
		eval('<%=locnHandle%>').PatCriteriaFr.PatCriteriaFrm.url.value = url+'&locn_type='+obj;
		
	}
	else if('<%=allowSecondLevel%>' == "N"||obj=="RP")
	{
		//eval('<%=locnHandle%>').PatResultFr.resultFrameSet.rows ='7%,0%,0%,*';
		eval('<%=locnHandle%>').PatResultFr.LocnResultPatClass.style = "display";
		eval('<%=locnHandle%>').PatResultFr.LocnResultPatClass.style.height = "7vh"
		eval('<%=locnHandle%>').PatResultFr.LocnResultPatClass.style.width = "100vw";
		eval('<%=locnHandle%>').PatResultFr.LocnResultLocation.style.display = "none";
		eval('<%=locnHandle%>').PatResultFr.LocnResultTitle.style.display = "none";
		eval('<%=locnHandle%>').PatResultFr.LocnResult.style.height = "91vh"
		eval('<%=locnHandle%>').PatResultFr.LocnResult.style.width = "100vw";
		var url = '<%=queryString%>&locn_type='+obj;
		eval('<%=locnHandle%>').PatResultFr.LocnResultLocation.location.href='../../eCA/jsp/PatListByLocationPatLocn.jsp?'+url+'&pat_type='+obj;
		/*added by Deepa on 6/9/2009 at 3:57 PM for IN011216*/
		if(obj!="RP")
		{
			eval('<%=locnHandle%>').PatCriteriaFr.PatCriteriaFrm.url.value = url;
			//eval('<%=locnHandle%>').PatResultFr.LocnResultLocation.url.value = url;
		}
		/*added by Deepa on 6/9/2009 at 3:57 PM for IN011216*/
		if(obj=="RP")
		{
			eval('<%=locnHandle%>').PatResultFr.LocnResultLocation.location.href ='../../eCommon/html/blank.html';
			eval('<%=locnHandle%>').PatCriteriaFr.PatCriteriaFrm.url.value = url;
			//eval('<%=locnHandle%>').PatResultFr.LocnResultTitle.location.href ='../../eCA/jsp/PatListByLocationTitle.jsp?locn_type='+obj;
			//top.content.workAreaFrame.PatResultFr.LocnResultTitle.location.href='../../eCA/jsp/PatListByLocationTitle.jsp?locn_type='+obj;
		}
		eval('<%=locnHandle%>').PatResultFr.LocnResult.location.href='../../eCA/jsp/PatListByLocationResult.jsp?'+url;		
	}

	if(eval('<%=locnHandle%>').PatResultFr.LocnResultTitle.location.href.indexOf(".jsp") != -1){
	   eval('<%=locnHandle%>').PatResultFr.LocnResultTitle.location.href='../../eCommon/html/blank.html';
	}
}
</script>
			<body class ='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
                    <form name="formLocnResultPatClass" id="formLocnResultPatClass">
                        <table border='0' cellpadding='0' cellspacing='0' class='' id="tab" width="50%">
                        <tr>
<%
                            String classValue="";
                            for(int i=0;i<classArray.length;i++)        {
                                if(i==0)  classValue="FIRSTSELECTED";
                                else classValue="FIRSTNORMAL";
						
                                if(classArray[i]!=null){%>
                                        <th class='<%=classValue%>'  align="center" onMouseOver='callOnMouseOver(this);' onMouseOut='callOnMouseOut(this);'style='cursor:pointer;' onclick="display(this);callLevelTwo('<%=classArray[i]%>');" >
										<a href="javascript:callLevelTwo('<%=classArray[i]%>');"> <%=getPatientClassName(classArray[i],pageContext)%></a></th>
<%                          }
                             }
%>
                        </tr>
                        </table>
                            <input type="hidden" name="queryString" id="queryString" value="<%=queryString%>">
                            <input type="hidden" name="url" id="url" value="">						
                        </form>
            </body>

<%
        String pat_type = "";
        if(classArray[0]!=null){
            pat_type = classArray[0];
            if(!allowSecondLevel.equals("")){%>
            <script>
				if('<%=rp_hanlde%>'=="RP")
				{	
					var url1 = '<%=queryString%>&locn_type=RP';
					if('<%=groupByEpisode%>'=='Y')
					{
						//eval('<%=locnHandle%>').PatResultFr.resultFrameSet.rows ='4.5%,0%,0%,*';
						eval('<%=locnHandle%>').PatResultFr.LocnResultPatClass.style = "display";
						eval('<%=locnHandle%>').PatResultFr.LocnResultPatClass.style.height = "7vh"
						eval('<%=locnHandle%>').PatResultFr.LocnResultPatClass.style.width = "100vw";
						eval('<%=locnHandle%>').PatResultFr.LocnResultLocation.style.display = "none";
						eval('<%=locnHandle%>').PatResultFr.LocnResultTitle.style.display = "none";
						eval('<%=locnHandle%>').PatResultFr.LocnResult.style.height = "91vh"
						eval('<%=locnHandle%>').PatResultFr.LocnResult.style.width = "100vw";
					}
					else if('<%=groupByEpisode%>'=='N')
					{
						//eval('<%=locnHandle%>').PatResultFr.resultFrameSet.rows ='0%,0%,0%,*';
						eval('<%=locnHandle%>').PatResultFr.LocnResultPatClass.style.display = "none";
						eval('<%=locnHandle%>').PatResultFr.LocnResultLocation.style.display = "none";
						eval('<%=locnHandle%>').PatResultFr.LocnResultTitle.style.display = "none";
						eval('<%=locnHandle%>').PatResultFr.LocnResult.style.height = "91vh"
						eval('<%=locnHandle%>').PatResultFr.LocnResult.style.width = "100vw";
					}
			
					eval('<%=locnHandle%>').PatCriteriaFr.PatCriteriaFrm.document.forms[0].url.value = url1;
					eval('<%=locnHandle%>').PatResultFr.LocnResult.location.href='../../eCA/jsp/PatListByLocationResult.jsp?'+'<%=queryString%>&pat_type=RP&locn_type=RP';

				}
				else
				{
					eval('<%=locnHandle%>').PatResultFr.LocnResultLocation.location.href='../../eCA/jsp/PatListByLocationPatLocn.jsp?<%=queryString%>&pat_type=<%=pat_type%>';			
				}
			 //alert('<%=queryString%>');
			 //alert(top.content.workAreaFrame.PatResultFr.LocnResultLocation.location.href);
            </script>
<%
            }
        }
%>
</html>

<%!
        String getPatientClassName(String code,PageContext pgContxt)
        {
            if(code!=null)
            {
                if(code.equals("IP"))
				return com.ehis.util.BundleMessage.getBundleMessage(pgContxt,"Common.inpatient.label","common_labels");
                else if(code.equals("OP"))
				return com.ehis.util.BundleMessage.getBundleMessage(pgContxt,"Common.Outpatient.label","common_labels");
                else if(code.equals("EM"))
				return com.ehis.util.BundleMessage.getBundleMessage(pgContxt,"Common.emergency.label","common_labels");
                else if(code.equals("DC"))
				return com.ehis.util.BundleMessage.getBundleMessage(pgContxt,"Common.daycare.label","common_labels");
				else if(code.equals("RP"))
				return com.ehis.util.BundleMessage.getBundleMessage(pgContxt,"Common.referral.label","common_labels");
            }
            return null;
        }
%>

