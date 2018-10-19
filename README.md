# AndroidDaggerSample
Simple example showing how to implement dagger for dependencies injection

## Getting Started
The code has three packages

* di (for dependecy injection modules and Components)
* model (Contains my UserModel which i intend to inject to my activity)
* view (Contains Android Activity Class)
* viewmodel (to hold logic of my Activity class)

MyApp Class (Creates the dagger component and exposes it through public method)

### Add Dagger 2 to your build.gradle
Open your app gradle file and add to your dependencies 
   > implementation 'com.google.dagger:dagger:2.15'
   > annotationProcessor 'com.google.dagger:dagger-compiler:2.15'



## Dagger Annotations
* @Module - Defines a class that provides dependency and the annotation is placed on top of the class.
* @Provides - Tells dagger that the dependency is provided by given function.
* @Component - An interface contain methods that specify to Dagger where to inject the dependencies. It is added on top of the class and includes modules providing the dependencies.
* @Inject - Used to request for dependency in classes which requires to use them.

## Creating DaggerComponent
Once the module and Component has been created, build the app and dagger will automatically generate DaggerComponent that you will use to initialize you component.


## Injecting Your Dependencies into the class
For Easier implementation, create a class extending Application class and define your component which you initialize on its onCreate
Create a public method to provide the component
You can also create a public static method to give you the instance of the class such that you will not have to create its object from your activity but instead call it directly
```java
public class MyApp extends Application {
    private static MyApp app;
    private UserModule userModule;
    private UserComponent userComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;

        userModule = new UserModule();
        userComponent = DaggerUserComponent.builder()
                .userModule(userModule)
                .build();
    }

    public static MyApp app() {
        return app;
    }

    public UserComponent userComponent() {
        return userComponent;
    }
}

```
Add the class to your manifest
```xml
        android:name=".MyApp"
```
On your Activity's oncreate, call the component and access it method specifying injection target and give it the activity context
use @Inject to request for your dependencies provided by the module
```java
 @Inject
    User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        MyApp.app().userComponent().inject(this);
    }
```

