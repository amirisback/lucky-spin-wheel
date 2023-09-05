![](https://raw.githubusercontent.com/frogobox/.github/main/docs/image/banner-frogo-kick-start-library.png?raw=true)

## About This Project
[![Android CI](https://github.com/frogobox/frogo-kick-start-library/actions/workflows/android-ci.yml/badge.svg)](https://github.com/frogobox/frogo-kick-start-library/actions/workflows/android-ci.yml)
- Template Frogo for creating library
- Using GitHub Action For CI / CD
- Privacy Policy [Click Here](https://github.com/frogobox/frogo-kick-start-library/blob/master/PRIVACY-POLICY.md)
- License [Click Here](https://github.com/frogobox/frogo-kick-start-library/blob/master/LICENSE)
- Check This Out [Original Repository LuckyWheel_Android by mmoamenn](https://github.com/mmoamenn/LuckyWheel_Android)

Repository for testing build from jitpack.io
- Red : Failed
- Green : Success / Pass

## Version Release
This Is Latest Release

    ~ Beta Release
    $version_release = comming-soon

What's New??

    * Comming Soon *

## Download this project

### Step 1. Add the JitPack repository to your build file (build.gradle : Project)
    
#### <Option 1> Groovy Gradle

    // Add it in your root build.gradle at the end of repositories:

    allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }

#### <Option 2> Kotlin DSL Gradle

```kotlin
// Add it in your root build.gradle.kts at the end of repositories:

allprojects {
    repositories {
        ...
        maven { url = uri("https://jitpack.io") }
    }
}
```
      
### Step 2. Add the dependency (build.gradle : Module)

#### <Option 1> Groovy Gradle

    dependencies {
        // library [project-name]
        implementation 'com.github.frogobox:[project-name]:comming-soon'
    }

#### <Option 2> Kotlin DSL Gradle

    dependencies {
        // library [project-name]
        implementation("com.github.frogobox:[project-name]:comming-soon")
    }

**Sample**

![Lucky wheel](https://github.com/mmoamenn/LuckyWheel_Android/blob/master/samples/color_image.png).

**Overview**

The LuckyWheel shows a wheel which can spin, and a marker that indicates the selected item in the wheel. Items may be customized with text, image, or a color.

The wheel starts off stationary. Calling the `setTarget()` method with an integer parameter will set the wheel to spin to that section when the user taps the wheel in the UI. Calling `rotateWheelTo()` with an integer parameter will cause the wheel to spin to that section immediately.

The wheel spins for a few seconds, then fires the `setLuckyWheelReachTheTarget` callback to notify the application it has stopped moving.

**XML**

```xml
<com.bluehomestudio.luckywheel.LuckyWheel
        android:id="@+id/lwv"
        android:layout_width="250dp"
        android:layout_height="250dp"
        android:layout_centerInParent="true"
        LuckyWheel:background_color="@color/colorPrimary" />
```


You must use the following properties in your XML

_Choose the background color_

```xml
LuckyWheel:background_color
```

_Choose wheel image arrow_

 ```xml
LuckyWheel:arrow_image
```
_Change item image padding_

 ```xml
LuckyWheel:image_padding
```

**Kotlin**

Functions to use after reference the Lucky wheel

* Create wheel sections

 ```kotlin
 val wheelItems: MutableList<WheelItem> = ArrayList()

 wheelItems.add(WheelItem(Color.LTGRAY,
 BitmapFactory.decodeResource(resources, R.drawable.ic_action_name),
 "text 1"))
 
 wheelItems.add(WheelItem(Color.BLUE,
 BitmapFactory.decodeResource(resources, R.drawable.ic_action_name),
 "text 2"))
 
 wheelItems.add(WheelItem(Color.BLACK,
 BitmapFactory.decodeResource(resources, R.drawable.ic_action_name),
 "text 3"))
 
 wheelItems.add(WheelItem(Color.GRAY,
 BitmapFactory.decodeResource(resources, R.drawable.ic_action_name)
 ,"text 4"))
 
 wheelItems.add(WheelItem(Color.RED,
 BitmapFactory.decodeResource(resources, R.drawable.ic_action_name),
 "text 5"))
 
 wheelItems.add(WheelItem(Color.BLACK,
 BitmapFactory.decodeResource(resources, R.drawable.ic_action_name),
 "text 6"))
 
 ```

* Add sections to wheel

 ```kotlin
  addWheelItems(wheelItems)
 ``` 
* Rotate by touch -- set target before user touch wheel

 ```kotlin
  setTarget(3)
 ``` 
* Rotate to section -- not need if you will use touch

 ```koltin
  rotateWheelTo(2)
 ``` 
* On target reach listener

 ```koltin
  lwv.setLuckyWheelReachTheTarget {
  
  }
 ```

## Colaborator
Very open to anyone, I'll write your name under this, please contribute by sending an email to me

- Mail To faisalamircs@gmail.com
- Subject : Github _ [Github-Username-Account] _ [Language] _ [Repository-Name]
- Example : Github_amirisback_kotlin_admob-helper-implementation

Name Of Contribute
- Muhammad Faisal Amir
- Waiting List
- Waiting List

Waiting for your contribute

## Attention !!!
- Please enjoy and don't forget fork and give a star
- Don't Forget Follow My Github Account

![](docs/image/mad_score.png?raw=true)
