package ru.anatsarego.di;

public interface Injector {
    <T> T get(Class<T> clazz);
}
