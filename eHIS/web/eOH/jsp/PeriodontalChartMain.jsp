<!DOCTYPE html>

<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.Common.CommonBean" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	request.setCharacterEncoding("UTF-8");
	
%>
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script> 
	<script language='javascript' src='../../eOH/js/PeriodontalChart.js'></script>
	<script Language="JavaScript" src="../../eOH/js/OHCommonMasters.js"></script>



</head>
<body onLoad="parent.commontoolbarFrame.document.forms[0].apply.disabled=false;" OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%

PreparedStatement stmt1=null;
ResultSet rs1=null;

Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
String mode=request.getParameter("mode");
String chartid = request.getParameter("chartid")==null?"":request.getParameter( "chartid" );
chartid=CommonBean.checkForNull(chartid);
String chk_checked1="checked";
String chk_value1="E";
String disable_flag1="";
String chartid_disable1="";
String chart_desc="";
String selected_yn="";
String chart_code = request.getParameter("chartid")==null?"":request.getParameter( "chartid" );
String component_code="";
String component_desc="";
String min_value="";
String max_value="";
String cut_off="";
String sequence_no="";
String select_status="";
String sql="";
String surfaces_appl_yn="";
int i=0;

String sql1="";
int count=0;
try{
	con=ConnectionManager.getConnection(request);

	if(mode.equals("modify")){
		String status="";
		sql1="SELECT CHART_CODE, CHART_DESC, NVL(EFF_STATUS,'E') STATUS FROM OH_PERIODONTAL_CHART_DEF_HDR WHERE CHART_CODE = ? ";
		stmt1=con.prepareStatement(sql1);
		stmt1.setString(1,chartid);
		rs1=stmt1.executeQuery();
		if(rs1!=null && rs1.next())
		{
			chart_desc=CommonBean.checkForNull(rs1.getString("chart_desc"));
			status=CommonBean.checkForNull(rs1.getString("status"));
		}
		if(status.equals("E"))
		{
			chk_checked1="checked";
			disable_flag1="";
		}
		else
		{
			chk_checked1="";
			disable_flag1="disabled";
			chk_value1="D";
		}
		
	chartid_disable1="disabled";	

}

%>
<form name="periodontalchart" id="periodontalchart"  onload='FocusFirstElement()'  action="../../servlet/eOH.PeriodontalChartServlet?status="+document.forms[0].status.value; method="post" target='f_query_add_mod'> 
<table border=0 cellspacing=0 cellpadding=3 width='60%'  align=center>
<tr>
	<td class=label align=right>
		<fmt:message key="Common.ChartID.label" bundle="${common_labels}"/>
	</td>
	<td align=left>
		<input type="text" name="chartid" id="chartid" value="<%=chartid%>" size=4 maxlength=4  <%=chartid_disable1%> onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" >
		<img src='../../eCommon/images/mandatory.gif'>
	</td>

</tr>

<tr>
	<td class=label align=right>
		<fmt:message key="Common.description.label" bundle="${common_labels}"/>
	</td>
	<td class=field>
		<input type="text" name="chart_desc" id="chart_desc" value="<%=chart_desc%>"  size=30 maxlength=30 <%=disable_flag1%> onblur='setCheckValue();' onkeypress="CharCheck();">
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<tr>
	<td class=label align=right>
		<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
	</td>
	<td  class=field>
		<input type="checkbox" name="status" id="status" onClick='setCheckValue();' value='<%=chk_value1%>' <%=chk_checked1%> >
	</td>
</tr>
<br>
</table>
<table cellpadding=3  cellspacing="0" width="100%" align="center" border="0" id="tit_header">
	<tr>
		<td class='CAGROUPHEADING'> <fmt:message key="Common.Components.label" bundle="${common_labels}"/>	</td>
	</tr>
</TABLE>
<TABLE BORDER="1" CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center">	
	<tr height='30'>
				<td class='columnheader' width='25%'> <fmt:message key="Common.Component.label" bundle="${common_labels}"/></td>
				<td class='columnheader'> <fmt:message key="eOT.Sequence.Label" bundle="${ot_labels}"/></td>
				<td class='columnheader'><fmt:message key="eAM.MinValue.label" bundle="${am_labels}"/></td>
				<td class='columnheader'><fmt:message key="Common.MaxValue.label" bundle="${common_labels}"/></td>
				<td class='columnheader'><fmt:message key="eOH.RedIfGreaterEqual.Label" bundle="${ot_labels}"/></td>
<!-- 				 <td class='columnheader'><fmt:message key="eOH.GraphReqd?.Label" bundle="${oh_labels}"/></td> -->
				<!-- <td class='columnheader'><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></td> -->
				<td class='columnheader'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
	</tr>

	<%
		if (mode.equals("insert")){
			sql="SELECT COMPONENT_CODE CODE,COMPONENT_DESC_USER_DEF USER_DESC, MIN_VALUE, MAX_VALUE, CUT_OFF REDIF, 'N' SELECTED_YN, NULL SEQUENCENO,NVL(SURFACES_APPL_YN,'N') SURFACES_APPL_YN FROM OH_PERIODONTAL_CHART_COMP ORDER BY USER_DESC";
		} else {
			sql="SELECT A.COMPONENT_CODE CODE, A.COMPONENT_DESC_USER_DEF USER_DESC, DECODE(B.COMPONENT_CODE,NULL,A.MIN_VALUE, B.MIN_VALUE) MIN_VALUE,DECODE(B.COMPONENT_CODE,NULL,A.MAX_VALUE,B.MAX_VALUE) MAX_VALUE, DECODE(B.COMPONENT_CODE,NULL,A.CUT_OFF,B.CUT_OFF) REDIF, B.SEQUENCE_NO SEQUENCENO, NVL2(B.SEQUENCE_NO,'Y','N') SELECTED_YN,NVL(SURFACES_APPL_YN,'N') SURFACES_APPL_YN FROM OH_PERIODONTAL_CHART_COMP A, OH_PERIODONTAL_CHART_DEF_DTL B WHERE A.COMPONENT_CODE=B.COMPONENT_CODE(+) AND B.CHART_CODE(+)=? ORDER BY USER_DESC";
		}
		int j=0;
		stmt=con.prepareStatement(sql);
		if (mode.equals("modify")){
			stmt.setString(1,chart_code);
		}

		rs=stmt.executeQuery();
		while(rs.next()){
			j++;
		}
		count=j;
			
		if(rs != null) rs.close();
		if (mode.equals("modify")){
            stmt.setString(1,chart_code);
		}
			rs=stmt.executeQuery();
			int row_count = 0;
			String classValue = "";
			while(rs.next()){
				row_count++;
				component_code=CommonBean.checkForNull(rs.getString("CODE"));
				component_desc=CommonBean.checkForNull(rs.getString("USER_DESC"));
				min_value=CommonBean.checkForNull(rs.getString("MIN_VALUE"));
				max_value=CommonBean.checkForNull(rs.getString("MAX_VALUE"));
				cut_off=CommonBean.checkForNull(rs.getString("REDIF"));
				selected_yn=CommonBean.checkForNull(rs.getString("SELECTED_YN"));
				sequence_no=CommonBean.checkForNull(rs.getString("SEQUENCENO"));
				
				 if(selected_yn.equals("Y")){
						select_status="checked";
				}else if( selected_yn.equals("N") || selected_yn.equals("") ){
					   select_status="unchecked";
				}
				surfaces_appl_yn=CommonBean.checkForNull(rs.getString("SURFACES_APPL_YN"));
				
				if ( row_count % 2 == 0 )
                    classValue = "QRYEVEN" ;
                else
					classValue = "QRYODD" ;

		%>
				<tr align='center' >		
					<td width="10%" align='left' class="<%=classValue%>" ><%=component_desc%></td>
					<input type='hidden' name="comp_code_<%=i%>" id="comp_code_<%=i%>" value="<%=component_code%>">

					<td  width="10%" class="<%=classValue%>"><input type=text name="sequence_<%=i%>" id="sequence_<%=i%>" value="<%=sequence_no%>"  maxlength='33' size='3' id='sequence' onkeypress="return checkForSpecCharsforIDSeq(event);" onblur='CheckSeqNum(this);Checkdbmode(this,<%=i%>);'  <%=disable_flag1%>></td>
		
		<% 
				
				if(component_code.equals("DEB") || component_code.equals("CALC") || component_code.equals("PLA") || component_code.equals("MOBL") || component_code.equals("BOP") || component_code.equals("LOC") || component_code.equals("FOI") || component_code.equals("FUIN") || component_code.equals("SUP") || component_code.equals("MITH"))
					{ %>
					<td  width="10%" class="<%=classValue%>">
						<input type=text name="minvalue_<%=i%>" id="minvalue_<%=i%>" value="<%=min_value%>" onkeypress="return checkForSpecCharsforID(event);" maxlength='3' size='3' disabled>
					</td>
					<td  width="10%" class="<%=classValue%>">
						<input type=text name="maxvalue_<%=i%>" id="maxvalue_<%=i%>" value="<%=max_value%>" onkeypress="return checkForSpecCharsforID(event);" maxlength='3' size='3' disabled>
					</td>
					<td  width="10%" class="<%=classValue%>"><input type=text name="redif_<%=i%>" id="redif_<%=i%>" value="<%=cut_off%>" onkeypress="return checkForSpecCharsforID(event);" maxlength='3' size='3' disabled>
					</td>
		<%      }
				else if(component_code.equals("CAL")){
		%>
					<td  width="10%" class="<%=classValue%>">
						<input type=text name="minvalue_<%=i%>" id="minvalue_<%=i%>" value="<%=min_value%>"  maxlength='3' size='3' disabled>
					</td>
					<td  width="10%" class="<%=classValue%>">
						<input type=text name="maxvalue_<%=i%>" id="maxvalue_<%=i%>" value="<%=max_value%>"  maxlength='3' size='3' disabled>
					</td>
					<!-- <td  width="10%" class="<%=classValue%>"><input type=text name="redif_<%=i%>" id="redif_<%=i%>" value="<%=cut_off%>"  maxlength='5' size='5' onblur='CheckRedifNum(this,<%=i%>,"<%=component_code%>");changeColor("<%=i%>",this,"redif");Checkdbmode(this,<%=i%>);validatevalues(<%=i%>);'> -->
					<td  width="10%" class="<%=classValue%>"><input type=text name="redif_<%=i%>" id="redif_<%=i%>" value="<%=cut_off%>"  maxlength='3' size='3' onkeypress="return checkForSpecCharsforID(event);" onblur='CheckRedifNum(this,<%=i%>,"<%=component_code%>","<%=chartid%>");Checkdbmode(this,<%=i%>);validatevalues(<%=i%>);'>
					</td>
		<% 
				}
				else{
		%>
					<!-- <td  width="10%" class="<%=classValue%>"><input type=text name="minvalue_<%=i%>" id="minvalue_<%=i%>" value="<%=min_value%>"  maxlength='5' size='5'  onblur='CheckNumMaxMin(this,"min",<%=i%>,"<%=component_code%>");changeColor("<%=i%>",this,"min");Checkdbmode(this,<%=i%>);'  <%=disable_flag1%>>
					</td>
					<td  width="10%" class="<%=classValue%>"><input type=text name="maxvalue_<%=i%>" id="maxvalue_<%=i%>" value="<%=max_value%>"  maxlength='5' size='5'  onblur='CheckNumMaxMin(this,"max",<%=i%>,"<%=component_code%>");changeColor("<%=i%>",this,"max");Checkdbmode(this,<%=i%>);'  <%=disable_flag1%>>
					</td>
					<td  width="10%" class="<%=classValue%>"><input type=text name="redif_<%=i%>" id="redif_<%=i%>" value="<%=cut_off%>"  maxlength='5' size='5'  onblur='CheckRedifNum(this,<%=i%>,"<%=component_code%>");changeColor("<%=i%>",this,"redif");Checkdbmode(this,<%=i%>);validatevalues(<%=i%>);' <%=disable_flag1%>>
					</td> -->

					<td width="10%" class="<%=classValue%>"><input type=text name="minvalue_<%=i%>" id="minvalue_<%=i%>" value="<%=min_value%>" maxlength='3' size='3' onkeypress="return checkForSpecCharsforID(event);" onblur='CheckNumMaxMin(this,"min",<%=i%>,"<%=component_code%>","<%=chartid%>");Checkdbmode(this,<%=i%>);'  <%=disable_flag1%>>
					</td>
					<td  width="10%" class="<%=classValue%>"><input type=text name="maxvalue_<%=i%>" id="maxvalue_<%=i%>" value="<%=max_value%>"  maxlength='3' size='3' id="id_<%=i%>" onkeypress="return checkForSpecCharsforID(event);" onblur='CheckNumMaxMin(this,"max",<%=i%>,"<%=component_code%>","<%=chartid%>");Checkdbmode(this,<%=i%>);'  <%=disable_flag1%>>
					</td>
					<td  width="10%" class="<%=classValue%>"><input type=text name="redif_<%=i%>" id="redif_<%=i%>" value="<%=cut_off%>"  maxlength='3' size='3' onkeypress="return checkForSpecCharsforID(event);" onblur='CheckRedifNum(this,<%=i%>,"<%=component_code%>","<%=chartid%>");Checkdbmode(this,<%=i%>);validatevalues(<%=i%>);' <%=disable_flag1%>>
					</td>
		<%      } 
						
		%>
				<td  width="6%" class="<%=classValue%>"><input type='checkbox' name="select_<%=i%>" id="select_<%=i%>" value='<%=selected_yn%>'  <%=select_status%> db_change='N' onclick='validateCheckBox(this,<%=i%>)' select_yn_<%=i%>='<%=selected_yn%>' no_record='<%=i%>' component_code<%=i%>='<%=component_code%>'  component_desc<%=i%>='<%=component_desc%>' sequence<%=i%>='<%=sequence_no%>' minvalue_<%=i%>='<%=min_value%>' maxvalue_<%=i%>='<%=max_value%>' redif_<%=i%>='<%=cut_off%>' db_mode<%=i%>='s' <%=disable_flag1%>>
      
				<input type='hidden' name='hsequence_no<%=i%>' id='hsequence_no<%=i%>' value='<%=sequence_no%>'>
				<input type='hidden' name='hmin_value<%=i%>' id='hmin_value<%=i%>' value='<%=min_value%>'>
				<input type='hidden' name='hmax_value<%=i%>' id='hmax_value<%=i%>' value='<%=max_value%>'>
				<input type='hidden' name='hcut_off<%=i%>' id='hcut_off<%=i%>' value='<%=cut_off%>'>
				<input type='hidden' name='hselect_<%=i%>' id='hselect_<%=i%>' value='<%=selected_yn%>'>
				<input type='hidden' name='hdb_mode_<%=i%>' id='hdb_mode_<%=i%>' value=''>
				<input type='hidden' name='comp_code_<%=i%>' id='comp_code_<%=i%>' value='<%=component_code%>'>
               
				</td>			
				</tr>
		<%
				if(selected_yn.equals("Y") ){
		%>
					<input type='hidden' name="enable_<%=i%>" id="enable_<%=i%>" value="<%=selected_yn%>">
		<%
				}else{
		%>
					<input type='hidden' name="enable_<%=i%>" id="enable_<%=i%>" value="<%=selected_yn%>">
		<%
				}
				i++;
			}

		%>
		<input type='hidden' name="ival" id="ival" value="<%=i%>">		
		<%

}catch(Exception e)
	{
	out.println("Exception is "+e);
		}
		finally{
			try{
				if(rs1!=null)rs1.close();
				if(rs != null) rs.close();
				if(stmt1!=null) stmt1.close();
				if(stmt!=null) stmt.close();
			
				ConnectionManager.returnConnection(con);
		}catch(Exception e)
			{
			out.println("Exception is "+e);
			}
		
		}
	%>
	</table>
<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
<input type="hidden" name="params" id="params" value="<%=request.getQueryString()%>">
<input type="hidden" name="modified_flag" id="modified_flag" value="false" >
<input type="hidden" name="count" id="count" value="<%=count%>" >
 <input type="hidden" name="component_desc" id="component_desc" value="<%=component_desc%>" > 
 <input type="hidden" name="component_code" id="component_code" value="<%=component_code%>" > 
 <input type="hidden" name="chart_code" id="chart_code" value="<%=chartid%>" > 

</form>
<script>
	CheckNumMaxMin(document.forms[0].id_1, "max", "1", document.getElementById("comp_code_1").value, (document.forms[0].chartid).value)
	//CheckNumMaxMin(this,"min",<%=i%>,"<%=component_code%>","<%=chartid%>")
</script>
</body>
</html>



