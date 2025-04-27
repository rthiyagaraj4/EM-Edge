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

public class DrugDuplicateTherapy
{

    public DrugDuplicateTherapy()
        throws IOException
    {
        FrameworkConnectionManager fwConnMgr = new FrameworkConnectionManager();
        fwConnMgr.setFrameworkConnection();
        fwConn = fwConnMgr.getFrameworkConnection();
    }

    public void setProspectiveOnly(boolean prospectiveonly)
    {
        prospectiveOnly = prospectiveonly;
    }

    

    public void setUseDuplicateAllowance(boolean useduplicateallowance)
    {
        useDuplicateAllowance = useduplicateallowance;
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

   public void setDrugList(ArrayList drugList,String prod_id)
        throws FDBException, Exception
    {
        screenDrugs = new ScreenDrugs();
        DispensableDrug drug = null;
		drug_det= new HashMap();
        for(int i = 0; i < drugList.size(); i++)
        {
            screenDrug = new ScreenDrug(fwConn);//FDB
			screenDrug.load(drugList.get(i).toString(), FDBDrugType.fdbDTGCNSeqNo, ""); //FDB API 
			screenDrug.setProspective(true);//SETTING VALUE FDB API 
			DispensableGeneric dispGeneric = new DispensableGeneric(fwConn);// FDB API 
			dispGeneric.load(Long.parseLong(drugList.get(i).toString()), "", "");// FDB API 
            screenDrug.setDescription(dispGeneric.getDescription());//SETTING DRUG DESC IN FDB API 
			drug_det.put(drugList.get(i),dispGeneric.getDescription());

            screenDrugs.addItem(screenDrug);//ADDING DRUGS TO FDB API FOR SCREEING DRUGS
        }

        setDuplicateDrugTherapyResult(prod_id);
    }

    public void setDuplicateDrugTherapyResult(String prod_id)
        throws FDBException, Exception
    {
		

		sbDuplicateDescription = new StringBuffer();
        Screening screening = new Screening(fwConn);
        DTScreenDrugItems drugItems = null;
        DTScreenResults dtScreenResults = screening.DTScreen(screenDrugs, prospectiveOnly,  useDuplicateAllowance);//CALLING FDB API FOR SCREENING DRUGS
		Messages messages = dtScreenResults.getMessages(); //GETTING PRE-DEFINED MESSAGES FROM FDB IF DRUGS ARE DUPLICATED
		
       if(messages!=null && messages.count() > 0)
        {
		      sbDuplicateDescription.append("THERAPEUTIC DUPLICATION WARNING <br>=================================== </br><br>");
				int msgCount = messages.count();
				for (int i = 0; i < msgCount; i++)
				{
					sbDuplicateDescription.append("--> ").append(messages.item(i).getMessageText()).append("</br>");
				}
				sbDuplicateDescription.append("<br></br>");
				duplicate_found=true;
				
        }else{//CODE TO CHECK WHETHER DRUGS ARE DUPLICATED OR NOT IF FDB IS NOT RETURNING FDB PRE DEFINED MESSAGES ARE NOT WRITTEN
			int resultCount = dtScreenResults.count();
					 drugMap = new HashMap();
					 String pres_drug_desc =(String)drug_det.get(prod_id);

					for (int i = 0; i < resultCount; i++)
					{
						DTScreenResult scrngResult = dtScreenResults.item(i);
						String className = scrngResult.getClassDescription();
						DTScreenDrugItems objDTScreenDrugItems = scrngResult.getDrugItems();
						for (int d=0; d<objDTScreenDrugItems.count(); d++)
						{
							DTScreenDrugItem objDTScreenDrugItem = objDTScreenDrugItems.item(d);
							String drugName = objDTScreenDrugItem.getDrugDescription();							
                               
							//if (pres_drug_desc.equalsIgnoreCase(drugName)) continue;

							String drugClasses = (String)drugMap.get(drugName);
							if (drugClasses!=null)
							{
								drugClasses = drugClasses + ", " + className;
							}
							else
							{
								drugClasses = className;
							}
							drugMap.put(drugName,drugClasses);

							duplicate_found = true;
						}
					}
                   if (duplicate_found == true)
					{
						

						sbDuplicateDescription.append("<b>The Drug is found to be members of the same class with the following drug(s) and may represent Duplicate Theraphy</b> <br> ============================================================================ <br>");

						Iterator keyIter = drugMap.keySet().iterator();
						while(keyIter.hasNext())
						{
							String drugName = (String)keyIter.next();

							String drugClasses = (String)drugMap.get(drugName);
							if (!pres_drug_desc.equalsIgnoreCase(drugName)){
							     sbDuplicateDescription.append("--> ").append(drugName).append(" (").append(drugClasses).append(") <br>");
							}
						}	
						
					  sbDuplicateDescription.append("<br></br>");	
					}
		}
    }
//THIS METHOD WILL RETURN TRUE IF DRUGS ARE DUPLICATED
    public boolean getDuplicateDrugTherapyYN()
    {
        return duplicate_found;
    }

	public String getDuplicateDrugTherapyResult()
    {
        return sbDuplicateDescription.toString();
    }

	public HashMap getDrugDeatils()
    {
        return drug_det;
    } 

	public HashMap getDuplicateDrugDeatils()
    {
        return drugMap;
    } 

    private FDBDataManager fwConn;
    private long drugid;
    private boolean prospectiveOnly;
    private boolean useDuplicateAllowance;
    private FDBDrugType drugType;
    private ScreenDrugs screenDrugs;
    private ScreenDrug screenDrug;
	private boolean duplicate_found;
	StringBuffer sbDuplicateDescription = new StringBuffer();
	HashMap drug_det= new HashMap();
	HashMap drugMap = new HashMap();
}
