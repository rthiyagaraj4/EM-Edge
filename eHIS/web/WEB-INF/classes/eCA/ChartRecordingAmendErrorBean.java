/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
?             100            ?           created
21/02/2013    IN037946      Chowminya G     Remarks - while marking all the event as error for the ‘Formula Component’
--------------------------------------------------------------------------------------------------------
*/
package eCA;
import java.util.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;
import webbeans.eCommon.*;

public class ChartRecordingAmendErrorBean
{
    //private String chartId;
    //private String descrMsrIds;
    String defaultYN = "";
    private Connection con;
    private PreparedStatement pstmt;
    //private PreparedStatement pstmt1;
	
    private ResultSet res;
    //private ResultSet rs1;
    //private ArrayList arrList;
    private ArrayList stringArray =null;
    private ArrayList stringArrayDiscr =null;
    private ArrayList stringArrayErrorYN =null;
    //private ArrayList discrArray =null;
	private HashMap hashForm = null;

    //private int index;
    private int i = 0;
	int formulaCount = 0;
    private StringBuffer displayString = null;
	//private StringBuffer displayStringFormula = null;

    //private String summationFormula="0";
    private String globalSummationFormula="0";
    //private String shortDesc,groupHeading,uom,graph;
    //private StringBuffer component = null;
    //private String prevGroupId="",normalInd="", associate_score_yn="";
    private String classValue="gridDataChart";


    String chartName = "";

    String sql ="";
		
	/*"select a.DISCR_MSR_PANEL_OR_FORM_ID, a.DISCR_MSR_ID, a.DISCR_MSR_RESULT_NUM, a.DISCR_MSR_RESULT_NUM_UOM, a.DISCR_MSR_RESULT_STR, a.DISCR_MSR_RESULT_DATA, a.DISCR_MSR_RESULT_TYPE, a.ACCESSION_NUM, G.short_desc, I.short_desc, a.NORMAL_LOW, a.NORMAL_HIGH, a.CRITICAL_LOW, a.CRITICAL_HIGH, I.NUM_DIGITS_MAX, I.NUM_DIGITS_MIN, I.NUM_DIGITS_DEC, I.ASSOCIATE_SCORE_YN,CA_GET_FORMULA_STRING(b.FORMULA_DEF) FORMULA_DEF from ca_encntr_discr_msr a, CA_CHART_SECTION_COMP b, AM_DISCR_MSR G, AM_DISCR_MSR I where a.CHART_ID = ? and a.TEST_OBSERV_DT_TM = to_date(?,'DD/MM/YYYY HH24:MI') and nvl(ERROR_YN,'N') != 'Y' and b.CHART_ID  =a.CHART_ID   and b.PANEL_ID  =a.DISCR_MSR_PANEL_OR_FORM_ID and b.DISCR_MSR_ID=a.DISCR_MSR_ID AND G.DISCR_MSR_ID=a.DISCR_MSR_PANEL_OR_FORM_ID AND I.DISCR_MSR_ID=a.DISCR_MSR_ID order by B.PANEL_DISP_ORDER_SEQ,B.DISCR_DISP_ORDER_SEQ";*/

