<!DOCTYPE html>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	 Rev.date           Rev.Name              Description                  
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	                                            created
26/06/2013    	IN039171		Dinesh	                                           System do not calculate 'day summary' in chart that summary  required such as ?intake/output chart?
15/05/2018      IN066995             RamyaMaddena       15/05/2018          Ramesh.G      comitted & modified for ARYU-SCF-0070[IN066995]
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,java.net.*,java.text.*,java.util.*,webbeans.eCommon.ConnectionManager,eCA.ChartComponentFormulaBean,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id='recordsBean' class='eCA.ChartComponentResultsetBean' scope='session' />
<html>
	<head>
		<title><fmt:message key="eCA.ChartComponentList.label" bundle="${ca_labels}"/></title>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script><!--IN066995-->
		<script language='javascript' src='../../eCA/js/ChartComponent.js'></script>		
	</head>
	<body OnMouseDown="CodeArrest()"  onKeyDown="lockKey()">
	<script language='javascript'>
	document.body.style.scrollbarBaseColor='#E2E3F0';
	document.body.style.scrollbarArrowColor='#000080';
	document.body.style.scrollbarDarkShadowColor='#E2E3F0';
	document.body.style.scrollbarFaceColor='#E2E3F0';
	document.body.style.scrollbarHighlightColor='white';
	document.body.style.scrollbarShadowColor='#E2E3F0';
	document.body.style.scrollbar3dlightColor='#E2E3F0';
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<%
	String operation = request.getParameter("operation")==null ? "" : request.getParameter("operation");
	String searchVal = request.getParameter("chartCompSearch")==null?"":request.getParameter("chartCompSearch");
	
	Connection con = null;

	PreparedStatement pstmtList = null;
	ResultSet resList = null;
	PreparedStatement ps = null;
	ResultSet rs = null;	
	PreparedStatement psSumm = null;
	ResultSet rsSumm = null;
	PreparedStatement psChk = null;
	ResultSet resChk = null;	
	PreparedStatement pstmtTrans = null;
	ResultSet resTrans = null;
	PreparedStatement pstmtAssYN = null;
	ResultSet resAssYN = null;
	

	int i = 0;
	int j = 0;
	int k = 0;
	int noOfRows = 0;
	int ctr=0;
	int sequenceNumber = 0;

	String sqlAssYN = "";
	String sqlSumm = "";
	String summaryColumn = "";
	String readOnly="";
	String style="";
	String summaryType = "";
	String remove_value ="";
	String section_id = "";
	String section_desc = "";//not reqd for table
	String discr_msr_id = "";
	String discr_msr_desc = "";//not reqd for table
	String result_type = "";
	String order_srl_no = "";//discr_msr_disp_order
	String current_sec_desc = "";
	String sql = "";
	String sqlComp = "";
	String classvalue = "";
	String panel_desc_id = "";
	String discr_disp_order_seq = "";
	String finalString = "";
	String finalStringGrp = "";
	String recordValues = "";
	String sqlChk = "";
	String tempDispSeqNum = "";
	String finalSummaryValue="";
	String summarySelect="";
	String summaryColText="";
	String summaryColHidden="";
	String default_yn="";
	String summary_col = "";
	String disabled ="";
	String checked = "";
	String checkedSumm = "";
	String tempSum = "";
	String tempAvg = "";
	String tempMin = "";
	String tempMax = "";
	//String tempPct = "";
	String formula_def = "";
	String sum_yn = "N";
	String disChkSumm = "";
	String result_typeForDefn = "Def.";

	String summary_req_yn = "";
	String associate_score_yn = "";
	String change_at_trans = "";
	String sqlTrans = "";
	String enableSummYN = "";
	String enableDefault = "";
	String mandatory_yn = "";
	String checkedMandatory = "";
	
	StringTokenizer tokenPipe = null;
	StringTokenizer tokenTilde = null;
	
	HashMap tableForRecs =null;
	HashMap tabFormula =  null;
	HashMap tabSummary =  null;	
	
	String element_type = "##";
	String enableEleType = "";
	String def_select = "";
	StringBuffer elementTypes = new StringBuffer();
	StringBuffer elementTypes1 = null;

%>

