# JDuden
With this small library you can query [duden.de](https://duden.de) for words. It returns all information about a given word from the website.
## Installation
Download the jar file from the [release page](https://github.com/Gregyyy/JDuden/releases).

### Maven

````xml
<dependency>
    <groupId>me.gregyyy.jduden</groupId>
    <artifactId>jduden</artifactId>
    <version>VERSION</version>
</dependency>
````

## Usage
This project can only be used as a libary.

Examples:
```JAVA
Word word = JDuden.getWort("Joghurt");
System.out.println("The word " + word.getWord() + " can be written as " +  word.getAltSpellings() + ".");
```

```JAVA
Word word = JDuden.getWort("Leben");
System.out.println("The meaning of life is: " + word.getMeanings().get(0));
```

Tips:
- JDuden#getWord is case sensitive
- Some information can be null, when there are not provided by duden.de
