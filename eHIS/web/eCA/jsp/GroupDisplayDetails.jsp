<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History   	Name        		Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
18/04/2018	IN061884		Raja S			18/04/2018		Ramesh G		ML-MMOH-CRF-0536
22/10/2018	IN068145		Raja S			22/10/2018		Ramesh G		ML-MMOH-CRF-1212
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page import="java.sql.*,webbeans.eCommon.*,eCA.*,eCA.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
    <head>
    <style>
    .test
    {
    clear: both;
    }

.container {
	/*overflow: scroll; -- commented for IN068145*/
	/*height: 50px;  -- commented for IN068145*/
}
td span {
	font-weight:bold;
	font-size:12px;
	
}
.gridTooltipData
{
	background-color: #FEFFE5;
	font-family: Verdana;
	font-size: 8pt;
	color: #000000;
	font-weight:normal;
	text-align:left;
	padding-left:10px;
	padding-right:10px;
	padding-top:10px;
	padding-bottom:10px;
	vertical-align:middle;
	border-bottom:1px;
	border-top:1px;
	border-left:1px;
	border-right:1px;
	border-style:solid;
	border-color:#DCDCDC;
} 
.gridDataSelect
{
	background-color: #CDE5FF;
	font-family: Verdana;
	font-size: 8pt;
	color: #000000;
	font-weight:normal;
	text-align:left;
	padding-left:10px;
	padding-right:10px;
	vertical-align:middle;
	border-bottom:1px;
	border-top:1px;
	border-left:1px;
	border-right:1px;
	border-style:solid;
	border-color:#0460B5;
} 
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%
String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
    <title>Untitled Document</title>
	<link rel="stylesheet" href="../../eCommon/html/<%=sStyle%>" type="text/css" />
    <link href="../../eCA/html/GroupDisplayStyle.css" rel="stylesheet" type="text/css" />
    <link href="../../eCA/html/GroupDisplayWeb.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="../../eCA/js/GroupDisplay.js"></script>
    <script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
    <script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>

    </head>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<%
	Properties p;
	session = request.getSession(false);
	p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	Connection con = null;
	ArrayList eventClassArr = new ArrayList() ;
	ArrayList groupTreeArr = new ArrayList() ;
	String bean_id					= "GroupCompDetailBean" ;
	String bean_name				= "eCA.GroupCompDetailBean";
	String patient_id				= request.getParameter("patient_id");
	String clinician_id			= (String) session.getValue("ca_practitioner_id");
	String resp_id = (String)session.getValue("responsibility_id");
	String encounterId = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String strNormalcyInd = request.getParameter("normalcy")==null?"N":request.getParameter("normalcy");
	String fromDate="",toDate="";
	String fac_id = (String)session.getValue("facility_id");
	fromDate = request.getParameter("from_date")==null	?"":request.getParameter("from_date");
	toDate = request.getParameter("to_date")==null	?"":request.getParameter("to_date");
	
	if (toDate.equals(""))
		toDate		= com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
	


	String grphistory_type			= request.getParameter("grphistory_type")==null	?"":request.getParameter("grphistory_type");
	String loadDefaultGrp			= request.getParameter("loadDefaultGrp")==null	?"":request.getParameter("loadDefaultGrp");
	String loadDefaultclass			= request.getParameter("loadDefaultclass")==null	?"":request.getParameter("loadDefaultclass");
	String loadDefaultYear			= request.getParameter("loadDefaultYear")==null	?"":request.getParameter("loadDefaultYear");
	String loadDefaultMonth			= request.getParameter("loadDefaultMonth")==null	?"":request.getParameter("loadDefaultMonth");
	String catalog_nature			= request.getParameter("orderCatalogNature")==null	?"":request.getParameter("orderCatalogNature");
	GroupCompDetailBean bean	= (GroupCompDetailBean)getBeanObject( bean_id, bean_name , request) ; 

