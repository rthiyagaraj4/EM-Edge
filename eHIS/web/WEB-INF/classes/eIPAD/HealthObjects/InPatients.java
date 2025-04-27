/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.HealthObjects;
import java.io.*;
public class InPatients implements java.io.Serializable
{
	public String sPatientName;
	public String sPatientId;
	public String sAge;
	public String sGender;
	public String sPhysicianName;
	public String sAdmDateTime;
	public String sRoomNo;
	public String sBedNo;
	public String sDischargeDateTime;
	public String sEpisodeId;
	public String sStatus;
	public String locationType;
	public String locationCode;
	public String serviceCode;
	public boolean relnExists;
	public String sSpecialityCode;

}
