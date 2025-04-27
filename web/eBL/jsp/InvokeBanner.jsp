<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,eBL.InvokeBannerBean,eBL.Common.BlRepository " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
%>
 
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<!--<script language="javascript" src='../js/BLBanner.js'></script> -->
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
 <script>
 	$(document).ready(function(){
 		var bannerSize = $('#bannerSize').val();
 		if(bannerSize>3){
 			$('#miniBanner').show();
 			$('#maxiBanner').hide();
 		}
 		else{
 			$('#miniBanner').hide();
 			$('#maxiBanner').show();
 		}
 	});
	   var headTop = -1;
	   var FloatHead1;
	   function processScroll()
	   	{
	   		if (headTop < 0)
	   		{
	   			saveHeadPos();
	   			
	   		}
	   		if (headTop>0)
	   		{
	   			if (document.documentElement && document.documentElement.scrollTop)
	   				theTop = document.documentElement.scrollTop;
	   			else if (document.body)
	   				theTop = document.body.scrollTop;
	    
	   			if (theTop>headTop)
	   				FloatHead1.style.top = (theTop-headTop) + 'px';
	   			else
	   				FloatHead1.style.top = '0px';
	   		}
	   	}
	    
	   	function saveHeadPos()
	   	{
	   		parTable = document.getElementById("divHeadSep");
	   		if (parTable != null)
	   		{
	   			headTop = parTable.offsetTop + 3;
	   			FloatHead1 = document.getElementById("heading");
	   			FloatHead1.style.position = "relative";
	   		}
	   	}
	   	
	   	function ShowMaximum(size)
	   	{
	   		/*if(size>2)
	   		{
	   			document.getElementById("miniBanner").style.visibility='hidden';
		   		document.getElementById("maxiBanner").style.visibility='visible';
	   		}*/
	   		$('#miniBanner').hide();
 			$('#maxiBanner').show();  		
	   	}
	  
		function ShowMinimize()
	   	{
			/*document.getElementById("maxiBanner").style.visibility='hidden';
	   		document.getElementById("miniBanner").style.visibility='visible';*/
			$('#miniBanner').show();
 			$('#maxiBanner').hide();	 
	   	}
	  
</script>
<style>
	   		thead td, thead td.locked	{
	   		background-color: navy;
	   		color: white;
	   		position:relative;}	
	   		thead td {
	   		top: expression(document.getElementById("tbl-container").scrollTop-4); 
	   		z-index: 20;}
	   		thead td.locked {z-index: 30;}
	   		td.locked,  th.locked{
	   		left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
	   		position: relative;
	   		z-index: 10;}
	   		td.locked,  th.locked{
	   		left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
	   		position: relative;
	   		z-index: 10;}
	   		</style>
