/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * 
 */
package eIPAD.chartsummary.results.request;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author SaraswathiR 
 *
 */
public class ResultsCatConstants {

	public static final String RESULTCATEGORY_LABORATORY = "LBIN";
	public static final String RESULTCATEGORY_RADIOLOGYIMAGING = "RDIN";
	public static final String RESULTCATEGORY_SURGERYPROCEDURE = "SUNT";
	public static final String RESULTCATEGORY_DEPTDIAGNOSTICS = "RXIN";
	public static final String RESULTCATEGORY_CLINICALNOTE = "CLNT";
	public static final String RESULTCATEGORY_FUTUREEVENTS = "FEVT";
	public static final String RESULTCATEGORY_PATIENTCARE = "PTCR";
	public static final String RESULTCATEGORY_PROBLEMDIAGNOSIS = "DIAG";
	public static final String RESULTCATEGORY_DISCHARGESUMMARY = "DSSM";
	public static final String RESULTCATEGORY_TREATMENT = "TRET";
	public static final String RESULTCATEGORY_BLOODTRANSFUSION = "BLTF";
	public static final String RESULTCATEGORY_FREEDOCUMENTATION = "FDOC";
	public static final String RESULTCATEGORY_MIGCLINICALINFO = "MGCL";
	public static final String RESULTCATEGORY_DIETARY = "DIET";
	public static final String RESULTCATEGORY_MEDICATION = "MEDN";
	public static final String RESULTCATEGORY_NEWBORN = "NBDT";
	public static final String RESULTCATEGORY_ADVERSEEVENT = "ALGY";
	public static final String RESULTCATEGORY_MONITORING = "NCIN";
	
	public static final String RESULTCATEGORY_OTHERS = "OTHERS";
	
	public static final String GROUPBY_CATEGORY = "CAT";
	public static final String GROUPBY_SUBCATEGORY = "SUBCAT";
	
	public static final String RESULTDATATYPE_NUM = "NUM";
	public static final String RESULTDATATYPE_STR = "STR";
	public static final String RESULTDATATYPE_HTM = "HTM";
	public static final String RESULTDATATYPE_TXT = "TXT";
	public static final String RESULTDATATYPE_ALL = "ALL";
	
	public static ArrayList<String> GETOTHERSCATLIST(){
		ArrayList<String> OTHERS_LIST = new ArrayList<String>();
		OTHERS_LIST.add(RESULTCATEGORY_CLINICALNOTE);
		OTHERS_LIST.add(RESULTCATEGORY_FUTUREEVENTS);
		OTHERS_LIST.add(RESULTCATEGORY_PATIENTCARE);
		OTHERS_LIST.add(RESULTCATEGORY_PROBLEMDIAGNOSIS);
		OTHERS_LIST.add(RESULTCATEGORY_DISCHARGESUMMARY);
		OTHERS_LIST.add(RESULTCATEGORY_TREATMENT);
		OTHERS_LIST.add(RESULTCATEGORY_BLOODTRANSFUSION);
		OTHERS_LIST.add(RESULTCATEGORY_FREEDOCUMENTATION);
		OTHERS_LIST.add(RESULTCATEGORY_MIGCLINICALINFO);
		OTHERS_LIST.add(RESULTCATEGORY_DIETARY);
		OTHERS_LIST.add(RESULTCATEGORY_MEDICATION);
		OTHERS_LIST.add(RESULTCATEGORY_NEWBORN);
		OTHERS_LIST.add(RESULTCATEGORY_ADVERSEEVENT);
		OTHERS_LIST.add(RESULTCATEGORY_MONITORING);
		
		//making the ArrayList readonly
		Collections.unmodifiableList(OTHERS_LIST);
		
		return OTHERS_LIST;
	}
}
