
/*							
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History    	Name				Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
15/03/2017		IN051294		Krishna Gowtham J										MO-CRF-20087
07/02/2019		IN069654	sivabagyam M 	07/02/2019		Ramesh G			        MO-CRF-20101.4
21/06/2020  	IN071596	sivabagyam M 	21/06/2020		Ramesh G		            MO-CRF-20101.7
05/08/2020      IN072762    ChandraShekar                                               MO-CRF-20101.11
04/11/2020		IN073728	Nijithas		04/11/2020		Ramesh G					MO-CRF-20101.16
26/11/2020	    6450		SIVABAGYAM M	26/11/2020		RAMESH G	      			MO-CRF-20101.10
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/

<%@ page import="java.sql.*,webbeans.eCommon.*,eCA.*,eCA.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//IN073728 Starts
	String bean_id					= "NewClinicalEventHistBean" ;
	String bean_name				= "eCA.NewClinicalEventHistBean";
	NewClinicalEventHistBean bean	= (NewClinicalEventHistBean)getBeanObject( bean_id, bean_name , request) ; 
	//IN073728 Ends
	Connection con = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	PreparedStatement pstmt2 = null;
	PreparedStatement pstmt3 = null;
	PreparedStatement pstmt4 = null;
	PreparedStatement pstmt5= null;
	PreparedStatement pstmt7= null;//IN072762
	PreparedStatement pstmt8= null;//IN072762
	ResultSet rs = null;
	ResultSet rs1 = null;
	ResultSet rs2 = null;
	ResultSet rs3 = null;
	ResultSet rs4 = null;
	ResultSet rs5 = null;
	ResultSet rs7 = null;//IN072762
	ResultSet rs8 = null;//IN072762
	PreparedStatement pstm1 = null;//IN071596
	ResultSet rst1 = null;//IN071596
	String sql = "";
	String sql7="";//IN071596
	String sql1 = "";
	String sql2 = "";
	String sql3 = "";
	String sql4 = "";
	String sql5 = "";
	String sql6 = "";
	String sql8 = "";//IN072762
	String sql9 = "";//IN072762
	String column_id = "";
	String column_desc = "";
	String column_data_type = "";
	String list_type = "";
	String relative_ref = "";
	String relative_desc = "";
	String value_appl_type = "";
	String default_yn = "";
	String sel = "";
	String relative_field_ref = "";
	String actual_value = "";
	String dt_relative_val = "";
	String val_type = "";
	String actual_checked = "checked";
	String field_check = "";
	String chk_val = "N";
	String choice_val ="";
	String choice_desc = "";
	String actual_enabled = "";
	String relative_enabled = "disabled";
	String dt_relative_ind = "";
	String dt_relative_unit = "";
	String data_source_id = "";
	String data_source_sql = "";
	String dep_col_Yn = "";
	String dep_col_Id = "";
	String dependency = "";
	String actual_text = "";
	String depend_value = "";
	String disable_field = "";//IN072762
	String sel_d ="",sel_e ="",sel_m="";//IN072762

	int max_length = 0;
	int decimal_digits = 0;
	int i = 0;
	int totalHistTypes=0;//IN073728
	HashMap map = new HashMap();
	
	String function_id = request.getParameter("function_id") == null ? "" : request.getParameter("function_id");
	String ql_ref = request.getParameter("ql_ref") == null ? "" : request.getParameter("ql_ref");
	String mode = request.getParameter("mode") == null ? "insert" : request.getParameter("mode");
	String locale = request.getParameter("locale") == null ? "en" : request.getParameter("locale");
	String facilityId = request.getParameter("facilityId") == null ? "" : request.getParameter("facilityId");
	String clinician_id = request.getParameter("clinician_id") == null ? "" : request.getParameter("clinician_id");
	String pract_type = request.getParameter("pract_type") == null ? "" : request.getParameter("pract_type");
	String grphistory_type			= request.getParameter("grphistory_type")==null	?"LBIN":request.getParameter("grphistory_type");//IN069654 starts//IN071596
	//IN073728 Starts
	String grphistory_type_all = "";
	if(!"*ALL".equals(grphistory_type)){
		grphistory_type_all = grphistory_type;
	}
	if(!"LBIN".equals(grphistory_type)){
		grphistory_type = "LBIN";
	}
	//IN073728 Ends
	String[] eventHistList  = new String[2];
	//String[] eventHistList1  = new String[2];//IN071596//IN073728
	ArrayList eventHistArr  = new ArrayList();//IN071596//IN073728
	
	try
	{
	con =	ConnectionManager.getConnection(request);
	eventHistArr = bean.getHistRecType(con,locale);//IN073728

	String sq="select hist_rec_type, short_desc from CR_HIS_RECTYP_LNG_VW where hist_rec_type not in('ALGY','MEDN','NBDT','FEVT') AND LANGUAGE_ID = ? and hist_rec_type=? order by 2";
	pstmt = con.prepareStatement(sq.toString());
	pstmt.setString(1, locale);
	pstmt.setString(2, grphistory_type);
	rs = pstmt.executeQuery(); 
	 if ( rs != null )
		{
			while(rs.next())
			{
				eventHistList[0] =(String)rs.getString("hist_rec_type");
				eventHistList[1] =(String)rs.getString("short_desc");
				
			}
		}
	//IN069654ends
	StringBuffer sb = new StringBuffer();
	String histypeStyle = "display:none";//IN073728
	if(function_id.equals("FLOW_SHEET_NEW")){//IN069654 starts
		
		//IN073728 StartS
		/* sb.append("<table  border=0 cellspacing=0 cellpadding=3 width=\"100%\" align=center>");
		sb.append("<tr><td style=\"width: 25%;\" width=\"18%\" class=fields >History Type </td>");//IN071596 STARTS
		sb.append("<td style=\"width: 25%;\" width=\"82%\" class=fields > <select name=\"grphistory_type1\" onchange=\"selecthistype(this)\" >");
		 sql7 ="select A.HIST_REC_TYPE,A.SHORT_DESC FROM CR_HIS_RECTYP_LNG_VW A, CR_HIST_APPLICABILITY B WHERE A.HIST_REC_TYPE=B.HIST_REC_TYPE AND B.HIST_REC_TYPE_APPL_YN = 'Y' AND LANGUAGE_ID = ? ORDER BY B.SEQ_NUMBER";
		pstm1 = con.prepareStatement(sql7.toString());
		pstm1.setString(1, locale);
		rst1 = pstm1.executeQuery(); 
		 if ( rst1 != null )
			{
				while(rst1.next())
				{
					eventHistList1[0] =(String)rst1.getString("HIST_REC_TYPE");
					eventHistList1[1] =(String)rst1.getString("SHORT_DESC");
					
					if(eventHistList1[0].equals(grphistory_type))
						sel = "selected";
					else
						sel = "";
					

		
		sb.append("<option value="+eventHistList1[0]+"  "+sel+">"+eventHistList1[1]+"</option>");
		
				}
			}
		sb.append("</select>");
		sb.append("</td></tr>");//IN071596 ENDS
		sb.append("</table>"); */
		 for(int k=0;k<eventHistArr.size();k++) {
				String[] eventHistStr =(String[])eventHistArr.get(k);
				totalHistTypes++;
					if(grphistory_type.equals(eventHistStr[0])){
								sb.append("<li class=tablistitem title="+eventHistStr[1]+" style=display: width=100px >");			
								sb.append(" <a class=tabClicked id=histTab"+k+" value="+eventHistStr[1]+" onclick=\"selHistTypeNew("+k+");\">");
								sb.append("<span class=tabSpanclicked id=histTabSpan"+k+"> <span class=tabtext1> "+eventHistStr[1]+"</span></span></a>");
								sb.append("<input type=hidden  id=eventHistStr"+k+" name=eventHistStr"+k+" value=\""+eventHistStr[0]+"\" >");
								sb.append("<input type=hidden  id=histtypeSelected"+eventHistStr[0]+" name=histtypeSelected"+eventHistStr[0]+" value=\"Y\" >");
								
							}else{

								sb.append("<li class=tablistitem title="+eventHistStr[1]+"  style=display: width=100px >");				
								sb.append("<a class=tabA id=histTab"+k+" value="+eventHistStr[1]+" onclick=\"selHistTypeNew("+k+");\" >");
								sb.append("<span class=tabAspan id=histTabSpan"+k+"><span class=tabtext1>"+eventHistStr[1]+"</span></span> </a> </li>");
								sb.append("<input type=hidden  id=eventHistStr"+k+" name=eventHistStr"+k+" value=\""+eventHistStr[0]+"\" >");
								sb.append("<input type=hidden  id=histtypeSelected"+eventHistStr[0]+" name=histtypeSelected"+eventHistStr[0]+" value=\"N\" >");
							}
				
					
		 }
		 
		 for(int m=0;m<eventHistArr.size();m++) {
				i=0;
				sel = "";
				chk_val = "N";
				actual_checked = "checked";
				actual_enabled = "";
				relative_enabled = "disabled";
				disable_field = "";
				field_check = "";
				dependency = "";
				actual_value = "";
				value_appl_type = "";
				
				String[] eventHistStr1 =(String[])eventHistArr.get(m);
				if(grphistory_type.equals(eventHistStr1[0])){
					
					histypeStyle = "display:";
				}
				else{
					grphistory_type = eventHistStr1[0];
					histypeStyle = "display:none";
				}
					sb.append("<table  border=0 cellspacing=0 cellpadding=3 width=\"100%\" align=center>");
					sb.append("<div id=\"ql_crit_div"+grphistory_type+"\"  name=\"ql_crit_div"+grphistory_type+"\" style=\" position:relative;"+histypeStyle+" \" >");
					sb.append("<table id=\"dataTitleTable"+grphistory_type+"\" style = \""+histypeStyle+"\" border=0 cellspacing=1 cellpadding=3 width=\"100%\" align=center>");
				//	sb.append("<table id=\"dataTitleTable"+grphistory_type+"\" style = \""+histypeStyle+"\" border=0 cellspacing=0 cellpadding=3 width=\"100%\" align=center>");//Nijitha
					sb.append("<tr><td style=\"width: 25%;\" style = \""+histypeStyle+"\"  colspan=4 class=COLUMNHEADER>Define Filter Criteria</td></tr>");
					sb.append("<tr></tr>");
					sb.append("<tr><td style=\"width: 25%;\" style=\"width: 25%;\" class=COLUMNHEADER>Criteria Name</td>");
					sb.append("<td style=\"width: 25%;\" style=\"width: 25%;\" class=COLUMNHEADER>Actual</td>");
					sb.append("<td style=\"width: 25%;\" style=\"width: 25%;\" class=COLUMNHEADER>Actual Value</td>");
					sb.append("<td style=\"width: 25%;\"  class=COLUMNHEADER>Relative</td></tr>");
					sb.append("</table>");
					sb.append("</div>");
					sb.append("<table id=\"dataTable"+grphistory_type+"\" style = \""+histypeStyle+"\" border=0 cellspacing=0 cellpadding=3 width=\"100%\" align=center>");

						sql = "select COLUMN_ID, COLUMN_DESC, COLUMN_DATA_TYPE, MAX_LENGTH, DECIMAL_DIGITS, LIST_TYPE, VALUE_APPL_TYPE, DATA_SOURCE_ID, DEP_COL_YN, DEP_COLUMN_ID from SM_QUICK_LINK_CRITERIA where OPTION_ID = ? order by ORDER_SEQ_NO";

						sql1 = "select a.RELATIVE_FIELD_REF, a.RELATIVE_FIELD_DESC, b.DEFAULT_YN from SM_QUICK_LINK_RELV_ITEM_LST a, SM_QUICK_LINK_CRIT_RELV_LNK b where a.RELATIVE_FIELD_REF = b.RELATIVE_FIELD_REF and b.OPTION_ID = ? and b.COLUMN_ID = ?";

						sql2 = "select CHOICE_VAL, CHOICE_DESC from SM_QUICK_LINK_CRIT_VAL where OPTION_ID = ? and COLUMN_ID = ?";

						if(mode.equals("update"))
						{
							sql3 = "select VALUE_TYPE, ACTUAL_VALUE, DATETIME_RELATIVE_IND, DATETIME_RELATIVE_VAL, DATETIME_RELATIVE_UNIT, RELATIVE_FIELD_REF from SM_QUICK_LINK_DEFN where QUICK_LINK_REF = ? and COLUMN_ID = ? AND HIST_TYPE=? ";
						}
						
						sql4 = "select SOURCE_SQL from SM_DATA_SOURCE where SOURCE_ID = ? ";

						sql5 = "select sm_get_quick_link_dep_items(?,?) dep_items from dual ";

						sql6 = "SELECT ACTUAL_VALUE FROM SM_QUICK_LINK_DEFN  WHERE COLUMN_ID = ? AND QUICK_LINK_REF =?  AND HIST_TYPE=? ";
						sql9 = "SELECT SHORT_DESC FROM OR_ORDER_TYPE WHERE ORDER_TYPE_CODE =? ";

						sql8 = "select DRUG_DESC from ph_drug_lang_vw where  drug_code = ? and LANGUAGE_ID =?";

						
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1,function_id);
						rs = pstmt.executeQuery();

						while(rs.next())
						{
							depend_value = "";
							actual_enabled = "";
							
							actual_value = "";
							column_id = rs.getString("COLUMN_ID") == null ? "" : rs.getString("COLUMN_ID");
							
							if(!"ENCOUNTER_ID".equals(column_id)){
								val_type="A";
							}
							else{
								val_type="";
							}
							column_desc = rs.getString("COLUMN_DESC") == null ? "" : rs.getString("COLUMN_DESC");
							column_data_type = rs.getString("COLUMN_DATA_TYPE") == null ? "" : rs.getString("COLUMN_DATA_TYPE");
							max_length = rs.getInt("MAX_LENGTH");
							decimal_digits = rs.getInt("DECIMAL_DIGITS");
							list_type = rs.getString("LIST_TYPE") == null ? "" : rs.getString("LIST_TYPE");
							value_appl_type = rs.getString("VALUE_APPL_TYPE") == null ? "" : rs.getString("VALUE_APPL_TYPE");
							data_source_id = rs.getString("DATA_SOURCE_ID") == null ? "" : rs.getString("DATA_SOURCE_ID");
							dep_col_Yn = rs.getString("DEP_COL_YN") == null ? "" : rs.getString("DEP_COL_YN");
							dep_col_Id = rs.getString("DEP_COLUMN_ID") == null ? "" : rs.getString("DEP_COLUMN_ID");
							pstmt5 = con.prepareStatement(sql6);
							pstmt5.setString(1,dep_col_Id);
							pstmt5.setString(2,ql_ref);
							if(grphistory_type_all.equals(eventHistStr1[0]))
								pstmt5.setString(3,"*ALL");
							else
								pstmt5.setString(3,grphistory_type);
							rs5 = pstmt5.executeQuery();
							if(rs5.next())
							{
								depend_value = rs5.getString("ACTUAL_VALUE")==null?"":rs5.getString("ACTUAL_VALUE");
							}
							if(rs5!=null)rs5.close();
							if(pstmt5!=null)pstmt5.close();
							pstmt1 = con.prepareStatement(sql1);
							pstmt1.setString(1,function_id);
							pstmt1.setString(2,column_id);
							rs1 = pstmt1.executeQuery();

							if(mode.equals("update"))
							{
								System.out.println("ql_ref===>"+ql_ref);
								pstmt3 = con.prepareStatement(sql3);
								
								pstmt3.setString(1,ql_ref);
								pstmt3.setString(2,column_id);
								if(grphistory_type_all.equals(eventHistStr1[0]))
									pstmt3.setString(3,"*ALL");
								else
									pstmt3.setString(3,grphistory_type);
								rs3 = pstmt3.executeQuery();
								if(rs3.next())
								{
									val_type = rs3.getString("VALUE_TYPE") == null ? "" : rs3.getString("VALUE_TYPE");
									System.out.println("239:val_type==>"+val_type);
									actual_value = rs3.getString("ACTUAL_VALUE") == null ? "" : rs3.getString("ACTUAL_VALUE");
									dt_relative_ind = rs3.getString("DATETIME_RELATIVE_IND") == null ? "" : rs3.getString("DATETIME_RELATIVE_IND");
									dt_relative_val = rs3.getString("DATETIME_RELATIVE_VAL") == null ? "" : rs3.getString("DATETIME_RELATIVE_VAL");
									dt_relative_unit = rs3.getString("DATETIME_RELATIVE_UNIT") == null ? "" : rs3.getString("DATETIME_RELATIVE_UNIT");
									relative_field_ref = rs3.getString("RELATIVE_FIELD_REF") == null ? "" : rs3.getString("RELATIVE_FIELD_REF");
								}
								if(rs3 != null) rs3.close();
								if(pstmt3 != null) pstmt3.close();
							}

							sb.append("<tr>");
							if(column_id.equals("QUEUE_STATUS"))
							{
								sb.append("<td style=\"width: 25%;\" class=label><B>"+column_desc+"</B></td>");
							}
							else
							{
								sb.append("<td style=\"width: 25%;\" class=label>"+column_desc+"</td>");
							}
							sb.append("<input type=hidden id=column_desc"+i+grphistory_type+" name=column_desc"+i+grphistory_type+" value=\""+column_desc+"\">");
							if(column_data_type.equals("DATETIME"))
							{
								String selBefore = "", selAfter = "";
								String selHour = "", selDay = "", selMonth = "", selYear = "";

								if(mode.equals("update"))
								{
									if(dt_relative_ind.equals("B"))
									{
										selBefore = "selected";
										selAfter = "";
									}
									else if(dt_relative_ind.equals("A"))
									{
										selBefore = "";
										selAfter = "selected";
									}
									if(dt_relative_unit.equals("h"))
									{
										selHour = "selected";
										selDay = "";
										selMonth = "";
										selYear = "";
									}
									else if(dt_relative_unit.equals("d"))
									{
										selHour = "";
										selDay = "selected";
										selMonth = "";
										selYear = "";
									}
									else if(dt_relative_unit.equals("M"))
									{
										selHour = "";
										selDay = "";
										selMonth = "selected";
										selYear = "";
									}
									else if(dt_relative_unit.equals("Y"))
									{
										selHour = "";
										selDay = "";
										selMonth = "";
										selYear = "selected";
									}
								}
								sb.append("<td style=\"width: 25%;\" class=fields><select name=date_ind"+i+grphistory_type+">");
								sb.append("<option value=\"\">---Select---</option>");
								sb.append("<option value=B "+selBefore+">Before</option>");
								//if((function_id.equals("FLOW_SHEET"))||(function_id.equals("PREVIOUS_NOTES")))//Commented for IN051294
								//if((function_id.equals("FLOW_SHEET"))||(function_id.equals("PREVIOUS_NOTES"))||(function_id.equals("PHYSICIAN_NOTES"))||)) //20101.3
								if((function_id.equals("FLOW_SHEET"))||(function_id.equals("PREVIOUS_NOTES"))||(function_id.equals("PHYSICIAN_NOTES"))||(function_id.equals("FLOW_SHEET_NEW"))) //Added for IN069654
									sb.append("<option value=A "+selAfter+">After</option></select></td>");

								sb.append("<td style=\"width: 25%;\" class=fields><input type=text id=noOfDays"+i+grphistory_type+" name=noOfDays"+i+grphistory_type+" value=\""+dt_relative_val+"\" size=4 maxlength=4 OnKeyPress =\"return(ChkNumberInput(this,event,0))\">");

								sb.append("<select name=value_ind"+i+grphistory_type+"><option value=\"\">---Select---</option>");
								//if(!(function_id.equals("BY_LOCATION")&&(column_id.equals("PERIOD_FROM")||column_id.equals("PERIOD_TO"))))//Commented for IN051294
								if(!(function_id.equals("BY_LOCATION")||function_id.equals("PHYSICIAN_NOTES")&&(column_id.equals("PERIOD_FROM")||column_id.equals("PERIOD_TO")))) //Added for IN051294
								{
									sb.append("<option value=h "+selHour+">Hours</option>");
								}
								
								sb.append("<option value=d "+selDay+">Days</option>");
								sb.append("<option value=M "+selMonth+">Months</option>");
								sb.append("<option value=Y "+selYear+">Years</option></select></td>");

								sb.append("<td style=\"width: 25%;\" class=label>From&nbsp;");
								sb.append("<select name=relative_val"+i+grphistory_type+"><option value=\"\">---Select---</option>");
								while(rs1.next())
								{
									relative_ref = rs1.getString("RELATIVE_FIELD_REF") == null ? "" : rs1.getString("RELATIVE_FIELD_REF");
									relative_desc = rs1.getString("RELATIVE_FIELD_DESC") == null ? "" : rs1.getString("RELATIVE_FIELD_DESC");
									default_yn = rs1.getString("DEFAULT_YN") == null ? "N" : rs1.getString("DEFAULT_YN");
									if(relative_field_ref.equals(""))
									{
										if(default_yn.equals("Y"))
											sel = "selected";
										else
											sel = "";
									}
									else
									{
										if(relative_field_ref.equals(relative_ref))
											sel = "selected";
										else
											sel = "";
									}
									sb.append("<option value="+relative_ref+" " +sel+">"+relative_desc+"</option>");
								}
								sb.append("</select></td>");
								sb.append("<input type=hidden id=actual_val"+i+grphistory_type+" name=actual_val"+i+grphistory_type+" value=\"\">");
								sb.append("<input type=hidden id=value_type"+i+grphistory_type+" name=value_type"+i+grphistory_type+" value=\"R\">");
							}
							else
							{
								sb.append("<input type=hidden id=date_ind"+i+grphistory_type+" name=date_ind"+i+grphistory_type+" value=\"\">");
								sb.append("<input type=hidden id=noOfDays"+i+grphistory_type+" name=noOfDays"+i+grphistory_type+" value=\"\">");
								sb.append("<input type=hidden id=value_ind"+i+grphistory_type+" name=value_ind"+i+grphistory_type+" value=\"\">");
							}
							if(column_data_type.equals("CHECKBOX"))
							{
									if(actual_value.equals("Y"))
									{
										chk_val = "Y";
										field_check = "checked";
									}
									else
									{
										chk_val = "N";
										field_check = "";
									}
								
								pstmt4 = con.prepareStatement(sql5);
								pstmt4.setString(1,function_id);
								pstmt4.setString(2,column_id);
								rs4 = pstmt4.executeQuery();
								if(rs4.next())
								{
									dependency = rs4.getString(1);
								}
								else
									dependency = "";
								if(rs4 != null) rs4.close();
								if(pstmt4 != null) pstmt4.close();
								
								if(grphistory_type.equals("MEDN")||grphistory_type.equals("CLNT")||grphistory_type.equals("SUNT")||grphistory_type.equals("MERP"))//IN072762//6450
									disable_field = "disabled";//IN072762
								else
									disable_field = "";//IN072762

								sb.append("<td style=\"width: 25%;\" class=fields>&nbsp;</td>");
								if(column_id.equals("QUEUE_STATUS"))
								{
									sb.append("<td style=\"width: 25%;\" class=fields>&nbsp;</td>");
								}
								else
								{
									sb.append("<td style=\"width: 25%;\" class=fields><input type=checkbox id=actual_val"+i+grphistory_type+" name=actual_val"+i+grphistory_type+" value=\""+chk_val+"\" onclick=makeEnable(this,"+i+",\""+grphistory_type+"\"); "+field_check+" "+disable_field+"></td>");
								}
								sb.append("<td style=\"width: 25%;\" class=fields>&nbsp;</td>");
								sb.append("<input type=hidden id=relative_val"+i+grphistory_type+" name=relative_val"+i+grphistory_type+" value=\"\">");
								sb.append("<input type=hidden id=value_type"+i+grphistory_type+" name=value_type"+i+grphistory_type+" value=\"A\">");
								sb.append("<input type=hidden id=dependency"+i+grphistory_type+" name=dependency"+i+grphistory_type+" value=\""+dependency+"\">");
							}
							if(column_data_type.equals("LIST") || column_data_type.equals("NUMERIC"))
							{
								if(mode.equals("update"))
								{
									if(val_type.equals("A"))
									{
										actual_checked = "checked";
										actual_enabled = "";
										relative_enabled = "disabled";
										
									}
									else
									{
										actual_checked = "";
										actual_enabled = "disabled";
										relative_enabled = "";
									}
								}
								else
								{
									if(value_appl_type.equals("R"))
										relative_enabled = "";
									else
										relative_enabled = "disabled";
								}

								if(!value_appl_type.equals("R") && !value_appl_type.equals("A"))
									sb.append("<td style=\"width: 25%;\" class=fields><input type=checkbox id=actual_check"+i+grphistory_type+" name=actual_check"+i+grphistory_type+" onclick=enableActualCEH(this,"+i+",\""+grphistory_type+"\"); "+actual_checked+"></td>");
								else
									sb.append("<td style=\"width: 25%;\" class=fields>&nbsp;</td>");

								if(column_data_type.equals("NUMERIC"))
								{
									if(!value_appl_type.equals("R"))
									{
										if(!mode.equals("update"))
										{
											val_type = "A";
										}
										sb.append("<td style=\"width: 25%;\" class=fields><input type=text id=actual_val"+i+grphistory_type+" name=actual_val"+i+grphistory_type+" value=\""+actual_value+"\" maxlength=12 size=13 "+actual_enabled+"></td>");
										sb.append("<input type=hidden id=value_type"+i+grphistory_type+" name=value_type"+i+grphistory_type+" value=\""+val_type+"\">");
									}
									else
									{
										val_type = "R";
										sb.append("<td style=\"width: 25%;\" class=fields>&nbsp;</td>");
										sb.append("<input type=hidden id=actual_val"+i+grphistory_type+" name=actual_val"+i+grphistory_type+" value=\"\">");
										sb.append("<input type=hidden id=actual_val"+i+grphistory_type+" name=value_type"+i+grphistory_type+" value=\""+val_type+"\">");
									}
									sb.append("<td style=\"width: 25%;\" class=fields><select name=relative_val"+i+grphistory_type+" "+relative_enabled+">");
									sb.append("<option value=\"\">---Select---</option>");

									while(rs1.next())
									{
										relative_ref = rs1.getString("RELATIVE_FIELD_REF") == null ? "" : rs1.getString("RELATIVE_FIELD_REF");
										relative_desc = rs1.getString("RELATIVE_FIELD_DESC") == null ? "" : rs1.getString("RELATIVE_FIELD_DESC");
										default_yn = rs1.getString("DEFAULT_YN") == null ? "N" : rs1.getString("DEFAULT_YN");
										if(relative_field_ref.equals(""))
										{
											if(default_yn.equals("Y"))
												sel = "selected";
											else
												sel = "";
										}
										else
										{
											if(relative_field_ref.equals(relative_ref))
												sel = "selected";
											else
												sel = "";
										}
										sb.append("<option value="+relative_ref+" " +sel+">"+relative_desc+"</option>");
									}
									sb.append("</select></td>");
								}
								if(column_data_type.equals("LIST"))
								{
									if(!mode.equals("update"))
									{
										val_type = "A";
									}
									if(list_type.equals("F"))
									{
										if(!mode.equals("update"))
										{
											if(dep_col_Yn.equals("Y") && !value_appl_type.equals("B"))
											{
												actual_enabled = "";
											}
											else if(dep_col_Yn.equals("Y"))
												actual_enabled="disabled";
											else
												actual_enabled = "";

										}else if(mode.equals("update"))
										{	//sb.append("HAI");
											if(map.containsKey(dep_col_Id))
											{	//sb.append("HAI1");
												if(dep_col_Yn.equals("Y") && !value_appl_type.equals("B"))
											{
													actual_enabled = "disabled";
											}
											else if(dep_col_Yn.equals("Y"))
												actual_enabled="";
											else
												actual_enabled = "";
											}
											else{//sb.append("HAI2");
											if(dep_col_Yn.equals("Y") && !value_appl_type.equals("B"))
											{
													actual_enabled = "";
											}
											else if(dep_col_Yn.equals("Y"))
												actual_enabled="disabled";
											else
												actual_enabled = "";
											}
											
											
											}
											if((grphistory_type.equals("MEDN") || grphistory_type.equals("CLNT") || grphistory_type.equals("SUNT") ||grphistory_type.equals("MERP")) && (column_id.equals("VIEW_BY") || column_id.equals("NORMALCY_IND")))//Added for IN072762//6450
											        actual_enabled="disabled";//Added for IN072762
									
										if((grphistory_type.equals("CLNT") || grphistory_type.equals("SUNT") || grphistory_type.equals("RDIN")||grphistory_type.equals("MERP"))   && (column_id.equals("VIEW_BY")))//Added for IN072762//6450
									        actual_enabled="disabled";
									
												
										sb.append("<td style=\"width: 25%;\" class=fields><select id=actual_val"+i+grphistory_type+" name=actual_val"+i+grphistory_type+" "+actual_enabled+">");
										if(function_id.equals("PREVIOUS_NOTES"))
											sb.append("<option value=\"\">All</option>");
										else
											sb.append("<option value=\"\">---Select---</option>");


										pstmt2 = con.prepareStatement(sql2);
										pstmt2.setString(1,function_id);
										pstmt2.setString(2,column_id);
										rs2 = pstmt2.executeQuery();
										while(rs2.next())
										{
											choice_val = rs2.getString("CHOICE_VAL") == null ? "" : rs2.getString("CHOICE_VAL");
											choice_desc = rs2.getString("CHOICE_DESC") == null ? "" : rs2.getString("CHOICE_DESC");
											if(actual_value.equals(choice_val))
												sel = "selected";
											else
												sel = "";
											sb.append("<option value="+choice_val+" "+sel+">"+choice_desc+"</option>");
										}
										if(rs2 != null) rs2.close();
										if(pstmt2 != null) pstmt2.close();

										sb.append("</select></td>");
										if(!value_appl_type.equals("A"))
										{
											sb.append("<td style=\"width: 25%;\" class=fields><select name=relative_val"+i+grphistory_type+" "+relative_enabled+">");
											sb.append("<option value=\"\">---Select---</option>");

											while(rs1.next())
											{
												relative_ref = rs1.getString("RELATIVE_FIELD_REF") == null ? "" : rs1.getString("RELATIVE_FIELD_REF");
												relative_desc = rs1.getString("RELATIVE_FIELD_DESC") == null ? "" : rs1.getString("RELATIVE_FIELD_DESC");
												default_yn = rs1.getString("DEFAULT_YN") == null ? "N" : rs1.getString("DEFAULT_YN");
												if(relative_field_ref.equals(""))
												{
													if(default_yn.equals("Y"))
														sel = "selected";
													else
														sel = "";
												}
												else
												{
													if(relative_field_ref.equals(relative_ref))
														sel = "selected";
													else
														sel = "";
												}
												sb.append("<option value="+relative_ref+" " +sel+">"+relative_desc+"</option>");
											}
											sb.append("</select></td>");
										}
										else
											sb.append("<input type=hidden id=relative_val"+i+grphistory_type+" name=relative_val"+i+grphistory_type+" value=\"\">");
										sb.append("<input type=hidden id=value_type"+i+grphistory_type+" name=value_type"+i+grphistory_type+" value=\""+val_type+"\">");
									}
									if(list_type.equals("V"))
									{
										if(grphistory_type.equals("MERP") &&(column_id.equals("EVENT_GROUP")||column_id.equals("EVENT_CLASS")||column_id.equals("EVENT_ITEM")))
											 actual_enabled="disabled";
										if(!mode.equals("update"))
										{
											if(dep_col_Yn.equals("Y") && !value_appl_type.equals("B"))
											{
												actual_enabled = "disabled";
											}
											if(!dep_col_Yn.equals("Y") && value_appl_type.equals("B"))
											{
												actual_enabled = "";
											}
											//else
												//actual_enabled = "";
										}
										pstmt4 = con.prepareStatement(sql4);
										pstmt4.setString(1,data_source_id);
										rs4 = pstmt4.executeQuery();
										if(rs4.next())
										{
											data_source_sql = rs4.getString(1) == null ? "" : rs4.getString(1);
										}
										if(rs4 != null) rs4.close();
										if(pstmt4 != null) pstmt4.close();
										
										if(mode.equals("update"))
										{
											if(!dep_col_Id.equals(""))
											{
												if(!value_appl_type.equals("B")){
												if(map.containsKey(dep_col_Id))
												{
													actual_enabled = "";
													depend_value = (String)map.get(dep_col_Id);
												}
												else
												{
													if(dep_col_Id.equals("Y"))
													 {
													actual_enabled = "disabled";
													 }
													 else
													 {
														actual_enabled = "";
													 }
													depend_value = "";
												}
												}
												else
												{
												if(map.containsKey(dep_col_Id) && dep_col_Id.equals("Y"))
												{
													actual_enabled = "disabled";
													depend_value = (String)map.get(dep_col_Id);
												}
												}
													
											}
											else
											{
												if(val_type.equals("R"))
												{
													actual_enabled = "disabled";
												}
												else
													actual_enabled = "";
												depend_value = "";
											}

											if(!data_source_sql.equals(""))
											{
												String data_source_sql1 = data_source_sql;
												if(data_source_sql1.indexOf("~") != -1)
												{
													data_source_sql1 = data_source_sql1.replaceAll("~","'");
												}
												if(data_source_sql1.indexOf("&&") != -1)
												{
													String retVal[] = null; 
													int count = 0;
													if(data_source_sql1.indexOf("&&") == data_source_sql1.lastIndexOf("&&"))
														retVal = new String[2];
													else
													{
														int start_index = 0;
														while (true)
														{
															start_index = data_source_sql1.indexOf("&&", start_index);
															if(start_index == -1)
																break;
															else
															{
																count++;
																start_index += 2;
															}
														}
														retVal = new String[count+1];
													}
													count = 1;
													while(data_source_sql1.indexOf("&&") != -1)
													{
														int start_index = data_source_sql1.indexOf("&&");
														int end_index = data_source_sql1.indexOf("##");
														String paramValue = data_source_sql1.substring(start_index+2, end_index);
														String substr = data_source_sql1.substring(start_index,end_index+2);
														data_source_sql1 = data_source_sql1.replaceFirst(substr,"?");
														retVal[count] = paramValue;
														count++;
													}
													retVal[0] = data_source_sql1.toString();

													int setStringCount = 1;
													pstmt4 = con.prepareStatement(retVal[0]);
													
													for(int l=1;l<retVal.length;l++)
													{
														String param = retVal[l];
														if(param.equals("LANGUAGE_ID"))
															pstmt4.setString(setStringCount++, locale);
														else if(param.equals("FACILITY_ID"))
															pstmt4.setString(setStringCount++,facilityId);
														else if(param.equals("PRACTITIONER_ID"))
															pstmt4.setString(setStringCount++,clinician_id);
														else if(param.equals("PRACT_TYPE"))
															pstmt4.setString(setStringCount++,pract_type);
														//IN069654 starts
														if(function_id.equals("FLOW_SHEET_NEW"))
														{
															
															 if(param.equals("HIST_REC_TYPE"))
																pstmt4.setString(setStringCount++,grphistory_type);
														}
														//IN069654 ends
														else if(param.equals(dep_col_Id))
														{
															String paramVal = "";
															if(map.containsKey(dep_col_Id))
																paramVal = (String)map.get(dep_col_Id);
															//Added By Jyothi on 02/06/2010 to fix IN020967
															if(function_id.equals("BY_LOCATION") && param.equals("PATIENT_CLASS"))
															{
																if(paramVal.equals("IP") || paramVal.equals("DC"))
																	pstmt4.setString(setStringCount++, "W");
																else if(paramVal.equals("OP") || paramVal.equals("EM"))
																	pstmt4.setString(setStringCount++, "C");
																else
																	pstmt4.setString(setStringCount++, "");
															}
															else
																pstmt4.setString(setStringCount++, paramVal);
														}
													}
													pstmt4.setString(setStringCount++, "%");

													pstmt4.setString(setStringCount++, actual_value);
												}
												else
												{
													pstmt4 = con.prepareStatement(data_source_sql1);
													pstmt4.setString(1, "%");
													pstmt4.setString(2, actual_value);
												}
												rs4 = pstmt4.executeQuery();
												if(rs4.next())
												{
													actual_text = rs4.getString(2);
												}
												else
													actual_text = "";
												if(rs4 != null) rs4.close();
												if(pstmt4 != null) pstmt4.close();
											}
											else
												actual_text = "";
											
										}
										else
											actual_text = "";
										pstmt4 = con.prepareStatement(sql5);
										pstmt4.setString(1,function_id);
										pstmt4.setString(2,column_id);
										rs4 = pstmt4.executeQuery();
										if(rs4.next())
										{
											dependency = rs4.getString(1);
											
										}
										else
											dependency = "";

										if(rs4 != null) rs4.close();
										if(pstmt4 != null) pstmt4.close();
							                     //Adding start for IN072762
										if(mode.equals("update")){
											if(grphistory_type.equals("MEDN") && column_id.equals("EVENT_CLASS") && !actual_value.equals("")){
												pstmt7 = con.prepareStatement(sql9);
												pstmt7.setString(1,actual_value);
												rs7 = pstmt7.executeQuery();
												if(rs7.next())
												{
													actual_text = rs7.getString("SHORT_DESC") == null ? "" : rs7.getString("SHORT_DESC");
													
												}
												if(rs7 != null) rs7.close();
												if(pstmt7 != null) pstmt7.close();
											
										     }
											if(grphistory_type.equals("MEDN") && column_id.equals("EVENT_ITEM") && !actual_value.equals("")){
												pstmt8 = con.prepareStatement(sql8);
												pstmt8.setString(1,actual_value);
												pstmt8.setString(2,locale);
												rs8 = pstmt8.executeQuery();
												if(rs8.next())
												{
													actual_text = rs8.getString("DRUG_DESC") == null ? "" : rs8.getString("DRUG_DESC");
													
												}
												if(rs8 != null) rs8.close();
												if(pstmt8 != null) pstmt8.close();
											 }
											   if(grphistory_type.equals("MEDN") && column_id.equals("EVENT_GROUP") && !actual_value.equals("")){
												   if(actual_value.equals("D"))
													   sel_d ="selected";
												   if(actual_value.equals("E"))
													   sel_e ="selected";
												   if(actual_value.equals("M"))
													   sel_m ="selected";
				                                    
											   }
											}//Adding end for IN072762
										if(!grphistory_type.equals("MEDN") ){ //added if condition forIN072762
										//sb.append("<input type=text name=actual_val"+i+" value=\""+dependency+"\">");
										sb.append("<td style=\"width: 25%;\" class=fields  id="+column_id+i+grphistory_type+"><input type=text id=actual_val_text"+i+grphistory_type+" name=actual_val_text"+i+grphistory_type+" value=\""+actual_text+"\" maxlength=16 size=16 onblur=openLookup1(this,"+i+",\""+grphistory_type+"\") "+actual_enabled+"><input type=button class=button value=? id=search_ref"+i+grphistory_type+" name=search_ref"+i+grphistory_type+" onclick= openLookup("+i+",\""+grphistory_type+"\") "+actual_enabled+"><input type=hidden id=actual_val"+i+grphistory_type+" name=actual_val"+i+grphistory_type+" value=\""+actual_value+"\">");//TD id added for IN072762
										}else if (grphistory_type.equals("MEDN") && column_id.equals("EVENT_GROUP")){//Adding start for IN072762
											sb.append("<td style=\"width: 25%;\" class=fields id="+column_id+i+grphistory_type+"><select id=actual_val_text"+i+grphistory_type+" name=actual_val_text"+i+grphistory_type+"  "+actual_enabled+" onchange =assignevngrp(this,"+i+",\""+grphistory_type+"\")>" );
											sb.append("<option value=\"\">---Select---</option>");
											sb.append("<option value=\"D\" " +sel_d+"> Drug Item </option>");
											sb.append("<option value=\"E\" " +sel_e+">External Drug</option>");
											sb.append("<option value=\"M\" " +sel_m+">Medical Item</option>");
											sb.append("<input type=hidden id=actual_val"+i+grphistory_type+" name=actual_val"+i+grphistory_type+" value=\""+actual_value+"\">");
											//sb.append("<option value="+relative_ref+" " +sel+">"+relative_desc+"</option>");
										}else if(grphistory_type.equals("MEDN") && !column_id.equals("EVENT_GROUP") ){
										//sb.append("<input type=text name=actual_val"+i+" value=\""+dependency+"\">");
										sb.append("<td style=\"width: 25%;\" class=fields id="+column_id+i+grphistory_type+"><input type=text id=actual_val_text"+i+grphistory_type+" name=actual_val_text"+i+grphistory_type+" value=\""+actual_text+"\" maxlength=16 size=16 onblur=openLookup1(this,"+i+",\""+grphistory_type+"\") "+actual_enabled+"><input type=button class=button value=? id=search_ref"+i+grphistory_type+" name=search_ref"+i+grphistory_type+" onclick=openLookup("+i+",\""+grphistory_type+"\") "+actual_enabled+"><input type=hidden id=actual_val"+i+grphistory_type+" name=actual_val"+i+grphistory_type+" value=\""+actual_value+"\">");
										
										}//Adding end for IN072762
										sb.append("</td>");
										sb.append("<input type=hidden id=query"+i+grphistory_type+" name=query"+i+grphistory_type+" value=\""+data_source_sql+"\">");
										sb.append("<input type=hidden id=value_type"+i+grphistory_type+" name=value_type"+i+grphistory_type+" value=\""+val_type+"\">");
										sb.append("<input type=hidden id=dependency"+i+grphistory_type+" name=dependency"+i+grphistory_type+" value=\""+dependency+"\">");
										sb.append("<input type=hidden id=depend_value"+i+grphistory_type+" name=depend_value"+i+grphistory_type+" value=\""+depend_value+"\">");
										
										if(!value_appl_type.equals("A"))
										{
											sb.append("<td style=\"width: 25%;\" class=fields><select name=relative_val"+i+grphistory_type+" "+relative_enabled+">");
											sb.append("<option value=\"\">---Select---</option>");
											while(rs1.next())
											{
												relative_ref = rs1.getString("RELATIVE_FIELD_REF") == null ? "" : rs1.getString("RELATIVE_FIELD_REF");
												relative_desc = rs1.getString("RELATIVE_FIELD_DESC") == null ? "" : rs1.getString("RELATIVE_FIELD_DESC");
												default_yn = rs1.getString("DEFAULT_YN") == null ? "N" : rs1.getString("DEFAULT_YN");
												if(relative_field_ref.equals(""))
												{
													if(default_yn.equals("Y"))
														sel = "selected";
													else
														sel = "";
												}
												else
												{
													if(relative_field_ref.equals(relative_ref))
														sel = "selected";
													else
														sel = "";
												}
												sb.append("<option value="+relative_ref+" " +sel+">"+relative_desc+"</option>");
											}
											if(rs1 != null) rs1.close();
											if(pstmt1 != null) pstmt1.close();
											if(rst1 != null) rst1.close();
											if(pstm1 != null) pstm1.close();
											sb.append("</select></td>");
										}
										else
											sb.append("<input type=hidden id=relative_val"+i+grphistory_type+" name=relative_val"+i+grphistory_type+" value=\"\">");
									}
								}
							}
							sb.append("</tr>");
							sb.append("<input type=hidden id=column_id"+i+grphistory_type+" name=column_id"+i+grphistory_type+" value=\""+column_id+"\">");
							sb.append("<input type=hidden id=column_type"+i+grphistory_type+" name=column_type"+i+grphistory_type+" value=\""+column_data_type+"\">");
							sb.append("<input type=hidden id=list_type"+i+grphistory_type+" name=list_type"+i+grphistory_type+" value=\""+list_type+"\">");
							sb.append("<input type=hidden id=dep_col_Id"+i+grphistory_type+" name=dep_col_Id"+i+grphistory_type+" value=\""+dep_col_Id+"\">");
							sb.append("<input type=hidden id=index name=index value=\""+i+"\">");
							i = i + 1;
							if(mode.equals("update"))
							{
								if(val_type.equals("A"))
								{
									if(column_data_type.equals("CHECKBOX"))
									{
										if(actual_value.equals("Y")){
											map.put(column_id,actual_value);}
									}
									else
									{
										if(!actual_value.equals(""))
											map.put(column_id,actual_value);
									}
								}
								else if(val_type.equals("R"))
								{
									if(!relative_field_ref.equals(""))
										map.put(column_id,relative_field_ref);
								}
							}
							
						}
						sb.append("</table>");
						sb.append("</table>");
				 }
						if(rs != null) rs.close();
						if(pstmt != null) pstmt.close();
					
						System.out.println("sb==>"+sb);
		
		sb.append("<input type=hidden id=totalHistTypes name=totalHistTypes value=\""+totalHistTypes+"\" >");
		sb.append("<input type=hidden id=histSelected name=histSelected value=\""+grphistory_type+"\" >");
		
	
	}//IN069654 ends
	else{//IN073728 Ends
	sb.append("<div id=\"ql_crit_div\" name=\"ql_crit_div\" style=\" position:relative \" >");
	sb.append("<table id=\"dataTitleTable\" border=0 cellspacing=1 cellpadding=3 width=\"100%\" align=center>");
	sb.append("<tr><td style=\"width: 25%;\" colspan=4 class=COLUMNHEADER>Define Filter Criteria</td></tr>");
	sb.append("<tr></tr>");
	sb.append("<tr><td style=\"width: 25%;\" style=\"width: 25%;\" class=COLUMNHEADER>Criteria Name</td>");
	sb.append("<td style=\"width: 25%;\" style=\"width: 25%;\" class=COLUMNHEADER>Actual</td>");
	sb.append("<td style=\"width: 25%;\" style=\"width: 25%;\" class=COLUMNHEADER>Actual Value</td>");
	sb.append("<td style=\"width: 25%;\" style=\"width: 25%;\" class=COLUMNHEADER>Relative</td></tr>");
	sb.append("</table>");
	sb.append("</div>");
	sb.append("<table id=\"dataTable\" border=0 cellspacing=0 cellpadding=3 width=\"100%\" align=center>");

		sql = "select COLUMN_ID, COLUMN_DESC, COLUMN_DATA_TYPE, MAX_LENGTH, DECIMAL_DIGITS, LIST_TYPE, VALUE_APPL_TYPE, DATA_SOURCE_ID, DEP_COL_YN, DEP_COLUMN_ID from SM_QUICK_LINK_CRITERIA where OPTION_ID = ? order by ORDER_SEQ_NO";

		sql1 = "select a.RELATIVE_FIELD_REF, a.RELATIVE_FIELD_DESC, b.DEFAULT_YN from SM_QUICK_LINK_RELV_ITEM_LST a, SM_QUICK_LINK_CRIT_RELV_LNK b where a.RELATIVE_FIELD_REF = b.RELATIVE_FIELD_REF and b.OPTION_ID = ? and b.COLUMN_ID = ?";

		sql2 = "select CHOICE_VAL, CHOICE_DESC from SM_QUICK_LINK_CRIT_VAL where OPTION_ID = ? and COLUMN_ID = ?";

		if(mode.equals("update"))
		{
			sql3 = "select VALUE_TYPE, ACTUAL_VALUE, DATETIME_RELATIVE_IND, DATETIME_RELATIVE_VAL, DATETIME_RELATIVE_UNIT, RELATIVE_FIELD_REF from SM_QUICK_LINK_DEFN where QUICK_LINK_REF = ? and COLUMN_ID = ?";
		}
		
		sql4 = "select SOURCE_SQL from SM_DATA_SOURCE where SOURCE_ID = ? ";

		sql5 = "select sm_get_quick_link_dep_items(?,?) dep_items from dual ";

		sql6 = "SELECT ACTUAL_VALUE FROM SM_QUICK_LINK_DEFN  WHERE COLUMN_ID = ? AND QUICK_LINK_REF =? ";
		sql9 = "SELECT SHORT_DESC FROM OR_ORDER_TYPE WHERE ORDER_TYPE_CODE =? ";

		sql8 = "select DRUG_DESC from ph_drug_lang_vw where  drug_code = ? and LANGUAGE_ID =?";

		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,function_id);
		rs = pstmt.executeQuery();

		while(rs.next())
		{
			depend_value = "";
			column_id = rs.getString("COLUMN_ID") == null ? "" : rs.getString("COLUMN_ID");
			column_desc = rs.getString("COLUMN_DESC") == null ? "" : rs.getString("COLUMN_DESC");
			column_data_type = rs.getString("COLUMN_DATA_TYPE") == null ? "" : rs.getString("COLUMN_DATA_TYPE");
			max_length = rs.getInt("MAX_LENGTH");
			decimal_digits = rs.getInt("DECIMAL_DIGITS");
			list_type = rs.getString("LIST_TYPE") == null ? "" : rs.getString("LIST_TYPE");
			value_appl_type = rs.getString("VALUE_APPL_TYPE") == null ? "" : rs.getString("VALUE_APPL_TYPE");
			data_source_id = rs.getString("DATA_SOURCE_ID") == null ? "" : rs.getString("DATA_SOURCE_ID");
			dep_col_Yn = rs.getString("DEP_COL_YN") == null ? "" : rs.getString("DEP_COL_YN");
			dep_col_Id = rs.getString("DEP_COLUMN_ID") == null ? "" : rs.getString("DEP_COLUMN_ID");
			pstmt5 = con.prepareStatement(sql6);
			pstmt5.setString(1,dep_col_Id);
			pstmt5.setString(2,ql_ref);
			rs5 = pstmt5.executeQuery();
			if(rs5.next())
			{
				depend_value = rs5.getString("ACTUAL_VALUE")==null?"":rs5.getString("ACTUAL_VALUE");
			}
			if(rs5!=null)rs5.close();
			if(pstmt5!=null)pstmt5.close();
			pstmt1 = con.prepareStatement(sql1);
			pstmt1.setString(1,function_id);
			pstmt1.setString(2,column_id);
			rs1 = pstmt1.executeQuery();

			if(mode.equals("update"))
			{
				pstmt3 = con.prepareStatement(sql3);
				pstmt3.setString(1,ql_ref);
				pstmt3.setString(2,column_id);
				rs3 = pstmt3.executeQuery();
				if(rs3.next())
				{
					val_type = rs3.getString("VALUE_TYPE") == null ? "" : rs3.getString("VALUE_TYPE");
					actual_value = rs3.getString("ACTUAL_VALUE") == null ? "" : rs3.getString("ACTUAL_VALUE");
					dt_relative_ind = rs3.getString("DATETIME_RELATIVE_IND") == null ? "" : rs3.getString("DATETIME_RELATIVE_IND");
					dt_relative_val = rs3.getString("DATETIME_RELATIVE_VAL") == null ? "" : rs3.getString("DATETIME_RELATIVE_VAL");
					dt_relative_unit = rs3.getString("DATETIME_RELATIVE_UNIT") == null ? "" : rs3.getString("DATETIME_RELATIVE_UNIT");
					relative_field_ref = rs3.getString("RELATIVE_FIELD_REF") == null ? "" : rs3.getString("RELATIVE_FIELD_REF");
				}
				if(rs3 != null) rs3.close();
				if(pstmt3 != null) pstmt3.close();
			}

			sb.append("<tr>");
			if(column_id.equals("QUEUE_STATUS"))
			{
				sb.append("<td style=\"width: 25%;\" style=\"width: 25%;\" class=label><B>"+column_desc+"</B></td>");
			}
			else
			{
				sb.append("<td style=\"width: 25%;\" style=\"width: 25%;\" class=label>"+column_desc+"</td>");
			}
			sb.append("<input type=hidden id=column_desc"+i+" name=column_desc"+i+" value=\""+column_desc+"\">");
			if(column_data_type.equals("DATETIME"))
			{
				String selBefore = "", selAfter = "";
				String selHour = "", selDay = "", selMonth = "", selYear = "";

				if(mode.equals("update"))
				{
					if(dt_relative_ind.equals("B"))
					{
						selBefore = "selected";
						selAfter = "";
					}
					else if(dt_relative_ind.equals("A"))
					{
						selBefore = "";
						selAfter = "selected";
					}
					if(dt_relative_unit.equals("h"))
					{
						selHour = "selected";
						selDay = "";
						selMonth = "";
						selYear = "";
					}
					else if(dt_relative_unit.equals("d"))
					{
						selHour = "";
						selDay = "selected";
						selMonth = "";
						selYear = "";
					}
					else if(dt_relative_unit.equals("M"))
					{
						selHour = "";
						selDay = "";
						selMonth = "selected";
						selYear = "";
					}
					else if(dt_relative_unit.equals("Y"))
					{
						selHour = "";
						selDay = "";
						selMonth = "";
						selYear = "selected";
					}
				}
				sb.append("<td style=\"width: 25%;\" style=\"width: 25%;\" class=fields><select name=date_ind"+i+">");
				sb.append("<option value=\"\">---Select---</option>");
				sb.append("<option value=B "+selBefore+">Before</option>");
				//if((function_id.equals("FLOW_SHEET"))||(function_id.equals("PREVIOUS_NOTES")))//Commented for IN051294
				//if((function_id.equals("FLOW_SHEET"))||(function_id.equals("PREVIOUS_NOTES"))||(function_id.equals("PHYSICIAN_NOTES"))||)) //20101.3
				if((function_id.equals("FLOW_SHEET"))||(function_id.equals("PREVIOUS_NOTES"))||(function_id.equals("PHYSICIAN_NOTES"))||(function_id.equals("FLOW_SHEET_NEW"))) //Added for IN069654
					sb.append("<option value=A "+selAfter+">After</option></select></td>");

				sb.append("<td style=\"width: 25%;\" style=\"width: 25%;\" class=fields><input type=text id=noOfDays"+i+" name=noOfDays"+i+" value=\""+dt_relative_val+"\" size=4 maxlength=4 OnKeyPress =\"return(ChkNumberInput(this,event,0))\">");

				sb.append("<select name=value_ind"+i+"><option value=\"\">---Select---</option>");
				//if(!(function_id.equals("BY_LOCATION")&&(column_id.equals("PERIOD_FROM")||column_id.equals("PERIOD_TO"))))//Commented for IN051294
				if(!(function_id.equals("BY_LOCATION")||function_id.equals("PHYSICIAN_NOTES")&&(column_id.equals("PERIOD_FROM")||column_id.equals("PERIOD_TO")))) //Added for IN051294
				{
					sb.append("<option value=h "+selHour+">Hours</option>");
				}
				
				sb.append("<option value=d "+selDay+">Days</option>");
				sb.append("<option value=M "+selMonth+">Months</option>");
				sb.append("<option value=Y "+selYear+">Years</option></select></td>");

				sb.append("<td style=\"width: 25%;\" style=\"width: 25%;\" class=label>From&nbsp;");
				sb.append("<select name=relative_val"+i+"><option value=\"\">---Select---</option>");
				while(rs1.next())
				{
					System.out.println("DefineQuickLinksIntermediate.jsp----------------------------->"+rs1.getString("RELATIVE_FIELD_DESC"));
					relative_ref = rs1.getString("RELATIVE_FIELD_REF") == null ? "" : rs1.getString("RELATIVE_FIELD_REF");
					relative_desc = rs1.getString("RELATIVE_FIELD_DESC") == null ? "" : rs1.getString("RELATIVE_FIELD_DESC");
					default_yn = rs1.getString("DEFAULT_YN") == null ? "N" : rs1.getString("DEFAULT_YN");
					if(relative_field_ref.equals(""))
					{
						if(default_yn.equals("Y"))
							sel = "selected";
						else
							sel = "";
					}
					else
					{
						if(relative_field_ref.equals(relative_ref))
							sel = "selected";
						else
							sel = "";
					}
					sb.append("<option value="+relative_ref+" " +sel+">"+relative_desc+"</option>");
				}
				sb.append("</select></td>");
				sb.append("<input type=hidden id=actual_val"+i+" name=actual_val"+i+" value=\"\">");
				sb.append("<input type=hidden id=actual_val"+i+" name=value_type"+i+" value=\"R\">");
			}
			else
			{
				sb.append("<input type=hidden id=date_ind"+i+" name=date_ind"+i+" value=\"\">");
				sb.append("<input type=hidden id=noOfDays"+i+" name=noOfDays"+i+" value=\"\">");
				sb.append("<input type=hidden id=value_ind"+i+" name=value_ind"+i+" value=\"\">");
			}
			if(column_data_type.equals("CHECKBOX"))
			{
				if(actual_value.equals("Y"))
				{
					chk_val = "Y";
					field_check = "checked";
				}
				else
				{
					chk_val = "N";
					field_check = "";
				}
				pstmt4 = con.prepareStatement(sql5);
				pstmt4.setString(1,function_id);
				pstmt4.setString(2,column_id);
				rs4 = pstmt4.executeQuery();
				if(rs4.next())
				{
					dependency = rs4.getString(1);
				}
				else
					dependency = "";
				if(rs4 != null) rs4.close();
				if(pstmt4 != null) pstmt4.close();
				
				if(grphistory_type.equals("MEDN")||grphistory_type.equals("CLNT")||grphistory_type.equals("SUNT")||grphistory_type.equals("MERP"))//IN072762//6450
					disable_field = "disabled";//IN072762
				else
					disable_field = "";//IN072762

				sb.append("<td style=\"width: 25%;\" class=fields>&nbsp;</td>");
				if(column_id.equals("QUEUE_STATUS"))
				{
					sb.append("<td style=\"width: 25%;\" class=fields>&nbsp;</td>");
				}
				else
				{
					sb.append("<td style=\"width: 25%;\" class=fields><input type=checkbox id=actual_val"+i+" name=actual_val"+i+" value=\""+chk_val+"\" onclick=\"makeEnable(this,"+i+");\" "+field_check+" "+disable_field+"></td>");
				}
				sb.append("<td style=\"width: 25%;\" class=fields>&nbsp;</td>");
				sb.append("<input type=hidden id=relative_val"+i+" name=relative_val"+i+" value=\"\">");
				sb.append("<input type=hidden id=value_type"+i+" name=value_type"+i+" value=\"A\">");
				sb.append("<input type=hidden id=dependency"+i+" name=dependency"+i+" value=\""+dependency+"\">");
			}
			if(column_data_type.equals("LIST") || column_data_type.equals("NUMERIC"))
			{
				if(mode.equals("update"))
				{
					if(val_type.equals("A"))
					{
						actual_checked = "checked";
						actual_enabled = "";
						relative_enabled = "disabled";
					}
					else
					{
						actual_checked = "";
						actual_enabled = "disabled";
						relative_enabled = "";
					}
				}
				else
				{
					if(value_appl_type.equals("R"))
						relative_enabled = "";
					else
						relative_enabled = "disabled";
				}

				if(!value_appl_type.equals("R") && !value_appl_type.equals("A"))
					sb.append("<td style=\"width: 25%;\" class=fields><input type=checkbox id=actual_check"+i+" name=actual_check"+i+" onclick=\"enableActual(this,"+i+");\" "+actual_checked+"></td>");
				else
					sb.append("<td style=\"width: 25%;\" class=fields>&nbsp;</td>");

				if(column_data_type.equals("NUMERIC"))
				{
					if(!value_appl_type.equals("R"))
					{
						if(!mode.equals("update"))
						{
							val_type = "A";
						}
						sb.append("<td style=\"width: 25%;\" class=fields><input type=text id=actual_val"+i+" name=actual_val"+i+" value=\""+actual_value+"\" maxlength=12 size=13 "+actual_enabled+"></td>");
						sb.append("<input type=hidden id=value_type"+i+" name=value_type"+i+" value=\""+val_type+"\">");
					}
					else
					{
						val_type = "R";
						sb.append("<td style=\"width: 25%;\" class=fields>&nbsp;</td>");
						sb.append("<input type=hidden id=actual_val"+i+" name=actual_val"+i+" value=\"\">");
						sb.append("<input type=hidden id=value_type"+i+" name=value_type"+i+" value=\""+val_type+"\">");
					}
					sb.append("<td style=\"width: 25%;\" class=fields><select name=relative_val"+i+" "+relative_enabled+">");
					sb.append("<option value=\"\">---Select---</option>");

					while(rs1.next())
					{
						relative_ref = rs1.getString("RELATIVE_FIELD_REF") == null ? "" : rs1.getString("RELATIVE_FIELD_REF");
						relative_desc = rs1.getString("RELATIVE_FIELD_DESC") == null ? "" : rs1.getString("RELATIVE_FIELD_DESC");
						default_yn = rs1.getString("DEFAULT_YN") == null ? "N" : rs1.getString("DEFAULT_YN");
						if(relative_field_ref.equals(""))
						{
							if(default_yn.equals("Y"))
								sel = "selected";
							else
								sel = "";
						}
						else
						{
							if(relative_field_ref.equals(relative_ref))
								sel = "selected";
							else
								sel = "";
						}
						sb.append("<option value="+relative_ref+" " +sel+">"+relative_desc+"</option>");
					}
					sb.append("</select></td>");
				}
				if(column_data_type.equals("LIST"))
				{
					if(!mode.equals("update"))
					{
						val_type = "A";
					}
					if(list_type.equals("F"))
					{
						if(!mode.equals("update"))
						{
							if(dep_col_Yn.equals("Y") && !value_appl_type.equals("B"))
							{
								actual_enabled = "";
							}
							else if(dep_col_Yn.equals("Y"))
								actual_enabled="disabled";
							else
								actual_enabled = "";

						}else if(mode.equals("update"))
						{	//sb.append("HAI");
							if(map.containsKey(dep_col_Id))
							{	//sb.append("HAI1");
								if(dep_col_Yn.equals("Y") && !value_appl_type.equals("B"))
							{
									actual_enabled = "disabled";
							}
							else if(dep_col_Yn.equals("Y"))
								actual_enabled="";
							else
								actual_enabled = "";
							}
							else{//sb.append("HAI2");
							if(dep_col_Yn.equals("Y") && !value_appl_type.equals("B"))
							{
									actual_enabled = "";
							}
							else if(dep_col_Yn.equals("Y"))
								actual_enabled="disabled";
							else
								actual_enabled = "";
							}
							//else
								//actual_enabled = "disabled";
							
							/*if(dep_col_Yn.equals("Y"))
							{
								actual_enabled = "disabled";
							}
							else
								actual_enabled = "";*/
							
							}
							if(grphistory_type.equals("MEDN") || grphistory_type.equals("CLNT") || grphistory_type.equals("SUNT")||grphistory_type.equals("MERP") && (column_id.equals("VIEW_BY") || column_id.equals("NORMALCY_IND")))//Added for IN072762//6450
							        actual_enabled="disabled";//Added for IN072762
						if((grphistory_type.equals("CLNT") || grphistory_type.equals("SUNT") || grphistory_type.equals("RDIN")||grphistory_type.equals("MERP")) && (column_id.equals("VIEW_BY")))//Added for IN072762//6450
					        actual_enabled="disabled";
					
								
						sb.append("<td style=\"width: 25%;\" class=fields><select id=actual_val"+i+" name=actual_val"+i+" "+actual_enabled+">");
						if(function_id.equals("PREVIOUS_NOTES"))
							sb.append("<option value=\"\">All</option>");
						else
							sb.append("<option value=\"\">---Select---</option>");


						pstmt2 = con.prepareStatement(sql2);
						pstmt2.setString(1,function_id);
						pstmt2.setString(2,column_id);
						rs2 = pstmt2.executeQuery();
						while(rs2.next())
						{
							choice_val = rs2.getString("CHOICE_VAL") == null ? "" : rs2.getString("CHOICE_VAL");
							choice_desc = rs2.getString("CHOICE_DESC") == null ? "" : rs2.getString("CHOICE_DESC");
							if(actual_value.equals(choice_val))
								sel = "selected";
							else
								sel = "";
							sb.append("<option value="+choice_val+" "+sel+">"+choice_desc+"</option>");
						}
						if(rs2 != null) rs2.close();
						if(pstmt2 != null) pstmt2.close();

						sb.append("</select></td>");
						if(!value_appl_type.equals("A"))
						{
							sb.append("<td style=\"width: 25%;\" class=fields><select name=relative_val"+i+" "+relative_enabled+">");
							sb.append("<option value=\"\">---Select---</option>");

							while(rs1.next())
							{
								relative_ref = rs1.getString("RELATIVE_FIELD_REF") == null ? "" : rs1.getString("RELATIVE_FIELD_REF");
								relative_desc = rs1.getString("RELATIVE_FIELD_DESC") == null ? "" : rs1.getString("RELATIVE_FIELD_DESC");
								default_yn = rs1.getString("DEFAULT_YN") == null ? "N" : rs1.getString("DEFAULT_YN");
								if(relative_field_ref.equals(""))
								{
									if(default_yn.equals("Y"))
										sel = "selected";
									else
										sel = "";
								}
								else
								{
									if(relative_field_ref.equals(relative_ref))
										sel = "selected";
									else
										sel = "";
								}
								sb.append("<option value="+relative_ref+" " +sel+">"+relative_desc+"</option>");
							}
							sb.append("</select></td>");
						}
						else
							sb.append("<input type=hidden id=relative_val"+i+" name=relative_val"+i+" value=\"\">");
						sb.append("<input type=hidden id=value_type"+i+" name=value_type"+i+" value=\""+val_type+"\">");
					}
					if(list_type.equals("V"))
					{
						if(grphistory_type.equals("MERP") &&(column_id.equals("EVENT_GROUP")||column_id.equals("EVENT_CLASS")||column_id.equals("EVENT_ITEM")))
							 actual_enabled="disabled";
						if(!mode.equals("update"))
						{
							if(dep_col_Yn.equals("Y") && !value_appl_type.equals("B"))
							{
								actual_enabled = "disabled";
							}
							if(!dep_col_Yn.equals("Y") && value_appl_type.equals("B"))
							{
								actual_enabled = "";
							}
							//else
								//actual_enabled = "";
						}
						pstmt4 = con.prepareStatement(sql4);
						pstmt4.setString(1,data_source_id);
						rs4 = pstmt4.executeQuery();
						if(rs4.next())
						{
							data_source_sql = rs4.getString(1) == null ? "" : rs4.getString(1);
						}
						if(rs4 != null) rs4.close();
						if(pstmt4 != null) pstmt4.close();
						
						if(mode.equals("update"))
						{
							if(!dep_col_Id.equals(""))
							{
								if(!value_appl_type.equals("B")){
								if(map.containsKey(dep_col_Id))
								{
									actual_enabled = "";
									depend_value = (String)map.get(dep_col_Id);
								}
								else
								{
									if(dep_col_Id.equals("Y"))
									 {
									actual_enabled = "disabled";
									 }
									 else
									 {
										actual_enabled = "";
									 }
									depend_value = "";
								}
								}
								else
								{
								if(map.containsKey(dep_col_Id) && dep_col_Id.equals("Y"))
								{
									actual_enabled = "disabled";
									depend_value = (String)map.get(dep_col_Id);
								}
								}
									
							}
							else
							{
								if(val_type.equals("R"))
								{
									actual_enabled = "disabled";
								}
								else
									actual_enabled = "";
								depend_value = "";
							}

							if(!data_source_sql.equals(""))
							{
								String data_source_sql1 = data_source_sql;
								if(data_source_sql1.indexOf("~") != -1)
								{
									data_source_sql1 = data_source_sql1.replaceAll("~","'");
								}
								if(data_source_sql1.indexOf("&&") != -1)
								{
									String retVal[] = null; 
									int count = 0;
									if(data_source_sql1.indexOf("&&") == data_source_sql1.lastIndexOf("&&"))
										retVal = new String[2];
									else
									{
										int start_index = 0;
										while (true)
										{
											start_index = data_source_sql1.indexOf("&&", start_index);
											if(start_index == -1)
												break;
											else
											{
												count++;
												start_index += 2;
											}
										}
										retVal = new String[count+1];
									}
									count = 1;
									while(data_source_sql1.indexOf("&&") != -1)
									{
										int start_index = data_source_sql1.indexOf("&&");
										int end_index = data_source_sql1.indexOf("##");
										String paramValue = data_source_sql1.substring(start_index+2, end_index);
										String substr = data_source_sql1.substring(start_index,end_index+2);
										data_source_sql1 = data_source_sql1.replaceFirst(substr,"?");
										retVal[count] = paramValue;
										count++;
									}
									retVal[0] = data_source_sql1.toString();

									int setStringCount = 1;
									pstmt4 = con.prepareStatement(retVal[0]);
									
									for(int l=1;l<retVal.length;l++)
									{
										String param = retVal[l];
										if(param.equals("LANGUAGE_ID"))
											pstmt4.setString(setStringCount++, locale);
										else if(param.equals("FACILITY_ID"))
											pstmt4.setString(setStringCount++,facilityId);
										else if(param.equals("PRACTITIONER_ID"))
											pstmt4.setString(setStringCount++,clinician_id);
										else if(param.equals("PRACT_TYPE"))
											pstmt4.setString(setStringCount++,pract_type);
										//IN069654 starts
										if(function_id.equals("FLOW_SHEET_NEW"))
										{
											
											 if(param.equals("HIST_REC_TYPE"))
												pstmt4.setString(setStringCount++,grphistory_type);
										}
										//IN069654 ends
										else if(param.equals(dep_col_Id))
										{
											String paramVal = "";
											if(map.containsKey(dep_col_Id))
												paramVal = (String)map.get(dep_col_Id);
											//Added By Jyothi on 02/06/2010 to fix IN020967
											if(function_id.equals("BY_LOCATION") && param.equals("PATIENT_CLASS"))
											{
												if(paramVal.equals("IP") || paramVal.equals("DC"))
													pstmt4.setString(setStringCount++, "W");
												else if(paramVal.equals("OP") || paramVal.equals("EM"))
													pstmt4.setString(setStringCount++, "C");
												else
													pstmt4.setString(setStringCount++, "");
											}
											else
												pstmt4.setString(setStringCount++, paramVal);
										}
									}
									pstmt4.setString(setStringCount++, "%");

									pstmt4.setString(setStringCount++, actual_value);
								}
								else
								{
									pstmt4 = con.prepareStatement(data_source_sql1);
									pstmt4.setString(1, "%");
									pstmt4.setString(2, actual_value);
								}
								rs4 = pstmt4.executeQuery();
								if(rs4.next())
								{
									actual_text = rs4.getString(2);
								}
								else
									actual_text = "";
								if(rs4 != null) rs4.close();
								if(pstmt4 != null) pstmt4.close();
							}
							else
								actual_text = "";
							
						}
						else
							actual_text = "";
						pstmt4 = con.prepareStatement(sql5);
						pstmt4.setString(1,function_id);
						pstmt4.setString(2,column_id);
						rs4 = pstmt4.executeQuery();
						if(rs4.next())
						{
							dependency = rs4.getString(1);
							
						}
						else
							dependency = "";

						if(rs4 != null) rs4.close();
						if(pstmt4 != null) pstmt4.close();
			                     //Adding start for IN072762
						if(mode.equals("update")){
							if(grphistory_type.equals("MEDN") && column_id.equals("EVENT_CLASS") && !actual_value.equals("")){
								pstmt7 = con.prepareStatement(sql9);
								pstmt7.setString(1,actual_value);
								rs7 = pstmt7.executeQuery();
								if(rs7.next())
								{
									actual_text = rs7.getString("SHORT_DESC") == null ? "" : rs7.getString("SHORT_DESC");
									
								}
								if(rs7 != null) rs7.close();
								if(pstmt7 != null) pstmt7.close();
							
						     }
							if(grphistory_type.equals("MEDN") && column_id.equals("EVENT_ITEM") && !actual_value.equals("")){
								pstmt8 = con.prepareStatement(sql8);
								pstmt8.setString(1,actual_value);
								pstmt8.setString(2,locale);
								rs8 = pstmt8.executeQuery();
								if(rs8.next())
								{
									actual_text = rs8.getString("DRUG_DESC") == null ? "" : rs8.getString("DRUG_DESC");
									
								}
								if(rs8 != null) rs8.close();
								if(pstmt8 != null) pstmt8.close();
							 }
							   if(grphistory_type.equals("MEDN") && column_id.equals("EVENT_GROUP") && !actual_value.equals("")){
								   if(actual_value.equals("D"))
									   sel_d ="selected";
								   if(actual_value.equals("E"))
									   sel_e ="selected";
								   if(actual_value.equals("M"))
									   sel_m ="selected";
                                    
							   }
							}//Adding end for IN072762
						if(!grphistory_type.equals("MEDN") ){ //added if condition forIN072762
						//sb.append("<input type=text name=actual_val"+i+" value=\""+dependency+"\">");
						sb.append("<td style=\"width: 25%;\" class=fields  id="+column_id+"><input type=text id=actual_val_text"+i+" name=actual_val_text"+i+" value=\""+actual_text+"\" maxlength=16 size=16 onblur=\"openLookup1(this,"+i+")\" "+actual_enabled+"><input type=button class=button value=? id=search_ref"+i+" name=search_ref"+i+" onclick=\"openLookup("+i+")\" "+actual_enabled+"><input type=hidden id=actual_val"+i+" name=actual_val"+i+" value=\""+actual_value+"\">");//TD id added for IN072762
						}else if (grphistory_type.equals("MEDN") && column_id.equals("EVENT_GROUP")){//Adding start for IN072762
							sb.append("<td style=\"width: 25%;\" class=fields id="+column_id+"><select id=actual_val_text"+i+" name=actual_val_text"+i+"  "+actual_enabled+" onchange =\"assignevngrp(this,"+i+")\">" );
							sb.append("<option value=\"\">---Select---</option>");
							sb.append("<option value=\"D\" " +sel_d+"> Drug Item </option>");
							sb.append("<option value=\"E\" " +sel_e+">External Drug</option>");
							sb.append("<option value=\"M\" " +sel_m+">Medical Item</option>");
							sb.append("<input type=hidden id=actual_val"+i+" name=actual_val"+i+" value=\""+actual_value+"\">");
							//sb.append("<option value="+relative_ref+" " +sel+">"+relative_desc+"</option>");
						}else if(grphistory_type.equals("MEDN") && !column_id.equals("EVENT_GROUP") ){
						//sb.append("<input type=text name=actual_val"+i+" value=\""+dependency+"\">");
						sb.append("<td style=\"width: 25%;\" class=fields id="+column_id+"><input type=text id=actual_val_text"+i+" name=actual_val_text"+i+" value=\""+actual_text+"\" maxlength=16 size=16 onblur=\"openLookup1(this,"+i+")\" "+actual_enabled+"><input type=button class=button value=? id=search_ref"+i+" name=search_ref"+i+" onclick=\"openLookup("+i+")\" "+actual_enabled+"><input type=hidden id=actual_val"+i+" name=actual_val"+i+" value=\""+actual_value+"\">");
						
						}//Adding end for IN072762
						sb.append("</td>");
						sb.append("<input type=hidden id=query"+i+" name=query"+i+" value=\""+data_source_sql+"\">");
						sb.append("<input type=hidden id=value_type"+i+" name=value_type"+i+" value=\""+val_type+"\">");
						sb.append("<input type=hidden id=dependency"+i+" name=dependency"+i+" value=\""+dependency+"\">");
						sb.append("<input type=hidden id=depend_value"+i+" name=depend_value"+i+" value=\""+depend_value+"\">");
						
						if(!value_appl_type.equals("A"))
						{
							sb.append("<td style=\"width: 25%;\" class=fields><select name=relative_val"+i+" "+relative_enabled+">");
							sb.append("<option value=\"\">---Select---</option>");
							while(rs1.next())
							{
								relative_ref = rs1.getString("RELATIVE_FIELD_REF") == null ? "" : rs1.getString("RELATIVE_FIELD_REF");
								relative_desc = rs1.getString("RELATIVE_FIELD_DESC") == null ? "" : rs1.getString("RELATIVE_FIELD_DESC");
								default_yn = rs1.getString("DEFAULT_YN") == null ? "N" : rs1.getString("DEFAULT_YN");
								if(relative_field_ref.equals(""))
								{
									if(default_yn.equals("Y"))
										sel = "selected";
									else
										sel = "";
								}
								else
								{
									if(relative_field_ref.equals(relative_ref))
										sel = "selected";
									else
										sel = "";
								}
								sb.append("<option value="+relative_ref+" " +sel+">"+relative_desc+"</option>");
							}
							if(rs1 != null) rs1.close();
							if(pstmt1 != null) pstmt1.close();
							if(rst1 != null) rst1.close();
							if(pstm1 != null) pstm1.close();
							sb.append("</select></td>");
						}
						else
							sb.append("<input type=hidden id=relative_val"+i+" name=relative_val"+i+" value=\"\">");
					}
				}
			}
			sb.append("</tr>");
			sb.append("<input type=hidden id=column_id"+i+" name=column_id"+i+" value=\""+column_id+"\">");
			sb.append("<input type=hidden id=column_type"+i+" name=column_type"+i+" value=\""+column_data_type+"\">");
			sb.append("<input type=hidden id=list_type"+i+" name=list_type"+i+" value=\""+list_type+"\">");
			sb.append("<input type=hidden id=dep_col_Id"+i+" name=dep_col_Id"+i+" value=\""+dep_col_Id+"\">");
			i = i + 1;
			if(mode.equals("update"))
			{
				if(val_type.equals("A"))
				{
					if(column_data_type.equals("CHECKBOX"))
					{
						if(actual_value.equals("Y")){
							map.put(column_id,actual_value);}
					}
					else
					{
						if(!actual_value.equals(""))
							map.put(column_id,actual_value);
					}
				}
				else if(val_type.equals("R"))
				{
					if(!relative_field_ref.equals(""))
						map.put(column_id,relative_field_ref);
				}
			}
			
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		
		sb.append("<tr style=\"visibility:hidden\" ><td style=\"width: 25%;\" class=COLUMNHEADER>Criteria Name</td>");
		sb.append("<td style=\"width: 25%;\" class=COLUMNHEADER>Actual</td>");
		sb.append("<td style=\"width: 25%;\" class=COLUMNHEADER>Actual Value</td>");
		sb.append("<td style=\"width: 25%;\" class=COLUMNHEADER>Relative</td></tr>");
		
		sb.append("</table>");
	}
	
	//IN073728
    String sbStr = sb.toString() ;
	
	out.println("document.getElementById('criteria').innerHTML = '" + sbStr + "';");
	out.println("document.getElementById('count').value = '"+i+"'");
    out.println("alignWidth();"); 
    
     if(map != null) map.clear();
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	finally
	{
		if(con != null) 
			ConnectionManager.returnConnection(con,request);
	}

%>
