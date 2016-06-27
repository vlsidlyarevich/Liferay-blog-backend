### Java based backend part of angular2 rest client [rest client](https://github.com/solairerove/liferay-blog-client) as a part of [blog app](https://github.com/solairerove/blog-app)


##### Build `*.war` file: 

* `git clone *git`
* `cd project`
* `mvn clean install`

___

##### Build ubuntu:liferay [image](https://github.com/solairerove/docker/tree/master/ubuntu-liferay):

* `cd ubuntu-git/`
* `docker build -t name-of-image:tag-of-image .`
* `docker run -t -i -p 8080:8080 name-of-image:tag-of-image`
* `docker rename old-name new-nam`

or crash your host machine

___

##### Start liferay portal:

* `cd liferay/tomcat/bin`
* `./catalina.sh start`
* `cd liferay/tomcat/logs`
* `tail -f -n 100 ./catalina.out`
* `cp *.war /liferay/deploy`

___

##### Mems:

![alt tag](https://cloud.githubusercontent.com/assets/9396988/16380937/891aec50-3c82-11e6-94e4-7fe8060d11c8.png)
