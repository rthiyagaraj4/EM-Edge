<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
--------------------------------------------------------------------------------------------------------------
08/07/2020     IN072184          Chandrashekar raju     	08/07/2020       Ramesh G      Modified for MMS-DM-CRF-0157.2
--------------------------------------------------------------------------------------------------------------------------------
--> 

<%@page import="java.sql.*,java.util.*,webbeans.eCommon.*,java.net.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	/** added by kishore kumar n on 28/11/2009  */
	String imgUrl="";

	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
	 /** ends here*/


%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<link rel='stylesheet' type='text/css' href="../../eCommon/html/CommonCalendar.css"></link>
		
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language='javascript' src='../../eCA/js/NewBornList.js'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
		<script language='javascript' src='../../eCA/js/DateCheck.js' ></script>
		<script language='javascript' src='../js/CAMenu.js'></script>
		<script type='text/javascript' src="../../eCommon/js/CommonCalendar.js"></script>
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
		<script language='javascript'>
		</script>

	<%
			
			Connection con = null;
			Properties p = (Properties)session.getValue("jdbc");
			String locale	= (String) p.getProperty("LOCALE");
			String establishRelnYN = "";
 		     
			try{
				String locnType=request.getParameter("locationType")==null?"IP":request.getParameter("locationType"); 
                String querystring=request.getQueryString();
				
				String display="";
				String ca_practitioner_id =(String)session.getValue("ca_practitioner_id");
				if(ca_practitioner_id == null) ca_practitioner_id="";
				String facilityId = (String) session.getValue("facility_id");
				if(facilityId == null) facilityId="";
				
				
				con = ConnectionManager.getConnection(request);
				PreparedStatement pstmt = null;
				ResultSet rset = null;
//Adding start for IN072184
				Boolean bar_code_scan_site = CommonBean.isSiteSpecific(con, "AM", "BARCODE_SCANNING_APPLICABLE");//Added for IN072184
				String bar_code_scan_site_YN = "";
				
				if(bar_code_scan_site)
				{
					bar_code_scan_site_YN = "Y";
				}
				else
				{
					bar_code_scan_site_YN = "N";
				}
//Ading end for IN072184
				
			/*    out.println("<script language='javascript'>");
				//pstmt = con.prepareStatement("Select patient_class,locn_type,locn_code,locn_short_desc,'A' care_type  from ca_pract_by_locn_view where practitioner_id= ? and locn_type in ('C','W') and facility_id = ? order by locn_short_desc ");

				pstmt = con.prepareStatement("Select patient_class,locn_type,locn_code,DECODE(locn_type,'C',OP_GET_DESC.OP_CLINIC(?,locn_code,?,'1'),'W',IP_GET_DESC.IP_NURSING_UNIT(?,locn_code,?,'1') ) locn_short_desc,'A' care_type  from ca_pract_by_locn_view where practitioner_id= ? and locn_type in ('C','W') and facility_id = ? AAorder by locn_short_desc ");
				pstmt.setString(1,facilityId );
				pstmt.setString(2,locale);
				pstmt.setString(3,facilityId);
				pstmt.setString(4,locale);
				pstmt.setString(5,ca_practitioner_id);
				pstmt.setString(6,facilityId);
				rset = pstmt.executeQuery();
				int i=0, j=0,k=0,l=0;

				while(rset.next()){
					if(rset.getString("locn_type").equals("C") && rset.getString("patient_class").equals("OP")){
						out.println("clinicCodeArr["+i+"]=\""+rset.getString("locn_code")+"\"");
						out.println("clinicDescArr["+i+"]=\""+rset.getString("locn_short_desc")+"\"");
						out.println("clinicTypeArr["+i+"]=\""+rset.getString("care_type")+"\"");
						i++;
					}else if(rset.getString("locn_type").equals("W") && rset.getString("patient_class").equals("IP")){
						out.println("wardCodeArr["+j+"]=\""+rset.getString("locn_code")+"\"");
						out.println("wardDescArr["+j+"]=\""+rset.getString("locn_short_desc")+"\"");
						j++;
					}
				
					if (rset.getString("patient_class").equals("DC")){
						out.println("dayCareCodArray["+k+"]=\""+rset.getString("locn_code")+"\"");
						out.println("dayCareDesArray["+k+"]=\""+rset.getString("locn_short_desc")+"\"");
						k++;
					}
					
					if (rset.getString("patient_class").equals("EM")){
						out.println("OPEmerCodArray["+l+"]=\""+rset.getString("locn_code")+"\"");
						out.println("OPEmerDesArray["+l+"]=\""+rset.getString("locn_short_desc")+"\"");
						l++;
					}
				}
				
				if(rset!=null)rset.close();
				if(pstmt != null)pstmt.close();
				
				out.println("</script>");*/
				%>
	
	</head>
	<body class='CONTENT' onLoad=''  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name='NewBornCriteriaForm' id='NewBornCriteriaForm' onload="">
			<table id='NewBornCriteriaTb' width='100%' border='0' cellpadding='3' cellspacing=0>
				<tr><th class='columnheader' colspan=6 align='left'><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></th></tr>
				
	            <tr>
                <td class=label width='25%'  ><B><fmt:message key="Common.display.label" bundle="${common_labels}"/></B></td>
				<td class='label' width='25%'> <fmt:message key="eCA.HealthNewBorns.label" bundle="${ca_labels}"/><input type="checkbox" name="healthy" id="healthy"  onClick="healthyClick(this)" value="Y" checked></td>
                <td class=label width='25%' ><fmt:message key="eCA.AdmittedNewborns.label" bundle="${ca_labels}"/>
				<input type="checkbox"  name="admitted" id="admitted"  onClick="admittedClick(this)" value="Y" checked></td>
				<td class=label width='25%' ><fmt:message key="eCA.StillbornDeceased.label" bundle="${ca_labels}"/>
				<input type="checkbox"  name="deceased" id="deceased"  onClick="deceasedClick(this)" value="Y" checked></td>
				</tr>
	            
				<tr>
						<td   class='label' width='25%' ><fmt:message key='eCA.NewBornID.label' bundle='${ca_labels}'/></td>
						<td class='fields' width='25%'  ><input type='text'  name='newbornid' id='newbornid' value=''  onkeydown ='barcodeScan(event,this,"CHILD")' onKeyPress='return CheckForSpecChars(event)' onBlur='checkDuplicate(this)' size='10' maxlength='20' ><input align='right' type=button name=search value='?'  class=button tabIndex="4" onClick="getNewbornId()"><!-- onkeydown ='barcodeScan(event,this,"CHILD")' Added for IN072184-->
						</td>
                        <td  class='label' width='25%' ><fmt:message key="eCA.MothersID.label" bundle="${ca_labels}"/></td>
						<td class='fields'  width="25%" ><input type='text'  name='motherid' id='motherid' value='' onkeydown ='barcodeScan(event,this,"MOTHER")' onKeyPress='return CheckForSpecChars(event)' onBlur='checkDuplicate(this)' size='10' maxlength='20'><input align='right' type=button name=search value='?'  class=button tabIndex="4" onClick="getMotherId()"><!-- onkeydown ='barcodeScan(event,this,"MOTHER")' Added for IN072184 -->
						</td>
					</tr><tr>
						<td   class='label' width="25%" ><fmt:message key="eCA.NewBornEncounterID.label" bundle="${ca_labels}"/></td>
						<td  class='fields' width="25%" ><input type='text' name='encounterId' id='encounterId' value='' size='12' maxlength='12'  OnKeyPress='return allowValidNo(this,event,6,0)' onBlur='CheckNum(this)'></td> 
										
				       
                    <%	
						// String  sql = "select PATIENT_CLASS, SHORT_DESC  from  am_patient_class where patient_class in ('OP','IP','EM','DC') order by 2  ";

						/***************ADDED BY Deepa on 9/30/2009 at 3:30 PM for IN014961**********************/
						String sql = " select ESTABLISH_RELN_REQ_YN  from ca_encntr_param ";
						pstmt = con.prepareStatement(sql);
						 rset = pstmt.executeQuery();

						 while(rset.next())
							 establishRelnYN = rset.getString("ESTABLISH_RELN_REQ_YN") == null ? "N" : rset.getString("ESTABLISH_RELN_REQ_YN");


						 if(rset != null) rset.close();
						 if(pstmt != null) pstmt.close();

						/***************ADDED BY Deepa on 9/30/2009 at 3:30 PM for IN014961**********************/	
						sql = "select PATIENT_CLASS, AM_GET_DESC.AM_PATIENT_CLASS(PATIENT_CLASS,?,'1') SHORT_DESC  from  am_patient_class where patient_class in ('OP','IP','EM','DC') order by 2  ";
						 pstmt = con.prepareStatement(sql);
						 pstmt.setString(1,locale);
						 rset = pstmt.executeQuery();                     
					
					%>                   
					
				<!--	<td class='LABEL' ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/>&nbsp;</td>
					<td class='fields'>
						<select name='locationType' id='locationType' onchange='locnTypeChange(this)' disabled> 
						<option value='Z'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
							<% while (rset.next()){	
										if(locnType.equals(rset.getString("PATIENT_CLASS"))){
											display=rset.getString("PATIENT_CLASS")+"    selected ";
										}else{
											display=rset.getString("PATIENT_CLASS");
										}

											out.println("<option value="+display+">"+rset.getString("SHORT_DESC")+"</option>");
									}	
							 
							 
									if(rset!=null)rset.close();
									if(pstmt != null)pstmt.close();
							 %>
						</select>
					</td>
					</tr><tr>-->
					
					<td class='label' ><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td> <!--id='locLed' -->
					<td class='fields'>
					<!--<select name='locationCode' id='locationCode' disabled id='locVal' onChange=''> 
							<option value='*ALL'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
					</select> -->
					<input type='text' name='locationDesc' id='locationDesc' id='locDesc' value='' onBlur='getLocCode(this);' ><input type='hidden' id='locVal' name='locationCode' id='locationCode' value='*ALL'><input type='button' name='locCodeButton' id='locCodeButton' class='button' value='?' onClick='populateLoc();'>

					</td> </tr>
					<tr>
					
				<!--	<script language="JavaScript">
						document.getElementById("locLed").innerText='';
						document.getElementById("locVal").style.visibility='hidden';
						document.forms[0].locationCode.disabled = true;
						
					</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>


 -->
					<td  colspan=2 align='right'>&nbsp;</td>
					<td  colspan=2 align='right'>
					<input type='button' class='button' name='search' id='search' id = 'searchID' onclick="searchClick()" 	value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>'></input>
					<input type='button' class='button' name='clear' id='clear' onclick="clearClick()" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>'></input>
                    </td>
			</tr>
		</table>
				<!-- added by kishore kumar n on 27/11/2009  -->
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
				<!--ends here -->		
		<input type="hidden" name="querystring" id="querystring" value="<%=querystring%>">
		<input type="hidden" name="locale" id="locale" value="<%=locale%>">
		<input type="hidden" name="facilityId" id="facilityId" value="<%=facilityId%>">
		<input type="hidden" name="ca_practitioner_id" id="ca_practitioner_id" value="<%=ca_practitioner_id%>">
		<input type="hidden" name="establishRelnYN" id="establishRelnYN" value="<%=establishRelnYN%>">
		<input type='hidden' name='bar_code_scan_site_YN' id='bar_code_scan_site_YN' value='<%=bar_code_scan_site_YN%>'><!--Added for IN072184-->
        <input type='hidden' name='baby_bar_code_scaned_YN' id='baby_bar_code_scaned_YN' value=''><!--Added for IN072184-->
		<input type='hidden' name='mother_bar_code_scaned_YN' id='mother_bar_code_scaned_YN' value=''><!--Added for IN072184-->
		<input type='hidden' name='bar_code_scaned_YN' id='bar_code_scaned_YN' value=''><!--Added for IN072184-->
       <!-- <script>locnTypeChange(document.NewBornCriteriaForm.locationType)</script> -->
		</form>	
	</body>
</html>

<%
}
catch(Exception e)
{
	//out.println(e);//common-icn-0181
	e.printStackTrace();//COMMON-ICN-0181
}
finally 
{
	if (con!=null) ConnectionManager.returnConnection(con,request);
}
%> 

