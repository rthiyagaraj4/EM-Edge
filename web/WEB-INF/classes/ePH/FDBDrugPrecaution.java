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
import java.util.ArrayList;
import java.util.HashMap;

public class FDBDrugPrecaution
{
    public FDBDrugPrecaution(FDBDataManager fwConn)throws IOException
    {
        this.fwConn = fwConn;
    }

	public void setGERISeverityFilter(int gerifiltertype)
    {
        if(gerifiltertype == 1)
            geriseverityfilter = FDBGERISeverityFilter.fdbGERISFContraindicated;
        else
        if(gerifiltertype == 2)
            geriseverityfilter = FDBGERISeverityFilter.fdbGERISFAll;        
        else
            throw new IllegalArgumentException();
    }

	public void setLACTSeverityFilter(int lactfiltertype)
    {
        if(lactfiltertype == 1)
            lactseverityfilter = FDBLACTSeverityFilter.fdbLACTSFContraindicated;
        else
        if(lactfiltertype == 2)
            lactseverityfilter = FDBLACTSeverityFilter.fdbLACTSFWarning;  
		else
        if(lactfiltertype == 3)
            lactseverityfilter = FDBLACTSeverityFilter.fdbLACTSFAll;  
        else
            throw new IllegalArgumentException();
    }

	public void setPEDISeverityFilter(int pedifiltertype)
    {
        if(pedifiltertype == 1)
            pediseverityfilter = FDBPEDISeverityFilter.fdbPEDISFContraindicated;
        else
        if(pedifiltertype == 2)
            pediseverityfilter = FDBPEDISeverityFilter.fdbPEDISFExtremeCaution;  
		else
        if(pedifiltertype == 3)
            pediseverityfilter = FDBPEDISeverityFilter.fdbPEDISFAll;  
        else
            throw new IllegalArgumentException();
    }

	public void setPREGSignificanceFilter(int pregseverityfiltertype)
    {
        if(pregseverityfiltertype == 1)
            pregsignificancefilter = FDBPREGSignificanceFilter.fdbPREGSFContraindicated;
        else
        if(pregseverityfiltertype == 2)
            pregsignificancefilter = FDBPREGSignificanceFilter.fdbPREGSFExtremeCaution;  
		else
        if(pregseverityfiltertype == 3)
            pregsignificancefilter = FDBPREGSignificanceFilter.fdbPREGSFWarning;  
		else
        if(pregseverityfiltertype == 4)
            pregsignificancefilter = FDBPREGSignificanceFilter.fdbPREGSFConcern;  
		else
        if(pregseverityfiltertype == 5)
            pregsignificancefilter = FDBPREGSignificanceFilter.fdbPREGSFAll;  
        else
            throw new IllegalArgumentException();
    }

	public void setDrugType(int type)
    {
        if(type == 1)
            this.drugType = FDBDrugType.fdbDTRoutedDrug;
        else
        if(type == 2)
            this.drugType = FDBDrugType.fdbDTDispensableDrug;
        else
        if(type == 3)
            this.drugType = FDBDrugType.fdbDTPackagedDrug;
        else
        if(type == 4)
            this.drugType = FDBDrugType.fdbDTGCNSeqNo;
        else
        if(type == 5)
            this.drugType = FDBDrugType.fdbDTRtGen;
        else
        if(type == 6)
            this.drugType = FDBDrugType.fdbDTCompound;
        else
        if(type == 7)
            this.drugType = FDBDrugType.fdbDTCustom;
        else
		if(type == 8)
            this.drugType = FDBDrugType.fdbDTManufacturedDrug;
        else
        if(type == 9)
            this.drugType = FDBDrugType.fdbDTReferenceOnly;
        else
        if(type == 10)
            this.drugType = FDBDrugType.fdbDTRoutedDoseFormMedID;
        else
        if(type == 11)
            this.drugType = FDBDrugType.fdbDTRoutedDoseFormGeneric;
        else
        if(type == 12)
            this.drugType = FDBDrugType.fdbDTRegionalPackagedDrug;

        else
            throw new IllegalArgumentException();
    }

    public void setSignificanceFilter(int filterType)
    {
        if(filterType == 1)
            significanceFilter = FDBDFIMSignificanceFilter.fdbDFIMSFMost;
        else
        if(filterType == 2)
            significanceFilter = FDBDFIMSignificanceFilter.fdbDFIMSFMore;
        else
        if(filterType == 3)
            significanceFilter = FDBDFIMSignificanceFilter.fdbDFIMSFSignificant;
        else
        if(filterType == 4)
            significanceFilter = FDBDFIMSignificanceFilter.fdbDFIMSFLess;
        else
        if(filterType == 5)
            significanceFilter = FDBDFIMSignificanceFilter.fdbDFIMSFMinor;
        else
            throw new IllegalArgumentException();
    }

	public void setProspectiveOnlyAttribute(boolean prospectiveOnlyAttrib)
    {
        prospectiveOnlyAttribute = prospectiveOnlyAttrib;
    }

