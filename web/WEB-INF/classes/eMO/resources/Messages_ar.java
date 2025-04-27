package eMO.resources;
import java.util.*;

public class Messages_ar extends ListResourceBundle implements java.io.Serializable
{
	public Object[][] getContents() 
	{
		return contents;
	}

	static final Object[][] contents = 
	{
{"PATIENT_IS_NOT_DECEASED","APP-MO0001 المريض ليس متوفي"},
{"PATIENT_ALREADY_REGISTERED","APP-MO0002 المريض مسجل بالفعل"},
{"MAX_SHOULD_BE_GT_NEXT","APP-MO0003 # يجب ان تكون اكبر من $"},
{"MAX_SHOULD_BE_GT_START","APP-MO0004 يجب أن يكون الرقم الأقصى أكبر من رقم البداية"},
{"START_NUM_CANT_BE_ZERO","APP-MO0005 لا يمكن أن يكون رقم البداية صفرًا"},
{"CANT_BE_LT_DECEASED_DATE","APP-MO0006 لا يمكن أن يكون تاريخ استلام الجثمان / تصريح الدفن أقل من تاريخ الوفاة"},
{"PM_END_CANT_BE_LT_PM_START","APP-MO0007 تاريخ و وقت إنتهاء فحص الجثمان لا يمكن أن يكون أقل من تاريخ و وقت بداية الفحص"},
{"DATE_CANT_BE_LT_RECEIPT","APP-MO0008 لا يمكن أن يكون التاريخ أقل من تاريخ استلام الجثمان"},
{"REG_NO_EXCEEDS_MAX_NO","APP-MO0009 يتجاوز رقم التسجيل الحد الأقصى للرقم المحدد في الإعدادات"},
{"AREA_EXCEEDS_CAPACITY","APP-MO0010 السعة مكتملة للمنطقة"},
{"REGN_NO_CTRL_TO_BE_SETUP","APP-MO0011 يجب تسجيل إعدادات التحكم في رقم التسجيل"},
{"SAME_PRACT_ID_NOT_ALLOWED","APP-MO0012 لا يمكن اختيار نفس الطبيب"},
{"PARAMETER_TO_BE_SETUP","APP-MO0013 لابد من تسجيل إعدادات النظام"},
{"CUTOFF_PERIOD_CHECK","APP-MO0014 (اقل من عدد ساعات) يجب ان يكون اكبر من (اكثر من عدد ساعات)"},
{"REGN_NOT_ALLOWED","APP-MO0015 غير مسموح بالتسجيل"},
{"CANNOT_CREATE_BAYS","APP-MO0016 تم إنشاء المواقع بالفعل حسب سعة المنطقة"},
{"BURIAL_PERMIT_NO_EXISTS","APP-MO0017 رقم تصريح الدفن موجود بالفعل"},
{"BURIAL_PERMIT_NO_GT_ZERO","APP-MO0018 يجب أن يكون رقم تصريح الدفن التالي أكبر من صفر ويجب ألا يقل عن رقم تصريح الدفن التالي"},
{"DONOR_DETAILS_EXCEEDS_LIMIT","APP-MO0019 لا يمكن أن تكون تفاصيل المتبرع أكبر من 500 حرف"},
{"SAME_WITNESS","APP-MO0020 لا يمكن أن يكون لديك نفس الشاهد"},
{"SPECI_ANOTOM_UNIQUE","APP-MO0021 يجب أن يكون نوع العينة والموقع التشريحي فريدًا"},
{"POSTMORTEM_FINDINGS","APP-MO0022 لا يمكن أن تكون نتائج تشريح الجثمان أكبر من 500 حرف"},
{"CNT_ASIGN_SAME_DIAG_CODE","APP-MO0023 لا يمكن تعيين نفس رمز التشخيص"},
{"PM_PURPOSE","APP-MO0024 لا يمكن أن يتجاوز الغرض من إجراء تشريح الجثمان 250 حرفًا"},
{"DEATH_CAUSE_EXCEEDS_LMT","APP-MO0025 لا يمكن أن يتجاوز سبب الوفاة 250 حرفًا"},
{"POLICE_DET_EXCEEDS_LMT","APP-MO0026 لا يمكن أن تتجاوز تفاصيل الشرطة 500 حرف"},
{"EXPRT_ADR_EXCEEDS_LMT","APP-MO0027 لا يمكن أن يتجاوز العنوان 500 حرف"},
{"BURIAL_PERMIT_NOT_EXIST","APP-MO0028 تصريح الدفن غير موجود"},
{"BURIAL_PERMIT_NOT_ALLOWED","APP-MO0029 تصريح الدفن غير مسموح به لأن تشريح الجثمان مطلوب"},
{"OBTAINFROM_SELECT","APP-MO0030 يجب تحديد حقل (تم الحصول عليها من)"},
{"REFRESH_INTERVAL_CHK","APP-MO0031 يجب أن يكون الفاصل الزمني للتحديث بين 1 و 9999"},
{"BLK_DATE_TIME","APP-MO0032 يجب أن يكون حتى تاريخ و وقت الحظر حتى أكبر من التاريخ و الوقت الحالي"},
{"VAC_BED_SEL","APP-MO0033 الموقع المحدد مخصص / محظور حاليًا"},
{"BUR_NT_GEN","APP-MO0034 لم يتم إصدار تصريح الدفن بعد. لا يمكن المتابعة ...."},
{"POLICE_DET_MAND","APP-MO0035 يجب تسجيل تفاصيل الشرطة"},
{"CAUSE_OF_DEATH_NOT_REC","APP-MO0036 سبب الوفاة غير مسجل. لا يمكن المتابعة."},
{"CNT_REASSIGN","APP-MO0037 تم تقديم الطلب. قم بإلغاء الأمر لإعادة تعيين المنطقة."},
{"CAPACITY_GREATER_LOCATION","APP-MO0038 يجب أن تكون قيمة السعة أكبر من الموقع الذي تم إنشاؤه."},
{"CAPACITY_GREATER_ZERO","APP-MO0039 يجب أن تكون قيمة السعة أكبر من الصفر."},
{"DATE_CANT_BE_BLANK","APP-MO0040 لا يمكن أن يكون التاريخ فارغًا"},
{"ENTER_BDYRCPT_DTTIME","APP-MO0041 يجب إدخال تاريخ / وقت استلام الجثمان أولاً .."},
{"ENTER_POLICE_DTLS","APP-MO0042 يجب إدخال جميع تفاصيل الشرطة"},
{"FROM_DATE_LESS_EQ_TO_DATE","APP-MO0043 يجب أن يكون من التاريخ أقل من أو يساوي إلى تاريخ"},
{"REASON_CANT_MORE","APP-MO0044 لا يمكن أن يكون السبب أكثر من 100 حرف ..."},
{"BODY_PART_DTLS_CANT_VIEW","APP-MO0045 لا يمكن الاطلاع على تفاصيل تسجيل أجزاء الجسم هنا ..."},
{"ENTER_TISSUE_PROCMENT_DATE","APP-MO0046 يجب إدخال تاريخ شراء الأنسجة"},
{"CAPTURE_SPECIMEN_DTLS","APP-MO0047 يجب تسجيل جميع تفاصيل العينة"},
{"DATE_CANT_BE_LESS","APP-MO0048 لا يمكن أن يكون تاريخ $ أقل من تاريخ #"},
{"CAPTURE_BURIAL_PRMT_DTLS","APP-MO0049 يجب تسجيل جميع تفاصيل تصريح الدفن"},
{"SELECT_BODY_PART","APP-MO0050 يجب تحديد جزء واحد على الأقل من اجزاء الجسم"},
{"CAPTURE_CONSENT_DTLS","APP-MO0051 يجب تسجيل جميع تفاصيل الموافقة"},
{"CAPTURE_DONOR_DTLS","APP-MO0052 يجب تسجيل جميع تفاصيل المتبرع"},
{"ENTER_DONOR_CARD_INFO","APP-MO0053 يجب إدخال معلومات بطاقة المتبرع"},
{"ID_MARKS_EXCEEDS_LMT","APP-MO0054 لا يمكن أن تتجاوز علامات التعريف 500 حرف ..."},
{"USER_CANT_EXCEEDS_PARAM","APP-MO0055 لا يمكن للمستخدم تجاوز قيمة الإعدادات"},
{"MO_PARAM_NOT_FOUND","APP-MO0056 لم يتم تعريف الإعدادات "},
{"NOT_EXT_PAT","APP-MO0057  المريض توفى في منشأة تسجيل الدخول. لا يمكن تسجيله على أنه خارجي"},
{"REASON_EXCEED_MAX_LEN","APP-MO0058 لا يمكن أن يتجاوز السبب 100 حرف"},
{"ENTER_DECEASED","APP-MO0059 قم بإدخال المريض المتوفى فقط"},
{"EMBALM_HOME_OR_HOSPITAL","APP-MO0060 يجب إختيار الغسل في المستشفى أو المنزل"},
{"EMBALM_NOT_COMPLETED","APP-MO0061 لا يمكن خروج الجثمان لعدم إستكمال الغسل"},
{"EMBALM_NOT_DEFINED","APP-MO0062 لم يتم تحديد إعدادات رقم الغسل. لا يمكن المتابعة"},
{"EMBALM_REG_NO_EXCEEDS_MAX_NO","APP-MO0063 يتجاوز رقم تسجيل الغسل الرقم الأقصى المعرف في إعدادات رقم الغسل"},
{"CANT_BE_LT_DECEASED_DATE1","APP-MO0064 لا يمكن أن يكون تاريخ استلام الجثمان / تصريح الدفن أقل من تاريخ الوفاة"}

};		
}
