package ru.anatsarego.di;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.inject.Inject;

public class InjectorImpl implements Injector{
    public <T> T get(Class<T> clazz) {
        try {
            Constructor<?> constructors[] = clazz.getConstructors();
            int constructorsWithInjectCounter = 0;
            Constructor<?> constructorWithInject = null;
            for (Constructor<?> constructor : constructors) {
		if (constructor.isAnnotationPresent(Inject.class)) {
		    constructorsWithInjectCounter++;
		    constructorWithInject = constructor;
		}
	    }
            
            if (constructorsWithInjectCounter > 1) {
        	throw new IllegalStateException("There are one more constructors with @Inject annotation");
            }
            
            if(constructorsWithInjectCounter == 1 ) {
        	Class<?> types[] = constructorWithInject.getParameterTypes();
        	Object initargs[] = new Object[types.length];
        	for (int i = 0; i < types.length; i++) {
		    initargs[i] = types[i].newInstance();
		}
		return (T) constructorWithInject.newInstance(initargs);
            }
	    return clazz.newInstance();
	} catch (InstantiationException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IllegalAccessException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IllegalArgumentException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (InvocationTargetException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
        return null;
    }
}
