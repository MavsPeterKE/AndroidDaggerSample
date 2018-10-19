# AndroidDaggerSample
Simple example showing how to implement dagger for dependencies injection

##Getting Started
The code has three packages
*di (for dependecy injection modules and Components)
*model (Contains my UserModel which i intend to inject to my activity)
*view (Contains Android Activity Class)
*viewmodel (to hold logic of my Activity class)
*MyApp Class (Creates the dagger component and exposes it through public method)

### Add Dagger 2 to your build.gradle
Open your app gradle file and add to your dependencies
    implementation 'com.google.dagger:dagger:2.15'
    annotationProcessor 'com.google.dagger:dagger-compiler:2.15'



##Dagger Annotations
**@Module - Defines a class that provides dependency and the annotation is placed on top of the class
**@Component - Defines a class that provides dependency and the annotation is placed on top of the class
**@Inject - Defines a class that provides dependency and the annotation is placed on top of the class

