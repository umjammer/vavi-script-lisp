[![Maven Package](https://github.com/umjammer/vavi-script-lisp/actions/workflows/maven-publish.yml/badge.svg)](https://github.com/umjammer/vavi-script-lisp/actions/workflows/maven-publish.yml)
[![Java CI with Maven](https://github.com/umjammer/vavi-script-lisp/workflows/Java%20CI%20with%20Maven/badge.svg)](https://github.com/umjammer/vavi-script-lisp/actions)
[![CodeQL](https://github.com/umjammer/vavi-script-lisp/actions/workflows/codeql-analysis.yml/badge.svg)](https://github.com/umjammer/vavi-script-lisp/actions/workflows/codeql-analysis.yml)
![Java](https://img.shields.io/badge/Java-8-b07219)

# Lisp interpreter

Those who use this package use the following classes.

  * `com.sun.script.lisp.LispInterpreter`
  * `com.sun.script.LispException`
  * `com.sun.script.lisp.MetaException`

Others can be built by using `*Exception` for exception handling
Application-specific exceptions can be nested and thrown with `vavi.apps.lisp.MetaException`.

## References

 * [isbn:0135657636 (SunSoft Java Series CD-ROM "Java by Example")](https://archive.org/details/javabyexample00jack)
 * [uncommon lisp](https://web.archive.org/web/19970409021851/http://www.go2net.com/internet/deep/)

## License

 * com.sun.script.lisp

   https://archive.org/details/javabyexample00jack

## TODO

 * apply BSF
 * ~~apply JSR 223~~

### ~~AppleScript~~ -> [vavi-script-apple](https://github.com/umjammer/vavi-script-apple)

 * ~~applescriptengine by rococoa for jdk6<~~
 * ~~apple script by jna (prevent deprecation after jdk8)~~
   * ~~https://github.com/mik3hall/AppleScriptEngine~~

### Hypercard

 * https://github.com/defano/wyldcard
 * https://github.com/pgostation/HyperZebra/
