/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//import firstdatabank.fdbffc.*;
package webbeans.ePH.FDBInterface;
import firstdatabank.idif.*;
import firstdatabank.database.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.medicom.dif:
//            FrameworkConnectionManager

public class DrugDrugInteraction
{

    public DrugDrugInteraction()
        throws IOException
    {
        FrameworkConnectionManager fwConnMgr = new FrameworkConnectionManager();
        fwConnMgr.setFrameworkConnection();
        fwConn = fwConnMgr.getFrameworkConnection();
        screening = new Screening(fwConn);
        screenDrugsList = new ScreenDrugs();
        drugDrugInteractionResult = new HashMap();
    }

    public void setDrugType(int drugType)
    {
         if(drugType == 1)
            this.drugType = FDBDrugType.fdbDTRoutedDrug;
        else
        if(drugType == 2)
            this.drugType = FDBDrugType.fdbDTDispensableDrug;
        else
        if(drugType == 3)
            this.drugType = FDBDrugType.fdbDTPackagedDrug;
        else
        if(drugType == 4)
            this.drugType = FDBDrugType.fdbDTGCNSeqNo;
        else
        if(drugType == 5)
            this.drugType = FDBDrugType.fdbDTRtGen;
        else
        if(drugType == 6)
            this.drugType = FDBDrugType.fdbDTCompound;
        else
        if(drugType == 7)
            this.drugType = FDBDrugType.fdbDTCustom;
        else
		if(drugType == 8)
            this.drugType = FDBDrugType.fdbDTManufacturedDrug;
        else
        if(drugType == 9)
            this.drugType = FDBDrugType.fdbDTReferenceOnly;
        else
        if(drugType == 10)
            this.drugType = FDBDrugType.fdbDTRoutedDoseFormMedID;
        else
        if(drugType == 11)
            this.drugType = FDBDrugType.fdbDTRoutedDoseFormGeneric;
        else
        if(drugType == 12)
            this.drugType = FDBDrugType.fdbDTRegionalPackagedDrug;

        else
            throw new IllegalArgumentException();
    }

    public void setSeverityFilter(int filterType)
    {
        if(filterType == 1)
            severityFilter = FDBDDIMSeverityFilter.fdbDDIMSFContraindicated;
        else
        if(filterType == 2)
            severityFilter = FDBDDIMSeverityFilter.fdbDDIMSFSevere;
        else
        if(filterType == 3)
            severityFilter = FDBDDIMSeverityFilter.fdbDDIMSFModerate;
        else
        if(filterType == 4)
            severityFilter = FDBDDIMSeverityFilter.fdbDDIMSFUnknownContraindicated;
        else
        if(filterType == 5)
            severityFilter = FDBDDIMSeverityFilter.fdbDDIMSFUnknownSevere;
        else
        if(filterType == 6)
            severityFilter = FDBDDIMSeverityFilter.fdbDDIMSFUnknownModerate;
        else
            throw new IllegalArgumentException();
    }

    public void setProspectiveOnlyAttribute(boolean prospectiveOnlyAttrib)
    {
        prospectiveOnlyAttribute = prospectiveOnlyAttrib;
    }

    public void setUseCustomInteractions(boolean useCustomInteractionAttrib)
    {
        useCustomInteractionsAttribute = useCustomInteractionAttrib;
    }

    public void setDrugList(ArrayList drugIDList)
        throws Exception
    {
        ArrayList drugList = new ArrayList(drugIDList);
        selectScreenDrugs(drugList);
    }

    private void selectScreenDrugs(ArrayList drugList)
        throws Exception
    {
        for(int i = 0; i < drugList.size() - 1; i++)
        {
            for(int j = i + 1; j < drugList.size(); j++)
            {
                ArrayList selectList = new ArrayList();
                selectList.add(drugList.get(i));
                String drugID1 = new String(drugList.get(i).toString());
                selectList.add(drugList.get(j));
                String drugID2 = new String(drugList.get(j).toString());
                loadScreenDrugs(selectList, drugID1, drugID2);
            }

        }

    }

    private void loadScreenDrugs(ArrayList drugList, String drugIDA, String drugIDB)
        throws Exception
    {
        if(screenDrugsList.count() != 0)
            screenDrugsList.clear();
        for(int i = 0; i < drugList.size(); i++)
        {
           
			ScreenDrug screenDrug = new ScreenDrug(fwConn);
			screenDrug.load(drugList.get(i).toString(), FDBDrugType.fdbDTGCNSeqNo, ""); //FDB API 
			screenDrug.setProspective(true);//SETTING VALUE FDB API 
			DispensableGeneric dispGeneric = new DispensableGeneric(fwConn);// FDB API 
			dispGeneric.load(Long.parseLong(drugList.get(i).toString()), "", "");// FDB API 
            screenDrug.setDescription(dispGeneric.getDescription());//SETTING DRUG DESC IN FDB API 
			screenDrugsList.addItem(screenDrug);

        }

       setDrugDrugInteractionResult(screenDrugsList, drugIDA, drugIDB);		

    }

   private void setDrugDrugInteractionResult(ScreenDrugs screenDrugsList, String drugIDA, String drugIDB)
        throws Exception
    {
	     HashMap interactionsList = null;
		 DDIMScreenResults screenResultsDDIM = new DDIMScreenResults();
		 screenResultsDDIM = screening.DDIMScreen(screenDrugsList, true, severityFilter, false, false, false, "", false, "");
		 Messages messages = screenResultsDDIM.getMessages(); //GETTING PRE-DEFINED MESSAGES FROM FDB IF DRUGS ARE DUPLICATED
		 long screenResultsCount = screenResultsDDIM.count();
         if(messages!=null && messages.count()>0){



		 }else{

			 int resultCount = screenResultsDDIM.count();

					for (int i = 0; i < resultCount; i++)
					{
						DDIMScreenResult screenResultDDIM = screenResultsDDIM.item(i);
						String tmpdesc    = screenResultDDIM.getDrug1Description();						
						String effectCode = screenResultDDIM.getClinicalEffectCode1();

						if (effectCode == null) 
							effectCode = screenResultDDIM.getClinicalEffectCode2();
						StringBuffer effectDesc = new StringBuffer();

						if (effectCode != null)
						{
							FDBCode fdbCodeObj = new FDBCode(fwConn);
							fdbCodeObj.load(15, effectCode);
							//effectDesc = fdbCodeObj.getDescription();
                              effectDesc.append(" (Severity Level " + screenResultDDIM.getSeverityLevelCode() + ")").append(fdbCodeObj.getDescription());
							interactionsList = new HashMap();
							interactionsList.put(Integer.toString(i + 1), effectDesc.toString());

						}
                      drugDrugInteractionResult.put(new String(drugIDA + "-" + drugIDB), interactionsList);	
						
					}   
    }
	}

    public HashMap getDrugDrugInteraction()
    {
        return drugDrugInteractionResult;
    }

   
	private FDBDataManager fwConn;
    private ScreenDrugs screenDrugsList;
    private Screening screening;
    private HashMap drugDrugInteractionResult;
    private FDBDrugType drugType;
    private FDBDDIMSeverityFilter severityFilter;
    private boolean prospectiveOnlyAttribute;
    private boolean useCustomInteractionsAttribute;
    private ArrayList drugList;
}
