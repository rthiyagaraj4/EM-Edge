<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@page  import="java.util.*, eOH.* ,eOH.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>


<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%

	request.setCharacterEncoding("UTF-8");
	String bean_id = request.getParameter( "bean_id" ) ;
	String validate = request.getParameter( "validate" ) ;
	String localeName=(String)session.getAttribute("LOCALE");
	
	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

	if ( validate == null || validate.equals( "" ) )
		return ;

	ResultEntryBean beanObj = (ResultEntryBean)getBeanObject( bean_id, "eOH.ResultEntryBean" , request) ;
	beanObj.setLanguageId(localeName);
	
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;
	if ( validate.equals( "SYNC_CULTURE_TEST" ) ) {
		String index				= (String)hash.get("index");
		HashMap map					= new HashMap();
		HashMap descMap				= new HashMap();

		int colCount = 0;
		/*map.put("antibiotic_organism_reqd_yn",(String)hash.get("antibiotic_organism_reqd_yn"));
		map.put("remarks",(String)hash.get("remarks"));
		String chart_result_type 	= (String)hash.get("chart_result_type") ;
		map.put("chart_result_type",chart_result_type);
		map.put("vertical_heading",(String)hash.get("vertical_heading"));
		map.put("horizontal_heading",(String)hash.get("horizontal_heading"));

		if (((String)hash.get("antibiotic_organism_reqd_yn")).equals("Y")) {

			String antibiotic_length 	= (String)hash.get("antibiotic_length") ;
			int anti_length				= Integer.parseInt(antibiotic_length);
			map.put("antibiotic_length",antibiotic_length);
			String chart_no_columns		= (String)hash.get("chart_no_columns");
			colCount					= Integer.parseInt(chart_no_columns);
			map.put("chart_no_columns",chart_no_columns);

			for(int i = 0; i < anti_length; i++) {
				map.put("antibiotic"+i,(String)hash.get("antibiotic"+i));
				map.put("antibiotic_desc"+i,(String)hash.get("antibiotic_desc"+i));
				map.put("discr_msr_id"+i,(hash.get("discr_msr_id"+i) != null)?(String)hash.get("discr_msr_id"+i):"");
				map.put("result_type"+i,(String)hash.get("result_type"+i));
				for (int j = 0; j < colCount; j++) {
					map.put(i+""+j,(String)hash.get("anti"+i+""+j));
				}
			}

			for(int i = 0; i < colCount; i++) {
				map.put("organism"+i,(String)hash.get("organism"+i));
			}

		}*/

		map.put("antibiotic_organism_reqd_yn",(String)hash.get("antibiotic_organism_reqd_yn"));
		map.put("remarks",(String)hash.get("remarks"));
		map.put("vertical_heading",(String)hash.get("vertical_heading"));
		map.put("horizontal_heading",(String)hash.get("horizontal_heading"));
		map.put("chart_result_type",(String)hash.get("chart_result_type"));
		String chart_result_type 	= (String)hash.get("chart_result_type") ;
		//map.put("chart_result_type",chart_result_type);

		if (((String)hash.get("antibiotic_organism_reqd_yn")).equals("Y")) {

			String antibiotic_length 	= (String)hash.get("antibiotic_length") ;
			map.put("antibiotic_length",antibiotic_length);
			String chart_no_columns		= (String)hash.get("chart_no_columns");
			map.put("chart_no_columns",chart_no_columns);
			int anti_length				= Integer.parseInt(antibiotic_length);
			colCount				= Integer.parseInt(chart_no_columns);


			for(int i = 0; i < anti_length; i++) {
				map.put("antibiotic"+i,(String)hash.get("antibiotic"+i));
				map.put("antibiotic_desc"+i,(String)hash.get("antibiotic_desc"+i));
				map.put("discr_msr_id"+i,(hash.get("discr_msr_id"+i) != null)?(String)hash.get("discr_msr_id"+i):"");
				map.put("result_type"+i,(String)hash.get("result_type"+i));
				for (int j = 0; j < colCount; j++) {
					map.put(i+""+j,(String)hash.get("anti"+i+""+j));
					if (((String)hash.get("result_type"+i)).equals("N")) {
						map.put("num_uom"+i+""+j,(String)hash.get("num_uom"+i+""+j));
					}
				}
			}

			for(int i = 0; i < colCount; i++) {
				map.put("organism"+i,(String)hash.get("organism"+i));
			}
		}

		HashMap parentMap			= beanObj.getCultureTestRecord();
		parentMap.put(""+index,map);

		beanObj.setCultureTestRecord(parentMap);



		

		ArrayList antibioticValues	= beanObj.getAntibioticDetails(chart_result_type);

		//if (organismDetails == null) organismDetails = new ArrayList();
		if (antibioticValues == null) antibioticValues = new ArrayList();
		//out.println("<script>alert('"+antibioticValues.size()+"')</script>");
		StringBuffer previewText = new StringBuffer();
		//out.println("<script>alert('"+(map.containsKey("chart_no_columns"))+"')</script>");
		if (map.containsKey("chart_no_columns") && (!((String)map.get("chart_no_columns")).equals(""))) {

			colCount = Integer.parseInt((String)map.get("chart_no_columns"));
		}
		//out.println("<script>alert('"+(map.containsKey("remarks"))+"')</script>");
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
								previewText.append(" ");
							}
						}

					}
					String organismDesc = beanObj.getOrganismDesc((String)map.get("organism"+i),chart_result_type);
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

			int maxLength = 0;

			String antibiotic_length 	= (String)map.get("antibiotic_length") ;
			int anti_length				= Integer.parseInt(antibiotic_length);

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
			previewText.append("\n\n---------------------------");
			for (int i = 0; i < colCount; i++) {
				for (int j = 0; j < maxLength; j++) {
					previewText.append("-");
				}
				//previewText += "----------------";
			}
			//...............................
			%>
			<%!int tempLength=0;%>
			<%
			int firstlable=((String)map.get("horizontal_heading")).length();			
			int tempVertLength = 0;			
			int tempAntBlenght=0;
			int largeHeader=0;
			int[] a=new int[anti_length];	   
			 for(int i = 0; i < anti_length; i++) {
			if (map.containsKey("antibiotic" + i)) {				
				String tempAntiBiotic = (String)map.get("antibiotic_desc" + i);
				 a[i]=tempAntiBiotic.length();	
				 tempAntBlenght=tempAntiBiotic.length();								
				}
			}	  
		 for (int i=0;i<a.length;i++){			 
			 if(a[i]>largeHeader)
			 {
			   largeHeader=a[i];
			}
		}		
		
		if(firstlable>largeHeader){				
				tempLength=2+firstlable+(firstlable-largeHeader);
				tempVertLength=2+firstlable;				
		}
		
		else{
			tempVertLength=2+tempAntBlenght+(largeHeader-firstlable);
			tempLength=2+tempAntBlenght;
		}
			


			//..............................
			previewText.append("\n"+(String)map.get("horizontal_heading")+"  ");
			//previewText += "\n"+(String)map.get("vertical_heading")+"     \t";
			//previewText += "\n"+(String)map.get("vertical_heading");//+"     \t"
			//int tempVertLength = 16 - ((String)map.get("vertical_heading")).length();
			for (int i = 0; i < tempVertLength; i++) {
				previewText.append(" ");
			}
			previewText.append("\t");

			for (int i = 0; i < count; i++) {
				previewText.append((i+1));
				int tempHeaderLength = maxLength - (Integer.toString(i+1)).length();
				for (int j = 0; j < tempHeaderLength; j++) {
				//	previewText += "";	
				}previewText.append("\t");
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
					//String [] record = (String[])antibioticValues.get(i);
					//if (record[1].equals(tempAntiBiotic))
					//	tempAntiBiotic			= record[0];
					//int tempLength = 16 - tempAntiBiotic.length();

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
								//previewText += "----------------";
								for (int j = 0; j < maxLength; j++) {
									previewText.append("-");
								}
							}
							previewText.append("\n");
						}
						previewText.append(tempAntiBiotic);
						for (int in = 0; in < tempLength; in++) {
							previewText.append(" ");
						}
						previewText.append("\t");
						for (int j = 0; j < count; j++) {
							if (map.containsKey(i+""+j)) {
								tempAntiBiotic	= (String)map.get(i+""+j);
								//tempLength = maxLength - tempAntiBiotic.length();
								previewText.append(tempAntiBiotic);

								if (map.containsKey("result_type"+i) && ((String)map.get("result_type"+i)).equals("L")) {
									ArrayList resultTypeList = beanObj.getPreviewListResultTypeDetails((String)map.get("discr_msr_id"+i),tempAntiBiotic);
									
									if (resultTypeList != null && resultTypeList.size() > 0) {

										String [] strResultType		= (String[])resultTypeList.get(0);
										String antiBioticDesc		= strResultType[0];
										String antiDesc				= "";
										if(antiBioticDesc.length()>0)
											antiDesc				= antiBioticDesc.substring(0,1);
										if(antiDesc==null) antiDesc = "\t";

										previewText.append("("+antiDesc+")");
										descMap.put(tempAntiBiotic+antiDesc,antiBioticDesc);
									}
								} else if (map.containsKey("result_type"+i) && ((String)map.get("result_type"+i)).equals("N")) {
									if ((!((String)map.get(i+""+j)).equals("")) && map.containsKey("num_uom"+i+""+j)) {
										previewText.append(" " + (String)map.get("num_uom"+i+""+j));
										//tempLength = maxLength - (tempAntiBiotic.length() + ((String)map.get("num_uom"+i+""+j)).length() + 1);
									}
								}
								for (int in = 0; in < tempLength; in++) {
									//previewText += "";
								}previewText.append("\t");
							}
						}

						previewText.append("\n");
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

		//boolean check = beanObj.setResultData(index, previewText);
		beanObj.setResultData(index, previewText.toString());

		out.println("previewText="+previewText.toString());

	} else if ( validate.equals( "PREVIEW_CULTURE_TEST" ) ) {
		//String index				= (String)hash.get("index");
		HashMap map					= new HashMap();
		map.put("antibiotic_organism_reqd_yn",(String)hash.get("antibiotic_organism_reqd_yn"));
		map.put("remarks",(String)hash.get("remarks"));
		map.put("vertical_heading",(String)hash.get("vertical_heading"));
		map.put("horizontal_heading",(String)hash.get("horizontal_heading"));
		map.put("chart_result_type",(String)hash.get("chart_result_type"));

		if (((String)hash.get("antibiotic_organism_reqd_yn")).equals("Y")) {

			String antibiotic_length 	= (String)hash.get("antibiotic_length") ;
			map.put("antibiotic_length",antibiotic_length);
			String chart_no_columns		= (String)hash.get("chart_no_columns");
			map.put("chart_no_columns",chart_no_columns);
			int anti_length				= Integer.parseInt(antibiotic_length);
			int colCount				= Integer.parseInt(chart_no_columns);


			for(int i = 0; i < anti_length; i++) {
				map.put("antibiotic"+i,(String)hash.get("antibiotic"+i));
				map.put("antibiotic_desc"+i,(String)hash.get("antibiotic_desc"+i));
				map.put("discr_msr_id"+i,(hash.get("discr_msr_id"+i) != null)?(String)hash.get("discr_msr_id"+i):"");
				map.put("result_type"+i,(String)hash.get("result_type"+i));
				for (int j = 0; j < colCount; j++) {
					map.put(i+""+j,(String)hash.get("anti"+i+""+j));
					if (((String)hash.get("result_type"+i)).equals("N")) {
						map.put("num_uom"+i+""+j,(String)hash.get("num_uom"+i+""+j));
					}
				}
			}

			for(int i = 0; i < colCount; i++) {
				map.put("organism"+i,(String)hash.get("organism"+i));
			}
		}

		beanObj.setPreviewCultureTestRecord(map);
		//out.println("alert('"+(((String)map.get("antibiotic_organism_reqd_yn")).equals("Y"))+"')");
	} else if ( validate.equals( "LOAD_ORGANISM_VALUES" ) ) {
		String organism_string = (String)hash.get("organism_string") ;
		String index = (String)hash.get("index") ;
		out.println( "clearList('document','"+index+"') ; " ) ;

		ArrayList organismDetails = beanObj.getOrganismDetails(organism_string) ;
		for( int i=0 ; i< organismDetails.size() ; i++ ) {
			String[] record = (String[])organismDetails.get(i);
			out.println( "addOrganismList(\"" + record[1] + "\",\"" + record[0] + "\",\"" + index + "\") ; " ) ;
		}
	}  else if ( validate.equals( "LOAD_ANTIBIOTIC_VALUES" ) ) {
		String organism_id 			= (String)hash.get("organism_id") ;
		String orgIndex				= (String)hash.get("orgIndex");
		String antibiotic_length	= (String)hash.get("antibiotic_length");
		if (antibiotic_length == null) antibiotic_length = "0";
		int columnIndex				= Integer.parseInt(antibiotic_length);

		//String chart_result_type 	= "";
		String discr_msr_id			= "";
		String result_type			= "";

		ArrayList organismDiscreteDetails	= beanObj.getOrganismDiscreteDetails(organism_id);

		if (organismDiscreteDetails != null && organismDiscreteDetails.size() > 0) {
			String [] record	= (String[])organismDiscreteDetails.get(0);
			//chart_result_type	= beanObj.checkForNull(record[0]);
			discr_msr_id		= beanObj.checkForNull(record[1]);
			result_type			= beanObj.checkForNull(record[2]);
		}

		if (result_type.equals("N")) {
			for (int i = 0; i < columnIndex; i++) {
				String[] record1 = new String[6];
				record1 = beanObj.getNumericResultTypeDetails(discr_msr_id);

				for(int j=0; j<record1.length; j++)
					if(record1[j]== null) record1[j]="";

				//double max_val	= 0;
				//double min_val	= 0;
				//if (!record1[2].equals("")) max_val	= Double.parseDouble(record1[2]);
				//if (!record1[1].equals("")) min_val	= Double.parseDouble(record1[1]);

				out.println("document.result_culture_test.all.anti"+i+orgIndex+"_td.innerHTML=\"<input type='text' name='anti"+i+orgIndex+"' id='anti"+i+orgIndex+"' value='' size='5' class='NUMBER' onblur=''  >\"");
			}
		} else if (result_type.equals("L")) {
			for (int i = 0; i < columnIndex; i++) {
				ArrayList listItems = beanObj.getListResultTypeDetails(discr_msr_id);

				StringBuffer option_string	= new StringBuffer();
				int selectedCount		= 0;
				//out.println("<select name='result_"+i+"' id='result_"+i+"' onchange='onListChange("+i+")' "+disabled+" "+disabled1+">");
				option_string.append("<option>-- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" --</option>");
				if(listItems!=null)
					for(int k=0; k<listItems.size(); k++) {
						String[] listValues = new String[4];
						listValues = (String[])listItems.get(k);
						if(listValues[1]!=null && listValues[1].equalsIgnoreCase("Y")) {
							option_string.append("<option value='"+listValues[2]+"' selected>"+listValues[0]+"</option>");
							selectedCount++;
						} else {
							option_string.append("<option value='"+listValues[2]+"'>"+listValues[0]+"</option>");
						}
					}
				option_string.append("</select>\"");

				out.println("document.result_culture_test.all.anti"+i+orgIndex+"_td.innerHTML=\"<select name='anti"+i+orgIndex+"' id='anti"+i+orgIndex+"'  onChange='antibioticClick(this)' >"+option_string.toString());
				if (selectedCount > 0) {
					out.println("antibioticClick(document.result_culture_test.all.anti"+i+orgIndex+")");
				}

			}
		} else if (result_type.equals("D")) {
			for (int i = 0; i < columnIndex; i++) {
				out.println("document.result_culture_test.all.anti"+i+orgIndex+"_td.innerHTML=\"<input type='text' name='anti"+i+orgIndex+"' id='anti"+i+orgIndex+"' value=''>\"");
			}
		} else if (result_type.equals("E")) {
			for (int i = 0; i < columnIndex; i++) {
				out.println("document.result_culture_test.all.anti"+i+orgIndex+"_td.innerHTML=\"<input type='text' name='anti"+i+orgIndex+"' id='anti"+i+orgIndex+"' value=''>\"");
			}
		} else if (result_type.equals("T")) {
			for (int i = 0; i < columnIndex; i++) {
				out.println("document.result_culture_test.all.anti"+i+orgIndex+"_td.innerHTML=\"<input type='text' name='anti"+i+orgIndex+"' id='anti"+i+orgIndex+"' value=''>\"");
			}
		} else if (result_type.equals("C")) {
			for (int i = 0; i < columnIndex; i++) {
				out.println("document.result_culture_test.all.result_culture_test"+i+orgIndex+"_td.innerHTML=\"<input type='checkbox' name='anti"+i+orgIndex+"' id='anti"+i+orgIndex+"' value='N'>\"");
			}
		}
	}
	/*else if(validate.equals("CONVERT_XML"))
	{
		
		// String qry_string			= (String)hash.get("qry_string");
		 String index					= (String)hash.get("index");
		 String htmlString				= beanObj.checkForNull((String)hash.get("htmlString"),"");
 		 htmlString						= htmlString.replaceAll(">>","\"");
    		 if(htmlString!=null && htmlString.length() > 0){
			 //set it in the bean
				beanObj.setResultHtmlData(index, htmlString);
 		 }

	}	*/
	else if( validate.equals( "NOTE_EVENT_STATUS" )){
		String facility_id = (String)session.getAttribute("facility_id");
		String accession_num = (String)hash.get("accession_num");
		String event_status = beanObj.getNoteStatus(facility_id,accession_num);
		if(event_status.equals("4") || event_status.equals("5"))
		out.println("event_status = 'RECORD_COMPLETE' ;");
		else
		out.println("event_status = 'RECORD_PARTIAL' ;");
	}
	else if( validate.equals( "CHART_RECORDING" ))
	{
	
		String orderId			 = (String)hash.get("orderId");
		String order_line_num	 = (String)hash.get("order_line_num");
		
		String chart_status		 = beanObj.getChartStatus(orderId,order_line_num);
		
		if(chart_status.equals("Y"))
		out.println("chart_status = 'CHART_RECORDED' ;");
		else
		out.println("chart_status = 'NOT_RECORDED' ;");
	}			
	putObjectInBean(bean_id,beanObj,request);
%>

