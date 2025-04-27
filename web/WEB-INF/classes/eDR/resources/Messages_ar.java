package eDR.resources;
import java.util.*;

public class Messages_ar extends ListResourceBundle implements java.io.Serializable
{
	public Object[][] getContents() 
	{
		return contents;
	}

	static final Object[][] contents = 
	{
{"THREE_FIELD","APP-DR0001 يجب تحديد 3 حقول على الأقل"},
{"CHECK_DAY_MONTH","APP-DR0002 يتم الفحص على مجموعة السنة / الشهر / اليوم"},
{"CHECK_MONTH_YEAR","APP-DR0003 تحقق من السنة / الشهر"},
{"ATLEAT_ONE_NAME","APP-DR0004 يجب تحديد مكون اسم واحد على الأقل"},
{"SEARCH_ACTIVE","APP-DR0005 تم تنشيط وظيفة البحث هذه بالفعل"},
{"ONLY_TWO","APP-DR0006 يمكن اختيار مريضين فقط"},
{"TWO_PATIENTS","APP-DR0007 يجب اختيار مريضين على الأقل"},
{"TEN_PATIENTS","APP-DR0008 العرض غير ممكن لأكثر من 10 مرضى. حدد أي مريضين باستخدام خانة الاختيار"},
{"NO_RECORD","APP-DR0009 سجل المريض غير موجود"},
{"PATIENT_NOT_SELECTED","APP-DR0010 لم يتم تحديد سجل مريض"},
{"CYCLE_IN_PROGRESS","APP-DR0011 الدورة قيد التقدم بالفعل"},
{"NO_RECORD_AVAILABLE","APP-DR0012 لا توجد سجلات متاحة في الجدول"},
{"DR_PARAM_NOT_AVAILABLE","APP-DR0013 DR لم يتم إعداد معلمة"},
{"ATLEAST_ONE_VALID","APP-DR0014 يجب تحديد معرّف مريض رئيسي واحد"},
{"INVALID_DATETIME","APP-DR0015 تنسيق التاريخ والوقت غير صالح"},
{"NON_DUPLICATES","APP-DR0016 معرفات المريض موجودة بالفعل كتكرار"},
{"PATIENT_POSSIBLE_DUPLICATES","APP-DR0017 معرف المريض موجود بالفعل في التكرارات المحتملة"},
{"DUPLICATE_PATIENT_ENTRY","APP-DR0018 إدخال مريض مكرر"},
{"START_LATER_TIME","APP-DR0019 يجب أن يكون وقت تاريخ البدء لاحقًا أكبر من وقت التاريخ الحالي"},
{"ONLY_ONE_PAIR","APP-DR0020 يجب تحديد سجل واحد فقط"},
{"CHANGE_ID_SERIES_NOT_ALLOWED","APP-DR0021 التغيير إلى سلسله المعرف غير مسموح به لسلسلة بديلة أو وطنية"},
{"SHD_NOT_BE_BLANK","APP-DR0022 لا يمكن أن يكون معرف المريض فارغًا"},
{"ID_NO_NOT_BLANK","APP-DR0023 لا يمكن أن يكون رقم المعرف فارغًا"},
{"DUPLICATE_ID_NO","APP-DR0024 رقم الهوية موجود بالفعل"},
{"RECORD_EXISTS","APP-DR0025 السجل موجود من قبل"},
{"SEARCH_MERGE_JOB_EXISTS","APP-DR0026 وظيفة البحث / الدمج موجودة في قائمة انتظار الوظائف"},
{"NO_USER_RIGHTS","APP-DR0027 لا يمتلك المستخدم حق الوصول إلى هذه الوظيفة"},
{"REMARKS_CANNOT_BE_BLANK","APP-DR0028 لا يمكن ترك الملاحظات فارغة"},
{"DR_USER_ID_NOT_BLANK","APP-DR0029 لا يمكن أن يكون معرف المستخدم فارغًا"},
{"MINIMUM_TWO_PATIENTS","APP-DR0030 يجب إدخال مريضين على الأقل"},
{"DECEASED_PATIENT","APP-DR0031 المريض مريض متوفى"},
{"DATE_TIME_NOT_BLANK","APP-DR0032 لا يمكن ترك حقل التاريخ والوقت فارغًا"},
{"NO_SEARCH_PROCESS","APP-DR0033 لا توجد دورة عملية DR قيد التقدم"},
{"NO_RECORDS_FOR_REVIEW","APP-DR0034 لا توجد بيانات متاحة للمراجعة"},
{"NAME_MANDATORY","APP-DR0035 يجب اختيار مكون اسم إلزامي واحد على الأقل كمعيار"},
{"PATIENT_REGISTERED_FACILITY","APP-DR0036 المريض غير مسجل تحت المنشأة الحالية"},
{"SEARCH_ALL_FACILITY","APP-DR0037 سيتم البحث في جميع المنشأت"},
{"SEARCH_PROCESS_JOB","APP-DR0038 يتم تقديم عملية البحث كوظيفة"},
{"MERGE_PROCESS_JOB","APP-DR0039 يتم تقديم عملية الدمج كوظيفة"},
{"UNMERGE_PROCESS_JOB","APP-DR0040 يتم تقديم عملية عدم الدمج كوظيفة"},
{"IDSERIES_PROCESS_JOB","APP-DR0041 يتم تقديم التغيير إلى عملية سلسلة المعرف كوظيفة"},
{"NO_USER_RIGHTS_ALL_FCY","APP-DR0042 لا يمتلك المستخدم حق الوصول إلى هذه الوظيفة عبر المنشأت"},
{"ATLEAST_ONE_DUPLICATE","APP-DR0043 يجب تحديد معرّف مريض واحد مكرر"},
{"DR_PROCESS_CYCLE","APP-DR0044 دورة عملية DR قيد التقدم بالفعل"},
{"REMARKS_NOT_EXCEED_500_CH","APP-DR0045 لا يمكن أن تتجاوز الملاحظات 500 حرف"},
{"ID_MIN_LENGTH","APP-DR0046 يجب أن يكون الحد الأدنى لطول رقم الهوية هو"},
{"INVALID_PAT","APP-DR0047 معرف المريض غير صالح"},
{"DELETE_RECORD","APP-DR0048 هل تريد حذف السجل؟"},
{"CANT_BE_LT","APP-DR0049 $ لا يمكن أن يكون أقل من #"},
{"NO_MERGED_PAT_REC","APP-DR0050 لا توجد سجلات مريض مدمجة"},
{"PATIENT_CUR_OUTPATIENT","APP-DR0051 المريض حاليا في العيادة الخارجية"},
{"START_LATER_DATE_BLANK","APP-DR0052 لا يمكن أن يكون تاريخ ووقت البدء لاحقًا فارغين"},
{"ABORT_PROCESS","APP-DR0053 هل تريد إحباط العملية؟"},
{"NEXT_EXE_DATE_GRT_CUR_DATE","APP-DR0054 يجب أن يكون تاريخ التنفيذ التالي أكبر من التاريخ الحالي"},
{"ATLEAST_ONE_CHECK_BEF_DEL","APP-DR0055 يجب تحديد سجل واحد على الأقل للحذف"},
{"ED_TIME_LESS_EQL_ST_TIME","APP-DR0056 لا يمكن أن يكون وقت الانتهاء أقل من وقت البدء أو مساويًا له"},
{"PAT_LENGTH","APP-DR0057 يجب أن يكون معرف المريض من"},
{"CLOSE_PROCESS","APP-DR0058 هل تريد إغلاق العملية؟"},
{"DR_INVALID_MERGE_TIME","APP-DR0059 وقت الدمج غير صالح. لا يمكن المتابعة"},
{"EXCLUDE_DUPLICATE_RECORD","APP-DR0060 استبعاد التكرارات المحتملة موجودة"},
{"PAT_SHD_BE_IDENTIFIED","APP-DR0061 يجب تحديد المريض أولاً"},
{"ONLY_ONE_MAIN","APP-DR0062 يجب تحديد معرّف مريض رئيسي واحد فقط"},
{"MERGE_DUPLICATES_EXISTS","APP-DR0063 معرف المريض موجود بالفعل في دمج التكرارات"},
{"ONE_MAIN_AND_ATLEAST_ONE_DUPLICATE","APP-DR0064 يجب تحديد هوية مريض واحدة رئيسية وواحدة على الأقل"},
{"ONLY_ONE_INPATIENT","APP-DR0065 هذا المريض حاليًا مريض داخلي. لا يمكن أن يكون هناك أكثر من مريض واحد كمريض داخلي للدمج."},
{"ATLEAST_ONE_VALID_EXISTS","APP-DR0066 يجب أن يكون هناك سجل مكرر واحد على الأقل. لا يمكن المتابعة"},
{"SELECT_MANDATORY_NAME","APP-DR0067 يجب اختيار واحد على الأقل من # مكون كمعيار"},
{"DELETE_BOTH_MAIN_AND_DUPLICATE","APP-DR0068 سيتم حذف كل من المرضى الرئيسيين والمكررين. هل تريد الاستمرار؟"},
{"TOOMANY_RECORDS_REFINE_SEARCH","APP-DR0069 تم العثور على سجلات كثيرة جدًا للمعايير المحددة. تنقية البحث"}

};		
}
