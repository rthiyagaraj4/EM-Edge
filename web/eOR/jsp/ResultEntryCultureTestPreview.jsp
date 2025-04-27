<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import="eOR.ResultEntryBean" %>
    <TITLE><fmt:message key="Common.Preview.label" bundle="${common_labels}"/></TITLE>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>

 	<script language="JavaScript" src="../js/ResultEntry.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 	<Style> </Style>
</HEAD>
<BODY OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<%
	String bean_id = "Or_ResultEntry" ;
	String bean_name = "eOR.ResultEntryBean";
	String index	= request.getParameter("index");
	String chart_result_type	= request.getParameter("chart_result_type");
	if (index == null) index = "0";
	if (chart_result_type == null) chart_result_type = "";
	int colCount = 0;
	//ResultEntryBean bean = (ResultEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	ResultEntryBean bean = (ResultEntryBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

    //HashMap parentMap 	=	bean.getCultureTestRecord();
	HashMap map			= new HashMap();
	HashMap descMap		= new HashMap();

	//if (parentMap != null && parentMap.containsKey(index))
		map = bean.getPreviewCultureTestRecord();

	//ArrayList organismDetails	= bean.getOrganismDetails();
	ArrayList antibioticValues	= bean.getAntibioticDetails(chart_result_type);

	//if (organismDetails == null) organismDetails = new ArrayList();
	if (antibioticValues == null) antibioticValues = new ArrayList();	
	StringBuffer previewText = new StringBuffer();	
	if (map.containsKey("chart_no_columns") && (!((String)map.get("chart_no_columns")).equals(""))) {
		colCount = Integer.parseInt((String)map.get("chart_no_columns"));		
	}    
	if (map.containsKey("remarks") && (!((String)map.get("remarks")).equals(""))) {

		previewText.append("Remarks: " + (String)map.get("remarks") + "\n\n");
	}

	if (map.containsKey("antibiotic_organism_reqd_yn") && (((String)map.get("antibiotic_organism_reqd_yn")).equals("Y"))) {		

			previewText.append("\n"+(String)map.get("vertical_heading")+": ");//+"     \t"
			
			int count = 0;

			for(int i = 0; i < colCount; i++) {
				//out.println("<script>alert('"+(map.get("organism"+i))+"')</script>");
				if (!((map.containsKey("organism"+i)) && ((String)map.get("organism"+i)).equals(""))) {
					if (i % 3 == 0) {
						if (i != 0) {
							//previewText += "\n";

							for (int indx = 0; indx < (((String)map.get("horizontal_heading")).length() + 2); indx++) {
								//previewText.append(" ");
							}
						}

					}
					String organismDesc = bean.getOrganismDesc((String)map.get("organism"+i),chart_result_type);
					//String tempOrganism	= (String)map.get("organism"+i);
					previewText.append(i+1 + "=" + organismDesc.trim() + " ,");
					count++;
				}

			}
			//previewText.append(previewText.substring(0,(previewText.length()-1)));
			String tempPreviewText="";
			tempPreviewText=previewText.toString();
			previewText.setLength(0);
			previewText.append(tempPreviewText.substring(0,(tempPreviewText.length()-1)));
			int largelengths=0;
			int maxLength = 0;
			

			String antibiotic_length 	= (String)map.get("antibiotic_length") ;
			int anti_length				= Integer.parseInt(antibiotic_length);
			
			int[] anti_lengths=new int[anti_length];
			for(int i = 0; i < anti_length; i++) {
				if (map.containsKey("antibiotic" + i)) {
					for (int j = 0; j < count; j++) {
						if (map.containsKey("result_type"+i)) {
							int tempMaxLength	= 0;
							
							if (((String)map.get("result_type"+i)).equals("L")) {
								tempMaxLength	= 12;//6
							} else if (((String)map.get("result_type"+i)).equals("N")) {
								tempMaxLength	= 17;
							} else if (((String)map.get("result_type"+i)).equals("D")) {
								tempMaxLength	= 12;
							} else if (((String)map.get("result_type"+i)).equals("E")) {
								tempMaxLength	= 18;
							} else if (((String)map.get("result_type"+i)).equals("T")) {
								tempMaxLength	= 7;
							} else if (((String)map.get("result_type"+i)).equals("C")) {
								tempMaxLength	= 3;
							}
							if (tempMaxLength > maxLength) {
								maxLength = tempMaxLength;
							}							
						}
					}
				}
			}
			String tempmaximum="";
			int tempmaximumlength=0;
				for(int i = 0; i < anti_length; i++) {
				 if (map.containsKey("antibiotic" + i)) {					
					if (map.containsKey("result_type"+i)) {
						int tempMaxLength	= 0;
						if (map.containsKey("maximum"+i)) {
						tempmaximum=(String)map.get("maximum"+i) ;
							if (tempmaximum.equals(""))
							 tempmaximumlength=0;
							else
							tempmaximumlength=Integer.parseInt(tempmaximum);						
						}
						if (((String)map.get("result_type"+i)).equals("L")) {
								tempMaxLength	= 12;//6
							} else if (((String)map.get("result_type"+i)).equals("N")) {
								if(tempmaximumlength==0)
									tempMaxLength	= 21;
								else
									tempMaxLength	= tempmaximumlength;
							} else if (((String)map.get("result_type"+i)).equals("D")) {
								tempMaxLength	= 12;
							} else if (((String)map.get("result_type"+i)).equals("E")) {
								tempMaxLength	= 18;
							} else if (((String)map.get("result_type"+i)).equals("T")) {
								tempMaxLength	= 7;
							} else if (((String)map.get("result_type"+i)).equals("C")) {
								tempMaxLength	= 3;
							}else if (((String)map.get("result_type"+i)).equals("I")) {
								if(tempmaximumlength==0)
									tempMaxLength	= 20;
								else
									tempMaxLength	= tempmaximumlength;
							}
							anti_lengths[i]=tempMaxLength;						
					}
				 }
				}
				for(int i = 0; i < anti_lengths.length; i++) {						
						 if(anti_lengths[i]>largelengths)
						 {
						   largelengths=anti_lengths[i];						   
						 }
				}
						
			
			
		previewText.append("\n\n---------------------------");
			
			for (int i = 0; i < colCount; i++) {
				for (int j = 0; j < maxLength; j++) {
					previewText.append("-");
				}
				//previewText += "----------------";
			}
			//................................................Colum...................................
			%>
			<%!int tempLength=0;
			int tempLengthNew=0;
			int tempVertLength = 0;
			int tempVertLengthNew = 0;
			int tempVertLengthNew1 = 0;
			%>
			<%
			int firstlable=((String)map.get("horizontal_heading")).length();			
						
			int tempAntBlenght=0;
			int largelable=0;
			int largelableNew=0;
			int[] a=new int[anti_length];	   
			for(int i = 0; i < anti_length; i++) {
			if (map.containsKey("antibiotic" + i)) {				
				String tempAntiBiotic = (String)map.get("antibiotic_desc" + i);
				 a[i]=tempAntiBiotic.length();					
				 tempAntBlenght=tempAntiBiotic.length();								
				}
			}	  
		 for (int i=0;i<a.length;i++){			 
			 if(a[i]>largelable)
			 {
			   largelable=a[i];
			}
		}		
		
		if(firstlable>largelable){				
				tempLength=2+firstlable+(firstlable-largelable);
				tempVertLength=1+firstlable;	
				tempVertLengthNew=1+(firstlable-largelable);
		}
		
		else{
			tempVertLength=2+tempAntBlenght+(largelable-firstlable);
			tempLength=2+tempAntBlenght+(largelable-firstlable);
				tempVertLengthNew=1+(largelable-firstlable);	
			
		}
		
			

		//---------------------------
			previewText.append("\n"+(String)map.get("horizontal_heading"));
			//previewText += "\n"+(String)map.get("vertical_heading")+"     \t";
			//previewText += "\n"+(String)map.get("vertical_heading");//+"     \t"
			//int firstlable=((String)map.get("horizontal_heading")).length();
			
			//int tempVertLength = 16 - ((String)map.get("vertical_heading")).length();
			//if(firstlable<largeHeader)
			//	tempVertLength=tempVertLength-1;//+(tempAntBlenght-firstlable);
			//int tempVertLength = maxLength-((String)map.get("vertical_heading")).length();

			/*for (int i = 0; i < tempVertLength; i++) {
				previewText.append(" ");
			}*/
			if(firstlable>largelable){
				previewText.append(" ");
			}else if(firstlable==largelable)
			{
				previewText.append(" ");
			}
			else
			{		
				for (int i = 0; i < tempVertLengthNew; i++) {
				previewText.append(" ");				
				}
			}		
			for (int i = 0; i < count; i++) {
				previewText.append((i+1));
				//int tempHeaderLength = maxLength - (Integer.toString(i+1)).length();
				int tempHeaderLengthspace = largelengths - (Integer.toString(i+1)).length();
							
				for (int j = 0; j < tempHeaderLengthspace+10; j++) {
					//previewText += "";
					previewText.append(" ");
				}//previewText.append("\t");
			}

			previewText.append("\n---------------------------");
			
			for (int i = 0; i < colCount; i++) {
				//previewText += "----------------";
				for (int j = 0; j < maxLength; j++) {
					previewText.append("-");
				}
			}
			previewText.append("\n");

			for(int i = 0; i < anti_length; i++) {
				if (map.containsKey("antibiotic" + i)) {
					//out.println("<script>alert('"+(((String)map.get("discr_msr_id"+i)))+"')</script>");
					String tempAntiBiotic = (String)map.get("antibiotic_desc" + i);
					
					boolean continueFlag = false;

					for (int j = 0; j < count; j++) {						
						if (map.containsKey(i+""+j)) {
							if ( (((String)map.get(i+""+j))!=null && (!((String)map.get(i+""+j)).equals(""))) || ((String)map.get("discr_msr_id"+i)).equals("")) {
								continueFlag = true;
								break;
							}
						}
					}

					if (continueFlag) {
						if ( i != 0 && ((String)map.get("discr_msr_id"+i)).equals("")) {
							previewText.append("---------------------------");
							for (int indx = 0; indx < colCount; indx++) {							
								for (int j = 0; j < maxLength; j++) {
									previewText.append("-");
								}
							}
							previewText.append("\n");
						}
						previewText.append(tempAntiBiotic);
						
						if(firstlable>largelable)
						{
							largelableNew=firstlable;
						}
						else
						{
							largelableNew=largelable;
						}
						
							if(a[i]>largelableNew)
							{
								tempVertLengthNew1=1+(a[i]-largelableNew);
							}
							else
							{
								tempVertLengthNew1=1+(largelableNew-a[i]);
							}
							
							for (int m=0;m<tempVertLengthNew1;m++){
								previewText.append(" ");
								}


						/*for (int in = 0; in < tempLength; in++) {
						//for (int in = 0; in < 22; in++) {
							previewText.append(" ");
						}*/
						//previewText.append("\t");
						for (int j = 0; j < count; j++) {
							if (map.containsKey(i+""+j)) {								
								tempAntiBiotic	= (String)map.get(i+""+j);
								int tempdataLengthspace=0;
								if(largelengths>((tempAntiBiotic).length()))
									tempdataLengthspace= largelengths - ((tempAntiBiotic).length());
								
								//tempLength = maxLength - tempAntiBiotic.length();
								//tempLength = tempLength;
								
								previewText.append(tempAntiBiotic);
								//out.println("type"+(String)map.get("result_type"+i)+"<br>");
								if (map.containsKey("result_type"+i) && ((String)map.get("result_type"+i)).equals("L")) {
									ArrayList resultTypeList = bean.getPreviewListResultTypeDetails((String)map.get("discr_msr_id"+i),tempAntiBiotic);
									
									if (resultTypeList != null && resultTypeList.size() > 0) {

										String [] strResultType		= (String[])resultTypeList.get(0);
										String antiBioticDesc		= strResultType[0];
										String antiDesc				= "";
										if(antiBioticDesc.length()>0)
											antiDesc				= antiBioticDesc.substring(0,1);
										if(antiDesc==null) antiDesc = "\t";
										//out.println("antiDesc"+antiDesc);
										previewText.append("("+antiDesc+")");
										descMap.put(tempAntiBiotic+antiDesc,antiBioticDesc);
										tempdataLengthspace= tempdataLengthspace - ((antiDesc.length()+2));
									}
									
								} else if (map.containsKey("result_type"+i) && ((String)map.get("result_type"+i)).equals("N")) {
									if ((!((String)map.get(i+""+j)).equals("")) && map.containsKey("num_uom"+i+""+j)) {
										previewText.append(" " + (String)map.get("num_uom"+i+""+j));
										//tempLength = maxLength - (tempAntiBiotic.length() + ((String)map.get("num_uom"+i+""+j)).length() + 1);
										tempdataLengthspace= tempdataLengthspace - (((" " + (String)map.get("num_uom"+i+""+j))).length());
									}
								}
								else if (map.containsKey("result_type"+i) && ((String)map.get("result_type"+i)).equals("I")) {
									if ((!((String)map.get(i+""+j)).equals("")) && map.containsKey("unitofmeasure"+i+""+j)) {
										previewText.append(" " + (String)map.get("unitofmeasure"+i+""+j));
										//tempLength = maxLength - (tempAntiBiotic.length() + ((String)map.get("num_uom"+i+""+j)).length() + 1);
										tempdataLengthspace= tempdataLengthspace - (((" " + (String)map.get("unitofmeasure"+i+""+j))).length());
									}
								}
								for (int in = 0; in < tempdataLengthspace+10; in++) {
									previewText.append(" ");
								}//previewText.append("\t");
							}
						}

						previewText.append("\n\n");
						if (((String)map.get("discr_msr_id"+i)).equals("")) {
							previewText.append("---------------------------");
							for (int indx = 0; indx < colCount; indx++) {
								//previewText += "----------------";
								for (int j = 0; j < maxLength; j++) {
									previewText.append("-");
								}
							}
							previewText.append("\n");
							
						}
					}
				}
			}

			previewText.append("\n---------------------------");
			for (int i = 0; i < colCount; i++) {
				//previewText += "----------------";
				for (int j = 0; j < maxLength; j++) {
					previewText.append("-");
				}
			}
			if (descMap.size() > 0) {
				//for(int i = 0; i < anti_length; i++) {
				//	descMap		= beanObj.getPreviewListResultTypeDetails((String)map.get("discr_msr_id"+i),descMap);
				//}
				Set set			= descMap.keySet();
				Iterator itr	= set.iterator();
				previewText.append("\n");
				int breakCounter = 0;
				while(itr.hasNext()) {
					String key	= (String)itr.next();
					String key_code = "";
					if(key!=null && key.length()>0) {
						 key_code  = key.substring(key.length()-1);
						if(key_code==null) key_code = "";
					   previewText.append(key.substring(0,key.length()-1)  + "("+ key_code +")" + "="+ (String)descMap.get(key) + ";");
					}
					if (breakCounter == 3) previewText.append("\n");
					breakCounter++;
				}
				//previewText += "\nS=Sensitive; R=Resistant; I=Intermediate;\nMR=Mild Resistant; MS=Mild Sensitive;\n S1=S+; S2=S++; S3=S+++;";
				previewText.append("\n---------------------------");
				for (int i = 0; i < colCount; i++) {
					//previewText += "----------------";
					for (int j = 0; j < maxLength; j++) {
						previewText.append("-");
					}
				} 
			}
		}
%>
<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
<TR> <TD class=fields>
<TextArea Cols='300' Name='result_text' Rows='25' readonly style="font-family:Courier new; "><%=previewText%></TextArea>
</TD>
</TR>
<!-- <TR><td  class='button'><INPUT TYPE="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' class='button' onClick='window.close()'></TD></TR> -->
</Table>
</BODY>
</HTML>

<%
		putObjectInBean(bean_id,bean,request);

%>

