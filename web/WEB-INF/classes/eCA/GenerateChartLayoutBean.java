/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-----------------------------------------------------------------------
Date       Edit History      Name        	Description
-----------------------------------------------------------------------
?             100            ?           	created
30/05/2013    IN00000       Chowminya G    R(remarks) in Assessment Chart recording in AE after data recorded to be removed as it throws script error
08/10/2013	  IN043178		Vijayakumar K	Alpha-CIS->CA->View Chart Summary>Record Charts>Displays a message "APP CA 0224 – Transaction could not be complete" when entering 'text' data into a field	
16/12/2013    IN045648		Chowminya		All discrete measures which are long text in charts , we are not able to enter any alpha characters in it
30/12/2013	  IN045223.1	Chowminya		[Reopen]Score value 0 in formula component not displayed	
01/04/2014	  ICN_ADH_002	Chowminya		Default component value and normalcy indicator not displayed from AE	
-----------------------------------------------------------------------
Date       	Edit History     Name      	Rev.Date		Rev.Name		Description
-----------------------------------------------------------------------
16/08/2017	IN060946	RajaS		17/08/2017		Raja S			ML-MMOH-CRF-0520
19/04/2018	IN067307	Raja S		19/04/2018		Raja S			ML-MMOH-SCF-0976
29/10/2018	IN068742	Sharanraj						Ramesh G		TBMC-SCF-0006
-------------------------------------------------------------------------------------------------------------------------------
*/ 
package eCA;
import java.util.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;
import webbeans.eCommon.*;
import java.math.*;
public class GenerateChartLayoutBean
{
    private String chartId;
    private String function_from;
    private String descrMsrIds;
    String defaultYN = "";
    private Connection con;
    private PreparedStatement pstmt,pstmt1;
    private ResultSet rs,rs1;
    private ArrayList arrList;
    private ArrayList stringArray =null;
    private ArrayList discrArray =null;

    private int index;
	private StringBuffer displayString = null;

    private int counter;
    private String summationFormula="0";
    private String shortDesc,groupHeading,uom,graph;
    private StringBuffer component = null;
    private String prevGroupId="",classValue="gridDataChart",normalInd="", associate_score_yn="";
	private String modifyYN = "";
	private String Discmeasureid="";//IN068742
  
