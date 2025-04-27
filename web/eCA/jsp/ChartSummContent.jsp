<!DOCTYPE html>
<!-- 
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------------
?             100            ?           created
01/03/2013	IN035924	  Karthi L	 	CA View chart summary ?RESULT WIDGET? should come blank if patient visit hospital after 6 month or time interval defined by customer(CHL-CRF-018)
14/03/2013	IN038651		Karthi L 	Alphabets & Special Characters can be Pasted. Should not allow to paste alpha and characters.
18/02/2021	14773			 Nijitha S		PMG2021-COMN-CRF-0003
--------------------------------------------------------------------------------------------------------------------
-->

<%@ page import ="java.sql.*,eCA.*,webbeans.eCommon.*,java.util.*" contentType="text/html;charset=UTF-8" %> <!--added eCA.* for IN035924 -->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
		
	<title><fmt:message key="eCA.ChartSummaryContent.label" bundle="${ca_labels}"/></title>
<%
	request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
//Properties p = (Properties)session.getValue("jdbc");
//String locale	= (String) p.getProperty("LOCALE");
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />



	<script src="../../eCommon/js/ValidateControl.js"	language="javascript"></script>
	<script src="../../eCommon/js/common.js"			language="javascript"></script>
	<script src='../js/ChartSummContent.js'				language='javascript' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	Connection conn				= null;
	PreparedStatement pstmt		= null;
	ResultSet rs				= null;

	int i = 0, rowCount	= 0;
	String sql_sel_query	= "";
	String classval			= "";
	String cont_id			= "";
	String cont_sysdef_desc = "",cont_usrdef_desc = "";
	String display_scope_ind = "", no_enc_display = ""; // added for CRF - 018 IN035924
	ArrayList cont_id_list = new ArrayList();  // added for CRF - 018 IN035924
	cont_id_list.add("8");
	cont_id_list.add("13");
	cont_id_list.add("14");
	cont_id_list.add("16");//PMG2021-COMN-CRF-0003
	

	//IN035924 - END
		//sql_sel_query	="select content_id, content_sysdef_desc, content_userdef_desc from ca_chart_summ_content order by content_sysdef_desc";

		//sql_sel_query	="select content_id, content_sysdef_desc, content_userdef_desc from ca_chart_summ_content order by content_sysdef_desc "; Commented for CRF-018
		sql_sel_query	="select content_id, content_sysdef_desc, content_userdef_desc, display_scope_ind,no_enc_display from ca_chart_summ_content order by content_sysdef_desc "; //modified for CRF-018 IN035924
	try{
			conn	= ConnectionManager.getConnection();
			pstmt	= conn.prepareStatement(sql_sel_query);
			rs		= pstmt.executeQuery();
		%>
			
				

	<body OnMouseDown="CodeArrest()" onload='FocusFirstElement();' onKeyDown="lockKey()">
	<form name="formChartSummContent" id="formChartSummContent" action="" method="">
	<br><br><br>
				
				
				<table class='grid' width='75%' align='center' style='border: 1px solid black; border-collapse: separate; border-spacing: 0 3px;'>
				
				
						<th class='COLUMNHEADERCENTER' ><fmt:message key="Common.SystemDescription.label" bundle="${common_labels}"/></th>
						<th class='COLUMNHEADERCENTER'><fmt:message key="eCA.UserDefinedDescription.label" bundle="${ca_labels}"/></th>	
						<th class='COLUMNHEADERCENTER' nowrap><fmt:message key="eCA.scopefordata.label" bundle="${ca_labels}"/></th>	 <!-- added for CRF -018 IN035924 -->
						
				<% 
					String disableYN = ""; //IN035924

					while(rs.next())
					{
						rowCount++;
						i++;
						classval = "gridData";//((i%2)==0 )? "QRYEVEN" : "QRYODD";
							
						cont_id			 = rs.getString("content_id");
						cont_sysdef_desc = rs.getString("content_sysdef_desc");
						cont_usrdef_desc = rs.getString("content_userdef_desc");
						display_scope_ind = rs.getString("display_scope_ind"); //IN035924
						no_enc_display = rs.getString("no_enc_display"); // IN035924
						
						if(cont_usrdef_desc == null || cont_usrdef_desc.equals("null"))
							cont_usrdef_desc="";
						
						if(no_enc_display == null || no_enc_display.equals("null"))
							no_enc_display="";

						disableYN = "";

						if(!cont_id_list.contains(cont_id)) //IN035924 - START
						{
							disableYN = "disabled";
						}
						//IN035924 - END
						
						
				%> 	
							<tr>	
								<input type='hidden' name='content_id<%=i%>' id='content_id<%=i%>'  value="<%=cont_id%>">

							
								<td  class='<%=classval%>' width='30%'><%= cont_sysdef_desc%></td>  <!-- width modified from 50% to 30% IN035924 -->
								<td  class='<%=classval%>' width='30%'>  <!-- width modified from 50% to 30% IN035924 -->
								<input type='text' name='content_userdef_desc_txt<%=i%>' id='content_userdef_desc_txt<%=i%>'
								size='30' maxlength='30'   value='<%=cont_usrdef_desc%>' onKeyPress="return Checkspclchars(event,this)" onBlur="SpaceCountIncr()">
								</td>
								<!-- added for CRF -018 START IN035924 -->
								<td  class='<%=classval%>' width='40%' >
									<SELECT id = "scope_to_choose<%= i %>" NAME="scope_to_choose<%= i %>" <%=disableYN%> onchange = 'displayData(<%= i %>);'>
										<option value="D"<%if("D".equals(display_scope_ind)){%> selected <%} %> ><fmt:message key="eCA.defaultcriteria.label" bundle="${ca_labels}"/></option>
										<option value="C" <%if("C".equals(display_scope_ind)){%> selected <%}%> ><fmt:message key="eCA.currentencounter.label" bundle="${ca_labels}"/></option>
											<%if(!"16".equals(cont_id)) {%><!-- PMG2021-COMN-CRF-0003  -->
										<option value="P" <%if("P".equals(display_scope_ind)){%> selected <%}%> ><fmt:message key="eCA.pastencounter.label" bundle="${ca_labels}"/></option>
										<%} %><!-- 14773 PMG2021-COMN-CRF-0003  -->
									</SELECT> &nbsp;
									<%if("16".equals(cont_id)) {%><!-- 14773 PMG2021-COMN-CRF-0003 Starts -->
									<INPUT TYPE="text" id =  "scope_of_data<%=i%>"  NAME="scope_of_data<%=i%>"  onpaste="return false"  size=15 maxlength=1  onBlur="checkMaxNoOfEncounters(<%= i %>)" onKeyPress="return CheckOnlynumsnew(event,this)" <%if(("C".equals(display_scope_ind)) || ("P".equals(display_scope_ind))){%> style ="display" value = <%= no_enc_display%> <%}else{%>style ="display:none"  value = "" <%}%>>
									<%}else{ %><!-- PMG2021-COMN-CRF-0003 Ends -->
									<INPUT TYPE="text" id =  "scope_of_data<%=i%>"  NAME="scope_of_data<%=i%>"  onpaste="return false"  size=15 maxlength=3  onBlur="checkMaxNoOfEncounters(<%= i %>)" onKeyPress="return CheckOnlynums(event,this)" <%if(("C".equals(display_scope_ind)) || ("P".equals(display_scope_ind))){%> style ="display" value = <%= no_enc_display%> <%}else{%>style ="display:none"  value = "" <%}%>>
									
									<%} %> <!-- 14773 PMG2021-COMN-CRF-0003 -->
										<input type='hidden' name="scope_to_choose<%= i %>" id="scope_to_choose<%= i %>"   value=""> </input>		<!-- method onpaste return false added for IN038651 --> 
									<label id = "unit_for_scope<%=i%>" style ="display:none" ></label>
									<span id='label_data<%=i%>' style='display'>
										<%
										if("C".equals(display_scope_ind)) {%> 
											 <fmt:message key="Common.days.label" bundle="${common_labels}"/>
										<% } else if("P".equals(display_scope_ind)) { %>
											<fmt:message key="eCA.Encounters.label" bundle="${ca_labels}"/>
										<%}%>
									</span>
								</td>
								<!-- added for CRF -018 IN035924 - END -->
							</tr>
				<%
					} 
				%>
					</table>
			<%
				if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
			}
			catch(Exception e)
			{
				//out.println("Exception in try :"+e);//common-icn-0181
				e.printStackTrace();//COMMON-ICN-0181
			}
	
			finally
			{		
					if(conn!=null)ConnectionManager.returnConnection(conn,request);
			}	
			%>

			<input type='hidden' name='rowCnt' id='rowCnt'  value="<%=rowCount%>"> </input>
			
</form> 

</body>
</html>



