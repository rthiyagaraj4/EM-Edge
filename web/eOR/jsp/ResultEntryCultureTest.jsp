<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------------------------
15/05/2017	IN064122		Dinesh T										Header Format is missing when header is not 																				having any mandatory fields
--------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
 <%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
    <TITLE><fmt:message key="eOR.CultureTest.label" bundle="${or_labels}"/></TITLE>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
 	<script language="JavaScript" src="../js/ResultEntry.js"></script>

 	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
 	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
 	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<!---->
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script type="text/javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<Style>   </Style>
	<script>
					
	</script>
</HEAD>
<BODY >
<% try{
	String bean_id = "Or_ResultEntry" ;
	
	String bean_name = "eOR.ResultEntryBean";
	String index	= request.getParameter("index");
	String line_index	= request.getParameter("line_index")==null?"0":request.getParameter("line_index");
	String chart_result_type = request.getParameter("chart_result_type");
	if (chart_result_type == null) chart_result_type = "";
	String antibiotic_organism_reqd_yn = request.getParameter("antibiotic_organism_reqd_yn");
	String sex = request.getParameter("sex") == null ? "A" : request.getParameter("sex");	
	String dob = request.getParameter("dob")== null ? "" : request.getParameter("dob");	

	String remarks = request.getParameter("remarks");
	if (index == null) index = "0";
	if (antibiotic_organism_reqd_yn == null) antibiotic_organism_reqd_yn = "";
	if (remarks == null) remarks = "";
	ResultEntryBean bean = (ResultEntryBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clear() ;
	String organism_string		= "";
	ArrayList headingDetails	= bean.getChartHeadingDetails(chart_result_type);
	String horizontalHeading	= "";
	String verticalHeading		= "";
	//String unitofmeasure		= "";

	int	chart_no_columns		= 0;
	ArrayList organismDetails	= bean.getOrganismDetails(chart_result_type);
		
	/*String organismString		= "";
    if (organismDetails != null) {
		for (int i=0; i < organismDetails.size(); i++) {
			String [] record = (String[])organismDetails.get(i);
			organismString += "<option value='"+record[1]+"'>"+record[0]+"</option>";
		}
	}*/

	if (headingDetails != null &&headingDetails.size() > 0) {
		String [] headingRecord = (String[])headingDetails.get(0);
		verticalHeading			= bean.checkForNull(headingRecord[0]);
		horizontalHeading		= bean.checkForNull(headingRecord[1]);
		chart_no_columns		= Integer.parseInt(bean.checkForNull(headingRecord[2],"0"));
	}


	int prevIndx				= 0;
	int currIndx				= 0;
	ArrayList antibioticValues	= bean.getAntibioticDetails(chart_result_type);
	if (antibioticValues == null) antibioticValues = new ArrayList();

	HashMap parentMap 	=	bean.getCultureTestRecord();
	HashMap map			= new HashMap();
	//out.println("columnCounter "+columnCounter+"value");
	
	if (parentMap != null && parentMap.containsKey(line_index))
		map = (HashMap)parentMap.get(line_index);
	
	//out.println("@@@parentMap="+parentMap+"\n");
	//out.println("@@@map="+map);
	//out.println("\n");
	//for(int i=0;i<5;i++)
	//out.println("Details "+antibioticValues.contains(i)+"\n");
	
	
	

	
%>
<Form name='result_culture_test' id='result_culture_test' action='../../eOR/jsp/ResultEntryCultureTestPreview.jsp'>
	<Input name='antibiotic_length' id='antibiotic_length' type='hidden' value='<%=antibioticValues.size()%>'>
    <Input name='organism_string' id='organism_string' type='hidden' value='<%=organism_string%>'>
    <Input name='chart_no_columns' id='chart_no_columns' type='hidden' value='<%=chart_no_columns%>'>
	<Table>
		<TR>
			<td class='ORCOLUMNHEADING'><B><Font COLOR='WHITE'><%=horizontalHeading%>\<%=verticalHeading%></Font></B></TD>
			<%for (int i = 0; i < chart_no_columns; i++) {%>
				<TD class='label'><Select name='organism<%=i%>' id='organism<%=i%>' onChange='organismClick(this)' <%=((!((map.containsKey("organism"+i))?(String)map.get("organism"+i):"").equals("")) || (i == 0))?"":"disabled"%>><Option value=''> ---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---  </Option>
				<% //organismDetails = null;
				if (organismDetails != null) {
					for (int j=0; j < organismDetails.size(); j++) {
						String [] record = (String[])organismDetails.get(j);%>
						<option value='<%=record[1]%>' <%=eHISFormatter.select((map.containsKey("organism"+i) || record[2].equals(""+(i+1)))?((map.containsKey("organism"+i))?(String)map.get("organism"+i):record[1]):"",record[1])%>><%=record[0]%></option>
					<%}
				}
				%>
				</Select><Input name='column_type<%=i%>' id='column_type<%=i%>' type='hidden' value=''></TD>

			<%}%>
		</tr>
		<%--<Script>alert('<%=antibioticValues.size()%>')</Script>--%>
		<%	int columnCounter			= 0;
				for (int i=0;i < antibioticValues.size();i++) {
	

			String record [] 			= (String[])antibioticValues.get(i);
			String discr_msr_id			= bean.checkForNull(record[3]);			
			String result_type			= bean.checkForNull(record[4]);

			String copy_prev_vert_yn	= bean.checkForNull(record[5]);
			String unitofmeasure	= bean.checkForNull(record[9]);
			String maximumvalue	= bean.checkForNull(record[6]);
			String minimumvalue	= bean.checkForNull(record[7]);
			if(maximumvalue.equals(""))
				maximumvalue="1";
			if(minimumvalue.equals(""))
				minimumvalue="1";
			
			//out.println("max length ="+maximumvalue);

			//out.println("min length ="+minimumvalue);
			String defValue=bean.checkForNull(record[10]);
			String minweight=bean.checkForNull(record[11]);
			if(minweight.equals(""))
				minweight="0";
			String maxweight=bean.checkForNull(record[12]);
			if(maxweight.equals(""))
				maxweight="0";

//			out.println("minweight"+minweight+"value");
//			out.println("maxweight"+maxweight+"value");
			
			//out.println("maximumvalue"+maximumvalue);
			

			//out.println("@@@discr_msr_id="+discr_msr_id);
			//out.println("@@@result_type="+result_type);
			//out.println("@@@copy_prev_vert_yn="+copy_prev_vert_yn);
		%>
			<TR>
<% 

			%>
			<%if (discr_msr_id.equals("")) {//out.println("<script>alert('"+columnCounter+"')</script>");
			
			%>
				<TD class='ORCHARTHEADING'><B><Font size='1' color='WHITE'><%=record[0]%></Font></B><Input name='antibiotic<%=columnCounter%>' id='antibiotic<%=columnCounter%>' type='hidden' value='<%=record[1]%>'><Input name='maximum<%=columnCounter%>' id='maximum<%=columnCounter%>' type='hidden' value='<%=maximumvalue%>'><Input name='antibiotic_desc<%=columnCounter%>' id='antibiotic_desc<%=columnCounter%>' type='hidden' value='<%=record[0]%>'><Input name='discr_msr_id<%=columnCounter%>' id='discr_msr_id<%=columnCounter%>' type='hidden' value='<%=discr_msr_id%>'><Input name='result_type<%=columnCounter%>' id='result_type<%=columnCounter%>' type='hidden' value='<%=result_type%>'></TD>
			<%	prevIndx	= currIndx;
				currIndx	= i;
				if (discr_msr_id.equals("") && record[5].equals("N")) {

				%>
					<%for (int j=0;j < chart_no_columns; j++) {%>
						<TD class='ORCHARTHEADING' id='anti<%=columnCounter%><%=j%>_td'><Input name='anti<%=columnCounter%><%=j%>' id='anti<%=columnCounter%><%=j%>' type='hidden' value='' ></TD>
					<%}

				} else if (discr_msr_id.equals("") && record[5].equals("Y")) {
					for (int j=0;j < chart_no_columns; j++) {%>
						<TD class='ORCHARTHEADING' id='anti<%=columnCounter%><%=j%>_td'><Input name='anti<%=columnCounter%><%=j%>' id='anti<%=columnCounter%><%=j%>' type='hidden' value=''></TD>
					<%}
				}
			} else {			
				
					String check="";

				%>
			<TD class='ORROWHEADING'><%=record[0]%><Input name='antibiotic<%=columnCounter%>' id='antibiotic<%=columnCounter%>' type='hidden' value='<%=record[1]%>'><Input name='antibiotic_desc<%=columnCounter%>' id='antibiotic_desc<%=columnCounter%>' type='hidden' value='<%=record[0]%>'><Input name='discr_msr_id<%=columnCounter%>' id='discr_msr_id<%=columnCounter%>' type='hidden' value='<%=discr_msr_id%>'><Input name='result_type<%=columnCounter%>' id='result_type<%=columnCounter%>' type='hidden' value='<%=result_type%>'><Input name='maximum<%=columnCounter%>' id='maximum<%=columnCounter%>' type='hidden' value='<%=maximumvalue%>'></TD>

				<%for (int j=0;j < chart_no_columns; j++) {//out.println("Result Type ="+result_type);%>
				
					<TD class='label' id='anti<%=columnCounter%><%=j%>_td'>
					<%  boolean default_value = false;
				if (result_type.equals("I")) {
					if(maximumvalue=="")
						maximumvalue="1";
					//String num_digits_max=bean.checkForNull(record[6]);
					//out.println("defaultvalue "+defValue.length()+" "+maximumvalue);
					int defValueLen=defValue.length();
					if(Integer.parseInt(maximumvalue)<defValueLen)
						defValue="";
					//else
					//	defValue=defValue;
										
					%>
					
					<input type='text' name='anti<%=columnCounter%><%=j%>' id='anti<%=columnCounter%><%=j%>' value='<%=defValue%>' size='5' class='NUMBER'  onkeypress='return isNumberKey(event)'onblur='allowValidInteger(this,<%=minimumvalue%>,<%=maximumvalue%>,<%=minweight%>,<%=maxweight%>);antibioticClick(this)'  maxlength='<%=maximumvalue%>'><%=unitofmeasure%><input type='hidden' name='unitofmeasure<%=columnCounter%><%=j%>' id='unitofmeasure<%=columnCounter%><%=j%>' value='<%=unitofmeasure%>'> 
				<%}
				if (result_type.equals("H")) {
					%>
					<input type='text' name='anti<%=columnCounter%><%=j%>' id='anti<%=columnCounter%><%=j%>' value='<%=(map.containsKey(columnCounter+""+j))?((String)map.get(columnCounter+""+j)):""%>' size='5' class='NUMBER'  onblur='antibioticClick(this)'  maxlength='7'>
			<%	}

						if (result_type.equals("N")) {
						
							int maxlength = 1;
							if(record[7]==null || record[7].trim().equals(""))
								record[7]="0";
							if(record[6]==null || record[6].trim().equals(""))
								//record[6] = "0";//IN064122
								record[6] = "20";//IN064122
							if(record[8]==null || record[8].equals("") || record[8].equals("0")) {
								maxlength = Integer.parseInt(record[6]);
								record[8] = "0";
							} //else {
								//maxlength = Integer.parseInt(record[8]) + Integer.parseInt(record[8]) + 1;
							//}
							if(record[6]!=null || record[8]!=null)
							maxlength=Integer.parseInt(record[6])+Integer.parseInt(record[8])+1;
							
							String[] record1 = new String[8];
							record1 = bean.getNumericResultTypeDetails(discr_msr_id,sex,dob);

							for(int indx=0; indx<record1.length; indx++)
								if(record1[indx]== null) record1[indx]="";
							
							double max_val	= 0;
							double min_val	= 0;
							if (!record1[2].equals("")) max_val	= Double.parseDouble(record1[2]);
							if (!record1[1].equals("")) min_val	= Double.parseDouble(record1[1]);
							String num_digits_dec=bean.checkForNull(record[8]);
							String num_digits_min=bean.checkForNull(record[7]);
							//out.println("&&&&&"+num_digits_min+"########");
							/*if((num_digits_min.equals("")))
								num_digits_min="1";*/
							String num_digits_max=bean.checkForNull(record[6]);
							//out.println(num_digits_max);
							//String anti="anti"+columnCounter+j;
							/*if(!(java.util.regex.Pattern.compile("^(\\d{"+num_digits_min+"," + num_digits_max + "}(\\.\\d{"+num_digits_min+"," + num_digits_dec + "}))+|(\\d{1," + num_digits_max + "}(\\.\\d{0," + num_digits_dec + "})?)$").matcher(defValue).matches()))
							{
							out.println("Not true");
							defValue="";
							}*/

							%>
						<input type='hidden' name='num_digits_dec_<%=columnCounter%><%=j%>' id='num_digits_dec_<%=columnCounter%><%=j%>'
						value='<%=num_digits_dec%>'/>
						
						
						<input type='hidden' name='num_digits_min_<%=columnCounter%><%=j%>' id='num_digits_min_<%=columnCounter%><%=j%>'
						value='<%=num_digits_min%>'/>


						<input type='hidden' name='num_digits_max_<%=columnCounter%><%=j%>' id='num_digits_max_<%=columnCounter%><%=j%>'
						value='<%=num_digits_max%>'/>
<%//out.println("columnCounter"+columnCounter);
%>
					<!--<input type='text' name='anti<%=columnCounter%><%=j%>' id='anti<%=columnCounter%><%=j%>' value='<%=defValue%>' size='5' class='NUMBER' onblur='checkNumericResultMatrix(<%=columnCounter%>,<%=j%>,"<%=record[0]%>");checkRange(this,<%=minweight%>,<%=maxweight%>);antibioticClick(this);' maxlength='<%=maxlength%>' onKeyPress='return checkValid(this,window.event,<%=record[6]%>,<%=record[8]%>)'><%=record1[0]%><%=(max_val != 0.0 && min_val !=0.0)?"("+min_val+"-"+max_val+")":""%>--><input type='text' name='anti<%=columnCounter%><%=j%>' id='anti<%=columnCounter%><%=j%>' value='<%=defValue%>' size='5' class='NUMBER' onblur='checkNumericResultMatrix(<%=columnCounter%>,<%=j%>,"<%=record[0]%>");checkRange(this,<%=minweight%>,<%=maxweight%>);antibioticClick(this);' maxlength='<%=maxlength%>' onKeyPress='return checkValid(this,window.event,<%=maxlength%>,<%=record[8]%>)'><%=record1[0]%><%=(max_val != 0.0 && min_val !=0.0)?"("+min_val+"-"+max_val+")":""%><!--IN064122--><input type='hidden' name='num_uom<%=columnCounter%><%=j%>' id='num_uom<%=columnCounter%><%=j%>' value='<%=record1[0]%>'>
						<%} else if (result_type.equals("L")) {%>
							<select name='anti<%=columnCounter%><%=j%>' id='anti<%=columnCounter%><%=j%>'  onChange='antibioticClick(this)' >
						<%	ArrayList listItems = bean.getListResultTypeDetails(discr_msr_id);
						
							//String option_string	= "";
							int selectedCount		= 0;
							%>
							<option value=''>-- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --</option>
							<%if(listItems!=null) {
								for(int k=0; k<listItems.size(); k++) {
									String[] listValues = new String[4];
									listValues = (String[])listItems.get(k);
									if(listValues[1]!=null && listValues[1].equalsIgnoreCase("Y")) {
										default_value = true;%>
										<option value='<%=listValues[2]%>' selected><%=listValues[0]%></option>
									<%	selectedCount++;
									} else if (map.containsKey(columnCounter+""+j) && ((String)map.get(columnCounter+""+j)).equals(listValues[2])) {
										default_value = true;%>
										<option value='<%=listValues[2]%>' selected><%=listValues[0]%></option>
									<%	selectedCount++;
									} else {%>
										<option value='<%=listValues[2]%>'><%=listValues[0]%></option>
									<%}
								}
							}%>
							</Select>
						<%} else if (result_type.equals("D")) {%>
							<input type='text' name='anti<%=columnCounter%><%=j%>' id='anti<%=columnCounter%><%=j%>' value='<%=(map.containsKey(columnCounter+""+j))?((String)map.get(columnCounter+""+j)):""%>' onBlur='chckDate(this,"anti<%=columnCounter%><%=j%>");antibioticClick(this)'><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('anti<%=columnCounter%><%=j%>');" style='cursor:pointer'>
						<%} else if (result_type.equals("E")) {%>
							<input type='text' name='anti<%=columnCounter%><%=j%>' id='anti<%=columnCounter%><%=j%>' value='<%=(map.containsKey(columnCounter+""+j))?((String)map.get(columnCounter+""+j)):""%>'  onBlur='validDateObj(this,"DMYHM","<%=localeName%>");antibioticClick(this)'><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('anti<%=columnCounter%><%=j%>',null,'hh:mm');" style='cursor:pointer'>
						<%} else if (result_type.equals("T")) {%>
							<input type='text' name='anti<%=columnCounter%><%=j%>' id='anti<%=columnCounter%><%=j%>' value='<%=(map.containsKey(columnCounter+""+j))?((String)map.get(columnCounter+""+j)):""%>' onKeyPress=''  onBlur='if(this.value!=""){checkChartTemplateTime(this)};antibioticClick(this);'>
						<%} else if (result_type.equals("C")) {
							String temp=(map.containsKey(columnCounter+""+j))?((String)map.get(columnCounter+""+j)):"";						
							if(temp.equals("Y"))
							{	check="checked";}
							else
							{	check="";}
							
							%>
							<input type='checkbox' name='anti<%=columnCounter%><%=j%>' id='anti<%=columnCounter%><%=j%>' value='<%=temp%>'  <%=check%> onClick='checkClick(this);antibioticClick(this)'>
						<%}
					%>
				<%	if ((((!((map.containsKey("organism"+j))?(String)map.get("organism"+j):"").equals("")) || (j == 0)) && ((map.containsKey(columnCounter+""+j)) && map.get(columnCounter+""+j) != null && (!((String)map.get(columnCounter+""+j)).equals("") ))) || default_value){%>
	    			<Script>
						if (<%=j+1%> < <%=chart_no_columns%>) {
							eval("document.result_culture_test.organism"+<%=j+1%>).disabled = false;
						}
					</Script>
					<%}

				}
			}
			columnCounter++;
			%>
			</TR>
		<% 	if (copy_prev_vert_yn.equals("Y")) {
				
				for(int rowIndx = prevIndx; rowIndx < currIndx; rowIndx++) {
					String tempRecord [] 		= (String[])antibioticValues.get(rowIndx);
					String tempDiscr_msr_id			= bean.checkForNull(tempRecord[3]);
					String tempResult_type			= bean.checkForNull(tempRecord[4]);
					//String tempCopy_prev_vert_yn	= bean.checkForNull(tempRecord[5]);
					//out.println("TempDiscr_msr_id"+tempDiscr_msr_id);
					%>
					<TR>
						<%if (tempDiscr_msr_id.equals("")) {%>
						<%} else {%>
							<TD class='ORROWHEADING'><%=tempRecord[0]%><Input name='antibiotic<%=columnCounter%>' id='antibiotic<%=columnCounter%>' type='hidden' value='<%=tempRecord[1]%>'><Input name='antibiotic_desc<%=columnCounter%>' id='antibiotic_desc<%=columnCounter%>' type='hidden' value='<%=tempRecord[0]%>'><Input name='discr_msr_id<%=columnCounter%>' id='discr_msr_id<%=columnCounter%>' type='hidden' value='<%=tempDiscr_msr_id%>'><Input name='result_type<%=columnCounter%>' id='result_type<%=columnCounter%>' type='hidden' value='<%=tempResult_type%>'></TD>
							<%for (int j=0;j < chart_no_columns; j++) {%>
								<TD class='label' id='anti<%=columnCounter%><%=j%>_td'>
								<%  boolean default_value = false;
									if (tempResult_type.equals("N")) {
                                        int maxlength = 1;
										if(tempRecord[6]==null || tempRecord[6].trim().equals(""))
											tempRecord[6] = "0";
										if(tempRecord[8].equals("") || tempRecord[8].equals("0")) {
											maxlength = Integer.parseInt(tempRecord[6]);
											tempRecord[8] = "0";
										} else {
											maxlength = Integer.parseInt(tempRecord[8]) + Integer.parseInt(tempRecord[8]) + 1;
										}

										String[] record1 = new String[8];
										record1 = bean.getNumericResultTypeDetails(tempDiscr_msr_id,sex,dob);

										for(int indx=0; indx<record1.length; indx++)
											if(record1[indx]== null) record1[indx]="";

										double max_val	= 0;
										double min_val	= 0;
										if (!record1[2].equals("")) max_val	= Double.parseDouble(record1[2]);
										if (!record1[1].equals("")) min_val	= Double.parseDouble(record1[1]);
									%>
										<input type='text' name='anti<%=columnCounter%><%=j%>' id='anti<%=columnCounter%><%=j%>' value='<%=(map.containsKey(columnCounter+""+j))?((String)map.get(columnCounter+""+j)):""%>' size='5' class='NUMBER' onblur='antibioticClick(this)' maxlength='<%=maxlength%>'  onKeyPress='return checkValid(this,window.event,<%=tempRecord[6]%>,<%=tempRecord[8]%>)'><%=record1[0]%><%=(max_val != 0.0 && min_val !=0.0)?"("+min_val+"-"+max_val+")":""%><input type='hidden' name='num_uom<%=columnCounter%><%=j%>' id='num_uom<%=columnCounter%><%=j%>' value='<%=record1[0]%>'>
									<%} else if (tempResult_type.equals("L")) {%>
										<select name='anti<%=columnCounter%><%=j%>' id='anti<%=columnCounter%><%=j%>'  onChange='antibioticClick(this)' >
									<%	ArrayList listItems = bean.getListResultTypeDetails(tempDiscr_msr_id);

										//String option_string	= "";
										int selectedCount		= 0;
										//out.println("<select name='result_"+i+"' id='result_"+i+"' onchange='onListChange("+i+")' "+disabled+" "+disabled1+">");%>
										<option value=''>-- Select --</option>
										<%if(listItems!=null) {
											for(int k=0; k<listItems.size(); k++) {
												String[] listValues = new String[4];
												listValues = (String[])listItems.get(k);
												if (map.containsKey(columnCounter+""+j) && ((String)map.get(columnCounter+""+j)).equals(listValues[2])) {
													default_value = true;%>
													<option value='<%=listValues[2]%>' selected><%=listValues[0]%></option>
												<%	selectedCount++;
												}else if((map.containsKey(columnCounter+""+j) && ((String)map.get(columnCounter+""+j)).equals("")) && (listValues[1]!=null && listValues[1].equalsIgnoreCase("Y"))) {
													default_value = true;%>
													<option value='<%=listValues[2]%>' selected><%=listValues[0]%></option>
												<%	selectedCount++;
												} else {%>
													<option value='<%=listValues[2]%>'><%=listValues[0]%></option>
												<%}
											}
										}%>
										</Select>
									<%} else if (tempResult_type.equals("D")) {%>
										<input type='text' name='anti<%=columnCounter%><%=j%>' id='anti<%=columnCounter%><%=j%>' value='<%=(map.containsKey(columnCounter+""+j))?((String)map.get(columnCounter+""+j)):""%>' onBlur='antibioticClick(this)'><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('anti<%=columnCounter%><%=j%>');" style='cursor:pointer'>
									<%} else if (tempResult_type.equals("E")) {%>
										<input type='text' name='anti<%=columnCounter%><%=j%>' id='anti<%=columnCounter%><%=j%>' value='<%=(map.containsKey(columnCounter+""+j))?((String)map.get(columnCounter+""+j)):""%>' onBlur='antibioticClick(this)'><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('anti<%=columnCounter%><%=j%>');" style='cursor:pointer'>
									<%} else if (tempResult_type.equals("T")) {%>
										<input type='text' name='anti<%=columnCounter%><%=j%>' id='anti<%=columnCounter%><%=j%>' value='<%=(map.containsKey(columnCounter+""+j))?((String)map.get(columnCounter+""+j)):""%>' onKeyPress='enterCheck()' onBlur='if(this.value!=""){checkChartTemplateTime(this)};antibioticClick(this);'>
									<%} else if (tempResult_type.equals("C")) {%>
										<input type='checkbox' name='anti<%=columnCounter%><%=j%>' id='anti<%=columnCounter%><%=j%>' value='<%=(map.containsKey(columnCounter+""+j))?((String)map.get(columnCounter+""+j)):""%>' onClick='antibioticClick(this)'>
									<%}
								%>
								</TD>
							<%	if ((((!((map.containsKey("organism"+j))?(String)map.get("organism"+j):"").equals("")) || (j == 0)) && ((map.containsKey(columnCounter+""+j)) && map.get(columnCounter+""+j) != null && (!((String)map.get(columnCounter+""+j)).equals("") ))) || default_value){%>
				    			<Script>
									if (<%=j+1%> < <%=chart_no_columns%>) {
										eval("document.result_culture_test.organism"+<%=j+1%>).disabled = false;
									}
								</Script>
								<%}
							}%>
						<%	columnCounter++;
						}%>
					</TR>
				<%}
			}
		}%>
	</Table>
	<Script>
		document.result_culture_test.antibiotic_length.value = '<%=columnCounter%>';
		//alert(document.result_culture_test.antibiotic_length.value);
	</Script>
	<%for (int i = 0; i < chart_no_columns; i++) {
		if ((map.containsKey("organism"+i)) && (!((String)map.get("organism"+i)).equals(""))) {%>
			<Script>
				organismClick(document.result_culture_test.organism<%=i%>);
			</Script>
		<%}
	}
	for (int i=0;i < antibioticValues.size();i++) {
		for (int j=0;j < chart_no_columns; j++) {
   			if (map.containsKey(i+""+j)) {
   				if (map.get(i+""+j) != null) {
   					
					   %>
   					<Script>document.result_culture_test.anti<%=i%><%=j%>.value = '<%=(String)map.get(i+""+j)%>'</Script>
   				<%}
   			}
		}
	}
	%>
	<%--<Input name='antibiotic_organism_reqd_yn' id='antibiotic_organism_reqd_yn' type='hidden' value='<%=antibiotic_organism_reqd_yn%>'>
	<Input name='remarks' id='remarks' type='hidden' value='<%=remarks%>'>
	<Input name='index' id='index' type='hidden' value='<%=index%>'>--%>
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">

</Form>
</BODY>
</HTML>
<%
putObjectInBean(bean_id,bean,request);
}catch(Exception e){
	//out.println("====exception====="+e.toString());//COMMON-ICN-0181
	e.printStackTrace();
}
%>

