<!DOCTYPE html>
<%
/*
developed by venkatesh.d on 5th may 2005
-------------------------------------------------------------------------------------------------------------------------------
	Date		Edit History	Name				Rev.Date   		Rev.By 		Description
-------------------------------------------------------------------------------------------------------------------------------
01/11/2017		IN065595		Krishna Gowtham		01/11/2017		Ramesh G	AM-Common-Discrete Measure
07/08/2019	    IN070957		Ramya Maddena	    07/08/2019      Ramesh G
08/01/2025	    68801		Gunasekar R	 		 23/01/2025  	    Twinkle Shah       ML-MMOH-CRF-0579
-------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import="webbeans.eCommon.*,java.sql.*,java.text.*,java.util.*, eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<jsp:useBean id="associateDiagBean1" class="webbeans.eCommon.RecordSet" scope="session"/>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eAM/js/DiscrMsrComp.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>	
	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

<body onLoad='chkMode(document.forms[0].comp_type);' OnMouseDown='CodeArrest();' onKeyDown="lockKey()">
<%
   String comp_id="";
 
   String long_desc="";
   String short_desc="";
   String comp_prompt="";
   String comp_type="";
   
   String referencerange = "";
   String discrmulti="";
   String dis1="";
   String dis11="";
   String disstdref="disabled";
   String disDiscTypeInd="";

   String numdigitsmax = "";
   String numdigitsmin = "";
   String numdigitsdec = "";

   String minvalue="";
   String maxvalue="";

   String confidential_yn="";
   String associate_score_yn="";
   String link_to_std_value_yn="";
   String numeric_prefix_yn="";

   String appall="";
   String Rec_vital="";
   String Rec_chart="";
   String Res_rep="";
   String Note_temp=""; 
   
   String fieldUnit = "";
   String dflt_value = "";
   String include_for_anal_yn = "";
   String enabled_checked="checked";
   String effstatus = "";
   StringBuffer numericvalues =new StringBuffer();
   String service="";
   String serviceval="";
   String freetext="";
   String histype="";
   String selectmon="";
   String selectcare="";
   String selectdoc="";
   StringBuffer alphainfovalues =new StringBuffer();
   String allrd="";
   String reflow="";
   String refhigh="";
   String criticallow="";
   String criticalhigh="";
   String std_comp_id = "";
   String descret_short_desc="";  
   String uom=""; 

   String resulttemplateid="";
  /* String comptypecode[] = {"","C","D","Z","N","P","F","I","L","T","S","H", "G", "M","V","W","X","Y","Z"};
   String comptypedesc[]={"&nbsp;------- Select -------&nbsp;","Check Box","Date","Date/Time","Decimal Numeric","Embedded Component","Formula","Integer Numeric","List","Long Text","Short Text","Time","Grid Component","Matrix Component","Multi Choice","Summary","Chart Section","VitalSigns Battery","PatientCare Panel"}; */

   String comptypecode[] = {"","C","D","E","N","P","A","R","I","L","F","X","H","S","T"};
   String comptypedesc[]={"&nbsp;------- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" -------&nbsp;",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckBox.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.date.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.datetime.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DecimalNumeric.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.EmbeddedComponent.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Formula.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.GridComponent.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.IntegerNumeric.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.List.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LongText.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.MatrixComponent.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ShortText.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Summary.label","common_labels")+""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Component.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.time.label","common_labels")};


   String sel	= "";
   String selfree	= "";
   String rd	= "";
   String chk	= "checked";
   String chkl  = "";
   String chkn  = "";
   String chka  = "";
   String confiChk = "";

   String chkapp="checked";
   String chkv="checked";
   String chkc="checked";
   String chkt="checked";
   String chkr="checked"; 
   
   String mode	= "insert";

   String stdref="";
   String rdonly = "" ;  
   String std_ref_rdonly="readonly";   
   String discr_type_id = "";
   String note_templ_char_allowed = ""; //68801

   StringBuffer paragraphDefinition=new StringBuffer();
   Connection con = null;
   PreparedStatement stmt = null;
   
   ResultSet rset = null;

