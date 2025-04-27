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

public class FDBDrugAlerggyCheck
{

    public FDBDrugAlerggyCheck(FDBDataManager fwConn)throws IOException
    {
        this.fwConn = fwConn;
    }


   public HashMap getDrugAllergies(ArrayList drugList, ArrayList alergyList) throws FDBException, Exception
    {
        screenDrugs = new ScreenDrugs();
		Drug_alergies = new HashMap();
		if(alergyList!=null && alergyList.size()>0)
			setAllergenList(alergyList);
        for(int i = 0; i < drugList.size(); i++)
        {
            screenDrug = new ScreenDrug(fwConn);//FDB
			screenDrug.load(drugList.get(i).toString(), FDBDrugType.fdbDTGCNSeqNo, ""); //FDB API 
			screenDrug.setProspective(true);//SETTING VALUE FDB API 
			DispensableGeneric dispGeneric = new DispensableGeneric(fwConn);// FDB API 
			dispGeneric.load(Long.parseLong(drugList.get(i).toString()), "", "");// FDB API 
            screenDrug.setDescription(dispGeneric.getDescription());//SETTING DRUG DESC IN FDB API 
            screenDrugs.addItem(screenDrug);//ADDING DRUGS TO FDB API FOR SCREEING DRUGS
            String alergy_result = (String)setDrugAlergyResult();
			if(!alergy_result.equals("")){
				Drug_alergies.put(drugList.get(i).toString(),alergy_result );
			}
        }
		return Drug_alergies;
    }


	private void setAllergenList(ArrayList alergyList) throws FDBException, Exception
    {
        ScreenAllergies = new ScreenAllergies();
        for(int i = 0; i < alergyList.size(); i++)
        {
            ScreenAllergy = new ScreenAllergy(fwConn);//FDB
			ScreenAllergy.load(alergyList.get(i).toString(), FDBAllergyType.fdbATGCNSeqNo); //FDB API 
			ScreenAllergy.setProspective(false);//SETTING VALUE FDB API 
			ScreenAllergies.addItem(ScreenAllergy);			
        }
    }

   	private String setDrugAlergyResult() throws FDBException, Exception{
		String contraInd					= "";
	//	ScreenConditions scrCondnList		= new ScreenConditions();	 Removed for IN063877			 
		StringBuffer sbDescList				= new StringBuffer();
		//StringBuffer sbContraDescription	= new StringBuffer();   Removed for IN063877

		Screening scrngObject = new Screening(fwConn);
		DAMScreenResults scrngResultList = scrngObject.DAMScreen(screenDrugs, ScreenAllergies, false);

		 for (int i = 0; i < scrngResultList.count(); i++){
			DAMScreenResult result = scrngResultList.item(i);
			String tmpdesc = result.getScreenMessage();
			if (sbDescList.indexOf(tmpdesc) == -1){
				sbDescList.append(" --> ").append("<b>").append(tmpdesc).append("</b>").append(" <br> ");
			}				
		 }
		contraInd = sbDescList.toString();				
		return contraInd;
	}

/*
    private long drugid;
    private boolean prospectiveOnly;
    private boolean useDuplicateAllowance;
    private FDBDrugType drugType;*/
    private ScreenDrugs screenDrugs;
    private ScreenDrug screenDrug;
    private FDBDataManager fwConn;
	private ScreenAllergy ScreenAllergy;
    private ScreenAllergies ScreenAllergies;
    private HashMap Drug_alergies = null;
}
