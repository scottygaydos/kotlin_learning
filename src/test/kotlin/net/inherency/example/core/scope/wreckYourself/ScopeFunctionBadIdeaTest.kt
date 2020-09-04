package net.inherency.example.core.scope.wreckYourself

import net.inherency.example.Person
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class ScopeFunctionBadIdeaTest {

    @Nested
    class Also {
        @Test
        fun `ALSO calls a function block using object as argument and CAN mutate it`() {
            val scotty = Person("Scotty", 37)

            scotty.also {
                it.age = it.age + 1
            }

            Assertions.assertEquals(38, scotty.age)
        }

        @Test
        fun `ALSO calls a function block on null objects and executes the function block regardless`() {
            val nullPerson: Person? = null

            val stillTheNullPerson: Person? = nullPerson.also {
                "Happy birthday $it." //This is highlighted by IntelliJ because it is never used.
            }

            //This is really nice!  Kotlin allows toString() on a null object,
            //and kotlin doesn't throw an exception!
            Assertions.assertEquals("null", stillTheNullPerson.toString())
        }

        //This is probably bad by convention.
        @Test
        fun `ALSO calls a function block on null objects and can modify variables`() {
            val nullPerson: Person? = null
            var shouldChange = 0

            nullPerson.also {
                shouldChange++
            }

            Assertions.assertEquals(1, shouldChange)
        }
    }

    @Nested
    class Let {
        //Maybe useful?  Sometimes?  Be wary, though...
        @Test
        fun `LET on a null object executes the lambda when the safety check is inside LET`() {
            val nullPerson: Person? = null
            var counter = 0

            nullPerson.let {
                val ignored = it?.age?.plus(1)
                counter += 1
                ignored
            }

            Assertions.assertEquals(1, counter)
        }

        //This is probably bad by convention.
        @Test
        fun `LET calls a function block using object as argument and CAN mutate it (but we should not do this!)`() {
            val scotty = Person("Scotty", 37)

            scotty.let {
                //Calling this age setter probably bad by convention.
                it.age = it.age + 1
                "Happy birthday ${it.name}. You are ${it.age} today!"
            }

            //Because LET returns the birthday message, we should not mutate the age in the block.
            //See ALSO for a better mutate option.
            Assertions.assertEquals(38, scotty.age)
        }

        //This is probably bad by convention.
        @Test
        fun `LET calls a function block on null objects and can modify variables`() {
            val nullPerson: Person? = null
            var shouldChange = 0

            nullPerson.let {
                shouldChange++
            }

            Assertions.assertEquals(1, shouldChange)
        }
    }

    @Nested
    class Run {
        //This is probably not good by convention
        @Test
        fun `RUN extension function can alter variables passed into scope try not to do this!`() {
            var counter = 0

            Person("Scotty", 37).run {
                counter += 1
                val newAge = age + 1
                newAge
            }

            Assertions.assertEquals(1, counter)
        }

        //This is probably not good by convention
        @Test
        fun `RUN top level function can alter variables passed into scope try not to do this!`() {
            var counter = 0

            run {
                counter += 1
                2
            }

            Assertions.assertEquals(1, counter)
        }
    }

    @Nested
    class With {
        @Test
        fun `WITH assigns or mutates values in an object with an explicit use of THIS keyword`() {
            val person = Person("Scotty", 37)
            with(person) {
                this.age = 38
            }

            Assertions.assertEquals(38, person.age)
        }

        @Test
        fun `WITH assigns or mutates values in an object with an implicit use of THIS keyword`() {
            val person = Person("Scotty", 37)

            with(person) {
                age += 1
                age
            }

            Assertions.assertEquals(38, person.age)
        }
    }

}