<form name='ChartComponentListForm' id='ChartComponentListForm' action='' method='post'>
	
	<table width='100%'  cellpadding='3' cellspacing=0  align='center'>
		<tr>
			<td colspan ='11' align='left'><input type='button' class = 'button' name='btnAddPanel' id='btnAddPanel' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ChartComponentAddPanel.label","ca_labels")%>' onclick='addPanel("<%=searchVal%>","sequenceNumber")'></td>
		</tr>
	</table>	 
		
	<table width='100%' class='grid' id='tabList' >
		<tr>
			<th class ='columnheader' align="left" width="100px"><fmt:message key="eCA.OrderSequenceNumber.label" bundle="${ca_labels}"/></th> 
			<th class ='columnheader' align="left" width="100px"><fmt:message key="Common.DiscreteMeasureCode.label" bundle="${common_labels}"/></th>
			<th class ='columnheader' align="left" width="200px"><fmt:message key="Common.DiscreteMeasure.label" bundle="${common_labels}"/></th>
			<th class ='columnheader' align="left"><fmt:message key="Common.Formula.label" bundle="${common_labels}"/></th>
			<th class ='columnheader' align="left" width="80px"><fmt:message key="eCA.SummaryRequired.label" bundle="${ca_labels}"/>&nbsp;</th>
			<th class ='columnheader' align="left" width="190px"><fmt:message key="eCA.SummaryColumn.label" bundle="${ca_labels}"/></th>
			<th class ='columnheader' align="left"><fmt:message key="eCA.SummaryType.label" bundle="${ca_labels}"/></th>
			<th class ='columnheader' align="left" width="50px"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;</th>
			<th class ='columnheader' align="left" width="60px"><fmt:message key="Common.Mandatory.label" bundle="${common_labels}"/>&nbsp; <!-- <INPUT TYPE="checkbox" name="chkMainMandatory" id="chkMainMandatory" onclick='perform(this)'> --> </th>
			<th class ='columnheader' align="left" width="100px"><fmt:message key="Common.Element.label" bundle="${common_labels}"/>  <fmt:message key="Common.type.label" bundle="${common_labels}"/></th>
			<th class ='columnheader' align="left" width="60px"><fmt:message key="Common.Default.label" bundle="${common_labels}"/>&nbsp;</th>
			<th class ='columnheader' align="left" width='0%' Style='display:none' >&nbsp;</th>
		</tr> 
		<%
		try{

			con = ConnectionManager.getConnection(request);
			try
				{
			PreparedStatement psmt = con.prepareStatement("SELECT ELEMENT_TYPE,ELEMENT_TYPE_DESC FROM CA_SPL_CHART_ELEMENT_TYPE");
					ResultSet rset = psmt.executeQuery();
					String elementType = null,elementDesc = null;
					while(rset.next())
					{
						elementType = rset.getString("ELEMENT_TYPE");
						elementDesc = rset.getString("ELEMENT_TYPE_DESC");
						elementTypes.append("<option value='"+elementType+"' >"+elementDesc+"</option>");
					}	
					elementTypes1 = new StringBuffer(elementTypes.toString());
					if(rset!=null)
						rset.close();
					if(psmt!=null)
						psmt.close();
	
					String sqlEle = "select SPL_CHART_TYPE from CA_CHART WHERE CHART_ID = ?";
					psmt = con.prepareStatement(sqlEle);
					psmt.setString(1,searchVal);
					rset = psmt.executeQuery();
					String spl_chart_type = "";
					if(rset.next())
						spl_chart_type = rset.getString(1);
					if(rset!=null) rset.close();		
					if(psmt!=null) psmt.close();


					if(spl_chart_type == null)
						spl_chart_type = "";

					if(spl_chart_type.equals("") || spl_chart_type.equals("null"))
						enableEleType = " disabled ";
					else
						enableEleType = "";
				}
				catch(Exception e)
				{
					e.printStackTrace() ;
				}
			
				if(operation.equals(""))
			{%>
				<jsp:useBean id='formulaBean' class='eCA.ChartComponentFormulaBean' scope='session' />
				<%
			try
				{			
				out.println("<script>parent.frames[1].document.ChartComponentHeaderForm.remove_value.value='' </script>");

				tabFormula = new HashMap();
				tableForRecs= new HashMap();
				tabSummary = new HashMap(); 
			

				sqlTrans = "select summary_req_yn, /*DEFINE_MODIFIABLE_AT_TRN_YN*/ config_type from ca_chart where chart_id = ?";
				pstmtTrans = con.prepareStatement(sqlTrans);
				sqlComp = "select FORMULA_DEF,SUMMARY_TYPE,SUMMRY_COLUMN,DEFAULT_DISPLAY_YN,SUM_YN,MANDATORY_YN,ELEMENT_TYPE,DEFAULT_DISPLAY_YN from ca_chart_section_comp where chart_id = ? and panel_id = ?  and discr_msr_id = ?";
				
				ps =con.prepareStatement(sqlComp);

				int count= 0;
				sqlChk = "select count(*) total from  ca_chart_section_comp where CHART_ID=? and 	rownum=1";
				psChk = con.prepareStatement(sqlChk);
				psChk.setString(1,searchVal);	
				resChk = psChk.executeQuery();
				while(resChk.next()){
					count = Integer.parseInt(resChk.getString("total"));
				}

				if(resChk!=null) resChk.close();		
				if(psChk!=null) psChk.close();

				pstmtTrans.setString(1,searchVal);
				resTrans = pstmtTrans.executeQuery();
				while(resTrans.next())
				{
					summary_req_yn = resTrans.getString(1);
					change_at_trans = resTrans.getString(2) == null?"N":resTrans.getString(2);
				}
					
				if(resTrans!=null) resTrans.close();		
				if(pstmtTrans!=null) pstmtTrans.close();
				if(summary_req_yn.equals("Y") || summary_req_yn.equals("y")){
					enableSummYN = "";
				}
				else{
					enableSummYN = " disabled ";
				}

				if(count==1){
					sql = "SELECT A.PANEL_ID SECION_ID, SECTION.SHORT_DESC SECTION_DESC, a.DISCR_MSR_ID, DISCR_MSR.SHORT_DESC DISCR_MSR_DESC, DISCR_MSR.RESULT_TYPE, A.PANEL_DISP_ORDER_SEQ DISPLAY_ORDER_SEQ, a.DISCR_DISP_ORDER_SEQ ORDER_SRL_NO, a.SUM_YN,DISCR_MSR.ASSOCIATE_SCORE_YN FROM ca_chart_section_comp A, AM_DISCR_MSR SECTION,AM_DISCR_MSR DISCR_MSR WHERE A.CHART_ID=? AND    SECTION.DISCR_MSR_ID = A.PANEL_ID AND   DISCR_MSR.DISCR_MSR_ID=  A.DISCR_MSR_ID AND DISCR_MSR.CH_APPL_YN='Y' ORDER BY A.PANEL_DISP_ORDER_SEQ,a.dISCR_DISP_ORDER_SEQ  ";
				}
				else{
					sql = "SELECT A.PANEL_ID SECION_ID, SECTION.SHORT_DESC SECTION_DESC, B.DISCR_MSR_ID, DISCR_MSR.SHORT_DESC DISCR_MSR_DESC, DISCR_MSR.RESULT_TYPE,A.DISPLAY_ORDER_SEQ, B.ORDER_SRL_NO,DISCR_MSR.ASSOCIATE_SCORE_YN  FROM CA_CHART_SECTION A,AM_DISCR_MSR_BATTERY B,AM_DISCR_MSR SECTION,AM_DISCR_MSR DISCR_MSR WHERE A.CHART_ID=? AND  B.DISCR_MSR_BATTERY_ID = A.PANEL_ID AND   SECTION.DISCR_MSR_ID = A.PANEL_ID AND   DISCR_MSR.DISCR_MSR_ID=  B.DISCR_MSR_ID AND DISCR_MSR.CH_APPL_YN='Y' ORDER BY A.DISPLAY_ORDER_SEQ, B.ORDER_SRL_NO";
				}
				sqlSumm = "select short_desc from am_discr_msr where discr_msr_id = ?";
				psSumm = con.prepareStatement(sqlSumm);
				pstmtList = con.prepareStatement(sql);
				pstmtList.setString(1,searchVal);
				resList = pstmtList.executeQuery();

				boolean bRecAvl = false;
				while(resList.next())
				{
					bRecAvl = true;
					current_sec_desc = resList.getString("SECTION_DESC");
					section_id = resList.getString("SECION_ID");
					discr_msr_id = resList.getString(3);
					discr_msr_desc = resList.getString("DISCR_MSR_DESC");
					if(!(current_sec_desc.equals(section_desc))){
						out.println("<tr width='100%' id ='trGrpHeader"+j+"'><td colspan='10' class='CAGROUPHEADING'>");
						out.println("<input type ='hidden' name='group"+j+"' id='group"+j+"' value='"+current_sec_desc+"'>");
						out.println("<input type ='hidden' name='groupId"+j+"' id='groupId"+j+"' value='"+section_id+"'>");
						out.println("<input type ='hidden' name='displaySeqNumber"+j+"' id='displaySeqNumber"+j+"' value='"+resList.getInt(6)+"'>");
						if(!section_desc.equals(""))
						{
							out.println("<input type ='hidden' name='noOfRows"+k+"' id='noOfRows"+k+"' value='"+noOfRows+"'>");
							k++;
						}
						out.println(" "+current_sec_desc+" ");			
						out.println("</td>");				
						out.println("<td colspan='1' ><input type='button' class='button'  name='addNew"+k+"' id='addNew"+k+"' onclick='addNewRow(\""+searchVal+"\",\""+section_id+"\",\""+k+"\")' value= "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")+"&nbsp;"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.New.label","common_labels")+"></td>");
						out.println("</tr>");	

						noOfRows = 0;
						k= j;

						out.println("<input type='hidden' name='finalString"+j+"' id='finalString"+j+"' value=''>");
						j++;
						

					}

					if(i%2 == 0){
						classvalue = "gridData";
					}
					else{
						classvalue = "gridData";
					}			
					order_srl_no = resList.getString(7);
					discr_msr_id = resList.getString(3);
					discr_msr_desc = resList.getString("DISCR_MSR_DESC");
					result_type = resList.getString(5);
					//out.println("result_type ="+result_type+"=");
					discr_disp_order_seq = resList.getString(6);
					associate_score_yn = resList.getString("ASSOCIATE_SCORE_YN")==null?"N":resList.getString("ASSOCIATE_SCORE_YN");

					panel_desc_id = searchVal+":"+section_id+":"+discr_msr_id;
					recordValues = result_type+"$"+order_srl_no+"$"+discr_disp_order_seq;					
					tableForRecs.put(panel_desc_id,recordValues);

					ps.setString(1,searchVal);
					ps.setString(2,section_id);
					ps.setString(3,discr_msr_id);
//					out.println("searchVal=> "+searchVal+" section_id=>"+section_id+" discr_msr_id=>"+discr_msr_id);
					rs = ps.executeQuery();

					while(rs.next())
					{
						ctr++;
					
						summaryColumn	= rs.getString(3) == null ? "" :  rs.getString(3);
						summaryType		= rs.getString(2) == null ? "" :  rs.getString(2);
						default_yn		= rs.getString(4) == null ? "N" :  rs.getString(4);
						sum_yn			= rs.getString(5) == null ? "N" :  rs.getString(5);
						mandatory_yn	= rs.getString(6) == null ? "N" :  rs.getString(6);
						element_type	= rs.getString(7) == null ? "##" :  rs.getString(7);
						def_select		= rs.getString(8) == null ? "N"	: rs.getString(8);
						//out.println("def_select => "+def_select);

						
						if(mandatory_yn.trim().equals("Y"))
							checkedMandatory =" checked ";
						else
							checkedMandatory="";	
						
						if(summaryColumn.equals(""))
							summaryColumn = "X";

						if(summaryType.equals(""))
							summaryType = "X";	
						
						finalSummaryValue = summaryColumn + ":" +summaryType + ":" + default_yn + ":" + sum_yn + ":" + mandatory_yn + ":" + change_at_trans + ":" + element_type;
						
						tabSummary.put(panel_desc_id,finalSummaryValue);

						if(!summaryColumn.equals("X"))
						{
							psSumm.setString(1,summaryColumn);
							rsSumm = psSumm.executeQuery();
							style = "disabled ";
							readOnly="readOnly";
						
							while(rsSumm.next())
							{
								summary_col = rsSumm.getString(1) == null?"":rsSumm.getString(1);
							}
						}
						else
						{
							summary_col = "";
							style = "disabled";
							readOnly= "readOnly";
						}
					}

					if(rs != null)rs.close();
					if(rsSumm != null)rsSumm.close();

					if(change_at_trans.equals("Y"))
					{
						if(default_yn.equals("Y") && mandatory_yn.equals("Y"))
						{
							checked = "checked";
							enableDefault = " disabled ";						
						}
						else
							enableDefault = "";
					}
					else{
						checked = " checked ";
						enableDefault = " disabled ";
					}
					
					
														
					if(ctr==0)
					{
						summaryColumn = "X";
						summaryType = "X";	
						default_yn = "Y";
						sum_yn = "N";
						mandatory_yn = "N";
						change_at_trans = "Y";
						element_type = "##";

						finalSummaryValue = summaryColumn + ":" +summaryType + ":" + default_yn + ":" + sum_yn + ":" + mandatory_yn + ":" + change_at_trans + ":" + element_type;

						tabSummary.put(panel_desc_id,finalSummaryValue);			
					}

					if(!change_at_trans.equals("N")){
						if(default_yn.equals("Y") && mandatory_yn.equals("Y")) 
						{
							checked="checked";
							enableDefault = " disabled ";
						}
						else 
							checked="";
					}
					else{
						checked="checked";
						enableDefault = " disabled ";
					}

					if(def_select.equals("Y"))
						checked="checked";

					if(sum_yn.equals("Y"))
					{
						if((result_type.equals("L") && associate_score_yn.equals("Y")) || result_type.equals("I") || result_type.equals("N") || result_type.equals("A"))
						{
							checkedSumm=" checked ";
							//IN066995 Start.
							//disChkSumm = "disabled";
							disChkSumm = "";
							//IN066995 End.
							readOnly= " readOnly ";
							//IN066995 Start.
							//style = " disabled ";
							style = "";
							//IN066995 End.
						}
						else
						{
							checkedSumm="";
							disChkSumm = "disabled";
							readOnly= " readOnly ";
							style = " disabled ";
						}
					}
					else{
					
						if((result_type.equals("L") && associate_score_yn.equals("Y")) || result_type.equals("I") || result_type.equals("N") || result_type.equals("A"))
						{
							checkedSumm="";
							disChkSumm = "";
							readOnly= " readOnly ";
							style = " disabled ";
							
						}
						else
						{
							checkedSumm="";
							disChkSumm = "disabled";
							readOnly= " readOnly ";
							style = " disabled ";
							
								
							
						}
					}					

					if(summaryColumn.equals("X"))
						summaryColumn= "";
					if(summaryType.trim().equals("SUM"))
					{
						tempSum="selected";
						//IN066995 Start.
						//disabled ="disabled";
						disabled ="";
						//IN066995 End.
						 tempAvg = "";
						 tempMin = "";
						 tempMax = "";
						 //tempPct = "";
					}
					else if(summaryType.trim().equals("AVERAGE"))
					{
						tempAvg="selected";
						//IN066995 Start.
				        //disabled ="disabled";
						disabled ="";
						//IN066995 End.
						tempSum = "";
						tempMin = "";
						tempMax = "";
						//tempPct = "";
					}
					else if(summaryType.trim().equals("MAXIMUM"))
					{
						tempMax="selected";	
						//IN066995 Start.
                         //disabled ="disabled";						
						disabled ="";
						//IN066995 End.
						tempSum = "";
						tempAvg = "";
						tempMin = "";
						// tempPct = "";
					}
					else if(summaryType.trim().equals("MINIMUM"))
					{
						tempMin="selected";
						//IN066995 Start.
						//disabled ="disabled";
						disabled ="";
						//IN066995 End.
						tempSum = "";
						tempAvg = "";
						tempMax = "";
						//tempPct = "";
					}
					else if(summaryType.trim().equals("PERCENTAGE"))
					{
						//tempPct="selected";
						//IN066995 Start.
						//disabled ="disabled";
						disabled ="";
						//IN066995 End.
						tempSum = "";
						tempAvg = "";
						tempMin = "";
						tempMax = "";
					}
					else
					{
						tempSum = "";
						tempAvg = "";
						tempMin = "";
						tempMax = "";
						//tempPct = "";
						disabled ="disabled";
					}

                    
					if(result_type.equals("A")){
						rs = ps.executeQuery();
						while(rs.next())
						{
							formula_def = rs.getString(1) == null ? "" :  rs.getString(1);
							tabFormula.put(panel_desc_id,formula_def);
						}
						if(rs!=null)rs.close();
					}

					out.println("<tr id ='trRowId"+k+noOfRows+"'>");
					out.println("<td class='gridNumericData' >"+order_srl_no+"</td><td class='" + classvalue + "' >"+discr_msr_id+"</td><td class = '"+classvalue+"' >"+discr_msr_desc+"</td>");
					out.println("<td width='5%' class = '"+classvalue+"'>");
					if(result_type.equals("A")){
						out.println("<a href='javascript:' onclick='formulaDefn(\""+panel_desc_id+"\")' class='gridLink'>");
						out.println(result_typeForDefn+"</a><input type ='hidden' name='result_type"+k+noOfRows+"' id='result_type"+k+noOfRows+"' value='"+result_type+"'></td>");
					}
					else{
						out.println("<input type ='hidden' name='result_type"+k+noOfRows+"' id='result_type"+k+noOfRows+"' value='"+result_type+"'></td>");
					}
					out.println("<td class='" + classvalue + "' ><INPUT TYPE='checkbox' name='sum_yn"+k+noOfRows+"' id='sum_yn"+k+noOfRows+"' value='N' '"+enableSummYN+"' onclick='enableSumm("+k+","+noOfRows+",this);clickOK(\""+panel_desc_id+"\",document.forms[0].summaryColumnCode"+k+noOfRows+",document.forms[0].summaryType"+k+noOfRows+",document.forms[0].summary_column"+k+noOfRows+",document.forms[0].default_yn"+k+noOfRows+",document.forms[0].sum_yn"+k+noOfRows+",document.forms[0].mandatory_yn"+k+noOfRows+",\""+change_at_trans+"\",document.forms[0].elementType"+k+noOfRows+")'  "+checkedSumm+"  "+disChkSumm+" ></td>");
					
					
				//	out.println("<td class='" + classvalue + "' ><INPUT TYPE='checkbox' name='sum_yn"+k+noOfRows+"' id='sum_yn"+k+noOfRows+"' value='N' '"+enableSummYN+"' onclick='enableSumm("+k+","+noOfRows+",this);clickOK(\""+panel_desc_id+"\",document.forms[0].summaryColumnCode"+k+i+",document.forms[0].summaryType"+k+i+",document.forms[0].summary_column"+k+i+",document.forms[0].default_yn"+k+i+",document.forms[0].sum_yn"+k+i+",document.forms[0].mandatory_yn"+k+i+",\""+change_at_trans+"\",document.forms[0].elementType"+k+noOfRows+")'  "+checkedSumm+"  "+disChkSumm+" ></td>");
				/**
					modified by Dinesh T on 8/4/2010 at 9:46 AM for IN022998
					invoking new functions onblur and onclick events, since two different look ups were displayed on these two events.
				**/
					out.println("<td width='12%' class = '"+classvalue+"'>");
					//IN039171 starts
					//out.println("<input type='text' name='summary_column"+k+noOfRows+"' id='summary_column"+k+noOfRows+"' SIZE='10' value='"+summary_col+"' "+readOnly+" OnBlur='onBlursummaryDefnLookup(\""+panel_desc_id+"\",document.forms[0].summary_column"+k+noOfRows+",document.forms[0].summaryColumnCode"+k+noOfRows+");chkDupSummValues(this,"+k+","+noOfRows+")'"+disChkSumm+"><input type ='hidden' name='summaryColumnCode"+k+noOfRows+"' id='summaryColumnCode"+k+noOfRows+"' value='"+summaryColumn+"'><input type='button' class='button' name='btnSumm"+k+noOfRows+"' id='btnSumm"+k+noOfRows+"' value='?' "+style+" onclick='summaryDefnLookup(\""+panel_desc_id+"\",document.forms[0].summary_column"+k+noOfRows+",document.forms[0].summaryColumnCode"+k+noOfRows+")'></td>"); 
					//IN057490 starts
					//out.println("<input type='text' name='summary_column"+k+noOfRows+"' id='summary_column"+k+noOfRows+"' SIZE='10' value='"+summary_col+"' "+readOnly+" /*onChange='clickOK(\""+panel_desc_id+"\",document.forms[0].summaryColumnCode"+k+noOfRows+",document.forms[0].summaryType"+k+noOfRows+",document.forms[0].summary_column"+k+noOfRows+",document.forms[0].default_yn"+k+noOfRows+",document.forms[0].sum_yn"+k+noOfRows+",document.forms[0].mandatory_yn"+k+noOfRows+",\""+change_at_trans+"\",document.forms[0].elementType"+k+noOfRows+")' */ OnBlur='onBlursummaryDefnLookup(\""+panel_desc_id+"\",document.forms[0].summary_column"+k+noOfRows+",document.forms[0].summaryColumnCode"+k+noOfRows+","+k+","+noOfRows+");chkDupSummValues(this,"+k+","+noOfRows+")'><input type ='hidden' name='summaryColumnCode"+k+noOfRows+"' id='summaryColumnCode"+k+noOfRows+"' value='"+summaryColumn+"'><input type='button' class='button' name='btnSumm"+k+noOfRows+"' id='btnSumm"+k+noOfRows+"' value='?' "+style+" onclick='summaryDefnLookup(\""+panel_desc_id+"\",document.forms[0].summary_column"+k+noOfRows+",document.forms[0].summaryColumnCode"+k+noOfRows+","+k+","+noOfRows+");clickOK(\""+panel_desc_id+"\",document.forms[0].summaryColumnCode"+k+noOfRows+",document.forms[0].summaryType"+k+noOfRows+",document.forms[0].summary_column"+k+noOfRows+",document.forms[0].default_yn"+k+noOfRows+",document.forms[0].sum_yn"+k+noOfRows+",document.forms[0].mandatory_yn"+k+noOfRows+",\""+change_at_trans+"\",document.forms[0].elementType"+k+noOfRows+")'></td>");
					out.println("<input type='text' name='summary_column"+k+noOfRows+"' id='summary_column"+k+noOfRows+"' SIZE='10' value='"+summary_col+"' "+readOnly+" OnBlur='onBlursummaryDefnLookup(\""+panel_desc_id+"\",document.forms[0].summary_column"+k+noOfRows+",document.forms[0].summaryColumnCode"+k+noOfRows+","+k+","+noOfRows+");chkDupSummValues(this,"+k+","+noOfRows+")' "+disChkSumm+" ><input type ='hidden' name='summaryColumnCode"+k+noOfRows+"' id='summaryColumnCode"+k+noOfRows+"' value='"+summaryColumn+"'><input type='button' class='button' name='btnSumm"+k+noOfRows+"' id='btnSumm"+k+noOfRows+"' value='?' "+style+" onclick='summaryDefnLookup(\""+panel_desc_id+"\",document.forms[0].summary_column"+k+noOfRows+",document.forms[0].summaryColumnCode"+k+noOfRows+","+k+","+noOfRows+");clickOK(\""+panel_desc_id+"\",document.forms[0].summaryColumnCode"+k+noOfRows+",document.forms[0].summaryType"+k+noOfRows+",document.forms[0].summary_column"+k+noOfRows+",document.forms[0].default_yn"+k+noOfRows+",document.forms[0].sum_yn"+k+noOfRows+",document.forms[0].mandatory_yn"+k+noOfRows+",\""+change_at_trans+"\",document.forms[0].elementType"+k+noOfRows+")'></td>");
					//IN057490 ends
					//IN039171 ends
					out.println("<td width='5%' class = '"+classvalue+"'>");
					out.println("<SELECT name='summaryType"+k+noOfRows+"' id='summaryType"+k+noOfRows+"' "+disabled+" onchange='clickOK(\""+panel_desc_id+"\",document.forms[0].summaryColumnCode"+k+noOfRows+",document.forms[0].summaryType"+k+noOfRows+",document.forms[0].summary_column"+k+noOfRows+",document.forms[0].default_yn"+k+noOfRows+",document.forms[0].sum_yn"+k+noOfRows+",document.forms[0].mandatory_yn"+k+noOfRows+",\""+change_at_trans+"\",document.forms[0].elementType"+k+noOfRows+");checkDiscrValue(document.forms[0].summary_column"+k+noOfRows+",this)'><option value='X'>--------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"------</option><option value='SUM'  "+tempSum+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.SUM.label","ca_labels")+"</option><option value='AVERAGE' "+tempAvg+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AVG.label","ca_labels")+"</option><option value='MAXIMUM' "+tempMax+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Max.label","common_labels")+"</option><option value='MINIMUM' "+tempMin+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.MIN.label","common_labels")+"						</option></SELECT></td>");
					out.println("<td class='" + classvalue + "' ><INPUT TYPE='checkbox' OnClick='removeRow("+k+","+noOfRows+",this)' name='select_yn"+noOfRows+"' id='select_yn"+noOfRows+"'  value='Y' checked></td>");
					if(result_type.equals("A"))
					out.println("<td class='" + classvalue + "' ><INPUT TYPE='checkbox' style='display:none' name='mandatory_yn"+k+noOfRows+"' id='mandatory_yn"+k+noOfRows+"' value='N'  '"+checkedMandatory+"' onclick='chkAndDisableDef(this,document.forms[0].default_yn"+k+noOfRows+",\""+change_at_trans+"\");clickOK(\""+panel_desc_id+"\",document.forms[0].summaryColumnCode"+k+noOfRows+",document.forms[0].summaryType"+k+noOfRows+",document.forms[0].summary_column"+k+noOfRows+",document.forms[0].default_yn"+k+noOfRows+",document.forms[0].sum_yn"+k+noOfRows+",document.forms[0].mandatory_yn"+k+noOfRows+",\""+change_at_trans+"\",document.forms[0].elementType"+k+noOfRows+")'></td>");
					else
					{
						out.println("<td class='" + classvalue + "' ><INPUT TYPE='checkbox' name='mandatory_yn"+k+noOfRows+"' id='mandatory_yn"+k+noOfRows+"' value='N'  '"+checkedMandatory+"' onclick='chkAndDisableDef(this,document.forms[0].default_yn"+k+noOfRows+",\""+change_at_trans+"\");clickOK(\""+panel_desc_id+"\",document.forms[0].summaryColumnCode"+k+noOfRows+",document.forms[0].summaryType"+k+noOfRows+",document.forms[0].summary_column"+k+noOfRows+",document.forms[0].default_yn"+k+noOfRows+",document.forms[0].sum_yn"+k+noOfRows+",document.forms[0].mandatory_yn"+k+noOfRows+",\""+change_at_trans+"\",document.forms[0].elementType"+k+noOfRows+")'></td>");
					}
						out.println("<td class = '"+classvalue+"'> <SELECT name='elementType"+k+noOfRows+"' id='elementType"+k+noOfRows+"'"+enableEleType+" onchange='clickOK(\""+panel_desc_id+"\",document.forms[0].summaryColumnCode"+k+noOfRows+",document.forms[0].summaryType"+k+noOfRows+",document.forms[0].summary_column"+k+noOfRows+",document.forms[0].default_yn"+k+noOfRows+",document.forms[0].sum_yn"+k+noOfRows+",document.forms[0].mandatory_yn"+k+noOfRows+",\""+change_at_trans+"\",document.forms[0].elementType"+k+noOfRows+");' onblur='chkDupElementTypes(this,\""+result_type+"\")'> <option value='##'>------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"------</option>");
					if(elementTypes.indexOf(element_type)!=-1)
					elementTypes.insert((elementTypes.indexOf(">",elementTypes.indexOf(element_type))),"selected");

					out.println(elementTypes.toString());
					out.println("</SELECT  ></td>");
					elementTypes = new StringBuffer(elementTypes1.toString());

					out.println("<td class='" + classvalue + "' ><INPUT TYPE='checkbox' name='default_yn"+k+noOfRows+"' id='default_yn"+k+noOfRows+"' value='Y' "+checked+" '"+enableDefault+"' onclick='clickOK(\""+panel_desc_id+"\",document.forms[0].summaryColumnCode"+k+noOfRows+",document.forms[0].summaryType"+k+noOfRows+",document.forms[0].summary_column"+k+noOfRows+",document.forms[0].default_yn"+k+noOfRows+",document.forms[0].sum_yn"+k+noOfRows+",document.forms[0].mandatory_yn"+k+noOfRows+",\""+change_at_trans+"\",document.forms[0].elementType"+k+noOfRows+")'></td>");
					out.println("<td  style='display:none' >"+discr_disp_order_seq+"<input type='hidden' name='panel_desc_msr_id"+k+noOfRows+"' id='panel_desc_msr_id"+k+noOfRows+"' value='"+panel_desc_id+"'></td>");
					out.println("<input type='hidden' name='rowValue"+k+noOfRows+"' id='rowValue"+k+noOfRows+"' value='"+k+"'>");
					

					out.println("</tr>");
					noOfRows++;		
					i++;	
					section_desc = current_sec_desc;
				}
				
					if(!bRecAvl)
					{
						%>
						<script>
							alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
							document.URL ='../../eCommon/html/blank.html'
						</script>
						<%
					}
				//end of while
					if(resList!=null) resList.close();
					if(pstmtList!=null) pstmtList.close();
				out.println("<input type ='hidden' name='noOfRows"+k+"' id='noOfRows"+k+"' value='"+noOfRows+"'>");
							
				recordsBean.addRecords(tableForRecs);
				formulaBean.addFormula(tabFormula);
				formulaBean.setSummary(tabSummary);
				//out.println("tabSummary from jsp =="+tabSummary+"==");
				out.println("<input type='hidden' name='sequenceGrp' id='sequenceGrp' value='"+j+"'>");
			}
			catch(Exception ee)
				{
					
					ee.printStackTrace();
				}
			}//end of if
			else
			{

				tempSum = "";
				tempAvg = "";
				tempMin = "";
				tempMax = "";
				
				//tempPct = "";
				try
				{
				ChartComponentFormulaBean formulaBean  = (ChartComponentFormulaBean)session.getAttribute("formulaBean");
				if(formulaBean != null)
				{
					formulaBean.clearSummary();
				}
				tableForRecs= new HashMap();
				tabSummary = new HashMap(); 
				if(formulaBean != null)
				{
					tabFormula= formulaBean.returnFormulaTab();
				}
				
				sequenceNumber = (request.getParameter("sequenceGrp") == null ) ? 0 : Integer.parseInt(request.getParameter("sequenceGrp"));
				remove_value = request.getParameter("remove_value") == null  ? "" : request.getParameter("remove_value");

				sqlAssYN = "select ASSOCIATE_SCORE_YN from AM_DISCR_MSR where DISCR_MSR_ID = ?";
				
				if(!remove_value.equals(""))
				{
					recordsBean.setFinalString(remove_value);
				}
				//commented by jupitora on 13/6/2005
				//con = ConnectionManager.getConnection(request);
				

				k=0;
				for(j =0 ; j < sequenceNumber;j++)
				{
					finalStringGrp = request.getParameter("group"+j)==null ? "" : request.getParameter("group"+j);
					finalString = request.getParameter("finalString"+j)==null ? "" : request.getParameter("finalString"+j);

					//finalString=java.net.URLDecoder.decode(finalString);
					

					section_id = request.getParameter("groupId"+j)==null ? "" : request.getParameter("groupId"+j);
					tempDispSeqNum = request.getParameter("displaySeqNumber"+j)==null ? "0" : request.getParameter("displaySeqNumber"+j);
					k = k + 0;

					if(!(finalString.equals("") || finalStringGrp.equals("") ||  section_id.equals(""))){
					out.println("<tr width='100%' id ='trGrpHeader"+k+"'> <td colspan ='10' class='CAGROUPHEADING'>");
					out.println(finalStringGrp);
					out.println("<input type ='hidden' name='group"+k+"' id='group"+k+"' value='"+finalStringGrp+"'>");
					out.println("<input type ='hidden' name='groupId"+k+"' id='groupId"+k+"' value='"+section_id+"'>");
					out.println("<input type='hidden' name='finalString"+k+"' id='finalString"+k+"' value=''>");
					out.println("<input type ='hidden' name='displaySeqNumber"+k+"' id='displaySeqNumber"+k+"' value='"+tempDispSeqNum+"'>");
					out.println("</td>");
					//out.println("<td colspan='1' ><input type='button' class='button'  onclick='addNewRow(\""+searchVal+"\",\""+section_id+"\",\""+k+"\")'   name='addNew"+k+"' id='addNew"+k+"' value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ChartComponentAddNew.label","ca_labels")+"'></td>");		
					out.println("<td colspan='1' ><input type='button' class='button'  name='addNew"+k+"' id='addNew"+k+"' onclick='addNewRow(\""+searchVal+"\",\""+section_id+"\",\""+k+"\")' value= "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")+"&nbsp;"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.New.label","common_labels")+"></td>");
					out.println("</tr>");	

						tokenTilde = new  StringTokenizer(finalString,"~");
						i=0;
						while(tokenTilde.hasMoreTokens())
						{
					
							classvalue = (i % 2 == 0) ? "gridData" : "gridData" ;
							tokenPipe =new StringTokenizer(tokenTilde.nextToken(),"||");
							order_srl_no = tokenPipe.nextToken();
//							out.println("order_srl_no = "+order_srl_no);
	
							discr_msr_id = tokenPipe.nextToken();
//							out.println("discr_msr_id = "+discr_msr_id);
							discr_msr_desc= tokenPipe.nextToken();
//							out.println("discr_msr_desc = "+discr_msr_desc);
							result_type = tokenPipe.nextToken();
									
							discr_disp_order_seq =  tokenPipe.nextToken();						 
//							out.println("discr_disp_order_seq = "+discr_disp_order_seq);
							summaryColText=tokenPipe.nextToken();
//							out.println("summaryColText = "+summaryColText);
							summaryColHidden=tokenPipe.nextToken();
//							out.println("summaryColHidden = "+summaryColHidden);
							summarySelect=tokenPipe.nextToken();
//							out.println("summarySelect = "+summarySelect);
							default_yn=tokenPipe.nextToken();
//							out.println("default_yn = "+default_yn);
							sum_yn = tokenPipe.nextToken();
//							out.println("sum_yn = "+sum_yn);
//							out.println("DEE3 sum_yn="+sum_yn+"=");
							mandatory_yn = tokenPipe.nextToken();
//							out.println("mandatory_yn = "+mandatory_yn);
							change_at_trans = tokenPipe.nextToken();
								try
							{
								element_type = tokenPipe.nextToken();
							}
							catch(Exception e)
							{
								e.printStackTrace() ;
							}

							finalSummaryValue = summaryColHidden + ":" +summarySelect + ":" + default_yn + ":" + sum_yn + ":" + mandatory_yn + ":" + change_at_trans + ":" + element_type;
							panel_desc_id = searchVal.trim()+":"+section_id.trim()+":"+discr_msr_id.trim();
							recordValues = result_type.trim()+"$"+order_srl_no.trim()+"$"+discr_disp_order_seq.trim();	
							
							pstmtAssYN = con.prepareStatement(sqlAssYN);
							pstmtAssYN.clearParameters();
							pstmtAssYN.setString(1,discr_msr_id);
							resAssYN = pstmtAssYN.executeQuery();
						
							while(resAssYN.next())
							{
								associate_score_yn = resAssYN.getString(1)==null?"":resAssYN.getString(1);
							}
							
							
							if(resAssYN!=null)
								resAssYN.close();
							if(pstmtAssYN!=null)
								pstmtAssYN.close();

							if(default_yn.trim().equals("Y")) 
								checked="checked";
							else
								checked="";	

							//out.println("sum_yn from JSP ---"+sum_yn+"---");
							//out.println("DEE4 sum_yn="+sum_yn+"=");
							
							if(!sum_yn.trim().equals("X"))
							{
								if(sum_yn.trim().equals("Y")){
									if((result_type.equals("L") && associate_score_yn.equals("Y")) || result_type.equals("I") || result_type.equals("N") || result_type.equals("A"))
									{
										checkedSumm=" checked ";
										//IN066995 Start.
										//disChkSumm = "disabled";
										disChkSumm = "";
										//IN066995 End.
									}
									else
									{
										checkedSumm="";
										disChkSumm = " disabled ";
									}
								}								
								else{
									if((result_type.equals("L") && associate_score_yn.equals("Y")) || result_type.equals("I") || result_type.equals("N")  || result_type.equals("A"))
									{
										checkedSumm="";	
										disChkSumm = "";
									}
									else
									{
										checkedSumm="";	
										disChkSumm = "disabled";
									}
								}

							if(mandatory_yn.trim().equals("Y")){
								checkedMandatory =" checked ";
								//disChkSumm = " disabled ";
							}								
							else{
								checkedMandatory="";	
							}							
							}
							else
							{
								checkedSumm="";	
								disChkSumm = " disabled ";
								
							}

							tableForRecs.put(panel_desc_id,recordValues);
							tabSummary.put(panel_desc_id,finalSummaryValue);
							if(summaryColText.equals("X"))
							{
								summaryColText = "";
								readOnly ="readOnly";
								//IN066995 Start.
								//style="disabled";
								style="";
								//IN066995 End.
							}
							 else if(summaryColHidden.equals("X"))
							{
								summaryColHidden = "";	
								style="";
							}
							else
							{
								readOnly ="readOnly";
								style="disabled";
							}

							if(result_type.equals("A")){
								if(tabFormula !=null)
								{	
									formula_def = (String)tabFormula.get(panel_desc_id)==null ? "" : (String)tabFormula.get(panel_desc_id);
								
									if(tabFormula.containsKey(formula_def))
									{
										tabFormula.remove(panel_desc_id);
									}
								}
								tabFormula.put(panel_desc_id,formula_def);								
						}

						out.println("<tr id='trRowId"+k+i+"'><td width='10%' class='gridNumericData'>"+order_srl_no+"</td>");
						out.println("<td  class='" + classvalue + "'  width='15%'>"+discr_msr_id+"</td>");
						out.println("<td  class='" + classvalue + "'  width='25%'>"+discr_msr_desc+"</td>");
						out.println("<td width='10%' class = '"+classvalue+"'>");
						if(result_type.equals("A")){
							out.println("<a href='javascript:' onclick='formulaDefn(\""+panel_desc_id+"\")' class='gridLink'> ");
							out.println("Def.</a><input type ='hidden' name='result_type"+k+i+"' id='result_type"+k+i+"' value='"+result_type+"'></td>");
						}
						else{
							out.println("<input type ='hidden' name='result_type"+k+i+"' id='result_type"+k+i+"' value='"+result_type+"'> </td>");
						}
						out.println("<td class='" + classvalue + "' ><INPUT TYPE='checkbox' name='sum_yn"+k+i+"' id='sum_yn"+k+i+"' value='N'  "+checkedSumm+"  "+disChkSumm+" onclick='enableSumm("+k+","+i+",this);clickOK(\""+panel_desc_id+"\",document.forms[0].summaryColumnCode"+k+i+",document.forms[0].summaryType"+k+i+",document.forms[0].summary_column"+k+i+",document.forms[0].default_yn"+k+i+",document.forms[0].sum_yn"+k+i+",document.forms[0].mandatory_yn"+k+i+",\""+change_at_trans+"\",document.forms[0].elementType"+k+noOfRows+")'></td>");
						out.println("<td width='5%' class = '"+classvalue+"'>");
						out.println("<input type='text' name='summary_column"+k+i+"' id='summary_column"+k+i+"' SIZE='10' value='"+summaryColText+"' "+readOnly+" onChange='clickOK(\""+panel_desc_id+"\",document.forms[0].summaryColumnCode"+k+i+",document.forms[0].summaryType"+k+i+",document.forms[0].summary_column"+k+i+",document.forms[0].default_yn"+k+i+",document.forms[0].sum_yn"+k+i+",document.forms[0].mandatory_yn"+k+i+",\""+change_at_trans+"\",document.forms[0].elementType"+k+noOfRows+")'><input type ='hidden' name='summaryColumnCode"+k+i+"' id='summaryColumnCode"+k+i+"' value='"+summaryColHidden+"'><input type='button' class='button' name='btnSumm"+k+i+"' id='btnSumm"+k+i+"' value='?' "+style+" onclick='summaryDefn(\""+panel_desc_id+"\",document.forms[0].summary_column"+k+i+",document.forms[0].summaryColumnCode"+k+i+");clickOK(\""+panel_desc_id+"\",document.forms[0].summaryColumnCode"+k+i+",document.forms[0].summaryType"+k+i+",document.forms[0].summary_column"+k+i+",document.forms[0].default_yn"+k+i+",document.forms[0].sum_yn"+k+i+",document.forms[0].mandatory_yn"+k+i+",\""+change_at_trans+"\",document.forms[0].elementType"+k+noOfRows+")' ></td>");
						out.println("<td width='10%' class = '"+classvalue+"'>");
						if(summarySelect.trim().equals("SUM"))
						{
							tempSum="selected";
							 tempAvg = "";
							 tempMin = "";
							 tempMax = "";
							//tempPct = "";
							//IN066995 Start.
							 //disabled ="disabled";
							 disabled="";
							 //IN066995 End.
						}	
						else if(summarySelect.trim().equals("AVERAGE"))
						{
							tempAvg="selected";
							tempSum = "";
							tempMin = "";
							tempMax = "";
							//tempPct = "";
							//IN066995 Start.
						   //disabled ="disabled";
							disabled="";
							//IN066995 End.
						}
						else if(summarySelect.trim().equals("MAXIMUM"))
						{
							tempMax="selected";
							tempSum = "";
							tempAvg = "";
							tempMin = "";
							//tempPct = "";
                            //IN066995 Start.
							//disabled ="disabled";							
							disabled="";
							//IN066995 End.
						}	
						else if(summarySelect.trim().equals("MINIMUM"))
						{
							tempMin="selected";
							tempSum = "";
							tempAvg = "";
							tempMax = "";
							//tempPct = "";
							//IN066995 Start.
							//disabled ="disabled";
							disabled="";
							//IN066995 End.
						}
						else if(summarySelect.trim().equals("PERCENTAGE"))
						{
							//tempPct="selected";
							tempSum = "";
							tempAvg = "";
							tempMin = "";
							tempMax = ""; 
							//IN066995 Start.
							//disabled ="disabled";
							disabled="";
							//IN066995 End.
						}
						else
						{
							tempSum = "";
							tempAvg = "";
							tempMin = "";
							tempMax = "";
							//tempPct = "";
							disabled="disabled";
						}

						if(change_at_trans.equals("Y")){
							if(default_yn.trim().equals("Y") && mandatory_yn.equals("Y")){
								checked="checked";
								enableDefault = " disabled ";
							}	
							else{
								checked="";
								enableDefault = "";
							}
						}
						else{
							checked="checked";
							enableDefault = " disabled ";
						}

						out.println("<SELECT name='summaryType"+k+i+"' id='summaryType"+k+i+"' "+disabled+" onchange='clickOK(\""+panel_desc_id+"\",document.forms[0].summaryColumnCode"+k+i+",document.forms[0].summaryType"+k+i+",document.forms[0].summary_column"+k+i+",document.forms[0].default_yn"+k+i+",document.forms[0].sum_yn"+k+i+",document.forms[0].mandatory_yn"+k+i+",\""+change_at_trans+"\",document.forms[0].elementType"+k+noOfRows+");checkDiscrValue(document.forms[0].summary_column"+k+i+",this)'><option value='X'>--"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--</option><option value='SUM' "+tempSum+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.SUM.label","ca_labels")+"</option><option value='AVERAGE' "+tempAvg+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AVG.label","ca_labels")+"</option><option value='MAXIMUM' "+tempMax+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Max.label","common_labels")+"</option><option value='MINIMUM' "+tempMin+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.MIN.label","common_labels")+"</option></SELECT></td>");
						out.println("<td  class='" + classvalue + "' ><INPUT TYPE='checkbox' OnClick='removeRow("+k+","+i+",this)' name='select_yn"+i+"' id='select_yn"+i+"'  value='Y' checked></td>");
						out.println("<td class='" + classvalue + "' ><INPUT TYPE='checkbox' name='mandatory_yn"+k+i+"' id='mandatory_yn"+k+i+"' value='N' '"+checkedMandatory+"' onclick='chkAndDisableDef(this,document.forms[0].default_yn"+k+i+",\""+change_at_trans+"\");clickOK(\""+panel_desc_id+"\",document.forms[0].summaryColumnCode"+k+i+",document.forms[0].summaryType"+k+i+",document.forms[0].summary_column"+k+i+",document.forms[0].default_yn"+k+i+",document.forms[0].sum_yn"+k+i+",document.forms[0].mandatory_yn"+k+i+",\""+change_at_trans+"\",document.forms[0].elementType"+k+noOfRows+")'></td>");
					


						/*******COMMENTED BY Deepa on 9/21/2009 at 12:56 PM for IN014076 **********************/

						//out.println("<td  class='" + classvalue + "' ><INPUT TYPE='checkbox' OnClick='removeRow("+k+","+i+",this)' name='select_yn"+i+"' id='select_yn"+i+"'  value='Y' checked></td>");
						//out.println("<td class='" + classvalue + "' ><INPUT TYPE='checkbox' name='mandatory_yn"+k+i+"' id='mandatory_yn"+k+i+"' value='N' '"+checkedMandatory+"' onclick='chkAndDisableDef(this,document.forms[0].default_yn"+k+i+",\""+change_at_trans+"\");clickOK(\""+panel_desc_id+"\",document.forms[0].summaryColumnCode"+k+i+",document.forms[0].summaryType"+k+i+",document.forms[0].summary_column"+k+i+",document.forms[0].default_yn"+k+i+",document.forms[0].sum_yn"+k+i+",document.forms[0].mandatory_yn"+k+i+",\""+change_at_trans+"\",document.forms[0].elementType"+k+noOfRows+")'></td>");

						/*******COMMENTED BY Deepa on 9/21/2009 at 12:56 PM for IN014076 **********************/				

						out.println("<td class = '"+classvalue+"'> <SELECT name='elementType"+k+i+"' id='elementType"+k+i+"'"+enableEleType+" onchange='clickOK(\""+panel_desc_id+"\",document.forms[0].summaryColumnCode"+k+noOfRows+",document.forms[0].summaryType"+k+noOfRows+",document.forms[0].summary_column"+k+noOfRows+",document.forms[0].default_yn"+k+noOfRows+",document.forms[0].sum_yn"+k+noOfRows+",document.forms[0].mandatory_yn"+k+noOfRows+",\""+change_at_trans+"\",document.forms[0].elementType"+k+noOfRows+");' onblur='chkDupElementTypes(this,\""+result_type+"\")'><option value='##'>------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"------</option>");
						if(elementTypes.indexOf(element_type)!=-1)
						elementTypes.insert((elementTypes.indexOf(">",elementTypes.indexOf(element_type))),"selected");

						out.println(elementTypes.toString());
						out.println("</SELECT  ></td>");
						elementTypes = new StringBuffer(elementTypes1.toString());
					

						out.println("<td  class='" + classvalue + "' ><INPUT TYPE='checkbox' name='default_yn"+k+i+"' id='default_yn"+k+i+"' value='Y' "+checked+" '"+enableDefault+"' onclick='clickOK(\""+panel_desc_id+"\",document.forms[0].summaryColumnCode"+k+i+",document.forms[0].summaryType"+k+i+",document.forms[0].summary_column"+k+i+",document.forms[0].default_yn"+k+i+",document.forms[0].sum_yn"+k+i+",document.forms[0].mandatory_yn"+k+i+",\""+change_at_trans+"\",document.forms[0].elementType"+k+noOfRows+")' ></td>");
						out.println("<td  style='display:none' >"+discr_disp_order_seq+"<input type='hidden' name='panel_desc_msr_id"+k+i+"' id='panel_desc_msr_id"+k+i+"' value='"+panel_desc_id+"'></td>");
						out.println("<input type='hidden' name='rowValue"+k+i+"' id='rowValue"+k+i+"' value='"+k+"'>");
						out.println("</tr>");	
						i++;	
				 }
				out.println("<input type ='hidden' name='noOfRows"+k+"' id='noOfRows"+k+"' value='"+i+"'>");
				
				k++;
    			}
		  }

		   recordsBean.addRecords(tableForRecs);
		   formulaBean.addFormula(tabFormula);
		   formulaBean.setSummary(tabSummary);

		   out.println("<input type='hidden' name='sequenceGrp' id='sequenceGrp' value='"+k+"'>");
			}
			catch(Exception e)
			{
				out.println("Exception @ else block ChartComponentList.jsp"+e.toString());
				e.printStackTrace();
			}
		  
		}//end of else
		out.println("<input type='hidden' name='sequence' id='sequence' value='"+i+"'>");
		out.println("<input type='hidden' name='chartCompSearch' id='chartCompSearch' value='"+searchVal+"'>");
		out.println("<input type='hidden' name='operation' id='operation' value=''>");
		out.println("<input type='hidden' name='remove_value' id='remove_value' value=''>");