try
{
	con = ConnectionManager.getConnection(request);	
	eventClassArr = bean.getEventClass(con,locale,patient_id,encounterId,clinician_id,resp_id,catalog_nature,grphistory_type,fromDate,toDate);
	if(eventClassArr!=null && !(eventClassArr.isEmpty()) )
	{
	%>
    <body>
    <form name="grpdispdetail" id="grpdispdetail">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td align="left" valign="middle" class="HeaderMenu"><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
            <%for(int i=0;i<eventClassArr.size();i++) {
            	String[] eventClassStr =(String[])eventClassArr.get(i);
            
            if(loadDefaultclass.equals("")){
            	loadDefaultclass=(String)eventClassStr[0];
            }
            if(loadDefaultclass.equals(eventClassStr[0])){%>
            <td width="4%" align="left" valign="top" onclick="loadgroup('<%=eventClassStr[0]%>')" class="HeaderMenutxt HMselect"><%=eventClassStr[1]%></td>
            <%}else{%>
            <td width="4%" align="left" valign="top" onclick="loadgroup('<%=eventClassStr[0]%>')" class="HeaderMenutxt"><%=eventClassStr[1]%></td>
           <%}
            } %>
             <td width="96%" align="left" valign="top"  class="">&nbsp;</td>
          </tr>
          </table></td>
      </tr>
      </table>
<%
	groupTreeArr=bean.getGroupTree(con,locale,grphistory_type,catalog_nature,loadDefaultclass,patient_id,encounterId,clinician_id,resp_id,fromDate,toDate);
	String tempGroupTest = "";
	String tempGroupYear = "";
	String tempGroupMonth = "";
	
	int totcount= groupTreeArr.size();
%>
<input type="hidden" name="totaltreecount" id="totaltreecount" value="<%=totcount%>"/>
	 <table width="100%" border="0" cellspacing="0" cellpadding="0" style="overflow:auto; position:relative;">
<% 	
for(int j=0;j<totcount;j++) {
	String groupStr[] =(String[])groupTreeArr.get(j);
	
	if(loadDefaultGrp.equals("")){
	loadDefaultGrp=groupStr[0];
	}

	if(!tempGroupTest.equals(groupStr[0])){
	tempGroupTest=groupStr[0];
	tempGroupYear = "";
	tempGroupMonth = "";
%>	
	  <tr>
        <td align="left" valign="top"><div>
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0" class="space">
                <%if(loadDefaultGrp.equals(groupStr[0])) {%>
                  <tr>
                    <td align="left" valign="top" value="Y" id="group<%=groupStr[0]%>" onclick="hidepanel('<%=groupStr[0]%>')" class="AcctxtimgSelect AcctxtimgSub" ><%=groupStr[1]%></td>
                    <input type="hidden" name="grpselectflg<%=j%>" id="grpselectflg<%=j%>" value='Y'/>
                    <input type="hidden" name="grpid<%=j%>" id="grpid<%=j%>" value=<%=groupStr[0]%>/>
                  </tr>
                  <%}else{ %>
                  <tr>
                    <td align="left" valign="top" value="N" class="Acctxtimg" id="group<%=groupStr[0]%>" onclick="hidepanel('<%=groupStr[0]%>')" ><%=groupStr[1]%></td>
                    <input type="hidden" name="grpselectflg<%=j%>" id="grpselectflg<%=j%>" value='N'/>
                    <input type="hidden" name="grpid<%=j%>" id="grpid<%=j%>" value=<%=groupStr[0]%>/>
                  </tr>
                  <%} %>
                  <tr>
                    <td style="display:none" id="panelview<%=groupStr[0]%>" value="N"><div  class="panelview">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="12%" align="left" valign="top" bgcolor="#f8f8f8"><div class="Maxheightpanel">
								<table width="100%" border="0" cellspacing="0" cellpadding="0" class="space">
						  			<tr>
										<td align="left" valign="top"><div>
											<table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <%for(int i=0;i<totcount;i++) {
					String[] yearValues= (String[])groupTreeArr.get(i);
			
					if(!tempGroupYear.equals(yearValues[2]) && tempGroupTest.equals(yearValues[0])) {
						tempGroupYear=(String)yearValues[2];

						if(loadDefaultYear.equals("")){
							loadDefaultYear=yearValues[2];
						}
%>				
											<%if(loadDefaultYear.equals(yearValues[2]) && loadDefaultGrp.equals(yearValues[0])) {%>
											  <tr>
												<td align="left" valign="top" id="year<%=tempGroupTest%><%=tempGroupYear%>" value="Y" onclick="hidemonth('<%=tempGroupTest%>','<%=tempGroupYear%>');" class="AcctxtimgSelect AcctxtimgSub"><%=yearValues[2]%></td>
								    		 </tr>
								    		 <%}else{%>
								    		  <tr>
												<td align="left" valign="top" id="year<%=tempGroupTest%><%=tempGroupYear%>" value="N" onclick="hidemonth('<%=tempGroupTest%>','<%=tempGroupYear%>');" class="Acctxtimg"><%=yearValues[2]%></td>
								    		 </tr>
								    		 <%} %>
								    		 
								  			 <tr>
												<td style="display:none" id="month<%=tempGroupTest%><%=tempGroupYear%>" value="N" ><div >
													<table width="100%" border="0" cellspacing="5" cellpadding="0" class="space">
													<%	for(int k=0;k<totcount;k++){
													String[] MonthValues= (String[])groupTreeArr.get(k);
													if(loadDefaultMonth.equals("")){
														loadDefaultMonth=MonthValues[3];
													}
													
														if(tempGroupYear.equals(MonthValues[2]) && tempGroupTest.equals(MonthValues[0])){
														
		
														%>
															<%if(loadDefaultMonth.equals(MonthValues[3]) && loadDefaultGrp.equals(MonthValues[0])) {%>
													  			<tr>
																	<td align="left" valign="top" value="N" id="monthsub<%=tempGroupTest%><%=tempGroupYear%><%=MonthValues[3]%>" onclick="loadvalues('<%=loadDefaultclass%>','<%=tempGroupTest%>','<%=tempGroupYear%>','<%=MonthValues[3]%>',this)" class="Acctxtimg"><%=MonthValues[3]%></td>
										  						</tr>
										  					<%}else{%>
										  					 	<tr>
																	<td align="left" valign="top" value="N" id="monthsub<%=tempGroupTest%><%=tempGroupYear%><%=MonthValues[3]%>" onclick="loadvalues('<%=loadDefaultclass%>','<%=tempGroupTest%>','<%=tempGroupYear%>','<%=MonthValues[3]%>',this)" class="Acctxtimg"><%=MonthValues[3]%></td>
										  						</tr>
										  					<%} %>
													<%	}
													}%>
													</table>
									  				</div></td> 
									  		 </tr>
<% 						  
					 }
						  
					}
%>											  				
								  			 
											</table>
							  			</div></td>
						  			</tr>
								</table>
					  		</div></td>
						<td width="88%" align="left" valign="top" class="test">
							<table width="100%" >
								<tr>
									<td  id="details<%=tempGroupTest%>">
									
									</td>
								</tr>
							</table>
                     
						</td>
				  	</tr>
				    </table></td>
			 	</tr>
		  		</table>
            	</div></td>
			</tr>
          </table></td>
		</tr>
		</table>
		</div></td>
	</tr>
<%	}
} %>
    </table>
    
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>"/>
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>"/>
<input type="hidden" name="locale" id="locale" value="<%=locale%>"/>
<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>"/>
<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounterId%>"/>
<input type="hidden" name="from_date" id="from_date" value="<%=fromDate%>"/>
<input type="hidden" name="to_date" id="to_date" value="<%=toDate%>"/>
<input type="hidden" name="grphistory_type" id="grphistory_type" value="<%=grphistory_type%>"/>
<input type="hidden" name="lastopenmonth" id="lastopenmonth" value=""/>
<input type="hidden" name="lastopengroup" id="lastopengroup" value=""/>
<input type="hidden" name="orderCatalogNature" id="orderCatalogNature" value="<%=catalog_nature%>"/>
<input type="hidden" name="clinician_id" id="clinician_id" value="<%=clinician_id%>"/>
<input type="hidden" name="resp_id" id="resp_id" value="<%=resp_id%>"/>
<input type='hidden' name='txtFlagComments' id='txtFlagComments' value="N">
<input type='hidden' name='txtFlagQuickText' id='txtFlagQuickText' value="N">
<input type='hidden' name='normalcy' id='normalcy' value="<%=strNormalcyInd%>">
<input type='hidden' name='queryStringForComments' id='queryStringForComments' value="">
<input type="hidden" name="fac_id" id="fac_id" value="<%=fac_id%>">


</form>
</body>
<div name='tooltiplayer' id='tooltiplayer'  style='position:absolute; width:30%; visibility:hidden;' bgcolor='yellow'>
	<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%' align='center'>
		<tr>
			<td width='100%' class='gridTooltipData' id='t' nowrap></td>
			</td>
		</tr>
	</table>
</div>
<script>
loadYearMonth('<%=loadDefaultclass%>','<%=loadDefaultGrp%>','<%=loadDefaultYear%>','<%=loadDefaultMonth%>');
</script>
<script>
			if(top.content!=null)
			{
				top.content.messageFrame.location.href="../../eCommon/html/blank.html";	
			}else
			{
				parent.parent.parent.messageFrame.location.href="../../eCommon/html/blank.html";	
			}
</script>
<%	}
	else{
		
		%>
		<script>
			//parent.dataFrame.location.href="../../eCommon/html/blank.html";
			if(top.content!=null)
			{
				top.content.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=APP-002415 Query caused no records to be retrieved.";	
			}else
			{
				parent.parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=APP-002415 Query caused no records to be retrieved.";	
			}
		</script>
			<%
		}

}
catch(Exception e)
{
	e.printStackTrace();
}
finally
{
	if(con!=null)ConnectionManager.returnConnection(con,request);
}
%>
</html>