<%	  
String locale																				=	null;
String facilityId																			=	null;
String loggedInUser																			=	null;
String bean_id																				= 	null;
String bean_name																			= 	null;
ArrayList bannerList				 														=   null;
HashMap bannerListMap																		=   null;
HashMap	tabdata																				=	null;
String miniBannerVisibility																	=	"";
Iterator iterator																			=	null;
try
		{		
			locale																			= 	(String)session.getAttribute("LOCALE");
			facilityId																		= 	(String) session.getValue( "facility_id" ) ;
			loggedInUser																	=  	(String) session.getValue("login_user");	
			bannerList				 														=   new ArrayList();
			bannerListMap																	=   new HashMap();
			tabdata																			=	new HashMap();
			bean_id																			=	"InvokeBannerBean";
			bean_name																		=	"eBL.InvokeBannerBean";
			InvokeBannerBean	invokeBannerBean											=	(InvokeBannerBean)getBeanObject( bean_id, bean_name, request ) ;
			miniBannerVisibility															=	"hidden";
			
			tabdata.put("login_user",		loggedInUser);
			tabdata.put("facility_id"	, 	facilityId);
			tabdata.put("userid"		,  	checkForNull(request.getParameter("userid")));
			tabdata.put("userrespid"	, 	checkForNull(request.getParameter("userrespid")));
			tabdata.put("functionid"	, 	checkForNull(request.getParameter("functionid")));
			tabdata.put("patientid"		, 	checkForNull(request.getParameter("patientid")));
			tabdata.put("episodetype"	, 	checkForNull(request.getParameter("episodetype")));
			tabdata.put("episodeid"		, 	checkForNull(request.getParameter("episodeid")));
			tabdata.put("visitid"		, 	checkForNull(request.getParameter("visitid")));   
			tabdata.put("blnggrpid"		, 	checkForNull(request.getParameter("blnggrpid")));
			tabdata.put("custgroupcode"	, 	checkForNull(request.getParameter("custgroupcode")));
			tabdata.put("custcode"		, 	checkForNull(request.getParameter("custcode")));
			tabdata.put("locale"		, 	locale);    
				
			System.out.println("facilityId IN InvokeBanner.JSP::: "+facilityId);
%>	
<div id="BannerHead"  name="BannerHead" style="visibility: visible;">

<div id="miniBanner" name="miniBanner" style="display: none;">	 
  
<TABLE width="100%" CELLSPACING=0 cellpadding=2 align='center'>

<%
bannerListMap = invokeBannerBean.invokeBanner(tabdata);
int bannerLimit = 3;
int bannerSize = bannerListMap.size();
iterator= bannerListMap.keySet().iterator(); 
System.out.println("In InvokeBanner.jsp bannerListMap:::::::"+bannerListMap);

for(int k=0;k<bannerLimit && iterator.hasNext();k++)
{

	
	int key =    (Integer)iterator.next();
		System.out.println("In InvokeBanner.jsp::miniBanner:::invokeBanner key:::::"+key);
		invokeBannerBean = (InvokeBannerBean) bannerListMap.get(key);
			System.out.println("INDEX::: "+key+" ::::COLUMN1::::::::::: 		"+invokeBannerBean.getCloumn1());
			System.out.println("INDEX::: "+key+" ::::COLUMN1VALUE:::::: 		"+invokeBannerBean.getCloumn1Value());
			System.out.println("INDEX::: "+key+" ::::COLUMN2::::::::::: 		"+invokeBannerBean.getCloumn2());
			System.out.println("INDEX::: "+key+" ::::COLUMN2VALUE:::::: 		"+invokeBannerBean.getCloumn2Value());
			System.out.println("INDEX::: "+key+" ::::COLUMN3::::::::::: 		"+invokeBannerBean.getCloumn3());
			System.out.println("INDEX::: "+key+" ::::COLUMN3VALUE:::::: 		"+invokeBannerBean.getCloumn3Value());
	%>
				<tr >
					<td  class="columnheader" ><%=invokeBannerBean.getCloumn1() %></td>
					<td  class="columnheader" ><%=invokeBannerBean.getCloumn1Value()%></td>
					<td  class="columnheader" ><%=invokeBannerBean.getCloumn2() %></td>
					<td  class="columnheader" ><%=invokeBannerBean.getCloumn2Value() %></td>
					<td  class="columnheader" ><%=invokeBannerBean.getCloumn3() %></td>
					<td  class="columnheader" ><%=invokeBannerBean.getCloumn3Value() %></td>    
				</tr>		
<%
}	
%>
<tr>
<td  class="columnheader" ></td>
<td  class="columnheader" ></td>
<td  class="columnheader" ></td>
<td  class="columnheader" ></td>
<td  class="columnheader" ></td>
   
<td  class="columnheader"  onclick="ShowMaximum('<%=bannerListMap.size()%>')"><%= bannerListMap.size()>bannerLimit ? "Maximize" : "" %></td>    
</tr>
</TABLE>
</div>



<div id="maxiBanner" name="maxiBanner" style="display: none;">	 
  
<TABLE width="100%" CELLSPACING=0 cellpadding=2 align='center'>

<%


bannerListMap = invokeBannerBean.invokeBanner(tabdata);
iterator= bannerListMap.keySet().iterator(); 
while(iterator.hasNext())
{
	
	int key =    (Integer)iterator.next();
	
		System.out.println("In InvokeBanner.jsp:::::maxiBanner::::invokeBanner key:::::"+key);
		invokeBannerBean = (InvokeBannerBean) bannerListMap.get(key);
			System.out.println("INDEX::: "+key+" ::::COLUMN1::::::::::: 		"+invokeBannerBean.getCloumn1());
			System.out.println("INDEX::: "+key+" ::::COLUMN1VALUE:::::: 		"+invokeBannerBean.getCloumn1Value());
			System.out.println("INDEX::: "+key+" ::::COLUMN2::::::::::: 		"+invokeBannerBean.getCloumn2());
			System.out.println("INDEX::: "+key+" ::::COLUMN2VALUE:::::: 		"+invokeBannerBean.getCloumn2Value());
			System.out.println("INDEX::: "+key+" ::::COLUMN3::::::::::: 		"+invokeBannerBean.getCloumn3());
			System.out.println("INDEX::: "+key+" ::::COLUMN3VALUE:::::: 		"+invokeBannerBean.getCloumn3Value());
			
	%>
				<tr >
					<td  class="columnheader" ><%=invokeBannerBean.getCloumn1() %></td>
					<td  class="columnheader" ><%=invokeBannerBean.getCloumn1() %></td>
					<td  class="columnheader" ><%=invokeBannerBean.getCloumn2() %></td>
					<td  class="columnheader" ><%=invokeBannerBean.getCloumn2Value() %></td>
					<td  class="columnheader" ><%=invokeBannerBean.getCloumn3() %></td>
					<td  class="columnheader" ><%=invokeBannerBean.getCloumn3Value() %></td>    
				</tr>		
<%
		
}	
%>
<tr>
<td  class="columnheader" ></td>
<td  class="columnheader" ></td>
<td  class="columnheader" ></td>
<td  class="columnheader" ></td>
<td  class="columnheader" ></td>
   
<td  class="columnheader"  onclick="ShowMinimize()">Minimize</td>    
</tr>
</TABLE>
</div>


</div>		
<input type='hidden' name='bannerSize' id='bannerSize' id='bannerSize' value='<%=bannerSize%>'>

	</body>

<%
	}catch(Exception e){out.println("EXCEPTION IN INVOKEBANNER.JSP::::"+e);}
	
%>
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

