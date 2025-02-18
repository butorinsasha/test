package mockito

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`


class MyClass(val dependency: Dependency) {

    fun myMethod(): String {
        return dependency.doSomething()
    }

    fun myMethod(string: String): String {
        return dependency.doSomething(string)
    }
}

class Dependency {
    fun doSomething(): String {
        return "Tinkoff Bank"
    }

    fun doSomething(str: String): String {
        return str
    }

    fun doSomethingElse(): String {
        return "Tinkoff Credit Systems"
    }
}

class MyClassMockitoTest {
    private lateinit var myClass: MyClass
    private lateinit var dependency: Dependency

    @Before
    fun setUp() {
        // 1) Создаем макет объекта Dependency.
        dependency = mock(Dependency::class.java)

        // 2) Передаем его в класс MyClass.
        myClass = MyClass(dependency)
    }

    @Test // [1] Тестирование метода, зависящего от другого компонента
    fun testMyMethodWhen() {
        // 3) Затем определяем поведение метода doSomething().
        `when`(dependency.doSomething()).thenReturn("T-Bank")

        val result = myClass.myMethod()

        // 4) Тестируем метод myMethod(), который зависит от Dependency.
        assertEquals("T-Bank", result)
    }


    @Test // [2]. Проверка вызова метода
    // В этом примере мы проверяем, что метод doSomething() был вызван в методе myMethod().
    // Если бы это позволяла сигнатура метода, мы могли бы проверять, что метод был вызван с параметром, например doSomething( “test”).
    fun testMyMethodVerify() {
        myClass.myMethod()
        // verify(dependency).doSomethingElse() /Wanted but not invoked: dependency.doSomethingElse();
        verify(dependency).doSomething()
    }

    @Test // [3] Проверка количества вызовов метода
    // В этом примере мы проверяем, что метод doSomething() был вызван дважды в методе myMethod().
    fun testMyMethodVerifyTimes() {
        myClass.myMethod()
        myClass.myMethod()
        verify(dependency, times(2)).doSomething()
    }

    @Test // [4] Определение поведения метода с параметрами
    fun testMyMethodWhenWithParams() {
        `when`(dependency.doSomething("test")).thenReturn("result")
        val result = myClass.myMethod("test")
        assertEquals("result", result)
    }


    @Test // [5] Определение поведения метода, вызывающего другой метод
    fun testMyMethodWhenCallingAnotherMethod() {
        // Определяем поведение метода doSomething(), который вызывает метод doSomethingElse() и возвращает значение "result"
        `when`(dependency.doSomething()).thenAnswer {
            dependency.doSomethingElse()
            "result"
        }

        val result = myClass.myMethod()

        // Затем тестируем метод myMethod()
        assertEquals("result", result)

        // Проверяем, что метод doSomethingElse() был вызван.
        verify(dependency).doSomethingElse()
    }
}
