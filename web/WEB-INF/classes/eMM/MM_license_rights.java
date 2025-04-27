/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMM;
 
public class MM_license_rights
{

    public MM_license_rights() {}

	public static String STboundary="I";   /*  P - for Pharmacy Inventory Only   I -  for Complete inventory   N - Inventory module Not Installed */
	
	public static String SSboundary="I";   /*  S - for Sterlie Stock Only        I -  for SS & Inventory       N - Sterile Stock Not Installed    */

    public static String SSperiodend="F";   /*  F- Facility Level              E - Accounting Entity Level                                          */

    public static String STperiodend="F";   /*  F- Facility Level              E - Accounting Entity Level                                          */

    public static String POboundary="N";   /*  P - Purchase Only     I - Purchase Inventory       N - Purhcase not Installed */
	
	public static String getSTboundary()
	{
		return STboundary;
	}
	public static String  getSSboundary()
	{
		return SSboundary;
	}
	public static String  getSSperiodend()
	{
		return SSperiodend;
	}
	public static String  getSTperiodend()
	{
		return STperiodend;
	}
	public static String getPOboundary()
	{
		return POboundary;
	}


}


