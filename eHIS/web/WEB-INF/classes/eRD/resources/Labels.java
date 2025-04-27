/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ************************************************************************************/
/* 
Sr No        Version        Incident/TFS         SCF/CRF            				 Developer Name
--------------------------------------------------------------------------------------------------
1            V220107           26735       PMG2021-COMN-CRF-0089.1-TF-US001            Mohanapriya K
---------------------------------------------------------------------------------------------------
 */
package eRD.resources;   
import java.util.*;

public class Labels extends ListResourceBundle implements java.io.Serializable{
	public Object[][] getContents() {
         return contents;
    }
	static final Object[][] contents = {
		{"eRD.Exam.label","Exam"},
		{"eRD.ResultInd.label","Result Indicator"},
		{"eRD.Regno.label","Reg no."},
		{"eRD.ComplDateTime.label","Compl. Date/Time"},
		{"eRD.AwaitTimeMin.label","Awaiting Time (In Min.)"},
		{"eRD.ContrastType.label","Contrast Type"},
		{"eRD.PrelimRadiologist.label","Prelim Radiologist"},
		{"eRD.Radiologist.label","Radiologist"},
		{"eRD.Wing.label","Wing"},
		{"eRD.Doctor.label","Doctor"},
		{"eRD.StudyLocation.label","Study Location"},
		{"eRD.WorkList.label","Work List"},
		{"eRD.stat.label","Stat"},
		{"eRD.Registrationdate.label","Registration Date"}
		//V211228 ends	 
};
}