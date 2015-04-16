# Necat
Necat is similar to the Nifty which is an implementation of Thrift client and server on Netty, but Necat is based on Netty 4.0. Necat is in pursuit of higher performance and easier use for developing distribute system, it will try to use UDT and Protocbuf to optimize the communication part of application.

# How to edit README.md file?
Please follow as: https://github.com/LearnShare/Learning-Markdown/blob/master/README.md

# how to create a mavne project quickly?
mvn archetype:generate -DgroupId=necat -DartifactId=necat-model -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

# how to push a maven project to remote github?
Please follow as: http://blog.sonatype.com/2009/09/maven-tips-and-tricks-using-github/#.VSAJS2CSw8o

If you want to add maven project to github repository, you can follow as:<br />
1, create a github repository on you github.<br />
2, change current directory into you maven project which you want to push to github.<br />
3, execute "maven clean" to clean the compiling files.<br />
3, execute "git init" to create local git repository.<br />
4, execute "git add . -A" to tell git the files that we want to push to github.<br />
5, execute "git commit -m <comments>" to add the files to local repository.<br />
6, execute "git remote add origin <github path>" to build the relationship between remote github and local github.<br />
7, execute "git push origin master" to push the files to remote github.<br />

# How to config maven module?
Please follow as: http://books.sonatype.com/mvnex-book/reference/multimodule-sect-simple-parent.html

