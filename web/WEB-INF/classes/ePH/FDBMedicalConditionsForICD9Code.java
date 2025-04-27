/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH;

import firstdatabank.idif.*;
import firstdatabank.database.*;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

// Referenced classes of package com.medicom.dif:
//            FrameworkConnectionManager, DrugMedicalConditionSearch

public class FDBMedicalConditionsForICD9Code
{
	private HashMap contraIndications = null;
	
    public FDBMedicalConditionsForICD9Code(FDBDataManager fwConn)throws IOException
    {
        this.fwConn = fwConn;
        navig = new Navigation(fwConn);
    }

    public HashMap getContraIndCheckResultForICD9Code (ArrayList ICD9Code, ArrayList drugList)throws FDBException, Exception
    {
        this.ICD9Code = ICD9Code;
		contraIndications = new HashMap();
        screenDrugs = new ScreenDrugs();
   //     DispensableDrug drug = null;  Removed for IN063877
        for(int i = 0; i < drugList.size(); i++)
        {
            screenDrug = new ScreenDrug(fwConn);//FDB
			screenDrug.load(drugList.get(i).toString(), FDBDrugType.fdbDTGCNSeqNo, ""); //FDB API 
			screenDrug.setProspective(true);//SETTING VALUE FDB API 
			DispensableGeneric dispGeneric = new DispensableGeneric(fwConn);// FDB API 
			dispGeneric.load(Long.parseLong(drugList.get(i).toString()), "", "");// FDB API 
            screenDrug.setDescription(dispGeneric.getDescription());//SETTING DRUG DESC IN FDB API 
            screenDrugs.addItem(screenDrug);//ADDING DRUGS TO FDB API FOR SCREEING DRUGS
			String contraIndicat = (String)setContraIndicationResult();
			if(!contraIndicat.equals("")){
				contraIndications.put(drugList.get(i).toString(),contraIndicat);
			}
        }
        return contraIndications;
    }


	private String setContraIndicationResult()
        throws FDBException, Exception{
//				boolean contraFound;
				String contraInd = "";
				ScreenConditions scrCondnList = new ScreenConditions();
				int condnSize = ICD9Code.size();
				for (int i = 0; i < condnSize; i++)
				{
					String clinicalCode = (String) ICD9Code.get(i);
					/*if (ServerConstants.ICD10.equals(clinicalCodeType))
					{
						clinicalCode = objContraIndicationChecksDAO.getClinicalCodeICD9(clinicalCode, oDOLogger);
					}*/
					ScreenCondition scrCondnExist = new ScreenCondition(fwConn);
					scrCondnExist.load(clinicalCode, FDBScreenConditionType.fdbSCTICD9);
					scrCondnList.addItem(scrCondnExist);
				}

				StringBuffer sbDescList				= new StringBuffer();
				StringBuffer sbContraDescription	= new StringBuffer();
				Screening scrngObject = new Screening(fwConn);
				DDCMScreenResults scrngResultList = scrngObject.DDCMScreen(screenDrugs, scrCondnList, true, FDBDDCMSeverityFilter.fdbDDCMSFContraindicated, FDBProxyPredictor.fdbPPCertain);
				Messages msgList = scrngResultList.getMessages();
			if (msgList != null && msgList.count() > 0)	{
					sbContraDescription.append("CONTRAINDICATIONS WARNING\n===================================\n\n");
					int msgCount = msgList.count();
					for (int i = 0; i < msgCount; i++)
					{
				//		oLogger.warn("FDBManager", msgList.item(i).getMessageText(), oDOLogger);
						sbContraDescription.append("<br>--> ").append(msgList.item(i).getMessageText()).append("<br>");
					}
//					sbContraDescription.append("\n\n");
					contraFound = true;
					contraInd = sbContraDescription.toString();
			}else{
					int resultCount = scrngResultList.count();
					for (int i = 0; i < resultCount; i++)
					{
						DDCMScreenResult scrngResult = scrngResultList.item(i);
						String tmpdesc = scrngResult.getDescriptionDisease();
						if (sbDescList.indexOf(tmpdesc) == -1)
						{
							sbDescList.append(" --> ").append("<b>").append(tmpdesc).append(" (Severity Level " + scrngResult.getSeverityLevelCode() + ") : ").append("</b>").append(scrngResult.getScreenMessage()).append(" <br> ");
						}
						contraFound = true;
//						contraInd.add(sbDescList.toString());
//						sbDescList.delete(0,sbDescList.length());
					//	signatureRequired = signatureRequired || isSignificant(Integer.parseInt(scrngResult.getSeverityLevelCode()), iSignatLevel);
					}
					contraInd = sbDescList.toString();
					/*if (contraFound == true)
					{
						int bufLength = sbDescList.length();
						if (bufLength > 2)
						{
							sbDescList.setLength(bufLength - 2);
							//sbContraDescription.append("The Drug ").append(sDrugDesc);
							//sbContraDescription.append(" is found to have contra indications with following patient current conditions \n");
							//sbContraDescription.append(sbDescList);
						}
						Object[] oDynPart = new Object[]{sbDescList};
						String sTmp = CISUtils.getFormattedMessage("CIS_15040", oDynPart, oDOGlobal.getCountry(), oDOGlobal.getLanguage());
						sbContraDescription.append(sTmp).append("\n\n\n");
					}*/
				}
				return contraInd;
	}

	public boolean getContraIndicationResult()
    {
        return contraFound;
    }

    private FDBDataManager fwConn;
    private Navigation navig;
 //   private MedicalConditions medConds;  Removed for IN063877
    private ArrayList ICD9Code;
  //  private HashMap searchResult;   Removed for IN063877
	private ScreenDrugs screenDrugs;
	private ScreenDrug screenDrug;
	private boolean contraFound;
}