    public HashMap getAllInfos(ArrayList drugIDList)throws FDBException{
		drugInfos = new HashMap();
		drugList = drugIDList;
		String drugID="";
		getDrugClassificationInformation();//Drug Classification
		getDrugInteractionInformation();//Drug -Interactions
		setDrugPrecautionResult();//drug precautons
		getDrugCommonOrders();//drug_common-orders
		setDrugContraIndicationResult();//Drug Contra indications
		getDrugSideEffectsInformation();//Side-eefects
		getDrugOverDoseInformation();//DRug Over dose Information
		getPatientEductionInformation();//patient-education

		screening   = new Screening(fwConn);
		screenDrugs = new ScreenDrugs();
		drugFoodInteractionResult = new HashMap();
		GetDrugFoodInteractionDetails();//Drug Food Interaction
		HashMap tempDetails;
		for(int i=0;i<drugIDList.size();i++){
			tempDetails = new HashMap();
			drugID = drugIDList.get(i).toString();
			tempDetails.put("DRUG_CLASSFI",(HashMap)getDrugInfo().get(drugID));
			tempDetails.put("INTE",(HashMap)getDrugInteractions().get(drugID));
			tempDetails.put("PREC",(HashMap)getDrugPrecautionResult().get(drugID));
			tempDetails.put("COMMON_ORD",(ArrayList)getCommonOrders().get(drugID));
			tempDetails.put("DRUG_FOOD",(HashMap)getDrugFoodInteractionResult().get(drugID));
			tempDetails.put("CONT",(HashMap)getDrugContraIndications().get(drugID));
			tempDetails.put("SIDE",(HashMap)getDrugSideEffects().get(drugID));
			tempDetails.put("OVER",(String)getDrugOverDose().get(drugID));
			tempDetails.put("PAT_EDU",(String)getPatientEducationInfo().get(drugID));
			drugInfos.put(drugID,tempDetails);
		}
		return drugInfos;
	}

/*
    public void setDrugList(ArrayList drugIDList,String type)
        throws FDBException
    {
      drugList = new ArrayList(drugIDList);
		if(type.equals("PREC")){
			 setDrugPrecautionResult();//drug precautons
		}else if(type.equals("CONT")){
             setDrugContraIndicationResult();//Drug Contra indications
		}else if(type.equals("INTE")){
		     getDrugInteractionInformation();//Drug -Interactions
		}else if(type.equals("SIDE")){
		     getDrugSideEffectsInformation();//Side-eefects
		}else if(type.equals("OVER")){
		     getDrugOverDoseInformation();//DRug Over dose Information
		}else if(type.equals("PAT_EDU")){
		     getPatientEductionInformation();//patient-education
		}else if(type.equals("COMMON_ORD")){
		     getDrugCommonOrders();//drug_common-orders
		}else if(type.equals("DRUG_CLASSFI")){
		     getDrugClassificationInformation();//Drug Classification
		}else if(type.equals("DRUG_FOOD")){
		     screening   = new Screening(fwConn);
			 screenDrugs = new ScreenDrugs();
			 drugFoodInteractionResult = new HashMap();
			 GetDrugFoodInteractionDetails();//Drug Classification
		}		
    }*/
	private static String getGERISeverityDescription(String code,FDBDataManager fwConn)
	{
		String result = null;
		if (GERISeverityMap==null)
		{
			GERISeverityMap = loadFDBCodes(88, fwConn);
		}
		result = (String)GERISeverityMap.get(code);
		return result;
	}
	private static String getPREGSignificanceDescription(String signiCode, FDBDataManager fdbDatMan)
	{
		String result = null;
		if (PREGSignificanceMap==null)
		{
			PREGSignificanceMap = loadFDBCodes(93, fdbDatMan);
		}
		result = (String)PREGSignificanceMap.get(signiCode);
		return result;
	}
	private static String getPEDISeverityDescription(String code, FDBDataManager fdbDatMan)
	{
		String result = null;
		if (PEDISeverityMap==null)
		{
			PEDISeverityMap = loadFDBCodes(92, fdbDatMan);
		}
		result = (String)PEDISeverityMap.get(code);
		return result;
	}

	private static String getLACTSeverityDescription(String code, FDBDataManager fdbDatMan)
	{
		String result = null;
		if (LACTSeverityMap==null)
		{
			LACTSeverityMap = loadFDBCodes(89, fdbDatMan);
		}
		result = (String)LACTSeverityMap.get(code);
		return result;
	}

	private static String getLACTExcretionEffectDescription(String code, FDBDataManager fdbDatMan)
	{
		String result = null;
		if (LACTExcretionEffectMap==null)
		{
			LACTExcretionEffectMap = loadFDBCodes(90, fdbDatMan);
		}
		result = (String)LACTExcretionEffectMap.get(code);
		return result;
	}

	private static String getLACTLactationEffectDescription(String code, FDBDataManager fdbDatMan)
	{
		String result = null;
		if (LACTLactationEffectMap==null)
		{
			LACTLactationEffectMap = loadFDBCodes(91, fdbDatMan);
		}
		result = (String)LACTLactationEffectMap.get(code);
		return result;
	}
	private static String getDDIMSeverityDescription(String severityCode, FDBDataManager fdbDatMan)
	{
		String result = null;
		if (DDIMSeverityMap==null)
		{
			DDIMSeverityMap = loadFDBCodes(14, fdbDatMan);
		}
		result = (String)DDIMSeverityMap.get(severityCode);
		return result;
	}
	private static String getDDIMClinicalEffectDescription(String effectCode, FDBDataManager fdbDatMan)
	{
		String result = null;
		if (DDIMClinicalEffectMap==null)
		{
			DDIMClinicalEffectMap = loadFDBCodes(15, fdbDatMan);
		}
		result = (String)DDIMClinicalEffectMap.get(effectCode);
		return result;
	}


