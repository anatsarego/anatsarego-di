package ru.anatsarego.di;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class MainTest {
    @Test
    public void testA() {
	Injector injector = new InjectorImpl();
	ClassA objA = injector.get(ClassA.class);
	assertNotNull(objA);
    }
    
    @Test
    public void testB() {
	Injector injector = new InjectorImpl();
	ClassB objB = injector.get(ClassB.class);
	assertNotNull(objB);
    }
    
    @Test
    public void testC() {
	Injector injector = new InjectorImpl();
	ClassC objC = injector.get(ClassC.class);
	assertNotNull(objC);
    }
}