	public String getIndex()
	{
		return (index + "");
	}
    public GenerateChartLayoutBean()
    {
        arrList = new ArrayList();
        displayString = new StringBuffer();
    }
    /*IN068742 starts*/
    public int getdecimal() throws Exception
    {

    	int numdecimal=0;
    	String sql ="select NUM_DIGITS_DEC from am_discr_msr where discr_msr_id=?";
    	Connection con1=null;
    	con1=ConnectionManager.getConnection();
    	pstmt = con1.prepareStatement(sql);
		pstmt.setString(1,Discmeasureid);
		rs = pstmt.executeQuery();
		try
		{
			if(rs!=null && rs.next())
			{
				numdecimal=rs.getInt(1);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(con1!=null)con1.close();
		}
		return numdecimal;
    }
    /*IN068742 ends*/
    private void loadDataArrayList(String facilityId, HttpServletRequest request, String locale) throws Exception
    {
        HashMap hash = null;
        HashMap hashData = new HashMap();
        
        ArrayList arr = null;
        try
        {
			chartId = request.getParameter("chartId");

			if(chartId == null)
				chartId = "";

			function_from = checkForNull(request.getParameter("function_from"));
			modifyYN = request.getParameter("modifyYN") == null ? "Y" : request.getParameter("modifyYN");

			boolean  flag=true;
			String dob = request.getParameter("Dob");
            String Sex = request.getParameter("Sex");
			String patient_id = request.getParameter("patient_id");//ICN_ADH_002
            String encounterId = request.getParameter("encounter_id");

			if(encounterId.equals("")) encounterId = "0";
			//ICN_ADH_002 - Start
			if("AE".equals(function_from))
			{
				String sqlAE ="select SEX,TO_CHAR(DATE_OF_BIRTH, 'dd/mm/yyyy') DATE_OF_BIRTH from mp_patient where patient_id= ? ";

				pstmt = con.prepareStatement(sqlAE);
				pstmt.setString(1,patient_id);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					Sex = checkForNull(rs.getString("SEX"));
					dob = checkForNull(rs.getString("DATE_OF_BIRTH"));
				}
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}
			//ICN_ADH_002 - End
            String summaryYN="";
            String sql ="select CONFIG_TYPE DEFINE_MODIFIABLE_AT_TRN_YN,DAY_SUMMARY_REQ_YN    from ca_chart where chart_id = ? ";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,chartId);
            rs = pstmt.executeQuery();
            while(rs.next())
            {
                defaultYN =checkForNull( rs.getString(1));
                summaryYN= checkForNull(rs.getString(2));
            }
            if(rs!=null)rs.close();
            if(pstmt!=null)pstmt.close();
            if(defaultYN.equals("N"))
            {
                sql = "SELECT   a.panel_id chart_group_id, AM_GET_DESC.AM_DISCR_MSR(a.panel_id,?,'2') chart_group_desc, a.discr_msr_id, AM_GET_DESC.AM_DISCR_MSR(a.discr_msr_id,?,'2') discr_msr_desc,c.result_type  result_type,a.panel_disp_order_seq display_order_seq,       a.discr_disp_order_seq order_srl_no,c.ref_range_type unit_of_measure, c.result_type, c.num_digits_max,c.num_digits_min, c.num_digits_dec, 'I' operation_type, a.mandatory_yn ,CA_GET_FORMULA_STRING(a.FORMULA_DEF) FORMULA_DEF,CA_GET_FORMULA_TOOLTIP(a.FORMULA_DEF) tooltip, c.ASSOCIATE_SCORE_YN associate_score_yn, c.MIN_VALUE, c.MAX_VALUE FROM ca_chart_section_comp a,am_discr_msr c  WHERE a.chart_id = ?   and c.discr_msr_id = a.discr_msr_id ORDER BY a.panel_disp_order_seq, a.discr_disp_order_seq ";
            }
            else
            {
                sql = "select    d.PANEL_ID chart_group_id , AM_GET_DESC.AM_DISCR_MSR(d.panel_id,?,'2') chart_group_desc , d.DISCR_MSR_ID  , AM_GET_DESC.AM_DISCR_MSR(d.discr_msr_id,?,'2') discr_msr_desc , d.DISCR_MSR_TYPE result_type , CA_GET_FORMULA_STRING(d.FORMULA_DEF) FORMULA_DEF  ,CA_GET_FORMULA_TOOLTIP(d.FORMULA_DEF) tooltip, d.PANEL_DISP_ORDER_SEQ display_order_seq , d.DISCR_DISP_ORDER_SEQ order_srl_no ,c.ref_range_type unit_of_measure , c.num_digits_max ,c.num_digits_min , c.num_digits_dec , 'I' operation_type ,d.mandatory_yn, c.ASSOCIATE_SCORE_YN  associate_score_yn, c.MIN_VALUE, c.MAX_VALUE from   CA_ENCNTR_CHART_DRAFT d ,am_discr_msr c where   d.ENCOUNTER_ID = ? and d.CHART_ID = ?   and d.FACILITY_ID = ?  and d.discr_msr_id = c.discr_msr_id ORDER BY  d.panel_disp_order_seq , d.discr_disp_order_seq  ";
            }

            pstmt = con.prepareStatement(sql);

            if(defaultYN.equals("N"))
            {
				pstmt.setString(1,locale);
				pstmt.setString(2,locale);
				pstmt.setString(3,chartId);
            }
            else
            {
				pstmt.setString(1,locale);
				pstmt.setString(2,locale);
				pstmt.setString(3,encounterId);
                pstmt.setString(4,chartId);
                pstmt.setString(5,facilityId);
            }
            rs = pstmt.executeQuery();
            String refRangeType = "";
            String disMsrId = "";
            String prevChtGrpId="",chtGrpId="";
            ArrayList chartGrpArray = new ArrayList();
            //IN060946 Starts         
            //String sql1 = "select num_uom, num_ref_low, num_ref_high, num_crit_low, num_crit_high, ref_range_seq,NUM_DFLT_RESULT from am_discr_msr_ref_rng_num WHERE discr_msr_id= ? ";//IN060946
	    String sql1 = "select num_uom, num_ref_low, num_ref_high, num_crit_low, num_crit_high, ref_range_seq,NUM_DFLT_RESULT,(SELECT STD_COMP_ID FROM AM_DISCR_MSR B WHERE B.DISCR_MSR_ID=A.DISCR_MSR_ID) STD_COMP from am_discr_msr_ref_rng_num A WHERE A.discr_msr_id= ? ";
	    //IN060946 Ends

			String sql2 = sql1 + " and ( to_date( ?,'dd/mm/yyyy') <=  decode(START_AGE_UNITS,'D',trunc(sysdate)-START_AGE,'M',add_months(trunc(sysdate),-1*START_AGE),'Y',add_months(trunc(sysdate),-12*START_AGE)))  and ( to_date( ?,'dd/mm/yyyy') >=  decode(END_AGE_UNITS,'D',trunc(sysdate)-END_AGE,'M',add_months(trunc(sysdate),-1*END_AGE),'Y',add_months(trunc(sysdate),-12*END_AGE)) )and PATIENT_SEX = ? ";

            int i = 0;
            while(rs.next())
            {
				flag = true;
                refRangeType = checkForNull(rs.getString("unit_of_measure"));
				associate_score_yn = rs.getString("associate_score_yn") == null ? "" : rs.getString("associate_score_yn");

				associate_score_yn = associate_score_yn;

                disMsrId = checkForNull(rs.getString("DISCR_MSR_ID"));
                chtGrpId = checkForNull(rs.getString("chart_group_id"));
                hash = new HashMap();
                hash.put("CHART_GROUP_ID",checkForNull(rs.getString("chart_group_id")));
                hash.put("CHART_GORUP_DESC",checkForNull(rs.getString("chart_group_desc")));

                hash.put("DISCR_MSR_ID",disMsrId);
                hash.put("SHORT_DESC",checkForNull(rs.getString("DISCR_MSR_DESC")));
				
                String resultType = checkForNull(rs.getString("result_type"));
                if(!resultType.equals("S"))
                hash.put("RESULT_TYPE",resultType);
                else
                {
                    if(summaryYN.equals("Y"))
						hash.put("RESULT_TYPE",resultType);
                }
                hash.put("DISPLAY_ORDER_SEQUENCE",checkForNull(rs.getString("DISPLAY_ORDER_SEQ")));
                hash.put("ORDER_SERIAL_NUMBER",checkForNull(rs.getString("ORDER_SRL_NO")));
                hash.put("NUM_MIN",checkForNull(rs.getString("num_digits_min")));
                hash.put("NUM_MAX",checkForNull(rs.getString("num_digits_max")));
                hash.put("NUM_DEC",checkForNull(rs.getString("num_digits_dec")));
                hash.put("OPERATION_TYPE",checkForNull(rs.getString("operation_type")));
                hash.put("MANDATORY_YN",checkForNull(rs.getString("MANDATORY_YN")));
                hash.put("ASSOCIATE_SCORE_YN",checkForNull(rs.getString("associate_score_yn")));

                hash.put("FORMULA_STRING",checkForNull(rs.getString("FORMULA_DEF")));
                hash.put("TOOL_TIP",checkForNull(rs.getString("tooltip")));

				hash.put("MIN_VALUE",checkForNull(rs.getString("MIN_VALUE")));
				hash.put("MAX_VALUE",checkForNull(rs.getString("MAX_VALUE")));

                if(!prevChtGrpId.equals(chtGrpId))
                {
                    if(!chartGrpArray.contains(chtGrpId))
                    chartGrpArray.add(chtGrpId);
                    if(i>0)
                    {

                        hashData.put(prevChtGrpId,arr);
                    }


                    arr  = new ArrayList();
                }
                arr.add(disMsrId);

				if(refRangeType.equals("M"))
                {
                    pstmt1 = con.prepareStatement(sql2);
                }
				else
				{
	                pstmt1 = con.prepareStatement(sql1);
				}
                
                if(refRangeType.equals("M"))
                {
                    pstmt1.setString(1,disMsrId);
                    pstmt1.setString(2,dob);
                    pstmt1.setString(3,dob);
                    pstmt1.setString(4,Sex);
                }
				else
				{
					pstmt1.setString(1,disMsrId);
				}
                rs1 = pstmt1.executeQuery();
               	if(rs1.next())
                {
                    hash.put("UOM",checkForNull(rs1.getString(1)));
                    hash.put("NORMAL_LOW",checkForNull(rs1.getString(2)));
                    hash.put("NORMAL_HIGH",checkForNull(rs1.getString(3)));
                    hash.put("CRITICAL_LOW",checkForNull(rs1.getString(4)));
                    hash.put("CRITICAL_HIGH",checkForNull(rs1.getString(5)));
                    //IN060946 starts
                    //hash.put("NUM_DFLT_RESULT",checkForNull(rs1.getString(7)));
                    if(rs1.getString(7)==null && "RECENT_WEIGHTOF_PAT".equals(rs1.getString(8))){
						//String stdSql="select * from (SELECT   NVL (DISCR_MSR_RESULT_NUM, '') CURR_WEIGHT FROM   CA_ENCNTR_DISCR_MSR WHERE   DISCR_MSR_ID =(SELECT   DISCR_MSR_ID FROM   OR_ORDER_FIELD WHERE FIELD_MNEMONIC = 'WEIGHT' AND ORDER_CATEGORY = 'PH') AND PATIENT_ID = '"+patient_id+"' AND ENCOUNTER_ID ='"+encounterId+"' ORDER BY TEST_OBSERV_DT_TM desc ) where ROWNUM = 1";//common-icn-0180 
						String stdSql="select * from (SELECT   NVL (DISCR_MSR_RESULT_NUM, '') CURR_WEIGHT FROM   CA_ENCNTR_DISCR_MSR WHERE   DISCR_MSR_ID =(SELECT   DISCR_MSR_ID FROM   OR_ORDER_FIELD WHERE FIELD_MNEMONIC = 'WEIGHT' AND ORDER_CATEGORY = 'PH') AND PATIENT_ID = ? AND ENCOUNTER_ID = ? ORDER BY TEST_OBSERV_DT_TM desc ) where ROWNUM = 1"; //common-icn-0180
						
						
						PreparedStatement pstmt2 =null;
						ResultSet rs2;
						pstmt2 =con.prepareStatement(stdSql);
						pstmt2.setString(1, patient_id);//common-icn-0180
						pstmt2.setString(1, encounterId);//common-icn-0180
						rs2 = pstmt2.executeQuery();
						if(rs2.next()){
							//IN067307 changes starts
							String weightVal = "";
							BigDecimal wt =rs2.getBigDecimal(1);
							if(wt!=null)
							weightVal=wt.toString();
							else
							weightVal="";
							//IN067307 changes ends

							hash.put("NUM_DFLT_RESULT",checkForNull(weightVal));
						}else{
							hash.put("NUM_DFLT_RESULT",checkForNull(rs1.getString(7)));
						}

						if(rs2!=null)rs2.close();
						if(pstmt2!=null)pstmt2.close();
					}
					else{
						hash.put("NUM_DFLT_RESULT",checkForNull(rs1.getString(7)));
					}
                    //IN060946 Ends
					flag = false;
                }
                if(rs1!=null)rs1.close();
                if(pstmt1!=null)pstmt1.close();
				
				if(flag)
				{
					if(refRangeType.equals("M"))
					{
						pstmt1 = con.prepareStatement(sql2);
                    }
					else
					{
	                    pstmt1 = con.prepareStatement(sql1);
					}
                    
                    if(refRangeType.equals("M"))
                    {
						pstmt1.setString(1,disMsrId);
						pstmt1.setString(2,dob);
						pstmt1.setString(3,dob);
						pstmt1.setString(4,"A");
                    }
					else
					{
						pstmt1.setString(1,disMsrId);
					}
                    rs1 = pstmt1.executeQuery();

				    if(rs1.next())
                    {
						hash.put("UOM",checkForNull(rs1.getString(1)));
						hash.put("NORMAL_LOW",checkForNull(rs1.getString(2)));
						hash.put("NORMAL_HIGH",checkForNull(rs1.getString(3)));
						hash.put("CRITICAL_LOW",checkForNull(rs1.getString(4)));
						hash.put("CRITICAL_HIGH",checkForNull(rs1.getString(5)));
						//IN060946 Starts
						//hash.put("NUM_DFLT_RESULT",checkForNull(rs1.getString(7)));
						if(rs1.getString(7)==null && "CURRENT_WEIGHTOF_PAT".equals(rs1.getString(8))){
							//String stdSql="SELECT NVL(DISCR_MSR_RESULT_NUM,'') CURR_WEIGHT FROM CA_ENCNTR_DISCR_MSR  WHERE DISCR_MSR_ID = (SELECT DISCR_MSR_ID FROM OR_ORDER_FIELD WHERE FIELD_MNEMONIC ='WEIGHT' AND ORDER_CATEGORY='PH') AND PATIENT_ID='"+patient_id+"' AND ENCOUNTER_ID='"+encounterId+"' AND ROWNUM=1 ORDER BY TEST_OBSERV_DT_TM DESC"; //common-icn-0180
							String stdSql="SELECT NVL(DISCR_MSR_RESULT_NUM,'') CURR_WEIGHT FROM CA_ENCNTR_DISCR_MSR  WHERE DISCR_MSR_ID = (SELECT DISCR_MSR_ID FROM OR_ORDER_FIELD WHERE FIELD_MNEMONIC ='WEIGHT' AND ORDER_CATEGORY='PH') AND PATIENT_ID= ?  AND ENCOUNTER_ID= ? AND ROWNUM=1 ORDER BY TEST_OBSERV_DT_TM DESC"; //common-icn-0180
							
							PreparedStatement pstmt2 =null;
						    ResultSet rs2;
							pstmt2 =con.prepareStatement(stdSql);
							pstmt2.setString(1, patient_id);//common-icn-0180
							pstmt2.setString(1, encounterId);//common-icn-0180
							rs2 = pstmt2.executeQuery();
							if(rs2.next())
								hash.put("NUM_DFLT_RESULT",checkForNull(rs2.getString(1)));
							else
								hash.put("NUM_DFLT_RESULT",checkForNull(rs1.getString(7)));

							if(rs2!=null)rs2.close();
							if(pstmt2!=null)pstmt2.close();

						}
						else{
							hash.put("NUM_DFLT_RESULT",checkForNull(rs1.getString(7)));
						}
						//IN060946 Ends
                    }
				}
				if(rs1!=null)rs1.close();
                if(pstmt1!=null)pstmt1.close();

                arrList.add(hash);
                prevChtGrpId =     chtGrpId;
                i++;
            }
            if(rs!=null)rs.close();
            if(pstmt!=null)pstmt.close();

            hashData.put(chtGrpId,arr);

            if(i==0)
                hashData = null;
            else
                request.getSession().putValue("chartEvents"+encounterId,hashData);
                request.getSession().putValue("chartGrp"+encounterId,chartGrpArray);
                request.getSession().putValue("arrList"+encounterId,arrList);
            loadExtraDiscrMsr(locale);
        }
		catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(rs!=null)rs.close();
                if(pstmt!=null)pstmt.close();
                    if(rs1!=null)rs1.close();
                if(pstmt1!=null)pstmt1.close();
                hash = null;
            }
			catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    /* this function is used for adding Extra Discrete measures to the
     * chart temporarly
     * It checks the second attribute in the tag "descrMsrIds" and
     * if its there then only call fire the Query
     */
    private void loadExtraDiscrMsr(String locale)
    {
        if(descrMsrIds!=null)
        {
            HashMap hash = null;
            String newDescrMsrIds = replaceString(descrMsrIds,"|","','");

			try
            {
                String sql = "SELECT  discr_msr_id, short_desc,null unit_of_measure, result_type, num_digits_max , num_digits_min , num_digits_dec,null mandatory_yn,null operation_type,REF_RANGE_TYPE ,to_char(sysdate,'dd/mm/yyyy') to_date, MIN_VALUE, MAX_VALUE From AM_DISCR_MSR_lang_vw where discr_msr_id in ('"+newDescrMsrIds+"') and language_id = ? ";

                pstmt = con.prepareStatement(sql);
				pstmt.setString(1,locale);
                rs = pstmt.executeQuery();
				while(rs.next())
                {
                    hash = new HashMap();
                    hash.put("DISCR_MSR_ID",rs.getString(1));
                    hash.put("SHORT_DESC",rs.getString(2));
                    hash.put("UOM",rs.getString(3));
                    hash.put("RESULT_TYPE",rs.getString(4));
                    hash.put("NUM_MAX",rs.getString(5));
                    hash.put("NUM_MIN",rs.getString(6));
                    hash.put("NUM_DEC",rs.getString(7));
                    hash.put("MANDATORY_YN",rs.getString(8));
                    hash.put("OPERATION_TYPE",rs.getString(9));
                    hash.put("REF_RANGE_TYPE",rs.getString(10));
                    hash.put("TO_DATE",rs.getString(11));
					hash.put("MIN_VALUE",rs.getString(12));
					hash.put("MAX_VALUE",rs.getString(13));
                    arrList.add(hash);
                }
                if(rs!=null)rs.close();
                if(pstmt!=null)pstmt.close();
                hash = null;
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    //***************************Helper Functions*************************************//
    /* support Method for replacing the strings
     *
     */
    private String replaceString(String sourceString,String replaceWhat,String replaceWith)
    {
		if (sourceString.indexOf(replaceWhat) != -1) sourceString = sourceString.replaceAll(replaceWhat,replaceWith);
/*
		int index=0;

        StringBuffer sourceBuffer = new StringBuffer(sourceString);

        if((index=sourceBuffer.toString().indexOf(replaceWhat))!=-1)
        {

            sourceBuffer=sourceBuffer.replace(index,index+replaceWhat.length(),replaceWith);

            replaceWhat="";
        }

        return sourceBuffer.toString();*/
		return sourceString;

    }

private String constructFormula(String formula, String groups ,String flagString)
    {
		//groups = groups;

        StringBuffer sourceBuffer=null;
        String finalFormula = formula;

        String tempFormula = "";
        String tempString = "";
        String emptyString = "\"\"";
        String tempToken ="";
        int indexValue=0;
        int dummyI=0;
        int dummyJ=0;
        indexValue =finalFormula.indexOf(tempString);
        if(!formula.equals(""))
        {

                if(flagString.equals("S")){
                    for(int indexI = 0; indexI < stringArray.size();indexI++)
                    {
                        tempString = checkForNull((String)stringArray.get(indexI)) ;

                        tempToken = "$$$" + tempString + "###";
                        dummyI = 0;
                        while((indexValue =finalFormula.indexOf(tempToken,dummyI)) !=-1 && dummyI <=finalFormula.length())
                        {
                                 sourceBuffer= new StringBuffer(finalFormula);
                                  tempFormula =  "((eval(\"document.forms[0].custom_"+tempString+"\") == null)? 0 : eval(\"document.forms[0].custom_"+tempString+".value\")=="+emptyString+" ? 0 :parseFloat(eval(\"document.forms[0].custom_"+tempString+".value\")))";
                            sourceBuffer=sourceBuffer.replace(indexValue,indexValue + tempToken.length(),tempFormula);
                            finalFormula =  sourceBuffer.toString(); dummyJ =  finalFormula.indexOf(tempFormula,dummyI);
                            dummyI =dummyI +dummyJ + tempFormula.length() + 1;

                        }
                    }
                }
                else
                {
                    for(int indexI = 0; indexI < stringArray.size();indexI++)
                    {
                        tempString = checkForNull((String)stringArray.get(indexI));
                            tempToken = "$$$" + tempString + "###";
                            dummyI = 0;
                        while((indexValue =finalFormula.indexOf(tempToken,dummyI)) !=-1 && dummyI <=finalFormula.length())
                        {
                            sourceBuffer= new StringBuffer(finalFormula);
							tempFormula ="((eval(\"parent.ChartRecordingDetailFrame.document.forms[0].custom_"+tempString+"\") == null)? 0 : eval(\"parent.ChartRecordingDetailFrame.document.forms[0].custom_"+tempString+".value\")=="+emptyString+" ? 0 :parseFloat(eval(\"parent.ChartRecordingDetailFrame.document.forms[0].custom_"+tempString+".value\")) )";
                            sourceBuffer=sourceBuffer.replace(indexValue,indexValue +tempToken.length(),tempFormula);
                            finalFormula =  sourceBuffer.toString();
                            dummyJ =  finalFormula.indexOf(tempFormula,dummyI);
                            dummyI =dummyI +dummyJ + tempFormula.length() + 1;

                        }
                    }
                }
        }

        return finalFormula;
    }    //********************************************************************************//

    /* this method is used for loading the scripting
     * variables with the new values taken from the Hashtable
     */
    private void loadScriptingVariables(String locale) 
    {
		java.util.Locale loc = new java.util.Locale(locale);

		java.util.ResourceBundle common_labels	= java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
		
		String strSelect = "";

		String tempSummationFormula = "";
        shortDesc = "";
        component = new StringBuffer();
        groupHeading = "";
        uom="";
		String num_dflt_result="";
        String groupId = "";
        String discrMsrId="";
        String textName="";
        graph ="&nbsp;";

		String minValue = "";
		String maxValue = "";

        stringArray = new ArrayList();
        discrArray = new ArrayList();
        for(int indexI = 0; indexI < arrList.size();indexI++)
        {
            HashMap tempHash = (HashMap)arrList.get(indexI);
             groupId= checkForNull((String)(tempHash.get("CHART_GROUP_ID")));

              discrMsrId= checkForNull((String)(tempHash.get("DISCR_MSR_ID")));
            textName = groupId+"_"+discrMsrId;
            stringArray.add(indexI,textName);
            discrArray.add(discrMsrId);
			

        }
		
        if(index < arrList.size())
        {

            HashMap hash = (HashMap)arrList.get(index);



            //for summation of values and formula at the bottom
            String sumYN = checkForNull((String)(hash.get("SUM_YN")));
            //String sumDsrcId = (String)(hash.get("SUM_DISCR_ID")==null?"":hash.get("SUM_DISCR_ID"));
            //String formulaMemberYN = (String)(hash.get("FORMULA_MENMBER_YN")==null?"N":hash.get("FORMULA_MENMBER_YN"));
            String formulaString = checkForNull((String)(hash.get("FORMULA_STRING")));

            //--------------------

             groupId = checkForNull((String)(hash.get("CHART_GROUP_ID")));
            String groupDesc = checkForNull((String)(hash.get("CHART_GORUP_DESC")));
            if(!prevGroupId.equals(groupId))
            {
                groupHeading = "<tr><td colspan='5' class='CACHARTFOURTHLEVELCOLOR'><font size='1'>"+groupDesc+"</font></td></tr>";
                counter++;
            }

            uom = checkForNull((String)(hash.get("UOM")));
            num_dflt_result = checkForNull((String)(hash.get("NUM_DFLT_RESULT")));
            discrMsrId = checkForNull((String)(hash.get("DISCR_MSR_ID")));
            associate_score_yn = checkForNull((String)(hash.get("ASSOCIATE_SCORE_YN"))); //IN045223.1

            shortDesc = checkForNull((String)(hash.get("SHORT_DESC")));
            String type = checkForNull((String)(hash.get("RESULT_TYPE")));
            
            String maxSize = checkForNull((String)(hash.get("NUM_MAX")));
            
			if (maxSize.equals(""))
			{
				maxSize = "20";
			}
           // if(Integer.parseInt(maxSize)==0)
		   if(Float.parseFloat(maxSize)==0)
            {
                maxSize = "20";
            }
					
			String minSize = checkForNull((String)(hash.get("NUM_MIN")));
            String decSize = checkForNull((String)(hash.get("NUM_DEC")));

			minValue = checkForNull((String)(hash.get("MIN_VALUE")));
			maxValue = checkForNull((String)(hash.get("MAX_VALUE")));

		/*	if(minValue.equals("")||Integer.parseInt(minValue)==0)
			{
				minValue = "0";
			}
            if(maxValue.equals("")||Integer.parseInt(maxValue)==0)
            {
                maxValue = "0";
            }
		*/	
		
			if(minValue.equals("")||Float.parseFloat(minValue)==0)
			{
				//minValue = "0";
			}
            if(maxValue.equals("")||Float.parseFloat(maxValue)==0)
            {
                //maxValue = "0";
            }

	        String normalLow = checkForNull((String)(hash.get("NORMAL_LOW")));
            String normalHigh = checkForNull((String)(hash.get("NORMAL_HIGH")));
            String criticalLow = checkForNull((String)(hash.get("CRITICAL_LOW")));
            String criticalHigh = checkForNull((String)(hash.get("CRITICAL_HIGH")));

            String mandatory = checkForNull((String)(hash.get("MANDATORY_YN")));

            String tooltip1 = checkForNull((String)(hash.get("TOOL_TIP")));
            String tooltip="";
            if(!tooltip1.equals(""))
            tooltip = "Formula : " + tooltip1;
            //constructing formula for summation

            //temporarly added for the new graphs
            String growthId = "";
            if(discrMsrId.equals("GRCHARTH"))
                    growthId = "H";
            else if(discrMsrId.equals("GRCHART"))
                    growthId = "W";
            else if(discrMsrId.equals("GCHARTHC"))
                    growthId = "C";
            
	
			//----------------------------------
            //if(sumYN.equals("Y"))
            //{
            if(type.equals("A")){

                    summationFormula = constructFormula(formulaString,groupId,"S");
                    tempSummationFormula  = constructFormula(formulaString,groupId,"D");

                }
            //}
            else
            {
                summationFormula ="0";
            }

            if(type.equals("L"))
            {
				int cntDflt = 0;
                String sqlSelect = "select ref_rng_desc,NORM_ABNORM_IND,DFLT_YN,NUMERIC_VALUE REF_RANGE_SEQ from AM_DISCR_MSR_RF_RNG_LS_LANG_VW where  discr_msr_id= ? and language_id = ? order by SORT_ORDER,ref_rng_desc";
				String dispForm = "";
				//String associate_score = checkForNull((String)(hash.get("ASSOCIATE_SCORE_YN"))); //IN045223.1 commented
				String associate_score = associate_score_yn; //IN045223.1

				if(associate_score.equals("Y") || associate_score.equals("y"))
				{
					dispForm = "onblur=\"displayFormula()\" ";
				}
				else
				{
					dispForm = "";
				}
                try{
                    pstmt = con.prepareStatement(sqlSelect);
                    pstmt.setString(1,discrMsrId);
                    pstmt.setString(2,locale);
                    rs = pstmt.executeQuery();
                    String desc="",code="",dflt="",selected="";
					strSelect = common_labels.getString("Common.defaultSelect.label");
                    component.append( "<Select name='list_"+index+"' OnChange='document.forms[0].comp_"+index+".value=this.value;document.forms[0].listItemValue"+index+".value=this.options[selectedIndex].text;document.forms[0].custom_"+groupId+"_"+discrMsrId+".value=this.value'  "+dispForm+" >");
                    component.append("<option value=''>------"+strSelect+"------</option>");

                    while(rs.next())
                    {
                        desc = rs.getString(1)==null?"":rs.getString(1).trim();
                        normalInd = checkForNull(rs.getString(2));

                        dflt = checkForNull(rs.getString(3));
                        //code = checkForNull(rs.getString(4));
                        code = rs.getString(4) == null ? "" : rs.getString(4);

                        if(dflt.trim().equalsIgnoreCase("Y") )
						{
                            selected="selected";
							cntDflt++;
						}
                        else 
							selected="";
                        component.append("<option value='"+code+"' "+selected+">"+desc+"</option>");
                    }
                    if(rs!=null)rs.close();
                    if(pstmt!=null)pstmt.close();
                }
                catch(Exception ee)
				{
					ee.printStackTrace();
				}
                component.append("</select>");
                component.append("<input type='hidden' name='custom_"+groupId+"_"+discrMsrId+"'>");
                component.append("<input type='hidden' name='listItemValue"+index+"' >");
                component.append("<input type='hidden' name='comp_"+index+"' >");
                component.append("<input type='hidden' name='cntDflt_"+index+"' value='"+cntDflt+"'>");
                component.append("<input type=hidden name='dis_msr_type_"+index+"' value='"+type+"'>");
                //component.append("<input type=hidden name='uom_"+index+"' value='"+uom+"'>");
                component.append("<input type=hidden name='dis_msr_id_"+index+"' value='"+discrMsrId+"'>");
                component.append("<input type=hidden name='normal_low_"+index+"' value='"+normalLow+"'>");
                component.append("<input type=hidden name='normal_high_"+index+"' value='"+normalHigh+"'>");
                component.append("<input type=hidden name='critical_low_"+index+"' value='"+criticalLow+"'>");
                component.append("<input type=hidden name='associate_score_yn"+index+"' value='"+associate_score_yn+"'>");
                component.append("<input type=hidden name='critical_high_"+index+"' value='"+criticalHigh+"'>");
                component.append("<input type=hidden name='normal_abnormal_ind_"+index+"' value='"+normalInd+"'>");
                component.append("<input type=hidden name='event_grp_desc_"+index+"' value=\""+shortDesc+"\">");
                component.append("<input type=hidden name='chat_grp_id_"+index+"' value='"+groupId+"'>");
                component.append("<input type=hidden name='mandatory_yn_"+index+"' value='"+mandatory+"'>");
                component.append("<input type='hidden' name='discr_msr_id_grp_id"+index+"' value='custom_"+groupId+"_"+discrMsrId+"'>");
                graph = "<input type='checkbox' name='chkGraph' value='"+groupId+"~"+discrMsrId+"' class='"+index+"' onClick=\"addToGroups(this,'"+shortDesc+"','"+discrMsrId+"')\"></input>";

                normalInd ="";

            }

            //added for summation charting
            else if(type.equals("A"))
            {


                //component = "<input type='text' name='comp_formula' title='"+tooltip+"' size=4 readOnly>&nbsp;<input type=button class=button name=formula_btn value='?' title='"+tooltip+"' onclick='document.forms(0).comp_formula.value= "+summationFormula+";'>";

                if(!summationFormula.equals("")){
                component.append( "<input type='text' name='custom_"+groupId+"_"+discrMsrId+"'  style='field 200x18 \"Small text\" font-size 9'  size=4 readOnly OnChange='document.forms[0].comp_"+index+".value=this.value' onkeypress=\"return allowValidNumberLocal3(this, event)\" >&nbsp;<input type=button class=button name='comp_"+index+"F' value='+' title='"+tooltip+"' onclick='checkForNaN(document.forms[0].custom_"+groupId+"_"+discrMsrId+","+summationFormula+",document.forms[0].comp_"+index+")'>");
                component.append("<input type='hidden' name='listItemValue"+index+"' >");
                component.append("<input type='hidden' name='comp_"+index+"'>");
                component.append("<input type='hidden' name='comp_formula"+index+"' value='"+tempSummationFormula+"'>");
                component.append("<input type='hidden' name='discr_msr_id_grp_id"+index+"' value='custom_"+groupId+"_"+discrMsrId+"'>");
                }
                else
                {
                        summationFormula ="X";
                        tempSummationFormula = "";
                        component.append( "<input type='text' style='field 200x18 \"Small text\" font-size 9'  name='custom_"+groupId+"_"+discrMsrId+"'  size=4 readOnly OnChange='document.forms[0].comp_"+index+".value=this.value' onkeypress=\"return allowValidNumberLocal3(this, event)\" >&nbsp;<input type=button class=button name='comp_"+index+"F' value='+' title='"+tooltip+"' onclick='checkForNaN(document.forms[0].custom_"+groupId+"_"+discrMsrId+",\""+summationFormula+"\",document.forms[0].comp_"+index+")'>");
                        component.append("<input type='hidden' name='listItemValue"+index+"' >");
                        component.append("<input type='hidden' name='comp_"+index+"' value='"+summationFormula+"'>");
                        component.append("<input type='hidden' name='comp_formula"+index+"' value='"+tempSummationFormula+"'>");
                        component.append("<input type='hidden' name='discr_msr_id_grp_id"+index+"' value='custom_"+groupId+"_"+discrMsrId+"'>");
                }

                component.append("<input type=hidden name='dis_msr_type_"+index+"' value='"+type+"'>");
                //component.append("<input type=hidden name='uom_"+index+"' value='"+uom+"'>");
                component.append("<input type=hidden name='dis_msr_id_"+index+"' value='"+discrMsrId+"'>");
                component.append("<input type=hidden name='normal_low_"+index+"' value='"+normalLow+"'>");
                component.append("<input type=hidden name='normal_high_"+index+"' value='"+normalHigh+"'>");
                component.append("<input type=hidden name='critical_low_"+index+"' value='"+criticalLow+"'>");
                component.append("<input type=hidden name='associate_score_yn"+index+"' value='"+associate_score_yn+"'>");
                component.append("<input type=hidden name='critical_high_"+index+"' value='"+criticalHigh+"'>");
                component.append("<input type=hidden name='normal_abnormal_ind_"+index+"' value='"+normalInd+"'>");
                component.append("<input type=hidden name='chat_grp_id_"+index+"' value='"+groupId+"'>");
                component.append("<input type=hidden name='mandatory_yn_"+index+"' value='"+mandatory+"'>");
                component.append("<input type=hidden name='event_grp_desc_"+index+"' value=\""+shortDesc+"\">");
                graph = "<input type='checkbox' name='chkGraph' value='"+groupId+"~"+discrMsrId+"' class='"+index+"' onClick=\"addToGroups(this,'"+shortDesc+"','"+discrMsrId+"')\"></input>";
                normalInd ="";
                summationFormula ="0";
                Discmeasureid=discrMsrId; //IN068742
            }
            //------------------------
            else if(type.equals("C"))
            {

                component.append( "<input type='checkbox' name='custom_"+groupId+"_"+discrMsrId+"' onkeypress=\"return allowValidNumberLocal3(this, event)\"  OnClick='evalCheckBox(this,document.forms[0].comp_"+index+")'> ");
                component.append("<input type=hidden name='comp_"+index+"'>");
                component.append("<input type='hidden' name='discr_msr_id_grp_id"+index+"' value='custom_"+groupId+"_"+discrMsrId+"'>");
                component.append("<input type=hidden name='dis_msr_type_"+index+"' value='"+type+"'>");
                //component.append("<input type=hidden name='uom_"+index+"' value='"+uom+"'>");
                component.append("<input type=hidden name='dis_msr_id_"+index+"' value='"+discrMsrId+"'>");
                component.append("<input type=hidden name='normal_low_"+index+"' value='"+normalLow+"'>");
                component.append("<input type=hidden name='normal_high_"+index+"' value='"+normalHigh+"'>");
                component.append("<input type=hidden name='critical_low_"+index+"' value='"+criticalLow+"'>");
                component.append("<input type=hidden name='associate_score_yn"+index+"' value='"+associate_score_yn+"'>");
                component.append("<input type=hidden name='critical_high_"+index+"' value='"+criticalHigh+"'>");
                component.append("<input type=hidden name='normal_abnormal_ind_"+index+"' value='"+normalInd+"'>");
                component.append("<input type=hidden name='event_grp_desc_"+index+"' value=\""+shortDesc+"\">");
                component.append("<input type=hidden name='chat_grp_id_"+index+"' value='"+groupId+"'>");
                component.append("<input type=hidden name='mandatory_yn_"+index+"' value='"+mandatory+"'>");
                component.append("<input type='hidden' name='discr_msr_id_grp_id"+index+"' value='custom_"+groupId+"_"+discrMsrId+"'>");

            }
            else if(type.equals("N")||type.equals("I"))
            {
				if(num_dflt_result.length() > Integer.parseInt(maxSize))
					num_dflt_result = "";

				normalInd = "";
				if(!num_dflt_result.equals(""))
				{
					String highStr = "", lowStr = "", cricHighStr = "", cricLowStr = "";
					try
					{
						pstmt = con.prepareStatement("select HIGH_STR,LOW_STR,CRIT_HIGH_STR,CRIT_LOW_STR from cr_clin_event_param");		
						rs = pstmt.executeQuery();
						while(rs.next())
						{
							highStr = checkForNull(rs.getString("HIGH_STR"));
							lowStr = checkForNull(rs.getString("LOW_STR"));
							cricHighStr = checkForNull(rs.getString("CRIT_HIGH_STR"));
							cricLowStr = checkForNull(rs.getString("CRIT_LOW_STR"));
						}
						if(rs != null)rs.close();
						if(pstmt != null)pstmt.close();
					}
					catch(Exception ee)
					{
						ee.printStackTrace();
					}

					if(Float.parseFloat(num_dflt_result) != 0)
					{	
						if((!normalLow.equals("") && Float.parseFloat(normalLow) != 0) && (!normalHigh.equals("") && Float.parseFloat(normalHigh) != 0) && (!criticalLow.equals("") && Float.parseFloat(criticalLow) != 0) &&  (!criticalHigh.equals("") && Float.parseFloat(criticalHigh) != 0))
						{
							if(Float.parseFloat(num_dflt_result) >= Float.parseFloat(criticalLow) && Float.parseFloat(num_dflt_result) < Float.parseFloat(normalLow))
							{
								normalInd = lowStr;
							}
							else if(Float.parseFloat(num_dflt_result) > Float.parseFloat(criticalHigh))
							{
								normalInd = cricHighStr;
							}
							else if(Float.parseFloat(num_dflt_result) < Float.parseFloat(criticalLow))
							{
								normalInd = cricLowStr;
							}
							else if(Float.parseFloat(num_dflt_result) > Float.parseFloat(normalHigh) && Float.parseFloat(num_dflt_result) <= Float.parseFloat(criticalHigh))
							{
								normalInd = highStr;
							}
						}
						else
						{
							if(!normalLow.equals("") && Float.parseFloat(normalLow) != 0)
							{	
								if(!criticalLow.equals("") && Float.parseFloat(criticalLow) != 0)
								{
									if(Float.parseFloat(num_dflt_result) < Float.parseFloat(criticalLow)) 								normalInd = cricLowStr;
									else if((Float.parseFloat(num_dflt_result) >= Float.parseFloat(criticalLow))&&(Float.parseFloat(num_dflt_result) < Float.parseFloat(normalLow)))
										normalInd = lowStr;
								}
								else if(Float.parseFloat(num_dflt_result) < Float.parseFloat(normalLow)) normalInd = lowStr;
							}

							if(!normalHigh.equals("") && Float.parseFloat(normalHigh) != 0)
							{	
								if(!criticalHigh.equals("") && Float.parseFloat(criticalHigh) != 0)
								{
									if(Float.parseFloat(num_dflt_result) > Float.parseFloat(criticalHigh)) 
										normalInd = cricHighStr;
									else if((Float.parseFloat(num_dflt_result) <= Float.parseFloat(criticalHigh))&&(Float.parseFloat(num_dflt_result) > Float.parseFloat(normalHigh)))
										normalInd = highStr;	
								}
								else if(Float.parseFloat(num_dflt_result) > Float.parseFloat(normalHigh)) normalInd = highStr;					
							}
						}												
					}
				}

				int tempMaxSize = 0;

				if(type.equals("I")) decSize = "0";

				if(type.equals("N"))
					tempMaxSize = Integer.parseInt(maxSize) + 1;
				else
					tempMaxSize = Integer.parseInt(maxSize);
					
	        
				
               component.append( "<input type='text' style='field 200x18 \"Small text\" font-size 9'  name='custom_"+groupId+"_"+discrMsrId+"' size='"+maxSize+"' maxLength='"+maxSize+"' value='"+num_dflt_result+"' onkeypress=\"return allowValidNumberLocal2(this, event, '"+maxSize+"','"+decSize+"')\" onblur= \"validateNumber(this,'"+normalLow+"','"+normalHigh+"','"+index+"','"+decSize+"','"+criticalLow+"','"+criticalHigh+"','"+minSize+"','"+minValue+"','"+maxValue+"');displayFormula()");
               //component.append( "<input type='text' style='field 200x18 \"Small text\" font-size 9'  name='custom_"+groupId+"_"+discrMsrId+"' size='"+maxSize+"' maxlength='"+maxSize+"'  value='"+num_dflt_result+"' onkeypress=\"return allowValidNumber(this, event, '"+tempMaxSize+"','"+tempMaxSize+"')\" onblur= \"validateNumber(this,'"+normalLow+"','"+normalHigh+"','"+index+"','"+decSize+"','"+criticalLow+"','"+criticalHigh+"','"+minSize+"','"+minValue+"','"+maxValue+"');displayFormula()");
                component.append(" \" OnChange='document.forms[0].comp_"+index+".value=this.value'>");
                //if(num_dflt_result.equals(""))
				component.append("<input type='hidden' name='comp_"+index+"' value='"+num_dflt_result+"'>");
                component.append("<input type='hidden' name='listItemValue"+index+"' >");
				component.append("<input type='hidden' name='result_prefix"+index+"' value=''>");
                if(sumYN.equals("Y"))
                {
                    component.append("document.forms[0]."+groupId+"_sum.value= "+summationFormula+";");
                }


                component.append("<input type=hidden name='dis_msr_type_"+index+"' value='"+type+"'>");
               //component.append("<input type=hidden name='uom_"+index+"' value='"+uom+"'>");
                component.append("<input type=hidden name='dis_msr_id_"+index+"' value='"+discrMsrId+"'>");
                component.append("<input type=hidden name='normal_low_"+index+"' value='"+normalLow+"'>");
                component.append("<input type=hidden name='normal_high_"+index+"' value='"+normalHigh+"'>");
                component.append("<input type=hidden name='critical_low_"+index+"' value='"+criticalLow+"'>");
                component.append("<input type=hidden name='associate_score_yn"+index+"' value='"+associate_score_yn+"'>");
                component.append("<input type=hidden name='critical_high_"+index+"' value='"+criticalHigh+"'>");
                component.append("<input type=hidden name='normal_abnormal_ind_"+index+"' value='"+normalInd+"'>");
                component.append("<input type=hidden name='chat_grp_id_"+index+"' value='"+groupId+"'>");
                component.append("<input type=hidden name='mandatory_yn_"+index+"' value='"+mandatory+"'>");
                //for graph
                component.append("<input type=hidden name='event_grp_desc_"+index+"' value=\""+shortDesc+"\">");
                component.append("<input type='hidden' name='discr_msr_id_grp_id"+index+"' value='custom_"+groupId+"_"+discrMsrId+"'>");

                //graph = "<input type='checkbox' name='chkGraph' value='"+counter+"' title='"+index+"' onClick=\"//limitTheGraphs('"+index+"')\"></input>";
                //included temporarly for using another graph

				


                if(chartId.equals("GRCT"))
                {
                    graph = "<input type='checkbox' name='chkGraph' value='"+groupId+"~"+discrMsrId+"' class='"+index+"' onClick=\"addToGroups(this,'"+shortDesc+"','"+discrMsrId+"')\"></input>";
                }
                else
                {
                    graph = "<input type='checkbox' name='chkGraph' value='"+groupId+"~"+discrMsrId+"' class='"+index+"' onClick=\"addToGroups(this,'"+shortDesc+"','"+discrMsrId+"')\"></input>";
                }


            }
            else if(type.equals("D"))
            {


                component.append( "<input type='text' style='field 200x18 \"Small text\" font-size 9'  name='custom_"+groupId+"_"+discrMsrId+"' size='10' maxlength='10' value='' onblur= \"checkDateForDetail(this);document.forms[0].comp_"+index+".value=this.value\"    OnChange='document.forms[0].comp_"+index+".value=this.value'>");
                component.append( "<input type='image' src='../../eCommon/images/CommonCalendar.gif' onclick='return showCalendarValidateForDate(\"custom_"+groupId+"_"+discrMsrId+"\")'>");
                component.append("<input type='hidden' name='listItemValue"+index+"' >");
                component.append("<input type=hidden name='comp_"+index+"'  value=''>");
                component.append("<input type=hidden name='dis_msr_type_"+index+"' value='"+type+"'>");
                //component.append("<input type=hidden name='uom_"+index+"' value='"+uom+"'>");
                component.append("<input type=hidden name='dis_msr_id_"+index+"' value='"+discrMsrId+"'>");
                component.append("<input type=hidden name='normal_low_"+index+"' value='"+normalLow+"'>");
                component.append("<input type=hidden name='normal_high_"+index+"' value='"+normalHigh+"'>");
                component.append("<input type=hidden name='critical_low_"+index+"' value='"+criticalLow+"'>");
                component.append("<input type=hidden name='associate_score_yn"+index+"' value='"+associate_score_yn+"'>");
                component.append("<input type=hidden name='critical_high_"+index+"' value='"+criticalHigh+"'>");
                component.append("<input type=hidden name='normal_abnormal_ind_"+index+"' value='"+normalInd+"'>");
                component.append("<input type=hidden name='event_grp_desc_"+index+"' value=\""+shortDesc+"\">");
                component.append("<input type=hidden name='chat_grp_id_"+index+"' value='"+groupId+"'>");
                component.append("<input type=hidden name='mandatory_yn_"+index+"' value='"+mandatory+"'>");
                component.append("<input type='hidden' name='discr_msr_id_grp_id"+index+"' value='custom_"+groupId+"_"+discrMsrId+"'>");

            }
            else if(type.equals("E"))
            {

				component.append( "<input type='text' style='field 200x18 \"Small text\" font-size 9'  name='custom_"+groupId+"_"+discrMsrId+"' size='16' maxlength='16' value='' onblur= \"CheckDateTime(this);document.forms[0].comp_"+index+".value=this.value\"    OnChange='document.forms[0].comp_"+index+".value=this.value'>");
                component.append( "<input type='image' src='../../eCommon/images/CommonCalendar.gif' onclick='return showCalendarValidate(\"custom_"+groupId+"_"+discrMsrId+"\")'>");
                component.append("<input type='hidden' name='listItemValue"+index+"' >");
                component.append("<input type=hidden name='comp_"+index+"'  value=''>");
                component.append("<input type=hidden name='dis_msr_type_"+index+"' value='"+type+"'>");
               // component.append("<input type=hidden name='uom_"+index+"' value='"+uom+"'>");
                component.append("<input type=hidden name='dis_msr_id_"+index+"' value='"+discrMsrId+"'>");
                component.append("<input type=hidden name='normal_low_"+index+"' value='"+normalLow+"'>");
                component.append("<input type=hidden name='normal_high_"+index+"' value='"+normalHigh+"'>");
                component.append("<input type=hidden name='critical_low_"+index+"' value='"+criticalLow+"'>");
                component.append("<input type=hidden name='associate_score_yn"+index+"' value='"+associate_score_yn+"'>");
                component.append("<input type=hidden name='critical_high_"+index+"' value='"+criticalHigh+"'>");
                component.append("<input type=hidden name='normal_abnormal_ind_"+index+"' value='"+normalInd+"'>");
                component.append("<input type=hidden name='event_grp_desc_"+index+"' value=\""+shortDesc+"\">");
                component.append("<input type=hidden name='chat_grp_id_"+index+"' value='"+groupId+"'>");
                component.append("<input type=hidden name='mandatory_yn_"+index+"' value='"+mandatory+"'>");
                component.append("<input type='hidden' name='discr_msr_id_grp_id"+index+"' value='custom_"+groupId+"_"+discrMsrId+"'>");

            }
            else if(type.equals("T"))
            {

                component.append( "<input type='text' style='field 200x18 \"Small text\" font-size 9'  name='custom_"+groupId+"_"+discrMsrId+"' size='5' maxlength='5' value='' onblur= \"chkValidityOfTime(this);\"    OnChange='document.forms[0].comp_"+index+".value=this.value'>");
                component.append("<input type='hidden' name='listItemValue"+index+"' >");
                component.append("<input type=hidden name='comp_"+index+"'  value=''>");
                component.append("<input type=hidden name='dis_msr_type_"+index+"' value='"+type+"'>");
                //component.append("<input type=hidden name='uom_"+index+"' value='"+uom+"'>");
                component.append("<input type=hidden name='dis_msr_id_"+index+"' value='"+discrMsrId+"'>");
                component.append("<input type=hidden name='normal_low_"+index+"' value='"+normalLow+"'>");
                component.append("<input type=hidden name='normal_high_"+index+"' value='"+normalHigh+"'>");
                component.append("<input type=hidden name='critical_low_"+index+"' value='"+criticalLow+"'>");
                component.append("<input type=hidden name='associate_score_yn"+index+"' value='"+associate_score_yn+"'>");
                component.append("<input type=hidden name='critical_high_"+index+"' value='"+criticalHigh+"'>");
                component.append("<input type=hidden name='normal_abnormal_ind_"+index+"' value='"+normalInd+"'>");
                component.append("<input type=hidden name='event_grp_desc_"+index+"' value=\""+shortDesc+"\">");
                component.append("<input type=hidden name='chat_grp_id_"+index+"' value='"+groupId+"'>");
                component.append("<input type=hidden name='mandatory_yn_"+index+"' value='"+mandatory+"'>");
                component.append("<input type='hidden' name='discr_msr_id_grp_id"+index+"' value='custom_"+groupId+"_"+discrMsrId+"'>");

            }
            else
            {

				//IN043178 starts - reverted the changes for long text emg issue IN045648
                component.append( "<input type='text' style='field 200x18 \"Small text\" font-size 9'  name='custom_"+groupId+"_"+discrMsrId+"' size='20' maxlength='20' value='' onkeypress=\"return allowValidNumberLocal3(this, event)\" style='field 200x18 \"Small text\" font-size 9' OnChange='document.forms[0].comp_"+index+".value=this.value'>");
				//component.append( "<input type='text' style='field 200x18 \"Small text\" font-size 9'  name='custom_"+groupId+"_"+discrMsrId+"' size='20' maxlength='20' value='' onkeypress=\"return allowValidNumberOnKeyPress(this, event)\" style='field 200x18 \"Small text\" font-size 9' OnChange='document.forms(0).comp_"+index+".value=this.value' onblur=\"allowValidNumberOnBlur(this)\">");
				//IN043178 ends
                component.append("<input type='hidden' name='listItemValue"+index+"' >");
                component.append("<input type=hidden name='comp_"+index+"'  value=''>");
                component.append("<input type=hidden name='dis_msr_type_"+index+"' value='"+type+"'>");
                //component.append("<input type=hidden name='uom_"+index+"' value='"+uom+"'>");
                component.append("<input type=hidden name='dis_msr_id_"+index+"' value='"+discrMsrId+"'>");
                component.append("<input type=hidden name='normal_low_"+index+"' value='"+normalLow+"'>");
                component.append("<input type=hidden name='normal_high_"+index+"' value='"+normalHigh+"'>");
                component.append("<input type=hidden name='critical_low_"+index+"' value='"+criticalLow+"'>");
                component.append("<input type=hidden name='associate_score_yn"+index+"' value='"+associate_score_yn+"'>");
                component.append("<input type=hidden name='critical_high_"+index+"' value='"+criticalHigh+"'>");
                component.append("<input type=hidden name='normal_abnormal_ind_"+index+"' value='"+normalInd+"'>");
                component.append("<input type=hidden name='event_grp_desc_"+index+"' value=\""+shortDesc+"\">");
                component.append("<input type=hidden name='chat_grp_id_"+index+"' value='"+groupId+"'>");
                component.append("<input type=hidden name='mandatory_yn_"+index+"' value='"+mandatory+"'>");
                component.append("<input type='hidden' name='discr_msr_id_grp_id"+index+"' value='custom_"+groupId+"_"+discrMsrId+"'>");

            }

            //check for mandatory
            if(mandatory.equals("Y") && !type.equals("A"))
            {
                component.append("<img align=center src='../../eCommon/images/mandatory.gif'></img>");
            }
            hash = null;
            if(!type.equals("A")){
            if((index%2)==0)
                classValue    =    "gridDataChart";
            else
                classValue    =    "gridDataChart";
            }
            else
            {

                if((index%2)==0)
                classValue    =    "gridDataChart";
            else
                classValue    =    "gridDataChart";
            }
            //resetting the prev Values
            prevGroupId = groupId;


            counter++;
        }
        component.append("<input type='hidden' name='sequence' value= '"+index+"'>");
		component.append("<input type='hidden' name='defaultYN' value= '"+defaultYN+"'>");
		component.append("<input type='hidden' name='remarksField"+index+"' value= ''>");

        //loading the latest values into the scripting variables
		displayString.append(groupHeading);
		displayString.append("<tr>");
		displayString.append("<td class='" + classValue + "'><font size='1'>" + shortDesc + "</font></td>");
		
		if(modifyYN.equals("Y"))
		{
			displayString.append("<td class='" + classValue + "'><font size='1'>" + component + "</font></td>");
			
			displayString.append("<td class='" + classValue + "' align='center'><font size='2'><a id = 'comment"+index+"' style='color:blue' href='javascript:callRecordComment("+index+")' title='Click here to record comments'>R</a></font></td>"); //IN00000
		}

		//displayString.append("<td class='" + classValue + "' align='center'><font size='2'><a id = 'comment"+index+"' style='color:blue' href='javascript:callRecordComment("+index+")' title='Click here to record comments'>R</a></font></td>"); //IN00000 moved tag into if condition

		displayString.append("<td class='" + classValue + "'><font size='1'>" + uom + "</font></td>");
		displayString.append("<input type=hidden name='uom_"+index+"' value='"+uom+"'>");

		if(!function_from.equals("SECONDARY_TRIAGE"))
		{

			displayString.append("<td class='" + classValue + "' align=center>" + graph + "</td>");
		}
		displayString.append("</tr>");		
    }
    /* callback Methods starts from here
     *
     */
    public void setChartId(String chartId)
    {
        this.chartId = chartId;
    }
    public String getChartId()
    {
        return chartId;
    }
    public void setDescrMsrIds(String descrMsrIds)
    {
        this.descrMsrIds = descrMsrIds;
    }
    public String getDescrMsrIds()
    {
        return descrMsrIds;
    }
    public StringBuffer getChartLayout(HttpServletRequest request,String locale)
    {
        //processing of the tag starts from here
        try
        {
			String facilityId = (String)request.getSession().getAttribute("facility_id");			

            //getting the connection object
            con = ConnectionManager.getConnection(request);
            //load the data in the hashmap-arraylist format in the arraylist
            loadDataArrayList(facilityId, request,locale);
            //if there is any record then evaluate the tag else SKIP_body
			if(arrList != null && arrList.size()>0)
			{				
				while(index < arrList.size())
				{
					loadScriptingVariables(locale);
					index++;

				}
			}		
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
		finally
		{
			if(con != null) ConnectionManager.returnConnection(con);
		}
		release();
		return displayString;
    }        
    public void release()
    {
        try
        {
            //arrList = null;
            if(rs != null)rs.close();
            if(pstmt != null)pstmt.close();
        }
        catch(Exception e)
        {
			e.printStackTrace();
        }
    }
    private String checkForNull(String strParam)
    {
            String str ="";
            if(strParam!=null && strParam.length() >0)
            str = strParam;
            return str;
    }
}
