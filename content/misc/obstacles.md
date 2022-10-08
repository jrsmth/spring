# Obstacles
*Lessons learnt along the way*

<br>

### Maven Release Plugin: failing on release:perform
* Error Message:
    * `Failed to execute goal org.apache.maven.plugins:maven-javadoc-plugin:3.4.1:jar (attach-javadocs): MavenReportException: Error while generating Javadoc:`
* Solution:
    * Turns out that whilst refactoring to a multi-module project, one of the paths was changed from `/`'s to `.`'s
        * `java/com.jrsmiffy.springguru.petclinic`
    * I fixed this to `java/com/jrsmiffy/springguru/petclinic` and the release started working
* Sources:
    * Stack Overflow [post](https://stackoverflow.com/questions/37958104/maven-javadoc-no-source-files-for-package)