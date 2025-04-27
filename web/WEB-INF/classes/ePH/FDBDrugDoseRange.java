/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//import firstdatabank.fdbffc.*;
package ePH;
import firstdatabank.idif.*;
import firstdatabank.database.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.PrintStream;

// Referenced classes of package com.medicom.dif:
// FrameworkConnectionManager

public class FDBDrugDoseRange{

    public FDBDrugDoseRange(FDBDataManager fwConn)throws IOException
    {
        this.fwConn = fwConn;
        screening = new Screening(fwConn);
    }

    public void setDrugType(int drugType){
		switch(drugType){
			case 1:
				this.drugType = FDBDrugType.fdbDTRoutedDrug;
				break;
			case 2:
	            this.drugType = FDBDrugType.fdbDTDispensableDrug;
				break;
			case 3:
	            this.drugType = FDBDrugType.fdbDTPackagedDrug;
				break;
			case 4:
	            this.drugType = FDBDrugType.fdbDTGCNSeqNo;
				break;
			case 5:
	            this.drugType = FDBDrugType.fdbDTRtGen;
				break;
			case 6:
				this.drugType = FDBDrugType.fdbDTCompound;
				break;
			case 7:
	            this.drugType = FDBDrugType.fdbDTCustom;
				break;
			case 8:
	            this.drugType = FDBDrugType.fdbDTManufacturedDrug;
				break;
			case 9:
	            this.drugType = FDBDrugType.fdbDTReferenceOnly;
				break;
			case 10:
	            this.drugType = FDBDrugType.fdbDTRoutedDoseFormMedID;
				break;
			case 11:
	            this.drugType = FDBDrugType.fdbDTRoutedDoseFormGeneric;
				break;
			case 12:
	            this.drugType = FDBDrugType.fdbDTRegionalPackagedDrug;
				break;
			default:
	            throw new IllegalArgumentException();
		 }
    }

    public void setSeverityFilter(int filterType){
		switch(filterType){
			case 1:
	            severityFilter = FDBDDIMSeverityFilter.fdbDDIMSFContraindicated;
				break;
			case 2:
	            severityFilter = FDBDDIMSeverityFilter.fdbDDIMSFSevere;
				break;
			case 3:
	            severityFilter = FDBDDIMSeverityFilter.fdbDDIMSFModerate;
				break;
			case 4:
	            severityFilter = FDBDDIMSeverityFilter.fdbDDIMSFUnknownContraindicated;
				break;
			case 5:
	            severityFilter = FDBDDIMSeverityFilter.fdbDDIMSFUnknownSevere;
				break;
			case 6:
	            severityFilter = FDBDDIMSeverityFilter.fdbDDIMSFUnknownModerate;
				break;
			default:
	            throw new IllegalArgumentException();
		}
    }

    public void setProspectiveOnly(boolean prospectiveOnly){
        prospectiveOnly = prospectiveOnly;
    }

    public void setUseCustomInteractions(boolean useCustomInteraction){
        useCustomInteractions = useCustomInteraction;
    }

    public HashMap checkForDrugDoseRange(String sDrugCode,  long age_in_days, double weightKG, double BSAInM2, String dosage, String doseUnit, String frequency, String duration) throws Exception {

//		ArrayList drugList = new ArrayList();  Removed for IN063877
		String doseRate = "day";
		String durationRate = "day";
		String doseType = "02"; //Maintenance Dose
		int iFreq = Integer.parseInt((frequency == null || frequency.equals("")) ?"1":frequency);
		long lDuration = Long.parseLong((duration == null || duration.equals("")) ?"0":duration);
		double dDosage = Double.parseDouble((dosage == null || dosage.equals("")) ?"0":dosage);
		DosageCheckMessages = new HashMap();
		try{
			ScreenDrugs scrDrgList = new ScreenDrugs();
			ScreenDrug scrDrg = new ScreenDrug(fwConn);
			scrDrg.load(sDrugCode, FDBDrugType.fdbDTGCNSeqNo, "");
			scrDrg.setProspective(true);
			scrDrgList.addItem(scrDrg);
			scrDrg.setDoseType(doseType);
			scrDrg.setDoseInfo(dDosage, doseUnit, doseRate, iFreq + "", lDuration, durationRate);

			DOSEScreenResults screenResultsDosege = new DOSEScreenResults();
			screenResultsDosege =(DOSEScreenResults) screening.DOSEScreen (scrDrgList, true, age_in_days, weightKG, BSAInM2, FDBDOSESource.fdbDSDRCAndMinMax, "") ;

			for (int i = 0; i < screenResultsDosege.count(); i++){

				DOSEScreenResult screenResultDRC =screenResultsDosege.item(i);
				String singledosemsg = screenResultDRC.getSingleDoseMessage();
				String dailydosemsg = screenResultDRC.getDailyDoseMessage();
				String maxdailydosemsg = screenResultDRC.getMaxDailyDoseMessage();
				String freqmsg = screenResultDRC.getFrequencyMessage();
				String rangedosemsg = screenResultDRC.getRangeDoseMessage();
				String durnmsg = screenResultDRC.getDurationMessage();

				if(singledosemsg != null)
					DosageCheckMessages.put("SINGLEDOSAGE", singledosemsg);
				if(dailydosemsg != null)
					DosageCheckMessages.put("DAILYDOSAGE", dailydosemsg);
				if(maxdailydosemsg != null)
					DosageCheckMessages.put("MAXDAILYDOSAGE", maxdailydosemsg);
				if(freqmsg != null)
					DosageCheckMessages.put("FREQUENCYDOSAGE", freqmsg);
				if(rangedosemsg != null)
					DosageCheckMessages.put("RANGEDOSAGE", rangedosemsg);
				if(durnmsg != null)
					DosageCheckMessages.put("DURATIONDOSAGE", durnmsg);

				break;
			}
		}catch(Exception e){
			System.err.println("@@FDBDrugDosageRange dDosage= "+dDosage+"  doseUnit= "+doseUnit+" doseRate= "+doseRate+" iFreq= "+iFreq+" lDuration= "+lDuration+" durationRate="+durationRate);
			e.printStackTrace();
		}

		return DosageCheckMessages;
    }

//	private ScreenDrug drug;  Removed for IN063877
    private FDBDrugType drugType;
    private FDBDDIMSeverityFilter severityFilter;
//    private boolean prospectiveOnly;    Removed for IN063877
    private boolean useCustomInteractions;
    private Screening screening;
	private FDBDataManager fwConn;
    private HashMap DosageCheckMessages;
}
