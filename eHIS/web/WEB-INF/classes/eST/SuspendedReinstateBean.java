/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eST;

//import eCommon.Common.CommonAdapter;
import eST.Common.StAdapter;
//import eST.Common.StRepository;
import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class SuspendedReinstateBean extends StAdapter
    implements Serializable
{


    public SuspendedReinstateBean()
    {
        module_id = "ST";
    }
}
