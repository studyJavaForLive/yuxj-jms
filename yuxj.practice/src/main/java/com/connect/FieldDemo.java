package com.connect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FieldDemo {
	
	public static void main(String[] args) {
		
		/*String str = new String();
		
		Class<? extends String> c = str.getClass();//获取类的类 类型
		
		Field[] fields = c.getDeclaredFields();
		
		for (Field field : fields) {
			
			System.out.println(field);
			
		}
		*/
		MethodReflect mf = new MethodReflect();
		
		Class< ? extends MethodReflect> c1 = mf.getClass();
		
		Method m = null;
		
		try {
			
			m = c1.getMethod("add", new Class[]{int.class,int.class});
			
			Object o = m.invoke(mf,10,20);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
class MethodReflect{
	
	public void add(int a, int b) {
		
		System.out.println(a+b);
		
	}
	
}
