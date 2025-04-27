/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT.WidgetSelection;

import javax.ejb.EJBLocalObject ;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Properties;
//import javax.ejb.*;
public interface WidgetSelectionLocal extends EJBLocalObject {
	java.util.HashMap insertWidgetSelection(java.util.Properties jdbc_props, java.util.HashMap htAEManagePatient);
}
