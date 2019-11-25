1. Getting Started with Android and Kotlin
2. Kotlin, XML, and the UI Designer
   - Add button and click event
   - Log and Tost
3. Exploring Android Studio and the Project Structure
   - manifests
   - java
   - res
     - strings.xml
4. Getting Started with Layouts and Material Design
   - LinearLayout
   - ConstraintLayout
   - TableLayout
5. Beautiful Layouts with CardView and ScrollView
   - Sizing using dp or density-independent pixels
   - Sizing fonts using sp or scalable pixels
   - layout_weight
   - layout_gravity
6. The Android Lifecycle
   - Being created onCreate()
   - Starting onStart()
   - Resuming onResume()
   - Running
   - Pausing onPause()
   - Stopping onStop()
   - Being destroyed onDestroy()
7. Kotlin Variables, Operators, and Expressions
8. Kotlin Decisions and Loops
   - Ranges
     `val rangeOfNumbers = 1..4`
     as same as`val rangeOfNumbers = listOf(1, 2, 3, 4)`
   - For loops, break, continue

```kotlin
val list = 1..10
for (i in list)
  Log.i("Looping through list","Current value is $i")
for (i in 0..999) {}
```

9. Chapter 9. Kotlin Functions

```kotlin
fun printSum(a: Int, b: Int): Int //or with out returntype
{
  Log.i("a + b = ","${a+b}")
  return a + b
}
//call
printSum(2, 3)
```

10. Object-Oriented Programming
    - constructors
11. Inheritance in Kotlin

    - Inheritance
    - Overriding
    - polymorphism

```kotlin
open class Soldier() {
     fun shoot () {
          Log.i("Action","Bang bang bang")
     }
}
class Paratrooper: Soldier() {
    fun jumpOutOfPlane() {
         Log.i("Action", "Jump out of plane")
    }
}
```

12. Connecting Our Kotlin to the UI and Nullability
13. Bringing Android Widgets to Life
14. Android Dialog Windows
15. Handling Data and Generating Random Numbers

### random

```kotlin
val randGenerator = Random()
var ourRandomNumber = randGenerator.nextInt(10)
//random number between 0 and 9
//If we want a random number between 1 and 10
ourRandomNumber ++
```

### array

```kotlin
var myIntArray: IntArray
var myFloatArray: FloatArray
var myBooleanArray: BooleanArray
//fix maximum storage
myIntArray = IntArray(100)
myFloatArray = FloatArray(100)
myBooleanArray = BooleanArray(100)
//assign
myIntArray [0] = 5
```

### array list

### hash map

16. Adapters and Recyclers

### inner class

```kotlin
class SomeRegularClass{
    var someRegularProperty = 1

    val myInnerInstance = MyInnerClass()

    fun someRegularFunction(){
        val someVariable = myInnerInstance.myInnerProperty
        myInnerInstance.myInnerFunction()
    }

    inner class MyInnerClass {
        val myInnerProperty = 1

        fun myInnerFunction() {
        }

    }
}
```

17. Data Persistence and Sharing
18. Localization
19. Animations and Interpolations
20. Drawing Graphics
21. Threads and Starting the Live Drawing App
22. Particle Systems and Handling Screen Touches
23. Android Sound Effects and the Spinner Widget
24. Design Patterns, Multiple Layouts, and Fragments
    - model-view-controller pattern
25. Advanced UI with Paging and Swiping
26. Advanced UI with Navigation Drawer and Fragment
27. Android Databases

- SQLite

28. A Quick Chat Before You Go
