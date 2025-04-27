/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package webbeans.ePH.FDBInterface;

import firstdatabank.idif.*;
import firstdatabank.database.*;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

// Referenced classes of package com.medicom.dif:
//            FrameworkConnectionManager, DrugMedicalConditionSearch

public class MedicalConditionsForICD9Code
{
	private HashMap contraIndications = new HashMap();
	
	public HashMap getContraIndications(){
		return contraIndications;
	}

    public MedicalConditionsForICD9Code()
        throws IOException
    {
        FrameworkConnectionManager fwConnMgr = new FrameworkConnectionManager();
        fwConnMgr.setFrameworkConnection();
        fwConn = fwConnMgr.getFrameworkConnection();
        navig = new Navigation(fwConn);
       // medConds = new MedicalConditions(fwConn);
    }

    public void setICD9Codes(ArrayList ICD9Code)
    {
        this.ICD9Code = ICD9Code;
        setMedicalConditionsForICD9Code();
    }

    private void setMedicalConditionsForICD9Code()
    {
        searchResult = new HashMap();
  /*      for(int i = 0; i < ICD9Code.size(); i++)
        {
           // medConds = navig.medicalConditionsForICD9(ICD9Code.get(i).toString());
            if(medConds.count() > 0)
            {
                for(int j = 0; j < medConds.count(); j++)
                    searchResult.put(new Long(medConds.item(j).getID()), medConds.item(j).getProfessionalName());

            }
        }*/

    }

    public HashMap getMedicalConditionsForICD9Code()
    {
        return searchResult;
    }
	
	 public void setDrugList(ArrayList drugList)
        throws FDBException, Exception{

        screenDrugs = new ScreenDrugs();
        DispensableDrug drug = null;
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
        //setContraIndicationResult();
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

    public static void main(String args[])
    {
        try
        {
            MedicalConditionsForICD9Code medcondforicd9code = new MedicalConditionsForICD9Code();
           // DrugMedicalConditionSearch drugMedicalConditionSearch = null;
            ArrayList icd9code = new ArrayList();
            icd9code.add("04280");
            medcondforicd9code.setICD9Codes(icd9code);
            HashMap map = medcondforicd9code.getMedicalConditionsForICD9Code();
            System.out.println(map);
            Set idset = map.keySet();
          /*  for(Iterator iterator = idset.iterator(); iterator.hasNext(); System.out.println(drugMedicalConditionSearch.getRecommendedDrugs()))
            {
             //   drugMedicalConditionSearch = new DrugMedicalConditionSearch();
               // drugMedicalConditionSearch.setMedCondNameType(2);
               // drugMedicalConditionSearch.setManagementLevelFilter(1);
               // drugMedicalConditionSearch.setAcceptanceLevelFilter(3);
               // drugMedicalConditionSearch.setOutcomeFilter(1);
               // drugMedicalConditionSearch.setDrugSearchFilter(1);
               // drugMedicalConditionSearch.setMedicalCondition(Long.parseLong(iterator.next().toString()));
               // System.out.println(drugMedicalConditionSearch.getNotRecommendedDrugs());
            }*/

        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }
    }

    private FDBDataManager fwConn;
    private Navigation navig;
    private MedicalConditions medConds;
    private ArrayList ICD9Code;
    private HashMap searchResult;
	private ScreenDrugs screenDrugs;
	private ScreenDrug screenDrug;
	private boolean contraFound;
}
