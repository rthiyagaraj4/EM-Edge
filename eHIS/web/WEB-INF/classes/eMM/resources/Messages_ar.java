package eMM.resources;

import java.util.*;

public class Messages_ar extends ListResourceBundle implements java.io.Serializable{

	public Object[][] getContents() {
		return contents;
	} 
	static final Object[][] contents = {
		{"ATLEAST_ONE_RECORD_ENTERED","يجب إدخال سجل واحد فقط على الاقل"},
		{"ITEM_ANALYSIS_UNIQUE","يجب كود التحليل ان يكون فريد"},
		{"ITEM_EITHER_PH_CSSD","يجب ان يكون الصنف مخزن صيدلية او  مركب CSSD"},
		{"STORE_EITHER_EXT_DEPT","المخزن يجب ان يكون  خارجي او لقسم داخلي"},
		{"INVALID_AM_TRADE_ID","كود الإسم التجاري غير فعال"},
		{"INVALID_MM_ITEM_CODE","كود العنصر غير فعال"},
		{"DUPLICATE_ENTRIES_NOT_ALLOWED","الإدخالات المكررة غير مسموح بها"},
		{"NOT_APPL_FOR_THIS_INSTAL","هذة الوظيفة لا تنطبق  "},
		{"CONV_FACTOR_NOT_GREATER_THAN_ONE","لا يمكن أن يكون عامل التحويل أكبر من واحد"},
		{"DIRECT_SALES_NOT_ALLOWED","لا يمكن إلغاء التحديد. العنصر محدد بعبارة \"مشاكل البيع / المريض\" لمخزن واحد أو أكثر."},
		{"STOCK_IN_HAND","المخزون متاح لهذا العنصر. لا يمكن إجراء المعاملات على مخزون لعنصر غير نشط."},
		{"PARAMETER_SETUP","يرجى ضبط إعدادات المنشأة و الجهة للمتابعة."}
	};
}