	public void loadGrpDiscrId(HttpServletRequest request, String chartID, String currDate,String patientId, String locale)
	{
		sql = "select b.PANEL_ID DISCR_MSR_PANEL_OR_FORM_ID, b.DISCR_MSR_ID, a.DISCR_MSR_RESULT_NUM, a.DISCR_MSR_RESULT_NUM_UOM, a.DISCR_MSR_RESULT_STR, a.DISCR_MSR_RESULT_DATA, b.DISCR_MSR_TYPE DISCR_MSR_RESULT_TYPE, a.ACCESSION_NUM, AM_GET_DESC.AM_DISCR_MSR(b.PANEL_ID,?,'2') short_desc, AM_GET_DESC.AM_DISCR_MSR(b.discr_msr_id,?,'2') short_desc, a.NORMAL_LOW, a.NORMAL_HIGH, a.CRITICAL_LOW, a.CRITICAL_HIGH, I.NUM_DIGITS_MAX, I.NUM_DIGITS_MIN, I.NUM_DIGITS_DEC, I.ASSOCIATE_SCORE_YN,CA_GET_FORMULA_STRING(b.FORMULA_DEF) FORMULA_DEF, nvl(a.ERROR_YN,'N') err_yn from ca_encntr_discr_msr a, CA_CHART_SECTION_COMP b, AM_DISCR_MSR I where b.CHART_ID = ? and a.patient_id(+) = ? and a.TEST_OBSERV_DT_TM (+)= to_date(?,'DD/MM/YYYY HH24:MI') and nvl(a.ERROR_YN(+),'N') = 'N' and b.CHART_ID  =a.CHART_ID(+)   and b.PANEL_ID  =a.DISCR_MSR_PANEL_OR_FORM_ID(+) and b.DISCR_MSR_ID=a.DISCR_MSR_ID(+)  AND I.DISCR_MSR_ID=b.DISCR_MSR_ID order by B.PANEL_DISP_ORDER_SEQ,B.DISCR_DISP_ORDER_SEQ";

		String discrMsrID = "";
		String grpID = "";
		String stringForList = "";
		String errYN = "";
		int index = 0; 
		stringArray = new ArrayList();
		stringArrayDiscr = new ArrayList();
		stringArrayErrorYN = new ArrayList();

		try
		{
			con = ConnectionManager.getConnection(request);
            pstmt = con.prepareStatement(sql);
			pstmt.setString(1,locale);
			pstmt.setString(2,locale);
			pstmt.setString(3,chartID);
			pstmt.setString(4,patientId);
			pstmt.setString(5,currDate);
			res = pstmt.executeQuery();

			while(res.next())
			{
				discrMsrID = res.getString(2) == null ? "" : res.getString(2);
				grpID = res.getString(1) == null ? "" : res.getString(1);
				errYN = res.getString("err_yn") == null ? "" : res.getString("err_yn");

				stringForList = grpID+"_"+discrMsrID;
				stringArray.add(index,stringForList);
				stringArrayDiscr.add(index,discrMsrID);
				stringArrayErrorYN.add(index,errYN);
				index++;
			}



			if(res != null) res.close();
			if(pstmt != null) pstmt.close();
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		finally
		{
			if(con != null) ConnectionManager.returnConnection(con);
		}
	}

	public void addtoHashMap(HttpServletRequest request, String chartID, String currDate,String patientId, String locale)
	{
		String formulaDef = "";
		String summationFormula = "";
		//String dispForm = "";
		String discrMsrNum = "";
		String discrMsrResultType = "";
		//String summFormula = "";
		String associateScoreYN = "";
		String discrMsrID = "";
		String grpID = "";
		String errYN = "";
		//String tempStr = "";

		
		//int index = 0; 
		hashForm = new HashMap();
		displayString = new StringBuffer();

		try
		{
			con = ConnectionManager.getConnection(request);
            pstmt = con.prepareStatement(sql);
			pstmt.setString(1,locale);
			pstmt.setString(2,locale);
			pstmt.setString(3,chartID);
			pstmt.setString(4,patientId);
			pstmt.setString(5,currDate);
			res = pstmt.executeQuery();

			while(res.next())
			{
				discrMsrNum = res.getString(3) == null ? "" : res.getString(3);
				formulaDef = res.getString("FORMULA_DEF") == null ? "" : res.getString("FORMULA_DEF");

				discrMsrResultType = res.getString(7) == null ? "" : res.getString(7);
				associateScoreYN = res.getString(18) == null ? "" : res.getString(18);
				discrMsrID = res.getString(2) == null ? "" : res.getString(2);
				grpID = res.getString(1) == null ? "" : res.getString(1);
				errYN = res.getString("err_yn") == null ? "" : res.getString("err_yn");
				if(errYN.equals("Y"))
				{
					discrMsrNum = "0";
					//formulaCount--;
				}
				else
				{
					discrMsrNum = discrMsrNum;
				}

				displayString.append("<input type='hidden' name='custom_"+grpID+"_"+discrMsrID+"' value='"+discrMsrNum+"'>");
				displayString.append("<input type='hidden' name='formulaString'>");
				//displayString.append("<input type='hidden' name='formula_comp_hidden_"+grpID+"_"+discrMsrID+"'>");

				if(discrMsrResultType.equals("A"))
				{
					displayString.append("<input type='hidden' name='formulaString1' value='"+formulaDef+"'>");
					summationFormula = constructFormula(formulaDef);
					globalSummationFormula = summationFormula;
				}
				else
				{
					summationFormula = "0";
				}

				//hashForm.put(grpID+"_"+discrMsrID,summationFormula);
				hashForm.put(grpID+"_"+discrMsrID,formulaDef);
				hashForm.put("evaluated"+grpID+"_"+discrMsrID,summationFormula);
				//index++;
			}

			if(res != null) res.close();
			if(pstmt != null) pstmt.close();
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		finally
		{
			if(con != null) ConnectionManager.returnConnection(con);
		}
	}


   public StringBuffer amendErrorScreen(HttpServletRequest request,String chartID, String currDate,String patientId, String locale)
   {
		java.util.Locale loc = new java.util.Locale(locale);

		java.util.ResourceBundle common_labels	= java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
		//java.util.ResourceBundle ca_labels		= java.util.ResourceBundle.getBundle( "eCA.resources.Labels",loc);

	   sql = "select a.DISCR_MSR_PANEL_OR_FORM_ID, a.DISCR_MSR_ID, a.DISCR_MSR_RESULT_NUM, a.DISCR_MSR_RESULT_NUM_UOM, a.DISCR_MSR_RESULT_STR, a.DISCR_MSR_RESULT_DATA, a.DISCR_MSR_RESULT_TYPE, a.ACCESSION_NUM,  AM_GET_DESC.AM_DISCR_MSR(a.discr_msr_panel_or_form_id,?,'2') short_desc, AM_GET_DESC.AM_DISCR_MSR(A.DISCR_MSR_ID,?,'2') short_desc, a.NORMAL_LOW, a.NORMAL_HIGH, a.CRITICAL_LOW, a.CRITICAL_HIGH, I.NUM_DIGITS_MAX, I.NUM_DIGITS_MIN, I.NUM_DIGITS_DEC, I.ASSOCIATE_SCORE_YN, I.MIN_VALUE, I.MAX_VALUE, CA_GET_FORMULA_STRING(b.FORMULA_DEF) FORMULA_DEF, a.RESULT_NUM_PREFIX from ca_encntr_discr_msr a, CA_CHART_SECTION_COMP b,  AM_DISCR_MSR I where a.CHART_ID = ? and a.patient_id = ? and a.TEST_OBSERV_DT_TM = to_date(?,'DD/MM/YYYY HH24:MI') and nvl(ERROR_YN,'N') != 'Y' and b.CHART_ID  =a.CHART_ID   and b.PANEL_ID  =a.DISCR_MSR_PANEL_OR_FORM_ID and b.DISCR_MSR_ID=a.DISCR_MSR_ID  AND I.DISCR_MSR_ID=a.DISCR_MSR_ID order by B.PANEL_DISP_ORDER_SEQ,B.DISCR_DISP_ORDER_SEQ";

		String discrMsrID = "";
		String grpID = "";
		String discrMsrNum = "";
		String discrMsrUOM = "";
		String tempStringArray = "";
		String tempStringGrpDiscr = "";
		String discrMsrResultType = "";
		String accessionNumber = "";
		String chartGrpDesc = "";
		String discrMsrDesc = "";
		String normalLow = "";
		String normalHigh = "";
		String criticalLow = "";
		String criticalHigh = "";
		String associateScoreYN = "";
		String formulaDef = "";
		String displayStringValue = "";
		String dispOnChange = "";
		String summFormula = "0";
		String dispForm = "";
		String ValidNumForNNI = "";
		String validityNum = "";
		String discrMsrResultStr = "";
		String prevGrpId = "";
		String displayObject = "";
		String disableSelect = "";
		String textReadOnly = "";
		String constructedFormula = "";
		String hiddenNumValue = "";
		String selectedValue = "";
		String strError = "";
		String strReplace = "";
		String strSel = "";
		String highStr = "", lowStr = "", cricHighStr = "",  cricLowStr = "";
		String prefix = "";

		strSel = common_labels.getString("Common.defaultSelect.label");
		strError = common_labels.getString("Common.Error.label");
		strReplace = common_labels.getString("Common.Replace.label");

		//String chkDate = "";
		//String chkTime = "";
		//String chkDaTime = "";

		int maxSize = 0;
		int minSize = 0;
		int decSize = 0;

		String minValue = "";
		String maxValue = "";

		//int temp = 0;

		try
		{		
			con = ConnectionManager.getConnection(request);
			try
			{
				pstmt = con.prepareStatement("select HIGH_STR,LOW_STR,CRIT_HIGH_STR,CRIT_LOW_STR from cr_clin_event_param");		
				res = pstmt.executeQuery();
				while(res.next())
				{
					highStr = res.getString("HIGH_STR");

					lowStr = res.getString("LOW_STR");

					cricHighStr = res.getString("CRIT_HIGH_STR");

					cricLowStr = res.getString("CRIT_LOW_STR");
				}
				if(res != null)res.close();
				if(pstmt != null)pstmt.close();
			}
			catch (Exception ee)
			{
				
				ee.printStackTrace();
			}
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,locale);
			pstmt.setString(2,locale);
			pstmt.setString(3,chartID);
			pstmt.setString(4,patientId);
			pstmt.setString(5,currDate);

			res = pstmt.executeQuery();

			while(res.next())
			{
				if(i % 2 == 0)
					classValue = "gridDataChart";
				else
					classValue = "gridDataChart";

				discrMsrID = res.getString(2) == null ? "" : res.getString(2);
				grpID = res.getString(1) == null ? "" : res.getString(1);
				discrMsrNum = res.getString(3) == null ? "" : res.getString(3);
				discrMsrUOM = res.getString(4) == null ? "" : res.getString(4);
				
				tempStringArray = grpID + "_" + discrMsrID;
				tempStringGrpDiscr = grpID + "_" + discrMsrID;	
				//stringArray.add(i,tempStringArray);
				
				discrMsrResultType = res.getString(7) == null ? "" : res.getString(7);
				//stringArrayType.add(i,discrMsrResultType);
				accessionNumber = res.getString(8) == null ? "" : res.getString(8);

				chartGrpDesc = res.getString(9) == null ? "" : res.getString(9);
				discrMsrDesc = res.getString(10) == null ? "" : res.getString(10);
				normalLow = res.getString(11) == null ? "" : res.getString(11);
				normalHigh = res.getString(12) == null ? "" : res.getString(12);
				criticalLow = res.getString(13) == null ? "" : res.getString(13);
				criticalHigh = res.getString(14) == null ? "" : res.getString(14);
				maxSize = res.getInt(15);
				minSize = res.getInt(16);
				decSize = res.getInt(17);
				associateScoreYN = res.getString(18) == null ? "" : res.getString(18);
				minValue = res.getString(19) == null ? "" : res.getString(19);
				maxValue = res.getString(20) == null ? "" : res.getString(20);

				if(discrMsrResultType.equals("A"))
				{
					formulaDef = res.getString("FORMULA_DEF") == null ? "" : res.getString("FORMULA_DEF");
					constructedFormula = constructFormula(formulaDef);
				}
				else
				{	
					formulaDef = "";
					constructedFormula = "";
				}				

				displayString.append("<input type='hidden' name='formulaString"+tempStringGrpDiscr+"' value='"+formulaDef+"'>");

				displayString.append("<input type='hidden' name='constructedFormula"+tempStringGrpDiscr+"' value=\""+constructedFormula+"\">");
	
				tempStringArray = "$$$"+tempStringArray+"###";

				if(globalSummationFormula.indexOf(tempStringArray) != -1)
					displayString.append("<input type='hidden' name='formulaMemberYN"+i+"' value = 'Y'>");
				else
					displayString.append("<input type='hidden' name='formulaMemberYN"+i+"' value = 'N'>");


				if(maxSize == 0) maxSize = 20;

				if(!prevGrpId.equals(grpID))
				{
					displayString.append("<tr>");
					displayString.append("<td class = 'CACHARTFOURTHLEVELCOLOR' colspan='9'>"+chartGrpDesc+"</td>");
					displayString.append("</tr>");
					prevGrpId = grpID;
				}

				if(discrMsrResultType.equals("N") || discrMsrResultType.equals("I") || discrMsrResultType.equals("A"))
				{
					discrMsrNum = res.getString(3) == null ? "" : res.getString(3);
					prefix = res.getString("RESULT_NUM_PREFIX") == null ? "" : res.getString("RESULT_NUM_PREFIX");
					if(prefix != null || !prefix.equals(""))
						displayStringValue = prefix+discrMsrNum;
					else
						displayStringValue = discrMsrNum;
					hiddenNumValue = "";
					summFormula = globalSummationFormula;
					if(summFormula.equals("") || summFormula.equals("0")) summFormula = "0";
				}
				else if(discrMsrResultType.equals("C") || discrMsrResultType.equals("L") || discrMsrResultType.equals("D") || discrMsrResultType.equals("E") || discrMsrResultType.equals("H"))
				{
					discrMsrNum = res.getString(3) == null ? "" : res.getString(3);
					discrMsrResultStr = res.getString(5) == null ? "" : res.getString(5);

					if(discrMsrResultType.equals("D") )
						discrMsrResultStr = com.ehis.util.DateUtils.convertDate(discrMsrResultStr,"DMY","en",locale);
					else if(discrMsrResultType.equals("E") )
						discrMsrResultStr = com.ehis.util.DateUtils.convertDate(discrMsrResultStr,"DMYHM","en",locale);

					displayStringValue = discrMsrResultStr;
					if(discrMsrResultType.equals("L"))
					{
						hiddenNumValue = discrMsrNum;
					}
					else
					{
						hiddenNumValue = "";
					}
				}
				else
				{
					discrMsrResultStr = res.getString(5) == null ? "" : res.getString(5);
					displayStringValue = discrMsrResultStr;
					hiddenNumValue = "";
				}

				displayString.append("<input type='hidden' name='listStringValue"+i+"' value=''>");

				if(discrMsrResultType.equals("L"))
				{
					disableSelect = "";
					summFormula = globalSummationFormula;
					if(summFormula.equals("") || summFormula.equals("0")) summFormula = "0";
					if(associateScoreYN.equals("Y"))
					{
						dispForm = " onBlur =  \"displayFormulaForError("+summFormula+","+i+","+formulaCount+")\" ";
						dispOnChange = "OnChange = \" document.forms[0].custom_"+grpID+"_"+discrMsrID+".value=this.value; \" ";
					}
					else
					{
						dispForm = " onBlur =  \"displayFormulaForError("+summFormula+","+i+","+formulaCount+")\" ";
						dispOnChange = "OnChange = \" document.forms[0].custom_"+grpID+"_"+discrMsrID+".value=this.value; \" ";
					}
					String sqlSelect = "select ref_rng_desc,NORM_ABNORM_IND,DFLT_YN,NUMERIC_VALUE REF_RANGE_SEQ from am_discr_msr_ref_rng_list where  discr_msr_id= ? order by SORT_ORDER,ref_rng_desc";
						
					String desc="",code="",dfltYN = "";
					PreparedStatement pstmtList = null;
					ResultSet resList = null;

					pstmtList = con.prepareStatement(sqlSelect);
					pstmtList.setString(1,discrMsrID);
					resList = pstmtList.executeQuery();
					displayObject = "<select name = 'objectName"+i+"' style='display:none' id='object"+i+"' "+dispForm+" "+dispOnChange+">";

					while(resList.next())
					{
						desc = resList.getString(1) == null ? "" : resList.getString(1).trim();
						code = resList.getString(4) == null ? "" : resList.getString(4).trim();

						//added by Deepa on 12/4/2008 3:47 PM for 7014 (SCF # SRR20056-SCF-2579)
						dfltYN = resList.getString("DFLT_YN") == null ? "N" : resList.getString("DFLT_YN").trim();

						if(code.equals("")) code = "";


//Commented by Deepa on 12/4/2008 3:47 PM for 7014 (SCF # SRR20056-SCF-2579)
						/*if(discrMsrNum.equals(code))
							selectedValue = "selected";
						else
							selectedValue = "";*/

//added by Deepa on 12/4/2008 3:47 PM for 7014 (SCF # SRR20056-SCF-2579)
						if(dfltYN.equals("Y"))
							selectedValue = "selected";
						else
							selectedValue = "";

						displayObject = displayObject + "<option value='"+code+"' "+selectedValue+">"+desc+"</option>";
					}
					//displayObject = displayObject + " "+selectedValue+" </select>";
					displayObject = displayObject + "</select>";
					if(resList != null) resList.close();
					if(pstmtList != null) pstmtList.close();
				}
				else if(discrMsrResultType.equals("C"))
				{
					dispForm = "";
					ValidNumForNNI = "";
					validityNum = "";
					dispOnChange = "";
					disableSelect = "";
					displayObject = "<input type='checkbox' style='display:none' id='object"+i+"' name = 'objectName"+i+"' value='N'>";
				}
				else if(discrMsrResultType.equals("A"))
				{
					dispForm = "";
					ValidNumForNNI = "";
					validityNum = "";
					dispOnChange = "";
					disableSelect = " disabled ";
					displayObject = "<input type='text' style='display:none' id='formObject"+i+"' name = 'formulaObjectName"+tempStringGrpDiscr+"' readOnly>";
				}
				else
				{
					dispForm = "";
					if(discrMsrResultType.equals("D"))
					{
						dispOnChange = "";
						maxSize = 10;
						dispForm = " checkDateForDetail(this) ";
						validityNum = "";
						ValidNumForNNI = "";
					}
					else if(discrMsrResultType.equals("E"))
					{
						dispOnChange = "";
						maxSize = 16;
						dispForm = " CheckDateTime(this) ";
						validityNum = "";
						ValidNumForNNI = "";
					}
					else if(discrMsrResultType.equals("T"))
					{
						dispOnChange = "";
						maxSize = 5;
						dispForm = " chkValidityOfTime(this) ";
						validityNum = "";
						ValidNumForNNI = "";
					}
					if(discrMsrResultType.equals("N") || discrMsrResultType.equals("I"))
					{
						disableSelect = "";
						summFormula = globalSummationFormula;
						if(summFormula.equals("") || summFormula.equals("0")) summFormula = "0";
						dispOnChange = "OnChange = \" document.forms[0].custom_"+grpID+"_"+discrMsrID+".value=this.value; \" ";
						dispForm = " displayFormulaForError("+summFormula+","+i+","+formulaCount+") ";
						validityNum = " onkeypress=\"return allowValidNumberLocal2(this, event, '"+maxSize+"','"+decSize+"')\" ";
						ValidNumForNNI = " validateNumber(this,'"+normalLow+"','"+normalHigh+"','"+i+"','"+decSize+"','"+criticalLow+"','"+criticalHigh+"','"+minSize+"','"+minValue+"','"+maxValue+"'); ";
					}
					else
					{
						dispForm = "";
						validityNum = " onkeypress=\"return allowValidNumberLocal3(this, event)\" ";
						dispOnChange = " OnChange = \" document.forms[0].custom_"+grpID+"_"+discrMsrID+".value=this.value; \" ";
						ValidNumForNNI = "";
					}
					if(discrMsrResultType.equals("A"))
					{
						disableSelect = " disabled ";
						textReadOnly = " readOnly ";
					}
					else
					{
						disableSelect = "";
						textReadOnly = "";
					}

					displayObject = "<input type='text' style='display:none' id='object"+i+"' name = 'objectName"+i+"' size="+maxSize+" maxlength="+maxSize+" "+textReadOnly+" onBlur=\" "+ValidNumForNNI+" "+dispForm+" \" "+dispOnChange+" "+validityNum+">";
					
				
				}
				displayString.append("<tr>");
				displayString.append("<td class=\""+classValue+"\">"+discrMsrDesc+" <input type='hidden' name='discrMsrHidden"+i+"' value=\""+discrMsrID+"\"></td>");
				displayString.append("<td class=\""+classValue+"\">"+displayStringValue+" <input type='hidden' name='displayStringValue"+i+"' value='"+displayStringValue+"'><input type='hidden' name='prevDisplayStringValue"+i+"' value='"+displayStringValue+"'><input type='hidden' name='prevDisplayNumValue"+i+"' value='"+hiddenNumValue+"'><input type='hidden' name='displayNumValue"+i+"' value='"+hiddenNumValue+"'><input type='hidden' name='accessNumHidden"+i+"' value=\""+accessionNumber+"\"> </td>");
				displayString.append("<td class=\""+classValue+"\">"+discrMsrUOM+" <input type='hidden' name='discrUOMHidden"+i+"' value=\""+discrMsrUOM+"\"> </td>");
				displayString.append("<td class=\""+classValue+"\"><select "+disableSelect+" name='amendOrError' onchange='enableObject(this,\""+i+"\",document.forms[0].custom_"+grpID+"_"+discrMsrID+",\""+formulaCount+"\")' id='selectObject"+i+"'>");
				displayString.append("<option value=''>----"+strSel+"----</option>");
				displayString.append("<option value='E'>"+strError+"</option>");
				displayString.append("<option value='R'>"+strReplace+"</option>");
				displayString.append("</select> &nbsp; "+displayObject+" <input type='hidden' id='hidErrYN"+i+"' name='errorYN"+i+"' value=''> <input type='hidden' name='discrGrpHidden"+i+"' value=\""+grpID+"\"> <input type='hidden' name='discrTypeHidden"+i+"' value=\""+discrMsrResultType+"\"> <input type='hidden' name='normalLow"+i+"' value=\""+normalLow+"\"> <input type='hidden' name='normalHigh"+i+"' value=\""+normalHigh+"\"> <input type='hidden' name='criticalLow"+i+"' value=\""+criticalLow+"\"> <input type='hidden' name='criticalHigh"+i+"' value=\""+criticalHigh+"\"> <input type='hidden' name='normal_abnormal_ind_"+i+"' value=''> <input type='hidden' name='result_prefix"+i+"' value='' </td>");
				displayString.append("<td class=\""+classValue+"\"><input type='text' "+disableSelect+" size=30 maxlength=60 name='remarksHidden"+i+"' id='errorRem"+i+"'></td>");//IN037946 included disableSelect
				displayString.append("</tr>");
				displayString.append("<input type='hidden' name='errorFormulaMemberYN"+i+"'>");
				displayString.append("<input type='hidden' name='tempStringArray"+i+"' value='"+tempStringArray+"'>");
				displayString.append("<input type='hidden' name='formulaObject"+i+"' value=''>");
				displayString.append("<input type='hidden' name='grpDiscrMsrIds"+i+"' value='"+tempStringGrpDiscr+"'>");

				i++;
				displayObject = "";

				if(discrMsrResultType.equals("A"))
				{
					formulaCount++;
				}
			}//end of while

			String formulaFromMap = "";
			String evaluatedFormulaFromMap = "";
			String keyForMap = "";
			String tempFormulaFromMap = "";
			String discrMsrForFormula = "";
			String discrMsrGrpForFormula = "";
			int tempIntForm = 0;
			int tempFormCnt = 0;

			for(int j=0;j<stringArray.size();j++)
			{
				tempIntForm = 0;
				keyForMap = (String) stringArray.get(j);
				formulaFromMap = (String) hashForm.get(keyForMap);
				evaluatedFormulaFromMap = (String) hashForm.get("evaluated"+keyForMap);

				if(formulaFromMap != null && !formulaFromMap.equals(""))
				{
					displayString.append("<input type='hidden' name='Form"+j+"' value=\"Form"+tempFormCnt+"\">");
					displayString.append("<input type='hidden' name='evaluatedForm"+tempFormCnt+"' value=\""+evaluatedFormulaFromMap+"\">");
					for(int k=0;k<stringArray.size();k++)
					{
						discrMsrForFormula = (String) stringArrayDiscr.get(k);
						discrMsrGrpForFormula = (String) stringArray.get(k);
						
						if(formulaFromMap.indexOf(discrMsrGrpForFormula) != -1)
						{

							displayString.append("<input type='hidden' name='FormulaMember"+					tempFormCnt+"Form"+k+"' value=\""+discrMsrForFormula+""+					tempFormCnt+"Form"+k+"\">");
							tempIntForm++;
						}
					}//end of for-2
					displayString.append("<input type='hidden' name='numOfCompsForm"+tempFormCnt+"' value=\""+tempIntForm+"\">");
					tempFormCnt++;//should be incremented if not "A" and if not "Y"
				}//end of if

				tempFormulaFromMap = formulaFromMap;				
			}//end of for			

			displayString.append("<input type='hidden' name='numOfRecs' value=\""+i+"\">");
			//displayString.append("<input type='hidden' name='chartID' value=\""+i+"\">");
			displayString.append("<input type='hidden' name='numOfRecsFormError' value=0>");
			displayString.append("<input type='hidden' name='numOfSelObjects' value=0>");
			displayString.append("<input type='hidden' name='numOfReplaceObjects' value=0>");

			displayString.append("<input type='hidden' name='chartId' value=\""+chartID+"\">");
			displayString.append("<input type='hidden' name='recordedDatime' value=\""+currDate+"\">");
			displayString.append("<input type='hidden' name='encounter_id' value=''>");
			displayString.append("<input type='hidden' name='patient_id' value=''>");
			displayString.append("<input type='hidden' name='patient_class' value=''>");
			displayString.append("<input type='hidden' name='highStr' value=\""+highStr+"\">");
			displayString.append("<input type='hidden' name='lowStr' value=\""+lowStr+"\">");
			displayString.append("<input type='hidden' name='cricHighStr' value=\""+cricHighStr+"\">");
			displayString.append("<input type='hidden' name='cricLowStr' value=\""+cricLowStr+"\">");

			if(res != null) res.close();
			if(pstmt != null) pstmt.close();
		}//end of try
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		finally
		{
			if(con != null) ConnectionManager.returnConnection(con,request);
		}

		return displayString;
	}//end of amendErrorScreen

	private String constructFormula(String formula)
	{

        StringBuffer sourceBuffer=null;
		String finalFormula = formula;
        String tempFormula = "";
        String tempString = "";
        String emptyString = "''";
        String tempToken ="";
       // String tempTokenForError ="";
        
		int indexValue=0;
        int dummyI=0;
        int dummyJ=0;
        //int k=0;
       
	   indexValue =finalFormula.indexOf(tempString);

        if(!formula.equals(""))
        {
			for(int indexI = 0; indexI < stringArray.size();indexI++)
			{

				//if(((String) stringArrayErrorYN.get(indexI)).equals("N"))
				{
				tempString = (String)stringArray.get(indexI) == null ? "" : (String)stringArray.get(indexI);

				tempToken = "$$$" + tempString + "###";


				dummyI = 0;
				while((indexValue =finalFormula.indexOf(tempToken,dummyI)) !=-1 && dummyI <=finalFormula.length())
				{

					 sourceBuffer= new StringBuffer(finalFormula);
					tempFormula =  "((eval('document.forms(0).custom_"+tempString+"') == null)? 0 : eval('document.forms(0).custom_"+tempString+".value')=="+emptyString+" ? 0 :parseFloat(eval('document.forms(0).custom_"+tempString+".value')))";
					sourceBuffer=sourceBuffer.replace(indexValue,indexValue + tempToken.length(),tempFormula);

					finalFormula =  sourceBuffer.toString();

					dummyJ =  finalFormula.indexOf(tempFormula,dummyI);
					dummyI =dummyI +dummyJ + tempFormula.length() + 1;
				}//end of while
				//k++;
				}
			}//end of for
		}//end of if
		
		/*int p=0,start=0,end=0;

		StringBuffer finalFormulaBfr = new StringBuffer(finalFormula);
		while(p<finalFormulaBfr.length())
		{
			start = finalFormula.indexOf("$$$",p);
			end = finalFormula.indexOf("###",p);
			if(start<0)
				break;
			else
			{
				finalFormulaBfr.replace(start,end+2,"0");
				p = end+3;
			}
		}
		finalFormula = finalFormulaBfr.toString();*/

		return finalFormula;
	}//end of constructFormula

}//end of class
