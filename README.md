[![CircleCI](https://circleci.com/gh/omidashouri/omid-pet-clinic.svg?style=svg)](https://circleci.com/gh/omidashouri/omid-pet-clinic)

# omid-pet-clinic

Omid Ashouri pet clinic

call me at 09126607350


--- --- --- --- --- --- ---
define remote SonarQube to maven:
--add in setting.xml maven
    <profiles>
        <profile>
            <id>sonar</id>
            <activation>
                <activeByDefault>true</activeByDefault>
            </activation>
                <properties>
                    <!-- optional URL to server. Default value is http://localhost:9000 -->
                    <sonar.host.url>
                        http://172.17.70.55:9000/
                    </sonar.host.url>
                    <!-- get this id from sonar web -->
					<sonar.login>54f3fda8b8eccc470b81c0015243e0115f9ac1bf</sonar.login>
                </properties>
        </profile>
    </profiles>
        
--- --- --- --- --- --- ---