	private static HashMap loadFDBCodes(int fdbCodeType, FDBDataManager fwConn)
	{
		HashMap resultMap = new HashMap();
		Navigation naviObj = new Navigation(fwConn);
		try
		{
			FDBCodes objFDBCodes = naviObj.FDBCodesLoad(fdbCodeType);
			for (int i=0; i<objFDBCodes.count(); i++)
			{
				FDBCode objFDBCode = objFDBCodes.item(i);
				resultMap.put(objFDBCode.getCodeValue(), objFDBCode.getDescription());
			}
		}
		catch (FDBSQLException ex)
		{
		}
		return resultMap;
	}
	//code for getting contra indications

	private static String getDDCMSeverityDescription(String severityCode, FDBDataManager fdbDatMan)
	{
		String result = null;
		if (DDCMSeverityMap==null)
		{
			DDCMSeverityMap = loadFDBCodes(85, fdbDatMan);
		}
		result = (String)DDCMSeverityMap.get(severityCode);
		return result;
	}

	private static String getSIDESeverityDescription(String code, FDBDataManager fdbDatMan)
	{
		String result = null;
		if (SIDESeverityMap==null)
		{
			SIDESeverityMap = loadFDBCodes(95, fdbDatMan);
		}
		result = (String)SIDESeverityMap.get(code);
		return result;
	}

	private static String getSIDEVisibilityDescription(String code, FDBDataManager fdbDatMan)
	{
		String result = null;
		if (SIDEVisibilityMap==null)
		{
			SIDEVisibilityMap = loadFDBCodes(96, fdbDatMan);
		}
		result = (String)SIDEVisibilityMap.get(code);
		return result;
	}

	private static String getSIDELabTestDescription(String code, FDBDataManager fdbDatMan)
	{
		String result = null;
		if (SIDELabTestMap==null)
		{
			SIDELabTestMap = loadFDBCodes(97, fdbDatMan);
		}
		result = (String)SIDELabTestMap.get(code);
		return result;
	}

	private static String getSIDEPhysDescription(String code, FDBDataManager fdbDatMan)
	{
		String result = null;
		if (SIDEPhysMap==null)
		{
			SIDEPhysMap = loadFDBCodes(98, fdbDatMan);
		}
		result = (String)SIDEPhysMap.get(code);
		return result;
	}
	private static String getSIDEFrequencyDescription(String code, FDBDataManager fdbDatMan)
	{
		String result = null;
		if (SIDEFrequencyMap==null)
		{
			SIDEFrequencyMap = loadFDBCodes(94, fdbDatMan);
		}
		result = (String)SIDEFrequencyMap.get(code);
		return result;
	}

	//this method is used for getting Precautions Information
    private void setDrugPrecautionResult()  throws FDBException
    {
        drugPrecautionResult				= new HashMap();
		HashMap data						= null;
		HashMap precautions					= null;
	//	ArrayList absolute_contraindication	= null; Removed for IN063877 
	//	ArrayList contra_extreme_caution	= null;   Removed for IN063877
	//	ArrayList contra_warnings			= null;  Removed for IN063877
		String severityLevelCode			= "";
		String severityLevelDesc			= "";
		String signiLevel					= "";
        String signiLevelDesc				= "";
		String excretionEffectCode			= "";
		String excretionEffectDesc			= "";
		String lactationEffectCode			= "";
		String lactationEffectDesc			= "";
		
		for(int m = 0; m < drugList.size(); m++)
        {
			precautions			= new HashMap();
			data				= new HashMap();             

			DispensableGeneric dispGeneric = new DispensableGeneric(fwConn);// FDB API 
			String drugID = new String(drugList.get(m).toString());
			dispGeneric.load(Long.parseLong(drugID), "", "");// FDB API 
//code for getting Geriatric precautions
            GERILookupResults lookupresultsGERI = dispGeneric.getPrecautionsGeriatric(geriseverityfilter);// FDB API 

            for(int i = 0; i < lookupresultsGERI.count(); i++)
            {
                GERILookupResult lookupresultGERI = lookupresultsGERI.item(i);	            
                data.put("comment_"+i, lookupresultGERI.getAddComment());
                severityLevelCode = lookupresultGERI.getSeverityLevelCode();
			    severityLevelDesc = "";
				if (severityLevelCode!=null && !severityLevelCode.equals(""))
				{
					severityLevelDesc = getGERISeverityDescription(severityLevelCode, fwConn);
					
				} 
				data.put("Severity_Level_Desc_"+i, severityLevelDesc);
            }
          precautions.put("GERI",data);

//code for getting Pregnancy precautions
         data      = new HashMap(); 

         PREGLookupResults lookupresultsPREG = dispGeneric.getPrecautionsPregnancy(pregsignificancefilter);// FDB API 

            for(int i = 0; i < lookupresultsPREG.count(); i++)
            {
                PREGLookupResult lookupresultPREG = lookupresultsPREG.item(i);	            
                data.put("comment_"+i, lookupresultPREG.getAddComment());
                signiLevel     = lookupresultPREG.getSignificanceLevelCode();
			    signiLevelDesc = "";
				if (signiLevel!=null && !signiLevel.equals(""))
				{
					signiLevelDesc = getPREGSignificanceDescription(signiLevel, fwConn);
				} 
				data.put("Significent_Level_Desc_"+i, signiLevelDesc);
            }
			precautions.put("PREG",data);
 //code for getting Pediatric precautions

         data             = new HashMap(); 
         PEDILookupResults lookupresultsPEDI = dispGeneric.getPrecautionsPediatric(pediseverityfilter);// FDB API 
            for(int i = 0; i < lookupresultsPEDI.count(); i++)
            {
                PEDILookupResult lookupresultPEDI = lookupresultsPEDI.item(i);	            
                data.put("comment_"+i, lookupresultPEDI.getAddComment());
                severityLevelCode = lookupresultPEDI.getSeverityLevelCode();
			    severityLevelDesc = "";
				if (severityLevelCode!=null && !severityLevelCode.equals(""))
				{
					severityLevelDesc = getPEDISeverityDescription(severityLevelCode, fwConn);
				}
				data.put("Severity_Level_Desc_"+i, severityLevelDesc);
			}
			precautions.put("PEDI",data);
			//code for getting Lactaction precautions
			data             = new HashMap(); 

			LACTLookupResults lookupresultsLACT = dispGeneric.getPrecautionsLactation(lactseverityfilter);// FDB API 

			for(int i = 0; i < lookupresultsLACT.count(); i++)
			{
				LACTLookupResult lookupresultLACT = lookupresultsLACT.item(i);	
				data.put("comment_"+i, lookupresultLACT.getAddComment());
			   
				severityLevelCode = lookupresultLACT.getSeverityLevelCode();
				severityLevelDesc = "";
				if (severityLevelCode!=null && !severityLevelCode.equals(""))
				{
					severityLevelDesc = getLACTSeverityDescription(severityLevelCode, fwConn);
				}
				data.put("Severity_Level_Desc_"+i, severityLevelDesc);

				excretionEffectCode = lookupresultLACT.getExcretionEffectCode();
				excretionEffectDesc = "";
				if (excretionEffectCode!=null && !excretionEffectCode.equals(""))
				{
					excretionEffectDesc = getLACTExcretionEffectDescription(excretionEffectCode, fwConn);
				}
				data.put("Excretion_Effect_Desc_"+i, excretionEffectDesc);

				lactationEffectCode = lookupresultLACT.getLactationEffectCode();
				lactationEffectDesc = "";
				if (lactationEffectCode!=null && !lactationEffectCode.equals(""))
				{
					lactationEffectDesc = getLACTLactationEffectDescription(lactationEffectCode, fwConn);
				}  
				data.put("Effect_desc_"+i, lactationEffectDesc);
			}
			precautions.put("LACT",data);
			drugPrecautionResult.put(drugID, precautions);
		}
	}
	
