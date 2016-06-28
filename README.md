# Grails 2.5.4 Bug Report - Sample Application

This applicaiton demonstrate some strange behaviour with Grails 2.5.4 which might be a bug. 

The recent issue I found is with data-binding and having a getter for a property. For example - 

```
package test

class PersonCO {
    String name
    List<String> tags
    
    
    List<String> getTags() {
        this?.tags?.findAll { it }
    }
}
```

The data binding would not work in above when a request comes with tags information `["one", "two"]`. But, it will work if you change the getter implementation as following:

```
List<String> getTags() {
        this.tags = this?.tags?.findAll { it }
        this.tags
    }
```

In this project I have one command object `PersonCO` in `/src/groovy/test` and a `UtilController`. I have also added a failing unit test `UtilControllerSpec` demonstrating the problem. 
