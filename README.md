# CPSC 411- Mobile Device Application Development
# Fall 2018 - Mini-App 4, due December 13
## Introduction
In this project, I modify the code for [Mini-App 3](https://github.com/tngo0508/mini-app03) to store
 data in a [ViewModel](https://developer.android.com/reference/android/arch/lifecycle/ViewModel) 
 and display it using a [data binding layout](https://developer.android.com/topic/libraries/data-binding/expressions).
## Dependencies
+ [Enabling data binding](https://developer.android.com/topic/libraries/data-binding/start#build_environment)
+ [Adding lifecycle dependencies](https://developer.android.com/topic/libraries/architecture/adding-components#lifecycle)
+ [Kotlin support additional configuration](https://developer.android.com/topic/libraries/architecture/adding-components#kotlin)
## ViewModel
+ I create a ViewModel class to hold the network speed, file size, and transfer time.
+ Since the transfer time will be updated based on the values of the other two fields, I need use an
 [Observable](https://developer.android.com/reference/android/databinding/ObservableDouble) for transfer time.
+ Then, I add methods to the ViewModel class to recompute the transfer time when the other fields are changed.
## Data Binding
1. Convert the layout for the fragment (or activity) to a data binding layout, and declare 
a variable in the <data> section for the ViewModel.
2. Modify the android:text attributes of widgets in the layout to use data binding to display the value from the ViewModel variable.
3. Modify the fragment or activity to create the ViewModel object, [inflate the layout and retrieve 
the binding](https://developer.android.com/topic/libraries/data-binding/expressions#binding_data), 
and [assign the ViewModel object to a property in the binding class](https://developer.android.com/topic/libraries/data-binding/architecture#viewmodel).
-  __Note__: Remove the Kotlin code from the fragment or activity that has been replaced by data binding.
## Updating the transfer time
+ The Data Binding Library includes a [BindingAdapter](https://www.bignerdranch.com/blog/descent-into-databinding/#fantastic-bindingadapters-and-where-to-find-them) that will allow handlers for individual 
[TextWatcher](https://developer.android.com/reference/android/text/TextWatcher) events to be declared in the layout.
+ Add an android:onTextChanged attribute to each of the EditText widgets in the layout and 
set their [listener bindings](https://developer.android.com/topic/libraries/data-binding/expressions#listener_bindings) to call the methods I added to the ViewModel class.
## Acknowledgement
-   **Professor Kenytt Avery** - _kavery@fullerton.edu_ - California State University, Fullerton
- [Android Data Binding CodeLab](https://codelabs.developers.google.com/codelabs/android-databinding/#0)