	//code for getting contra indications
	private void setDrugContraIndicationResult() throws FDBException{
        drugcontraindications               = new HashMap();
		HashMap  contra_indication          = new HashMap();
		ArrayList absolute_contraindication	= null; 
		ArrayList contra_extreme_caution	= null;  
		ArrayList contra_warnings			= null; 
		absolute_contraindication			= new ArrayList();
		contra_extreme_caution				= new ArrayList();
		contra_warnings						= new ArrayList();
		String condtion_desc  ="";
		String severityLevelDesc = "";
		for(int m = 0; m < drugList.size(); m++){

			DispensableGeneric dispGeneric		= new DispensableGeneric(fwConn);// FDB API 
			String drugID = new String(drugList.get(m).toString());
			dispGeneric.load(Long.parseLong(drugID), "", "");

		    DDCMLookupResults LookupResultsDDCM = dispGeneric.getDiseaseContraindications(FDBDDCMSeverityFilter.fdbDDCMSFWarning);// FDB API 
		    for (int i=0; i<LookupResultsDDCM.count(); i++)
			{
				DDCMLookupResult LookupResultDDCM = LookupResultsDDCM.item(i);
				if ("1".equals(LookupResultDDCM.getSeverityLevelCode()))      //'absolute contraindication
				{ condtion_desc  ="";
				  condtion_desc  =  LookupResultDDCM.getConditionDescription();
				  severityLevelDesc = "";
					
					if (LookupResultDDCM.getSeverityLevelCode()!=null)
					{
						severityLevelDesc = getDDCMSeverityDescription(LookupResultDDCM.getSeverityLevelCode(), fwConn);
					}
					absolute_contraindication.add(condtion_desc);
					absolute_contraindication.add(severityLevelDesc);
				} 
				if ("2".equals(LookupResultDDCM.getSeverityLevelCode()))      //extreme   caution 
				{
					condtion_desc  ="";
					condtion_desc  =  LookupResultDDCM.getConditionDescription(); 
					severityLevelDesc = "";
					if (LookupResultDDCM.getSeverityLevelCode()!=null)
					{
						severityLevelDesc = getDDCMSeverityDescription(LookupResultDDCM.getSeverityLevelCode(), fwConn);
					}
					contra_extreme_caution.add(condtion_desc);
					contra_extreme_caution.add(severityLevelDesc);
				} 

				if ("3".equals(LookupResultDDCM.getSeverityLevelCode()))      //warning
				{
					 condtion_desc  ="";
					 condtion_desc  =  LookupResultDDCM.getConditionDescription();
					 severityLevelDesc = "";
					if (LookupResultDDCM.getSeverityLevelCode()!=null)
					{
						severityLevelDesc = getDDCMSeverityDescription(LookupResultDDCM.getSeverityLevelCode(), fwConn);
					}
					contra_warnings.add(condtion_desc);
					contra_warnings.add(severityLevelDesc);
				}  
			}
			contra_indication.put("ABS",absolute_contraindication);
			contra_indication.put("EXT",contra_extreme_caution);
			contra_indication.put("WAR",contra_warnings);
			drugcontraindications.put(drugID,contra_indication);
		}
	}

