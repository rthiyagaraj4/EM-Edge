/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA.DisDataCharting;

import java.util.HashMap;
import java.util.Properties;
import javax.ejb.EJBLocalObject;

public abstract interface DisDataChartingLocal extends EJBLocalObject
{
  public abstract HashMap operateDisDataCharting(Properties paramProperties, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String[][] paramArrayOfString, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17,String paramString18,String paramString19,String paramString20);//Added paramString20 for Bru-HIMS-CRF-133 [IN:034536] 
}
