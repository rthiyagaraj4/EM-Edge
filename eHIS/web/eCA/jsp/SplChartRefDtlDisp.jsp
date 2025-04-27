<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
?             100            ?           	    ?				?			created
30/07/2018	IN061886		Ramesh G				    					To be able to plot Growth Charts for Pre Term babies and abnormal babies.
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@ page import ="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title>SplChartRefDtlList</title>
		<script src='../../eCA/js/SplChartRef.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
//			parent.parent.frameSplChartRefHdr.document.forms[0].spl_chart_type.disabled = true;
			//alert(getCAMessage("RECORD_ALREADY_EXISTS"));
		</script>
<%! private void checkNull(String st)
	{	
	if(st==null || st.equals("null"))
		st = "";
	}
%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<style type="text/css">
      .p_header 
	  {		
		background-color: #FFFFFF;
		margin-right:none; 
		font-family: Verdana, Arial, Helvetica, sans-serif;
		font-size: 8pt;	
		color: black;
		font-weight:normal;
		text-align:left;
		padding:0px;
		vertical-align:middle;	
		border-bottom:0px;
		border-top:0px;
		border-left:0px;
		border-right:0px;
		border-style:normal;
		width:1px;
		position:relative;
		border-color:#659EC7;
		height:20px;
      }
	 .header 
	 {
		height:20px;
		margin-right:none; 
		background-color: #FFFFFF;
		font-family: Verdana, Arial, Helvetica, sans-serif;
		font-size: 8pt;	
		color: black;
		font-weight:normal;
		text-align:left;
		padding:0px;
		vertical-align:middle;
		border-bottom:0px;
		border-top:0px;
		border-left:0px;
		border-right:0px;
		border-style:solid;
		width:40px;
	  }
   </style>
</head>

<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<form name="SplChartRefDtlList" id="SplChartRefDtlList"  action="../../servlet/eCA.SplChartRefServlet" method="post" target="messageFrame">
<table  width='100%' class='grid' >
<tr>
	<td class='COLUMNHEADERCENTER'  width='14%'><fmt:message key="Common.Range.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADERCENTER'  width='8%'><fmt:message key="eCA.Median.label" bundle="${ca_labels}"/></td>
	<td class='COLUMNHEADERCENTER' width='8%'><fmt:message key="Common.Variance.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADERCENTER' width='8%'><fmt:message key="eCA.Trans.label" bundle="${ca_labels}"/></td>	
