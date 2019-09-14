package ru.anatsarego.di;

public class InjectorImpl implements Injector{
    public <T> T get(Class<T> clazz) {
        try {
	    return clazz.newInstance();
	} catch (InstantiationException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IllegalAccessException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
        return null;
    }
}