	//this method is used for getting Drug Interaction Information
	private void  getDrugInteractionInformation()throws FDBException
	{
		druginteractiondetail               = new HashMap();
		try
		{
			for(int m = 0; m < drugList.size(); m++){
				DispensableGeneric dispGeneric		= new DispensableGeneric(fwConn);// FDB API 
				String drugID = new String(drugList.get(m).toString());
				dispGeneric.load(Long.parseLong(drugID), "", "");// FDB API 

				HashMap interactiondetail               = new HashMap();
				DDIMLookupResults LookupResultsDDIM = dispGeneric.getDDIMInteractions(FDBDDIMSeverityFilter.fdbDDIMSFUnknownModerate, true, true);
				if (LookupResultsDDIM.count() > 0)
				{
					for (int i=0; i<LookupResultsDDIM.count(); i++)
					{
						DDIMLookupResult LookupResultDDIM = LookupResultsDDIM.item(i);
						String interDesc = LookupResultDDIM.getInteractionDescription();
						String interSevLevel = LookupResultDDIM.getSeverityLevelCode();						

						interactiondetail.put("INT_DESC",interDesc);//interaction description
						interactiondetail.put("SEV_DESC",getDDIMSeverityDescription(interSevLevel,fwConn));//severity level description
						String cecDesc1 = "";
						if (LookupResultDDIM.getClinicalEffectCode1()!=null)
						{
							cecDesc1 = getDDIMClinicalEffectDescription(LookupResultDDIM.getClinicalEffectCode1(), fwConn);
						}
						String cecDesc2 = "";
						if (LookupResultDDIM.getClinicalEffectCode2()!=null)
						{
							cecDesc2 = getDDIMClinicalEffectDescription(LookupResultDDIM.getClinicalEffectCode2(), fwConn);
							if(cecDesc2==null) 
								cecDesc2="";
							if (!cecDesc1.equals("")) 
								cecDesc1 = cecDesc1 + "<br>";
						}
                        interactiondetail.put("CLIN_EFFECT",cecDesc1+cecDesc2);//severity level description  

						if (LookupResultDDIM.getUserCategory()!=null)
						{							
							interactiondetail.put("USER_CAT",LookupResultDDIM.getUserCategory());//user category 
						}
                              
						if (!LookupResultDDIM.getDocAnimalStudy() || LookupResultDDIM.getDocCaseReport() || LookupResultDDIM.getDocHumanTrial()
							|| LookupResultDDIM.getDocManufacturer() || LookupResultDDIM.getDocMeetingAbstract() || LookupResultDDIM.getDocReviewArticle())
						{
							ArrayList supp_doc=new ArrayList();
							
							if (LookupResultDDIM.getDocAnimalStudy())
							{
								supp_doc.add("Animal Study");
							}
							else if (LookupResultDDIM.getDocCaseReport())
							{
								supp_doc.add("Case Report");
							}
							else if (LookupResultDDIM.getDocHumanTrial())
							{
								supp_doc.add("Human Trials");
							}
							else if (LookupResultDDIM.getDocManufacturer())
							{
								supp_doc.add("Manufacturer Information");
							}
							else if (LookupResultDDIM.getDocMeetingAbstract())
							{
								supp_doc.add("Meeting Abstract");
							}
							else if (LookupResultDDIM.getDocReviewArticle())
							{
								supp_doc.add("Review Articles");
							}
							interactiondetail.put("SUPP_DOC",supp_doc);//support documentation
						}

						DDIMLookupDrugs LookupDrugsDDIM = LookupResultDDIM.getDrugs();

						if (LookupDrugsDDIM.count()>0)
						{
							ArrayList drugs=new ArrayList();
							String str="The following routed drugs interact with "+ dispGeneric.getDescription()+" within the context of this Interaction  ";
                            drugs.add(str);
							for (int j=0; j<LookupDrugsDDIM.count(); j++)
							{
								drugs.add(LookupDrugsDDIM.item(j).getDescription());
							}
                             interactiondetail.put("DRUGS",drugs);//list of drugs which interacts with selected drug
						}
					}
					druginteractiondetail.put(drugID,interactiondetail);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
     
	//this method is used for getting Side Effects Information
	public void getDrugSideEffectsInformation()throws FDBException
	{
		side_effects                = new HashMap();
		try
		{
            for(int m = 0; m < drugList.size(); m++){
				DispensableGeneric dispGeneric		= new DispensableGeneric(fwConn);// FDB API 
				String drugID = new String(drugList.get(m).toString());
				dispGeneric.load(Long.parseLong(drugID), "", "");// FDB API 

				SIDELookupResults LookupResultsSIDE = dispGeneric.getSideEffects(FDBSIDESeverityFilter.fdbSIDESFAll, FDBSIDEFreqFilter.fdbSIDEFFAll);
				if (LookupResultsSIDE!=null && LookupResultsSIDE.count()>0)
				{
					 HashMap data				= new HashMap();
					 ArrayList severe_data		= new ArrayList();	
		             ArrayList less_severe_data	= new ArrayList();	

					for (int i=0; i<LookupResultsSIDE.count(); i++)
					{
						SIDELookupResult LookupResultSIDE = LookupResultsSIDE.item(i);
                        String cond_desc = LookupResultSIDE.getConditionDescription();
					    String severityLevelCode = LookupResultSIDE.getSeverityLevelCode();
						String severityLevelDesc = "";
						if (severityLevelCode!=null && !severityLevelCode.equals(""))
						{
							severityLevelDesc = getSIDESeverityDescription(severityLevelCode, fwConn);
						}
						String frequencyCode = LookupResultSIDE.getFrequencyCode();
						String frequencyDesc = "";
						if (frequencyCode!=null && !frequencyCode.equals(""))
						{
							frequencyDesc = getSIDEFrequencyDescription(frequencyCode, fwConn);
						}			

						String labTestCode = LookupResultSIDE.getLabTestCode();
						String labTestDesc = "";
						if (labTestCode!=null && !labTestCode.equals(""))
						{
							labTestDesc = getSIDELabTestDescription(labTestCode, fwConn);
						}			

						String visibilityCode = LookupResultSIDE.getVisibilityCode();
						String visibilityDesc = "";
						if (visibilityCode!=null && !visibilityCode.equals(""))
						{
							visibilityDesc = getSIDEVisibilityDescription(visibilityCode, fwConn);
						}		

						String hyperSensitityDesc = "No";
						if (LookupResultSIDE.getHypersensitivity())
						{
							hyperSensitityDesc = "Yes";
						}									

						String physCode = LookupResultSIDE.getContactPhysicianCode();
						String physDesc = "";
						if (physCode!=null && !physCode.equals(""))
						{
							physDesc = getSIDEPhysDescription(physCode, fwConn);
						}

						if ("1".equals(LookupResultSIDE.getSeverityLevelCode()))
						{
                           severe_data.add(cond_desc);
						   severe_data.add(severityLevelDesc);
						   severe_data.add(frequencyDesc);
						   severe_data.add(labTestDesc);
						   severe_data.add(visibilityDesc);
						   severe_data.add(hyperSensitityDesc);
						   severe_data.add(physDesc);

						}
						else if ("0".equals(LookupResultSIDE.getSeverityLevelCode()))
						{
						   less_severe_data.add(cond_desc);
						   less_severe_data.add(severityLevelDesc);
						   less_severe_data.add(frequencyDesc);
						   less_severe_data.add(labTestDesc);
						   less_severe_data.add(visibilityDesc);
						   less_severe_data.add(hyperSensitityDesc);
						   less_severe_data.add(physDesc);
						}
					}
                     data.put("SEVE",severe_data);
				     data.put("LESS_SEVE",less_severe_data);
					 side_effects.put(drugID,data);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}		
	}

	//this method is used for getting Over Dose Information
	public void getDrugOverDoseInformation()throws FDBException
	{
		OverDose_msg=new HashMap();
		try
		{
			 for(int m = 0; m < drugList.size(); m++){
				DispensableGeneric dispGeneric		= new DispensableGeneric(fwConn);// FDB API 
				String drugID = new String(drugList.get(m).toString());
				dispGeneric.load(Long.parseLong(drugID), "", "");// FDB API

				Monograph monoObj = dispGeneric.getPEMMonograph("", FDBMonographSource.fdbMSFDBOnly, 0);
				if (monoObj!=null)
				{
					MonographSection objSection = monoObj.getSections().getItemBySectionID("O");
					StringBuffer tempBuffer = new StringBuffer();
					if (objSection!=null)
					{
						for (int i=0; i<objSection.getLines().count(); i++)
						{
							if (i==0)
							{
								String lineText = objSection.getLines().item(i).getLineText();
								int colonIndex = lineText.indexOf(":");
								tempBuffer.append(lineText.substring(colonIndex+3));
							}
							else
							{
								if ("1".equalsIgnoreCase(objSection.getLines().item(i).getFormatCode()))
								{
									tempBuffer.append("<br>").append(objSection.getLines().item(i).getLineText());
								}
								else if ("2".equalsIgnoreCase(objSection.getLines().item(i).getFormatCode()))
								{
									tempBuffer.append("<br>").append(objSection.getLines().item(i).getLineText());
								}
								else
								{
									tempBuffer.append(" ").append(objSection.getLines().item(i).getLineText());
								}
							}
						}						
					}
                    String msg = tempBuffer.toString();
					OverDose_msg.put(drugID,msg);
			  }
		   }
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
		
	}

	//this method is used for getting Patient Education Information
	public void getPatientEductionInformation()throws FDBException
	{
		pat_edu_info =new HashMap();
		try
		{
			for(int m = 0; m < drugList.size(); m++){
				String result = "";	
				DispensableGeneric dispGeneric		= new DispensableGeneric(fwConn);// FDB API 
				String drugID = new String(drugList.get(m).toString());
				dispGeneric.load(Long.parseLong(drugID), "", "");

				Monograph monoObj = dispGeneric.getPEMMonograph("", FDBMonographSource.fdbMSFDBOnly, 0);// FDB API 
//				String str =dispGeneric.getImageFileName() ;
				if (monoObj != null)
				{
					result = monoObj.getFormattedText(FDBMonographFormat.fdbMFHTML);
					pat_edu_info.put(drugID,result);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

	//this method is used for getting Common orders Information
	public void getDrugCommonOrders()throws FDBException
	{
		common_orders	      = new HashMap();
		ArrayList child_data  =	null;
		ArrayList elder_data  =	null;
		ArrayList adult_data  =	null;
		HashMap tmp_data      =	null;	
		ArrayList tmp_data1   = new ArrayList();
		StringBuffer currentBuffer = null;
	
		try
		{
		  for(int m = 0; m < drugList.size(); m++){
			//	String result = ""; Removed for IN063877	
				DispensableGeneric dispGenObj		= new DispensableGeneric(fwConn);// FDB API 
				String drugID = new String(drugList.get(m).toString());
				dispGenObj.load(Long.parseLong(drugID), "", "");// FDB API
			    DispensableGeneric[] dispGenObjArray = new 	DispensableGeneric[]{dispGenObj};
							 
			    for (int drugIndex=0; drugIndex<dispGenObjArray.length; drugIndex++)
				{
					child_data  =new ArrayList();
					elder_data  =new ArrayList();
					adult_data  =new ArrayList();
					dispGenObj = dispGenObjArray[drugIndex];
					POEMLookupResults objPOEMLookupResults = dispGenObj.getCommonOrders("","","",0);

					if (objPOEMLookupResults.count()>0)
					{		
						tmp_data1  = new ArrayList();
						for (int resIndex=0; resIndex<objPOEMLookupResults.count(); resIndex++)
						{
							POEMLookupResult objPOEMLookupResult = objPOEMLookupResults.item(resIndex);
							long ageLow = objPOEMLookupResult.getAgeInDaysLow()/365;
							long ageHigh = objPOEMLookupResult.getAgeInDaysHigh()/365;
							
							String Indication_desc =objPOEMLookupResult.getIndicationDescription();	
							
							POEMOrderStrings objPOEMOrderStrings = objPOEMLookupResult.getOrderStrings();

							ArrayList data=new ArrayList();
							for (int ordStrIndex=0; ordStrIndex<objPOEMOrderStrings.count(); ordStrIndex++)
							{
								POEMOrderString objPOEMOrderString = objPOEMOrderStrings.item(ordStrIndex);
								String Dose_type= objPOEMOrderString.getDoseTypeDescription();
								String dose_route_desc= objPOEMOrderString.getDoseRouteDescription();
								String full_order_string =objPOEMOrderString.getFullOrderText();

								POEMAdminRates objPOEMAdminRates = objPOEMOrderString.getAdminRates();
								currentBuffer = new StringBuffer();
								
								if (objPOEMAdminRates!=null && objPOEMAdminRates.count()>0)
								{
									currentBuffer.append("<BR><B>Admin Rates:</B><BR><TABLE border=1 align=center>");
									currentBuffer.append("<tr><td><B>Admin Rate Seq</B></td><td><B>Admin Rate</B></td><td><B>Admin Rate Unit Desc</B></td></tr>");
									for (int admIndex=0; admIndex<objPOEMAdminRates.count(); admIndex++)
									{
										POEMAdminRate objPOEMAdminRate = objPOEMAdminRates.item(admIndex);
										currentBuffer.append("<tr><td>").append(objPOEMAdminRate.getAdminRateSeq()).append("</td>");
										currentBuffer.append("<td>").append(objPOEMAdminRate.getAdminRate()).append("</td>");
										currentBuffer.append("<td>").append(objPOEMAdminRate.getAdminRateUnitDescription()).append("</td></tr>");
									}
									currentBuffer.append("</table>");
								}

								POEMInstructions objPOEMInstructions = objPOEMOrderString.getInstructions();
								if (objPOEMInstructions!=null && objPOEMInstructions.count()>0)
								{
									currentBuffer.append("<BR><B>Special Instructions:</B><BR>");
									for (int insIndex=0; insIndex<objPOEMInstructions.count(); insIndex++)
									{
										POEMInstruction objPOEMInstruction = objPOEMInstructions.item(insIndex);
										currentBuffer.append("- ").append(objPOEMInstruction.getInstructionText()).append("<BR>");
									}
								}	
								
								data.add(Dose_type);
								data.add(dose_route_desc);
								data.add(full_order_string);
								data.add(currentBuffer.toString());
							}

							 if (ageLow<=12 && ageHigh<=12)
							 {  
							   child_data.add(Indication_desc); 
							   child_data.add(data); 					   
							 }else  if (ageLow>=13 && ageLow<=65 && ageHigh>=13 && ageHigh<=65){
							   adult_data.add(Indication_desc) ;
							   adult_data.add(data) ;
							 }else if (ageLow>=66 && ageHigh>=66){
								 elder_data.add(Indication_desc) ;
								 elder_data.add(data) ;
							 }
						}
						tmp_data  = new HashMap();
						tmp_data.put("CHILD",child_data);
						tmp_data.put("ADULT",adult_data);
						tmp_data.put("ELDER",elder_data);
					}	
					
					tmp_data1.add(tmp_data);
				}
				common_orders.put(drugID,tmp_data1);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

	//this method is used for getting Drug-Classification Information
	public void getDrugClassificationInformation()
	{
		ArrayList  data  =null;
		ArrayList  data1 =null;
		HashMap    data2 =null;
		Drug_info		 =new HashMap();

		try
		{
			for(int m = 0; m < drugList.size(); m++){
			//	String result = ""; Removed for IN063877	
				DispensableGeneric dispGenObj		= new DispensableGeneric(fwConn);// FDB API 
				String drugID = new String(drugList.get(m).toString());
				dispGenObj.load(Long.parseLong(drugID), "", "");// FDB API
			  //  DispensableGeneric[] dispGenObjArray = new 	DispensableGeneric[]{dispGenObj}; Removed for IN063877

		//AHFS Classifications
				AHFSClassifications objAHFSClassifications = dispGenObj.getAHFSClassifications();
				data1 =new ArrayList();
				data2 =new HashMap();
				for (int i=0; i<objAHFSClassifications.count(); i++)
				{
					AHFSClassification objAHFSClassification = objAHFSClassifications.item(i);
					data =new ArrayList();
					data.add(objAHFSClassification.getDescription());
					while (objAHFSClassification.getParentID()!=null && !objAHFSClassification.getParentID().equals(""))
					{
						AHFSClassification parentAHFSClassification = objAHFSClassification.getParent();
						data.add(parentAHFSClassification.getDescription());					
						objAHFSClassification = parentAHFSClassification;
					}
				  data1.add(data);
				}
			data2.put("AHFS",data1);

		//FDB Classifications
				FDBClassifications objFDBClassifications = dispGenObj.getFDBClassifications();
				data1 =new ArrayList();
			
				for (int i=0; i<objFDBClassifications.count(); i++)
				{
					FDBClassification objFDBClassification = objFDBClassifications.item(i);
					data =new ArrayList();
					data.add(objFDBClassification.getDescription());	
					
					while (objFDBClassification.getParentID()!=0)
					{
						FDBClassification parentFDBClassification = objFDBClassification.getParent();
						data.add(parentFDBClassification.getDescription());
						objFDBClassification = parentFDBClassification;
					}
				  data1.add(data);
				}
				data2.put("FDB",data1);	
				Drug_info.put(drugID,data2);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}


	private void GetDrugFoodInteractionDetails() throws FDBException
    {
        try
		{ 
			for(int i = 0; i < drugList.size(); i++)
			{
				String drugID = new String(drugList.get(i).toString());            
				screenDrug    = new ScreenDrug(fwConn);//FDB
				screenDrug.load(drugList.get(i).toString(), FDBDrugType.fdbDTGCNSeqNo, ""); //FDB API 
				screenDrug.setProspective(true);//SETTING VALUE FDB API 
				DispensableGeneric dispGeneric = new DispensableGeneric(fwConn);// FDB API 
				dispGeneric.load(Long.parseLong(drugList.get(i).toString()), "", "");// FDB API 
				screenDrug.setDescription(dispGeneric.getDescription());//SETTING DRUG DESC IN FDB API 
				screenDrugs.addItem(screenDrug);//ADDING DRUGS TO FDB API FOR SCREEING DRUGS
				//setDrugFoodInteractionResult(screenDrugs, drugID);

				HashMap data = null;
				DFIMScreenResults screenResultsDFIM = new DFIMScreenResults();
				screenResultsDFIM		= screening.DFIMScreen(screenDrugs, prospectiveOnlyAttribute, significanceFilter, false);
				long screenResultCount  = screenResultsDFIM.count();
				if(screenResultCount > 0L)
				{
					data = new HashMap();
					for(int intInd = 0; intInd <= (int)screenResultCount - 1; intInd++)
					{
						DFIMScreenResult screenResultDFIM = screenResultsDFIM.item(intInd);
						String message = screenResultDFIM.getScreenMessage();
					   data.put(Integer.toString(intInd + 1), message);
					}
					drugFoodInteractionResult.put(drugID, data);
				}
			}
	    }catch (Exception e)
		{
			e.printStackTrace();
		}
    }


    public HashMap getDrugPrecautionResult()
    {
        return drugPrecautionResult;
    }
	 public HashMap getDrugContraIndications()
    {
        return drugcontraindications;
    }
	 public HashMap getDrugInteractions()
    {
        return druginteractiondetail;
    }
	 public HashMap getDrugSideEffects()
    {
        return side_effects;
    }
	public HashMap getDrugOverDose()
    {
        return OverDose_msg;
    }
	public HashMap getPatientEducationInfo()
    {
        return pat_edu_info;
    }
	public HashMap getCommonOrders()
    {
        return common_orders;
    }
	public HashMap getDrugInfo()
    {
        return Drug_info;
    }
	 public HashMap getDrugFoodInteractionResult()
    {
        return drugFoodInteractionResult;
    }

    private FDBDataManager fwConn;
    private FDBGERISeverityFilter geriseverityfilter;
	private FDBLACTSeverityFilter lactseverityfilter;
	private FDBPEDISeverityFilter pediseverityfilter;
	private FDBPREGSignificanceFilter pregsignificancefilter;
    private ArrayList drugList;
    private HashMap drugPrecautionResult;
	private HashMap drugcontraindications;
	private HashMap druginteractiondetail;
	private HashMap side_effects;
	private HashMap OverDose_msg ;
	private HashMap pat_edu_info;
	private HashMap common_orders;
	private HashMap Drug_info;
	private static HashMap GERISeverityMap			=null;
	private static HashMap PREGSignificanceMap		=null;
	private static HashMap PEDISeverityMap			=null;
	private static HashMap LACTSeverityMap			=null;
	private static HashMap LACTExcretionEffectMap	=null;
	private static HashMap LACTLactationEffectMap	=null;
	private static HashMap DDCMSeverityMap          =null;
	private static HashMap DDIMSeverityMap          =null;
	private static HashMap DDIMClinicalEffectMap    =null;
	private static HashMap SIDESeverityMap			=null;
	private static HashMap SIDEVisibilityMap		=null;
	private static HashMap SIDELabTestMap			=null;
	private static HashMap SIDEPhysMap				=null;
	private static HashMap SIDEFrequencyMap			=null;	
    private FDBDFIMSignificanceFilter significanceFilter; 
	private FDBDrugType drugType;
    private boolean prospectiveOnlyAttribute;
    private HashMap drugFoodInteractionResult;
    private HashMap drugInfos;
	private ScreenDrug screenDrug;
	private ScreenDrugs screenDrugs;
    private Screening screening;
}