%>

			<script>
/*
			var flag;
				var total=0;
				if(eval("document.forms[0].sequenceGrp") != null)
				{
					for(var index = 0 ; index < parseInt(eval("document.forms[0].sequenceGrp.value"));index++)
					{
						var noOfRows = eval("document.forms[0].noOfRows"+index)
						total = total + parseInt(noOfRows.value)

					}
				}
			
			if(total==0)
			{
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				document.URL ='../../eCommon/html/blank.html'
			}
			*/
			/*else{
				var counter = 0;
				for(var index = 0 ; index < parseInt(document.forms[0].sequenceGrp.value);index++)
				{					
					var noofrows = eval("document.forms[0].noOfRows"+index)
					for(var indexJ = 0;indexJ<parseInt(noofrows.value);indexJ++){
						var defChecked = eval("document.forms[0].mandatory_yn"+index+indexJ)
						if(defChecked.checked == true){
							counter++;									
						}
					}				
				}
				
				if(parseInt(counter) == parseInt(total)){
					//document.forms[0].chkMainMandatory.checked = true;			
				}
			}*/
			</script>
			<%
				if(change_at_trans.equals("N")){
				%>
					<!-- <script>document.forms[0].chkMainDefault.disabled = true;</script>  -->
				<%	
				}	
	//	if(rsSumm!=null) rsSumm.close();
		if(psSumm!=null) psSumm.close();
		
		if(ps!=null)ps.close();
		if(resList!=null) resList.close();
		if(pstmtList!=null) pstmtList.close();
	
	}//end of try-1 
	catch(Exception e){
		//out.println("Exception in try-1 of ChartComponentList.jsp:"+e.toString());//common-icn-0181
                   e.printStackTrace();//COMMON-ICN-0181
	}
	finally{
		
	
		if(con!=null) ConnectionManager.returnConnection(con,request);
		/*if (tableForRecs!=null)
			tableForRecs.clear();
		if (tabFormula!=null)
			tabFormula.clear();
		if (tabSummary!=null)
			tabSummary.clear();*/
	}

	%>
	</table>
	<input type='hidden' name='sum_req' id='sum_req' value='<%=summary_req_yn%>'>
	<input type='hidden' name='change_trans' id='change_trans' value='<%=change_at_trans%>'>
	<input type='hidden' name='element_types' id='element_types' value="<%=elementTypes1.toString()%>">
	<input type='hidden' name='enable_ele_type' id='enable_ele_type' value="<%=enableEleType%>">


	</form>
	</body>
</html>