<%

		String splChartType = request.getParameter("spl_chart_type");
		splChartType = splChartType==null?"":splChartType;

		String splChartGroup = request.getParameter("spl_chart_group");
		splChartGroup = splChartGroup==null?"":splChartGroup;

		String elementType = request.getParameter("element_type");
		elementType = elementType==null?"":elementType;
		
		String xAxis_element = request.getParameter("xAxis_element")==null?"*K":(String)request.getParameter("xAxis_element");	

		String gender = request.getParameter("gender");
		gender = gender==null?"":gender;
		
		StringBuffer key_ref = new StringBuffer();
		key_ref.append(splChartType);
		key_ref.append("#");
		key_ref.append(splChartGroup);
		key_ref.append("#");
		key_ref.append(elementType);
		key_ref.append("#");
		key_ref.append(gender);
		
		String P1_Header ="2";
		String P2_Header= "5";
		String P3_Header= "10";
		String P4_Header= "25";
		String P5_Header= "50";
		String P6_Header= "75";
		String P7_Header= "90";
		String P8_Header= "95";
		String P9_Header= "97";
		String P10_Header="";
		String P11_Header="";
		String P12_Header="";
		int cntHeaderVal = 0;

		Connection con = null;
		PreparedStatement ps1 = null;
		ResultSet res1 = null;
		ArrayList prefArray=new  ArrayList();	
		prefArray.add(0,P1_Header);
		prefArray.add(1,P2_Header);
		prefArray.add(2,P3_Header);
		prefArray.add(3,P4_Header);
		prefArray.add(4,P5_Header);
		prefArray.add(5,P6_Header);
		prefArray.add(6,P7_Header);
		prefArray.add(7,P8_Header);
		prefArray.add(8,P9_Header);
		prefArray.add(9,P10_Header);
		prefArray.add(10,P11_Header);
		prefArray.add(11,P12_Header);							
		try
			{
				con = ConnectionManager.getConnection(request);		
				String sqlStr="SELECT PREF_DESC  FROM CA_SPL_CHART_REF_DTL ORDER BY ABS(SUBSTR(PREF_DESC, 2))"; 

				ps1 = con.prepareStatement(sqlStr);
				//ps1.setString(1,key_ref.toString());
				res1 = ps1.executeQuery();
				int i=0;
				while(res1.next())
				{  
					String str= res1.getString("PREF_DESC");
					//out.println("str   :   "+str);
					prefArray.set(i,str.substring(1));	
					if(((String)prefArray.get(i)).equals(""))
					{
						cntHeaderVal++;
					}
					i++;
				}
				if(res1 != null) res1.close();
				if(ps1 != null) ps1.close();
				
				//out.println("===>cntHeaderVal   :     "+cntHeaderVal);
		}
		catch(Exception e)
		{
			out.println("Exception in try of SplChartRefDtlList.jsp for Percentile Header"+e.toString());
		}
		if(cntHeaderVal < 12)
		{
			P1_Header=(String)prefArray.get(0);
			P2_Header=(String)prefArray.get(1);
			P3_Header=(String)prefArray.get(2);
			P4_Header=(String)prefArray.get(3);
			P5_Header=(String)prefArray.get(4);
			P6_Header=(String)prefArray.get(5);
			P7_Header=(String)prefArray.get(6);
			P8_Header=(String)prefArray.get(7);
			P9_Header=(String)prefArray.get(8);
			P10_Header=(String)prefArray.get(9);
			P11_Header=(String)prefArray.get(10);		
			P12_Header=(String)prefArray.get(11);		
		}
		%>
	<td width='10%' class='COLUMNHEADERCENTER'   nowrap>	
	<label class='p_header'>P</label><input type='text' name='header1' id='header1' id="P1" class='header' size='4' maxlength='3' value='<%=P1_Header%>' onkeypress="return CheckForSpeChar(event);" onBlur="checkPercentileHeader(this);enableFileds(this);" ></td>
	
	<td width='10%' class='COLUMNHEADERCENTER'   nowrap>
	<label class='p_header'>P</label><input type='text'  name='header2' id='header2' id="P2" class='header'  size='4' maxlength='3' value='<%=P2_Header%>' onkeypress="return CheckForSpeChar(event);" onBlur="checkPercentileHeader(this);enableFileds(this);"></td>

	<td width='10%' class='COLUMNHEADERCENTER'   nowrap>
	<label class='p_header'>P</label><input type='text'  name='header3' id='header3' id="P3" class='header'  size='4' maxlength='3' value='<%=P3_Header%>' onkeypress="return CheckForSpeChar(event);" onBlur="checkPercentileHeader(this);enableFileds(this);"></td>

	<td width='10%' class='COLUMNHEADERCENTER'   nowrap>
	<label class='p_header'>P</label><input type='text'  name='header4' id='header4' id="P4" class='header'  size='4' maxlength='3' value='<%=P4_Header%>' onkeypress="return CheckForSpeChar(event);" onBlur="checkPercentileHeader(this);enableFileds(this);"></td>

	<td width='10%' class='COLUMNHEADERCENTER'   nowrap>
	<label class='p_header'>P</label><input type='text'  name='header5' id='header5' id="P5" class='header'  size='4' maxlength='3' value='<%=P5_Header%>' onkeypress="return CheckForSpeChar(event);" onBlur="checkPercentileHeader(this);enableFileds(this);"></td>

	<td width='10%' class='COLUMNHEADERCENTER'   nowrap>
	<label class='p_header'>P</label><input type='text'  name='header6' id='header6' id="P6" class='header'  size='4' maxlength='3' value='<%=P6_Header%>' onkeypress="return CheckForSpeChar(event);" onBlur="checkPercentileHeader(this);enableFileds(this);"></td>

	<td width='10%' class='COLUMNHEADERCENTER'   nowrap>
	<label class='p_header'>P</label><input type='text'  name='header7' id='header7' id="P7" class='header'  size='4' maxlength='3' value='<%=P7_Header%>' onkeypress="return CheckForSpeChar(event);" onBlur="checkPercentileHeader(this);enableFileds(this);"></td>

	<td width='10%' class='COLUMNHEADERCENTER'   nowrap>
	<label class='p_header'>P</label><input type='text'  name='header8' id='header8' id="P8" class='header'  size='4' maxlength='3' value='<%=P8_Header%>' onkeypress="return CheckForSpeChar(event);" onBlur="checkPercentileHeader(this);enableFileds(this);"></td>

	<td width='10%' class='COLUMNHEADERCENTER'   nowrap>
	<label class='p_header'>P</label><input type='text'  name='header9' id='header9' id="P9" class='header'  size='4' maxlength='3' value='<%=P9_Header%>' onkeypress="return CheckForSpeChar(event);" onBlur="checkPercentileHeader(this);enableFileds(this);"></td>

	<td width='10%' class='COLUMNHEADERCENTER'   nowrap>
	<label class='p_header'>P</label><input type='text'  name='header10' id='header10' id="P10" class='header'  size='4' maxlength='3' value='<%=P10_Header%>' onkeypress="return CheckForSpeChar(event);" onBlur="checkPercentileHeader(this);enableFileds(this);"></td>

	<td width='10%' class='COLUMNHEADERCENTER'   nowrap>
	<label class='p_header'>P</label><input type='text'  name='header11' id='header11' id="P11" class='header'  size='4' maxlength='3' value='<%=P11_Header%>' onkeypress="return CheckForSpeChar(event);" onBlur="checkPercentileHeader(this);enableFileds(this);"></td>

	<td width='10%' class='COLUMNHEADERCENTER'   nowrap>
	<label class='p_header'>P</label><input type='text'  name='header12' id='header12' id="P12" class='header'  size='4' maxlength='3' value='<%=P12_Header%>' onkeypress="return CheckForSpeChar(event);" onBlur="checkPercentileHeader(this);enableFileds(this);"></td>
	