try{
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
     con = ConnectionManager.getConnection(request);
	mode		=(request.getParameter("mode")==null)?"":request.getParameter("mode");
	
	
	comp_id		=(request.getParameter("comp_id")==null)?"":request.getParameter("comp_id");
	
	
	if(mode.trim().equalsIgnoreCase("update")) 
	{
		
		
		String sql = "SELECT a.SHORT_DESC,a.LONG_DESC,a.RESULT_TYPE,a.RESULT_TEMPLATE_ID,a.SERVICE_CODE,a.HIST_REC_TYPE,a.NUM_DIGITS_MAX,a.NUM_DIGITS_MIN,a.NUM_DIGITS_DEC, a.MIN_VALUE,a.MAX_VALUE,a.INCLUDE_FOR_ANAL_YN,a.ASSOCIATE_SCORE_YN,a.confidential_yn, a.LINK_TO_STD_VALUE_YN,a.NUMERIC_PREFIX_YN,a.EFF_STATUS,a.REF_RANGE_TYPE,b.STD_COMP_DESC,a.VS_APPL_YN, a.RS_APPL_YN,a.CH_APPL_YN,a.TM_APPL_YN,a.APPL_TO_ALL_CATG_YN,b.STD_COMP_DESC, b.std_comp_id,a.DISCR_TYPE_ID, c.SHORT_DESC descret_short_desc, a.note_templ_char_allowed FROM AM_DISCR_MSR a, am_standard_comp b,AM_DISCR_TYPE c  where a.DISCR_MSR_ID=? and a.STD_COMP_ID=b.STD_COMP_ID(+) and a.DISCR_TYPE_ID=c.DISCR_TYPE_ID(+)";
		
//String sql = "SELECT a.SHORT_DESC,a.LONG_DESC,a.RESULT_TYPE,a.RESULT_TEMPLATE_ID,a.SERVICE_CODE,a.HIST_REC_TYPE,a.NUM_DIGITS_MAX,a.NUM_DIGITS_MIN,a.NUM_DIGITS_DEC, a.MIN_VALUE,a.MAX_VALUE,a.INCLUDE_FOR_ANAL_YN,a.ASSOCIATE_SCORE_YN,a.confidential_yn, a.LINK_TO_STD_VALUE_YN,a.NUMERIC_PREFIX_YN,a.EFF_STATUS,a.REF_RANGE_TYPE,b.STD_COMP_DESC,a.VS_APPL_YN, a.RS_APPL_YN,a.CH_APPL_YN,a.TM_APPL_YN,a.APPL_TO_ALL_CATG_YN,b.STD_COMP_DESC, b.std_comp_id FROM AM_DISCR_MSR a, am_standard_comp b  where a.DISCR_MSR_ID='"+comp_id+"' and a.STD_COMP_ID=b.STD_COMP_ID(+)  ";
	
	stmt=con.prepareStatement(sql);
	stmt.setString	(	1,	comp_id		);
	rset = stmt.executeQuery();
	
	if(rset.next())
	{
		rd = "readonly";

		
	//	comp_prompt =(rset.getString("COMP_PROMPT")==null)?"":rset.getString("COMP_PROMPT");
		short_desc  =(rset.getString("SHORT_DESC")==null)?"":rset.getString("SHORT_DESC");
		
		long_desc   =(rset.getString("LONG_DESC")==null)?"":rset.getString("LONG_DESC");
		
		comp_type   =(rset.getString("RESULT_TYPE")==null)?"":rset.getString("RESULT_TYPE");
		resulttemplateid   =(rset.getString("RESULT_TEMPLATE_ID")==null)?"":rset.getString("RESULT_TEMPLATE_ID");
		
        service     =(rset.getString("SERVICE_CODE")==null)?"":rset.getString("SERVICE_CODE");
        histype     =(rset.getString("HIST_REC_TYPE")==null)?"":rset.getString("HIST_REC_TYPE");
		
	descret_short_desc=(rset.getString("descret_short_desc")==null)?"":rset.getString("descret_short_desc");
	//	accept_option   =(rset.getString("ACCEPT_OPTION")==null)?"":rset.getString("ACCEPT_OPTION");
		effstatus   =(rset.getString("EFF_STATUS")==null)?"":rset.getString("EFF_STATUS");
		
		if(effstatus.equals("E"))
		{	enabled_checked="checked"; 
            disDiscTypeInd ="";
		rdonly = ""; }
		else
			{
					enabled_checked="";
					dis1="disabled";
					dis11="disabled";
                    rdonly = "readonly";
					disDiscTypeInd ="disabled";
			}
		
		
		
		referencerange = rset.getString("REF_RANGE_TYPE")==null?"":rset.getString("REF_RANGE_TYPE");
     
	  //if(referencerange.equalsIgnoreCase("0")) referencerange="";
	    
	    numdigitsmax =     rset.getString ("NUM_DIGITS_MAX")==null?"":rset.getString("NUM_DIGITS_MAX");
        
		//if(numdigitsmax.equalsIgnoreCase("0")) numdigitsmax="";
		numdigitsmin = rset.getString("NUM_DIGITS_MIN")==null?"":rset.getString("NUM_DIGITS_MIN");
        

		//if(numdigitsmin.equalsIgnoreCase("0")) numdigitsmin="";
		numdigitsdec = rset.getString("NUM_DIGITS_DEC")==null?"":rset.getString("NUM_DIGITS_DEC");
		
		//if(numdigitsdec.equalsIgnoreCase("0")) numdigitsdec="";
		//dflt_value   = rset.getString("DFLT_VALUE")==null?"0":rset.getString("DFLT_VALUE");
		
        maxvalue = rset.getString("MAX_VALUE")==null?"":rset.getString("MAX_VALUE");
	
		
		minvalue = rset.getString("MIN_VALUE")==null?"":rset.getString("MIN_VALUE");
		

		
		include_for_anal_yn   =  		
		rset.getString("INCLUDE_FOR_ANAL_YN")==null?"":rset.getString("INCLUDE_FOR_ANAL_YN");

		
		
		if(include_for_anal_yn.equals("Y")) chk = "checked"; else chk="";
         
		
		associate_score_yn   = rset.getString("ASSOCIATE_SCORE_YN")==null?"":rset.getString("ASSOCIATE_SCORE_YN");
        if(associate_score_yn.equals("Y")) chka = "checked"; else chka="";
		
		
		confidential_yn   = rset.getString("confidential_yn")==null?"":rset.getString("confidential_yn");
        if(confidential_yn.equals("Y")) confiChk = "checked"; else confiChk="";

		link_to_std_value_yn   = rset.getString("LINK_TO_STD_VALUE_YN")==null?"":rset.getString("LINK_TO_STD_VALUE_YN");
        if(link_to_std_value_yn.equals("Y"))
			{
			chkl = "checked";
			if(effstatus.equals("E"))
			      disstdref = "";
			dis11="disabled";
			std_ref_rdonly="";
			}
			else chkl="";

	
        
		stdref = rset.getString("STD_COMP_DESC")==null?"":rset.getString("STD_COMP_DESC");
		std_comp_id = rset.getString("std_comp_id")==null?"":rset.getString("std_comp_id");
		discr_type_id = rset.getString("discr_type_id")==null?"":rset.getString("discr_type_id");

		numeric_prefix_yn   = rset.getString("NUMERIC_PREFIX_YN")==null?"":rset.getString("NUMERIC_PREFIX_YN");	

        if(numeric_prefix_yn.equals("Y"))
			chkn = "checked";
		else
			chkn="";

        Rec_vital   = rset.getString("VS_APPL_YN")==null?"":rset.getString("VS_APPL_YN");	
        if(Rec_vital.equals("Y")) chkv = "checked"; else chkv="";

        Rec_chart   = rset.getString("CH_APPL_YN")==null?"":rset.getString("CH_APPL_YN");	
        if(Rec_chart.equals("Y")) chkc = "checked"; else chkc="";
      	
		Note_temp   = rset.getString("TM_APPL_YN")==null?"":rset.getString("TM_APPL_YN");	
        if(Note_temp.equals("Y")) chkt = "checked"; else chkt="";
      	
        Res_rep   = rset.getString("RS_APPL_YN")==null?"":rset.getString("RS_APPL_YN");	
        if(Res_rep.equals("Y")) chkr = "checked"; else chkr="";
      	
		appall   = rset.getString("APPL_TO_ALL_CATG_YN")==null?"":rset.getString("APPL_TO_ALL_CATG_YN");	
        if(appall.equals("Y")) chkapp = "checked"; else chkapp="";
      
        note_templ_char_allowed = rset.getString("note_templ_char_allowed")==null?"":rset.getString("note_templ_char_allowed"); //68801
		//fieldUnit = rset.getString("FIELD_UNIT")==null?"":rset.getString("FIELD_UNIT");
		PreparedStatement stmt1=null;
		
		ResultSet rset1=null;
		
		numericvalues =null;

			if(comp_type.trim().equalsIgnoreCase("L") || comp_type.trim().equalsIgnoreCase("M"))
			{
				numericvalues = null;
				//String sqlalpha = " SELECT LIST_ITEM_ID, LIST_ITEM_TEXT, ORDER_SEQ_NO, DEFAULT_YN FROM CA_TEMPLATE_COMP_LIST WHERE COMP_ID = '"+comp_id+"' order by ORDER_SEQ_NO " ;
                String sqlalpha="select REF_RANGE_SEQ,REF_RNG_DESC,RESULT_VALUE,NUMERIC_VALUE,SORT_ORDER,DFLT_YN from AM_DISCR_MSR_REF_RNG_LIST where discr_msr_id ='"+comp_id+"' order by REF_RANGE_SEQ";

				stmt1=con.prepareStatement(sqlalpha);
				rset1 = stmt1.executeQuery();
				while(rset1.next())
				{
				
				//alphainfovalues += rset1.getString("ORDER_SEQ_NO")+"~"+rset1.getString("LIST_ITEM_ID")+"~"+rset1.getString("LIST_ITEM_TEXT")+"~"+rset1.getString("DEFAULT_YN")+"`";

				alphainfovalues.append(rset1.getString("REF_RANGE_SEQ")+"~"+rset1.getString("REF_RNG_DESC")+"~"+rset1.getString("RESULT_VALUE")+"~"+rset1.getString("DFLT_YN")+"~"+(rset1.getString("NUMERIC_VALUE")==null?"":rset1.getString("NUMERIC_VALUE"))+"`");
				//to add delete option
				//alphainfovalues +="N"+"`";
				
			    }
				if(rset1!=null) 	rset1.close();
				if(stmt1!=null) 	stmt1.close();
				
			}
			else if(comp_type.trim().equalsIgnoreCase("P")  || comp_type.trim().equalsIgnoreCase("R") || comp_type.trim().equalsIgnoreCase("X"))
			{
				String sqlalpha = " SELECT DISCR_MSR_DEF FROM AM_DISCR_COMP_DEFINITION WHERE DISCR_MSR_ID =? " ;
				stmt1=con.prepareStatement(sqlalpha);
				stmt1.setString	(	1,	comp_id		);
				rset1 = stmt1.executeQuery();
				while(rset1.next())
				{
					Clob clb = rset1.getClob(1);

					if(clb!=null)
					{
						java.io.BufferedReader r = new java.io.BufferedReader(clb.getCharacterStream());
						String line = null;
						while((line=r.readLine()) != null) {
							paragraphDefinition.append(line+"\n");
						}
					}
				}

				if(rset1!=null) 	rset1.close();
				if(stmt1!=null) 	stmt1.close();
			}
		}
	
		if(rset!=null) 	rset.close();
		if(stmt!=null) 	stmt.close();
		
       if(comp_type.trim().equalsIgnoreCase("N") || comp_type.trim().equalsIgnoreCase("I") || comp_type.trim().equalsIgnoreCase("A") || comp_type.trim().equalsIgnoreCase("S") )
		{
	  //String query ="select PATIENT_SEX,START_AGE,START_AGE_UNITS,END_AGE,END_AGE_UNITS,NUM_REF_LOW, REF_RANGE_SEQ,NUM_REF_HIGH, NUM_CRIT_LOW, NUM_CRIT_HIGH, NUM_DFLT_RESULT, NUM_UOM from AM_DISCR_MSR_REF_RNG_NUM where DISCR_MSR_ID= '"+comp_id+"'";//commented for IN070957
	   StringBuffer query = new StringBuffer();
	   query.append("select PATIENT_SEX,START_AGE,START_AGE_UNITS,END_AGE,END_AGE_UNITS,NUM_REF_LOW, REF_RANGE_SEQ,NUM_REF_HIGH, NUM_CRIT_LOW, NUM_CRIT_HIGH, NUM_DFLT_RESULT, NUM_UOM from AM_DISCR_MSR_REF_RNG_NUM where DISCR_MSR_ID=?");//added for IN070957
	   if(referencerange.equals("M"))
			query.append(" Order By REF_RANGE_SEQ");
		 //stmt=con.prepareStatement(query);//commented for IN070957
	   stmt=con.prepareStatement(query.toString());//added for IN070957
	   stmt.setString	(	1,	comp_id		);
	   rset = stmt.executeQuery();
	   while(rset.next())
		{
			if(referencerange.equals("M"))
			{
				//discrmulti =discrmulti+ checkForNull(rset.getString("PATIENT_SEX"))+"~"+checkForNull(rset.getString("START_AGE"))+"~"+checkForNull(rset.getString("START_AGE_UNITS"))+"~"+checkForNull(rset.getString("END_AGE"))+"~"+checkForNull(rset.getString("END_AGE_UNITS"))+"~"+checkForNull(rset.getString("REF_RANGE_SEQ"))+"~"+checkForNull(rset.getString("NUM_REF_LOW"))+"~"+checkForNull(rset.getString("NUM_REF_HIGH"))+"~"+checkForNull(rset.getString("NUM_CRIT_LOW"))+"~"+checkForNull(rset.getString("NUM_CRIT_HIGH"))+"~"+checkForNull(rset.getString("NUM_UOM"))+"~"+checkForNull(rset.getString("NUM_DFLT_RESULT"))+"~"+"N"+"`";//commented for IN070957
				discrmulti =discrmulti+ checkForNull(rset.getString("PATIENT_SEX"))+"~"+checkForNull(rset.getString("START_AGE"))+"~"+checkForNull(rset.getString("START_AGE_UNITS"))+"~"+checkForNull(rset.getString("END_AGE"))+"~"+checkForNull(rset.getString("END_AGE_UNITS"))+"~"+checkForNull(rset.getString("REF_RANGE_SEQ"))+"~"+checkForNull(rset.getString("NUM_REF_LOW"))+"~"+checkForNull(rset.getString("NUM_REF_HIGH"))+"~"+checkForNull(rset.getString("NUM_CRIT_LOW"))+"~"+checkForNull(rset.getString("NUM_CRIT_HIGH"))+"~"+checkForNull(rset.getString("NUM_UOM"))+"~"+checkForNull(rset.getString("NUM_DFLT_RESULT"))+" ~"+"N"+"`";//added for IN070957

				//numericvalues.append(discrmulti);
			}
			else
			{
				reflow =     rset.getString ("NUM_REF_LOW")==null?"":rset.getString("NUM_REF_LOW");
				refhigh =     rset.getString ("NUM_REF_HIGH")==null?"":rset.getString("NUM_REF_HIGH");
				criticallow =     rset.getString ("NUM_CRIT_LOW")==null?"":rset.getString("NUM_CRIT_LOW");
				criticalhigh =     rset.getString ("NUM_CRIT_HIGH")==null?"":rset.getString("NUM_CRIT_HIGH");
				dflt_value =     rset.getString ("NUM_DFLT_RESULT")==null?"":rset.getString("NUM_DFLT_RESULT");
				fieldUnit =     rset.getString ("NUM_UOM")==null?"":rset.getString("NUM_UOM");
			}
		}

        if(rset!=null) 	rset.close();
		if(stmt!=null) 	stmt.close();

		}
	}//end of if block(executed in the updated mode)									

	//68801 start
	String dispResLinkHtmlYN = "";
 	PreparedStatement stmt2 = null;
    ResultSet rset2 = null;
	String sql1 = "select  DISP_RES_LINK_HTML_YN from ca_note_param";
   	stmt2 = con.prepareStatement(sql1);
    rset2 = stmt2.executeQuery();
    while(rset2.next()){
    	dispResLinkHtmlYN=rset2.getString("DISP_RES_LINK_HTML_YN");
    }

    if(rset2!=null) 	rset2.close();
	if(stmt2!=null) 	stmt2.close();
	//68801 end
%>

<form name='TemplateComponent_form' id='TemplateComponent_form' action='../../servlet/eAM.DiscrMsrCompServlet' method='post' target='messageFrame'>

<table border='0' cellpadding='2' cellspacing='0' width='90%' align='center'>

<tr>
	<td width='21%' class='label'><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
	<td colspan ="6" class='fields'>&nbsp;<input type='text' name="comp_id" id="comp_id" value="<%=comp_id%>" <%=rd%> size='10' maxlength='15' 
	onkeypress="return CheckForSpecChars(event)" onBlur="CheckSpecialChar(this)">
	<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
</tr>

<!-- <tr>
	<td  align='right' class='label' >Prompt Text</td>
	<td  align='left'>&nbsp;<input type='text'  name='comp_prompt' id='comp_prompt' value="<%=comp_prompt%>" size="20" maxlength="20" onBlur="makeValidString(this)" onkeypress="return CheckForSpecCharsNoCaps(event)" <%=dis1%> >
	<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr> -->
	
<tr>
	<td  class='label' ><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
	<td  class='fields' colspan ="6">&nbsp;<input type='text'  name='long_desc' id='long_desc' value="<%=long_desc%>" size="45" maxlength="60" onkeypress="return chkspchar(this);" onBlur="makeValidString(this)" <%=rdonly%> >
	<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>

<tr>
	<td  class='label' ><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
	<td  class='fields' colspan ="6">&nbsp;<input type='text'  name='short_desc' id='short_desc' value="<%=short_desc%>" size="25" maxlength="30"  onkeypress="return chkspchar(this);"  onBlur="makeValidString(this);chkchar(this);" <%=rdonly%>>
	<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>

<tr>
	 <td class='label'><fmt:message key="Common.ComponentType.label" bundle="${common_labels}"/></td>
	 <td class='fields' colspan ="6"><%

			if(mode.equals("update"))
		   {
				
				for(int k=0;k<comptypecode.length;k++)
				{
					if(comptypecode[k].trim().equalsIgnoreCase(comp_type))
						sel = comptypedesc[k];
				}%>&nbsp;<input type='text' name='comp_type_desc' id='comp_type_desc' value="<%=sel%>" readOnly>
			<input type='hidden' name='comp_type' id='comp_type' value="<%=comp_type%>" >
		   <%}
		   else
		   {  
			 
	%>
	
	&nbsp;<select name='comp_type' id='comp_type' onChange="showHideFields(this.value,'Y');setStd(this);chkModeDefault(this);chkModePrecision(this);chkModeMax(this);chkModeLength(this);
	 chkModeMin(this),showGif(this);setDefaultLength();chkModeUnit(this);chkCharLimit(this)" <%=dis1%> > <!-- Added chkCharLimit for 68801 start-->
			<% 
				for(int k=0;k<comptypecode.length;k++)
				{
					if(comptypecode[k].equals(comp_type))
						sel = "selected";
					else
						sel = "";
					out.println("<option value='"+comptypecode[k]+"' "+sel+">"+comptypedesc[k]);
				}
		%>
	 </select>
	 <img src='../../eCommon/images/mandatory.gif'></img>&nbsp;&nbsp;
	<%
		   }
	%>


	<input type="button" class="button" id="alpha_info" name="alpha_info" value="Alpha Info" onClick="getAlphaInfo(this)" <%=dis1%>>
	
	</td>
</tr>

<tr>
	<td height='50%' class='label'><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
	<td class='fields' colspan ="6">&nbsp;<select name="service2" id="service2" onChange="setService(this)" <%=dis1%> >
			<option value=''>&nbsp;---------- ---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------- ----------&nbsp;
			<%
				
			String servicesql = " select service_code, SHORT_DESC from am_service where EFF_STATUS = 'E' order by 2 ";
				stmt=con.prepareStatement(servicesql);
				rset = stmt.executeQuery();
				while(rset.next())
				 {
					if(service.equals(rset.getString("service_code")))
					 {
						sel = "selected";
						serviceval=service;
					 }
					else
						sel = "";
					out.println("<option value='"+rset.getString("service_code")+"' "+sel+">"+rset.getString("SHORT_DESC")+"");
				 }
                 if(rset!=null) 	rset.close();
	             if(stmt!=null) 	stmt.close();
			%>
		</select>
        <input type='hidden' name='service' id='service' value="<%=serviceval%>">
		<img id="imgid" src='../../eCommon/images/mandatory.gif'></img>
	</td>
   <!--  <td align='left'  class='label'></td> -->
</tr>

<tr>
<td  class='label'><fmt:message key="eAM.HistoryTypeDirectRecording.label" bundle="${am_labels}"/></td>
<%
	if(!mode.equals("update"))
	{
selectcare="selected";
histype="PTCR";
	}
if(histype.equalsIgnoreCase("NCIN"))
selectmon="selected";
else if(histype.equalsIgnoreCase("PTCR"))
selectcare="selected";
else if(histype.equalsIgnoreCase("FDOC"))
selectdoc="selected";

			
%>
<td class='fields' colspan = "6">&nbsp;<select name="histype2" id="histype2" onChange="setHistype(this)" <%=dis1%> >
	    <!-- <option value=''>&nbsp;------ Select ------&nbsp;</option> -->
        
	    <option value='FDOC' <%=selectdoc%>><fmt:message key="eAM.FreeDocumentation.label" bundle="${am_labels}"/></option> 
		<option value='NCIN' <%=selectmon%>><fmt:message key="Common.Monitoring.label" bundle="${common_labels}"/></option>
		<option value='PTCR' <%=selectcare%>><fmt:message key="Common.PatientCare.label" bundle="${common_labels}"/></option>
		
</select>
<input type='hidden' name='histype' id='histype' value="<%=histype%>">
<img id="imgid" src='../../eCommon/images/mandatory.gif'></img>	
</td>
<!-- <td align='left' class='label'></td> -->
</tr>
<tr id="free_text">
	<td height='50%' class='label'><fmt:message key="eAM.FreeTextTemplate.label" bundle="${am_labels}"/></td>
	<td class='fields' colspan ="6">&nbsp;<select name="free_text_template" id="free_text_template" onChange="setFreeText(this)" <%=dis1%> >
		<option value=''>&nbsp;---------- ---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------- ----------&nbsp;
		<%
			String tempsql = "select result_template_id,result_template_name from am_result_template where eff_status='E' order by result_template_name ";
			stmt=con.prepareStatement(tempsql);
			rset = stmt.executeQuery();
			while(rset.next())
			 {
				if(rset.getString("result_template_id").equals(resulttemplateid))
				 {
					selfree = "selected";
                    freetext = resulttemplateid;
				 }
				else
					selfree = "";
				out.println("<option value='"+rset.getString("result_template_id")+"' "+selfree+">"+rset.getString("result_template_name")+"");
			 }
			 if(rset!=null) 	rset.close();
	         if(stmt!=null) 	stmt.close();
		%>
		</select>
        <input type='hidden' name='freetext' id='freetext' value="<%=freetext%>">  
	</td>
</tr>
<!-- <tr>
	 <td align='right' class='label'>Accept Option</td>
	<td>&nbsp;<select name='accept_option' id='accept_option' onChange="" > -->
		<%
			/*	for(int k=0;k<acceptoptioncode.length;k++)
				{
					if(acceptoptioncode[k].trim().equalsIgnoreCase(accept_option))
						sel = "selected";
					else
						sel = "";
					out.println("<option value='"+acceptoptioncode[k]+"' "+sel+">"+acceptoptiondesc[k]);
				}  */
		%>
	 <!-- </select>
		<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>  -->

<!-- <tr>
	<td align='right' class='label'>Enabled</td>
	<td  align='left'>&nbsp;<input type="checkbox" name="eff_status" id="eff_status" value="E" <%=enabled_checked%>>
	</td>
</tr> -->
<!--From Discr Measure  -->
<tr id='sp2'><td class='label' height='0' colspan=7  >&nbsp;</td></tr>
<tr id="trone" >
	<td class='label'><fmt:message key="eAM.NumericMapDigits.label" bundle="${am_labels}"/></td>
	<td class='label' width ="3%">&nbsp;<fmt:message key="Common.Max.label" bundle="${common_labels}"/>&nbsp;</td>
	<td class='fields' width ="5%"><input type="text" name="maxdgt" id="maxdgt" <%=rdonly%> value="<%=numdigitsmax%>" maxlength="1" size="1" onKeyPress='return(ChkNumberInput(this,event,0))'   OnBlur="CheckPositiveNumberLocal(this);CheckZero(this)"></td>
	<td class='label' width="3%"><fmt:message key="Common.MIN.label" bundle="${common_labels}"/>&nbsp; </td>
	<td class='fields' width ="5%"><input type="text" name="mindgt" id="mindgt" <%=rdonly%> value="<%=numdigitsmin%>" maxlength="1" size="1" onKeyPress='return(ChkNumberInput(this,event,0))'
		OnBlur="CheckPositiveNumberLocal(this);validateMinmax(this);CheckZero(this)" > </td>
	<td class='label' width="3%" ><fmt:message key="Common.DecimalNumeric.label" bundle="${common_labels}"/>&nbsp;</td>
	<td class='fields' ><input type="text" name="decimaldgt" id="decimaldgt" <%=rdonly%> value="<%=numdigitsdec%>" maxlength="2" size="2" onKeyPress='return(ChkNumberInput(this,event,0))' OnBlur="validateDeci(this);CheckZero(this)">
	</td>
</tr>
<tr id='sp1'><td class='label' height='0' colspan=7 >&nbsp;</td></tr>
<tr id="trtwo">
	<td class='label'><fmt:message key="eAM.ReferenceRanges.label" bundle="${am_labels}"/></td>
	<td class='fields' colspan ="6">&nbsp;
	 
		<%
			if(mode.equals("update"))
		    {
				if(referencerange.equals("S")) sel = "Single";
				else if(referencerange.equals("M")) sel = "Multiple";
				out.println("<input type='text' name='ref_ranges_desc' id='ref_ranges_desc' value='"+sel+"' readonly>");
				out.println("<input type='hidden' name='ref_ranges' id='ref_ranges' value='"+referencerange+"'>");
			}
			else
		   {
		%>
		<select name='ref_ranges' id='ref_ranges' onChange="setNumericFields(this.value);show(this);">			
			<option value='S'><fmt:message key="Common.single.label" bundle="${common_labels}"/>
			<option value='M'><fmt:message key="Common.multiple.label" bundle="${common_labels}"/>
		</select>
		<%}%>
		<input type="button" class="button" name="numeric_details" id="numeric_details" value="Numeric Details" <%=dis1%> onClick="showNumericDetails()">
	</td>
</tr>

<tr id="tr3">
	<td class='label'>&nbsp;</td>
	<td class='querydata' colspan ="6">
		&nbsp;&nbsp;&nbsp;<b><fmt:message key="Common.Low.label" bundle="${common_labels}"/></b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<b><fmt:message key="Common.High.label" bundle="${common_labels}"/></b>
	</td>
</tr>

<tr id="tr4">
	<td  class='label'><fmt:message key="eMP.Reference.label" bundle="${mp_labels}"/></td>
	<td colspan ="6" class='fields'>
		&nbsp;<input type="text" <%=rdonly%>  id="ref_low" value="<%=reflow%>" name="ref_low" size="3" onBlur="validateNumber2(this);validateRefCritical2(this);">
		&nbsp;<input type="text" <%=rdonly%> value="<%=refhigh%>" name="ref_high" id="ref_high"  size="3" onBlur="validateNumber2(this);chkMiinMax1(forms[0].min,this);validateRefCritical2(this);"> 
	</td>
</tr>

<tr id="tr5">
	<td class='label'><fmt:message key="Common.Critical.label" bundle="${common_labels}"/></td>
	<td colspan ="6" class='fields'>
		&nbsp;<input type="text" <%=rdonly%> value="<%=criticallow%>" name="critical_low" id="critical_low" size="3" onBlur="validateNumber2(this);validateRefCritical2(this);">
		&nbsp;<input type="text" <%=rdonly%> value="<%=criticalhigh%>" name="critical_high" id="critical_high" size="3" onBlur="validateNumber2(this);validateRefCritical2(this);"> 
	</td>
</tr>

 <tr id="tr6">
	<td class='label'><fmt:message key="Common.UnitofMeasure.label" bundle="${common_labels}"/></td>
	<td colspan ="6" class='fields'>&nbsp;&nbsp;&nbsp;<input type="text" "<%=allrd%>" value="<%=uom%>" name="unit_of_measure" id="unit_of_measure" maxlength="10" size="10"></td>
</tr>  
			
<!--  -->
<tr id="tr1">
	<td class='label'><fmt:message key="Common.length.label" bundle="${common_labels}"/></td>
	<td class='fields' colspan ="6">&nbsp;<input type="text" name="len" id="len" value="<%=referencerange%>" maxlength="4" size="4" onKeyPress='return(ChkNumberInput(this,event,0))' <%=dis1%> onBlur="return checkLength(this);">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eAM.Precision.label" bundle="${am_labels}"/>&nbsp;<input type="text" name="decimal" id="decimal"  value="<%=numdigitsdec%>" maxlength="1" size="1" onBlur="chkPrecision(this);setMaxMinLength();setDefaultLength();" onKeyPress='return(ChkNumberInput(this,event,0))' <%=dis1%>>
	</td>
</tr>
<tr id="tr2">
	<td class='label' nowrap><fmt:message key="eAM.MinValue.label" bundle="${am_labels}"/></td>
	<td class='fields' width='10%' colspan ="2">&nbsp;<input type="text" name="min" id="min"  value="<%=minvalue%>" maxlength="9" size="9"  onBLur="validateNumber2(this);chkMiinMax();validateRefCritical2(this);"  <%=rdonly%>  onKeyPress='' > </td>
	<td class='label' width='10%' colspan ="2" nowrap>&nbsp;<fmt:message key="Common.MaxValue.label" bundle="${common_labels}"/>&nbsp;</td>
	<td class='fields' width='10%' colspan ="3"><input type="text" name="max" id="max" value="<%=maxvalue%>" maxlength="9" size="9" 
	onBlur="validateNumber2(this);chkMiinMax();validateRefCritical2(this);" onKeyPress='' <%=rdonly%>>
	</td> 
	
</tr>
<tr id='un'>
<td class='label'><fmt:message key="Common.Units.label" bundle="${common_labels}"/></td>
<td class='fields' colspan ="6">&nbsp;<input type="text" name="unit" id="unit"  value="<%=fieldUnit%>" maxlength="10" size="10"  <%=rdonly%>></td>
</tr> 

<tr id="dflt">
	<td class='label'><fmt:message key="Common.DefaultValue.label" bundle="${common_labels}"/></td>
	<td  class='fields' colspan ="6">&nbsp;<input type="text" value="<%=dflt_value%>" name="default_val" id="default_val" size="45" maxlength="60" onKeyPress="return setLength(this,event);" onBlur="makeValidString(this);validateNumber(this);" <%=rdonly%>>
	</td>	

</tr>


<!-- <tr>
	<td align='right' class='label'>Include for Analysis</td>
	<td  align='left'>&nbsp;<input type="checkbox" name="include_for_anal_yn" id="include_for_anal_yn" value="Y" <%=chk%> <%=dis1%>>
	</td>
</tr> -->

<!-- </table>
<table border='0' cellpadding='2' cellspacing='0' width='90%' align='center'> -->

<tr id='anal' style='display:none'>
	<td id='wid' nowrap  class='label' >&nbsp;<fmt:message key="Common.IncludeforAnalysis.label" bundle="${common_labels}"/>&nbsp;</td>
    <td nowrap class='fields'><input type="checkbox" name="include_for_anal_yn" id="include_for_anal_yn" onClick='' value="N" <%=chk%> <%=dis1%>></td>
    <td class='label' colspan='5'>&nbsp;</td>
   
</tr>
<!-- <tr>
  <td id="tr10" nowrap align='left' class='label' colspan='3'>&nbsp;EffStatus&nbsp;<input type="checkbox" name="eff_status_yn" id="eff_status_yn" value="Y" <%=chk%><%=dis1%> >
  </td>
  <td class='label' colspan='2'>&nbsp;</td>
</tr> -->
<tr>
	<td nowrap class='label' ><fmt:message key="Common.Confidential.label" bundle="${common_labels}"/>&nbsp;</td>
	<td nowrap class='fields'><input type="checkbox" onclick="if(this.checked == true)this.value='Y';" name="confidential" id="confidential" value="N" <%=confiChk%> <%=dis1%> ></td>
	<td nowrap class='label' colspan='5'>&nbsp;</td>
	<script>
		document.forms[0].confidential.value ="<%=confidential_yn%>";
		if("<%=confidential_yn%>" == "Y")
			document.forms[0].confidential.checked = true;;
	</script>


</tr>
<tr>
	<td nowrap class='label' ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/>&nbsp;</td>
	<td nowrap class='fields'><input type="checkbox" name="eff_status" id="eff_status" value="E" <%=enabled_checked%>></td>
	<td nowrap class='label' colspan='5'>&nbsp;</td>
</tr>
<tr id="tr9">
	<td   nowrap class='label'><fmt:message key="eAM.AssociateScore.label" bundle="${am_labels}"/>&nbsp;</td>
	<td nowrap class='fields'><input type="checkbox" name="ass_score_yn" id="ass_score_yn" value="N" <%=chka%> <%=dis1%> onclick="asscheck(this)"></td>
	<td nowrap class='label' colspan='5'>&nbsp;</td>
</tr>
<tr id="tr77">
	<td    nowrap class='label' id="tr11"><fmt:message key="Common.NumericPrefixRequired.label" bundle="${common_labels}"/>&nbsp;</td>
	<td nowrap class='fields' id="tr112"><input type="checkbox" name="nu_pre_yn" id="nu_pre_yn" value="Y" <%=chkn%> <%=dis1%>></td>
    <td  nowrap  class='label' colspan="3" id="tr44"><fmt:message key="eAM.DiscreteTypeIndicator.label" bundle="${am_labels}"/>&nbsp;</td> 
    <td class='fields'  colspan="4" id="tr55"><input type='text' name="discr_typeInd" id="discr_typeInd" value="<%=descret_short_desc%>"  size='15' maxlength='15' 
	onkeypress="" onBlur="beforeGetDiscreteTypeInd(this,disTypeIndval);" <%=disDiscTypeInd%> ><input type='button' class='button' value='?'  name='search_ref1' id='search_ref1' onClick="getdiscretetypeind(discr_typeInd,disTypeIndval);" <%=disDiscTypeInd%> ></td>
</tr> 
<!-- </table> -->
<!-- <table border='0' cellpadding='0' cellspacing='0' width='90%' align='center'> -->

<tr id="tr8">
	<td nowrap   class='label' width=''><fmt:message key="eAM.LinkStandardValue.label" bundle="${am_labels}"/>&nbsp;</td>
	<td nowrap class='fields' colspan="9"><input type="checkbox" name="link_yn" id="link_yn" value="N" onclick='mand(this)' <%=chkl%> <%=dis1%>></td>

    <td id='cols1' nowrap  class='label' colspan="3"><fmt:message key="eAM.StandardValueRef.label" bundle="${am_labels}"/>&nbsp;</td> 
    <td id='cols2' class='fields' colspan="4"><input type='text' name="std_ref" id="std_ref" value="<%=stdref%>"  size='15' maxlength='15' 
	onkeypress="" onBlur="" <%=std_ref_rdonly%> <%=disstdref%>><input type='button' class='button' value='?'  name='search_ref' id='search_ref' onClick="getServiceCode3()" <%=disstdref%>> <img id="std_value_ref" style="visibility:hidden"  src='../../eCommon/images/mandatory.gif'></img>	
 </td>
		
</tr>
</table>
<table id='apptab' border='0' cellpadding='2' cellspacing='0' width='90%' align='center'>
<tr>
	<th nowrap align='left' colspan='4'><fmt:message key="eAM.ApplicableCategoriesAll.label" bundle="${am_labels}"/><input type="checkbox" name="sel_all" id="sel_all" value="Y" onClick="checkall(this)" <%=chkapp%> <%=dis11%> >
	</th>
</tr>
		
<tr>
    <td nowrap class='label'>&nbsp;<fmt:message key="eAM.RecordingVital.label" bundle="${am_labels}"/> 
    <input type="checkbox" name="Rec_vital" id="Rec_vital" value="Y" onClick="enabcategory(this)" <%=chkv%> <%=dis11%> ></td>
	<td nowrap class='label' >&nbsp;<fmt:message key="eAM.RecordingChart.label" bundle="${am_labels}"/> 
    <input type="checkbox" name="Rec_chart" id="Rec_chart" value="Y" onClick="enabcategory(this)" <%=chkc%> <%=dis11%>></td>
	<td nowrap class='label' >&nbsp;<fmt:message key="Common.ResultReporting.label" bundle="${common_labels}"/> 
    <input type="checkbox" name="Res_rep" id="Res_rep" value="Y" onClick="enabcategory(this)"  <%=chkr%> <%=dis11%> ></td>
    <td nowrap class='label' >&nbsp;<fmt:message key="eAM.NotesTemplate.label" bundle="${am_labels}"/>
    <input type="checkbox" name="Note_temp" id="Note_temp" value="Y" onClick="enabcategory(this)" <%=chkt%> <%=dis1%> ></td>
    <!-- <td id='ins'>&nbsp;</td> -->
    
    <tr id='noteTempCharTr' style='display:none'> <!-- 68801 start-->
   	<td class='label' colspan="3">&nbsp;</td> 
    <td class='label' >&nbsp;<fmt:message key="eAM.NoteTemplateCharAllowed.label" bundle="${am_labels}"/>&nbsp;
    <input type='number' name="char_limit" id="char_limit" onblur="noteTemplCharAllowed();"  onKeyPress="return CheckForNumsAndColon(event)" value='<%=note_templ_char_allowed%>' size='2' maxlength='3' >	
 	</td></tr><!--68801 end-->
</table>
<textarea style="display:none" name="paragraphDef" ><%=paragraphDefinition%></textarea>
<input type='hidden' name='mode' id='mode' value="<%=mode%>">
<%
	ArrayList b1= new ArrayList();
		b1= associateDiagBean1.getRecordSetHandle();
		associateDiagBean1.clearAll();
		associateDiagBean1.putObject(alphainfovalues);
		//associateDiagBean1.putObject("shyam1");

	%>
<input type='hidden' name='alpha_info_values' id='alpha_info_values' value="<%=alphainfovalues%>">
<input type='hidden' name='numeric_details_values' id='numeric_details_values' value="<%=discrmulti%>">
<input type='hidden' name="beforeUpdateEff_status" id="beforeUpdateEff_status" value="<%=enabled_checked%>">
<input type='hidden' name="comp_id_update" id="comp_id_update" value="<%=comp_id%>">
<input type='hidden' name="comp_type_update" id="comp_type_update" value="<%=comp_type%>">
<input type='hidden' name="eff_status_value" id="eff_status_value" value="<%=effstatus%>">
<input type='hidden' name="gridComponentDefinition" id="gridComponentDefinition" value="<%=paragraphDefinition%>">
<input type='hidden' name="matrixComponentDefinition" id="matrixComponentDefinition" value="<%=paragraphDefinition%>">
<input type='hidden' name="matrix_max_columns_allowed" id="matrix_max_columns_allowed" value="10">
<input type='hidden' name="grid_max_columns_allowed" id="grid_max_columns_allowed" value="10">
<input type='hidden' name='stdrefval' id='stdrefval' value="<%=std_comp_id%>">
<input type='hidden' name='disTypeIndval' id='disTypeIndval' value="<%=discr_type_id%>">
<input type='hidden' name='VS_APPL_YN' id='VS_APPL_YN' value="<%=chkv%>"><!--IN065595-->
<input type='hidden' name='TM_APPL_YN' id='TM_APPL_YN' value="<%=chkt%>"><!--IN065595-->
<input type='hidden' name="dispResLinkHtmlYN" id="dispResLinkHtmlYN" value="<%=dispResLinkHtmlYN%>"> <!-- 68801 -->
	
	
<!-- please do not change the value for the above parameter until required. this might have adverse affects on the matrix component. This field is used in the MatrixComponentBean to construct the matrix. please change with lot of care-->
<%
	
if(mode.equals("update"))
out.println("<script>showHideFields('"+comp_type+"','N','"+referencerange+"');</script>");
else 
out.println("<script>initFields();</script>");
}
catch(Exception e){
//	out.println(e.toString());
	e.printStackTrace(System.err);
}
finally{
	
	if(con!=null)ConnectionManager.returnConnection(con,request);
	}

	//out.println("<script>initFields();</script>");
%>

</form>
</body>
</html>
<%!
public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
}
%>
<!-- 68801 start -->
<script>
var dispResLinkHtmlYN = document.TemplateComponent_form.dispResLinkHtmlYN.value;
var mode = document.TemplateComponent_form.mode.value;
var comp_type = document.TemplateComponent_form.comp_type.value;

if(mode == "update" && comp_type == "F" && dispResLinkHtmlYN == "Y" ){
	document.TemplateComponent_form.char_limit.disabled = true;
	document.TemplateComponent_form.char_limit.value = "";
}
</script>
<!-- 68801 end -->

