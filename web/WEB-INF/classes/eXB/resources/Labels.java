/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXB.resources;

import java.util.*;

public class  Labels  extends ListResourceBundle{
	public Object[][] getContents() {
         return contents;
    }

	static final Object[][] contents = {

{"eXB.FinalizedBy.Label","Finalized By"},
{"eXB.LastConfirmDate.Label","Last Confirmed Date"},
{"eXB.QtyFinalized.Label","Quantity Finalized"},
{"eXB.Showhidecolumns.Label","Show/Hide Columns"},
{"eXB.Showhidecolumns.Label","Module Type"},
{"eXB.PayerGroup.Label","Payer Group"},
{"eXB.Payer.Label","Payer"},
{"eXB.Policy.Label","Policy"},
{"eXB.EpisodeType.Label","Episode Type"},
{"eXB.Enabled.Label","Enabled"}
};
}