</tr>
<%		
	//out.println("<script>alert('"+gender+"')</script>");
	String classValue = "";
	int i = 1;
	int totalRecords = 0;
	
	PreparedStatement pstmt = null, pstmt1 = null;
	ResultSet rset = null, rset1 = null;

	String sql = "",sql1 = "";

	try{
		
	//	sql = "SELECT  KEY_VALUE, MEDIAN_VALUE, VARIATION_VALUE,BOX_CON_TRANS_VALUE,PREF1,PREF2,PREF3,PREF4,PREF5,PREF6,PREF7,PREF8,PREF9,PREF10,PREF11,PREF12 FROM CA_SPL_CHART_REF_VALUE WHERE SPL_CHART_TYPE = ? AND ELEMENT_TYPE=? AND GENDER = ? AND SPL_CHART_TYPE_GRP_ID = ? ORDER BY to_number(KEY_VALUE)";
		sql = "SELECT  KEY_VALUE, MEDIAN_VALUE, VARIATION_VALUE,BOX_CON_TRANS_VALUE,PREF1,PREF2,PREF3,PREF4,PREF5,PREF6,PREF7,PREF8,PREF9,PREF10,PREF11,PREF12 FROM CA_SPL_CHART_REF_VALUE WHERE SPL_CHART_TYPE = ? AND ELEMENT_TYPE=? AND GENDER = ? AND SPL_CHART_TYPE_GRP_ID = ? AND X_ELEMENT_TYPE=? AND to_number(KEY_VALUE) = ? ORDER BY to_number(KEY_VALUE)";

		//sql1 = "SELECT START_VALUE,VALUE_UNIT FROM CA_SPL_CHART_KEY_VALUE WHERE SPL_CHART_TYPE=? AND to_number(KEY_VALUE) = ?";
		sql1 = "SELECT KEY_VALUE,START_VALUE,VALUE_UNIT FROM CA_SPL_CHART_KEY_VALUE WHERE SPL_CHART_TYPE=? AND SPL_CHART_TYPE_GRP_ID = ? AND X_ELEMENT_TYPE=? ORDER BY to_number(KEY_VALUE)";

	    //pstmt1 = con.prepareStatement(sql1);
	    pstmt1 = con.prepareStatement(sql);

		//pstmt = con.prepareStatement(sql);
		pstmt = con.prepareStatement(sql1);
		pstmt.setString(1,splChartType);
		pstmt.setString(2,splChartGroup);
		pstmt.setString(3,xAxis_element);
		/*pstmt.setString(1,splChartType);
		pstmt.setString(2,elementType);
		pstmt.setString(3,gender);
		pstmt.setString(4,splChartGroup);*/
		rset  = pstmt.executeQuery();
			
		String keyValue = "";
		String medianValue = "";
		String variationValue = "";
		String transValue = "";
		
		String rangeValue = "",unit = "",unitValue = "";

		String PREF1 = "";
		String PREF2= "";
		String PREF3= "";
		String PREF4= "";
		String PREF5= "";
		String PREF6= "";
		String PREF7= "";
		String PREF8= "";
		String PREF9= "";
		String PREF10= "";
		String PREF11= "";
		String PREF12= "";
	
		classValue = "gridData";
		i = 1;
		while(rset.next())
		{			
			keyValue		= rset.getString("KEY_VALUE")==null ? "":rset.getString("KEY_VALUE");
			unit = rset.getString("VALUE_UNIT");

			//out.println("unit"+unit);
			if(unit.equals("M"))
				 unitValue = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.months.label","common_labels");
			else if(unit.equals("Y"))
				 unitValue =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Years.label","common_labels");
			else if(unit.equals("D"))
				 unitValue = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels");
			else if(unit.equals("KG"))
				 unitValue =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Kgs.label","common_labels");
			else if(unit.equals("KM"))
				 unitValue =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.kgm2.label","ca_labels");
			else if(unit.equals("CM"))
				 unitValue =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.centimeters.label","ca_labels");				 
			else if(unit.equals("W"))
				 unitValue =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.weeks.label","common_labels");   //IN061886
			rangeValue = rset.getString("START_VALUE")+"~"+keyValue+" "+unitValue;
			
			/*medianValue     = rset.getString("MEDIAN_VALUE")==null ? "":rset.getString("MEDIAN_VALUE");
			variationValue  = rset.getString("VARIATION_VALUE")==null ? "":rset.getString("VARIATION_VALUE");
			transValue		= rset.getString("BOX_CON_TRANS_VALUE")==null ? "":rset.getString("BOX_CON_TRANS_VALUE");
  		    PREF1 = rset.getString("PREF1")==null ? "":rset.getString("PREF1");
			PREF2 = rset.getString("PREF2")==null ? "":rset.getString("PREF2");
			PREF3 = rset.getString("PREF3")==null ? "":rset.getString("PREF3"); 
			PREF4 = rset.getString("PREF4")==null ? "":rset.getString("PREF4");
			PREF5 = rset.getString("PREF5")==null ? "":rset.getString("PREF5");
			PREF6 = rset.getString("PREF6")==null ? "":rset.getString("PREF6");
			PREF7 = rset.getString("PREF7")==null ? "":rset.getString("PREF7");
			PREF8 = rset.getString("PREF8")==null ? "":rset.getString("PREF8");
			PREF9 = rset.getString("PREF9")==null ? "":rset.getString("PREF9");
			PREF10 = rset.getString("PREF10")==null ? "":rset.getString("PREF10");
			PREF11 = rset.getString("PREF11")==null ? "":rset.getString("PREF11");
			PREF12 = rset.getString("PREF12")==null ? "":rset.getString("PREF12");*/
			
			/*if(i % 2 == 0 )
				classValue	=	"gridData";
			else	
				classValue	=	"gridData";*/
				//out.println(splChartType+"{}"+keyValue);
		/*	pstmt1.setString(1,splChartType);
			pstmt1.setString(2,(keyValue));*/
			pstmt1.setString(1,splChartType);
			pstmt1.setString(2,elementType);
			pstmt1.setString(3,gender);
			pstmt1.setString(4,splChartGroup);
			pstmt1.setString(5,xAxis_element);
			pstmt1.setString(6,keyValue);
			rset1 = pstmt1.executeQuery();
			if(rset1.next())
			{	

				medianValue     = rset1.getString("MEDIAN_VALUE")==null ? "":rset1.getString("MEDIAN_VALUE");
				variationValue  = rset1.getString("VARIATION_VALUE")==null ? "":rset1.getString("VARIATION_VALUE");
				transValue		= rset1.getString("BOX_CON_TRANS_VALUE")==null ? "":rset1.getString("BOX_CON_TRANS_VALUE");
				PREF1 = rset1.getString("PREF1")==null ? "":rset1.getString("PREF1");
				PREF2 = rset1.getString("PREF2")==null ? "":rset1.getString("PREF2");
				PREF3 = rset1.getString("PREF3")==null ? "":rset1.getString("PREF3"); 
				PREF4 = rset1.getString("PREF4")==null ? "":rset1.getString("PREF4");
				PREF5 = rset1.getString("PREF5")==null ? "":rset1.getString("PREF5");
				PREF6 = rset1.getString("PREF6")==null ? "":rset1.getString("PREF6");
				PREF7 = rset1.getString("PREF7")==null ? "":rset1.getString("PREF7");
				PREF8 = rset1.getString("PREF8")==null ? "":rset1.getString("PREF8");
				PREF9 = rset1.getString("PREF9")==null ? "":rset1.getString("PREF9");
				PREF10 = rset1.getString("PREF10")==null ? "":rset1.getString("PREF10");
				PREF11 = rset1.getString("PREF11")==null ? "":rset1.getString("PREF11");
				PREF12 = rset1.getString("PREF12")==null ? "":rset1.getString("PREF12");


		/*		unit = rset1.getString("VALUE_UNIT");
				
				//out.println("unit"+unit);
				if(unit.equals("M"))
					 unitValue = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.months.label","common_labels");
				else if(unit.equals("Y"))
					 unitValue =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Years.label","common_labels");
				else if(unit.equals("D"))
					 unitValue = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels");
				rangeValue = rset1.getString("START_VALUE")+"~"+keyValue+" "+unitValue;*/
			}
			if(rset1!=null)
				rset1.close();
			//out.println("unitValue"+unitValue);

		%>
		
		<tr >
			<td width='16%' class = '<%=classValue%>' nowrap>&nbsp;<%=rangeValue%>&nbsp;</td>

			<input type='hidden' name='key_value<%=i%>' id='key_value<%=i%>' value='<%=keyValue%>'/>
			<td width='10%' class = '<%=classValue%>' nowrap><input type='text' name='median_value<%=i%>' id='median_value<%=i%>' size='4' maxlength='20' value='<%=medianValue%>'  onkeypress="return allowNumber();" onBlur="checkNumber1(this);"></td>
			<td width='10%' class = '<%=classValue%>' nowrap><input type='text' name='variation_value<%=i%>' id='variation_value<%=i%>' size='4' maxlength='20' value='<%=variationValue%>' onkeypress="return allowNumber();" onBlur="checkNumber1(this);"></td>
			<td width='10%' class = '<%=classValue%>' nowrap><input type='text' name='trans_value<%=i%>' id='trans_value<%=i%>' size='4' maxlength='20' value='<%=transValue%>' onkeypress="return allowNumber();" onBlur="checkNumber1(this);"></td>
			<td width='10%' class = '<%=classValue%>' nowrap><input type='text' name='p1_value<%=i%>' id='p1_value<%=i%>' <%if(P1_Header.equals("")){%>readOnly<%}%>  size='4' maxlength='20' value='<%=PREF1%>'  onkeypress="return allowNumber();" onBlur="checkNumber1(this);"></td>
			<td width='10%' class = '<%=classValue%>' nowrap><input type='text' name='p2_value<%=i%>' id='p2_value<%=i%>'  <%if(P2_Header.equals("")){%>readOnly<%}%> size='4' maxlength='20' value='<%=PREF2%>' onkeypress="return allowNumber();" onBlur="checkNumber1(this);"></td>
			<td width='10%' class = '<%=classValue%>' nowrap><input type='text' name='p3_value<%=i%>' id='p3_value<%=i%>'  <%if(P3_Header.equals("")){%>readOnly<%}%> size='4' maxlength='20' value='<%=PREF3%>' onkeypress="return allowNumber();" onBlur="checkNumber1(this);"></td>
			<td width='10%' class = '<%=classValue%>' nowrap><input type='text' name='p4_value<%=i%>' id='p4_value<%=i%>'  <%if(P4_Header.equals("")){%>readOnly<%}%> size='4' maxlength='20' value='<%=PREF4%>' onkeypress="return allowNumber();" onBlur="checkNumber1(this);"></td>
			<td width='10%' class = '<%=classValue%>' nowrap><input type='text' name='p5_value<%=i%>' id='p5_value<%=i%>' <%if(P5_Header.equals("")){%>readOnly<%}%>  size='4' maxlength='20' value='<%=PREF5%>' onkeypress="return allowNumber();" onBlur="checkNumber1(this);"></td>
			<td width='10%' class = '<%=classValue%>' nowrap><input type='text' name='p6_value<%=i%>' id='p6_value<%=i%>' <%if(P6_Header.equals("")){%>readOnly<%}%>  size='4' maxlength='20' value='<%=PREF6%>' onkeypress="return allowNumber();" onBlur="checkNumber1(this);"></td>
			<td width='10%' class = '<%=classValue%>' nowrap><input type='text' name='p7_value<%=i%>' id='p7_value<%=i%>' <%if(P7_Header.equals("")){%>readOnly<%}%>  size='4' maxlength='20' value='<%=PREF7%>' onkeypress="return allowNumber();" onBlur="checkNumber1(this);"></td>
			<td width='10%' class = '<%=classValue%>' nowrap><input type='text' name='p8_value<%=i%>' id='p8_value<%=i%>'  <%if(P8_Header.equals("")){%>readOnly<%}%> size='4' maxlength='20' value='<%=PREF8%>' onkeypress="return allowNumber();" onBlur="checkNumber1(this);"></td>
			<td width='10%' class = '<%=classValue%>' nowrap><input type='text' name='p9_value<%=i%>' id='p9_value<%=i%>' <%if(P9_Header.equals("")){%>readOnly<%}%>  size='4' maxlength='20' value='<%=PREF9%>' onkeypress="return allowNumber();" onBlur="checkNumber1(this);"></td>
			<td width='10%' class = '<%=classValue%>' nowrap><input type='text' name='p10_value<%=i%>' id='p10_value<%=i%>' <%if(P10_Header.equals("")){%>readOnly<%}%> size='4' maxlength='20' value='<%=PREF10%>' onBlur="checkNumber1(this);" onkeypress=" return allowNumber(this);"></td>
			<td width='10%' class = '<%=classValue%>' nowrap><input type='text' name='p11_value<%=i%>' id='p11_value<%=i%>' <%if(P11_Header.equals("")){%>readOnly<%}%> size='4' maxlength='20' value='<%=PREF11%>'  onBlur="checkNumber1(this);" onkeypress="return allowNumber(this);"></td>
			<td width='10%' class = '<%=classValue%>' nowrap><input type='text' name='p12_value<%=i%>' id='p12_value<%=i%>' <%if(P12_Header.equals("")){%>readOnly<%}%>  size='4' maxlength='20' value='<%=PREF12%>' onBlur="checkNumber1(this);" onkeypress="return allowNumber(this);"></td>				
		</tr>		
		<%
		i++;
		}		
		totalRecords = i -1;
		if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();
		if(pstmt1!=null) pstmt1.close();
	} 
	catch(Exception e){
		out.println("Exception in try of SplChartRefDtlDisp.jsp"+e.toString());
	}
	finally{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>
</table>
<input type="hidden" name="spl_chart_type" id="spl_chart_type" value = "<%=splChartType%>"/>
<input type="hidden" name="spl_chart_group" id="spl_chart_group" value = "<%=splChartGroup%>"/>
<input type="hidden" name="element_type" id="element_type" value = "<%=elementType%>"/>
<input type="hidden" name="xAxis_element" id="xAxis_element" value = "<%=xAxis_element%>"/>
<input type="hidden" name="gender" id="gender" value = "<%=gender%>"/>
<input type="hidden" name="rec_count" id="rec_count" value = "<%=totalRecords%>"/>
</form>
</body>
</html>

