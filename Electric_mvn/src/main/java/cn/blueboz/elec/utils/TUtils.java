package cn.blueboz.elec.utils;

import java.lang.reflect.ParameterizedType;

public class TUtils<T> {
	/**
	 * 送入含有泛型的class，返回泛型类
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	@SuppressWarnings("rawtypes")
	public static Class getTClass(Class entity) {
		ParameterizedType pt=(ParameterizedType) entity.getGenericSuperclass();
		Class clazz=(Class) pt.getActualTypeArguments()[0];
		return clazz;
	}
}
