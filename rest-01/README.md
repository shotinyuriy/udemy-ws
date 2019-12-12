
# Swagger Links
http://localhost:9001/v2/api-docs
http://localhost:9001/swagger-ui.html

# Troubleshooting
If try to add swagger to your project and you see the following error:

```
Caused by: org.springframework.beans.factory.NoUniqueBeanDefinitionException: No qualifying bean of type 'org.springframework.plugin.core.PluginRegistry<org.springframework.hateoas.client.LinkDiscoverer, org.springframework.http.MediaType>' available: expected single matching bean but found 3: relProviderPluginRegistry,linkDiscovererRegistry,entityLinksPluginRegistry
    at org.springframework.beans.factory.config.DependencyDescriptor.resolveNotUnique(DependencyDescriptor.java:220) ~[spring-beans-5.2.2.RELEASE.jar:5.2.2.RELEASE]
    at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1265) ~[spring-beans-5.2.2.RELEASE.jar:5.2.2.RELEASE]
    at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:1207) ~[spring-beans-5.2.2.RELEASE.jar:5.2.2.RELEASE]
    at org.springframework.beans.factory.support.ConstructorResolver.resolveAutowiredArgument(ConstructorResolver.java:885) ~[spring-beans-5.2.2.RELEASE.jar:5.2.2.RELEASE]
    at org.springframework.beans.factory.support.ConstructorResolver.createArgumentArray(ConstructorResolver.java:789) ~[spring-beans-5.2.2.RELEASE.jar:5.2.2.RELEASE]
    ... 83 common frames omitted
```

Then you need to include the following configuration into your pom.xml
```xml
    <properties>
        <spring-plugin.version>2.0.0.BUILD-SNAPSHOT</spring-plugin.version>
    </properties>
    <dependency>
        <groupId>org.springframework.plugin</groupId>
        <artifactId>spring-plugin-core</artifactId>
        <version>2.0.0.RELEASE</version>
    </dependency>
```

Then you will probably see NoSuchMethodException getPluginFor

Also you will need to create new classes and create primary beans to avoid this exception.
Please take a look at this GitHub repository:

https://github.com/eceolin/webflux-tips/tree/master/src/main/java/com/reactor/configuration/swagger