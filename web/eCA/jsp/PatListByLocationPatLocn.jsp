<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           	created
04/1/2012     101            Chowminya      Incident No: IN030239 - <Search Patient by location, to restore missing locations>
24/01/2013	IN030532		Karthi L		CA Patient List to have option to call a specific patient queue no	
21/04/2014	IN048617		Karthi L		This is an issue for integration between Queue Management System and generating queue number in CA.
---------------------------------------------------------------------------------------------------------------
--> 
<%@ page import="webbeans.eCommon.*, java.sql.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
   request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	eCA.PatSearch PatSearch = (eCA.PatSearch)getObjectFromBean("PatSearch","eCA.PatSearch",session);
	Connection conn = null; // added for CRF 192
	try {
		conn=ConnectionManager.getConnection(request);
%>

<html>
	<head>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		 <script src='../js/PatientListByLocationResult.js' language='javascript'></script>
		 <script language='javascript' src='../../eCommon/js/common.js'></script>

 <%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
 
 <title>View Patient List by Location Result (by Locn)</title>
		<SCRIPT LANGUAGE="JavaScript">

</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<%
			String queryString  ="";
			queryString			  = request.getQueryString();
			String Summary=request.getParameter("Summary")==null?"":request.getParameter("Summary");
			String facility_id=(String)session.getValue("facility_id");

			//String locationType=request.getParameter("locationType");
		%>

	<style>
		A:link {
			COLOR: white;
		}

		/* TD.FIRSTSELECTED
		{
			FONT-SIZE: 8pt ;
			background-color : #3399CC;
			border-width: thin ;
			border-style: inset;
			BORDER-LEFT-COLOR: #696969;
			BORDER-RIGHT-COLOR: #696969;
			BORDER-TOP-COLOR: #696969;
			BORDER-BOTTOM-COLOR: #696969 ;
		}
		TD.FIRSTNORMAL
		{
			FONT-SIZE: 8pt ;
			background-color : SLATEGRAY;
			border-width: thin ;
			border-style: inset;
			BORDER-LEFT-COLOR: #696969;
			BORDER-RIGHT-COLOR: #696969;
			BORDER-TOP-COLOR: #696969;
			BORDER-BOTTOM-COLOR: #696969 ;
		}

		TD.SECONDSELECTED{
			FONT-SIZE: 8pt ;
			background-color : SLATEGRAY;
			border-width: thin ;
			border-style: inset;
			BORDER-LEFT-COLOR: #696969;
			BORDER-RIGHT-COLOR: #696969;
			BORDER-TOP-COLOR: #696969;
			BORDER-BOTTOM-COLOR: #696969 ;
		}
		TD.SECONDNORMAL{
			FONT-SIZE: 8pt ;
			background-color : PALEVIOLETRED;
			border-width: thin ;
			border-style: inset;
			BORDER-LEFT-COLOR: #696969;
			BORDER-RIGHT-COLOR: #696969;
			BORDER-TOP-COLOR: #696969;
			BORDER-BOTTOM-COLOR: #696969 ;
		} */

		A:visited {
			COLOR:white ;
		}
		A:active {
			COLOR: white;
		}
		</STYLE>
	</style>
<script>

	function callResult(obj, obj1,current_pos){
		//alert('in call result');
		
		if(obj1 != ""){
			if(document.getElementById("locnTab") == null){
				if(document.getElementById("locnTab").rows[0].cells[1].className=="FIRSTSELECTED");
					document.getElementById("locnTab").rows[0].cells[1].className="FIRSTNORMAL"
			}
			var qryStr = '<%=queryString%>';
			document.forms[0].currentPos.value=current_pos;
			url = qryStr+'&locn_type='+obj+'&locn_code='+obj1;
			if(document.forms[0]!=null){
				document.forms[0].url.value=url;
			}
			
			if ("<%=Summary%>" == "Summary")
			{
				parent.parent.PatResultFr.LocnResultPatClass.document.forms[0].url.value=url;
				parent.parent.PatResultFr.LocnResultTitle.location.href='../../eCA/jsp/PatListByLocationTitle.jsp?locn_type='+obj+'&Summary=Summary';
			}else{
			top.content.workAreaFrame.PatResultFr.LocnResultPatClass.document.getElementById('url').value=url;
			top.content.workAreaFrame.PatCriteriaFr.document.getElementById('url').value=url;
			//PatCriteriaFr.PatCriteriaFrm.document.forms[0].url.value
			top.content.workAreaFrame.PatResultFr.LocnResultTitle.location.href='../../eCA/jsp/PatListByLocationTitle.jsp?locn_type='+obj;
			}
		}
	}

</script>
</head>

<%! int maxCount = 0;%>
<%
	int from_disp = 0;
	int to_disp = 6; //--[IN030239]
	ArrayList beanList  = new ArrayList();
	HashMap hLocn		= new HashMap();
	String locn_short_desc="", locn_code="", pat_type="";
	String disabled_next ="", disabled_prev = "", qryLocnCode="";
	pat_type		= request.getParameter("pat_type");
	qryLocnCode		= request.getParameter("locationCode");

	//out.println("<script>alert('in begin')</script>");	

	String labelCounter1 = request.getParameter("labelCounter")==null?"0":request.getParameter("labelCounter");
	int labelCounter=Integer.parseInt(labelCounter1);
	int tempLabelCounter=labelCounter;
	String flagYN = request.getParameter("flagYN")==null?"":request.getParameter("flagYN");
	String flagLastYN = request.getParameter("flagLastYN")==null?"":request.getParameter("flagLastYN");

	if(queryString	== null)queryString="";
	if(pat_type	== null)pat_type="";
	if(qryLocnCode ==  null) qryLocnCode = "";

	try{
		//String pract_id		= (String)session.getValue("ca_practitioner_id");
		//String facility_id	= (String)session.getValue("facility_id");
		String isError = "";
		boolean isFirstLevel = false;
		if(pat_type.equals("")){
			isError="QQ";
		}
		if(isError.equals("")){
			isFirstLevel = PatSearch.isFirstLevel();
			if(isFirstLevel)
			{
				beanList = PatSearch.getSecondLevel(pat_type);

				maxCount = beanList.size();
			}
		}
	}catch(Exception e){
		e.printStackTrace() ;
	}finally {
}

	String start = request.getParameter("start_disp");

	String end = request.getParameter("end_disp");
	%>
	<script>
	function callOnLoad(){
		
			<%

				if(start == null && maxCount>0){
					from_disp = 0;
					flagYN = "true";
					String ln_code ="";
					HashMap hTable = (HashMap)beanList.get(0);
					ln_code = (String)hTable.get("LOCN_CODE");
					if(!qryLocnCode.equals("")){
						if(qryLocnCode.equals("*ALL") || qryLocnCode.equals("Z")){
			%>
								callResult('<%=pat_type%>','<%=ln_code%>','0');
			<%		}else{		%>
								callResult('<%=pat_type%>','<%=qryLocnCode%>','0');
			<%
						}
					}
					//pra	}//end of maxCount
				}else{

                     if(start != null)
         			from_disp = Integer.parseInt(start);
					 else
                      from_disp = 0;
				}
			%>
	}
	</script>

	<%
	if(end == null)
		to_disp = 2; //--[IN030239]
	else
		to_disp = Integer.parseInt(end);

	if(to_disp >= maxCount){

		disabled_next = "disabled";
	}else{
		disabled_next = "";
	}

	if(from_disp <= 0) //--[IN030239]
	{
		disabled_prev = "disabled";
	}else{
		disabled_prev = "";
	}
%>

	<body class='CONTENT'  onload='fillUrl("<%=Summary%>"); callOnLoad();'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="formLocnResultLocation" id="formLocnResultLocation">
			<table border='0' cellpadding='0' cellspacing='0' width='100%' class='' id='locnTab'>
				<tr id="tr_prev">
					<td align='left' class='button'  width='4%'><input type='button' name='prev' id='prev' class='button' value="  <<  " <%=disabled_prev%> onClick="showPrevLocn();" style="font-size:6pt" title='Previous'></td>
					<% 
					//pra	if(maxCount>0){
					String className = "";
					if(flagYN.equals("false") && !flagLastYN.equals("true"))
					{
							className = "FIRSTSELECTED";
							hLocn			=	(HashMap)beanList.get(labelCounter);
							locn_short_desc =	(String)hLocn.get("LOCN_SHORT_DESC");
							locn_code		=	(String)hLocn.get("LOCN_CODE");
							//added for CRF 192 - IN030532
							String clinic_qms_interfaced_yn=eOP.QMSInterface.isClinicQMSInterfaced(locn_code,facility_id,conn);
							if(clinic_qms_interfaced_yn.equals("Y")){
							%>
								<td id='callnext'  width='1%'> &nbsp;
							<img style='cursor:pointer;' src='../../eCommon/images/callNext.png' alt='Call Next Patient' onclick="callNextPatient();"/></td> <!-- IN048617 added -callNextPatient() -->
							<%
							}//end
							%> 
						<th class='<%=className%>' align="center" onMouseOver='callOnMouseOver(this);' onMouseOut='callOnMouseOut(this);'style='cursor:pointer;'onclick="displayLoc(this);callResult('<%=pat_type%>','<%=locn_code%>','<%=labelCounter%>');"  width='15%' align='center'><a href="javascript:callResult('<%=pat_type%>','<%=locn_code%>','<%=labelCounter%>');"><nobr><%=locn_short_desc%></nobr></a></th>
					<%
					}//--[IN030239]
					for(int i=from_disp; i<=to_disp; i++){
						labelCounter=i;
						if(i==tempLabelCounter)
								className = "FIRSTSELECTED";
						else
								className = "FIRSTNORMAL";

						if(i < maxCount ){
							hLocn			=	(HashMap)beanList.get(i);
							locn_short_desc =	(String)hLocn.get("LOCN_SHORT_DESC");
							locn_code		=	(String)hLocn.get("LOCN_CODE");

						}else{
								className="WHITE";
								locn_short_desc ="&nbsp;";
								locn_code	    ="";
						}
						if(locn_short_desc == null)locn_short_desc="";
						if(locn_code == null)locn_code="";
						//added for CRF 192 - IN030532
						String clinic_qms_interfaced_yn=eOP.QMSInterface.isClinicQMSInterfaced(locn_code,facility_id,conn);
						
						if(clinic_qms_interfaced_yn.equals("Y")){
						%>
							<td id='callnext'  width='1%'> &nbsp;
							<img style='cursor:pointer;' src='../../eCommon/images/callNext.png' alt='Call Next Patient' onclick="callNextPatient();"/></td> <!-- IN048617 added -callNextPatient() -->
						<%
						}
						%>
							<th class='<%=className%>' align="center" onMouseOver='callOnMouseOver(this);' onMouseOut='callOnMouseOut(this);'style='cursor:pointer;'							onclick="displayLoc(this);callResult('<%=pat_type%>','<%=locn_code%>','<%=labelCounter%>');"  width='15%' align='center'><a href="javascript:callResult('<%=pat_type%>','<%=locn_code%>','<%=labelCounter%>');"><nobr><%=locn_short_desc%></nobr></a></th>
					<%		
					}
					if(flagLastYN.equals("true"))
					{
							className = "FIRSTSELECTED";
							hLocn			=	(HashMap)beanList.get(tempLabelCounter);
							locn_short_desc =	(String)hLocn.get("LOCN_SHORT_DESC");
							locn_code		=	(String)hLocn.get("LOCN_CODE");
							String clinic_qms_interfaced_yn=eOP.QMSInterface.isClinicQMSInterfaced(locn_code,facility_id,conn);
							
						//added for CRF 192 - IN030532
						if(clinic_qms_interfaced_yn.equals("Y")){
						%>
							<td id='callnext'  width='1%'> &nbsp;
							<img style='cursor:pointer;' src='../../eCommon/images/callNext.png' alt='Call Next Patient'  onclick=""/></td>
						<%
						}
						%>
						<th class='<%=className%>' align="center" onMouseOver='callOnMouseOver(this);' onMouseOut='callOnMouseOut(this);''style='cursor:pointer;' onclick="displayLoc(this);callResult('<%=pat_type%>','<%=locn_code%>','<%=labelCounter%>');"  width='15%' align='center'><a href="javascript:callResult('<%=pat_type%>','<%=locn_code%>','<%=tempLabelCounter%>');"><nobr><%=locn_short_desc%></nobr></a></th>
					<%
					}
					%>
					<td align='right' class='button' width='4%'><input type='button' name='next' id='next' class='button' value="  >>  " <%=disabled_next%> onClick="showNextLocn();" style="font-size:6pt" title='Next' ></td>
				</tr>
				<input type="hidden" name="pat_type" id="pat_type" value="<%=pat_type%>"><input type="hidden" name="queryString" id="queryString" value="<%=queryString%>">
				<input type="hidden" name="url" id="url" value=''>
				<input type="hidden" name="currentPos" id="currentPos" value='<%=tempLabelCounter%>'>
				<input type="hidden" name="from_disp" id="from_disp" value='<%=from_disp%>'>
				<input type="hidden" name="to_disp" id="to_disp" value='<%=to_disp%>'>
				<input type="hidden" name="flagYN" id="flagYN" value='<%=flagYN%>'>
			</table>
		</form>
	</body>
</html>
<script>
	if ("<%=locn_short_desc%>"=="")
	{
		document.getElementById("tr_prev").style.display="none";
	} 
</script>
<%		}catch(Exception e){}
finally{
	
    if(conn!=null) ConnectionManager.returnConnection(conn,request);
}%>	
	

